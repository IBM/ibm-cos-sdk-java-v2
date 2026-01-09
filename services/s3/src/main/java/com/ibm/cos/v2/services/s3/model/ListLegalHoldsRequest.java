/*
 * Copyright 2018 IBM Corp. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
package com.ibm.cos.v2.services.s3.model;

import com.ibm.cos.v2.annotations.Mutable;
import com.ibm.cos.v2.annotations.NotThreadSafe;
import com.ibm.cos.v2.core.SdkField;
import com.ibm.cos.v2.core.SdkPojo;
import com.ibm.cos.v2.core.protocol.MarshallLocation;
import com.ibm.cos.v2.core.protocol.MarshallingType;
import com.ibm.cos.v2.core.traits.LocationTrait;
import com.ibm.cos.v2.core.traits.RequiredTrait;
import com.ibm.cos.v2.utils.ToString;
import com.ibm.cos.v2.utils.builder.CopyableBuilder;
import com.ibm.cos.v2.utils.builder.ToCopyableBuilder;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**

 <p>
 Request object containing all the options for listing legal holds

 associated with a specific object in a Cloud Object Storage (COS) bucket.

 </p>
 <p>
 This class allows users to specify the bucket name and object key

 to filter the legal holds to be listed. It also supports specifying

 an optional WORM (Write Once Read Many) mirror destination,

 which is applicable when mirroring is enabled on the bucket.

 </p>
 <p>
 Instances of this class are immutable and can be created or

 modified using the provided {@link Builder}.

 </p>
 @see ListLegalHoldsRequest.Builder
 */
public final class ListLegalHoldsRequest extends S3Request
    implements SdkPojo, ToCopyableBuilder<ListLegalHoldsRequest.Builder, ListLegalHoldsRequest> {

    private static final SdkField<String> BUCKET_FIELD = SdkField
        .<String>builder(MarshallingType.STRING)
        .memberName("Bucket")
        .getter(getter(ListLegalHoldsRequest::bucket))
        .setter(setter(ListLegalHoldsRequest.Builder::bucket))
        .traits(LocationTrait.builder().location(MarshallLocation.PATH).locationName("Bucket")
                             .unmarshallLocationName("Bucket").build(), RequiredTrait.create()).build();

    private static final SdkField<String> KEY_FIELD = SdkField
        .<String>builder(MarshallingType.STRING)
        .memberName("Key")
        .getter(getter(ListLegalHoldsRequest::key))
        .setter(setter(ListLegalHoldsRequest.Builder::key))
        .traits(LocationTrait.builder().location(MarshallLocation.GREEDY_PATH)
                             .locationName("Key")
                             .build(), RequiredTrait.create())
        .build();

    private static final SdkField<String> WORM_MIRROR_DESTINATION_FIELD = SdkField
        .<String>builder(MarshallingType.STRING)
        .memberName("WormMirrorDestination")
        .getter(getter(ListLegalHoldsRequest::wormMirrorDestination))
        .setter(setter(ListLegalHoldsRequest.Builder::wormMirrorDestination))
        .traits(LocationTrait.builder().location(MarshallLocation.HEADER)
                             .locationName("mirror-destination")
                             .build())
        .build();


    private static final List<SdkField<?>> SDK_FIELDS = Collections.unmodifiableList(Arrays.asList(BUCKET_FIELD, KEY_FIELD,
                                                                                                   WORM_MIRROR_DESTINATION_FIELD));


    /** The name of the bucket which contains the specified object. */
    private final String bucket;

    /** The name of the specified object to perform the list against. */
    private final String key;

    /**
     * Optional parameter setting the mirror-destination on a WORM enabled bucket.
     */
    private final String wormMirrorDestination;


    private ListLegalHoldsRequest(BuilderImpl builder) {
        super(builder);
        this.bucket = builder.bucket;
        this.key = builder.key;
        this.wormMirrorDestination = builder.wormMirrorDestination;
    }

    private static <T> Function<Object, T> getter(Function<ListLegalHoldsRequest, T> g) {
        return obj -> g.apply((ListLegalHoldsRequest) obj);
    }

    private static <T> BiConsumer<Object, T> setter(BiConsumer<ListLegalHoldsRequest.Builder, T> s) {
        return (obj, val) -> s.accept((ListLegalHoldsRequest.Builder) obj, val);
    }

    @Override
    public Builder toBuilder() {
        return new BuilderImpl(this);
    }

    public static Builder builder() {
        return new BuilderImpl();
    }

    public static Class<? extends ListLegalHoldsRequest.Builder> serializableBuilderClass() {
        return ListLegalHoldsRequest.BuilderImpl.class;
    }

    @Override
    public final int hashCode() {
        int hashCode = 1;
        hashCode = 31 * hashCode + super.hashCode();
        hashCode = 31 * hashCode + Objects.hashCode(bucket());
        hashCode = 31 * hashCode + Objects.hashCode(key());
        hashCode = 31 * hashCode + Objects.hashCode(wormMirrorDestination());
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
        if (!(obj instanceof ListLegalHoldsRequest)) {
            return false;
        }
        ListLegalHoldsRequest other = (ListLegalHoldsRequest) obj;
        return Objects.equals(bucket(), other.bucket()) &&
               Objects.equals(key(), other.bucket())
               && Objects.equals(wormMirrorDestination(),other.wormMirrorDestination());
    }

    /**
     * Returns a string representation of this object. This is useful for testing and debugging. Sensitive data will be redacted
     * from this string using a placeholder value.
     */
    @Override
    public final String toString() {
        return ToString.builder("ListLegalHoldsRequest")
                       .add("Bucket", bucket())
                       .add("Key", key())
                        .add("WormMirrorDestination", wormMirrorDestination())
                       .build();

    }

    public final <T> Optional<T> getValueForField(String fieldName, Class<T> clazz) {
        switch (fieldName) {
            case "Bucket":
                return Optional.ofNullable(clazz.cast(bucket()));
            case "Key":
                return Optional.ofNullable(clazz.cast(key()));
            case "WormMirrorDestination":
                return Optional.ofNullable(clazz.cast(wormMirrorDestination()));
            default:
                return Optional.empty();
        }
    }

    @Override
    public List<SdkField<?>> sdkFields() {
        return SDK_FIELDS;
    }


    @Mutable
    @NotThreadSafe
    public interface Builder extends S3Request.Builder, SdkPojo,
                                     CopyableBuilder<ListLegalHoldsRequest.Builder, ListLegalHoldsRequest> {

        /**
         * Sets the name of the bucket which contains the specified object
         * and returns the updated {@link Builder} so that additional
         * method calls may be chained together.
         *
         * @param bucketName
         *            The name of the bucket containing the object.
         *
         * @return This {@link Builder}, enabling additional method calls
         *         to be chained together.
         */
        Builder bucket(String bucketName);

        /**
         * Sets the name of the specified object to perform the list against
         * and returns the updated {@link Builder} so that additional
         * method calls may be chained together.
         *
         * @param key
         *            The name of the object whose legal holds are being listed.
         *
         * @return This {@link Builder}, enabling additional method calls
         *         to be chained together.
         */
        Builder key(String key);

        /**
         * Sets the optional mirror-destination value for WORM (Write Once Read Many)
         * mirroring and returns the updated {@link Builder} so that additional
         * method calls may be chained together.
         *
         * @param wormMirrorDestination
         *            The optional mirror-destination value for WORM mirroring.
         *
         * @return This {@link Builder}, enabling additional method calls
         *         to be chained together.
         */
        Builder wormMirrorDestination(String wormMirrorDestination);

    }

    static private final class BuilderImpl extends S3Request.BuilderImpl
        implements ListLegalHoldsRequest.Builder {

        private String bucket;
        private String key;
        private String wormMirrorDestination;


        private BuilderImpl() {
        }

        private BuilderImpl(ListLegalHoldsRequest model) {
            super(model);
            bucket(model.bucket);
            key(model.key);
            wormMirrorDestination(model.wormMirrorDestination);
        }

        public void setBucket(String bucket) { this.bucket = bucket;}

        public String getBucket() { return bucket; }

        @Override
        public Builder bucket(String bucketName) {
            this.bucket = bucketName;
            return this;
        }

        public void setKey(String key) { this.key = key;}

        public String getKey() { return key; }

        @Override
        public Builder key(String key) {
            this.key = key;
            return this;
        }

        public void setWormMirrorDestination(String key) { this.wormMirrorDestination = wormMirrorDestination;}

        public String getWormMirrorDestination() { return wormMirrorDestination; }

        @Override
        public Builder wormMirrorDestination(String wormMirrorDestination) {
            this.wormMirrorDestination = wormMirrorDestination;
            return this;
        }


        @Override
        public List<SdkField<?>> sdkFields() {
            return SDK_FIELDS;
        }

        @Override
        public ListLegalHoldsRequest build() {
            return new ListLegalHoldsRequest(this);
        }
    }

    /**
     * Returns the name of the bucket which contains the specified object.
     *
     * @return The name of the bucket which contains the specified object.
     */
    public String bucket() {
        return bucket;
    }

    /**
     * Returns the name of the object to perform the list against.
     *
     * @return The name of the object to perform the list against.
     */
    public String key() {
        return key;
    }

    /**
     * Returns the optional mirror-destination value for WORM mirroring
     *
     * @return The optional mirror-destination value
     */
    public String wormMirrorDestination() {
        return wormMirrorDestination;
    }
}

