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

package com.ibm.cos.v2.services.kms.model;

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
import com.ibm.cos.v2.utils.ToString;
import com.ibm.cos.v2.utils.builder.CopyableBuilder;
import com.ibm.cos.v2.utils.builder.ToCopyableBuilder;

/**
 */
@Generated("com.ibm.cos.v2:codegen")
public final class CreateKeyResponse extends KmsResponse implements
        ToCopyableBuilder<CreateKeyResponse.Builder, CreateKeyResponse> {
    private static final SdkField<KeyMetadata> KEY_METADATA_FIELD = SdkField.<KeyMetadata> builder(MarshallingType.SDK_POJO)
            .memberName("KeyMetadata").getter(getter(CreateKeyResponse::keyMetadata)).setter(setter(Builder::keyMetadata))
            .constructor(KeyMetadata::builder)
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("KeyMetadata").build()).build();

    private static final List<SdkField<?>> SDK_FIELDS = Collections.unmodifiableList(Arrays.asList(KEY_METADATA_FIELD));

    private static final Map<String, SdkField<?>> SDK_NAME_TO_FIELD = memberNameToFieldInitializer();

    private final KeyMetadata keyMetadata;

    private CreateKeyResponse(BuilderImpl builder) {
        super(builder);
        this.keyMetadata = builder.keyMetadata;
    }

    /**
     * <p>
     * Metadata associated with the KMS key.
     * </p>
     * 
     * @return Metadata associated with the KMS key.
     */
    public final KeyMetadata keyMetadata() {
        return keyMetadata;
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
        hashCode = 31 * hashCode + Objects.hashCode(keyMetadata());
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
        if (!(obj instanceof CreateKeyResponse)) {
            return false;
        }
        CreateKeyResponse other = (CreateKeyResponse) obj;
        return Objects.equals(keyMetadata(), other.keyMetadata());
    }

    /**
     * Returns a string representation of this object. This is useful for testing and debugging. Sensitive data will be
     * redacted from this string using a placeholder value.
     */
    @Override
    public final String toString() {
        return ToString.builder("CreateKeyResponse").add("KeyMetadata", keyMetadata()).build();
    }

    public final <T> Optional<T> getValueForField(String fieldName, Class<T> clazz) {
        switch (fieldName) {
        case "KeyMetadata":
            return Optional.ofNullable(clazz.cast(keyMetadata()));
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
        map.put("KeyMetadata", KEY_METADATA_FIELD);
        return Collections.unmodifiableMap(map);
    }

    private static <T> Function<Object, T> getter(Function<CreateKeyResponse, T> g) {
        return obj -> g.apply((CreateKeyResponse) obj);
    }

    private static <T> BiConsumer<Object, T> setter(BiConsumer<Builder, T> s) {
        return (obj, val) -> s.accept((Builder) obj, val);
    }

    @Mutable
    @NotThreadSafe
    public interface Builder extends KmsResponse.Builder, SdkPojo, CopyableBuilder<Builder, CreateKeyResponse> {
        /**
         * <p>
         * Metadata associated with the KMS key.
         * </p>
         * 
         * @param keyMetadata
         *        Metadata associated with the KMS key.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder keyMetadata(KeyMetadata keyMetadata);

        /**
         * <p>
         * Metadata associated with the KMS key.
         * </p>
         * This is a convenience method that creates an instance of the {@link KeyMetadata.Builder} avoiding the need to
         * create one manually via {@link KeyMetadata#builder()}.
         *
         * <p>
         * When the {@link Consumer} completes, {@link KeyMetadata.Builder#build()} is called immediately and its result
         * is passed to {@link #keyMetadata(KeyMetadata)}.
         * 
         * @param keyMetadata
         *        a consumer that will call methods on {@link KeyMetadata.Builder}
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see #keyMetadata(KeyMetadata)
         */
        default Builder keyMetadata(Consumer<KeyMetadata.Builder> keyMetadata) {
            return keyMetadata(KeyMetadata.builder().applyMutation(keyMetadata).build());
        }
    }

    static final class BuilderImpl extends KmsResponse.BuilderImpl implements Builder {
        private KeyMetadata keyMetadata;

        private BuilderImpl() {
        }

        private BuilderImpl(CreateKeyResponse model) {
            super(model);
            keyMetadata(model.keyMetadata);
        }

        public final KeyMetadata.Builder getKeyMetadata() {
            return keyMetadata != null ? keyMetadata.toBuilder() : null;
        }

        public final void setKeyMetadata(KeyMetadata.BuilderImpl keyMetadata) {
            this.keyMetadata = keyMetadata != null ? keyMetadata.build() : null;
        }

        @Override
        public final Builder keyMetadata(KeyMetadata keyMetadata) {
            this.keyMetadata = keyMetadata;
            return this;
        }

        @Override
        public CreateKeyResponse build() {
            return new CreateKeyResponse(this);
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
