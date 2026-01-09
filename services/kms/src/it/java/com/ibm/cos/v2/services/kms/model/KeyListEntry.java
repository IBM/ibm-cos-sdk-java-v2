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
 * Contains information about each entry in the key list.
 * </p>
 */
@Generated("com.ibm.cos.v2:codegen")
public final class KeyListEntry implements SdkPojo, Serializable, ToCopyableBuilder<KeyListEntry.Builder, KeyListEntry> {
    private static final SdkField<String> KEY_ID_FIELD = SdkField.<String> builder(MarshallingType.STRING).memberName("KeyId")
            .getter(getter(KeyListEntry::keyId)).setter(setter(Builder::keyId))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("KeyId").build()).build();

    private static final SdkField<String> KEY_ARN_FIELD = SdkField.<String> builder(MarshallingType.STRING).memberName("KeyArn")
            .getter(getter(KeyListEntry::keyArn)).setter(setter(Builder::keyArn))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("KeyArn").build()).build();

    private static final List<SdkField<?>> SDK_FIELDS = Collections.unmodifiableList(Arrays.asList(KEY_ID_FIELD, KEY_ARN_FIELD));

    private static final Map<String, SdkField<?>> SDK_NAME_TO_FIELD = memberNameToFieldInitializer();

    private static final long serialVersionUID = 1L;

    private final String keyId;

    private final String keyArn;

    private KeyListEntry(BuilderImpl builder) {
        this.keyId = builder.keyId;
        this.keyArn = builder.keyArn;
    }

    /**
     * <p>
     * Unique identifier of the key.
     * </p>
     * 
     * @return Unique identifier of the key.
     */
    public final String keyId() {
        return keyId;
    }

    /**
     * <p>
     * ARN of the key.
     * </p>
     * 
     * @return ARN of the key.
     */
    public final String keyArn() {
        return keyArn;
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
        hashCode = 31 * hashCode + Objects.hashCode(keyId());
        hashCode = 31 * hashCode + Objects.hashCode(keyArn());
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
        if (!(obj instanceof KeyListEntry)) {
            return false;
        }
        KeyListEntry other = (KeyListEntry) obj;
        return Objects.equals(keyId(), other.keyId()) && Objects.equals(keyArn(), other.keyArn());
    }

    /**
     * Returns a string representation of this object. This is useful for testing and debugging. Sensitive data will be
     * redacted from this string using a placeholder value.
     */
    @Override
    public final String toString() {
        return ToString.builder("KeyListEntry").add("KeyId", keyId()).add("KeyArn", keyArn()).build();
    }

    public final <T> Optional<T> getValueForField(String fieldName, Class<T> clazz) {
        switch (fieldName) {
        case "KeyId":
            return Optional.ofNullable(clazz.cast(keyId()));
        case "KeyArn":
            return Optional.ofNullable(clazz.cast(keyArn()));
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
        map.put("KeyId", KEY_ID_FIELD);
        map.put("KeyArn", KEY_ARN_FIELD);
        return Collections.unmodifiableMap(map);
    }

    private static <T> Function<Object, T> getter(Function<KeyListEntry, T> g) {
        return obj -> g.apply((KeyListEntry) obj);
    }

    private static <T> BiConsumer<Object, T> setter(BiConsumer<Builder, T> s) {
        return (obj, val) -> s.accept((Builder) obj, val);
    }

    @Mutable
    @NotThreadSafe
    public interface Builder extends SdkPojo, CopyableBuilder<Builder, KeyListEntry> {
        /**
         * <p>
         * Unique identifier of the key.
         * </p>
         * 
         * @param keyId
         *        Unique identifier of the key.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder keyId(String keyId);

        /**
         * <p>
         * ARN of the key.
         * </p>
         * 
         * @param keyArn
         *        ARN of the key.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder keyArn(String keyArn);
    }

    static final class BuilderImpl implements Builder {
        private String keyId;

        private String keyArn;

        private BuilderImpl() {
        }

        private BuilderImpl(KeyListEntry model) {
            keyId(model.keyId);
            keyArn(model.keyArn);
        }

        public final String getKeyId() {
            return keyId;
        }

        public final void setKeyId(String keyId) {
            this.keyId = keyId;
        }

        @Override
        public final Builder keyId(String keyId) {
            this.keyId = keyId;
            return this;
        }

        public final String getKeyArn() {
            return keyArn;
        }

        public final void setKeyArn(String keyArn) {
            this.keyArn = keyArn;
        }

        @Override
        public final Builder keyArn(String keyArn) {
            this.keyArn = keyArn;
            return this;
        }

        @Override
        public KeyListEntry build() {
            return new KeyListEntry(this);
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
