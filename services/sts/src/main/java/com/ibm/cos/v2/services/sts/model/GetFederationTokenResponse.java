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
import java.util.function.Consumer;
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
 * Contains the response to a successful <a>GetFederationToken</a> request, including temporary Amazon Web Services
 * credentials that can be used to make Amazon Web Services requests.
 * </p>
 */
@Generated("com.ibm.cos.v2:codegen")
public final class GetFederationTokenResponse extends StsResponse implements
        ToCopyableBuilder<GetFederationTokenResponse.Builder, GetFederationTokenResponse> {
    private static final SdkField<Credentials> CREDENTIALS_FIELD = SdkField.<Credentials> builder(MarshallingType.SDK_POJO)
            .memberName("Credentials").getter(getter(GetFederationTokenResponse::credentials))
            .setter(setter(Builder::credentials)).constructor(Credentials::builder)
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("Credentials").build()).build();

    private static final SdkField<FederatedUser> FEDERATED_USER_FIELD = SdkField
            .<FederatedUser> builder(MarshallingType.SDK_POJO).memberName("FederatedUser")
            .getter(getter(GetFederationTokenResponse::federatedUser)).setter(setter(Builder::federatedUser))
            .constructor(FederatedUser::builder)
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("FederatedUser").build()).build();

    private static final SdkField<Integer> PACKED_POLICY_SIZE_FIELD = SdkField.<Integer> builder(MarshallingType.INTEGER)
            .memberName("PackedPolicySize").getter(getter(GetFederationTokenResponse::packedPolicySize))
            .setter(setter(Builder::packedPolicySize))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("PackedPolicySize").build()).build();

    private static final List<SdkField<?>> SDK_FIELDS = Collections.unmodifiableList(Arrays.asList(CREDENTIALS_FIELD,
            FEDERATED_USER_FIELD, PACKED_POLICY_SIZE_FIELD));

    private static final Map<String, SdkField<?>> SDK_NAME_TO_FIELD = memberNameToFieldInitializer();

    private final Credentials credentials;

    private final FederatedUser federatedUser;

    private final Integer packedPolicySize;

    private GetFederationTokenResponse(BuilderImpl builder) {
        super(builder);
        this.credentials = builder.credentials;
        this.federatedUser = builder.federatedUser;
        this.packedPolicySize = builder.packedPolicySize;
    }

    /**
     * <p>
     * The temporary security credentials, which include an access key ID, a secret access key, and a security (or
     * session) token.
     * </p>
     * <note>
     * <p>
     * The size of the security token that STS API operations return is not fixed. We strongly recommend that you make
     * no assumptions about the maximum size.
     * </p>
     * </note>
     * 
     * @return The temporary security credentials, which include an access key ID, a secret access key, and a security
     *         (or session) token.</p> <note>
     *         <p>
     *         The size of the security token that STS API operations return is not fixed. We strongly recommend that
     *         you make no assumptions about the maximum size.
     *         </p>
     */
    public final Credentials credentials() {
        return credentials;
    }

    /**
     * <p>
     * Identifiers for the federated user associated with the credentials (such as
     * <code>arn:aws:sts::123456789012:federated-user/Bob</code> or <code>123456789012:Bob</code>). You can use the
     * federated user's ARN in your resource-based policies, such as an Amazon S3 bucket policy.
     * </p>
     * 
     * @return Identifiers for the federated user associated with the credentials (such as
     *         <code>arn:aws:sts::123456789012:federated-user/Bob</code> or <code>123456789012:Bob</code>). You can use
     *         the federated user's ARN in your resource-based policies, such as an Amazon S3 bucket policy.
     */
    public final FederatedUser federatedUser() {
        return federatedUser;
    }

    /**
     * <p>
     * A percentage value that indicates the packed size of the session policies and session tags combined passed in the
     * request. The request fails if the packed size is greater than 100 percent, which means the policies and tags
     * exceeded the allowed space.
     * </p>
     * 
     * @return A percentage value that indicates the packed size of the session policies and session tags combined
     *         passed in the request. The request fails if the packed size is greater than 100 percent, which means the
     *         policies and tags exceeded the allowed space.
     */
    public final Integer packedPolicySize() {
        return packedPolicySize;
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
        hashCode = 31 * hashCode + Objects.hashCode(credentials());
        hashCode = 31 * hashCode + Objects.hashCode(federatedUser());
        hashCode = 31 * hashCode + Objects.hashCode(packedPolicySize());
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
        if (!(obj instanceof GetFederationTokenResponse)) {
            return false;
        }
        GetFederationTokenResponse other = (GetFederationTokenResponse) obj;
        return Objects.equals(credentials(), other.credentials()) && Objects.equals(federatedUser(), other.federatedUser())
                && Objects.equals(packedPolicySize(), other.packedPolicySize());
    }

    /**
     * Returns a string representation of this object. This is useful for testing and debugging. Sensitive data will be
     * redacted from this string using a placeholder value.
     */
    @Override
    public final String toString() {
        return ToString.builder("GetFederationTokenResponse").add("Credentials", credentials())
                .add("FederatedUser", federatedUser()).add("PackedPolicySize", packedPolicySize()).build();
    }

    public final <T> Optional<T> getValueForField(String fieldName, Class<T> clazz) {
        switch (fieldName) {
        case "Credentials":
            return Optional.ofNullable(clazz.cast(credentials()));
        case "FederatedUser":
            return Optional.ofNullable(clazz.cast(federatedUser()));
        case "PackedPolicySize":
            return Optional.ofNullable(clazz.cast(packedPolicySize()));
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
        map.put("Credentials", CREDENTIALS_FIELD);
        map.put("FederatedUser", FEDERATED_USER_FIELD);
        map.put("PackedPolicySize", PACKED_POLICY_SIZE_FIELD);
        return Collections.unmodifiableMap(map);
    }

    private static <T> Function<Object, T> getter(Function<GetFederationTokenResponse, T> g) {
        return obj -> g.apply((GetFederationTokenResponse) obj);
    }

    private static <T> BiConsumer<Object, T> setter(BiConsumer<Builder, T> s) {
        return (obj, val) -> s.accept((Builder) obj, val);
    }

    @Mutable
    @NotThreadSafe
    public interface Builder extends StsResponse.Builder, SdkPojo, CopyableBuilder<Builder, GetFederationTokenResponse> {
        /**
         * <p>
         * The temporary security credentials, which include an access key ID, a secret access key, and a security (or
         * session) token.
         * </p>
         * <note>
         * <p>
         * The size of the security token that STS API operations return is not fixed. We strongly recommend that you
         * make no assumptions about the maximum size.
         * </p>
         * </note>
         * 
         * @param credentials
         *        The temporary security credentials, which include an access key ID, a secret access key, and a
         *        security (or session) token.</p> <note>
         *        <p>
         *        The size of the security token that STS API operations return is not fixed. We strongly recommend that
         *        you make no assumptions about the maximum size.
         *        </p>
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder credentials(Credentials credentials);

        /**
         * <p>
         * The temporary security credentials, which include an access key ID, a secret access key, and a security (or
         * session) token.
         * </p>
         * <note>
         * <p>
         * The size of the security token that STS API operations return is not fixed. We strongly recommend that you
         * make no assumptions about the maximum size.
         * </p>
         * </note> This is a convenience method that creates an instance of the {@link Credentials.Builder} avoiding the
         * need to create one manually via {@link Credentials#builder()}.
         *
         * <p>
         * When the {@link Consumer} completes, {@link Credentials.Builder#build()} is called immediately and its result
         * is passed to {@link #credentials(Credentials)}.
         * 
         * @param credentials
         *        a consumer that will call methods on {@link Credentials.Builder}
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see #credentials(Credentials)
         */
        default Builder credentials(Consumer<Credentials.Builder> credentials) {
            return credentials(Credentials.builder().applyMutation(credentials).build());
        }

        /**
         * <p>
         * Identifiers for the federated user associated with the credentials (such as
         * <code>arn:aws:sts::123456789012:federated-user/Bob</code> or <code>123456789012:Bob</code>). You can use the
         * federated user's ARN in your resource-based policies, such as an Amazon S3 bucket policy.
         * </p>
         * 
         * @param federatedUser
         *        Identifiers for the federated user associated with the credentials (such as
         *        <code>arn:aws:sts::123456789012:federated-user/Bob</code> or <code>123456789012:Bob</code>). You can
         *        use the federated user's ARN in your resource-based policies, such as an Amazon S3 bucket policy.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder federatedUser(FederatedUser federatedUser);

        /**
         * <p>
         * Identifiers for the federated user associated with the credentials (such as
         * <code>arn:aws:sts::123456789012:federated-user/Bob</code> or <code>123456789012:Bob</code>). You can use the
         * federated user's ARN in your resource-based policies, such as an Amazon S3 bucket policy.
         * </p>
         * This is a convenience method that creates an instance of the {@link FederatedUser.Builder} avoiding the need
         * to create one manually via {@link FederatedUser#builder()}.
         *
         * <p>
         * When the {@link Consumer} completes, {@link FederatedUser.Builder#build()} is called immediately and its
         * result is passed to {@link #federatedUser(FederatedUser)}.
         * 
         * @param federatedUser
         *        a consumer that will call methods on {@link FederatedUser.Builder}
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see #federatedUser(FederatedUser)
         */
        default Builder federatedUser(Consumer<FederatedUser.Builder> federatedUser) {
            return federatedUser(FederatedUser.builder().applyMutation(federatedUser).build());
        }

        /**
         * <p>
         * A percentage value that indicates the packed size of the session policies and session tags combined passed in
         * the request. The request fails if the packed size is greater than 100 percent, which means the policies and
         * tags exceeded the allowed space.
         * </p>
         * 
         * @param packedPolicySize
         *        A percentage value that indicates the packed size of the session policies and session tags combined
         *        passed in the request. The request fails if the packed size is greater than 100 percent, which means
         *        the policies and tags exceeded the allowed space.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder packedPolicySize(Integer packedPolicySize);
    }

    static final class BuilderImpl extends StsResponse.BuilderImpl implements Builder {
        private Credentials credentials;

        private FederatedUser federatedUser;

        private Integer packedPolicySize;

        private BuilderImpl() {
        }

        private BuilderImpl(GetFederationTokenResponse model) {
            super(model);
            credentials(model.credentials);
            federatedUser(model.federatedUser);
            packedPolicySize(model.packedPolicySize);
        }

        public final Credentials.Builder getCredentials() {
            return credentials != null ? credentials.toBuilder() : null;
        }

        public final void setCredentials(Credentials.BuilderImpl credentials) {
            this.credentials = credentials != null ? credentials.build() : null;
        }

        @Override
        public final Builder credentials(Credentials credentials) {
            this.credentials = credentials;
            return this;
        }

        public final FederatedUser.Builder getFederatedUser() {
            return federatedUser != null ? federatedUser.toBuilder() : null;
        }

        public final void setFederatedUser(FederatedUser.BuilderImpl federatedUser) {
            this.federatedUser = federatedUser != null ? federatedUser.build() : null;
        }

        @Override
        public final Builder federatedUser(FederatedUser federatedUser) {
            this.federatedUser = federatedUser;
            return this;
        }

        public final Integer getPackedPolicySize() {
            return packedPolicySize;
        }

        public final void setPackedPolicySize(Integer packedPolicySize) {
            this.packedPolicySize = packedPolicySize;
        }

        @Override
        public final Builder packedPolicySize(Integer packedPolicySize) {
            this.packedPolicySize = packedPolicySize;
            return this;
        }

        @Override
        public GetFederationTokenResponse build() {
            return new GetFederationTokenResponse(this);
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
