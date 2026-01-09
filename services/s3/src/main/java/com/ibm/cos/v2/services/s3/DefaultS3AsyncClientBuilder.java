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
import com.ibm.cos.v2.services.s3.internal.client.S3AsyncClientDecorator;
import com.ibm.cos.v2.services.s3.multipart.MultipartConfiguration;

/**
 * Internal implementation of {@link S3AsyncClientBuilder}.
 */
@Generated("com.ibm.cos.v2:codegen")
@SdkInternalApi
final class DefaultS3AsyncClientBuilder extends DefaultS3BaseClientBuilder<S3AsyncClientBuilder, S3AsyncClient> implements
        S3AsyncClientBuilder {
    @Override
    public DefaultS3AsyncClientBuilder endpointProvider(S3EndpointProvider endpointProvider) {
        clientConfiguration.option(SdkClientOption.ENDPOINT_PROVIDER, endpointProvider);
        return this;
    }

    @Override
    public S3AsyncClientBuilder multipartEnabled(Boolean enabled) {
        clientContextParams.put(S3AsyncClientDecorator.MULTIPART_ENABLED_KEY, enabled);
        return this;
    }

    @Override
    public S3AsyncClientBuilder multipartConfiguration(MultipartConfiguration multipartConfig) {
        clientContextParams.put(S3AsyncClientDecorator.MULTIPART_CONFIGURATION_KEY, multipartConfig);
        return this;
    }

    @Override
    protected final S3AsyncClient buildClient() {
        SdkClientConfiguration clientConfiguration = super.asyncClientConfiguration();
        this.validateClientOptions(clientConfiguration);
        S3AsyncClient client = new DefaultS3AsyncClient(clientConfiguration);
        return new S3AsyncClientDecorator().decorate(client, clientConfiguration);
    }
}
