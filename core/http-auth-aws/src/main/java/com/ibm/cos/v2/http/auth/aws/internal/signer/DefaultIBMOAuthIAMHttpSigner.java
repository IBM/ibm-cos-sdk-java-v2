/*
 * Copyright 2017 IBM Corp. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */

package com.ibm.cos.v2.http.auth.aws.internal.signer;

import static com.ibm.cos.v2.http.auth.aws.internal.signer.util.ChecksumUtil.checksummer;
import static com.ibm.cos.v2.http.auth.aws.internal.signer.util.ChecksumUtil.hasChecksumHeader;
import static com.ibm.cos.v2.http.auth.aws.internal.signer.util.ChecksumUtil.isEventStreaming;
import static com.ibm.cos.v2.http.auth.aws.internal.signer.util.ChecksumUtil.isPayloadSigning;
import static com.ibm.cos.v2.http.auth.aws.internal.signer.util.ChecksumUtil.useChunkEncoding;
import static com.ibm.cos.v2.http.auth.aws.internal.signer.util.CredentialUtils.sanitizeCredentialsIAM;
import static com.ibm.cos.v2.http.auth.aws.internal.signer.util.OptionalDependencyLoaderUtil.getEventStreamV4PayloadSigner;
import static com.ibm.cos.v2.http.auth.aws.internal.signer.util.SignerConstant.X_AMZ_TRAILER;
import static com.ibm.cos.v2.http.auth.aws.signer.AwsV4FamilyHttpSigner.CHECKSUM_ALGORITHM;
import static com.ibm.cos.v2.http.auth.aws.signer.AwsV4FamilyHttpSigner.CHUNK_ENCODING_ENABLED;
import static com.ibm.cos.v2.http.auth.aws.signer.AwsV4FamilyHttpSigner.DOUBLE_URL_ENCODE;
import static com.ibm.cos.v2.http.auth.aws.signer.AwsV4FamilyHttpSigner.NORMALIZE_PATH;
import static com.ibm.cos.v2.http.auth.aws.signer.AwsV4FamilyHttpSigner.PAYLOAD_SIGNING_ENABLED;
import static com.ibm.cos.v2.http.auth.aws.signer.AwsV4FamilyHttpSigner.SERVICE_SIGNING_NAME;
import com.ibm.cos.v2.annotations.SdkInternalApi;
import com.ibm.cos.v2.http.ContentStreamProvider;
import com.ibm.cos.v2.http.SdkHttpRequest;
import com.ibm.cos.v2.http.auth.aws.signer.AwsV4HttpSigner;
import com.ibm.cos.v2.http.auth.aws.signer.IBMOAuthSigner;
import com.ibm.cos.v2.http.auth.spi.signer.AsyncSignRequest;
import com.ibm.cos.v2.http.auth.spi.signer.AsyncSignedRequest;
import com.ibm.cos.v2.http.auth.spi.signer.BaseSignRequest;
import com.ibm.cos.v2.http.auth.spi.signer.SignRequest;
import com.ibm.cos.v2.http.auth.spi.signer.SignedRequest;
import com.ibm.cos.v2.identity.spi.Identity;
import com.ibm.cos.v2.identity.spi.internal.IBMOAuthIdentity;
import com.ibm.cos.v2.utils.Logger;
import java.time.Clock;
import java.time.Instant;
import java.util.concurrent.CompletableFuture;

/** 
 * An implementation of a {@link IBMOAuthSigner} that uses properties to compose IAM-signers in order to delegate signing of a
 * request and payload (if applicable) accordingly.
 */
@SdkInternalApi
public final class DefaultIBMOAuthIAMHttpSigner implements IBMOAuthSigner {
    private static final int DEFAULT_CHUNK_SIZE_IN_BYTES = 128 * 1024;
    private static final Logger LOG = Logger.loggerFor(DefaultIBMOAuthIAMHttpSigner.class);

    @Override
    public SignedRequest sign(SignRequest<? extends IBMOAuthIdentity> request) {
        LOG.debug(() -> "Signing request with DefaultIBMOAuthIAMHttpSigner");
        Checksummer checksummer = checksummer(request, null);
        V4PayloadSigner payloadSigner = v4PayloadSigner(request);

        return doSign(request, checksummer, payloadSigner);
    }

    private static SignedRequest doSign(SignRequest<? extends Identity> request,
                                        Checksummer checksummer,
                                        V4PayloadSigner payloadSigner) {                                
        SdkHttpRequest.Builder requestBuilder = request.request().toBuilder();
        ContentStreamProvider requestPayload = request.payload().orElse(null);
        checksummer.checksum(requestPayload, requestBuilder);
        payloadSigner.beforeSigning(requestBuilder, requestPayload);

        IAMRequestSigner iamRequestSigner = new IAMRequestSigner();
        V4RequestSigningResult requestSigningResult = iamRequestSigner.sign(requestBuilder,
                                                                            (IBMOAuthIdentity) request.identity());

       ContentStreamProvider signedPayload = null;
        if (requestPayload != null) {
            signedPayload = payloadSigner.sign(requestPayload, requestSigningResult);
        }
        return SignedRequest.builder()
                            .request(requestSigningResult.getSignedRequest().build())
                            .payload(signedPayload)
                            .build();

    }

    @Override
    public CompletableFuture<AsyncSignedRequest> signAsync(AsyncSignRequest<? extends IBMOAuthIdentity> request) {
        LOG.debug(() -> "Signing async request with DefaultIBMOAuthIAMHttpSigner");
        Checksummer checksummer = asyncChecksummer(request);
        V4Properties v4Properties = iamProperties(request);
        IAMRequestSigner iamRequestSigner = new IAMRequestSigner();
        V4PayloadSigner payloadSigner = v4PayloadAsyncSigner(request, v4Properties);

        return doSign(request, checksummer, payloadSigner,iamRequestSigner);
    }

    private CompletableFuture<AsyncSignedRequest> doSign(AsyncSignRequest<? extends IBMOAuthIdentity> request,
                                                                Checksummer checksummer,
                                                                V4PayloadSigner payloadSigner,
                                                                IAMRequestSigner iamRequestSigner ) {

        SdkHttpRequest.Builder requestBuilder = request.request().toBuilder();

        return checksummer.checksum(request.payload().orElse(null), requestBuilder)
                          .thenApply(payload -> {
                              V4RequestSigningResult requestSigningResultFuture = iamRequestSigner.sign(requestBuilder, request.identity());
                              return AsyncSignedRequest.builder()
                                                       .request(requestSigningResultFuture.getSignedRequest().build())
                                                       .payload(payloadSigner.signAsync(payload, requestSigningResultFuture))
                                                       .build();
                          });
    }

    private static V4Properties iamProperties(BaseSignRequest<?, ? extends IBMOAuthIdentity> request) {
        Clock signingClock = request.requireProperty(SIGNING_CLOCK, Clock.systemUTC());

        IBMOAuthIdentity iamCredentials = sanitizeCredentialsIAM(request.identity());
        return V4Properties.builder()
                               .iamCredentials(iamCredentials)
                               .signingClock(signingClock)
                               .build();
    }



    /**
     * This is needed because of the pre-existing gap (pre-SRA) in behavior where we don't treat async + streaming + http +
     * unsigned-payload as signed-payload (fallback). We have to do some finagling of the payload-signing options before
     * calling the actual checksummer() method
     */
    private static Checksummer asyncChecksummer(BaseSignRequest<?, ? extends IBMOAuthIdentity> request) {
        boolean isHttp = !"https".equals(request.request().protocol());
        boolean isPayloadSigning = isPayloadSigning(request);
        boolean isChunkEncoding = request.requireProperty(CHUNK_ENCODING_ENABLED, false);
        boolean shouldTreatAsUnsigned = isHttp && isPayloadSigning && isChunkEncoding;

        // set the override to false if it should be treated as unsigned, otherwise, null should be passed so that the normal
        // check for payload signing is done.
        Boolean overridePayloadSigning = shouldTreatAsUnsigned ? false : null;

        return checksummer(request, overridePayloadSigning);
    }
    private static V4PayloadSigner v4PayloadSigner(
        SignRequest<? extends IBMOAuthIdentity> request) {

        boolean isPayloadSigning = isPayloadSigning(request);
        boolean isChunkEncoding = request.requireProperty(CHUNK_ENCODING_ENABLED, false);
        boolean isTrailing = request.request().firstMatchingHeader(X_AMZ_TRAILER).isPresent();
        boolean isFlexible = request.hasProperty(CHECKSUM_ALGORITHM) && !hasChecksumHeader(request);


        if (useChunkEncoding(isPayloadSigning, isChunkEncoding, isTrailing || isFlexible)) {
            return AwsChunkedV4PayloadSigner.builder()
                                            //credential scope is not used for signing request using IAM, it is only used for HMAC
                                            .credentialScope(new CredentialScope("dummy","dummy",Instant.now()))
                                            .chunkSize(DEFAULT_CHUNK_SIZE_IN_BYTES)
                                            .checksumAlgorithm(request.property(CHECKSUM_ALGORITHM))
                                            .build();
        }

        return V4PayloadSigner.create();
    }

    /**
     * Returns a payload signer for IBM IAM requests.
    */
    private static V4PayloadSigner v4PayloadAsyncSigner(
        AsyncSignRequest<? extends IBMOAuthIdentity> request,
        V4Properties properties) {

        boolean isPayloadSigning = request.requireProperty(PAYLOAD_SIGNING_ENABLED, true);
        boolean isEventStreaming = isEventStreaming(request.request());
        boolean isChunkEncoding = request.requireProperty(CHUNK_ENCODING_ENABLED, false);

        if (isEventStreaming) {
            if (isPayloadSigning) {
                return getEventStreamV4PayloadSigner(
                    properties.getCredentials(),
                    //credential scope is not used for signing request using IAM, it is only used for HMAC
                    new CredentialScope("dummy","dummy",Instant.now()),
                    properties.getSigningClock()
                );
            }
            throw new UnsupportedOperationException("Unsigned payload is not supported with event-streaming.");
        }

        if (isChunkEncoding && isPayloadSigning) {
            // TODO(sra-identity-and-auth): We need to implement aws-chunk content-encoding for async.
            //  For now, we basically have to treat this as an unsigned case because there are existing s3 use-cases for
            //  Unsigned-payload + HTTP. These requests SHOULD be signed-payload, but are not pre-SRA, hence the problem. This
            //  will be taken care of in HttpChecksumStage for now, so we shouldn't throw an unsupported exception here, we
            //  should just fall through to the default since it will already encoded by the time it gets here.
            return V4PayloadSigner.create();
        }

        return V4PayloadSigner.create();
    }
}


