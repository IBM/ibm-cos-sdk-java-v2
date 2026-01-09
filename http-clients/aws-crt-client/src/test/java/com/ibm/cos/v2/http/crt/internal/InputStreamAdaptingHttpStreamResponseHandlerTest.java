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

package com.ibm.cos.v2.http.crt.internal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.CompletableFuture;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Test;
import software.amazon.awssdk.crt.http.HttpHeader;
import software.amazon.awssdk.crt.http.HttpHeaderBlock;
import software.amazon.awssdk.crt.http.HttpStreamResponseHandler;
import com.ibm.cos.v2.http.AbortableInputStream;
import com.ibm.cos.v2.http.SdkHttpFullResponse;
import com.ibm.cos.v2.http.crt.internal.response.InputStreamAdaptingHttpStreamResponseHandler;
import com.ibm.cos.v2.utils.async.SimplePublisher;

public class InputStreamAdaptingHttpStreamResponseHandlerTest extends BaseHttpStreamResponseHandlerTest {

    @Override
    HttpStreamResponseHandler responseHandler() {
        return new InputStreamAdaptingHttpStreamResponseHandler(crtConn, requestFuture);
    }

    @Override
    HttpStreamResponseHandler responseHandlerWithMockedPublisher(SimplePublisher<ByteBuffer> simplePublisher) {
        return new InputStreamAdaptingHttpStreamResponseHandler(crtConn, requestFuture, simplePublisher);
    }

    @Test
    void abortStream_shouldShutDownConnection() throws IOException {
        HttpHeader[] httpHeaders = getHttpHeaders();

        responseHandler.onResponseHeaders(httpStream, 500, HttpHeaderBlock.MAIN.getValue(),
                                          httpHeaders);
        responseHandler.onResponseHeadersDone(httpStream, 0);
        responseHandler.onResponseBody(httpStream,
                                       RandomStringUtils.random(1 * 1024 * 1024).getBytes(StandardCharsets.UTF_8));

        SdkHttpFullResponse response = ((CompletableFuture<SdkHttpFullResponse>) requestFuture).join();
        assertThat(response.content()).isPresent();
        AbortableInputStream abortableInputStream = response.content().get();

        abortableInputStream.read();
        abortableInputStream.abort();

        verify(crtConn).shutdown();
        verify(crtConn).close();
        verify(httpStream).close();
    }

    @Test
    void closeStream_shouldShutdownConnection() throws IOException {
        HttpHeader[] httpHeaders = getHttpHeaders();

        responseHandler.onResponseHeaders(httpStream, 500, HttpHeaderBlock.MAIN.getValue(),
                                          httpHeaders);
        responseHandler.onResponseHeadersDone(httpStream, 0);
        responseHandler.onResponseBody(httpStream,
                                       RandomStringUtils.random(1 * 1024 * 1024).getBytes(StandardCharsets.UTF_8));

        SdkHttpFullResponse response = ((CompletableFuture<SdkHttpFullResponse>) requestFuture).join();
        assertThat(response.content()).isPresent();
        AbortableInputStream abortableInputStream = response.content().get();

        abortableInputStream.read();
        abortableInputStream.abort();

        verify(crtConn).shutdown();
        verify(crtConn).close();
        verify(httpStream).close();
    }

    @Test
    void cancelFuture_shouldCloseConnection() {
        HttpHeader[] httpHeaders = getHttpHeaders();

        responseHandler.onResponseHeaders(httpStream, 200, HttpHeaderBlock.MAIN.getValue(),
                                          httpHeaders);

        requestFuture.completeExceptionally(new RuntimeException());
        verify(crtConn).shutdown();
        verify(crtConn).close();
        verify(httpStream).close();
    }
}
