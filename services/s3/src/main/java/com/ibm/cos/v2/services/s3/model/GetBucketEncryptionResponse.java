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
import com.ibm.cos.v2.core.SdkField;
import com.ibm.cos.v2.core.SdkPojo;
import com.ibm.cos.v2.core.protocol.MarshallLocation;
import com.ibm.cos.v2.core.protocol.MarshallingType;
import com.ibm.cos.v2.core.traits.LocationTrait;
import com.ibm.cos.v2.core.traits.PayloadTrait;
import com.ibm.cos.v2.utils.ToString;
import com.ibm.cos.v2.utils.builder.CopyableBuilder;
import com.ibm.cos.v2.utils.builder.ToCopyableBuilder;

/**
 */
@Generated("com.ibm.cos.v2:codegen")
public final class GetBucketEncryptionResponse extends S3Response implements
        ToCopyableBuilder<GetBucketEncryptionResponse.Builder, GetBucketEncryptionResponse> {
    private static final SdkField<ServerSideEncryptionConfiguration> SERVER_SIDE_ENCRYPTION_CONFIGURATION_FIELD = SdkField
            .<ServerSideEncryptionConfiguration> builder(MarshallingType.SDK_POJO)
            .memberName("ServerSideEncryptionConfiguration")
            .getter(getter(GetBucketEncryptionResponse::serverSideEncryptionConfiguration))
            .setter(setter(Builder::serverSideEncryptionConfiguration))
            .constructor(ServerSideEncryptionConfiguration::builder)
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("ServerSideEncryptionConfiguration")
                    .unmarshallLocationName("ServerSideEncryptionConfiguration").build(), PayloadTrait.create()).build();

    private static final List<SdkField<?>> SDK_FIELDS = Collections.unmodifiableList(Arrays
            .asList(SERVER_SIDE_ENCRYPTION_CONFIGURATION_FIELD));

    private static final Map<String, SdkField<?>> SDK_NAME_TO_FIELD = memberNameToFieldInitializer();

    private final ServerSideEncryptionConfiguration serverSideEncryptionConfiguration;

    private GetBucketEncryptionResponse(BuilderImpl builder) {
        super(builder);
        this.serverSideEncryptionConfiguration = builder.serverSideEncryptionConfiguration;
    }

    /**
     * Returns the value of the ServerSideEncryptionConfiguration property for this object.
     * 
     * @return The value of the ServerSideEncryptionConfiguration property for this object.
     */
    public final ServerSideEncryptionConfiguration serverSideEncryptionConfiguration() {
        return serverSideEncryptionConfiguration;
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
        hashCode = 31 * hashCode + Objects.hashCode(serverSideEncryptionConfiguration());
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
        if (!(obj instanceof GetBucketEncryptionResponse)) {
            return false;
        }
        GetBucketEncryptionResponse other = (GetBucketEncryptionResponse) obj;
        return Objects.equals(serverSideEncryptionConfiguration(), other.serverSideEncryptionConfiguration());
    }

    /**
     * Returns a string representation of this object. This is useful for testing and debugging. Sensitive data will be
     * redacted from this string using a placeholder value.
     */
    @Override
    public final String toString() {
        return ToString.builder("GetBucketEncryptionResponse")
                .add("ServerSideEncryptionConfiguration", serverSideEncryptionConfiguration()).build();
    }

    public final <T> Optional<T> getValueForField(String fieldName, Class<T> clazz) {
        switch (fieldName) {
        case "ServerSideEncryptionConfiguration":
            return Optional.ofNullable(clazz.cast(serverSideEncryptionConfiguration()));
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
        map.put("ServerSideEncryptionConfiguration", SERVER_SIDE_ENCRYPTION_CONFIGURATION_FIELD);
        return Collections.unmodifiableMap(map);
    }

    private static <T> Function<Object, T> getter(Function<GetBucketEncryptionResponse, T> g) {
        return obj -> g.apply((GetBucketEncryptionResponse) obj);
    }

    private static <T> BiConsumer<Object, T> setter(BiConsumer<Builder, T> s) {
        return (obj, val) -> s.accept((Builder) obj, val);
    }

    @Mutable
    @NotThreadSafe
    public interface Builder extends S3Response.Builder, SdkPojo, CopyableBuilder<Builder, GetBucketEncryptionResponse> {
        /**
         * Sets the value of the ServerSideEncryptionConfiguration property for this object.
         *
         * @param serverSideEncryptionConfiguration
         *        The new value for the ServerSideEncryptionConfiguration property for this object.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder serverSideEncryptionConfiguration(ServerSideEncryptionConfiguration serverSideEncryptionConfiguration);

        /**
         * Sets the value of the ServerSideEncryptionConfiguration property for this object.
         *
         * This is a convenience method that creates an instance of the
         * {@link ServerSideEncryptionConfiguration.Builder} avoiding the need to create one manually via
         * {@link ServerSideEncryptionConfiguration#builder()}.
         *
         * <p>
         * When the {@link Consumer} completes, {@link ServerSideEncryptionConfiguration.Builder#build()} is called
         * immediately and its result is passed to
         * {@link #serverSideEncryptionConfiguration(ServerSideEncryptionConfiguration)}.
         * 
         * @param serverSideEncryptionConfiguration
         *        a consumer that will call methods on {@link ServerSideEncryptionConfiguration.Builder}
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see #serverSideEncryptionConfiguration(ServerSideEncryptionConfiguration)
         */
        default Builder serverSideEncryptionConfiguration(
                Consumer<ServerSideEncryptionConfiguration.Builder> serverSideEncryptionConfiguration) {
            return serverSideEncryptionConfiguration(ServerSideEncryptionConfiguration.builder()
                    .applyMutation(serverSideEncryptionConfiguration).build());
        }
    }

    static final class BuilderImpl extends S3Response.BuilderImpl implements Builder {
        private ServerSideEncryptionConfiguration serverSideEncryptionConfiguration;

        private BuilderImpl() {
        }

        private BuilderImpl(GetBucketEncryptionResponse model) {
            super(model);
            serverSideEncryptionConfiguration(model.serverSideEncryptionConfiguration);
        }

        public final ServerSideEncryptionConfiguration.Builder getServerSideEncryptionConfiguration() {
            return serverSideEncryptionConfiguration != null ? serverSideEncryptionConfiguration.toBuilder() : null;
        }

        public final void setServerSideEncryptionConfiguration(
                ServerSideEncryptionConfiguration.BuilderImpl serverSideEncryptionConfiguration) {
            this.serverSideEncryptionConfiguration = serverSideEncryptionConfiguration != null ? serverSideEncryptionConfiguration
                    .build() : null;
        }

        @Override
        public final Builder serverSideEncryptionConfiguration(ServerSideEncryptionConfiguration serverSideEncryptionConfiguration) {
            this.serverSideEncryptionConfiguration = serverSideEncryptionConfiguration;
            return this;
        }

        @Override
        public GetBucketEncryptionResponse build() {
            return new GetBucketEncryptionResponse(this);
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
