package com.ibm.cos.v2.authcrt.signer.internal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static com.ibm.cos.v2.auth.signer.internal.Aws4SignerUtils.calculateRequestContentLength;
import static com.ibm.cos.v2.authcrt.signer.SignerTestUtils.extractSignatureFromAuthHeader;
import static com.ibm.cos.v2.authcrt.signer.SignerTestUtils.extractSignedHeadersFromAuthHeader;
import static com.ibm.cos.v2.http.Header.CONTENT_LENGTH;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.ibm.cos.v2.auth.signer.internal.chunkedencoding.AwsSignedChunkedEncodingInputStream;
import com.ibm.cos.v2.authcrt.signer.SignerTestUtils;
import com.ibm.cos.v2.authcrt.signer.SigningTestCase;
import com.ibm.cos.v2.authcrt.signer.internal.chunkedencoding.AwsS3V4aChunkSigner;
import com.ibm.cos.v2.core.interceptor.ExecutionAttributes;
import com.ibm.cos.v2.core.internal.chunked.AwsChunkedEncodingConfig;
import software.amazon.awssdk.crt.auth.signing.AwsSigningConfig;
import software.amazon.awssdk.crt.auth.signing.AwsSigningResult;
import com.ibm.cos.v2.http.SdkHttpFullRequest;

public class AwsCrt4aSigningAdapterTest {

    AwsCrt4aSigningAdapter crtSigningAdapter;
    SigningConfigProvider configProvider;

    @BeforeEach
    public void setup() {
        crtSigningAdapter = new AwsCrt4aSigningAdapter();
        configProvider = new SigningConfigProvider();
    }

    @Test
    public void signRequest_forHeader_works() {
        SigningTestCase testCase = SignerTestUtils.createBasicHeaderSigningTestCase();
        ExecutionAttributes executionAttributes = SignerTestUtils.buildBasicExecutionAttributes(testCase);
        SdkHttpFullRequest request = testCase.requestBuilder.build();

        AwsSigningConfig signingConfig = configProvider.createCrtSigningConfig(executionAttributes);
        SdkHttpFullRequest signed = crtSigningAdapter.signRequest(request, signingConfig);

        String signatureValue = extractSignatureFromAuthHeader(signed);

        assertTrue(SignerTestUtils.verifyEcdsaSignature(request, testCase.expectedCanonicalRequest, signingConfig, signatureValue));
    }

    @Test
    void sign_forHeader_works() {
        SigningTestCase testCase = SignerTestUtils.createBasicHeaderSigningTestCase();
        ExecutionAttributes executionAttributes = SignerTestUtils.buildBasicExecutionAttributes(testCase);
        SdkHttpFullRequest request = testCase.requestBuilder.build();

        AwsSigningConfig signingConfig = configProvider.createCrtSigningConfig(executionAttributes);
        SdkSigningResult signed = crtSigningAdapter.sign(request, signingConfig);

        SdkHttpFullRequest signedRequest = signed.getSignedRequest();
        String signatureValue = extractSignatureFromAuthHeader(signedRequest);

        assertTrue(SignerTestUtils.verifyEcdsaSignature(request, testCase.expectedCanonicalRequest, signingConfig, signatureValue));
    }

    @Test
    public void sign_forChunkedHeader_works() {
        SigningTestCase testCase = SignerTestUtils.createBasicChunkedSigningTestCase();
        ExecutionAttributes executionAttributes = SignerTestUtils.buildBasicExecutionAttributes(testCase);

        SdkHttpFullRequest.Builder requestBuilder = testCase.requestBuilder;
        long originalContentLength = calculateRequestContentLength(requestBuilder);
        requestBuilder.putHeader("x-amz-decoded-content-length", Long.toString(originalContentLength));
        requestBuilder.putHeader(CONTENT_LENGTH, Long.toString(AwsSignedChunkedEncodingInputStream.calculateStreamContentLength(
            originalContentLength, AwsS3V4aChunkSigner.getSignatureLength(), AwsChunkedEncodingConfig.create())));
        SdkHttpFullRequest request = requestBuilder.build();

        AwsSigningConfig signingConfig = configProvider.createS3CrtSigningConfig(executionAttributes);

        SdkSigningResult signingResult = crtSigningAdapter.sign(request, signingConfig);

        List<String> signedHeaders = extractSignedHeadersFromAuthHeader(signingResult.getSignedRequest());
        assertThat(signedHeaders.size()).isEqualTo(7);
        assertThat(signedHeaders).contains("x-amz-decoded-content-length", "content-length");

        byte[] data = new byte[10];
        Arrays.fill(data, (byte) 0x61);
        AwsSigningConfig chunkConfig = configProvider.createChunkedSigningConfig(executionAttributes);
        byte[] chunkSignature = crtSigningAdapter.signChunk(data, signingResult.getSignature(), chunkConfig);

        assertThat(chunkSignature.length).isEqualTo(144);
    }

    @Test
    void sign_forTrailerHeader_works() {

        SigningTestCase testCase = SignerTestUtils.createBasicChunkedSigningTestCase();
        ExecutionAttributes executionAttributes = SignerTestUtils.buildBasicExecutionAttributes(testCase);
        SdkHttpFullRequest.Builder requestBuilder = testCase.requestBuilder;
        long originalContentLength = calculateRequestContentLength(requestBuilder);
        requestBuilder.putHeader("x-amz-decoded-content-length", Long.toString(originalContentLength));
        requestBuilder.putHeader(CONTENT_LENGTH, Long.toString(AwsSignedChunkedEncodingInputStream.calculateStreamContentLength(
            originalContentLength, AwsS3V4aChunkSigner.getSignatureLength(), AwsChunkedEncodingConfig.create())));
        SdkHttpFullRequest request = requestBuilder.build();
        AwsSigningConfig signingConfig = configProvider.createS3CrtSigningConfig(executionAttributes);
        SdkSigningResult signingResult = crtSigningAdapter.sign(request, signingConfig);
        byte[] data = new byte[10];
        Arrays.fill(data, (byte) 0x61);
        AwsSigningConfig chunkConfig = configProvider.createChunkedSigningConfig(executionAttributes);
        byte[] previousSignature = crtSigningAdapter.signChunk(data, signingResult.getSignature(), chunkConfig);

        AwsSigningResult trailerHeadersSignature = crtSigningAdapter
            .signTrailerHeaders(Collections.singletonMap("x-amz-checksum-crc32", Collections.singletonList("check4c==")),
                                previousSignature, chunkConfig);
        assertThat(trailerHeadersSignature.getSignature()).hasSize(144);
    }

}