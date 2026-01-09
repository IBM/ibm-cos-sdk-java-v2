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
public final class AssumeRoleRequest extends StsRequest implements
        ToCopyableBuilder<AssumeRoleRequest.Builder, AssumeRoleRequest> {
    private static final SdkField<String> ROLE_ARN_FIELD = SdkField.<String> builder(MarshallingType.STRING)
            .memberName("RoleArn").getter(getter(AssumeRoleRequest::roleArn)).setter(setter(Builder::roleArn))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("RoleArn").build()).build();

    private static final SdkField<String> ROLE_SESSION_NAME_FIELD = SdkField.<String> builder(MarshallingType.STRING)
            .memberName("RoleSessionName").getter(getter(AssumeRoleRequest::roleSessionName))
            .setter(setter(Builder::roleSessionName))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("RoleSessionName").build()).build();

    private static final SdkField<List<PolicyDescriptorType>> POLICY_ARNS_FIELD = SdkField
            .<List<PolicyDescriptorType>> builder(MarshallingType.LIST)
            .memberName("PolicyArns")
            .getter(getter(AssumeRoleRequest::policyArns))
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
            .getter(getter(AssumeRoleRequest::policy)).setter(setter(Builder::policy))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("Policy").build()).build();

    private static final SdkField<Integer> DURATION_SECONDS_FIELD = SdkField.<Integer> builder(MarshallingType.INTEGER)
            .memberName("DurationSeconds").getter(getter(AssumeRoleRequest::durationSeconds))
            .setter(setter(Builder::durationSeconds))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("DurationSeconds").build()).build();

    private static final SdkField<List<Tag>> TAGS_FIELD = SdkField
            .<List<Tag>> builder(MarshallingType.LIST)
            .memberName("Tags")
            .getter(getter(AssumeRoleRequest::tags))
            .setter(setter(Builder::tags))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("Tags").build(),
                    ListTrait
                            .builder()
                            .memberLocationName(null)
                            .memberFieldInfo(
                                    SdkField.<Tag> builder(MarshallingType.SDK_POJO)
                                            .constructor(Tag::builder)
                                            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD)
                                                    .locationName("member").build()).build()).build()).build();

    private static final SdkField<List<String>> TRANSITIVE_TAG_KEYS_FIELD = SdkField
            .<List<String>> builder(MarshallingType.LIST)
            .memberName("TransitiveTagKeys")
            .getter(getter(AssumeRoleRequest::transitiveTagKeys))
            .setter(setter(Builder::transitiveTagKeys))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("TransitiveTagKeys").build(),
                    ListTrait
                            .builder()
                            .memberLocationName(null)
                            .memberFieldInfo(
                                    SdkField.<String> builder(MarshallingType.STRING)
                                            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD)
                                                    .locationName("member").build()).build()).build()).build();

    private static final SdkField<String> EXTERNAL_ID_FIELD = SdkField.<String> builder(MarshallingType.STRING)
            .memberName("ExternalId").getter(getter(AssumeRoleRequest::externalId)).setter(setter(Builder::externalId))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("ExternalId").build()).build();

    private static final SdkField<String> SERIAL_NUMBER_FIELD = SdkField.<String> builder(MarshallingType.STRING)
            .memberName("SerialNumber").getter(getter(AssumeRoleRequest::serialNumber)).setter(setter(Builder::serialNumber))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("SerialNumber").build()).build();

    private static final SdkField<String> TOKEN_CODE_FIELD = SdkField.<String> builder(MarshallingType.STRING)
            .memberName("TokenCode").getter(getter(AssumeRoleRequest::tokenCode)).setter(setter(Builder::tokenCode))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("TokenCode").build()).build();

    private static final SdkField<String> SOURCE_IDENTITY_FIELD = SdkField.<String> builder(MarshallingType.STRING)
            .memberName("SourceIdentity").getter(getter(AssumeRoleRequest::sourceIdentity))
            .setter(setter(Builder::sourceIdentity))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("SourceIdentity").build()).build();

    private static final SdkField<List<ProvidedContext>> PROVIDED_CONTEXTS_FIELD = SdkField
            .<List<ProvidedContext>> builder(MarshallingType.LIST)
            .memberName("ProvidedContexts")
            .getter(getter(AssumeRoleRequest::providedContexts))
            .setter(setter(Builder::providedContexts))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("ProvidedContexts").build(),
                    ListTrait
                            .builder()
                            .memberLocationName(null)
                            .memberFieldInfo(
                                    SdkField.<ProvidedContext> builder(MarshallingType.SDK_POJO)
                                            .constructor(ProvidedContext::builder)
                                            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD)
                                                    .locationName("member").build()).build()).build()).build();

    private static final List<SdkField<?>> SDK_FIELDS = Collections.unmodifiableList(Arrays.asList(ROLE_ARN_FIELD,
            ROLE_SESSION_NAME_FIELD, POLICY_ARNS_FIELD, POLICY_FIELD, DURATION_SECONDS_FIELD, TAGS_FIELD,
            TRANSITIVE_TAG_KEYS_FIELD, EXTERNAL_ID_FIELD, SERIAL_NUMBER_FIELD, TOKEN_CODE_FIELD, SOURCE_IDENTITY_FIELD,
            PROVIDED_CONTEXTS_FIELD));

    private static final Map<String, SdkField<?>> SDK_NAME_TO_FIELD = memberNameToFieldInitializer();

    private final String roleArn;

    private final String roleSessionName;

    private final List<PolicyDescriptorType> policyArns;

    private final String policy;

    private final Integer durationSeconds;

    private final List<Tag> tags;

    private final List<String> transitiveTagKeys;

    private final String externalId;

    private final String serialNumber;

    private final String tokenCode;

    private final String sourceIdentity;

    private final List<ProvidedContext> providedContexts;

    private AssumeRoleRequest(BuilderImpl builder) {
        super(builder);
        this.roleArn = builder.roleArn;
        this.roleSessionName = builder.roleSessionName;
        this.policyArns = builder.policyArns;
        this.policy = builder.policy;
        this.durationSeconds = builder.durationSeconds;
        this.tags = builder.tags;
        this.transitiveTagKeys = builder.transitiveTagKeys;
        this.externalId = builder.externalId;
        this.serialNumber = builder.serialNumber;
        this.tokenCode = builder.tokenCode;
        this.sourceIdentity = builder.sourceIdentity;
        this.providedContexts = builder.providedContexts;
    }

    /**
     * <p>
     * The Amazon Resource Name (ARN) of the role to assume.
     * </p>
     * 
     * @return The Amazon Resource Name (ARN) of the role to assume.
     */
    public final String roleArn() {
        return roleArn;
    }

    /**
     * <p>
     * An identifier for the assumed role session.
     * </p>
     * <p>
     * Use the role session name to uniquely identify a session when the same role is assumed by different principals or
     * for different reasons. In cross-account scenarios, the role session name is visible to, and can be logged by the
     * account that owns the role. The role session name is also used in the ARN of the assumed role principal. This
     * means that subsequent cross-account API requests that use the temporary security credentials will expose the role
     * session name to the external account in their CloudTrail logs.
     * </p>
     * <p>
     * For security purposes, administrators can view this field in <a href=
     * "https://docs.aws.amazon.com/IAM/latest/UserGuide/cloudtrail-integration.html#cloudtrail-integration_signin-tempcreds"
     * >CloudTrail logs</a> to help identify who performed an action in Amazon Web Services. Your administrator might
     * require that you specify your user name as the session name when you assume the role. For more information, see
     * <a href=
     * "https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_policies_iam-condition-keys.html#ck_rolesessionname">
     * <code>sts:RoleSessionName</code> </a>.
     * </p>
     * <p>
     * The regex used to validate this parameter is a string of characters consisting of upper- and lower-case
     * alphanumeric characters with no spaces. You can also include underscores or any of the following characters: =,.@-
     * </p>
     * 
     * @return An identifier for the assumed role session.</p>
     *         <p>
     *         Use the role session name to uniquely identify a session when the same role is assumed by different
     *         principals or for different reasons. In cross-account scenarios, the role session name is visible to, and
     *         can be logged by the account that owns the role. The role session name is also used in the ARN of the
     *         assumed role principal. This means that subsequent cross-account API requests that use the temporary
     *         security credentials will expose the role session name to the external account in their CloudTrail logs.
     *         </p>
     *         <p>
     *         For security purposes, administrators can view this field in <a href=
     *         "https://docs.aws.amazon.com/IAM/latest/UserGuide/cloudtrail-integration.html#cloudtrail-integration_signin-tempcreds"
     *         >CloudTrail logs</a> to help identify who performed an action in Amazon Web Services. Your administrator
     *         might require that you specify your user name as the session name when you assume the role. For more
     *         information, see <a href=
     *         "https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_policies_iam-condition-keys.html#ck_rolesessionname"
     *         > <code>sts:RoleSessionName</code> </a>.
     *         </p>
     *         <p>
     *         The regex used to validate this parameter is a string of characters consisting of upper- and lower-case
     *         alphanumeric characters with no spaces. You can also include underscores or any of the following
     *         characters: =,.@-
     */
    public final String roleSessionName() {
        return roleSessionName;
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
     * <note>
     * <p>
     * An Amazon Web Services conversion compresses the passed inline session policy, managed policy ARNs, and session
     * tags into a packed binary format that has a separate limit. Your request can fail for this limit even if your
     * plaintext meets the other requirements. The <code>PackedPolicySize</code> response element indicates by
     * percentage how close the policies and tags for your request are to the upper size limit.
     * </p>
     * </note>
     * <p>
     * For more information about role session permissions, see <a
     * href="https://docs.aws.amazon.com/IAM/latest/UserGuide/access_policies.html#policies_session">Session
     * policies</a>.
     * </p>
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
     *         <note>
     *         <p>
     *         An Amazon Web Services conversion compresses the passed inline session policy, managed policy ARNs, and
     *         session tags into a packed binary format that has a separate limit. Your request can fail for this limit
     *         even if your plaintext meets the other requirements. The <code>PackedPolicySize</code> response element
     *         indicates by percentage how close the policies and tags for your request are to the upper size limit.
     *         </p>
     *         </note>
     *         <p>
     *         For more information about role session permissions, see <a
     *         href="https://docs.aws.amazon.com/IAM/latest/UserGuide/access_policies.html#policies_session">Session
     *         policies</a>.
     */
    public final String policy() {
        return policy;
    }

    /**
     * <p>
     * The duration, in seconds, of the role session. The value specified can range from 900 seconds (15 minutes) up to
     * the maximum session duration set for the role. The maximum session duration setting can have a value from 1 hour
     * to 12 hours. If you specify a value higher than this setting or the administrator setting (whichever is lower),
     * the operation fails. For example, if you specify a session duration of 12 hours, but your administrator set the
     * maximum session duration to 6 hours, your operation fails.
     * </p>
     * <p>
     * Role chaining limits your Amazon Web Services CLI or Amazon Web Services API role session to a maximum of one
     * hour. When you use the <code>AssumeRole</code> API operation to assume a role, you can specify the duration of
     * your role session with the <code>DurationSeconds</code> parameter. You can specify a parameter value of up to
     * 43200 seconds (12 hours), depending on the maximum session duration setting for your role. However, if you assume
     * a role using role chaining and provide a <code>DurationSeconds</code> parameter value greater than one hour, the
     * operation fails. To learn how to view the maximum value for your role, see <a href=
     * "https://docs.aws.amazon.com/IAM/latest/UserGuide/id_roles_update-role-settings.html#id_roles_update-session-duration"
     * >Update the maximum session duration for a role</a>.
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
     * @return The duration, in seconds, of the role session. The value specified can range from 900 seconds (15
     *         minutes) up to the maximum session duration set for the role. The maximum session duration setting can
     *         have a value from 1 hour to 12 hours. If you specify a value higher than this setting or the
     *         administrator setting (whichever is lower), the operation fails. For example, if you specify a session
     *         duration of 12 hours, but your administrator set the maximum session duration to 6 hours, your operation
     *         fails. </p>
     *         <p>
     *         Role chaining limits your Amazon Web Services CLI or Amazon Web Services API role session to a maximum of
     *         one hour. When you use the <code>AssumeRole</code> API operation to assume a role, you can specify the
     *         duration of your role session with the <code>DurationSeconds</code> parameter. You can specify a
     *         parameter value of up to 43200 seconds (12 hours), depending on the maximum session duration setting for
     *         your role. However, if you assume a role using role chaining and provide a <code>DurationSeconds</code>
     *         parameter value greater than one hour, the operation fails. To learn how to view the maximum value for
     *         your role, see <a href=
     *         "https://docs.aws.amazon.com/IAM/latest/UserGuide/id_roles_update-role-settings.html#id_roles_update-session-duration"
     *         >Update the maximum session duration for a role</a>.
     *         </p>
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

    /**
     * For responses, this returns true if the service returned a value for the Tags property. This DOES NOT check that
     * the value is non-empty (for which, you should check the {@code isEmpty()} method on the property). This is useful
     * because the SDK will never return a null collection or map, but you may need to differentiate between the service
     * returning nothing (or null) and the service returning an empty collection or map. For requests, this returns true
     * if a value for the property was specified in the request builder, and false if a value was not specified.
     */
    public final boolean hasTags() {
        return tags != null && !(tags instanceof SdkAutoConstructList);
    }

    /**
     * <p>
     * A list of session tags that you want to pass. Each session tag consists of a key name and an associated value.
     * For more information about session tags, see <a
     * href="https://docs.aws.amazon.com/IAM/latest/UserGuide/id_session-tags.html">Tagging Amazon Web Services STS
     * Sessions</a> in the <i>IAM User Guide</i>.
     * </p>
     * <p>
     * This parameter is optional. You can pass up to 50 session tags. The plaintext session tag keys can’t exceed 128
     * characters, and the values can’t exceed 256 characters. For these and additional limits, see <a href=
     * "https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_iam-limits.html#reference_iam-limits-entity-length"
     * >IAM and STS Character Limits</a> in the <i>IAM User Guide</i>.
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
     * You can pass a session tag with the same key as a tag that is already attached to the role. When you do, session
     * tags override a role tag with the same key.
     * </p>
     * <p>
     * Tag key–value pairs are not case sensitive, but case is preserved. This means that you cannot have separate
     * <code>Department</code> and <code>department</code> tag keys. Assume that the role has the
     * <code>Department</code>=<code>Marketing</code> tag and you pass the <code>department</code>=
     * <code>engineering</code> session tag. <code>Department</code> and <code>department</code> are not saved as
     * separate tags, and the session tag passed in the request takes precedence over the role tag.
     * </p>
     * <p>
     * Additionally, if you used temporary credentials to perform this operation, the new session inherits any
     * transitive session tags from the calling session. If you pass a session tag with the same key as an inherited
     * tag, the operation fails. To view the inherited tags for a session, see the CloudTrail logs. For more
     * information, see <a
     * href="https://docs.aws.amazon.com/IAM/latest/UserGuide/id_session-tags.html#id_session-tags_ctlogs">Viewing
     * Session Tags in CloudTrail</a> in the <i>IAM User Guide</i>.
     * </p>
     * <p>
     * Attempts to modify the collection returned by this method will result in an UnsupportedOperationException.
     * </p>
     * <p>
     * This method will never return null. If you would like to know whether the service returned this field (so that
     * you can differentiate between null and empty), you can use the {@link #hasTags} method.
     * </p>
     * 
     * @return A list of session tags that you want to pass. Each session tag consists of a key name and an associated
     *         value. For more information about session tags, see <a
     *         href="https://docs.aws.amazon.com/IAM/latest/UserGuide/id_session-tags.html">Tagging Amazon Web Services
     *         STS Sessions</a> in the <i>IAM User Guide</i>.</p>
     *         <p>
     *         This parameter is optional. You can pass up to 50 session tags. The plaintext session tag keys can’t
     *         exceed 128 characters, and the values can’t exceed 256 characters. For these and additional limits, see
     *         <a href=
     *         "https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_iam-limits.html#reference_iam-limits-entity-length"
     *         >IAM and STS Character Limits</a> in the <i>IAM User Guide</i>.
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
     *         You can pass a session tag with the same key as a tag that is already attached to the role. When you do,
     *         session tags override a role tag with the same key.
     *         </p>
     *         <p>
     *         Tag key–value pairs are not case sensitive, but case is preserved. This means that you cannot have
     *         separate <code>Department</code> and <code>department</code> tag keys. Assume that the role has the
     *         <code>Department</code>=<code>Marketing</code> tag and you pass the <code>department</code>=
     *         <code>engineering</code> session tag. <code>Department</code> and <code>department</code> are not saved
     *         as separate tags, and the session tag passed in the request takes precedence over the role tag.
     *         </p>
     *         <p>
     *         Additionally, if you used temporary credentials to perform this operation, the new session inherits any
     *         transitive session tags from the calling session. If you pass a session tag with the same key as an
     *         inherited tag, the operation fails. To view the inherited tags for a session, see the CloudTrail logs.
     *         For more information, see <a
     *         href="https://docs.aws.amazon.com/IAM/latest/UserGuide/id_session-tags.html#id_session-tags_ctlogs"
     *         >Viewing Session Tags in CloudTrail</a> in the <i>IAM User Guide</i>.
     */
    public final List<Tag> tags() {
        return tags;
    }

    /**
     * For responses, this returns true if the service returned a value for the TransitiveTagKeys property. This DOES
     * NOT check that the value is non-empty (for which, you should check the {@code isEmpty()} method on the property).
     * This is useful because the SDK will never return a null collection or map, but you may need to differentiate
     * between the service returning nothing (or null) and the service returning an empty collection or map. For
     * requests, this returns true if a value for the property was specified in the request builder, and false if a
     * value was not specified.
     */
    public final boolean hasTransitiveTagKeys() {
        return transitiveTagKeys != null && !(transitiveTagKeys instanceof SdkAutoConstructList);
    }

    /**
     * <p>
     * A list of keys for session tags that you want to set as transitive. If you set a tag key as transitive, the
     * corresponding key and value passes to subsequent sessions in a role chain. For more information, see <a
     * href="https://docs.aws.amazon.com/IAM/latest/UserGuide/id_session-tags.html#id_session-tags_role-chaining"
     * >Chaining Roles with Session Tags</a> in the <i>IAM User Guide</i>.
     * </p>
     * <p>
     * This parameter is optional. The transitive status of a session tag does not impact its packed binary size.
     * </p>
     * <p>
     * If you choose not to specify a transitive tag key, then no tags are passed from this session to any subsequent
     * sessions.
     * </p>
     * <p>
     * Attempts to modify the collection returned by this method will result in an UnsupportedOperationException.
     * </p>
     * <p>
     * This method will never return null. If you would like to know whether the service returned this field (so that
     * you can differentiate between null and empty), you can use the {@link #hasTransitiveTagKeys} method.
     * </p>
     * 
     * @return A list of keys for session tags that you want to set as transitive. If you set a tag key as transitive,
     *         the corresponding key and value passes to subsequent sessions in a role chain. For more information, see
     *         <a href=
     *         "https://docs.aws.amazon.com/IAM/latest/UserGuide/id_session-tags.html#id_session-tags_role-chaining"
     *         >Chaining Roles with Session Tags</a> in the <i>IAM User Guide</i>.</p>
     *         <p>
     *         This parameter is optional. The transitive status of a session tag does not impact its packed binary
     *         size.
     *         </p>
     *         <p>
     *         If you choose not to specify a transitive tag key, then no tags are passed from this session to any
     *         subsequent sessions.
     */
    public final List<String> transitiveTagKeys() {
        return transitiveTagKeys;
    }

    /**
     * <p>
     * A unique identifier that might be required when you assume a role in another account. If the administrator of the
     * account to which the role belongs provided you with an external ID, then provide that value in the
     * <code>ExternalId</code> parameter. This value can be any string, such as a passphrase or account number. A
     * cross-account role is usually set up to trust everyone in an account. Therefore, the administrator of the
     * trusting account might send an external ID to the administrator of the trusted account. That way, only someone
     * with the ID can assume the role, rather than everyone in the account. For more information about the external ID,
     * see <a href="https://docs.aws.amazon.com/IAM/latest/UserGuide/id_roles_create_for-user_externalid.html">How to
     * Use an External ID When Granting Access to Your Amazon Web Services Resources to a Third Party</a> in the <i>IAM
     * User Guide</i>.
     * </p>
     * <p>
     * The regex used to validate this parameter is a string of characters consisting of upper- and lower-case
     * alphanumeric characters with no spaces. You can also include underscores or any of the following characters:
     * =,.@:/-
     * </p>
     * 
     * @return A unique identifier that might be required when you assume a role in another account. If the
     *         administrator of the account to which the role belongs provided you with an external ID, then provide
     *         that value in the <code>ExternalId</code> parameter. This value can be any string, such as a passphrase
     *         or account number. A cross-account role is usually set up to trust everyone in an account. Therefore, the
     *         administrator of the trusting account might send an external ID to the administrator of the trusted
     *         account. That way, only someone with the ID can assume the role, rather than everyone in the account. For
     *         more information about the external ID, see <a
     *         href="https://docs.aws.amazon.com/IAM/latest/UserGuide/id_roles_create_for-user_externalid.html">How to
     *         Use an External ID When Granting Access to Your Amazon Web Services Resources to a Third Party</a> in the
     *         <i>IAM User Guide</i>.</p>
     *         <p>
     *         The regex used to validate this parameter is a string of characters consisting of upper- and lower-case
     *         alphanumeric characters with no spaces. You can also include underscores or any of the following
     *         characters: =,.@:/-
     */
    public final String externalId() {
        return externalId;
    }

    /**
     * <p>
     * The identification number of the MFA device that is associated with the user who is making the
     * <code>AssumeRole</code> call. Specify this value if the trust policy of the role being assumed includes a
     * condition that requires MFA authentication. The value is either the serial number for a hardware device (such as
     * <code>GAHT12345678</code>) or an Amazon Resource Name (ARN) for a virtual device (such as
     * <code>arn:aws:iam::123456789012:mfa/user</code>).
     * </p>
     * <p>
     * The regex used to validate this parameter is a string of characters consisting of upper- and lower-case
     * alphanumeric characters with no spaces. You can also include underscores or any of the following characters: =,.@-
     * </p>
     * 
     * @return The identification number of the MFA device that is associated with the user who is making the
     *         <code>AssumeRole</code> call. Specify this value if the trust policy of the role being assumed includes a
     *         condition that requires MFA authentication. The value is either the serial number for a hardware device
     *         (such as <code>GAHT12345678</code>) or an Amazon Resource Name (ARN) for a virtual device (such as
     *         <code>arn:aws:iam::123456789012:mfa/user</code>).</p>
     *         <p>
     *         The regex used to validate this parameter is a string of characters consisting of upper- and lower-case
     *         alphanumeric characters with no spaces. You can also include underscores or any of the following
     *         characters: =,.@-
     */
    public final String serialNumber() {
        return serialNumber;
    }

    /**
     * <p>
     * The value provided by the MFA device, if the trust policy of the role being assumed requires MFA. (In other
     * words, if the policy includes a condition that tests for MFA). If the role being assumed requires MFA and if the
     * <code>TokenCode</code> value is missing or expired, the <code>AssumeRole</code> call returns an "access denied"
     * error.
     * </p>
     * <p>
     * The format for this parameter, as described by its regex pattern, is a sequence of six numeric digits.
     * </p>
     * 
     * @return The value provided by the MFA device, if the trust policy of the role being assumed requires MFA. (In
     *         other words, if the policy includes a condition that tests for MFA). If the role being assumed requires
     *         MFA and if the <code>TokenCode</code> value is missing or expired, the <code>AssumeRole</code> call
     *         returns an "access denied" error.</p>
     *         <p>
     *         The format for this parameter, as described by its regex pattern, is a sequence of six numeric digits.
     */
    public final String tokenCode() {
        return tokenCode;
    }

    /**
     * <p>
     * The source identity specified by the principal that is calling the <code>AssumeRole</code> operation. The source
     * identity value persists across <a
     * href="https://docs.aws.amazon.com/IAM/latest/UserGuide/id_roles.html#iam-term-role-chaining">chained role</a>
     * sessions.
     * </p>
     * <p>
     * You can require users to specify a source identity when they assume a role. You do this by using the <a href=
     * "https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_policies_condition-keys.html#condition-keys-sourceidentity"
     * > <code>sts:SourceIdentity</code> </a> condition key in a role trust policy. You can use source identity
     * information in CloudTrail logs to determine who took actions with a role. You can use the
     * <code>aws:SourceIdentity</code> condition key to further control access to Amazon Web Services resources based on
     * the value of source identity. For more information about using source identity, see <a
     * href="https://docs.aws.amazon.com/IAM/latest/UserGuide/id_credentials_temp_control-access_monitor.html">Monitor
     * and control actions taken with assumed roles</a> in the <i>IAM User Guide</i>.
     * </p>
     * <p>
     * The regex used to validate this parameter is a string of characters consisting of upper- and lower-case
     * alphanumeric characters with no spaces. You can also include underscores or any of the following characters:
     * +=,.@-. You cannot use a value that begins with the text <code>aws:</code>. This prefix is reserved for Amazon
     * Web Services internal use.
     * </p>
     * 
     * @return The source identity specified by the principal that is calling the <code>AssumeRole</code> operation. The
     *         source identity value persists across <a
     *         href="https://docs.aws.amazon.com/IAM/latest/UserGuide/id_roles.html#iam-term-role-chaining">chained
     *         role</a> sessions.</p>
     *         <p>
     *         You can require users to specify a source identity when they assume a role. You do this by using the <a
     *         href=
     *         "https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_policies_condition-keys.html#condition-keys-sourceidentity"
     *         > <code>sts:SourceIdentity</code> </a> condition key in a role trust policy. You can use source identity
     *         information in CloudTrail logs to determine who took actions with a role. You can use the
     *         <code>aws:SourceIdentity</code> condition key to further control access to Amazon Web Services resources
     *         based on the value of source identity. For more information about using source identity, see <a
     *         href="https://docs.aws.amazon.com/IAM/latest/UserGuide/id_credentials_temp_control-access_monitor.html"
     *         >Monitor and control actions taken with assumed roles</a> in the <i>IAM User Guide</i>.
     *         </p>
     *         <p>
     *         The regex used to validate this parameter is a string of characters consisting of upper- and lower-case
     *         alphanumeric characters with no spaces. You can also include underscores or any of the following
     *         characters: +=,.@-. You cannot use a value that begins with the text <code>aws:</code>. This prefix is
     *         reserved for Amazon Web Services internal use.
     */
    public final String sourceIdentity() {
        return sourceIdentity;
    }

    /**
     * For responses, this returns true if the service returned a value for the ProvidedContexts property. This DOES NOT
     * check that the value is non-empty (for which, you should check the {@code isEmpty()} method on the property).
     * This is useful because the SDK will never return a null collection or map, but you may need to differentiate
     * between the service returning nothing (or null) and the service returning an empty collection or map. For
     * requests, this returns true if a value for the property was specified in the request builder, and false if a
     * value was not specified.
     */
    public final boolean hasProvidedContexts() {
        return providedContexts != null && !(providedContexts instanceof SdkAutoConstructList);
    }

    /**
     * <p>
     * A list of previously acquired trusted context assertions in the format of a JSON array. The trusted context
     * assertion is signed and encrypted by Amazon Web Services STS.
     * </p>
     * <p>
     * The following is an example of a <code>ProvidedContext</code> value that includes a single trusted context
     * assertion and the ARN of the context provider from which the trusted context assertion was generated.
     * </p>
     * <p>
     * <code>[{"ProviderArn":"arn:aws:iam::aws:contextProvider/IdentityCenter","ContextAssertion":"trusted-context-assertion"}]</code>
     * </p>
     * <p>
     * Attempts to modify the collection returned by this method will result in an UnsupportedOperationException.
     * </p>
     * <p>
     * This method will never return null. If you would like to know whether the service returned this field (so that
     * you can differentiate between null and empty), you can use the {@link #hasProvidedContexts} method.
     * </p>
     * 
     * @return A list of previously acquired trusted context assertions in the format of a JSON array. The trusted
     *         context assertion is signed and encrypted by Amazon Web Services STS.</p>
     *         <p>
     *         The following is an example of a <code>ProvidedContext</code> value that includes a single trusted
     *         context assertion and the ARN of the context provider from which the trusted context assertion was
     *         generated.
     *         </p>
     *         <p>
     *         <code>[{"ProviderArn":"arn:aws:iam::aws:contextProvider/IdentityCenter","ContextAssertion":"trusted-context-assertion"}]</code>
     */
    public final List<ProvidedContext> providedContexts() {
        return providedContexts;
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
        hashCode = 31 * hashCode + Objects.hashCode(roleSessionName());
        hashCode = 31 * hashCode + Objects.hashCode(hasPolicyArns() ? policyArns() : null);
        hashCode = 31 * hashCode + Objects.hashCode(policy());
        hashCode = 31 * hashCode + Objects.hashCode(durationSeconds());
        hashCode = 31 * hashCode + Objects.hashCode(hasTags() ? tags() : null);
        hashCode = 31 * hashCode + Objects.hashCode(hasTransitiveTagKeys() ? transitiveTagKeys() : null);
        hashCode = 31 * hashCode + Objects.hashCode(externalId());
        hashCode = 31 * hashCode + Objects.hashCode(serialNumber());
        hashCode = 31 * hashCode + Objects.hashCode(tokenCode());
        hashCode = 31 * hashCode + Objects.hashCode(sourceIdentity());
        hashCode = 31 * hashCode + Objects.hashCode(hasProvidedContexts() ? providedContexts() : null);
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
        if (!(obj instanceof AssumeRoleRequest)) {
            return false;
        }
        AssumeRoleRequest other = (AssumeRoleRequest) obj;
        return Objects.equals(roleArn(), other.roleArn()) && Objects.equals(roleSessionName(), other.roleSessionName())
                && hasPolicyArns() == other.hasPolicyArns() && Objects.equals(policyArns(), other.policyArns())
                && Objects.equals(policy(), other.policy()) && Objects.equals(durationSeconds(), other.durationSeconds())
                && hasTags() == other.hasTags() && Objects.equals(tags(), other.tags())
                && hasTransitiveTagKeys() == other.hasTransitiveTagKeys()
                && Objects.equals(transitiveTagKeys(), other.transitiveTagKeys())
                && Objects.equals(externalId(), other.externalId()) && Objects.equals(serialNumber(), other.serialNumber())
                && Objects.equals(tokenCode(), other.tokenCode()) && Objects.equals(sourceIdentity(), other.sourceIdentity())
                && hasProvidedContexts() == other.hasProvidedContexts()
                && Objects.equals(providedContexts(), other.providedContexts());
    }

    /**
     * Returns a string representation of this object. This is useful for testing and debugging. Sensitive data will be
     * redacted from this string using a placeholder value.
     */
    @Override
    public final String toString() {
        return ToString.builder("AssumeRoleRequest").add("RoleArn", roleArn()).add("RoleSessionName", roleSessionName())
                .add("PolicyArns", hasPolicyArns() ? policyArns() : null).add("Policy", policy())
                .add("DurationSeconds", durationSeconds()).add("Tags", hasTags() ? tags() : null)
                .add("TransitiveTagKeys", hasTransitiveTagKeys() ? transitiveTagKeys() : null).add("ExternalId", externalId())
                .add("SerialNumber", serialNumber()).add("TokenCode", tokenCode()).add("SourceIdentity", sourceIdentity())
                .add("ProvidedContexts", hasProvidedContexts() ? providedContexts() : null).build();
    }

    public final <T> Optional<T> getValueForField(String fieldName, Class<T> clazz) {
        switch (fieldName) {
        case "RoleArn":
            return Optional.ofNullable(clazz.cast(roleArn()));
        case "RoleSessionName":
            return Optional.ofNullable(clazz.cast(roleSessionName()));
        case "PolicyArns":
            return Optional.ofNullable(clazz.cast(policyArns()));
        case "Policy":
            return Optional.ofNullable(clazz.cast(policy()));
        case "DurationSeconds":
            return Optional.ofNullable(clazz.cast(durationSeconds()));
        case "Tags":
            return Optional.ofNullable(clazz.cast(tags()));
        case "TransitiveTagKeys":
            return Optional.ofNullable(clazz.cast(transitiveTagKeys()));
        case "ExternalId":
            return Optional.ofNullable(clazz.cast(externalId()));
        case "SerialNumber":
            return Optional.ofNullable(clazz.cast(serialNumber()));
        case "TokenCode":
            return Optional.ofNullable(clazz.cast(tokenCode()));
        case "SourceIdentity":
            return Optional.ofNullable(clazz.cast(sourceIdentity()));
        case "ProvidedContexts":
            return Optional.ofNullable(clazz.cast(providedContexts()));
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
        map.put("RoleSessionName", ROLE_SESSION_NAME_FIELD);
        map.put("PolicyArns", POLICY_ARNS_FIELD);
        map.put("Policy", POLICY_FIELD);
        map.put("DurationSeconds", DURATION_SECONDS_FIELD);
        map.put("Tags", TAGS_FIELD);
        map.put("TransitiveTagKeys", TRANSITIVE_TAG_KEYS_FIELD);
        map.put("ExternalId", EXTERNAL_ID_FIELD);
        map.put("SerialNumber", SERIAL_NUMBER_FIELD);
        map.put("TokenCode", TOKEN_CODE_FIELD);
        map.put("SourceIdentity", SOURCE_IDENTITY_FIELD);
        map.put("ProvidedContexts", PROVIDED_CONTEXTS_FIELD);
        return Collections.unmodifiableMap(map);
    }

    private static <T> Function<Object, T> getter(Function<AssumeRoleRequest, T> g) {
        return obj -> g.apply((AssumeRoleRequest) obj);
    }

    private static <T> BiConsumer<Object, T> setter(BiConsumer<Builder, T> s) {
        return (obj, val) -> s.accept((Builder) obj, val);
    }

    @Mutable
    @NotThreadSafe
    public interface Builder extends StsRequest.Builder, SdkPojo, CopyableBuilder<Builder, AssumeRoleRequest> {
        /**
         * <p>
         * The Amazon Resource Name (ARN) of the role to assume.
         * </p>
         * 
         * @param roleArn
         *        The Amazon Resource Name (ARN) of the role to assume.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder roleArn(String roleArn);

        /**
         * <p>
         * An identifier for the assumed role session.
         * </p>
         * <p>
         * Use the role session name to uniquely identify a session when the same role is assumed by different
         * principals or for different reasons. In cross-account scenarios, the role session name is visible to, and can
         * be logged by the account that owns the role. The role session name is also used in the ARN of the assumed
         * role principal. This means that subsequent cross-account API requests that use the temporary security
         * credentials will expose the role session name to the external account in their CloudTrail logs.
         * </p>
         * <p>
         * For security purposes, administrators can view this field in <a href=
         * "https://docs.aws.amazon.com/IAM/latest/UserGuide/cloudtrail-integration.html#cloudtrail-integration_signin-tempcreds"
         * >CloudTrail logs</a> to help identify who performed an action in Amazon Web Services. Your administrator
         * might require that you specify your user name as the session name when you assume the role. For more
         * information, see <a href=
         * "https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_policies_iam-condition-keys.html#ck_rolesessionname"
         * > <code>sts:RoleSessionName</code> </a>.
         * </p>
         * <p>
         * The regex used to validate this parameter is a string of characters consisting of upper- and lower-case
         * alphanumeric characters with no spaces. You can also include underscores or any of the following characters:
         * =,.@-
         * </p>
         * 
         * @param roleSessionName
         *        An identifier for the assumed role session.</p>
         *        <p>
         *        Use the role session name to uniquely identify a session when the same role is assumed by different
         *        principals or for different reasons. In cross-account scenarios, the role session name is visible to,
         *        and can be logged by the account that owns the role. The role session name is also used in the ARN of
         *        the assumed role principal. This means that subsequent cross-account API requests that use the
         *        temporary security credentials will expose the role session name to the external account in their
         *        CloudTrail logs.
         *        </p>
         *        <p>
         *        For security purposes, administrators can view this field in <a href=
         *        "https://docs.aws.amazon.com/IAM/latest/UserGuide/cloudtrail-integration.html#cloudtrail-integration_signin-tempcreds"
         *        >CloudTrail logs</a> to help identify who performed an action in Amazon Web Services. Your
         *        administrator might require that you specify your user name as the session name when you assume the
         *        role. For more information, see <a href=
         *        "https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_policies_iam-condition-keys.html#ck_rolesessionname"
         *        > <code>sts:RoleSessionName</code> </a>.
         *        </p>
         *        <p>
         *        The regex used to validate this parameter is a string of characters consisting of upper- and
         *        lower-case alphanumeric characters with no spaces. You can also include underscores or any of the
         *        following characters: =,.@-
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder roleSessionName(String roleSessionName);

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
         * <note>
         * <p>
         * An Amazon Web Services conversion compresses the passed inline session policy, managed policy ARNs, and
         * session tags into a packed binary format that has a separate limit. Your request can fail for this limit even
         * if your plaintext meets the other requirements. The <code>PackedPolicySize</code> response element indicates
         * by percentage how close the policies and tags for your request are to the upper size limit.
         * </p>
         * </note>
         * <p>
         * For more information about role session permissions, see <a
         * href="https://docs.aws.amazon.com/IAM/latest/UserGuide/access_policies.html#policies_session">Session
         * policies</a>.
         * </p>
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
         *        For more information about role session permissions, see <a
         *        href="https://docs.aws.amazon.com/IAM/latest/UserGuide/access_policies.html#policies_session">Session
         *        policies</a>.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder policy(String policy);

        /**
         * <p>
         * The duration, in seconds, of the role session. The value specified can range from 900 seconds (15 minutes) up
         * to the maximum session duration set for the role. The maximum session duration setting can have a value from
         * 1 hour to 12 hours. If you specify a value higher than this setting or the administrator setting (whichever
         * is lower), the operation fails. For example, if you specify a session duration of 12 hours, but your
         * administrator set the maximum session duration to 6 hours, your operation fails.
         * </p>
         * <p>
         * Role chaining limits your Amazon Web Services CLI or Amazon Web Services API role session to a maximum of one
         * hour. When you use the <code>AssumeRole</code> API operation to assume a role, you can specify the duration
         * of your role session with the <code>DurationSeconds</code> parameter. You can specify a parameter value of up
         * to 43200 seconds (12 hours), depending on the maximum session duration setting for your role. However, if you
         * assume a role using role chaining and provide a <code>DurationSeconds</code> parameter value greater than one
         * hour, the operation fails. To learn how to view the maximum value for your role, see <a href=
         * "https://docs.aws.amazon.com/IAM/latest/UserGuide/id_roles_update-role-settings.html#id_roles_update-session-duration"
         * >Update the maximum session duration for a role</a>.
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
         *        The duration, in seconds, of the role session. The value specified can range from 900 seconds (15
         *        minutes) up to the maximum session duration set for the role. The maximum session duration setting can
         *        have a value from 1 hour to 12 hours. If you specify a value higher than this setting or the
         *        administrator setting (whichever is lower), the operation fails. For example, if you specify a session
         *        duration of 12 hours, but your administrator set the maximum session duration to 6 hours, your
         *        operation fails. </p>
         *        <p>
         *        Role chaining limits your Amazon Web Services CLI or Amazon Web Services API role session to a maximum
         *        of one hour. When you use the <code>AssumeRole</code> API operation to assume a role, you can specify
         *        the duration of your role session with the <code>DurationSeconds</code> parameter. You can specify a
         *        parameter value of up to 43200 seconds (12 hours), depending on the maximum session duration setting
         *        for your role. However, if you assume a role using role chaining and provide a
         *        <code>DurationSeconds</code> parameter value greater than one hour, the operation fails. To learn how
         *        to view the maximum value for your role, see <a href=
         *        "https://docs.aws.amazon.com/IAM/latest/UserGuide/id_roles_update-role-settings.html#id_roles_update-session-duration"
         *        >Update the maximum session duration for a role</a>.
         *        </p>
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

        /**
         * <p>
         * A list of session tags that you want to pass. Each session tag consists of a key name and an associated
         * value. For more information about session tags, see <a
         * href="https://docs.aws.amazon.com/IAM/latest/UserGuide/id_session-tags.html">Tagging Amazon Web Services STS
         * Sessions</a> in the <i>IAM User Guide</i>.
         * </p>
         * <p>
         * This parameter is optional. You can pass up to 50 session tags. The plaintext session tag keys can’t exceed
         * 128 characters, and the values can’t exceed 256 characters. For these and additional limits, see <a href=
         * "https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_iam-limits.html#reference_iam-limits-entity-length"
         * >IAM and STS Character Limits</a> in the <i>IAM User Guide</i>.
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
         * You can pass a session tag with the same key as a tag that is already attached to the role. When you do,
         * session tags override a role tag with the same key.
         * </p>
         * <p>
         * Tag key–value pairs are not case sensitive, but case is preserved. This means that you cannot have separate
         * <code>Department</code> and <code>department</code> tag keys. Assume that the role has the
         * <code>Department</code>=<code>Marketing</code> tag and you pass the <code>department</code>=
         * <code>engineering</code> session tag. <code>Department</code> and <code>department</code> are not saved as
         * separate tags, and the session tag passed in the request takes precedence over the role tag.
         * </p>
         * <p>
         * Additionally, if you used temporary credentials to perform this operation, the new session inherits any
         * transitive session tags from the calling session. If you pass a session tag with the same key as an inherited
         * tag, the operation fails. To view the inherited tags for a session, see the CloudTrail logs. For more
         * information, see <a
         * href="https://docs.aws.amazon.com/IAM/latest/UserGuide/id_session-tags.html#id_session-tags_ctlogs">Viewing
         * Session Tags in CloudTrail</a> in the <i>IAM User Guide</i>.
         * </p>
         * 
         * @param tags
         *        A list of session tags that you want to pass. Each session tag consists of a key name and an
         *        associated value. For more information about session tags, see <a
         *        href="https://docs.aws.amazon.com/IAM/latest/UserGuide/id_session-tags.html">Tagging Amazon Web
         *        Services STS Sessions</a> in the <i>IAM User Guide</i>.</p>
         *        <p>
         *        This parameter is optional. You can pass up to 50 session tags. The plaintext session tag keys can’t
         *        exceed 128 characters, and the values can’t exceed 256 characters. For these and additional limits,
         *        see <a href=
         *        "https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_iam-limits.html#reference_iam-limits-entity-length"
         *        >IAM and STS Character Limits</a> in the <i>IAM User Guide</i>.
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
         *        You can pass a session tag with the same key as a tag that is already attached to the role. When you
         *        do, session tags override a role tag with the same key.
         *        </p>
         *        <p>
         *        Tag key–value pairs are not case sensitive, but case is preserved. This means that you cannot have
         *        separate <code>Department</code> and <code>department</code> tag keys. Assume that the role has the
         *        <code>Department</code>=<code>Marketing</code> tag and you pass the <code>department</code>=
         *        <code>engineering</code> session tag. <code>Department</code> and <code>department</code> are not
         *        saved as separate tags, and the session tag passed in the request takes precedence over the role tag.
         *        </p>
         *        <p>
         *        Additionally, if you used temporary credentials to perform this operation, the new session inherits
         *        any transitive session tags from the calling session. If you pass a session tag with the same key as
         *        an inherited tag, the operation fails. To view the inherited tags for a session, see the CloudTrail
         *        logs. For more information, see <a
         *        href="https://docs.aws.amazon.com/IAM/latest/UserGuide/id_session-tags.html#id_session-tags_ctlogs"
         *        >Viewing Session Tags in CloudTrail</a> in the <i>IAM User Guide</i>.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder tags(Collection<Tag> tags);

        /**
         * <p>
         * A list of session tags that you want to pass. Each session tag consists of a key name and an associated
         * value. For more information about session tags, see <a
         * href="https://docs.aws.amazon.com/IAM/latest/UserGuide/id_session-tags.html">Tagging Amazon Web Services STS
         * Sessions</a> in the <i>IAM User Guide</i>.
         * </p>
         * <p>
         * This parameter is optional. You can pass up to 50 session tags. The plaintext session tag keys can’t exceed
         * 128 characters, and the values can’t exceed 256 characters. For these and additional limits, see <a href=
         * "https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_iam-limits.html#reference_iam-limits-entity-length"
         * >IAM and STS Character Limits</a> in the <i>IAM User Guide</i>.
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
         * You can pass a session tag with the same key as a tag that is already attached to the role. When you do,
         * session tags override a role tag with the same key.
         * </p>
         * <p>
         * Tag key–value pairs are not case sensitive, but case is preserved. This means that you cannot have separate
         * <code>Department</code> and <code>department</code> tag keys. Assume that the role has the
         * <code>Department</code>=<code>Marketing</code> tag and you pass the <code>department</code>=
         * <code>engineering</code> session tag. <code>Department</code> and <code>department</code> are not saved as
         * separate tags, and the session tag passed in the request takes precedence over the role tag.
         * </p>
         * <p>
         * Additionally, if you used temporary credentials to perform this operation, the new session inherits any
         * transitive session tags from the calling session. If you pass a session tag with the same key as an inherited
         * tag, the operation fails. To view the inherited tags for a session, see the CloudTrail logs. For more
         * information, see <a
         * href="https://docs.aws.amazon.com/IAM/latest/UserGuide/id_session-tags.html#id_session-tags_ctlogs">Viewing
         * Session Tags in CloudTrail</a> in the <i>IAM User Guide</i>.
         * </p>
         * 
         * @param tags
         *        A list of session tags that you want to pass. Each session tag consists of a key name and an
         *        associated value. For more information about session tags, see <a
         *        href="https://docs.aws.amazon.com/IAM/latest/UserGuide/id_session-tags.html">Tagging Amazon Web
         *        Services STS Sessions</a> in the <i>IAM User Guide</i>.</p>
         *        <p>
         *        This parameter is optional. You can pass up to 50 session tags. The plaintext session tag keys can’t
         *        exceed 128 characters, and the values can’t exceed 256 characters. For these and additional limits,
         *        see <a href=
         *        "https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_iam-limits.html#reference_iam-limits-entity-length"
         *        >IAM and STS Character Limits</a> in the <i>IAM User Guide</i>.
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
         *        You can pass a session tag with the same key as a tag that is already attached to the role. When you
         *        do, session tags override a role tag with the same key.
         *        </p>
         *        <p>
         *        Tag key–value pairs are not case sensitive, but case is preserved. This means that you cannot have
         *        separate <code>Department</code> and <code>department</code> tag keys. Assume that the role has the
         *        <code>Department</code>=<code>Marketing</code> tag and you pass the <code>department</code>=
         *        <code>engineering</code> session tag. <code>Department</code> and <code>department</code> are not
         *        saved as separate tags, and the session tag passed in the request takes precedence over the role tag.
         *        </p>
         *        <p>
         *        Additionally, if you used temporary credentials to perform this operation, the new session inherits
         *        any transitive session tags from the calling session. If you pass a session tag with the same key as
         *        an inherited tag, the operation fails. To view the inherited tags for a session, see the CloudTrail
         *        logs. For more information, see <a
         *        href="https://docs.aws.amazon.com/IAM/latest/UserGuide/id_session-tags.html#id_session-tags_ctlogs"
         *        >Viewing Session Tags in CloudTrail</a> in the <i>IAM User Guide</i>.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder tags(Tag... tags);

        /**
         * <p>
         * A list of session tags that you want to pass. Each session tag consists of a key name and an associated
         * value. For more information about session tags, see <a
         * href="https://docs.aws.amazon.com/IAM/latest/UserGuide/id_session-tags.html">Tagging Amazon Web Services STS
         * Sessions</a> in the <i>IAM User Guide</i>.
         * </p>
         * <p>
         * This parameter is optional. You can pass up to 50 session tags. The plaintext session tag keys can’t exceed
         * 128 characters, and the values can’t exceed 256 characters. For these and additional limits, see <a href=
         * "https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_iam-limits.html#reference_iam-limits-entity-length"
         * >IAM and STS Character Limits</a> in the <i>IAM User Guide</i>.
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
         * You can pass a session tag with the same key as a tag that is already attached to the role. When you do,
         * session tags override a role tag with the same key.
         * </p>
         * <p>
         * Tag key–value pairs are not case sensitive, but case is preserved. This means that you cannot have separate
         * <code>Department</code> and <code>department</code> tag keys. Assume that the role has the
         * <code>Department</code>=<code>Marketing</code> tag and you pass the <code>department</code>=
         * <code>engineering</code> session tag. <code>Department</code> and <code>department</code> are not saved as
         * separate tags, and the session tag passed in the request takes precedence over the role tag.
         * </p>
         * <p>
         * Additionally, if you used temporary credentials to perform this operation, the new session inherits any
         * transitive session tags from the calling session. If you pass a session tag with the same key as an inherited
         * tag, the operation fails. To view the inherited tags for a session, see the CloudTrail logs. For more
         * information, see <a
         * href="https://docs.aws.amazon.com/IAM/latest/UserGuide/id_session-tags.html#id_session-tags_ctlogs">Viewing
         * Session Tags in CloudTrail</a> in the <i>IAM User Guide</i>.
         * </p>
         * This is a convenience method that creates an instance of the
         * {@link com.ibm.cos.v2.services.sts.model.Tag.Builder} avoiding the need to create one manually via
         * {@link com.ibm.cos.v2.services.sts.model.Tag#builder()}.
         *
         * <p>
         * When the {@link Consumer} completes, {@link com.ibm.cos.v2.services.sts.model.Tag.Builder#build()} is
         * called immediately and its result is passed to {@link #tags(List<Tag>)}.
         * 
         * @param tags
         *        a consumer that will call methods on {@link com.ibm.cos.v2.services.sts.model.Tag.Builder}
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see #tags(java.util.Collection<Tag>)
         */
        Builder tags(Consumer<Tag.Builder>... tags);

        /**
         * <p>
         * A list of keys for session tags that you want to set as transitive. If you set a tag key as transitive, the
         * corresponding key and value passes to subsequent sessions in a role chain. For more information, see <a
         * href="https://docs.aws.amazon.com/IAM/latest/UserGuide/id_session-tags.html#id_session-tags_role-chaining"
         * >Chaining Roles with Session Tags</a> in the <i>IAM User Guide</i>.
         * </p>
         * <p>
         * This parameter is optional. The transitive status of a session tag does not impact its packed binary size.
         * </p>
         * <p>
         * If you choose not to specify a transitive tag key, then no tags are passed from this session to any
         * subsequent sessions.
         * </p>
         * 
         * @param transitiveTagKeys
         *        A list of keys for session tags that you want to set as transitive. If you set a tag key as
         *        transitive, the corresponding key and value passes to subsequent sessions in a role chain. For more
         *        information, see <a href=
         *        "https://docs.aws.amazon.com/IAM/latest/UserGuide/id_session-tags.html#id_session-tags_role-chaining"
         *        >Chaining Roles with Session Tags</a> in the <i>IAM User Guide</i>.</p>
         *        <p>
         *        This parameter is optional. The transitive status of a session tag does not impact its packed binary
         *        size.
         *        </p>
         *        <p>
         *        If you choose not to specify a transitive tag key, then no tags are passed from this session to any
         *        subsequent sessions.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder transitiveTagKeys(Collection<String> transitiveTagKeys);

        /**
         * <p>
         * A list of keys for session tags that you want to set as transitive. If you set a tag key as transitive, the
         * corresponding key and value passes to subsequent sessions in a role chain. For more information, see <a
         * href="https://docs.aws.amazon.com/IAM/latest/UserGuide/id_session-tags.html#id_session-tags_role-chaining"
         * >Chaining Roles with Session Tags</a> in the <i>IAM User Guide</i>.
         * </p>
         * <p>
         * This parameter is optional. The transitive status of a session tag does not impact its packed binary size.
         * </p>
         * <p>
         * If you choose not to specify a transitive tag key, then no tags are passed from this session to any
         * subsequent sessions.
         * </p>
         * 
         * @param transitiveTagKeys
         *        A list of keys for session tags that you want to set as transitive. If you set a tag key as
         *        transitive, the corresponding key and value passes to subsequent sessions in a role chain. For more
         *        information, see <a href=
         *        "https://docs.aws.amazon.com/IAM/latest/UserGuide/id_session-tags.html#id_session-tags_role-chaining"
         *        >Chaining Roles with Session Tags</a> in the <i>IAM User Guide</i>.</p>
         *        <p>
         *        This parameter is optional. The transitive status of a session tag does not impact its packed binary
         *        size.
         *        </p>
         *        <p>
         *        If you choose not to specify a transitive tag key, then no tags are passed from this session to any
         *        subsequent sessions.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder transitiveTagKeys(String... transitiveTagKeys);

        /**
         * <p>
         * A unique identifier that might be required when you assume a role in another account. If the administrator of
         * the account to which the role belongs provided you with an external ID, then provide that value in the
         * <code>ExternalId</code> parameter. This value can be any string, such as a passphrase or account number. A
         * cross-account role is usually set up to trust everyone in an account. Therefore, the administrator of the
         * trusting account might send an external ID to the administrator of the trusted account. That way, only
         * someone with the ID can assume the role, rather than everyone in the account. For more information about the
         * external ID, see <a
         * href="https://docs.aws.amazon.com/IAM/latest/UserGuide/id_roles_create_for-user_externalid.html">How to Use
         * an External ID When Granting Access to Your Amazon Web Services Resources to a Third Party</a> in the <i>IAM
         * User Guide</i>.
         * </p>
         * <p>
         * The regex used to validate this parameter is a string of characters consisting of upper- and lower-case
         * alphanumeric characters with no spaces. You can also include underscores or any of the following characters:
         * =,.@:/-
         * </p>
         * 
         * @param externalId
         *        A unique identifier that might be required when you assume a role in another account. If the
         *        administrator of the account to which the role belongs provided you with an external ID, then provide
         *        that value in the <code>ExternalId</code> parameter. This value can be any string, such as a
         *        passphrase or account number. A cross-account role is usually set up to trust everyone in an account.
         *        Therefore, the administrator of the trusting account might send an external ID to the administrator of
         *        the trusted account. That way, only someone with the ID can assume the role, rather than everyone in
         *        the account. For more information about the external ID, see <a
         *        href="https://docs.aws.amazon.com/IAM/latest/UserGuide/id_roles_create_for-user_externalid.html">How
         *        to Use an External ID When Granting Access to Your Amazon Web Services Resources to a Third Party</a>
         *        in the <i>IAM User Guide</i>.</p>
         *        <p>
         *        The regex used to validate this parameter is a string of characters consisting of upper- and
         *        lower-case alphanumeric characters with no spaces. You can also include underscores or any of the
         *        following characters: =,.@:/-
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder externalId(String externalId);

        /**
         * <p>
         * The identification number of the MFA device that is associated with the user who is making the
         * <code>AssumeRole</code> call. Specify this value if the trust policy of the role being assumed includes a
         * condition that requires MFA authentication. The value is either the serial number for a hardware device (such
         * as <code>GAHT12345678</code>) or an Amazon Resource Name (ARN) for a virtual device (such as
         * <code>arn:aws:iam::123456789012:mfa/user</code>).
         * </p>
         * <p>
         * The regex used to validate this parameter is a string of characters consisting of upper- and lower-case
         * alphanumeric characters with no spaces. You can also include underscores or any of the following characters:
         * =,.@-
         * </p>
         * 
         * @param serialNumber
         *        The identification number of the MFA device that is associated with the user who is making the
         *        <code>AssumeRole</code> call. Specify this value if the trust policy of the role being assumed
         *        includes a condition that requires MFA authentication. The value is either the serial number for a
         *        hardware device (such as <code>GAHT12345678</code>) or an Amazon Resource Name (ARN) for a virtual
         *        device (such as <code>arn:aws:iam::123456789012:mfa/user</code>).</p>
         *        <p>
         *        The regex used to validate this parameter is a string of characters consisting of upper- and
         *        lower-case alphanumeric characters with no spaces. You can also include underscores or any of the
         *        following characters: =,.@-
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder serialNumber(String serialNumber);

        /**
         * <p>
         * The value provided by the MFA device, if the trust policy of the role being assumed requires MFA. (In other
         * words, if the policy includes a condition that tests for MFA). If the role being assumed requires MFA and if
         * the <code>TokenCode</code> value is missing or expired, the <code>AssumeRole</code> call returns an
         * "access denied" error.
         * </p>
         * <p>
         * The format for this parameter, as described by its regex pattern, is a sequence of six numeric digits.
         * </p>
         * 
         * @param tokenCode
         *        The value provided by the MFA device, if the trust policy of the role being assumed requires MFA. (In
         *        other words, if the policy includes a condition that tests for MFA). If the role being assumed
         *        requires MFA and if the <code>TokenCode</code> value is missing or expired, the
         *        <code>AssumeRole</code> call returns an "access denied" error.</p>
         *        <p>
         *        The format for this parameter, as described by its regex pattern, is a sequence of six numeric digits.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder tokenCode(String tokenCode);

        /**
         * <p>
         * The source identity specified by the principal that is calling the <code>AssumeRole</code> operation. The
         * source identity value persists across <a
         * href="https://docs.aws.amazon.com/IAM/latest/UserGuide/id_roles.html#iam-term-role-chaining">chained role</a>
         * sessions.
         * </p>
         * <p>
         * You can require users to specify a source identity when they assume a role. You do this by using the <a href=
         * "https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_policies_condition-keys.html#condition-keys-sourceidentity"
         * > <code>sts:SourceIdentity</code> </a> condition key in a role trust policy. You can use source identity
         * information in CloudTrail logs to determine who took actions with a role. You can use the
         * <code>aws:SourceIdentity</code> condition key to further control access to Amazon Web Services resources
         * based on the value of source identity. For more information about using source identity, see <a
         * href="https://docs.aws.amazon.com/IAM/latest/UserGuide/id_credentials_temp_control-access_monitor.html"
         * >Monitor and control actions taken with assumed roles</a> in the <i>IAM User Guide</i>.
         * </p>
         * <p>
         * The regex used to validate this parameter is a string of characters consisting of upper- and lower-case
         * alphanumeric characters with no spaces. You can also include underscores or any of the following characters:
         * +=,.@-. You cannot use a value that begins with the text <code>aws:</code>. This prefix is reserved for
         * Amazon Web Services internal use.
         * </p>
         * 
         * @param sourceIdentity
         *        The source identity specified by the principal that is calling the <code>AssumeRole</code> operation.
         *        The source identity value persists across <a
         *        href="https://docs.aws.amazon.com/IAM/latest/UserGuide/id_roles.html#iam-term-role-chaining">chained
         *        role</a> sessions.</p>
         *        <p>
         *        You can require users to specify a source identity when they assume a role. You do this by using the
         *        <a href=
         *        "https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_policies_condition-keys.html#condition-keys-sourceidentity"
         *        > <code>sts:SourceIdentity</code> </a> condition key in a role trust policy. You can use source
         *        identity information in CloudTrail logs to determine who took actions with a role. You can use the
         *        <code>aws:SourceIdentity</code> condition key to further control access to Amazon Web Services
         *        resources based on the value of source identity. For more information about using source identity, see
         *        <a href=
         *        "https://docs.aws.amazon.com/IAM/latest/UserGuide/id_credentials_temp_control-access_monitor.html"
         *        >Monitor and control actions taken with assumed roles</a> in the <i>IAM User Guide</i>.
         *        </p>
         *        <p>
         *        The regex used to validate this parameter is a string of characters consisting of upper- and
         *        lower-case alphanumeric characters with no spaces. You can also include underscores or any of the
         *        following characters: +=,.@-. You cannot use a value that begins with the text <code>aws:</code>. This
         *        prefix is reserved for Amazon Web Services internal use.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder sourceIdentity(String sourceIdentity);

        /**
         * <p>
         * A list of previously acquired trusted context assertions in the format of a JSON array. The trusted context
         * assertion is signed and encrypted by Amazon Web Services STS.
         * </p>
         * <p>
         * The following is an example of a <code>ProvidedContext</code> value that includes a single trusted context
         * assertion and the ARN of the context provider from which the trusted context assertion was generated.
         * </p>
         * <p>
         * <code>[{"ProviderArn":"arn:aws:iam::aws:contextProvider/IdentityCenter","ContextAssertion":"trusted-context-assertion"}]</code>
         * </p>
         * 
         * @param providedContexts
         *        A list of previously acquired trusted context assertions in the format of a JSON array. The trusted
         *        context assertion is signed and encrypted by Amazon Web Services STS.</p>
         *        <p>
         *        The following is an example of a <code>ProvidedContext</code> value that includes a single trusted
         *        context assertion and the ARN of the context provider from which the trusted context assertion was
         *        generated.
         *        </p>
         *        <p>
         *        <code>[{"ProviderArn":"arn:aws:iam::aws:contextProvider/IdentityCenter","ContextAssertion":"trusted-context-assertion"}]</code>
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder providedContexts(Collection<ProvidedContext> providedContexts);

        /**
         * <p>
         * A list of previously acquired trusted context assertions in the format of a JSON array. The trusted context
         * assertion is signed and encrypted by Amazon Web Services STS.
         * </p>
         * <p>
         * The following is an example of a <code>ProvidedContext</code> value that includes a single trusted context
         * assertion and the ARN of the context provider from which the trusted context assertion was generated.
         * </p>
         * <p>
         * <code>[{"ProviderArn":"arn:aws:iam::aws:contextProvider/IdentityCenter","ContextAssertion":"trusted-context-assertion"}]</code>
         * </p>
         * 
         * @param providedContexts
         *        A list of previously acquired trusted context assertions in the format of a JSON array. The trusted
         *        context assertion is signed and encrypted by Amazon Web Services STS.</p>
         *        <p>
         *        The following is an example of a <code>ProvidedContext</code> value that includes a single trusted
         *        context assertion and the ARN of the context provider from which the trusted context assertion was
         *        generated.
         *        </p>
         *        <p>
         *        <code>[{"ProviderArn":"arn:aws:iam::aws:contextProvider/IdentityCenter","ContextAssertion":"trusted-context-assertion"}]</code>
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder providedContexts(ProvidedContext... providedContexts);

        /**
         * <p>
         * A list of previously acquired trusted context assertions in the format of a JSON array. The trusted context
         * assertion is signed and encrypted by Amazon Web Services STS.
         * </p>
         * <p>
         * The following is an example of a <code>ProvidedContext</code> value that includes a single trusted context
         * assertion and the ARN of the context provider from which the trusted context assertion was generated.
         * </p>
         * <p>
         * <code>[{"ProviderArn":"arn:aws:iam::aws:contextProvider/IdentityCenter","ContextAssertion":"trusted-context-assertion"}]</code>
         * </p>
         * This is a convenience method that creates an instance of the
         * {@link com.ibm.cos.v2.services.sts.model.ProvidedContext.Builder} avoiding the need to create one
         * manually via {@link com.ibm.cos.v2.services.sts.model.ProvidedContext#builder()}.
         *
         * <p>
         * When the {@link Consumer} completes,
         * {@link com.ibm.cos.v2.services.sts.model.ProvidedContext.Builder#build()} is called immediately and
         * its result is passed to {@link #providedContexts(List<ProvidedContext>)}.
         * 
         * @param providedContexts
         *        a consumer that will call methods on
         *        {@link com.ibm.cos.v2.services.sts.model.ProvidedContext.Builder}
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see #providedContexts(java.util.Collection<ProvidedContext>)
         */
        Builder providedContexts(Consumer<ProvidedContext.Builder>... providedContexts);

        @Override
        Builder overrideConfiguration(AwsRequestOverrideConfiguration overrideConfiguration);

        @Override
        Builder overrideConfiguration(Consumer<AwsRequestOverrideConfiguration.Builder> builderConsumer);
    }

    static final class BuilderImpl extends StsRequest.BuilderImpl implements Builder {
        private String roleArn;

        private String roleSessionName;

        private List<PolicyDescriptorType> policyArns = DefaultSdkAutoConstructList.getInstance();

        private String policy;

        private Integer durationSeconds;

        private List<Tag> tags = DefaultSdkAutoConstructList.getInstance();

        private List<String> transitiveTagKeys = DefaultSdkAutoConstructList.getInstance();

        private String externalId;

        private String serialNumber;

        private String tokenCode;

        private String sourceIdentity;

        private List<ProvidedContext> providedContexts = DefaultSdkAutoConstructList.getInstance();

        private BuilderImpl() {
        }

        private BuilderImpl(AssumeRoleRequest model) {
            super(model);
            roleArn(model.roleArn);
            roleSessionName(model.roleSessionName);
            policyArns(model.policyArns);
            policy(model.policy);
            durationSeconds(model.durationSeconds);
            tags(model.tags);
            transitiveTagKeys(model.transitiveTagKeys);
            externalId(model.externalId);
            serialNumber(model.serialNumber);
            tokenCode(model.tokenCode);
            sourceIdentity(model.sourceIdentity);
            providedContexts(model.providedContexts);
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

        public final String getRoleSessionName() {
            return roleSessionName;
        }

        public final void setRoleSessionName(String roleSessionName) {
            this.roleSessionName = roleSessionName;
        }

        @Override
        public final Builder roleSessionName(String roleSessionName) {
            this.roleSessionName = roleSessionName;
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

        public final List<Tag.Builder> getTags() {
            List<Tag.Builder> result = _tagListTypeCopier.copyToBuilder(this.tags);
            if (result instanceof SdkAutoConstructList) {
                return null;
            }
            return result;
        }

        public final void setTags(Collection<Tag.BuilderImpl> tags) {
            this.tags = _tagListTypeCopier.copyFromBuilder(tags);
        }

        @Override
        public final Builder tags(Collection<Tag> tags) {
            this.tags = _tagListTypeCopier.copy(tags);
            return this;
        }

        @Override
        @SafeVarargs
        public final Builder tags(Tag... tags) {
            tags(Arrays.asList(tags));
            return this;
        }

        @Override
        @SafeVarargs
        public final Builder tags(Consumer<Tag.Builder>... tags) {
            tags(Stream.of(tags).map(c -> Tag.builder().applyMutation(c).build()).collect(Collectors.toList()));
            return this;
        }

        public final Collection<String> getTransitiveTagKeys() {
            if (transitiveTagKeys instanceof SdkAutoConstructList) {
                return null;
            }
            return transitiveTagKeys;
        }

        public final void setTransitiveTagKeys(Collection<String> transitiveTagKeys) {
            this.transitiveTagKeys = _tagKeyListTypeCopier.copy(transitiveTagKeys);
        }

        @Override
        public final Builder transitiveTagKeys(Collection<String> transitiveTagKeys) {
            this.transitiveTagKeys = _tagKeyListTypeCopier.copy(transitiveTagKeys);
            return this;
        }

        @Override
        @SafeVarargs
        public final Builder transitiveTagKeys(String... transitiveTagKeys) {
            transitiveTagKeys(Arrays.asList(transitiveTagKeys));
            return this;
        }

        public final String getExternalId() {
            return externalId;
        }

        public final void setExternalId(String externalId) {
            this.externalId = externalId;
        }

        @Override
        public final Builder externalId(String externalId) {
            this.externalId = externalId;
            return this;
        }

        public final String getSerialNumber() {
            return serialNumber;
        }

        public final void setSerialNumber(String serialNumber) {
            this.serialNumber = serialNumber;
        }

        @Override
        public final Builder serialNumber(String serialNumber) {
            this.serialNumber = serialNumber;
            return this;
        }

        public final String getTokenCode() {
            return tokenCode;
        }

        public final void setTokenCode(String tokenCode) {
            this.tokenCode = tokenCode;
        }

        @Override
        public final Builder tokenCode(String tokenCode) {
            this.tokenCode = tokenCode;
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

        public final List<ProvidedContext.Builder> getProvidedContexts() {
            List<ProvidedContext.Builder> result = ProvidedContextsListTypeCopier.copyToBuilder(this.providedContexts);
            if (result instanceof SdkAutoConstructList) {
                return null;
            }
            return result;
        }

        public final void setProvidedContexts(Collection<ProvidedContext.BuilderImpl> providedContexts) {
            this.providedContexts = ProvidedContextsListTypeCopier.copyFromBuilder(providedContexts);
        }

        @Override
        public final Builder providedContexts(Collection<ProvidedContext> providedContexts) {
            this.providedContexts = ProvidedContextsListTypeCopier.copy(providedContexts);
            return this;
        }

        @Override
        @SafeVarargs
        public final Builder providedContexts(ProvidedContext... providedContexts) {
            providedContexts(Arrays.asList(providedContexts));
            return this;
        }

        @Override
        @SafeVarargs
        public final Builder providedContexts(Consumer<ProvidedContext.Builder>... providedContexts) {
            providedContexts(Stream.of(providedContexts).map(c -> ProvidedContext.builder().applyMutation(c).build())
                    .collect(Collectors.toList()));
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
        public AssumeRoleRequest build() {
            return new AssumeRoleRequest(this);
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
