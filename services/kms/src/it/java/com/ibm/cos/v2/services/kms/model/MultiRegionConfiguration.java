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
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import com.ibm.cos.v2.annotations.Generated;
import com.ibm.cos.v2.annotations.Mutable;
import com.ibm.cos.v2.annotations.NotThreadSafe;
import com.ibm.cos.v2.core.SdkField;
import com.ibm.cos.v2.core.SdkPojo;
import com.ibm.cos.v2.core.protocol.MarshallLocation;
import com.ibm.cos.v2.core.protocol.MarshallingType;
import com.ibm.cos.v2.core.traits.ListTrait;
import com.ibm.cos.v2.core.traits.LocationTrait;
import com.ibm.cos.v2.core.util.DefaultSdkAutoConstructList;
import com.ibm.cos.v2.core.util.SdkAutoConstructList;
import com.ibm.cos.v2.utils.ToString;
import com.ibm.cos.v2.utils.builder.CopyableBuilder;
import com.ibm.cos.v2.utils.builder.ToCopyableBuilder;

/**
 * <p>
 * Describes the configuration of this multi-Region key. This field appears only when the KMS key is a primary or
 * replica of a multi-Region key.
 * </p>
 * <p>
 * For more information about any listed KMS key, use the <a>DescribeKey</a> operation.
 * </p>
 */
@Generated("com.ibm.cos.v2:codegen")
public final class MultiRegionConfiguration implements SdkPojo, Serializable,
        ToCopyableBuilder<MultiRegionConfiguration.Builder, MultiRegionConfiguration> {
    private static final SdkField<String> MULTI_REGION_KEY_TYPE_FIELD = SdkField.<String> builder(MarshallingType.STRING)
            .memberName("MultiRegionKeyType").getter(getter(MultiRegionConfiguration::multiRegionKeyTypeAsString))
            .setter(setter(Builder::multiRegionKeyType))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("MultiRegionKeyType").build())
            .build();

    private static final SdkField<MultiRegionKey> PRIMARY_KEY_FIELD = SdkField.<MultiRegionKey> builder(MarshallingType.SDK_POJO)
            .memberName("PrimaryKey").getter(getter(MultiRegionConfiguration::primaryKey)).setter(setter(Builder::primaryKey))
            .constructor(MultiRegionKey::builder)
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("PrimaryKey").build()).build();

    private static final SdkField<List<MultiRegionKey>> REPLICA_KEYS_FIELD = SdkField
            .<List<MultiRegionKey>> builder(MarshallingType.LIST)
            .memberName("ReplicaKeys")
            .getter(getter(MultiRegionConfiguration::replicaKeys))
            .setter(setter(Builder::replicaKeys))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("ReplicaKeys").build(),
                    ListTrait
                            .builder()
                            .memberLocationName(null)
                            .memberFieldInfo(
                                    SdkField.<MultiRegionKey> builder(MarshallingType.SDK_POJO)
                                            .constructor(MultiRegionKey::builder)
                                            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD)
                                                    .locationName("member").build()).build()).build()).build();

    private static final List<SdkField<?>> SDK_FIELDS = Collections.unmodifiableList(Arrays.asList(MULTI_REGION_KEY_TYPE_FIELD,
            PRIMARY_KEY_FIELD, REPLICA_KEYS_FIELD));

    private static final Map<String, SdkField<?>> SDK_NAME_TO_FIELD = memberNameToFieldInitializer();

    private static final long serialVersionUID = 1L;

    private final String multiRegionKeyType;

    private final MultiRegionKey primaryKey;

    private final List<MultiRegionKey> replicaKeys;

    private MultiRegionConfiguration(BuilderImpl builder) {
        this.multiRegionKeyType = builder.multiRegionKeyType;
        this.primaryKey = builder.primaryKey;
        this.replicaKeys = builder.replicaKeys;
    }

    /**
     * <p>
     * Indicates whether the KMS key is a <code>PRIMARY</code> or <code>REPLICA</code> key.
     * </p>
     * <p>
     * If the service returns an enum value that is not available in the current SDK version,
     * {@link #multiRegionKeyType} will return {@link MultiRegionKeyType#UNKNOWN_TO_SDK_VERSION}. The raw value returned
     * by the service is available from {@link #multiRegionKeyTypeAsString}.
     * </p>
     * 
     * @return Indicates whether the KMS key is a <code>PRIMARY</code> or <code>REPLICA</code> key.
     * @see MultiRegionKeyType
     */
    public final MultiRegionKeyType multiRegionKeyType() {
        return MultiRegionKeyType.fromValue(multiRegionKeyType);
    }

    /**
     * <p>
     * Indicates whether the KMS key is a <code>PRIMARY</code> or <code>REPLICA</code> key.
     * </p>
     * <p>
     * If the service returns an enum value that is not available in the current SDK version,
     * {@link #multiRegionKeyType} will return {@link MultiRegionKeyType#UNKNOWN_TO_SDK_VERSION}. The raw value returned
     * by the service is available from {@link #multiRegionKeyTypeAsString}.
     * </p>
     * 
     * @return Indicates whether the KMS key is a <code>PRIMARY</code> or <code>REPLICA</code> key.
     * @see MultiRegionKeyType
     */
    public final String multiRegionKeyTypeAsString() {
        return multiRegionKeyType;
    }

    /**
     * <p>
     * Displays the key ARN and Region of the primary key. This field includes the current KMS key if it is the primary
     * key.
     * </p>
     * 
     * @return Displays the key ARN and Region of the primary key. This field includes the current KMS key if it is the
     *         primary key.
     */
    public final MultiRegionKey primaryKey() {
        return primaryKey;
    }

    /**
     * For responses, this returns true if the service returned a value for the ReplicaKeys property. This DOES NOT
     * check that the value is non-empty (for which, you should check the {@code isEmpty()} method on the property).
     * This is useful because the SDK will never return a null collection or map, but you may need to differentiate
     * between the service returning nothing (or null) and the service returning an empty collection or map. For
     * requests, this returns true if a value for the property was specified in the request builder, and false if a
     * value was not specified.
     */
    public final boolean hasReplicaKeys() {
        return replicaKeys != null && !(replicaKeys instanceof SdkAutoConstructList);
    }

    /**
     * <p>
     * displays the key ARNs and Regions of all replica keys. This field includes the current KMS key if it is a replica
     * key.
     * </p>
     * <p>
     * Attempts to modify the collection returned by this method will result in an UnsupportedOperationException.
     * </p>
     * <p>
     * This method will never return null. If you would like to know whether the service returned this field (so that
     * you can differentiate between null and empty), you can use the {@link #hasReplicaKeys} method.
     * </p>
     * 
     * @return displays the key ARNs and Regions of all replica keys. This field includes the current KMS key if it is a
     *         replica key.
     */
    public final List<MultiRegionKey> replicaKeys() {
        return replicaKeys;
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
        hashCode = 31 * hashCode + Objects.hashCode(multiRegionKeyTypeAsString());
        hashCode = 31 * hashCode + Objects.hashCode(primaryKey());
        hashCode = 31 * hashCode + Objects.hashCode(hasReplicaKeys() ? replicaKeys() : null);
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
        if (!(obj instanceof MultiRegionConfiguration)) {
            return false;
        }
        MultiRegionConfiguration other = (MultiRegionConfiguration) obj;
        return Objects.equals(multiRegionKeyTypeAsString(), other.multiRegionKeyTypeAsString())
                && Objects.equals(primaryKey(), other.primaryKey()) && hasReplicaKeys() == other.hasReplicaKeys()
                && Objects.equals(replicaKeys(), other.replicaKeys());
    }

    /**
     * Returns a string representation of this object. This is useful for testing and debugging. Sensitive data will be
     * redacted from this string using a placeholder value.
     */
    @Override
    public final String toString() {
        return ToString.builder("MultiRegionConfiguration").add("MultiRegionKeyType", multiRegionKeyTypeAsString())
                .add("PrimaryKey", primaryKey()).add("ReplicaKeys", hasReplicaKeys() ? replicaKeys() : null).build();
    }

    public final <T> Optional<T> getValueForField(String fieldName, Class<T> clazz) {
        switch (fieldName) {
        case "MultiRegionKeyType":
            return Optional.ofNullable(clazz.cast(multiRegionKeyTypeAsString()));
        case "PrimaryKey":
            return Optional.ofNullable(clazz.cast(primaryKey()));
        case "ReplicaKeys":
            return Optional.ofNullable(clazz.cast(replicaKeys()));
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
        map.put("MultiRegionKeyType", MULTI_REGION_KEY_TYPE_FIELD);
        map.put("PrimaryKey", PRIMARY_KEY_FIELD);
        map.put("ReplicaKeys", REPLICA_KEYS_FIELD);
        return Collections.unmodifiableMap(map);
    }

    private static <T> Function<Object, T> getter(Function<MultiRegionConfiguration, T> g) {
        return obj -> g.apply((MultiRegionConfiguration) obj);
    }

    private static <T> BiConsumer<Object, T> setter(BiConsumer<Builder, T> s) {
        return (obj, val) -> s.accept((Builder) obj, val);
    }

    @Mutable
    @NotThreadSafe
    public interface Builder extends SdkPojo, CopyableBuilder<Builder, MultiRegionConfiguration> {
        /**
         * <p>
         * Indicates whether the KMS key is a <code>PRIMARY</code> or <code>REPLICA</code> key.
         * </p>
         * 
         * @param multiRegionKeyType
         *        Indicates whether the KMS key is a <code>PRIMARY</code> or <code>REPLICA</code> key.
         * @see MultiRegionKeyType
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see MultiRegionKeyType
         */
        Builder multiRegionKeyType(String multiRegionKeyType);

        /**
         * <p>
         * Indicates whether the KMS key is a <code>PRIMARY</code> or <code>REPLICA</code> key.
         * </p>
         * 
         * @param multiRegionKeyType
         *        Indicates whether the KMS key is a <code>PRIMARY</code> or <code>REPLICA</code> key.
         * @see MultiRegionKeyType
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see MultiRegionKeyType
         */
        Builder multiRegionKeyType(MultiRegionKeyType multiRegionKeyType);

        /**
         * <p>
         * Displays the key ARN and Region of the primary key. This field includes the current KMS key if it is the
         * primary key.
         * </p>
         * 
         * @param primaryKey
         *        Displays the key ARN and Region of the primary key. This field includes the current KMS key if it is
         *        the primary key.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder primaryKey(MultiRegionKey primaryKey);

        /**
         * <p>
         * Displays the key ARN and Region of the primary key. This field includes the current KMS key if it is the
         * primary key.
         * </p>
         * This is a convenience method that creates an instance of the {@link MultiRegionKey.Builder} avoiding the need
         * to create one manually via {@link MultiRegionKey#builder()}.
         *
         * <p>
         * When the {@link Consumer} completes, {@link MultiRegionKey.Builder#build()} is called immediately and its
         * result is passed to {@link #primaryKey(MultiRegionKey)}.
         * 
         * @param primaryKey
         *        a consumer that will call methods on {@link MultiRegionKey.Builder}
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see #primaryKey(MultiRegionKey)
         */
        default Builder primaryKey(Consumer<MultiRegionKey.Builder> primaryKey) {
            return primaryKey(MultiRegionKey.builder().applyMutation(primaryKey).build());
        }

        /**
         * <p>
         * displays the key ARNs and Regions of all replica keys. This field includes the current KMS key if it is a
         * replica key.
         * </p>
         * 
         * @param replicaKeys
         *        displays the key ARNs and Regions of all replica keys. This field includes the current KMS key if it
         *        is a replica key.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder replicaKeys(Collection<MultiRegionKey> replicaKeys);

        /**
         * <p>
         * displays the key ARNs and Regions of all replica keys. This field includes the current KMS key if it is a
         * replica key.
         * </p>
         * 
         * @param replicaKeys
         *        displays the key ARNs and Regions of all replica keys. This field includes the current KMS key if it
         *        is a replica key.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder replicaKeys(MultiRegionKey... replicaKeys);

        /**
         * <p>
         * displays the key ARNs and Regions of all replica keys. This field includes the current KMS key if it is a
         * replica key.
         * </p>
         * This is a convenience method that creates an instance of the
         * {@link com.ibm.cos.v2.services.kms.model.MultiRegionKey.Builder} avoiding the need to create one
         * manually via {@link com.ibm.cos.v2.services.kms.model.MultiRegionKey#builder()}.
         *
         * <p>
         * When the {@link Consumer} completes,
         * {@link com.ibm.cos.v2.services.kms.model.MultiRegionKey.Builder#build()} is called immediately and
         * its result is passed to {@link #replicaKeys(List<MultiRegionKey>)}.
         * 
         * @param replicaKeys
         *        a consumer that will call methods on
         *        {@link com.ibm.cos.v2.services.kms.model.MultiRegionKey.Builder}
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see #replicaKeys(java.util.Collection<MultiRegionKey>)
         */
        Builder replicaKeys(Consumer<MultiRegionKey.Builder>... replicaKeys);
    }

    static final class BuilderImpl implements Builder {
        private String multiRegionKeyType;

        private MultiRegionKey primaryKey;

        private List<MultiRegionKey> replicaKeys = DefaultSdkAutoConstructList.getInstance();

        private BuilderImpl() {
        }

        private BuilderImpl(MultiRegionConfiguration model) {
            multiRegionKeyType(model.multiRegionKeyType);
            primaryKey(model.primaryKey);
            replicaKeys(model.replicaKeys);
        }

        public final String getMultiRegionKeyType() {
            return multiRegionKeyType;
        }

        public final void setMultiRegionKeyType(String multiRegionKeyType) {
            this.multiRegionKeyType = multiRegionKeyType;
        }

        @Override
        public final Builder multiRegionKeyType(String multiRegionKeyType) {
            this.multiRegionKeyType = multiRegionKeyType;
            return this;
        }

        @Override
        public final Builder multiRegionKeyType(MultiRegionKeyType multiRegionKeyType) {
            this.multiRegionKeyType(multiRegionKeyType == null ? null : multiRegionKeyType.toString());
            return this;
        }

        public final MultiRegionKey.Builder getPrimaryKey() {
            return primaryKey != null ? primaryKey.toBuilder() : null;
        }

        public final void setPrimaryKey(MultiRegionKey.BuilderImpl primaryKey) {
            this.primaryKey = primaryKey != null ? primaryKey.build() : null;
        }

        @Override
        public final Builder primaryKey(MultiRegionKey primaryKey) {
            this.primaryKey = primaryKey;
            return this;
        }

        public final List<MultiRegionKey.Builder> getReplicaKeys() {
            List<MultiRegionKey.Builder> result = MultiRegionKeyListCopier.copyToBuilder(this.replicaKeys);
            if (result instanceof SdkAutoConstructList) {
                return null;
            }
            return result;
        }

        public final void setReplicaKeys(Collection<MultiRegionKey.BuilderImpl> replicaKeys) {
            this.replicaKeys = MultiRegionKeyListCopier.copyFromBuilder(replicaKeys);
        }

        @Override
        public final Builder replicaKeys(Collection<MultiRegionKey> replicaKeys) {
            this.replicaKeys = MultiRegionKeyListCopier.copy(replicaKeys);
            return this;
        }

        @Override
        @SafeVarargs
        public final Builder replicaKeys(MultiRegionKey... replicaKeys) {
            replicaKeys(Arrays.asList(replicaKeys));
            return this;
        }

        @Override
        @SafeVarargs
        public final Builder replicaKeys(Consumer<MultiRegionKey.Builder>... replicaKeys) {
            replicaKeys(Stream.of(replicaKeys).map(c -> MultiRegionKey.builder().applyMutation(c).build())
                    .collect(Collectors.toList()));
            return this;
        }

        @Override
        public MultiRegionConfiguration build() {
            return new MultiRegionConfiguration(this);
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
