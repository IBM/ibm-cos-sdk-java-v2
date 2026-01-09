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

package com.ibm.cos.v2.services.kms.endpoints.internal;

import java.time.Duration;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletionException;
import com.ibm.cos.v2.annotations.Generated;
import com.ibm.cos.v2.annotations.SdkInternalApi;
import com.ibm.cos.v2.awscore.AwsExecutionAttribute;
import com.ibm.cos.v2.awscore.endpoints.AwsEndpointAttribute;
import com.ibm.cos.v2.awscore.endpoints.authscheme.EndpointAuthScheme;
import com.ibm.cos.v2.awscore.endpoints.authscheme.SigV4AuthScheme;
import com.ibm.cos.v2.awscore.endpoints.authscheme.SigV4aAuthScheme;
import com.ibm.cos.v2.core.SdkRequest;
import com.ibm.cos.v2.core.SelectedAuthScheme;
import com.ibm.cos.v2.core.exception.SdkClientException;
import com.ibm.cos.v2.core.interceptor.Context;
import com.ibm.cos.v2.core.interceptor.ExecutionAttributes;
import com.ibm.cos.v2.core.interceptor.ExecutionInterceptor;
import com.ibm.cos.v2.core.interceptor.SdkExecutionAttribute;
import com.ibm.cos.v2.core.interceptor.SdkInternalExecutionAttribute;
import com.ibm.cos.v2.core.metrics.CoreMetric;
import com.ibm.cos.v2.endpoints.Endpoint;
import com.ibm.cos.v2.http.SdkHttpRequest;
import com.ibm.cos.v2.http.auth.aws.signer.AwsV4HttpSigner;
//import com.ibm.cos.v2.http.auth.aws.signer.AwsV4aHttpSigner; TODO:REMOVE
import com.ibm.cos.v2.http.auth.aws.signer.RegionSet;
import com.ibm.cos.v2.http.auth.spi.scheme.AuthSchemeOption;
import com.ibm.cos.v2.identity.spi.Identity;
import com.ibm.cos.v2.metrics.MetricCollector;
import com.ibm.cos.v2.services.kms.endpoints.KmsEndpointParams;
import com.ibm.cos.v2.services.kms.endpoints.KmsEndpointProvider;
import com.ibm.cos.v2.utils.CollectionUtils;

@Generated("com.ibm.cos.v2:codegen")
@SdkInternalApi
public final class KmsResolveEndpointInterceptor implements ExecutionInterceptor {
    @Override
    public SdkRequest modifyRequest(Context.ModifyRequest context, ExecutionAttributes executionAttributes) {
        SdkRequest result = context.request();
        if (AwsEndpointProviderUtils.endpointIsDiscovered(executionAttributes)) {
            return result;
        }
        KmsEndpointProvider provider = (KmsEndpointProvider) executionAttributes
                .getAttribute(SdkInternalExecutionAttribute.ENDPOINT_PROVIDER);
        try {
            long resolveEndpointStart = System.nanoTime();
            KmsEndpointParams endpointParams = ruleParams(result, executionAttributes);
            Endpoint endpoint = provider.resolveEndpoint(endpointParams).join();
            Duration resolveEndpointDuration = Duration.ofNanos(System.nanoTime() - resolveEndpointStart);
            Optional<MetricCollector> metricCollector = executionAttributes
                    .getOptionalAttribute(SdkExecutionAttribute.API_CALL_METRIC_COLLECTOR);
            metricCollector.ifPresent(mc -> mc.reportMetric(CoreMetric.ENDPOINT_RESOLVE_DURATION, resolveEndpointDuration));
            if (!AwsEndpointProviderUtils.disableHostPrefixInjection(executionAttributes)) {
                Optional<String> hostPrefix = hostPrefix(executionAttributes.getAttribute(SdkExecutionAttribute.OPERATION_NAME),
                        result);
                if (hostPrefix.isPresent()) {
                    endpoint = AwsEndpointProviderUtils.addHostPrefix(endpoint, hostPrefix.get());
                }
            }
            List<EndpointAuthScheme> endpointAuthSchemes = endpoint.attribute(AwsEndpointAttribute.AUTH_SCHEMES);
            SelectedAuthScheme<?> selectedAuthScheme = executionAttributes
                    .getAttribute(SdkInternalExecutionAttribute.SELECTED_AUTH_SCHEME);
            if (endpointAuthSchemes != null && selectedAuthScheme != null) {
                selectedAuthScheme = authSchemeWithEndpointSignerProperties(endpointAuthSchemes, selectedAuthScheme);
                executionAttributes.putAttribute(SdkInternalExecutionAttribute.SELECTED_AUTH_SCHEME, selectedAuthScheme);
            }
            executionAttributes.putAttribute(SdkInternalExecutionAttribute.RESOLVED_ENDPOINT, endpoint);
            return result;
        } catch (CompletionException e) {
            Throwable cause = e.getCause();
            if (cause instanceof SdkClientException) {
                throw (SdkClientException) cause;
            } else {
                throw SdkClientException.create("Endpoint resolution failed", cause);
            }
        }
    }

    @Override
    public SdkHttpRequest modifyHttpRequest(Context.ModifyHttpRequest context, ExecutionAttributes executionAttributes) {
        Endpoint resolvedEndpoint = executionAttributes.getAttribute(SdkInternalExecutionAttribute.RESOLVED_ENDPOINT);
        if (resolvedEndpoint.headers().isEmpty()) {
            return context.httpRequest();
        }
        SdkHttpRequest.Builder httpRequestBuilder = context.httpRequest().toBuilder();
        resolvedEndpoint.headers().forEach((name, values) -> {
            values.forEach(v -> httpRequestBuilder.appendHeader(name, v));
        });
        return httpRequestBuilder.build();
    }

    public static KmsEndpointParams ruleParams(SdkRequest request, ExecutionAttributes executionAttributes) {
        KmsEndpointParams.Builder builder = KmsEndpointParams.builder();
        builder.region(AwsEndpointProviderUtils.regionBuiltIn(executionAttributes));
        builder.useDualStack(AwsEndpointProviderUtils.dualStackEnabledBuiltIn(executionAttributes));
        builder.useFips(AwsEndpointProviderUtils.fipsEnabledBuiltIn(executionAttributes));
        builder.endpoint(AwsEndpointProviderUtils.endpointBuiltIn(executionAttributes));
        setContextParams(builder, executionAttributes.getAttribute(AwsExecutionAttribute.OPERATION_NAME), request);
        setStaticContextParams(builder, executionAttributes.getAttribute(AwsExecutionAttribute.OPERATION_NAME));
        setOperationContextParams(builder, executionAttributes.getAttribute(AwsExecutionAttribute.OPERATION_NAME), request);
        return builder.build();
    }

    private static void setContextParams(KmsEndpointParams.Builder params, String operationName, SdkRequest request) {
    }

    private static void setStaticContextParams(KmsEndpointParams.Builder params, String operationName) {
    }

    private <T extends Identity> SelectedAuthScheme<T> authSchemeWithEndpointSignerProperties(
            List<EndpointAuthScheme> endpointAuthSchemes, SelectedAuthScheme<T> selectedAuthScheme) {
        for (EndpointAuthScheme endpointAuthScheme : endpointAuthSchemes) {
            if (!endpointAuthScheme.schemeId().equals(selectedAuthScheme.authSchemeOption().schemeId())) {
                continue;
            }
            AuthSchemeOption.Builder option = selectedAuthScheme.authSchemeOption().toBuilder();
            if (endpointAuthScheme instanceof SigV4AuthScheme) {
                SigV4AuthScheme v4AuthScheme = (SigV4AuthScheme) endpointAuthScheme;
                if (v4AuthScheme.isDisableDoubleEncodingSet()) {
                    option.putSignerProperty(AwsV4HttpSigner.DOUBLE_URL_ENCODE, !v4AuthScheme.disableDoubleEncoding());
                }
                if (v4AuthScheme.signingRegion() != null) {
                    option.putSignerProperty(AwsV4HttpSigner.REGION_NAME, v4AuthScheme.signingRegion());
                }
                if (v4AuthScheme.signingName() != null) {
                    option.putSignerProperty(AwsV4HttpSigner.SERVICE_SIGNING_NAME, v4AuthScheme.signingName());
                }
                return new SelectedAuthScheme<>(selectedAuthScheme.identity(), selectedAuthScheme.signer(), option.build());
            }
            /*if (endpointAuthScheme instanceof SigV4aAuthScheme) { TODO:REMOVE
                SigV4aAuthScheme v4aAuthScheme = (SigV4aAuthScheme) endpointAuthScheme;
                if (v4aAuthScheme.isDisableDoubleEncodingSet()) {
                    option.putSignerProperty(AwsV4aHttpSigner.DOUBLE_URL_ENCODE, !v4aAuthScheme.disableDoubleEncoding());
                }
                if (!CollectionUtils.isNullOrEmpty(v4aAuthScheme.signingRegionSet())) {
                    RegionSet regionSet = RegionSet.create(v4aAuthScheme.signingRegionSet());
                    option.putSignerProperty(AwsV4aHttpSigner.REGION_SET, regionSet);
                }
                if (v4aAuthScheme.signingName() != null) {
                    option.putSignerProperty(AwsV4aHttpSigner.SERVICE_SIGNING_NAME, v4aAuthScheme.signingName());
                }
                return new SelectedAuthScheme<>(selectedAuthScheme.identity(), selectedAuthScheme.signer(), option.build());
            }*/
            throw new IllegalArgumentException("Endpoint auth scheme '" + endpointAuthScheme.name()
                    + "' cannot be mapped to the SDK auth scheme. Was it declared in the service's model?");
        }
        return selectedAuthScheme;
    }

    private static void setOperationContextParams(KmsEndpointParams.Builder params, String operationName, SdkRequest request) {
    }

    private static Optional<String> hostPrefix(String operationName, SdkRequest request) {
        return Optional.empty();
    }
}
