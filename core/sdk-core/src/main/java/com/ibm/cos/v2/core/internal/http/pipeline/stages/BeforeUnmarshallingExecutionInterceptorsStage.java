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

import com.ibm.cos.v2.annotations.SdkInternalApi;
import com.ibm.cos.v2.core.interceptor.ExecutionInterceptor;
import com.ibm.cos.v2.core.internal.http.InterruptMonitor;
import com.ibm.cos.v2.core.internal.http.RequestExecutionContext;
import com.ibm.cos.v2.core.internal.http.pipeline.RequestPipeline;
import com.ibm.cos.v2.http.SdkHttpFullRequest;
import com.ibm.cos.v2.http.SdkHttpFullResponse;
import com.ibm.cos.v2.http.SdkHttpResponse;
import com.ibm.cos.v2.utils.Pair;

/**
 * Invoke the {@link ExecutionInterceptor#beforeUnmarshalling} callback to allow for pre-processing on the {@link SdkHttpResponse}
 * before it is handed off to the unmarshaller.
 */
@SdkInternalApi
public class BeforeUnmarshallingExecutionInterceptorsStage
    implements RequestPipeline<Pair<SdkHttpFullRequest, SdkHttpFullResponse>, SdkHttpFullResponse> {

    @Override
    public SdkHttpFullResponse execute(Pair<SdkHttpFullRequest, SdkHttpFullResponse> input,
                                RequestExecutionContext context) throws Exception {
        context.interceptorChain().beforeUnmarshalling(context.executionContext().interceptorContext(),
                                                       context.executionAttributes());
        InterruptMonitor.checkInterrupted(input.right());
        return input.right();
    }
}
