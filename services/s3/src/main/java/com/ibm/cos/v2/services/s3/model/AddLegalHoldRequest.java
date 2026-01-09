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
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * Request object representing the parameters required to add a legal hold on an object
 * in IBM Cloud Object Storage.
 *
 * <p>
 * A legal hold prevents the object from being modified or deleted until explicitly
 * released. This model wraps bucket, key, and optional legal hold identifier
 * metadata.
 * </p>
 */
public class AddLegalHoldRequest extends S3Request
    implements SdkPojo, ToCopyableBuilder<AddLegalHoldRequest.Builder, AddLegalHoldRequest> {

    private static final SdkField<String> BUCKET_FIELD = SdkField
        .<String>builder(MarshallingType.STRING)
        .memberName("Bucket")
        .getter(getter(AddLegalHoldRequest::bucket))
        .setter(setter(AddLegalHoldRequest.Builder::bucket))
        .traits(LocationTrait.builder()
                             .location(MarshallLocation.PATH)
                             .locationName("Bucket")
                             .unmarshallLocationName("Bucket").build(), RequiredTrait.create())
        .build();

    private static final SdkField<String> KEY_FIELD = SdkField
        .<String>builder(MarshallingType.STRING)
        .memberName("Key")
        .getter(getter(AddLegalHoldRequest::key))
        .setter(setter(AddLegalHoldRequest.Builder::key))
        .traits(LocationTrait.builder()
                             .location(MarshallLocation.GREEDY_PATH)
                             .locationName("Key")
                             .unmarshallLocationName("Key").build(), RequiredTrait.create())
        .build();

    private static final SdkField<String> LEGAL_HOLD_ID_FIELD = SdkField
        .<String>builder(MarshallingType.STRING)
        .memberName("LegalHoldId")
        .getter(getter(AddLegalHoldRequest::legalHoldId))
        .setter(setter(AddLegalHoldRequest.Builder::legalHoldId))
        .traits(LocationTrait.builder()
                             .location(MarshallLocation.QUERY_PARAM)
                             .locationName("add")
                             .unmarshallLocationName("add").build(), RequiredTrait.create())
        .build();

    private static final List<SdkField<?>> SDK_FIELDS = Collections.unmodifiableList(Arrays.asList(BUCKET_FIELD, KEY_FIELD,
                                                                                                   LEGAL_HOLD_ID_FIELD));

    /**
     * The name of the bucket containing the reference to the object to add a legal hold to.
     */
    private String bucketName;

    /**
     * The key, the name of the reference to the object to add a legal hold to.
     */
    private String key;

    /**
     * If enabled, the requester is charged for conducting this operation from
     * Requester Pays Buckets.
     */
    private String legalHoldId;

    /**
     * Constructs an immutable request instance based on the builder.
     */
    protected AddLegalHoldRequest(BuilderImpl builder) {
        super(builder);
        this.bucketName = builder.bucketName;
        this.key = builder.key;
        this.legalHoldId = builder.legalHoldId;
    }

    private static <T> Function<Object, T> getter(Function<AddLegalHoldRequest, T> g) {
        return obj -> g.apply((AddLegalHoldRequest) obj);
    }

    private static <T> BiConsumer<Object, T> setter(BiConsumer<AddLegalHoldRequest.Builder, T> s) {
        return (obj, val) -> s.accept((AddLegalHoldRequest.Builder) obj, val);
    }

    /** @return bucket name */
    public String bucket() { return this.bucketName;}

    /** @return object key */
    public String key() { return this.key;}

    /** @return legal hold ID */
    public String legalHoldId() { return this.legalHoldId;}

    @Override
    public Builder toBuilder() {
        return new BuilderImpl(this);
    }

    public static Builder builder() {
        return new BuilderImpl();
    }

    public static Class<? extends AddLegalHoldRequest.Builder> serializableBuilderClass() {
        return BuilderImpl.class;
    }

    @Override
    public final int hashCode() {
        int hashCode = 1;
        hashCode = 31 * hashCode + super.hashCode();
        hashCode = 31 * hashCode + Objects.hashCode(bucket());
        hashCode = 31 * hashCode + Objects.hashCode(key());
        hashCode = 31 * hashCode + Objects.hashCode(legalHoldId());
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
        if (!(obj instanceof AddLegalHoldRequest)) {
            return false;
        }
        AddLegalHoldRequest other = (AddLegalHoldRequest) obj;
        return Objects.equals(bucket(), other.bucket()) && Objects.equals(key(), other.key())
               && Objects.equals(legalHoldId(), other.legalHoldId());
    }

    /**
     * Returns a string representation of this object. This is useful for testing and debugging. Sensitive data will be
     * redacted from this string using a placeholder value.
     */
    @Override
    public final String toString() {
        return ToString.builder("AddLegalHoldRequest")
                       .add("Bucket", bucket())
                       .add("Key", key())
                       .add("LegalHoldId", legalHoldId()).build();
    }

    public final <T> Optional<T> getValueForField(String fieldName, Class<T> clazz) {
        switch (fieldName) {
            case "Bucket":
                return Optional.ofNullable(clazz.cast(bucket()));
            case "Key":
                return Optional.ofNullable(clazz.cast(key()));
            case "LegalHoldId":
                return Optional.ofNullable(clazz.cast(legalHoldId()));
            default:
                return Optional.empty();
        }
    }

    /**
     * Returns SdkField metadata describing this request.
     * Used internally for (un)marshalling.
     */
    @Override
    public List<SdkField<?>> sdkFields() {
        return SDK_FIELDS;
    }

    /**
     * Builder for constructing {@link AddLegalHoldRequest} objects.
     *
     * <p>
     * Implements fluent setters (bucket(), key(), legalHoldId()) and is annotated
     * as mutable and not thread-safe because builders are not synchronized and
     * intended for single-threaded usage.
     * </p>
     */
    @Mutable
    @NotThreadSafe
    public interface Builder extends S3Request.Builder, SdkPojo, CopyableBuilder<Builder,
            AddLegalHoldRequest> {
        Builder bucket(String bucket);

        Builder key(String key);

        Builder legalHoldId(String legalHoldId);
    }

    /**
     * Internal implementation of Builder. Holds mutable field state during
     * construction and is used to create the immutable {@link AddLegalHoldRequest}.
     */
    static private final class BuilderImpl extends S3Request.BuilderImpl implements AddLegalHoldRequest.Builder{

        private String bucketName;

        private String key;

        private String legalHoldId;

        private BuilderImpl() {}

        private BuilderImpl(AddLegalHoldRequest model){
            bucket(model.bucketName);
            key(model.key);
            legalHoldId(model.legalHoldId);
        }

        // Internal getters and setters available for model copy logic
        public final String getBucketName() {
            return bucketName;
        }

        public final void setBucketName(String ibmTransitionId) {
            this.bucketName = bucketName;
        }

        @Override
         public Builder bucket(String bucket){
            this.bucketName = bucket;
            return this;
        }

        public final String getKey() {
            return key;
        }

        public final void setKey(String key) {
            this.key = key;
        }

        @Override
        public Builder key(String key){
            this.key = key;
            return this;
        }

        public final String getLegalHoldId() {
            return legalHoldId;
        }

        public final void setLegalHoldId(String legalHoldId) {
            this.legalHoldId = legalHoldId;
        }

        @Override
        public Builder legalHoldId(String legalHoldId){
            this.legalHoldId = legalHoldId;
            return this;
        }

        /**
         * Returns SdkField definitions needed for serialization.
         */
        @Override
        public List<SdkField<?>> sdkFields() {
            return SDK_FIELDS;
        }

        /**
         * Creates an immutable AddLegalHoldRequest instance from the current
         * builder state.
         */
        @Override
        public AddLegalHoldRequest build() {
            return new AddLegalHoldRequest(this);
        }
    }
}
