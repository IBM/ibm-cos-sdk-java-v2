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
public final class ListMultipartUploadsRequest extends S3Request implements
        ToCopyableBuilder<ListMultipartUploadsRequest.Builder, ListMultipartUploadsRequest> {
    private static final SdkField<String> BUCKET_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("Bucket")
            .getter(getter(ListMultipartUploadsRequest::bucket))
            .setter(setter(Builder::bucket))
            .traits(LocationTrait.builder().location(MarshallLocation.PATH).locationName("Bucket")
                    .unmarshallLocationName("Bucket").build(), RequiredTrait.create()).build();

    private static final SdkField<String> DELIMITER_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("Delimiter")
            .getter(getter(ListMultipartUploadsRequest::delimiter))
            .setter(setter(Builder::delimiter))
            .traits(LocationTrait.builder().location(MarshallLocation.QUERY_PARAM).locationName("delimiter")
                    .unmarshallLocationName("delimiter").build()).build();

    private static final SdkField<String> ENCODING_TYPE_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("EncodingType")
            .getter(getter(ListMultipartUploadsRequest::encodingTypeAsString))
            .setter(setter(Builder::encodingType))
            .traits(LocationTrait.builder().location(MarshallLocation.QUERY_PARAM).locationName("encoding-type")
                    .unmarshallLocationName("encoding-type").build()).build();

    private static final SdkField<String> KEY_MARKER_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("KeyMarker")
            .getter(getter(ListMultipartUploadsRequest::keyMarker))
            .setter(setter(Builder::keyMarker))
            .traits(LocationTrait.builder().location(MarshallLocation.QUERY_PARAM).locationName("key-marker")
                    .unmarshallLocationName("key-marker").build()).build();

    private static final SdkField<Integer> MAX_UPLOADS_FIELD = SdkField
            .<Integer> builder(MarshallingType.INTEGER)
            .memberName("MaxUploads")
            .getter(getter(ListMultipartUploadsRequest::maxUploads))
            .setter(setter(Builder::maxUploads))
            .traits(LocationTrait.builder().location(MarshallLocation.QUERY_PARAM).locationName("max-uploads")
                    .unmarshallLocationName("max-uploads").build()).build();

    private static final SdkField<String> PREFIX_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("Prefix")
            .getter(getter(ListMultipartUploadsRequest::prefix))
            .setter(setter(Builder::prefix))
            .traits(LocationTrait.builder().location(MarshallLocation.QUERY_PARAM).locationName("prefix")
                    .unmarshallLocationName("prefix").build()).build();

    private static final SdkField<String> UPLOAD_ID_MARKER_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("UploadIdMarker")
            .getter(getter(ListMultipartUploadsRequest::uploadIdMarker))
            .setter(setter(Builder::uploadIdMarker))
            .traits(LocationTrait.builder().location(MarshallLocation.QUERY_PARAM).locationName("upload-id-marker")
                    .unmarshallLocationName("upload-id-marker").build()).build();

    private static final SdkField<String> EXPECTED_BUCKET_OWNER_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("ExpectedBucketOwner")
            .getter(getter(ListMultipartUploadsRequest::expectedBucketOwner))
            .setter(setter(Builder::expectedBucketOwner))
            .traits(LocationTrait.builder().location(MarshallLocation.HEADER).locationName("x-amz-expected-bucket-owner")
                    .unmarshallLocationName("x-amz-expected-bucket-owner").build()).build();

    private static final SdkField<String> REQUEST_PAYER_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("RequestPayer")
            .getter(getter(ListMultipartUploadsRequest::requestPayerAsString))
            .setter(setter(Builder::requestPayer))
            .traits(LocationTrait.builder().location(MarshallLocation.HEADER).locationName("x-amz-request-payer")
                    .unmarshallLocationName("x-amz-request-payer").build()).build();

    private static final List<SdkField<?>> SDK_FIELDS = Collections.unmodifiableList(Arrays.asList(BUCKET_FIELD, DELIMITER_FIELD,
            ENCODING_TYPE_FIELD, KEY_MARKER_FIELD, MAX_UPLOADS_FIELD, PREFIX_FIELD, UPLOAD_ID_MARKER_FIELD,
            EXPECTED_BUCKET_OWNER_FIELD, REQUEST_PAYER_FIELD));

    private static final Map<String, SdkField<?>> SDK_NAME_TO_FIELD = memberNameToFieldInitializer();

    private final String bucket;

    private final String delimiter;

    private final String encodingType;

    private final String keyMarker;

    private final Integer maxUploads;

    private final String prefix;

    private final String uploadIdMarker;

    private final String expectedBucketOwner;

    private final String requestPayer;

    private ListMultipartUploadsRequest(BuilderImpl builder) {
        super(builder);
        this.bucket = builder.bucket;
        this.delimiter = builder.delimiter;
        this.encodingType = builder.encodingType;
        this.keyMarker = builder.keyMarker;
        this.maxUploads = builder.maxUploads;
        this.prefix = builder.prefix;
        this.uploadIdMarker = builder.uploadIdMarker;
        this.expectedBucketOwner = builder.expectedBucketOwner;
        this.requestPayer = builder.requestPayer;
    }

    /**
     * <p>
     * The name of the bucket to which the multipart upload was initiated.
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
     * @return The name of the bucket to which the multipart upload was initiated. </p>
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
     * Character you use to group keys.
     * </p>
     * <p>
     * All keys that contain the same string between the prefix, if specified, and the first occurrence of the delimiter
     * after the prefix are grouped under a single result element, <code>CommonPrefixes</code>. If you don't specify the
     * prefix parameter, then the substring starts at the beginning of the key. The keys that are grouped under
     * <code>CommonPrefixes</code> result element are not returned elsewhere in the response.
     * </p>
     * <note>
     * <p>
     * <b>Directory buckets</b> - For directory buckets, <code>/</code> is the only supported delimiter.
     * </p>
     * </note>
     * 
     * @return Character you use to group keys.</p>
     *         <p>
     *         All keys that contain the same string between the prefix, if specified, and the first occurrence of the
     *         delimiter after the prefix are grouped under a single result element, <code>CommonPrefixes</code>. If you
     *         don't specify the prefix parameter, then the substring starts at the beginning of the key. The keys that
     *         are grouped under <code>CommonPrefixes</code> result element are not returned elsewhere in the response.
     *         </p>
     *         <note>
     *         <p>
     *         <b>Directory buckets</b> - For directory buckets, <code>/</code> is the only supported delimiter.
     *         </p>
     */
    public final String delimiter() {
        return delimiter;
    }

    /**
     * Returns the value of the EncodingType property for this object.
     * <p>
     * If the service returns an enum value that is not available in the current SDK version, {@link #encodingType} will
     * return {@link EncodingType#UNKNOWN_TO_SDK_VERSION}. The raw value returned by the service is available from
     * {@link #encodingTypeAsString}.
     * </p>
     * 
     * @return The value of the EncodingType property for this object.
     * @see EncodingType
     */
    public final EncodingType encodingType() {
        return EncodingType.fromValue(encodingType);
    }

    /**
     * Returns the value of the EncodingType property for this object.
     * <p>
     * If the service returns an enum value that is not available in the current SDK version, {@link #encodingType} will
     * return {@link EncodingType#UNKNOWN_TO_SDK_VERSION}. The raw value returned by the service is available from
     * {@link #encodingTypeAsString}.
     * </p>
     * 
     * @return The value of the EncodingType property for this object.
     * @see EncodingType
     */
    public final String encodingTypeAsString() {
        return encodingType;
    }

    /**
     * <p>
     * Specifies the multipart upload after which listing should begin.
     * </p>
     * <note>
     * <ul>
     * <li>
     * <p>
     * <b>General purpose buckets</b> - For general purpose buckets, <code>key-marker</code> is an object key. Together
     * with <code>upload-id-marker</code>, this parameter specifies the multipart upload after which listing should
     * begin.
     * </p>
     * <p>
     * If <code>upload-id-marker</code> is not specified, only the keys lexicographically greater than the specified
     * <code>key-marker</code> will be included in the list.
     * </p>
     * <p>
     * If <code>upload-id-marker</code> is specified, any multipart uploads for a key equal to the
     * <code>key-marker</code> might also be included, provided those multipart uploads have upload IDs
     * lexicographically greater than the specified <code>upload-id-marker</code>.
     * </p>
     * </li>
     * <li>
     * <p>
     * <b>Directory buckets</b> - For directory buckets, <code>key-marker</code> is obfuscated and isn't a real object
     * key. The <code>upload-id-marker</code> parameter isn't supported by directory buckets. To list the additional
     * multipart uploads, you only need to set the value of <code>key-marker</code> to the <code>NextKeyMarker</code>
     * value from the previous response.
     * </p>
     * <p>
     * In the <code>ListMultipartUploads</code> response, the multipart uploads aren't sorted lexicographically based on
     * the object keys.
     * </p>
     * </li>
     * </ul>
     * </note>
     * 
     * @return Specifies the multipart upload after which listing should begin.</p> <note>
     *         <ul>
     *         <li>
     *         <p>
     *         <b>General purpose buckets</b> - For general purpose buckets, <code>key-marker</code> is an object key.
     *         Together with <code>upload-id-marker</code>, this parameter specifies the multipart upload after which
     *         listing should begin.
     *         </p>
     *         <p>
     *         If <code>upload-id-marker</code> is not specified, only the keys lexicographically greater than the
     *         specified <code>key-marker</code> will be included in the list.
     *         </p>
     *         <p>
     *         If <code>upload-id-marker</code> is specified, any multipart uploads for a key equal to the
     *         <code>key-marker</code> might also be included, provided those multipart uploads have upload IDs
     *         lexicographically greater than the specified <code>upload-id-marker</code>.
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         <b>Directory buckets</b> - For directory buckets, <code>key-marker</code> is obfuscated and isn't a real
     *         object key. The <code>upload-id-marker</code> parameter isn't supported by directory buckets. To list the
     *         additional multipart uploads, you only need to set the value of <code>key-marker</code> to the
     *         <code>NextKeyMarker</code> value from the previous response.
     *         </p>
     *         <p>
     *         In the <code>ListMultipartUploads</code> response, the multipart uploads aren't sorted lexicographically
     *         based on the object keys.
     *         </p>
     *         </li>
     *         </ul>
     */
    public final String keyMarker() {
        return keyMarker;
    }

    /**
     * <p>
     * Sets the maximum number of multipart uploads, from 1 to 1,000, to return in the response body. 1,000 is the
     * maximum number of uploads that can be returned in a response.
     * </p>
     * 
     * @return Sets the maximum number of multipart uploads, from 1 to 1,000, to return in the response body. 1,000 is
     *         the maximum number of uploads that can be returned in a response.
     */
    public final Integer maxUploads() {
        return maxUploads;
    }

    /**
     * <p>
     * Lists in-progress uploads only for those keys that begin with the specified prefix. You can use prefixes to
     * separate a bucket into different grouping of keys. (You can think of using <code>prefix</code> to make groups in
     * the same way that you'd use a folder in a file system.)
     * </p>
     * <note>
     * <p>
     * <b>Directory buckets</b> - For directory buckets, only prefixes that end in a delimiter (<code>/</code>) are
     * supported.
     * </p>
     * </note>
     * 
     * @return Lists in-progress uploads only for those keys that begin with the specified prefix. You can use prefixes
     *         to separate a bucket into different grouping of keys. (You can think of using <code>prefix</code> to make
     *         groups in the same way that you'd use a folder in a file system.)</p> <note>
     *         <p>
     *         <b>Directory buckets</b> - For directory buckets, only prefixes that end in a delimiter (<code>/</code>)
     *         are supported.
     *         </p>
     */
    public final String prefix() {
        return prefix;
    }

    /**
     * <p>
     * Together with key-marker, specifies the multipart upload after which listing should begin. If key-marker is not
     * specified, the upload-id-marker parameter is ignored. Otherwise, any multipart uploads for a key equal to the
     * key-marker might be included in the list only if they have an upload ID lexicographically greater than the
     * specified <code>upload-id-marker</code>.
     * </p>
     * <note>
     * <p>
     * This functionality is not supported for directory buckets.
     * </p>
     * </note>
     * 
     * @return Together with key-marker, specifies the multipart upload after which listing should begin. If key-marker
     *         is not specified, the upload-id-marker parameter is ignored. Otherwise, any multipart uploads for a key
     *         equal to the key-marker might be included in the list only if they have an upload ID lexicographically
     *         greater than the specified <code>upload-id-marker</code>.</p> <note>
     *         <p>
     *         This functionality is not supported for directory buckets.
     *         </p>
     */
    public final String uploadIdMarker() {
        return uploadIdMarker;
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
        hashCode = 31 * hashCode + Objects.hashCode(delimiter());
        hashCode = 31 * hashCode + Objects.hashCode(encodingTypeAsString());
        hashCode = 31 * hashCode + Objects.hashCode(keyMarker());
        hashCode = 31 * hashCode + Objects.hashCode(maxUploads());
        hashCode = 31 * hashCode + Objects.hashCode(prefix());
        hashCode = 31 * hashCode + Objects.hashCode(uploadIdMarker());
        hashCode = 31 * hashCode + Objects.hashCode(expectedBucketOwner());
        hashCode = 31 * hashCode + Objects.hashCode(requestPayerAsString());
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
        if (!(obj instanceof ListMultipartUploadsRequest)) {
            return false;
        }
        ListMultipartUploadsRequest other = (ListMultipartUploadsRequest) obj;
        return Objects.equals(bucket(), other.bucket()) && Objects.equals(delimiter(), other.delimiter())
                && Objects.equals(encodingTypeAsString(), other.encodingTypeAsString())
                && Objects.equals(keyMarker(), other.keyMarker()) && Objects.equals(maxUploads(), other.maxUploads())
                && Objects.equals(prefix(), other.prefix()) && Objects.equals(uploadIdMarker(), other.uploadIdMarker())
                && Objects.equals(expectedBucketOwner(), other.expectedBucketOwner())
                && Objects.equals(requestPayerAsString(), other.requestPayerAsString());
    }

    /**
     * Returns a string representation of this object. This is useful for testing and debugging. Sensitive data will be
     * redacted from this string using a placeholder value.
     */
    @Override
    public final String toString() {
        return ToString.builder("ListMultipartUploadsRequest").add("Bucket", bucket()).add("Delimiter", delimiter())
                .add("EncodingType", encodingTypeAsString()).add("KeyMarker", keyMarker()).add("MaxUploads", maxUploads())
                .add("Prefix", prefix()).add("UploadIdMarker", uploadIdMarker())
                .add("ExpectedBucketOwner", expectedBucketOwner()).add("RequestPayer", requestPayerAsString()).build();
    }

    public final <T> Optional<T> getValueForField(String fieldName, Class<T> clazz) {
        switch (fieldName) {
        case "Bucket":
            return Optional.ofNullable(clazz.cast(bucket()));
        case "Delimiter":
            return Optional.ofNullable(clazz.cast(delimiter()));
        case "EncodingType":
            return Optional.ofNullable(clazz.cast(encodingTypeAsString()));
        case "KeyMarker":
            return Optional.ofNullable(clazz.cast(keyMarker()));
        case "MaxUploads":
            return Optional.ofNullable(clazz.cast(maxUploads()));
        case "Prefix":
            return Optional.ofNullable(clazz.cast(prefix()));
        case "UploadIdMarker":
            return Optional.ofNullable(clazz.cast(uploadIdMarker()));
        case "ExpectedBucketOwner":
            return Optional.ofNullable(clazz.cast(expectedBucketOwner()));
        case "RequestPayer":
            return Optional.ofNullable(clazz.cast(requestPayerAsString()));
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
        map.put("delimiter", DELIMITER_FIELD);
        map.put("encoding-type", ENCODING_TYPE_FIELD);
        map.put("key-marker", KEY_MARKER_FIELD);
        map.put("max-uploads", MAX_UPLOADS_FIELD);
        map.put("prefix", PREFIX_FIELD);
        map.put("upload-id-marker", UPLOAD_ID_MARKER_FIELD);
        map.put("x-amz-expected-bucket-owner", EXPECTED_BUCKET_OWNER_FIELD);
        map.put("x-amz-request-payer", REQUEST_PAYER_FIELD);
        return Collections.unmodifiableMap(map);
    }

    private static <T> Function<Object, T> getter(Function<ListMultipartUploadsRequest, T> g) {
        return obj -> g.apply((ListMultipartUploadsRequest) obj);
    }

    private static <T> BiConsumer<Object, T> setter(BiConsumer<Builder, T> s) {
        return (obj, val) -> s.accept((Builder) obj, val);
    }

    @Mutable
    @NotThreadSafe
    public interface Builder extends S3Request.Builder, SdkPojo, CopyableBuilder<Builder, ListMultipartUploadsRequest> {
        /**
         * <p>
         * The name of the bucket to which the multipart upload was initiated.
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
         *        The name of the bucket to which the multipart upload was initiated. </p>
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
         * Character you use to group keys.
         * </p>
         * <p>
         * All keys that contain the same string between the prefix, if specified, and the first occurrence of the
         * delimiter after the prefix are grouped under a single result element, <code>CommonPrefixes</code>. If you
         * don't specify the prefix parameter, then the substring starts at the beginning of the key. The keys that are
         * grouped under <code>CommonPrefixes</code> result element are not returned elsewhere in the response.
         * </p>
         * <note>
         * <p>
         * <b>Directory buckets</b> - For directory buckets, <code>/</code> is the only supported delimiter.
         * </p>
         * </note>
         * 
         * @param delimiter
         *        Character you use to group keys.</p>
         *        <p>
         *        All keys that contain the same string between the prefix, if specified, and the first occurrence of
         *        the delimiter after the prefix are grouped under a single result element, <code>CommonPrefixes</code>.
         *        If you don't specify the prefix parameter, then the substring starts at the beginning of the key. The
         *        keys that are grouped under <code>CommonPrefixes</code> result element are not returned elsewhere in
         *        the response.
         *        </p>
         *        <note>
         *        <p>
         *        <b>Directory buckets</b> - For directory buckets, <code>/</code> is the only supported delimiter.
         *        </p>
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder delimiter(String delimiter);

        /**
         * Sets the value of the EncodingType property for this object.
         *
         * @param encodingType
         *        The new value for the EncodingType property for this object.
         * @see EncodingType
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see EncodingType
         */
        Builder encodingType(String encodingType);

        /**
         * Sets the value of the EncodingType property for this object.
         *
         * @param encodingType
         *        The new value for the EncodingType property for this object.
         * @see EncodingType
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see EncodingType
         */
        Builder encodingType(EncodingType encodingType);

        /**
         * <p>
         * Specifies the multipart upload after which listing should begin.
         * </p>
         * <note>
         * <ul>
         * <li>
         * <p>
         * <b>General purpose buckets</b> - For general purpose buckets, <code>key-marker</code> is an object key.
         * Together with <code>upload-id-marker</code>, this parameter specifies the multipart upload after which
         * listing should begin.
         * </p>
         * <p>
         * If <code>upload-id-marker</code> is not specified, only the keys lexicographically greater than the specified
         * <code>key-marker</code> will be included in the list.
         * </p>
         * <p>
         * If <code>upload-id-marker</code> is specified, any multipart uploads for a key equal to the
         * <code>key-marker</code> might also be included, provided those multipart uploads have upload IDs
         * lexicographically greater than the specified <code>upload-id-marker</code>.
         * </p>
         * </li>
         * <li>
         * <p>
         * <b>Directory buckets</b> - For directory buckets, <code>key-marker</code> is obfuscated and isn't a real
         * object key. The <code>upload-id-marker</code> parameter isn't supported by directory buckets. To list the
         * additional multipart uploads, you only need to set the value of <code>key-marker</code> to the
         * <code>NextKeyMarker</code> value from the previous response.
         * </p>
         * <p>
         * In the <code>ListMultipartUploads</code> response, the multipart uploads aren't sorted lexicographically
         * based on the object keys.
         * </p>
         * </li>
         * </ul>
         * </note>
         * 
         * @param keyMarker
         *        Specifies the multipart upload after which listing should begin.</p> <note>
         *        <ul>
         *        <li>
         *        <p>
         *        <b>General purpose buckets</b> - For general purpose buckets, <code>key-marker</code> is an object
         *        key. Together with <code>upload-id-marker</code>, this parameter specifies the multipart upload after
         *        which listing should begin.
         *        </p>
         *        <p>
         *        If <code>upload-id-marker</code> is not specified, only the keys lexicographically greater than the
         *        specified <code>key-marker</code> will be included in the list.
         *        </p>
         *        <p>
         *        If <code>upload-id-marker</code> is specified, any multipart uploads for a key equal to the
         *        <code>key-marker</code> might also be included, provided those multipart uploads have upload IDs
         *        lexicographically greater than the specified <code>upload-id-marker</code>.
         *        </p>
         *        </li>
         *        <li>
         *        <p>
         *        <b>Directory buckets</b> - For directory buckets, <code>key-marker</code> is obfuscated and isn't a
         *        real object key. The <code>upload-id-marker</code> parameter isn't supported by directory buckets. To
         *        list the additional multipart uploads, you only need to set the value of <code>key-marker</code> to
         *        the <code>NextKeyMarker</code> value from the previous response.
         *        </p>
         *        <p>
         *        In the <code>ListMultipartUploads</code> response, the multipart uploads aren't sorted
         *        lexicographically based on the object keys.
         *        </p>
         *        </li>
         *        </ul>
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder keyMarker(String keyMarker);

        /**
         * <p>
         * Sets the maximum number of multipart uploads, from 1 to 1,000, to return in the response body. 1,000 is the
         * maximum number of uploads that can be returned in a response.
         * </p>
         * 
         * @param maxUploads
         *        Sets the maximum number of multipart uploads, from 1 to 1,000, to return in the response body. 1,000
         *        is the maximum number of uploads that can be returned in a response.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder maxUploads(Integer maxUploads);

        /**
         * <p>
         * Lists in-progress uploads only for those keys that begin with the specified prefix. You can use prefixes to
         * separate a bucket into different grouping of keys. (You can think of using <code>prefix</code> to make groups
         * in the same way that you'd use a folder in a file system.)
         * </p>
         * <note>
         * <p>
         * <b>Directory buckets</b> - For directory buckets, only prefixes that end in a delimiter (<code>/</code>) are
         * supported.
         * </p>
         * </note>
         * 
         * @param prefix
         *        Lists in-progress uploads only for those keys that begin with the specified prefix. You can use
         *        prefixes to separate a bucket into different grouping of keys. (You can think of using
         *        <code>prefix</code> to make groups in the same way that you'd use a folder in a file system.)</p>
         *        <note>
         *        <p>
         *        <b>Directory buckets</b> - For directory buckets, only prefixes that end in a delimiter (
         *        <code>/</code>) are supported.
         *        </p>
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder prefix(String prefix);

        /**
         * <p>
         * Together with key-marker, specifies the multipart upload after which listing should begin. If key-marker is
         * not specified, the upload-id-marker parameter is ignored. Otherwise, any multipart uploads for a key equal to
         * the key-marker might be included in the list only if they have an upload ID lexicographically greater than
         * the specified <code>upload-id-marker</code>.
         * </p>
         * <note>
         * <p>
         * This functionality is not supported for directory buckets.
         * </p>
         * </note>
         * 
         * @param uploadIdMarker
         *        Together with key-marker, specifies the multipart upload after which listing should begin. If
         *        key-marker is not specified, the upload-id-marker parameter is ignored. Otherwise, any multipart
         *        uploads for a key equal to the key-marker might be included in the list only if they have an upload ID
         *        lexicographically greater than the specified <code>upload-id-marker</code>.</p> <note>
         *        <p>
         *        This functionality is not supported for directory buckets.
         *        </p>
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder uploadIdMarker(String uploadIdMarker);

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

        @Override
        Builder overrideConfiguration(AwsRequestOverrideConfiguration overrideConfiguration);

        @Override
        Builder overrideConfiguration(Consumer<AwsRequestOverrideConfiguration.Builder> builderConsumer);
    }

    static final class BuilderImpl extends S3Request.BuilderImpl implements Builder {
        private String bucket;

        private String delimiter;

        private String encodingType;

        private String keyMarker;

        private Integer maxUploads;

        private String prefix;

        private String uploadIdMarker;

        private String expectedBucketOwner;

        private String requestPayer;

        private BuilderImpl() {
        }

        private BuilderImpl(ListMultipartUploadsRequest model) {
            super(model);
            bucket(model.bucket);
            delimiter(model.delimiter);
            encodingType(model.encodingType);
            keyMarker(model.keyMarker);
            maxUploads(model.maxUploads);
            prefix(model.prefix);
            uploadIdMarker(model.uploadIdMarker);
            expectedBucketOwner(model.expectedBucketOwner);
            requestPayer(model.requestPayer);
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

        public final String getDelimiter() {
            return delimiter;
        }

        public final void setDelimiter(String delimiter) {
            this.delimiter = delimiter;
        }

        @Override
        public final Builder delimiter(String delimiter) {
            this.delimiter = delimiter;
            return this;
        }

        public final String getEncodingType() {
            return encodingType;
        }

        public final void setEncodingType(String encodingType) {
            this.encodingType = encodingType;
        }

        @Override
        public final Builder encodingType(String encodingType) {
            this.encodingType = encodingType;
            return this;
        }

        @Override
        public final Builder encodingType(EncodingType encodingType) {
            this.encodingType(encodingType == null ? null : encodingType.toString());
            return this;
        }

        public final String getKeyMarker() {
            return keyMarker;
        }

        public final void setKeyMarker(String keyMarker) {
            this.keyMarker = keyMarker;
        }

        @Override
        public final Builder keyMarker(String keyMarker) {
            this.keyMarker = keyMarker;
            return this;
        }

        public final Integer getMaxUploads() {
            return maxUploads;
        }

        public final void setMaxUploads(Integer maxUploads) {
            this.maxUploads = maxUploads;
        }

        @Override
        public final Builder maxUploads(Integer maxUploads) {
            this.maxUploads = maxUploads;
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

        public final String getUploadIdMarker() {
            return uploadIdMarker;
        }

        public final void setUploadIdMarker(String uploadIdMarker) {
            this.uploadIdMarker = uploadIdMarker;
        }

        @Override
        public final Builder uploadIdMarker(String uploadIdMarker) {
            this.uploadIdMarker = uploadIdMarker;
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
        public ListMultipartUploadsRequest build() {
            return new ListMultipartUploadsRequest(this);
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
