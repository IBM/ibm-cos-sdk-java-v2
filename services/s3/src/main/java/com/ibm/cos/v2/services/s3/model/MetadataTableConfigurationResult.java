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
 * The metadata table configuration for a general purpose bucket. The destination table bucket must be in the same
 * Region and Amazon Web Services account as the general purpose bucket. The specified metadata table name must be
 * unique within the <code>aws_s3_metadata</code> namespace in the destination table bucket.
 * </p>
 */
@Generated("com.ibm.cos.v2:codegen")
public final class MetadataTableConfigurationResult implements SdkPojo, Serializable,
        ToCopyableBuilder<MetadataTableConfigurationResult.Builder, MetadataTableConfigurationResult> {
    private static final SdkField<S3TablesDestinationResult> S3_TABLES_DESTINATION_RESULT_FIELD = SdkField
            .<S3TablesDestinationResult> builder(MarshallingType.SDK_POJO)
            .memberName("S3TablesDestinationResult")
            .getter(getter(MetadataTableConfigurationResult::s3TablesDestinationResult))
            .setter(setter(Builder::s3TablesDestinationResult))
            .constructor(S3TablesDestinationResult::builder)
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("S3TablesDestinationResult")
                    .unmarshallLocationName("S3TablesDestinationResult").build(), RequiredTrait.create()).build();

    private static final List<SdkField<?>> SDK_FIELDS = Collections.unmodifiableList(Arrays
            .asList(S3_TABLES_DESTINATION_RESULT_FIELD));

    private static final Map<String, SdkField<?>> SDK_NAME_TO_FIELD = memberNameToFieldInitializer();

    private static final long serialVersionUID = 1L;

    private final S3TablesDestinationResult s3TablesDestinationResult;

    private MetadataTableConfigurationResult(BuilderImpl builder) {
        this.s3TablesDestinationResult = builder.s3TablesDestinationResult;
    }

    /**
     * <p>
     * The destination information for the metadata table configuration. The destination table bucket must be in the
     * same Region and Amazon Web Services account as the general purpose bucket. The specified metadata table name must
     * be unique within the <code>aws_s3_metadata</code> namespace in the destination table bucket.
     * </p>
     * 
     * @return The destination information for the metadata table configuration. The destination table bucket must be in
     *         the same Region and Amazon Web Services account as the general purpose bucket. The specified metadata
     *         table name must be unique within the <code>aws_s3_metadata</code> namespace in the destination table
     *         bucket.
     */
    public final S3TablesDestinationResult s3TablesDestinationResult() {
        return s3TablesDestinationResult;
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
        hashCode = 31 * hashCode + Objects.hashCode(s3TablesDestinationResult());
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
        if (!(obj instanceof MetadataTableConfigurationResult)) {
            return false;
        }
        MetadataTableConfigurationResult other = (MetadataTableConfigurationResult) obj;
        return Objects.equals(s3TablesDestinationResult(), other.s3TablesDestinationResult());
    }

    /**
     * Returns a string representation of this object. This is useful for testing and debugging. Sensitive data will be
     * redacted from this string using a placeholder value.
     */
    @Override
    public final String toString() {
        return ToString.builder("MetadataTableConfigurationResult").add("S3TablesDestinationResult", s3TablesDestinationResult())
                .build();
    }

    public final <T> Optional<T> getValueForField(String fieldName, Class<T> clazz) {
        switch (fieldName) {
        case "S3TablesDestinationResult":
            return Optional.ofNullable(clazz.cast(s3TablesDestinationResult()));
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
        map.put("S3TablesDestinationResult", S3_TABLES_DESTINATION_RESULT_FIELD);
        return Collections.unmodifiableMap(map);
    }

    private static <T> Function<Object, T> getter(Function<MetadataTableConfigurationResult, T> g) {
        return obj -> g.apply((MetadataTableConfigurationResult) obj);
    }

    private static <T> BiConsumer<Object, T> setter(BiConsumer<Builder, T> s) {
        return (obj, val) -> s.accept((Builder) obj, val);
    }

    @Mutable
    @NotThreadSafe
    public interface Builder extends SdkPojo, CopyableBuilder<Builder, MetadataTableConfigurationResult> {
        /**
         * <p>
         * The destination information for the metadata table configuration. The destination table bucket must be in the
         * same Region and Amazon Web Services account as the general purpose bucket. The specified metadata table name
         * must be unique within the <code>aws_s3_metadata</code> namespace in the destination table bucket.
         * </p>
         * 
         * @param s3TablesDestinationResult
         *        The destination information for the metadata table configuration. The destination table bucket must be
         *        in the same Region and Amazon Web Services account as the general purpose bucket. The specified
         *        metadata table name must be unique within the <code>aws_s3_metadata</code> namespace in the
         *        destination table bucket.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder s3TablesDestinationResult(S3TablesDestinationResult s3TablesDestinationResult);

        /**
         * <p>
         * The destination information for the metadata table configuration. The destination table bucket must be in the
         * same Region and Amazon Web Services account as the general purpose bucket. The specified metadata table name
         * must be unique within the <code>aws_s3_metadata</code> namespace in the destination table bucket.
         * </p>
         * This is a convenience method that creates an instance of the {@link S3TablesDestinationResult.Builder}
         * avoiding the need to create one manually via {@link S3TablesDestinationResult#builder()}.
         *
         * <p>
         * When the {@link Consumer} completes, {@link S3TablesDestinationResult.Builder#build()} is called immediately
         * and its result is passed to {@link #s3TablesDestinationResult(S3TablesDestinationResult)}.
         * 
         * @param s3TablesDestinationResult
         *        a consumer that will call methods on {@link S3TablesDestinationResult.Builder}
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see #s3TablesDestinationResult(S3TablesDestinationResult)
         */
        default Builder s3TablesDestinationResult(Consumer<S3TablesDestinationResult.Builder> s3TablesDestinationResult) {
            return s3TablesDestinationResult(S3TablesDestinationResult.builder().applyMutation(s3TablesDestinationResult).build());
        }
    }

    static final class BuilderImpl implements Builder {
        private S3TablesDestinationResult s3TablesDestinationResult;

        private BuilderImpl() {
        }

        private BuilderImpl(MetadataTableConfigurationResult model) {
            s3TablesDestinationResult(model.s3TablesDestinationResult);
        }

        public final S3TablesDestinationResult.Builder getS3TablesDestinationResult() {
            return s3TablesDestinationResult != null ? s3TablesDestinationResult.toBuilder() : null;
        }

        public final void setS3TablesDestinationResult(S3TablesDestinationResult.BuilderImpl s3TablesDestinationResult) {
            this.s3TablesDestinationResult = s3TablesDestinationResult != null ? s3TablesDestinationResult.build() : null;
        }

        @Override
        public final Builder s3TablesDestinationResult(S3TablesDestinationResult s3TablesDestinationResult) {
            this.s3TablesDestinationResult = s3TablesDestinationResult;
            return this;
        }

        @Override
        public MetadataTableConfigurationResult build() {
            return new MetadataTableConfigurationResult(this);
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
