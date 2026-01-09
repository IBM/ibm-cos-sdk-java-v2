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

import com.ibm.cos.v2.annotations.Immutable;
import com.ibm.cos.v2.annotations.SdkProtectedApi;
import com.ibm.cos.v2.annotations.ThreadSafe;
import com.ibm.cos.v2.awscore.internal.AwsExecutionContextBuilder;
import com.ibm.cos.v2.awscore.internal.client.config.AwsClientOptionValidation;
import com.ibm.cos.v2.core.SdkRequest;
import com.ibm.cos.v2.core.SdkResponse;
import com.ibm.cos.v2.core.client.config.SdkClientConfiguration;
import com.ibm.cos.v2.core.client.handler.ClientExecutionParams;
import com.ibm.cos.v2.core.client.handler.SdkSyncClientHandler;
import com.ibm.cos.v2.core.client.handler.SyncClientHandler;
import com.ibm.cos.v2.core.http.Crc32Validation;
import com.ibm.cos.v2.core.http.ExecutionContext;
import com.ibm.cos.v2.core.http.HttpResponseHandler;
import com.ibm.cos.v2.core.interceptor.ExecutionAttributes;
import com.ibm.cos.v2.core.sync.ResponseTransformer;
import com.ibm.cos.v2.http.SdkHttpFullResponse;

/**
 * Client handler for AWS SDK clients.
 */
@ThreadSafe
@Immutable
@SdkProtectedApi
public final class AwsSyncClientHandler extends SdkSyncClientHandler implements SyncClientHandler {

    public AwsSyncClientHandler(SdkClientConfiguration clientConfiguration) {
        super(clientConfiguration);
        AwsClientOptionValidation.validateSyncClientOptions(clientConfiguration);
    }

    @Override
    public <InputT extends SdkRequest, OutputT extends SdkResponse> OutputT execute(
        ClientExecutionParams<InputT, OutputT> executionParams) {
        ClientExecutionParams<InputT, OutputT> clientExecutionParams = addCrc32Validation(executionParams);
        return super.execute(clientExecutionParams);
    }

    @Override
    public <InputT extends SdkRequest, OutputT extends SdkResponse, ReturnT> ReturnT execute(
        ClientExecutionParams<InputT, OutputT> executionParams,
        ResponseTransformer<OutputT, ReturnT> responseTransformer) {
        return super.execute(executionParams, responseTransformer);
    }

    @Override
    protected <InputT extends SdkRequest, OutputT extends SdkResponse> ExecutionContext
        invokeInterceptorsAndCreateExecutionContext(ClientExecutionParams<InputT, OutputT> executionParams) {
        SdkClientConfiguration clientConfiguration = resolveRequestConfiguration(executionParams);
        return AwsExecutionContextBuilder.invokeInterceptorsAndCreateExecutionContext(executionParams, clientConfiguration);
    }

    private <InputT extends SdkRequest, OutputT> ClientExecutionParams<InputT, OutputT> addCrc32Validation(
        ClientExecutionParams<InputT, OutputT> executionParams) {
        if (executionParams.getCombinedResponseHandler() != null) {
            return executionParams.withCombinedResponseHandler(
                new Crc32ValidationResponseHandler<>(executionParams.getCombinedResponseHandler()));
        } else {
            return executionParams.withResponseHandler(
                new Crc32ValidationResponseHandler<>(executionParams.getResponseHandler()));
        }
    }

    /**
     * Decorate {@link HttpResponseHandler} to validate CRC32 if needed.
     */
    private class Crc32ValidationResponseHandler<T> implements HttpResponseHandler<T> {
        private final HttpResponseHandler<T> delegate;

        private Crc32ValidationResponseHandler(HttpResponseHandler<T> delegate) {
            this.delegate = delegate;
        }

        @Override
        public T handle(SdkHttpFullResponse response, ExecutionAttributes executionAttributes) throws Exception {
            return delegate.handle(Crc32Validation.validate(isCalculateCrc32FromCompressedData(), response), executionAttributes);
        }
    }
}
