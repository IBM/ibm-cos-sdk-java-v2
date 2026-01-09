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

package com.ibm.cos.v2.benchmark.apicall;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.TearDown;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import com.ibm.cos.v2.benchmark.utils.MockServer;
import com.ibm.cos.v2.core.async.AsyncRequestBody;
import com.ibm.cos.v2.core.async.AsyncResponseTransformer;
import com.ibm.cos.v2.core.client.builder.SdkClientBuilder;
import com.ibm.cos.v2.core.sync.RequestBody;
import com.ibm.cos.v2.http.apache.ApacheHttpClient;
import com.ibm.cos.v2.http.nio.netty.NettyNioAsyncHttpClient;
import com.ibm.cos.v2.metrics.MetricCollection;
import com.ibm.cos.v2.metrics.MetricPublisher;
import com.ibm.cos.v2.services.protocolrestjson.ProtocolRestJsonAsyncClient;
import com.ibm.cos.v2.services.protocolrestjson.ProtocolRestJsonAsyncClientBuilder;
import com.ibm.cos.v2.services.protocolrestjson.ProtocolRestJsonClient;
import com.ibm.cos.v2.services.protocolrestjson.ProtocolRestJsonClientBuilder;
import com.ibm.cos.v2.services.protocolrestjson.model.StreamingInputOperationRequest;
import com.ibm.cos.v2.services.protocolrestjson.model.StreamingOutputOperationRequest;

/**
 * Benchmarking comparing metrics-enabled versus metrics-disabled performance.
 */
@State(Scope.Benchmark)
@BenchmarkMode(Mode.Throughput)
public class MetricsEnabledBenchmark {
    private MockServer mockServer;
    private ProtocolRestJsonClient enabledMetricsSyncClient;
    private ProtocolRestJsonAsyncClient enabledMetricsAsyncClient;

    @Setup(Level.Trial)
    public void setup() throws Exception {
        mockServer = new MockServer();
        mockServer.start();
        enabledMetricsSyncClient = enableMetrics(syncClientBuilder()).build();
        enabledMetricsAsyncClient = enableMetrics(asyncClientBuilder()).build();
    }

    protected <T extends SdkClientBuilder<T, ?>> T enableMetrics(T syncClientBuilder) {
        return syncClientBuilder.overrideConfiguration(c -> c.addMetricPublisher(new EnabledPublisher()));
    }

    private ProtocolRestJsonClientBuilder syncClientBuilder() {
        return ProtocolRestJsonClient.builder()
                                     .endpointOverride(mockServer.getHttpUri())
                                     .httpClientBuilder(ApacheHttpClient.builder());
    }

    private ProtocolRestJsonAsyncClientBuilder asyncClientBuilder() {
        return ProtocolRestJsonAsyncClient.builder()
                                          .endpointOverride(mockServer.getHttpUri())
                                          .httpClientBuilder(NettyNioAsyncHttpClient.builder());
    }

    @TearDown(Level.Trial)
    public void tearDown() throws Exception {
        mockServer.stop();
        enabledMetricsSyncClient.close();
        enabledMetricsAsyncClient.close();
    }

    @Benchmark
    public void metricsEnabledSync() {
        enabledMetricsSyncClient.allTypes();
    }

    @Benchmark
    public void metricsEnabledAsync() {
        enabledMetricsAsyncClient.allTypes().join();
    }

    @Benchmark
    public void metricsEnabledSyncStreamingInput() {
        enabledMetricsSyncClient.streamingInputOperation(streamingInputRequest(), RequestBody.fromString(""));
    }

    @Benchmark
    public void metricsEnabledAsyncStreamingInput() {
        enabledMetricsAsyncClient.streamingInputOperation(streamingInputRequest(), AsyncRequestBody.fromString("")).join();
    }

    @Benchmark
    public void metricsEnabledSyncStreamingOutput() {
        enabledMetricsSyncClient.streamingOutputOperationAsBytes(streamingOutputRequest());
    }

    @Benchmark
    public void metricsEnabledAsyncStreamingOutput() {
        enabledMetricsAsyncClient.streamingOutputOperation(streamingOutputRequest(), AsyncResponseTransformer.toBytes()).join();
    }

    private StreamingInputOperationRequest streamingInputRequest() {
        return StreamingInputOperationRequest.builder().build();
    }

    private StreamingOutputOperationRequest streamingOutputRequest() {
        return StreamingOutputOperationRequest.builder().build();
    }

    public static void main(String... args) throws Exception {
        Options opt = new OptionsBuilder()
            .include(MetricsEnabledBenchmark.class.getSimpleName())
            .build();
        new Runner(opt).run();
    }

    private static final class EnabledPublisher implements MetricPublisher {
        @Override
        public void publish(MetricCollection metricCollection) {
        }

        @Override
        public void close() {
        }
    }
}
