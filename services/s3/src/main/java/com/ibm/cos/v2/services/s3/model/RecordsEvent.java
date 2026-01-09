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
import java.nio.ByteBuffer;
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
import com.ibm.cos.v2.core.SdkBytes;
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
 * <p>
 * The container for the records event.
 * </p>
 */
@Generated("com.ibm.cos.v2:codegen")
public class RecordsEvent implements SdkPojo, Serializable, ToCopyableBuilder<RecordsEvent.Builder, RecordsEvent>,
        SelectObjectContentEventStream {
    private static final SdkField<SdkBytes> PAYLOAD_FIELD = SdkField
            .<SdkBytes> builder(MarshallingType.SDK_BYTES)
            .memberName("Payload")
            .getter(getter(RecordsEvent::payload))
            .setter(setter(Builder::payload))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("Payload")
                    .unmarshallLocationName("Payload").build(), PayloadTrait.create()).build();

    private static final List<SdkField<?>> SDK_FIELDS = Collections.unmodifiableList(Arrays.asList(PAYLOAD_FIELD));

    private static final Map<String, SdkField<?>> SDK_NAME_TO_FIELD = memberNameToFieldInitializer();

    private static final long serialVersionUID = 1L;

    private final SdkBytes payload;

    protected RecordsEvent(BuilderImpl builder) {
        this.payload = builder.payload;
    }

    /**
     * <p>
     * The byte array of partial, one or more result records. S3 Select doesn't guarantee that a record will be
     * self-contained in one record frame. To ensure continuous streaming of data, S3 Select might split the same record
     * across multiple record frames instead of aggregating the results in memory. Some S3 clients (for example, the
     * SDKforJava) handle this behavior by creating a <code>ByteStream</code> out of the response by default. Other
     * clients might not handle this behavior by default. In those cases, you must aggregate the results on the client
     * side and parse the response.
     * </p>
     * 
     * @return The byte array of partial, one or more result records. S3 Select doesn't guarantee that a record will be
     *         self-contained in one record frame. To ensure continuous streaming of data, S3 Select might split the
     *         same record across multiple record frames instead of aggregating the results in memory. Some S3 clients
     *         (for example, the SDKforJava) handle this behavior by creating a <code>ByteStream</code> out of the
     *         response by default. Other clients might not handle this behavior by default. In those cases, you must
     *         aggregate the results on the client side and parse the response.
     */
    public final SdkBytes payload() {
        return payload;
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
        hashCode = 31 * hashCode + Objects.hashCode(payload());
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
        if (!(obj instanceof RecordsEvent)) {
            return false;
        }
        RecordsEvent other = (RecordsEvent) obj;
        return Objects.equals(payload(), other.payload());
    }

    /**
     * Returns a string representation of this object. This is useful for testing and debugging. Sensitive data will be
     * redacted from this string using a placeholder value.
     */
    @Override
    public final String toString() {
        return ToString.builder("RecordsEvent").add("Payload", payload()).build();
    }

    public final <T> Optional<T> getValueForField(String fieldName, Class<T> clazz) {
        switch (fieldName) {
        case "Payload":
            return Optional.ofNullable(clazz.cast(payload()));
        default:
            return Optional.empty();
        }
    }

    @Override
    public final RecordsEvent copy(Consumer<? super Builder> modifier) {
        return ToCopyableBuilder.super.copy(modifier);
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
        map.put("Payload", PAYLOAD_FIELD);
        return Collections.unmodifiableMap(map);
    }

    private static <T> Function<Object, T> getter(Function<RecordsEvent, T> g) {
        return obj -> g.apply((RecordsEvent) obj);
    }

    private static <T> BiConsumer<Object, T> setter(BiConsumer<Builder, T> s) {
        return (obj, val) -> s.accept((Builder) obj, val);
    }

    /**
     * Calls the appropriate visit method depending on the subtype of {@link RecordsEvent}.
     *
     * @param visitor
     *        Visitor to invoke.
     */
    @Override
    public void accept(SelectObjectContentResponseHandler.Visitor visitor) {
        throw new UnsupportedOperationException();
    }

    @Mutable
    @NotThreadSafe
    public interface Builder extends SdkPojo, CopyableBuilder<Builder, RecordsEvent> {
        /**
         * <p>
         * The byte array of partial, one or more result records. S3 Select doesn't guarantee that a record will be
         * self-contained in one record frame. To ensure continuous streaming of data, S3 Select might split the same
         * record across multiple record frames instead of aggregating the results in memory. Some S3 clients (for
         * example, the SDKforJava) handle this behavior by creating a <code>ByteStream</code> out of the response by
         * default. Other clients might not handle this behavior by default. In those cases, you must aggregate the
         * results on the client side and parse the response.
         * </p>
         * 
         * @param payload
         *        The byte array of partial, one or more result records. S3 Select doesn't guarantee that a record will
         *        be self-contained in one record frame. To ensure continuous streaming of data, S3 Select might split
         *        the same record across multiple record frames instead of aggregating the results in memory. Some S3
         *        clients (for example, the SDKforJava) handle this behavior by creating a <code>ByteStream</code> out
         *        of the response by default. Other clients might not handle this behavior by default. In those cases,
         *        you must aggregate the results on the client side and parse the response.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder payload(SdkBytes payload);
    }

    protected static class BuilderImpl implements Builder {
        private SdkBytes payload;

        protected BuilderImpl() {
        }

        protected BuilderImpl(RecordsEvent model) {
            payload(model.payload);
        }

        public final ByteBuffer getPayload() {
            return payload == null ? null : payload.asByteBuffer();
        }

        public final void setPayload(ByteBuffer payload) {
            payload(payload == null ? null : SdkBytes.fromByteBuffer(payload));
        }

        @Override
        public final Builder payload(SdkBytes payload) {
            this.payload = payload;
            return this;
        }

        @Override
        public RecordsEvent build() {
            return new RecordsEvent(this);
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
