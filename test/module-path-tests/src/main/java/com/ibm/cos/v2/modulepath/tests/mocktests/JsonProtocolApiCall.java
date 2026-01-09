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

package com.ibm.cos.v2.modulepath.tests.mocktests;

import com.ibm.cos.v2.auth.credentials.AwsBasicCredentials;
import com.ibm.cos.v2.auth.credentials.StaticCredentialsProvider;
import com.ibm.cos.v2.regions.Region;
import com.ibm.cos.v2.services.protocolrestjson.ProtocolRestJsonAsyncClient;
import com.ibm.cos.v2.services.protocolrestjson.ProtocolRestJsonClient;

/**
 * Protocol tests for json protocol
 */
public class JsonProtocolApiCall extends BaseMockApiCall {

    private ProtocolRestJsonClient client;
    private ProtocolRestJsonAsyncClient asyncClient;

    public JsonProtocolApiCall() {
        super("json");
        this.client = ProtocolRestJsonClient.builder()
                                            .credentialsProvider(StaticCredentialsProvider.create(AwsBasicCredentials.create(
                                                "akid", "skid")))
                                            .region(Region.US_EAST_1)
                                            .httpClient(mockHttpClient)
                                            .build();
        this.asyncClient = ProtocolRestJsonAsyncClient.builder()
                                                      .credentialsProvider(
                                                          StaticCredentialsProvider.create(AwsBasicCredentials.create(
                                                          "akid", "skid")))
                                                      .region(Region.US_EAST_1)
                                                      .httpClient(mockAyncHttpClient)
                                                      .build();
    }

    @Override
    Runnable runnable() {
        return () -> client.allTypes();
    }

    @Override
    Runnable asyncRunnable() {
        return () -> asyncClient.allTypes().join();
    }

}
