/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License").
 * You may not use this file except in compliance with the License.
 * A copy of the License is located at
 *
 *  http://aws.amazon.com/apache2.0
 *
 * or in the "license" file accompanying this file. This file is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */

package com.ibm.cos.v2.awscore.internal.authcontext;

import com.ibm.cos.v2.annotations.SdkInternalApi;
import com.ibm.cos.v2.awscore.client.config.AwsClientOption;
import com.ibm.cos.v2.core.CredentialType;
import com.ibm.cos.v2.core.SdkRequest;
import com.ibm.cos.v2.core.client.config.SdkAdvancedClientOption;
import com.ibm.cos.v2.core.client.config.SdkClientConfiguration;
import com.ibm.cos.v2.core.signer.Signer;
import com.ibm.cos.v2.identity.spi.AwsCredentialsIdentity;
import com.ibm.cos.v2.identity.spi.IdentityProvider;
import com.ibm.cos.v2.identity.spi.TokenIdentity;
import com.ibm.cos.v2.metrics.MetricCollector;

/**
 * Will create the correct authorization strategy based on provided credential type.
 *
 * @deprecated This is only used for compatibility with pre-SRA authorization logic. After we are comfortable that the new code
 * paths are working, we should migrate old clients to the new code paths (where possible) and delete this code.
 */
@Deprecated
@SdkInternalApi
public final class AuthorizationStrategyFactory {

    private final SdkRequest request;
    private final MetricCollector metricCollector;
    private final SdkClientConfiguration clientConfiguration;

    public AuthorizationStrategyFactory(SdkRequest request,
                                        MetricCollector metricCollector,
                                        SdkClientConfiguration clientConfiguration) {
        this.request = request;
        this.metricCollector = metricCollector;
        this.clientConfiguration = clientConfiguration;
    }

    public AuthorizationStrategy strategyFor(CredentialType credentialType) {
        if (credentialType == CredentialType.TOKEN) {
            return tokenAuthorizationStrategy();
        }
        return awsCredentialsAuthorizationStrategy();
    }

    private TokenAuthorizationStrategy tokenAuthorizationStrategy() {
        Signer defaultSigner = clientConfiguration.option(SdkAdvancedClientOption.TOKEN_SIGNER);
        // Older generated clients may be setting TOKEN_PROVIDER, hence fallback.
        IdentityProvider<? extends TokenIdentity> defaultTokenProvider =
            clientConfiguration.option(AwsClientOption.TOKEN_IDENTITY_PROVIDER) == null
            ? clientConfiguration.option(AwsClientOption.TOKEN_PROVIDER)
            : clientConfiguration.option(AwsClientOption.TOKEN_IDENTITY_PROVIDER);
        return TokenAuthorizationStrategy.builder()
                                         .request(request)
                                         .defaultSigner(defaultSigner)
                                         .defaultTokenProvider(defaultTokenProvider)
                                         .metricCollector(metricCollector)
                                         .build();
    }

    private AwsCredentialsAuthorizationStrategy awsCredentialsAuthorizationStrategy() {
        Signer defaultSigner = clientConfiguration.option(SdkAdvancedClientOption.SIGNER);
        IdentityProvider<? extends AwsCredentialsIdentity> defaultCredentialsProvider =
            clientConfiguration.option(AwsClientOption.CREDENTIALS_IDENTITY_PROVIDER);
        return AwsCredentialsAuthorizationStrategy.builder()
                                                  .request(request)
                                                  .defaultSigner(defaultSigner)
                                                  .defaultCredentialsProvider(defaultCredentialsProvider)
                                                  .metricCollector(metricCollector)
                                                  .build();
    }
}
