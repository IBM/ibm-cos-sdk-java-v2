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

package com.ibm.cos.v2.services.kms.model;

import java.nio.ByteBuffer;
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
import com.ibm.cos.v2.core.SdkBytes;
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
public final class ReEncryptResponse extends KmsResponse implements
        ToCopyableBuilder<ReEncryptResponse.Builder, ReEncryptResponse> {
    private static final SdkField<SdkBytes> CIPHERTEXT_BLOB_FIELD = SdkField.<SdkBytes> builder(MarshallingType.SDK_BYTES)
            .memberName("CiphertextBlob").getter(getter(ReEncryptResponse::ciphertextBlob))
            .setter(setter(Builder::ciphertextBlob))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("CiphertextBlob").build()).build();

    private static final SdkField<String> SOURCE_KEY_ID_FIELD = SdkField.<String> builder(MarshallingType.STRING)
            .memberName("SourceKeyId").getter(getter(ReEncryptResponse::sourceKeyId)).setter(setter(Builder::sourceKeyId))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("SourceKeyId").build()).build();

    private static final SdkField<String> KEY_ID_FIELD = SdkField.<String> builder(MarshallingType.STRING).memberName("KeyId")
            .getter(getter(ReEncryptResponse::keyId)).setter(setter(Builder::keyId))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("KeyId").build()).build();

    private static final SdkField<String> SOURCE_ENCRYPTION_ALGORITHM_FIELD = SdkField.<String> builder(MarshallingType.STRING)
            .memberName("SourceEncryptionAlgorithm").getter(getter(ReEncryptResponse::sourceEncryptionAlgorithmAsString))
            .setter(setter(Builder::sourceEncryptionAlgorithm))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("SourceEncryptionAlgorithm").build())
            .build();

    private static final SdkField<String> DESTINATION_ENCRYPTION_ALGORITHM_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("DestinationEncryptionAlgorithm")
            .getter(getter(ReEncryptResponse::destinationEncryptionAlgorithmAsString))
            .setter(setter(Builder::destinationEncryptionAlgorithm))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("DestinationEncryptionAlgorithm")
                    .build()).build();

    private static final List<SdkField<?>> SDK_FIELDS = Collections.unmodifiableList(Arrays.asList(CIPHERTEXT_BLOB_FIELD,
            SOURCE_KEY_ID_FIELD, KEY_ID_FIELD, SOURCE_ENCRYPTION_ALGORITHM_FIELD, DESTINATION_ENCRYPTION_ALGORITHM_FIELD));

    private static final Map<String, SdkField<?>> SDK_NAME_TO_FIELD = memberNameToFieldInitializer();

    private final SdkBytes ciphertextBlob;

    private final String sourceKeyId;

    private final String keyId;

    private final String sourceEncryptionAlgorithm;

    private final String destinationEncryptionAlgorithm;

    private ReEncryptResponse(BuilderImpl builder) {
        super(builder);
        this.ciphertextBlob = builder.ciphertextBlob;
        this.sourceKeyId = builder.sourceKeyId;
        this.keyId = builder.keyId;
        this.sourceEncryptionAlgorithm = builder.sourceEncryptionAlgorithm;
        this.destinationEncryptionAlgorithm = builder.destinationEncryptionAlgorithm;
    }

    /**
     * <p>
     * The reencrypted data. When you use the HTTP API or the Amazon Web Services CLI, the value is Base64-encoded.
     * Otherwise, it is not Base64-encoded.
     * </p>
     * 
     * @return The reencrypted data. When you use the HTTP API or the Amazon Web Services CLI, the value is
     *         Base64-encoded. Otherwise, it is not Base64-encoded.
     */
    public final SdkBytes ciphertextBlob() {
        return ciphertextBlob;
    }

    /**
     * <p>
     * Unique identifier of the KMS key used to originally encrypt the data.
     * </p>
     * 
     * @return Unique identifier of the KMS key used to originally encrypt the data.
     */
    public final String sourceKeyId() {
        return sourceKeyId;
    }

    /**
     * <p>
     * The Amazon Resource Name (<a
     * href="https://docs.aws.amazon.com/kms/latest/developerguide/concepts.html#key-id-key-ARN">key ARN</a>) of the KMS
     * key that was used to reencrypt the data.
     * </p>
     * 
     * @return The Amazon Resource Name (<a
     *         href="https://docs.aws.amazon.com/kms/latest/developerguide/concepts.html#key-id-key-ARN">key ARN</a>) of
     *         the KMS key that was used to reencrypt the data.
     */
    public final String keyId() {
        return keyId;
    }

    /**
     * <p>
     * The encryption algorithm that was used to decrypt the ciphertext before it was reencrypted.
     * </p>
     * <p>
     * If the service returns an enum value that is not available in the current SDK version,
     * {@link #sourceEncryptionAlgorithm} will return {@link EncryptionAlgorithmSpec#UNKNOWN_TO_SDK_VERSION}. The raw
     * value returned by the service is available from {@link #sourceEncryptionAlgorithmAsString}.
     * </p>
     * 
     * @return The encryption algorithm that was used to decrypt the ciphertext before it was reencrypted.
     * @see EncryptionAlgorithmSpec
     */
    public final EncryptionAlgorithmSpec sourceEncryptionAlgorithm() {
        return EncryptionAlgorithmSpec.fromValue(sourceEncryptionAlgorithm);
    }

    /**
     * <p>
     * The encryption algorithm that was used to decrypt the ciphertext before it was reencrypted.
     * </p>
     * <p>
     * If the service returns an enum value that is not available in the current SDK version,
     * {@link #sourceEncryptionAlgorithm} will return {@link EncryptionAlgorithmSpec#UNKNOWN_TO_SDK_VERSION}. The raw
     * value returned by the service is available from {@link #sourceEncryptionAlgorithmAsString}.
     * </p>
     * 
     * @return The encryption algorithm that was used to decrypt the ciphertext before it was reencrypted.
     * @see EncryptionAlgorithmSpec
     */
    public final String sourceEncryptionAlgorithmAsString() {
        return sourceEncryptionAlgorithm;
    }

    /**
     * <p>
     * The encryption algorithm that was used to reencrypt the data.
     * </p>
     * <p>
     * If the service returns an enum value that is not available in the current SDK version,
     * {@link #destinationEncryptionAlgorithm} will return {@link EncryptionAlgorithmSpec#UNKNOWN_TO_SDK_VERSION}. The
     * raw value returned by the service is available from {@link #destinationEncryptionAlgorithmAsString}.
     * </p>
     * 
     * @return The encryption algorithm that was used to reencrypt the data.
     * @see EncryptionAlgorithmSpec
     */
    public final EncryptionAlgorithmSpec destinationEncryptionAlgorithm() {
        return EncryptionAlgorithmSpec.fromValue(destinationEncryptionAlgorithm);
    }

    /**
     * <p>
     * The encryption algorithm that was used to reencrypt the data.
     * </p>
     * <p>
     * If the service returns an enum value that is not available in the current SDK version,
     * {@link #destinationEncryptionAlgorithm} will return {@link EncryptionAlgorithmSpec#UNKNOWN_TO_SDK_VERSION}. The
     * raw value returned by the service is available from {@link #destinationEncryptionAlgorithmAsString}.
     * </p>
     * 
     * @return The encryption algorithm that was used to reencrypt the data.
     * @see EncryptionAlgorithmSpec
     */
    public final String destinationEncryptionAlgorithmAsString() {
        return destinationEncryptionAlgorithm;
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
        hashCode = 31 * hashCode + Objects.hashCode(ciphertextBlob());
        hashCode = 31 * hashCode + Objects.hashCode(sourceKeyId());
        hashCode = 31 * hashCode + Objects.hashCode(keyId());
        hashCode = 31 * hashCode + Objects.hashCode(sourceEncryptionAlgorithmAsString());
        hashCode = 31 * hashCode + Objects.hashCode(destinationEncryptionAlgorithmAsString());
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
        if (!(obj instanceof ReEncryptResponse)) {
            return false;
        }
        ReEncryptResponse other = (ReEncryptResponse) obj;
        return Objects.equals(ciphertextBlob(), other.ciphertextBlob()) && Objects.equals(sourceKeyId(), other.sourceKeyId())
                && Objects.equals(keyId(), other.keyId())
                && Objects.equals(sourceEncryptionAlgorithmAsString(), other.sourceEncryptionAlgorithmAsString())
                && Objects.equals(destinationEncryptionAlgorithmAsString(), other.destinationEncryptionAlgorithmAsString());
    }

    /**
     * Returns a string representation of this object. This is useful for testing and debugging. Sensitive data will be
     * redacted from this string using a placeholder value.
     */
    @Override
    public final String toString() {
        return ToString.builder("ReEncryptResponse").add("CiphertextBlob", ciphertextBlob()).add("SourceKeyId", sourceKeyId())
                .add("KeyId", keyId()).add("SourceEncryptionAlgorithm", sourceEncryptionAlgorithmAsString())
                .add("DestinationEncryptionAlgorithm", destinationEncryptionAlgorithmAsString()).build();
    }

    public final <T> Optional<T> getValueForField(String fieldName, Class<T> clazz) {
        switch (fieldName) {
        case "CiphertextBlob":
            return Optional.ofNullable(clazz.cast(ciphertextBlob()));
        case "SourceKeyId":
            return Optional.ofNullable(clazz.cast(sourceKeyId()));
        case "KeyId":
            return Optional.ofNullable(clazz.cast(keyId()));
        case "SourceEncryptionAlgorithm":
            return Optional.ofNullable(clazz.cast(sourceEncryptionAlgorithmAsString()));
        case "DestinationEncryptionAlgorithm":
            return Optional.ofNullable(clazz.cast(destinationEncryptionAlgorithmAsString()));
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
        map.put("CiphertextBlob", CIPHERTEXT_BLOB_FIELD);
        map.put("SourceKeyId", SOURCE_KEY_ID_FIELD);
        map.put("KeyId", KEY_ID_FIELD);
        map.put("SourceEncryptionAlgorithm", SOURCE_ENCRYPTION_ALGORITHM_FIELD);
        map.put("DestinationEncryptionAlgorithm", DESTINATION_ENCRYPTION_ALGORITHM_FIELD);
        return Collections.unmodifiableMap(map);
    }

    private static <T> Function<Object, T> getter(Function<ReEncryptResponse, T> g) {
        return obj -> g.apply((ReEncryptResponse) obj);
    }

    private static <T> BiConsumer<Object, T> setter(BiConsumer<Builder, T> s) {
        return (obj, val) -> s.accept((Builder) obj, val);
    }

    @Mutable
    @NotThreadSafe
    public interface Builder extends KmsResponse.Builder, SdkPojo, CopyableBuilder<Builder, ReEncryptResponse> {
        /**
         * <p>
         * The reencrypted data. When you use the HTTP API or the Amazon Web Services CLI, the value is Base64-encoded.
         * Otherwise, it is not Base64-encoded.
         * </p>
         * 
         * @param ciphertextBlob
         *        The reencrypted data. When you use the HTTP API or the Amazon Web Services CLI, the value is
         *        Base64-encoded. Otherwise, it is not Base64-encoded.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder ciphertextBlob(SdkBytes ciphertextBlob);

        /**
         * <p>
         * Unique identifier of the KMS key used to originally encrypt the data.
         * </p>
         * 
         * @param sourceKeyId
         *        Unique identifier of the KMS key used to originally encrypt the data.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder sourceKeyId(String sourceKeyId);

        /**
         * <p>
         * The Amazon Resource Name (<a
         * href="https://docs.aws.amazon.com/kms/latest/developerguide/concepts.html#key-id-key-ARN">key ARN</a>) of the
         * KMS key that was used to reencrypt the data.
         * </p>
         * 
         * @param keyId
         *        The Amazon Resource Name (<a
         *        href="https://docs.aws.amazon.com/kms/latest/developerguide/concepts.html#key-id-key-ARN">key ARN</a>)
         *        of the KMS key that was used to reencrypt the data.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder keyId(String keyId);

        /**
         * <p>
         * The encryption algorithm that was used to decrypt the ciphertext before it was reencrypted.
         * </p>
         * 
         * @param sourceEncryptionAlgorithm
         *        The encryption algorithm that was used to decrypt the ciphertext before it was reencrypted.
         * @see EncryptionAlgorithmSpec
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see EncryptionAlgorithmSpec
         */
        Builder sourceEncryptionAlgorithm(String sourceEncryptionAlgorithm);

        /**
         * <p>
         * The encryption algorithm that was used to decrypt the ciphertext before it was reencrypted.
         * </p>
         * 
         * @param sourceEncryptionAlgorithm
         *        The encryption algorithm that was used to decrypt the ciphertext before it was reencrypted.
         * @see EncryptionAlgorithmSpec
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see EncryptionAlgorithmSpec
         */
        Builder sourceEncryptionAlgorithm(EncryptionAlgorithmSpec sourceEncryptionAlgorithm);

        /**
         * <p>
         * The encryption algorithm that was used to reencrypt the data.
         * </p>
         * 
         * @param destinationEncryptionAlgorithm
         *        The encryption algorithm that was used to reencrypt the data.
         * @see EncryptionAlgorithmSpec
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see EncryptionAlgorithmSpec
         */
        Builder destinationEncryptionAlgorithm(String destinationEncryptionAlgorithm);

        /**
         * <p>
         * The encryption algorithm that was used to reencrypt the data.
         * </p>
         * 
         * @param destinationEncryptionAlgorithm
         *        The encryption algorithm that was used to reencrypt the data.
         * @see EncryptionAlgorithmSpec
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see EncryptionAlgorithmSpec
         */
        Builder destinationEncryptionAlgorithm(EncryptionAlgorithmSpec destinationEncryptionAlgorithm);
    }

    static final class BuilderImpl extends KmsResponse.BuilderImpl implements Builder {
        private SdkBytes ciphertextBlob;

        private String sourceKeyId;

        private String keyId;

        private String sourceEncryptionAlgorithm;

        private String destinationEncryptionAlgorithm;

        private BuilderImpl() {
        }

        private BuilderImpl(ReEncryptResponse model) {
            super(model);
            ciphertextBlob(model.ciphertextBlob);
            sourceKeyId(model.sourceKeyId);
            keyId(model.keyId);
            sourceEncryptionAlgorithm(model.sourceEncryptionAlgorithm);
            destinationEncryptionAlgorithm(model.destinationEncryptionAlgorithm);
        }

        public final ByteBuffer getCiphertextBlob() {
            return ciphertextBlob == null ? null : ciphertextBlob.asByteBuffer();
        }

        public final void setCiphertextBlob(ByteBuffer ciphertextBlob) {
            ciphertextBlob(ciphertextBlob == null ? null : SdkBytes.fromByteBuffer(ciphertextBlob));
        }

        @Override
        public final Builder ciphertextBlob(SdkBytes ciphertextBlob) {
            this.ciphertextBlob = ciphertextBlob;
            return this;
        }

        public final String getSourceKeyId() {
            return sourceKeyId;
        }

        public final void setSourceKeyId(String sourceKeyId) {
            this.sourceKeyId = sourceKeyId;
        }

        @Override
        public final Builder sourceKeyId(String sourceKeyId) {
            this.sourceKeyId = sourceKeyId;
            return this;
        }

        public final String getKeyId() {
            return keyId;
        }

        public final void setKeyId(String keyId) {
            this.keyId = keyId;
        }

        @Override
        public final Builder keyId(String keyId) {
            this.keyId = keyId;
            return this;
        }

        public final String getSourceEncryptionAlgorithm() {
            return sourceEncryptionAlgorithm;
        }

        public final void setSourceEncryptionAlgorithm(String sourceEncryptionAlgorithm) {
            this.sourceEncryptionAlgorithm = sourceEncryptionAlgorithm;
        }

        @Override
        public final Builder sourceEncryptionAlgorithm(String sourceEncryptionAlgorithm) {
            this.sourceEncryptionAlgorithm = sourceEncryptionAlgorithm;
            return this;
        }

        @Override
        public final Builder sourceEncryptionAlgorithm(EncryptionAlgorithmSpec sourceEncryptionAlgorithm) {
            this.sourceEncryptionAlgorithm(sourceEncryptionAlgorithm == null ? null : sourceEncryptionAlgorithm.toString());
            return this;
        }

        public final String getDestinationEncryptionAlgorithm() {
            return destinationEncryptionAlgorithm;
        }

        public final void setDestinationEncryptionAlgorithm(String destinationEncryptionAlgorithm) {
            this.destinationEncryptionAlgorithm = destinationEncryptionAlgorithm;
        }

        @Override
        public final Builder destinationEncryptionAlgorithm(String destinationEncryptionAlgorithm) {
            this.destinationEncryptionAlgorithm = destinationEncryptionAlgorithm;
            return this;
        }

        @Override
        public final Builder destinationEncryptionAlgorithm(EncryptionAlgorithmSpec destinationEncryptionAlgorithm) {
            this.destinationEncryptionAlgorithm(destinationEncryptionAlgorithm == null ? null : destinationEncryptionAlgorithm
                    .toString());
            return this;
        }

        @Override
        public ReEncryptResponse build() {
            return new ReEncryptResponse(this);
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
