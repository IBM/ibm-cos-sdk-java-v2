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
public final class ReplicateKeyRequest extends KmsRequest implements
        ToCopyableBuilder<ReplicateKeyRequest.Builder, ReplicateKeyRequest> {
    private static final SdkField<String> KEY_ID_FIELD = SdkField.<String> builder(MarshallingType.STRING).memberName("KeyId")
            .getter(getter(ReplicateKeyRequest::keyId)).setter(setter(Builder::keyId))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("KeyId").build()).build();

    private static final SdkField<String> REPLICA_REGION_FIELD = SdkField.<String> builder(MarshallingType.STRING)
            .memberName("ReplicaRegion").getter(getter(ReplicateKeyRequest::replicaRegion))
            .setter(setter(Builder::replicaRegion))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("ReplicaRegion").build()).build();

    private static final SdkField<String> POLICY_FIELD = SdkField.<String> builder(MarshallingType.STRING).memberName("Policy")
            .getter(getter(ReplicateKeyRequest::policy)).setter(setter(Builder::policy))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("Policy").build()).build();

    private static final SdkField<Boolean> BYPASS_POLICY_LOCKOUT_SAFETY_CHECK_FIELD = SdkField
            .<Boolean> builder(MarshallingType.BOOLEAN)
            .memberName("BypassPolicyLockoutSafetyCheck")
            .getter(getter(ReplicateKeyRequest::bypassPolicyLockoutSafetyCheck))
            .setter(setter(Builder::bypassPolicyLockoutSafetyCheck))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("BypassPolicyLockoutSafetyCheck")
                    .build()).build();

    private static final SdkField<String> DESCRIPTION_FIELD = SdkField.<String> builder(MarshallingType.STRING)
            .memberName("Description").getter(getter(ReplicateKeyRequest::description)).setter(setter(Builder::description))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("Description").build()).build();

    private static final SdkField<List<Tag>> TAGS_FIELD = SdkField
            .<List<Tag>> builder(MarshallingType.LIST)
            .memberName("Tags")
            .getter(getter(ReplicateKeyRequest::tags))
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

    private static final List<SdkField<?>> SDK_FIELDS = Collections.unmodifiableList(Arrays.asList(KEY_ID_FIELD,
            REPLICA_REGION_FIELD, POLICY_FIELD, BYPASS_POLICY_LOCKOUT_SAFETY_CHECK_FIELD, DESCRIPTION_FIELD, TAGS_FIELD));

    private static final Map<String, SdkField<?>> SDK_NAME_TO_FIELD = memberNameToFieldInitializer();

    private final String keyId;

    private final String replicaRegion;

    private final String policy;

    private final Boolean bypassPolicyLockoutSafetyCheck;

    private final String description;

    private final List<Tag> tags;

    private ReplicateKeyRequest(BuilderImpl builder) {
        super(builder);
        this.keyId = builder.keyId;
        this.replicaRegion = builder.replicaRegion;
        this.policy = builder.policy;
        this.bypassPolicyLockoutSafetyCheck = builder.bypassPolicyLockoutSafetyCheck;
        this.description = builder.description;
        this.tags = builder.tags;
    }

    /**
     * <p>
     * Identifies the multi-Region primary key that is being replicated. To determine whether a KMS key is a
     * multi-Region primary key, use the <a>DescribeKey</a> operation to check the value of the
     * <code>MultiRegionKeyType</code> property.
     * </p>
     * <p>
     * Specify the key ID or key ARN of a multi-Region primary key.
     * </p>
     * <p>
     * For example:
     * </p>
     * <ul>
     * <li>
     * <p>
     * Key ID: <code>mrk-1234abcd12ab34cd56ef1234567890ab</code>
     * </p>
     * </li>
     * <li>
     * <p>
     * Key ARN: <code>arn:aws:kms:us-east-2:111122223333:key/mrk-1234abcd12ab34cd56ef1234567890ab</code>
     * </p>
     * </li>
     * </ul>
     * <p>
     * To get the key ID and key ARN for a KMS key, use <a>ListKeys</a> or <a>DescribeKey</a>.
     * </p>
     * 
     * @return Identifies the multi-Region primary key that is being replicated. To determine whether a KMS key is a
     *         multi-Region primary key, use the <a>DescribeKey</a> operation to check the value of the
     *         <code>MultiRegionKeyType</code> property.</p>
     *         <p>
     *         Specify the key ID or key ARN of a multi-Region primary key.
     *         </p>
     *         <p>
     *         For example:
     *         </p>
     *         <ul>
     *         <li>
     *         <p>
     *         Key ID: <code>mrk-1234abcd12ab34cd56ef1234567890ab</code>
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         Key ARN: <code>arn:aws:kms:us-east-2:111122223333:key/mrk-1234abcd12ab34cd56ef1234567890ab</code>
     *         </p>
     *         </li>
     *         </ul>
     *         <p>
     *         To get the key ID and key ARN for a KMS key, use <a>ListKeys</a> or <a>DescribeKey</a>.
     */
    public final String keyId() {
        return keyId;
    }

    /**
     * <p>
     * The Region ID of the Amazon Web Services Region for this replica key.
     * </p>
     * <p>
     * Enter the Region ID, such as <code>us-east-1</code> or <code>ap-southeast-2</code>. For a list of Amazon Web
     * Services Regions in which KMS is supported, see <a
     * href="https://docs.aws.amazon.com/general/latest/gr/kms.html#kms_region">KMS service endpoints</a> in the
     * <i>Amazon Web Services General Reference</i>.
     * </p>
     * <note>
     * <p>
     * HMAC KMS keys are not supported in all Amazon Web Services Regions. If you try to replicate an HMAC KMS key in an
     * Amazon Web Services Region in which HMAC keys are not supported, the <code>ReplicateKey</code> operation returns
     * an <code>UnsupportedOperationException</code>. For a list of Regions in which HMAC KMS keys are supported, see <a
     * href="https://docs.aws.amazon.com/kms/latest/developerguide/hmac.html">HMAC keys in KMS</a> in the <i>Key
     * Management Service Developer Guide</i>.
     * </p>
     * </note>
     * <p>
     * The replica must be in a different Amazon Web Services Region than its primary key and other replicas of that
     * primary key, but in the same Amazon Web Services partition. KMS must be available in the replica Region. If the
     * Region is not enabled by default, the Amazon Web Services account must be enabled in the Region. For information
     * about Amazon Web Services partitions, see <a
     * href="https://docs.aws.amazon.com/general/latest/gr/aws-arns-and-namespaces.html">Amazon Resource Names
     * (ARNs)</a> in the <i>Amazon Web Services General Reference</i>. For information about enabling and disabling
     * Regions, see <a
     * href="https://docs.aws.amazon.com/general/latest/gr/rande-manage.html#rande-manage-enable">Enabling a Region</a>
     * and <a href="https://docs.aws.amazon.com/general/latest/gr/rande-manage.html#rande-manage-disable">Disabling a
     * Region</a> in the <i>Amazon Web Services General Reference</i>.
     * </p>
     * 
     * @return The Region ID of the Amazon Web Services Region for this replica key. </p>
     *         <p>
     *         Enter the Region ID, such as <code>us-east-1</code> or <code>ap-southeast-2</code>. For a list of Amazon
     *         Web Services Regions in which KMS is supported, see <a
     *         href="https://docs.aws.amazon.com/general/latest/gr/kms.html#kms_region">KMS service endpoints</a> in the
     *         <i>Amazon Web Services General Reference</i>.
     *         </p>
     *         <note>
     *         <p>
     *         HMAC KMS keys are not supported in all Amazon Web Services Regions. If you try to replicate an HMAC KMS
     *         key in an Amazon Web Services Region in which HMAC keys are not supported, the <code>ReplicateKey</code>
     *         operation returns an <code>UnsupportedOperationException</code>. For a list of Regions in which HMAC KMS
     *         keys are supported, see <a href="https://docs.aws.amazon.com/kms/latest/developerguide/hmac.html">HMAC
     *         keys in KMS</a> in the <i>Key Management Service Developer Guide</i>.
     *         </p>
     *         </note>
     *         <p>
     *         The replica must be in a different Amazon Web Services Region than its primary key and other replicas of
     *         that primary key, but in the same Amazon Web Services partition. KMS must be available in the replica
     *         Region. If the Region is not enabled by default, the Amazon Web Services account must be enabled in the
     *         Region. For information about Amazon Web Services partitions, see <a
     *         href="https://docs.aws.amazon.com/general/latest/gr/aws-arns-and-namespaces.html">Amazon Resource Names
     *         (ARNs)</a> in the <i>Amazon Web Services General Reference</i>. For information about enabling and
     *         disabling Regions, see <a
     *         href="https://docs.aws.amazon.com/general/latest/gr/rande-manage.html#rande-manage-enable">Enabling a
     *         Region</a> and <a
     *         href="https://docs.aws.amazon.com/general/latest/gr/rande-manage.html#rande-manage-disable">Disabling a
     *         Region</a> in the <i>Amazon Web Services General Reference</i>.
     */
    public final String replicaRegion() {
        return replicaRegion;
    }

    /**
     * <p>
     * The key policy to attach to the KMS key. This parameter is optional. If you do not provide a key policy, KMS
     * attaches the <a
     * href="https://docs.aws.amazon.com/kms/latest/developerguide/key-policies.html#key-policy-default">default key
     * policy</a> to the KMS key.
     * </p>
     * <p>
     * The key policy is not a shared property of multi-Region keys. You can specify the same key policy or a different
     * key policy for each key in a set of related multi-Region keys. KMS does not synchronize this property.
     * </p>
     * <p>
     * If you provide a key policy, it must meet the following criteria:
     * </p>
     * <ul>
     * <li>
     * <p>
     * The key policy must allow the calling principal to make a subsequent <code>PutKeyPolicy</code> request on the KMS
     * key. This reduces the risk that the KMS key becomes unmanageable. For more information, see <a
     * href="https://docs.aws.amazon.com/kms/latest/developerguide/key-policy-default.html#prevent-unmanageable-key"
     * >Default key policy</a> in the <i>Key Management Service Developer Guide</i>. (To omit this condition, set
     * <code>BypassPolicyLockoutSafetyCheck</code> to true.)
     * </p>
     * </li>
     * <li>
     * <p>
     * Each statement in the key policy must contain one or more principals. The principals in the key policy must exist
     * and be visible to KMS. When you create a new Amazon Web Services principal, you might need to enforce a delay
     * before including the new principal in a key policy because the new principal might not be immediately visible to
     * KMS. For more information, see <a href=
     * "https://docs.aws.amazon.com/IAM/latest/UserGuide/troubleshoot_general.html#troubleshoot_general_eventual-consistency"
     * >Changes that I make are not always immediately visible</a> in the <i>Amazon Web Services Identity and Access
     * Management User Guide</i>.
     * </p>
     * </li>
     * </ul>
     * <p>
     * A key policy document can include only the following characters:
     * </p>
     * <ul>
     * <li>
     * <p>
     * Printable ASCII characters from the space character (<code>\u0020</code>) through the end of the ASCII character
     * range.
     * </p>
     * </li>
     * <li>
     * <p>
     * Printable characters in the Basic Latin and Latin-1 Supplement character set (through <code>\u00FF</code>).
     * </p>
     * </li>
     * <li>
     * <p>
     * The tab (<code>\u0009</code>), line feed (<code>\u000A</code>), and carriage return (<code>\u000D</code>) special
     * characters
     * </p>
     * </li>
     * </ul>
     * <p>
     * For information about key policies, see <a
     * href="https://docs.aws.amazon.com/kms/latest/developerguide/key-policies.html">Key policies in KMS</a> in the
     * <i>Key Management Service Developer Guide</i>. For help writing and formatting a JSON policy document, see the <a
     * href="https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_policies.html">IAM JSON Policy Reference</a> in
     * the <i> <i>Identity and Access Management User Guide</i> </i>.
     * </p>
     * 
     * @return The key policy to attach to the KMS key. This parameter is optional. If you do not provide a key policy,
     *         KMS attaches the <a
     *         href="https://docs.aws.amazon.com/kms/latest/developerguide/key-policies.html#key-policy-default">default
     *         key policy</a> to the KMS key.</p>
     *         <p>
     *         The key policy is not a shared property of multi-Region keys. You can specify the same key policy or a
     *         different key policy for each key in a set of related multi-Region keys. KMS does not synchronize this
     *         property.
     *         </p>
     *         <p>
     *         If you provide a key policy, it must meet the following criteria:
     *         </p>
     *         <ul>
     *         <li>
     *         <p>
     *         The key policy must allow the calling principal to make a subsequent <code>PutKeyPolicy</code> request on
     *         the KMS key. This reduces the risk that the KMS key becomes unmanageable. For more information, see <a
     *         href=
     *         "https://docs.aws.amazon.com/kms/latest/developerguide/key-policy-default.html#prevent-unmanageable-key"
     *         >Default key policy</a> in the <i>Key Management Service Developer Guide</i>. (To omit this condition,
     *         set <code>BypassPolicyLockoutSafetyCheck</code> to true.)
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         Each statement in the key policy must contain one or more principals. The principals in the key policy
     *         must exist and be visible to KMS. When you create a new Amazon Web Services principal, you might need to
     *         enforce a delay before including the new principal in a key policy because the new principal might not be
     *         immediately visible to KMS. For more information, see <a href=
     *         "https://docs.aws.amazon.com/IAM/latest/UserGuide/troubleshoot_general.html#troubleshoot_general_eventual-consistency"
     *         >Changes that I make are not always immediately visible</a> in the <i>Amazon Web Services Identity and
     *         Access Management User Guide</i>.
     *         </p>
     *         </li>
     *         </ul>
     *         <p>
     *         A key policy document can include only the following characters:
     *         </p>
     *         <ul>
     *         <li>
     *         <p>
     *         Printable ASCII characters from the space character (<code>\u0020</code>) through the end of the ASCII
     *         character range.
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         Printable characters in the Basic Latin and Latin-1 Supplement character set (through <code>\u00FF</code>
     *         ).
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         The tab (<code>\u0009</code>), line feed (<code>\u000A</code>), and carriage return (<code>\u000D</code>)
     *         special characters
     *         </p>
     *         </li>
     *         </ul>
     *         <p>
     *         For information about key policies, see <a
     *         href="https://docs.aws.amazon.com/kms/latest/developerguide/key-policies.html">Key policies in KMS</a> in
     *         the <i>Key Management Service Developer Guide</i>. For help writing and formatting a JSON policy
     *         document, see the <a href="https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_policies.html">IAM
     *         JSON Policy Reference</a> in the <i> <i>Identity and Access Management User Guide</i> </i>.
     */
    public final String policy() {
        return policy;
    }

    /**
     * <p>
     * Skips ("bypasses") the key policy lockout safety check. The default value is false.
     * </p>
     * <important>
     * <p>
     * Setting this value to true increases the risk that the KMS key becomes unmanageable. Do not set this value to
     * true indiscriminately.
     * </p>
     * <p>
     * For more information, see <a
     * href="https://docs.aws.amazon.com/kms/latest/developerguide/key-policy-default.html#prevent-unmanageable-key"
     * >Default key policy</a> in the <i>Key Management Service Developer Guide</i>.
     * </p>
     * </important>
     * <p>
     * Use this parameter only when you intend to prevent the principal that is making the request from making a
     * subsequent <a href="https://docs.aws.amazon.com/kms/latest/APIReference/API_PutKeyPolicy.html">PutKeyPolicy</a>
     * request on the KMS key.
     * </p>
     * 
     * @return Skips ("bypasses") the key policy lockout safety check. The default value is false.</p> <important>
     *         <p>
     *         Setting this value to true increases the risk that the KMS key becomes unmanageable. Do not set this
     *         value to true indiscriminately.
     *         </p>
     *         <p>
     *         For more information, see <a href=
     *         "https://docs.aws.amazon.com/kms/latest/developerguide/key-policy-default.html#prevent-unmanageable-key"
     *         >Default key policy</a> in the <i>Key Management Service Developer Guide</i>.
     *         </p>
     *         </important>
     *         <p>
     *         Use this parameter only when you intend to prevent the principal that is making the request from making a
     *         subsequent <a
     *         href="https://docs.aws.amazon.com/kms/latest/APIReference/API_PutKeyPolicy.html">PutKeyPolicy</a> request
     *         on the KMS key.
     */
    public final Boolean bypassPolicyLockoutSafetyCheck() {
        return bypassPolicyLockoutSafetyCheck;
    }

    /**
     * <p>
     * A description of the KMS key. The default value is an empty string (no description).
     * </p>
     * <important>
     * <p>
     * Do not include confidential or sensitive information in this field. This field may be displayed in plaintext in
     * CloudTrail logs and other output.
     * </p>
     * </important>
     * <p>
     * The description is not a shared property of multi-Region keys. You can specify the same description or a
     * different description for each key in a set of related multi-Region keys. KMS does not synchronize this property.
     * </p>
     * 
     * @return A description of the KMS key. The default value is an empty string (no description).</p> <important>
     *         <p>
     *         Do not include confidential or sensitive information in this field. This field may be displayed in
     *         plaintext in CloudTrail logs and other output.
     *         </p>
     *         </important>
     *         <p>
     *         The description is not a shared property of multi-Region keys. You can specify the same description or a
     *         different description for each key in a set of related multi-Region keys. KMS does not synchronize this
     *         property.
     */
    public final String description() {
        return description;
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
     * Assigns one or more tags to the replica key. Use this parameter to tag the KMS key when it is created. To tag an
     * existing KMS key, use the <a>TagResource</a> operation.
     * </p>
     * <important>
     * <p>
     * Do not include confidential or sensitive information in this field. This field may be displayed in plaintext in
     * CloudTrail logs and other output.
     * </p>
     * </important> <note>
     * <p>
     * Tagging or untagging a KMS key can allow or deny permission to the KMS key. For details, see <a
     * href="https://docs.aws.amazon.com/kms/latest/developerguide/abac.html">ABAC for KMS</a> in the <i>Key Management
     * Service Developer Guide</i>.
     * </p>
     * </note>
     * <p>
     * To use this parameter, you must have <a
     * href="https://docs.aws.amazon.com/kms/latest/developerguide/kms-api-permissions-reference.html"
     * >kms:TagResource</a> permission in an IAM policy.
     * </p>
     * <p>
     * Tags are not a shared property of multi-Region keys. You can specify the same tags or different tags for each key
     * in a set of related multi-Region keys. KMS does not synchronize this property.
     * </p>
     * <p>
     * Each tag consists of a tag key and a tag value. Both the tag key and the tag value are required, but the tag
     * value can be an empty (null) string. You cannot have more than one tag on a KMS key with the same tag key. If you
     * specify an existing tag key with a different tag value, KMS replaces the current tag value with the specified
     * one.
     * </p>
     * <p>
     * When you add tags to an Amazon Web Services resource, Amazon Web Services generates a cost allocation report with
     * usage and costs aggregated by tags. Tags can also be used to control access to a KMS key. For details, see <a
     * href="https://docs.aws.amazon.com/kms/latest/developerguide/tagging-keys.html">Tagging Keys</a>.
     * </p>
     * <p>
     * Attempts to modify the collection returned by this method will result in an UnsupportedOperationException.
     * </p>
     * <p>
     * This method will never return null. If you would like to know whether the service returned this field (so that
     * you can differentiate between null and empty), you can use the {@link #hasTags} method.
     * </p>
     * 
     * @return Assigns one or more tags to the replica key. Use this parameter to tag the KMS key when it is created. To
     *         tag an existing KMS key, use the <a>TagResource</a> operation.</p> <important>
     *         <p>
     *         Do not include confidential or sensitive information in this field. This field may be displayed in
     *         plaintext in CloudTrail logs and other output.
     *         </p>
     *         </important> <note>
     *         <p>
     *         Tagging or untagging a KMS key can allow or deny permission to the KMS key. For details, see <a
     *         href="https://docs.aws.amazon.com/kms/latest/developerguide/abac.html">ABAC for KMS</a> in the <i>Key
     *         Management Service Developer Guide</i>.
     *         </p>
     *         </note>
     *         <p>
     *         To use this parameter, you must have <a
     *         href="https://docs.aws.amazon.com/kms/latest/developerguide/kms-api-permissions-reference.html"
     *         >kms:TagResource</a> permission in an IAM policy.
     *         </p>
     *         <p>
     *         Tags are not a shared property of multi-Region keys. You can specify the same tags or different tags for
     *         each key in a set of related multi-Region keys. KMS does not synchronize this property.
     *         </p>
     *         <p>
     *         Each tag consists of a tag key and a tag value. Both the tag key and the tag value are required, but the
     *         tag value can be an empty (null) string. You cannot have more than one tag on a KMS key with the same tag
     *         key. If you specify an existing tag key with a different tag value, KMS replaces the current tag value
     *         with the specified one.
     *         </p>
     *         <p>
     *         When you add tags to an Amazon Web Services resource, Amazon Web Services generates a cost allocation
     *         report with usage and costs aggregated by tags. Tags can also be used to control access to a KMS key. For
     *         details, see <a href="https://docs.aws.amazon.com/kms/latest/developerguide/tagging-keys.html">Tagging
     *         Keys</a>.
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
        hashCode = 31 * hashCode + Objects.hashCode(keyId());
        hashCode = 31 * hashCode + Objects.hashCode(replicaRegion());
        hashCode = 31 * hashCode + Objects.hashCode(policy());
        hashCode = 31 * hashCode + Objects.hashCode(bypassPolicyLockoutSafetyCheck());
        hashCode = 31 * hashCode + Objects.hashCode(description());
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
        if (!(obj instanceof ReplicateKeyRequest)) {
            return false;
        }
        ReplicateKeyRequest other = (ReplicateKeyRequest) obj;
        return Objects.equals(keyId(), other.keyId()) && Objects.equals(replicaRegion(), other.replicaRegion())
                && Objects.equals(policy(), other.policy())
                && Objects.equals(bypassPolicyLockoutSafetyCheck(), other.bypassPolicyLockoutSafetyCheck())
                && Objects.equals(description(), other.description()) && hasTags() == other.hasTags()
                && Objects.equals(tags(), other.tags());
    }

    /**
     * Returns a string representation of this object. This is useful for testing and debugging. Sensitive data will be
     * redacted from this string using a placeholder value.
     */
    @Override
    public final String toString() {
        return ToString.builder("ReplicateKeyRequest").add("KeyId", keyId()).add("ReplicaRegion", replicaRegion())
                .add("Policy", policy()).add("BypassPolicyLockoutSafetyCheck", bypassPolicyLockoutSafetyCheck())
                .add("Description", description()).add("Tags", hasTags() ? tags() : null).build();
    }

    public final <T> Optional<T> getValueForField(String fieldName, Class<T> clazz) {
        switch (fieldName) {
        case "KeyId":
            return Optional.ofNullable(clazz.cast(keyId()));
        case "ReplicaRegion":
            return Optional.ofNullable(clazz.cast(replicaRegion()));
        case "Policy":
            return Optional.ofNullable(clazz.cast(policy()));
        case "BypassPolicyLockoutSafetyCheck":
            return Optional.ofNullable(clazz.cast(bypassPolicyLockoutSafetyCheck()));
        case "Description":
            return Optional.ofNullable(clazz.cast(description()));
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
        map.put("KeyId", KEY_ID_FIELD);
        map.put("ReplicaRegion", REPLICA_REGION_FIELD);
        map.put("Policy", POLICY_FIELD);
        map.put("BypassPolicyLockoutSafetyCheck", BYPASS_POLICY_LOCKOUT_SAFETY_CHECK_FIELD);
        map.put("Description", DESCRIPTION_FIELD);
        map.put("Tags", TAGS_FIELD);
        return Collections.unmodifiableMap(map);
    }

    private static <T> Function<Object, T> getter(Function<ReplicateKeyRequest, T> g) {
        return obj -> g.apply((ReplicateKeyRequest) obj);
    }

    private static <T> BiConsumer<Object, T> setter(BiConsumer<Builder, T> s) {
        return (obj, val) -> s.accept((Builder) obj, val);
    }

    @Mutable
    @NotThreadSafe
    public interface Builder extends KmsRequest.Builder, SdkPojo, CopyableBuilder<Builder, ReplicateKeyRequest> {
        /**
         * <p>
         * Identifies the multi-Region primary key that is being replicated. To determine whether a KMS key is a
         * multi-Region primary key, use the <a>DescribeKey</a> operation to check the value of the
         * <code>MultiRegionKeyType</code> property.
         * </p>
         * <p>
         * Specify the key ID or key ARN of a multi-Region primary key.
         * </p>
         * <p>
         * For example:
         * </p>
         * <ul>
         * <li>
         * <p>
         * Key ID: <code>mrk-1234abcd12ab34cd56ef1234567890ab</code>
         * </p>
         * </li>
         * <li>
         * <p>
         * Key ARN: <code>arn:aws:kms:us-east-2:111122223333:key/mrk-1234abcd12ab34cd56ef1234567890ab</code>
         * </p>
         * </li>
         * </ul>
         * <p>
         * To get the key ID and key ARN for a KMS key, use <a>ListKeys</a> or <a>DescribeKey</a>.
         * </p>
         * 
         * @param keyId
         *        Identifies the multi-Region primary key that is being replicated. To determine whether a KMS key is a
         *        multi-Region primary key, use the <a>DescribeKey</a> operation to check the value of the
         *        <code>MultiRegionKeyType</code> property.</p>
         *        <p>
         *        Specify the key ID or key ARN of a multi-Region primary key.
         *        </p>
         *        <p>
         *        For example:
         *        </p>
         *        <ul>
         *        <li>
         *        <p>
         *        Key ID: <code>mrk-1234abcd12ab34cd56ef1234567890ab</code>
         *        </p>
         *        </li>
         *        <li>
         *        <p>
         *        Key ARN: <code>arn:aws:kms:us-east-2:111122223333:key/mrk-1234abcd12ab34cd56ef1234567890ab</code>
         *        </p>
         *        </li>
         *        </ul>
         *        <p>
         *        To get the key ID and key ARN for a KMS key, use <a>ListKeys</a> or <a>DescribeKey</a>.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder keyId(String keyId);

        /**
         * <p>
         * The Region ID of the Amazon Web Services Region for this replica key.
         * </p>
         * <p>
         * Enter the Region ID, such as <code>us-east-1</code> or <code>ap-southeast-2</code>. For a list of Amazon Web
         * Services Regions in which KMS is supported, see <a
         * href="https://docs.aws.amazon.com/general/latest/gr/kms.html#kms_region">KMS service endpoints</a> in the
         * <i>Amazon Web Services General Reference</i>.
         * </p>
         * <note>
         * <p>
         * HMAC KMS keys are not supported in all Amazon Web Services Regions. If you try to replicate an HMAC KMS key
         * in an Amazon Web Services Region in which HMAC keys are not supported, the <code>ReplicateKey</code>
         * operation returns an <code>UnsupportedOperationException</code>. For a list of Regions in which HMAC KMS keys
         * are supported, see <a href="https://docs.aws.amazon.com/kms/latest/developerguide/hmac.html">HMAC keys in
         * KMS</a> in the <i>Key Management Service Developer Guide</i>.
         * </p>
         * </note>
         * <p>
         * The replica must be in a different Amazon Web Services Region than its primary key and other replicas of that
         * primary key, but in the same Amazon Web Services partition. KMS must be available in the replica Region. If
         * the Region is not enabled by default, the Amazon Web Services account must be enabled in the Region. For
         * information about Amazon Web Services partitions, see <a
         * href="https://docs.aws.amazon.com/general/latest/gr/aws-arns-and-namespaces.html">Amazon Resource Names
         * (ARNs)</a> in the <i>Amazon Web Services General Reference</i>. For information about enabling and disabling
         * Regions, see <a
         * href="https://docs.aws.amazon.com/general/latest/gr/rande-manage.html#rande-manage-enable">Enabling a
         * Region</a> and <a
         * href="https://docs.aws.amazon.com/general/latest/gr/rande-manage.html#rande-manage-disable">Disabling a
         * Region</a> in the <i>Amazon Web Services General Reference</i>.
         * </p>
         * 
         * @param replicaRegion
         *        The Region ID of the Amazon Web Services Region for this replica key. </p>
         *        <p>
         *        Enter the Region ID, such as <code>us-east-1</code> or <code>ap-southeast-2</code>. For a list of
         *        Amazon Web Services Regions in which KMS is supported, see <a
         *        href="https://docs.aws.amazon.com/general/latest/gr/kms.html#kms_region">KMS service endpoints</a> in
         *        the <i>Amazon Web Services General Reference</i>.
         *        </p>
         *        <note>
         *        <p>
         *        HMAC KMS keys are not supported in all Amazon Web Services Regions. If you try to replicate an HMAC
         *        KMS key in an Amazon Web Services Region in which HMAC keys are not supported, the
         *        <code>ReplicateKey</code> operation returns an <code>UnsupportedOperationException</code>. For a list
         *        of Regions in which HMAC KMS keys are supported, see <a
         *        href="https://docs.aws.amazon.com/kms/latest/developerguide/hmac.html">HMAC keys in KMS</a> in the
         *        <i>Key Management Service Developer Guide</i>.
         *        </p>
         *        </note>
         *        <p>
         *        The replica must be in a different Amazon Web Services Region than its primary key and other replicas
         *        of that primary key, but in the same Amazon Web Services partition. KMS must be available in the
         *        replica Region. If the Region is not enabled by default, the Amazon Web Services account must be
         *        enabled in the Region. For information about Amazon Web Services partitions, see <a
         *        href="https://docs.aws.amazon.com/general/latest/gr/aws-arns-and-namespaces.html">Amazon Resource
         *        Names (ARNs)</a> in the <i>Amazon Web Services General Reference</i>. For information about enabling
         *        and disabling Regions, see <a
         *        href="https://docs.aws.amazon.com/general/latest/gr/rande-manage.html#rande-manage-enable">Enabling a
         *        Region</a> and <a
         *        href="https://docs.aws.amazon.com/general/latest/gr/rande-manage.html#rande-manage-disable">Disabling
         *        a Region</a> in the <i>Amazon Web Services General Reference</i>.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder replicaRegion(String replicaRegion);

        /**
         * <p>
         * The key policy to attach to the KMS key. This parameter is optional. If you do not provide a key policy, KMS
         * attaches the <a
         * href="https://docs.aws.amazon.com/kms/latest/developerguide/key-policies.html#key-policy-default">default key
         * policy</a> to the KMS key.
         * </p>
         * <p>
         * The key policy is not a shared property of multi-Region keys. You can specify the same key policy or a
         * different key policy for each key in a set of related multi-Region keys. KMS does not synchronize this
         * property.
         * </p>
         * <p>
         * If you provide a key policy, it must meet the following criteria:
         * </p>
         * <ul>
         * <li>
         * <p>
         * The key policy must allow the calling principal to make a subsequent <code>PutKeyPolicy</code> request on the
         * KMS key. This reduces the risk that the KMS key becomes unmanageable. For more information, see <a href=
         * "https://docs.aws.amazon.com/kms/latest/developerguide/key-policy-default.html#prevent-unmanageable-key"
         * >Default key policy</a> in the <i>Key Management Service Developer Guide</i>. (To omit this condition, set
         * <code>BypassPolicyLockoutSafetyCheck</code> to true.)
         * </p>
         * </li>
         * <li>
         * <p>
         * Each statement in the key policy must contain one or more principals. The principals in the key policy must
         * exist and be visible to KMS. When you create a new Amazon Web Services principal, you might need to enforce a
         * delay before including the new principal in a key policy because the new principal might not be immediately
         * visible to KMS. For more information, see <a href=
         * "https://docs.aws.amazon.com/IAM/latest/UserGuide/troubleshoot_general.html#troubleshoot_general_eventual-consistency"
         * >Changes that I make are not always immediately visible</a> in the <i>Amazon Web Services Identity and Access
         * Management User Guide</i>.
         * </p>
         * </li>
         * </ul>
         * <p>
         * A key policy document can include only the following characters:
         * </p>
         * <ul>
         * <li>
         * <p>
         * Printable ASCII characters from the space character (<code>\u0020</code>) through the end of the ASCII
         * character range.
         * </p>
         * </li>
         * <li>
         * <p>
         * Printable characters in the Basic Latin and Latin-1 Supplement character set (through <code>\u00FF</code>).
         * </p>
         * </li>
         * <li>
         * <p>
         * The tab (<code>\u0009</code>), line feed (<code>\u000A</code>), and carriage return (<code>\u000D</code>)
         * special characters
         * </p>
         * </li>
         * </ul>
         * <p>
         * For information about key policies, see <a
         * href="https://docs.aws.amazon.com/kms/latest/developerguide/key-policies.html">Key policies in KMS</a> in the
         * <i>Key Management Service Developer Guide</i>. For help writing and formatting a JSON policy document, see
         * the <a href="https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_policies.html">IAM JSON Policy
         * Reference</a> in the <i> <i>Identity and Access Management User Guide</i> </i>.
         * </p>
         * 
         * @param policy
         *        The key policy to attach to the KMS key. This parameter is optional. If you do not provide a key
         *        policy, KMS attaches the <a
         *        href="https://docs.aws.amazon.com/kms/latest/developerguide/key-policies.html#key-policy-default"
         *        >default key policy</a> to the KMS key.</p>
         *        <p>
         *        The key policy is not a shared property of multi-Region keys. You can specify the same key policy or a
         *        different key policy for each key in a set of related multi-Region keys. KMS does not synchronize this
         *        property.
         *        </p>
         *        <p>
         *        If you provide a key policy, it must meet the following criteria:
         *        </p>
         *        <ul>
         *        <li>
         *        <p>
         *        The key policy must allow the calling principal to make a subsequent <code>PutKeyPolicy</code> request
         *        on the KMS key. This reduces the risk that the KMS key becomes unmanageable. For more information, see
         *        <a href=
         *        "https://docs.aws.amazon.com/kms/latest/developerguide/key-policy-default.html#prevent-unmanageable-key"
         *        >Default key policy</a> in the <i>Key Management Service Developer Guide</i>. (To omit this condition,
         *        set <code>BypassPolicyLockoutSafetyCheck</code> to true.)
         *        </p>
         *        </li>
         *        <li>
         *        <p>
         *        Each statement in the key policy must contain one or more principals. The principals in the key policy
         *        must exist and be visible to KMS. When you create a new Amazon Web Services principal, you might need
         *        to enforce a delay before including the new principal in a key policy because the new principal might
         *        not be immediately visible to KMS. For more information, see <a href=
         *        "https://docs.aws.amazon.com/IAM/latest/UserGuide/troubleshoot_general.html#troubleshoot_general_eventual-consistency"
         *        >Changes that I make are not always immediately visible</a> in the <i>Amazon Web Services Identity and
         *        Access Management User Guide</i>.
         *        </p>
         *        </li>
         *        </ul>
         *        <p>
         *        A key policy document can include only the following characters:
         *        </p>
         *        <ul>
         *        <li>
         *        <p>
         *        Printable ASCII characters from the space character (<code>\u0020</code>) through the end of the ASCII
         *        character range.
         *        </p>
         *        </li>
         *        <li>
         *        <p>
         *        Printable characters in the Basic Latin and Latin-1 Supplement character set (through
         *        <code>\u00FF</code>).
         *        </p>
         *        </li>
         *        <li>
         *        <p>
         *        The tab (<code>\u0009</code>), line feed (<code>\u000A</code>), and carriage return (<code>\u000D</code>
         *        ) special characters
         *        </p>
         *        </li>
         *        </ul>
         *        <p>
         *        For information about key policies, see <a
         *        href="https://docs.aws.amazon.com/kms/latest/developerguide/key-policies.html">Key policies in KMS</a>
         *        in the <i>Key Management Service Developer Guide</i>. For help writing and formatting a JSON policy
         *        document, see the <a
         *        href="https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_policies.html">IAM JSON Policy
         *        Reference</a> in the <i> <i>Identity and Access Management User Guide</i> </i>.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder policy(String policy);

        /**
         * <p>
         * Skips ("bypasses") the key policy lockout safety check. The default value is false.
         * </p>
         * <important>
         * <p>
         * Setting this value to true increases the risk that the KMS key becomes unmanageable. Do not set this value to
         * true indiscriminately.
         * </p>
         * <p>
         * For more information, see <a href=
         * "https://docs.aws.amazon.com/kms/latest/developerguide/key-policy-default.html#prevent-unmanageable-key"
         * >Default key policy</a> in the <i>Key Management Service Developer Guide</i>.
         * </p>
         * </important>
         * <p>
         * Use this parameter only when you intend to prevent the principal that is making the request from making a
         * subsequent <a
         * href="https://docs.aws.amazon.com/kms/latest/APIReference/API_PutKeyPolicy.html">PutKeyPolicy</a> request on
         * the KMS key.
         * </p>
         * 
         * @param bypassPolicyLockoutSafetyCheck
         *        Skips ("bypasses") the key policy lockout safety check. The default value is false.</p> <important>
         *        <p>
         *        Setting this value to true increases the risk that the KMS key becomes unmanageable. Do not set this
         *        value to true indiscriminately.
         *        </p>
         *        <p>
         *        For more information, see <a href=
         *        "https://docs.aws.amazon.com/kms/latest/developerguide/key-policy-default.html#prevent-unmanageable-key"
         *        >Default key policy</a> in the <i>Key Management Service Developer Guide</i>.
         *        </p>
         *        </important>
         *        <p>
         *        Use this parameter only when you intend to prevent the principal that is making the request from
         *        making a subsequent <a
         *        href="https://docs.aws.amazon.com/kms/latest/APIReference/API_PutKeyPolicy.html">PutKeyPolicy</a>
         *        request on the KMS key.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder bypassPolicyLockoutSafetyCheck(Boolean bypassPolicyLockoutSafetyCheck);

        /**
         * <p>
         * A description of the KMS key. The default value is an empty string (no description).
         * </p>
         * <important>
         * <p>
         * Do not include confidential or sensitive information in this field. This field may be displayed in plaintext
         * in CloudTrail logs and other output.
         * </p>
         * </important>
         * <p>
         * The description is not a shared property of multi-Region keys. You can specify the same description or a
         * different description for each key in a set of related multi-Region keys. KMS does not synchronize this
         * property.
         * </p>
         * 
         * @param description
         *        A description of the KMS key. The default value is an empty string (no description).</p> <important>
         *        <p>
         *        Do not include confidential or sensitive information in this field. This field may be displayed in
         *        plaintext in CloudTrail logs and other output.
         *        </p>
         *        </important>
         *        <p>
         *        The description is not a shared property of multi-Region keys. You can specify the same description or
         *        a different description for each key in a set of related multi-Region keys. KMS does not synchronize
         *        this property.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder description(String description);

        /**
         * <p>
         * Assigns one or more tags to the replica key. Use this parameter to tag the KMS key when it is created. To tag
         * an existing KMS key, use the <a>TagResource</a> operation.
         * </p>
         * <important>
         * <p>
         * Do not include confidential or sensitive information in this field. This field may be displayed in plaintext
         * in CloudTrail logs and other output.
         * </p>
         * </important> <note>
         * <p>
         * Tagging or untagging a KMS key can allow or deny permission to the KMS key. For details, see <a
         * href="https://docs.aws.amazon.com/kms/latest/developerguide/abac.html">ABAC for KMS</a> in the <i>Key
         * Management Service Developer Guide</i>.
         * </p>
         * </note>
         * <p>
         * To use this parameter, you must have <a
         * href="https://docs.aws.amazon.com/kms/latest/developerguide/kms-api-permissions-reference.html"
         * >kms:TagResource</a> permission in an IAM policy.
         * </p>
         * <p>
         * Tags are not a shared property of multi-Region keys. You can specify the same tags or different tags for each
         * key in a set of related multi-Region keys. KMS does not synchronize this property.
         * </p>
         * <p>
         * Each tag consists of a tag key and a tag value. Both the tag key and the tag value are required, but the tag
         * value can be an empty (null) string. You cannot have more than one tag on a KMS key with the same tag key. If
         * you specify an existing tag key with a different tag value, KMS replaces the current tag value with the
         * specified one.
         * </p>
         * <p>
         * When you add tags to an Amazon Web Services resource, Amazon Web Services generates a cost allocation report
         * with usage and costs aggregated by tags. Tags can also be used to control access to a KMS key. For details,
         * see <a href="https://docs.aws.amazon.com/kms/latest/developerguide/tagging-keys.html">Tagging Keys</a>.
         * </p>
         * 
         * @param tags
         *        Assigns one or more tags to the replica key. Use this parameter to tag the KMS key when it is created.
         *        To tag an existing KMS key, use the <a>TagResource</a> operation.</p> <important>
         *        <p>
         *        Do not include confidential or sensitive information in this field. This field may be displayed in
         *        plaintext in CloudTrail logs and other output.
         *        </p>
         *        </important> <note>
         *        <p>
         *        Tagging or untagging a KMS key can allow or deny permission to the KMS key. For details, see <a
         *        href="https://docs.aws.amazon.com/kms/latest/developerguide/abac.html">ABAC for KMS</a> in the <i>Key
         *        Management Service Developer Guide</i>.
         *        </p>
         *        </note>
         *        <p>
         *        To use this parameter, you must have <a
         *        href="https://docs.aws.amazon.com/kms/latest/developerguide/kms-api-permissions-reference.html"
         *        >kms:TagResource</a> permission in an IAM policy.
         *        </p>
         *        <p>
         *        Tags are not a shared property of multi-Region keys. You can specify the same tags or different tags
         *        for each key in a set of related multi-Region keys. KMS does not synchronize this property.
         *        </p>
         *        <p>
         *        Each tag consists of a tag key and a tag value. Both the tag key and the tag value are required, but
         *        the tag value can be an empty (null) string. You cannot have more than one tag on a KMS key with the
         *        same tag key. If you specify an existing tag key with a different tag value, KMS replaces the current
         *        tag value with the specified one.
         *        </p>
         *        <p>
         *        When you add tags to an Amazon Web Services resource, Amazon Web Services generates a cost allocation
         *        report with usage and costs aggregated by tags. Tags can also be used to control access to a KMS key.
         *        For details, see <a
         *        href="https://docs.aws.amazon.com/kms/latest/developerguide/tagging-keys.html">Tagging Keys</a>.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder tags(Collection<Tag> tags);

        /**
         * <p>
         * Assigns one or more tags to the replica key. Use this parameter to tag the KMS key when it is created. To tag
         * an existing KMS key, use the <a>TagResource</a> operation.
         * </p>
         * <important>
         * <p>
         * Do not include confidential or sensitive information in this field. This field may be displayed in plaintext
         * in CloudTrail logs and other output.
         * </p>
         * </important> <note>
         * <p>
         * Tagging or untagging a KMS key can allow or deny permission to the KMS key. For details, see <a
         * href="https://docs.aws.amazon.com/kms/latest/developerguide/abac.html">ABAC for KMS</a> in the <i>Key
         * Management Service Developer Guide</i>.
         * </p>
         * </note>
         * <p>
         * To use this parameter, you must have <a
         * href="https://docs.aws.amazon.com/kms/latest/developerguide/kms-api-permissions-reference.html"
         * >kms:TagResource</a> permission in an IAM policy.
         * </p>
         * <p>
         * Tags are not a shared property of multi-Region keys. You can specify the same tags or different tags for each
         * key in a set of related multi-Region keys. KMS does not synchronize this property.
         * </p>
         * <p>
         * Each tag consists of a tag key and a tag value. Both the tag key and the tag value are required, but the tag
         * value can be an empty (null) string. You cannot have more than one tag on a KMS key with the same tag key. If
         * you specify an existing tag key with a different tag value, KMS replaces the current tag value with the
         * specified one.
         * </p>
         * <p>
         * When you add tags to an Amazon Web Services resource, Amazon Web Services generates a cost allocation report
         * with usage and costs aggregated by tags. Tags can also be used to control access to a KMS key. For details,
         * see <a href="https://docs.aws.amazon.com/kms/latest/developerguide/tagging-keys.html">Tagging Keys</a>.
         * </p>
         * 
         * @param tags
         *        Assigns one or more tags to the replica key. Use this parameter to tag the KMS key when it is created.
         *        To tag an existing KMS key, use the <a>TagResource</a> operation.</p> <important>
         *        <p>
         *        Do not include confidential or sensitive information in this field. This field may be displayed in
         *        plaintext in CloudTrail logs and other output.
         *        </p>
         *        </important> <note>
         *        <p>
         *        Tagging or untagging a KMS key can allow or deny permission to the KMS key. For details, see <a
         *        href="https://docs.aws.amazon.com/kms/latest/developerguide/abac.html">ABAC for KMS</a> in the <i>Key
         *        Management Service Developer Guide</i>.
         *        </p>
         *        </note>
         *        <p>
         *        To use this parameter, you must have <a
         *        href="https://docs.aws.amazon.com/kms/latest/developerguide/kms-api-permissions-reference.html"
         *        >kms:TagResource</a> permission in an IAM policy.
         *        </p>
         *        <p>
         *        Tags are not a shared property of multi-Region keys. You can specify the same tags or different tags
         *        for each key in a set of related multi-Region keys. KMS does not synchronize this property.
         *        </p>
         *        <p>
         *        Each tag consists of a tag key and a tag value. Both the tag key and the tag value are required, but
         *        the tag value can be an empty (null) string. You cannot have more than one tag on a KMS key with the
         *        same tag key. If you specify an existing tag key with a different tag value, KMS replaces the current
         *        tag value with the specified one.
         *        </p>
         *        <p>
         *        When you add tags to an Amazon Web Services resource, Amazon Web Services generates a cost allocation
         *        report with usage and costs aggregated by tags. Tags can also be used to control access to a KMS key.
         *        For details, see <a
         *        href="https://docs.aws.amazon.com/kms/latest/developerguide/tagging-keys.html">Tagging Keys</a>.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder tags(Tag... tags);

        /**
         * <p>
         * Assigns one or more tags to the replica key. Use this parameter to tag the KMS key when it is created. To tag
         * an existing KMS key, use the <a>TagResource</a> operation.
         * </p>
         * <important>
         * <p>
         * Do not include confidential or sensitive information in this field. This field may be displayed in plaintext
         * in CloudTrail logs and other output.
         * </p>
         * </important> <note>
         * <p>
         * Tagging or untagging a KMS key can allow or deny permission to the KMS key. For details, see <a
         * href="https://docs.aws.amazon.com/kms/latest/developerguide/abac.html">ABAC for KMS</a> in the <i>Key
         * Management Service Developer Guide</i>.
         * </p>
         * </note>
         * <p>
         * To use this parameter, you must have <a
         * href="https://docs.aws.amazon.com/kms/latest/developerguide/kms-api-permissions-reference.html"
         * >kms:TagResource</a> permission in an IAM policy.
         * </p>
         * <p>
         * Tags are not a shared property of multi-Region keys. You can specify the same tags or different tags for each
         * key in a set of related multi-Region keys. KMS does not synchronize this property.
         * </p>
         * <p>
         * Each tag consists of a tag key and a tag value. Both the tag key and the tag value are required, but the tag
         * value can be an empty (null) string. You cannot have more than one tag on a KMS key with the same tag key. If
         * you specify an existing tag key with a different tag value, KMS replaces the current tag value with the
         * specified one.
         * </p>
         * <p>
         * When you add tags to an Amazon Web Services resource, Amazon Web Services generates a cost allocation report
         * with usage and costs aggregated by tags. Tags can also be used to control access to a KMS key. For details,
         * see <a href="https://docs.aws.amazon.com/kms/latest/developerguide/tagging-keys.html">Tagging Keys</a>.
         * </p>
         * This is a convenience method that creates an instance of the
         * {@link com.ibm.cos.v2.services.kms.model.Tag.Builder} avoiding the need to create one manually via
         * {@link com.ibm.cos.v2.services.kms.model.Tag#builder()}.
         *
         * <p>
         * When the {@link Consumer} completes, {@link com.ibm.cos.v2.services.kms.model.Tag.Builder#build()} is
         * called immediately and its result is passed to {@link #tags(List<Tag>)}.
         * 
         * @param tags
         *        a consumer that will call methods on {@link com.ibm.cos.v2.services.kms.model.Tag.Builder}
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see #tags(java.util.Collection<Tag>)
         */
        Builder tags(Consumer<Tag.Builder>... tags);

        @Override
        Builder overrideConfiguration(AwsRequestOverrideConfiguration overrideConfiguration);

        @Override
        Builder overrideConfiguration(Consumer<AwsRequestOverrideConfiguration.Builder> builderConsumer);
    }

    static final class BuilderImpl extends KmsRequest.BuilderImpl implements Builder {
        private String keyId;

        private String replicaRegion;

        private String policy;

        private Boolean bypassPolicyLockoutSafetyCheck;

        private String description;

        private List<Tag> tags = DefaultSdkAutoConstructList.getInstance();

        private BuilderImpl() {
        }

        private BuilderImpl(ReplicateKeyRequest model) {
            super(model);
            keyId(model.keyId);
            replicaRegion(model.replicaRegion);
            policy(model.policy);
            bypassPolicyLockoutSafetyCheck(model.bypassPolicyLockoutSafetyCheck);
            description(model.description);
            tags(model.tags);
        }

        public final String getKeyId() {
            return keyId;
        }

        public final void setKeyId(String keyId) {
            this.keyId = keyId;
        }

        @Override
        public final Builder keyId(String keyId) {
            this.keyId = keyId;
            return this;
        }

        public final String getReplicaRegion() {
            return replicaRegion;
        }

        public final void setReplicaRegion(String replicaRegion) {
            this.replicaRegion = replicaRegion;
        }

        @Override
        public final Builder replicaRegion(String replicaRegion) {
            this.replicaRegion = replicaRegion;
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

        public final Boolean getBypassPolicyLockoutSafetyCheck() {
            return bypassPolicyLockoutSafetyCheck;
        }

        public final void setBypassPolicyLockoutSafetyCheck(Boolean bypassPolicyLockoutSafetyCheck) {
            this.bypassPolicyLockoutSafetyCheck = bypassPolicyLockoutSafetyCheck;
        }

        @Override
        public final Builder bypassPolicyLockoutSafetyCheck(Boolean bypassPolicyLockoutSafetyCheck) {
            this.bypassPolicyLockoutSafetyCheck = bypassPolicyLockoutSafetyCheck;
            return this;
        }

        public final String getDescription() {
            return description;
        }

        public final void setDescription(String description) {
            this.description = description;
        }

        @Override
        public final Builder description(String description) {
            this.description = description;
            return this;
        }

        public final List<Tag.Builder> getTags() {
            List<Tag.Builder> result = TagListCopier.copyToBuilder(this.tags);
            if (result instanceof SdkAutoConstructList) {
                return null;
            }
            return result;
        }

        public final void setTags(Collection<Tag.BuilderImpl> tags) {
            this.tags = TagListCopier.copyFromBuilder(tags);
        }

        @Override
        public final Builder tags(Collection<Tag> tags) {
            this.tags = TagListCopier.copy(tags);
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
        public ReplicateKeyRequest build() {
            return new ReplicateKeyRequest(this);
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
