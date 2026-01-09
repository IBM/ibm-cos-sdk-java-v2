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

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.function.Function;
import com.ibm.cos.v2.annotations.Generated;
import com.ibm.cos.v2.annotations.Mutable;
import com.ibm.cos.v2.annotations.NotThreadSafe;
import com.ibm.cos.v2.core.SdkField;
import com.ibm.cos.v2.core.SdkPojo;
import com.ibm.cos.v2.core.protocol.MarshallLocation;
import com.ibm.cos.v2.core.protocol.MarshallingType;
import com.ibm.cos.v2.core.traits.LocationTrait;
import com.ibm.cos.v2.utils.ToString;
import com.ibm.cos.v2.utils.builder.CopyableBuilder;
import com.ibm.cos.v2.utils.builder.ToCopyableBuilder;

/**
 */
@Generated("com.ibm.cos.v2:codegen")
public final class PutObjectResponse extends S3Response implements
        ToCopyableBuilder<PutObjectResponse.Builder, PutObjectResponse> {
    private static final SdkField<String> EXPIRATION_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("Expiration")
            .getter(getter(PutObjectResponse::expiration))
            .setter(setter(Builder::expiration))
            .traits(LocationTrait.builder().location(MarshallLocation.HEADER).locationName("x-amz-expiration")
                    .unmarshallLocationName("x-amz-expiration").build()).build();

    private static final SdkField<String> E_TAG_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("ETag")
            .getter(getter(PutObjectResponse::eTag))
            .setter(setter(Builder::eTag))
            .traits(LocationTrait.builder().location(MarshallLocation.HEADER).locationName("ETag").unmarshallLocationName("ETag")
                    .build()).build();

    private static final SdkField<String> CHECKSUM_CRC32_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("ChecksumCRC32")
            .getter(getter(PutObjectResponse::checksumCRC32))
            .setter(setter(Builder::checksumCRC32))
            .traits(LocationTrait.builder().location(MarshallLocation.HEADER).locationName("x-amz-checksum-crc32")
                    .unmarshallLocationName("x-amz-checksum-crc32").build()).build();

    private static final SdkField<String> CHECKSUM_CRC32_C_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("ChecksumCRC32C")
            .getter(getter(PutObjectResponse::checksumCRC32C))
            .setter(setter(Builder::checksumCRC32C))
            .traits(LocationTrait.builder().location(MarshallLocation.HEADER).locationName("x-amz-checksum-crc32c")
                    .unmarshallLocationName("x-amz-checksum-crc32c").build()).build();

    private static final SdkField<String> CHECKSUM_CRC64_NVME_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("ChecksumCRC64NVME")
            .getter(getter(PutObjectResponse::checksumCRC64NVME))
            .setter(setter(Builder::checksumCRC64NVME))
            .traits(LocationTrait.builder().location(MarshallLocation.HEADER).locationName("x-amz-checksum-crc64nvme")
                    .unmarshallLocationName("x-amz-checksum-crc64nvme").build()).build();

    private static final SdkField<String> CHECKSUM_SHA1_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("ChecksumSHA1")
            .getter(getter(PutObjectResponse::checksumSHA1))
            .setter(setter(Builder::checksumSHA1))
            .traits(LocationTrait.builder().location(MarshallLocation.HEADER).locationName("x-amz-checksum-sha1")
                    .unmarshallLocationName("x-amz-checksum-sha1").build()).build();

    private static final SdkField<String> CHECKSUM_SHA256_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("ChecksumSHA256")
            .getter(getter(PutObjectResponse::checksumSHA256))
            .setter(setter(Builder::checksumSHA256))
            .traits(LocationTrait.builder().location(MarshallLocation.HEADER).locationName("x-amz-checksum-sha256")
                    .unmarshallLocationName("x-amz-checksum-sha256").build()).build();

    private static final SdkField<String> CHECKSUM_TYPE_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("ChecksumType")
            .getter(getter(PutObjectResponse::checksumTypeAsString))
            .setter(setter(Builder::checksumType))
            .traits(LocationTrait.builder().location(MarshallLocation.HEADER).locationName("x-amz-checksum-type")
                    .unmarshallLocationName("x-amz-checksum-type").build()).build();

    private static final SdkField<String> SERVER_SIDE_ENCRYPTION_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("ServerSideEncryption")
            .getter(getter(PutObjectResponse::serverSideEncryptionAsString))
            .setter(setter(Builder::serverSideEncryption))
            .traits(LocationTrait.builder().location(MarshallLocation.HEADER).locationName("x-amz-server-side-encryption")
                    .unmarshallLocationName("x-amz-server-side-encryption").build()).build();

    private static final SdkField<String> VERSION_ID_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("VersionId")
            .getter(getter(PutObjectResponse::versionId))
            .setter(setter(Builder::versionId))
            .traits(LocationTrait.builder().location(MarshallLocation.HEADER).locationName("x-amz-version-id")
                    .unmarshallLocationName("x-amz-version-id").build()).build();

    private static final SdkField<String> SSE_CUSTOMER_ALGORITHM_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("SSECustomerAlgorithm")
            .getter(getter(PutObjectResponse::sseCustomerAlgorithm))
            .setter(setter(Builder::sseCustomerAlgorithm))
            .traits(LocationTrait.builder().location(MarshallLocation.HEADER)
                    .locationName("x-amz-server-side-encryption-customer-algorithm")
                    .unmarshallLocationName("x-amz-server-side-encryption-customer-algorithm").build()).build();

    private static final SdkField<String> SSE_CUSTOMER_KEY_MD5_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("SSECustomerKeyMD5")
            .getter(getter(PutObjectResponse::sseCustomerKeyMD5))
            .setter(setter(Builder::sseCustomerKeyMD5))
            .traits(LocationTrait.builder().location(MarshallLocation.HEADER)
                    .locationName("x-amz-server-side-encryption-customer-key-MD5")
                    .unmarshallLocationName("x-amz-server-side-encryption-customer-key-MD5").build()).build();

    private static final SdkField<String> SSEKMS_KEY_ID_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("SSEKMSKeyId")
            .getter(getter(PutObjectResponse::ssekmsKeyId))
            .setter(setter(Builder::ssekmsKeyId))
            .traits(LocationTrait.builder().location(MarshallLocation.HEADER)
                    .locationName("x-amz-server-side-encryption-aws-kms-key-id")
                    .unmarshallLocationName("x-amz-server-side-encryption-aws-kms-key-id").build()).build();

    private static final SdkField<String> SSEKMS_ENCRYPTION_CONTEXT_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("SSEKMSEncryptionContext")
            .getter(getter(PutObjectResponse::ssekmsEncryptionContext))
            .setter(setter(Builder::ssekmsEncryptionContext))
            .traits(LocationTrait.builder().location(MarshallLocation.HEADER)
                    .locationName("x-amz-server-side-encryption-context")
                    .unmarshallLocationName("x-amz-server-side-encryption-context").build()).build();

    private static final SdkField<Boolean> BUCKET_KEY_ENABLED_FIELD = SdkField
            .<Boolean> builder(MarshallingType.BOOLEAN)
            .memberName("BucketKeyEnabled")
            .getter(getter(PutObjectResponse::bucketKeyEnabled))
            .setter(setter(Builder::bucketKeyEnabled))
            .traits(LocationTrait.builder().location(MarshallLocation.HEADER)
                    .locationName("x-amz-server-side-encryption-bucket-key-enabled")
                    .unmarshallLocationName("x-amz-server-side-encryption-bucket-key-enabled").build()).build();

    private static final SdkField<Long> SIZE_FIELD = SdkField
            .<Long> builder(MarshallingType.LONG)
            .memberName("Size")
            .getter(getter(PutObjectResponse::size))
            .setter(setter(Builder::size))
            .traits(LocationTrait.builder().location(MarshallLocation.HEADER).locationName("x-amz-object-size")
                    .unmarshallLocationName("x-amz-object-size").build()).build();

    private static final SdkField<String> REQUEST_CHARGED_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("RequestCharged")
            .getter(getter(PutObjectResponse::requestChargedAsString))
            .setter(setter(Builder::requestCharged))
            .traits(LocationTrait.builder().location(MarshallLocation.HEADER).locationName("x-amz-request-charged")
                    .unmarshallLocationName("x-amz-request-charged").build()).build();

    private static final List<SdkField<?>> SDK_FIELDS = Collections.unmodifiableList(Arrays.asList(EXPIRATION_FIELD, E_TAG_FIELD,
            CHECKSUM_CRC32_FIELD, CHECKSUM_CRC32_C_FIELD, CHECKSUM_CRC64_NVME_FIELD, CHECKSUM_SHA1_FIELD, CHECKSUM_SHA256_FIELD,
            CHECKSUM_TYPE_FIELD, SERVER_SIDE_ENCRYPTION_FIELD, VERSION_ID_FIELD, SSE_CUSTOMER_ALGORITHM_FIELD,
            SSE_CUSTOMER_KEY_MD5_FIELD, SSEKMS_KEY_ID_FIELD, SSEKMS_ENCRYPTION_CONTEXT_FIELD, BUCKET_KEY_ENABLED_FIELD,
            SIZE_FIELD, REQUEST_CHARGED_FIELD));

    private static final Map<String, SdkField<?>> SDK_NAME_TO_FIELD = memberNameToFieldInitializer();

    private final String expiration;

    private final String eTag;

    private final String checksumCRC32;

    private final String checksumCRC32C;

    private final String checksumCRC64NVME;

    private final String checksumSHA1;

    private final String checksumSHA256;

    private final String checksumType;

    private final String serverSideEncryption;

    private final String versionId;

    private final String sseCustomerAlgorithm;

    private final String sseCustomerKeyMD5;

    private final String ssekmsKeyId;

    private final String ssekmsEncryptionContext;

    private final Boolean bucketKeyEnabled;

    private final Long size;

    private final String requestCharged;

    private PutObjectResponse(BuilderImpl builder) {
        super(builder);
        this.expiration = builder.expiration;
        this.eTag = builder.eTag;
        this.checksumCRC32 = builder.checksumCRC32;
        this.checksumCRC32C = builder.checksumCRC32C;
        this.checksumCRC64NVME = builder.checksumCRC64NVME;
        this.checksumSHA1 = builder.checksumSHA1;
        this.checksumSHA256 = builder.checksumSHA256;
        this.checksumType = builder.checksumType;
        this.serverSideEncryption = builder.serverSideEncryption;
        this.versionId = builder.versionId;
        this.sseCustomerAlgorithm = builder.sseCustomerAlgorithm;
        this.sseCustomerKeyMD5 = builder.sseCustomerKeyMD5;
        this.ssekmsKeyId = builder.ssekmsKeyId;
        this.ssekmsEncryptionContext = builder.ssekmsEncryptionContext;
        this.bucketKeyEnabled = builder.bucketKeyEnabled;
        this.size = builder.size;
        this.requestCharged = builder.requestCharged;
    }

    /**
     * <p>
     * If the expiration is configured for the object (see <a
     * href="https://docs.aws.amazon.com/AmazonS3/latest/API/API_PutBucketLifecycleConfiguration.html"
     * >PutBucketLifecycleConfiguration</a>) in the <i>Amazon S3 User Guide</i>, the response includes this header. It
     * includes the <code>expiry-date</code> and <code>rule-id</code> key-value pairs that provide information about
     * object expiration. The value of the <code>rule-id</code> is URL-encoded.
     * </p>
     * <note>
     * <p>
     * Object expiration information is not returned in directory buckets and this header returns the value "
     * <code>NotImplemented</code>" in all responses for directory buckets.
     * </p>
     * </note>
     * 
     * @return If the expiration is configured for the object (see <a
     *         href="https://docs.aws.amazon.com/AmazonS3/latest/API/API_PutBucketLifecycleConfiguration.html"
     *         >PutBucketLifecycleConfiguration</a>) in the <i>Amazon S3 User Guide</i>, the response includes this
     *         header. It includes the <code>expiry-date</code> and <code>rule-id</code> key-value pairs that provide
     *         information about object expiration. The value of the <code>rule-id</code> is URL-encoded.</p> <note>
     *         <p>
     *         Object expiration information is not returned in directory buckets and this header returns the value "
     *         <code>NotImplemented</code>" in all responses for directory buckets.
     *         </p>
     */
    public final String expiration() {
        return expiration;
    }

    /**
     * <p>
     * Entity tag for the uploaded object.
     * </p>
     * <p>
     * <b>General purpose buckets </b> - To ensure that data is not corrupted traversing the network, for objects where
     * the ETag is the MD5 digest of the object, you can calculate the MD5 while putting an object to Amazon S3 and
     * compare the returned ETag to the calculated MD5 value.
     * </p>
     * <p>
     * <b>Directory buckets </b> - The ETag for the object in a directory bucket isn't the MD5 digest of the object.
     * </p>
     * 
     * @return Entity tag for the uploaded object.</p>
     *         <p>
     *         <b>General purpose buckets </b> - To ensure that data is not corrupted traversing the network, for
     *         objects where the ETag is the MD5 digest of the object, you can calculate the MD5 while putting an object
     *         to Amazon S3 and compare the returned ETag to the calculated MD5 value.
     *         </p>
     *         <p>
     *         <b>Directory buckets </b> - The ETag for the object in a directory bucket isn't the MD5 digest of the
     *         object.
     */
    public final String eTag() {
        return eTag;
    }

    /**
     * <p>
     * The Base64 encoded, 32-bit <code>CRC32 checksum</code> of the object. This checksum is only be present if the
     * checksum was uploaded with the object. When you use an API operation on an object that was uploaded using
     * multipart uploads, this value may not be a direct checksum value of the full object. Instead, it's a calculation
     * based on the checksum values of each individual part. For more information about how checksums are calculated
     * with multipart uploads, see <a href=
     * "https://docs.aws.amazon.com/AmazonS3/latest/userguide/checking-object-integrity.html#large-object-checksums">
     * Checking object integrity</a> in the <i>Amazon S3 User Guide</i>.
     * </p>
     * 
     * @return The Base64 encoded, 32-bit <code>CRC32 checksum</code> of the object. This checksum is only be present if
     *         the checksum was uploaded with the object. When you use an API operation on an object that was uploaded
     *         using multipart uploads, this value may not be a direct checksum value of the full object. Instead, it's
     *         a calculation based on the checksum values of each individual part. For more information about how
     *         checksums are calculated with multipart uploads, see <a href=
     *         "https://docs.aws.amazon.com/AmazonS3/latest/userguide/checking-object-integrity.html#large-object-checksums"
     *         > Checking object integrity</a> in the <i>Amazon S3 User Guide</i>.
     */
    public final String checksumCRC32() {
        return checksumCRC32;
    }

    /**
     * <p>
     * The Base64 encoded, 32-bit <code>CRC32C</code> checksum of the object. This checksum is only present if the
     * checksum was uploaded with the object. When you use an API operation on an object that was uploaded using
     * multipart uploads, this value may not be a direct checksum value of the full object. Instead, it's a calculation
     * based on the checksum values of each individual part. For more information about how checksums are calculated
     * with multipart uploads, see <a href=
     * "https://docs.aws.amazon.com/AmazonS3/latest/userguide/checking-object-integrity.html#large-object-checksums">
     * Checking object integrity</a> in the <i>Amazon S3 User Guide</i>.
     * </p>
     * 
     * @return The Base64 encoded, 32-bit <code>CRC32C</code> checksum of the object. This checksum is only present if
     *         the checksum was uploaded with the object. When you use an API operation on an object that was uploaded
     *         using multipart uploads, this value may not be a direct checksum value of the full object. Instead, it's
     *         a calculation based on the checksum values of each individual part. For more information about how
     *         checksums are calculated with multipart uploads, see <a href=
     *         "https://docs.aws.amazon.com/AmazonS3/latest/userguide/checking-object-integrity.html#large-object-checksums"
     *         > Checking object integrity</a> in the <i>Amazon S3 User Guide</i>.
     */
    public final String checksumCRC32C() {
        return checksumCRC32C;
    }

    /**
     * <p>
     * The Base64 encoded, 64-bit <code>CRC64NVME</code> checksum of the object. This header is present if the object
     * was uploaded with the <code>CRC64NVME</code> checksum algorithm, or if it was uploaded without a checksum (and
     * Amazon S3 added the default checksum, <code>CRC64NVME</code>, to the uploaded object). For more information about
     * how checksums are calculated with multipart uploads, see <a
     * href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/checking-object-integrity.html">Checking object
     * integrity in the Amazon S3 User Guide</a>.
     * </p>
     * 
     * @return The Base64 encoded, 64-bit <code>CRC64NVME</code> checksum of the object. This header is present if the
     *         object was uploaded with the <code>CRC64NVME</code> checksum algorithm, or if it was uploaded without a
     *         checksum (and Amazon S3 added the default checksum, <code>CRC64NVME</code>, to the uploaded object). For
     *         more information about how checksums are calculated with multipart uploads, see <a
     *         href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/checking-object-integrity.html">Checking
     *         object integrity in the Amazon S3 User Guide</a>.
     */
    public final String checksumCRC64NVME() {
        return checksumCRC64NVME;
    }

    /**
     * <p>
     * The Base64 encoded, 160-bit <code>SHA1</code> digest of the object. This will only be present if the object was
     * uploaded with the object. When you use the API operation on an object that was uploaded using multipart uploads,
     * this value may not be a direct checksum value of the full object. Instead, it's a calculation based on the
     * checksum values of each individual part. For more information about how checksums are calculated with multipart
     * uploads, see <a href=
     * "https://docs.aws.amazon.com/AmazonS3/latest/userguide/checking-object-integrity.html#large-object-checksums">
     * Checking object integrity</a> in the <i>Amazon S3 User Guide</i>.
     * </p>
     * 
     * @return The Base64 encoded, 160-bit <code>SHA1</code> digest of the object. This will only be present if the
     *         object was uploaded with the object. When you use the API operation on an object that was uploaded using
     *         multipart uploads, this value may not be a direct checksum value of the full object. Instead, it's a
     *         calculation based on the checksum values of each individual part. For more information about how
     *         checksums are calculated with multipart uploads, see <a href=
     *         "https://docs.aws.amazon.com/AmazonS3/latest/userguide/checking-object-integrity.html#large-object-checksums"
     *         > Checking object integrity</a> in the <i>Amazon S3 User Guide</i>.
     */
    public final String checksumSHA1() {
        return checksumSHA1;
    }

    /**
     * <p>
     * The Base64 encoded, 256-bit <code>SHA256</code> digest of the object. This will only be present if the object was
     * uploaded with the object. When you use an API operation on an object that was uploaded using multipart uploads,
     * this value may not be a direct checksum value of the full object. Instead, it's a calculation based on the
     * checksum values of each individual part. For more information about how checksums are calculated with multipart
     * uploads, see <a href=
     * "https://docs.aws.amazon.com/AmazonS3/latest/userguide/checking-object-integrity.html#large-object-checksums">
     * Checking object integrity</a> in the <i>Amazon S3 User Guide</i>.
     * </p>
     * 
     * @return The Base64 encoded, 256-bit <code>SHA256</code> digest of the object. This will only be present if the
     *         object was uploaded with the object. When you use an API operation on an object that was uploaded using
     *         multipart uploads, this value may not be a direct checksum value of the full object. Instead, it's a
     *         calculation based on the checksum values of each individual part. For more information about how
     *         checksums are calculated with multipart uploads, see <a href=
     *         "https://docs.aws.amazon.com/AmazonS3/latest/userguide/checking-object-integrity.html#large-object-checksums"
     *         > Checking object integrity</a> in the <i>Amazon S3 User Guide</i>.
     */
    public final String checksumSHA256() {
        return checksumSHA256;
    }

    /**
     * <p>
     * This header specifies the checksum type of the object, which determines how part-level checksums are combined to
     * create an object-level checksum for multipart objects. For <code>PutObject</code> uploads, the checksum type is
     * always <code>FULL_OBJECT</code>. You can use this header as a data integrity check to verify that the checksum
     * type that is received is the same checksum that was specified. For more information, see <a
     * href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/checking-object-integrity.html">Checking object
     * integrity</a> in the <i>Amazon S3 User Guide</i>.
     * </p>
     * <p>
     * If the service returns an enum value that is not available in the current SDK version, {@link #checksumType} will
     * return {@link ChecksumType#UNKNOWN_TO_SDK_VERSION}. The raw value returned by the service is available from
     * {@link #checksumTypeAsString}.
     * </p>
     * 
     * @return This header specifies the checksum type of the object, which determines how part-level checksums are
     *         combined to create an object-level checksum for multipart objects. For <code>PutObject</code> uploads,
     *         the checksum type is always <code>FULL_OBJECT</code>. You can use this header as a data integrity check
     *         to verify that the checksum type that is received is the same checksum that was specified. For more
     *         information, see <a
     *         href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/checking-object-integrity.html">Checking
     *         object integrity</a> in the <i>Amazon S3 User Guide</i>.
     * @see ChecksumType
     */
    public final ChecksumType checksumType() {
        return ChecksumType.fromValue(checksumType);
    }

    /**
     * <p>
     * This header specifies the checksum type of the object, which determines how part-level checksums are combined to
     * create an object-level checksum for multipart objects. For <code>PutObject</code> uploads, the checksum type is
     * always <code>FULL_OBJECT</code>. You can use this header as a data integrity check to verify that the checksum
     * type that is received is the same checksum that was specified. For more information, see <a
     * href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/checking-object-integrity.html">Checking object
     * integrity</a> in the <i>Amazon S3 User Guide</i>.
     * </p>
     * <p>
     * If the service returns an enum value that is not available in the current SDK version, {@link #checksumType} will
     * return {@link ChecksumType#UNKNOWN_TO_SDK_VERSION}. The raw value returned by the service is available from
     * {@link #checksumTypeAsString}.
     * </p>
     * 
     * @return This header specifies the checksum type of the object, which determines how part-level checksums are
     *         combined to create an object-level checksum for multipart objects. For <code>PutObject</code> uploads,
     *         the checksum type is always <code>FULL_OBJECT</code>. You can use this header as a data integrity check
     *         to verify that the checksum type that is received is the same checksum that was specified. For more
     *         information, see <a
     *         href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/checking-object-integrity.html">Checking
     *         object integrity</a> in the <i>Amazon S3 User Guide</i>.
     * @see ChecksumType
     */
    public final String checksumTypeAsString() {
        return checksumType;
    }

    /**
     * <p>
     * The server-side encryption algorithm used when you store this object in Amazon S3.
     * </p>
     * <p>
     * If the service returns an enum value that is not available in the current SDK version,
     * {@link #serverSideEncryption} will return {@link ServerSideEncryption#UNKNOWN_TO_SDK_VERSION}. The raw value
     * returned by the service is available from {@link #serverSideEncryptionAsString}.
     * </p>
     * 
     * @return The server-side encryption algorithm used when you store this object in Amazon S3.
     * @see ServerSideEncryption
     */
    public final ServerSideEncryption serverSideEncryption() {
        return ServerSideEncryption.fromValue(serverSideEncryption);
    }

    /**
     * <p>
     * The server-side encryption algorithm used when you store this object in Amazon S3.
     * </p>
     * <p>
     * If the service returns an enum value that is not available in the current SDK version,
     * {@link #serverSideEncryption} will return {@link ServerSideEncryption#UNKNOWN_TO_SDK_VERSION}. The raw value
     * returned by the service is available from {@link #serverSideEncryptionAsString}.
     * </p>
     * 
     * @return The server-side encryption algorithm used when you store this object in Amazon S3.
     * @see ServerSideEncryption
     */
    public final String serverSideEncryptionAsString() {
        return serverSideEncryption;
    }

    /**
     * <p>
     * Version ID of the object.
     * </p>
     * <p>
     * If you enable versioning for a bucket, Amazon S3 automatically generates a unique version ID for the object being
     * stored. Amazon S3 returns this ID in the response. When you enable versioning for a bucket, if Amazon S3 receives
     * multiple write requests for the same object simultaneously, it stores all of the objects. For more information
     * about versioning, see <a
     * href="https://docs.aws.amazon.com/AmazonS3/latest/dev/AddingObjectstoVersioningEnabledBuckets.html">Adding
     * Objects to Versioning-Enabled Buckets</a> in the <i>Amazon S3 User Guide</i>. For information about returning the
     * versioning state of a bucket, see <a
     * href="https://docs.aws.amazon.com/AmazonS3/latest/API/API_GetBucketVersioning.html">GetBucketVersioning</a>.
     * </p>
     * <note>
     * <p>
     * This functionality is not supported for directory buckets.
     * </p>
     * </note>
     * 
     * @return Version ID of the object.</p>
     *         <p>
     *         If you enable versioning for a bucket, Amazon S3 automatically generates a unique version ID for the
     *         object being stored. Amazon S3 returns this ID in the response. When you enable versioning for a bucket,
     *         if Amazon S3 receives multiple write requests for the same object simultaneously, it stores all of the
     *         objects. For more information about versioning, see <a
     *         href="https://docs.aws.amazon.com/AmazonS3/latest/dev/AddingObjectstoVersioningEnabledBuckets.html"
     *         >Adding Objects to Versioning-Enabled Buckets</a> in the <i>Amazon S3 User Guide</i>. For information
     *         about returning the versioning state of a bucket, see <a
     *         href="https://docs.aws.amazon.com/AmazonS3/latest/API/API_GetBucketVersioning.html"
     *         >GetBucketVersioning</a>.
     *         </p>
     *         <note>
     *         <p>
     *         This functionality is not supported for directory buckets.
     *         </p>
     */
    public final String versionId() {
        return versionId;
    }

    /**
     * <p>
     * If server-side encryption with a customer-provided encryption key was requested, the response will include this
     * header to confirm the encryption algorithm that's used.
     * </p>
     * <note>
     * <p>
     * This functionality is not supported for directory buckets.
     * </p>
     * </note>
     * 
     * @return If server-side encryption with a customer-provided encryption key was requested, the response will
     *         include this header to confirm the encryption algorithm that's used.</p> <note>
     *         <p>
     *         This functionality is not supported for directory buckets.
     *         </p>
     */
    public final String sseCustomerAlgorithm() {
        return sseCustomerAlgorithm;
    }

    /**
     * <p>
     * If server-side encryption with a customer-provided encryption key was requested, the response will include this
     * header to provide the round-trip message integrity verification of the customer-provided encryption key.
     * </p>
     * <note>
     * <p>
     * This functionality is not supported for directory buckets.
     * </p>
     * </note>
     * 
     * @return If server-side encryption with a customer-provided encryption key was requested, the response will
     *         include this header to provide the round-trip message integrity verification of the customer-provided
     *         encryption key.</p> <note>
     *         <p>
     *         This functionality is not supported for directory buckets.
     *         </p>
     */
    public final String sseCustomerKeyMD5() {
        return sseCustomerKeyMD5;
    }

    /**
     * <p>
     * If present, indicates the ID of the KMS key that was used for object encryption.
     * </p>
     * 
     * @return If present, indicates the ID of the KMS key that was used for object encryption.
     */
    public final String ssekmsKeyId() {
        return ssekmsKeyId;
    }

    /**
     * <p>
     * If present, indicates the Amazon Web Services KMS Encryption Context to use for object encryption. The value of
     * this header is a Base64 encoded string of a UTF-8 encoded JSON, which contains the encryption context as
     * key-value pairs. This value is stored as object metadata and automatically gets passed on to Amazon Web Services
     * KMS for future <code>GetObject</code> operations on this object.
     * </p>
     * 
     * @return If present, indicates the Amazon Web Services KMS Encryption Context to use for object encryption. The
     *         value of this header is a Base64 encoded string of a UTF-8 encoded JSON, which contains the encryption
     *         context as key-value pairs. This value is stored as object metadata and automatically gets passed on to
     *         Amazon Web Services KMS for future <code>GetObject</code> operations on this object.
     */
    public final String ssekmsEncryptionContext() {
        return ssekmsEncryptionContext;
    }

    /**
     * <p>
     * Indicates whether the uploaded object uses an S3 Bucket Key for server-side encryption with Key Management
     * Service (KMS) keys (SSE-KMS).
     * </p>
     * 
     * @return Indicates whether the uploaded object uses an S3 Bucket Key for server-side encryption with Key
     *         Management Service (KMS) keys (SSE-KMS).
     */
    public final Boolean bucketKeyEnabled() {
        return bucketKeyEnabled;
    }

    /**
     * <p>
     * The size of the object in bytes. This value is only be present if you append to an object.
     * </p>
     * <note>
     * <p>
     * This functionality is only supported for objects in the Amazon S3 Express One Zone storage class in directory
     * buckets.
     * </p>
     * </note>
     * 
     * @return The size of the object in bytes. This value is only be present if you append to an object. </p> <note>
     *         <p>
     *         This functionality is only supported for objects in the Amazon S3 Express One Zone storage class in
     *         directory buckets.
     *         </p>
     */
    public final Long size() {
        return size;
    }

    /**
     * Returns the value of the RequestCharged property for this object.
     * <p>
     * If the service returns an enum value that is not available in the current SDK version, {@link #requestCharged}
     * will return {@link RequestCharged#UNKNOWN_TO_SDK_VERSION}. The raw value returned by the service is available
     * from {@link #requestChargedAsString}.
     * </p>
     * 
     * @return The value of the RequestCharged property for this object.
     * @see RequestCharged
     */
    public final RequestCharged requestCharged() {
        return RequestCharged.fromValue(requestCharged);
    }

    /**
     * Returns the value of the RequestCharged property for this object.
     * <p>
     * If the service returns an enum value that is not available in the current SDK version, {@link #requestCharged}
     * will return {@link RequestCharged#UNKNOWN_TO_SDK_VERSION}. The raw value returned by the service is available
     * from {@link #requestChargedAsString}.
     * </p>
     * 
     * @return The value of the RequestCharged property for this object.
     * @see RequestCharged
     */
    public final String requestChargedAsString() {
        return requestCharged;
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
        hashCode = 31 * hashCode + Objects.hashCode(expiration());
        hashCode = 31 * hashCode + Objects.hashCode(eTag());
        hashCode = 31 * hashCode + Objects.hashCode(checksumCRC32());
        hashCode = 31 * hashCode + Objects.hashCode(checksumCRC32C());
        hashCode = 31 * hashCode + Objects.hashCode(checksumCRC64NVME());
        hashCode = 31 * hashCode + Objects.hashCode(checksumSHA1());
        hashCode = 31 * hashCode + Objects.hashCode(checksumSHA256());
        hashCode = 31 * hashCode + Objects.hashCode(checksumTypeAsString());
        hashCode = 31 * hashCode + Objects.hashCode(serverSideEncryptionAsString());
        hashCode = 31 * hashCode + Objects.hashCode(versionId());
        hashCode = 31 * hashCode + Objects.hashCode(sseCustomerAlgorithm());
        hashCode = 31 * hashCode + Objects.hashCode(sseCustomerKeyMD5());
        hashCode = 31 * hashCode + Objects.hashCode(ssekmsKeyId());
        hashCode = 31 * hashCode + Objects.hashCode(ssekmsEncryptionContext());
        hashCode = 31 * hashCode + Objects.hashCode(bucketKeyEnabled());
        hashCode = 31 * hashCode + Objects.hashCode(size());
        hashCode = 31 * hashCode + Objects.hashCode(requestChargedAsString());
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
        if (!(obj instanceof PutObjectResponse)) {
            return false;
        }
        PutObjectResponse other = (PutObjectResponse) obj;
        return Objects.equals(expiration(), other.expiration()) && Objects.equals(eTag(), other.eTag())
                && Objects.equals(checksumCRC32(), other.checksumCRC32())
                && Objects.equals(checksumCRC32C(), other.checksumCRC32C())
                && Objects.equals(checksumCRC64NVME(), other.checksumCRC64NVME())
                && Objects.equals(checksumSHA1(), other.checksumSHA1())
                && Objects.equals(checksumSHA256(), other.checksumSHA256())
                && Objects.equals(checksumTypeAsString(), other.checksumTypeAsString())
                && Objects.equals(serverSideEncryptionAsString(), other.serverSideEncryptionAsString())
                && Objects.equals(versionId(), other.versionId())
                && Objects.equals(sseCustomerAlgorithm(), other.sseCustomerAlgorithm())
                && Objects.equals(sseCustomerKeyMD5(), other.sseCustomerKeyMD5())
                && Objects.equals(ssekmsKeyId(), other.ssekmsKeyId())
                && Objects.equals(ssekmsEncryptionContext(), other.ssekmsEncryptionContext())
                && Objects.equals(bucketKeyEnabled(), other.bucketKeyEnabled()) && Objects.equals(size(), other.size())
                && Objects.equals(requestChargedAsString(), other.requestChargedAsString());
    }

    /**
     * Returns a string representation of this object. This is useful for testing and debugging. Sensitive data will be
     * redacted from this string using a placeholder value.
     */
    @Override
    public final String toString() {
        return ToString.builder("PutObjectResponse").add("Expiration", expiration()).add("ETag", eTag())
                .add("ChecksumCRC32", checksumCRC32()).add("ChecksumCRC32C", checksumCRC32C())
                .add("ChecksumCRC64NVME", checksumCRC64NVME()).add("ChecksumSHA1", checksumSHA1())
                .add("ChecksumSHA256", checksumSHA256()).add("ChecksumType", checksumTypeAsString())
                .add("ServerSideEncryption", serverSideEncryptionAsString()).add("VersionId", versionId())
                .add("SSECustomerAlgorithm", sseCustomerAlgorithm()).add("SSECustomerKeyMD5", sseCustomerKeyMD5())
                .add("SSEKMSKeyId", ssekmsKeyId() == null ? null : "*** Sensitive Data Redacted ***")
                .add("SSEKMSEncryptionContext", ssekmsEncryptionContext() == null ? null : "*** Sensitive Data Redacted ***")
                .add("BucketKeyEnabled", bucketKeyEnabled()).add("Size", size()).add("RequestCharged", requestChargedAsString())
                .build();
    }

    public final <T> Optional<T> getValueForField(String fieldName, Class<T> clazz) {
        switch (fieldName) {
        case "Expiration":
            return Optional.ofNullable(clazz.cast(expiration()));
        case "ETag":
            return Optional.ofNullable(clazz.cast(eTag()));
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
        case "ServerSideEncryption":
            return Optional.ofNullable(clazz.cast(serverSideEncryptionAsString()));
        case "VersionId":
            return Optional.ofNullable(clazz.cast(versionId()));
        case "SSECustomerAlgorithm":
            return Optional.ofNullable(clazz.cast(sseCustomerAlgorithm()));
        case "SSECustomerKeyMD5":
            return Optional.ofNullable(clazz.cast(sseCustomerKeyMD5()));
        case "SSEKMSKeyId":
            return Optional.ofNullable(clazz.cast(ssekmsKeyId()));
        case "SSEKMSEncryptionContext":
            return Optional.ofNullable(clazz.cast(ssekmsEncryptionContext()));
        case "BucketKeyEnabled":
            return Optional.ofNullable(clazz.cast(bucketKeyEnabled()));
        case "Size":
            return Optional.ofNullable(clazz.cast(size()));
        case "RequestCharged":
            return Optional.ofNullable(clazz.cast(requestChargedAsString()));
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
        map.put("x-amz-expiration", EXPIRATION_FIELD);
        map.put("ETag", E_TAG_FIELD);
        map.put("x-amz-checksum-crc32", CHECKSUM_CRC32_FIELD);
        map.put("x-amz-checksum-crc32c", CHECKSUM_CRC32_C_FIELD);
        map.put("x-amz-checksum-crc64nvme", CHECKSUM_CRC64_NVME_FIELD);
        map.put("x-amz-checksum-sha1", CHECKSUM_SHA1_FIELD);
        map.put("x-amz-checksum-sha256", CHECKSUM_SHA256_FIELD);
        map.put("x-amz-checksum-type", CHECKSUM_TYPE_FIELD);
        map.put("x-amz-server-side-encryption", SERVER_SIDE_ENCRYPTION_FIELD);
        map.put("x-amz-version-id", VERSION_ID_FIELD);
        map.put("x-amz-server-side-encryption-customer-algorithm", SSE_CUSTOMER_ALGORITHM_FIELD);
        map.put("x-amz-server-side-encryption-customer-key-MD5", SSE_CUSTOMER_KEY_MD5_FIELD);
        map.put("x-amz-server-side-encryption-aws-kms-key-id", SSEKMS_KEY_ID_FIELD);
        map.put("x-amz-server-side-encryption-context", SSEKMS_ENCRYPTION_CONTEXT_FIELD);
        map.put("x-amz-server-side-encryption-bucket-key-enabled", BUCKET_KEY_ENABLED_FIELD);
        map.put("x-amz-object-size", SIZE_FIELD);
        map.put("x-amz-request-charged", REQUEST_CHARGED_FIELD);
        return Collections.unmodifiableMap(map);
    }

    private static <T> Function<Object, T> getter(Function<PutObjectResponse, T> g) {
        return obj -> g.apply((PutObjectResponse) obj);
    }

    private static <T> BiConsumer<Object, T> setter(BiConsumer<Builder, T> s) {
        return (obj, val) -> s.accept((Builder) obj, val);
    }

    @Mutable
    @NotThreadSafe
    public interface Builder extends S3Response.Builder, SdkPojo, CopyableBuilder<Builder, PutObjectResponse> {
        /**
         * <p>
         * If the expiration is configured for the object (see <a
         * href="https://docs.aws.amazon.com/AmazonS3/latest/API/API_PutBucketLifecycleConfiguration.html"
         * >PutBucketLifecycleConfiguration</a>) in the <i>Amazon S3 User Guide</i>, the response includes this header.
         * It includes the <code>expiry-date</code> and <code>rule-id</code> key-value pairs that provide information
         * about object expiration. The value of the <code>rule-id</code> is URL-encoded.
         * </p>
         * <note>
         * <p>
         * Object expiration information is not returned in directory buckets and this header returns the value "
         * <code>NotImplemented</code>" in all responses for directory buckets.
         * </p>
         * </note>
         * 
         * @param expiration
         *        If the expiration is configured for the object (see <a
         *        href="https://docs.aws.amazon.com/AmazonS3/latest/API/API_PutBucketLifecycleConfiguration.html"
         *        >PutBucketLifecycleConfiguration</a>) in the <i>Amazon S3 User Guide</i>, the response includes this
         *        header. It includes the <code>expiry-date</code> and <code>rule-id</code> key-value pairs that provide
         *        information about object expiration. The value of the <code>rule-id</code> is URL-encoded.</p> <note>
         *        <p>
         *        Object expiration information is not returned in directory buckets and this header returns the value "
         *        <code>NotImplemented</code>" in all responses for directory buckets.
         *        </p>
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder expiration(String expiration);

        /**
         * <p>
         * Entity tag for the uploaded object.
         * </p>
         * <p>
         * <b>General purpose buckets </b> - To ensure that data is not corrupted traversing the network, for objects
         * where the ETag is the MD5 digest of the object, you can calculate the MD5 while putting an object to Amazon
         * S3 and compare the returned ETag to the calculated MD5 value.
         * </p>
         * <p>
         * <b>Directory buckets </b> - The ETag for the object in a directory bucket isn't the MD5 digest of the object.
         * </p>
         * 
         * @param eTag
         *        Entity tag for the uploaded object.</p>
         *        <p>
         *        <b>General purpose buckets </b> - To ensure that data is not corrupted traversing the network, for
         *        objects where the ETag is the MD5 digest of the object, you can calculate the MD5 while putting an
         *        object to Amazon S3 and compare the returned ETag to the calculated MD5 value.
         *        </p>
         *        <p>
         *        <b>Directory buckets </b> - The ETag for the object in a directory bucket isn't the MD5 digest of the
         *        object.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder eTag(String eTag);

        /**
         * <p>
         * The Base64 encoded, 32-bit <code>CRC32 checksum</code> of the object. This checksum is only be present if the
         * checksum was uploaded with the object. When you use an API operation on an object that was uploaded using
         * multipart uploads, this value may not be a direct checksum value of the full object. Instead, it's a
         * calculation based on the checksum values of each individual part. For more information about how checksums
         * are calculated with multipart uploads, see <a href=
         * "https://docs.aws.amazon.com/AmazonS3/latest/userguide/checking-object-integrity.html#large-object-checksums"
         * > Checking object integrity</a> in the <i>Amazon S3 User Guide</i>.
         * </p>
         * 
         * @param checksumCRC32
         *        The Base64 encoded, 32-bit <code>CRC32 checksum</code> of the object. This checksum is only be present
         *        if the checksum was uploaded with the object. When you use an API operation on an object that was
         *        uploaded using multipart uploads, this value may not be a direct checksum value of the full object.
         *        Instead, it's a calculation based on the checksum values of each individual part. For more information
         *        about how checksums are calculated with multipart uploads, see <a href=
         *        "https://docs.aws.amazon.com/AmazonS3/latest/userguide/checking-object-integrity.html#large-object-checksums"
         *        > Checking object integrity</a> in the <i>Amazon S3 User Guide</i>.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder checksumCRC32(String checksumCRC32);

        /**
         * <p>
         * The Base64 encoded, 32-bit <code>CRC32C</code> checksum of the object. This checksum is only present if the
         * checksum was uploaded with the object. When you use an API operation on an object that was uploaded using
         * multipart uploads, this value may not be a direct checksum value of the full object. Instead, it's a
         * calculation based on the checksum values of each individual part. For more information about how checksums
         * are calculated with multipart uploads, see <a href=
         * "https://docs.aws.amazon.com/AmazonS3/latest/userguide/checking-object-integrity.html#large-object-checksums"
         * > Checking object integrity</a> in the <i>Amazon S3 User Guide</i>.
         * </p>
         * 
         * @param checksumCRC32C
         *        The Base64 encoded, 32-bit <code>CRC32C</code> checksum of the object. This checksum is only present
         *        if the checksum was uploaded with the object. When you use an API operation on an object that was
         *        uploaded using multipart uploads, this value may not be a direct checksum value of the full object.
         *        Instead, it's a calculation based on the checksum values of each individual part. For more information
         *        about how checksums are calculated with multipart uploads, see <a href=
         *        "https://docs.aws.amazon.com/AmazonS3/latest/userguide/checking-object-integrity.html#large-object-checksums"
         *        > Checking object integrity</a> in the <i>Amazon S3 User Guide</i>.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder checksumCRC32C(String checksumCRC32C);

        /**
         * <p>
         * The Base64 encoded, 64-bit <code>CRC64NVME</code> checksum of the object. This header is present if the
         * object was uploaded with the <code>CRC64NVME</code> checksum algorithm, or if it was uploaded without a
         * checksum (and Amazon S3 added the default checksum, <code>CRC64NVME</code>, to the uploaded object). For more
         * information about how checksums are calculated with multipart uploads, see <a
         * href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/checking-object-integrity.html">Checking object
         * integrity in the Amazon S3 User Guide</a>.
         * </p>
         * 
         * @param checksumCRC64NVME
         *        The Base64 encoded, 64-bit <code>CRC64NVME</code> checksum of the object. This header is present if
         *        the object was uploaded with the <code>CRC64NVME</code> checksum algorithm, or if it was uploaded
         *        without a checksum (and Amazon S3 added the default checksum, <code>CRC64NVME</code>, to the uploaded
         *        object). For more information about how checksums are calculated with multipart uploads, see <a
         *        href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/checking-object-integrity.html">Checking
         *        object integrity in the Amazon S3 User Guide</a>.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder checksumCRC64NVME(String checksumCRC64NVME);

        /**
         * <p>
         * The Base64 encoded, 160-bit <code>SHA1</code> digest of the object. This will only be present if the object
         * was uploaded with the object. When you use the API operation on an object that was uploaded using multipart
         * uploads, this value may not be a direct checksum value of the full object. Instead, it's a calculation based
         * on the checksum values of each individual part. For more information about how checksums are calculated with
         * multipart uploads, see <a href=
         * "https://docs.aws.amazon.com/AmazonS3/latest/userguide/checking-object-integrity.html#large-object-checksums"
         * > Checking object integrity</a> in the <i>Amazon S3 User Guide</i>.
         * </p>
         * 
         * @param checksumSHA1
         *        The Base64 encoded, 160-bit <code>SHA1</code> digest of the object. This will only be present if the
         *        object was uploaded with the object. When you use the API operation on an object that was uploaded
         *        using multipart uploads, this value may not be a direct checksum value of the full object. Instead,
         *        it's a calculation based on the checksum values of each individual part. For more information about
         *        how checksums are calculated with multipart uploads, see <a href=
         *        "https://docs.aws.amazon.com/AmazonS3/latest/userguide/checking-object-integrity.html#large-object-checksums"
         *        > Checking object integrity</a> in the <i>Amazon S3 User Guide</i>.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder checksumSHA1(String checksumSHA1);

        /**
         * <p>
         * The Base64 encoded, 256-bit <code>SHA256</code> digest of the object. This will only be present if the object
         * was uploaded with the object. When you use an API operation on an object that was uploaded using multipart
         * uploads, this value may not be a direct checksum value of the full object. Instead, it's a calculation based
         * on the checksum values of each individual part. For more information about how checksums are calculated with
         * multipart uploads, see <a href=
         * "https://docs.aws.amazon.com/AmazonS3/latest/userguide/checking-object-integrity.html#large-object-checksums"
         * > Checking object integrity</a> in the <i>Amazon S3 User Guide</i>.
         * </p>
         * 
         * @param checksumSHA256
         *        The Base64 encoded, 256-bit <code>SHA256</code> digest of the object. This will only be present if the
         *        object was uploaded with the object. When you use an API operation on an object that was uploaded
         *        using multipart uploads, this value may not be a direct checksum value of the full object. Instead,
         *        it's a calculation based on the checksum values of each individual part. For more information about
         *        how checksums are calculated with multipart uploads, see <a href=
         *        "https://docs.aws.amazon.com/AmazonS3/latest/userguide/checking-object-integrity.html#large-object-checksums"
         *        > Checking object integrity</a> in the <i>Amazon S3 User Guide</i>.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder checksumSHA256(String checksumSHA256);

        /**
         * <p>
         * This header specifies the checksum type of the object, which determines how part-level checksums are combined
         * to create an object-level checksum for multipart objects. For <code>PutObject</code> uploads, the checksum
         * type is always <code>FULL_OBJECT</code>. You can use this header as a data integrity check to verify that the
         * checksum type that is received is the same checksum that was specified. For more information, see <a
         * href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/checking-object-integrity.html">Checking object
         * integrity</a> in the <i>Amazon S3 User Guide</i>.
         * </p>
         * 
         * @param checksumType
         *        This header specifies the checksum type of the object, which determines how part-level checksums are
         *        combined to create an object-level checksum for multipart objects. For <code>PutObject</code> uploads,
         *        the checksum type is always <code>FULL_OBJECT</code>. You can use this header as a data integrity
         *        check to verify that the checksum type that is received is the same checksum that was specified. For
         *        more information, see <a
         *        href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/checking-object-integrity.html">Checking
         *        object integrity</a> in the <i>Amazon S3 User Guide</i>.
         * @see ChecksumType
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see ChecksumType
         */
        Builder checksumType(String checksumType);

        /**
         * <p>
         * This header specifies the checksum type of the object, which determines how part-level checksums are combined
         * to create an object-level checksum for multipart objects. For <code>PutObject</code> uploads, the checksum
         * type is always <code>FULL_OBJECT</code>. You can use this header as a data integrity check to verify that the
         * checksum type that is received is the same checksum that was specified. For more information, see <a
         * href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/checking-object-integrity.html">Checking object
         * integrity</a> in the <i>Amazon S3 User Guide</i>.
         * </p>
         * 
         * @param checksumType
         *        This header specifies the checksum type of the object, which determines how part-level checksums are
         *        combined to create an object-level checksum for multipart objects. For <code>PutObject</code> uploads,
         *        the checksum type is always <code>FULL_OBJECT</code>. You can use this header as a data integrity
         *        check to verify that the checksum type that is received is the same checksum that was specified. For
         *        more information, see <a
         *        href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/checking-object-integrity.html">Checking
         *        object integrity</a> in the <i>Amazon S3 User Guide</i>.
         * @see ChecksumType
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see ChecksumType
         */
        Builder checksumType(ChecksumType checksumType);

        /**
         * <p>
         * The server-side encryption algorithm used when you store this object in Amazon S3.
         * </p>
         * 
         * @param serverSideEncryption
         *        The server-side encryption algorithm used when you store this object in Amazon S3.
         * @see ServerSideEncryption
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see ServerSideEncryption
         */
        Builder serverSideEncryption(String serverSideEncryption);

        /**
         * <p>
         * The server-side encryption algorithm used when you store this object in Amazon S3.
         * </p>
         * 
         * @param serverSideEncryption
         *        The server-side encryption algorithm used when you store this object in Amazon S3.
         * @see ServerSideEncryption
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see ServerSideEncryption
         */
        Builder serverSideEncryption(ServerSideEncryption serverSideEncryption);

        /**
         * <p>
         * Version ID of the object.
         * </p>
         * <p>
         * If you enable versioning for a bucket, Amazon S3 automatically generates a unique version ID for the object
         * being stored. Amazon S3 returns this ID in the response. When you enable versioning for a bucket, if Amazon
         * S3 receives multiple write requests for the same object simultaneously, it stores all of the objects. For
         * more information about versioning, see <a
         * href="https://docs.aws.amazon.com/AmazonS3/latest/dev/AddingObjectstoVersioningEnabledBuckets.html">Adding
         * Objects to Versioning-Enabled Buckets</a> in the <i>Amazon S3 User Guide</i>. For information about returning
         * the versioning state of a bucket, see <a
         * href="https://docs.aws.amazon.com/AmazonS3/latest/API/API_GetBucketVersioning.html">GetBucketVersioning</a>.
         * </p>
         * <note>
         * <p>
         * This functionality is not supported for directory buckets.
         * </p>
         * </note>
         * 
         * @param versionId
         *        Version ID of the object.</p>
         *        <p>
         *        If you enable versioning for a bucket, Amazon S3 automatically generates a unique version ID for the
         *        object being stored. Amazon S3 returns this ID in the response. When you enable versioning for a
         *        bucket, if Amazon S3 receives multiple write requests for the same object simultaneously, it stores
         *        all of the objects. For more information about versioning, see <a
         *        href="https://docs.aws.amazon.com/AmazonS3/latest/dev/AddingObjectstoVersioningEnabledBuckets.html"
         *        >Adding Objects to Versioning-Enabled Buckets</a> in the <i>Amazon S3 User Guide</i>. For information
         *        about returning the versioning state of a bucket, see <a
         *        href="https://docs.aws.amazon.com/AmazonS3/latest/API/API_GetBucketVersioning.html"
         *        >GetBucketVersioning</a>.
         *        </p>
         *        <note>
         *        <p>
         *        This functionality is not supported for directory buckets.
         *        </p>
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder versionId(String versionId);

        /**
         * <p>
         * If server-side encryption with a customer-provided encryption key was requested, the response will include
         * this header to confirm the encryption algorithm that's used.
         * </p>
         * <note>
         * <p>
         * This functionality is not supported for directory buckets.
         * </p>
         * </note>
         * 
         * @param sseCustomerAlgorithm
         *        If server-side encryption with a customer-provided encryption key was requested, the response will
         *        include this header to confirm the encryption algorithm that's used.</p> <note>
         *        <p>
         *        This functionality is not supported for directory buckets.
         *        </p>
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder sseCustomerAlgorithm(String sseCustomerAlgorithm);

        /**
         * <p>
         * If server-side encryption with a customer-provided encryption key was requested, the response will include
         * this header to provide the round-trip message integrity verification of the customer-provided encryption key.
         * </p>
         * <note>
         * <p>
         * This functionality is not supported for directory buckets.
         * </p>
         * </note>
         * 
         * @param sseCustomerKeyMD5
         *        If server-side encryption with a customer-provided encryption key was requested, the response will
         *        include this header to provide the round-trip message integrity verification of the customer-provided
         *        encryption key.</p> <note>
         *        <p>
         *        This functionality is not supported for directory buckets.
         *        </p>
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder sseCustomerKeyMD5(String sseCustomerKeyMD5);

        /**
         * <p>
         * If present, indicates the ID of the KMS key that was used for object encryption.
         * </p>
         * 
         * @param ssekmsKeyId
         *        If present, indicates the ID of the KMS key that was used for object encryption.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder ssekmsKeyId(String ssekmsKeyId);

        /**
         * <p>
         * If present, indicates the Amazon Web Services KMS Encryption Context to use for object encryption. The value
         * of this header is a Base64 encoded string of a UTF-8 encoded JSON, which contains the encryption context as
         * key-value pairs. This value is stored as object metadata and automatically gets passed on to Amazon Web
         * Services KMS for future <code>GetObject</code> operations on this object.
         * </p>
         * 
         * @param ssekmsEncryptionContext
         *        If present, indicates the Amazon Web Services KMS Encryption Context to use for object encryption. The
         *        value of this header is a Base64 encoded string of a UTF-8 encoded JSON, which contains the encryption
         *        context as key-value pairs. This value is stored as object metadata and automatically gets passed on
         *        to Amazon Web Services KMS for future <code>GetObject</code> operations on this object.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder ssekmsEncryptionContext(String ssekmsEncryptionContext);

        /**
         * <p>
         * Indicates whether the uploaded object uses an S3 Bucket Key for server-side encryption with Key Management
         * Service (KMS) keys (SSE-KMS).
         * </p>
         * 
         * @param bucketKeyEnabled
         *        Indicates whether the uploaded object uses an S3 Bucket Key for server-side encryption with Key
         *        Management Service (KMS) keys (SSE-KMS).
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder bucketKeyEnabled(Boolean bucketKeyEnabled);

        /**
         * <p>
         * The size of the object in bytes. This value is only be present if you append to an object.
         * </p>
         * <note>
         * <p>
         * This functionality is only supported for objects in the Amazon S3 Express One Zone storage class in directory
         * buckets.
         * </p>
         * </note>
         * 
         * @param size
         *        The size of the object in bytes. This value is only be present if you append to an object. </p> <note>
         *        <p>
         *        This functionality is only supported for objects in the Amazon S3 Express One Zone storage class in
         *        directory buckets.
         *        </p>
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder size(Long size);

        /**
         * Sets the value of the RequestCharged property for this object.
         *
         * @param requestCharged
         *        The new value for the RequestCharged property for this object.
         * @see RequestCharged
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see RequestCharged
         */
        Builder requestCharged(String requestCharged);

        /**
         * Sets the value of the RequestCharged property for this object.
         *
         * @param requestCharged
         *        The new value for the RequestCharged property for this object.
         * @see RequestCharged
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see RequestCharged
         */
        Builder requestCharged(RequestCharged requestCharged);
    }

    static final class BuilderImpl extends S3Response.BuilderImpl implements Builder {
        private String expiration;

        private String eTag;

        private String checksumCRC32;

        private String checksumCRC32C;

        private String checksumCRC64NVME;

        private String checksumSHA1;

        private String checksumSHA256;

        private String checksumType;

        private String serverSideEncryption;

        private String versionId;

        private String sseCustomerAlgorithm;

        private String sseCustomerKeyMD5;

        private String ssekmsKeyId;

        private String ssekmsEncryptionContext;

        private Boolean bucketKeyEnabled;

        private Long size;

        private String requestCharged;

        private BuilderImpl() {
        }

        private BuilderImpl(PutObjectResponse model) {
            super(model);
            expiration(model.expiration);
            eTag(model.eTag);
            checksumCRC32(model.checksumCRC32);
            checksumCRC32C(model.checksumCRC32C);
            checksumCRC64NVME(model.checksumCRC64NVME);
            checksumSHA1(model.checksumSHA1);
            checksumSHA256(model.checksumSHA256);
            checksumType(model.checksumType);
            serverSideEncryption(model.serverSideEncryption);
            versionId(model.versionId);
            sseCustomerAlgorithm(model.sseCustomerAlgorithm);
            sseCustomerKeyMD5(model.sseCustomerKeyMD5);
            ssekmsKeyId(model.ssekmsKeyId);
            ssekmsEncryptionContext(model.ssekmsEncryptionContext);
            bucketKeyEnabled(model.bucketKeyEnabled);
            size(model.size);
            requestCharged(model.requestCharged);
        }

        public final String getExpiration() {
            return expiration;
        }

        public final void setExpiration(String expiration) {
            this.expiration = expiration;
        }

        @Override
        public final Builder expiration(String expiration) {
            this.expiration = expiration;
            return this;
        }

        public final String getETag() {
            return eTag;
        }

        public final void setETag(String eTag) {
            this.eTag = eTag;
        }

        @Override
        public final Builder eTag(String eTag) {
            this.eTag = eTag;
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

        public final String getVersionId() {
            return versionId;
        }

        public final void setVersionId(String versionId) {
            this.versionId = versionId;
        }

        @Override
        public final Builder versionId(String versionId) {
            this.versionId = versionId;
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

        public final Long getSize() {
            return size;
        }

        public final void setSize(Long size) {
            this.size = size;
        }

        @Override
        public final Builder size(Long size) {
            this.size = size;
            return this;
        }

        public final String getRequestCharged() {
            return requestCharged;
        }

        public final void setRequestCharged(String requestCharged) {
            this.requestCharged = requestCharged;
        }

        @Override
        public final Builder requestCharged(String requestCharged) {
            this.requestCharged = requestCharged;
            return this;
        }

        @Override
        public final Builder requestCharged(RequestCharged requestCharged) {
            this.requestCharged(requestCharged == null ? null : requestCharged.toString());
            return this;
        }

        @Override
        public PutObjectResponse build() {
            return new PutObjectResponse(this);
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
