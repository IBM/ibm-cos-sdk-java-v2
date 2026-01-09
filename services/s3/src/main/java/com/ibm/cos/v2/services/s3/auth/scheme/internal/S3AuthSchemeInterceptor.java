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

package com.ibm.cos.v2.services.s3.auth.scheme.internal;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import com.ibm.cos.v2.annotations.Generated;
import com.ibm.cos.v2.annotations.SdkInternalApi;
import com.ibm.cos.v2.awscore.AwsExecutionAttribute;
import com.ibm.cos.v2.core.SdkRequest;
import com.ibm.cos.v2.core.SelectedAuthScheme;
import com.ibm.cos.v2.core.exception.SdkException;
import com.ibm.cos.v2.core.identity.SdkIdentityProperty;
import com.ibm.cos.v2.core.interceptor.Context;
import com.ibm.cos.v2.core.interceptor.ExecutionAttributes;
import com.ibm.cos.v2.core.interceptor.ExecutionInterceptor;
import com.ibm.cos.v2.core.interceptor.SdkExecutionAttribute;
import com.ibm.cos.v2.core.interceptor.SdkInternalExecutionAttribute;
import com.ibm.cos.v2.core.internal.util.MetricUtils;
import com.ibm.cos.v2.core.metrics.CoreMetric;
import com.ibm.cos.v2.endpoints.EndpointProvider;
import com.ibm.cos.v2.http.auth.aws.signer.RegionSet;
import com.ibm.cos.v2.http.auth.spi.scheme.AuthScheme;
import com.ibm.cos.v2.http.auth.spi.scheme.AuthSchemeOption;
import com.ibm.cos.v2.http.auth.spi.signer.HttpSigner;
import com.ibm.cos.v2.identity.spi.AwsCredentialsIdentity;
import com.ibm.cos.v2.identity.spi.Identity;
import com.ibm.cos.v2.identity.spi.IdentityProvider;
import com.ibm.cos.v2.identity.spi.IdentityProviders;
import com.ibm.cos.v2.identity.spi.ResolveIdentityRequest;
import com.ibm.cos.v2.identity.spi.TokenIdentity;
import com.ibm.cos.v2.metrics.MetricCollector;
import com.ibm.cos.v2.metrics.SdkMetric;
import com.ibm.cos.v2.services.s3.auth.scheme.S3AuthSchemeParams;
import com.ibm.cos.v2.services.s3.auth.scheme.S3AuthSchemeProvider;
import com.ibm.cos.v2.services.s3.endpoints.S3EndpointParams;
import com.ibm.cos.v2.services.s3.endpoints.S3EndpointProvider;
import com.ibm.cos.v2.services.s3.endpoints.internal.S3ResolveEndpointInterceptor;
import com.ibm.cos.v2.utils.CollectionUtils;
import com.ibm.cos.v2.utils.Logger;
import com.ibm.cos.v2.utils.Validate;

@Generated("com.ibm.cos.v2:codegen")
@SdkInternalApi
public final class S3AuthSchemeInterceptor implements ExecutionInterceptor {
    private static Logger LOG = Logger.loggerFor(S3AuthSchemeInterceptor.class);

    @Override
    public void beforeExecution(Context.BeforeExecution context, ExecutionAttributes executionAttributes) {
        List<AuthSchemeOption> authOptions = resolveAuthOptions(context, executionAttributes);
        SelectedAuthScheme<? extends Identity> selectedAuthScheme = selectAuthScheme(authOptions, executionAttributes);
        putSelectedAuthScheme(executionAttributes, selectedAuthScheme);
    }

    private List<AuthSchemeOption> resolveAuthOptions(Context.BeforeExecution context, ExecutionAttributes executionAttributes) {
        S3AuthSchemeProvider authSchemeProvider = Validate.isInstanceOf(S3AuthSchemeProvider.class,
                executionAttributes.getAttribute(SdkInternalExecutionAttribute.AUTH_SCHEME_RESOLVER),
                "Expected an instance of S3AuthSchemeProvider");
        S3AuthSchemeParams params = authSchemeParams(context.request(), executionAttributes);
        return authSchemeProvider.resolveAuthScheme(params);
    }

    private SelectedAuthScheme<? extends Identity> selectAuthScheme(List<AuthSchemeOption> authOptions,
            ExecutionAttributes executionAttributes) {
        MetricCollector metricCollector = executionAttributes.getAttribute(SdkExecutionAttribute.API_CALL_METRIC_COLLECTOR);
        Map<String, AuthScheme<?>> authSchemes = executionAttributes.getAttribute(SdkInternalExecutionAttribute.AUTH_SCHEMES);
        IdentityProviders identityProviders = executionAttributes.getAttribute(SdkInternalExecutionAttribute.IDENTITY_PROVIDERS);
        List<Supplier<String>> discardedReasons = new ArrayList<>();
        for (AuthSchemeOption authOption : authOptions) {
            AuthScheme<?> authScheme = authSchemes.get(authOption.schemeId());
            SelectedAuthScheme<? extends Identity> selectedAuthScheme = trySelectAuthScheme(authOption, authScheme,
                    identityProviders, discardedReasons, metricCollector, executionAttributes);
            if (selectedAuthScheme != null) {
                if (!discardedReasons.isEmpty()) {
                    LOG.debug(() -> String.format("%s auth will be used, discarded: '%s'", authOption.schemeId(),
                            discardedReasons.stream().map(Supplier::get).collect(Collectors.joining(", "))));
                }
                return selectedAuthScheme;
            }
        }
        throw SdkException
                .builder()
                .message(
                        "Failed to determine how to authenticate the user: "
                                + discardedReasons.stream().map(Supplier::get).collect(Collectors.joining(", "))).build();
    }

    private S3AuthSchemeParams authSchemeParams(SdkRequest request, ExecutionAttributes executionAttributes) {
        S3EndpointParams endpointParams = S3ResolveEndpointInterceptor.ruleParams(request, executionAttributes);
        S3AuthSchemeParams.Builder builder = S3AuthSchemeParams.builder();
        builder.bucket(endpointParams.bucket());
        builder.region(endpointParams.region());
        builder.useFips(endpointParams.useFips());
        builder.useDualStack(endpointParams.useDualStack());
        builder.endpoint(endpointParams.endpoint());
        builder.forcePathStyle(endpointParams.forcePathStyle());
        builder.accelerate(endpointParams.accelerate());
        builder.useGlobalEndpoint(endpointParams.useGlobalEndpoint());
        builder.useObjectLambdaEndpoint(endpointParams.useObjectLambdaEndpoint());
        builder.key(endpointParams.key());
        builder.prefix(endpointParams.prefix());
        builder.copySource(endpointParams.copySource());
        builder.disableAccessPoints(endpointParams.disableAccessPoints());
        builder.disableMultiRegionAccessPoints(endpointParams.disableMultiRegionAccessPoints());
        builder.useArnRegion(endpointParams.useArnRegion());
        builder.useS3ExpressControlEndpoint(endpointParams.useS3ExpressControlEndpoint());
        builder.disableS3ExpressSessionAuth(endpointParams.disableS3ExpressSessionAuth());
        builder.deleteObjectKeys(endpointParams.deleteObjectKeys());
        String operation = executionAttributes.getAttribute(SdkExecutionAttribute.OPERATION_NAME);
        builder.operation(operation);
        executionAttributes.getOptionalAttribute(AwsExecutionAttribute.AWS_SIGV4A_SIGNING_REGION_SET)
                .filter(regionSet -> !CollectionUtils.isNullOrEmpty(regionSet))
                .ifPresent(nonEmptyRegionSet -> builder.regionSet(RegionSet.create(nonEmptyRegionSet)));
        if (builder instanceof S3EndpointResolverAware.Builder) {
            EndpointProvider endpointProvider = executionAttributes.getAttribute(SdkInternalExecutionAttribute.ENDPOINT_PROVIDER);
            if (endpointProvider instanceof S3EndpointProvider) {
                ((S3EndpointResolverAware.Builder) builder).endpointProvider((S3EndpointProvider) endpointProvider);
            }
        }
        return builder.build();
    }

    private <T extends Identity> SelectedAuthScheme<T> trySelectAuthScheme(AuthSchemeOption authOption, AuthScheme<T> authScheme,
            IdentityProviders identityProviders, List<Supplier<String>> discardedReasons, MetricCollector metricCollector,
            ExecutionAttributes executionAttributes) {
        if (authScheme == null) {
            discardedReasons.add(() -> String.format("'%s' is not enabled for this request.", authOption.schemeId()));
            return null;
        }
        IdentityProvider<T> identityProvider = authScheme.identityProvider(identityProviders);
        if (identityProvider == null) {
            discardedReasons
                    .add(() -> String.format("'%s' does not have an identity provider configured.", authOption.schemeId()));
            return null;
        }
        HttpSigner<T> signer;
        try {
            signer = authScheme.signer();
        } catch (RuntimeException e) {
            discardedReasons.add(() -> String.format("'%s' signer could not be retrieved: %s", authOption.schemeId(),
                    e.getMessage()));
            return null;
        }
        ResolveIdentityRequest.Builder identityRequestBuilder = ResolveIdentityRequest.builder();
        authOption.forEachIdentityProperty(identityRequestBuilder::putProperty);
        identityRequestBuilder.putProperty(SdkIdentityProperty.SDK_CLIENT,
                executionAttributes.getAttribute(SdkInternalExecutionAttribute.SDK_CLIENT));
        CompletableFuture<? extends T> identity;
        SdkMetric<Duration> metric = getIdentityMetric(identityProvider);
        if (metric == null) {
            identity = identityProvider.resolveIdentity(identityRequestBuilder.build());
        } else {
            identity = MetricUtils.reportDuration(() -> identityProvider.resolveIdentity(identityRequestBuilder.build()),
                    metricCollector, metric);
        }
        return new SelectedAuthScheme<>(identity, signer, authOption);
    }

    private SdkMetric<Duration> getIdentityMetric(IdentityProvider<?> identityProvider) {
        Class<?> identityType = identityProvider.identityType();
        if (identityType == AwsCredentialsIdentity.class) {
            return CoreMetric.CREDENTIALS_FETCH_DURATION;
        }
        if (identityType == TokenIdentity.class) {
            return CoreMetric.TOKEN_FETCH_DURATION;
        }
        return null;
    }

    private <T extends Identity> void putSelectedAuthScheme(ExecutionAttributes attributes,
            SelectedAuthScheme<T> selectedAuthScheme) {
        SelectedAuthScheme<?> existingAuthScheme = attributes.getAttribute(SdkInternalExecutionAttribute.SELECTED_AUTH_SCHEME);
        if (existingAuthScheme != null) {
            AuthSchemeOption.Builder selectedOption = selectedAuthScheme.authSchemeOption().toBuilder();
            existingAuthScheme.authSchemeOption().forEachIdentityProperty(selectedOption::putIdentityPropertyIfAbsent);
            existingAuthScheme.authSchemeOption().forEachSignerProperty(selectedOption::putSignerPropertyIfAbsent);
            selectedAuthScheme = new SelectedAuthScheme<>(selectedAuthScheme.identity(), selectedAuthScheme.signer(),
                    selectedOption.build());
        }
        attributes.putAttribute(SdkInternalExecutionAttribute.SELECTED_AUTH_SCHEME, selectedAuthScheme);
    }
}
