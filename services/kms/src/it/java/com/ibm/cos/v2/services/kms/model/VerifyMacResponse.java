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
public final class VerifyMacResponse extends KmsResponse implements
        ToCopyableBuilder<VerifyMacResponse.Builder, VerifyMacResponse> {
    private static final SdkField<String> KEY_ID_FIELD = SdkField.<String> builder(MarshallingType.STRING).memberName("KeyId")
            .getter(getter(VerifyMacResponse::keyId)).setter(setter(Builder::keyId))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("KeyId").build()).build();

    private static final SdkField<Boolean> MAC_VALID_FIELD = SdkField.<Boolean> builder(MarshallingType.BOOLEAN)
            .memberName("MacValid").getter(getter(VerifyMacResponse::macValid)).setter(setter(Builder::macValid))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("MacValid").build()).build();

    private static final SdkField<String> MAC_ALGORITHM_FIELD = SdkField.<String> builder(MarshallingType.STRING)
            .memberName("MacAlgorithm").getter(getter(VerifyMacResponse::macAlgorithmAsString))
            .setter(setter(Builder::macAlgorithm))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("MacAlgorithm").build()).build();

    private static final List<SdkField<?>> SDK_FIELDS = Collections.unmodifiableList(Arrays.asList(KEY_ID_FIELD, MAC_VALID_FIELD,
            MAC_ALGORITHM_FIELD));

    private static final Map<String, SdkField<?>> SDK_NAME_TO_FIELD = memberNameToFieldInitializer();

    private final String keyId;

    private final Boolean macValid;

    private final String macAlgorithm;

    private VerifyMacResponse(BuilderImpl builder) {
        super(builder);
        this.keyId = builder.keyId;
        this.macValid = builder.macValid;
        this.macAlgorithm = builder.macAlgorithm;
    }

    /**
     * <p>
     * The HMAC KMS key used in the verification.
     * </p>
     * 
     * @return The HMAC KMS key used in the verification.
     */
    public final String keyId() {
        return keyId;
    }

    /**
     * <p>
     * A Boolean value that indicates whether the HMAC was verified. A value of <code>True</code> indicates that the
     * HMAC (<code>Mac</code>) was generated with the specified <code>Message</code>, HMAC KMS key (<code>KeyID</code>)
     * and <code>MacAlgorithm.</code>.
     * </p>
     * <p>
     * If the HMAC is not verified, the <code>VerifyMac</code> operation fails with a
     * <code>KMSInvalidMacException</code> exception. This exception indicates that one or more of the inputs changed
     * since the HMAC was computed.
     * </p>
     * 
     * @return A Boolean value that indicates whether the HMAC was verified. A value of <code>True</code> indicates that
     *         the HMAC (<code>Mac</code>) was generated with the specified <code>Message</code>, HMAC KMS key (
     *         <code>KeyID</code>) and <code>MacAlgorithm.</code>.</p>
     *         <p>
     *         If the HMAC is not verified, the <code>VerifyMac</code> operation fails with a
     *         <code>KMSInvalidMacException</code> exception. This exception indicates that one or more of the inputs
     *         changed since the HMAC was computed.
     */
    public final Boolean macValid() {
        return macValid;
    }

    /**
     * <p>
     * The MAC algorithm used in the verification.
     * </p>
     * <p>
     * If the service returns an enum value that is not available in the current SDK version, {@link #macAlgorithm} will
     * return {@link MacAlgorithmSpec#UNKNOWN_TO_SDK_VERSION}. The raw value returned by the service is available from
     * {@link #macAlgorithmAsString}.
     * </p>
     * 
     * @return The MAC algorithm used in the verification.
     * @see MacAlgorithmSpec
     */
    public final MacAlgorithmSpec macAlgorithm() {
        return MacAlgorithmSpec.fromValue(macAlgorithm);
    }

    /**
     * <p>
     * The MAC algorithm used in the verification.
     * </p>
     * <p>
     * If the service returns an enum value that is not available in the current SDK version, {@link #macAlgorithm} will
     * return {@link MacAlgorithmSpec#UNKNOWN_TO_SDK_VERSION}. The raw value returned by the service is available from
     * {@link #macAlgorithmAsString}.
     * </p>
     * 
     * @return The MAC algorithm used in the verification.
     * @see MacAlgorithmSpec
     */
    public final String macAlgorithmAsString() {
        return macAlgorithm;
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
        hashCode = 31 * hashCode + Objects.hashCode(macValid());
        hashCode = 31 * hashCode + Objects.hashCode(macAlgorithmAsString());
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
        if (!(obj instanceof VerifyMacResponse)) {
            return false;
        }
        VerifyMacResponse other = (VerifyMacResponse) obj;
        return Objects.equals(keyId(), other.keyId()) && Objects.equals(macValid(), other.macValid())
                && Objects.equals(macAlgorithmAsString(), other.macAlgorithmAsString());
    }

    /**
     * Returns a string representation of this object. This is useful for testing and debugging. Sensitive data will be
     * redacted from this string using a placeholder value.
     */
    @Override
    public final String toString() {
        return ToString.builder("VerifyMacResponse").add("KeyId", keyId()).add("MacValid", macValid())
                .add("MacAlgorithm", macAlgorithmAsString()).build();
    }

    public final <T> Optional<T> getValueForField(String fieldName, Class<T> clazz) {
        switch (fieldName) {
        case "KeyId":
            return Optional.ofNullable(clazz.cast(keyId()));
        case "MacValid":
            return Optional.ofNullable(clazz.cast(macValid()));
        case "MacAlgorithm":
            return Optional.ofNullable(clazz.cast(macAlgorithmAsString()));
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
        map.put("MacValid", MAC_VALID_FIELD);
        map.put("MacAlgorithm", MAC_ALGORITHM_FIELD);
        return Collections.unmodifiableMap(map);
    }

    private static <T> Function<Object, T> getter(Function<VerifyMacResponse, T> g) {
        return obj -> g.apply((VerifyMacResponse) obj);
    }

    private static <T> BiConsumer<Object, T> setter(BiConsumer<Builder, T> s) {
        return (obj, val) -> s.accept((Builder) obj, val);
    }

    @Mutable
    @NotThreadSafe
    public interface Builder extends KmsResponse.Builder, SdkPojo, CopyableBuilder<Builder, VerifyMacResponse> {
        /**
         * <p>
         * The HMAC KMS key used in the verification.
         * </p>
         * 
         * @param keyId
         *        The HMAC KMS key used in the verification.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder keyId(String keyId);

        /**
         * <p>
         * A Boolean value that indicates whether the HMAC was verified. A value of <code>True</code> indicates that the
         * HMAC (<code>Mac</code>) was generated with the specified <code>Message</code>, HMAC KMS key (
         * <code>KeyID</code>) and <code>MacAlgorithm.</code>.
         * </p>
         * <p>
         * If the HMAC is not verified, the <code>VerifyMac</code> operation fails with a
         * <code>KMSInvalidMacException</code> exception. This exception indicates that one or more of the inputs
         * changed since the HMAC was computed.
         * </p>
         * 
         * @param macValid
         *        A Boolean value that indicates whether the HMAC was verified. A value of <code>True</code> indicates
         *        that the HMAC (<code>Mac</code>) was generated with the specified <code>Message</code>, HMAC KMS key (
         *        <code>KeyID</code>) and <code>MacAlgorithm.</code>.</p>
         *        <p>
         *        If the HMAC is not verified, the <code>VerifyMac</code> operation fails with a
         *        <code>KMSInvalidMacException</code> exception. This exception indicates that one or more of the inputs
         *        changed since the HMAC was computed.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder macValid(Boolean macValid);

        /**
         * <p>
         * The MAC algorithm used in the verification.
         * </p>
         * 
         * @param macAlgorithm
         *        The MAC algorithm used in the verification.
         * @see MacAlgorithmSpec
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see MacAlgorithmSpec
         */
        Builder macAlgorithm(String macAlgorithm);

        /**
         * <p>
         * The MAC algorithm used in the verification.
         * </p>
         * 
         * @param macAlgorithm
         *        The MAC algorithm used in the verification.
         * @see MacAlgorithmSpec
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see MacAlgorithmSpec
         */
        Builder macAlgorithm(MacAlgorithmSpec macAlgorithm);
    }

    static final class BuilderImpl extends KmsResponse.BuilderImpl implements Builder {
        private String keyId;

        private Boolean macValid;

        private String macAlgorithm;

        private BuilderImpl() {
        }

        private BuilderImpl(VerifyMacResponse model) {
            super(model);
            keyId(model.keyId);
            macValid(model.macValid);
            macAlgorithm(model.macAlgorithm);
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

        public final Boolean getMacValid() {
            return macValid;
        }

        public final void setMacValid(Boolean macValid) {
            this.macValid = macValid;
        }

        @Override
        public final Builder macValid(Boolean macValid) {
            this.macValid = macValid;
            return this;
        }

        public final String getMacAlgorithm() {
            return macAlgorithm;
        }

        public final void setMacAlgorithm(String macAlgorithm) {
            this.macAlgorithm = macAlgorithm;
        }

        @Override
        public final Builder macAlgorithm(String macAlgorithm) {
            this.macAlgorithm = macAlgorithm;
            return this;
        }

        @Override
        public final Builder macAlgorithm(MacAlgorithmSpec macAlgorithm) {
            this.macAlgorithm(macAlgorithm == null ? null : macAlgorithm.toString());
            return this;
        }

        @Override
        public VerifyMacResponse build() {
            return new VerifyMacResponse(this);
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
