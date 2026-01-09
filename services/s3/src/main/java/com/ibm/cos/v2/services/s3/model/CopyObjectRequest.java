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

package com.ibm.cos.v2.services.s3.model;

import java.time.Instant;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import com.ibm.cos.v2.annotations.Generated;
import com.ibm.cos.v2.annotations.Mutable;
import com.ibm.cos.v2.annotations.NotThreadSafe;
import com.ibm.cos.v2.awscore.AwsRequestOverrideConfiguration;
import com.ibm.cos.v2.core.SdkField;
import com.ibm.cos.v2.core.SdkPojo;
import com.ibm.cos.v2.core.protocol.MarshallLocation;
import com.ibm.cos.v2.core.protocol.MarshallingType;
import com.ibm.cos.v2.core.traits.LocationTrait;
import com.ibm.cos.v2.core.traits.MapTrait;
import com.ibm.cos.v2.core.traits.RequiredTrait;
import com.ibm.cos.v2.core.traits.TimestampFormatTrait;
import com.ibm.cos.v2.core.util.DefaultSdkAutoConstructMap;
import com.ibm.cos.v2.core.util.SdkAutoConstructMap;
import com.ibm.cos.v2.services.s3.internal.TaggingAdapter;
import com.ibm.cos.v2.utils.ToString;
import com.ibm.cos.v2.utils.builder.CopyableBuilder;
import com.ibm.cos.v2.utils.builder.ToCopyableBuilder;

/**
 */
@Generated("com.ibm.cos.v2:codegen")
public final class CopyObjectRequest extends S3Request implements ToCopyableBuilder<CopyObjectRequest.Builder, CopyObjectRequest> {
    private static final SdkField<String> ACL_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("ACL")
            .getter(getter(CopyObjectRequest::aclAsString))
            .setter(setter(Builder::acl))
            .traits(LocationTrait.builder().location(MarshallLocation.HEADER).locationName("x-amz-acl")
                    .unmarshallLocationName("x-amz-acl").build()).build();

    private static final SdkField<String> CACHE_CONTROL_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("CacheControl")
            .getter(getter(CopyObjectRequest::cacheControl))
            .setter(setter(Builder::cacheControl))
            .traits(LocationTrait.builder().location(MarshallLocation.HEADER).locationName("Cache-Control")
                    .unmarshallLocationName("Cache-Control").build()).build();

    private static final SdkField<String> CHECKSUM_ALGORITHM_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("ChecksumAlgorithm")
            .getter(getter(CopyObjectRequest::checksumAlgorithmAsString))
            .setter(setter(Builder::checksumAlgorithm))
            .traits(LocationTrait.builder().location(MarshallLocation.HEADER).locationName("x-amz-checksum-algorithm")
                    .unmarshallLocationName("x-amz-checksum-algorithm").build()).build();

    private static final SdkField<String> CONTENT_DISPOSITION_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("ContentDisposition")
            .getter(getter(CopyObjectRequest::contentDisposition))
            .setter(setter(Builder::contentDisposition))
            .traits(LocationTrait.builder().location(MarshallLocation.HEADER).locationName("Content-Disposition")
                    .unmarshallLocationName("Content-Disposition").build()).build();

    private static final SdkField<String> CONTENT_ENCODING_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("ContentEncoding")
            .getter(getter(CopyObjectRequest::contentEncoding))
            .setter(setter(Builder::contentEncoding))
            .traits(LocationTrait.builder().location(MarshallLocation.HEADER).locationName("Content-Encoding")
                    .unmarshallLocationName("Content-Encoding").build()).build();

    private static final SdkField<String> CONTENT_LANGUAGE_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("ContentLanguage")
            .getter(getter(CopyObjectRequest::contentLanguage))
            .setter(setter(Builder::contentLanguage))
            .traits(LocationTrait.builder().location(MarshallLocation.HEADER).locationName("Content-Language")
                    .unmarshallLocationName("Content-Language").build()).build();

    private static final SdkField<String> CONTENT_TYPE_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("ContentType")
            .getter(getter(CopyObjectRequest::contentType))
            .setter(setter(Builder::contentType))
            .traits(LocationTrait.builder().location(MarshallLocation.HEADER).locationName("Content-Type")
                    .unmarshallLocationName("Content-Type").build()).build();

    private static final SdkField<String> COPY_SOURCE_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("CopySource")
            .getter(getter(CopyObjectRequest::copySource))
            .setter(setter(Builder::copySource))
            .traits(LocationTrait.builder().location(MarshallLocation.HEADER).locationName("x-amz-copy-source")
                    .unmarshallLocationName("x-amz-copy-source").build(), RequiredTrait.create()).build();

    private static final SdkField<String> COPY_SOURCE_IF_MATCH_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("CopySourceIfMatch")
            .getter(getter(CopyObjectRequest::copySourceIfMatch))
            .setter(setter(Builder::copySourceIfMatch))
            .traits(LocationTrait.builder().location(MarshallLocation.HEADER).locationName("x-amz-copy-source-if-match")
                    .unmarshallLocationName("x-amz-copy-source-if-match").build()).build();

    private static final SdkField<Instant> COPY_SOURCE_IF_MODIFIED_SINCE_FIELD = SdkField
            .<Instant> builder(MarshallingType.INSTANT)
            .memberName("CopySourceIfModifiedSince")
            .getter(getter(CopyObjectRequest::copySourceIfModifiedSince))
            .setter(setter(Builder::copySourceIfModifiedSince))
            .traits(LocationTrait.builder().location(MarshallLocation.HEADER).locationName("x-amz-copy-source-if-modified-since")
                    .unmarshallLocationName("x-amz-copy-source-if-modified-since").build()).build();

    private static final SdkField<String> COPY_SOURCE_IF_NONE_MATCH_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("CopySourceIfNoneMatch")
            .getter(getter(CopyObjectRequest::copySourceIfNoneMatch))
            .setter(setter(Builder::copySourceIfNoneMatch))
            .traits(LocationTrait.builder().location(MarshallLocation.HEADER).locationName("x-amz-copy-source-if-none-match")
                    .unmarshallLocationName("x-amz-copy-source-if-none-match").build()).build();

    private static final SdkField<Instant> COPY_SOURCE_IF_UNMODIFIED_SINCE_FIELD = SdkField
            .<Instant> builder(MarshallingType.INSTANT)
            .memberName("CopySourceIfUnmodifiedSince")
            .getter(getter(CopyObjectRequest::copySourceIfUnmodifiedSince))
            .setter(setter(Builder::copySourceIfUnmodifiedSince))
            .traits(LocationTrait.builder().location(MarshallLocation.HEADER)
                    .locationName("x-amz-copy-source-if-unmodified-since")
                    .unmarshallLocationName("x-amz-copy-source-if-unmodified-since").build()).build();

    private static final SdkField<Instant> EXPIRES_FIELD = SdkField
            .<Instant> builder(MarshallingType.INSTANT)
            .memberName("Expires")
            .getter(getter(CopyObjectRequest::expires))
            .setter(setter(Builder::expires))
            .traits(LocationTrait.builder().location(MarshallLocation.HEADER).locationName("Expires")
                    .unmarshallLocationName("Expires").build()).build();

    private static final SdkField<String> GRANT_FULL_CONTROL_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("GrantFullControl")
            .getter(getter(CopyObjectRequest::grantFullControl))
            .setter(setter(Builder::grantFullControl))
            .traits(LocationTrait.builder().location(MarshallLocation.HEADER).locationName("x-amz-grant-full-control")
                    .unmarshallLocationName("x-amz-grant-full-control").build()).build();

    private static final SdkField<String> GRANT_READ_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("GrantRead")
            .getter(getter(CopyObjectRequest::grantRead))
            .setter(setter(Builder::grantRead))
            .traits(LocationTrait.builder().location(MarshallLocation.HEADER).locationName("x-amz-grant-read")
                    .unmarshallLocationName("x-amz-grant-read").build()).build();

    private static final SdkField<String> GRANT_READ_ACP_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("GrantReadACP")
            .getter(getter(CopyObjectRequest::grantReadACP))
            .setter(setter(Builder::grantReadACP))
            .traits(LocationTrait.builder().location(MarshallLocation.HEADER).locationName("x-amz-grant-read-acp")
                    .unmarshallLocationName("x-amz-grant-read-acp").build()).build();

    private static final SdkField<String> GRANT_WRITE_ACP_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("GrantWriteACP")
            .getter(getter(CopyObjectRequest::grantWriteACP))
            .setter(setter(Builder::grantWriteACP))
            .traits(LocationTrait.builder().location(MarshallLocation.HEADER).locationName("x-amz-grant-write-acp")
                    .unmarshallLocationName("x-amz-grant-write-acp").build()).build();

    private static final SdkField<Map<String, String>> METADATA_FIELD = SdkField
            .<Map<String, String>> builder(MarshallingType.MAP)
            .memberName("Metadata")
            .getter(getter(CopyObjectRequest::metadata))
            .setter(setter(Builder::metadata))
            .traits(LocationTrait.builder().location(MarshallLocation.HEADER).locationName("x-amz-meta-")
                    .unmarshallLocationName("x-amz-meta-").build(),
                    MapTrait.builder()
                            .keyLocationName("key")
                            .valueLocationName("value")
                            .valueFieldInfo(
                                    SdkField.<String> builder(MarshallingType.STRING)
                                            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD)
                                                    .locationName("value").unmarshallLocationName("value").build()).build())
                            .build()).build();

    private static final SdkField<String> METADATA_DIRECTIVE_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("MetadataDirective")
            .getter(getter(CopyObjectRequest::metadataDirectiveAsString))
            .setter(setter(Builder::metadataDirective))
            .traits(LocationTrait.builder().location(MarshallLocation.HEADER).locationName("x-amz-metadata-directive")
                    .unmarshallLocationName("x-amz-metadata-directive").build()).build();

    private static final SdkField<String> TAGGING_DIRECTIVE_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("TaggingDirective")
            .getter(getter(CopyObjectRequest::taggingDirectiveAsString))
            .setter(setter(Builder::taggingDirective))
            .traits(LocationTrait.builder().location(MarshallLocation.HEADER).locationName("x-amz-tagging-directive")
                    .unmarshallLocationName("x-amz-tagging-directive").build()).build();

    private static final SdkField<String> SERVER_SIDE_ENCRYPTION_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("ServerSideEncryption")
            .getter(getter(CopyObjectRequest::serverSideEncryptionAsString))
            .setter(setter(Builder::serverSideEncryption))
            .traits(LocationTrait.builder().location(MarshallLocation.HEADER).locationName("x-amz-server-side-encryption")
                    .unmarshallLocationName("x-amz-server-side-encryption").build()).build();

    private static final SdkField<String> STORAGE_CLASS_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("StorageClass")
            .getter(getter(CopyObjectRequest::storageClassAsString))
            .setter(setter(Builder::storageClass))
            .traits(LocationTrait.builder().location(MarshallLocation.HEADER).locationName("x-amz-storage-class")
                    .unmarshallLocationName("x-amz-storage-class").build()).build();

    private static final SdkField<String> WEBSITE_REDIRECT_LOCATION_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("WebsiteRedirectLocation")
            .getter(getter(CopyObjectRequest::websiteRedirectLocation))
            .setter(setter(Builder::websiteRedirectLocation))
            .traits(LocationTrait.builder().location(MarshallLocation.HEADER).locationName("x-amz-website-redirect-location")
                    .unmarshallLocationName("x-amz-website-redirect-location").build()).build();

    private static final SdkField<String> SSE_CUSTOMER_ALGORITHM_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("SSECustomerAlgorithm")
            .getter(getter(CopyObjectRequest::sseCustomerAlgorithm))
            .setter(setter(Builder::sseCustomerAlgorithm))
            .traits(LocationTrait.builder().location(MarshallLocation.HEADER)
                    .locationName("x-amz-server-side-encryption-customer-algorithm")
                    .unmarshallLocationName("x-amz-server-side-encryption-customer-algorithm").build()).build();

    private static final SdkField<String> SSE_CUSTOMER_KEY_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("SSECustomerKey")
            .getter(getter(CopyObjectRequest::sseCustomerKey))
            .setter(setter(Builder::sseCustomerKey))
            .traits(LocationTrait.builder().location(MarshallLocation.HEADER)
                    .locationName("x-amz-server-side-encryption-customer-key")
                    .unmarshallLocationName("x-amz-server-side-encryption-customer-key").build()).build();

    private static final SdkField<String> SSE_CUSTOMER_KEY_MD5_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("SSECustomerKeyMD5")
            .getter(getter(CopyObjectRequest::sseCustomerKeyMD5))
            .setter(setter(Builder::sseCustomerKeyMD5))
            .traits(LocationTrait.builder().location(MarshallLocation.HEADER)
                    .locationName("x-amz-server-side-encryption-customer-key-MD5")
                    .unmarshallLocationName("x-amz-server-side-encryption-customer-key-MD5").build()).build();

    private static final SdkField<String> SSEKMS_KEY_ID_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("SSEKMSKeyId")
            .getter(getter(CopyObjectRequest::ssekmsKeyId))
            .setter(setter(Builder::ssekmsKeyId))
            .traits(LocationTrait.builder().location(MarshallLocation.HEADER)
                    .locationName("x-amz-server-side-encryption-aws-kms-key-id")
                    .unmarshallLocationName("x-amz-server-side-encryption-aws-kms-key-id").build()).build();

    private static final SdkField<String> SSEKMS_ENCRYPTION_CONTEXT_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("SSEKMSEncryptionContext")
            .getter(getter(CopyObjectRequest::ssekmsEncryptionContext))
            .setter(setter(Builder::ssekmsEncryptionContext))
            .traits(LocationTrait.builder().location(MarshallLocation.HEADER)
                    .locationName("x-amz-server-side-encryption-context")
                    .unmarshallLocationName("x-amz-server-side-encryption-context").build()).build();

    private static final SdkField<Boolean> BUCKET_KEY_ENABLED_FIELD = SdkField
            .<Boolean> builder(MarshallingType.BOOLEAN)
            .memberName("BucketKeyEnabled")
            .getter(getter(CopyObjectRequest::bucketKeyEnabled))
            .setter(setter(Builder::bucketKeyEnabled))
            .traits(LocationTrait.builder().location(MarshallLocation.HEADER)
                    .locationName("x-amz-server-side-encryption-bucket-key-enabled")
                    .unmarshallLocationName("x-amz-server-side-encryption-bucket-key-enabled").build()).build();

    private static final SdkField<String> COPY_SOURCE_SSE_CUSTOMER_ALGORITHM_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("CopySourceSSECustomerAlgorithm")
            .getter(getter(CopyObjectRequest::copySourceSSECustomerAlgorithm))
            .setter(setter(Builder::copySourceSSECustomerAlgorithm))
            .traits(LocationTrait.builder().location(MarshallLocation.HEADER)
                    .locationName("x-amz-copy-source-server-side-encryption-customer-algorithm")
                    .unmarshallLocationName("x-amz-copy-source-server-side-encryption-customer-algorithm").build()).build();

    private static final SdkField<String> COPY_SOURCE_SSE_CUSTOMER_KEY_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("CopySourceSSECustomerKey")
            .getter(getter(CopyObjectRequest::copySourceSSECustomerKey))
            .setter(setter(Builder::copySourceSSECustomerKey))
            .traits(LocationTrait.builder().location(MarshallLocation.HEADER)
                    .locationName("x-amz-copy-source-server-side-encryption-customer-key")
                    .unmarshallLocationName("x-amz-copy-source-server-side-encryption-customer-key").build()).build();

    private static final SdkField<String> COPY_SOURCE_SSE_CUSTOMER_KEY_MD5_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("CopySourceSSECustomerKeyMD5")
            .getter(getter(CopyObjectRequest::copySourceSSECustomerKeyMD5))
            .setter(setter(Builder::copySourceSSECustomerKeyMD5))
            .traits(LocationTrait.builder().location(MarshallLocation.HEADER)
                    .locationName("x-amz-copy-source-server-side-encryption-customer-key-MD5")
                    .unmarshallLocationName("x-amz-copy-source-server-side-encryption-customer-key-MD5").build()).build();

    private static final SdkField<String> REQUEST_PAYER_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("RequestPayer")
            .getter(getter(CopyObjectRequest::requestPayerAsString))
            .setter(setter(Builder::requestPayer))
            .traits(LocationTrait.builder().location(MarshallLocation.HEADER).locationName("x-amz-request-payer")
                    .unmarshallLocationName("x-amz-request-payer").build()).build();

    private static final SdkField<String> TAGGING_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("Tagging")
            .getter(getter(CopyObjectRequest::tagging))
            .setter(setter(Builder::tagging))
            .traits(LocationTrait.builder().location(MarshallLocation.HEADER).locationName("x-amz-tagging")
                    .unmarshallLocationName("x-amz-tagging").build()).build();

    private static final SdkField<String> OBJECT_LOCK_MODE_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("ObjectLockMode")
            .getter(getter(CopyObjectRequest::objectLockModeAsString))
            .setter(setter(Builder::objectLockMode))
            .traits(LocationTrait.builder().location(MarshallLocation.HEADER).locationName("x-amz-object-lock-mode")
                    .unmarshallLocationName("x-amz-object-lock-mode").build()).build();

    private static final SdkField<Instant> OBJECT_LOCK_RETAIN_UNTIL_DATE_FIELD = SdkField
            .<Instant> builder(MarshallingType.INSTANT)
            .memberName("ObjectLockRetainUntilDate")
            .getter(getter(CopyObjectRequest::objectLockRetainUntilDate))
            .setter(setter(Builder::objectLockRetainUntilDate))
            .traits(LocationTrait.builder().location(MarshallLocation.HEADER).locationName("x-amz-object-lock-retain-until-date")
                    .unmarshallLocationName("x-amz-object-lock-retain-until-date").build(),
                    TimestampFormatTrait.create(TimestampFormatTrait.Format.ISO_8601)).build();

    private static final SdkField<String> OBJECT_LOCK_LEGAL_HOLD_STATUS_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("ObjectLockLegalHoldStatus")
            .getter(getter(CopyObjectRequest::objectLockLegalHoldStatusAsString))
            .setter(setter(Builder::objectLockLegalHoldStatus))
            .traits(LocationTrait.builder().location(MarshallLocation.HEADER).locationName("x-amz-object-lock-legal-hold")
                    .unmarshallLocationName("x-amz-object-lock-legal-hold").build()).build();

    private static final SdkField<String> EXPECTED_BUCKET_OWNER_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("ExpectedBucketOwner")
            .getter(getter(CopyObjectRequest::expectedBucketOwner))
            .setter(setter(Builder::expectedBucketOwner))
            .traits(LocationTrait.builder().location(MarshallLocation.HEADER).locationName("x-amz-expected-bucket-owner")
                    .unmarshallLocationName("x-amz-expected-bucket-owner").build()).build();

    private static final SdkField<String> EXPECTED_SOURCE_BUCKET_OWNER_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("ExpectedSourceBucketOwner")
            .getter(getter(CopyObjectRequest::expectedSourceBucketOwner))
            .setter(setter(Builder::expectedSourceBucketOwner))
            .traits(LocationTrait.builder().location(MarshallLocation.HEADER).locationName("x-amz-source-expected-bucket-owner")
                    .unmarshallLocationName("x-amz-source-expected-bucket-owner").build()).build();

    private static final SdkField<String> DESTINATION_BUCKET_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("DestinationBucket")
            .getter(getter(CopyObjectRequest::destinationBucket))
            .setter(setter(Builder::destinationBucket))
            .traits(LocationTrait.builder().location(MarshallLocation.PATH).locationName("Bucket")
                    .unmarshallLocationName("Bucket").build()).build();

    private static final SdkField<String> DESTINATION_KEY_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("DestinationKey")
            .getter(getter(CopyObjectRequest::destinationKey))
            .setter(setter(Builder::destinationKey))
            .traits(LocationTrait.builder().location(MarshallLocation.GREEDY_PATH).locationName("Key")
                    .unmarshallLocationName("Key").build()).build();

    private static final SdkField<String> SOURCE_BUCKET_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("SourceBucket")
            .getter(getter(CopyObjectRequest::sourceBucket))
            .setter(setter(Builder::sourceBucket))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("SourceBucket")
                    .unmarshallLocationName("SourceBucket").build()).build();

    private static final SdkField<String> SOURCE_KEY_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("SourceKey")
            .getter(getter(CopyObjectRequest::sourceKey))
            .setter(setter(Builder::sourceKey))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("SourceKey")
                    .unmarshallLocationName("SourceKey").build()).build();

    private static final SdkField<String> SOURCE_VERSION_ID_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("SourceVersionId")
            .getter(getter(CopyObjectRequest::sourceVersionId))
            .setter(setter(Builder::sourceVersionId))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("SourceVersionId")
                    .unmarshallLocationName("SourceVersionId").build()).build();

    /************************************************ IBM Supported *************************************************************/
    private static final SdkField<Instant> RETENTION_EXPIRATION_DATE_FIELD = SdkField
        .<Instant>builder(MarshallingType.INSTANT)
        .memberName("RetentionExpirationDate")
        .getter((getter(CopyObjectRequest::retentionExpirationDate)))
        .setter(setter(Builder::retentionExpirationDate))
        .traits(LocationTrait.builder().location(MarshallLocation.HEADER)
                .locationName("retention-expiration-date").unmarshallLocationName("retention-expiration-date").build())
        .build();

    private static final SdkField<String> RETENTION_LEGAL_HOLD_ID_FIELD = SdkField
        .<String>builder(MarshallingType.STRING)
        .memberName("RetentionLegalHoldId")
        .getter((getter(CopyObjectRequest::retentionLegalHoldId)))
        .setter(setter(Builder::retentionLegalHoldId))
        .traits(LocationTrait.builder().location(MarshallLocation.HEADER)
               .locationName("retention-legal-hold-id").unmarshallLocationName("retention-legal-hold-id").build())
        .build();

    private static final SdkField<Long> RETENTION_PERIOD_FIELD = SdkField
        .<Long>builder(MarshallingType.LONG)
        .memberName("RetentionPeriod")
        .getter((getter(CopyObjectRequest::retentionPeriod)))
        .setter(setter(Builder::retentionPeriod))
        .traits(LocationTrait.builder().location(MarshallLocation.HEADER)
                  .locationName("retention-period").unmarshallLocationName("retention-period").build())
        .build();

    private static final List<SdkField<?>> SDK_FIELDS = Collections.unmodifiableList(Arrays.asList(ACL_FIELD,
            CACHE_CONTROL_FIELD, CHECKSUM_ALGORITHM_FIELD, CONTENT_DISPOSITION_FIELD, CONTENT_ENCODING_FIELD,
            CONTENT_LANGUAGE_FIELD, CONTENT_TYPE_FIELD, COPY_SOURCE_FIELD, COPY_SOURCE_IF_MATCH_FIELD,
            COPY_SOURCE_IF_MODIFIED_SINCE_FIELD, COPY_SOURCE_IF_NONE_MATCH_FIELD, COPY_SOURCE_IF_UNMODIFIED_SINCE_FIELD,
            EXPIRES_FIELD, GRANT_FULL_CONTROL_FIELD, GRANT_READ_FIELD, GRANT_READ_ACP_FIELD, GRANT_WRITE_ACP_FIELD,
            METADATA_FIELD, METADATA_DIRECTIVE_FIELD, TAGGING_DIRECTIVE_FIELD, SERVER_SIDE_ENCRYPTION_FIELD, STORAGE_CLASS_FIELD,
            WEBSITE_REDIRECT_LOCATION_FIELD, SSE_CUSTOMER_ALGORITHM_FIELD, SSE_CUSTOMER_KEY_FIELD, SSE_CUSTOMER_KEY_MD5_FIELD,
            SSEKMS_KEY_ID_FIELD, SSEKMS_ENCRYPTION_CONTEXT_FIELD, BUCKET_KEY_ENABLED_FIELD,
            COPY_SOURCE_SSE_CUSTOMER_ALGORITHM_FIELD, COPY_SOURCE_SSE_CUSTOMER_KEY_FIELD, COPY_SOURCE_SSE_CUSTOMER_KEY_MD5_FIELD,
            REQUEST_PAYER_FIELD, TAGGING_FIELD, OBJECT_LOCK_MODE_FIELD, OBJECT_LOCK_RETAIN_UNTIL_DATE_FIELD,
            OBJECT_LOCK_LEGAL_HOLD_STATUS_FIELD, EXPECTED_BUCKET_OWNER_FIELD, EXPECTED_SOURCE_BUCKET_OWNER_FIELD,
            DESTINATION_BUCKET_FIELD, DESTINATION_KEY_FIELD, SOURCE_BUCKET_FIELD, SOURCE_KEY_FIELD, SOURCE_VERSION_ID_FIELD,
            RETENTION_EXPIRATION_DATE_FIELD, RETENTION_LEGAL_HOLD_ID_FIELD, RETENTION_PERIOD_FIELD));

    private static final Map<String, SdkField<?>> SDK_NAME_TO_FIELD = memberNameToFieldInitializer();

    private final String acl;

    private final String cacheControl;

    private final String checksumAlgorithm;

    private final String contentDisposition;

    private final String contentEncoding;

    private final String contentLanguage;

    private final String contentType;

    private final String copySource;

    private final String copySourceIfMatch;

    private final Instant copySourceIfModifiedSince;

    private final String copySourceIfNoneMatch;

    private final Instant copySourceIfUnmodifiedSince;

    private final Instant expires;

    private final String grantFullControl;

    private final String grantRead;

    private final String grantReadACP;

    private final String grantWriteACP;

    private final Map<String, String> metadata;

    private final String metadataDirective;

    private final String taggingDirective;

    private final String serverSideEncryption;

    private final String storageClass;

    private final String websiteRedirectLocation;

    private final String sseCustomerAlgorithm;

    private final String sseCustomerKey;

    private final String sseCustomerKeyMD5;

    private final String ssekmsKeyId;

    private final String ssekmsEncryptionContext;

    private final Boolean bucketKeyEnabled;

    private final String copySourceSSECustomerAlgorithm;

    private final String copySourceSSECustomerKey;

    private final String copySourceSSECustomerKeyMD5;

    private final String requestPayer;

    private final String tagging;

    private final String objectLockMode;

    private final Instant objectLockRetainUntilDate;

    private final String objectLockLegalHoldStatus;

    private final String expectedBucketOwner;

    private final String expectedSourceBucketOwner;

    private final String destinationBucket;

    private final String destinationKey;

    private final String sourceBucket;

    private final String sourceKey;

    private final String sourceVersionId;

    /*********************************** IBM Supported *********************************************/

    /**
     *  Controls how the Protection state of the source object is copied to the destination object.
     *  If copied, the retention period and all legal holds are copied onto the new object.
     *  The legal hold date's is set to the date of the copy.
     */
    private final RetentionDirective retentionDirective;

    /**
     * Date on which it will be legal to delete or modify the object.
     * You can only specify this or the Retention-Period header.
     * If both are specified a 400 error will be returned.
     * If neither is specified the bucket's DefaultRetention period will be used.
     * This header should be used to calculate a retention period in seconds and then stored in that manner.
     */
    private final Instant retentionExpirationDate;

    /**
     * A single legal hold to apply to the object.
     * A legal hold is a Y character long string.
     * The object cannot be overwritten or deleted until all legal holds associated with the object are removed.
     */
    private final String retentionLegalHoldId;

    /**
     * Retention period to store on the object in seconds.
     * If this field and Retention-Expiration-Date are specified a 400 error is returned.
     * If neither is specified the bucket's DefaultRetention period will be used.
     * 0 is a legal value assuming the bucket's minimum retention period is also 0.
     */
    private final Long retentionPeriod;

    private CopyObjectRequest(BuilderImpl builder) {
        super(builder);
        this.acl = builder.acl;
        this.cacheControl = builder.cacheControl;
        this.checksumAlgorithm = builder.checksumAlgorithm;
        this.contentDisposition = builder.contentDisposition;
        this.contentEncoding = builder.contentEncoding;
        this.contentLanguage = builder.contentLanguage;
        this.contentType = builder.contentType;
        this.copySource = builder.copySource;
        this.copySourceIfMatch = builder.copySourceIfMatch;
        this.copySourceIfModifiedSince = builder.copySourceIfModifiedSince;
        this.copySourceIfNoneMatch = builder.copySourceIfNoneMatch;
        this.copySourceIfUnmodifiedSince = builder.copySourceIfUnmodifiedSince;
        this.expires = builder.expires;
        this.grantFullControl = builder.grantFullControl;
        this.grantRead = builder.grantRead;
        this.grantReadACP = builder.grantReadACP;
        this.grantWriteACP = builder.grantWriteACP;
        this.metadata = builder.metadata;
        this.metadataDirective = builder.metadataDirective;
        this.taggingDirective = builder.taggingDirective;
        this.serverSideEncryption = builder.serverSideEncryption;
        this.storageClass = builder.storageClass;
        this.websiteRedirectLocation = builder.websiteRedirectLocation;
        this.sseCustomerAlgorithm = builder.sseCustomerAlgorithm;
        this.sseCustomerKey = builder.sseCustomerKey;
        this.sseCustomerKeyMD5 = builder.sseCustomerKeyMD5;
        this.ssekmsKeyId = builder.ssekmsKeyId;
        this.ssekmsEncryptionContext = builder.ssekmsEncryptionContext;
        this.bucketKeyEnabled = builder.bucketKeyEnabled;
        this.copySourceSSECustomerAlgorithm = builder.copySourceSSECustomerAlgorithm;
        this.copySourceSSECustomerKey = builder.copySourceSSECustomerKey;
        this.copySourceSSECustomerKeyMD5 = builder.copySourceSSECustomerKeyMD5;
        this.requestPayer = builder.requestPayer;
        this.tagging = builder.tagging;
        this.objectLockMode = builder.objectLockMode;
        this.objectLockRetainUntilDate = builder.objectLockRetainUntilDate;
        this.objectLockLegalHoldStatus = builder.objectLockLegalHoldStatus;
        this.expectedBucketOwner = builder.expectedBucketOwner;
        this.expectedSourceBucketOwner = builder.expectedSourceBucketOwner;
        this.destinationBucket = builder.destinationBucket;
        this.destinationKey = builder.destinationKey;
        this.sourceBucket = builder.sourceBucket;
        this.sourceKey = builder.sourceKey;
        this.sourceVersionId = builder.sourceVersionId;
        this.retentionDirective = builder.retentionDirective;
        this.retentionExpirationDate = builder.retentionExpirationDate;
        this.retentionLegalHoldId = builder.retentionLegalHoldId;
        this.retentionPeriod = builder.retentionPeriod;
    }

    /**
     * <p>
     * The canned access control list (ACL) to apply to the object.
     * </p>
     * <p>
     * When you copy an object, the ACL metadata is not preserved and is set to <code>private</code> by default. Only
     * the owner has full access control. To override the default ACL setting, specify a new ACL when you generate a
     * copy request. For more information, see <a
     * href="https://docs.aws.amazon.com/AmazonS3/latest/dev/S3_ACLs_UsingACLs.html">Using ACLs</a>.
     * </p>
     * <p>
     * If the destination bucket that you're copying objects to uses the bucket owner enforced setting for S3 Object
     * Ownership, ACLs are disabled and no longer affect permissions. Buckets that use this setting only accept
     * <code>PUT</code> requests that don't specify an ACL or <code>PUT</code> requests that specify bucket owner full
     * control ACLs, such as the <code>bucket-owner-full-control</code> canned ACL or an equivalent form of this ACL
     * expressed in the XML format. For more information, see <a
     * href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/about-object-ownership.html">Controlling ownership of
     * objects and disabling ACLs</a> in the <i>Amazon S3 User Guide</i>.
     * </p>
     * <note>
     * <ul>
     * <li>
     * <p>
     * If your destination bucket uses the bucket owner enforced setting for Object Ownership, all objects written to
     * the bucket by any account will be owned by the bucket owner.
     * </p>
     * </li>
     * <li>
     * <p>
     * This functionality is not supported for directory buckets.
     * </p>
     * </li>
     * <li>
     * <p>
     * This functionality is not supported for Amazon S3 on Outposts.
     * </p>
     * </li>
     * </ul>
     * </note>
     * <p>
     * If the service returns an enum value that is not available in the current SDK version, {@link #acl} will return
     * {@link ObjectCannedACL#UNKNOWN_TO_SDK_VERSION}. The raw value returned by the service is available from
     * {@link #aclAsString}.
     * </p>
     * 
     * @return The canned access control list (ACL) to apply to the object.</p>
     *         <p>
     *         When you copy an object, the ACL metadata is not preserved and is set to <code>private</code> by default.
     *         Only the owner has full access control. To override the default ACL setting, specify a new ACL when you
     *         generate a copy request. For more information, see <a
     *         href="https://docs.aws.amazon.com/AmazonS3/latest/dev/S3_ACLs_UsingACLs.html">Using ACLs</a>.
     *         </p>
     *         <p>
     *         If the destination bucket that you're copying objects to uses the bucket owner enforced setting for S3
     *         Object Ownership, ACLs are disabled and no longer affect permissions. Buckets that use this setting only
     *         accept <code>PUT</code> requests that don't specify an ACL or <code>PUT</code> requests that specify
     *         bucket owner full control ACLs, such as the <code>bucket-owner-full-control</code> canned ACL or an
     *         equivalent form of this ACL expressed in the XML format. For more information, see <a
     *         href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/about-object-ownership.html">Controlling
     *         ownership of objects and disabling ACLs</a> in the <i>Amazon S3 User Guide</i>.
     *         </p>
     *         <note>
     *         <ul>
     *         <li>
     *         <p>
     *         If your destination bucket uses the bucket owner enforced setting for Object Ownership, all objects
     *         written to the bucket by any account will be owned by the bucket owner.
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         This functionality is not supported for directory buckets.
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         This functionality is not supported for Amazon S3 on Outposts.
     *         </p>
     *         </li>
     *         </ul>
     * @see ObjectCannedACL
     */
    public final ObjectCannedACL acl() {
        return ObjectCannedACL.fromValue(acl);
    }

    /**
     * <p>
     * The canned access control list (ACL) to apply to the object.
     * </p>
     * <p>
     * When you copy an object, the ACL metadata is not preserved and is set to <code>private</code> by default. Only
     * the owner has full access control. To override the default ACL setting, specify a new ACL when you generate a
     * copy request. For more information, see <a
     * href="https://docs.aws.amazon.com/AmazonS3/latest/dev/S3_ACLs_UsingACLs.html">Using ACLs</a>.
     * </p>
     * <p>
     * If the destination bucket that you're copying objects to uses the bucket owner enforced setting for S3 Object
     * Ownership, ACLs are disabled and no longer affect permissions. Buckets that use this setting only accept
     * <code>PUT</code> requests that don't specify an ACL or <code>PUT</code> requests that specify bucket owner full
     * control ACLs, such as the <code>bucket-owner-full-control</code> canned ACL or an equivalent form of this ACL
     * expressed in the XML format. For more information, see <a
     * href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/about-object-ownership.html">Controlling ownership of
     * objects and disabling ACLs</a> in the <i>Amazon S3 User Guide</i>.
     * </p>
     * <note>
     * <ul>
     * <li>
     * <p>
     * If your destination bucket uses the bucket owner enforced setting for Object Ownership, all objects written to
     * the bucket by any account will be owned by the bucket owner.
     * </p>
     * </li>
     * <li>
     * <p>
     * This functionality is not supported for directory buckets.
     * </p>
     * </li>
     * <li>
     * <p>
     * This functionality is not supported for Amazon S3 on Outposts.
     * </p>
     * </li>
     * </ul>
     * </note>
     * <p>
     * If the service returns an enum value that is not available in the current SDK version, {@link #acl} will return
     * {@link ObjectCannedACL#UNKNOWN_TO_SDK_VERSION}. The raw value returned by the service is available from
     * {@link #aclAsString}.
     * </p>
     * 
     * @return The canned access control list (ACL) to apply to the object.</p>
     *         <p>
     *         When you copy an object, the ACL metadata is not preserved and is set to <code>private</code> by default.
     *         Only the owner has full access control. To override the default ACL setting, specify a new ACL when you
     *         generate a copy request. For more information, see <a
     *         href="https://docs.aws.amazon.com/AmazonS3/latest/dev/S3_ACLs_UsingACLs.html">Using ACLs</a>.
     *         </p>
     *         <p>
     *         If the destination bucket that you're copying objects to uses the bucket owner enforced setting for S3
     *         Object Ownership, ACLs are disabled and no longer affect permissions. Buckets that use this setting only
     *         accept <code>PUT</code> requests that don't specify an ACL or <code>PUT</code> requests that specify
     *         bucket owner full control ACLs, such as the <code>bucket-owner-full-control</code> canned ACL or an
     *         equivalent form of this ACL expressed in the XML format. For more information, see <a
     *         href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/about-object-ownership.html">Controlling
     *         ownership of objects and disabling ACLs</a> in the <i>Amazon S3 User Guide</i>.
     *         </p>
     *         <note>
     *         <ul>
     *         <li>
     *         <p>
     *         If your destination bucket uses the bucket owner enforced setting for Object Ownership, all objects
     *         written to the bucket by any account will be owned by the bucket owner.
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         This functionality is not supported for directory buckets.
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         This functionality is not supported for Amazon S3 on Outposts.
     *         </p>
     *         </li>
     *         </ul>
     * @see ObjectCannedACL
     */
    public final String aclAsString() {
        return acl;
    }

    /**
     * <p>
     * Specifies the caching behavior along the request/reply chain.
     * </p>
     * 
     * @return Specifies the caching behavior along the request/reply chain.
     */
    public final String cacheControl() {
        return cacheControl;
    }

    /**
     * <p>
     * Indicates the algorithm that you want Amazon S3 to use to create the checksum for the object. For more
     * information, see <a
     * href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/checking-object-integrity.html">Checking object
     * integrity</a> in the <i>Amazon S3 User Guide</i>.
     * </p>
     * <p>
     * When you copy an object, if the source object has a checksum, that checksum value will be copied to the new
     * object by default. If the <code>CopyObject</code> request does not include this
     * <code>x-amz-checksum-algorithm</code> header, the checksum algorithm will be copied from the source object to the
     * destination object (if it's present on the source object). You can optionally specify a different checksum
     * algorithm to use with the <code>x-amz-checksum-algorithm</code> header. Unrecognized or unsupported values will
     * respond with the HTTP status code <code>400 Bad Request</code>.
     * </p>
     * <note>
     * <p>
     * For directory buckets, when you use Amazon Web Services SDKs, <code>CRC32</code> is the default checksum
     * algorithm that's used for performance.
     * </p>
     * </note>
     * <p>
     * If the service returns an enum value that is not available in the current SDK version, {@link #checksumAlgorithm}
     * will return {@link ChecksumAlgorithm#UNKNOWN_TO_SDK_VERSION}. The raw value returned by the service is available
     * from {@link #checksumAlgorithmAsString}.
     * </p>
     * 
     * @return Indicates the algorithm that you want Amazon S3 to use to create the checksum for the object. For more
     *         information, see <a
     *         href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/checking-object-integrity.html">Checking
     *         object integrity</a> in the <i>Amazon S3 User Guide</i>.</p>
     *         <p>
     *         When you copy an object, if the source object has a checksum, that checksum value will be copied to the
     *         new object by default. If the <code>CopyObject</code> request does not include this
     *         <code>x-amz-checksum-algorithm</code> header, the checksum algorithm will be copied from the source
     *         object to the destination object (if it's present on the source object). You can optionally specify a
     *         different checksum algorithm to use with the <code>x-amz-checksum-algorithm</code> header. Unrecognized
     *         or unsupported values will respond with the HTTP status code <code>400 Bad Request</code>.
     *         </p>
     *         <note>
     *         <p>
     *         For directory buckets, when you use Amazon Web Services SDKs, <code>CRC32</code> is the default checksum
     *         algorithm that's used for performance.
     *         </p>
     * @see ChecksumAlgorithm
     */
    public final ChecksumAlgorithm checksumAlgorithm() {
        return ChecksumAlgorithm.fromValue(checksumAlgorithm);
    }

    /**
     * <p>
     * Indicates the algorithm that you want Amazon S3 to use to create the checksum for the object. For more
     * information, see <a
     * href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/checking-object-integrity.html">Checking object
     * integrity</a> in the <i>Amazon S3 User Guide</i>.
     * </p>
     * <p>
     * When you copy an object, if the source object has a checksum, that checksum value will be copied to the new
     * object by default. If the <code>CopyObject</code> request does not include this
     * <code>x-amz-checksum-algorithm</code> header, the checksum algorithm will be copied from the source object to the
     * destination object (if it's present on the source object). You can optionally specify a different checksum
     * algorithm to use with the <code>x-amz-checksum-algorithm</code> header. Unrecognized or unsupported values will
     * respond with the HTTP status code <code>400 Bad Request</code>.
     * </p>
     * <note>
     * <p>
     * For directory buckets, when you use Amazon Web Services SDKs, <code>CRC32</code> is the default checksum
     * algorithm that's used for performance.
     * </p>
     * </note>
     * <p>
     * If the service returns an enum value that is not available in the current SDK version, {@link #checksumAlgorithm}
     * will return {@link ChecksumAlgorithm#UNKNOWN_TO_SDK_VERSION}. The raw value returned by the service is available
     * from {@link #checksumAlgorithmAsString}.
     * </p>
     * 
     * @return Indicates the algorithm that you want Amazon S3 to use to create the checksum for the object. For more
     *         information, see <a
     *         href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/checking-object-integrity.html">Checking
     *         object integrity</a> in the <i>Amazon S3 User Guide</i>.</p>
     *         <p>
     *         When you copy an object, if the source object has a checksum, that checksum value will be copied to the
     *         new object by default. If the <code>CopyObject</code> request does not include this
     *         <code>x-amz-checksum-algorithm</code> header, the checksum algorithm will be copied from the source
     *         object to the destination object (if it's present on the source object). You can optionally specify a
     *         different checksum algorithm to use with the <code>x-amz-checksum-algorithm</code> header. Unrecognized
     *         or unsupported values will respond with the HTTP status code <code>400 Bad Request</code>.
     *         </p>
     *         <note>
     *         <p>
     *         For directory buckets, when you use Amazon Web Services SDKs, <code>CRC32</code> is the default checksum
     *         algorithm that's used for performance.
     *         </p>
     * @see ChecksumAlgorithm
     */
    public final String checksumAlgorithmAsString() {
        return checksumAlgorithm;
    }

    /**
     * <p>
     * Specifies presentational information for the object. Indicates whether an object should be displayed in a web
     * browser or downloaded as a file. It allows specifying the desired filename for the downloaded file.
     * </p>
     * 
     * @return Specifies presentational information for the object. Indicates whether an object should be displayed in a
     *         web browser or downloaded as a file. It allows specifying the desired filename for the downloaded file.
     */
    public final String contentDisposition() {
        return contentDisposition;
    }

    /**
     * <p>
     * Specifies what content encodings have been applied to the object and thus what decoding mechanisms must be
     * applied to obtain the media-type referenced by the Content-Type header field.
     * </p>
     * <note>
     * <p>
     * For directory buckets, only the <code>aws-chunked</code> value is supported in this header field.
     * </p>
     * </note>
     * 
     * @return Specifies what content encodings have been applied to the object and thus what decoding mechanisms must
     *         be applied to obtain the media-type referenced by the Content-Type header field.</p> <note>
     *         <p>
     *         For directory buckets, only the <code>aws-chunked</code> value is supported in this header field.
     *         </p>
     */
    public final String contentEncoding() {
        return contentEncoding;
    }

    /**
     * <p>
     * The language the content is in.
     * </p>
     * 
     * @return The language the content is in.
     */
    public final String contentLanguage() {
        return contentLanguage;
    }

    /**
     * <p>
     * A standard MIME type that describes the format of the object data.
     * </p>
     * 
     * @return A standard MIME type that describes the format of the object data.
     */
    public final String contentType() {
        return contentType;
    }

    /**
     * <p>
     * Specifies the source object for the copy operation. The source object can be up to 5 GB. If the source object is
     * an object that was uploaded by using a multipart upload, the object copy will be a single part object after the
     * source object is copied to the destination bucket.
     * </p>
     * <p>
     * You specify the value of the copy source in one of two formats, depending on whether you want to access the
     * source object through an <a
     * href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/access-points.html">access point</a>:
     * </p>
     * <ul>
     * <li>
     * <p>
     * For objects not accessed through an access point, specify the name of the source bucket and the key of the source
     * object, separated by a slash (/). For example, to copy the object <code>reports/january.pdf</code> from the
     * general purpose bucket <code>awsexamplebucket</code>, use <code>awsexamplebucket/reports/january.pdf</code>. The
     * value must be URL-encoded. To copy the object <code>reports/january.pdf</code> from the directory bucket
     * <code>awsexamplebucket--use1-az5--x-s3</code>, use
     * <code>awsexamplebucket--use1-az5--x-s3/reports/january.pdf</code>. The value must be URL-encoded.
     * </p>
     * </li>
     * <li>
     * <p>
     * For objects accessed through access points, specify the Amazon Resource Name (ARN) of the object as accessed
     * through the access point, in the format
     * <code>arn:aws:s3:&lt;Region&gt;:&lt;account-id&gt;:accesspoint/&lt;access-point-name&gt;/object/&lt;key&gt;</code>
     * . For example, to copy the object <code>reports/january.pdf</code> through access point
     * <code>my-access-point</code> owned by account <code>123456789012</code> in Region <code>us-west-2</code>, use the
     * URL encoding of
     * <code>arn:aws:s3:us-west-2:123456789012:accesspoint/my-access-point/object/reports/january.pdf</code>. The value
     * must be URL encoded.
     * </p>
     * <note>
     * <ul>
     * <li>
     * <p>
     * Amazon S3 supports copy operations using Access points only when the source and destination buckets are in the
     * same Amazon Web Services Region.
     * </p>
     * </li>
     * <li>
     * <p>
     * Access points are not supported by directory buckets.
     * </p>
     * </li>
     * </ul>
     * </note>
     * <p>
     * Alternatively, for objects accessed through Amazon S3 on Outposts, specify the ARN of the object as accessed in
     * the format
     * <code>arn:aws:s3-outposts:&lt;Region&gt;:&lt;account-id&gt;:outpost/&lt;outpost-id&gt;/object/&lt;key&gt;</code>.
     * For example, to copy the object <code>reports/january.pdf</code> through outpost <code>my-outpost</code> owned by
     * account <code>123456789012</code> in Region <code>us-west-2</code>, use the URL encoding of
     * <code>arn:aws:s3-outposts:us-west-2:123456789012:outpost/my-outpost/object/reports/january.pdf</code>. The value
     * must be URL-encoded.
     * </p>
     * </li>
     * </ul>
     * <p>
     * If your source bucket versioning is enabled, the <code>x-amz-copy-source</code> header by default identifies the
     * current version of an object to copy. If the current version is a delete marker, Amazon S3 behaves as if the
     * object was deleted. To copy a different version, use the <code>versionId</code> query parameter. Specifically,
     * append <code>?versionId=&lt;version-id&gt;</code> to the value (for example,
     * <code>awsexamplebucket/reports/january.pdf?versionId=QUpfdndhfd8438MNFDN93jdnJFkdmqnh893</code>). If you don't
     * specify a version ID, Amazon S3 copies the latest version of the source object.
     * </p>
     * <p>
     * If you enable versioning on the destination bucket, Amazon S3 generates a unique version ID for the copied
     * object. This version ID is different from the version ID of the source object. Amazon S3 returns the version ID
     * of the copied object in the <code>x-amz-version-id</code> response header in the response.
     * </p>
     * <p>
     * If you do not enable versioning or suspend it on the destination bucket, the version ID that Amazon S3 generates
     * in the <code>x-amz-version-id</code> response header is always null.
     * </p>
     * <note>
     * <p>
     * <b>Directory buckets</b> - S3 Versioning isn't enabled and supported for directory buckets.
     * </p>
     * </note>
     * 
     * @return Specifies the source object for the copy operation. The source object can be up to 5 GB. If the source
     *         object is an object that was uploaded by using a multipart upload, the object copy will be a single part
     *         object after the source object is copied to the destination bucket.</p>
     *         <p>
     *         You specify the value of the copy source in one of two formats, depending on whether you want to access
     *         the source object through an <a
     *         href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/access-points.html">access point</a>:
     *         </p>
     *         <ul>
     *         <li>
     *         <p>
     *         For objects not accessed through an access point, specify the name of the source bucket and the key of
     *         the source object, separated by a slash (/). For example, to copy the object
     *         <code>reports/january.pdf</code> from the general purpose bucket <code>awsexamplebucket</code>, use
     *         <code>awsexamplebucket/reports/january.pdf</code>. The value must be URL-encoded. To copy the object
     *         <code>reports/january.pdf</code> from the directory bucket <code>awsexamplebucket--use1-az5--x-s3</code>,
     *         use <code>awsexamplebucket--use1-az5--x-s3/reports/january.pdf</code>. The value must be URL-encoded.
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         For objects accessed through access points, specify the Amazon Resource Name (ARN) of the object as
     *         accessed through the access point, in the format
     *         <code>arn:aws:s3:&lt;Region&gt;:&lt;account-id&gt;:accesspoint/&lt;access-point-name&gt;/object/&lt;key&gt;</code>
     *         . For example, to copy the object <code>reports/january.pdf</code> through access point
     *         <code>my-access-point</code> owned by account <code>123456789012</code> in Region <code>us-west-2</code>,
     *         use the URL encoding of
     *         <code>arn:aws:s3:us-west-2:123456789012:accesspoint/my-access-point/object/reports/january.pdf</code>.
     *         The value must be URL encoded.
     *         </p>
     *         <note>
     *         <ul>
     *         <li>
     *         <p>
     *         Amazon S3 supports copy operations using Access points only when the source and destination buckets are
     *         in the same Amazon Web Services Region.
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         Access points are not supported by directory buckets.
     *         </p>
     *         </li>
     *         </ul>
     *         </note>
     *         <p>
     *         Alternatively, for objects accessed through Amazon S3 on Outposts, specify the ARN of the object as
     *         accessed in the format
     *         <code>arn:aws:s3-outposts:&lt;Region&gt;:&lt;account-id&gt;:outpost/&lt;outpost-id&gt;/object/&lt;key&gt;</code>
     *         . For example, to copy the object <code>reports/january.pdf</code> through outpost
     *         <code>my-outpost</code> owned by account <code>123456789012</code> in Region <code>us-west-2</code>, use
     *         the URL encoding of
     *         <code>arn:aws:s3-outposts:us-west-2:123456789012:outpost/my-outpost/object/reports/january.pdf</code>.
     *         The value must be URL-encoded.
     *         </p>
     *         </li>
     *         </ul>
     *         <p>
     *         If your source bucket versioning is enabled, the <code>x-amz-copy-source</code> header by default
     *         identifies the current version of an object to copy. If the current version is a delete marker, Amazon S3
     *         behaves as if the object was deleted. To copy a different version, use the <code>versionId</code> query
     *         parameter. Specifically, append <code>?versionId=&lt;version-id&gt;</code> to the value (for example,
     *         <code>awsexamplebucket/reports/january.pdf?versionId=QUpfdndhfd8438MNFDN93jdnJFkdmqnh893</code>). If you
     *         don't specify a version ID, Amazon S3 copies the latest version of the source object.
     *         </p>
     *         <p>
     *         If you enable versioning on the destination bucket, Amazon S3 generates a unique version ID for the
     *         copied object. This version ID is different from the version ID of the source object. Amazon S3 returns
     *         the version ID of the copied object in the <code>x-amz-version-id</code> response header in the response.
     *         </p>
     *         <p>
     *         If you do not enable versioning or suspend it on the destination bucket, the version ID that Amazon S3
     *         generates in the <code>x-amz-version-id</code> response header is always null.
     *         </p>
     *         <note>
     *         <p>
     *         <b>Directory buckets</b> - S3 Versioning isn't enabled and supported for directory buckets.
     *         </p>
     * @deprecated The {@code copySource} parameter has been deprecated in favor of the more user-friendly
     *             {@code sourceBucket}, {@code sourceKey}, and {@code sourceVersionId} parameters. The
     *             {@code copySource} parameter will remain fully functional, but it must not be used in conjunction
     *             with its replacement parameters.
     */
    @Deprecated
    public final String copySource() {
        return copySource;
    }

    /**
     * <p>
     * Copies the object if its entity tag (ETag) matches the specified tag.
     * </p>
     * <p>
     * If both the <code>x-amz-copy-source-if-match</code> and <code>x-amz-copy-source-if-unmodified-since</code>
     * headers are present in the request and evaluate as follows, Amazon S3 returns <code>200 OK</code> and copies the
     * data:
     * </p>
     * <ul>
     * <li>
     * <p>
     * <code>x-amz-copy-source-if-match</code> condition evaluates to true
     * </p>
     * </li>
     * <li>
     * <p>
     * <code>x-amz-copy-source-if-unmodified-since</code> condition evaluates to false
     * </p>
     * </li>
     * </ul>
     * 
     * @return Copies the object if its entity tag (ETag) matches the specified tag.</p>
     *         <p>
     *         If both the <code>x-amz-copy-source-if-match</code> and
     *         <code>x-amz-copy-source-if-unmodified-since</code> headers are present in the request and evaluate as
     *         follows, Amazon S3 returns <code>200 OK</code> and copies the data:
     *         </p>
     *         <ul>
     *         <li>
     *         <p>
     *         <code>x-amz-copy-source-if-match</code> condition evaluates to true
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         <code>x-amz-copy-source-if-unmodified-since</code> condition evaluates to false
     *         </p>
     *         </li>
     */
    public final String copySourceIfMatch() {
        return copySourceIfMatch;
    }

    /**
     * <p>
     * Copies the object if it has been modified since the specified time.
     * </p>
     * <p>
     * If both the <code>x-amz-copy-source-if-none-match</code> and <code>x-amz-copy-source-if-modified-since</code>
     * headers are present in the request and evaluate as follows, Amazon S3 returns the
     * <code>412 Precondition Failed</code> response code:
     * </p>
     * <ul>
     * <li>
     * <p>
     * <code>x-amz-copy-source-if-none-match</code> condition evaluates to false
     * </p>
     * </li>
     * <li>
     * <p>
     * <code>x-amz-copy-source-if-modified-since</code> condition evaluates to true
     * </p>
     * </li>
     * </ul>
     * 
     * @return Copies the object if it has been modified since the specified time.</p>
     *         <p>
     *         If both the <code>x-amz-copy-source-if-none-match</code> and
     *         <code>x-amz-copy-source-if-modified-since</code> headers are present in the request and evaluate as
     *         follows, Amazon S3 returns the <code>412 Precondition Failed</code> response code:
     *         </p>
     *         <ul>
     *         <li>
     *         <p>
     *         <code>x-amz-copy-source-if-none-match</code> condition evaluates to false
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         <code>x-amz-copy-source-if-modified-since</code> condition evaluates to true
     *         </p>
     *         </li>
     */
    public final Instant copySourceIfModifiedSince() {
        return copySourceIfModifiedSince;
    }

    /**
     * <p>
     * Copies the object if its entity tag (ETag) is different than the specified ETag.
     * </p>
     * <p>
     * If both the <code>x-amz-copy-source-if-none-match</code> and <code>x-amz-copy-source-if-modified-since</code>
     * headers are present in the request and evaluate as follows, Amazon S3 returns the
     * <code>412 Precondition Failed</code> response code:
     * </p>
     * <ul>
     * <li>
     * <p>
     * <code>x-amz-copy-source-if-none-match</code> condition evaluates to false
     * </p>
     * </li>
     * <li>
     * <p>
     * <code>x-amz-copy-source-if-modified-since</code> condition evaluates to true
     * </p>
     * </li>
     * </ul>
     * 
     * @return Copies the object if its entity tag (ETag) is different than the specified ETag.</p>
     *         <p>
     *         If both the <code>x-amz-copy-source-if-none-match</code> and
     *         <code>x-amz-copy-source-if-modified-since</code> headers are present in the request and evaluate as
     *         follows, Amazon S3 returns the <code>412 Precondition Failed</code> response code:
     *         </p>
     *         <ul>
     *         <li>
     *         <p>
     *         <code>x-amz-copy-source-if-none-match</code> condition evaluates to false
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         <code>x-amz-copy-source-if-modified-since</code> condition evaluates to true
     *         </p>
     *         </li>
     */
    public final String copySourceIfNoneMatch() {
        return copySourceIfNoneMatch;
    }

    /**
     * <p>
     * Copies the object if it hasn't been modified since the specified time.
     * </p>
     * <p>
     * If both the <code>x-amz-copy-source-if-match</code> and <code>x-amz-copy-source-if-unmodified-since</code>
     * headers are present in the request and evaluate as follows, Amazon S3 returns <code>200 OK</code> and copies the
     * data:
     * </p>
     * <ul>
     * <li>
     * <p>
     * <code>x-amz-copy-source-if-match</code> condition evaluates to true
     * </p>
     * </li>
     * <li>
     * <p>
     * <code>x-amz-copy-source-if-unmodified-since</code> condition evaluates to false
     * </p>
     * </li>
     * </ul>
     * 
     * @return Copies the object if it hasn't been modified since the specified time.</p>
     *         <p>
     *         If both the <code>x-amz-copy-source-if-match</code> and
     *         <code>x-amz-copy-source-if-unmodified-since</code> headers are present in the request and evaluate as
     *         follows, Amazon S3 returns <code>200 OK</code> and copies the data:
     *         </p>
     *         <ul>
     *         <li>
     *         <p>
     *         <code>x-amz-copy-source-if-match</code> condition evaluates to true
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         <code>x-amz-copy-source-if-unmodified-since</code> condition evaluates to false
     *         </p>
     *         </li>
     */
    public final Instant copySourceIfUnmodifiedSince() {
        return copySourceIfUnmodifiedSince;
    }

    /**
     * <p>
     * The date and time at which the object is no longer cacheable.
     * </p>
     * 
     * @return The date and time at which the object is no longer cacheable.
     */
    public final Instant expires() {
        return expires;
    }

    /**
     * <p>
     * Gives the grantee READ, READ_ACP, and WRITE_ACP permissions on the object.
     * </p>
     * <note>
     * <ul>
     * <li>
     * <p>
     * This functionality is not supported for directory buckets.
     * </p>
     * </li>
     * <li>
     * <p>
     * This functionality is not supported for Amazon S3 on Outposts.
     * </p>
     * </li>
     * </ul>
     * </note>
     * 
     * @return Gives the grantee READ, READ_ACP, and WRITE_ACP permissions on the object.</p> <note>
     *         <ul>
     *         <li>
     *         <p>
     *         This functionality is not supported for directory buckets.
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         This functionality is not supported for Amazon S3 on Outposts.
     *         </p>
     *         </li>
     *         </ul>
     */
    public final String grantFullControl() {
        return grantFullControl;
    }

    /**
     * <p>
     * Allows grantee to read the object data and its metadata.
     * </p>
     * <note>
     * <ul>
     * <li>
     * <p>
     * This functionality is not supported for directory buckets.
     * </p>
     * </li>
     * <li>
     * <p>
     * This functionality is not supported for Amazon S3 on Outposts.
     * </p>
     * </li>
     * </ul>
     * </note>
     * 
     * @return Allows grantee to read the object data and its metadata.</p> <note>
     *         <ul>
     *         <li>
     *         <p>
     *         This functionality is not supported for directory buckets.
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         This functionality is not supported for Amazon S3 on Outposts.
     *         </p>
     *         </li>
     *         </ul>
     */
    public final String grantRead() {
        return grantRead;
    }

    /**
     * <p>
     * Allows grantee to read the object ACL.
     * </p>
     * <note>
     * <ul>
     * <li>
     * <p>
     * This functionality is not supported for directory buckets.
     * </p>
     * </li>
     * <li>
     * <p>
     * This functionality is not supported for Amazon S3 on Outposts.
     * </p>
     * </li>
     * </ul>
     * </note>
     * 
     * @return Allows grantee to read the object ACL.</p> <note>
     *         <ul>
     *         <li>
     *         <p>
     *         This functionality is not supported for directory buckets.
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         This functionality is not supported for Amazon S3 on Outposts.
     *         </p>
     *         </li>
     *         </ul>
     */
    public final String grantReadACP() {
        return grantReadACP;
    }

    /**
     * <p>
     * Allows grantee to write the ACL for the applicable object.
     * </p>
     * <note>
     * <ul>
     * <li>
     * <p>
     * This functionality is not supported for directory buckets.
     * </p>
     * </li>
     * <li>
     * <p>
     * This functionality is not supported for Amazon S3 on Outposts.
     * </p>
     * </li>
     * </ul>
     * </note>
     * 
     * @return Allows grantee to write the ACL for the applicable object.</p> <note>
     *         <ul>
     *         <li>
     *         <p>
     *         This functionality is not supported for directory buckets.
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         This functionality is not supported for Amazon S3 on Outposts.
     *         </p>
     *         </li>
     *         </ul>
     */
    public final String grantWriteACP() {
        return grantWriteACP;
    }

    /**
     * For responses, this returns true if the service returned a value for the Metadata property. This DOES NOT check
     * that the value is non-empty (for which, you should check the {@code isEmpty()} method on the property). This is
     * useful because the SDK will never return a null collection or map, but you may need to differentiate between the
     * service returning nothing (or null) and the service returning an empty collection or map. For requests, this
     * returns true if a value for the property was specified in the request builder, and false if a value was not
     * specified.
     */
    public final boolean hasMetadata() {
        return metadata != null && !(metadata instanceof SdkAutoConstructMap);
    }

    /**
     * <p>
     * A map of metadata to store with the object in S3.
     * </p>
     * <p>
     * Attempts to modify the collection returned by this method will result in an UnsupportedOperationException.
     * </p>
     * <p>
     * This method will never return null. If you would like to know whether the service returned this field (so that
     * you can differentiate between null and empty), you can use the {@link #hasMetadata} method.
     * </p>
     * 
     * @return A map of metadata to store with the object in S3.
     */
    public final Map<String, String> metadata() {
        return metadata;
    }

    /**
     * <p>
     * Specifies whether the metadata is copied from the source object or replaced with metadata that's provided in the
     * request. When copying an object, you can preserve all metadata (the default) or specify new metadata. If this
     * header isn’t specified, <code>COPY</code> is the default behavior.
     * </p>
     * <p>
     * <b>General purpose bucket</b> - For general purpose buckets, when you grant permissions, you can use the
     * <code>s3:x-amz-metadata-directive</code> condition key to enforce certain metadata behavior when objects are
     * uploaded. For more information, see <a
     * href="https://docs.aws.amazon.com/AmazonS3/latest/dev/amazon-s3-policy-keys.html">Amazon S3 condition key
     * examples</a> in the <i>Amazon S3 User Guide</i>.
     * </p>
     * <note>
     * <p>
     * <code>x-amz-website-redirect-location</code> is unique to each object and is not copied when using the
     * <code>x-amz-metadata-directive</code> header. To copy the value, you must specify
     * <code>x-amz-website-redirect-location</code> in the request header.
     * </p>
     * </note>
     * <p>
     * If the service returns an enum value that is not available in the current SDK version, {@link #metadataDirective}
     * will return {@link MetadataDirective#UNKNOWN_TO_SDK_VERSION}. The raw value returned by the service is available
     * from {@link #metadataDirectiveAsString}.
     * </p>
     * 
     * @return Specifies whether the metadata is copied from the source object or replaced with metadata that's provided
     *         in the request. When copying an object, you can preserve all metadata (the default) or specify new
     *         metadata. If this header isn’t specified, <code>COPY</code> is the default behavior. </p>
     *         <p>
     *         <b>General purpose bucket</b> - For general purpose buckets, when you grant permissions, you can use the
     *         <code>s3:x-amz-metadata-directive</code> condition key to enforce certain metadata behavior when objects
     *         are uploaded. For more information, see <a
     *         href="https://docs.aws.amazon.com/AmazonS3/latest/dev/amazon-s3-policy-keys.html">Amazon S3 condition key
     *         examples</a> in the <i>Amazon S3 User Guide</i>.
     *         </p>
     *         <note>
     *         <p>
     *         <code>x-amz-website-redirect-location</code> is unique to each object and is not copied when using the
     *         <code>x-amz-metadata-directive</code> header. To copy the value, you must specify
     *         <code>x-amz-website-redirect-location</code> in the request header.
     *         </p>
     * @see MetadataDirective
     */
    public final MetadataDirective metadataDirective() {
        return MetadataDirective.fromValue(metadataDirective);
    }

    /**
     * <p>
     * Specifies whether the metadata is copied from the source object or replaced with metadata that's provided in the
     * request. When copying an object, you can preserve all metadata (the default) or specify new metadata. If this
     * header isn’t specified, <code>COPY</code> is the default behavior.
     * </p>
     * <p>
     * <b>General purpose bucket</b> - For general purpose buckets, when you grant permissions, you can use the
     * <code>s3:x-amz-metadata-directive</code> condition key to enforce certain metadata behavior when objects are
     * uploaded. For more information, see <a
     * href="https://docs.aws.amazon.com/AmazonS3/latest/dev/amazon-s3-policy-keys.html">Amazon S3 condition key
     * examples</a> in the <i>Amazon S3 User Guide</i>.
     * </p>
     * <note>
     * <p>
     * <code>x-amz-website-redirect-location</code> is unique to each object and is not copied when using the
     * <code>x-amz-metadata-directive</code> header. To copy the value, you must specify
     * <code>x-amz-website-redirect-location</code> in the request header.
     * </p>
     * </note>
     * <p>
     * If the service returns an enum value that is not available in the current SDK version, {@link #metadataDirective}
     * will return {@link MetadataDirective#UNKNOWN_TO_SDK_VERSION}. The raw value returned by the service is available
     * from {@link #metadataDirectiveAsString}.
     * </p>
     * 
     * @return Specifies whether the metadata is copied from the source object or replaced with metadata that's provided
     *         in the request. When copying an object, you can preserve all metadata (the default) or specify new
     *         metadata. If this header isn’t specified, <code>COPY</code> is the default behavior. </p>
     *         <p>
     *         <b>General purpose bucket</b> - For general purpose buckets, when you grant permissions, you can use the
     *         <code>s3:x-amz-metadata-directive</code> condition key to enforce certain metadata behavior when objects
     *         are uploaded. For more information, see <a
     *         href="https://docs.aws.amazon.com/AmazonS3/latest/dev/amazon-s3-policy-keys.html">Amazon S3 condition key
     *         examples</a> in the <i>Amazon S3 User Guide</i>.
     *         </p>
     *         <note>
     *         <p>
     *         <code>x-amz-website-redirect-location</code> is unique to each object and is not copied when using the
     *         <code>x-amz-metadata-directive</code> header. To copy the value, you must specify
     *         <code>x-amz-website-redirect-location</code> in the request header.
     *         </p>
     * @see MetadataDirective
     */
    public final String metadataDirectiveAsString() {
        return metadataDirective;
    }

    /**
     * <p>
     * Specifies whether the object tag-set is copied from the source object or replaced with the tag-set that's
     * provided in the request.
     * </p>
     * <p>
     * The default value is <code>COPY</code>.
     * </p>
     * <note>
     * <p>
     * <b>Directory buckets</b> - For directory buckets in a <code>CopyObject</code> operation, only the empty tag-set
     * is supported. Any requests that attempt to write non-empty tags into directory buckets will receive a
     * <code>501 Not Implemented</code> status code. When the destination bucket is a directory bucket, you will receive
     * a <code>501 Not Implemented</code> response in any of the following situations:
     * </p>
     * <ul>
     * <li>
     * <p>
     * When you attempt to <code>COPY</code> the tag-set from an S3 source object that has non-empty tags.
     * </p>
     * </li>
     * <li>
     * <p>
     * When you attempt to <code>REPLACE</code> the tag-set of a source object and set a non-empty value to
     * <code>x-amz-tagging</code>.
     * </p>
     * </li>
     * <li>
     * <p>
     * When you don't set the <code>x-amz-tagging-directive</code> header and the source object has non-empty tags. This
     * is because the default value of <code>x-amz-tagging-directive</code> is <code>COPY</code>.
     * </p>
     * </li>
     * </ul>
     * <p>
     * Because only the empty tag-set is supported for directory buckets in a <code>CopyObject</code> operation, the
     * following situations are allowed:
     * </p>
     * <ul>
     * <li>
     * <p>
     * When you attempt to <code>COPY</code> the tag-set from a directory bucket source object that has no tags to a
     * general purpose bucket. It copies an empty tag-set to the destination object.
     * </p>
     * </li>
     * <li>
     * <p>
     * When you attempt to <code>REPLACE</code> the tag-set of a directory bucket source object and set the
     * <code>x-amz-tagging</code> value of the directory bucket destination object to empty.
     * </p>
     * </li>
     * <li>
     * <p>
     * When you attempt to <code>REPLACE</code> the tag-set of a general purpose bucket source object that has non-empty
     * tags and set the <code>x-amz-tagging</code> value of the directory bucket destination object to empty.
     * </p>
     * </li>
     * <li>
     * <p>
     * When you attempt to <code>REPLACE</code> the tag-set of a directory bucket source object and don't set the
     * <code>x-amz-tagging</code> value of the directory bucket destination object. This is because the default value of
     * <code>x-amz-tagging</code> is the empty value.
     * </p>
     * </li>
     * </ul>
     * </note>
     * <p>
     * If the service returns an enum value that is not available in the current SDK version, {@link #taggingDirective}
     * will return {@link TaggingDirective#UNKNOWN_TO_SDK_VERSION}. The raw value returned by the service is available
     * from {@link #taggingDirectiveAsString}.
     * </p>
     * 
     * @return Specifies whether the object tag-set is copied from the source object or replaced with the tag-set that's
     *         provided in the request.</p>
     *         <p>
     *         The default value is <code>COPY</code>.
     *         </p>
     *         <note>
     *         <p>
     *         <b>Directory buckets</b> - For directory buckets in a <code>CopyObject</code> operation, only the empty
     *         tag-set is supported. Any requests that attempt to write non-empty tags into directory buckets will
     *         receive a <code>501 Not Implemented</code> status code. When the destination bucket is a directory
     *         bucket, you will receive a <code>501 Not Implemented</code> response in any of the following situations:
     *         </p>
     *         <ul>
     *         <li>
     *         <p>
     *         When you attempt to <code>COPY</code> the tag-set from an S3 source object that has non-empty tags.
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         When you attempt to <code>REPLACE</code> the tag-set of a source object and set a non-empty value to
     *         <code>x-amz-tagging</code>.
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         When you don't set the <code>x-amz-tagging-directive</code> header and the source object has non-empty
     *         tags. This is because the default value of <code>x-amz-tagging-directive</code> is <code>COPY</code>.
     *         </p>
     *         </li>
     *         </ul>
     *         <p>
     *         Because only the empty tag-set is supported for directory buckets in a <code>CopyObject</code> operation,
     *         the following situations are allowed:
     *         </p>
     *         <ul>
     *         <li>
     *         <p>
     *         When you attempt to <code>COPY</code> the tag-set from a directory bucket source object that has no tags
     *         to a general purpose bucket. It copies an empty tag-set to the destination object.
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         When you attempt to <code>REPLACE</code> the tag-set of a directory bucket source object and set the
     *         <code>x-amz-tagging</code> value of the directory bucket destination object to empty.
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         When you attempt to <code>REPLACE</code> the tag-set of a general purpose bucket source object that has
     *         non-empty tags and set the <code>x-amz-tagging</code> value of the directory bucket destination object to
     *         empty.
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         When you attempt to <code>REPLACE</code> the tag-set of a directory bucket source object and don't set
     *         the <code>x-amz-tagging</code> value of the directory bucket destination object. This is because the
     *         default value of <code>x-amz-tagging</code> is the empty value.
     *         </p>
     *         </li>
     *         </ul>
     * @see TaggingDirective
     */
    public final TaggingDirective taggingDirective() {
        return TaggingDirective.fromValue(taggingDirective);
    }

    /**
     * <p>
     * Specifies whether the object tag-set is copied from the source object or replaced with the tag-set that's
     * provided in the request.
     * </p>
     * <p>
     * The default value is <code>COPY</code>.
     * </p>
     * <note>
     * <p>
     * <b>Directory buckets</b> - For directory buckets in a <code>CopyObject</code> operation, only the empty tag-set
     * is supported. Any requests that attempt to write non-empty tags into directory buckets will receive a
     * <code>501 Not Implemented</code> status code. When the destination bucket is a directory bucket, you will receive
     * a <code>501 Not Implemented</code> response in any of the following situations:
     * </p>
     * <ul>
     * <li>
     * <p>
     * When you attempt to <code>COPY</code> the tag-set from an S3 source object that has non-empty tags.
     * </p>
     * </li>
     * <li>
     * <p>
     * When you attempt to <code>REPLACE</code> the tag-set of a source object and set a non-empty value to
     * <code>x-amz-tagging</code>.
     * </p>
     * </li>
     * <li>
     * <p>
     * When you don't set the <code>x-amz-tagging-directive</code> header and the source object has non-empty tags. This
     * is because the default value of <code>x-amz-tagging-directive</code> is <code>COPY</code>.
     * </p>
     * </li>
     * </ul>
     * <p>
     * Because only the empty tag-set is supported for directory buckets in a <code>CopyObject</code> operation, the
     * following situations are allowed:
     * </p>
     * <ul>
     * <li>
     * <p>
     * When you attempt to <code>COPY</code> the tag-set from a directory bucket source object that has no tags to a
     * general purpose bucket. It copies an empty tag-set to the destination object.
     * </p>
     * </li>
     * <li>
     * <p>
     * When you attempt to <code>REPLACE</code> the tag-set of a directory bucket source object and set the
     * <code>x-amz-tagging</code> value of the directory bucket destination object to empty.
     * </p>
     * </li>
     * <li>
     * <p>
     * When you attempt to <code>REPLACE</code> the tag-set of a general purpose bucket source object that has non-empty
     * tags and set the <code>x-amz-tagging</code> value of the directory bucket destination object to empty.
     * </p>
     * </li>
     * <li>
     * <p>
     * When you attempt to <code>REPLACE</code> the tag-set of a directory bucket source object and don't set the
     * <code>x-amz-tagging</code> value of the directory bucket destination object. This is because the default value of
     * <code>x-amz-tagging</code> is the empty value.
     * </p>
     * </li>
     * </ul>
     * </note>
     * <p>
     * If the service returns an enum value that is not available in the current SDK version, {@link #taggingDirective}
     * will return {@link TaggingDirective#UNKNOWN_TO_SDK_VERSION}. The raw value returned by the service is available
     * from {@link #taggingDirectiveAsString}.
     * </p>
     * 
     * @return Specifies whether the object tag-set is copied from the source object or replaced with the tag-set that's
     *         provided in the request.</p>
     *         <p>
     *         The default value is <code>COPY</code>.
     *         </p>
     *         <note>
     *         <p>
     *         <b>Directory buckets</b> - For directory buckets in a <code>CopyObject</code> operation, only the empty
     *         tag-set is supported. Any requests that attempt to write non-empty tags into directory buckets will
     *         receive a <code>501 Not Implemented</code> status code. When the destination bucket is a directory
     *         bucket, you will receive a <code>501 Not Implemented</code> response in any of the following situations:
     *         </p>
     *         <ul>
     *         <li>
     *         <p>
     *         When you attempt to <code>COPY</code> the tag-set from an S3 source object that has non-empty tags.
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         When you attempt to <code>REPLACE</code> the tag-set of a source object and set a non-empty value to
     *         <code>x-amz-tagging</code>.
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         When you don't set the <code>x-amz-tagging-directive</code> header and the source object has non-empty
     *         tags. This is because the default value of <code>x-amz-tagging-directive</code> is <code>COPY</code>.
     *         </p>
     *         </li>
     *         </ul>
     *         <p>
     *         Because only the empty tag-set is supported for directory buckets in a <code>CopyObject</code> operation,
     *         the following situations are allowed:
     *         </p>
     *         <ul>
     *         <li>
     *         <p>
     *         When you attempt to <code>COPY</code> the tag-set from a directory bucket source object that has no tags
     *         to a general purpose bucket. It copies an empty tag-set to the destination object.
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         When you attempt to <code>REPLACE</code> the tag-set of a directory bucket source object and set the
     *         <code>x-amz-tagging</code> value of the directory bucket destination object to empty.
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         When you attempt to <code>REPLACE</code> the tag-set of a general purpose bucket source object that has
     *         non-empty tags and set the <code>x-amz-tagging</code> value of the directory bucket destination object to
     *         empty.
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         When you attempt to <code>REPLACE</code> the tag-set of a directory bucket source object and don't set
     *         the <code>x-amz-tagging</code> value of the directory bucket destination object. This is because the
     *         default value of <code>x-amz-tagging</code> is the empty value.
     *         </p>
     *         </li>
     *         </ul>
     * @see TaggingDirective
     */
    public final String taggingDirectiveAsString() {
        return taggingDirective;
    }

    /**
     * <p>
     * The server-side encryption algorithm used when storing this object in Amazon S3. Unrecognized or unsupported
     * values won’t write a destination object and will receive a <code>400 Bad Request</code> response.
     * </p>
     * <p>
     * Amazon S3 automatically encrypts all new objects that are copied to an S3 bucket. When copying an object, if you
     * don't specify encryption information in your copy request, the encryption setting of the target object is set to
     * the default encryption configuration of the destination bucket. By default, all buckets have a base level of
     * encryption configuration that uses server-side encryption with Amazon S3 managed keys (SSE-S3). If the
     * destination bucket has a different default encryption configuration, Amazon S3 uses the corresponding encryption
     * key to encrypt the target object copy.
     * </p>
     * <p>
     * With server-side encryption, Amazon S3 encrypts your data as it writes your data to disks in its data centers and
     * decrypts the data when you access it. For more information about server-side encryption, see <a
     * href="https://docs.aws.amazon.com/AmazonS3/latest/dev/serv-side-encryption.html">Using Server-Side Encryption</a>
     * in the <i>Amazon S3 User Guide</i>.
     * </p>
     * <p>
     * <b>General purpose buckets </b>
     * </p>
     * <ul>
     * <li>
     * <p>
     * For general purpose buckets, there are the following supported options for server-side encryption: server-side
     * encryption with Key Management Service (KMS) keys (SSE-KMS), dual-layer server-side encryption with Amazon Web
     * Services KMS keys (DSSE-KMS), and server-side encryption with customer-provided encryption keys (SSE-C). Amazon
     * S3 uses the corresponding KMS key, or a customer-provided key to encrypt the target object copy.
     * </p>
     * </li>
     * <li>
     * <p>
     * When you perform a <code>CopyObject</code> operation, if you want to use a different type of encryption setting
     * for the target object, you can specify appropriate encryption-related headers to encrypt the target object with
     * an Amazon S3 managed key, a KMS key, or a customer-provided key. If the encryption setting in your request is
     * different from the default encryption configuration of the destination bucket, the encryption setting in your
     * request takes precedence.
     * </p>
     * </li>
     * </ul>
     * <p>
     * <b>Directory buckets </b>
     * </p>
     * <ul>
     * <li>
     * <p>
     * For directory buckets, there are only two supported options for server-side encryption: server-side encryption
     * with Amazon S3 managed keys (SSE-S3) (<code>AES256</code>) and server-side encryption with KMS keys (SSE-KMS) (
     * <code>aws:kms</code>). We recommend that the bucket's default encryption uses the desired encryption
     * configuration and you don't override the bucket default encryption in your <code>CreateSession</code> requests or
     * <code>PUT</code> object requests. Then, new objects are automatically encrypted with the desired encryption
     * settings. For more information, see <a
     * href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/s3-express-serv-side-encryption.html">Protecting data
     * with server-side encryption</a> in the <i>Amazon S3 User Guide</i>. For more information about the encryption
     * overriding behaviors in directory buckets, see <a
     * href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/s3-express-specifying-kms-encryption.html">Specifying
     * server-side encryption with KMS for new object uploads</a>.
     * </p>
     * </li>
     * <li>
     * <p>
     * To encrypt new object copies to a directory bucket with SSE-KMS, we recommend you specify SSE-KMS as the
     * directory bucket's default encryption configuration with a KMS key (specifically, a <a
     * href="https://docs.aws.amazon.com/kms/latest/developerguide/concepts.html#customer-cmk">customer managed
     * key</a>). The <a
     * href="https://docs.aws.amazon.com/kms/latest/developerguide/concepts.html#aws-managed-cmk">Amazon Web Services
     * managed key</a> (<code>aws/s3</code>) isn't supported. Your SSE-KMS configuration can only support 1 <a
     * href="https://docs.aws.amazon.com/kms/latest/developerguide/concepts.html#customer-cmk">customer managed key</a>
     * per directory bucket for the lifetime of the bucket. After you specify a customer managed key for SSE-KMS, you
     * can't override the customer managed key for the bucket's SSE-KMS configuration. Then, when you perform a
     * <code>CopyObject</code> operation and want to specify server-side encryption settings for new object copies with
     * SSE-KMS in the encryption-related request headers, you must ensure the encryption key is the same customer
     * managed key that you specified for the directory bucket's default encryption configuration.
     * </p>
     * </li>
     * </ul>
     * <p>
     * If the service returns an enum value that is not available in the current SDK version,
     * {@link #serverSideEncryption} will return {@link ServerSideEncryption#UNKNOWN_TO_SDK_VERSION}. The raw value
     * returned by the service is available from {@link #serverSideEncryptionAsString}.
     * </p>
     * 
     * @return The server-side encryption algorithm used when storing this object in Amazon S3. Unrecognized or
     *         unsupported values won’t write a destination object and will receive a <code>400 Bad Request</code>
     *         response. </p>
     *         <p>
     *         Amazon S3 automatically encrypts all new objects that are copied to an S3 bucket. When copying an object,
     *         if you don't specify encryption information in your copy request, the encryption setting of the target
     *         object is set to the default encryption configuration of the destination bucket. By default, all buckets
     *         have a base level of encryption configuration that uses server-side encryption with Amazon S3 managed
     *         keys (SSE-S3). If the destination bucket has a different default encryption configuration, Amazon S3 uses
     *         the corresponding encryption key to encrypt the target object copy.
     *         </p>
     *         <p>
     *         With server-side encryption, Amazon S3 encrypts your data as it writes your data to disks in its data
     *         centers and decrypts the data when you access it. For more information about server-side encryption, see
     *         <a href="https://docs.aws.amazon.com/AmazonS3/latest/dev/serv-side-encryption.html">Using Server-Side
     *         Encryption</a> in the <i>Amazon S3 User Guide</i>.
     *         </p>
     *         <p>
     *         <b>General purpose buckets </b>
     *         </p>
     *         <ul>
     *         <li>
     *         <p>
     *         For general purpose buckets, there are the following supported options for server-side encryption:
     *         server-side encryption with Key Management Service (KMS) keys (SSE-KMS), dual-layer server-side
     *         encryption with Amazon Web Services KMS keys (DSSE-KMS), and server-side encryption with
     *         customer-provided encryption keys (SSE-C). Amazon S3 uses the corresponding KMS key, or a
     *         customer-provided key to encrypt the target object copy.
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         When you perform a <code>CopyObject</code> operation, if you want to use a different type of encryption
     *         setting for the target object, you can specify appropriate encryption-related headers to encrypt the
     *         target object with an Amazon S3 managed key, a KMS key, or a customer-provided key. If the encryption
     *         setting in your request is different from the default encryption configuration of the destination bucket,
     *         the encryption setting in your request takes precedence.
     *         </p>
     *         </li>
     *         </ul>
     *         <p>
     *         <b>Directory buckets </b>
     *         </p>
     *         <ul>
     *         <li>
     *         <p>
     *         For directory buckets, there are only two supported options for server-side encryption: server-side
     *         encryption with Amazon S3 managed keys (SSE-S3) (<code>AES256</code>) and server-side encryption with KMS
     *         keys (SSE-KMS) (<code>aws:kms</code>). We recommend that the bucket's default encryption uses the desired
     *         encryption configuration and you don't override the bucket default encryption in your
     *         <code>CreateSession</code> requests or <code>PUT</code> object requests. Then, new objects are
     *         automatically encrypted with the desired encryption settings. For more information, see <a
     *         href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/s3-express-serv-side-encryption.html"
     *         >Protecting data with server-side encryption</a> in the <i>Amazon S3 User Guide</i>. For more information
     *         about the encryption overriding behaviors in directory buckets, see <a
     *         href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/s3-express-specifying-kms-encryption.html"
     *         >Specifying server-side encryption with KMS for new object uploads</a>.
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         To encrypt new object copies to a directory bucket with SSE-KMS, we recommend you specify SSE-KMS as the
     *         directory bucket's default encryption configuration with a KMS key (specifically, a <a
     *         href="https://docs.aws.amazon.com/kms/latest/developerguide/concepts.html#customer-cmk">customer managed
     *         key</a>). The <a
     *         href="https://docs.aws.amazon.com/kms/latest/developerguide/concepts.html#aws-managed-cmk">Amazon Web
     *         Services managed key</a> (<code>aws/s3</code>) isn't supported. Your SSE-KMS configuration can only
     *         support 1 <a
     *         href="https://docs.aws.amazon.com/kms/latest/developerguide/concepts.html#customer-cmk">customer managed
     *         key</a> per directory bucket for the lifetime of the bucket. After you specify a customer managed key for
     *         SSE-KMS, you can't override the customer managed key for the bucket's SSE-KMS configuration. Then, when
     *         you perform a <code>CopyObject</code> operation and want to specify server-side encryption settings for
     *         new object copies with SSE-KMS in the encryption-related request headers, you must ensure the encryption
     *         key is the same customer managed key that you specified for the directory bucket's default encryption
     *         configuration.
     *         </p>
     *         </li>
     * @see ServerSideEncryption
     */
    public final ServerSideEncryption serverSideEncryption() {
        return ServerSideEncryption.fromValue(serverSideEncryption);
    }

    /**
     * <p>
     * The server-side encryption algorithm used when storing this object in Amazon S3. Unrecognized or unsupported
     * values won’t write a destination object and will receive a <code>400 Bad Request</code> response.
     * </p>
     * <p>
     * Amazon S3 automatically encrypts all new objects that are copied to an S3 bucket. When copying an object, if you
     * don't specify encryption information in your copy request, the encryption setting of the target object is set to
     * the default encryption configuration of the destination bucket. By default, all buckets have a base level of
     * encryption configuration that uses server-side encryption with Amazon S3 managed keys (SSE-S3). If the
     * destination bucket has a different default encryption configuration, Amazon S3 uses the corresponding encryption
     * key to encrypt the target object copy.
     * </p>
     * <p>
     * With server-side encryption, Amazon S3 encrypts your data as it writes your data to disks in its data centers and
     * decrypts the data when you access it. For more information about server-side encryption, see <a
     * href="https://docs.aws.amazon.com/AmazonS3/latest/dev/serv-side-encryption.html">Using Server-Side Encryption</a>
     * in the <i>Amazon S3 User Guide</i>.
     * </p>
     * <p>
     * <b>General purpose buckets </b>
     * </p>
     * <ul>
     * <li>
     * <p>
     * For general purpose buckets, there are the following supported options for server-side encryption: server-side
     * encryption with Key Management Service (KMS) keys (SSE-KMS), dual-layer server-side encryption with Amazon Web
     * Services KMS keys (DSSE-KMS), and server-side encryption with customer-provided encryption keys (SSE-C). Amazon
     * S3 uses the corresponding KMS key, or a customer-provided key to encrypt the target object copy.
     * </p>
     * </li>
     * <li>
     * <p>
     * When you perform a <code>CopyObject</code> operation, if you want to use a different type of encryption setting
     * for the target object, you can specify appropriate encryption-related headers to encrypt the target object with
     * an Amazon S3 managed key, a KMS key, or a customer-provided key. If the encryption setting in your request is
     * different from the default encryption configuration of the destination bucket, the encryption setting in your
     * request takes precedence.
     * </p>
     * </li>
     * </ul>
     * <p>
     * <b>Directory buckets </b>
     * </p>
     * <ul>
     * <li>
     * <p>
     * For directory buckets, there are only two supported options for server-side encryption: server-side encryption
     * with Amazon S3 managed keys (SSE-S3) (<code>AES256</code>) and server-side encryption with KMS keys (SSE-KMS) (
     * <code>aws:kms</code>). We recommend that the bucket's default encryption uses the desired encryption
     * configuration and you don't override the bucket default encryption in your <code>CreateSession</code> requests or
     * <code>PUT</code> object requests. Then, new objects are automatically encrypted with the desired encryption
     * settings. For more information, see <a
     * href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/s3-express-serv-side-encryption.html">Protecting data
     * with server-side encryption</a> in the <i>Amazon S3 User Guide</i>. For more information about the encryption
     * overriding behaviors in directory buckets, see <a
     * href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/s3-express-specifying-kms-encryption.html">Specifying
     * server-side encryption with KMS for new object uploads</a>.
     * </p>
     * </li>
     * <li>
     * <p>
     * To encrypt new object copies to a directory bucket with SSE-KMS, we recommend you specify SSE-KMS as the
     * directory bucket's default encryption configuration with a KMS key (specifically, a <a
     * href="https://docs.aws.amazon.com/kms/latest/developerguide/concepts.html#customer-cmk">customer managed
     * key</a>). The <a
     * href="https://docs.aws.amazon.com/kms/latest/developerguide/concepts.html#aws-managed-cmk">Amazon Web Services
     * managed key</a> (<code>aws/s3</code>) isn't supported. Your SSE-KMS configuration can only support 1 <a
     * href="https://docs.aws.amazon.com/kms/latest/developerguide/concepts.html#customer-cmk">customer managed key</a>
     * per directory bucket for the lifetime of the bucket. After you specify a customer managed key for SSE-KMS, you
     * can't override the customer managed key for the bucket's SSE-KMS configuration. Then, when you perform a
     * <code>CopyObject</code> operation and want to specify server-side encryption settings for new object copies with
     * SSE-KMS in the encryption-related request headers, you must ensure the encryption key is the same customer
     * managed key that you specified for the directory bucket's default encryption configuration.
     * </p>
     * </li>
     * </ul>
     * <p>
     * If the service returns an enum value that is not available in the current SDK version,
     * {@link #serverSideEncryption} will return {@link ServerSideEncryption#UNKNOWN_TO_SDK_VERSION}. The raw value
     * returned by the service is available from {@link #serverSideEncryptionAsString}.
     * </p>
     * 
     * @return The server-side encryption algorithm used when storing this object in Amazon S3. Unrecognized or
     *         unsupported values won’t write a destination object and will receive a <code>400 Bad Request</code>
     *         response. </p>
     *         <p>
     *         Amazon S3 automatically encrypts all new objects that are copied to an S3 bucket. When copying an object,
     *         if you don't specify encryption information in your copy request, the encryption setting of the target
     *         object is set to the default encryption configuration of the destination bucket. By default, all buckets
     *         have a base level of encryption configuration that uses server-side encryption with Amazon S3 managed
     *         keys (SSE-S3). If the destination bucket has a different default encryption configuration, Amazon S3 uses
     *         the corresponding encryption key to encrypt the target object copy.
     *         </p>
     *         <p>
     *         With server-side encryption, Amazon S3 encrypts your data as it writes your data to disks in its data
     *         centers and decrypts the data when you access it. For more information about server-side encryption, see
     *         <a href="https://docs.aws.amazon.com/AmazonS3/latest/dev/serv-side-encryption.html">Using Server-Side
     *         Encryption</a> in the <i>Amazon S3 User Guide</i>.
     *         </p>
     *         <p>
     *         <b>General purpose buckets </b>
     *         </p>
     *         <ul>
     *         <li>
     *         <p>
     *         For general purpose buckets, there are the following supported options for server-side encryption:
     *         server-side encryption with Key Management Service (KMS) keys (SSE-KMS), dual-layer server-side
     *         encryption with Amazon Web Services KMS keys (DSSE-KMS), and server-side encryption with
     *         customer-provided encryption keys (SSE-C). Amazon S3 uses the corresponding KMS key, or a
     *         customer-provided key to encrypt the target object copy.
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         When you perform a <code>CopyObject</code> operation, if you want to use a different type of encryption
     *         setting for the target object, you can specify appropriate encryption-related headers to encrypt the
     *         target object with an Amazon S3 managed key, a KMS key, or a customer-provided key. If the encryption
     *         setting in your request is different from the default encryption configuration of the destination bucket,
     *         the encryption setting in your request takes precedence.
     *         </p>
     *         </li>
     *         </ul>
     *         <p>
     *         <b>Directory buckets </b>
     *         </p>
     *         <ul>
     *         <li>
     *         <p>
     *         For directory buckets, there are only two supported options for server-side encryption: server-side
     *         encryption with Amazon S3 managed keys (SSE-S3) (<code>AES256</code>) and server-side encryption with KMS
     *         keys (SSE-KMS) (<code>aws:kms</code>). We recommend that the bucket's default encryption uses the desired
     *         encryption configuration and you don't override the bucket default encryption in your
     *         <code>CreateSession</code> requests or <code>PUT</code> object requests. Then, new objects are
     *         automatically encrypted with the desired encryption settings. For more information, see <a
     *         href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/s3-express-serv-side-encryption.html"
     *         >Protecting data with server-side encryption</a> in the <i>Amazon S3 User Guide</i>. For more information
     *         about the encryption overriding behaviors in directory buckets, see <a
     *         href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/s3-express-specifying-kms-encryption.html"
     *         >Specifying server-side encryption with KMS for new object uploads</a>.
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         To encrypt new object copies to a directory bucket with SSE-KMS, we recommend you specify SSE-KMS as the
     *         directory bucket's default encryption configuration with a KMS key (specifically, a <a
     *         href="https://docs.aws.amazon.com/kms/latest/developerguide/concepts.html#customer-cmk">customer managed
     *         key</a>). The <a
     *         href="https://docs.aws.amazon.com/kms/latest/developerguide/concepts.html#aws-managed-cmk">Amazon Web
     *         Services managed key</a> (<code>aws/s3</code>) isn't supported. Your SSE-KMS configuration can only
     *         support 1 <a
     *         href="https://docs.aws.amazon.com/kms/latest/developerguide/concepts.html#customer-cmk">customer managed
     *         key</a> per directory bucket for the lifetime of the bucket. After you specify a customer managed key for
     *         SSE-KMS, you can't override the customer managed key for the bucket's SSE-KMS configuration. Then, when
     *         you perform a <code>CopyObject</code> operation and want to specify server-side encryption settings for
     *         new object copies with SSE-KMS in the encryption-related request headers, you must ensure the encryption
     *         key is the same customer managed key that you specified for the directory bucket's default encryption
     *         configuration.
     *         </p>
     *         </li>
     * @see ServerSideEncryption
     */
    public final String serverSideEncryptionAsString() {
        return serverSideEncryption;
    }

    /**
     * <p>
     * If the <code>x-amz-storage-class</code> header is not used, the copied object will be stored in the
     * <code>STANDARD</code> Storage Class by default. The <code>STANDARD</code> storage class provides high durability
     * and high availability. Depending on performance needs, you can specify a different Storage Class.
     * </p>
     * <note>
     * <ul>
     * <li>
     * <p>
     * <b>Directory buckets </b> - Directory buckets only support <code>EXPRESS_ONEZONE</code> (the S3 Express One Zone
     * storage class) in Availability Zones and <code>ONEZONE_IA</code> (the S3 One Zone-Infrequent Access storage
     * class) in Dedicated Local Zones. Unsupported storage class values won't write a destination object and will
     * respond with the HTTP status code <code>400 Bad Request</code>.
     * </p>
     * </li>
     * <li>
     * <p>
     * <b>Amazon S3 on Outposts </b> - S3 on Outposts only uses the <code>OUTPOSTS</code> Storage Class.
     * </p>
     * </li>
     * </ul>
     * </note>
     * <p>
     * You can use the <code>CopyObject</code> action to change the storage class of an object that is already stored in
     * Amazon S3 by using the <code>x-amz-storage-class</code> header. For more information, see <a
     * href="https://docs.aws.amazon.com/AmazonS3/latest/dev/storage-class-intro.html">Storage Classes</a> in the
     * <i>Amazon S3 User Guide</i>.
     * </p>
     * <p>
     * Before using an object as a source object for the copy operation, you must restore a copy of it if it meets any
     * of the following conditions:
     * </p>
     * <ul>
     * <li>
     * <p>
     * The storage class of the source object is <code>GLACIER</code> or <code>DEEP_ARCHIVE</code>.
     * </p>
     * </li>
     * <li>
     * <p>
     * The storage class of the source object is <code>INTELLIGENT_TIERING</code> and it's <a href=
     * "https://docs.aws.amazon.com/AmazonS3/latest/userguide/intelligent-tiering-overview.html#intel-tiering-tier-definition"
     * >S3 Intelligent-Tiering access tier</a> is <code>Archive Access</code> or <code>Deep Archive Access</code>.
     * </p>
     * </li>
     * </ul>
     * <p>
     * For more information, see <a
     * href="https://docs.aws.amazon.com/AmazonS3/latest/API/API_RestoreObject.html">RestoreObject</a> and <a
     * href="https://docs.aws.amazon.com/AmazonS3/latest/dev/CopyingObjectsExamples.html">Copying Objects</a> in the
     * <i>Amazon S3 User Guide</i>.
     * </p>
     * <p>
     * If the service returns an enum value that is not available in the current SDK version, {@link #storageClass} will
     * return {@link StorageClass#UNKNOWN_TO_SDK_VERSION}. The raw value returned by the service is available from
     * {@link #storageClassAsString}.
     * </p>
     * 
     * @return If the <code>x-amz-storage-class</code> header is not used, the copied object will be stored in the
     *         <code>STANDARD</code> Storage Class by default. The <code>STANDARD</code> storage class provides high
     *         durability and high availability. Depending on performance needs, you can specify a different Storage
     *         Class. </p> <note>
     *         <ul>
     *         <li>
     *         <p>
     *         <b>Directory buckets </b> - Directory buckets only support <code>EXPRESS_ONEZONE</code> (the S3 Express
     *         One Zone storage class) in Availability Zones and <code>ONEZONE_IA</code> (the S3 One Zone-Infrequent
     *         Access storage class) in Dedicated Local Zones. Unsupported storage class values won't write a
     *         destination object and will respond with the HTTP status code <code>400 Bad Request</code>.
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         <b>Amazon S3 on Outposts </b> - S3 on Outposts only uses the <code>OUTPOSTS</code> Storage Class.
     *         </p>
     *         </li>
     *         </ul>
     *         </note>
     *         <p>
     *         You can use the <code>CopyObject</code> action to change the storage class of an object that is already
     *         stored in Amazon S3 by using the <code>x-amz-storage-class</code> header. For more information, see <a
     *         href="https://docs.aws.amazon.com/AmazonS3/latest/dev/storage-class-intro.html">Storage Classes</a> in
     *         the <i>Amazon S3 User Guide</i>.
     *         </p>
     *         <p>
     *         Before using an object as a source object for the copy operation, you must restore a copy of it if it
     *         meets any of the following conditions:
     *         </p>
     *         <ul>
     *         <li>
     *         <p>
     *         The storage class of the source object is <code>GLACIER</code> or <code>DEEP_ARCHIVE</code>.
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         The storage class of the source object is <code>INTELLIGENT_TIERING</code> and it's <a href=
     *         "https://docs.aws.amazon.com/AmazonS3/latest/userguide/intelligent-tiering-overview.html#intel-tiering-tier-definition"
     *         >S3 Intelligent-Tiering access tier</a> is <code>Archive Access</code> or
     *         <code>Deep Archive Access</code>.
     *         </p>
     *         </li>
     *         </ul>
     *         <p>
     *         For more information, see <a
     *         href="https://docs.aws.amazon.com/AmazonS3/latest/API/API_RestoreObject.html">RestoreObject</a> and <a
     *         href="https://docs.aws.amazon.com/AmazonS3/latest/dev/CopyingObjectsExamples.html">Copying Objects</a> in
     *         the <i>Amazon S3 User Guide</i>.
     * @see StorageClass
     */
    public final StorageClass storageClass() {
        return StorageClass.fromValue(storageClass);
    }

    /**
     * <p>
     * If the <code>x-amz-storage-class</code> header is not used, the copied object will be stored in the
     * <code>STANDARD</code> Storage Class by default. The <code>STANDARD</code> storage class provides high durability
     * and high availability. Depending on performance needs, you can specify a different Storage Class.
     * </p>
     * <note>
     * <ul>
     * <li>
     * <p>
     * <b>Directory buckets </b> - Directory buckets only support <code>EXPRESS_ONEZONE</code> (the S3 Express One Zone
     * storage class) in Availability Zones and <code>ONEZONE_IA</code> (the S3 One Zone-Infrequent Access storage
     * class) in Dedicated Local Zones. Unsupported storage class values won't write a destination object and will
     * respond with the HTTP status code <code>400 Bad Request</code>.
     * </p>
     * </li>
     * <li>
     * <p>
     * <b>Amazon S3 on Outposts </b> - S3 on Outposts only uses the <code>OUTPOSTS</code> Storage Class.
     * </p>
     * </li>
     * </ul>
     * </note>
     * <p>
     * You can use the <code>CopyObject</code> action to change the storage class of an object that is already stored in
     * Amazon S3 by using the <code>x-amz-storage-class</code> header. For more information, see <a
     * href="https://docs.aws.amazon.com/AmazonS3/latest/dev/storage-class-intro.html">Storage Classes</a> in the
     * <i>Amazon S3 User Guide</i>.
     * </p>
     * <p>
     * Before using an object as a source object for the copy operation, you must restore a copy of it if it meets any
     * of the following conditions:
     * </p>
     * <ul>
     * <li>
     * <p>
     * The storage class of the source object is <code>GLACIER</code> or <code>DEEP_ARCHIVE</code>.
     * </p>
     * </li>
     * <li>
     * <p>
     * The storage class of the source object is <code>INTELLIGENT_TIERING</code> and it's <a href=
     * "https://docs.aws.amazon.com/AmazonS3/latest/userguide/intelligent-tiering-overview.html#intel-tiering-tier-definition"
     * >S3 Intelligent-Tiering access tier</a> is <code>Archive Access</code> or <code>Deep Archive Access</code>.
     * </p>
     * </li>
     * </ul>
     * <p>
     * For more information, see <a
     * href="https://docs.aws.amazon.com/AmazonS3/latest/API/API_RestoreObject.html">RestoreObject</a> and <a
     * href="https://docs.aws.amazon.com/AmazonS3/latest/dev/CopyingObjectsExamples.html">Copying Objects</a> in the
     * <i>Amazon S3 User Guide</i>.
     * </p>
     * <p>
     * If the service returns an enum value that is not available in the current SDK version, {@link #storageClass} will
     * return {@link StorageClass#UNKNOWN_TO_SDK_VERSION}. The raw value returned by the service is available from
     * {@link #storageClassAsString}.
     * </p>
     * 
     * @return If the <code>x-amz-storage-class</code> header is not used, the copied object will be stored in the
     *         <code>STANDARD</code> Storage Class by default. The <code>STANDARD</code> storage class provides high
     *         durability and high availability. Depending on performance needs, you can specify a different Storage
     *         Class. </p> <note>
     *         <ul>
     *         <li>
     *         <p>
     *         <b>Directory buckets </b> - Directory buckets only support <code>EXPRESS_ONEZONE</code> (the S3 Express
     *         One Zone storage class) in Availability Zones and <code>ONEZONE_IA</code> (the S3 One Zone-Infrequent
     *         Access storage class) in Dedicated Local Zones. Unsupported storage class values won't write a
     *         destination object and will respond with the HTTP status code <code>400 Bad Request</code>.
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         <b>Amazon S3 on Outposts </b> - S3 on Outposts only uses the <code>OUTPOSTS</code> Storage Class.
     *         </p>
     *         </li>
     *         </ul>
     *         </note>
     *         <p>
     *         You can use the <code>CopyObject</code> action to change the storage class of an object that is already
     *         stored in Amazon S3 by using the <code>x-amz-storage-class</code> header. For more information, see <a
     *         href="https://docs.aws.amazon.com/AmazonS3/latest/dev/storage-class-intro.html">Storage Classes</a> in
     *         the <i>Amazon S3 User Guide</i>.
     *         </p>
     *         <p>
     *         Before using an object as a source object for the copy operation, you must restore a copy of it if it
     *         meets any of the following conditions:
     *         </p>
     *         <ul>
     *         <li>
     *         <p>
     *         The storage class of the source object is <code>GLACIER</code> or <code>DEEP_ARCHIVE</code>.
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         The storage class of the source object is <code>INTELLIGENT_TIERING</code> and it's <a href=
     *         "https://docs.aws.amazon.com/AmazonS3/latest/userguide/intelligent-tiering-overview.html#intel-tiering-tier-definition"
     *         >S3 Intelligent-Tiering access tier</a> is <code>Archive Access</code> or
     *         <code>Deep Archive Access</code>.
     *         </p>
     *         </li>
     *         </ul>
     *         <p>
     *         For more information, see <a
     *         href="https://docs.aws.amazon.com/AmazonS3/latest/API/API_RestoreObject.html">RestoreObject</a> and <a
     *         href="https://docs.aws.amazon.com/AmazonS3/latest/dev/CopyingObjectsExamples.html">Copying Objects</a> in
     *         the <i>Amazon S3 User Guide</i>.
     * @see StorageClass
     */
    public final String storageClassAsString() {
        return storageClass;
    }

    /**
     * <p>
     * If the destination bucket is configured as a website, redirects requests for this object copy to another object
     * in the same bucket or to an external URL. Amazon S3 stores the value of this header in the object metadata. This
     * value is unique to each object and is not copied when using the <code>x-amz-metadata-directive</code> header.
     * Instead, you may opt to provide this header in combination with the <code>x-amz-metadata-directive</code> header.
     * </p>
     * <note>
     * <p>
     * This functionality is not supported for directory buckets.
     * </p>
     * </note>
     * 
     * @return If the destination bucket is configured as a website, redirects requests for this object copy to another
     *         object in the same bucket or to an external URL. Amazon S3 stores the value of this header in the object
     *         metadata. This value is unique to each object and is not copied when using the
     *         <code>x-amz-metadata-directive</code> header. Instead, you may opt to provide this header in combination
     *         with the <code>x-amz-metadata-directive</code> header.</p> <note>
     *         <p>
     *         This functionality is not supported for directory buckets.
     *         </p>
     */
    public final String websiteRedirectLocation() {
        return websiteRedirectLocation;
    }

    /**
     * <p>
     * Specifies the algorithm to use when encrypting the object (for example, <code>AES256</code>).
     * </p>
     * <p>
     * When you perform a <code>CopyObject</code> operation, if you want to use a different type of encryption setting
     * for the target object, you can specify appropriate encryption-related headers to encrypt the target object with
     * an Amazon S3 managed key, a KMS key, or a customer-provided key. If the encryption setting in your request is
     * different from the default encryption configuration of the destination bucket, the encryption setting in your
     * request takes precedence.
     * </p>
     * <note>
     * <p>
     * This functionality is not supported when the destination bucket is a directory bucket.
     * </p>
     * </note>
     * 
     * @return Specifies the algorithm to use when encrypting the object (for example, <code>AES256</code>).</p>
     *         <p>
     *         When you perform a <code>CopyObject</code> operation, if you want to use a different type of encryption
     *         setting for the target object, you can specify appropriate encryption-related headers to encrypt the
     *         target object with an Amazon S3 managed key, a KMS key, or a customer-provided key. If the encryption
     *         setting in your request is different from the default encryption configuration of the destination bucket,
     *         the encryption setting in your request takes precedence.
     *         </p>
     *         <note>
     *         <p>
     *         This functionality is not supported when the destination bucket is a directory bucket.
     *         </p>
     */
    public final String sseCustomerAlgorithm() {
        return sseCustomerAlgorithm;
    }

    /**
     * <p>
     * Specifies the customer-provided encryption key for Amazon S3 to use in encrypting data. This value is used to
     * store the object and then it is discarded. Amazon S3 does not store the encryption key. The key must be
     * appropriate for use with the algorithm specified in the
     * <code>x-amz-server-side-encryption-customer-algorithm</code> header.
     * </p>
     * <note>
     * <p>
     * This functionality is not supported when the destination bucket is a directory bucket.
     * </p>
     * </note>
     * 
     * @return Specifies the customer-provided encryption key for Amazon S3 to use in encrypting data. This value is
     *         used to store the object and then it is discarded. Amazon S3 does not store the encryption key. The key
     *         must be appropriate for use with the algorithm specified in the
     *         <code>x-amz-server-side-encryption-customer-algorithm</code> header.</p> <note>
     *         <p>
     *         This functionality is not supported when the destination bucket is a directory bucket.
     *         </p>
     */
    public final String sseCustomerKey() {
        return sseCustomerKey;
    }

    /**
     * <p>
     * Specifies the 128-bit MD5 digest of the encryption key according to RFC 1321. Amazon S3 uses this header for a
     * message integrity check to ensure that the encryption key was transmitted without error.
     * </p>
     * <note>
     * <p>
     * This functionality is not supported when the destination bucket is a directory bucket.
     * </p>
     * </note>
     * 
     * @return Specifies the 128-bit MD5 digest of the encryption key according to RFC 1321. Amazon S3 uses this header
     *         for a message integrity check to ensure that the encryption key was transmitted without error.</p> <note>
     *         <p>
     *         This functionality is not supported when the destination bucket is a directory bucket.
     *         </p>
     */
    public final String sseCustomerKeyMD5() {
        return sseCustomerKeyMD5;
    }

    /**
     * <p>
     * Specifies the KMS key ID (Key ID, Key ARN, or Key Alias) to use for object encryption. All GET and PUT requests
     * for an object protected by KMS will fail if they're not made via SSL or using SigV4. For information about
     * configuring any of the officially supported Amazon Web Services SDKs and Amazon Web Services CLI, see <a
     * href="https://docs.aws.amazon.com/AmazonS3/latest/dev/UsingAWSSDK.html#specify-signature-version">Specifying the
     * Signature Version in Request Authentication</a> in the <i>Amazon S3 User Guide</i>.
     * </p>
     * <p>
     * <b>Directory buckets</b> - To encrypt data using SSE-KMS, it's recommended to specify the
     * <code>x-amz-server-side-encryption</code> header to <code>aws:kms</code>. Then, the
     * <code>x-amz-server-side-encryption-aws-kms-key-id</code> header implicitly uses the bucket's default KMS customer
     * managed key ID. If you want to explicitly set the <code> x-amz-server-side-encryption-aws-kms-key-id</code>
     * header, it must match the bucket's default customer managed key (using key ID or ARN, not alias). Your SSE-KMS
     * configuration can only support 1 <a
     * href="https://docs.aws.amazon.com/kms/latest/developerguide/concepts.html#customer-cmk">customer managed key</a>
     * per directory bucket's lifetime. The <a
     * href="https://docs.aws.amazon.com/kms/latest/developerguide/concepts.html#aws-managed-cmk">Amazon Web Services
     * managed key</a> (<code>aws/s3</code>) isn't supported. Incorrect key specification results in an HTTP
     * <code>400 Bad Request</code> error.
     * </p>
     * 
     * @return Specifies the KMS key ID (Key ID, Key ARN, or Key Alias) to use for object encryption. All GET and PUT
     *         requests for an object protected by KMS will fail if they're not made via SSL or using SigV4. For
     *         information about configuring any of the officially supported Amazon Web Services SDKs and Amazon Web
     *         Services CLI, see <a
     *         href="https://docs.aws.amazon.com/AmazonS3/latest/dev/UsingAWSSDK.html#specify-signature-version"
     *         >Specifying the Signature Version in Request Authentication</a> in the <i>Amazon S3 User Guide</i>.</p>
     *         <p>
     *         <b>Directory buckets</b> - To encrypt data using SSE-KMS, it's recommended to specify the
     *         <code>x-amz-server-side-encryption</code> header to <code>aws:kms</code>. Then, the
     *         <code>x-amz-server-side-encryption-aws-kms-key-id</code> header implicitly uses the bucket's default KMS
     *         customer managed key ID. If you want to explicitly set the
     *         <code> x-amz-server-side-encryption-aws-kms-key-id</code> header, it must match the bucket's default
     *         customer managed key (using key ID or ARN, not alias). Your SSE-KMS configuration can only support 1 <a
     *         href="https://docs.aws.amazon.com/kms/latest/developerguide/concepts.html#customer-cmk">customer managed
     *         key</a> per directory bucket's lifetime. The <a
     *         href="https://docs.aws.amazon.com/kms/latest/developerguide/concepts.html#aws-managed-cmk">Amazon Web
     *         Services managed key</a> (<code>aws/s3</code>) isn't supported. Incorrect key specification results in an
     *         HTTP <code>400 Bad Request</code> error.
     */
    public final String ssekmsKeyId() {
        return ssekmsKeyId;
    }

    /**
     * <p>
     * Specifies the Amazon Web Services KMS Encryption Context as an additional encryption context to use for the
     * destination object encryption. The value of this header is a base64-encoded UTF-8 string holding JSON with the
     * encryption context key-value pairs.
     * </p>
     * <p>
     * <b>General purpose buckets</b> - This value must be explicitly added to specify encryption context for
     * <code>CopyObject</code> requests if you want an additional encryption context for your destination object. The
     * additional encryption context of the source object won't be copied to the destination object. For more
     * information, see <a
     * href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/UsingKMSEncryption.html#encryption-context"
     * >Encryption context</a> in the <i>Amazon S3 User Guide</i>.
     * </p>
     * <p>
     * <b>Directory buckets</b> - You can optionally provide an explicit encryption context value. The value must match
     * the default encryption context - the bucket Amazon Resource Name (ARN). An additional encryption context value is
     * not supported.
     * </p>
     * 
     * @return Specifies the Amazon Web Services KMS Encryption Context as an additional encryption context to use for
     *         the destination object encryption. The value of this header is a base64-encoded UTF-8 string holding JSON
     *         with the encryption context key-value pairs.</p>
     *         <p>
     *         <b>General purpose buckets</b> - This value must be explicitly added to specify encryption context for
     *         <code>CopyObject</code> requests if you want an additional encryption context for your destination
     *         object. The additional encryption context of the source object won't be copied to the destination object.
     *         For more information, see <a
     *         href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/UsingKMSEncryption.html#encryption-context"
     *         >Encryption context</a> in the <i>Amazon S3 User Guide</i>.
     *         </p>
     *         <p>
     *         <b>Directory buckets</b> - You can optionally provide an explicit encryption context value. The value
     *         must match the default encryption context - the bucket Amazon Resource Name (ARN). An additional
     *         encryption context value is not supported.
     */
    public final String ssekmsEncryptionContext() {
        return ssekmsEncryptionContext;
    }

    /**
     * <p>
     * Specifies whether Amazon S3 should use an S3 Bucket Key for object encryption with server-side encryption using
     * Key Management Service (KMS) keys (SSE-KMS). If a target object uses SSE-KMS, you can enable an S3 Bucket Key for
     * the object.
     * </p>
     * <p>
     * Setting this header to <code>true</code> causes Amazon S3 to use an S3 Bucket Key for object encryption with
     * SSE-KMS. Specifying this header with a COPY action doesn’t affect bucket-level settings for S3 Bucket Key.
     * </p>
     * <p>
     * For more information, see <a href="https://docs.aws.amazon.com/AmazonS3/latest/dev/bucket-key.html">Amazon S3
     * Bucket Keys</a> in the <i>Amazon S3 User Guide</i>.
     * </p>
     * <note>
     * <p>
     * <b>Directory buckets</b> - S3 Bucket Keys aren't supported, when you copy SSE-KMS encrypted objects from general
     * purpose buckets to directory buckets, from directory buckets to general purpose buckets, or between directory
     * buckets, through <a href="https://docs.aws.amazon.com/AmazonS3/latest/API/API_CopyObject.html">CopyObject</a>. In
     * this case, Amazon S3 makes a call to KMS every time a copy request is made for a KMS-encrypted object.
     * </p>
     * </note>
     * 
     * @return Specifies whether Amazon S3 should use an S3 Bucket Key for object encryption with server-side encryption
     *         using Key Management Service (KMS) keys (SSE-KMS). If a target object uses SSE-KMS, you can enable an S3
     *         Bucket Key for the object.</p>
     *         <p>
     *         Setting this header to <code>true</code> causes Amazon S3 to use an S3 Bucket Key for object encryption
     *         with SSE-KMS. Specifying this header with a COPY action doesn’t affect bucket-level settings for S3
     *         Bucket Key.
     *         </p>
     *         <p>
     *         For more information, see <a
     *         href="https://docs.aws.amazon.com/AmazonS3/latest/dev/bucket-key.html">Amazon S3 Bucket Keys</a> in the
     *         <i>Amazon S3 User Guide</i>.
     *         </p>
     *         <note>
     *         <p>
     *         <b>Directory buckets</b> - S3 Bucket Keys aren't supported, when you copy SSE-KMS encrypted objects from
     *         general purpose buckets to directory buckets, from directory buckets to general purpose buckets, or
     *         between directory buckets, through <a
     *         href="https://docs.aws.amazon.com/AmazonS3/latest/API/API_CopyObject.html">CopyObject</a>. In this case,
     *         Amazon S3 makes a call to KMS every time a copy request is made for a KMS-encrypted object.
     *         </p>
     */
    public final Boolean bucketKeyEnabled() {
        return bucketKeyEnabled;
    }

    /**
     * <p>
     * Specifies the algorithm to use when decrypting the source object (for example, <code>AES256</code>).
     * </p>
     * <p>
     * If the source object for the copy is stored in Amazon S3 using SSE-C, you must provide the necessary encryption
     * information in your request so that Amazon S3 can decrypt the object for copying.
     * </p>
     * <note>
     * <p>
     * This functionality is not supported when the source object is in a directory bucket.
     * </p>
     * </note>
     * 
     * @return Specifies the algorithm to use when decrypting the source object (for example, <code>AES256</code>).</p>
     *         <p>
     *         If the source object for the copy is stored in Amazon S3 using SSE-C, you must provide the necessary
     *         encryption information in your request so that Amazon S3 can decrypt the object for copying.
     *         </p>
     *         <note>
     *         <p>
     *         This functionality is not supported when the source object is in a directory bucket.
     *         </p>
     */
    public final String copySourceSSECustomerAlgorithm() {
        return copySourceSSECustomerAlgorithm;
    }

    /**
     * <p>
     * Specifies the customer-provided encryption key for Amazon S3 to use to decrypt the source object. The encryption
     * key provided in this header must be the same one that was used when the source object was created.
     * </p>
     * <p>
     * If the source object for the copy is stored in Amazon S3 using SSE-C, you must provide the necessary encryption
     * information in your request so that Amazon S3 can decrypt the object for copying.
     * </p>
     * <note>
     * <p>
     * This functionality is not supported when the source object is in a directory bucket.
     * </p>
     * </note>
     * 
     * @return Specifies the customer-provided encryption key for Amazon S3 to use to decrypt the source object. The
     *         encryption key provided in this header must be the same one that was used when the source object was
     *         created.</p>
     *         <p>
     *         If the source object for the copy is stored in Amazon S3 using SSE-C, you must provide the necessary
     *         encryption information in your request so that Amazon S3 can decrypt the object for copying.
     *         </p>
     *         <note>
     *         <p>
     *         This functionality is not supported when the source object is in a directory bucket.
     *         </p>
     */
    public final String copySourceSSECustomerKey() {
        return copySourceSSECustomerKey;
    }

    /**
     * <p>
     * Specifies the 128-bit MD5 digest of the encryption key according to RFC 1321. Amazon S3 uses this header for a
     * message integrity check to ensure that the encryption key was transmitted without error.
     * </p>
     * <p>
     * If the source object for the copy is stored in Amazon S3 using SSE-C, you must provide the necessary encryption
     * information in your request so that Amazon S3 can decrypt the object for copying.
     * </p>
     * <note>
     * <p>
     * This functionality is not supported when the source object is in a directory bucket.
     * </p>
     * </note>
     * 
     * @return Specifies the 128-bit MD5 digest of the encryption key according to RFC 1321. Amazon S3 uses this header
     *         for a message integrity check to ensure that the encryption key was transmitted without error.</p>
     *         <p>
     *         If the source object for the copy is stored in Amazon S3 using SSE-C, you must provide the necessary
     *         encryption information in your request so that Amazon S3 can decrypt the object for copying.
     *         </p>
     *         <note>
     *         <p>
     *         This functionality is not supported when the source object is in a directory bucket.
     *         </p>
     */
    public final String copySourceSSECustomerKeyMD5() {
        return copySourceSSECustomerKeyMD5;
    }

    /**
     * Returns the value of the RequestPayer property for this object.
     * <p>
     * If the service returns an enum value that is not available in the current SDK version, {@link #requestPayer} will
     * return {@link RequestPayer#UNKNOWN_TO_SDK_VERSION}. The raw value returned by the service is available from
     * {@link #requestPayerAsString}.
     * </p>
     * 
     * @return The value of the RequestPayer property for this object.
     * @see RequestPayer
     */
    public final RequestPayer requestPayer() {
        return RequestPayer.fromValue(requestPayer);
    }

    /**
     * Returns the value of the RequestPayer property for this object.
     * <p>
     * If the service returns an enum value that is not available in the current SDK version, {@link #requestPayer} will
     * return {@link RequestPayer#UNKNOWN_TO_SDK_VERSION}. The raw value returned by the service is available from
     * {@link #requestPayerAsString}.
     * </p>
     * 
     * @return The value of the RequestPayer property for this object.
     * @see RequestPayer
     */
    public final String requestPayerAsString() {
        return requestPayer;
    }

    /**
     * <p>
     * The tag-set for the object copy in the destination bucket. This value must be used in conjunction with the
     * <code>x-amz-tagging-directive</code> if you choose <code>REPLACE</code> for the
     * <code>x-amz-tagging-directive</code>. If you choose <code>COPY</code> for the
     * <code>x-amz-tagging-directive</code>, you don't need to set the <code>x-amz-tagging</code> header, because the
     * tag-set will be copied from the source object directly. The tag-set must be encoded as URL Query parameters.
     * </p>
     * <p>
     * The default value is the empty value.
     * </p>
     * <note>
     * <p>
     * <b>Directory buckets</b> - For directory buckets in a <code>CopyObject</code> operation, only the empty tag-set
     * is supported. Any requests that attempt to write non-empty tags into directory buckets will receive a
     * <code>501 Not Implemented</code> status code. When the destination bucket is a directory bucket, you will receive
     * a <code>501 Not Implemented</code> response in any of the following situations:
     * </p>
     * <ul>
     * <li>
     * <p>
     * When you attempt to <code>COPY</code> the tag-set from an S3 source object that has non-empty tags.
     * </p>
     * </li>
     * <li>
     * <p>
     * When you attempt to <code>REPLACE</code> the tag-set of a source object and set a non-empty value to
     * <code>x-amz-tagging</code>.
     * </p>
     * </li>
     * <li>
     * <p>
     * When you don't set the <code>x-amz-tagging-directive</code> header and the source object has non-empty tags. This
     * is because the default value of <code>x-amz-tagging-directive</code> is <code>COPY</code>.
     * </p>
     * </li>
     * </ul>
     * <p>
     * Because only the empty tag-set is supported for directory buckets in a <code>CopyObject</code> operation, the
     * following situations are allowed:
     * </p>
     * <ul>
     * <li>
     * <p>
     * When you attempt to <code>COPY</code> the tag-set from a directory bucket source object that has no tags to a
     * general purpose bucket. It copies an empty tag-set to the destination object.
     * </p>
     * </li>
     * <li>
     * <p>
     * When you attempt to <code>REPLACE</code> the tag-set of a directory bucket source object and set the
     * <code>x-amz-tagging</code> value of the directory bucket destination object to empty.
     * </p>
     * </li>
     * <li>
     * <p>
     * When you attempt to <code>REPLACE</code> the tag-set of a general purpose bucket source object that has non-empty
     * tags and set the <code>x-amz-tagging</code> value of the directory bucket destination object to empty.
     * </p>
     * </li>
     * <li>
     * <p>
     * When you attempt to <code>REPLACE</code> the tag-set of a directory bucket source object and don't set the
     * <code>x-amz-tagging</code> value of the directory bucket destination object. This is because the default value of
     * <code>x-amz-tagging</code> is the empty value.
     * </p>
     * </li>
     * </ul>
     * </note>
     * 
     * @return The tag-set for the object copy in the destination bucket. This value must be used in conjunction with
     *         the <code>x-amz-tagging-directive</code> if you choose <code>REPLACE</code> for the
     *         <code>x-amz-tagging-directive</code>. If you choose <code>COPY</code> for the
     *         <code>x-amz-tagging-directive</code>, you don't need to set the <code>x-amz-tagging</code> header,
     *         because the tag-set will be copied from the source object directly. The tag-set must be encoded as URL
     *         Query parameters.</p>
     *         <p>
     *         The default value is the empty value.
     *         </p>
     *         <note>
     *         <p>
     *         <b>Directory buckets</b> - For directory buckets in a <code>CopyObject</code> operation, only the empty
     *         tag-set is supported. Any requests that attempt to write non-empty tags into directory buckets will
     *         receive a <code>501 Not Implemented</code> status code. When the destination bucket is a directory
     *         bucket, you will receive a <code>501 Not Implemented</code> response in any of the following situations:
     *         </p>
     *         <ul>
     *         <li>
     *         <p>
     *         When you attempt to <code>COPY</code> the tag-set from an S3 source object that has non-empty tags.
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         When you attempt to <code>REPLACE</code> the tag-set of a source object and set a non-empty value to
     *         <code>x-amz-tagging</code>.
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         When you don't set the <code>x-amz-tagging-directive</code> header and the source object has non-empty
     *         tags. This is because the default value of <code>x-amz-tagging-directive</code> is <code>COPY</code>.
     *         </p>
     *         </li>
     *         </ul>
     *         <p>
     *         Because only the empty tag-set is supported for directory buckets in a <code>CopyObject</code> operation,
     *         the following situations are allowed:
     *         </p>
     *         <ul>
     *         <li>
     *         <p>
     *         When you attempt to <code>COPY</code> the tag-set from a directory bucket source object that has no tags
     *         to a general purpose bucket. It copies an empty tag-set to the destination object.
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         When you attempt to <code>REPLACE</code> the tag-set of a directory bucket source object and set the
     *         <code>x-amz-tagging</code> value of the directory bucket destination object to empty.
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         When you attempt to <code>REPLACE</code> the tag-set of a general purpose bucket source object that has
     *         non-empty tags and set the <code>x-amz-tagging</code> value of the directory bucket destination object to
     *         empty.
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         When you attempt to <code>REPLACE</code> the tag-set of a directory bucket source object and don't set
     *         the <code>x-amz-tagging</code> value of the directory bucket destination object. This is because the
     *         default value of <code>x-amz-tagging</code> is the empty value.
     *         </p>
     *         </li>
     *         </ul>
     */
    public final String tagging() {
        return tagging;
    }

    /**
     * <p>
     * The Object Lock mode that you want to apply to the object copy.
     * </p>
     * <note>
     * <p>
     * This functionality is not supported for directory buckets.
     * </p>
     * </note>
     * <p>
     * If the service returns an enum value that is not available in the current SDK version, {@link #objectLockMode}
     * will return {@link ObjectLockMode#UNKNOWN_TO_SDK_VERSION}. The raw value returned by the service is available
     * from {@link #objectLockModeAsString}.
     * </p>
     * 
     * @return The Object Lock mode that you want to apply to the object copy.</p> <note>
     *         <p>
     *         This functionality is not supported for directory buckets.
     *         </p>
     * @see ObjectLockMode
     */
    public final ObjectLockMode objectLockMode() {
        return ObjectLockMode.fromValue(objectLockMode);
    }

    /**
     * <p>
     * The Object Lock mode that you want to apply to the object copy.
     * </p>
     * <note>
     * <p>
     * This functionality is not supported for directory buckets.
     * </p>
     * </note>
     * <p>
     * If the service returns an enum value that is not available in the current SDK version, {@link #objectLockMode}
     * will return {@link ObjectLockMode#UNKNOWN_TO_SDK_VERSION}. The raw value returned by the service is available
     * from {@link #objectLockModeAsString}.
     * </p>
     * 
     * @return The Object Lock mode that you want to apply to the object copy.</p> <note>
     *         <p>
     *         This functionality is not supported for directory buckets.
     *         </p>
     * @see ObjectLockMode
     */
    public final String objectLockModeAsString() {
        return objectLockMode;
    }

    /**
     * <p>
     * The date and time when you want the Object Lock of the object copy to expire.
     * </p>
     * <note>
     * <p>
     * This functionality is not supported for directory buckets.
     * </p>
     * </note>
     * 
     * @return The date and time when you want the Object Lock of the object copy to expire.</p> <note>
     *         <p>
     *         This functionality is not supported for directory buckets.
     *         </p>
     */
    public final Instant objectLockRetainUntilDate() {
        return objectLockRetainUntilDate;
    }

    /**
     * <p>
     * Specifies whether you want to apply a legal hold to the object copy.
     * </p>
     * <note>
     * <p>
     * This functionality is not supported for directory buckets.
     * </p>
     * </note>
     * <p>
     * If the service returns an enum value that is not available in the current SDK version,
     * {@link #objectLockLegalHoldStatus} will return {@link ObjectLockLegalHoldStatus#UNKNOWN_TO_SDK_VERSION}. The raw
     * value returned by the service is available from {@link #objectLockLegalHoldStatusAsString}.
     * </p>
     * 
     * @return Specifies whether you want to apply a legal hold to the object copy.</p> <note>
     *         <p>
     *         This functionality is not supported for directory buckets.
     *         </p>
     * @see ObjectLockLegalHoldStatus
     */
    public final ObjectLockLegalHoldStatus objectLockLegalHoldStatus() {
        return ObjectLockLegalHoldStatus.fromValue(objectLockLegalHoldStatus);
    }

    /**
     * <p>
     * Specifies whether you want to apply a legal hold to the object copy.
     * </p>
     * <note>
     * <p>
     * This functionality is not supported for directory buckets.
     * </p>
     * </note>
     * <p>
     * If the service returns an enum value that is not available in the current SDK version,
     * {@link #objectLockLegalHoldStatus} will return {@link ObjectLockLegalHoldStatus#UNKNOWN_TO_SDK_VERSION}. The raw
     * value returned by the service is available from {@link #objectLockLegalHoldStatusAsString}.
     * </p>
     * 
     * @return Specifies whether you want to apply a legal hold to the object copy.</p> <note>
     *         <p>
     *         This functionality is not supported for directory buckets.
     *         </p>
     * @see ObjectLockLegalHoldStatus
     */
    public final String objectLockLegalHoldStatusAsString() {
        return objectLockLegalHoldStatus;
    }

    /**
     * <p>
     * The account ID of the expected destination bucket owner. If the account ID that you provide does not match the
     * actual owner of the destination bucket, the request fails with the HTTP status code <code>403 Forbidden</code>
     * (access denied).
     * </p>
     * 
     * @return The account ID of the expected destination bucket owner. If the account ID that you provide does not
     *         match the actual owner of the destination bucket, the request fails with the HTTP status code
     *         <code>403 Forbidden</code> (access denied).
     */
    public final String expectedBucketOwner() {
        return expectedBucketOwner;
    }

    /**
     * <p>
     * The account ID of the expected source bucket owner. If the account ID that you provide does not match the actual
     * owner of the source bucket, the request fails with the HTTP status code <code>403 Forbidden</code> (access
     * denied).
     * </p>
     * 
     * @return The account ID of the expected source bucket owner. If the account ID that you provide does not match the
     *         actual owner of the source bucket, the request fails with the HTTP status code <code>403 Forbidden</code>
     *         (access denied).
     */
    public final String expectedSourceBucketOwner() {
        return expectedSourceBucketOwner;
    }

    /**
     * <p>
     * The name of the destination bucket.
     * </p>
     * <p>
     * <b>Directory buckets</b> - When you use this operation with a directory bucket, you must use virtual-hosted-style
     * requests in the format <code> <i>Bucket-name</i>.s3express-<i>zone-id</i>.<i>region-code</i>.amazonaws.com</code>
     * . Path-style requests are not supported. Directory bucket names must be unique in the chosen Zone (Availability
     * Zone or Local Zone). Bucket names must follow the format
     * <code> <i>bucket-base-name</i>--<i>zone-id</i>--x-s3</code> (for example,
     * <code> <i>amzn-s3-demo-bucket</i>--<i>usw2-az1</i>--x-s3</code>). For information about bucket naming
     * restrictions, see <a
     * href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/directory-bucket-naming-rules.html">Directory bucket
     * naming rules</a> in the <i>Amazon S3 User Guide</i>.
     * </p>
     * <note>
     * <p>
     * Copying objects across different Amazon Web Services Regions isn't supported when the source or destination
     * bucket is in Amazon Web Services Local Zones. The source and destination buckets must have the same parent Amazon
     * Web Services Region. Otherwise, you get an HTTP <code>400 Bad Request</code> error with the error code
     * <code>InvalidRequest</code>.
     * </p>
     * </note>
     * <p>
     * <b>Access points</b> - When you use this action with an access point for general purpose buckets, you must
     * provide the alias of the access point in place of the bucket name or specify the access point ARN. When you use
     * this action with an access point for directory buckets, you must provide the access point name in place of the
     * bucket name. When using the access point ARN, you must direct requests to the access point hostname. The access
     * point hostname takes the form <i>AccessPointName</i>-<i>AccountId</i>.s3-accesspoint.<i>Region</i>.amazonaws.com.
     * When using this action with an access point through the Amazon Web Services SDKs, you provide the access point
     * ARN in place of the bucket name. For more information about access point ARNs, see <a
     * href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/using-access-points.html">Using access points</a> in
     * the <i>Amazon S3 User Guide</i>.
     * </p>
     * <note>
     * <p>
     * Object Lambda access points are not supported by directory buckets.
     * </p>
     * </note>
     * <p>
     * <b>S3 on Outposts</b> - When you use this action with S3 on Outposts, you must use the Outpost bucket access
     * point ARN or the access point alias for the destination bucket. You can only copy objects within the same Outpost
     * bucket. It's not supported to copy objects across different Amazon Web Services Outposts, between buckets on the
     * same Outposts, or between Outposts buckets and any other bucket types. For more information about S3 on Outposts,
     * see <a href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/S3onOutposts.html">What is S3 on Outposts?</a>
     * in the <i>S3 on Outposts guide</i>. When you use this action with S3 on Outposts through the REST API, you must
     * direct requests to the S3 on Outposts hostname, in the format
     * <code> <i>AccessPointName</i>-<i>AccountId</i>.<i>outpostID</i>.s3-outposts.<i>Region</i>.amazonaws.com</code>.
     * The hostname isn't required when you use the Amazon Web Services CLI or SDKs.
     * </p>
     * 
     * @return The name of the destination bucket.</p>
     *         <p>
     *         <b>Directory buckets</b> - When you use this operation with a directory bucket, you must use
     *         virtual-hosted-style requests in the format
     *         <code> <i>Bucket-name</i>.s3express-<i>zone-id</i>.<i>region-code</i>.amazonaws.com</code>. Path-style
     *         requests are not supported. Directory bucket names must be unique in the chosen Zone (Availability Zone
     *         or Local Zone). Bucket names must follow the format
     *         <code> <i>bucket-base-name</i>--<i>zone-id</i>--x-s3</code> (for example,
     *         <code> <i>amzn-s3-demo-bucket</i>--<i>usw2-az1</i>--x-s3</code>). For information about bucket naming
     *         restrictions, see <a
     *         href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/directory-bucket-naming-rules.html">Directory
     *         bucket naming rules</a> in the <i>Amazon S3 User Guide</i>.
     *         </p>
     *         <note>
     *         <p>
     *         Copying objects across different Amazon Web Services Regions isn't supported when the source or
     *         destination bucket is in Amazon Web Services Local Zones. The source and destination buckets must have
     *         the same parent Amazon Web Services Region. Otherwise, you get an HTTP <code>400 Bad Request</code> error
     *         with the error code <code>InvalidRequest</code>.
     *         </p>
     *         </note>
     *         <p>
     *         <b>Access points</b> - When you use this action with an access point for general purpose buckets, you
     *         must provide the alias of the access point in place of the bucket name or specify the access point ARN.
     *         When you use this action with an access point for directory buckets, you must provide the access point
     *         name in place of the bucket name. When using the access point ARN, you must direct requests to the access
     *         point hostname. The access point hostname takes the form
     *         <i>AccessPointName</i>-<i>AccountId</i>.s3-accesspoint.<i>Region</i>.amazonaws.com. When using this
     *         action with an access point through the Amazon Web Services SDKs, you provide the access point ARN in
     *         place of the bucket name. For more information about access point ARNs, see <a
     *         href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/using-access-points.html">Using access
     *         points</a> in the <i>Amazon S3 User Guide</i>.
     *         </p>
     *         <note>
     *         <p>
     *         Object Lambda access points are not supported by directory buckets.
     *         </p>
     *         </note>
     *         <p>
     *         <b>S3 on Outposts</b> - When you use this action with S3 on Outposts, you must use the Outpost bucket
     *         access point ARN or the access point alias for the destination bucket. You can only copy objects within
     *         the same Outpost bucket. It's not supported to copy objects across different Amazon Web Services
     *         Outposts, between buckets on the same Outposts, or between Outposts buckets and any other bucket types.
     *         For more information about S3 on Outposts, see <a
     *         href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/S3onOutposts.html">What is S3 on
     *         Outposts?</a> in the <i>S3 on Outposts guide</i>. When you use this action with S3 on Outposts through
     *         the REST API, you must direct requests to the S3 on Outposts hostname, in the format
     *         <code> <i>AccessPointName</i>-<i>AccountId</i>.<i>outpostID</i>.s3-outposts.<i>Region</i>.amazonaws.com</code>
     *         . The hostname isn't required when you use the Amazon Web Services CLI or SDKs.
     * @deprecated Use {@link #destinationBucket()}
     */
    @Deprecated
    public final String bucket() {
        return destinationBucket;
    }

    /**
     * <p>
     * The name of the destination bucket.
     * </p>
     * <p>
     * <b>Directory buckets</b> - When you use this operation with a directory bucket, you must use virtual-hosted-style
     * requests in the format <code> <i>Bucket-name</i>.s3express-<i>zone-id</i>.<i>region-code</i>.amazonaws.com</code>
     * . Path-style requests are not supported. Directory bucket names must be unique in the chosen Zone (Availability
     * Zone or Local Zone). Bucket names must follow the format
     * <code> <i>bucket-base-name</i>--<i>zone-id</i>--x-s3</code> (for example,
     * <code> <i>amzn-s3-demo-bucket</i>--<i>usw2-az1</i>--x-s3</code>). For information about bucket naming
     * restrictions, see <a
     * href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/directory-bucket-naming-rules.html">Directory bucket
     * naming rules</a> in the <i>Amazon S3 User Guide</i>.
     * </p>
     * <note>
     * <p>
     * Copying objects across different Amazon Web Services Regions isn't supported when the source or destination
     * bucket is in Amazon Web Services Local Zones. The source and destination buckets must have the same parent Amazon
     * Web Services Region. Otherwise, you get an HTTP <code>400 Bad Request</code> error with the error code
     * <code>InvalidRequest</code>.
     * </p>
     * </note>
     * <p>
     * <b>Access points</b> - When you use this action with an access point for general purpose buckets, you must
     * provide the alias of the access point in place of the bucket name or specify the access point ARN. When you use
     * this action with an access point for directory buckets, you must provide the access point name in place of the
     * bucket name. When using the access point ARN, you must direct requests to the access point hostname. The access
     * point hostname takes the form <i>AccessPointName</i>-<i>AccountId</i>.s3-accesspoint.<i>Region</i>.amazonaws.com.
     * When using this action with an access point through the Amazon Web Services SDKs, you provide the access point
     * ARN in place of the bucket name. For more information about access point ARNs, see <a
     * href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/using-access-points.html">Using access points</a> in
     * the <i>Amazon S3 User Guide</i>.
     * </p>
     * <note>
     * <p>
     * Object Lambda access points are not supported by directory buckets.
     * </p>
     * </note>
     * <p>
     * <b>S3 on Outposts</b> - When you use this action with S3 on Outposts, you must use the Outpost bucket access
     * point ARN or the access point alias for the destination bucket. You can only copy objects within the same Outpost
     * bucket. It's not supported to copy objects across different Amazon Web Services Outposts, between buckets on the
     * same Outposts, or between Outposts buckets and any other bucket types. For more information about S3 on Outposts,
     * see <a href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/S3onOutposts.html">What is S3 on Outposts?</a>
     * in the <i>S3 on Outposts guide</i>. When you use this action with S3 on Outposts through the REST API, you must
     * direct requests to the S3 on Outposts hostname, in the format
     * <code> <i>AccessPointName</i>-<i>AccountId</i>.<i>outpostID</i>.s3-outposts.<i>Region</i>.amazonaws.com</code>.
     * The hostname isn't required when you use the Amazon Web Services CLI or SDKs.
     * </p>
     * 
     * @return The name of the destination bucket.</p>
     *         <p>
     *         <b>Directory buckets</b> - When you use this operation with a directory bucket, you must use
     *         virtual-hosted-style requests in the format
     *         <code> <i>Bucket-name</i>.s3express-<i>zone-id</i>.<i>region-code</i>.amazonaws.com</code>. Path-style
     *         requests are not supported. Directory bucket names must be unique in the chosen Zone (Availability Zone
     *         or Local Zone). Bucket names must follow the format
     *         <code> <i>bucket-base-name</i>--<i>zone-id</i>--x-s3</code> (for example,
     *         <code> <i>amzn-s3-demo-bucket</i>--<i>usw2-az1</i>--x-s3</code>). For information about bucket naming
     *         restrictions, see <a
     *         href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/directory-bucket-naming-rules.html">Directory
     *         bucket naming rules</a> in the <i>Amazon S3 User Guide</i>.
     *         </p>
     *         <note>
     *         <p>
     *         Copying objects across different Amazon Web Services Regions isn't supported when the source or
     *         destination bucket is in Amazon Web Services Local Zones. The source and destination buckets must have
     *         the same parent Amazon Web Services Region. Otherwise, you get an HTTP <code>400 Bad Request</code> error
     *         with the error code <code>InvalidRequest</code>.
     *         </p>
     *         </note>
     *         <p>
     *         <b>Access points</b> - When you use this action with an access point for general purpose buckets, you
     *         must provide the alias of the access point in place of the bucket name or specify the access point ARN.
     *         When you use this action with an access point for directory buckets, you must provide the access point
     *         name in place of the bucket name. When using the access point ARN, you must direct requests to the access
     *         point hostname. The access point hostname takes the form
     *         <i>AccessPointName</i>-<i>AccountId</i>.s3-accesspoint.<i>Region</i>.amazonaws.com. When using this
     *         action with an access point through the Amazon Web Services SDKs, you provide the access point ARN in
     *         place of the bucket name. For more information about access point ARNs, see <a
     *         href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/using-access-points.html">Using access
     *         points</a> in the <i>Amazon S3 User Guide</i>.
     *         </p>
     *         <note>
     *         <p>
     *         Object Lambda access points are not supported by directory buckets.
     *         </p>
     *         </note>
     *         <p>
     *         <b>S3 on Outposts</b> - When you use this action with S3 on Outposts, you must use the Outpost bucket
     *         access point ARN or the access point alias for the destination bucket. You can only copy objects within
     *         the same Outpost bucket. It's not supported to copy objects across different Amazon Web Services
     *         Outposts, between buckets on the same Outposts, or between Outposts buckets and any other bucket types.
     *         For more information about S3 on Outposts, see <a
     *         href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/S3onOutposts.html">What is S3 on
     *         Outposts?</a> in the <i>S3 on Outposts guide</i>. When you use this action with S3 on Outposts through
     *         the REST API, you must direct requests to the S3 on Outposts hostname, in the format
     *         <code> <i>AccessPointName</i>-<i>AccountId</i>.<i>outpostID</i>.s3-outposts.<i>Region</i>.amazonaws.com</code>
     *         . The hostname isn't required when you use the Amazon Web Services CLI or SDKs.
     */
    public final String destinationBucket() {
        return destinationBucket;
    }

    /**
     * <p>
     * The key of the destination object.
     * </p>
     * 
     * @return The key of the destination object.
     * @deprecated Use {@link #destinationKey()}
     */
    @Deprecated
    public final String key() {
        return destinationKey;
    }

    /**
     * <p>
     * The key of the destination object.
     * </p>
     * 
     * @return The key of the destination object.
     */
    public final String destinationKey() {
        return destinationKey;
    }

    /**
     * The name of the bucket containing the object to copy. The provided input will be URL encoded. The
     * {@code sourceBucket}, {@code sourceKey}, and {@code sourceVersionId} parameters must not be used in conjunction
     * with the {@code copySource} parameter.
     * 
     * @return The name of the bucket containing the object to copy. The provided input will be URL encoded. The
     *         {@code sourceBucket}, {@code sourceKey}, and {@code sourceVersionId} parameters must not be used in
     *         conjunction with the {@code copySource} parameter.
     */
    public final String sourceBucket() {
        return sourceBucket;
    }

    /**
     * The key of the object to copy. The provided input will be URL encoded. The {@code sourceBucket},
     * {@code sourceKey}, and {@code sourceVersionId} parameters must not be used in conjunction with the
     * {@code copySource} parameter.
     * 
     * @return The key of the object to copy. The provided input will be URL encoded. The {@code sourceBucket},
     *         {@code sourceKey}, and {@code sourceVersionId} parameters must not be used in conjunction with the
     *         {@code copySource} parameter.
     */
    public final String sourceKey() {
        return sourceKey;
    }

    /**
     * Specifies a particular version of the source object to copy. By default the latest version is copied. The
     * {@code sourceBucket}, {@code sourceKey}, and {@code sourceVersionId} parameters must not be used in conjunction
     * with the {@code copySource} parameter.
     * 
     * @return Specifies a particular version of the source object to copy. By default the latest version is copied. The
     *         {@code sourceBucket}, {@code sourceKey}, and {@code sourceVersionId} parameters must not be used in
     *         conjunction with the {@code copySource} parameter.
     */
    public final String sourceVersionId() {
        return sourceVersionId;
    }

    public final RetentionDirective retentionDirective() {
        return retentionDirective;
    }

    public final Instant retentionExpirationDate() {
        return retentionExpirationDate;
    }

    public final String retentionLegalHoldId() {
        return retentionLegalHoldId;
    }

    public final Long retentionPeriod() {
        return retentionPeriod;
    }

    @Override
    public Builder toBuilder() {
        return new BuilderImpl(this);
    }

    public static Builder builder() {
        return new BuilderImpl();
    }

    public static Class<? extends Builder> serializableBuilderClass() {
        return BuilderImpl.class;
    }

    @Override
    public final int hashCode() {
        int hashCode = 1;
        hashCode = 31 * hashCode + super.hashCode();
        hashCode = 31 * hashCode + Objects.hashCode(aclAsString());
        hashCode = 31 * hashCode + Objects.hashCode(cacheControl());
        hashCode = 31 * hashCode + Objects.hashCode(checksumAlgorithmAsString());
        hashCode = 31 * hashCode + Objects.hashCode(contentDisposition());
        hashCode = 31 * hashCode + Objects.hashCode(contentEncoding());
        hashCode = 31 * hashCode + Objects.hashCode(contentLanguage());
        hashCode = 31 * hashCode + Objects.hashCode(contentType());
        hashCode = 31 * hashCode + Objects.hashCode(copySource());
        hashCode = 31 * hashCode + Objects.hashCode(copySourceIfMatch());
        hashCode = 31 * hashCode + Objects.hashCode(copySourceIfModifiedSince());
        hashCode = 31 * hashCode + Objects.hashCode(copySourceIfNoneMatch());
        hashCode = 31 * hashCode + Objects.hashCode(copySourceIfUnmodifiedSince());
        hashCode = 31 * hashCode + Objects.hashCode(expires());
        hashCode = 31 * hashCode + Objects.hashCode(grantFullControl());
        hashCode = 31 * hashCode + Objects.hashCode(grantRead());
        hashCode = 31 * hashCode + Objects.hashCode(grantReadACP());
        hashCode = 31 * hashCode + Objects.hashCode(grantWriteACP());
        hashCode = 31 * hashCode + Objects.hashCode(hasMetadata() ? metadata() : null);
        hashCode = 31 * hashCode + Objects.hashCode(metadataDirectiveAsString());
        hashCode = 31 * hashCode + Objects.hashCode(taggingDirectiveAsString());
        hashCode = 31 * hashCode + Objects.hashCode(serverSideEncryptionAsString());
        hashCode = 31 * hashCode + Objects.hashCode(storageClassAsString());
        hashCode = 31 * hashCode + Objects.hashCode(websiteRedirectLocation());
        hashCode = 31 * hashCode + Objects.hashCode(sseCustomerAlgorithm());
        hashCode = 31 * hashCode + Objects.hashCode(sseCustomerKey());
        hashCode = 31 * hashCode + Objects.hashCode(sseCustomerKeyMD5());
        hashCode = 31 * hashCode + Objects.hashCode(ssekmsKeyId());
        hashCode = 31 * hashCode + Objects.hashCode(ssekmsEncryptionContext());
        hashCode = 31 * hashCode + Objects.hashCode(bucketKeyEnabled());
        hashCode = 31 * hashCode + Objects.hashCode(copySourceSSECustomerAlgorithm());
        hashCode = 31 * hashCode + Objects.hashCode(copySourceSSECustomerKey());
        hashCode = 31 * hashCode + Objects.hashCode(copySourceSSECustomerKeyMD5());
        hashCode = 31 * hashCode + Objects.hashCode(requestPayerAsString());
        hashCode = 31 * hashCode + Objects.hashCode(tagging());
        hashCode = 31 * hashCode + Objects.hashCode(objectLockModeAsString());
        hashCode = 31 * hashCode + Objects.hashCode(objectLockRetainUntilDate());
        hashCode = 31 * hashCode + Objects.hashCode(objectLockLegalHoldStatusAsString());
        hashCode = 31 * hashCode + Objects.hashCode(expectedBucketOwner());
        hashCode = 31 * hashCode + Objects.hashCode(expectedSourceBucketOwner());
        hashCode = 31 * hashCode + Objects.hashCode(destinationBucket());
        hashCode = 31 * hashCode + Objects.hashCode(destinationKey());
        hashCode = 31 * hashCode + Objects.hashCode(sourceBucket());
        hashCode = 31 * hashCode + Objects.hashCode(sourceKey());
        hashCode = 31 * hashCode + Objects.hashCode(sourceVersionId());
        hashCode = 31 * hashCode + Objects.hashCode(retentionDirective());
        hashCode = 31 * hashCode + Objects.hashCode(retentionExpirationDate());
        hashCode = 31 * hashCode + Objects.hashCode(retentionLegalHoldId());
        hashCode = 31 * hashCode + Objects.hashCode(retentionPeriod());
        return hashCode;
    }

    @Override
    public final boolean equals(Object obj) {
        return super.equals(obj) && equalsBySdkFields(obj);
    }

    @Override
    public final boolean equalsBySdkFields(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof CopyObjectRequest)) {
            return false;
        }
        CopyObjectRequest other = (CopyObjectRequest) obj;
        return Objects.equals(aclAsString(), other.aclAsString()) && Objects.equals(cacheControl(), other.cacheControl())
                && Objects.equals(checksumAlgorithmAsString(), other.checksumAlgorithmAsString())
                && Objects.equals(contentDisposition(), other.contentDisposition())
                && Objects.equals(contentEncoding(), other.contentEncoding())
                && Objects.equals(contentLanguage(), other.contentLanguage())
                && Objects.equals(contentType(), other.contentType()) && Objects.equals(copySource(), other.copySource())
                && Objects.equals(copySourceIfMatch(), other.copySourceIfMatch())
                && Objects.equals(copySourceIfModifiedSince(), other.copySourceIfModifiedSince())
                && Objects.equals(copySourceIfNoneMatch(), other.copySourceIfNoneMatch())
                && Objects.equals(copySourceIfUnmodifiedSince(), other.copySourceIfUnmodifiedSince())
                && Objects.equals(expires(), other.expires()) && Objects.equals(grantFullControl(), other.grantFullControl())
                && Objects.equals(grantRead(), other.grantRead()) && Objects.equals(grantReadACP(), other.grantReadACP())
                && Objects.equals(grantWriteACP(), other.grantWriteACP()) && hasMetadata() == other.hasMetadata()
                && Objects.equals(metadata(), other.metadata())
                && Objects.equals(metadataDirectiveAsString(), other.metadataDirectiveAsString())
                && Objects.equals(taggingDirectiveAsString(), other.taggingDirectiveAsString())
                && Objects.equals(serverSideEncryptionAsString(), other.serverSideEncryptionAsString())
                && Objects.equals(storageClassAsString(), other.storageClassAsString())
                && Objects.equals(websiteRedirectLocation(), other.websiteRedirectLocation())
                && Objects.equals(sseCustomerAlgorithm(), other.sseCustomerAlgorithm())
                && Objects.equals(sseCustomerKey(), other.sseCustomerKey())
                && Objects.equals(sseCustomerKeyMD5(), other.sseCustomerKeyMD5())
                && Objects.equals(ssekmsKeyId(), other.ssekmsKeyId())
                && Objects.equals(ssekmsEncryptionContext(), other.ssekmsEncryptionContext())
                && Objects.equals(bucketKeyEnabled(), other.bucketKeyEnabled())
                && Objects.equals(copySourceSSECustomerAlgorithm(), other.copySourceSSECustomerAlgorithm())
                && Objects.equals(copySourceSSECustomerKey(), other.copySourceSSECustomerKey())
                && Objects.equals(copySourceSSECustomerKeyMD5(), other.copySourceSSECustomerKeyMD5())
                && Objects.equals(requestPayerAsString(), other.requestPayerAsString())
                && Objects.equals(tagging(), other.tagging())
                && Objects.equals(objectLockModeAsString(), other.objectLockModeAsString())
                && Objects.equals(objectLockRetainUntilDate(), other.objectLockRetainUntilDate())
                && Objects.equals(objectLockLegalHoldStatusAsString(), other.objectLockLegalHoldStatusAsString())
                && Objects.equals(expectedBucketOwner(), other.expectedBucketOwner())
                && Objects.equals(expectedSourceBucketOwner(), other.expectedSourceBucketOwner())
                && Objects.equals(destinationBucket(), other.destinationBucket())
                && Objects.equals(destinationKey(), other.destinationKey())
                && Objects.equals(sourceBucket(), other.sourceBucket()) && Objects.equals(sourceKey(), other.sourceKey())
                && Objects.equals(sourceVersionId(), other.sourceVersionId())
                && Objects.equals(retentionDirective(), other.retentionDirective())
                && Objects.equals(retentionExpirationDate(), other.retentionExpirationDate())
                && Objects.equals(retentionLegalHoldId(), other.retentionLegalHoldId())
                && Objects.equals(retentionPeriod(), other.retentionPeriod());
    }

    /**
     * Returns a string representation of this object. This is useful for testing and debugging. Sensitive data will be
     * redacted from this string using a placeholder value.
     */
    @Override
    public final String toString() {
        return ToString.builder("CopyObjectRequest").add("ACL", aclAsString()).add("CacheControl", cacheControl())
                .add("ChecksumAlgorithm", checksumAlgorithmAsString()).add("ContentDisposition", contentDisposition())
                .add("ContentEncoding", contentEncoding()).add("ContentLanguage", contentLanguage())
                .add("ContentType", contentType()).add("CopySource", copySource()).add("CopySourceIfMatch", copySourceIfMatch())
                .add("CopySourceIfModifiedSince", copySourceIfModifiedSince())
                .add("CopySourceIfNoneMatch", copySourceIfNoneMatch())
                .add("CopySourceIfUnmodifiedSince", copySourceIfUnmodifiedSince()).add("Expires", expires())
                .add("GrantFullControl", grantFullControl()).add("GrantRead", grantRead()).add("GrantReadACP", grantReadACP())
                .add("GrantWriteACP", grantWriteACP()).add("Metadata", hasMetadata() ? metadata() : null)
                .add("MetadataDirective", metadataDirectiveAsString()).add("TaggingDirective", taggingDirectiveAsString())
                .add("ServerSideEncryption", serverSideEncryptionAsString()).add("StorageClass", storageClassAsString())
                .add("WebsiteRedirectLocation", websiteRedirectLocation()).add("SSECustomerAlgorithm", sseCustomerAlgorithm())
                .add("SSECustomerKey", sseCustomerKey() == null ? null : "*** Sensitive Data Redacted ***")
                .add("SSECustomerKeyMD5", sseCustomerKeyMD5())
                .add("SSEKMSKeyId", ssekmsKeyId() == null ? null : "*** Sensitive Data Redacted ***")
                .add("SSEKMSEncryptionContext", ssekmsEncryptionContext() == null ? null : "*** Sensitive Data Redacted ***")
                .add("BucketKeyEnabled", bucketKeyEnabled())
                .add("CopySourceSSECustomerAlgorithm", copySourceSSECustomerAlgorithm())
                .add("CopySourceSSECustomerKey", copySourceSSECustomerKey() == null ? null : "*** Sensitive Data Redacted ***")
                .add("CopySourceSSECustomerKeyMD5", copySourceSSECustomerKeyMD5()).add("RequestPayer", requestPayerAsString())
                .add("Tagging", tagging()).add("ObjectLockMode", objectLockModeAsString())
                .add("ObjectLockRetainUntilDate", objectLockRetainUntilDate())
                .add("ObjectLockLegalHoldStatus", objectLockLegalHoldStatusAsString())
                .add("ExpectedBucketOwner", expectedBucketOwner()).add("ExpectedSourceBucketOwner", expectedSourceBucketOwner())
                .add("DestinationBucket", destinationBucket()).add("DestinationKey", destinationKey())
                .add("SourceBucket", sourceBucket()).add("SourceKey", sourceKey()).add("SourceVersionId", sourceVersionId())
                .add("RetentionDirective",retentionDirective())
                .add("RetentionExpirationDate",retentionExpirationDate())
                .add("RetentionLegalHoldId",retentionLegalHoldId()).add("RetentionPeriod",retentionPeriod())
                .build();
    }

    public final <T> Optional<T> getValueForField(String fieldName, Class<T> clazz) {
        switch (fieldName) {
        case "ACL":
            return Optional.ofNullable(clazz.cast(aclAsString()));
        case "CacheControl":
            return Optional.ofNullable(clazz.cast(cacheControl()));
        case "ChecksumAlgorithm":
            return Optional.ofNullable(clazz.cast(checksumAlgorithmAsString()));
        case "ContentDisposition":
            return Optional.ofNullable(clazz.cast(contentDisposition()));
        case "ContentEncoding":
            return Optional.ofNullable(clazz.cast(contentEncoding()));
        case "ContentLanguage":
            return Optional.ofNullable(clazz.cast(contentLanguage()));
        case "ContentType":
            return Optional.ofNullable(clazz.cast(contentType()));
        case "CopySource":
            return Optional.ofNullable(clazz.cast(copySource()));
        case "CopySourceIfMatch":
            return Optional.ofNullable(clazz.cast(copySourceIfMatch()));
        case "CopySourceIfModifiedSince":
            return Optional.ofNullable(clazz.cast(copySourceIfModifiedSince()));
        case "CopySourceIfNoneMatch":
            return Optional.ofNullable(clazz.cast(copySourceIfNoneMatch()));
        case "CopySourceIfUnmodifiedSince":
            return Optional.ofNullable(clazz.cast(copySourceIfUnmodifiedSince()));
        case "Expires":
            return Optional.ofNullable(clazz.cast(expires()));
        case "GrantFullControl":
            return Optional.ofNullable(clazz.cast(grantFullControl()));
        case "GrantRead":
            return Optional.ofNullable(clazz.cast(grantRead()));
        case "GrantReadACP":
            return Optional.ofNullable(clazz.cast(grantReadACP()));
        case "GrantWriteACP":
            return Optional.ofNullable(clazz.cast(grantWriteACP()));
        case "Metadata":
            return Optional.ofNullable(clazz.cast(metadata()));
        case "MetadataDirective":
            return Optional.ofNullable(clazz.cast(metadataDirectiveAsString()));
        case "TaggingDirective":
            return Optional.ofNullable(clazz.cast(taggingDirectiveAsString()));
        case "ServerSideEncryption":
            return Optional.ofNullable(clazz.cast(serverSideEncryptionAsString()));
        case "StorageClass":
            return Optional.ofNullable(clazz.cast(storageClassAsString()));
        case "WebsiteRedirectLocation":
            return Optional.ofNullable(clazz.cast(websiteRedirectLocation()));
        case "SSECustomerAlgorithm":
            return Optional.ofNullable(clazz.cast(sseCustomerAlgorithm()));
        case "SSECustomerKey":
            return Optional.ofNullable(clazz.cast(sseCustomerKey()));
        case "SSECustomerKeyMD5":
            return Optional.ofNullable(clazz.cast(sseCustomerKeyMD5()));
        case "SSEKMSKeyId":
            return Optional.ofNullable(clazz.cast(ssekmsKeyId()));
        case "SSEKMSEncryptionContext":
            return Optional.ofNullable(clazz.cast(ssekmsEncryptionContext()));
        case "BucketKeyEnabled":
            return Optional.ofNullable(clazz.cast(bucketKeyEnabled()));
        case "CopySourceSSECustomerAlgorithm":
            return Optional.ofNullable(clazz.cast(copySourceSSECustomerAlgorithm()));
        case "CopySourceSSECustomerKey":
            return Optional.ofNullable(clazz.cast(copySourceSSECustomerKey()));
        case "CopySourceSSECustomerKeyMD5":
            return Optional.ofNullable(clazz.cast(copySourceSSECustomerKeyMD5()));
        case "RequestPayer":
            return Optional.ofNullable(clazz.cast(requestPayerAsString()));
        case "Tagging":
            return Optional.ofNullable(clazz.cast(tagging()));
        case "ObjectLockMode":
            return Optional.ofNullable(clazz.cast(objectLockModeAsString()));
        case "ObjectLockRetainUntilDate":
            return Optional.ofNullable(clazz.cast(objectLockRetainUntilDate()));
        case "ObjectLockLegalHoldStatus":
            return Optional.ofNullable(clazz.cast(objectLockLegalHoldStatusAsString()));
        case "ExpectedBucketOwner":
            return Optional.ofNullable(clazz.cast(expectedBucketOwner()));
        case "ExpectedSourceBucketOwner":
            return Optional.ofNullable(clazz.cast(expectedSourceBucketOwner()));
        case "DestinationBucket":
            return Optional.ofNullable(clazz.cast(destinationBucket()));
        case "Bucket":
            return Optional.ofNullable(clazz.cast(destinationBucket()));
        case "DestinationKey":
            return Optional.ofNullable(clazz.cast(destinationKey()));
        case "Key":
            return Optional.ofNullable(clazz.cast(destinationKey()));
        case "SourceBucket":
            return Optional.ofNullable(clazz.cast(sourceBucket()));
        case "SourceKey":
            return Optional.ofNullable(clazz.cast(sourceKey()));
        case "SourceVersionId":
            return Optional.ofNullable(clazz.cast(sourceVersionId()));
        case"RetentionDirective" :
                return Optional.ofNullable(clazz.cast(retentionDirective()));
        case"RetentionExpirationDate" :
                return Optional.ofNullable(clazz.cast(retentionExpirationDate()));
        case"RetentionLegalHoldId" :
                return Optional.ofNullable(clazz.cast(retentionLegalHoldId()));
        case"RetentionPeriod" :
                return Optional.ofNullable(clazz.cast(retentionPeriod()));
        default:
            return Optional.empty();
        }
    }

    @Override
    public final List<SdkField<?>> sdkFields() {
        return SDK_FIELDS;
    }

    @Override
    public final Map<String, SdkField<?>> sdkFieldNameToField() {
        return SDK_NAME_TO_FIELD;
    }

    private static Map<String, SdkField<?>> memberNameToFieldInitializer() {
        Map<String, SdkField<?>> map = new HashMap<>();
        map.put("x-amz-acl", ACL_FIELD);
        map.put("Cache-Control", CACHE_CONTROL_FIELD);
        map.put("x-amz-checksum-algorithm", CHECKSUM_ALGORITHM_FIELD);
        map.put("Content-Disposition", CONTENT_DISPOSITION_FIELD);
        map.put("Content-Encoding", CONTENT_ENCODING_FIELD);
        map.put("Content-Language", CONTENT_LANGUAGE_FIELD);
        map.put("Content-Type", CONTENT_TYPE_FIELD);
        map.put("x-amz-copy-source", COPY_SOURCE_FIELD);
        map.put("x-amz-copy-source-if-match", COPY_SOURCE_IF_MATCH_FIELD);
        map.put("x-amz-copy-source-if-modified-since", COPY_SOURCE_IF_MODIFIED_SINCE_FIELD);
        map.put("x-amz-copy-source-if-none-match", COPY_SOURCE_IF_NONE_MATCH_FIELD);
        map.put("x-amz-copy-source-if-unmodified-since", COPY_SOURCE_IF_UNMODIFIED_SINCE_FIELD);
        map.put("Expires", EXPIRES_FIELD);
        map.put("x-amz-grant-full-control", GRANT_FULL_CONTROL_FIELD);
        map.put("x-amz-grant-read", GRANT_READ_FIELD);
        map.put("x-amz-grant-read-acp", GRANT_READ_ACP_FIELD);
        map.put("x-amz-grant-write-acp", GRANT_WRITE_ACP_FIELD);
        map.put("x-amz-meta-", METADATA_FIELD);
        map.put("x-amz-metadata-directive", METADATA_DIRECTIVE_FIELD);
        map.put("x-amz-tagging-directive", TAGGING_DIRECTIVE_FIELD);
        map.put("x-amz-server-side-encryption", SERVER_SIDE_ENCRYPTION_FIELD);
        map.put("x-amz-storage-class", STORAGE_CLASS_FIELD);
        map.put("x-amz-website-redirect-location", WEBSITE_REDIRECT_LOCATION_FIELD);
        map.put("x-amz-server-side-encryption-customer-algorithm", SSE_CUSTOMER_ALGORITHM_FIELD);
        map.put("x-amz-server-side-encryption-customer-key", SSE_CUSTOMER_KEY_FIELD);
        map.put("x-amz-server-side-encryption-customer-key-MD5", SSE_CUSTOMER_KEY_MD5_FIELD);
        map.put("x-amz-server-side-encryption-aws-kms-key-id", SSEKMS_KEY_ID_FIELD);
        map.put("x-amz-server-side-encryption-context", SSEKMS_ENCRYPTION_CONTEXT_FIELD);
        map.put("x-amz-server-side-encryption-bucket-key-enabled", BUCKET_KEY_ENABLED_FIELD);
        map.put("x-amz-copy-source-server-side-encryption-customer-algorithm", COPY_SOURCE_SSE_CUSTOMER_ALGORITHM_FIELD);
        map.put("x-amz-copy-source-server-side-encryption-customer-key", COPY_SOURCE_SSE_CUSTOMER_KEY_FIELD);
        map.put("x-amz-copy-source-server-side-encryption-customer-key-MD5", COPY_SOURCE_SSE_CUSTOMER_KEY_MD5_FIELD);
        map.put("x-amz-request-payer", REQUEST_PAYER_FIELD);
        map.put("x-amz-tagging", TAGGING_FIELD);
        map.put("x-amz-object-lock-mode", OBJECT_LOCK_MODE_FIELD);
        map.put("x-amz-object-lock-retain-until-date", OBJECT_LOCK_RETAIN_UNTIL_DATE_FIELD);
        map.put("x-amz-object-lock-legal-hold", OBJECT_LOCK_LEGAL_HOLD_STATUS_FIELD);
        map.put("x-amz-expected-bucket-owner", EXPECTED_BUCKET_OWNER_FIELD);
        map.put("x-amz-source-expected-bucket-owner", EXPECTED_SOURCE_BUCKET_OWNER_FIELD);
        map.put("Bucket", DESTINATION_BUCKET_FIELD);
        map.put("Key", DESTINATION_KEY_FIELD);
        map.put("SourceBucket", SOURCE_BUCKET_FIELD);
        map.put("SourceKey", SOURCE_KEY_FIELD);
        map.put("SourceVersionId", SOURCE_VERSION_ID_FIELD);
        map.put("retention-expiration-date", RETENTION_EXPIRATION_DATE_FIELD);
        map.put("retention-legal-hold-id", RETENTION_LEGAL_HOLD_ID_FIELD);
        map.put("retention-period", RETENTION_PERIOD_FIELD);
        return Collections.unmodifiableMap(map);
    }

    private static <T> Function<Object, T> getter(Function<CopyObjectRequest, T> g) {
        return obj -> g.apply((CopyObjectRequest) obj);
    }

    private static <T> BiConsumer<Object, T> setter(BiConsumer<Builder, T> s) {
        return (obj, val) -> s.accept((Builder) obj, val);
    }

    @Mutable
    @NotThreadSafe
    public interface Builder extends S3Request.Builder, SdkPojo, CopyableBuilder<Builder, CopyObjectRequest> {
        /**
         * <p>
         * The canned access control list (ACL) to apply to the object.
         * </p>
         * <p>
         * When you copy an object, the ACL metadata is not preserved and is set to <code>private</code> by default.
         * Only the owner has full access control. To override the default ACL setting, specify a new ACL when you
         * generate a copy request. For more information, see <a
         * href="https://docs.aws.amazon.com/AmazonS3/latest/dev/S3_ACLs_UsingACLs.html">Using ACLs</a>.
         * </p>
         * <p>
         * If the destination bucket that you're copying objects to uses the bucket owner enforced setting for S3 Object
         * Ownership, ACLs are disabled and no longer affect permissions. Buckets that use this setting only accept
         * <code>PUT</code> requests that don't specify an ACL or <code>PUT</code> requests that specify bucket owner
         * full control ACLs, such as the <code>bucket-owner-full-control</code> canned ACL or an equivalent form of
         * this ACL expressed in the XML format. For more information, see <a
         * href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/about-object-ownership.html">Controlling
         * ownership of objects and disabling ACLs</a> in the <i>Amazon S3 User Guide</i>.
         * </p>
         * <note>
         * <ul>
         * <li>
         * <p>
         * If your destination bucket uses the bucket owner enforced setting for Object Ownership, all objects written
         * to the bucket by any account will be owned by the bucket owner.
         * </p>
         * </li>
         * <li>
         * <p>
         * This functionality is not supported for directory buckets.
         * </p>
         * </li>
         * <li>
         * <p>
         * This functionality is not supported for Amazon S3 on Outposts.
         * </p>
         * </li>
         * </ul>
         * </note>
         * 
         * @param acl
         *        The canned access control list (ACL) to apply to the object.</p>
         *        <p>
         *        When you copy an object, the ACL metadata is not preserved and is set to <code>private</code> by
         *        default. Only the owner has full access control. To override the default ACL setting, specify a new
         *        ACL when you generate a copy request. For more information, see <a
         *        href="https://docs.aws.amazon.com/AmazonS3/latest/dev/S3_ACLs_UsingACLs.html">Using ACLs</a>.
         *        </p>
         *        <p>
         *        If the destination bucket that you're copying objects to uses the bucket owner enforced setting for S3
         *        Object Ownership, ACLs are disabled and no longer affect permissions. Buckets that use this setting
         *        only accept <code>PUT</code> requests that don't specify an ACL or <code>PUT</code> requests that
         *        specify bucket owner full control ACLs, such as the <code>bucket-owner-full-control</code> canned ACL
         *        or an equivalent form of this ACL expressed in the XML format. For more information, see <a
         *        href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/about-object-ownership.html">Controlling
         *        ownership of objects and disabling ACLs</a> in the <i>Amazon S3 User Guide</i>.
         *        </p>
         *        <note>
         *        <ul>
         *        <li>
         *        <p>
         *        If your destination bucket uses the bucket owner enforced setting for Object Ownership, all objects
         *        written to the bucket by any account will be owned by the bucket owner.
         *        </p>
         *        </li>
         *        <li>
         *        <p>
         *        This functionality is not supported for directory buckets.
         *        </p>
         *        </li>
         *        <li>
         *        <p>
         *        This functionality is not supported for Amazon S3 on Outposts.
         *        </p>
         *        </li>
         *        </ul>
         * @see ObjectCannedACL
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see ObjectCannedACL
         */
        Builder acl(String acl);

        /**
         * <p>
         * The canned access control list (ACL) to apply to the object.
         * </p>
         * <p>
         * When you copy an object, the ACL metadata is not preserved and is set to <code>private</code> by default.
         * Only the owner has full access control. To override the default ACL setting, specify a new ACL when you
         * generate a copy request. For more information, see <a
         * href="https://docs.aws.amazon.com/AmazonS3/latest/dev/S3_ACLs_UsingACLs.html">Using ACLs</a>.
         * </p>
         * <p>
         * If the destination bucket that you're copying objects to uses the bucket owner enforced setting for S3 Object
         * Ownership, ACLs are disabled and no longer affect permissions. Buckets that use this setting only accept
         * <code>PUT</code> requests that don't specify an ACL or <code>PUT</code> requests that specify bucket owner
         * full control ACLs, such as the <code>bucket-owner-full-control</code> canned ACL or an equivalent form of
         * this ACL expressed in the XML format. For more information, see <a
         * href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/about-object-ownership.html">Controlling
         * ownership of objects and disabling ACLs</a> in the <i>Amazon S3 User Guide</i>.
         * </p>
         * <note>
         * <ul>
         * <li>
         * <p>
         * If your destination bucket uses the bucket owner enforced setting for Object Ownership, all objects written
         * to the bucket by any account will be owned by the bucket owner.
         * </p>
         * </li>
         * <li>
         * <p>
         * This functionality is not supported for directory buckets.
         * </p>
         * </li>
         * <li>
         * <p>
         * This functionality is not supported for Amazon S3 on Outposts.
         * </p>
         * </li>
         * </ul>
         * </note>
         * 
         * @param acl
         *        The canned access control list (ACL) to apply to the object.</p>
         *        <p>
         *        When you copy an object, the ACL metadata is not preserved and is set to <code>private</code> by
         *        default. Only the owner has full access control. To override the default ACL setting, specify a new
         *        ACL when you generate a copy request. For more information, see <a
         *        href="https://docs.aws.amazon.com/AmazonS3/latest/dev/S3_ACLs_UsingACLs.html">Using ACLs</a>.
         *        </p>
         *        <p>
         *        If the destination bucket that you're copying objects to uses the bucket owner enforced setting for S3
         *        Object Ownership, ACLs are disabled and no longer affect permissions. Buckets that use this setting
         *        only accept <code>PUT</code> requests that don't specify an ACL or <code>PUT</code> requests that
         *        specify bucket owner full control ACLs, such as the <code>bucket-owner-full-control</code> canned ACL
         *        or an equivalent form of this ACL expressed in the XML format. For more information, see <a
         *        href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/about-object-ownership.html">Controlling
         *        ownership of objects and disabling ACLs</a> in the <i>Amazon S3 User Guide</i>.
         *        </p>
         *        <note>
         *        <ul>
         *        <li>
         *        <p>
         *        If your destination bucket uses the bucket owner enforced setting for Object Ownership, all objects
         *        written to the bucket by any account will be owned by the bucket owner.
         *        </p>
         *        </li>
         *        <li>
         *        <p>
         *        This functionality is not supported for directory buckets.
         *        </p>
         *        </li>
         *        <li>
         *        <p>
         *        This functionality is not supported for Amazon S3 on Outposts.
         *        </p>
         *        </li>
         *        </ul>
         * @see ObjectCannedACL
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see ObjectCannedACL
         */
        Builder acl(ObjectCannedACL acl);

        /**
         * <p>
         * Specifies the caching behavior along the request/reply chain.
         * </p>
         * 
         * @param cacheControl
         *        Specifies the caching behavior along the request/reply chain.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder cacheControl(String cacheControl);

        /**
         * <p>
         * Indicates the algorithm that you want Amazon S3 to use to create the checksum for the object. For more
         * information, see <a
         * href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/checking-object-integrity.html">Checking object
         * integrity</a> in the <i>Amazon S3 User Guide</i>.
         * </p>
         * <p>
         * When you copy an object, if the source object has a checksum, that checksum value will be copied to the new
         * object by default. If the <code>CopyObject</code> request does not include this
         * <code>x-amz-checksum-algorithm</code> header, the checksum algorithm will be copied from the source object to
         * the destination object (if it's present on the source object). You can optionally specify a different
         * checksum algorithm to use with the <code>x-amz-checksum-algorithm</code> header. Unrecognized or unsupported
         * values will respond with the HTTP status code <code>400 Bad Request</code>.
         * </p>
         * <note>
         * <p>
         * For directory buckets, when you use Amazon Web Services SDKs, <code>CRC32</code> is the default checksum
         * algorithm that's used for performance.
         * </p>
         * </note>
         * 
         * @param checksumAlgorithm
         *        Indicates the algorithm that you want Amazon S3 to use to create the checksum for the object. For more
         *        information, see <a
         *        href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/checking-object-integrity.html">Checking
         *        object integrity</a> in the <i>Amazon S3 User Guide</i>.</p>
         *        <p>
         *        When you copy an object, if the source object has a checksum, that checksum value will be copied to
         *        the new object by default. If the <code>CopyObject</code> request does not include this
         *        <code>x-amz-checksum-algorithm</code> header, the checksum algorithm will be copied from the source
         *        object to the destination object (if it's present on the source object). You can optionally specify a
         *        different checksum algorithm to use with the <code>x-amz-checksum-algorithm</code> header.
         *        Unrecognized or unsupported values will respond with the HTTP status code <code>400 Bad Request</code>
         *        .
         *        </p>
         *        <note>
         *        <p>
         *        For directory buckets, when you use Amazon Web Services SDKs, <code>CRC32</code> is the default
         *        checksum algorithm that's used for performance.
         *        </p>
         * @see ChecksumAlgorithm
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see ChecksumAlgorithm
         */
        Builder checksumAlgorithm(String checksumAlgorithm);

        /**
         * <p>
         * Indicates the algorithm that you want Amazon S3 to use to create the checksum for the object. For more
         * information, see <a
         * href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/checking-object-integrity.html">Checking object
         * integrity</a> in the <i>Amazon S3 User Guide</i>.
         * </p>
         * <p>
         * When you copy an object, if the source object has a checksum, that checksum value will be copied to the new
         * object by default. If the <code>CopyObject</code> request does not include this
         * <code>x-amz-checksum-algorithm</code> header, the checksum algorithm will be copied from the source object to
         * the destination object (if it's present on the source object). You can optionally specify a different
         * checksum algorithm to use with the <code>x-amz-checksum-algorithm</code> header. Unrecognized or unsupported
         * values will respond with the HTTP status code <code>400 Bad Request</code>.
         * </p>
         * <note>
         * <p>
         * For directory buckets, when you use Amazon Web Services SDKs, <code>CRC32</code> is the default checksum
         * algorithm that's used for performance.
         * </p>
         * </note>
         * 
         * @param checksumAlgorithm
         *        Indicates the algorithm that you want Amazon S3 to use to create the checksum for the object. For more
         *        information, see <a
         *        href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/checking-object-integrity.html">Checking
         *        object integrity</a> in the <i>Amazon S3 User Guide</i>.</p>
         *        <p>
         *        When you copy an object, if the source object has a checksum, that checksum value will be copied to
         *        the new object by default. If the <code>CopyObject</code> request does not include this
         *        <code>x-amz-checksum-algorithm</code> header, the checksum algorithm will be copied from the source
         *        object to the destination object (if it's present on the source object). You can optionally specify a
         *        different checksum algorithm to use with the <code>x-amz-checksum-algorithm</code> header.
         *        Unrecognized or unsupported values will respond with the HTTP status code <code>400 Bad Request</code>
         *        .
         *        </p>
         *        <note>
         *        <p>
         *        For directory buckets, when you use Amazon Web Services SDKs, <code>CRC32</code> is the default
         *        checksum algorithm that's used for performance.
         *        </p>
         * @see ChecksumAlgorithm
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see ChecksumAlgorithm
         */
        Builder checksumAlgorithm(ChecksumAlgorithm checksumAlgorithm);

        /**
         * <p>
         * Specifies presentational information for the object. Indicates whether an object should be displayed in a web
         * browser or downloaded as a file. It allows specifying the desired filename for the downloaded file.
         * </p>
         * 
         * @param contentDisposition
         *        Specifies presentational information for the object. Indicates whether an object should be displayed
         *        in a web browser or downloaded as a file. It allows specifying the desired filename for the downloaded
         *        file.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder contentDisposition(String contentDisposition);

        /**
         * <p>
         * Specifies what content encodings have been applied to the object and thus what decoding mechanisms must be
         * applied to obtain the media-type referenced by the Content-Type header field.
         * </p>
         * <note>
         * <p>
         * For directory buckets, only the <code>aws-chunked</code> value is supported in this header field.
         * </p>
         * </note>
         * 
         * @param contentEncoding
         *        Specifies what content encodings have been applied to the object and thus what decoding mechanisms
         *        must be applied to obtain the media-type referenced by the Content-Type header field.</p> <note>
         *        <p>
         *        For directory buckets, only the <code>aws-chunked</code> value is supported in this header field.
         *        </p>
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder contentEncoding(String contentEncoding);

        /**
         * <p>
         * The language the content is in.
         * </p>
         * 
         * @param contentLanguage
         *        The language the content is in.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder contentLanguage(String contentLanguage);

        /**
         * <p>
         * A standard MIME type that describes the format of the object data.
         * </p>
         * 
         * @param contentType
         *        A standard MIME type that describes the format of the object data.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder contentType(String contentType);

        /**
         * <p>
         * Specifies the source object for the copy operation. The source object can be up to 5 GB. If the source object
         * is an object that was uploaded by using a multipart upload, the object copy will be a single part object
         * after the source object is copied to the destination bucket.
         * </p>
         * <p>
         * You specify the value of the copy source in one of two formats, depending on whether you want to access the
         * source object through an <a
         * href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/access-points.html">access point</a>:
         * </p>
         * <ul>
         * <li>
         * <p>
         * For objects not accessed through an access point, specify the name of the source bucket and the key of the
         * source object, separated by a slash (/). For example, to copy the object <code>reports/january.pdf</code>
         * from the general purpose bucket <code>awsexamplebucket</code>, use
         * <code>awsexamplebucket/reports/january.pdf</code>. The value must be URL-encoded. To copy the object
         * <code>reports/january.pdf</code> from the directory bucket <code>awsexamplebucket--use1-az5--x-s3</code>, use
         * <code>awsexamplebucket--use1-az5--x-s3/reports/january.pdf</code>. The value must be URL-encoded.
         * </p>
         * </li>
         * <li>
         * <p>
         * For objects accessed through access points, specify the Amazon Resource Name (ARN) of the object as accessed
         * through the access point, in the format
         * <code>arn:aws:s3:&lt;Region&gt;:&lt;account-id&gt;:accesspoint/&lt;access-point-name&gt;/object/&lt;key&gt;</code>
         * . For example, to copy the object <code>reports/january.pdf</code> through access point
         * <code>my-access-point</code> owned by account <code>123456789012</code> in Region <code>us-west-2</code>, use
         * the URL encoding of
         * <code>arn:aws:s3:us-west-2:123456789012:accesspoint/my-access-point/object/reports/january.pdf</code>. The
         * value must be URL encoded.
         * </p>
         * <note>
         * <ul>
         * <li>
         * <p>
         * Amazon S3 supports copy operations using Access points only when the source and destination buckets are in
         * the same Amazon Web Services Region.
         * </p>
         * </li>
         * <li>
         * <p>
         * Access points are not supported by directory buckets.
         * </p>
         * </li>
         * </ul>
         * </note>
         * <p>
         * Alternatively, for objects accessed through Amazon S3 on Outposts, specify the ARN of the object as accessed
         * in the format
         * <code>arn:aws:s3-outposts:&lt;Region&gt;:&lt;account-id&gt;:outpost/&lt;outpost-id&gt;/object/&lt;key&gt;</code>
         * . For example, to copy the object <code>reports/january.pdf</code> through outpost <code>my-outpost</code>
         * owned by account <code>123456789012</code> in Region <code>us-west-2</code>, use the URL encoding of
         * <code>arn:aws:s3-outposts:us-west-2:123456789012:outpost/my-outpost/object/reports/january.pdf</code>. The
         * value must be URL-encoded.
         * </p>
         * </li>
         * </ul>
         * <p>
         * If your source bucket versioning is enabled, the <code>x-amz-copy-source</code> header by default identifies
         * the current version of an object to copy. If the current version is a delete marker, Amazon S3 behaves as if
         * the object was deleted. To copy a different version, use the <code>versionId</code> query parameter.
         * Specifically, append <code>?versionId=&lt;version-id&gt;</code> to the value (for example,
         * <code>awsexamplebucket/reports/january.pdf?versionId=QUpfdndhfd8438MNFDN93jdnJFkdmqnh893</code>). If you
         * don't specify a version ID, Amazon S3 copies the latest version of the source object.
         * </p>
         * <p>
         * If you enable versioning on the destination bucket, Amazon S3 generates a unique version ID for the copied
         * object. This version ID is different from the version ID of the source object. Amazon S3 returns the version
         * ID of the copied object in the <code>x-amz-version-id</code> response header in the response.
         * </p>
         * <p>
         * If you do not enable versioning or suspend it on the destination bucket, the version ID that Amazon S3
         * generates in the <code>x-amz-version-id</code> response header is always null.
         * </p>
         * <note>
         * <p>
         * <b>Directory buckets</b> - S3 Versioning isn't enabled and supported for directory buckets.
         * </p>
         * </note>
         * 
         * @param copySource
         *        Specifies the source object for the copy operation. The source object can be up to 5 GB. If the source
         *        object is an object that was uploaded by using a multipart upload, the object copy will be a single
         *        part object after the source object is copied to the destination bucket.</p>
         *        <p>
         *        You specify the value of the copy source in one of two formats, depending on whether you want to
         *        access the source object through an <a
         *        href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/access-points.html">access point</a>:
         *        </p>
         *        <ul>
         *        <li>
         *        <p>
         *        For objects not accessed through an access point, specify the name of the source bucket and the key of
         *        the source object, separated by a slash (/). For example, to copy the object
         *        <code>reports/january.pdf</code> from the general purpose bucket <code>awsexamplebucket</code>, use
         *        <code>awsexamplebucket/reports/january.pdf</code>. The value must be URL-encoded. To copy the object
         *        <code>reports/january.pdf</code> from the directory bucket
         *        <code>awsexamplebucket--use1-az5--x-s3</code>, use
         *        <code>awsexamplebucket--use1-az5--x-s3/reports/january.pdf</code>. The value must be URL-encoded.
         *        </p>
         *        </li>
         *        <li>
         *        <p>
         *        For objects accessed through access points, specify the Amazon Resource Name (ARN) of the object as
         *        accessed through the access point, in the format
         *        <code>arn:aws:s3:&lt;Region&gt;:&lt;account-id&gt;:accesspoint/&lt;access-point-name&gt;/object/&lt;key&gt;</code>
         *        . For example, to copy the object <code>reports/january.pdf</code> through access point
         *        <code>my-access-point</code> owned by account <code>123456789012</code> in Region
         *        <code>us-west-2</code>, use the URL encoding of
         *        <code>arn:aws:s3:us-west-2:123456789012:accesspoint/my-access-point/object/reports/january.pdf</code>.
         *        The value must be URL encoded.
         *        </p>
         *        <note>
         *        <ul>
         *        <li>
         *        <p>
         *        Amazon S3 supports copy operations using Access points only when the source and destination buckets
         *        are in the same Amazon Web Services Region.
         *        </p>
         *        </li>
         *        <li>
         *        <p>
         *        Access points are not supported by directory buckets.
         *        </p>
         *        </li>
         *        </ul>
         *        </note>
         *        <p>
         *        Alternatively, for objects accessed through Amazon S3 on Outposts, specify the ARN of the object as
         *        accessed in the format
         *        <code>arn:aws:s3-outposts:&lt;Region&gt;:&lt;account-id&gt;:outpost/&lt;outpost-id&gt;/object/&lt;key&gt;</code>
         *        . For example, to copy the object <code>reports/january.pdf</code> through outpost
         *        <code>my-outpost</code> owned by account <code>123456789012</code> in Region <code>us-west-2</code>,
         *        use the URL encoding of
         *        <code>arn:aws:s3-outposts:us-west-2:123456789012:outpost/my-outpost/object/reports/january.pdf</code>.
         *        The value must be URL-encoded.
         *        </p>
         *        </li>
         *        </ul>
         *        <p>
         *        If your source bucket versioning is enabled, the <code>x-amz-copy-source</code> header by default
         *        identifies the current version of an object to copy. If the current version is a delete marker, Amazon
         *        S3 behaves as if the object was deleted. To copy a different version, use the <code>versionId</code>
         *        query parameter. Specifically, append <code>?versionId=&lt;version-id&gt;</code> to the value (for
         *        example,
         *        <code>awsexamplebucket/reports/january.pdf?versionId=QUpfdndhfd8438MNFDN93jdnJFkdmqnh893</code>). If
         *        you don't specify a version ID, Amazon S3 copies the latest version of the source object.
         *        </p>
         *        <p>
         *        If you enable versioning on the destination bucket, Amazon S3 generates a unique version ID for the
         *        copied object. This version ID is different from the version ID of the source object. Amazon S3
         *        returns the version ID of the copied object in the <code>x-amz-version-id</code> response header in
         *        the response.
         *        </p>
         *        <p>
         *        If you do not enable versioning or suspend it on the destination bucket, the version ID that Amazon S3
         *        generates in the <code>x-amz-version-id</code> response header is always null.
         *        </p>
         *        <note>
         *        <p>
         *        <b>Directory buckets</b> - S3 Versioning isn't enabled and supported for directory buckets.
         *        </p>
         * @return Returns a reference to this object so that method calls can be chained together.
         * @deprecated The {@code copySource} parameter has been deprecated in favor of the more user-friendly
         *             {@code sourceBucket}, {@code sourceKey}, and {@code sourceVersionId} parameters. The
         *             {@code copySource} parameter will remain fully functional, but it must not be used in conjunction
         *             with its replacement parameters.
         */
        @Deprecated
        Builder copySource(String copySource);

        /**
         * <p>
         * Copies the object if its entity tag (ETag) matches the specified tag.
         * </p>
         * <p>
         * If both the <code>x-amz-copy-source-if-match</code> and <code>x-amz-copy-source-if-unmodified-since</code>
         * headers are present in the request and evaluate as follows, Amazon S3 returns <code>200 OK</code> and copies
         * the data:
         * </p>
         * <ul>
         * <li>
         * <p>
         * <code>x-amz-copy-source-if-match</code> condition evaluates to true
         * </p>
         * </li>
         * <li>
         * <p>
         * <code>x-amz-copy-source-if-unmodified-since</code> condition evaluates to false
         * </p>
         * </li>
         * </ul>
         * 
         * @param copySourceIfMatch
         *        Copies the object if its entity tag (ETag) matches the specified tag.</p>
         *        <p>
         *        If both the <code>x-amz-copy-source-if-match</code> and
         *        <code>x-amz-copy-source-if-unmodified-since</code> headers are present in the request and evaluate as
         *        follows, Amazon S3 returns <code>200 OK</code> and copies the data:
         *        </p>
         *        <ul>
         *        <li>
         *        <p>
         *        <code>x-amz-copy-source-if-match</code> condition evaluates to true
         *        </p>
         *        </li>
         *        <li>
         *        <p>
         *        <code>x-amz-copy-source-if-unmodified-since</code> condition evaluates to false
         *        </p>
         *        </li>
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder copySourceIfMatch(String copySourceIfMatch);

        /**
         * <p>
         * Copies the object if it has been modified since the specified time.
         * </p>
         * <p>
         * If both the <code>x-amz-copy-source-if-none-match</code> and <code>x-amz-copy-source-if-modified-since</code>
         * headers are present in the request and evaluate as follows, Amazon S3 returns the
         * <code>412 Precondition Failed</code> response code:
         * </p>
         * <ul>
         * <li>
         * <p>
         * <code>x-amz-copy-source-if-none-match</code> condition evaluates to false
         * </p>
         * </li>
         * <li>
         * <p>
         * <code>x-amz-copy-source-if-modified-since</code> condition evaluates to true
         * </p>
         * </li>
         * </ul>
         * 
         * @param copySourceIfModifiedSince
         *        Copies the object if it has been modified since the specified time.</p>
         *        <p>
         *        If both the <code>x-amz-copy-source-if-none-match</code> and
         *        <code>x-amz-copy-source-if-modified-since</code> headers are present in the request and evaluate as
         *        follows, Amazon S3 returns the <code>412 Precondition Failed</code> response code:
         *        </p>
         *        <ul>
         *        <li>
         *        <p>
         *        <code>x-amz-copy-source-if-none-match</code> condition evaluates to false
         *        </p>
         *        </li>
         *        <li>
         *        <p>
         *        <code>x-amz-copy-source-if-modified-since</code> condition evaluates to true
         *        </p>
         *        </li>
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder copySourceIfModifiedSince(Instant copySourceIfModifiedSince);

        /**
         * <p>
         * Copies the object if its entity tag (ETag) is different than the specified ETag.
         * </p>
         * <p>
         * If both the <code>x-amz-copy-source-if-none-match</code> and <code>x-amz-copy-source-if-modified-since</code>
         * headers are present in the request and evaluate as follows, Amazon S3 returns the
         * <code>412 Precondition Failed</code> response code:
         * </p>
         * <ul>
         * <li>
         * <p>
         * <code>x-amz-copy-source-if-none-match</code> condition evaluates to false
         * </p>
         * </li>
         * <li>
         * <p>
         * <code>x-amz-copy-source-if-modified-since</code> condition evaluates to true
         * </p>
         * </li>
         * </ul>
         * 
         * @param copySourceIfNoneMatch
         *        Copies the object if its entity tag (ETag) is different than the specified ETag.</p>
         *        <p>
         *        If both the <code>x-amz-copy-source-if-none-match</code> and
         *        <code>x-amz-copy-source-if-modified-since</code> headers are present in the request and evaluate as
         *        follows, Amazon S3 returns the <code>412 Precondition Failed</code> response code:
         *        </p>
         *        <ul>
         *        <li>
         *        <p>
         *        <code>x-amz-copy-source-if-none-match</code> condition evaluates to false
         *        </p>
         *        </li>
         *        <li>
         *        <p>
         *        <code>x-amz-copy-source-if-modified-since</code> condition evaluates to true
         *        </p>
         *        </li>
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder copySourceIfNoneMatch(String copySourceIfNoneMatch);

        /**
         * <p>
         * Copies the object if it hasn't been modified since the specified time.
         * </p>
         * <p>
         * If both the <code>x-amz-copy-source-if-match</code> and <code>x-amz-copy-source-if-unmodified-since</code>
         * headers are present in the request and evaluate as follows, Amazon S3 returns <code>200 OK</code> and copies
         * the data:
         * </p>
         * <ul>
         * <li>
         * <p>
         * <code>x-amz-copy-source-if-match</code> condition evaluates to true
         * </p>
         * </li>
         * <li>
         * <p>
         * <code>x-amz-copy-source-if-unmodified-since</code> condition evaluates to false
         * </p>
         * </li>
         * </ul>
         * 
         * @param copySourceIfUnmodifiedSince
         *        Copies the object if it hasn't been modified since the specified time.</p>
         *        <p>
         *        If both the <code>x-amz-copy-source-if-match</code> and
         *        <code>x-amz-copy-source-if-unmodified-since</code> headers are present in the request and evaluate as
         *        follows, Amazon S3 returns <code>200 OK</code> and copies the data:
         *        </p>
         *        <ul>
         *        <li>
         *        <p>
         *        <code>x-amz-copy-source-if-match</code> condition evaluates to true
         *        </p>
         *        </li>
         *        <li>
         *        <p>
         *        <code>x-amz-copy-source-if-unmodified-since</code> condition evaluates to false
         *        </p>
         *        </li>
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder copySourceIfUnmodifiedSince(Instant copySourceIfUnmodifiedSince);

        /**
         * <p>
         * The date and time at which the object is no longer cacheable.
         * </p>
         * 
         * @param expires
         *        The date and time at which the object is no longer cacheable.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder expires(Instant expires);

        /**
         * <p>
         * Gives the grantee READ, READ_ACP, and WRITE_ACP permissions on the object.
         * </p>
         * <note>
         * <ul>
         * <li>
         * <p>
         * This functionality is not supported for directory buckets.
         * </p>
         * </li>
         * <li>
         * <p>
         * This functionality is not supported for Amazon S3 on Outposts.
         * </p>
         * </li>
         * </ul>
         * </note>
         * 
         * @param grantFullControl
         *        Gives the grantee READ, READ_ACP, and WRITE_ACP permissions on the object.</p> <note>
         *        <ul>
         *        <li>
         *        <p>
         *        This functionality is not supported for directory buckets.
         *        </p>
         *        </li>
         *        <li>
         *        <p>
         *        This functionality is not supported for Amazon S3 on Outposts.
         *        </p>
         *        </li>
         *        </ul>
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder grantFullControl(String grantFullControl);

        /**
         * <p>
         * Allows grantee to read the object data and its metadata.
         * </p>
         * <note>
         * <ul>
         * <li>
         * <p>
         * This functionality is not supported for directory buckets.
         * </p>
         * </li>
         * <li>
         * <p>
         * This functionality is not supported for Amazon S3 on Outposts.
         * </p>
         * </li>
         * </ul>
         * </note>
         * 
         * @param grantRead
         *        Allows grantee to read the object data and its metadata.</p> <note>
         *        <ul>
         *        <li>
         *        <p>
         *        This functionality is not supported for directory buckets.
         *        </p>
         *        </li>
         *        <li>
         *        <p>
         *        This functionality is not supported for Amazon S3 on Outposts.
         *        </p>
         *        </li>
         *        </ul>
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder grantRead(String grantRead);

        /**
         * <p>
         * Allows grantee to read the object ACL.
         * </p>
         * <note>
         * <ul>
         * <li>
         * <p>
         * This functionality is not supported for directory buckets.
         * </p>
         * </li>
         * <li>
         * <p>
         * This functionality is not supported for Amazon S3 on Outposts.
         * </p>
         * </li>
         * </ul>
         * </note>
         * 
         * @param grantReadACP
         *        Allows grantee to read the object ACL.</p> <note>
         *        <ul>
         *        <li>
         *        <p>
         *        This functionality is not supported for directory buckets.
         *        </p>
         *        </li>
         *        <li>
         *        <p>
         *        This functionality is not supported for Amazon S3 on Outposts.
         *        </p>
         *        </li>
         *        </ul>
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder grantReadACP(String grantReadACP);

        /**
         * <p>
         * Allows grantee to write the ACL for the applicable object.
         * </p>
         * <note>
         * <ul>
         * <li>
         * <p>
         * This functionality is not supported for directory buckets.
         * </p>
         * </li>
         * <li>
         * <p>
         * This functionality is not supported for Amazon S3 on Outposts.
         * </p>
         * </li>
         * </ul>
         * </note>
         * 
         * @param grantWriteACP
         *        Allows grantee to write the ACL for the applicable object.</p> <note>
         *        <ul>
         *        <li>
         *        <p>
         *        This functionality is not supported for directory buckets.
         *        </p>
         *        </li>
         *        <li>
         *        <p>
         *        This functionality is not supported for Amazon S3 on Outposts.
         *        </p>
         *        </li>
         *        </ul>
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder grantWriteACP(String grantWriteACP);

        /**
         * <p>
         * A map of metadata to store with the object in S3.
         * </p>
         * 
         * @param metadata
         *        A map of metadata to store with the object in S3.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder metadata(Map<String, String> metadata);

        /**
         * <p>
         * Specifies whether the metadata is copied from the source object or replaced with metadata that's provided in
         * the request. When copying an object, you can preserve all metadata (the default) or specify new metadata. If
         * this header isn’t specified, <code>COPY</code> is the default behavior.
         * </p>
         * <p>
         * <b>General purpose bucket</b> - For general purpose buckets, when you grant permissions, you can use the
         * <code>s3:x-amz-metadata-directive</code> condition key to enforce certain metadata behavior when objects are
         * uploaded. For more information, see <a
         * href="https://docs.aws.amazon.com/AmazonS3/latest/dev/amazon-s3-policy-keys.html">Amazon S3 condition key
         * examples</a> in the <i>Amazon S3 User Guide</i>.
         * </p>
         * <note>
         * <p>
         * <code>x-amz-website-redirect-location</code> is unique to each object and is not copied when using the
         * <code>x-amz-metadata-directive</code> header. To copy the value, you must specify
         * <code>x-amz-website-redirect-location</code> in the request header.
         * </p>
         * </note>
         * 
         * @param metadataDirective
         *        Specifies whether the metadata is copied from the source object or replaced with metadata that's
         *        provided in the request. When copying an object, you can preserve all metadata (the default) or
         *        specify new metadata. If this header isn’t specified, <code>COPY</code> is the default behavior. </p>
         *        <p>
         *        <b>General purpose bucket</b> - For general purpose buckets, when you grant permissions, you can use
         *        the <code>s3:x-amz-metadata-directive</code> condition key to enforce certain metadata behavior when
         *        objects are uploaded. For more information, see <a
         *        href="https://docs.aws.amazon.com/AmazonS3/latest/dev/amazon-s3-policy-keys.html">Amazon S3 condition
         *        key examples</a> in the <i>Amazon S3 User Guide</i>.
         *        </p>
         *        <note>
         *        <p>
         *        <code>x-amz-website-redirect-location</code> is unique to each object and is not copied when using the
         *        <code>x-amz-metadata-directive</code> header. To copy the value, you must specify
         *        <code>x-amz-website-redirect-location</code> in the request header.
         *        </p>
         * @see MetadataDirective
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see MetadataDirective
         */
        Builder metadataDirective(String metadataDirective);

        /**
         * <p>
         * Specifies whether the metadata is copied from the source object or replaced with metadata that's provided in
         * the request. When copying an object, you can preserve all metadata (the default) or specify new metadata. If
         * this header isn’t specified, <code>COPY</code> is the default behavior.
         * </p>
         * <p>
         * <b>General purpose bucket</b> - For general purpose buckets, when you grant permissions, you can use the
         * <code>s3:x-amz-metadata-directive</code> condition key to enforce certain metadata behavior when objects are
         * uploaded. For more information, see <a
         * href="https://docs.aws.amazon.com/AmazonS3/latest/dev/amazon-s3-policy-keys.html">Amazon S3 condition key
         * examples</a> in the <i>Amazon S3 User Guide</i>.
         * </p>
         * <note>
         * <p>
         * <code>x-amz-website-redirect-location</code> is unique to each object and is not copied when using the
         * <code>x-amz-metadata-directive</code> header. To copy the value, you must specify
         * <code>x-amz-website-redirect-location</code> in the request header.
         * </p>
         * </note>
         * 
         * @param metadataDirective
         *        Specifies whether the metadata is copied from the source object or replaced with metadata that's
         *        provided in the request. When copying an object, you can preserve all metadata (the default) or
         *        specify new metadata. If this header isn’t specified, <code>COPY</code> is the default behavior. </p>
         *        <p>
         *        <b>General purpose bucket</b> - For general purpose buckets, when you grant permissions, you can use
         *        the <code>s3:x-amz-metadata-directive</code> condition key to enforce certain metadata behavior when
         *        objects are uploaded. For more information, see <a
         *        href="https://docs.aws.amazon.com/AmazonS3/latest/dev/amazon-s3-policy-keys.html">Amazon S3 condition
         *        key examples</a> in the <i>Amazon S3 User Guide</i>.
         *        </p>
         *        <note>
         *        <p>
         *        <code>x-amz-website-redirect-location</code> is unique to each object and is not copied when using the
         *        <code>x-amz-metadata-directive</code> header. To copy the value, you must specify
         *        <code>x-amz-website-redirect-location</code> in the request header.
         *        </p>
         * @see MetadataDirective
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see MetadataDirective
         */
        Builder metadataDirective(MetadataDirective metadataDirective);

        /**
         * <p>
         * Specifies whether the object tag-set is copied from the source object or replaced with the tag-set that's
         * provided in the request.
         * </p>
         * <p>
         * The default value is <code>COPY</code>.
         * </p>
         * <note>
         * <p>
         * <b>Directory buckets</b> - For directory buckets in a <code>CopyObject</code> operation, only the empty
         * tag-set is supported. Any requests that attempt to write non-empty tags into directory buckets will receive a
         * <code>501 Not Implemented</code> status code. When the destination bucket is a directory bucket, you will
         * receive a <code>501 Not Implemented</code> response in any of the following situations:
         * </p>
         * <ul>
         * <li>
         * <p>
         * When you attempt to <code>COPY</code> the tag-set from an S3 source object that has non-empty tags.
         * </p>
         * </li>
         * <li>
         * <p>
         * When you attempt to <code>REPLACE</code> the tag-set of a source object and set a non-empty value to
         * <code>x-amz-tagging</code>.
         * </p>
         * </li>
         * <li>
         * <p>
         * When you don't set the <code>x-amz-tagging-directive</code> header and the source object has non-empty tags.
         * This is because the default value of <code>x-amz-tagging-directive</code> is <code>COPY</code>.
         * </p>
         * </li>
         * </ul>
         * <p>
         * Because only the empty tag-set is supported for directory buckets in a <code>CopyObject</code> operation, the
         * following situations are allowed:
         * </p>
         * <ul>
         * <li>
         * <p>
         * When you attempt to <code>COPY</code> the tag-set from a directory bucket source object that has no tags to a
         * general purpose bucket. It copies an empty tag-set to the destination object.
         * </p>
         * </li>
         * <li>
         * <p>
         * When you attempt to <code>REPLACE</code> the tag-set of a directory bucket source object and set the
         * <code>x-amz-tagging</code> value of the directory bucket destination object to empty.
         * </p>
         * </li>
         * <li>
         * <p>
         * When you attempt to <code>REPLACE</code> the tag-set of a general purpose bucket source object that has
         * non-empty tags and set the <code>x-amz-tagging</code> value of the directory bucket destination object to
         * empty.
         * </p>
         * </li>
         * <li>
         * <p>
         * When you attempt to <code>REPLACE</code> the tag-set of a directory bucket source object and don't set the
         * <code>x-amz-tagging</code> value of the directory bucket destination object. This is because the default
         * value of <code>x-amz-tagging</code> is the empty value.
         * </p>
         * </li>
         * </ul>
         * </note>
         * 
         * @param taggingDirective
         *        Specifies whether the object tag-set is copied from the source object or replaced with the tag-set
         *        that's provided in the request.</p>
         *        <p>
         *        The default value is <code>COPY</code>.
         *        </p>
         *        <note>
         *        <p>
         *        <b>Directory buckets</b> - For directory buckets in a <code>CopyObject</code> operation, only the
         *        empty tag-set is supported. Any requests that attempt to write non-empty tags into directory buckets
         *        will receive a <code>501 Not Implemented</code> status code. When the destination bucket is a
         *        directory bucket, you will receive a <code>501 Not Implemented</code> response in any of the following
         *        situations:
         *        </p>
         *        <ul>
         *        <li>
         *        <p>
         *        When you attempt to <code>COPY</code> the tag-set from an S3 source object that has non-empty tags.
         *        </p>
         *        </li>
         *        <li>
         *        <p>
         *        When you attempt to <code>REPLACE</code> the tag-set of a source object and set a non-empty value to
         *        <code>x-amz-tagging</code>.
         *        </p>
         *        </li>
         *        <li>
         *        <p>
         *        When you don't set the <code>x-amz-tagging-directive</code> header and the source object has non-empty
         *        tags. This is because the default value of <code>x-amz-tagging-directive</code> is <code>COPY</code>.
         *        </p>
         *        </li>
         *        </ul>
         *        <p>
         *        Because only the empty tag-set is supported for directory buckets in a <code>CopyObject</code>
         *        operation, the following situations are allowed:
         *        </p>
         *        <ul>
         *        <li>
         *        <p>
         *        When you attempt to <code>COPY</code> the tag-set from a directory bucket source object that has no
         *        tags to a general purpose bucket. It copies an empty tag-set to the destination object.
         *        </p>
         *        </li>
         *        <li>
         *        <p>
         *        When you attempt to <code>REPLACE</code> the tag-set of a directory bucket source object and set the
         *        <code>x-amz-tagging</code> value of the directory bucket destination object to empty.
         *        </p>
         *        </li>
         *        <li>
         *        <p>
         *        When you attempt to <code>REPLACE</code> the tag-set of a general purpose bucket source object that
         *        has non-empty tags and set the <code>x-amz-tagging</code> value of the directory bucket destination
         *        object to empty.
         *        </p>
         *        </li>
         *        <li>
         *        <p>
         *        When you attempt to <code>REPLACE</code> the tag-set of a directory bucket source object and don't set
         *        the <code>x-amz-tagging</code> value of the directory bucket destination object. This is because the
         *        default value of <code>x-amz-tagging</code> is the empty value.
         *        </p>
         *        </li>
         *        </ul>
         * @see TaggingDirective
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see TaggingDirective
         */
        Builder taggingDirective(String taggingDirective);

        /**
         * <p>
         * Specifies whether the object tag-set is copied from the source object or replaced with the tag-set that's
         * provided in the request.
         * </p>
         * <p>
         * The default value is <code>COPY</code>.
         * </p>
         * <note>
         * <p>
         * <b>Directory buckets</b> - For directory buckets in a <code>CopyObject</code> operation, only the empty
         * tag-set is supported. Any requests that attempt to write non-empty tags into directory buckets will receive a
         * <code>501 Not Implemented</code> status code. When the destination bucket is a directory bucket, you will
         * receive a <code>501 Not Implemented</code> response in any of the following situations:
         * </p>
         * <ul>
         * <li>
         * <p>
         * When you attempt to <code>COPY</code> the tag-set from an S3 source object that has non-empty tags.
         * </p>
         * </li>
         * <li>
         * <p>
         * When you attempt to <code>REPLACE</code> the tag-set of a source object and set a non-empty value to
         * <code>x-amz-tagging</code>.
         * </p>
         * </li>
         * <li>
         * <p>
         * When you don't set the <code>x-amz-tagging-directive</code> header and the source object has non-empty tags.
         * This is because the default value of <code>x-amz-tagging-directive</code> is <code>COPY</code>.
         * </p>
         * </li>
         * </ul>
         * <p>
         * Because only the empty tag-set is supported for directory buckets in a <code>CopyObject</code> operation, the
         * following situations are allowed:
         * </p>
         * <ul>
         * <li>
         * <p>
         * When you attempt to <code>COPY</code> the tag-set from a directory bucket source object that has no tags to a
         * general purpose bucket. It copies an empty tag-set to the destination object.
         * </p>
         * </li>
         * <li>
         * <p>
         * When you attempt to <code>REPLACE</code> the tag-set of a directory bucket source object and set the
         * <code>x-amz-tagging</code> value of the directory bucket destination object to empty.
         * </p>
         * </li>
         * <li>
         * <p>
         * When you attempt to <code>REPLACE</code> the tag-set of a general purpose bucket source object that has
         * non-empty tags and set the <code>x-amz-tagging</code> value of the directory bucket destination object to
         * empty.
         * </p>
         * </li>
         * <li>
         * <p>
         * When you attempt to <code>REPLACE</code> the tag-set of a directory bucket source object and don't set the
         * <code>x-amz-tagging</code> value of the directory bucket destination object. This is because the default
         * value of <code>x-amz-tagging</code> is the empty value.
         * </p>
         * </li>
         * </ul>
         * </note>
         * 
         * @param taggingDirective
         *        Specifies whether the object tag-set is copied from the source object or replaced with the tag-set
         *        that's provided in the request.</p>
         *        <p>
         *        The default value is <code>COPY</code>.
         *        </p>
         *        <note>
         *        <p>
         *        <b>Directory buckets</b> - For directory buckets in a <code>CopyObject</code> operation, only the
         *        empty tag-set is supported. Any requests that attempt to write non-empty tags into directory buckets
         *        will receive a <code>501 Not Implemented</code> status code. When the destination bucket is a
         *        directory bucket, you will receive a <code>501 Not Implemented</code> response in any of the following
         *        situations:
         *        </p>
         *        <ul>
         *        <li>
         *        <p>
         *        When you attempt to <code>COPY</code> the tag-set from an S3 source object that has non-empty tags.
         *        </p>
         *        </li>
         *        <li>
         *        <p>
         *        When you attempt to <code>REPLACE</code> the tag-set of a source object and set a non-empty value to
         *        <code>x-amz-tagging</code>.
         *        </p>
         *        </li>
         *        <li>
         *        <p>
         *        When you don't set the <code>x-amz-tagging-directive</code> header and the source object has non-empty
         *        tags. This is because the default value of <code>x-amz-tagging-directive</code> is <code>COPY</code>.
         *        </p>
         *        </li>
         *        </ul>
         *        <p>
         *        Because only the empty tag-set is supported for directory buckets in a <code>CopyObject</code>
         *        operation, the following situations are allowed:
         *        </p>
         *        <ul>
         *        <li>
         *        <p>
         *        When you attempt to <code>COPY</code> the tag-set from a directory bucket source object that has no
         *        tags to a general purpose bucket. It copies an empty tag-set to the destination object.
         *        </p>
         *        </li>
         *        <li>
         *        <p>
         *        When you attempt to <code>REPLACE</code> the tag-set of a directory bucket source object and set the
         *        <code>x-amz-tagging</code> value of the directory bucket destination object to empty.
         *        </p>
         *        </li>
         *        <li>
         *        <p>
         *        When you attempt to <code>REPLACE</code> the tag-set of a general purpose bucket source object that
         *        has non-empty tags and set the <code>x-amz-tagging</code> value of the directory bucket destination
         *        object to empty.
         *        </p>
         *        </li>
         *        <li>
         *        <p>
         *        When you attempt to <code>REPLACE</code> the tag-set of a directory bucket source object and don't set
         *        the <code>x-amz-tagging</code> value of the directory bucket destination object. This is because the
         *        default value of <code>x-amz-tagging</code> is the empty value.
         *        </p>
         *        </li>
         *        </ul>
         * @see TaggingDirective
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see TaggingDirective
         */
        Builder taggingDirective(TaggingDirective taggingDirective);

        /**
         * <p>
         * The server-side encryption algorithm used when storing this object in Amazon S3. Unrecognized or unsupported
         * values won’t write a destination object and will receive a <code>400 Bad Request</code> response.
         * </p>
         * <p>
         * Amazon S3 automatically encrypts all new objects that are copied to an S3 bucket. When copying an object, if
         * you don't specify encryption information in your copy request, the encryption setting of the target object is
         * set to the default encryption configuration of the destination bucket. By default, all buckets have a base
         * level of encryption configuration that uses server-side encryption with Amazon S3 managed keys (SSE-S3). If
         * the destination bucket has a different default encryption configuration, Amazon S3 uses the corresponding
         * encryption key to encrypt the target object copy.
         * </p>
         * <p>
         * With server-side encryption, Amazon S3 encrypts your data as it writes your data to disks in its data centers
         * and decrypts the data when you access it. For more information about server-side encryption, see <a
         * href="https://docs.aws.amazon.com/AmazonS3/latest/dev/serv-side-encryption.html">Using Server-Side
         * Encryption</a> in the <i>Amazon S3 User Guide</i>.
         * </p>
         * <p>
         * <b>General purpose buckets </b>
         * </p>
         * <ul>
         * <li>
         * <p>
         * For general purpose buckets, there are the following supported options for server-side encryption:
         * server-side encryption with Key Management Service (KMS) keys (SSE-KMS), dual-layer server-side encryption
         * with Amazon Web Services KMS keys (DSSE-KMS), and server-side encryption with customer-provided encryption
         * keys (SSE-C). Amazon S3 uses the corresponding KMS key, or a customer-provided key to encrypt the target
         * object copy.
         * </p>
         * </li>
         * <li>
         * <p>
         * When you perform a <code>CopyObject</code> operation, if you want to use a different type of encryption
         * setting for the target object, you can specify appropriate encryption-related headers to encrypt the target
         * object with an Amazon S3 managed key, a KMS key, or a customer-provided key. If the encryption setting in
         * your request is different from the default encryption configuration of the destination bucket, the encryption
         * setting in your request takes precedence.
         * </p>
         * </li>
         * </ul>
         * <p>
         * <b>Directory buckets </b>
         * </p>
         * <ul>
         * <li>
         * <p>
         * For directory buckets, there are only two supported options for server-side encryption: server-side
         * encryption with Amazon S3 managed keys (SSE-S3) (<code>AES256</code>) and server-side encryption with KMS
         * keys (SSE-KMS) (<code>aws:kms</code>). We recommend that the bucket's default encryption uses the desired
         * encryption configuration and you don't override the bucket default encryption in your
         * <code>CreateSession</code> requests or <code>PUT</code> object requests. Then, new objects are automatically
         * encrypted with the desired encryption settings. For more information, see <a
         * href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/s3-express-serv-side-encryption.html">Protecting
         * data with server-side encryption</a> in the <i>Amazon S3 User Guide</i>. For more information about the
         * encryption overriding behaviors in directory buckets, see <a
         * href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/s3-express-specifying-kms-encryption.html"
         * >Specifying server-side encryption with KMS for new object uploads</a>.
         * </p>
         * </li>
         * <li>
         * <p>
         * To encrypt new object copies to a directory bucket with SSE-KMS, we recommend you specify SSE-KMS as the
         * directory bucket's default encryption configuration with a KMS key (specifically, a <a
         * href="https://docs.aws.amazon.com/kms/latest/developerguide/concepts.html#customer-cmk">customer managed
         * key</a>). The <a
         * href="https://docs.aws.amazon.com/kms/latest/developerguide/concepts.html#aws-managed-cmk">Amazon Web
         * Services managed key</a> (<code>aws/s3</code>) isn't supported. Your SSE-KMS configuration can only support 1
         * <a href="https://docs.aws.amazon.com/kms/latest/developerguide/concepts.html#customer-cmk">customer managed
         * key</a> per directory bucket for the lifetime of the bucket. After you specify a customer managed key for
         * SSE-KMS, you can't override the customer managed key for the bucket's SSE-KMS configuration. Then, when you
         * perform a <code>CopyObject</code> operation and want to specify server-side encryption settings for new
         * object copies with SSE-KMS in the encryption-related request headers, you must ensure the encryption key is
         * the same customer managed key that you specified for the directory bucket's default encryption configuration.
         * </p>
         * </li>
         * </ul>
         * 
         * @param serverSideEncryption
         *        The server-side encryption algorithm used when storing this object in Amazon S3. Unrecognized or
         *        unsupported values won’t write a destination object and will receive a <code>400 Bad Request</code>
         *        response. </p>
         *        <p>
         *        Amazon S3 automatically encrypts all new objects that are copied to an S3 bucket. When copying an
         *        object, if you don't specify encryption information in your copy request, the encryption setting of
         *        the target object is set to the default encryption configuration of the destination bucket. By
         *        default, all buckets have a base level of encryption configuration that uses server-side encryption
         *        with Amazon S3 managed keys (SSE-S3). If the destination bucket has a different default encryption
         *        configuration, Amazon S3 uses the corresponding encryption key to encrypt the target object copy.
         *        </p>
         *        <p>
         *        With server-side encryption, Amazon S3 encrypts your data as it writes your data to disks in its data
         *        centers and decrypts the data when you access it. For more information about server-side encryption,
         *        see <a href="https://docs.aws.amazon.com/AmazonS3/latest/dev/serv-side-encryption.html">Using
         *        Server-Side Encryption</a> in the <i>Amazon S3 User Guide</i>.
         *        </p>
         *        <p>
         *        <b>General purpose buckets </b>
         *        </p>
         *        <ul>
         *        <li>
         *        <p>
         *        For general purpose buckets, there are the following supported options for server-side encryption:
         *        server-side encryption with Key Management Service (KMS) keys (SSE-KMS), dual-layer server-side
         *        encryption with Amazon Web Services KMS keys (DSSE-KMS), and server-side encryption with
         *        customer-provided encryption keys (SSE-C). Amazon S3 uses the corresponding KMS key, or a
         *        customer-provided key to encrypt the target object copy.
         *        </p>
         *        </li>
         *        <li>
         *        <p>
         *        When you perform a <code>CopyObject</code> operation, if you want to use a different type of
         *        encryption setting for the target object, you can specify appropriate encryption-related headers to
         *        encrypt the target object with an Amazon S3 managed key, a KMS key, or a customer-provided key. If the
         *        encryption setting in your request is different from the default encryption configuration of the
         *        destination bucket, the encryption setting in your request takes precedence.
         *        </p>
         *        </li>
         *        </ul>
         *        <p>
         *        <b>Directory buckets </b>
         *        </p>
         *        <ul>
         *        <li>
         *        <p>
         *        For directory buckets, there are only two supported options for server-side encryption: server-side
         *        encryption with Amazon S3 managed keys (SSE-S3) (<code>AES256</code>) and server-side encryption with
         *        KMS keys (SSE-KMS) (<code>aws:kms</code>). We recommend that the bucket's default encryption uses the
         *        desired encryption configuration and you don't override the bucket default encryption in your
         *        <code>CreateSession</code> requests or <code>PUT</code> object requests. Then, new objects are
         *        automatically encrypted with the desired encryption settings. For more information, see <a
         *        href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/s3-express-serv-side-encryption.html"
         *        >Protecting data with server-side encryption</a> in the <i>Amazon S3 User Guide</i>. For more
         *        information about the encryption overriding behaviors in directory buckets, see <a href=
         *        "https://docs.aws.amazon.com/AmazonS3/latest/userguide/s3-express-specifying-kms-encryption.html"
         *        >Specifying server-side encryption with KMS for new object uploads</a>.
         *        </p>
         *        </li>
         *        <li>
         *        <p>
         *        To encrypt new object copies to a directory bucket with SSE-KMS, we recommend you specify SSE-KMS as
         *        the directory bucket's default encryption configuration with a KMS key (specifically, a <a
         *        href="https://docs.aws.amazon.com/kms/latest/developerguide/concepts.html#customer-cmk">customer
         *        managed key</a>). The <a
         *        href="https://docs.aws.amazon.com/kms/latest/developerguide/concepts.html#aws-managed-cmk">Amazon Web
         *        Services managed key</a> (<code>aws/s3</code>) isn't supported. Your SSE-KMS configuration can only
         *        support 1 <a
         *        href="https://docs.aws.amazon.com/kms/latest/developerguide/concepts.html#customer-cmk">customer
         *        managed key</a> per directory bucket for the lifetime of the bucket. After you specify a customer
         *        managed key for SSE-KMS, you can't override the customer managed key for the bucket's SSE-KMS
         *        configuration. Then, when you perform a <code>CopyObject</code> operation and want to specify
         *        server-side encryption settings for new object copies with SSE-KMS in the encryption-related request
         *        headers, you must ensure the encryption key is the same customer managed key that you specified for
         *        the directory bucket's default encryption configuration.
         *        </p>
         *        </li>
         * @see ServerSideEncryption
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see ServerSideEncryption
         */
        Builder serverSideEncryption(String serverSideEncryption);

        /**
         * <p>
         * The server-side encryption algorithm used when storing this object in Amazon S3. Unrecognized or unsupported
         * values won’t write a destination object and will receive a <code>400 Bad Request</code> response.
         * </p>
         * <p>
         * Amazon S3 automatically encrypts all new objects that are copied to an S3 bucket. When copying an object, if
         * you don't specify encryption information in your copy request, the encryption setting of the target object is
         * set to the default encryption configuration of the destination bucket. By default, all buckets have a base
         * level of encryption configuration that uses server-side encryption with Amazon S3 managed keys (SSE-S3). If
         * the destination bucket has a different default encryption configuration, Amazon S3 uses the corresponding
         * encryption key to encrypt the target object copy.
         * </p>
         * <p>
         * With server-side encryption, Amazon S3 encrypts your data as it writes your data to disks in its data centers
         * and decrypts the data when you access it. For more information about server-side encryption, see <a
         * href="https://docs.aws.amazon.com/AmazonS3/latest/dev/serv-side-encryption.html">Using Server-Side
         * Encryption</a> in the <i>Amazon S3 User Guide</i>.
         * </p>
         * <p>
         * <b>General purpose buckets </b>
         * </p>
         * <ul>
         * <li>
         * <p>
         * For general purpose buckets, there are the following supported options for server-side encryption:
         * server-side encryption with Key Management Service (KMS) keys (SSE-KMS), dual-layer server-side encryption
         * with Amazon Web Services KMS keys (DSSE-KMS), and server-side encryption with customer-provided encryption
         * keys (SSE-C). Amazon S3 uses the corresponding KMS key, or a customer-provided key to encrypt the target
         * object copy.
         * </p>
         * </li>
         * <li>
         * <p>
         * When you perform a <code>CopyObject</code> operation, if you want to use a different type of encryption
         * setting for the target object, you can specify appropriate encryption-related headers to encrypt the target
         * object with an Amazon S3 managed key, a KMS key, or a customer-provided key. If the encryption setting in
         * your request is different from the default encryption configuration of the destination bucket, the encryption
         * setting in your request takes precedence.
         * </p>
         * </li>
         * </ul>
         * <p>
         * <b>Directory buckets </b>
         * </p>
         * <ul>
         * <li>
         * <p>
         * For directory buckets, there are only two supported options for server-side encryption: server-side
         * encryption with Amazon S3 managed keys (SSE-S3) (<code>AES256</code>) and server-side encryption with KMS
         * keys (SSE-KMS) (<code>aws:kms</code>). We recommend that the bucket's default encryption uses the desired
         * encryption configuration and you don't override the bucket default encryption in your
         * <code>CreateSession</code> requests or <code>PUT</code> object requests. Then, new objects are automatically
         * encrypted with the desired encryption settings. For more information, see <a
         * href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/s3-express-serv-side-encryption.html">Protecting
         * data with server-side encryption</a> in the <i>Amazon S3 User Guide</i>. For more information about the
         * encryption overriding behaviors in directory buckets, see <a
         * href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/s3-express-specifying-kms-encryption.html"
         * >Specifying server-side encryption with KMS for new object uploads</a>.
         * </p>
         * </li>
         * <li>
         * <p>
         * To encrypt new object copies to a directory bucket with SSE-KMS, we recommend you specify SSE-KMS as the
         * directory bucket's default encryption configuration with a KMS key (specifically, a <a
         * href="https://docs.aws.amazon.com/kms/latest/developerguide/concepts.html#customer-cmk">customer managed
         * key</a>). The <a
         * href="https://docs.aws.amazon.com/kms/latest/developerguide/concepts.html#aws-managed-cmk">Amazon Web
         * Services managed key</a> (<code>aws/s3</code>) isn't supported. Your SSE-KMS configuration can only support 1
         * <a href="https://docs.aws.amazon.com/kms/latest/developerguide/concepts.html#customer-cmk">customer managed
         * key</a> per directory bucket for the lifetime of the bucket. After you specify a customer managed key for
         * SSE-KMS, you can't override the customer managed key for the bucket's SSE-KMS configuration. Then, when you
         * perform a <code>CopyObject</code> operation and want to specify server-side encryption settings for new
         * object copies with SSE-KMS in the encryption-related request headers, you must ensure the encryption key is
         * the same customer managed key that you specified for the directory bucket's default encryption configuration.
         * </p>
         * </li>
         * </ul>
         * 
         * @param serverSideEncryption
         *        The server-side encryption algorithm used when storing this object in Amazon S3. Unrecognized or
         *        unsupported values won’t write a destination object and will receive a <code>400 Bad Request</code>
         *        response. </p>
         *        <p>
         *        Amazon S3 automatically encrypts all new objects that are copied to an S3 bucket. When copying an
         *        object, if you don't specify encryption information in your copy request, the encryption setting of
         *        the target object is set to the default encryption configuration of the destination bucket. By
         *        default, all buckets have a base level of encryption configuration that uses server-side encryption
         *        with Amazon S3 managed keys (SSE-S3). If the destination bucket has a different default encryption
         *        configuration, Amazon S3 uses the corresponding encryption key to encrypt the target object copy.
         *        </p>
         *        <p>
         *        With server-side encryption, Amazon S3 encrypts your data as it writes your data to disks in its data
         *        centers and decrypts the data when you access it. For more information about server-side encryption,
         *        see <a href="https://docs.aws.amazon.com/AmazonS3/latest/dev/serv-side-encryption.html">Using
         *        Server-Side Encryption</a> in the <i>Amazon S3 User Guide</i>.
         *        </p>
         *        <p>
         *        <b>General purpose buckets </b>
         *        </p>
         *        <ul>
         *        <li>
         *        <p>
         *        For general purpose buckets, there are the following supported options for server-side encryption:
         *        server-side encryption with Key Management Service (KMS) keys (SSE-KMS), dual-layer server-side
         *        encryption with Amazon Web Services KMS keys (DSSE-KMS), and server-side encryption with
         *        customer-provided encryption keys (SSE-C). Amazon S3 uses the corresponding KMS key, or a
         *        customer-provided key to encrypt the target object copy.
         *        </p>
         *        </li>
         *        <li>
         *        <p>
         *        When you perform a <code>CopyObject</code> operation, if you want to use a different type of
         *        encryption setting for the target object, you can specify appropriate encryption-related headers to
         *        encrypt the target object with an Amazon S3 managed key, a KMS key, or a customer-provided key. If the
         *        encryption setting in your request is different from the default encryption configuration of the
         *        destination bucket, the encryption setting in your request takes precedence.
         *        </p>
         *        </li>
         *        </ul>
         *        <p>
         *        <b>Directory buckets </b>
         *        </p>
         *        <ul>
         *        <li>
         *        <p>
         *        For directory buckets, there are only two supported options for server-side encryption: server-side
         *        encryption with Amazon S3 managed keys (SSE-S3) (<code>AES256</code>) and server-side encryption with
         *        KMS keys (SSE-KMS) (<code>aws:kms</code>). We recommend that the bucket's default encryption uses the
         *        desired encryption configuration and you don't override the bucket default encryption in your
         *        <code>CreateSession</code> requests or <code>PUT</code> object requests. Then, new objects are
         *        automatically encrypted with the desired encryption settings. For more information, see <a
         *        href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/s3-express-serv-side-encryption.html"
         *        >Protecting data with server-side encryption</a> in the <i>Amazon S3 User Guide</i>. For more
         *        information about the encryption overriding behaviors in directory buckets, see <a href=
         *        "https://docs.aws.amazon.com/AmazonS3/latest/userguide/s3-express-specifying-kms-encryption.html"
         *        >Specifying server-side encryption with KMS for new object uploads</a>.
         *        </p>
         *        </li>
         *        <li>
         *        <p>
         *        To encrypt new object copies to a directory bucket with SSE-KMS, we recommend you specify SSE-KMS as
         *        the directory bucket's default encryption configuration with a KMS key (specifically, a <a
         *        href="https://docs.aws.amazon.com/kms/latest/developerguide/concepts.html#customer-cmk">customer
         *        managed key</a>). The <a
         *        href="https://docs.aws.amazon.com/kms/latest/developerguide/concepts.html#aws-managed-cmk">Amazon Web
         *        Services managed key</a> (<code>aws/s3</code>) isn't supported. Your SSE-KMS configuration can only
         *        support 1 <a
         *        href="https://docs.aws.amazon.com/kms/latest/developerguide/concepts.html#customer-cmk">customer
         *        managed key</a> per directory bucket for the lifetime of the bucket. After you specify a customer
         *        managed key for SSE-KMS, you can't override the customer managed key for the bucket's SSE-KMS
         *        configuration. Then, when you perform a <code>CopyObject</code> operation and want to specify
         *        server-side encryption settings for new object copies with SSE-KMS in the encryption-related request
         *        headers, you must ensure the encryption key is the same customer managed key that you specified for
         *        the directory bucket's default encryption configuration.
         *        </p>
         *        </li>
         * @see ServerSideEncryption
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see ServerSideEncryption
         */
        Builder serverSideEncryption(ServerSideEncryption serverSideEncryption);

        /**
         * <p>
         * If the <code>x-amz-storage-class</code> header is not used, the copied object will be stored in the
         * <code>STANDARD</code> Storage Class by default. The <code>STANDARD</code> storage class provides high
         * durability and high availability. Depending on performance needs, you can specify a different Storage Class.
         * </p>
         * <note>
         * <ul>
         * <li>
         * <p>
         * <b>Directory buckets </b> - Directory buckets only support <code>EXPRESS_ONEZONE</code> (the S3 Express One
         * Zone storage class) in Availability Zones and <code>ONEZONE_IA</code> (the S3 One Zone-Infrequent Access
         * storage class) in Dedicated Local Zones. Unsupported storage class values won't write a destination object
         * and will respond with the HTTP status code <code>400 Bad Request</code>.
         * </p>
         * </li>
         * <li>
         * <p>
         * <b>Amazon S3 on Outposts </b> - S3 on Outposts only uses the <code>OUTPOSTS</code> Storage Class.
         * </p>
         * </li>
         * </ul>
         * </note>
         * <p>
         * You can use the <code>CopyObject</code> action to change the storage class of an object that is already
         * stored in Amazon S3 by using the <code>x-amz-storage-class</code> header. For more information, see <a
         * href="https://docs.aws.amazon.com/AmazonS3/latest/dev/storage-class-intro.html">Storage Classes</a> in the
         * <i>Amazon S3 User Guide</i>.
         * </p>
         * <p>
         * Before using an object as a source object for the copy operation, you must restore a copy of it if it meets
         * any of the following conditions:
         * </p>
         * <ul>
         * <li>
         * <p>
         * The storage class of the source object is <code>GLACIER</code> or <code>DEEP_ARCHIVE</code>.
         * </p>
         * </li>
         * <li>
         * <p>
         * The storage class of the source object is <code>INTELLIGENT_TIERING</code> and it's <a href=
         * "https://docs.aws.amazon.com/AmazonS3/latest/userguide/intelligent-tiering-overview.html#intel-tiering-tier-definition"
         * >S3 Intelligent-Tiering access tier</a> is <code>Archive Access</code> or <code>Deep Archive Access</code>.
         * </p>
         * </li>
         * </ul>
         * <p>
         * For more information, see <a
         * href="https://docs.aws.amazon.com/AmazonS3/latest/API/API_RestoreObject.html">RestoreObject</a> and <a
         * href="https://docs.aws.amazon.com/AmazonS3/latest/dev/CopyingObjectsExamples.html">Copying Objects</a> in the
         * <i>Amazon S3 User Guide</i>.
         * </p>
         * 
         * @param storageClass
         *        If the <code>x-amz-storage-class</code> header is not used, the copied object will be stored in the
         *        <code>STANDARD</code> Storage Class by default. The <code>STANDARD</code> storage class provides high
         *        durability and high availability. Depending on performance needs, you can specify a different Storage
         *        Class. </p> <note>
         *        <ul>
         *        <li>
         *        <p>
         *        <b>Directory buckets </b> - Directory buckets only support <code>EXPRESS_ONEZONE</code> (the S3
         *        Express One Zone storage class) in Availability Zones and <code>ONEZONE_IA</code> (the S3 One
         *        Zone-Infrequent Access storage class) in Dedicated Local Zones. Unsupported storage class values won't
         *        write a destination object and will respond with the HTTP status code <code>400 Bad Request</code>.
         *        </p>
         *        </li>
         *        <li>
         *        <p>
         *        <b>Amazon S3 on Outposts </b> - S3 on Outposts only uses the <code>OUTPOSTS</code> Storage Class.
         *        </p>
         *        </li>
         *        </ul>
         *        </note>
         *        <p>
         *        You can use the <code>CopyObject</code> action to change the storage class of an object that is
         *        already stored in Amazon S3 by using the <code>x-amz-storage-class</code> header. For more
         *        information, see <a
         *        href="https://docs.aws.amazon.com/AmazonS3/latest/dev/storage-class-intro.html">Storage Classes</a> in
         *        the <i>Amazon S3 User Guide</i>.
         *        </p>
         *        <p>
         *        Before using an object as a source object for the copy operation, you must restore a copy of it if it
         *        meets any of the following conditions:
         *        </p>
         *        <ul>
         *        <li>
         *        <p>
         *        The storage class of the source object is <code>GLACIER</code> or <code>DEEP_ARCHIVE</code>.
         *        </p>
         *        </li>
         *        <li>
         *        <p>
         *        The storage class of the source object is <code>INTELLIGENT_TIERING</code> and it's <a href=
         *        "https://docs.aws.amazon.com/AmazonS3/latest/userguide/intelligent-tiering-overview.html#intel-tiering-tier-definition"
         *        >S3 Intelligent-Tiering access tier</a> is <code>Archive Access</code> or
         *        <code>Deep Archive Access</code>.
         *        </p>
         *        </li>
         *        </ul>
         *        <p>
         *        For more information, see <a
         *        href="https://docs.aws.amazon.com/AmazonS3/latest/API/API_RestoreObject.html">RestoreObject</a> and <a
         *        href="https://docs.aws.amazon.com/AmazonS3/latest/dev/CopyingObjectsExamples.html">Copying Objects</a>
         *        in the <i>Amazon S3 User Guide</i>.
         * @see StorageClass
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see StorageClass
         */
        Builder storageClass(String storageClass);

        /**
         * <p>
         * If the <code>x-amz-storage-class</code> header is not used, the copied object will be stored in the
         * <code>STANDARD</code> Storage Class by default. The <code>STANDARD</code> storage class provides high
         * durability and high availability. Depending on performance needs, you can specify a different Storage Class.
         * </p>
         * <note>
         * <ul>
         * <li>
         * <p>
         * <b>Directory buckets </b> - Directory buckets only support <code>EXPRESS_ONEZONE</code> (the S3 Express One
         * Zone storage class) in Availability Zones and <code>ONEZONE_IA</code> (the S3 One Zone-Infrequent Access
         * storage class) in Dedicated Local Zones. Unsupported storage class values won't write a destination object
         * and will respond with the HTTP status code <code>400 Bad Request</code>.
         * </p>
         * </li>
         * <li>
         * <p>
         * <b>Amazon S3 on Outposts </b> - S3 on Outposts only uses the <code>OUTPOSTS</code> Storage Class.
         * </p>
         * </li>
         * </ul>
         * </note>
         * <p>
         * You can use the <code>CopyObject</code> action to change the storage class of an object that is already
         * stored in Amazon S3 by using the <code>x-amz-storage-class</code> header. For more information, see <a
         * href="https://docs.aws.amazon.com/AmazonS3/latest/dev/storage-class-intro.html">Storage Classes</a> in the
         * <i>Amazon S3 User Guide</i>.
         * </p>
         * <p>
         * Before using an object as a source object for the copy operation, you must restore a copy of it if it meets
         * any of the following conditions:
         * </p>
         * <ul>
         * <li>
         * <p>
         * The storage class of the source object is <code>GLACIER</code> or <code>DEEP_ARCHIVE</code>.
         * </p>
         * </li>
         * <li>
         * <p>
         * The storage class of the source object is <code>INTELLIGENT_TIERING</code> and it's <a href=
         * "https://docs.aws.amazon.com/AmazonS3/latest/userguide/intelligent-tiering-overview.html#intel-tiering-tier-definition"
         * >S3 Intelligent-Tiering access tier</a> is <code>Archive Access</code> or <code>Deep Archive Access</code>.
         * </p>
         * </li>
         * </ul>
         * <p>
         * For more information, see <a
         * href="https://docs.aws.amazon.com/AmazonS3/latest/API/API_RestoreObject.html">RestoreObject</a> and <a
         * href="https://docs.aws.amazon.com/AmazonS3/latest/dev/CopyingObjectsExamples.html">Copying Objects</a> in the
         * <i>Amazon S3 User Guide</i>.
         * </p>
         * 
         * @param storageClass
         *        If the <code>x-amz-storage-class</code> header is not used, the copied object will be stored in the
         *        <code>STANDARD</code> Storage Class by default. The <code>STANDARD</code> storage class provides high
         *        durability and high availability. Depending on performance needs, you can specify a different Storage
         *        Class. </p> <note>
         *        <ul>
         *        <li>
         *        <p>
         *        <b>Directory buckets </b> - Directory buckets only support <code>EXPRESS_ONEZONE</code> (the S3
         *        Express One Zone storage class) in Availability Zones and <code>ONEZONE_IA</code> (the S3 One
         *        Zone-Infrequent Access storage class) in Dedicated Local Zones. Unsupported storage class values won't
         *        write a destination object and will respond with the HTTP status code <code>400 Bad Request</code>.
         *        </p>
         *        </li>
         *        <li>
         *        <p>
         *        <b>Amazon S3 on Outposts </b> - S3 on Outposts only uses the <code>OUTPOSTS</code> Storage Class.
         *        </p>
         *        </li>
         *        </ul>
         *        </note>
         *        <p>
         *        You can use the <code>CopyObject</code> action to change the storage class of an object that is
         *        already stored in Amazon S3 by using the <code>x-amz-storage-class</code> header. For more
         *        information, see <a
         *        href="https://docs.aws.amazon.com/AmazonS3/latest/dev/storage-class-intro.html">Storage Classes</a> in
         *        the <i>Amazon S3 User Guide</i>.
         *        </p>
         *        <p>
         *        Before using an object as a source object for the copy operation, you must restore a copy of it if it
         *        meets any of the following conditions:
         *        </p>
         *        <ul>
         *        <li>
         *        <p>
         *        The storage class of the source object is <code>GLACIER</code> or <code>DEEP_ARCHIVE</code>.
         *        </p>
         *        </li>
         *        <li>
         *        <p>
         *        The storage class of the source object is <code>INTELLIGENT_TIERING</code> and it's <a href=
         *        "https://docs.aws.amazon.com/AmazonS3/latest/userguide/intelligent-tiering-overview.html#intel-tiering-tier-definition"
         *        >S3 Intelligent-Tiering access tier</a> is <code>Archive Access</code> or
         *        <code>Deep Archive Access</code>.
         *        </p>
         *        </li>
         *        </ul>
         *        <p>
         *        For more information, see <a
         *        href="https://docs.aws.amazon.com/AmazonS3/latest/API/API_RestoreObject.html">RestoreObject</a> and <a
         *        href="https://docs.aws.amazon.com/AmazonS3/latest/dev/CopyingObjectsExamples.html">Copying Objects</a>
         *        in the <i>Amazon S3 User Guide</i>.
         * @see StorageClass
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see StorageClass
         */
        Builder storageClass(StorageClass storageClass);

        /**
         * <p>
         * If the destination bucket is configured as a website, redirects requests for this object copy to another
         * object in the same bucket or to an external URL. Amazon S3 stores the value of this header in the object
         * metadata. This value is unique to each object and is not copied when using the
         * <code>x-amz-metadata-directive</code> header. Instead, you may opt to provide this header in combination with
         * the <code>x-amz-metadata-directive</code> header.
         * </p>
         * <note>
         * <p>
         * This functionality is not supported for directory buckets.
         * </p>
         * </note>
         * 
         * @param websiteRedirectLocation
         *        If the destination bucket is configured as a website, redirects requests for this object copy to
         *        another object in the same bucket or to an external URL. Amazon S3 stores the value of this header in
         *        the object metadata. This value is unique to each object and is not copied when using the
         *        <code>x-amz-metadata-directive</code> header. Instead, you may opt to provide this header in
         *        combination with the <code>x-amz-metadata-directive</code> header.</p> <note>
         *        <p>
         *        This functionality is not supported for directory buckets.
         *        </p>
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder websiteRedirectLocation(String websiteRedirectLocation);

        /**
         * <p>
         * Specifies the algorithm to use when encrypting the object (for example, <code>AES256</code>).
         * </p>
         * <p>
         * When you perform a <code>CopyObject</code> operation, if you want to use a different type of encryption
         * setting for the target object, you can specify appropriate encryption-related headers to encrypt the target
         * object with an Amazon S3 managed key, a KMS key, or a customer-provided key. If the encryption setting in
         * your request is different from the default encryption configuration of the destination bucket, the encryption
         * setting in your request takes precedence.
         * </p>
         * <note>
         * <p>
         * This functionality is not supported when the destination bucket is a directory bucket.
         * </p>
         * </note>
         * 
         * @param sseCustomerAlgorithm
         *        Specifies the algorithm to use when encrypting the object (for example, <code>AES256</code>).</p>
         *        <p>
         *        When you perform a <code>CopyObject</code> operation, if you want to use a different type of
         *        encryption setting for the target object, you can specify appropriate encryption-related headers to
         *        encrypt the target object with an Amazon S3 managed key, a KMS key, or a customer-provided key. If the
         *        encryption setting in your request is different from the default encryption configuration of the
         *        destination bucket, the encryption setting in your request takes precedence.
         *        </p>
         *        <note>
         *        <p>
         *        This functionality is not supported when the destination bucket is a directory bucket.
         *        </p>
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder sseCustomerAlgorithm(String sseCustomerAlgorithm);

        /**
         * <p>
         * Specifies the customer-provided encryption key for Amazon S3 to use in encrypting data. This value is used to
         * store the object and then it is discarded. Amazon S3 does not store the encryption key. The key must be
         * appropriate for use with the algorithm specified in the
         * <code>x-amz-server-side-encryption-customer-algorithm</code> header.
         * </p>
         * <note>
         * <p>
         * This functionality is not supported when the destination bucket is a directory bucket.
         * </p>
         * </note>
         * 
         * @param sseCustomerKey
         *        Specifies the customer-provided encryption key for Amazon S3 to use in encrypting data. This value is
         *        used to store the object and then it is discarded. Amazon S3 does not store the encryption key. The
         *        key must be appropriate for use with the algorithm specified in the
         *        <code>x-amz-server-side-encryption-customer-algorithm</code> header.</p> <note>
         *        <p>
         *        This functionality is not supported when the destination bucket is a directory bucket.
         *        </p>
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder sseCustomerKey(String sseCustomerKey);

        /**
         * <p>
         * Specifies the 128-bit MD5 digest of the encryption key according to RFC 1321. Amazon S3 uses this header for
         * a message integrity check to ensure that the encryption key was transmitted without error.
         * </p>
         * <note>
         * <p>
         * This functionality is not supported when the destination bucket is a directory bucket.
         * </p>
         * </note>
         * 
         * @param sseCustomerKeyMD5
         *        Specifies the 128-bit MD5 digest of the encryption key according to RFC 1321. Amazon S3 uses this
         *        header for a message integrity check to ensure that the encryption key was transmitted without
         *        error.</p> <note>
         *        <p>
         *        This functionality is not supported when the destination bucket is a directory bucket.
         *        </p>
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder sseCustomerKeyMD5(String sseCustomerKeyMD5);

        /**
         * <p>
         * Specifies the KMS key ID (Key ID, Key ARN, or Key Alias) to use for object encryption. All GET and PUT
         * requests for an object protected by KMS will fail if they're not made via SSL or using SigV4. For information
         * about configuring any of the officially supported Amazon Web Services SDKs and Amazon Web Services CLI, see
         * <a href="https://docs.aws.amazon.com/AmazonS3/latest/dev/UsingAWSSDK.html#specify-signature-version">
         * Specifying the Signature Version in Request Authentication</a> in the <i>Amazon S3 User Guide</i>.
         * </p>
         * <p>
         * <b>Directory buckets</b> - To encrypt data using SSE-KMS, it's recommended to specify the
         * <code>x-amz-server-side-encryption</code> header to <code>aws:kms</code>. Then, the
         * <code>x-amz-server-side-encryption-aws-kms-key-id</code> header implicitly uses the bucket's default KMS
         * customer managed key ID. If you want to explicitly set the
         * <code> x-amz-server-side-encryption-aws-kms-key-id</code> header, it must match the bucket's default customer
         * managed key (using key ID or ARN, not alias). Your SSE-KMS configuration can only support 1 <a
         * href="https://docs.aws.amazon.com/kms/latest/developerguide/concepts.html#customer-cmk">customer managed
         * key</a> per directory bucket's lifetime. The <a
         * href="https://docs.aws.amazon.com/kms/latest/developerguide/concepts.html#aws-managed-cmk">Amazon Web
         * Services managed key</a> (<code>aws/s3</code>) isn't supported. Incorrect key specification results in an
         * HTTP <code>400 Bad Request</code> error.
         * </p>
         * 
         * @param ssekmsKeyId
         *        Specifies the KMS key ID (Key ID, Key ARN, or Key Alias) to use for object encryption. All GET and PUT
         *        requests for an object protected by KMS will fail if they're not made via SSL or using SigV4. For
         *        information about configuring any of the officially supported Amazon Web Services SDKs and Amazon Web
         *        Services CLI, see <a
         *        href="https://docs.aws.amazon.com/AmazonS3/latest/dev/UsingAWSSDK.html#specify-signature-version"
         *        >Specifying the Signature Version in Request Authentication</a> in the <i>Amazon S3 User
         *        Guide</i>.</p>
         *        <p>
         *        <b>Directory buckets</b> - To encrypt data using SSE-KMS, it's recommended to specify the
         *        <code>x-amz-server-side-encryption</code> header to <code>aws:kms</code>. Then, the
         *        <code>x-amz-server-side-encryption-aws-kms-key-id</code> header implicitly uses the bucket's default
         *        KMS customer managed key ID. If you want to explicitly set the
         *        <code> x-amz-server-side-encryption-aws-kms-key-id</code> header, it must match the bucket's default
         *        customer managed key (using key ID or ARN, not alias). Your SSE-KMS configuration can only support 1
         *        <a href="https://docs.aws.amazon.com/kms/latest/developerguide/concepts.html#customer-cmk">customer
         *        managed key</a> per directory bucket's lifetime. The <a
         *        href="https://docs.aws.amazon.com/kms/latest/developerguide/concepts.html#aws-managed-cmk">Amazon Web
         *        Services managed key</a> (<code>aws/s3</code>) isn't supported. Incorrect key specification results in
         *        an HTTP <code>400 Bad Request</code> error.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder ssekmsKeyId(String ssekmsKeyId);

        /**
         * <p>
         * Specifies the Amazon Web Services KMS Encryption Context as an additional encryption context to use for the
         * destination object encryption. The value of this header is a base64-encoded UTF-8 string holding JSON with
         * the encryption context key-value pairs.
         * </p>
         * <p>
         * <b>General purpose buckets</b> - This value must be explicitly added to specify encryption context for
         * <code>CopyObject</code> requests if you want an additional encryption context for your destination object.
         * The additional encryption context of the source object won't be copied to the destination object. For more
         * information, see <a
         * href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/UsingKMSEncryption.html#encryption-context"
         * >Encryption context</a> in the <i>Amazon S3 User Guide</i>.
         * </p>
         * <p>
         * <b>Directory buckets</b> - You can optionally provide an explicit encryption context value. The value must
         * match the default encryption context - the bucket Amazon Resource Name (ARN). An additional encryption
         * context value is not supported.
         * </p>
         * 
         * @param ssekmsEncryptionContext
         *        Specifies the Amazon Web Services KMS Encryption Context as an additional encryption context to use
         *        for the destination object encryption. The value of this header is a base64-encoded UTF-8 string
         *        holding JSON with the encryption context key-value pairs.</p>
         *        <p>
         *        <b>General purpose buckets</b> - This value must be explicitly added to specify encryption context for
         *        <code>CopyObject</code> requests if you want an additional encryption context for your destination
         *        object. The additional encryption context of the source object won't be copied to the destination
         *        object. For more information, see <a href=
         *        "https://docs.aws.amazon.com/AmazonS3/latest/userguide/UsingKMSEncryption.html#encryption-context"
         *        >Encryption context</a> in the <i>Amazon S3 User Guide</i>.
         *        </p>
         *        <p>
         *        <b>Directory buckets</b> - You can optionally provide an explicit encryption context value. The value
         *        must match the default encryption context - the bucket Amazon Resource Name (ARN). An additional
         *        encryption context value is not supported.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder ssekmsEncryptionContext(String ssekmsEncryptionContext);

        /**
         * <p>
         * Specifies whether Amazon S3 should use an S3 Bucket Key for object encryption with server-side encryption
         * using Key Management Service (KMS) keys (SSE-KMS). If a target object uses SSE-KMS, you can enable an S3
         * Bucket Key for the object.
         * </p>
         * <p>
         * Setting this header to <code>true</code> causes Amazon S3 to use an S3 Bucket Key for object encryption with
         * SSE-KMS. Specifying this header with a COPY action doesn’t affect bucket-level settings for S3 Bucket Key.
         * </p>
         * <p>
         * For more information, see <a href="https://docs.aws.amazon.com/AmazonS3/latest/dev/bucket-key.html">Amazon S3
         * Bucket Keys</a> in the <i>Amazon S3 User Guide</i>.
         * </p>
         * <note>
         * <p>
         * <b>Directory buckets</b> - S3 Bucket Keys aren't supported, when you copy SSE-KMS encrypted objects from
         * general purpose buckets to directory buckets, from directory buckets to general purpose buckets, or between
         * directory buckets, through <a
         * href="https://docs.aws.amazon.com/AmazonS3/latest/API/API_CopyObject.html">CopyObject</a>. In this case,
         * Amazon S3 makes a call to KMS every time a copy request is made for a KMS-encrypted object.
         * </p>
         * </note>
         * 
         * @param bucketKeyEnabled
         *        Specifies whether Amazon S3 should use an S3 Bucket Key for object encryption with server-side
         *        encryption using Key Management Service (KMS) keys (SSE-KMS). If a target object uses SSE-KMS, you can
         *        enable an S3 Bucket Key for the object.</p>
         *        <p>
         *        Setting this header to <code>true</code> causes Amazon S3 to use an S3 Bucket Key for object
         *        encryption with SSE-KMS. Specifying this header with a COPY action doesn’t affect bucket-level
         *        settings for S3 Bucket Key.
         *        </p>
         *        <p>
         *        For more information, see <a
         *        href="https://docs.aws.amazon.com/AmazonS3/latest/dev/bucket-key.html">Amazon S3 Bucket Keys</a> in
         *        the <i>Amazon S3 User Guide</i>.
         *        </p>
         *        <note>
         *        <p>
         *        <b>Directory buckets</b> - S3 Bucket Keys aren't supported, when you copy SSE-KMS encrypted objects
         *        from general purpose buckets to directory buckets, from directory buckets to general purpose buckets,
         *        or between directory buckets, through <a
         *        href="https://docs.aws.amazon.com/AmazonS3/latest/API/API_CopyObject.html">CopyObject</a>. In this
         *        case, Amazon S3 makes a call to KMS every time a copy request is made for a KMS-encrypted object.
         *        </p>
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder bucketKeyEnabled(Boolean bucketKeyEnabled);

        /**
         * <p>
         * Specifies the algorithm to use when decrypting the source object (for example, <code>AES256</code>).
         * </p>
         * <p>
         * If the source object for the copy is stored in Amazon S3 using SSE-C, you must provide the necessary
         * encryption information in your request so that Amazon S3 can decrypt the object for copying.
         * </p>
         * <note>
         * <p>
         * This functionality is not supported when the source object is in a directory bucket.
         * </p>
         * </note>
         * 
         * @param copySourceSSECustomerAlgorithm
         *        Specifies the algorithm to use when decrypting the source object (for example, <code>AES256</code>
         *        ).</p>
         *        <p>
         *        If the source object for the copy is stored in Amazon S3 using SSE-C, you must provide the necessary
         *        encryption information in your request so that Amazon S3 can decrypt the object for copying.
         *        </p>
         *        <note>
         *        <p>
         *        This functionality is not supported when the source object is in a directory bucket.
         *        </p>
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder copySourceSSECustomerAlgorithm(String copySourceSSECustomerAlgorithm);

        /**
         * <p>
         * Specifies the customer-provided encryption key for Amazon S3 to use to decrypt the source object. The
         * encryption key provided in this header must be the same one that was used when the source object was created.
         * </p>
         * <p>
         * If the source object for the copy is stored in Amazon S3 using SSE-C, you must provide the necessary
         * encryption information in your request so that Amazon S3 can decrypt the object for copying.
         * </p>
         * <note>
         * <p>
         * This functionality is not supported when the source object is in a directory bucket.
         * </p>
         * </note>
         * 
         * @param copySourceSSECustomerKey
         *        Specifies the customer-provided encryption key for Amazon S3 to use to decrypt the source object. The
         *        encryption key provided in this header must be the same one that was used when the source object was
         *        created.</p>
         *        <p>
         *        If the source object for the copy is stored in Amazon S3 using SSE-C, you must provide the necessary
         *        encryption information in your request so that Amazon S3 can decrypt the object for copying.
         *        </p>
         *        <note>
         *        <p>
         *        This functionality is not supported when the source object is in a directory bucket.
         *        </p>
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder copySourceSSECustomerKey(String copySourceSSECustomerKey);

        /**
         * <p>
         * Specifies the 128-bit MD5 digest of the encryption key according to RFC 1321. Amazon S3 uses this header for
         * a message integrity check to ensure that the encryption key was transmitted without error.
         * </p>
         * <p>
         * If the source object for the copy is stored in Amazon S3 using SSE-C, you must provide the necessary
         * encryption information in your request so that Amazon S3 can decrypt the object for copying.
         * </p>
         * <note>
         * <p>
         * This functionality is not supported when the source object is in a directory bucket.
         * </p>
         * </note>
         * 
         * @param copySourceSSECustomerKeyMD5
         *        Specifies the 128-bit MD5 digest of the encryption key according to RFC 1321. Amazon S3 uses this
         *        header for a message integrity check to ensure that the encryption key was transmitted without
         *        error.</p>
         *        <p>
         *        If the source object for the copy is stored in Amazon S3 using SSE-C, you must provide the necessary
         *        encryption information in your request so that Amazon S3 can decrypt the object for copying.
         *        </p>
         *        <note>
         *        <p>
         *        This functionality is not supported when the source object is in a directory bucket.
         *        </p>
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder copySourceSSECustomerKeyMD5(String copySourceSSECustomerKeyMD5);

        /**
         * Sets the value of the RequestPayer property for this object.
         *
         * @param requestPayer
         *        The new value for the RequestPayer property for this object.
         * @see RequestPayer
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see RequestPayer
         */
        Builder requestPayer(String requestPayer);

        /**
         * Sets the value of the RequestPayer property for this object.
         *
         * @param requestPayer
         *        The new value for the RequestPayer property for this object.
         * @see RequestPayer
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see RequestPayer
         */
        Builder requestPayer(RequestPayer requestPayer);

        /**
         * <p>
         * The tag-set for the object copy in the destination bucket. This value must be used in conjunction with the
         * <code>x-amz-tagging-directive</code> if you choose <code>REPLACE</code> for the
         * <code>x-amz-tagging-directive</code>. If you choose <code>COPY</code> for the
         * <code>x-amz-tagging-directive</code>, you don't need to set the <code>x-amz-tagging</code> header, because
         * the tag-set will be copied from the source object directly. The tag-set must be encoded as URL Query
         * parameters.
         * </p>
         * <p>
         * The default value is the empty value.
         * </p>
         * <note>
         * <p>
         * <b>Directory buckets</b> - For directory buckets in a <code>CopyObject</code> operation, only the empty
         * tag-set is supported. Any requests that attempt to write non-empty tags into directory buckets will receive a
         * <code>501 Not Implemented</code> status code. When the destination bucket is a directory bucket, you will
         * receive a <code>501 Not Implemented</code> response in any of the following situations:
         * </p>
         * <ul>
         * <li>
         * <p>
         * When you attempt to <code>COPY</code> the tag-set from an S3 source object that has non-empty tags.
         * </p>
         * </li>
         * <li>
         * <p>
         * When you attempt to <code>REPLACE</code> the tag-set of a source object and set a non-empty value to
         * <code>x-amz-tagging</code>.
         * </p>
         * </li>
         * <li>
         * <p>
         * When you don't set the <code>x-amz-tagging-directive</code> header and the source object has non-empty tags.
         * This is because the default value of <code>x-amz-tagging-directive</code> is <code>COPY</code>.
         * </p>
         * </li>
         * </ul>
         * <p>
         * Because only the empty tag-set is supported for directory buckets in a <code>CopyObject</code> operation, the
         * following situations are allowed:
         * </p>
         * <ul>
         * <li>
         * <p>
         * When you attempt to <code>COPY</code> the tag-set from a directory bucket source object that has no tags to a
         * general purpose bucket. It copies an empty tag-set to the destination object.
         * </p>
         * </li>
         * <li>
         * <p>
         * When you attempt to <code>REPLACE</code> the tag-set of a directory bucket source object and set the
         * <code>x-amz-tagging</code> value of the directory bucket destination object to empty.
         * </p>
         * </li>
         * <li>
         * <p>
         * When you attempt to <code>REPLACE</code> the tag-set of a general purpose bucket source object that has
         * non-empty tags and set the <code>x-amz-tagging</code> value of the directory bucket destination object to
         * empty.
         * </p>
         * </li>
         * <li>
         * <p>
         * When you attempt to <code>REPLACE</code> the tag-set of a directory bucket source object and don't set the
         * <code>x-amz-tagging</code> value of the directory bucket destination object. This is because the default
         * value of <code>x-amz-tagging</code> is the empty value.
         * </p>
         * </li>
         * </ul>
         * </note>
         * 
         * @param tagging
         *        The tag-set for the object copy in the destination bucket. This value must be used in conjunction with
         *        the <code>x-amz-tagging-directive</code> if you choose <code>REPLACE</code> for the
         *        <code>x-amz-tagging-directive</code>. If you choose <code>COPY</code> for the
         *        <code>x-amz-tagging-directive</code>, you don't need to set the <code>x-amz-tagging</code> header,
         *        because the tag-set will be copied from the source object directly. The tag-set must be encoded as URL
         *        Query parameters.</p>
         *        <p>
         *        The default value is the empty value.
         *        </p>
         *        <note>
         *        <p>
         *        <b>Directory buckets</b> - For directory buckets in a <code>CopyObject</code> operation, only the
         *        empty tag-set is supported. Any requests that attempt to write non-empty tags into directory buckets
         *        will receive a <code>501 Not Implemented</code> status code. When the destination bucket is a
         *        directory bucket, you will receive a <code>501 Not Implemented</code> response in any of the following
         *        situations:
         *        </p>
         *        <ul>
         *        <li>
         *        <p>
         *        When you attempt to <code>COPY</code> the tag-set from an S3 source object that has non-empty tags.
         *        </p>
         *        </li>
         *        <li>
         *        <p>
         *        When you attempt to <code>REPLACE</code> the tag-set of a source object and set a non-empty value to
         *        <code>x-amz-tagging</code>.
         *        </p>
         *        </li>
         *        <li>
         *        <p>
         *        When you don't set the <code>x-amz-tagging-directive</code> header and the source object has non-empty
         *        tags. This is because the default value of <code>x-amz-tagging-directive</code> is <code>COPY</code>.
         *        </p>
         *        </li>
         *        </ul>
         *        <p>
         *        Because only the empty tag-set is supported for directory buckets in a <code>CopyObject</code>
         *        operation, the following situations are allowed:
         *        </p>
         *        <ul>
         *        <li>
         *        <p>
         *        When you attempt to <code>COPY</code> the tag-set from a directory bucket source object that has no
         *        tags to a general purpose bucket. It copies an empty tag-set to the destination object.
         *        </p>
         *        </li>
         *        <li>
         *        <p>
         *        When you attempt to <code>REPLACE</code> the tag-set of a directory bucket source object and set the
         *        <code>x-amz-tagging</code> value of the directory bucket destination object to empty.
         *        </p>
         *        </li>
         *        <li>
         *        <p>
         *        When you attempt to <code>REPLACE</code> the tag-set of a general purpose bucket source object that
         *        has non-empty tags and set the <code>x-amz-tagging</code> value of the directory bucket destination
         *        object to empty.
         *        </p>
         *        </li>
         *        <li>
         *        <p>
         *        When you attempt to <code>REPLACE</code> the tag-set of a directory bucket source object and don't set
         *        the <code>x-amz-tagging</code> value of the directory bucket destination object. This is because the
         *        default value of <code>x-amz-tagging</code> is the empty value.
         *        </p>
         *        </li>
         *        </ul>
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder tagging(String tagging);

        Builder tagging(Tagging tagging);

        /**
         * <p>
         * The Object Lock mode that you want to apply to the object copy.
         * </p>
         * <note>
         * <p>
         * This functionality is not supported for directory buckets.
         * </p>
         * </note>
         * 
         * @param objectLockMode
         *        The Object Lock mode that you want to apply to the object copy.</p> <note>
         *        <p>
         *        This functionality is not supported for directory buckets.
         *        </p>
         * @see ObjectLockMode
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see ObjectLockMode
         */
        Builder objectLockMode(String objectLockMode);

        /**
         * <p>
         * The Object Lock mode that you want to apply to the object copy.
         * </p>
         * <note>
         * <p>
         * This functionality is not supported for directory buckets.
         * </p>
         * </note>
         * 
         * @param objectLockMode
         *        The Object Lock mode that you want to apply to the object copy.</p> <note>
         *        <p>
         *        This functionality is not supported for directory buckets.
         *        </p>
         * @see ObjectLockMode
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see ObjectLockMode
         */
        Builder objectLockMode(ObjectLockMode objectLockMode);

        /**
         * <p>
         * The date and time when you want the Object Lock of the object copy to expire.
         * </p>
         * <note>
         * <p>
         * This functionality is not supported for directory buckets.
         * </p>
         * </note>
         * 
         * @param objectLockRetainUntilDate
         *        The date and time when you want the Object Lock of the object copy to expire.</p> <note>
         *        <p>
         *        This functionality is not supported for directory buckets.
         *        </p>
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder objectLockRetainUntilDate(Instant objectLockRetainUntilDate);

        /**
         * <p>
         * Specifies whether you want to apply a legal hold to the object copy.
         * </p>
         * <note>
         * <p>
         * This functionality is not supported for directory buckets.
         * </p>
         * </note>
         * 
         * @param objectLockLegalHoldStatus
         *        Specifies whether you want to apply a legal hold to the object copy.</p> <note>
         *        <p>
         *        This functionality is not supported for directory buckets.
         *        </p>
         * @see ObjectLockLegalHoldStatus
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see ObjectLockLegalHoldStatus
         */
        Builder objectLockLegalHoldStatus(String objectLockLegalHoldStatus);

        /**
         * <p>
         * Specifies whether you want to apply a legal hold to the object copy.
         * </p>
         * <note>
         * <p>
         * This functionality is not supported for directory buckets.
         * </p>
         * </note>
         * 
         * @param objectLockLegalHoldStatus
         *        Specifies whether you want to apply a legal hold to the object copy.</p> <note>
         *        <p>
         *        This functionality is not supported for directory buckets.
         *        </p>
         * @see ObjectLockLegalHoldStatus
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see ObjectLockLegalHoldStatus
         */
        Builder objectLockLegalHoldStatus(ObjectLockLegalHoldStatus objectLockLegalHoldStatus);

        /**
         * <p>
         * The account ID of the expected destination bucket owner. If the account ID that you provide does not match
         * the actual owner of the destination bucket, the request fails with the HTTP status code
         * <code>403 Forbidden</code> (access denied).
         * </p>
         * 
         * @param expectedBucketOwner
         *        The account ID of the expected destination bucket owner. If the account ID that you provide does not
         *        match the actual owner of the destination bucket, the request fails with the HTTP status code
         *        <code>403 Forbidden</code> (access denied).
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder expectedBucketOwner(String expectedBucketOwner);

        /**
         * <p>
         * The account ID of the expected source bucket owner. If the account ID that you provide does not match the
         * actual owner of the source bucket, the request fails with the HTTP status code <code>403 Forbidden</code>
         * (access denied).
         * </p>
         * 
         * @param expectedSourceBucketOwner
         *        The account ID of the expected source bucket owner. If the account ID that you provide does not match
         *        the actual owner of the source bucket, the request fails with the HTTP status code
         *        <code>403 Forbidden</code> (access denied).
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder expectedSourceBucketOwner(String expectedSourceBucketOwner);

        /**
         * <p>
         * The name of the destination bucket.
         * </p>
         * <p>
         * <b>Directory buckets</b> - When you use this operation with a directory bucket, you must use
         * virtual-hosted-style requests in the format
         * <code> <i>Bucket-name</i>.s3express-<i>zone-id</i>.<i>region-code</i>.amazonaws.com</code>. Path-style
         * requests are not supported. Directory bucket names must be unique in the chosen Zone (Availability Zone or
         * Local Zone). Bucket names must follow the format <code> <i>bucket-base-name</i>--<i>zone-id</i>--x-s3</code>
         * (for example, <code> <i>amzn-s3-demo-bucket</i>--<i>usw2-az1</i>--x-s3</code>). For information about bucket
         * naming restrictions, see <a
         * href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/directory-bucket-naming-rules.html">Directory
         * bucket naming rules</a> in the <i>Amazon S3 User Guide</i>.
         * </p>
         * <note>
         * <p>
         * Copying objects across different Amazon Web Services Regions isn't supported when the source or destination
         * bucket is in Amazon Web Services Local Zones. The source and destination buckets must have the same parent
         * Amazon Web Services Region. Otherwise, you get an HTTP <code>400 Bad Request</code> error with the error code
         * <code>InvalidRequest</code>.
         * </p>
         * </note>
         * <p>
         * <b>Access points</b> - When you use this action with an access point for general purpose buckets, you must
         * provide the alias of the access point in place of the bucket name or specify the access point ARN. When you
         * use this action with an access point for directory buckets, you must provide the access point name in place
         * of the bucket name. When using the access point ARN, you must direct requests to the access point hostname.
         * The access point hostname takes the form
         * <i>AccessPointName</i>-<i>AccountId</i>.s3-accesspoint.<i>Region</i>.amazonaws.com. When using this action
         * with an access point through the Amazon Web Services SDKs, you provide the access point ARN in place of the
         * bucket name. For more information about access point ARNs, see <a
         * href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/using-access-points.html">Using access points</a>
         * in the <i>Amazon S3 User Guide</i>.
         * </p>
         * <note>
         * <p>
         * Object Lambda access points are not supported by directory buckets.
         * </p>
         * </note>
         * <p>
         * <b>S3 on Outposts</b> - When you use this action with S3 on Outposts, you must use the Outpost bucket access
         * point ARN or the access point alias for the destination bucket. You can only copy objects within the same
         * Outpost bucket. It's not supported to copy objects across different Amazon Web Services Outposts, between
         * buckets on the same Outposts, or between Outposts buckets and any other bucket types. For more information
         * about S3 on Outposts, see <a
         * href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/S3onOutposts.html">What is S3 on Outposts?</a> in
         * the <i>S3 on Outposts guide</i>. When you use this action with S3 on Outposts through the REST API, you must
         * direct requests to the S3 on Outposts hostname, in the format
         * <code> <i>AccessPointName</i>-<i>AccountId</i>.<i>outpostID</i>.s3-outposts.<i>Region</i>.amazonaws.com</code>
         * . The hostname isn't required when you use the Amazon Web Services CLI or SDKs.
         * </p>
         * 
         * @param destinationBucket
         *        The name of the destination bucket.</p>
         *        <p>
         *        <b>Directory buckets</b> - When you use this operation with a directory bucket, you must use
         *        virtual-hosted-style requests in the format
         *        <code> <i>Bucket-name</i>.s3express-<i>zone-id</i>.<i>region-code</i>.amazonaws.com</code>. Path-style
         *        requests are not supported. Directory bucket names must be unique in the chosen Zone (Availability
         *        Zone or Local Zone). Bucket names must follow the format
         *        <code> <i>bucket-base-name</i>--<i>zone-id</i>--x-s3</code> (for example,
         *        <code> <i>amzn-s3-demo-bucket</i>--<i>usw2-az1</i>--x-s3</code>). For information about bucket naming
         *        restrictions, see <a
         *        href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/directory-bucket-naming-rules.html"
         *        >Directory bucket naming rules</a> in the <i>Amazon S3 User Guide</i>.
         *        </p>
         *        <note>
         *        <p>
         *        Copying objects across different Amazon Web Services Regions isn't supported when the source or
         *        destination bucket is in Amazon Web Services Local Zones. The source and destination buckets must have
         *        the same parent Amazon Web Services Region. Otherwise, you get an HTTP <code>400 Bad Request</code>
         *        error with the error code <code>InvalidRequest</code>.
         *        </p>
         *        </note>
         *        <p>
         *        <b>Access points</b> - When you use this action with an access point for general purpose buckets, you
         *        must provide the alias of the access point in place of the bucket name or specify the access point
         *        ARN. When you use this action with an access point for directory buckets, you must provide the access
         *        point name in place of the bucket name. When using the access point ARN, you must direct requests to
         *        the access point hostname. The access point hostname takes the form
         *        <i>AccessPointName</i>-<i>AccountId</i>.s3-accesspoint.<i>Region</i>.amazonaws.com. When using this
         *        action with an access point through the Amazon Web Services SDKs, you provide the access point ARN in
         *        place of the bucket name. For more information about access point ARNs, see <a
         *        href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/using-access-points.html">Using access
         *        points</a> in the <i>Amazon S3 User Guide</i>.
         *        </p>
         *        <note>
         *        <p>
         *        Object Lambda access points are not supported by directory buckets.
         *        </p>
         *        </note>
         *        <p>
         *        <b>S3 on Outposts</b> - When you use this action with S3 on Outposts, you must use the Outpost bucket
         *        access point ARN or the access point alias for the destination bucket. You can only copy objects
         *        within the same Outpost bucket. It's not supported to copy objects across different Amazon Web
         *        Services Outposts, between buckets on the same Outposts, or between Outposts buckets and any other
         *        bucket types. For more information about S3 on Outposts, see <a
         *        href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/S3onOutposts.html">What is S3 on
         *        Outposts?</a> in the <i>S3 on Outposts guide</i>. When you use this action with S3 on Outposts through
         *        the REST API, you must direct requests to the S3 on Outposts hostname, in the format
         *        <code> <i>AccessPointName</i>-<i>AccountId</i>.<i>outpostID</i>.s3-outposts.<i>Region</i>.amazonaws.com</code>
         *        . The hostname isn't required when you use the Amazon Web Services CLI or SDKs.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder destinationBucket(String destinationBucket);

        /**
         * <p>
         * The name of the destination bucket.
         * </p>
         * <p>
         * <b>Directory buckets</b> - When you use this operation with a directory bucket, you must use
         * virtual-hosted-style requests in the format
         * <code> <i>Bucket-name</i>.s3express-<i>zone-id</i>.<i>region-code</i>.amazonaws.com</code>. Path-style
         * requests are not supported. Directory bucket names must be unique in the chosen Zone (Availability Zone or
         * Local Zone). Bucket names must follow the format <code> <i>bucket-base-name</i>--<i>zone-id</i>--x-s3</code>
         * (for example, <code> <i>amzn-s3-demo-bucket</i>--<i>usw2-az1</i>--x-s3</code>). For information about bucket
         * naming restrictions, see <a
         * href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/directory-bucket-naming-rules.html">Directory
         * bucket naming rules</a> in the <i>Amazon S3 User Guide</i>.
         * </p>
         * <note>
         * <p>
         * Copying objects across different Amazon Web Services Regions isn't supported when the source or destination
         * bucket is in Amazon Web Services Local Zones. The source and destination buckets must have the same parent
         * Amazon Web Services Region. Otherwise, you get an HTTP <code>400 Bad Request</code> error with the error code
         * <code>InvalidRequest</code>.
         * </p>
         * </note>
         * <p>
         * <b>Access points</b> - When you use this action with an access point for general purpose buckets, you must
         * provide the alias of the access point in place of the bucket name or specify the access point ARN. When you
         * use this action with an access point for directory buckets, you must provide the access point name in place
         * of the bucket name. When using the access point ARN, you must direct requests to the access point hostname.
         * The access point hostname takes the form
         * <i>AccessPointName</i>-<i>AccountId</i>.s3-accesspoint.<i>Region</i>.amazonaws.com. When using this action
         * with an access point through the Amazon Web Services SDKs, you provide the access point ARN in place of the
         * bucket name. For more information about access point ARNs, see <a
         * href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/using-access-points.html">Using access points</a>
         * in the <i>Amazon S3 User Guide</i>.
         * </p>
         * <note>
         * <p>
         * Object Lambda access points are not supported by directory buckets.
         * </p>
         * </note>
         * <p>
         * <b>S3 on Outposts</b> - When you use this action with S3 on Outposts, you must use the Outpost bucket access
         * point ARN or the access point alias for the destination bucket. You can only copy objects within the same
         * Outpost bucket. It's not supported to copy objects across different Amazon Web Services Outposts, between
         * buckets on the same Outposts, or between Outposts buckets and any other bucket types. For more information
         * about S3 on Outposts, see <a
         * href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/S3onOutposts.html">What is S3 on Outposts?</a> in
         * the <i>S3 on Outposts guide</i>. When you use this action with S3 on Outposts through the REST API, you must
         * direct requests to the S3 on Outposts hostname, in the format
         * <code> <i>AccessPointName</i>-<i>AccountId</i>.<i>outpostID</i>.s3-outposts.<i>Region</i>.amazonaws.com</code>
         * . The hostname isn't required when you use the Amazon Web Services CLI or SDKs.
         * </p>
         * 
         * @param destinationBucket
         *        The name of the destination bucket.</p>
         *        <p>
         *        <b>Directory buckets</b> - When you use this operation with a directory bucket, you must use
         *        virtual-hosted-style requests in the format
         *        <code> <i>Bucket-name</i>.s3express-<i>zone-id</i>.<i>region-code</i>.amazonaws.com</code>. Path-style
         *        requests are not supported. Directory bucket names must be unique in the chosen Zone (Availability
         *        Zone or Local Zone). Bucket names must follow the format
         *        <code> <i>bucket-base-name</i>--<i>zone-id</i>--x-s3</code> (for example,
         *        <code> <i>amzn-s3-demo-bucket</i>--<i>usw2-az1</i>--x-s3</code>). For information about bucket naming
         *        restrictions, see <a
         *        href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/directory-bucket-naming-rules.html"
         *        >Directory bucket naming rules</a> in the <i>Amazon S3 User Guide</i>.
         *        </p>
         *        <note>
         *        <p>
         *        Copying objects across different Amazon Web Services Regions isn't supported when the source or
         *        destination bucket is in Amazon Web Services Local Zones. The source and destination buckets must have
         *        the same parent Amazon Web Services Region. Otherwise, you get an HTTP <code>400 Bad Request</code>
         *        error with the error code <code>InvalidRequest</code>.
         *        </p>
         *        </note>
         *        <p>
         *        <b>Access points</b> - When you use this action with an access point for general purpose buckets, you
         *        must provide the alias of the access point in place of the bucket name or specify the access point
         *        ARN. When you use this action with an access point for directory buckets, you must provide the access
         *        point name in place of the bucket name. When using the access point ARN, you must direct requests to
         *        the access point hostname. The access point hostname takes the form
         *        <i>AccessPointName</i>-<i>AccountId</i>.s3-accesspoint.<i>Region</i>.amazonaws.com. When using this
         *        action with an access point through the Amazon Web Services SDKs, you provide the access point ARN in
         *        place of the bucket name. For more information about access point ARNs, see <a
         *        href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/using-access-points.html">Using access
         *        points</a> in the <i>Amazon S3 User Guide</i>.
         *        </p>
         *        <note>
         *        <p>
         *        Object Lambda access points are not supported by directory buckets.
         *        </p>
         *        </note>
         *        <p>
         *        <b>S3 on Outposts</b> - When you use this action with S3 on Outposts, you must use the Outpost bucket
         *        access point ARN or the access point alias for the destination bucket. You can only copy objects
         *        within the same Outpost bucket. It's not supported to copy objects across different Amazon Web
         *        Services Outposts, between buckets on the same Outposts, or between Outposts buckets and any other
         *        bucket types. For more information about S3 on Outposts, see <a
         *        href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/S3onOutposts.html">What is S3 on
         *        Outposts?</a> in the <i>S3 on Outposts guide</i>. When you use this action with S3 on Outposts through
         *        the REST API, you must direct requests to the S3 on Outposts hostname, in the format
         *        <code> <i>AccessPointName</i>-<i>AccountId</i>.<i>outpostID</i>.s3-outposts.<i>Region</i>.amazonaws.com</code>
         *        . The hostname isn't required when you use the Amazon Web Services CLI or SDKs.
         * @return Returns a reference to this object so that method calls can be chained together.
         * @deprecated Use {@link #destinationBucket(String)}
         */
        @Deprecated
        Builder bucket(String destinationBucket);

        /**
         * <p>
         * The key of the destination object.
         * </p>
         * 
         * @param destinationKey
         *        The key of the destination object.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder destinationKey(String destinationKey);

        /**
         * <p>
         * The key of the destination object.
         * </p>
         * 
         * @param destinationKey
         *        The key of the destination object.
         * @return Returns a reference to this object so that method calls can be chained together.
         * @deprecated Use {@link #destinationKey(String)}
         */
        @Deprecated
        Builder key(String destinationKey);

        /**
         * The name of the bucket containing the object to copy. The provided input will be URL encoded. The
         * {@code sourceBucket}, {@code sourceKey}, and {@code sourceVersionId} parameters must not be used in
         * conjunction with the {@code copySource} parameter.
         * 
         * @param sourceBucket
         *        The name of the bucket containing the object to copy. The provided input will be URL encoded. The
         *        {@code sourceBucket}, {@code sourceKey}, and {@code sourceVersionId} parameters must not be used in
         *        conjunction with the {@code copySource} parameter.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder sourceBucket(String sourceBucket);

        /**
         * The key of the object to copy. The provided input will be URL encoded. The {@code sourceBucket},
         * {@code sourceKey}, and {@code sourceVersionId} parameters must not be used in conjunction with the
         * {@code copySource} parameter.
         * 
         * @param sourceKey
         *        The key of the object to copy. The provided input will be URL encoded. The {@code sourceBucket},
         *        {@code sourceKey}, and {@code sourceVersionId} parameters must not be used in conjunction with the
         *        {@code copySource} parameter.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder sourceKey(String sourceKey);

        /**
         * Specifies a particular version of the source object to copy. By default the latest version is copied. The
         * {@code sourceBucket}, {@code sourceKey}, and {@code sourceVersionId} parameters must not be used in
         * conjunction with the {@code copySource} parameter.
         * 
         * @param sourceVersionId
         *        Specifies a particular version of the source object to copy. By default the latest version is copied.
         *        The {@code sourceBucket}, {@code sourceKey}, and {@code sourceVersionId} parameters must not be used
         *        in conjunction with the {@code copySource} parameter.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder sourceVersionId(String sourceVersionId);

        @Override
        Builder overrideConfiguration(AwsRequestOverrideConfiguration overrideConfiguration);

        @Override
        Builder overrideConfiguration(Consumer<AwsRequestOverrideConfiguration.Builder> builderConsumer);

        /**
         *  Controls how the Protection state of the source object is copied to the destination object.
         *  If copied, the retention period and all legal holds are copied onto the new object.
         *  The legal hold date's is set to the date of the copy.
         *
         *  @param retentionDirective
         *      Specifies the Retention Directive
         */
        Builder retentionDirective(RetentionDirective retentionDirective);

        Builder retentionExpirationDate(Instant retentionExpirationDate);

        Builder retentionLegalHoldId(String retentionLegalHoldId);

        Builder retentionPeriod(Long retentionPeriod);
    }

    static final class BuilderImpl extends S3Request.BuilderImpl implements Builder {
        private String acl;

        private String cacheControl;

        private String checksumAlgorithm;

        private String contentDisposition;

        private String contentEncoding;

        private String contentLanguage;

        private String contentType;

        private String copySource;

        private String copySourceIfMatch;

        private Instant copySourceIfModifiedSince;

        private String copySourceIfNoneMatch;

        private Instant copySourceIfUnmodifiedSince;

        private Instant expires;

        private String grantFullControl;

        private String grantRead;

        private String grantReadACP;

        private String grantWriteACP;

        private Map<String, String> metadata = DefaultSdkAutoConstructMap.getInstance();

        private String metadataDirective;

        private String taggingDirective;

        private String serverSideEncryption;

        private String storageClass;

        private String websiteRedirectLocation;

        private String sseCustomerAlgorithm;

        private String sseCustomerKey;

        private String sseCustomerKeyMD5;

        private String ssekmsKeyId;

        private String ssekmsEncryptionContext;

        private Boolean bucketKeyEnabled;

        private String copySourceSSECustomerAlgorithm;

        private String copySourceSSECustomerKey;

        private String copySourceSSECustomerKeyMD5;

        private String requestPayer;

        private String tagging;

        private String objectLockMode;

        private Instant objectLockRetainUntilDate;

        private String objectLockLegalHoldStatus;

        private String expectedBucketOwner;

        private String expectedSourceBucketOwner;

        private String destinationBucket;

        private String destinationKey;

        private String sourceBucket;

        private String sourceKey;

        private String sourceVersionId;

        /*************** IBM Supported **************/
        private RetentionDirective retentionDirective;

        private Instant retentionExpirationDate;

        private String retentionLegalHoldId;

        private Long retentionPeriod;

        private BuilderImpl() {
        }

        private BuilderImpl(CopyObjectRequest model) {
            super(model);
            acl(model.acl);
            cacheControl(model.cacheControl);
            checksumAlgorithm(model.checksumAlgorithm);
            contentDisposition(model.contentDisposition);
            contentEncoding(model.contentEncoding);
            contentLanguage(model.contentLanguage);
            contentType(model.contentType);
            copySource(model.copySource);
            copySourceIfMatch(model.copySourceIfMatch);
            copySourceIfModifiedSince(model.copySourceIfModifiedSince);
            copySourceIfNoneMatch(model.copySourceIfNoneMatch);
            copySourceIfUnmodifiedSince(model.copySourceIfUnmodifiedSince);
            expires(model.expires);
            grantFullControl(model.grantFullControl);
            grantRead(model.grantRead);
            grantReadACP(model.grantReadACP);
            grantWriteACP(model.grantWriteACP);
            metadata(model.metadata);
            metadataDirective(model.metadataDirective);
            taggingDirective(model.taggingDirective);
            serverSideEncryption(model.serverSideEncryption);
            storageClass(model.storageClass);
            websiteRedirectLocation(model.websiteRedirectLocation);
            sseCustomerAlgorithm(model.sseCustomerAlgorithm);
            sseCustomerKey(model.sseCustomerKey);
            sseCustomerKeyMD5(model.sseCustomerKeyMD5);
            ssekmsKeyId(model.ssekmsKeyId);
            ssekmsEncryptionContext(model.ssekmsEncryptionContext);
            bucketKeyEnabled(model.bucketKeyEnabled);
            copySourceSSECustomerAlgorithm(model.copySourceSSECustomerAlgorithm);
            copySourceSSECustomerKey(model.copySourceSSECustomerKey);
            copySourceSSECustomerKeyMD5(model.copySourceSSECustomerKeyMD5);
            requestPayer(model.requestPayer);
            tagging(model.tagging);
            objectLockMode(model.objectLockMode);
            objectLockRetainUntilDate(model.objectLockRetainUntilDate);
            objectLockLegalHoldStatus(model.objectLockLegalHoldStatus);
            expectedBucketOwner(model.expectedBucketOwner);
            expectedSourceBucketOwner(model.expectedSourceBucketOwner);
            destinationBucket(model.destinationBucket);
            destinationKey(model.destinationKey);
            sourceBucket(model.sourceBucket);
            sourceKey(model.sourceKey);
            sourceVersionId(model.sourceVersionId);
            retentionDirective(model.retentionDirective);
            retentionExpirationDate(model.retentionExpirationDate);
            retentionLegalHoldId(model.retentionLegalHoldId);
            retentionPeriod(model.retentionPeriod);
        }

        public final String getAcl() {
            return acl;
        }

        public final void setAcl(String acl) {
            this.acl = acl;
        }

        @Override
        public final Builder acl(String acl) {
            this.acl = acl;
            return this;
        }

        @Override
        public final Builder acl(ObjectCannedACL acl) {
            this.acl(acl == null ? null : acl.toString());
            return this;
        }

        public final String getCacheControl() {
            return cacheControl;
        }

        public final void setCacheControl(String cacheControl) {
            this.cacheControl = cacheControl;
        }

        @Override
        public final Builder cacheControl(String cacheControl) {
            this.cacheControl = cacheControl;
            return this;
        }

        public final String getChecksumAlgorithm() {
            return checksumAlgorithm;
        }

        public final void setChecksumAlgorithm(String checksumAlgorithm) {
            this.checksumAlgorithm = checksumAlgorithm;
        }

        @Override
        public final Builder checksumAlgorithm(String checksumAlgorithm) {
            this.checksumAlgorithm = checksumAlgorithm;
            return this;
        }

        @Override
        public final Builder checksumAlgorithm(ChecksumAlgorithm checksumAlgorithm) {
            this.checksumAlgorithm(checksumAlgorithm == null ? null : checksumAlgorithm.toString());
            return this;
        }

        public final String getContentDisposition() {
            return contentDisposition;
        }

        public final void setContentDisposition(String contentDisposition) {
            this.contentDisposition = contentDisposition;
        }

        @Override
        public final Builder contentDisposition(String contentDisposition) {
            this.contentDisposition = contentDisposition;
            return this;
        }

        public final String getContentEncoding() {
            return contentEncoding;
        }

        public final void setContentEncoding(String contentEncoding) {
            this.contentEncoding = contentEncoding;
        }

        @Override
        public final Builder contentEncoding(String contentEncoding) {
            this.contentEncoding = contentEncoding;
            return this;
        }

        public final String getContentLanguage() {
            return contentLanguage;
        }

        public final void setContentLanguage(String contentLanguage) {
            this.contentLanguage = contentLanguage;
        }

        @Override
        public final Builder contentLanguage(String contentLanguage) {
            this.contentLanguage = contentLanguage;
            return this;
        }

        public final String getContentType() {
            return contentType;
        }

        public final void setContentType(String contentType) {
            this.contentType = contentType;
        }

        @Override
        public final Builder contentType(String contentType) {
            this.contentType = contentType;
            return this;
        }

        @Deprecated
        public final String getCopySource() {
            return copySource;
        }

        @Deprecated
        public final void setCopySource(String copySource) {
            this.copySource = copySource;
        }

        @Override
        @Deprecated
        public final Builder copySource(String copySource) {
            this.copySource = copySource;
            return this;
        }

        public final String getCopySourceIfMatch() {
            return copySourceIfMatch;
        }

        public final void setCopySourceIfMatch(String copySourceIfMatch) {
            this.copySourceIfMatch = copySourceIfMatch;
        }

        @Override
        public final Builder copySourceIfMatch(String copySourceIfMatch) {
            this.copySourceIfMatch = copySourceIfMatch;
            return this;
        }

        public final Instant getCopySourceIfModifiedSince() {
            return copySourceIfModifiedSince;
        }

        public final void setCopySourceIfModifiedSince(Instant copySourceIfModifiedSince) {
            this.copySourceIfModifiedSince = copySourceIfModifiedSince;
        }

        @Override
        public final Builder copySourceIfModifiedSince(Instant copySourceIfModifiedSince) {
            this.copySourceIfModifiedSince = copySourceIfModifiedSince;
            return this;
        }

        public final String getCopySourceIfNoneMatch() {
            return copySourceIfNoneMatch;
        }

        public final void setCopySourceIfNoneMatch(String copySourceIfNoneMatch) {
            this.copySourceIfNoneMatch = copySourceIfNoneMatch;
        }

        @Override
        public final Builder copySourceIfNoneMatch(String copySourceIfNoneMatch) {
            this.copySourceIfNoneMatch = copySourceIfNoneMatch;
            return this;
        }

        public final Instant getCopySourceIfUnmodifiedSince() {
            return copySourceIfUnmodifiedSince;
        }

        public final void setCopySourceIfUnmodifiedSince(Instant copySourceIfUnmodifiedSince) {
            this.copySourceIfUnmodifiedSince = copySourceIfUnmodifiedSince;
        }

        @Override
        public final Builder copySourceIfUnmodifiedSince(Instant copySourceIfUnmodifiedSince) {
            this.copySourceIfUnmodifiedSince = copySourceIfUnmodifiedSince;
            return this;
        }

        public final Instant getExpires() {
            return expires;
        }

        public final void setExpires(Instant expires) {
            this.expires = expires;
        }

        @Override
        public final Builder expires(Instant expires) {
            this.expires = expires;
            return this;
        }

        public final String getGrantFullControl() {
            return grantFullControl;
        }

        public final void setGrantFullControl(String grantFullControl) {
            this.grantFullControl = grantFullControl;
        }

        @Override
        public final Builder grantFullControl(String grantFullControl) {
            this.grantFullControl = grantFullControl;
            return this;
        }

        public final String getGrantRead() {
            return grantRead;
        }

        public final void setGrantRead(String grantRead) {
            this.grantRead = grantRead;
        }

        @Override
        public final Builder grantRead(String grantRead) {
            this.grantRead = grantRead;
            return this;
        }

        public final String getGrantReadACP() {
            return grantReadACP;
        }

        public final void setGrantReadACP(String grantReadACP) {
            this.grantReadACP = grantReadACP;
        }

        @Override
        public final Builder grantReadACP(String grantReadACP) {
            this.grantReadACP = grantReadACP;
            return this;
        }

        public final String getGrantWriteACP() {
            return grantWriteACP;
        }

        public final void setGrantWriteACP(String grantWriteACP) {
            this.grantWriteACP = grantWriteACP;
        }

        @Override
        public final Builder grantWriteACP(String grantWriteACP) {
            this.grantWriteACP = grantWriteACP;
            return this;
        }

        public final Map<String, String> getMetadata() {
            if (metadata instanceof SdkAutoConstructMap) {
                return null;
            }
            return metadata;
        }

        public final void setMetadata(Map<String, String> metadata) {
            this.metadata = MetadataCopier.copy(metadata);
        }

        @Override
        public final Builder metadata(Map<String, String> metadata) {
            this.metadata = MetadataCopier.copy(metadata);
            return this;
        }

        public final String getMetadataDirective() {
            return metadataDirective;
        }

        public final void setMetadataDirective(String metadataDirective) {
            this.metadataDirective = metadataDirective;
        }

        @Override
        public final Builder metadataDirective(String metadataDirective) {
            this.metadataDirective = metadataDirective;
            return this;
        }

        @Override
        public final Builder metadataDirective(MetadataDirective metadataDirective) {
            this.metadataDirective(metadataDirective == null ? null : metadataDirective.toString());
            return this;
        }

        public final String getTaggingDirective() {
            return taggingDirective;
        }

        public final void setTaggingDirective(String taggingDirective) {
            this.taggingDirective = taggingDirective;
        }

        @Override
        public final Builder taggingDirective(String taggingDirective) {
            this.taggingDirective = taggingDirective;
            return this;
        }

        @Override
        public final Builder taggingDirective(TaggingDirective taggingDirective) {
            this.taggingDirective(taggingDirective == null ? null : taggingDirective.toString());
            return this;
        }

        public final String getServerSideEncryption() {
            return serverSideEncryption;
        }

        public final void setServerSideEncryption(String serverSideEncryption) {
            this.serverSideEncryption = serverSideEncryption;
        }

        @Override
        public final Builder serverSideEncryption(String serverSideEncryption) {
            this.serverSideEncryption = serverSideEncryption;
            return this;
        }

        @Override
        public final Builder serverSideEncryption(ServerSideEncryption serverSideEncryption) {
            this.serverSideEncryption(serverSideEncryption == null ? null : serverSideEncryption.toString());
            return this;
        }

        public final String getStorageClass() {
            return storageClass;
        }

        public final void setStorageClass(String storageClass) {
            this.storageClass = storageClass;
        }

        @Override
        public final Builder storageClass(String storageClass) {
            this.storageClass = storageClass;
            return this;
        }

        @Override
        public final Builder storageClass(StorageClass storageClass) {
            this.storageClass(storageClass == null ? null : storageClass.toString());
            return this;
        }

        public final String getWebsiteRedirectLocation() {
            return websiteRedirectLocation;
        }

        public final void setWebsiteRedirectLocation(String websiteRedirectLocation) {
            this.websiteRedirectLocation = websiteRedirectLocation;
        }

        @Override
        public final Builder websiteRedirectLocation(String websiteRedirectLocation) {
            this.websiteRedirectLocation = websiteRedirectLocation;
            return this;
        }

        public final String getSseCustomerAlgorithm() {
            return sseCustomerAlgorithm;
        }

        public final void setSseCustomerAlgorithm(String sseCustomerAlgorithm) {
            this.sseCustomerAlgorithm = sseCustomerAlgorithm;
        }

        @Override
        public final Builder sseCustomerAlgorithm(String sseCustomerAlgorithm) {
            this.sseCustomerAlgorithm = sseCustomerAlgorithm;
            return this;
        }

        public final String getSseCustomerKey() {
            return sseCustomerKey;
        }

        public final void setSseCustomerKey(String sseCustomerKey) {
            this.sseCustomerKey = sseCustomerKey;
        }

        @Override
        public final Builder sseCustomerKey(String sseCustomerKey) {
            this.sseCustomerKey = sseCustomerKey;
            return this;
        }

        public final String getSseCustomerKeyMD5() {
            return sseCustomerKeyMD5;
        }

        public final void setSseCustomerKeyMD5(String sseCustomerKeyMD5) {
            this.sseCustomerKeyMD5 = sseCustomerKeyMD5;
        }

        @Override
        public final Builder sseCustomerKeyMD5(String sseCustomerKeyMD5) {
            this.sseCustomerKeyMD5 = sseCustomerKeyMD5;
            return this;
        }

        public final String getSsekmsKeyId() {
            return ssekmsKeyId;
        }

        public final void setSsekmsKeyId(String ssekmsKeyId) {
            this.ssekmsKeyId = ssekmsKeyId;
        }

        @Override
        public final Builder ssekmsKeyId(String ssekmsKeyId) {
            this.ssekmsKeyId = ssekmsKeyId;
            return this;
        }

        public final String getSsekmsEncryptionContext() {
            return ssekmsEncryptionContext;
        }

        public final void setSsekmsEncryptionContext(String ssekmsEncryptionContext) {
            this.ssekmsEncryptionContext = ssekmsEncryptionContext;
        }

        @Override
        public final Builder ssekmsEncryptionContext(String ssekmsEncryptionContext) {
            this.ssekmsEncryptionContext = ssekmsEncryptionContext;
            return this;
        }

        public final Boolean getBucketKeyEnabled() {
            return bucketKeyEnabled;
        }

        public final void setBucketKeyEnabled(Boolean bucketKeyEnabled) {
            this.bucketKeyEnabled = bucketKeyEnabled;
        }

        @Override
        public final Builder bucketKeyEnabled(Boolean bucketKeyEnabled) {
            this.bucketKeyEnabled = bucketKeyEnabled;
            return this;
        }

        public final String getCopySourceSSECustomerAlgorithm() {
            return copySourceSSECustomerAlgorithm;
        }

        public final void setCopySourceSSECustomerAlgorithm(String copySourceSSECustomerAlgorithm) {
            this.copySourceSSECustomerAlgorithm = copySourceSSECustomerAlgorithm;
        }

        @Override
        public final Builder copySourceSSECustomerAlgorithm(String copySourceSSECustomerAlgorithm) {
            this.copySourceSSECustomerAlgorithm = copySourceSSECustomerAlgorithm;
            return this;
        }

        public final String getCopySourceSSECustomerKey() {
            return copySourceSSECustomerKey;
        }

        public final void setCopySourceSSECustomerKey(String copySourceSSECustomerKey) {
            this.copySourceSSECustomerKey = copySourceSSECustomerKey;
        }

        @Override
        public final Builder copySourceSSECustomerKey(String copySourceSSECustomerKey) {
            this.copySourceSSECustomerKey = copySourceSSECustomerKey;
            return this;
        }

        public final String getCopySourceSSECustomerKeyMD5() {
            return copySourceSSECustomerKeyMD5;
        }

        public final void setCopySourceSSECustomerKeyMD5(String copySourceSSECustomerKeyMD5) {
            this.copySourceSSECustomerKeyMD5 = copySourceSSECustomerKeyMD5;
        }

        @Override
        public final Builder copySourceSSECustomerKeyMD5(String copySourceSSECustomerKeyMD5) {
            this.copySourceSSECustomerKeyMD5 = copySourceSSECustomerKeyMD5;
            return this;
        }

        public final String getRequestPayer() {
            return requestPayer;
        }

        public final void setRequestPayer(String requestPayer) {
            this.requestPayer = requestPayer;
        }

        @Override
        public final Builder requestPayer(String requestPayer) {
            this.requestPayer = requestPayer;
            return this;
        }

        @Override
        public final Builder requestPayer(RequestPayer requestPayer) {
            this.requestPayer(requestPayer == null ? null : requestPayer.toString());
            return this;
        }

        public final String getTagging() {
            return tagging;
        }

        public final void setTagging(String tagging) {
            this.tagging = tagging;
        }

        @Override
        public final Builder tagging(String tagging) {
            this.tagging = tagging;
            return this;
        }

        public Builder tagging(Tagging tagging) {
            tagging(TaggingAdapter.instance().adapt(tagging));
            return this;
        }

        public final String getObjectLockMode() {
            return objectLockMode;
        }

        public final void setObjectLockMode(String objectLockMode) {
            this.objectLockMode = objectLockMode;
        }

        @Override
        public final Builder objectLockMode(String objectLockMode) {
            this.objectLockMode = objectLockMode;
            return this;
        }

        @Override
        public final Builder objectLockMode(ObjectLockMode objectLockMode) {
            this.objectLockMode(objectLockMode == null ? null : objectLockMode.toString());
            return this;
        }

        public final Instant getObjectLockRetainUntilDate() {
            return objectLockRetainUntilDate;
        }

        public final void setObjectLockRetainUntilDate(Instant objectLockRetainUntilDate) {
            this.objectLockRetainUntilDate = objectLockRetainUntilDate;
        }

        @Override
        public final Builder objectLockRetainUntilDate(Instant objectLockRetainUntilDate) {
            this.objectLockRetainUntilDate = objectLockRetainUntilDate;
            return this;
        }

        public final String getObjectLockLegalHoldStatus() {
            return objectLockLegalHoldStatus;
        }

        public final void setObjectLockLegalHoldStatus(String objectLockLegalHoldStatus) {
            this.objectLockLegalHoldStatus = objectLockLegalHoldStatus;
        }

        @Override
        public final Builder objectLockLegalHoldStatus(String objectLockLegalHoldStatus) {
            this.objectLockLegalHoldStatus = objectLockLegalHoldStatus;
            return this;
        }

        @Override
        public final Builder objectLockLegalHoldStatus(ObjectLockLegalHoldStatus objectLockLegalHoldStatus) {
            this.objectLockLegalHoldStatus(objectLockLegalHoldStatus == null ? null : objectLockLegalHoldStatus.toString());
            return this;
        }

        public final String getExpectedBucketOwner() {
            return expectedBucketOwner;
        }

        public final void setExpectedBucketOwner(String expectedBucketOwner) {
            this.expectedBucketOwner = expectedBucketOwner;
        }

        @Override
        public final Builder expectedBucketOwner(String expectedBucketOwner) {
            this.expectedBucketOwner = expectedBucketOwner;
            return this;
        }

        public final String getExpectedSourceBucketOwner() {
            return expectedSourceBucketOwner;
        }

        public final void setExpectedSourceBucketOwner(String expectedSourceBucketOwner) {
            this.expectedSourceBucketOwner = expectedSourceBucketOwner;
        }

        @Override
        public final Builder expectedSourceBucketOwner(String expectedSourceBucketOwner) {
            this.expectedSourceBucketOwner = expectedSourceBucketOwner;
            return this;
        }

        public final String getDestinationBucket() {
            return destinationBucket;
        }

        public final void setDestinationBucket(String destinationBucket) {
            this.destinationBucket = destinationBucket;
        }

        /**
         * @deprecated Use {@link #setDestinationBucket} instead
         */
        @Deprecated
        public final void setBucket(String destinationBucket) {
            this.destinationBucket = destinationBucket;
        }

        @Override
        public final Builder destinationBucket(String destinationBucket) {
            this.destinationBucket = destinationBucket;
            return this;
        }

        @Override
        public final Builder bucket(String destinationBucket) {
            this.destinationBucket = destinationBucket;
            return this;
        }

        public final String getDestinationKey() {
            return destinationKey;
        }

        public final void setDestinationKey(String destinationKey) {
            this.destinationKey = destinationKey;
        }

        /**
         * @deprecated Use {@link #setDestinationKey} instead
         */
        @Deprecated
        public final void setKey(String destinationKey) {
            this.destinationKey = destinationKey;
        }

        @Override
        public final Builder destinationKey(String destinationKey) {
            this.destinationKey = destinationKey;
            return this;
        }

        @Override
        public final Builder key(String destinationKey) {
            this.destinationKey = destinationKey;
            return this;
        }

        public final String getSourceBucket() {
            return sourceBucket;
        }

        public final void setSourceBucket(String sourceBucket) {
            this.sourceBucket = sourceBucket;
        }

        @Override
        public final Builder sourceBucket(String sourceBucket) {
            this.sourceBucket = sourceBucket;
            return this;
        }

        public final String getSourceKey() {
            return sourceKey;
        }

        public final void setSourceKey(String sourceKey) {
            this.sourceKey = sourceKey;
        }

        @Override
        public final Builder sourceKey(String sourceKey) {
            this.sourceKey = sourceKey;
            return this;
        }

        public final String getSourceVersionId() {
            return sourceVersionId;
        }

        public final void setSourceVersionId(String sourceVersionId) {
            this.sourceVersionId = sourceVersionId;
        }

        @Override
        public final Builder sourceVersionId(String sourceVersionId) {
            this.sourceVersionId = sourceVersionId;
            return this;
        }

        @Override
        public Builder overrideConfiguration(AwsRequestOverrideConfiguration overrideConfiguration) {
            super.overrideConfiguration(overrideConfiguration);
            return this;
        }

        @Override
        public Builder overrideConfiguration(Consumer<AwsRequestOverrideConfiguration.Builder> builderConsumer) {
            super.overrideConfiguration(builderConsumer);
            return this;
        }

        /**************** IBM Supported *************************/
        public final RetentionDirective getRetentionDirective() {
            return retentionDirective;
        }

        public final void setRetentionDirective(RetentionDirective retentionDirective) {
            this.retentionDirective = retentionDirective;
        }

        @Override
        public final Builder retentionDirective(RetentionDirective retentionDirective) {
            this.retentionDirective = retentionDirective;
            return this;
        }

        public final Instant getRetentionExpirationDate() {
            return retentionExpirationDate;
        }

        public final void setRetentionExpirationDate(Instant retentionExpirationDate) {
            this.retentionExpirationDate = retentionExpirationDate;
        }

        @Override
        public Builder retentionExpirationDate(Instant retentionExpirationDate) {
            this.retentionExpirationDate = retentionExpirationDate;
            return this;
        }

        public final String getRetentionLegalHoldId() {
            return retentionLegalHoldId;
        }

        public final void setRetentionLegalHoldId(String retentionLegalHoldId) {
            this.retentionLegalHoldId = retentionLegalHoldId;
        }

        @Override
        public Builder retentionLegalHoldId(String retentionLegalHoldId) {
            this.retentionLegalHoldId = retentionLegalHoldId;
            return this;
        }

        public final Long getRetentionPeriod() {
            return retentionPeriod;
        }

        public final void setRetentionPeriod(Long retentionPeriod) {
            this.retentionPeriod = retentionPeriod;
        }

        @Override
        public Builder retentionPeriod(Long retentionPeriod) {
            this.retentionPeriod = retentionPeriod;
            return this;
        }

        @Override
        public CopyObjectRequest build() {
            return new CopyObjectRequest(this);
        }

        @Override
        public List<SdkField<?>> sdkFields() {
            return SDK_FIELDS;
        }

        @Override
        public Map<String, SdkField<?>> sdkFieldNameToField() {
            return SDK_NAME_TO_FIELD;
        }
    }
}
