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
import com.ibm.cos.v2.annotations.SdkInternalApi;
import com.ibm.cos.v2.core.client.config.SdkClientConfiguration;
import com.ibm.cos.v2.core.client.config.SdkClientOption;
import com.ibm.cos.v2.services.kms.endpoints.KmsEndpointProvider;

/**
 * Internal implementation of {@link KmsClientBuilder}.
 */
@Generated("com.ibm.cos.v2:codegen")
@SdkInternalApi
final class DefaultKmsClientBuilder extends DefaultKmsBaseClientBuilder<KmsClientBuilder, KmsClient> implements KmsClientBuilder {
    @Override
    public DefaultKmsClientBuilder endpointProvider(KmsEndpointProvider endpointProvider) {
        clientConfiguration.option(SdkClientOption.ENDPOINT_PROVIDER, endpointProvider);
        return this;
    }

    @Override
    protected final KmsClient buildClient() {
        SdkClientConfiguration clientConfiguration = super.syncClientConfiguration();
        this.validateClientOptions(clientConfiguration);
        KmsClient client = new DefaultKmsClient(clientConfiguration);
        return client;
    }
}
