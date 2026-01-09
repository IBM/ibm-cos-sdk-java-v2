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
public final class SignResponse extends KmsResponse implements ToCopyableBuilder<SignResponse.Builder, SignResponse> {
    private static final SdkField<String> KEY_ID_FIELD = SdkField.<String> builder(MarshallingType.STRING).memberName("KeyId")
            .getter(getter(SignResponse::keyId)).setter(setter(Builder::keyId))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("KeyId").build()).build();

    private static final SdkField<SdkBytes> SIGNATURE_FIELD = SdkField.<SdkBytes> builder(MarshallingType.SDK_BYTES)
            .memberName("Signature").getter(getter(SignResponse::signature)).setter(setter(Builder::signature))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("Signature").build()).build();

    private static final SdkField<String> SIGNING_ALGORITHM_FIELD = SdkField.<String> builder(MarshallingType.STRING)
            .memberName("SigningAlgorithm").getter(getter(SignResponse::signingAlgorithmAsString))
            .setter(setter(Builder::signingAlgorithm))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("SigningAlgorithm").build()).build();

    private static final List<SdkField<?>> SDK_FIELDS = Collections.unmodifiableList(Arrays.asList(KEY_ID_FIELD, SIGNATURE_FIELD,
            SIGNING_ALGORITHM_FIELD));

    private static final Map<String, SdkField<?>> SDK_NAME_TO_FIELD = memberNameToFieldInitializer();

    private final String keyId;

    private final SdkBytes signature;

    private final String signingAlgorithm;

    private SignResponse(BuilderImpl builder) {
        super(builder);
        this.keyId = builder.keyId;
        this.signature = builder.signature;
        this.signingAlgorithm = builder.signingAlgorithm;
    }

    /**
     * <p>
     * The Amazon Resource Name (<a
     * href="https://docs.aws.amazon.com/kms/latest/developerguide/concepts.html#key-id-key-ARN">key ARN</a>) of the
     * asymmetric KMS key that was used to sign the message.
     * </p>
     * 
     * @return The Amazon Resource Name (<a
     *         href="https://docs.aws.amazon.com/kms/latest/developerguide/concepts.html#key-id-key-ARN">key ARN</a>) of
     *         the asymmetric KMS key that was used to sign the message.
     */
    public final String keyId() {
        return keyId;
    }

    /**
     * <p>
     * The cryptographic signature that was generated for the message.
     * </p>
     * <ul>
     * <li>
     * <p>
     * When used with the supported RSA signing algorithms, the encoding of this value is defined by <a
     * href="https://tools.ietf.org/html/rfc8017">PKCS #1 in RFC 8017</a>.
     * </p>
     * </li>
     * <li>
     * <p>
     * When used with the <code>ECDSA_SHA_256</code>, <code>ECDSA_SHA_384</code>, or <code>ECDSA_SHA_512</code> signing
     * algorithms, this value is a DER-encoded object as defined by ANSI X9.62–2005 and <a
     * href="https://tools.ietf.org/html/rfc3279#section-2.2.3">RFC 3279 Section 2.2.3</a>. This is the most commonly
     * used signature format and is appropriate for most uses.
     * </p>
     * </li>
     * </ul>
     * <p>
     * When you use the HTTP API or the Amazon Web Services CLI, the value is Base64-encoded. Otherwise, it is not
     * Base64-encoded.
     * </p>
     * 
     * @return The cryptographic signature that was generated for the message. </p>
     *         <ul>
     *         <li>
     *         <p>
     *         When used with the supported RSA signing algorithms, the encoding of this value is defined by <a
     *         href="https://tools.ietf.org/html/rfc8017">PKCS #1 in RFC 8017</a>.
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         When used with the <code>ECDSA_SHA_256</code>, <code>ECDSA_SHA_384</code>, or <code>ECDSA_SHA_512</code>
     *         signing algorithms, this value is a DER-encoded object as defined by ANSI X9.62–2005 and <a
     *         href="https://tools.ietf.org/html/rfc3279#section-2.2.3">RFC 3279 Section 2.2.3</a>. This is the most
     *         commonly used signature format and is appropriate for most uses.
     *         </p>
     *         </li>
     *         </ul>
     *         <p>
     *         When you use the HTTP API or the Amazon Web Services CLI, the value is Base64-encoded. Otherwise, it is
     *         not Base64-encoded.
     */
    public final SdkBytes signature() {
        return signature;
    }

    /**
     * <p>
     * The signing algorithm that was used to sign the message.
     * </p>
     * <p>
     * If the service returns an enum value that is not available in the current SDK version, {@link #signingAlgorithm}
     * will return {@link SigningAlgorithmSpec#UNKNOWN_TO_SDK_VERSION}. The raw value returned by the service is
     * available from {@link #signingAlgorithmAsString}.
     * </p>
     * 
     * @return The signing algorithm that was used to sign the message.
     * @see SigningAlgorithmSpec
     */
    public final SigningAlgorithmSpec signingAlgorithm() {
        return SigningAlgorithmSpec.fromValue(signingAlgorithm);
    }

    /**
     * <p>
     * The signing algorithm that was used to sign the message.
     * </p>
     * <p>
     * If the service returns an enum value that is not available in the current SDK version, {@link #signingAlgorithm}
     * will return {@link SigningAlgorithmSpec#UNKNOWN_TO_SDK_VERSION}. The raw value returned by the service is
     * available from {@link #signingAlgorithmAsString}.
     * </p>
     * 
     * @return The signing algorithm that was used to sign the message.
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
        hashCode = 31 * hashCode + Objects.hashCode(signature());
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
        if (!(obj instanceof SignResponse)) {
            return false;
        }
        SignResponse other = (SignResponse) obj;
        return Objects.equals(keyId(), other.keyId()) && Objects.equals(signature(), other.signature())
                && Objects.equals(signingAlgorithmAsString(), other.signingAlgorithmAsString());
    }

    /**
     * Returns a string representation of this object. This is useful for testing and debugging. Sensitive data will be
     * redacted from this string using a placeholder value.
     */
    @Override
    public final String toString() {
        return ToString.builder("SignResponse").add("KeyId", keyId()).add("Signature", signature())
                .add("SigningAlgorithm", signingAlgorithmAsString()).build();
    }

    public final <T> Optional<T> getValueForField(String fieldName, Class<T> clazz) {
        switch (fieldName) {
        case "KeyId":
            return Optional.ofNullable(clazz.cast(keyId()));
        case "Signature":
            return Optional.ofNullable(clazz.cast(signature()));
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
        map.put("Signature", SIGNATURE_FIELD);
        map.put("SigningAlgorithm", SIGNING_ALGORITHM_FIELD);
        return Collections.unmodifiableMap(map);
    }

    private static <T> Function<Object, T> getter(Function<SignResponse, T> g) {
        return obj -> g.apply((SignResponse) obj);
    }

    private static <T> BiConsumer<Object, T> setter(BiConsumer<Builder, T> s) {
        return (obj, val) -> s.accept((Builder) obj, val);
    }

    @Mutable
    @NotThreadSafe
    public interface Builder extends KmsResponse.Builder, SdkPojo, CopyableBuilder<Builder, SignResponse> {
        /**
         * <p>
         * The Amazon Resource Name (<a
         * href="https://docs.aws.amazon.com/kms/latest/developerguide/concepts.html#key-id-key-ARN">key ARN</a>) of the
         * asymmetric KMS key that was used to sign the message.
         * </p>
         * 
         * @param keyId
         *        The Amazon Resource Name (<a
         *        href="https://docs.aws.amazon.com/kms/latest/developerguide/concepts.html#key-id-key-ARN">key ARN</a>)
         *        of the asymmetric KMS key that was used to sign the message.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder keyId(String keyId);

        /**
         * <p>
         * The cryptographic signature that was generated for the message.
         * </p>
         * <ul>
         * <li>
         * <p>
         * When used with the supported RSA signing algorithms, the encoding of this value is defined by <a
         * href="https://tools.ietf.org/html/rfc8017">PKCS #1 in RFC 8017</a>.
         * </p>
         * </li>
         * <li>
         * <p>
         * When used with the <code>ECDSA_SHA_256</code>, <code>ECDSA_SHA_384</code>, or <code>ECDSA_SHA_512</code>
         * signing algorithms, this value is a DER-encoded object as defined by ANSI X9.62–2005 and <a
         * href="https://tools.ietf.org/html/rfc3279#section-2.2.3">RFC 3279 Section 2.2.3</a>. This is the most
         * commonly used signature format and is appropriate for most uses.
         * </p>
         * </li>
         * </ul>
         * <p>
         * When you use the HTTP API or the Amazon Web Services CLI, the value is Base64-encoded. Otherwise, it is not
         * Base64-encoded.
         * </p>
         * 
         * @param signature
         *        The cryptographic signature that was generated for the message. </p>
         *        <ul>
         *        <li>
         *        <p>
         *        When used with the supported RSA signing algorithms, the encoding of this value is defined by <a
         *        href="https://tools.ietf.org/html/rfc8017">PKCS #1 in RFC 8017</a>.
         *        </p>
         *        </li>
         *        <li>
         *        <p>
         *        When used with the <code>ECDSA_SHA_256</code>, <code>ECDSA_SHA_384</code>, or
         *        <code>ECDSA_SHA_512</code> signing algorithms, this value is a DER-encoded object as defined by ANSI
         *        X9.62–2005 and <a href="https://tools.ietf.org/html/rfc3279#section-2.2.3">RFC 3279 Section 2.2.3</a>.
         *        This is the most commonly used signature format and is appropriate for most uses.
         *        </p>
         *        </li>
         *        </ul>
         *        <p>
         *        When you use the HTTP API or the Amazon Web Services CLI, the value is Base64-encoded. Otherwise, it
         *        is not Base64-encoded.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder signature(SdkBytes signature);

        /**
         * <p>
         * The signing algorithm that was used to sign the message.
         * </p>
         * 
         * @param signingAlgorithm
         *        The signing algorithm that was used to sign the message.
         * @see SigningAlgorithmSpec
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see SigningAlgorithmSpec
         */
        Builder signingAlgorithm(String signingAlgorithm);

        /**
         * <p>
         * The signing algorithm that was used to sign the message.
         * </p>
         * 
         * @param signingAlgorithm
         *        The signing algorithm that was used to sign the message.
         * @see SigningAlgorithmSpec
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see SigningAlgorithmSpec
         */
        Builder signingAlgorithm(SigningAlgorithmSpec signingAlgorithm);
    }

    static final class BuilderImpl extends KmsResponse.BuilderImpl implements Builder {
        private String keyId;

        private SdkBytes signature;

        private String signingAlgorithm;

        private BuilderImpl() {
        }

        private BuilderImpl(SignResponse model) {
            super(model);
            keyId(model.keyId);
            signature(model.signature);
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

        public final ByteBuffer getSignature() {
            return signature == null ? null : signature.asByteBuffer();
        }

        public final void setSignature(ByteBuffer signature) {
            signature(signature == null ? null : SdkBytes.fromByteBuffer(signature));
        }

        @Override
        public final Builder signature(SdkBytes signature) {
            this.signature = signature;
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
        public SignResponse build() {
            return new SignResponse(this);
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
