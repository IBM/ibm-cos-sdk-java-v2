/*
 * Copyright 2019 IBM Corp. All Rights Reserved.
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
 * Request to retrieve a listing of buckets from Cloud Object Storage.
 */
public class ListBucketsExtendedRequest extends S3Request
    implements SdkPojo, ToCopyableBuilder<ListBucketsExtendedRequest.Builder, ListBucketsExtendedRequest> {

    private static final SdkField<Integer> MAX_KEYS_FIELD = SdkField
        .<Integer>builder(MarshallingType.INTEGER)
        .memberName("MaxKeys")
        .getter(getter(ListBucketsExtendedRequest::maxKeys))
        .setter(setter(ListBucketsExtendedRequest.Builder::maxKeys))
        .traits(LocationTrait.builder().location(MarshallLocation.QUERY_PARAM).locationName("max-keys")
                             .unmarshallLocationName("max-keys").build()).build();

    private static final SdkField<String> PREFIX_FIELD = SdkField
        .<String>builder(MarshallingType.STRING)
        .memberName("Prefix")
        .getter(getter(ListBucketsExtendedRequest::prefix))
        .setter(setter(ListBucketsExtendedRequest.Builder::prefix))
        .traits(LocationTrait.builder().location(MarshallLocation.QUERY_PARAM).locationName("prefix")
                             .unmarshallLocationName("prefix").build()).build();

    private static final SdkField<String> MARKER_FIELD = SdkField
        .<String>builder(MarshallingType.STRING)
        .memberName("Marker")
        .getter(getter(ListBucketsExtendedRequest::marker))
        .setter(setter(ListBucketsExtendedRequest.Builder::marker))
        .traits(LocationTrait.builder().location(MarshallLocation.QUERY_PARAM).locationName("marker")
                             .unmarshallLocationName("marker").build()).build();

    /**
     * Constructs a new {@link ListBucketsExtendedRequest} object and
     * initializes all required and optional object fields.
     */
    public ListBucketsExtendedRequest(BuilderImpl builder) {
        super(builder);
        this.maxKeys = builder.maxKeys;
        this.prefix = builder.prefix;;
        this.marker = builder.marker;;
    }

    private static <T> Function<Object, T> getter(Function<ListBucketsExtendedRequest, T> g) {
        return obj -> g.apply((ListBucketsExtendedRequest) obj);
    }

    private static <T> BiConsumer<Object, T> setter(BiConsumer<ListBucketsExtendedRequest.Builder, T> s) {
        return (obj, val) -> s.accept((ListBucketsExtendedRequest.Builder) obj, val);
    }

    public static final List<SdkField<?>> SDK_FIELDS = Collections.unmodifiableList(Arrays.asList(MAX_KEYS_FIELD,PREFIX_FIELD,
                                                                                                  MARKER_FIELD));

    /**
     * Optional parameter indicating the maximum number of keys to include in
     * the response. COS S3 might return fewer than this, but will not return
     * more.
     */
    private final Integer maxKeys;

    /**
     * Optional parameter restricting the response to keys which begin with the
     * specified prefix.
     */
    private final String prefix;

    /**
     * Optional parameter indicating where to begin listing. The
     * list will only include keys that occur lexicographically after the
     * marker. This enables pagination; to get the next page of results use the
     * current value as the marker for the next request to list buckets.
     */
    private final String marker;


    /**
     * Gets the optional <code>maxKeys</code> parameter indicating the maximum number of keys to
     * include in the response. COS S3 might return fewer keys than specified, but will
     * never return more.
     *
     * @return The optional parameter indicating the maximum number of keys to
     *         include in the response.
     * @see Builder#maxKeys() (String)
     */
    public Integer maxKeys(){
        return maxKeys;
    }

    /**
     * Gets the optional prefix parameter and restricts the response to keys
     * that begin with the specified prefix. Use prefixes to separate a
     * bucket into different sets of keys, similar to how a file system organizes files
     * into directories.
     *
     * @return The optional prefix parameter restricting the response to keys
     *         that begin with the specified prefix.
     *
     * @see Builder#prefix() (String)
     */
    public String prefix(){
        return prefix;
    }

    /**
     * Gets the optional marker parameter indicating where in the bucket to begin
     * listing. The list will only include keys that occur lexicographically
     * after the marker.
     *
     * @return The optional marker parameter indicating where in the bucket to begin
     *         listing. The list will only include keys that occur
     *         lexicographically after the marker.
     *
     * @see Builder#marker() (String)
     */
    public String marker(){
        return marker;
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
        hashCode = 31 * hashCode + Objects.hashCode(maxKeys());
        hashCode = 31 * hashCode + Objects.hashCode(prefix());
        hashCode = 31 * hashCode + Objects.hashCode(marker());
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
        if (!(obj instanceof ListBucketsExtendedRequest)) {
            return false;
        }
        ListBucketsExtendedRequest other = (ListBucketsExtendedRequest) obj;
        return Objects.equals(maxKeys(), other.maxKeys()) && Objects.equals(prefix(), other.prefix())
               && Objects.equals(marker(), other.marker());
    }

    /**
     * Returns a string representation of this object. This is useful for testing and debugging. Sensitive data will be
     * redacted from this string using a placeholder value.
     */
    @Override
    public final String toString() {
        return ToString.builder("ListBucketsExtendedRequest")
                       .add("MaxKeys", maxKeys())
                       .add("Prefix", prefix())
                       .add("Marker", marker()).build();
    }

    public final <T> Optional<T> getValueForField(String fieldName, Class<T> clazz) {
        switch (fieldName) {
            case "MaxKeys":
                return Optional.ofNullable(clazz.cast(maxKeys()));
            case "Prefix":
                return Optional.ofNullable(clazz.cast(prefix()));
            case "Marker":
                return Optional.ofNullable(clazz.cast(marker()));
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
                                     CopyableBuilder<ListBucketsExtendedRequest.Builder, ListBucketsExtendedRequest> {
        /**
         * Sets the optional <code>maxKeys</code> parameter indicating the maximum number of keys to
         * include in the response.
         *
         * @param maxKeys
         *            The optional parameter indicating the maximum number of keys
         *            to include in the response.
         *
         *  @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder maxKeys(Integer maxKeys);

        /**
         * Sets the optional prefix parameter, restricting the response to keys that
         * begin with the specified prefix.
         *
         * @param prefix
         *            The optional prefix parameter, restricting the response to keys
         *            that begin with the specified prefix.
         *
         *  @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder prefix(String prefix);

        /**
         * Gets the optional marker parameter indicating where in the bucket to begin
         * listing. The list will only include keys that occur lexicographically
         * after the marker.
         *
         * @param marker
         *            The optional parameter indicating the maximum number of keys
         *            to include in the response.
         *
         *  @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder marker(String marker);
    }

    static private final class BuilderImpl extends S3Request.BuilderImpl implements ListBucketsExtendedRequest.Builder {
        private Integer maxKeys;

        private String prefix;

        private String marker;

        private BuilderImpl(){};

        BuilderImpl(ListBucketsExtendedRequest model) {
            super(model);
            maxKeys(model.maxKeys);
            prefix(model.prefix);
            marker(model.marker);
        }

        @Override
        public Builder maxKeys(Integer maxKeys) {
            this.maxKeys = maxKeys;
            return this;
        }

        @Override
        public Builder prefix(String prefix) {
            this.prefix = prefix;
            return this;
        }

        @Override
        public Builder marker(String marker) {
            this.marker = marker;
            return this;
        }

        @Override
        public List<SdkField<?>> sdkFields() {
            return SDK_FIELDS;
        }

        @Override
        public ListBucketsExtendedRequest build() {
            return new ListBucketsExtendedRequest(this);
        }
    }
}
