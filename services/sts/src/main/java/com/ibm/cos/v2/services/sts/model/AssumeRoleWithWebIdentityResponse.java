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
 * Contains the response to a successful <a>AssumeRoleWithWebIdentity</a> request, including temporary Amazon Web
 * Services credentials that can be used to make Amazon Web Services requests.
 * </p>
 */
@Generated("com.ibm.cos.v2:codegen")
public final class AssumeRoleWithWebIdentityResponse extends StsResponse implements
        ToCopyableBuilder<AssumeRoleWithWebIdentityResponse.Builder, AssumeRoleWithWebIdentityResponse> {
    private static final SdkField<Credentials> CREDENTIALS_FIELD = SdkField.<Credentials> builder(MarshallingType.SDK_POJO)
            .memberName("Credentials").getter(getter(AssumeRoleWithWebIdentityResponse::credentials))
            .setter(setter(Builder::credentials)).constructor(Credentials::builder)
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("Credentials").build()).build();

    private static final SdkField<String> SUBJECT_FROM_WEB_IDENTITY_TOKEN_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("SubjectFromWebIdentityToken")
            .getter(getter(AssumeRoleWithWebIdentityResponse::subjectFromWebIdentityToken))
            .setter(setter(Builder::subjectFromWebIdentityToken))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("SubjectFromWebIdentityToken")
                    .build()).build();

    private static final SdkField<AssumedRoleUser> ASSUMED_ROLE_USER_FIELD = SdkField
            .<AssumedRoleUser> builder(MarshallingType.SDK_POJO).memberName("AssumedRoleUser")
            .getter(getter(AssumeRoleWithWebIdentityResponse::assumedRoleUser)).setter(setter(Builder::assumedRoleUser))
            .constructor(AssumedRoleUser::builder)
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("AssumedRoleUser").build()).build();

    private static final SdkField<Integer> PACKED_POLICY_SIZE_FIELD = SdkField.<Integer> builder(MarshallingType.INTEGER)
            .memberName("PackedPolicySize").getter(getter(AssumeRoleWithWebIdentityResponse::packedPolicySize))
            .setter(setter(Builder::packedPolicySize))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("PackedPolicySize").build()).build();

    private static final SdkField<String> PROVIDER_FIELD = SdkField.<String> builder(MarshallingType.STRING)
            .memberName("Provider").getter(getter(AssumeRoleWithWebIdentityResponse::provider)).setter(setter(Builder::provider))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("Provider").build()).build();

    private static final SdkField<String> AUDIENCE_FIELD = SdkField.<String> builder(MarshallingType.STRING)
            .memberName("Audience").getter(getter(AssumeRoleWithWebIdentityResponse::audience)).setter(setter(Builder::audience))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("Audience").build()).build();

    private static final SdkField<String> SOURCE_IDENTITY_FIELD = SdkField.<String> builder(MarshallingType.STRING)
            .memberName("SourceIdentity").getter(getter(AssumeRoleWithWebIdentityResponse::sourceIdentity))
            .setter(setter(Builder::sourceIdentity))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("SourceIdentity").build()).build();

    private static final List<SdkField<?>> SDK_FIELDS = Collections.unmodifiableList(Arrays.asList(CREDENTIALS_FIELD,
            SUBJECT_FROM_WEB_IDENTITY_TOKEN_FIELD, ASSUMED_ROLE_USER_FIELD, PACKED_POLICY_SIZE_FIELD, PROVIDER_FIELD,
            AUDIENCE_FIELD, SOURCE_IDENTITY_FIELD));

    private static final Map<String, SdkField<?>> SDK_NAME_TO_FIELD = memberNameToFieldInitializer();

    private final Credentials credentials;

    private final String subjectFromWebIdentityToken;

    private final AssumedRoleUser assumedRoleUser;

    private final Integer packedPolicySize;

    private final String provider;

    private final String audience;

    private final String sourceIdentity;

    private AssumeRoleWithWebIdentityResponse(BuilderImpl builder) {
        super(builder);
        this.credentials = builder.credentials;
        this.subjectFromWebIdentityToken = builder.subjectFromWebIdentityToken;
        this.assumedRoleUser = builder.assumedRoleUser;
        this.packedPolicySize = builder.packedPolicySize;
        this.provider = builder.provider;
        this.audience = builder.audience;
        this.sourceIdentity = builder.sourceIdentity;
    }

    /**
     * <p>
     * The temporary security credentials, which include an access key ID, a secret access key, and a security token.
     * </p>
     * <note>
     * <p>
     * The size of the security token that STS API operations return is not fixed. We strongly recommend that you make
     * no assumptions about the maximum size.
     * </p>
     * </note>
     * 
     * @return The temporary security credentials, which include an access key ID, a secret access key, and a security
     *         token.</p> <note>
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
     * The unique user identifier that is returned by the identity provider. This identifier is associated with the
     * <code>WebIdentityToken</code> that was submitted with the <code>AssumeRoleWithWebIdentity</code> call. The
     * identifier is typically unique to the user and the application that acquired the <code>WebIdentityToken</code>
     * (pairwise identifier). For OpenID Connect ID tokens, this field contains the value returned by the identity
     * provider as the token's <code>sub</code> (Subject) claim.
     * </p>
     * 
     * @return The unique user identifier that is returned by the identity provider. This identifier is associated with
     *         the <code>WebIdentityToken</code> that was submitted with the <code>AssumeRoleWithWebIdentity</code>
     *         call. The identifier is typically unique to the user and the application that acquired the
     *         <code>WebIdentityToken</code> (pairwise identifier). For OpenID Connect ID tokens, this field contains
     *         the value returned by the identity provider as the token's <code>sub</code> (Subject) claim.
     */
    public final String subjectFromWebIdentityToken() {
        return subjectFromWebIdentityToken;
    }

    /**
     * <p>
     * The Amazon Resource Name (ARN) and the assumed role ID, which are identifiers that you can use to refer to the
     * resulting temporary security credentials. For example, you can reference these credentials as a principal in a
     * resource-based policy by using the ARN or assumed role ID. The ARN and ID include the
     * <code>RoleSessionName</code> that you specified when you called <code>AssumeRole</code>.
     * </p>
     * 
     * @return The Amazon Resource Name (ARN) and the assumed role ID, which are identifiers that you can use to refer
     *         to the resulting temporary security credentials. For example, you can reference these credentials as a
     *         principal in a resource-based policy by using the ARN or assumed role ID. The ARN and ID include the
     *         <code>RoleSessionName</code> that you specified when you called <code>AssumeRole</code>.
     */
    public final AssumedRoleUser assumedRoleUser() {
        return assumedRoleUser;
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

    /**
     * <p>
     * The issuing authority of the web identity token presented. For OpenID Connect ID tokens, this contains the value
     * of the <code>iss</code> field. For OAuth 2.0 access tokens, this contains the value of the
     * <code>ProviderId</code> parameter that was passed in the <code>AssumeRoleWithWebIdentity</code> request.
     * </p>
     * 
     * @return The issuing authority of the web identity token presented. For OpenID Connect ID tokens, this contains
     *         the value of the <code>iss</code> field. For OAuth 2.0 access tokens, this contains the value of the
     *         <code>ProviderId</code> parameter that was passed in the <code>AssumeRoleWithWebIdentity</code> request.
     */
    public final String provider() {
        return provider;
    }

    /**
     * <p>
     * The intended audience (also known as client ID) of the web identity token. This is traditionally the client
     * identifier issued to the application that requested the web identity token.
     * </p>
     * 
     * @return The intended audience (also known as client ID) of the web identity token. This is traditionally the
     *         client identifier issued to the application that requested the web identity token.
     */
    public final String audience() {
        return audience;
    }

    /**
     * <p>
     * The value of the source identity that is returned in the JSON web token (JWT) from the identity provider.
     * </p>
     * <p>
     * You can require users to set a source identity value when they assume a role. You do this by using the
     * <code>sts:SourceIdentity</code> condition key in a role trust policy. That way, actions that are taken with the
     * role are associated with that user. After the source identity is set, the value cannot be changed. It is present
     * in the request for all actions that are taken by the role and persists across <a
     * href="https://docs.aws.amazon.com/IAM/latest/UserGuide/id_roles.html#id_roles_terms-and-concepts">chained
     * role</a> sessions. You can configure your identity provider to use an attribute associated with your users, like
     * user name or email, as the source identity when calling <code>AssumeRoleWithWebIdentity</code>. You do this by
     * adding a claim to the JSON web token. To learn more about OIDC tokens and claims, see <a href=
     * "https://docs.aws.amazon.com/cognito/latest/developerguide/amazon-cognito-user-pools-using-tokens-with-identity-providers.html"
     * >Using Tokens with User Pools</a> in the <i>Amazon Cognito Developer Guide</i>. For more information about using
     * source identity, see <a
     * href="https://docs.aws.amazon.com/IAM/latest/UserGuide/id_credentials_temp_control-access_monitor.html">Monitor
     * and control actions taken with assumed roles</a> in the <i>IAM User Guide</i>.
     * </p>
     * <p>
     * The regex used to validate this parameter is a string of characters consisting of upper- and lower-case
     * alphanumeric characters with no spaces. You can also include underscores or any of the following characters: =,.@-
     * </p>
     * 
     * @return The value of the source identity that is returned in the JSON web token (JWT) from the identity
     *         provider.</p>
     *         <p>
     *         You can require users to set a source identity value when they assume a role. You do this by using the
     *         <code>sts:SourceIdentity</code> condition key in a role trust policy. That way, actions that are taken
     *         with the role are associated with that user. After the source identity is set, the value cannot be
     *         changed. It is present in the request for all actions that are taken by the role and persists across <a
     *         href="https://docs.aws.amazon.com/IAM/latest/UserGuide/id_roles.html#id_roles_terms-and-concepts">chained
     *         role</a> sessions. You can configure your identity provider to use an attribute associated with your
     *         users, like user name or email, as the source identity when calling
     *         <code>AssumeRoleWithWebIdentity</code>. You do this by adding a claim to the JSON web token. To learn
     *         more about OIDC tokens and claims, see <a href=
     *         "https://docs.aws.amazon.com/cognito/latest/developerguide/amazon-cognito-user-pools-using-tokens-with-identity-providers.html"
     *         >Using Tokens with User Pools</a> in the <i>Amazon Cognito Developer Guide</i>. For more information
     *         about using source identity, see <a
     *         href="https://docs.aws.amazon.com/IAM/latest/UserGuide/id_credentials_temp_control-access_monitor.html"
     *         >Monitor and control actions taken with assumed roles</a> in the <i>IAM User Guide</i>.
     *         </p>
     *         <p>
     *         The regex used to validate this parameter is a string of characters consisting of upper- and lower-case
     *         alphanumeric characters with no spaces. You can also include underscores or any of the following
     *         characters: =,.@-
     */
    public final String sourceIdentity() {
        return sourceIdentity;
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
        hashCode = 31 * hashCode + Objects.hashCode(subjectFromWebIdentityToken());
        hashCode = 31 * hashCode + Objects.hashCode(assumedRoleUser());
        hashCode = 31 * hashCode + Objects.hashCode(packedPolicySize());
        hashCode = 31 * hashCode + Objects.hashCode(provider());
        hashCode = 31 * hashCode + Objects.hashCode(audience());
        hashCode = 31 * hashCode + Objects.hashCode(sourceIdentity());
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
        if (!(obj instanceof AssumeRoleWithWebIdentityResponse)) {
            return false;
        }
        AssumeRoleWithWebIdentityResponse other = (AssumeRoleWithWebIdentityResponse) obj;
        return Objects.equals(credentials(), other.credentials())
                && Objects.equals(subjectFromWebIdentityToken(), other.subjectFromWebIdentityToken())
                && Objects.equals(assumedRoleUser(), other.assumedRoleUser())
                && Objects.equals(packedPolicySize(), other.packedPolicySize()) && Objects.equals(provider(), other.provider())
                && Objects.equals(audience(), other.audience()) && Objects.equals(sourceIdentity(), other.sourceIdentity());
    }

    /**
     * Returns a string representation of this object. This is useful for testing and debugging. Sensitive data will be
     * redacted from this string using a placeholder value.
     */
    @Override
    public final String toString() {
        return ToString.builder("AssumeRoleWithWebIdentityResponse").add("Credentials", credentials())
                .add("SubjectFromWebIdentityToken", subjectFromWebIdentityToken()).add("AssumedRoleUser", assumedRoleUser())
                .add("PackedPolicySize", packedPolicySize()).add("Provider", provider()).add("Audience", audience())
                .add("SourceIdentity", sourceIdentity()).build();
    }

    public final <T> Optional<T> getValueForField(String fieldName, Class<T> clazz) {
        switch (fieldName) {
        case "Credentials":
            return Optional.ofNullable(clazz.cast(credentials()));
        case "SubjectFromWebIdentityToken":
            return Optional.ofNullable(clazz.cast(subjectFromWebIdentityToken()));
        case "AssumedRoleUser":
            return Optional.ofNullable(clazz.cast(assumedRoleUser()));
        case "PackedPolicySize":
            return Optional.ofNullable(clazz.cast(packedPolicySize()));
        case "Provider":
            return Optional.ofNullable(clazz.cast(provider()));
        case "Audience":
            return Optional.ofNullable(clazz.cast(audience()));
        case "SourceIdentity":
            return Optional.ofNullable(clazz.cast(sourceIdentity()));
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
        map.put("SubjectFromWebIdentityToken", SUBJECT_FROM_WEB_IDENTITY_TOKEN_FIELD);
        map.put("AssumedRoleUser", ASSUMED_ROLE_USER_FIELD);
        map.put("PackedPolicySize", PACKED_POLICY_SIZE_FIELD);
        map.put("Provider", PROVIDER_FIELD);
        map.put("Audience", AUDIENCE_FIELD);
        map.put("SourceIdentity", SOURCE_IDENTITY_FIELD);
        return Collections.unmodifiableMap(map);
    }

    private static <T> Function<Object, T> getter(Function<AssumeRoleWithWebIdentityResponse, T> g) {
        return obj -> g.apply((AssumeRoleWithWebIdentityResponse) obj);
    }

    private static <T> BiConsumer<Object, T> setter(BiConsumer<Builder, T> s) {
        return (obj, val) -> s.accept((Builder) obj, val);
    }

    @Mutable
    @NotThreadSafe
    public interface Builder extends StsResponse.Builder, SdkPojo, CopyableBuilder<Builder, AssumeRoleWithWebIdentityResponse> {
        /**
         * <p>
         * The temporary security credentials, which include an access key ID, a secret access key, and a security
         * token.
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
         *        security token.</p> <note>
         *        <p>
         *        The size of the security token that STS API operations return is not fixed. We strongly recommend that
         *        you make no assumptions about the maximum size.
         *        </p>
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder credentials(Credentials credentials);

        /**
         * <p>
         * The temporary security credentials, which include an access key ID, a secret access key, and a security
         * token.
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
         * The unique user identifier that is returned by the identity provider. This identifier is associated with the
         * <code>WebIdentityToken</code> that was submitted with the <code>AssumeRoleWithWebIdentity</code> call. The
         * identifier is typically unique to the user and the application that acquired the
         * <code>WebIdentityToken</code> (pairwise identifier). For OpenID Connect ID tokens, this field contains the
         * value returned by the identity provider as the token's <code>sub</code> (Subject) claim.
         * </p>
         * 
         * @param subjectFromWebIdentityToken
         *        The unique user identifier that is returned by the identity provider. This identifier is associated
         *        with the <code>WebIdentityToken</code> that was submitted with the
         *        <code>AssumeRoleWithWebIdentity</code> call. The identifier is typically unique to the user and the
         *        application that acquired the <code>WebIdentityToken</code> (pairwise identifier). For OpenID Connect
         *        ID tokens, this field contains the value returned by the identity provider as the token's
         *        <code>sub</code> (Subject) claim.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder subjectFromWebIdentityToken(String subjectFromWebIdentityToken);

        /**
         * <p>
         * The Amazon Resource Name (ARN) and the assumed role ID, which are identifiers that you can use to refer to
         * the resulting temporary security credentials. For example, you can reference these credentials as a principal
         * in a resource-based policy by using the ARN or assumed role ID. The ARN and ID include the
         * <code>RoleSessionName</code> that you specified when you called <code>AssumeRole</code>.
         * </p>
         * 
         * @param assumedRoleUser
         *        The Amazon Resource Name (ARN) and the assumed role ID, which are identifiers that you can use to
         *        refer to the resulting temporary security credentials. For example, you can reference these
         *        credentials as a principal in a resource-based policy by using the ARN or assumed role ID. The ARN and
         *        ID include the <code>RoleSessionName</code> that you specified when you called <code>AssumeRole</code>
         *        .
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder assumedRoleUser(AssumedRoleUser assumedRoleUser);

        /**
         * <p>
         * The Amazon Resource Name (ARN) and the assumed role ID, which are identifiers that you can use to refer to
         * the resulting temporary security credentials. For example, you can reference these credentials as a principal
         * in a resource-based policy by using the ARN or assumed role ID. The ARN and ID include the
         * <code>RoleSessionName</code> that you specified when you called <code>AssumeRole</code>.
         * </p>
         * This is a convenience method that creates an instance of the {@link AssumedRoleUser.Builder} avoiding the
         * need to create one manually via {@link AssumedRoleUser#builder()}.
         *
         * <p>
         * When the {@link Consumer} completes, {@link AssumedRoleUser.Builder#build()} is called immediately and its
         * result is passed to {@link #assumedRoleUser(AssumedRoleUser)}.
         * 
         * @param assumedRoleUser
         *        a consumer that will call methods on {@link AssumedRoleUser.Builder}
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see #assumedRoleUser(AssumedRoleUser)
         */
        default Builder assumedRoleUser(Consumer<AssumedRoleUser.Builder> assumedRoleUser) {
            return assumedRoleUser(AssumedRoleUser.builder().applyMutation(assumedRoleUser).build());
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

        /**
         * <p>
         * The issuing authority of the web identity token presented. For OpenID Connect ID tokens, this contains the
         * value of the <code>iss</code> field. For OAuth 2.0 access tokens, this contains the value of the
         * <code>ProviderId</code> parameter that was passed in the <code>AssumeRoleWithWebIdentity</code> request.
         * </p>
         * 
         * @param provider
         *        The issuing authority of the web identity token presented. For OpenID Connect ID tokens, this contains
         *        the value of the <code>iss</code> field. For OAuth 2.0 access tokens, this contains the value of the
         *        <code>ProviderId</code> parameter that was passed in the <code>AssumeRoleWithWebIdentity</code>
         *        request.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder provider(String provider);

        /**
         * <p>
         * The intended audience (also known as client ID) of the web identity token. This is traditionally the client
         * identifier issued to the application that requested the web identity token.
         * </p>
         * 
         * @param audience
         *        The intended audience (also known as client ID) of the web identity token. This is traditionally the
         *        client identifier issued to the application that requested the web identity token.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder audience(String audience);

        /**
         * <p>
         * The value of the source identity that is returned in the JSON web token (JWT) from the identity provider.
         * </p>
         * <p>
         * You can require users to set a source identity value when they assume a role. You do this by using the
         * <code>sts:SourceIdentity</code> condition key in a role trust policy. That way, actions that are taken with
         * the role are associated with that user. After the source identity is set, the value cannot be changed. It is
         * present in the request for all actions that are taken by the role and persists across <a
         * href="https://docs.aws.amazon.com/IAM/latest/UserGuide/id_roles.html#id_roles_terms-and-concepts">chained
         * role</a> sessions. You can configure your identity provider to use an attribute associated with your users,
         * like user name or email, as the source identity when calling <code>AssumeRoleWithWebIdentity</code>. You do
         * this by adding a claim to the JSON web token. To learn more about OIDC tokens and claims, see <a href=
         * "https://docs.aws.amazon.com/cognito/latest/developerguide/amazon-cognito-user-pools-using-tokens-with-identity-providers.html"
         * >Using Tokens with User Pools</a> in the <i>Amazon Cognito Developer Guide</i>. For more information about
         * using source identity, see <a
         * href="https://docs.aws.amazon.com/IAM/latest/UserGuide/id_credentials_temp_control-access_monitor.html"
         * >Monitor and control actions taken with assumed roles</a> in the <i>IAM User Guide</i>.
         * </p>
         * <p>
         * The regex used to validate this parameter is a string of characters consisting of upper- and lower-case
         * alphanumeric characters with no spaces. You can also include underscores or any of the following characters:
         * =,.@-
         * </p>
         * 
         * @param sourceIdentity
         *        The value of the source identity that is returned in the JSON web token (JWT) from the identity
         *        provider.</p>
         *        <p>
         *        You can require users to set a source identity value when they assume a role. You do this by using the
         *        <code>sts:SourceIdentity</code> condition key in a role trust policy. That way, actions that are taken
         *        with the role are associated with that user. After the source identity is set, the value cannot be
         *        changed. It is present in the request for all actions that are taken by the role and persists across
         *        <a href="https://docs.aws.amazon.com/IAM/latest/UserGuide/id_roles.html#id_roles_terms-and-concepts">
         *        chained role</a> sessions. You can configure your identity provider to use an attribute associated
         *        with your users, like user name or email, as the source identity when calling
         *        <code>AssumeRoleWithWebIdentity</code>. You do this by adding a claim to the JSON web token. To learn
         *        more about OIDC tokens and claims, see <a href=
         *        "https://docs.aws.amazon.com/cognito/latest/developerguide/amazon-cognito-user-pools-using-tokens-with-identity-providers.html"
         *        >Using Tokens with User Pools</a> in the <i>Amazon Cognito Developer Guide</i>. For more information
         *        about using source identity, see <a href=
         *        "https://docs.aws.amazon.com/IAM/latest/UserGuide/id_credentials_temp_control-access_monitor.html"
         *        >Monitor and control actions taken with assumed roles</a> in the <i>IAM User Guide</i>.
         *        </p>
         *        <p>
         *        The regex used to validate this parameter is a string of characters consisting of upper- and
         *        lower-case alphanumeric characters with no spaces. You can also include underscores or any of the
         *        following characters: =,.@-
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder sourceIdentity(String sourceIdentity);
    }

    static final class BuilderImpl extends StsResponse.BuilderImpl implements Builder {
        private Credentials credentials;

        private String subjectFromWebIdentityToken;

        private AssumedRoleUser assumedRoleUser;

        private Integer packedPolicySize;

        private String provider;

        private String audience;

        private String sourceIdentity;

        private BuilderImpl() {
        }

        private BuilderImpl(AssumeRoleWithWebIdentityResponse model) {
            super(model);
            credentials(model.credentials);
            subjectFromWebIdentityToken(model.subjectFromWebIdentityToken);
            assumedRoleUser(model.assumedRoleUser);
            packedPolicySize(model.packedPolicySize);
            provider(model.provider);
            audience(model.audience);
            sourceIdentity(model.sourceIdentity);
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

        public final String getSubjectFromWebIdentityToken() {
            return subjectFromWebIdentityToken;
        }

        public final void setSubjectFromWebIdentityToken(String subjectFromWebIdentityToken) {
            this.subjectFromWebIdentityToken = subjectFromWebIdentityToken;
        }

        @Override
        public final Builder subjectFromWebIdentityToken(String subjectFromWebIdentityToken) {
            this.subjectFromWebIdentityToken = subjectFromWebIdentityToken;
            return this;
        }

        public final AssumedRoleUser.Builder getAssumedRoleUser() {
            return assumedRoleUser != null ? assumedRoleUser.toBuilder() : null;
        }

        public final void setAssumedRoleUser(AssumedRoleUser.BuilderImpl assumedRoleUser) {
            this.assumedRoleUser = assumedRoleUser != null ? assumedRoleUser.build() : null;
        }

        @Override
        public final Builder assumedRoleUser(AssumedRoleUser assumedRoleUser) {
            this.assumedRoleUser = assumedRoleUser;
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

        public final String getProvider() {
            return provider;
        }

        public final void setProvider(String provider) {
            this.provider = provider;
        }

        @Override
        public final Builder provider(String provider) {
            this.provider = provider;
            return this;
        }

        public final String getAudience() {
            return audience;
        }

        public final void setAudience(String audience) {
            this.audience = audience;
        }

        @Override
        public final Builder audience(String audience) {
            this.audience = audience;
            return this;
        }

        public final String getSourceIdentity() {
            return sourceIdentity;
        }

        public final void setSourceIdentity(String sourceIdentity) {
            this.sourceIdentity = sourceIdentity;
        }

        @Override
        public final Builder sourceIdentity(String sourceIdentity) {
            this.sourceIdentity = sourceIdentity;
            return this;
        }

        @Override
        public AssumeRoleWithWebIdentityResponse build() {
            return new AssumeRoleWithWebIdentityResponse(this);
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
