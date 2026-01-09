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
 * KMS uses the authentication credential to sign requests that it sends to the external key store proxy (XKS proxy) on
 * your behalf. You establish these credentials on your external key store proxy and report them to KMS.
 * </p>
 * <p>
 * The <code>XksProxyAuthenticationCredential</code> includes two required elements.
 * </p>
 */
@Generated("com.ibm.cos.v2:codegen")
public final class XksProxyAuthenticationCredentialType implements SdkPojo, Serializable,
        ToCopyableBuilder<XksProxyAuthenticationCredentialType.Builder, XksProxyAuthenticationCredentialType> {
    private static final SdkField<String> ACCESS_KEY_ID_FIELD = SdkField.<String> builder(MarshallingType.STRING)
            .memberName("AccessKeyId").getter(getter(XksProxyAuthenticationCredentialType::accessKeyId))
            .setter(setter(Builder::accessKeyId))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("AccessKeyId").build()).build();

    private static final SdkField<String> RAW_SECRET_ACCESS_KEY_FIELD = SdkField.<String> builder(MarshallingType.STRING)
            .memberName("RawSecretAccessKey").getter(getter(XksProxyAuthenticationCredentialType::rawSecretAccessKey))
            .setter(setter(Builder::rawSecretAccessKey))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("RawSecretAccessKey").build())
            .build();

    private static final List<SdkField<?>> SDK_FIELDS = Collections.unmodifiableList(Arrays.asList(ACCESS_KEY_ID_FIELD,
            RAW_SECRET_ACCESS_KEY_FIELD));

    private static final Map<String, SdkField<?>> SDK_NAME_TO_FIELD = memberNameToFieldInitializer();

    private static final long serialVersionUID = 1L;

    private final String accessKeyId;

    private final String rawSecretAccessKey;

    private XksProxyAuthenticationCredentialType(BuilderImpl builder) {
        this.accessKeyId = builder.accessKeyId;
        this.rawSecretAccessKey = builder.rawSecretAccessKey;
    }

    /**
     * <p>
     * A unique identifier for the raw secret access key.
     * </p>
     * 
     * @return A unique identifier for the raw secret access key.
     */
    public final String accessKeyId() {
        return accessKeyId;
    }

    /**
     * <p>
     * A secret string of 43-64 characters. Valid characters are a-z, A-Z, 0-9, /, +, and =.
     * </p>
     * 
     * @return A secret string of 43-64 characters. Valid characters are a-z, A-Z, 0-9, /, +, and =.
     */
    public final String rawSecretAccessKey() {
        return rawSecretAccessKey;
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
        hashCode = 31 * hashCode + Objects.hashCode(accessKeyId());
        hashCode = 31 * hashCode + Objects.hashCode(rawSecretAccessKey());
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
        if (!(obj instanceof XksProxyAuthenticationCredentialType)) {
            return false;
        }
        XksProxyAuthenticationCredentialType other = (XksProxyAuthenticationCredentialType) obj;
        return Objects.equals(accessKeyId(), other.accessKeyId())
                && Objects.equals(rawSecretAccessKey(), other.rawSecretAccessKey());
    }

    /**
     * Returns a string representation of this object. This is useful for testing and debugging. Sensitive data will be
     * redacted from this string using a placeholder value.
     */
    @Override
    public final String toString() {
        return ToString.builder("XksProxyAuthenticationCredentialType")
                .add("AccessKeyId", accessKeyId() == null ? null : "*** Sensitive Data Redacted ***")
                .add("RawSecretAccessKey", rawSecretAccessKey() == null ? null : "*** Sensitive Data Redacted ***").build();
    }

    public final <T> Optional<T> getValueForField(String fieldName, Class<T> clazz) {
        switch (fieldName) {
        case "AccessKeyId":
            return Optional.ofNullable(clazz.cast(accessKeyId()));
        case "RawSecretAccessKey":
            return Optional.ofNullable(clazz.cast(rawSecretAccessKey()));
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
        map.put("AccessKeyId", ACCESS_KEY_ID_FIELD);
        map.put("RawSecretAccessKey", RAW_SECRET_ACCESS_KEY_FIELD);
        return Collections.unmodifiableMap(map);
    }

    private static <T> Function<Object, T> getter(Function<XksProxyAuthenticationCredentialType, T> g) {
        return obj -> g.apply((XksProxyAuthenticationCredentialType) obj);
    }

    private static <T> BiConsumer<Object, T> setter(BiConsumer<Builder, T> s) {
        return (obj, val) -> s.accept((Builder) obj, val);
    }

    @Mutable
    @NotThreadSafe
    public interface Builder extends SdkPojo, CopyableBuilder<Builder, XksProxyAuthenticationCredentialType> {
        /**
         * <p>
         * A unique identifier for the raw secret access key.
         * </p>
         * 
         * @param accessKeyId
         *        A unique identifier for the raw secret access key.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder accessKeyId(String accessKeyId);

        /**
         * <p>
         * A secret string of 43-64 characters. Valid characters are a-z, A-Z, 0-9, /, +, and =.
         * </p>
         * 
         * @param rawSecretAccessKey
         *        A secret string of 43-64 characters. Valid characters are a-z, A-Z, 0-9, /, +, and =.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder rawSecretAccessKey(String rawSecretAccessKey);
    }

    static final class BuilderImpl implements Builder {
        private String accessKeyId;

        private String rawSecretAccessKey;

        private BuilderImpl() {
        }

        private BuilderImpl(XksProxyAuthenticationCredentialType model) {
            accessKeyId(model.accessKeyId);
            rawSecretAccessKey(model.rawSecretAccessKey);
        }

        public final String getAccessKeyId() {
            return accessKeyId;
        }

        public final void setAccessKeyId(String accessKeyId) {
            this.accessKeyId = accessKeyId;
        }

        @Override
        public final Builder accessKeyId(String accessKeyId) {
            this.accessKeyId = accessKeyId;
            return this;
        }

        public final String getRawSecretAccessKey() {
            return rawSecretAccessKey;
        }

        public final void setRawSecretAccessKey(String rawSecretAccessKey) {
            this.rawSecretAccessKey = rawSecretAccessKey;
        }

        @Override
        public final Builder rawSecretAccessKey(String rawSecretAccessKey) {
            this.rawSecretAccessKey = rawSecretAccessKey;
            return this;
        }

        @Override
        public XksProxyAuthenticationCredentialType build() {
            return new XksProxyAuthenticationCredentialType(this);
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
