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
import com.ibm.cos.v2.core.traits.RequiredTrait;
import com.ibm.cos.v2.utils.ToString;
import com.ibm.cos.v2.utils.builder.CopyableBuilder;
import com.ibm.cos.v2.utils.builder.ToCopyableBuilder;

/**
 */
@Generated("com.ibm.cos.v2:codegen")
public final class GetBucketEncryptionRequest extends S3Request implements
        ToCopyableBuilder<GetBucketEncryptionRequest.Builder, GetBucketEncryptionRequest> {
    private static final SdkField<String> BUCKET_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("Bucket")
            .getter(getter(GetBucketEncryptionRequest::bucket))
            .setter(setter(Builder::bucket))
            .traits(LocationTrait.builder().location(MarshallLocation.PATH).locationName("Bucket")
                    .unmarshallLocationName("Bucket").build(), RequiredTrait.create()).build();

    private static final SdkField<String> EXPECTED_BUCKET_OWNER_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("ExpectedBucketOwner")
            .getter(getter(GetBucketEncryptionRequest::expectedBucketOwner))
            .setter(setter(Builder::expectedBucketOwner))
            .traits(LocationTrait.builder().location(MarshallLocation.HEADER).locationName("x-amz-expected-bucket-owner")
                    .unmarshallLocationName("x-amz-expected-bucket-owner").build()).build();

    private static final List<SdkField<?>> SDK_FIELDS = Collections.unmodifiableList(Arrays.asList(BUCKET_FIELD,
            EXPECTED_BUCKET_OWNER_FIELD));

    private static final Map<String, SdkField<?>> SDK_NAME_TO_FIELD = memberNameToFieldInitializer();

    private final String bucket;

    private final String expectedBucketOwner;

    private GetBucketEncryptionRequest(BuilderImpl builder) {
        super(builder);
        this.bucket = builder.bucket;
        this.expectedBucketOwner = builder.expectedBucketOwner;
    }

    /**
     * <p>
     * The name of the bucket from which the server-side encryption configuration is retrieved.
     * </p>
     * <p>
     * <b>Directory buckets </b> - When you use this operation with a directory bucket, you must use path-style requests
     * in the format <code>https://s3express-control.<i>region-code</i>.amazonaws.com/<i>bucket-name</i> </code>.
     * Virtual-hosted-style requests aren't supported. Directory bucket names must be unique in the chosen Zone
     * (Availability Zone or Local Zone). Bucket names must also follow the format
     * <code> <i>bucket-base-name</i>--<i>zone-id</i>--x-s3</code> (for example,
     * <code> <i>DOC-EXAMPLE-BUCKET</i>--<i>usw2-az1</i>--x-s3</code>). For information about bucket naming
     * restrictions, see <a
     * href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/directory-bucket-naming-rules.html">Directory bucket
     * naming rules</a> in the <i>Amazon S3 User Guide</i>
     * </p>
     * 
     * @return The name of the bucket from which the server-side encryption configuration is retrieved.</p>
     *         <p>
     *         <b>Directory buckets </b> - When you use this operation with a directory bucket, you must use path-style
     *         requests in the format
     *         <code>https://s3express-control.<i>region-code</i>.amazonaws.com/<i>bucket-name</i> </code>.
     *         Virtual-hosted-style requests aren't supported. Directory bucket names must be unique in the chosen Zone
     *         (Availability Zone or Local Zone). Bucket names must also follow the format
     *         <code> <i>bucket-base-name</i>--<i>zone-id</i>--x-s3</code> (for example,
     *         <code> <i>DOC-EXAMPLE-BUCKET</i>--<i>usw2-az1</i>--x-s3</code>). For information about bucket naming
     *         restrictions, see <a
     *         href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/directory-bucket-naming-rules.html">Directory
     *         bucket naming rules</a> in the <i>Amazon S3 User Guide</i>
     */
    public final String bucket() {
        return bucket;
    }

    /**
     * <p>
     * The account ID of the expected bucket owner. If the account ID that you provide does not match the actual owner
     * of the bucket, the request fails with the HTTP status code <code>403 Forbidden</code> (access denied).
     * </p>
     * <note>
     * <p>
     * For directory buckets, this header is not supported in this API operation. If you specify this header, the
     * request fails with the HTTP status code <code>501 Not Implemented</code>.
     * </p>
     * </note>
     * 
     * @return The account ID of the expected bucket owner. If the account ID that you provide does not match the actual
     *         owner of the bucket, the request fails with the HTTP status code <code>403 Forbidden</code> (access
     *         denied).</p> <note>
     *         <p>
     *         For directory buckets, this header is not supported in this API operation. If you specify this header,
     *         the request fails with the HTTP status code <code>501 Not Implemented</code>.
     *         </p>
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
        if (!(obj instanceof GetBucketEncryptionRequest)) {
            return false;
        }
        GetBucketEncryptionRequest other = (GetBucketEncryptionRequest) obj;
        return Objects.equals(bucket(), other.bucket()) && Objects.equals(expectedBucketOwner(), other.expectedBucketOwner());
    }

    /**
     * Returns a string representation of this object. This is useful for testing and debugging. Sensitive data will be
     * redacted from this string using a placeholder value.
     */
    @Override
    public final String toString() {
        return ToString.builder("GetBucketEncryptionRequest").add("Bucket", bucket())
                .add("ExpectedBucketOwner", expectedBucketOwner()).build();
    }

    public final <T> Optional<T> getValueForField(String fieldName, Class<T> clazz) {
        switch (fieldName) {
        case "Bucket":
            return Optional.ofNullable(clazz.cast(bucket()));
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
        map.put("x-amz-expected-bucket-owner", EXPECTED_BUCKET_OWNER_FIELD);
        return Collections.unmodifiableMap(map);
    }

    private static <T> Function<Object, T> getter(Function<GetBucketEncryptionRequest, T> g) {
        return obj -> g.apply((GetBucketEncryptionRequest) obj);
    }

    private static <T> BiConsumer<Object, T> setter(BiConsumer<Builder, T> s) {
        return (obj, val) -> s.accept((Builder) obj, val);
    }

    @Mutable
    @NotThreadSafe
    public interface Builder extends S3Request.Builder, SdkPojo, CopyableBuilder<Builder, GetBucketEncryptionRequest> {
        /**
         * <p>
         * The name of the bucket from which the server-side encryption configuration is retrieved.
         * </p>
         * <p>
         * <b>Directory buckets </b> - When you use this operation with a directory bucket, you must use path-style
         * requests in the format
         * <code>https://s3express-control.<i>region-code</i>.amazonaws.com/<i>bucket-name</i> </code>.
         * Virtual-hosted-style requests aren't supported. Directory bucket names must be unique in the chosen Zone
         * (Availability Zone or Local Zone). Bucket names must also follow the format
         * <code> <i>bucket-base-name</i>--<i>zone-id</i>--x-s3</code> (for example,
         * <code> <i>DOC-EXAMPLE-BUCKET</i>--<i>usw2-az1</i>--x-s3</code>). For information about bucket naming
         * restrictions, see <a
         * href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/directory-bucket-naming-rules.html">Directory
         * bucket naming rules</a> in the <i>Amazon S3 User Guide</i>
         * </p>
         * 
         * @param bucket
         *        The name of the bucket from which the server-side encryption configuration is retrieved.</p>
         *        <p>
         *        <b>Directory buckets </b> - When you use this operation with a directory bucket, you must use
         *        path-style requests in the format
         *        <code>https://s3express-control.<i>region-code</i>.amazonaws.com/<i>bucket-name</i> </code>.
         *        Virtual-hosted-style requests aren't supported. Directory bucket names must be unique in the chosen
         *        Zone (Availability Zone or Local Zone). Bucket names must also follow the format
         *        <code> <i>bucket-base-name</i>--<i>zone-id</i>--x-s3</code> (for example,
         *        <code> <i>DOC-EXAMPLE-BUCKET</i>--<i>usw2-az1</i>--x-s3</code>). For information about bucket naming
         *        restrictions, see <a
         *        href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/directory-bucket-naming-rules.html"
         *        >Directory bucket naming rules</a> in the <i>Amazon S3 User Guide</i>
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder bucket(String bucket);

        /**
         * <p>
         * The account ID of the expected bucket owner. If the account ID that you provide does not match the actual
         * owner of the bucket, the request fails with the HTTP status code <code>403 Forbidden</code> (access denied).
         * </p>
         * <note>
         * <p>
         * For directory buckets, this header is not supported in this API operation. If you specify this header, the
         * request fails with the HTTP status code <code>501 Not Implemented</code>.
         * </p>
         * </note>
         * 
         * @param expectedBucketOwner
         *        The account ID of the expected bucket owner. If the account ID that you provide does not match the
         *        actual owner of the bucket, the request fails with the HTTP status code <code>403 Forbidden</code>
         *        (access denied).</p> <note>
         *        <p>
         *        For directory buckets, this header is not supported in this API operation. If you specify this header,
         *        the request fails with the HTTP status code <code>501 Not Implemented</code>.
         *        </p>
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

        private String expectedBucketOwner;

        private BuilderImpl() {
        }

        private BuilderImpl(GetBucketEncryptionRequest model) {
            super(model);
            bucket(model.bucket);
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
        public GetBucketEncryptionRequest build() {
            return new GetBucketEncryptionRequest(this);
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
