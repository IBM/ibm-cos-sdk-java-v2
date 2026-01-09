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
import java.util.function.Consumer;
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
import com.ibm.cos.v2.utils.ToString;
import com.ibm.cos.v2.utils.builder.CopyableBuilder;
import com.ibm.cos.v2.utils.builder.ToCopyableBuilder;

/**
 * <p>
 * The metadata table configuration for a general purpose bucket.
 * </p>
 */
@Generated("com.ibm.cos.v2:codegen")
public final class GetBucketMetadataTableConfigurationResult implements SdkPojo, Serializable,
        ToCopyableBuilder<GetBucketMetadataTableConfigurationResult.Builder, GetBucketMetadataTableConfigurationResult> {
    private static final SdkField<MetadataTableConfigurationResult> METADATA_TABLE_CONFIGURATION_RESULT_FIELD = SdkField
            .<MetadataTableConfigurationResult> builder(MarshallingType.SDK_POJO)
            .memberName("MetadataTableConfigurationResult")
            .getter(getter(GetBucketMetadataTableConfigurationResult::metadataTableConfigurationResult))
            .setter(setter(Builder::metadataTableConfigurationResult))
            .constructor(MetadataTableConfigurationResult::builder)
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("MetadataTableConfigurationResult")
                    .unmarshallLocationName("MetadataTableConfigurationResult").build(), RequiredTrait.create()).build();

    private static final SdkField<String> STATUS_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("Status")
            .getter(getter(GetBucketMetadataTableConfigurationResult::status))
            .setter(setter(Builder::status))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("Status")
                    .unmarshallLocationName("Status").build(), RequiredTrait.create()).build();

    private static final SdkField<ErrorDetails> ERROR_FIELD = SdkField
            .<ErrorDetails> builder(MarshallingType.SDK_POJO)
            .memberName("Error")
            .getter(getter(GetBucketMetadataTableConfigurationResult::error))
            .setter(setter(Builder::error))
            .constructor(ErrorDetails::builder)
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("Error")
                    .unmarshallLocationName("Error").build()).build();

    private static final List<SdkField<?>> SDK_FIELDS = Collections.unmodifiableList(Arrays.asList(
            METADATA_TABLE_CONFIGURATION_RESULT_FIELD, STATUS_FIELD, ERROR_FIELD));

    private static final Map<String, SdkField<?>> SDK_NAME_TO_FIELD = memberNameToFieldInitializer();

    private static final long serialVersionUID = 1L;

    private final MetadataTableConfigurationResult metadataTableConfigurationResult;

    private final String status;

    private final ErrorDetails error;

    private GetBucketMetadataTableConfigurationResult(BuilderImpl builder) {
        this.metadataTableConfigurationResult = builder.metadataTableConfigurationResult;
        this.status = builder.status;
        this.error = builder.error;
    }

    /**
     * <p>
     * The metadata table configuration for a general purpose bucket.
     * </p>
     * 
     * @return The metadata table configuration for a general purpose bucket.
     */
    public final MetadataTableConfigurationResult metadataTableConfigurationResult() {
        return metadataTableConfigurationResult;
    }

    /**
     * <p>
     * The status of the metadata table. The status values are:
     * </p>
     * <ul>
     * <li>
     * <p>
     * <code>CREATING</code> - The metadata table is in the process of being created in the specified table bucket.
     * </p>
     * </li>
     * <li>
     * <p>
     * <code>ACTIVE</code> - The metadata table has been created successfully and records are being delivered to the
     * table.
     * </p>
     * </li>
     * <li>
     * <p>
     * <code>FAILED</code> - Amazon S3 is unable to create the metadata table, or Amazon S3 is unable to deliver
     * records. See <code>ErrorDetails</code> for details.
     * </p>
     * </li>
     * </ul>
     * 
     * @return The status of the metadata table. The status values are: </p>
     *         <ul>
     *         <li>
     *         <p>
     *         <code>CREATING</code> - The metadata table is in the process of being created in the specified table
     *         bucket.
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         <code>ACTIVE</code> - The metadata table has been created successfully and records are being delivered to
     *         the table.
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         <code>FAILED</code> - Amazon S3 is unable to create the metadata table, or Amazon S3 is unable to deliver
     *         records. See <code>ErrorDetails</code> for details.
     *         </p>
     *         </li>
     */
    public final String status() {
        return status;
    }

    /**
     * <p>
     * If the <code>CreateBucketMetadataTableConfiguration</code> request succeeds, but S3 Metadata was unable to create
     * the table, this structure contains the error code and error message.
     * </p>
     * 
     * @return If the <code>CreateBucketMetadataTableConfiguration</code> request succeeds, but S3 Metadata was unable
     *         to create the table, this structure contains the error code and error message.
     */
    public final ErrorDetails error() {
        return error;
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
        hashCode = 31 * hashCode + Objects.hashCode(metadataTableConfigurationResult());
        hashCode = 31 * hashCode + Objects.hashCode(status());
        hashCode = 31 * hashCode + Objects.hashCode(error());
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
        if (!(obj instanceof GetBucketMetadataTableConfigurationResult)) {
            return false;
        }
        GetBucketMetadataTableConfigurationResult other = (GetBucketMetadataTableConfigurationResult) obj;
        return Objects.equals(metadataTableConfigurationResult(), other.metadataTableConfigurationResult())
                && Objects.equals(status(), other.status()) && Objects.equals(error(), other.error());
    }

    /**
     * Returns a string representation of this object. This is useful for testing and debugging. Sensitive data will be
     * redacted from this string using a placeholder value.
     */
    @Override
    public final String toString() {
        return ToString.builder("GetBucketMetadataTableConfigurationResult")
                .add("MetadataTableConfigurationResult", metadataTableConfigurationResult()).add("Status", status())
                .add("Error", error()).build();
    }

    public final <T> Optional<T> getValueForField(String fieldName, Class<T> clazz) {
        switch (fieldName) {
        case "MetadataTableConfigurationResult":
            return Optional.ofNullable(clazz.cast(metadataTableConfigurationResult()));
        case "Status":
            return Optional.ofNullable(clazz.cast(status()));
        case "Error":
            return Optional.ofNullable(clazz.cast(error()));
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
        map.put("MetadataTableConfigurationResult", METADATA_TABLE_CONFIGURATION_RESULT_FIELD);
        map.put("Status", STATUS_FIELD);
        map.put("Error", ERROR_FIELD);
        return Collections.unmodifiableMap(map);
    }

    private static <T> Function<Object, T> getter(Function<GetBucketMetadataTableConfigurationResult, T> g) {
        return obj -> g.apply((GetBucketMetadataTableConfigurationResult) obj);
    }

    private static <T> BiConsumer<Object, T> setter(BiConsumer<Builder, T> s) {
        return (obj, val) -> s.accept((Builder) obj, val);
    }

    @Mutable
    @NotThreadSafe
    public interface Builder extends SdkPojo, CopyableBuilder<Builder, GetBucketMetadataTableConfigurationResult> {
        /**
         * <p>
         * The metadata table configuration for a general purpose bucket.
         * </p>
         * 
         * @param metadataTableConfigurationResult
         *        The metadata table configuration for a general purpose bucket.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder metadataTableConfigurationResult(MetadataTableConfigurationResult metadataTableConfigurationResult);

        /**
         * <p>
         * The metadata table configuration for a general purpose bucket.
         * </p>
         * This is a convenience method that creates an instance of the {@link MetadataTableConfigurationResult.Builder}
         * avoiding the need to create one manually via {@link MetadataTableConfigurationResult#builder()}.
         *
         * <p>
         * When the {@link Consumer} completes, {@link MetadataTableConfigurationResult.Builder#build()} is called
         * immediately and its result is passed to
         * {@link #metadataTableConfigurationResult(MetadataTableConfigurationResult)}.
         * 
         * @param metadataTableConfigurationResult
         *        a consumer that will call methods on {@link MetadataTableConfigurationResult.Builder}
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see #metadataTableConfigurationResult(MetadataTableConfigurationResult)
         */
        default Builder metadataTableConfigurationResult(
                Consumer<MetadataTableConfigurationResult.Builder> metadataTableConfigurationResult) {
            return metadataTableConfigurationResult(MetadataTableConfigurationResult.builder()
                    .applyMutation(metadataTableConfigurationResult).build());
        }

        /**
         * <p>
         * The status of the metadata table. The status values are:
         * </p>
         * <ul>
         * <li>
         * <p>
         * <code>CREATING</code> - The metadata table is in the process of being created in the specified table bucket.
         * </p>
         * </li>
         * <li>
         * <p>
         * <code>ACTIVE</code> - The metadata table has been created successfully and records are being delivered to the
         * table.
         * </p>
         * </li>
         * <li>
         * <p>
         * <code>FAILED</code> - Amazon S3 is unable to create the metadata table, or Amazon S3 is unable to deliver
         * records. See <code>ErrorDetails</code> for details.
         * </p>
         * </li>
         * </ul>
         * 
         * @param status
         *        The status of the metadata table. The status values are: </p>
         *        <ul>
         *        <li>
         *        <p>
         *        <code>CREATING</code> - The metadata table is in the process of being created in the specified table
         *        bucket.
         *        </p>
         *        </li>
         *        <li>
         *        <p>
         *        <code>ACTIVE</code> - The metadata table has been created successfully and records are being delivered
         *        to the table.
         *        </p>
         *        </li>
         *        <li>
         *        <p>
         *        <code>FAILED</code> - Amazon S3 is unable to create the metadata table, or Amazon S3 is unable to
         *        deliver records. See <code>ErrorDetails</code> for details.
         *        </p>
         *        </li>
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder status(String status);

        /**
         * <p>
         * If the <code>CreateBucketMetadataTableConfiguration</code> request succeeds, but S3 Metadata was unable to
         * create the table, this structure contains the error code and error message.
         * </p>
         * 
         * @param error
         *        If the <code>CreateBucketMetadataTableConfiguration</code> request succeeds, but S3 Metadata was
         *        unable to create the table, this structure contains the error code and error message.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder error(ErrorDetails error);

        /**
         * <p>
         * If the <code>CreateBucketMetadataTableConfiguration</code> request succeeds, but S3 Metadata was unable to
         * create the table, this structure contains the error code and error message.
         * </p>
         * This is a convenience method that creates an instance of the {@link ErrorDetails.Builder} avoiding the need
         * to create one manually via {@link ErrorDetails#builder()}.
         *
         * <p>
         * When the {@link Consumer} completes, {@link ErrorDetails.Builder#build()} is called immediately and its
         * result is passed to {@link #error(ErrorDetails)}.
         * 
         * @param error
         *        a consumer that will call methods on {@link ErrorDetails.Builder}
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see #error(ErrorDetails)
         */
        default Builder error(Consumer<ErrorDetails.Builder> error) {
            return error(ErrorDetails.builder().applyMutation(error).build());
        }
    }

    static final class BuilderImpl implements Builder {
        private MetadataTableConfigurationResult metadataTableConfigurationResult;

        private String status;

        private ErrorDetails error;

        private BuilderImpl() {
        }

        private BuilderImpl(GetBucketMetadataTableConfigurationResult model) {
            metadataTableConfigurationResult(model.metadataTableConfigurationResult);
            status(model.status);
            error(model.error);
        }

        public final MetadataTableConfigurationResult.Builder getMetadataTableConfigurationResult() {
            return metadataTableConfigurationResult != null ? metadataTableConfigurationResult.toBuilder() : null;
        }

        public final void setMetadataTableConfigurationResult(
                MetadataTableConfigurationResult.BuilderImpl metadataTableConfigurationResult) {
            this.metadataTableConfigurationResult = metadataTableConfigurationResult != null ? metadataTableConfigurationResult
                    .build() : null;
        }

        @Override
        public final Builder metadataTableConfigurationResult(MetadataTableConfigurationResult metadataTableConfigurationResult) {
            this.metadataTableConfigurationResult = metadataTableConfigurationResult;
            return this;
        }

        public final String getStatus() {
            return status;
        }

        public final void setStatus(String status) {
            this.status = status;
        }

        @Override
        public final Builder status(String status) {
            this.status = status;
            return this;
        }

        public final ErrorDetails.Builder getError() {
            return error != null ? error.toBuilder() : null;
        }

        public final void setError(ErrorDetails.BuilderImpl error) {
            this.error = error != null ? error.build() : null;
        }

        @Override
        public final Builder error(ErrorDetails error) {
            this.error = error;
            return this;
        }

        @Override
        public GetBucketMetadataTableConfigurationResult build() {
            return new GetBucketMetadataTableConfigurationResult(this);
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
