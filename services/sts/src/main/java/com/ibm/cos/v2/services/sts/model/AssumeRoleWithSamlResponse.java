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
 * Contains the response to a successful <a>AssumeRoleWithSAML</a> request, including temporary Amazon Web Services
 * credentials that can be used to make Amazon Web Services requests.
 * </p>
 */
@Generated("com.ibm.cos.v2:codegen")
public final class AssumeRoleWithSamlResponse extends StsResponse implements
        ToCopyableBuilder<AssumeRoleWithSamlResponse.Builder, AssumeRoleWithSamlResponse> {
    private static final SdkField<Credentials> CREDENTIALS_FIELD = SdkField.<Credentials> builder(MarshallingType.SDK_POJO)
            .memberName("Credentials").getter(getter(AssumeRoleWithSamlResponse::credentials))
            .setter(setter(Builder::credentials)).constructor(Credentials::builder)
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("Credentials").build()).build();

    private static final SdkField<AssumedRoleUser> ASSUMED_ROLE_USER_FIELD = SdkField
            .<AssumedRoleUser> builder(MarshallingType.SDK_POJO).memberName("AssumedRoleUser")
            .getter(getter(AssumeRoleWithSamlResponse::assumedRoleUser)).setter(setter(Builder::assumedRoleUser))
            .constructor(AssumedRoleUser::builder)
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("AssumedRoleUser").build()).build();

    private static final SdkField<Integer> PACKED_POLICY_SIZE_FIELD = SdkField.<Integer> builder(MarshallingType.INTEGER)
            .memberName("PackedPolicySize").getter(getter(AssumeRoleWithSamlResponse::packedPolicySize))
            .setter(setter(Builder::packedPolicySize))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("PackedPolicySize").build()).build();

    private static final SdkField<String> SUBJECT_FIELD = SdkField.<String> builder(MarshallingType.STRING).memberName("Subject")
            .getter(getter(AssumeRoleWithSamlResponse::subject)).setter(setter(Builder::subject))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("Subject").build()).build();

    private static final SdkField<String> SUBJECT_TYPE_FIELD = SdkField.<String> builder(MarshallingType.STRING)
            .memberName("SubjectType").getter(getter(AssumeRoleWithSamlResponse::subjectType))
            .setter(setter(Builder::subjectType))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("SubjectType").build()).build();

    private static final SdkField<String> ISSUER_FIELD = SdkField.<String> builder(MarshallingType.STRING).memberName("Issuer")
            .getter(getter(AssumeRoleWithSamlResponse::issuer)).setter(setter(Builder::issuer))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("Issuer").build()).build();

    private static final SdkField<String> AUDIENCE_FIELD = SdkField.<String> builder(MarshallingType.STRING)
            .memberName("Audience").getter(getter(AssumeRoleWithSamlResponse::audience)).setter(setter(Builder::audience))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("Audience").build()).build();

    private static final SdkField<String> NAME_QUALIFIER_FIELD = SdkField.<String> builder(MarshallingType.STRING)
            .memberName("NameQualifier").getter(getter(AssumeRoleWithSamlResponse::nameQualifier))
            .setter(setter(Builder::nameQualifier))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("NameQualifier").build()).build();

    private static final SdkField<String> SOURCE_IDENTITY_FIELD = SdkField.<String> builder(MarshallingType.STRING)
            .memberName("SourceIdentity").getter(getter(AssumeRoleWithSamlResponse::sourceIdentity))
            .setter(setter(Builder::sourceIdentity))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("SourceIdentity").build()).build();

    private static final List<SdkField<?>> SDK_FIELDS = Collections.unmodifiableList(Arrays.asList(CREDENTIALS_FIELD,
            ASSUMED_ROLE_USER_FIELD, PACKED_POLICY_SIZE_FIELD, SUBJECT_FIELD, SUBJECT_TYPE_FIELD, ISSUER_FIELD, AUDIENCE_FIELD,
            NAME_QUALIFIER_FIELD, SOURCE_IDENTITY_FIELD));

    private static final Map<String, SdkField<?>> SDK_NAME_TO_FIELD = memberNameToFieldInitializer();

    private final Credentials credentials;

    private final AssumedRoleUser assumedRoleUser;

    private final Integer packedPolicySize;

    private final String subject;

    private final String subjectType;

    private final String issuer;

    private final String audience;

    private final String nameQualifier;

    private final String sourceIdentity;

    private AssumeRoleWithSamlResponse(BuilderImpl builder) {
        super(builder);
        this.credentials = builder.credentials;
        this.assumedRoleUser = builder.assumedRoleUser;
        this.packedPolicySize = builder.packedPolicySize;
        this.subject = builder.subject;
        this.subjectType = builder.subjectType;
        this.issuer = builder.issuer;
        this.audience = builder.audience;
        this.nameQualifier = builder.nameQualifier;
        this.sourceIdentity = builder.sourceIdentity;
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
     * The identifiers for the temporary security credentials that the operation returns.
     * </p>
     * 
     * @return The identifiers for the temporary security credentials that the operation returns.
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
     * The value of the <code>NameID</code> element in the <code>Subject</code> element of the SAML assertion.
     * </p>
     * 
     * @return The value of the <code>NameID</code> element in the <code>Subject</code> element of the SAML assertion.
     */
    public final String subject() {
        return subject;
    }

    /**
     * <p>
     * The format of the name ID, as defined by the <code>Format</code> attribute in the <code>NameID</code> element of
     * the SAML assertion. Typical examples of the format are <code>transient</code> or <code>persistent</code>.
     * </p>
     * <p>
     * If the format includes the prefix <code>urn:oasis:names:tc:SAML:2.0:nameid-format</code>, that prefix is removed.
     * For example, <code>urn:oasis:names:tc:SAML:2.0:nameid-format:transient</code> is returned as
     * <code>transient</code>. If the format includes any other prefix, the format is returned with no modifications.
     * </p>
     * 
     * @return The format of the name ID, as defined by the <code>Format</code> attribute in the <code>NameID</code>
     *         element of the SAML assertion. Typical examples of the format are <code>transient</code> or
     *         <code>persistent</code>. </p>
     *         <p>
     *         If the format includes the prefix <code>urn:oasis:names:tc:SAML:2.0:nameid-format</code>, that prefix is
     *         removed. For example, <code>urn:oasis:names:tc:SAML:2.0:nameid-format:transient</code> is returned as
     *         <code>transient</code>. If the format includes any other prefix, the format is returned with no
     *         modifications.
     */
    public final String subjectType() {
        return subjectType;
    }

    /**
     * <p>
     * The value of the <code>Issuer</code> element of the SAML assertion.
     * </p>
     * 
     * @return The value of the <code>Issuer</code> element of the SAML assertion.
     */
    public final String issuer() {
        return issuer;
    }

    /**
     * <p>
     * The value of the <code>Recipient</code> attribute of the <code>SubjectConfirmationData</code> element of the SAML
     * assertion.
     * </p>
     * 
     * @return The value of the <code>Recipient</code> attribute of the <code>SubjectConfirmationData</code> element of
     *         the SAML assertion.
     */
    public final String audience() {
        return audience;
    }

    /**
     * <p>
     * A hash value based on the concatenation of the following:
     * </p>
     * <ul>
     * <li>
     * <p>
     * The <code>Issuer</code> response value.
     * </p>
     * </li>
     * <li>
     * <p>
     * The Amazon Web Services account ID.
     * </p>
     * </li>
     * <li>
     * <p>
     * The friendly name (the last part of the ARN) of the SAML provider in IAM.
     * </p>
     * </li>
     * </ul>
     * <p>
     * The combination of <code>NameQualifier</code> and <code>Subject</code> can be used to uniquely identify a user.
     * </p>
     * <p>
     * The following pseudocode shows how the hash value is calculated:
     * </p>
     * <p>
     * <code>BASE64 ( SHA1 ( "https://example.com/saml" + "123456789012" + "/MySAMLIdP" ) )</code>
     * </p>
     * 
     * @return A hash value based on the concatenation of the following:</p>
     *         <ul>
     *         <li>
     *         <p>
     *         The <code>Issuer</code> response value.
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         The Amazon Web Services account ID.
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         The friendly name (the last part of the ARN) of the SAML provider in IAM.
     *         </p>
     *         </li>
     *         </ul>
     *         <p>
     *         The combination of <code>NameQualifier</code> and <code>Subject</code> can be used to uniquely identify a
     *         user.
     *         </p>
     *         <p>
     *         The following pseudocode shows how the hash value is calculated:
     *         </p>
     *         <p>
     *         <code>BASE64 ( SHA1 ( "https://example.com/saml" + "123456789012" + "/MySAMLIdP" ) )</code>
     */
    public final String nameQualifier() {
        return nameQualifier;
    }

    /**
     * <p>
     * The value in the <code>SourceIdentity</code> attribute in the SAML assertion. The source identity value persists
     * across <a href="https://docs.aws.amazon.com/IAM/latest/UserGuide/id_roles.html#iam-term-role-chaining">chained
     * role</a> sessions.
     * </p>
     * <p>
     * You can require users to set a source identity value when they assume a role. You do this by using the
     * <code>sts:SourceIdentity</code> condition key in a role trust policy. That way, actions that are taken with the
     * role are associated with that user. After the source identity is set, the value cannot be changed. It is present
     * in the request for all actions that are taken by the role and persists across <a
     * href="https://docs.aws.amazon.com/IAM/latest/UserGuide/id_roles.html#id_roles_terms-and-concepts">chained
     * role</a> sessions. You can configure your SAML identity provider to use an attribute associated with your users,
     * like user name or email, as the source identity when calling <code>AssumeRoleWithSAML</code>. You do this by
     * adding an attribute to the SAML assertion. For more information about using source identity, see <a
     * href="https://docs.aws.amazon.com/IAM/latest/UserGuide/id_credentials_temp_control-access_monitor.html">Monitor
     * and control actions taken with assumed roles</a> in the <i>IAM User Guide</i>.
     * </p>
     * <p>
     * The regex used to validate this parameter is a string of characters consisting of upper- and lower-case
     * alphanumeric characters with no spaces. You can also include underscores or any of the following characters: =,.@-
     * </p>
     * 
     * @return The value in the <code>SourceIdentity</code> attribute in the SAML assertion. The source identity value
     *         persists across <a
     *         href="https://docs.aws.amazon.com/IAM/latest/UserGuide/id_roles.html#iam-term-role-chaining">chained
     *         role</a> sessions.</p>
     *         <p>
     *         You can require users to set a source identity value when they assume a role. You do this by using the
     *         <code>sts:SourceIdentity</code> condition key in a role trust policy. That way, actions that are taken
     *         with the role are associated with that user. After the source identity is set, the value cannot be
     *         changed. It is present in the request for all actions that are taken by the role and persists across <a
     *         href="https://docs.aws.amazon.com/IAM/latest/UserGuide/id_roles.html#id_roles_terms-and-concepts">chained
     *         role</a> sessions. You can configure your SAML identity provider to use an attribute associated with your
     *         users, like user name or email, as the source identity when calling <code>AssumeRoleWithSAML</code>. You
     *         do this by adding an attribute to the SAML assertion. For more information about using source identity,
     *         see <a
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
        hashCode = 31 * hashCode + Objects.hashCode(assumedRoleUser());
        hashCode = 31 * hashCode + Objects.hashCode(packedPolicySize());
        hashCode = 31 * hashCode + Objects.hashCode(subject());
        hashCode = 31 * hashCode + Objects.hashCode(subjectType());
        hashCode = 31 * hashCode + Objects.hashCode(issuer());
        hashCode = 31 * hashCode + Objects.hashCode(audience());
        hashCode = 31 * hashCode + Objects.hashCode(nameQualifier());
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
        if (!(obj instanceof AssumeRoleWithSamlResponse)) {
            return false;
        }
        AssumeRoleWithSamlResponse other = (AssumeRoleWithSamlResponse) obj;
        return Objects.equals(credentials(), other.credentials()) && Objects.equals(assumedRoleUser(), other.assumedRoleUser())
                && Objects.equals(packedPolicySize(), other.packedPolicySize()) && Objects.equals(subject(), other.subject())
                && Objects.equals(subjectType(), other.subjectType()) && Objects.equals(issuer(), other.issuer())
                && Objects.equals(audience(), other.audience()) && Objects.equals(nameQualifier(), other.nameQualifier())
                && Objects.equals(sourceIdentity(), other.sourceIdentity());
    }

    /**
     * Returns a string representation of this object. This is useful for testing and debugging. Sensitive data will be
     * redacted from this string using a placeholder value.
     */
    @Override
    public final String toString() {
        return ToString.builder("AssumeRoleWithSamlResponse").add("Credentials", credentials())
                .add("AssumedRoleUser", assumedRoleUser()).add("PackedPolicySize", packedPolicySize()).add("Subject", subject())
                .add("SubjectType", subjectType()).add("Issuer", issuer()).add("Audience", audience())
                .add("NameQualifier", nameQualifier()).add("SourceIdentity", sourceIdentity()).build();
    }

    public final <T> Optional<T> getValueForField(String fieldName, Class<T> clazz) {
        switch (fieldName) {
        case "Credentials":
            return Optional.ofNullable(clazz.cast(credentials()));
        case "AssumedRoleUser":
            return Optional.ofNullable(clazz.cast(assumedRoleUser()));
        case "PackedPolicySize":
            return Optional.ofNullable(clazz.cast(packedPolicySize()));
        case "Subject":
            return Optional.ofNullable(clazz.cast(subject()));
        case "SubjectType":
            return Optional.ofNullable(clazz.cast(subjectType()));
        case "Issuer":
            return Optional.ofNullable(clazz.cast(issuer()));
        case "Audience":
            return Optional.ofNullable(clazz.cast(audience()));
        case "NameQualifier":
            return Optional.ofNullable(clazz.cast(nameQualifier()));
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
        map.put("AssumedRoleUser", ASSUMED_ROLE_USER_FIELD);
        map.put("PackedPolicySize", PACKED_POLICY_SIZE_FIELD);
        map.put("Subject", SUBJECT_FIELD);
        map.put("SubjectType", SUBJECT_TYPE_FIELD);
        map.put("Issuer", ISSUER_FIELD);
        map.put("Audience", AUDIENCE_FIELD);
        map.put("NameQualifier", NAME_QUALIFIER_FIELD);
        map.put("SourceIdentity", SOURCE_IDENTITY_FIELD);
        return Collections.unmodifiableMap(map);
    }

    private static <T> Function<Object, T> getter(Function<AssumeRoleWithSamlResponse, T> g) {
        return obj -> g.apply((AssumeRoleWithSamlResponse) obj);
    }

    private static <T> BiConsumer<Object, T> setter(BiConsumer<Builder, T> s) {
        return (obj, val) -> s.accept((Builder) obj, val);
    }

    @Mutable
    @NotThreadSafe
    public interface Builder extends StsResponse.Builder, SdkPojo, CopyableBuilder<Builder, AssumeRoleWithSamlResponse> {
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
         * The identifiers for the temporary security credentials that the operation returns.
         * </p>
         * 
         * @param assumedRoleUser
         *        The identifiers for the temporary security credentials that the operation returns.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder assumedRoleUser(AssumedRoleUser assumedRoleUser);

        /**
         * <p>
         * The identifiers for the temporary security credentials that the operation returns.
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
         * The value of the <code>NameID</code> element in the <code>Subject</code> element of the SAML assertion.
         * </p>
         * 
         * @param subject
         *        The value of the <code>NameID</code> element in the <code>Subject</code> element of the SAML
         *        assertion.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder subject(String subject);

        /**
         * <p>
         * The format of the name ID, as defined by the <code>Format</code> attribute in the <code>NameID</code> element
         * of the SAML assertion. Typical examples of the format are <code>transient</code> or <code>persistent</code>.
         * </p>
         * <p>
         * If the format includes the prefix <code>urn:oasis:names:tc:SAML:2.0:nameid-format</code>, that prefix is
         * removed. For example, <code>urn:oasis:names:tc:SAML:2.0:nameid-format:transient</code> is returned as
         * <code>transient</code>. If the format includes any other prefix, the format is returned with no
         * modifications.
         * </p>
         * 
         * @param subjectType
         *        The format of the name ID, as defined by the <code>Format</code> attribute in the <code>NameID</code>
         *        element of the SAML assertion. Typical examples of the format are <code>transient</code> or
         *        <code>persistent</code>. </p>
         *        <p>
         *        If the format includes the prefix <code>urn:oasis:names:tc:SAML:2.0:nameid-format</code>, that prefix
         *        is removed. For example, <code>urn:oasis:names:tc:SAML:2.0:nameid-format:transient</code> is returned
         *        as <code>transient</code>. If the format includes any other prefix, the format is returned with no
         *        modifications.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder subjectType(String subjectType);

        /**
         * <p>
         * The value of the <code>Issuer</code> element of the SAML assertion.
         * </p>
         * 
         * @param issuer
         *        The value of the <code>Issuer</code> element of the SAML assertion.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder issuer(String issuer);

        /**
         * <p>
         * The value of the <code>Recipient</code> attribute of the <code>SubjectConfirmationData</code> element of the
         * SAML assertion.
         * </p>
         * 
         * @param audience
         *        The value of the <code>Recipient</code> attribute of the <code>SubjectConfirmationData</code> element
         *        of the SAML assertion.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder audience(String audience);

        /**
         * <p>
         * A hash value based on the concatenation of the following:
         * </p>
         * <ul>
         * <li>
         * <p>
         * The <code>Issuer</code> response value.
         * </p>
         * </li>
         * <li>
         * <p>
         * The Amazon Web Services account ID.
         * </p>
         * </li>
         * <li>
         * <p>
         * The friendly name (the last part of the ARN) of the SAML provider in IAM.
         * </p>
         * </li>
         * </ul>
         * <p>
         * The combination of <code>NameQualifier</code> and <code>Subject</code> can be used to uniquely identify a
         * user.
         * </p>
         * <p>
         * The following pseudocode shows how the hash value is calculated:
         * </p>
         * <p>
         * <code>BASE64 ( SHA1 ( "https://example.com/saml" + "123456789012" + "/MySAMLIdP" ) )</code>
         * </p>
         * 
         * @param nameQualifier
         *        A hash value based on the concatenation of the following:</p>
         *        <ul>
         *        <li>
         *        <p>
         *        The <code>Issuer</code> response value.
         *        </p>
         *        </li>
         *        <li>
         *        <p>
         *        The Amazon Web Services account ID.
         *        </p>
         *        </li>
         *        <li>
         *        <p>
         *        The friendly name (the last part of the ARN) of the SAML provider in IAM.
         *        </p>
         *        </li>
         *        </ul>
         *        <p>
         *        The combination of <code>NameQualifier</code> and <code>Subject</code> can be used to uniquely
         *        identify a user.
         *        </p>
         *        <p>
         *        The following pseudocode shows how the hash value is calculated:
         *        </p>
         *        <p>
         *        <code>BASE64 ( SHA1 ( "https://example.com/saml" + "123456789012" + "/MySAMLIdP" ) )</code>
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder nameQualifier(String nameQualifier);

        /**
         * <p>
         * The value in the <code>SourceIdentity</code> attribute in the SAML assertion. The source identity value
         * persists across <a
         * href="https://docs.aws.amazon.com/IAM/latest/UserGuide/id_roles.html#iam-term-role-chaining">chained role</a>
         * sessions.
         * </p>
         * <p>
         * You can require users to set a source identity value when they assume a role. You do this by using the
         * <code>sts:SourceIdentity</code> condition key in a role trust policy. That way, actions that are taken with
         * the role are associated with that user. After the source identity is set, the value cannot be changed. It is
         * present in the request for all actions that are taken by the role and persists across <a
         * href="https://docs.aws.amazon.com/IAM/latest/UserGuide/id_roles.html#id_roles_terms-and-concepts">chained
         * role</a> sessions. You can configure your SAML identity provider to use an attribute associated with your
         * users, like user name or email, as the source identity when calling <code>AssumeRoleWithSAML</code>. You do
         * this by adding an attribute to the SAML assertion. For more information about using source identity, see <a
         * href
         * ="https://docs.aws.amazon.com/IAM/latest/UserGuide/id_credentials_temp_control-access_monitor.html">Monitor
         * and control actions taken with assumed roles</a> in the <i>IAM User Guide</i>.
         * </p>
         * <p>
         * The regex used to validate this parameter is a string of characters consisting of upper- and lower-case
         * alphanumeric characters with no spaces. You can also include underscores or any of the following characters:
         * =,.@-
         * </p>
         * 
         * @param sourceIdentity
         *        The value in the <code>SourceIdentity</code> attribute in the SAML assertion. The source identity
         *        value persists across <a
         *        href="https://docs.aws.amazon.com/IAM/latest/UserGuide/id_roles.html#iam-term-role-chaining">chained
         *        role</a> sessions.</p>
         *        <p>
         *        You can require users to set a source identity value when they assume a role. You do this by using the
         *        <code>sts:SourceIdentity</code> condition key in a role trust policy. That way, actions that are taken
         *        with the role are associated with that user. After the source identity is set, the value cannot be
         *        changed. It is present in the request for all actions that are taken by the role and persists across
         *        <a href="https://docs.aws.amazon.com/IAM/latest/UserGuide/id_roles.html#id_roles_terms-and-concepts">
         *        chained role</a> sessions. You can configure your SAML identity provider to use an attribute
         *        associated with your users, like user name or email, as the source identity when calling
         *        <code>AssumeRoleWithSAML</code>. You do this by adding an attribute to the SAML assertion. For more
         *        information about using source identity, see <a href=
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

        private AssumedRoleUser assumedRoleUser;

        private Integer packedPolicySize;

        private String subject;

        private String subjectType;

        private String issuer;

        private String audience;

        private String nameQualifier;

        private String sourceIdentity;

        private BuilderImpl() {
        }

        private BuilderImpl(AssumeRoleWithSamlResponse model) {
            super(model);
            credentials(model.credentials);
            assumedRoleUser(model.assumedRoleUser);
            packedPolicySize(model.packedPolicySize);
            subject(model.subject);
            subjectType(model.subjectType);
            issuer(model.issuer);
            audience(model.audience);
            nameQualifier(model.nameQualifier);
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

        public final String getSubject() {
            return subject;
        }

        public final void setSubject(String subject) {
            this.subject = subject;
        }

        @Override
        public final Builder subject(String subject) {
            this.subject = subject;
            return this;
        }

        public final String getSubjectType() {
            return subjectType;
        }

        public final void setSubjectType(String subjectType) {
            this.subjectType = subjectType;
        }

        @Override
        public final Builder subjectType(String subjectType) {
            this.subjectType = subjectType;
            return this;
        }

        public final String getIssuer() {
            return issuer;
        }

        public final void setIssuer(String issuer) {
            this.issuer = issuer;
        }

        @Override
        public final Builder issuer(String issuer) {
            this.issuer = issuer;
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

        public final String getNameQualifier() {
            return nameQualifier;
        }

        public final void setNameQualifier(String nameQualifier) {
            this.nameQualifier = nameQualifier;
        }

        @Override
        public final Builder nameQualifier(String nameQualifier) {
            this.nameQualifier = nameQualifier;
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
        public AssumeRoleWithSamlResponse build() {
            return new AssumeRoleWithSamlResponse(this);
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
