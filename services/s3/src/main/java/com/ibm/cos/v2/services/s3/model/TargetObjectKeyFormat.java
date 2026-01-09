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
import com.ibm.cos.v2.utils.ToString;
import com.ibm.cos.v2.utils.builder.CopyableBuilder;
import com.ibm.cos.v2.utils.builder.ToCopyableBuilder;

/**
 * <p>
 * Amazon S3 key format for log objects. Only one format, PartitionedPrefix or SimplePrefix, is allowed.
 * </p>
 */
@Generated("com.ibm.cos.v2:codegen")
public final class TargetObjectKeyFormat implements SdkPojo, Serializable,
        ToCopyableBuilder<TargetObjectKeyFormat.Builder, TargetObjectKeyFormat> {
    private static final SdkField<SimplePrefix> SIMPLE_PREFIX_FIELD = SdkField
            .<SimplePrefix> builder(MarshallingType.SDK_POJO)
            .memberName("SimplePrefix")
            .getter(getter(TargetObjectKeyFormat::simplePrefix))
            .setter(setter(Builder::simplePrefix))
            .constructor(SimplePrefix::builder)
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("SimplePrefix")
                    .unmarshallLocationName("SimplePrefix").build()).build();

    private static final SdkField<PartitionedPrefix> PARTITIONED_PREFIX_FIELD = SdkField
            .<PartitionedPrefix> builder(MarshallingType.SDK_POJO)
            .memberName("PartitionedPrefix")
            .getter(getter(TargetObjectKeyFormat::partitionedPrefix))
            .setter(setter(Builder::partitionedPrefix))
            .constructor(PartitionedPrefix::builder)
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("PartitionedPrefix")
                    .unmarshallLocationName("PartitionedPrefix").build()).build();

    private static final List<SdkField<?>> SDK_FIELDS = Collections.unmodifiableList(Arrays.asList(SIMPLE_PREFIX_FIELD,
            PARTITIONED_PREFIX_FIELD));

    private static final Map<String, SdkField<?>> SDK_NAME_TO_FIELD = memberNameToFieldInitializer();

    private static final long serialVersionUID = 1L;

    private final SimplePrefix simplePrefix;

    private final PartitionedPrefix partitionedPrefix;

    private TargetObjectKeyFormat(BuilderImpl builder) {
        this.simplePrefix = builder.simplePrefix;
        this.partitionedPrefix = builder.partitionedPrefix;
    }

    /**
     * <p>
     * To use the simple format for S3 keys for log objects. To specify SimplePrefix format, set SimplePrefix to {}.
     * </p>
     * 
     * @return To use the simple format for S3 keys for log objects. To specify SimplePrefix format, set SimplePrefix to
     *         {}.
     */
    public final SimplePrefix simplePrefix() {
        return simplePrefix;
    }

    /**
     * <p>
     * Partitioned S3 key for log objects.
     * </p>
     * 
     * @return Partitioned S3 key for log objects.
     */
    public final PartitionedPrefix partitionedPrefix() {
        return partitionedPrefix;
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
        hashCode = 31 * hashCode + Objects.hashCode(simplePrefix());
        hashCode = 31 * hashCode + Objects.hashCode(partitionedPrefix());
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
        if (!(obj instanceof TargetObjectKeyFormat)) {
            return false;
        }
        TargetObjectKeyFormat other = (TargetObjectKeyFormat) obj;
        return Objects.equals(simplePrefix(), other.simplePrefix())
                && Objects.equals(partitionedPrefix(), other.partitionedPrefix());
    }

    /**
     * Returns a string representation of this object. This is useful for testing and debugging. Sensitive data will be
     * redacted from this string using a placeholder value.
     */
    @Override
    public final String toString() {
        return ToString.builder("TargetObjectKeyFormat").add("SimplePrefix", simplePrefix())
                .add("PartitionedPrefix", partitionedPrefix()).build();
    }

    public final <T> Optional<T> getValueForField(String fieldName, Class<T> clazz) {
        switch (fieldName) {
        case "SimplePrefix":
            return Optional.ofNullable(clazz.cast(simplePrefix()));
        case "PartitionedPrefix":
            return Optional.ofNullable(clazz.cast(partitionedPrefix()));
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
        map.put("SimplePrefix", SIMPLE_PREFIX_FIELD);
        map.put("PartitionedPrefix", PARTITIONED_PREFIX_FIELD);
        return Collections.unmodifiableMap(map);
    }

    private static <T> Function<Object, T> getter(Function<TargetObjectKeyFormat, T> g) {
        return obj -> g.apply((TargetObjectKeyFormat) obj);
    }

    private static <T> BiConsumer<Object, T> setter(BiConsumer<Builder, T> s) {
        return (obj, val) -> s.accept((Builder) obj, val);
    }

    @Mutable
    @NotThreadSafe
    public interface Builder extends SdkPojo, CopyableBuilder<Builder, TargetObjectKeyFormat> {
        /**
         * <p>
         * To use the simple format for S3 keys for log objects. To specify SimplePrefix format, set SimplePrefix to {}.
         * </p>
         * 
         * @param simplePrefix
         *        To use the simple format for S3 keys for log objects. To specify SimplePrefix format, set SimplePrefix
         *        to {}.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder simplePrefix(SimplePrefix simplePrefix);

        /**
         * <p>
         * To use the simple format for S3 keys for log objects. To specify SimplePrefix format, set SimplePrefix to {}.
         * </p>
         * This is a convenience method that creates an instance of the {@link SimplePrefix.Builder} avoiding the need
         * to create one manually via {@link SimplePrefix#builder()}.
         *
         * <p>
         * When the {@link Consumer} completes, {@link SimplePrefix.Builder#build()} is called immediately and its
         * result is passed to {@link #simplePrefix(SimplePrefix)}.
         * 
         * @param simplePrefix
         *        a consumer that will call methods on {@link SimplePrefix.Builder}
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see #simplePrefix(SimplePrefix)
         */
        default Builder simplePrefix(Consumer<SimplePrefix.Builder> simplePrefix) {
            return simplePrefix(SimplePrefix.builder().applyMutation(simplePrefix).build());
        }

        /**
         * <p>
         * Partitioned S3 key for log objects.
         * </p>
         * 
         * @param partitionedPrefix
         *        Partitioned S3 key for log objects.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder partitionedPrefix(PartitionedPrefix partitionedPrefix);

        /**
         * <p>
         * Partitioned S3 key for log objects.
         * </p>
         * This is a convenience method that creates an instance of the {@link PartitionedPrefix.Builder} avoiding the
         * need to create one manually via {@link PartitionedPrefix#builder()}.
         *
         * <p>
         * When the {@link Consumer} completes, {@link PartitionedPrefix.Builder#build()} is called immediately and its
         * result is passed to {@link #partitionedPrefix(PartitionedPrefix)}.
         * 
         * @param partitionedPrefix
         *        a consumer that will call methods on {@link PartitionedPrefix.Builder}
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see #partitionedPrefix(PartitionedPrefix)
         */
        default Builder partitionedPrefix(Consumer<PartitionedPrefix.Builder> partitionedPrefix) {
            return partitionedPrefix(PartitionedPrefix.builder().applyMutation(partitionedPrefix).build());
        }
    }

    static final class BuilderImpl implements Builder {
        private SimplePrefix simplePrefix;

        private PartitionedPrefix partitionedPrefix;

        private BuilderImpl() {
        }

        private BuilderImpl(TargetObjectKeyFormat model) {
            simplePrefix(model.simplePrefix);
            partitionedPrefix(model.partitionedPrefix);
        }

        public final SimplePrefix.Builder getSimplePrefix() {
            return simplePrefix != null ? simplePrefix.toBuilder() : null;
        }

        public final void setSimplePrefix(SimplePrefix.BuilderImpl simplePrefix) {
            this.simplePrefix = simplePrefix != null ? simplePrefix.build() : null;
        }

        @Override
        public final Builder simplePrefix(SimplePrefix simplePrefix) {
            this.simplePrefix = simplePrefix;
            return this;
        }

        public final PartitionedPrefix.Builder getPartitionedPrefix() {
            return partitionedPrefix != null ? partitionedPrefix.toBuilder() : null;
        }

        public final void setPartitionedPrefix(PartitionedPrefix.BuilderImpl partitionedPrefix) {
            this.partitionedPrefix = partitionedPrefix != null ? partitionedPrefix.build() : null;
        }

        @Override
        public final Builder partitionedPrefix(PartitionedPrefix partitionedPrefix) {
            this.partitionedPrefix = partitionedPrefix;
            return this;
        }

        @Override
        public TargetObjectKeyFormat build() {
            return new TargetObjectKeyFormat(this);
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
