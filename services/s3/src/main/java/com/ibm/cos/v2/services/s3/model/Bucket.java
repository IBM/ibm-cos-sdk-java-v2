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
import java.time.Instant;
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
 * In terms of implementation, a Bucket is a resource.
 * </p>
 */
@Generated("com.ibm.cos.v2:codegen")
public final class Bucket implements SdkPojo, Serializable, ToCopyableBuilder<Bucket.Builder, Bucket> {
    private static final SdkField<String> NAME_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("Name")
            .getter(getter(Bucket::name))
            .setter(setter(Builder::name))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("Name")
                    .unmarshallLocationName("Name").build()).build();

    private static final SdkField<Instant> CREATION_DATE_FIELD = SdkField
            .<Instant> builder(MarshallingType.INSTANT)
            .memberName("CreationDate")
            .getter(getter(Bucket::creationDate))
            .setter(setter(Builder::creationDate))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("CreationDate")
                    .unmarshallLocationName("CreationDate").build()).build();

    private static final SdkField<String> BUCKET_REGION_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("BucketRegion")
            .getter(getter(Bucket::bucketRegion))
            .setter(setter(Builder::bucketRegion))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("BucketRegion")
                    .unmarshallLocationName("BucketRegion").build()).build();

    /***************************************** IBM Supported fields ************************************************/
    private static final SdkField<Owner> OWNER_FIELD = SdkField
        .<Owner>builder(MarshallingType.SDK_POJO)
        .memberName("Owner")
        .getter(getter(Bucket::owner))
        .setter(setter(Builder::owner))
        .traits(LocationTrait.builder()
                             .location(MarshallLocation.PAYLOAD)
                             .locationName("Owner")
                             .unmarshallLocationName("Owner")
                             .build())
        .constructor(Owner::builder)
        .build();

    private static final SdkField<String> LOCATION_CONSTRAINT_FIELD = SdkField
        .<String>builder(MarshallingType.STRING)
        .memberName("LocationConstraint")
        .getter(getter(Bucket::locationConstraint))
        .setter(setter(Builder::locationConstraint))
        .traits(LocationTrait.builder()
                             .location(MarshallLocation.PAYLOAD)
                             .locationName("LocationConstraint")
                             .unmarshallLocationName("LocationConstraint")
                             .build())
        .constructor(Owner::builder)
        .build();

    private static final SdkField<String> CREATION_TEMPLATE_ID_FIELD = SdkField
        .<String>builder(MarshallingType.STRING)
        .memberName("CreationTemplateId")
        .getter(getter(Bucket::creationTemplateId))
        .setter(setter(Builder::creationTemplateId))
        .traits(LocationTrait.builder()
                             .location(MarshallLocation.PAYLOAD)
                             .locationName("CreationTemplateId")
                             .unmarshallLocationName("CreationTemplateId")
                             .build())
        .constructor(Owner::builder)
        .build();

    private static final List<SdkField<?>> SDK_FIELDS = Collections.unmodifiableList(Arrays.asList(NAME_FIELD,
            CREATION_DATE_FIELD, BUCKET_REGION_FIELD, OWNER_FIELD, LOCATION_CONSTRAINT_FIELD,CREATION_TEMPLATE_ID_FIELD));

    private static final Map<String, SdkField<?>> SDK_NAME_TO_FIELD = memberNameToFieldInitializer();

    private static final long serialVersionUID = 1L;

    private final String name;

    private final Instant creationDate;

    private final String bucketRegion;

    private final Owner owner;

    private final String locationConstraint;

    private final String creationTemplateId;

    private Bucket(BuilderImpl builder) {
        this.name = builder.name;
        this.creationDate = builder.creationDate;
        this.bucketRegion = builder.bucketRegion;
        this.owner = builder.owner;
        this.locationConstraint = builder.locationConstraint;
        this.creationTemplateId = builder.creationTemplateId;
    }

    /**
     * <p>
     * The name of the bucket.
     * </p>
     * 
     * @return The name of the bucket.
     */
    public final String name() {
        return name;
    }

    /**
     * <p>
     * Date the bucket was created. This date can change when making changes to your bucket, such as editing its bucket
     * policy.
     * </p>
     * 
     * @return Date the bucket was created. This date can change when making changes to your bucket, such as editing its
     *         bucket policy.
     */
    public final Instant creationDate() {
        return creationDate;
    }

    /**
     * <p>
     * <code>BucketRegion</code> indicates the Amazon Web Services region where the bucket is located. If the request
     * contains at least one valid parameter, it is included in the response.
     * </p>
     * 
     * @return <code>BucketRegion</code> indicates the Amazon Web Services region where the bucket is located. If the
     *         request contains at least one valid parameter, it is included in the response.
     */
    public final String bucketRegion() {
        return bucketRegion;
    }

    /**
     * Gets the bucket's owner.  Returns <code>null</code>
     * if the bucket's owner is unknown.
     *
     * @return
     *  The bucket's owner, or <code>null</code> if it is unknown.
     */
    public Owner owner() { return owner; }

    /**
     * IBM
     * Returns the locationConstraint associated with the bucket
     * This will only have populated information when used in conjunction with
     * the Extended Listing support to the COS S3 GET Service API
     *
     * @return The locationConstraint on the bucket
     */
    public String locationConstraint() { return locationConstraint; }

    /**
     * IBM
     * Returns the creationTemplateId associated with the bucket.
     * IBM COS returns this field only if a template was used.
     * This will only have populated information when used in conjunction with
     * the Extended Listing support to the COS S3 GET Service API
     *
     * @return The templateId used on bucket creation
     */
    public String creationTemplateId() { return creationTemplateId; }

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
        hashCode = 31 * hashCode + Objects.hashCode(name());
        hashCode = 31 * hashCode + Objects.hashCode(creationDate());
        hashCode = 31 * hashCode + Objects.hashCode(bucketRegion());
        hashCode = 31 * hashCode + Objects.hashCode(owner());
        hashCode = 31 * hashCode + Objects.hashCode(locationConstraint());
        hashCode = 31 * hashCode + Objects.hashCode(creationTemplateId());
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
        if (!(obj instanceof Bucket)) {
            return false;
        }
        Bucket other = (Bucket) obj;
        return Objects.equals(name(), other.name()) && Objects.equals(creationDate(), other.creationDate())
                && Objects.equals(bucketRegion(), other.bucketRegion())
               && Objects.equals(owner(), other.owner()) && Objects.equals(locationConstraint(), other.locationConstraint())
               && Objects.equals((creationTemplateId()), other.creationTemplateId());
    }

    /**
     * Returns a string representation of this object. This is useful for testing and debugging. Sensitive data will be
     * redacted from this string using a placeholder value.
     */
    @Override
    public final String toString() {
        return ToString.builder("Bucket").add("Name", name()).add("CreationDate", creationDate())
                .add("BucketRegion", bucketRegion()).add("Owner", owner())
                .add("LocationConstraint", locationConstraint())
                .add("creationTemplateId", creationTemplateId()).build();
    }

    public final <T> Optional<T> getValueForField(String fieldName, Class<T> clazz) {
        switch (fieldName) {
        case "Name":
            return Optional.ofNullable(clazz.cast(name()));
        case "CreationDate":
            return Optional.ofNullable(clazz.cast(creationDate()));
        case "BucketRegion":
            return Optional.ofNullable(clazz.cast(bucketRegion()));
        case "Owner":
                return Optional.ofNullable(clazz.cast(owner()));
        case "LocationConstraint":
                return Optional.ofNullable(clazz.cast(locationConstraint()));
        case "CreationTemplateId":
                return Optional.ofNullable(clazz.cast(creationTemplateId()));
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
        map.put("CreationDate", CREATION_DATE_FIELD);
        map.put("BucketRegion", BUCKET_REGION_FIELD);
        map.put("Owner", OWNER_FIELD);
        map.put("LocationConstraint", LOCATION_CONSTRAINT_FIELD);
        map.put("CreationTemplateId", CREATION_TEMPLATE_ID_FIELD);
        return Collections.unmodifiableMap(map);
    }

    private static <T> Function<Object, T> getter(Function<Bucket, T> g) {
        return obj -> g.apply((Bucket) obj);
    }

    private static <T> BiConsumer<Object, T> setter(BiConsumer<Builder, T> s) {
        return (obj, val) -> s.accept((Builder) obj, val);
    }

    @Mutable
    @NotThreadSafe
    public interface Builder extends SdkPojo, CopyableBuilder<Builder, Bucket> {
        /**
         * <p>
         * The name of the bucket.
         * </p>
         * 
         * @param name
         *        The name of the bucket.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder name(String name);

        /**
         * <p>
         * Date the bucket was created. This date can change when making changes to your bucket, such as editing its
         * bucket policy.
         * </p>
         * 
         * @param creationDate
         *        Date the bucket was created. This date can change when making changes to your bucket, such as editing
         *        its bucket policy.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder creationDate(Instant creationDate);

        /**
         * <p>
         * <code>BucketRegion</code> indicates the Amazon Web Services region where the bucket is located. If the
         * request contains at least one valid parameter, it is included in the response.
         * </p>
         * 
         * @param bucketRegion
         *        <code>BucketRegion</code> indicates the Amazon Web Services region where the bucket is located. If the
         *        request contains at least one valid parameter, it is included in the response.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder bucketRegion(String bucketRegion);

        /**
         * For internal use only.
         * Sets the bucket's owner in Amazon S3. This should only be used internally by
         * the Amazon Web Services Java client methods that retrieve information directly from Amazon S3.
         *
         * @param owner
         *          The bucket's owner.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder owner(Owner owner);


        /** For internal use only:
         * IBM
         * set the bucket locationConstraint from the api response
         *
         * @param locationConstraint
         *          The location constraint for the bucket.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder locationConstraint(String locationConstraint);

        /** For internal use only:
         * IBM
         * set the bucket creationTemplateId from the api response
         *
         * @param creationTemplateId
         *          The templateId used on bucket creation
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder creationTemplateId(String creationTemplateId);
    }

    static final class BuilderImpl implements Builder {
        private String name;

        private Instant creationDate;

        private String bucketRegion;

        private Owner owner;

        private String locationConstraint;

        private String creationTemplateId;

        private BuilderImpl() {
        }

        private BuilderImpl(Bucket model) {
            name(model.name);
            creationDate(model.creationDate);
            bucketRegion(model.bucketRegion);
            owner(model.owner);
            locationConstraint(model.locationConstraint);
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

        public final Instant getCreationDate() {
            return creationDate;
        }

        public final void setCreationDate(Instant creationDate) {
            this.creationDate = creationDate;
        }

        @Override
        public final Builder creationDate(Instant creationDate) {
            this.creationDate = creationDate;
            return this;
        }

        public final String getBucketRegion() {
            return bucketRegion;
        }

        public final void setBucketRegion(String bucketRegion) {
            this.bucketRegion = bucketRegion;
        }

        @Override
        public final Builder bucketRegion(String bucketRegion) {
            this.bucketRegion = bucketRegion;
            return this;
        }

        public final Owner getOwner() {
            return owner;
        }

        public final void setOwner(Owner owner) {
            this.owner = owner;
        }

        @Override
        public Builder owner(Owner owner) {
            this.owner = owner;
            return this;
        }

        public final String getLcationConstraint() {
            return locationConstraint;
        }

        public final void setLocationConstraint(String locationConstraint) {
            this.locationConstraint = locationConstraint;
        }

        @Override
        public Builder locationConstraint(String locationConstraint) {
            this.locationConstraint = locationConstraint;
            return this;
        }

        public final String getCreationTemplateId() {
            return creationTemplateId;
        }

        public final void setCreationTemplateId(String creationTemplateId) {
            this.creationTemplateId = creationTemplateId;
        }

        @Override
        public Builder creationTemplateId(String locationConstraint) {
            this.locationConstraint = locationConstraint;
            return this;
        }

        @Override
        public Bucket build() {
            return new Bucket(this);
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
