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
 * Request object containing all the options for deleting a legal hold from an object.
 *
 */
public class DeleteLegalHoldRequest extends S3Request
    implements SdkPojo, ToCopyableBuilder<DeleteLegalHoldRequest.Builder, DeleteLegalHoldRequest> {

    private static final SdkField<String> BUCKET_FIELD = SdkField
        .<String>builder(MarshallingType.STRING)
        .memberName("Bucket")
        .getter(getter(DeleteLegalHoldRequest::bucket))
        .setter(setter(DeleteLegalHoldRequest.Builder::bucket))
        .traits(LocationTrait.builder().location(MarshallLocation.PATH).locationName("Bucket")
                             .unmarshallLocationName("Bucket").build(), RequiredTrait.create()).build();

    private static final SdkField<String> KEY_FIELD = SdkField
        .<String>builder(MarshallingType.STRING)
        .memberName("Key")
        .getter(getter(DeleteLegalHoldRequest::key))
        .setter(setter(DeleteLegalHoldRequest.Builder::key))
        .traits(LocationTrait.builder().location(MarshallLocation.GREEDY_PATH).locationName("Key")
                             .unmarshallLocationName("Key").build(), RequiredTrait.create()).build();

    private static final SdkField<String> LEGAL_HOLD_ID_FIELD = SdkField
        .<String>builder(MarshallingType.STRING)
        .memberName("LegalHoldId")
        .getter(getter(DeleteLegalHoldRequest::legalHoldId))
        .setter(setter(DeleteLegalHoldRequest.Builder::legalHoldId))
        .traits(LocationTrait.builder().location(MarshallLocation.QUERY_PARAM).locationName("remove")
                             .unmarshallLocationName("remove").build(), RequiredTrait.create()).build();

    public static final List<SdkField<?>> SDK_FIELDS = Collections.unmodifiableList(Arrays.asList(BUCKET_FIELD, KEY_FIELD,
                                                                                                  LEGAL_HOLD_ID_FIELD));


    /**
     * The name of the bucket containing the reference to the object to delete a legal hold from.
     */
    private String bucket;

    /**
     * The key, the name of the reference to the object to delete a legal hold from.
     */
    private String key;

    /**
     * The id of the legal hold to delete.
     */
    private String legalHoldId;

    /**
     * Returns the name of the bucket containing the reference to the object to
     * delete a legal hold from.
     */
    public String bucket() {
        return bucket;
    }

    /**
     * Gets the key, the name of the reference to the object to delete a legal hold from.
     */
    public String key() {
        return key;
    }

    /**
     * Returns the legal hold id to be deleted.
     */
    public String legalHoldId() {
        return legalHoldId;
    }

    /**
     * Constructs a new {@link DeleteLegalHoldRequest} object and
     * initializes all required and optional object fields.
     */
    public DeleteLegalHoldRequest(BuilderImpl builder){
        super(builder);
        this.bucket = builder.bucket;
        this.key = builder.key;
        this.legalHoldId = builder.legalHoldId;
    }

    private static <T> Function<Object, T> getter(Function<DeleteLegalHoldRequest, T> g) {
        return obj -> g.apply((DeleteLegalHoldRequest) obj);
    }

    private static <T> BiConsumer<Object, T> setter(BiConsumer<DeleteLegalHoldRequest.Builder, T> s) {
        return (obj, val) -> s.accept((DeleteLegalHoldRequest.Builder) obj, val);
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
        if (!(obj instanceof DeleteLegalHoldRequest)) {
            return false;
        }
        DeleteLegalHoldRequest other = (DeleteLegalHoldRequest) obj;
        return Objects.equals(bucket(), other.bucket()) && Objects.equals(key(), other.key())
               && Objects.equals(legalHoldId(), other.legalHoldId());
    }

    /**
     * Returns a string representation of this object. This is useful for testing and debugging. Sensitive data will be
     * redacted from this string using a placeholder value.
     */
    @Override
    public final String toString() {
        return ToString.builder("DeleteLegalHoldRequest")
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

    @Mutable
    @NotThreadSafe
    public interface Builder extends S3Request.Builder, SdkPojo,
                                     CopyableBuilder<DeleteLegalHoldRequest.Builder, DeleteLegalHoldRequest> {

        /**
         * Sets the name of the bucket containing the reference to the object to
         * delete a legal hold from.
         *
         * @param bucket: Name of the bucket
         *
         * @return Returns a reference to this object so that method calls can be chained together.
         *
         */
       Builder bucket(String bucket);

        /**
         * Sets the key, the name of the reference to the object to delete a legal hold from.
         *
         * @param key: name of the reference to the object to delete a legal hold from
         *
         * @return Returns a reference to this object so that method calls can be chained together.
         *
         */
       Builder key(String key);

        /**
         * Sets the legal hold id to be deleted
         *
         * @param legalHoldId: The id of the legal hold to delete
         *
         * @return Returns a reference to this object so that method calls can be chained together.
         *
         */
       Builder legalHoldId(String legalHoldId);
    }

    static private final class BuilderImpl extends S3Request.BuilderImpl implements DeleteLegalHoldRequest.Builder {

        public String bucket;

        public String key;

        public String legalHoldId;

        private BuilderImpl(){};

        BuilderImpl(DeleteLegalHoldRequest model) {
            super(model);
            bucket(model.bucket);
            key(model.key);
            legalHoldId(model.legalHoldId);
        }

        public final String getBucket() { return bucket;}

        public final void setBucket(String bucket) {this.bucket = bucket;}

        @Override
        public Builder bucket(String bucket) {
            this.bucket = bucket;
            return this;
        }

        public final String getKey() { return key;}

        public final void setKey(String key) {
            this.key = key;
        }
        @Override
        public Builder key(String key) {
            this.key = key;
            return this;
        }

        public final String getLegalHoldId() { return legalHoldId;}

        public final void setLegalHoldId(String legalHoldId) {
            this.legalHoldId = legalHoldId;
        }
        @Override
        public Builder legalHoldId(String legalHoldId) {
            this.legalHoldId = legalHoldId;
            return this;
        }

        @Override
        public List<SdkField<?>> sdkFields() {
            return SDK_FIELDS;
        }

        @Override
        public DeleteLegalHoldRequest build() {
            return new DeleteLegalHoldRequest(this);
        }
    }


}
