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

package com.ibm.cos.v2.awscore.interceptor;

import com.ibm.cos.v2.annotations.SdkProtectedApi;
import com.ibm.cos.v2.core.interceptor.Context;
import com.ibm.cos.v2.core.interceptor.ExecutionAttributes;
import com.ibm.cos.v2.core.interceptor.ExecutionInterceptor;

/**
 * A more specific version of {@link HelpfulUnknownHostExceptionInterceptor} that was used for older IAM clients. This can be
 * removed if we ever drop backwards-compatibility with older IAM client versions, because newer IAM client versions do not
 * depend on this interceptor.
 */
@SdkProtectedApi
public class GlobalServiceExecutionInterceptor implements ExecutionInterceptor {
    private static final HelpfulUnknownHostExceptionInterceptor DELEGATE = new HelpfulUnknownHostExceptionInterceptor();

    @Override
    public Throwable modifyException(Context.FailedExecution context, ExecutionAttributes executionAttributes) {
        return DELEGATE.modifyException(context, executionAttributes);
    }
}
