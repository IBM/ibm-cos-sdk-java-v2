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
public final class EnableKeyRotationRequest extends KmsRequest implements
        ToCopyableBuilder<EnableKeyRotationRequest.Builder, EnableKeyRotationRequest> {
    private static final SdkField<String> KEY_ID_FIELD = SdkField.<String> builder(MarshallingType.STRING).memberName("KeyId")
            .getter(getter(EnableKeyRotationRequest::keyId)).setter(setter(Builder::keyId))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("KeyId").build()).build();

    private static final SdkField<Integer> ROTATION_PERIOD_IN_DAYS_FIELD = SdkField.<Integer> builder(MarshallingType.INTEGER)
            .memberName("RotationPeriodInDays").getter(getter(EnableKeyRotationRequest::rotationPeriodInDays))
            .setter(setter(Builder::rotationPeriodInDays))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("RotationPeriodInDays").build())
            .build();

    private static final List<SdkField<?>> SDK_FIELDS = Collections.unmodifiableList(Arrays.asList(KEY_ID_FIELD,
            ROTATION_PERIOD_IN_DAYS_FIELD));

    private static final Map<String, SdkField<?>> SDK_NAME_TO_FIELD = memberNameToFieldInitializer();

    private final String keyId;

    private final Integer rotationPeriodInDays;

    private EnableKeyRotationRequest(BuilderImpl builder) {
        super(builder);
        this.keyId = builder.keyId;
        this.rotationPeriodInDays = builder.rotationPeriodInDays;
    }

    /**
     * <p>
     * Identifies a symmetric encryption KMS key. You cannot enable automatic rotation of <a
     * href="https://docs.aws.amazon.com/kms/latest/developerguide/symmetric-asymmetric.html">asymmetric KMS keys</a>,
     * <a href="https://docs.aws.amazon.com/kms/latest/developerguide/hmac.html">HMAC KMS keys</a>, KMS keys with <a
     * href="https://docs.aws.amazon.com/kms/latest/developerguide/importing-keys.html">imported key material</a>, or
     * KMS keys in a <a
     * href="https://docs.aws.amazon.com/kms/latest/developerguide/custom-key-store-overview.html">custom key store</a>.
     * To enable or disable automatic rotation of a set of related <a
     * href="https://docs.aws.amazon.com/kms/latest/developerguide/multi-region-keys-manage.html#multi-region-rotate"
     * >multi-Region keys</a>, set the property on the primary key.
     * </p>
     * <p>
     * Specify the key ID or key ARN of the KMS key.
     * </p>
     * <p>
     * For example:
     * </p>
     * <ul>
     * <li>
     * <p>
     * Key ID: <code>1234abcd-12ab-34cd-56ef-1234567890ab</code>
     * </p>
     * </li>
     * <li>
     * <p>
     * Key ARN: <code>arn:aws:kms:us-east-2:111122223333:key/1234abcd-12ab-34cd-56ef-1234567890ab</code>
     * </p>
     * </li>
     * </ul>
     * <p>
     * To get the key ID and key ARN for a KMS key, use <a>ListKeys</a> or <a>DescribeKey</a>.
     * </p>
     * 
     * @return Identifies a symmetric encryption KMS key. You cannot enable automatic rotation of <a
     *         href="https://docs.aws.amazon.com/kms/latest/developerguide/symmetric-asymmetric.html">asymmetric KMS
     *         keys</a>, <a href="https://docs.aws.amazon.com/kms/latest/developerguide/hmac.html">HMAC KMS keys</a>,
     *         KMS keys with <a
     *         href="https://docs.aws.amazon.com/kms/latest/developerguide/importing-keys.html">imported key
     *         material</a>, or KMS keys in a <a
     *         href="https://docs.aws.amazon.com/kms/latest/developerguide/custom-key-store-overview.html">custom key
     *         store</a>. To enable or disable automatic rotation of a set of related <a href=
     *         "https://docs.aws.amazon.com/kms/latest/developerguide/multi-region-keys-manage.html#multi-region-rotate"
     *         >multi-Region keys</a>, set the property on the primary key.</p>
     *         <p>
     *         Specify the key ID or key ARN of the KMS key.
     *         </p>
     *         <p>
     *         For example:
     *         </p>
     *         <ul>
     *         <li>
     *         <p>
     *         Key ID: <code>1234abcd-12ab-34cd-56ef-1234567890ab</code>
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         Key ARN: <code>arn:aws:kms:us-east-2:111122223333:key/1234abcd-12ab-34cd-56ef-1234567890ab</code>
     *         </p>
     *         </li>
     *         </ul>
     *         <p>
     *         To get the key ID and key ARN for a KMS key, use <a>ListKeys</a> or <a>DescribeKey</a>.
     */
    public final String keyId() {
        return keyId;
    }

    /**
     * <p>
     * Use this parameter to specify a custom period of time between each rotation date. If no value is specified, the
     * default value is 365 days.
     * </p>
     * <p>
     * The rotation period defines the number of days after you enable automatic key rotation that KMS will rotate your
     * key material, and the number of days between each automatic rotation thereafter.
     * </p>
     * <p>
     * You can use the <a href=
     * "https://docs.aws.amazon.com/kms/latest/developerguide/conditions-kms.html#conditions-kms-rotation-period-in-days"
     * > <code>kms:RotationPeriodInDays</code> </a> condition key to further constrain the values that principals can
     * specify in the <code>RotationPeriodInDays</code> parameter.
     * </p>
     * <p>
     * </p>
     * 
     * @return Use this parameter to specify a custom period of time between each rotation date. If no value is
     *         specified, the default value is 365 days.</p>
     *         <p>
     *         The rotation period defines the number of days after you enable automatic key rotation that KMS will
     *         rotate your key material, and the number of days between each automatic rotation thereafter.
     *         </p>
     *         <p>
     *         You can use the <a href=
     *         "https://docs.aws.amazon.com/kms/latest/developerguide/conditions-kms.html#conditions-kms-rotation-period-in-days"
     *         > <code>kms:RotationPeriodInDays</code> </a> condition key to further constrain the values that
     *         principals can specify in the <code>RotationPeriodInDays</code> parameter.
     *         </p>
     *         <p>
     */
    public final Integer rotationPeriodInDays() {
        return rotationPeriodInDays;
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
        hashCode = 31 * hashCode + Objects.hashCode(rotationPeriodInDays());
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
        if (!(obj instanceof EnableKeyRotationRequest)) {
            return false;
        }
        EnableKeyRotationRequest other = (EnableKeyRotationRequest) obj;
        return Objects.equals(keyId(), other.keyId()) && Objects.equals(rotationPeriodInDays(), other.rotationPeriodInDays());
    }

    /**
     * Returns a string representation of this object. This is useful for testing and debugging. Sensitive data will be
     * redacted from this string using a placeholder value.
     */
    @Override
    public final String toString() {
        return ToString.builder("EnableKeyRotationRequest").add("KeyId", keyId())
                .add("RotationPeriodInDays", rotationPeriodInDays()).build();
    }

    public final <T> Optional<T> getValueForField(String fieldName, Class<T> clazz) {
        switch (fieldName) {
        case "KeyId":
            return Optional.ofNullable(clazz.cast(keyId()));
        case "RotationPeriodInDays":
            return Optional.ofNullable(clazz.cast(rotationPeriodInDays()));
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
        map.put("RotationPeriodInDays", ROTATION_PERIOD_IN_DAYS_FIELD);
        return Collections.unmodifiableMap(map);
    }

    private static <T> Function<Object, T> getter(Function<EnableKeyRotationRequest, T> g) {
        return obj -> g.apply((EnableKeyRotationRequest) obj);
    }

    private static <T> BiConsumer<Object, T> setter(BiConsumer<Builder, T> s) {
        return (obj, val) -> s.accept((Builder) obj, val);
    }

    @Mutable
    @NotThreadSafe
    public interface Builder extends KmsRequest.Builder, SdkPojo, CopyableBuilder<Builder, EnableKeyRotationRequest> {
        /**
         * <p>
         * Identifies a symmetric encryption KMS key. You cannot enable automatic rotation of <a
         * href="https://docs.aws.amazon.com/kms/latest/developerguide/symmetric-asymmetric.html">asymmetric KMS
         * keys</a>, <a href="https://docs.aws.amazon.com/kms/latest/developerguide/hmac.html">HMAC KMS keys</a>, KMS
         * keys with <a href="https://docs.aws.amazon.com/kms/latest/developerguide/importing-keys.html">imported key
         * material</a>, or KMS keys in a <a
         * href="https://docs.aws.amazon.com/kms/latest/developerguide/custom-key-store-overview.html">custom key
         * store</a>. To enable or disable automatic rotation of a set of related <a href=
         * "https://docs.aws.amazon.com/kms/latest/developerguide/multi-region-keys-manage.html#multi-region-rotate"
         * >multi-Region keys</a>, set the property on the primary key.
         * </p>
         * <p>
         * Specify the key ID or key ARN of the KMS key.
         * </p>
         * <p>
         * For example:
         * </p>
         * <ul>
         * <li>
         * <p>
         * Key ID: <code>1234abcd-12ab-34cd-56ef-1234567890ab</code>
         * </p>
         * </li>
         * <li>
         * <p>
         * Key ARN: <code>arn:aws:kms:us-east-2:111122223333:key/1234abcd-12ab-34cd-56ef-1234567890ab</code>
         * </p>
         * </li>
         * </ul>
         * <p>
         * To get the key ID and key ARN for a KMS key, use <a>ListKeys</a> or <a>DescribeKey</a>.
         * </p>
         * 
         * @param keyId
         *        Identifies a symmetric encryption KMS key. You cannot enable automatic rotation of <a
         *        href="https://docs.aws.amazon.com/kms/latest/developerguide/symmetric-asymmetric.html">asymmetric KMS
         *        keys</a>, <a href="https://docs.aws.amazon.com/kms/latest/developerguide/hmac.html">HMAC KMS keys</a>,
         *        KMS keys with <a
         *        href="https://docs.aws.amazon.com/kms/latest/developerguide/importing-keys.html">imported key
         *        material</a>, or KMS keys in a <a
         *        href="https://docs.aws.amazon.com/kms/latest/developerguide/custom-key-store-overview.html">custom key
         *        store</a>. To enable or disable automatic rotation of a set of related <a href=
         *        "https://docs.aws.amazon.com/kms/latest/developerguide/multi-region-keys-manage.html#multi-region-rotate"
         *        >multi-Region keys</a>, set the property on the primary key.</p>
         *        <p>
         *        Specify the key ID or key ARN of the KMS key.
         *        </p>
         *        <p>
         *        For example:
         *        </p>
         *        <ul>
         *        <li>
         *        <p>
         *        Key ID: <code>1234abcd-12ab-34cd-56ef-1234567890ab</code>
         *        </p>
         *        </li>
         *        <li>
         *        <p>
         *        Key ARN: <code>arn:aws:kms:us-east-2:111122223333:key/1234abcd-12ab-34cd-56ef-1234567890ab</code>
         *        </p>
         *        </li>
         *        </ul>
         *        <p>
         *        To get the key ID and key ARN for a KMS key, use <a>ListKeys</a> or <a>DescribeKey</a>.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder keyId(String keyId);

        /**
         * <p>
         * Use this parameter to specify a custom period of time between each rotation date. If no value is specified,
         * the default value is 365 days.
         * </p>
         * <p>
         * The rotation period defines the number of days after you enable automatic key rotation that KMS will rotate
         * your key material, and the number of days between each automatic rotation thereafter.
         * </p>
         * <p>
         * You can use the <a href=
         * "https://docs.aws.amazon.com/kms/latest/developerguide/conditions-kms.html#conditions-kms-rotation-period-in-days"
         * > <code>kms:RotationPeriodInDays</code> </a> condition key to further constrain the values that principals
         * can specify in the <code>RotationPeriodInDays</code> parameter.
         * </p>
         * <p>
         * </p>
         * 
         * @param rotationPeriodInDays
         *        Use this parameter to specify a custom period of time between each rotation date. If no value is
         *        specified, the default value is 365 days.</p>
         *        <p>
         *        The rotation period defines the number of days after you enable automatic key rotation that KMS will
         *        rotate your key material, and the number of days between each automatic rotation thereafter.
         *        </p>
         *        <p>
         *        You can use the <a href=
         *        "https://docs.aws.amazon.com/kms/latest/developerguide/conditions-kms.html#conditions-kms-rotation-period-in-days"
         *        > <code>kms:RotationPeriodInDays</code> </a> condition key to further constrain the values that
         *        principals can specify in the <code>RotationPeriodInDays</code> parameter.
         *        </p>
         *        <p>
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder rotationPeriodInDays(Integer rotationPeriodInDays);

        @Override
        Builder overrideConfiguration(AwsRequestOverrideConfiguration overrideConfiguration);

        @Override
        Builder overrideConfiguration(Consumer<AwsRequestOverrideConfiguration.Builder> builderConsumer);
    }

    static final class BuilderImpl extends KmsRequest.BuilderImpl implements Builder {
        private String keyId;

        private Integer rotationPeriodInDays;

        private BuilderImpl() {
        }

        private BuilderImpl(EnableKeyRotationRequest model) {
            super(model);
            keyId(model.keyId);
            rotationPeriodInDays(model.rotationPeriodInDays);
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
        public EnableKeyRotationRequest build() {
            return new EnableKeyRotationRequest(this);
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
