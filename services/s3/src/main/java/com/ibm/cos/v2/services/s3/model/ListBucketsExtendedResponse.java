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
import com.ibm.cos.v2.core.traits.ListTrait;
import com.ibm.cos.v2.core.traits.LocationTrait;
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

public class ListBucketsExtendedResponse extends S3Response
    implements ToCopyableBuilder<ListBucketsExtendedResponse.Builder, ListBucketsExtendedResponse> {

    private static final SdkField<Boolean> IS_TRUNCATED_FIELD = SdkField
        .<Boolean>builder(MarshallingType.BOOLEAN)
        .memberName("isTruncated")
        .getter(getter(ListBucketsExtendedResponse::isTruncated))
        .setter(setter(ListBucketsExtendedResponse.Builder::isTruncated))
        .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("IsTruncated")
                             .unmarshallLocationName("IsTruncated").build()).build();

    private static final SdkField<String> MARKER_FIELD = SdkField
        .<String>builder(MarshallingType.STRING)
        .memberName("Marker")
        .getter(getter(ListBucketsExtendedResponse::marker))
        .setter(setter(ListBucketsExtendedResponse.Builder::marker))
        .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("Marker")
                             .unmarshallLocationName("Marker").build()).build();

    private static final SdkField<List<Bucket>> BUCKETS_FIELD = SdkField
        .<List<Bucket>>builder(MarshallingType.LIST)
        .memberName("Buckets")
        .getter(getter(ListBucketsExtendedResponse::buckets))
        .setter(setter(ListBucketsExtendedResponse.Builder::buckets))
        .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("Bucket")
                             .unmarshallLocationName("Buckets").build(),
                ListTrait.builder().memberLocationName("Bucket")
                    .memberFieldInfo(
                        SdkField.<Bucket> builder(MarshallingType.SDK_POJO)
                                .constructor(Bucket::builder)
                                .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD)
                                                     .locationName("Bucket").unmarshallLocationName("Bucket").build()).build())
                    .build()).build();

    private static final SdkField<Owner> OWNER_FIELD = SdkField
        .<Owner>builder(MarshallingType.SDK_POJO)
        .memberName("Owner")
        .getter(getter(ListBucketsExtendedResponse::owner))
        .setter(setter(ListBucketsExtendedResponse.Builder::owner))
        .constructor(Owner::builder)
        .traits(LocationTrait.builder()
                             .location(MarshallLocation.PAYLOAD)
                             .locationName("Owner")
                             .unmarshallLocationName("Owner")
                             .build())
        .build();


    /**
     * Constructs a new {@link ListBucketsExtendedResponse} object and
     * initializes all required and optional object fields.
     */
    public ListBucketsExtendedResponse(BuilderImpl builder) {
        super(builder);
        this.isTruncated = builder.isTruncated;
        this.marker = builder.marker;
        this.buckets = builder.buckets;
        this.owner = builder.owner;
    }

    private static <T> Function<Object, T> getter(Function<ListBucketsExtendedResponse, T> g) {
        return obj -> g.apply((ListBucketsExtendedResponse) obj);
    }

    private static <T> BiConsumer<Object, T> setter(BiConsumer<ListBucketsExtendedResponse.Builder, T> s) {
        return (obj, val) -> s.accept((ListBucketsExtendedResponse.Builder) obj, val);
    }

    public static final List<SdkField<?>> SDK_FIELDS = Collections.unmodifiableList(Arrays.asList(IS_TRUNCATED_FIELD,
                                                                                                  MARKER_FIELD, BUCKETS_FIELD, OWNER_FIELD));

    /**
     * Optional parameter indicating the maximum number of keys to include in
     * the response. COS S3 might return fewer than this, but will not return
     * more.
     */
    private final Boolean isTruncated;

    /**
     * Optional parameter indicating where to begin listing. The
     * list will only include keys that occur lexicographically after the
     * marker. This enables pagination; to get the next page of results use the
     * current value as the marker for the next request to list buckets.
     */
    private String marker ;

    /**
     * Gets the list of buckets describing the objects stored in the
     * S3 bucket. Listings for large buckets can be
     * truncated for performance reasons.  Always check the
     * {@link ListBucketsExtendedResponse#isTruncated()} method to see if the returned
     * listing is complete or if additional calls are needed to get
     * more results.
     *
     * @return A list of buckets.
     */
    private List<Bucket> buckets ;

    private final Owner owner;


    /**
     * Gets whether or not this listing is complete.
     *
     * @return The value <code>true</code> if the bucket listing is <b>not complete</b>.
     *         Returns the value <code>false</code> if otherwise.
     *         When returning <code>true</code>,
     *         additional calls to COS may be needed in order to
     *         obtain more results.
     */
    public Boolean isTruncated(){
        return isTruncated;
    }

    /**
     * Parameter indicating where in the bucket to begin listing. The
     * list will only include keys that occur lexicographically after the
     * marker. This enables pagination
     *
     * @return marker
     */
    public String marker(){
        return marker;
    }

    public List<Bucket> buckets() {
        return buckets;
    }

    public Owner owner(){
        return owner;
    }

    @Override
    public Builder toBuilder() {
        return new BuilderImpl(this);
    }

    public static Builder builder() {
        return new BuilderImpl();
    }

    @Override
    public final int hashCode() {
        int hashCode = 1;
        hashCode = 31 * hashCode + super.hashCode();
        hashCode = 31 * hashCode + Objects.hashCode(isTruncated());
        hashCode = 31 * hashCode + Objects.hashCode(buckets());
        hashCode = 31 * hashCode + Objects.hashCode(marker());
        hashCode = 31 * hashCode + Objects.hashCode(owner());
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
        if (!(obj instanceof ListBucketsExtendedResponse)) {
            return false;
        }
        ListBucketsExtendedResponse other = (ListBucketsExtendedResponse) obj;
        return Objects.equals(isTruncated(), other.isTruncated()) && Objects.equals(buckets(), other.buckets())
               && Objects.equals(marker(), other.marker()) && Objects.equals(owner(), other.owner());
    }

    /**
     * Returns a string representation of this object. This is useful for testing and debugging. Sensitive data will be
     * redacted from this string using a placeholder value.
     */
    @Override
    public final String toString() {
        return ToString.builder("ListBucketsExtendedResponse")
                       .add("isTruncated", isTruncated())
                       .add("Buckets", buckets())
                       .add("Marker", marker())
                       .add("Owner", owner()).build();
    }

    public final <T> Optional<T> getValueForField(String fieldName, Class<T> clazz) {
        switch (fieldName) {
            case "isTruncated":
                return Optional.ofNullable(clazz.cast(isTruncated()));
            case "Buckets":
                return Optional.ofNullable(clazz.cast(buckets()));
            case "Marker":
                return Optional.ofNullable(clazz.cast(marker()));
            case "Owner":
                return Optional.ofNullable(clazz.cast(owner()));
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
    public interface Builder extends S3Response.Builder, SdkPojo,
                                     CopyableBuilder<ListBucketsExtendedResponse.Builder, ListBucketsExtendedResponse> {

        /**
         * For internal use only.  Sets the truncated property for
         * this object listing, indicating if this is a complete listing or not and
         * whether the caller needs to make additional calls to S3 to get more
         * object summaries.
         *
         * @param isTruncated
         *            The value <code>true</code> if the object listing is <b>not complete</b>.
         *            The value <code>false</code> if otherwise.
         */
        Builder isTruncated(Boolean isTruncated);

        /**
         * For internal use only. Sets the bucket from the XML response.
         */
        Builder buckets(List<Bucket> buckets);

        /**
         * For internal use only. Sets the marker from the XML response.
         */
        Builder marker(String marker);

        /**
         * For internal use only. Sets the Owner from the XML response.
         */
        Builder owner(Owner owner);
    }

    static private final class BuilderImpl extends S3Response.BuilderImpl implements ListBucketsExtendedResponse.Builder {

        private Boolean isTruncated;

        private List<Bucket> buckets;

        private String marker;

        private Owner owner;

        private BuilderImpl(){};

        BuilderImpl(ListBucketsExtendedResponse model) {
            this.isTruncated = model.isTruncated;
            this.buckets = model.buckets;
            this.marker = model.marker;
            this.owner = model.owner;
        }

        @Override
        public Builder isTruncated(Boolean isTruncated) {
            this.isTruncated = isTruncated;
            return this;
        }

        @Override
        public Builder buckets(List<Bucket> buckets) {
            this.buckets = buckets;
            return this;
        }

        @Override
        public Builder marker(String marker) {
            this.marker = marker;
            return this;
        }

        @Override
        public Builder owner(Owner owner) {
            this.owner = owner;
            return this;
        }

        @Override
        public List<SdkField<?>> sdkFields() {
            return SDK_FIELDS;
        }

        @Override
        public ListBucketsExtendedResponse build() {
            Owner owner = this.owner;
            if (buckets != null && owner != null) {
                this.buckets = buckets.stream()
                                      .map(b -> b.toBuilder().owner(owner).build())
                                      .collect(java.util.stream.Collectors.toList());
            }
            return new ListBucketsExtendedResponse(this);
        }
    }
}