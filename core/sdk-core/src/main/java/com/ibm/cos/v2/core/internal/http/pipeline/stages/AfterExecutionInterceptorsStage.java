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
import com.ibm.cos.v2.core.internal.http.RequestExecutionContext;
import com.ibm.cos.v2.core.internal.http.pipeline.RequestPipeline;

@SdkInternalApi
public class AfterExecutionInterceptorsStage<OutputT> implements RequestPipeline<OutputT, OutputT> {
    @Override
    public OutputT execute(OutputT input, RequestExecutionContext context) throws Exception {
        context.interceptorChain().afterExecution(context.executionContext().interceptorContext(),
                                                  context.executionAttributes());
        return input;
    }
}
