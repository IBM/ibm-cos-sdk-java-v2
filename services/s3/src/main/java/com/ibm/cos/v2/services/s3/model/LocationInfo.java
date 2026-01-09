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
 * Specifies the location where the bucket will be created.
 * </p>
 * <p>
 * For directory buckets, the location type is Availability Zone or Local Zone. For more information about directory
 * buckets, see <a href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/directory-buckets-overview.html">Working
 * with directory buckets</a> in the <i>Amazon S3 User Guide</i>.
 * </p>
 * <note>
 * <p>
 * This functionality is only supported by directory buckets.
 * </p>
 * </note>
 */
@Generated("com.ibm.cos.v2:codegen")
public final class LocationInfo implements SdkPojo, Serializable, ToCopyableBuilder<LocationInfo.Builder, LocationInfo> {
    private static final SdkField<String> TYPE_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("Type")
            .getter(getter(LocationInfo::typeAsString))
            .setter(setter(Builder::type))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("Type")
                    .unmarshallLocationName("Type").build()).build();

    private static final SdkField<String> NAME_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("Name")
            .getter(getter(LocationInfo::name))
            .setter(setter(Builder::name))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("Name")
                    .unmarshallLocationName("Name").build()).build();

    private static final List<SdkField<?>> SDK_FIELDS = Collections.unmodifiableList(Arrays.asList(TYPE_FIELD, NAME_FIELD));

    private static final Map<String, SdkField<?>> SDK_NAME_TO_FIELD = memberNameToFieldInitializer();

    private static final long serialVersionUID = 1L;

    private final String type;

    private final String name;

    private LocationInfo(BuilderImpl builder) {
        this.type = builder.type;
        this.name = builder.name;
    }

    /**
     * <p>
     * The type of location where the bucket will be created.
     * </p>
     * <p>
     * If the service returns an enum value that is not available in the current SDK version, {@link #type} will return
     * {@link LocationType#UNKNOWN_TO_SDK_VERSION}. The raw value returned by the service is available from
     * {@link #typeAsString}.
     * </p>
     * 
     * @return The type of location where the bucket will be created.
     * @see LocationType
     */
    public final LocationType type() {
        return LocationType.fromValue(type);
    }

    /**
     * <p>
     * The type of location where the bucket will be created.
     * </p>
     * <p>
     * If the service returns an enum value that is not available in the current SDK version, {@link #type} will return
     * {@link LocationType#UNKNOWN_TO_SDK_VERSION}. The raw value returned by the service is available from
     * {@link #typeAsString}.
     * </p>
     * 
     * @return The type of location where the bucket will be created.
     * @see LocationType
     */
    public final String typeAsString() {
        return type;
    }

    /**
     * <p>
     * The name of the location where the bucket will be created.
     * </p>
     * <p>
     * For directory buckets, the name of the location is the Zone ID of the Availability Zone (AZ) or Local Zone (LZ)
     * where the bucket will be created. An example AZ ID value is <code>usw2-az1</code>.
     * </p>
     * 
     * @return The name of the location where the bucket will be created.</p>
     *         <p>
     *         For directory buckets, the name of the location is the Zone ID of the Availability Zone (AZ) or Local
     *         Zone (LZ) where the bucket will be created. An example AZ ID value is <code>usw2-az1</code>.
     */
    public final String name() {
        return name;
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
        hashCode = 31 * hashCode + Objects.hashCode(typeAsString());
        hashCode = 31 * hashCode + Objects.hashCode(name());
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
        if (!(obj instanceof LocationInfo)) {
            return false;
        }
        LocationInfo other = (LocationInfo) obj;
        return Objects.equals(typeAsString(), other.typeAsString()) && Objects.equals(name(), other.name());
    }

    /**
     * Returns a string representation of this object. This is useful for testing and debugging. Sensitive data will be
     * redacted from this string using a placeholder value.
     */
    @Override
    public final String toString() {
        return ToString.builder("LocationInfo").add("Type", typeAsString()).add("Name", name()).build();
    }

    public final <T> Optional<T> getValueForField(String fieldName, Class<T> clazz) {
        switch (fieldName) {
        case "Type":
            return Optional.ofNullable(clazz.cast(typeAsString()));
        case "Name":
            return Optional.ofNullable(clazz.cast(name()));
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
        map.put("Type", TYPE_FIELD);
        map.put("Name", NAME_FIELD);
        return Collections.unmodifiableMap(map);
    }

    private static <T> Function<Object, T> getter(Function<LocationInfo, T> g) {
        return obj -> g.apply((LocationInfo) obj);
    }

    private static <T> BiConsumer<Object, T> setter(BiConsumer<Builder, T> s) {
        return (obj, val) -> s.accept((Builder) obj, val);
    }

    @Mutable
    @NotThreadSafe
    public interface Builder extends SdkPojo, CopyableBuilder<Builder, LocationInfo> {
        /**
         * <p>
         * The type of location where the bucket will be created.
         * </p>
         * 
         * @param type
         *        The type of location where the bucket will be created.
         * @see LocationType
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see LocationType
         */
        Builder type(String type);

        /**
         * <p>
         * The type of location where the bucket will be created.
         * </p>
         * 
         * @param type
         *        The type of location where the bucket will be created.
         * @see LocationType
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see LocationType
         */
        Builder type(LocationType type);

        /**
         * <p>
         * The name of the location where the bucket will be created.
         * </p>
         * <p>
         * For directory buckets, the name of the location is the Zone ID of the Availability Zone (AZ) or Local Zone
         * (LZ) where the bucket will be created. An example AZ ID value is <code>usw2-az1</code>.
         * </p>
         * 
         * @param name
         *        The name of the location where the bucket will be created.</p>
         *        <p>
         *        For directory buckets, the name of the location is the Zone ID of the Availability Zone (AZ) or Local
         *        Zone (LZ) where the bucket will be created. An example AZ ID value is <code>usw2-az1</code>.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder name(String name);
    }

    static final class BuilderImpl implements Builder {
        private String type;

        private String name;

        private BuilderImpl() {
        }

        private BuilderImpl(LocationInfo model) {
            type(model.type);
            name(model.name);
        }

        public final String getType() {
            return type;
        }

        public final void setType(String type) {
            this.type = type;
        }

        @Override
        public final Builder type(String type) {
            this.type = type;
            return this;
        }

        @Override
        public final Builder type(LocationType type) {
            this.type(type == null ? null : type.toString());
            return this;
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
        public LocationInfo build() {
            return new LocationInfo(this);
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
