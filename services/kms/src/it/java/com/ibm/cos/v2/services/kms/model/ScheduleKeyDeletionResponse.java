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
public final class ScheduleKeyDeletionResponse extends KmsResponse implements
        ToCopyableBuilder<ScheduleKeyDeletionResponse.Builder, ScheduleKeyDeletionResponse> {
    private static final SdkField<String> KEY_ID_FIELD = SdkField.<String> builder(MarshallingType.STRING).memberName("KeyId")
            .getter(getter(ScheduleKeyDeletionResponse::keyId)).setter(setter(Builder::keyId))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("KeyId").build()).build();

    private static final SdkField<Instant> DELETION_DATE_FIELD = SdkField.<Instant> builder(MarshallingType.INSTANT)
            .memberName("DeletionDate").getter(getter(ScheduleKeyDeletionResponse::deletionDate))
            .setter(setter(Builder::deletionDate))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("DeletionDate").build()).build();

    private static final SdkField<String> KEY_STATE_FIELD = SdkField.<String> builder(MarshallingType.STRING)
            .memberName("KeyState").getter(getter(ScheduleKeyDeletionResponse::keyStateAsString))
            .setter(setter(Builder::keyState))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("KeyState").build()).build();

    private static final SdkField<Integer> PENDING_WINDOW_IN_DAYS_FIELD = SdkField.<Integer> builder(MarshallingType.INTEGER)
            .memberName("PendingWindowInDays").getter(getter(ScheduleKeyDeletionResponse::pendingWindowInDays))
            .setter(setter(Builder::pendingWindowInDays))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("PendingWindowInDays").build())
            .build();

    private static final List<SdkField<?>> SDK_FIELDS = Collections.unmodifiableList(Arrays.asList(KEY_ID_FIELD,
            DELETION_DATE_FIELD, KEY_STATE_FIELD, PENDING_WINDOW_IN_DAYS_FIELD));

    private static final Map<String, SdkField<?>> SDK_NAME_TO_FIELD = memberNameToFieldInitializer();

    private final String keyId;

    private final Instant deletionDate;

    private final String keyState;

    private final Integer pendingWindowInDays;

    private ScheduleKeyDeletionResponse(BuilderImpl builder) {
        super(builder);
        this.keyId = builder.keyId;
        this.deletionDate = builder.deletionDate;
        this.keyState = builder.keyState;
        this.pendingWindowInDays = builder.pendingWindowInDays;
    }

    /**
     * <p>
     * The Amazon Resource Name (<a
     * href="https://docs.aws.amazon.com/kms/latest/developerguide/concepts.html#key-id-key-ARN">key ARN</a>) of the KMS
     * key whose deletion is scheduled.
     * </p>
     * 
     * @return The Amazon Resource Name (<a
     *         href="https://docs.aws.amazon.com/kms/latest/developerguide/concepts.html#key-id-key-ARN">key ARN</a>) of
     *         the KMS key whose deletion is scheduled.
     */
    public final String keyId() {
        return keyId;
    }

    /**
     * <p>
     * The date and time after which KMS deletes the KMS key.
     * </p>
     * <p>
     * If the KMS key is a multi-Region primary key with replica keys, this field does not appear. The deletion date for
     * the primary key isn't known until its last replica key is deleted.
     * </p>
     * 
     * @return The date and time after which KMS deletes the KMS key.</p>
     *         <p>
     *         If the KMS key is a multi-Region primary key with replica keys, this field does not appear. The deletion
     *         date for the primary key isn't known until its last replica key is deleted.
     */
    public final Instant deletionDate() {
        return deletionDate;
    }

    /**
     * <p>
     * The current status of the KMS key.
     * </p>
     * <p>
     * For more information about how key state affects the use of a KMS key, see <a
     * href="https://docs.aws.amazon.com/kms/latest/developerguide/key-state.html">Key states of KMS keys</a> in the
     * <i>Key Management Service Developer Guide</i>.
     * </p>
     * <p>
     * If the service returns an enum value that is not available in the current SDK version, {@link #keyState} will
     * return {@link KeyState#UNKNOWN_TO_SDK_VERSION}. The raw value returned by the service is available from
     * {@link #keyStateAsString}.
     * </p>
     * 
     * @return The current status of the KMS key.</p>
     *         <p>
     *         For more information about how key state affects the use of a KMS key, see <a
     *         href="https://docs.aws.amazon.com/kms/latest/developerguide/key-state.html">Key states of KMS keys</a> in
     *         the <i>Key Management Service Developer Guide</i>.
     * @see KeyState
     */
    public final KeyState keyState() {
        return KeyState.fromValue(keyState);
    }

    /**
     * <p>
     * The current status of the KMS key.
     * </p>
     * <p>
     * For more information about how key state affects the use of a KMS key, see <a
     * href="https://docs.aws.amazon.com/kms/latest/developerguide/key-state.html">Key states of KMS keys</a> in the
     * <i>Key Management Service Developer Guide</i>.
     * </p>
     * <p>
     * If the service returns an enum value that is not available in the current SDK version, {@link #keyState} will
     * return {@link KeyState#UNKNOWN_TO_SDK_VERSION}. The raw value returned by the service is available from
     * {@link #keyStateAsString}.
     * </p>
     * 
     * @return The current status of the KMS key.</p>
     *         <p>
     *         For more information about how key state affects the use of a KMS key, see <a
     *         href="https://docs.aws.amazon.com/kms/latest/developerguide/key-state.html">Key states of KMS keys</a> in
     *         the <i>Key Management Service Developer Guide</i>.
     * @see KeyState
     */
    public final String keyStateAsString() {
        return keyState;
    }

    /**
     * <p>
     * The waiting period before the KMS key is deleted.
     * </p>
     * <p>
     * If the KMS key is a multi-Region primary key with replicas, the waiting period begins when the last of its
     * replica keys is deleted. Otherwise, the waiting period begins immediately.
     * </p>
     * 
     * @return The waiting period before the KMS key is deleted. </p>
     *         <p>
     *         If the KMS key is a multi-Region primary key with replicas, the waiting period begins when the last of
     *         its replica keys is deleted. Otherwise, the waiting period begins immediately.
     */
    public final Integer pendingWindowInDays() {
        return pendingWindowInDays;
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
        hashCode = 31 * hashCode + Objects.hashCode(deletionDate());
        hashCode = 31 * hashCode + Objects.hashCode(keyStateAsString());
        hashCode = 31 * hashCode + Objects.hashCode(pendingWindowInDays());
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
        if (!(obj instanceof ScheduleKeyDeletionResponse)) {
            return false;
        }
        ScheduleKeyDeletionResponse other = (ScheduleKeyDeletionResponse) obj;
        return Objects.equals(keyId(), other.keyId()) && Objects.equals(deletionDate(), other.deletionDate())
                && Objects.equals(keyStateAsString(), other.keyStateAsString())
                && Objects.equals(pendingWindowInDays(), other.pendingWindowInDays());
    }

    /**
     * Returns a string representation of this object. This is useful for testing and debugging. Sensitive data will be
     * redacted from this string using a placeholder value.
     */
    @Override
    public final String toString() {
        return ToString.builder("ScheduleKeyDeletionResponse").add("KeyId", keyId()).add("DeletionDate", deletionDate())
                .add("KeyState", keyStateAsString()).add("PendingWindowInDays", pendingWindowInDays()).build();
    }

    public final <T> Optional<T> getValueForField(String fieldName, Class<T> clazz) {
        switch (fieldName) {
        case "KeyId":
            return Optional.ofNullable(clazz.cast(keyId()));
        case "DeletionDate":
            return Optional.ofNullable(clazz.cast(deletionDate()));
        case "KeyState":
            return Optional.ofNullable(clazz.cast(keyStateAsString()));
        case "PendingWindowInDays":
            return Optional.ofNullable(clazz.cast(pendingWindowInDays()));
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
        map.put("DeletionDate", DELETION_DATE_FIELD);
        map.put("KeyState", KEY_STATE_FIELD);
        map.put("PendingWindowInDays", PENDING_WINDOW_IN_DAYS_FIELD);
        return Collections.unmodifiableMap(map);
    }

    private static <T> Function<Object, T> getter(Function<ScheduleKeyDeletionResponse, T> g) {
        return obj -> g.apply((ScheduleKeyDeletionResponse) obj);
    }

    private static <T> BiConsumer<Object, T> setter(BiConsumer<Builder, T> s) {
        return (obj, val) -> s.accept((Builder) obj, val);
    }

    @Mutable
    @NotThreadSafe
    public interface Builder extends KmsResponse.Builder, SdkPojo, CopyableBuilder<Builder, ScheduleKeyDeletionResponse> {
        /**
         * <p>
         * The Amazon Resource Name (<a
         * href="https://docs.aws.amazon.com/kms/latest/developerguide/concepts.html#key-id-key-ARN">key ARN</a>) of the
         * KMS key whose deletion is scheduled.
         * </p>
         * 
         * @param keyId
         *        The Amazon Resource Name (<a
         *        href="https://docs.aws.amazon.com/kms/latest/developerguide/concepts.html#key-id-key-ARN">key ARN</a>)
         *        of the KMS key whose deletion is scheduled.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder keyId(String keyId);

        /**
         * <p>
         * The date and time after which KMS deletes the KMS key.
         * </p>
         * <p>
         * If the KMS key is a multi-Region primary key with replica keys, this field does not appear. The deletion date
         * for the primary key isn't known until its last replica key is deleted.
         * </p>
         * 
         * @param deletionDate
         *        The date and time after which KMS deletes the KMS key.</p>
         *        <p>
         *        If the KMS key is a multi-Region primary key with replica keys, this field does not appear. The
         *        deletion date for the primary key isn't known until its last replica key is deleted.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder deletionDate(Instant deletionDate);

        /**
         * <p>
         * The current status of the KMS key.
         * </p>
         * <p>
         * For more information about how key state affects the use of a KMS key, see <a
         * href="https://docs.aws.amazon.com/kms/latest/developerguide/key-state.html">Key states of KMS keys</a> in the
         * <i>Key Management Service Developer Guide</i>.
         * </p>
         * 
         * @param keyState
         *        The current status of the KMS key.</p>
         *        <p>
         *        For more information about how key state affects the use of a KMS key, see <a
         *        href="https://docs.aws.amazon.com/kms/latest/developerguide/key-state.html">Key states of KMS keys</a>
         *        in the <i>Key Management Service Developer Guide</i>.
         * @see KeyState
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see KeyState
         */
        Builder keyState(String keyState);

        /**
         * <p>
         * The current status of the KMS key.
         * </p>
         * <p>
         * For more information about how key state affects the use of a KMS key, see <a
         * href="https://docs.aws.amazon.com/kms/latest/developerguide/key-state.html">Key states of KMS keys</a> in the
         * <i>Key Management Service Developer Guide</i>.
         * </p>
         * 
         * @param keyState
         *        The current status of the KMS key.</p>
         *        <p>
         *        For more information about how key state affects the use of a KMS key, see <a
         *        href="https://docs.aws.amazon.com/kms/latest/developerguide/key-state.html">Key states of KMS keys</a>
         *        in the <i>Key Management Service Developer Guide</i>.
         * @see KeyState
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see KeyState
         */
        Builder keyState(KeyState keyState);

        /**
         * <p>
         * The waiting period before the KMS key is deleted.
         * </p>
         * <p>
         * If the KMS key is a multi-Region primary key with replicas, the waiting period begins when the last of its
         * replica keys is deleted. Otherwise, the waiting period begins immediately.
         * </p>
         * 
         * @param pendingWindowInDays
         *        The waiting period before the KMS key is deleted. </p>
         *        <p>
         *        If the KMS key is a multi-Region primary key with replicas, the waiting period begins when the last of
         *        its replica keys is deleted. Otherwise, the waiting period begins immediately.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder pendingWindowInDays(Integer pendingWindowInDays);
    }

    static final class BuilderImpl extends KmsResponse.BuilderImpl implements Builder {
        private String keyId;

        private Instant deletionDate;

        private String keyState;

        private Integer pendingWindowInDays;

        private BuilderImpl() {
        }

        private BuilderImpl(ScheduleKeyDeletionResponse model) {
            super(model);
            keyId(model.keyId);
            deletionDate(model.deletionDate);
            keyState(model.keyState);
            pendingWindowInDays(model.pendingWindowInDays);
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

        public final Instant getDeletionDate() {
            return deletionDate;
        }

        public final void setDeletionDate(Instant deletionDate) {
            this.deletionDate = deletionDate;
        }

        @Override
        public final Builder deletionDate(Instant deletionDate) {
            this.deletionDate = deletionDate;
            return this;
        }

        public final String getKeyState() {
            return keyState;
        }

        public final void setKeyState(String keyState) {
            this.keyState = keyState;
        }

        @Override
        public final Builder keyState(String keyState) {
            this.keyState = keyState;
            return this;
        }

        @Override
        public final Builder keyState(KeyState keyState) {
            this.keyState(keyState == null ? null : keyState.toString());
            return this;
        }

        public final Integer getPendingWindowInDays() {
            return pendingWindowInDays;
        }

        public final void setPendingWindowInDays(Integer pendingWindowInDays) {
            this.pendingWindowInDays = pendingWindowInDays;
        }

        @Override
        public final Builder pendingWindowInDays(Integer pendingWindowInDays) {
            this.pendingWindowInDays = pendingWindowInDays;
            return this;
        }

        @Override
        public ScheduleKeyDeletionResponse build() {
            return new ScheduleKeyDeletionResponse(this);
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
