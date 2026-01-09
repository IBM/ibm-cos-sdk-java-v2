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
public final class CreateBucketMetadataTableConfigurationRequest extends S3Request implements
        ToCopyableBuilder<CreateBucketMetadataTableConfigurationRequest.Builder, CreateBucketMetadataTableConfigurationRequest> {
    private static final SdkField<String> BUCKET_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("Bucket")
            .getter(getter(CreateBucketMetadataTableConfigurationRequest::bucket))
            .setter(setter(Builder::bucket))
            .traits(LocationTrait.builder().location(MarshallLocation.PATH).locationName("Bucket")
                    .unmarshallLocationName("Bucket").build(), RequiredTrait.create()).build();

    private static final SdkField<String> CONTENT_MD5_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("ContentMD5")
            .getter(getter(CreateBucketMetadataTableConfigurationRequest::contentMD5))
            .setter(setter(Builder::contentMD5))
            .traits(LocationTrait.builder().location(MarshallLocation.HEADER).locationName("Content-MD5")
                    .unmarshallLocationName("Content-MD5").build()).build();

    private static final SdkField<String> CHECKSUM_ALGORITHM_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("ChecksumAlgorithm")
            .getter(getter(CreateBucketMetadataTableConfigurationRequest::checksumAlgorithmAsString))
            .setter(setter(Builder::checksumAlgorithm))
            .traits(LocationTrait.builder().location(MarshallLocation.HEADER).locationName("x-amz-sdk-checksum-algorithm")
                    .unmarshallLocationName("x-amz-sdk-checksum-algorithm").build()).build();

    private static final SdkField<MetadataTableConfiguration> METADATA_TABLE_CONFIGURATION_FIELD = SdkField
            .<MetadataTableConfiguration> builder(MarshallingType.SDK_POJO)
            .memberName("MetadataTableConfiguration")
            .getter(getter(CreateBucketMetadataTableConfigurationRequest::metadataTableConfiguration))
            .setter(setter(Builder::metadataTableConfiguration))
            .constructor(MetadataTableConfiguration::builder)
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("MetadataTableConfiguration")
                    .unmarshallLocationName("MetadataTableConfiguration").build(), PayloadTrait.create(), RequiredTrait.create())
            .build();

    private static final SdkField<String> EXPECTED_BUCKET_OWNER_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("ExpectedBucketOwner")
            .getter(getter(CreateBucketMetadataTableConfigurationRequest::expectedBucketOwner))
            .setter(setter(Builder::expectedBucketOwner))
            .traits(LocationTrait.builder().location(MarshallLocation.HEADER).locationName("x-amz-expected-bucket-owner")
                    .unmarshallLocationName("x-amz-expected-bucket-owner").build()).build();

    private static final List<SdkField<?>> SDK_FIELDS = Collections.unmodifiableList(Arrays.asList(BUCKET_FIELD,
            CONTENT_MD5_FIELD, CHECKSUM_ALGORITHM_FIELD, METADATA_TABLE_CONFIGURATION_FIELD, EXPECTED_BUCKET_OWNER_FIELD));

    private static final Map<String, SdkField<?>> SDK_NAME_TO_FIELD = memberNameToFieldInitializer();

    private final String bucket;

    private final String contentMD5;

    private final String checksumAlgorithm;

    private final MetadataTableConfiguration metadataTableConfiguration;

    private final String expectedBucketOwner;

    private CreateBucketMetadataTableConfigurationRequest(BuilderImpl builder) {
        super(builder);
        this.bucket = builder.bucket;
        this.contentMD5 = builder.contentMD5;
        this.checksumAlgorithm = builder.checksumAlgorithm;
        this.metadataTableConfiguration = builder.metadataTableConfiguration;
        this.expectedBucketOwner = builder.expectedBucketOwner;
    }

    /**
     * <p>
     * The general purpose bucket that you want to create the metadata table configuration in.
     * </p>
     * 
     * @return The general purpose bucket that you want to create the metadata table configuration in.
     */
    public final String bucket() {
        return bucket;
    }

    /**
     * <p>
     * The <code>Content-MD5</code> header for the metadata table configuration.
     * </p>
     * 
     * @return The <code>Content-MD5</code> header for the metadata table configuration.
     */
    public final String contentMD5() {
        return contentMD5;
    }

    /**
     * <p>
     * The checksum algorithm to use with your metadata table configuration.
     * </p>
     * <p>
     * If the service returns an enum value that is not available in the current SDK version, {@link #checksumAlgorithm}
     * will return {@link ChecksumAlgorithm#UNKNOWN_TO_SDK_VERSION}. The raw value returned by the service is available
     * from {@link #checksumAlgorithmAsString}.
     * </p>
     * 
     * @return The checksum algorithm to use with your metadata table configuration.
     * @see ChecksumAlgorithm
     */
    public final ChecksumAlgorithm checksumAlgorithm() {
        return ChecksumAlgorithm.fromValue(checksumAlgorithm);
    }

    /**
     * <p>
     * The checksum algorithm to use with your metadata table configuration.
     * </p>
     * <p>
     * If the service returns an enum value that is not available in the current SDK version, {@link #checksumAlgorithm}
     * will return {@link ChecksumAlgorithm#UNKNOWN_TO_SDK_VERSION}. The raw value returned by the service is available
     * from {@link #checksumAlgorithmAsString}.
     * </p>
     * 
     * @return The checksum algorithm to use with your metadata table configuration.
     * @see ChecksumAlgorithm
     */
    public final String checksumAlgorithmAsString() {
        return checksumAlgorithm;
    }

    /**
     * <p>
     * The contents of your metadata table configuration.
     * </p>
     * 
     * @return The contents of your metadata table configuration.
     */
    public final MetadataTableConfiguration metadataTableConfiguration() {
        return metadataTableConfiguration;
    }

    /**
     * <p>
     * The expected owner of the general purpose bucket that contains your metadata table configuration.
     * </p>
     * 
     * @return The expected owner of the general purpose bucket that contains your metadata table configuration.
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
        hashCode = 31 * hashCode + Objects.hashCode(contentMD5());
        hashCode = 31 * hashCode + Objects.hashCode(checksumAlgorithmAsString());
        hashCode = 31 * hashCode + Objects.hashCode(metadataTableConfiguration());
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
        if (!(obj instanceof CreateBucketMetadataTableConfigurationRequest)) {
            return false;
        }
        CreateBucketMetadataTableConfigurationRequest other = (CreateBucketMetadataTableConfigurationRequest) obj;
        return Objects.equals(bucket(), other.bucket()) && Objects.equals(contentMD5(), other.contentMD5())
                && Objects.equals(checksumAlgorithmAsString(), other.checksumAlgorithmAsString())
                && Objects.equals(metadataTableConfiguration(), other.metadataTableConfiguration())
                && Objects.equals(expectedBucketOwner(), other.expectedBucketOwner());
    }

    /**
     * Returns a string representation of this object. This is useful for testing and debugging. Sensitive data will be
     * redacted from this string using a placeholder value.
     */
    @Override
    public final String toString() {
        return ToString.builder("CreateBucketMetadataTableConfigurationRequest").add("Bucket", bucket())
                .add("ContentMD5", contentMD5()).add("ChecksumAlgorithm", checksumAlgorithmAsString())
                .add("MetadataTableConfiguration", metadataTableConfiguration())
                .add("ExpectedBucketOwner", expectedBucketOwner()).build();
    }

    public final <T> Optional<T> getValueForField(String fieldName, Class<T> clazz) {
        switch (fieldName) {
        case "Bucket":
            return Optional.ofNullable(clazz.cast(bucket()));
        case "ContentMD5":
            return Optional.ofNullable(clazz.cast(contentMD5()));
        case "ChecksumAlgorithm":
            return Optional.ofNullable(clazz.cast(checksumAlgorithmAsString()));
        case "MetadataTableConfiguration":
            return Optional.ofNullable(clazz.cast(metadataTableConfiguration()));
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
        map.put("Content-MD5", CONTENT_MD5_FIELD);
        map.put("x-amz-sdk-checksum-algorithm", CHECKSUM_ALGORITHM_FIELD);
        map.put("MetadataTableConfiguration", METADATA_TABLE_CONFIGURATION_FIELD);
        map.put("x-amz-expected-bucket-owner", EXPECTED_BUCKET_OWNER_FIELD);
        return Collections.unmodifiableMap(map);
    }

    private static <T> Function<Object, T> getter(Function<CreateBucketMetadataTableConfigurationRequest, T> g) {
        return obj -> g.apply((CreateBucketMetadataTableConfigurationRequest) obj);
    }

    private static <T> BiConsumer<Object, T> setter(BiConsumer<Builder, T> s) {
        return (obj, val) -> s.accept((Builder) obj, val);
    }

    @Mutable
    @NotThreadSafe
    public interface Builder extends S3Request.Builder, SdkPojo,
            CopyableBuilder<Builder, CreateBucketMetadataTableConfigurationRequest> {
        /**
         * <p>
         * The general purpose bucket that you want to create the metadata table configuration in.
         * </p>
         * 
         * @param bucket
         *        The general purpose bucket that you want to create the metadata table configuration in.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder bucket(String bucket);

        /**
         * <p>
         * The <code>Content-MD5</code> header for the metadata table configuration.
         * </p>
         * 
         * @param contentMD5
         *        The <code>Content-MD5</code> header for the metadata table configuration.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder contentMD5(String contentMD5);

        /**
         * <p>
         * The checksum algorithm to use with your metadata table configuration.
         * </p>
         * 
         * @param checksumAlgorithm
         *        The checksum algorithm to use with your metadata table configuration.
         * @see ChecksumAlgorithm
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see ChecksumAlgorithm
         */
        Builder checksumAlgorithm(String checksumAlgorithm);

        /**
         * <p>
         * The checksum algorithm to use with your metadata table configuration.
         * </p>
         * 
         * @param checksumAlgorithm
         *        The checksum algorithm to use with your metadata table configuration.
         * @see ChecksumAlgorithm
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see ChecksumAlgorithm
         */
        Builder checksumAlgorithm(ChecksumAlgorithm checksumAlgorithm);

        /**
         * <p>
         * The contents of your metadata table configuration.
         * </p>
         * 
         * @param metadataTableConfiguration
         *        The contents of your metadata table configuration.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder metadataTableConfiguration(MetadataTableConfiguration metadataTableConfiguration);

        /**
         * <p>
         * The contents of your metadata table configuration.
         * </p>
         * This is a convenience method that creates an instance of the {@link MetadataTableConfiguration.Builder}
         * avoiding the need to create one manually via {@link MetadataTableConfiguration#builder()}.
         *
         * <p>
         * When the {@link Consumer} completes, {@link MetadataTableConfiguration.Builder#build()} is called immediately
         * and its result is passed to {@link #metadataTableConfiguration(MetadataTableConfiguration)}.
         * 
         * @param metadataTableConfiguration
         *        a consumer that will call methods on {@link MetadataTableConfiguration.Builder}
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see #metadataTableConfiguration(MetadataTableConfiguration)
         */
        default Builder metadataTableConfiguration(Consumer<MetadataTableConfiguration.Builder> metadataTableConfiguration) {
            return metadataTableConfiguration(MetadataTableConfiguration.builder().applyMutation(metadataTableConfiguration)
                    .build());
        }

        /**
         * <p>
         * The expected owner of the general purpose bucket that contains your metadata table configuration.
         * </p>
         * 
         * @param expectedBucketOwner
         *        The expected owner of the general purpose bucket that contains your metadata table configuration.
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

        private String contentMD5;

        private String checksumAlgorithm;

        private MetadataTableConfiguration metadataTableConfiguration;

        private String expectedBucketOwner;

        private BuilderImpl() {
        }

        private BuilderImpl(CreateBucketMetadataTableConfigurationRequest model) {
            super(model);
            bucket(model.bucket);
            contentMD5(model.contentMD5);
            checksumAlgorithm(model.checksumAlgorithm);
            metadataTableConfiguration(model.metadataTableConfiguration);
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

        public final String getContentMD5() {
            return contentMD5;
        }

        public final void setContentMD5(String contentMD5) {
            this.contentMD5 = contentMD5;
        }

        @Override
        public final Builder contentMD5(String contentMD5) {
            this.contentMD5 = contentMD5;
            return this;
        }

        public final String getChecksumAlgorithm() {
            return checksumAlgorithm;
        }

        public final void setChecksumAlgorithm(String checksumAlgorithm) {
            this.checksumAlgorithm = checksumAlgorithm;
        }

        @Override
        public final Builder checksumAlgorithm(String checksumAlgorithm) {
            this.checksumAlgorithm = checksumAlgorithm;
            return this;
        }

        @Override
        public final Builder checksumAlgorithm(ChecksumAlgorithm checksumAlgorithm) {
            this.checksumAlgorithm(checksumAlgorithm == null ? null : checksumAlgorithm.toString());
            return this;
        }

        public final MetadataTableConfiguration.Builder getMetadataTableConfiguration() {
            return metadataTableConfiguration != null ? metadataTableConfiguration.toBuilder() : null;
        }

        public final void setMetadataTableConfiguration(MetadataTableConfiguration.BuilderImpl metadataTableConfiguration) {
            this.metadataTableConfiguration = metadataTableConfiguration != null ? metadataTableConfiguration.build() : null;
        }

        @Override
        public final Builder metadataTableConfiguration(MetadataTableConfiguration metadataTableConfiguration) {
            this.metadataTableConfiguration = metadataTableConfiguration;
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
        public CreateBucketMetadataTableConfigurationRequest build() {
            return new CreateBucketMetadataTableConfigurationRequest(this);
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
