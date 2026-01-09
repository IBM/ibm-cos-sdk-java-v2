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

package com.ibm.cos.v2.services.kms.model;

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
 */
@Generated("com.ibm.cos.v2:codegen")
public final class GetKeyPolicyResponse extends KmsResponse implements
        ToCopyableBuilder<GetKeyPolicyResponse.Builder, GetKeyPolicyResponse> {
    private static final SdkField<String> POLICY_FIELD = SdkField.<String> builder(MarshallingType.STRING).memberName("Policy")
            .getter(getter(GetKeyPolicyResponse::policy)).setter(setter(Builder::policy))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("Policy").build()).build();

    private static final SdkField<String> POLICY_NAME_FIELD = SdkField.<String> builder(MarshallingType.STRING)
            .memberName("PolicyName").getter(getter(GetKeyPolicyResponse::policyName)).setter(setter(Builder::policyName))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("PolicyName").build()).build();

    private static final List<SdkField<?>> SDK_FIELDS = Collections.unmodifiableList(Arrays.asList(POLICY_FIELD,
            POLICY_NAME_FIELD));

    private static final Map<String, SdkField<?>> SDK_NAME_TO_FIELD = memberNameToFieldInitializer();

    private final String policy;

    private final String policyName;

    private GetKeyPolicyResponse(BuilderImpl builder) {
        super(builder);
        this.policy = builder.policy;
        this.policyName = builder.policyName;
    }

    /**
     * <p>
     * A key policy document in JSON format.
     * </p>
     * 
     * @return A key policy document in JSON format.
     */
    public final String policy() {
        return policy;
    }

    /**
     * <p>
     * The name of the key policy. The only valid value is <code>default</code>.
     * </p>
     * 
     * @return The name of the key policy. The only valid value is <code>default</code>.
     */
    public final String policyName() {
        return policyName;
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
        hashCode = 31 * hashCode + Objects.hashCode(policy());
        hashCode = 31 * hashCode + Objects.hashCode(policyName());
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
        if (!(obj instanceof GetKeyPolicyResponse)) {
            return false;
        }
        GetKeyPolicyResponse other = (GetKeyPolicyResponse) obj;
        return Objects.equals(policy(), other.policy()) && Objects.equals(policyName(), other.policyName());
    }

    /**
     * Returns a string representation of this object. This is useful for testing and debugging. Sensitive data will be
     * redacted from this string using a placeholder value.
     */
    @Override
    public final String toString() {
        return ToString.builder("GetKeyPolicyResponse").add("Policy", policy()).add("PolicyName", policyName()).build();
    }

    public final <T> Optional<T> getValueForField(String fieldName, Class<T> clazz) {
        switch (fieldName) {
        case "Policy":
            return Optional.ofNullable(clazz.cast(policy()));
        case "PolicyName":
            return Optional.ofNullable(clazz.cast(policyName()));
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
        map.put("Policy", POLICY_FIELD);
        map.put("PolicyName", POLICY_NAME_FIELD);
        return Collections.unmodifiableMap(map);
    }

    private static <T> Function<Object, T> getter(Function<GetKeyPolicyResponse, T> g) {
        return obj -> g.apply((GetKeyPolicyResponse) obj);
    }

    private static <T> BiConsumer<Object, T> setter(BiConsumer<Builder, T> s) {
        return (obj, val) -> s.accept((Builder) obj, val);
    }

    @Mutable
    @NotThreadSafe
    public interface Builder extends KmsResponse.Builder, SdkPojo, CopyableBuilder<Builder, GetKeyPolicyResponse> {
        /**
         * <p>
         * A key policy document in JSON format.
         * </p>
         * 
         * @param policy
         *        A key policy document in JSON format.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder policy(String policy);

        /**
         * <p>
         * The name of the key policy. The only valid value is <code>default</code>.
         * </p>
         * 
         * @param policyName
         *        The name of the key policy. The only valid value is <code>default</code>.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder policyName(String policyName);
    }

    static final class BuilderImpl extends KmsResponse.BuilderImpl implements Builder {
        private String policy;

        private String policyName;

        private BuilderImpl() {
        }

        private BuilderImpl(GetKeyPolicyResponse model) {
            super(model);
            policy(model.policy);
            policyName(model.policyName);
        }

        public final String getPolicy() {
            return policy;
        }

        public final void setPolicy(String policy) {
            this.policy = policy;
        }

        @Override
        public final Builder policy(String policy) {
            this.policy = policy;
            return this;
        }

        public final String getPolicyName() {
            return policyName;
        }

        public final void setPolicyName(String policyName) {
            this.policyName = policyName;
        }

        @Override
        public final Builder policyName(String policyName) {
            this.policyName = policyName;
            return this;
        }

        @Override
        public GetKeyPolicyResponse build() {
            return new GetKeyPolicyResponse(this);
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
