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
import com.ibm.cos.v2.core.traits.RequiredTrait;
import com.ibm.cos.v2.utils.ToString;
import com.ibm.cos.v2.utils.builder.CopyableBuilder;
import com.ibm.cos.v2.utils.builder.ToCopyableBuilder;

/**
 */
@Generated("com.ibm.cos.v2:codegen")
public final class CreateSessionResponse extends S3Response implements
        ToCopyableBuilder<CreateSessionResponse.Builder, CreateSessionResponse> {
    private static final SdkField<String> SERVER_SIDE_ENCRYPTION_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("ServerSideEncryption")
            .getter(getter(CreateSessionResponse::serverSideEncryptionAsString))
            .setter(setter(Builder::serverSideEncryption))
            .traits(LocationTrait.builder().location(MarshallLocation.HEADER).locationName("x-amz-server-side-encryption")
                    .unmarshallLocationName("x-amz-server-side-encryption").build()).build();

    private static final SdkField<String> SSEKMS_KEY_ID_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("SSEKMSKeyId")
            .getter(getter(CreateSessionResponse::ssekmsKeyId))
            .setter(setter(Builder::ssekmsKeyId))
            .traits(LocationTrait.builder().location(MarshallLocation.HEADER)
                    .locationName("x-amz-server-side-encryption-aws-kms-key-id")
                    .unmarshallLocationName("x-amz-server-side-encryption-aws-kms-key-id").build()).build();

    private static final SdkField<String> SSEKMS_ENCRYPTION_CONTEXT_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("SSEKMSEncryptionContext")
            .getter(getter(CreateSessionResponse::ssekmsEncryptionContext))
            .setter(setter(Builder::ssekmsEncryptionContext))
            .traits(LocationTrait.builder().location(MarshallLocation.HEADER)
                    .locationName("x-amz-server-side-encryption-context")
                    .unmarshallLocationName("x-amz-server-side-encryption-context").build()).build();

    private static final SdkField<Boolean> BUCKET_KEY_ENABLED_FIELD = SdkField
            .<Boolean> builder(MarshallingType.BOOLEAN)
            .memberName("BucketKeyEnabled")
            .getter(getter(CreateSessionResponse::bucketKeyEnabled))
            .setter(setter(Builder::bucketKeyEnabled))
            .traits(LocationTrait.builder().location(MarshallLocation.HEADER)
                    .locationName("x-amz-server-side-encryption-bucket-key-enabled")
                    .unmarshallLocationName("x-amz-server-side-encryption-bucket-key-enabled").build()).build();

    private static final SdkField<SessionCredentials> CREDENTIALS_FIELD = SdkField
            .<SessionCredentials> builder(MarshallingType.SDK_POJO)
            .memberName("Credentials")
            .getter(getter(CreateSessionResponse::credentials))
            .setter(setter(Builder::credentials))
            .constructor(SessionCredentials::builder)
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("Credentials")
                    .unmarshallLocationName("Credentials").build(), RequiredTrait.create()).build();

    private static final List<SdkField<?>> SDK_FIELDS = Collections.unmodifiableList(Arrays.asList(SERVER_SIDE_ENCRYPTION_FIELD,
            SSEKMS_KEY_ID_FIELD, SSEKMS_ENCRYPTION_CONTEXT_FIELD, BUCKET_KEY_ENABLED_FIELD, CREDENTIALS_FIELD));

    private static final Map<String, SdkField<?>> SDK_NAME_TO_FIELD = memberNameToFieldInitializer();

    private final String serverSideEncryption;

    private final String ssekmsKeyId;

    private final String ssekmsEncryptionContext;

    private final Boolean bucketKeyEnabled;

    private final SessionCredentials credentials;

    private CreateSessionResponse(BuilderImpl builder) {
        super(builder);
        this.serverSideEncryption = builder.serverSideEncryption;
        this.ssekmsKeyId = builder.ssekmsKeyId;
        this.ssekmsEncryptionContext = builder.ssekmsEncryptionContext;
        this.bucketKeyEnabled = builder.bucketKeyEnabled;
        this.credentials = builder.credentials;
    }

    /**
     * <p>
     * The server-side encryption algorithm used when you store objects in the directory bucket.
     * </p>
     * <p>
     * If the service returns an enum value that is not available in the current SDK version,
     * {@link #serverSideEncryption} will return {@link ServerSideEncryption#UNKNOWN_TO_SDK_VERSION}. The raw value
     * returned by the service is available from {@link #serverSideEncryptionAsString}.
     * </p>
     * 
     * @return The server-side encryption algorithm used when you store objects in the directory bucket.
     * @see ServerSideEncryption
     */
    public final ServerSideEncryption serverSideEncryption() {
        return ServerSideEncryption.fromValue(serverSideEncryption);
    }

    /**
     * <p>
     * The server-side encryption algorithm used when you store objects in the directory bucket.
     * </p>
     * <p>
     * If the service returns an enum value that is not available in the current SDK version,
     * {@link #serverSideEncryption} will return {@link ServerSideEncryption#UNKNOWN_TO_SDK_VERSION}. The raw value
     * returned by the service is available from {@link #serverSideEncryptionAsString}.
     * </p>
     * 
     * @return The server-side encryption algorithm used when you store objects in the directory bucket.
     * @see ServerSideEncryption
     */
    public final String serverSideEncryptionAsString() {
        return serverSideEncryption;
    }

    /**
     * <p>
     * If you specify <code>x-amz-server-side-encryption</code> with <code>aws:kms</code>, this header indicates the ID
     * of the KMS symmetric encryption customer managed key that was used for object encryption.
     * </p>
     * 
     * @return If you specify <code>x-amz-server-side-encryption</code> with <code>aws:kms</code>, this header indicates
     *         the ID of the KMS symmetric encryption customer managed key that was used for object encryption.
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
     * Indicates whether to use an S3 Bucket Key for server-side encryption with KMS keys (SSE-KMS).
     * </p>
     * 
     * @return Indicates whether to use an S3 Bucket Key for server-side encryption with KMS keys (SSE-KMS).
     */
    public final Boolean bucketKeyEnabled() {
        return bucketKeyEnabled;
    }

    /**
     * <p>
     * The established temporary security credentials for the created session.
     * </p>
     * 
     * @return The established temporary security credentials for the created session.
     */
    public final SessionCredentials credentials() {
        return credentials;
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
        hashCode = 31 * hashCode + Objects.hashCode(serverSideEncryptionAsString());
        hashCode = 31 * hashCode + Objects.hashCode(ssekmsKeyId());
        hashCode = 31 * hashCode + Objects.hashCode(ssekmsEncryptionContext());
        hashCode = 31 * hashCode + Objects.hashCode(bucketKeyEnabled());
        hashCode = 31 * hashCode + Objects.hashCode(credentials());
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
        if (!(obj instanceof CreateSessionResponse)) {
            return false;
        }
        CreateSessionResponse other = (CreateSessionResponse) obj;
        return Objects.equals(serverSideEncryptionAsString(), other.serverSideEncryptionAsString())
                && Objects.equals(ssekmsKeyId(), other.ssekmsKeyId())
                && Objects.equals(ssekmsEncryptionContext(), other.ssekmsEncryptionContext())
                && Objects.equals(bucketKeyEnabled(), other.bucketKeyEnabled())
                && Objects.equals(credentials(), other.credentials());
    }

    /**
     * Returns a string representation of this object. This is useful for testing and debugging. Sensitive data will be
     * redacted from this string using a placeholder value.
     */
    @Override
    public final String toString() {
        return ToString.builder("CreateSessionResponse").add("ServerSideEncryption", serverSideEncryptionAsString())
                .add("SSEKMSKeyId", ssekmsKeyId() == null ? null : "*** Sensitive Data Redacted ***")
                .add("SSEKMSEncryptionContext", ssekmsEncryptionContext() == null ? null : "*** Sensitive Data Redacted ***")
                .add("BucketKeyEnabled", bucketKeyEnabled()).add("Credentials", credentials()).build();
    }

    public final <T> Optional<T> getValueForField(String fieldName, Class<T> clazz) {
        switch (fieldName) {
        case "ServerSideEncryption":
            return Optional.ofNullable(clazz.cast(serverSideEncryptionAsString()));
        case "SSEKMSKeyId":
            return Optional.ofNullable(clazz.cast(ssekmsKeyId()));
        case "SSEKMSEncryptionContext":
            return Optional.ofNullable(clazz.cast(ssekmsEncryptionContext()));
        case "BucketKeyEnabled":
            return Optional.ofNullable(clazz.cast(bucketKeyEnabled()));
        case "Credentials":
            return Optional.ofNullable(clazz.cast(credentials()));
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
        map.put("x-amz-server-side-encryption", SERVER_SIDE_ENCRYPTION_FIELD);
        map.put("x-amz-server-side-encryption-aws-kms-key-id", SSEKMS_KEY_ID_FIELD);
        map.put("x-amz-server-side-encryption-context", SSEKMS_ENCRYPTION_CONTEXT_FIELD);
        map.put("x-amz-server-side-encryption-bucket-key-enabled", BUCKET_KEY_ENABLED_FIELD);
        map.put("Credentials", CREDENTIALS_FIELD);
        return Collections.unmodifiableMap(map);
    }

    private static <T> Function<Object, T> getter(Function<CreateSessionResponse, T> g) {
        return obj -> g.apply((CreateSessionResponse) obj);
    }

    private static <T> BiConsumer<Object, T> setter(BiConsumer<Builder, T> s) {
        return (obj, val) -> s.accept((Builder) obj, val);
    }

    @Mutable
    @NotThreadSafe
    public interface Builder extends S3Response.Builder, SdkPojo, CopyableBuilder<Builder, CreateSessionResponse> {
        /**
         * <p>
         * The server-side encryption algorithm used when you store objects in the directory bucket.
         * </p>
         * 
         * @param serverSideEncryption
         *        The server-side encryption algorithm used when you store objects in the directory bucket.
         * @see ServerSideEncryption
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see ServerSideEncryption
         */
        Builder serverSideEncryption(String serverSideEncryption);

        /**
         * <p>
         * The server-side encryption algorithm used when you store objects in the directory bucket.
         * </p>
         * 
         * @param serverSideEncryption
         *        The server-side encryption algorithm used when you store objects in the directory bucket.
         * @see ServerSideEncryption
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see ServerSideEncryption
         */
        Builder serverSideEncryption(ServerSideEncryption serverSideEncryption);

        /**
         * <p>
         * If you specify <code>x-amz-server-side-encryption</code> with <code>aws:kms</code>, this header indicates the
         * ID of the KMS symmetric encryption customer managed key that was used for object encryption.
         * </p>
         * 
         * @param ssekmsKeyId
         *        If you specify <code>x-amz-server-side-encryption</code> with <code>aws:kms</code>, this header
         *        indicates the ID of the KMS symmetric encryption customer managed key that was used for object
         *        encryption.
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
         * Indicates whether to use an S3 Bucket Key for server-side encryption with KMS keys (SSE-KMS).
         * </p>
         * 
         * @param bucketKeyEnabled
         *        Indicates whether to use an S3 Bucket Key for server-side encryption with KMS keys (SSE-KMS).
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder bucketKeyEnabled(Boolean bucketKeyEnabled);

        /**
         * <p>
         * The established temporary security credentials for the created session.
         * </p>
         * 
         * @param credentials
         *        The established temporary security credentials for the created session.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder credentials(SessionCredentials credentials);

        /**
         * <p>
         * The established temporary security credentials for the created session.
         * </p>
         * This is a convenience method that creates an instance of the {@link SessionCredentials.Builder} avoiding the
         * need to create one manually via {@link SessionCredentials#builder()}.
         *
         * <p>
         * When the {@link Consumer} completes, {@link SessionCredentials.Builder#build()} is called immediately and its
         * result is passed to {@link #credentials(SessionCredentials)}.
         * 
         * @param credentials
         *        a consumer that will call methods on {@link SessionCredentials.Builder}
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see #credentials(SessionCredentials)
         */
        default Builder credentials(Consumer<SessionCredentials.Builder> credentials) {
            return credentials(SessionCredentials.builder().applyMutation(credentials).build());
        }
    }

    static final class BuilderImpl extends S3Response.BuilderImpl implements Builder {
        private String serverSideEncryption;

        private String ssekmsKeyId;

        private String ssekmsEncryptionContext;

        private Boolean bucketKeyEnabled;

        private SessionCredentials credentials;

        private BuilderImpl() {
        }

        private BuilderImpl(CreateSessionResponse model) {
            super(model);
            serverSideEncryption(model.serverSideEncryption);
            ssekmsKeyId(model.ssekmsKeyId);
            ssekmsEncryptionContext(model.ssekmsEncryptionContext);
            bucketKeyEnabled(model.bucketKeyEnabled);
            credentials(model.credentials);
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

        public final SessionCredentials.Builder getCredentials() {
            return credentials != null ? credentials.toBuilder() : null;
        }

        public final void setCredentials(SessionCredentials.BuilderImpl credentials) {
            this.credentials = credentials != null ? credentials.build() : null;
        }

        @Override
        public final Builder credentials(SessionCredentials credentials) {
            this.credentials = credentials;
            return this;
        }

        @Override
        public CreateSessionResponse build() {
            return new CreateSessionResponse(this);
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
