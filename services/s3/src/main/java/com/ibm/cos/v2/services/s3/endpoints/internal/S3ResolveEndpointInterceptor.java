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

package com.ibm.cos.v2.services.s3.endpoints.internal;

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
//import com.ibm.cos.v2.http.auth.aws.scheme.AwsV4aAuthScheme; TODO:REMOVE
import com.ibm.cos.v2.http.auth.aws.signer.AwsV4HttpSigner;
//import com.ibm.cos.v2.http.auth.aws.signer.AwsV4aHttpSigner; TODO:REMOVE
import com.ibm.cos.v2.http.auth.aws.signer.RegionSet;
import com.ibm.cos.v2.http.auth.spi.scheme.AuthSchemeOption;
import com.ibm.cos.v2.identity.spi.Identity;
import com.ibm.cos.v2.metrics.MetricCollector;
import com.ibm.cos.v2.services.s3.endpoints.S3ClientContextParams;
import com.ibm.cos.v2.services.s3.endpoints.S3EndpointParams;
import com.ibm.cos.v2.services.s3.endpoints.S3EndpointProvider;
import com.ibm.cos.v2.services.s3.endpoints.authscheme.S3ExpressEndpointAuthScheme;
import com.ibm.cos.v2.services.s3.jmespath.internal.JmesPathRuntime;
import com.ibm.cos.v2.services.s3.model.AbortMultipartUploadRequest;
import com.ibm.cos.v2.services.s3.model.CompleteMultipartUploadRequest;
import com.ibm.cos.v2.services.s3.model.CopyObjectRequest;
import com.ibm.cos.v2.services.s3.model.CreateBucketMetadataTableConfigurationRequest;
import com.ibm.cos.v2.services.s3.model.CreateBucketRequest;
import com.ibm.cos.v2.services.s3.model.CreateMultipartUploadRequest;
import com.ibm.cos.v2.services.s3.model.CreateSessionRequest;
import com.ibm.cos.v2.services.s3.model.DeleteBucketAnalyticsConfigurationRequest;
import com.ibm.cos.v2.services.s3.model.DeleteBucketCorsRequest;
import com.ibm.cos.v2.services.s3.model.DeleteBucketEncryptionRequest;
import com.ibm.cos.v2.services.s3.model.DeleteBucketIntelligentTieringConfigurationRequest;
import com.ibm.cos.v2.services.s3.model.DeleteBucketInventoryConfigurationRequest;
import com.ibm.cos.v2.services.s3.model.DeleteBucketLifecycleRequest;
import com.ibm.cos.v2.services.s3.model.DeleteBucketMetadataTableConfigurationRequest;
import com.ibm.cos.v2.services.s3.model.DeleteBucketMetricsConfigurationRequest;
import com.ibm.cos.v2.services.s3.model.DeleteBucketOwnershipControlsRequest;
import com.ibm.cos.v2.services.s3.model.DeleteBucketPolicyRequest;
import com.ibm.cos.v2.services.s3.model.DeleteBucketReplicationRequest;
import com.ibm.cos.v2.services.s3.model.DeleteBucketRequest;
import com.ibm.cos.v2.services.s3.model.DeleteBucketTaggingRequest;
import com.ibm.cos.v2.services.s3.model.DeleteBucketWebsiteRequest;
import com.ibm.cos.v2.services.s3.model.DeleteObjectRequest;
import com.ibm.cos.v2.services.s3.model.DeleteObjectTaggingRequest;
import com.ibm.cos.v2.services.s3.model.DeleteObjectsRequest;
import com.ibm.cos.v2.services.s3.model.DeletePublicAccessBlockRequest;
import com.ibm.cos.v2.services.s3.model.GetBucketAccelerateConfigurationRequest;
import com.ibm.cos.v2.services.s3.model.GetBucketAclRequest;
import com.ibm.cos.v2.services.s3.model.GetBucketAnalyticsConfigurationRequest;
import com.ibm.cos.v2.services.s3.model.GetBucketCorsRequest;
import com.ibm.cos.v2.services.s3.model.GetBucketEncryptionRequest;
import com.ibm.cos.v2.services.s3.model.GetBucketIntelligentTieringConfigurationRequest;
import com.ibm.cos.v2.services.s3.model.GetBucketInventoryConfigurationRequest;
import com.ibm.cos.v2.services.s3.model.GetBucketLifecycleConfigurationRequest;
import com.ibm.cos.v2.services.s3.model.GetBucketLocationRequest;
import com.ibm.cos.v2.services.s3.model.GetBucketLoggingRequest;
import com.ibm.cos.v2.services.s3.model.GetBucketMetadataTableConfigurationRequest;
import com.ibm.cos.v2.services.s3.model.GetBucketMetricsConfigurationRequest;
import com.ibm.cos.v2.services.s3.model.GetBucketNotificationConfigurationRequest;
import com.ibm.cos.v2.services.s3.model.GetBucketOwnershipControlsRequest;
import com.ibm.cos.v2.services.s3.model.GetBucketPolicyRequest;
import com.ibm.cos.v2.services.s3.model.GetBucketPolicyStatusRequest;
import com.ibm.cos.v2.services.s3.model.GetBucketReplicationRequest;
import com.ibm.cos.v2.services.s3.model.GetBucketRequestPaymentRequest;
import com.ibm.cos.v2.services.s3.model.GetBucketTaggingRequest;
import com.ibm.cos.v2.services.s3.model.GetBucketVersioningRequest;
import com.ibm.cos.v2.services.s3.model.GetBucketWebsiteRequest;
import com.ibm.cos.v2.services.s3.model.GetObjectAclRequest;
import com.ibm.cos.v2.services.s3.model.GetObjectAttributesRequest;
import com.ibm.cos.v2.services.s3.model.GetObjectLegalHoldRequest;
import com.ibm.cos.v2.services.s3.model.GetObjectLockConfigurationRequest;
import com.ibm.cos.v2.services.s3.model.GetObjectRequest;
import com.ibm.cos.v2.services.s3.model.GetObjectRetentionRequest;
import com.ibm.cos.v2.services.s3.model.GetObjectTaggingRequest;
import com.ibm.cos.v2.services.s3.model.GetObjectTorrentRequest;
import com.ibm.cos.v2.services.s3.model.GetPublicAccessBlockRequest;
import com.ibm.cos.v2.services.s3.model.HeadBucketRequest;
import com.ibm.cos.v2.services.s3.model.HeadObjectRequest;
import com.ibm.cos.v2.services.s3.model.ListBucketAnalyticsConfigurationsRequest;
import com.ibm.cos.v2.services.s3.model.ListBucketIntelligentTieringConfigurationsRequest;
import com.ibm.cos.v2.services.s3.model.ListBucketInventoryConfigurationsRequest;
import com.ibm.cos.v2.services.s3.model.ListBucketMetricsConfigurationsRequest;
import com.ibm.cos.v2.services.s3.model.ListMultipartUploadsRequest;
import com.ibm.cos.v2.services.s3.model.ListObjectVersionsRequest;
import com.ibm.cos.v2.services.s3.model.ListObjectsRequest;
import com.ibm.cos.v2.services.s3.model.ListObjectsV2Request;
import com.ibm.cos.v2.services.s3.model.ListPartsRequest;
import com.ibm.cos.v2.services.s3.model.PutBucketAccelerateConfigurationRequest;
import com.ibm.cos.v2.services.s3.model.PutBucketAclRequest;
import com.ibm.cos.v2.services.s3.model.PutBucketAnalyticsConfigurationRequest;
import com.ibm.cos.v2.services.s3.model.PutBucketCorsRequest;
import com.ibm.cos.v2.services.s3.model.PutBucketEncryptionRequest;
import com.ibm.cos.v2.services.s3.model.PutBucketIntelligentTieringConfigurationRequest;
import com.ibm.cos.v2.services.s3.model.PutBucketInventoryConfigurationRequest;
import com.ibm.cos.v2.services.s3.model.PutBucketLifecycleConfigurationRequest;
import com.ibm.cos.v2.services.s3.model.PutBucketLoggingRequest;
import com.ibm.cos.v2.services.s3.model.PutBucketMetricsConfigurationRequest;
import com.ibm.cos.v2.services.s3.model.PutBucketNotificationConfigurationRequest;
import com.ibm.cos.v2.services.s3.model.PutBucketOwnershipControlsRequest;
import com.ibm.cos.v2.services.s3.model.PutBucketPolicyRequest;
import com.ibm.cos.v2.services.s3.model.PutBucketReplicationRequest;
import com.ibm.cos.v2.services.s3.model.PutBucketRequestPaymentRequest;
import com.ibm.cos.v2.services.s3.model.PutBucketTaggingRequest;
import com.ibm.cos.v2.services.s3.model.PutBucketVersioningRequest;
import com.ibm.cos.v2.services.s3.model.PutBucketWebsiteRequest;
import com.ibm.cos.v2.services.s3.model.PutObjectAclRequest;
import com.ibm.cos.v2.services.s3.model.PutObjectLegalHoldRequest;
import com.ibm.cos.v2.services.s3.model.PutObjectLockConfigurationRequest;
import com.ibm.cos.v2.services.s3.model.PutObjectRequest;
import com.ibm.cos.v2.services.s3.model.PutObjectRetentionRequest;
import com.ibm.cos.v2.services.s3.model.PutObjectTaggingRequest;
import com.ibm.cos.v2.services.s3.model.PutPublicAccessBlockRequest;
import com.ibm.cos.v2.services.s3.model.RestoreObjectRequest;
import com.ibm.cos.v2.services.s3.model.SelectObjectContentRequest;
import com.ibm.cos.v2.services.s3.model.UploadPartCopyRequest;
import com.ibm.cos.v2.services.s3.model.UploadPartRequest;
import com.ibm.cos.v2.utils.AttributeMap;
import com.ibm.cos.v2.utils.CollectionUtils;
import com.ibm.cos.v2.utils.HostnameValidator;

@Generated("com.ibm.cos.v2:codegen")
@SdkInternalApi
public final class S3ResolveEndpointInterceptor implements ExecutionInterceptor {
    @Override
    public SdkRequest modifyRequest(Context.ModifyRequest context, ExecutionAttributes executionAttributes) {
        SdkRequest result = context.request();
        if (AwsEndpointProviderUtils.endpointIsDiscovered(executionAttributes)) {
            return result;
        }
        S3EndpointProvider provider = (S3EndpointProvider) executionAttributes
                .getAttribute(SdkInternalExecutionAttribute.ENDPOINT_PROVIDER);
        try {
            long resolveEndpointStart = System.nanoTime();
            S3EndpointParams endpointParams = ruleParams(result, executionAttributes);
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
                // Precedence of SigV4a RegionSet is set according to multi-auth SigV4a specifications
               /* if (selectedAuthScheme.authSchemeOption().schemeId().equals(AwsV4aAuthScheme.SCHEME_ID) TODO:REMOVE
                        && selectedAuthScheme.authSchemeOption().signerProperty(AwsV4aHttpSigner.REGION_SET) == null) {
                    AuthSchemeOption.Builder optionBuilder = selectedAuthScheme.authSchemeOption().toBuilder();
                    RegionSet regionSet = RegionSet.create(endpointParams.region().id());
                    optionBuilder.putSignerProperty(AwsV4aHttpSigner.REGION_SET, regionSet);
                    selectedAuthScheme = new SelectedAuthScheme(selectedAuthScheme.identity(), selectedAuthScheme.signer(),
                            optionBuilder.build());
                }*/
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

    public static S3EndpointParams ruleParams(SdkRequest request, ExecutionAttributes executionAttributes) {
        S3EndpointParams.Builder builder = S3EndpointParams.builder();
        builder.region(AwsEndpointProviderUtils.regionBuiltIn(executionAttributes));
        builder.useFips(AwsEndpointProviderUtils.fipsEnabledBuiltIn(executionAttributes));
        builder.useDualStack(AwsEndpointProviderUtils.dualStackEnabledBuiltIn(executionAttributes));
        builder.endpoint(AwsEndpointProviderUtils.endpointBuiltIn(executionAttributes));
        builder.useGlobalEndpoint(executionAttributes.getAttribute(AwsExecutionAttribute.USE_GLOBAL_ENDPOINT));
        setClientContextParams(builder, executionAttributes);
        setContextParams(builder, executionAttributes.getAttribute(AwsExecutionAttribute.OPERATION_NAME), request);
        setStaticContextParams(builder, executionAttributes.getAttribute(AwsExecutionAttribute.OPERATION_NAME));
        setOperationContextParams(builder, executionAttributes.getAttribute(AwsExecutionAttribute.OPERATION_NAME), request);
        return builder.build();
    }

    private static void setContextParams(S3EndpointParams.Builder params, String operationName, SdkRequest request) {
        switch (operationName) {
        case "AbortMultipartUpload":
            setContextParams(params, (AbortMultipartUploadRequest) request);
            break;
        case "CompleteMultipartUpload":
            setContextParams(params, (CompleteMultipartUploadRequest) request);
            break;
        case "CopyObject":
            setContextParams(params, (CopyObjectRequest) request);
            break;
        case "CreateBucket":
            setContextParams(params, (CreateBucketRequest) request);
            break;
        case "CreateBucketMetadataTableConfiguration":
            setContextParams(params, (CreateBucketMetadataTableConfigurationRequest) request);
            break;
        case "CreateMultipartUpload":
            setContextParams(params, (CreateMultipartUploadRequest) request);
            break;
        case "CreateSession":
            setContextParams(params, (CreateSessionRequest) request);
            break;
        case "DeleteBucket":
            setContextParams(params, (DeleteBucketRequest) request);
            break;
        case "DeleteBucketAnalyticsConfiguration":
            setContextParams(params, (DeleteBucketAnalyticsConfigurationRequest) request);
            break;
        case "DeleteBucketCors":
            setContextParams(params, (DeleteBucketCorsRequest) request);
            break;
        case "DeleteBucketEncryption":
            setContextParams(params, (DeleteBucketEncryptionRequest) request);
            break;
        case "DeleteBucketIntelligentTieringConfiguration":
            setContextParams(params, (DeleteBucketIntelligentTieringConfigurationRequest) request);
            break;
        case "DeleteBucketInventoryConfiguration":
            setContextParams(params, (DeleteBucketInventoryConfigurationRequest) request);
            break;
        case "DeleteBucketLifecycle":
            setContextParams(params, (DeleteBucketLifecycleRequest) request);
            break;
        case "DeleteBucketMetadataTableConfiguration":
            setContextParams(params, (DeleteBucketMetadataTableConfigurationRequest) request);
            break;
        case "DeleteBucketMetricsConfiguration":
            setContextParams(params, (DeleteBucketMetricsConfigurationRequest) request);
            break;
        case "DeleteBucketOwnershipControls":
            setContextParams(params, (DeleteBucketOwnershipControlsRequest) request);
            break;
        case "DeleteBucketPolicy":
            setContextParams(params, (DeleteBucketPolicyRequest) request);
            break;
        case "DeleteBucketReplication":
            setContextParams(params, (DeleteBucketReplicationRequest) request);
            break;
        case "DeleteBucketTagging":
            setContextParams(params, (DeleteBucketTaggingRequest) request);
            break;
        case "DeleteBucketWebsite":
            setContextParams(params, (DeleteBucketWebsiteRequest) request);
            break;
        case "DeleteObject":
            setContextParams(params, (DeleteObjectRequest) request);
            break;
        case "DeleteObjectTagging":
            setContextParams(params, (DeleteObjectTaggingRequest) request);
            break;
        case "DeleteObjects":
            setContextParams(params, (DeleteObjectsRequest) request);
            break;
        case "DeletePublicAccessBlock":
            setContextParams(params, (DeletePublicAccessBlockRequest) request);
            break;
        case "GetBucketAccelerateConfiguration":
            setContextParams(params, (GetBucketAccelerateConfigurationRequest) request);
            break;
        case "GetBucketAcl":
            setContextParams(params, (GetBucketAclRequest) request);
            break;
        case "GetBucketAnalyticsConfiguration":
            setContextParams(params, (GetBucketAnalyticsConfigurationRequest) request);
            break;
        case "GetBucketCors":
            setContextParams(params, (GetBucketCorsRequest) request);
            break;
        case "GetBucketEncryption":
            setContextParams(params, (GetBucketEncryptionRequest) request);
            break;
        case "GetBucketIntelligentTieringConfiguration":
            setContextParams(params, (GetBucketIntelligentTieringConfigurationRequest) request);
            break;
        case "GetBucketInventoryConfiguration":
            setContextParams(params, (GetBucketInventoryConfigurationRequest) request);
            break;
        case "GetBucketLifecycleConfiguration":
            setContextParams(params, (GetBucketLifecycleConfigurationRequest) request);
            break;
        case "GetBucketLocation":
            setContextParams(params, (GetBucketLocationRequest) request);
            break;
        case "GetBucketLogging":
            setContextParams(params, (GetBucketLoggingRequest) request);
            break;
        case "GetBucketMetadataTableConfiguration":
            setContextParams(params, (GetBucketMetadataTableConfigurationRequest) request);
            break;
        case "GetBucketMetricsConfiguration":
            setContextParams(params, (GetBucketMetricsConfigurationRequest) request);
            break;
        case "GetBucketNotificationConfiguration":
            setContextParams(params, (GetBucketNotificationConfigurationRequest) request);
            break;
        case "GetBucketOwnershipControls":
            setContextParams(params, (GetBucketOwnershipControlsRequest) request);
            break;
        case "GetBucketPolicy":
            setContextParams(params, (GetBucketPolicyRequest) request);
            break;
        case "GetBucketPolicyStatus":
            setContextParams(params, (GetBucketPolicyStatusRequest) request);
            break;
        case "GetBucketReplication":
            setContextParams(params, (GetBucketReplicationRequest) request);
            break;
        case "GetBucketRequestPayment":
            setContextParams(params, (GetBucketRequestPaymentRequest) request);
            break;
        case "GetBucketTagging":
            setContextParams(params, (GetBucketTaggingRequest) request);
            break;
        case "GetBucketVersioning":
            setContextParams(params, (GetBucketVersioningRequest) request);
            break;
        case "GetBucketWebsite":
            setContextParams(params, (GetBucketWebsiteRequest) request);
            break;
        case "GetObject":
            setContextParams(params, (GetObjectRequest) request);
            break;
        case "GetObjectAcl":
            setContextParams(params, (GetObjectAclRequest) request);
            break;
        case "GetObjectAttributes":
            setContextParams(params, (GetObjectAttributesRequest) request);
            break;
        case "GetObjectLegalHold":
            setContextParams(params, (GetObjectLegalHoldRequest) request);
            break;
        case "GetObjectLockConfiguration":
            setContextParams(params, (GetObjectLockConfigurationRequest) request);
            break;
        case "GetObjectRetention":
            setContextParams(params, (GetObjectRetentionRequest) request);
            break;
        case "GetObjectTagging":
            setContextParams(params, (GetObjectTaggingRequest) request);
            break;
        case "GetObjectTorrent":
            setContextParams(params, (GetObjectTorrentRequest) request);
            break;
        case "GetPublicAccessBlock":
            setContextParams(params, (GetPublicAccessBlockRequest) request);
            break;
        case "HeadBucket":
            setContextParams(params, (HeadBucketRequest) request);
            break;
        case "HeadObject":
            setContextParams(params, (HeadObjectRequest) request);
            break;
        case "ListBucketAnalyticsConfigurations":
            setContextParams(params, (ListBucketAnalyticsConfigurationsRequest) request);
            break;
        case "ListBucketIntelligentTieringConfigurations":
            setContextParams(params, (ListBucketIntelligentTieringConfigurationsRequest) request);
            break;
        case "ListBucketInventoryConfigurations":
            setContextParams(params, (ListBucketInventoryConfigurationsRequest) request);
            break;
        case "ListBucketMetricsConfigurations":
            setContextParams(params, (ListBucketMetricsConfigurationsRequest) request);
            break;
        case "ListMultipartUploads":
            setContextParams(params, (ListMultipartUploadsRequest) request);
            break;
        case "ListObjectVersions":
            setContextParams(params, (ListObjectVersionsRequest) request);
            break;
        case "ListObjects":
            setContextParams(params, (ListObjectsRequest) request);
            break;
        case "ListObjectsV2":
            setContextParams(params, (ListObjectsV2Request) request);
            break;
        case "ListParts":
            setContextParams(params, (ListPartsRequest) request);
            break;
        case "PutBucketAccelerateConfiguration":
            setContextParams(params, (PutBucketAccelerateConfigurationRequest) request);
            break;
        case "PutBucketAcl":
            setContextParams(params, (PutBucketAclRequest) request);
            break;
        case "PutBucketAnalyticsConfiguration":
            setContextParams(params, (PutBucketAnalyticsConfigurationRequest) request);
            break;
        case "PutBucketCors":
            setContextParams(params, (PutBucketCorsRequest) request);
            break;
        case "PutBucketEncryption":
            setContextParams(params, (PutBucketEncryptionRequest) request);
            break;
        case "PutBucketIntelligentTieringConfiguration":
            setContextParams(params, (PutBucketIntelligentTieringConfigurationRequest) request);
            break;
        case "PutBucketInventoryConfiguration":
            setContextParams(params, (PutBucketInventoryConfigurationRequest) request);
            break;
        case "PutBucketLifecycleConfiguration":
            setContextParams(params, (PutBucketLifecycleConfigurationRequest) request);
            break;
        case "PutBucketLogging":
            setContextParams(params, (PutBucketLoggingRequest) request);
            break;
        case "PutBucketMetricsConfiguration":
            setContextParams(params, (PutBucketMetricsConfigurationRequest) request);
            break;
        case "PutBucketNotificationConfiguration":
            setContextParams(params, (PutBucketNotificationConfigurationRequest) request);
            break;
        case "PutBucketOwnershipControls":
            setContextParams(params, (PutBucketOwnershipControlsRequest) request);
            break;
        case "PutBucketPolicy":
            setContextParams(params, (PutBucketPolicyRequest) request);
            break;
        case "PutBucketReplication":
            setContextParams(params, (PutBucketReplicationRequest) request);
            break;
        case "PutBucketRequestPayment":
            setContextParams(params, (PutBucketRequestPaymentRequest) request);
            break;
        case "PutBucketTagging":
            setContextParams(params, (PutBucketTaggingRequest) request);
            break;
        case "PutBucketVersioning":
            setContextParams(params, (PutBucketVersioningRequest) request);
            break;
        case "PutBucketWebsite":
            setContextParams(params, (PutBucketWebsiteRequest) request);
            break;
        case "PutObject":
            setContextParams(params, (PutObjectRequest) request);
            break;
        case "PutObjectAcl":
            setContextParams(params, (PutObjectAclRequest) request);
            break;
        case "PutObjectLegalHold":
            setContextParams(params, (PutObjectLegalHoldRequest) request);
            break;
        case "PutObjectLockConfiguration":
            setContextParams(params, (PutObjectLockConfigurationRequest) request);
            break;
        case "PutObjectRetention":
            setContextParams(params, (PutObjectRetentionRequest) request);
            break;
        case "PutObjectTagging":
            setContextParams(params, (PutObjectTaggingRequest) request);
            break;
        case "PutPublicAccessBlock":
            setContextParams(params, (PutPublicAccessBlockRequest) request);
            break;
        case "RestoreObject":
            setContextParams(params, (RestoreObjectRequest) request);
            break;
        case "SelectObjectContent":
            setContextParams(params, (SelectObjectContentRequest) request);
            break;
        case "UploadPart":
            setContextParams(params, (UploadPartRequest) request);
            break;
        case "UploadPartCopy":
            setContextParams(params, (UploadPartCopyRequest) request);
            break;
        default:
            break;
        }
    }

    private static void setContextParams(S3EndpointParams.Builder params, AbortMultipartUploadRequest request) {
        params.bucket(request.bucket());
        params.key(request.key());
    }

    private static void setContextParams(S3EndpointParams.Builder params, CompleteMultipartUploadRequest request) {
        params.bucket(request.bucket());
        params.key(request.key());
    }

    private static void setContextParams(S3EndpointParams.Builder params, CopyObjectRequest request) {
        params.copySource(request.copySource());
        params.bucket(request.destinationBucket());
        params.key(request.destinationKey());
    }

    private static void setContextParams(S3EndpointParams.Builder params, CreateBucketRequest request) {
        params.bucket(request.bucket());
    }

    private static void setContextParams(S3EndpointParams.Builder params, CreateBucketMetadataTableConfigurationRequest request) {
        params.bucket(request.bucket());
    }

    private static void setContextParams(S3EndpointParams.Builder params, CreateMultipartUploadRequest request) {
        params.bucket(request.bucket());
        params.key(request.key());
    }

    private static void setContextParams(S3EndpointParams.Builder params, CreateSessionRequest request) {
        params.bucket(request.bucket());
    }

    private static void setContextParams(S3EndpointParams.Builder params, DeleteBucketRequest request) {
        params.bucket(request.bucket());
    }

    private static void setContextParams(S3EndpointParams.Builder params, DeleteBucketAnalyticsConfigurationRequest request) {
        params.bucket(request.bucket());
    }

    private static void setContextParams(S3EndpointParams.Builder params, DeleteBucketCorsRequest request) {
        params.bucket(request.bucket());
    }

    private static void setContextParams(S3EndpointParams.Builder params, DeleteBucketEncryptionRequest request) {
        params.bucket(request.bucket());
    }

    private static void setContextParams(S3EndpointParams.Builder params,
            DeleteBucketIntelligentTieringConfigurationRequest request) {
        params.bucket(request.bucket());
    }

    private static void setContextParams(S3EndpointParams.Builder params, DeleteBucketInventoryConfigurationRequest request) {
        params.bucket(request.bucket());
    }

    private static void setContextParams(S3EndpointParams.Builder params, DeleteBucketLifecycleRequest request) {
        params.bucket(request.bucket());
    }

    private static void setContextParams(S3EndpointParams.Builder params, DeleteBucketMetadataTableConfigurationRequest request) {
        params.bucket(request.bucket());
    }

    private static void setContextParams(S3EndpointParams.Builder params, DeleteBucketMetricsConfigurationRequest request) {
        params.bucket(request.bucket());
    }

    private static void setContextParams(S3EndpointParams.Builder params, DeleteBucketOwnershipControlsRequest request) {
        params.bucket(request.bucket());
    }

    private static void setContextParams(S3EndpointParams.Builder params, DeleteBucketPolicyRequest request) {
        params.bucket(request.bucket());
    }

    private static void setContextParams(S3EndpointParams.Builder params, DeleteBucketReplicationRequest request) {
        params.bucket(request.bucket());
    }

    private static void setContextParams(S3EndpointParams.Builder params, DeleteBucketTaggingRequest request) {
        params.bucket(request.bucket());
    }

    private static void setContextParams(S3EndpointParams.Builder params, DeleteBucketWebsiteRequest request) {
        params.bucket(request.bucket());
    }

    private static void setContextParams(S3EndpointParams.Builder params, DeleteObjectRequest request) {
        params.bucket(request.bucket());
        params.key(request.key());
    }

    private static void setContextParams(S3EndpointParams.Builder params, DeleteObjectTaggingRequest request) {
        params.bucket(request.bucket());
    }

    private static void setContextParams(S3EndpointParams.Builder params, DeleteObjectsRequest request) {
        params.bucket(request.bucket());
    }

    private static void setContextParams(S3EndpointParams.Builder params, DeletePublicAccessBlockRequest request) {
        params.bucket(request.bucket());
    }

    private static void setContextParams(S3EndpointParams.Builder params, GetBucketAccelerateConfigurationRequest request) {
        params.bucket(request.bucket());
    }

    private static void setContextParams(S3EndpointParams.Builder params, GetBucketAclRequest request) {
        params.bucket(request.bucket());
    }

    private static void setContextParams(S3EndpointParams.Builder params, GetBucketAnalyticsConfigurationRequest request) {
        params.bucket(request.bucket());
    }

    private static void setContextParams(S3EndpointParams.Builder params, GetBucketCorsRequest request) {
        params.bucket(request.bucket());
    }

    private static void setContextParams(S3EndpointParams.Builder params, GetBucketEncryptionRequest request) {
        params.bucket(request.bucket());
    }

    private static void setContextParams(S3EndpointParams.Builder params, GetBucketIntelligentTieringConfigurationRequest request) {
        params.bucket(request.bucket());
    }

    private static void setContextParams(S3EndpointParams.Builder params, GetBucketInventoryConfigurationRequest request) {
        params.bucket(request.bucket());
    }

    private static void setContextParams(S3EndpointParams.Builder params, GetBucketLifecycleConfigurationRequest request) {
        params.bucket(request.bucket());
    }

    private static void setContextParams(S3EndpointParams.Builder params, GetBucketLocationRequest request) {
        params.bucket(request.bucket());
    }

    private static void setContextParams(S3EndpointParams.Builder params, GetBucketLoggingRequest request) {
        params.bucket(request.bucket());
    }

    private static void setContextParams(S3EndpointParams.Builder params, GetBucketMetadataTableConfigurationRequest request) {
        params.bucket(request.bucket());
    }

    private static void setContextParams(S3EndpointParams.Builder params, GetBucketMetricsConfigurationRequest request) {
        params.bucket(request.bucket());
    }

    private static void setContextParams(S3EndpointParams.Builder params, GetBucketNotificationConfigurationRequest request) {
        params.bucket(request.bucket());
    }

    private static void setContextParams(S3EndpointParams.Builder params, GetBucketOwnershipControlsRequest request) {
        params.bucket(request.bucket());
    }

    private static void setContextParams(S3EndpointParams.Builder params, GetBucketPolicyRequest request) {
        params.bucket(request.bucket());
    }

    private static void setContextParams(S3EndpointParams.Builder params, GetBucketPolicyStatusRequest request) {
        params.bucket(request.bucket());
    }

    private static void setContextParams(S3EndpointParams.Builder params, GetBucketReplicationRequest request) {
        params.bucket(request.bucket());
    }

    private static void setContextParams(S3EndpointParams.Builder params, GetBucketRequestPaymentRequest request) {
        params.bucket(request.bucket());
    }

    private static void setContextParams(S3EndpointParams.Builder params, GetBucketTaggingRequest request) {
        params.bucket(request.bucket());
    }

    private static void setContextParams(S3EndpointParams.Builder params, GetBucketVersioningRequest request) {
        params.bucket(request.bucket());
    }

    private static void setContextParams(S3EndpointParams.Builder params, GetBucketWebsiteRequest request) {
        params.bucket(request.bucket());
    }

    private static void setContextParams(S3EndpointParams.Builder params, GetObjectRequest request) {
        params.bucket(request.bucket());
        params.key(request.key());
    }

    private static void setContextParams(S3EndpointParams.Builder params, GetObjectAclRequest request) {
        params.bucket(request.bucket());
        params.key(request.key());
    }

    private static void setContextParams(S3EndpointParams.Builder params, GetObjectAttributesRequest request) {
        params.bucket(request.bucket());
    }

    private static void setContextParams(S3EndpointParams.Builder params, GetObjectLegalHoldRequest request) {
        params.bucket(request.bucket());
    }

    private static void setContextParams(S3EndpointParams.Builder params, GetObjectLockConfigurationRequest request) {
        params.bucket(request.bucket());
    }

    private static void setContextParams(S3EndpointParams.Builder params, GetObjectRetentionRequest request) {
        params.bucket(request.bucket());
    }

    private static void setContextParams(S3EndpointParams.Builder params, GetObjectTaggingRequest request) {
        params.bucket(request.bucket());
    }

    private static void setContextParams(S3EndpointParams.Builder params, GetObjectTorrentRequest request) {
        params.bucket(request.bucket());
    }

    private static void setContextParams(S3EndpointParams.Builder params, GetPublicAccessBlockRequest request) {
        params.bucket(request.bucket());
    }

    private static void setContextParams(S3EndpointParams.Builder params, HeadBucketRequest request) {
        params.bucket(request.bucket());
    }

    private static void setContextParams(S3EndpointParams.Builder params, HeadObjectRequest request) {
        params.bucket(request.bucket());
        params.key(request.key());
    }

    private static void setContextParams(S3EndpointParams.Builder params, ListBucketAnalyticsConfigurationsRequest request) {
        params.bucket(request.bucket());
    }

    private static void setContextParams(S3EndpointParams.Builder params,
            ListBucketIntelligentTieringConfigurationsRequest request) {
        params.bucket(request.bucket());
    }

    private static void setContextParams(S3EndpointParams.Builder params, ListBucketInventoryConfigurationsRequest request) {
        params.bucket(request.bucket());
    }

    private static void setContextParams(S3EndpointParams.Builder params, ListBucketMetricsConfigurationsRequest request) {
        params.bucket(request.bucket());
    }

    private static void setContextParams(S3EndpointParams.Builder params, ListMultipartUploadsRequest request) {
        params.bucket(request.bucket());
        params.prefix(request.prefix());
    }

    private static void setContextParams(S3EndpointParams.Builder params, ListObjectVersionsRequest request) {
        params.bucket(request.bucket());
        params.prefix(request.prefix());
    }

    private static void setContextParams(S3EndpointParams.Builder params, ListObjectsRequest request) {
        params.bucket(request.bucket());
        params.prefix(request.prefix());
    }

    private static void setContextParams(S3EndpointParams.Builder params, ListObjectsV2Request request) {
        params.bucket(request.bucket());
        params.prefix(request.prefix());
    }

    private static void setContextParams(S3EndpointParams.Builder params, ListPartsRequest request) {
        params.bucket(request.bucket());
        params.key(request.key());
    }

    private static void setContextParams(S3EndpointParams.Builder params, PutBucketAccelerateConfigurationRequest request) {
        params.bucket(request.bucket());
    }

    private static void setContextParams(S3EndpointParams.Builder params, PutBucketAclRequest request) {
        params.bucket(request.bucket());
    }

    private static void setContextParams(S3EndpointParams.Builder params, PutBucketAnalyticsConfigurationRequest request) {
        params.bucket(request.bucket());
    }

    private static void setContextParams(S3EndpointParams.Builder params, PutBucketCorsRequest request) {
        params.bucket(request.bucket());
    }

    private static void setContextParams(S3EndpointParams.Builder params, PutBucketEncryptionRequest request) {
        params.bucket(request.bucket());
    }

    private static void setContextParams(S3EndpointParams.Builder params, PutBucketIntelligentTieringConfigurationRequest request) {
        params.bucket(request.bucket());
    }

    private static void setContextParams(S3EndpointParams.Builder params, PutBucketInventoryConfigurationRequest request) {
        params.bucket(request.bucket());
    }

    private static void setContextParams(S3EndpointParams.Builder params, PutBucketLifecycleConfigurationRequest request) {
        params.bucket(request.bucket());
    }

    private static void setContextParams(S3EndpointParams.Builder params, PutBucketLoggingRequest request) {
        params.bucket(request.bucket());
    }

    private static void setContextParams(S3EndpointParams.Builder params, PutBucketMetricsConfigurationRequest request) {
        params.bucket(request.bucket());
    }

    private static void setContextParams(S3EndpointParams.Builder params, PutBucketNotificationConfigurationRequest request) {
        params.bucket(request.bucket());
    }

    private static void setContextParams(S3EndpointParams.Builder params, PutBucketOwnershipControlsRequest request) {
        params.bucket(request.bucket());
    }

    private static void setContextParams(S3EndpointParams.Builder params, PutBucketPolicyRequest request) {
        params.bucket(request.bucket());
    }

    private static void setContextParams(S3EndpointParams.Builder params, PutBucketReplicationRequest request) {
        params.bucket(request.bucket());
    }

    private static void setContextParams(S3EndpointParams.Builder params, PutBucketRequestPaymentRequest request) {
        params.bucket(request.bucket());
    }

    private static void setContextParams(S3EndpointParams.Builder params, PutBucketTaggingRequest request) {
        params.bucket(request.bucket());
    }

    private static void setContextParams(S3EndpointParams.Builder params, PutBucketVersioningRequest request) {
        params.bucket(request.bucket());
    }

    private static void setContextParams(S3EndpointParams.Builder params, PutBucketWebsiteRequest request) {
        params.bucket(request.bucket());
    }

    private static void setContextParams(S3EndpointParams.Builder params, PutObjectRequest request) {
        params.bucket(request.bucket());
        params.key(request.key());
    }

    private static void setContextParams(S3EndpointParams.Builder params, PutObjectAclRequest request) {
        params.bucket(request.bucket());
        params.key(request.key());
    }

    private static void setContextParams(S3EndpointParams.Builder params, PutObjectLegalHoldRequest request) {
        params.bucket(request.bucket());
    }

    private static void setContextParams(S3EndpointParams.Builder params, PutObjectLockConfigurationRequest request) {
        params.bucket(request.bucket());
    }

    private static void setContextParams(S3EndpointParams.Builder params, PutObjectRetentionRequest request) {
        params.bucket(request.bucket());
    }

    private static void setContextParams(S3EndpointParams.Builder params, PutObjectTaggingRequest request) {
        params.bucket(request.bucket());
    }

    private static void setContextParams(S3EndpointParams.Builder params, PutPublicAccessBlockRequest request) {
        params.bucket(request.bucket());
    }

    private static void setContextParams(S3EndpointParams.Builder params, RestoreObjectRequest request) {
        params.bucket(request.bucket());
    }

    private static void setContextParams(S3EndpointParams.Builder params, SelectObjectContentRequest request) {
        params.bucket(request.bucket());
    }

    private static void setContextParams(S3EndpointParams.Builder params, UploadPartRequest request) {
        params.bucket(request.bucket());
        params.key(request.key());
    }

    private static void setContextParams(S3EndpointParams.Builder params, UploadPartCopyRequest request) {
        params.bucket(request.destinationBucket());
    }

    private static void setStaticContextParams(S3EndpointParams.Builder params, String operationName) {
        switch (operationName) {
        case "CopyObject":
            copyObjectStaticContextParams(params);
            break;
        case "CreateBucket":
            createBucketStaticContextParams(params);
            break;
        case "CreateBucketMetadataTableConfiguration":
            createBucketMetadataTableConfigurationStaticContextParams(params);
            break;
        case "CreateSession":
            createSessionStaticContextParams(params);
            break;
        case "DeleteBucket":
            deleteBucketStaticContextParams(params);
            break;
        case "DeleteBucketAnalyticsConfiguration":
            deleteBucketAnalyticsConfigurationStaticContextParams(params);
            break;
        case "DeleteBucketCors":
            deleteBucketCorsStaticContextParams(params);
            break;
        case "DeleteBucketEncryption":
            deleteBucketEncryptionStaticContextParams(params);
            break;
        case "DeleteBucketIntelligentTieringConfiguration":
            deleteBucketIntelligentTieringConfigurationStaticContextParams(params);
            break;
        case "DeleteBucketInventoryConfiguration":
            deleteBucketInventoryConfigurationStaticContextParams(params);
            break;
        case "DeleteBucketLifecycle":
            deleteBucketLifecycleStaticContextParams(params);
            break;
        case "DeleteBucketMetadataTableConfiguration":
            deleteBucketMetadataTableConfigurationStaticContextParams(params);
            break;
        case "DeleteBucketMetricsConfiguration":
            deleteBucketMetricsConfigurationStaticContextParams(params);
            break;
        case "DeleteBucketOwnershipControls":
            deleteBucketOwnershipControlsStaticContextParams(params);
            break;
        case "DeleteBucketPolicy":
            deleteBucketPolicyStaticContextParams(params);
            break;
        case "DeleteBucketReplication":
            deleteBucketReplicationStaticContextParams(params);
            break;
        case "DeleteBucketTagging":
            deleteBucketTaggingStaticContextParams(params);
            break;
        case "DeleteBucketWebsite":
            deleteBucketWebsiteStaticContextParams(params);
            break;
        case "DeletePublicAccessBlock":
            deletePublicAccessBlockStaticContextParams(params);
            break;
        case "GetBucketAccelerateConfiguration":
            getBucketAccelerateConfigurationStaticContextParams(params);
            break;
        case "GetBucketAcl":
            getBucketAclStaticContextParams(params);
            break;
        case "GetBucketAnalyticsConfiguration":
            getBucketAnalyticsConfigurationStaticContextParams(params);
            break;
        case "GetBucketCors":
            getBucketCorsStaticContextParams(params);
            break;
        case "GetBucketEncryption":
            getBucketEncryptionStaticContextParams(params);
            break;
        case "GetBucketIntelligentTieringConfiguration":
            getBucketIntelligentTieringConfigurationStaticContextParams(params);
            break;
        case "GetBucketInventoryConfiguration":
            getBucketInventoryConfigurationStaticContextParams(params);
            break;
        case "GetBucketLifecycleConfiguration":
            getBucketLifecycleConfigurationStaticContextParams(params);
            break;
        case "GetBucketLocation":
            getBucketLocationStaticContextParams(params);
            break;
        case "GetBucketLogging":
            getBucketLoggingStaticContextParams(params);
            break;
        case "GetBucketMetadataTableConfiguration":
            getBucketMetadataTableConfigurationStaticContextParams(params);
            break;
        case "GetBucketMetricsConfiguration":
            getBucketMetricsConfigurationStaticContextParams(params);
            break;
        case "GetBucketNotificationConfiguration":
            getBucketNotificationConfigurationStaticContextParams(params);
            break;
        case "GetBucketOwnershipControls":
            getBucketOwnershipControlsStaticContextParams(params);
            break;
        case "GetBucketPolicy":
            getBucketPolicyStaticContextParams(params);
            break;
        case "GetBucketPolicyStatus":
            getBucketPolicyStatusStaticContextParams(params);
            break;
        case "GetBucketReplication":
            getBucketReplicationStaticContextParams(params);
            break;
        case "GetBucketRequestPayment":
            getBucketRequestPaymentStaticContextParams(params);
            break;
        case "GetBucketTagging":
            getBucketTaggingStaticContextParams(params);
            break;
        case "GetBucketVersioning":
            getBucketVersioningStaticContextParams(params);
            break;
        case "GetBucketWebsite":
            getBucketWebsiteStaticContextParams(params);
            break;
        case "GetPublicAccessBlock":
            getPublicAccessBlockStaticContextParams(params);
            break;
        case "ListBucketAnalyticsConfigurations":
            listBucketAnalyticsConfigurationsStaticContextParams(params);
            break;
        case "ListBucketIntelligentTieringConfigurations":
            listBucketIntelligentTieringConfigurationsStaticContextParams(params);
            break;
        case "ListBucketInventoryConfigurations":
            listBucketInventoryConfigurationsStaticContextParams(params);
            break;
        case "ListDirectoryBuckets":
            listDirectoryBucketsStaticContextParams(params);
            break;
        case "PutBucketAccelerateConfiguration":
            putBucketAccelerateConfigurationStaticContextParams(params);
            break;
        case "PutBucketAcl":
            putBucketAclStaticContextParams(params);
            break;
        case "PutBucketAnalyticsConfiguration":
            putBucketAnalyticsConfigurationStaticContextParams(params);
            break;
        case "PutBucketCors":
            putBucketCorsStaticContextParams(params);
            break;
        case "PutBucketEncryption":
            putBucketEncryptionStaticContextParams(params);
            break;
        case "PutBucketIntelligentTieringConfiguration":
            putBucketIntelligentTieringConfigurationStaticContextParams(params);
            break;
        case "PutBucketInventoryConfiguration":
            putBucketInventoryConfigurationStaticContextParams(params);
            break;
        case "PutBucketLifecycleConfiguration":
            putBucketLifecycleConfigurationStaticContextParams(params);
            break;
        case "PutBucketLogging":
            putBucketLoggingStaticContextParams(params);
            break;
        case "PutBucketMetricsConfiguration":
            putBucketMetricsConfigurationStaticContextParams(params);
            break;
        case "PutBucketNotificationConfiguration":
            putBucketNotificationConfigurationStaticContextParams(params);
            break;
        case "PutBucketOwnershipControls":
            putBucketOwnershipControlsStaticContextParams(params);
            break;
        case "PutBucketPolicy":
            putBucketPolicyStaticContextParams(params);
            break;
        case "PutBucketReplication":
            putBucketReplicationStaticContextParams(params);
            break;
        case "PutBucketRequestPayment":
            putBucketRequestPaymentStaticContextParams(params);
            break;
        case "PutBucketTagging":
            putBucketTaggingStaticContextParams(params);
            break;
        case "PutBucketVersioning":
            putBucketVersioningStaticContextParams(params);
            break;
        case "PutBucketWebsite":
            putBucketWebsiteStaticContextParams(params);
            break;
        case "PutPublicAccessBlock":
            putPublicAccessBlockStaticContextParams(params);
            break;
        case "UploadPartCopy":
            uploadPartCopyStaticContextParams(params);
            break;
        case "WriteGetObjectResponse":
            writeGetObjectResponseStaticContextParams(params);
            break;
        default:
            break;
        }
    }

    private static void copyObjectStaticContextParams(S3EndpointParams.Builder params) {
        params.disableS3ExpressSessionAuth(true);
    }

    private static void createBucketStaticContextParams(S3EndpointParams.Builder params) {
        params.disableAccessPoints(true);
        params.useS3ExpressControlEndpoint(true);
    }

    private static void createBucketMetadataTableConfigurationStaticContextParams(S3EndpointParams.Builder params) {
        params.useS3ExpressControlEndpoint(true);
    }

    private static void createSessionStaticContextParams(S3EndpointParams.Builder params) {
        params.disableS3ExpressSessionAuth(true);
    }

    private static void deleteBucketStaticContextParams(S3EndpointParams.Builder params) {
        params.useS3ExpressControlEndpoint(true);
    }

    private static void deleteBucketAnalyticsConfigurationStaticContextParams(S3EndpointParams.Builder params) {
        params.useS3ExpressControlEndpoint(true);
    }

    private static void deleteBucketCorsStaticContextParams(S3EndpointParams.Builder params) {
        params.useS3ExpressControlEndpoint(true);
    }

    private static void deleteBucketEncryptionStaticContextParams(S3EndpointParams.Builder params) {
        params.useS3ExpressControlEndpoint(true);
    }

    private static void deleteBucketIntelligentTieringConfigurationStaticContextParams(S3EndpointParams.Builder params) {
        params.useS3ExpressControlEndpoint(true);
    }

    private static void deleteBucketInventoryConfigurationStaticContextParams(S3EndpointParams.Builder params) {
        params.useS3ExpressControlEndpoint(true);
    }

    private static void deleteBucketLifecycleStaticContextParams(S3EndpointParams.Builder params) {
        params.useS3ExpressControlEndpoint(true);
    }

    private static void deleteBucketMetadataTableConfigurationStaticContextParams(S3EndpointParams.Builder params) {
        params.useS3ExpressControlEndpoint(true);
    }

    private static void deleteBucketMetricsConfigurationStaticContextParams(S3EndpointParams.Builder params) {
        params.useS3ExpressControlEndpoint(true);
    }

    private static void deleteBucketOwnershipControlsStaticContextParams(S3EndpointParams.Builder params) {
        params.useS3ExpressControlEndpoint(true);
    }

    private static void deleteBucketPolicyStaticContextParams(S3EndpointParams.Builder params) {
        params.useS3ExpressControlEndpoint(true);
    }

    private static void deleteBucketReplicationStaticContextParams(S3EndpointParams.Builder params) {
        params.useS3ExpressControlEndpoint(true);
    }

    private static void deleteBucketTaggingStaticContextParams(S3EndpointParams.Builder params) {
        params.useS3ExpressControlEndpoint(true);
    }

    private static void deleteBucketWebsiteStaticContextParams(S3EndpointParams.Builder params) {
        params.useS3ExpressControlEndpoint(true);
    }

    private static void deletePublicAccessBlockStaticContextParams(S3EndpointParams.Builder params) {
        params.useS3ExpressControlEndpoint(true);
    }

    private static void getBucketAccelerateConfigurationStaticContextParams(S3EndpointParams.Builder params) {
        params.useS3ExpressControlEndpoint(true);
    }

    private static void getBucketAclStaticContextParams(S3EndpointParams.Builder params) {
        params.useS3ExpressControlEndpoint(true);
    }

    private static void getBucketAnalyticsConfigurationStaticContextParams(S3EndpointParams.Builder params) {
        params.useS3ExpressControlEndpoint(true);
    }

    private static void getBucketCorsStaticContextParams(S3EndpointParams.Builder params) {
        params.useS3ExpressControlEndpoint(true);
    }

    private static void getBucketEncryptionStaticContextParams(S3EndpointParams.Builder params) {
        params.useS3ExpressControlEndpoint(true);
    }

    private static void getBucketIntelligentTieringConfigurationStaticContextParams(S3EndpointParams.Builder params) {
        params.useS3ExpressControlEndpoint(true);
    }

    private static void getBucketInventoryConfigurationStaticContextParams(S3EndpointParams.Builder params) {
        params.useS3ExpressControlEndpoint(true);
    }

    private static void getBucketLifecycleConfigurationStaticContextParams(S3EndpointParams.Builder params) {
        params.useS3ExpressControlEndpoint(true);
    }

    private static void getBucketLocationStaticContextParams(S3EndpointParams.Builder params) {
        params.useS3ExpressControlEndpoint(true);
    }

    private static void getBucketLoggingStaticContextParams(S3EndpointParams.Builder params) {
        params.useS3ExpressControlEndpoint(true);
    }

    private static void getBucketMetadataTableConfigurationStaticContextParams(S3EndpointParams.Builder params) {
        params.useS3ExpressControlEndpoint(true);
    }

    private static void getBucketMetricsConfigurationStaticContextParams(S3EndpointParams.Builder params) {
        params.useS3ExpressControlEndpoint(true);
    }

    private static void getBucketNotificationConfigurationStaticContextParams(S3EndpointParams.Builder params) {
        params.useS3ExpressControlEndpoint(true);
    }

    private static void getBucketOwnershipControlsStaticContextParams(S3EndpointParams.Builder params) {
        params.useS3ExpressControlEndpoint(true);
    }

    private static void getBucketPolicyStaticContextParams(S3EndpointParams.Builder params) {
        params.useS3ExpressControlEndpoint(true);
    }

    private static void getBucketPolicyStatusStaticContextParams(S3EndpointParams.Builder params) {
        params.useS3ExpressControlEndpoint(true);
    }

    private static void getBucketReplicationStaticContextParams(S3EndpointParams.Builder params) {
        params.useS3ExpressControlEndpoint(true);
    }

    private static void getBucketRequestPaymentStaticContextParams(S3EndpointParams.Builder params) {
        params.useS3ExpressControlEndpoint(true);
    }

    private static void getBucketTaggingStaticContextParams(S3EndpointParams.Builder params) {
        params.useS3ExpressControlEndpoint(true);
    }

    private static void getBucketVersioningStaticContextParams(S3EndpointParams.Builder params) {
        params.useS3ExpressControlEndpoint(true);
    }

    private static void getBucketWebsiteStaticContextParams(S3EndpointParams.Builder params) {
        params.useS3ExpressControlEndpoint(true);
    }

    private static void getPublicAccessBlockStaticContextParams(S3EndpointParams.Builder params) {
        params.useS3ExpressControlEndpoint(true);
    }

    private static void listBucketAnalyticsConfigurationsStaticContextParams(S3EndpointParams.Builder params) {
        params.useS3ExpressControlEndpoint(true);
    }

    private static void listBucketIntelligentTieringConfigurationsStaticContextParams(S3EndpointParams.Builder params) {
        params.useS3ExpressControlEndpoint(true);
    }

    private static void listBucketInventoryConfigurationsStaticContextParams(S3EndpointParams.Builder params) {
        params.useS3ExpressControlEndpoint(true);
    }

    private static void listDirectoryBucketsStaticContextParams(S3EndpointParams.Builder params) {
        params.useS3ExpressControlEndpoint(true);
    }

    private static void putBucketAccelerateConfigurationStaticContextParams(S3EndpointParams.Builder params) {
        params.useS3ExpressControlEndpoint(true);
    }

    private static void putBucketAclStaticContextParams(S3EndpointParams.Builder params) {
        params.useS3ExpressControlEndpoint(true);
    }

    private static void putBucketAnalyticsConfigurationStaticContextParams(S3EndpointParams.Builder params) {
        params.useS3ExpressControlEndpoint(true);
    }

    private static void putBucketCorsStaticContextParams(S3EndpointParams.Builder params) {
        params.useS3ExpressControlEndpoint(true);
    }

    private static void putBucketEncryptionStaticContextParams(S3EndpointParams.Builder params) {
        params.useS3ExpressControlEndpoint(true);
    }

    private static void putBucketIntelligentTieringConfigurationStaticContextParams(S3EndpointParams.Builder params) {
        params.useS3ExpressControlEndpoint(true);
    }

    private static void putBucketInventoryConfigurationStaticContextParams(S3EndpointParams.Builder params) {
        params.useS3ExpressControlEndpoint(true);
    }

    private static void putBucketLifecycleConfigurationStaticContextParams(S3EndpointParams.Builder params) {
        params.useS3ExpressControlEndpoint(true);
    }

    private static void putBucketLoggingStaticContextParams(S3EndpointParams.Builder params) {
        params.useS3ExpressControlEndpoint(true);
    }

    private static void putBucketMetricsConfigurationStaticContextParams(S3EndpointParams.Builder params) {
        params.useS3ExpressControlEndpoint(true);
    }

    private static void putBucketNotificationConfigurationStaticContextParams(S3EndpointParams.Builder params) {
        params.useS3ExpressControlEndpoint(true);
    }

    private static void putBucketOwnershipControlsStaticContextParams(S3EndpointParams.Builder params) {
        params.useS3ExpressControlEndpoint(true);
    }

    private static void putBucketPolicyStaticContextParams(S3EndpointParams.Builder params) {
        params.useS3ExpressControlEndpoint(true);
    }

    private static void putBucketReplicationStaticContextParams(S3EndpointParams.Builder params) {
        params.useS3ExpressControlEndpoint(true);
    }

    private static void putBucketRequestPaymentStaticContextParams(S3EndpointParams.Builder params) {
        params.useS3ExpressControlEndpoint(true);
    }

    private static void putBucketTaggingStaticContextParams(S3EndpointParams.Builder params) {
        params.useS3ExpressControlEndpoint(true);
    }

    private static void putBucketVersioningStaticContextParams(S3EndpointParams.Builder params) {
        params.useS3ExpressControlEndpoint(true);
    }

    private static void putBucketWebsiteStaticContextParams(S3EndpointParams.Builder params) {
        params.useS3ExpressControlEndpoint(true);
    }

    private static void putPublicAccessBlockStaticContextParams(S3EndpointParams.Builder params) {
        params.useS3ExpressControlEndpoint(true);
    }

    private static void uploadPartCopyStaticContextParams(S3EndpointParams.Builder params) {
        params.disableS3ExpressSessionAuth(true);
    }

    private static void writeGetObjectResponseStaticContextParams(S3EndpointParams.Builder params) {
        params.useObjectLambdaEndpoint(true);
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
            if (endpointAuthScheme instanceof SigV4aAuthScheme) {
                SigV4aAuthScheme v4aAuthScheme = (SigV4aAuthScheme) endpointAuthScheme;
                /*if (v4aAuthScheme.isDisableDoubleEncodingSet()) { TODO:REMOVE
                    option.putSignerProperty(AwsV4aHttpSigner.DOUBLE_URL_ENCODE, !v4aAuthScheme.disableDoubleEncoding());
                }
                if (!(selectedAuthScheme.authSchemeOption().schemeId().equals(AwsV4aAuthScheme.SCHEME_ID) && selectedAuthScheme
                        .authSchemeOption().signerProperty(AwsV4aHttpSigner.REGION_SET) != null)
                        && !CollectionUtils.isNullOrEmpty(v4aAuthScheme.signingRegionSet())) {
                    RegionSet regionSet = RegionSet.create(v4aAuthScheme.signingRegionSet());
                    option.putSignerProperty(AwsV4aHttpSigner.REGION_SET, regionSet);
                }
                if (v4aAuthScheme.signingName() != null) {
                    option.putSignerProperty(AwsV4aHttpSigner.SERVICE_SIGNING_NAME, v4aAuthScheme.signingName());
                } */
                return new SelectedAuthScheme<>(selectedAuthScheme.identity(), selectedAuthScheme.signer(), option.build());
            }
            if (endpointAuthScheme instanceof S3ExpressEndpointAuthScheme) {
                S3ExpressEndpointAuthScheme s3ExpressAuthScheme = (S3ExpressEndpointAuthScheme) endpointAuthScheme;
                if (s3ExpressAuthScheme.isDisableDoubleEncodingSet()) {
                    option.putSignerProperty(AwsV4HttpSigner.DOUBLE_URL_ENCODE, !s3ExpressAuthScheme.disableDoubleEncoding());
                }
                if (s3ExpressAuthScheme.signingRegion() != null) {
                    option.putSignerProperty(AwsV4HttpSigner.REGION_NAME, s3ExpressAuthScheme.signingRegion());
                }
                if (s3ExpressAuthScheme.signingName() != null) {
                    option.putSignerProperty(AwsV4HttpSigner.SERVICE_SIGNING_NAME, s3ExpressAuthScheme.signingName());
                }
                return new SelectedAuthScheme<>(selectedAuthScheme.identity(), selectedAuthScheme.signer(), option.build());
            }
            throw new IllegalArgumentException("Endpoint auth scheme '" + endpointAuthScheme.name()
                    + "' cannot be mapped to the SDK auth scheme. Was it declared in the service's model?");
        }
        return selectedAuthScheme;
    }

    private static void setClientContextParams(S3EndpointParams.Builder params, ExecutionAttributes executionAttributes) {
        AttributeMap clientContextParams = executionAttributes.getAttribute(SdkInternalExecutionAttribute.CLIENT_CONTEXT_PARAMS);
        Optional.ofNullable(clientContextParams.get(S3ClientContextParams.ACCELERATE)).ifPresent(params::accelerate);
        Optional.ofNullable(clientContextParams.get(S3ClientContextParams.DISABLE_MULTI_REGION_ACCESS_POINTS)).ifPresent(
                params::disableMultiRegionAccessPoints);
        Optional.ofNullable(clientContextParams.get(S3ClientContextParams.DISABLE_S3_EXPRESS_SESSION_AUTH)).ifPresent(
                params::disableS3ExpressSessionAuth);
        Optional.ofNullable(clientContextParams.get(S3ClientContextParams.FORCE_PATH_STYLE)).ifPresent(params::forcePathStyle);
        Optional.ofNullable(clientContextParams.get(S3ClientContextParams.USE_ARN_REGION)).ifPresent(params::useArnRegion);
    }

    private static void setOperationContextParams(S3EndpointParams.Builder params, String operationName, SdkRequest request) {
        switch (operationName) {
        case "DeleteObjects":
            setOperationContextParams(params, (DeleteObjectsRequest) request);
            break;
        default:
            break;
        }
    }

    private static void setOperationContextParams(S3EndpointParams.Builder params, DeleteObjectsRequest request) {
        JmesPathRuntime.Value input = new JmesPathRuntime.Value(request);
        params.deleteObjectKeys(input.field("Delete").field("Objects").wildcard().field("Key").stringValues());
    }

    private static Optional<String> hostPrefix(String operationName, SdkRequest request) {
        switch (operationName) {
        case "WriteGetObjectResponse": {
            HostnameValidator.validateHostnameCompliant(request.getValueForField("RequestRoute", String.class).orElse(null),
                    "RequestRoute", "writeGetObjectResponseRequest");
            return Optional.of(String.format("%s.", request.getValueForField("RequestRoute", String.class).get()));
        }
        default:
            return Optional.empty();
        }
    }
}
