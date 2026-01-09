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
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import com.ibm.cos.v2.annotations.Generated;
import com.ibm.cos.v2.annotations.Mutable;
import com.ibm.cos.v2.annotations.NotThreadSafe;
import com.ibm.cos.v2.awscore.AwsRequestOverrideConfiguration;
import com.ibm.cos.v2.core.SdkField;
import com.ibm.cos.v2.core.SdkPojo;
import com.ibm.cos.v2.core.protocol.MarshallLocation;
import com.ibm.cos.v2.core.protocol.MarshallingType;
import com.ibm.cos.v2.core.traits.ListTrait;
import com.ibm.cos.v2.core.traits.LocationTrait;
import com.ibm.cos.v2.core.util.DefaultSdkAutoConstructList;
import com.ibm.cos.v2.core.util.SdkAutoConstructList;
import com.ibm.cos.v2.utils.ToString;
import com.ibm.cos.v2.utils.builder.CopyableBuilder;
import com.ibm.cos.v2.utils.builder.ToCopyableBuilder;

/**
 */
@Generated("com.ibm.cos.v2:codegen")
public final class AssumeRoleWithSamlRequest extends StsRequest implements
        ToCopyableBuilder<AssumeRoleWithSamlRequest.Builder, AssumeRoleWithSamlRequest> {
    private static final SdkField<String> ROLE_ARN_FIELD = SdkField.<String> builder(MarshallingType.STRING)
            .memberName("RoleArn").getter(getter(AssumeRoleWithSamlRequest::roleArn)).setter(setter(Builder::roleArn))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("RoleArn").build()).build();

    private static final SdkField<String> PRINCIPAL_ARN_FIELD = SdkField.<String> builder(MarshallingType.STRING)
            .memberName("PrincipalArn").getter(getter(AssumeRoleWithSamlRequest::principalArn))
            .setter(setter(Builder::principalArn))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("PrincipalArn").build()).build();

    private static final SdkField<String> SAML_ASSERTION_FIELD = SdkField.<String> builder(MarshallingType.STRING)
            .memberName("SAMLAssertion").getter(getter(AssumeRoleWithSamlRequest::samlAssertion))
            .setter(setter(Builder::samlAssertion))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("SAMLAssertion").build()).build();

    private static final SdkField<List<PolicyDescriptorType>> POLICY_ARNS_FIELD = SdkField
            .<List<PolicyDescriptorType>> builder(MarshallingType.LIST)
            .memberName("PolicyArns")
            .getter(getter(AssumeRoleWithSamlRequest::policyArns))
            .setter(setter(Builder::policyArns))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("PolicyArns").build(),
                    ListTrait
                            .builder()
                            .memberLocationName(null)
                            .memberFieldInfo(
                                    SdkField.<PolicyDescriptorType> builder(MarshallingType.SDK_POJO)
                                            .constructor(PolicyDescriptorType::builder)
                                            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD)
                                                    .locationName("member").build()).build()).build()).build();

    private static final SdkField<String> POLICY_FIELD = SdkField.<String> builder(MarshallingType.STRING).memberName("Policy")
            .getter(getter(AssumeRoleWithSamlRequest::policy)).setter(setter(Builder::policy))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("Policy").build()).build();

    private static final SdkField<Integer> DURATION_SECONDS_FIELD = SdkField.<Integer> builder(MarshallingType.INTEGER)
            .memberName("DurationSeconds").getter(getter(AssumeRoleWithSamlRequest::durationSeconds))
            .setter(setter(Builder::durationSeconds))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("DurationSeconds").build()).build();

    private static final List<SdkField<?>> SDK_FIELDS = Collections.unmodifiableList(Arrays.asList(ROLE_ARN_FIELD,
            PRINCIPAL_ARN_FIELD, SAML_ASSERTION_FIELD, POLICY_ARNS_FIELD, POLICY_FIELD, DURATION_SECONDS_FIELD));

    private static final Map<String, SdkField<?>> SDK_NAME_TO_FIELD = memberNameToFieldInitializer();

    private final String roleArn;

    private final String principalArn;

    private final String samlAssertion;

    private final List<PolicyDescriptorType> policyArns;

    private final String policy;

    private final Integer durationSeconds;

    private AssumeRoleWithSamlRequest(BuilderImpl builder) {
        super(builder);
        this.roleArn = builder.roleArn;
        this.principalArn = builder.principalArn;
        this.samlAssertion = builder.samlAssertion;
        this.policyArns = builder.policyArns;
        this.policy = builder.policy;
        this.durationSeconds = builder.durationSeconds;
    }

    /**
     * <p>
     * The Amazon Resource Name (ARN) of the role that the caller is assuming.
     * </p>
     * 
     * @return The Amazon Resource Name (ARN) of the role that the caller is assuming.
     */
    public final String roleArn() {
        return roleArn;
    }

    /**
     * <p>
     * The Amazon Resource Name (ARN) of the SAML provider in IAM that describes the IdP.
     * </p>
     * 
     * @return The Amazon Resource Name (ARN) of the SAML provider in IAM that describes the IdP.
     */
    public final String principalArn() {
        return principalArn;
    }

    /**
     * <p>
     * The base64 encoded SAML authentication response provided by the IdP.
     * </p>
     * <p>
     * For more information, see <a
     * href="https://docs.aws.amazon.com/IAM/latest/UserGuide/create-role-saml-IdP-tasks.html">Configuring a Relying
     * Party and Adding Claims</a> in the <i>IAM User Guide</i>.
     * </p>
     * 
     * @return The base64 encoded SAML authentication response provided by the IdP.</p>
     *         <p>
     *         For more information, see <a
     *         href="https://docs.aws.amazon.com/IAM/latest/UserGuide/create-role-saml-IdP-tasks.html">Configuring a
     *         Relying Party and Adding Claims</a> in the <i>IAM User Guide</i>.
     */
    public final String samlAssertion() {
        return samlAssertion;
    }

    /**
     * For responses, this returns true if the service returned a value for the PolicyArns property. This DOES NOT check
     * that the value is non-empty (for which, you should check the {@code isEmpty()} method on the property). This is
     * useful because the SDK will never return a null collection or map, but you may need to differentiate between the
     * service returning nothing (or null) and the service returning an empty collection or map. For requests, this
     * returns true if a value for the property was specified in the request builder, and false if a value was not
     * specified.
     */
    public final boolean hasPolicyArns() {
        return policyArns != null && !(policyArns instanceof SdkAutoConstructList);
    }

    /**
     * <p>
     * The Amazon Resource Names (ARNs) of the IAM managed policies that you want to use as managed session policies.
     * The policies must exist in the same account as the role.
     * </p>
     * <p>
     * This parameter is optional. You can provide up to 10 managed policy ARNs. However, the plaintext that you use for
     * both inline and managed session policies can't exceed 2,048 characters. For more information about ARNs, see <a
     * href="https://docs.aws.amazon.com/general/latest/gr/aws-arns-and-namespaces.html">Amazon Resource Names (ARNs)
     * and Amazon Web Services Service Namespaces</a> in the Amazon Web Services General Reference.
     * </p>
     * <note>
     * <p>
     * An Amazon Web Services conversion compresses the passed inline session policy, managed policy ARNs, and session
     * tags into a packed binary format that has a separate limit. Your request can fail for this limit even if your
     * plaintext meets the other requirements. The <code>PackedPolicySize</code> response element indicates by
     * percentage how close the policies and tags for your request are to the upper size limit.
     * </p>
     * </note>
     * <p>
     * Passing policies to this operation returns new temporary credentials. The resulting session's permissions are the
     * intersection of the role's identity-based policy and the session policies. You can use the role's temporary
     * credentials in subsequent Amazon Web Services API calls to access resources in the account that owns the role.
     * You cannot use session policies to grant more permissions than those allowed by the identity-based policy of the
     * role that is being assumed. For more information, see <a
     * href="https://docs.aws.amazon.com/IAM/latest/UserGuide/access_policies.html#policies_session">Session
     * Policies</a> in the <i>IAM User Guide</i>.
     * </p>
     * <p>
     * Attempts to modify the collection returned by this method will result in an UnsupportedOperationException.
     * </p>
     * <p>
     * This method will never return null. If you would like to know whether the service returned this field (so that
     * you can differentiate between null and empty), you can use the {@link #hasPolicyArns} method.
     * </p>
     * 
     * @return The Amazon Resource Names (ARNs) of the IAM managed policies that you want to use as managed session
     *         policies. The policies must exist in the same account as the role.</p>
     *         <p>
     *         This parameter is optional. You can provide up to 10 managed policy ARNs. However, the plaintext that you
     *         use for both inline and managed session policies can't exceed 2,048 characters. For more information
     *         about ARNs, see <a
     *         href="https://docs.aws.amazon.com/general/latest/gr/aws-arns-and-namespaces.html">Amazon Resource Names
     *         (ARNs) and Amazon Web Services Service Namespaces</a> in the Amazon Web Services General Reference.
     *         </p>
     *         <note>
     *         <p>
     *         An Amazon Web Services conversion compresses the passed inline session policy, managed policy ARNs, and
     *         session tags into a packed binary format that has a separate limit. Your request can fail for this limit
     *         even if your plaintext meets the other requirements. The <code>PackedPolicySize</code> response element
     *         indicates by percentage how close the policies and tags for your request are to the upper size limit.
     *         </p>
     *         </note>
     *         <p>
     *         Passing policies to this operation returns new temporary credentials. The resulting session's permissions
     *         are the intersection of the role's identity-based policy and the session policies. You can use the role's
     *         temporary credentials in subsequent Amazon Web Services API calls to access resources in the account that
     *         owns the role. You cannot use session policies to grant more permissions than those allowed by the
     *         identity-based policy of the role that is being assumed. For more information, see <a
     *         href="https://docs.aws.amazon.com/IAM/latest/UserGuide/access_policies.html#policies_session">Session
     *         Policies</a> in the <i>IAM User Guide</i>.
     */
    public final List<PolicyDescriptorType> policyArns() {
        return policyArns;
    }

    /**
     * <p>
     * An IAM policy in JSON format that you want to use as an inline session policy.
     * </p>
     * <p>
     * This parameter is optional. Passing policies to this operation returns new temporary credentials. The resulting
     * session's permissions are the intersection of the role's identity-based policy and the session policies. You can
     * use the role's temporary credentials in subsequent Amazon Web Services API calls to access resources in the
     * account that owns the role. You cannot use session policies to grant more permissions than those allowed by the
     * identity-based policy of the role that is being assumed. For more information, see <a
     * href="https://docs.aws.amazon.com/IAM/latest/UserGuide/access_policies.html#policies_session">Session
     * Policies</a> in the <i>IAM User Guide</i>.
     * </p>
     * <p>
     * The plaintext that you use for both inline and managed session policies can't exceed 2,048 characters. The JSON
     * policy characters can be any ASCII character from the space character to the end of the valid character list (
     * through \u00FF). It can also include the tab ( ), linefeed ( ), and carriage return ( ) characters.
     * </p>
     * <p>
     * For more information about role session permissions, see <a
     * href="https://docs.aws.amazon.com/IAM/latest/UserGuide/access_policies.html#policies_session">Session
     * policies</a>.
     * </p>
     * <note>
     * <p>
     * An Amazon Web Services conversion compresses the passed inline session policy, managed policy ARNs, and session
     * tags into a packed binary format that has a separate limit. Your request can fail for this limit even if your
     * plaintext meets the other requirements. The <code>PackedPolicySize</code> response element indicates by
     * percentage how close the policies and tags for your request are to the upper size limit.
     * </p>
     * </note>
     * 
     * @return An IAM policy in JSON format that you want to use as an inline session policy.</p>
     *         <p>
     *         This parameter is optional. Passing policies to this operation returns new temporary credentials. The
     *         resulting session's permissions are the intersection of the role's identity-based policy and the session
     *         policies. You can use the role's temporary credentials in subsequent Amazon Web Services API calls to
     *         access resources in the account that owns the role. You cannot use session policies to grant more
     *         permissions than those allowed by the identity-based policy of the role that is being assumed. For more
     *         information, see <a
     *         href="https://docs.aws.amazon.com/IAM/latest/UserGuide/access_policies.html#policies_session">Session
     *         Policies</a> in the <i>IAM User Guide</i>.
     *         </p>
     *         <p>
     *         The plaintext that you use for both inline and managed session policies can't exceed 2,048 characters.
     *         The JSON policy characters can be any ASCII character from the space character to the end of the valid
     *         character list ( through \u00FF). It can also include the tab ( ), linefeed ( ), and carriage return ( )
     *         characters.
     *         </p>
     *         <p>
     *         For more information about role session permissions, see <a
     *         href="https://docs.aws.amazon.com/IAM/latest/UserGuide/access_policies.html#policies_session">Session
     *         policies</a>.
     *         </p>
     *         <note>
     *         <p>
     *         An Amazon Web Services conversion compresses the passed inline session policy, managed policy ARNs, and
     *         session tags into a packed binary format that has a separate limit. Your request can fail for this limit
     *         even if your plaintext meets the other requirements. The <code>PackedPolicySize</code> response element
     *         indicates by percentage how close the policies and tags for your request are to the upper size limit.
     *         </p>
     */
    public final String policy() {
        return policy;
    }

    /**
     * <p>
     * The duration, in seconds, of the role session. Your role session lasts for the duration that you specify for the
     * <code>DurationSeconds</code> parameter, or until the time specified in the SAML authentication response's
     * <code>SessionNotOnOrAfter</code> value, whichever is shorter. You can provide a <code>DurationSeconds</code>
     * value from 900 seconds (15 minutes) up to the maximum session duration setting for the role. This setting can
     * have a value from 1 hour to 12 hours. If you specify a value higher than this setting, the operation fails. For
     * example, if you specify a session duration of 12 hours, but your administrator set the maximum session duration
     * to 6 hours, your operation fails. To learn how to view the maximum value for your role, see <a
     * href="https://docs.aws.amazon.com/IAM/latest/UserGuide/id_roles_use.html#id_roles_use_view-role-max-session">View
     * the Maximum Session Duration Setting for a Role</a> in the <i>IAM User Guide</i>.
     * </p>
     * <p>
     * By default, the value is set to <code>3600</code> seconds.
     * </p>
     * <note>
     * <p>
     * The <code>DurationSeconds</code> parameter is separate from the duration of a console session that you might
     * request using the returned credentials. The request to the federation endpoint for a console sign-in token takes
     * a <code>SessionDuration</code> parameter that specifies the maximum length of the console session. For more
     * information, see <a
     * href="https://docs.aws.amazon.com/IAM/latest/UserGuide/id_roles_providers_enable-console-custom-url.html"
     * >Creating a URL that Enables Federated Users to Access the Amazon Web Services Management Console</a> in the
     * <i>IAM User Guide</i>.
     * </p>
     * </note>
     * 
     * @return The duration, in seconds, of the role session. Your role session lasts for the duration that you specify
     *         for the <code>DurationSeconds</code> parameter, or until the time specified in the SAML authentication
     *         response's <code>SessionNotOnOrAfter</code> value, whichever is shorter. You can provide a
     *         <code>DurationSeconds</code> value from 900 seconds (15 minutes) up to the maximum session duration
     *         setting for the role. This setting can have a value from 1 hour to 12 hours. If you specify a value
     *         higher than this setting, the operation fails. For example, if you specify a session duration of 12
     *         hours, but your administrator set the maximum session duration to 6 hours, your operation fails. To learn
     *         how to view the maximum value for your role, see <a href=
     *         "https://docs.aws.amazon.com/IAM/latest/UserGuide/id_roles_use.html#id_roles_use_view-role-max-session"
     *         >View the Maximum Session Duration Setting for a Role</a> in the <i>IAM User Guide</i>.</p>
     *         <p>
     *         By default, the value is set to <code>3600</code> seconds.
     *         </p>
     *         <note>
     *         <p>
     *         The <code>DurationSeconds</code> parameter is separate from the duration of a console session that you
     *         might request using the returned credentials. The request to the federation endpoint for a console
     *         sign-in token takes a <code>SessionDuration</code> parameter that specifies the maximum length of the
     *         console session. For more information, see <a href=
     *         "https://docs.aws.amazon.com/IAM/latest/UserGuide/id_roles_providers_enable-console-custom-url.html"
     *         >Creating a URL that Enables Federated Users to Access the Amazon Web Services Management Console</a> in
     *         the <i>IAM User Guide</i>.
     *         </p>
     */
    public final Integer durationSeconds() {
        return durationSeconds;
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
        hashCode = 31 * hashCode + Objects.hashCode(roleArn());
        hashCode = 31 * hashCode + Objects.hashCode(principalArn());
        hashCode = 31 * hashCode + Objects.hashCode(samlAssertion());
        hashCode = 31 * hashCode + Objects.hashCode(hasPolicyArns() ? policyArns() : null);
        hashCode = 31 * hashCode + Objects.hashCode(policy());
        hashCode = 31 * hashCode + Objects.hashCode(durationSeconds());
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
        if (!(obj instanceof AssumeRoleWithSamlRequest)) {
            return false;
        }
        AssumeRoleWithSamlRequest other = (AssumeRoleWithSamlRequest) obj;
        return Objects.equals(roleArn(), other.roleArn()) && Objects.equals(principalArn(), other.principalArn())
                && Objects.equals(samlAssertion(), other.samlAssertion()) && hasPolicyArns() == other.hasPolicyArns()
                && Objects.equals(policyArns(), other.policyArns()) && Objects.equals(policy(), other.policy())
                && Objects.equals(durationSeconds(), other.durationSeconds());
    }

    /**
     * Returns a string representation of this object. This is useful for testing and debugging. Sensitive data will be
     * redacted from this string using a placeholder value.
     */
    @Override
    public final String toString() {
        return ToString.builder("AssumeRoleWithSamlRequest").add("RoleArn", roleArn()).add("PrincipalArn", principalArn())
                .add("SAMLAssertion", samlAssertion() == null ? null : "*** Sensitive Data Redacted ***")
                .add("PolicyArns", hasPolicyArns() ? policyArns() : null).add("Policy", policy())
                .add("DurationSeconds", durationSeconds()).build();
    }

    public final <T> Optional<T> getValueForField(String fieldName, Class<T> clazz) {
        switch (fieldName) {
        case "RoleArn":
            return Optional.ofNullable(clazz.cast(roleArn()));
        case "PrincipalArn":
            return Optional.ofNullable(clazz.cast(principalArn()));
        case "SAMLAssertion":
            return Optional.ofNullable(clazz.cast(samlAssertion()));
        case "PolicyArns":
            return Optional.ofNullable(clazz.cast(policyArns()));
        case "Policy":
            return Optional.ofNullable(clazz.cast(policy()));
        case "DurationSeconds":
            return Optional.ofNullable(clazz.cast(durationSeconds()));
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
        map.put("RoleArn", ROLE_ARN_FIELD);
        map.put("PrincipalArn", PRINCIPAL_ARN_FIELD);
        map.put("SAMLAssertion", SAML_ASSERTION_FIELD);
        map.put("PolicyArns", POLICY_ARNS_FIELD);
        map.put("Policy", POLICY_FIELD);
        map.put("DurationSeconds", DURATION_SECONDS_FIELD);
        return Collections.unmodifiableMap(map);
    }

    private static <T> Function<Object, T> getter(Function<AssumeRoleWithSamlRequest, T> g) {
        return obj -> g.apply((AssumeRoleWithSamlRequest) obj);
    }

    private static <T> BiConsumer<Object, T> setter(BiConsumer<Builder, T> s) {
        return (obj, val) -> s.accept((Builder) obj, val);
    }

    @Mutable
    @NotThreadSafe
    public interface Builder extends StsRequest.Builder, SdkPojo, CopyableBuilder<Builder, AssumeRoleWithSamlRequest> {
        /**
         * <p>
         * The Amazon Resource Name (ARN) of the role that the caller is assuming.
         * </p>
         * 
         * @param roleArn
         *        The Amazon Resource Name (ARN) of the role that the caller is assuming.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder roleArn(String roleArn);

        /**
         * <p>
         * The Amazon Resource Name (ARN) of the SAML provider in IAM that describes the IdP.
         * </p>
         * 
         * @param principalArn
         *        The Amazon Resource Name (ARN) of the SAML provider in IAM that describes the IdP.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder principalArn(String principalArn);

        /**
         * <p>
         * The base64 encoded SAML authentication response provided by the IdP.
         * </p>
         * <p>
         * For more information, see <a
         * href="https://docs.aws.amazon.com/IAM/latest/UserGuide/create-role-saml-IdP-tasks.html">Configuring a Relying
         * Party and Adding Claims</a> in the <i>IAM User Guide</i>.
         * </p>
         * 
         * @param samlAssertion
         *        The base64 encoded SAML authentication response provided by the IdP.</p>
         *        <p>
         *        For more information, see <a
         *        href="https://docs.aws.amazon.com/IAM/latest/UserGuide/create-role-saml-IdP-tasks.html">Configuring a
         *        Relying Party and Adding Claims</a> in the <i>IAM User Guide</i>.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder samlAssertion(String samlAssertion);

        /**
         * <p>
         * The Amazon Resource Names (ARNs) of the IAM managed policies that you want to use as managed session
         * policies. The policies must exist in the same account as the role.
         * </p>
         * <p>
         * This parameter is optional. You can provide up to 10 managed policy ARNs. However, the plaintext that you use
         * for both inline and managed session policies can't exceed 2,048 characters. For more information about ARNs,
         * see <a href="https://docs.aws.amazon.com/general/latest/gr/aws-arns-and-namespaces.html">Amazon Resource
         * Names (ARNs) and Amazon Web Services Service Namespaces</a> in the Amazon Web Services General Reference.
         * </p>
         * <note>
         * <p>
         * An Amazon Web Services conversion compresses the passed inline session policy, managed policy ARNs, and
         * session tags into a packed binary format that has a separate limit. Your request can fail for this limit even
         * if your plaintext meets the other requirements. The <code>PackedPolicySize</code> response element indicates
         * by percentage how close the policies and tags for your request are to the upper size limit.
         * </p>
         * </note>
         * <p>
         * Passing policies to this operation returns new temporary credentials. The resulting session's permissions are
         * the intersection of the role's identity-based policy and the session policies. You can use the role's
         * temporary credentials in subsequent Amazon Web Services API calls to access resources in the account that
         * owns the role. You cannot use session policies to grant more permissions than those allowed by the
         * identity-based policy of the role that is being assumed. For more information, see <a
         * href="https://docs.aws.amazon.com/IAM/latest/UserGuide/access_policies.html#policies_session">Session
         * Policies</a> in the <i>IAM User Guide</i>.
         * </p>
         * 
         * @param policyArns
         *        The Amazon Resource Names (ARNs) of the IAM managed policies that you want to use as managed session
         *        policies. The policies must exist in the same account as the role.</p>
         *        <p>
         *        This parameter is optional. You can provide up to 10 managed policy ARNs. However, the plaintext that
         *        you use for both inline and managed session policies can't exceed 2,048 characters. For more
         *        information about ARNs, see <a
         *        href="https://docs.aws.amazon.com/general/latest/gr/aws-arns-and-namespaces.html">Amazon Resource
         *        Names (ARNs) and Amazon Web Services Service Namespaces</a> in the Amazon Web Services General
         *        Reference.
         *        </p>
         *        <note>
         *        <p>
         *        An Amazon Web Services conversion compresses the passed inline session policy, managed policy ARNs,
         *        and session tags into a packed binary format that has a separate limit. Your request can fail for this
         *        limit even if your plaintext meets the other requirements. The <code>PackedPolicySize</code> response
         *        element indicates by percentage how close the policies and tags for your request are to the upper size
         *        limit.
         *        </p>
         *        </note>
         *        <p>
         *        Passing policies to this operation returns new temporary credentials. The resulting session's
         *        permissions are the intersection of the role's identity-based policy and the session policies. You can
         *        use the role's temporary credentials in subsequent Amazon Web Services API calls to access resources
         *        in the account that owns the role. You cannot use session policies to grant more permissions than
         *        those allowed by the identity-based policy of the role that is being assumed. For more information,
         *        see <a href="https://docs.aws.amazon.com/IAM/latest/UserGuide/access_policies.html#policies_session">
         *        Session Policies</a> in the <i>IAM User Guide</i>.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder policyArns(Collection<PolicyDescriptorType> policyArns);

        /**
         * <p>
         * The Amazon Resource Names (ARNs) of the IAM managed policies that you want to use as managed session
         * policies. The policies must exist in the same account as the role.
         * </p>
         * <p>
         * This parameter is optional. You can provide up to 10 managed policy ARNs. However, the plaintext that you use
         * for both inline and managed session policies can't exceed 2,048 characters. For more information about ARNs,
         * see <a href="https://docs.aws.amazon.com/general/latest/gr/aws-arns-and-namespaces.html">Amazon Resource
         * Names (ARNs) and Amazon Web Services Service Namespaces</a> in the Amazon Web Services General Reference.
         * </p>
         * <note>
         * <p>
         * An Amazon Web Services conversion compresses the passed inline session policy, managed policy ARNs, and
         * session tags into a packed binary format that has a separate limit. Your request can fail for this limit even
         * if your plaintext meets the other requirements. The <code>PackedPolicySize</code> response element indicates
         * by percentage how close the policies and tags for your request are to the upper size limit.
         * </p>
         * </note>
         * <p>
         * Passing policies to this operation returns new temporary credentials. The resulting session's permissions are
         * the intersection of the role's identity-based policy and the session policies. You can use the role's
         * temporary credentials in subsequent Amazon Web Services API calls to access resources in the account that
         * owns the role. You cannot use session policies to grant more permissions than those allowed by the
         * identity-based policy of the role that is being assumed. For more information, see <a
         * href="https://docs.aws.amazon.com/IAM/latest/UserGuide/access_policies.html#policies_session">Session
         * Policies</a> in the <i>IAM User Guide</i>.
         * </p>
         * 
         * @param policyArns
         *        The Amazon Resource Names (ARNs) of the IAM managed policies that you want to use as managed session
         *        policies. The policies must exist in the same account as the role.</p>
         *        <p>
         *        This parameter is optional. You can provide up to 10 managed policy ARNs. However, the plaintext that
         *        you use for both inline and managed session policies can't exceed 2,048 characters. For more
         *        information about ARNs, see <a
         *        href="https://docs.aws.amazon.com/general/latest/gr/aws-arns-and-namespaces.html">Amazon Resource
         *        Names (ARNs) and Amazon Web Services Service Namespaces</a> in the Amazon Web Services General
         *        Reference.
         *        </p>
         *        <note>
         *        <p>
         *        An Amazon Web Services conversion compresses the passed inline session policy, managed policy ARNs,
         *        and session tags into a packed binary format that has a separate limit. Your request can fail for this
         *        limit even if your plaintext meets the other requirements. The <code>PackedPolicySize</code> response
         *        element indicates by percentage how close the policies and tags for your request are to the upper size
         *        limit.
         *        </p>
         *        </note>
         *        <p>
         *        Passing policies to this operation returns new temporary credentials. The resulting session's
         *        permissions are the intersection of the role's identity-based policy and the session policies. You can
         *        use the role's temporary credentials in subsequent Amazon Web Services API calls to access resources
         *        in the account that owns the role. You cannot use session policies to grant more permissions than
         *        those allowed by the identity-based policy of the role that is being assumed. For more information,
         *        see <a href="https://docs.aws.amazon.com/IAM/latest/UserGuide/access_policies.html#policies_session">
         *        Session Policies</a> in the <i>IAM User Guide</i>.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder policyArns(PolicyDescriptorType... policyArns);

        /**
         * <p>
         * The Amazon Resource Names (ARNs) of the IAM managed policies that you want to use as managed session
         * policies. The policies must exist in the same account as the role.
         * </p>
         * <p>
         * This parameter is optional. You can provide up to 10 managed policy ARNs. However, the plaintext that you use
         * for both inline and managed session policies can't exceed 2,048 characters. For more information about ARNs,
         * see <a href="https://docs.aws.amazon.com/general/latest/gr/aws-arns-and-namespaces.html">Amazon Resource
         * Names (ARNs) and Amazon Web Services Service Namespaces</a> in the Amazon Web Services General Reference.
         * </p>
         * <note>
         * <p>
         * An Amazon Web Services conversion compresses the passed inline session policy, managed policy ARNs, and
         * session tags into a packed binary format that has a separate limit. Your request can fail for this limit even
         * if your plaintext meets the other requirements. The <code>PackedPolicySize</code> response element indicates
         * by percentage how close the policies and tags for your request are to the upper size limit.
         * </p>
         * </note>
         * <p>
         * Passing policies to this operation returns new temporary credentials. The resulting session's permissions are
         * the intersection of the role's identity-based policy and the session policies. You can use the role's
         * temporary credentials in subsequent Amazon Web Services API calls to access resources in the account that
         * owns the role. You cannot use session policies to grant more permissions than those allowed by the
         * identity-based policy of the role that is being assumed. For more information, see <a
         * href="https://docs.aws.amazon.com/IAM/latest/UserGuide/access_policies.html#policies_session">Session
         * Policies</a> in the <i>IAM User Guide</i>.
         * </p>
         * This is a convenience method that creates an instance of the
         * {@link com.ibm.cos.v2.services.sts.model.PolicyDescriptorType.Builder} avoiding the need to create
         * one manually via {@link com.ibm.cos.v2.services.sts.model.PolicyDescriptorType#builder()}.
         *
         * <p>
         * When the {@link Consumer} completes,
         * {@link com.ibm.cos.v2.services.sts.model.PolicyDescriptorType.Builder#build()} is called immediately
         * and its result is passed to {@link #policyArns(List<PolicyDescriptorType>)}.
         * 
         * @param policyArns
         *        a consumer that will call methods on
         *        {@link com.ibm.cos.v2.services.sts.model.PolicyDescriptorType.Builder}
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see #policyArns(java.util.Collection<PolicyDescriptorType>)
         */
        Builder policyArns(Consumer<PolicyDescriptorType.Builder>... policyArns);

        /**
         * <p>
         * An IAM policy in JSON format that you want to use as an inline session policy.
         * </p>
         * <p>
         * This parameter is optional. Passing policies to this operation returns new temporary credentials. The
         * resulting session's permissions are the intersection of the role's identity-based policy and the session
         * policies. You can use the role's temporary credentials in subsequent Amazon Web Services API calls to access
         * resources in the account that owns the role. You cannot use session policies to grant more permissions than
         * those allowed by the identity-based policy of the role that is being assumed. For more information, see <a
         * href="https://docs.aws.amazon.com/IAM/latest/UserGuide/access_policies.html#policies_session">Session
         * Policies</a> in the <i>IAM User Guide</i>.
         * </p>
         * <p>
         * The plaintext that you use for both inline and managed session policies can't exceed 2,048 characters. The
         * JSON policy characters can be any ASCII character from the space character to the end of the valid character
         * list ( through \u00FF). It can also include the tab ( ), linefeed ( ), and carriage return ( ) characters.
         * </p>
         * <p>
         * For more information about role session permissions, see <a
         * href="https://docs.aws.amazon.com/IAM/latest/UserGuide/access_policies.html#policies_session">Session
         * policies</a>.
         * </p>
         * <note>
         * <p>
         * An Amazon Web Services conversion compresses the passed inline session policy, managed policy ARNs, and
         * session tags into a packed binary format that has a separate limit. Your request can fail for this limit even
         * if your plaintext meets the other requirements. The <code>PackedPolicySize</code> response element indicates
         * by percentage how close the policies and tags for your request are to the upper size limit.
         * </p>
         * </note>
         * 
         * @param policy
         *        An IAM policy in JSON format that you want to use as an inline session policy.</p>
         *        <p>
         *        This parameter is optional. Passing policies to this operation returns new temporary credentials. The
         *        resulting session's permissions are the intersection of the role's identity-based policy and the
         *        session policies. You can use the role's temporary credentials in subsequent Amazon Web Services API
         *        calls to access resources in the account that owns the role. You cannot use session policies to grant
         *        more permissions than those allowed by the identity-based policy of the role that is being assumed.
         *        For more information, see <a
         *        href="https://docs.aws.amazon.com/IAM/latest/UserGuide/access_policies.html#policies_session">Session
         *        Policies</a> in the <i>IAM User Guide</i>.
         *        </p>
         *        <p>
         *        The plaintext that you use for both inline and managed session policies can't exceed 2,048 characters.
         *        The JSON policy characters can be any ASCII character from the space character to the end of the valid
         *        character list ( through \u00FF). It can also include the tab ( ), linefeed ( ), and carriage return (
         *        ) characters.
         *        </p>
         *        <p>
         *        For more information about role session permissions, see <a
         *        href="https://docs.aws.amazon.com/IAM/latest/UserGuide/access_policies.html#policies_session">Session
         *        policies</a>.
         *        </p>
         *        <note>
         *        <p>
         *        An Amazon Web Services conversion compresses the passed inline session policy, managed policy ARNs,
         *        and session tags into a packed binary format that has a separate limit. Your request can fail for this
         *        limit even if your plaintext meets the other requirements. The <code>PackedPolicySize</code> response
         *        element indicates by percentage how close the policies and tags for your request are to the upper size
         *        limit.
         *        </p>
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder policy(String policy);

        /**
         * <p>
         * The duration, in seconds, of the role session. Your role session lasts for the duration that you specify for
         * the <code>DurationSeconds</code> parameter, or until the time specified in the SAML authentication response's
         * <code>SessionNotOnOrAfter</code> value, whichever is shorter. You can provide a <code>DurationSeconds</code>
         * value from 900 seconds (15 minutes) up to the maximum session duration setting for the role. This setting can
         * have a value from 1 hour to 12 hours. If you specify a value higher than this setting, the operation fails.
         * For example, if you specify a session duration of 12 hours, but your administrator set the maximum session
         * duration to 6 hours, your operation fails. To learn how to view the maximum value for your role, see <a href=
         * "https://docs.aws.amazon.com/IAM/latest/UserGuide/id_roles_use.html#id_roles_use_view-role-max-session">View
         * the Maximum Session Duration Setting for a Role</a> in the <i>IAM User Guide</i>.
         * </p>
         * <p>
         * By default, the value is set to <code>3600</code> seconds.
         * </p>
         * <note>
         * <p>
         * The <code>DurationSeconds</code> parameter is separate from the duration of a console session that you might
         * request using the returned credentials. The request to the federation endpoint for a console sign-in token
         * takes a <code>SessionDuration</code> parameter that specifies the maximum length of the console session. For
         * more information, see <a
         * href="https://docs.aws.amazon.com/IAM/latest/UserGuide/id_roles_providers_enable-console-custom-url.html"
         * >Creating a URL that Enables Federated Users to Access the Amazon Web Services Management Console</a> in the
         * <i>IAM User Guide</i>.
         * </p>
         * </note>
         * 
         * @param durationSeconds
         *        The duration, in seconds, of the role session. Your role session lasts for the duration that you
         *        specify for the <code>DurationSeconds</code> parameter, or until the time specified in the SAML
         *        authentication response's <code>SessionNotOnOrAfter</code> value, whichever is shorter. You can
         *        provide a <code>DurationSeconds</code> value from 900 seconds (15 minutes) up to the maximum session
         *        duration setting for the role. This setting can have a value from 1 hour to 12 hours. If you specify a
         *        value higher than this setting, the operation fails. For example, if you specify a session duration of
         *        12 hours, but your administrator set the maximum session duration to 6 hours, your operation fails. To
         *        learn how to view the maximum value for your role, see <a href=
         *        "https://docs.aws.amazon.com/IAM/latest/UserGuide/id_roles_use.html#id_roles_use_view-role-max-session"
         *        >View the Maximum Session Duration Setting for a Role</a> in the <i>IAM User Guide</i>.</p>
         *        <p>
         *        By default, the value is set to <code>3600</code> seconds.
         *        </p>
         *        <note>
         *        <p>
         *        The <code>DurationSeconds</code> parameter is separate from the duration of a console session that you
         *        might request using the returned credentials. The request to the federation endpoint for a console
         *        sign-in token takes a <code>SessionDuration</code> parameter that specifies the maximum length of the
         *        console session. For more information, see <a href=
         *        "https://docs.aws.amazon.com/IAM/latest/UserGuide/id_roles_providers_enable-console-custom-url.html"
         *        >Creating a URL that Enables Federated Users to Access the Amazon Web Services Management Console</a>
         *        in the <i>IAM User Guide</i>.
         *        </p>
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder durationSeconds(Integer durationSeconds);

        @Override
        Builder overrideConfiguration(AwsRequestOverrideConfiguration overrideConfiguration);

        @Override
        Builder overrideConfiguration(Consumer<AwsRequestOverrideConfiguration.Builder> builderConsumer);
    }

    static final class BuilderImpl extends StsRequest.BuilderImpl implements Builder {
        private String roleArn;

        private String principalArn;

        private String samlAssertion;

        private List<PolicyDescriptorType> policyArns = DefaultSdkAutoConstructList.getInstance();

        private String policy;

        private Integer durationSeconds;

        private BuilderImpl() {
        }

        private BuilderImpl(AssumeRoleWithSamlRequest model) {
            super(model);
            roleArn(model.roleArn);
            principalArn(model.principalArn);
            samlAssertion(model.samlAssertion);
            policyArns(model.policyArns);
            policy(model.policy);
            durationSeconds(model.durationSeconds);
        }

        public final String getRoleArn() {
            return roleArn;
        }

        public final void setRoleArn(String roleArn) {
            this.roleArn = roleArn;
        }

        @Override
        public final Builder roleArn(String roleArn) {
            this.roleArn = roleArn;
            return this;
        }

        public final String getPrincipalArn() {
            return principalArn;
        }

        public final void setPrincipalArn(String principalArn) {
            this.principalArn = principalArn;
        }

        @Override
        public final Builder principalArn(String principalArn) {
            this.principalArn = principalArn;
            return this;
        }

        public final String getSamlAssertion() {
            return samlAssertion;
        }

        public final void setSamlAssertion(String samlAssertion) {
            this.samlAssertion = samlAssertion;
        }

        @Override
        public final Builder samlAssertion(String samlAssertion) {
            this.samlAssertion = samlAssertion;
            return this;
        }

        public final List<PolicyDescriptorType.Builder> getPolicyArns() {
            List<PolicyDescriptorType.Builder> result = _policyDescriptorListTypeCopier.copyToBuilder(this.policyArns);
            if (result instanceof SdkAutoConstructList) {
                return null;
            }
            return result;
        }

        public final void setPolicyArns(Collection<PolicyDescriptorType.BuilderImpl> policyArns) {
            this.policyArns = _policyDescriptorListTypeCopier.copyFromBuilder(policyArns);
        }

        @Override
        public final Builder policyArns(Collection<PolicyDescriptorType> policyArns) {
            this.policyArns = _policyDescriptorListTypeCopier.copy(policyArns);
            return this;
        }

        @Override
        @SafeVarargs
        public final Builder policyArns(PolicyDescriptorType... policyArns) {
            policyArns(Arrays.asList(policyArns));
            return this;
        }

        @Override
        @SafeVarargs
        public final Builder policyArns(Consumer<PolicyDescriptorType.Builder>... policyArns) {
            policyArns(Stream.of(policyArns).map(c -> PolicyDescriptorType.builder().applyMutation(c).build())
                    .collect(Collectors.toList()));
            return this;
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

        public final Integer getDurationSeconds() {
            return durationSeconds;
        }

        public final void setDurationSeconds(Integer durationSeconds) {
            this.durationSeconds = durationSeconds;
        }

        @Override
        public final Builder durationSeconds(Integer durationSeconds) {
            this.durationSeconds = durationSeconds;
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
        public AssumeRoleWithSamlRequest build() {
            return new AssumeRoleWithSamlRequest(this);
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
