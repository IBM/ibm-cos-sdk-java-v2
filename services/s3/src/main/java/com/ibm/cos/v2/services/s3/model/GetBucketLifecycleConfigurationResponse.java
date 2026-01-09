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
public final class GetBucketLifecycleConfigurationResponse extends S3Response implements
        ToCopyableBuilder<GetBucketLifecycleConfigurationResponse.Builder, GetBucketLifecycleConfigurationResponse> {
    private static final SdkField<List<LifecycleRule>> RULES_FIELD = SdkField
            .<List<LifecycleRule>> builder(MarshallingType.LIST)
            .memberName("Rules")
            .getter(getter(GetBucketLifecycleConfigurationResponse::rules))
            .setter(setter(Builder::rules))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("Rule")
                    .unmarshallLocationName("Rule").build(),
                    ListTrait
                            .builder()
                            .memberLocationName(null)
                            .memberFieldInfo(
                                    SdkField.<LifecycleRule> builder(MarshallingType.SDK_POJO)
                                            .constructor(LifecycleRule::builder)
                                            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD)
                                                    .locationName("member").unmarshallLocationName("member").build()).build())
                            .isFlattened(true).build()).build();

    private static final SdkField<String> TRANSITION_DEFAULT_MINIMUM_OBJECT_SIZE_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("TransitionDefaultMinimumObjectSize")
            .getter(getter(GetBucketLifecycleConfigurationResponse::transitionDefaultMinimumObjectSizeAsString))
            .setter(setter(Builder::transitionDefaultMinimumObjectSize))
            .traits(LocationTrait.builder().location(MarshallLocation.HEADER)
                    .locationName("x-amz-transition-default-minimum-object-size")
                    .unmarshallLocationName("x-amz-transition-default-minimum-object-size").build()).build();

    private static final List<SdkField<?>> SDK_FIELDS = Collections.unmodifiableList(Arrays.asList(RULES_FIELD,
            TRANSITION_DEFAULT_MINIMUM_OBJECT_SIZE_FIELD));

    private static final Map<String, SdkField<?>> SDK_NAME_TO_FIELD = memberNameToFieldInitializer();

    private final List<LifecycleRule> rules;

    private final String transitionDefaultMinimumObjectSize;

    private GetBucketLifecycleConfigurationResponse(BuilderImpl builder) {
        super(builder);
        this.rules = builder.rules;
        this.transitionDefaultMinimumObjectSize = builder.transitionDefaultMinimumObjectSize;
    }

    /**
     * For responses, this returns true if the service returned a value for the Rules property. This DOES NOT check that
     * the value is non-empty (for which, you should check the {@code isEmpty()} method on the property). This is useful
     * because the SDK will never return a null collection or map, but you may need to differentiate between the service
     * returning nothing (or null) and the service returning an empty collection or map. For requests, this returns true
     * if a value for the property was specified in the request builder, and false if a value was not specified.
     */
    public final boolean hasRules() {
        return rules != null && !(rules instanceof SdkAutoConstructList);
    }

    /**
     * <p>
     * Container for a lifecycle rule.
     * </p>
     * <p>
     * Attempts to modify the collection returned by this method will result in an UnsupportedOperationException.
     * </p>
     * <p>
     * This method will never return null. If you would like to know whether the service returned this field (so that
     * you can differentiate between null and empty), you can use the {@link #hasRules} method.
     * </p>
     * 
     * @return Container for a lifecycle rule.
     */
    public final List<LifecycleRule> rules() {
        return rules;
    }

    /**
     * <p>
     * Indicates which default minimum object size behavior is applied to the lifecycle configuration.
     * </p>
     * <note>
     * <p>
     * This parameter applies to general purpose buckets only. It isn't supported for directory bucket lifecycle
     * configurations.
     * </p>
     * </note>
     * <ul>
     * <li>
     * <p>
     * <code>all_storage_classes_128K</code> - Objects smaller than 128 KB will not transition to any storage class by
     * default.
     * </p>
     * </li>
     * <li>
     * <p>
     * <code>varies_by_storage_class</code> - Objects smaller than 128 KB will transition to Glacier Flexible Retrieval
     * or Glacier Deep Archive storage classes. By default, all other storage classes will prevent transitions smaller
     * than 128 KB.
     * </p>
     * </li>
     * </ul>
     * <p>
     * To customize the minimum object size for any transition you can add a filter that specifies a custom
     * <code>ObjectSizeGreaterThan</code> or <code>ObjectSizeLessThan</code> in the body of your transition rule. Custom
     * filters always take precedence over the default transition behavior.
     * </p>
     * <p>
     * If the service returns an enum value that is not available in the current SDK version,
     * {@link #transitionDefaultMinimumObjectSize} will return
     * {@link TransitionDefaultMinimumObjectSize#UNKNOWN_TO_SDK_VERSION}. The raw value returned by the service is
     * available from {@link #transitionDefaultMinimumObjectSizeAsString}.
     * </p>
     * 
     * @return Indicates which default minimum object size behavior is applied to the lifecycle configuration.</p>
     *         <note>
     *         <p>
     *         This parameter applies to general purpose buckets only. It isn't supported for directory bucket lifecycle
     *         configurations.
     *         </p>
     *         </note>
     *         <ul>
     *         <li>
     *         <p>
     *         <code>all_storage_classes_128K</code> - Objects smaller than 128 KB will not transition to any storage
     *         class by default.
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         <code>varies_by_storage_class</code> - Objects smaller than 128 KB will transition to Glacier Flexible
     *         Retrieval or Glacier Deep Archive storage classes. By default, all other storage classes will prevent
     *         transitions smaller than 128 KB.
     *         </p>
     *         </li>
     *         </ul>
     *         <p>
     *         To customize the minimum object size for any transition you can add a filter that specifies a custom
     *         <code>ObjectSizeGreaterThan</code> or <code>ObjectSizeLessThan</code> in the body of your transition
     *         rule. Custom filters always take precedence over the default transition behavior.
     * @see TransitionDefaultMinimumObjectSize
     */
    public final TransitionDefaultMinimumObjectSize transitionDefaultMinimumObjectSize() {
        return TransitionDefaultMinimumObjectSize.fromValue(transitionDefaultMinimumObjectSize);
    }

    /**
     * <p>
     * Indicates which default minimum object size behavior is applied to the lifecycle configuration.
     * </p>
     * <note>
     * <p>
     * This parameter applies to general purpose buckets only. It isn't supported for directory bucket lifecycle
     * configurations.
     * </p>
     * </note>
     * <ul>
     * <li>
     * <p>
     * <code>all_storage_classes_128K</code> - Objects smaller than 128 KB will not transition to any storage class by
     * default.
     * </p>
     * </li>
     * <li>
     * <p>
     * <code>varies_by_storage_class</code> - Objects smaller than 128 KB will transition to Glacier Flexible Retrieval
     * or Glacier Deep Archive storage classes. By default, all other storage classes will prevent transitions smaller
     * than 128 KB.
     * </p>
     * </li>
     * </ul>
     * <p>
     * To customize the minimum object size for any transition you can add a filter that specifies a custom
     * <code>ObjectSizeGreaterThan</code> or <code>ObjectSizeLessThan</code> in the body of your transition rule. Custom
     * filters always take precedence over the default transition behavior.
     * </p>
     * <p>
     * If the service returns an enum value that is not available in the current SDK version,
     * {@link #transitionDefaultMinimumObjectSize} will return
     * {@link TransitionDefaultMinimumObjectSize#UNKNOWN_TO_SDK_VERSION}. The raw value returned by the service is
     * available from {@link #transitionDefaultMinimumObjectSizeAsString}.
     * </p>
     * 
     * @return Indicates which default minimum object size behavior is applied to the lifecycle configuration.</p>
     *         <note>
     *         <p>
     *         This parameter applies to general purpose buckets only. It isn't supported for directory bucket lifecycle
     *         configurations.
     *         </p>
     *         </note>
     *         <ul>
     *         <li>
     *         <p>
     *         <code>all_storage_classes_128K</code> - Objects smaller than 128 KB will not transition to any storage
     *         class by default.
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         <code>varies_by_storage_class</code> - Objects smaller than 128 KB will transition to Glacier Flexible
     *         Retrieval or Glacier Deep Archive storage classes. By default, all other storage classes will prevent
     *         transitions smaller than 128 KB.
     *         </p>
     *         </li>
     *         </ul>
     *         <p>
     *         To customize the minimum object size for any transition you can add a filter that specifies a custom
     *         <code>ObjectSizeGreaterThan</code> or <code>ObjectSizeLessThan</code> in the body of your transition
     *         rule. Custom filters always take precedence over the default transition behavior.
     * @see TransitionDefaultMinimumObjectSize
     */
    public final String transitionDefaultMinimumObjectSizeAsString() {
        return transitionDefaultMinimumObjectSize;
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
        hashCode = 31 * hashCode + Objects.hashCode(hasRules() ? rules() : null);
        hashCode = 31 * hashCode + Objects.hashCode(transitionDefaultMinimumObjectSizeAsString());
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
        if (!(obj instanceof GetBucketLifecycleConfigurationResponse)) {
            return false;
        }
        GetBucketLifecycleConfigurationResponse other = (GetBucketLifecycleConfigurationResponse) obj;
        return hasRules() == other.hasRules()
                && Objects.equals(rules(), other.rules())
                && Objects.equals(transitionDefaultMinimumObjectSizeAsString(),
                        other.transitionDefaultMinimumObjectSizeAsString());
    }

    /**
     * Returns a string representation of this object. This is useful for testing and debugging. Sensitive data will be
     * redacted from this string using a placeholder value.
     */
    @Override
    public final String toString() {
        return ToString.builder("GetBucketLifecycleConfigurationResponse").add("Rules", hasRules() ? rules() : null)
                .add("TransitionDefaultMinimumObjectSize", transitionDefaultMinimumObjectSizeAsString()).build();
    }

    public final <T> Optional<T> getValueForField(String fieldName, Class<T> clazz) {
        switch (fieldName) {
        case "Rules":
            return Optional.ofNullable(clazz.cast(rules()));
        case "TransitionDefaultMinimumObjectSize":
            return Optional.ofNullable(clazz.cast(transitionDefaultMinimumObjectSizeAsString()));
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
        map.put("Rule", RULES_FIELD);
        map.put("x-amz-transition-default-minimum-object-size", TRANSITION_DEFAULT_MINIMUM_OBJECT_SIZE_FIELD);
        return Collections.unmodifiableMap(map);
    }

    private static <T> Function<Object, T> getter(Function<GetBucketLifecycleConfigurationResponse, T> g) {
        return obj -> g.apply((GetBucketLifecycleConfigurationResponse) obj);
    }

    private static <T> BiConsumer<Object, T> setter(BiConsumer<Builder, T> s) {
        return (obj, val) -> s.accept((Builder) obj, val);
    }

    @Mutable
    @NotThreadSafe
    public interface Builder extends S3Response.Builder, SdkPojo,
            CopyableBuilder<Builder, GetBucketLifecycleConfigurationResponse> {
        /**
         * <p>
         * Container for a lifecycle rule.
         * </p>
         * 
         * @param rules
         *        Container for a lifecycle rule.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder rules(Collection<LifecycleRule> rules);

        /**
         * <p>
         * Container for a lifecycle rule.
         * </p>
         * 
         * @param rules
         *        Container for a lifecycle rule.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder rules(LifecycleRule... rules);

        /**
         * <p>
         * Container for a lifecycle rule.
         * </p>
         * This is a convenience method that creates an instance of the
         * {@link com.ibm.cos.v2.services.s3.model.LifecycleRule.Builder} avoiding the need to create one
         * manually via {@link com.ibm.cos.v2.services.s3.model.LifecycleRule#builder()}.
         *
         * <p>
         * When the {@link Consumer} completes,
         * {@link com.ibm.cos.v2.services.s3.model.LifecycleRule.Builder#build()} is called immediately and its
         * result is passed to {@link #rules(List<LifecycleRule>)}.
         * 
         * @param rules
         *        a consumer that will call methods on
         *        {@link com.ibm.cos.v2.services.s3.model.LifecycleRule.Builder}
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see #rules(java.util.Collection<LifecycleRule>)
         */
        Builder rules(Consumer<LifecycleRule.Builder>... rules);

        /**
         * <p>
         * Indicates which default minimum object size behavior is applied to the lifecycle configuration.
         * </p>
         * <note>
         * <p>
         * This parameter applies to general purpose buckets only. It isn't supported for directory bucket lifecycle
         * configurations.
         * </p>
         * </note>
         * <ul>
         * <li>
         * <p>
         * <code>all_storage_classes_128K</code> - Objects smaller than 128 KB will not transition to any storage class
         * by default.
         * </p>
         * </li>
         * <li>
         * <p>
         * <code>varies_by_storage_class</code> - Objects smaller than 128 KB will transition to Glacier Flexible
         * Retrieval or Glacier Deep Archive storage classes. By default, all other storage classes will prevent
         * transitions smaller than 128 KB.
         * </p>
         * </li>
         * </ul>
         * <p>
         * To customize the minimum object size for any transition you can add a filter that specifies a custom
         * <code>ObjectSizeGreaterThan</code> or <code>ObjectSizeLessThan</code> in the body of your transition rule.
         * Custom filters always take precedence over the default transition behavior.
         * </p>
         * 
         * @param transitionDefaultMinimumObjectSize
         *        Indicates which default minimum object size behavior is applied to the lifecycle configuration.</p>
         *        <note>
         *        <p>
         *        This parameter applies to general purpose buckets only. It isn't supported for directory bucket
         *        lifecycle configurations.
         *        </p>
         *        </note>
         *        <ul>
         *        <li>
         *        <p>
         *        <code>all_storage_classes_128K</code> - Objects smaller than 128 KB will not transition to any storage
         *        class by default.
         *        </p>
         *        </li>
         *        <li>
         *        <p>
         *        <code>varies_by_storage_class</code> - Objects smaller than 128 KB will transition to Glacier Flexible
         *        Retrieval or Glacier Deep Archive storage classes. By default, all other storage classes will prevent
         *        transitions smaller than 128 KB.
         *        </p>
         *        </li>
         *        </ul>
         *        <p>
         *        To customize the minimum object size for any transition you can add a filter that specifies a custom
         *        <code>ObjectSizeGreaterThan</code> or <code>ObjectSizeLessThan</code> in the body of your transition
         *        rule. Custom filters always take precedence over the default transition behavior.
         * @see TransitionDefaultMinimumObjectSize
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see TransitionDefaultMinimumObjectSize
         */
        Builder transitionDefaultMinimumObjectSize(String transitionDefaultMinimumObjectSize);

        /**
         * <p>
         * Indicates which default minimum object size behavior is applied to the lifecycle configuration.
         * </p>
         * <note>
         * <p>
         * This parameter applies to general purpose buckets only. It isn't supported for directory bucket lifecycle
         * configurations.
         * </p>
         * </note>
         * <ul>
         * <li>
         * <p>
         * <code>all_storage_classes_128K</code> - Objects smaller than 128 KB will not transition to any storage class
         * by default.
         * </p>
         * </li>
         * <li>
         * <p>
         * <code>varies_by_storage_class</code> - Objects smaller than 128 KB will transition to Glacier Flexible
         * Retrieval or Glacier Deep Archive storage classes. By default, all other storage classes will prevent
         * transitions smaller than 128 KB.
         * </p>
         * </li>
         * </ul>
         * <p>
         * To customize the minimum object size for any transition you can add a filter that specifies a custom
         * <code>ObjectSizeGreaterThan</code> or <code>ObjectSizeLessThan</code> in the body of your transition rule.
         * Custom filters always take precedence over the default transition behavior.
         * </p>
         * 
         * @param transitionDefaultMinimumObjectSize
         *        Indicates which default minimum object size behavior is applied to the lifecycle configuration.</p>
         *        <note>
         *        <p>
         *        This parameter applies to general purpose buckets only. It isn't supported for directory bucket
         *        lifecycle configurations.
         *        </p>
         *        </note>
         *        <ul>
         *        <li>
         *        <p>
         *        <code>all_storage_classes_128K</code> - Objects smaller than 128 KB will not transition to any storage
         *        class by default.
         *        </p>
         *        </li>
         *        <li>
         *        <p>
         *        <code>varies_by_storage_class</code> - Objects smaller than 128 KB will transition to Glacier Flexible
         *        Retrieval or Glacier Deep Archive storage classes. By default, all other storage classes will prevent
         *        transitions smaller than 128 KB.
         *        </p>
         *        </li>
         *        </ul>
         *        <p>
         *        To customize the minimum object size for any transition you can add a filter that specifies a custom
         *        <code>ObjectSizeGreaterThan</code> or <code>ObjectSizeLessThan</code> in the body of your transition
         *        rule. Custom filters always take precedence over the default transition behavior.
         * @see TransitionDefaultMinimumObjectSize
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see TransitionDefaultMinimumObjectSize
         */
        Builder transitionDefaultMinimumObjectSize(TransitionDefaultMinimumObjectSize transitionDefaultMinimumObjectSize);
    }

    static final class BuilderImpl extends S3Response.BuilderImpl implements Builder {
        private List<LifecycleRule> rules = DefaultSdkAutoConstructList.getInstance();

        private String transitionDefaultMinimumObjectSize;

        private BuilderImpl() {
        }

        private BuilderImpl(GetBucketLifecycleConfigurationResponse model) {
            super(model);
            rules(model.rules);
            transitionDefaultMinimumObjectSize(model.transitionDefaultMinimumObjectSize);
        }

        public final List<LifecycleRule.Builder> getRules() {
            List<LifecycleRule.Builder> result = LifecycleRulesCopier.copyToBuilder(this.rules);
            if (result instanceof SdkAutoConstructList) {
                return null;
            }
            return result;
        }

        public final void setRules(Collection<LifecycleRule.BuilderImpl> rules) {
            this.rules = LifecycleRulesCopier.copyFromBuilder(rules);
        }

        @Override
        public final Builder rules(Collection<LifecycleRule> rules) {
            this.rules = LifecycleRulesCopier.copy(rules);
            return this;
        }

        @Override
        @SafeVarargs
        public final Builder rules(LifecycleRule... rules) {
            rules(Arrays.asList(rules));
            return this;
        }

        @Override
        @SafeVarargs
        public final Builder rules(Consumer<LifecycleRule.Builder>... rules) {
            rules(Stream.of(rules).map(c -> LifecycleRule.builder().applyMutation(c).build()).collect(Collectors.toList()));
            return this;
        }

        public final String getTransitionDefaultMinimumObjectSize() {
            return transitionDefaultMinimumObjectSize;
        }

        public final void setTransitionDefaultMinimumObjectSize(String transitionDefaultMinimumObjectSize) {
            this.transitionDefaultMinimumObjectSize = transitionDefaultMinimumObjectSize;
        }

        @Override
        public final Builder transitionDefaultMinimumObjectSize(String transitionDefaultMinimumObjectSize) {
            this.transitionDefaultMinimumObjectSize = transitionDefaultMinimumObjectSize;
            return this;
        }

        @Override
        public final Builder transitionDefaultMinimumObjectSize(
                TransitionDefaultMinimumObjectSize transitionDefaultMinimumObjectSize) {
            this.transitionDefaultMinimumObjectSize(transitionDefaultMinimumObjectSize == null ? null
                    : transitionDefaultMinimumObjectSize.toString());
            return this;
        }

        @Override
        public GetBucketLifecycleConfigurationResponse build() {
            return new GetBucketLifecycleConfigurationResponse(this);
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
