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
 * <p>
 * An object consists of data and its descriptive metadata.
 * </p>
 */
@Generated("com.ibm.cos.v2:codegen")
public final class S3Object implements SdkPojo, Serializable, ToCopyableBuilder<S3Object.Builder, S3Object> {
    private static final SdkField<String> KEY_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("Key")
            .getter(getter(S3Object::key))
            .setter(setter(Builder::key))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("Key").unmarshallLocationName("Key")
                    .build()).build();

    private static final SdkField<Instant> LAST_MODIFIED_FIELD = SdkField
            .<Instant> builder(MarshallingType.INSTANT)
            .memberName("LastModified")
            .getter(getter(S3Object::lastModified))
            .setter(setter(Builder::lastModified))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("LastModified")
                    .unmarshallLocationName("LastModified").build()).build();

    private static final SdkField<String> E_TAG_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("ETag")
            .getter(getter(S3Object::eTag))
            .setter(setter(Builder::eTag))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("ETag")
                    .unmarshallLocationName("ETag").build()).build();

    private static final SdkField<List<String>> CHECKSUM_ALGORITHM_FIELD = SdkField
            .<List<String>> builder(MarshallingType.LIST)
            .memberName("ChecksumAlgorithm")
            .getter(getter(S3Object::checksumAlgorithmAsStrings))
            .setter(setter(Builder::checksumAlgorithmWithStrings))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("ChecksumAlgorithm")
                    .unmarshallLocationName("ChecksumAlgorithm").build(),
                    ListTrait
                            .builder()
                            .memberLocationName(null)
                            .memberFieldInfo(
                                    SdkField.<String> builder(MarshallingType.STRING)
                                            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD)
                                                    .locationName("member").unmarshallLocationName("member").build()).build())
                            .isFlattened(true).build()).build();

    private static final SdkField<String> CHECKSUM_TYPE_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("ChecksumType")
            .getter(getter(S3Object::checksumTypeAsString))
            .setter(setter(Builder::checksumType))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("ChecksumType")
                    .unmarshallLocationName("ChecksumType").build()).build();

    private static final SdkField<Long> SIZE_FIELD = SdkField
            .<Long> builder(MarshallingType.LONG)
            .memberName("Size")
            .getter(getter(S3Object::size))
            .setter(setter(Builder::size))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("Size")
                    .unmarshallLocationName("Size").build()).build();

    private static final SdkField<String> STORAGE_CLASS_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("StorageClass")
            .getter(getter(S3Object::storageClassAsString))
            .setter(setter(Builder::storageClass))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("StorageClass")
                    .unmarshallLocationName("StorageClass").build()).build();

    private static final SdkField<Owner> OWNER_FIELD = SdkField
            .<Owner> builder(MarshallingType.SDK_POJO)
            .memberName("Owner")
            .getter(getter(S3Object::owner))
            .setter(setter(Builder::owner))
            .constructor(Owner::builder)
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("Owner")
                    .unmarshallLocationName("Owner").build()).build();

    private static final SdkField<RestoreStatus> RESTORE_STATUS_FIELD = SdkField
            .<RestoreStatus> builder(MarshallingType.SDK_POJO)
            .memberName("RestoreStatus")
            .getter(getter(S3Object::restoreStatus))
            .setter(setter(Builder::restoreStatus))
            .constructor(RestoreStatus::builder)
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("RestoreStatus")
                    .unmarshallLocationName("RestoreStatus").build()).build();

    private static final List<SdkField<?>> SDK_FIELDS = Collections.unmodifiableList(Arrays.asList(KEY_FIELD,
            LAST_MODIFIED_FIELD, E_TAG_FIELD, CHECKSUM_ALGORITHM_FIELD, CHECKSUM_TYPE_FIELD, SIZE_FIELD, STORAGE_CLASS_FIELD,
            OWNER_FIELD, RESTORE_STATUS_FIELD));

    private static final Map<String, SdkField<?>> SDK_NAME_TO_FIELD = memberNameToFieldInitializer();

    private static final long serialVersionUID = 1L;

    private final String key;

    private final Instant lastModified;

    private final String eTag;

    private final List<String> checksumAlgorithm;

    private final String checksumType;

    private final Long size;

    private final String storageClass;

    private final Owner owner;

    private final RestoreStatus restoreStatus;

    private S3Object(BuilderImpl builder) {
        this.key = builder.key;
        this.lastModified = builder.lastModified;
        this.eTag = builder.eTag;
        this.checksumAlgorithm = builder.checksumAlgorithm;
        this.checksumType = builder.checksumType;
        this.size = builder.size;
        this.storageClass = builder.storageClass;
        this.owner = builder.owner;
        this.restoreStatus = builder.restoreStatus;
    }

    /**
     * <p>
     * The name that you assign to an object. You use the object key to retrieve the object.
     * </p>
     * 
     * @return The name that you assign to an object. You use the object key to retrieve the object.
     */
    public final String key() {
        return key;
    }

    /**
     * <p>
     * Creation date of the object.
     * </p>
     * 
     * @return Creation date of the object.
     */
    public final Instant lastModified() {
        return lastModified;
    }

    /**
     * <p>
     * The entity tag is a hash of the object. The ETag reflects changes only to the contents of an object, not its
     * metadata. The ETag may or may not be an MD5 digest of the object data. Whether or not it is depends on how the
     * object was created and how it is encrypted as described below:
     * </p>
     * <ul>
     * <li>
     * <p>
     * Objects created by the PUT Object, POST Object, or Copy operation, or through the Amazon Web Services Management
     * Console, and are encrypted by SSE-S3 or plaintext, have ETags that are an MD5 digest of their object data.
     * </p>
     * </li>
     * <li>
     * <p>
     * Objects created by the PUT Object, POST Object, or Copy operation, or through the Amazon Web Services Management
     * Console, and are encrypted by SSE-C or SSE-KMS, have ETags that are not an MD5 digest of their object data.
     * </p>
     * </li>
     * <li>
     * <p>
     * If an object is created by either the Multipart Upload or Part Copy operation, the ETag is not an MD5 digest,
     * regardless of the method of encryption. If an object is larger than 16 MB, the Amazon Web Services Management
     * Console will upload or copy that object as a Multipart Upload, and therefore the ETag will not be an MD5 digest.
     * </p>
     * </li>
     * </ul>
     * <note>
     * <p>
     * <b>Directory buckets</b> - MD5 is not supported by directory buckets.
     * </p>
     * </note>
     * 
     * @return The entity tag is a hash of the object. The ETag reflects changes only to the contents of an object, not
     *         its metadata. The ETag may or may not be an MD5 digest of the object data. Whether or not it is depends
     *         on how the object was created and how it is encrypted as described below:</p>
     *         <ul>
     *         <li>
     *         <p>
     *         Objects created by the PUT Object, POST Object, or Copy operation, or through the Amazon Web Services
     *         Management Console, and are encrypted by SSE-S3 or plaintext, have ETags that are an MD5 digest of their
     *         object data.
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         Objects created by the PUT Object, POST Object, or Copy operation, or through the Amazon Web Services
     *         Management Console, and are encrypted by SSE-C or SSE-KMS, have ETags that are not an MD5 digest of their
     *         object data.
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         If an object is created by either the Multipart Upload or Part Copy operation, the ETag is not an MD5
     *         digest, regardless of the method of encryption. If an object is larger than 16 MB, the Amazon Web
     *         Services Management Console will upload or copy that object as a Multipart Upload, and therefore the ETag
     *         will not be an MD5 digest.
     *         </p>
     *         </li>
     *         </ul>
     *         <note>
     *         <p>
     *         <b>Directory buckets</b> - MD5 is not supported by directory buckets.
     *         </p>
     */
    public final String eTag() {
        return eTag;
    }

    /**
     * <p>
     * The algorithm that was used to create a checksum of the object.
     * </p>
     * <p>
     * Attempts to modify the collection returned by this method will result in an UnsupportedOperationException.
     * </p>
     * <p>
     * This method will never return null. If you would like to know whether the service returned this field (so that
     * you can differentiate between null and empty), you can use the {@link #hasChecksumAlgorithm} method.
     * </p>
     * 
     * @return The algorithm that was used to create a checksum of the object.
     */
    public final List<ChecksumAlgorithm> checksumAlgorithm() {
        return ChecksumAlgorithmListCopier.copyStringToEnum(checksumAlgorithm);
    }

    /**
     * For responses, this returns true if the service returned a value for the ChecksumAlgorithm property. This DOES
     * NOT check that the value is non-empty (for which, you should check the {@code isEmpty()} method on the property).
     * This is useful because the SDK will never return a null collection or map, but you may need to differentiate
     * between the service returning nothing (or null) and the service returning an empty collection or map. For
     * requests, this returns true if a value for the property was specified in the request builder, and false if a
     * value was not specified.
     */
    public final boolean hasChecksumAlgorithm() {
        return checksumAlgorithm != null && !(checksumAlgorithm instanceof SdkAutoConstructList);
    }

    /**
     * <p>
     * The algorithm that was used to create a checksum of the object.
     * </p>
     * <p>
     * Attempts to modify the collection returned by this method will result in an UnsupportedOperationException.
     * </p>
     * <p>
     * This method will never return null. If you would like to know whether the service returned this field (so that
     * you can differentiate between null and empty), you can use the {@link #hasChecksumAlgorithm} method.
     * </p>
     * 
     * @return The algorithm that was used to create a checksum of the object.
     */
    public final List<String> checksumAlgorithmAsStrings() {
        return checksumAlgorithm;
    }

    /**
     * <p>
     * The checksum type that is used to calculate the object’s checksum value. For more information, see <a
     * href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/checking-object-integrity.html">Checking object
     * integrity</a> in the <i>Amazon S3 User Guide</i>.
     * </p>
     * <p>
     * If the service returns an enum value that is not available in the current SDK version, {@link #checksumType} will
     * return {@link ChecksumType#UNKNOWN_TO_SDK_VERSION}. The raw value returned by the service is available from
     * {@link #checksumTypeAsString}.
     * </p>
     * 
     * @return The checksum type that is used to calculate the object’s checksum value. For more information, see <a
     *         href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/checking-object-integrity.html">Checking
     *         object integrity</a> in the <i>Amazon S3 User Guide</i>.
     * @see ChecksumType
     */
    public final ChecksumType checksumType() {
        return ChecksumType.fromValue(checksumType);
    }

    /**
     * <p>
     * The checksum type that is used to calculate the object’s checksum value. For more information, see <a
     * href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/checking-object-integrity.html">Checking object
     * integrity</a> in the <i>Amazon S3 User Guide</i>.
     * </p>
     * <p>
     * If the service returns an enum value that is not available in the current SDK version, {@link #checksumType} will
     * return {@link ChecksumType#UNKNOWN_TO_SDK_VERSION}. The raw value returned by the service is available from
     * {@link #checksumTypeAsString}.
     * </p>
     * 
     * @return The checksum type that is used to calculate the object’s checksum value. For more information, see <a
     *         href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/checking-object-integrity.html">Checking
     *         object integrity</a> in the <i>Amazon S3 User Guide</i>.
     * @see ChecksumType
     */
    public final String checksumTypeAsString() {
        return checksumType;
    }

    /**
     * <p>
     * Size in bytes of the object
     * </p>
     * 
     * @return Size in bytes of the object
     */
    public final Long size() {
        return size;
    }

    /**
     * <p>
     * The class of storage used to store the object.
     * </p>
     * <note>
     * <p>
     * <b>Directory buckets</b> - Directory buckets only support <code>EXPRESS_ONEZONE</code> (the S3 Express One Zone
     * storage class) in Availability Zones and <code>ONEZONE_IA</code> (the S3 One Zone-Infrequent Access storage
     * class) in Dedicated Local Zones.
     * </p>
     * </note>
     * <p>
     * If the service returns an enum value that is not available in the current SDK version, {@link #storageClass} will
     * return {@link ObjectStorageClass#UNKNOWN_TO_SDK_VERSION}. The raw value returned by the service is available from
     * {@link #storageClassAsString}.
     * </p>
     * 
     * @return The class of storage used to store the object.</p> <note>
     *         <p>
     *         <b>Directory buckets</b> - Directory buckets only support <code>EXPRESS_ONEZONE</code> (the S3 Express
     *         One Zone storage class) in Availability Zones and <code>ONEZONE_IA</code> (the S3 One Zone-Infrequent
     *         Access storage class) in Dedicated Local Zones.
     *         </p>
     * @see ObjectStorageClass
     */
    public final ObjectStorageClass storageClass() {
        return ObjectStorageClass.fromValue(storageClass);
    }

    /**
     * <p>
     * The class of storage used to store the object.
     * </p>
     * <note>
     * <p>
     * <b>Directory buckets</b> - Directory buckets only support <code>EXPRESS_ONEZONE</code> (the S3 Express One Zone
     * storage class) in Availability Zones and <code>ONEZONE_IA</code> (the S3 One Zone-Infrequent Access storage
     * class) in Dedicated Local Zones.
     * </p>
     * </note>
     * <p>
     * If the service returns an enum value that is not available in the current SDK version, {@link #storageClass} will
     * return {@link ObjectStorageClass#UNKNOWN_TO_SDK_VERSION}. The raw value returned by the service is available from
     * {@link #storageClassAsString}.
     * </p>
     * 
     * @return The class of storage used to store the object.</p> <note>
     *         <p>
     *         <b>Directory buckets</b> - Directory buckets only support <code>EXPRESS_ONEZONE</code> (the S3 Express
     *         One Zone storage class) in Availability Zones and <code>ONEZONE_IA</code> (the S3 One Zone-Infrequent
     *         Access storage class) in Dedicated Local Zones.
     *         </p>
     * @see ObjectStorageClass
     */
    public final String storageClassAsString() {
        return storageClass;
    }

    /**
     * <p>
     * The owner of the object
     * </p>
     * <note>
     * <p>
     * <b>Directory buckets</b> - The bucket owner is returned as the object owner.
     * </p>
     * </note>
     * 
     * @return The owner of the object</p> <note>
     *         <p>
     *         <b>Directory buckets</b> - The bucket owner is returned as the object owner.
     *         </p>
     */
    public final Owner owner() {
        return owner;
    }

    /**
     * <p>
     * Specifies the restoration status of an object. Objects in certain storage classes must be restored before they
     * can be retrieved. For more information about these storage classes and how to work with archived objects, see <a
     * href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/archived-objects.html"> Working with archived
     * objects</a> in the <i>Amazon S3 User Guide</i>.
     * </p>
     * <note>
     * <p>
     * This functionality is not supported for directory buckets. Directory buckets only support
     * <code>EXPRESS_ONEZONE</code> (the S3 Express One Zone storage class) in Availability Zones and
     * <code>ONEZONE_IA</code> (the S3 One Zone-Infrequent Access storage class) in Dedicated Local Zones.
     * </p>
     * </note>
     * 
     * @return Specifies the restoration status of an object. Objects in certain storage classes must be restored before
     *         they can be retrieved. For more information about these storage classes and how to work with archived
     *         objects, see <a href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/archived-objects.html">
     *         Working with archived objects</a> in the <i>Amazon S3 User Guide</i>.</p> <note>
     *         <p>
     *         This functionality is not supported for directory buckets. Directory buckets only support
     *         <code>EXPRESS_ONEZONE</code> (the S3 Express One Zone storage class) in Availability Zones and
     *         <code>ONEZONE_IA</code> (the S3 One Zone-Infrequent Access storage class) in Dedicated Local Zones.
     *         </p>
     */
    public final RestoreStatus restoreStatus() {
        return restoreStatus;
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
        hashCode = 31 * hashCode + Objects.hashCode(lastModified());
        hashCode = 31 * hashCode + Objects.hashCode(eTag());
        hashCode = 31 * hashCode + Objects.hashCode(hasChecksumAlgorithm() ? checksumAlgorithmAsStrings() : null);
        hashCode = 31 * hashCode + Objects.hashCode(checksumTypeAsString());
        hashCode = 31 * hashCode + Objects.hashCode(size());
        hashCode = 31 * hashCode + Objects.hashCode(storageClassAsString());
        hashCode = 31 * hashCode + Objects.hashCode(owner());
        hashCode = 31 * hashCode + Objects.hashCode(restoreStatus());
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
        if (!(obj instanceof S3Object)) {
            return false;
        }
        S3Object other = (S3Object) obj;
        return Objects.equals(key(), other.key()) && Objects.equals(lastModified(), other.lastModified())
                && Objects.equals(eTag(), other.eTag()) && hasChecksumAlgorithm() == other.hasChecksumAlgorithm()
                && Objects.equals(checksumAlgorithmAsStrings(), other.checksumAlgorithmAsStrings())
                && Objects.equals(checksumTypeAsString(), other.checksumTypeAsString()) && Objects.equals(size(), other.size())
                && Objects.equals(storageClassAsString(), other.storageClassAsString()) && Objects.equals(owner(), other.owner())
                && Objects.equals(restoreStatus(), other.restoreStatus());
    }

    /**
     * Returns a string representation of this object. This is useful for testing and debugging. Sensitive data will be
     * redacted from this string using a placeholder value.
     */
    @Override
    public final String toString() {
        return ToString.builder("S3Object").add("Key", key()).add("LastModified", lastModified()).add("ETag", eTag())
                .add("ChecksumAlgorithm", hasChecksumAlgorithm() ? checksumAlgorithmAsStrings() : null)
                .add("ChecksumType", checksumTypeAsString()).add("Size", size()).add("StorageClass", storageClassAsString())
                .add("Owner", owner()).add("RestoreStatus", restoreStatus()).build();
    }

    public final <T> Optional<T> getValueForField(String fieldName, Class<T> clazz) {
        switch (fieldName) {
        case "Key":
            return Optional.ofNullable(clazz.cast(key()));
        case "LastModified":
            return Optional.ofNullable(clazz.cast(lastModified()));
        case "ETag":
            return Optional.ofNullable(clazz.cast(eTag()));
        case "ChecksumAlgorithm":
            return Optional.ofNullable(clazz.cast(checksumAlgorithmAsStrings()));
        case "ChecksumType":
            return Optional.ofNullable(clazz.cast(checksumTypeAsString()));
        case "Size":
            return Optional.ofNullable(clazz.cast(size()));
        case "StorageClass":
            return Optional.ofNullable(clazz.cast(storageClassAsString()));
        case "Owner":
            return Optional.ofNullable(clazz.cast(owner()));
        case "RestoreStatus":
            return Optional.ofNullable(clazz.cast(restoreStatus()));
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
        map.put("LastModified", LAST_MODIFIED_FIELD);
        map.put("ETag", E_TAG_FIELD);
        map.put("ChecksumAlgorithm", CHECKSUM_ALGORITHM_FIELD);
        map.put("ChecksumType", CHECKSUM_TYPE_FIELD);
        map.put("Size", SIZE_FIELD);
        map.put("StorageClass", STORAGE_CLASS_FIELD);
        map.put("Owner", OWNER_FIELD);
        map.put("RestoreStatus", RESTORE_STATUS_FIELD);
        return Collections.unmodifiableMap(map);
    }

    private static <T> Function<Object, T> getter(Function<S3Object, T> g) {
        return obj -> g.apply((S3Object) obj);
    }

    private static <T> BiConsumer<Object, T> setter(BiConsumer<Builder, T> s) {
        return (obj, val) -> s.accept((Builder) obj, val);
    }

    @Mutable
    @NotThreadSafe
    public interface Builder extends SdkPojo, CopyableBuilder<Builder, S3Object> {
        /**
         * <p>
         * The name that you assign to an object. You use the object key to retrieve the object.
         * </p>
         * 
         * @param key
         *        The name that you assign to an object. You use the object key to retrieve the object.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder key(String key);

        /**
         * <p>
         * Creation date of the object.
         * </p>
         * 
         * @param lastModified
         *        Creation date of the object.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder lastModified(Instant lastModified);

        /**
         * <p>
         * The entity tag is a hash of the object. The ETag reflects changes only to the contents of an object, not its
         * metadata. The ETag may or may not be an MD5 digest of the object data. Whether or not it is depends on how
         * the object was created and how it is encrypted as described below:
         * </p>
         * <ul>
         * <li>
         * <p>
         * Objects created by the PUT Object, POST Object, or Copy operation, or through the Amazon Web Services
         * Management Console, and are encrypted by SSE-S3 or plaintext, have ETags that are an MD5 digest of their
         * object data.
         * </p>
         * </li>
         * <li>
         * <p>
         * Objects created by the PUT Object, POST Object, or Copy operation, or through the Amazon Web Services
         * Management Console, and are encrypted by SSE-C or SSE-KMS, have ETags that are not an MD5 digest of their
         * object data.
         * </p>
         * </li>
         * <li>
         * <p>
         * If an object is created by either the Multipart Upload or Part Copy operation, the ETag is not an MD5 digest,
         * regardless of the method of encryption. If an object is larger than 16 MB, the Amazon Web Services Management
         * Console will upload or copy that object as a Multipart Upload, and therefore the ETag will not be an MD5
         * digest.
         * </p>
         * </li>
         * </ul>
         * <note>
         * <p>
         * <b>Directory buckets</b> - MD5 is not supported by directory buckets.
         * </p>
         * </note>
         * 
         * @param eTag
         *        The entity tag is a hash of the object. The ETag reflects changes only to the contents of an object,
         *        not its metadata. The ETag may or may not be an MD5 digest of the object data. Whether or not it is
         *        depends on how the object was created and how it is encrypted as described below:</p>
         *        <ul>
         *        <li>
         *        <p>
         *        Objects created by the PUT Object, POST Object, or Copy operation, or through the Amazon Web Services
         *        Management Console, and are encrypted by SSE-S3 or plaintext, have ETags that are an MD5 digest of
         *        their object data.
         *        </p>
         *        </li>
         *        <li>
         *        <p>
         *        Objects created by the PUT Object, POST Object, or Copy operation, or through the Amazon Web Services
         *        Management Console, and are encrypted by SSE-C or SSE-KMS, have ETags that are not an MD5 digest of
         *        their object data.
         *        </p>
         *        </li>
         *        <li>
         *        <p>
         *        If an object is created by either the Multipart Upload or Part Copy operation, the ETag is not an MD5
         *        digest, regardless of the method of encryption. If an object is larger than 16 MB, the Amazon Web
         *        Services Management Console will upload or copy that object as a Multipart Upload, and therefore the
         *        ETag will not be an MD5 digest.
         *        </p>
         *        </li>
         *        </ul>
         *        <note>
         *        <p>
         *        <b>Directory buckets</b> - MD5 is not supported by directory buckets.
         *        </p>
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder eTag(String eTag);

        /**
         * <p>
         * The algorithm that was used to create a checksum of the object.
         * </p>
         * 
         * @param checksumAlgorithm
         *        The algorithm that was used to create a checksum of the object.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder checksumAlgorithmWithStrings(Collection<String> checksumAlgorithm);

        /**
         * <p>
         * The algorithm that was used to create a checksum of the object.
         * </p>
         * 
         * @param checksumAlgorithm
         *        The algorithm that was used to create a checksum of the object.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder checksumAlgorithmWithStrings(String... checksumAlgorithm);

        /**
         * <p>
         * The algorithm that was used to create a checksum of the object.
         * </p>
         * 
         * @param checksumAlgorithm
         *        The algorithm that was used to create a checksum of the object.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder checksumAlgorithm(Collection<ChecksumAlgorithm> checksumAlgorithm);

        /**
         * <p>
         * The algorithm that was used to create a checksum of the object.
         * </p>
         * 
         * @param checksumAlgorithm
         *        The algorithm that was used to create a checksum of the object.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder checksumAlgorithm(ChecksumAlgorithm... checksumAlgorithm);

        /**
         * <p>
         * The checksum type that is used to calculate the object’s checksum value. For more information, see <a
         * href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/checking-object-integrity.html">Checking object
         * integrity</a> in the <i>Amazon S3 User Guide</i>.
         * </p>
         * 
         * @param checksumType
         *        The checksum type that is used to calculate the object’s checksum value. For more information, see <a
         *        href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/checking-object-integrity.html">Checking
         *        object integrity</a> in the <i>Amazon S3 User Guide</i>.
         * @see ChecksumType
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see ChecksumType
         */
        Builder checksumType(String checksumType);

        /**
         * <p>
         * The checksum type that is used to calculate the object’s checksum value. For more information, see <a
         * href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/checking-object-integrity.html">Checking object
         * integrity</a> in the <i>Amazon S3 User Guide</i>.
         * </p>
         * 
         * @param checksumType
         *        The checksum type that is used to calculate the object’s checksum value. For more information, see <a
         *        href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/checking-object-integrity.html">Checking
         *        object integrity</a> in the <i>Amazon S3 User Guide</i>.
         * @see ChecksumType
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see ChecksumType
         */
        Builder checksumType(ChecksumType checksumType);

        /**
         * <p>
         * Size in bytes of the object
         * </p>
         * 
         * @param size
         *        Size in bytes of the object
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder size(Long size);

        /**
         * <p>
         * The class of storage used to store the object.
         * </p>
         * <note>
         * <p>
         * <b>Directory buckets</b> - Directory buckets only support <code>EXPRESS_ONEZONE</code> (the S3 Express One
         * Zone storage class) in Availability Zones and <code>ONEZONE_IA</code> (the S3 One Zone-Infrequent Access
         * storage class) in Dedicated Local Zones.
         * </p>
         * </note>
         * 
         * @param storageClass
         *        The class of storage used to store the object.</p> <note>
         *        <p>
         *        <b>Directory buckets</b> - Directory buckets only support <code>EXPRESS_ONEZONE</code> (the S3 Express
         *        One Zone storage class) in Availability Zones and <code>ONEZONE_IA</code> (the S3 One Zone-Infrequent
         *        Access storage class) in Dedicated Local Zones.
         *        </p>
         * @see ObjectStorageClass
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see ObjectStorageClass
         */
        Builder storageClass(String storageClass);

        /**
         * <p>
         * The class of storage used to store the object.
         * </p>
         * <note>
         * <p>
         * <b>Directory buckets</b> - Directory buckets only support <code>EXPRESS_ONEZONE</code> (the S3 Express One
         * Zone storage class) in Availability Zones and <code>ONEZONE_IA</code> (the S3 One Zone-Infrequent Access
         * storage class) in Dedicated Local Zones.
         * </p>
         * </note>
         * 
         * @param storageClass
         *        The class of storage used to store the object.</p> <note>
         *        <p>
         *        <b>Directory buckets</b> - Directory buckets only support <code>EXPRESS_ONEZONE</code> (the S3 Express
         *        One Zone storage class) in Availability Zones and <code>ONEZONE_IA</code> (the S3 One Zone-Infrequent
         *        Access storage class) in Dedicated Local Zones.
         *        </p>
         * @see ObjectStorageClass
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see ObjectStorageClass
         */
        Builder storageClass(ObjectStorageClass storageClass);

        /**
         * <p>
         * The owner of the object
         * </p>
         * <note>
         * <p>
         * <b>Directory buckets</b> - The bucket owner is returned as the object owner.
         * </p>
         * </note>
         * 
         * @param owner
         *        The owner of the object</p> <note>
         *        <p>
         *        <b>Directory buckets</b> - The bucket owner is returned as the object owner.
         *        </p>
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder owner(Owner owner);

        /**
         * <p>
         * The owner of the object
         * </p>
         * <note>
         * <p>
         * <b>Directory buckets</b> - The bucket owner is returned as the object owner.
         * </p>
         * </note> This is a convenience method that creates an instance of the {@link Owner.Builder} avoiding the need
         * to create one manually via {@link Owner#builder()}.
         *
         * <p>
         * When the {@link Consumer} completes, {@link Owner.Builder#build()} is called immediately and its result is
         * passed to {@link #owner(Owner)}.
         * 
         * @param owner
         *        a consumer that will call methods on {@link Owner.Builder}
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see #owner(Owner)
         */
        default Builder owner(Consumer<Owner.Builder> owner) {
            return owner(Owner.builder().applyMutation(owner).build());
        }

        /**
         * <p>
         * Specifies the restoration status of an object. Objects in certain storage classes must be restored before
         * they can be retrieved. For more information about these storage classes and how to work with archived
         * objects, see <a href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/archived-objects.html"> Working
         * with archived objects</a> in the <i>Amazon S3 User Guide</i>.
         * </p>
         * <note>
         * <p>
         * This functionality is not supported for directory buckets. Directory buckets only support
         * <code>EXPRESS_ONEZONE</code> (the S3 Express One Zone storage class) in Availability Zones and
         * <code>ONEZONE_IA</code> (the S3 One Zone-Infrequent Access storage class) in Dedicated Local Zones.
         * </p>
         * </note>
         * 
         * @param restoreStatus
         *        Specifies the restoration status of an object. Objects in certain storage classes must be restored
         *        before they can be retrieved. For more information about these storage classes and how to work with
         *        archived objects, see <a
         *        href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/archived-objects.html"> Working with
         *        archived objects</a> in the <i>Amazon S3 User Guide</i>.</p> <note>
         *        <p>
         *        This functionality is not supported for directory buckets. Directory buckets only support
         *        <code>EXPRESS_ONEZONE</code> (the S3 Express One Zone storage class) in Availability Zones and
         *        <code>ONEZONE_IA</code> (the S3 One Zone-Infrequent Access storage class) in Dedicated Local Zones.
         *        </p>
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder restoreStatus(RestoreStatus restoreStatus);

        /**
         * <p>
         * Specifies the restoration status of an object. Objects in certain storage classes must be restored before
         * they can be retrieved. For more information about these storage classes and how to work with archived
         * objects, see <a href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/archived-objects.html"> Working
         * with archived objects</a> in the <i>Amazon S3 User Guide</i>.
         * </p>
         * <note>
         * <p>
         * This functionality is not supported for directory buckets. Directory buckets only support
         * <code>EXPRESS_ONEZONE</code> (the S3 Express One Zone storage class) in Availability Zones and
         * <code>ONEZONE_IA</code> (the S3 One Zone-Infrequent Access storage class) in Dedicated Local Zones.
         * </p>
         * </note> This is a convenience method that creates an instance of the {@link RestoreStatus.Builder} avoiding
         * the need to create one manually via {@link RestoreStatus#builder()}.
         *
         * <p>
         * When the {@link Consumer} completes, {@link RestoreStatus.Builder#build()} is called immediately and its
         * result is passed to {@link #restoreStatus(RestoreStatus)}.
         * 
         * @param restoreStatus
         *        a consumer that will call methods on {@link RestoreStatus.Builder}
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see #restoreStatus(RestoreStatus)
         */
        default Builder restoreStatus(Consumer<RestoreStatus.Builder> restoreStatus) {
            return restoreStatus(RestoreStatus.builder().applyMutation(restoreStatus).build());
        }
    }

    static final class BuilderImpl implements Builder {
        private String key;

        private Instant lastModified;

        private String eTag;

        private List<String> checksumAlgorithm = DefaultSdkAutoConstructList.getInstance();

        private String checksumType;

        private Long size;

        private String storageClass;

        private Owner owner;

        private RestoreStatus restoreStatus;

        private BuilderImpl() {
        }

        private BuilderImpl(S3Object model) {
            key(model.key);
            lastModified(model.lastModified);
            eTag(model.eTag);
            checksumAlgorithmWithStrings(model.checksumAlgorithm);
            checksumType(model.checksumType);
            size(model.size);
            storageClass(model.storageClass);
            owner(model.owner);
            restoreStatus(model.restoreStatus);
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

        public final Instant getLastModified() {
            return lastModified;
        }

        public final void setLastModified(Instant lastModified) {
            this.lastModified = lastModified;
        }

        @Override
        public final Builder lastModified(Instant lastModified) {
            this.lastModified = lastModified;
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

        public final Collection<String> getChecksumAlgorithm() {
            if (checksumAlgorithm instanceof SdkAutoConstructList) {
                return null;
            }
            return checksumAlgorithm;
        }

        public final void setChecksumAlgorithm(Collection<String> checksumAlgorithm) {
            this.checksumAlgorithm = ChecksumAlgorithmListCopier.copy(checksumAlgorithm);
        }

        @Override
        public final Builder checksumAlgorithmWithStrings(Collection<String> checksumAlgorithm) {
            this.checksumAlgorithm = ChecksumAlgorithmListCopier.copy(checksumAlgorithm);
            return this;
        }

        @Override
        @SafeVarargs
        public final Builder checksumAlgorithmWithStrings(String... checksumAlgorithm) {
            checksumAlgorithmWithStrings(Arrays.asList(checksumAlgorithm));
            return this;
        }

        @Override
        public final Builder checksumAlgorithm(Collection<ChecksumAlgorithm> checksumAlgorithm) {
            this.checksumAlgorithm = ChecksumAlgorithmListCopier.copyEnumToString(checksumAlgorithm);
            return this;
        }

        @Override
        @SafeVarargs
        public final Builder checksumAlgorithm(ChecksumAlgorithm... checksumAlgorithm) {
            checksumAlgorithm(Arrays.asList(checksumAlgorithm));
            return this;
        }

        public final String getChecksumType() {
            return checksumType;
        }

        public final void setChecksumType(String checksumType) {
            this.checksumType = checksumType;
        }

        @Override
        public final Builder checksumType(String checksumType) {
            this.checksumType = checksumType;
            return this;
        }

        @Override
        public final Builder checksumType(ChecksumType checksumType) {
            this.checksumType(checksumType == null ? null : checksumType.toString());
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

        public final String getStorageClass() {
            return storageClass;
        }

        public final void setStorageClass(String storageClass) {
            this.storageClass = storageClass;
        }

        @Override
        public final Builder storageClass(String storageClass) {
            this.storageClass = storageClass;
            return this;
        }

        @Override
        public final Builder storageClass(ObjectStorageClass storageClass) {
            this.storageClass(storageClass == null ? null : storageClass.toString());
            return this;
        }

        public final Owner.Builder getOwner() {
            return owner != null ? owner.toBuilder() : null;
        }

        public final void setOwner(Owner.BuilderImpl owner) {
            this.owner = owner != null ? owner.build() : null;
        }

        @Override
        public final Builder owner(Owner owner) {
            this.owner = owner;
            return this;
        }

        public final RestoreStatus.Builder getRestoreStatus() {
            return restoreStatus != null ? restoreStatus.toBuilder() : null;
        }

        public final void setRestoreStatus(RestoreStatus.BuilderImpl restoreStatus) {
            this.restoreStatus = restoreStatus != null ? restoreStatus.build() : null;
        }

        @Override
        public final Builder restoreStatus(RestoreStatus restoreStatus) {
            this.restoreStatus = restoreStatus;
            return this;
        }

        @Override
        public S3Object build() {
            return new S3Object(this);
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
