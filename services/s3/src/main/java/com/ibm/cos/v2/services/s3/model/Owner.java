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
 * Container for the owner's display name and ID.
 * </p>
 */
@Generated("com.ibm.cos.v2:codegen")
public final class Owner implements SdkPojo, Serializable, ToCopyableBuilder<Owner.Builder, Owner> {
    private static final SdkField<String> DISPLAY_NAME_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("DisplayName")
            .getter(getter(Owner::displayName))
            .setter(setter(Builder::displayName))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("DisplayName")
                    .unmarshallLocationName("DisplayName").build()).build();

    private static final SdkField<String> ID_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("ID")
            .getter(getter(Owner::id))
            .setter(setter(Builder::id))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("ID").unmarshallLocationName("ID")
                    .build()).build();

    private static final List<SdkField<?>> SDK_FIELDS = Collections.unmodifiableList(Arrays.asList(DISPLAY_NAME_FIELD, ID_FIELD));

    private static final Map<String, SdkField<?>> SDK_NAME_TO_FIELD = memberNameToFieldInitializer();

    private static final long serialVersionUID = 1L;

    private final String displayName;

    private final String id;

    private Owner(BuilderImpl builder) {
        this.displayName = builder.displayName;
        this.id = builder.id;
    }

    /**
     * <p>
     * Container for the display name of the owner. This value is only supported in the following Amazon Web Services
     * Regions:
     * </p>
     * <ul>
     * <li>
     * <p>
     * US East (N. Virginia)
     * </p>
     * </li>
     * <li>
     * <p>
     * US West (N. California)
     * </p>
     * </li>
     * <li>
     * <p>
     * US West (Oregon)
     * </p>
     * </li>
     * <li>
     * <p>
     * Asia Pacific (Singapore)
     * </p>
     * </li>
     * <li>
     * <p>
     * Asia Pacific (Sydney)
     * </p>
     * </li>
     * <li>
     * <p>
     * Asia Pacific (Tokyo)
     * </p>
     * </li>
     * <li>
     * <p>
     * Europe (Ireland)
     * </p>
     * </li>
     * <li>
     * <p>
     * South America (São Paulo)
     * </p>
     * </li>
     * </ul>
     * <note>
     * <p>
     * This functionality is not supported for directory buckets.
     * </p>
     * </note>
     * 
     * @return Container for the display name of the owner. This value is only supported in the following Amazon Web
     *         Services Regions:</p>
     *         <ul>
     *         <li>
     *         <p>
     *         US East (N. Virginia)
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         US West (N. California)
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         US West (Oregon)
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         Asia Pacific (Singapore)
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         Asia Pacific (Sydney)
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         Asia Pacific (Tokyo)
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         Europe (Ireland)
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         South America (São Paulo)
     *         </p>
     *         </li>
     *         </ul>
     *         <note>
     *         <p>
     *         This functionality is not supported for directory buckets.
     *         </p>
     */
    public final String displayName() {
        return displayName;
    }

    /**
     * <p>
     * Container for the ID of the owner.
     * </p>
     * 
     * @return Container for the ID of the owner.
     */
    public final String id() {
        return id;
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
        hashCode = 31 * hashCode + Objects.hashCode(displayName());
        hashCode = 31 * hashCode + Objects.hashCode(id());
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
        if (!(obj instanceof Owner)) {
            return false;
        }
        Owner other = (Owner) obj;
        return Objects.equals(displayName(), other.displayName()) && Objects.equals(id(), other.id());
    }

    /**
     * Returns a string representation of this object. This is useful for testing and debugging. Sensitive data will be
     * redacted from this string using a placeholder value.
     */
    @Override
    public final String toString() {
        return ToString.builder("Owner").add("DisplayName", displayName()).add("ID", id()).build();
    }

    public final <T> Optional<T> getValueForField(String fieldName, Class<T> clazz) {
        switch (fieldName) {
        case "DisplayName":
            return Optional.ofNullable(clazz.cast(displayName()));
        case "ID":
            return Optional.ofNullable(clazz.cast(id()));
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
        map.put("DisplayName", DISPLAY_NAME_FIELD);
        map.put("ID", ID_FIELD);
        return Collections.unmodifiableMap(map);
    }

    private static <T> Function<Object, T> getter(Function<Owner, T> g) {
        return obj -> g.apply((Owner) obj);
    }

    private static <T> BiConsumer<Object, T> setter(BiConsumer<Builder, T> s) {
        return (obj, val) -> s.accept((Builder) obj, val);
    }

    @Mutable
    @NotThreadSafe
    public interface Builder extends SdkPojo, CopyableBuilder<Builder, Owner> {
        /**
         * <p>
         * Container for the display name of the owner. This value is only supported in the following Amazon Web
         * Services Regions:
         * </p>
         * <ul>
         * <li>
         * <p>
         * US East (N. Virginia)
         * </p>
         * </li>
         * <li>
         * <p>
         * US West (N. California)
         * </p>
         * </li>
         * <li>
         * <p>
         * US West (Oregon)
         * </p>
         * </li>
         * <li>
         * <p>
         * Asia Pacific (Singapore)
         * </p>
         * </li>
         * <li>
         * <p>
         * Asia Pacific (Sydney)
         * </p>
         * </li>
         * <li>
         * <p>
         * Asia Pacific (Tokyo)
         * </p>
         * </li>
         * <li>
         * <p>
         * Europe (Ireland)
         * </p>
         * </li>
         * <li>
         * <p>
         * South America (São Paulo)
         * </p>
         * </li>
         * </ul>
         * <note>
         * <p>
         * This functionality is not supported for directory buckets.
         * </p>
         * </note>
         * 
         * @param displayName
         *        Container for the display name of the owner. This value is only supported in the following Amazon Web
         *        Services Regions:</p>
         *        <ul>
         *        <li>
         *        <p>
         *        US East (N. Virginia)
         *        </p>
         *        </li>
         *        <li>
         *        <p>
         *        US West (N. California)
         *        </p>
         *        </li>
         *        <li>
         *        <p>
         *        US West (Oregon)
         *        </p>
         *        </li>
         *        <li>
         *        <p>
         *        Asia Pacific (Singapore)
         *        </p>
         *        </li>
         *        <li>
         *        <p>
         *        Asia Pacific (Sydney)
         *        </p>
         *        </li>
         *        <li>
         *        <p>
         *        Asia Pacific (Tokyo)
         *        </p>
         *        </li>
         *        <li>
         *        <p>
         *        Europe (Ireland)
         *        </p>
         *        </li>
         *        <li>
         *        <p>
         *        South America (São Paulo)
         *        </p>
         *        </li>
         *        </ul>
         *        <note>
         *        <p>
         *        This functionality is not supported for directory buckets.
         *        </p>
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder displayName(String displayName);

        /**
         * <p>
         * Container for the ID of the owner.
         * </p>
         * 
         * @param id
         *        Container for the ID of the owner.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder id(String id);
    }

    static final class BuilderImpl implements Builder {
        private String displayName;

        private String id;

        private BuilderImpl() {
        }

        private BuilderImpl(Owner model) {
            displayName(model.displayName);
            id(model.id);
        }

        public final String getDisplayName() {
            return displayName;
        }

        public final void setDisplayName(String displayName) {
            this.displayName = displayName;
        }

        @Override
        public final Builder displayName(String displayName) {
            this.displayName = displayName;
            return this;
        }

        public final String getId() {
            return id;
        }

        public final void setId(String id) {
            this.id = id;
        }

        @Override
        public final Builder id(String id) {
            this.id = id;
            return this;
        }

        @Override
        public Owner build() {
            return new Owner(this);
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
