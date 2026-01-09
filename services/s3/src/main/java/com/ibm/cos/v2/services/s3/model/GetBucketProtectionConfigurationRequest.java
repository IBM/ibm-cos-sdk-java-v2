

package com.ibm.cos.v2.services.s3.model;
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
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * Request object for the parameters to get a bucket's protection configuration.
 */
public final class  GetBucketProtectionConfigurationRequest extends S3Request implements
                                                                              ToCopyableBuilder<GetBucketProtectionConfigurationRequest.Builder,
                                                                                  GetBucketProtectionConfigurationRequest> {
    private static final SdkField<String> BUCKET_FIELD = SdkField
        .<String>builder(MarshallingType.STRING)
        .memberName("Bucket")
        .getter(getter(GetBucketProtectionConfigurationRequest::bucket))
        .setter(setter(Builder::bucket))
        .traits(LocationTrait.builder()
                             .location(MarshallLocation.PATH)
                             .locationName("Bucket")
                             .unmarshallLocationName("Bucket")
                             .build())
        .build();

    private static final List<SdkField<?>> SDK_FIELDS = Collections.unmodifiableList(Arrays.asList(BUCKET_FIELD));

    private final String bucket;

    private GetBucketProtectionConfigurationRequest(BuilderImpl builder) {
        super(builder);
        this.bucket = builder.bucket;
    }

    public String bucket() {
        return bucket;
    }

    private static <T> Function<Object, T> getter(Function<GetBucketProtectionConfigurationRequest, T> g) {
        return obj -> g.apply((GetBucketProtectionConfigurationRequest) obj);
    }

    private static <T> BiConsumer<Object, T> setter(BiConsumer<Builder, T> s) {
        return (obj, val) -> s.accept((GetBucketProtectionConfigurationRequest.Builder) obj, val);
    }

    public static GetBucketProtectionConfigurationRequest.Builder builder() {
        return new BuilderImpl();
    }

    public static Class<? extends GetBucketProtectionConfigurationRequest.Builder> serializableBuilderClass() {
        return GetBucketProtectionConfigurationRequest.BuilderImpl.class;
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
        if (!(obj instanceof GetBucketProtectionConfigurationRequest)) {
            return false;
        }
        GetBucketProtectionConfigurationRequest other = (GetBucketProtectionConfigurationRequest) obj;
        return Objects.equals(bucket(), other.bucket());
    }

    /**
     * Returns a string representation of this object. This is useful for testing and debugging. Sensitive data will be
     * redacted from this string using a placeholder value.
     */
    @Override
    public final String toString() {
        return ToString.builder("GetBucketProtectionConfigurationRequest")
                       .add("Bucket", bucket()).build();
    }

    @Mutable
    @NotThreadSafe
    public interface Builder extends S3Request.Builder, SdkPojo, CopyableBuilder<Builder, GetBucketProtectionConfigurationRequest>
    {
        Builder bucket(String bucket);

        String bucket();
    }


    static final class BuilderImpl extends S3Request.BuilderImpl implements Builder {

        private String bucket;

        private BuilderImpl() {}

        private BuilderImpl(GetBucketProtectionConfigurationRequest model) {
            super(model);
            this.bucket = model.bucket;
        }

        @Override
        public String bucket() {
            return bucket;
        }

        @Override
        public Builder bucket(String bucket) {
            this.bucket = bucket;
            return this;
        }

        /**
         * Creates a request object, ready to be executed to fetch the protection
         * configuration of the specified bucket.
         *
         * A {@link Consumer} that will call methods on
         * {@link com.ibm.cos.v2.services.s3.model.GetBucketProtectionConfigurationRequest.Builder for
         *      building request to get the bucket protection
         */
        @Override
        public GetBucketProtectionConfigurationRequest build() {
            return new GetBucketProtectionConfigurationRequest(this);
        }

        @Override
        public List<SdkField<?>> sdkFields() {
            return SDK_FIELDS;
        }
    }

    @Override
    public Builder toBuilder() {
        return new BuilderImpl(this);
    }

    @Override
    public List<SdkField<?>> sdkFields() {
        return SDK_FIELDS;
    }
}
