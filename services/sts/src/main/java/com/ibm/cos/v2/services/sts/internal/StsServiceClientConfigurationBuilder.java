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

package com.ibm.cos.v2.services.sts.internal;

import java.net.URI;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import com.ibm.cos.v2.annotations.SdkInternalApi;
import com.ibm.cos.v2.awscore.client.config.AwsClientOption;
import com.ibm.cos.v2.core.ClientEndpointProvider;
import com.ibm.cos.v2.core.client.config.ClientOverrideConfiguration;
import com.ibm.cos.v2.core.client.config.SdkClientConfiguration;
import com.ibm.cos.v2.core.client.config.SdkClientOption;
import com.ibm.cos.v2.endpoints.EndpointProvider;
import com.ibm.cos.v2.http.auth.spi.scheme.AuthScheme;
import com.ibm.cos.v2.http.auth.spi.scheme.AuthSchemeProvider;
import com.ibm.cos.v2.identity.spi.AwsCredentialsIdentity;
import com.ibm.cos.v2.identity.spi.IdentityProvider;
import com.ibm.cos.v2.regions.Region;
import com.ibm.cos.v2.services.sts.StsServiceClientConfiguration;
import com.ibm.cos.v2.services.sts.auth.scheme.StsAuthSchemeProvider;
import com.ibm.cos.v2.utils.Validate;

@SdkInternalApi
public class StsServiceClientConfigurationBuilder implements StsServiceClientConfiguration.Builder {
    private final SdkClientConfiguration.Builder config;

    public StsServiceClientConfigurationBuilder() {
        this(SdkClientConfiguration.builder());
    }

    public StsServiceClientConfigurationBuilder(SdkClientConfiguration.Builder config) {
        this.config = config;
    }

    /**
     * Sets the value for client override configuration
     */
    @Override
    public StsServiceClientConfiguration.Builder overrideConfiguration(ClientOverrideConfiguration overrideConfiguration) {
        config.putAll(overrideConfiguration);
        return this;
    }

    /**
     * Gets the value for client override configuration
     */
    @Override
    public ClientOverrideConfiguration overrideConfiguration() {
        return config.asOverrideConfigurationBuilder().build();
    }

    /**
     * Sets the value for endpoint override
     */
    @Override
    public StsServiceClientConfiguration.Builder endpointOverride(URI endpointOverride) {
        if (endpointOverride != null) {
            config.option(SdkClientOption.CLIENT_ENDPOINT_PROVIDER, ClientEndpointProvider.forEndpointOverride(endpointOverride));
        } else {
            config.option(SdkClientOption.CLIENT_ENDPOINT_PROVIDER, null);
        }
        return this;
    }

    /**
     * Gets the value for endpoint override
     */
    @Override
    public URI endpointOverride() {
        ClientEndpointProvider clientEndpoint = config.option(SdkClientOption.CLIENT_ENDPOINT_PROVIDER);
        if (clientEndpoint != null && clientEndpoint.isEndpointOverridden()) {
            return clientEndpoint.clientEndpoint();
        }
        return null;
    }

    /**
     * Sets the value for endpoint provider
     */
    @Override
    public StsServiceClientConfiguration.Builder endpointProvider(EndpointProvider endpointProvider) {
        config.option(SdkClientOption.ENDPOINT_PROVIDER, endpointProvider);
        return this;
    }

    /**
     * Gets the value for endpoint provider
     */
    @Override
    public EndpointProvider endpointProvider() {
        return config.option(SdkClientOption.ENDPOINT_PROVIDER);
    }

    /**
     * Sets the value for AWS region
     */
    @Override
    public StsServiceClientConfiguration.Builder region(Region region) {
        config.option(AwsClientOption.AWS_REGION, region);
        return this;
    }

    /**
     * Gets the value for AWS region
     */
    @Override
    public Region region() {
        return config.option(AwsClientOption.AWS_REGION);
    }

    /**
     * Sets the value for credentials provider
     */
    @Override
    public StsServiceClientConfiguration.Builder credentialsProvider(
        IdentityProvider<? extends AwsCredentialsIdentity> credentialsProvider) {
        config.option(AwsClientOption.CREDENTIALS_IDENTITY_PROVIDER, credentialsProvider);
        return this;
    }

    /**
     * Gets the value for credentials provider
     */
    @Override
    public IdentityProvider<? extends AwsCredentialsIdentity> credentialsProvider() {
        return config.option(AwsClientOption.CREDENTIALS_IDENTITY_PROVIDER);
    }

    @Override
    public StsServiceClientConfiguration.Builder putAuthScheme(AuthScheme<?> authScheme) {
        config.computeOptionIfAbsent(SdkClientOption.AUTH_SCHEMES, HashMap::new).put(authScheme.schemeId(), authScheme);
        return this;
    }

    /**
     * Gets the value for auth schemes
     */
    @Override
    public Map<String, AuthScheme<?>> authSchemes() {
        Map<String, AuthScheme<?>> authSchemes = config.option(SdkClientOption.AUTH_SCHEMES);
        return Collections.unmodifiableMap(authSchemes == null ? Collections.emptyMap() : authSchemes);
    }

    /**
     * Sets the value for auth scheme provider
     */
    @Override
    public StsServiceClientConfiguration.Builder authSchemeProvider(StsAuthSchemeProvider authSchemeProvider) {
        config.option(SdkClientOption.AUTH_SCHEME_PROVIDER, authSchemeProvider);
        return this;
    }

    /**
     * Gets the value for auth scheme provider
     */
    @Override
    public StsAuthSchemeProvider authSchemeProvider() {
        AuthSchemeProvider result = config.option(SdkClientOption.AUTH_SCHEME_PROVIDER);
        if (result == null) {
            return null;
        }
        return Validate.isInstanceOf(StsAuthSchemeProvider.class, result, "Expected an instance of "
                                                                          + StsAuthSchemeProvider.class.getSimpleName());
    }

    @Override
    public StsServiceClientConfiguration build() {
        return new StsServiceClientConfiguration(this);
    }
}
