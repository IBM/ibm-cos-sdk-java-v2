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

package com.ibm.cos.v2.awscore.client.utils;

import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.Executors;
import com.ibm.cos.v2.auth.credentials.DefaultCredentialsProvider;
import com.ibm.cos.v2.awscore.client.config.AwsClientOption;
import com.ibm.cos.v2.awscore.retry.AwsRetryStrategy;
import com.ibm.cos.v2.core.ClientEndpointProvider;
import com.ibm.cos.v2.core.client.config.SdkAdvancedAsyncClientOption;
import com.ibm.cos.v2.core.client.config.SdkAdvancedClientOption;
import com.ibm.cos.v2.core.client.config.SdkClientConfiguration;
import com.ibm.cos.v2.core.client.config.SdkClientOption;
import com.ibm.cos.v2.core.internal.http.AmazonSyncHttpClient;
import com.ibm.cos.v2.core.internal.http.loader.DefaultSdkHttpClientBuilder;
import com.ibm.cos.v2.core.signer.NoOpSigner;
import com.ibm.cos.v2.http.SdkHttpClient;
import com.ibm.cos.v2.http.SdkHttpConfigurationOption;
import com.ibm.cos.v2.utils.AttributeMap;

public class HttpTestUtils {
    public static SdkHttpClient testSdkHttpClient() {
        return new DefaultSdkHttpClientBuilder().buildWithDefaults(
                AttributeMap.empty().merge(SdkHttpConfigurationOption.GLOBAL_HTTP_DEFAULTS));
    }

    public static AmazonSyncHttpClient testAmazonHttpClient() {
        return testClientBuilder().httpClient(testSdkHttpClient()).build();
    }

    public static TestClientBuilder testClientBuilder() {
        return new TestClientBuilder();
    }

    public static SdkClientConfiguration testClientConfiguration() {
        return SdkClientConfiguration.builder()
                                     .option(SdkClientOption.EXECUTION_INTERCEPTORS, new ArrayList<>())
                                     .option(SdkClientOption.CLIENT_ENDPOINT_PROVIDER,
                                             ClientEndpointProvider.forEndpointOverride(URI.create("http://localhost:8080")))
                                     .option(SdkClientOption.RETRY_STRATEGY, AwsRetryStrategy.defaultRetryStrategy())
                                     .option(SdkClientOption.ADDITIONAL_HTTP_HEADERS, new HashMap<>())
                                     .option(SdkClientOption.CRC32_FROM_COMPRESSED_DATA_ENABLED, false)
                                     .option(AwsClientOption.CREDENTIALS_IDENTITY_PROVIDER, DefaultCredentialsProvider.create())
                                     .option(SdkAdvancedClientOption.SIGNER, new NoOpSigner())
                                     .option(SdkAdvancedClientOption.USER_AGENT_PREFIX, "")
                                     .option(SdkAdvancedClientOption.USER_AGENT_SUFFIX, "")
                                     .option(SdkAdvancedAsyncClientOption.FUTURE_COMPLETION_EXECUTOR, Runnable::run)
                                     .option(SdkClientOption.SCHEDULED_EXECUTOR_SERVICE, Executors.newScheduledThreadPool(1))
                                     .build();
    }

    public static class TestClientBuilder {
        private SdkHttpClient httpClient;

        public TestClientBuilder httpClient(SdkHttpClient sdkHttpClient) {
            this.httpClient = sdkHttpClient;
            return this;
        }

        public AmazonSyncHttpClient build() {
            SdkHttpClient sdkHttpClient = this.httpClient != null ? this.httpClient : testSdkHttpClient();
            return new AmazonSyncHttpClient(testClientConfiguration().toBuilder()
                                                                     .option(SdkClientOption.SYNC_HTTP_CLIENT, sdkHttpClient)
                                                                     .build());
        }
    }
}
