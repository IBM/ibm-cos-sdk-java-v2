/*
 * (C) Copyright 2018 IBM Corp. All Rights Reserved.
 */

package com.ibm.cos.v2.services.s3.model;

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
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.function.Function;

public final class BucketProtectionResponse extends S3Response implements
                                                         ToCopyableBuilder<BucketProtectionResponse.Builder, BucketProtectionResponse> {
    private static final SdkField<String> LOCATION_FIELD = SdkField
        .<String> builder(MarshallingType.STRING)
        .memberName("Location")
        .getter(getter(BucketProtectionResponse::location))
        .setter(setter(BucketProtectionResponse.Builder::location))
        .traits(LocationTrait.builder().location(MarshallLocation.HEADER).locationName("Location")
                             .unmarshallLocationName("Location").build()).build();

    private static final SdkField<String> STATUS_FIELD = SdkField
        .<String>builder(MarshallingType.STRING)
        .memberName("Status")
        .getter(getter(BucketProtectionResponse::status))
        .setter(setter(BucketProtectionResponse.Builder::status))
        .traits(LocationTrait.builder().locationName("Status").build())
        .build();

    private static final List<SdkField<?>> SDK_FIELDS = Collections.unmodifiableList(Arrays.asList(LOCATION_FIELD,STATUS_FIELD));

    private static final Map<String, SdkField<?>> SDK_NAME_TO_FIELD = memberNameToFieldInitializer();

    private final String location;

    private final String status;

    private BucketProtectionResponse(BuilderImpl builder) {
        super(builder);
        this.location = builder.location;
        this.status = builder.status;
    }

    /**
     * <p>
     * A forward slash followed by the name of the bucket.
     * </p>
     *
     * @return A forward slash followed by the name of the bucket.
     */
    public final String location() {
        return location;
    }

    private String status() {return status;}

    @Override
    public Builder toBuilder() {
        return new BuilderImpl(this);
    }

    public static Builder builder() {
        return new BuilderImpl();
    }

    public static Class<? extends BucketProtectionResponse.Builder> serializableBuilderClass() {
        return BucketProtectionResponse.BuilderImpl.class;
    }

    @Override
    public final int hashCode() {
        int hashCode = 1;
        hashCode = 31 * hashCode + super.hashCode();
        hashCode = 31 * hashCode + Objects.hashCode(location());
        hashCode = 31 * hashCode + Objects.hashCode(status());
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
        if (!(obj instanceof BucketProtectionResponse)) {
            return false;
        }
        BucketProtectionResponse other = (BucketProtectionResponse) obj;
        return Objects.equals(location(), other.location())
                && Objects.equals(status(), other.status());
    }

    /**
     * Returns a string representation of this object. This is useful for testing and debugging. Sensitive data will be
     * redacted from this string using a placeholder value.
     */
    @Override
    public final String toString() {
        return ToString.builder("BucketProtectionResponse")
                       .add("Location", location())
                       .add("Status", status())
                       .build();
    }

    public final <T> Optional<T> getValueForField(String fieldName, Class<T> clazz) {
        switch (fieldName) {
            case "Location":
                return Optional.ofNullable(clazz.cast(location()));
            case "Status":
                return Optional.ofNullable((clazz.cast(status())));
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
        map.put("Location", LOCATION_FIELD);
        map.put("Status", STATUS_FIELD);
        return Collections.unmodifiableMap(map);
    }

    private static <T> Function<Object, T> getter(Function<BucketProtectionResponse, T> g) {
        return obj -> g.apply((BucketProtectionResponse) obj);
    }

    private static <T> BiConsumer<Object, T> setter(BiConsumer<BucketProtectionResponse.Builder, T> s) {
        return (obj, val) -> s.accept((BucketProtectionResponse.Builder) obj, val);
    }

    @Mutable
    @NotThreadSafe
    public interface Builder extends S3Response.Builder, SdkPojo, CopyableBuilder<BucketProtectionResponse.Builder, BucketProtectionResponse> {
        /**
         * <p>
         * A forward slash followed by the name of the bucket.
         * </p>
         *
         * @param location
         *        A forward slash followed by the name of the bucket.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder location(String location);

        Builder status(String status);
    }

    static final class BuilderImpl extends S3Response.BuilderImpl implements BucketProtectionResponse.Builder {
        private String location;

        private String status;

        private BuilderImpl() {
        }

        private BuilderImpl(BucketProtectionResponse model) {
            super(model);
            location(model.location);
            status(model.status);
        }

        public final String getLocation() {
            return location;
        }

        public final void setLocation(String location) {
            this.location = location;
        }

        public final String getStatus() {
            return status;
        }

        public final void setStatus(String status) {
            this.status = status;
        }


        @Override
        public final BucketProtectionResponse.Builder location(String location) {
            this.location = location;
            return this;
        }

        @Override
        public final BucketProtectionResponse.Builder status(String status) {
            this.status = status;
            return this;
        }

        @Override
        public BucketProtectionResponse build() {
            return new BucketProtectionResponse(this);
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
