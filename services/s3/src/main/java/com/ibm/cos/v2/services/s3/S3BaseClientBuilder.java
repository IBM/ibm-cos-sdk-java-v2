/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"). You may not use this file except in compliance with
 * the License. A copy of the License is located at
 * 
 * http://aws.amazon.com/apache2.0
 * 
 * or in the "license" file accompanying this file. This file is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR
 * CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions
 * and limitations under the License.
 */

package com.ibm.cos.v2.services.s3;

import java.util.function.Consumer;
import com.ibm.cos.v2.annotations.Generated;
import com.ibm.cos.v2.annotations.SdkPublicApi;
import com.ibm.cos.v2.awscore.client.builder.AwsClientBuilder;
import com.ibm.cos.v2.core.checksums.RequestChecksumCalculation;
import com.ibm.cos.v2.core.checksums.ResponseChecksumValidation;
import com.ibm.cos.v2.http.auth.aws.signer.RegionSet;
import com.ibm.cos.v2.services.s3.auth.scheme.S3AuthSchemeProvider;
import com.ibm.cos.v2.services.s3.endpoints.S3EndpointProvider;

/**
 * This includes configuration specific to Amazon S3 that is supported by both {@link S3ClientBuilder} and
 * {@link S3AsyncClientBuilder}.
 */
@Generated("com.ibm.cos.v2:codegen")
@SdkPublicApi
public interface S3BaseClientBuilder<B extends S3BaseClientBuilder<B, C>, C> extends AwsClientBuilder<B, C> {
    B serviceConfiguration(S3Configuration serviceConfiguration);

    default B serviceConfiguration(Consumer<S3Configuration.Builder> serviceConfiguration) {
        return serviceConfiguration(S3Configuration.builder().applyMutation(serviceConfiguration).build());
    }

    /**
     * Set the {@link S3EndpointProvider} implementation that will be used by the client to determine the endpoint for
     * each request. This is optional; if none is provided a default implementation will be used the SDK.
     */
    default B endpointProvider(S3EndpointProvider endpointProvider) {
        throw new UnsupportedOperationException();
    }

    /**
     * Set the {@link S3AuthSchemeProvider} implementation that will be used by the client to resolve the auth scheme
     * for each request. This is optional; if none is provided a default implementation will be used the SDK.
     */
    default B authSchemeProvider(S3AuthSchemeProvider authSchemeProvider) {
        throw new UnsupportedOperationException();
    }

    /**
     * Enables this client to use S3 Transfer Acceleration endpoints.
     */
    B accelerate(Boolean accelerate);

    /**
     * Disables this client's usage of Multi-Region Access Points.
     */
    B disableMultiRegionAccessPoints(Boolean disableMultiRegionAccessPoints);

    /**
     * Disables this client's usage of Session Auth for S3Express buckets and reverts to using conventional SigV4 for
     * those.
     */
    B disableS3ExpressSessionAuth(Boolean disableS3ExpressSessionAuth);

    /**
     * Forces this client to use path-style addressing for buckets.
     */
    B forcePathStyle(Boolean forcePathStyle);

    /**
     * Enables this client to use an ARN's region when constructing an endpoint instead of the client's configured
     * region.
     */
    B useArnRegion(Boolean useArnRegion);

    /**
     * Enables cross-region bucket access for this client
     */
    B crossRegionAccessEnabled(Boolean crossRegionAccessEnabled);

    /**
     * Configures the client behavior for request checksum calculation.
     */
    default B requestChecksumCalculation(RequestChecksumCalculation requestChecksumCalculation) {
        throw new UnsupportedOperationException();
    }

    /**
     * Configures the client behavior for response checksum validation.
     */
    default B responseChecksumValidation(ResponseChecksumValidation responseChecksumValidation) {
        throw new UnsupportedOperationException();
    }

    /**
     * Sets the {@link RegionSet} to be used for operations using Sigv4a signing requests. This is optional; if not
     * provided, the following precedence is used:
     * <ol>
     * <li>{@link com.ibm.cos.v2.core.SdkSystemSetting#AWS_SIGV4A_SIGNING_REGION_SET}.</li>
     * <li>as <code>sigv4a_signing_region_set</code> in the configuration file.</li>
     * <li>The region configured for the client.</li>
     * </ol>
     */
    default B sigv4aSigningRegionSet(RegionSet sigv4aSigningRegionSet) {
        throw new UnsupportedOperationException();
    }
}
