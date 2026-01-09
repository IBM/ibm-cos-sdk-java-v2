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
import com.ibm.cos.v2.core.traits.MapTrait;
import com.ibm.cos.v2.core.util.DefaultSdkAutoConstructMap;
import com.ibm.cos.v2.core.util.SdkAutoConstructMap;
import com.ibm.cos.v2.utils.ToString;
import com.ibm.cos.v2.utils.builder.CopyableBuilder;
import com.ibm.cos.v2.utils.builder.ToCopyableBuilder;

/**
 * <p>
 * Use this structure to allow <a
 * href="https://docs.aws.amazon.com/kms/latest/developerguide/concepts.html#cryptographic-operations">cryptographic
 * operations</a> in the grant only when the operation request includes the specified <a
 * href="https://docs.aws.amazon.com/kms/latest/developerguide/concepts.html#encrypt_context">encryption context</a>.
 * </p>
 * <p>
 * KMS applies the grant constraints only to cryptographic operations that support an encryption context, that is, all
 * cryptographic operations with a <a
 * href="https://docs.aws.amazon.com/kms/latest/developerguide/symm-asymm-concepts.html#symmetric-cmks">symmetric KMS
 * key</a>. Grant constraints are not applied to operations that do not support an encryption context, such as
 * cryptographic operations with asymmetric KMS keys and management operations, such as <a>DescribeKey</a> or
 * <a>RetireGrant</a>.
 * </p>
 * <important>
 * <p>
 * In a cryptographic operation, the encryption context in the decryption operation must be an exact, case-sensitive
 * match for the keys and values in the encryption context of the encryption operation. Only the order of the pairs can
 * vary.
 * </p>
 * <p>
 * However, in a grant constraint, the key in each key-value pair is not case sensitive, but the value is case
 * sensitive.
 * </p>
 * <p>
 * To avoid confusion, do not use multiple encryption context pairs that differ only by case. To require a fully
 * case-sensitive encryption context, use the <code>kms:EncryptionContext:</code> and
 * <code>kms:EncryptionContextKeys</code> conditions in an IAM or key policy. For details, see <a href=
 * "https://docs.aws.amazon.com/kms/latest/developerguide/policy-conditions.html#conditions-kms-encryption-context"
 * >kms:EncryptionContext:</a> in the <i> <i>Key Management Service Developer Guide</i> </i>.
 * </p>
 * </important>
 */
@Generated("com.ibm.cos.v2:codegen")
public final class GrantConstraints implements SdkPojo, Serializable,
        ToCopyableBuilder<GrantConstraints.Builder, GrantConstraints> {
    private static final SdkField<Map<String, String>> ENCRYPTION_CONTEXT_SUBSET_FIELD = SdkField
            .<Map<String, String>> builder(MarshallingType.MAP)
            .memberName("EncryptionContextSubset")
            .getter(getter(GrantConstraints::encryptionContextSubset))
            .setter(setter(Builder::encryptionContextSubset))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("EncryptionContextSubset").build(),
                    MapTrait.builder()
                            .keyLocationName("key")
                            .valueLocationName("value")
                            .valueFieldInfo(
                                    SdkField.<String> builder(MarshallingType.STRING)
                                            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD)
                                                    .locationName("value").build()).build()).build()).build();

    private static final SdkField<Map<String, String>> ENCRYPTION_CONTEXT_EQUALS_FIELD = SdkField
            .<Map<String, String>> builder(MarshallingType.MAP)
            .memberName("EncryptionContextEquals")
            .getter(getter(GrantConstraints::encryptionContextEquals))
            .setter(setter(Builder::encryptionContextEquals))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("EncryptionContextEquals").build(),
                    MapTrait.builder()
                            .keyLocationName("key")
                            .valueLocationName("value")
                            .valueFieldInfo(
                                    SdkField.<String> builder(MarshallingType.STRING)
                                            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD)
                                                    .locationName("value").build()).build()).build()).build();

    private static final List<SdkField<?>> SDK_FIELDS = Collections.unmodifiableList(Arrays.asList(
            ENCRYPTION_CONTEXT_SUBSET_FIELD, ENCRYPTION_CONTEXT_EQUALS_FIELD));

    private static final Map<String, SdkField<?>> SDK_NAME_TO_FIELD = memberNameToFieldInitializer();

    private static final long serialVersionUID = 1L;

    private final Map<String, String> encryptionContextSubset;

    private final Map<String, String> encryptionContextEquals;

    private GrantConstraints(BuilderImpl builder) {
        this.encryptionContextSubset = builder.encryptionContextSubset;
        this.encryptionContextEquals = builder.encryptionContextEquals;
    }

    /**
     * For responses, this returns true if the service returned a value for the EncryptionContextSubset property. This
     * DOES NOT check that the value is non-empty (for which, you should check the {@code isEmpty()} method on the
     * property). This is useful because the SDK will never return a null collection or map, but you may need to
     * differentiate between the service returning nothing (or null) and the service returning an empty collection or
     * map. For requests, this returns true if a value for the property was specified in the request builder, and false
     * if a value was not specified.
     */
    public final boolean hasEncryptionContextSubset() {
        return encryptionContextSubset != null && !(encryptionContextSubset instanceof SdkAutoConstructMap);
    }

    /**
     * <p>
     * A list of key-value pairs that must be included in the encryption context of the <a
     * href="https://docs.aws.amazon.com/kms/latest/developerguide/concepts.html#cryptographic-operations">cryptographic
     * operation</a> request. The grant allows the cryptographic operation only when the encryption context in the
     * request includes the key-value pairs specified in this constraint, although it can include additional key-value
     * pairs.
     * </p>
     * <p>
     * Attempts to modify the collection returned by this method will result in an UnsupportedOperationException.
     * </p>
     * <p>
     * This method will never return null. If you would like to know whether the service returned this field (so that
     * you can differentiate between null and empty), you can use the {@link #hasEncryptionContextSubset} method.
     * </p>
     * 
     * @return A list of key-value pairs that must be included in the encryption context of the <a
     *         href="https://docs.aws.amazon.com/kms/latest/developerguide/concepts.html#cryptographic-operations"
     *         >cryptographic operation</a> request. The grant allows the cryptographic operation only when the
     *         encryption context in the request includes the key-value pairs specified in this constraint, although it
     *         can include additional key-value pairs.
     */
    public final Map<String, String> encryptionContextSubset() {
        return encryptionContextSubset;
    }

    /**
     * For responses, this returns true if the service returned a value for the EncryptionContextEquals property. This
     * DOES NOT check that the value is non-empty (for which, you should check the {@code isEmpty()} method on the
     * property). This is useful because the SDK will never return a null collection or map, but you may need to
     * differentiate between the service returning nothing (or null) and the service returning an empty collection or
     * map. For requests, this returns true if a value for the property was specified in the request builder, and false
     * if a value was not specified.
     */
    public final boolean hasEncryptionContextEquals() {
        return encryptionContextEquals != null && !(encryptionContextEquals instanceof SdkAutoConstructMap);
    }

    /**
     * <p>
     * A list of key-value pairs that must match the encryption context in the <a
     * href="https://docs.aws.amazon.com/kms/latest/developerguide/concepts.html#cryptographic-operations">cryptographic
     * operation</a> request. The grant allows the operation only when the encryption context in the request is the same
     * as the encryption context specified in this constraint.
     * </p>
     * <p>
     * Attempts to modify the collection returned by this method will result in an UnsupportedOperationException.
     * </p>
     * <p>
     * This method will never return null. If you would like to know whether the service returned this field (so that
     * you can differentiate between null and empty), you can use the {@link #hasEncryptionContextEquals} method.
     * </p>
     * 
     * @return A list of key-value pairs that must match the encryption context in the <a
     *         href="https://docs.aws.amazon.com/kms/latest/developerguide/concepts.html#cryptographic-operations"
     *         >cryptographic operation</a> request. The grant allows the operation only when the encryption context in
     *         the request is the same as the encryption context specified in this constraint.
     */
    public final Map<String, String> encryptionContextEquals() {
        return encryptionContextEquals;
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
        hashCode = 31 * hashCode + Objects.hashCode(hasEncryptionContextSubset() ? encryptionContextSubset() : null);
        hashCode = 31 * hashCode + Objects.hashCode(hasEncryptionContextEquals() ? encryptionContextEquals() : null);
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
        if (!(obj instanceof GrantConstraints)) {
            return false;
        }
        GrantConstraints other = (GrantConstraints) obj;
        return hasEncryptionContextSubset() == other.hasEncryptionContextSubset()
                && Objects.equals(encryptionContextSubset(), other.encryptionContextSubset())
                && hasEncryptionContextEquals() == other.hasEncryptionContextEquals()
                && Objects.equals(encryptionContextEquals(), other.encryptionContextEquals());
    }

    /**
     * Returns a string representation of this object. This is useful for testing and debugging. Sensitive data will be
     * redacted from this string using a placeholder value.
     */
    @Override
    public final String toString() {
        return ToString.builder("GrantConstraints")
                .add("EncryptionContextSubset", hasEncryptionContextSubset() ? encryptionContextSubset() : null)
                .add("EncryptionContextEquals", hasEncryptionContextEquals() ? encryptionContextEquals() : null).build();
    }

    public final <T> Optional<T> getValueForField(String fieldName, Class<T> clazz) {
        switch (fieldName) {
        case "EncryptionContextSubset":
            return Optional.ofNullable(clazz.cast(encryptionContextSubset()));
        case "EncryptionContextEquals":
            return Optional.ofNullable(clazz.cast(encryptionContextEquals()));
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
        map.put("EncryptionContextSubset", ENCRYPTION_CONTEXT_SUBSET_FIELD);
        map.put("EncryptionContextEquals", ENCRYPTION_CONTEXT_EQUALS_FIELD);
        return Collections.unmodifiableMap(map);
    }

    private static <T> Function<Object, T> getter(Function<GrantConstraints, T> g) {
        return obj -> g.apply((GrantConstraints) obj);
    }

    private static <T> BiConsumer<Object, T> setter(BiConsumer<Builder, T> s) {
        return (obj, val) -> s.accept((Builder) obj, val);
    }

    @Mutable
    @NotThreadSafe
    public interface Builder extends SdkPojo, CopyableBuilder<Builder, GrantConstraints> {
        /**
         * <p>
         * A list of key-value pairs that must be included in the encryption context of the <a
         * href="https://docs.aws.amazon.com/kms/latest/developerguide/concepts.html#cryptographic-operations"
         * >cryptographic operation</a> request. The grant allows the cryptographic operation only when the encryption
         * context in the request includes the key-value pairs specified in this constraint, although it can include
         * additional key-value pairs.
         * </p>
         * 
         * @param encryptionContextSubset
         *        A list of key-value pairs that must be included in the encryption context of the <a
         *        href="https://docs.aws.amazon.com/kms/latest/developerguide/concepts.html#cryptographic-operations"
         *        >cryptographic operation</a> request. The grant allows the cryptographic operation only when the
         *        encryption context in the request includes the key-value pairs specified in this constraint, although
         *        it can include additional key-value pairs.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder encryptionContextSubset(Map<String, String> encryptionContextSubset);

        /**
         * <p>
         * A list of key-value pairs that must match the encryption context in the <a
         * href="https://docs.aws.amazon.com/kms/latest/developerguide/concepts.html#cryptographic-operations"
         * >cryptographic operation</a> request. The grant allows the operation only when the encryption context in the
         * request is the same as the encryption context specified in this constraint.
         * </p>
         * 
         * @param encryptionContextEquals
         *        A list of key-value pairs that must match the encryption context in the <a
         *        href="https://docs.aws.amazon.com/kms/latest/developerguide/concepts.html#cryptographic-operations"
         *        >cryptographic operation</a> request. The grant allows the operation only when the encryption context
         *        in the request is the same as the encryption context specified in this constraint.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder encryptionContextEquals(Map<String, String> encryptionContextEquals);
    }

    static final class BuilderImpl implements Builder {
        private Map<String, String> encryptionContextSubset = DefaultSdkAutoConstructMap.getInstance();

        private Map<String, String> encryptionContextEquals = DefaultSdkAutoConstructMap.getInstance();

        private BuilderImpl() {
        }

        private BuilderImpl(GrantConstraints model) {
            encryptionContextSubset(model.encryptionContextSubset);
            encryptionContextEquals(model.encryptionContextEquals);
        }

        public final Map<String, String> getEncryptionContextSubset() {
            if (encryptionContextSubset instanceof SdkAutoConstructMap) {
                return null;
            }
            return encryptionContextSubset;
        }

        public final void setEncryptionContextSubset(Map<String, String> encryptionContextSubset) {
            this.encryptionContextSubset = EncryptionContextTypeCopier.copy(encryptionContextSubset);
        }

        @Override
        public final Builder encryptionContextSubset(Map<String, String> encryptionContextSubset) {
            this.encryptionContextSubset = EncryptionContextTypeCopier.copy(encryptionContextSubset);
            return this;
        }

        public final Map<String, String> getEncryptionContextEquals() {
            if (encryptionContextEquals instanceof SdkAutoConstructMap) {
                return null;
            }
            return encryptionContextEquals;
        }

        public final void setEncryptionContextEquals(Map<String, String> encryptionContextEquals) {
            this.encryptionContextEquals = EncryptionContextTypeCopier.copy(encryptionContextEquals);
        }

        @Override
        public final Builder encryptionContextEquals(Map<String, String> encryptionContextEquals) {
            this.encryptionContextEquals = EncryptionContextTypeCopier.copy(encryptionContextEquals);
            return this;
        }

        @Override
        public GrantConstraints build() {
            return new GrantConstraints(this);
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
