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
import com.ibm.cos.v2.utils.ToString;
import com.ibm.cos.v2.utils.builder.CopyableBuilder;
import com.ibm.cos.v2.utils.builder.ToCopyableBuilder;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.function.Function;

public class GetBucketProtectionConfigurationResponse extends S3Response
    implements ToCopyableBuilder<GetBucketProtectionConfigurationResponse.Builder, GetBucketProtectionConfigurationResponse> {

    private static final SdkField<String> STATUS_FIELD = SdkField
        .<String>builder(MarshallingType.STRING)
        .memberName("Status")
        .getter(getter(GetBucketProtectionConfigurationResponse::status))
        .setter(setter(GetBucketProtectionConfigurationResponse.Builder::status))
        .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD)
                 .locationName("Status").unmarshallLocationName("Status").build())
        .build();

    private static final SdkField<Retention> MIN_RETENTION_FIELD = SdkField
        .<Retention>builder((MarshallingType<Retention>) (MarshallingType<?>) MarshallingType.SDK_POJO)
        .memberName("MinimumRetention")
        .getter(getter(GetBucketProtectionConfigurationResponse::minimumRetention))
        .setter(setter(GetBucketProtectionConfigurationResponse.Builder::minimumRetention))
        .constructor(Retention::builder)
        .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD)
                             .locationName("MinimumRetention").unmarshallLocationName("MinimumRetention")
                             .build())
        .build();


    private static final SdkField<Retention> DEFAULT_RETENTION_FIELD = SdkField
        .<Retention>builder((MarshallingType<Retention>) (MarshallingType<?>) MarshallingType.SDK_POJO)
        .memberName("DefaultRetention")
        .getter(getter(GetBucketProtectionConfigurationResponse::defaultRetention))
        .setter(setter(GetBucketProtectionConfigurationResponse.Builder::defaultRetention))
        .constructor(Retention::builder)
        .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD)
                             .locationName("DefaultRetention")
                             .build())
        .build();

    private static final SdkField<Retention> MAX_RETENTION_FIELD = SdkField
        .<Retention>builder((MarshallingType<Retention>) (MarshallingType<?>) MarshallingType.SDK_POJO)
        .memberName("MaximumRetention")
        .getter(getter(GetBucketProtectionConfigurationResponse::maximumRetention))
        .setter(setter(GetBucketProtectionConfigurationResponse.Builder::maximumRetention))
        .constructor(Retention::builder)
        .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD)
                             .locationName("MaximumRetention")
                             .build())
        .build();

    private static final SdkField<Boolean> PERMANENT_RETENTION_FIELD = SdkField
        .<Boolean>builder(MarshallingType.BOOLEAN)
        .memberName("EnablePermanentRetention")
        .getter(getter(GetBucketProtectionConfigurationResponse::permanentRetentionEnabled))
        .setter(setter(GetBucketProtectionConfigurationResponse.Builder::permanentRetentionEnabled))
        .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD)
                             .locationName("EnablePermanentRetention")
                             .build())
        .build();

    private static final List<SdkField<?>> SDK_FIELDS = Collections.unmodifiableList(Arrays.asList(STATUS_FIELD,
                                                                                                   MIN_RETENTION_FIELD,
                                                                                                   MAX_RETENTION_FIELD,
                                                                                                   DEFAULT_RETENTION_FIELD, PERMANENT_RETENTION_FIELD));

    private static final Map<String, SdkField<?>> SDK_NAME_TO_FIELD = memberNameToFieldInitializer();

    private final String status;

    private final Retention minimumRetention;

    private final Retention defaultRetention;

    private final Retention maximumRetention;

    private final Boolean permanentRetentionEnabled;

    private GetBucketProtectionConfigurationResponse(BuilderImpl builder) {
        super(builder);
        this.status = builder.status;
        this.minimumRetention = builder.minimumRetention;
        this.defaultRetention = builder.defaultRetention;
        this.maximumRetention = builder.maximumRetention;
        this.permanentRetentionEnabled = builder.permanentRetentionEnabled;
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
        hashCode = 31 * hashCode + Objects.hashCode((status()));
        hashCode = 31 * hashCode + Objects.hashCode(maximumRetention());
        hashCode = 31 * hashCode + Objects.hashCode(minimumRetention());
        hashCode = 31 * hashCode + Objects.hashCode(defaultRetention());
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
        if (!(obj instanceof GetBucketProtectionConfigurationResponse)) {
            return false;
        }
        GetBucketProtectionConfigurationResponse other = (GetBucketProtectionConfigurationResponse) obj;
        return Objects.equals(status(), other.status())
         && Objects.equals(maximumRetention(), other.maximumRetention())
        && Objects.equals(minimumRetention(), other.minimumRetention())
        && Objects.equals(defaultRetention(), other.defaultRetention())
        && Objects.equals(permanentRetentionEnabled(), other.permanentRetentionEnabled());
    }

    /**
     * Returns a string representation of this object. This is useful for testing and debugging. Sensitive data will be
     * redacted from this string using a placeholder value.
     */
    @Override
    public final String toString() {
        return ToString.builder("GetBucketProtectionConfigurationResponse")
                       .add("Status",status())
                       .add("MaximumRetentionInDays", maximumRetention())
                       .add("MinimumRetentionInDays", minimumRetention())
                       .add("DefaultRetentionInDays", defaultRetention())
                       .add("PermanentRetentionEnabled", permanentRetentionEnabled()).build();
    }

    public final <T> Optional<T> getValueForField(String fieldName, Class<T> clazz) {
        switch (fieldName) {
            case "Status":
                return Optional.ofNullable((clazz.cast(status())));
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
    public final List<SdkField<?>> sdkFields() {
        return SDK_FIELDS;
    }

    @Override
    public final Map<String, SdkField<?>> sdkFieldNameToField() {
        return SDK_NAME_TO_FIELD;
    }

    private static Map<String, SdkField<?>> memberNameToFieldInitializer() {
        Map<String, SdkField<?>> map = new HashMap<>();
        map.put("Status", STATUS_FIELD);
        map.put("MinimumRetention", MIN_RETENTION_FIELD);
        map.put("MaximumRetention", MAX_RETENTION_FIELD);
        map.put("DefaultRetention", DEFAULT_RETENTION_FIELD);
        map.put("EnablePermanentRetention", PERMANENT_RETENTION_FIELD);
        return Collections.unmodifiableMap(map);
    }

    private static <T> Function<Object, T> getter(Function<GetBucketProtectionConfigurationResponse, T> g) {
        return obj -> g.apply((GetBucketProtectionConfigurationResponse) obj);
    }

    private static <T> BiConsumer<Object, T> setter(BiConsumer<GetBucketProtectionConfigurationResponse.Builder, T> s) {
        return (obj, val) -> s.accept((GetBucketProtectionConfigurationResponse.Builder) obj, val);
    }

    @Mutable
    @NotThreadSafe
    public interface Builder extends S3Response.Builder, SdkPojo,
                                     CopyableBuilder<GetBucketProtectionConfigurationResponse.Builder, GetBucketProtectionConfigurationResponse> {

        Builder status(String status);

        Builder minimumRetention(Retention minimumRetention);

        Builder maximumRetention(Retention maximumRetentionInDays);

        Builder defaultRetention(Retention defaultRetentionInDays);

        /**
         * Sets permanent retention true or false on the bucket.
         *
         * @param permanentRetentionEnabled
         *            Sets permanent retention enablement.
         */
        Builder permanentRetentionEnabled(Boolean permanentRetentionEnabled);

    }

    static final class BuilderImpl extends S3Response.BuilderImpl implements Builder {

        private String status;

        private Retention minimumRetention;

        private Retention defaultRetention;

        private Retention maximumRetention;

        private Boolean permanentRetentionEnabled;

        private BuilderImpl() {
        }

        private BuilderImpl(GetBucketProtectionConfigurationResponse model) {
            super(model);
            status(model.status);
            minimumRetention(model.minimumRetention);
            maximumRetention(model.maximumRetention);
            defaultRetention(model.defaultRetention);
            permanentRetentionEnabled(model.permanentRetentionEnabled);
        }

        public final void setStatus(String status) {
            this.status = status;
        }

        public final String getStatus() {
            return status;
        }

        @Override
        public final Builder status(String status) {
            this.status = status;
            return this;
        }

        @Override
        public Builder minimumRetention(Retention minimumRetention) {
            this.minimumRetention = minimumRetention;
            return this;
        }

        @Override
        public Builder defaultRetention(Retention defaultRetention) {
            this.defaultRetention = defaultRetention;
            return this;
        }

        @Override
        public Builder maximumRetention(Retention maximumRetention) {
            this.maximumRetention = maximumRetention;
            return this;
        }

        @Override
        public Builder permanentRetentionEnabled(Boolean permanentRetentionEnabled) {
            this.permanentRetentionEnabled = permanentRetentionEnabled;
            return this;
        }

        @Override
        public GetBucketProtectionConfigurationResponse build() {
            return new GetBucketProtectionConfigurationResponse(this);
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

    /**
     * @return The current status of the protection configuration for this bucket, or null if the
     *         status has not been configured.
     */
    public String status() {return status;}

    public Retention minimumRetention() {
        return minimumRetention;
    }

    /**
     * @return The current minimum retention days of the protection configuration for this bucket, or null if the
     *         minimum retention has not been configured.
     */
    public Integer minimumRetentionInDays() {
        return minimumRetention.days();
    }


    public Retention defaultRetention() {
        return defaultRetention;
    }

    /**
     * @return The current default retention (in days) of the protection configuration for this bucket, or null if the
     *         default retention has not been configured.
     */
    public Integer defaultRetentionInDays() {
        return defaultRetention.days();
    }


    public Retention maximumRetention() {
        return maximumRetention;
    }

    /**
     * @return The current maximum retention of the protection configuration for this bucket, or null if the
     *         maximum retention has not been configured.
     */
    public Integer maximumRetentionInDays() {
        return maximumRetention.days();
    }

    /**
     * @return Whether or not permanent retention is enabled on the bucket.
     */
    public Boolean permanentRetentionEnabled() {
        return permanentRetentionEnabled;
    }
}