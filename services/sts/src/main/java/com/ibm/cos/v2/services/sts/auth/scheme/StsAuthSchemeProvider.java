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

package com.ibm.cos.v2.services.sts.auth.scheme;

import java.util.List;
import java.util.function.Consumer;
import com.ibm.cos.v2.annotations.Generated;
import com.ibm.cos.v2.annotations.SdkPublicApi;
import com.ibm.cos.v2.http.auth.spi.scheme.AuthSchemeOption;
import com.ibm.cos.v2.http.auth.spi.scheme.AuthSchemeProvider;
import com.ibm.cos.v2.services.sts.auth.scheme.internal.DefaultStsAuthSchemeProvider;

/**
 * An auth scheme provider for Sts service. The auth scheme provider takes a set of parameters using
 * {@link StsAuthSchemeParams}, and resolves a list of {@link AuthSchemeOption} based on the given parameters.
 */
@Generated("com.ibm.cos.v2:codegen")
@SdkPublicApi
public interface StsAuthSchemeProvider extends AuthSchemeProvider {
    /**
     * Resolve the auth schemes based on the given set of parameters.
     */
    List<AuthSchemeOption> resolveAuthScheme(StsAuthSchemeParams authSchemeParams);

    /**
     * Resolve the auth schemes based on the given set of parameters.
     */
    default List<AuthSchemeOption> resolveAuthScheme(Consumer<StsAuthSchemeParams.Builder> consumer) {
        StsAuthSchemeParams.Builder builder = StsAuthSchemeParams.builder();
        consumer.accept(builder);
        return resolveAuthScheme(builder.build());
    }

    /**
     * Get the default auth scheme provider.
     */
    static StsAuthSchemeProvider defaultProvider() {
        return DefaultStsAuthSchemeProvider.create();
    }
}
