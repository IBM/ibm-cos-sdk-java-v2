/*
 * Copyright 2018 IBM Corp. All Rights Reserved.
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
import java.time.Instant;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * IBM specific: Request object containing all the options for extending the retention period of a protected object.
 */
public class ExtendObjectRetentionRequest extends S3Request
    implements SdkPojo, ToCopyableBuilder<ExtendObjectRetentionRequest.Builder, ExtendObjectRetentionRequest> {

    private static final SdkField<String> BUCKET_FIELD = SdkField
        .<String>builder(MarshallingType.STRING)
        .memberName("Bucket")
        .getter(getter(ExtendObjectRetentionRequest::bucket))
        .setter(setter(ExtendObjectRetentionRequest.Builder::bucket))
        .traits(LocationTrait.builder().location(MarshallLocation.PATH).locationName("Bucket")
                             .unmarshallLocationName("Bucket").build(), RequiredTrait.create()).build();

    private static final SdkField<String> KEY_FIELD = SdkField
        .<String>builder(MarshallingType.STRING)
        .memberName("Key")
        .getter(getter(ExtendObjectRetentionRequest::key))
        .setter(setter(ExtendObjectRetentionRequest.Builder::key))
        .traits(LocationTrait.builder().location(MarshallLocation.GREEDY_PATH).locationName("Key")
                             .unmarshallLocationName("Key").build(), RequiredTrait.create()).build();

    private static final SdkField<Long> ADDDITIONAL_RETENTION_PERIOD_FIELD = SdkField
        .<Long>builder(MarshallingType.LONG)
        .memberName("AdditionalRetentionPeriod")
        .getter(getter(ExtendObjectRetentionRequest::additionalRetentionPeriod))
        .setter(setter(ExtendObjectRetentionRequest.Builder::additionalRetentionPeriod))
        .traits(LocationTrait.builder().location(MarshallLocation.HEADER).locationName("additional-retention-period")
                             .unmarshallLocationName("additional-retention-period").build()).build();

    private static final SdkField<Long> EXTENDED_RETENTION_FROM_CURRENTTIME_FIELD = SdkField
        .<Long>builder(MarshallingType.LONG)
        .memberName("ExtendRetentionFromCurrentTime")
        .getter(getter(ExtendObjectRetentionRequest::extendRetentionFromCurrentTime))
        .setter(setter(ExtendObjectRetentionRequest.Builder::extendRetentionFromCurrentTime))
        .traits(LocationTrait.builder().location(MarshallLocation.HEADER).locationName("extend-retention-from-current-time")
                             .unmarshallLocationName("extend-retention-from-current-time").build()).build();

    private static final SdkField<Instant> NEW_RETENTION_EXPIRATION_DATE_FIELD = SdkField
        .<Instant>builder(MarshallingType.INSTANT)
        .memberName("NewRetentionExpirationDate")
        .getter(getter(ExtendObjectRetentionRequest::newRetentionExpirationDate))
        .setter(setter(ExtendObjectRetentionRequest.Builder::newRetentionExpirationDate))
        .traits(LocationTrait.builder().location(MarshallLocation.HEADER).locationName("new-retention-expiration-date")
                             .unmarshallLocationName("new-retention-expiration-date").build()).build();

    private static final SdkField<Long> NEW_RETENTION_PERIOD_FIELD = SdkField
        .<Long>builder(MarshallingType.LONG)
        .memberName("NewRetentionPeriod")
        .getter(getter(ExtendObjectRetentionRequest::newRetentionPeriod))
        .setter(setter(ExtendObjectRetentionRequest.Builder::newRetentionPeriod))
        .traits(LocationTrait.builder().location(MarshallLocation.HEADER).locationName("new-retention-period")
                             .unmarshallLocationName("new-retention-period").build()).build();

    public static final List<SdkField<?>> SDK_FIELDS = Collections.unmodifiableList(Arrays.asList(BUCKET_FIELD, KEY_FIELD,
                                                                                                  ADDDITIONAL_RETENTION_PERIOD_FIELD,
                                                                                                  EXTENDED_RETENTION_FROM_CURRENTTIME_FIELD,
                                                                                                  NEW_RETENTION_EXPIRATION_DATE_FIELD,
                                                                                                  NEW_RETENTION_PERIOD_FIELD));


    /**
     * The name of the bucket containing the reference to the object to add a legal hold to.
     */
    private String bucket;

    /**
     * The key, the name of the reference to the object to add a legal hold to.
     */
    private String key;

    /**
     * Additional Retention Period
     */
    private Long additionalRetentionPeriod;

    /**
     * Retention Period in seconds for the object. The Retention will be enforced from the current time until current time + the
     * value in this header. This header will only be supported for objects that are currently stored with an indefinite retention
     * period (-1). This value has to be within the ranges defined for the bucket.
     */
    private Long extendRetentionFromCurrentTime;

    /**
     * New retention expiration date.
     */
    private Instant newRetentionExpirationDate;

    /**
     * Retention period, in seconds, to use for the object in place of the existing retention period stored for the object. If
     * this value is less than the existing value stored for the object, a 400 error will be returned. If this field and
     * Additional-Retention-Period and/or New-Retention-Expiration-Date are specified, a 400 error will be returned. If none of
     * the Request Headers are specified, a 400 error will be returned.
     */
    private Long newRetentionPeriod;

    /**
     * Returns the name of the bucket containing the reference to the object to add a legal hold to.
     */
    public String bucket() {
        return bucket;
    }

    /**
     * Gets the key, the name of the reference to the object to add a legal hold to.
     */
    public String key() {
        return key;
    }

    public Long additionalRetentionPeriod() {
        return additionalRetentionPeriod;
    }

    public Long extendRetentionFromCurrentTime() {
        return extendRetentionFromCurrentTime;
    }

    public Instant newRetentionExpirationDate() {
        return newRetentionExpirationDate;
    }

    public Long newRetentionPeriod() {
        return newRetentionPeriod;
    }

    /**
     * Constructs a new {@link ExtendObjectRetentionRequest} object and initializes all required and optional object fields.
     */
    public ExtendObjectRetentionRequest(BuilderImpl builder) {
        super(builder);
        this.bucket = builder.bucket;
        this.key = builder.key;
        this.additionalRetentionPeriod = builder.additionalRetentionPeriod;
        this.extendRetentionFromCurrentTime = builder.extendRetentionFromCurrentTime;
        this.newRetentionExpirationDate = builder.newRetentionExpirationDate;
        this.newRetentionPeriod = builder.newRetentionPeriod;
    }

    private static <T> Function<Object, T> getter(Function<ExtendObjectRetentionRequest, T> g) {
        return obj -> g.apply((ExtendObjectRetentionRequest) obj);
    }

    private static <T> BiConsumer<Object, T> setter(BiConsumer<ExtendObjectRetentionRequest.Builder, T> s) {
        return (obj, val) -> s.accept((ExtendObjectRetentionRequest.Builder) obj, val);
    }

    @Override
    public Builder toBuilder() {
        return new BuilderImpl(this);
    }

    public static Builder builder() {
        return new BuilderImpl();
    }

    @Override
    public List<SdkField<?>> sdkFields() {
        return SDK_FIELDS;
    }

    @Override
    public final int hashCode() {
        int hashCode = 1;
        hashCode = 31 * hashCode + super.hashCode();
        hashCode = 31 * hashCode + Objects.hashCode(bucket());
        hashCode = 31 * hashCode + Objects.hashCode(key());
        hashCode = 31 * hashCode + Objects.hashCode(additionalRetentionPeriod());
        hashCode = 31 * hashCode + Objects.hashCode(extendRetentionFromCurrentTime());
        hashCode = 31 * hashCode + Objects.hashCode(newRetentionExpirationDate());
        hashCode = 31 * hashCode + Objects.hashCode(newRetentionPeriod());
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
        if (!(obj instanceof ExtendObjectRetentionRequest)) {
            return false;
        }
        ExtendObjectRetentionRequest other = (ExtendObjectRetentionRequest) obj;
        return Objects.equals(bucket(), other.bucket()) && Objects.equals(key(), other.key())
               && Objects.equals(additionalRetentionPeriod(), other.additionalRetentionPeriod())
               && Objects.equals(extendRetentionFromCurrentTime(), other.extendRetentionFromCurrentTime())
               && Objects.equals(newRetentionExpirationDate(), other.newRetentionExpirationDate())
               && Objects.equals(newRetentionPeriod(), other.newRetentionPeriod());
    }

    /**
     * Returns a string representation of this object. This is useful for testing and debugging. Sensitive data will be redacted
     * from this string using a placeholder value.
     */
    @Override
    public final String toString() {
        return ToString.builder("ExtendObjectRetentionRequest")
                       .add("Bucket", bucket())
                       .add("Key", key())
                       .add("AdditionalRetentionPeriod", additionalRetentionPeriod())
                       .add("ExtendRetentionFromCurrentTime", extendRetentionFromCurrentTime())
                       .add("NewRetentionExpirationDate", newRetentionExpirationDate())
                       .add("NewRetentionPeriod", newRetentionPeriod()).build();
    }

    public final <T> Optional<T> getValueForField(String fieldName, Class<T> clazz) {
        switch (fieldName) {
            case "Bucket":
                return Optional.ofNullable(clazz.cast(bucket()));
            case "Key":
                return Optional.ofNullable(clazz.cast(key()));
            case "AdditionalRetentionPeriod":
                return Optional.ofNullable(clazz.cast(additionalRetentionPeriod()));
            case "ExtendRetentionFromCurrentTime":
                return Optional.ofNullable(clazz.cast(extendRetentionFromCurrentTime()));
            case "NewRetentionExpirationDate":
                return Optional.ofNullable(clazz.cast(newRetentionExpirationDate()));
            case "NewRetentionPeriod":
                return Optional.ofNullable(clazz.cast(newRetentionPeriod()));
            default:
                return Optional.empty();
        }
    }

    @Mutable
    @NotThreadSafe
    public interface Builder extends S3Request.Builder, SdkPojo,
                                     CopyableBuilder<ExtendObjectRetentionRequest.Builder, ExtendObjectRetentionRequest> {

        /**
         * Sets the name of the bucket containing the reference to the object to add a legal hold to.
         *
         * @param bucket: Name of the bucket
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder bucket(String bucket);

        /**
         * Sets the key, the name of the reference to the object to add a legal hold to.
         *
         * @param key: name of the reference to the object to add a legal hold to
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder key(String key);

        Builder additionalRetentionPeriod(Long additionalRetentionPeriod);

        Builder extendRetentionFromCurrentTime(Long extendRetentionFromCurrentTime);

        Builder newRetentionExpirationDate(Instant newRetentionExpirationDate);

        Builder newRetentionPeriod(Long newRetentionPeriod);
    }

    static private final class BuilderImpl extends S3Request.BuilderImpl implements ExtendObjectRetentionRequest.Builder {

        public String bucket;

        public String key;

        public Long additionalRetentionPeriod;

        public Long extendRetentionFromCurrentTime;

        public Instant newRetentionExpirationDate;

        public Long newRetentionPeriod;

        private BuilderImpl() {
        }

        BuilderImpl(ExtendObjectRetentionRequest model) {
            super(model);
            bucket(model.bucket);
            key(model.key);
            additionalRetentionPeriod(model.additionalRetentionPeriod);
            extendRetentionFromCurrentTime(model.extendRetentionFromCurrentTime);
            newRetentionExpirationDate(model.newRetentionExpirationDate);
            newRetentionPeriod(model.newRetentionPeriod);
        }

        public final String getBucket() {
            return bucket;
        }

        public final void setBucket(String bucket) {
            this.bucket = bucket;
        }

        @Override
        public Builder bucket(String bucket) {
            this.bucket = bucket;
            return this;
        }

        public final String getKey() {
            return key;
        }

        public final void setKey(String key) {
            this.key = key;
        }

        @Override
        public Builder key(String key) {
            this.key = key;
            return this;
        }

        public final Long getAdditionalRetentionPeriod() {
            return additionalRetentionPeriod;
        }

        public final void setAdditionalRetentionPeriod(Long additionalRetentionPeriod) {
            this.additionalRetentionPeriod = additionalRetentionPeriod;
        }

        @Override
        public Builder additionalRetentionPeriod(Long additionalRetentionPeriod) {
            System.out.println("setter invoked -> " + additionalRetentionPeriod);
            this.additionalRetentionPeriod = additionalRetentionPeriod;
            return this;
        }

        public final Long getExtendRetentionFromCurrentTime() {
            return extendRetentionFromCurrentTime;
        }

        public final void setExtendRetentionFromCurrentTime(Long extendRetentionFromCurrentTime) {
            this.extendRetentionFromCurrentTime = extendRetentionFromCurrentTime;
        }

        @Override
        public Builder extendRetentionFromCurrentTime(Long extendRetentionFromCurrentTime) {
            System.out.println("setter invoked -> " + extendRetentionFromCurrentTime);
            this.extendRetentionFromCurrentTime = extendRetentionFromCurrentTime;
            return this;
        }

        public final Instant getNewRetentionExpirationDate() {
            return newRetentionExpirationDate;
        }

        public final void setNewRetentionExpirationDate(Instant newRetentionExpirationDate) {
            this.newRetentionExpirationDate = newRetentionExpirationDate;
        }

        @Override
        public Builder newRetentionExpirationDate(Instant newRetentionExpirationDate) {
            this.newRetentionExpirationDate = newRetentionExpirationDate;
            return this;
        }

        public final Long getNewRetentionPeriod() {
            return newRetentionPeriod;
        }

        public final void setNewRetentionPeriod(Long newRetentionPeriod) {
            this.newRetentionPeriod = newRetentionPeriod;
        }

        @Override
        public Builder newRetentionPeriod(Long newRetentionPeriod) {
            this.newRetentionPeriod = newRetentionPeriod;
            return this;
        }

        @Override
        public List<SdkField<?>> sdkFields() {
            return SDK_FIELDS;
        }

        @Override
        public ExtendObjectRetentionRequest build() {
            return new ExtendObjectRetentionRequest(this);
        }
    }


}