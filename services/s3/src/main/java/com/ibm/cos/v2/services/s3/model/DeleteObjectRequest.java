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

import java.time.Instant;
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
import com.ibm.cos.v2.core.traits.TimestampFormatTrait;
import com.ibm.cos.v2.utils.ToString;
import com.ibm.cos.v2.utils.builder.CopyableBuilder;
import com.ibm.cos.v2.utils.builder.ToCopyableBuilder;

/**
 */
@Generated("com.ibm.cos.v2:codegen")
public final class DeleteObjectRequest extends S3Request implements
        ToCopyableBuilder<DeleteObjectRequest.Builder, DeleteObjectRequest> {
    private static final SdkField<String> BUCKET_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("Bucket")
            .getter(getter(DeleteObjectRequest::bucket))
            .setter(setter(Builder::bucket))
            .traits(LocationTrait.builder().location(MarshallLocation.PATH).locationName("Bucket")
                    .unmarshallLocationName("Bucket").build(), RequiredTrait.create()).build();

    private static final SdkField<String> KEY_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("Key")
            .getter(getter(DeleteObjectRequest::key))
            .setter(setter(Builder::key))
            .traits(LocationTrait.builder().location(MarshallLocation.GREEDY_PATH).locationName("Key")
                    .unmarshallLocationName("Key").build(), RequiredTrait.create()).build();

    private static final SdkField<String> MFA_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("MFA")
            .getter(getter(DeleteObjectRequest::mfa))
            .setter(setter(Builder::mfa))
            .traits(LocationTrait.builder().location(MarshallLocation.HEADER).locationName("x-amz-mfa")
                    .unmarshallLocationName("x-amz-mfa").build()).build();

    private static final SdkField<String> VERSION_ID_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("VersionId")
            .getter(getter(DeleteObjectRequest::versionId))
            .setter(setter(Builder::versionId))
            .traits(LocationTrait.builder().location(MarshallLocation.QUERY_PARAM).locationName("versionId")
                    .unmarshallLocationName("versionId").build()).build();

    private static final SdkField<String> REQUEST_PAYER_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("RequestPayer")
            .getter(getter(DeleteObjectRequest::requestPayerAsString))
            .setter(setter(Builder::requestPayer))
            .traits(LocationTrait.builder().location(MarshallLocation.HEADER).locationName("x-amz-request-payer")
                    .unmarshallLocationName("x-amz-request-payer").build()).build();

    private static final SdkField<Boolean> BYPASS_GOVERNANCE_RETENTION_FIELD = SdkField
            .<Boolean> builder(MarshallingType.BOOLEAN)
            .memberName("BypassGovernanceRetention")
            .getter(getter(DeleteObjectRequest::bypassGovernanceRetention))
            .setter(setter(Builder::bypassGovernanceRetention))
            .traits(LocationTrait.builder().location(MarshallLocation.HEADER).locationName("x-amz-bypass-governance-retention")
                    .unmarshallLocationName("x-amz-bypass-governance-retention").build()).build();

    private static final SdkField<String> EXPECTED_BUCKET_OWNER_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("ExpectedBucketOwner")
            .getter(getter(DeleteObjectRequest::expectedBucketOwner))
            .setter(setter(Builder::expectedBucketOwner))
            .traits(LocationTrait.builder().location(MarshallLocation.HEADER).locationName("x-amz-expected-bucket-owner")
                    .unmarshallLocationName("x-amz-expected-bucket-owner").build()).build();

    private static final SdkField<String> IF_MATCH_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("IfMatch")
            .getter(getter(DeleteObjectRequest::ifMatch))
            .setter(setter(Builder::ifMatch))
            .traits(LocationTrait.builder().location(MarshallLocation.HEADER).locationName("If-Match")
                    .unmarshallLocationName("If-Match").build()).build();

    private static final SdkField<Instant> IF_MATCH_LAST_MODIFIED_TIME_FIELD = SdkField
            .<Instant> builder(MarshallingType.INSTANT)
            .memberName("IfMatchLastModifiedTime")
            .getter(getter(DeleteObjectRequest::ifMatchLastModifiedTime))
            .setter(setter(Builder::ifMatchLastModifiedTime))
            .traits(LocationTrait.builder().location(MarshallLocation.HEADER).locationName("x-amz-if-match-last-modified-time")
                    .unmarshallLocationName("x-amz-if-match-last-modified-time").build(),
                    TimestampFormatTrait.create(TimestampFormatTrait.Format.RFC_822)).build();

    private static final SdkField<Long> IF_MATCH_SIZE_FIELD = SdkField
            .<Long> builder(MarshallingType.LONG)
            .memberName("IfMatchSize")
            .getter(getter(DeleteObjectRequest::ifMatchSize))
            .setter(setter(Builder::ifMatchSize))
            .traits(LocationTrait.builder().location(MarshallLocation.HEADER).locationName("x-amz-if-match-size")
                    .unmarshallLocationName("x-amz-if-match-size").build()).build();

    private static final List<SdkField<?>> SDK_FIELDS = Collections.unmodifiableList(Arrays.asList(BUCKET_FIELD, KEY_FIELD,
            MFA_FIELD, VERSION_ID_FIELD, REQUEST_PAYER_FIELD, BYPASS_GOVERNANCE_RETENTION_FIELD, EXPECTED_BUCKET_OWNER_FIELD,
            IF_MATCH_FIELD, IF_MATCH_LAST_MODIFIED_TIME_FIELD, IF_MATCH_SIZE_FIELD));

    private static final Map<String, SdkField<?>> SDK_NAME_TO_FIELD = memberNameToFieldInitializer();

    private final String bucket;

    private final String key;

    private final String mfa;

    private final String versionId;

    private final String requestPayer;

    private final Boolean bypassGovernanceRetention;

    private final String expectedBucketOwner;

    private final String ifMatch;

    private final Instant ifMatchLastModifiedTime;

    private final Long ifMatchSize;

    private DeleteObjectRequest(BuilderImpl builder) {
        super(builder);
        this.bucket = builder.bucket;
        this.key = builder.key;
        this.mfa = builder.mfa;
        this.versionId = builder.versionId;
        this.requestPayer = builder.requestPayer;
        this.bypassGovernanceRetention = builder.bypassGovernanceRetention;
        this.expectedBucketOwner = builder.expectedBucketOwner;
        this.ifMatch = builder.ifMatch;
        this.ifMatchLastModifiedTime = builder.ifMatchLastModifiedTime;
        this.ifMatchSize = builder.ifMatchSize;
    }

    /**
     * <p>
     * The bucket name of the bucket containing the object.
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
     * @return The bucket name of the bucket containing the object. </p>
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
     * Key name of the object to delete.
     * </p>
     * 
     * @return Key name of the object to delete.
     */
    public final String key() {
        return key;
    }

    /**
     * <p>
     * The concatenation of the authentication device's serial number, a space, and the value that is displayed on your
     * authentication device. Required to permanently delete a versioned object if versioning is configured with MFA
     * delete enabled.
     * </p>
     * <note>
     * <p>
     * This functionality is not supported for directory buckets.
     * </p>
     * </note>
     * 
     * @return The concatenation of the authentication device's serial number, a space, and the value that is displayed
     *         on your authentication device. Required to permanently delete a versioned object if versioning is
     *         configured with MFA delete enabled.</p> <note>
     *         <p>
     *         This functionality is not supported for directory buckets.
     *         </p>
     */
    public final String mfa() {
        return mfa;
    }

    /**
     * <p>
     * Version ID used to reference a specific version of the object.
     * </p>
     * <note>
     * <p>
     * For directory buckets in this API operation, only the <code>null</code> value of the version ID is supported.
     * </p>
     * </note>
     * 
     * @return Version ID used to reference a specific version of the object.</p> <note>
     *         <p>
     *         For directory buckets in this API operation, only the <code>null</code> value of the version ID is
     *         supported.
     *         </p>
     */
    public final String versionId() {
        return versionId;
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
     * Indicates whether S3 Object Lock should bypass Governance-mode restrictions to process this operation. To use
     * this header, you must have the <code>s3:BypassGovernanceRetention</code> permission.
     * </p>
     * <note>
     * <p>
     * This functionality is not supported for directory buckets.
     * </p>
     * </note>
     * 
     * @return Indicates whether S3 Object Lock should bypass Governance-mode restrictions to process this operation. To
     *         use this header, you must have the <code>s3:BypassGovernanceRetention</code> permission.</p> <note>
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
     * The <code>If-Match</code> header field makes the request method conditional on ETags. If the ETag value does not
     * match, the operation returns a <code>412 Precondition Failed</code> error. If the ETag matches or if the object
     * doesn't exist, the operation will return a <code>204 Success (No Content) response</code>.
     * </p>
     * <p>
     * For more information about conditional requests, see <a href="https://tools.ietf.org/html/rfc7232">RFC 7232</a>.
     * </p>
     * <note>
     * <p>
     * This functionality is only supported for directory buckets.
     * </p>
     * </note>
     * 
     * @return The <code>If-Match</code> header field makes the request method conditional on ETags. If the ETag value
     *         does not match, the operation returns a <code>412 Precondition Failed</code> error. If the ETag matches
     *         or if the object doesn't exist, the operation will return a
     *         <code>204 Success (No Content) response</code>.</p>
     *         <p>
     *         For more information about conditional requests, see <a href="https://tools.ietf.org/html/rfc7232">RFC
     *         7232</a>.
     *         </p>
     *         <note>
     *         <p>
     *         This functionality is only supported for directory buckets.
     *         </p>
     */
    public final String ifMatch() {
        return ifMatch;
    }

    /**
     * <p>
     * If present, the object is deleted only if its modification times matches the provided <code>Timestamp</code>. If
     * the <code>Timestamp</code> values do not match, the operation returns a <code>412 Precondition Failed</code>
     * error. If the <code>Timestamp</code> matches or if the object doesn’t exist, the operation returns a
     * <code>204 Success (No Content)</code> response.
     * </p>
     * <note>
     * <p>
     * This functionality is only supported for directory buckets.
     * </p>
     * </note>
     * 
     * @return If present, the object is deleted only if its modification times matches the provided
     *         <code>Timestamp</code>. If the <code>Timestamp</code> values do not match, the operation returns a
     *         <code>412 Precondition Failed</code> error. If the <code>Timestamp</code> matches or if the object
     *         doesn’t exist, the operation returns a <code>204 Success (No Content)</code> response.</p> <note>
     *         <p>
     *         This functionality is only supported for directory buckets.
     *         </p>
     */
    public final Instant ifMatchLastModifiedTime() {
        return ifMatchLastModifiedTime;
    }

    /**
     * <p>
     * If present, the object is deleted only if its size matches the provided size in bytes. If the <code>Size</code>
     * value does not match, the operation returns a <code>412 Precondition Failed</code> error. If the
     * <code>Size</code> matches or if the object doesn’t exist, the operation returns a
     * <code>204 Success (No Content)</code> response.
     * </p>
     * <note>
     * <p>
     * This functionality is only supported for directory buckets.
     * </p>
     * </note> <important>
     * <p>
     * You can use the <code>If-Match</code>, <code>x-amz-if-match-last-modified-time</code> and
     * <code>x-amz-if-match-size</code> conditional headers in conjunction with each-other or individually.
     * </p>
     * </important>
     * 
     * @return If present, the object is deleted only if its size matches the provided size in bytes. If the
     *         <code>Size</code> value does not match, the operation returns a <code>412 Precondition Failed</code>
     *         error. If the <code>Size</code> matches or if the object doesn’t exist, the operation returns a
     *         <code>204 Success (No Content)</code> response.</p> <note>
     *         <p>
     *         This functionality is only supported for directory buckets.
     *         </p>
     *         </note> <important>
     *         <p>
     *         You can use the <code>If-Match</code>, <code>x-amz-if-match-last-modified-time</code> and
     *         <code>x-amz-if-match-size</code> conditional headers in conjunction with each-other or individually.
     *         </p>
     */
    public final Long ifMatchSize() {
        return ifMatchSize;
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
        hashCode = 31 * hashCode + Objects.hashCode(key());
        hashCode = 31 * hashCode + Objects.hashCode(mfa());
        hashCode = 31 * hashCode + Objects.hashCode(versionId());
        hashCode = 31 * hashCode + Objects.hashCode(requestPayerAsString());
        hashCode = 31 * hashCode + Objects.hashCode(bypassGovernanceRetention());
        hashCode = 31 * hashCode + Objects.hashCode(expectedBucketOwner());
        hashCode = 31 * hashCode + Objects.hashCode(ifMatch());
        hashCode = 31 * hashCode + Objects.hashCode(ifMatchLastModifiedTime());
        hashCode = 31 * hashCode + Objects.hashCode(ifMatchSize());
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
        if (!(obj instanceof DeleteObjectRequest)) {
            return false;
        }
        DeleteObjectRequest other = (DeleteObjectRequest) obj;
        return Objects.equals(bucket(), other.bucket()) && Objects.equals(key(), other.key())
                && Objects.equals(mfa(), other.mfa()) && Objects.equals(versionId(), other.versionId())
                && Objects.equals(requestPayerAsString(), other.requestPayerAsString())
                && Objects.equals(bypassGovernanceRetention(), other.bypassGovernanceRetention())
                && Objects.equals(expectedBucketOwner(), other.expectedBucketOwner())
                && Objects.equals(ifMatch(), other.ifMatch())
                && Objects.equals(ifMatchLastModifiedTime(), other.ifMatchLastModifiedTime())
                && Objects.equals(ifMatchSize(), other.ifMatchSize());
    }

    /**
     * Returns a string representation of this object. This is useful for testing and debugging. Sensitive data will be
     * redacted from this string using a placeholder value.
     */
    @Override
    public final String toString() {
        return ToString.builder("DeleteObjectRequest").add("Bucket", bucket()).add("Key", key()).add("MFA", mfa())
                .add("VersionId", versionId()).add("RequestPayer", requestPayerAsString())
                .add("BypassGovernanceRetention", bypassGovernanceRetention()).add("ExpectedBucketOwner", expectedBucketOwner())
                .add("IfMatch", ifMatch()).add("IfMatchLastModifiedTime", ifMatchLastModifiedTime())
                .add("IfMatchSize", ifMatchSize()).build();
    }

    public final <T> Optional<T> getValueForField(String fieldName, Class<T> clazz) {
        switch (fieldName) {
        case "Bucket":
            return Optional.ofNullable(clazz.cast(bucket()));
        case "Key":
            return Optional.ofNullable(clazz.cast(key()));
        case "MFA":
            return Optional.ofNullable(clazz.cast(mfa()));
        case "VersionId":
            return Optional.ofNullable(clazz.cast(versionId()));
        case "RequestPayer":
            return Optional.ofNullable(clazz.cast(requestPayerAsString()));
        case "BypassGovernanceRetention":
            return Optional.ofNullable(clazz.cast(bypassGovernanceRetention()));
        case "ExpectedBucketOwner":
            return Optional.ofNullable(clazz.cast(expectedBucketOwner()));
        case "IfMatch":
            return Optional.ofNullable(clazz.cast(ifMatch()));
        case "IfMatchLastModifiedTime":
            return Optional.ofNullable(clazz.cast(ifMatchLastModifiedTime()));
        case "IfMatchSize":
            return Optional.ofNullable(clazz.cast(ifMatchSize()));
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
        map.put("Key", KEY_FIELD);
        map.put("x-amz-mfa", MFA_FIELD);
        map.put("versionId", VERSION_ID_FIELD);
        map.put("x-amz-request-payer", REQUEST_PAYER_FIELD);
        map.put("x-amz-bypass-governance-retention", BYPASS_GOVERNANCE_RETENTION_FIELD);
        map.put("x-amz-expected-bucket-owner", EXPECTED_BUCKET_OWNER_FIELD);
        map.put("If-Match", IF_MATCH_FIELD);
        map.put("x-amz-if-match-last-modified-time", IF_MATCH_LAST_MODIFIED_TIME_FIELD);
        map.put("x-amz-if-match-size", IF_MATCH_SIZE_FIELD);
        return Collections.unmodifiableMap(map);
    }

    private static <T> Function<Object, T> getter(Function<DeleteObjectRequest, T> g) {
        return obj -> g.apply((DeleteObjectRequest) obj);
    }

    private static <T> BiConsumer<Object, T> setter(BiConsumer<Builder, T> s) {
        return (obj, val) -> s.accept((Builder) obj, val);
    }

    @Mutable
    @NotThreadSafe
    public interface Builder extends S3Request.Builder, SdkPojo, CopyableBuilder<Builder, DeleteObjectRequest> {
        /**
         * <p>
         * The bucket name of the bucket containing the object.
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
         *        The bucket name of the bucket containing the object. </p>
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
         * Key name of the object to delete.
         * </p>
         * 
         * @param key
         *        Key name of the object to delete.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder key(String key);

        /**
         * <p>
         * The concatenation of the authentication device's serial number, a space, and the value that is displayed on
         * your authentication device. Required to permanently delete a versioned object if versioning is configured
         * with MFA delete enabled.
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
         *        versioning is configured with MFA delete enabled.</p> <note>
         *        <p>
         *        This functionality is not supported for directory buckets.
         *        </p>
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder mfa(String mfa);

        /**
         * <p>
         * Version ID used to reference a specific version of the object.
         * </p>
         * <note>
         * <p>
         * For directory buckets in this API operation, only the <code>null</code> value of the version ID is supported.
         * </p>
         * </note>
         * 
         * @param versionId
         *        Version ID used to reference a specific version of the object.</p> <note>
         *        <p>
         *        For directory buckets in this API operation, only the <code>null</code> value of the version ID is
         *        supported.
         *        </p>
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder versionId(String versionId);

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
         * Indicates whether S3 Object Lock should bypass Governance-mode restrictions to process this operation. To use
         * this header, you must have the <code>s3:BypassGovernanceRetention</code> permission.
         * </p>
         * <note>
         * <p>
         * This functionality is not supported for directory buckets.
         * </p>
         * </note>
         * 
         * @param bypassGovernanceRetention
         *        Indicates whether S3 Object Lock should bypass Governance-mode restrictions to process this operation.
         *        To use this header, you must have the <code>s3:BypassGovernanceRetention</code> permission.</p> <note>
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
         * The <code>If-Match</code> header field makes the request method conditional on ETags. If the ETag value does
         * not match, the operation returns a <code>412 Precondition Failed</code> error. If the ETag matches or if the
         * object doesn't exist, the operation will return a <code>204 Success (No Content) response</code>.
         * </p>
         * <p>
         * For more information about conditional requests, see <a href="https://tools.ietf.org/html/rfc7232">RFC
         * 7232</a>.
         * </p>
         * <note>
         * <p>
         * This functionality is only supported for directory buckets.
         * </p>
         * </note>
         * 
         * @param ifMatch
         *        The <code>If-Match</code> header field makes the request method conditional on ETags. If the ETag
         *        value does not match, the operation returns a <code>412 Precondition Failed</code> error. If the ETag
         *        matches or if the object doesn't exist, the operation will return a
         *        <code>204 Success (No Content) response</code>.</p>
         *        <p>
         *        For more information about conditional requests, see <a href="https://tools.ietf.org/html/rfc7232">RFC
         *        7232</a>.
         *        </p>
         *        <note>
         *        <p>
         *        This functionality is only supported for directory buckets.
         *        </p>
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder ifMatch(String ifMatch);

        /**
         * <p>
         * If present, the object is deleted only if its modification times matches the provided <code>Timestamp</code>.
         * If the <code>Timestamp</code> values do not match, the operation returns a
         * <code>412 Precondition Failed</code> error. If the <code>Timestamp</code> matches or if the object doesn’t
         * exist, the operation returns a <code>204 Success (No Content)</code> response.
         * </p>
         * <note>
         * <p>
         * This functionality is only supported for directory buckets.
         * </p>
         * </note>
         * 
         * @param ifMatchLastModifiedTime
         *        If present, the object is deleted only if its modification times matches the provided
         *        <code>Timestamp</code>. If the <code>Timestamp</code> values do not match, the operation returns a
         *        <code>412 Precondition Failed</code> error. If the <code>Timestamp</code> matches or if the object
         *        doesn’t exist, the operation returns a <code>204 Success (No Content)</code> response.</p> <note>
         *        <p>
         *        This functionality is only supported for directory buckets.
         *        </p>
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder ifMatchLastModifiedTime(Instant ifMatchLastModifiedTime);

        /**
         * <p>
         * If present, the object is deleted only if its size matches the provided size in bytes. If the
         * <code>Size</code> value does not match, the operation returns a <code>412 Precondition Failed</code> error.
         * If the <code>Size</code> matches or if the object doesn’t exist, the operation returns a
         * <code>204 Success (No Content)</code> response.
         * </p>
         * <note>
         * <p>
         * This functionality is only supported for directory buckets.
         * </p>
         * </note> <important>
         * <p>
         * You can use the <code>If-Match</code>, <code>x-amz-if-match-last-modified-time</code> and
         * <code>x-amz-if-match-size</code> conditional headers in conjunction with each-other or individually.
         * </p>
         * </important>
         * 
         * @param ifMatchSize
         *        If present, the object is deleted only if its size matches the provided size in bytes. If the
         *        <code>Size</code> value does not match, the operation returns a <code>412 Precondition Failed</code>
         *        error. If the <code>Size</code> matches or if the object doesn’t exist, the operation returns a
         *        <code>204 Success (No Content)</code> response.</p> <note>
         *        <p>
         *        This functionality is only supported for directory buckets.
         *        </p>
         *        </note> <important>
         *        <p>
         *        You can use the <code>If-Match</code>, <code>x-amz-if-match-last-modified-time</code> and
         *        <code>x-amz-if-match-size</code> conditional headers in conjunction with each-other or individually.
         *        </p>
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder ifMatchSize(Long ifMatchSize);

        @Override
        Builder overrideConfiguration(AwsRequestOverrideConfiguration overrideConfiguration);

        @Override
        Builder overrideConfiguration(Consumer<AwsRequestOverrideConfiguration.Builder> builderConsumer);
    }

    static final class BuilderImpl extends S3Request.BuilderImpl implements Builder {
        private String bucket;

        private String key;

        private String mfa;

        private String versionId;

        private String requestPayer;

        private Boolean bypassGovernanceRetention;

        private String expectedBucketOwner;

        private String ifMatch;

        private Instant ifMatchLastModifiedTime;

        private Long ifMatchSize;

        private BuilderImpl() {
        }

        private BuilderImpl(DeleteObjectRequest model) {
            super(model);
            bucket(model.bucket);
            key(model.key);
            mfa(model.mfa);
            versionId(model.versionId);
            requestPayer(model.requestPayer);
            bypassGovernanceRetention(model.bypassGovernanceRetention);
            expectedBucketOwner(model.expectedBucketOwner);
            ifMatch(model.ifMatch);
            ifMatchLastModifiedTime(model.ifMatchLastModifiedTime);
            ifMatchSize(model.ifMatchSize);
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

        public final String getKey() {
            return key;
        }

        public final void setKey(String key) {
            this.key = key;
        }

        @Override
        public final Builder key(String key) {
            this.key = key;
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

        public final String getVersionId() {
            return versionId;
        }

        public final void setVersionId(String versionId) {
            this.versionId = versionId;
        }

        @Override
        public final Builder versionId(String versionId) {
            this.versionId = versionId;
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

        public final String getIfMatch() {
            return ifMatch;
        }

        public final void setIfMatch(String ifMatch) {
            this.ifMatch = ifMatch;
        }

        @Override
        public final Builder ifMatch(String ifMatch) {
            this.ifMatch = ifMatch;
            return this;
        }

        public final Instant getIfMatchLastModifiedTime() {
            return ifMatchLastModifiedTime;
        }

        public final void setIfMatchLastModifiedTime(Instant ifMatchLastModifiedTime) {
            this.ifMatchLastModifiedTime = ifMatchLastModifiedTime;
        }

        @Override
        public final Builder ifMatchLastModifiedTime(Instant ifMatchLastModifiedTime) {
            this.ifMatchLastModifiedTime = ifMatchLastModifiedTime;
            return this;
        }

        public final Long getIfMatchSize() {
            return ifMatchSize;
        }

        public final void setIfMatchSize(Long ifMatchSize) {
            this.ifMatchSize = ifMatchSize;
        }

        @Override
        public final Builder ifMatchSize(Long ifMatchSize) {
            this.ifMatchSize = ifMatchSize;
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
        public DeleteObjectRequest build() {
            return new DeleteObjectRequest(this);
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
