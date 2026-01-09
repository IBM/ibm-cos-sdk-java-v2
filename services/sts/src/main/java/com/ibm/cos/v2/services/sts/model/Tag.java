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

package com.ibm.cos.v2.services.sts.model;

import java.io.Serializable;
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
 * You can pass custom key-value pair attributes when you assume a role or federate a user. These are called session
 * tags. You can then use the session tags to control access to resources. For more information, see <a
 * href="https://docs.aws.amazon.com/IAM/latest/UserGuide/id_session-tags.html">Tagging Amazon Web Services STS
 * Sessions</a> in the <i>IAM User Guide</i>.
 * </p>
 */
@Generated("com.ibm.cos.v2:codegen")
public final class Tag implements SdkPojo, Serializable, ToCopyableBuilder<Tag.Builder, Tag> {
    private static final SdkField<String> KEY_FIELD = SdkField.<String> builder(MarshallingType.STRING).memberName("Key")
                                                              .getter(getter(Tag::key)).setter(setter(Builder::key))
                                                              .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("Key").build()).build();

    private static final SdkField<String> VALUE_FIELD = SdkField.<String> builder(MarshallingType.STRING).memberName("Value")
                                                                .getter(getter(Tag::value)).setter(setter(Builder::value))
                                                                .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("Value").build()).build();

    private static final List<SdkField<?>> SDK_FIELDS = Collections.unmodifiableList(Arrays.asList(KEY_FIELD, VALUE_FIELD));

    private static final Map<String, SdkField<?>> SDK_NAME_TO_FIELD = memberNameToFieldInitializer();

    private static final long serialVersionUID = 1L;

    private final String key;

    private final String value;

    private Tag(BuilderImpl builder) {
        this.key = builder.key;
        this.value = builder.value;
    }

    /**
     * <p>
     * The key for a session tag.
     * </p>
     * <p>
     * You can pass up to 50 session tags. The plain text session tag keys can’t exceed 128 characters. For these and
     * additional limits, see <a href=
     * "https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_iam-limits.html#reference_iam-limits-entity-length"
     * >IAM and STS Character Limits</a> in the <i>IAM User Guide</i>.
     * </p>
     *
     * @return The key for a session tag.</p>
     *         <p>
     *         You can pass up to 50 session tags. The plain text session tag keys can’t exceed 128 characters. For
     *         these and additional limits, see <a href=
     *         "https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_iam-limits.html#reference_iam-limits-entity-length"
     *         >IAM and STS Character Limits</a> in the <i>IAM User Guide</i>.
     */
    public final String key() {
        return key;
    }

    /**
     * <p>
     * The value for a session tag.
     * </p>
     * <p>
     * You can pass up to 50 session tags. The plain text session tag values can’t exceed 256 characters. For these and
     * additional limits, see <a href=
     * "https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_iam-limits.html#reference_iam-limits-entity-length"
     * >IAM and STS Character Limits</a> in the <i>IAM User Guide</i>.
     * </p>
     *
     * @return The value for a session tag.</p>
     *         <p>
     *         You can pass up to 50 session tags. The plain text session tag values can’t exceed 256 characters. For
     *         these and additional limits, see <a href=
     *         "https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_iam-limits.html#reference_iam-limits-entity-length"
     *         >IAM and STS Character Limits</a> in the <i>IAM User Guide</i>.
     */
    public final String value() {
        return value;
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
        hashCode = 31 * hashCode + Objects.hashCode(key());
        hashCode = 31 * hashCode + Objects.hashCode(value());
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
        if (!(obj instanceof Tag)) {
            return false;
        }
        Tag other = (Tag) obj;
        return Objects.equals(key(), other.key()) && Objects.equals(value(), other.value());
    }

    /**
     * Returns a string representation of this object. This is useful for testing and debugging. Sensitive data will be
     * redacted from this string using a placeholder value.
     */
    @Override
    public final String toString() {
        return ToString.builder("Tag").add("Key", key()).add("Value", value()).build();
    }

    public final <T> Optional<T> getValueForField(String fieldName, Class<T> clazz) {
        switch (fieldName) {
            case "Key":
                return Optional.ofNullable(clazz.cast(key()));
            case "Value":
                return Optional.ofNullable(clazz.cast(value()));
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
        map.put("Key", KEY_FIELD);
        map.put("Value", VALUE_FIELD);
        return Collections.unmodifiableMap(map);
    }

    private static <T> Function<Object, T> getter(Function<Tag, T> g) {
        return obj -> g.apply((Tag) obj);
    }

    private static <T> BiConsumer<Object, T> setter(BiConsumer<Builder, T> s) {
        return (obj, val) -> s.accept((Builder) obj, val);
    }

    @Mutable
    @NotThreadSafe
    public interface Builder extends SdkPojo, CopyableBuilder<Builder, Tag> {
        /**
         * <p>
         * The key for a session tag.
         * </p>
         * <p>
         * You can pass up to 50 session tags. The plain text session tag keys can’t exceed 128 characters. For these
         * and additional limits, see <a href=
         * "https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_iam-limits.html#reference_iam-limits-entity-length"
         * >IAM and STS Character Limits</a> in the <i>IAM User Guide</i>.
         * </p>
         *
         * @param key
         *        The key for a session tag.</p>
         *        <p>
         *        You can pass up to 50 session tags. The plain text session tag keys can’t exceed 128 characters. For
         *        these and additional limits, see <a href=
         *        "https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_iam-limits.html#reference_iam-limits-entity-length"
         *        >IAM and STS Character Limits</a> in the <i>IAM User Guide</i>.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder key(String key);

        /**
         * <p>
         * The value for a session tag.
         * </p>
         * <p>
         * You can pass up to 50 session tags. The plain text session tag values can’t exceed 256 characters. For these
         * and additional limits, see <a href=
         * "https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_iam-limits.html#reference_iam-limits-entity-length"
         * >IAM and STS Character Limits</a> in the <i>IAM User Guide</i>.
         * </p>
         *
         * @param value
         *        The value for a session tag.</p>
         *        <p>
         *        You can pass up to 50 session tags. The plain text session tag values can’t exceed 256 characters. For
         *        these and additional limits, see <a href=
         *        "https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_iam-limits.html#reference_iam-limits-entity-length"
         *        >IAM and STS Character Limits</a> in the <i>IAM User Guide</i>.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder value(String value);
    }

    static final class BuilderImpl implements Builder {
        private String key;

        private String value;

        private BuilderImpl() {
        }

        private BuilderImpl(Tag model) {
            key(model.key);
            value(model.value);
        }

        public final String getKey() {
            return key;
        }

        public final void setKey(String key) {
            this.key = key;
        }

        @Override
        public final Builder key(String key) {
            this.key = key;
            return this;
        }

        public final String getValue() {
            return value;
        }

        public final void setValue(String value) {
            this.value = value;
        }

        @Override
        public final Builder value(String value) {
            this.value = value;
            return this;
        }

        @Override
        public Tag build() {
            return new Tag(this);
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
