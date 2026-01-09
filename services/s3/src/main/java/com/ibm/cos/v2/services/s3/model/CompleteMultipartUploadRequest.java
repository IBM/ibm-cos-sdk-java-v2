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
import com.ibm.cos.v2.core.traits.PayloadTrait;
import com.ibm.cos.v2.core.traits.RequiredTrait;
import com.ibm.cos.v2.utils.ToString;
import com.ibm.cos.v2.utils.builder.CopyableBuilder;
import com.ibm.cos.v2.utils.builder.ToCopyableBuilder;

/**
 */
@Generated("com.ibm.cos.v2:codegen")
public final class CompleteMultipartUploadRequest extends S3Request implements
        ToCopyableBuilder<CompleteMultipartUploadRequest.Builder, CompleteMultipartUploadRequest> {
    private static final SdkField<String> BUCKET_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("Bucket")
            .getter(getter(CompleteMultipartUploadRequest::bucket))
            .setter(setter(Builder::bucket))
            .traits(LocationTrait.builder().location(MarshallLocation.PATH).locationName("Bucket")
                    .unmarshallLocationName("Bucket").build(), RequiredTrait.create()).build();

    private static final SdkField<String> KEY_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("Key")
            .getter(getter(CompleteMultipartUploadRequest::key))
            .setter(setter(Builder::key))
            .traits(LocationTrait.builder().location(MarshallLocation.GREEDY_PATH).locationName("Key")
                    .unmarshallLocationName("Key").build(), RequiredTrait.create()).build();

    private static final SdkField<CompletedMultipartUpload> MULTIPART_UPLOAD_FIELD = SdkField
            .<CompletedMultipartUpload> builder(MarshallingType.SDK_POJO)
            .memberName("MultipartUpload")
            .getter(getter(CompleteMultipartUploadRequest::multipartUpload))
            .setter(setter(Builder::multipartUpload))
            .constructor(CompletedMultipartUpload::builder)
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("CompleteMultipartUpload")
                    .unmarshallLocationName("CompleteMultipartUpload").build(), PayloadTrait.create()).build();

    private static final SdkField<String> UPLOAD_ID_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("UploadId")
            .getter(getter(CompleteMultipartUploadRequest::uploadId))
            .setter(setter(Builder::uploadId))
            .traits(LocationTrait.builder().location(MarshallLocation.QUERY_PARAM).locationName("uploadId")
                    .unmarshallLocationName("uploadId").build(), RequiredTrait.create()).build();

    private static final SdkField<String> CHECKSUM_CRC32_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("ChecksumCRC32")
            .getter(getter(CompleteMultipartUploadRequest::checksumCRC32))
            .setter(setter(Builder::checksumCRC32))
            .traits(LocationTrait.builder().location(MarshallLocation.HEADER).locationName("x-amz-checksum-crc32")
                    .unmarshallLocationName("x-amz-checksum-crc32").build()).build();

    private static final SdkField<String> CHECKSUM_CRC32_C_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("ChecksumCRC32C")
            .getter(getter(CompleteMultipartUploadRequest::checksumCRC32C))
            .setter(setter(Builder::checksumCRC32C))
            .traits(LocationTrait.builder().location(MarshallLocation.HEADER).locationName("x-amz-checksum-crc32c")
                    .unmarshallLocationName("x-amz-checksum-crc32c").build()).build();

    private static final SdkField<String> CHECKSUM_CRC64_NVME_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("ChecksumCRC64NVME")
            .getter(getter(CompleteMultipartUploadRequest::checksumCRC64NVME))
            .setter(setter(Builder::checksumCRC64NVME))
            .traits(LocationTrait.builder().location(MarshallLocation.HEADER).locationName("x-amz-checksum-crc64nvme")
                    .unmarshallLocationName("x-amz-checksum-crc64nvme").build()).build();

    private static final SdkField<String> CHECKSUM_SHA1_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("ChecksumSHA1")
            .getter(getter(CompleteMultipartUploadRequest::checksumSHA1))
            .setter(setter(Builder::checksumSHA1))
            .traits(LocationTrait.builder().location(MarshallLocation.HEADER).locationName("x-amz-checksum-sha1")
                    .unmarshallLocationName("x-amz-checksum-sha1").build()).build();

    private static final SdkField<String> CHECKSUM_SHA256_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("ChecksumSHA256")
            .getter(getter(CompleteMultipartUploadRequest::checksumSHA256))
            .setter(setter(Builder::checksumSHA256))
            .traits(LocationTrait.builder().location(MarshallLocation.HEADER).locationName("x-amz-checksum-sha256")
                    .unmarshallLocationName("x-amz-checksum-sha256").build()).build();

    private static final SdkField<String> CHECKSUM_TYPE_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("ChecksumType")
            .getter(getter(CompleteMultipartUploadRequest::checksumTypeAsString))
            .setter(setter(Builder::checksumType))
            .traits(LocationTrait.builder().location(MarshallLocation.HEADER).locationName("x-amz-checksum-type")
                    .unmarshallLocationName("x-amz-checksum-type").build()).build();

    private static final SdkField<Long> MPU_OBJECT_SIZE_FIELD = SdkField
            .<Long> builder(MarshallingType.LONG)
            .memberName("MpuObjectSize")
            .getter(getter(CompleteMultipartUploadRequest::mpuObjectSize))
            .setter(setter(Builder::mpuObjectSize))
            .traits(LocationTrait.builder().location(MarshallLocation.HEADER).locationName("x-amz-mp-object-size")
                    .unmarshallLocationName("x-amz-mp-object-size").build()).build();

    private static final SdkField<String> REQUEST_PAYER_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("RequestPayer")
            .getter(getter(CompleteMultipartUploadRequest::requestPayerAsString))
            .setter(setter(Builder::requestPayer))
            .traits(LocationTrait.builder().location(MarshallLocation.HEADER).locationName("x-amz-request-payer")
                    .unmarshallLocationName("x-amz-request-payer").build()).build();

    private static final SdkField<String> EXPECTED_BUCKET_OWNER_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("ExpectedBucketOwner")
            .getter(getter(CompleteMultipartUploadRequest::expectedBucketOwner))
            .setter(setter(Builder::expectedBucketOwner))
            .traits(LocationTrait.builder().location(MarshallLocation.HEADER).locationName("x-amz-expected-bucket-owner")
                    .unmarshallLocationName("x-amz-expected-bucket-owner").build()).build();

    private static final SdkField<String> IF_MATCH_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("IfMatch")
            .getter(getter(CompleteMultipartUploadRequest::ifMatch))
            .setter(setter(Builder::ifMatch))
            .traits(LocationTrait.builder().location(MarshallLocation.HEADER).locationName("If-Match")
                    .unmarshallLocationName("If-Match").build()).build();

    private static final SdkField<String> IF_NONE_MATCH_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("IfNoneMatch")
            .getter(getter(CompleteMultipartUploadRequest::ifNoneMatch))
            .setter(setter(Builder::ifNoneMatch))
            .traits(LocationTrait.builder().location(MarshallLocation.HEADER).locationName("If-None-Match")
                    .unmarshallLocationName("If-None-Match").build()).build();

    private static final SdkField<String> SSE_CUSTOMER_ALGORITHM_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("SSECustomerAlgorithm")
            .getter(getter(CompleteMultipartUploadRequest::sseCustomerAlgorithm))
            .setter(setter(Builder::sseCustomerAlgorithm))
            .traits(LocationTrait.builder().location(MarshallLocation.HEADER)
                    .locationName("x-amz-server-side-encryption-customer-algorithm")
                    .unmarshallLocationName("x-amz-server-side-encryption-customer-algorithm").build()).build();

    private static final SdkField<String> SSE_CUSTOMER_KEY_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("SSECustomerKey")
            .getter(getter(CompleteMultipartUploadRequest::sseCustomerKey))
            .setter(setter(Builder::sseCustomerKey))
            .traits(LocationTrait.builder().location(MarshallLocation.HEADER)
                    .locationName("x-amz-server-side-encryption-customer-key")
                    .unmarshallLocationName("x-amz-server-side-encryption-customer-key").build()).build();

    private static final SdkField<String> SSE_CUSTOMER_KEY_MD5_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("SSECustomerKeyMD5")
            .getter(getter(CompleteMultipartUploadRequest::sseCustomerKeyMD5))
            .setter(setter(Builder::sseCustomerKeyMD5))
            .traits(LocationTrait.builder().location(MarshallLocation.HEADER)
                    .locationName("x-amz-server-side-encryption-customer-key-MD5")
                    .unmarshallLocationName("x-amz-server-side-encryption-customer-key-MD5").build()).build();

    /************************************************ IBM Supported *************************************************************/
    private static final SdkField<Instant> RETENTION_EXPIRATION_DATE_FIELD = SdkField
        .<Instant>builder(MarshallingType.INSTANT)
        .memberName("RetentionExpirationDate")
        .getter((getter(CompleteMultipartUploadRequest::retentionExpirationDate)))
        .setter(setter(CompleteMultipartUploadRequest.Builder::retentionExpirationDate))
        .traits(LocationTrait.builder().location(MarshallLocation.HEADER)
                             .locationName("retention-expiration-date").unmarshallLocationName("retention-expiration-date").build())
        .build();

    private static final SdkField<String> RETENTION_LEGAL_HOLD_ID_FIELD = SdkField
        .<String>builder(MarshallingType.STRING)
        .memberName("RetentionLegalHoldId")
        .getter((getter(CompleteMultipartUploadRequest::retentionLegalHoldId)))
        .setter(setter(CompleteMultipartUploadRequest.Builder::retentionLegalHoldId))
        .traits(LocationTrait.builder().location(MarshallLocation.HEADER)
                             .locationName("retention-legal-hold-id").unmarshallLocationName("retention-legal-hold-id").build())
        .build();

    private static final SdkField<Long> RETENTION_PERIOD_FIELD = SdkField
        .<Long>builder(MarshallingType.LONG)
        .memberName("RetentionPeriod")
        .getter((getter(CompleteMultipartUploadRequest::retentionPeriod)))
        .setter(setter(CompleteMultipartUploadRequest.Builder::retentionPeriod))
        .traits(LocationTrait.builder().location(MarshallLocation.HEADER)
                             .locationName("retention-period").unmarshallLocationName("retention-period").build())
        .build();

    private static final List<SdkField<?>> SDK_FIELDS = Collections.unmodifiableList(Arrays.asList(BUCKET_FIELD, KEY_FIELD,
            MULTIPART_UPLOAD_FIELD, UPLOAD_ID_FIELD, CHECKSUM_CRC32_FIELD, CHECKSUM_CRC32_C_FIELD, CHECKSUM_CRC64_NVME_FIELD,
            CHECKSUM_SHA1_FIELD, CHECKSUM_SHA256_FIELD, CHECKSUM_TYPE_FIELD, MPU_OBJECT_SIZE_FIELD, REQUEST_PAYER_FIELD,
            EXPECTED_BUCKET_OWNER_FIELD, IF_MATCH_FIELD, IF_NONE_MATCH_FIELD, SSE_CUSTOMER_ALGORITHM_FIELD,
            SSE_CUSTOMER_KEY_FIELD, SSE_CUSTOMER_KEY_MD5_FIELD,
            RETENTION_EXPIRATION_DATE_FIELD, RETENTION_LEGAL_HOLD_ID_FIELD, RETENTION_PERIOD_FIELD));

    private static final Map<String, SdkField<?>> SDK_NAME_TO_FIELD = memberNameToFieldInitializer();

    private final String bucket;

    private final String key;

    private final CompletedMultipartUpload multipartUpload;

    private final String uploadId;

    private final String checksumCRC32;

    private final String checksumCRC32C;

    private final String checksumCRC64NVME;

    private final String checksumSHA1;

    private final String checksumSHA256;

    private final String checksumType;

    private final Long mpuObjectSize;

    private final String requestPayer;

    private final String expectedBucketOwner;

    private final String ifMatch;

    private final String ifNoneMatch;

    private final String sseCustomerAlgorithm;

    private final String sseCustomerKey;

    private final String sseCustomerKeyMD5;

    /*********************************** IBM Supported *********************************************/

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

    private CompleteMultipartUploadRequest(BuilderImpl builder) {
        super(builder);
        this.bucket = builder.bucket;
        this.key = builder.key;
        this.multipartUpload = builder.multipartUpload;
        this.uploadId = builder.uploadId;
        this.checksumCRC32 = builder.checksumCRC32;
        this.checksumCRC32C = builder.checksumCRC32C;
        this.checksumCRC64NVME = builder.checksumCRC64NVME;
        this.checksumSHA1 = builder.checksumSHA1;
        this.checksumSHA256 = builder.checksumSHA256;
        this.checksumType = builder.checksumType;
        this.mpuObjectSize = builder.mpuObjectSize;
        this.requestPayer = builder.requestPayer;
        this.expectedBucketOwner = builder.expectedBucketOwner;
        this.ifMatch = builder.ifMatch;
        this.ifNoneMatch = builder.ifNoneMatch;
        this.sseCustomerAlgorithm = builder.sseCustomerAlgorithm;
        this.sseCustomerKey = builder.sseCustomerKey;
        this.sseCustomerKeyMD5 = builder.sseCustomerKeyMD5;
        this.retentionExpirationDate = builder.retentionExpirationDate;
        this.retentionLegalHoldId = builder.retentionLegalHoldId;
        this.retentionPeriod = builder.retentionPeriod;
    }

    /**
     * <p>
     * Name of the bucket to which the multipart upload was initiated.
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
     * @return Name of the bucket to which the multipart upload was initiated.</p>
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
     * Object key for which the multipart upload was initiated.
     * </p>
     * 
     * @return Object key for which the multipart upload was initiated.
     */
    public final String key() {
        return key;
    }

    /**
     * <p>
     * The container for the multipart upload request information.
     * </p>
     * 
     * @return The container for the multipart upload request information.
     */
    public final CompletedMultipartUpload multipartUpload() {
        return multipartUpload;
    }

    /**
     * <p>
     * ID for the initiated multipart upload.
     * </p>
     * 
     * @return ID for the initiated multipart upload.
     */
    public final String uploadId() {
        return uploadId;
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
     * This header specifies the checksum type of the object, which determines how part-level checksums are combined to
     * create an object-level checksum for multipart objects. You can use this header as a data integrity check to
     * verify that the checksum type that is received is the same checksum that was specified. If the checksum type
     * doesn’t match the checksum type that was specified for the object during the <code>CreateMultipartUpload</code>
     * request, it’ll result in a <code>BadDigest</code> error. For more information, see Checking object integrity in
     * the Amazon S3 User Guide.
     * </p>
     * <p>
     * If the service returns an enum value that is not available in the current SDK version, {@link #checksumType} will
     * return {@link ChecksumType#UNKNOWN_TO_SDK_VERSION}. The raw value returned by the service is available from
     * {@link #checksumTypeAsString}.
     * </p>
     * 
     * @return This header specifies the checksum type of the object, which determines how part-level checksums are
     *         combined to create an object-level checksum for multipart objects. You can use this header as a data
     *         integrity check to verify that the checksum type that is received is the same checksum that was
     *         specified. If the checksum type doesn’t match the checksum type that was specified for the object during
     *         the <code>CreateMultipartUpload</code> request, it’ll result in a <code>BadDigest</code> error. For more
     *         information, see Checking object integrity in the Amazon S3 User Guide.
     * @see ChecksumType
     */
    public final ChecksumType checksumType() {
        return ChecksumType.fromValue(checksumType);
    }

    /**
     * <p>
     * This header specifies the checksum type of the object, which determines how part-level checksums are combined to
     * create an object-level checksum for multipart objects. You can use this header as a data integrity check to
     * verify that the checksum type that is received is the same checksum that was specified. If the checksum type
     * doesn’t match the checksum type that was specified for the object during the <code>CreateMultipartUpload</code>
     * request, it’ll result in a <code>BadDigest</code> error. For more information, see Checking object integrity in
     * the Amazon S3 User Guide.
     * </p>
     * <p>
     * If the service returns an enum value that is not available in the current SDK version, {@link #checksumType} will
     * return {@link ChecksumType#UNKNOWN_TO_SDK_VERSION}. The raw value returned by the service is available from
     * {@link #checksumTypeAsString}.
     * </p>
     * 
     * @return This header specifies the checksum type of the object, which determines how part-level checksums are
     *         combined to create an object-level checksum for multipart objects. You can use this header as a data
     *         integrity check to verify that the checksum type that is received is the same checksum that was
     *         specified. If the checksum type doesn’t match the checksum type that was specified for the object during
     *         the <code>CreateMultipartUpload</code> request, it’ll result in a <code>BadDigest</code> error. For more
     *         information, see Checking object integrity in the Amazon S3 User Guide.
     * @see ChecksumType
     */
    public final String checksumTypeAsString() {
        return checksumType;
    }

    /**
     * <p>
     * The expected total object size of the multipart upload request. If there’s a mismatch between the specified
     * object size value and the actual object size value, it results in an <code>HTTP 400 InvalidRequest</code> error.
     * </p>
     * 
     * @return The expected total object size of the multipart upload request. If there’s a mismatch between the
     *         specified object size value and the actual object size value, it results in an
     *         <code>HTTP 400 InvalidRequest</code> error.
     */
    public final Long mpuObjectSize() {
        return mpuObjectSize;
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

    /**
     * <p>
     * Uploads the object only if the ETag (entity tag) value provided during the WRITE operation matches the ETag of
     * the object in S3. If the ETag values do not match, the operation returns a <code>412 Precondition Failed</code>
     * error.
     * </p>
     * <p>
     * If a conflicting operation occurs during the upload S3 returns a <code>409 ConditionalRequestConflict</code>
     * response. On a 409 failure you should fetch the object's ETag, re-initiate the multipart upload with
     * <code>CreateMultipartUpload</code>, and re-upload each part.
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
     *         <code>409 ConditionalRequestConflict</code> response. On a 409 failure you should fetch the object's
     *         ETag, re-initiate the multipart upload with <code>CreateMultipartUpload</code>, and re-upload each part.
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
     * response. On a 409 failure you should re-initiate the multipart upload with <code>CreateMultipartUpload</code>
     * and re-upload each part.
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
     *         <code>409 ConditionalRequestConflict</code> response. On a 409 failure you should re-initiate the
     *         multipart upload with <code>CreateMultipartUpload</code> and re-upload each part.
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
     * The server-side encryption (SSE) algorithm used to encrypt the object. This parameter is required only when the
     * object was created using a checksum algorithm or if your bucket policy requires the use of SSE-C. For more
     * information, see <a href=
     * "https://docs.aws.amazon.com/AmazonS3/latest/userguide/ServerSideEncryptionCustomerKeys.html#ssec-require-condition-key"
     * >Protecting data using SSE-C keys</a> in the <i>Amazon S3 User Guide</i>.
     * </p>
     * <note>
     * <p>
     * This functionality is not supported for directory buckets.
     * </p>
     * </note>
     * 
     * @return The server-side encryption (SSE) algorithm used to encrypt the object. This parameter is required only
     *         when the object was created using a checksum algorithm or if your bucket policy requires the use of
     *         SSE-C. For more information, see <a href=
     *         "https://docs.aws.amazon.com/AmazonS3/latest/userguide/ServerSideEncryptionCustomerKeys.html#ssec-require-condition-key"
     *         >Protecting data using SSE-C keys</a> in the <i>Amazon S3 User Guide</i>.</p> <note>
     *         <p>
     *         This functionality is not supported for directory buckets.
     *         </p>
     */
    public final String sseCustomerAlgorithm() {
        return sseCustomerAlgorithm;
    }

    /**
     * <p>
     * The server-side encryption (SSE) customer managed key. This parameter is needed only when the object was created
     * using a checksum algorithm. For more information, see <a
     * href="https://docs.aws.amazon.com/AmazonS3/latest/dev/ServerSideEncryptionCustomerKeys.html">Protecting data
     * using SSE-C keys</a> in the <i>Amazon S3 User Guide</i>.
     * </p>
     * <note>
     * <p>
     * This functionality is not supported for directory buckets.
     * </p>
     * </note>
     * 
     * @return The server-side encryption (SSE) customer managed key. This parameter is needed only when the object was
     *         created using a checksum algorithm. For more information, see <a
     *         href="https://docs.aws.amazon.com/AmazonS3/latest/dev/ServerSideEncryptionCustomerKeys.html">Protecting
     *         data using SSE-C keys</a> in the <i>Amazon S3 User Guide</i>.</p> <note>
     *         <p>
     *         This functionality is not supported for directory buckets.
     *         </p>
     */
    public final String sseCustomerKey() {
        return sseCustomerKey;
    }

    /**
     * <p>
     * The MD5 server-side encryption (SSE) customer managed key. This parameter is needed only when the object was
     * created using a checksum algorithm. For more information, see <a
     * href="https://docs.aws.amazon.com/AmazonS3/latest/dev/ServerSideEncryptionCustomerKeys.html">Protecting data
     * using SSE-C keys</a> in the <i>Amazon S3 User Guide</i>.
     * </p>
     * <note>
     * <p>
     * This functionality is not supported for directory buckets.
     * </p>
     * </note>
     * 
     * @return The MD5 server-side encryption (SSE) customer managed key. This parameter is needed only when the object
     *         was created using a checksum algorithm. For more information, see <a
     *         href="https://docs.aws.amazon.com/AmazonS3/latest/dev/ServerSideEncryptionCustomerKeys.html">Protecting
     *         data using SSE-C keys</a> in the <i>Amazon S3 User Guide</i>.</p> <note>
     *         <p>
     *         This functionality is not supported for directory buckets.
     *         </p>
     */
    public final String sseCustomerKeyMD5() {
        return sseCustomerKeyMD5;
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
        hashCode = 31 * hashCode + Objects.hashCode(bucket());
        hashCode = 31 * hashCode + Objects.hashCode(key());
        hashCode = 31 * hashCode + Objects.hashCode(multipartUpload());
        hashCode = 31 * hashCode + Objects.hashCode(uploadId());
        hashCode = 31 * hashCode + Objects.hashCode(checksumCRC32());
        hashCode = 31 * hashCode + Objects.hashCode(checksumCRC32C());
        hashCode = 31 * hashCode + Objects.hashCode(checksumCRC64NVME());
        hashCode = 31 * hashCode + Objects.hashCode(checksumSHA1());
        hashCode = 31 * hashCode + Objects.hashCode(checksumSHA256());
        hashCode = 31 * hashCode + Objects.hashCode(checksumTypeAsString());
        hashCode = 31 * hashCode + Objects.hashCode(mpuObjectSize());
        hashCode = 31 * hashCode + Objects.hashCode(requestPayerAsString());
        hashCode = 31 * hashCode + Objects.hashCode(expectedBucketOwner());
        hashCode = 31 * hashCode + Objects.hashCode(ifMatch());
        hashCode = 31 * hashCode + Objects.hashCode(ifNoneMatch());
        hashCode = 31 * hashCode + Objects.hashCode(sseCustomerAlgorithm());
        hashCode = 31 * hashCode + Objects.hashCode(sseCustomerKey());
        hashCode = 31 * hashCode + Objects.hashCode(sseCustomerKeyMD5());
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
        if (!(obj instanceof CompleteMultipartUploadRequest)) {
            return false;
        }
        CompleteMultipartUploadRequest other = (CompleteMultipartUploadRequest) obj;
        return Objects.equals(bucket(), other.bucket()) && Objects.equals(key(), other.key())
                && Objects.equals(multipartUpload(), other.multipartUpload()) && Objects.equals(uploadId(), other.uploadId())
                && Objects.equals(checksumCRC32(), other.checksumCRC32())
                && Objects.equals(checksumCRC32C(), other.checksumCRC32C())
                && Objects.equals(checksumCRC64NVME(), other.checksumCRC64NVME())
                && Objects.equals(checksumSHA1(), other.checksumSHA1())
                && Objects.equals(checksumSHA256(), other.checksumSHA256())
                && Objects.equals(checksumTypeAsString(), other.checksumTypeAsString())
                && Objects.equals(mpuObjectSize(), other.mpuObjectSize())
                && Objects.equals(requestPayerAsString(), other.requestPayerAsString())
                && Objects.equals(expectedBucketOwner(), other.expectedBucketOwner())
                && Objects.equals(ifMatch(), other.ifMatch()) && Objects.equals(ifNoneMatch(), other.ifNoneMatch())
                && Objects.equals(sseCustomerAlgorithm(), other.sseCustomerAlgorithm())
                && Objects.equals(sseCustomerKey(), other.sseCustomerKey())
                && Objects.equals(sseCustomerKeyMD5(), other.sseCustomerKeyMD5())
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
        return ToString.builder("CompleteMultipartUploadRequest").add("Bucket", bucket()).add("Key", key())
                .add("MultipartUpload", multipartUpload()).add("UploadId", uploadId()).add("ChecksumCRC32", checksumCRC32())
                .add("ChecksumCRC32C", checksumCRC32C()).add("ChecksumCRC64NVME", checksumCRC64NVME())
                .add("ChecksumSHA1", checksumSHA1()).add("ChecksumSHA256", checksumSHA256())
                .add("ChecksumType", checksumTypeAsString()).add("MpuObjectSize", mpuObjectSize())
                .add("RequestPayer", requestPayerAsString()).add("ExpectedBucketOwner", expectedBucketOwner())
                .add("IfMatch", ifMatch()).add("IfNoneMatch", ifNoneMatch()).add("SSECustomerAlgorithm", sseCustomerAlgorithm())
                .add("SSECustomerKey", sseCustomerKey() == null ? null : "*** Sensitive Data Redacted ***")
                .add("SSECustomerKeyMD5", sseCustomerKeyMD5()).add("RetentionExpirationDate",retentionExpirationDate())
                       .add("RetentionLegalHoldId",retentionLegalHoldId()).add("RetentionPeriod",retentionPeriod()).build();
    }

    public final <T> Optional<T> getValueForField(String fieldName, Class<T> clazz) {
        switch (fieldName) {
        case "Bucket":
            return Optional.ofNullable(clazz.cast(bucket()));
        case "Key":
            return Optional.ofNullable(clazz.cast(key()));
        case "MultipartUpload":
            return Optional.ofNullable(clazz.cast(multipartUpload()));
        case "UploadId":
            return Optional.ofNullable(clazz.cast(uploadId()));
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
        case "ChecksumType":
            return Optional.ofNullable(clazz.cast(checksumTypeAsString()));
        case "MpuObjectSize":
            return Optional.ofNullable(clazz.cast(mpuObjectSize()));
        case "RequestPayer":
            return Optional.ofNullable(clazz.cast(requestPayerAsString()));
        case "ExpectedBucketOwner":
            return Optional.ofNullable(clazz.cast(expectedBucketOwner()));
        case "IfMatch":
            return Optional.ofNullable(clazz.cast(ifMatch()));
        case "IfNoneMatch":
            return Optional.ofNullable(clazz.cast(ifNoneMatch()));
        case "SSECustomerAlgorithm":
            return Optional.ofNullable(clazz.cast(sseCustomerAlgorithm()));
        case "SSECustomerKey":
            return Optional.ofNullable(clazz.cast(sseCustomerKey()));
        case "SSECustomerKeyMD5":
            return Optional.ofNullable(clazz.cast(sseCustomerKeyMD5()));
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
        map.put("Bucket", BUCKET_FIELD);
        map.put("Key", KEY_FIELD);
        map.put("CompleteMultipartUpload", MULTIPART_UPLOAD_FIELD);
        map.put("uploadId", UPLOAD_ID_FIELD);
        map.put("x-amz-checksum-crc32", CHECKSUM_CRC32_FIELD);
        map.put("x-amz-checksum-crc32c", CHECKSUM_CRC32_C_FIELD);
        map.put("x-amz-checksum-crc64nvme", CHECKSUM_CRC64_NVME_FIELD);
        map.put("x-amz-checksum-sha1", CHECKSUM_SHA1_FIELD);
        map.put("x-amz-checksum-sha256", CHECKSUM_SHA256_FIELD);
        map.put("x-amz-checksum-type", CHECKSUM_TYPE_FIELD);
        map.put("x-amz-mp-object-size", MPU_OBJECT_SIZE_FIELD);
        map.put("x-amz-request-payer", REQUEST_PAYER_FIELD);
        map.put("x-amz-expected-bucket-owner", EXPECTED_BUCKET_OWNER_FIELD);
        map.put("If-Match", IF_MATCH_FIELD);
        map.put("If-None-Match", IF_NONE_MATCH_FIELD);
        map.put("x-amz-server-side-encryption-customer-algorithm", SSE_CUSTOMER_ALGORITHM_FIELD);
        map.put("x-amz-server-side-encryption-customer-key", SSE_CUSTOMER_KEY_FIELD);
        map.put("x-amz-server-side-encryption-customer-key-MD5", SSE_CUSTOMER_KEY_MD5_FIELD);
        map.put("retention-expiration-date", RETENTION_EXPIRATION_DATE_FIELD);
        map.put("retention-legal-hold-id", RETENTION_LEGAL_HOLD_ID_FIELD);
        map.put("retention-period", RETENTION_PERIOD_FIELD);
        return Collections.unmodifiableMap(map);
    }

    private static <T> Function<Object, T> getter(Function<CompleteMultipartUploadRequest, T> g) {
        return obj -> g.apply((CompleteMultipartUploadRequest) obj);
    }

    private static <T> BiConsumer<Object, T> setter(BiConsumer<Builder, T> s) {
        return (obj, val) -> s.accept((Builder) obj, val);
    }

    @Mutable
    @NotThreadSafe
    public interface Builder extends S3Request.Builder, SdkPojo, CopyableBuilder<Builder, CompleteMultipartUploadRequest> {
        /**
         * <p>
         * Name of the bucket to which the multipart upload was initiated.
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
         *        Name of the bucket to which the multipart upload was initiated.</p>
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
         * Object key for which the multipart upload was initiated.
         * </p>
         * 
         * @param key
         *        Object key for which the multipart upload was initiated.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder key(String key);

        /**
         * <p>
         * The container for the multipart upload request information.
         * </p>
         * 
         * @param multipartUpload
         *        The container for the multipart upload request information.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder multipartUpload(CompletedMultipartUpload multipartUpload);

        /**
         * <p>
         * The container for the multipart upload request information.
         * </p>
         * This is a convenience method that creates an instance of the {@link CompletedMultipartUpload.Builder}
         * avoiding the need to create one manually via {@link CompletedMultipartUpload#builder()}.
         *
         * <p>
         * When the {@link Consumer} completes, {@link CompletedMultipartUpload.Builder#build()} is called immediately
         * and its result is passed to {@link #multipartUpload(CompletedMultipartUpload)}.
         * 
         * @param multipartUpload
         *        a consumer that will call methods on {@link CompletedMultipartUpload.Builder}
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see #multipartUpload(CompletedMultipartUpload)
         */
        default Builder multipartUpload(Consumer<CompletedMultipartUpload.Builder> multipartUpload) {
            return multipartUpload(CompletedMultipartUpload.builder().applyMutation(multipartUpload).build());
        }

        /**
         * <p>
         * ID for the initiated multipart upload.
         * </p>
         * 
         * @param uploadId
         *        ID for the initiated multipart upload.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder uploadId(String uploadId);

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
         * This header specifies the checksum type of the object, which determines how part-level checksums are combined
         * to create an object-level checksum for multipart objects. You can use this header as a data integrity check
         * to verify that the checksum type that is received is the same checksum that was specified. If the checksum
         * type doesn’t match the checksum type that was specified for the object during the
         * <code>CreateMultipartUpload</code> request, it’ll result in a <code>BadDigest</code> error. For more
         * information, see Checking object integrity in the Amazon S3 User Guide.
         * </p>
         * 
         * @param checksumType
         *        This header specifies the checksum type of the object, which determines how part-level checksums are
         *        combined to create an object-level checksum for multipart objects. You can use this header as a data
         *        integrity check to verify that the checksum type that is received is the same checksum that was
         *        specified. If the checksum type doesn’t match the checksum type that was specified for the object
         *        during the <code>CreateMultipartUpload</code> request, it’ll result in a <code>BadDigest</code> error.
         *        For more information, see Checking object integrity in the Amazon S3 User Guide.
         * @see ChecksumType
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see ChecksumType
         */
        Builder checksumType(String checksumType);

        /**
         * <p>
         * This header specifies the checksum type of the object, which determines how part-level checksums are combined
         * to create an object-level checksum for multipart objects. You can use this header as a data integrity check
         * to verify that the checksum type that is received is the same checksum that was specified. If the checksum
         * type doesn’t match the checksum type that was specified for the object during the
         * <code>CreateMultipartUpload</code> request, it’ll result in a <code>BadDigest</code> error. For more
         * information, see Checking object integrity in the Amazon S3 User Guide.
         * </p>
         * 
         * @param checksumType
         *        This header specifies the checksum type of the object, which determines how part-level checksums are
         *        combined to create an object-level checksum for multipart objects. You can use this header as a data
         *        integrity check to verify that the checksum type that is received is the same checksum that was
         *        specified. If the checksum type doesn’t match the checksum type that was specified for the object
         *        during the <code>CreateMultipartUpload</code> request, it’ll result in a <code>BadDigest</code> error.
         *        For more information, see Checking object integrity in the Amazon S3 User Guide.
         * @see ChecksumType
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see ChecksumType
         */
        Builder checksumType(ChecksumType checksumType);

        /**
         * <p>
         * The expected total object size of the multipart upload request. If there’s a mismatch between the specified
         * object size value and the actual object size value, it results in an <code>HTTP 400 InvalidRequest</code>
         * error.
         * </p>
         * 
         * @param mpuObjectSize
         *        The expected total object size of the multipart upload request. If there’s a mismatch between the
         *        specified object size value and the actual object size value, it results in an
         *        <code>HTTP 400 InvalidRequest</code> error.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder mpuObjectSize(Long mpuObjectSize);

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

        /**
         * <p>
         * Uploads the object only if the ETag (entity tag) value provided during the WRITE operation matches the ETag
         * of the object in S3. If the ETag values do not match, the operation returns a
         * <code>412 Precondition Failed</code> error.
         * </p>
         * <p>
         * If a conflicting operation occurs during the upload S3 returns a <code>409 ConditionalRequestConflict</code>
         * response. On a 409 failure you should fetch the object's ETag, re-initiate the multipart upload with
         * <code>CreateMultipartUpload</code>, and re-upload each part.
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
         *        ETag, re-initiate the multipart upload with <code>CreateMultipartUpload</code>, and re-upload each
         *        part.
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
         * response. On a 409 failure you should re-initiate the multipart upload with
         * <code>CreateMultipartUpload</code> and re-upload each part.
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
         *        <code>409 ConditionalRequestConflict</code> response. On a 409 failure you should re-initiate the
         *        multipart upload with <code>CreateMultipartUpload</code> and re-upload each part.
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
         * The server-side encryption (SSE) algorithm used to encrypt the object. This parameter is required only when
         * the object was created using a checksum algorithm or if your bucket policy requires the use of SSE-C. For
         * more information, see <a href=
         * "https://docs.aws.amazon.com/AmazonS3/latest/userguide/ServerSideEncryptionCustomerKeys.html#ssec-require-condition-key"
         * >Protecting data using SSE-C keys</a> in the <i>Amazon S3 User Guide</i>.
         * </p>
         * <note>
         * <p>
         * This functionality is not supported for directory buckets.
         * </p>
         * </note>
         * 
         * @param sseCustomerAlgorithm
         *        The server-side encryption (SSE) algorithm used to encrypt the object. This parameter is required only
         *        when the object was created using a checksum algorithm or if your bucket policy requires the use of
         *        SSE-C. For more information, see <a href=
         *        "https://docs.aws.amazon.com/AmazonS3/latest/userguide/ServerSideEncryptionCustomerKeys.html#ssec-require-condition-key"
         *        >Protecting data using SSE-C keys</a> in the <i>Amazon S3 User Guide</i>.</p> <note>
         *        <p>
         *        This functionality is not supported for directory buckets.
         *        </p>
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder sseCustomerAlgorithm(String sseCustomerAlgorithm);

        /**
         * <p>
         * The server-side encryption (SSE) customer managed key. This parameter is needed only when the object was
         * created using a checksum algorithm. For more information, see <a
         * href="https://docs.aws.amazon.com/AmazonS3/latest/dev/ServerSideEncryptionCustomerKeys.html">Protecting data
         * using SSE-C keys</a> in the <i>Amazon S3 User Guide</i>.
         * </p>
         * <note>
         * <p>
         * This functionality is not supported for directory buckets.
         * </p>
         * </note>
         * 
         * @param sseCustomerKey
         *        The server-side encryption (SSE) customer managed key. This parameter is needed only when the object
         *        was created using a checksum algorithm. For more information, see <a
         *        href="https://docs.aws.amazon.com/AmazonS3/latest/dev/ServerSideEncryptionCustomerKeys.html"
         *        >Protecting data using SSE-C keys</a> in the <i>Amazon S3 User Guide</i>.</p> <note>
         *        <p>
         *        This functionality is not supported for directory buckets.
         *        </p>
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder sseCustomerKey(String sseCustomerKey);

        /**
         * <p>
         * The MD5 server-side encryption (SSE) customer managed key. This parameter is needed only when the object was
         * created using a checksum algorithm. For more information, see <a
         * href="https://docs.aws.amazon.com/AmazonS3/latest/dev/ServerSideEncryptionCustomerKeys.html">Protecting data
         * using SSE-C keys</a> in the <i>Amazon S3 User Guide</i>.
         * </p>
         * <note>
         * <p>
         * This functionality is not supported for directory buckets.
         * </p>
         * </note>
         * 
         * @param sseCustomerKeyMD5
         *        The MD5 server-side encryption (SSE) customer managed key. This parameter is needed only when the
         *        object was created using a checksum algorithm. For more information, see <a
         *        href="https://docs.aws.amazon.com/AmazonS3/latest/dev/ServerSideEncryptionCustomerKeys.html"
         *        >Protecting data using SSE-C keys</a> in the <i>Amazon S3 User Guide</i>.</p> <note>
         *        <p>
         *        This functionality is not supported for directory buckets.
         *        </p>
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder sseCustomerKeyMD5(String sseCustomerKeyMD5);

        @Override
        Builder overrideConfiguration(AwsRequestOverrideConfiguration overrideConfiguration);

        @Override
        Builder overrideConfiguration(Consumer<AwsRequestOverrideConfiguration.Builder> builderConsumer);

        Builder retentionExpirationDate(Instant retentionExpirationDate);

        Builder retentionLegalHoldId(String retentionLegalHoldId);

        Builder retentionPeriod(Long retentionPeriod);
    }

    static final class BuilderImpl extends S3Request.BuilderImpl implements Builder {
        private String bucket;

        private String key;

        private CompletedMultipartUpload multipartUpload;

        private String uploadId;

        private String checksumCRC32;

        private String checksumCRC32C;

        private String checksumCRC64NVME;

        private String checksumSHA1;

        private String checksumSHA256;

        private String checksumType;

        private Long mpuObjectSize;

        private String requestPayer;

        private String expectedBucketOwner;

        private String ifMatch;

        private String ifNoneMatch;

        private String sseCustomerAlgorithm;

        private String sseCustomerKey;

        private String sseCustomerKeyMD5;

        /*************** IBM Supported **************/
        private Instant retentionExpirationDate;

        private String retentionLegalHoldId;

        private Long retentionPeriod;

        private BuilderImpl() {
        }

        private BuilderImpl(CompleteMultipartUploadRequest model) {
            super(model);
            bucket(model.bucket);
            key(model.key);
            multipartUpload(model.multipartUpload);
            uploadId(model.uploadId);
            checksumCRC32(model.checksumCRC32);
            checksumCRC32C(model.checksumCRC32C);
            checksumCRC64NVME(model.checksumCRC64NVME);
            checksumSHA1(model.checksumSHA1);
            checksumSHA256(model.checksumSHA256);
            checksumType(model.checksumType);
            mpuObjectSize(model.mpuObjectSize);
            requestPayer(model.requestPayer);
            expectedBucketOwner(model.expectedBucketOwner);
            ifMatch(model.ifMatch);
            ifNoneMatch(model.ifNoneMatch);
            sseCustomerAlgorithm(model.sseCustomerAlgorithm);
            sseCustomerKey(model.sseCustomerKey);
            sseCustomerKeyMD5(model.sseCustomerKeyMD5);
            retentionExpirationDate(model.retentionExpirationDate);
            retentionLegalHoldId(model.retentionLegalHoldId);
            retentionPeriod(model.retentionPeriod);
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

        public final CompletedMultipartUpload.Builder getMultipartUpload() {
            return multipartUpload != null ? multipartUpload.toBuilder() : null;
        }

        public final void setMultipartUpload(CompletedMultipartUpload.BuilderImpl multipartUpload) {
            this.multipartUpload = multipartUpload != null ? multipartUpload.build() : null;
        }

        @Override
        public final Builder multipartUpload(CompletedMultipartUpload multipartUpload) {
            this.multipartUpload = multipartUpload;
            return this;
        }

        public final String getUploadId() {
            return uploadId;
        }

        public final void setUploadId(String uploadId) {
            this.uploadId = uploadId;
        }

        @Override
        public final Builder uploadId(String uploadId) {
            this.uploadId = uploadId;
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

        public final String getChecksumType() {
            return checksumType;
        }

        public final void setChecksumType(String checksumType) {
            this.checksumType = checksumType;
        }

        @Override
        public final Builder checksumType(String checksumType) {
            this.checksumType = checksumType;
            return this;
        }

        @Override
        public final Builder checksumType(ChecksumType checksumType) {
            this.checksumType(checksumType == null ? null : checksumType.toString());
            return this;
        }

        public final Long getMpuObjectSize() {
            return mpuObjectSize;
        }

        public final void setMpuObjectSize(Long mpuObjectSize) {
            this.mpuObjectSize = mpuObjectSize;
        }

        @Override
        public final Builder mpuObjectSize(Long mpuObjectSize) {
            this.mpuObjectSize = mpuObjectSize;
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
        public CompleteMultipartUploadRequest build() {
            return new CompleteMultipartUploadRequest(this);
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
