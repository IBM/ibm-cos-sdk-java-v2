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

import java.time.Duration;
import java.util.concurrent.CompletableFuture;
import com.ibm.cos.v2.annotations.SdkInternalApi;
import com.ibm.cos.v2.core.internal.http.RequestExecutionContext;
import com.ibm.cos.v2.core.internal.http.pipeline.RequestPipeline;
import com.ibm.cos.v2.core.internal.util.MetricUtils;
import com.ibm.cos.v2.core.metrics.CoreMetric;
import com.ibm.cos.v2.http.SdkHttpFullRequest;
import com.ibm.cos.v2.metrics.MetricCollector;
import com.ibm.cos.v2.utils.CompletableFutureUtils;

/**
 * Wrapper pipeline that tracks the {@link CoreMetric#API_CALL_DURATION} metric.
 */
@SdkInternalApi
public final class AsyncApiCallMetricCollectionStage<OutputT> implements RequestPipeline<SdkHttpFullRequest,
    CompletableFuture<OutputT>> {
    private final RequestPipeline<SdkHttpFullRequest, CompletableFuture<OutputT>> wrapped;

    public AsyncApiCallMetricCollectionStage(RequestPipeline<SdkHttpFullRequest, CompletableFuture<OutputT>> wrapped) {
        this.wrapped = wrapped;
    }

    @Override
    public CompletableFuture<OutputT> execute(SdkHttpFullRequest input, RequestExecutionContext context) throws Exception {
        MetricCollector metricCollector = context.executionContext().metricCollector();
        MetricUtils.collectServiceEndpointMetrics(metricCollector, input);

        CompletableFuture<OutputT> future = new CompletableFuture<>();

        long callStart = System.nanoTime();
        CompletableFuture<OutputT> executeFuture = wrapped.execute(input, context);

        executeFuture.whenComplete((r, t) -> {
            long duration = System.nanoTime() - callStart;
            metricCollector.reportMetric(CoreMetric.API_CALL_DURATION, Duration.ofNanos(duration));

            if (t != null) {
                future.completeExceptionally(t);
            } else {
                future.complete(r);
            }
        }).exceptionally(t -> {
            future.completeExceptionally(t);
            return null;
        });

        return CompletableFutureUtils.forwardExceptionTo(future, executeFuture);
    }
}
