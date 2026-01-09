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
public final class DecryptResponse extends KmsResponse implements ToCopyableBuilder<DecryptResponse.Builder, DecryptResponse> {
    private static final SdkField<String> KEY_ID_FIELD = SdkField.<String> builder(MarshallingType.STRING).memberName("KeyId")
            .getter(getter(DecryptResponse::keyId)).setter(setter(Builder::keyId))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("KeyId").build()).build();

    private static final SdkField<SdkBytes> PLAINTEXT_FIELD = SdkField.<SdkBytes> builder(MarshallingType.SDK_BYTES)
            .memberName("Plaintext").getter(getter(DecryptResponse::plaintext)).setter(setter(Builder::plaintext))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("Plaintext").build()).build();

    private static final SdkField<String> ENCRYPTION_ALGORITHM_FIELD = SdkField.<String> builder(MarshallingType.STRING)
            .memberName("EncryptionAlgorithm").getter(getter(DecryptResponse::encryptionAlgorithmAsString))
            .setter(setter(Builder::encryptionAlgorithm))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("EncryptionAlgorithm").build())
            .build();

    private static final SdkField<SdkBytes> CIPHERTEXT_FOR_RECIPIENT_FIELD = SdkField
            .<SdkBytes> builder(MarshallingType.SDK_BYTES).memberName("CiphertextForRecipient")
            .getter(getter(DecryptResponse::ciphertextForRecipient)).setter(setter(Builder::ciphertextForRecipient))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("CiphertextForRecipient").build())
            .build();

    private static final List<SdkField<?>> SDK_FIELDS = Collections.unmodifiableList(Arrays.asList(KEY_ID_FIELD, PLAINTEXT_FIELD,
            ENCRYPTION_ALGORITHM_FIELD, CIPHERTEXT_FOR_RECIPIENT_FIELD));

    private static final Map<String, SdkField<?>> SDK_NAME_TO_FIELD = memberNameToFieldInitializer();

    private final String keyId;

    private final SdkBytes plaintext;

    private final String encryptionAlgorithm;

    private final SdkBytes ciphertextForRecipient;

    private DecryptResponse(BuilderImpl builder) {
        super(builder);
        this.keyId = builder.keyId;
        this.plaintext = builder.plaintext;
        this.encryptionAlgorithm = builder.encryptionAlgorithm;
        this.ciphertextForRecipient = builder.ciphertextForRecipient;
    }

    /**
     * <p>
     * The Amazon Resource Name (<a
     * href="https://docs.aws.amazon.com/kms/latest/developerguide/concepts.html#key-id-key-ARN">key ARN</a>) of the KMS
     * key that was used to decrypt the ciphertext.
     * </p>
     * 
     * @return The Amazon Resource Name (<a
     *         href="https://docs.aws.amazon.com/kms/latest/developerguide/concepts.html#key-id-key-ARN">key ARN</a>) of
     *         the KMS key that was used to decrypt the ciphertext.
     */
    public final String keyId() {
        return keyId;
    }

    /**
     * <p>
     * Decrypted plaintext data. When you use the HTTP API or the Amazon Web Services CLI, the value is Base64-encoded.
     * Otherwise, it is not Base64-encoded.
     * </p>
     * <p>
     * If the response includes the <code>CiphertextForRecipient</code> field, the <code>Plaintext</code> field is null
     * or empty.
     * </p>
     * 
     * @return Decrypted plaintext data. When you use the HTTP API or the Amazon Web Services CLI, the value is
     *         Base64-encoded. Otherwise, it is not Base64-encoded.</p>
     *         <p>
     *         If the response includes the <code>CiphertextForRecipient</code> field, the <code>Plaintext</code> field
     *         is null or empty.
     */
    public final SdkBytes plaintext() {
        return plaintext;
    }

    /**
     * <p>
     * The encryption algorithm that was used to decrypt the ciphertext.
     * </p>
     * <p>
     * If the service returns an enum value that is not available in the current SDK version,
     * {@link #encryptionAlgorithm} will return {@link EncryptionAlgorithmSpec#UNKNOWN_TO_SDK_VERSION}. The raw value
     * returned by the service is available from {@link #encryptionAlgorithmAsString}.
     * </p>
     * 
     * @return The encryption algorithm that was used to decrypt the ciphertext.
     * @see EncryptionAlgorithmSpec
     */
    public final EncryptionAlgorithmSpec encryptionAlgorithm() {
        return EncryptionAlgorithmSpec.fromValue(encryptionAlgorithm);
    }

    /**
     * <p>
     * The encryption algorithm that was used to decrypt the ciphertext.
     * </p>
     * <p>
     * If the service returns an enum value that is not available in the current SDK version,
     * {@link #encryptionAlgorithm} will return {@link EncryptionAlgorithmSpec#UNKNOWN_TO_SDK_VERSION}. The raw value
     * returned by the service is available from {@link #encryptionAlgorithmAsString}.
     * </p>
     * 
     * @return The encryption algorithm that was used to decrypt the ciphertext.
     * @see EncryptionAlgorithmSpec
     */
    public final String encryptionAlgorithmAsString() {
        return encryptionAlgorithm;
    }

    /**
     * <p>
     * The plaintext data encrypted with the public key in the attestation document.
     * </p>
     * <p>
     * This field is included in the response only when the <code>Recipient</code> parameter in the request includes a
     * valid attestation document from an Amazon Web Services Nitro enclave. For information about the interaction
     * between KMS and Amazon Web Services Nitro Enclaves, see <a
     * href="https://docs.aws.amazon.com/kms/latest/developerguide/services-nitro-enclaves.html">How Amazon Web Services
     * Nitro Enclaves uses KMS</a> in the <i>Key Management Service Developer Guide</i>.
     * </p>
     * 
     * @return The plaintext data encrypted with the public key in the attestation document. </p>
     *         <p>
     *         This field is included in the response only when the <code>Recipient</code> parameter in the request
     *         includes a valid attestation document from an Amazon Web Services Nitro enclave. For information about
     *         the interaction between KMS and Amazon Web Services Nitro Enclaves, see <a
     *         href="https://docs.aws.amazon.com/kms/latest/developerguide/services-nitro-enclaves.html">How Amazon Web
     *         Services Nitro Enclaves uses KMS</a> in the <i>Key Management Service Developer Guide</i>.
     */
    public final SdkBytes ciphertextForRecipient() {
        return ciphertextForRecipient;
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
        hashCode = 31 * hashCode + Objects.hashCode(keyId());
        hashCode = 31 * hashCode + Objects.hashCode(plaintext());
        hashCode = 31 * hashCode + Objects.hashCode(encryptionAlgorithmAsString());
        hashCode = 31 * hashCode + Objects.hashCode(ciphertextForRecipient());
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
        if (!(obj instanceof DecryptResponse)) {
            return false;
        }
        DecryptResponse other = (DecryptResponse) obj;
        return Objects.equals(keyId(), other.keyId()) && Objects.equals(plaintext(), other.plaintext())
                && Objects.equals(encryptionAlgorithmAsString(), other.encryptionAlgorithmAsString())
                && Objects.equals(ciphertextForRecipient(), other.ciphertextForRecipient());
    }

    /**
     * Returns a string representation of this object. This is useful for testing and debugging. Sensitive data will be
     * redacted from this string using a placeholder value.
     */
    @Override
    public final String toString() {
        return ToString.builder("DecryptResponse").add("KeyId", keyId())
                .add("Plaintext", plaintext() == null ? null : "*** Sensitive Data Redacted ***")
                .add("EncryptionAlgorithm", encryptionAlgorithmAsString())
                .add("CiphertextForRecipient", ciphertextForRecipient()).build();
    }

    public final <T> Optional<T> getValueForField(String fieldName, Class<T> clazz) {
        switch (fieldName) {
        case "KeyId":
            return Optional.ofNullable(clazz.cast(keyId()));
        case "Plaintext":
            return Optional.ofNullable(clazz.cast(plaintext()));
        case "EncryptionAlgorithm":
            return Optional.ofNullable(clazz.cast(encryptionAlgorithmAsString()));
        case "CiphertextForRecipient":
            return Optional.ofNullable(clazz.cast(ciphertextForRecipient()));
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
        map.put("KeyId", KEY_ID_FIELD);
        map.put("Plaintext", PLAINTEXT_FIELD);
        map.put("EncryptionAlgorithm", ENCRYPTION_ALGORITHM_FIELD);
        map.put("CiphertextForRecipient", CIPHERTEXT_FOR_RECIPIENT_FIELD);
        return Collections.unmodifiableMap(map);
    }

    private static <T> Function<Object, T> getter(Function<DecryptResponse, T> g) {
        return obj -> g.apply((DecryptResponse) obj);
    }

    private static <T> BiConsumer<Object, T> setter(BiConsumer<Builder, T> s) {
        return (obj, val) -> s.accept((Builder) obj, val);
    }

    @Mutable
    @NotThreadSafe
    public interface Builder extends KmsResponse.Builder, SdkPojo, CopyableBuilder<Builder, DecryptResponse> {
        /**
         * <p>
         * The Amazon Resource Name (<a
         * href="https://docs.aws.amazon.com/kms/latest/developerguide/concepts.html#key-id-key-ARN">key ARN</a>) of the
         * KMS key that was used to decrypt the ciphertext.
         * </p>
         * 
         * @param keyId
         *        The Amazon Resource Name (<a
         *        href="https://docs.aws.amazon.com/kms/latest/developerguide/concepts.html#key-id-key-ARN">key ARN</a>)
         *        of the KMS key that was used to decrypt the ciphertext.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder keyId(String keyId);

        /**
         * <p>
         * Decrypted plaintext data. When you use the HTTP API or the Amazon Web Services CLI, the value is
         * Base64-encoded. Otherwise, it is not Base64-encoded.
         * </p>
         * <p>
         * If the response includes the <code>CiphertextForRecipient</code> field, the <code>Plaintext</code> field is
         * null or empty.
         * </p>
         * 
         * @param plaintext
         *        Decrypted plaintext data. When you use the HTTP API or the Amazon Web Services CLI, the value is
         *        Base64-encoded. Otherwise, it is not Base64-encoded.</p>
         *        <p>
         *        If the response includes the <code>CiphertextForRecipient</code> field, the <code>Plaintext</code>
         *        field is null or empty.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder plaintext(SdkBytes plaintext);

        /**
         * <p>
         * The encryption algorithm that was used to decrypt the ciphertext.
         * </p>
         * 
         * @param encryptionAlgorithm
         *        The encryption algorithm that was used to decrypt the ciphertext.
         * @see EncryptionAlgorithmSpec
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see EncryptionAlgorithmSpec
         */
        Builder encryptionAlgorithm(String encryptionAlgorithm);

        /**
         * <p>
         * The encryption algorithm that was used to decrypt the ciphertext.
         * </p>
         * 
         * @param encryptionAlgorithm
         *        The encryption algorithm that was used to decrypt the ciphertext.
         * @see EncryptionAlgorithmSpec
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see EncryptionAlgorithmSpec
         */
        Builder encryptionAlgorithm(EncryptionAlgorithmSpec encryptionAlgorithm);

        /**
         * <p>
         * The plaintext data encrypted with the public key in the attestation document.
         * </p>
         * <p>
         * This field is included in the response only when the <code>Recipient</code> parameter in the request includes
         * a valid attestation document from an Amazon Web Services Nitro enclave. For information about the interaction
         * between KMS and Amazon Web Services Nitro Enclaves, see <a
         * href="https://docs.aws.amazon.com/kms/latest/developerguide/services-nitro-enclaves.html">How Amazon Web
         * Services Nitro Enclaves uses KMS</a> in the <i>Key Management Service Developer Guide</i>.
         * </p>
         * 
         * @param ciphertextForRecipient
         *        The plaintext data encrypted with the public key in the attestation document. </p>
         *        <p>
         *        This field is included in the response only when the <code>Recipient</code> parameter in the request
         *        includes a valid attestation document from an Amazon Web Services Nitro enclave. For information about
         *        the interaction between KMS and Amazon Web Services Nitro Enclaves, see <a
         *        href="https://docs.aws.amazon.com/kms/latest/developerguide/services-nitro-enclaves.html">How Amazon
         *        Web Services Nitro Enclaves uses KMS</a> in the <i>Key Management Service Developer Guide</i>.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder ciphertextForRecipient(SdkBytes ciphertextForRecipient);
    }

    static final class BuilderImpl extends KmsResponse.BuilderImpl implements Builder {
        private String keyId;

        private SdkBytes plaintext;

        private String encryptionAlgorithm;

        private SdkBytes ciphertextForRecipient;

        private BuilderImpl() {
        }

        private BuilderImpl(DecryptResponse model) {
            super(model);
            keyId(model.keyId);
            plaintext(model.plaintext);
            encryptionAlgorithm(model.encryptionAlgorithm);
            ciphertextForRecipient(model.ciphertextForRecipient);
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

        public final ByteBuffer getPlaintext() {
            return plaintext == null ? null : plaintext.asByteBuffer();
        }

        public final void setPlaintext(ByteBuffer plaintext) {
            plaintext(plaintext == null ? null : SdkBytes.fromByteBuffer(plaintext));
        }

        @Override
        public final Builder plaintext(SdkBytes plaintext) {
            this.plaintext = plaintext;
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

        public final ByteBuffer getCiphertextForRecipient() {
            return ciphertextForRecipient == null ? null : ciphertextForRecipient.asByteBuffer();
        }

        public final void setCiphertextForRecipient(ByteBuffer ciphertextForRecipient) {
            ciphertextForRecipient(ciphertextForRecipient == null ? null : SdkBytes.fromByteBuffer(ciphertextForRecipient));
        }

        @Override
        public final Builder ciphertextForRecipient(SdkBytes ciphertextForRecipient) {
            this.ciphertextForRecipient = ciphertextForRecipient;
            return this;
        }

        @Override
        public DecryptResponse build() {
            return new DecryptResponse(this);
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
