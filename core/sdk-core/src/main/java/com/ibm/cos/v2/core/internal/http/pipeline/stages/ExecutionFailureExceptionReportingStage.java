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

import static com.ibm.cos.v2.core.internal.http.pipeline.stages.utils.ExceptionReportingUtils.reportFailureToInterceptors;
import static com.ibm.cos.v2.core.internal.util.ThrowableUtils.failure;

import com.ibm.cos.v2.annotations.SdkInternalApi;
import com.ibm.cos.v2.core.internal.http.RequestExecutionContext;
import com.ibm.cos.v2.core.internal.http.pipeline.RequestPipeline;
import com.ibm.cos.v2.http.SdkHttpFullRequest;

@SdkInternalApi
public final class ExecutionFailureExceptionReportingStage<OutputT> implements RequestPipeline<SdkHttpFullRequest, OutputT> {
    private final RequestPipeline<SdkHttpFullRequest, OutputT> wrapped;

    public ExecutionFailureExceptionReportingStage(RequestPipeline<SdkHttpFullRequest, OutputT> wrapped) {
        this.wrapped = wrapped;
    }

    @Override
    public OutputT execute(SdkHttpFullRequest input, RequestExecutionContext context) throws Exception {
        try {
            return wrapped.execute(input, context);
        } catch (Exception e) {
            Throwable throwable = reportFailureToInterceptors(context, e);
            throw failure(throwable);
        }
    }
}
