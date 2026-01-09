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
import com.ibm.cos.v2.annotations.SdkInternalApi;
import com.ibm.cos.v2.core.client.config.SdkClientConfiguration;
import com.ibm.cos.v2.core.client.config.SdkClientOption;
import com.ibm.cos.v2.services.sts.endpoints.StsEndpointProvider;

/**
 * Internal implementation of {@link StsAsyncClientBuilder}.
 */
@Generated("com.ibm.cos.v2:codegen")
@SdkInternalApi
final class DefaultStsAsyncClientBuilder extends DefaultStsBaseClientBuilder<StsAsyncClientBuilder, StsAsyncClient> implements
        StsAsyncClientBuilder {
    @Override
    public DefaultStsAsyncClientBuilder endpointProvider(StsEndpointProvider endpointProvider) {
        clientConfiguration.option(SdkClientOption.ENDPOINT_PROVIDER, endpointProvider);
        return this;
    }

    @Override
    protected final StsAsyncClient buildClient() {
        SdkClientConfiguration clientConfiguration = super.asyncClientConfiguration();
        this.validateClientOptions(clientConfiguration);
        StsAsyncClient client = new DefaultStsAsyncClient(clientConfiguration);
        return client;
    }
}
