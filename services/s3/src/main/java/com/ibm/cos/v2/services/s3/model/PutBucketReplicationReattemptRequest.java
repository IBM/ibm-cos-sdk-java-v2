/*
 * Copyright 2025 IBM Corp. All Rights Reserved.
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

public class PutBucketReplicationReattemptRequest extends S3Request
    implements SdkPojo, ToCopyableBuilder<PutBucketReplicationReattemptRequest.Builder, PutBucketReplicationReattemptRequest> {

    private static final SdkField<String> BUCKET_FIELD = SdkField
        .<String>builder(MarshallingType.STRING)
        .memberName("Bucket")
        .getter(getter(PutBucketReplicationReattemptRequest::bucket))
        .setter(setter(PutBucketReplicationReattemptRequest.Builder::bucket))
        .traits(LocationTrait.builder().location(MarshallLocation.PATH).locationName("Bucket")
                             .unmarshallLocationName("Bucket").build(), RequiredTrait.create()).build();

    private static final List<SdkField<?>> SDK_FIELDS = Collections.unmodifiableList(Arrays.asList(BUCKET_FIELD));

    /**
     * The name of Amazon S3 bucket to which the replication reattempt is
     * set.
     */
    private final String bucket;

    private PutBucketReplicationReattemptRequest(BuilderImpl builder) {
        super(builder);
        this.bucket = builder.bucket;
    }

    private static <T> Function<Object, T> getter(Function<PutBucketReplicationReattemptRequest, T> g) {
        return obj -> g.apply((PutBucketReplicationReattemptRequest) obj);
    }

    private static <T> BiConsumer<Object, T> setter(BiConsumer<PutBucketReplicationReattemptRequest.Builder, T> s) {
        return (obj, val) -> s.accept((PutBucketReplicationReattemptRequest.Builder) obj, val);
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
        hashCode = 31 * hashCode + Objects.hashCode(bucket());
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
        if (!(obj instanceof PutBucketReplicationReattemptRequest)) {
            return false;
        }
        PutBucketReplicationReattemptRequest other = (PutBucketReplicationReattemptRequest) obj;
        return Objects.equals(bucket(), other.bucket());
    }

    /**
     * Returns a string representation of this object. This is useful for testing and debugging. Sensitive data will be
     * redacted from this string using a placeholder value.
     */
    @Override
    public final String toString() {
        return ToString.builder("SetBucketReplicationReattemptRequest")
                       .add("Bucket",bucket())
                       .build();

    }

    public final <T> Optional<T> getValueForField(String fieldName, Class<T> clazz) {
        switch (fieldName) {
            case "Bucket":
                return Optional.ofNullable(clazz.cast(bucket()));
            default:
                return Optional.empty();
        }
    }

    @Override
    public List<SdkField<?>> sdkFields() {
        return SDK_FIELDS;
    }


    @Mutable
    @NotThreadSafe
    public interface Builder extends S3Request.Builder, SdkPojo, CopyableBuilder<Builder, PutBucketReplicationReattemptRequest> {

        /**
         * Sets the name of Amazon S3 bucket for replication reattempt. Returns
         * the updated object.
         *
         * @param bucketName
         *            The name of Amazon S3 bucket to which the replication
         *            reattempt is set.
         * @return The updated {@link PutBucketReplicationReattemptRequest}
         *         object.
         */
        Builder bucket(String bucketName);

        }

    static private final class BuilderImpl extends S3Request.BuilderImpl implements Builder {

        private String bucket;

        private BuilderImpl(){}

        private BuilderImpl(PutBucketReplicationReattemptRequest model) {
            super(model);
            bucket(model.bucket);
        }

        public String getBucket() { return  bucket;}

        public void setBucket(String bucket) { this.bucket = bucket;}

        @Override
        public Builder bucket(String bucketName){
            this.bucket = bucketName;
            return this;
        }

        @Override
        public List<SdkField<?>> sdkFields() {
            return SDK_FIELDS;
        }

        @Override
        public PutBucketReplicationReattemptRequest build() {
            return new PutBucketReplicationReattemptRequest(this);
        }
    }

    /**
     * @return The bucket name for which replication attempt has been configured.
     */
    public String bucket() {
        return bucket;
    }

}
