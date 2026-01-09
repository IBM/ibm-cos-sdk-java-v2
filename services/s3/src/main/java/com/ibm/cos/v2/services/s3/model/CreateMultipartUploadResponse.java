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
public final class CreateMultipartUploadResponse extends S3Response implements
        ToCopyableBuilder<CreateMultipartUploadResponse.Builder, CreateMultipartUploadResponse> {
    private static final SdkField<Instant> ABORT_DATE_FIELD = SdkField
            .<Instant> builder(MarshallingType.INSTANT)
            .memberName("AbortDate")
            .getter(getter(CreateMultipartUploadResponse::abortDate))
            .setter(setter(Builder::abortDate))
            .traits(LocationTrait.builder().location(MarshallLocation.HEADER).locationName("x-amz-abort-date")
                    .unmarshallLocationName("x-amz-abort-date").build()).build();

    private static final SdkField<String> ABORT_RULE_ID_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("AbortRuleId")
            .getter(getter(CreateMultipartUploadResponse::abortRuleId))
            .setter(setter(Builder::abortRuleId))
            .traits(LocationTrait.builder().location(MarshallLocation.HEADER).locationName("x-amz-abort-rule-id")
                    .unmarshallLocationName("x-amz-abort-rule-id").build()).build();

    private static final SdkField<String> BUCKET_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("Bucket")
            .getter(getter(CreateMultipartUploadResponse::bucket))
            .setter(setter(Builder::bucket))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("Bucket")
                    .unmarshallLocationName("Bucket").build()).build();

    private static final SdkField<String> KEY_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("Key")
            .getter(getter(CreateMultipartUploadResponse::key))
            .setter(setter(Builder::key))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("Key").unmarshallLocationName("Key")
                    .build()).build();

    private static final SdkField<String> UPLOAD_ID_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("UploadId")
            .getter(getter(CreateMultipartUploadResponse::uploadId))
            .setter(setter(Builder::uploadId))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("UploadId")
                    .unmarshallLocationName("UploadId").build()).build();

    private static final SdkField<String> SERVER_SIDE_ENCRYPTION_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("ServerSideEncryption")
            .getter(getter(CreateMultipartUploadResponse::serverSideEncryptionAsString))
            .setter(setter(Builder::serverSideEncryption))
            .traits(LocationTrait.builder().location(MarshallLocation.HEADER).locationName("x-amz-server-side-encryption")
                    .unmarshallLocationName("x-amz-server-side-encryption").build()).build();

    private static final SdkField<String> SSE_CUSTOMER_ALGORITHM_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("SSECustomerAlgorithm")
            .getter(getter(CreateMultipartUploadResponse::sseCustomerAlgorithm))
            .setter(setter(Builder::sseCustomerAlgorithm))
            .traits(LocationTrait.builder().location(MarshallLocation.HEADER)
                    .locationName("x-amz-server-side-encryption-customer-algorithm")
                    .unmarshallLocationName("x-amz-server-side-encryption-customer-algorithm").build()).build();

    private static final SdkField<String> SSE_CUSTOMER_KEY_MD5_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("SSECustomerKeyMD5")
            .getter(getter(CreateMultipartUploadResponse::sseCustomerKeyMD5))
            .setter(setter(Builder::sseCustomerKeyMD5))
            .traits(LocationTrait.builder().location(MarshallLocation.HEADER)
                    .locationName("x-amz-server-side-encryption-customer-key-MD5")
                    .unmarshallLocationName("x-amz-server-side-encryption-customer-key-MD5").build()).build();

    private static final SdkField<String> SSEKMS_KEY_ID_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("SSEKMSKeyId")
            .getter(getter(CreateMultipartUploadResponse::ssekmsKeyId))
            .setter(setter(Builder::ssekmsKeyId))
            .traits(LocationTrait.builder().location(MarshallLocation.HEADER)
                    .locationName("x-amz-server-side-encryption-aws-kms-key-id")
                    .unmarshallLocationName("x-amz-server-side-encryption-aws-kms-key-id").build()).build();

    private static final SdkField<String> SSEKMS_ENCRYPTION_CONTEXT_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("SSEKMSEncryptionContext")
            .getter(getter(CreateMultipartUploadResponse::ssekmsEncryptionContext))
            .setter(setter(Builder::ssekmsEncryptionContext))
            .traits(LocationTrait.builder().location(MarshallLocation.HEADER)
                    .locationName("x-amz-server-side-encryption-context")
                    .unmarshallLocationName("x-amz-server-side-encryption-context").build()).build();

    private static final SdkField<Boolean> BUCKET_KEY_ENABLED_FIELD = SdkField
            .<Boolean> builder(MarshallingType.BOOLEAN)
            .memberName("BucketKeyEnabled")
            .getter(getter(CreateMultipartUploadResponse::bucketKeyEnabled))
            .setter(setter(Builder::bucketKeyEnabled))
            .traits(LocationTrait.builder().location(MarshallLocation.HEADER)
                    .locationName("x-amz-server-side-encryption-bucket-key-enabled")
                    .unmarshallLocationName("x-amz-server-side-encryption-bucket-key-enabled").build()).build();

    private static final SdkField<String> REQUEST_CHARGED_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("RequestCharged")
            .getter(getter(CreateMultipartUploadResponse::requestChargedAsString))
            .setter(setter(Builder::requestCharged))
            .traits(LocationTrait.builder().location(MarshallLocation.HEADER).locationName("x-amz-request-charged")
                    .unmarshallLocationName("x-amz-request-charged").build()).build();

    private static final SdkField<String> CHECKSUM_ALGORITHM_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("ChecksumAlgorithm")
            .getter(getter(CreateMultipartUploadResponse::checksumAlgorithmAsString))
            .setter(setter(Builder::checksumAlgorithm))
            .traits(LocationTrait.builder().location(MarshallLocation.HEADER).locationName("x-amz-checksum-algorithm")
                    .unmarshallLocationName("x-amz-checksum-algorithm").build()).build();

    private static final SdkField<String> CHECKSUM_TYPE_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("ChecksumType")
            .getter(getter(CreateMultipartUploadResponse::checksumTypeAsString))
            .setter(setter(Builder::checksumType))
            .traits(LocationTrait.builder().location(MarshallLocation.HEADER).locationName("x-amz-checksum-type")
                    .unmarshallLocationName("x-amz-checksum-type").build()).build();

    private static final List<SdkField<?>> SDK_FIELDS = Collections.unmodifiableList(Arrays.asList(ABORT_DATE_FIELD,
            ABORT_RULE_ID_FIELD, BUCKET_FIELD, KEY_FIELD, UPLOAD_ID_FIELD, SERVER_SIDE_ENCRYPTION_FIELD,
            SSE_CUSTOMER_ALGORITHM_FIELD, SSE_CUSTOMER_KEY_MD5_FIELD, SSEKMS_KEY_ID_FIELD, SSEKMS_ENCRYPTION_CONTEXT_FIELD,
            BUCKET_KEY_ENABLED_FIELD, REQUEST_CHARGED_FIELD, CHECKSUM_ALGORITHM_FIELD, CHECKSUM_TYPE_FIELD));

    private static final Map<String, SdkField<?>> SDK_NAME_TO_FIELD = memberNameToFieldInitializer();

    private final Instant abortDate;

    private final String abortRuleId;

    private final String bucket;

    private final String key;

    private final String uploadId;

    private final String serverSideEncryption;

    private final String sseCustomerAlgorithm;

    private final String sseCustomerKeyMD5;

    private final String ssekmsKeyId;

    private final String ssekmsEncryptionContext;

    private final Boolean bucketKeyEnabled;

    private final String requestCharged;

    private final String checksumAlgorithm;

    private final String checksumType;

    private CreateMultipartUploadResponse(BuilderImpl builder) {
        super(builder);
        this.abortDate = builder.abortDate;
        this.abortRuleId = builder.abortRuleId;
        this.bucket = builder.bucket;
        this.key = builder.key;
        this.uploadId = builder.uploadId;
        this.serverSideEncryption = builder.serverSideEncryption;
        this.sseCustomerAlgorithm = builder.sseCustomerAlgorithm;
        this.sseCustomerKeyMD5 = builder.sseCustomerKeyMD5;
        this.ssekmsKeyId = builder.ssekmsKeyId;
        this.ssekmsEncryptionContext = builder.ssekmsEncryptionContext;
        this.bucketKeyEnabled = builder.bucketKeyEnabled;
        this.requestCharged = builder.requestCharged;
        this.checksumAlgorithm = builder.checksumAlgorithm;
        this.checksumType = builder.checksumType;
    }

    /**
     * <p>
     * If the bucket has a lifecycle rule configured with an action to abort incomplete multipart uploads and the prefix
     * in the lifecycle rule matches the object name in the request, the response includes this header. The header
     * indicates when the initiated multipart upload becomes eligible for an abort operation. For more information, see
     * <a href=
     * "https://docs.aws.amazon.com/AmazonS3/latest/dev/mpuoverview.html#mpu-abort-incomplete-mpu-lifecycle-config">
     * Aborting Incomplete Multipart Uploads Using a Bucket Lifecycle Configuration</a> in the <i>Amazon S3 User
     * Guide</i>.
     * </p>
     * <p>
     * The response also includes the <code>x-amz-abort-rule-id</code> header that provides the ID of the lifecycle
     * configuration rule that defines the abort action.
     * </p>
     * <note>
     * <p>
     * This functionality is not supported for directory buckets.
     * </p>
     * </note>
     * 
     * @return If the bucket has a lifecycle rule configured with an action to abort incomplete multipart uploads and
     *         the prefix in the lifecycle rule matches the object name in the request, the response includes this
     *         header. The header indicates when the initiated multipart upload becomes eligible for an abort operation.
     *         For more information, see <a href=
     *         "https://docs.aws.amazon.com/AmazonS3/latest/dev/mpuoverview.html#mpu-abort-incomplete-mpu-lifecycle-config"
     *         > Aborting Incomplete Multipart Uploads Using a Bucket Lifecycle Configuration</a> in the <i>Amazon S3
     *         User Guide</i>.</p>
     *         <p>
     *         The response also includes the <code>x-amz-abort-rule-id</code> header that provides the ID of the
     *         lifecycle configuration rule that defines the abort action.
     *         </p>
     *         <note>
     *         <p>
     *         This functionality is not supported for directory buckets.
     *         </p>
     */
    public final Instant abortDate() {
        return abortDate;
    }

    /**
     * <p>
     * This header is returned along with the <code>x-amz-abort-date</code> header. It identifies the applicable
     * lifecycle configuration rule that defines the action to abort incomplete multipart uploads.
     * </p>
     * <note>
     * <p>
     * This functionality is not supported for directory buckets.
     * </p>
     * </note>
     * 
     * @return This header is returned along with the <code>x-amz-abort-date</code> header. It identifies the applicable
     *         lifecycle configuration rule that defines the action to abort incomplete multipart uploads.</p> <note>
     *         <p>
     *         This functionality is not supported for directory buckets.
     *         </p>
     */
    public final String abortRuleId() {
        return abortRuleId;
    }

    /**
     * <p>
     * The name of the bucket to which the multipart upload was initiated. Does not return the access point ARN or
     * access point alias if used.
     * </p>
     * <note>
     * <p>
     * Access points are not supported by directory buckets.
     * </p>
     * </note>
     * 
     * @return The name of the bucket to which the multipart upload was initiated. Does not return the access point ARN
     *         or access point alias if used.</p> <note>
     *         <p>
     *         Access points are not supported by directory buckets.
     *         </p>
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
     * The server-side encryption algorithm used when you store this object in Amazon S3 (for example,
     * <code>AES256</code>, <code>aws:kms</code>).
     * </p>
     * <p>
     * If the service returns an enum value that is not available in the current SDK version,
     * {@link #serverSideEncryption} will return {@link ServerSideEncryption#UNKNOWN_TO_SDK_VERSION}. The raw value
     * returned by the service is available from {@link #serverSideEncryptionAsString}.
     * </p>
     * 
     * @return The server-side encryption algorithm used when you store this object in Amazon S3 (for example,
     *         <code>AES256</code>, <code>aws:kms</code>).
     * @see ServerSideEncryption
     */
    public final ServerSideEncryption serverSideEncryption() {
        return ServerSideEncryption.fromValue(serverSideEncryption);
    }

    /**
     * <p>
     * The server-side encryption algorithm used when you store this object in Amazon S3 (for example,
     * <code>AES256</code>, <code>aws:kms</code>).
     * </p>
     * <p>
     * If the service returns an enum value that is not available in the current SDK version,
     * {@link #serverSideEncryption} will return {@link ServerSideEncryption#UNKNOWN_TO_SDK_VERSION}. The raw value
     * returned by the service is available from {@link #serverSideEncryptionAsString}.
     * </p>
     * 
     * @return The server-side encryption algorithm used when you store this object in Amazon S3 (for example,
     *         <code>AES256</code>, <code>aws:kms</code>).
     * @see ServerSideEncryption
     */
    public final String serverSideEncryptionAsString() {
        return serverSideEncryption;
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
     * key-value pairs.
     * </p>
     * 
     * @return If present, indicates the Amazon Web Services KMS Encryption Context to use for object encryption. The
     *         value of this header is a Base64 encoded string of a UTF-8 encoded JSON, which contains the encryption
     *         context as key-value pairs.
     */
    public final String ssekmsEncryptionContext() {
        return ssekmsEncryptionContext;
    }

    /**
     * <p>
     * Indicates whether the multipart upload uses an S3 Bucket Key for server-side encryption with Key Management
     * Service (KMS) keys (SSE-KMS).
     * </p>
     * 
     * @return Indicates whether the multipart upload uses an S3 Bucket Key for server-side encryption with Key
     *         Management Service (KMS) keys (SSE-KMS).
     */
    public final Boolean bucketKeyEnabled() {
        return bucketKeyEnabled;
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

    /**
     * <p>
     * The algorithm that was used to create a checksum of the object.
     * </p>
     * <p>
     * If the service returns an enum value that is not available in the current SDK version, {@link #checksumAlgorithm}
     * will return {@link ChecksumAlgorithm#UNKNOWN_TO_SDK_VERSION}. The raw value returned by the service is available
     * from {@link #checksumAlgorithmAsString}.
     * </p>
     * 
     * @return The algorithm that was used to create a checksum of the object.
     * @see ChecksumAlgorithm
     */
    public final ChecksumAlgorithm checksumAlgorithm() {
        return ChecksumAlgorithm.fromValue(checksumAlgorithm);
    }

    /**
     * <p>
     * The algorithm that was used to create a checksum of the object.
     * </p>
     * <p>
     * If the service returns an enum value that is not available in the current SDK version, {@link #checksumAlgorithm}
     * will return {@link ChecksumAlgorithm#UNKNOWN_TO_SDK_VERSION}. The raw value returned by the service is available
     * from {@link #checksumAlgorithmAsString}.
     * </p>
     * 
     * @return The algorithm that was used to create a checksum of the object.
     * @see ChecksumAlgorithm
     */
    public final String checksumAlgorithmAsString() {
        return checksumAlgorithm;
    }

    /**
     * <p>
     * Indicates the checksum type that you want Amazon S3 to use to calculate the object’s checksum value. For more
     * information, see <a
     * href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/checking-object-integrity.html">Checking object
     * integrity in the Amazon S3 User Guide</a>.
     * </p>
     * <p>
     * If the service returns an enum value that is not available in the current SDK version, {@link #checksumType} will
     * return {@link ChecksumType#UNKNOWN_TO_SDK_VERSION}. The raw value returned by the service is available from
     * {@link #checksumTypeAsString}.
     * </p>
     * 
     * @return Indicates the checksum type that you want Amazon S3 to use to calculate the object’s checksum value. For
     *         more information, see <a
     *         href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/checking-object-integrity.html">Checking
     *         object integrity in the Amazon S3 User Guide</a>.
     * @see ChecksumType
     */
    public final ChecksumType checksumType() {
        return ChecksumType.fromValue(checksumType);
    }

    /**
     * <p>
     * Indicates the checksum type that you want Amazon S3 to use to calculate the object’s checksum value. For more
     * information, see <a
     * href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/checking-object-integrity.html">Checking object
     * integrity in the Amazon S3 User Guide</a>.
     * </p>
     * <p>
     * If the service returns an enum value that is not available in the current SDK version, {@link #checksumType} will
     * return {@link ChecksumType#UNKNOWN_TO_SDK_VERSION}. The raw value returned by the service is available from
     * {@link #checksumTypeAsString}.
     * </p>
     * 
     * @return Indicates the checksum type that you want Amazon S3 to use to calculate the object’s checksum value. For
     *         more information, see <a
     *         href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/checking-object-integrity.html">Checking
     *         object integrity in the Amazon S3 User Guide</a>.
     * @see ChecksumType
     */
    public final String checksumTypeAsString() {
        return checksumType;
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
        hashCode = 31 * hashCode + Objects.hashCode(abortDate());
        hashCode = 31 * hashCode + Objects.hashCode(abortRuleId());
        hashCode = 31 * hashCode + Objects.hashCode(bucket());
        hashCode = 31 * hashCode + Objects.hashCode(key());
        hashCode = 31 * hashCode + Objects.hashCode(uploadId());
        hashCode = 31 * hashCode + Objects.hashCode(serverSideEncryptionAsString());
        hashCode = 31 * hashCode + Objects.hashCode(sseCustomerAlgorithm());
        hashCode = 31 * hashCode + Objects.hashCode(sseCustomerKeyMD5());
        hashCode = 31 * hashCode + Objects.hashCode(ssekmsKeyId());
        hashCode = 31 * hashCode + Objects.hashCode(ssekmsEncryptionContext());
        hashCode = 31 * hashCode + Objects.hashCode(bucketKeyEnabled());
        hashCode = 31 * hashCode + Objects.hashCode(requestChargedAsString());
        hashCode = 31 * hashCode + Objects.hashCode(checksumAlgorithmAsString());
        hashCode = 31 * hashCode + Objects.hashCode(checksumTypeAsString());
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
        if (!(obj instanceof CreateMultipartUploadResponse)) {
            return false;
        }
        CreateMultipartUploadResponse other = (CreateMultipartUploadResponse) obj;
        return Objects.equals(abortDate(), other.abortDate()) && Objects.equals(abortRuleId(), other.abortRuleId())
                && Objects.equals(bucket(), other.bucket()) && Objects.equals(key(), other.key())
                && Objects.equals(uploadId(), other.uploadId())
                && Objects.equals(serverSideEncryptionAsString(), other.serverSideEncryptionAsString())
                && Objects.equals(sseCustomerAlgorithm(), other.sseCustomerAlgorithm())
                && Objects.equals(sseCustomerKeyMD5(), other.sseCustomerKeyMD5())
                && Objects.equals(ssekmsKeyId(), other.ssekmsKeyId())
                && Objects.equals(ssekmsEncryptionContext(), other.ssekmsEncryptionContext())
                && Objects.equals(bucketKeyEnabled(), other.bucketKeyEnabled())
                && Objects.equals(requestChargedAsString(), other.requestChargedAsString())
                && Objects.equals(checksumAlgorithmAsString(), other.checksumAlgorithmAsString())
                && Objects.equals(checksumTypeAsString(), other.checksumTypeAsString());
    }

    /**
     * Returns a string representation of this object. This is useful for testing and debugging. Sensitive data will be
     * redacted from this string using a placeholder value.
     */
    @Override
    public final String toString() {
        return ToString.builder("CreateMultipartUploadResponse").add("AbortDate", abortDate()).add("AbortRuleId", abortRuleId())
                .add("Bucket", bucket()).add("Key", key()).add("UploadId", uploadId())
                .add("ServerSideEncryption", serverSideEncryptionAsString()).add("SSECustomerAlgorithm", sseCustomerAlgorithm())
                .add("SSECustomerKeyMD5", sseCustomerKeyMD5())
                .add("SSEKMSKeyId", ssekmsKeyId() == null ? null : "*** Sensitive Data Redacted ***")
                .add("SSEKMSEncryptionContext", ssekmsEncryptionContext() == null ? null : "*** Sensitive Data Redacted ***")
                .add("BucketKeyEnabled", bucketKeyEnabled()).add("RequestCharged", requestChargedAsString())
                .add("ChecksumAlgorithm", checksumAlgorithmAsString()).add("ChecksumType", checksumTypeAsString()).build();
    }

    public final <T> Optional<T> getValueForField(String fieldName, Class<T> clazz) {
        switch (fieldName) {
        case "AbortDate":
            return Optional.ofNullable(clazz.cast(abortDate()));
        case "AbortRuleId":
            return Optional.ofNullable(clazz.cast(abortRuleId()));
        case "Bucket":
            return Optional.ofNullable(clazz.cast(bucket()));
        case "Key":
            return Optional.ofNullable(clazz.cast(key()));
        case "UploadId":
            return Optional.ofNullable(clazz.cast(uploadId()));
        case "ServerSideEncryption":
            return Optional.ofNullable(clazz.cast(serverSideEncryptionAsString()));
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
        case "RequestCharged":
            return Optional.ofNullable(clazz.cast(requestChargedAsString()));
        case "ChecksumAlgorithm":
            return Optional.ofNullable(clazz.cast(checksumAlgorithmAsString()));
        case "ChecksumType":
            return Optional.ofNullable(clazz.cast(checksumTypeAsString()));
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
        map.put("x-amz-abort-date", ABORT_DATE_FIELD);
        map.put("x-amz-abort-rule-id", ABORT_RULE_ID_FIELD);
        map.put("Bucket", BUCKET_FIELD);
        map.put("Key", KEY_FIELD);
        map.put("UploadId", UPLOAD_ID_FIELD);
        map.put("x-amz-server-side-encryption", SERVER_SIDE_ENCRYPTION_FIELD);
        map.put("x-amz-server-side-encryption-customer-algorithm", SSE_CUSTOMER_ALGORITHM_FIELD);
        map.put("x-amz-server-side-encryption-customer-key-MD5", SSE_CUSTOMER_KEY_MD5_FIELD);
        map.put("x-amz-server-side-encryption-aws-kms-key-id", SSEKMS_KEY_ID_FIELD);
        map.put("x-amz-server-side-encryption-context", SSEKMS_ENCRYPTION_CONTEXT_FIELD);
        map.put("x-amz-server-side-encryption-bucket-key-enabled", BUCKET_KEY_ENABLED_FIELD);
        map.put("x-amz-request-charged", REQUEST_CHARGED_FIELD);
        map.put("x-amz-checksum-algorithm", CHECKSUM_ALGORITHM_FIELD);
        map.put("x-amz-checksum-type", CHECKSUM_TYPE_FIELD);
        return Collections.unmodifiableMap(map);
    }

    private static <T> Function<Object, T> getter(Function<CreateMultipartUploadResponse, T> g) {
        return obj -> g.apply((CreateMultipartUploadResponse) obj);
    }

    private static <T> BiConsumer<Object, T> setter(BiConsumer<Builder, T> s) {
        return (obj, val) -> s.accept((Builder) obj, val);
    }

    @Mutable
    @NotThreadSafe
    public interface Builder extends S3Response.Builder, SdkPojo, CopyableBuilder<Builder, CreateMultipartUploadResponse> {
        /**
         * <p>
         * If the bucket has a lifecycle rule configured with an action to abort incomplete multipart uploads and the
         * prefix in the lifecycle rule matches the object name in the request, the response includes this header. The
         * header indicates when the initiated multipart upload becomes eligible for an abort operation. For more
         * information, see <a href=
         * "https://docs.aws.amazon.com/AmazonS3/latest/dev/mpuoverview.html#mpu-abort-incomplete-mpu-lifecycle-config">
         * Aborting Incomplete Multipart Uploads Using a Bucket Lifecycle Configuration</a> in the <i>Amazon S3 User
         * Guide</i>.
         * </p>
         * <p>
         * The response also includes the <code>x-amz-abort-rule-id</code> header that provides the ID of the lifecycle
         * configuration rule that defines the abort action.
         * </p>
         * <note>
         * <p>
         * This functionality is not supported for directory buckets.
         * </p>
         * </note>
         * 
         * @param abortDate
         *        If the bucket has a lifecycle rule configured with an action to abort incomplete multipart uploads and
         *        the prefix in the lifecycle rule matches the object name in the request, the response includes this
         *        header. The header indicates when the initiated multipart upload becomes eligible for an abort
         *        operation. For more information, see <a href=
         *        "https://docs.aws.amazon.com/AmazonS3/latest/dev/mpuoverview.html#mpu-abort-incomplete-mpu-lifecycle-config"
         *        > Aborting Incomplete Multipart Uploads Using a Bucket Lifecycle Configuration</a> in the <i>Amazon S3
         *        User Guide</i>.</p>
         *        <p>
         *        The response also includes the <code>x-amz-abort-rule-id</code> header that provides the ID of the
         *        lifecycle configuration rule that defines the abort action.
         *        </p>
         *        <note>
         *        <p>
         *        This functionality is not supported for directory buckets.
         *        </p>
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder abortDate(Instant abortDate);

        /**
         * <p>
         * This header is returned along with the <code>x-amz-abort-date</code> header. It identifies the applicable
         * lifecycle configuration rule that defines the action to abort incomplete multipart uploads.
         * </p>
         * <note>
         * <p>
         * This functionality is not supported for directory buckets.
         * </p>
         * </note>
         * 
         * @param abortRuleId
         *        This header is returned along with the <code>x-amz-abort-date</code> header. It identifies the
         *        applicable lifecycle configuration rule that defines the action to abort incomplete multipart
         *        uploads.</p> <note>
         *        <p>
         *        This functionality is not supported for directory buckets.
         *        </p>
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder abortRuleId(String abortRuleId);

        /**
         * <p>
         * The name of the bucket to which the multipart upload was initiated. Does not return the access point ARN or
         * access point alias if used.
         * </p>
         * <note>
         * <p>
         * Access points are not supported by directory buckets.
         * </p>
         * </note>
         * 
         * @param bucket
         *        The name of the bucket to which the multipart upload was initiated. Does not return the access point
         *        ARN or access point alias if used.</p> <note>
         *        <p>
         *        Access points are not supported by directory buckets.
         *        </p>
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
         * The server-side encryption algorithm used when you store this object in Amazon S3 (for example,
         * <code>AES256</code>, <code>aws:kms</code>).
         * </p>
         * 
         * @param serverSideEncryption
         *        The server-side encryption algorithm used when you store this object in Amazon S3 (for example,
         *        <code>AES256</code>, <code>aws:kms</code>).
         * @see ServerSideEncryption
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see ServerSideEncryption
         */
        Builder serverSideEncryption(String serverSideEncryption);

        /**
         * <p>
         * The server-side encryption algorithm used when you store this object in Amazon S3 (for example,
         * <code>AES256</code>, <code>aws:kms</code>).
         * </p>
         * 
         * @param serverSideEncryption
         *        The server-side encryption algorithm used when you store this object in Amazon S3 (for example,
         *        <code>AES256</code>, <code>aws:kms</code>).
         * @see ServerSideEncryption
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see ServerSideEncryption
         */
        Builder serverSideEncryption(ServerSideEncryption serverSideEncryption);

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
         * key-value pairs.
         * </p>
         * 
         * @param ssekmsEncryptionContext
         *        If present, indicates the Amazon Web Services KMS Encryption Context to use for object encryption. The
         *        value of this header is a Base64 encoded string of a UTF-8 encoded JSON, which contains the encryption
         *        context as key-value pairs.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder ssekmsEncryptionContext(String ssekmsEncryptionContext);

        /**
         * <p>
         * Indicates whether the multipart upload uses an S3 Bucket Key for server-side encryption with Key Management
         * Service (KMS) keys (SSE-KMS).
         * </p>
         * 
         * @param bucketKeyEnabled
         *        Indicates whether the multipart upload uses an S3 Bucket Key for server-side encryption with Key
         *        Management Service (KMS) keys (SSE-KMS).
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder bucketKeyEnabled(Boolean bucketKeyEnabled);

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

        /**
         * <p>
         * The algorithm that was used to create a checksum of the object.
         * </p>
         * 
         * @param checksumAlgorithm
         *        The algorithm that was used to create a checksum of the object.
         * @see ChecksumAlgorithm
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see ChecksumAlgorithm
         */
        Builder checksumAlgorithm(String checksumAlgorithm);

        /**
         * <p>
         * The algorithm that was used to create a checksum of the object.
         * </p>
         * 
         * @param checksumAlgorithm
         *        The algorithm that was used to create a checksum of the object.
         * @see ChecksumAlgorithm
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see ChecksumAlgorithm
         */
        Builder checksumAlgorithm(ChecksumAlgorithm checksumAlgorithm);

        /**
         * <p>
         * Indicates the checksum type that you want Amazon S3 to use to calculate the object’s checksum value. For more
         * information, see <a
         * href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/checking-object-integrity.html">Checking object
         * integrity in the Amazon S3 User Guide</a>.
         * </p>
         * 
         * @param checksumType
         *        Indicates the checksum type that you want Amazon S3 to use to calculate the object’s checksum value.
         *        For more information, see <a
         *        href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/checking-object-integrity.html">Checking
         *        object integrity in the Amazon S3 User Guide</a>.
         * @see ChecksumType
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see ChecksumType
         */
        Builder checksumType(String checksumType);

        /**
         * <p>
         * Indicates the checksum type that you want Amazon S3 to use to calculate the object’s checksum value. For more
         * information, see <a
         * href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/checking-object-integrity.html">Checking object
         * integrity in the Amazon S3 User Guide</a>.
         * </p>
         * 
         * @param checksumType
         *        Indicates the checksum type that you want Amazon S3 to use to calculate the object’s checksum value.
         *        For more information, see <a
         *        href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/checking-object-integrity.html">Checking
         *        object integrity in the Amazon S3 User Guide</a>.
         * @see ChecksumType
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see ChecksumType
         */
        Builder checksumType(ChecksumType checksumType);
    }

    static final class BuilderImpl extends S3Response.BuilderImpl implements Builder {
        private Instant abortDate;

        private String abortRuleId;

        private String bucket;

        private String key;

        private String uploadId;

        private String serverSideEncryption;

        private String sseCustomerAlgorithm;

        private String sseCustomerKeyMD5;

        private String ssekmsKeyId;

        private String ssekmsEncryptionContext;

        private Boolean bucketKeyEnabled;

        private String requestCharged;

        private String checksumAlgorithm;

        private String checksumType;

        private BuilderImpl() {
        }

        private BuilderImpl(CreateMultipartUploadResponse model) {
            super(model);
            abortDate(model.abortDate);
            abortRuleId(model.abortRuleId);
            bucket(model.bucket);
            key(model.key);
            uploadId(model.uploadId);
            serverSideEncryption(model.serverSideEncryption);
            sseCustomerAlgorithm(model.sseCustomerAlgorithm);
            sseCustomerKeyMD5(model.sseCustomerKeyMD5);
            ssekmsKeyId(model.ssekmsKeyId);
            ssekmsEncryptionContext(model.ssekmsEncryptionContext);
            bucketKeyEnabled(model.bucketKeyEnabled);
            requestCharged(model.requestCharged);
            checksumAlgorithm(model.checksumAlgorithm);
            checksumType(model.checksumType);
        }

        public final Instant getAbortDate() {
            return abortDate;
        }

        public final void setAbortDate(Instant abortDate) {
            this.abortDate = abortDate;
        }

        @Override
        public final Builder abortDate(Instant abortDate) {
            this.abortDate = abortDate;
            return this;
        }

        public final String getAbortRuleId() {
            return abortRuleId;
        }

        public final void setAbortRuleId(String abortRuleId) {
            this.abortRuleId = abortRuleId;
        }

        @Override
        public final Builder abortRuleId(String abortRuleId) {
            this.abortRuleId = abortRuleId;
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

        @Override
        public CreateMultipartUploadResponse build() {
            return new CreateMultipartUploadResponse(this);
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
