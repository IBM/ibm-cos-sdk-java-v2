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
public final class PutKeyPolicyRequest extends KmsRequest implements
        ToCopyableBuilder<PutKeyPolicyRequest.Builder, PutKeyPolicyRequest> {
    private static final SdkField<String> KEY_ID_FIELD = SdkField.<String> builder(MarshallingType.STRING).memberName("KeyId")
            .getter(getter(PutKeyPolicyRequest::keyId)).setter(setter(Builder::keyId))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("KeyId").build()).build();

    private static final SdkField<String> POLICY_NAME_FIELD = SdkField.<String> builder(MarshallingType.STRING)
            .memberName("PolicyName").getter(getter(PutKeyPolicyRequest::policyName)).setter(setter(Builder::policyName))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("PolicyName").build()).build();

    private static final SdkField<String> POLICY_FIELD = SdkField.<String> builder(MarshallingType.STRING).memberName("Policy")
            .getter(getter(PutKeyPolicyRequest::policy)).setter(setter(Builder::policy))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("Policy").build()).build();

    private static final SdkField<Boolean> BYPASS_POLICY_LOCKOUT_SAFETY_CHECK_FIELD = SdkField
            .<Boolean> builder(MarshallingType.BOOLEAN)
            .memberName("BypassPolicyLockoutSafetyCheck")
            .getter(getter(PutKeyPolicyRequest::bypassPolicyLockoutSafetyCheck))
            .setter(setter(Builder::bypassPolicyLockoutSafetyCheck))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("BypassPolicyLockoutSafetyCheck")
                    .build()).build();

    private static final List<SdkField<?>> SDK_FIELDS = Collections.unmodifiableList(Arrays.asList(KEY_ID_FIELD,
            POLICY_NAME_FIELD, POLICY_FIELD, BYPASS_POLICY_LOCKOUT_SAFETY_CHECK_FIELD));

    private static final Map<String, SdkField<?>> SDK_NAME_TO_FIELD = memberNameToFieldInitializer();

    private final String keyId;

    private final String policyName;

    private final String policy;

    private final Boolean bypassPolicyLockoutSafetyCheck;

    private PutKeyPolicyRequest(BuilderImpl builder) {
        super(builder);
        this.keyId = builder.keyId;
        this.policyName = builder.policyName;
        this.policy = builder.policy;
        this.bypassPolicyLockoutSafetyCheck = builder.bypassPolicyLockoutSafetyCheck;
    }

    /**
     * <p>
     * Sets the key policy on the specified KMS key.
     * </p>
     * <p>
     * Specify the key ID or key ARN of the KMS key.
     * </p>
     * <p>
     * For example:
     * </p>
     * <ul>
     * <li>
     * <p>
     * Key ID: <code>1234abcd-12ab-34cd-56ef-1234567890ab</code>
     * </p>
     * </li>
     * <li>
     * <p>
     * Key ARN: <code>arn:aws:kms:us-east-2:111122223333:key/1234abcd-12ab-34cd-56ef-1234567890ab</code>
     * </p>
     * </li>
     * </ul>
     * <p>
     * To get the key ID and key ARN for a KMS key, use <a>ListKeys</a> or <a>DescribeKey</a>.
     * </p>
     * 
     * @return Sets the key policy on the specified KMS key.</p>
     *         <p>
     *         Specify the key ID or key ARN of the KMS key.
     *         </p>
     *         <p>
     *         For example:
     *         </p>
     *         <ul>
     *         <li>
     *         <p>
     *         Key ID: <code>1234abcd-12ab-34cd-56ef-1234567890ab</code>
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         Key ARN: <code>arn:aws:kms:us-east-2:111122223333:key/1234abcd-12ab-34cd-56ef-1234567890ab</code>
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
     * The name of the key policy. If no policy name is specified, the default value is <code>default</code>. The only
     * valid value is <code>default</code>.
     * </p>
     * 
     * @return The name of the key policy. If no policy name is specified, the default value is <code>default</code>.
     *         The only valid value is <code>default</code>.
     */
    public final String policyName() {
        return policyName;
    }

    /**
     * <p>
     * The key policy to attach to the KMS key.
     * </p>
     * <p>
     * The key policy must meet the following criteria:
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
     * <i>Key Management Service Developer Guide</i>.For help writing and formatting a JSON policy document, see the <a
     * href="https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_policies.html">IAM JSON Policy Reference</a> in
     * the <i> <i>Identity and Access Management User Guide</i> </i>.
     * </p>
     * 
     * @return The key policy to attach to the KMS key.</p>
     *         <p>
     *         The key policy must meet the following criteria:
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
     *         the <i>Key Management Service Developer Guide</i>.For help writing and formatting a JSON policy document,
     *         see the <a href="https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_policies.html">IAM JSON
     *         Policy Reference</a> in the <i> <i>Identity and Access Management User Guide</i> </i>.
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
        hashCode = 31 * hashCode + Objects.hashCode(policyName());
        hashCode = 31 * hashCode + Objects.hashCode(policy());
        hashCode = 31 * hashCode + Objects.hashCode(bypassPolicyLockoutSafetyCheck());
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
        if (!(obj instanceof PutKeyPolicyRequest)) {
            return false;
        }
        PutKeyPolicyRequest other = (PutKeyPolicyRequest) obj;
        return Objects.equals(keyId(), other.keyId()) && Objects.equals(policyName(), other.policyName())
                && Objects.equals(policy(), other.policy())
                && Objects.equals(bypassPolicyLockoutSafetyCheck(), other.bypassPolicyLockoutSafetyCheck());
    }

    /**
     * Returns a string representation of this object. This is useful for testing and debugging. Sensitive data will be
     * redacted from this string using a placeholder value.
     */
    @Override
    public final String toString() {
        return ToString.builder("PutKeyPolicyRequest").add("KeyId", keyId()).add("PolicyName", policyName())
                .add("Policy", policy()).add("BypassPolicyLockoutSafetyCheck", bypassPolicyLockoutSafetyCheck()).build();
    }

    public final <T> Optional<T> getValueForField(String fieldName, Class<T> clazz) {
        switch (fieldName) {
        case "KeyId":
            return Optional.ofNullable(clazz.cast(keyId()));
        case "PolicyName":
            return Optional.ofNullable(clazz.cast(policyName()));
        case "Policy":
            return Optional.ofNullable(clazz.cast(policy()));
        case "BypassPolicyLockoutSafetyCheck":
            return Optional.ofNullable(clazz.cast(bypassPolicyLockoutSafetyCheck()));
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
        map.put("PolicyName", POLICY_NAME_FIELD);
        map.put("Policy", POLICY_FIELD);
        map.put("BypassPolicyLockoutSafetyCheck", BYPASS_POLICY_LOCKOUT_SAFETY_CHECK_FIELD);
        return Collections.unmodifiableMap(map);
    }

    private static <T> Function<Object, T> getter(Function<PutKeyPolicyRequest, T> g) {
        return obj -> g.apply((PutKeyPolicyRequest) obj);
    }

    private static <T> BiConsumer<Object, T> setter(BiConsumer<Builder, T> s) {
        return (obj, val) -> s.accept((Builder) obj, val);
    }

    @Mutable
    @NotThreadSafe
    public interface Builder extends KmsRequest.Builder, SdkPojo, CopyableBuilder<Builder, PutKeyPolicyRequest> {
        /**
         * <p>
         * Sets the key policy on the specified KMS key.
         * </p>
         * <p>
         * Specify the key ID or key ARN of the KMS key.
         * </p>
         * <p>
         * For example:
         * </p>
         * <ul>
         * <li>
         * <p>
         * Key ID: <code>1234abcd-12ab-34cd-56ef-1234567890ab</code>
         * </p>
         * </li>
         * <li>
         * <p>
         * Key ARN: <code>arn:aws:kms:us-east-2:111122223333:key/1234abcd-12ab-34cd-56ef-1234567890ab</code>
         * </p>
         * </li>
         * </ul>
         * <p>
         * To get the key ID and key ARN for a KMS key, use <a>ListKeys</a> or <a>DescribeKey</a>.
         * </p>
         * 
         * @param keyId
         *        Sets the key policy on the specified KMS key.</p>
         *        <p>
         *        Specify the key ID or key ARN of the KMS key.
         *        </p>
         *        <p>
         *        For example:
         *        </p>
         *        <ul>
         *        <li>
         *        <p>
         *        Key ID: <code>1234abcd-12ab-34cd-56ef-1234567890ab</code>
         *        </p>
         *        </li>
         *        <li>
         *        <p>
         *        Key ARN: <code>arn:aws:kms:us-east-2:111122223333:key/1234abcd-12ab-34cd-56ef-1234567890ab</code>
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
         * The name of the key policy. If no policy name is specified, the default value is <code>default</code>. The
         * only valid value is <code>default</code>.
         * </p>
         * 
         * @param policyName
         *        The name of the key policy. If no policy name is specified, the default value is <code>default</code>.
         *        The only valid value is <code>default</code>.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder policyName(String policyName);

        /**
         * <p>
         * The key policy to attach to the KMS key.
         * </p>
         * <p>
         * The key policy must meet the following criteria:
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
         * <i>Key Management Service Developer Guide</i>.For help writing and formatting a JSON policy document, see the
         * <a href="https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_policies.html">IAM JSON Policy
         * Reference</a> in the <i> <i>Identity and Access Management User Guide</i> </i>.
         * </p>
         * 
         * @param policy
         *        The key policy to attach to the KMS key.</p>
         *        <p>
         *        The key policy must meet the following criteria:
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
         *        in the <i>Key Management Service Developer Guide</i>.For help writing and formatting a JSON policy
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

        @Override
        Builder overrideConfiguration(AwsRequestOverrideConfiguration overrideConfiguration);

        @Override
        Builder overrideConfiguration(Consumer<AwsRequestOverrideConfiguration.Builder> builderConsumer);
    }

    static final class BuilderImpl extends KmsRequest.BuilderImpl implements Builder {
        private String keyId;

        private String policyName;

        private String policy;

        private Boolean bypassPolicyLockoutSafetyCheck;

        private BuilderImpl() {
        }

        private BuilderImpl(PutKeyPolicyRequest model) {
            super(model);
            keyId(model.keyId);
            policyName(model.policyName);
            policy(model.policy);
            bypassPolicyLockoutSafetyCheck(model.bypassPolicyLockoutSafetyCheck);
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

        public final String getPolicyName() {
            return policyName;
        }

        public final void setPolicyName(String policyName) {
            this.policyName = policyName;
        }

        @Override
        public final Builder policyName(String policyName) {
            this.policyName = policyName;
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
        public PutKeyPolicyRequest build() {
            return new PutKeyPolicyRequest(this);
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
