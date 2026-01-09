/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License").
 * You may not use this file except in compliance with the License.
 * A copy of the License is located at
 *
 *  http://aws.amazon.com/apache2.0
 *
 * or in the "license" file accompanying this file. This file is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */

package com.ibm.cos.v2.services.s3.model;

import com.ibm.cos.v2.annotations.SdkInternalApi;
import com.ibm.cos.v2.core.SdkField;
import com.ibm.cos.v2.core.SdkPojo;
import com.ibm.cos.v2.core.protocol.MarshallLocation;
import com.ibm.cos.v2.core.protocol.MarshallingType;
import com.ibm.cos.v2.core.traits.LocationTrait;
import com.ibm.cos.v2.utils.builder.Buildable;
import com.ibm.cos.v2.utils.builder.CopyableBuilder;
import com.ibm.cos.v2.utils.builder.ToCopyableBuilder;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Function;

@SdkInternalApi
public final class Retention implements SdkPojo, Serializable, ToCopyableBuilder<Retention.Builder, Retention> {
    private final Integer days;

    private static final SdkField<Integer> DAYS_FIELD = SdkField
        .<Integer>builder(MarshallingType.INTEGER)
        .memberName("Days")
        .getter(getter(Retention::days))
        .setter(setter(Retention.Builder::days))
        .traits(LocationTrait.builder()
                             .location(MarshallLocation.PAYLOAD)
                             .locationName("Days").unmarshallLocationName("Days")
                             .build())
        .build();

    private static final List<SdkField<?>> SDK_FIELDS = Collections.unmodifiableList(
        Arrays.asList(DAYS_FIELD)
    );

    //constructor
    public Retention(BuilderImpl builder) {
        this.days = builder.days;
    }

    public Integer days() { return days; }

    @Override
    public List<SdkField<?>> sdkFields() {
        return Collections.singletonList(DAYS_FIELD);
    }

    public static Builder builder() {
        return new BuilderImpl();
    }

    @Override
    public Builder toBuilder() {
        return new BuilderImpl(this);
    }


    public interface Builder extends SdkPojo, CopyableBuilder<Retention.Builder, Retention> {
        Builder days(Integer days);
    }

    static final class BuilderImpl implements Builder {
        private Integer days;

        private BuilderImpl() {
        }

        private BuilderImpl(Retention model) {
            days(model.days);
        }

        @Override
        public Builder days(Integer days) {
            this.days = days;
            return this;
        }

        @Override
        public Retention build() {
            return new Retention(this);
        }

        @Override
        public List<SdkField<?>> sdkFields() {
            return SDK_FIELDS;
        }
    }

    private static <T> Function<Object, T> getter(Function<Retention, T> g) {
        return obj -> g.apply((Retention) obj);
    }

    private static <T> BiConsumer<Object, T> setter(BiConsumer<Retention.Builder, T> s) {
        return (obj, val) -> s.accept((Retention.Builder) obj, val);
    }
}
