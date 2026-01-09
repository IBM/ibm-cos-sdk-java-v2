/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"). You may not use this file except in compliance with
 * the License. A copy of the License is located at
 *
 * http://aws.amazon.com/apache2.0
 *
 * or in the "license" file accompanying this file. This file is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR
 * CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions
 * and limitations under the License.
 */

package com.ibm.cos.v2.services.sts.endpoints.internal;

import com.ibm.cos.v2.annotations.Generated;
import com.ibm.cos.v2.annotations.SdkInternalApi;
import com.ibm.cos.v2.core.interceptor.Context;
import com.ibm.cos.v2.core.interceptor.ExecutionAttributes;
import com.ibm.cos.v2.core.interceptor.ExecutionInterceptor;
import com.ibm.cos.v2.core.interceptor.SdkInternalExecutionAttribute;
import com.ibm.cos.v2.endpoints.Endpoint;
import com.ibm.cos.v2.http.SdkHttpRequest;

@Generated("software.amazon.awssdk:codegen")
@SdkInternalApi
public final class StsRequestSetEndpointInterceptor implements ExecutionInterceptor {
    @Override
    public SdkHttpRequest modifyHttpRequest(Context.ModifyHttpRequest context, ExecutionAttributes executionAttributes) {
        if (AwsEndpointProviderUtils.endpointIsDiscovered(executionAttributes)) {
            return context.httpRequest();
        }
        Endpoint endpoint = executionAttributes.getAttribute(SdkInternalExecutionAttribute.RESOLVED_ENDPOINT);
        return AwsEndpointProviderUtils.setUri(context.httpRequest(),
                                               executionAttributes.getAttribute(SdkInternalExecutionAttribute.CLIENT_ENDPOINT_PROVIDER).clientEndpoint(),
                                               endpoint.url());
    }
}
