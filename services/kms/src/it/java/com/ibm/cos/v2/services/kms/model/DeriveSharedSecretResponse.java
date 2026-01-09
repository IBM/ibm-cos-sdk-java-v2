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
public final class DeriveSharedSecretResponse extends KmsResponse implements
        ToCopyableBuilder<DeriveSharedSecretResponse.Builder, DeriveSharedSecretResponse> {
    private static final SdkField<String> KEY_ID_FIELD = SdkField.<String> builder(MarshallingType.STRING).memberName("KeyId")
            .getter(getter(DeriveSharedSecretResponse::keyId)).setter(setter(Builder::keyId))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("KeyId").build()).build();

    private static final SdkField<SdkBytes> SHARED_SECRET_FIELD = SdkField.<SdkBytes> builder(MarshallingType.SDK_BYTES)
            .memberName("SharedSecret").getter(getter(DeriveSharedSecretResponse::sharedSecret))
            .setter(setter(Builder::sharedSecret))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("SharedSecret").build()).build();

    private static final SdkField<SdkBytes> CIPHERTEXT_FOR_RECIPIENT_FIELD = SdkField
            .<SdkBytes> builder(MarshallingType.SDK_BYTES).memberName("CiphertextForRecipient")
            .getter(getter(DeriveSharedSecretResponse::ciphertextForRecipient)).setter(setter(Builder::ciphertextForRecipient))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("CiphertextForRecipient").build())
            .build();

    private static final SdkField<String> KEY_AGREEMENT_ALGORITHM_FIELD = SdkField.<String> builder(MarshallingType.STRING)
            .memberName("KeyAgreementAlgorithm").getter(getter(DeriveSharedSecretResponse::keyAgreementAlgorithmAsString))
            .setter(setter(Builder::keyAgreementAlgorithm))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("KeyAgreementAlgorithm").build())
            .build();

    private static final SdkField<String> KEY_ORIGIN_FIELD = SdkField.<String> builder(MarshallingType.STRING)
            .memberName("KeyOrigin").getter(getter(DeriveSharedSecretResponse::keyOriginAsString))
            .setter(setter(Builder::keyOrigin))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("KeyOrigin").build()).build();

    private static final List<SdkField<?>> SDK_FIELDS = Collections.unmodifiableList(Arrays.asList(KEY_ID_FIELD,
            SHARED_SECRET_FIELD, CIPHERTEXT_FOR_RECIPIENT_FIELD, KEY_AGREEMENT_ALGORITHM_FIELD, KEY_ORIGIN_FIELD));

    private static final Map<String, SdkField<?>> SDK_NAME_TO_FIELD = memberNameToFieldInitializer();

    private final String keyId;

    private final SdkBytes sharedSecret;

    private final SdkBytes ciphertextForRecipient;

    private final String keyAgreementAlgorithm;

    private final String keyOrigin;

    private DeriveSharedSecretResponse(BuilderImpl builder) {
        super(builder);
        this.keyId = builder.keyId;
        this.sharedSecret = builder.sharedSecret;
        this.ciphertextForRecipient = builder.ciphertextForRecipient;
        this.keyAgreementAlgorithm = builder.keyAgreementAlgorithm;
        this.keyOrigin = builder.keyOrigin;
    }

    /**
     * <p>
     * Identifies the KMS key used to derive the shared secret.
     * </p>
     * 
     * @return Identifies the KMS key used to derive the shared secret.
     */
    public final String keyId() {
        return keyId;
    }

    /**
     * <p>
     * The raw secret derived from the specified key agreement algorithm, private key in the asymmetric KMS key, and
     * your peer's public key.
     * </p>
     * <p>
     * If the response includes the <code>CiphertextForRecipient</code> field, the <code>SharedSecret</code> field is
     * null or empty.
     * </p>
     * 
     * @return The raw secret derived from the specified key agreement algorithm, private key in the asymmetric KMS key,
     *         and your peer's public key.</p>
     *         <p>
     *         If the response includes the <code>CiphertextForRecipient</code> field, the <code>SharedSecret</code>
     *         field is null or empty.
     */
    public final SdkBytes sharedSecret() {
        return sharedSecret;
    }

    /**
     * <p>
     * The plaintext shared secret encrypted with the public key in the attestation document.
     * </p>
     * <p>
     * This field is included in the response only when the <code>Recipient</code> parameter in the request includes a
     * valid attestation document from an Amazon Web Services Nitro enclave. For information about the interaction
     * between KMS and Amazon Web Services Nitro Enclaves, see <a
     * href="https://docs.aws.amazon.com/kms/latest/developerguide/services-nitro-enclaves.html">How Amazon Web Services
     * Nitro Enclaves uses KMS</a> in the <i>Key Management Service Developer Guide</i>.
     * </p>
     * 
     * @return The plaintext shared secret encrypted with the public key in the attestation document.</p>
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

    /**
     * <p>
     * Identifies the key agreement algorithm used to derive the shared secret.
     * </p>
     * <p>
     * If the service returns an enum value that is not available in the current SDK version,
     * {@link #keyAgreementAlgorithm} will return {@link KeyAgreementAlgorithmSpec#UNKNOWN_TO_SDK_VERSION}. The raw
     * value returned by the service is available from {@link #keyAgreementAlgorithmAsString}.
     * </p>
     * 
     * @return Identifies the key agreement algorithm used to derive the shared secret.
     * @see KeyAgreementAlgorithmSpec
     */
    public final KeyAgreementAlgorithmSpec keyAgreementAlgorithm() {
        return KeyAgreementAlgorithmSpec.fromValue(keyAgreementAlgorithm);
    }

    /**
     * <p>
     * Identifies the key agreement algorithm used to derive the shared secret.
     * </p>
     * <p>
     * If the service returns an enum value that is not available in the current SDK version,
     * {@link #keyAgreementAlgorithm} will return {@link KeyAgreementAlgorithmSpec#UNKNOWN_TO_SDK_VERSION}. The raw
     * value returned by the service is available from {@link #keyAgreementAlgorithmAsString}.
     * </p>
     * 
     * @return Identifies the key agreement algorithm used to derive the shared secret.
     * @see KeyAgreementAlgorithmSpec
     */
    public final String keyAgreementAlgorithmAsString() {
        return keyAgreementAlgorithm;
    }

    /**
     * <p>
     * The source of the key material for the specified KMS key.
     * </p>
     * <p>
     * When this value is <code>AWS_KMS</code>, KMS created the key material. When this value is <code>EXTERNAL</code>,
     * the key material was imported or the KMS key doesn't have any key material.
     * </p>
     * <p>
     * The only valid values for DeriveSharedSecret are <code>AWS_KMS</code> and <code>EXTERNAL</code>.
     * DeriveSharedSecret does not support KMS keys with a <code>KeyOrigin</code> value of <code>AWS_CLOUDHSM</code> or
     * <code>EXTERNAL_KEY_STORE</code>.
     * </p>
     * <p>
     * If the service returns an enum value that is not available in the current SDK version, {@link #keyOrigin} will
     * return {@link OriginType#UNKNOWN_TO_SDK_VERSION}. The raw value returned by the service is available from
     * {@link #keyOriginAsString}.
     * </p>
     * 
     * @return The source of the key material for the specified KMS key.</p>
     *         <p>
     *         When this value is <code>AWS_KMS</code>, KMS created the key material. When this value is
     *         <code>EXTERNAL</code>, the key material was imported or the KMS key doesn't have any key material.
     *         </p>
     *         <p>
     *         The only valid values for DeriveSharedSecret are <code>AWS_KMS</code> and <code>EXTERNAL</code>.
     *         DeriveSharedSecret does not support KMS keys with a <code>KeyOrigin</code> value of
     *         <code>AWS_CLOUDHSM</code> or <code>EXTERNAL_KEY_STORE</code>.
     * @see OriginType
     */
    public final OriginType keyOrigin() {
        return OriginType.fromValue(keyOrigin);
    }

    /**
     * <p>
     * The source of the key material for the specified KMS key.
     * </p>
     * <p>
     * When this value is <code>AWS_KMS</code>, KMS created the key material. When this value is <code>EXTERNAL</code>,
     * the key material was imported or the KMS key doesn't have any key material.
     * </p>
     * <p>
     * The only valid values for DeriveSharedSecret are <code>AWS_KMS</code> and <code>EXTERNAL</code>.
     * DeriveSharedSecret does not support KMS keys with a <code>KeyOrigin</code> value of <code>AWS_CLOUDHSM</code> or
     * <code>EXTERNAL_KEY_STORE</code>.
     * </p>
     * <p>
     * If the service returns an enum value that is not available in the current SDK version, {@link #keyOrigin} will
     * return {@link OriginType#UNKNOWN_TO_SDK_VERSION}. The raw value returned by the service is available from
     * {@link #keyOriginAsString}.
     * </p>
     * 
     * @return The source of the key material for the specified KMS key.</p>
     *         <p>
     *         When this value is <code>AWS_KMS</code>, KMS created the key material. When this value is
     *         <code>EXTERNAL</code>, the key material was imported or the KMS key doesn't have any key material.
     *         </p>
     *         <p>
     *         The only valid values for DeriveSharedSecret are <code>AWS_KMS</code> and <code>EXTERNAL</code>.
     *         DeriveSharedSecret does not support KMS keys with a <code>KeyOrigin</code> value of
     *         <code>AWS_CLOUDHSM</code> or <code>EXTERNAL_KEY_STORE</code>.
     * @see OriginType
     */
    public final String keyOriginAsString() {
        return keyOrigin;
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
        hashCode = 31 * hashCode + Objects.hashCode(sharedSecret());
        hashCode = 31 * hashCode + Objects.hashCode(ciphertextForRecipient());
        hashCode = 31 * hashCode + Objects.hashCode(keyAgreementAlgorithmAsString());
        hashCode = 31 * hashCode + Objects.hashCode(keyOriginAsString());
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
        if (!(obj instanceof DeriveSharedSecretResponse)) {
            return false;
        }
        DeriveSharedSecretResponse other = (DeriveSharedSecretResponse) obj;
        return Objects.equals(keyId(), other.keyId()) && Objects.equals(sharedSecret(), other.sharedSecret())
                && Objects.equals(ciphertextForRecipient(), other.ciphertextForRecipient())
                && Objects.equals(keyAgreementAlgorithmAsString(), other.keyAgreementAlgorithmAsString())
                && Objects.equals(keyOriginAsString(), other.keyOriginAsString());
    }

    /**
     * Returns a string representation of this object. This is useful for testing and debugging. Sensitive data will be
     * redacted from this string using a placeholder value.
     */
    @Override
    public final String toString() {
        return ToString.builder("DeriveSharedSecretResponse").add("KeyId", keyId())
                .add("SharedSecret", sharedSecret() == null ? null : "*** Sensitive Data Redacted ***")
                .add("CiphertextForRecipient", ciphertextForRecipient())
                .add("KeyAgreementAlgorithm", keyAgreementAlgorithmAsString()).add("KeyOrigin", keyOriginAsString()).build();
    }

    public final <T> Optional<T> getValueForField(String fieldName, Class<T> clazz) {
        switch (fieldName) {
        case "KeyId":
            return Optional.ofNullable(clazz.cast(keyId()));
        case "SharedSecret":
            return Optional.ofNullable(clazz.cast(sharedSecret()));
        case "CiphertextForRecipient":
            return Optional.ofNullable(clazz.cast(ciphertextForRecipient()));
        case "KeyAgreementAlgorithm":
            return Optional.ofNullable(clazz.cast(keyAgreementAlgorithmAsString()));
        case "KeyOrigin":
            return Optional.ofNullable(clazz.cast(keyOriginAsString()));
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
        map.put("SharedSecret", SHARED_SECRET_FIELD);
        map.put("CiphertextForRecipient", CIPHERTEXT_FOR_RECIPIENT_FIELD);
        map.put("KeyAgreementAlgorithm", KEY_AGREEMENT_ALGORITHM_FIELD);
        map.put("KeyOrigin", KEY_ORIGIN_FIELD);
        return Collections.unmodifiableMap(map);
    }

    private static <T> Function<Object, T> getter(Function<DeriveSharedSecretResponse, T> g) {
        return obj -> g.apply((DeriveSharedSecretResponse) obj);
    }

    private static <T> BiConsumer<Object, T> setter(BiConsumer<Builder, T> s) {
        return (obj, val) -> s.accept((Builder) obj, val);
    }

    @Mutable
    @NotThreadSafe
    public interface Builder extends KmsResponse.Builder, SdkPojo, CopyableBuilder<Builder, DeriveSharedSecretResponse> {
        /**
         * <p>
         * Identifies the KMS key used to derive the shared secret.
         * </p>
         * 
         * @param keyId
         *        Identifies the KMS key used to derive the shared secret.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder keyId(String keyId);

        /**
         * <p>
         * The raw secret derived from the specified key agreement algorithm, private key in the asymmetric KMS key, and
         * your peer's public key.
         * </p>
         * <p>
         * If the response includes the <code>CiphertextForRecipient</code> field, the <code>SharedSecret</code> field
         * is null or empty.
         * </p>
         * 
         * @param sharedSecret
         *        The raw secret derived from the specified key agreement algorithm, private key in the asymmetric KMS
         *        key, and your peer's public key.</p>
         *        <p>
         *        If the response includes the <code>CiphertextForRecipient</code> field, the <code>SharedSecret</code>
         *        field is null or empty.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder sharedSecret(SdkBytes sharedSecret);

        /**
         * <p>
         * The plaintext shared secret encrypted with the public key in the attestation document.
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
         *        The plaintext shared secret encrypted with the public key in the attestation document.</p>
         *        <p>
         *        This field is included in the response only when the <code>Recipient</code> parameter in the request
         *        includes a valid attestation document from an Amazon Web Services Nitro enclave. For information about
         *        the interaction between KMS and Amazon Web Services Nitro Enclaves, see <a
         *        href="https://docs.aws.amazon.com/kms/latest/developerguide/services-nitro-enclaves.html">How Amazon
         *        Web Services Nitro Enclaves uses KMS</a> in the <i>Key Management Service Developer Guide</i>.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder ciphertextForRecipient(SdkBytes ciphertextForRecipient);

        /**
         * <p>
         * Identifies the key agreement algorithm used to derive the shared secret.
         * </p>
         * 
         * @param keyAgreementAlgorithm
         *        Identifies the key agreement algorithm used to derive the shared secret.
         * @see KeyAgreementAlgorithmSpec
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see KeyAgreementAlgorithmSpec
         */
        Builder keyAgreementAlgorithm(String keyAgreementAlgorithm);

        /**
         * <p>
         * Identifies the key agreement algorithm used to derive the shared secret.
         * </p>
         * 
         * @param keyAgreementAlgorithm
         *        Identifies the key agreement algorithm used to derive the shared secret.
         * @see KeyAgreementAlgorithmSpec
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see KeyAgreementAlgorithmSpec
         */
        Builder keyAgreementAlgorithm(KeyAgreementAlgorithmSpec keyAgreementAlgorithm);

        /**
         * <p>
         * The source of the key material for the specified KMS key.
         * </p>
         * <p>
         * When this value is <code>AWS_KMS</code>, KMS created the key material. When this value is
         * <code>EXTERNAL</code>, the key material was imported or the KMS key doesn't have any key material.
         * </p>
         * <p>
         * The only valid values for DeriveSharedSecret are <code>AWS_KMS</code> and <code>EXTERNAL</code>.
         * DeriveSharedSecret does not support KMS keys with a <code>KeyOrigin</code> value of <code>AWS_CLOUDHSM</code>
         * or <code>EXTERNAL_KEY_STORE</code>.
         * </p>
         * 
         * @param keyOrigin
         *        The source of the key material for the specified KMS key.</p>
         *        <p>
         *        When this value is <code>AWS_KMS</code>, KMS created the key material. When this value is
         *        <code>EXTERNAL</code>, the key material was imported or the KMS key doesn't have any key material.
         *        </p>
         *        <p>
         *        The only valid values for DeriveSharedSecret are <code>AWS_KMS</code> and <code>EXTERNAL</code>.
         *        DeriveSharedSecret does not support KMS keys with a <code>KeyOrigin</code> value of
         *        <code>AWS_CLOUDHSM</code> or <code>EXTERNAL_KEY_STORE</code>.
         * @see OriginType
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see OriginType
         */
        Builder keyOrigin(String keyOrigin);

        /**
         * <p>
         * The source of the key material for the specified KMS key.
         * </p>
         * <p>
         * When this value is <code>AWS_KMS</code>, KMS created the key material. When this value is
         * <code>EXTERNAL</code>, the key material was imported or the KMS key doesn't have any key material.
         * </p>
         * <p>
         * The only valid values for DeriveSharedSecret are <code>AWS_KMS</code> and <code>EXTERNAL</code>.
         * DeriveSharedSecret does not support KMS keys with a <code>KeyOrigin</code> value of <code>AWS_CLOUDHSM</code>
         * or <code>EXTERNAL_KEY_STORE</code>.
         * </p>
         * 
         * @param keyOrigin
         *        The source of the key material for the specified KMS key.</p>
         *        <p>
         *        When this value is <code>AWS_KMS</code>, KMS created the key material. When this value is
         *        <code>EXTERNAL</code>, the key material was imported or the KMS key doesn't have any key material.
         *        </p>
         *        <p>
         *        The only valid values for DeriveSharedSecret are <code>AWS_KMS</code> and <code>EXTERNAL</code>.
         *        DeriveSharedSecret does not support KMS keys with a <code>KeyOrigin</code> value of
         *        <code>AWS_CLOUDHSM</code> or <code>EXTERNAL_KEY_STORE</code>.
         * @see OriginType
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see OriginType
         */
        Builder keyOrigin(OriginType keyOrigin);
    }

    static final class BuilderImpl extends KmsResponse.BuilderImpl implements Builder {
        private String keyId;

        private SdkBytes sharedSecret;

        private SdkBytes ciphertextForRecipient;

        private String keyAgreementAlgorithm;

        private String keyOrigin;

        private BuilderImpl() {
        }

        private BuilderImpl(DeriveSharedSecretResponse model) {
            super(model);
            keyId(model.keyId);
            sharedSecret(model.sharedSecret);
            ciphertextForRecipient(model.ciphertextForRecipient);
            keyAgreementAlgorithm(model.keyAgreementAlgorithm);
            keyOrigin(model.keyOrigin);
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

        public final ByteBuffer getSharedSecret() {
            return sharedSecret == null ? null : sharedSecret.asByteBuffer();
        }

        public final void setSharedSecret(ByteBuffer sharedSecret) {
            sharedSecret(sharedSecret == null ? null : SdkBytes.fromByteBuffer(sharedSecret));
        }

        @Override
        public final Builder sharedSecret(SdkBytes sharedSecret) {
            this.sharedSecret = sharedSecret;
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

        public final String getKeyAgreementAlgorithm() {
            return keyAgreementAlgorithm;
        }

        public final void setKeyAgreementAlgorithm(String keyAgreementAlgorithm) {
            this.keyAgreementAlgorithm = keyAgreementAlgorithm;
        }

        @Override
        public final Builder keyAgreementAlgorithm(String keyAgreementAlgorithm) {
            this.keyAgreementAlgorithm = keyAgreementAlgorithm;
            return this;
        }

        @Override
        public final Builder keyAgreementAlgorithm(KeyAgreementAlgorithmSpec keyAgreementAlgorithm) {
            this.keyAgreementAlgorithm(keyAgreementAlgorithm == null ? null : keyAgreementAlgorithm.toString());
            return this;
        }

        public final String getKeyOrigin() {
            return keyOrigin;
        }

        public final void setKeyOrigin(String keyOrigin) {
            this.keyOrigin = keyOrigin;
        }

        @Override
        public final Builder keyOrigin(String keyOrigin) {
            this.keyOrigin = keyOrigin;
            return this;
        }

        @Override
        public final Builder keyOrigin(OriginType keyOrigin) {
            this.keyOrigin(keyOrigin == null ? null : keyOrigin.toString());
            return this;
        }

        @Override
        public DeriveSharedSecretResponse build() {
            return new DeriveSharedSecretResponse(this);
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
