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
public final class PutObjectRequest extends S3Request implements ToCopyableBuilder<PutObjectRequest.Builder, PutObjectRequest> {
    private static final SdkField<String> ACL_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("ACL")
            .getter(getter(PutObjectRequest::aclAsString))
            .setter(setter(Builder::acl))
            .traits(LocationTrait.builder().location(MarshallLocation.HEADER).locationName("x-amz-acl")
                    .unmarshallLocationName("x-amz-acl").build()).build();

    private static final SdkField<String> BUCKET_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("Bucket")
            .getter(getter(PutObjectRequest::bucket))
            .setter(setter(Builder::bucket))
            .traits(LocationTrait.builder().location(MarshallLocation.PATH).locationName("Bucket")
                    .unmarshallLocationName("Bucket").build(), RequiredTrait.create()).build();

    private static final SdkField<String> CACHE_CONTROL_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("CacheControl")
            .getter(getter(PutObjectRequest::cacheControl))
            .setter(setter(Builder::cacheControl))
            .traits(LocationTrait.builder().location(MarshallLocation.HEADER).locationName("Cache-Control")
                    .unmarshallLocationName("Cache-Control").build()).build();

    private static final SdkField<String> CONTENT_DISPOSITION_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("ContentDisposition")
            .getter(getter(PutObjectRequest::contentDisposition))
            .setter(setter(Builder::contentDisposition))
            .traits(LocationTrait.builder().location(MarshallLocation.HEADER).locationName("Content-Disposition")
                    .unmarshallLocationName("Content-Disposition").build()).build();

    private static final SdkField<String> CONTENT_ENCODING_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("ContentEncoding")
            .getter(getter(PutObjectRequest::contentEncoding))
            .setter(setter(Builder::contentEncoding))
            .traits(LocationTrait.builder().location(MarshallLocation.HEADER).locationName("Content-Encoding")
                    .unmarshallLocationName("Content-Encoding").build()).build();

    private static final SdkField<String> CONTENT_LANGUAGE_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("ContentLanguage")
            .getter(getter(PutObjectRequest::contentLanguage))
            .setter(setter(Builder::contentLanguage))
            .traits(LocationTrait.builder().location(MarshallLocation.HEADER).locationName("Content-Language")
                    .unmarshallLocationName("Content-Language").build()).build();

    private static final SdkField<Long> CONTENT_LENGTH_FIELD = SdkField
            .<Long> builder(MarshallingType.LONG)
            .memberName("ContentLength")
            .getter(getter(PutObjectRequest::contentLength))
            .setter(setter(Builder::contentLength))
            .traits(LocationTrait.builder().location(MarshallLocation.HEADER).locationName("Content-Length")
                    .unmarshallLocationName("Content-Length").build()).build();

    private static final SdkField<String> CONTENT_MD5_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("ContentMD5")
            .getter(getter(PutObjectRequest::contentMD5))
            .setter(setter(Builder::contentMD5))
            .traits(LocationTrait.builder().location(MarshallLocation.HEADER).locationName("Content-MD5")
                    .unmarshallLocationName("Content-MD5").build()).build();

    private static final SdkField<String> CONTENT_TYPE_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("ContentType")
            .getter(getter(PutObjectRequest::contentType))
            .setter(setter(Builder::contentType))
            .traits(LocationTrait.builder().location(MarshallLocation.HEADER).locationName("Content-Type")
                    .unmarshallLocationName("Content-Type").build()).build();

    private static final SdkField<String> CHECKSUM_ALGORITHM_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("ChecksumAlgorithm")
            .getter(getter(PutObjectRequest::checksumAlgorithmAsString))
            .setter(setter(Builder::checksumAlgorithm))
            .traits(LocationTrait.builder().location(MarshallLocation.HEADER).locationName("x-amz-sdk-checksum-algorithm")
                    .unmarshallLocationName("x-amz-sdk-checksum-algorithm").build()).build();

    private static final SdkField<String> CHECKSUM_CRC32_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("ChecksumCRC32")
            .getter(getter(PutObjectRequest::checksumCRC32))
            .setter(setter(Builder::checksumCRC32))
            .traits(LocationTrait.builder().location(MarshallLocation.HEADER).locationName("x-amz-checksum-crc32")
                    .unmarshallLocationName("x-amz-checksum-crc32").build()).build();

    private static final SdkField<String> CHECKSUM_CRC32_C_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("ChecksumCRC32C")
            .getter(getter(PutObjectRequest::checksumCRC32C))
            .setter(setter(Builder::checksumCRC32C))
            .traits(LocationTrait.builder().location(MarshallLocation.HEADER).locationName("x-amz-checksum-crc32c")
                    .unmarshallLocationName("x-amz-checksum-crc32c").build()).build();

    private static final SdkField<String> CHECKSUM_CRC64_NVME_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("ChecksumCRC64NVME")
            .getter(getter(PutObjectRequest::checksumCRC64NVME))
            .setter(setter(Builder::checksumCRC64NVME))
            .traits(LocationTrait.builder().location(MarshallLocation.HEADER).locationName("x-amz-checksum-crc64nvme")
                    .unmarshallLocationName("x-amz-checksum-crc64nvme").build()).build();

    private static final SdkField<String> CHECKSUM_SHA1_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("ChecksumSHA1")
            .getter(getter(PutObjectRequest::checksumSHA1))
            .setter(setter(Builder::checksumSHA1))
            .traits(LocationTrait.builder().location(MarshallLocation.HEADER).locationName("x-amz-checksum-sha1")
                    .unmarshallLocationName("x-amz-checksum-sha1").build()).build();

    private static final SdkField<String> CHECKSUM_SHA256_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("ChecksumSHA256")
            .getter(getter(PutObjectRequest::checksumSHA256))
            .setter(setter(Builder::checksumSHA256))
            .traits(LocationTrait.builder().location(MarshallLocation.HEADER).locationName("x-amz-checksum-sha256")
                    .unmarshallLocationName("x-amz-checksum-sha256").build()).build();

    private static final SdkField<Instant> EXPIRES_FIELD = SdkField
            .<Instant> builder(MarshallingType.INSTANT)
            .memberName("Expires")
            .getter(getter(PutObjectRequest::expires))
            .setter(setter(Builder::expires))
            .traits(LocationTrait.builder().location(MarshallLocation.HEADER).locationName("Expires")
                    .unmarshallLocationName("Expires").build()).build();

    private static final SdkField<String> IF_MATCH_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("IfMatch")
            .getter(getter(PutObjectRequest::ifMatch))
            .setter(setter(Builder::ifMatch))
            .traits(LocationTrait.builder().location(MarshallLocation.HEADER).locationName("If-Match")
                    .unmarshallLocationName("If-Match").build()).build();

    private static final SdkField<String> IF_NONE_MATCH_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("IfNoneMatch")
            .getter(getter(PutObjectRequest::ifNoneMatch))
            .setter(setter(Builder::ifNoneMatch))
            .traits(LocationTrait.builder().location(MarshallLocation.HEADER).locationName("If-None-Match")
                    .unmarshallLocationName("If-None-Match").build()).build();

    private static final SdkField<String> GRANT_FULL_CONTROL_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("GrantFullControl")
            .getter(getter(PutObjectRequest::grantFullControl))
            .setter(setter(Builder::grantFullControl))
            .traits(LocationTrait.builder().location(MarshallLocation.HEADER).locationName("x-amz-grant-full-control")
                    .unmarshallLocationName("x-amz-grant-full-control").build()).build();

    private static final SdkField<String> GRANT_READ_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("GrantRead")
            .getter(getter(PutObjectRequest::grantRead))
            .setter(setter(Builder::grantRead))
            .traits(LocationTrait.builder().location(MarshallLocation.HEADER).locationName("x-amz-grant-read")
                    .unmarshallLocationName("x-amz-grant-read").build()).build();

    private static final SdkField<String> GRANT_READ_ACP_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("GrantReadACP")
            .getter(getter(PutObjectRequest::grantReadACP))
            .setter(setter(Builder::grantReadACP))
            .traits(LocationTrait.builder().location(MarshallLocation.HEADER).locationName("x-amz-grant-read-acp")
                    .unmarshallLocationName("x-amz-grant-read-acp").build()).build();

    private static final SdkField<String> GRANT_WRITE_ACP_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("GrantWriteACP")
            .getter(getter(PutObjectRequest::grantWriteACP))
            .setter(setter(Builder::grantWriteACP))
            .traits(LocationTrait.builder().location(MarshallLocation.HEADER).locationName("x-amz-grant-write-acp")
                    .unmarshallLocationName("x-amz-grant-write-acp").build()).build();

    private static final SdkField<String> KEY_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("Key")
            .getter(getter(PutObjectRequest::key))
            .setter(setter(Builder::key))
            .traits(LocationTrait.builder().location(MarshallLocation.GREEDY_PATH).locationName("Key")
                    .unmarshallLocationName("Key").build(), RequiredTrait.create()).build();

    private static final SdkField<Long> WRITE_OFFSET_BYTES_FIELD = SdkField
            .<Long> builder(MarshallingType.LONG)
            .memberName("WriteOffsetBytes")
            .getter(getter(PutObjectRequest::writeOffsetBytes))
            .setter(setter(Builder::writeOffsetBytes))
            .traits(LocationTrait.builder().location(MarshallLocation.HEADER).locationName("x-amz-write-offset-bytes")
                    .unmarshallLocationName("x-amz-write-offset-bytes").build()).build();

    private static final SdkField<Map<String, String>> METADATA_FIELD = SdkField
            .<Map<String, String>> builder(MarshallingType.MAP)
            .memberName("Metadata")
            .getter(getter(PutObjectRequest::metadata))
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

    private static final SdkField<String> SERVER_SIDE_ENCRYPTION_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("ServerSideEncryption")
            .getter(getter(PutObjectRequest::serverSideEncryptionAsString))
            .setter(setter(Builder::serverSideEncryption))
            .traits(LocationTrait.builder().location(MarshallLocation.HEADER).locationName("x-amz-server-side-encryption")
                    .unmarshallLocationName("x-amz-server-side-encryption").build()).build();

    private static final SdkField<String> STORAGE_CLASS_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("StorageClass")
            .getter(getter(PutObjectRequest::storageClassAsString))
            .setter(setter(Builder::storageClass))
            .traits(LocationTrait.builder().location(MarshallLocation.HEADER).locationName("x-amz-storage-class")
                    .unmarshallLocationName("x-amz-storage-class").build()).build();

    private static final SdkField<String> WEBSITE_REDIRECT_LOCATION_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("WebsiteRedirectLocation")
            .getter(getter(PutObjectRequest::websiteRedirectLocation))
            .setter(setter(Builder::websiteRedirectLocation))
            .traits(LocationTrait.builder().location(MarshallLocation.HEADER).locationName("x-amz-website-redirect-location")
                    .unmarshallLocationName("x-amz-website-redirect-location").build()).build();

    private static final SdkField<String> SSE_CUSTOMER_ALGORITHM_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("SSECustomerAlgorithm")
            .getter(getter(PutObjectRequest::sseCustomerAlgorithm))
            .setter(setter(Builder::sseCustomerAlgorithm))
            .traits(LocationTrait.builder().location(MarshallLocation.HEADER)
                    .locationName("x-amz-server-side-encryption-customer-algorithm")
                    .unmarshallLocationName("x-amz-server-side-encryption-customer-algorithm").build()).build();

    private static final SdkField<String> SSE_CUSTOMER_KEY_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("SSECustomerKey")
            .getter(getter(PutObjectRequest::sseCustomerKey))
            .setter(setter(Builder::sseCustomerKey))
            .traits(LocationTrait.builder().location(MarshallLocation.HEADER)
                    .locationName("x-amz-server-side-encryption-customer-key")
                    .unmarshallLocationName("x-amz-server-side-encryption-customer-key").build()).build();

    private static final SdkField<String> SSE_CUSTOMER_KEY_MD5_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("SSECustomerKeyMD5")
            .getter(getter(PutObjectRequest::sseCustomerKeyMD5))
            .setter(setter(Builder::sseCustomerKeyMD5))
            .traits(LocationTrait.builder().location(MarshallLocation.HEADER)
                    .locationName("x-amz-server-side-encryption-customer-key-MD5")
                    .unmarshallLocationName("x-amz-server-side-encryption-customer-key-MD5").build()).build();

    private static final SdkField<String> SSEKMS_KEY_ID_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("SSEKMSKeyId")
            .getter(getter(PutObjectRequest::ssekmsKeyId))
            .setter(setter(Builder::ssekmsKeyId))
            .traits(LocationTrait.builder().location(MarshallLocation.HEADER)
                    .locationName("x-amz-server-side-encryption-aws-kms-key-id")
                    .unmarshallLocationName("x-amz-server-side-encryption-aws-kms-key-id").build()).build();

    private static final SdkField<String> SSEKMS_ENCRYPTION_CONTEXT_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("SSEKMSEncryptionContext")
            .getter(getter(PutObjectRequest::ssekmsEncryptionContext))
            .setter(setter(Builder::ssekmsEncryptionContext))
            .traits(LocationTrait.builder().location(MarshallLocation.HEADER)
                    .locationName("x-amz-server-side-encryption-context")
                    .unmarshallLocationName("x-amz-server-side-encryption-context").build()).build();

    private static final SdkField<Boolean> BUCKET_KEY_ENABLED_FIELD = SdkField
            .<Boolean> builder(MarshallingType.BOOLEAN)
            .memberName("BucketKeyEnabled")
            .getter(getter(PutObjectRequest::bucketKeyEnabled))
            .setter(setter(Builder::bucketKeyEnabled))
            .traits(LocationTrait.builder().location(MarshallLocation.HEADER)
                    .locationName("x-amz-server-side-encryption-bucket-key-enabled")
                    .unmarshallLocationName("x-amz-server-side-encryption-bucket-key-enabled").build()).build();

    private static final SdkField<String> REQUEST_PAYER_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("RequestPayer")
            .getter(getter(PutObjectRequest::requestPayerAsString))
            .setter(setter(Builder::requestPayer))
            .traits(LocationTrait.builder().location(MarshallLocation.HEADER).locationName("x-amz-request-payer")
                    .unmarshallLocationName("x-amz-request-payer").build()).build();

    private static final SdkField<String> TAGGING_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("Tagging")
            .getter(getter(PutObjectRequest::tagging))
            .setter(setter(Builder::tagging))
            .traits(LocationTrait.builder().location(MarshallLocation.HEADER).locationName("x-amz-tagging")
                    .unmarshallLocationName("x-amz-tagging").build()).build();

    private static final SdkField<String> OBJECT_LOCK_MODE_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("ObjectLockMode")
            .getter(getter(PutObjectRequest::objectLockModeAsString))
            .setter(setter(Builder::objectLockMode))
            .traits(LocationTrait.builder().location(MarshallLocation.HEADER).locationName("x-amz-object-lock-mode")
                    .unmarshallLocationName("x-amz-object-lock-mode").build()).build();

    private static final SdkField<Instant> OBJECT_LOCK_RETAIN_UNTIL_DATE_FIELD = SdkField
            .<Instant> builder(MarshallingType.INSTANT)
            .memberName("ObjectLockRetainUntilDate")
            .getter(getter(PutObjectRequest::objectLockRetainUntilDate))
            .setter(setter(Builder::objectLockRetainUntilDate))
            .traits(LocationTrait.builder().location(MarshallLocation.HEADER).locationName("x-amz-object-lock-retain-until-date")
                    .unmarshallLocationName("x-amz-object-lock-retain-until-date").build(),
                    TimestampFormatTrait.create(TimestampFormatTrait.Format.ISO_8601)).build();

    private static final SdkField<String> OBJECT_LOCK_LEGAL_HOLD_STATUS_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("ObjectLockLegalHoldStatus")
            .getter(getter(PutObjectRequest::objectLockLegalHoldStatusAsString))
            .setter(setter(Builder::objectLockLegalHoldStatus))
            .traits(LocationTrait.builder().location(MarshallLocation.HEADER).locationName("x-amz-object-lock-legal-hold")
                    .unmarshallLocationName("x-amz-object-lock-legal-hold").build()).build();

    private static final SdkField<String> EXPECTED_BUCKET_OWNER_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("ExpectedBucketOwner")
            .getter(getter(PutObjectRequest::expectedBucketOwner))
            .setter(setter(Builder::expectedBucketOwner))
            .traits(LocationTrait.builder().location(MarshallLocation.HEADER).locationName("x-amz-expected-bucket-owner")
                    .unmarshallLocationName("x-amz-expected-bucket-owner").build()).build();

    /********************************************** IBM Supported ***************************************************************/
    /** IBM Retention Expiration Date header */
    private static final SdkField<Instant> IBM_RETENTION_EXPIRATION_DATE_FIELD = SdkField
        .<Instant> builder(MarshallingType.INSTANT)
        .memberName("RetentionExpirationDate")
        .getter(getter(PutObjectRequest::retentionExpirationDate))
        .setter(setter(PutObjectRequest.Builder::retentionExpirationDate))
        .traits(LocationTrait.builder().location(MarshallLocation.HEADER).locationName("retention-expiration-date")
                             .unmarshallLocationName("retention-expiration-date").build()).build();

    /** IBM Retention Legal Hold Count header */
    private static final SdkField<String> IBM_RETENTION_LEGAL_HOLD_ID_FIELD = SdkField
        .<String> builder(MarshallingType.STRING)
        .memberName("RetentionLegalHoldId")
        .getter(getter(PutObjectRequest::retentionLegalHoldId))
        .setter(setter(PutObjectRequest.Builder::retentionLegalHoldId))
        .traits(LocationTrait.builder().location(MarshallLocation.HEADER).locationName("retention-legal-hold-id")
                             .unmarshallLocationName("retention-legal-hold-id").build()).build();

    /** IBM Retention period header */
    private static final SdkField<Long> IBM_RETENTION_PERIOD_FIELD = SdkField
        .<Long> builder(MarshallingType.LONG)
        .memberName("RetentionPeriod")
        .getter(getter(PutObjectRequest::retentionPeriod))
        .setter(setter(PutObjectRequest.Builder::retentionPeriod))
        .traits(LocationTrait.builder().location(MarshallLocation.HEADER).locationName("retention-period")
                             .unmarshallLocationName("retention-period").build()).build();

    private static final List<SdkField<?>> SDK_FIELDS = Collections.unmodifiableList(Arrays.asList(ACL_FIELD, BUCKET_FIELD,
            CACHE_CONTROL_FIELD, CONTENT_DISPOSITION_FIELD, CONTENT_ENCODING_FIELD, CONTENT_LANGUAGE_FIELD, CONTENT_LENGTH_FIELD,
            CONTENT_MD5_FIELD, CONTENT_TYPE_FIELD, CHECKSUM_ALGORITHM_FIELD, CHECKSUM_CRC32_FIELD, CHECKSUM_CRC32_C_FIELD,
            CHECKSUM_CRC64_NVME_FIELD, CHECKSUM_SHA1_FIELD, CHECKSUM_SHA256_FIELD, EXPIRES_FIELD, IF_MATCH_FIELD,
            IF_NONE_MATCH_FIELD, GRANT_FULL_CONTROL_FIELD, GRANT_READ_FIELD, GRANT_READ_ACP_FIELD, GRANT_WRITE_ACP_FIELD,
            KEY_FIELD, WRITE_OFFSET_BYTES_FIELD, METADATA_FIELD, SERVER_SIDE_ENCRYPTION_FIELD, STORAGE_CLASS_FIELD,
            WEBSITE_REDIRECT_LOCATION_FIELD, SSE_CUSTOMER_ALGORITHM_FIELD, SSE_CUSTOMER_KEY_FIELD, SSE_CUSTOMER_KEY_MD5_FIELD,
            SSEKMS_KEY_ID_FIELD, SSEKMS_ENCRYPTION_CONTEXT_FIELD, BUCKET_KEY_ENABLED_FIELD, REQUEST_PAYER_FIELD, TAGGING_FIELD,
            OBJECT_LOCK_MODE_FIELD, OBJECT_LOCK_RETAIN_UNTIL_DATE_FIELD, OBJECT_LOCK_LEGAL_HOLD_STATUS_FIELD,
            EXPECTED_BUCKET_OWNER_FIELD,
            IBM_RETENTION_EXPIRATION_DATE_FIELD,IBM_RETENTION_LEGAL_HOLD_ID_FIELD,IBM_RETENTION_PERIOD_FIELD));

    private static final Map<String, SdkField<?>> SDK_NAME_TO_FIELD = memberNameToFieldInitializer();

    private final String acl;

    private final String bucket;

    private final String cacheControl;

    private final String contentDisposition;

    private final String contentEncoding;

    private final String contentLanguage;

    private final Long contentLength;

    private final String contentMD5;

    private final String contentType;

    private final String checksumAlgorithm;

    private final String checksumCRC32;

    private final String checksumCRC32C;

    private final String checksumCRC64NVME;

    private final String checksumSHA1;

    private final String checksumSHA256;

    private final Instant expires;

    private final String ifMatch;

    private final String ifNoneMatch;

    private final String grantFullControl;

    private final String grantRead;

    private final String grantReadACP;

    private final String grantWriteACP;

    private final String key;

    private final Long writeOffsetBytes;

    private final Map<String, String> metadata;

    private final String serverSideEncryption;

    private final String storageClass;

    private final String websiteRedirectLocation;

    private final String sseCustomerAlgorithm;

    private final String sseCustomerKey;

    private final String sseCustomerKeyMD5;

    private final String ssekmsKeyId;

    private final String ssekmsEncryptionContext;

    private final Boolean bucketKeyEnabled;

    private final String requestPayer;

    private final String tagging;

    private final String objectLockMode;

    private final Instant objectLockRetainUntilDate;

    private final String objectLockLegalHoldStatus;

    private final String expectedBucketOwner;

    private Instant retentionExpirationDate;

    private String retentionLegalHoldId;

    private Long retentionPeriod;

    private PutObjectRequest(BuilderImpl builder) {
        super(builder);
        this.acl = builder.acl;
        this.bucket = builder.bucket;
        this.cacheControl = builder.cacheControl;
        this.contentDisposition = builder.contentDisposition;
        this.contentEncoding = builder.contentEncoding;
        this.contentLanguage = builder.contentLanguage;
        this.contentLength = builder.contentLength;
        this.contentMD5 = builder.contentMD5;
        this.contentType = builder.contentType;
        this.checksumAlgorithm = builder.checksumAlgorithm;
        this.checksumCRC32 = builder.checksumCRC32;
        this.checksumCRC32C = builder.checksumCRC32C;
        this.checksumCRC64NVME = builder.checksumCRC64NVME;
        this.checksumSHA1 = builder.checksumSHA1;
        this.checksumSHA256 = builder.checksumSHA256;
        this.expires = builder.expires;
        this.ifMatch = builder.ifMatch;
        this.ifNoneMatch = builder.ifNoneMatch;
        this.grantFullControl = builder.grantFullControl;
        this.grantRead = builder.grantRead;
        this.grantReadACP = builder.grantReadACP;
        this.grantWriteACP = builder.grantWriteACP;
        this.key = builder.key;
        this.writeOffsetBytes = builder.writeOffsetBytes;
        this.metadata = builder.metadata;
        this.serverSideEncryption = builder.serverSideEncryption;
        this.storageClass = builder.storageClass;
        this.websiteRedirectLocation = builder.websiteRedirectLocation;
        this.sseCustomerAlgorithm = builder.sseCustomerAlgorithm;
        this.sseCustomerKey = builder.sseCustomerKey;
        this.sseCustomerKeyMD5 = builder.sseCustomerKeyMD5;
        this.ssekmsKeyId = builder.ssekmsKeyId;
        this.ssekmsEncryptionContext = builder.ssekmsEncryptionContext;
        this.bucketKeyEnabled = builder.bucketKeyEnabled;
        this.requestPayer = builder.requestPayer;
        this.tagging = builder.tagging;
        this.objectLockMode = builder.objectLockMode;
        this.objectLockRetainUntilDate = builder.objectLockRetainUntilDate;
        this.objectLockLegalHoldStatus = builder.objectLockLegalHoldStatus;
        this.expectedBucketOwner = builder.expectedBucketOwner;
        this.retentionExpirationDate = builder.retentionExpirationDate;
        this.retentionLegalHoldId = builder.retentionLegalHoldId;
        this.retentionPeriod = builder.retentionPeriod;

    }

    /**
     * <p>
     * The canned ACL to apply to the object. For more information, see <a
     * href="https://docs.aws.amazon.com/AmazonS3/latest/dev/acl-overview.html#CannedACL">Canned ACL</a> in the
     * <i>Amazon S3 User Guide</i>.
     * </p>
     * <p>
     * When adding a new object, you can use headers to grant ACL-based permissions to individual Amazon Web Services
     * accounts or to predefined groups defined by Amazon S3. These permissions are then added to the ACL on the object.
     * By default, all objects are private. Only the owner has full access control. For more information, see <a
     * href="https://docs.aws.amazon.com/AmazonS3/latest/dev/acl-overview.html">Access Control List (ACL) Overview</a>
     * and <a href="https://docs.aws.amazon.com/AmazonS3/latest/dev/acl-using-rest-api.html">Managing ACLs Using the
     * REST API</a> in the <i>Amazon S3 User Guide</i>.
     * </p>
     * <p>
     * If the bucket that you're uploading objects to uses the bucket owner enforced setting for S3 Object Ownership,
     * ACLs are disabled and no longer affect permissions. Buckets that use this setting only accept PUT requests that
     * don't specify an ACL or PUT requests that specify bucket owner full control ACLs, such as the
     * <code>bucket-owner-full-control</code> canned ACL or an equivalent form of this ACL expressed in the XML format.
     * PUT requests that contain other ACLs (for example, custom grants to certain Amazon Web Services accounts) fail
     * and return a <code>400</code> error with the error code <code>AccessControlListNotSupported</code>. For more
     * information, see <a href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/about-object-ownership.html">
     * Controlling ownership of objects and disabling ACLs</a> in the <i>Amazon S3 User Guide</i>.
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
     * <p>
     * If the service returns an enum value that is not available in the current SDK version, {@link #acl} will return
     * {@link ObjectCannedACL#UNKNOWN_TO_SDK_VERSION}. The raw value returned by the service is available from
     * {@link #aclAsString}.
     * </p>
     * 
     * @return The canned ACL to apply to the object. For more information, see <a
     *         href="https://docs.aws.amazon.com/AmazonS3/latest/dev/acl-overview.html#CannedACL">Canned ACL</a> in the
     *         <i>Amazon S3 User Guide</i>.</p>
     *         <p>
     *         When adding a new object, you can use headers to grant ACL-based permissions to individual Amazon Web
     *         Services accounts or to predefined groups defined by Amazon S3. These permissions are then added to the
     *         ACL on the object. By default, all objects are private. Only the owner has full access control. For more
     *         information, see <a href="https://docs.aws.amazon.com/AmazonS3/latest/dev/acl-overview.html">Access
     *         Control List (ACL) Overview</a> and <a
     *         href="https://docs.aws.amazon.com/AmazonS3/latest/dev/acl-using-rest-api.html">Managing ACLs Using the
     *         REST API</a> in the <i>Amazon S3 User Guide</i>.
     *         </p>
     *         <p>
     *         If the bucket that you're uploading objects to uses the bucket owner enforced setting for S3 Object
     *         Ownership, ACLs are disabled and no longer affect permissions. Buckets that use this setting only accept
     *         PUT requests that don't specify an ACL or PUT requests that specify bucket owner full control ACLs, such
     *         as the <code>bucket-owner-full-control</code> canned ACL or an equivalent form of this ACL expressed in
     *         the XML format. PUT requests that contain other ACLs (for example, custom grants to certain Amazon Web
     *         Services accounts) fail and return a <code>400</code> error with the error code
     *         <code>AccessControlListNotSupported</code>. For more information, see <a
     *         href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/about-object-ownership.html"> Controlling
     *         ownership of objects and disabling ACLs</a> in the <i>Amazon S3 User Guide</i>.
     *         </p>
     *         <note>
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
     * @see ObjectCannedACL
     */
    public final ObjectCannedACL acl() {
        return ObjectCannedACL.fromValue(acl);
    }

    /**
     * <p>
     * The canned ACL to apply to the object. For more information, see <a
     * href="https://docs.aws.amazon.com/AmazonS3/latest/dev/acl-overview.html#CannedACL">Canned ACL</a> in the
     * <i>Amazon S3 User Guide</i>.
     * </p>
     * <p>
     * When adding a new object, you can use headers to grant ACL-based permissions to individual Amazon Web Services
     * accounts or to predefined groups defined by Amazon S3. These permissions are then added to the ACL on the object.
     * By default, all objects are private. Only the owner has full access control. For more information, see <a
     * href="https://docs.aws.amazon.com/AmazonS3/latest/dev/acl-overview.html">Access Control List (ACL) Overview</a>
     * and <a href="https://docs.aws.amazon.com/AmazonS3/latest/dev/acl-using-rest-api.html">Managing ACLs Using the
     * REST API</a> in the <i>Amazon S3 User Guide</i>.
     * </p>
     * <p>
     * If the bucket that you're uploading objects to uses the bucket owner enforced setting for S3 Object Ownership,
     * ACLs are disabled and no longer affect permissions. Buckets that use this setting only accept PUT requests that
     * don't specify an ACL or PUT requests that specify bucket owner full control ACLs, such as the
     * <code>bucket-owner-full-control</code> canned ACL or an equivalent form of this ACL expressed in the XML format.
     * PUT requests that contain other ACLs (for example, custom grants to certain Amazon Web Services accounts) fail
     * and return a <code>400</code> error with the error code <code>AccessControlListNotSupported</code>. For more
     * information, see <a href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/about-object-ownership.html">
     * Controlling ownership of objects and disabling ACLs</a> in the <i>Amazon S3 User Guide</i>.
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
     * <p>
     * If the service returns an enum value that is not available in the current SDK version, {@link #acl} will return
     * {@link ObjectCannedACL#UNKNOWN_TO_SDK_VERSION}. The raw value returned by the service is available from
     * {@link #aclAsString}.
     * </p>
     * 
     * @return The canned ACL to apply to the object. For more information, see <a
     *         href="https://docs.aws.amazon.com/AmazonS3/latest/dev/acl-overview.html#CannedACL">Canned ACL</a> in the
     *         <i>Amazon S3 User Guide</i>.</p>
     *         <p>
     *         When adding a new object, you can use headers to grant ACL-based permissions to individual Amazon Web
     *         Services accounts or to predefined groups defined by Amazon S3. These permissions are then added to the
     *         ACL on the object. By default, all objects are private. Only the owner has full access control. For more
     *         information, see <a href="https://docs.aws.amazon.com/AmazonS3/latest/dev/acl-overview.html">Access
     *         Control List (ACL) Overview</a> and <a
     *         href="https://docs.aws.amazon.com/AmazonS3/latest/dev/acl-using-rest-api.html">Managing ACLs Using the
     *         REST API</a> in the <i>Amazon S3 User Guide</i>.
     *         </p>
     *         <p>
     *         If the bucket that you're uploading objects to uses the bucket owner enforced setting for S3 Object
     *         Ownership, ACLs are disabled and no longer affect permissions. Buckets that use this setting only accept
     *         PUT requests that don't specify an ACL or PUT requests that specify bucket owner full control ACLs, such
     *         as the <code>bucket-owner-full-control</code> canned ACL or an equivalent form of this ACL expressed in
     *         the XML format. PUT requests that contain other ACLs (for example, custom grants to certain Amazon Web
     *         Services accounts) fail and return a <code>400</code> error with the error code
     *         <code>AccessControlListNotSupported</code>. For more information, see <a
     *         href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/about-object-ownership.html"> Controlling
     *         ownership of objects and disabling ACLs</a> in the <i>Amazon S3 User Guide</i>.
     *         </p>
     *         <note>
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
     * @see ObjectCannedACL
     */
    public final String aclAsString() {
        return acl;
    }

    /**
     * <p>
     * The bucket name to which the PUT action was initiated.
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
     * <b>S3 on Outposts</b> - When you use this action with S3 on Outposts, you must direct requests to the S3 on
     * Outposts hostname. The S3 on Outposts hostname takes the form
     * <code> <i>AccessPointName</i>-<i>AccountId</i>.<i>outpostID</i>.s3-outposts.<i>Region</i>.amazonaws.com</code>.
     * When you use this action with S3 on Outposts, the destination bucket must be the Outposts access point ARN or the
     * access point alias. For more information about S3 on Outposts, see <a
     * href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/S3onOutposts.html">What is S3 on Outposts?</a> in the
     * <i>Amazon S3 User Guide</i>.
     * </p>
     * 
     * @return The bucket name to which the PUT action was initiated. </p>
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
     *         <b>S3 on Outposts</b> - When you use this action with S3 on Outposts, you must direct requests to the S3
     *         on Outposts hostname. The S3 on Outposts hostname takes the form
     *         <code> <i>AccessPointName</i>-<i>AccountId</i>.<i>outpostID</i>.s3-outposts.<i>Region</i>.amazonaws.com</code>
     *         . When you use this action with S3 on Outposts, the destination bucket must be the Outposts access point
     *         ARN or the access point alias. For more information about S3 on Outposts, see <a
     *         href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/S3onOutposts.html">What is S3 on
     *         Outposts?</a> in the <i>Amazon S3 User Guide</i>.
     */
    public final String bucket() {
        return bucket;
    }

    /**
     * <p>
     * Can be used to specify caching behavior along the request/reply chain. For more information, see <a
     * href="http://www.w3.org/Protocols/rfc2616/rfc2616-sec14.html#sec14.9"
     * >http://www.w3.org/Protocols/rfc2616/rfc2616-sec14.html#sec14.9</a>.
     * </p>
     * 
     * @return Can be used to specify caching behavior along the request/reply chain. For more information, see <a
     *         href="http://www.w3.org/Protocols/rfc2616/rfc2616-sec14.html#sec14.9"
     *         >http://www.w3.org/Protocols/rfc2616/rfc2616-sec14.html#sec14.9</a>.
     */
    public final String cacheControl() {
        return cacheControl;
    }

    /**
     * <p>
     * Specifies presentational information for the object. For more information, see <a
     * href="https://www.rfc-editor.org/rfc/rfc6266#section-4">https://www.rfc-editor.org/rfc/rfc6266#section-4</a>.
     * </p>
     * 
     * @return Specifies presentational information for the object. For more information, see <a
     *         href="https://www.rfc-editor.org/rfc/rfc6266#section-4"
     *         >https://www.rfc-editor.org/rfc/rfc6266#section-4</a>.
     */
    public final String contentDisposition() {
        return contentDisposition;
    }

    /**
     * <p>
     * Specifies what content encodings have been applied to the object and thus what decoding mechanisms must be
     * applied to obtain the media-type referenced by the Content-Type header field. For more information, see <a
     * href="https://www.rfc-editor.org/rfc/rfc9110.html#field.content-encoding"
     * >https://www.rfc-editor.org/rfc/rfc9110.html#field.content-encoding</a>.
     * </p>
     * 
     * @return Specifies what content encodings have been applied to the object and thus what decoding mechanisms must
     *         be applied to obtain the media-type referenced by the Content-Type header field. For more information,
     *         see <a
     *         href="https://www.rfc-editor.org/rfc/rfc9110.html#field.content-encoding">https://www.rfc-editor.org
     *         /rfc/rfc9110.html#field.content-encoding</a>.
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
     * Size of the body in bytes. This parameter is useful when the size of the body cannot be determined automatically.
     * For more information, see <a
     * href="https://www.rfc-editor.org/rfc/rfc9110.html#name-content-length">https://www.rfc
     * -editor.org/rfc/rfc9110.html#name-content-length</a>.
     * </p>
     * 
     * @return Size of the body in bytes. This parameter is useful when the size of the body cannot be determined
     *         automatically. For more information, see <a
     *         href="https://www.rfc-editor.org/rfc/rfc9110.html#name-content-length"
     *         >https://www.rfc-editor.org/rfc/rfc9110.html#name-content-length</a>.
     */
    public final Long contentLength() {
        return contentLength;
    }

    /**
     * <p>
     * The Base64 encoded 128-bit <code>MD5</code> digest of the message (without the headers) according to RFC 1864.
     * This header can be used as a message integrity check to verify that the data is the same data that was originally
     * sent. Although it is optional, we recommend using the Content-MD5 mechanism as an end-to-end integrity check. For
     * more information about REST request authentication, see <a
     * href="https://docs.aws.amazon.com/AmazonS3/latest/dev/RESTAuthentication.html">REST Authentication</a>.
     * </p>
     * <note>
     * <p>
     * The <code>Content-MD5</code> or <code>x-amz-sdk-checksum-algorithm</code> header is required for any request to
     * upload an object with a retention period configured using Amazon S3 Object Lock. For more information, see <a
     * href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/object-lock-managing.html#object-lock-put-object">
     * Uploading objects to an Object Lock enabled bucket </a> in the <i>Amazon S3 User Guide</i>.
     * </p>
     * </note> <note>
     * <p>
     * This functionality is not supported for directory buckets.
     * </p>
     * </note>
     * 
     * @return The Base64 encoded 128-bit <code>MD5</code> digest of the message (without the headers) according to RFC
     *         1864. This header can be used as a message integrity check to verify that the data is the same data that
     *         was originally sent. Although it is optional, we recommend using the Content-MD5 mechanism as an
     *         end-to-end integrity check. For more information about REST request authentication, see <a
     *         href="https://docs.aws.amazon.com/AmazonS3/latest/dev/RESTAuthentication.html">REST
     *         Authentication</a>.</p> <note>
     *         <p>
     *         The <code>Content-MD5</code> or <code>x-amz-sdk-checksum-algorithm</code> header is required for any
     *         request to upload an object with a retention period configured using Amazon S3 Object Lock. For more
     *         information, see <a href=
     *         "https://docs.aws.amazon.com/AmazonS3/latest/userguide/object-lock-managing.html#object-lock-put-object"
     *         >Uploading objects to an Object Lock enabled bucket </a> in the <i>Amazon S3 User Guide</i>.
     *         </p>
     *         </note> <note>
     *         <p>
     *         This functionality is not supported for directory buckets.
     *         </p>
     */
    public final String contentMD5() {
        return contentMD5;
    }

    /**
     * <p>
     * A standard MIME type describing the format of the contents. For more information, see <a
     * href="https://www.rfc-editor.org/rfc/rfc9110.html#name-content-type"
     * >https://www.rfc-editor.org/rfc/rfc9110.html#name-content-type</a>.
     * </p>
     * 
     * @return A standard MIME type describing the format of the contents. For more information, see <a
     *         href="https://www.rfc-editor.org/rfc/rfc9110.html#name-content-type"
     *         >https://www.rfc-editor.org/rfc/rfc9110.html#name-content-type</a>.
     */
    public final String contentType() {
        return contentType;
    }

    /**
     * <p>
     * Indicates the algorithm used to create the checksum for the object when you use the SDK. This header will not
     * provide any additional functionality if you don't use the SDK. When you send this header, there must be a
     * corresponding <code>x-amz-checksum-<i>algorithm</i> </code> or <code>x-amz-trailer</code> header sent. Otherwise,
     * Amazon S3 fails the request with the HTTP status code <code>400 Bad Request</code>.
     * </p>
     * <p>
     * For the <code>x-amz-checksum-<i>algorithm</i> </code> header, replace <code> <i>algorithm</i> </code> with the
     * supported algorithm from the following list:
     * </p>
     * <ul>
     * <li>
     * <p>
     * <code>CRC32</code>
     * </p>
     * </li>
     * <li>
     * <p>
     * <code>CRC32C</code>
     * </p>
     * </li>
     * <li>
     * <p>
     * <code>CRC64NVME</code>
     * </p>
     * </li>
     * <li>
     * <p>
     * <code>SHA1</code>
     * </p>
     * </li>
     * <li>
     * <p>
     * <code>SHA256</code>
     * </p>
     * </li>
     * </ul>
     * <p>
     * For more information, see <a
     * href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/checking-object-integrity.html">Checking object
     * integrity</a> in the <i>Amazon S3 User Guide</i>.
     * </p>
     * <p>
     * If the individual checksum value you provide through <code>x-amz-checksum-<i>algorithm</i> </code> doesn't match
     * the checksum algorithm you set through <code>x-amz-sdk-checksum-algorithm</code>, Amazon S3 fails the request
     * with a <code>BadDigest</code> error.
     * </p>
     * <note>
     * <p>
     * The <code>Content-MD5</code> or <code>x-amz-sdk-checksum-algorithm</code> header is required for any request to
     * upload an object with a retention period configured using Amazon S3 Object Lock. For more information, see <a
     * href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/object-lock-managing.html#object-lock-put-object">
     * Uploading objects to an Object Lock enabled bucket </a> in the <i>Amazon S3 User Guide</i>.
     * </p>
     * </note>
     * <p>
     * For directory buckets, when you use Amazon Web Services SDKs, <code>CRC32</code> is the default checksum
     * algorithm that's used for performance.
     * </p>
     * <p>
     * If the service returns an enum value that is not available in the current SDK version, {@link #checksumAlgorithm}
     * will return {@link ChecksumAlgorithm#UNKNOWN_TO_SDK_VERSION}. The raw value returned by the service is available
     * from {@link #checksumAlgorithmAsString}.
     * </p>
     * 
     * @return Indicates the algorithm used to create the checksum for the object when you use the SDK. This header will
     *         not provide any additional functionality if you don't use the SDK. When you send this header, there must
     *         be a corresponding <code>x-amz-checksum-<i>algorithm</i> </code> or <code>x-amz-trailer</code> header
     *         sent. Otherwise, Amazon S3 fails the request with the HTTP status code <code>400 Bad Request</code>.</p>
     *         <p>
     *         For the <code>x-amz-checksum-<i>algorithm</i> </code> header, replace <code> <i>algorithm</i> </code>
     *         with the supported algorithm from the following list:
     *         </p>
     *         <ul>
     *         <li>
     *         <p>
     *         <code>CRC32</code>
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         <code>CRC32C</code>
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         <code>CRC64NVME</code>
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         <code>SHA1</code>
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         <code>SHA256</code>
     *         </p>
     *         </li>
     *         </ul>
     *         <p>
     *         For more information, see <a
     *         href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/checking-object-integrity.html">Checking
     *         object integrity</a> in the <i>Amazon S3 User Guide</i>.
     *         </p>
     *         <p>
     *         If the individual checksum value you provide through <code>x-amz-checksum-<i>algorithm</i> </code>
     *         doesn't match the checksum algorithm you set through <code>x-amz-sdk-checksum-algorithm</code>, Amazon S3
     *         fails the request with a <code>BadDigest</code> error.
     *         </p>
     *         <note>
     *         <p>
     *         The <code>Content-MD5</code> or <code>x-amz-sdk-checksum-algorithm</code> header is required for any
     *         request to upload an object with a retention period configured using Amazon S3 Object Lock. For more
     *         information, see <a href=
     *         "https://docs.aws.amazon.com/AmazonS3/latest/userguide/object-lock-managing.html#object-lock-put-object"
     *         >Uploading objects to an Object Lock enabled bucket </a> in the <i>Amazon S3 User Guide</i>.
     *         </p>
     *         </note>
     *         <p>
     *         For directory buckets, when you use Amazon Web Services SDKs, <code>CRC32</code> is the default checksum
     *         algorithm that's used for performance.
     * @see ChecksumAlgorithm
     */
    public final ChecksumAlgorithm checksumAlgorithm() {
        return ChecksumAlgorithm.fromValue(checksumAlgorithm);
    }

    /**
     * <p>
     * Indicates the algorithm used to create the checksum for the object when you use the SDK. This header will not
     * provide any additional functionality if you don't use the SDK. When you send this header, there must be a
     * corresponding <code>x-amz-checksum-<i>algorithm</i> </code> or <code>x-amz-trailer</code> header sent. Otherwise,
     * Amazon S3 fails the request with the HTTP status code <code>400 Bad Request</code>.
     * </p>
     * <p>
     * For the <code>x-amz-checksum-<i>algorithm</i> </code> header, replace <code> <i>algorithm</i> </code> with the
     * supported algorithm from the following list:
     * </p>
     * <ul>
     * <li>
     * <p>
     * <code>CRC32</code>
     * </p>
     * </li>
     * <li>
     * <p>
     * <code>CRC32C</code>
     * </p>
     * </li>
     * <li>
     * <p>
     * <code>CRC64NVME</code>
     * </p>
     * </li>
     * <li>
     * <p>
     * <code>SHA1</code>
     * </p>
     * </li>
     * <li>
     * <p>
     * <code>SHA256</code>
     * </p>
     * </li>
     * </ul>
     * <p>
     * For more information, see <a
     * href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/checking-object-integrity.html">Checking object
     * integrity</a> in the <i>Amazon S3 User Guide</i>.
     * </p>
     * <p>
     * If the individual checksum value you provide through <code>x-amz-checksum-<i>algorithm</i> </code> doesn't match
     * the checksum algorithm you set through <code>x-amz-sdk-checksum-algorithm</code>, Amazon S3 fails the request
     * with a <code>BadDigest</code> error.
     * </p>
     * <note>
     * <p>
     * The <code>Content-MD5</code> or <code>x-amz-sdk-checksum-algorithm</code> header is required for any request to
     * upload an object with a retention period configured using Amazon S3 Object Lock. For more information, see <a
     * href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/object-lock-managing.html#object-lock-put-object">
     * Uploading objects to an Object Lock enabled bucket </a> in the <i>Amazon S3 User Guide</i>.
     * </p>
     * </note>
     * <p>
     * For directory buckets, when you use Amazon Web Services SDKs, <code>CRC32</code> is the default checksum
     * algorithm that's used for performance.
     * </p>
     * <p>
     * If the service returns an enum value that is not available in the current SDK version, {@link #checksumAlgorithm}
     * will return {@link ChecksumAlgorithm#UNKNOWN_TO_SDK_VERSION}. The raw value returned by the service is available
     * from {@link #checksumAlgorithmAsString}.
     * </p>
     * 
     * @return Indicates the algorithm used to create the checksum for the object when you use the SDK. This header will
     *         not provide any additional functionality if you don't use the SDK. When you send this header, there must
     *         be a corresponding <code>x-amz-checksum-<i>algorithm</i> </code> or <code>x-amz-trailer</code> header
     *         sent. Otherwise, Amazon S3 fails the request with the HTTP status code <code>400 Bad Request</code>.</p>
     *         <p>
     *         For the <code>x-amz-checksum-<i>algorithm</i> </code> header, replace <code> <i>algorithm</i> </code>
     *         with the supported algorithm from the following list:
     *         </p>
     *         <ul>
     *         <li>
     *         <p>
     *         <code>CRC32</code>
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         <code>CRC32C</code>
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         <code>CRC64NVME</code>
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         <code>SHA1</code>
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         <code>SHA256</code>
     *         </p>
     *         </li>
     *         </ul>
     *         <p>
     *         For more information, see <a
     *         href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/checking-object-integrity.html">Checking
     *         object integrity</a> in the <i>Amazon S3 User Guide</i>.
     *         </p>
     *         <p>
     *         If the individual checksum value you provide through <code>x-amz-checksum-<i>algorithm</i> </code>
     *         doesn't match the checksum algorithm you set through <code>x-amz-sdk-checksum-algorithm</code>, Amazon S3
     *         fails the request with a <code>BadDigest</code> error.
     *         </p>
     *         <note>
     *         <p>
     *         The <code>Content-MD5</code> or <code>x-amz-sdk-checksum-algorithm</code> header is required for any
     *         request to upload an object with a retention period configured using Amazon S3 Object Lock. For more
     *         information, see <a href=
     *         "https://docs.aws.amazon.com/AmazonS3/latest/userguide/object-lock-managing.html#object-lock-put-object"
     *         >Uploading objects to an Object Lock enabled bucket </a> in the <i>Amazon S3 User Guide</i>.
     *         </p>
     *         </note>
     *         <p>
     *         For directory buckets, when you use Amazon Web Services SDKs, <code>CRC32</code> is the default checksum
     *         algorithm that's used for performance.
     * @see ChecksumAlgorithm
     */
    public final String checksumAlgorithmAsString() {
        return checksumAlgorithm;
    }

    /**
     * <p>
     * This header can be used as a data integrity check to verify that the data received is the same data that was
     * originally sent. This header specifies the Base64 encoded, 32-bit <code>CRC32</code> checksum of the object. For
     * more information, see <a
     * href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/checking-object-integrity.html">Checking object
     * integrity</a> in the <i>Amazon S3 User Guide</i>.
     * </p>
     * 
     * @return This header can be used as a data integrity check to verify that the data received is the same data that
     *         was originally sent. This header specifies the Base64 encoded, 32-bit <code>CRC32</code> checksum of the
     *         object. For more information, see <a
     *         href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/checking-object-integrity.html">Checking
     *         object integrity</a> in the <i>Amazon S3 User Guide</i>.
     */
    public final String checksumCRC32() {
        return checksumCRC32;
    }

    /**
     * <p>
     * This header can be used as a data integrity check to verify that the data received is the same data that was
     * originally sent. This header specifies the Base64 encoded, 32-bit <code>CRC32C</code> checksum of the object. For
     * more information, see <a
     * href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/checking-object-integrity.html">Checking object
     * integrity</a> in the <i>Amazon S3 User Guide</i>.
     * </p>
     * 
     * @return This header can be used as a data integrity check to verify that the data received is the same data that
     *         was originally sent. This header specifies the Base64 encoded, 32-bit <code>CRC32C</code> checksum of the
     *         object. For more information, see <a
     *         href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/checking-object-integrity.html">Checking
     *         object integrity</a> in the <i>Amazon S3 User Guide</i>.
     */
    public final String checksumCRC32C() {
        return checksumCRC32C;
    }

    /**
     * <p>
     * This header can be used as a data integrity check to verify that the data received is the same data that was
     * originally sent. This header specifies the Base64 encoded, 64-bit <code>CRC64NVME</code> checksum of the object.
     * The <code>CRC64NVME</code> checksum is always a full object checksum. For more information, see <a
     * href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/checking-object-integrity.html">Checking object
     * integrity in the Amazon S3 User Guide</a>.
     * </p>
     * 
     * @return This header can be used as a data integrity check to verify that the data received is the same data that
     *         was originally sent. This header specifies the Base64 encoded, 64-bit <code>CRC64NVME</code> checksum of
     *         the object. The <code>CRC64NVME</code> checksum is always a full object checksum. For more information,
     *         see <a
     *         href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/checking-object-integrity.html">Checking
     *         object integrity in the Amazon S3 User Guide</a>.
     */
    public final String checksumCRC64NVME() {
        return checksumCRC64NVME;
    }

    /**
     * <p>
     * This header can be used as a data integrity check to verify that the data received is the same data that was
     * originally sent. This header specifies the Base64 encoded, 160-bit <code>SHA1</code> digest of the object. For
     * more information, see <a
     * href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/checking-object-integrity.html">Checking object
     * integrity</a> in the <i>Amazon S3 User Guide</i>.
     * </p>
     * 
     * @return This header can be used as a data integrity check to verify that the data received is the same data that
     *         was originally sent. This header specifies the Base64 encoded, 160-bit <code>SHA1</code> digest of the
     *         object. For more information, see <a
     *         href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/checking-object-integrity.html">Checking
     *         object integrity</a> in the <i>Amazon S3 User Guide</i>.
     */
    public final String checksumSHA1() {
        return checksumSHA1;
    }

    /**
     * <p>
     * This header can be used as a data integrity check to verify that the data received is the same data that was
     * originally sent. This header specifies the Base64 encoded, 256-bit <code>SHA256</code> digest of the object. For
     * more information, see <a
     * href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/checking-object-integrity.html">Checking object
     * integrity</a> in the <i>Amazon S3 User Guide</i>.
     * </p>
     * 
     * @return This header can be used as a data integrity check to verify that the data received is the same data that
     *         was originally sent. This header specifies the Base64 encoded, 256-bit <code>SHA256</code> digest of the
     *         object. For more information, see <a
     *         href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/checking-object-integrity.html">Checking
     *         object integrity</a> in the <i>Amazon S3 User Guide</i>.
     */
    public final String checksumSHA256() {
        return checksumSHA256;
    }

    /**
     * <p>
     * The date and time at which the object is no longer cacheable. For more information, see <a
     * href="https://www.rfc-editor.org/rfc/rfc7234#section-5.3">https://www.rfc-editor.org/rfc/rfc7234#section-5.3</a>.
     * </p>
     * 
     * @return The date and time at which the object is no longer cacheable. For more information, see <a
     *         href="https://www.rfc-editor.org/rfc/rfc7234#section-5.3"
     *         >https://www.rfc-editor.org/rfc/rfc7234#section-5.3</a>.
     */
    public final Instant expires() {
        return expires;
    }

    /**
     * <p>
     * Uploads the object only if the ETag (entity tag) value provided during the WRITE operation matches the ETag of
     * the object in S3. If the ETag values do not match, the operation returns a <code>412 Precondition Failed</code>
     * error.
     * </p>
     * <p>
     * If a conflicting operation occurs during the upload S3 returns a <code>409 ConditionalRequestConflict</code>
     * response. On a 409 failure you should fetch the object's ETag and retry the upload.
     * </p>
     * <p>
     * Expects the ETag value as a string.
     * </p>
     * <p>
     * For more information about conditional requests, see <a href="https://tools.ietf.org/html/rfc7232">RFC 7232</a>,
     * or <a href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/conditional-requests.html">Conditional
     * requests</a> in the <i>Amazon S3 User Guide</i>.
     * </p>
     * 
     * @return Uploads the object only if the ETag (entity tag) value provided during the WRITE operation matches the
     *         ETag of the object in S3. If the ETag values do not match, the operation returns a
     *         <code>412 Precondition Failed</code> error.</p>
     *         <p>
     *         If a conflicting operation occurs during the upload S3 returns a
     *         <code>409 ConditionalRequestConflict</code> response. On a 409 failure you should fetch the object's ETag
     *         and retry the upload.
     *         </p>
     *         <p>
     *         Expects the ETag value as a string.
     *         </p>
     *         <p>
     *         For more information about conditional requests, see <a href="https://tools.ietf.org/html/rfc7232">RFC
     *         7232</a>, or <a
     *         href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/conditional-requests.html">Conditional
     *         requests</a> in the <i>Amazon S3 User Guide</i>.
     */
    public final String ifMatch() {
        return ifMatch;
    }

    /**
     * <p>
     * Uploads the object only if the object key name does not already exist in the bucket specified. Otherwise, Amazon
     * S3 returns a <code>412 Precondition Failed</code> error.
     * </p>
     * <p>
     * If a conflicting operation occurs during the upload S3 returns a <code>409 ConditionalRequestConflict</code>
     * response. On a 409 failure you should retry the upload.
     * </p>
     * <p>
     * Expects the '*' (asterisk) character.
     * </p>
     * <p>
     * For more information about conditional requests, see <a href="https://tools.ietf.org/html/rfc7232">RFC 7232</a>,
     * or <a href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/conditional-requests.html">Conditional
     * requests</a> in the <i>Amazon S3 User Guide</i>.
     * </p>
     * 
     * @return Uploads the object only if the object key name does not already exist in the bucket specified. Otherwise,
     *         Amazon S3 returns a <code>412 Precondition Failed</code> error.</p>
     *         <p>
     *         If a conflicting operation occurs during the upload S3 returns a
     *         <code>409 ConditionalRequestConflict</code> response. On a 409 failure you should retry the upload.
     *         </p>
     *         <p>
     *         Expects the '*' (asterisk) character.
     *         </p>
     *         <p>
     *         For more information about conditional requests, see <a href="https://tools.ietf.org/html/rfc7232">RFC
     *         7232</a>, or <a
     *         href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/conditional-requests.html">Conditional
     *         requests</a> in the <i>Amazon S3 User Guide</i>.
     */
    public final String ifNoneMatch() {
        return ifNoneMatch;
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
     * <p>
     * Object key for which the PUT action was initiated.
     * </p>
     * 
     * @return Object key for which the PUT action was initiated.
     */
    public final String key() {
        return key;
    }

    /**
     * <p>
     * Specifies the offset for appending data to existing objects in bytes. The offset must be equal to the size of the
     * existing object being appended to. If no object exists, setting this header to 0 will create a new object.
     * </p>
     * <note>
     * <p>
     * This functionality is only supported for objects in the Amazon S3 Express One Zone storage class in directory
     * buckets.
     * </p>
     * </note>
     * 
     * @return Specifies the offset for appending data to existing objects in bytes. The offset must be equal to the
     *         size of the existing object being appended to. If no object exists, setting this header to 0 will create
     *         a new object. </p> <note>
     *         <p>
     *         This functionality is only supported for objects in the Amazon S3 Express One Zone storage class in
     *         directory buckets.
     *         </p>
     */
    public final Long writeOffsetBytes() {
        return writeOffsetBytes;
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
     * The server-side encryption algorithm that was used when you store this object in Amazon S3 (for example,
     * <code>AES256</code>, <code>aws:kms</code>, <code>aws:kms:dsse</code>).
     * </p>
     * <ul>
     * <li>
     * <p>
     * <b>General purpose buckets </b> - You have four mutually exclusive options to protect data using server-side
     * encryption in Amazon S3, depending on how you choose to manage the encryption keys. Specifically, the encryption
     * key options are Amazon S3 managed keys (SSE-S3), Amazon Web Services KMS keys (SSE-KMS or DSSE-KMS), and
     * customer-provided keys (SSE-C). Amazon S3 encrypts data with server-side encryption by using Amazon S3 managed
     * keys (SSE-S3) by default. You can optionally tell Amazon S3 to encrypt data at rest by using server-side
     * encryption with other key options. For more information, see <a
     * href="https://docs.aws.amazon.com/AmazonS3/latest/dev/UsingServerSideEncryption.html">Using Server-Side
     * Encryption</a> in the <i>Amazon S3 User Guide</i>.
     * </p>
     * </li>
     * <li>
     * <p>
     * <b>Directory buckets </b> - For directory buckets, there are only two supported options for server-side
     * encryption: server-side encryption with Amazon S3 managed keys (SSE-S3) (<code>AES256</code>) and server-side
     * encryption with KMS keys (SSE-KMS) (<code>aws:kms</code>). We recommend that the bucket's default encryption uses
     * the desired encryption configuration and you don't override the bucket default encryption in your
     * <code>CreateSession</code> requests or <code>PUT</code> object requests. Then, new objects are automatically
     * encrypted with the desired encryption settings. For more information, see <a
     * href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/s3-express-serv-side-encryption.html">Protecting data
     * with server-side encryption</a> in the <i>Amazon S3 User Guide</i>. For more information about the encryption
     * overriding behaviors in directory buckets, see <a
     * href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/s3-express-specifying-kms-encryption.html">Specifying
     * server-side encryption with KMS for new object uploads</a>.
     * </p>
     * <p>
     * In the Zonal endpoint API calls (except <a
     * href="https://docs.aws.amazon.com/AmazonS3/latest/API/API_CopyObject.html">CopyObject</a> and <a
     * href="https://docs.aws.amazon.com/AmazonS3/latest/API/API_UploadPartCopy.html">UploadPartCopy</a>) using the REST
     * API, the encryption request headers must match the encryption settings that are specified in the
     * <code>CreateSession</code> request. You can't override the values of the encryption settings (
     * <code>x-amz-server-side-encryption</code>, <code>x-amz-server-side-encryption-aws-kms-key-id</code>,
     * <code>x-amz-server-side-encryption-context</code>, and
     * <code>x-amz-server-side-encryption-bucket-key-enabled</code>) that are specified in the
     * <code>CreateSession</code> request. You don't need to explicitly specify these encryption settings values in
     * Zonal endpoint API calls, and Amazon S3 will use the encryption settings values from the
     * <code>CreateSession</code> request to protect new objects in the directory bucket.
     * </p>
     * <note>
     * <p>
     * When you use the CLI or the Amazon Web Services SDKs, for <code>CreateSession</code>, the session token refreshes
     * automatically to avoid service interruptions when a session expires. The CLI or the Amazon Web Services SDKs use
     * the bucket's default encryption configuration for the <code>CreateSession</code> request. It's not supported to
     * override the encryption settings values in the <code>CreateSession</code> request. So in the Zonal endpoint API
     * calls (except <a href="https://docs.aws.amazon.com/AmazonS3/latest/API/API_CopyObject.html">CopyObject</a> and <a
     * href="https://docs.aws.amazon.com/AmazonS3/latest/API/API_UploadPartCopy.html">UploadPartCopy</a>), the
     * encryption request headers must match the default encryption configuration of the directory bucket.
     * </p>
     * </note></li>
     * </ul>
     * <p>
     * If the service returns an enum value that is not available in the current SDK version,
     * {@link #serverSideEncryption} will return {@link ServerSideEncryption#UNKNOWN_TO_SDK_VERSION}. The raw value
     * returned by the service is available from {@link #serverSideEncryptionAsString}.
     * </p>
     * 
     * @return The server-side encryption algorithm that was used when you store this object in Amazon S3 (for example,
     *         <code>AES256</code>, <code>aws:kms</code>, <code>aws:kms:dsse</code>).</p>
     *         <ul>
     *         <li>
     *         <p>
     *         <b>General purpose buckets </b> - You have four mutually exclusive options to protect data using
     *         server-side encryption in Amazon S3, depending on how you choose to manage the encryption keys.
     *         Specifically, the encryption key options are Amazon S3 managed keys (SSE-S3), Amazon Web Services KMS
     *         keys (SSE-KMS or DSSE-KMS), and customer-provided keys (SSE-C). Amazon S3 encrypts data with server-side
     *         encryption by using Amazon S3 managed keys (SSE-S3) by default. You can optionally tell Amazon S3 to
     *         encrypt data at rest by using server-side encryption with other key options. For more information, see <a
     *         href="https://docs.aws.amazon.com/AmazonS3/latest/dev/UsingServerSideEncryption.html">Using Server-Side
     *         Encryption</a> in the <i>Amazon S3 User Guide</i>.
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         <b>Directory buckets </b> - For directory buckets, there are only two supported options for server-side
     *         encryption: server-side encryption with Amazon S3 managed keys (SSE-S3) (<code>AES256</code>) and
     *         server-side encryption with KMS keys (SSE-KMS) (<code>aws:kms</code>). We recommend that the bucket's
     *         default encryption uses the desired encryption configuration and you don't override the bucket default
     *         encryption in your <code>CreateSession</code> requests or <code>PUT</code> object requests. Then, new
     *         objects are automatically encrypted with the desired encryption settings. For more information, see <a
     *         href
     *         ="https://docs.aws.amazon.com/AmazonS3/latest/userguide/s3-express-serv-side-encryption.html">Protecting
     *         data with server-side encryption</a> in the <i>Amazon S3 User Guide</i>. For more information about the
     *         encryption overriding behaviors in directory buckets, see <a
     *         href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/s3-express-specifying-kms-encryption.html"
     *         >Specifying server-side encryption with KMS for new object uploads</a>.
     *         </p>
     *         <p>
     *         In the Zonal endpoint API calls (except <a
     *         href="https://docs.aws.amazon.com/AmazonS3/latest/API/API_CopyObject.html">CopyObject</a> and <a
     *         href="https://docs.aws.amazon.com/AmazonS3/latest/API/API_UploadPartCopy.html">UploadPartCopy</a>) using
     *         the REST API, the encryption request headers must match the encryption settings that are specified in the
     *         <code>CreateSession</code> request. You can't override the values of the encryption settings (
     *         <code>x-amz-server-side-encryption</code>, <code>x-amz-server-side-encryption-aws-kms-key-id</code>,
     *         <code>x-amz-server-side-encryption-context</code>, and
     *         <code>x-amz-server-side-encryption-bucket-key-enabled</code>) that are specified in the
     *         <code>CreateSession</code> request. You don't need to explicitly specify these encryption settings values
     *         in Zonal endpoint API calls, and Amazon S3 will use the encryption settings values from the
     *         <code>CreateSession</code> request to protect new objects in the directory bucket.
     *         </p>
     *         <note>
     *         <p>
     *         When you use the CLI or the Amazon Web Services SDKs, for <code>CreateSession</code>, the session token
     *         refreshes automatically to avoid service interruptions when a session expires. The CLI or the Amazon Web
     *         Services SDKs use the bucket's default encryption configuration for the <code>CreateSession</code>
     *         request. It's not supported to override the encryption settings values in the <code>CreateSession</code>
     *         request. So in the Zonal endpoint API calls (except <a
     *         href="https://docs.aws.amazon.com/AmazonS3/latest/API/API_CopyObject.html">CopyObject</a> and <a
     *         href="https://docs.aws.amazon.com/AmazonS3/latest/API/API_UploadPartCopy.html">UploadPartCopy</a>), the
     *         encryption request headers must match the default encryption configuration of the directory bucket.
     *         </p>
     *         </note></li>
     * @see ServerSideEncryption
     */
    public final ServerSideEncryption serverSideEncryption() {
        return ServerSideEncryption.fromValue(serverSideEncryption);
    }

    /**
     * <p>
     * The server-side encryption algorithm that was used when you store this object in Amazon S3 (for example,
     * <code>AES256</code>, <code>aws:kms</code>, <code>aws:kms:dsse</code>).
     * </p>
     * <ul>
     * <li>
     * <p>
     * <b>General purpose buckets </b> - You have four mutually exclusive options to protect data using server-side
     * encryption in Amazon S3, depending on how you choose to manage the encryption keys. Specifically, the encryption
     * key options are Amazon S3 managed keys (SSE-S3), Amazon Web Services KMS keys (SSE-KMS or DSSE-KMS), and
     * customer-provided keys (SSE-C). Amazon S3 encrypts data with server-side encryption by using Amazon S3 managed
     * keys (SSE-S3) by default. You can optionally tell Amazon S3 to encrypt data at rest by using server-side
     * encryption with other key options. For more information, see <a
     * href="https://docs.aws.amazon.com/AmazonS3/latest/dev/UsingServerSideEncryption.html">Using Server-Side
     * Encryption</a> in the <i>Amazon S3 User Guide</i>.
     * </p>
     * </li>
     * <li>
     * <p>
     * <b>Directory buckets </b> - For directory buckets, there are only two supported options for server-side
     * encryption: server-side encryption with Amazon S3 managed keys (SSE-S3) (<code>AES256</code>) and server-side
     * encryption with KMS keys (SSE-KMS) (<code>aws:kms</code>). We recommend that the bucket's default encryption uses
     * the desired encryption configuration and you don't override the bucket default encryption in your
     * <code>CreateSession</code> requests or <code>PUT</code> object requests. Then, new objects are automatically
     * encrypted with the desired encryption settings. For more information, see <a
     * href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/s3-express-serv-side-encryption.html">Protecting data
     * with server-side encryption</a> in the <i>Amazon S3 User Guide</i>. For more information about the encryption
     * overriding behaviors in directory buckets, see <a
     * href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/s3-express-specifying-kms-encryption.html">Specifying
     * server-side encryption with KMS for new object uploads</a>.
     * </p>
     * <p>
     * In the Zonal endpoint API calls (except <a
     * href="https://docs.aws.amazon.com/AmazonS3/latest/API/API_CopyObject.html">CopyObject</a> and <a
     * href="https://docs.aws.amazon.com/AmazonS3/latest/API/API_UploadPartCopy.html">UploadPartCopy</a>) using the REST
     * API, the encryption request headers must match the encryption settings that are specified in the
     * <code>CreateSession</code> request. You can't override the values of the encryption settings (
     * <code>x-amz-server-side-encryption</code>, <code>x-amz-server-side-encryption-aws-kms-key-id</code>,
     * <code>x-amz-server-side-encryption-context</code>, and
     * <code>x-amz-server-side-encryption-bucket-key-enabled</code>) that are specified in the
     * <code>CreateSession</code> request. You don't need to explicitly specify these encryption settings values in
     * Zonal endpoint API calls, and Amazon S3 will use the encryption settings values from the
     * <code>CreateSession</code> request to protect new objects in the directory bucket.
     * </p>
     * <note>
     * <p>
     * When you use the CLI or the Amazon Web Services SDKs, for <code>CreateSession</code>, the session token refreshes
     * automatically to avoid service interruptions when a session expires. The CLI or the Amazon Web Services SDKs use
     * the bucket's default encryption configuration for the <code>CreateSession</code> request. It's not supported to
     * override the encryption settings values in the <code>CreateSession</code> request. So in the Zonal endpoint API
     * calls (except <a href="https://docs.aws.amazon.com/AmazonS3/latest/API/API_CopyObject.html">CopyObject</a> and <a
     * href="https://docs.aws.amazon.com/AmazonS3/latest/API/API_UploadPartCopy.html">UploadPartCopy</a>), the
     * encryption request headers must match the default encryption configuration of the directory bucket.
     * </p>
     * </note></li>
     * </ul>
     * <p>
     * If the service returns an enum value that is not available in the current SDK version,
     * {@link #serverSideEncryption} will return {@link ServerSideEncryption#UNKNOWN_TO_SDK_VERSION}. The raw value
     * returned by the service is available from {@link #serverSideEncryptionAsString}.
     * </p>
     * 
     * @return The server-side encryption algorithm that was used when you store this object in Amazon S3 (for example,
     *         <code>AES256</code>, <code>aws:kms</code>, <code>aws:kms:dsse</code>).</p>
     *         <ul>
     *         <li>
     *         <p>
     *         <b>General purpose buckets </b> - You have four mutually exclusive options to protect data using
     *         server-side encryption in Amazon S3, depending on how you choose to manage the encryption keys.
     *         Specifically, the encryption key options are Amazon S3 managed keys (SSE-S3), Amazon Web Services KMS
     *         keys (SSE-KMS or DSSE-KMS), and customer-provided keys (SSE-C). Amazon S3 encrypts data with server-side
     *         encryption by using Amazon S3 managed keys (SSE-S3) by default. You can optionally tell Amazon S3 to
     *         encrypt data at rest by using server-side encryption with other key options. For more information, see <a
     *         href="https://docs.aws.amazon.com/AmazonS3/latest/dev/UsingServerSideEncryption.html">Using Server-Side
     *         Encryption</a> in the <i>Amazon S3 User Guide</i>.
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         <b>Directory buckets </b> - For directory buckets, there are only two supported options for server-side
     *         encryption: server-side encryption with Amazon S3 managed keys (SSE-S3) (<code>AES256</code>) and
     *         server-side encryption with KMS keys (SSE-KMS) (<code>aws:kms</code>). We recommend that the bucket's
     *         default encryption uses the desired encryption configuration and you don't override the bucket default
     *         encryption in your <code>CreateSession</code> requests or <code>PUT</code> object requests. Then, new
     *         objects are automatically encrypted with the desired encryption settings. For more information, see <a
     *         href
     *         ="https://docs.aws.amazon.com/AmazonS3/latest/userguide/s3-express-serv-side-encryption.html">Protecting
     *         data with server-side encryption</a> in the <i>Amazon S3 User Guide</i>. For more information about the
     *         encryption overriding behaviors in directory buckets, see <a
     *         href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/s3-express-specifying-kms-encryption.html"
     *         >Specifying server-side encryption with KMS for new object uploads</a>.
     *         </p>
     *         <p>
     *         In the Zonal endpoint API calls (except <a
     *         href="https://docs.aws.amazon.com/AmazonS3/latest/API/API_CopyObject.html">CopyObject</a> and <a
     *         href="https://docs.aws.amazon.com/AmazonS3/latest/API/API_UploadPartCopy.html">UploadPartCopy</a>) using
     *         the REST API, the encryption request headers must match the encryption settings that are specified in the
     *         <code>CreateSession</code> request. You can't override the values of the encryption settings (
     *         <code>x-amz-server-side-encryption</code>, <code>x-amz-server-side-encryption-aws-kms-key-id</code>,
     *         <code>x-amz-server-side-encryption-context</code>, and
     *         <code>x-amz-server-side-encryption-bucket-key-enabled</code>) that are specified in the
     *         <code>CreateSession</code> request. You don't need to explicitly specify these encryption settings values
     *         in Zonal endpoint API calls, and Amazon S3 will use the encryption settings values from the
     *         <code>CreateSession</code> request to protect new objects in the directory bucket.
     *         </p>
     *         <note>
     *         <p>
     *         When you use the CLI or the Amazon Web Services SDKs, for <code>CreateSession</code>, the session token
     *         refreshes automatically to avoid service interruptions when a session expires. The CLI or the Amazon Web
     *         Services SDKs use the bucket's default encryption configuration for the <code>CreateSession</code>
     *         request. It's not supported to override the encryption settings values in the <code>CreateSession</code>
     *         request. So in the Zonal endpoint API calls (except <a
     *         href="https://docs.aws.amazon.com/AmazonS3/latest/API/API_CopyObject.html">CopyObject</a> and <a
     *         href="https://docs.aws.amazon.com/AmazonS3/latest/API/API_UploadPartCopy.html">UploadPartCopy</a>), the
     *         encryption request headers must match the default encryption configuration of the directory bucket.
     *         </p>
     *         </note></li>
     * @see ServerSideEncryption
     */
    public final String serverSideEncryptionAsString() {
        return serverSideEncryption;
    }

    /**
     * <p>
     * By default, Amazon S3 uses the STANDARD Storage Class to store newly created objects. The STANDARD storage class
     * provides high durability and high availability. Depending on performance needs, you can specify a different
     * Storage Class. For more information, see <a
     * href="https://docs.aws.amazon.com/AmazonS3/latest/dev/storage-class-intro.html">Storage Classes</a> in the
     * <i>Amazon S3 User Guide</i>.
     * </p>
     * <note>
     * <ul>
     * <li>
     * <p>
     * Directory buckets only support <code>EXPRESS_ONEZONE</code> (the S3 Express One Zone storage class) in
     * Availability Zones and <code>ONEZONE_IA</code> (the S3 One Zone-Infrequent Access storage class) in Dedicated
     * Local Zones.
     * </p>
     * </li>
     * <li>
     * <p>
     * Amazon S3 on Outposts only uses the OUTPOSTS Storage Class.
     * </p>
     * </li>
     * </ul>
     * </note>
     * <p>
     * If the service returns an enum value that is not available in the current SDK version, {@link #storageClass} will
     * return {@link StorageClass#UNKNOWN_TO_SDK_VERSION}. The raw value returned by the service is available from
     * {@link #storageClassAsString}.
     * </p>
     * 
     * @return By default, Amazon S3 uses the STANDARD Storage Class to store newly created objects. The STANDARD
     *         storage class provides high durability and high availability. Depending on performance needs, you can
     *         specify a different Storage Class. For more information, see <a
     *         href="https://docs.aws.amazon.com/AmazonS3/latest/dev/storage-class-intro.html">Storage Classes</a> in
     *         the <i>Amazon S3 User Guide</i>.</p> <note>
     *         <ul>
     *         <li>
     *         <p>
     *         Directory buckets only support <code>EXPRESS_ONEZONE</code> (the S3 Express One Zone storage class) in
     *         Availability Zones and <code>ONEZONE_IA</code> (the S3 One Zone-Infrequent Access storage class) in
     *         Dedicated Local Zones.
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         Amazon S3 on Outposts only uses the OUTPOSTS Storage Class.
     *         </p>
     *         </li>
     *         </ul>
     * @see StorageClass
     */
    public final StorageClass storageClass() {
        return StorageClass.fromValue(storageClass);
    }

    /**
     * <p>
     * By default, Amazon S3 uses the STANDARD Storage Class to store newly created objects. The STANDARD storage class
     * provides high durability and high availability. Depending on performance needs, you can specify a different
     * Storage Class. For more information, see <a
     * href="https://docs.aws.amazon.com/AmazonS3/latest/dev/storage-class-intro.html">Storage Classes</a> in the
     * <i>Amazon S3 User Guide</i>.
     * </p>
     * <note>
     * <ul>
     * <li>
     * <p>
     * Directory buckets only support <code>EXPRESS_ONEZONE</code> (the S3 Express One Zone storage class) in
     * Availability Zones and <code>ONEZONE_IA</code> (the S3 One Zone-Infrequent Access storage class) in Dedicated
     * Local Zones.
     * </p>
     * </li>
     * <li>
     * <p>
     * Amazon S3 on Outposts only uses the OUTPOSTS Storage Class.
     * </p>
     * </li>
     * </ul>
     * </note>
     * <p>
     * If the service returns an enum value that is not available in the current SDK version, {@link #storageClass} will
     * return {@link StorageClass#UNKNOWN_TO_SDK_VERSION}. The raw value returned by the service is available from
     * {@link #storageClassAsString}.
     * </p>
     * 
     * @return By default, Amazon S3 uses the STANDARD Storage Class to store newly created objects. The STANDARD
     *         storage class provides high durability and high availability. Depending on performance needs, you can
     *         specify a different Storage Class. For more information, see <a
     *         href="https://docs.aws.amazon.com/AmazonS3/latest/dev/storage-class-intro.html">Storage Classes</a> in
     *         the <i>Amazon S3 User Guide</i>.</p> <note>
     *         <ul>
     *         <li>
     *         <p>
     *         Directory buckets only support <code>EXPRESS_ONEZONE</code> (the S3 Express One Zone storage class) in
     *         Availability Zones and <code>ONEZONE_IA</code> (the S3 One Zone-Infrequent Access storage class) in
     *         Dedicated Local Zones.
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         Amazon S3 on Outposts only uses the OUTPOSTS Storage Class.
     *         </p>
     *         </li>
     *         </ul>
     * @see StorageClass
     */
    public final String storageClassAsString() {
        return storageClass;
    }

    /**
     * <p>
     * If the bucket is configured as a website, redirects requests for this object to another object in the same bucket
     * or to an external URL. Amazon S3 stores the value of this header in the object metadata. For information about
     * object metadata, see <a href="https://docs.aws.amazon.com/AmazonS3/latest/dev/UsingMetadata.html">Object Key and
     * Metadata</a> in the <i>Amazon S3 User Guide</i>.
     * </p>
     * <p>
     * In the following example, the request header sets the redirect to an object (anotherPage.html) in the same
     * bucket:
     * </p>
     * <p>
     * <code>x-amz-website-redirect-location: /anotherPage.html</code>
     * </p>
     * <p>
     * In the following example, the request header sets the object redirect to another website:
     * </p>
     * <p>
     * <code>x-amz-website-redirect-location: http://www.example.com/</code>
     * </p>
     * <p>
     * For more information about website hosting in Amazon S3, see <a
     * href="https://docs.aws.amazon.com/AmazonS3/latest/dev/WebsiteHosting.html">Hosting Websites on Amazon S3</a> and
     * <a href="https://docs.aws.amazon.com/AmazonS3/latest/dev/how-to-page-redirect.html">How to Configure Website Page
     * Redirects</a> in the <i>Amazon S3 User Guide</i>.
     * </p>
     * <note>
     * <p>
     * This functionality is not supported for directory buckets.
     * </p>
     * </note>
     * 
     * @return If the bucket is configured as a website, redirects requests for this object to another object in the
     *         same bucket or to an external URL. Amazon S3 stores the value of this header in the object metadata. For
     *         information about object metadata, see <a
     *         href="https://docs.aws.amazon.com/AmazonS3/latest/dev/UsingMetadata.html">Object Key and Metadata</a> in
     *         the <i>Amazon S3 User Guide</i>.</p>
     *         <p>
     *         In the following example, the request header sets the redirect to an object (anotherPage.html) in the
     *         same bucket:
     *         </p>
     *         <p>
     *         <code>x-amz-website-redirect-location: /anotherPage.html</code>
     *         </p>
     *         <p>
     *         In the following example, the request header sets the object redirect to another website:
     *         </p>
     *         <p>
     *         <code>x-amz-website-redirect-location: http://www.example.com/</code>
     *         </p>
     *         <p>
     *         For more information about website hosting in Amazon S3, see <a
     *         href="https://docs.aws.amazon.com/AmazonS3/latest/dev/WebsiteHosting.html">Hosting Websites on Amazon
     *         S3</a> and <a href="https://docs.aws.amazon.com/AmazonS3/latest/dev/how-to-page-redirect.html">How to
     *         Configure Website Page Redirects</a> in the <i>Amazon S3 User Guide</i>.
     *         </p>
     *         <note>
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
     * <note>
     * <p>
     * This functionality is not supported for directory buckets.
     * </p>
     * </note>
     * 
     * @return Specifies the algorithm to use when encrypting the object (for example, <code>AES256</code>).</p> <note>
     *         <p>
     *         This functionality is not supported for directory buckets.
     *         </p>
     */
    public final String sseCustomerAlgorithm() {
        return sseCustomerAlgorithm;
    }

    /**
     * <p>
     * Specifies the customer-provided encryption key for Amazon S3 to use in encrypting data. This value is used to
     * store the object and then it is discarded; Amazon S3 does not store the encryption key. The key must be
     * appropriate for use with the algorithm specified in the
     * <code>x-amz-server-side-encryption-customer-algorithm</code> header.
     * </p>
     * <note>
     * <p>
     * This functionality is not supported for directory buckets.
     * </p>
     * </note>
     * 
     * @return Specifies the customer-provided encryption key for Amazon S3 to use in encrypting data. This value is
     *         used to store the object and then it is discarded; Amazon S3 does not store the encryption key. The key
     *         must be appropriate for use with the algorithm specified in the
     *         <code>x-amz-server-side-encryption-customer-algorithm</code> header.</p> <note>
     *         <p>
     *         This functionality is not supported for directory buckets.
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
     * This functionality is not supported for directory buckets.
     * </p>
     * </note>
     * 
     * @return Specifies the 128-bit MD5 digest of the encryption key according to RFC 1321. Amazon S3 uses this header
     *         for a message integrity check to ensure that the encryption key was transmitted without error.</p> <note>
     *         <p>
     *         This functionality is not supported for directory buckets.
     *         </p>
     */
    public final String sseCustomerKeyMD5() {
        return sseCustomerKeyMD5;
    }

    /**
     * <p>
     * Specifies the KMS key ID (Key ID, Key ARN, or Key Alias) to use for object encryption. If the KMS key doesn't
     * exist in the same account that's issuing the command, you must use the full Key ARN not the Key ID.
     * </p>
     * <p>
     * <b>General purpose buckets</b> - If you specify <code>x-amz-server-side-encryption</code> with
     * <code>aws:kms</code> or <code>aws:kms:dsse</code>, this header specifies the ID (Key ID, Key ARN, or Key Alias)
     * of the KMS key to use. If you specify <code>x-amz-server-side-encryption:aws:kms</code> or
     * <code>x-amz-server-side-encryption:aws:kms:dsse</code>, but do not provide
     * <code>x-amz-server-side-encryption-aws-kms-key-id</code>, Amazon S3 uses the Amazon Web Services managed key (
     * <code>aws/s3</code>) to protect the data.
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
     * @return Specifies the KMS key ID (Key ID, Key ARN, or Key Alias) to use for object encryption. If the KMS key
     *         doesn't exist in the same account that's issuing the command, you must use the full Key ARN not the Key
     *         ID.</p>
     *         <p>
     *         <b>General purpose buckets</b> - If you specify <code>x-amz-server-side-encryption</code> with
     *         <code>aws:kms</code> or <code>aws:kms:dsse</code>, this header specifies the ID (Key ID, Key ARN, or Key
     *         Alias) of the KMS key to use. If you specify <code>x-amz-server-side-encryption:aws:kms</code> or
     *         <code>x-amz-server-side-encryption:aws:kms:dsse</code>, but do not provide
     *         <code>x-amz-server-side-encryption-aws-kms-key-id</code>, Amazon S3 uses the Amazon Web Services managed
     *         key (<code>aws/s3</code>) to protect the data.
     *         </p>
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
     * Specifies the Amazon Web Services KMS Encryption Context as an additional encryption context to use for object
     * encryption. The value of this header is a Base64 encoded string of a UTF-8 encoded JSON, which contains the
     * encryption context as key-value pairs. This value is stored as object metadata and automatically gets passed on
     * to Amazon Web Services KMS for future <code>GetObject</code> operations on this object.
     * </p>
     * <p>
     * <b>General purpose buckets</b> - This value must be explicitly added during <code>CopyObject</code> operations if
     * you want an additional encryption context for your object. For more information, see <a
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
     *         object encryption. The value of this header is a Base64 encoded string of a UTF-8 encoded JSON, which
     *         contains the encryption context as key-value pairs. This value is stored as object metadata and
     *         automatically gets passed on to Amazon Web Services KMS for future <code>GetObject</code> operations on
     *         this object.</p>
     *         <p>
     *         <b>General purpose buckets</b> - This value must be explicitly added during <code>CopyObject</code>
     *         operations if you want an additional encryption context for your object. For more information, see <a
     *         href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/UsingKMSEncryption.html#encryption-context">
     *         Encryption context</a> in the <i>Amazon S3 User Guide</i>.
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
     * Key Management Service (KMS) keys (SSE-KMS).
     * </p>
     * <p>
     * <b>General purpose buckets</b> - Setting this header to <code>true</code> causes Amazon S3 to use an S3 Bucket
     * Key for object encryption with SSE-KMS. Also, specifying this header with a PUT action doesn't affect
     * bucket-level settings for S3 Bucket Key.
     * </p>
     * <p>
     * <b>Directory buckets</b> - S3 Bucket Keys are always enabled for <code>GET</code> and <code>PUT</code> operations
     * in a directory bucket and can’t be disabled. S3 Bucket Keys aren't supported, when you copy SSE-KMS encrypted
     * objects from general purpose buckets to directory buckets, from directory buckets to general purpose buckets, or
     * between directory buckets, through <a
     * href="https://docs.aws.amazon.com/AmazonS3/latest/API/API_CopyObject.html">CopyObject</a>, <a
     * href="https://docs.aws.amazon.com/AmazonS3/latest/API/API_UploadPartCopy.html">UploadPartCopy</a>, <a
     * href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/directory-buckets-objects-Batch-Ops">the Copy
     * operation in Batch Operations</a>, or <a
     * href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/create-import-job">the import jobs</a>. In this case,
     * Amazon S3 makes a call to KMS every time a copy request is made for a KMS-encrypted object.
     * </p>
     * 
     * @return Specifies whether Amazon S3 should use an S3 Bucket Key for object encryption with server-side encryption
     *         using Key Management Service (KMS) keys (SSE-KMS).</p>
     *         <p>
     *         <b>General purpose buckets</b> - Setting this header to <code>true</code> causes Amazon S3 to use an S3
     *         Bucket Key for object encryption with SSE-KMS. Also, specifying this header with a PUT action doesn't
     *         affect bucket-level settings for S3 Bucket Key.
     *         </p>
     *         <p>
     *         <b>Directory buckets</b> - S3 Bucket Keys are always enabled for <code>GET</code> and <code>PUT</code>
     *         operations in a directory bucket and can’t be disabled. S3 Bucket Keys aren't supported, when you copy
     *         SSE-KMS encrypted objects from general purpose buckets to directory buckets, from directory buckets to
     *         general purpose buckets, or between directory buckets, through <a
     *         href="https://docs.aws.amazon.com/AmazonS3/latest/API/API_CopyObject.html">CopyObject</a>, <a
     *         href="https://docs.aws.amazon.com/AmazonS3/latest/API/API_UploadPartCopy.html">UploadPartCopy</a>, <a
     *         href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/directory-buckets-objects-Batch-Ops">the Copy
     *         operation in Batch Operations</a>, or <a
     *         href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/create-import-job">the import jobs</a>. In
     *         this case, Amazon S3 makes a call to KMS every time a copy request is made for a KMS-encrypted object.
     */
    public final Boolean bucketKeyEnabled() {
        return bucketKeyEnabled;
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
     * The tag-set for the object. The tag-set must be encoded as URL Query parameters. (For example, "Key1=Value1")
     * </p>
     * <note>
     * <p>
     * This functionality is not supported for directory buckets.
     * </p>
     * </note>
     * 
     * @return The tag-set for the object. The tag-set must be encoded as URL Query parameters. (For example,
     *         "Key1=Value1")</p> <note>
     *         <p>
     *         This functionality is not supported for directory buckets.
     *         </p>
     */
    public final String tagging() {
        return tagging;
    }

    /**
     * <p>
     * The Object Lock mode that you want to apply to this object.
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
     * @return The Object Lock mode that you want to apply to this object.</p> <note>
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
     * The Object Lock mode that you want to apply to this object.
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
     * @return The Object Lock mode that you want to apply to this object.</p> <note>
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
     * The date and time when you want this object's Object Lock to expire. Must be formatted as a timestamp parameter.
     * </p>
     * <note>
     * <p>
     * This functionality is not supported for directory buckets.
     * </p>
     * </note>
     * 
     * @return The date and time when you want this object's Object Lock to expire. Must be formatted as a timestamp
     *         parameter.</p> <note>
     *         <p>
     *         This functionality is not supported for directory buckets.
     *         </p>
     */
    public final Instant objectLockRetainUntilDate() {
        return objectLockRetainUntilDate;
    }

    /**
     * <p>
     * Specifies whether a legal hold will be applied to this object. For more information about S3 Object Lock, see <a
     * href="https://docs.aws.amazon.com/AmazonS3/latest/dev/object-lock.html">Object Lock</a> in the <i>Amazon S3 User
     * Guide</i>.
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
     * @return Specifies whether a legal hold will be applied to this object. For more information about S3 Object Lock,
     *         see <a href="https://docs.aws.amazon.com/AmazonS3/latest/dev/object-lock.html">Object Lock</a> in the
     *         <i>Amazon S3 User Guide</i>.</p> <note>
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
     * Specifies whether a legal hold will be applied to this object. For more information about S3 Object Lock, see <a
     * href="https://docs.aws.amazon.com/AmazonS3/latest/dev/object-lock.html">Object Lock</a> in the <i>Amazon S3 User
     * Guide</i>.
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
     * @return Specifies whether a legal hold will be applied to this object. For more information about S3 Object Lock,
     *         see <a href="https://docs.aws.amazon.com/AmazonS3/latest/dev/object-lock.html">Object Lock</a> in the
     *         <i>Amazon S3 User Guide</i>.</p> <note>
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
     * The account ID of the expected bucket owner. If the account ID that you provide does not match the actual owner
     * of the bucket, the request fails with the HTTP status code <code>403 Forbidden</code> (access denied).
     * </p>
     * 
     * @return The account ID of the expected bucket owner. If the account ID that you provide does not match the actual
     *         owner of the bucket, the request fails with the HTTP status code <code>403 Forbidden</code> (access
     *         denied).
     */
    public final String expectedBucketOwner() {
        return expectedBucketOwner;
    }

    public final Instant retentionExpirationDate() { return retentionExpirationDate; }

    public final String retentionLegalHoldId()  { return retentionLegalHoldId; }

    public final Long retentionPeriod() { return  retentionPeriod; }

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
        hashCode = 31 * hashCode + Objects.hashCode(bucket());
        hashCode = 31 * hashCode + Objects.hashCode(cacheControl());
        hashCode = 31 * hashCode + Objects.hashCode(contentDisposition());
        hashCode = 31 * hashCode + Objects.hashCode(contentEncoding());
        hashCode = 31 * hashCode + Objects.hashCode(contentLanguage());
        hashCode = 31 * hashCode + Objects.hashCode(contentLength());
        hashCode = 31 * hashCode + Objects.hashCode(contentMD5());
        hashCode = 31 * hashCode + Objects.hashCode(contentType());
        hashCode = 31 * hashCode + Objects.hashCode(checksumAlgorithmAsString());
        hashCode = 31 * hashCode + Objects.hashCode(checksumCRC32());
        hashCode = 31 * hashCode + Objects.hashCode(checksumCRC32C());
        hashCode = 31 * hashCode + Objects.hashCode(checksumCRC64NVME());
        hashCode = 31 * hashCode + Objects.hashCode(checksumSHA1());
        hashCode = 31 * hashCode + Objects.hashCode(checksumSHA256());
        hashCode = 31 * hashCode + Objects.hashCode(expires());
        hashCode = 31 * hashCode + Objects.hashCode(ifMatch());
        hashCode = 31 * hashCode + Objects.hashCode(ifNoneMatch());
        hashCode = 31 * hashCode + Objects.hashCode(grantFullControl());
        hashCode = 31 * hashCode + Objects.hashCode(grantRead());
        hashCode = 31 * hashCode + Objects.hashCode(grantReadACP());
        hashCode = 31 * hashCode + Objects.hashCode(grantWriteACP());
        hashCode = 31 * hashCode + Objects.hashCode(key());
        hashCode = 31 * hashCode + Objects.hashCode(writeOffsetBytes());
        hashCode = 31 * hashCode + Objects.hashCode(hasMetadata() ? metadata() : null);
        hashCode = 31 * hashCode + Objects.hashCode(serverSideEncryptionAsString());
        hashCode = 31 * hashCode + Objects.hashCode(storageClassAsString());
        hashCode = 31 * hashCode + Objects.hashCode(websiteRedirectLocation());
        hashCode = 31 * hashCode + Objects.hashCode(sseCustomerAlgorithm());
        hashCode = 31 * hashCode + Objects.hashCode(sseCustomerKey());
        hashCode = 31 * hashCode + Objects.hashCode(sseCustomerKeyMD5());
        hashCode = 31 * hashCode + Objects.hashCode(ssekmsKeyId());
        hashCode = 31 * hashCode + Objects.hashCode(ssekmsEncryptionContext());
        hashCode = 31 * hashCode + Objects.hashCode(bucketKeyEnabled());
        hashCode = 31 * hashCode + Objects.hashCode(requestPayerAsString());
        hashCode = 31 * hashCode + Objects.hashCode(tagging());
        hashCode = 31 * hashCode + Objects.hashCode(objectLockModeAsString());
        hashCode = 31 * hashCode + Objects.hashCode(objectLockRetainUntilDate());
        hashCode = 31 * hashCode + Objects.hashCode(objectLockLegalHoldStatusAsString());
        hashCode = 31 * hashCode + Objects.hashCode(expectedBucketOwner());
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
        if (!(obj instanceof PutObjectRequest)) {
            return false;
        }
        PutObjectRequest other = (PutObjectRequest) obj;
        return Objects.equals(aclAsString(), other.aclAsString()) && Objects.equals(bucket(), other.bucket())
                && Objects.equals(cacheControl(), other.cacheControl())
                && Objects.equals(contentDisposition(), other.contentDisposition())
                && Objects.equals(contentEncoding(), other.contentEncoding())
                && Objects.equals(contentLanguage(), other.contentLanguage())
                && Objects.equals(contentLength(), other.contentLength()) && Objects.equals(contentMD5(), other.contentMD5())
                && Objects.equals(contentType(), other.contentType())
                && Objects.equals(checksumAlgorithmAsString(), other.checksumAlgorithmAsString())
                && Objects.equals(checksumCRC32(), other.checksumCRC32())
                && Objects.equals(checksumCRC32C(), other.checksumCRC32C())
                && Objects.equals(checksumCRC64NVME(), other.checksumCRC64NVME())
                && Objects.equals(checksumSHA1(), other.checksumSHA1())
                && Objects.equals(checksumSHA256(), other.checksumSHA256()) && Objects.equals(expires(), other.expires())
                && Objects.equals(ifMatch(), other.ifMatch()) && Objects.equals(ifNoneMatch(), other.ifNoneMatch())
                && Objects.equals(grantFullControl(), other.grantFullControl()) && Objects.equals(grantRead(), other.grantRead())
                && Objects.equals(grantReadACP(), other.grantReadACP()) && Objects.equals(grantWriteACP(), other.grantWriteACP())
                && Objects.equals(key(), other.key()) && Objects.equals(writeOffsetBytes(), other.writeOffsetBytes())
                && hasMetadata() == other.hasMetadata() && Objects.equals(metadata(), other.metadata())
                && Objects.equals(serverSideEncryptionAsString(), other.serverSideEncryptionAsString())
                && Objects.equals(storageClassAsString(), other.storageClassAsString())
                && Objects.equals(websiteRedirectLocation(), other.websiteRedirectLocation())
                && Objects.equals(sseCustomerAlgorithm(), other.sseCustomerAlgorithm())
                && Objects.equals(sseCustomerKey(), other.sseCustomerKey())
                && Objects.equals(sseCustomerKeyMD5(), other.sseCustomerKeyMD5())
                && Objects.equals(ssekmsKeyId(), other.ssekmsKeyId())
                && Objects.equals(ssekmsEncryptionContext(), other.ssekmsEncryptionContext())
                && Objects.equals(bucketKeyEnabled(), other.bucketKeyEnabled())
                && Objects.equals(requestPayerAsString(), other.requestPayerAsString())
                && Objects.equals(tagging(), other.tagging())
                && Objects.equals(objectLockModeAsString(), other.objectLockModeAsString())
                && Objects.equals(objectLockRetainUntilDate(), other.objectLockRetainUntilDate())
                && Objects.equals(objectLockLegalHoldStatusAsString(), other.objectLockLegalHoldStatusAsString())
                && Objects.equals(expectedBucketOwner(), other.expectedBucketOwner())
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
        return ToString.builder("PutObjectRequest").add("ACL", aclAsString()).add("Bucket", bucket())
                .add("CacheControl", cacheControl()).add("ContentDisposition", contentDisposition())
                .add("ContentEncoding", contentEncoding()).add("ContentLanguage", contentLanguage())
                .add("ContentLength", contentLength()).add("ContentMD5", contentMD5()).add("ContentType", contentType())
                .add("ChecksumAlgorithm", checksumAlgorithmAsString()).add("ChecksumCRC32", checksumCRC32())
                .add("ChecksumCRC32C", checksumCRC32C()).add("ChecksumCRC64NVME", checksumCRC64NVME())
                .add("ChecksumSHA1", checksumSHA1()).add("ChecksumSHA256", checksumSHA256()).add("Expires", expires())
                .add("IfMatch", ifMatch()).add("IfNoneMatch", ifNoneMatch()).add("GrantFullControl", grantFullControl())
                .add("GrantRead", grantRead()).add("GrantReadACP", grantReadACP()).add("GrantWriteACP", grantWriteACP())
                .add("Key", key()).add("WriteOffsetBytes", writeOffsetBytes()).add("Metadata", hasMetadata() ? metadata() : null)
                .add("ServerSideEncryption", serverSideEncryptionAsString()).add("StorageClass", storageClassAsString())
                .add("WebsiteRedirectLocation", websiteRedirectLocation()).add("SSECustomerAlgorithm", sseCustomerAlgorithm())
                .add("SSECustomerKey", sseCustomerKey() == null ? null : "*** Sensitive Data Redacted ***")
                .add("SSECustomerKeyMD5", sseCustomerKeyMD5())
                .add("SSEKMSKeyId", ssekmsKeyId() == null ? null : "*** Sensitive Data Redacted ***")
                .add("SSEKMSEncryptionContext", ssekmsEncryptionContext() == null ? null : "*** Sensitive Data Redacted ***")
                .add("BucketKeyEnabled", bucketKeyEnabled()).add("RequestPayer", requestPayerAsString())
                .add("Tagging", tagging()).add("ObjectLockMode", objectLockModeAsString())
                .add("ObjectLockRetainUntilDate", objectLockRetainUntilDate())
                .add("ObjectLockLegalHoldStatus", objectLockLegalHoldStatusAsString())
                .add("ExpectedBucketOwner", expectedBucketOwner())
                .add("RetentionExpirationDate",retentionExpirationDate())
                .add("RetentionLegalHoldId",retentionLegalHoldId())
                .add("RetentionPeriod",retentionPeriod())
                       .build();

    }

    public final <T> Optional<T> getValueForField(String fieldName, Class<T> clazz) {
        switch (fieldName) {
        case "ACL":
            return Optional.ofNullable(clazz.cast(aclAsString()));
        case "Bucket":
            return Optional.ofNullable(clazz.cast(bucket()));
        case "CacheControl":
            return Optional.ofNullable(clazz.cast(cacheControl()));
        case "ContentDisposition":
            return Optional.ofNullable(clazz.cast(contentDisposition()));
        case "ContentEncoding":
            return Optional.ofNullable(clazz.cast(contentEncoding()));
        case "ContentLanguage":
            return Optional.ofNullable(clazz.cast(contentLanguage()));
        case "ContentLength":
            return Optional.ofNullable(clazz.cast(contentLength()));
        case "ContentMD5":
            return Optional.ofNullable(clazz.cast(contentMD5()));
        case "ContentType":
            return Optional.ofNullable(clazz.cast(contentType()));
        case "ChecksumAlgorithm":
            return Optional.ofNullable(clazz.cast(checksumAlgorithmAsString()));
        case "ChecksumCRC32":
            return Optional.ofNullable(clazz.cast(checksumCRC32()));
        case "ChecksumCRC32C":
            return Optional.ofNullable(clazz.cast(checksumCRC32C()));
        case "ChecksumCRC64NVME":
            return Optional.ofNullable(clazz.cast(checksumCRC64NVME()));
        case "ChecksumSHA1":
            return Optional.ofNullable(clazz.cast(checksumSHA1()));
        case "ChecksumSHA256":
            return Optional.ofNullable(clazz.cast(checksumSHA256()));
        case "Expires":
            return Optional.ofNullable(clazz.cast(expires()));
        case "IfMatch":
            return Optional.ofNullable(clazz.cast(ifMatch()));
        case "IfNoneMatch":
            return Optional.ofNullable(clazz.cast(ifNoneMatch()));
        case "GrantFullControl":
            return Optional.ofNullable(clazz.cast(grantFullControl()));
        case "GrantRead":
            return Optional.ofNullable(clazz.cast(grantRead()));
        case "GrantReadACP":
            return Optional.ofNullable(clazz.cast(grantReadACP()));
        case "GrantWriteACP":
            return Optional.ofNullable(clazz.cast(grantWriteACP()));
        case "Key":
            return Optional.ofNullable(clazz.cast(key()));
        case "WriteOffsetBytes":
            return Optional.ofNullable(clazz.cast(writeOffsetBytes()));
        case "Metadata":
            return Optional.ofNullable(clazz.cast(metadata()));
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
        case "RetentionExpirationDate":
                return  Optional.ofNullable(clazz.cast(retentionExpirationDate()));
        case "RetentionLegalHoldId" :
                return Optional.ofNullable(clazz.cast(retentionLegalHoldId()));
        case "RetentionPeriod" :
                return  Optional.ofNullable(clazz.cast(retentionPeriod()));
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
        map.put("Bucket", BUCKET_FIELD);
        map.put("Cache-Control", CACHE_CONTROL_FIELD);
        map.put("Content-Disposition", CONTENT_DISPOSITION_FIELD);
        map.put("Content-Encoding", CONTENT_ENCODING_FIELD);
        map.put("Content-Language", CONTENT_LANGUAGE_FIELD);
        map.put("Content-Length", CONTENT_LENGTH_FIELD);
        map.put("Content-MD5", CONTENT_MD5_FIELD);
        map.put("Content-Type", CONTENT_TYPE_FIELD);
        map.put("x-amz-sdk-checksum-algorithm", CHECKSUM_ALGORITHM_FIELD);
        map.put("x-amz-checksum-crc32", CHECKSUM_CRC32_FIELD);
        map.put("x-amz-checksum-crc32c", CHECKSUM_CRC32_C_FIELD);
        map.put("x-amz-checksum-crc64nvme", CHECKSUM_CRC64_NVME_FIELD);
        map.put("x-amz-checksum-sha1", CHECKSUM_SHA1_FIELD);
        map.put("x-amz-checksum-sha256", CHECKSUM_SHA256_FIELD);
        map.put("Expires", EXPIRES_FIELD);
        map.put("If-Match", IF_MATCH_FIELD);
        map.put("If-None-Match", IF_NONE_MATCH_FIELD);
        map.put("x-amz-grant-full-control", GRANT_FULL_CONTROL_FIELD);
        map.put("x-amz-grant-read", GRANT_READ_FIELD);
        map.put("x-amz-grant-read-acp", GRANT_READ_ACP_FIELD);
        map.put("x-amz-grant-write-acp", GRANT_WRITE_ACP_FIELD);
        map.put("Key", KEY_FIELD);
        map.put("x-amz-write-offset-bytes", WRITE_OFFSET_BYTES_FIELD);
        map.put("x-amz-meta-", METADATA_FIELD);
        map.put("x-amz-server-side-encryption", SERVER_SIDE_ENCRYPTION_FIELD);
        map.put("x-amz-storage-class", STORAGE_CLASS_FIELD);
        map.put("x-amz-website-redirect-location", WEBSITE_REDIRECT_LOCATION_FIELD);
        map.put("x-amz-server-side-encryption-customer-algorithm", SSE_CUSTOMER_ALGORITHM_FIELD);
        map.put("x-amz-server-side-encryption-customer-key", SSE_CUSTOMER_KEY_FIELD);
        map.put("x-amz-server-side-encryption-customer-key-MD5", SSE_CUSTOMER_KEY_MD5_FIELD);
        map.put("x-amz-server-side-encryption-aws-kms-key-id", SSEKMS_KEY_ID_FIELD);
        map.put("x-amz-server-side-encryption-context", SSEKMS_ENCRYPTION_CONTEXT_FIELD);
        map.put("x-amz-server-side-encryption-bucket-key-enabled", BUCKET_KEY_ENABLED_FIELD);
        map.put("x-amz-request-payer", REQUEST_PAYER_FIELD);
        map.put("x-amz-tagging", TAGGING_FIELD);
        map.put("x-amz-object-lock-mode", OBJECT_LOCK_MODE_FIELD);
        map.put("x-amz-object-lock-retain-until-date", OBJECT_LOCK_RETAIN_UNTIL_DATE_FIELD);
        map.put("x-amz-object-lock-legal-hold", OBJECT_LOCK_LEGAL_HOLD_STATUS_FIELD);
        map.put("x-amz-expected-bucket-owner", EXPECTED_BUCKET_OWNER_FIELD);
        map.put("retention-expiration-date", IBM_RETENTION_EXPIRATION_DATE_FIELD);
        map.put("retention-legal-hold-id", IBM_RETENTION_LEGAL_HOLD_ID_FIELD);
        map.put("retention-period", IBM_RETENTION_PERIOD_FIELD);
        return Collections.unmodifiableMap(map);
    }

    private static <T> Function<Object, T> getter(Function<PutObjectRequest, T> g) {
        return obj -> g.apply((PutObjectRequest) obj);
    }

    private static <T> BiConsumer<Object, T> setter(BiConsumer<Builder, T> s) {
        return (obj, val) -> s.accept((Builder) obj, val);
    }

    @Mutable
    @NotThreadSafe
    public interface Builder extends S3Request.Builder, SdkPojo, CopyableBuilder<Builder, PutObjectRequest> {
        /**
         * <p>
         * The canned ACL to apply to the object. For more information, see <a
         * href="https://docs.aws.amazon.com/AmazonS3/latest/dev/acl-overview.html#CannedACL">Canned ACL</a> in the
         * <i>Amazon S3 User Guide</i>.
         * </p>
         * <p>
         * When adding a new object, you can use headers to grant ACL-based permissions to individual Amazon Web
         * Services accounts or to predefined groups defined by Amazon S3. These permissions are then added to the ACL
         * on the object. By default, all objects are private. Only the owner has full access control. For more
         * information, see <a href="https://docs.aws.amazon.com/AmazonS3/latest/dev/acl-overview.html">Access Control
         * List (ACL) Overview</a> and <a
         * href="https://docs.aws.amazon.com/AmazonS3/latest/dev/acl-using-rest-api.html">Managing ACLs Using the REST
         * API</a> in the <i>Amazon S3 User Guide</i>.
         * </p>
         * <p>
         * If the bucket that you're uploading objects to uses the bucket owner enforced setting for S3 Object
         * Ownership, ACLs are disabled and no longer affect permissions. Buckets that use this setting only accept PUT
         * requests that don't specify an ACL or PUT requests that specify bucket owner full control ACLs, such as the
         * <code>bucket-owner-full-control</code> canned ACL or an equivalent form of this ACL expressed in the XML
         * format. PUT requests that contain other ACLs (for example, custom grants to certain Amazon Web Services
         * accounts) fail and return a <code>400</code> error with the error code
         * <code>AccessControlListNotSupported</code>. For more information, see <a
         * href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/about-object-ownership.html"> Controlling
         * ownership of objects and disabling ACLs</a> in the <i>Amazon S3 User Guide</i>.
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
         * @param acl
         *        The canned ACL to apply to the object. For more information, see <a
         *        href="https://docs.aws.amazon.com/AmazonS3/latest/dev/acl-overview.html#CannedACL">Canned ACL</a> in
         *        the <i>Amazon S3 User Guide</i>.</p>
         *        <p>
         *        When adding a new object, you can use headers to grant ACL-based permissions to individual Amazon Web
         *        Services accounts or to predefined groups defined by Amazon S3. These permissions are then added to
         *        the ACL on the object. By default, all objects are private. Only the owner has full access control.
         *        For more information, see <a
         *        href="https://docs.aws.amazon.com/AmazonS3/latest/dev/acl-overview.html">Access Control List (ACL)
         *        Overview</a> and <a
         *        href="https://docs.aws.amazon.com/AmazonS3/latest/dev/acl-using-rest-api.html">Managing ACLs Using the
         *        REST API</a> in the <i>Amazon S3 User Guide</i>.
         *        </p>
         *        <p>
         *        If the bucket that you're uploading objects to uses the bucket owner enforced setting for S3 Object
         *        Ownership, ACLs are disabled and no longer affect permissions. Buckets that use this setting only
         *        accept PUT requests that don't specify an ACL or PUT requests that specify bucket owner full control
         *        ACLs, such as the <code>bucket-owner-full-control</code> canned ACL or an equivalent form of this ACL
         *        expressed in the XML format. PUT requests that contain other ACLs (for example, custom grants to
         *        certain Amazon Web Services accounts) fail and return a <code>400</code> error with the error code
         *        <code>AccessControlListNotSupported</code>. For more information, see <a
         *        href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/about-object-ownership.html"> Controlling
         *        ownership of objects and disabling ACLs</a> in the <i>Amazon S3 User Guide</i>.
         *        </p>
         *        <note>
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
         * @see ObjectCannedACL
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see ObjectCannedACL
         */
        Builder acl(String acl);

        /**
         * <p>
         * The canned ACL to apply to the object. For more information, see <a
         * href="https://docs.aws.amazon.com/AmazonS3/latest/dev/acl-overview.html#CannedACL">Canned ACL</a> in the
         * <i>Amazon S3 User Guide</i>.
         * </p>
         * <p>
         * When adding a new object, you can use headers to grant ACL-based permissions to individual Amazon Web
         * Services accounts or to predefined groups defined by Amazon S3. These permissions are then added to the ACL
         * on the object. By default, all objects are private. Only the owner has full access control. For more
         * information, see <a href="https://docs.aws.amazon.com/AmazonS3/latest/dev/acl-overview.html">Access Control
         * List (ACL) Overview</a> and <a
         * href="https://docs.aws.amazon.com/AmazonS3/latest/dev/acl-using-rest-api.html">Managing ACLs Using the REST
         * API</a> in the <i>Amazon S3 User Guide</i>.
         * </p>
         * <p>
         * If the bucket that you're uploading objects to uses the bucket owner enforced setting for S3 Object
         * Ownership, ACLs are disabled and no longer affect permissions. Buckets that use this setting only accept PUT
         * requests that don't specify an ACL or PUT requests that specify bucket owner full control ACLs, such as the
         * <code>bucket-owner-full-control</code> canned ACL or an equivalent form of this ACL expressed in the XML
         * format. PUT requests that contain other ACLs (for example, custom grants to certain Amazon Web Services
         * accounts) fail and return a <code>400</code> error with the error code
         * <code>AccessControlListNotSupported</code>. For more information, see <a
         * href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/about-object-ownership.html"> Controlling
         * ownership of objects and disabling ACLs</a> in the <i>Amazon S3 User Guide</i>.
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
         * @param acl
         *        The canned ACL to apply to the object. For more information, see <a
         *        href="https://docs.aws.amazon.com/AmazonS3/latest/dev/acl-overview.html#CannedACL">Canned ACL</a> in
         *        the <i>Amazon S3 User Guide</i>.</p>
         *        <p>
         *        When adding a new object, you can use headers to grant ACL-based permissions to individual Amazon Web
         *        Services accounts or to predefined groups defined by Amazon S3. These permissions are then added to
         *        the ACL on the object. By default, all objects are private. Only the owner has full access control.
         *        For more information, see <a
         *        href="https://docs.aws.amazon.com/AmazonS3/latest/dev/acl-overview.html">Access Control List (ACL)
         *        Overview</a> and <a
         *        href="https://docs.aws.amazon.com/AmazonS3/latest/dev/acl-using-rest-api.html">Managing ACLs Using the
         *        REST API</a> in the <i>Amazon S3 User Guide</i>.
         *        </p>
         *        <p>
         *        If the bucket that you're uploading objects to uses the bucket owner enforced setting for S3 Object
         *        Ownership, ACLs are disabled and no longer affect permissions. Buckets that use this setting only
         *        accept PUT requests that don't specify an ACL or PUT requests that specify bucket owner full control
         *        ACLs, such as the <code>bucket-owner-full-control</code> canned ACL or an equivalent form of this ACL
         *        expressed in the XML format. PUT requests that contain other ACLs (for example, custom grants to
         *        certain Amazon Web Services accounts) fail and return a <code>400</code> error with the error code
         *        <code>AccessControlListNotSupported</code>. For more information, see <a
         *        href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/about-object-ownership.html"> Controlling
         *        ownership of objects and disabling ACLs</a> in the <i>Amazon S3 User Guide</i>.
         *        </p>
         *        <note>
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
         * @see ObjectCannedACL
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see ObjectCannedACL
         */
        Builder acl(ObjectCannedACL acl);

        /**
         * <p>
         * The bucket name to which the PUT action was initiated.
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
         * <b>S3 on Outposts</b> - When you use this action with S3 on Outposts, you must direct requests to the S3 on
         * Outposts hostname. The S3 on Outposts hostname takes the form
         * <code> <i>AccessPointName</i>-<i>AccountId</i>.<i>outpostID</i>.s3-outposts.<i>Region</i>.amazonaws.com</code>
         * . When you use this action with S3 on Outposts, the destination bucket must be the Outposts access point ARN
         * or the access point alias. For more information about S3 on Outposts, see <a
         * href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/S3onOutposts.html">What is S3 on Outposts?</a> in
         * the <i>Amazon S3 User Guide</i>.
         * </p>
         * 
         * @param bucket
         *        The bucket name to which the PUT action was initiated. </p>
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
         *        <b>S3 on Outposts</b> - When you use this action with S3 on Outposts, you must direct requests to the
         *        S3 on Outposts hostname. The S3 on Outposts hostname takes the form
         *        <code> <i>AccessPointName</i>-<i>AccountId</i>.<i>outpostID</i>.s3-outposts.<i>Region</i>.amazonaws.com</code>
         *        . When you use this action with S3 on Outposts, the destination bucket must be the Outposts access
         *        point ARN or the access point alias. For more information about S3 on Outposts, see <a
         *        href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/S3onOutposts.html">What is S3 on
         *        Outposts?</a> in the <i>Amazon S3 User Guide</i>.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder bucket(String bucket);

        /**
         * <p>
         * Can be used to specify caching behavior along the request/reply chain. For more information, see <a
         * href="http://www.w3.org/Protocols/rfc2616/rfc2616-sec14.html#sec14.9"
         * >http://www.w3.org/Protocols/rfc2616/rfc2616-sec14.html#sec14.9</a>.
         * </p>
         * 
         * @param cacheControl
         *        Can be used to specify caching behavior along the request/reply chain. For more information, see <a
         *        href
         *        ="http://www.w3.org/Protocols/rfc2616/rfc2616-sec14.html#sec14.9">http://www.w3.org/Protocols/rfc2616
         *        /rfc2616-sec14.html#sec14.9</a>.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder cacheControl(String cacheControl);

        /**
         * <p>
         * Specifies presentational information for the object. For more information, see <a
         * href="https://www.rfc-editor.org/rfc/rfc6266#section-4">https://www.rfc-editor.org/rfc/rfc6266#section-4</a>.
         * </p>
         * 
         * @param contentDisposition
         *        Specifies presentational information for the object. For more information, see <a
         *        href="https://www.rfc-editor.org/rfc/rfc6266#section-4"
         *        >https://www.rfc-editor.org/rfc/rfc6266#section-4</a>.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder contentDisposition(String contentDisposition);

        /**
         * <p>
         * Specifies what content encodings have been applied to the object and thus what decoding mechanisms must be
         * applied to obtain the media-type referenced by the Content-Type header field. For more information, see <a
         * href
         * ="https://www.rfc-editor.org/rfc/rfc9110.html#field.content-encoding">https://www.rfc-editor.org/rfc/rfc9110
         * .html#field.content-encoding</a>.
         * </p>
         * 
         * @param contentEncoding
         *        Specifies what content encodings have been applied to the object and thus what decoding mechanisms
         *        must be applied to obtain the media-type referenced by the Content-Type header field. For more
         *        information, see <a
         *        href="https://www.rfc-editor.org/rfc/rfc9110.html#field.content-encoding">https://www
         *        .rfc-editor.org/rfc/rfc9110.html#field.content-encoding</a>.
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
         * Size of the body in bytes. This parameter is useful when the size of the body cannot be determined
         * automatically. For more information, see <a
         * href="https://www.rfc-editor.org/rfc/rfc9110.html#name-content-length"
         * >https://www.rfc-editor.org/rfc/rfc9110.html#name-content-length</a>.
         * </p>
         * 
         * @param contentLength
         *        Size of the body in bytes. This parameter is useful when the size of the body cannot be determined
         *        automatically. For more information, see <a
         *        href="https://www.rfc-editor.org/rfc/rfc9110.html#name-content-length"
         *        >https://www.rfc-editor.org/rfc/rfc9110.html#name-content-length</a>.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder contentLength(Long contentLength);

        /**
         * <p>
         * The Base64 encoded 128-bit <code>MD5</code> digest of the message (without the headers) according to RFC
         * 1864. This header can be used as a message integrity check to verify that the data is the same data that was
         * originally sent. Although it is optional, we recommend using the Content-MD5 mechanism as an end-to-end
         * integrity check. For more information about REST request authentication, see <a
         * href="https://docs.aws.amazon.com/AmazonS3/latest/dev/RESTAuthentication.html">REST Authentication</a>.
         * </p>
         * <note>
         * <p>
         * The <code>Content-MD5</code> or <code>x-amz-sdk-checksum-algorithm</code> header is required for any request
         * to upload an object with a retention period configured using Amazon S3 Object Lock. For more information, see
         * <a href=
         * "https://docs.aws.amazon.com/AmazonS3/latest/userguide/object-lock-managing.html#object-lock-put-object"
         * >Uploading objects to an Object Lock enabled bucket </a> in the <i>Amazon S3 User Guide</i>.
         * </p>
         * </note> <note>
         * <p>
         * This functionality is not supported for directory buckets.
         * </p>
         * </note>
         * 
         * @param contentMD5
         *        The Base64 encoded 128-bit <code>MD5</code> digest of the message (without the headers) according to
         *        RFC 1864. This header can be used as a message integrity check to verify that the data is the same
         *        data that was originally sent. Although it is optional, we recommend using the Content-MD5 mechanism
         *        as an end-to-end integrity check. For more information about REST request authentication, see <a
         *        href="https://docs.aws.amazon.com/AmazonS3/latest/dev/RESTAuthentication.html">REST
         *        Authentication</a>.</p> <note>
         *        <p>
         *        The <code>Content-MD5</code> or <code>x-amz-sdk-checksum-algorithm</code> header is required for any
         *        request to upload an object with a retention period configured using Amazon S3 Object Lock. For more
         *        information, see <a href=
         *        "https://docs.aws.amazon.com/AmazonS3/latest/userguide/object-lock-managing.html#object-lock-put-object"
         *        >Uploading objects to an Object Lock enabled bucket </a> in the <i>Amazon S3 User Guide</i>.
         *        </p>
         *        </note> <note>
         *        <p>
         *        This functionality is not supported for directory buckets.
         *        </p>
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder contentMD5(String contentMD5);

        /**
         * <p>
         * A standard MIME type describing the format of the contents. For more information, see <a
         * href="https://www.rfc-editor.org/rfc/rfc9110.html#name-content-type"
         * >https://www.rfc-editor.org/rfc/rfc9110.html#name-content-type</a>.
         * </p>
         * 
         * @param contentType
         *        A standard MIME type describing the format of the contents. For more information, see <a
         *        href="https://www.rfc-editor.org/rfc/rfc9110.html#name-content-type"
         *        >https://www.rfc-editor.org/rfc/rfc9110.html#name-content-type</a>.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder contentType(String contentType);

        /**
         * <p>
         * Indicates the algorithm used to create the checksum for the object when you use the SDK. This header will not
         * provide any additional functionality if you don't use the SDK. When you send this header, there must be a
         * corresponding <code>x-amz-checksum-<i>algorithm</i> </code> or <code>x-amz-trailer</code> header sent.
         * Otherwise, Amazon S3 fails the request with the HTTP status code <code>400 Bad Request</code>.
         * </p>
         * <p>
         * For the <code>x-amz-checksum-<i>algorithm</i> </code> header, replace <code> <i>algorithm</i> </code> with
         * the supported algorithm from the following list:
         * </p>
         * <ul>
         * <li>
         * <p>
         * <code>CRC32</code>
         * </p>
         * </li>
         * <li>
         * <p>
         * <code>CRC32C</code>
         * </p>
         * </li>
         * <li>
         * <p>
         * <code>CRC64NVME</code>
         * </p>
         * </li>
         * <li>
         * <p>
         * <code>SHA1</code>
         * </p>
         * </li>
         * <li>
         * <p>
         * <code>SHA256</code>
         * </p>
         * </li>
         * </ul>
         * <p>
         * For more information, see <a
         * href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/checking-object-integrity.html">Checking object
         * integrity</a> in the <i>Amazon S3 User Guide</i>.
         * </p>
         * <p>
         * If the individual checksum value you provide through <code>x-amz-checksum-<i>algorithm</i> </code> doesn't
         * match the checksum algorithm you set through <code>x-amz-sdk-checksum-algorithm</code>, Amazon S3 fails the
         * request with a <code>BadDigest</code> error.
         * </p>
         * <note>
         * <p>
         * The <code>Content-MD5</code> or <code>x-amz-sdk-checksum-algorithm</code> header is required for any request
         * to upload an object with a retention period configured using Amazon S3 Object Lock. For more information, see
         * <a href=
         * "https://docs.aws.amazon.com/AmazonS3/latest/userguide/object-lock-managing.html#object-lock-put-object"
         * >Uploading objects to an Object Lock enabled bucket </a> in the <i>Amazon S3 User Guide</i>.
         * </p>
         * </note>
         * <p>
         * For directory buckets, when you use Amazon Web Services SDKs, <code>CRC32</code> is the default checksum
         * algorithm that's used for performance.
         * </p>
         * 
         * @param checksumAlgorithm
         *        Indicates the algorithm used to create the checksum for the object when you use the SDK. This header
         *        will not provide any additional functionality if you don't use the SDK. When you send this header,
         *        there must be a corresponding <code>x-amz-checksum-<i>algorithm</i> </code> or
         *        <code>x-amz-trailer</code> header sent. Otherwise, Amazon S3 fails the request with the HTTP status
         *        code <code>400 Bad Request</code>.</p>
         *        <p>
         *        For the <code>x-amz-checksum-<i>algorithm</i> </code> header, replace <code> <i>algorithm</i> </code>
         *        with the supported algorithm from the following list:
         *        </p>
         *        <ul>
         *        <li>
         *        <p>
         *        <code>CRC32</code>
         *        </p>
         *        </li>
         *        <li>
         *        <p>
         *        <code>CRC32C</code>
         *        </p>
         *        </li>
         *        <li>
         *        <p>
         *        <code>CRC64NVME</code>
         *        </p>
         *        </li>
         *        <li>
         *        <p>
         *        <code>SHA1</code>
         *        </p>
         *        </li>
         *        <li>
         *        <p>
         *        <code>SHA256</code>
         *        </p>
         *        </li>
         *        </ul>
         *        <p>
         *        For more information, see <a
         *        href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/checking-object-integrity.html">Checking
         *        object integrity</a> in the <i>Amazon S3 User Guide</i>.
         *        </p>
         *        <p>
         *        If the individual checksum value you provide through <code>x-amz-checksum-<i>algorithm</i> </code>
         *        doesn't match the checksum algorithm you set through <code>x-amz-sdk-checksum-algorithm</code>, Amazon
         *        S3 fails the request with a <code>BadDigest</code> error.
         *        </p>
         *        <note>
         *        <p>
         *        The <code>Content-MD5</code> or <code>x-amz-sdk-checksum-algorithm</code> header is required for any
         *        request to upload an object with a retention period configured using Amazon S3 Object Lock. For more
         *        information, see <a href=
         *        "https://docs.aws.amazon.com/AmazonS3/latest/userguide/object-lock-managing.html#object-lock-put-object"
         *        >Uploading objects to an Object Lock enabled bucket </a> in the <i>Amazon S3 User Guide</i>.
         *        </p>
         *        </note>
         *        <p>
         *        For directory buckets, when you use Amazon Web Services SDKs, <code>CRC32</code> is the default
         *        checksum algorithm that's used for performance.
         * @see ChecksumAlgorithm
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see ChecksumAlgorithm
         */
        Builder checksumAlgorithm(String checksumAlgorithm);

        /**
         * <p>
         * Indicates the algorithm used to create the checksum for the object when you use the SDK. This header will not
         * provide any additional functionality if you don't use the SDK. When you send this header, there must be a
         * corresponding <code>x-amz-checksum-<i>algorithm</i> </code> or <code>x-amz-trailer</code> header sent.
         * Otherwise, Amazon S3 fails the request with the HTTP status code <code>400 Bad Request</code>.
         * </p>
         * <p>
         * For the <code>x-amz-checksum-<i>algorithm</i> </code> header, replace <code> <i>algorithm</i> </code> with
         * the supported algorithm from the following list:
         * </p>
         * <ul>
         * <li>
         * <p>
         * <code>CRC32</code>
         * </p>
         * </li>
         * <li>
         * <p>
         * <code>CRC32C</code>
         * </p>
         * </li>
         * <li>
         * <p>
         * <code>CRC64NVME</code>
         * </p>
         * </li>
         * <li>
         * <p>
         * <code>SHA1</code>
         * </p>
         * </li>
         * <li>
         * <p>
         * <code>SHA256</code>
         * </p>
         * </li>
         * </ul>
         * <p>
         * For more information, see <a
         * href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/checking-object-integrity.html">Checking object
         * integrity</a> in the <i>Amazon S3 User Guide</i>.
         * </p>
         * <p>
         * If the individual checksum value you provide through <code>x-amz-checksum-<i>algorithm</i> </code> doesn't
         * match the checksum algorithm you set through <code>x-amz-sdk-checksum-algorithm</code>, Amazon S3 fails the
         * request with a <code>BadDigest</code> error.
         * </p>
         * <note>
         * <p>
         * The <code>Content-MD5</code> or <code>x-amz-sdk-checksum-algorithm</code> header is required for any request
         * to upload an object with a retention period configured using Amazon S3 Object Lock. For more information, see
         * <a href=
         * "https://docs.aws.amazon.com/AmazonS3/latest/userguide/object-lock-managing.html#object-lock-put-object"
         * >Uploading objects to an Object Lock enabled bucket </a> in the <i>Amazon S3 User Guide</i>.
         * </p>
         * </note>
         * <p>
         * For directory buckets, when you use Amazon Web Services SDKs, <code>CRC32</code> is the default checksum
         * algorithm that's used for performance.
         * </p>
         * 
         * @param checksumAlgorithm
         *        Indicates the algorithm used to create the checksum for the object when you use the SDK. This header
         *        will not provide any additional functionality if you don't use the SDK. When you send this header,
         *        there must be a corresponding <code>x-amz-checksum-<i>algorithm</i> </code> or
         *        <code>x-amz-trailer</code> header sent. Otherwise, Amazon S3 fails the request with the HTTP status
         *        code <code>400 Bad Request</code>.</p>
         *        <p>
         *        For the <code>x-amz-checksum-<i>algorithm</i> </code> header, replace <code> <i>algorithm</i> </code>
         *        with the supported algorithm from the following list:
         *        </p>
         *        <ul>
         *        <li>
         *        <p>
         *        <code>CRC32</code>
         *        </p>
         *        </li>
         *        <li>
         *        <p>
         *        <code>CRC32C</code>
         *        </p>
         *        </li>
         *        <li>
         *        <p>
         *        <code>CRC64NVME</code>
         *        </p>
         *        </li>
         *        <li>
         *        <p>
         *        <code>SHA1</code>
         *        </p>
         *        </li>
         *        <li>
         *        <p>
         *        <code>SHA256</code>
         *        </p>
         *        </li>
         *        </ul>
         *        <p>
         *        For more information, see <a
         *        href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/checking-object-integrity.html">Checking
         *        object integrity</a> in the <i>Amazon S3 User Guide</i>.
         *        </p>
         *        <p>
         *        If the individual checksum value you provide through <code>x-amz-checksum-<i>algorithm</i> </code>
         *        doesn't match the checksum algorithm you set through <code>x-amz-sdk-checksum-algorithm</code>, Amazon
         *        S3 fails the request with a <code>BadDigest</code> error.
         *        </p>
         *        <note>
         *        <p>
         *        The <code>Content-MD5</code> or <code>x-amz-sdk-checksum-algorithm</code> header is required for any
         *        request to upload an object with a retention period configured using Amazon S3 Object Lock. For more
         *        information, see <a href=
         *        "https://docs.aws.amazon.com/AmazonS3/latest/userguide/object-lock-managing.html#object-lock-put-object"
         *        >Uploading objects to an Object Lock enabled bucket </a> in the <i>Amazon S3 User Guide</i>.
         *        </p>
         *        </note>
         *        <p>
         *        For directory buckets, when you use Amazon Web Services SDKs, <code>CRC32</code> is the default
         *        checksum algorithm that's used for performance.
         * @see ChecksumAlgorithm
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see ChecksumAlgorithm
         */
        Builder checksumAlgorithm(ChecksumAlgorithm checksumAlgorithm);

        /**
         * <p>
         * This header can be used as a data integrity check to verify that the data received is the same data that was
         * originally sent. This header specifies the Base64 encoded, 32-bit <code>CRC32</code> checksum of the object.
         * For more information, see <a
         * href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/checking-object-integrity.html">Checking object
         * integrity</a> in the <i>Amazon S3 User Guide</i>.
         * </p>
         * 
         * @param checksumCRC32
         *        This header can be used as a data integrity check to verify that the data received is the same data
         *        that was originally sent. This header specifies the Base64 encoded, 32-bit <code>CRC32</code> checksum
         *        of the object. For more information, see <a
         *        href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/checking-object-integrity.html">Checking
         *        object integrity</a> in the <i>Amazon S3 User Guide</i>.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder checksumCRC32(String checksumCRC32);

        /**
         * <p>
         * This header can be used as a data integrity check to verify that the data received is the same data that was
         * originally sent. This header specifies the Base64 encoded, 32-bit <code>CRC32C</code> checksum of the object.
         * For more information, see <a
         * href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/checking-object-integrity.html">Checking object
         * integrity</a> in the <i>Amazon S3 User Guide</i>.
         * </p>
         * 
         * @param checksumCRC32C
         *        This header can be used as a data integrity check to verify that the data received is the same data
         *        that was originally sent. This header specifies the Base64 encoded, 32-bit <code>CRC32C</code>
         *        checksum of the object. For more information, see <a
         *        href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/checking-object-integrity.html">Checking
         *        object integrity</a> in the <i>Amazon S3 User Guide</i>.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder checksumCRC32C(String checksumCRC32C);

        /**
         * <p>
         * This header can be used as a data integrity check to verify that the data received is the same data that was
         * originally sent. This header specifies the Base64 encoded, 64-bit <code>CRC64NVME</code> checksum of the
         * object. The <code>CRC64NVME</code> checksum is always a full object checksum. For more information, see <a
         * href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/checking-object-integrity.html">Checking object
         * integrity in the Amazon S3 User Guide</a>.
         * </p>
         * 
         * @param checksumCRC64NVME
         *        This header can be used as a data integrity check to verify that the data received is the same data
         *        that was originally sent. This header specifies the Base64 encoded, 64-bit <code>CRC64NVME</code>
         *        checksum of the object. The <code>CRC64NVME</code> checksum is always a full object checksum. For more
         *        information, see <a
         *        href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/checking-object-integrity.html">Checking
         *        object integrity in the Amazon S3 User Guide</a>.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder checksumCRC64NVME(String checksumCRC64NVME);

        /**
         * <p>
         * This header can be used as a data integrity check to verify that the data received is the same data that was
         * originally sent. This header specifies the Base64 encoded, 160-bit <code>SHA1</code> digest of the object.
         * For more information, see <a
         * href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/checking-object-integrity.html">Checking object
         * integrity</a> in the <i>Amazon S3 User Guide</i>.
         * </p>
         * 
         * @param checksumSHA1
         *        This header can be used as a data integrity check to verify that the data received is the same data
         *        that was originally sent. This header specifies the Base64 encoded, 160-bit <code>SHA1</code> digest
         *        of the object. For more information, see <a
         *        href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/checking-object-integrity.html">Checking
         *        object integrity</a> in the <i>Amazon S3 User Guide</i>.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder checksumSHA1(String checksumSHA1);

        /**
         * <p>
         * This header can be used as a data integrity check to verify that the data received is the same data that was
         * originally sent. This header specifies the Base64 encoded, 256-bit <code>SHA256</code> digest of the object.
         * For more information, see <a
         * href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/checking-object-integrity.html">Checking object
         * integrity</a> in the <i>Amazon S3 User Guide</i>.
         * </p>
         * 
         * @param checksumSHA256
         *        This header can be used as a data integrity check to verify that the data received is the same data
         *        that was originally sent. This header specifies the Base64 encoded, 256-bit <code>SHA256</code> digest
         *        of the object. For more information, see <a
         *        href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/checking-object-integrity.html">Checking
         *        object integrity</a> in the <i>Amazon S3 User Guide</i>.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder checksumSHA256(String checksumSHA256);

        /**
         * <p>
         * The date and time at which the object is no longer cacheable. For more information, see <a
         * href="https://www.rfc-editor.org/rfc/rfc7234#section-5.3"
         * >https://www.rfc-editor.org/rfc/rfc7234#section-5.3</a>.
         * </p>
         * 
         * @param expires
         *        The date and time at which the object is no longer cacheable. For more information, see <a
         *        href="https://www.rfc-editor.org/rfc/rfc7234#section-5.3"
         *        >https://www.rfc-editor.org/rfc/rfc7234#section-5.3</a>.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder expires(Instant expires);

        /**
         * <p>
         * Uploads the object only if the ETag (entity tag) value provided during the WRITE operation matches the ETag
         * of the object in S3. If the ETag values do not match, the operation returns a
         * <code>412 Precondition Failed</code> error.
         * </p>
         * <p>
         * If a conflicting operation occurs during the upload S3 returns a <code>409 ConditionalRequestConflict</code>
         * response. On a 409 failure you should fetch the object's ETag and retry the upload.
         * </p>
         * <p>
         * Expects the ETag value as a string.
         * </p>
         * <p>
         * For more information about conditional requests, see <a href="https://tools.ietf.org/html/rfc7232">RFC
         * 7232</a>, or <a
         * href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/conditional-requests.html">Conditional
         * requests</a> in the <i>Amazon S3 User Guide</i>.
         * </p>
         * 
         * @param ifMatch
         *        Uploads the object only if the ETag (entity tag) value provided during the WRITE operation matches the
         *        ETag of the object in S3. If the ETag values do not match, the operation returns a
         *        <code>412 Precondition Failed</code> error.</p>
         *        <p>
         *        If a conflicting operation occurs during the upload S3 returns a
         *        <code>409 ConditionalRequestConflict</code> response. On a 409 failure you should fetch the object's
         *        ETag and retry the upload.
         *        </p>
         *        <p>
         *        Expects the ETag value as a string.
         *        </p>
         *        <p>
         *        For more information about conditional requests, see <a href="https://tools.ietf.org/html/rfc7232">RFC
         *        7232</a>, or <a
         *        href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/conditional-requests.html">Conditional
         *        requests</a> in the <i>Amazon S3 User Guide</i>.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder ifMatch(String ifMatch);

        /**
         * <p>
         * Uploads the object only if the object key name does not already exist in the bucket specified. Otherwise,
         * Amazon S3 returns a <code>412 Precondition Failed</code> error.
         * </p>
         * <p>
         * If a conflicting operation occurs during the upload S3 returns a <code>409 ConditionalRequestConflict</code>
         * response. On a 409 failure you should retry the upload.
         * </p>
         * <p>
         * Expects the '*' (asterisk) character.
         * </p>
         * <p>
         * For more information about conditional requests, see <a href="https://tools.ietf.org/html/rfc7232">RFC
         * 7232</a>, or <a
         * href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/conditional-requests.html">Conditional
         * requests</a> in the <i>Amazon S3 User Guide</i>.
         * </p>
         * 
         * @param ifNoneMatch
         *        Uploads the object only if the object key name does not already exist in the bucket specified.
         *        Otherwise, Amazon S3 returns a <code>412 Precondition Failed</code> error.</p>
         *        <p>
         *        If a conflicting operation occurs during the upload S3 returns a
         *        <code>409 ConditionalRequestConflict</code> response. On a 409 failure you should retry the upload.
         *        </p>
         *        <p>
         *        Expects the '*' (asterisk) character.
         *        </p>
         *        <p>
         *        For more information about conditional requests, see <a href="https://tools.ietf.org/html/rfc7232">RFC
         *        7232</a>, or <a
         *        href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/conditional-requests.html">Conditional
         *        requests</a> in the <i>Amazon S3 User Guide</i>.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder ifNoneMatch(String ifNoneMatch);

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
         * Object key for which the PUT action was initiated.
         * </p>
         * 
         * @param key
         *        Object key for which the PUT action was initiated.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder key(String key);

        /**
         * <p>
         * Specifies the offset for appending data to existing objects in bytes. The offset must be equal to the size of
         * the existing object being appended to. If no object exists, setting this header to 0 will create a new
         * object.
         * </p>
         * <note>
         * <p>
         * This functionality is only supported for objects in the Amazon S3 Express One Zone storage class in directory
         * buckets.
         * </p>
         * </note>
         * 
         * @param writeOffsetBytes
         *        Specifies the offset for appending data to existing objects in bytes. The offset must be equal to the
         *        size of the existing object being appended to. If no object exists, setting this header to 0 will
         *        create a new object. </p> <note>
         *        <p>
         *        This functionality is only supported for objects in the Amazon S3 Express One Zone storage class in
         *        directory buckets.
         *        </p>
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder writeOffsetBytes(Long writeOffsetBytes);

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
         * The server-side encryption algorithm that was used when you store this object in Amazon S3 (for example,
         * <code>AES256</code>, <code>aws:kms</code>, <code>aws:kms:dsse</code>).
         * </p>
         * <ul>
         * <li>
         * <p>
         * <b>General purpose buckets </b> - You have four mutually exclusive options to protect data using server-side
         * encryption in Amazon S3, depending on how you choose to manage the encryption keys. Specifically, the
         * encryption key options are Amazon S3 managed keys (SSE-S3), Amazon Web Services KMS keys (SSE-KMS or
         * DSSE-KMS), and customer-provided keys (SSE-C). Amazon S3 encrypts data with server-side encryption by using
         * Amazon S3 managed keys (SSE-S3) by default. You can optionally tell Amazon S3 to encrypt data at rest by
         * using server-side encryption with other key options. For more information, see <a
         * href="https://docs.aws.amazon.com/AmazonS3/latest/dev/UsingServerSideEncryption.html">Using Server-Side
         * Encryption</a> in the <i>Amazon S3 User Guide</i>.
         * </p>
         * </li>
         * <li>
         * <p>
         * <b>Directory buckets </b> - For directory buckets, there are only two supported options for server-side
         * encryption: server-side encryption with Amazon S3 managed keys (SSE-S3) (<code>AES256</code>) and server-side
         * encryption with KMS keys (SSE-KMS) (<code>aws:kms</code>). We recommend that the bucket's default encryption
         * uses the desired encryption configuration and you don't override the bucket default encryption in your
         * <code>CreateSession</code> requests or <code>PUT</code> object requests. Then, new objects are automatically
         * encrypted with the desired encryption settings. For more information, see <a
         * href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/s3-express-serv-side-encryption.html">Protecting
         * data with server-side encryption</a> in the <i>Amazon S3 User Guide</i>. For more information about the
         * encryption overriding behaviors in directory buckets, see <a
         * href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/s3-express-specifying-kms-encryption.html"
         * >Specifying server-side encryption with KMS for new object uploads</a>.
         * </p>
         * <p>
         * In the Zonal endpoint API calls (except <a
         * href="https://docs.aws.amazon.com/AmazonS3/latest/API/API_CopyObject.html">CopyObject</a> and <a
         * href="https://docs.aws.amazon.com/AmazonS3/latest/API/API_UploadPartCopy.html">UploadPartCopy</a>) using the
         * REST API, the encryption request headers must match the encryption settings that are specified in the
         * <code>CreateSession</code> request. You can't override the values of the encryption settings (
         * <code>x-amz-server-side-encryption</code>, <code>x-amz-server-side-encryption-aws-kms-key-id</code>,
         * <code>x-amz-server-side-encryption-context</code>, and
         * <code>x-amz-server-side-encryption-bucket-key-enabled</code>) that are specified in the
         * <code>CreateSession</code> request. You don't need to explicitly specify these encryption settings values in
         * Zonal endpoint API calls, and Amazon S3 will use the encryption settings values from the
         * <code>CreateSession</code> request to protect new objects in the directory bucket.
         * </p>
         * <note>
         * <p>
         * When you use the CLI or the Amazon Web Services SDKs, for <code>CreateSession</code>, the session token
         * refreshes automatically to avoid service interruptions when a session expires. The CLI or the Amazon Web
         * Services SDKs use the bucket's default encryption configuration for the <code>CreateSession</code> request.
         * It's not supported to override the encryption settings values in the <code>CreateSession</code> request. So
         * in the Zonal endpoint API calls (except <a
         * href="https://docs.aws.amazon.com/AmazonS3/latest/API/API_CopyObject.html">CopyObject</a> and <a
         * href="https://docs.aws.amazon.com/AmazonS3/latest/API/API_UploadPartCopy.html">UploadPartCopy</a>), the
         * encryption request headers must match the default encryption configuration of the directory bucket.
         * </p>
         * </note></li>
         * </ul>
         * 
         * @param serverSideEncryption
         *        The server-side encryption algorithm that was used when you store this object in Amazon S3 (for
         *        example, <code>AES256</code>, <code>aws:kms</code>, <code>aws:kms:dsse</code>).</p>
         *        <ul>
         *        <li>
         *        <p>
         *        <b>General purpose buckets </b> - You have four mutually exclusive options to protect data using
         *        server-side encryption in Amazon S3, depending on how you choose to manage the encryption keys.
         *        Specifically, the encryption key options are Amazon S3 managed keys (SSE-S3), Amazon Web Services KMS
         *        keys (SSE-KMS or DSSE-KMS), and customer-provided keys (SSE-C). Amazon S3 encrypts data with
         *        server-side encryption by using Amazon S3 managed keys (SSE-S3) by default. You can optionally tell
         *        Amazon S3 to encrypt data at rest by using server-side encryption with other key options. For more
         *        information, see <a
         *        href="https://docs.aws.amazon.com/AmazonS3/latest/dev/UsingServerSideEncryption.html">Using
         *        Server-Side Encryption</a> in the <i>Amazon S3 User Guide</i>.
         *        </p>
         *        </li>
         *        <li>
         *        <p>
         *        <b>Directory buckets </b> - For directory buckets, there are only two supported options for
         *        server-side encryption: server-side encryption with Amazon S3 managed keys (SSE-S3) (
         *        <code>AES256</code>) and server-side encryption with KMS keys (SSE-KMS) (<code>aws:kms</code>). We
         *        recommend that the bucket's default encryption uses the desired encryption configuration and you don't
         *        override the bucket default encryption in your <code>CreateSession</code> requests or <code>PUT</code>
         *        object requests. Then, new objects are automatically encrypted with the desired encryption settings.
         *        For more information, see <a
         *        href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/s3-express-serv-side-encryption.html"
         *        >Protecting data with server-side encryption</a> in the <i>Amazon S3 User Guide</i>. For more
         *        information about the encryption overriding behaviors in directory buckets, see <a href=
         *        "https://docs.aws.amazon.com/AmazonS3/latest/userguide/s3-express-specifying-kms-encryption.html"
         *        >Specifying server-side encryption with KMS for new object uploads</a>.
         *        </p>
         *        <p>
         *        In the Zonal endpoint API calls (except <a
         *        href="https://docs.aws.amazon.com/AmazonS3/latest/API/API_CopyObject.html">CopyObject</a> and <a
         *        href="https://docs.aws.amazon.com/AmazonS3/latest/API/API_UploadPartCopy.html">UploadPartCopy</a>)
         *        using the REST API, the encryption request headers must match the encryption settings that are
         *        specified in the <code>CreateSession</code> request. You can't override the values of the encryption
         *        settings (<code>x-amz-server-side-encryption</code>,
         *        <code>x-amz-server-side-encryption-aws-kms-key-id</code>,
         *        <code>x-amz-server-side-encryption-context</code>, and
         *        <code>x-amz-server-side-encryption-bucket-key-enabled</code>) that are specified in the
         *        <code>CreateSession</code> request. You don't need to explicitly specify these encryption settings
         *        values in Zonal endpoint API calls, and Amazon S3 will use the encryption settings values from the
         *        <code>CreateSession</code> request to protect new objects in the directory bucket.
         *        </p>
         *        <note>
         *        <p>
         *        When you use the CLI or the Amazon Web Services SDKs, for <code>CreateSession</code>, the session
         *        token refreshes automatically to avoid service interruptions when a session expires. The CLI or the
         *        Amazon Web Services SDKs use the bucket's default encryption configuration for the
         *        <code>CreateSession</code> request. It's not supported to override the encryption settings values in
         *        the <code>CreateSession</code> request. So in the Zonal endpoint API calls (except <a
         *        href="https://docs.aws.amazon.com/AmazonS3/latest/API/API_CopyObject.html">CopyObject</a> and <a
         *        href="https://docs.aws.amazon.com/AmazonS3/latest/API/API_UploadPartCopy.html">UploadPartCopy</a>),
         *        the encryption request headers must match the default encryption configuration of the directory
         *        bucket.
         *        </p>
         *        </note></li>
         * @see ServerSideEncryption
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see ServerSideEncryption
         */
        Builder serverSideEncryption(String serverSideEncryption);

        /**
         * <p>
         * The server-side encryption algorithm that was used when you store this object in Amazon S3 (for example,
         * <code>AES256</code>, <code>aws:kms</code>, <code>aws:kms:dsse</code>).
         * </p>
         * <ul>
         * <li>
         * <p>
         * <b>General purpose buckets </b> - You have four mutually exclusive options to protect data using server-side
         * encryption in Amazon S3, depending on how you choose to manage the encryption keys. Specifically, the
         * encryption key options are Amazon S3 managed keys (SSE-S3), Amazon Web Services KMS keys (SSE-KMS or
         * DSSE-KMS), and customer-provided keys (SSE-C). Amazon S3 encrypts data with server-side encryption by using
         * Amazon S3 managed keys (SSE-S3) by default. You can optionally tell Amazon S3 to encrypt data at rest by
         * using server-side encryption with other key options. For more information, see <a
         * href="https://docs.aws.amazon.com/AmazonS3/latest/dev/UsingServerSideEncryption.html">Using Server-Side
         * Encryption</a> in the <i>Amazon S3 User Guide</i>.
         * </p>
         * </li>
         * <li>
         * <p>
         * <b>Directory buckets </b> - For directory buckets, there are only two supported options for server-side
         * encryption: server-side encryption with Amazon S3 managed keys (SSE-S3) (<code>AES256</code>) and server-side
         * encryption with KMS keys (SSE-KMS) (<code>aws:kms</code>). We recommend that the bucket's default encryption
         * uses the desired encryption configuration and you don't override the bucket default encryption in your
         * <code>CreateSession</code> requests or <code>PUT</code> object requests. Then, new objects are automatically
         * encrypted with the desired encryption settings. For more information, see <a
         * href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/s3-express-serv-side-encryption.html">Protecting
         * data with server-side encryption</a> in the <i>Amazon S3 User Guide</i>. For more information about the
         * encryption overriding behaviors in directory buckets, see <a
         * href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/s3-express-specifying-kms-encryption.html"
         * >Specifying server-side encryption with KMS for new object uploads</a>.
         * </p>
         * <p>
         * In the Zonal endpoint API calls (except <a
         * href="https://docs.aws.amazon.com/AmazonS3/latest/API/API_CopyObject.html">CopyObject</a> and <a
         * href="https://docs.aws.amazon.com/AmazonS3/latest/API/API_UploadPartCopy.html">UploadPartCopy</a>) using the
         * REST API, the encryption request headers must match the encryption settings that are specified in the
         * <code>CreateSession</code> request. You can't override the values of the encryption settings (
         * <code>x-amz-server-side-encryption</code>, <code>x-amz-server-side-encryption-aws-kms-key-id</code>,
         * <code>x-amz-server-side-encryption-context</code>, and
         * <code>x-amz-server-side-encryption-bucket-key-enabled</code>) that are specified in the
         * <code>CreateSession</code> request. You don't need to explicitly specify these encryption settings values in
         * Zonal endpoint API calls, and Amazon S3 will use the encryption settings values from the
         * <code>CreateSession</code> request to protect new objects in the directory bucket.
         * </p>
         * <note>
         * <p>
         * When you use the CLI or the Amazon Web Services SDKs, for <code>CreateSession</code>, the session token
         * refreshes automatically to avoid service interruptions when a session expires. The CLI or the Amazon Web
         * Services SDKs use the bucket's default encryption configuration for the <code>CreateSession</code> request.
         * It's not supported to override the encryption settings values in the <code>CreateSession</code> request. So
         * in the Zonal endpoint API calls (except <a
         * href="https://docs.aws.amazon.com/AmazonS3/latest/API/API_CopyObject.html">CopyObject</a> and <a
         * href="https://docs.aws.amazon.com/AmazonS3/latest/API/API_UploadPartCopy.html">UploadPartCopy</a>), the
         * encryption request headers must match the default encryption configuration of the directory bucket.
         * </p>
         * </note></li>
         * </ul>
         * 
         * @param serverSideEncryption
         *        The server-side encryption algorithm that was used when you store this object in Amazon S3 (for
         *        example, <code>AES256</code>, <code>aws:kms</code>, <code>aws:kms:dsse</code>).</p>
         *        <ul>
         *        <li>
         *        <p>
         *        <b>General purpose buckets </b> - You have four mutually exclusive options to protect data using
         *        server-side encryption in Amazon S3, depending on how you choose to manage the encryption keys.
         *        Specifically, the encryption key options are Amazon S3 managed keys (SSE-S3), Amazon Web Services KMS
         *        keys (SSE-KMS or DSSE-KMS), and customer-provided keys (SSE-C). Amazon S3 encrypts data with
         *        server-side encryption by using Amazon S3 managed keys (SSE-S3) by default. You can optionally tell
         *        Amazon S3 to encrypt data at rest by using server-side encryption with other key options. For more
         *        information, see <a
         *        href="https://docs.aws.amazon.com/AmazonS3/latest/dev/UsingServerSideEncryption.html">Using
         *        Server-Side Encryption</a> in the <i>Amazon S3 User Guide</i>.
         *        </p>
         *        </li>
         *        <li>
         *        <p>
         *        <b>Directory buckets </b> - For directory buckets, there are only two supported options for
         *        server-side encryption: server-side encryption with Amazon S3 managed keys (SSE-S3) (
         *        <code>AES256</code>) and server-side encryption with KMS keys (SSE-KMS) (<code>aws:kms</code>). We
         *        recommend that the bucket's default encryption uses the desired encryption configuration and you don't
         *        override the bucket default encryption in your <code>CreateSession</code> requests or <code>PUT</code>
         *        object requests. Then, new objects are automatically encrypted with the desired encryption settings.
         *        For more information, see <a
         *        href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/s3-express-serv-side-encryption.html"
         *        >Protecting data with server-side encryption</a> in the <i>Amazon S3 User Guide</i>. For more
         *        information about the encryption overriding behaviors in directory buckets, see <a href=
         *        "https://docs.aws.amazon.com/AmazonS3/latest/userguide/s3-express-specifying-kms-encryption.html"
         *        >Specifying server-side encryption with KMS for new object uploads</a>.
         *        </p>
         *        <p>
         *        In the Zonal endpoint API calls (except <a
         *        href="https://docs.aws.amazon.com/AmazonS3/latest/API/API_CopyObject.html">CopyObject</a> and <a
         *        href="https://docs.aws.amazon.com/AmazonS3/latest/API/API_UploadPartCopy.html">UploadPartCopy</a>)
         *        using the REST API, the encryption request headers must match the encryption settings that are
         *        specified in the <code>CreateSession</code> request. You can't override the values of the encryption
         *        settings (<code>x-amz-server-side-encryption</code>,
         *        <code>x-amz-server-side-encryption-aws-kms-key-id</code>,
         *        <code>x-amz-server-side-encryption-context</code>, and
         *        <code>x-amz-server-side-encryption-bucket-key-enabled</code>) that are specified in the
         *        <code>CreateSession</code> request. You don't need to explicitly specify these encryption settings
         *        values in Zonal endpoint API calls, and Amazon S3 will use the encryption settings values from the
         *        <code>CreateSession</code> request to protect new objects in the directory bucket.
         *        </p>
         *        <note>
         *        <p>
         *        When you use the CLI or the Amazon Web Services SDKs, for <code>CreateSession</code>, the session
         *        token refreshes automatically to avoid service interruptions when a session expires. The CLI or the
         *        Amazon Web Services SDKs use the bucket's default encryption configuration for the
         *        <code>CreateSession</code> request. It's not supported to override the encryption settings values in
         *        the <code>CreateSession</code> request. So in the Zonal endpoint API calls (except <a
         *        href="https://docs.aws.amazon.com/AmazonS3/latest/API/API_CopyObject.html">CopyObject</a> and <a
         *        href="https://docs.aws.amazon.com/AmazonS3/latest/API/API_UploadPartCopy.html">UploadPartCopy</a>),
         *        the encryption request headers must match the default encryption configuration of the directory
         *        bucket.
         *        </p>
         *        </note></li>
         * @see ServerSideEncryption
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see ServerSideEncryption
         */
        Builder serverSideEncryption(ServerSideEncryption serverSideEncryption);

        /**
         * <p>
         * By default, Amazon S3 uses the STANDARD Storage Class to store newly created objects. The STANDARD storage
         * class provides high durability and high availability. Depending on performance needs, you can specify a
         * different Storage Class. For more information, see <a
         * href="https://docs.aws.amazon.com/AmazonS3/latest/dev/storage-class-intro.html">Storage Classes</a> in the
         * <i>Amazon S3 User Guide</i>.
         * </p>
         * <note>
         * <ul>
         * <li>
         * <p>
         * Directory buckets only support <code>EXPRESS_ONEZONE</code> (the S3 Express One Zone storage class) in
         * Availability Zones and <code>ONEZONE_IA</code> (the S3 One Zone-Infrequent Access storage class) in Dedicated
         * Local Zones.
         * </p>
         * </li>
         * <li>
         * <p>
         * Amazon S3 on Outposts only uses the OUTPOSTS Storage Class.
         * </p>
         * </li>
         * </ul>
         * </note>
         * 
         * @param storageClass
         *        By default, Amazon S3 uses the STANDARD Storage Class to store newly created objects. The STANDARD
         *        storage class provides high durability and high availability. Depending on performance needs, you can
         *        specify a different Storage Class. For more information, see <a
         *        href="https://docs.aws.amazon.com/AmazonS3/latest/dev/storage-class-intro.html">Storage Classes</a> in
         *        the <i>Amazon S3 User Guide</i>.</p> <note>
         *        <ul>
         *        <li>
         *        <p>
         *        Directory buckets only support <code>EXPRESS_ONEZONE</code> (the S3 Express One Zone storage class) in
         *        Availability Zones and <code>ONEZONE_IA</code> (the S3 One Zone-Infrequent Access storage class) in
         *        Dedicated Local Zones.
         *        </p>
         *        </li>
         *        <li>
         *        <p>
         *        Amazon S3 on Outposts only uses the OUTPOSTS Storage Class.
         *        </p>
         *        </li>
         *        </ul>
         * @see StorageClass
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see StorageClass
         */
        Builder storageClass(String storageClass);

        /**
         * <p>
         * By default, Amazon S3 uses the STANDARD Storage Class to store newly created objects. The STANDARD storage
         * class provides high durability and high availability. Depending on performance needs, you can specify a
         * different Storage Class. For more information, see <a
         * href="https://docs.aws.amazon.com/AmazonS3/latest/dev/storage-class-intro.html">Storage Classes</a> in the
         * <i>Amazon S3 User Guide</i>.
         * </p>
         * <note>
         * <ul>
         * <li>
         * <p>
         * Directory buckets only support <code>EXPRESS_ONEZONE</code> (the S3 Express One Zone storage class) in
         * Availability Zones and <code>ONEZONE_IA</code> (the S3 One Zone-Infrequent Access storage class) in Dedicated
         * Local Zones.
         * </p>
         * </li>
         * <li>
         * <p>
         * Amazon S3 on Outposts only uses the OUTPOSTS Storage Class.
         * </p>
         * </li>
         * </ul>
         * </note>
         * 
         * @param storageClass
         *        By default, Amazon S3 uses the STANDARD Storage Class to store newly created objects. The STANDARD
         *        storage class provides high durability and high availability. Depending on performance needs, you can
         *        specify a different Storage Class. For more information, see <a
         *        href="https://docs.aws.amazon.com/AmazonS3/latest/dev/storage-class-intro.html">Storage Classes</a> in
         *        the <i>Amazon S3 User Guide</i>.</p> <note>
         *        <ul>
         *        <li>
         *        <p>
         *        Directory buckets only support <code>EXPRESS_ONEZONE</code> (the S3 Express One Zone storage class) in
         *        Availability Zones and <code>ONEZONE_IA</code> (the S3 One Zone-Infrequent Access storage class) in
         *        Dedicated Local Zones.
         *        </p>
         *        </li>
         *        <li>
         *        <p>
         *        Amazon S3 on Outposts only uses the OUTPOSTS Storage Class.
         *        </p>
         *        </li>
         *        </ul>
         * @see StorageClass
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see StorageClass
         */
        Builder storageClass(StorageClass storageClass);

        /**
         * <p>
         * If the bucket is configured as a website, redirects requests for this object to another object in the same
         * bucket or to an external URL. Amazon S3 stores the value of this header in the object metadata. For
         * information about object metadata, see <a
         * href="https://docs.aws.amazon.com/AmazonS3/latest/dev/UsingMetadata.html">Object Key and Metadata</a> in the
         * <i>Amazon S3 User Guide</i>.
         * </p>
         * <p>
         * In the following example, the request header sets the redirect to an object (anotherPage.html) in the same
         * bucket:
         * </p>
         * <p>
         * <code>x-amz-website-redirect-location: /anotherPage.html</code>
         * </p>
         * <p>
         * In the following example, the request header sets the object redirect to another website:
         * </p>
         * <p>
         * <code>x-amz-website-redirect-location: http://www.example.com/</code>
         * </p>
         * <p>
         * For more information about website hosting in Amazon S3, see <a
         * href="https://docs.aws.amazon.com/AmazonS3/latest/dev/WebsiteHosting.html">Hosting Websites on Amazon S3</a>
         * and <a href="https://docs.aws.amazon.com/AmazonS3/latest/dev/how-to-page-redirect.html">How to Configure
         * Website Page Redirects</a> in the <i>Amazon S3 User Guide</i>.
         * </p>
         * <note>
         * <p>
         * This functionality is not supported for directory buckets.
         * </p>
         * </note>
         * 
         * @param websiteRedirectLocation
         *        If the bucket is configured as a website, redirects requests for this object to another object in the
         *        same bucket or to an external URL. Amazon S3 stores the value of this header in the object metadata.
         *        For information about object metadata, see <a
         *        href="https://docs.aws.amazon.com/AmazonS3/latest/dev/UsingMetadata.html">Object Key and Metadata</a>
         *        in the <i>Amazon S3 User Guide</i>.</p>
         *        <p>
         *        In the following example, the request header sets the redirect to an object (anotherPage.html) in the
         *        same bucket:
         *        </p>
         *        <p>
         *        <code>x-amz-website-redirect-location: /anotherPage.html</code>
         *        </p>
         *        <p>
         *        In the following example, the request header sets the object redirect to another website:
         *        </p>
         *        <p>
         *        <code>x-amz-website-redirect-location: http://www.example.com/</code>
         *        </p>
         *        <p>
         *        For more information about website hosting in Amazon S3, see <a
         *        href="https://docs.aws.amazon.com/AmazonS3/latest/dev/WebsiteHosting.html">Hosting Websites on Amazon
         *        S3</a> and <a href="https://docs.aws.amazon.com/AmazonS3/latest/dev/how-to-page-redirect.html">How to
         *        Configure Website Page Redirects</a> in the <i>Amazon S3 User Guide</i>.
         *        </p>
         *        <note>
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
         * <note>
         * <p>
         * This functionality is not supported for directory buckets.
         * </p>
         * </note>
         * 
         * @param sseCustomerAlgorithm
         *        Specifies the algorithm to use when encrypting the object (for example, <code>AES256</code>).</p>
         *        <note>
         *        <p>
         *        This functionality is not supported for directory buckets.
         *        </p>
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder sseCustomerAlgorithm(String sseCustomerAlgorithm);

        /**
         * <p>
         * Specifies the customer-provided encryption key for Amazon S3 to use in encrypting data. This value is used to
         * store the object and then it is discarded; Amazon S3 does not store the encryption key. The key must be
         * appropriate for use with the algorithm specified in the
         * <code>x-amz-server-side-encryption-customer-algorithm</code> header.
         * </p>
         * <note>
         * <p>
         * This functionality is not supported for directory buckets.
         * </p>
         * </note>
         * 
         * @param sseCustomerKey
         *        Specifies the customer-provided encryption key for Amazon S3 to use in encrypting data. This value is
         *        used to store the object and then it is discarded; Amazon S3 does not store the encryption key. The
         *        key must be appropriate for use with the algorithm specified in the
         *        <code>x-amz-server-side-encryption-customer-algorithm</code> header.</p> <note>
         *        <p>
         *        This functionality is not supported for directory buckets.
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
         * This functionality is not supported for directory buckets.
         * </p>
         * </note>
         * 
         * @param sseCustomerKeyMD5
         *        Specifies the 128-bit MD5 digest of the encryption key according to RFC 1321. Amazon S3 uses this
         *        header for a message integrity check to ensure that the encryption key was transmitted without
         *        error.</p> <note>
         *        <p>
         *        This functionality is not supported for directory buckets.
         *        </p>
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder sseCustomerKeyMD5(String sseCustomerKeyMD5);

        /**
         * <p>
         * Specifies the KMS key ID (Key ID, Key ARN, or Key Alias) to use for object encryption. If the KMS key doesn't
         * exist in the same account that's issuing the command, you must use the full Key ARN not the Key ID.
         * </p>
         * <p>
         * <b>General purpose buckets</b> - If you specify <code>x-amz-server-side-encryption</code> with
         * <code>aws:kms</code> or <code>aws:kms:dsse</code>, this header specifies the ID (Key ID, Key ARN, or Key
         * Alias) of the KMS key to use. If you specify <code>x-amz-server-side-encryption:aws:kms</code> or
         * <code>x-amz-server-side-encryption:aws:kms:dsse</code>, but do not provide
         * <code>x-amz-server-side-encryption-aws-kms-key-id</code>, Amazon S3 uses the Amazon Web Services managed key
         * (<code>aws/s3</code>) to protect the data.
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
         *        Specifies the KMS key ID (Key ID, Key ARN, or Key Alias) to use for object encryption. If the KMS key
         *        doesn't exist in the same account that's issuing the command, you must use the full Key ARN not the
         *        Key ID.</p>
         *        <p>
         *        <b>General purpose buckets</b> - If you specify <code>x-amz-server-side-encryption</code> with
         *        <code>aws:kms</code> or <code>aws:kms:dsse</code>, this header specifies the ID (Key ID, Key ARN, or
         *        Key Alias) of the KMS key to use. If you specify <code>x-amz-server-side-encryption:aws:kms</code> or
         *        <code>x-amz-server-side-encryption:aws:kms:dsse</code>, but do not provide
         *        <code>x-amz-server-side-encryption-aws-kms-key-id</code>, Amazon S3 uses the Amazon Web Services
         *        managed key (<code>aws/s3</code>) to protect the data.
         *        </p>
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
         * Specifies the Amazon Web Services KMS Encryption Context as an additional encryption context to use for
         * object encryption. The value of this header is a Base64 encoded string of a UTF-8 encoded JSON, which
         * contains the encryption context as key-value pairs. This value is stored as object metadata and automatically
         * gets passed on to Amazon Web Services KMS for future <code>GetObject</code> operations on this object.
         * </p>
         * <p>
         * <b>General purpose buckets</b> - This value must be explicitly added during <code>CopyObject</code>
         * operations if you want an additional encryption context for your object. For more information, see <a
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
         *        for object encryption. The value of this header is a Base64 encoded string of a UTF-8 encoded JSON,
         *        which contains the encryption context as key-value pairs. This value is stored as object metadata and
         *        automatically gets passed on to Amazon Web Services KMS for future <code>GetObject</code> operations
         *        on this object.</p>
         *        <p>
         *        <b>General purpose buckets</b> - This value must be explicitly added during <code>CopyObject</code>
         *        operations if you want an additional encryption context for your object. For more information, see <a
         *        href
         *        ="https://docs.aws.amazon.com/AmazonS3/latest/userguide/UsingKMSEncryption.html#encryption-context"
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
         * using Key Management Service (KMS) keys (SSE-KMS).
         * </p>
         * <p>
         * <b>General purpose buckets</b> - Setting this header to <code>true</code> causes Amazon S3 to use an S3
         * Bucket Key for object encryption with SSE-KMS. Also, specifying this header with a PUT action doesn't affect
         * bucket-level settings for S3 Bucket Key.
         * </p>
         * <p>
         * <b>Directory buckets</b> - S3 Bucket Keys are always enabled for <code>GET</code> and <code>PUT</code>
         * operations in a directory bucket and can’t be disabled. S3 Bucket Keys aren't supported, when you copy
         * SSE-KMS encrypted objects from general purpose buckets to directory buckets, from directory buckets to
         * general purpose buckets, or between directory buckets, through <a
         * href="https://docs.aws.amazon.com/AmazonS3/latest/API/API_CopyObject.html">CopyObject</a>, <a
         * href="https://docs.aws.amazon.com/AmazonS3/latest/API/API_UploadPartCopy.html">UploadPartCopy</a>, <a
         * href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/directory-buckets-objects-Batch-Ops">the Copy
         * operation in Batch Operations</a>, or <a
         * href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/create-import-job">the import jobs</a>. In this
         * case, Amazon S3 makes a call to KMS every time a copy request is made for a KMS-encrypted object.
         * </p>
         * 
         * @param bucketKeyEnabled
         *        Specifies whether Amazon S3 should use an S3 Bucket Key for object encryption with server-side
         *        encryption using Key Management Service (KMS) keys (SSE-KMS).</p>
         *        <p>
         *        <b>General purpose buckets</b> - Setting this header to <code>true</code> causes Amazon S3 to use an
         *        S3 Bucket Key for object encryption with SSE-KMS. Also, specifying this header with a PUT action
         *        doesn't affect bucket-level settings for S3 Bucket Key.
         *        </p>
         *        <p>
         *        <b>Directory buckets</b> - S3 Bucket Keys are always enabled for <code>GET</code> and <code>PUT</code>
         *        operations in a directory bucket and can’t be disabled. S3 Bucket Keys aren't supported, when you copy
         *        SSE-KMS encrypted objects from general purpose buckets to directory buckets, from directory buckets to
         *        general purpose buckets, or between directory buckets, through <a
         *        href="https://docs.aws.amazon.com/AmazonS3/latest/API/API_CopyObject.html">CopyObject</a>, <a
         *        href="https://docs.aws.amazon.com/AmazonS3/latest/API/API_UploadPartCopy.html">UploadPartCopy</a>, <a
         *        href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/directory-buckets-objects-Batch-Ops">the
         *        Copy operation in Batch Operations</a>, or <a
         *        href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/create-import-job">the import jobs</a>. In
         *        this case, Amazon S3 makes a call to KMS every time a copy request is made for a KMS-encrypted object.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder bucketKeyEnabled(Boolean bucketKeyEnabled);

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
         * The tag-set for the object. The tag-set must be encoded as URL Query parameters. (For example, "Key1=Value1")
         * </p>
         * <note>
         * <p>
         * This functionality is not supported for directory buckets.
         * </p>
         * </note>
         * 
         * @param tagging
         *        The tag-set for the object. The tag-set must be encoded as URL Query parameters. (For example,
         *        "Key1=Value1")</p> <note>
         *        <p>
         *        This functionality is not supported for directory buckets.
         *        </p>
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder tagging(String tagging);

        Builder tagging(Tagging tagging);

        /**
         * <p>
         * The Object Lock mode that you want to apply to this object.
         * </p>
         * <note>
         * <p>
         * This functionality is not supported for directory buckets.
         * </p>
         * </note>
         * 
         * @param objectLockMode
         *        The Object Lock mode that you want to apply to this object.</p> <note>
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
         * The Object Lock mode that you want to apply to this object.
         * </p>
         * <note>
         * <p>
         * This functionality is not supported for directory buckets.
         * </p>
         * </note>
         * 
         * @param objectLockMode
         *        The Object Lock mode that you want to apply to this object.</p> <note>
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
         * The date and time when you want this object's Object Lock to expire. Must be formatted as a timestamp
         * parameter.
         * </p>
         * <note>
         * <p>
         * This functionality is not supported for directory buckets.
         * </p>
         * </note>
         * 
         * @param objectLockRetainUntilDate
         *        The date and time when you want this object's Object Lock to expire. Must be formatted as a timestamp
         *        parameter.</p> <note>
         *        <p>
         *        This functionality is not supported for directory buckets.
         *        </p>
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder objectLockRetainUntilDate(Instant objectLockRetainUntilDate);

        /**
         * <p>
         * Specifies whether a legal hold will be applied to this object. For more information about S3 Object Lock, see
         * <a href="https://docs.aws.amazon.com/AmazonS3/latest/dev/object-lock.html">Object Lock</a> in the <i>Amazon
         * S3 User Guide</i>.
         * </p>
         * <note>
         * <p>
         * This functionality is not supported for directory buckets.
         * </p>
         * </note>
         * 
         * @param objectLockLegalHoldStatus
         *        Specifies whether a legal hold will be applied to this object. For more information about S3 Object
         *        Lock, see <a href="https://docs.aws.amazon.com/AmazonS3/latest/dev/object-lock.html">Object Lock</a>
         *        in the <i>Amazon S3 User Guide</i>.</p> <note>
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
         * Specifies whether a legal hold will be applied to this object. For more information about S3 Object Lock, see
         * <a href="https://docs.aws.amazon.com/AmazonS3/latest/dev/object-lock.html">Object Lock</a> in the <i>Amazon
         * S3 User Guide</i>.
         * </p>
         * <note>
         * <p>
         * This functionality is not supported for directory buckets.
         * </p>
         * </note>
         * 
         * @param objectLockLegalHoldStatus
         *        Specifies whether a legal hold will be applied to this object. For more information about S3 Object
         *        Lock, see <a href="https://docs.aws.amazon.com/AmazonS3/latest/dev/object-lock.html">Object Lock</a>
         *        in the <i>Amazon S3 User Guide</i>.</p> <note>
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
         * The account ID of the expected bucket owner. If the account ID that you provide does not match the actual
         * owner of the bucket, the request fails with the HTTP status code <code>403 Forbidden</code> (access denied).
         * </p>
         * 
         * @param expectedBucketOwner
         *        The account ID of the expected bucket owner. If the account ID that you provide does not match the
         *        actual owner of the bucket, the request fails with the HTTP status code <code>403 Forbidden</code>
         *        (access denied).
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder expectedBucketOwner(String expectedBucketOwner);

        @Override
        Builder overrideConfiguration(AwsRequestOverrideConfiguration overrideConfiguration);

        @Override
        Builder overrideConfiguration(Consumer<AwsRequestOverrideConfiguration.Builder> builderConsumer);

        /**
         * <p>
         *  Date on which it will be legal to delete or modify the object.
         * </p>
         *
         * @param retentionExpirationDate
         *
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder retentionExpirationDate(Instant retentionExpirationDate);

        /**
         * <p>
         * The number of legal holds applied to the object.
         * </p>
         *
         * @param retentionLegalHoldId
         *
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder retentionLegalHoldId(String retentionLegalHoldId);

        /**
         * <p>
         * Retention period to store on the object in seconds.
         * </p>
         *
         * @param retentionPeriod
         *
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder retentionPeriod(Long retentionPeriod);
    }

    static final class BuilderImpl extends S3Request.BuilderImpl implements Builder {
        private String acl;

        private String bucket;

        private String cacheControl;

        private String contentDisposition;

        private String contentEncoding;

        private String contentLanguage;

        private Long contentLength;

        private String contentMD5;

        private String contentType;

        private String checksumAlgorithm;

        private String checksumCRC32;

        private String checksumCRC32C;

        private String checksumCRC64NVME;

        private String checksumSHA1;

        private String checksumSHA256;

        private Instant expires;

        private String ifMatch;

        private String ifNoneMatch;

        private String grantFullControl;

        private String grantRead;

        private String grantReadACP;

        private String grantWriteACP;

        private String key;

        private Long writeOffsetBytes;

        private Map<String, String> metadata = DefaultSdkAutoConstructMap.getInstance();

        private String serverSideEncryption;

        private String storageClass;

        private String websiteRedirectLocation;

        private String sseCustomerAlgorithm;

        private String sseCustomerKey;

        private String sseCustomerKeyMD5;

        private String ssekmsKeyId;

        private String ssekmsEncryptionContext;

        private Boolean bucketKeyEnabled;

        private String requestPayer;

        private String tagging;

        private String objectLockMode;

        private Instant objectLockRetainUntilDate;

        private String objectLockLegalHoldStatus;

        private String expectedBucketOwner;

        private Instant retentionExpirationDate;

        private String retentionLegalHoldId;

        private  Long retentionPeriod;

        private BuilderImpl() {
        }

        private BuilderImpl(PutObjectRequest model) {
            super(model);
            acl(model.acl);
            bucket(model.bucket);
            cacheControl(model.cacheControl);
            contentDisposition(model.contentDisposition);
            contentEncoding(model.contentEncoding);
            contentLanguage(model.contentLanguage);
            contentLength(model.contentLength);
            contentMD5(model.contentMD5);
            contentType(model.contentType);
            checksumAlgorithm(model.checksumAlgorithm);
            checksumCRC32(model.checksumCRC32);
            checksumCRC32C(model.checksumCRC32C);
            checksumCRC64NVME(model.checksumCRC64NVME);
            checksumSHA1(model.checksumSHA1);
            checksumSHA256(model.checksumSHA256);
            expires(model.expires);
            ifMatch(model.ifMatch);
            ifNoneMatch(model.ifNoneMatch);
            grantFullControl(model.grantFullControl);
            grantRead(model.grantRead);
            grantReadACP(model.grantReadACP);
            grantWriteACP(model.grantWriteACP);
            key(model.key);
            writeOffsetBytes(model.writeOffsetBytes);
            metadata(model.metadata);
            serverSideEncryption(model.serverSideEncryption);
            storageClass(model.storageClass);
            websiteRedirectLocation(model.websiteRedirectLocation);
            sseCustomerAlgorithm(model.sseCustomerAlgorithm);
            sseCustomerKey(model.sseCustomerKey);
            sseCustomerKeyMD5(model.sseCustomerKeyMD5);
            ssekmsKeyId(model.ssekmsKeyId);
            ssekmsEncryptionContext(model.ssekmsEncryptionContext);
            bucketKeyEnabled(model.bucketKeyEnabled);
            requestPayer(model.requestPayer);
            tagging(model.tagging);
            objectLockMode(model.objectLockMode);
            objectLockRetainUntilDate(model.objectLockRetainUntilDate);
            objectLockLegalHoldStatus(model.objectLockLegalHoldStatus);
            expectedBucketOwner(model.expectedBucketOwner);
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

        public final String getBucket() {
            return bucket;
        }

        public final void setBucket(String bucket) {
            this.bucket = bucket;
        }

        @Override
        public final Builder bucket(String bucket) {
            this.bucket = bucket;
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

        public final Long getContentLength() {
            return contentLength;
        }

        public final void setContentLength(Long contentLength) {
            this.contentLength = contentLength;
        }

        @Override
        public final Builder contentLength(Long contentLength) {
            this.contentLength = contentLength;
            return this;
        }

        public final String getContentMD5() {
            return contentMD5;
        }

        public final void setContentMD5(String contentMD5) {
            this.contentMD5 = contentMD5;
        }

        @Override
        public final Builder contentMD5(String contentMD5) {
            this.contentMD5 = contentMD5;
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

        public final String getChecksumCRC32() {
            return checksumCRC32;
        }

        public final void setChecksumCRC32(String checksumCRC32) {
            this.checksumCRC32 = checksumCRC32;
        }

        @Override
        public final Builder checksumCRC32(String checksumCRC32) {
            this.checksumCRC32 = checksumCRC32;
            return this;
        }

        public final String getChecksumCRC32C() {
            return checksumCRC32C;
        }

        public final void setChecksumCRC32C(String checksumCRC32C) {
            this.checksumCRC32C = checksumCRC32C;
        }

        @Override
        public final Builder checksumCRC32C(String checksumCRC32C) {
            this.checksumCRC32C = checksumCRC32C;
            return this;
        }

        public final String getChecksumCRC64NVME() {
            return checksumCRC64NVME;
        }

        public final void setChecksumCRC64NVME(String checksumCRC64NVME) {
            this.checksumCRC64NVME = checksumCRC64NVME;
        }

        @Override
        public final Builder checksumCRC64NVME(String checksumCRC64NVME) {
            this.checksumCRC64NVME = checksumCRC64NVME;
            return this;
        }

        public final String getChecksumSHA1() {
            return checksumSHA1;
        }

        public final void setChecksumSHA1(String checksumSHA1) {
            this.checksumSHA1 = checksumSHA1;
        }

        @Override
        public final Builder checksumSHA1(String checksumSHA1) {
            this.checksumSHA1 = checksumSHA1;
            return this;
        }

        public final String getChecksumSHA256() {
            return checksumSHA256;
        }

        public final void setChecksumSHA256(String checksumSHA256) {
            this.checksumSHA256 = checksumSHA256;
        }

        @Override
        public final Builder checksumSHA256(String checksumSHA256) {
            this.checksumSHA256 = checksumSHA256;
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

        public final String getIfMatch() {
            return ifMatch;
        }

        public final void setIfMatch(String ifMatch) {
            this.ifMatch = ifMatch;
        }

        @Override
        public final Builder ifMatch(String ifMatch) {
            this.ifMatch = ifMatch;
            return this;
        }

        public final String getIfNoneMatch() {
            return ifNoneMatch;
        }

        public final void setIfNoneMatch(String ifNoneMatch) {
            this.ifNoneMatch = ifNoneMatch;
        }

        @Override
        public final Builder ifNoneMatch(String ifNoneMatch) {
            this.ifNoneMatch = ifNoneMatch;
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

        public final String getKey() {
            return key;
        }

        public final void setKey(String key) {
            this.key = key;
        }

        @Override
        public final Builder key(String key) {
            this.key = key;
            return this;
        }

        public final Long getWriteOffsetBytes() {
            return writeOffsetBytes;
        }

        public final void setWriteOffsetBytes(Long writeOffsetBytes) {
            this.writeOffsetBytes = writeOffsetBytes;
        }

        @Override
        public final Builder writeOffsetBytes(Long writeOffsetBytes) {
            this.writeOffsetBytes = writeOffsetBytes;
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

        public final Instant getRetentionExpirationDate() {
            return retentionExpirationDate;
        }

        public final void setRetentionExpirationDate(Instant ibmRetentionExpirationDate) {
            this.retentionExpirationDate = retentionExpirationDate;
        }

        @Override
        public final Builder retentionExpirationDate(Instant retentionExpirationDate) {
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
        public final Builder retentionLegalHoldId(String retentionLegalHoldId) {
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
        public final Builder retentionPeriod(Long retentionPeriod) {
            this.retentionPeriod = retentionPeriod;
            return this;
        }

        @Override
        public PutObjectRequest build() {
            return new PutObjectRequest(this);
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
