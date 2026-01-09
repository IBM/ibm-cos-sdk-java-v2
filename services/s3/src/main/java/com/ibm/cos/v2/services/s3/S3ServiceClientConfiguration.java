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

import java.net.URI;
import java.util.Map;
import com.ibm.cos.v2.annotations.Generated;
import com.ibm.cos.v2.annotations.SdkPublicApi;
import com.ibm.cos.v2.awscore.AwsServiceClientConfiguration;
import com.ibm.cos.v2.core.checksums.RequestChecksumCalculation;
import com.ibm.cos.v2.core.checksums.ResponseChecksumValidation;
import com.ibm.cos.v2.core.client.config.ClientOverrideConfiguration;
import com.ibm.cos.v2.endpoints.EndpointProvider;
import com.ibm.cos.v2.http.auth.spi.scheme.AuthScheme;
import com.ibm.cos.v2.identity.spi.AwsCredentialsIdentity;
import com.ibm.cos.v2.identity.spi.IdentityProvider;
import com.ibm.cos.v2.regions.Region;
import com.ibm.cos.v2.services.s3.auth.scheme.S3AuthSchemeProvider;
import com.ibm.cos.v2.services.s3.internal.S3ServiceClientConfigurationBuilder;

/**
 * Class to expose the service client settings to the user. Implementation of {@link AwsServiceClientConfiguration}
 */
@Generated("com.ibm.cos.v2:codegen")
@SdkPublicApi
public final class S3ServiceClientConfiguration extends AwsServiceClientConfiguration {
    private final S3AuthSchemeProvider authSchemeProvider;

    private final Boolean crossRegionAccessEnabled;

    private final ResponseChecksumValidation responseChecksumValidation;

    private final RequestChecksumCalculation requestChecksumCalculation;

    public S3ServiceClientConfiguration(Builder builder) {
        super(builder);
        this.authSchemeProvider = builder.authSchemeProvider();
        this.crossRegionAccessEnabled = builder.crossRegionAccessEnabled();
        this.responseChecksumValidation = builder.responseChecksumValidation();
        this.requestChecksumCalculation = builder.requestChecksumCalculation();
    }

    public static Builder builder() {
        return new S3ServiceClientConfigurationBuilder();
    }

    /**
     * Gets the value for auth scheme provider
     */
    public S3AuthSchemeProvider authSchemeProvider() {
        return authSchemeProvider;
    }

    /**
     * Gets the value for Enables cross-region bucket access for this client
     */
    public Boolean crossRegionAccessEnabled() {
        return crossRegionAccessEnabled;
    }

    /**
     * Gets the value for client behavior for response checksum validation
     */
    public ResponseChecksumValidation responseChecksumValidation() {
        return responseChecksumValidation;
    }

    /**
     * Gets the value for client behavior for request checksum calculation
     */
    public RequestChecksumCalculation requestChecksumCalculation() {
        return requestChecksumCalculation;
    }

    /**
     * A builder for creating a {@link S3ServiceClientConfiguration}
     */
    public interface Builder extends AwsServiceClientConfiguration.Builder {
        /**
         * Sets the value for client override configuration
         */
        @Override
        Builder overrideConfiguration(ClientOverrideConfiguration overrideConfiguration);

        /**
         * Gets the value for client override configuration
         */
        @Override
        ClientOverrideConfiguration overrideConfiguration();

        /**
         * Sets the value for endpoint override
         */
        @Override
        Builder endpointOverride(URI endpointOverride);

        /**
         * Gets the value for endpoint override
         */
        @Override
        URI endpointOverride();

        /**
         * Sets the value for endpoint provider
         */
        @Override
        Builder endpointProvider(EndpointProvider endpointProvider);

        /**
         * Gets the value for endpoint provider
         */
        @Override
        EndpointProvider endpointProvider();

        /**
         * Sets the value for AWS region
         */
        @Override
        Builder region(Region region);

        /**
         * Gets the value for AWS region
         */
        @Override
        Region region();

        /**
         * Sets the value for credentials provider
         */
        @Override
        Builder credentialsProvider(IdentityProvider<? extends AwsCredentialsIdentity> credentialsProvider);

        /**
         * Gets the value for credentials provider
         */
        @Override
        IdentityProvider<? extends AwsCredentialsIdentity> credentialsProvider();

        @Override
        Builder putAuthScheme(AuthScheme<?> authScheme);

        /**
         * Gets the value for auth schemes
         */
        @Override
        Map<String, AuthScheme<?>> authSchemes();

        /**
         * Sets the value for auth scheme provider
         */
        Builder authSchemeProvider(S3AuthSchemeProvider authSchemeProvider);

        /**
         * Gets the value for auth scheme provider
         */
        S3AuthSchemeProvider authSchemeProvider();

        /**
         * Sets the value for Enables cross-region bucket access for this client
         */
        Builder crossRegionAccessEnabled(Boolean crossRegionAccessEnabled);

        /**
         * Gets the value for Enables cross-region bucket access for this client
         */
        Boolean crossRegionAccessEnabled();

        /**
         * Sets the value for client behavior for response checksum validation
         */
        Builder responseChecksumValidation(ResponseChecksumValidation responseChecksumValidation);

        /**
         * Gets the value for client behavior for response checksum validation
         */
        ResponseChecksumValidation responseChecksumValidation();

        /**
         * Sets the value for client behavior for request checksum calculation
         */
        Builder requestChecksumCalculation(RequestChecksumCalculation requestChecksumCalculation);

        /**
         * Gets the value for client behavior for request checksum calculation
         */
        RequestChecksumCalculation requestChecksumCalculation();

        @Override
        S3ServiceClientConfiguration build();
    }
}
