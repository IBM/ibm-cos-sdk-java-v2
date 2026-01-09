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
 * Specifies encryption-related information for an Amazon S3 bucket that is a destination for replicated objects.
 * </p>
 * <note>
 * <p>
 * If you're specifying a customer managed KMS key, we recommend using a fully qualified KMS key ARN. If you use a KMS
 * key alias instead, then KMS resolves the key within the requester’s account. This behavior can result in data that's
 * encrypted with a KMS key that belongs to the requester, and not the bucket owner.
 * </p>
 * </note>
 */
@Generated("com.ibm.cos.v2:codegen")
public final class EncryptionConfiguration implements SdkPojo, Serializable,
        ToCopyableBuilder<EncryptionConfiguration.Builder, EncryptionConfiguration> {
    private static final SdkField<String> REPLICA_KMS_KEY_ID_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("ReplicaKmsKeyID")
            .getter(getter(EncryptionConfiguration::replicaKmsKeyID))
            .setter(setter(Builder::replicaKmsKeyID))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("ReplicaKmsKeyID")
                    .unmarshallLocationName("ReplicaKmsKeyID").build()).build();

    private static final List<SdkField<?>> SDK_FIELDS = Collections.unmodifiableList(Arrays.asList(REPLICA_KMS_KEY_ID_FIELD));

    private static final Map<String, SdkField<?>> SDK_NAME_TO_FIELD = memberNameToFieldInitializer();

    private static final long serialVersionUID = 1L;

    private final String replicaKmsKeyID;

    private EncryptionConfiguration(BuilderImpl builder) {
        this.replicaKmsKeyID = builder.replicaKmsKeyID;
    }

    /**
     * <p>
     * Specifies the ID (Key ARN or Alias ARN) of the customer managed Amazon Web Services KMS key stored in Amazon Web
     * Services Key Management Service (KMS) for the destination bucket. Amazon S3 uses this key to encrypt replica
     * objects. Amazon S3 only supports symmetric encryption KMS keys. For more information, see <a
     * href="https://docs.aws.amazon.com/kms/latest/developerguide/symmetric-asymmetric.html">Asymmetric keys in Amazon
     * Web Services KMS</a> in the <i>Amazon Web Services Key Management Service Developer Guide</i>.
     * </p>
     * 
     * @return Specifies the ID (Key ARN or Alias ARN) of the customer managed Amazon Web Services KMS key stored in
     *         Amazon Web Services Key Management Service (KMS) for the destination bucket. Amazon S3 uses this key to
     *         encrypt replica objects. Amazon S3 only supports symmetric encryption KMS keys. For more information, see
     *         <a href="https://docs.aws.amazon.com/kms/latest/developerguide/symmetric-asymmetric.html">Asymmetric keys
     *         in Amazon Web Services KMS</a> in the <i>Amazon Web Services Key Management Service Developer Guide</i>.
     */
    public final String replicaKmsKeyID() {
        return replicaKmsKeyID;
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
        hashCode = 31 * hashCode + Objects.hashCode(replicaKmsKeyID());
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
        if (!(obj instanceof EncryptionConfiguration)) {
            return false;
        }
        EncryptionConfiguration other = (EncryptionConfiguration) obj;
        return Objects.equals(replicaKmsKeyID(), other.replicaKmsKeyID());
    }

    /**
     * Returns a string representation of this object. This is useful for testing and debugging. Sensitive data will be
     * redacted from this string using a placeholder value.
     */
    @Override
    public final String toString() {
        return ToString.builder("EncryptionConfiguration").add("ReplicaKmsKeyID", replicaKmsKeyID()).build();
    }

    public final <T> Optional<T> getValueForField(String fieldName, Class<T> clazz) {
        switch (fieldName) {
        case "ReplicaKmsKeyID":
            return Optional.ofNullable(clazz.cast(replicaKmsKeyID()));
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
        map.put("ReplicaKmsKeyID", REPLICA_KMS_KEY_ID_FIELD);
        return Collections.unmodifiableMap(map);
    }

    private static <T> Function<Object, T> getter(Function<EncryptionConfiguration, T> g) {
        return obj -> g.apply((EncryptionConfiguration) obj);
    }

    private static <T> BiConsumer<Object, T> setter(BiConsumer<Builder, T> s) {
        return (obj, val) -> s.accept((Builder) obj, val);
    }

    @Mutable
    @NotThreadSafe
    public interface Builder extends SdkPojo, CopyableBuilder<Builder, EncryptionConfiguration> {
        /**
         * <p>
         * Specifies the ID (Key ARN or Alias ARN) of the customer managed Amazon Web Services KMS key stored in Amazon
         * Web Services Key Management Service (KMS) for the destination bucket. Amazon S3 uses this key to encrypt
         * replica objects. Amazon S3 only supports symmetric encryption KMS keys. For more information, see <a
         * href="https://docs.aws.amazon.com/kms/latest/developerguide/symmetric-asymmetric.html">Asymmetric keys in
         * Amazon Web Services KMS</a> in the <i>Amazon Web Services Key Management Service Developer Guide</i>.
         * </p>
         * 
         * @param replicaKmsKeyID
         *        Specifies the ID (Key ARN or Alias ARN) of the customer managed Amazon Web Services KMS key stored in
         *        Amazon Web Services Key Management Service (KMS) for the destination bucket. Amazon S3 uses this key
         *        to encrypt replica objects. Amazon S3 only supports symmetric encryption KMS keys. For more
         *        information, see <a
         *        href="https://docs.aws.amazon.com/kms/latest/developerguide/symmetric-asymmetric.html">Asymmetric keys
         *        in Amazon Web Services KMS</a> in the <i>Amazon Web Services Key Management Service Developer
         *        Guide</i>.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder replicaKmsKeyID(String replicaKmsKeyID);
    }

    static final class BuilderImpl implements Builder {
        private String replicaKmsKeyID;

        private BuilderImpl() {
        }

        private BuilderImpl(EncryptionConfiguration model) {
            replicaKmsKeyID(model.replicaKmsKeyID);
        }

        public final String getReplicaKmsKeyID() {
            return replicaKmsKeyID;
        }

        public final void setReplicaKmsKeyID(String replicaKmsKeyID) {
            this.replicaKmsKeyID = replicaKmsKeyID;
        }

        @Override
        public final Builder replicaKmsKeyID(String replicaKmsKeyID) {
            this.replicaKmsKeyID = replicaKmsKeyID;
            return this;
        }

        @Override
        public EncryptionConfiguration build() {
            return new EncryptionConfiguration(this);
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
