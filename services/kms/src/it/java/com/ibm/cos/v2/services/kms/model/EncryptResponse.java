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
public final class EncryptResponse extends KmsResponse implements ToCopyableBuilder<EncryptResponse.Builder, EncryptResponse> {
    private static final SdkField<SdkBytes> CIPHERTEXT_BLOB_FIELD = SdkField.<SdkBytes> builder(MarshallingType.SDK_BYTES)
            .memberName("CiphertextBlob").getter(getter(EncryptResponse::ciphertextBlob)).setter(setter(Builder::ciphertextBlob))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("CiphertextBlob").build()).build();

    private static final SdkField<String> KEY_ID_FIELD = SdkField.<String> builder(MarshallingType.STRING).memberName("KeyId")
            .getter(getter(EncryptResponse::keyId)).setter(setter(Builder::keyId))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("KeyId").build()).build();

    private static final SdkField<String> ENCRYPTION_ALGORITHM_FIELD = SdkField.<String> builder(MarshallingType.STRING)
            .memberName("EncryptionAlgorithm").getter(getter(EncryptResponse::encryptionAlgorithmAsString))
            .setter(setter(Builder::encryptionAlgorithm))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("EncryptionAlgorithm").build())
            .build();

    private static final List<SdkField<?>> SDK_FIELDS = Collections.unmodifiableList(Arrays.asList(CIPHERTEXT_BLOB_FIELD,
            KEY_ID_FIELD, ENCRYPTION_ALGORITHM_FIELD));

    private static final Map<String, SdkField<?>> SDK_NAME_TO_FIELD = memberNameToFieldInitializer();

    private final SdkBytes ciphertextBlob;

    private final String keyId;

    private final String encryptionAlgorithm;

    private EncryptResponse(BuilderImpl builder) {
        super(builder);
        this.ciphertextBlob = builder.ciphertextBlob;
        this.keyId = builder.keyId;
        this.encryptionAlgorithm = builder.encryptionAlgorithm;
    }

    /**
     * <p>
     * The encrypted plaintext. When you use the HTTP API or the Amazon Web Services CLI, the value is Base64-encoded.
     * Otherwise, it is not Base64-encoded.
     * </p>
     * 
     * @return The encrypted plaintext. When you use the HTTP API or the Amazon Web Services CLI, the value is
     *         Base64-encoded. Otherwise, it is not Base64-encoded.
     */
    public final SdkBytes ciphertextBlob() {
        return ciphertextBlob;
    }

    /**
     * <p>
     * The Amazon Resource Name (<a
     * href="https://docs.aws.amazon.com/kms/latest/developerguide/concepts.html#key-id-key-ARN">key ARN</a>) of the KMS
     * key that was used to encrypt the plaintext.
     * </p>
     * 
     * @return The Amazon Resource Name (<a
     *         href="https://docs.aws.amazon.com/kms/latest/developerguide/concepts.html#key-id-key-ARN">key ARN</a>) of
     *         the KMS key that was used to encrypt the plaintext.
     */
    public final String keyId() {
        return keyId;
    }

    /**
     * <p>
     * The encryption algorithm that was used to encrypt the plaintext.
     * </p>
     * <p>
     * If the service returns an enum value that is not available in the current SDK version,
     * {@link #encryptionAlgorithm} will return {@link EncryptionAlgorithmSpec#UNKNOWN_TO_SDK_VERSION}. The raw value
     * returned by the service is available from {@link #encryptionAlgorithmAsString}.
     * </p>
     * 
     * @return The encryption algorithm that was used to encrypt the plaintext.
     * @see EncryptionAlgorithmSpec
     */
    public final EncryptionAlgorithmSpec encryptionAlgorithm() {
        return EncryptionAlgorithmSpec.fromValue(encryptionAlgorithm);
    }

    /**
     * <p>
     * The encryption algorithm that was used to encrypt the plaintext.
     * </p>
     * <p>
     * If the service returns an enum value that is not available in the current SDK version,
     * {@link #encryptionAlgorithm} will return {@link EncryptionAlgorithmSpec#UNKNOWN_TO_SDK_VERSION}. The raw value
     * returned by the service is available from {@link #encryptionAlgorithmAsString}.
     * </p>
     * 
     * @return The encryption algorithm that was used to encrypt the plaintext.
     * @see EncryptionAlgorithmSpec
     */
    public final String encryptionAlgorithmAsString() {
        return encryptionAlgorithm;
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
        hashCode = 31 * hashCode + Objects.hashCode(keyId());
        hashCode = 31 * hashCode + Objects.hashCode(encryptionAlgorithmAsString());
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
        if (!(obj instanceof EncryptResponse)) {
            return false;
        }
        EncryptResponse other = (EncryptResponse) obj;
        return Objects.equals(ciphertextBlob(), other.ciphertextBlob()) && Objects.equals(keyId(), other.keyId())
                && Objects.equals(encryptionAlgorithmAsString(), other.encryptionAlgorithmAsString());
    }

    /**
     * Returns a string representation of this object. This is useful for testing and debugging. Sensitive data will be
     * redacted from this string using a placeholder value.
     */
    @Override
    public final String toString() {
        return ToString.builder("EncryptResponse").add("CiphertextBlob", ciphertextBlob()).add("KeyId", keyId())
                .add("EncryptionAlgorithm", encryptionAlgorithmAsString()).build();
    }

    public final <T> Optional<T> getValueForField(String fieldName, Class<T> clazz) {
        switch (fieldName) {
        case "CiphertextBlob":
            return Optional.ofNullable(clazz.cast(ciphertextBlob()));
        case "KeyId":
            return Optional.ofNullable(clazz.cast(keyId()));
        case "EncryptionAlgorithm":
            return Optional.ofNullable(clazz.cast(encryptionAlgorithmAsString()));
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
        map.put("KeyId", KEY_ID_FIELD);
        map.put("EncryptionAlgorithm", ENCRYPTION_ALGORITHM_FIELD);
        return Collections.unmodifiableMap(map);
    }

    private static <T> Function<Object, T> getter(Function<EncryptResponse, T> g) {
        return obj -> g.apply((EncryptResponse) obj);
    }

    private static <T> BiConsumer<Object, T> setter(BiConsumer<Builder, T> s) {
        return (obj, val) -> s.accept((Builder) obj, val);
    }

    @Mutable
    @NotThreadSafe
    public interface Builder extends KmsResponse.Builder, SdkPojo, CopyableBuilder<Builder, EncryptResponse> {
        /**
         * <p>
         * The encrypted plaintext. When you use the HTTP API or the Amazon Web Services CLI, the value is
         * Base64-encoded. Otherwise, it is not Base64-encoded.
         * </p>
         * 
         * @param ciphertextBlob
         *        The encrypted plaintext. When you use the HTTP API or the Amazon Web Services CLI, the value is
         *        Base64-encoded. Otherwise, it is not Base64-encoded.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder ciphertextBlob(SdkBytes ciphertextBlob);

        /**
         * <p>
         * The Amazon Resource Name (<a
         * href="https://docs.aws.amazon.com/kms/latest/developerguide/concepts.html#key-id-key-ARN">key ARN</a>) of the
         * KMS key that was used to encrypt the plaintext.
         * </p>
         * 
         * @param keyId
         *        The Amazon Resource Name (<a
         *        href="https://docs.aws.amazon.com/kms/latest/developerguide/concepts.html#key-id-key-ARN">key ARN</a>)
         *        of the KMS key that was used to encrypt the plaintext.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder keyId(String keyId);

        /**
         * <p>
         * The encryption algorithm that was used to encrypt the plaintext.
         * </p>
         * 
         * @param encryptionAlgorithm
         *        The encryption algorithm that was used to encrypt the plaintext.
         * @see EncryptionAlgorithmSpec
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see EncryptionAlgorithmSpec
         */
        Builder encryptionAlgorithm(String encryptionAlgorithm);

        /**
         * <p>
         * The encryption algorithm that was used to encrypt the plaintext.
         * </p>
         * 
         * @param encryptionAlgorithm
         *        The encryption algorithm that was used to encrypt the plaintext.
         * @see EncryptionAlgorithmSpec
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see EncryptionAlgorithmSpec
         */
        Builder encryptionAlgorithm(EncryptionAlgorithmSpec encryptionAlgorithm);
    }

    static final class BuilderImpl extends KmsResponse.BuilderImpl implements Builder {
        private SdkBytes ciphertextBlob;

        private String keyId;

        private String encryptionAlgorithm;

        private BuilderImpl() {
        }

        private BuilderImpl(EncryptResponse model) {
            super(model);
            ciphertextBlob(model.ciphertextBlob);
            keyId(model.keyId);
            encryptionAlgorithm(model.encryptionAlgorithm);
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

        public final String getEncryptionAlgorithm() {
            return encryptionAlgorithm;
        }

        public final void setEncryptionAlgorithm(String encryptionAlgorithm) {
            this.encryptionAlgorithm = encryptionAlgorithm;
        }

        @Override
        public final Builder encryptionAlgorithm(String encryptionAlgorithm) {
            this.encryptionAlgorithm = encryptionAlgorithm;
            return this;
        }

        @Override
        public final Builder encryptionAlgorithm(EncryptionAlgorithmSpec encryptionAlgorithm) {
            this.encryptionAlgorithm(encryptionAlgorithm == null ? null : encryptionAlgorithm.toString());
            return this;
        }

        @Override
        public EncryptResponse build() {
            return new EncryptResponse(this);
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
