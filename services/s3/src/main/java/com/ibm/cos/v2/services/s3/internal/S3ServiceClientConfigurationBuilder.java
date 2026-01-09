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

package com.ibm.cos.v2.services.s3.internal;

import java.net.URI;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import com.ibm.cos.v2.annotations.Generated;
import com.ibm.cos.v2.annotations.SdkInternalApi;
import com.ibm.cos.v2.awscore.client.config.AwsClientOption;
import com.ibm.cos.v2.core.ClientEndpointProvider;
import com.ibm.cos.v2.core.checksums.RequestChecksumCalculation;
import com.ibm.cos.v2.core.checksums.ResponseChecksumValidation;
import com.ibm.cos.v2.core.client.config.ClientOverrideConfiguration;
import com.ibm.cos.v2.core.client.config.SdkClientConfiguration;
import com.ibm.cos.v2.core.client.config.SdkClientOption;
import com.ibm.cos.v2.endpoints.EndpointProvider;
import com.ibm.cos.v2.http.auth.spi.scheme.AuthScheme;
import com.ibm.cos.v2.http.auth.spi.scheme.AuthSchemeProvider;
import com.ibm.cos.v2.identity.spi.AwsCredentialsIdentity;
import com.ibm.cos.v2.identity.spi.IdentityProvider;
import com.ibm.cos.v2.regions.Region;
import com.ibm.cos.v2.services.s3.S3ServiceClientConfiguration;
import com.ibm.cos.v2.services.s3.auth.scheme.S3AuthSchemeProvider;
import com.ibm.cos.v2.services.s3.endpoints.S3ClientContextParams;
import com.ibm.cos.v2.utils.AttributeMap;
import com.ibm.cos.v2.utils.Validate;

@Generated("com.ibm.cos.v2:codegen")
@SdkInternalApi
public class S3ServiceClientConfigurationBuilder implements S3ServiceClientConfiguration.Builder {
    private final SdkClientConfiguration.Builder config;

    public S3ServiceClientConfigurationBuilder() {
        this(SdkClientConfiguration.builder());
    }

    public S3ServiceClientConfigurationBuilder(SdkClientConfiguration.Builder config) {
        this.config = config;
    }

    /**
     * Sets the value for client override configuration
     */
    @Override
    public S3ServiceClientConfiguration.Builder overrideConfiguration(ClientOverrideConfiguration overrideConfiguration) {
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
    public S3ServiceClientConfiguration.Builder endpointOverride(URI endpointOverride) {
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
    public S3ServiceClientConfiguration.Builder endpointProvider(EndpointProvider endpointProvider) {
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
    public S3ServiceClientConfiguration.Builder region(Region region) {
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
    public S3ServiceClientConfiguration.Builder credentialsProvider(
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
    public S3ServiceClientConfiguration.Builder putAuthScheme(AuthScheme<?> authScheme) {
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
    public S3ServiceClientConfiguration.Builder authSchemeProvider(S3AuthSchemeProvider authSchemeProvider) {
        config.option(SdkClientOption.AUTH_SCHEME_PROVIDER, authSchemeProvider);
        return this;
    }

    /**
     * Gets the value for auth scheme provider
     */
    @Override
    public S3AuthSchemeProvider authSchemeProvider() {
        AuthSchemeProvider result = config.option(SdkClientOption.AUTH_SCHEME_PROVIDER);
        if (result == null) {
            return null;
        }
        return Validate.isInstanceOf(S3AuthSchemeProvider.class, result,
                "Expected an instance of " + S3AuthSchemeProvider.class.getSimpleName());
    }

    /**
     * Sets the value for Enables cross-region bucket access for this client
     */
    @Override
    public S3ServiceClientConfiguration.Builder crossRegionAccessEnabled(Boolean crossRegionAccessEnabled) {
        config.option(
                SdkClientOption.CLIENT_CONTEXT_PARAMS,
                config.computeOptionIfAbsent(SdkClientOption.CLIENT_CONTEXT_PARAMS, AttributeMap::empty).toBuilder()
                        .put(S3ClientContextParams.CROSS_REGION_ACCESS_ENABLED, crossRegionAccessEnabled).build());
        return this;
    }

    /**
     * Gets the value for Enables cross-region bucket access for this client
     */
    @Override
    public Boolean crossRegionAccessEnabled() {
        return config.computeOptionIfAbsent(SdkClientOption.CLIENT_CONTEXT_PARAMS, AttributeMap::empty).get(
                S3ClientContextParams.CROSS_REGION_ACCESS_ENABLED);
    }

    /**
     * Sets the value for client behavior for response checksum validation
     */
    @Override
    public S3ServiceClientConfiguration.Builder responseChecksumValidation(ResponseChecksumValidation responseChecksumValidation) {
        config.option(SdkClientOption.RESPONSE_CHECKSUM_VALIDATION, responseChecksumValidation);
        return this;
    }

    /**
     * Gets the value for client behavior for response checksum validation
     */
    @Override
    public ResponseChecksumValidation responseChecksumValidation() {
        return config.option(SdkClientOption.RESPONSE_CHECKSUM_VALIDATION);
    }

    /**
     * Sets the value for client behavior for request checksum calculation
     */
    @Override
    public S3ServiceClientConfiguration.Builder requestChecksumCalculation(RequestChecksumCalculation requestChecksumCalculation) {
        config.option(SdkClientOption.REQUEST_CHECKSUM_CALCULATION, requestChecksumCalculation);
        return this;
    }

    /**
     * Gets the value for client behavior for request checksum calculation
     */
    @Override
    public RequestChecksumCalculation requestChecksumCalculation() {
        return config.option(SdkClientOption.REQUEST_CHECKSUM_CALCULATION);
    }

    @Override
    public S3ServiceClientConfiguration build() {
        return new S3ServiceClientConfiguration(this);
    }
}
