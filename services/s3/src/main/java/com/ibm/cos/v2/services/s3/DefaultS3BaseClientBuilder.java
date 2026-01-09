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

import com.ibm.cos.v2.auth.credentials.ibmOAuth.BasicIBMOAuthCredentials;
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
import com.ibm.cos.v2.core.checksums.RequestChecksumCalculation;
import com.ibm.cos.v2.core.checksums.RequestChecksumCalculationResolver;
import com.ibm.cos.v2.core.checksums.ResponseChecksumValidation;
import com.ibm.cos.v2.core.checksums.ResponseChecksumValidationResolver;
import com.ibm.cos.v2.core.client.config.ClientOverrideConfiguration;
import com.ibm.cos.v2.core.client.config.SdkClientConfiguration;
import com.ibm.cos.v2.core.client.config.SdkClientOption;
import com.ibm.cos.v2.core.interceptor.ClasspathInterceptorChainFactory;
import com.ibm.cos.v2.core.interceptor.ExecutionInterceptor;
import com.ibm.cos.v2.core.retry.RetryMode;
import com.ibm.cos.v2.http.auth.aws.scheme.AwsV4AuthScheme;
//import com.ibm.cos.v2.http.auth.aws.scheme.AwsV4aAuthScheme; TODO:REMOVE
import com.ibm.cos.v2.http.auth.aws.signer.RegionSet;
import com.ibm.cos.v2.http.auth.scheme.NoAuthAuthScheme;
import com.ibm.cos.v2.http.auth.spi.scheme.AuthScheme;
import com.ibm.cos.v2.identity.spi.IdentityProvider;
import com.ibm.cos.v2.identity.spi.IdentityProviders;
import com.ibm.cos.v2.regions.ServiceMetadataAdvancedOption;
import com.ibm.cos.v2.retries.api.RetryStrategy;
import com.ibm.cos.v2.services.s3.auth.scheme.S3AuthSchemeProvider;
import com.ibm.cos.v2.services.s3.auth.scheme.internal.S3AuthSchemeInterceptor;
import com.ibm.cos.v2.services.s3.endpoints.S3ClientContextParams;
import com.ibm.cos.v2.services.s3.endpoints.S3EndpointProvider;
import com.ibm.cos.v2.services.s3.endpoints.internal.S3RequestSetEndpointInterceptor;
import com.ibm.cos.v2.services.s3.endpoints.internal.S3ResolveEndpointInterceptor;
import com.ibm.cos.v2.services.s3.internal.S3ServiceClientConfigurationBuilder;
import com.ibm.cos.v2.services.s3.internal.endpoints.UseGlobalEndpointResolver;
import com.ibm.cos.v2.services.s3.internal.handlers.AsyncChecksumValidationInterceptor;
import com.ibm.cos.v2.services.s3.internal.handlers.CreateBucketInterceptor;
import com.ibm.cos.v2.services.s3.internal.handlers.CreateMultipartUploadRequestInterceptor;
import com.ibm.cos.v2.services.s3.internal.handlers.DecodeUrlEncodedResponseInterceptor;
import com.ibm.cos.v2.services.s3.internal.handlers.EnableTrailingChecksumInterceptor;
import com.ibm.cos.v2.services.s3.internal.handlers.ExceptionTranslationInterceptor;
import com.ibm.cos.v2.services.s3.internal.handlers.GetBucketPolicyInterceptor;
import com.ibm.cos.v2.services.s3.internal.handlers.GetObjectInterceptor;
import com.ibm.cos.v2.services.s3.internal.handlers.ObjectMetadataInterceptor;
import com.ibm.cos.v2.services.s3.internal.handlers.StreamingRequestInterceptor;
import com.ibm.cos.v2.services.s3.internal.handlers.SyncChecksumValidationInterceptor;
import com.ibm.cos.v2.services.s3.internal.plugins.S3DisableChunkEncodingIfConfiguredPlugin;
import com.ibm.cos.v2.services.s3.internal.s3express.S3ExpressPlugin;
import com.ibm.cos.v2.services.s3.internal.s3express.UseS3ExpressAuthResolver;
import com.ibm.cos.v2.utils.CollectionUtils;
import com.ibm.cos.v2.utils.Validate;

/**
 * Internal base class for {@link DefaultS3ClientBuilder} and {@link DefaultS3AsyncClientBuilder}.
 */
@Generated("com.ibm.cos.v2:codegen")
@SdkInternalApi
abstract class DefaultS3BaseClientBuilder<B extends S3BaseClientBuilder<B, C>, C> extends AwsDefaultClientBuilder<B, C> {
    private final Map<String, AuthScheme<?>> additionalAuthSchemes = new HashMap<>();

    @Override
    protected final String serviceEndpointPrefix() {
        return "s3";
    }

    @Override
    protected final String serviceName() {
        return "S3";
    }

    @Override
    protected final SdkClientConfiguration mergeServiceDefaults(SdkClientConfiguration config) {
        return config.merge(c -> c.option(SdkClientOption.ENDPOINT_PROVIDER, defaultEndpointProvider())
                .option(SdkClientOption.AUTH_SCHEME_PROVIDER, defaultAuthSchemeProvider())
                .option(SdkClientOption.AUTH_SCHEMES, authSchemes())
                .option(SdkClientOption.CRC32_FROM_COMPRESSED_DATA_ENABLED, false)
                .option(SdkClientOption.SERVICE_CONFIGURATION, S3Configuration.builder().build()));
    }

    @Override
    protected final SdkClientConfiguration finalizeServiceConfiguration(SdkClientConfiguration config) {
        List<ExecutionInterceptor> endpointInterceptors = new ArrayList<>();
        endpointInterceptors.add(new S3AuthSchemeInterceptor());
        endpointInterceptors.add(new S3ResolveEndpointInterceptor());
        endpointInterceptors.add(new S3RequestSetEndpointInterceptor());
        endpointInterceptors.add(new StreamingRequestInterceptor());
        endpointInterceptors.add(new CreateBucketInterceptor());
        endpointInterceptors.add(new CreateMultipartUploadRequestInterceptor());
        endpointInterceptors.add(new DecodeUrlEncodedResponseInterceptor());
        endpointInterceptors.add(new GetBucketPolicyInterceptor());
        endpointInterceptors.add(new AsyncChecksumValidationInterceptor());
        endpointInterceptors.add(new SyncChecksumValidationInterceptor());
        endpointInterceptors.add(new EnableTrailingChecksumInterceptor());
        endpointInterceptors.add(new ExceptionTranslationInterceptor());
        endpointInterceptors.add(new GetObjectInterceptor());
        endpointInterceptors.add(new ObjectMetadataInterceptor());
        ClasspathInterceptorChainFactory interceptorFactory = new ClasspathInterceptorChainFactory();
        List<ExecutionInterceptor> interceptors = interceptorFactory
                .getInterceptors("com/ibm/cloud/objectstorage/s3/execution.interceptors");
        List<ExecutionInterceptor> additionalInterceptors = new ArrayList<>();
        interceptors = CollectionUtils.mergeLists(endpointInterceptors, interceptors);
        interceptors = CollectionUtils.mergeLists(interceptors, additionalInterceptors);
        interceptors = CollectionUtils.mergeLists(interceptors, config.option(SdkClientOption.EXECUTION_INTERCEPTORS));
        S3Configuration.Builder serviceConfigBuilder = ((S3Configuration) config.option(SdkClientOption.SERVICE_CONFIGURATION))
                .toBuilder();
        serviceConfigBuilder.profileFile(serviceConfigBuilder.profileFileSupplier() != null ? serviceConfigBuilder
                .profileFileSupplier() : config.option(SdkClientOption.PROFILE_FILE_SUPPLIER));
        serviceConfigBuilder.profileName(serviceConfigBuilder.profileName() != null ? serviceConfigBuilder.profileName() : config
                .option(SdkClientOption.PROFILE_NAME));
        if (serviceConfigBuilder.dualstackEnabled() != null) {
            Validate.validState(
                    config.option(AwsClientOption.DUALSTACK_ENDPOINT_ENABLED) == null,
                    "Dualstack has been configured on both S3Configuration and the client/global level. Please limit dualstack configuration to one location.");
        } else {
            serviceConfigBuilder.dualstackEnabled(config.option(AwsClientOption.DUALSTACK_ENDPOINT_ENABLED));
        }
        if (serviceConfigBuilder.useArnRegionEnabled() != null) {
            Validate.validState(
                    clientContextParams.get(S3ClientContextParams.USE_ARN_REGION) == null,
                    "UseArnRegion has been configured on both S3Configuration and the client/global level. Please limit UseArnRegion configuration to one location.");
        } else {
            serviceConfigBuilder.useArnRegionEnabled(clientContextParams.get(S3ClientContextParams.USE_ARN_REGION));
        }
        if (serviceConfigBuilder.multiRegionEnabled() != null) {
            Validate.validState(
                    clientContextParams.get(S3ClientContextParams.DISABLE_MULTI_REGION_ACCESS_POINTS) == null,
                    "DisableMultiRegionAccessPoints has been configured on both S3Configuration and the client/global level. Please limit DisableMultiRegionAccessPoints configuration to one location.");
        } else if (clientContextParams.get(S3ClientContextParams.DISABLE_MULTI_REGION_ACCESS_POINTS) != null) {
            serviceConfigBuilder.multiRegionEnabled(!clientContextParams
                    .get(S3ClientContextParams.DISABLE_MULTI_REGION_ACCESS_POINTS));
        }
        if (serviceConfigBuilder.pathStyleAccessEnabled() != null) {
            Validate.validState(
                    clientContextParams.get(S3ClientContextParams.FORCE_PATH_STYLE) == null,
                    "ForcePathStyle has been configured on both S3Configuration and the client/global level. Please limit ForcePathStyle configuration to one location.");
        } else {
            serviceConfigBuilder.pathStyleAccessEnabled(clientContextParams.get(S3ClientContextParams.FORCE_PATH_STYLE));
        }
        if (serviceConfigBuilder.accelerateModeEnabled() != null) {
            Validate.validState(
                    clientContextParams.get(S3ClientContextParams.ACCELERATE) == null,
                    "Accelerate has been configured on both S3Configuration and the client/global level. Please limit Accelerate configuration to one location.");
        } else {
            serviceConfigBuilder.accelerateModeEnabled(clientContextParams.get(S3ClientContextParams.ACCELERATE));
        }
        Boolean checksumValidationEnabled = serviceConfigBuilder.checksumValidationEnabled();
        if (checksumValidationEnabled != null) {
            Validate.validState(
                    config.option(SdkClientOption.REQUEST_CHECKSUM_CALCULATION) == null,
                    "Checksum behavior has been configured on both S3Configuration and the client/global level. Please limit checksum behavior configuration to one location.");
            Validate.validState(
                    config.option(SdkClientOption.RESPONSE_CHECKSUM_VALIDATION) == null,
                    "Checksum behavior has been configured on both S3Configuration and the client/global level. Please limit checksum behavior configuration to one location.");
            if (checksumValidationEnabled) {
                config = config.toBuilder()
                        .option(SdkClientOption.REQUEST_CHECKSUM_CALCULATION, RequestChecksumCalculation.WHEN_SUPPORTED)
                        .option(SdkClientOption.RESPONSE_CHECKSUM_VALIDATION, ResponseChecksumValidation.WHEN_SUPPORTED).build();
            } else {
                config = config.toBuilder()
                        .option(SdkClientOption.REQUEST_CHECKSUM_CALCULATION, RequestChecksumCalculation.WHEN_REQUIRED)
                        .option(SdkClientOption.RESPONSE_CHECKSUM_VALIDATION, ResponseChecksumValidation.WHEN_REQUIRED).build();
            }
        }
        S3Configuration finalServiceConfig = serviceConfigBuilder.build();
        clientContextParams.put(S3ClientContextParams.USE_ARN_REGION, finalServiceConfig.useArnRegionEnabled());
        clientContextParams.put(S3ClientContextParams.DISABLE_MULTI_REGION_ACCESS_POINTS,
                !finalServiceConfig.multiRegionEnabled());
        clientContextParams.put(S3ClientContextParams.FORCE_PATH_STYLE, finalServiceConfig.pathStyleAccessEnabled());
        clientContextParams.put(S3ClientContextParams.ACCELERATE, finalServiceConfig.accelerateModeEnabled());
        UseGlobalEndpointResolver globalEndpointResolver = new UseGlobalEndpointResolver(config);
        UseS3ExpressAuthResolver useS3ExpressAuthResolver = new UseS3ExpressAuthResolver(config);
        if (clientContextParams.get(S3ClientContextParams.DISABLE_S3_EXPRESS_SESSION_AUTH) == null) {
            clientContextParams.put(S3ClientContextParams.DISABLE_S3_EXPRESS_SESSION_AUTH, !useS3ExpressAuthResolver.resolve());
        }
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
        builder.option(AwsClientOption.DUALSTACK_ENDPOINT_ENABLED, serviceConfigBuilder.dualstackEnabled());
        builder.option(SdkClientOption.SERVICE_CONFIGURATION, finalServiceConfig);
        builder.option(AwsClientOption.USE_GLOBAL_ENDPOINT,
                globalEndpointResolver.resolve(config.option(AwsClientOption.AWS_REGION)));
        builder.option(SdkClientOption.CLIENT_CONTEXT_PARAMS, clientContextParams.build());
        builder.lazyOptionIfAbsent(
                SdkClientOption.CLIENT_ENDPOINT_PROVIDER,
                c -> AwsClientEndpointProvider
                        .builder()
                        .serviceEndpointOverrideEnvironmentVariable("AWS_ENDPOINT_URL_S3")
                        .serviceEndpointOverrideSystemProperty("aws.endpointUrlS3")
                        .serviceProfileProperty("s3")
                        .serviceEndpointPrefix(serviceEndpointPrefix())
                        .defaultProtocol("https")
                        .region(c.get(AwsClientOption.AWS_REGION))
                        .profileFile(c.get(SdkClientOption.PROFILE_FILE_SUPPLIER))
                        .profileName(c.get(SdkClientOption.PROFILE_NAME))
                        .putAdvancedOption(ServiceMetadataAdvancedOption.DEFAULT_S3_US_EAST_1_REGIONAL_ENDPOINT,
                                c.get(ServiceMetadataAdvancedOption.DEFAULT_S3_US_EAST_1_REGIONAL_ENDPOINT))
                        .dualstackEnabled(c.get(AwsClientOption.DUALSTACK_ENDPOINT_ENABLED))
                        .fipsEnabled(c.get(AwsClientOption.FIPS_ENDPOINT_ENABLED)).build());
        SdkClientConfiguration clientConfig = config;
        builder.lazyOption(SdkClientOption.REQUEST_CHECKSUM_CALCULATION, c -> resolveRequestChecksumCalculation(clientConfig));
        builder.lazyOption(SdkClientOption.RESPONSE_CHECKSUM_VALIDATION, c -> resolveResponseChecksumValidation(clientConfig));
        return builder.build();
    }

    @Override
    protected final String signingName() {
        return "s3";
    }

    private S3EndpointProvider defaultEndpointProvider() {
        return S3EndpointProvider.defaultProvider();
    }

    public B authSchemeProvider(S3AuthSchemeProvider authSchemeProvider) {
        clientConfiguration.option(SdkClientOption.AUTH_SCHEME_PROVIDER, authSchemeProvider);
        return thisBuilder();
    }

    private S3AuthSchemeProvider defaultAuthSchemeProvider() {
        return S3AuthSchemeProvider.defaultProvider();
    }

    @Override
    public B putAuthScheme(AuthScheme<?> authScheme) {
        additionalAuthSchemes.put(authScheme.schemeId(), authScheme);
        return thisBuilder();
    }

    private Map<String, AuthScheme<?>> authSchemes() {
        Map<String, AuthScheme<?>> schemes = new HashMap<>(3 + this.additionalAuthSchemes.size());

        AwsV4AuthScheme awsV4AuthScheme = AwsV4AuthScheme.create();
        schemes.put(awsV4AuthScheme.schemeId(), awsV4AuthScheme);
        /*AwsV4aAuthScheme awsV4aAuthScheme = AwsV4aAuthScheme.create(); TODO:REMOVE
        schemes.put(awsV4aAuthScheme.schemeId(), awsV4aAuthScheme); */
        NoAuthAuthScheme noAuthAuthScheme = NoAuthAuthScheme.create();
        schemes.put(noAuthAuthScheme.schemeId(), noAuthAuthScheme);
        schemes.putAll(this.additionalAuthSchemes);
        return schemes;
    }

    public B requestChecksumCalculation(RequestChecksumCalculation requestChecksumCalculation) {
        clientConfiguration.option(SdkClientOption.REQUEST_CHECKSUM_CALCULATION, requestChecksumCalculation);
        return thisBuilder();
    }

    public B responseChecksumValidation(ResponseChecksumValidation responseChecksumValidation) {
        clientConfiguration.option(SdkClientOption.RESPONSE_CHECKSUM_VALIDATION, responseChecksumValidation);
        return thisBuilder();
    }

    public B accelerate(Boolean accelerate) {
        clientContextParams.put(S3ClientContextParams.ACCELERATE, accelerate);
        return thisBuilder();
    }

    public B disableMultiRegionAccessPoints(Boolean disableMultiRegionAccessPoints) {
        clientContextParams.put(S3ClientContextParams.DISABLE_MULTI_REGION_ACCESS_POINTS, disableMultiRegionAccessPoints);
        return thisBuilder();
    }

    public B disableS3ExpressSessionAuth(Boolean disableS3ExpressSessionAuth) {
        clientContextParams.put(S3ClientContextParams.DISABLE_S3_EXPRESS_SESSION_AUTH, disableS3ExpressSessionAuth);
        return thisBuilder();
    }

    public B forcePathStyle(Boolean forcePathStyle) {
        clientContextParams.put(S3ClientContextParams.FORCE_PATH_STYLE, forcePathStyle);
        return thisBuilder();
    }

    public B useArnRegion(Boolean useArnRegion) {
        clientContextParams.put(S3ClientContextParams.USE_ARN_REGION, useArnRegion);
        return thisBuilder();
    }

    public B crossRegionAccessEnabled(Boolean crossRegionAccessEnabled) {
        clientContextParams.put(S3ClientContextParams.CROSS_REGION_ACCESS_ENABLED, crossRegionAccessEnabled);
        return thisBuilder();
    }

    public B serviceConfiguration(S3Configuration serviceConfiguration) {
        clientConfiguration.option(SdkClientOption.SERVICE_CONFIGURATION, serviceConfiguration);
        return thisBuilder();
    }

    public void setServiceConfiguration(S3Configuration serviceConfiguration) {
        serviceConfiguration(serviceConfiguration);
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
        S3ServiceClientConfigurationBuilder serviceConfigBuilder = new S3ServiceClientConfigurationBuilder(configuration);
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
        List<SdkPlugin> internalPlugins = new ArrayList<>();
        internalPlugins.add(new S3DisableChunkEncodingIfConfiguredPlugin((config)));
        internalPlugins.add(new S3ExpressPlugin());
        return internalPlugins;
    }

    private RequestChecksumCalculation resolveRequestChecksumCalculation(SdkClientConfiguration config) {
        RequestChecksumCalculation configuredChecksumCalculation = config.option(SdkClientOption.REQUEST_CHECKSUM_CALCULATION);
        if (configuredChecksumCalculation == null) {
            configuredChecksumCalculation = RequestChecksumCalculationResolver.create()
                    .profileFile(config.option(SdkClientOption.PROFILE_FILE_SUPPLIER))
                    .profileName(config.option(SdkClientOption.PROFILE_NAME))
                    .defaultChecksumCalculation(RequestChecksumCalculation.WHEN_SUPPORTED).resolve();
        }
        return configuredChecksumCalculation;
    }

    private ResponseChecksumValidation resolveResponseChecksumValidation(SdkClientConfiguration config) {
        ResponseChecksumValidation configuredChecksumValidation = config.option(SdkClientOption.RESPONSE_CHECKSUM_VALIDATION);
        if (configuredChecksumValidation == null) {
            configuredChecksumValidation = ResponseChecksumValidationResolver.create()
                    .profileFile(config.option(SdkClientOption.PROFILE_FILE_SUPPLIER))
                    .profileName(config.option(SdkClientOption.PROFILE_NAME))
                    .defaultChecksumValidation(ResponseChecksumValidation.WHEN_SUPPORTED).resolve();
        }
        return configuredChecksumValidation;
    }

    protected static void validateClientOptions(SdkClientConfiguration c) {
    }

    public B sigv4aSigningRegionSet(RegionSet sigv4aSigningRegionSet) {
        clientConfiguration.option(AwsClientOption.AWS_SIGV4A_SIGNING_REGION_SET,
                sigv4aSigningRegionSet == null ? Collections.emptySet() : sigv4aSigningRegionSet.asSet());
        return thisBuilder();
    }
}
