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
public final class GetAccessKeyInfoResponse extends StsResponse implements
        ToCopyableBuilder<GetAccessKeyInfoResponse.Builder, GetAccessKeyInfoResponse> {
    private static final SdkField<String> ACCOUNT_FIELD = SdkField.<String> builder(MarshallingType.STRING).memberName("Account")
            .getter(getter(GetAccessKeyInfoResponse::account)).setter(setter(Builder::account))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("Account").build()).build();

    private static final List<SdkField<?>> SDK_FIELDS = Collections.unmodifiableList(Arrays.asList(ACCOUNT_FIELD));

    private static final Map<String, SdkField<?>> SDK_NAME_TO_FIELD = memberNameToFieldInitializer();

    private final String account;

    private GetAccessKeyInfoResponse(BuilderImpl builder) {
        super(builder);
        this.account = builder.account;
    }

    /**
     * <p>
     * The number used to identify the Amazon Web Services account.
     * </p>
     * 
     * @return The number used to identify the Amazon Web Services account.
     */
    public final String account() {
        return account;
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
        hashCode = 31 * hashCode + Objects.hashCode(account());
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
        if (!(obj instanceof GetAccessKeyInfoResponse)) {
            return false;
        }
        GetAccessKeyInfoResponse other = (GetAccessKeyInfoResponse) obj;
        return Objects.equals(account(), other.account());
    }

    /**
     * Returns a string representation of this object. This is useful for testing and debugging. Sensitive data will be
     * redacted from this string using a placeholder value.
     */
    @Override
    public final String toString() {
        return ToString.builder("GetAccessKeyInfoResponse").add("Account", account()).build();
    }

    public final <T> Optional<T> getValueForField(String fieldName, Class<T> clazz) {
        switch (fieldName) {
        case "Account":
            return Optional.ofNullable(clazz.cast(account()));
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
        map.put("Account", ACCOUNT_FIELD);
        return Collections.unmodifiableMap(map);
    }

    private static <T> Function<Object, T> getter(Function<GetAccessKeyInfoResponse, T> g) {
        return obj -> g.apply((GetAccessKeyInfoResponse) obj);
    }

    private static <T> BiConsumer<Object, T> setter(BiConsumer<Builder, T> s) {
        return (obj, val) -> s.accept((Builder) obj, val);
    }

    @Mutable
    @NotThreadSafe
    public interface Builder extends StsResponse.Builder, SdkPojo, CopyableBuilder<Builder, GetAccessKeyInfoResponse> {
        /**
         * <p>
         * The number used to identify the Amazon Web Services account.
         * </p>
         * 
         * @param account
         *        The number used to identify the Amazon Web Services account.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder account(String account);
    }

    static final class BuilderImpl extends StsResponse.BuilderImpl implements Builder {
        private String account;

        private BuilderImpl() {
        }

        private BuilderImpl(GetAccessKeyInfoResponse model) {
            super(model);
            account(model.account);
        }

        public final String getAccount() {
            return account;
        }

        public final void setAccount(String account) {
            this.account = account;
        }

        @Override
        public final Builder account(String account) {
            this.account = account;
            return this;
        }

        @Override
        public GetAccessKeyInfoResponse build() {
            return new GetAccessKeyInfoResponse(this);
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
