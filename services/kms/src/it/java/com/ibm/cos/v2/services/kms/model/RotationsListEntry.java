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
import java.time.Instant;
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
 * <p>
 * Contains information about completed key material rotations.
 * </p>
 */
@Generated("com.ibm.cos.v2:codegen")
public final class RotationsListEntry implements SdkPojo, Serializable,
        ToCopyableBuilder<RotationsListEntry.Builder, RotationsListEntry> {
    private static final SdkField<String> KEY_ID_FIELD = SdkField.<String> builder(MarshallingType.STRING).memberName("KeyId")
            .getter(getter(RotationsListEntry::keyId)).setter(setter(Builder::keyId))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("KeyId").build()).build();

    private static final SdkField<Instant> ROTATION_DATE_FIELD = SdkField.<Instant> builder(MarshallingType.INSTANT)
            .memberName("RotationDate").getter(getter(RotationsListEntry::rotationDate)).setter(setter(Builder::rotationDate))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("RotationDate").build()).build();

    private static final SdkField<String> ROTATION_TYPE_FIELD = SdkField.<String> builder(MarshallingType.STRING)
            .memberName("RotationType").getter(getter(RotationsListEntry::rotationTypeAsString))
            .setter(setter(Builder::rotationType))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("RotationType").build()).build();

    private static final List<SdkField<?>> SDK_FIELDS = Collections.unmodifiableList(Arrays.asList(KEY_ID_FIELD,
            ROTATION_DATE_FIELD, ROTATION_TYPE_FIELD));

    private static final Map<String, SdkField<?>> SDK_NAME_TO_FIELD = memberNameToFieldInitializer();

    private static final long serialVersionUID = 1L;

    private final String keyId;

    private final Instant rotationDate;

    private final String rotationType;

    private RotationsListEntry(BuilderImpl builder) {
        this.keyId = builder.keyId;
        this.rotationDate = builder.rotationDate;
        this.rotationType = builder.rotationType;
    }

    /**
     * <p>
     * Unique identifier of the key.
     * </p>
     * 
     * @return Unique identifier of the key.
     */
    public final String keyId() {
        return keyId;
    }

    /**
     * <p>
     * Date and time that the key material rotation completed. Formatted as Unix time.
     * </p>
     * 
     * @return Date and time that the key material rotation completed. Formatted as Unix time.
     */
    public final Instant rotationDate() {
        return rotationDate;
    }

    /**
     * <p>
     * Identifies whether the key material rotation was a scheduled <a
     * href="https://docs.aws.amazon.com/kms/latest/developerguide/rotate-keys.html#rotating-keys-enable-disable"
     * >automatic rotation</a> or an <a
     * href="https://docs.aws.amazon.com/kms/latest/developerguide/rotate-keys.html#rotating-keys-on-demand">on-demand
     * rotation</a>.
     * </p>
     * <p>
     * If the service returns an enum value that is not available in the current SDK version, {@link #rotationType} will
     * return {@link RotationType#UNKNOWN_TO_SDK_VERSION}. The raw value returned by the service is available from
     * {@link #rotationTypeAsString}.
     * </p>
     * 
     * @return Identifies whether the key material rotation was a scheduled <a
     *         href="https://docs.aws.amazon.com/kms/latest/developerguide/rotate-keys.html#rotating-keys-enable-disable"
     *         >automatic rotation</a> or an <a
     *         href="https://docs.aws.amazon.com/kms/latest/developerguide/rotate-keys.html#rotating-keys-on-demand"
     *         >on-demand rotation</a>.
     * @see RotationType
     */
    public final RotationType rotationType() {
        return RotationType.fromValue(rotationType);
    }

    /**
     * <p>
     * Identifies whether the key material rotation was a scheduled <a
     * href="https://docs.aws.amazon.com/kms/latest/developerguide/rotate-keys.html#rotating-keys-enable-disable"
     * >automatic rotation</a> or an <a
     * href="https://docs.aws.amazon.com/kms/latest/developerguide/rotate-keys.html#rotating-keys-on-demand">on-demand
     * rotation</a>.
     * </p>
     * <p>
     * If the service returns an enum value that is not available in the current SDK version, {@link #rotationType} will
     * return {@link RotationType#UNKNOWN_TO_SDK_VERSION}. The raw value returned by the service is available from
     * {@link #rotationTypeAsString}.
     * </p>
     * 
     * @return Identifies whether the key material rotation was a scheduled <a
     *         href="https://docs.aws.amazon.com/kms/latest/developerguide/rotate-keys.html#rotating-keys-enable-disable"
     *         >automatic rotation</a> or an <a
     *         href="https://docs.aws.amazon.com/kms/latest/developerguide/rotate-keys.html#rotating-keys-on-demand"
     *         >on-demand rotation</a>.
     * @see RotationType
     */
    public final String rotationTypeAsString() {
        return rotationType;
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
        hashCode = 31 * hashCode + Objects.hashCode(keyId());
        hashCode = 31 * hashCode + Objects.hashCode(rotationDate());
        hashCode = 31 * hashCode + Objects.hashCode(rotationTypeAsString());
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
        if (!(obj instanceof RotationsListEntry)) {
            return false;
        }
        RotationsListEntry other = (RotationsListEntry) obj;
        return Objects.equals(keyId(), other.keyId()) && Objects.equals(rotationDate(), other.rotationDate())
                && Objects.equals(rotationTypeAsString(), other.rotationTypeAsString());
    }

    /**
     * Returns a string representation of this object. This is useful for testing and debugging. Sensitive data will be
     * redacted from this string using a placeholder value.
     */
    @Override
    public final String toString() {
        return ToString.builder("RotationsListEntry").add("KeyId", keyId()).add("RotationDate", rotationDate())
                .add("RotationType", rotationTypeAsString()).build();
    }

    public final <T> Optional<T> getValueForField(String fieldName, Class<T> clazz) {
        switch (fieldName) {
        case "KeyId":
            return Optional.ofNullable(clazz.cast(keyId()));
        case "RotationDate":
            return Optional.ofNullable(clazz.cast(rotationDate()));
        case "RotationType":
            return Optional.ofNullable(clazz.cast(rotationTypeAsString()));
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
        map.put("RotationDate", ROTATION_DATE_FIELD);
        map.put("RotationType", ROTATION_TYPE_FIELD);
        return Collections.unmodifiableMap(map);
    }

    private static <T> Function<Object, T> getter(Function<RotationsListEntry, T> g) {
        return obj -> g.apply((RotationsListEntry) obj);
    }

    private static <T> BiConsumer<Object, T> setter(BiConsumer<Builder, T> s) {
        return (obj, val) -> s.accept((Builder) obj, val);
    }

    @Mutable
    @NotThreadSafe
    public interface Builder extends SdkPojo, CopyableBuilder<Builder, RotationsListEntry> {
        /**
         * <p>
         * Unique identifier of the key.
         * </p>
         * 
         * @param keyId
         *        Unique identifier of the key.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder keyId(String keyId);

        /**
         * <p>
         * Date and time that the key material rotation completed. Formatted as Unix time.
         * </p>
         * 
         * @param rotationDate
         *        Date and time that the key material rotation completed. Formatted as Unix time.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder rotationDate(Instant rotationDate);

        /**
         * <p>
         * Identifies whether the key material rotation was a scheduled <a
         * href="https://docs.aws.amazon.com/kms/latest/developerguide/rotate-keys.html#rotating-keys-enable-disable"
         * >automatic rotation</a> or an <a
         * href="https://docs.aws.amazon.com/kms/latest/developerguide/rotate-keys.html#rotating-keys-on-demand"
         * >on-demand rotation</a>.
         * </p>
         * 
         * @param rotationType
         *        Identifies whether the key material rotation was a scheduled <a href=
         *        "https://docs.aws.amazon.com/kms/latest/developerguide/rotate-keys.html#rotating-keys-enable-disable"
         *        >automatic rotation</a> or an <a href=
         *        "https://docs.aws.amazon.com/kms/latest/developerguide/rotate-keys.html#rotating-keys-on-demand"
         *        >on-demand rotation</a>.
         * @see RotationType
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see RotationType
         */
        Builder rotationType(String rotationType);

        /**
         * <p>
         * Identifies whether the key material rotation was a scheduled <a
         * href="https://docs.aws.amazon.com/kms/latest/developerguide/rotate-keys.html#rotating-keys-enable-disable"
         * >automatic rotation</a> or an <a
         * href="https://docs.aws.amazon.com/kms/latest/developerguide/rotate-keys.html#rotating-keys-on-demand"
         * >on-demand rotation</a>.
         * </p>
         * 
         * @param rotationType
         *        Identifies whether the key material rotation was a scheduled <a href=
         *        "https://docs.aws.amazon.com/kms/latest/developerguide/rotate-keys.html#rotating-keys-enable-disable"
         *        >automatic rotation</a> or an <a href=
         *        "https://docs.aws.amazon.com/kms/latest/developerguide/rotate-keys.html#rotating-keys-on-demand"
         *        >on-demand rotation</a>.
         * @see RotationType
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see RotationType
         */
        Builder rotationType(RotationType rotationType);
    }

    static final class BuilderImpl implements Builder {
        private String keyId;

        private Instant rotationDate;

        private String rotationType;

        private BuilderImpl() {
        }

        private BuilderImpl(RotationsListEntry model) {
            keyId(model.keyId);
            rotationDate(model.rotationDate);
            rotationType(model.rotationType);
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

        public final Instant getRotationDate() {
            return rotationDate;
        }

        public final void setRotationDate(Instant rotationDate) {
            this.rotationDate = rotationDate;
        }

        @Override
        public final Builder rotationDate(Instant rotationDate) {
            this.rotationDate = rotationDate;
            return this;
        }

        public final String getRotationType() {
            return rotationType;
        }

        public final void setRotationType(String rotationType) {
            this.rotationType = rotationType;
        }

        @Override
        public final Builder rotationType(String rotationType) {
            this.rotationType = rotationType;
            return this;
        }

        @Override
        public final Builder rotationType(RotationType rotationType) {
            this.rotationType(rotationType == null ? null : rotationType.toString());
            return this;
        }

        @Override
        public RotationsListEntry build() {
            return new RotationsListEntry(this);
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
