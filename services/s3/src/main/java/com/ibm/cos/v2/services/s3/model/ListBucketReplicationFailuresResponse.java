/*
 * Copyright 2025 IBM Corp. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */

package com.ibm.cos.v2.services.s3.model;

import com.ibm.cos.v2.annotations.Mutable;
import com.ibm.cos.v2.annotations.NotThreadSafe;
import com.ibm.cos.v2.core.SdkField;
import com.ibm.cos.v2.core.SdkPojo;
import com.ibm.cos.v2.core.protocol.MarshallLocation;
import com.ibm.cos.v2.core.protocol.MarshallingType;
import com.ibm.cos.v2.core.traits.ListTrait;
import com.ibm.cos.v2.core.traits.LocationTrait;
import com.ibm.cos.v2.core.traits.RequiredTrait;
import com.ibm.cos.v2.utils.ToString;
import com.ibm.cos.v2.utils.builder.CopyableBuilder;
import com.ibm.cos.v2.utils.builder.ToCopyableBuilder;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.function.Function;

public class ListBucketReplicationFailuresResponse extends S3Response implements
       ToCopyableBuilder<ListBucketReplicationFailuresResponse.Builder, ListBucketReplicationFailuresResponse> {

    private static final SdkField<String> BUCKET_FIELD = SdkField
        .<String>builder(MarshallingType.STRING)
        .memberName("Bucket")
        .getter(getter(ListBucketReplicationFailuresResponse::bucket))
        .setter(setter(ListBucketReplicationFailuresResponse.Builder::bucket))
        .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("Name")
                             .unmarshallLocationName("Name").build(), RequiredTrait.create()).build();

    private static final SdkField<String> CONTINUATION_TOKEN_FIELD = SdkField
        .<String>builder(MarshallingType.STRING)
        .memberName("ContinuationToken")
        .getter(getter(ListBucketReplicationFailuresResponse::continuationToken))
        .setter(setter(ListBucketReplicationFailuresResponse.Builder::continuationToken))
        .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("continuation-token")
                             .unmarshallLocationName("continuation-token").build()).build();

    private static final SdkField<Integer> MAX_KEYS_FIELD = SdkField
        .<Integer>builder(MarshallingType.INTEGER)
        .memberName("MaxKeys")
        .getter(getter(ListBucketReplicationFailuresResponse::maxKeys))
        .setter(setter(ListBucketReplicationFailuresResponse.Builder::maxKeys))
        .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("MaxKeys")
                             .unmarshallLocationName("MaxKeys").build()).build();

    private static final SdkField<String> FIRST_SYNC_ATTEMPTED_BEFORE_FIELD = SdkField
        .<String>builder(MarshallingType.STRING)
        .memberName("FirstSyncAttemptedBefore")
        .getter(getter(ListBucketReplicationFailuresResponse::firstSyncAttemptedBefore))
        .setter(setter(ListBucketReplicationFailuresResponse.Builder::firstSyncAttemptedBefore))
        .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("FirstSyncAttemptedBefore")
                             .unmarshallLocationName("FirstSyncAttemptedBefore").build()).build();

    private static final SdkField<String> ENCODING_TYPE_FIELD = SdkField
        .<String>builder(MarshallingType.STRING)
        .memberName("EncodingType")
        .getter(getter(ListBucketReplicationFailuresResponse::encodingType))
        .setter(setter(ListBucketReplicationFailuresResponse.Builder::encodingType))
        .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("EncodingType")
                             .unmarshallLocationName("EncodingType").build()).build();

    private static final SdkField<Boolean> IS_TRUNCATED_FIELD = SdkField
        .<Boolean>builder(MarshallingType.BOOLEAN)
        .memberName("isTruncated")
        .getter(getter(ListBucketReplicationFailuresResponse::isTruncated))
        .setter(setter(ListBucketReplicationFailuresResponse.Builder::isTruncated))
        .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("IsTruncated")
                             .unmarshallLocationName("IsTruncated").build()).build();


    private static final SdkField<Integer> KEY_COUNT_FIELD = SdkField
        .<Integer>builder(MarshallingType.INTEGER)
        .memberName("KeyCount")
        .getter(getter(ListBucketReplicationFailuresResponse::keyCount))
        .setter(setter(ListBucketReplicationFailuresResponse.Builder::keyCount))
        .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("KeyCount")
                             .unmarshallLocationName("KeyCount").build(), RequiredTrait.create()).build();


    private static final SdkField<String> NEXT_CONTINUATION_TOKEN_FIELD = SdkField
        .<String>builder(MarshallingType.STRING)
        .memberName("NextContinuationToken")
        .getter(getter(ListBucketReplicationFailuresResponse::nextContinuationToken))
        .setter(setter(ListBucketReplicationFailuresResponse.Builder::nextContinuationToken))
        .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("NextContinuationToken")
                             .unmarshallLocationName("NextContinuationToken").build()).build();

    private static final SdkField<List<ContentList>> CONTENT_LIST_FIELD = SdkField
        .<List<ContentList>>builder(MarshallingType.LIST)
        .memberName("Contents")
        .getter(getter(ListBucketReplicationFailuresResponse::contentList))
        .setter(setter(Builder::contentList))
        .constructor(ContentList::builder)
        .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("Contents").build(),
            ListTrait.builder().memberLocationName(null).memberFieldInfo(SdkField.<ContentList> builder(MarshallingType.SDK_POJO)
                                .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD)
                                .locationName("Contents").build()).build()).build(), RequiredTrait.create()).build();

    private static final List<SdkField<?>> SDK_FIELDS = Collections.unmodifiableList(Arrays.asList(BUCKET_FIELD,
                                                         CONTINUATION_TOKEN_FIELD, MAX_KEYS_FIELD,
                                                         FIRST_SYNC_ATTEMPTED_BEFORE_FIELD, ENCODING_TYPE_FIELD,
                                                         IS_TRUNCATED_FIELD,KEY_COUNT_FIELD,NEXT_CONTINUATION_TOKEN_FIELD,
                                                         CONTENT_LIST_FIELD));

    /**
     * The name of Amazon S3 bucket to which the replication configuration is
     * set.
     */
    private String bucket;

    /**
     * Obfuscated string token for pagination. This is returned on incomplete listing responses.
     */
    private String continuationToken;

    /**
     * Maximum number of entries to return (default 1000).
     */
    private Integer maxKeys;

    /**
     * Epoch ms time from which to start the listing (inclusive if time exactly matches an entry).
     * The failures are sorted by the time at which the syncs were originally triggered on the source bucket.
     */
    private String firstSyncAttemptedBefore;

    /**
     * Encoding type to use for Key. Only valid value is url.
     */
    private String encodingType;

    /**
     * Whether or not the results are truncated.
     */
    private boolean isTruncated;

    /**
     * <p><code>KeyCount</code> is the number of keys returned with this request. <code>KeyCount</code> will always be less than or equal to the <code>MaxKeys</code> field.
     * For example, if you ask for 50 keys, your result will include 50 keys or fewer.</p>
     */
    private Integer keyCount;

    /**
     * NextContinuationToken is sent when isTruncated is true, Next continuation token.
     * Present if this result was truncated
     */
    private String nextContinuationToken;

    /**
     * Metadata about each object returned.
     */
    private List<ContentList> contentList;

    private ListBucketReplicationFailuresResponse(BuilderImpl builder) {
        super(builder);
        this.bucket = builder.bucket;
        this.continuationToken = builder.continuationToken;
        this.maxKeys = builder.maxKeys;
        this.firstSyncAttemptedBefore = builder.firstSyncAttemptedBefore;
        this.encodingType = builder.encodingType;
        this.isTruncated = builder.isTruncated;
        this.keyCount = builder.keyCount;
        this.nextContinuationToken = builder.nextContinuationToken;
        this.contentList = builder.contentList;
    }

    private static <T> Function<Object, T> getter(Function<ListBucketReplicationFailuresResponse, T> g) {
        return obj -> g.apply((ListBucketReplicationFailuresResponse) obj);
    }

    private static <T> BiConsumer<Object, T> setter(BiConsumer<ListBucketReplicationFailuresResponse.Builder, T> s) {
        return (obj, val) -> s.accept((ListBucketReplicationFailuresResponse.Builder) obj, val);
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
        hashCode = 31 * hashCode + Objects.hashCode(continuationToken());
        hashCode = 31 * hashCode + Objects.hashCode(maxKeys());
        hashCode = 31 * hashCode + Objects.hashCode(firstSyncAttemptedBefore());
        hashCode = 31 * hashCode + Objects.hashCode(encodingType());
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
        if (!(obj instanceof ListBucketReplicationFailuresRequest)) {
            return false;
        }
        ListBucketReplicationFailuresRequest other = (ListBucketReplicationFailuresRequest) obj;
        return Objects.equals(bucket(), other.bucket()) && Objects.equals(continuationToken(), other.continuationToken())
               && Objects.equals(maxKeys(), other.maxKeys()) && Objects.equals(firstSyncAttemptedBefore(), other.firstSyncAttemptedBefore())
               && Objects.equals(encodingType(), other.encodingType());
    }

    /**
     * Returns a string representation of this object. This is useful for testing and debugging. Sensitive data will be
     * redacted from this string using a placeholder value.
     */
    @Override
    public final String toString() {
        return ToString.builder("ListBucketReplicationFailuresRequest")
                       .add("Bucket",bucket())
                       .add("ContinuationToken",continuationToken())
                       .add("MaxKeys",maxKeys())
                       .add("FirstSyncAttemptedBefore",firstSyncAttemptedBefore())
                       .add("EncodingType",encodingType())
                       .build();

    }

    public final <T> Optional<T> getValueForField(String fieldName, Class<T> clazz) {
        switch (fieldName) {
            case "Bucket":
                return Optional.ofNullable(clazz.cast(bucket()));
            case "ContinuationToken":
                return Optional.ofNullable(clazz.cast(continuationToken()));
            case "MaxKeys":
                return Optional.ofNullable(clazz.cast(maxKeys()));
            case "FirstSyncAttemptedBefore":
                return Optional.ofNullable(clazz.cast(firstSyncAttemptedBefore()));
            case "EncodingType":
                return Optional.ofNullable(clazz.cast(encodingType()));
            default:
                return Optional.empty();
        }
    }

    @Override
    public List<SdkField<?>> sdkFields() {
        return SDK_FIELDS;
    }


    /**
     * @return The bucket name for which replication attempt has been configured.
     */
    public String bucket() {
        return bucket;
    }

    /**
     * Gets the optional continuation token.  Continuation token allows a list to be
     * continued from a specific point. ContinuationToken is provided in truncated list results.
     *
     * @return The optional continuation token associated with this request.
     */
    public String continuationToken() {
        return continuationToken;
    }

    /**
     * Gets the optional <code>maxKeys</code> parameter indicating the maximum number of keys to
     * include in the response. COS S3 might return fewer keys than specified, but will
     * never return more.
     *
     * @return The optional parameter indicating the maximum number of keys to
     *         include in the response.
     */
    public Integer maxKeys() {
        return maxKeys;
    }

    /**
     * Returns optional parameter indicating where you want Amazon S3 to start the object
     * listing from.  This can be any key in the bucket.
     *
     * @return the optional firstSyncAttemptedBefore parameter
     */
    public String firstSyncAttemptedBefore() {
        return firstSyncAttemptedBefore;
    }

    /**
     * Gets the optional <code>encodingType</code> parameter indicating the
     * encoding method to be applied on the response.
     *
     * @return The encoding method to be applied on the response.
     */
    public String encodingType() {
        return encodingType;
    }

    public boolean isTruncated() {
        return isTruncated;
    }

    public Integer keyCount() {
        return keyCount;
    }

    public String nextContinuationToken() {
        return nextContinuationToken;
    }

    public List<ContentList> contentList() {
        return contentList;
    }

    @Mutable
    @NotThreadSafe
    public interface Builder extends S3Response.Builder, SdkPojo,
                                     CopyableBuilder<ListBucketReplicationFailuresResponse.Builder,ListBucketReplicationFailuresResponse> {

        /**
         * Sets the name of Amazon S3 bucket for replication configuration.
         *
         * @param bucketName
         *            The name of Amazon S3 bucket to which the replication
         *            configuration is set.
         * @return The updated {@link ListBucketReplicationFailuresResponse}
         *         object.
         */
         Builder bucket(String bucketName);

        /**
         * Sets the optional continuation token.  Continuation token allows a list to be
         * continued from a specific point. ContinuationToken is provided in truncated list results.
         *
         * @param continuationToken
         *                     The optional continuation token to associate with this request.
         * @return The updated {@link ListBucketReplicationFailuresResponse}
         *         object.
         */
        Builder continuationToken(String continuationToken);

        /**
         * Sets the optional <code>maxKeys</code> parameter indicating the maximum number of keys to
         * include in the response.
         *
         * @param maxKeys
         *            The optional parameter indicating the maximum number of keys
         *            to include in the response.
         * @return The updated {@link ListBucketReplicationFailuresResponse}
         *         object.
         */
        Builder maxKeys(Integer maxKeys);

        /**
         * Sets the optional parameter indicating where you want Amazon S3 to start the object
         * listing from.  This can be any key in the bucket.
         *
         * @param firstSyncAttemptedBefore
         *                The optional firstSyncAttemptedBefore parameter.  This can be any key in the bucket.
         * @return The updated {@link ListBucketReplicationFailuresResponse}
         *         object.
         */
        Builder firstSyncAttemptedBefore(String firstSyncAttemptedBefore);

        /**
         * Sets the optional <code>encodingType</code> parameter indicating the
         * encoding method to be applied on the response. An object key can contain
         * any Unicode character; however, XML 1.0 parser cannot parse some
         * characters, such as characters with an ASCII value from 0 to 10. For
         * characters that are not supported in XML 1.0, you can add this parameter
         * to request that Amazon S3 encode the keys in the response.
         *
         * @param encodingType
         *            The encoding method to be applied on the response. Valid
         *            values: null (not encoded) or "url".
         * @return The updated {@link ListBucketReplicationFailuresResponse}
         *         object.
         */
        Builder encodingType(String encodingType);

        /**
         * Sets the optional <code>isTruncated</code> parameter indicating
         * whether or not the results are truncated.
         *
         * @param isTruncated
         *            indicates whether or not the results are truncated.
         * @return The updated {@link ListBucketReplicationFailuresResponse}
         *         object.
         */
        Builder isTruncated(boolean isTruncated);

        /**
         * KeyCount is the number of keys returned with this request.
         * It will always be less than or equal to the MaxKeys field.
         * For example, if you ask for 50 keys, your result will include 50 keys or fewer.
         *
         * @return The optional parameter indicating the maximum number of keys to
         *         include in the response.
         */
        Builder keyCount(Integer keyCount);

        /**
         * Sets the optional <code>next continuation token</code>
         *
         * @param nextContinuationToken
         *            next continuation token.
         * @return The updated {@link ListBucketReplicationFailuresResponse}
         *         object.
         */
        Builder nextContinuationToken(String nextContinuationToken);

        /**
         * Sets the optional <code> contentList </code>
         *
         * @param contentList
         *            Metadata about each object returned.
         * @return The updated {@link ListBucketReplicationFailuresResponse}
         *         object.
         */
        Builder contentList(List<ContentList> contentList);

    }

    static private final class BuilderImpl extends S3Response.BuilderImpl
        implements ListBucketReplicationFailuresResponse.Builder {

        private String bucket;

        private String continuationToken;

        private Integer maxKeys;

        private String firstSyncAttemptedBefore;

        private String encodingType;

        private boolean isTruncated;

        private Integer keyCount;

        private String nextContinuationToken;

        private List<ContentList> contentList;


        private BuilderImpl(){}

        private BuilderImpl(ListBucketReplicationFailuresResponse model) {
            super(model);
            bucket(model.bucket);
        }

        public String getBucket() { return  bucket;}

        public void setBucket(String bucket) { this.bucket = bucket;}

        @Override
        public Builder bucket(String bucketName){
            this.bucket = bucketName;
            return this;
        }

        public void setContinuationToken(String continuationToken) {
            this.continuationToken = continuationToken;
        }

        public String getContinuationToken() { return this.continuationToken;}

        @Override
        public Builder continuationToken(String continuationToken) {
            this.continuationToken = continuationToken;
            return this;
        }

        public void setMaxKeys(Integer maxKeys){ this.maxKeys = maxKeys;}

        public Integer getMaxKeys() { return this.maxKeys;}

        @Override
        public Builder maxKeys(Integer maxKeys) {
            this.maxKeys = maxKeys;
            return this;
        }

        public void setFirstSyncAttemptedBefore(String firstSyncAttemptedBefore) {
            this.firstSyncAttemptedBefore = firstSyncAttemptedBefore;
        }

        public String getFirstSyncAttemptedBefore() { return this.firstSyncAttemptedBefore;}

        @Override
        public Builder firstSyncAttemptedBefore(String firstSyncAttemptedBefore) {
            this.firstSyncAttemptedBefore = firstSyncAttemptedBefore;
            return this;
        }

        public void setEncodingType(String encodingType) {
            this.encodingType = encodingType;
        }

        public String getEncodingType() { return this.encodingType;}

        @Override
        public Builder encodingType(String encodingType) {
            this.encodingType = encodingType;
            return this;
        }

        public boolean isTruncated() {
            return isTruncated;
        }

        public void setTruncated(boolean truncated) {
            isTruncated = truncated;
        }

        @Override
        public Builder isTruncated(boolean isTruncated) {
            this.isTruncated = isTruncated;
            return this;
        }

        public Integer getKeyCount() {
            return keyCount;
        }

        public void setKeyCount(Integer keyCount) {
            this.keyCount = keyCount;
        }

        @Override
        public Builder keyCount(Integer keyCount) {
            this.keyCount = keyCount;
            return this;
        }

        public String getNextContinuationToken() {
            return nextContinuationToken;
        }

        public void setNextContinuationToken(String nextContinuationToken) {
            this.nextContinuationToken = nextContinuationToken;
        }

        @Override
        public Builder nextContinuationToken(String nextContinuationToken) {
            this.nextContinuationToken = nextContinuationToken;
            return this;
        }

        public List<ContentList> getContentList() {
            return contentList;
        }

        public void setContentList(List<ContentList> contentList) {
            this.contentList = contentList;
        }

        @Override
        public Builder contentList(List<ContentList> contentList) {
            this.contentList = contentList;
            return this;
        }


        @Override
        public List<SdkField<?>> sdkFields() {
            return SDK_FIELDS;
        }

        @Override
        public ListBucketReplicationFailuresResponse build() {
            return new ListBucketReplicationFailuresResponse(this);
        }
    }


}
