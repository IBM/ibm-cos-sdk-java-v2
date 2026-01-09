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

package com.ibm.cos.v2.stability.tests.transcribestreaming;

import java.io.InputStream;
import java.time.Duration;
import java.util.concurrent.CompletableFuture;
import java.util.function.IntFunction;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import com.ibm.cos.v2.core.async.SdkPublisher;
import com.ibm.cos.v2.http.Protocol;
import com.ibm.cos.v2.http.ProtocolNegotiation;
import com.ibm.cos.v2.http.nio.netty.NettyNioAsyncHttpClient;
import com.ibm.cos.v2.services.transcribestreaming.TranscribeStreamingAsyncClient;
import com.ibm.cos.v2.services.transcribestreaming.model.AudioStream;
import com.ibm.cos.v2.services.transcribestreaming.model.LanguageCode;
import com.ibm.cos.v2.services.transcribestreaming.model.MediaEncoding;
import com.ibm.cos.v2.services.transcribestreaming.model.StartStreamTranscriptionResponse;
import com.ibm.cos.v2.services.transcribestreaming.model.StartStreamTranscriptionResponseHandler;
import com.ibm.cos.v2.services.transcribestreaming.model.TranscriptEvent;
import com.ibm.cos.v2.services.transcribestreaming.model.TranscriptResultStream;
import com.ibm.cos.v2.stability.tests.exceptions.StabilityTestsRetryableException;
import com.ibm.cos.v2.testutils.retry.RetryableTest;
import com.ibm.cos.v2.stability.tests.utils.StabilityTestRunner;
import com.ibm.cos.v2.stability.tests.utils.TestEventStreamingResponseHandler;
import com.ibm.cos.v2.stability.tests.utils.TestTranscribeStreamingSubscription;
import com.ibm.cos.v2.testutils.service.AwsTestBase;
import com.ibm.cos.v2.utils.Logger;

public class TranscribeStreamingStabilityTest extends AwsTestBase {
    private static final Logger log = Logger.loggerFor(TranscribeStreamingStabilityTest.class.getSimpleName());
    public static final int CONCURRENCY = 2;
    public static final int TOTAL_RUNS = 1;
    private static TranscribeStreamingAsyncClient asyncClient;
    private static TranscribeStreamingAsyncClient asyncClientAlpn;
    private static InputStream audioFileInputStream;

    @BeforeAll
    public static void setup() {
        asyncClient = initClient(ProtocolNegotiation.ASSUME_PROTOCOL);
        asyncClientAlpn = initClient(ProtocolNegotiation.ALPN);

        audioFileInputStream = getInputStream();

        if (audioFileInputStream == null) {
            throw new RuntimeException("fail to get the audio input stream");
        }
    }

    private static TranscribeStreamingAsyncClient initClient(ProtocolNegotiation protocolNegotiation) {
        return TranscribeStreamingAsyncClient.builder()
                                             .credentialsProvider(CREDENTIALS_PROVIDER_CHAIN)
                                             .httpClientBuilder(NettyNioAsyncHttpClient.builder()
                                                                                       .connectionAcquisitionTimeout(Duration.ofSeconds(30))
                                                                                       .maxConcurrency(CONCURRENCY)
                                                                                       .protocol(Protocol.HTTP2)
                                                                                       .protocolNegotiation(protocolNegotiation))
                                             .build();
    }

    @AfterAll
    public static void tearDown() {
        asyncClient.close();
        asyncClientAlpn.close();
    }

    @RetryableTest(maxRetries = 3, retryableException = StabilityTestsRetryableException.class)
    public void startTranscription() {
        IntFunction<CompletableFuture<?>> futureIntFunction = i ->
            asyncClient.startStreamTranscription(b -> b.mediaSampleRateHertz(8_000)
                                                       .languageCode(LanguageCode.EN_US)
                                                       .mediaEncoding(MediaEncoding.PCM),
                                                 new AudioStreamPublisher(),
                                                 new TestStartStreamTranscriptionResponseHandler());
        StabilityTestRunner.newRunner()
                           .futureFactory(futureIntFunction)
                           .totalRuns(TOTAL_RUNS)
                           .requestCountPerRun(CONCURRENCY)
                           .testName("TranscribeStreamingStabilityTest.startTranscription")
                           .run();
    }

    @RetryableTest(maxRetries = 3, retryableException = StabilityTestsRetryableException.class)
    public void startTranscription_alpnEnabled() {
        IntFunction<CompletableFuture<?>> futureIntFunction = i ->
            asyncClientAlpn.startStreamTranscription(b -> b.mediaSampleRateHertz(8_000)
                                                           .languageCode(LanguageCode.EN_US)
                                                           .mediaEncoding(MediaEncoding.PCM),
                                                     new AudioStreamPublisher(),
                                                     new TestStartStreamTranscriptionResponseHandler());
        StabilityTestRunner.newRunner()
                           .futureFactory(futureIntFunction)
                           .totalRuns(TOTAL_RUNS)
                           .requestCountPerRun(CONCURRENCY)
                           .testName("TranscribeStreamingStabilityTest.startTranscription")
                           .run();
    }

    private static InputStream getInputStream() {
        return TranscribeStreamingStabilityTest.class.getResourceAsStream("silence_8kHz.wav");
    }

    private static class AudioStreamPublisher implements Publisher<AudioStream> {

        @Override
        public void subscribe(Subscriber<? super AudioStream> s) {
            s.onSubscribe(new TestTranscribeStreamingSubscription(s, audioFileInputStream));
        }
    }

    private static class TestStartStreamTranscriptionResponseHandler extends TestEventStreamingResponseHandler<StartStreamTranscriptionResponse, TranscriptResultStream>
        implements StartStreamTranscriptionResponseHandler {

        @Override
        public void onEventStream(SdkPublisher<TranscriptResultStream> publisher) {
            publisher
                .filter(TranscriptEvent.class)
                .subscribe(result -> log.debug(() -> "Record Batch - " + result.transcript().results()));
        }
    }
}
