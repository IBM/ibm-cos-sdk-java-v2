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

import com.ibm.cos.v2.core.traits.RequiredTrait;
import com.ibm.cos.v2.http.auth.aws.internal.signer.FlexibleChecksummer;
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
public final class HeadBucketResponse extends S3Response implements
        ToCopyableBuilder<HeadBucketResponse.Builder, HeadBucketResponse> {
    private static final SdkField<String> BUCKET_LOCATION_TYPE_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("BucketLocationType")
            .getter(getter(HeadBucketResponse::bucketLocationTypeAsString))
            .setter(setter(Builder::bucketLocationType))
            .traits(LocationTrait.builder().location(MarshallLocation.HEADER).locationName("x-amz-bucket-location-type")
                    .unmarshallLocationName("x-amz-bucket-location-type").build()).build();

    private static final SdkField<String> BUCKET_LOCATION_NAME_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("BucketLocationName")
            .getter(getter(HeadBucketResponse::bucketLocationName))
            .setter(setter(Builder::bucketLocationName))
            .traits(LocationTrait.builder().location(MarshallLocation.HEADER).locationName("x-amz-bucket-location-name")
                    .unmarshallLocationName("x-amz-bucket-location-name").build()).build();

    private static final SdkField<String> BUCKET_REGION_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("BucketRegion")
            .getter(getter(HeadBucketResponse::bucketRegion))
            .setter(setter(Builder::bucketRegion))
            .traits(LocationTrait.builder().location(MarshallLocation.HEADER).locationName("x-amz-bucket-region")
                    .unmarshallLocationName("x-amz-bucket-region").build()).build();

    private static final SdkField<Boolean> ACCESS_POINT_ALIAS_FIELD = SdkField
            .<Boolean> builder(MarshallingType.BOOLEAN)
            .memberName("AccessPointAlias")
            .getter(getter(HeadBucketResponse::accessPointAlias))
            .setter(setter(Builder::accessPointAlias))
            .traits(LocationTrait.builder().location(MarshallLocation.HEADER).locationName("x-amz-access-point-alias")
                    .unmarshallLocationName("x-amz-access-point-alias").build()).build();

    /***************************************** IBM Supported fields ************************************************/
    private static final SdkField<Boolean> IBM_SSE_KP_ENABLED_FILED = SdkField
        .<Boolean> builder(MarshallingType.BOOLEAN)
        .memberName("IBMSSEKPEnabled")
        .getter(getter(HeadBucketResponse::IBMSSEKPEnabled))
        .setter(setter(Builder::IBMSSEKPEnabled))
        //.setter(setter((b, v) -> b.IBMSSEKPEnabled(v != null && v))) //using lambda instaed of primitive to handle NULL
        .traits(LocationTrait.builder().location(MarshallLocation.HEADER).locationName("ibm-sse-kp-enabled")
                             .unmarshallLocationName("ibm-sse-kp-enabled").build()).build();

    private static final SdkField<String> IBM_SSE_KP_CRK_FILED = SdkField
        .<String> builder(MarshallingType.STRING)
        .memberName("IBMSSEKPCrk")
        .getter(getter(HeadBucketResponse::IBMSSEKPCrk))
        .setter(setter(Builder::IBMSSEKPCrk))
        .traits(LocationTrait.builder().location(MarshallLocation.HEADER).locationName("ibm-sse-kp-customer-root-key-crn")
                             .unmarshallLocationName("ibm-sse-kp-customer-root-key-crn").build()).build();

    private static final List<SdkField<?>> SDK_FIELDS = Collections.unmodifiableList(Arrays.asList(BUCKET_LOCATION_TYPE_FIELD,
            BUCKET_LOCATION_NAME_FIELD, BUCKET_REGION_FIELD, ACCESS_POINT_ALIAS_FIELD,
             IBM_SSE_KP_ENABLED_FILED, IBM_SSE_KP_CRK_FILED));

    private static final Map<String, SdkField<?>> SDK_NAME_TO_FIELD = memberNameToFieldInitializer();

    private final String bucketLocationType;

    private final String bucketLocationName;

    private final String bucketRegion;

    private final Boolean accessPointAlias;

    private boolean IBMSSEKPEnabled;

    private String IBMSSEKPCrk;

    private HeadBucketResponse(BuilderImpl builder) {
        super(builder);
        this.bucketLocationType = builder.bucketLocationType;
        this.bucketLocationName = builder.bucketLocationName;
        this.bucketRegion = builder.bucketRegion;
        this.accessPointAlias = builder.accessPointAlias;
        this.IBMSSEKPEnabled = builder.IBMSSEKPEnabled != null ? builder.IBMSSEKPEnabled : false;
        this.IBMSSEKPCrk = builder.IBMSSEKPCrk;
    }

    /**
     * <p>
     * The type of location where the bucket is created.
     * </p>
     * <note>
     * <p>
     * This functionality is only supported by directory buckets.
     * </p>
     * </note>
     * <p>
     * If the service returns an enum value that is not available in the current SDK version,
     * {@link #bucketLocationType} will return {@link LocationType#UNKNOWN_TO_SDK_VERSION}. The raw value returned by
     * the service is available from {@link #bucketLocationTypeAsString}.
     * </p>
     * 
     * @return The type of location where the bucket is created.</p> <note>
     *         <p>
     *         This functionality is only supported by directory buckets.
     *         </p>
     * @see LocationType
     */
    public final LocationType bucketLocationType() {
        return LocationType.fromValue(bucketLocationType);
    }

    /**
     * <p>
     * The type of location where the bucket is created.
     * </p>
     * <note>
     * <p>
     * This functionality is only supported by directory buckets.
     * </p>
     * </note>
     * <p>
     * If the service returns an enum value that is not available in the current SDK version,
     * {@link #bucketLocationType} will return {@link LocationType#UNKNOWN_TO_SDK_VERSION}. The raw value returned by
     * the service is available from {@link #bucketLocationTypeAsString}.
     * </p>
     * 
     * @return The type of location where the bucket is created.</p> <note>
     *         <p>
     *         This functionality is only supported by directory buckets.
     *         </p>
     * @see LocationType
     */
    public final String bucketLocationTypeAsString() {
        return bucketLocationType;
    }

    /**
     * <p>
     * The name of the location where the bucket will be created.
     * </p>
     * <p>
     * For directory buckets, the Zone ID of the Availability Zone or the Local Zone where the bucket is created. An
     * example Zone ID value for an Availability Zone is <code>usw2-az1</code>.
     * </p>
     * <note>
     * <p>
     * This functionality is only supported by directory buckets.
     * </p>
     * </note>
     * 
     * @return The name of the location where the bucket will be created.</p>
     *         <p>
     *         For directory buckets, the Zone ID of the Availability Zone or the Local Zone where the bucket is
     *         created. An example Zone ID value for an Availability Zone is <code>usw2-az1</code>.
     *         </p>
     *         <note>
     *         <p>
     *         This functionality is only supported by directory buckets.
     *         </p>
     */
    public final String bucketLocationName() {
        return bucketLocationName;
    }

    /**
     * <p>
     * The Region that the bucket is located.
     * </p>
     * 
     * @return The Region that the bucket is located.
     */
    public final String bucketRegion() {
        return bucketRegion;
    }

    /**
     * <p>
     * Indicates whether the bucket name used in the request is an access point alias.
     * </p>
     * <note>
     * <p>
     * For directory buckets, the value of this field is <code>false</code>.
     * </p>
     * </note>
     * 
     * @return Indicates whether the bucket name used in the request is an access point alias.</p> <note>
     *         <p>
     *         For directory buckets, the value of this field is <code>false</code>.
     *         </p>
     */
    public final Boolean accessPointAlias() {
        return accessPointAlias;
    }

    /**
     * <p>
     * Indicates whether key protect has been enabled on bucket.
     *
     * @return Indicates whether the bucket's key protect has been enabled.</p>
     */
    public final Boolean IBMSSEKPEnabled() { return IBMSSEKPEnabled; }

    /**
     * <p>
     * Indicates the CRK header of the HEAD request
     *
     * @return the CRK header of the HEAD request.</p>
     */
    public final String IBMSSEKPCrk() { return IBMSSEKPCrk; }

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
        hashCode = 31 * hashCode + Objects.hashCode(bucketLocationTypeAsString());
        hashCode = 31 * hashCode + Objects.hashCode(bucketLocationName());
        hashCode = 31 * hashCode + Objects.hashCode(bucketRegion());
        hashCode = 31 * hashCode + Objects.hashCode(accessPointAlias());
        hashCode = 31 * hashCode + Objects.hashCode(IBMSSEKPEnabled());
        hashCode = 31 * hashCode + Objects.hashCode(IBMSSEKPCrk());
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
        if (!(obj instanceof HeadBucketResponse)) {
            return false;
        }
        HeadBucketResponse other = (HeadBucketResponse) obj;
        return Objects.equals(bucketLocationTypeAsString(), other.bucketLocationTypeAsString())
                && Objects.equals(bucketLocationName(), other.bucketLocationName())
                && Objects.equals(bucketRegion(), other.bucketRegion())
                && Objects.equals(accessPointAlias(), other.accessPointAlias())
               && Objects.equals(IBMSSEKPEnabled(), other.IBMSSEKPEnabled())
               && Objects.equals(IBMSSEKPCrk(), other.IBMSSEKPCrk());
    }

    /**
     * Returns a string representation of this object. This is useful for testing and debugging. Sensitive data will be
     * redacted from this string using a placeholder value.
     */
    @Override
    public final String toString() {
        return ToString.builder("HeadBucketResponse").add("BucketLocationType", bucketLocationTypeAsString())
                .add("BucketLocationName", bucketLocationName()).add("BucketRegion", bucketRegion())
                .add("AccessPointAlias", accessPointAlias())
                .add("IBMSSEKPEnabled", IBMSSEKPEnabled())
                .add("IBMSSEKPCrk", IBMSSEKPCrk()).build();
    }

    public final <T> Optional<T> getValueForField(String fieldName, Class<T> clazz) {
        switch (fieldName) {
        case "BucketLocationType":
            return Optional.ofNullable(clazz.cast(bucketLocationTypeAsString()));
        case "BucketLocationName":
            return Optional.ofNullable(clazz.cast(bucketLocationName()));
        case "BucketRegion":
            return Optional.ofNullable(clazz.cast(bucketRegion()));
        case "AccessPointAlias":
            return Optional.ofNullable(clazz.cast(accessPointAlias()));
        case "IBMSSEKPEnabled":
            return Optional.of(clazz.cast(IBMSSEKPEnabled()));
        case "IBMSSEKPCrk":
            return Optional.ofNullable(clazz.cast(IBMSSEKPCrk()));
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
        map.put("x-amz-bucket-location-type", BUCKET_LOCATION_TYPE_FIELD);
        map.put("x-amz-bucket-location-name", BUCKET_LOCATION_NAME_FIELD);
        map.put("x-amz-bucket-region", BUCKET_REGION_FIELD);
        map.put("x-amz-access-point-alias", ACCESS_POINT_ALIAS_FIELD);
        map.put("ibm-sse-kp-enabled", IBM_SSE_KP_ENABLED_FILED);
        map.put("ibm-sse-kp-crk-id", IBM_SSE_KP_CRK_FILED);
        return Collections.unmodifiableMap(map);
    }

    private static <T> Function<Object, T> getter(Function<HeadBucketResponse, T> g) {
        return obj -> g.apply((HeadBucketResponse) obj);
    }

    private static <T> BiConsumer<Object, T> setter(BiConsumer<Builder, T> s) {
        return (obj, val) -> s.accept((Builder) obj, val);
    }

    @Mutable
    @NotThreadSafe
    public interface Builder extends S3Response.Builder, SdkPojo, CopyableBuilder<Builder, HeadBucketResponse> {
        /**
         * <p>
         * The type of location where the bucket is created.
         * </p>
         * <note>
         * <p>
         * This functionality is only supported by directory buckets.
         * </p>
         * </note>
         * 
         * @param bucketLocationType
         *        The type of location where the bucket is created.</p> <note>
         *        <p>
         *        This functionality is only supported by directory buckets.
         *        </p>
         * @see LocationType
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see LocationType
         */
        Builder bucketLocationType(String bucketLocationType);

        /**
         * <p>
         * The type of location where the bucket is created.
         * </p>
         * <note>
         * <p>
         * This functionality is only supported by directory buckets.
         * </p>
         * </note>
         * 
         * @param bucketLocationType
         *        The type of location where the bucket is created.</p> <note>
         *        <p>
         *        This functionality is only supported by directory buckets.
         *        </p>
         * @see LocationType
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see LocationType
         */
        Builder bucketLocationType(LocationType bucketLocationType);

        /**
         * <p>
         * The name of the location where the bucket will be created.
         * </p>
         * <p>
         * For directory buckets, the Zone ID of the Availability Zone or the Local Zone where the bucket is created. An
         * example Zone ID value for an Availability Zone is <code>usw2-az1</code>.
         * </p>
         * <note>
         * <p>
         * This functionality is only supported by directory buckets.
         * </p>
         * </note>
         * 
         * @param bucketLocationName
         *        The name of the location where the bucket will be created.</p>
         *        <p>
         *        For directory buckets, the Zone ID of the Availability Zone or the Local Zone where the bucket is
         *        created. An example Zone ID value for an Availability Zone is <code>usw2-az1</code>.
         *        </p>
         *        <note>
         *        <p>
         *        This functionality is only supported by directory buckets.
         *        </p>
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder bucketLocationName(String bucketLocationName);

        /**
         * <p>
         * The Region that the bucket is located.
         * </p>
         * 
         * @param bucketRegion
         *        The Region that the bucket is located.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder bucketRegion(String bucketRegion);

        /**
         * <p>
         * Indicates whether the bucket name used in the request is an access point alias.
         * </p>
         * <note>
         * <p>
         * For directory buckets, the value of this field is <code>false</code>.
         * </p>
         * </note>
         * 
         * @param accessPointAlias
         *        Indicates whether the bucket name used in the request is an access point alias.</p> <note>
         *        <p>
         *        For directory buckets, the value of this field is <code>false</code>.
         *        </p>
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder accessPointAlias(Boolean accessPointAlias);

        /**
         * Sets if KP is enabled
         * @param IBMSSEKPEnabled
         */
        Builder IBMSSEKPEnabled (Boolean IBMSSEKPEnabled);

        /**
         * Sets the CRK value
         * @param IBMSSEKPCrk
         */
        Builder IBMSSEKPCrk (String IBMSSEKPCrk);
    }

    static final class BuilderImpl extends S3Response.BuilderImpl implements Builder {
        private String bucketLocationType;

        private String bucketLocationName;

        private String bucketRegion;

        private Boolean accessPointAlias;

        private Boolean IBMSSEKPEnabled;

        private String IBMSSEKPCrk;

        private BuilderImpl() {
        }

        private BuilderImpl(HeadBucketResponse model) {
            super(model);
            bucketLocationType(model.bucketLocationType);
            bucketLocationName(model.bucketLocationName);
            bucketRegion(model.bucketRegion);
            accessPointAlias(model.accessPointAlias);
            IBMSSEKPEnabled(model.IBMSSEKPEnabled);
            IBMSSEKPCrk(model.IBMSSEKPCrk);
        }

        public final String getBucketLocationType() {
            return bucketLocationType;
        }

        public final void setBucketLocationType(String bucketLocationType) {
            this.bucketLocationType = bucketLocationType;
        }

        public final Boolean getIBMSSEKPEnabled() {
            return IBMSSEKPEnabled;
        }

        public final String getIBMSSEKPCrk() {
            return IBMSSEKPCrk;
        }

        public final void setIBMSSEKPEnabled(Boolean IBMSSEKPEnabled) {
            this.IBMSSEKPEnabled = IBMSSEKPEnabled;
        }

        public final void setIBMSSEKPCrk(String IBMSSEKPCrk) {
             this.IBMSSEKPCrk = IBMSSEKPCrk;
        }

        @Override
        public final Builder bucketLocationType(String bucketLocationType) {
            this.bucketLocationType = bucketLocationType;
            return this;
        }

        @Override
        public final Builder bucketLocationType(LocationType bucketLocationType) {
            this.bucketLocationType(bucketLocationType == null ? null : bucketLocationType.toString());
            return this;
        }

        public final String getBucketLocationName() {
            return bucketLocationName;
        }

        public final void setBucketLocationName(String bucketLocationName) {
            this.bucketLocationName = bucketLocationName;
        }

        @Override
        public final Builder bucketLocationName(String bucketLocationName) {
            this.bucketLocationName = bucketLocationName;
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

        public final Boolean getAccessPointAlias() {
            return accessPointAlias;
        }

        public final void setAccessPointAlias(Boolean accessPointAlias) {
            this.accessPointAlias = accessPointAlias;
        }

        @Override
        public final Builder accessPointAlias(Boolean accessPointAlias) {
            this.accessPointAlias = accessPointAlias;
            return this;
        }

        @Override
        public final Builder IBMSSEKPCrk(String IBMSSEKPCrk){
            this.IBMSSEKPCrk = IBMSSEKPCrk;
            return this;
        }

        @Override
        public final Builder IBMSSEKPEnabled(Boolean IBMSSEKPEnabled){
            this.IBMSSEKPEnabled = IBMSSEKPEnabled;
            return this;
        }

        @Override
        public HeadBucketResponse build() {
            return new HeadBucketResponse(this);
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
