/*
 * Copyright 2017 IBM Corp. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */

package com.ibm.cos.v2.services.s3.model;

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
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * Represents the protection configuration for a bucket.
 */
public class BucketProtectionConfiguration extends S3Request
    implements SdkPojo, ToCopyableBuilder<BucketProtectionConfiguration.Builder, BucketProtectionConfiguration> {


    private static final SdkField<String> STATUS_FIELD = SdkField
        .<String>builder(MarshallingType.STRING)
        .memberName("Status")
        .getter(getter(BucketProtectionConfiguration::status))
        .setter(setter(BucketProtectionConfiguration.Builder::status))
        .traits(LocationTrait.builder()
                             .location(MarshallLocation.PAYLOAD)
                             .locationName("Status")
                             .unmarshallLocationName("Status").build(), RequiredTrait.create())
        .build();

    private static final SdkField<Retention> MIN_RETENTION_FIELD = SdkField
        .<Retention>builder((MarshallingType<Retention>) (MarshallingType<?>) MarshallingType.SDK_POJO)
        .memberName("MinimumRetention")
        .getter(getter(BucketProtectionConfiguration::minimumRetentionInDays))
        .setter(setter(BucketProtectionConfiguration.Builder::minimumRetentionInDays))
        .constructor(Retention::builder)
        .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD)
                             .locationName("MinimumRetention")
                             .build(), RequiredTrait.create())
        .build();

    private static final SdkField<Retention> DEFAULT_RETENTION_FIELD = SdkField
        .<Retention>builder((MarshallingType<Retention>) (MarshallingType<?>) MarshallingType.SDK_POJO)
        .memberName("DefaultRetention")
        .getter(getter(BucketProtectionConfiguration::defaultRetentionInDays))
        .setter(setter(BucketProtectionConfiguration.Builder::defaultRetentionInDays))
        .constructor(Retention::builder)
        .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD)
                             .locationName("DefaultRetention")
                             .build(), RequiredTrait.create())
        .build();

    private static final SdkField<Retention> MAX_RETENTION_FIELD = SdkField
        .<Retention>builder((MarshallingType<Retention>) (MarshallingType<?>) MarshallingType.SDK_POJO)
        .memberName("MaximumRetention")
        .getter(getter(BucketProtectionConfiguration::maximumRetentionInDays))
        .setter(setter(BucketProtectionConfiguration.Builder::maximumRetentionInDays))
        .constructor(Retention::builder)
        .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD)
                             .locationName("MaximumRetention")
                             .build())
        .build();

    private static final SdkField<Boolean> PERMANENT_RETENTION_FIELD = SdkField
        .<Boolean>builder(MarshallingType.BOOLEAN)
        .memberName("EnablePermanentRetention")
        .getter(getter(BucketProtectionConfiguration::permanentRetentionEnabled))
        .setter(setter(BucketProtectionConfiguration.Builder::permanentRetentionEnabled))
        .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD)
                             .locationName("EnablePermanentRetention")
                             .build())
        .build();
    private static final List<SdkField<?>> SDK_FIELDS = Collections.unmodifiableList(Arrays.asList(STATUS_FIELD,
                                                                                                   MIN_RETENTION_FIELD,
                                                                                                   DEFAULT_RETENTION_FIELD,
                                                                                                   MAX_RETENTION_FIELD, PERMANENT_RETENTION_FIELD));

    //private static final Map<String, SdkField<?>> SDK_NAME_TO_FIELD = memberNameToFieldInitializer();

    /** The current protection configuration status */
    private final String status;
    private final Retention minimumRetentionInDays;
    private final Retention defaultRetentionInDays;
    private final Retention maximumRetentionInDays;
    private final Boolean permanentRetentionEnabled;

    private BucketProtectionConfiguration(BuilderImpl builder) {
        super(builder);
        this.status = builder.status;
        this.minimumRetentionInDays = builder.minimumRetentionInDays;
        this.defaultRetentionInDays = builder.defaultRetentionInDays;
        this.maximumRetentionInDays = builder.maximumRetentionInDays;
        this.permanentRetentionEnabled = builder.permanentRetentionEnabled;
    }

    private static <T> Function<Object, T> getter(Function<BucketProtectionConfiguration, T> g) {
        return obj -> g.apply((BucketProtectionConfiguration) obj);
    }

    private static <T> BiConsumer<Object, T> setter(BiConsumer<BucketProtectionConfiguration.Builder, T> s) {
        return (obj, val) -> s.accept((BucketProtectionConfiguration.Builder) obj, val);
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
        hashCode = 31 * hashCode + Objects.hashCode(status());
        hashCode = 31 * hashCode + Objects.hashCode(maximumRetentionInDays());
        hashCode = 31 * hashCode + Objects.hashCode(minimumRetentionInDays());
        hashCode = 31 * hashCode + Objects.hashCode(defaultRetentionInDays());
        hashCode = 31 * hashCode + Objects.hashCode(permanentRetentionEnabled());
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
        if (!(obj instanceof BucketProtectionConfiguration)) {
            return false;
        }
        BucketProtectionConfiguration other = (BucketProtectionConfiguration) obj;
        return Objects.equals(status(), other.status()) && Objects.equals(maximumRetentionInDays(), other.maximumRetentionInDays())
               && Objects.equals(minimumRetentionInDays(), other.minimumRetentionInDays())
               && Objects.equals(defaultRetentionInDays(), other.defaultRetentionInDays())
               && Objects.equals(permanentRetentionEnabled(), other.permanentRetentionEnabled());
    }

    /**
     * Returns a string representation of this object. This is useful for testing and debugging. Sensitive data will be
     * redacted from this string using a placeholder value.
     */
    @Override
    public final String toString() {
        return ToString.builder("BucketProtectionConfiguration")
                       .add("Status", status())
                       .add("MaximumRetentionInDays", maximumRetentionInDays())
                       .add("MinimumRetentionInDays", minimumRetentionInDays())
                       .add("DefaultRetentionInDays", defaultRetentionInDays())
                       .add("PermanentRetentionEnabled", permanentRetentionEnabled()).build();
    }

    public final <T> Optional<T> getValueForField(String fieldName, Class<T> clazz) {
        switch (fieldName) {
            case "Status":
                return Optional.ofNullable(clazz.cast(status()));
            case "MaximumRetentionInDays":
                return Optional.ofNullable(clazz.cast(maximumRetentionInDays()));
            case "MinimumRetentionInDays":
                return Optional.ofNullable(clazz.cast(minimumRetentionInDays()));
            case "DefaultRetentionInDays":
                return Optional.ofNullable(clazz.cast(defaultRetentionInDays()));
            case "PermanentRetentionEnabled":
                return Optional.ofNullable(clazz.cast(permanentRetentionEnabled()));
            default:
                return Optional.empty();
        }
    }

    @Override
    public List<SdkField<?>> sdkFields() {
        return SDK_FIELDS;
    }

    @Mutable
    @NotThreadSafe
    public interface Builder extends S3Request.Builder, SdkPojo, CopyableBuilder<BucketProtectionConfiguration.Builder, BucketProtectionConfiguration> {


        /**
         * Sets the desired bucket protection status for this configuration object.
         *
         * @param status
         *            The desired bucket protection status for this configuration object. See
         *            {@link BucketProtectionStatus} for a list of valid values.
         */
        Builder status(String status);

        /**
         * Sets the desired bucket protection status for this configuration object.
         *
         * @param status
         *            The desired bucket protection status for this configuration object. See
         *            {@link BucketProtectionStatus} for a list of valid values.
         */
        Builder status(BucketProtectionStatus status);


        Builder minimumRetentionInDays(Retention minimumRetentionInDays);


        Builder maximumRetentionInDays(Retention maximumRetentionInDays);


        Builder defaultRetentionInDays(Retention defaultRetentionInDays);

        /**
         * Sets permanent retention true or false on the bucket.
         *
         * @param permanentRetentionEnabled
         *            Sets permanent retention enablement.
         */
        Builder permanentRetentionEnabled(Boolean permanentRetentionEnabled);

        /* convenience helpers to set the retention*/
        /**
         * Sets the desired bucket protection minimum retention for this configuration object.
         *
         * @param minimumRetentionInDays
         *            The desired bucket protection minimum retention for this configuration object.
         */
        default Builder minimumRetentionInDays(Integer minimumRetentionInDays) {
            return minimumRetentionInDays(Retention.builder().days(minimumRetentionInDays).build());
        }

        /**
         * Sets the desired bucket protection default retention for this configuration object.
         *
         * @param defaultRetentionInDays
         *            The desired bucket protection default retention for this configuration object.
         */

        default Builder defaultRetentionInDays(Integer defaultRetentionInDays) {
            return defaultRetentionInDays(Retention.builder().days(defaultRetentionInDays).build());
        }

        /**
         * Sets the desired bucket protection maximum retention for this configuration object.
         *
         * @param maximumRetentionInDays
         *            The desired bucket protection maximum retention for this configuration object.
         */
        default Builder maximumRetentionInDays(Integer maximumRetentionInDays) {
            return maximumRetentionInDays(Retention.builder().days(maximumRetentionInDays).build());
        }
    }

    static private final class BuilderImpl extends S3Request.BuilderImpl implements BucketProtectionConfiguration.Builder {

        private String status;

        private Retention minimumRetentionInDays;

        private Retention defaultRetentionInDays;

        private Retention maximumRetentionInDays;

        private Boolean permanentRetentionEnabled;

        private BuilderImpl(){}

        private BuilderImpl(BucketProtectionConfiguration model) {
            super(model);
            status(model.status);
            minimumRetentionInDays(model.minimumRetentionInDays);
            maximumRetentionInDays(model.maximumRetentionInDays);
            defaultRetentionInDays(model.defaultRetentionInDays);
            permanentRetentionEnabled(model.permanentRetentionEnabled);
        }

        @Override
        public Builder status(String status){
            this.status = status;
            return this;
        }


        @Override
        public Builder status(BucketProtectionStatus status){
            this.status = status.toString();
            return this;
        }

        @Override
        public Builder minimumRetentionInDays(Retention minimumRetentionInDays) {
            this.minimumRetentionInDays = minimumRetentionInDays;
            return this;
        }

        @Override
        public Builder defaultRetentionInDays(Retention defaultRetentionInDays) {
            this.defaultRetentionInDays = defaultRetentionInDays;
            return this;
        }

        @Override
        public Builder maximumRetentionInDays(Retention maximumRetentionInDays) {
            this.maximumRetentionInDays = maximumRetentionInDays;
            return this;
        }

        @Override
        public Builder permanentRetentionEnabled(Boolean permanentRetentionEnabled) {
            this.permanentRetentionEnabled = permanentRetentionEnabled;
            return this;
        }

        @Override
        public List<SdkField<?>> sdkFields() {
            return SDK_FIELDS;
        }

        @Override
        public BucketProtectionConfiguration build() {
            return new BucketProtectionConfiguration(this);
        }
    }

    /**
     * @return The current status of the protection configuration for this bucket, or null if the
     *         status has not been configured.
     */
    public String status() {
        return status;
    }

    /**
     * @return The current minimum retention of the protection configuration for this bucket, or null if the
     *         minimum retention has not been configured.
     */
    public Retention minimumRetentionInDays() {
        return minimumRetentionInDays;
    }

    /**
     * @return The current default retention of the protection configuration for this bucket, or null if the
     *         default retention has not been configured.
     */
    public Retention defaultRetentionInDays() {
        return defaultRetentionInDays;
    }


    /**
     * @return The current maximum retention of the protection configuration for this bucket, or null if the
     *         maximum retention has not been configured.
     */
    public Retention maximumRetentionInDays() {
        return maximumRetentionInDays;
    }

    /**
     * @return Whether or not permanent retention is enabled on the bucket.
     */
    public Boolean permanentRetentionEnabled() {
        return permanentRetentionEnabled;
    }


}