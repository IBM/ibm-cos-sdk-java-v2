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

package com.ibm.cos.v2.services.kms.endpoints;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import com.ibm.cos.v2.annotations.Generated;
import com.ibm.cos.v2.annotations.SdkPublicApi;
import com.ibm.cos.v2.endpoints.Endpoint;
import com.ibm.cos.v2.endpoints.EndpointProvider;
import com.ibm.cos.v2.services.kms.endpoints.internal.DefaultKmsEndpointProvider;

/**
 * An endpoint provider for Kms. The endpoint provider takes a set of parameters using {@link KmsEndpointParams}, and
 * resolves an {@link Endpoint} base on the given parameters.
 */
@Generated("com.ibm.cos.v2:codegen")
@SdkPublicApi
public interface KmsEndpointProvider extends EndpointProvider {
    /**
     * Compute the endpoint based on the given set of parameters.
     */
    CompletableFuture<Endpoint> resolveEndpoint(KmsEndpointParams endpointParams);

    /**
     * Compute the endpoint based on the given set of parameters.
     */
    default CompletableFuture<Endpoint> resolveEndpoint(Consumer<KmsEndpointParams.Builder> endpointParamsConsumer) {
        KmsEndpointParams.Builder paramsBuilder = KmsEndpointParams.builder();
        endpointParamsConsumer.accept(paramsBuilder);
        return resolveEndpoint(paramsBuilder.build());
    }

    static KmsEndpointProvider defaultProvider() {
        return new DefaultKmsEndpointProvider();
    }
}
