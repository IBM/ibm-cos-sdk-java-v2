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

package com.ibm.cos.v2.core.internal.http.pipeline.stages.utils;

import com.ibm.cos.v2.annotations.SdkInternalApi;
import com.ibm.cos.v2.core.internal.http.RequestExecutionContext;
import com.ibm.cos.v2.core.internal.interceptor.DefaultFailedExecutionContext;
import com.ibm.cos.v2.utils.Logger;

@SdkInternalApi
public final class ExceptionReportingUtils {
    private static final Logger log = Logger.loggerFor(ExceptionReportingUtils.class);

    private ExceptionReportingUtils() {
    }

    /**
     * Report the failure to the execution interceptors. Swallow any exceptions thrown from the interceptor since
     * we don't want to replace the execution failure.
     *
     * @param context The execution context.
     * @param failure The execution failure.
     */
    public static Throwable reportFailureToInterceptors(RequestExecutionContext context, Throwable failure) {
        DefaultFailedExecutionContext modifiedContext = runModifyException(context, failure);

        try {
            context.interceptorChain().onExecutionFailure(modifiedContext, context.executionAttributes());
        } catch (Exception exception) {
            log.warn(() -> "Interceptor chain threw an error from onExecutionFailure().", exception);
        }

        return modifiedContext.exception();
    }

    private static DefaultFailedExecutionContext runModifyException(RequestExecutionContext context, Throwable e) {
        DefaultFailedExecutionContext failedContext =
            DefaultFailedExecutionContext.builder()
                                         .interceptorContext(context.executionContext().interceptorContext())
                                         .exception(e).build();
        return context.interceptorChain().modifyException(failedContext, context.executionAttributes());
    }
}
