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
public final class GenerateMacResponse extends KmsResponse implements
        ToCopyableBuilder<GenerateMacResponse.Builder, GenerateMacResponse> {
    private static final SdkField<SdkBytes> MAC_FIELD = SdkField.<SdkBytes> builder(MarshallingType.SDK_BYTES).memberName("Mac")
            .getter(getter(GenerateMacResponse::mac)).setter(setter(Builder::mac))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("Mac").build()).build();

    private static final SdkField<String> MAC_ALGORITHM_FIELD = SdkField.<String> builder(MarshallingType.STRING)
            .memberName("MacAlgorithm").getter(getter(GenerateMacResponse::macAlgorithmAsString))
            .setter(setter(Builder::macAlgorithm))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("MacAlgorithm").build()).build();

    private static final SdkField<String> KEY_ID_FIELD = SdkField.<String> builder(MarshallingType.STRING).memberName("KeyId")
            .getter(getter(GenerateMacResponse::keyId)).setter(setter(Builder::keyId))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("KeyId").build()).build();

    private static final List<SdkField<?>> SDK_FIELDS = Collections.unmodifiableList(Arrays.asList(MAC_FIELD,
            MAC_ALGORITHM_FIELD, KEY_ID_FIELD));

    private static final Map<String, SdkField<?>> SDK_NAME_TO_FIELD = memberNameToFieldInitializer();

    private final SdkBytes mac;

    private final String macAlgorithm;

    private final String keyId;

    private GenerateMacResponse(BuilderImpl builder) {
        super(builder);
        this.mac = builder.mac;
        this.macAlgorithm = builder.macAlgorithm;
        this.keyId = builder.keyId;
    }

    /**
     * <p>
     * The hash-based message authentication code (HMAC) that was generated for the specified message, HMAC KMS key, and
     * MAC algorithm.
     * </p>
     * <p>
     * This is the standard, raw HMAC defined in <a href="https://datatracker.ietf.org/doc/html/rfc2104">RFC 2104</a>.
     * </p>
     * 
     * @return The hash-based message authentication code (HMAC) that was generated for the specified message, HMAC KMS
     *         key, and MAC algorithm.</p>
     *         <p>
     *         This is the standard, raw HMAC defined in <a href="https://datatracker.ietf.org/doc/html/rfc2104">RFC
     *         2104</a>.
     */
    public final SdkBytes mac() {
        return mac;
    }

    /**
     * <p>
     * The MAC algorithm that was used to generate the HMAC.
     * </p>
     * <p>
     * If the service returns an enum value that is not available in the current SDK version, {@link #macAlgorithm} will
     * return {@link MacAlgorithmSpec#UNKNOWN_TO_SDK_VERSION}. The raw value returned by the service is available from
     * {@link #macAlgorithmAsString}.
     * </p>
     * 
     * @return The MAC algorithm that was used to generate the HMAC.
     * @see MacAlgorithmSpec
     */
    public final MacAlgorithmSpec macAlgorithm() {
        return MacAlgorithmSpec.fromValue(macAlgorithm);
    }

    /**
     * <p>
     * The MAC algorithm that was used to generate the HMAC.
     * </p>
     * <p>
     * If the service returns an enum value that is not available in the current SDK version, {@link #macAlgorithm} will
     * return {@link MacAlgorithmSpec#UNKNOWN_TO_SDK_VERSION}. The raw value returned by the service is available from
     * {@link #macAlgorithmAsString}.
     * </p>
     * 
     * @return The MAC algorithm that was used to generate the HMAC.
     * @see MacAlgorithmSpec
     */
    public final String macAlgorithmAsString() {
        return macAlgorithm;
    }

    /**
     * <p>
     * The HMAC KMS key used in the operation.
     * </p>
     * 
     * @return The HMAC KMS key used in the operation.
     */
    public final String keyId() {
        return keyId;
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
        hashCode = 31 * hashCode + Objects.hashCode(mac());
        hashCode = 31 * hashCode + Objects.hashCode(macAlgorithmAsString());
        hashCode = 31 * hashCode + Objects.hashCode(keyId());
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
        if (!(obj instanceof GenerateMacResponse)) {
            return false;
        }
        GenerateMacResponse other = (GenerateMacResponse) obj;
        return Objects.equals(mac(), other.mac()) && Objects.equals(macAlgorithmAsString(), other.macAlgorithmAsString())
                && Objects.equals(keyId(), other.keyId());
    }

    /**
     * Returns a string representation of this object. This is useful for testing and debugging. Sensitive data will be
     * redacted from this string using a placeholder value.
     */
    @Override
    public final String toString() {
        return ToString.builder("GenerateMacResponse").add("Mac", mac()).add("MacAlgorithm", macAlgorithmAsString())
                .add("KeyId", keyId()).build();
    }

    public final <T> Optional<T> getValueForField(String fieldName, Class<T> clazz) {
        switch (fieldName) {
        case "Mac":
            return Optional.ofNullable(clazz.cast(mac()));
        case "MacAlgorithm":
            return Optional.ofNullable(clazz.cast(macAlgorithmAsString()));
        case "KeyId":
            return Optional.ofNullable(clazz.cast(keyId()));
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
        map.put("Mac", MAC_FIELD);
        map.put("MacAlgorithm", MAC_ALGORITHM_FIELD);
        map.put("KeyId", KEY_ID_FIELD);
        return Collections.unmodifiableMap(map);
    }

    private static <T> Function<Object, T> getter(Function<GenerateMacResponse, T> g) {
        return obj -> g.apply((GenerateMacResponse) obj);
    }

    private static <T> BiConsumer<Object, T> setter(BiConsumer<Builder, T> s) {
        return (obj, val) -> s.accept((Builder) obj, val);
    }

    @Mutable
    @NotThreadSafe
    public interface Builder extends KmsResponse.Builder, SdkPojo, CopyableBuilder<Builder, GenerateMacResponse> {
        /**
         * <p>
         * The hash-based message authentication code (HMAC) that was generated for the specified message, HMAC KMS key,
         * and MAC algorithm.
         * </p>
         * <p>
         * This is the standard, raw HMAC defined in <a href="https://datatracker.ietf.org/doc/html/rfc2104">RFC
         * 2104</a>.
         * </p>
         * 
         * @param mac
         *        The hash-based message authentication code (HMAC) that was generated for the specified message, HMAC
         *        KMS key, and MAC algorithm.</p>
         *        <p>
         *        This is the standard, raw HMAC defined in <a href="https://datatracker.ietf.org/doc/html/rfc2104">RFC
         *        2104</a>.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder mac(SdkBytes mac);

        /**
         * <p>
         * The MAC algorithm that was used to generate the HMAC.
         * </p>
         * 
         * @param macAlgorithm
         *        The MAC algorithm that was used to generate the HMAC.
         * @see MacAlgorithmSpec
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see MacAlgorithmSpec
         */
        Builder macAlgorithm(String macAlgorithm);

        /**
         * <p>
         * The MAC algorithm that was used to generate the HMAC.
         * </p>
         * 
         * @param macAlgorithm
         *        The MAC algorithm that was used to generate the HMAC.
         * @see MacAlgorithmSpec
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see MacAlgorithmSpec
         */
        Builder macAlgorithm(MacAlgorithmSpec macAlgorithm);

        /**
         * <p>
         * The HMAC KMS key used in the operation.
         * </p>
         * 
         * @param keyId
         *        The HMAC KMS key used in the operation.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder keyId(String keyId);
    }

    static final class BuilderImpl extends KmsResponse.BuilderImpl implements Builder {
        private SdkBytes mac;

        private String macAlgorithm;

        private String keyId;

        private BuilderImpl() {
        }

        private BuilderImpl(GenerateMacResponse model) {
            super(model);
            mac(model.mac);
            macAlgorithm(model.macAlgorithm);
            keyId(model.keyId);
        }

        public final ByteBuffer getMac() {
            return mac == null ? null : mac.asByteBuffer();
        }

        public final void setMac(ByteBuffer mac) {
            mac(mac == null ? null : SdkBytes.fromByteBuffer(mac));
        }

        @Override
        public final Builder mac(SdkBytes mac) {
            this.mac = mac;
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

        @Override
        public GenerateMacResponse build() {
            return new GenerateMacResponse(this);
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
