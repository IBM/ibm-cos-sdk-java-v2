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
import com.ibm.cos.v2.awscore.AwsRequestOverrideConfiguration;
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
public final class ListDirectoryBucketsRequest extends S3Request implements
        ToCopyableBuilder<ListDirectoryBucketsRequest.Builder, ListDirectoryBucketsRequest> {
    private static final SdkField<String> CONTINUATION_TOKEN_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("ContinuationToken")
            .getter(getter(ListDirectoryBucketsRequest::continuationToken))
            .setter(setter(Builder::continuationToken))
            .traits(LocationTrait.builder().location(MarshallLocation.QUERY_PARAM).locationName("continuation-token")
                    .unmarshallLocationName("continuation-token").build()).build();

    private static final SdkField<Integer> MAX_DIRECTORY_BUCKETS_FIELD = SdkField
            .<Integer> builder(MarshallingType.INTEGER)
            .memberName("MaxDirectoryBuckets")
            .getter(getter(ListDirectoryBucketsRequest::maxDirectoryBuckets))
            .setter(setter(Builder::maxDirectoryBuckets))
            .traits(LocationTrait.builder().location(MarshallLocation.QUERY_PARAM).locationName("max-directory-buckets")
                    .unmarshallLocationName("max-directory-buckets").build()).build();

    private static final List<SdkField<?>> SDK_FIELDS = Collections.unmodifiableList(Arrays.asList(CONTINUATION_TOKEN_FIELD,
            MAX_DIRECTORY_BUCKETS_FIELD));

    private static final Map<String, SdkField<?>> SDK_NAME_TO_FIELD = memberNameToFieldInitializer();

    private final String continuationToken;

    private final Integer maxDirectoryBuckets;

    private ListDirectoryBucketsRequest(BuilderImpl builder) {
        super(builder);
        this.continuationToken = builder.continuationToken;
        this.maxDirectoryBuckets = builder.maxDirectoryBuckets;
    }

    /**
     * <p>
     * <code>ContinuationToken</code> indicates to Amazon S3 that the list is being continued on buckets in this account
     * with a token. <code>ContinuationToken</code> is obfuscated and is not a real bucket name. You can use this
     * <code>ContinuationToken</code> for the pagination of the list results.
     * </p>
     * 
     * @return <code>ContinuationToken</code> indicates to Amazon S3 that the list is being continued on buckets in this
     *         account with a token. <code>ContinuationToken</code> is obfuscated and is not a real bucket name. You can
     *         use this <code>ContinuationToken</code> for the pagination of the list results.
     */
    public final String continuationToken() {
        return continuationToken;
    }

    /**
     * <p>
     * Maximum number of buckets to be returned in response. When the number is more than the count of buckets that are
     * owned by an Amazon Web Services account, return all the buckets in response.
     * </p>
     * 
     * @return Maximum number of buckets to be returned in response. When the number is more than the count of buckets
     *         that are owned by an Amazon Web Services account, return all the buckets in response.
     */
    public final Integer maxDirectoryBuckets() {
        return maxDirectoryBuckets;
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
        hashCode = 31 * hashCode + Objects.hashCode(continuationToken());
        hashCode = 31 * hashCode + Objects.hashCode(maxDirectoryBuckets());
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
        if (!(obj instanceof ListDirectoryBucketsRequest)) {
            return false;
        }
        ListDirectoryBucketsRequest other = (ListDirectoryBucketsRequest) obj;
        return Objects.equals(continuationToken(), other.continuationToken())
                && Objects.equals(maxDirectoryBuckets(), other.maxDirectoryBuckets());
    }

    /**
     * Returns a string representation of this object. This is useful for testing and debugging. Sensitive data will be
     * redacted from this string using a placeholder value.
     */
    @Override
    public final String toString() {
        return ToString.builder("ListDirectoryBucketsRequest").add("ContinuationToken", continuationToken())
                .add("MaxDirectoryBuckets", maxDirectoryBuckets()).build();
    }

    public final <T> Optional<T> getValueForField(String fieldName, Class<T> clazz) {
        switch (fieldName) {
        case "ContinuationToken":
            return Optional.ofNullable(clazz.cast(continuationToken()));
        case "MaxDirectoryBuckets":
            return Optional.ofNullable(clazz.cast(maxDirectoryBuckets()));
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
        map.put("continuation-token", CONTINUATION_TOKEN_FIELD);
        map.put("max-directory-buckets", MAX_DIRECTORY_BUCKETS_FIELD);
        return Collections.unmodifiableMap(map);
    }

    private static <T> Function<Object, T> getter(Function<ListDirectoryBucketsRequest, T> g) {
        return obj -> g.apply((ListDirectoryBucketsRequest) obj);
    }

    private static <T> BiConsumer<Object, T> setter(BiConsumer<Builder, T> s) {
        return (obj, val) -> s.accept((Builder) obj, val);
    }

    @Mutable
    @NotThreadSafe
    public interface Builder extends S3Request.Builder, SdkPojo, CopyableBuilder<Builder, ListDirectoryBucketsRequest> {
        /**
         * <p>
         * <code>ContinuationToken</code> indicates to Amazon S3 that the list is being continued on buckets in this
         * account with a token. <code>ContinuationToken</code> is obfuscated and is not a real bucket name. You can use
         * this <code>ContinuationToken</code> for the pagination of the list results.
         * </p>
         * 
         * @param continuationToken
         *        <code>ContinuationToken</code> indicates to Amazon S3 that the list is being continued on buckets in
         *        this account with a token. <code>ContinuationToken</code> is obfuscated and is not a real bucket name.
         *        You can use this <code>ContinuationToken</code> for the pagination of the list results.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder continuationToken(String continuationToken);

        /**
         * <p>
         * Maximum number of buckets to be returned in response. When the number is more than the count of buckets that
         * are owned by an Amazon Web Services account, return all the buckets in response.
         * </p>
         * 
         * @param maxDirectoryBuckets
         *        Maximum number of buckets to be returned in response. When the number is more than the count of
         *        buckets that are owned by an Amazon Web Services account, return all the buckets in response.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder maxDirectoryBuckets(Integer maxDirectoryBuckets);

        @Override
        Builder overrideConfiguration(AwsRequestOverrideConfiguration overrideConfiguration);

        @Override
        Builder overrideConfiguration(Consumer<AwsRequestOverrideConfiguration.Builder> builderConsumer);
    }

    static final class BuilderImpl extends S3Request.BuilderImpl implements Builder {
        private String continuationToken;

        private Integer maxDirectoryBuckets;

        private BuilderImpl() {
        }

        private BuilderImpl(ListDirectoryBucketsRequest model) {
            super(model);
            continuationToken(model.continuationToken);
            maxDirectoryBuckets(model.maxDirectoryBuckets);
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

        public final Integer getMaxDirectoryBuckets() {
            return maxDirectoryBuckets;
        }

        public final void setMaxDirectoryBuckets(Integer maxDirectoryBuckets) {
            this.maxDirectoryBuckets = maxDirectoryBuckets;
        }

        @Override
        public final Builder maxDirectoryBuckets(Integer maxDirectoryBuckets) {
            this.maxDirectoryBuckets = maxDirectoryBuckets;
            return this;
        }

        @Override
        public Builder overrideConfiguration(AwsRequestOverrideConfiguration overrideConfiguration) {
            super.overrideConfiguration(overrideConfiguration);
            return this;
        }

        @Override
        public Builder overrideConfiguration(Consumer<AwsRequestOverrideConfiguration.Builder> builderConsumer) {
            super.overrideConfiguration(builderConsumer);
            return this;
        }

        @Override
        public ListDirectoryBucketsRequest build() {
            return new ListDirectoryBucketsRequest(this);
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
