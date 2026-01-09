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
import com.ibm.cos.v2.utils.ToString;
import com.ibm.cos.v2.utils.builder.CopyableBuilder;
import com.ibm.cos.v2.utils.builder.ToCopyableBuilder;

/**
 * <p>
 * Information about the deleted object.
 * </p>
 */
@Generated("com.ibm.cos.v2:codegen")
public final class DeletedObject implements SdkPojo, Serializable, ToCopyableBuilder<DeletedObject.Builder, DeletedObject> {
    private static final SdkField<String> KEY_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("Key")
            .getter(getter(DeletedObject::key))
            .setter(setter(Builder::key))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("Key").unmarshallLocationName("Key")
                    .build()).build();

    private static final SdkField<String> VERSION_ID_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("VersionId")
            .getter(getter(DeletedObject::versionId))
            .setter(setter(Builder::versionId))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("VersionId")
                    .unmarshallLocationName("VersionId").build()).build();

    private static final SdkField<Boolean> DELETE_MARKER_FIELD = SdkField
            .<Boolean> builder(MarshallingType.BOOLEAN)
            .memberName("DeleteMarker")
            .getter(getter(DeletedObject::deleteMarker))
            .setter(setter(Builder::deleteMarker))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("DeleteMarker")
                    .unmarshallLocationName("DeleteMarker").build()).build();

    private static final SdkField<String> DELETE_MARKER_VERSION_ID_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("DeleteMarkerVersionId")
            .getter(getter(DeletedObject::deleteMarkerVersionId))
            .setter(setter(Builder::deleteMarkerVersionId))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("DeleteMarkerVersionId")
                    .unmarshallLocationName("DeleteMarkerVersionId").build()).build();

    private static final List<SdkField<?>> SDK_FIELDS = Collections.unmodifiableList(Arrays.asList(KEY_FIELD, VERSION_ID_FIELD,
            DELETE_MARKER_FIELD, DELETE_MARKER_VERSION_ID_FIELD));

    private static final Map<String, SdkField<?>> SDK_NAME_TO_FIELD = memberNameToFieldInitializer();

    private static final long serialVersionUID = 1L;

    private final String key;

    private final String versionId;

    private final Boolean deleteMarker;

    private final String deleteMarkerVersionId;

    private DeletedObject(BuilderImpl builder) {
        this.key = builder.key;
        this.versionId = builder.versionId;
        this.deleteMarker = builder.deleteMarker;
        this.deleteMarkerVersionId = builder.deleteMarkerVersionId;
    }

    /**
     * <p>
     * The name of the deleted object.
     * </p>
     * 
     * @return The name of the deleted object.
     */
    public final String key() {
        return key;
    }

    /**
     * <p>
     * The version ID of the deleted object.
     * </p>
     * <note>
     * <p>
     * This functionality is not supported for directory buckets.
     * </p>
     * </note>
     * 
     * @return The version ID of the deleted object.</p> <note>
     *         <p>
     *         This functionality is not supported for directory buckets.
     *         </p>
     */
    public final String versionId() {
        return versionId;
    }

    /**
     * <p>
     * Indicates whether the specified object version that was permanently deleted was (true) or was not (false) a
     * delete marker before deletion. In a simple DELETE, this header indicates whether (true) or not (false) the
     * current version of the object is a delete marker. To learn more about delete markers, see <a
     * href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/DeleteMarker.html">Working with delete markers</a>.
     * </p>
     * <note>
     * <p>
     * This functionality is not supported for directory buckets.
     * </p>
     * </note>
     * 
     * @return Indicates whether the specified object version that was permanently deleted was (true) or was not (false)
     *         a delete marker before deletion. In a simple DELETE, this header indicates whether (true) or not (false)
     *         the current version of the object is a delete marker. To learn more about delete markers, see <a
     *         href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/DeleteMarker.html">Working with delete
     *         markers</a>.</p> <note>
     *         <p>
     *         This functionality is not supported for directory buckets.
     *         </p>
     */
    public final Boolean deleteMarker() {
        return deleteMarker;
    }

    /**
     * <p>
     * The version ID of the delete marker created as a result of the DELETE operation. If you delete a specific object
     * version, the value returned by this header is the version ID of the object version deleted.
     * </p>
     * <note>
     * <p>
     * This functionality is not supported for directory buckets.
     * </p>
     * </note>
     * 
     * @return The version ID of the delete marker created as a result of the DELETE operation. If you delete a specific
     *         object version, the value returned by this header is the version ID of the object version deleted.</p>
     *         <note>
     *         <p>
     *         This functionality is not supported for directory buckets.
     *         </p>
     */
    public final String deleteMarkerVersionId() {
        return deleteMarkerVersionId;
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
        hashCode = 31 * hashCode + Objects.hashCode(deleteMarker());
        hashCode = 31 * hashCode + Objects.hashCode(deleteMarkerVersionId());
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
        if (!(obj instanceof DeletedObject)) {
            return false;
        }
        DeletedObject other = (DeletedObject) obj;
        return Objects.equals(key(), other.key()) && Objects.equals(versionId(), other.versionId())
                && Objects.equals(deleteMarker(), other.deleteMarker())
                && Objects.equals(deleteMarkerVersionId(), other.deleteMarkerVersionId());
    }

    /**
     * Returns a string representation of this object. This is useful for testing and debugging. Sensitive data will be
     * redacted from this string using a placeholder value.
     */
    @Override
    public final String toString() {
        return ToString.builder("DeletedObject").add("Key", key()).add("VersionId", versionId())
                .add("DeleteMarker", deleteMarker()).add("DeleteMarkerVersionId", deleteMarkerVersionId()).build();
    }

    public final <T> Optional<T> getValueForField(String fieldName, Class<T> clazz) {
        switch (fieldName) {
        case "Key":
            return Optional.ofNullable(clazz.cast(key()));
        case "VersionId":
            return Optional.ofNullable(clazz.cast(versionId()));
        case "DeleteMarker":
            return Optional.ofNullable(clazz.cast(deleteMarker()));
        case "DeleteMarkerVersionId":
            return Optional.ofNullable(clazz.cast(deleteMarkerVersionId()));
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
        map.put("DeleteMarker", DELETE_MARKER_FIELD);
        map.put("DeleteMarkerVersionId", DELETE_MARKER_VERSION_ID_FIELD);
        return Collections.unmodifiableMap(map);
    }

    private static <T> Function<Object, T> getter(Function<DeletedObject, T> g) {
        return obj -> g.apply((DeletedObject) obj);
    }

    private static <T> BiConsumer<Object, T> setter(BiConsumer<Builder, T> s) {
        return (obj, val) -> s.accept((Builder) obj, val);
    }

    @Mutable
    @NotThreadSafe
    public interface Builder extends SdkPojo, CopyableBuilder<Builder, DeletedObject> {
        /**
         * <p>
         * The name of the deleted object.
         * </p>
         * 
         * @param key
         *        The name of the deleted object.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder key(String key);

        /**
         * <p>
         * The version ID of the deleted object.
         * </p>
         * <note>
         * <p>
         * This functionality is not supported for directory buckets.
         * </p>
         * </note>
         * 
         * @param versionId
         *        The version ID of the deleted object.</p> <note>
         *        <p>
         *        This functionality is not supported for directory buckets.
         *        </p>
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder versionId(String versionId);

        /**
         * <p>
         * Indicates whether the specified object version that was permanently deleted was (true) or was not (false) a
         * delete marker before deletion. In a simple DELETE, this header indicates whether (true) or not (false) the
         * current version of the object is a delete marker. To learn more about delete markers, see <a
         * href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/DeleteMarker.html">Working with delete
         * markers</a>.
         * </p>
         * <note>
         * <p>
         * This functionality is not supported for directory buckets.
         * </p>
         * </note>
         * 
         * @param deleteMarker
         *        Indicates whether the specified object version that was permanently deleted was (true) or was not
         *        (false) a delete marker before deletion. In a simple DELETE, this header indicates whether (true) or
         *        not (false) the current version of the object is a delete marker. To learn more about delete markers,
         *        see <a href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/DeleteMarker.html">Working with
         *        delete markers</a>.</p> <note>
         *        <p>
         *        This functionality is not supported for directory buckets.
         *        </p>
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder deleteMarker(Boolean deleteMarker);

        /**
         * <p>
         * The version ID of the delete marker created as a result of the DELETE operation. If you delete a specific
         * object version, the value returned by this header is the version ID of the object version deleted.
         * </p>
         * <note>
         * <p>
         * This functionality is not supported for directory buckets.
         * </p>
         * </note>
         * 
         * @param deleteMarkerVersionId
         *        The version ID of the delete marker created as a result of the DELETE operation. If you delete a
         *        specific object version, the value returned by this header is the version ID of the object version
         *        deleted.</p> <note>
         *        <p>
         *        This functionality is not supported for directory buckets.
         *        </p>
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder deleteMarkerVersionId(String deleteMarkerVersionId);
    }

    static final class BuilderImpl implements Builder {
        private String key;

        private String versionId;

        private Boolean deleteMarker;

        private String deleteMarkerVersionId;

        private BuilderImpl() {
        }

        private BuilderImpl(DeletedObject model) {
            key(model.key);
            versionId(model.versionId);
            deleteMarker(model.deleteMarker);
            deleteMarkerVersionId(model.deleteMarkerVersionId);
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

        public final Boolean getDeleteMarker() {
            return deleteMarker;
        }

        public final void setDeleteMarker(Boolean deleteMarker) {
            this.deleteMarker = deleteMarker;
        }

        @Override
        public final Builder deleteMarker(Boolean deleteMarker) {
            this.deleteMarker = deleteMarker;
            return this;
        }

        public final String getDeleteMarkerVersionId() {
            return deleteMarkerVersionId;
        }

        public final void setDeleteMarkerVersionId(String deleteMarkerVersionId) {
            this.deleteMarkerVersionId = deleteMarkerVersionId;
        }

        @Override
        public final Builder deleteMarkerVersionId(String deleteMarkerVersionId) {
            this.deleteMarkerVersionId = deleteMarkerVersionId;
            return this;
        }

        @Override
        public DeletedObject build() {
            return new DeletedObject(this);
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
