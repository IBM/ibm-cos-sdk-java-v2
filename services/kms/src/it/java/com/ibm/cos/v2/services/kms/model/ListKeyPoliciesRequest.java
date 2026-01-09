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
public final class ListKeyPoliciesRequest extends KmsRequest implements
        ToCopyableBuilder<ListKeyPoliciesRequest.Builder, ListKeyPoliciesRequest> {
    private static final SdkField<String> KEY_ID_FIELD = SdkField.<String> builder(MarshallingType.STRING).memberName("KeyId")
            .getter(getter(ListKeyPoliciesRequest::keyId)).setter(setter(Builder::keyId))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("KeyId").build()).build();

    private static final SdkField<Integer> LIMIT_FIELD = SdkField.<Integer> builder(MarshallingType.INTEGER).memberName("Limit")
            .getter(getter(ListKeyPoliciesRequest::limit)).setter(setter(Builder::limit))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("Limit").build()).build();

    private static final SdkField<String> MARKER_FIELD = SdkField.<String> builder(MarshallingType.STRING).memberName("Marker")
            .getter(getter(ListKeyPoliciesRequest::marker)).setter(setter(Builder::marker))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("Marker").build()).build();

    private static final List<SdkField<?>> SDK_FIELDS = Collections.unmodifiableList(Arrays.asList(KEY_ID_FIELD, LIMIT_FIELD,
            MARKER_FIELD));

    private static final Map<String, SdkField<?>> SDK_NAME_TO_FIELD = memberNameToFieldInitializer();

    private final String keyId;

    private final Integer limit;

    private final String marker;

    private ListKeyPoliciesRequest(BuilderImpl builder) {
        super(builder);
        this.keyId = builder.keyId;
        this.limit = builder.limit;
        this.marker = builder.marker;
    }

    /**
     * <p>
     * Gets the names of key policies for the specified KMS key.
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
     * @return Gets the names of key policies for the specified KMS key.</p>
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
     * Use this parameter to specify the maximum number of items to return. When this value is present, KMS does not
     * return more than the specified number of items, but it might return fewer.
     * </p>
     * <p>
     * This value is optional. If you include a value, it must be between 1 and 1000, inclusive. If you do not include a
     * value, it defaults to 100.
     * </p>
     * <p>
     * Only one policy can be attached to a key.
     * </p>
     * 
     * @return Use this parameter to specify the maximum number of items to return. When this value is present, KMS does
     *         not return more than the specified number of items, but it might return fewer.</p>
     *         <p>
     *         This value is optional. If you include a value, it must be between 1 and 1000, inclusive. If you do not
     *         include a value, it defaults to 100.
     *         </p>
     *         <p>
     *         Only one policy can be attached to a key.
     */
    public final Integer limit() {
        return limit;
    }

    /**
     * <p>
     * Use this parameter in a subsequent request after you receive a response with truncated results. Set it to the
     * value of <code>NextMarker</code> from the truncated response you just received.
     * </p>
     * 
     * @return Use this parameter in a subsequent request after you receive a response with truncated results. Set it to
     *         the value of <code>NextMarker</code> from the truncated response you just received.
     */
    public final String marker() {
        return marker;
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
        hashCode = 31 * hashCode + Objects.hashCode(limit());
        hashCode = 31 * hashCode + Objects.hashCode(marker());
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
        if (!(obj instanceof ListKeyPoliciesRequest)) {
            return false;
        }
        ListKeyPoliciesRequest other = (ListKeyPoliciesRequest) obj;
        return Objects.equals(keyId(), other.keyId()) && Objects.equals(limit(), other.limit())
                && Objects.equals(marker(), other.marker());
    }

    /**
     * Returns a string representation of this object. This is useful for testing and debugging. Sensitive data will be
     * redacted from this string using a placeholder value.
     */
    @Override
    public final String toString() {
        return ToString.builder("ListKeyPoliciesRequest").add("KeyId", keyId()).add("Limit", limit()).add("Marker", marker())
                .build();
    }

    public final <T> Optional<T> getValueForField(String fieldName, Class<T> clazz) {
        switch (fieldName) {
        case "KeyId":
            return Optional.ofNullable(clazz.cast(keyId()));
        case "Limit":
            return Optional.ofNullable(clazz.cast(limit()));
        case "Marker":
            return Optional.ofNullable(clazz.cast(marker()));
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
        map.put("Limit", LIMIT_FIELD);
        map.put("Marker", MARKER_FIELD);
        return Collections.unmodifiableMap(map);
    }

    private static <T> Function<Object, T> getter(Function<ListKeyPoliciesRequest, T> g) {
        return obj -> g.apply((ListKeyPoliciesRequest) obj);
    }

    private static <T> BiConsumer<Object, T> setter(BiConsumer<Builder, T> s) {
        return (obj, val) -> s.accept((Builder) obj, val);
    }

    @Mutable
    @NotThreadSafe
    public interface Builder extends KmsRequest.Builder, SdkPojo, CopyableBuilder<Builder, ListKeyPoliciesRequest> {
        /**
         * <p>
         * Gets the names of key policies for the specified KMS key.
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
         *        Gets the names of key policies for the specified KMS key.</p>
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
         * Use this parameter to specify the maximum number of items to return. When this value is present, KMS does not
         * return more than the specified number of items, but it might return fewer.
         * </p>
         * <p>
         * This value is optional. If you include a value, it must be between 1 and 1000, inclusive. If you do not
         * include a value, it defaults to 100.
         * </p>
         * <p>
         * Only one policy can be attached to a key.
         * </p>
         * 
         * @param limit
         *        Use this parameter to specify the maximum number of items to return. When this value is present, KMS
         *        does not return more than the specified number of items, but it might return fewer.</p>
         *        <p>
         *        This value is optional. If you include a value, it must be between 1 and 1000, inclusive. If you do
         *        not include a value, it defaults to 100.
         *        </p>
         *        <p>
         *        Only one policy can be attached to a key.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder limit(Integer limit);

        /**
         * <p>
         * Use this parameter in a subsequent request after you receive a response with truncated results. Set it to the
         * value of <code>NextMarker</code> from the truncated response you just received.
         * </p>
         * 
         * @param marker
         *        Use this parameter in a subsequent request after you receive a response with truncated results. Set it
         *        to the value of <code>NextMarker</code> from the truncated response you just received.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder marker(String marker);

        @Override
        Builder overrideConfiguration(AwsRequestOverrideConfiguration overrideConfiguration);

        @Override
        Builder overrideConfiguration(Consumer<AwsRequestOverrideConfiguration.Builder> builderConsumer);
    }

    static final class BuilderImpl extends KmsRequest.BuilderImpl implements Builder {
        private String keyId;

        private Integer limit;

        private String marker;

        private BuilderImpl() {
        }

        private BuilderImpl(ListKeyPoliciesRequest model) {
            super(model);
            keyId(model.keyId);
            limit(model.limit);
            marker(model.marker);
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

        public final Integer getLimit() {
            return limit;
        }

        public final void setLimit(Integer limit) {
            this.limit = limit;
        }

        @Override
        public final Builder limit(Integer limit) {
            this.limit = limit;
            return this;
        }

        public final String getMarker() {
            return marker;
        }

        public final void setMarker(String marker) {
            this.marker = marker;
        }

        @Override
        public final Builder marker(String marker) {
            this.marker = marker;
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
        public ListKeyPoliciesRequest build() {
            return new ListKeyPoliciesRequest(this);
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
