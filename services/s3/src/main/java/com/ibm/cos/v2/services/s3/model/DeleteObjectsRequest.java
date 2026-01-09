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
public final class DeleteObjectsRequest extends S3Request implements
        ToCopyableBuilder<DeleteObjectsRequest.Builder, DeleteObjectsRequest> {
    private static final SdkField<String> BUCKET_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("Bucket")
            .getter(getter(DeleteObjectsRequest::bucket))
            .setter(setter(Builder::bucket))
            .traits(LocationTrait.builder().location(MarshallLocation.PATH).locationName("Bucket")
                    .unmarshallLocationName("Bucket").build(), RequiredTrait.create()).build();

    private static final SdkField<Delete> DELETE_FIELD = SdkField
            .<Delete> builder(MarshallingType.SDK_POJO)
            .memberName("Delete")
            .getter(getter(DeleteObjectsRequest::delete))
            .setter(setter(Builder::delete))
            .constructor(Delete::builder)
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("Delete")
                    .unmarshallLocationName("Delete").build(), PayloadTrait.create(), RequiredTrait.create()).build();

    private static final SdkField<String> MFA_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("MFA")
            .getter(getter(DeleteObjectsRequest::mfa))
            .setter(setter(Builder::mfa))
            .traits(LocationTrait.builder().location(MarshallLocation.HEADER).locationName("x-amz-mfa")
                    .unmarshallLocationName("x-amz-mfa").build()).build();

    private static final SdkField<String> REQUEST_PAYER_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("RequestPayer")
            .getter(getter(DeleteObjectsRequest::requestPayerAsString))
            .setter(setter(Builder::requestPayer))
            .traits(LocationTrait.builder().location(MarshallLocation.HEADER).locationName("x-amz-request-payer")
                    .unmarshallLocationName("x-amz-request-payer").build()).build();

    private static final SdkField<Boolean> BYPASS_GOVERNANCE_RETENTION_FIELD = SdkField
            .<Boolean> builder(MarshallingType.BOOLEAN)
            .memberName("BypassGovernanceRetention")
            .getter(getter(DeleteObjectsRequest::bypassGovernanceRetention))
            .setter(setter(Builder::bypassGovernanceRetention))
            .traits(LocationTrait.builder().location(MarshallLocation.HEADER).locationName("x-amz-bypass-governance-retention")
                    .unmarshallLocationName("x-amz-bypass-governance-retention").build()).build();

    private static final SdkField<String> EXPECTED_BUCKET_OWNER_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("ExpectedBucketOwner")
            .getter(getter(DeleteObjectsRequest::expectedBucketOwner))
            .setter(setter(Builder::expectedBucketOwner))
            .traits(LocationTrait.builder().location(MarshallLocation.HEADER).locationName("x-amz-expected-bucket-owner")
                    .unmarshallLocationName("x-amz-expected-bucket-owner").build()).build();

    private static final SdkField<String> CHECKSUM_ALGORITHM_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("ChecksumAlgorithm")
            .getter(getter(DeleteObjectsRequest::checksumAlgorithmAsString))
            .setter(setter(Builder::checksumAlgorithm))
            .traits(LocationTrait.builder().location(MarshallLocation.HEADER).locationName("x-amz-sdk-checksum-algorithm")
                    .unmarshallLocationName("x-amz-sdk-checksum-algorithm").build()).build();

    private static final List<SdkField<?>> SDK_FIELDS = Collections.unmodifiableList(Arrays.asList(BUCKET_FIELD, DELETE_FIELD,
            MFA_FIELD, REQUEST_PAYER_FIELD, BYPASS_GOVERNANCE_RETENTION_FIELD, EXPECTED_BUCKET_OWNER_FIELD,
            CHECKSUM_ALGORITHM_FIELD));

    private static final Map<String, SdkField<?>> SDK_NAME_TO_FIELD = memberNameToFieldInitializer();

    private final String bucket;

    private final Delete delete;

    private final String mfa;

    private final String requestPayer;

    private final Boolean bypassGovernanceRetention;

    private final String expectedBucketOwner;

    private final String checksumAlgorithm;

    private DeleteObjectsRequest(BuilderImpl builder) {
        super(builder);
        this.bucket = builder.bucket;
        this.delete = builder.delete;
        this.mfa = builder.mfa;
        this.requestPayer = builder.requestPayer;
        this.bypassGovernanceRetention = builder.bypassGovernanceRetention;
        this.expectedBucketOwner = builder.expectedBucketOwner;
        this.checksumAlgorithm = builder.checksumAlgorithm;
    }

    /**
     * <p>
     * The bucket name containing the objects to delete.
     * </p>
     * <p>
     * <b>Directory buckets</b> - When you use this operation with a directory bucket, you must use virtual-hosted-style
     * requests in the format <code> <i>Bucket-name</i>.s3express-<i>zone-id</i>.<i>region-code</i>.amazonaws.com</code>
     * . Path-style requests are not supported. Directory bucket names must be unique in the chosen Zone (Availability
     * Zone or Local Zone). Bucket names must follow the format
     * <code> <i>bucket-base-name</i>--<i>zone-id</i>--x-s3</code> (for example,
     * <code> <i>amzn-s3-demo-bucket</i>--<i>usw2-az1</i>--x-s3</code>). For information about bucket naming
     * restrictions, see <a
     * href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/directory-bucket-naming-rules.html">Directory bucket
     * naming rules</a> in the <i>Amazon S3 User Guide</i>.
     * </p>
     * <p>
     * <b>Access points</b> - When you use this action with an access point for general purpose buckets, you must
     * provide the alias of the access point in place of the bucket name or specify the access point ARN. When you use
     * this action with an access point for directory buckets, you must provide the access point name in place of the
     * bucket name. When using the access point ARN, you must direct requests to the access point hostname. The access
     * point hostname takes the form <i>AccessPointName</i>-<i>AccountId</i>.s3-accesspoint.<i>Region</i>.amazonaws.com.
     * When using this action with an access point through the Amazon Web Services SDKs, you provide the access point
     * ARN in place of the bucket name. For more information about access point ARNs, see <a
     * href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/using-access-points.html">Using access points</a> in
     * the <i>Amazon S3 User Guide</i>.
     * </p>
     * <note>
     * <p>
     * Object Lambda access points are not supported by directory buckets.
     * </p>
     * </note>
     * <p>
     * <b>S3 on Outposts</b> - When you use this action with S3 on Outposts, you must direct requests to the S3 on
     * Outposts hostname. The S3 on Outposts hostname takes the form
     * <code> <i>AccessPointName</i>-<i>AccountId</i>.<i>outpostID</i>.s3-outposts.<i>Region</i>.amazonaws.com</code>.
     * When you use this action with S3 on Outposts, the destination bucket must be the Outposts access point ARN or the
     * access point alias. For more information about S3 on Outposts, see <a
     * href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/S3onOutposts.html">What is S3 on Outposts?</a> in the
     * <i>Amazon S3 User Guide</i>.
     * </p>
     * 
     * @return The bucket name containing the objects to delete. </p>
     *         <p>
     *         <b>Directory buckets</b> - When you use this operation with a directory bucket, you must use
     *         virtual-hosted-style requests in the format
     *         <code> <i>Bucket-name</i>.s3express-<i>zone-id</i>.<i>region-code</i>.amazonaws.com</code>. Path-style
     *         requests are not supported. Directory bucket names must be unique in the chosen Zone (Availability Zone
     *         or Local Zone). Bucket names must follow the format
     *         <code> <i>bucket-base-name</i>--<i>zone-id</i>--x-s3</code> (for example,
     *         <code> <i>amzn-s3-demo-bucket</i>--<i>usw2-az1</i>--x-s3</code>). For information about bucket naming
     *         restrictions, see <a
     *         href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/directory-bucket-naming-rules.html">Directory
     *         bucket naming rules</a> in the <i>Amazon S3 User Guide</i>.
     *         </p>
     *         <p>
     *         <b>Access points</b> - When you use this action with an access point for general purpose buckets, you
     *         must provide the alias of the access point in place of the bucket name or specify the access point ARN.
     *         When you use this action with an access point for directory buckets, you must provide the access point
     *         name in place of the bucket name. When using the access point ARN, you must direct requests to the access
     *         point hostname. The access point hostname takes the form
     *         <i>AccessPointName</i>-<i>AccountId</i>.s3-accesspoint.<i>Region</i>.amazonaws.com. When using this
     *         action with an access point through the Amazon Web Services SDKs, you provide the access point ARN in
     *         place of the bucket name. For more information about access point ARNs, see <a
     *         href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/using-access-points.html">Using access
     *         points</a> in the <i>Amazon S3 User Guide</i>.
     *         </p>
     *         <note>
     *         <p>
     *         Object Lambda access points are not supported by directory buckets.
     *         </p>
     *         </note>
     *         <p>
     *         <b>S3 on Outposts</b> - When you use this action with S3 on Outposts, you must direct requests to the S3
     *         on Outposts hostname. The S3 on Outposts hostname takes the form
     *         <code> <i>AccessPointName</i>-<i>AccountId</i>.<i>outpostID</i>.s3-outposts.<i>Region</i>.amazonaws.com</code>
     *         . When you use this action with S3 on Outposts, the destination bucket must be the Outposts access point
     *         ARN or the access point alias. For more information about S3 on Outposts, see <a
     *         href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/S3onOutposts.html">What is S3 on
     *         Outposts?</a> in the <i>Amazon S3 User Guide</i>.
     */
    public final String bucket() {
        return bucket;
    }

    /**
     * <p>
     * Container for the request.
     * </p>
     * 
     * @return Container for the request.
     */
    public final Delete delete() {
        return delete;
    }

    /**
     * <p>
     * The concatenation of the authentication device's serial number, a space, and the value that is displayed on your
     * authentication device. Required to permanently delete a versioned object if versioning is configured with MFA
     * delete enabled.
     * </p>
     * <p>
     * When performing the <code>DeleteObjects</code> operation on an MFA delete enabled bucket, which attempts to
     * delete the specified versioned objects, you must include an MFA token. If you don't provide an MFA token, the
     * entire request will fail, even if there are non-versioned objects that you are trying to delete. If you provide
     * an invalid token, whether there are versioned object keys in the request or not, the entire Multi-Object Delete
     * request will fail. For information about MFA Delete, see <a
     * href="https://docs.aws.amazon.com/AmazonS3/latest/dev/Versioning.html#MultiFactorAuthenticationDelete"> MFA
     * Delete</a> in the <i>Amazon S3 User Guide</i>.
     * </p>
     * <note>
     * <p>
     * This functionality is not supported for directory buckets.
     * </p>
     * </note>
     * 
     * @return The concatenation of the authentication device's serial number, a space, and the value that is displayed
     *         on your authentication device. Required to permanently delete a versioned object if versioning is
     *         configured with MFA delete enabled.</p>
     *         <p>
     *         When performing the <code>DeleteObjects</code> operation on an MFA delete enabled bucket, which attempts
     *         to delete the specified versioned objects, you must include an MFA token. If you don't provide an MFA
     *         token, the entire request will fail, even if there are non-versioned objects that you are trying to
     *         delete. If you provide an invalid token, whether there are versioned object keys in the request or not,
     *         the entire Multi-Object Delete request will fail. For information about MFA Delete, see <a
     *         href="https://docs.aws.amazon.com/AmazonS3/latest/dev/Versioning.html#MultiFactorAuthenticationDelete">
     *         MFA Delete</a> in the <i>Amazon S3 User Guide</i>.
     *         </p>
     *         <note>
     *         <p>
     *         This functionality is not supported for directory buckets.
     *         </p>
     */
    public final String mfa() {
        return mfa;
    }

    /**
     * Returns the value of the RequestPayer property for this object.
     * <p>
     * If the service returns an enum value that is not available in the current SDK version, {@link #requestPayer} will
     * return {@link RequestPayer#UNKNOWN_TO_SDK_VERSION}. The raw value returned by the service is available from
     * {@link #requestPayerAsString}.
     * </p>
     * 
     * @return The value of the RequestPayer property for this object.
     * @see RequestPayer
     */
    public final RequestPayer requestPayer() {
        return RequestPayer.fromValue(requestPayer);
    }

    /**
     * Returns the value of the RequestPayer property for this object.
     * <p>
     * If the service returns an enum value that is not available in the current SDK version, {@link #requestPayer} will
     * return {@link RequestPayer#UNKNOWN_TO_SDK_VERSION}. The raw value returned by the service is available from
     * {@link #requestPayerAsString}.
     * </p>
     * 
     * @return The value of the RequestPayer property for this object.
     * @see RequestPayer
     */
    public final String requestPayerAsString() {
        return requestPayer;
    }

    /**
     * <p>
     * Specifies whether you want to delete this object even if it has a Governance-type Object Lock in place. To use
     * this header, you must have the <code>s3:BypassGovernanceRetention</code> permission.
     * </p>
     * <note>
     * <p>
     * This functionality is not supported for directory buckets.
     * </p>
     * </note>
     * 
     * @return Specifies whether you want to delete this object even if it has a Governance-type Object Lock in place.
     *         To use this header, you must have the <code>s3:BypassGovernanceRetention</code> permission.</p> <note>
     *         <p>
     *         This functionality is not supported for directory buckets.
     *         </p>
     */
    public final Boolean bypassGovernanceRetention() {
        return bypassGovernanceRetention;
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

    /**
     * <p>
     * Indicates the algorithm used to create the checksum for the object when you use the SDK. This header will not
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
     * <p>
     * If you provide an individual checksum, Amazon S3 ignores any provided <code>ChecksumAlgorithm</code> parameter.
     * </p>
     * <p>
     * If the service returns an enum value that is not available in the current SDK version, {@link #checksumAlgorithm}
     * will return {@link ChecksumAlgorithm#UNKNOWN_TO_SDK_VERSION}. The raw value returned by the service is available
     * from {@link #checksumAlgorithmAsString}.
     * </p>
     * 
     * @return Indicates the algorithm used to create the checksum for the object when you use the SDK. This header will
     *         not provide any additional functionality if you don't use the SDK. When you send this header, there must
     *         be a corresponding <code>x-amz-checksum-<i>algorithm</i> </code> or <code>x-amz-trailer</code> header
     *         sent. Otherwise, Amazon S3 fails the request with the HTTP status code <code>400 Bad Request</code>.</p>
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
     * Indicates the algorithm used to create the checksum for the object when you use the SDK. This header will not
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
     * <p>
     * If you provide an individual checksum, Amazon S3 ignores any provided <code>ChecksumAlgorithm</code> parameter.
     * </p>
     * <p>
     * If the service returns an enum value that is not available in the current SDK version, {@link #checksumAlgorithm}
     * will return {@link ChecksumAlgorithm#UNKNOWN_TO_SDK_VERSION}. The raw value returned by the service is available
     * from {@link #checksumAlgorithmAsString}.
     * </p>
     * 
     * @return Indicates the algorithm used to create the checksum for the object when you use the SDK. This header will
     *         not provide any additional functionality if you don't use the SDK. When you send this header, there must
     *         be a corresponding <code>x-amz-checksum-<i>algorithm</i> </code> or <code>x-amz-trailer</code> header
     *         sent. Otherwise, Amazon S3 fails the request with the HTTP status code <code>400 Bad Request</code>.</p>
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
     *         <p>
     *         If you provide an individual checksum, Amazon S3 ignores any provided <code>ChecksumAlgorithm</code>
     *         parameter.
     * @see ChecksumAlgorithm
     */
    public final String checksumAlgorithmAsString() {
        return checksumAlgorithm;
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
        hashCode = 31 * hashCode + Objects.hashCode(delete());
        hashCode = 31 * hashCode + Objects.hashCode(mfa());
        hashCode = 31 * hashCode + Objects.hashCode(requestPayerAsString());
        hashCode = 31 * hashCode + Objects.hashCode(bypassGovernanceRetention());
        hashCode = 31 * hashCode + Objects.hashCode(expectedBucketOwner());
        hashCode = 31 * hashCode + Objects.hashCode(checksumAlgorithmAsString());
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
        if (!(obj instanceof DeleteObjectsRequest)) {
            return false;
        }
        DeleteObjectsRequest other = (DeleteObjectsRequest) obj;
        return Objects.equals(bucket(), other.bucket()) && Objects.equals(delete(), other.delete())
                && Objects.equals(mfa(), other.mfa()) && Objects.equals(requestPayerAsString(), other.requestPayerAsString())
                && Objects.equals(bypassGovernanceRetention(), other.bypassGovernanceRetention())
                && Objects.equals(expectedBucketOwner(), other.expectedBucketOwner())
                && Objects.equals(checksumAlgorithmAsString(), other.checksumAlgorithmAsString());
    }

    /**
     * Returns a string representation of this object. This is useful for testing and debugging. Sensitive data will be
     * redacted from this string using a placeholder value.
     */
    @Override
    public final String toString() {
        return ToString.builder("DeleteObjectsRequest").add("Bucket", bucket()).add("Delete", delete()).add("MFA", mfa())
                .add("RequestPayer", requestPayerAsString()).add("BypassGovernanceRetention", bypassGovernanceRetention())
                .add("ExpectedBucketOwner", expectedBucketOwner()).add("ChecksumAlgorithm", checksumAlgorithmAsString()).build();
    }

    public final <T> Optional<T> getValueForField(String fieldName, Class<T> clazz) {
        switch (fieldName) {
        case "Bucket":
            return Optional.ofNullable(clazz.cast(bucket()));
        case "Delete":
            return Optional.ofNullable(clazz.cast(delete()));
        case "MFA":
            return Optional.ofNullable(clazz.cast(mfa()));
        case "RequestPayer":
            return Optional.ofNullable(clazz.cast(requestPayerAsString()));
        case "BypassGovernanceRetention":
            return Optional.ofNullable(clazz.cast(bypassGovernanceRetention()));
        case "ExpectedBucketOwner":
            return Optional.ofNullable(clazz.cast(expectedBucketOwner()));
        case "ChecksumAlgorithm":
            return Optional.ofNullable(clazz.cast(checksumAlgorithmAsString()));
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
        map.put("Delete", DELETE_FIELD);
        map.put("x-amz-mfa", MFA_FIELD);
        map.put("x-amz-request-payer", REQUEST_PAYER_FIELD);
        map.put("x-amz-bypass-governance-retention", BYPASS_GOVERNANCE_RETENTION_FIELD);
        map.put("x-amz-expected-bucket-owner", EXPECTED_BUCKET_OWNER_FIELD);
        map.put("x-amz-sdk-checksum-algorithm", CHECKSUM_ALGORITHM_FIELD);
        return Collections.unmodifiableMap(map);
    }

    private static <T> Function<Object, T> getter(Function<DeleteObjectsRequest, T> g) {
        return obj -> g.apply((DeleteObjectsRequest) obj);
    }

    private static <T> BiConsumer<Object, T> setter(BiConsumer<Builder, T> s) {
        return (obj, val) -> s.accept((Builder) obj, val);
    }

    @Mutable
    @NotThreadSafe
    public interface Builder extends S3Request.Builder, SdkPojo, CopyableBuilder<Builder, DeleteObjectsRequest> {
        /**
         * <p>
         * The bucket name containing the objects to delete.
         * </p>
         * <p>
         * <b>Directory buckets</b> - When you use this operation with a directory bucket, you must use
         * virtual-hosted-style requests in the format
         * <code> <i>Bucket-name</i>.s3express-<i>zone-id</i>.<i>region-code</i>.amazonaws.com</code>. Path-style
         * requests are not supported. Directory bucket names must be unique in the chosen Zone (Availability Zone or
         * Local Zone). Bucket names must follow the format <code> <i>bucket-base-name</i>--<i>zone-id</i>--x-s3</code>
         * (for example, <code> <i>amzn-s3-demo-bucket</i>--<i>usw2-az1</i>--x-s3</code>). For information about bucket
         * naming restrictions, see <a
         * href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/directory-bucket-naming-rules.html">Directory
         * bucket naming rules</a> in the <i>Amazon S3 User Guide</i>.
         * </p>
         * <p>
         * <b>Access points</b> - When you use this action with an access point for general purpose buckets, you must
         * provide the alias of the access point in place of the bucket name or specify the access point ARN. When you
         * use this action with an access point for directory buckets, you must provide the access point name in place
         * of the bucket name. When using the access point ARN, you must direct requests to the access point hostname.
         * The access point hostname takes the form
         * <i>AccessPointName</i>-<i>AccountId</i>.s3-accesspoint.<i>Region</i>.amazonaws.com. When using this action
         * with an access point through the Amazon Web Services SDKs, you provide the access point ARN in place of the
         * bucket name. For more information about access point ARNs, see <a
         * href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/using-access-points.html">Using access points</a>
         * in the <i>Amazon S3 User Guide</i>.
         * </p>
         * <note>
         * <p>
         * Object Lambda access points are not supported by directory buckets.
         * </p>
         * </note>
         * <p>
         * <b>S3 on Outposts</b> - When you use this action with S3 on Outposts, you must direct requests to the S3 on
         * Outposts hostname. The S3 on Outposts hostname takes the form
         * <code> <i>AccessPointName</i>-<i>AccountId</i>.<i>outpostID</i>.s3-outposts.<i>Region</i>.amazonaws.com</code>
         * . When you use this action with S3 on Outposts, the destination bucket must be the Outposts access point ARN
         * or the access point alias. For more information about S3 on Outposts, see <a
         * href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/S3onOutposts.html">What is S3 on Outposts?</a> in
         * the <i>Amazon S3 User Guide</i>.
         * </p>
         * 
         * @param bucket
         *        The bucket name containing the objects to delete. </p>
         *        <p>
         *        <b>Directory buckets</b> - When you use this operation with a directory bucket, you must use
         *        virtual-hosted-style requests in the format
         *        <code> <i>Bucket-name</i>.s3express-<i>zone-id</i>.<i>region-code</i>.amazonaws.com</code>. Path-style
         *        requests are not supported. Directory bucket names must be unique in the chosen Zone (Availability
         *        Zone or Local Zone). Bucket names must follow the format
         *        <code> <i>bucket-base-name</i>--<i>zone-id</i>--x-s3</code> (for example,
         *        <code> <i>amzn-s3-demo-bucket</i>--<i>usw2-az1</i>--x-s3</code>). For information about bucket naming
         *        restrictions, see <a
         *        href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/directory-bucket-naming-rules.html"
         *        >Directory bucket naming rules</a> in the <i>Amazon S3 User Guide</i>.
         *        </p>
         *        <p>
         *        <b>Access points</b> - When you use this action with an access point for general purpose buckets, you
         *        must provide the alias of the access point in place of the bucket name or specify the access point
         *        ARN. When you use this action with an access point for directory buckets, you must provide the access
         *        point name in place of the bucket name. When using the access point ARN, you must direct requests to
         *        the access point hostname. The access point hostname takes the form
         *        <i>AccessPointName</i>-<i>AccountId</i>.s3-accesspoint.<i>Region</i>.amazonaws.com. When using this
         *        action with an access point through the Amazon Web Services SDKs, you provide the access point ARN in
         *        place of the bucket name. For more information about access point ARNs, see <a
         *        href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/using-access-points.html">Using access
         *        points</a> in the <i>Amazon S3 User Guide</i>.
         *        </p>
         *        <note>
         *        <p>
         *        Object Lambda access points are not supported by directory buckets.
         *        </p>
         *        </note>
         *        <p>
         *        <b>S3 on Outposts</b> - When you use this action with S3 on Outposts, you must direct requests to the
         *        S3 on Outposts hostname. The S3 on Outposts hostname takes the form
         *        <code> <i>AccessPointName</i>-<i>AccountId</i>.<i>outpostID</i>.s3-outposts.<i>Region</i>.amazonaws.com</code>
         *        . When you use this action with S3 on Outposts, the destination bucket must be the Outposts access
         *        point ARN or the access point alias. For more information about S3 on Outposts, see <a
         *        href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/S3onOutposts.html">What is S3 on
         *        Outposts?</a> in the <i>Amazon S3 User Guide</i>.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder bucket(String bucket);

        /**
         * <p>
         * Container for the request.
         * </p>
         * 
         * @param delete
         *        Container for the request.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder delete(Delete delete);

        /**
         * <p>
         * Container for the request.
         * </p>
         * This is a convenience method that creates an instance of the {@link Delete.Builder} avoiding the need to
         * create one manually via {@link Delete#builder()}.
         *
         * <p>
         * When the {@link Consumer} completes, {@link Delete.Builder#build()} is called immediately and its result is
         * passed to {@link #delete(Delete)}.
         * 
         * @param delete
         *        a consumer that will call methods on {@link Delete.Builder}
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see #delete(Delete)
         */
        default Builder delete(Consumer<Delete.Builder> delete) {
            return delete(Delete.builder().applyMutation(delete).build());
        }

        /**
         * <p>
         * The concatenation of the authentication device's serial number, a space, and the value that is displayed on
         * your authentication device. Required to permanently delete a versioned object if versioning is configured
         * with MFA delete enabled.
         * </p>
         * <p>
         * When performing the <code>DeleteObjects</code> operation on an MFA delete enabled bucket, which attempts to
         * delete the specified versioned objects, you must include an MFA token. If you don't provide an MFA token, the
         * entire request will fail, even if there are non-versioned objects that you are trying to delete. If you
         * provide an invalid token, whether there are versioned object keys in the request or not, the entire
         * Multi-Object Delete request will fail. For information about MFA Delete, see <a
         * href="https://docs.aws.amazon.com/AmazonS3/latest/dev/Versioning.html#MultiFactorAuthenticationDelete"> MFA
         * Delete</a> in the <i>Amazon S3 User Guide</i>.
         * </p>
         * <note>
         * <p>
         * This functionality is not supported for directory buckets.
         * </p>
         * </note>
         * 
         * @param mfa
         *        The concatenation of the authentication device's serial number, a space, and the value that is
         *        displayed on your authentication device. Required to permanently delete a versioned object if
         *        versioning is configured with MFA delete enabled.</p>
         *        <p>
         *        When performing the <code>DeleteObjects</code> operation on an MFA delete enabled bucket, which
         *        attempts to delete the specified versioned objects, you must include an MFA token. If you don't
         *        provide an MFA token, the entire request will fail, even if there are non-versioned objects that you
         *        are trying to delete. If you provide an invalid token, whether there are versioned object keys in the
         *        request or not, the entire Multi-Object Delete request will fail. For information about MFA Delete,
         *        see <a href=
         *        "https://docs.aws.amazon.com/AmazonS3/latest/dev/Versioning.html#MultiFactorAuthenticationDelete"> MFA
         *        Delete</a> in the <i>Amazon S3 User Guide</i>.
         *        </p>
         *        <note>
         *        <p>
         *        This functionality is not supported for directory buckets.
         *        </p>
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder mfa(String mfa);

        /**
         * Sets the value of the RequestPayer property for this object.
         *
         * @param requestPayer
         *        The new value for the RequestPayer property for this object.
         * @see RequestPayer
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see RequestPayer
         */
        Builder requestPayer(String requestPayer);

        /**
         * Sets the value of the RequestPayer property for this object.
         *
         * @param requestPayer
         *        The new value for the RequestPayer property for this object.
         * @see RequestPayer
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see RequestPayer
         */
        Builder requestPayer(RequestPayer requestPayer);

        /**
         * <p>
         * Specifies whether you want to delete this object even if it has a Governance-type Object Lock in place. To
         * use this header, you must have the <code>s3:BypassGovernanceRetention</code> permission.
         * </p>
         * <note>
         * <p>
         * This functionality is not supported for directory buckets.
         * </p>
         * </note>
         * 
         * @param bypassGovernanceRetention
         *        Specifies whether you want to delete this object even if it has a Governance-type Object Lock in
         *        place. To use this header, you must have the <code>s3:BypassGovernanceRetention</code> permission.</p>
         *        <note>
         *        <p>
         *        This functionality is not supported for directory buckets.
         *        </p>
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder bypassGovernanceRetention(Boolean bypassGovernanceRetention);

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

        /**
         * <p>
         * Indicates the algorithm used to create the checksum for the object when you use the SDK. This header will not
         * provide any additional functionality if you don't use the SDK. When you send this header, there must be a
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
         * <p>
         * If you provide an individual checksum, Amazon S3 ignores any provided <code>ChecksumAlgorithm</code>
         * parameter.
         * </p>
         * 
         * @param checksumAlgorithm
         *        Indicates the algorithm used to create the checksum for the object when you use the SDK. This header
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
         * Indicates the algorithm used to create the checksum for the object when you use the SDK. This header will not
         * provide any additional functionality if you don't use the SDK. When you send this header, there must be a
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
         * <p>
         * If you provide an individual checksum, Amazon S3 ignores any provided <code>ChecksumAlgorithm</code>
         * parameter.
         * </p>
         * 
         * @param checksumAlgorithm
         *        Indicates the algorithm used to create the checksum for the object when you use the SDK. This header
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
         *        <p>
         *        If you provide an individual checksum, Amazon S3 ignores any provided <code>ChecksumAlgorithm</code>
         *        parameter.
         * @see ChecksumAlgorithm
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see ChecksumAlgorithm
         */
        Builder checksumAlgorithm(ChecksumAlgorithm checksumAlgorithm);

        @Override
        Builder overrideConfiguration(AwsRequestOverrideConfiguration overrideConfiguration);

        @Override
        Builder overrideConfiguration(Consumer<AwsRequestOverrideConfiguration.Builder> builderConsumer);
    }

    static final class BuilderImpl extends S3Request.BuilderImpl implements Builder {
        private String bucket;

        private Delete delete;

        private String mfa;

        private String requestPayer;

        private Boolean bypassGovernanceRetention;

        private String expectedBucketOwner;

        private String checksumAlgorithm;

        private BuilderImpl() {
        }

        private BuilderImpl(DeleteObjectsRequest model) {
            super(model);
            bucket(model.bucket);
            delete(model.delete);
            mfa(model.mfa);
            requestPayer(model.requestPayer);
            bypassGovernanceRetention(model.bypassGovernanceRetention);
            expectedBucketOwner(model.expectedBucketOwner);
            checksumAlgorithm(model.checksumAlgorithm);
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

        public final Delete.Builder getDelete() {
            return delete != null ? delete.toBuilder() : null;
        }

        public final void setDelete(Delete.BuilderImpl delete) {
            this.delete = delete != null ? delete.build() : null;
        }

        @Override
        public final Builder delete(Delete delete) {
            this.delete = delete;
            return this;
        }

        public final String getMfa() {
            return mfa;
        }

        public final void setMfa(String mfa) {
            this.mfa = mfa;
        }

        @Override
        public final Builder mfa(String mfa) {
            this.mfa = mfa;
            return this;
        }

        public final String getRequestPayer() {
            return requestPayer;
        }

        public final void setRequestPayer(String requestPayer) {
            this.requestPayer = requestPayer;
        }

        @Override
        public final Builder requestPayer(String requestPayer) {
            this.requestPayer = requestPayer;
            return this;
        }

        @Override
        public final Builder requestPayer(RequestPayer requestPayer) {
            this.requestPayer(requestPayer == null ? null : requestPayer.toString());
            return this;
        }

        public final Boolean getBypassGovernanceRetention() {
            return bypassGovernanceRetention;
        }

        public final void setBypassGovernanceRetention(Boolean bypassGovernanceRetention) {
            this.bypassGovernanceRetention = bypassGovernanceRetention;
        }

        @Override
        public final Builder bypassGovernanceRetention(Boolean bypassGovernanceRetention) {
            this.bypassGovernanceRetention = bypassGovernanceRetention;
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
        public DeleteObjectsRequest build() {
            return new DeleteObjectsRequest(this);
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
