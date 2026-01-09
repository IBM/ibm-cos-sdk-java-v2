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

package com.ibm.cos.v2.services.sts.model;

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
import com.ibm.cos.v2.awscore.AwsRequestOverrideConfiguration;
import com.ibm.cos.v2.core.SdkField;
import com.ibm.cos.v2.core.SdkPojo;
import com.ibm.cos.v2.core.protocol.MarshallLocation;
import com.ibm.cos.v2.core.protocol.MarshallingType;
import com.ibm.cos.v2.core.traits.LocationTrait;
import com.ibm.cos.v2.utils.ToString;
import com.ibm.cos.v2.utils.builder.CopyableBuilder;
import com.ibm.cos.v2.utils.builder.ToCopyableBuilder;

/**
 */
@Generated("com.ibm.cos.v2:codegen")
public final class DecodeAuthorizationMessageRequest extends StsRequest implements
        ToCopyableBuilder<DecodeAuthorizationMessageRequest.Builder, DecodeAuthorizationMessageRequest> {
    private static final SdkField<String> ENCODED_MESSAGE_FIELD = SdkField.<String> builder(MarshallingType.STRING)
            .memberName("EncodedMessage").getter(getter(DecodeAuthorizationMessageRequest::encodedMessage))
            .setter(setter(Builder::encodedMessage))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("EncodedMessage").build()).build();

    private static final List<SdkField<?>> SDK_FIELDS = Collections.unmodifiableList(Arrays.asList(ENCODED_MESSAGE_FIELD));

    private static final Map<String, SdkField<?>> SDK_NAME_TO_FIELD = memberNameToFieldInitializer();

    private final String encodedMessage;

    private DecodeAuthorizationMessageRequest(BuilderImpl builder) {
        super(builder);
        this.encodedMessage = builder.encodedMessage;
    }

    /**
     * <p>
     * The encoded message that was returned with the response.
     * </p>
     * 
     * @return The encoded message that was returned with the response.
     */
    public final String encodedMessage() {
        return encodedMessage;
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
        hashCode = 31 * hashCode + Objects.hashCode(encodedMessage());
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
        if (!(obj instanceof DecodeAuthorizationMessageRequest)) {
            return false;
        }
        DecodeAuthorizationMessageRequest other = (DecodeAuthorizationMessageRequest) obj;
        return Objects.equals(encodedMessage(), other.encodedMessage());
    }

    /**
     * Returns a string representation of this object. This is useful for testing and debugging. Sensitive data will be
     * redacted from this string using a placeholder value.
     */
    @Override
    public final String toString() {
        return ToString.builder("DecodeAuthorizationMessageRequest").add("EncodedMessage", encodedMessage()).build();
    }

    public final <T> Optional<T> getValueForField(String fieldName, Class<T> clazz) {
        switch (fieldName) {
        case "EncodedMessage":
            return Optional.ofNullable(clazz.cast(encodedMessage()));
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
        map.put("EncodedMessage", ENCODED_MESSAGE_FIELD);
        return Collections.unmodifiableMap(map);
    }

    private static <T> Function<Object, T> getter(Function<DecodeAuthorizationMessageRequest, T> g) {
        return obj -> g.apply((DecodeAuthorizationMessageRequest) obj);
    }

    private static <T> BiConsumer<Object, T> setter(BiConsumer<Builder, T> s) {
        return (obj, val) -> s.accept((Builder) obj, val);
    }

    @Mutable
    @NotThreadSafe
    public interface Builder extends StsRequest.Builder, SdkPojo, CopyableBuilder<Builder, DecodeAuthorizationMessageRequest> {
        /**
         * <p>
         * The encoded message that was returned with the response.
         * </p>
         * 
         * @param encodedMessage
         *        The encoded message that was returned with the response.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder encodedMessage(String encodedMessage);

        @Override
        Builder overrideConfiguration(AwsRequestOverrideConfiguration overrideConfiguration);

        @Override
        Builder overrideConfiguration(Consumer<AwsRequestOverrideConfiguration.Builder> builderConsumer);
    }

    static final class BuilderImpl extends StsRequest.BuilderImpl implements Builder {
        private String encodedMessage;

        private BuilderImpl() {
        }

        private BuilderImpl(DecodeAuthorizationMessageRequest model) {
            super(model);
            encodedMessage(model.encodedMessage);
        }

        public final String getEncodedMessage() {
            return encodedMessage;
        }

        public final void setEncodedMessage(String encodedMessage) {
            this.encodedMessage = encodedMessage;
        }

        @Override
        public final Builder encodedMessage(String encodedMessage) {
            this.encodedMessage = encodedMessage;
            return this;
        }

        @Override
        public Builder overrideConfiguration(AwsRequestOverrideConfiguration overrideConfiguration) {
            super.overrideConfiguration(overrideConfiguration);
            return this;
        }

        @Override
        public Builder overrideConfiguration(Consumer<AwsRequestOverrideConfiguration.Builder> builderConsumer) {
            super.overrideConfiguration(builderConsumer);
            return this;
        }

        @Override
        public DecodeAuthorizationMessageRequest build() {
            return new DecodeAuthorizationMessageRequest(this);
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
