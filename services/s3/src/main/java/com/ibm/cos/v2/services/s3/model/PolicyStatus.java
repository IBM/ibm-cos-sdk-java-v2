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
 * The container element for a bucket's policy status.
 * </p>
 */
@Generated("com.ibm.cos.v2:codegen")
public final class PolicyStatus implements SdkPojo, Serializable, ToCopyableBuilder<PolicyStatus.Builder, PolicyStatus> {
    private static final SdkField<Boolean> IS_PUBLIC_FIELD = SdkField
            .<Boolean> builder(MarshallingType.BOOLEAN)
            .memberName("IsPublic")
            .getter(getter(PolicyStatus::isPublic))
            .setter(setter(Builder::isPublic))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("IsPublic")
                    .unmarshallLocationName("IsPublic").build()).build();

    private static final List<SdkField<?>> SDK_FIELDS = Collections.unmodifiableList(Arrays.asList(IS_PUBLIC_FIELD));

    private static final Map<String, SdkField<?>> SDK_NAME_TO_FIELD = memberNameToFieldInitializer();

    private static final long serialVersionUID = 1L;

    private final Boolean isPublic;

    private PolicyStatus(BuilderImpl builder) {
        this.isPublic = builder.isPublic;
    }

    /**
     * <p>
     * The policy status for this bucket. <code>TRUE</code> indicates that this bucket is public. <code>FALSE</code>
     * indicates that the bucket is not public.
     * </p>
     * 
     * @return The policy status for this bucket. <code>TRUE</code> indicates that this bucket is public.
     *         <code>FALSE</code> indicates that the bucket is not public.
     */
    public final Boolean isPublic() {
        return isPublic;
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
        hashCode = 31 * hashCode + Objects.hashCode(isPublic());
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
        if (!(obj instanceof PolicyStatus)) {
            return false;
        }
        PolicyStatus other = (PolicyStatus) obj;
        return Objects.equals(isPublic(), other.isPublic());
    }

    /**
     * Returns a string representation of this object. This is useful for testing and debugging. Sensitive data will be
     * redacted from this string using a placeholder value.
     */
    @Override
    public final String toString() {
        return ToString.builder("PolicyStatus").add("IsPublic", isPublic()).build();
    }

    public final <T> Optional<T> getValueForField(String fieldName, Class<T> clazz) {
        switch (fieldName) {
        case "IsPublic":
            return Optional.ofNullable(clazz.cast(isPublic()));
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
        map.put("IsPublic", IS_PUBLIC_FIELD);
        return Collections.unmodifiableMap(map);
    }

    private static <T> Function<Object, T> getter(Function<PolicyStatus, T> g) {
        return obj -> g.apply((PolicyStatus) obj);
    }

    private static <T> BiConsumer<Object, T> setter(BiConsumer<Builder, T> s) {
        return (obj, val) -> s.accept((Builder) obj, val);
    }

    @Mutable
    @NotThreadSafe
    public interface Builder extends SdkPojo, CopyableBuilder<Builder, PolicyStatus> {
        /**
         * <p>
         * The policy status for this bucket. <code>TRUE</code> indicates that this bucket is public. <code>FALSE</code>
         * indicates that the bucket is not public.
         * </p>
         * 
         * @param isPublic
         *        The policy status for this bucket. <code>TRUE</code> indicates that this bucket is public.
         *        <code>FALSE</code> indicates that the bucket is not public.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder isPublic(Boolean isPublic);
    }

    static final class BuilderImpl implements Builder {
        private Boolean isPublic;

        private BuilderImpl() {
        }

        private BuilderImpl(PolicyStatus model) {
            isPublic(model.isPublic);
        }

        public final Boolean getIsPublic() {
            return isPublic;
        }

        public final void setIsPublic(Boolean isPublic) {
            this.isPublic = isPublic;
        }

        @Override
        public final Builder isPublic(Boolean isPublic) {
            this.isPublic = isPublic;
            return this;
        }

        @Override
        public PolicyStatus build() {
            return new PolicyStatus(this);
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
