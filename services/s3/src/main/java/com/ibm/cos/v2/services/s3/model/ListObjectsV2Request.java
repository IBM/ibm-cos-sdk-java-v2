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
import java.util.Collection;
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
import com.ibm.cos.v2.core.traits.ListTrait;
import com.ibm.cos.v2.core.traits.LocationTrait;
import com.ibm.cos.v2.core.traits.RequiredTrait;
import com.ibm.cos.v2.core.util.DefaultSdkAutoConstructList;
import com.ibm.cos.v2.core.util.SdkAutoConstructList;
import com.ibm.cos.v2.utils.ToString;
import com.ibm.cos.v2.utils.builder.CopyableBuilder;
import com.ibm.cos.v2.utils.builder.ToCopyableBuilder;

/**
 */
@Generated("com.ibm.cos.v2:codegen")
public final class ListObjectsV2Request extends S3Request implements
        ToCopyableBuilder<ListObjectsV2Request.Builder, ListObjectsV2Request> {
    private static final SdkField<String> BUCKET_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("Bucket")
            .getter(getter(ListObjectsV2Request::bucket))
            .setter(setter(Builder::bucket))
            .traits(LocationTrait.builder().location(MarshallLocation.PATH).locationName("Bucket")
                    .unmarshallLocationName("Bucket").build(), RequiredTrait.create()).build();

    private static final SdkField<String> DELIMITER_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("Delimiter")
            .getter(getter(ListObjectsV2Request::delimiter))
            .setter(setter(Builder::delimiter))
            .traits(LocationTrait.builder().location(MarshallLocation.QUERY_PARAM).locationName("delimiter")
                    .unmarshallLocationName("delimiter").build()).build();

    private static final SdkField<String> ENCODING_TYPE_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("EncodingType")
            .getter(getter(ListObjectsV2Request::encodingTypeAsString))
            .setter(setter(Builder::encodingType))
            .traits(LocationTrait.builder().location(MarshallLocation.QUERY_PARAM).locationName("encoding-type")
                    .unmarshallLocationName("encoding-type").build()).build();

    private static final SdkField<Integer> MAX_KEYS_FIELD = SdkField
            .<Integer> builder(MarshallingType.INTEGER)
            .memberName("MaxKeys")
            .getter(getter(ListObjectsV2Request::maxKeys))
            .setter(setter(Builder::maxKeys))
            .traits(LocationTrait.builder().location(MarshallLocation.QUERY_PARAM).locationName("max-keys")
                    .unmarshallLocationName("max-keys").build()).build();

    private static final SdkField<String> PREFIX_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("Prefix")
            .getter(getter(ListObjectsV2Request::prefix))
            .setter(setter(Builder::prefix))
            .traits(LocationTrait.builder().location(MarshallLocation.QUERY_PARAM).locationName("prefix")
                    .unmarshallLocationName("prefix").build()).build();

    private static final SdkField<String> CONTINUATION_TOKEN_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("ContinuationToken")
            .getter(getter(ListObjectsV2Request::continuationToken))
            .setter(setter(Builder::continuationToken))
            .traits(LocationTrait.builder().location(MarshallLocation.QUERY_PARAM).locationName("continuation-token")
                    .unmarshallLocationName("continuation-token").build()).build();

    private static final SdkField<Boolean> FETCH_OWNER_FIELD = SdkField
            .<Boolean> builder(MarshallingType.BOOLEAN)
            .memberName("FetchOwner")
            .getter(getter(ListObjectsV2Request::fetchOwner))
            .setter(setter(Builder::fetchOwner))
            .traits(LocationTrait.builder().location(MarshallLocation.QUERY_PARAM).locationName("fetch-owner")
                    .unmarshallLocationName("fetch-owner").build()).build();

    private static final SdkField<String> START_AFTER_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("StartAfter")
            .getter(getter(ListObjectsV2Request::startAfter))
            .setter(setter(Builder::startAfter))
            .traits(LocationTrait.builder().location(MarshallLocation.QUERY_PARAM).locationName("start-after")
                    .unmarshallLocationName("start-after").build()).build();

    private static final SdkField<String> REQUEST_PAYER_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("RequestPayer")
            .getter(getter(ListObjectsV2Request::requestPayerAsString))
            .setter(setter(Builder::requestPayer))
            .traits(LocationTrait.builder().location(MarshallLocation.HEADER).locationName("x-amz-request-payer")
                    .unmarshallLocationName("x-amz-request-payer").build()).build();

    private static final SdkField<String> EXPECTED_BUCKET_OWNER_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("ExpectedBucketOwner")
            .getter(getter(ListObjectsV2Request::expectedBucketOwner))
            .setter(setter(Builder::expectedBucketOwner))
            .traits(LocationTrait.builder().location(MarshallLocation.HEADER).locationName("x-amz-expected-bucket-owner")
                    .unmarshallLocationName("x-amz-expected-bucket-owner").build()).build();

    private static final SdkField<List<String>> OPTIONAL_OBJECT_ATTRIBUTES_FIELD = SdkField
            .<List<String>> builder(MarshallingType.LIST)
            .memberName("OptionalObjectAttributes")
            .getter(getter(ListObjectsV2Request::optionalObjectAttributesAsStrings))
            .setter(setter(Builder::optionalObjectAttributesWithStrings))
            .traits(LocationTrait.builder().location(MarshallLocation.HEADER).locationName("x-amz-optional-object-attributes")
                    .unmarshallLocationName("x-amz-optional-object-attributes").build(),
                    ListTrait
                            .builder()
                            .memberLocationName(null)
                            .memberFieldInfo(
                                    SdkField.<String> builder(MarshallingType.STRING)
                                            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD)
                                                    .locationName("member").unmarshallLocationName("member").build()).build())
                            .build()).build();

    private static final List<SdkField<?>> SDK_FIELDS = Collections.unmodifiableList(Arrays.asList(BUCKET_FIELD, DELIMITER_FIELD,
            ENCODING_TYPE_FIELD, MAX_KEYS_FIELD, PREFIX_FIELD, CONTINUATION_TOKEN_FIELD, FETCH_OWNER_FIELD, START_AFTER_FIELD,
            REQUEST_PAYER_FIELD, EXPECTED_BUCKET_OWNER_FIELD, OPTIONAL_OBJECT_ATTRIBUTES_FIELD));

    private static final Map<String, SdkField<?>> SDK_NAME_TO_FIELD = memberNameToFieldInitializer();

    private final String bucket;

    private final String delimiter;

    private final String encodingType;

    private final Integer maxKeys;

    private final String prefix;

    private final String continuationToken;

    private final Boolean fetchOwner;

    private final String startAfter;

    private final String requestPayer;

    private final String expectedBucketOwner;

    private final List<String> optionalObjectAttributes;

    private ListObjectsV2Request(BuilderImpl builder) {
        super(builder);
        this.bucket = builder.bucket;
        this.delimiter = builder.delimiter;
        this.encodingType = builder.encodingType;
        this.maxKeys = builder.maxKeys;
        this.prefix = builder.prefix;
        this.continuationToken = builder.continuationToken;
        this.fetchOwner = builder.fetchOwner;
        this.startAfter = builder.startAfter;
        this.requestPayer = builder.requestPayer;
        this.expectedBucketOwner = builder.expectedBucketOwner;
        this.optionalObjectAttributes = builder.optionalObjectAttributes;
    }

    /**
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
     * @return <b>Directory buckets</b> - When you use this operation with a directory bucket, you must use
     *         virtual-hosted-style requests in the format
     *         <code> <i>Bucket-name</i>.s3express-<i>zone-id</i>.<i>region-code</i>.amazonaws.com</code>. Path-style
     *         requests are not supported. Directory bucket names must be unique in the chosen Zone (Availability Zone
     *         or Local Zone). Bucket names must follow the format
     *         <code> <i>bucket-base-name</i>--<i>zone-id</i>--x-s3</code> (for example,
     *         <code> <i>amzn-s3-demo-bucket</i>--<i>usw2-az1</i>--x-s3</code>). For information about bucket naming
     *         restrictions, see <a
     *         href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/directory-bucket-naming-rules.html">Directory
     *         bucket naming rules</a> in the <i>Amazon S3 User Guide</i>.</p>
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
     * A delimiter is a character that you use to group keys.
     * </p>
     * <note>
     * <ul>
     * <li>
     * <p>
     * <b>Directory buckets</b> - For directory buckets, <code>/</code> is the only supported delimiter.
     * </p>
     * </li>
     * <li>
     * <p>
     * <b>Directory buckets </b> - When you query <code>ListObjectsV2</code> with a delimiter during in-progress
     * multipart uploads, the <code>CommonPrefixes</code> response parameter contains the prefixes that are associated
     * with the in-progress multipart uploads. For more information about multipart uploads, see <a
     * href="https://docs.aws.amazon.com/AmazonS3/latest/dev/mpuoverview.html">Multipart Upload Overview</a> in the
     * <i>Amazon S3 User Guide</i>.
     * </p>
     * </li>
     * </ul>
     * </note>
     * 
     * @return A delimiter is a character that you use to group keys.</p> <note>
     *         <ul>
     *         <li>
     *         <p>
     *         <b>Directory buckets</b> - For directory buckets, <code>/</code> is the only supported delimiter.
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         <b>Directory buckets </b> - When you query <code>ListObjectsV2</code> with a delimiter during in-progress
     *         multipart uploads, the <code>CommonPrefixes</code> response parameter contains the prefixes that are
     *         associated with the in-progress multipart uploads. For more information about multipart uploads, see <a
     *         href="https://docs.aws.amazon.com/AmazonS3/latest/dev/mpuoverview.html">Multipart Upload Overview</a> in
     *         the <i>Amazon S3 User Guide</i>.
     *         </p>
     *         </li>
     *         </ul>
     */
    public final String delimiter() {
        return delimiter;
    }

    /**
     * <p>
     * Encoding type used by Amazon S3 to encode the <a
     * href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/object-keys.html">object keys</a> in the response.
     * Responses are encoded only in UTF-8. An object key can contain any Unicode character. However, the XML 1.0 parser
     * can't parse certain characters, such as characters with an ASCII value from 0 to 10. For characters that aren't
     * supported in XML 1.0, you can add this parameter to request that Amazon S3 encode the keys in the response. For
     * more information about characters to avoid in object key names, see <a
     * href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/object-keys.html#object-key-guidelines">Object key
     * naming guidelines</a>.
     * </p>
     * <note>
     * <p>
     * When using the URL encoding type, non-ASCII characters that are used in an object's key name will be
     * percent-encoded according to UTF-8 code values. For example, the object <code>test_file(3).png</code> will appear
     * as <code>test_file%283%29.png</code>.
     * </p>
     * </note>
     * <p>
     * If the service returns an enum value that is not available in the current SDK version, {@link #encodingType} will
     * return {@link EncodingType#UNKNOWN_TO_SDK_VERSION}. The raw value returned by the service is available from
     * {@link #encodingTypeAsString}.
     * </p>
     * 
     * @return Encoding type used by Amazon S3 to encode the <a
     *         href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/object-keys.html">object keys</a> in the
     *         response. Responses are encoded only in UTF-8. An object key can contain any Unicode character. However,
     *         the XML 1.0 parser can't parse certain characters, such as characters with an ASCII value from 0 to 10.
     *         For characters that aren't supported in XML 1.0, you can add this parameter to request that Amazon S3
     *         encode the keys in the response. For more information about characters to avoid in object key names, see
     *         <a href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/object-keys.html#object-key-guidelines">
     *         Object key naming guidelines</a>.</p> <note>
     *         <p>
     *         When using the URL encoding type, non-ASCII characters that are used in an object's key name will be
     *         percent-encoded according to UTF-8 code values. For example, the object <code>test_file(3).png</code>
     *         will appear as <code>test_file%283%29.png</code>.
     *         </p>
     * @see EncodingType
     */
    public final EncodingType encodingType() {
        return EncodingType.fromValue(encodingType);
    }

    /**
     * <p>
     * Encoding type used by Amazon S3 to encode the <a
     * href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/object-keys.html">object keys</a> in the response.
     * Responses are encoded only in UTF-8. An object key can contain any Unicode character. However, the XML 1.0 parser
     * can't parse certain characters, such as characters with an ASCII value from 0 to 10. For characters that aren't
     * supported in XML 1.0, you can add this parameter to request that Amazon S3 encode the keys in the response. For
     * more information about characters to avoid in object key names, see <a
     * href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/object-keys.html#object-key-guidelines">Object key
     * naming guidelines</a>.
     * </p>
     * <note>
     * <p>
     * When using the URL encoding type, non-ASCII characters that are used in an object's key name will be
     * percent-encoded according to UTF-8 code values. For example, the object <code>test_file(3).png</code> will appear
     * as <code>test_file%283%29.png</code>.
     * </p>
     * </note>
     * <p>
     * If the service returns an enum value that is not available in the current SDK version, {@link #encodingType} will
     * return {@link EncodingType#UNKNOWN_TO_SDK_VERSION}. The raw value returned by the service is available from
     * {@link #encodingTypeAsString}.
     * </p>
     * 
     * @return Encoding type used by Amazon S3 to encode the <a
     *         href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/object-keys.html">object keys</a> in the
     *         response. Responses are encoded only in UTF-8. An object key can contain any Unicode character. However,
     *         the XML 1.0 parser can't parse certain characters, such as characters with an ASCII value from 0 to 10.
     *         For characters that aren't supported in XML 1.0, you can add this parameter to request that Amazon S3
     *         encode the keys in the response. For more information about characters to avoid in object key names, see
     *         <a href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/object-keys.html#object-key-guidelines">
     *         Object key naming guidelines</a>.</p> <note>
     *         <p>
     *         When using the URL encoding type, non-ASCII characters that are used in an object's key name will be
     *         percent-encoded according to UTF-8 code values. For example, the object <code>test_file(3).png</code>
     *         will appear as <code>test_file%283%29.png</code>.
     *         </p>
     * @see EncodingType
     */
    public final String encodingTypeAsString() {
        return encodingType;
    }

    /**
     * <p>
     * Sets the maximum number of keys returned in the response. By default, the action returns up to 1,000 key names.
     * The response might contain fewer keys but will never contain more.
     * </p>
     * 
     * @return Sets the maximum number of keys returned in the response. By default, the action returns up to 1,000 key
     *         names. The response might contain fewer keys but will never contain more.
     */
    public final Integer maxKeys() {
        return maxKeys;
    }

    /**
     * <p>
     * Limits the response to keys that begin with the specified prefix.
     * </p>
     * <note>
     * <p>
     * <b>Directory buckets</b> - For directory buckets, only prefixes that end in a delimiter (<code>/</code>) are
     * supported.
     * </p>
     * </note>
     * 
     * @return Limits the response to keys that begin with the specified prefix.</p> <note>
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
     * <code>ContinuationToken</code> indicates to Amazon S3 that the list is being continued on this bucket with a
     * token. <code>ContinuationToken</code> is obfuscated and is not a real key. You can use this
     * <code>ContinuationToken</code> for pagination of the list results.
     * </p>
     * 
     * @return <code>ContinuationToken</code> indicates to Amazon S3 that the list is being continued on this bucket
     *         with a token. <code>ContinuationToken</code> is obfuscated and is not a real key. You can use this
     *         <code>ContinuationToken</code> for pagination of the list results.
     */
    public final String continuationToken() {
        return continuationToken;
    }

    /**
     * <p>
     * The owner field is not present in <code>ListObjectsV2</code> by default. If you want to return the owner field
     * with each key in the result, then set the <code>FetchOwner</code> field to <code>true</code>.
     * </p>
     * <note>
     * <p>
     * <b>Directory buckets</b> - For directory buckets, the bucket owner is returned as the object owner for all
     * objects.
     * </p>
     * </note>
     * 
     * @return The owner field is not present in <code>ListObjectsV2</code> by default. If you want to return the owner
     *         field with each key in the result, then set the <code>FetchOwner</code> field to <code>true</code>.</p>
     *         <note>
     *         <p>
     *         <b>Directory buckets</b> - For directory buckets, the bucket owner is returned as the object owner for
     *         all objects.
     *         </p>
     */
    public final Boolean fetchOwner() {
        return fetchOwner;
    }

    /**
     * <p>
     * StartAfter is where you want Amazon S3 to start listing from. Amazon S3 starts listing after this specified key.
     * StartAfter can be any key in the bucket.
     * </p>
     * <note>
     * <p>
     * This functionality is not supported for directory buckets.
     * </p>
     * </note>
     * 
     * @return StartAfter is where you want Amazon S3 to start listing from. Amazon S3 starts listing after this
     *         specified key. StartAfter can be any key in the bucket.</p> <note>
     *         <p>
     *         This functionality is not supported for directory buckets.
     *         </p>
     */
    public final String startAfter() {
        return startAfter;
    }

    /**
     * <p>
     * Confirms that the requester knows that she or he will be charged for the list objects request in V2 style. Bucket
     * owners need not specify this parameter in their requests.
     * </p>
     * <note>
     * <p>
     * This functionality is not supported for directory buckets.
     * </p>
     * </note>
     * <p>
     * If the service returns an enum value that is not available in the current SDK version, {@link #requestPayer} will
     * return {@link RequestPayer#UNKNOWN_TO_SDK_VERSION}. The raw value returned by the service is available from
     * {@link #requestPayerAsString}.
     * </p>
     * 
     * @return Confirms that the requester knows that she or he will be charged for the list objects request in V2
     *         style. Bucket owners need not specify this parameter in their requests.</p> <note>
     *         <p>
     *         This functionality is not supported for directory buckets.
     *         </p>
     * @see RequestPayer
     */
    public final RequestPayer requestPayer() {
        return RequestPayer.fromValue(requestPayer);
    }

    /**
     * <p>
     * Confirms that the requester knows that she or he will be charged for the list objects request in V2 style. Bucket
     * owners need not specify this parameter in their requests.
     * </p>
     * <note>
     * <p>
     * This functionality is not supported for directory buckets.
     * </p>
     * </note>
     * <p>
     * If the service returns an enum value that is not available in the current SDK version, {@link #requestPayer} will
     * return {@link RequestPayer#UNKNOWN_TO_SDK_VERSION}. The raw value returned by the service is available from
     * {@link #requestPayerAsString}.
     * </p>
     * 
     * @return Confirms that the requester knows that she or he will be charged for the list objects request in V2
     *         style. Bucket owners need not specify this parameter in their requests.</p> <note>
     *         <p>
     *         This functionality is not supported for directory buckets.
     *         </p>
     * @see RequestPayer
     */
    public final String requestPayerAsString() {
        return requestPayer;
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
     * Specifies the optional fields that you want returned in the response. Fields that you do not specify are not
     * returned.
     * </p>
     * <note>
     * <p>
     * This functionality is not supported for directory buckets.
     * </p>
     * </note>
     * <p>
     * Attempts to modify the collection returned by this method will result in an UnsupportedOperationException.
     * </p>
     * <p>
     * This method will never return null. If you would like to know whether the service returned this field (so that
     * you can differentiate between null and empty), you can use the {@link #hasOptionalObjectAttributes} method.
     * </p>
     * 
     * @return Specifies the optional fields that you want returned in the response. Fields that you do not specify are
     *         not returned.</p> <note>
     *         <p>
     *         This functionality is not supported for directory buckets.
     *         </p>
     */
    public final List<OptionalObjectAttributes> optionalObjectAttributes() {
        return OptionalObjectAttributesListCopier.copyStringToEnum(optionalObjectAttributes);
    }

    /**
     * For responses, this returns true if the service returned a value for the OptionalObjectAttributes property. This
     * DOES NOT check that the value is non-empty (for which, you should check the {@code isEmpty()} method on the
     * property). This is useful because the SDK will never return a null collection or map, but you may need to
     * differentiate between the service returning nothing (or null) and the service returning an empty collection or
     * map. For requests, this returns true if a value for the property was specified in the request builder, and false
     * if a value was not specified.
     */
    public final boolean hasOptionalObjectAttributes() {
        return optionalObjectAttributes != null && !(optionalObjectAttributes instanceof SdkAutoConstructList);
    }

    /**
     * <p>
     * Specifies the optional fields that you want returned in the response. Fields that you do not specify are not
     * returned.
     * </p>
     * <note>
     * <p>
     * This functionality is not supported for directory buckets.
     * </p>
     * </note>
     * <p>
     * Attempts to modify the collection returned by this method will result in an UnsupportedOperationException.
     * </p>
     * <p>
     * This method will never return null. If you would like to know whether the service returned this field (so that
     * you can differentiate between null and empty), you can use the {@link #hasOptionalObjectAttributes} method.
     * </p>
     * 
     * @return Specifies the optional fields that you want returned in the response. Fields that you do not specify are
     *         not returned.</p> <note>
     *         <p>
     *         This functionality is not supported for directory buckets.
     *         </p>
     */
    public final List<String> optionalObjectAttributesAsStrings() {
        return optionalObjectAttributes;
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
        hashCode = 31 * hashCode + Objects.hashCode(maxKeys());
        hashCode = 31 * hashCode + Objects.hashCode(prefix());
        hashCode = 31 * hashCode + Objects.hashCode(continuationToken());
        hashCode = 31 * hashCode + Objects.hashCode(fetchOwner());
        hashCode = 31 * hashCode + Objects.hashCode(startAfter());
        hashCode = 31 * hashCode + Objects.hashCode(requestPayerAsString());
        hashCode = 31 * hashCode + Objects.hashCode(expectedBucketOwner());
        hashCode = 31 * hashCode + Objects.hashCode(hasOptionalObjectAttributes() ? optionalObjectAttributesAsStrings() : null);
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
        if (!(obj instanceof ListObjectsV2Request)) {
            return false;
        }
        ListObjectsV2Request other = (ListObjectsV2Request) obj;
        return Objects.equals(bucket(), other.bucket()) && Objects.equals(delimiter(), other.delimiter())
                && Objects.equals(encodingTypeAsString(), other.encodingTypeAsString())
                && Objects.equals(maxKeys(), other.maxKeys()) && Objects.equals(prefix(), other.prefix())
                && Objects.equals(continuationToken(), other.continuationToken())
                && Objects.equals(fetchOwner(), other.fetchOwner()) && Objects.equals(startAfter(), other.startAfter())
                && Objects.equals(requestPayerAsString(), other.requestPayerAsString())
                && Objects.equals(expectedBucketOwner(), other.expectedBucketOwner())
                && hasOptionalObjectAttributes() == other.hasOptionalObjectAttributes()
                && Objects.equals(optionalObjectAttributesAsStrings(), other.optionalObjectAttributesAsStrings());
    }

    /**
     * Returns a string representation of this object. This is useful for testing and debugging. Sensitive data will be
     * redacted from this string using a placeholder value.
     */
    @Override
    public final String toString() {
        return ToString.builder("ListObjectsV2Request").add("Bucket", bucket()).add("Delimiter", delimiter())
                .add("EncodingType", encodingTypeAsString()).add("MaxKeys", maxKeys()).add("Prefix", prefix())
                .add("ContinuationToken", continuationToken()).add("FetchOwner", fetchOwner()).add("StartAfter", startAfter())
                .add("RequestPayer", requestPayerAsString()).add("ExpectedBucketOwner", expectedBucketOwner())
                .add("OptionalObjectAttributes", hasOptionalObjectAttributes() ? optionalObjectAttributesAsStrings() : null)
                .build();
    }

    public final <T> Optional<T> getValueForField(String fieldName, Class<T> clazz) {
        switch (fieldName) {
        case "Bucket":
            return Optional.ofNullable(clazz.cast(bucket()));
        case "Delimiter":
            return Optional.ofNullable(clazz.cast(delimiter()));
        case "EncodingType":
            return Optional.ofNullable(clazz.cast(encodingTypeAsString()));
        case "MaxKeys":
            return Optional.ofNullable(clazz.cast(maxKeys()));
        case "Prefix":
            return Optional.ofNullable(clazz.cast(prefix()));
        case "ContinuationToken":
            return Optional.ofNullable(clazz.cast(continuationToken()));
        case "FetchOwner":
            return Optional.ofNullable(clazz.cast(fetchOwner()));
        case "StartAfter":
            return Optional.ofNullable(clazz.cast(startAfter()));
        case "RequestPayer":
            return Optional.ofNullable(clazz.cast(requestPayerAsString()));
        case "ExpectedBucketOwner":
            return Optional.ofNullable(clazz.cast(expectedBucketOwner()));
        case "OptionalObjectAttributes":
            return Optional.ofNullable(clazz.cast(optionalObjectAttributesAsStrings()));
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
        map.put("max-keys", MAX_KEYS_FIELD);
        map.put("prefix", PREFIX_FIELD);
        map.put("continuation-token", CONTINUATION_TOKEN_FIELD);
        map.put("fetch-owner", FETCH_OWNER_FIELD);
        map.put("start-after", START_AFTER_FIELD);
        map.put("x-amz-request-payer", REQUEST_PAYER_FIELD);
        map.put("x-amz-expected-bucket-owner", EXPECTED_BUCKET_OWNER_FIELD);
        map.put("x-amz-optional-object-attributes", OPTIONAL_OBJECT_ATTRIBUTES_FIELD);
        return Collections.unmodifiableMap(map);
    }

    private static <T> Function<Object, T> getter(Function<ListObjectsV2Request, T> g) {
        return obj -> g.apply((ListObjectsV2Request) obj);
    }

    private static <T> BiConsumer<Object, T> setter(BiConsumer<Builder, T> s) {
        return (obj, val) -> s.accept((Builder) obj, val);
    }

    @Mutable
    @NotThreadSafe
    public interface Builder extends S3Request.Builder, SdkPojo, CopyableBuilder<Builder, ListObjectsV2Request> {
        /**
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
         *        <b>Directory buckets</b> - When you use this operation with a directory bucket, you must use
         *        virtual-hosted-style requests in the format
         *        <code> <i>Bucket-name</i>.s3express-<i>zone-id</i>.<i>region-code</i>.amazonaws.com</code>. Path-style
         *        requests are not supported. Directory bucket names must be unique in the chosen Zone (Availability
         *        Zone or Local Zone). Bucket names must follow the format
         *        <code> <i>bucket-base-name</i>--<i>zone-id</i>--x-s3</code> (for example,
         *        <code> <i>amzn-s3-demo-bucket</i>--<i>usw2-az1</i>--x-s3</code>). For information about bucket naming
         *        restrictions, see <a
         *        href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/directory-bucket-naming-rules.html"
         *        >Directory bucket naming rules</a> in the <i>Amazon S3 User Guide</i>.</p>
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
         * A delimiter is a character that you use to group keys.
         * </p>
         * <note>
         * <ul>
         * <li>
         * <p>
         * <b>Directory buckets</b> - For directory buckets, <code>/</code> is the only supported delimiter.
         * </p>
         * </li>
         * <li>
         * <p>
         * <b>Directory buckets </b> - When you query <code>ListObjectsV2</code> with a delimiter during in-progress
         * multipart uploads, the <code>CommonPrefixes</code> response parameter contains the prefixes that are
         * associated with the in-progress multipart uploads. For more information about multipart uploads, see <a
         * href="https://docs.aws.amazon.com/AmazonS3/latest/dev/mpuoverview.html">Multipart Upload Overview</a> in the
         * <i>Amazon S3 User Guide</i>.
         * </p>
         * </li>
         * </ul>
         * </note>
         * 
         * @param delimiter
         *        A delimiter is a character that you use to group keys.</p> <note>
         *        <ul>
         *        <li>
         *        <p>
         *        <b>Directory buckets</b> - For directory buckets, <code>/</code> is the only supported delimiter.
         *        </p>
         *        </li>
         *        <li>
         *        <p>
         *        <b>Directory buckets </b> - When you query <code>ListObjectsV2</code> with a delimiter during
         *        in-progress multipart uploads, the <code>CommonPrefixes</code> response parameter contains the
         *        prefixes that are associated with the in-progress multipart uploads. For more information about
         *        multipart uploads, see <a
         *        href="https://docs.aws.amazon.com/AmazonS3/latest/dev/mpuoverview.html">Multipart Upload Overview</a>
         *        in the <i>Amazon S3 User Guide</i>.
         *        </p>
         *        </li>
         *        </ul>
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder delimiter(String delimiter);

        /**
         * <p>
         * Encoding type used by Amazon S3 to encode the <a
         * href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/object-keys.html">object keys</a> in the
         * response. Responses are encoded only in UTF-8. An object key can contain any Unicode character. However, the
         * XML 1.0 parser can't parse certain characters, such as characters with an ASCII value from 0 to 10. For
         * characters that aren't supported in XML 1.0, you can add this parameter to request that Amazon S3 encode the
         * keys in the response. For more information about characters to avoid in object key names, see <a
         * href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/object-keys.html#object-key-guidelines">Object
         * key naming guidelines</a>.
         * </p>
         * <note>
         * <p>
         * When using the URL encoding type, non-ASCII characters that are used in an object's key name will be
         * percent-encoded according to UTF-8 code values. For example, the object <code>test_file(3).png</code> will
         * appear as <code>test_file%283%29.png</code>.
         * </p>
         * </note>
         * 
         * @param encodingType
         *        Encoding type used by Amazon S3 to encode the <a
         *        href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/object-keys.html">object keys</a> in the
         *        response. Responses are encoded only in UTF-8. An object key can contain any Unicode character.
         *        However, the XML 1.0 parser can't parse certain characters, such as characters with an ASCII value
         *        from 0 to 10. For characters that aren't supported in XML 1.0, you can add this parameter to request
         *        that Amazon S3 encode the keys in the response. For more information about characters to avoid in
         *        object key names, see <a
         *        href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/object-keys.html#object-key-guidelines"
         *        >Object key naming guidelines</a>.</p> <note>
         *        <p>
         *        When using the URL encoding type, non-ASCII characters that are used in an object's key name will be
         *        percent-encoded according to UTF-8 code values. For example, the object <code>test_file(3).png</code>
         *        will appear as <code>test_file%283%29.png</code>.
         *        </p>
         * @see EncodingType
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see EncodingType
         */
        Builder encodingType(String encodingType);

        /**
         * <p>
         * Encoding type used by Amazon S3 to encode the <a
         * href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/object-keys.html">object keys</a> in the
         * response. Responses are encoded only in UTF-8. An object key can contain any Unicode character. However, the
         * XML 1.0 parser can't parse certain characters, such as characters with an ASCII value from 0 to 10. For
         * characters that aren't supported in XML 1.0, you can add this parameter to request that Amazon S3 encode the
         * keys in the response. For more information about characters to avoid in object key names, see <a
         * href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/object-keys.html#object-key-guidelines">Object
         * key naming guidelines</a>.
         * </p>
         * <note>
         * <p>
         * When using the URL encoding type, non-ASCII characters that are used in an object's key name will be
         * percent-encoded according to UTF-8 code values. For example, the object <code>test_file(3).png</code> will
         * appear as <code>test_file%283%29.png</code>.
         * </p>
         * </note>
         * 
         * @param encodingType
         *        Encoding type used by Amazon S3 to encode the <a
         *        href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/object-keys.html">object keys</a> in the
         *        response. Responses are encoded only in UTF-8. An object key can contain any Unicode character.
         *        However, the XML 1.0 parser can't parse certain characters, such as characters with an ASCII value
         *        from 0 to 10. For characters that aren't supported in XML 1.0, you can add this parameter to request
         *        that Amazon S3 encode the keys in the response. For more information about characters to avoid in
         *        object key names, see <a
         *        href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/object-keys.html#object-key-guidelines"
         *        >Object key naming guidelines</a>.</p> <note>
         *        <p>
         *        When using the URL encoding type, non-ASCII characters that are used in an object's key name will be
         *        percent-encoded according to UTF-8 code values. For example, the object <code>test_file(3).png</code>
         *        will appear as <code>test_file%283%29.png</code>.
         *        </p>
         * @see EncodingType
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see EncodingType
         */
        Builder encodingType(EncodingType encodingType);

        /**
         * <p>
         * Sets the maximum number of keys returned in the response. By default, the action returns up to 1,000 key
         * names. The response might contain fewer keys but will never contain more.
         * </p>
         * 
         * @param maxKeys
         *        Sets the maximum number of keys returned in the response. By default, the action returns up to 1,000
         *        key names. The response might contain fewer keys but will never contain more.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder maxKeys(Integer maxKeys);

        /**
         * <p>
         * Limits the response to keys that begin with the specified prefix.
         * </p>
         * <note>
         * <p>
         * <b>Directory buckets</b> - For directory buckets, only prefixes that end in a delimiter (<code>/</code>) are
         * supported.
         * </p>
         * </note>
         * 
         * @param prefix
         *        Limits the response to keys that begin with the specified prefix.</p> <note>
         *        <p>
         *        <b>Directory buckets</b> - For directory buckets, only prefixes that end in a delimiter (
         *        <code>/</code>) are supported.
         *        </p>
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder prefix(String prefix);

        /**
         * <p>
         * <code>ContinuationToken</code> indicates to Amazon S3 that the list is being continued on this bucket with a
         * token. <code>ContinuationToken</code> is obfuscated and is not a real key. You can use this
         * <code>ContinuationToken</code> for pagination of the list results.
         * </p>
         * 
         * @param continuationToken
         *        <code>ContinuationToken</code> indicates to Amazon S3 that the list is being continued on this bucket
         *        with a token. <code>ContinuationToken</code> is obfuscated and is not a real key. You can use this
         *        <code>ContinuationToken</code> for pagination of the list results.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder continuationToken(String continuationToken);

        /**
         * <p>
         * The owner field is not present in <code>ListObjectsV2</code> by default. If you want to return the owner
         * field with each key in the result, then set the <code>FetchOwner</code> field to <code>true</code>.
         * </p>
         * <note>
         * <p>
         * <b>Directory buckets</b> - For directory buckets, the bucket owner is returned as the object owner for all
         * objects.
         * </p>
         * </note>
         * 
         * @param fetchOwner
         *        The owner field is not present in <code>ListObjectsV2</code> by default. If you want to return the
         *        owner field with each key in the result, then set the <code>FetchOwner</code> field to
         *        <code>true</code>.</p> <note>
         *        <p>
         *        <b>Directory buckets</b> - For directory buckets, the bucket owner is returned as the object owner for
         *        all objects.
         *        </p>
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder fetchOwner(Boolean fetchOwner);

        /**
         * <p>
         * StartAfter is where you want Amazon S3 to start listing from. Amazon S3 starts listing after this specified
         * key. StartAfter can be any key in the bucket.
         * </p>
         * <note>
         * <p>
         * This functionality is not supported for directory buckets.
         * </p>
         * </note>
         * 
         * @param startAfter
         *        StartAfter is where you want Amazon S3 to start listing from. Amazon S3 starts listing after this
         *        specified key. StartAfter can be any key in the bucket.</p> <note>
         *        <p>
         *        This functionality is not supported for directory buckets.
         *        </p>
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder startAfter(String startAfter);

        /**
         * <p>
         * Confirms that the requester knows that she or he will be charged for the list objects request in V2 style.
         * Bucket owners need not specify this parameter in their requests.
         * </p>
         * <note>
         * <p>
         * This functionality is not supported for directory buckets.
         * </p>
         * </note>
         * 
         * @param requestPayer
         *        Confirms that the requester knows that she or he will be charged for the list objects request in V2
         *        style. Bucket owners need not specify this parameter in their requests.</p> <note>
         *        <p>
         *        This functionality is not supported for directory buckets.
         *        </p>
         * @see RequestPayer
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see RequestPayer
         */
        Builder requestPayer(String requestPayer);

        /**
         * <p>
         * Confirms that the requester knows that she or he will be charged for the list objects request in V2 style.
         * Bucket owners need not specify this parameter in their requests.
         * </p>
         * <note>
         * <p>
         * This functionality is not supported for directory buckets.
         * </p>
         * </note>
         * 
         * @param requestPayer
         *        Confirms that the requester knows that she or he will be charged for the list objects request in V2
         *        style. Bucket owners need not specify this parameter in their requests.</p> <note>
         *        <p>
         *        This functionality is not supported for directory buckets.
         *        </p>
         * @see RequestPayer
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see RequestPayer
         */
        Builder requestPayer(RequestPayer requestPayer);

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
         * Specifies the optional fields that you want returned in the response. Fields that you do not specify are not
         * returned.
         * </p>
         * <note>
         * <p>
         * This functionality is not supported for directory buckets.
         * </p>
         * </note>
         * 
         * @param optionalObjectAttributes
         *        Specifies the optional fields that you want returned in the response. Fields that you do not specify
         *        are not returned.</p> <note>
         *        <p>
         *        This functionality is not supported for directory buckets.
         *        </p>
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder optionalObjectAttributesWithStrings(Collection<String> optionalObjectAttributes);

        /**
         * <p>
         * Specifies the optional fields that you want returned in the response. Fields that you do not specify are not
         * returned.
         * </p>
         * <note>
         * <p>
         * This functionality is not supported for directory buckets.
         * </p>
         * </note>
         * 
         * @param optionalObjectAttributes
         *        Specifies the optional fields that you want returned in the response. Fields that you do not specify
         *        are not returned.</p> <note>
         *        <p>
         *        This functionality is not supported for directory buckets.
         *        </p>
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder optionalObjectAttributesWithStrings(String... optionalObjectAttributes);

        /**
         * <p>
         * Specifies the optional fields that you want returned in the response. Fields that you do not specify are not
         * returned.
         * </p>
         * <note>
         * <p>
         * This functionality is not supported for directory buckets.
         * </p>
         * </note>
         * 
         * @param optionalObjectAttributes
         *        Specifies the optional fields that you want returned in the response. Fields that you do not specify
         *        are not returned.</p> <note>
         *        <p>
         *        This functionality is not supported for directory buckets.
         *        </p>
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder optionalObjectAttributes(Collection<OptionalObjectAttributes> optionalObjectAttributes);

        /**
         * <p>
         * Specifies the optional fields that you want returned in the response. Fields that you do not specify are not
         * returned.
         * </p>
         * <note>
         * <p>
         * This functionality is not supported for directory buckets.
         * </p>
         * </note>
         * 
         * @param optionalObjectAttributes
         *        Specifies the optional fields that you want returned in the response. Fields that you do not specify
         *        are not returned.</p> <note>
         *        <p>
         *        This functionality is not supported for directory buckets.
         *        </p>
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder optionalObjectAttributes(OptionalObjectAttributes... optionalObjectAttributes);

        @Override
        Builder overrideConfiguration(AwsRequestOverrideConfiguration overrideConfiguration);

        @Override
        Builder overrideConfiguration(Consumer<AwsRequestOverrideConfiguration.Builder> builderConsumer);
    }

    static final class BuilderImpl extends S3Request.BuilderImpl implements Builder {
        private String bucket;

        private String delimiter;

        private String encodingType;

        private Integer maxKeys;

        private String prefix;

        private String continuationToken;

        private Boolean fetchOwner;

        private String startAfter;

        private String requestPayer;

        private String expectedBucketOwner;

        private List<String> optionalObjectAttributes = DefaultSdkAutoConstructList.getInstance();

        private BuilderImpl() {
        }

        private BuilderImpl(ListObjectsV2Request model) {
            super(model);
            bucket(model.bucket);
            delimiter(model.delimiter);
            encodingType(model.encodingType);
            maxKeys(model.maxKeys);
            prefix(model.prefix);
            continuationToken(model.continuationToken);
            fetchOwner(model.fetchOwner);
            startAfter(model.startAfter);
            requestPayer(model.requestPayer);
            expectedBucketOwner(model.expectedBucketOwner);
            optionalObjectAttributesWithStrings(model.optionalObjectAttributes);
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

        public final Integer getMaxKeys() {
            return maxKeys;
        }

        public final void setMaxKeys(Integer maxKeys) {
            this.maxKeys = maxKeys;
        }

        @Override
        public final Builder maxKeys(Integer maxKeys) {
            this.maxKeys = maxKeys;
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

        public final Boolean getFetchOwner() {
            return fetchOwner;
        }

        public final void setFetchOwner(Boolean fetchOwner) {
            this.fetchOwner = fetchOwner;
        }

        @Override
        public final Builder fetchOwner(Boolean fetchOwner) {
            this.fetchOwner = fetchOwner;
            return this;
        }

        public final String getStartAfter() {
            return startAfter;
        }

        public final void setStartAfter(String startAfter) {
            this.startAfter = startAfter;
        }

        @Override
        public final Builder startAfter(String startAfter) {
            this.startAfter = startAfter;
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

        public final Collection<String> getOptionalObjectAttributes() {
            if (optionalObjectAttributes instanceof SdkAutoConstructList) {
                return null;
            }
            return optionalObjectAttributes;
        }

        public final void setOptionalObjectAttributes(Collection<String> optionalObjectAttributes) {
            this.optionalObjectAttributes = OptionalObjectAttributesListCopier.copy(optionalObjectAttributes);
        }

        @Override
        public final Builder optionalObjectAttributesWithStrings(Collection<String> optionalObjectAttributes) {
            this.optionalObjectAttributes = OptionalObjectAttributesListCopier.copy(optionalObjectAttributes);
            return this;
        }

        @Override
        @SafeVarargs
        public final Builder optionalObjectAttributesWithStrings(String... optionalObjectAttributes) {
            optionalObjectAttributesWithStrings(Arrays.asList(optionalObjectAttributes));
            return this;
        }

        @Override
        public final Builder optionalObjectAttributes(Collection<OptionalObjectAttributes> optionalObjectAttributes) {
            this.optionalObjectAttributes = OptionalObjectAttributesListCopier.copyEnumToString(optionalObjectAttributes);
            return this;
        }

        @Override
        @SafeVarargs
        public final Builder optionalObjectAttributes(OptionalObjectAttributes... optionalObjectAttributes) {
            optionalObjectAttributes(Arrays.asList(optionalObjectAttributes));
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
        public ListObjectsV2Request build() {
            return new ListObjectsV2Request(this);
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
