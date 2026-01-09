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

package com.ibm.cos.v2.services.s3.model;

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
 * Specifies the Amazon S3 object key name to filter on. An object key name is the name assigned to an object in your
 * Amazon S3 bucket. You specify whether to filter on the suffix or prefix of the object key name. A prefix is a
 * specific string of characters at the beginning of an object key name, which you can use to organize objects. For
 * example, you can start the key names of related objects with a prefix, such as <code>2023-</code> or
 * <code>engineering/</code>. Then, you can use <code>FilterRule</code> to find objects in a bucket with key names that
 * have the same prefix. A suffix is similar to a prefix, but it is at the end of the object key name instead of at the
 * beginning.
 * </p>
 */
@Generated("com.ibm.cos.v2:codegen")
public final class FilterRule implements SdkPojo, Serializable, ToCopyableBuilder<FilterRule.Builder, FilterRule> {
    private static final SdkField<String> NAME_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("Name")
            .getter(getter(FilterRule::nameAsString))
            .setter(setter(Builder::name))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("Name")
                    .unmarshallLocationName("Name").build()).build();

    private static final SdkField<String> VALUE_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("Value")
            .getter(getter(FilterRule::value))
            .setter(setter(Builder::value))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("Value")
                    .unmarshallLocationName("Value").build()).build();

    private static final List<SdkField<?>> SDK_FIELDS = Collections.unmodifiableList(Arrays.asList(NAME_FIELD, VALUE_FIELD));

    private static final Map<String, SdkField<?>> SDK_NAME_TO_FIELD = memberNameToFieldInitializer();

    private static final long serialVersionUID = 1L;

    private final String name;

    private final String value;

    private FilterRule(BuilderImpl builder) {
        this.name = builder.name;
        this.value = builder.value;
    }

    /**
     * <p>
     * The object key name prefix or suffix identifying one or more objects to which the filtering rule applies. The
     * maximum length is 1,024 characters. Overlapping prefixes and suffixes are not supported. For more information,
     * see <a href="https://docs.aws.amazon.com/AmazonS3/latest/dev/NotificationHowTo.html">Configuring Event
     * Notifications</a> in the <i>Amazon S3 User Guide</i>.
     * </p>
     * <p>
     * If the service returns an enum value that is not available in the current SDK version, {@link #name} will return
     * {@link FilterRuleName#UNKNOWN_TO_SDK_VERSION}. The raw value returned by the service is available from
     * {@link #nameAsString}.
     * </p>
     * 
     * @return The object key name prefix or suffix identifying one or more objects to which the filtering rule applies.
     *         The maximum length is 1,024 characters. Overlapping prefixes and suffixes are not supported. For more
     *         information, see <a
     *         href="https://docs.aws.amazon.com/AmazonS3/latest/dev/NotificationHowTo.html">Configuring Event
     *         Notifications</a> in the <i>Amazon S3 User Guide</i>.
     * @see FilterRuleName
     */
    public final FilterRuleName name() {
        return FilterRuleName.fromValue(name);
    }

    /**
     * <p>
     * The object key name prefix or suffix identifying one or more objects to which the filtering rule applies. The
     * maximum length is 1,024 characters. Overlapping prefixes and suffixes are not supported. For more information,
     * see <a href="https://docs.aws.amazon.com/AmazonS3/latest/dev/NotificationHowTo.html">Configuring Event
     * Notifications</a> in the <i>Amazon S3 User Guide</i>.
     * </p>
     * <p>
     * If the service returns an enum value that is not available in the current SDK version, {@link #name} will return
     * {@link FilterRuleName#UNKNOWN_TO_SDK_VERSION}. The raw value returned by the service is available from
     * {@link #nameAsString}.
     * </p>
     * 
     * @return The object key name prefix or suffix identifying one or more objects to which the filtering rule applies.
     *         The maximum length is 1,024 characters. Overlapping prefixes and suffixes are not supported. For more
     *         information, see <a
     *         href="https://docs.aws.amazon.com/AmazonS3/latest/dev/NotificationHowTo.html">Configuring Event
     *         Notifications</a> in the <i>Amazon S3 User Guide</i>.
     * @see FilterRuleName
     */
    public final String nameAsString() {
        return name;
    }

    /**
     * <p>
     * The value that the filter searches for in object key names.
     * </p>
     * 
     * @return The value that the filter searches for in object key names.
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
        hashCode = 31 * hashCode + Objects.hashCode(nameAsString());
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
        if (!(obj instanceof FilterRule)) {
            return false;
        }
        FilterRule other = (FilterRule) obj;
        return Objects.equals(nameAsString(), other.nameAsString()) && Objects.equals(value(), other.value());
    }

    /**
     * Returns a string representation of this object. This is useful for testing and debugging. Sensitive data will be
     * redacted from this string using a placeholder value.
     */
    @Override
    public final String toString() {
        return ToString.builder("FilterRule").add("Name", nameAsString()).add("Value", value()).build();
    }

    public final <T> Optional<T> getValueForField(String fieldName, Class<T> clazz) {
        switch (fieldName) {
        case "Name":
            return Optional.ofNullable(clazz.cast(nameAsString()));
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
        map.put("Name", NAME_FIELD);
        map.put("Value", VALUE_FIELD);
        return Collections.unmodifiableMap(map);
    }

    private static <T> Function<Object, T> getter(Function<FilterRule, T> g) {
        return obj -> g.apply((FilterRule) obj);
    }

    private static <T> BiConsumer<Object, T> setter(BiConsumer<Builder, T> s) {
        return (obj, val) -> s.accept((Builder) obj, val);
    }

    @Mutable
    @NotThreadSafe
    public interface Builder extends SdkPojo, CopyableBuilder<Builder, FilterRule> {
        /**
         * <p>
         * The object key name prefix or suffix identifying one or more objects to which the filtering rule applies. The
         * maximum length is 1,024 characters. Overlapping prefixes and suffixes are not supported. For more
         * information, see <a href="https://docs.aws.amazon.com/AmazonS3/latest/dev/NotificationHowTo.html">Configuring
         * Event Notifications</a> in the <i>Amazon S3 User Guide</i>.
         * </p>
         * 
         * @param name
         *        The object key name prefix or suffix identifying one or more objects to which the filtering rule
         *        applies. The maximum length is 1,024 characters. Overlapping prefixes and suffixes are not supported.
         *        For more information, see <a
         *        href="https://docs.aws.amazon.com/AmazonS3/latest/dev/NotificationHowTo.html">Configuring Event
         *        Notifications</a> in the <i>Amazon S3 User Guide</i>.
         * @see FilterRuleName
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see FilterRuleName
         */
        Builder name(String name);

        /**
         * <p>
         * The object key name prefix or suffix identifying one or more objects to which the filtering rule applies. The
         * maximum length is 1,024 characters. Overlapping prefixes and suffixes are not supported. For more
         * information, see <a href="https://docs.aws.amazon.com/AmazonS3/latest/dev/NotificationHowTo.html">Configuring
         * Event Notifications</a> in the <i>Amazon S3 User Guide</i>.
         * </p>
         * 
         * @param name
         *        The object key name prefix or suffix identifying one or more objects to which the filtering rule
         *        applies. The maximum length is 1,024 characters. Overlapping prefixes and suffixes are not supported.
         *        For more information, see <a
         *        href="https://docs.aws.amazon.com/AmazonS3/latest/dev/NotificationHowTo.html">Configuring Event
         *        Notifications</a> in the <i>Amazon S3 User Guide</i>.
         * @see FilterRuleName
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see FilterRuleName
         */
        Builder name(FilterRuleName name);

        /**
         * <p>
         * The value that the filter searches for in object key names.
         * </p>
         * 
         * @param value
         *        The value that the filter searches for in object key names.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder value(String value);
    }

    static final class BuilderImpl implements Builder {
        private String name;

        private String value;

        private BuilderImpl() {
        }

        private BuilderImpl(FilterRule model) {
            name(model.name);
            value(model.value);
        }

        public final String getName() {
            return name;
        }

        public final void setName(String name) {
            this.name = name;
        }

        @Override
        public final Builder name(String name) {
            this.name = name;
            return this;
        }

        @Override
        public final Builder name(FilterRuleName name) {
            this.name(name == null ? null : name.toString());
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
        public FilterRule build() {
            return new FilterRule(this);
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
