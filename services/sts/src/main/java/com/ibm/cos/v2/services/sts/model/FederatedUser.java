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
 * Identifiers for the federated user that is associated with the credentials.
 * </p>
 */
@Generated("com.ibm.cos.v2:codegen")
public final class FederatedUser implements SdkPojo, Serializable, ToCopyableBuilder<FederatedUser.Builder, FederatedUser> {
    private static final SdkField<String> FEDERATED_USER_ID_FIELD = SdkField.<String> builder(MarshallingType.STRING)
            .memberName("FederatedUserId").getter(getter(FederatedUser::federatedUserId))
            .setter(setter(Builder::federatedUserId))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("FederatedUserId").build()).build();

    private static final SdkField<String> ARN_FIELD = SdkField.<String> builder(MarshallingType.STRING).memberName("Arn")
            .getter(getter(FederatedUser::arn)).setter(setter(Builder::arn))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("Arn").build()).build();

    private static final List<SdkField<?>> SDK_FIELDS = Collections.unmodifiableList(Arrays.asList(FEDERATED_USER_ID_FIELD,
            ARN_FIELD));

    private static final Map<String, SdkField<?>> SDK_NAME_TO_FIELD = memberNameToFieldInitializer();

    private static final long serialVersionUID = 1L;

    private final String federatedUserId;

    private final String arn;

    private FederatedUser(BuilderImpl builder) {
        this.federatedUserId = builder.federatedUserId;
        this.arn = builder.arn;
    }

    /**
     * <p>
     * The string that identifies the federated user associated with the credentials, similar to the unique ID of an IAM
     * user.
     * </p>
     * 
     * @return The string that identifies the federated user associated with the credentials, similar to the unique ID
     *         of an IAM user.
     */
    public final String federatedUserId() {
        return federatedUserId;
    }

    /**
     * <p>
     * The ARN that specifies the federated user that is associated with the credentials. For more information about
     * ARNs and how to use them in policies, see <a
     * href="https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_identifiers.html">IAM Identifiers</a> in the
     * <i>IAM User Guide</i>.
     * </p>
     * 
     * @return The ARN that specifies the federated user that is associated with the credentials. For more information
     *         about ARNs and how to use them in policies, see <a
     *         href="https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_identifiers.html">IAM Identifiers</a> in
     *         the <i>IAM User Guide</i>.
     */
    public final String arn() {
        return arn;
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
        hashCode = 31 * hashCode + Objects.hashCode(federatedUserId());
        hashCode = 31 * hashCode + Objects.hashCode(arn());
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
        if (!(obj instanceof FederatedUser)) {
            return false;
        }
        FederatedUser other = (FederatedUser) obj;
        return Objects.equals(federatedUserId(), other.federatedUserId()) && Objects.equals(arn(), other.arn());
    }

    /**
     * Returns a string representation of this object. This is useful for testing and debugging. Sensitive data will be
     * redacted from this string using a placeholder value.
     */
    @Override
    public final String toString() {
        return ToString.builder("FederatedUser").add("FederatedUserId", federatedUserId()).add("Arn", arn()).build();
    }

    public final <T> Optional<T> getValueForField(String fieldName, Class<T> clazz) {
        switch (fieldName) {
        case "FederatedUserId":
            return Optional.ofNullable(clazz.cast(federatedUserId()));
        case "Arn":
            return Optional.ofNullable(clazz.cast(arn()));
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
        map.put("FederatedUserId", FEDERATED_USER_ID_FIELD);
        map.put("Arn", ARN_FIELD);
        return Collections.unmodifiableMap(map);
    }

    private static <T> Function<Object, T> getter(Function<FederatedUser, T> g) {
        return obj -> g.apply((FederatedUser) obj);
    }

    private static <T> BiConsumer<Object, T> setter(BiConsumer<Builder, T> s) {
        return (obj, val) -> s.accept((Builder) obj, val);
    }

    @Mutable
    @NotThreadSafe
    public interface Builder extends SdkPojo, CopyableBuilder<Builder, FederatedUser> {
        /**
         * <p>
         * The string that identifies the federated user associated with the credentials, similar to the unique ID of an
         * IAM user.
         * </p>
         * 
         * @param federatedUserId
         *        The string that identifies the federated user associated with the credentials, similar to the unique
         *        ID of an IAM user.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder federatedUserId(String federatedUserId);

        /**
         * <p>
         * The ARN that specifies the federated user that is associated with the credentials. For more information about
         * ARNs and how to use them in policies, see <a
         * href="https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_identifiers.html">IAM Identifiers</a> in the
         * <i>IAM User Guide</i>.
         * </p>
         * 
         * @param arn
         *        The ARN that specifies the federated user that is associated with the credentials. For more
         *        information about ARNs and how to use them in policies, see <a
         *        href="https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_identifiers.html">IAM Identifiers</a>
         *        in the <i>IAM User Guide</i>.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder arn(String arn);
    }

    static final class BuilderImpl implements Builder {
        private String federatedUserId;

        private String arn;

        private BuilderImpl() {
        }

        private BuilderImpl(FederatedUser model) {
            federatedUserId(model.federatedUserId);
            arn(model.arn);
        }

        public final String getFederatedUserId() {
            return federatedUserId;
        }

        public final void setFederatedUserId(String federatedUserId) {
            this.federatedUserId = federatedUserId;
        }

        @Override
        public final Builder federatedUserId(String federatedUserId) {
            this.federatedUserId = federatedUserId;
            return this;
        }

        public final String getArn() {
            return arn;
        }

        public final void setArn(String arn) {
            this.arn = arn;
        }

        @Override
        public final Builder arn(String arn) {
            this.arn = arn;
            return this;
        }

        @Override
        public FederatedUser build() {
            return new FederatedUser(this);
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
