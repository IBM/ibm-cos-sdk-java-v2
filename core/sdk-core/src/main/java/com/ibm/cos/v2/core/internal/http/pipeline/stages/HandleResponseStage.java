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
import java.util.concurrent.atomic.AtomicLong;
import com.ibm.cos.v2.annotations.SdkInternalApi;
import com.ibm.cos.v2.core.Response;
import com.ibm.cos.v2.core.http.HttpResponseHandler;
import com.ibm.cos.v2.core.interceptor.SdkInternalExecutionAttribute;
import com.ibm.cos.v2.core.internal.http.RequestExecutionContext;
import com.ibm.cos.v2.core.internal.http.pipeline.RequestPipeline;
import com.ibm.cos.v2.core.internal.metrics.BytesReadTrackingInputStream;
import com.ibm.cos.v2.core.internal.util.MetricUtils;
import com.ibm.cos.v2.core.metrics.CoreMetric;
import com.ibm.cos.v2.http.AbortableInputStream;
import com.ibm.cos.v2.http.SdkHttpFullResponse;
import com.ibm.cos.v2.metrics.MetricCollector;

/**
 * Pipeline stage that executes an {@link HttpResponseHandler} to transform the response into a {@link Response}
 * object that contains a flag indicating success of failure and an unmarshalled response object or exception as
 * appropriate.
 */
@SdkInternalApi
public class HandleResponseStage<OutputT> implements RequestPipeline<SdkHttpFullResponse, Response<OutputT>> {
    private final HttpResponseHandler<Response<OutputT>> responseHandler;

    public HandleResponseStage(HttpResponseHandler<Response<OutputT>> responseHandler) {
        this.responseHandler = responseHandler;
    }

    @Override
    public Response<OutputT> execute(SdkHttpFullResponse httpResponse, RequestExecutionContext context) throws Exception {
        SdkHttpFullResponse bytesReadTracking = trackBytesRead(httpResponse, context);

        Response<OutputT> response = responseHandler.handle(bytesReadTracking, context.executionAttributes());

        collectMetrics(context);

        return response;
    }

    private void collectMetrics(RequestExecutionContext context) {
        MetricCollector attemptMetricCollector = context.attemptMetricCollector();

        long attemptStartTime = context.executionAttributes()
                                       .getAttribute(SdkInternalExecutionAttribute.API_CALL_ATTEMPT_START_NANO_TIME);

        long now = System.nanoTime();
        long ttlb = now - attemptStartTime;
        attemptMetricCollector.reportMetric(CoreMetric.TIME_TO_LAST_BYTE, Duration.ofNanos(ttlb));

        long responseBytesRead = MetricUtils.apiCallAttemptResponseBytesRead(context).getAsLong();
        long responseReadStart = MetricUtils.responseHeadersReadEndNanoTime(context).getAsLong();
        double throughput = MetricUtils.bytesPerSec(responseBytesRead, responseReadStart, now);

        attemptMetricCollector.reportMetric(CoreMetric.READ_THROUGHPUT, throughput);
    }

    private SdkHttpFullResponse trackBytesRead(SdkHttpFullResponse httpFullResponse, RequestExecutionContext context) {
        if (!httpFullResponse.content().isPresent()) {
            return httpFullResponse;
        }

        AbortableInputStream content = httpFullResponse.content().get();

        return httpFullResponse.toBuilder()
                               .content(trackBytesRead(content, context))
                               .build();
    }

    private AbortableInputStream trackBytesRead(AbortableInputStream content, RequestExecutionContext context) {
        AtomicLong bytesRead = context.executionAttributes().getAttribute(SdkInternalExecutionAttribute.RESPONSE_BYTES_READ);
        BytesReadTrackingInputStream bytesReadTrackedStream = new BytesReadTrackingInputStream(content, bytesRead);
        return AbortableInputStream.create(bytesReadTrackedStream);
    }
}
