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

package com.ibm.cos.v2.benchmark.apicall.httpclient.async;

import static com.ibm.cos.v2.benchmark.utils.BenchmarkConstant.CONCURRENT_CALLS;
import static com.ibm.cos.v2.benchmark.utils.BenchmarkUtils.awaitCountdownLatchUninterruptibly;
import static com.ibm.cos.v2.benchmark.utils.BenchmarkUtils.countDownUponCompletion;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.OperationsPerInvocation;
import org.openjdk.jmh.infra.Blackhole;
import com.ibm.cos.v2.benchmark.apicall.httpclient.SdkHttpClientBenchmark;
import com.ibm.cos.v2.services.protocolrestjson.ProtocolRestJsonAsyncClient;

/**
 * Base class for netty benchmark
 */
public abstract class BaseNettyBenchmark implements SdkHttpClientBenchmark {

    protected ProtocolRestJsonAsyncClient client;

    @Override
    @Benchmark
    @OperationsPerInvocation(CONCURRENT_CALLS)
    public void concurrentApiCall(Blackhole blackhole) {
        CountDownLatch countDownLatch = new CountDownLatch(CONCURRENT_CALLS);
        for (int i = 0; i < CONCURRENT_CALLS; i++) {
            countDownUponCompletion(blackhole, client.allTypes(), countDownLatch);
        }

        awaitCountdownLatchUninterruptibly(countDownLatch, 10, TimeUnit.SECONDS);
    }

    @Override
    @Benchmark
    public void sequentialApiCall(Blackhole blackhole) {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        countDownUponCompletion(blackhole, client.allTypes(), countDownLatch);
        awaitCountdownLatchUninterruptibly(countDownLatch, 1, TimeUnit.SECONDS);
    }
}
