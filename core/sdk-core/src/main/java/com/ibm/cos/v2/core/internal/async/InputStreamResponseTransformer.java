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
import com.ibm.cos.v2.core.ResponseInputStream;
import com.ibm.cos.v2.core.SdkResponse;
import com.ibm.cos.v2.core.async.AsyncResponseTransformer;
import com.ibm.cos.v2.core.async.SdkPublisher;
import com.ibm.cos.v2.http.async.AbortableInputStreamSubscriber;

/**
 * A {@link AsyncResponseTransformer} that allows performing blocking reads on the response data.
 * <p>
 * Created with {@link AsyncResponseTransformer#toBlockingInputStream()}.
 */
@SdkInternalApi
public class InputStreamResponseTransformer<ResponseT extends SdkResponse>
    implements AsyncResponseTransformer<ResponseT, ResponseInputStream<ResponseT>> {

    private volatile CompletableFuture<ResponseInputStream<ResponseT>> future;
    private volatile ResponseT response;

    @Override
    public CompletableFuture<ResponseInputStream<ResponseT>> prepare() {
        CompletableFuture<ResponseInputStream<ResponseT>> result = new CompletableFuture<>();
        this.future = result;
        return result;
    }

    @Override
    public void onResponse(ResponseT response) {
        this.response = response;
    }

    @Override
    public void onStream(SdkPublisher<ByteBuffer> publisher) {
        AbortableInputStreamSubscriber inputStreamSubscriber = AbortableInputStreamSubscriber.builder().build();
        publisher.subscribe(inputStreamSubscriber);
        future.complete(new ResponseInputStream<>(response, inputStreamSubscriber));
    }

    @Override
    public void exceptionOccurred(Throwable error) {
        future.completeExceptionally(error);
    }
}
