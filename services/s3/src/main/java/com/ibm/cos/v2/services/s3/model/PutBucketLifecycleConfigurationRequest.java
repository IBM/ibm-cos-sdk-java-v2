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
public final class PutBucketLifecycleConfigurationRequest extends S3Request implements
        ToCopyableBuilder<PutBucketLifecycleConfigurationRequest.Builder, PutBucketLifecycleConfigurationRequest> {
    private static final SdkField<String> BUCKET_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("Bucket")
            .getter(getter(PutBucketLifecycleConfigurationRequest::bucket))
            .setter(setter(Builder::bucket))
            .traits(LocationTrait.builder().location(MarshallLocation.PATH).locationName("Bucket")
                    .unmarshallLocationName("Bucket").build(), RequiredTrait.create()).build();

    private static final SdkField<String> CHECKSUM_ALGORITHM_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("ChecksumAlgorithm")
            .getter(getter(PutBucketLifecycleConfigurationRequest::checksumAlgorithmAsString))
            .setter(setter(Builder::checksumAlgorithm))
            .traits(LocationTrait.builder().location(MarshallLocation.HEADER).locationName("x-amz-sdk-checksum-algorithm")
                    .unmarshallLocationName("x-amz-sdk-checksum-algorithm").build()).build();

    private static final SdkField<BucketLifecycleConfiguration> LIFECYCLE_CONFIGURATION_FIELD = SdkField
            .<BucketLifecycleConfiguration> builder(MarshallingType.SDK_POJO)
            .memberName("LifecycleConfiguration")
            .getter(getter(PutBucketLifecycleConfigurationRequest::lifecycleConfiguration))
            .setter(setter(Builder::lifecycleConfiguration))
            .constructor(BucketLifecycleConfiguration::builder)
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("LifecycleConfiguration")
                    .unmarshallLocationName("LifecycleConfiguration").build(), PayloadTrait.create()).build();

    private static final SdkField<String> EXPECTED_BUCKET_OWNER_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("ExpectedBucketOwner")
            .getter(getter(PutBucketLifecycleConfigurationRequest::expectedBucketOwner))
            .setter(setter(Builder::expectedBucketOwner))
            .traits(LocationTrait.builder().location(MarshallLocation.HEADER).locationName("x-amz-expected-bucket-owner")
                    .unmarshallLocationName("x-amz-expected-bucket-owner").build()).build();

    private static final SdkField<String> TRANSITION_DEFAULT_MINIMUM_OBJECT_SIZE_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("TransitionDefaultMinimumObjectSize")
            .getter(getter(PutBucketLifecycleConfigurationRequest::transitionDefaultMinimumObjectSizeAsString))
            .setter(setter(Builder::transitionDefaultMinimumObjectSize))
            .traits(LocationTrait.builder().location(MarshallLocation.HEADER)
                    .locationName("x-amz-transition-default-minimum-object-size")
                    .unmarshallLocationName("x-amz-transition-default-minimum-object-size").build()).build();

    private static final List<SdkField<?>> SDK_FIELDS = Collections.unmodifiableList(Arrays.asList(BUCKET_FIELD,
            CHECKSUM_ALGORITHM_FIELD, LIFECYCLE_CONFIGURATION_FIELD, EXPECTED_BUCKET_OWNER_FIELD,
            TRANSITION_DEFAULT_MINIMUM_OBJECT_SIZE_FIELD));

    private static final Map<String, SdkField<?>> SDK_NAME_TO_FIELD = memberNameToFieldInitializer();

    private final String bucket;

    private final String checksumAlgorithm;

    private final BucketLifecycleConfiguration lifecycleConfiguration;

    private final String expectedBucketOwner;

    private final String transitionDefaultMinimumObjectSize;

    private PutBucketLifecycleConfigurationRequest(BuilderImpl builder) {
        super(builder);
        this.bucket = builder.bucket;
        this.checksumAlgorithm = builder.checksumAlgorithm;
        this.lifecycleConfiguration = builder.lifecycleConfiguration;
        this.expectedBucketOwner = builder.expectedBucketOwner;
        this.transitionDefaultMinimumObjectSize = builder.transitionDefaultMinimumObjectSize;
    }

    /**
     * <p>
     * The name of the bucket for which to set the configuration.
     * </p>
     * 
     * @return The name of the bucket for which to set the configuration.
     */
    public final String bucket() {
        return bucket;
    }

    /**
     * <p>
     * Indicates the algorithm used to create the checksum for the request when you use the SDK. This header will not
     * provide any additional functionality if you don't use the SDK. When you send this header, there must be a
     * corresponding <code>x-amz-checksum</code> or <code>x-amz-trailer</code> header sent. Otherwise, Amazon S3 fails
     * the request with the HTTP status code <code>400 Bad Request</code>. For more information, see <a
     * href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/checking-object-integrity.html">Checking object
     * integrity</a> in the <i>Amazon S3 User Guide</i>.
     * </p>
     * <p>
     * If you provide an individual checksum, Amazon S3 ignores any provided <code>ChecksumAlgorithm</code> parameter.
     * </p>
     * <p>
     * If the service returns an enum value that is not available in the current SDK version, {@link #checksumAlgorithm}
     * will return {@link ChecksumAlgorithm#UNKNOWN_TO_SDK_VERSION}. The raw value returned by the service is available
     * from {@link #checksumAlgorithmAsString}.
     * </p>
     * 
     * @return Indicates the algorithm used to create the checksum for the request when you use the SDK. This header
     *         will not provide any additional functionality if you don't use the SDK. When you send this header, there
     *         must be a corresponding <code>x-amz-checksum</code> or <code>x-amz-trailer</code> header sent. Otherwise,
     *         Amazon S3 fails the request with the HTTP status code <code>400 Bad Request</code>. For more information,
     *         see <a
     *         href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/checking-object-integrity.html">Checking
     *         object integrity</a> in the <i>Amazon S3 User Guide</i>.</p>
     *         <p>
     *         If you provide an individual checksum, Amazon S3 ignores any provided <code>ChecksumAlgorithm</code>
     *         parameter.
     * @see ChecksumAlgorithm
     */
    public final ChecksumAlgorithm checksumAlgorithm() {
        return ChecksumAlgorithm.fromValue(checksumAlgorithm);
    }

    /**
     * <p>
     * Indicates the algorithm used to create the checksum for the request when you use the SDK. This header will not
     * provide any additional functionality if you don't use the SDK. When you send this header, there must be a
     * corresponding <code>x-amz-checksum</code> or <code>x-amz-trailer</code> header sent. Otherwise, Amazon S3 fails
     * the request with the HTTP status code <code>400 Bad Request</code>. For more information, see <a
     * href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/checking-object-integrity.html">Checking object
     * integrity</a> in the <i>Amazon S3 User Guide</i>.
     * </p>
     * <p>
     * If you provide an individual checksum, Amazon S3 ignores any provided <code>ChecksumAlgorithm</code> parameter.
     * </p>
     * <p>
     * If the service returns an enum value that is not available in the current SDK version, {@link #checksumAlgorithm}
     * will return {@link ChecksumAlgorithm#UNKNOWN_TO_SDK_VERSION}. The raw value returned by the service is available
     * from {@link #checksumAlgorithmAsString}.
     * </p>
     * 
     * @return Indicates the algorithm used to create the checksum for the request when you use the SDK. This header
     *         will not provide any additional functionality if you don't use the SDK. When you send this header, there
     *         must be a corresponding <code>x-amz-checksum</code> or <code>x-amz-trailer</code> header sent. Otherwise,
     *         Amazon S3 fails the request with the HTTP status code <code>400 Bad Request</code>. For more information,
     *         see <a
     *         href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/checking-object-integrity.html">Checking
     *         object integrity</a> in the <i>Amazon S3 User Guide</i>.</p>
     *         <p>
     *         If you provide an individual checksum, Amazon S3 ignores any provided <code>ChecksumAlgorithm</code>
     *         parameter.
     * @see ChecksumAlgorithm
     */
    public final String checksumAlgorithmAsString() {
        return checksumAlgorithm;
    }

    /**
     * <p>
     * Container for lifecycle rules. You can add as many as 1,000 rules.
     * </p>
     * 
     * @return Container for lifecycle rules. You can add as many as 1,000 rules.
     */
    public final BucketLifecycleConfiguration lifecycleConfiguration() {
        return lifecycleConfiguration;
    }

    /**
     * <p>
     * The account ID of the expected bucket owner. If the account ID that you provide does not match the actual owner
     * of the bucket, the request fails with the HTTP status code <code>403 Forbidden</code> (access denied).
     * </p>
     * <note>
     * <p>
     * This parameter applies to general purpose buckets only. It is not supported for directory bucket lifecycle
     * configurations.
     * </p>
     * </note>
     * 
     * @return The account ID of the expected bucket owner. If the account ID that you provide does not match the actual
     *         owner of the bucket, the request fails with the HTTP status code <code>403 Forbidden</code> (access
     *         denied).</p> <note>
     *         <p>
     *         This parameter applies to general purpose buckets only. It is not supported for directory bucket
     *         lifecycle configurations.
     *         </p>
     */
    public final String expectedBucketOwner() {
        return expectedBucketOwner;
    }

    /**
     * <p>
     * Indicates which default minimum object size behavior is applied to the lifecycle configuration.
     * </p>
     * <note>
     * <p>
     * This parameter applies to general purpose buckets only. It is not supported for directory bucket lifecycle
     * configurations.
     * </p>
     * </note>
     * <ul>
     * <li>
     * <p>
     * <code>all_storage_classes_128K</code> - Objects smaller than 128 KB will not transition to any storage class by
     * default.
     * </p>
     * </li>
     * <li>
     * <p>
     * <code>varies_by_storage_class</code> - Objects smaller than 128 KB will transition to Glacier Flexible Retrieval
     * or Glacier Deep Archive storage classes. By default, all other storage classes will prevent transitions smaller
     * than 128 KB.
     * </p>
     * </li>
     * </ul>
     * <p>
     * To customize the minimum object size for any transition you can add a filter that specifies a custom
     * <code>ObjectSizeGreaterThan</code> or <code>ObjectSizeLessThan</code> in the body of your transition rule. Custom
     * filters always take precedence over the default transition behavior.
     * </p>
     * <p>
     * If the service returns an enum value that is not available in the current SDK version,
     * {@link #transitionDefaultMinimumObjectSize} will return
     * {@link TransitionDefaultMinimumObjectSize#UNKNOWN_TO_SDK_VERSION}. The raw value returned by the service is
     * available from {@link #transitionDefaultMinimumObjectSizeAsString}.
     * </p>
     * 
     * @return Indicates which default minimum object size behavior is applied to the lifecycle configuration.</p>
     *         <note>
     *         <p>
     *         This parameter applies to general purpose buckets only. It is not supported for directory bucket
     *         lifecycle configurations.
     *         </p>
     *         </note>
     *         <ul>
     *         <li>
     *         <p>
     *         <code>all_storage_classes_128K</code> - Objects smaller than 128 KB will not transition to any storage
     *         class by default.
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         <code>varies_by_storage_class</code> - Objects smaller than 128 KB will transition to Glacier Flexible
     *         Retrieval or Glacier Deep Archive storage classes. By default, all other storage classes will prevent
     *         transitions smaller than 128 KB.
     *         </p>
     *         </li>
     *         </ul>
     *         <p>
     *         To customize the minimum object size for any transition you can add a filter that specifies a custom
     *         <code>ObjectSizeGreaterThan</code> or <code>ObjectSizeLessThan</code> in the body of your transition
     *         rule. Custom filters always take precedence over the default transition behavior.
     * @see TransitionDefaultMinimumObjectSize
     */
    public final TransitionDefaultMinimumObjectSize transitionDefaultMinimumObjectSize() {
        return TransitionDefaultMinimumObjectSize.fromValue(transitionDefaultMinimumObjectSize);
    }

    /**
     * <p>
     * Indicates which default minimum object size behavior is applied to the lifecycle configuration.
     * </p>
     * <note>
     * <p>
     * This parameter applies to general purpose buckets only. It is not supported for directory bucket lifecycle
     * configurations.
     * </p>
     * </note>
     * <ul>
     * <li>
     * <p>
     * <code>all_storage_classes_128K</code> - Objects smaller than 128 KB will not transition to any storage class by
     * default.
     * </p>
     * </li>
     * <li>
     * <p>
     * <code>varies_by_storage_class</code> - Objects smaller than 128 KB will transition to Glacier Flexible Retrieval
     * or Glacier Deep Archive storage classes. By default, all other storage classes will prevent transitions smaller
     * than 128 KB.
     * </p>
     * </li>
     * </ul>
     * <p>
     * To customize the minimum object size for any transition you can add a filter that specifies a custom
     * <code>ObjectSizeGreaterThan</code> or <code>ObjectSizeLessThan</code> in the body of your transition rule. Custom
     * filters always take precedence over the default transition behavior.
     * </p>
     * <p>
     * If the service returns an enum value that is not available in the current SDK version,
     * {@link #transitionDefaultMinimumObjectSize} will return
     * {@link TransitionDefaultMinimumObjectSize#UNKNOWN_TO_SDK_VERSION}. The raw value returned by the service is
     * available from {@link #transitionDefaultMinimumObjectSizeAsString}.
     * </p>
     * 
     * @return Indicates which default minimum object size behavior is applied to the lifecycle configuration.</p>
     *         <note>
     *         <p>
     *         This parameter applies to general purpose buckets only. It is not supported for directory bucket
     *         lifecycle configurations.
     *         </p>
     *         </note>
     *         <ul>
     *         <li>
     *         <p>
     *         <code>all_storage_classes_128K</code> - Objects smaller than 128 KB will not transition to any storage
     *         class by default.
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         <code>varies_by_storage_class</code> - Objects smaller than 128 KB will transition to Glacier Flexible
     *         Retrieval or Glacier Deep Archive storage classes. By default, all other storage classes will prevent
     *         transitions smaller than 128 KB.
     *         </p>
     *         </li>
     *         </ul>
     *         <p>
     *         To customize the minimum object size for any transition you can add a filter that specifies a custom
     *         <code>ObjectSizeGreaterThan</code> or <code>ObjectSizeLessThan</code> in the body of your transition
     *         rule. Custom filters always take precedence over the default transition behavior.
     * @see TransitionDefaultMinimumObjectSize
     */
    public final String transitionDefaultMinimumObjectSizeAsString() {
        return transitionDefaultMinimumObjectSize;
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
        hashCode = 31 * hashCode + Objects.hashCode(checksumAlgorithmAsString());
        hashCode = 31 * hashCode + Objects.hashCode(lifecycleConfiguration());
        hashCode = 31 * hashCode + Objects.hashCode(expectedBucketOwner());
        hashCode = 31 * hashCode + Objects.hashCode(transitionDefaultMinimumObjectSizeAsString());
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
        if (!(obj instanceof PutBucketLifecycleConfigurationRequest)) {
            return false;
        }
        PutBucketLifecycleConfigurationRequest other = (PutBucketLifecycleConfigurationRequest) obj;
        return Objects.equals(bucket(), other.bucket())
                && Objects.equals(checksumAlgorithmAsString(), other.checksumAlgorithmAsString())
                && Objects.equals(lifecycleConfiguration(), other.lifecycleConfiguration())
                && Objects.equals(expectedBucketOwner(), other.expectedBucketOwner())
                && Objects.equals(transitionDefaultMinimumObjectSizeAsString(),
                        other.transitionDefaultMinimumObjectSizeAsString());
    }

    /**
     * Returns a string representation of this object. This is useful for testing and debugging. Sensitive data will be
     * redacted from this string using a placeholder value.
     */
    @Override
    public final String toString() {
        return ToString.builder("PutBucketLifecycleConfigurationRequest").add("Bucket", bucket())
                .add("ChecksumAlgorithm", checksumAlgorithmAsString()).add("LifecycleConfiguration", lifecycleConfiguration())
                .add("ExpectedBucketOwner", expectedBucketOwner())
                .add("TransitionDefaultMinimumObjectSize", transitionDefaultMinimumObjectSizeAsString()).build();
    }

    public final <T> Optional<T> getValueForField(String fieldName, Class<T> clazz) {
        switch (fieldName) {
        case "Bucket":
            return Optional.ofNullable(clazz.cast(bucket()));
        case "ChecksumAlgorithm":
            return Optional.ofNullable(clazz.cast(checksumAlgorithmAsString()));
        case "LifecycleConfiguration":
            return Optional.ofNullable(clazz.cast(lifecycleConfiguration()));
        case "ExpectedBucketOwner":
            return Optional.ofNullable(clazz.cast(expectedBucketOwner()));
        case "TransitionDefaultMinimumObjectSize":
            return Optional.ofNullable(clazz.cast(transitionDefaultMinimumObjectSizeAsString()));
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
        map.put("x-amz-sdk-checksum-algorithm", CHECKSUM_ALGORITHM_FIELD);
        map.put("LifecycleConfiguration", LIFECYCLE_CONFIGURATION_FIELD);
        map.put("x-amz-expected-bucket-owner", EXPECTED_BUCKET_OWNER_FIELD);
        map.put("x-amz-transition-default-minimum-object-size", TRANSITION_DEFAULT_MINIMUM_OBJECT_SIZE_FIELD);
        return Collections.unmodifiableMap(map);
    }

    private static <T> Function<Object, T> getter(Function<PutBucketLifecycleConfigurationRequest, T> g) {
        return obj -> g.apply((PutBucketLifecycleConfigurationRequest) obj);
    }

    private static <T> BiConsumer<Object, T> setter(BiConsumer<Builder, T> s) {
        return (obj, val) -> s.accept((Builder) obj, val);
    }

    @Mutable
    @NotThreadSafe
    public interface Builder extends S3Request.Builder, SdkPojo, CopyableBuilder<Builder, PutBucketLifecycleConfigurationRequest> {
        /**
         * <p>
         * The name of the bucket for which to set the configuration.
         * </p>
         * 
         * @param bucket
         *        The name of the bucket for which to set the configuration.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder bucket(String bucket);

        /**
         * <p>
         * Indicates the algorithm used to create the checksum for the request when you use the SDK. This header will
         * not provide any additional functionality if you don't use the SDK. When you send this header, there must be a
         * corresponding <code>x-amz-checksum</code> or <code>x-amz-trailer</code> header sent. Otherwise, Amazon S3
         * fails the request with the HTTP status code <code>400 Bad Request</code>. For more information, see <a
         * href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/checking-object-integrity.html">Checking object
         * integrity</a> in the <i>Amazon S3 User Guide</i>.
         * </p>
         * <p>
         * If you provide an individual checksum, Amazon S3 ignores any provided <code>ChecksumAlgorithm</code>
         * parameter.
         * </p>
         * 
         * @param checksumAlgorithm
         *        Indicates the algorithm used to create the checksum for the request when you use the SDK. This header
         *        will not provide any additional functionality if you don't use the SDK. When you send this header,
         *        there must be a corresponding <code>x-amz-checksum</code> or <code>x-amz-trailer</code> header sent.
         *        Otherwise, Amazon S3 fails the request with the HTTP status code <code>400 Bad Request</code>. For
         *        more information, see <a
         *        href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/checking-object-integrity.html">Checking
         *        object integrity</a> in the <i>Amazon S3 User Guide</i>.</p>
         *        <p>
         *        If you provide an individual checksum, Amazon S3 ignores any provided <code>ChecksumAlgorithm</code>
         *        parameter.
         * @see ChecksumAlgorithm
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see ChecksumAlgorithm
         */
        Builder checksumAlgorithm(String checksumAlgorithm);

        /**
         * <p>
         * Indicates the algorithm used to create the checksum for the request when you use the SDK. This header will
         * not provide any additional functionality if you don't use the SDK. When you send this header, there must be a
         * corresponding <code>x-amz-checksum</code> or <code>x-amz-trailer</code> header sent. Otherwise, Amazon S3
         * fails the request with the HTTP status code <code>400 Bad Request</code>. For more information, see <a
         * href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/checking-object-integrity.html">Checking object
         * integrity</a> in the <i>Amazon S3 User Guide</i>.
         * </p>
         * <p>
         * If you provide an individual checksum, Amazon S3 ignores any provided <code>ChecksumAlgorithm</code>
         * parameter.
         * </p>
         * 
         * @param checksumAlgorithm
         *        Indicates the algorithm used to create the checksum for the request when you use the SDK. This header
         *        will not provide any additional functionality if you don't use the SDK. When you send this header,
         *        there must be a corresponding <code>x-amz-checksum</code> or <code>x-amz-trailer</code> header sent.
         *        Otherwise, Amazon S3 fails the request with the HTTP status code <code>400 Bad Request</code>. For
         *        more information, see <a
         *        href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/checking-object-integrity.html">Checking
         *        object integrity</a> in the <i>Amazon S3 User Guide</i>.</p>
         *        <p>
         *        If you provide an individual checksum, Amazon S3 ignores any provided <code>ChecksumAlgorithm</code>
         *        parameter.
         * @see ChecksumAlgorithm
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see ChecksumAlgorithm
         */
        Builder checksumAlgorithm(ChecksumAlgorithm checksumAlgorithm);

        /**
         * <p>
         * Container for lifecycle rules. You can add as many as 1,000 rules.
         * </p>
         * 
         * @param lifecycleConfiguration
         *        Container for lifecycle rules. You can add as many as 1,000 rules.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder lifecycleConfiguration(BucketLifecycleConfiguration lifecycleConfiguration);

        /**
         * <p>
         * Container for lifecycle rules. You can add as many as 1,000 rules.
         * </p>
         * This is a convenience method that creates an instance of the {@link BucketLifecycleConfiguration.Builder}
         * avoiding the need to create one manually via {@link BucketLifecycleConfiguration#builder()}.
         *
         * <p>
         * When the {@link Consumer} completes, {@link BucketLifecycleConfiguration.Builder#build()} is called
         * immediately and its result is passed to {@link #lifecycleConfiguration(BucketLifecycleConfiguration)}.
         * 
         * @param lifecycleConfiguration
         *        a consumer that will call methods on {@link BucketLifecycleConfiguration.Builder}
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see #lifecycleConfiguration(BucketLifecycleConfiguration)
         */
        default Builder lifecycleConfiguration(Consumer<BucketLifecycleConfiguration.Builder> lifecycleConfiguration) {
            return lifecycleConfiguration(BucketLifecycleConfiguration.builder().applyMutation(lifecycleConfiguration).build());
        }

        /**
         * <p>
         * The account ID of the expected bucket owner. If the account ID that you provide does not match the actual
         * owner of the bucket, the request fails with the HTTP status code <code>403 Forbidden</code> (access denied).
         * </p>
         * <note>
         * <p>
         * This parameter applies to general purpose buckets only. It is not supported for directory bucket lifecycle
         * configurations.
         * </p>
         * </note>
         * 
         * @param expectedBucketOwner
         *        The account ID of the expected bucket owner. If the account ID that you provide does not match the
         *        actual owner of the bucket, the request fails with the HTTP status code <code>403 Forbidden</code>
         *        (access denied).</p> <note>
         *        <p>
         *        This parameter applies to general purpose buckets only. It is not supported for directory bucket
         *        lifecycle configurations.
         *        </p>
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder expectedBucketOwner(String expectedBucketOwner);

        /**
         * <p>
         * Indicates which default minimum object size behavior is applied to the lifecycle configuration.
         * </p>
         * <note>
         * <p>
         * This parameter applies to general purpose buckets only. It is not supported for directory bucket lifecycle
         * configurations.
         * </p>
         * </note>
         * <ul>
         * <li>
         * <p>
         * <code>all_storage_classes_128K</code> - Objects smaller than 128 KB will not transition to any storage class
         * by default.
         * </p>
         * </li>
         * <li>
         * <p>
         * <code>varies_by_storage_class</code> - Objects smaller than 128 KB will transition to Glacier Flexible
         * Retrieval or Glacier Deep Archive storage classes. By default, all other storage classes will prevent
         * transitions smaller than 128 KB.
         * </p>
         * </li>
         * </ul>
         * <p>
         * To customize the minimum object size for any transition you can add a filter that specifies a custom
         * <code>ObjectSizeGreaterThan</code> or <code>ObjectSizeLessThan</code> in the body of your transition rule.
         * Custom filters always take precedence over the default transition behavior.
         * </p>
         * 
         * @param transitionDefaultMinimumObjectSize
         *        Indicates which default minimum object size behavior is applied to the lifecycle configuration.</p>
         *        <note>
         *        <p>
         *        This parameter applies to general purpose buckets only. It is not supported for directory bucket
         *        lifecycle configurations.
         *        </p>
         *        </note>
         *        <ul>
         *        <li>
         *        <p>
         *        <code>all_storage_classes_128K</code> - Objects smaller than 128 KB will not transition to any storage
         *        class by default.
         *        </p>
         *        </li>
         *        <li>
         *        <p>
         *        <code>varies_by_storage_class</code> - Objects smaller than 128 KB will transition to Glacier Flexible
         *        Retrieval or Glacier Deep Archive storage classes. By default, all other storage classes will prevent
         *        transitions smaller than 128 KB.
         *        </p>
         *        </li>
         *        </ul>
         *        <p>
         *        To customize the minimum object size for any transition you can add a filter that specifies a custom
         *        <code>ObjectSizeGreaterThan</code> or <code>ObjectSizeLessThan</code> in the body of your transition
         *        rule. Custom filters always take precedence over the default transition behavior.
         * @see TransitionDefaultMinimumObjectSize
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see TransitionDefaultMinimumObjectSize
         */
        Builder transitionDefaultMinimumObjectSize(String transitionDefaultMinimumObjectSize);

        /**
         * <p>
         * Indicates which default minimum object size behavior is applied to the lifecycle configuration.
         * </p>
         * <note>
         * <p>
         * This parameter applies to general purpose buckets only. It is not supported for directory bucket lifecycle
         * configurations.
         * </p>
         * </note>
         * <ul>
         * <li>
         * <p>
         * <code>all_storage_classes_128K</code> - Objects smaller than 128 KB will not transition to any storage class
         * by default.
         * </p>
         * </li>
         * <li>
         * <p>
         * <code>varies_by_storage_class</code> - Objects smaller than 128 KB will transition to Glacier Flexible
         * Retrieval or Glacier Deep Archive storage classes. By default, all other storage classes will prevent
         * transitions smaller than 128 KB.
         * </p>
         * </li>
         * </ul>
         * <p>
         * To customize the minimum object size for any transition you can add a filter that specifies a custom
         * <code>ObjectSizeGreaterThan</code> or <code>ObjectSizeLessThan</code> in the body of your transition rule.
         * Custom filters always take precedence over the default transition behavior.
         * </p>
         * 
         * @param transitionDefaultMinimumObjectSize
         *        Indicates which default minimum object size behavior is applied to the lifecycle configuration.</p>
         *        <note>
         *        <p>
         *        This parameter applies to general purpose buckets only. It is not supported for directory bucket
         *        lifecycle configurations.
         *        </p>
         *        </note>
         *        <ul>
         *        <li>
         *        <p>
         *        <code>all_storage_classes_128K</code> - Objects smaller than 128 KB will not transition to any storage
         *        class by default.
         *        </p>
         *        </li>
         *        <li>
         *        <p>
         *        <code>varies_by_storage_class</code> - Objects smaller than 128 KB will transition to Glacier Flexible
         *        Retrieval or Glacier Deep Archive storage classes. By default, all other storage classes will prevent
         *        transitions smaller than 128 KB.
         *        </p>
         *        </li>
         *        </ul>
         *        <p>
         *        To customize the minimum object size for any transition you can add a filter that specifies a custom
         *        <code>ObjectSizeGreaterThan</code> or <code>ObjectSizeLessThan</code> in the body of your transition
         *        rule. Custom filters always take precedence over the default transition behavior.
         * @see TransitionDefaultMinimumObjectSize
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see TransitionDefaultMinimumObjectSize
         */
        Builder transitionDefaultMinimumObjectSize(TransitionDefaultMinimumObjectSize transitionDefaultMinimumObjectSize);

        @Override
        Builder overrideConfiguration(AwsRequestOverrideConfiguration overrideConfiguration);

        @Override
        Builder overrideConfiguration(Consumer<AwsRequestOverrideConfiguration.Builder> builderConsumer);
    }

    static final class BuilderImpl extends S3Request.BuilderImpl implements Builder {
        private String bucket;

        private String checksumAlgorithm;

        private BucketLifecycleConfiguration lifecycleConfiguration;

        private String expectedBucketOwner;

        private String transitionDefaultMinimumObjectSize;

        private BuilderImpl() {
        }

        private BuilderImpl(PutBucketLifecycleConfigurationRequest model) {
            super(model);
            bucket(model.bucket);
            checksumAlgorithm(model.checksumAlgorithm);
            lifecycleConfiguration(model.lifecycleConfiguration);
            expectedBucketOwner(model.expectedBucketOwner);
            transitionDefaultMinimumObjectSize(model.transitionDefaultMinimumObjectSize);
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

        public final BucketLifecycleConfiguration.Builder getLifecycleConfiguration() {
            return lifecycleConfiguration != null ? lifecycleConfiguration.toBuilder() : null;
        }

        public final void setLifecycleConfiguration(BucketLifecycleConfiguration.BuilderImpl lifecycleConfiguration) {
            this.lifecycleConfiguration = lifecycleConfiguration != null ? lifecycleConfiguration.build() : null;
        }

        @Override
        public final Builder lifecycleConfiguration(BucketLifecycleConfiguration lifecycleConfiguration) {
            this.lifecycleConfiguration = lifecycleConfiguration;
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

        public final String getTransitionDefaultMinimumObjectSize() {
            return transitionDefaultMinimumObjectSize;
        }

        public final void setTransitionDefaultMinimumObjectSize(String transitionDefaultMinimumObjectSize) {
            this.transitionDefaultMinimumObjectSize = transitionDefaultMinimumObjectSize;
        }

        @Override
        public final Builder transitionDefaultMinimumObjectSize(String transitionDefaultMinimumObjectSize) {
            this.transitionDefaultMinimumObjectSize = transitionDefaultMinimumObjectSize;
            return this;
        }

        @Override
        public final Builder transitionDefaultMinimumObjectSize(
                TransitionDefaultMinimumObjectSize transitionDefaultMinimumObjectSize) {
            this.transitionDefaultMinimumObjectSize(transitionDefaultMinimumObjectSize == null ? null
                    : transitionDefaultMinimumObjectSize.toString());
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
        public PutBucketLifecycleConfigurationRequest build() {
            return new PutBucketLifecycleConfigurationRequest(this);
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
