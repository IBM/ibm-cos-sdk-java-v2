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

package com.ibm.cos.v2.core.internal.async;

import java.nio.ByteBuffer;
import java.util.concurrent.CompletableFuture;
import com.ibm.cos.v2.annotations.SdkInternalApi;
import com.ibm.cos.v2.core.SdkResponse;
import com.ibm.cos.v2.core.async.AsyncResponseTransformer;
import com.ibm.cos.v2.core.async.ResponsePublisher;
import com.ibm.cos.v2.core.async.SdkPublisher;

/**
 * Transforms a {@link ResponseT} and {@link ByteBuffer} {@link SdkPublisher} into a {@link ResponsePublisher}.
 *
 * @param <ResponseT> Pojo response type.
 * @see AsyncResponseTransformer#toPublisher()
 */
@SdkInternalApi
public final class PublisherAsyncResponseTransformer<ResponseT extends SdkResponse>
    implements AsyncResponseTransformer<ResponseT, ResponsePublisher<ResponseT>> {

    private volatile CompletableFuture<ResponsePublisher<ResponseT>> future;
    private volatile ResponseT response;

    @Override
    public CompletableFuture<ResponsePublisher<ResponseT>> prepare() {
        CompletableFuture<ResponsePublisher<ResponseT>> f = new CompletableFuture<>();
        this.future = f;
        return f;
    }

    @Override
    public void onResponse(ResponseT response) {
        this.response = response;
    }

    @Override
    public void onStream(SdkPublisher<ByteBuffer> publisher) {
        future.complete(new ResponsePublisher<>(response, publisher));
    }

    @Override
    public void exceptionOccurred(Throwable error) {
        future.completeExceptionally(error);
    }
}
