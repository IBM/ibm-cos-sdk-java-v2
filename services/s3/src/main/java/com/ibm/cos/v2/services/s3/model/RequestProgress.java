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
 * Container for specifying if periodic <code>QueryProgress</code> messages should be sent.
 * </p>
 */
@Generated("com.ibm.cos.v2:codegen")
public final class RequestProgress implements SdkPojo, Serializable, ToCopyableBuilder<RequestProgress.Builder, RequestProgress> {
    private static final SdkField<Boolean> ENABLED_FIELD = SdkField
            .<Boolean> builder(MarshallingType.BOOLEAN)
            .memberName("Enabled")
            .getter(getter(RequestProgress::enabled))
            .setter(setter(Builder::enabled))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("Enabled")
                    .unmarshallLocationName("Enabled").build()).build();

    private static final List<SdkField<?>> SDK_FIELDS = Collections.unmodifiableList(Arrays.asList(ENABLED_FIELD));

    private static final Map<String, SdkField<?>> SDK_NAME_TO_FIELD = memberNameToFieldInitializer();

    private static final long serialVersionUID = 1L;

    private final Boolean enabled;

    private RequestProgress(BuilderImpl builder) {
        this.enabled = builder.enabled;
    }

    /**
     * <p>
     * Specifies whether periodic QueryProgress frames should be sent. Valid values: TRUE, FALSE. Default value: FALSE.
     * </p>
     * 
     * @return Specifies whether periodic QueryProgress frames should be sent. Valid values: TRUE, FALSE. Default value:
     *         FALSE.
     */
    public final Boolean enabled() {
        return enabled;
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
        hashCode = 31 * hashCode + Objects.hashCode(enabled());
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
        if (!(obj instanceof RequestProgress)) {
            return false;
        }
        RequestProgress other = (RequestProgress) obj;
        return Objects.equals(enabled(), other.enabled());
    }

    /**
     * Returns a string representation of this object. This is useful for testing and debugging. Sensitive data will be
     * redacted from this string using a placeholder value.
     */
    @Override
    public final String toString() {
        return ToString.builder("RequestProgress").add("Enabled", enabled()).build();
    }

    public final <T> Optional<T> getValueForField(String fieldName, Class<T> clazz) {
        switch (fieldName) {
        case "Enabled":
            return Optional.ofNullable(clazz.cast(enabled()));
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
        map.put("Enabled", ENABLED_FIELD);
        return Collections.unmodifiableMap(map);
    }

    private static <T> Function<Object, T> getter(Function<RequestProgress, T> g) {
        return obj -> g.apply((RequestProgress) obj);
    }

    private static <T> BiConsumer<Object, T> setter(BiConsumer<Builder, T> s) {
        return (obj, val) -> s.accept((Builder) obj, val);
    }

    @Mutable
    @NotThreadSafe
    public interface Builder extends SdkPojo, CopyableBuilder<Builder, RequestProgress> {
        /**
         * <p>
         * Specifies whether periodic QueryProgress frames should be sent. Valid values: TRUE, FALSE. Default value:
         * FALSE.
         * </p>
         * 
         * @param enabled
         *        Specifies whether periodic QueryProgress frames should be sent. Valid values: TRUE, FALSE. Default
         *        value: FALSE.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder enabled(Boolean enabled);
    }

    static final class BuilderImpl implements Builder {
        private Boolean enabled;

        private BuilderImpl() {
        }

        private BuilderImpl(RequestProgress model) {
            enabled(model.enabled);
        }

        public final Boolean getEnabled() {
            return enabled;
        }

        public final void setEnabled(Boolean enabled) {
            this.enabled = enabled;
        }

        @Override
        public final Builder enabled(Boolean enabled) {
            this.enabled = enabled;
            return this;
        }

        @Override
        public RequestProgress build() {
            return new RequestProgress(this);
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
