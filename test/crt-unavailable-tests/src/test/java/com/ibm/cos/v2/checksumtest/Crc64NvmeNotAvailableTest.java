/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License").
 * You may not use this file except in compliance with the License.
 * A copy of the License is located at
 *
 *  http://aws.amazon.com/apache2.0
 *
 * or in the "license" file accompanying this file. This file is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */

package com.ibm.cos.v2.checksumtest;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static com.ibm.cos.v2.auth.signer.S3SignerExecutionAttribute.ENABLE_CHUNKED_ENCODING;

import io.reactivex.Flowable;
import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import com.ibm.cos.v2.auth.credentials.AnonymousCredentialsProvider;
import com.ibm.cos.v2.core.SdkRequest;
import com.ibm.cos.v2.core.async.AsyncResponseTransformer;
import com.ibm.cos.v2.core.checksums.ChecksumValidation;
import com.ibm.cos.v2.core.interceptor.Context;
import com.ibm.cos.v2.core.interceptor.ExecutionAttributes;
import com.ibm.cos.v2.core.interceptor.ExecutionInterceptor;
import com.ibm.cos.v2.core.interceptor.SdkExecutionAttribute;
import com.ibm.cos.v2.core.sync.ResponseTransformer;
import com.ibm.cos.v2.http.ExecutableHttpRequest;
import com.ibm.cos.v2.http.HttpExecuteResponse;
import com.ibm.cos.v2.http.SdkHttpClient;
import com.ibm.cos.v2.http.SdkHttpFullResponse;
import com.ibm.cos.v2.http.async.AsyncExecuteRequest;
import com.ibm.cos.v2.http.async.SdkAsyncHttpClient;
import com.ibm.cos.v2.regions.Region;
import com.ibm.cos.v2.services.protocolrestjson.ProtocolRestJsonAsyncClient;
import com.ibm.cos.v2.services.protocolrestjson.ProtocolRestJsonAsyncClientBuilder;
import com.ibm.cos.v2.services.protocolrestjson.ProtocolRestJsonClient;
import com.ibm.cos.v2.services.protocolrestjson.ProtocolRestJsonClientBuilder;
import com.ibm.cos.v2.services.protocolrestjson.model.ChecksumAlgorithm;
import com.ibm.cos.v2.services.protocolrestjson.model.ChecksumMode;
import com.ibm.cos.v2.services.protocolrestjson.model.OperationWithCustomRequestChecksumRequest;
import com.ibm.cos.v2.services.protocolrestjson.model.PutOperationWithChecksumRequest;

public class Crc64NvmeNotAvailableTest {
    private SdkHttpClient httpClient;
    private SdkAsyncHttpClient httpAsyncClient;
    private ProtocolRestJsonAsyncClient asyncClient;
    private ProtocolRestJsonClient client;

    @BeforeEach
    public void setup() throws IOException {
        httpClient = Mockito.mock(SdkHttpClient.class);
        httpAsyncClient = Mockito.mock(SdkAsyncHttpClient.class);
        client = initializeSync().build();
        asyncClient = initializeAsync().build();
    }

    private void stubResponse(SdkHttpFullResponse.Builder responseBuilder) throws IOException {
        SdkHttpFullResponse successfulHttpResponse = responseBuilder
            .statusCode(200)
            .putHeader("Content-Length", "0")
            .build();

        ExecutableHttpRequest request = Mockito.mock(ExecutableHttpRequest.class);
        Mockito.when(request.call()).thenReturn(HttpExecuteResponse.builder()
                                                                   .response(successfulHttpResponse)
                                                                   .build());
        Mockito.when(httpClient.prepareRequest(any())).thenReturn(request);

        Mockito.when(httpAsyncClient.execute(any())).thenAnswer(invocation -> {
            AsyncExecuteRequest asyncExecuteRequest = invocation.getArgument(0, AsyncExecuteRequest.class);
            asyncExecuteRequest.responseHandler().onHeaders(successfulHttpResponse);
            asyncExecuteRequest.responseHandler().onStream(Flowable.empty());
            return CompletableFuture.completedFuture(null);
        });
    }

    private ProtocolRestJsonAsyncClientBuilder initializeAsync() {
        return ProtocolRestJsonAsyncClient.builder().httpClient(httpAsyncClient)
                                          .credentialsProvider(AnonymousCredentialsProvider.create())
                                          .overrideConfiguration(
                                              // TODO(sra-identity-and-auth): we should remove these
                                              //  overrides once we set up codegen to set chunk-encoding to true
                                              //  for requests that are streaming and checksum-enabled
                                              o -> o.addExecutionInterceptor(new EnableChunkedEncodingInterceptor())
                                                    .addExecutionInterceptor(new CaptureChecksumValidationInterceptor()))
                                          .region(Region.US_WEST_2);
    }

    private ProtocolRestJsonClientBuilder initializeSync() {
        return ProtocolRestJsonClient.builder().httpClient(httpClient)
                                     .credentialsProvider(AnonymousCredentialsProvider.create())
                                     .overrideConfiguration(
                                         //     // TODO(sra-identity-and-auth): we should remove these
                                         //     //  overrides once we set up codegen to set chunk-encoding to true
                                         //     //  for requests that are streaming and checksum-enabled
                                         o -> o.addExecutionInterceptor(new EnableChunkedEncodingInterceptor())
                                               .addExecutionInterceptor(new CaptureChecksumValidationInterceptor()))
                                     .region(Region.US_WEST_2);
    }

    @Test
    public void asyncChecksumCalculation_crc64NvmeNotAvailable_shouldThrowException() throws IOException {
        stubResponse(SdkHttpFullResponse.builder());
        assertThatThrownBy(() -> asyncClient.operationWithCustomRequestChecksum(
            OperationWithCustomRequestChecksumRequest.builder()
                                                     .checksumAlgorithm(ChecksumAlgorithm.CRC64_NVME)
                                                     .build()).join()).hasMessageContaining("Add dependency on "
                                                                                            + "'com.ibm.cos.v2"
                                                                                            + ".crt:aws-crt' module to "
                                                                                            + "enable CRC64NVME feature");
    }

    @Test
    public void syncChecksumCalculation_crc64NvmeNotAvailable_shouldThrowException() throws IOException {
        stubResponse(SdkHttpFullResponse.builder());
        assertThatThrownBy(() -> client.operationWithCustomRequestChecksum(
            OperationWithCustomRequestChecksumRequest.builder()
                                                     .checksumAlgorithm(ChecksumAlgorithm.CRC64_NVME)
                                                     .build())).hasMessageContaining("Add dependency on "
                                                                                     + "'com.ibm.cos.v2"
                                                                                     + ".crt:aws-crt' module to "
                                                                                     + "enable CRC64NVME feature");
    }

    @Test
    public void syncChecksumValidation_onlyHasCrc64Nvme_shouldSkipValidation() throws IOException {
        stubResponse(SdkHttpFullResponse.builder().putHeader("x-amz-checksum-crc64nvme", "foobar"));

        client.getOperationWithChecksum(
            r -> r.checksumMode(ChecksumMode.ENABLED),
            ResponseTransformer.toBytes());

        assertThat(CaptureChecksumValidationInterceptor.checksumValidation).isEqualTo(ChecksumValidation.CHECKSUM_ALGORITHM_NOT_FOUND);
        assertThat(CaptureChecksumValidationInterceptor.expectedAlgorithm).isNull();
    }

    @Test
    public void asyncChecksumValidation_onlyHasCrc64Nvme_shouldSkipValidation() throws IOException {
        stubResponse(SdkHttpFullResponse.builder().putHeader("x-amz-checksum-crc64nvme", "foobar"));

        asyncClient.getOperationWithChecksum(
            r -> r.checksumMode(ChecksumMode.ENABLED),
            AsyncResponseTransformer.toBytes()).join();

        assertThat(CaptureChecksumValidationInterceptor.checksumValidation).isEqualTo(ChecksumValidation.CHECKSUM_ALGORITHM_NOT_FOUND);
        assertThat(CaptureChecksumValidationInterceptor.expectedAlgorithm).isNull();
    }


    private static final class EnableChunkedEncodingInterceptor implements ExecutionInterceptor {
        public void beforeExecution(Context.BeforeExecution context, ExecutionAttributes executionAttributes) {
            SdkRequest request = context.request();

            if (request instanceof PutOperationWithChecksumRequest) {
                executionAttributes.putAttributeIfAbsent(ENABLE_CHUNKED_ENCODING, true);
            }
        }
    }

    private static class CaptureChecksumValidationInterceptor implements ExecutionInterceptor {
        private static com.ibm.cos.v2.checksums.spi.ChecksumAlgorithm expectedAlgorithm;
        private static ChecksumValidation checksumValidation;

        public static void reset() {
            expectedAlgorithm = null;
            checksumValidation = null;
        }

        @Override
        public void afterExecution(Context.AfterExecution context, ExecutionAttributes executionAttributes) {
            expectedAlgorithm =
                executionAttributes.getOptionalAttribute(SdkExecutionAttribute.HTTP_CHECKSUM_VALIDATION_ALGORITHM_V2).orElse(null);
            checksumValidation =
                executionAttributes.getOptionalAttribute(SdkExecutionAttribute.HTTP_RESPONSE_CHECKSUM_VALIDATION).orElse(null);
        }
    }
}
