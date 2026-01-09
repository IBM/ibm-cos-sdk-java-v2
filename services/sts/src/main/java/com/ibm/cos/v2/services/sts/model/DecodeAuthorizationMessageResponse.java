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
 * A document that contains additional information about the authorization status of a request from an encoded message
 * that is returned in response to an Amazon Web Services request.
 * </p>
 */
@Generated("com.ibm.cos.v2:codegen")
public final class DecodeAuthorizationMessageResponse extends StsResponse implements
        ToCopyableBuilder<DecodeAuthorizationMessageResponse.Builder, DecodeAuthorizationMessageResponse> {
    private static final SdkField<String> DECODED_MESSAGE_FIELD = SdkField.<String> builder(MarshallingType.STRING)
            .memberName("DecodedMessage").getter(getter(DecodeAuthorizationMessageResponse::decodedMessage))
            .setter(setter(Builder::decodedMessage))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("DecodedMessage").build()).build();

    private static final List<SdkField<?>> SDK_FIELDS = Collections.unmodifiableList(Arrays.asList(DECODED_MESSAGE_FIELD));

    private static final Map<String, SdkField<?>> SDK_NAME_TO_FIELD = memberNameToFieldInitializer();

    private final String decodedMessage;

    private DecodeAuthorizationMessageResponse(BuilderImpl builder) {
        super(builder);
        this.decodedMessage = builder.decodedMessage;
    }

    /**
     * <p>
     * The API returns a response with the decoded message.
     * </p>
     * 
     * @return The API returns a response with the decoded message.
     */
    public final String decodedMessage() {
        return decodedMessage;
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
        hashCode = 31 * hashCode + Objects.hashCode(decodedMessage());
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
        if (!(obj instanceof DecodeAuthorizationMessageResponse)) {
            return false;
        }
        DecodeAuthorizationMessageResponse other = (DecodeAuthorizationMessageResponse) obj;
        return Objects.equals(decodedMessage(), other.decodedMessage());
    }

    /**
     * Returns a string representation of this object. This is useful for testing and debugging. Sensitive data will be
     * redacted from this string using a placeholder value.
     */
    @Override
    public final String toString() {
        return ToString.builder("DecodeAuthorizationMessageResponse").add("DecodedMessage", decodedMessage()).build();
    }

    public final <T> Optional<T> getValueForField(String fieldName, Class<T> clazz) {
        switch (fieldName) {
        case "DecodedMessage":
            return Optional.ofNullable(clazz.cast(decodedMessage()));
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
        map.put("DecodedMessage", DECODED_MESSAGE_FIELD);
        return Collections.unmodifiableMap(map);
    }

    private static <T> Function<Object, T> getter(Function<DecodeAuthorizationMessageResponse, T> g) {
        return obj -> g.apply((DecodeAuthorizationMessageResponse) obj);
    }

    private static <T> BiConsumer<Object, T> setter(BiConsumer<Builder, T> s) {
        return (obj, val) -> s.accept((Builder) obj, val);
    }

    @Mutable
    @NotThreadSafe
    public interface Builder extends StsResponse.Builder, SdkPojo, CopyableBuilder<Builder, DecodeAuthorizationMessageResponse> {
        /**
         * <p>
         * The API returns a response with the decoded message.
         * </p>
         * 
         * @param decodedMessage
         *        The API returns a response with the decoded message.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder decodedMessage(String decodedMessage);
    }

    static final class BuilderImpl extends StsResponse.BuilderImpl implements Builder {
        private String decodedMessage;

        private BuilderImpl() {
        }

        private BuilderImpl(DecodeAuthorizationMessageResponse model) {
            super(model);
            decodedMessage(model.decodedMessage);
        }

        public final String getDecodedMessage() {
            return decodedMessage;
        }

        public final void setDecodedMessage(String decodedMessage) {
            this.decodedMessage = decodedMessage;
        }

        @Override
        public final Builder decodedMessage(String decodedMessage) {
            this.decodedMessage = decodedMessage;
            return this;
        }

        @Override
        public DecodeAuthorizationMessageResponse build() {
            return new DecodeAuthorizationMessageResponse(this);
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
