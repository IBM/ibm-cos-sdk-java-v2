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
import java.util.function.Consumer;
import java.util.function.Function;
import com.ibm.cos.v2.annotations.Generated;
import com.ibm.cos.v2.annotations.Mutable;
import com.ibm.cos.v2.annotations.NotThreadSafe;
import com.ibm.cos.v2.awscore.AwsRequestOverrideConfiguration;
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
public final class ListRetirableGrantsRequest extends KmsRequest implements
        ToCopyableBuilder<ListRetirableGrantsRequest.Builder, ListRetirableGrantsRequest> {
    private static final SdkField<Integer> LIMIT_FIELD = SdkField.<Integer> builder(MarshallingType.INTEGER).memberName("Limit")
            .getter(getter(ListRetirableGrantsRequest::limit)).setter(setter(Builder::limit))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("Limit").build()).build();

    private static final SdkField<String> MARKER_FIELD = SdkField.<String> builder(MarshallingType.STRING).memberName("Marker")
            .getter(getter(ListRetirableGrantsRequest::marker)).setter(setter(Builder::marker))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("Marker").build()).build();

    private static final SdkField<String> RETIRING_PRINCIPAL_FIELD = SdkField.<String> builder(MarshallingType.STRING)
            .memberName("RetiringPrincipal").getter(getter(ListRetirableGrantsRequest::retiringPrincipal))
            .setter(setter(Builder::retiringPrincipal))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("RetiringPrincipal").build()).build();

    private static final List<SdkField<?>> SDK_FIELDS = Collections.unmodifiableList(Arrays.asList(LIMIT_FIELD, MARKER_FIELD,
            RETIRING_PRINCIPAL_FIELD));

    private static final Map<String, SdkField<?>> SDK_NAME_TO_FIELD = memberNameToFieldInitializer();

    private final Integer limit;

    private final String marker;

    private final String retiringPrincipal;

    private ListRetirableGrantsRequest(BuilderImpl builder) {
        super(builder);
        this.limit = builder.limit;
        this.marker = builder.marker;
        this.retiringPrincipal = builder.retiringPrincipal;
    }

    /**
     * <p>
     * Use this parameter to specify the maximum number of items to return. When this value is present, KMS does not
     * return more than the specified number of items, but it might return fewer.
     * </p>
     * <p>
     * This value is optional. If you include a value, it must be between 1 and 100, inclusive. If you do not include a
     * value, it defaults to 50.
     * </p>
     * 
     * @return Use this parameter to specify the maximum number of items to return. When this value is present, KMS does
     *         not return more than the specified number of items, but it might return fewer.</p>
     *         <p>
     *         This value is optional. If you include a value, it must be between 1 and 100, inclusive. If you do not
     *         include a value, it defaults to 50.
     */
    public final Integer limit() {
        return limit;
    }

    /**
     * <p>
     * Use this parameter in a subsequent request after you receive a response with truncated results. Set it to the
     * value of <code>NextMarker</code> from the truncated response you just received.
     * </p>
     * 
     * @return Use this parameter in a subsequent request after you receive a response with truncated results. Set it to
     *         the value of <code>NextMarker</code> from the truncated response you just received.
     */
    public final String marker() {
        return marker;
    }

    /**
     * <p>
     * The retiring principal for which to list grants. Enter a principal in your Amazon Web Services account.
     * </p>
     * <p>
     * To specify the retiring principal, use the <a
     * href="https://docs.aws.amazon.com/general/latest/gr/aws-arns-and-namespaces.html">Amazon Resource Name (ARN)</a>
     * of an Amazon Web Services principal. Valid principals include Amazon Web Services accounts, IAM users, IAM roles,
     * federated users, and assumed role users. For help with the ARN syntax for a principal, see <a
     * href="https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_identifiers.html#identifiers-arns">IAM ARNs</a>
     * in the <i> <i>Identity and Access Management User Guide</i> </i>.
     * </p>
     * 
     * @return The retiring principal for which to list grants. Enter a principal in your Amazon Web Services
     *         account.</p>
     *         <p>
     *         To specify the retiring principal, use the <a
     *         href="https://docs.aws.amazon.com/general/latest/gr/aws-arns-and-namespaces.html">Amazon Resource Name
     *         (ARN)</a> of an Amazon Web Services principal. Valid principals include Amazon Web Services accounts, IAM
     *         users, IAM roles, federated users, and assumed role users. For help with the ARN syntax for a principal,
     *         see <a
     *         href="https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_identifiers.html#identifiers-arns">IAM
     *         ARNs</a> in the <i> <i>Identity and Access Management User Guide</i> </i>.
     */
    public final String retiringPrincipal() {
        return retiringPrincipal;
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
        hashCode = 31 * hashCode + Objects.hashCode(limit());
        hashCode = 31 * hashCode + Objects.hashCode(marker());
        hashCode = 31 * hashCode + Objects.hashCode(retiringPrincipal());
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
        if (!(obj instanceof ListRetirableGrantsRequest)) {
            return false;
        }
        ListRetirableGrantsRequest other = (ListRetirableGrantsRequest) obj;
        return Objects.equals(limit(), other.limit()) && Objects.equals(marker(), other.marker())
                && Objects.equals(retiringPrincipal(), other.retiringPrincipal());
    }

    /**
     * Returns a string representation of this object. This is useful for testing and debugging. Sensitive data will be
     * redacted from this string using a placeholder value.
     */
    @Override
    public final String toString() {
        return ToString.builder("ListRetirableGrantsRequest").add("Limit", limit()).add("Marker", marker())
                .add("RetiringPrincipal", retiringPrincipal()).build();
    }

    public final <T> Optional<T> getValueForField(String fieldName, Class<T> clazz) {
        switch (fieldName) {
        case "Limit":
            return Optional.ofNullable(clazz.cast(limit()));
        case "Marker":
            return Optional.ofNullable(clazz.cast(marker()));
        case "RetiringPrincipal":
            return Optional.ofNullable(clazz.cast(retiringPrincipal()));
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
        map.put("Limit", LIMIT_FIELD);
        map.put("Marker", MARKER_FIELD);
        map.put("RetiringPrincipal", RETIRING_PRINCIPAL_FIELD);
        return Collections.unmodifiableMap(map);
    }

    private static <T> Function<Object, T> getter(Function<ListRetirableGrantsRequest, T> g) {
        return obj -> g.apply((ListRetirableGrantsRequest) obj);
    }

    private static <T> BiConsumer<Object, T> setter(BiConsumer<Builder, T> s) {
        return (obj, val) -> s.accept((Builder) obj, val);
    }

    @Mutable
    @NotThreadSafe
    public interface Builder extends KmsRequest.Builder, SdkPojo, CopyableBuilder<Builder, ListRetirableGrantsRequest> {
        /**
         * <p>
         * Use this parameter to specify the maximum number of items to return. When this value is present, KMS does not
         * return more than the specified number of items, but it might return fewer.
         * </p>
         * <p>
         * This value is optional. If you include a value, it must be between 1 and 100, inclusive. If you do not
         * include a value, it defaults to 50.
         * </p>
         * 
         * @param limit
         *        Use this parameter to specify the maximum number of items to return. When this value is present, KMS
         *        does not return more than the specified number of items, but it might return fewer.</p>
         *        <p>
         *        This value is optional. If you include a value, it must be between 1 and 100, inclusive. If you do not
         *        include a value, it defaults to 50.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder limit(Integer limit);

        /**
         * <p>
         * Use this parameter in a subsequent request after you receive a response with truncated results. Set it to the
         * value of <code>NextMarker</code> from the truncated response you just received.
         * </p>
         * 
         * @param marker
         *        Use this parameter in a subsequent request after you receive a response with truncated results. Set it
         *        to the value of <code>NextMarker</code> from the truncated response you just received.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder marker(String marker);

        /**
         * <p>
         * The retiring principal for which to list grants. Enter a principal in your Amazon Web Services account.
         * </p>
         * <p>
         * To specify the retiring principal, use the <a
         * href="https://docs.aws.amazon.com/general/latest/gr/aws-arns-and-namespaces.html">Amazon Resource Name
         * (ARN)</a> of an Amazon Web Services principal. Valid principals include Amazon Web Services accounts, IAM
         * users, IAM roles, federated users, and assumed role users. For help with the ARN syntax for a principal, see
         * <a href="https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_identifiers.html#identifiers-arns">IAM
         * ARNs</a> in the <i> <i>Identity and Access Management User Guide</i> </i>.
         * </p>
         * 
         * @param retiringPrincipal
         *        The retiring principal for which to list grants. Enter a principal in your Amazon Web Services
         *        account.</p>
         *        <p>
         *        To specify the retiring principal, use the <a
         *        href="https://docs.aws.amazon.com/general/latest/gr/aws-arns-and-namespaces.html">Amazon Resource Name
         *        (ARN)</a> of an Amazon Web Services principal. Valid principals include Amazon Web Services accounts,
         *        IAM users, IAM roles, federated users, and assumed role users. For help with the ARN syntax for a
         *        principal, see <a
         *        href="https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_identifiers.html#identifiers-arns"
         *        >IAM ARNs</a> in the <i> <i>Identity and Access Management User Guide</i> </i>.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder retiringPrincipal(String retiringPrincipal);

        @Override
        Builder overrideConfiguration(AwsRequestOverrideConfiguration overrideConfiguration);

        @Override
        Builder overrideConfiguration(Consumer<AwsRequestOverrideConfiguration.Builder> builderConsumer);
    }

    static final class BuilderImpl extends KmsRequest.BuilderImpl implements Builder {
        private Integer limit;

        private String marker;

        private String retiringPrincipal;

        private BuilderImpl() {
        }

        private BuilderImpl(ListRetirableGrantsRequest model) {
            super(model);
            limit(model.limit);
            marker(model.marker);
            retiringPrincipal(model.retiringPrincipal);
        }

        public final Integer getLimit() {
            return limit;
        }

        public final void setLimit(Integer limit) {
            this.limit = limit;
        }

        @Override
        public final Builder limit(Integer limit) {
            this.limit = limit;
            return this;
        }

        public final String getMarker() {
            return marker;
        }

        public final void setMarker(String marker) {
            this.marker = marker;
        }

        @Override
        public final Builder marker(String marker) {
            this.marker = marker;
            return this;
        }

        public final String getRetiringPrincipal() {
            return retiringPrincipal;
        }

        public final void setRetiringPrincipal(String retiringPrincipal) {
            this.retiringPrincipal = retiringPrincipal;
        }

        @Override
        public final Builder retiringPrincipal(String retiringPrincipal) {
            this.retiringPrincipal = retiringPrincipal;
            return this;
        }

        @Override
        public Builder overrideConfiguration(AwsRequestOverrideConfiguration overrideConfiguration) {
            super.overrideConfiguration(overrideConfiguration);
            return this;
        }

        @Override
        public Builder overrideConfiguration(Consumer<AwsRequestOverrideConfiguration.Builder> builderConsumer) {
            super.overrideConfiguration(builderConsumer);
            return this;
        }

        @Override
        public ListRetirableGrantsRequest build() {
            return new ListRetirableGrantsRequest(this);
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
