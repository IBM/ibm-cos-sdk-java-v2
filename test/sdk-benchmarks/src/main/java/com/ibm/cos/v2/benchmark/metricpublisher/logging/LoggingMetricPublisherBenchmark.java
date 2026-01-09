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

package com.ibm.cos.v2.benchmark.metricpublisher.logging;

import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.TearDown;
import com.ibm.cos.v2.benchmark.apicall.MetricsEnabledBenchmark;
import com.ibm.cos.v2.core.client.builder.SdkClientBuilder;
import com.ibm.cos.v2.metrics.LoggingMetricPublisher;

@State(Scope.Benchmark)
@BenchmarkMode(Mode.Throughput)
public class LoggingMetricPublisherBenchmark extends MetricsEnabledBenchmark {
    private LoggingMetricPublisher loggingMetricPublisher;

    @Override
    @Setup(Level.Trial)
    public void setup() throws Exception {
        loggingMetricPublisher = LoggingMetricPublisher.create();
        super.setup();
    }

    @Override
    protected <T extends SdkClientBuilder<T, ?>> T enableMetrics(T clientBuilder) {
        return clientBuilder.overrideConfiguration(c -> c.addMetricPublisher(loggingMetricPublisher));
    }

    @Override
    @TearDown(Level.Trial)
    public void tearDown() throws Exception {
        super.tearDown();
        loggingMetricPublisher.close();
    }
}
