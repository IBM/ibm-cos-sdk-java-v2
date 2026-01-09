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

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Optional;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.reactivestreams.Subscriber;
import com.ibm.cos.v2.annotations.SdkInternalApi;
import com.ibm.cos.v2.annotations.SdkTestInternalApi;
import com.ibm.cos.v2.core.async.AsyncRequestBody;
import com.ibm.cos.v2.core.async.AsyncRequestBodyFromInputStreamConfiguration;
import com.ibm.cos.v2.core.async.BlockingInputStreamAsyncRequestBody;
import com.ibm.cos.v2.core.exception.NonRetryableException;
import com.ibm.cos.v2.core.internal.util.NoopSubscription;
import com.ibm.cos.v2.utils.IoUtils;
import com.ibm.cos.v2.utils.Logger;

/**
 * A {@link AsyncRequestBody} that allows reading data off of an {@link InputStream} using a background
 * {@link ExecutorService}.
 * <p>
 * Created via {@link AsyncRequestBody#fromInputStream(InputStream, Long, ExecutorService)}.
 */
@SdkInternalApi
public class InputStreamWithExecutorAsyncRequestBody implements AsyncRequestBody {
    private static final Logger log = Logger.loggerFor(InputStreamWithExecutorAsyncRequestBody.class);

    private final Object subscribeLock = new Object();
    private final InputStream inputStream;
    private final Long contentLength;
    private final ExecutorService executor;

    private Future<?> writeFuture;

    public InputStreamWithExecutorAsyncRequestBody(AsyncRequestBodyFromInputStreamConfiguration configuration) {
        this.inputStream = configuration.inputStream();
        this.contentLength = configuration.contentLength();
        this.executor = configuration.executor();
        IoUtils.markStreamWithMaxReadLimit(inputStream, configuration.maxReadLimit());
    }

    @Override
    public Optional<Long> contentLength() {
        return Optional.ofNullable(contentLength);
    }

    @Override
    public void subscribe(Subscriber<? super ByteBuffer> s) {
        // Each subscribe cancels the previous subscribe.
        synchronized (subscribeLock) {
            try {
                if (writeFuture != null) {
                    writeFuture.cancel(true);
                    waitForCancellation(writeFuture); // Wait for the cancellation
                    tryReset(inputStream);
                }

                BlockingInputStreamAsyncRequestBody delegate = AsyncRequestBody.forBlockingInputStream(contentLength);
                writeFuture = executor.submit(() -> doBlockingWrite(delegate));
                delegate.subscribe(s);
            } catch (Throwable t) {
                s.onSubscribe(new NoopSubscription(s));
                s.onError(t);
            }
        }
    }

    private void tryReset(InputStream inputStream) {
        try {
            inputStream.reset();
        } catch (IOException e) {
            String message = "Request cannot be retried, because the request stream could not be reset.";
            throw NonRetryableException.create(message, e);
        }
    }

    @SdkTestInternalApi
    public Future<?> activeWriteFuture() {
        synchronized (subscribeLock) {
            return writeFuture;
        }
    }

    private void doBlockingWrite(BlockingInputStreamAsyncRequestBody asyncRequestBody) {
        try {
            asyncRequestBody.writeInputStream(inputStream);
        } catch (Throwable t) {
            log.debug(() -> "Encountered error while writing input stream to service.", t);
            throw t;
        }
    }

    private void waitForCancellation(Future<?> writeFuture) {
        try {
            writeFuture.get(10, TimeUnit.SECONDS);
        } catch (ExecutionException | CancellationException e) {
            // Expected - we cancelled.
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        } catch (TimeoutException e) {
            throw new IllegalStateException("Timed out waiting to reset the input stream.", e);
        }
    }
}
