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
public final class GetFederationTokenRequest extends StsRequest implements
        ToCopyableBuilder<GetFederationTokenRequest.Builder, GetFederationTokenRequest> {
    private static final SdkField<String> NAME_FIELD = SdkField.<String> builder(MarshallingType.STRING).memberName("Name")
            .getter(getter(GetFederationTokenRequest::name)).setter(setter(Builder::name))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("Name").build()).build();

    private static final SdkField<String> POLICY_FIELD = SdkField.<String> builder(MarshallingType.STRING).memberName("Policy")
            .getter(getter(GetFederationTokenRequest::policy)).setter(setter(Builder::policy))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("Policy").build()).build();

    private static final SdkField<List<PolicyDescriptorType>> POLICY_ARNS_FIELD = SdkField
            .<List<PolicyDescriptorType>> builder(MarshallingType.LIST)
            .memberName("PolicyArns")
            .getter(getter(GetFederationTokenRequest::policyArns))
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

    private static final SdkField<Integer> DURATION_SECONDS_FIELD = SdkField.<Integer> builder(MarshallingType.INTEGER)
            .memberName("DurationSeconds").getter(getter(GetFederationTokenRequest::durationSeconds))
            .setter(setter(Builder::durationSeconds))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("DurationSeconds").build()).build();

    private static final SdkField<List<Tag>> TAGS_FIELD = SdkField
            .<List<Tag>> builder(MarshallingType.LIST)
            .memberName("Tags")
            .getter(getter(GetFederationTokenRequest::tags))
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

    private static final List<SdkField<?>> SDK_FIELDS = Collections.unmodifiableList(Arrays.asList(NAME_FIELD, POLICY_FIELD,
            POLICY_ARNS_FIELD, DURATION_SECONDS_FIELD, TAGS_FIELD));

    private static final Map<String, SdkField<?>> SDK_NAME_TO_FIELD = memberNameToFieldInitializer();

    private final String name;

    private final String policy;

    private final List<PolicyDescriptorType> policyArns;

    private final Integer durationSeconds;

    private final List<Tag> tags;

    private GetFederationTokenRequest(BuilderImpl builder) {
        super(builder);
        this.name = builder.name;
        this.policy = builder.policy;
        this.policyArns = builder.policyArns;
        this.durationSeconds = builder.durationSeconds;
        this.tags = builder.tags;
    }

    /**
     * <p>
     * The name of the federated user. The name is used as an identifier for the temporary security credentials (such as
     * <code>Bob</code>). For example, you can reference the federated user name in a resource-based policy, such as in
     * an Amazon S3 bucket policy.
     * </p>
     * <p>
     * The regex used to validate this parameter is a string of characters consisting of upper- and lower-case
     * alphanumeric characters with no spaces. You can also include underscores or any of the following characters: =,.@-
     * </p>
     * 
     * @return The name of the federated user. The name is used as an identifier for the temporary security credentials
     *         (such as <code>Bob</code>). For example, you can reference the federated user name in a resource-based
     *         policy, such as in an Amazon S3 bucket policy.</p>
     *         <p>
     *         The regex used to validate this parameter is a string of characters consisting of upper- and lower-case
     *         alphanumeric characters with no spaces. You can also include underscores or any of the following
     *         characters: =,.@-
     */
    public final String name() {
        return name;
    }

    /**
     * <p>
     * An IAM policy in JSON format that you want to use as an inline session policy.
     * </p>
     * <p>
     * You must pass an inline or managed <a
     * href="https://docs.aws.amazon.com/IAM/latest/UserGuide/access_policies.html#policies_session">session policy</a>
     * to this operation. You can pass a single JSON policy document to use as an inline session policy. You can also
     * specify up to 10 managed policy Amazon Resource Names (ARNs) to use as managed session policies.
     * </p>
     * <p>
     * This parameter is optional. However, if you do not pass any session policies, then the resulting federated user
     * session has no permissions.
     * </p>
     * <p>
     * When you pass session policies, the session permissions are the intersection of the IAM user policies and the
     * session policies that you pass. This gives you a way to further restrict the permissions for a federated user.
     * You cannot use session policies to grant more permissions than those that are defined in the permissions policy
     * of the IAM user. For more information, see <a
     * href="https://docs.aws.amazon.com/IAM/latest/UserGuide/access_policies.html#policies_session">Session
     * Policies</a> in the <i>IAM User Guide</i>.
     * </p>
     * <p>
     * The resulting credentials can be used to access a resource that has a resource-based policy. If that policy
     * specifically references the federated user session in the <code>Principal</code> element of the policy, the
     * session has the permissions allowed by the policy. These permissions are granted in addition to the permissions
     * that are granted by the session policies.
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
     * 
     * @return An IAM policy in JSON format that you want to use as an inline session policy.</p>
     *         <p>
     *         You must pass an inline or managed <a
     *         href="https://docs.aws.amazon.com/IAM/latest/UserGuide/access_policies.html#policies_session">session
     *         policy</a> to this operation. You can pass a single JSON policy document to use as an inline session
     *         policy. You can also specify up to 10 managed policy Amazon Resource Names (ARNs) to use as managed
     *         session policies.
     *         </p>
     *         <p>
     *         This parameter is optional. However, if you do not pass any session policies, then the resulting
     *         federated user session has no permissions.
     *         </p>
     *         <p>
     *         When you pass session policies, the session permissions are the intersection of the IAM user policies and
     *         the session policies that you pass. This gives you a way to further restrict the permissions for a
     *         federated user. You cannot use session policies to grant more permissions than those that are defined in
     *         the permissions policy of the IAM user. For more information, see <a
     *         href="https://docs.aws.amazon.com/IAM/latest/UserGuide/access_policies.html#policies_session">Session
     *         Policies</a> in the <i>IAM User Guide</i>.
     *         </p>
     *         <p>
     *         The resulting credentials can be used to access a resource that has a resource-based policy. If that
     *         policy specifically references the federated user session in the <code>Principal</code> element of the
     *         policy, the session has the permissions allowed by the policy. These permissions are granted in addition
     *         to the permissions that are granted by the session policies.
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
     */
    public final String policy() {
        return policy;
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
     * The Amazon Resource Names (ARNs) of the IAM managed policies that you want to use as a managed session policy.
     * The policies must exist in the same account as the IAM user that is requesting federated access.
     * </p>
     * <p>
     * You must pass an inline or managed <a
     * href="https://docs.aws.amazon.com/IAM/latest/UserGuide/access_policies.html#policies_session">session policy</a>
     * to this operation. You can pass a single JSON policy document to use as an inline session policy. You can also
     * specify up to 10 managed policy Amazon Resource Names (ARNs) to use as managed session policies. The plaintext
     * that you use for both inline and managed session policies can't exceed 2,048 characters. You can provide up to 10
     * managed policy ARNs. For more information about ARNs, see <a
     * href="https://docs.aws.amazon.com/general/latest/gr/aws-arns-and-namespaces.html">Amazon Resource Names (ARNs)
     * and Amazon Web Services Service Namespaces</a> in the Amazon Web Services General Reference.
     * </p>
     * <p>
     * This parameter is optional. However, if you do not pass any session policies, then the resulting federated user
     * session has no permissions.
     * </p>
     * <p>
     * When you pass session policies, the session permissions are the intersection of the IAM user policies and the
     * session policies that you pass. This gives you a way to further restrict the permissions for a federated user.
     * You cannot use session policies to grant more permissions than those that are defined in the permissions policy
     * of the IAM user. For more information, see <a
     * href="https://docs.aws.amazon.com/IAM/latest/UserGuide/access_policies.html#policies_session">Session
     * Policies</a> in the <i>IAM User Guide</i>.
     * </p>
     * <p>
     * The resulting credentials can be used to access a resource that has a resource-based policy. If that policy
     * specifically references the federated user session in the <code>Principal</code> element of the policy, the
     * session has the permissions allowed by the policy. These permissions are granted in addition to the permissions
     * that are granted by the session policies.
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
     * Attempts to modify the collection returned by this method will result in an UnsupportedOperationException.
     * </p>
     * <p>
     * This method will never return null. If you would like to know whether the service returned this field (so that
     * you can differentiate between null and empty), you can use the {@link #hasPolicyArns} method.
     * </p>
     * 
     * @return The Amazon Resource Names (ARNs) of the IAM managed policies that you want to use as a managed session
     *         policy. The policies must exist in the same account as the IAM user that is requesting federated
     *         access.</p>
     *         <p>
     *         You must pass an inline or managed <a
     *         href="https://docs.aws.amazon.com/IAM/latest/UserGuide/access_policies.html#policies_session">session
     *         policy</a> to this operation. You can pass a single JSON policy document to use as an inline session
     *         policy. You can also specify up to 10 managed policy Amazon Resource Names (ARNs) to use as managed
     *         session policies. The plaintext that you use for both inline and managed session policies can't exceed
     *         2,048 characters. You can provide up to 10 managed policy ARNs. For more information about ARNs, see <a
     *         href="https://docs.aws.amazon.com/general/latest/gr/aws-arns-and-namespaces.html">Amazon Resource Names
     *         (ARNs) and Amazon Web Services Service Namespaces</a> in the Amazon Web Services General Reference.
     *         </p>
     *         <p>
     *         This parameter is optional. However, if you do not pass any session policies, then the resulting
     *         federated user session has no permissions.
     *         </p>
     *         <p>
     *         When you pass session policies, the session permissions are the intersection of the IAM user policies and
     *         the session policies that you pass. This gives you a way to further restrict the permissions for a
     *         federated user. You cannot use session policies to grant more permissions than those that are defined in
     *         the permissions policy of the IAM user. For more information, see <a
     *         href="https://docs.aws.amazon.com/IAM/latest/UserGuide/access_policies.html#policies_session">Session
     *         Policies</a> in the <i>IAM User Guide</i>.
     *         </p>
     *         <p>
     *         The resulting credentials can be used to access a resource that has a resource-based policy. If that
     *         policy specifically references the federated user session in the <code>Principal</code> element of the
     *         policy, the session has the permissions allowed by the policy. These permissions are granted in addition
     *         to the permissions that are granted by the session policies.
     *         </p>
     *         <note>
     *         <p>
     *         An Amazon Web Services conversion compresses the passed inline session policy, managed policy ARNs, and
     *         session tags into a packed binary format that has a separate limit. Your request can fail for this limit
     *         even if your plaintext meets the other requirements. The <code>PackedPolicySize</code> response element
     *         indicates by percentage how close the policies and tags for your request are to the upper size limit.
     *         </p>
     */
    public final List<PolicyDescriptorType> policyArns() {
        return policyArns;
    }

    /**
     * <p>
     * The duration, in seconds, that the session should last. Acceptable durations for federation sessions range from
     * 900 seconds (15 minutes) to 129,600 seconds (36 hours), with 43,200 seconds (12 hours) as the default. Sessions
     * obtained using root user credentials are restricted to a maximum of 3,600 seconds (one hour). If the specified
     * duration is longer than one hour, the session obtained by using root user credentials defaults to one hour.
     * </p>
     * 
     * @return The duration, in seconds, that the session should last. Acceptable durations for federation sessions
     *         range from 900 seconds (15 minutes) to 129,600 seconds (36 hours), with 43,200 seconds (12 hours) as the
     *         default. Sessions obtained using root user credentials are restricted to a maximum of 3,600 seconds (one
     *         hour). If the specified duration is longer than one hour, the session obtained by using root user
     *         credentials defaults to one hour.
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
     * A list of session tags. Each session tag consists of a key name and an associated value. For more information
     * about session tags, see <a href="https://docs.aws.amazon.com/IAM/latest/UserGuide/id_session-tags.html">Passing
     * Session Tags in STS</a> in the <i>IAM User Guide</i>.
     * </p>
     * <p>
     * This parameter is optional. You can pass up to 50 session tags. The plaintext session tag keys can’t exceed 128
     * characters and the values can’t exceed 256 characters. For these and additional limits, see <a href=
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
     * You can pass a session tag with the same key as a tag that is already attached to the user you are federating.
     * When you do, session tags override a user tag with the same key.
     * </p>
     * <p>
     * Tag key–value pairs are not case sensitive, but case is preserved. This means that you cannot have separate
     * <code>Department</code> and <code>department</code> tag keys. Assume that the role has the
     * <code>Department</code>=<code>Marketing</code> tag and you pass the <code>department</code>=
     * <code>engineering</code> session tag. <code>Department</code> and <code>department</code> are not saved as
     * separate tags, and the session tag passed in the request takes precedence over the role tag.
     * </p>
     * <p>
     * Attempts to modify the collection returned by this method will result in an UnsupportedOperationException.
     * </p>
     * <p>
     * This method will never return null. If you would like to know whether the service returned this field (so that
     * you can differentiate between null and empty), you can use the {@link #hasTags} method.
     * </p>
     * 
     * @return A list of session tags. Each session tag consists of a key name and an associated value. For more
     *         information about session tags, see <a
     *         href="https://docs.aws.amazon.com/IAM/latest/UserGuide/id_session-tags.html">Passing Session Tags in
     *         STS</a> in the <i>IAM User Guide</i>.</p>
     *         <p>
     *         This parameter is optional. You can pass up to 50 session tags. The plaintext session tag keys can’t
     *         exceed 128 characters and the values can’t exceed 256 characters. For these and additional limits, see <a
     *         href=
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
     *         You can pass a session tag with the same key as a tag that is already attached to the user you are
     *         federating. When you do, session tags override a user tag with the same key.
     *         </p>
     *         <p>
     *         Tag key–value pairs are not case sensitive, but case is preserved. This means that you cannot have
     *         separate <code>Department</code> and <code>department</code> tag keys. Assume that the role has the
     *         <code>Department</code>=<code>Marketing</code> tag and you pass the <code>department</code>=
     *         <code>engineering</code> session tag. <code>Department</code> and <code>department</code> are not saved
     *         as separate tags, and the session tag passed in the request takes precedence over the role tag.
     */
    public final List<Tag> tags() {
        return tags;
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
        hashCode = 31 * hashCode + Objects.hashCode(name());
        hashCode = 31 * hashCode + Objects.hashCode(policy());
        hashCode = 31 * hashCode + Objects.hashCode(hasPolicyArns() ? policyArns() : null);
        hashCode = 31 * hashCode + Objects.hashCode(durationSeconds());
        hashCode = 31 * hashCode + Objects.hashCode(hasTags() ? tags() : null);
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
        if (!(obj instanceof GetFederationTokenRequest)) {
            return false;
        }
        GetFederationTokenRequest other = (GetFederationTokenRequest) obj;
        return Objects.equals(name(), other.name()) && Objects.equals(policy(), other.policy())
                && hasPolicyArns() == other.hasPolicyArns() && Objects.equals(policyArns(), other.policyArns())
                && Objects.equals(durationSeconds(), other.durationSeconds()) && hasTags() == other.hasTags()
                && Objects.equals(tags(), other.tags());
    }

    /**
     * Returns a string representation of this object. This is useful for testing and debugging. Sensitive data will be
     * redacted from this string using a placeholder value.
     */
    @Override
    public final String toString() {
        return ToString.builder("GetFederationTokenRequest").add("Name", name()).add("Policy", policy())
                .add("PolicyArns", hasPolicyArns() ? policyArns() : null).add("DurationSeconds", durationSeconds())
                .add("Tags", hasTags() ? tags() : null).build();
    }

    public final <T> Optional<T> getValueForField(String fieldName, Class<T> clazz) {
        switch (fieldName) {
        case "Name":
            return Optional.ofNullable(clazz.cast(name()));
        case "Policy":
            return Optional.ofNullable(clazz.cast(policy()));
        case "PolicyArns":
            return Optional.ofNullable(clazz.cast(policyArns()));
        case "DurationSeconds":
            return Optional.ofNullable(clazz.cast(durationSeconds()));
        case "Tags":
            return Optional.ofNullable(clazz.cast(tags()));
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
        map.put("Name", NAME_FIELD);
        map.put("Policy", POLICY_FIELD);
        map.put("PolicyArns", POLICY_ARNS_FIELD);
        map.put("DurationSeconds", DURATION_SECONDS_FIELD);
        map.put("Tags", TAGS_FIELD);
        return Collections.unmodifiableMap(map);
    }

    private static <T> Function<Object, T> getter(Function<GetFederationTokenRequest, T> g) {
        return obj -> g.apply((GetFederationTokenRequest) obj);
    }

    private static <T> BiConsumer<Object, T> setter(BiConsumer<Builder, T> s) {
        return (obj, val) -> s.accept((Builder) obj, val);
    }

    @Mutable
    @NotThreadSafe
    public interface Builder extends StsRequest.Builder, SdkPojo, CopyableBuilder<Builder, GetFederationTokenRequest> {
        /**
         * <p>
         * The name of the federated user. The name is used as an identifier for the temporary security credentials
         * (such as <code>Bob</code>). For example, you can reference the federated user name in a resource-based
         * policy, such as in an Amazon S3 bucket policy.
         * </p>
         * <p>
         * The regex used to validate this parameter is a string of characters consisting of upper- and lower-case
         * alphanumeric characters with no spaces. You can also include underscores or any of the following characters:
         * =,.@-
         * </p>
         * 
         * @param name
         *        The name of the federated user. The name is used as an identifier for the temporary security
         *        credentials (such as <code>Bob</code>). For example, you can reference the federated user name in a
         *        resource-based policy, such as in an Amazon S3 bucket policy.</p>
         *        <p>
         *        The regex used to validate this parameter is a string of characters consisting of upper- and
         *        lower-case alphanumeric characters with no spaces. You can also include underscores or any of the
         *        following characters: =,.@-
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder name(String name);

        /**
         * <p>
         * An IAM policy in JSON format that you want to use as an inline session policy.
         * </p>
         * <p>
         * You must pass an inline or managed <a
         * href="https://docs.aws.amazon.com/IAM/latest/UserGuide/access_policies.html#policies_session">session
         * policy</a> to this operation. You can pass a single JSON policy document to use as an inline session policy.
         * You can also specify up to 10 managed policy Amazon Resource Names (ARNs) to use as managed session policies.
         * </p>
         * <p>
         * This parameter is optional. However, if you do not pass any session policies, then the resulting federated
         * user session has no permissions.
         * </p>
         * <p>
         * When you pass session policies, the session permissions are the intersection of the IAM user policies and the
         * session policies that you pass. This gives you a way to further restrict the permissions for a federated
         * user. You cannot use session policies to grant more permissions than those that are defined in the
         * permissions policy of the IAM user. For more information, see <a
         * href="https://docs.aws.amazon.com/IAM/latest/UserGuide/access_policies.html#policies_session">Session
         * Policies</a> in the <i>IAM User Guide</i>.
         * </p>
         * <p>
         * The resulting credentials can be used to access a resource that has a resource-based policy. If that policy
         * specifically references the federated user session in the <code>Principal</code> element of the policy, the
         * session has the permissions allowed by the policy. These permissions are granted in addition to the
         * permissions that are granted by the session policies.
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
         * 
         * @param policy
         *        An IAM policy in JSON format that you want to use as an inline session policy.</p>
         *        <p>
         *        You must pass an inline or managed <a
         *        href="https://docs.aws.amazon.com/IAM/latest/UserGuide/access_policies.html#policies_session">session
         *        policy</a> to this operation. You can pass a single JSON policy document to use as an inline session
         *        policy. You can also specify up to 10 managed policy Amazon Resource Names (ARNs) to use as managed
         *        session policies.
         *        </p>
         *        <p>
         *        This parameter is optional. However, if you do not pass any session policies, then the resulting
         *        federated user session has no permissions.
         *        </p>
         *        <p>
         *        When you pass session policies, the session permissions are the intersection of the IAM user policies
         *        and the session policies that you pass. This gives you a way to further restrict the permissions for a
         *        federated user. You cannot use session policies to grant more permissions than those that are defined
         *        in the permissions policy of the IAM user. For more information, see <a
         *        href="https://docs.aws.amazon.com/IAM/latest/UserGuide/access_policies.html#policies_session">Session
         *        Policies</a> in the <i>IAM User Guide</i>.
         *        </p>
         *        <p>
         *        The resulting credentials can be used to access a resource that has a resource-based policy. If that
         *        policy specifically references the federated user session in the <code>Principal</code> element of the
         *        policy, the session has the permissions allowed by the policy. These permissions are granted in
         *        addition to the permissions that are granted by the session policies.
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
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder policy(String policy);

        /**
         * <p>
         * The Amazon Resource Names (ARNs) of the IAM managed policies that you want to use as a managed session
         * policy. The policies must exist in the same account as the IAM user that is requesting federated access.
         * </p>
         * <p>
         * You must pass an inline or managed <a
         * href="https://docs.aws.amazon.com/IAM/latest/UserGuide/access_policies.html#policies_session">session
         * policy</a> to this operation. You can pass a single JSON policy document to use as an inline session policy.
         * You can also specify up to 10 managed policy Amazon Resource Names (ARNs) to use as managed session policies.
         * The plaintext that you use for both inline and managed session policies can't exceed 2,048 characters. You
         * can provide up to 10 managed policy ARNs. For more information about ARNs, see <a
         * href="https://docs.aws.amazon.com/general/latest/gr/aws-arns-and-namespaces.html">Amazon Resource Names
         * (ARNs) and Amazon Web Services Service Namespaces</a> in the Amazon Web Services General Reference.
         * </p>
         * <p>
         * This parameter is optional. However, if you do not pass any session policies, then the resulting federated
         * user session has no permissions.
         * </p>
         * <p>
         * When you pass session policies, the session permissions are the intersection of the IAM user policies and the
         * session policies that you pass. This gives you a way to further restrict the permissions for a federated
         * user. You cannot use session policies to grant more permissions than those that are defined in the
         * permissions policy of the IAM user. For more information, see <a
         * href="https://docs.aws.amazon.com/IAM/latest/UserGuide/access_policies.html#policies_session">Session
         * Policies</a> in the <i>IAM User Guide</i>.
         * </p>
         * <p>
         * The resulting credentials can be used to access a resource that has a resource-based policy. If that policy
         * specifically references the federated user session in the <code>Principal</code> element of the policy, the
         * session has the permissions allowed by the policy. These permissions are granted in addition to the
         * permissions that are granted by the session policies.
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
         * @param policyArns
         *        The Amazon Resource Names (ARNs) of the IAM managed policies that you want to use as a managed session
         *        policy. The policies must exist in the same account as the IAM user that is requesting federated
         *        access.</p>
         *        <p>
         *        You must pass an inline or managed <a
         *        href="https://docs.aws.amazon.com/IAM/latest/UserGuide/access_policies.html#policies_session">session
         *        policy</a> to this operation. You can pass a single JSON policy document to use as an inline session
         *        policy. You can also specify up to 10 managed policy Amazon Resource Names (ARNs) to use as managed
         *        session policies. The plaintext that you use for both inline and managed session policies can't exceed
         *        2,048 characters. You can provide up to 10 managed policy ARNs. For more information about ARNs, see
         *        <a href="https://docs.aws.amazon.com/general/latest/gr/aws-arns-and-namespaces.html">Amazon Resource
         *        Names (ARNs) and Amazon Web Services Service Namespaces</a> in the Amazon Web Services General
         *        Reference.
         *        </p>
         *        <p>
         *        This parameter is optional. However, if you do not pass any session policies, then the resulting
         *        federated user session has no permissions.
         *        </p>
         *        <p>
         *        When you pass session policies, the session permissions are the intersection of the IAM user policies
         *        and the session policies that you pass. This gives you a way to further restrict the permissions for a
         *        federated user. You cannot use session policies to grant more permissions than those that are defined
         *        in the permissions policy of the IAM user. For more information, see <a
         *        href="https://docs.aws.amazon.com/IAM/latest/UserGuide/access_policies.html#policies_session">Session
         *        Policies</a> in the <i>IAM User Guide</i>.
         *        </p>
         *        <p>
         *        The resulting credentials can be used to access a resource that has a resource-based policy. If that
         *        policy specifically references the federated user session in the <code>Principal</code> element of the
         *        policy, the session has the permissions allowed by the policy. These permissions are granted in
         *        addition to the permissions that are granted by the session policies.
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
        Builder policyArns(Collection<PolicyDescriptorType> policyArns);

        /**
         * <p>
         * The Amazon Resource Names (ARNs) of the IAM managed policies that you want to use as a managed session
         * policy. The policies must exist in the same account as the IAM user that is requesting federated access.
         * </p>
         * <p>
         * You must pass an inline or managed <a
         * href="https://docs.aws.amazon.com/IAM/latest/UserGuide/access_policies.html#policies_session">session
         * policy</a> to this operation. You can pass a single JSON policy document to use as an inline session policy.
         * You can also specify up to 10 managed policy Amazon Resource Names (ARNs) to use as managed session policies.
         * The plaintext that you use for both inline and managed session policies can't exceed 2,048 characters. You
         * can provide up to 10 managed policy ARNs. For more information about ARNs, see <a
         * href="https://docs.aws.amazon.com/general/latest/gr/aws-arns-and-namespaces.html">Amazon Resource Names
         * (ARNs) and Amazon Web Services Service Namespaces</a> in the Amazon Web Services General Reference.
         * </p>
         * <p>
         * This parameter is optional. However, if you do not pass any session policies, then the resulting federated
         * user session has no permissions.
         * </p>
         * <p>
         * When you pass session policies, the session permissions are the intersection of the IAM user policies and the
         * session policies that you pass. This gives you a way to further restrict the permissions for a federated
         * user. You cannot use session policies to grant more permissions than those that are defined in the
         * permissions policy of the IAM user. For more information, see <a
         * href="https://docs.aws.amazon.com/IAM/latest/UserGuide/access_policies.html#policies_session">Session
         * Policies</a> in the <i>IAM User Guide</i>.
         * </p>
         * <p>
         * The resulting credentials can be used to access a resource that has a resource-based policy. If that policy
         * specifically references the federated user session in the <code>Principal</code> element of the policy, the
         * session has the permissions allowed by the policy. These permissions are granted in addition to the
         * permissions that are granted by the session policies.
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
         * @param policyArns
         *        The Amazon Resource Names (ARNs) of the IAM managed policies that you want to use as a managed session
         *        policy. The policies must exist in the same account as the IAM user that is requesting federated
         *        access.</p>
         *        <p>
         *        You must pass an inline or managed <a
         *        href="https://docs.aws.amazon.com/IAM/latest/UserGuide/access_policies.html#policies_session">session
         *        policy</a> to this operation. You can pass a single JSON policy document to use as an inline session
         *        policy. You can also specify up to 10 managed policy Amazon Resource Names (ARNs) to use as managed
         *        session policies. The plaintext that you use for both inline and managed session policies can't exceed
         *        2,048 characters. You can provide up to 10 managed policy ARNs. For more information about ARNs, see
         *        <a href="https://docs.aws.amazon.com/general/latest/gr/aws-arns-and-namespaces.html">Amazon Resource
         *        Names (ARNs) and Amazon Web Services Service Namespaces</a> in the Amazon Web Services General
         *        Reference.
         *        </p>
         *        <p>
         *        This parameter is optional. However, if you do not pass any session policies, then the resulting
         *        federated user session has no permissions.
         *        </p>
         *        <p>
         *        When you pass session policies, the session permissions are the intersection of the IAM user policies
         *        and the session policies that you pass. This gives you a way to further restrict the permissions for a
         *        federated user. You cannot use session policies to grant more permissions than those that are defined
         *        in the permissions policy of the IAM user. For more information, see <a
         *        href="https://docs.aws.amazon.com/IAM/latest/UserGuide/access_policies.html#policies_session">Session
         *        Policies</a> in the <i>IAM User Guide</i>.
         *        </p>
         *        <p>
         *        The resulting credentials can be used to access a resource that has a resource-based policy. If that
         *        policy specifically references the federated user session in the <code>Principal</code> element of the
         *        policy, the session has the permissions allowed by the policy. These permissions are granted in
         *        addition to the permissions that are granted by the session policies.
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
        Builder policyArns(PolicyDescriptorType... policyArns);

        /**
         * <p>
         * The Amazon Resource Names (ARNs) of the IAM managed policies that you want to use as a managed session
         * policy. The policies must exist in the same account as the IAM user that is requesting federated access.
         * </p>
         * <p>
         * You must pass an inline or managed <a
         * href="https://docs.aws.amazon.com/IAM/latest/UserGuide/access_policies.html#policies_session">session
         * policy</a> to this operation. You can pass a single JSON policy document to use as an inline session policy.
         * You can also specify up to 10 managed policy Amazon Resource Names (ARNs) to use as managed session policies.
         * The plaintext that you use for both inline and managed session policies can't exceed 2,048 characters. You
         * can provide up to 10 managed policy ARNs. For more information about ARNs, see <a
         * href="https://docs.aws.amazon.com/general/latest/gr/aws-arns-and-namespaces.html">Amazon Resource Names
         * (ARNs) and Amazon Web Services Service Namespaces</a> in the Amazon Web Services General Reference.
         * </p>
         * <p>
         * This parameter is optional. However, if you do not pass any session policies, then the resulting federated
         * user session has no permissions.
         * </p>
         * <p>
         * When you pass session policies, the session permissions are the intersection of the IAM user policies and the
         * session policies that you pass. This gives you a way to further restrict the permissions for a federated
         * user. You cannot use session policies to grant more permissions than those that are defined in the
         * permissions policy of the IAM user. For more information, see <a
         * href="https://docs.aws.amazon.com/IAM/latest/UserGuide/access_policies.html#policies_session">Session
         * Policies</a> in the <i>IAM User Guide</i>.
         * </p>
         * <p>
         * The resulting credentials can be used to access a resource that has a resource-based policy. If that policy
         * specifically references the federated user session in the <code>Principal</code> element of the policy, the
         * session has the permissions allowed by the policy. These permissions are granted in addition to the
         * permissions that are granted by the session policies.
         * </p>
         * <note>
         * <p>
         * An Amazon Web Services conversion compresses the passed inline session policy, managed policy ARNs, and
         * session tags into a packed binary format that has a separate limit. Your request can fail for this limit even
         * if your plaintext meets the other requirements. The <code>PackedPolicySize</code> response element indicates
         * by percentage how close the policies and tags for your request are to the upper size limit.
         * </p>
         * </note> This is a convenience method that creates an instance of the
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
         * The duration, in seconds, that the session should last. Acceptable durations for federation sessions range
         * from 900 seconds (15 minutes) to 129,600 seconds (36 hours), with 43,200 seconds (12 hours) as the default.
         * Sessions obtained using root user credentials are restricted to a maximum of 3,600 seconds (one hour). If the
         * specified duration is longer than one hour, the session obtained by using root user credentials defaults to
         * one hour.
         * </p>
         * 
         * @param durationSeconds
         *        The duration, in seconds, that the session should last. Acceptable durations for federation sessions
         *        range from 900 seconds (15 minutes) to 129,600 seconds (36 hours), with 43,200 seconds (12 hours) as
         *        the default. Sessions obtained using root user credentials are restricted to a maximum of 3,600
         *        seconds (one hour). If the specified duration is longer than one hour, the session obtained by using
         *        root user credentials defaults to one hour.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder durationSeconds(Integer durationSeconds);

        /**
         * <p>
         * A list of session tags. Each session tag consists of a key name and an associated value. For more information
         * about session tags, see <a
         * href="https://docs.aws.amazon.com/IAM/latest/UserGuide/id_session-tags.html">Passing Session Tags in STS</a>
         * in the <i>IAM User Guide</i>.
         * </p>
         * <p>
         * This parameter is optional. You can pass up to 50 session tags. The plaintext session tag keys can’t exceed
         * 128 characters and the values can’t exceed 256 characters. For these and additional limits, see <a href=
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
         * You can pass a session tag with the same key as a tag that is already attached to the user you are
         * federating. When you do, session tags override a user tag with the same key.
         * </p>
         * <p>
         * Tag key–value pairs are not case sensitive, but case is preserved. This means that you cannot have separate
         * <code>Department</code> and <code>department</code> tag keys. Assume that the role has the
         * <code>Department</code>=<code>Marketing</code> tag and you pass the <code>department</code>=
         * <code>engineering</code> session tag. <code>Department</code> and <code>department</code> are not saved as
         * separate tags, and the session tag passed in the request takes precedence over the role tag.
         * </p>
         * 
         * @param tags
         *        A list of session tags. Each session tag consists of a key name and an associated value. For more
         *        information about session tags, see <a
         *        href="https://docs.aws.amazon.com/IAM/latest/UserGuide/id_session-tags.html">Passing Session Tags in
         *        STS</a> in the <i>IAM User Guide</i>.</p>
         *        <p>
         *        This parameter is optional. You can pass up to 50 session tags. The plaintext session tag keys can’t
         *        exceed 128 characters and the values can’t exceed 256 characters. For these and additional limits, see
         *        <a href=
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
         *        You can pass a session tag with the same key as a tag that is already attached to the user you are
         *        federating. When you do, session tags override a user tag with the same key.
         *        </p>
         *        <p>
         *        Tag key–value pairs are not case sensitive, but case is preserved. This means that you cannot have
         *        separate <code>Department</code> and <code>department</code> tag keys. Assume that the role has the
         *        <code>Department</code>=<code>Marketing</code> tag and you pass the <code>department</code>=
         *        <code>engineering</code> session tag. <code>Department</code> and <code>department</code> are not
         *        saved as separate tags, and the session tag passed in the request takes precedence over the role tag.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder tags(Collection<Tag> tags);

        /**
         * <p>
         * A list of session tags. Each session tag consists of a key name and an associated value. For more information
         * about session tags, see <a
         * href="https://docs.aws.amazon.com/IAM/latest/UserGuide/id_session-tags.html">Passing Session Tags in STS</a>
         * in the <i>IAM User Guide</i>.
         * </p>
         * <p>
         * This parameter is optional. You can pass up to 50 session tags. The plaintext session tag keys can’t exceed
         * 128 characters and the values can’t exceed 256 characters. For these and additional limits, see <a href=
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
         * You can pass a session tag with the same key as a tag that is already attached to the user you are
         * federating. When you do, session tags override a user tag with the same key.
         * </p>
         * <p>
         * Tag key–value pairs are not case sensitive, but case is preserved. This means that you cannot have separate
         * <code>Department</code> and <code>department</code> tag keys. Assume that the role has the
         * <code>Department</code>=<code>Marketing</code> tag and you pass the <code>department</code>=
         * <code>engineering</code> session tag. <code>Department</code> and <code>department</code> are not saved as
         * separate tags, and the session tag passed in the request takes precedence over the role tag.
         * </p>
         * 
         * @param tags
         *        A list of session tags. Each session tag consists of a key name and an associated value. For more
         *        information about session tags, see <a
         *        href="https://docs.aws.amazon.com/IAM/latest/UserGuide/id_session-tags.html">Passing Session Tags in
         *        STS</a> in the <i>IAM User Guide</i>.</p>
         *        <p>
         *        This parameter is optional. You can pass up to 50 session tags. The plaintext session tag keys can’t
         *        exceed 128 characters and the values can’t exceed 256 characters. For these and additional limits, see
         *        <a href=
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
         *        You can pass a session tag with the same key as a tag that is already attached to the user you are
         *        federating. When you do, session tags override a user tag with the same key.
         *        </p>
         *        <p>
         *        Tag key–value pairs are not case sensitive, but case is preserved. This means that you cannot have
         *        separate <code>Department</code> and <code>department</code> tag keys. Assume that the role has the
         *        <code>Department</code>=<code>Marketing</code> tag and you pass the <code>department</code>=
         *        <code>engineering</code> session tag. <code>Department</code> and <code>department</code> are not
         *        saved as separate tags, and the session tag passed in the request takes precedence over the role tag.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder tags(Tag... tags);

        /**
         * <p>
         * A list of session tags. Each session tag consists of a key name and an associated value. For more information
         * about session tags, see <a
         * href="https://docs.aws.amazon.com/IAM/latest/UserGuide/id_session-tags.html">Passing Session Tags in STS</a>
         * in the <i>IAM User Guide</i>.
         * </p>
         * <p>
         * This parameter is optional. You can pass up to 50 session tags. The plaintext session tag keys can’t exceed
         * 128 characters and the values can’t exceed 256 characters. For these and additional limits, see <a href=
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
         * You can pass a session tag with the same key as a tag that is already attached to the user you are
         * federating. When you do, session tags override a user tag with the same key.
         * </p>
         * <p>
         * Tag key–value pairs are not case sensitive, but case is preserved. This means that you cannot have separate
         * <code>Department</code> and <code>department</code> tag keys. Assume that the role has the
         * <code>Department</code>=<code>Marketing</code> tag and you pass the <code>department</code>=
         * <code>engineering</code> session tag. <code>Department</code> and <code>department</code> are not saved as
         * separate tags, and the session tag passed in the request takes precedence over the role tag.
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

        @Override
        Builder overrideConfiguration(AwsRequestOverrideConfiguration overrideConfiguration);

        @Override
        Builder overrideConfiguration(Consumer<AwsRequestOverrideConfiguration.Builder> builderConsumer);
    }

    static final class BuilderImpl extends StsRequest.BuilderImpl implements Builder {
        private String name;

        private String policy;

        private List<PolicyDescriptorType> policyArns = DefaultSdkAutoConstructList.getInstance();

        private Integer durationSeconds;

        private List<Tag> tags = DefaultSdkAutoConstructList.getInstance();

        private BuilderImpl() {
        }

        private BuilderImpl(GetFederationTokenRequest model) {
            super(model);
            name(model.name);
            policy(model.policy);
            policyArns(model.policyArns);
            durationSeconds(model.durationSeconds);
            tags(model.tags);
        }

        public final String getName() {
            return name;
        }

        public final void setName(String name) {
            this.name = name;
        }

        @Override
        public final Builder name(String name) {
            this.name = name;
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
        public GetFederationTokenRequest build() {
            return new GetFederationTokenRequest(this);
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
