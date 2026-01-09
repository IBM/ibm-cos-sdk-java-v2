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
import com.ibm.cos.v2.core.traits.LocationTrait;
import com.ibm.cos.v2.core.traits.TimestampFormatTrait;
import com.ibm.cos.v2.utils.builder.CopyableBuilder;
import com.ibm.cos.v2.utils.builder.ToCopyableBuilder;
import java.io.Serializable;
import java.time.Instant;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Function;

public class LegalHold implements SdkPojo, Serializable, ToCopyableBuilder<LegalHold.Builder, LegalHold> {


    private static final SdkField<Instant> DATE_FIELD = SdkField
        .<Instant>builder(MarshallingType.INSTANT)
        .memberName("Date")
        .getter(getter(LegalHold::date))
        .setter(setter(LegalHold.Builder::date))
        .traits(LocationTrait.builder()
                             .location(MarshallLocation.PAYLOAD)
                             .locationName("Date").unmarshallLocationName("Date")
                             .build(),
                TimestampFormatTrait.create(TimestampFormatTrait.Format.RFC_822))
        .build();

    private static final SdkField<String> ID_FIELD = SdkField
        .<String>builder(MarshallingType.STRING)
        .memberName("ID")
        .getter(getter(LegalHold::id))
        .setter(setter(LegalHold.Builder::id))
        .traits(LocationTrait.builder()
                             .location(MarshallLocation.PAYLOAD)
                             .locationName("ID").unmarshallLocationName("ID")
                             .build())
        .build();

    private static final List<SdkField<?>> SDK_FIELDS = Collections.unmodifiableList(
        Arrays.asList(DATE_FIELD,ID_FIELD)
    );

    /** creation date for the legal hold */
    private final Instant date;

    /** legal hold id */
    private final String id;

    //constructor
    public LegalHold(BuilderImpl builder) {
        this.date = builder.date;
        this.id = builder.id;
    }

    public Instant date() { return date; }

    public String id() { return id; }

    @Override
    public List<SdkField<?>> sdkFields() {
        return SDK_FIELDS;
    }

    public static Builder builder() {
        return new BuilderImpl();
    }

    public static Builder Builder() {
        return new BuilderImpl();
    }

    @Override
    public Builder toBuilder() {
        return new BuilderImpl(this);
    }

    public interface Builder extends SdkPojo, CopyableBuilder<LegalHold.Builder, LegalHold> {
       Builder date(Instant date);

       Builder id(String id);
    }

    static final class BuilderImpl implements Builder {
        private Instant date;

        private String id;

        private BuilderImpl() {
        }

        private BuilderImpl(LegalHold model) {
            date(model.date);
            id(model.id);
        }


        @Override
        public Builder date(Instant date) {
            this.date = date;
            return this;
        }

        @Override
        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public LegalHold build() {
            return new LegalHold(this);
        }

        @Override
        public List<SdkField<?>> sdkFields() {
            return SDK_FIELDS;
        }
    }

    private static <T> Function<Object, T> getter(Function<LegalHold, T> g) {
        return obj -> g.apply((LegalHold) obj);
    }

    private static <T> BiConsumer<Object, T> setter(BiConsumer<LegalHold.Builder, T> s) {
        return (obj, val) -> s.accept((LegalHold.Builder) obj, val);
    }
}
