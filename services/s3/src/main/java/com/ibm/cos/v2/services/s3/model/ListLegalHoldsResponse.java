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

import com.ibm.cos.v2.core.SdkField;
import com.ibm.cos.v2.core.SdkPojo;
import com.ibm.cos.v2.core.protocol.MarshallLocation;
import com.ibm.cos.v2.core.protocol.MarshallingType;
import com.ibm.cos.v2.core.traits.ListTrait;
import com.ibm.cos.v2.core.traits.LocationTrait;
import com.ibm.cos.v2.core.traits.TimestampFormatTrait;
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
 * Response object returned from {@link com.ibm.cos.v2.services.s3.S3Client#listLegalHolds(ListLegalHoldsRequest)}
 * operation.
 */
public class ListLegalHoldsResponse extends S3Response
    implements ToCopyableBuilder<ListLegalHoldsResponse.Builder, ListLegalHoldsResponse> {

    private static final SdkField<Instant> CREATE_TIME_FIELD = SdkField
        .<Instant>builder(MarshallingType.INSTANT)
        .memberName("CreateTime")
        .getter(getter(ListLegalHoldsResponse::createTime))
        .setter(setter(ListLegalHoldsResponse.Builder::createTime))
        .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("CreateTime")
                             .unmarshallLocationName("CreateTime").build(),
                TimestampFormatTrait.create(TimestampFormatTrait.Format.RFC_822)).build();

    private static final SdkField<List<LegalHold>> LEGAL_HOLDS_FIELD = SdkField
        .<List<LegalHold>>builder(MarshallingType.LIST)
        .memberName("LegalHolds")
        .getter(getter(ListLegalHoldsResponse::legalHolds))
        .setter(setter(Builder::legalHolds))
        .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("LegalHold")
                             .unmarshallLocationName("LegalHolds").build() ,
                ListTrait.builder().memberLocationName("LegalHold")
                         .memberFieldInfo(
                                 SdkField.<LegalHold> builder(MarshallingType.SDK_POJO)
                                .constructor(LegalHold::builder)
                                .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD)
                                                 .locationName("LegalHold").unmarshallLocationName("LegalHold").build()).build())
    .build()).build();

    private static final SdkField<Long> RETENTION_PERIOD_FIELD = SdkField
        .<Long>builder(MarshallingType.LONG)
        .memberName("RetentionPeriod")
        .getter(getter(ListLegalHoldsResponse::retentionPeriod))
        .setter(setter(Builder::retentionPeriod))
        .traits(LocationTrait.builder()
                             .location(MarshallLocation.PAYLOAD)
                             .locationName("RetentionPeriod").unmarshallLocationName("RetentionPeriod")
                             .build())
        .build();

    private static final SdkField<Instant> RETENTION_EXPIRATION_DATE_FIELD = SdkField
        .<Instant>builder(MarshallingType.INSTANT)
        .memberName("RetentionExpirationDate")
        .getter(getter(ListLegalHoldsResponse::retentionExpirationDate))
        .setter(setter(Builder::retentionExpirationDate))
        .traits(LocationTrait.builder()
                             .location(MarshallLocation.PAYLOAD)
                             .locationName("RetentionPeriodExpirationDate").unmarshallLocationName("RetentionPeriodExpirationDate")
                             .build(), TimestampFormatTrait.create(TimestampFormatTrait.Format.RFC_822))
        .build();

    @Override
    public List<SdkField<?>> sdkFields() {
        return SDK_FIELDS;
    }

    private static final List<SdkField<?>> SDK_FIELDS = Collections.unmodifiableList(Arrays.asList(CREATE_TIME_FIELD,
                                                                                              LEGAL_HOLDS_FIELD,
                                                             RETENTION_PERIOD_FIELD, RETENTION_EXPIRATION_DATE_FIELD));

    /** Creation time for the object */
    private final Instant createTime;

    /** A List of legal holds that have been added to the object */
    private final List<LegalHold> legalHolds;

    /** Retention period for the object, in seconds */
    private final long retentionPeriod;

    /** Date on which the retention period will expire */
    private final Instant retentionExpirationDate;

    /**
     * Constructs a new {@link ListLegalHoldsResponse} object and
     * initializes all required and optional object fields.
     */
    public ListLegalHoldsResponse(BuilderImpl builder) {
        super(builder);
        this.createTime = builder.createTime;
        this.legalHolds = builder.legalHolds;
        this.retentionPeriod = builder.retentionPeriod;
        this.retentionExpirationDate = builder.retentionExpirationDate;
    }

    private static <T> Function<Object, T> getter(Function<ListLegalHoldsResponse, T> g) {
        return obj -> g.apply((ListLegalHoldsResponse) obj);
    }

    private static <T> BiConsumer<Object, T> setter(BiConsumer<ListLegalHoldsResponse.Builder, T> s) {
        return (obj, val) -> s.accept((ListLegalHoldsResponse.Builder) obj, val);
    }


    /**
     * Gets creation time for the object/
     *
     * @return Creation time for the object
     */
    public Instant createTime() {
        return createTime;
    }

    /**
     * Gets the list of legal holds for the object.
     */
    public List<LegalHold> legalHolds() {
        return legalHolds;
    }

    /**
     * Gets the retention period for the object.
     *
     * @return the object's retention period
     */
    public long retentionPeriod() {
        return retentionPeriod;
    }

    /**
     * Gets the retention expiration date for the object.
     *
     * @return The object's retention expiration date
     */
    public Instant retentionExpirationDate() {
        return retentionExpirationDate;
    }

    @Override
    public Builder toBuilder() {
        return new BuilderImpl(this);
    }

    public static Builder builder() {
        return new BuilderImpl();
    }

    @Override
    public final int hashCode() {
        int hashCode = 1;
        hashCode = 31 * hashCode + super.hashCode();
        hashCode = 31 * hashCode + Objects.hashCode(createTime());
        hashCode = 31 * hashCode + Objects.hashCode(legalHolds());
        hashCode = 31 * hashCode + Objects.hashCode(retentionPeriod());
        hashCode = 31 * hashCode + Objects.hashCode(retentionExpirationDate());
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
        if (!(obj instanceof ListLegalHoldsResponse)) {
            return false;
        }
        ListLegalHoldsResponse other = (ListLegalHoldsResponse) obj;
        return Objects.equals(createTime(), other.createTime()) &&
                      Objects.equals(legalHolds(), other.legalHolds()) &&
                      Objects.equals(retentionPeriod(), other.retentionPeriod()) &&
                      Objects.equals(retentionExpirationDate(), other.retentionExpirationDate());
    }

    /**
     * Returns a string representation of this object. This is useful for testing and debugging. Sensitive data will be
     * redacted from this string using a placeholder value.
     */
    @Override
    public final String toString() {
        return ToString.builder("ListLegalHoldsResult")
                       .add("CreateTime", createTime)
                       .add("LegalHolds", legalHolds)
                       .add("RetentionPeriod", retentionPeriod)
                       .add("RetentionExpirationDate", retentionExpirationDate)
                       .build();
    }

    public final <T> Optional<T> getValueForField(String fieldName, Class<T> clazz) {
        switch (fieldName) {
            case "CreateTime":
                return Optional.ofNullable(clazz.cast(createTime()));
            case "LegalHolds":
                return Optional.ofNullable(clazz.cast(legalHolds()));
            case "RetentionPeriod":
                return Optional.of(clazz.cast(retentionPeriod()));
            case "RetentionExpirationDate":
                return Optional.ofNullable(clazz.cast(retentionExpirationDate()));
            default:
                return Optional.empty();
        }
    }

    public interface Builder extends S3Response.Builder, SdkPojo,
                                     CopyableBuilder<ListLegalHoldsResponse.Builder,ListLegalHoldsResponse> {

        /**
         * Sets the name of the bucket which contains the specified object
         * and returns the updated {@link ListLegalHoldsResponse.Builder} so that additional
         * method calls may be chained together.
         *
         * @param creationTime
         *            The time at which the object was created.
         *
         * @return This {@link ListLegalHoldsResponse.Builder}, enabling additional method calls
         *         to be chained together.
         */
        Builder createTime(Instant creationTime);

        /**
         * Sets the list of legal holds for the object.
         * and returns the updated {@link ListLegalHoldsResponse.Builder} so that additional
         * method calls may be chained together.
         *
         * @param legalHolds
         *            The list of legal holds for the object.
         *
         * @return This {@link ListLegalHoldsResponse.Builder}, enabling additional method calls
         *         to be chained together.
         */
        Builder legalHolds(List<LegalHold> legalHolds);

        /**
         * Sets the retention period for the object.
         * and returns the updated {@link ListLegalHoldsResponse.Builder} so that additional
         * method calls may be chained together.
         *
         * @param retentionPeriod
         *            The object's retention period
         *
         * @return This {@link ListLegalHoldsResponse.Builder}, enabling additional method calls
         *         to be chained together.
         */
        Builder retentionPeriod(long retentionPeriod);

        /**
         * Sets the retention expiration date for the object.
         * and returns the updated {@link ListLegalHoldsResponse.Builder} so that additional
         * method calls may be chained together.
         *
         * @param retentionExpirationDate
         *            The objects' retention expiration date.
         *
         * @return This {@link ListLegalHoldsResponse.Builder}, enabling additional method calls
         *         to be chained together.
         */
        Builder retentionExpirationDate(Instant retentionExpirationDate);

    }

    static private final class BuilderImpl extends S3Response.BuilderImpl implements Builder {

        private Instant createTime;

        private List<LegalHold> legalHolds;

        private long retentionPeriod;

        private Instant retentionExpirationDate;

        private BuilderImpl() {}

        BuilderImpl(ListLegalHoldsResponse model) {
            super(model);
            createTime(model.createTime);
            legalHolds(model.legalHolds);
            retentionPeriod(model.retentionPeriod);
            retentionExpirationDate(model.retentionExpirationDate);
        }

        @Override
        public Builder createTime(Instant creationTime) {
            this.createTime = creationTime;
            return this;
        }

        @Override
        public Builder legalHolds(List<LegalHold> legalHolds) {
            this.legalHolds = legalHolds;
            return this;
        }

        @Override
        public Builder retentionPeriod(long retentionPeriod) {
            this.retentionPeriod = retentionPeriod;
            return this;
        }

        @Override
        public Builder retentionExpirationDate(Instant retentionExpirationDate) {
            this.retentionExpirationDate = retentionExpirationDate;
            return this;
        }

        @Override
        public List<SdkField<?>> sdkFields() {
            return SDK_FIELDS;
        }

        @Override
        public ListLegalHoldsResponse build() {
            return new ListLegalHoldsResponse(this);
        }
    }



}
