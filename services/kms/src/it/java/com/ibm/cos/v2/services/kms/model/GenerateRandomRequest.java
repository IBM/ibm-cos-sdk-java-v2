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
import com.ibm.cos.v2.utils.ToString;
import com.ibm.cos.v2.utils.builder.CopyableBuilder;
import com.ibm.cos.v2.utils.builder.ToCopyableBuilder;

/**
 */
@Generated("com.ibm.cos.v2:codegen")
public final class GenerateRandomRequest extends KmsRequest implements
        ToCopyableBuilder<GenerateRandomRequest.Builder, GenerateRandomRequest> {
    private static final SdkField<Integer> NUMBER_OF_BYTES_FIELD = SdkField.<Integer> builder(MarshallingType.INTEGER)
            .memberName("NumberOfBytes").getter(getter(GenerateRandomRequest::numberOfBytes))
            .setter(setter(Builder::numberOfBytes))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("NumberOfBytes").build()).build();

    private static final SdkField<String> CUSTOM_KEY_STORE_ID_FIELD = SdkField.<String> builder(MarshallingType.STRING)
            .memberName("CustomKeyStoreId").getter(getter(GenerateRandomRequest::customKeyStoreId))
            .setter(setter(Builder::customKeyStoreId))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("CustomKeyStoreId").build()).build();

    private static final SdkField<RecipientInfo> RECIPIENT_FIELD = SdkField.<RecipientInfo> builder(MarshallingType.SDK_POJO)
            .memberName("Recipient").getter(getter(GenerateRandomRequest::recipient)).setter(setter(Builder::recipient))
            .constructor(RecipientInfo::builder)
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("Recipient").build()).build();

    private static final List<SdkField<?>> SDK_FIELDS = Collections.unmodifiableList(Arrays.asList(NUMBER_OF_BYTES_FIELD,
            CUSTOM_KEY_STORE_ID_FIELD, RECIPIENT_FIELD));

    private static final Map<String, SdkField<?>> SDK_NAME_TO_FIELD = memberNameToFieldInitializer();

    private final Integer numberOfBytes;

    private final String customKeyStoreId;

    private final RecipientInfo recipient;

    private GenerateRandomRequest(BuilderImpl builder) {
        super(builder);
        this.numberOfBytes = builder.numberOfBytes;
        this.customKeyStoreId = builder.customKeyStoreId;
        this.recipient = builder.recipient;
    }

    /**
     * <p>
     * The length of the random byte string. This parameter is required.
     * </p>
     * 
     * @return The length of the random byte string. This parameter is required.
     */
    public final Integer numberOfBytes() {
        return numberOfBytes;
    }

    /**
     * <p>
     * Generates the random byte string in the CloudHSM cluster that is associated with the specified CloudHSM key
     * store. To find the ID of a custom key store, use the <a>DescribeCustomKeyStores</a> operation.
     * </p>
     * <p>
     * External key store IDs are not valid for this parameter. If you specify the ID of an external key store,
     * <code>GenerateRandom</code> throws an <code>UnsupportedOperationException</code>.
     * </p>
     * 
     * @return Generates the random byte string in the CloudHSM cluster that is associated with the specified CloudHSM
     *         key store. To find the ID of a custom key store, use the <a>DescribeCustomKeyStores</a> operation.</p>
     *         <p>
     *         External key store IDs are not valid for this parameter. If you specify the ID of an external key store,
     *         <code>GenerateRandom</code> throws an <code>UnsupportedOperationException</code>.
     */
    public final String customKeyStoreId() {
        return customKeyStoreId;
    }

    /**
     * <p>
     * A signed <a
     * href="https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/nitro-enclave-how.html#term-attestdoc">attestation
     * document</a> from an Amazon Web Services Nitro enclave and the encryption algorithm to use with the enclave's
     * public key. The only valid encryption algorithm is <code>RSAES_OAEP_SHA_256</code>.
     * </p>
     * <p>
     * This parameter only supports attestation documents for Amazon Web Services Nitro Enclaves. To include this
     * parameter, use the <a
     * href="https://docs.aws.amazon.com/enclaves/latest/user/developing-applications.html#sdk">Amazon Web Services
     * Nitro Enclaves SDK</a> or any Amazon Web Services SDK.
     * </p>
     * <p>
     * When you use this parameter, instead of returning plaintext bytes, KMS encrypts the plaintext bytes under the
     * public key in the attestation document, and returns the resulting ciphertext in the
     * <code>CiphertextForRecipient</code> field in the response. This ciphertext can be decrypted only with the private
     * key in the enclave. The <code>Plaintext</code> field in the response is null or empty.
     * </p>
     * <p>
     * For information about the interaction between KMS and Amazon Web Services Nitro Enclaves, see <a
     * href="https://docs.aws.amazon.com/kms/latest/developerguide/services-nitro-enclaves.html">How Amazon Web Services
     * Nitro Enclaves uses KMS</a> in the <i>Key Management Service Developer Guide</i>.
     * </p>
     * 
     * @return A signed <a
     *         href="https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/nitro-enclave-how.html#term-attestdoc"
     *         >attestation document</a> from an Amazon Web Services Nitro enclave and the encryption algorithm to use
     *         with the enclave's public key. The only valid encryption algorithm is <code>RSAES_OAEP_SHA_256</code>.
     *         </p>
     *         <p>
     *         This parameter only supports attestation documents for Amazon Web Services Nitro Enclaves. To include
     *         this parameter, use the <a
     *         href="https://docs.aws.amazon.com/enclaves/latest/user/developing-applications.html#sdk">Amazon Web
     *         Services Nitro Enclaves SDK</a> or any Amazon Web Services SDK.
     *         </p>
     *         <p>
     *         When you use this parameter, instead of returning plaintext bytes, KMS encrypts the plaintext bytes under
     *         the public key in the attestation document, and returns the resulting ciphertext in the
     *         <code>CiphertextForRecipient</code> field in the response. This ciphertext can be decrypted only with the
     *         private key in the enclave. The <code>Plaintext</code> field in the response is null or empty.
     *         </p>
     *         <p>
     *         For information about the interaction between KMS and Amazon Web Services Nitro Enclaves, see <a
     *         href="https://docs.aws.amazon.com/kms/latest/developerguide/services-nitro-enclaves.html">How Amazon Web
     *         Services Nitro Enclaves uses KMS</a> in the <i>Key Management Service Developer Guide</i>.
     */
    public final RecipientInfo recipient() {
        return recipient;
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
        hashCode = 31 * hashCode + Objects.hashCode(numberOfBytes());
        hashCode = 31 * hashCode + Objects.hashCode(customKeyStoreId());
        hashCode = 31 * hashCode + Objects.hashCode(recipient());
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
        if (!(obj instanceof GenerateRandomRequest)) {
            return false;
        }
        GenerateRandomRequest other = (GenerateRandomRequest) obj;
        return Objects.equals(numberOfBytes(), other.numberOfBytes())
                && Objects.equals(customKeyStoreId(), other.customKeyStoreId()) && Objects.equals(recipient(), other.recipient());
    }

    /**
     * Returns a string representation of this object. This is useful for testing and debugging. Sensitive data will be
     * redacted from this string using a placeholder value.
     */
    @Override
    public final String toString() {
        return ToString.builder("GenerateRandomRequest").add("NumberOfBytes", numberOfBytes())
                .add("CustomKeyStoreId", customKeyStoreId()).add("Recipient", recipient()).build();
    }

    public final <T> Optional<T> getValueForField(String fieldName, Class<T> clazz) {
        switch (fieldName) {
        case "NumberOfBytes":
            return Optional.ofNullable(clazz.cast(numberOfBytes()));
        case "CustomKeyStoreId":
            return Optional.ofNullable(clazz.cast(customKeyStoreId()));
        case "Recipient":
            return Optional.ofNullable(clazz.cast(recipient()));
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
        map.put("NumberOfBytes", NUMBER_OF_BYTES_FIELD);
        map.put("CustomKeyStoreId", CUSTOM_KEY_STORE_ID_FIELD);
        map.put("Recipient", RECIPIENT_FIELD);
        return Collections.unmodifiableMap(map);
    }

    private static <T> Function<Object, T> getter(Function<GenerateRandomRequest, T> g) {
        return obj -> g.apply((GenerateRandomRequest) obj);
    }

    private static <T> BiConsumer<Object, T> setter(BiConsumer<Builder, T> s) {
        return (obj, val) -> s.accept((Builder) obj, val);
    }

    @Mutable
    @NotThreadSafe
    public interface Builder extends KmsRequest.Builder, SdkPojo, CopyableBuilder<Builder, GenerateRandomRequest> {
        /**
         * <p>
         * The length of the random byte string. This parameter is required.
         * </p>
         * 
         * @param numberOfBytes
         *        The length of the random byte string. This parameter is required.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder numberOfBytes(Integer numberOfBytes);

        /**
         * <p>
         * Generates the random byte string in the CloudHSM cluster that is associated with the specified CloudHSM key
         * store. To find the ID of a custom key store, use the <a>DescribeCustomKeyStores</a> operation.
         * </p>
         * <p>
         * External key store IDs are not valid for this parameter. If you specify the ID of an external key store,
         * <code>GenerateRandom</code> throws an <code>UnsupportedOperationException</code>.
         * </p>
         * 
         * @param customKeyStoreId
         *        Generates the random byte string in the CloudHSM cluster that is associated with the specified
         *        CloudHSM key store. To find the ID of a custom key store, use the <a>DescribeCustomKeyStores</a>
         *        operation.</p>
         *        <p>
         *        External key store IDs are not valid for this parameter. If you specify the ID of an external key
         *        store, <code>GenerateRandom</code> throws an <code>UnsupportedOperationException</code>.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder customKeyStoreId(String customKeyStoreId);

        /**
         * <p>
         * A signed <a href="https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/nitro-enclave-how.html#term-attestdoc">
         * attestation document</a> from an Amazon Web Services Nitro enclave and the encryption algorithm to use with
         * the enclave's public key. The only valid encryption algorithm is <code>RSAES_OAEP_SHA_256</code>.
         * </p>
         * <p>
         * This parameter only supports attestation documents for Amazon Web Services Nitro Enclaves. To include this
         * parameter, use the <a
         * href="https://docs.aws.amazon.com/enclaves/latest/user/developing-applications.html#sdk">Amazon Web Services
         * Nitro Enclaves SDK</a> or any Amazon Web Services SDK.
         * </p>
         * <p>
         * When you use this parameter, instead of returning plaintext bytes, KMS encrypts the plaintext bytes under the
         * public key in the attestation document, and returns the resulting ciphertext in the
         * <code>CiphertextForRecipient</code> field in the response. This ciphertext can be decrypted only with the
         * private key in the enclave. The <code>Plaintext</code> field in the response is null or empty.
         * </p>
         * <p>
         * For information about the interaction between KMS and Amazon Web Services Nitro Enclaves, see <a
         * href="https://docs.aws.amazon.com/kms/latest/developerguide/services-nitro-enclaves.html">How Amazon Web
         * Services Nitro Enclaves uses KMS</a> in the <i>Key Management Service Developer Guide</i>.
         * </p>
         * 
         * @param recipient
         *        A signed <a
         *        href="https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/nitro-enclave-how.html#term-attestdoc"
         *        >attestation document</a> from an Amazon Web Services Nitro enclave and the encryption algorithm to
         *        use with the enclave's public key. The only valid encryption algorithm is
         *        <code>RSAES_OAEP_SHA_256</code>. </p>
         *        <p>
         *        This parameter only supports attestation documents for Amazon Web Services Nitro Enclaves. To include
         *        this parameter, use the <a
         *        href="https://docs.aws.amazon.com/enclaves/latest/user/developing-applications.html#sdk">Amazon Web
         *        Services Nitro Enclaves SDK</a> or any Amazon Web Services SDK.
         *        </p>
         *        <p>
         *        When you use this parameter, instead of returning plaintext bytes, KMS encrypts the plaintext bytes
         *        under the public key in the attestation document, and returns the resulting ciphertext in the
         *        <code>CiphertextForRecipient</code> field in the response. This ciphertext can be decrypted only with
         *        the private key in the enclave. The <code>Plaintext</code> field in the response is null or empty.
         *        </p>
         *        <p>
         *        For information about the interaction between KMS and Amazon Web Services Nitro Enclaves, see <a
         *        href="https://docs.aws.amazon.com/kms/latest/developerguide/services-nitro-enclaves.html">How Amazon
         *        Web Services Nitro Enclaves uses KMS</a> in the <i>Key Management Service Developer Guide</i>.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder recipient(RecipientInfo recipient);

        /**
         * <p>
         * A signed <a href="https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/nitro-enclave-how.html#term-attestdoc">
         * attestation document</a> from an Amazon Web Services Nitro enclave and the encryption algorithm to use with
         * the enclave's public key. The only valid encryption algorithm is <code>RSAES_OAEP_SHA_256</code>.
         * </p>
         * <p>
         * This parameter only supports attestation documents for Amazon Web Services Nitro Enclaves. To include this
         * parameter, use the <a
         * href="https://docs.aws.amazon.com/enclaves/latest/user/developing-applications.html#sdk">Amazon Web Services
         * Nitro Enclaves SDK</a> or any Amazon Web Services SDK.
         * </p>
         * <p>
         * When you use this parameter, instead of returning plaintext bytes, KMS encrypts the plaintext bytes under the
         * public key in the attestation document, and returns the resulting ciphertext in the
         * <code>CiphertextForRecipient</code> field in the response. This ciphertext can be decrypted only with the
         * private key in the enclave. The <code>Plaintext</code> field in the response is null or empty.
         * </p>
         * <p>
         * For information about the interaction between KMS and Amazon Web Services Nitro Enclaves, see <a
         * href="https://docs.aws.amazon.com/kms/latest/developerguide/services-nitro-enclaves.html">How Amazon Web
         * Services Nitro Enclaves uses KMS</a> in the <i>Key Management Service Developer Guide</i>.
         * </p>
         * This is a convenience method that creates an instance of the {@link RecipientInfo.Builder} avoiding the need
         * to create one manually via {@link RecipientInfo#builder()}.
         *
         * <p>
         * When the {@link Consumer} completes, {@link RecipientInfo.Builder#build()} is called immediately and its
         * result is passed to {@link #recipient(RecipientInfo)}.
         * 
         * @param recipient
         *        a consumer that will call methods on {@link RecipientInfo.Builder}
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see #recipient(RecipientInfo)
         */
        default Builder recipient(Consumer<RecipientInfo.Builder> recipient) {
            return recipient(RecipientInfo.builder().applyMutation(recipient).build());
        }

        @Override
        Builder overrideConfiguration(AwsRequestOverrideConfiguration overrideConfiguration);

        @Override
        Builder overrideConfiguration(Consumer<AwsRequestOverrideConfiguration.Builder> builderConsumer);
    }

    static final class BuilderImpl extends KmsRequest.BuilderImpl implements Builder {
        private Integer numberOfBytes;

        private String customKeyStoreId;

        private RecipientInfo recipient;

        private BuilderImpl() {
        }

        private BuilderImpl(GenerateRandomRequest model) {
            super(model);
            numberOfBytes(model.numberOfBytes);
            customKeyStoreId(model.customKeyStoreId);
            recipient(model.recipient);
        }

        public final Integer getNumberOfBytes() {
            return numberOfBytes;
        }

        public final void setNumberOfBytes(Integer numberOfBytes) {
            this.numberOfBytes = numberOfBytes;
        }

        @Override
        public final Builder numberOfBytes(Integer numberOfBytes) {
            this.numberOfBytes = numberOfBytes;
            return this;
        }

        public final String getCustomKeyStoreId() {
            return customKeyStoreId;
        }

        public final void setCustomKeyStoreId(String customKeyStoreId) {
            this.customKeyStoreId = customKeyStoreId;
        }

        @Override
        public final Builder customKeyStoreId(String customKeyStoreId) {
            this.customKeyStoreId = customKeyStoreId;
            return this;
        }

        public final RecipientInfo.Builder getRecipient() {
            return recipient != null ? recipient.toBuilder() : null;
        }

        public final void setRecipient(RecipientInfo.BuilderImpl recipient) {
            this.recipient = recipient != null ? recipient.build() : null;
        }

        @Override
        public final Builder recipient(RecipientInfo recipient) {
            this.recipient = recipient;
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

        @Override
        public GenerateRandomRequest build() {
            return new GenerateRandomRequest(this);
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
