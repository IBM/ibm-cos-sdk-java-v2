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
 * Amazon S3 keys for log objects are partitioned in the following format:
 * </p>
 * <p>
 * <code>[DestinationPrefix][SourceAccountId]/[SourceRegion]/[SourceBucket]/[YYYY]/[MM]/[DD]/[YYYY]-[MM]-[DD]-[hh]-[mm]-[ss]-[UniqueString]</code>
 * </p>
 * <p>
 * PartitionedPrefix defaults to EventTime delivery when server access logs are delivered.
 * </p>
 */
@Generated("com.ibm.cos.v2:codegen")
public final class PartitionedPrefix implements SdkPojo, Serializable,
        ToCopyableBuilder<PartitionedPrefix.Builder, PartitionedPrefix> {
    private static final SdkField<String> PARTITION_DATE_SOURCE_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("PartitionDateSource")
            .getter(getter(PartitionedPrefix::partitionDateSourceAsString))
            .setter(setter(Builder::partitionDateSource))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("PartitionDateSource")
                    .unmarshallLocationName("PartitionDateSource").build()).build();

    private static final List<SdkField<?>> SDK_FIELDS = Collections.unmodifiableList(Arrays.asList(PARTITION_DATE_SOURCE_FIELD));

    private static final Map<String, SdkField<?>> SDK_NAME_TO_FIELD = memberNameToFieldInitializer();

    private static final long serialVersionUID = 1L;

    private final String partitionDateSource;

    private PartitionedPrefix(BuilderImpl builder) {
        this.partitionDateSource = builder.partitionDateSource;
    }

    /**
     * <p>
     * Specifies the partition date source for the partitioned prefix. <code>PartitionDateSource</code> can be
     * <code>EventTime</code> or <code>DeliveryTime</code>.
     * </p>
     * <p>
     * For <code>DeliveryTime</code>, the time in the log file names corresponds to the delivery time for the log files.
     * </p>
     * <p>
     * For <code>EventTime</code>, The logs delivered are for a specific day only. The year, month, and day correspond
     * to the day on which the event occurred, and the hour, minutes and seconds are set to 00 in the key.
     * </p>
     * <p>
     * If the service returns an enum value that is not available in the current SDK version,
     * {@link #partitionDateSource} will return {@link PartitionDateSource#UNKNOWN_TO_SDK_VERSION}. The raw value
     * returned by the service is available from {@link #partitionDateSourceAsString}.
     * </p>
     * 
     * @return Specifies the partition date source for the partitioned prefix. <code>PartitionDateSource</code> can be
     *         <code>EventTime</code> or <code>DeliveryTime</code>.</p>
     *         <p>
     *         For <code>DeliveryTime</code>, the time in the log file names corresponds to the delivery time for the
     *         log files.
     *         </p>
     *         <p>
     *         For <code>EventTime</code>, The logs delivered are for a specific day only. The year, month, and day
     *         correspond to the day on which the event occurred, and the hour, minutes and seconds are set to 00 in the
     *         key.
     * @see PartitionDateSource
     */
    public final PartitionDateSource partitionDateSource() {
        return PartitionDateSource.fromValue(partitionDateSource);
    }

    /**
     * <p>
     * Specifies the partition date source for the partitioned prefix. <code>PartitionDateSource</code> can be
     * <code>EventTime</code> or <code>DeliveryTime</code>.
     * </p>
     * <p>
     * For <code>DeliveryTime</code>, the time in the log file names corresponds to the delivery time for the log files.
     * </p>
     * <p>
     * For <code>EventTime</code>, The logs delivered are for a specific day only. The year, month, and day correspond
     * to the day on which the event occurred, and the hour, minutes and seconds are set to 00 in the key.
     * </p>
     * <p>
     * If the service returns an enum value that is not available in the current SDK version,
     * {@link #partitionDateSource} will return {@link PartitionDateSource#UNKNOWN_TO_SDK_VERSION}. The raw value
     * returned by the service is available from {@link #partitionDateSourceAsString}.
     * </p>
     * 
     * @return Specifies the partition date source for the partitioned prefix. <code>PartitionDateSource</code> can be
     *         <code>EventTime</code> or <code>DeliveryTime</code>.</p>
     *         <p>
     *         For <code>DeliveryTime</code>, the time in the log file names corresponds to the delivery time for the
     *         log files.
     *         </p>
     *         <p>
     *         For <code>EventTime</code>, The logs delivered are for a specific day only. The year, month, and day
     *         correspond to the day on which the event occurred, and the hour, minutes and seconds are set to 00 in the
     *         key.
     * @see PartitionDateSource
     */
    public final String partitionDateSourceAsString() {
        return partitionDateSource;
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
        hashCode = 31 * hashCode + Objects.hashCode(partitionDateSourceAsString());
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
        if (!(obj instanceof PartitionedPrefix)) {
            return false;
        }
        PartitionedPrefix other = (PartitionedPrefix) obj;
        return Objects.equals(partitionDateSourceAsString(), other.partitionDateSourceAsString());
    }

    /**
     * Returns a string representation of this object. This is useful for testing and debugging. Sensitive data will be
     * redacted from this string using a placeholder value.
     */
    @Override
    public final String toString() {
        return ToString.builder("PartitionedPrefix").add("PartitionDateSource", partitionDateSourceAsString()).build();
    }

    public final <T> Optional<T> getValueForField(String fieldName, Class<T> clazz) {
        switch (fieldName) {
        case "PartitionDateSource":
            return Optional.ofNullable(clazz.cast(partitionDateSourceAsString()));
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
        map.put("PartitionDateSource", PARTITION_DATE_SOURCE_FIELD);
        return Collections.unmodifiableMap(map);
    }

    private static <T> Function<Object, T> getter(Function<PartitionedPrefix, T> g) {
        return obj -> g.apply((PartitionedPrefix) obj);
    }

    private static <T> BiConsumer<Object, T> setter(BiConsumer<Builder, T> s) {
        return (obj, val) -> s.accept((Builder) obj, val);
    }

    @Mutable
    @NotThreadSafe
    public interface Builder extends SdkPojo, CopyableBuilder<Builder, PartitionedPrefix> {
        /**
         * <p>
         * Specifies the partition date source for the partitioned prefix. <code>PartitionDateSource</code> can be
         * <code>EventTime</code> or <code>DeliveryTime</code>.
         * </p>
         * <p>
         * For <code>DeliveryTime</code>, the time in the log file names corresponds to the delivery time for the log
         * files.
         * </p>
         * <p>
         * For <code>EventTime</code>, The logs delivered are for a specific day only. The year, month, and day
         * correspond to the day on which the event occurred, and the hour, minutes and seconds are set to 00 in the
         * key.
         * </p>
         * 
         * @param partitionDateSource
         *        Specifies the partition date source for the partitioned prefix. <code>PartitionDateSource</code> can
         *        be <code>EventTime</code> or <code>DeliveryTime</code>.</p>
         *        <p>
         *        For <code>DeliveryTime</code>, the time in the log file names corresponds to the delivery time for the
         *        log files.
         *        </p>
         *        <p>
         *        For <code>EventTime</code>, The logs delivered are for a specific day only. The year, month, and day
         *        correspond to the day on which the event occurred, and the hour, minutes and seconds are set to 00 in
         *        the key.
         * @see PartitionDateSource
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see PartitionDateSource
         */
        Builder partitionDateSource(String partitionDateSource);

        /**
         * <p>
         * Specifies the partition date source for the partitioned prefix. <code>PartitionDateSource</code> can be
         * <code>EventTime</code> or <code>DeliveryTime</code>.
         * </p>
         * <p>
         * For <code>DeliveryTime</code>, the time in the log file names corresponds to the delivery time for the log
         * files.
         * </p>
         * <p>
         * For <code>EventTime</code>, The logs delivered are for a specific day only. The year, month, and day
         * correspond to the day on which the event occurred, and the hour, minutes and seconds are set to 00 in the
         * key.
         * </p>
         * 
         * @param partitionDateSource
         *        Specifies the partition date source for the partitioned prefix. <code>PartitionDateSource</code> can
         *        be <code>EventTime</code> or <code>DeliveryTime</code>.</p>
         *        <p>
         *        For <code>DeliveryTime</code>, the time in the log file names corresponds to the delivery time for the
         *        log files.
         *        </p>
         *        <p>
         *        For <code>EventTime</code>, The logs delivered are for a specific day only. The year, month, and day
         *        correspond to the day on which the event occurred, and the hour, minutes and seconds are set to 00 in
         *        the key.
         * @see PartitionDateSource
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see PartitionDateSource
         */
        Builder partitionDateSource(PartitionDateSource partitionDateSource);
    }

    static final class BuilderImpl implements Builder {
        private String partitionDateSource;

        private BuilderImpl() {
        }

        private BuilderImpl(PartitionedPrefix model) {
            partitionDateSource(model.partitionDateSource);
        }

        public final String getPartitionDateSource() {
            return partitionDateSource;
        }

        public final void setPartitionDateSource(String partitionDateSource) {
            this.partitionDateSource = partitionDateSource;
        }

        @Override
        public final Builder partitionDateSource(String partitionDateSource) {
            this.partitionDateSource = partitionDateSource;
            return this;
        }

        @Override
        public final Builder partitionDateSource(PartitionDateSource partitionDateSource) {
            this.partitionDateSource(partitionDateSource == null ? null : partitionDateSource.toString());
            return this;
        }

        @Override
        public PartitionedPrefix build() {
            return new PartitionedPrefix(this);
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
