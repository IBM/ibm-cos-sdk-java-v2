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

package com.ibm.cos.v2.core.internal.http.pipeline.stages;

import static com.ibm.cos.v2.core.internal.http.pipeline.stages.utils.ExceptionReportingUtils.reportFailureToInterceptors;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;
import com.ibm.cos.v2.annotations.SdkInternalApi;
import com.ibm.cos.v2.core.internal.http.RequestExecutionContext;
import com.ibm.cos.v2.core.internal.http.pipeline.RequestPipeline;
import com.ibm.cos.v2.core.internal.util.ThrowableUtils;
import com.ibm.cos.v2.http.SdkHttpFullRequest;
import com.ibm.cos.v2.utils.CompletableFutureUtils;

@SdkInternalApi
public final class AsyncExecutionFailureExceptionReportingStage<OutputT>
    implements RequestPipeline<SdkHttpFullRequest, CompletableFuture<OutputT>> {

    private final RequestPipeline<SdkHttpFullRequest, CompletableFuture<OutputT>> wrapped;

    public AsyncExecutionFailureExceptionReportingStage(RequestPipeline<SdkHttpFullRequest, CompletableFuture<OutputT>> wrapped) {
        this.wrapped = wrapped;
    }

    @Override
    public CompletableFuture<OutputT> execute(SdkHttpFullRequest input, RequestExecutionContext context) throws Exception {
        CompletableFuture<OutputT> wrappedExecute = wrapped.execute(input, context);
        CompletableFuture<OutputT> executeFuture = wrappedExecute.handle((o, t) -> {
            if (t != null) {
                Throwable toReport = t;

                if (toReport instanceof CompletionException) {
                    toReport = toReport.getCause();
                }
                toReport = reportFailureToInterceptors(context, toReport);

                throw CompletableFutureUtils.errorAsCompletionException(ThrowableUtils.asSdkException(toReport));
            } else {
                return o;
            }
        });
        return CompletableFutureUtils.forwardExceptionTo(executeFuture, wrappedExecute);
    }


}
