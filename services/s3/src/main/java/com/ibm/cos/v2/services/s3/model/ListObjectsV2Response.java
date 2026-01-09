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
import java.util.stream.Collectors;
import java.util.stream.Stream;
import com.ibm.cos.v2.annotations.Generated;
import com.ibm.cos.v2.annotations.Mutable;
import com.ibm.cos.v2.annotations.NotThreadSafe;
import com.ibm.cos.v2.core.SdkField;
import com.ibm.cos.v2.core.SdkPojo;
import com.ibm.cos.v2.core.protocol.MarshallLocation;
import com.ibm.cos.v2.core.protocol.MarshallingType;
import com.ibm.cos.v2.core.traits.ListTrait;
import com.ibm.cos.v2.core.traits.LocationTrait;
import com.ibm.cos.v2.core.util.DefaultSdkAutoConstructList;
import com.ibm.cos.v2.core.util.SdkAutoConstructList;
import com.ibm.cos.v2.utils.ToString;
import com.ibm.cos.v2.utils.builder.CopyableBuilder;
import com.ibm.cos.v2.utils.builder.ToCopyableBuilder;

/**
 */
@Generated("com.ibm.cos.v2:codegen")
public final class ListObjectsV2Response extends S3Response implements
        ToCopyableBuilder<ListObjectsV2Response.Builder, ListObjectsV2Response> {
    private static final SdkField<Boolean> IS_TRUNCATED_FIELD = SdkField
            .<Boolean> builder(MarshallingType.BOOLEAN)
            .memberName("IsTruncated")
            .getter(getter(ListObjectsV2Response::isTruncated))
            .setter(setter(Builder::isTruncated))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("IsTruncated")
                    .unmarshallLocationName("IsTruncated").build()).build();

    private static final SdkField<List<S3Object>> CONTENTS_FIELD = SdkField
            .<List<S3Object>> builder(MarshallingType.LIST)
            .memberName("Contents")
            .getter(getter(ListObjectsV2Response::contents))
            .setter(setter(Builder::contents))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("Contents")
                    .unmarshallLocationName("Contents").build(),
                    ListTrait
                            .builder()
                            .memberLocationName(null)
                            .memberFieldInfo(
                                    SdkField.<S3Object> builder(MarshallingType.SDK_POJO)
                                            .constructor(S3Object::builder)
                                            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD)
                                                    .locationName("member").unmarshallLocationName("member").build()).build())
                            .isFlattened(true).build()).build();

    private static final SdkField<String> NAME_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("Name")
            .getter(getter(ListObjectsV2Response::name))
            .setter(setter(Builder::name))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("Name")
                    .unmarshallLocationName("Name").build()).build();

    private static final SdkField<String> PREFIX_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("Prefix")
            .getter(getter(ListObjectsV2Response::prefix))
            .setter(setter(Builder::prefix))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("Prefix")
                    .unmarshallLocationName("Prefix").build()).build();

    private static final SdkField<String> DELIMITER_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("Delimiter")
            .getter(getter(ListObjectsV2Response::delimiter))
            .setter(setter(Builder::delimiter))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("Delimiter")
                    .unmarshallLocationName("Delimiter").build()).build();

    private static final SdkField<Integer> MAX_KEYS_FIELD = SdkField
            .<Integer> builder(MarshallingType.INTEGER)
            .memberName("MaxKeys")
            .getter(getter(ListObjectsV2Response::maxKeys))
            .setter(setter(Builder::maxKeys))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("MaxKeys")
                    .unmarshallLocationName("MaxKeys").build()).build();

    private static final SdkField<List<CommonPrefix>> COMMON_PREFIXES_FIELD = SdkField
            .<List<CommonPrefix>> builder(MarshallingType.LIST)
            .memberName("CommonPrefixes")
            .getter(getter(ListObjectsV2Response::commonPrefixes))
            .setter(setter(Builder::commonPrefixes))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("CommonPrefixes")
                    .unmarshallLocationName("CommonPrefixes").build(),
                    ListTrait
                            .builder()
                            .memberLocationName(null)
                            .memberFieldInfo(
                                    SdkField.<CommonPrefix> builder(MarshallingType.SDK_POJO)
                                            .constructor(CommonPrefix::builder)
                                            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD)
                                                    .locationName("member").unmarshallLocationName("member").build()).build())
                            .isFlattened(true).build()).build();

    private static final SdkField<String> ENCODING_TYPE_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("EncodingType")
            .getter(getter(ListObjectsV2Response::encodingTypeAsString))
            .setter(setter(Builder::encodingType))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("EncodingType")
                    .unmarshallLocationName("EncodingType").build()).build();

    private static final SdkField<Integer> KEY_COUNT_FIELD = SdkField
            .<Integer> builder(MarshallingType.INTEGER)
            .memberName("KeyCount")
            .getter(getter(ListObjectsV2Response::keyCount))
            .setter(setter(Builder::keyCount))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("KeyCount")
                    .unmarshallLocationName("KeyCount").build()).build();

    private static final SdkField<String> CONTINUATION_TOKEN_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("ContinuationToken")
            .getter(getter(ListObjectsV2Response::continuationToken))
            .setter(setter(Builder::continuationToken))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("ContinuationToken")
                    .unmarshallLocationName("ContinuationToken").build()).build();

    private static final SdkField<String> NEXT_CONTINUATION_TOKEN_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("NextContinuationToken")
            .getter(getter(ListObjectsV2Response::nextContinuationToken))
            .setter(setter(Builder::nextContinuationToken))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("NextContinuationToken")
                    .unmarshallLocationName("NextContinuationToken").build()).build();

    private static final SdkField<String> START_AFTER_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("StartAfter")
            .getter(getter(ListObjectsV2Response::startAfter))
            .setter(setter(Builder::startAfter))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("StartAfter")
                    .unmarshallLocationName("StartAfter").build()).build();

    private static final SdkField<String> REQUEST_CHARGED_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("RequestCharged")
            .getter(getter(ListObjectsV2Response::requestChargedAsString))
            .setter(setter(Builder::requestCharged))
            .traits(LocationTrait.builder().location(MarshallLocation.HEADER).locationName("x-amz-request-charged")
                    .unmarshallLocationName("x-amz-request-charged").build()).build();

    private static final List<SdkField<?>> SDK_FIELDS = Collections.unmodifiableList(Arrays.asList(IS_TRUNCATED_FIELD,
            CONTENTS_FIELD, NAME_FIELD, PREFIX_FIELD, DELIMITER_FIELD, MAX_KEYS_FIELD, COMMON_PREFIXES_FIELD,
            ENCODING_TYPE_FIELD, KEY_COUNT_FIELD, CONTINUATION_TOKEN_FIELD, NEXT_CONTINUATION_TOKEN_FIELD, START_AFTER_FIELD,
            REQUEST_CHARGED_FIELD));

    private static final Map<String, SdkField<?>> SDK_NAME_TO_FIELD = memberNameToFieldInitializer();

    private final Boolean isTruncated;

    private final List<S3Object> contents;

    private final String name;

    private final String prefix;

    private final String delimiter;

    private final Integer maxKeys;

    private final List<CommonPrefix> commonPrefixes;

    private final String encodingType;

    private final Integer keyCount;

    private final String continuationToken;

    private final String nextContinuationToken;

    private final String startAfter;

    private final String requestCharged;

    private ListObjectsV2Response(BuilderImpl builder) {
        super(builder);
        this.isTruncated = builder.isTruncated;
        this.contents = builder.contents;
        this.name = builder.name;
        this.prefix = builder.prefix;
        this.delimiter = builder.delimiter;
        this.maxKeys = builder.maxKeys;
        this.commonPrefixes = builder.commonPrefixes;
        this.encodingType = builder.encodingType;
        this.keyCount = builder.keyCount;
        this.continuationToken = builder.continuationToken;
        this.nextContinuationToken = builder.nextContinuationToken;
        this.startAfter = builder.startAfter;
        this.requestCharged = builder.requestCharged;
    }

    /**
     * <p>
     * Set to <code>false</code> if all of the results were returned. Set to <code>true</code> if more keys are
     * available to return. If the number of results exceeds that specified by <code>MaxKeys</code>, all of the results
     * might not be returned.
     * </p>
     * 
     * @return Set to <code>false</code> if all of the results were returned. Set to <code>true</code> if more keys are
     *         available to return. If the number of results exceeds that specified by <code>MaxKeys</code>, all of the
     *         results might not be returned.
     */
    public final Boolean isTruncated() {
        return isTruncated;
    }

    /**
     * For responses, this returns true if the service returned a value for the Contents property. This DOES NOT check
     * that the value is non-empty (for which, you should check the {@code isEmpty()} method on the property). This is
     * useful because the SDK will never return a null collection or map, but you may need to differentiate between the
     * service returning nothing (or null) and the service returning an empty collection or map. For requests, this
     * returns true if a value for the property was specified in the request builder, and false if a value was not
     * specified.
     */
    public final boolean hasContents() {
        return contents != null && !(contents instanceof SdkAutoConstructList);
    }

    /**
     * <p>
     * Metadata about each object returned.
     * </p>
     * <p>
     * Attempts to modify the collection returned by this method will result in an UnsupportedOperationException.
     * </p>
     * <p>
     * This method will never return null. If you would like to know whether the service returned this field (so that
     * you can differentiate between null and empty), you can use the {@link #hasContents} method.
     * </p>
     * 
     * @return Metadata about each object returned.
     */
    public final List<S3Object> contents() {
        return contents;
    }

    /**
     * <p>
     * The bucket name.
     * </p>
     * 
     * @return The bucket name.
     */
    public final String name() {
        return name;
    }

    /**
     * <p>
     * Keys that begin with the indicated prefix.
     * </p>
     * <note>
     * <p>
     * <b>Directory buckets</b> - For directory buckets, only prefixes that end in a delimiter (<code>/</code>) are
     * supported.
     * </p>
     * </note>
     * 
     * @return Keys that begin with the indicated prefix.</p> <note>
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
     * Causes keys that contain the same string between the <code>prefix</code> and the first occurrence of the
     * delimiter to be rolled up into a single result element in the <code>CommonPrefixes</code> collection. These
     * rolled-up keys are not returned elsewhere in the response. Each rolled-up result counts as only one return
     * against the <code>MaxKeys</code> value.
     * </p>
     * <note>
     * <p>
     * <b>Directory buckets</b> - For directory buckets, <code>/</code> is the only supported delimiter.
     * </p>
     * </note>
     * 
     * @return Causes keys that contain the same string between the <code>prefix</code> and the first occurrence of the
     *         delimiter to be rolled up into a single result element in the <code>CommonPrefixes</code> collection.
     *         These rolled-up keys are not returned elsewhere in the response. Each rolled-up result counts as only one
     *         return against the <code>MaxKeys</code> value.</p> <note>
     *         <p>
     *         <b>Directory buckets</b> - For directory buckets, <code>/</code> is the only supported delimiter.
     *         </p>
     */
    public final String delimiter() {
        return delimiter;
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
     * For responses, this returns true if the service returned a value for the CommonPrefixes property. This DOES NOT
     * check that the value is non-empty (for which, you should check the {@code isEmpty()} method on the property).
     * This is useful because the SDK will never return a null collection or map, but you may need to differentiate
     * between the service returning nothing (or null) and the service returning an empty collection or map. For
     * requests, this returns true if a value for the property was specified in the request builder, and false if a
     * value was not specified.
     */
    public final boolean hasCommonPrefixes() {
        return commonPrefixes != null && !(commonPrefixes instanceof SdkAutoConstructList);
    }

    /**
     * <p>
     * All of the keys (up to 1,000) that share the same prefix are grouped together. When counting the total numbers of
     * returns by this API operation, this group of keys is considered as one item.
     * </p>
     * <p>
     * A response can contain <code>CommonPrefixes</code> only if you specify a delimiter.
     * </p>
     * <p>
     * <code>CommonPrefixes</code> contains all (if there are any) keys between <code>Prefix</code> and the next
     * occurrence of the string specified by a delimiter.
     * </p>
     * <p>
     * <code>CommonPrefixes</code> lists keys that act like subdirectories in the directory specified by
     * <code>Prefix</code>.
     * </p>
     * <p>
     * For example, if the prefix is <code>notes/</code> and the delimiter is a slash (<code>/</code>) as in
     * <code>notes/summer/july</code>, the common prefix is <code>notes/summer/</code>. All of the keys that roll up
     * into a common prefix count as a single return when calculating the number of returns.
     * </p>
     * <note>
     * <ul>
     * <li>
     * <p>
     * <b>Directory buckets</b> - For directory buckets, only prefixes that end in a delimiter (<code>/</code>) are
     * supported.
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
     * <p>
     * Attempts to modify the collection returned by this method will result in an UnsupportedOperationException.
     * </p>
     * <p>
     * This method will never return null. If you would like to know whether the service returned this field (so that
     * you can differentiate between null and empty), you can use the {@link #hasCommonPrefixes} method.
     * </p>
     * 
     * @return All of the keys (up to 1,000) that share the same prefix are grouped together. When counting the total
     *         numbers of returns by this API operation, this group of keys is considered as one item.</p>
     *         <p>
     *         A response can contain <code>CommonPrefixes</code> only if you specify a delimiter.
     *         </p>
     *         <p>
     *         <code>CommonPrefixes</code> contains all (if there are any) keys between <code>Prefix</code> and the next
     *         occurrence of the string specified by a delimiter.
     *         </p>
     *         <p>
     *         <code>CommonPrefixes</code> lists keys that act like subdirectories in the directory specified by
     *         <code>Prefix</code>.
     *         </p>
     *         <p>
     *         For example, if the prefix is <code>notes/</code> and the delimiter is a slash (<code>/</code>) as in
     *         <code>notes/summer/july</code>, the common prefix is <code>notes/summer/</code>. All of the keys that
     *         roll up into a common prefix count as a single return when calculating the number of returns.
     *         </p>
     *         <note>
     *         <ul>
     *         <li>
     *         <p>
     *         <b>Directory buckets</b> - For directory buckets, only prefixes that end in a delimiter (<code>/</code>)
     *         are supported.
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
    public final List<CommonPrefix> commonPrefixes() {
        return commonPrefixes;
    }

    /**
     * <p>
     * Encoding type used by Amazon S3 to encode object key names in the XML response.
     * </p>
     * <p>
     * If you specify the <code>encoding-type</code> request parameter, Amazon S3 includes this element in the response,
     * and returns encoded key name values in the following response elements:
     * </p>
     * <p>
     * <code>Delimiter, Prefix, Key,</code> and <code>StartAfter</code>.
     * </p>
     * <p>
     * If the service returns an enum value that is not available in the current SDK version, {@link #encodingType} will
     * return {@link EncodingType#UNKNOWN_TO_SDK_VERSION}. The raw value returned by the service is available from
     * {@link #encodingTypeAsString}.
     * </p>
     * 
     * @return Encoding type used by Amazon S3 to encode object key names in the XML response.</p>
     *         <p>
     *         If you specify the <code>encoding-type</code> request parameter, Amazon S3 includes this element in the
     *         response, and returns encoded key name values in the following response elements:
     *         </p>
     *         <p>
     *         <code>Delimiter, Prefix, Key,</code> and <code>StartAfter</code>.
     * @see EncodingType
     */
    public final EncodingType encodingType() {
        return EncodingType.fromValue(encodingType);
    }

    /**
     * <p>
     * Encoding type used by Amazon S3 to encode object key names in the XML response.
     * </p>
     * <p>
     * If you specify the <code>encoding-type</code> request parameter, Amazon S3 includes this element in the response,
     * and returns encoded key name values in the following response elements:
     * </p>
     * <p>
     * <code>Delimiter, Prefix, Key,</code> and <code>StartAfter</code>.
     * </p>
     * <p>
     * If the service returns an enum value that is not available in the current SDK version, {@link #encodingType} will
     * return {@link EncodingType#UNKNOWN_TO_SDK_VERSION}. The raw value returned by the service is available from
     * {@link #encodingTypeAsString}.
     * </p>
     * 
     * @return Encoding type used by Amazon S3 to encode object key names in the XML response.</p>
     *         <p>
     *         If you specify the <code>encoding-type</code> request parameter, Amazon S3 includes this element in the
     *         response, and returns encoded key name values in the following response elements:
     *         </p>
     *         <p>
     *         <code>Delimiter, Prefix, Key,</code> and <code>StartAfter</code>.
     * @see EncodingType
     */
    public final String encodingTypeAsString() {
        return encodingType;
    }

    /**
     * <p>
     * <code>KeyCount</code> is the number of keys returned with this request. <code>KeyCount</code> will always be less
     * than or equal to the <code>MaxKeys</code> field. For example, if you ask for 50 keys, your result will include 50
     * keys or fewer.
     * </p>
     * 
     * @return <code>KeyCount</code> is the number of keys returned with this request. <code>KeyCount</code> will always
     *         be less than or equal to the <code>MaxKeys</code> field. For example, if you ask for 50 keys, your result
     *         will include 50 keys or fewer.
     */
    public final Integer keyCount() {
        return keyCount;
    }

    /**
     * <p>
     * If <code>ContinuationToken</code> was sent with the request, it is included in the response. You can use the
     * returned <code>ContinuationToken</code> for pagination of the list response. You can use this
     * <code>ContinuationToken</code> for pagination of the list results.
     * </p>
     * 
     * @return If <code>ContinuationToken</code> was sent with the request, it is included in the response. You can use
     *         the returned <code>ContinuationToken</code> for pagination of the list response. You can use this
     *         <code>ContinuationToken</code> for pagination of the list results.
     */
    public final String continuationToken() {
        return continuationToken;
    }

    /**
     * <p>
     * <code>NextContinuationToken</code> is sent when <code>isTruncated</code> is true, which means there are more keys
     * in the bucket that can be listed. The next list requests to Amazon S3 can be continued with this
     * <code>NextContinuationToken</code>. <code>NextContinuationToken</code> is obfuscated and is not a real key
     * </p>
     * 
     * @return <code>NextContinuationToken</code> is sent when <code>isTruncated</code> is true, which means there are
     *         more keys in the bucket that can be listed. The next list requests to Amazon S3 can be continued with
     *         this <code>NextContinuationToken</code>. <code>NextContinuationToken</code> is obfuscated and is not a
     *         real key
     */
    public final String nextContinuationToken() {
        return nextContinuationToken;
    }

    /**
     * <p>
     * If StartAfter was sent with the request, it is included in the response.
     * </p>
     * <note>
     * <p>
     * This functionality is not supported for directory buckets.
     * </p>
     * </note>
     * 
     * @return If StartAfter was sent with the request, it is included in the response.</p> <note>
     *         <p>
     *         This functionality is not supported for directory buckets.
     *         </p>
     */
    public final String startAfter() {
        return startAfter;
    }

    /**
     * Returns the value of the RequestCharged property for this object.
     * <p>
     * If the service returns an enum value that is not available in the current SDK version, {@link #requestCharged}
     * will return {@link RequestCharged#UNKNOWN_TO_SDK_VERSION}. The raw value returned by the service is available
     * from {@link #requestChargedAsString}.
     * </p>
     * 
     * @return The value of the RequestCharged property for this object.
     * @see RequestCharged
     */
    public final RequestCharged requestCharged() {
        return RequestCharged.fromValue(requestCharged);
    }

    /**
     * Returns the value of the RequestCharged property for this object.
     * <p>
     * If the service returns an enum value that is not available in the current SDK version, {@link #requestCharged}
     * will return {@link RequestCharged#UNKNOWN_TO_SDK_VERSION}. The raw value returned by the service is available
     * from {@link #requestChargedAsString}.
     * </p>
     * 
     * @return The value of the RequestCharged property for this object.
     * @see RequestCharged
     */
    public final String requestChargedAsString() {
        return requestCharged;
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
        hashCode = 31 * hashCode + Objects.hashCode(isTruncated());
        hashCode = 31 * hashCode + Objects.hashCode(hasContents() ? contents() : null);
        hashCode = 31 * hashCode + Objects.hashCode(name());
        hashCode = 31 * hashCode + Objects.hashCode(prefix());
        hashCode = 31 * hashCode + Objects.hashCode(delimiter());
        hashCode = 31 * hashCode + Objects.hashCode(maxKeys());
        hashCode = 31 * hashCode + Objects.hashCode(hasCommonPrefixes() ? commonPrefixes() : null);
        hashCode = 31 * hashCode + Objects.hashCode(encodingTypeAsString());
        hashCode = 31 * hashCode + Objects.hashCode(keyCount());
        hashCode = 31 * hashCode + Objects.hashCode(continuationToken());
        hashCode = 31 * hashCode + Objects.hashCode(nextContinuationToken());
        hashCode = 31 * hashCode + Objects.hashCode(startAfter());
        hashCode = 31 * hashCode + Objects.hashCode(requestChargedAsString());
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
        if (!(obj instanceof ListObjectsV2Response)) {
            return false;
        }
        ListObjectsV2Response other = (ListObjectsV2Response) obj;
        return Objects.equals(isTruncated(), other.isTruncated()) && hasContents() == other.hasContents()
                && Objects.equals(contents(), other.contents()) && Objects.equals(name(), other.name())
                && Objects.equals(prefix(), other.prefix()) && Objects.equals(delimiter(), other.delimiter())
                && Objects.equals(maxKeys(), other.maxKeys()) && hasCommonPrefixes() == other.hasCommonPrefixes()
                && Objects.equals(commonPrefixes(), other.commonPrefixes())
                && Objects.equals(encodingTypeAsString(), other.encodingTypeAsString())
                && Objects.equals(keyCount(), other.keyCount()) && Objects.equals(continuationToken(), other.continuationToken())
                && Objects.equals(nextContinuationToken(), other.nextContinuationToken())
                && Objects.equals(startAfter(), other.startAfter())
                && Objects.equals(requestChargedAsString(), other.requestChargedAsString());
    }

    /**
     * Returns a string representation of this object. This is useful for testing and debugging. Sensitive data will be
     * redacted from this string using a placeholder value.
     */
    @Override
    public final String toString() {
        return ToString.builder("ListObjectsV2Response").add("IsTruncated", isTruncated())
                .add("Contents", hasContents() ? contents() : null).add("Name", name()).add("Prefix", prefix())
                .add("Delimiter", delimiter()).add("MaxKeys", maxKeys())
                .add("CommonPrefixes", hasCommonPrefixes() ? commonPrefixes() : null).add("EncodingType", encodingTypeAsString())
                .add("KeyCount", keyCount()).add("ContinuationToken", continuationToken())
                .add("NextContinuationToken", nextContinuationToken()).add("StartAfter", startAfter())
                .add("RequestCharged", requestChargedAsString()).build();
    }

    public final <T> Optional<T> getValueForField(String fieldName, Class<T> clazz) {
        switch (fieldName) {
        case "IsTruncated":
            return Optional.ofNullable(clazz.cast(isTruncated()));
        case "Contents":
            return Optional.ofNullable(clazz.cast(contents()));
        case "Name":
            return Optional.ofNullable(clazz.cast(name()));
        case "Prefix":
            return Optional.ofNullable(clazz.cast(prefix()));
        case "Delimiter":
            return Optional.ofNullable(clazz.cast(delimiter()));
        case "MaxKeys":
            return Optional.ofNullable(clazz.cast(maxKeys()));
        case "CommonPrefixes":
            return Optional.ofNullable(clazz.cast(commonPrefixes()));
        case "EncodingType":
            return Optional.ofNullable(clazz.cast(encodingTypeAsString()));
        case "KeyCount":
            return Optional.ofNullable(clazz.cast(keyCount()));
        case "ContinuationToken":
            return Optional.ofNullable(clazz.cast(continuationToken()));
        case "NextContinuationToken":
            return Optional.ofNullable(clazz.cast(nextContinuationToken()));
        case "StartAfter":
            return Optional.ofNullable(clazz.cast(startAfter()));
        case "RequestCharged":
            return Optional.ofNullable(clazz.cast(requestChargedAsString()));
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
        map.put("IsTruncated", IS_TRUNCATED_FIELD);
        map.put("Contents", CONTENTS_FIELD);
        map.put("Name", NAME_FIELD);
        map.put("Prefix", PREFIX_FIELD);
        map.put("Delimiter", DELIMITER_FIELD);
        map.put("MaxKeys", MAX_KEYS_FIELD);
        map.put("CommonPrefixes", COMMON_PREFIXES_FIELD);
        map.put("EncodingType", ENCODING_TYPE_FIELD);
        map.put("KeyCount", KEY_COUNT_FIELD);
        map.put("ContinuationToken", CONTINUATION_TOKEN_FIELD);
        map.put("NextContinuationToken", NEXT_CONTINUATION_TOKEN_FIELD);
        map.put("StartAfter", START_AFTER_FIELD);
        map.put("x-amz-request-charged", REQUEST_CHARGED_FIELD);
        return Collections.unmodifiableMap(map);
    }

    private static <T> Function<Object, T> getter(Function<ListObjectsV2Response, T> g) {
        return obj -> g.apply((ListObjectsV2Response) obj);
    }

    private static <T> BiConsumer<Object, T> setter(BiConsumer<Builder, T> s) {
        return (obj, val) -> s.accept((Builder) obj, val);
    }

    @Mutable
    @NotThreadSafe
    public interface Builder extends S3Response.Builder, SdkPojo, CopyableBuilder<Builder, ListObjectsV2Response> {
        /**
         * <p>
         * Set to <code>false</code> if all of the results were returned. Set to <code>true</code> if more keys are
         * available to return. If the number of results exceeds that specified by <code>MaxKeys</code>, all of the
         * results might not be returned.
         * </p>
         * 
         * @param isTruncated
         *        Set to <code>false</code> if all of the results were returned. Set to <code>true</code> if more keys
         *        are available to return. If the number of results exceeds that specified by <code>MaxKeys</code>, all
         *        of the results might not be returned.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder isTruncated(Boolean isTruncated);

        /**
         * <p>
         * Metadata about each object returned.
         * </p>
         * 
         * @param contents
         *        Metadata about each object returned.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder contents(Collection<S3Object> contents);

        /**
         * <p>
         * Metadata about each object returned.
         * </p>
         * 
         * @param contents
         *        Metadata about each object returned.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder contents(S3Object... contents);

        /**
         * <p>
         * Metadata about each object returned.
         * </p>
         * This is a convenience method that creates an instance of the
         * {@link com.ibm.cos.v2.services.s3.model.S3Object.Builder} avoiding the need to create one manually
         * via {@link com.ibm.cos.v2.services.s3.model.S3Object#builder()}.
         *
         * <p>
         * When the {@link Consumer} completes,
         * {@link com.ibm.cos.v2.services.s3.model.S3Object.Builder#build()} is called immediately and its
         * result is passed to {@link #contents(List<S3Object>)}.
         * 
         * @param contents
         *        a consumer that will call methods on {@link com.ibm.cos.v2.services.s3.model.S3Object.Builder}
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see #contents(java.util.Collection<S3Object>)
         */
        Builder contents(Consumer<S3Object.Builder>... contents);

        /**
         * <p>
         * The bucket name.
         * </p>
         * 
         * @param name
         *        The bucket name.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder name(String name);

        /**
         * <p>
         * Keys that begin with the indicated prefix.
         * </p>
         * <note>
         * <p>
         * <b>Directory buckets</b> - For directory buckets, only prefixes that end in a delimiter (<code>/</code>) are
         * supported.
         * </p>
         * </note>
         * 
         * @param prefix
         *        Keys that begin with the indicated prefix.</p> <note>
         *        <p>
         *        <b>Directory buckets</b> - For directory buckets, only prefixes that end in a delimiter (
         *        <code>/</code>) are supported.
         *        </p>
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder prefix(String prefix);

        /**
         * <p>
         * Causes keys that contain the same string between the <code>prefix</code> and the first occurrence of the
         * delimiter to be rolled up into a single result element in the <code>CommonPrefixes</code> collection. These
         * rolled-up keys are not returned elsewhere in the response. Each rolled-up result counts as only one return
         * against the <code>MaxKeys</code> value.
         * </p>
         * <note>
         * <p>
         * <b>Directory buckets</b> - For directory buckets, <code>/</code> is the only supported delimiter.
         * </p>
         * </note>
         * 
         * @param delimiter
         *        Causes keys that contain the same string between the <code>prefix</code> and the first occurrence of
         *        the delimiter to be rolled up into a single result element in the <code>CommonPrefixes</code>
         *        collection. These rolled-up keys are not returned elsewhere in the response. Each rolled-up result
         *        counts as only one return against the <code>MaxKeys</code> value.</p> <note>
         *        <p>
         *        <b>Directory buckets</b> - For directory buckets, <code>/</code> is the only supported delimiter.
         *        </p>
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder delimiter(String delimiter);

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
         * All of the keys (up to 1,000) that share the same prefix are grouped together. When counting the total
         * numbers of returns by this API operation, this group of keys is considered as one item.
         * </p>
         * <p>
         * A response can contain <code>CommonPrefixes</code> only if you specify a delimiter.
         * </p>
         * <p>
         * <code>CommonPrefixes</code> contains all (if there are any) keys between <code>Prefix</code> and the next
         * occurrence of the string specified by a delimiter.
         * </p>
         * <p>
         * <code>CommonPrefixes</code> lists keys that act like subdirectories in the directory specified by
         * <code>Prefix</code>.
         * </p>
         * <p>
         * For example, if the prefix is <code>notes/</code> and the delimiter is a slash (<code>/</code>) as in
         * <code>notes/summer/july</code>, the common prefix is <code>notes/summer/</code>. All of the keys that roll up
         * into a common prefix count as a single return when calculating the number of returns.
         * </p>
         * <note>
         * <ul>
         * <li>
         * <p>
         * <b>Directory buckets</b> - For directory buckets, only prefixes that end in a delimiter (<code>/</code>) are
         * supported.
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
         * @param commonPrefixes
         *        All of the keys (up to 1,000) that share the same prefix are grouped together. When counting the total
         *        numbers of returns by this API operation, this group of keys is considered as one item.</p>
         *        <p>
         *        A response can contain <code>CommonPrefixes</code> only if you specify a delimiter.
         *        </p>
         *        <p>
         *        <code>CommonPrefixes</code> contains all (if there are any) keys between <code>Prefix</code> and the
         *        next occurrence of the string specified by a delimiter.
         *        </p>
         *        <p>
         *        <code>CommonPrefixes</code> lists keys that act like subdirectories in the directory specified by
         *        <code>Prefix</code>.
         *        </p>
         *        <p>
         *        For example, if the prefix is <code>notes/</code> and the delimiter is a slash (<code>/</code>) as in
         *        <code>notes/summer/july</code>, the common prefix is <code>notes/summer/</code>. All of the keys that
         *        roll up into a common prefix count as a single return when calculating the number of returns.
         *        </p>
         *        <note>
         *        <ul>
         *        <li>
         *        <p>
         *        <b>Directory buckets</b> - For directory buckets, only prefixes that end in a delimiter (
         *        <code>/</code>) are supported.
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
        Builder commonPrefixes(Collection<CommonPrefix> commonPrefixes);

        /**
         * <p>
         * All of the keys (up to 1,000) that share the same prefix are grouped together. When counting the total
         * numbers of returns by this API operation, this group of keys is considered as one item.
         * </p>
         * <p>
         * A response can contain <code>CommonPrefixes</code> only if you specify a delimiter.
         * </p>
         * <p>
         * <code>CommonPrefixes</code> contains all (if there are any) keys between <code>Prefix</code> and the next
         * occurrence of the string specified by a delimiter.
         * </p>
         * <p>
         * <code>CommonPrefixes</code> lists keys that act like subdirectories in the directory specified by
         * <code>Prefix</code>.
         * </p>
         * <p>
         * For example, if the prefix is <code>notes/</code> and the delimiter is a slash (<code>/</code>) as in
         * <code>notes/summer/july</code>, the common prefix is <code>notes/summer/</code>. All of the keys that roll up
         * into a common prefix count as a single return when calculating the number of returns.
         * </p>
         * <note>
         * <ul>
         * <li>
         * <p>
         * <b>Directory buckets</b> - For directory buckets, only prefixes that end in a delimiter (<code>/</code>) are
         * supported.
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
         * @param commonPrefixes
         *        All of the keys (up to 1,000) that share the same prefix are grouped together. When counting the total
         *        numbers of returns by this API operation, this group of keys is considered as one item.</p>
         *        <p>
         *        A response can contain <code>CommonPrefixes</code> only if you specify a delimiter.
         *        </p>
         *        <p>
         *        <code>CommonPrefixes</code> contains all (if there are any) keys between <code>Prefix</code> and the
         *        next occurrence of the string specified by a delimiter.
         *        </p>
         *        <p>
         *        <code>CommonPrefixes</code> lists keys that act like subdirectories in the directory specified by
         *        <code>Prefix</code>.
         *        </p>
         *        <p>
         *        For example, if the prefix is <code>notes/</code> and the delimiter is a slash (<code>/</code>) as in
         *        <code>notes/summer/july</code>, the common prefix is <code>notes/summer/</code>. All of the keys that
         *        roll up into a common prefix count as a single return when calculating the number of returns.
         *        </p>
         *        <note>
         *        <ul>
         *        <li>
         *        <p>
         *        <b>Directory buckets</b> - For directory buckets, only prefixes that end in a delimiter (
         *        <code>/</code>) are supported.
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
        Builder commonPrefixes(CommonPrefix... commonPrefixes);

        /**
         * <p>
         * All of the keys (up to 1,000) that share the same prefix are grouped together. When counting the total
         * numbers of returns by this API operation, this group of keys is considered as one item.
         * </p>
         * <p>
         * A response can contain <code>CommonPrefixes</code> only if you specify a delimiter.
         * </p>
         * <p>
         * <code>CommonPrefixes</code> contains all (if there are any) keys between <code>Prefix</code> and the next
         * occurrence of the string specified by a delimiter.
         * </p>
         * <p>
         * <code>CommonPrefixes</code> lists keys that act like subdirectories in the directory specified by
         * <code>Prefix</code>.
         * </p>
         * <p>
         * For example, if the prefix is <code>notes/</code> and the delimiter is a slash (<code>/</code>) as in
         * <code>notes/summer/july</code>, the common prefix is <code>notes/summer/</code>. All of the keys that roll up
         * into a common prefix count as a single return when calculating the number of returns.
         * </p>
         * <note>
         * <ul>
         * <li>
         * <p>
         * <b>Directory buckets</b> - For directory buckets, only prefixes that end in a delimiter (<code>/</code>) are
         * supported.
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
         * </note> This is a convenience method that creates an instance of the
         * {@link com.ibm.cos.v2.services.s3.model.CommonPrefix.Builder} avoiding the need to create one
         * manually via {@link com.ibm.cos.v2.services.s3.model.CommonPrefix#builder()}.
         *
         * <p>
         * When the {@link Consumer} completes,
         * {@link com.ibm.cos.v2.services.s3.model.CommonPrefix.Builder#build()} is called immediately and its
         * result is passed to {@link #commonPrefixes(List<CommonPrefix>)}.
         * 
         * @param commonPrefixes
         *        a consumer that will call methods on
         *        {@link com.ibm.cos.v2.services.s3.model.CommonPrefix.Builder}
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see #commonPrefixes(java.util.Collection<CommonPrefix>)
         */
        Builder commonPrefixes(Consumer<CommonPrefix.Builder>... commonPrefixes);

        /**
         * <p>
         * Encoding type used by Amazon S3 to encode object key names in the XML response.
         * </p>
         * <p>
         * If you specify the <code>encoding-type</code> request parameter, Amazon S3 includes this element in the
         * response, and returns encoded key name values in the following response elements:
         * </p>
         * <p>
         * <code>Delimiter, Prefix, Key,</code> and <code>StartAfter</code>.
         * </p>
         * 
         * @param encodingType
         *        Encoding type used by Amazon S3 to encode object key names in the XML response.</p>
         *        <p>
         *        If you specify the <code>encoding-type</code> request parameter, Amazon S3 includes this element in
         *        the response, and returns encoded key name values in the following response elements:
         *        </p>
         *        <p>
         *        <code>Delimiter, Prefix, Key,</code> and <code>StartAfter</code>.
         * @see EncodingType
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see EncodingType
         */
        Builder encodingType(String encodingType);

        /**
         * <p>
         * Encoding type used by Amazon S3 to encode object key names in the XML response.
         * </p>
         * <p>
         * If you specify the <code>encoding-type</code> request parameter, Amazon S3 includes this element in the
         * response, and returns encoded key name values in the following response elements:
         * </p>
         * <p>
         * <code>Delimiter, Prefix, Key,</code> and <code>StartAfter</code>.
         * </p>
         * 
         * @param encodingType
         *        Encoding type used by Amazon S3 to encode object key names in the XML response.</p>
         *        <p>
         *        If you specify the <code>encoding-type</code> request parameter, Amazon S3 includes this element in
         *        the response, and returns encoded key name values in the following response elements:
         *        </p>
         *        <p>
         *        <code>Delimiter, Prefix, Key,</code> and <code>StartAfter</code>.
         * @see EncodingType
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see EncodingType
         */
        Builder encodingType(EncodingType encodingType);

        /**
         * <p>
         * <code>KeyCount</code> is the number of keys returned with this request. <code>KeyCount</code> will always be
         * less than or equal to the <code>MaxKeys</code> field. For example, if you ask for 50 keys, your result will
         * include 50 keys or fewer.
         * </p>
         * 
         * @param keyCount
         *        <code>KeyCount</code> is the number of keys returned with this request. <code>KeyCount</code> will
         *        always be less than or equal to the <code>MaxKeys</code> field. For example, if you ask for 50 keys,
         *        your result will include 50 keys or fewer.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder keyCount(Integer keyCount);

        /**
         * <p>
         * If <code>ContinuationToken</code> was sent with the request, it is included in the response. You can use the
         * returned <code>ContinuationToken</code> for pagination of the list response. You can use this
         * <code>ContinuationToken</code> for pagination of the list results.
         * </p>
         * 
         * @param continuationToken
         *        If <code>ContinuationToken</code> was sent with the request, it is included in the response. You can
         *        use the returned <code>ContinuationToken</code> for pagination of the list response. You can use this
         *        <code>ContinuationToken</code> for pagination of the list results.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder continuationToken(String continuationToken);

        /**
         * <p>
         * <code>NextContinuationToken</code> is sent when <code>isTruncated</code> is true, which means there are more
         * keys in the bucket that can be listed. The next list requests to Amazon S3 can be continued with this
         * <code>NextContinuationToken</code>. <code>NextContinuationToken</code> is obfuscated and is not a real key
         * </p>
         * 
         * @param nextContinuationToken
         *        <code>NextContinuationToken</code> is sent when <code>isTruncated</code> is true, which means there
         *        are more keys in the bucket that can be listed. The next list requests to Amazon S3 can be continued
         *        with this <code>NextContinuationToken</code>. <code>NextContinuationToken</code> is obfuscated and is
         *        not a real key
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder nextContinuationToken(String nextContinuationToken);

        /**
         * <p>
         * If StartAfter was sent with the request, it is included in the response.
         * </p>
         * <note>
         * <p>
         * This functionality is not supported for directory buckets.
         * </p>
         * </note>
         * 
         * @param startAfter
         *        If StartAfter was sent with the request, it is included in the response.</p> <note>
         *        <p>
         *        This functionality is not supported for directory buckets.
         *        </p>
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder startAfter(String startAfter);

        /**
         * Sets the value of the RequestCharged property for this object.
         *
         * @param requestCharged
         *        The new value for the RequestCharged property for this object.
         * @see RequestCharged
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see RequestCharged
         */
        Builder requestCharged(String requestCharged);

        /**
         * Sets the value of the RequestCharged property for this object.
         *
         * @param requestCharged
         *        The new value for the RequestCharged property for this object.
         * @see RequestCharged
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see RequestCharged
         */
        Builder requestCharged(RequestCharged requestCharged);
    }

    static final class BuilderImpl extends S3Response.BuilderImpl implements Builder {
        private Boolean isTruncated;

        private List<S3Object> contents = DefaultSdkAutoConstructList.getInstance();

        private String name;

        private String prefix;

        private String delimiter;

        private Integer maxKeys;

        private List<CommonPrefix> commonPrefixes = DefaultSdkAutoConstructList.getInstance();

        private String encodingType;

        private Integer keyCount;

        private String continuationToken;

        private String nextContinuationToken;

        private String startAfter;

        private String requestCharged;

        private BuilderImpl() {
        }

        private BuilderImpl(ListObjectsV2Response model) {
            super(model);
            isTruncated(model.isTruncated);
            contents(model.contents);
            name(model.name);
            prefix(model.prefix);
            delimiter(model.delimiter);
            maxKeys(model.maxKeys);
            commonPrefixes(model.commonPrefixes);
            encodingType(model.encodingType);
            keyCount(model.keyCount);
            continuationToken(model.continuationToken);
            nextContinuationToken(model.nextContinuationToken);
            startAfter(model.startAfter);
            requestCharged(model.requestCharged);
        }

        public final Boolean getIsTruncated() {
            return isTruncated;
        }

        public final void setIsTruncated(Boolean isTruncated) {
            this.isTruncated = isTruncated;
        }

        @Override
        public final Builder isTruncated(Boolean isTruncated) {
            this.isTruncated = isTruncated;
            return this;
        }

        public final List<S3Object.Builder> getContents() {
            List<S3Object.Builder> result = ObjectListCopier.copyToBuilder(this.contents);
            if (result instanceof SdkAutoConstructList) {
                return null;
            }
            return result;
        }

        public final void setContents(Collection<S3Object.BuilderImpl> contents) {
            this.contents = ObjectListCopier.copyFromBuilder(contents);
        }

        @Override
        public final Builder contents(Collection<S3Object> contents) {
            this.contents = ObjectListCopier.copy(contents);
            return this;
        }

        @Override
        @SafeVarargs
        public final Builder contents(S3Object... contents) {
            contents(Arrays.asList(contents));
            return this;
        }

        @Override
        @SafeVarargs
        public final Builder contents(Consumer<S3Object.Builder>... contents) {
            contents(Stream.of(contents).map(c -> S3Object.builder().applyMutation(c).build()).collect(Collectors.toList()));
            return this;
        }

        public final String getName() {
            return name;
        }

        public final void setName(String name) {
            this.name = name;
        }

        @Override
        public final Builder name(String name) {
            this.name = name;
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

        public final List<CommonPrefix.Builder> getCommonPrefixes() {
            List<CommonPrefix.Builder> result = CommonPrefixListCopier.copyToBuilder(this.commonPrefixes);
            if (result instanceof SdkAutoConstructList) {
                return null;
            }
            return result;
        }

        public final void setCommonPrefixes(Collection<CommonPrefix.BuilderImpl> commonPrefixes) {
            this.commonPrefixes = CommonPrefixListCopier.copyFromBuilder(commonPrefixes);
        }

        @Override
        public final Builder commonPrefixes(Collection<CommonPrefix> commonPrefixes) {
            this.commonPrefixes = CommonPrefixListCopier.copy(commonPrefixes);
            return this;
        }

        @Override
        @SafeVarargs
        public final Builder commonPrefixes(CommonPrefix... commonPrefixes) {
            commonPrefixes(Arrays.asList(commonPrefixes));
            return this;
        }

        @Override
        @SafeVarargs
        public final Builder commonPrefixes(Consumer<CommonPrefix.Builder>... commonPrefixes) {
            commonPrefixes(Stream.of(commonPrefixes).map(c -> CommonPrefix.builder().applyMutation(c).build())
                    .collect(Collectors.toList()));
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

        public final Integer getKeyCount() {
            return keyCount;
        }

        public final void setKeyCount(Integer keyCount) {
            this.keyCount = keyCount;
        }

        @Override
        public final Builder keyCount(Integer keyCount) {
            this.keyCount = keyCount;
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

        public final String getNextContinuationToken() {
            return nextContinuationToken;
        }

        public final void setNextContinuationToken(String nextContinuationToken) {
            this.nextContinuationToken = nextContinuationToken;
        }

        @Override
        public final Builder nextContinuationToken(String nextContinuationToken) {
            this.nextContinuationToken = nextContinuationToken;
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

        public final String getRequestCharged() {
            return requestCharged;
        }

        public final void setRequestCharged(String requestCharged) {
            this.requestCharged = requestCharged;
        }

        @Override
        public final Builder requestCharged(String requestCharged) {
            this.requestCharged = requestCharged;
            return this;
        }

        @Override
        public final Builder requestCharged(RequestCharged requestCharged) {
            this.requestCharged(requestCharged == null ? null : requestCharged.toString());
            return this;
        }

        @Override
        public ListObjectsV2Response build() {
            return new ListObjectsV2Response(this);
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
