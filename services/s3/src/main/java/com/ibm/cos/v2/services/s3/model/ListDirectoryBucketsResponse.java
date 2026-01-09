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

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import com.ibm.cos.v2.annotations.Generated;
import com.ibm.cos.v2.annotations.Mutable;
import com.ibm.cos.v2.annotations.NotThreadSafe;
import com.ibm.cos.v2.core.SdkField;
import com.ibm.cos.v2.core.SdkPojo;
import com.ibm.cos.v2.core.protocol.MarshallLocation;
import com.ibm.cos.v2.core.protocol.MarshallingType;
import com.ibm.cos.v2.core.traits.ListTrait;
import com.ibm.cos.v2.core.traits.LocationTrait;
import com.ibm.cos.v2.core.util.DefaultSdkAutoConstructList;
import com.ibm.cos.v2.core.util.SdkAutoConstructList;
import com.ibm.cos.v2.utils.ToString;
import com.ibm.cos.v2.utils.builder.CopyableBuilder;
import com.ibm.cos.v2.utils.builder.ToCopyableBuilder;

/**
 */
@Generated("com.ibm.cos.v2:codegen")
public final class ListDirectoryBucketsResponse extends S3Response implements
        ToCopyableBuilder<ListDirectoryBucketsResponse.Builder, ListDirectoryBucketsResponse> {
    private static final SdkField<List<Bucket>> BUCKETS_FIELD = SdkField
            .<List<Bucket>> builder(MarshallingType.LIST)
            .memberName("Buckets")
            .getter(getter(ListDirectoryBucketsResponse::buckets))
            .setter(setter(Builder::buckets))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("Buckets")
                    .unmarshallLocationName("Buckets").build(),
                    ListTrait
                            .builder()
                            .memberLocationName("Bucket")
                            .memberFieldInfo(
                                    SdkField.<Bucket> builder(MarshallingType.SDK_POJO)
                                            .constructor(Bucket::builder)
                                            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD)
                                                    .locationName("Bucket").unmarshallLocationName("Bucket").build()).build())
                            .build()).build();

    private static final SdkField<String> CONTINUATION_TOKEN_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("ContinuationToken")
            .getter(getter(ListDirectoryBucketsResponse::continuationToken))
            .setter(setter(Builder::continuationToken))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("ContinuationToken")
                    .unmarshallLocationName("ContinuationToken").build()).build();

    private static final List<SdkField<?>> SDK_FIELDS = Collections.unmodifiableList(Arrays.asList(BUCKETS_FIELD,
            CONTINUATION_TOKEN_FIELD));

    private static final Map<String, SdkField<?>> SDK_NAME_TO_FIELD = memberNameToFieldInitializer();

    private final List<Bucket> buckets;

    private final String continuationToken;

    private ListDirectoryBucketsResponse(BuilderImpl builder) {
        super(builder);
        this.buckets = builder.buckets;
        this.continuationToken = builder.continuationToken;
    }

    /**
     * For responses, this returns true if the service returned a value for the Buckets property. This DOES NOT check
     * that the value is non-empty (for which, you should check the {@code isEmpty()} method on the property). This is
     * useful because the SDK will never return a null collection or map, but you may need to differentiate between the
     * service returning nothing (or null) and the service returning an empty collection or map. For requests, this
     * returns true if a value for the property was specified in the request builder, and false if a value was not
     * specified.
     */
    public final boolean hasBuckets() {
        return buckets != null && !(buckets instanceof SdkAutoConstructList);
    }

    /**
     * <p>
     * The list of buckets owned by the requester.
     * </p>
     * <p>
     * Attempts to modify the collection returned by this method will result in an UnsupportedOperationException.
     * </p>
     * <p>
     * This method will never return null. If you would like to know whether the service returned this field (so that
     * you can differentiate between null and empty), you can use the {@link #hasBuckets} method.
     * </p>
     * 
     * @return The list of buckets owned by the requester.
     */
    public final List<Bucket> buckets() {
        return buckets;
    }

    /**
     * <p>
     * If <code>ContinuationToken</code> was sent with the request, it is included in the response. You can use the
     * returned <code>ContinuationToken</code> for pagination of the list response.
     * </p>
     * 
     * @return If <code>ContinuationToken</code> was sent with the request, it is included in the response. You can use
     *         the returned <code>ContinuationToken</code> for pagination of the list response.
     */
    public final String continuationToken() {
        return continuationToken;
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
        hashCode = 31 * hashCode + super.hashCode();
        hashCode = 31 * hashCode + Objects.hashCode(hasBuckets() ? buckets() : null);
        hashCode = 31 * hashCode + Objects.hashCode(continuationToken());
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
        if (!(obj instanceof ListDirectoryBucketsResponse)) {
            return false;
        }
        ListDirectoryBucketsResponse other = (ListDirectoryBucketsResponse) obj;
        return hasBuckets() == other.hasBuckets() && Objects.equals(buckets(), other.buckets())
                && Objects.equals(continuationToken(), other.continuationToken());
    }

    /**
     * Returns a string representation of this object. This is useful for testing and debugging. Sensitive data will be
     * redacted from this string using a placeholder value.
     */
    @Override
    public final String toString() {
        return ToString.builder("ListDirectoryBucketsResponse").add("Buckets", hasBuckets() ? buckets() : null)
                .add("ContinuationToken", continuationToken()).build();
    }

    public final <T> Optional<T> getValueForField(String fieldName, Class<T> clazz) {
        switch (fieldName) {
        case "Buckets":
            return Optional.ofNullable(clazz.cast(buckets()));
        case "ContinuationToken":
            return Optional.ofNullable(clazz.cast(continuationToken()));
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
        map.put("Buckets", BUCKETS_FIELD);
        map.put("ContinuationToken", CONTINUATION_TOKEN_FIELD);
        return Collections.unmodifiableMap(map);
    }

    private static <T> Function<Object, T> getter(Function<ListDirectoryBucketsResponse, T> g) {
        return obj -> g.apply((ListDirectoryBucketsResponse) obj);
    }

    private static <T> BiConsumer<Object, T> setter(BiConsumer<Builder, T> s) {
        return (obj, val) -> s.accept((Builder) obj, val);
    }

    @Mutable
    @NotThreadSafe
    public interface Builder extends S3Response.Builder, SdkPojo, CopyableBuilder<Builder, ListDirectoryBucketsResponse> {
        /**
         * <p>
         * The list of buckets owned by the requester.
         * </p>
         * 
         * @param buckets
         *        The list of buckets owned by the requester.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder buckets(Collection<Bucket> buckets);

        /**
         * <p>
         * The list of buckets owned by the requester.
         * </p>
         * 
         * @param buckets
         *        The list of buckets owned by the requester.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder buckets(Bucket... buckets);

        /**
         * <p>
         * The list of buckets owned by the requester.
         * </p>
         * This is a convenience method that creates an instance of the
         * {@link com.ibm.cos.v2.services.s3.model.Bucket.Builder} avoiding the need to create one manually via
         * {@link com.ibm.cos.v2.services.s3.model.Bucket#builder()}.
         *
         * <p>
         * When the {@link Consumer} completes, {@link com.ibm.cos.v2.services.s3.model.Bucket.Builder#build()}
         * is called immediately and its result is passed to {@link #buckets(List<Bucket>)}.
         * 
         * @param buckets
         *        a consumer that will call methods on {@link com.ibm.cos.v2.services.s3.model.Bucket.Builder}
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see #buckets(java.util.Collection<Bucket>)
         */
        Builder buckets(Consumer<Bucket.Builder>... buckets);

        /**
         * <p>
         * If <code>ContinuationToken</code> was sent with the request, it is included in the response. You can use the
         * returned <code>ContinuationToken</code> for pagination of the list response.
         * </p>
         * 
         * @param continuationToken
         *        If <code>ContinuationToken</code> was sent with the request, it is included in the response. You can
         *        use the returned <code>ContinuationToken</code> for pagination of the list response.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder continuationToken(String continuationToken);
    }

    static final class BuilderImpl extends S3Response.BuilderImpl implements Builder {
        private List<Bucket> buckets = DefaultSdkAutoConstructList.getInstance();

        private String continuationToken;

        private BuilderImpl() {
        }

        private BuilderImpl(ListDirectoryBucketsResponse model) {
            super(model);
            buckets(model.buckets);
            continuationToken(model.continuationToken);
        }

        public final List<Bucket.Builder> getBuckets() {
            List<Bucket.Builder> result = BucketsCopier.copyToBuilder(this.buckets);
            if (result instanceof SdkAutoConstructList) {
                return null;
            }
            return result;
        }

        public final void setBuckets(Collection<Bucket.BuilderImpl> buckets) {
            this.buckets = BucketsCopier.copyFromBuilder(buckets);
        }

        @Override
        public final Builder buckets(Collection<Bucket> buckets) {
            this.buckets = BucketsCopier.copy(buckets);
            return this;
        }

        @Override
        @SafeVarargs
        public final Builder buckets(Bucket... buckets) {
            buckets(Arrays.asList(buckets));
            return this;
        }

        @Override
        @SafeVarargs
        public final Builder buckets(Consumer<Bucket.Builder>... buckets) {
            buckets(Stream.of(buckets).map(c -> Bucket.builder().applyMutation(c).build()).collect(Collectors.toList()));
            return this;
        }

        public final String getContinuationToken() {
            return continuationToken;
        }

        public final void setContinuationToken(String continuationToken) {
            this.continuationToken = continuationToken;
        }

        @Override
        public final Builder continuationToken(String continuationToken) {
            this.continuationToken = continuationToken;
            return this;
        }

        @Override
        public ListDirectoryBucketsResponse build() {
            return new ListDirectoryBucketsResponse(this);
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
