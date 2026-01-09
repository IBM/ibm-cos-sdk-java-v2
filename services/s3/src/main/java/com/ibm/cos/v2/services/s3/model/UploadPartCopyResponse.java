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
import java.util.function.Consumer;
import java.util.function.Function;
import com.ibm.cos.v2.annotations.Generated;
import com.ibm.cos.v2.annotations.Mutable;
import com.ibm.cos.v2.annotations.NotThreadSafe;
import com.ibm.cos.v2.core.SdkField;
import com.ibm.cos.v2.core.SdkPojo;
import com.ibm.cos.v2.core.protocol.MarshallLocation;
import com.ibm.cos.v2.core.protocol.MarshallingType;
import com.ibm.cos.v2.core.traits.LocationTrait;
import com.ibm.cos.v2.core.traits.PayloadTrait;
import com.ibm.cos.v2.utils.ToString;
import com.ibm.cos.v2.utils.builder.CopyableBuilder;
import com.ibm.cos.v2.utils.builder.ToCopyableBuilder;

/**
 */
@Generated("com.ibm.cos.v2:codegen")
public final class UploadPartCopyResponse extends S3Response implements
        ToCopyableBuilder<UploadPartCopyResponse.Builder, UploadPartCopyResponse> {
    private static final SdkField<String> COPY_SOURCE_VERSION_ID_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("CopySourceVersionId")
            .getter(getter(UploadPartCopyResponse::copySourceVersionId))
            .setter(setter(Builder::copySourceVersionId))
            .traits(LocationTrait.builder().location(MarshallLocation.HEADER).locationName("x-amz-copy-source-version-id")
                    .unmarshallLocationName("x-amz-copy-source-version-id").build()).build();

    private static final SdkField<CopyPartResult> COPY_PART_RESULT_FIELD = SdkField
            .<CopyPartResult> builder(MarshallingType.SDK_POJO)
            .memberName("CopyPartResult")
            .getter(getter(UploadPartCopyResponse::copyPartResult))
            .setter(setter(Builder::copyPartResult))
            .constructor(CopyPartResult::builder)
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("CopyPartResult")
                    .unmarshallLocationName("CopyPartResult").build(), PayloadTrait.create()).build();

    private static final SdkField<String> SERVER_SIDE_ENCRYPTION_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("ServerSideEncryption")
            .getter(getter(UploadPartCopyResponse::serverSideEncryptionAsString))
            .setter(setter(Builder::serverSideEncryption))
            .traits(LocationTrait.builder().location(MarshallLocation.HEADER).locationName("x-amz-server-side-encryption")
                    .unmarshallLocationName("x-amz-server-side-encryption").build()).build();

    private static final SdkField<String> SSE_CUSTOMER_ALGORITHM_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("SSECustomerAlgorithm")
            .getter(getter(UploadPartCopyResponse::sseCustomerAlgorithm))
            .setter(setter(Builder::sseCustomerAlgorithm))
            .traits(LocationTrait.builder().location(MarshallLocation.HEADER)
                    .locationName("x-amz-server-side-encryption-customer-algorithm")
                    .unmarshallLocationName("x-amz-server-side-encryption-customer-algorithm").build()).build();

    private static final SdkField<String> SSE_CUSTOMER_KEY_MD5_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("SSECustomerKeyMD5")
            .getter(getter(UploadPartCopyResponse::sseCustomerKeyMD5))
            .setter(setter(Builder::sseCustomerKeyMD5))
            .traits(LocationTrait.builder().location(MarshallLocation.HEADER)
                    .locationName("x-amz-server-side-encryption-customer-key-MD5")
                    .unmarshallLocationName("x-amz-server-side-encryption-customer-key-MD5").build()).build();

    private static final SdkField<String> SSEKMS_KEY_ID_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("SSEKMSKeyId")
            .getter(getter(UploadPartCopyResponse::ssekmsKeyId))
            .setter(setter(Builder::ssekmsKeyId))
            .traits(LocationTrait.builder().location(MarshallLocation.HEADER)
                    .locationName("x-amz-server-side-encryption-aws-kms-key-id")
                    .unmarshallLocationName("x-amz-server-side-encryption-aws-kms-key-id").build()).build();

    private static final SdkField<Boolean> BUCKET_KEY_ENABLED_FIELD = SdkField
            .<Boolean> builder(MarshallingType.BOOLEAN)
            .memberName("BucketKeyEnabled")
            .getter(getter(UploadPartCopyResponse::bucketKeyEnabled))
            .setter(setter(Builder::bucketKeyEnabled))
            .traits(LocationTrait.builder().location(MarshallLocation.HEADER)
                    .locationName("x-amz-server-side-encryption-bucket-key-enabled")
                    .unmarshallLocationName("x-amz-server-side-encryption-bucket-key-enabled").build()).build();

    private static final SdkField<String> REQUEST_CHARGED_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("RequestCharged")
            .getter(getter(UploadPartCopyResponse::requestChargedAsString))
            .setter(setter(Builder::requestCharged))
            .traits(LocationTrait.builder().location(MarshallLocation.HEADER).locationName("x-amz-request-charged")
                    .unmarshallLocationName("x-amz-request-charged").build()).build();

    private static final List<SdkField<?>> SDK_FIELDS = Collections.unmodifiableList(Arrays.asList(COPY_SOURCE_VERSION_ID_FIELD,
            COPY_PART_RESULT_FIELD, SERVER_SIDE_ENCRYPTION_FIELD, SSE_CUSTOMER_ALGORITHM_FIELD, SSE_CUSTOMER_KEY_MD5_FIELD,
            SSEKMS_KEY_ID_FIELD, BUCKET_KEY_ENABLED_FIELD, REQUEST_CHARGED_FIELD));

    private static final Map<String, SdkField<?>> SDK_NAME_TO_FIELD = memberNameToFieldInitializer();

    private final String copySourceVersionId;

    private final CopyPartResult copyPartResult;

    private final String serverSideEncryption;

    private final String sseCustomerAlgorithm;

    private final String sseCustomerKeyMD5;

    private final String ssekmsKeyId;

    private final Boolean bucketKeyEnabled;

    private final String requestCharged;

    private UploadPartCopyResponse(BuilderImpl builder) {
        super(builder);
        this.copySourceVersionId = builder.copySourceVersionId;
        this.copyPartResult = builder.copyPartResult;
        this.serverSideEncryption = builder.serverSideEncryption;
        this.sseCustomerAlgorithm = builder.sseCustomerAlgorithm;
        this.sseCustomerKeyMD5 = builder.sseCustomerKeyMD5;
        this.ssekmsKeyId = builder.ssekmsKeyId;
        this.bucketKeyEnabled = builder.bucketKeyEnabled;
        this.requestCharged = builder.requestCharged;
    }

    /**
     * <p>
     * The version of the source object that was copied, if you have enabled versioning on the source bucket.
     * </p>
     * <note>
     * <p>
     * This functionality is not supported when the source object is in a directory bucket.
     * </p>
     * </note>
     * 
     * @return The version of the source object that was copied, if you have enabled versioning on the source
     *         bucket.</p> <note>
     *         <p>
     *         This functionality is not supported when the source object is in a directory bucket.
     *         </p>
     */
    public final String copySourceVersionId() {
        return copySourceVersionId;
    }

    /**
     * <p>
     * Container for all response elements.
     * </p>
     * 
     * @return Container for all response elements.
     */
    public final CopyPartResult copyPartResult() {
        return copyPartResult;
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
        hashCode = 31 * hashCode + Objects.hashCode(copySourceVersionId());
        hashCode = 31 * hashCode + Objects.hashCode(copyPartResult());
        hashCode = 31 * hashCode + Objects.hashCode(serverSideEncryptionAsString());
        hashCode = 31 * hashCode + Objects.hashCode(sseCustomerAlgorithm());
        hashCode = 31 * hashCode + Objects.hashCode(sseCustomerKeyMD5());
        hashCode = 31 * hashCode + Objects.hashCode(ssekmsKeyId());
        hashCode = 31 * hashCode + Objects.hashCode(bucketKeyEnabled());
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
        if (!(obj instanceof UploadPartCopyResponse)) {
            return false;
        }
        UploadPartCopyResponse other = (UploadPartCopyResponse) obj;
        return Objects.equals(copySourceVersionId(), other.copySourceVersionId())
                && Objects.equals(copyPartResult(), other.copyPartResult())
                && Objects.equals(serverSideEncryptionAsString(), other.serverSideEncryptionAsString())
                && Objects.equals(sseCustomerAlgorithm(), other.sseCustomerAlgorithm())
                && Objects.equals(sseCustomerKeyMD5(), other.sseCustomerKeyMD5())
                && Objects.equals(ssekmsKeyId(), other.ssekmsKeyId())
                && Objects.equals(bucketKeyEnabled(), other.bucketKeyEnabled())
                && Objects.equals(requestChargedAsString(), other.requestChargedAsString());
    }

    /**
     * Returns a string representation of this object. This is useful for testing and debugging. Sensitive data will be
     * redacted from this string using a placeholder value.
     */
    @Override
    public final String toString() {
        return ToString.builder("UploadPartCopyResponse").add("CopySourceVersionId", copySourceVersionId())
                .add("CopyPartResult", copyPartResult()).add("ServerSideEncryption", serverSideEncryptionAsString())
                .add("SSECustomerAlgorithm", sseCustomerAlgorithm()).add("SSECustomerKeyMD5", sseCustomerKeyMD5())
                .add("SSEKMSKeyId", ssekmsKeyId() == null ? null : "*** Sensitive Data Redacted ***")
                .add("BucketKeyEnabled", bucketKeyEnabled()).add("RequestCharged", requestChargedAsString()).build();
    }

    public final <T> Optional<T> getValueForField(String fieldName, Class<T> clazz) {
        switch (fieldName) {
        case "CopySourceVersionId":
            return Optional.ofNullable(clazz.cast(copySourceVersionId()));
        case "CopyPartResult":
            return Optional.ofNullable(clazz.cast(copyPartResult()));
        case "ServerSideEncryption":
            return Optional.ofNullable(clazz.cast(serverSideEncryptionAsString()));
        case "SSECustomerAlgorithm":
            return Optional.ofNullable(clazz.cast(sseCustomerAlgorithm()));
        case "SSECustomerKeyMD5":
            return Optional.ofNullable(clazz.cast(sseCustomerKeyMD5()));
        case "SSEKMSKeyId":
            return Optional.ofNullable(clazz.cast(ssekmsKeyId()));
        case "BucketKeyEnabled":
            return Optional.ofNullable(clazz.cast(bucketKeyEnabled()));
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
        map.put("x-amz-copy-source-version-id", COPY_SOURCE_VERSION_ID_FIELD);
        map.put("CopyPartResult", COPY_PART_RESULT_FIELD);
        map.put("x-amz-server-side-encryption", SERVER_SIDE_ENCRYPTION_FIELD);
        map.put("x-amz-server-side-encryption-customer-algorithm", SSE_CUSTOMER_ALGORITHM_FIELD);
        map.put("x-amz-server-side-encryption-customer-key-MD5", SSE_CUSTOMER_KEY_MD5_FIELD);
        map.put("x-amz-server-side-encryption-aws-kms-key-id", SSEKMS_KEY_ID_FIELD);
        map.put("x-amz-server-side-encryption-bucket-key-enabled", BUCKET_KEY_ENABLED_FIELD);
        map.put("x-amz-request-charged", REQUEST_CHARGED_FIELD);
        return Collections.unmodifiableMap(map);
    }

    private static <T> Function<Object, T> getter(Function<UploadPartCopyResponse, T> g) {
        return obj -> g.apply((UploadPartCopyResponse) obj);
    }

    private static <T> BiConsumer<Object, T> setter(BiConsumer<Builder, T> s) {
        return (obj, val) -> s.accept((Builder) obj, val);
    }

    @Mutable
    @NotThreadSafe
    public interface Builder extends S3Response.Builder, SdkPojo, CopyableBuilder<Builder, UploadPartCopyResponse> {
        /**
         * <p>
         * The version of the source object that was copied, if you have enabled versioning on the source bucket.
         * </p>
         * <note>
         * <p>
         * This functionality is not supported when the source object is in a directory bucket.
         * </p>
         * </note>
         * 
         * @param copySourceVersionId
         *        The version of the source object that was copied, if you have enabled versioning on the source
         *        bucket.</p> <note>
         *        <p>
         *        This functionality is not supported when the source object is in a directory bucket.
         *        </p>
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder copySourceVersionId(String copySourceVersionId);

        /**
         * <p>
         * Container for all response elements.
         * </p>
         * 
         * @param copyPartResult
         *        Container for all response elements.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder copyPartResult(CopyPartResult copyPartResult);

        /**
         * <p>
         * Container for all response elements.
         * </p>
         * This is a convenience method that creates an instance of the {@link CopyPartResult.Builder} avoiding the need
         * to create one manually via {@link CopyPartResult#builder()}.
         *
         * <p>
         * When the {@link Consumer} completes, {@link CopyPartResult.Builder#build()} is called immediately and its
         * result is passed to {@link #copyPartResult(CopyPartResult)}.
         * 
         * @param copyPartResult
         *        a consumer that will call methods on {@link CopyPartResult.Builder}
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see #copyPartResult(CopyPartResult)
         */
        default Builder copyPartResult(Consumer<CopyPartResult.Builder> copyPartResult) {
            return copyPartResult(CopyPartResult.builder().applyMutation(copyPartResult).build());
        }

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
    }

    static final class BuilderImpl extends S3Response.BuilderImpl implements Builder {
        private String copySourceVersionId;

        private CopyPartResult copyPartResult;

        private String serverSideEncryption;

        private String sseCustomerAlgorithm;

        private String sseCustomerKeyMD5;

        private String ssekmsKeyId;

        private Boolean bucketKeyEnabled;

        private String requestCharged;

        private BuilderImpl() {
        }

        private BuilderImpl(UploadPartCopyResponse model) {
            super(model);
            copySourceVersionId(model.copySourceVersionId);
            copyPartResult(model.copyPartResult);
            serverSideEncryption(model.serverSideEncryption);
            sseCustomerAlgorithm(model.sseCustomerAlgorithm);
            sseCustomerKeyMD5(model.sseCustomerKeyMD5);
            ssekmsKeyId(model.ssekmsKeyId);
            bucketKeyEnabled(model.bucketKeyEnabled);
            requestCharged(model.requestCharged);
        }

        public final String getCopySourceVersionId() {
            return copySourceVersionId;
        }

        public final void setCopySourceVersionId(String copySourceVersionId) {
            this.copySourceVersionId = copySourceVersionId;
        }

        @Override
        public final Builder copySourceVersionId(String copySourceVersionId) {
            this.copySourceVersionId = copySourceVersionId;
            return this;
        }

        public final CopyPartResult.Builder getCopyPartResult() {
            return copyPartResult != null ? copyPartResult.toBuilder() : null;
        }

        public final void setCopyPartResult(CopyPartResult.BuilderImpl copyPartResult) {
            this.copyPartResult = copyPartResult != null ? copyPartResult.build() : null;
        }

        @Override
        public final Builder copyPartResult(CopyPartResult copyPartResult) {
            this.copyPartResult = copyPartResult;
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

        @Override
        public UploadPartCopyResponse build() {
            return new UploadPartCopyResponse(this);
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
