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
import com.ibm.cos.v2.core.traits.PayloadTrait;
import com.ibm.cos.v2.core.traits.RequiredTrait;
import com.ibm.cos.v2.utils.ToString;
import com.ibm.cos.v2.utils.builder.CopyableBuilder;
import com.ibm.cos.v2.utils.builder.ToCopyableBuilder;

/**
 */
@Generated("com.ibm.cos.v2:codegen")
public final class PutBucketMetricsConfigurationRequest extends S3Request implements
        ToCopyableBuilder<PutBucketMetricsConfigurationRequest.Builder, PutBucketMetricsConfigurationRequest> {
    private static final SdkField<String> BUCKET_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("Bucket")
            .getter(getter(PutBucketMetricsConfigurationRequest::bucket))
            .setter(setter(Builder::bucket))
            .traits(LocationTrait.builder().location(MarshallLocation.PATH).locationName("Bucket")
                    .unmarshallLocationName("Bucket").build(), RequiredTrait.create()).build();

    private static final SdkField<String> ID_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("Id")
            .getter(getter(PutBucketMetricsConfigurationRequest::id))
            .setter(setter(Builder::id))
            .traits(LocationTrait.builder().location(MarshallLocation.QUERY_PARAM).locationName("id")
                    .unmarshallLocationName("id").build(), RequiredTrait.create()).build();

    private static final SdkField<MetricsConfiguration> METRICS_CONFIGURATION_FIELD = SdkField
            .<MetricsConfiguration> builder(MarshallingType.SDK_POJO)
            .memberName("MetricsConfiguration")
            .getter(getter(PutBucketMetricsConfigurationRequest::metricsConfiguration))
            .setter(setter(Builder::metricsConfiguration))
            .constructor(MetricsConfiguration::builder)
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("MetricsConfiguration")
                    .unmarshallLocationName("MetricsConfiguration").build(), PayloadTrait.create(), RequiredTrait.create())
            .build();

    private static final SdkField<String> EXPECTED_BUCKET_OWNER_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("ExpectedBucketOwner")
            .getter(getter(PutBucketMetricsConfigurationRequest::expectedBucketOwner))
            .setter(setter(Builder::expectedBucketOwner))
            .traits(LocationTrait.builder().location(MarshallLocation.HEADER).locationName("x-amz-expected-bucket-owner")
                    .unmarshallLocationName("x-amz-expected-bucket-owner").build()).build();

    private static final List<SdkField<?>> SDK_FIELDS = Collections.unmodifiableList(Arrays.asList(BUCKET_FIELD, ID_FIELD,
            METRICS_CONFIGURATION_FIELD, EXPECTED_BUCKET_OWNER_FIELD));

    private static final Map<String, SdkField<?>> SDK_NAME_TO_FIELD = memberNameToFieldInitializer();

    private final String bucket;

    private final String id;

    private final MetricsConfiguration metricsConfiguration;

    private final String expectedBucketOwner;

    private PutBucketMetricsConfigurationRequest(BuilderImpl builder) {
        super(builder);
        this.bucket = builder.bucket;
        this.id = builder.id;
        this.metricsConfiguration = builder.metricsConfiguration;
        this.expectedBucketOwner = builder.expectedBucketOwner;
    }

    /**
     * <p>
     * The name of the bucket for which the metrics configuration is set.
     * </p>
     * 
     * @return The name of the bucket for which the metrics configuration is set.
     */
    public final String bucket() {
        return bucket;
    }

    /**
     * <p>
     * The ID used to identify the metrics configuration. The ID has a 64 character limit and can only contain letters,
     * numbers, periods, dashes, and underscores.
     * </p>
     * 
     * @return The ID used to identify the metrics configuration. The ID has a 64 character limit and can only contain
     *         letters, numbers, periods, dashes, and underscores.
     */
    public final String id() {
        return id;
    }

    /**
     * <p>
     * Specifies the metrics configuration.
     * </p>
     * 
     * @return Specifies the metrics configuration.
     */
    public final MetricsConfiguration metricsConfiguration() {
        return metricsConfiguration;
    }

    /**
     * <p>
     * The account ID of the expected bucket owner. If the account ID that you provide does not match the actual owner
     * of the bucket, the request fails with the HTTP status code <code>403 Forbidden</code> (access denied).
     * </p>
     * 
     * @return The account ID of the expected bucket owner. If the account ID that you provide does not match the actual
     *         owner of the bucket, the request fails with the HTTP status code <code>403 Forbidden</code> (access
     *         denied).
     */
    public final String expectedBucketOwner() {
        return expectedBucketOwner;
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
        hashCode = 31 * hashCode + Objects.hashCode(bucket());
        hashCode = 31 * hashCode + Objects.hashCode(id());
        hashCode = 31 * hashCode + Objects.hashCode(metricsConfiguration());
        hashCode = 31 * hashCode + Objects.hashCode(expectedBucketOwner());
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
        if (!(obj instanceof PutBucketMetricsConfigurationRequest)) {
            return false;
        }
        PutBucketMetricsConfigurationRequest other = (PutBucketMetricsConfigurationRequest) obj;
        return Objects.equals(bucket(), other.bucket()) && Objects.equals(id(), other.id())
                && Objects.equals(metricsConfiguration(), other.metricsConfiguration())
                && Objects.equals(expectedBucketOwner(), other.expectedBucketOwner());
    }

    /**
     * Returns a string representation of this object. This is useful for testing and debugging. Sensitive data will be
     * redacted from this string using a placeholder value.
     */
    @Override
    public final String toString() {
        return ToString.builder("PutBucketMetricsConfigurationRequest").add("Bucket", bucket()).add("Id", id())
                .add("MetricsConfiguration", metricsConfiguration()).add("ExpectedBucketOwner", expectedBucketOwner()).build();
    }

    public final <T> Optional<T> getValueForField(String fieldName, Class<T> clazz) {
        switch (fieldName) {
        case "Bucket":
            return Optional.ofNullable(clazz.cast(bucket()));
        case "Id":
            return Optional.ofNullable(clazz.cast(id()));
        case "MetricsConfiguration":
            return Optional.ofNullable(clazz.cast(metricsConfiguration()));
        case "ExpectedBucketOwner":
            return Optional.ofNullable(clazz.cast(expectedBucketOwner()));
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
        map.put("Bucket", BUCKET_FIELD);
        map.put("id", ID_FIELD);
        map.put("MetricsConfiguration", METRICS_CONFIGURATION_FIELD);
        map.put("x-amz-expected-bucket-owner", EXPECTED_BUCKET_OWNER_FIELD);
        return Collections.unmodifiableMap(map);
    }

    private static <T> Function<Object, T> getter(Function<PutBucketMetricsConfigurationRequest, T> g) {
        return obj -> g.apply((PutBucketMetricsConfigurationRequest) obj);
    }

    private static <T> BiConsumer<Object, T> setter(BiConsumer<Builder, T> s) {
        return (obj, val) -> s.accept((Builder) obj, val);
    }

    @Mutable
    @NotThreadSafe
    public interface Builder extends S3Request.Builder, SdkPojo, CopyableBuilder<Builder, PutBucketMetricsConfigurationRequest> {
        /**
         * <p>
         * The name of the bucket for which the metrics configuration is set.
         * </p>
         * 
         * @param bucket
         *        The name of the bucket for which the metrics configuration is set.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder bucket(String bucket);

        /**
         * <p>
         * The ID used to identify the metrics configuration. The ID has a 64 character limit and can only contain
         * letters, numbers, periods, dashes, and underscores.
         * </p>
         * 
         * @param id
         *        The ID used to identify the metrics configuration. The ID has a 64 character limit and can only
         *        contain letters, numbers, periods, dashes, and underscores.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder id(String id);

        /**
         * <p>
         * Specifies the metrics configuration.
         * </p>
         * 
         * @param metricsConfiguration
         *        Specifies the metrics configuration.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder metricsConfiguration(MetricsConfiguration metricsConfiguration);

        /**
         * <p>
         * Specifies the metrics configuration.
         * </p>
         * This is a convenience method that creates an instance of the {@link MetricsConfiguration.Builder} avoiding
         * the need to create one manually via {@link MetricsConfiguration#builder()}.
         *
         * <p>
         * When the {@link Consumer} completes, {@link MetricsConfiguration.Builder#build()} is called immediately and
         * its result is passed to {@link #metricsConfiguration(MetricsConfiguration)}.
         * 
         * @param metricsConfiguration
         *        a consumer that will call methods on {@link MetricsConfiguration.Builder}
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see #metricsConfiguration(MetricsConfiguration)
         */
        default Builder metricsConfiguration(Consumer<MetricsConfiguration.Builder> metricsConfiguration) {
            return metricsConfiguration(MetricsConfiguration.builder().applyMutation(metricsConfiguration).build());
        }

        /**
         * <p>
         * The account ID of the expected bucket owner. If the account ID that you provide does not match the actual
         * owner of the bucket, the request fails with the HTTP status code <code>403 Forbidden</code> (access denied).
         * </p>
         * 
         * @param expectedBucketOwner
         *        The account ID of the expected bucket owner. If the account ID that you provide does not match the
         *        actual owner of the bucket, the request fails with the HTTP status code <code>403 Forbidden</code>
         *        (access denied).
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder expectedBucketOwner(String expectedBucketOwner);

        @Override
        Builder overrideConfiguration(AwsRequestOverrideConfiguration overrideConfiguration);

        @Override
        Builder overrideConfiguration(Consumer<AwsRequestOverrideConfiguration.Builder> builderConsumer);
    }

    static final class BuilderImpl extends S3Request.BuilderImpl implements Builder {
        private String bucket;

        private String id;

        private MetricsConfiguration metricsConfiguration;

        private String expectedBucketOwner;

        private BuilderImpl() {
        }

        private BuilderImpl(PutBucketMetricsConfigurationRequest model) {
            super(model);
            bucket(model.bucket);
            id(model.id);
            metricsConfiguration(model.metricsConfiguration);
            expectedBucketOwner(model.expectedBucketOwner);
        }

        public final String getBucket() {
            return bucket;
        }

        public final void setBucket(String bucket) {
            this.bucket = bucket;
        }

        @Override
        public final Builder bucket(String bucket) {
            this.bucket = bucket;
            return this;
        }

        public final String getId() {
            return id;
        }

        public final void setId(String id) {
            this.id = id;
        }

        @Override
        public final Builder id(String id) {
            this.id = id;
            return this;
        }

        public final MetricsConfiguration.Builder getMetricsConfiguration() {
            return metricsConfiguration != null ? metricsConfiguration.toBuilder() : null;
        }

        public final void setMetricsConfiguration(MetricsConfiguration.BuilderImpl metricsConfiguration) {
            this.metricsConfiguration = metricsConfiguration != null ? metricsConfiguration.build() : null;
        }

        @Override
        public final Builder metricsConfiguration(MetricsConfiguration metricsConfiguration) {
            this.metricsConfiguration = metricsConfiguration;
            return this;
        }

        public final String getExpectedBucketOwner() {
            return expectedBucketOwner;
        }

        public final void setExpectedBucketOwner(String expectedBucketOwner) {
            this.expectedBucketOwner = expectedBucketOwner;
        }

        @Override
        public final Builder expectedBucketOwner(String expectedBucketOwner) {
            this.expectedBucketOwner = expectedBucketOwner;
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
        public PutBucketMetricsConfigurationRequest build() {
            return new PutBucketMetricsConfigurationRequest(this);
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
