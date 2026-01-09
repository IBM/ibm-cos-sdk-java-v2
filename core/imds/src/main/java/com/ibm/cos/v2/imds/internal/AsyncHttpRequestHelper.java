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

package com.ibm.cos.v2.imds.internal;

import static com.ibm.cos.v2.imds.internal.BaseEc2MetadataClient.uncheckedInputStreamToUtf8;
import static com.ibm.cos.v2.imds.internal.RequestMarshaller.EC2_METADATA_TOKEN_TTL_HEADER;

import java.time.Duration;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;
import com.ibm.cos.v2.annotations.SdkInternalApi;
import com.ibm.cos.v2.core.SdkBytes;
import com.ibm.cos.v2.core.exception.RetryableException;
import com.ibm.cos.v2.core.exception.SdkClientException;
import com.ibm.cos.v2.core.http.HttpResponseHandler;
import com.ibm.cos.v2.core.interceptor.ExecutionAttributes;
import com.ibm.cos.v2.core.internal.http.TransformingAsyncResponseHandler;
import com.ibm.cos.v2.core.internal.http.async.AsyncResponseHandler;
import com.ibm.cos.v2.core.internal.http.async.SimpleHttpContentPublisher;
import com.ibm.cos.v2.http.AbortableInputStream;
import com.ibm.cos.v2.http.HttpStatusFamily;
import com.ibm.cos.v2.http.SdkHttpFullRequest;
import com.ibm.cos.v2.http.SdkHttpFullResponse;
import com.ibm.cos.v2.http.async.AsyncExecuteRequest;
import com.ibm.cos.v2.http.async.SdkAsyncHttpClient;
import com.ibm.cos.v2.http.async.SdkHttpContentPublisher;
import com.ibm.cos.v2.imds.Ec2MetadataClientException;
import com.ibm.cos.v2.utils.CompletableFutureUtils;

@SdkInternalApi
final class AsyncHttpRequestHelper {

    private AsyncHttpRequestHelper() {
        // static utility class
    }

    public static CompletableFuture<String> sendAsyncMetadataRequest(SdkAsyncHttpClient httpClient,
                                                                     SdkHttpFullRequest baseRequest,
                                                                     CompletableFuture<?> parentFuture) {
        return sendAsync(httpClient, baseRequest, AsyncHttpRequestHelper::handleResponse, parentFuture);
    }

    public static CompletableFuture<Token> sendAsyncTokenRequest(SdkAsyncHttpClient httpClient,
                                                                 SdkHttpFullRequest baseRequest) {
        return sendAsync(httpClient, baseRequest, AsyncHttpRequestHelper::handleTokenResponse, null);
    }

    private static <T> CompletableFuture<T> sendAsync(SdkAsyncHttpClient client,
                                                      SdkHttpFullRequest request,
                                                      HttpResponseHandler<T> handler,
                                                      CompletableFuture<?> parentFuture) {
        SdkHttpContentPublisher requestContentPublisher = new SimpleHttpContentPublisher(request);
        TransformingAsyncResponseHandler<T> responseHandler =
            new AsyncResponseHandler<>(handler, Function.identity(), new ExecutionAttributes());
        CompletableFuture<T> responseHandlerFuture = responseHandler.prepare();
        AsyncExecuteRequest metadataRequest = AsyncExecuteRequest.builder()
                                                                 .request(request)
                                                                 .requestContentPublisher(requestContentPublisher)
                                                                 .responseHandler(responseHandler)
                                                                 .build();
        CompletableFuture<Void> executeFuture = client.execute(metadataRequest);
        if (parentFuture != null) {
            CompletableFutureUtils.forwardExceptionTo(parentFuture, executeFuture);
            CompletableFutureUtils.forwardExceptionTo(parentFuture, responseHandlerFuture);
        }
        return responseHandlerFuture;
    }

    private static String handleResponse(SdkHttpFullResponse response, ExecutionAttributes executionAttributes) {
        HttpStatusFamily statusCode = HttpStatusFamily.of(response.statusCode());
        AbortableInputStream inputStream =
            response.content().orElseThrow(() -> SdkClientException.create("Unexpected error: empty response content"));
        String responseContent = uncheckedInputStreamToUtf8(inputStream);

        // retryable error
        if (statusCode.isOneOf(HttpStatusFamily.SERVER_ERROR)) {
            throw RetryableException.create(responseContent);
        }

        // non-retryable error
        if (!statusCode.isOneOf(HttpStatusFamily.SUCCESSFUL)) {
            throw Ec2MetadataClientException.builder()
                                            .statusCode(response.statusCode())
                                            .sdkHttpResponse(response)
                                            .rawResponse(SdkBytes.fromUtf8String(responseContent))
                                            .message(String.format("Failed to send request to IMDS. "
                                                                   + "Service returned %d error",
                                                                   response.statusCode()))
                                            .build();
        }
        return responseContent;
    }

    private static Token handleTokenResponse(SdkHttpFullResponse response, ExecutionAttributes executionAttributes) {
        String tokenValue = handleResponse(response, executionAttributes);
        Optional<String> ttl = response.firstMatchingHeader(EC2_METADATA_TOKEN_TTL_HEADER);

        if (!ttl.isPresent()) {
            throw SdkClientException.create(EC2_METADATA_TOKEN_TTL_HEADER + " header not found in token response");
        }
        try {
            Duration ttlDuration = Duration.ofSeconds(Long.parseLong(ttl.get()));
            return new Token(tokenValue, ttlDuration);
        } catch (NumberFormatException nfe) {
            throw SdkClientException.create(
                "Invalid token format received from IMDS server. Token received:  " + tokenValue, nfe);
        }
    }
}
