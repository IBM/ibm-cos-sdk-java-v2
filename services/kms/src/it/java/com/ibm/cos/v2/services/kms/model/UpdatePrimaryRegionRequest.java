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
public final class UpdatePrimaryRegionRequest extends KmsRequest implements
        ToCopyableBuilder<UpdatePrimaryRegionRequest.Builder, UpdatePrimaryRegionRequest> {
    private static final SdkField<String> KEY_ID_FIELD = SdkField.<String> builder(MarshallingType.STRING).memberName("KeyId")
            .getter(getter(UpdatePrimaryRegionRequest::keyId)).setter(setter(Builder::keyId))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("KeyId").build()).build();

    private static final SdkField<String> PRIMARY_REGION_FIELD = SdkField.<String> builder(MarshallingType.STRING)
            .memberName("PrimaryRegion").getter(getter(UpdatePrimaryRegionRequest::primaryRegion))
            .setter(setter(Builder::primaryRegion))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("PrimaryRegion").build()).build();

    private static final List<SdkField<?>> SDK_FIELDS = Collections.unmodifiableList(Arrays.asList(KEY_ID_FIELD,
            PRIMARY_REGION_FIELD));

    private static final Map<String, SdkField<?>> SDK_NAME_TO_FIELD = memberNameToFieldInitializer();

    private final String keyId;

    private final String primaryRegion;

    private UpdatePrimaryRegionRequest(BuilderImpl builder) {
        super(builder);
        this.keyId = builder.keyId;
        this.primaryRegion = builder.primaryRegion;
    }

    /**
     * <p>
     * Identifies the current primary key. When the operation completes, this KMS key will be a replica key.
     * </p>
     * <p>
     * Specify the key ID or key ARN of a multi-Region primary key.
     * </p>
     * <p>
     * For example:
     * </p>
     * <ul>
     * <li>
     * <p>
     * Key ID: <code>mrk-1234abcd12ab34cd56ef1234567890ab</code>
     * </p>
     * </li>
     * <li>
     * <p>
     * Key ARN: <code>arn:aws:kms:us-east-2:111122223333:key/mrk-1234abcd12ab34cd56ef1234567890ab</code>
     * </p>
     * </li>
     * </ul>
     * <p>
     * To get the key ID and key ARN for a KMS key, use <a>ListKeys</a> or <a>DescribeKey</a>.
     * </p>
     * 
     * @return Identifies the current primary key. When the operation completes, this KMS key will be a replica key.</p>
     *         <p>
     *         Specify the key ID or key ARN of a multi-Region primary key.
     *         </p>
     *         <p>
     *         For example:
     *         </p>
     *         <ul>
     *         <li>
     *         <p>
     *         Key ID: <code>mrk-1234abcd12ab34cd56ef1234567890ab</code>
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         Key ARN: <code>arn:aws:kms:us-east-2:111122223333:key/mrk-1234abcd12ab34cd56ef1234567890ab</code>
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
     * The Amazon Web Services Region of the new primary key. Enter the Region ID, such as <code>us-east-1</code> or
     * <code>ap-southeast-2</code>. There must be an existing replica key in this Region.
     * </p>
     * <p>
     * When the operation completes, the multi-Region key in this Region will be the primary key.
     * </p>
     * 
     * @return The Amazon Web Services Region of the new primary key. Enter the Region ID, such as
     *         <code>us-east-1</code> or <code>ap-southeast-2</code>. There must be an existing replica key in this
     *         Region. </p>
     *         <p>
     *         When the operation completes, the multi-Region key in this Region will be the primary key.
     */
    public final String primaryRegion() {
        return primaryRegion;
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
        hashCode = 31 * hashCode + Objects.hashCode(primaryRegion());
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
        if (!(obj instanceof UpdatePrimaryRegionRequest)) {
            return false;
        }
        UpdatePrimaryRegionRequest other = (UpdatePrimaryRegionRequest) obj;
        return Objects.equals(keyId(), other.keyId()) && Objects.equals(primaryRegion(), other.primaryRegion());
    }

    /**
     * Returns a string representation of this object. This is useful for testing and debugging. Sensitive data will be
     * redacted from this string using a placeholder value.
     */
    @Override
    public final String toString() {
        return ToString.builder("UpdatePrimaryRegionRequest").add("KeyId", keyId()).add("PrimaryRegion", primaryRegion()).build();
    }

    public final <T> Optional<T> getValueForField(String fieldName, Class<T> clazz) {
        switch (fieldName) {
        case "KeyId":
            return Optional.ofNullable(clazz.cast(keyId()));
        case "PrimaryRegion":
            return Optional.ofNullable(clazz.cast(primaryRegion()));
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
        map.put("PrimaryRegion", PRIMARY_REGION_FIELD);
        return Collections.unmodifiableMap(map);
    }

    private static <T> Function<Object, T> getter(Function<UpdatePrimaryRegionRequest, T> g) {
        return obj -> g.apply((UpdatePrimaryRegionRequest) obj);
    }

    private static <T> BiConsumer<Object, T> setter(BiConsumer<Builder, T> s) {
        return (obj, val) -> s.accept((Builder) obj, val);
    }

    @Mutable
    @NotThreadSafe
    public interface Builder extends KmsRequest.Builder, SdkPojo, CopyableBuilder<Builder, UpdatePrimaryRegionRequest> {
        /**
         * <p>
         * Identifies the current primary key. When the operation completes, this KMS key will be a replica key.
         * </p>
         * <p>
         * Specify the key ID or key ARN of a multi-Region primary key.
         * </p>
         * <p>
         * For example:
         * </p>
         * <ul>
         * <li>
         * <p>
         * Key ID: <code>mrk-1234abcd12ab34cd56ef1234567890ab</code>
         * </p>
         * </li>
         * <li>
         * <p>
         * Key ARN: <code>arn:aws:kms:us-east-2:111122223333:key/mrk-1234abcd12ab34cd56ef1234567890ab</code>
         * </p>
         * </li>
         * </ul>
         * <p>
         * To get the key ID and key ARN for a KMS key, use <a>ListKeys</a> or <a>DescribeKey</a>.
         * </p>
         * 
         * @param keyId
         *        Identifies the current primary key. When the operation completes, this KMS key will be a replica
         *        key.</p>
         *        <p>
         *        Specify the key ID or key ARN of a multi-Region primary key.
         *        </p>
         *        <p>
         *        For example:
         *        </p>
         *        <ul>
         *        <li>
         *        <p>
         *        Key ID: <code>mrk-1234abcd12ab34cd56ef1234567890ab</code>
         *        </p>
         *        </li>
         *        <li>
         *        <p>
         *        Key ARN: <code>arn:aws:kms:us-east-2:111122223333:key/mrk-1234abcd12ab34cd56ef1234567890ab</code>
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
         * The Amazon Web Services Region of the new primary key. Enter the Region ID, such as <code>us-east-1</code> or
         * <code>ap-southeast-2</code>. There must be an existing replica key in this Region.
         * </p>
         * <p>
         * When the operation completes, the multi-Region key in this Region will be the primary key.
         * </p>
         * 
         * @param primaryRegion
         *        The Amazon Web Services Region of the new primary key. Enter the Region ID, such as
         *        <code>us-east-1</code> or <code>ap-southeast-2</code>. There must be an existing replica key in this
         *        Region. </p>
         *        <p>
         *        When the operation completes, the multi-Region key in this Region will be the primary key.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder primaryRegion(String primaryRegion);

        @Override
        Builder overrideConfiguration(AwsRequestOverrideConfiguration overrideConfiguration);

        @Override
        Builder overrideConfiguration(Consumer<AwsRequestOverrideConfiguration.Builder> builderConsumer);
    }

    static final class BuilderImpl extends KmsRequest.BuilderImpl implements Builder {
        private String keyId;

        private String primaryRegion;

        private BuilderImpl() {
        }

        private BuilderImpl(UpdatePrimaryRegionRequest model) {
            super(model);
            keyId(model.keyId);
            primaryRegion(model.primaryRegion);
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

        public final String getPrimaryRegion() {
            return primaryRegion;
        }

        public final void setPrimaryRegion(String primaryRegion) {
            this.primaryRegion = primaryRegion;
        }

        @Override
        public final Builder primaryRegion(String primaryRegion) {
            this.primaryRegion = primaryRegion;
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
        public UpdatePrimaryRegionRequest build() {
            return new UpdatePrimaryRegionRequest(this);
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
