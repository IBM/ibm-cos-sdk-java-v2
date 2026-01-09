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
import java.util.function.Consumer;
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
 * The configuration information for the bucket.
 * </p>
 */
@Generated("com.ibm.cos.v2:codegen")
public final class CreateBucketConfiguration implements SdkPojo, Serializable,
        ToCopyableBuilder<CreateBucketConfiguration.Builder, CreateBucketConfiguration> {
    private static final SdkField<String> LOCATION_CONSTRAINT_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("LocationConstraint")
            .getter(getter(CreateBucketConfiguration::locationConstraintAsString))
            .setter(setter(Builder::locationConstraint))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("LocationConstraint")
                    .unmarshallLocationName("LocationConstraint").build()).build();

    private static final SdkField<LocationInfo> LOCATION_FIELD = SdkField
            .<LocationInfo> builder(MarshallingType.SDK_POJO)
            .memberName("Location")
            .getter(getter(CreateBucketConfiguration::location))
            .setter(setter(Builder::location))
            .constructor(LocationInfo::builder)
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("Location")
                    .unmarshallLocationName("Location").build()).build();

    private static final SdkField<BucketInfo> BUCKET_FIELD = SdkField
            .<BucketInfo> builder(MarshallingType.SDK_POJO)
            .memberName("Bucket")
            .getter(getter(CreateBucketConfiguration::bucket))
            .setter(setter(Builder::bucket))
            .constructor(BucketInfo::builder)
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("Bucket")
                    .unmarshallLocationName("Bucket").build()).build();

    private static final List<SdkField<?>> SDK_FIELDS = Collections.unmodifiableList(Arrays.asList(LOCATION_CONSTRAINT_FIELD,
            LOCATION_FIELD, BUCKET_FIELD));

    private static final Map<String, SdkField<?>> SDK_NAME_TO_FIELD = memberNameToFieldInitializer();

    private static final long serialVersionUID = 1L;

    private final String locationConstraint;

    private final LocationInfo location;

    private final BucketInfo bucket;

    private CreateBucketConfiguration(BuilderImpl builder) {
        this.locationConstraint = builder.locationConstraint;
        this.location = builder.location;
        this.bucket = builder.bucket;
    }

    /**
     * <p>
     * Specifies the Region where the bucket will be created. You might choose a Region to optimize latency, minimize
     * costs, or address regulatory requirements. For example, if you reside in Europe, you will probably find it
     * advantageous to create buckets in the Europe (Ireland) Region.
     * </p>
     * <p>
     * If you don't specify a Region, the bucket is created in the US East (N. Virginia) Region (us-east-1) by default.
     * Configurations using the value <code>EU</code> will create a bucket in <code>eu-west-1</code>.
     * </p>
     * <p>
     * For a list of the valid values for all of the Amazon Web Services Regions, see <a
     * href="https://docs.aws.amazon.com/general/latest/gr/rande.html#s3_region">Regions and Endpoints</a>.
     * </p>
     * <note>
     * <p>
     * This functionality is not supported for directory buckets.
     * </p>
     * </note>
     * <p>
     * If the service returns an enum value that is not available in the current SDK version,
     * {@link #locationConstraint} will return {@link BucketLocationConstraint#UNKNOWN_TO_SDK_VERSION}. The raw value
     * returned by the service is available from {@link #locationConstraintAsString}.
     * </p>
     * 
     * @return Specifies the Region where the bucket will be created. You might choose a Region to optimize latency,
     *         minimize costs, or address regulatory requirements. For example, if you reside in Europe, you will
     *         probably find it advantageous to create buckets in the Europe (Ireland) Region.</p>
     *         <p>
     *         If you don't specify a Region, the bucket is created in the US East (N. Virginia) Region (us-east-1) by
     *         default. Configurations using the value <code>EU</code> will create a bucket in <code>eu-west-1</code>.
     *         </p>
     *         <p>
     *         For a list of the valid values for all of the Amazon Web Services Regions, see <a
     *         href="https://docs.aws.amazon.com/general/latest/gr/rande.html#s3_region">Regions and Endpoints</a>.
     *         </p>
     *         <note>
     *         <p>
     *         This functionality is not supported for directory buckets.
     *         </p>
     * @see BucketLocationConstraint
     */
    public final BucketLocationConstraint locationConstraint() {
        return BucketLocationConstraint.fromValue(locationConstraint);
    }

    /**
     * <p>
     * Specifies the Region where the bucket will be created. You might choose a Region to optimize latency, minimize
     * costs, or address regulatory requirements. For example, if you reside in Europe, you will probably find it
     * advantageous to create buckets in the Europe (Ireland) Region.
     * </p>
     * <p>
     * If you don't specify a Region, the bucket is created in the US East (N. Virginia) Region (us-east-1) by default.
     * Configurations using the value <code>EU</code> will create a bucket in <code>eu-west-1</code>.
     * </p>
     * <p>
     * For a list of the valid values for all of the Amazon Web Services Regions, see <a
     * href="https://docs.aws.amazon.com/general/latest/gr/rande.html#s3_region">Regions and Endpoints</a>.
     * </p>
     * <note>
     * <p>
     * This functionality is not supported for directory buckets.
     * </p>
     * </note>
     * <p>
     * If the service returns an enum value that is not available in the current SDK version,
     * {@link #locationConstraint} will return {@link BucketLocationConstraint#UNKNOWN_TO_SDK_VERSION}. The raw value
     * returned by the service is available from {@link #locationConstraintAsString}.
     * </p>
     * 
     * @return Specifies the Region where the bucket will be created. You might choose a Region to optimize latency,
     *         minimize costs, or address regulatory requirements. For example, if you reside in Europe, you will
     *         probably find it advantageous to create buckets in the Europe (Ireland) Region.</p>
     *         <p>
     *         If you don't specify a Region, the bucket is created in the US East (N. Virginia) Region (us-east-1) by
     *         default. Configurations using the value <code>EU</code> will create a bucket in <code>eu-west-1</code>.
     *         </p>
     *         <p>
     *         For a list of the valid values for all of the Amazon Web Services Regions, see <a
     *         href="https://docs.aws.amazon.com/general/latest/gr/rande.html#s3_region">Regions and Endpoints</a>.
     *         </p>
     *         <note>
     *         <p>
     *         This functionality is not supported for directory buckets.
     *         </p>
     * @see BucketLocationConstraint
     */
    public final String locationConstraintAsString() {
        return locationConstraint;
    }

    /**
     * <p>
     * Specifies the location where the bucket will be created.
     * </p>
     * <p>
     * <b>Directory buckets </b> - The location type is Availability Zone or Local Zone. To use the Local Zone location
     * type, your account must be enabled for Dedicated Local Zones. Otherwise, you get an HTTP
     * <code>403 Forbidden</code> error with the error code <code>AccessDenied</code>. To learn more, see <a
     * href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/opt-in-directory-bucket-lz.html">Enable accounts for
     * Dedicated Local Zones</a> in the <i>Amazon S3 User Guide</i>.
     * </p>
     * <note>
     * <p>
     * This functionality is only supported by directory buckets.
     * </p>
     * </note>
     * 
     * @return Specifies the location where the bucket will be created.</p>
     *         <p>
     *         <b>Directory buckets </b> - The location type is Availability Zone or Local Zone. To use the Local Zone
     *         location type, your account must be enabled for Dedicated Local Zones. Otherwise, you get an HTTP
     *         <code>403 Forbidden</code> error with the error code <code>AccessDenied</code>. To learn more, see <a
     *         href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/opt-in-directory-bucket-lz.html">Enable
     *         accounts for Dedicated Local Zones</a> in the <i>Amazon S3 User Guide</i>.
     *         </p>
     *         <note>
     *         <p>
     *         This functionality is only supported by directory buckets.
     *         </p>
     */
    public final LocationInfo location() {
        return location;
    }

    /**
     * <p>
     * Specifies the information about the bucket that will be created.
     * </p>
     * <note>
     * <p>
     * This functionality is only supported by directory buckets.
     * </p>
     * </note>
     * 
     * @return Specifies the information about the bucket that will be created.</p> <note>
     *         <p>
     *         This functionality is only supported by directory buckets.
     *         </p>
     */
    public final BucketInfo bucket() {
        return bucket;
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
        hashCode = 31 * hashCode + Objects.hashCode(locationConstraintAsString());
        hashCode = 31 * hashCode + Objects.hashCode(location());
        hashCode = 31 * hashCode + Objects.hashCode(bucket());
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
        if (!(obj instanceof CreateBucketConfiguration)) {
            return false;
        }
        CreateBucketConfiguration other = (CreateBucketConfiguration) obj;
        return Objects.equals(locationConstraintAsString(), other.locationConstraintAsString())
                && Objects.equals(location(), other.location()) && Objects.equals(bucket(), other.bucket());
    }

    /**
     * Returns a string representation of this object. This is useful for testing and debugging. Sensitive data will be
     * redacted from this string using a placeholder value.
     */
    @Override
    public final String toString() {
        return ToString.builder("CreateBucketConfiguration").add("LocationConstraint", locationConstraintAsString())
                .add("Location", location()).add("Bucket", bucket()).build();
    }

    public final <T> Optional<T> getValueForField(String fieldName, Class<T> clazz) {
        switch (fieldName) {
        case "LocationConstraint":
            return Optional.ofNullable(clazz.cast(locationConstraintAsString()));
        case "Location":
            return Optional.ofNullable(clazz.cast(location()));
        case "Bucket":
            return Optional.ofNullable(clazz.cast(bucket()));
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
        map.put("LocationConstraint", LOCATION_CONSTRAINT_FIELD);
        map.put("Location", LOCATION_FIELD);
        map.put("Bucket", BUCKET_FIELD);
        return Collections.unmodifiableMap(map);
    }

    private static <T> Function<Object, T> getter(Function<CreateBucketConfiguration, T> g) {
        return obj -> g.apply((CreateBucketConfiguration) obj);
    }

    private static <T> BiConsumer<Object, T> setter(BiConsumer<Builder, T> s) {
        return (obj, val) -> s.accept((Builder) obj, val);
    }

    @Mutable
    @NotThreadSafe
    public interface Builder extends SdkPojo, CopyableBuilder<Builder, CreateBucketConfiguration> {
        /**
         * <p>
         * Specifies the Region where the bucket will be created. You might choose a Region to optimize latency,
         * minimize costs, or address regulatory requirements. For example, if you reside in Europe, you will probably
         * find it advantageous to create buckets in the Europe (Ireland) Region.
         * </p>
         * <p>
         * If you don't specify a Region, the bucket is created in the US East (N. Virginia) Region (us-east-1) by
         * default. Configurations using the value <code>EU</code> will create a bucket in <code>eu-west-1</code>.
         * </p>
         * <p>
         * For a list of the valid values for all of the Amazon Web Services Regions, see <a
         * href="https://docs.aws.amazon.com/general/latest/gr/rande.html#s3_region">Regions and Endpoints</a>.
         * </p>
         * <note>
         * <p>
         * This functionality is not supported for directory buckets.
         * </p>
         * </note>
         * 
         * @param locationConstraint
         *        Specifies the Region where the bucket will be created. You might choose a Region to optimize latency,
         *        minimize costs, or address regulatory requirements. For example, if you reside in Europe, you will
         *        probably find it advantageous to create buckets in the Europe (Ireland) Region.</p>
         *        <p>
         *        If you don't specify a Region, the bucket is created in the US East (N. Virginia) Region (us-east-1)
         *        by default. Configurations using the value <code>EU</code> will create a bucket in
         *        <code>eu-west-1</code>.
         *        </p>
         *        <p>
         *        For a list of the valid values for all of the Amazon Web Services Regions, see <a
         *        href="https://docs.aws.amazon.com/general/latest/gr/rande.html#s3_region">Regions and Endpoints</a>.
         *        </p>
         *        <note>
         *        <p>
         *        This functionality is not supported for directory buckets.
         *        </p>
         * @see BucketLocationConstraint
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see BucketLocationConstraint
         */
        Builder locationConstraint(String locationConstraint);

        /**
         * <p>
         * Specifies the Region where the bucket will be created. You might choose a Region to optimize latency,
         * minimize costs, or address regulatory requirements. For example, if you reside in Europe, you will probably
         * find it advantageous to create buckets in the Europe (Ireland) Region.
         * </p>
         * <p>
         * If you don't specify a Region, the bucket is created in the US East (N. Virginia) Region (us-east-1) by
         * default. Configurations using the value <code>EU</code> will create a bucket in <code>eu-west-1</code>.
         * </p>
         * <p>
         * For a list of the valid values for all of the Amazon Web Services Regions, see <a
         * href="https://docs.aws.amazon.com/general/latest/gr/rande.html#s3_region">Regions and Endpoints</a>.
         * </p>
         * <note>
         * <p>
         * This functionality is not supported for directory buckets.
         * </p>
         * </note>
         * 
         * @param locationConstraint
         *        Specifies the Region where the bucket will be created. You might choose a Region to optimize latency,
         *        minimize costs, or address regulatory requirements. For example, if you reside in Europe, you will
         *        probably find it advantageous to create buckets in the Europe (Ireland) Region.</p>
         *        <p>
         *        If you don't specify a Region, the bucket is created in the US East (N. Virginia) Region (us-east-1)
         *        by default. Configurations using the value <code>EU</code> will create a bucket in
         *        <code>eu-west-1</code>.
         *        </p>
         *        <p>
         *        For a list of the valid values for all of the Amazon Web Services Regions, see <a
         *        href="https://docs.aws.amazon.com/general/latest/gr/rande.html#s3_region">Regions and Endpoints</a>.
         *        </p>
         *        <note>
         *        <p>
         *        This functionality is not supported for directory buckets.
         *        </p>
         * @see BucketLocationConstraint
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see BucketLocationConstraint
         */
        Builder locationConstraint(BucketLocationConstraint locationConstraint);

        /**
         * <p>
         * Specifies the location where the bucket will be created.
         * </p>
         * <p>
         * <b>Directory buckets </b> - The location type is Availability Zone or Local Zone. To use the Local Zone
         * location type, your account must be enabled for Dedicated Local Zones. Otherwise, you get an HTTP
         * <code>403 Forbidden</code> error with the error code <code>AccessDenied</code>. To learn more, see <a
         * href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/opt-in-directory-bucket-lz.html">Enable accounts
         * for Dedicated Local Zones</a> in the <i>Amazon S3 User Guide</i>.
         * </p>
         * <note>
         * <p>
         * This functionality is only supported by directory buckets.
         * </p>
         * </note>
         * 
         * @param location
         *        Specifies the location where the bucket will be created.</p>
         *        <p>
         *        <b>Directory buckets </b> - The location type is Availability Zone or Local Zone. To use the Local
         *        Zone location type, your account must be enabled for Dedicated Local Zones. Otherwise, you get an HTTP
         *        <code>403 Forbidden</code> error with the error code <code>AccessDenied</code>. To learn more, see <a
         *        href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/opt-in-directory-bucket-lz.html">Enable
         *        accounts for Dedicated Local Zones</a> in the <i>Amazon S3 User Guide</i>.
         *        </p>
         *        <note>
         *        <p>
         *        This functionality is only supported by directory buckets.
         *        </p>
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder location(LocationInfo location);

        /**
         * <p>
         * Specifies the location where the bucket will be created.
         * </p>
         * <p>
         * <b>Directory buckets </b> - The location type is Availability Zone or Local Zone. To use the Local Zone
         * location type, your account must be enabled for Dedicated Local Zones. Otherwise, you get an HTTP
         * <code>403 Forbidden</code> error with the error code <code>AccessDenied</code>. To learn more, see <a
         * href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/opt-in-directory-bucket-lz.html">Enable accounts
         * for Dedicated Local Zones</a> in the <i>Amazon S3 User Guide</i>.
         * </p>
         * <note>
         * <p>
         * This functionality is only supported by directory buckets.
         * </p>
         * </note> This is a convenience method that creates an instance of the {@link LocationInfo.Builder} avoiding
         * the need to create one manually via {@link LocationInfo#builder()}.
         *
         * <p>
         * When the {@link Consumer} completes, {@link LocationInfo.Builder#build()} is called immediately and its
         * result is passed to {@link #location(LocationInfo)}.
         * 
         * @param location
         *        a consumer that will call methods on {@link LocationInfo.Builder}
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see #location(LocationInfo)
         */
        default Builder location(Consumer<LocationInfo.Builder> location) {
            return location(LocationInfo.builder().applyMutation(location).build());
        }

        /**
         * <p>
         * Specifies the information about the bucket that will be created.
         * </p>
         * <note>
         * <p>
         * This functionality is only supported by directory buckets.
         * </p>
         * </note>
         * 
         * @param bucket
         *        Specifies the information about the bucket that will be created.</p> <note>
         *        <p>
         *        This functionality is only supported by directory buckets.
         *        </p>
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder bucket(BucketInfo bucket);

        /**
         * <p>
         * Specifies the information about the bucket that will be created.
         * </p>
         * <note>
         * <p>
         * This functionality is only supported by directory buckets.
         * </p>
         * </note> This is a convenience method that creates an instance of the {@link BucketInfo.Builder} avoiding the
         * need to create one manually via {@link BucketInfo#builder()}.
         *
         * <p>
         * When the {@link Consumer} completes, {@link BucketInfo.Builder#build()} is called immediately and its result
         * is passed to {@link #bucket(BucketInfo)}.
         * 
         * @param bucket
         *        a consumer that will call methods on {@link BucketInfo.Builder}
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see #bucket(BucketInfo)
         */
        default Builder bucket(Consumer<BucketInfo.Builder> bucket) {
            return bucket(BucketInfo.builder().applyMutation(bucket).build());
        }
    }

    static final class BuilderImpl implements Builder {
        private String locationConstraint;

        private LocationInfo location;

        private BucketInfo bucket;

        private BuilderImpl() {
        }

        private BuilderImpl(CreateBucketConfiguration model) {
            locationConstraint(model.locationConstraint);
            location(model.location);
            bucket(model.bucket);
        }

        public final String getLocationConstraint() {
            return locationConstraint;
        }

        public final void setLocationConstraint(String locationConstraint) {
            this.locationConstraint = locationConstraint;
        }

        @Override
        public final Builder locationConstraint(String locationConstraint) {
            this.locationConstraint = locationConstraint;
            return this;
        }

        @Override
        public final Builder locationConstraint(BucketLocationConstraint locationConstraint) {
            this.locationConstraint(locationConstraint == null ? null : locationConstraint.toString());
            return this;
        }

        public final LocationInfo.Builder getLocation() {
            return location != null ? location.toBuilder() : null;
        }

        public final void setLocation(LocationInfo.BuilderImpl location) {
            this.location = location != null ? location.build() : null;
        }

        @Override
        public final Builder location(LocationInfo location) {
            this.location = location;
            return this;
        }

        public final BucketInfo.Builder getBucket() {
            return bucket != null ? bucket.toBuilder() : null;
        }

        public final void setBucket(BucketInfo.BuilderImpl bucket) {
            this.bucket = bucket != null ? bucket.build() : null;
        }

        @Override
        public final Builder bucket(BucketInfo bucket) {
            this.bucket = bucket;
            return this;
        }

        @Override
        public CreateBucketConfiguration build() {
            return new CreateBucketConfiguration(this);
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
