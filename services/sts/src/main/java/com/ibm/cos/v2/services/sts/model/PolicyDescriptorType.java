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
 * A reference to the IAM managed policy that is passed as a session policy for a role session or a federated user
 * session.
 * </p>
 */
public final class PolicyDescriptorType implements SdkPojo, Serializable,
                                                   ToCopyableBuilder<PolicyDescriptorType.Builder, PolicyDescriptorType> {
    private static final SdkField<String> ARN_FIELD = SdkField.<String> builder(MarshallingType.STRING).memberName("arn")
                                                              .getter(getter(PolicyDescriptorType::arn)).setter(setter(Builder::arn))
                                                              .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("arn").build()).build();

    private static final List<SdkField<?>> SDK_FIELDS = Collections.unmodifiableList(Arrays.asList(ARN_FIELD));

    private static final Map<String, SdkField<?>> SDK_NAME_TO_FIELD = memberNameToFieldInitializer();

    private static final long serialVersionUID = 1L;

    private final String arn;

    private PolicyDescriptorType(BuilderImpl builder) {
        this.arn = builder.arn;
    }

    /**
     * <p>
     * The Amazon Resource Name (ARN) of the IAM managed policy to use as a session policy for the role. For more
     * information about ARNs, see <a
     * href="https://docs.aws.amazon.com/general/latest/gr/aws-arns-and-namespaces.html">Amazon Resource Names (ARNs)
     * and Amazon Web Services Service Namespaces</a> in the <i>Amazon Web Services General Reference</i>.
     * </p>
     *
     * @return The Amazon Resource Name (ARN) of the IAM managed policy to use as a session policy for the role. For
     *         more information about ARNs, see <a
     *         href="https://docs.aws.amazon.com/general/latest/gr/aws-arns-and-namespaces.html">Amazon Resource Names
     *         (ARNs) and Amazon Web Services Service Namespaces</a> in the <i>Amazon Web Services General
     *         Reference</i>.
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
        if (!(obj instanceof PolicyDescriptorType)) {
            return false;
        }
        PolicyDescriptorType other = (PolicyDescriptorType) obj;
        return Objects.equals(arn(), other.arn());
    }

    /**
     * Returns a string representation of this object. This is useful for testing and debugging. Sensitive data will be
     * redacted from this string using a placeholder value.
     */
    @Override
    public final String toString() {
        return ToString.builder("PolicyDescriptorType").add("Arn", arn()).build();
    }

    public final <T> Optional<T> getValueForField(String fieldName, Class<T> clazz) {
        switch (fieldName) {
            case "arn":
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
        map.put("arn", ARN_FIELD);
        return Collections.unmodifiableMap(map);
    }

    private static <T> Function<Object, T> getter(Function<PolicyDescriptorType, T> g) {
        return obj -> g.apply((PolicyDescriptorType) obj);
    }

    private static <T> BiConsumer<Object, T> setter(BiConsumer<Builder, T> s) {
        return (obj, val) -> s.accept((Builder) obj, val);
    }

    @Mutable
    @NotThreadSafe
    public interface Builder extends SdkPojo, CopyableBuilder<Builder, PolicyDescriptorType> {
        /**
         * <p>
         * The Amazon Resource Name (ARN) of the IAM managed policy to use as a session policy for the role. For more
         * information about ARNs, see <a
         * href="https://docs.aws.amazon.com/general/latest/gr/aws-arns-and-namespaces.html">Amazon Resource Names
         * (ARNs) and Amazon Web Services Service Namespaces</a> in the <i>Amazon Web Services General Reference</i>.
         * </p>
         *
         * @param arn
         *        The Amazon Resource Name (ARN) of the IAM managed policy to use as a session policy for the role. For
         *        more information about ARNs, see <a
         *        href="https://docs.aws.amazon.com/general/latest/gr/aws-arns-and-namespaces.html">Amazon Resource
         *        Names (ARNs) and Amazon Web Services Service Namespaces</a> in the <i>Amazon Web Services General
         *        Reference</i>.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder arn(String arn);
    }

    static final class BuilderImpl implements Builder {
        private String arn;

        private BuilderImpl() {
        }

        private BuilderImpl(PolicyDescriptorType model) {
            arn(model.arn);
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
        public PolicyDescriptorType build() {
            return new PolicyDescriptorType(this);
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
