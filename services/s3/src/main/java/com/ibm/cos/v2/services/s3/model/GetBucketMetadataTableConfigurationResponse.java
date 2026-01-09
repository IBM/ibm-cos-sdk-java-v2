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
import com.ibm.cos.v2.core.SdkField;
import com.ibm.cos.v2.core.SdkPojo;
import com.ibm.cos.v2.core.protocol.MarshallLocation;
import com.ibm.cos.v2.core.protocol.MarshallingType;
import com.ibm.cos.v2.core.traits.LocationTrait;
import com.ibm.cos.v2.core.traits.PayloadTrait;
import com.ibm.cos.v2.utils.ToString;
import com.ibm.cos.v2.utils.builder.CopyableBuilder;
import com.ibm.cos.v2.utils.builder.ToCopyableBuilder;

/**
 */
@Generated("com.ibm.cos.v2:codegen")
public final class GetBucketMetadataTableConfigurationResponse extends S3Response implements
        ToCopyableBuilder<GetBucketMetadataTableConfigurationResponse.Builder, GetBucketMetadataTableConfigurationResponse> {
    private static final SdkField<GetBucketMetadataTableConfigurationResult> GET_BUCKET_METADATA_TABLE_CONFIGURATION_RESULT_FIELD = SdkField
            .<GetBucketMetadataTableConfigurationResult> builder(MarshallingType.SDK_POJO)
            .memberName("GetBucketMetadataTableConfigurationResult")
            .getter(getter(GetBucketMetadataTableConfigurationResponse::getBucketMetadataTableConfigurationResult))
            .setter(setter(Builder::getBucketMetadataTableConfigurationResult))
            .constructor(GetBucketMetadataTableConfigurationResult::builder)
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD)
                    .locationName("GetBucketMetadataTableConfigurationResult")
                    .unmarshallLocationName("GetBucketMetadataTableConfigurationResult").build(), PayloadTrait.create()).build();

    private static final List<SdkField<?>> SDK_FIELDS = Collections.unmodifiableList(Arrays
            .asList(GET_BUCKET_METADATA_TABLE_CONFIGURATION_RESULT_FIELD));

    private static final Map<String, SdkField<?>> SDK_NAME_TO_FIELD = memberNameToFieldInitializer();

    private final GetBucketMetadataTableConfigurationResult getBucketMetadataTableConfigurationResult;

    private GetBucketMetadataTableConfigurationResponse(BuilderImpl builder) {
        super(builder);
        this.getBucketMetadataTableConfigurationResult = builder.getBucketMetadataTableConfigurationResult;
    }

    /**
     * <p>
     * The metadata table configuration for the general purpose bucket.
     * </p>
     * 
     * @return The metadata table configuration for the general purpose bucket.
     */
    public final GetBucketMetadataTableConfigurationResult getBucketMetadataTableConfigurationResult() {
        return getBucketMetadataTableConfigurationResult;
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
        hashCode = 31 * hashCode + Objects.hashCode(getBucketMetadataTableConfigurationResult());
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
        if (!(obj instanceof GetBucketMetadataTableConfigurationResponse)) {
            return false;
        }
        GetBucketMetadataTableConfigurationResponse other = (GetBucketMetadataTableConfigurationResponse) obj;
        return Objects.equals(getBucketMetadataTableConfigurationResult(), other.getBucketMetadataTableConfigurationResult());
    }

    /**
     * Returns a string representation of this object. This is useful for testing and debugging. Sensitive data will be
     * redacted from this string using a placeholder value.
     */
    @Override
    public final String toString() {
        return ToString.builder("GetBucketMetadataTableConfigurationResponse")
                .add("GetBucketMetadataTableConfigurationResult", getBucketMetadataTableConfigurationResult()).build();
    }

    public final <T> Optional<T> getValueForField(String fieldName, Class<T> clazz) {
        switch (fieldName) {
        case "GetBucketMetadataTableConfigurationResult":
            return Optional.ofNullable(clazz.cast(getBucketMetadataTableConfigurationResult()));
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
        map.put("GetBucketMetadataTableConfigurationResult", GET_BUCKET_METADATA_TABLE_CONFIGURATION_RESULT_FIELD);
        return Collections.unmodifiableMap(map);
    }

    private static <T> Function<Object, T> getter(Function<GetBucketMetadataTableConfigurationResponse, T> g) {
        return obj -> g.apply((GetBucketMetadataTableConfigurationResponse) obj);
    }

    private static <T> BiConsumer<Object, T> setter(BiConsumer<Builder, T> s) {
        return (obj, val) -> s.accept((Builder) obj, val);
    }

    @Mutable
    @NotThreadSafe
    public interface Builder extends S3Response.Builder, SdkPojo,
            CopyableBuilder<Builder, GetBucketMetadataTableConfigurationResponse> {
        /**
         * <p>
         * The metadata table configuration for the general purpose bucket.
         * </p>
         * 
         * @param getBucketMetadataTableConfigurationResult
         *        The metadata table configuration for the general purpose bucket.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder getBucketMetadataTableConfigurationResult(
                GetBucketMetadataTableConfigurationResult getBucketMetadataTableConfigurationResult);

        /**
         * <p>
         * The metadata table configuration for the general purpose bucket.
         * </p>
         * This is a convenience method that creates an instance of the
         * {@link GetBucketMetadataTableConfigurationResult.Builder} avoiding the need to create one manually via
         * {@link GetBucketMetadataTableConfigurationResult#builder()}.
         *
         * <p>
         * When the {@link Consumer} completes, {@link GetBucketMetadataTableConfigurationResult.Builder#build()} is
         * called immediately and its result is passed to
         * {@link #getBucketMetadataTableConfigurationResult(GetBucketMetadataTableConfigurationResult)}.
         * 
         * @param getBucketMetadataTableConfigurationResult
         *        a consumer that will call methods on {@link GetBucketMetadataTableConfigurationResult.Builder}
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see #getBucketMetadataTableConfigurationResult(GetBucketMetadataTableConfigurationResult)
         */
        default Builder getBucketMetadataTableConfigurationResult(
                Consumer<GetBucketMetadataTableConfigurationResult.Builder> getBucketMetadataTableConfigurationResult) {
            return getBucketMetadataTableConfigurationResult(GetBucketMetadataTableConfigurationResult.builder()
                    .applyMutation(getBucketMetadataTableConfigurationResult).build());
        }
    }

    static final class BuilderImpl extends S3Response.BuilderImpl implements Builder {
        private GetBucketMetadataTableConfigurationResult getBucketMetadataTableConfigurationResult;

        private BuilderImpl() {
        }

        private BuilderImpl(GetBucketMetadataTableConfigurationResponse model) {
            super(model);
            getBucketMetadataTableConfigurationResult(model.getBucketMetadataTableConfigurationResult);
        }

        public final GetBucketMetadataTableConfigurationResult.Builder getGetBucketMetadataTableConfigurationResult() {
            return getBucketMetadataTableConfigurationResult != null ? getBucketMetadataTableConfigurationResult.toBuilder()
                    : null;
        }

        public final void setGetBucketMetadataTableConfigurationResult(
                GetBucketMetadataTableConfigurationResult.BuilderImpl getBucketMetadataTableConfigurationResult) {
            this.getBucketMetadataTableConfigurationResult = getBucketMetadataTableConfigurationResult != null ? getBucketMetadataTableConfigurationResult
                    .build() : null;
        }

        @Override
        public final Builder getBucketMetadataTableConfigurationResult(
                GetBucketMetadataTableConfigurationResult getBucketMetadataTableConfigurationResult) {
            this.getBucketMetadataTableConfigurationResult = getBucketMetadataTableConfigurationResult;
            return this;
        }

        @Override
        public GetBucketMetadataTableConfigurationResponse build() {
            return new GetBucketMetadataTableConfigurationResponse(this);
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
