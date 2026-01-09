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

import static com.ibm.cos.v2.http.Header.CONTENT_LENGTH;

import java.time.Duration;
import java.util.Optional;
import com.ibm.cos.v2.annotations.SdkInternalApi;
import com.ibm.cos.v2.core.client.config.SdkClientOption;
import com.ibm.cos.v2.core.interceptor.SdkInternalExecutionAttribute;
import com.ibm.cos.v2.core.internal.http.HttpClientDependencies;
import com.ibm.cos.v2.core.internal.http.InterruptMonitor;
import com.ibm.cos.v2.core.internal.http.RequestExecutionContext;
import com.ibm.cos.v2.core.internal.http.pipeline.RequestPipeline;
import com.ibm.cos.v2.core.internal.io.SdkLengthAwareInputStream;
import com.ibm.cos.v2.core.internal.util.MetricUtils;
import com.ibm.cos.v2.core.metrics.CoreMetric;
import com.ibm.cos.v2.http.ContentStreamProvider;
import com.ibm.cos.v2.http.ExecutableHttpRequest;
import com.ibm.cos.v2.http.HttpExecuteRequest;
import com.ibm.cos.v2.http.HttpExecuteResponse;
import com.ibm.cos.v2.http.SdkHttpClient;
import com.ibm.cos.v2.http.SdkHttpFullRequest;
import com.ibm.cos.v2.http.SdkHttpFullResponse;
import com.ibm.cos.v2.metrics.MetricCollector;
import com.ibm.cos.v2.utils.Logger;
import com.ibm.cos.v2.utils.Pair;

/**
 * Delegate to the HTTP implementation to make an HTTP request and receive the response.
 */
@SdkInternalApi
public class MakeHttpRequestStage
    implements RequestPipeline<SdkHttpFullRequest, Pair<SdkHttpFullRequest, SdkHttpFullResponse>> {
    private static final Logger LOG = Logger.loggerFor(MakeHttpRequestStage.class);

    private final SdkHttpClient sdkHttpClient;

    public MakeHttpRequestStage(HttpClientDependencies dependencies) {
        this.sdkHttpClient = dependencies.clientConfiguration().option(SdkClientOption.SYNC_HTTP_CLIENT);
    }

    /**
     * Returns the response from executing one httpClientSettings request; or null for retry.
     */
    @Override
    public Pair<SdkHttpFullRequest, SdkHttpFullResponse> execute(SdkHttpFullRequest request,
                                                                 RequestExecutionContext context) throws Exception {
        InterruptMonitor.checkInterrupted();
        HttpExecuteResponse executeResponse = executeHttpRequest(request, context);
        // TODO: Plumb through ExecuteResponse instead
        SdkHttpFullResponse httpResponse = (SdkHttpFullResponse) executeResponse.httpResponse();
        return Pair.of(request, httpResponse.toBuilder().content(executeResponse.responseBody().orElse(null)).build());
    }

    private HttpExecuteResponse executeHttpRequest(SdkHttpFullRequest request, RequestExecutionContext context) throws Exception {
        MetricCollector attemptMetricCollector = context.attemptMetricCollector();

        MetricCollector httpMetricCollector = MetricUtils.createHttpMetricsCollector(context);

        request = enforceContentLengthIfPresent(request);

        ExecutableHttpRequest requestCallable = sdkHttpClient
            .prepareRequest(HttpExecuteRequest.builder()
                                              .request(request)
                                              .metricCollector(httpMetricCollector)
                                              .contentStreamProvider(request.contentStreamProvider().orElse(null))
                                              .build());

        context.apiCallTimeoutTracker().abortable(requestCallable);
        context.apiCallAttemptTimeoutTracker().abortable(requestCallable);

        long start = updateMetricCollectionAttributes(context);
        Pair<HttpExecuteResponse, Duration> measuredExecute = MetricUtils.measureDurationUnsafe(requestCallable, start);
        Duration executeDuration = measuredExecute.right();
        attemptMetricCollector.reportMetric(CoreMetric.SERVICE_CALL_DURATION, executeDuration);

        attemptMetricCollector.reportMetric(CoreMetric.TIME_TO_FIRST_BYTE, executeDuration);

        context.executionAttributes().putAttribute(SdkInternalExecutionAttribute.HEADERS_READ_END_NANO_TIME,
                                                   start + executeDuration.toNanos());

        return measuredExecute.left();
    }

    private static long updateMetricCollectionAttributes(RequestExecutionContext context) {
        long now = System.nanoTime();
        context.executionAttributes().putAttribute(SdkInternalExecutionAttribute.API_CALL_ATTEMPT_START_NANO_TIME,
                                                   now);
        return now;
    }

    private static SdkHttpFullRequest enforceContentLengthIfPresent(SdkHttpFullRequest request) {
        Optional<ContentStreamProvider> requestContentStreamProviderOptional = request.contentStreamProvider();

        if (!requestContentStreamProviderOptional.isPresent()) {
            return request;
        }

        Optional<Long> contentLength = contentLength(request);
        if (!contentLength.isPresent()) {
            LOG.debug(() -> String.format("Request contains a body but does not have a Content-Length header. Not validating "
                                         + "the amount of data sent to the service: %s", request));
            return request;
        }

        ContentStreamProvider requestContentProvider = requestContentStreamProviderOptional.get();
        ContentStreamProvider lengthVerifyingProvider = () -> new SdkLengthAwareInputStream(requestContentProvider.newStream(),
                                                                                            contentLength.get());
        return request.toBuilder()
                      .contentStreamProvider(lengthVerifyingProvider)
                      .build();
    }

    private static Optional<Long> contentLength(SdkHttpFullRequest request) {
        Optional<String> contentLengthHeader = request.firstMatchingHeader(CONTENT_LENGTH);

        if (contentLengthHeader.isPresent()) {
            try {
                return Optional.of(Long.parseLong(contentLengthHeader.get()));
            } catch (NumberFormatException e) {
                LOG.warn(() -> "Unable to parse 'Content-Length' header. Treating it as non existent.");
            }
        }
        return Optional.empty();
    }
}
