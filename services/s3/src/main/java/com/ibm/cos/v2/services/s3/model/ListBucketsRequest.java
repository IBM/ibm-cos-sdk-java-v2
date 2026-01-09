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
public final class ListBucketsRequest extends S3Request implements
        ToCopyableBuilder<ListBucketsRequest.Builder, ListBucketsRequest> {
    private static final SdkField<Integer> MAX_BUCKETS_FIELD = SdkField
            .<Integer> builder(MarshallingType.INTEGER)
            .memberName("MaxBuckets")
            .getter(getter(ListBucketsRequest::maxBuckets))
            .setter(setter(Builder::maxBuckets))
            .traits(LocationTrait.builder().location(MarshallLocation.QUERY_PARAM).locationName("max-buckets")
                    .unmarshallLocationName("max-buckets").build()).build();

    private static final SdkField<String> CONTINUATION_TOKEN_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("ContinuationToken")
            .getter(getter(ListBucketsRequest::continuationToken))
            .setter(setter(Builder::continuationToken))
            .traits(LocationTrait.builder().location(MarshallLocation.QUERY_PARAM).locationName("continuation-token")
                    .unmarshallLocationName("continuation-token").build()).build();

    private static final SdkField<String> PREFIX_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("Prefix")
            .getter(getter(ListBucketsRequest::prefix))
            .setter(setter(Builder::prefix))
            .traits(LocationTrait.builder().location(MarshallLocation.QUERY_PARAM).locationName("prefix")
                    .unmarshallLocationName("prefix").build()).build();

    private static final SdkField<String> BUCKET_REGION_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("BucketRegion")
            .getter(getter(ListBucketsRequest::bucketRegion))
            .setter(setter(Builder::bucketRegion))
            .traits(LocationTrait.builder().location(MarshallLocation.QUERY_PARAM).locationName("bucket-region")
                    .unmarshallLocationName("bucket-region").build()).build();

    private static final List<SdkField<?>> SDK_FIELDS = Collections.unmodifiableList(Arrays.asList(MAX_BUCKETS_FIELD,
            CONTINUATION_TOKEN_FIELD, PREFIX_FIELD, BUCKET_REGION_FIELD));

    private static final Map<String, SdkField<?>> SDK_NAME_TO_FIELD = memberNameToFieldInitializer();

    private final Integer maxBuckets;

    private final String continuationToken;

    private final String prefix;

    private final String bucketRegion;

    private ListBucketsRequest(BuilderImpl builder) {
        super(builder);
        this.maxBuckets = builder.maxBuckets;
        this.continuationToken = builder.continuationToken;
        this.prefix = builder.prefix;
        this.bucketRegion = builder.bucketRegion;
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
    public final Integer maxBuckets() {
        return maxBuckets;
    }

    /**
     * <p>
     * <code>ContinuationToken</code> indicates to Amazon S3 that the list is being continued on this bucket with a
     * token. <code>ContinuationToken</code> is obfuscated and is not a real key. You can use this
     * <code>ContinuationToken</code> for pagination of the list results.
     * </p>
     * <p>
     * Length Constraints: Minimum length of 0. Maximum length of 1024.
     * </p>
     * <p>
     * Required: No.
     * </p>
     * <note>
     * <p>
     * If you specify the <code>bucket-region</code>, <code>prefix</code>, or <code>continuation-token</code> query
     * parameters without using <code>max-buckets</code> to set the maximum number of buckets returned in the response,
     * Amazon S3 applies a default page size of 10,000 and provides a continuation token if there are more buckets.
     * </p>
     * </note>
     * 
     * @return <code>ContinuationToken</code> indicates to Amazon S3 that the list is being continued on this bucket
     *         with a token. <code>ContinuationToken</code> is obfuscated and is not a real key. You can use this
     *         <code>ContinuationToken</code> for pagination of the list results. </p>
     *         <p>
     *         Length Constraints: Minimum length of 0. Maximum length of 1024.
     *         </p>
     *         <p>
     *         Required: No.
     *         </p>
     *         <note>
     *         <p>
     *         If you specify the <code>bucket-region</code>, <code>prefix</code>, or <code>continuation-token</code>
     *         query parameters without using <code>max-buckets</code> to set the maximum number of buckets returned in
     *         the response, Amazon S3 applies a default page size of 10,000 and provides a continuation token if there
     *         are more buckets.
     *         </p>
     */
    public final String continuationToken() {
        return continuationToken;
    }

    /**
     * <p>
     * Limits the response to bucket names that begin with the specified bucket name prefix.
     * </p>
     * 
     * @return Limits the response to bucket names that begin with the specified bucket name prefix.
     */
    public final String prefix() {
        return prefix;
    }

    /**
     * <p>
     * Limits the response to buckets that are located in the specified Amazon Web Services Region. The Amazon Web
     * Services Region must be expressed according to the Amazon Web Services Region code, such as
     * <code>us-west-2</code> for the US West (Oregon) Region. For a list of the valid values for all of the Amazon Web
     * Services Regions, see <a href="https://docs.aws.amazon.com/general/latest/gr/rande.html#s3_region">Regions and
     * Endpoints</a>.
     * </p>
     * <note>
     * <p>
     * Requests made to a Regional endpoint that is different from the <code>bucket-region</code> parameter are not
     * supported. For example, if you want to limit the response to your buckets in Region <code>us-west-2</code>, the
     * request must be made to an endpoint in Region <code>us-west-2</code>.
     * </p>
     * </note>
     * 
     * @return Limits the response to buckets that are located in the specified Amazon Web Services Region. The Amazon
     *         Web Services Region must be expressed according to the Amazon Web Services Region code, such as
     *         <code>us-west-2</code> for the US West (Oregon) Region. For a list of the valid values for all of the
     *         Amazon Web Services Regions, see <a
     *         href="https://docs.aws.amazon.com/general/latest/gr/rande.html#s3_region">Regions and Endpoints</a>.</p>
     *         <note>
     *         <p>
     *         Requests made to a Regional endpoint that is different from the <code>bucket-region</code> parameter are
     *         not supported. For example, if you want to limit the response to your buckets in Region
     *         <code>us-west-2</code>, the request must be made to an endpoint in Region <code>us-west-2</code>.
     *         </p>
     */
    public final String bucketRegion() {
        return bucketRegion;
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
        hashCode = 31 * hashCode + Objects.hashCode(maxBuckets());
        hashCode = 31 * hashCode + Objects.hashCode(continuationToken());
        hashCode = 31 * hashCode + Objects.hashCode(prefix());
        hashCode = 31 * hashCode + Objects.hashCode(bucketRegion());
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
        if (!(obj instanceof ListBucketsRequest)) {
            return false;
        }
        ListBucketsRequest other = (ListBucketsRequest) obj;
        return Objects.equals(maxBuckets(), other.maxBuckets()) && Objects.equals(continuationToken(), other.continuationToken())
                && Objects.equals(prefix(), other.prefix()) && Objects.equals(bucketRegion(), other.bucketRegion());
    }

    /**
     * Returns a string representation of this object. This is useful for testing and debugging. Sensitive data will be
     * redacted from this string using a placeholder value.
     */
    @Override
    public final String toString() {
        return ToString.builder("ListBucketsRequest").add("MaxBuckets", maxBuckets())
                .add("ContinuationToken", continuationToken()).add("Prefix", prefix()).add("BucketRegion", bucketRegion())
                .build();
    }

    public final <T> Optional<T> getValueForField(String fieldName, Class<T> clazz) {
        switch (fieldName) {
        case "MaxBuckets":
            return Optional.ofNullable(clazz.cast(maxBuckets()));
        case "ContinuationToken":
            return Optional.ofNullable(clazz.cast(continuationToken()));
        case "Prefix":
            return Optional.ofNullable(clazz.cast(prefix()));
        case "BucketRegion":
            return Optional.ofNullable(clazz.cast(bucketRegion()));
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
        map.put("max-buckets", MAX_BUCKETS_FIELD);
        map.put("continuation-token", CONTINUATION_TOKEN_FIELD);
        map.put("prefix", PREFIX_FIELD);
        map.put("bucket-region", BUCKET_REGION_FIELD);
        return Collections.unmodifiableMap(map);
    }

    private static <T> Function<Object, T> getter(Function<ListBucketsRequest, T> g) {
        return obj -> g.apply((ListBucketsRequest) obj);
    }

    private static <T> BiConsumer<Object, T> setter(BiConsumer<Builder, T> s) {
        return (obj, val) -> s.accept((Builder) obj, val);
    }

    @Mutable
    @NotThreadSafe
    public interface Builder extends S3Request.Builder, SdkPojo, CopyableBuilder<Builder, ListBucketsRequest> {
        /**
         * <p>
         * Maximum number of buckets to be returned in response. When the number is more than the count of buckets that
         * are owned by an Amazon Web Services account, return all the buckets in response.
         * </p>
         * 
         * @param maxBuckets
         *        Maximum number of buckets to be returned in response. When the number is more than the count of
         *        buckets that are owned by an Amazon Web Services account, return all the buckets in response.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder maxBuckets(Integer maxBuckets);

        /**
         * <p>
         * <code>ContinuationToken</code> indicates to Amazon S3 that the list is being continued on this bucket with a
         * token. <code>ContinuationToken</code> is obfuscated and is not a real key. You can use this
         * <code>ContinuationToken</code> for pagination of the list results.
         * </p>
         * <p>
         * Length Constraints: Minimum length of 0. Maximum length of 1024.
         * </p>
         * <p>
         * Required: No.
         * </p>
         * <note>
         * <p>
         * If you specify the <code>bucket-region</code>, <code>prefix</code>, or <code>continuation-token</code> query
         * parameters without using <code>max-buckets</code> to set the maximum number of buckets returned in the
         * response, Amazon S3 applies a default page size of 10,000 and provides a continuation token if there are more
         * buckets.
         * </p>
         * </note>
         * 
         * @param continuationToken
         *        <code>ContinuationToken</code> indicates to Amazon S3 that the list is being continued on this bucket
         *        with a token. <code>ContinuationToken</code> is obfuscated and is not a real key. You can use this
         *        <code>ContinuationToken</code> for pagination of the list results. </p>
         *        <p>
         *        Length Constraints: Minimum length of 0. Maximum length of 1024.
         *        </p>
         *        <p>
         *        Required: No.
         *        </p>
         *        <note>
         *        <p>
         *        If you specify the <code>bucket-region</code>, <code>prefix</code>, or <code>continuation-token</code>
         *        query parameters without using <code>max-buckets</code> to set the maximum number of buckets returned
         *        in the response, Amazon S3 applies a default page size of 10,000 and provides a continuation token if
         *        there are more buckets.
         *        </p>
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder continuationToken(String continuationToken);

        /**
         * <p>
         * Limits the response to bucket names that begin with the specified bucket name prefix.
         * </p>
         * 
         * @param prefix
         *        Limits the response to bucket names that begin with the specified bucket name prefix.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder prefix(String prefix);

        /**
         * <p>
         * Limits the response to buckets that are located in the specified Amazon Web Services Region. The Amazon Web
         * Services Region must be expressed according to the Amazon Web Services Region code, such as
         * <code>us-west-2</code> for the US West (Oregon) Region. For a list of the valid values for all of the Amazon
         * Web Services Regions, see <a
         * href="https://docs.aws.amazon.com/general/latest/gr/rande.html#s3_region">Regions and Endpoints</a>.
         * </p>
         * <note>
         * <p>
         * Requests made to a Regional endpoint that is different from the <code>bucket-region</code> parameter are not
         * supported. For example, if you want to limit the response to your buckets in Region <code>us-west-2</code>,
         * the request must be made to an endpoint in Region <code>us-west-2</code>.
         * </p>
         * </note>
         * 
         * @param bucketRegion
         *        Limits the response to buckets that are located in the specified Amazon Web Services Region. The
         *        Amazon Web Services Region must be expressed according to the Amazon Web Services Region code, such as
         *        <code>us-west-2</code> for the US West (Oregon) Region. For a list of the valid values for all of the
         *        Amazon Web Services Regions, see <a
         *        href="https://docs.aws.amazon.com/general/latest/gr/rande.html#s3_region">Regions and
         *        Endpoints</a>.</p> <note>
         *        <p>
         *        Requests made to a Regional endpoint that is different from the <code>bucket-region</code> parameter
         *        are not supported. For example, if you want to limit the response to your buckets in Region
         *        <code>us-west-2</code>, the request must be made to an endpoint in Region <code>us-west-2</code>.
         *        </p>
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder bucketRegion(String bucketRegion);

        @Override
        Builder overrideConfiguration(AwsRequestOverrideConfiguration overrideConfiguration);

        @Override
        Builder overrideConfiguration(Consumer<AwsRequestOverrideConfiguration.Builder> builderConsumer);
    }

    static final class BuilderImpl extends S3Request.BuilderImpl implements Builder {
        private Integer maxBuckets;

        private String continuationToken;

        private String prefix;

        private String bucketRegion;

        private BuilderImpl() {
        }

        private BuilderImpl(ListBucketsRequest model) {
            super(model);
            maxBuckets(model.maxBuckets);
            continuationToken(model.continuationToken);
            prefix(model.prefix);
            bucketRegion(model.bucketRegion);
        }

        public final Integer getMaxBuckets() {
            return maxBuckets;
        }

        public final void setMaxBuckets(Integer maxBuckets) {
            this.maxBuckets = maxBuckets;
        }

        @Override
        public final Builder maxBuckets(Integer maxBuckets) {
            this.maxBuckets = maxBuckets;
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

        public final String getPrefix() {
            return prefix;
        }

        public final void setPrefix(String prefix) {
            this.prefix = prefix;
        }

        @Override
        public final Builder prefix(String prefix) {
            this.prefix = prefix;
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
        public ListBucketsRequest build() {
            return new ListBucketsRequest(this);
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
