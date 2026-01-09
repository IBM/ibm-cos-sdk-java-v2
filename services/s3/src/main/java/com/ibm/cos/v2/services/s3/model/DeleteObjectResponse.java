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
 */
@Generated("com.ibm.cos.v2:codegen")
public final class DeleteObjectResponse extends S3Response implements
        ToCopyableBuilder<DeleteObjectResponse.Builder, DeleteObjectResponse> {
    private static final SdkField<Boolean> DELETE_MARKER_FIELD = SdkField
            .<Boolean> builder(MarshallingType.BOOLEAN)
            .memberName("DeleteMarker")
            .getter(getter(DeleteObjectResponse::deleteMarker))
            .setter(setter(Builder::deleteMarker))
            .traits(LocationTrait.builder().location(MarshallLocation.HEADER).locationName("x-amz-delete-marker")
                    .unmarshallLocationName("x-amz-delete-marker").build()).build();

    private static final SdkField<String> VERSION_ID_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("VersionId")
            .getter(getter(DeleteObjectResponse::versionId))
            .setter(setter(Builder::versionId))
            .traits(LocationTrait.builder().location(MarshallLocation.HEADER).locationName("x-amz-version-id")
                    .unmarshallLocationName("x-amz-version-id").build()).build();

    private static final SdkField<String> REQUEST_CHARGED_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("RequestCharged")
            .getter(getter(DeleteObjectResponse::requestChargedAsString))
            .setter(setter(Builder::requestCharged))
            .traits(LocationTrait.builder().location(MarshallLocation.HEADER).locationName("x-amz-request-charged")
                    .unmarshallLocationName("x-amz-request-charged").build()).build();

    private static final List<SdkField<?>> SDK_FIELDS = Collections.unmodifiableList(Arrays.asList(DELETE_MARKER_FIELD,
            VERSION_ID_FIELD, REQUEST_CHARGED_FIELD));

    private static final Map<String, SdkField<?>> SDK_NAME_TO_FIELD = memberNameToFieldInitializer();

    private final Boolean deleteMarker;

    private final String versionId;

    private final String requestCharged;

    private DeleteObjectResponse(BuilderImpl builder) {
        super(builder);
        this.deleteMarker = builder.deleteMarker;
        this.versionId = builder.versionId;
        this.requestCharged = builder.requestCharged;
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
     * Returns the version ID of the delete marker created as a result of the DELETE operation.
     * </p>
     * <note>
     * <p>
     * This functionality is not supported for directory buckets.
     * </p>
     * </note>
     * 
     * @return Returns the version ID of the delete marker created as a result of the DELETE operation.</p> <note>
     *         <p>
     *         This functionality is not supported for directory buckets.
     *         </p>
     */
    public final String versionId() {
        return versionId;
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
        hashCode = 31 * hashCode + Objects.hashCode(deleteMarker());
        hashCode = 31 * hashCode + Objects.hashCode(versionId());
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
        if (!(obj instanceof DeleteObjectResponse)) {
            return false;
        }
        DeleteObjectResponse other = (DeleteObjectResponse) obj;
        return Objects.equals(deleteMarker(), other.deleteMarker()) && Objects.equals(versionId(), other.versionId())
                && Objects.equals(requestChargedAsString(), other.requestChargedAsString());
    }

    /**
     * Returns a string representation of this object. This is useful for testing and debugging. Sensitive data will be
     * redacted from this string using a placeholder value.
     */
    @Override
    public final String toString() {
        return ToString.builder("DeleteObjectResponse").add("DeleteMarker", deleteMarker()).add("VersionId", versionId())
                .add("RequestCharged", requestChargedAsString()).build();
    }

    public final <T> Optional<T> getValueForField(String fieldName, Class<T> clazz) {
        switch (fieldName) {
        case "DeleteMarker":
            return Optional.ofNullable(clazz.cast(deleteMarker()));
        case "VersionId":
            return Optional.ofNullable(clazz.cast(versionId()));
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
        map.put("x-amz-delete-marker", DELETE_MARKER_FIELD);
        map.put("x-amz-version-id", VERSION_ID_FIELD);
        map.put("x-amz-request-charged", REQUEST_CHARGED_FIELD);
        return Collections.unmodifiableMap(map);
    }

    private static <T> Function<Object, T> getter(Function<DeleteObjectResponse, T> g) {
        return obj -> g.apply((DeleteObjectResponse) obj);
    }

    private static <T> BiConsumer<Object, T> setter(BiConsumer<Builder, T> s) {
        return (obj, val) -> s.accept((Builder) obj, val);
    }

    @Mutable
    @NotThreadSafe
    public interface Builder extends S3Response.Builder, SdkPojo, CopyableBuilder<Builder, DeleteObjectResponse> {
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
         * Returns the version ID of the delete marker created as a result of the DELETE operation.
         * </p>
         * <note>
         * <p>
         * This functionality is not supported for directory buckets.
         * </p>
         * </note>
         * 
         * @param versionId
         *        Returns the version ID of the delete marker created as a result of the DELETE operation.</p> <note>
         *        <p>
         *        This functionality is not supported for directory buckets.
         *        </p>
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder versionId(String versionId);

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
        private Boolean deleteMarker;

        private String versionId;

        private String requestCharged;

        private BuilderImpl() {
        }

        private BuilderImpl(DeleteObjectResponse model) {
            super(model);
            deleteMarker(model.deleteMarker);
            versionId(model.versionId);
            requestCharged(model.requestCharged);
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
        public DeleteObjectResponse build() {
            return new DeleteObjectResponse(this);
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
