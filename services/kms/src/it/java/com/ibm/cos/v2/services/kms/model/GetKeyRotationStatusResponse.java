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
 */
@Generated("com.ibm.cos.v2:codegen")
public final class GetKeyRotationStatusResponse extends KmsResponse implements
        ToCopyableBuilder<GetKeyRotationStatusResponse.Builder, GetKeyRotationStatusResponse> {
    private static final SdkField<Boolean> KEY_ROTATION_ENABLED_FIELD = SdkField.<Boolean> builder(MarshallingType.BOOLEAN)
            .memberName("KeyRotationEnabled").getter(getter(GetKeyRotationStatusResponse::keyRotationEnabled))
            .setter(setter(Builder::keyRotationEnabled))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("KeyRotationEnabled").build())
            .build();

    private static final SdkField<String> KEY_ID_FIELD = SdkField.<String> builder(MarshallingType.STRING).memberName("KeyId")
            .getter(getter(GetKeyRotationStatusResponse::keyId)).setter(setter(Builder::keyId))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("KeyId").build()).build();

    private static final SdkField<Integer> ROTATION_PERIOD_IN_DAYS_FIELD = SdkField.<Integer> builder(MarshallingType.INTEGER)
            .memberName("RotationPeriodInDays").getter(getter(GetKeyRotationStatusResponse::rotationPeriodInDays))
            .setter(setter(Builder::rotationPeriodInDays))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("RotationPeriodInDays").build())
            .build();

    private static final SdkField<Instant> NEXT_ROTATION_DATE_FIELD = SdkField.<Instant> builder(MarshallingType.INSTANT)
            .memberName("NextRotationDate").getter(getter(GetKeyRotationStatusResponse::nextRotationDate))
            .setter(setter(Builder::nextRotationDate))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("NextRotationDate").build()).build();

    private static final SdkField<Instant> ON_DEMAND_ROTATION_START_DATE_FIELD = SdkField
            .<Instant> builder(MarshallingType.INSTANT).memberName("OnDemandRotationStartDate")
            .getter(getter(GetKeyRotationStatusResponse::onDemandRotationStartDate))
            .setter(setter(Builder::onDemandRotationStartDate))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("OnDemandRotationStartDate").build())
            .build();

    private static final List<SdkField<?>> SDK_FIELDS = Collections.unmodifiableList(Arrays.asList(KEY_ROTATION_ENABLED_FIELD,
            KEY_ID_FIELD, ROTATION_PERIOD_IN_DAYS_FIELD, NEXT_ROTATION_DATE_FIELD, ON_DEMAND_ROTATION_START_DATE_FIELD));

    private static final Map<String, SdkField<?>> SDK_NAME_TO_FIELD = memberNameToFieldInitializer();

    private final Boolean keyRotationEnabled;

    private final String keyId;

    private final Integer rotationPeriodInDays;

    private final Instant nextRotationDate;

    private final Instant onDemandRotationStartDate;

    private GetKeyRotationStatusResponse(BuilderImpl builder) {
        super(builder);
        this.keyRotationEnabled = builder.keyRotationEnabled;
        this.keyId = builder.keyId;
        this.rotationPeriodInDays = builder.rotationPeriodInDays;
        this.nextRotationDate = builder.nextRotationDate;
        this.onDemandRotationStartDate = builder.onDemandRotationStartDate;
    }

    /**
     * <p>
     * A Boolean value that specifies whether key rotation is enabled.
     * </p>
     * 
     * @return A Boolean value that specifies whether key rotation is enabled.
     */
    public final Boolean keyRotationEnabled() {
        return keyRotationEnabled;
    }

    /**
     * <p>
     * Identifies the specified symmetric encryption KMS key.
     * </p>
     * 
     * @return Identifies the specified symmetric encryption KMS key.
     */
    public final String keyId() {
        return keyId;
    }

    /**
     * <p>
     * The number of days between each automatic rotation. The default value is 365 days.
     * </p>
     * 
     * @return The number of days between each automatic rotation. The default value is 365 days.
     */
    public final Integer rotationPeriodInDays() {
        return rotationPeriodInDays;
    }

    /**
     * <p>
     * The next date that KMS will automatically rotate the key material.
     * </p>
     * 
     * @return The next date that KMS will automatically rotate the key material.
     */
    public final Instant nextRotationDate() {
        return nextRotationDate;
    }

    /**
     * <p>
     * Identifies the date and time that an in progress on-demand rotation was initiated.
     * </p>
     * <p>
     * The KMS API follows an <a
     * href="https://docs.aws.amazon.com/kms/latest/developerguide/programming-eventual-consistency.html">eventual
     * consistency</a> model due to the distributed nature of the system. As a result, there might be a slight delay
     * between initiating on-demand key rotation and the rotation's completion. Once the on-demand rotation is complete,
     * use <a>ListKeyRotations</a> to view the details of the on-demand rotation.
     * </p>
     * 
     * @return Identifies the date and time that an in progress on-demand rotation was initiated.</p>
     *         <p>
     *         The KMS API follows an <a
     *         href="https://docs.aws.amazon.com/kms/latest/developerguide/programming-eventual-consistency.html"
     *         >eventual consistency</a> model due to the distributed nature of the system. As a result, there might be
     *         a slight delay between initiating on-demand key rotation and the rotation's completion. Once the
     *         on-demand rotation is complete, use <a>ListKeyRotations</a> to view the details of the on-demand
     *         rotation.
     */
    public final Instant onDemandRotationStartDate() {
        return onDemandRotationStartDate;
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
        hashCode = 31 * hashCode + Objects.hashCode(keyRotationEnabled());
        hashCode = 31 * hashCode + Objects.hashCode(keyId());
        hashCode = 31 * hashCode + Objects.hashCode(rotationPeriodInDays());
        hashCode = 31 * hashCode + Objects.hashCode(nextRotationDate());
        hashCode = 31 * hashCode + Objects.hashCode(onDemandRotationStartDate());
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
        if (!(obj instanceof GetKeyRotationStatusResponse)) {
            return false;
        }
        GetKeyRotationStatusResponse other = (GetKeyRotationStatusResponse) obj;
        return Objects.equals(keyRotationEnabled(), other.keyRotationEnabled()) && Objects.equals(keyId(), other.keyId())
                && Objects.equals(rotationPeriodInDays(), other.rotationPeriodInDays())
                && Objects.equals(nextRotationDate(), other.nextRotationDate())
                && Objects.equals(onDemandRotationStartDate(), other.onDemandRotationStartDate());
    }

    /**
     * Returns a string representation of this object. This is useful for testing and debugging. Sensitive data will be
     * redacted from this string using a placeholder value.
     */
    @Override
    public final String toString() {
        return ToString.builder("GetKeyRotationStatusResponse").add("KeyRotationEnabled", keyRotationEnabled())
                .add("KeyId", keyId()).add("RotationPeriodInDays", rotationPeriodInDays())
                .add("NextRotationDate", nextRotationDate()).add("OnDemandRotationStartDate", onDemandRotationStartDate())
                .build();
    }

    public final <T> Optional<T> getValueForField(String fieldName, Class<T> clazz) {
        switch (fieldName) {
        case "KeyRotationEnabled":
            return Optional.ofNullable(clazz.cast(keyRotationEnabled()));
        case "KeyId":
            return Optional.ofNullable(clazz.cast(keyId()));
        case "RotationPeriodInDays":
            return Optional.ofNullable(clazz.cast(rotationPeriodInDays()));
        case "NextRotationDate":
            return Optional.ofNullable(clazz.cast(nextRotationDate()));
        case "OnDemandRotationStartDate":
            return Optional.ofNullable(clazz.cast(onDemandRotationStartDate()));
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
        map.put("KeyRotationEnabled", KEY_ROTATION_ENABLED_FIELD);
        map.put("KeyId", KEY_ID_FIELD);
        map.put("RotationPeriodInDays", ROTATION_PERIOD_IN_DAYS_FIELD);
        map.put("NextRotationDate", NEXT_ROTATION_DATE_FIELD);
        map.put("OnDemandRotationStartDate", ON_DEMAND_ROTATION_START_DATE_FIELD);
        return Collections.unmodifiableMap(map);
    }

    private static <T> Function<Object, T> getter(Function<GetKeyRotationStatusResponse, T> g) {
        return obj -> g.apply((GetKeyRotationStatusResponse) obj);
    }

    private static <T> BiConsumer<Object, T> setter(BiConsumer<Builder, T> s) {
        return (obj, val) -> s.accept((Builder) obj, val);
    }

    @Mutable
    @NotThreadSafe
    public interface Builder extends KmsResponse.Builder, SdkPojo, CopyableBuilder<Builder, GetKeyRotationStatusResponse> {
        /**
         * <p>
         * A Boolean value that specifies whether key rotation is enabled.
         * </p>
         * 
         * @param keyRotationEnabled
         *        A Boolean value that specifies whether key rotation is enabled.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder keyRotationEnabled(Boolean keyRotationEnabled);

        /**
         * <p>
         * Identifies the specified symmetric encryption KMS key.
         * </p>
         * 
         * @param keyId
         *        Identifies the specified symmetric encryption KMS key.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder keyId(String keyId);

        /**
         * <p>
         * The number of days between each automatic rotation. The default value is 365 days.
         * </p>
         * 
         * @param rotationPeriodInDays
         *        The number of days between each automatic rotation. The default value is 365 days.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder rotationPeriodInDays(Integer rotationPeriodInDays);

        /**
         * <p>
         * The next date that KMS will automatically rotate the key material.
         * </p>
         * 
         * @param nextRotationDate
         *        The next date that KMS will automatically rotate the key material.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder nextRotationDate(Instant nextRotationDate);

        /**
         * <p>
         * Identifies the date and time that an in progress on-demand rotation was initiated.
         * </p>
         * <p>
         * The KMS API follows an <a
         * href="https://docs.aws.amazon.com/kms/latest/developerguide/programming-eventual-consistency.html">eventual
         * consistency</a> model due to the distributed nature of the system. As a result, there might be a slight delay
         * between initiating on-demand key rotation and the rotation's completion. Once the on-demand rotation is
         * complete, use <a>ListKeyRotations</a> to view the details of the on-demand rotation.
         * </p>
         * 
         * @param onDemandRotationStartDate
         *        Identifies the date and time that an in progress on-demand rotation was initiated.</p>
         *        <p>
         *        The KMS API follows an <a
         *        href="https://docs.aws.amazon.com/kms/latest/developerguide/programming-eventual-consistency.html"
         *        >eventual consistency</a> model due to the distributed nature of the system. As a result, there might
         *        be a slight delay between initiating on-demand key rotation and the rotation's completion. Once the
         *        on-demand rotation is complete, use <a>ListKeyRotations</a> to view the details of the on-demand
         *        rotation.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder onDemandRotationStartDate(Instant onDemandRotationStartDate);
    }

    static final class BuilderImpl extends KmsResponse.BuilderImpl implements Builder {
        private Boolean keyRotationEnabled;

        private String keyId;

        private Integer rotationPeriodInDays;

        private Instant nextRotationDate;

        private Instant onDemandRotationStartDate;

        private BuilderImpl() {
        }

        private BuilderImpl(GetKeyRotationStatusResponse model) {
            super(model);
            keyRotationEnabled(model.keyRotationEnabled);
            keyId(model.keyId);
            rotationPeriodInDays(model.rotationPeriodInDays);
            nextRotationDate(model.nextRotationDate);
            onDemandRotationStartDate(model.onDemandRotationStartDate);
        }

        public final Boolean getKeyRotationEnabled() {
            return keyRotationEnabled;
        }

        public final void setKeyRotationEnabled(Boolean keyRotationEnabled) {
            this.keyRotationEnabled = keyRotationEnabled;
        }

        @Override
        public final Builder keyRotationEnabled(Boolean keyRotationEnabled) {
            this.keyRotationEnabled = keyRotationEnabled;
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

        public final Integer getRotationPeriodInDays() {
            return rotationPeriodInDays;
        }

        public final void setRotationPeriodInDays(Integer rotationPeriodInDays) {
            this.rotationPeriodInDays = rotationPeriodInDays;
        }

        @Override
        public final Builder rotationPeriodInDays(Integer rotationPeriodInDays) {
            this.rotationPeriodInDays = rotationPeriodInDays;
            return this;
        }

        public final Instant getNextRotationDate() {
            return nextRotationDate;
        }

        public final void setNextRotationDate(Instant nextRotationDate) {
            this.nextRotationDate = nextRotationDate;
        }

        @Override
        public final Builder nextRotationDate(Instant nextRotationDate) {
            this.nextRotationDate = nextRotationDate;
            return this;
        }

        public final Instant getOnDemandRotationStartDate() {
            return onDemandRotationStartDate;
        }

        public final void setOnDemandRotationStartDate(Instant onDemandRotationStartDate) {
            this.onDemandRotationStartDate = onDemandRotationStartDate;
        }

        @Override
        public final Builder onDemandRotationStartDate(Instant onDemandRotationStartDate) {
            this.onDemandRotationStartDate = onDemandRotationStartDate;
            return this;
        }

        @Override
        public GetKeyRotationStatusResponse build() {
            return new GetKeyRotationStatusResponse(this);
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
