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
public final class PutBucketPolicyRequest extends S3Request implements
        ToCopyableBuilder<PutBucketPolicyRequest.Builder, PutBucketPolicyRequest> {
    private static final SdkField<String> BUCKET_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("Bucket")
            .getter(getter(PutBucketPolicyRequest::bucket))
            .setter(setter(Builder::bucket))
            .traits(LocationTrait.builder().location(MarshallLocation.PATH).locationName("Bucket")
                    .unmarshallLocationName("Bucket").build(), RequiredTrait.create()).build();

    private static final SdkField<String> CONTENT_MD5_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("ContentMD5")
            .getter(getter(PutBucketPolicyRequest::contentMD5))
            .setter(setter(Builder::contentMD5))
            .traits(LocationTrait.builder().location(MarshallLocation.HEADER).locationName("Content-MD5")
                    .unmarshallLocationName("Content-MD5").build()).build();

    private static final SdkField<String> CHECKSUM_ALGORITHM_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("ChecksumAlgorithm")
            .getter(getter(PutBucketPolicyRequest::checksumAlgorithmAsString))
            .setter(setter(Builder::checksumAlgorithm))
            .traits(LocationTrait.builder().location(MarshallLocation.HEADER).locationName("x-amz-sdk-checksum-algorithm")
                    .unmarshallLocationName("x-amz-sdk-checksum-algorithm").build()).build();

    private static final SdkField<Boolean> CONFIRM_REMOVE_SELF_BUCKET_ACCESS_FIELD = SdkField
            .<Boolean> builder(MarshallingType.BOOLEAN)
            .memberName("ConfirmRemoveSelfBucketAccess")
            .getter(getter(PutBucketPolicyRequest::confirmRemoveSelfBucketAccess))
            .setter(setter(Builder::confirmRemoveSelfBucketAccess))
            .traits(LocationTrait.builder().location(MarshallLocation.HEADER)
                    .locationName("x-amz-confirm-remove-self-bucket-access")
                    .unmarshallLocationName("x-amz-confirm-remove-self-bucket-access").build()).build();

    private static final SdkField<String> POLICY_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("Policy")
            .getter(getter(PutBucketPolicyRequest::policy))
            .setter(setter(Builder::policy))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("Policy")
                    .unmarshallLocationName("Policy").build(), PayloadTrait.create(), RequiredTrait.create()).build();

    private static final SdkField<String> EXPECTED_BUCKET_OWNER_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("ExpectedBucketOwner")
            .getter(getter(PutBucketPolicyRequest::expectedBucketOwner))
            .setter(setter(Builder::expectedBucketOwner))
            .traits(LocationTrait.builder().location(MarshallLocation.HEADER).locationName("x-amz-expected-bucket-owner")
                    .unmarshallLocationName("x-amz-expected-bucket-owner").build()).build();

    private static final List<SdkField<?>> SDK_FIELDS = Collections.unmodifiableList(Arrays.asList(BUCKET_FIELD,
            CONTENT_MD5_FIELD, CHECKSUM_ALGORITHM_FIELD, CONFIRM_REMOVE_SELF_BUCKET_ACCESS_FIELD, POLICY_FIELD,
            EXPECTED_BUCKET_OWNER_FIELD));

    private static final Map<String, SdkField<?>> SDK_NAME_TO_FIELD = memberNameToFieldInitializer();

    private final String bucket;

    private final String contentMD5;

    private final String checksumAlgorithm;

    private final Boolean confirmRemoveSelfBucketAccess;

    private final String policy;

    private final String expectedBucketOwner;

    private PutBucketPolicyRequest(BuilderImpl builder) {
        super(builder);
        this.bucket = builder.bucket;
        this.contentMD5 = builder.contentMD5;
        this.checksumAlgorithm = builder.checksumAlgorithm;
        this.confirmRemoveSelfBucketAccess = builder.confirmRemoveSelfBucketAccess;
        this.policy = builder.policy;
        this.expectedBucketOwner = builder.expectedBucketOwner;
    }

    /**
     * <p>
     * The name of the bucket.
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
     * @return The name of the bucket.</p>
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
     * The MD5 hash of the request body.
     * </p>
     * <p>
     * For requests made using the Amazon Web Services Command Line Interface (CLI) or Amazon Web Services SDKs, this
     * field is calculated automatically.
     * </p>
     * <note>
     * <p>
     * This functionality is not supported for directory buckets.
     * </p>
     * </note>
     * 
     * @return The MD5 hash of the request body.</p>
     *         <p>
     *         For requests made using the Amazon Web Services Command Line Interface (CLI) or Amazon Web Services SDKs,
     *         this field is calculated automatically.
     *         </p>
     *         <note>
     *         <p>
     *         This functionality is not supported for directory buckets.
     *         </p>
     */
    public final String contentMD5() {
        return contentMD5;
    }

    /**
     * <p>
     * Indicates the algorithm used to create the checksum for the request when you use the SDK. This header will not
     * provide any additional functionality if you don't use the SDK. When you send this header, there must be a
     * corresponding <code>x-amz-checksum-<i>algorithm</i> </code> or <code>x-amz-trailer</code> header sent. Otherwise,
     * Amazon S3 fails the request with the HTTP status code <code>400 Bad Request</code>.
     * </p>
     * <p>
     * For the <code>x-amz-checksum-<i>algorithm</i> </code> header, replace <code> <i>algorithm</i> </code> with the
     * supported algorithm from the following list:
     * </p>
     * <ul>
     * <li>
     * <p>
     * <code>CRC32</code>
     * </p>
     * </li>
     * <li>
     * <p>
     * <code>CRC32C</code>
     * </p>
     * </li>
     * <li>
     * <p>
     * <code>CRC64NVME</code>
     * </p>
     * </li>
     * <li>
     * <p>
     * <code>SHA1</code>
     * </p>
     * </li>
     * <li>
     * <p>
     * <code>SHA256</code>
     * </p>
     * </li>
     * </ul>
     * <p>
     * For more information, see <a
     * href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/checking-object-integrity.html">Checking object
     * integrity</a> in the <i>Amazon S3 User Guide</i>.
     * </p>
     * <p>
     * If the individual checksum value you provide through <code>x-amz-checksum-<i>algorithm</i> </code> doesn't match
     * the checksum algorithm you set through <code>x-amz-sdk-checksum-algorithm</code>, Amazon S3 fails the request
     * with a <code>BadDigest</code> error.
     * </p>
     * <note>
     * <p>
     * For directory buckets, when you use Amazon Web Services SDKs, <code>CRC32</code> is the default checksum
     * algorithm that's used for performance.
     * </p>
     * </note>
     * <p>
     * If the service returns an enum value that is not available in the current SDK version, {@link #checksumAlgorithm}
     * will return {@link ChecksumAlgorithm#UNKNOWN_TO_SDK_VERSION}. The raw value returned by the service is available
     * from {@link #checksumAlgorithmAsString}.
     * </p>
     * 
     * @return Indicates the algorithm used to create the checksum for the request when you use the SDK. This header
     *         will not provide any additional functionality if you don't use the SDK. When you send this header, there
     *         must be a corresponding <code>x-amz-checksum-<i>algorithm</i> </code> or <code>x-amz-trailer</code>
     *         header sent. Otherwise, Amazon S3 fails the request with the HTTP status code
     *         <code>400 Bad Request</code>.</p>
     *         <p>
     *         For the <code>x-amz-checksum-<i>algorithm</i> </code> header, replace <code> <i>algorithm</i> </code>
     *         with the supported algorithm from the following list:
     *         </p>
     *         <ul>
     *         <li>
     *         <p>
     *         <code>CRC32</code>
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         <code>CRC32C</code>
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         <code>CRC64NVME</code>
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         <code>SHA1</code>
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         <code>SHA256</code>
     *         </p>
     *         </li>
     *         </ul>
     *         <p>
     *         For more information, see <a
     *         href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/checking-object-integrity.html">Checking
     *         object integrity</a> in the <i>Amazon S3 User Guide</i>.
     *         </p>
     *         <p>
     *         If the individual checksum value you provide through <code>x-amz-checksum-<i>algorithm</i> </code>
     *         doesn't match the checksum algorithm you set through <code>x-amz-sdk-checksum-algorithm</code>, Amazon S3
     *         fails the request with a <code>BadDigest</code> error.
     *         </p>
     *         <note>
     *         <p>
     *         For directory buckets, when you use Amazon Web Services SDKs, <code>CRC32</code> is the default checksum
     *         algorithm that's used for performance.
     *         </p>
     * @see ChecksumAlgorithm
     */
    public final ChecksumAlgorithm checksumAlgorithm() {
        return ChecksumAlgorithm.fromValue(checksumAlgorithm);
    }

    /**
     * <p>
     * Indicates the algorithm used to create the checksum for the request when you use the SDK. This header will not
     * provide any additional functionality if you don't use the SDK. When you send this header, there must be a
     * corresponding <code>x-amz-checksum-<i>algorithm</i> </code> or <code>x-amz-trailer</code> header sent. Otherwise,
     * Amazon S3 fails the request with the HTTP status code <code>400 Bad Request</code>.
     * </p>
     * <p>
     * For the <code>x-amz-checksum-<i>algorithm</i> </code> header, replace <code> <i>algorithm</i> </code> with the
     * supported algorithm from the following list:
     * </p>
     * <ul>
     * <li>
     * <p>
     * <code>CRC32</code>
     * </p>
     * </li>
     * <li>
     * <p>
     * <code>CRC32C</code>
     * </p>
     * </li>
     * <li>
     * <p>
     * <code>CRC64NVME</code>
     * </p>
     * </li>
     * <li>
     * <p>
     * <code>SHA1</code>
     * </p>
     * </li>
     * <li>
     * <p>
     * <code>SHA256</code>
     * </p>
     * </li>
     * </ul>
     * <p>
     * For more information, see <a
     * href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/checking-object-integrity.html">Checking object
     * integrity</a> in the <i>Amazon S3 User Guide</i>.
     * </p>
     * <p>
     * If the individual checksum value you provide through <code>x-amz-checksum-<i>algorithm</i> </code> doesn't match
     * the checksum algorithm you set through <code>x-amz-sdk-checksum-algorithm</code>, Amazon S3 fails the request
     * with a <code>BadDigest</code> error.
     * </p>
     * <note>
     * <p>
     * For directory buckets, when you use Amazon Web Services SDKs, <code>CRC32</code> is the default checksum
     * algorithm that's used for performance.
     * </p>
     * </note>
     * <p>
     * If the service returns an enum value that is not available in the current SDK version, {@link #checksumAlgorithm}
     * will return {@link ChecksumAlgorithm#UNKNOWN_TO_SDK_VERSION}. The raw value returned by the service is available
     * from {@link #checksumAlgorithmAsString}.
     * </p>
     * 
     * @return Indicates the algorithm used to create the checksum for the request when you use the SDK. This header
     *         will not provide any additional functionality if you don't use the SDK. When you send this header, there
     *         must be a corresponding <code>x-amz-checksum-<i>algorithm</i> </code> or <code>x-amz-trailer</code>
     *         header sent. Otherwise, Amazon S3 fails the request with the HTTP status code
     *         <code>400 Bad Request</code>.</p>
     *         <p>
     *         For the <code>x-amz-checksum-<i>algorithm</i> </code> header, replace <code> <i>algorithm</i> </code>
     *         with the supported algorithm from the following list:
     *         </p>
     *         <ul>
     *         <li>
     *         <p>
     *         <code>CRC32</code>
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         <code>CRC32C</code>
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         <code>CRC64NVME</code>
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         <code>SHA1</code>
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         <code>SHA256</code>
     *         </p>
     *         </li>
     *         </ul>
     *         <p>
     *         For more information, see <a
     *         href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/checking-object-integrity.html">Checking
     *         object integrity</a> in the <i>Amazon S3 User Guide</i>.
     *         </p>
     *         <p>
     *         If the individual checksum value you provide through <code>x-amz-checksum-<i>algorithm</i> </code>
     *         doesn't match the checksum algorithm you set through <code>x-amz-sdk-checksum-algorithm</code>, Amazon S3
     *         fails the request with a <code>BadDigest</code> error.
     *         </p>
     *         <note>
     *         <p>
     *         For directory buckets, when you use Amazon Web Services SDKs, <code>CRC32</code> is the default checksum
     *         algorithm that's used for performance.
     *         </p>
     * @see ChecksumAlgorithm
     */
    public final String checksumAlgorithmAsString() {
        return checksumAlgorithm;
    }

    /**
     * <p>
     * Set this parameter to true to confirm that you want to remove your permissions to change this bucket policy in
     * the future.
     * </p>
     * <note>
     * <p>
     * This functionality is not supported for directory buckets.
     * </p>
     * </note>
     * 
     * @return Set this parameter to true to confirm that you want to remove your permissions to change this bucket
     *         policy in the future.</p> <note>
     *         <p>
     *         This functionality is not supported for directory buckets.
     *         </p>
     */
    public final Boolean confirmRemoveSelfBucketAccess() {
        return confirmRemoveSelfBucketAccess;
    }

    /**
     * <p>
     * The bucket policy as a JSON document.
     * </p>
     * <p>
     * For directory buckets, the only IAM action supported in the bucket policy is <code>s3express:CreateSession</code>
     * .
     * </p>
     * 
     * @return The bucket policy as a JSON document.</p>
     *         <p>
     *         For directory buckets, the only IAM action supported in the bucket policy is
     *         <code>s3express:CreateSession</code>.
     */
    public final String policy() {
        return policy;
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
        hashCode = 31 * hashCode + Objects.hashCode(contentMD5());
        hashCode = 31 * hashCode + Objects.hashCode(checksumAlgorithmAsString());
        hashCode = 31 * hashCode + Objects.hashCode(confirmRemoveSelfBucketAccess());
        hashCode = 31 * hashCode + Objects.hashCode(policy());
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
        if (!(obj instanceof PutBucketPolicyRequest)) {
            return false;
        }
        PutBucketPolicyRequest other = (PutBucketPolicyRequest) obj;
        return Objects.equals(bucket(), other.bucket()) && Objects.equals(contentMD5(), other.contentMD5())
                && Objects.equals(checksumAlgorithmAsString(), other.checksumAlgorithmAsString())
                && Objects.equals(confirmRemoveSelfBucketAccess(), other.confirmRemoveSelfBucketAccess())
                && Objects.equals(policy(), other.policy()) && Objects.equals(expectedBucketOwner(), other.expectedBucketOwner());
    }

    /**
     * Returns a string representation of this object. This is useful for testing and debugging. Sensitive data will be
     * redacted from this string using a placeholder value.
     */
    @Override
    public final String toString() {
        return ToString.builder("PutBucketPolicyRequest").add("Bucket", bucket()).add("ContentMD5", contentMD5())
                .add("ChecksumAlgorithm", checksumAlgorithmAsString())
                .add("ConfirmRemoveSelfBucketAccess", confirmRemoveSelfBucketAccess()).add("Policy", policy())
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
        case "ConfirmRemoveSelfBucketAccess":
            return Optional.ofNullable(clazz.cast(confirmRemoveSelfBucketAccess()));
        case "Policy":
            return Optional.ofNullable(clazz.cast(policy()));
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
        map.put("x-amz-confirm-remove-self-bucket-access", CONFIRM_REMOVE_SELF_BUCKET_ACCESS_FIELD);
        map.put("Policy", POLICY_FIELD);
        map.put("x-amz-expected-bucket-owner", EXPECTED_BUCKET_OWNER_FIELD);
        return Collections.unmodifiableMap(map);
    }

    private static <T> Function<Object, T> getter(Function<PutBucketPolicyRequest, T> g) {
        return obj -> g.apply((PutBucketPolicyRequest) obj);
    }

    private static <T> BiConsumer<Object, T> setter(BiConsumer<Builder, T> s) {
        return (obj, val) -> s.accept((Builder) obj, val);
    }

    @Mutable
    @NotThreadSafe
    public interface Builder extends S3Request.Builder, SdkPojo, CopyableBuilder<Builder, PutBucketPolicyRequest> {
        /**
         * <p>
         * The name of the bucket.
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
         *        The name of the bucket.</p>
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
         * The MD5 hash of the request body.
         * </p>
         * <p>
         * For requests made using the Amazon Web Services Command Line Interface (CLI) or Amazon Web Services SDKs,
         * this field is calculated automatically.
         * </p>
         * <note>
         * <p>
         * This functionality is not supported for directory buckets.
         * </p>
         * </note>
         * 
         * @param contentMD5
         *        The MD5 hash of the request body.</p>
         *        <p>
         *        For requests made using the Amazon Web Services Command Line Interface (CLI) or Amazon Web Services
         *        SDKs, this field is calculated automatically.
         *        </p>
         *        <note>
         *        <p>
         *        This functionality is not supported for directory buckets.
         *        </p>
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder contentMD5(String contentMD5);

        /**
         * <p>
         * Indicates the algorithm used to create the checksum for the request when you use the SDK. This header will
         * not provide any additional functionality if you don't use the SDK. When you send this header, there must be a
         * corresponding <code>x-amz-checksum-<i>algorithm</i> </code> or <code>x-amz-trailer</code> header sent.
         * Otherwise, Amazon S3 fails the request with the HTTP status code <code>400 Bad Request</code>.
         * </p>
         * <p>
         * For the <code>x-amz-checksum-<i>algorithm</i> </code> header, replace <code> <i>algorithm</i> </code> with
         * the supported algorithm from the following list:
         * </p>
         * <ul>
         * <li>
         * <p>
         * <code>CRC32</code>
         * </p>
         * </li>
         * <li>
         * <p>
         * <code>CRC32C</code>
         * </p>
         * </li>
         * <li>
         * <p>
         * <code>CRC64NVME</code>
         * </p>
         * </li>
         * <li>
         * <p>
         * <code>SHA1</code>
         * </p>
         * </li>
         * <li>
         * <p>
         * <code>SHA256</code>
         * </p>
         * </li>
         * </ul>
         * <p>
         * For more information, see <a
         * href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/checking-object-integrity.html">Checking object
         * integrity</a> in the <i>Amazon S3 User Guide</i>.
         * </p>
         * <p>
         * If the individual checksum value you provide through <code>x-amz-checksum-<i>algorithm</i> </code> doesn't
         * match the checksum algorithm you set through <code>x-amz-sdk-checksum-algorithm</code>, Amazon S3 fails the
         * request with a <code>BadDigest</code> error.
         * </p>
         * <note>
         * <p>
         * For directory buckets, when you use Amazon Web Services SDKs, <code>CRC32</code> is the default checksum
         * algorithm that's used for performance.
         * </p>
         * </note>
         * 
         * @param checksumAlgorithm
         *        Indicates the algorithm used to create the checksum for the request when you use the SDK. This header
         *        will not provide any additional functionality if you don't use the SDK. When you send this header,
         *        there must be a corresponding <code>x-amz-checksum-<i>algorithm</i> </code> or
         *        <code>x-amz-trailer</code> header sent. Otherwise, Amazon S3 fails the request with the HTTP status
         *        code <code>400 Bad Request</code>.</p>
         *        <p>
         *        For the <code>x-amz-checksum-<i>algorithm</i> </code> header, replace <code> <i>algorithm</i> </code>
         *        with the supported algorithm from the following list:
         *        </p>
         *        <ul>
         *        <li>
         *        <p>
         *        <code>CRC32</code>
         *        </p>
         *        </li>
         *        <li>
         *        <p>
         *        <code>CRC32C</code>
         *        </p>
         *        </li>
         *        <li>
         *        <p>
         *        <code>CRC64NVME</code>
         *        </p>
         *        </li>
         *        <li>
         *        <p>
         *        <code>SHA1</code>
         *        </p>
         *        </li>
         *        <li>
         *        <p>
         *        <code>SHA256</code>
         *        </p>
         *        </li>
         *        </ul>
         *        <p>
         *        For more information, see <a
         *        href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/checking-object-integrity.html">Checking
         *        object integrity</a> in the <i>Amazon S3 User Guide</i>.
         *        </p>
         *        <p>
         *        If the individual checksum value you provide through <code>x-amz-checksum-<i>algorithm</i> </code>
         *        doesn't match the checksum algorithm you set through <code>x-amz-sdk-checksum-algorithm</code>, Amazon
         *        S3 fails the request with a <code>BadDigest</code> error.
         *        </p>
         *        <note>
         *        <p>
         *        For directory buckets, when you use Amazon Web Services SDKs, <code>CRC32</code> is the default
         *        checksum algorithm that's used for performance.
         *        </p>
         * @see ChecksumAlgorithm
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see ChecksumAlgorithm
         */
        Builder checksumAlgorithm(String checksumAlgorithm);

        /**
         * <p>
         * Indicates the algorithm used to create the checksum for the request when you use the SDK. This header will
         * not provide any additional functionality if you don't use the SDK. When you send this header, there must be a
         * corresponding <code>x-amz-checksum-<i>algorithm</i> </code> or <code>x-amz-trailer</code> header sent.
         * Otherwise, Amazon S3 fails the request with the HTTP status code <code>400 Bad Request</code>.
         * </p>
         * <p>
         * For the <code>x-amz-checksum-<i>algorithm</i> </code> header, replace <code> <i>algorithm</i> </code> with
         * the supported algorithm from the following list:
         * </p>
         * <ul>
         * <li>
         * <p>
         * <code>CRC32</code>
         * </p>
         * </li>
         * <li>
         * <p>
         * <code>CRC32C</code>
         * </p>
         * </li>
         * <li>
         * <p>
         * <code>CRC64NVME</code>
         * </p>
         * </li>
         * <li>
         * <p>
         * <code>SHA1</code>
         * </p>
         * </li>
         * <li>
         * <p>
         * <code>SHA256</code>
         * </p>
         * </li>
         * </ul>
         * <p>
         * For more information, see <a
         * href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/checking-object-integrity.html">Checking object
         * integrity</a> in the <i>Amazon S3 User Guide</i>.
         * </p>
         * <p>
         * If the individual checksum value you provide through <code>x-amz-checksum-<i>algorithm</i> </code> doesn't
         * match the checksum algorithm you set through <code>x-amz-sdk-checksum-algorithm</code>, Amazon S3 fails the
         * request with a <code>BadDigest</code> error.
         * </p>
         * <note>
         * <p>
         * For directory buckets, when you use Amazon Web Services SDKs, <code>CRC32</code> is the default checksum
         * algorithm that's used for performance.
         * </p>
         * </note>
         * 
         * @param checksumAlgorithm
         *        Indicates the algorithm used to create the checksum for the request when you use the SDK. This header
         *        will not provide any additional functionality if you don't use the SDK. When you send this header,
         *        there must be a corresponding <code>x-amz-checksum-<i>algorithm</i> </code> or
         *        <code>x-amz-trailer</code> header sent. Otherwise, Amazon S3 fails the request with the HTTP status
         *        code <code>400 Bad Request</code>.</p>
         *        <p>
         *        For the <code>x-amz-checksum-<i>algorithm</i> </code> header, replace <code> <i>algorithm</i> </code>
         *        with the supported algorithm from the following list:
         *        </p>
         *        <ul>
         *        <li>
         *        <p>
         *        <code>CRC32</code>
         *        </p>
         *        </li>
         *        <li>
         *        <p>
         *        <code>CRC32C</code>
         *        </p>
         *        </li>
         *        <li>
         *        <p>
         *        <code>CRC64NVME</code>
         *        </p>
         *        </li>
         *        <li>
         *        <p>
         *        <code>SHA1</code>
         *        </p>
         *        </li>
         *        <li>
         *        <p>
         *        <code>SHA256</code>
         *        </p>
         *        </li>
         *        </ul>
         *        <p>
         *        For more information, see <a
         *        href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/checking-object-integrity.html">Checking
         *        object integrity</a> in the <i>Amazon S3 User Guide</i>.
         *        </p>
         *        <p>
         *        If the individual checksum value you provide through <code>x-amz-checksum-<i>algorithm</i> </code>
         *        doesn't match the checksum algorithm you set through <code>x-amz-sdk-checksum-algorithm</code>, Amazon
         *        S3 fails the request with a <code>BadDigest</code> error.
         *        </p>
         *        <note>
         *        <p>
         *        For directory buckets, when you use Amazon Web Services SDKs, <code>CRC32</code> is the default
         *        checksum algorithm that's used for performance.
         *        </p>
         * @see ChecksumAlgorithm
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see ChecksumAlgorithm
         */
        Builder checksumAlgorithm(ChecksumAlgorithm checksumAlgorithm);

        /**
         * <p>
         * Set this parameter to true to confirm that you want to remove your permissions to change this bucket policy
         * in the future.
         * </p>
         * <note>
         * <p>
         * This functionality is not supported for directory buckets.
         * </p>
         * </note>
         * 
         * @param confirmRemoveSelfBucketAccess
         *        Set this parameter to true to confirm that you want to remove your permissions to change this bucket
         *        policy in the future.</p> <note>
         *        <p>
         *        This functionality is not supported for directory buckets.
         *        </p>
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder confirmRemoveSelfBucketAccess(Boolean confirmRemoveSelfBucketAccess);

        /**
         * <p>
         * The bucket policy as a JSON document.
         * </p>
         * <p>
         * For directory buckets, the only IAM action supported in the bucket policy is
         * <code>s3express:CreateSession</code>.
         * </p>
         * 
         * @param policy
         *        The bucket policy as a JSON document.</p>
         *        <p>
         *        For directory buckets, the only IAM action supported in the bucket policy is
         *        <code>s3express:CreateSession</code>.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder policy(String policy);

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

        private String contentMD5;

        private String checksumAlgorithm;

        private Boolean confirmRemoveSelfBucketAccess;

        private String policy;

        private String expectedBucketOwner;

        private BuilderImpl() {
        }

        private BuilderImpl(PutBucketPolicyRequest model) {
            super(model);
            bucket(model.bucket);
            contentMD5(model.contentMD5);
            checksumAlgorithm(model.checksumAlgorithm);
            confirmRemoveSelfBucketAccess(model.confirmRemoveSelfBucketAccess);
            policy(model.policy);
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

        public final Boolean getConfirmRemoveSelfBucketAccess() {
            return confirmRemoveSelfBucketAccess;
        }

        public final void setConfirmRemoveSelfBucketAccess(Boolean confirmRemoveSelfBucketAccess) {
            this.confirmRemoveSelfBucketAccess = confirmRemoveSelfBucketAccess;
        }

        @Override
        public final Builder confirmRemoveSelfBucketAccess(Boolean confirmRemoveSelfBucketAccess) {
            this.confirmRemoveSelfBucketAccess = confirmRemoveSelfBucketAccess;
            return this;
        }

        public final String getPolicy() {
            return policy;
        }

        public final void setPolicy(String policy) {
            this.policy = policy;
        }

        @Override
        public final Builder policy(String policy) {
            this.policy = policy;
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
        public PutBucketPolicyRequest build() {
            return new PutBucketPolicyRequest(this);
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
