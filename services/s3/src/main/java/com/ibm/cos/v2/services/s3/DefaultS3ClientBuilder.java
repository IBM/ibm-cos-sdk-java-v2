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

package com.ibm.cos.v2.services.s3;

import com.ibm.cos.v2.annotations.Generated;
import com.ibm.cos.v2.annotations.SdkInternalApi;
import com.ibm.cos.v2.core.client.config.SdkClientConfiguration;
import com.ibm.cos.v2.core.client.config.SdkClientOption;
import com.ibm.cos.v2.services.s3.endpoints.S3EndpointProvider;
import com.ibm.cos.v2.services.s3.internal.client.S3SyncClientDecorator;

/**
 * Internal implementation of {@link S3ClientBuilder}.
 */
@Generated("com.ibm.cos.v2:codegen")
@SdkInternalApi
final class DefaultS3ClientBuilder extends DefaultS3BaseClientBuilder<S3ClientBuilder, S3Client> implements S3ClientBuilder {
    @Override
    public DefaultS3ClientBuilder endpointProvider(S3EndpointProvider endpointProvider) {
        clientConfiguration.option(SdkClientOption.ENDPOINT_PROVIDER, endpointProvider);
        return this;
    }

    @Override
    protected final S3Client buildClient() {
        SdkClientConfiguration clientConfiguration = super.syncClientConfiguration();
        this.validateClientOptions(clientConfiguration);
        S3Client client = new DefaultS3Client(clientConfiguration);
        return new S3SyncClientDecorator().decorate(client, clientConfiguration);
    }
}
