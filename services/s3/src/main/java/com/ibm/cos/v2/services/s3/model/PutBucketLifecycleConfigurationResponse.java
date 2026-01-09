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
public final class PutBucketLifecycleConfigurationResponse extends S3Response implements
        ToCopyableBuilder<PutBucketLifecycleConfigurationResponse.Builder, PutBucketLifecycleConfigurationResponse> {
    private static final SdkField<String> TRANSITION_DEFAULT_MINIMUM_OBJECT_SIZE_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("TransitionDefaultMinimumObjectSize")
            .getter(getter(PutBucketLifecycleConfigurationResponse::transitionDefaultMinimumObjectSizeAsString))
            .setter(setter(Builder::transitionDefaultMinimumObjectSize))
            .traits(LocationTrait.builder().location(MarshallLocation.HEADER)
                    .locationName("x-amz-transition-default-minimum-object-size")
                    .unmarshallLocationName("x-amz-transition-default-minimum-object-size").build()).build();

    private static final List<SdkField<?>> SDK_FIELDS = Collections.unmodifiableList(Arrays
            .asList(TRANSITION_DEFAULT_MINIMUM_OBJECT_SIZE_FIELD));

    private static final Map<String, SdkField<?>> SDK_NAME_TO_FIELD = memberNameToFieldInitializer();

    private final String transitionDefaultMinimumObjectSize;

    private PutBucketLifecycleConfigurationResponse(BuilderImpl builder) {
        super(builder);
        this.transitionDefaultMinimumObjectSize = builder.transitionDefaultMinimumObjectSize;
    }

    /**
     * <p>
     * Indicates which default minimum object size behavior is applied to the lifecycle configuration.
     * </p>
     * <note>
     * <p>
     * This parameter applies to general purpose buckets only. It is not supported for directory bucket lifecycle
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
     *         This parameter applies to general purpose buckets only. It is not supported for directory bucket
     *         lifecycle configurations.
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
     * This parameter applies to general purpose buckets only. It is not supported for directory bucket lifecycle
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
     *         This parameter applies to general purpose buckets only. It is not supported for directory bucket
     *         lifecycle configurations.
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
        if (!(obj instanceof PutBucketLifecycleConfigurationResponse)) {
            return false;
        }
        PutBucketLifecycleConfigurationResponse other = (PutBucketLifecycleConfigurationResponse) obj;
        return Objects.equals(transitionDefaultMinimumObjectSizeAsString(), other.transitionDefaultMinimumObjectSizeAsString());
    }

    /**
     * Returns a string representation of this object. This is useful for testing and debugging. Sensitive data will be
     * redacted from this string using a placeholder value.
     */
    @Override
    public final String toString() {
        return ToString.builder("PutBucketLifecycleConfigurationResponse")
                .add("TransitionDefaultMinimumObjectSize", transitionDefaultMinimumObjectSizeAsString()).build();
    }

    public final <T> Optional<T> getValueForField(String fieldName, Class<T> clazz) {
        switch (fieldName) {
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
        map.put("x-amz-transition-default-minimum-object-size", TRANSITION_DEFAULT_MINIMUM_OBJECT_SIZE_FIELD);
        return Collections.unmodifiableMap(map);
    }

    private static <T> Function<Object, T> getter(Function<PutBucketLifecycleConfigurationResponse, T> g) {
        return obj -> g.apply((PutBucketLifecycleConfigurationResponse) obj);
    }

    private static <T> BiConsumer<Object, T> setter(BiConsumer<Builder, T> s) {
        return (obj, val) -> s.accept((Builder) obj, val);
    }

    @Mutable
    @NotThreadSafe
    public interface Builder extends S3Response.Builder, SdkPojo,
            CopyableBuilder<Builder, PutBucketLifecycleConfigurationResponse> {
        /**
         * <p>
         * Indicates which default minimum object size behavior is applied to the lifecycle configuration.
         * </p>
         * <note>
         * <p>
         * This parameter applies to general purpose buckets only. It is not supported for directory bucket lifecycle
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
         *        This parameter applies to general purpose buckets only. It is not supported for directory bucket
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
         * This parameter applies to general purpose buckets only. It is not supported for directory bucket lifecycle
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
         *        This parameter applies to general purpose buckets only. It is not supported for directory bucket
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
        private String transitionDefaultMinimumObjectSize;

        private BuilderImpl() {
        }

        private BuilderImpl(PutBucketLifecycleConfigurationResponse model) {
            super(model);
            transitionDefaultMinimumObjectSize(model.transitionDefaultMinimumObjectSize);
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
        public PutBucketLifecycleConfigurationResponse build() {
            return new PutBucketLifecycleConfigurationResponse(this);
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
