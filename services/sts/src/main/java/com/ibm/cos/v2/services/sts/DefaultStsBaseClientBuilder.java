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

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import com.ibm.cos.v2.annotations.Generated;
import com.ibm.cos.v2.annotations.SdkInternalApi;
import com.ibm.cos.v2.awscore.client.builder.AwsDefaultClientBuilder;
import com.ibm.cos.v2.awscore.client.config.AwsClientOption;
import com.ibm.cos.v2.awscore.endpoint.AwsClientEndpointProvider;
import com.ibm.cos.v2.awscore.retry.AwsRetryStrategy;
import com.ibm.cos.v2.core.SdkPlugin;
import com.ibm.cos.v2.core.client.config.ClientOverrideConfiguration;
import com.ibm.cos.v2.core.client.config.SdkClientConfiguration;
import com.ibm.cos.v2.core.client.config.SdkClientOption;
import com.ibm.cos.v2.core.interceptor.ClasspathInterceptorChainFactory;
import com.ibm.cos.v2.core.interceptor.ExecutionInterceptor;
import com.ibm.cos.v2.core.retry.RetryMode;
import com.ibm.cos.v2.http.auth.aws.scheme.AwsV4AuthScheme;
import com.ibm.cos.v2.http.auth.scheme.NoAuthAuthScheme;
import com.ibm.cos.v2.http.auth.spi.scheme.AuthScheme;
import com.ibm.cos.v2.identity.spi.IdentityProvider;
import com.ibm.cos.v2.identity.spi.IdentityProviders;
import com.ibm.cos.v2.regions.ServiceMetadataAdvancedOption;
import com.ibm.cos.v2.retries.api.RetryStrategy;
import com.ibm.cos.v2.services.sts.auth.scheme.StsAuthSchemeProvider;
import com.ibm.cos.v2.services.sts.auth.scheme.internal.StsAuthSchemeInterceptor;
import com.ibm.cos.v2.services.sts.endpoints.StsEndpointProvider;
import com.ibm.cos.v2.services.sts.endpoints.internal.StsRequestSetEndpointInterceptor;
import com.ibm.cos.v2.services.sts.endpoints.internal.StsResolveEndpointInterceptor;
import com.ibm.cos.v2.services.sts.internal.StsServiceClientConfigurationBuilder;
import com.ibm.cos.v2.utils.CollectionUtils;

/**
 * Internal base class for {@link DefaultStsClientBuilder} and {@link DefaultStsAsyncClientBuilder}.
 */
@SdkInternalApi
abstract class DefaultStsBaseClientBuilder<B extends StsBaseClientBuilder<B, C>, C> extends AwsDefaultClientBuilder<B, C> {
    private final Map<String, AuthScheme<?>> additionalAuthSchemes = new HashMap<>();

    @Override
    protected final String serviceEndpointPrefix() {
        return "sts";
    }

    @Override
    protected final String serviceName() {
        return "Sts";
    }

    @Override
    protected final SdkClientConfiguration mergeServiceDefaults(SdkClientConfiguration config) {
        return config.merge(c -> c.option(SdkClientOption.ENDPOINT_PROVIDER, defaultEndpointProvider())
                .option(SdkClientOption.AUTH_SCHEME_PROVIDER, defaultAuthSchemeProvider())
                .option(SdkClientOption.AUTH_SCHEMES, authSchemes())
                .option(SdkClientOption.CRC32_FROM_COMPRESSED_DATA_ENABLED, false));
    }

    @Override
    protected final SdkClientConfiguration finalizeServiceConfiguration(SdkClientConfiguration config) {
        List<ExecutionInterceptor> endpointInterceptors = new ArrayList<>();
        endpointInterceptors.add(new StsAuthSchemeInterceptor());
        endpointInterceptors.add(new StsResolveEndpointInterceptor());
        endpointInterceptors.add(new StsRequestSetEndpointInterceptor());
        ClasspathInterceptorChainFactory interceptorFactory = new ClasspathInterceptorChainFactory();
        List<ExecutionInterceptor> interceptors = interceptorFactory
                .getInterceptors("com/ibm/cos/v2/services/sts/execution.interceptors");
        List<ExecutionInterceptor> additionalInterceptors = new ArrayList<>();
        interceptors = CollectionUtils.mergeLists(endpointInterceptors, interceptors);
        interceptors = CollectionUtils.mergeLists(interceptors, additionalInterceptors);
        interceptors = CollectionUtils.mergeLists(interceptors, config.option(SdkClientOption.EXECUTION_INTERCEPTORS));
        SdkClientConfiguration.Builder builder = config.toBuilder();
        builder.lazyOption(SdkClientOption.IDENTITY_PROVIDERS, c -> {
            IdentityProviders.Builder result = IdentityProviders.builder();
            IdentityProvider<?> credentialsIdentityProvider = c.get(AwsClientOption.CREDENTIALS_IDENTITY_PROVIDER);
            if (credentialsIdentityProvider != null) {
                result.putIdentityProvider(credentialsIdentityProvider);
            }
            return result.build();
        });
        builder.option(SdkClientOption.EXECUTION_INTERCEPTORS, interceptors);
        builder.lazyOptionIfAbsent(
                SdkClientOption.CLIENT_ENDPOINT_PROVIDER,
                c -> AwsClientEndpointProvider
                        .builder()
                        .serviceEndpointOverrideEnvironmentVariable("AWS_ENDPOINT_URL_STS")
                        .serviceEndpointOverrideSystemProperty("aws.endpointUrlSts")
                        .serviceProfileProperty("sts")
                        .serviceEndpointPrefix(serviceEndpointPrefix())
                        .defaultProtocol("https")
                        .region(c.get(AwsClientOption.AWS_REGION))
                        .profileFile(c.get(SdkClientOption.PROFILE_FILE_SUPPLIER))
                        .profileName(c.get(SdkClientOption.PROFILE_NAME))
                        .putAdvancedOption(ServiceMetadataAdvancedOption.DEFAULT_S3_US_EAST_1_REGIONAL_ENDPOINT,
                                c.get(ServiceMetadataAdvancedOption.DEFAULT_S3_US_EAST_1_REGIONAL_ENDPOINT))
                        .dualstackEnabled(c.get(AwsClientOption.DUALSTACK_ENDPOINT_ENABLED))
                        .fipsEnabled(c.get(AwsClientOption.FIPS_ENDPOINT_ENABLED)).build());
        return builder.build();
    }

    @Override
    protected final String signingName() {
        return "sts";
    }

    private StsEndpointProvider defaultEndpointProvider() {
        return StsEndpointProvider.defaultProvider();
    }

    public B authSchemeProvider(StsAuthSchemeProvider authSchemeProvider) {
        clientConfiguration.option(SdkClientOption.AUTH_SCHEME_PROVIDER, authSchemeProvider);
        return thisBuilder();
    }

    private StsAuthSchemeProvider defaultAuthSchemeProvider() {
        return StsAuthSchemeProvider.defaultProvider();
    }

    @Override
    public B putAuthScheme(AuthScheme<?> authScheme) {
        additionalAuthSchemes.put(authScheme.schemeId(), authScheme);
        return thisBuilder();
    }

    private Map<String, AuthScheme<?>> authSchemes() {
        Map<String, AuthScheme<?>> schemes = new HashMap<>(2 + this.additionalAuthSchemes.size());
        AwsV4AuthScheme awsV4AuthScheme = AwsV4AuthScheme.create();
        schemes.put(awsV4AuthScheme.schemeId(), awsV4AuthScheme);
        NoAuthAuthScheme noAuthAuthScheme = NoAuthAuthScheme.create();
        schemes.put(noAuthAuthScheme.schemeId(), noAuthAuthScheme);
        schemes.putAll(this.additionalAuthSchemes);
        return schemes;
    }

    @Override
    protected SdkClientConfiguration invokePlugins(SdkClientConfiguration config) {
        List<SdkPlugin> internalPlugins = internalPlugins(config);
        List<SdkPlugin> externalPlugins = plugins();
        if (internalPlugins.isEmpty() && externalPlugins.isEmpty()) {
            return config;
        }
        List<SdkPlugin> plugins = CollectionUtils.mergeLists(internalPlugins, externalPlugins);
        SdkClientConfiguration.Builder configuration = config.toBuilder();
        StsServiceClientConfigurationBuilder serviceConfigBuilder = new StsServiceClientConfigurationBuilder(configuration);
        for (SdkPlugin plugin : plugins) {
            plugin.configureClient(serviceConfigBuilder);
        }
        updateRetryStrategyClientConfiguration(configuration);
        return configuration.build();
    }

    private void updateRetryStrategyClientConfiguration(SdkClientConfiguration.Builder configuration) {
        ClientOverrideConfiguration.Builder builder = configuration.asOverrideConfigurationBuilder();
        RetryMode retryMode = builder.retryMode();
        if (retryMode != null) {
            configuration.option(SdkClientOption.RETRY_STRATEGY, AwsRetryStrategy.forRetryMode(retryMode));
        } else {
            Consumer<RetryStrategy.Builder<?, ?>> configurator = builder.retryStrategyConfigurator();
            if (configurator != null) {
                RetryStrategy.Builder<?, ?> defaultBuilder = AwsRetryStrategy.defaultRetryStrategy().toBuilder();
                configurator.accept(defaultBuilder);
                configuration.option(SdkClientOption.RETRY_STRATEGY, defaultBuilder.build());
            } else {
                RetryStrategy retryStrategy = builder.retryStrategy();
                if (retryStrategy != null) {
                    configuration.option(SdkClientOption.RETRY_STRATEGY, retryStrategy);
                }
            }
        }
        configuration.option(SdkClientOption.CONFIGURED_RETRY_MODE, null);
        configuration.option(SdkClientOption.CONFIGURED_RETRY_STRATEGY, null);
        configuration.option(SdkClientOption.CONFIGURED_RETRY_CONFIGURATOR, null);
    }

    private List<SdkPlugin> internalPlugins(SdkClientConfiguration config) {
        return Collections.emptyList();
    }

    protected static void validateClientOptions(SdkClientConfiguration c) {
    }
}
