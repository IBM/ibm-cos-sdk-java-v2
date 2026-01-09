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
import com.ibm.cos.v2.annotations.SdkInternalApi;
import com.ibm.cos.v2.core.Response;
import com.ibm.cos.v2.core.internal.http.RequestExecutionContext;
import com.ibm.cos.v2.core.internal.http.pipeline.RequestPipeline;
import com.ibm.cos.v2.core.internal.http.pipeline.RequestToResponsePipeline;
import com.ibm.cos.v2.core.internal.util.MetricUtils;
import com.ibm.cos.v2.core.metrics.CoreMetric;
import com.ibm.cos.v2.http.SdkHttpFullRequest;
import com.ibm.cos.v2.metrics.MetricCollector;

/**
 * Wrapper pipeline that tracks the {@link CoreMetric#API_CALL_DURATION} metric.
 */
@SdkInternalApi
public class ApiCallMetricCollectionStage<OutputT> implements RequestToResponsePipeline<OutputT> {
    private final RequestPipeline<SdkHttpFullRequest, Response<OutputT>>  wrapped;

    public ApiCallMetricCollectionStage(RequestPipeline<SdkHttpFullRequest, Response<OutputT>> wrapped) {
        this.wrapped = wrapped;
    }

    @Override
    public Response<OutputT> execute(SdkHttpFullRequest input, RequestExecutionContext context) throws Exception {
        MetricCollector metricCollector = context.executionContext().metricCollector();
        MetricUtils.collectServiceEndpointMetrics(metricCollector, input);

        // Note: at this point, any exception, even a service exception, will
        // be thrown from the wrapped pipeline so we can't use
        // MetricUtil.measureDuration()
        long callStart = System.nanoTime();
        try {
            return wrapped.execute(input, context);
        } finally {
            long d = System.nanoTime() - callStart;
            metricCollector.reportMetric(CoreMetric.API_CALL_DURATION, Duration.ofNanos(d));
        }
    }
}
