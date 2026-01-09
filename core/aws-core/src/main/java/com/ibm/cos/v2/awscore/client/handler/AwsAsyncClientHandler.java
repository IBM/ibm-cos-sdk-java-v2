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

package com.ibm.cos.v2.awscore.client.handler;

import java.util.concurrent.CompletableFuture;
import com.ibm.cos.v2.annotations.Immutable;
import com.ibm.cos.v2.annotations.SdkProtectedApi;
import com.ibm.cos.v2.annotations.ThreadSafe;
import com.ibm.cos.v2.awscore.internal.AwsExecutionContextBuilder;
import com.ibm.cos.v2.awscore.internal.client.config.AwsClientOptionValidation;
import com.ibm.cos.v2.core.SdkRequest;
import com.ibm.cos.v2.core.SdkResponse;
import com.ibm.cos.v2.core.async.AsyncResponseTransformer;
import com.ibm.cos.v2.core.client.config.SdkClientConfiguration;
import com.ibm.cos.v2.core.client.handler.AsyncClientHandler;
import com.ibm.cos.v2.core.client.handler.ClientExecutionParams;
import com.ibm.cos.v2.core.client.handler.SdkAsyncClientHandler;
import com.ibm.cos.v2.core.http.ExecutionContext;

/**
 * Async client handler for AWS SDK clients.
 */
@ThreadSafe
@Immutable
@SdkProtectedApi
public final class AwsAsyncClientHandler extends SdkAsyncClientHandler implements AsyncClientHandler {

    public AwsAsyncClientHandler(SdkClientConfiguration clientConfiguration) {
        super(clientConfiguration);
        AwsClientOptionValidation.validateAsyncClientOptions(clientConfiguration);
    }

    @Override
    public <InputT extends SdkRequest, OutputT extends SdkResponse> CompletableFuture<OutputT> execute(
        ClientExecutionParams<InputT, OutputT> executionParams) {
        return super.execute(executionParams);
    }

    @Override
    public <InputT extends SdkRequest, OutputT extends SdkResponse, ReturnT> CompletableFuture<ReturnT> execute(
        ClientExecutionParams<InputT, OutputT> executionParams,
        AsyncResponseTransformer<OutputT, ReturnT> asyncResponseTransformer) {
        return super.execute(executionParams, asyncResponseTransformer);
    }

    @Override
    protected <InputT extends SdkRequest, OutputT extends SdkResponse> ExecutionContext
        invokeInterceptorsAndCreateExecutionContext(ClientExecutionParams<InputT, OutputT> executionParams) {
        SdkClientConfiguration clientConfiguration = resolveRequestConfiguration(executionParams);
        return AwsExecutionContextBuilder.invokeInterceptorsAndCreateExecutionContext(executionParams, clientConfiguration);
    }
}
