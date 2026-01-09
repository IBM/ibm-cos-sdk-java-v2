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

package com.ibm.cos.v2.core.client.handler;

import com.ibm.cos.v2.annotations.Immutable;
import com.ibm.cos.v2.annotations.SdkProtectedApi;
import com.ibm.cos.v2.annotations.ThreadSafe;
import com.ibm.cos.v2.core.SdkRequest;
import com.ibm.cos.v2.core.SdkResponse;
import com.ibm.cos.v2.core.client.config.SdkClientConfiguration;
import com.ibm.cos.v2.core.client.config.SdkClientOptionValidation;
import com.ibm.cos.v2.core.internal.handler.BaseSyncClientHandler;
import com.ibm.cos.v2.core.internal.http.AmazonSyncHttpClient;
import com.ibm.cos.v2.core.sync.ResponseTransformer;

/**
 * Client handler for SDK clients.
 */
@ThreadSafe
@Immutable
@SdkProtectedApi
public class SdkSyncClientHandler extends BaseSyncClientHandler implements SyncClientHandler {

    protected SdkSyncClientHandler(SdkClientConfiguration clientConfiguration) {
        super(clientConfiguration, new AmazonSyncHttpClient(clientConfiguration));
        SdkClientOptionValidation.validateSyncClientOptions(clientConfiguration);
    }

    @Override
    public <InputT extends SdkRequest, OutputT extends SdkResponse> OutputT execute(
        ClientExecutionParams<InputT, OutputT> executionParams) {
        return super.execute(executionParams);
    }

    @Override
    public <InputT extends SdkRequest, OutputT extends SdkResponse, ReturnT> ReturnT execute(
        ClientExecutionParams<InputT, OutputT> executionParams,
        ResponseTransformer<OutputT, ReturnT> responseTransformer) {
        return super.execute(executionParams, responseTransformer);
    }

}
