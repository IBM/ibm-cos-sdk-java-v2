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
public final class VerifyResponse extends KmsResponse implements ToCopyableBuilder<VerifyResponse.Builder, VerifyResponse> {
    private static final SdkField<String> KEY_ID_FIELD = SdkField.<String> builder(MarshallingType.STRING).memberName("KeyId")
            .getter(getter(VerifyResponse::keyId)).setter(setter(Builder::keyId))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("KeyId").build()).build();

    private static final SdkField<Boolean> SIGNATURE_VALID_FIELD = SdkField.<Boolean> builder(MarshallingType.BOOLEAN)
            .memberName("SignatureValid").getter(getter(VerifyResponse::signatureValid)).setter(setter(Builder::signatureValid))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("SignatureValid").build()).build();

    private static final SdkField<String> SIGNING_ALGORITHM_FIELD = SdkField.<String> builder(MarshallingType.STRING)
            .memberName("SigningAlgorithm").getter(getter(VerifyResponse::signingAlgorithmAsString))
            .setter(setter(Builder::signingAlgorithm))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("SigningAlgorithm").build()).build();

    private static final List<SdkField<?>> SDK_FIELDS = Collections.unmodifiableList(Arrays.asList(KEY_ID_FIELD,
            SIGNATURE_VALID_FIELD, SIGNING_ALGORITHM_FIELD));

    private static final Map<String, SdkField<?>> SDK_NAME_TO_FIELD = memberNameToFieldInitializer();

    private final String keyId;

    private final Boolean signatureValid;

    private final String signingAlgorithm;

    private VerifyResponse(BuilderImpl builder) {
        super(builder);
        this.keyId = builder.keyId;
        this.signatureValid = builder.signatureValid;
        this.signingAlgorithm = builder.signingAlgorithm;
    }

    /**
     * <p>
     * The Amazon Resource Name (<a
     * href="https://docs.aws.amazon.com/kms/latest/developerguide/concepts.html#key-id-key-ARN">key ARN</a>) of the
     * asymmetric KMS key that was used to verify the signature.
     * </p>
     * 
     * @return The Amazon Resource Name (<a
     *         href="https://docs.aws.amazon.com/kms/latest/developerguide/concepts.html#key-id-key-ARN">key ARN</a>) of
     *         the asymmetric KMS key that was used to verify the signature.
     */
    public final String keyId() {
        return keyId;
    }

    /**
     * <p>
     * A Boolean value that indicates whether the signature was verified. A value of <code>True</code> indicates that
     * the <code>Signature</code> was produced by signing the <code>Message</code> with the specified <code>KeyID</code>
     * and <code>SigningAlgorithm.</code> If the signature is not verified, the <code>Verify</code> operation fails with
     * a <code>KMSInvalidSignatureException</code> exception.
     * </p>
     * 
     * @return A Boolean value that indicates whether the signature was verified. A value of <code>True</code> indicates
     *         that the <code>Signature</code> was produced by signing the <code>Message</code> with the specified
     *         <code>KeyID</code> and <code>SigningAlgorithm.</code> If the signature is not verified, the
     *         <code>Verify</code> operation fails with a <code>KMSInvalidSignatureException</code> exception.
     */
    public final Boolean signatureValid() {
        return signatureValid;
    }

    /**
     * <p>
     * The signing algorithm that was used to verify the signature.
     * </p>
     * <p>
     * If the service returns an enum value that is not available in the current SDK version, {@link #signingAlgorithm}
     * will return {@link SigningAlgorithmSpec#UNKNOWN_TO_SDK_VERSION}. The raw value returned by the service is
     * available from {@link #signingAlgorithmAsString}.
     * </p>
     * 
     * @return The signing algorithm that was used to verify the signature.
     * @see SigningAlgorithmSpec
     */
    public final SigningAlgorithmSpec signingAlgorithm() {
        return SigningAlgorithmSpec.fromValue(signingAlgorithm);
    }

    /**
     * <p>
     * The signing algorithm that was used to verify the signature.
     * </p>
     * <p>
     * If the service returns an enum value that is not available in the current SDK version, {@link #signingAlgorithm}
     * will return {@link SigningAlgorithmSpec#UNKNOWN_TO_SDK_VERSION}. The raw value returned by the service is
     * available from {@link #signingAlgorithmAsString}.
     * </p>
     * 
     * @return The signing algorithm that was used to verify the signature.
     * @see SigningAlgorithmSpec
     */
    public final String signingAlgorithmAsString() {
        return signingAlgorithm;
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
        hashCode = 31 * hashCode + Objects.hashCode(signatureValid());
        hashCode = 31 * hashCode + Objects.hashCode(signingAlgorithmAsString());
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
        if (!(obj instanceof VerifyResponse)) {
            return false;
        }
        VerifyResponse other = (VerifyResponse) obj;
        return Objects.equals(keyId(), other.keyId()) && Objects.equals(signatureValid(), other.signatureValid())
                && Objects.equals(signingAlgorithmAsString(), other.signingAlgorithmAsString());
    }

    /**
     * Returns a string representation of this object. This is useful for testing and debugging. Sensitive data will be
     * redacted from this string using a placeholder value.
     */
    @Override
    public final String toString() {
        return ToString.builder("VerifyResponse").add("KeyId", keyId()).add("SignatureValid", signatureValid())
                .add("SigningAlgorithm", signingAlgorithmAsString()).build();
    }

    public final <T> Optional<T> getValueForField(String fieldName, Class<T> clazz) {
        switch (fieldName) {
        case "KeyId":
            return Optional.ofNullable(clazz.cast(keyId()));
        case "SignatureValid":
            return Optional.ofNullable(clazz.cast(signatureValid()));
        case "SigningAlgorithm":
            return Optional.ofNullable(clazz.cast(signingAlgorithmAsString()));
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
        map.put("SignatureValid", SIGNATURE_VALID_FIELD);
        map.put("SigningAlgorithm", SIGNING_ALGORITHM_FIELD);
        return Collections.unmodifiableMap(map);
    }

    private static <T> Function<Object, T> getter(Function<VerifyResponse, T> g) {
        return obj -> g.apply((VerifyResponse) obj);
    }

    private static <T> BiConsumer<Object, T> setter(BiConsumer<Builder, T> s) {
        return (obj, val) -> s.accept((Builder) obj, val);
    }

    @Mutable
    @NotThreadSafe
    public interface Builder extends KmsResponse.Builder, SdkPojo, CopyableBuilder<Builder, VerifyResponse> {
        /**
         * <p>
         * The Amazon Resource Name (<a
         * href="https://docs.aws.amazon.com/kms/latest/developerguide/concepts.html#key-id-key-ARN">key ARN</a>) of the
         * asymmetric KMS key that was used to verify the signature.
         * </p>
         * 
         * @param keyId
         *        The Amazon Resource Name (<a
         *        href="https://docs.aws.amazon.com/kms/latest/developerguide/concepts.html#key-id-key-ARN">key ARN</a>)
         *        of the asymmetric KMS key that was used to verify the signature.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder keyId(String keyId);

        /**
         * <p>
         * A Boolean value that indicates whether the signature was verified. A value of <code>True</code> indicates
         * that the <code>Signature</code> was produced by signing the <code>Message</code> with the specified
         * <code>KeyID</code> and <code>SigningAlgorithm.</code> If the signature is not verified, the
         * <code>Verify</code> operation fails with a <code>KMSInvalidSignatureException</code> exception.
         * </p>
         * 
         * @param signatureValid
         *        A Boolean value that indicates whether the signature was verified. A value of <code>True</code>
         *        indicates that the <code>Signature</code> was produced by signing the <code>Message</code> with the
         *        specified <code>KeyID</code> and <code>SigningAlgorithm.</code> If the signature is not verified, the
         *        <code>Verify</code> operation fails with a <code>KMSInvalidSignatureException</code> exception.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder signatureValid(Boolean signatureValid);

        /**
         * <p>
         * The signing algorithm that was used to verify the signature.
         * </p>
         * 
         * @param signingAlgorithm
         *        The signing algorithm that was used to verify the signature.
         * @see SigningAlgorithmSpec
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see SigningAlgorithmSpec
         */
        Builder signingAlgorithm(String signingAlgorithm);

        /**
         * <p>
         * The signing algorithm that was used to verify the signature.
         * </p>
         * 
         * @param signingAlgorithm
         *        The signing algorithm that was used to verify the signature.
         * @see SigningAlgorithmSpec
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see SigningAlgorithmSpec
         */
        Builder signingAlgorithm(SigningAlgorithmSpec signingAlgorithm);
    }

    static final class BuilderImpl extends KmsResponse.BuilderImpl implements Builder {
        private String keyId;

        private Boolean signatureValid;

        private String signingAlgorithm;

        private BuilderImpl() {
        }

        private BuilderImpl(VerifyResponse model) {
            super(model);
            keyId(model.keyId);
            signatureValid(model.signatureValid);
            signingAlgorithm(model.signingAlgorithm);
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

        public final Boolean getSignatureValid() {
            return signatureValid;
        }

        public final void setSignatureValid(Boolean signatureValid) {
            this.signatureValid = signatureValid;
        }

        @Override
        public final Builder signatureValid(Boolean signatureValid) {
            this.signatureValid = signatureValid;
            return this;
        }

        public final String getSigningAlgorithm() {
            return signingAlgorithm;
        }

        public final void setSigningAlgorithm(String signingAlgorithm) {
            this.signingAlgorithm = signingAlgorithm;
        }

        @Override
        public final Builder signingAlgorithm(String signingAlgorithm) {
            this.signingAlgorithm = signingAlgorithm;
            return this;
        }

        @Override
        public final Builder signingAlgorithm(SigningAlgorithmSpec signingAlgorithm) {
            this.signingAlgorithm(signingAlgorithm == null ? null : signingAlgorithm.toString());
            return this;
        }

        @Override
        public VerifyResponse build() {
            return new VerifyResponse(this);
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
