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

package com.ibm.cos.v2.services.kms;

import com.ibm.cos.v2.annotations.Generated;
import com.ibm.cos.v2.annotations.SdkPublicApi;
import com.ibm.cos.v2.awscore.client.builder.AwsClientBuilder;
import com.ibm.cos.v2.services.kms.auth.scheme.KmsAuthSchemeProvider;
import com.ibm.cos.v2.services.kms.endpoints.KmsEndpointProvider;

/**
 * This includes configuration specific to KMS that is supported by both {@link KmsClientBuilder} and
 * {@link KmsAsyncClientBuilder}.
 */
@Generated("com.ibm.cos.v2:codegen")
@SdkPublicApi
public interface KmsBaseClientBuilder<B extends KmsBaseClientBuilder<B, C>, C> extends AwsClientBuilder<B, C> {
    /**
     * Set the {@link KmsEndpointProvider} implementation that will be used by the client to determine the endpoint for
     * each request. This is optional; if none is provided a default implementation will be used the SDK.
     */
    default B endpointProvider(KmsEndpointProvider endpointProvider) {
        throw new UnsupportedOperationException();
    }

    /**
     * Set the {@link KmsAuthSchemeProvider} implementation that will be used by the client to resolve the auth scheme
     * for each request. This is optional; if none is provided a default implementation will be used the SDK.
     */
    default B authSchemeProvider(KmsAuthSchemeProvider authSchemeProvider) {
        throw new UnsupportedOperationException();
    }
}
