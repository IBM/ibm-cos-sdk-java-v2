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
 * Specifies the information about the bucket that will be created. For more information about directory buckets, see <a
 * href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/directory-buckets-overview.html">Directory buckets</a> in
 * the <i>Amazon S3 User Guide</i>.
 * </p>
 * <note>
 * <p>
 * This functionality is only supported by directory buckets.
 * </p>
 * </note>
 */
@Generated("com.ibm.cos.v2:codegen")
public final class BucketInfo implements SdkPojo, Serializable, ToCopyableBuilder<BucketInfo.Builder, BucketInfo> {
    private static final SdkField<String> DATA_REDUNDANCY_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("DataRedundancy")
            .getter(getter(BucketInfo::dataRedundancyAsString))
            .setter(setter(Builder::dataRedundancy))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("DataRedundancy")
                    .unmarshallLocationName("DataRedundancy").build()).build();

    private static final SdkField<String> TYPE_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("Type")
            .getter(getter(BucketInfo::typeAsString))
            .setter(setter(Builder::type))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("Type")
                    .unmarshallLocationName("Type").build()).build();

    private static final List<SdkField<?>> SDK_FIELDS = Collections.unmodifiableList(Arrays.asList(DATA_REDUNDANCY_FIELD,
            TYPE_FIELD));

    private static final Map<String, SdkField<?>> SDK_NAME_TO_FIELD = memberNameToFieldInitializer();

    private static final long serialVersionUID = 1L;

    private final String dataRedundancy;

    private final String type;

    private BucketInfo(BuilderImpl builder) {
        this.dataRedundancy = builder.dataRedundancy;
        this.type = builder.type;
    }

    /**
     * <p>
     * The number of Zone (Availability Zone or Local Zone) that's used for redundancy for the bucket.
     * </p>
     * <p>
     * If the service returns an enum value that is not available in the current SDK version, {@link #dataRedundancy}
     * will return {@link DataRedundancy#UNKNOWN_TO_SDK_VERSION}. The raw value returned by the service is available
     * from {@link #dataRedundancyAsString}.
     * </p>
     * 
     * @return The number of Zone (Availability Zone or Local Zone) that's used for redundancy for the bucket.
     * @see DataRedundancy
     */
    public final DataRedundancy dataRedundancy() {
        return DataRedundancy.fromValue(dataRedundancy);
    }

    /**
     * <p>
     * The number of Zone (Availability Zone or Local Zone) that's used for redundancy for the bucket.
     * </p>
     * <p>
     * If the service returns an enum value that is not available in the current SDK version, {@link #dataRedundancy}
     * will return {@link DataRedundancy#UNKNOWN_TO_SDK_VERSION}. The raw value returned by the service is available
     * from {@link #dataRedundancyAsString}.
     * </p>
     * 
     * @return The number of Zone (Availability Zone or Local Zone) that's used for redundancy for the bucket.
     * @see DataRedundancy
     */
    public final String dataRedundancyAsString() {
        return dataRedundancy;
    }

    /**
     * <p>
     * The type of bucket.
     * </p>
     * <p>
     * If the service returns an enum value that is not available in the current SDK version, {@link #type} will return
     * {@link BucketType#UNKNOWN_TO_SDK_VERSION}. The raw value returned by the service is available from
     * {@link #typeAsString}.
     * </p>
     * 
     * @return The type of bucket.
     * @see BucketType
     */
    public final BucketType type() {
        return BucketType.fromValue(type);
    }

    /**
     * <p>
     * The type of bucket.
     * </p>
     * <p>
     * If the service returns an enum value that is not available in the current SDK version, {@link #type} will return
     * {@link BucketType#UNKNOWN_TO_SDK_VERSION}. The raw value returned by the service is available from
     * {@link #typeAsString}.
     * </p>
     * 
     * @return The type of bucket.
     * @see BucketType
     */
    public final String typeAsString() {
        return type;
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
        hashCode = 31 * hashCode + Objects.hashCode(dataRedundancyAsString());
        hashCode = 31 * hashCode + Objects.hashCode(typeAsString());
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
        if (!(obj instanceof BucketInfo)) {
            return false;
        }
        BucketInfo other = (BucketInfo) obj;
        return Objects.equals(dataRedundancyAsString(), other.dataRedundancyAsString())
                && Objects.equals(typeAsString(), other.typeAsString());
    }

    /**
     * Returns a string representation of this object. This is useful for testing and debugging. Sensitive data will be
     * redacted from this string using a placeholder value.
     */
    @Override
    public final String toString() {
        return ToString.builder("BucketInfo").add("DataRedundancy", dataRedundancyAsString()).add("Type", typeAsString()).build();
    }

    public final <T> Optional<T> getValueForField(String fieldName, Class<T> clazz) {
        switch (fieldName) {
        case "DataRedundancy":
            return Optional.ofNullable(clazz.cast(dataRedundancyAsString()));
        case "Type":
            return Optional.ofNullable(clazz.cast(typeAsString()));
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
        map.put("DataRedundancy", DATA_REDUNDANCY_FIELD);
        map.put("Type", TYPE_FIELD);
        return Collections.unmodifiableMap(map);
    }

    private static <T> Function<Object, T> getter(Function<BucketInfo, T> g) {
        return obj -> g.apply((BucketInfo) obj);
    }

    private static <T> BiConsumer<Object, T> setter(BiConsumer<Builder, T> s) {
        return (obj, val) -> s.accept((Builder) obj, val);
    }

    @Mutable
    @NotThreadSafe
    public interface Builder extends SdkPojo, CopyableBuilder<Builder, BucketInfo> {
        /**
         * <p>
         * The number of Zone (Availability Zone or Local Zone) that's used for redundancy for the bucket.
         * </p>
         * 
         * @param dataRedundancy
         *        The number of Zone (Availability Zone or Local Zone) that's used for redundancy for the bucket.
         * @see DataRedundancy
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see DataRedundancy
         */
        Builder dataRedundancy(String dataRedundancy);

        /**
         * <p>
         * The number of Zone (Availability Zone or Local Zone) that's used for redundancy for the bucket.
         * </p>
         * 
         * @param dataRedundancy
         *        The number of Zone (Availability Zone or Local Zone) that's used for redundancy for the bucket.
         * @see DataRedundancy
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see DataRedundancy
         */
        Builder dataRedundancy(DataRedundancy dataRedundancy);

        /**
         * <p>
         * The type of bucket.
         * </p>
         * 
         * @param type
         *        The type of bucket.
         * @see BucketType
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see BucketType
         */
        Builder type(String type);

        /**
         * <p>
         * The type of bucket.
         * </p>
         * 
         * @param type
         *        The type of bucket.
         * @see BucketType
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see BucketType
         */
        Builder type(BucketType type);
    }

    static final class BuilderImpl implements Builder {
        private String dataRedundancy;

        private String type;

        private BuilderImpl() {
        }

        private BuilderImpl(BucketInfo model) {
            dataRedundancy(model.dataRedundancy);
            type(model.type);
        }

        public final String getDataRedundancy() {
            return dataRedundancy;
        }

        public final void setDataRedundancy(String dataRedundancy) {
            this.dataRedundancy = dataRedundancy;
        }

        @Override
        public final Builder dataRedundancy(String dataRedundancy) {
            this.dataRedundancy = dataRedundancy;
            return this;
        }

        @Override
        public final Builder dataRedundancy(DataRedundancy dataRedundancy) {
            this.dataRedundancy(dataRedundancy == null ? null : dataRedundancy.toString());
            return this;
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
        public final Builder type(BucketType type) {
            this.type(type == null ? null : type.toString());
            return this;
        }

        @Override
        public BucketInfo build() {
            return new BucketInfo(this);
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
