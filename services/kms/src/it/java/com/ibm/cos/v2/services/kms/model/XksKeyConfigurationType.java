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
 * Information about the <a
 * href="https://docs.aws.amazon.com/kms/latest/developerguide/keystore-external.html#concept-external-key">external key
 * </a>that is associated with a KMS key in an external key store.
 * </p>
 * <p>
 * This element appears in a <a>CreateKey</a> or <a>DescribeKey</a> response only for a KMS key in an external key
 * store.
 * </p>
 * <p>
 * The <i>external key</i> is a symmetric encryption key that is hosted by an external key manager outside of Amazon Web
 * Services. When you use the KMS key in an external key store in a cryptographic operation, the cryptographic operation
 * is performed in the external key manager using the specified external key. For more information, see <a
 * href="https://docs.aws.amazon.com/kms/latest/developerguide/keystore-external.html#concept-external-key">External
 * key</a> in the <i>Key Management Service Developer Guide</i>.
 * </p>
 */
@Generated("com.ibm.cos.v2:codegen")
public final class XksKeyConfigurationType implements SdkPojo, Serializable,
        ToCopyableBuilder<XksKeyConfigurationType.Builder, XksKeyConfigurationType> {
    private static final SdkField<String> ID_FIELD = SdkField.<String> builder(MarshallingType.STRING).memberName("Id")
            .getter(getter(XksKeyConfigurationType::id)).setter(setter(Builder::id))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("Id").build()).build();

    private static final List<SdkField<?>> SDK_FIELDS = Collections.unmodifiableList(Arrays.asList(ID_FIELD));

    private static final Map<String, SdkField<?>> SDK_NAME_TO_FIELD = memberNameToFieldInitializer();

    private static final long serialVersionUID = 1L;

    private final String id;

    private XksKeyConfigurationType(BuilderImpl builder) {
        this.id = builder.id;
    }

    /**
     * <p>
     * The ID of the external key in its external key manager. This is the ID that the external key store proxy uses to
     * identify the external key.
     * </p>
     * 
     * @return The ID of the external key in its external key manager. This is the ID that the external key store proxy
     *         uses to identify the external key.
     */
    public final String id() {
        return id;
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
        hashCode = 31 * hashCode + Objects.hashCode(id());
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
        if (!(obj instanceof XksKeyConfigurationType)) {
            return false;
        }
        XksKeyConfigurationType other = (XksKeyConfigurationType) obj;
        return Objects.equals(id(), other.id());
    }

    /**
     * Returns a string representation of this object. This is useful for testing and debugging. Sensitive data will be
     * redacted from this string using a placeholder value.
     */
    @Override
    public final String toString() {
        return ToString.builder("XksKeyConfigurationType").add("Id", id()).build();
    }

    public final <T> Optional<T> getValueForField(String fieldName, Class<T> clazz) {
        switch (fieldName) {
        case "Id":
            return Optional.ofNullable(clazz.cast(id()));
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
        map.put("Id", ID_FIELD);
        return Collections.unmodifiableMap(map);
    }

    private static <T> Function<Object, T> getter(Function<XksKeyConfigurationType, T> g) {
        return obj -> g.apply((XksKeyConfigurationType) obj);
    }

    private static <T> BiConsumer<Object, T> setter(BiConsumer<Builder, T> s) {
        return (obj, val) -> s.accept((Builder) obj, val);
    }

    @Mutable
    @NotThreadSafe
    public interface Builder extends SdkPojo, CopyableBuilder<Builder, XksKeyConfigurationType> {
        /**
         * <p>
         * The ID of the external key in its external key manager. This is the ID that the external key store proxy uses
         * to identify the external key.
         * </p>
         * 
         * @param id
         *        The ID of the external key in its external key manager. This is the ID that the external key store
         *        proxy uses to identify the external key.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder id(String id);
    }

    static final class BuilderImpl implements Builder {
        private String id;

        private BuilderImpl() {
        }

        private BuilderImpl(XksKeyConfigurationType model) {
            id(model.id);
        }

        public final String getId() {
            return id;
        }

        public final void setId(String id) {
            this.id = id;
        }

        @Override
        public final Builder id(String id) {
            this.id = id;
            return this;
        }

        @Override
        public XksKeyConfigurationType build() {
            return new XksKeyConfigurationType(this);
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
