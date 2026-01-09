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

import java.io.Serializable;
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
 * <p>
 * Contains information about the party that receives the response from the API operation.
 * </p>
 * <p>
 * This data type is designed to support Amazon Web Services Nitro Enclaves, which lets you create an isolated compute
 * environment in Amazon EC2. For information about the interaction between KMS and Amazon Web Services Nitro Enclaves,
 * see <a href="https://docs.aws.amazon.com/kms/latest/developerguide/services-nitro-enclaves.html">How Amazon Web
 * Services Nitro Enclaves uses KMS</a> in the <i>Key Management Service Developer Guide</i>.
 * </p>
 */
@Generated("com.ibm.cos.v2:codegen")
public final class RecipientInfo implements SdkPojo, Serializable, ToCopyableBuilder<RecipientInfo.Builder, RecipientInfo> {
    private static final SdkField<String> KEY_ENCRYPTION_ALGORITHM_FIELD = SdkField.<String> builder(MarshallingType.STRING)
            .memberName("KeyEncryptionAlgorithm").getter(getter(RecipientInfo::keyEncryptionAlgorithmAsString))
            .setter(setter(Builder::keyEncryptionAlgorithm))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("KeyEncryptionAlgorithm").build())
            .build();

    private static final SdkField<SdkBytes> ATTESTATION_DOCUMENT_FIELD = SdkField.<SdkBytes> builder(MarshallingType.SDK_BYTES)
            .memberName("AttestationDocument").getter(getter(RecipientInfo::attestationDocument))
            .setter(setter(Builder::attestationDocument))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("AttestationDocument").build())
            .build();

    private static final List<SdkField<?>> SDK_FIELDS = Collections.unmodifiableList(Arrays.asList(
            KEY_ENCRYPTION_ALGORITHM_FIELD, ATTESTATION_DOCUMENT_FIELD));

    private static final Map<String, SdkField<?>> SDK_NAME_TO_FIELD = memberNameToFieldInitializer();

    private static final long serialVersionUID = 1L;

    private final String keyEncryptionAlgorithm;

    private final SdkBytes attestationDocument;

    private RecipientInfo(BuilderImpl builder) {
        this.keyEncryptionAlgorithm = builder.keyEncryptionAlgorithm;
        this.attestationDocument = builder.attestationDocument;
    }

    /**
     * <p>
     * The encryption algorithm that KMS should use with the public key for an Amazon Web Services Nitro Enclave to
     * encrypt plaintext values for the response. The only valid value is <code>RSAES_OAEP_SHA_256</code>.
     * </p>
     * <p>
     * If the service returns an enum value that is not available in the current SDK version,
     * {@link #keyEncryptionAlgorithm} will return {@link KeyEncryptionMechanism#UNKNOWN_TO_SDK_VERSION}. The raw value
     * returned by the service is available from {@link #keyEncryptionAlgorithmAsString}.
     * </p>
     * 
     * @return The encryption algorithm that KMS should use with the public key for an Amazon Web Services Nitro Enclave
     *         to encrypt plaintext values for the response. The only valid value is <code>RSAES_OAEP_SHA_256</code>.
     * @see KeyEncryptionMechanism
     */
    public final KeyEncryptionMechanism keyEncryptionAlgorithm() {
        return KeyEncryptionMechanism.fromValue(keyEncryptionAlgorithm);
    }

    /**
     * <p>
     * The encryption algorithm that KMS should use with the public key for an Amazon Web Services Nitro Enclave to
     * encrypt plaintext values for the response. The only valid value is <code>RSAES_OAEP_SHA_256</code>.
     * </p>
     * <p>
     * If the service returns an enum value that is not available in the current SDK version,
     * {@link #keyEncryptionAlgorithm} will return {@link KeyEncryptionMechanism#UNKNOWN_TO_SDK_VERSION}. The raw value
     * returned by the service is available from {@link #keyEncryptionAlgorithmAsString}.
     * </p>
     * 
     * @return The encryption algorithm that KMS should use with the public key for an Amazon Web Services Nitro Enclave
     *         to encrypt plaintext values for the response. The only valid value is <code>RSAES_OAEP_SHA_256</code>.
     * @see KeyEncryptionMechanism
     */
    public final String keyEncryptionAlgorithmAsString() {
        return keyEncryptionAlgorithm;
    }

    /**
     * <p>
     * The attestation document for an Amazon Web Services Nitro Enclave. This document includes the enclave's public
     * key.
     * </p>
     * 
     * @return The attestation document for an Amazon Web Services Nitro Enclave. This document includes the enclave's
     *         public key.
     */
    public final SdkBytes attestationDocument() {
        return attestationDocument;
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
        hashCode = 31 * hashCode + Objects.hashCode(keyEncryptionAlgorithmAsString());
        hashCode = 31 * hashCode + Objects.hashCode(attestationDocument());
        return hashCode;
    }

    @Override
    public final boolean equals(Object obj) {
        return equalsBySdkFields(obj);
    }

    @Override
    public final boolean equalsBySdkFields(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof RecipientInfo)) {
            return false;
        }
        RecipientInfo other = (RecipientInfo) obj;
        return Objects.equals(keyEncryptionAlgorithmAsString(), other.keyEncryptionAlgorithmAsString())
                && Objects.equals(attestationDocument(), other.attestationDocument());
    }

    /**
     * Returns a string representation of this object. This is useful for testing and debugging. Sensitive data will be
     * redacted from this string using a placeholder value.
     */
    @Override
    public final String toString() {
        return ToString.builder("RecipientInfo").add("KeyEncryptionAlgorithm", keyEncryptionAlgorithmAsString())
                .add("AttestationDocument", attestationDocument()).build();
    }

    public final <T> Optional<T> getValueForField(String fieldName, Class<T> clazz) {
        switch (fieldName) {
        case "KeyEncryptionAlgorithm":
            return Optional.ofNullable(clazz.cast(keyEncryptionAlgorithmAsString()));
        case "AttestationDocument":
            return Optional.ofNullable(clazz.cast(attestationDocument()));
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
        map.put("KeyEncryptionAlgorithm", KEY_ENCRYPTION_ALGORITHM_FIELD);
        map.put("AttestationDocument", ATTESTATION_DOCUMENT_FIELD);
        return Collections.unmodifiableMap(map);
    }

    private static <T> Function<Object, T> getter(Function<RecipientInfo, T> g) {
        return obj -> g.apply((RecipientInfo) obj);
    }

    private static <T> BiConsumer<Object, T> setter(BiConsumer<Builder, T> s) {
        return (obj, val) -> s.accept((Builder) obj, val);
    }

    @Mutable
    @NotThreadSafe
    public interface Builder extends SdkPojo, CopyableBuilder<Builder, RecipientInfo> {
        /**
         * <p>
         * The encryption algorithm that KMS should use with the public key for an Amazon Web Services Nitro Enclave to
         * encrypt plaintext values for the response. The only valid value is <code>RSAES_OAEP_SHA_256</code>.
         * </p>
         * 
         * @param keyEncryptionAlgorithm
         *        The encryption algorithm that KMS should use with the public key for an Amazon Web Services Nitro
         *        Enclave to encrypt plaintext values for the response. The only valid value is
         *        <code>RSAES_OAEP_SHA_256</code>.
         * @see KeyEncryptionMechanism
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see KeyEncryptionMechanism
         */
        Builder keyEncryptionAlgorithm(String keyEncryptionAlgorithm);

        /**
         * <p>
         * The encryption algorithm that KMS should use with the public key for an Amazon Web Services Nitro Enclave to
         * encrypt plaintext values for the response. The only valid value is <code>RSAES_OAEP_SHA_256</code>.
         * </p>
         * 
         * @param keyEncryptionAlgorithm
         *        The encryption algorithm that KMS should use with the public key for an Amazon Web Services Nitro
         *        Enclave to encrypt plaintext values for the response. The only valid value is
         *        <code>RSAES_OAEP_SHA_256</code>.
         * @see KeyEncryptionMechanism
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see KeyEncryptionMechanism
         */
        Builder keyEncryptionAlgorithm(KeyEncryptionMechanism keyEncryptionAlgorithm);

        /**
         * <p>
         * The attestation document for an Amazon Web Services Nitro Enclave. This document includes the enclave's
         * public key.
         * </p>
         * 
         * @param attestationDocument
         *        The attestation document for an Amazon Web Services Nitro Enclave. This document includes the
         *        enclave's public key.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder attestationDocument(SdkBytes attestationDocument);
    }

    static final class BuilderImpl implements Builder {
        private String keyEncryptionAlgorithm;

        private SdkBytes attestationDocument;

        private BuilderImpl() {
        }

        private BuilderImpl(RecipientInfo model) {
            keyEncryptionAlgorithm(model.keyEncryptionAlgorithm);
            attestationDocument(model.attestationDocument);
        }

        public final String getKeyEncryptionAlgorithm() {
            return keyEncryptionAlgorithm;
        }

        public final void setKeyEncryptionAlgorithm(String keyEncryptionAlgorithm) {
            this.keyEncryptionAlgorithm = keyEncryptionAlgorithm;
        }

        @Override
        public final Builder keyEncryptionAlgorithm(String keyEncryptionAlgorithm) {
            this.keyEncryptionAlgorithm = keyEncryptionAlgorithm;
            return this;
        }

        @Override
        public final Builder keyEncryptionAlgorithm(KeyEncryptionMechanism keyEncryptionAlgorithm) {
            this.keyEncryptionAlgorithm(keyEncryptionAlgorithm == null ? null : keyEncryptionAlgorithm.toString());
            return this;
        }

        public final ByteBuffer getAttestationDocument() {
            return attestationDocument == null ? null : attestationDocument.asByteBuffer();
        }

        public final void setAttestationDocument(ByteBuffer attestationDocument) {
            attestationDocument(attestationDocument == null ? null : SdkBytes.fromByteBuffer(attestationDocument));
        }

        @Override
        public final Builder attestationDocument(SdkBytes attestationDocument) {
            this.attestationDocument = attestationDocument;
            return this;
        }

        @Override
        public RecipientInfo build() {
            return new RecipientInfo(this);
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
