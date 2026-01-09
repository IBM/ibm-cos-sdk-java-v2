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

import java.io.Serializable;
import java.time.Instant;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.function.Function;
import com.ibm.cos.v2.annotations.Generated;
import com.ibm.cos.v2.annotations.Mutable;
import com.ibm.cos.v2.annotations.NotThreadSafe;
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
 * <p>
 * Object Identifier is unique value to identify objects.
 * </p>
 */
@Generated("com.ibm.cos.v2:codegen")
public final class ObjectIdentifier implements SdkPojo, Serializable,
        ToCopyableBuilder<ObjectIdentifier.Builder, ObjectIdentifier> {
    private static final SdkField<String> KEY_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("Key")
            .getter(getter(ObjectIdentifier::key))
            .setter(setter(Builder::key))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("Key").unmarshallLocationName("Key")
                    .build(), RequiredTrait.create()).build();

    private static final SdkField<String> VERSION_ID_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("VersionId")
            .getter(getter(ObjectIdentifier::versionId))
            .setter(setter(Builder::versionId))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("VersionId")
                    .unmarshallLocationName("VersionId").build()).build();

    private static final SdkField<String> E_TAG_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("ETag")
            .getter(getter(ObjectIdentifier::eTag))
            .setter(setter(Builder::eTag))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("ETag")
                    .unmarshallLocationName("ETag").build()).build();

    private static final SdkField<Instant> LAST_MODIFIED_TIME_FIELD = SdkField
            .<Instant> builder(MarshallingType.INSTANT)
            .memberName("LastModifiedTime")
            .getter(getter(ObjectIdentifier::lastModifiedTime))
            .setter(setter(Builder::lastModifiedTime))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("LastModifiedTime")
                    .unmarshallLocationName("LastModifiedTime").build(),
                    TimestampFormatTrait.create(TimestampFormatTrait.Format.RFC_822)).build();

    private static final SdkField<Long> SIZE_FIELD = SdkField
            .<Long> builder(MarshallingType.LONG)
            .memberName("Size")
            .getter(getter(ObjectIdentifier::size))
            .setter(setter(Builder::size))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("Size")
                    .unmarshallLocationName("Size").build()).build();

    private static final List<SdkField<?>> SDK_FIELDS = Collections.unmodifiableList(Arrays.asList(KEY_FIELD, VERSION_ID_FIELD,
            E_TAG_FIELD, LAST_MODIFIED_TIME_FIELD, SIZE_FIELD));

    private static final Map<String, SdkField<?>> SDK_NAME_TO_FIELD = memberNameToFieldInitializer();

    private static final long serialVersionUID = 1L;

    private final String key;

    private final String versionId;

    private final String eTag;

    private final Instant lastModifiedTime;

    private final Long size;

    private ObjectIdentifier(BuilderImpl builder) {
        this.key = builder.key;
        this.versionId = builder.versionId;
        this.eTag = builder.eTag;
        this.lastModifiedTime = builder.lastModifiedTime;
        this.size = builder.size;
    }

    /**
     * <p>
     * Key name of the object.
     * </p>
     * <important>
     * <p>
     * Replacement must be made for object keys containing special characters (such as carriage returns) when using XML
     * requests. For more information, see <a href=
     * "https://docs.aws.amazon.com/AmazonS3/latest/userguide/object-keys.html#object-key-xml-related-constraints"> XML
     * related object key constraints</a>.
     * </p>
     * </important>
     * 
     * @return Key name of the object.</p> <important>
     *         <p>
     *         Replacement must be made for object keys containing special characters (such as carriage returns) when
     *         using XML requests. For more information, see <a href=
     *         "https://docs.aws.amazon.com/AmazonS3/latest/userguide/object-keys.html#object-key-xml-related-constraints"
     *         > XML related object key constraints</a>.
     *         </p>
     */
    public final String key() {
        return key;
    }

    /**
     * <p>
     * Version ID for the specific version of the object to delete.
     * </p>
     * <note>
     * <p>
     * This functionality is not supported for directory buckets.
     * </p>
     * </note>
     * 
     * @return Version ID for the specific version of the object to delete.</p> <note>
     *         <p>
     *         This functionality is not supported for directory buckets.
     *         </p>
     */
    public final String versionId() {
        return versionId;
    }

    /**
     * <p>
     * An entity tag (ETag) is an identifier assigned by a web server to a specific version of a resource found at a
     * URL. This header field makes the request method conditional on <code>ETags</code>.
     * </p>
     * <note>
     * <p>
     * Entity tags (ETags) for S3 Express One Zone are random alphanumeric strings unique to the object.
     * </p>
     * </note>
     * 
     * @return An entity tag (ETag) is an identifier assigned by a web server to a specific version of a resource found
     *         at a URL. This header field makes the request method conditional on <code>ETags</code>. </p> <note>
     *         <p>
     *         Entity tags (ETags) for S3 Express One Zone are random alphanumeric strings unique to the object.
     *         </p>
     */
    public final String eTag() {
        return eTag;
    }

    /**
     * <p>
     * If present, the objects are deleted only if its modification times matches the provided <code>Timestamp</code>.
     * </p>
     * <note>
     * <p>
     * This functionality is only supported for directory buckets.
     * </p>
     * </note>
     * 
     * @return If present, the objects are deleted only if its modification times matches the provided
     *         <code>Timestamp</code>. </p> <note>
     *         <p>
     *         This functionality is only supported for directory buckets.
     *         </p>
     */
    public final Instant lastModifiedTime() {
        return lastModifiedTime;
    }

    /**
     * <p>
     * If present, the objects are deleted only if its size matches the provided size in bytes.
     * </p>
     * <note>
     * <p>
     * This functionality is only supported for directory buckets.
     * </p>
     * </note>
     * 
     * @return If present, the objects are deleted only if its size matches the provided size in bytes. </p> <note>
     *         <p>
     *         This functionality is only supported for directory buckets.
     *         </p>
     */
    public final Long size() {
        return size;
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
        hashCode = 31 * hashCode + Objects.hashCode(key());
        hashCode = 31 * hashCode + Objects.hashCode(versionId());
        hashCode = 31 * hashCode + Objects.hashCode(eTag());
        hashCode = 31 * hashCode + Objects.hashCode(lastModifiedTime());
        hashCode = 31 * hashCode + Objects.hashCode(size());
        return hashCode;
    }

    @Override
    public final boolean equals(Object obj) {
        return equalsBySdkFields(obj);
    }

    @Override
    public final boolean equalsBySdkFields(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof ObjectIdentifier)) {
            return false;
        }
        ObjectIdentifier other = (ObjectIdentifier) obj;
        return Objects.equals(key(), other.key()) && Objects.equals(versionId(), other.versionId())
                && Objects.equals(eTag(), other.eTag()) && Objects.equals(lastModifiedTime(), other.lastModifiedTime())
                && Objects.equals(size(), other.size());
    }

    /**
     * Returns a string representation of this object. This is useful for testing and debugging. Sensitive data will be
     * redacted from this string using a placeholder value.
     */
    @Override
    public final String toString() {
        return ToString.builder("ObjectIdentifier").add("Key", key()).add("VersionId", versionId()).add("ETag", eTag())
                .add("LastModifiedTime", lastModifiedTime()).add("Size", size()).build();
    }

    public final <T> Optional<T> getValueForField(String fieldName, Class<T> clazz) {
        switch (fieldName) {
        case "Key":
            return Optional.ofNullable(clazz.cast(key()));
        case "VersionId":
            return Optional.ofNullable(clazz.cast(versionId()));
        case "ETag":
            return Optional.ofNullable(clazz.cast(eTag()));
        case "LastModifiedTime":
            return Optional.ofNullable(clazz.cast(lastModifiedTime()));
        case "Size":
            return Optional.ofNullable(clazz.cast(size()));
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
        map.put("Key", KEY_FIELD);
        map.put("VersionId", VERSION_ID_FIELD);
        map.put("ETag", E_TAG_FIELD);
        map.put("LastModifiedTime", LAST_MODIFIED_TIME_FIELD);
        map.put("Size", SIZE_FIELD);
        return Collections.unmodifiableMap(map);
    }

    private static <T> Function<Object, T> getter(Function<ObjectIdentifier, T> g) {
        return obj -> g.apply((ObjectIdentifier) obj);
    }

    private static <T> BiConsumer<Object, T> setter(BiConsumer<Builder, T> s) {
        return (obj, val) -> s.accept((Builder) obj, val);
    }

    @Mutable
    @NotThreadSafe
    public interface Builder extends SdkPojo, CopyableBuilder<Builder, ObjectIdentifier> {
        /**
         * <p>
         * Key name of the object.
         * </p>
         * <important>
         * <p>
         * Replacement must be made for object keys containing special characters (such as carriage returns) when using
         * XML requests. For more information, see <a href=
         * "https://docs.aws.amazon.com/AmazonS3/latest/userguide/object-keys.html#object-key-xml-related-constraints">
         * XML related object key constraints</a>.
         * </p>
         * </important>
         * 
         * @param key
         *        Key name of the object.</p> <important>
         *        <p>
         *        Replacement must be made for object keys containing special characters (such as carriage returns) when
         *        using XML requests. For more information, see <a href=
         *        "https://docs.aws.amazon.com/AmazonS3/latest/userguide/object-keys.html#object-key-xml-related-constraints"
         *        > XML related object key constraints</a>.
         *        </p>
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder key(String key);

        /**
         * <p>
         * Version ID for the specific version of the object to delete.
         * </p>
         * <note>
         * <p>
         * This functionality is not supported for directory buckets.
         * </p>
         * </note>
         * 
         * @param versionId
         *        Version ID for the specific version of the object to delete.</p> <note>
         *        <p>
         *        This functionality is not supported for directory buckets.
         *        </p>
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder versionId(String versionId);

        /**
         * <p>
         * An entity tag (ETag) is an identifier assigned by a web server to a specific version of a resource found at a
         * URL. This header field makes the request method conditional on <code>ETags</code>.
         * </p>
         * <note>
         * <p>
         * Entity tags (ETags) for S3 Express One Zone are random alphanumeric strings unique to the object.
         * </p>
         * </note>
         * 
         * @param eTag
         *        An entity tag (ETag) is an identifier assigned by a web server to a specific version of a resource
         *        found at a URL. This header field makes the request method conditional on <code>ETags</code>. </p>
         *        <note>
         *        <p>
         *        Entity tags (ETags) for S3 Express One Zone are random alphanumeric strings unique to the object.
         *        </p>
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder eTag(String eTag);

        /**
         * <p>
         * If present, the objects are deleted only if its modification times matches the provided
         * <code>Timestamp</code>.
         * </p>
         * <note>
         * <p>
         * This functionality is only supported for directory buckets.
         * </p>
         * </note>
         * 
         * @param lastModifiedTime
         *        If present, the objects are deleted only if its modification times matches the provided
         *        <code>Timestamp</code>. </p> <note>
         *        <p>
         *        This functionality is only supported for directory buckets.
         *        </p>
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder lastModifiedTime(Instant lastModifiedTime);

        /**
         * <p>
         * If present, the objects are deleted only if its size matches the provided size in bytes.
         * </p>
         * <note>
         * <p>
         * This functionality is only supported for directory buckets.
         * </p>
         * </note>
         * 
         * @param size
         *        If present, the objects are deleted only if its size matches the provided size in bytes. </p> <note>
         *        <p>
         *        This functionality is only supported for directory buckets.
         *        </p>
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder size(Long size);
    }

    static final class BuilderImpl implements Builder {
        private String key;

        private String versionId;

        private String eTag;

        private Instant lastModifiedTime;

        private Long size;

        private BuilderImpl() {
        }

        private BuilderImpl(ObjectIdentifier model) {
            key(model.key);
            versionId(model.versionId);
            eTag(model.eTag);
            lastModifiedTime(model.lastModifiedTime);
            size(model.size);
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

        public final String getETag() {
            return eTag;
        }

        public final void setETag(String eTag) {
            this.eTag = eTag;
        }

        @Override
        public final Builder eTag(String eTag) {
            this.eTag = eTag;
            return this;
        }

        public final Instant getLastModifiedTime() {
            return lastModifiedTime;
        }

        public final void setLastModifiedTime(Instant lastModifiedTime) {
            this.lastModifiedTime = lastModifiedTime;
        }

        @Override
        public final Builder lastModifiedTime(Instant lastModifiedTime) {
            this.lastModifiedTime = lastModifiedTime;
            return this;
        }

        public final Long getSize() {
            return size;
        }

        public final void setSize(Long size) {
            this.size = size;
        }

        @Override
        public final Builder size(Long size) {
            this.size = size;
            return this;
        }

        @Override
        public ObjectIdentifier build() {
            return new ObjectIdentifier(this);
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
