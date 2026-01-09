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

package com.ibm.cos.v2.services.sts;

import com.ibm.cos.v2.annotations.Generated;
import com.ibm.cos.v2.annotations.SdkPublicApi;
import com.ibm.cos.v2.awscore.client.builder.AwsClientBuilder;
import com.ibm.cos.v2.services.sts.auth.scheme.StsAuthSchemeProvider;
import com.ibm.cos.v2.services.sts.endpoints.StsEndpointProvider;

/**
 * This includes configuration specific to AWS STS that is supported by both {@link StsClientBuilder} and
 * {@link StsAsyncClientBuilder}.
 */
@Generated("com.ibm.cos.v2:codegen")
@SdkPublicApi
public interface StsBaseClientBuilder<B extends StsBaseClientBuilder<B, C>, C> extends AwsClientBuilder<B, C> {
    /**
     * Set the {@link StsEndpointProvider} implementation that will be used by the client to determine the endpoint for
     * each request. This is optional; if none is provided a default implementation will be used the SDK.
     */
    default B endpointProvider(StsEndpointProvider endpointProvider) {
        throw new UnsupportedOperationException();
    }

    /**
     * Set the {@link StsAuthSchemeProvider} implementation that will be used by the client to resolve the auth scheme
     * for each request. This is optional; if none is provided a default implementation will be used the SDK.
     */
    default B authSchemeProvider(StsAuthSchemeProvider authSchemeProvider) {
        throw new UnsupportedOperationException();
    }
}
