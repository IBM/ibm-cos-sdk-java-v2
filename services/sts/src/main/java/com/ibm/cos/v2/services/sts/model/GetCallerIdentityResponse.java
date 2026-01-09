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
 * <p>
 * Contains the response to a successful <a>GetCallerIdentity</a> request, including information about the entity making
 * the request.
 * </p>
 */
@Generated("com.ibm.cos.v2:codegen")
public final class GetCallerIdentityResponse extends StsResponse implements
        ToCopyableBuilder<GetCallerIdentityResponse.Builder, GetCallerIdentityResponse> {
    private static final SdkField<String> USER_ID_FIELD = SdkField.<String> builder(MarshallingType.STRING).memberName("UserId")
            .getter(getter(GetCallerIdentityResponse::userId)).setter(setter(Builder::userId))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("UserId").build()).build();

    private static final SdkField<String> ACCOUNT_FIELD = SdkField.<String> builder(MarshallingType.STRING).memberName("Account")
            .getter(getter(GetCallerIdentityResponse::account)).setter(setter(Builder::account))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("Account").build()).build();

    private static final SdkField<String> ARN_FIELD = SdkField.<String> builder(MarshallingType.STRING).memberName("Arn")
            .getter(getter(GetCallerIdentityResponse::arn)).setter(setter(Builder::arn))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("Arn").build()).build();

    private static final List<SdkField<?>> SDK_FIELDS = Collections.unmodifiableList(Arrays.asList(USER_ID_FIELD, ACCOUNT_FIELD,
            ARN_FIELD));

    private static final Map<String, SdkField<?>> SDK_NAME_TO_FIELD = memberNameToFieldInitializer();

    private final String userId;

    private final String account;

    private final String arn;

    private GetCallerIdentityResponse(BuilderImpl builder) {
        super(builder);
        this.userId = builder.userId;
        this.account = builder.account;
        this.arn = builder.arn;
    }

    /**
     * <p>
     * The unique identifier of the calling entity. The exact value depends on the type of entity that is making the
     * call. The values returned are those listed in the <b>aws:userid</b> column in the <a
     * href="https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_policies_variables.html#principaltable"
     * >Principal table</a> found on the <b>Policy Variables</b> reference page in the <i>IAM User Guide</i>.
     * </p>
     * 
     * @return The unique identifier of the calling entity. The exact value depends on the type of entity that is making
     *         the call. The values returned are those listed in the <b>aws:userid</b> column in the <a href=
     *         "https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_policies_variables.html#principaltable"
     *         >Principal table</a> found on the <b>Policy Variables</b> reference page in the <i>IAM User Guide</i>.
     */
    public final String userId() {
        return userId;
    }

    /**
     * <p>
     * The Amazon Web Services account ID number of the account that owns or contains the calling entity.
     * </p>
     * 
     * @return The Amazon Web Services account ID number of the account that owns or contains the calling entity.
     */
    public final String account() {
        return account;
    }

    /**
     * <p>
     * The Amazon Web Services ARN associated with the calling entity.
     * </p>
     * 
     * @return The Amazon Web Services ARN associated with the calling entity.
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
        hashCode = 31 * hashCode + super.hashCode();
        hashCode = 31 * hashCode + Objects.hashCode(userId());
        hashCode = 31 * hashCode + Objects.hashCode(account());
        hashCode = 31 * hashCode + Objects.hashCode(arn());
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
        if (!(obj instanceof GetCallerIdentityResponse)) {
            return false;
        }
        GetCallerIdentityResponse other = (GetCallerIdentityResponse) obj;
        return Objects.equals(userId(), other.userId()) && Objects.equals(account(), other.account())
                && Objects.equals(arn(), other.arn());
    }

    /**
     * Returns a string representation of this object. This is useful for testing and debugging. Sensitive data will be
     * redacted from this string using a placeholder value.
     */
    @Override
    public final String toString() {
        return ToString.builder("GetCallerIdentityResponse").add("UserId", userId()).add("Account", account()).add("Arn", arn())
                .build();
    }

    public final <T> Optional<T> getValueForField(String fieldName, Class<T> clazz) {
        switch (fieldName) {
        case "UserId":
            return Optional.ofNullable(clazz.cast(userId()));
        case "Account":
            return Optional.ofNullable(clazz.cast(account()));
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
        map.put("UserId", USER_ID_FIELD);
        map.put("Account", ACCOUNT_FIELD);
        map.put("Arn", ARN_FIELD);
        return Collections.unmodifiableMap(map);
    }

    private static <T> Function<Object, T> getter(Function<GetCallerIdentityResponse, T> g) {
        return obj -> g.apply((GetCallerIdentityResponse) obj);
    }

    private static <T> BiConsumer<Object, T> setter(BiConsumer<Builder, T> s) {
        return (obj, val) -> s.accept((Builder) obj, val);
    }

    @Mutable
    @NotThreadSafe
    public interface Builder extends StsResponse.Builder, SdkPojo, CopyableBuilder<Builder, GetCallerIdentityResponse> {
        /**
         * <p>
         * The unique identifier of the calling entity. The exact value depends on the type of entity that is making the
         * call. The values returned are those listed in the <b>aws:userid</b> column in the <a
         * href="https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_policies_variables.html#principaltable"
         * >Principal table</a> found on the <b>Policy Variables</b> reference page in the <i>IAM User Guide</i>.
         * </p>
         * 
         * @param userId
         *        The unique identifier of the calling entity. The exact value depends on the type of entity that is
         *        making the call. The values returned are those listed in the <b>aws:userid</b> column in the <a href=
         *        "https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_policies_variables.html#principaltable"
         *        >Principal table</a> found on the <b>Policy Variables</b> reference page in the <i>IAM User Guide</i>.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder userId(String userId);

        /**
         * <p>
         * The Amazon Web Services account ID number of the account that owns or contains the calling entity.
         * </p>
         * 
         * @param account
         *        The Amazon Web Services account ID number of the account that owns or contains the calling entity.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder account(String account);

        /**
         * <p>
         * The Amazon Web Services ARN associated with the calling entity.
         * </p>
         * 
         * @param arn
         *        The Amazon Web Services ARN associated with the calling entity.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder arn(String arn);
    }

    static final class BuilderImpl extends StsResponse.BuilderImpl implements Builder {
        private String userId;

        private String account;

        private String arn;

        private BuilderImpl() {
        }

        private BuilderImpl(GetCallerIdentityResponse model) {
            super(model);
            userId(model.userId);
            account(model.account);
            arn(model.arn);
        }

        public final String getUserId() {
            return userId;
        }

        public final void setUserId(String userId) {
            this.userId = userId;
        }

        @Override
        public final Builder userId(String userId) {
            this.userId = userId;
            return this;
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
        public GetCallerIdentityResponse build() {
            return new GetCallerIdentityResponse(this);
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
