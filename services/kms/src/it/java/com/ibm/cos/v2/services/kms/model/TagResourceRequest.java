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
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import com.ibm.cos.v2.annotations.Generated;
import com.ibm.cos.v2.annotations.Mutable;
import com.ibm.cos.v2.annotations.NotThreadSafe;
import com.ibm.cos.v2.awscore.AwsRequestOverrideConfiguration;
import com.ibm.cos.v2.core.SdkField;
import com.ibm.cos.v2.core.SdkPojo;
import com.ibm.cos.v2.core.protocol.MarshallLocation;
import com.ibm.cos.v2.core.protocol.MarshallingType;
import com.ibm.cos.v2.core.traits.ListTrait;
import com.ibm.cos.v2.core.traits.LocationTrait;
import com.ibm.cos.v2.core.util.DefaultSdkAutoConstructList;
import com.ibm.cos.v2.core.util.SdkAutoConstructList;
import com.ibm.cos.v2.utils.ToString;
import com.ibm.cos.v2.utils.builder.CopyableBuilder;
import com.ibm.cos.v2.utils.builder.ToCopyableBuilder;

/**
 */
@Generated("com.ibm.cos.v2:codegen")
public final class TagResourceRequest extends KmsRequest implements
        ToCopyableBuilder<TagResourceRequest.Builder, TagResourceRequest> {
    private static final SdkField<String> KEY_ID_FIELD = SdkField.<String> builder(MarshallingType.STRING).memberName("KeyId")
            .getter(getter(TagResourceRequest::keyId)).setter(setter(Builder::keyId))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("KeyId").build()).build();

    private static final SdkField<List<Tag>> TAGS_FIELD = SdkField
            .<List<Tag>> builder(MarshallingType.LIST)
            .memberName("Tags")
            .getter(getter(TagResourceRequest::tags))
            .setter(setter(Builder::tags))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("Tags").build(),
                    ListTrait
                            .builder()
                            .memberLocationName(null)
                            .memberFieldInfo(
                                    SdkField.<Tag> builder(MarshallingType.SDK_POJO)
                                            .constructor(Tag::builder)
                                            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD)
                                                    .locationName("member").build()).build()).build()).build();

    private static final List<SdkField<?>> SDK_FIELDS = Collections.unmodifiableList(Arrays.asList(KEY_ID_FIELD, TAGS_FIELD));

    private static final Map<String, SdkField<?>> SDK_NAME_TO_FIELD = memberNameToFieldInitializer();

    private final String keyId;

    private final List<Tag> tags;

    private TagResourceRequest(BuilderImpl builder) {
        super(builder);
        this.keyId = builder.keyId;
        this.tags = builder.tags;
    }

    /**
     * <p>
     * Identifies a customer managed key in the account and Region.
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
     * @return Identifies a customer managed key in the account and Region.</p>
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
     * For responses, this returns true if the service returned a value for the Tags property. This DOES NOT check that
     * the value is non-empty (for which, you should check the {@code isEmpty()} method on the property). This is useful
     * because the SDK will never return a null collection or map, but you may need to differentiate between the service
     * returning nothing (or null) and the service returning an empty collection or map. For requests, this returns true
     * if a value for the property was specified in the request builder, and false if a value was not specified.
     */
    public final boolean hasTags() {
        return tags != null && !(tags instanceof SdkAutoConstructList);
    }

    /**
     * <p>
     * One or more tags. Each tag consists of a tag key and a tag value. The tag value can be an empty (null) string.
     * </p>
     * <important>
     * <p>
     * Do not include confidential or sensitive information in this field. This field may be displayed in plaintext in
     * CloudTrail logs and other output.
     * </p>
     * </important>
     * <p>
     * You cannot have more than one tag on a KMS key with the same tag key. If you specify an existing tag key with a
     * different tag value, KMS replaces the current tag value with the specified one.
     * </p>
     * <p>
     * Attempts to modify the collection returned by this method will result in an UnsupportedOperationException.
     * </p>
     * <p>
     * This method will never return null. If you would like to know whether the service returned this field (so that
     * you can differentiate between null and empty), you can use the {@link #hasTags} method.
     * </p>
     * 
     * @return One or more tags. Each tag consists of a tag key and a tag value. The tag value can be an empty (null)
     *         string. </p> <important>
     *         <p>
     *         Do not include confidential or sensitive information in this field. This field may be displayed in
     *         plaintext in CloudTrail logs and other output.
     *         </p>
     *         </important>
     *         <p>
     *         You cannot have more than one tag on a KMS key with the same tag key. If you specify an existing tag key
     *         with a different tag value, KMS replaces the current tag value with the specified one.
     */
    public final List<Tag> tags() {
        return tags;
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
        hashCode = 31 * hashCode + Objects.hashCode(hasTags() ? tags() : null);
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
        if (!(obj instanceof TagResourceRequest)) {
            return false;
        }
        TagResourceRequest other = (TagResourceRequest) obj;
        return Objects.equals(keyId(), other.keyId()) && hasTags() == other.hasTags() && Objects.equals(tags(), other.tags());
    }

    /**
     * Returns a string representation of this object. This is useful for testing and debugging. Sensitive data will be
     * redacted from this string using a placeholder value.
     */
    @Override
    public final String toString() {
        return ToString.builder("TagResourceRequest").add("KeyId", keyId()).add("Tags", hasTags() ? tags() : null).build();
    }

    public final <T> Optional<T> getValueForField(String fieldName, Class<T> clazz) {
        switch (fieldName) {
        case "KeyId":
            return Optional.ofNullable(clazz.cast(keyId()));
        case "Tags":
            return Optional.ofNullable(clazz.cast(tags()));
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
        map.put("Tags", TAGS_FIELD);
        return Collections.unmodifiableMap(map);
    }

    private static <T> Function<Object, T> getter(Function<TagResourceRequest, T> g) {
        return obj -> g.apply((TagResourceRequest) obj);
    }

    private static <T> BiConsumer<Object, T> setter(BiConsumer<Builder, T> s) {
        return (obj, val) -> s.accept((Builder) obj, val);
    }

    @Mutable
    @NotThreadSafe
    public interface Builder extends KmsRequest.Builder, SdkPojo, CopyableBuilder<Builder, TagResourceRequest> {
        /**
         * <p>
         * Identifies a customer managed key in the account and Region.
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
         *        Identifies a customer managed key in the account and Region.</p>
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
         * One or more tags. Each tag consists of a tag key and a tag value. The tag value can be an empty (null)
         * string.
         * </p>
         * <important>
         * <p>
         * Do not include confidential or sensitive information in this field. This field may be displayed in plaintext
         * in CloudTrail logs and other output.
         * </p>
         * </important>
         * <p>
         * You cannot have more than one tag on a KMS key with the same tag key. If you specify an existing tag key with
         * a different tag value, KMS replaces the current tag value with the specified one.
         * </p>
         * 
         * @param tags
         *        One or more tags. Each tag consists of a tag key and a tag value. The tag value can be an empty (null)
         *        string. </p> <important>
         *        <p>
         *        Do not include confidential or sensitive information in this field. This field may be displayed in
         *        plaintext in CloudTrail logs and other output.
         *        </p>
         *        </important>
         *        <p>
         *        You cannot have more than one tag on a KMS key with the same tag key. If you specify an existing tag
         *        key with a different tag value, KMS replaces the current tag value with the specified one.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder tags(Collection<Tag> tags);

        /**
         * <p>
         * One or more tags. Each tag consists of a tag key and a tag value. The tag value can be an empty (null)
         * string.
         * </p>
         * <important>
         * <p>
         * Do not include confidential or sensitive information in this field. This field may be displayed in plaintext
         * in CloudTrail logs and other output.
         * </p>
         * </important>
         * <p>
         * You cannot have more than one tag on a KMS key with the same tag key. If you specify an existing tag key with
         * a different tag value, KMS replaces the current tag value with the specified one.
         * </p>
         * 
         * @param tags
         *        One or more tags. Each tag consists of a tag key and a tag value. The tag value can be an empty (null)
         *        string. </p> <important>
         *        <p>
         *        Do not include confidential or sensitive information in this field. This field may be displayed in
         *        plaintext in CloudTrail logs and other output.
         *        </p>
         *        </important>
         *        <p>
         *        You cannot have more than one tag on a KMS key with the same tag key. If you specify an existing tag
         *        key with a different tag value, KMS replaces the current tag value with the specified one.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder tags(Tag... tags);

        /**
         * <p>
         * One or more tags. Each tag consists of a tag key and a tag value. The tag value can be an empty (null)
         * string.
         * </p>
         * <important>
         * <p>
         * Do not include confidential or sensitive information in this field. This field may be displayed in plaintext
         * in CloudTrail logs and other output.
         * </p>
         * </important>
         * <p>
         * You cannot have more than one tag on a KMS key with the same tag key. If you specify an existing tag key with
         * a different tag value, KMS replaces the current tag value with the specified one.
         * </p>
         * This is a convenience method that creates an instance of the
         * {@link com.ibm.cos.v2.services.kms.model.Tag.Builder} avoiding the need to create one manually via
         * {@link com.ibm.cos.v2.services.kms.model.Tag#builder()}.
         *
         * <p>
         * When the {@link Consumer} completes, {@link com.ibm.cos.v2.services.kms.model.Tag.Builder#build()} is
         * called immediately and its result is passed to {@link #tags(List<Tag>)}.
         * 
         * @param tags
         *        a consumer that will call methods on {@link com.ibm.cos.v2.services.kms.model.Tag.Builder}
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see #tags(java.util.Collection<Tag>)
         */
        Builder tags(Consumer<Tag.Builder>... tags);

        @Override
        Builder overrideConfiguration(AwsRequestOverrideConfiguration overrideConfiguration);

        @Override
        Builder overrideConfiguration(Consumer<AwsRequestOverrideConfiguration.Builder> builderConsumer);
    }

    static final class BuilderImpl extends KmsRequest.BuilderImpl implements Builder {
        private String keyId;

        private List<Tag> tags = DefaultSdkAutoConstructList.getInstance();

        private BuilderImpl() {
        }

        private BuilderImpl(TagResourceRequest model) {
            super(model);
            keyId(model.keyId);
            tags(model.tags);
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

        public final List<Tag.Builder> getTags() {
            List<Tag.Builder> result = TagListCopier.copyToBuilder(this.tags);
            if (result instanceof SdkAutoConstructList) {
                return null;
            }
            return result;
        }

        public final void setTags(Collection<Tag.BuilderImpl> tags) {
            this.tags = TagListCopier.copyFromBuilder(tags);
        }

        @Override
        public final Builder tags(Collection<Tag> tags) {
            this.tags = TagListCopier.copy(tags);
            return this;
        }

        @Override
        @SafeVarargs
        public final Builder tags(Tag... tags) {
            tags(Arrays.asList(tags));
            return this;
        }

        @Override
        @SafeVarargs
        public final Builder tags(Consumer<Tag.Builder>... tags) {
            tags(Stream.of(tags).map(c -> Tag.builder().applyMutation(c).build()).collect(Collectors.toList()));
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
        public TagResourceRequest build() {
            return new TagResourceRequest(this);
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
