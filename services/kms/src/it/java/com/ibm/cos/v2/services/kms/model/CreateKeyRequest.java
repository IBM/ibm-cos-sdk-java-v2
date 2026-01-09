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
public final class CreateKeyRequest extends KmsRequest implements ToCopyableBuilder<CreateKeyRequest.Builder, CreateKeyRequest> {
    private static final SdkField<String> POLICY_FIELD = SdkField.<String> builder(MarshallingType.STRING).memberName("Policy")
            .getter(getter(CreateKeyRequest::policy)).setter(setter(Builder::policy))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("Policy").build()).build();

    private static final SdkField<String> DESCRIPTION_FIELD = SdkField.<String> builder(MarshallingType.STRING)
            .memberName("Description").getter(getter(CreateKeyRequest::description)).setter(setter(Builder::description))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("Description").build()).build();

    private static final SdkField<String> KEY_USAGE_FIELD = SdkField.<String> builder(MarshallingType.STRING)
            .memberName("KeyUsage").getter(getter(CreateKeyRequest::keyUsageAsString)).setter(setter(Builder::keyUsage))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("KeyUsage").build()).build();

    private static final SdkField<String> CUSTOMER_MASTER_KEY_SPEC_FIELD = SdkField.<String> builder(MarshallingType.STRING)
            .memberName("CustomerMasterKeySpec").getter(getter(CreateKeyRequest::customerMasterKeySpecAsString))
            .setter(setter(Builder::customerMasterKeySpec))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("CustomerMasterKeySpec").build())
            .build();

    private static final SdkField<String> KEY_SPEC_FIELD = SdkField.<String> builder(MarshallingType.STRING)
            .memberName("KeySpec").getter(getter(CreateKeyRequest::keySpecAsString)).setter(setter(Builder::keySpec))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("KeySpec").build()).build();

    private static final SdkField<String> ORIGIN_FIELD = SdkField.<String> builder(MarshallingType.STRING).memberName("Origin")
            .getter(getter(CreateKeyRequest::originAsString)).setter(setter(Builder::origin))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("Origin").build()).build();

    private static final SdkField<String> CUSTOM_KEY_STORE_ID_FIELD = SdkField.<String> builder(MarshallingType.STRING)
            .memberName("CustomKeyStoreId").getter(getter(CreateKeyRequest::customKeyStoreId))
            .setter(setter(Builder::customKeyStoreId))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("CustomKeyStoreId").build()).build();

    private static final SdkField<Boolean> BYPASS_POLICY_LOCKOUT_SAFETY_CHECK_FIELD = SdkField
            .<Boolean> builder(MarshallingType.BOOLEAN)
            .memberName("BypassPolicyLockoutSafetyCheck")
            .getter(getter(CreateKeyRequest::bypassPolicyLockoutSafetyCheck))
            .setter(setter(Builder::bypassPolicyLockoutSafetyCheck))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("BypassPolicyLockoutSafetyCheck")
                    .build()).build();

    private static final SdkField<List<Tag>> TAGS_FIELD = SdkField
            .<List<Tag>> builder(MarshallingType.LIST)
            .memberName("Tags")
            .getter(getter(CreateKeyRequest::tags))
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

    private static final SdkField<Boolean> MULTI_REGION_FIELD = SdkField.<Boolean> builder(MarshallingType.BOOLEAN)
            .memberName("MultiRegion").getter(getter(CreateKeyRequest::multiRegion)).setter(setter(Builder::multiRegion))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("MultiRegion").build()).build();

    private static final SdkField<String> XKS_KEY_ID_FIELD = SdkField.<String> builder(MarshallingType.STRING)
            .memberName("XksKeyId").getter(getter(CreateKeyRequest::xksKeyId)).setter(setter(Builder::xksKeyId))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("XksKeyId").build()).build();

    private static final List<SdkField<?>> SDK_FIELDS = Collections.unmodifiableList(Arrays
            .asList(POLICY_FIELD, DESCRIPTION_FIELD, KEY_USAGE_FIELD, CUSTOMER_MASTER_KEY_SPEC_FIELD, KEY_SPEC_FIELD,
                    ORIGIN_FIELD, CUSTOM_KEY_STORE_ID_FIELD, BYPASS_POLICY_LOCKOUT_SAFETY_CHECK_FIELD, TAGS_FIELD,
                    MULTI_REGION_FIELD, XKS_KEY_ID_FIELD));

    private static final Map<String, SdkField<?>> SDK_NAME_TO_FIELD = memberNameToFieldInitializer();

    private final String policy;

    private final String description;

    private final String keyUsage;

    private final String customerMasterKeySpec;

    private final String keySpec;

    private final String origin;

    private final String customKeyStoreId;

    private final Boolean bypassPolicyLockoutSafetyCheck;

    private final List<Tag> tags;

    private final Boolean multiRegion;

    private final String xksKeyId;

    private CreateKeyRequest(BuilderImpl builder) {
        super(builder);
        this.policy = builder.policy;
        this.description = builder.description;
        this.keyUsage = builder.keyUsage;
        this.customerMasterKeySpec = builder.customerMasterKeySpec;
        this.keySpec = builder.keySpec;
        this.origin = builder.origin;
        this.customKeyStoreId = builder.customKeyStoreId;
        this.bypassPolicyLockoutSafetyCheck = builder.bypassPolicyLockoutSafetyCheck;
        this.tags = builder.tags;
        this.multiRegion = builder.multiRegion;
        this.xksKeyId = builder.xksKeyId;
    }

    /**
     * <p>
     * The key policy to attach to the KMS key.
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
     * If you do not provide a key policy, KMS attaches a default key policy to the KMS key. For more information, see
     * <a href="https://docs.aws.amazon.com/kms/latest/developerguide/key-policies.html#key-policy-default">Default key
     * policy</a> in the <i>Key Management Service Developer Guide</i>.
     * </p>
     * <p>
     * The key policy size quota is 32 kilobytes (32768 bytes).
     * </p>
     * <p>
     * For help writing and formatting a JSON policy document, see the <a
     * href="https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_policies.html">IAM JSON Policy Reference</a> in
     * the <i> <i>Identity and Access Management User Guide</i> </i>.
     * </p>
     * 
     * @return The key policy to attach to the KMS key.</p>
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
     *         If you do not provide a key policy, KMS attaches a default key policy to the KMS key. For more
     *         information, see <a
     *         href="https://docs.aws.amazon.com/kms/latest/developerguide/key-policies.html#key-policy-default">Default
     *         key policy</a> in the <i>Key Management Service Developer Guide</i>.
     *         </p>
     *         <p>
     *         The key policy size quota is 32 kilobytes (32768 bytes).
     *         </p>
     *         <p>
     *         For help writing and formatting a JSON policy document, see the <a
     *         href="https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_policies.html">IAM JSON Policy
     *         Reference</a> in the <i> <i>Identity and Access Management User Guide</i> </i>.
     */
    public final String policy() {
        return policy;
    }

    /**
     * <p>
     * A description of the KMS key. Use a description that helps you decide whether the KMS key is appropriate for a
     * task. The default value is an empty string (no description).
     * </p>
     * <important>
     * <p>
     * Do not include confidential or sensitive information in this field. This field may be displayed in plaintext in
     * CloudTrail logs and other output.
     * </p>
     * </important>
     * <p>
     * To set or change the description after the key is created, use <a>UpdateKeyDescription</a>.
     * </p>
     * 
     * @return A description of the KMS key. Use a description that helps you decide whether the KMS key is appropriate
     *         for a task. The default value is an empty string (no description).</p> <important>
     *         <p>
     *         Do not include confidential or sensitive information in this field. This field may be displayed in
     *         plaintext in CloudTrail logs and other output.
     *         </p>
     *         </important>
     *         <p>
     *         To set or change the description after the key is created, use <a>UpdateKeyDescription</a>.
     */
    public final String description() {
        return description;
    }

    /**
     * <p>
     * Determines the <a
     * href="https://docs.aws.amazon.com/kms/latest/developerguide/concepts.html#cryptographic-operations">cryptographic
     * operations</a> for which you can use the KMS key. The default value is <code>ENCRYPT_DECRYPT</code>. This
     * parameter is optional when you are creating a symmetric encryption KMS key; otherwise, it is required. You can't
     * change the <code>KeyUsage</code> value after the KMS key is created.
     * </p>
     * <p>
     * Select only one valid value.
     * </p>
     * <ul>
     * <li>
     * <p>
     * For symmetric encryption KMS keys, omit the parameter or specify <code>ENCRYPT_DECRYPT</code>.
     * </p>
     * </li>
     * <li>
     * <p>
     * For HMAC KMS keys (symmetric), specify <code>GENERATE_VERIFY_MAC</code>.
     * </p>
     * </li>
     * <li>
     * <p>
     * For asymmetric KMS keys with RSA key pairs, specify <code>ENCRYPT_DECRYPT</code> or <code>SIGN_VERIFY</code>.
     * </p>
     * </li>
     * <li>
     * <p>
     * For asymmetric KMS keys with NIST-recommended elliptic curve key pairs, specify <code>SIGN_VERIFY</code> or
     * <code>KEY_AGREEMENT</code>.
     * </p>
     * </li>
     * <li>
     * <p>
     * For asymmetric KMS keys with <code>ECC_SECG_P256K1</code> key pairs specify <code>SIGN_VERIFY</code>.
     * </p>
     * </li>
     * <li>
     * <p>
     * For asymmetric KMS keys with SM2 key pairs (China Regions only), specify <code>ENCRYPT_DECRYPT</code>,
     * <code>SIGN_VERIFY</code>, or <code>KEY_AGREEMENT</code>.
     * </p>
     * </li>
     * </ul>
     * <p>
     * If the service returns an enum value that is not available in the current SDK version, {@link #keyUsage} will
     * return {@link KeyUsageType#UNKNOWN_TO_SDK_VERSION}. The raw value returned by the service is available from
     * {@link #keyUsageAsString}.
     * </p>
     * 
     * @return Determines the <a
     *         href="https://docs.aws.amazon.com/kms/latest/developerguide/concepts.html#cryptographic-operations"
     *         >cryptographic operations</a> for which you can use the KMS key. The default value is
     *         <code>ENCRYPT_DECRYPT</code>. This parameter is optional when you are creating a symmetric encryption KMS
     *         key; otherwise, it is required. You can't change the <code>KeyUsage</code> value after the KMS key is
     *         created.</p>
     *         <p>
     *         Select only one valid value.
     *         </p>
     *         <ul>
     *         <li>
     *         <p>
     *         For symmetric encryption KMS keys, omit the parameter or specify <code>ENCRYPT_DECRYPT</code>.
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         For HMAC KMS keys (symmetric), specify <code>GENERATE_VERIFY_MAC</code>.
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         For asymmetric KMS keys with RSA key pairs, specify <code>ENCRYPT_DECRYPT</code> or
     *         <code>SIGN_VERIFY</code>.
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         For asymmetric KMS keys with NIST-recommended elliptic curve key pairs, specify <code>SIGN_VERIFY</code>
     *         or <code>KEY_AGREEMENT</code>.
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         For asymmetric KMS keys with <code>ECC_SECG_P256K1</code> key pairs specify <code>SIGN_VERIFY</code>.
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         For asymmetric KMS keys with SM2 key pairs (China Regions only), specify <code>ENCRYPT_DECRYPT</code>,
     *         <code>SIGN_VERIFY</code>, or <code>KEY_AGREEMENT</code>.
     *         </p>
     *         </li>
     * @see KeyUsageType
     */
    public final KeyUsageType keyUsage() {
        return KeyUsageType.fromValue(keyUsage);
    }

    /**
     * <p>
     * Determines the <a
     * href="https://docs.aws.amazon.com/kms/latest/developerguide/concepts.html#cryptographic-operations">cryptographic
     * operations</a> for which you can use the KMS key. The default value is <code>ENCRYPT_DECRYPT</code>. This
     * parameter is optional when you are creating a symmetric encryption KMS key; otherwise, it is required. You can't
     * change the <code>KeyUsage</code> value after the KMS key is created.
     * </p>
     * <p>
     * Select only one valid value.
     * </p>
     * <ul>
     * <li>
     * <p>
     * For symmetric encryption KMS keys, omit the parameter or specify <code>ENCRYPT_DECRYPT</code>.
     * </p>
     * </li>
     * <li>
     * <p>
     * For HMAC KMS keys (symmetric), specify <code>GENERATE_VERIFY_MAC</code>.
     * </p>
     * </li>
     * <li>
     * <p>
     * For asymmetric KMS keys with RSA key pairs, specify <code>ENCRYPT_DECRYPT</code> or <code>SIGN_VERIFY</code>.
     * </p>
     * </li>
     * <li>
     * <p>
     * For asymmetric KMS keys with NIST-recommended elliptic curve key pairs, specify <code>SIGN_VERIFY</code> or
     * <code>KEY_AGREEMENT</code>.
     * </p>
     * </li>
     * <li>
     * <p>
     * For asymmetric KMS keys with <code>ECC_SECG_P256K1</code> key pairs specify <code>SIGN_VERIFY</code>.
     * </p>
     * </li>
     * <li>
     * <p>
     * For asymmetric KMS keys with SM2 key pairs (China Regions only), specify <code>ENCRYPT_DECRYPT</code>,
     * <code>SIGN_VERIFY</code>, or <code>KEY_AGREEMENT</code>.
     * </p>
     * </li>
     * </ul>
     * <p>
     * If the service returns an enum value that is not available in the current SDK version, {@link #keyUsage} will
     * return {@link KeyUsageType#UNKNOWN_TO_SDK_VERSION}. The raw value returned by the service is available from
     * {@link #keyUsageAsString}.
     * </p>
     * 
     * @return Determines the <a
     *         href="https://docs.aws.amazon.com/kms/latest/developerguide/concepts.html#cryptographic-operations"
     *         >cryptographic operations</a> for which you can use the KMS key. The default value is
     *         <code>ENCRYPT_DECRYPT</code>. This parameter is optional when you are creating a symmetric encryption KMS
     *         key; otherwise, it is required. You can't change the <code>KeyUsage</code> value after the KMS key is
     *         created.</p>
     *         <p>
     *         Select only one valid value.
     *         </p>
     *         <ul>
     *         <li>
     *         <p>
     *         For symmetric encryption KMS keys, omit the parameter or specify <code>ENCRYPT_DECRYPT</code>.
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         For HMAC KMS keys (symmetric), specify <code>GENERATE_VERIFY_MAC</code>.
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         For asymmetric KMS keys with RSA key pairs, specify <code>ENCRYPT_DECRYPT</code> or
     *         <code>SIGN_VERIFY</code>.
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         For asymmetric KMS keys with NIST-recommended elliptic curve key pairs, specify <code>SIGN_VERIFY</code>
     *         or <code>KEY_AGREEMENT</code>.
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         For asymmetric KMS keys with <code>ECC_SECG_P256K1</code> key pairs specify <code>SIGN_VERIFY</code>.
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         For asymmetric KMS keys with SM2 key pairs (China Regions only), specify <code>ENCRYPT_DECRYPT</code>,
     *         <code>SIGN_VERIFY</code>, or <code>KEY_AGREEMENT</code>.
     *         </p>
     *         </li>
     * @see KeyUsageType
     */
    public final String keyUsageAsString() {
        return keyUsage;
    }

    /**
     * <p>
     * Instead, use the <code>KeySpec</code> parameter.
     * </p>
     * <p>
     * The <code>KeySpec</code> and <code>CustomerMasterKeySpec</code> parameters work the same way. Only the names
     * differ. We recommend that you use <code>KeySpec</code> parameter in your code. However, to avoid breaking
     * changes, KMS supports both parameters.
     * </p>
     * <p>
     * If the service returns an enum value that is not available in the current SDK version,
     * {@link #customerMasterKeySpec} will return {@link CustomerMasterKeySpec#UNKNOWN_TO_SDK_VERSION}. The raw value
     * returned by the service is available from {@link #customerMasterKeySpecAsString}.
     * </p>
     * 
     * @return Instead, use the <code>KeySpec</code> parameter.</p>
     *         <p>
     *         The <code>KeySpec</code> and <code>CustomerMasterKeySpec</code> parameters work the same way. Only the
     *         names differ. We recommend that you use <code>KeySpec</code> parameter in your code. However, to avoid
     *         breaking changes, KMS supports both parameters.
     * @see CustomerMasterKeySpec
     * @deprecated This parameter has been deprecated. Instead, use the KeySpec parameter.
     */
    @Deprecated
    public final CustomerMasterKeySpec customerMasterKeySpec() {
        return CustomerMasterKeySpec.fromValue(customerMasterKeySpec);
    }

    /**
     * <p>
     * Instead, use the <code>KeySpec</code> parameter.
     * </p>
     * <p>
     * The <code>KeySpec</code> and <code>CustomerMasterKeySpec</code> parameters work the same way. Only the names
     * differ. We recommend that you use <code>KeySpec</code> parameter in your code. However, to avoid breaking
     * changes, KMS supports both parameters.
     * </p>
     * <p>
     * If the service returns an enum value that is not available in the current SDK version,
     * {@link #customerMasterKeySpec} will return {@link CustomerMasterKeySpec#UNKNOWN_TO_SDK_VERSION}. The raw value
     * returned by the service is available from {@link #customerMasterKeySpecAsString}.
     * </p>
     * 
     * @return Instead, use the <code>KeySpec</code> parameter.</p>
     *         <p>
     *         The <code>KeySpec</code> and <code>CustomerMasterKeySpec</code> parameters work the same way. Only the
     *         names differ. We recommend that you use <code>KeySpec</code> parameter in your code. However, to avoid
     *         breaking changes, KMS supports both parameters.
     * @see CustomerMasterKeySpec
     * @deprecated This parameter has been deprecated. Instead, use the KeySpec parameter.
     */
    @Deprecated
    public final String customerMasterKeySpecAsString() {
        return customerMasterKeySpec;
    }

    /**
     * <p>
     * Specifies the type of KMS key to create. The default value, <code>SYMMETRIC_DEFAULT</code>, creates a KMS key
     * with a 256-bit AES-GCM key that is used for encryption and decryption, except in China Regions, where it creates
     * a 128-bit symmetric key that uses SM4 encryption. For help choosing a key spec for your KMS key, see <a
     * href="https://docs.aws.amazon.com/kms/latest/developerguide/key-types.html#symm-asymm-choose">Choosing a KMS key
     * type</a> in the <i> <i>Key Management Service Developer Guide</i> </i>.
     * </p>
     * <p>
     * The <code>KeySpec</code> determines whether the KMS key contains a symmetric key or an asymmetric key pair. It
     * also determines the algorithms that the KMS key supports. You can't change the <code>KeySpec</code> after the KMS
     * key is created. To further restrict the algorithms that can be used with the KMS key, use a condition key in its
     * key policy or IAM policy. For more information, see <a href=
     * "https://docs.aws.amazon.com/kms/latest/developerguide/policy-conditions.html#conditions-kms-encryption-algorithm"
     * >kms:EncryptionAlgorithm</a>, <a href=
     * "https://docs.aws.amazon.com/kms/latest/developerguide/policy-conditions.html#conditions-kms-mac-algorithm"
     * >kms:MacAlgorithm</a> or <a href=
     * "https://docs.aws.amazon.com/kms/latest/developerguide/policy-conditions.html#conditions-kms-signing-algorithm"
     * >kms:Signing Algorithm</a> in the <i> <i>Key Management Service Developer Guide</i> </i>.
     * </p>
     * <important>
     * <p>
     * <a href="http://aws.amazon.com/kms/features/#AWS_Service_Integration">Amazon Web Services services that are
     * integrated with KMS</a> use symmetric encryption KMS keys to protect your data. These services do not support
     * asymmetric KMS keys or HMAC KMS keys.
     * </p>
     * </important>
     * <p>
     * KMS supports the following key specs for KMS keys:
     * </p>
     * <ul>
     * <li>
     * <p>
     * Symmetric encryption key (default)
     * </p>
     * <ul>
     * <li>
     * <p>
     * <code>SYMMETRIC_DEFAULT</code>
     * </p>
     * </li>
     * </ul>
     * </li>
     * <li>
     * <p>
     * HMAC keys (symmetric)
     * </p>
     * <ul>
     * <li>
     * <p>
     * <code>HMAC_224</code>
     * </p>
     * </li>
     * <li>
     * <p>
     * <code>HMAC_256</code>
     * </p>
     * </li>
     * <li>
     * <p>
     * <code>HMAC_384</code>
     * </p>
     * </li>
     * <li>
     * <p>
     * <code>HMAC_512</code>
     * </p>
     * </li>
     * </ul>
     * </li>
     * <li>
     * <p>
     * Asymmetric RSA key pairs (encryption and decryption -or- signing and verification)
     * </p>
     * <ul>
     * <li>
     * <p>
     * <code>RSA_2048</code>
     * </p>
     * </li>
     * <li>
     * <p>
     * <code>RSA_3072</code>
     * </p>
     * </li>
     * <li>
     * <p>
     * <code>RSA_4096</code>
     * </p>
     * </li>
     * </ul>
     * </li>
     * <li>
     * <p>
     * Asymmetric NIST-recommended elliptic curve key pairs (signing and verification -or- deriving shared secrets)
     * </p>
     * <ul>
     * <li>
     * <p>
     * <code>ECC_NIST_P256</code> (secp256r1)
     * </p>
     * </li>
     * <li>
     * <p>
     * <code>ECC_NIST_P384</code> (secp384r1)
     * </p>
     * </li>
     * <li>
     * <p>
     * <code>ECC_NIST_P521</code> (secp521r1)
     * </p>
     * </li>
     * </ul>
     * </li>
     * <li>
     * <p>
     * Other asymmetric elliptic curve key pairs (signing and verification)
     * </p>
     * <ul>
     * <li>
     * <p>
     * <code>ECC_SECG_P256K1</code> (secp256k1), commonly used for cryptocurrencies.
     * </p>
     * </li>
     * </ul>
     * </li>
     * <li>
     * <p>
     * SM2 key pairs (encryption and decryption -or- signing and verification -or- deriving shared secrets)
     * </p>
     * <ul>
     * <li>
     * <p>
     * <code>SM2</code> (China Regions only)
     * </p>
     * </li>
     * </ul>
     * </li>
     * </ul>
     * <p>
     * If the service returns an enum value that is not available in the current SDK version, {@link #keySpec} will
     * return {@link KeySpec#UNKNOWN_TO_SDK_VERSION}. The raw value returned by the service is available from
     * {@link #keySpecAsString}.
     * </p>
     * 
     * @return Specifies the type of KMS key to create. The default value, <code>SYMMETRIC_DEFAULT</code>, creates a KMS
     *         key with a 256-bit AES-GCM key that is used for encryption and decryption, except in China Regions, where
     *         it creates a 128-bit symmetric key that uses SM4 encryption. For help choosing a key spec for your KMS
     *         key, see <a
     *         href="https://docs.aws.amazon.com/kms/latest/developerguide/key-types.html#symm-asymm-choose">Choosing a
     *         KMS key type</a> in the <i> <i>Key Management Service Developer Guide</i> </i>.</p>
     *         <p>
     *         The <code>KeySpec</code> determines whether the KMS key contains a symmetric key or an asymmetric key
     *         pair. It also determines the algorithms that the KMS key supports. You can't change the
     *         <code>KeySpec</code> after the KMS key is created. To further restrict the algorithms that can be used
     *         with the KMS key, use a condition key in its key policy or IAM policy. For more information, see <a href=
     *         "https://docs.aws.amazon.com/kms/latest/developerguide/policy-conditions.html#conditions-kms-encryption-algorithm"
     *         >kms:EncryptionAlgorithm</a>, <a href=
     *         "https://docs.aws.amazon.com/kms/latest/developerguide/policy-conditions.html#conditions-kms-mac-algorithm"
     *         >kms:MacAlgorithm</a> or <a href=
     *         "https://docs.aws.amazon.com/kms/latest/developerguide/policy-conditions.html#conditions-kms-signing-algorithm"
     *         >kms:Signing Algorithm</a> in the <i> <i>Key Management Service Developer Guide</i> </i>.
     *         </p>
     *         <important>
     *         <p>
     *         <a href="http://aws.amazon.com/kms/features/#AWS_Service_Integration">Amazon Web Services services that
     *         are integrated with KMS</a> use symmetric encryption KMS keys to protect your data. These services do not
     *         support asymmetric KMS keys or HMAC KMS keys.
     *         </p>
     *         </important>
     *         <p>
     *         KMS supports the following key specs for KMS keys:
     *         </p>
     *         <ul>
     *         <li>
     *         <p>
     *         Symmetric encryption key (default)
     *         </p>
     *         <ul>
     *         <li>
     *         <p>
     *         <code>SYMMETRIC_DEFAULT</code>
     *         </p>
     *         </li>
     *         </ul>
     *         </li>
     *         <li>
     *         <p>
     *         HMAC keys (symmetric)
     *         </p>
     *         <ul>
     *         <li>
     *         <p>
     *         <code>HMAC_224</code>
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         <code>HMAC_256</code>
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         <code>HMAC_384</code>
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         <code>HMAC_512</code>
     *         </p>
     *         </li>
     *         </ul>
     *         </li>
     *         <li>
     *         <p>
     *         Asymmetric RSA key pairs (encryption and decryption -or- signing and verification)
     *         </p>
     *         <ul>
     *         <li>
     *         <p>
     *         <code>RSA_2048</code>
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         <code>RSA_3072</code>
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         <code>RSA_4096</code>
     *         </p>
     *         </li>
     *         </ul>
     *         </li>
     *         <li>
     *         <p>
     *         Asymmetric NIST-recommended elliptic curve key pairs (signing and verification -or- deriving shared
     *         secrets)
     *         </p>
     *         <ul>
     *         <li>
     *         <p>
     *         <code>ECC_NIST_P256</code> (secp256r1)
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         <code>ECC_NIST_P384</code> (secp384r1)
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         <code>ECC_NIST_P521</code> (secp521r1)
     *         </p>
     *         </li>
     *         </ul>
     *         </li>
     *         <li>
     *         <p>
     *         Other asymmetric elliptic curve key pairs (signing and verification)
     *         </p>
     *         <ul>
     *         <li>
     *         <p>
     *         <code>ECC_SECG_P256K1</code> (secp256k1), commonly used for cryptocurrencies.
     *         </p>
     *         </li>
     *         </ul>
     *         </li>
     *         <li>
     *         <p>
     *         SM2 key pairs (encryption and decryption -or- signing and verification -or- deriving shared secrets)
     *         </p>
     *         <ul>
     *         <li>
     *         <p>
     *         <code>SM2</code> (China Regions only)
     *         </p>
     *         </li>
     *         </ul>
     *         </li>
     * @see KeySpec
     */
    public final KeySpec keySpec() {
        return KeySpec.fromValue(keySpec);
    }

    /**
     * <p>
     * Specifies the type of KMS key to create. The default value, <code>SYMMETRIC_DEFAULT</code>, creates a KMS key
     * with a 256-bit AES-GCM key that is used for encryption and decryption, except in China Regions, where it creates
     * a 128-bit symmetric key that uses SM4 encryption. For help choosing a key spec for your KMS key, see <a
     * href="https://docs.aws.amazon.com/kms/latest/developerguide/key-types.html#symm-asymm-choose">Choosing a KMS key
     * type</a> in the <i> <i>Key Management Service Developer Guide</i> </i>.
     * </p>
     * <p>
     * The <code>KeySpec</code> determines whether the KMS key contains a symmetric key or an asymmetric key pair. It
     * also determines the algorithms that the KMS key supports. You can't change the <code>KeySpec</code> after the KMS
     * key is created. To further restrict the algorithms that can be used with the KMS key, use a condition key in its
     * key policy or IAM policy. For more information, see <a href=
     * "https://docs.aws.amazon.com/kms/latest/developerguide/policy-conditions.html#conditions-kms-encryption-algorithm"
     * >kms:EncryptionAlgorithm</a>, <a href=
     * "https://docs.aws.amazon.com/kms/latest/developerguide/policy-conditions.html#conditions-kms-mac-algorithm"
     * >kms:MacAlgorithm</a> or <a href=
     * "https://docs.aws.amazon.com/kms/latest/developerguide/policy-conditions.html#conditions-kms-signing-algorithm"
     * >kms:Signing Algorithm</a> in the <i> <i>Key Management Service Developer Guide</i> </i>.
     * </p>
     * <important>
     * <p>
     * <a href="http://aws.amazon.com/kms/features/#AWS_Service_Integration">Amazon Web Services services that are
     * integrated with KMS</a> use symmetric encryption KMS keys to protect your data. These services do not support
     * asymmetric KMS keys or HMAC KMS keys.
     * </p>
     * </important>
     * <p>
     * KMS supports the following key specs for KMS keys:
     * </p>
     * <ul>
     * <li>
     * <p>
     * Symmetric encryption key (default)
     * </p>
     * <ul>
     * <li>
     * <p>
     * <code>SYMMETRIC_DEFAULT</code>
     * </p>
     * </li>
     * </ul>
     * </li>
     * <li>
     * <p>
     * HMAC keys (symmetric)
     * </p>
     * <ul>
     * <li>
     * <p>
     * <code>HMAC_224</code>
     * </p>
     * </li>
     * <li>
     * <p>
     * <code>HMAC_256</code>
     * </p>
     * </li>
     * <li>
     * <p>
     * <code>HMAC_384</code>
     * </p>
     * </li>
     * <li>
     * <p>
     * <code>HMAC_512</code>
     * </p>
     * </li>
     * </ul>
     * </li>
     * <li>
     * <p>
     * Asymmetric RSA key pairs (encryption and decryption -or- signing and verification)
     * </p>
     * <ul>
     * <li>
     * <p>
     * <code>RSA_2048</code>
     * </p>
     * </li>
     * <li>
     * <p>
     * <code>RSA_3072</code>
     * </p>
     * </li>
     * <li>
     * <p>
     * <code>RSA_4096</code>
     * </p>
     * </li>
     * </ul>
     * </li>
     * <li>
     * <p>
     * Asymmetric NIST-recommended elliptic curve key pairs (signing and verification -or- deriving shared secrets)
     * </p>
     * <ul>
     * <li>
     * <p>
     * <code>ECC_NIST_P256</code> (secp256r1)
     * </p>
     * </li>
     * <li>
     * <p>
     * <code>ECC_NIST_P384</code> (secp384r1)
     * </p>
     * </li>
     * <li>
     * <p>
     * <code>ECC_NIST_P521</code> (secp521r1)
     * </p>
     * </li>
     * </ul>
     * </li>
     * <li>
     * <p>
     * Other asymmetric elliptic curve key pairs (signing and verification)
     * </p>
     * <ul>
     * <li>
     * <p>
     * <code>ECC_SECG_P256K1</code> (secp256k1), commonly used for cryptocurrencies.
     * </p>
     * </li>
     * </ul>
     * </li>
     * <li>
     * <p>
     * SM2 key pairs (encryption and decryption -or- signing and verification -or- deriving shared secrets)
     * </p>
     * <ul>
     * <li>
     * <p>
     * <code>SM2</code> (China Regions only)
     * </p>
     * </li>
     * </ul>
     * </li>
     * </ul>
     * <p>
     * If the service returns an enum value that is not available in the current SDK version, {@link #keySpec} will
     * return {@link KeySpec#UNKNOWN_TO_SDK_VERSION}. The raw value returned by the service is available from
     * {@link #keySpecAsString}.
     * </p>
     * 
     * @return Specifies the type of KMS key to create. The default value, <code>SYMMETRIC_DEFAULT</code>, creates a KMS
     *         key with a 256-bit AES-GCM key that is used for encryption and decryption, except in China Regions, where
     *         it creates a 128-bit symmetric key that uses SM4 encryption. For help choosing a key spec for your KMS
     *         key, see <a
     *         href="https://docs.aws.amazon.com/kms/latest/developerguide/key-types.html#symm-asymm-choose">Choosing a
     *         KMS key type</a> in the <i> <i>Key Management Service Developer Guide</i> </i>.</p>
     *         <p>
     *         The <code>KeySpec</code> determines whether the KMS key contains a symmetric key or an asymmetric key
     *         pair. It also determines the algorithms that the KMS key supports. You can't change the
     *         <code>KeySpec</code> after the KMS key is created. To further restrict the algorithms that can be used
     *         with the KMS key, use a condition key in its key policy or IAM policy. For more information, see <a href=
     *         "https://docs.aws.amazon.com/kms/latest/developerguide/policy-conditions.html#conditions-kms-encryption-algorithm"
     *         >kms:EncryptionAlgorithm</a>, <a href=
     *         "https://docs.aws.amazon.com/kms/latest/developerguide/policy-conditions.html#conditions-kms-mac-algorithm"
     *         >kms:MacAlgorithm</a> or <a href=
     *         "https://docs.aws.amazon.com/kms/latest/developerguide/policy-conditions.html#conditions-kms-signing-algorithm"
     *         >kms:Signing Algorithm</a> in the <i> <i>Key Management Service Developer Guide</i> </i>.
     *         </p>
     *         <important>
     *         <p>
     *         <a href="http://aws.amazon.com/kms/features/#AWS_Service_Integration">Amazon Web Services services that
     *         are integrated with KMS</a> use symmetric encryption KMS keys to protect your data. These services do not
     *         support asymmetric KMS keys or HMAC KMS keys.
     *         </p>
     *         </important>
     *         <p>
     *         KMS supports the following key specs for KMS keys:
     *         </p>
     *         <ul>
     *         <li>
     *         <p>
     *         Symmetric encryption key (default)
     *         </p>
     *         <ul>
     *         <li>
     *         <p>
     *         <code>SYMMETRIC_DEFAULT</code>
     *         </p>
     *         </li>
     *         </ul>
     *         </li>
     *         <li>
     *         <p>
     *         HMAC keys (symmetric)
     *         </p>
     *         <ul>
     *         <li>
     *         <p>
     *         <code>HMAC_224</code>
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         <code>HMAC_256</code>
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         <code>HMAC_384</code>
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         <code>HMAC_512</code>
     *         </p>
     *         </li>
     *         </ul>
     *         </li>
     *         <li>
     *         <p>
     *         Asymmetric RSA key pairs (encryption and decryption -or- signing and verification)
     *         </p>
     *         <ul>
     *         <li>
     *         <p>
     *         <code>RSA_2048</code>
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         <code>RSA_3072</code>
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         <code>RSA_4096</code>
     *         </p>
     *         </li>
     *         </ul>
     *         </li>
     *         <li>
     *         <p>
     *         Asymmetric NIST-recommended elliptic curve key pairs (signing and verification -or- deriving shared
     *         secrets)
     *         </p>
     *         <ul>
     *         <li>
     *         <p>
     *         <code>ECC_NIST_P256</code> (secp256r1)
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         <code>ECC_NIST_P384</code> (secp384r1)
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         <code>ECC_NIST_P521</code> (secp521r1)
     *         </p>
     *         </li>
     *         </ul>
     *         </li>
     *         <li>
     *         <p>
     *         Other asymmetric elliptic curve key pairs (signing and verification)
     *         </p>
     *         <ul>
     *         <li>
     *         <p>
     *         <code>ECC_SECG_P256K1</code> (secp256k1), commonly used for cryptocurrencies.
     *         </p>
     *         </li>
     *         </ul>
     *         </li>
     *         <li>
     *         <p>
     *         SM2 key pairs (encryption and decryption -or- signing and verification -or- deriving shared secrets)
     *         </p>
     *         <ul>
     *         <li>
     *         <p>
     *         <code>SM2</code> (China Regions only)
     *         </p>
     *         </li>
     *         </ul>
     *         </li>
     * @see KeySpec
     */
    public final String keySpecAsString() {
        return keySpec;
    }

    /**
     * <p>
     * The source of the key material for the KMS key. You cannot change the origin after you create the KMS key. The
     * default is <code>AWS_KMS</code>, which means that KMS creates the key material.
     * </p>
     * <p>
     * To <a href="https://docs.aws.amazon.com/kms/latest/developerguide/importing-keys-create-cmk.html">create a KMS
     * key with no key material</a> (for imported key material), set this value to <code>EXTERNAL</code>. For more
     * information about importing key material into KMS, see <a
     * href="https://docs.aws.amazon.com/kms/latest/developerguide/importing-keys.html">Importing Key Material</a> in
     * the <i>Key Management Service Developer Guide</i>. The <code>EXTERNAL</code> origin value is valid only for
     * symmetric KMS keys.
     * </p>
     * <p>
     * To <a href="https://docs.aws.amazon.com/kms/latest/developerguide/create-cmk-keystore.html">create a KMS key in
     * an CloudHSM key store</a> and create its key material in the associated CloudHSM cluster, set this value to
     * <code>AWS_CLOUDHSM</code>. You must also use the <code>CustomKeyStoreId</code> parameter to identify the CloudHSM
     * key store. The <code>KeySpec</code> value must be <code>SYMMETRIC_DEFAULT</code>.
     * </p>
     * <p>
     * To <a href="https://docs.aws.amazon.com/kms/latest/developerguide/create-xks-keys.html">create a KMS key in an
     * external key store</a>, set this value to <code>EXTERNAL_KEY_STORE</code>. You must also use the
     * <code>CustomKeyStoreId</code> parameter to identify the external key store and the <code>XksKeyId</code>
     * parameter to identify the associated external key. The <code>KeySpec</code> value must be
     * <code>SYMMETRIC_DEFAULT</code>.
     * </p>
     * <p>
     * If the service returns an enum value that is not available in the current SDK version, {@link #origin} will
     * return {@link OriginType#UNKNOWN_TO_SDK_VERSION}. The raw value returned by the service is available from
     * {@link #originAsString}.
     * </p>
     * 
     * @return The source of the key material for the KMS key. You cannot change the origin after you create the KMS
     *         key. The default is <code>AWS_KMS</code>, which means that KMS creates the key material.</p>
     *         <p>
     *         To <a href="https://docs.aws.amazon.com/kms/latest/developerguide/importing-keys-create-cmk.html">create
     *         a KMS key with no key material</a> (for imported key material), set this value to <code>EXTERNAL</code>.
     *         For more information about importing key material into KMS, see <a
     *         href="https://docs.aws.amazon.com/kms/latest/developerguide/importing-keys.html">Importing Key
     *         Material</a> in the <i>Key Management Service Developer Guide</i>. The <code>EXTERNAL</code> origin value
     *         is valid only for symmetric KMS keys.
     *         </p>
     *         <p>
     *         To <a href="https://docs.aws.amazon.com/kms/latest/developerguide/create-cmk-keystore.html">create a KMS
     *         key in an CloudHSM key store</a> and create its key material in the associated CloudHSM cluster, set this
     *         value to <code>AWS_CLOUDHSM</code>. You must also use the <code>CustomKeyStoreId</code> parameter to
     *         identify the CloudHSM key store. The <code>KeySpec</code> value must be <code>SYMMETRIC_DEFAULT</code>.
     *         </p>
     *         <p>
     *         To <a href="https://docs.aws.amazon.com/kms/latest/developerguide/create-xks-keys.html">create a KMS key
     *         in an external key store</a>, set this value to <code>EXTERNAL_KEY_STORE</code>. You must also use the
     *         <code>CustomKeyStoreId</code> parameter to identify the external key store and the <code>XksKeyId</code>
     *         parameter to identify the associated external key. The <code>KeySpec</code> value must be
     *         <code>SYMMETRIC_DEFAULT</code>.
     * @see OriginType
     */
    public final OriginType origin() {
        return OriginType.fromValue(origin);
    }

    /**
     * <p>
     * The source of the key material for the KMS key. You cannot change the origin after you create the KMS key. The
     * default is <code>AWS_KMS</code>, which means that KMS creates the key material.
     * </p>
     * <p>
     * To <a href="https://docs.aws.amazon.com/kms/latest/developerguide/importing-keys-create-cmk.html">create a KMS
     * key with no key material</a> (for imported key material), set this value to <code>EXTERNAL</code>. For more
     * information about importing key material into KMS, see <a
     * href="https://docs.aws.amazon.com/kms/latest/developerguide/importing-keys.html">Importing Key Material</a> in
     * the <i>Key Management Service Developer Guide</i>. The <code>EXTERNAL</code> origin value is valid only for
     * symmetric KMS keys.
     * </p>
     * <p>
     * To <a href="https://docs.aws.amazon.com/kms/latest/developerguide/create-cmk-keystore.html">create a KMS key in
     * an CloudHSM key store</a> and create its key material in the associated CloudHSM cluster, set this value to
     * <code>AWS_CLOUDHSM</code>. You must also use the <code>CustomKeyStoreId</code> parameter to identify the CloudHSM
     * key store. The <code>KeySpec</code> value must be <code>SYMMETRIC_DEFAULT</code>.
     * </p>
     * <p>
     * To <a href="https://docs.aws.amazon.com/kms/latest/developerguide/create-xks-keys.html">create a KMS key in an
     * external key store</a>, set this value to <code>EXTERNAL_KEY_STORE</code>. You must also use the
     * <code>CustomKeyStoreId</code> parameter to identify the external key store and the <code>XksKeyId</code>
     * parameter to identify the associated external key. The <code>KeySpec</code> value must be
     * <code>SYMMETRIC_DEFAULT</code>.
     * </p>
     * <p>
     * If the service returns an enum value that is not available in the current SDK version, {@link #origin} will
     * return {@link OriginType#UNKNOWN_TO_SDK_VERSION}. The raw value returned by the service is available from
     * {@link #originAsString}.
     * </p>
     * 
     * @return The source of the key material for the KMS key. You cannot change the origin after you create the KMS
     *         key. The default is <code>AWS_KMS</code>, which means that KMS creates the key material.</p>
     *         <p>
     *         To <a href="https://docs.aws.amazon.com/kms/latest/developerguide/importing-keys-create-cmk.html">create
     *         a KMS key with no key material</a> (for imported key material), set this value to <code>EXTERNAL</code>.
     *         For more information about importing key material into KMS, see <a
     *         href="https://docs.aws.amazon.com/kms/latest/developerguide/importing-keys.html">Importing Key
     *         Material</a> in the <i>Key Management Service Developer Guide</i>. The <code>EXTERNAL</code> origin value
     *         is valid only for symmetric KMS keys.
     *         </p>
     *         <p>
     *         To <a href="https://docs.aws.amazon.com/kms/latest/developerguide/create-cmk-keystore.html">create a KMS
     *         key in an CloudHSM key store</a> and create its key material in the associated CloudHSM cluster, set this
     *         value to <code>AWS_CLOUDHSM</code>. You must also use the <code>CustomKeyStoreId</code> parameter to
     *         identify the CloudHSM key store. The <code>KeySpec</code> value must be <code>SYMMETRIC_DEFAULT</code>.
     *         </p>
     *         <p>
     *         To <a href="https://docs.aws.amazon.com/kms/latest/developerguide/create-xks-keys.html">create a KMS key
     *         in an external key store</a>, set this value to <code>EXTERNAL_KEY_STORE</code>. You must also use the
     *         <code>CustomKeyStoreId</code> parameter to identify the external key store and the <code>XksKeyId</code>
     *         parameter to identify the associated external key. The <code>KeySpec</code> value must be
     *         <code>SYMMETRIC_DEFAULT</code>.
     * @see OriginType
     */
    public final String originAsString() {
        return origin;
    }

    /**
     * <p>
     * Creates the KMS key in the specified <a
     * href="https://docs.aws.amazon.com/kms/latest/developerguide/custom-key-store-overview.html">custom key store</a>.
     * The <code>ConnectionState</code> of the custom key store must be <code>CONNECTED</code>. To find the
     * CustomKeyStoreID and ConnectionState use the <a>DescribeCustomKeyStores</a> operation.
     * </p>
     * <p>
     * This parameter is valid only for symmetric encryption KMS keys in a single Region. You cannot create any other
     * type of KMS key in a custom key store.
     * </p>
     * <p>
     * When you create a KMS key in an CloudHSM key store, KMS generates a non-exportable 256-bit symmetric key in its
     * associated CloudHSM cluster and associates it with the KMS key. When you create a KMS key in an external key
     * store, you must use the <code>XksKeyId</code> parameter to specify an external key that serves as key material
     * for the KMS key.
     * </p>
     * 
     * @return Creates the KMS key in the specified <a
     *         href="https://docs.aws.amazon.com/kms/latest/developerguide/custom-key-store-overview.html">custom key
     *         store</a>. The <code>ConnectionState</code> of the custom key store must be <code>CONNECTED</code>. To
     *         find the CustomKeyStoreID and ConnectionState use the <a>DescribeCustomKeyStores</a> operation.</p>
     *         <p>
     *         This parameter is valid only for symmetric encryption KMS keys in a single Region. You cannot create any
     *         other type of KMS key in a custom key store.
     *         </p>
     *         <p>
     *         When you create a KMS key in an CloudHSM key store, KMS generates a non-exportable 256-bit symmetric key
     *         in its associated CloudHSM cluster and associates it with the KMS key. When you create a KMS key in an
     *         external key store, you must use the <code>XksKeyId</code> parameter to specify an external key that
     *         serves as key material for the KMS key.
     */
    public final String customKeyStoreId() {
        return customKeyStoreId;
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
     * Assigns one or more tags to the KMS key. Use this parameter to tag the KMS key when it is created. To tag an
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
     * @return Assigns one or more tags to the KMS key. Use this parameter to tag the KMS key when it is created. To tag
     *         an existing KMS key, use the <a>TagResource</a> operation.</p> <important>
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

    /**
     * <p>
     * Creates a multi-Region primary key that you can replicate into other Amazon Web Services Regions. You cannot
     * change this value after you create the KMS key.
     * </p>
     * <p>
     * For a multi-Region key, set this parameter to <code>True</code>. For a single-Region KMS key, omit this parameter
     * or set it to <code>False</code>. The default value is <code>False</code>.
     * </p>
     * <p>
     * This operation supports <i>multi-Region keys</i>, an KMS feature that lets you create multiple interoperable KMS
     * keys in different Amazon Web Services Regions. Because these KMS keys have the same key ID, key material, and
     * other metadata, you can use them interchangeably to encrypt data in one Amazon Web Services Region and decrypt it
     * in a different Amazon Web Services Region without re-encrypting the data or making a cross-Region call. For more
     * information about multi-Region keys, see <a
     * href="https://docs.aws.amazon.com/kms/latest/developerguide/multi-region-keys-overview.html">Multi-Region keys in
     * KMS</a> in the <i>Key Management Service Developer Guide</i>.
     * </p>
     * <p>
     * This value creates a <i>primary key</i>, not a replica. To create a <i>replica key</i>, use the
     * <a>ReplicateKey</a> operation.
     * </p>
     * <p>
     * You can create a symmetric or asymmetric multi-Region key, and you can create a multi-Region key with imported
     * key material. However, you cannot create a multi-Region key in a custom key store.
     * </p>
     * 
     * @return Creates a multi-Region primary key that you can replicate into other Amazon Web Services Regions. You
     *         cannot change this value after you create the KMS key. </p>
     *         <p>
     *         For a multi-Region key, set this parameter to <code>True</code>. For a single-Region KMS key, omit this
     *         parameter or set it to <code>False</code>. The default value is <code>False</code>.
     *         </p>
     *         <p>
     *         This operation supports <i>multi-Region keys</i>, an KMS feature that lets you create multiple
     *         interoperable KMS keys in different Amazon Web Services Regions. Because these KMS keys have the same key
     *         ID, key material, and other metadata, you can use them interchangeably to encrypt data in one Amazon Web
     *         Services Region and decrypt it in a different Amazon Web Services Region without re-encrypting the data
     *         or making a cross-Region call. For more information about multi-Region keys, see <a
     *         href="https://docs.aws.amazon.com/kms/latest/developerguide/multi-region-keys-overview.html">Multi-Region
     *         keys in KMS</a> in the <i>Key Management Service Developer Guide</i>.
     *         </p>
     *         <p>
     *         This value creates a <i>primary key</i>, not a replica. To create a <i>replica key</i>, use the
     *         <a>ReplicateKey</a> operation.
     *         </p>
     *         <p>
     *         You can create a symmetric or asymmetric multi-Region key, and you can create a multi-Region key with
     *         imported key material. However, you cannot create a multi-Region key in a custom key store.
     */
    public final Boolean multiRegion() {
        return multiRegion;
    }

    /**
     * <p>
     * Identifies the <a
     * href="https://docs.aws.amazon.com/kms/latest/developerguide/keystore-external.html#concept-external-key">external
     * key</a> that serves as key material for the KMS key in an <a
     * href="https://docs.aws.amazon.com/kms/latest/developerguide/keystore-external.html">external key store</a>.
     * Specify the ID that the <a
     * href="https://docs.aws.amazon.com/kms/latest/developerguide/keystore-external.html#concept-xks-proxy">external
     * key store proxy</a> uses to refer to the external key. For help, see the documentation for your external key
     * store proxy.
     * </p>
     * <p>
     * This parameter is required for a KMS key with an <code>Origin</code> value of <code>EXTERNAL_KEY_STORE</code>. It
     * is not valid for KMS keys with any other <code>Origin</code> value.
     * </p>
     * <p>
     * The external key must be an existing 256-bit AES symmetric encryption key hosted outside of Amazon Web Services
     * in an external key manager associated with the external key store specified by the <code>CustomKeyStoreId</code>
     * parameter. This key must be enabled and configured to perform encryption and decryption. Each KMS key in an
     * external key store must use a different external key. For details, see <a
     * href="https://docs.aws.amazon.com/create-xks-keys.html#xks-key-requirements">Requirements for a KMS key in an
     * external key store</a> in the <i>Key Management Service Developer Guide</i>.
     * </p>
     * <p>
     * Each KMS key in an external key store is associated two backing keys. One is key material that KMS generates. The
     * other is the external key specified by this parameter. When you use the KMS key in an external key store to
     * encrypt data, the encryption operation is performed first by KMS using the KMS key material, and then by the
     * external key manager using the specified external key, a process known as <i>double encryption</i>. For details,
     * see <a
     * href="https://docs.aws.amazon.com/kms/latest/developerguide/keystore-external.html#concept-double-encryption"
     * >Double encryption</a> in the <i>Key Management Service Developer Guide</i>.
     * </p>
     * 
     * @return Identifies the <a
     *         href="https://docs.aws.amazon.com/kms/latest/developerguide/keystore-external.html#concept-external-key"
     *         >external key</a> that serves as key material for the KMS key in an <a
     *         href="https://docs.aws.amazon.com/kms/latest/developerguide/keystore-external.html">external key
     *         store</a>. Specify the ID that the <a
     *         href="https://docs.aws.amazon.com/kms/latest/developerguide/keystore-external.html#concept-xks-proxy"
     *         >external key store proxy</a> uses to refer to the external key. For help, see the documentation for your
     *         external key store proxy.</p>
     *         <p>
     *         This parameter is required for a KMS key with an <code>Origin</code> value of
     *         <code>EXTERNAL_KEY_STORE</code>. It is not valid for KMS keys with any other <code>Origin</code> value.
     *         </p>
     *         <p>
     *         The external key must be an existing 256-bit AES symmetric encryption key hosted outside of Amazon Web
     *         Services in an external key manager associated with the external key store specified by the
     *         <code>CustomKeyStoreId</code> parameter. This key must be enabled and configured to perform encryption
     *         and decryption. Each KMS key in an external key store must use a different external key. For details, see
     *         <a href="https://docs.aws.amazon.com/create-xks-keys.html#xks-key-requirements">Requirements for a KMS
     *         key in an external key store</a> in the <i>Key Management Service Developer Guide</i>.
     *         </p>
     *         <p>
     *         Each KMS key in an external key store is associated two backing keys. One is key material that KMS
     *         generates. The other is the external key specified by this parameter. When you use the KMS key in an
     *         external key store to encrypt data, the encryption operation is performed first by KMS using the KMS key
     *         material, and then by the external key manager using the specified external key, a process known as
     *         <i>double encryption</i>. For details, see <a href=
     *         "https://docs.aws.amazon.com/kms/latest/developerguide/keystore-external.html#concept-double-encryption"
     *         >Double encryption</a> in the <i>Key Management Service Developer Guide</i>.
     */
    public final String xksKeyId() {
        return xksKeyId;
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
        hashCode = 31 * hashCode + Objects.hashCode(policy());
        hashCode = 31 * hashCode + Objects.hashCode(description());
        hashCode = 31 * hashCode + Objects.hashCode(keyUsageAsString());
        hashCode = 31 * hashCode + Objects.hashCode(customerMasterKeySpecAsString());
        hashCode = 31 * hashCode + Objects.hashCode(keySpecAsString());
        hashCode = 31 * hashCode + Objects.hashCode(originAsString());
        hashCode = 31 * hashCode + Objects.hashCode(customKeyStoreId());
        hashCode = 31 * hashCode + Objects.hashCode(bypassPolicyLockoutSafetyCheck());
        hashCode = 31 * hashCode + Objects.hashCode(hasTags() ? tags() : null);
        hashCode = 31 * hashCode + Objects.hashCode(multiRegion());
        hashCode = 31 * hashCode + Objects.hashCode(xksKeyId());
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
        if (!(obj instanceof CreateKeyRequest)) {
            return false;
        }
        CreateKeyRequest other = (CreateKeyRequest) obj;
        return Objects.equals(policy(), other.policy()) && Objects.equals(description(), other.description())
                && Objects.equals(keyUsageAsString(), other.keyUsageAsString())
                && Objects.equals(customerMasterKeySpecAsString(), other.customerMasterKeySpecAsString())
                && Objects.equals(keySpecAsString(), other.keySpecAsString())
                && Objects.equals(originAsString(), other.originAsString())
                && Objects.equals(customKeyStoreId(), other.customKeyStoreId())
                && Objects.equals(bypassPolicyLockoutSafetyCheck(), other.bypassPolicyLockoutSafetyCheck())
                && hasTags() == other.hasTags() && Objects.equals(tags(), other.tags())
                && Objects.equals(multiRegion(), other.multiRegion()) && Objects.equals(xksKeyId(), other.xksKeyId());
    }

    /**
     * Returns a string representation of this object. This is useful for testing and debugging. Sensitive data will be
     * redacted from this string using a placeholder value.
     */
    @Override
    public final String toString() {
        return ToString.builder("CreateKeyRequest").add("Policy", policy()).add("Description", description())
                .add("KeyUsage", keyUsageAsString()).add("CustomerMasterKeySpec", customerMasterKeySpecAsString())
                .add("KeySpec", keySpecAsString()).add("Origin", originAsString()).add("CustomKeyStoreId", customKeyStoreId())
                .add("BypassPolicyLockoutSafetyCheck", bypassPolicyLockoutSafetyCheck()).add("Tags", hasTags() ? tags() : null)
                .add("MultiRegion", multiRegion()).add("XksKeyId", xksKeyId()).build();
    }

    public final <T> Optional<T> getValueForField(String fieldName, Class<T> clazz) {
        switch (fieldName) {
        case "Policy":
            return Optional.ofNullable(clazz.cast(policy()));
        case "Description":
            return Optional.ofNullable(clazz.cast(description()));
        case "KeyUsage":
            return Optional.ofNullable(clazz.cast(keyUsageAsString()));
        case "CustomerMasterKeySpec":
            return Optional.ofNullable(clazz.cast(customerMasterKeySpecAsString()));
        case "KeySpec":
            return Optional.ofNullable(clazz.cast(keySpecAsString()));
        case "Origin":
            return Optional.ofNullable(clazz.cast(originAsString()));
        case "CustomKeyStoreId":
            return Optional.ofNullable(clazz.cast(customKeyStoreId()));
        case "BypassPolicyLockoutSafetyCheck":
            return Optional.ofNullable(clazz.cast(bypassPolicyLockoutSafetyCheck()));
        case "Tags":
            return Optional.ofNullable(clazz.cast(tags()));
        case "MultiRegion":
            return Optional.ofNullable(clazz.cast(multiRegion()));
        case "XksKeyId":
            return Optional.ofNullable(clazz.cast(xksKeyId()));
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
        map.put("Policy", POLICY_FIELD);
        map.put("Description", DESCRIPTION_FIELD);
        map.put("KeyUsage", KEY_USAGE_FIELD);
        map.put("CustomerMasterKeySpec", CUSTOMER_MASTER_KEY_SPEC_FIELD);
        map.put("KeySpec", KEY_SPEC_FIELD);
        map.put("Origin", ORIGIN_FIELD);
        map.put("CustomKeyStoreId", CUSTOM_KEY_STORE_ID_FIELD);
        map.put("BypassPolicyLockoutSafetyCheck", BYPASS_POLICY_LOCKOUT_SAFETY_CHECK_FIELD);
        map.put("Tags", TAGS_FIELD);
        map.put("MultiRegion", MULTI_REGION_FIELD);
        map.put("XksKeyId", XKS_KEY_ID_FIELD);
        return Collections.unmodifiableMap(map);
    }

    private static <T> Function<Object, T> getter(Function<CreateKeyRequest, T> g) {
        return obj -> g.apply((CreateKeyRequest) obj);
    }

    private static <T> BiConsumer<Object, T> setter(BiConsumer<Builder, T> s) {
        return (obj, val) -> s.accept((Builder) obj, val);
    }

    @Mutable
    @NotThreadSafe
    public interface Builder extends KmsRequest.Builder, SdkPojo, CopyableBuilder<Builder, CreateKeyRequest> {
        /**
         * <p>
         * The key policy to attach to the KMS key.
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
         * If you do not provide a key policy, KMS attaches a default key policy to the KMS key. For more information,
         * see <a
         * href="https://docs.aws.amazon.com/kms/latest/developerguide/key-policies.html#key-policy-default">Default key
         * policy</a> in the <i>Key Management Service Developer Guide</i>.
         * </p>
         * <p>
         * The key policy size quota is 32 kilobytes (32768 bytes).
         * </p>
         * <p>
         * For help writing and formatting a JSON policy document, see the <a
         * href="https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_policies.html">IAM JSON Policy Reference</a>
         * in the <i> <i>Identity and Access Management User Guide</i> </i>.
         * </p>
         * 
         * @param policy
         *        The key policy to attach to the KMS key.</p>
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
         *        If you do not provide a key policy, KMS attaches a default key policy to the KMS key. For more
         *        information, see <a
         *        href="https://docs.aws.amazon.com/kms/latest/developerguide/key-policies.html#key-policy-default"
         *        >Default key policy</a> in the <i>Key Management Service Developer Guide</i>.
         *        </p>
         *        <p>
         *        The key policy size quota is 32 kilobytes (32768 bytes).
         *        </p>
         *        <p>
         *        For help writing and formatting a JSON policy document, see the <a
         *        href="https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_policies.html">IAM JSON Policy
         *        Reference</a> in the <i> <i>Identity and Access Management User Guide</i> </i>.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder policy(String policy);

        /**
         * <p>
         * A description of the KMS key. Use a description that helps you decide whether the KMS key is appropriate for
         * a task. The default value is an empty string (no description).
         * </p>
         * <important>
         * <p>
         * Do not include confidential or sensitive information in this field. This field may be displayed in plaintext
         * in CloudTrail logs and other output.
         * </p>
         * </important>
         * <p>
         * To set or change the description after the key is created, use <a>UpdateKeyDescription</a>.
         * </p>
         * 
         * @param description
         *        A description of the KMS key. Use a description that helps you decide whether the KMS key is
         *        appropriate for a task. The default value is an empty string (no description).</p> <important>
         *        <p>
         *        Do not include confidential or sensitive information in this field. This field may be displayed in
         *        plaintext in CloudTrail logs and other output.
         *        </p>
         *        </important>
         *        <p>
         *        To set or change the description after the key is created, use <a>UpdateKeyDescription</a>.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder description(String description);

        /**
         * <p>
         * Determines the <a
         * href="https://docs.aws.amazon.com/kms/latest/developerguide/concepts.html#cryptographic-operations"
         * >cryptographic operations</a> for which you can use the KMS key. The default value is
         * <code>ENCRYPT_DECRYPT</code>. This parameter is optional when you are creating a symmetric encryption KMS
         * key; otherwise, it is required. You can't change the <code>KeyUsage</code> value after the KMS key is
         * created.
         * </p>
         * <p>
         * Select only one valid value.
         * </p>
         * <ul>
         * <li>
         * <p>
         * For symmetric encryption KMS keys, omit the parameter or specify <code>ENCRYPT_DECRYPT</code>.
         * </p>
         * </li>
         * <li>
         * <p>
         * For HMAC KMS keys (symmetric), specify <code>GENERATE_VERIFY_MAC</code>.
         * </p>
         * </li>
         * <li>
         * <p>
         * For asymmetric KMS keys with RSA key pairs, specify <code>ENCRYPT_DECRYPT</code> or <code>SIGN_VERIFY</code>.
         * </p>
         * </li>
         * <li>
         * <p>
         * For asymmetric KMS keys with NIST-recommended elliptic curve key pairs, specify <code>SIGN_VERIFY</code> or
         * <code>KEY_AGREEMENT</code>.
         * </p>
         * </li>
         * <li>
         * <p>
         * For asymmetric KMS keys with <code>ECC_SECG_P256K1</code> key pairs specify <code>SIGN_VERIFY</code>.
         * </p>
         * </li>
         * <li>
         * <p>
         * For asymmetric KMS keys with SM2 key pairs (China Regions only), specify <code>ENCRYPT_DECRYPT</code>,
         * <code>SIGN_VERIFY</code>, or <code>KEY_AGREEMENT</code>.
         * </p>
         * </li>
         * </ul>
         * 
         * @param keyUsage
         *        Determines the <a
         *        href="https://docs.aws.amazon.com/kms/latest/developerguide/concepts.html#cryptographic-operations"
         *        >cryptographic operations</a> for which you can use the KMS key. The default value is
         *        <code>ENCRYPT_DECRYPT</code>. This parameter is optional when you are creating a symmetric encryption
         *        KMS key; otherwise, it is required. You can't change the <code>KeyUsage</code> value after the KMS key
         *        is created.</p>
         *        <p>
         *        Select only one valid value.
         *        </p>
         *        <ul>
         *        <li>
         *        <p>
         *        For symmetric encryption KMS keys, omit the parameter or specify <code>ENCRYPT_DECRYPT</code>.
         *        </p>
         *        </li>
         *        <li>
         *        <p>
         *        For HMAC KMS keys (symmetric), specify <code>GENERATE_VERIFY_MAC</code>.
         *        </p>
         *        </li>
         *        <li>
         *        <p>
         *        For asymmetric KMS keys with RSA key pairs, specify <code>ENCRYPT_DECRYPT</code> or
         *        <code>SIGN_VERIFY</code>.
         *        </p>
         *        </li>
         *        <li>
         *        <p>
         *        For asymmetric KMS keys with NIST-recommended elliptic curve key pairs, specify
         *        <code>SIGN_VERIFY</code> or <code>KEY_AGREEMENT</code>.
         *        </p>
         *        </li>
         *        <li>
         *        <p>
         *        For asymmetric KMS keys with <code>ECC_SECG_P256K1</code> key pairs specify <code>SIGN_VERIFY</code>.
         *        </p>
         *        </li>
         *        <li>
         *        <p>
         *        For asymmetric KMS keys with SM2 key pairs (China Regions only), specify <code>ENCRYPT_DECRYPT</code>,
         *        <code>SIGN_VERIFY</code>, or <code>KEY_AGREEMENT</code>.
         *        </p>
         *        </li>
         * @see KeyUsageType
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see KeyUsageType
         */
        Builder keyUsage(String keyUsage);

        /**
         * <p>
         * Determines the <a
         * href="https://docs.aws.amazon.com/kms/latest/developerguide/concepts.html#cryptographic-operations"
         * >cryptographic operations</a> for which you can use the KMS key. The default value is
         * <code>ENCRYPT_DECRYPT</code>. This parameter is optional when you are creating a symmetric encryption KMS
         * key; otherwise, it is required. You can't change the <code>KeyUsage</code> value after the KMS key is
         * created.
         * </p>
         * <p>
         * Select only one valid value.
         * </p>
         * <ul>
         * <li>
         * <p>
         * For symmetric encryption KMS keys, omit the parameter or specify <code>ENCRYPT_DECRYPT</code>.
         * </p>
         * </li>
         * <li>
         * <p>
         * For HMAC KMS keys (symmetric), specify <code>GENERATE_VERIFY_MAC</code>.
         * </p>
         * </li>
         * <li>
         * <p>
         * For asymmetric KMS keys with RSA key pairs, specify <code>ENCRYPT_DECRYPT</code> or <code>SIGN_VERIFY</code>.
         * </p>
         * </li>
         * <li>
         * <p>
         * For asymmetric KMS keys with NIST-recommended elliptic curve key pairs, specify <code>SIGN_VERIFY</code> or
         * <code>KEY_AGREEMENT</code>.
         * </p>
         * </li>
         * <li>
         * <p>
         * For asymmetric KMS keys with <code>ECC_SECG_P256K1</code> key pairs specify <code>SIGN_VERIFY</code>.
         * </p>
         * </li>
         * <li>
         * <p>
         * For asymmetric KMS keys with SM2 key pairs (China Regions only), specify <code>ENCRYPT_DECRYPT</code>,
         * <code>SIGN_VERIFY</code>, or <code>KEY_AGREEMENT</code>.
         * </p>
         * </li>
         * </ul>
         * 
         * @param keyUsage
         *        Determines the <a
         *        href="https://docs.aws.amazon.com/kms/latest/developerguide/concepts.html#cryptographic-operations"
         *        >cryptographic operations</a> for which you can use the KMS key. The default value is
         *        <code>ENCRYPT_DECRYPT</code>. This parameter is optional when you are creating a symmetric encryption
         *        KMS key; otherwise, it is required. You can't change the <code>KeyUsage</code> value after the KMS key
         *        is created.</p>
         *        <p>
         *        Select only one valid value.
         *        </p>
         *        <ul>
         *        <li>
         *        <p>
         *        For symmetric encryption KMS keys, omit the parameter or specify <code>ENCRYPT_DECRYPT</code>.
         *        </p>
         *        </li>
         *        <li>
         *        <p>
         *        For HMAC KMS keys (symmetric), specify <code>GENERATE_VERIFY_MAC</code>.
         *        </p>
         *        </li>
         *        <li>
         *        <p>
         *        For asymmetric KMS keys with RSA key pairs, specify <code>ENCRYPT_DECRYPT</code> or
         *        <code>SIGN_VERIFY</code>.
         *        </p>
         *        </li>
         *        <li>
         *        <p>
         *        For asymmetric KMS keys with NIST-recommended elliptic curve key pairs, specify
         *        <code>SIGN_VERIFY</code> or <code>KEY_AGREEMENT</code>.
         *        </p>
         *        </li>
         *        <li>
         *        <p>
         *        For asymmetric KMS keys with <code>ECC_SECG_P256K1</code> key pairs specify <code>SIGN_VERIFY</code>.
         *        </p>
         *        </li>
         *        <li>
         *        <p>
         *        For asymmetric KMS keys with SM2 key pairs (China Regions only), specify <code>ENCRYPT_DECRYPT</code>,
         *        <code>SIGN_VERIFY</code>, or <code>KEY_AGREEMENT</code>.
         *        </p>
         *        </li>
         * @see KeyUsageType
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see KeyUsageType
         */
        Builder keyUsage(KeyUsageType keyUsage);

        /**
         * <p>
         * Instead, use the <code>KeySpec</code> parameter.
         * </p>
         * <p>
         * The <code>KeySpec</code> and <code>CustomerMasterKeySpec</code> parameters work the same way. Only the names
         * differ. We recommend that you use <code>KeySpec</code> parameter in your code. However, to avoid breaking
         * changes, KMS supports both parameters.
         * </p>
         * 
         * @param customerMasterKeySpec
         *        Instead, use the <code>KeySpec</code> parameter.</p>
         *        <p>
         *        The <code>KeySpec</code> and <code>CustomerMasterKeySpec</code> parameters work the same way. Only the
         *        names differ. We recommend that you use <code>KeySpec</code> parameter in your code. However, to avoid
         *        breaking changes, KMS supports both parameters.
         * @see CustomerMasterKeySpec
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see CustomerMasterKeySpec
         * @deprecated This parameter has been deprecated. Instead, use the KeySpec parameter.
         */
        @Deprecated
        Builder customerMasterKeySpec(String customerMasterKeySpec);

        /**
         * <p>
         * Instead, use the <code>KeySpec</code> parameter.
         * </p>
         * <p>
         * The <code>KeySpec</code> and <code>CustomerMasterKeySpec</code> parameters work the same way. Only the names
         * differ. We recommend that you use <code>KeySpec</code> parameter in your code. However, to avoid breaking
         * changes, KMS supports both parameters.
         * </p>
         * 
         * @param customerMasterKeySpec
         *        Instead, use the <code>KeySpec</code> parameter.</p>
         *        <p>
         *        The <code>KeySpec</code> and <code>CustomerMasterKeySpec</code> parameters work the same way. Only the
         *        names differ. We recommend that you use <code>KeySpec</code> parameter in your code. However, to avoid
         *        breaking changes, KMS supports both parameters.
         * @see CustomerMasterKeySpec
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see CustomerMasterKeySpec
         * @deprecated This parameter has been deprecated. Instead, use the KeySpec parameter.
         */
        @Deprecated
        Builder customerMasterKeySpec(CustomerMasterKeySpec customerMasterKeySpec);

        /**
         * <p>
         * Specifies the type of KMS key to create. The default value, <code>SYMMETRIC_DEFAULT</code>, creates a KMS key
         * with a 256-bit AES-GCM key that is used for encryption and decryption, except in China Regions, where it
         * creates a 128-bit symmetric key that uses SM4 encryption. For help choosing a key spec for your KMS key, see
         * <a href="https://docs.aws.amazon.com/kms/latest/developerguide/key-types.html#symm-asymm-choose">Choosing a
         * KMS key type</a> in the <i> <i>Key Management Service Developer Guide</i> </i>.
         * </p>
         * <p>
         * The <code>KeySpec</code> determines whether the KMS key contains a symmetric key or an asymmetric key pair.
         * It also determines the algorithms that the KMS key supports. You can't change the <code>KeySpec</code> after
         * the KMS key is created. To further restrict the algorithms that can be used with the KMS key, use a condition
         * key in its key policy or IAM policy. For more information, see <a href=
         * "https://docs.aws.amazon.com/kms/latest/developerguide/policy-conditions.html#conditions-kms-encryption-algorithm"
         * >kms:EncryptionAlgorithm</a>, <a href=
         * "https://docs.aws.amazon.com/kms/latest/developerguide/policy-conditions.html#conditions-kms-mac-algorithm"
         * >kms:MacAlgorithm</a> or <a href=
         * "https://docs.aws.amazon.com/kms/latest/developerguide/policy-conditions.html#conditions-kms-signing-algorithm"
         * >kms:Signing Algorithm</a> in the <i> <i>Key Management Service Developer Guide</i> </i>.
         * </p>
         * <important>
         * <p>
         * <a href="http://aws.amazon.com/kms/features/#AWS_Service_Integration">Amazon Web Services services that are
         * integrated with KMS</a> use symmetric encryption KMS keys to protect your data. These services do not support
         * asymmetric KMS keys or HMAC KMS keys.
         * </p>
         * </important>
         * <p>
         * KMS supports the following key specs for KMS keys:
         * </p>
         * <ul>
         * <li>
         * <p>
         * Symmetric encryption key (default)
         * </p>
         * <ul>
         * <li>
         * <p>
         * <code>SYMMETRIC_DEFAULT</code>
         * </p>
         * </li>
         * </ul>
         * </li>
         * <li>
         * <p>
         * HMAC keys (symmetric)
         * </p>
         * <ul>
         * <li>
         * <p>
         * <code>HMAC_224</code>
         * </p>
         * </li>
         * <li>
         * <p>
         * <code>HMAC_256</code>
         * </p>
         * </li>
         * <li>
         * <p>
         * <code>HMAC_384</code>
         * </p>
         * </li>
         * <li>
         * <p>
         * <code>HMAC_512</code>
         * </p>
         * </li>
         * </ul>
         * </li>
         * <li>
         * <p>
         * Asymmetric RSA key pairs (encryption and decryption -or- signing and verification)
         * </p>
         * <ul>
         * <li>
         * <p>
         * <code>RSA_2048</code>
         * </p>
         * </li>
         * <li>
         * <p>
         * <code>RSA_3072</code>
         * </p>
         * </li>
         * <li>
         * <p>
         * <code>RSA_4096</code>
         * </p>
         * </li>
         * </ul>
         * </li>
         * <li>
         * <p>
         * Asymmetric NIST-recommended elliptic curve key pairs (signing and verification -or- deriving shared secrets)
         * </p>
         * <ul>
         * <li>
         * <p>
         * <code>ECC_NIST_P256</code> (secp256r1)
         * </p>
         * </li>
         * <li>
         * <p>
         * <code>ECC_NIST_P384</code> (secp384r1)
         * </p>
         * </li>
         * <li>
         * <p>
         * <code>ECC_NIST_P521</code> (secp521r1)
         * </p>
         * </li>
         * </ul>
         * </li>
         * <li>
         * <p>
         * Other asymmetric elliptic curve key pairs (signing and verification)
         * </p>
         * <ul>
         * <li>
         * <p>
         * <code>ECC_SECG_P256K1</code> (secp256k1), commonly used for cryptocurrencies.
         * </p>
         * </li>
         * </ul>
         * </li>
         * <li>
         * <p>
         * SM2 key pairs (encryption and decryption -or- signing and verification -or- deriving shared secrets)
         * </p>
         * <ul>
         * <li>
         * <p>
         * <code>SM2</code> (China Regions only)
         * </p>
         * </li>
         * </ul>
         * </li>
         * </ul>
         * 
         * @param keySpec
         *        Specifies the type of KMS key to create. The default value, <code>SYMMETRIC_DEFAULT</code>, creates a
         *        KMS key with a 256-bit AES-GCM key that is used for encryption and decryption, except in China
         *        Regions, where it creates a 128-bit symmetric key that uses SM4 encryption. For help choosing a key
         *        spec for your KMS key, see <a
         *        href="https://docs.aws.amazon.com/kms/latest/developerguide/key-types.html#symm-asymm-choose">Choosing
         *        a KMS key type</a> in the <i> <i>Key Management Service Developer Guide</i> </i>.</p>
         *        <p>
         *        The <code>KeySpec</code> determines whether the KMS key contains a symmetric key or an asymmetric key
         *        pair. It also determines the algorithms that the KMS key supports. You can't change the
         *        <code>KeySpec</code> after the KMS key is created. To further restrict the algorithms that can be used
         *        with the KMS key, use a condition key in its key policy or IAM policy. For more information, see <a
         *        href=
         *        "https://docs.aws.amazon.com/kms/latest/developerguide/policy-conditions.html#conditions-kms-encryption-algorithm"
         *        >kms:EncryptionAlgorithm</a>, <a href=
         *        "https://docs.aws.amazon.com/kms/latest/developerguide/policy-conditions.html#conditions-kms-mac-algorithm"
         *        >kms:MacAlgorithm</a> or <a href=
         *        "https://docs.aws.amazon.com/kms/latest/developerguide/policy-conditions.html#conditions-kms-signing-algorithm"
         *        >kms:Signing Algorithm</a> in the <i> <i>Key Management Service Developer Guide</i> </i>.
         *        </p>
         *        <important>
         *        <p>
         *        <a href="http://aws.amazon.com/kms/features/#AWS_Service_Integration">Amazon Web Services services
         *        that are integrated with KMS</a> use symmetric encryption KMS keys to protect your data. These
         *        services do not support asymmetric KMS keys or HMAC KMS keys.
         *        </p>
         *        </important>
         *        <p>
         *        KMS supports the following key specs for KMS keys:
         *        </p>
         *        <ul>
         *        <li>
         *        <p>
         *        Symmetric encryption key (default)
         *        </p>
         *        <ul>
         *        <li>
         *        <p>
         *        <code>SYMMETRIC_DEFAULT</code>
         *        </p>
         *        </li>
         *        </ul>
         *        </li>
         *        <li>
         *        <p>
         *        HMAC keys (symmetric)
         *        </p>
         *        <ul>
         *        <li>
         *        <p>
         *        <code>HMAC_224</code>
         *        </p>
         *        </li>
         *        <li>
         *        <p>
         *        <code>HMAC_256</code>
         *        </p>
         *        </li>
         *        <li>
         *        <p>
         *        <code>HMAC_384</code>
         *        </p>
         *        </li>
         *        <li>
         *        <p>
         *        <code>HMAC_512</code>
         *        </p>
         *        </li>
         *        </ul>
         *        </li>
         *        <li>
         *        <p>
         *        Asymmetric RSA key pairs (encryption and decryption -or- signing and verification)
         *        </p>
         *        <ul>
         *        <li>
         *        <p>
         *        <code>RSA_2048</code>
         *        </p>
         *        </li>
         *        <li>
         *        <p>
         *        <code>RSA_3072</code>
         *        </p>
         *        </li>
         *        <li>
         *        <p>
         *        <code>RSA_4096</code>
         *        </p>
         *        </li>
         *        </ul>
         *        </li>
         *        <li>
         *        <p>
         *        Asymmetric NIST-recommended elliptic curve key pairs (signing and verification -or- deriving shared
         *        secrets)
         *        </p>
         *        <ul>
         *        <li>
         *        <p>
         *        <code>ECC_NIST_P256</code> (secp256r1)
         *        </p>
         *        </li>
         *        <li>
         *        <p>
         *        <code>ECC_NIST_P384</code> (secp384r1)
         *        </p>
         *        </li>
         *        <li>
         *        <p>
         *        <code>ECC_NIST_P521</code> (secp521r1)
         *        </p>
         *        </li>
         *        </ul>
         *        </li>
         *        <li>
         *        <p>
         *        Other asymmetric elliptic curve key pairs (signing and verification)
         *        </p>
         *        <ul>
         *        <li>
         *        <p>
         *        <code>ECC_SECG_P256K1</code> (secp256k1), commonly used for cryptocurrencies.
         *        </p>
         *        </li>
         *        </ul>
         *        </li>
         *        <li>
         *        <p>
         *        SM2 key pairs (encryption and decryption -or- signing and verification -or- deriving shared secrets)
         *        </p>
         *        <ul>
         *        <li>
         *        <p>
         *        <code>SM2</code> (China Regions only)
         *        </p>
         *        </li>
         *        </ul>
         *        </li>
         * @see KeySpec
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see KeySpec
         */
        Builder keySpec(String keySpec);

        /**
         * <p>
         * Specifies the type of KMS key to create. The default value, <code>SYMMETRIC_DEFAULT</code>, creates a KMS key
         * with a 256-bit AES-GCM key that is used for encryption and decryption, except in China Regions, where it
         * creates a 128-bit symmetric key that uses SM4 encryption. For help choosing a key spec for your KMS key, see
         * <a href="https://docs.aws.amazon.com/kms/latest/developerguide/key-types.html#symm-asymm-choose">Choosing a
         * KMS key type</a> in the <i> <i>Key Management Service Developer Guide</i> </i>.
         * </p>
         * <p>
         * The <code>KeySpec</code> determines whether the KMS key contains a symmetric key or an asymmetric key pair.
         * It also determines the algorithms that the KMS key supports. You can't change the <code>KeySpec</code> after
         * the KMS key is created. To further restrict the algorithms that can be used with the KMS key, use a condition
         * key in its key policy or IAM policy. For more information, see <a href=
         * "https://docs.aws.amazon.com/kms/latest/developerguide/policy-conditions.html#conditions-kms-encryption-algorithm"
         * >kms:EncryptionAlgorithm</a>, <a href=
         * "https://docs.aws.amazon.com/kms/latest/developerguide/policy-conditions.html#conditions-kms-mac-algorithm"
         * >kms:MacAlgorithm</a> or <a href=
         * "https://docs.aws.amazon.com/kms/latest/developerguide/policy-conditions.html#conditions-kms-signing-algorithm"
         * >kms:Signing Algorithm</a> in the <i> <i>Key Management Service Developer Guide</i> </i>.
         * </p>
         * <important>
         * <p>
         * <a href="http://aws.amazon.com/kms/features/#AWS_Service_Integration">Amazon Web Services services that are
         * integrated with KMS</a> use symmetric encryption KMS keys to protect your data. These services do not support
         * asymmetric KMS keys or HMAC KMS keys.
         * </p>
         * </important>
         * <p>
         * KMS supports the following key specs for KMS keys:
         * </p>
         * <ul>
         * <li>
         * <p>
         * Symmetric encryption key (default)
         * </p>
         * <ul>
         * <li>
         * <p>
         * <code>SYMMETRIC_DEFAULT</code>
         * </p>
         * </li>
         * </ul>
         * </li>
         * <li>
         * <p>
         * HMAC keys (symmetric)
         * </p>
         * <ul>
         * <li>
         * <p>
         * <code>HMAC_224</code>
         * </p>
         * </li>
         * <li>
         * <p>
         * <code>HMAC_256</code>
         * </p>
         * </li>
         * <li>
         * <p>
         * <code>HMAC_384</code>
         * </p>
         * </li>
         * <li>
         * <p>
         * <code>HMAC_512</code>
         * </p>
         * </li>
         * </ul>
         * </li>
         * <li>
         * <p>
         * Asymmetric RSA key pairs (encryption and decryption -or- signing and verification)
         * </p>
         * <ul>
         * <li>
         * <p>
         * <code>RSA_2048</code>
         * </p>
         * </li>
         * <li>
         * <p>
         * <code>RSA_3072</code>
         * </p>
         * </li>
         * <li>
         * <p>
         * <code>RSA_4096</code>
         * </p>
         * </li>
         * </ul>
         * </li>
         * <li>
         * <p>
         * Asymmetric NIST-recommended elliptic curve key pairs (signing and verification -or- deriving shared secrets)
         * </p>
         * <ul>
         * <li>
         * <p>
         * <code>ECC_NIST_P256</code> (secp256r1)
         * </p>
         * </li>
         * <li>
         * <p>
         * <code>ECC_NIST_P384</code> (secp384r1)
         * </p>
         * </li>
         * <li>
         * <p>
         * <code>ECC_NIST_P521</code> (secp521r1)
         * </p>
         * </li>
         * </ul>
         * </li>
         * <li>
         * <p>
         * Other asymmetric elliptic curve key pairs (signing and verification)
         * </p>
         * <ul>
         * <li>
         * <p>
         * <code>ECC_SECG_P256K1</code> (secp256k1), commonly used for cryptocurrencies.
         * </p>
         * </li>
         * </ul>
         * </li>
         * <li>
         * <p>
         * SM2 key pairs (encryption and decryption -or- signing and verification -or- deriving shared secrets)
         * </p>
         * <ul>
         * <li>
         * <p>
         * <code>SM2</code> (China Regions only)
         * </p>
         * </li>
         * </ul>
         * </li>
         * </ul>
         * 
         * @param keySpec
         *        Specifies the type of KMS key to create. The default value, <code>SYMMETRIC_DEFAULT</code>, creates a
         *        KMS key with a 256-bit AES-GCM key that is used for encryption and decryption, except in China
         *        Regions, where it creates a 128-bit symmetric key that uses SM4 encryption. For help choosing a key
         *        spec for your KMS key, see <a
         *        href="https://docs.aws.amazon.com/kms/latest/developerguide/key-types.html#symm-asymm-choose">Choosing
         *        a KMS key type</a> in the <i> <i>Key Management Service Developer Guide</i> </i>.</p>
         *        <p>
         *        The <code>KeySpec</code> determines whether the KMS key contains a symmetric key or an asymmetric key
         *        pair. It also determines the algorithms that the KMS key supports. You can't change the
         *        <code>KeySpec</code> after the KMS key is created. To further restrict the algorithms that can be used
         *        with the KMS key, use a condition key in its key policy or IAM policy. For more information, see <a
         *        href=
         *        "https://docs.aws.amazon.com/kms/latest/developerguide/policy-conditions.html#conditions-kms-encryption-algorithm"
         *        >kms:EncryptionAlgorithm</a>, <a href=
         *        "https://docs.aws.amazon.com/kms/latest/developerguide/policy-conditions.html#conditions-kms-mac-algorithm"
         *        >kms:MacAlgorithm</a> or <a href=
         *        "https://docs.aws.amazon.com/kms/latest/developerguide/policy-conditions.html#conditions-kms-signing-algorithm"
         *        >kms:Signing Algorithm</a> in the <i> <i>Key Management Service Developer Guide</i> </i>.
         *        </p>
         *        <important>
         *        <p>
         *        <a href="http://aws.amazon.com/kms/features/#AWS_Service_Integration">Amazon Web Services services
         *        that are integrated with KMS</a> use symmetric encryption KMS keys to protect your data. These
         *        services do not support asymmetric KMS keys or HMAC KMS keys.
         *        </p>
         *        </important>
         *        <p>
         *        KMS supports the following key specs for KMS keys:
         *        </p>
         *        <ul>
         *        <li>
         *        <p>
         *        Symmetric encryption key (default)
         *        </p>
         *        <ul>
         *        <li>
         *        <p>
         *        <code>SYMMETRIC_DEFAULT</code>
         *        </p>
         *        </li>
         *        </ul>
         *        </li>
         *        <li>
         *        <p>
         *        HMAC keys (symmetric)
         *        </p>
         *        <ul>
         *        <li>
         *        <p>
         *        <code>HMAC_224</code>
         *        </p>
         *        </li>
         *        <li>
         *        <p>
         *        <code>HMAC_256</code>
         *        </p>
         *        </li>
         *        <li>
         *        <p>
         *        <code>HMAC_384</code>
         *        </p>
         *        </li>
         *        <li>
         *        <p>
         *        <code>HMAC_512</code>
         *        </p>
         *        </li>
         *        </ul>
         *        </li>
         *        <li>
         *        <p>
         *        Asymmetric RSA key pairs (encryption and decryption -or- signing and verification)
         *        </p>
         *        <ul>
         *        <li>
         *        <p>
         *        <code>RSA_2048</code>
         *        </p>
         *        </li>
         *        <li>
         *        <p>
         *        <code>RSA_3072</code>
         *        </p>
         *        </li>
         *        <li>
         *        <p>
         *        <code>RSA_4096</code>
         *        </p>
         *        </li>
         *        </ul>
         *        </li>
         *        <li>
         *        <p>
         *        Asymmetric NIST-recommended elliptic curve key pairs (signing and verification -or- deriving shared
         *        secrets)
         *        </p>
         *        <ul>
         *        <li>
         *        <p>
         *        <code>ECC_NIST_P256</code> (secp256r1)
         *        </p>
         *        </li>
         *        <li>
         *        <p>
         *        <code>ECC_NIST_P384</code> (secp384r1)
         *        </p>
         *        </li>
         *        <li>
         *        <p>
         *        <code>ECC_NIST_P521</code> (secp521r1)
         *        </p>
         *        </li>
         *        </ul>
         *        </li>
         *        <li>
         *        <p>
         *        Other asymmetric elliptic curve key pairs (signing and verification)
         *        </p>
         *        <ul>
         *        <li>
         *        <p>
         *        <code>ECC_SECG_P256K1</code> (secp256k1), commonly used for cryptocurrencies.
         *        </p>
         *        </li>
         *        </ul>
         *        </li>
         *        <li>
         *        <p>
         *        SM2 key pairs (encryption and decryption -or- signing and verification -or- deriving shared secrets)
         *        </p>
         *        <ul>
         *        <li>
         *        <p>
         *        <code>SM2</code> (China Regions only)
         *        </p>
         *        </li>
         *        </ul>
         *        </li>
         * @see KeySpec
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see KeySpec
         */
        Builder keySpec(KeySpec keySpec);

        /**
         * <p>
         * The source of the key material for the KMS key. You cannot change the origin after you create the KMS key.
         * The default is <code>AWS_KMS</code>, which means that KMS creates the key material.
         * </p>
         * <p>
         * To <a href="https://docs.aws.amazon.com/kms/latest/developerguide/importing-keys-create-cmk.html">create a
         * KMS key with no key material</a> (for imported key material), set this value to <code>EXTERNAL</code>. For
         * more information about importing key material into KMS, see <a
         * href="https://docs.aws.amazon.com/kms/latest/developerguide/importing-keys.html">Importing Key Material</a>
         * in the <i>Key Management Service Developer Guide</i>. The <code>EXTERNAL</code> origin value is valid only
         * for symmetric KMS keys.
         * </p>
         * <p>
         * To <a href="https://docs.aws.amazon.com/kms/latest/developerguide/create-cmk-keystore.html">create a KMS key
         * in an CloudHSM key store</a> and create its key material in the associated CloudHSM cluster, set this value
         * to <code>AWS_CLOUDHSM</code>. You must also use the <code>CustomKeyStoreId</code> parameter to identify the
         * CloudHSM key store. The <code>KeySpec</code> value must be <code>SYMMETRIC_DEFAULT</code>.
         * </p>
         * <p>
         * To <a href="https://docs.aws.amazon.com/kms/latest/developerguide/create-xks-keys.html">create a KMS key in
         * an external key store</a>, set this value to <code>EXTERNAL_KEY_STORE</code>. You must also use the
         * <code>CustomKeyStoreId</code> parameter to identify the external key store and the <code>XksKeyId</code>
         * parameter to identify the associated external key. The <code>KeySpec</code> value must be
         * <code>SYMMETRIC_DEFAULT</code>.
         * </p>
         * 
         * @param origin
         *        The source of the key material for the KMS key. You cannot change the origin after you create the KMS
         *        key. The default is <code>AWS_KMS</code>, which means that KMS creates the key material.</p>
         *        <p>
         *        To <a
         *        href="https://docs.aws.amazon.com/kms/latest/developerguide/importing-keys-create-cmk.html">create a
         *        KMS key with no key material</a> (for imported key material), set this value to <code>EXTERNAL</code>.
         *        For more information about importing key material into KMS, see <a
         *        href="https://docs.aws.amazon.com/kms/latest/developerguide/importing-keys.html">Importing Key
         *        Material</a> in the <i>Key Management Service Developer Guide</i>. The <code>EXTERNAL</code> origin
         *        value is valid only for symmetric KMS keys.
         *        </p>
         *        <p>
         *        To <a href="https://docs.aws.amazon.com/kms/latest/developerguide/create-cmk-keystore.html">create a
         *        KMS key in an CloudHSM key store</a> and create its key material in the associated CloudHSM cluster,
         *        set this value to <code>AWS_CLOUDHSM</code>. You must also use the <code>CustomKeyStoreId</code>
         *        parameter to identify the CloudHSM key store. The <code>KeySpec</code> value must be
         *        <code>SYMMETRIC_DEFAULT</code>.
         *        </p>
         *        <p>
         *        To <a href="https://docs.aws.amazon.com/kms/latest/developerguide/create-xks-keys.html">create a KMS
         *        key in an external key store</a>, set this value to <code>EXTERNAL_KEY_STORE</code>. You must also use
         *        the <code>CustomKeyStoreId</code> parameter to identify the external key store and the
         *        <code>XksKeyId</code> parameter to identify the associated external key. The <code>KeySpec</code>
         *        value must be <code>SYMMETRIC_DEFAULT</code>.
         * @see OriginType
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see OriginType
         */
        Builder origin(String origin);

        /**
         * <p>
         * The source of the key material for the KMS key. You cannot change the origin after you create the KMS key.
         * The default is <code>AWS_KMS</code>, which means that KMS creates the key material.
         * </p>
         * <p>
         * To <a href="https://docs.aws.amazon.com/kms/latest/developerguide/importing-keys-create-cmk.html">create a
         * KMS key with no key material</a> (for imported key material), set this value to <code>EXTERNAL</code>. For
         * more information about importing key material into KMS, see <a
         * href="https://docs.aws.amazon.com/kms/latest/developerguide/importing-keys.html">Importing Key Material</a>
         * in the <i>Key Management Service Developer Guide</i>. The <code>EXTERNAL</code> origin value is valid only
         * for symmetric KMS keys.
         * </p>
         * <p>
         * To <a href="https://docs.aws.amazon.com/kms/latest/developerguide/create-cmk-keystore.html">create a KMS key
         * in an CloudHSM key store</a> and create its key material in the associated CloudHSM cluster, set this value
         * to <code>AWS_CLOUDHSM</code>. You must also use the <code>CustomKeyStoreId</code> parameter to identify the
         * CloudHSM key store. The <code>KeySpec</code> value must be <code>SYMMETRIC_DEFAULT</code>.
         * </p>
         * <p>
         * To <a href="https://docs.aws.amazon.com/kms/latest/developerguide/create-xks-keys.html">create a KMS key in
         * an external key store</a>, set this value to <code>EXTERNAL_KEY_STORE</code>. You must also use the
         * <code>CustomKeyStoreId</code> parameter to identify the external key store and the <code>XksKeyId</code>
         * parameter to identify the associated external key. The <code>KeySpec</code> value must be
         * <code>SYMMETRIC_DEFAULT</code>.
         * </p>
         * 
         * @param origin
         *        The source of the key material for the KMS key. You cannot change the origin after you create the KMS
         *        key. The default is <code>AWS_KMS</code>, which means that KMS creates the key material.</p>
         *        <p>
         *        To <a
         *        href="https://docs.aws.amazon.com/kms/latest/developerguide/importing-keys-create-cmk.html">create a
         *        KMS key with no key material</a> (for imported key material), set this value to <code>EXTERNAL</code>.
         *        For more information about importing key material into KMS, see <a
         *        href="https://docs.aws.amazon.com/kms/latest/developerguide/importing-keys.html">Importing Key
         *        Material</a> in the <i>Key Management Service Developer Guide</i>. The <code>EXTERNAL</code> origin
         *        value is valid only for symmetric KMS keys.
         *        </p>
         *        <p>
         *        To <a href="https://docs.aws.amazon.com/kms/latest/developerguide/create-cmk-keystore.html">create a
         *        KMS key in an CloudHSM key store</a> and create its key material in the associated CloudHSM cluster,
         *        set this value to <code>AWS_CLOUDHSM</code>. You must also use the <code>CustomKeyStoreId</code>
         *        parameter to identify the CloudHSM key store. The <code>KeySpec</code> value must be
         *        <code>SYMMETRIC_DEFAULT</code>.
         *        </p>
         *        <p>
         *        To <a href="https://docs.aws.amazon.com/kms/latest/developerguide/create-xks-keys.html">create a KMS
         *        key in an external key store</a>, set this value to <code>EXTERNAL_KEY_STORE</code>. You must also use
         *        the <code>CustomKeyStoreId</code> parameter to identify the external key store and the
         *        <code>XksKeyId</code> parameter to identify the associated external key. The <code>KeySpec</code>
         *        value must be <code>SYMMETRIC_DEFAULT</code>.
         * @see OriginType
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see OriginType
         */
        Builder origin(OriginType origin);

        /**
         * <p>
         * Creates the KMS key in the specified <a
         * href="https://docs.aws.amazon.com/kms/latest/developerguide/custom-key-store-overview.html">custom key
         * store</a>. The <code>ConnectionState</code> of the custom key store must be <code>CONNECTED</code>. To find
         * the CustomKeyStoreID and ConnectionState use the <a>DescribeCustomKeyStores</a> operation.
         * </p>
         * <p>
         * This parameter is valid only for symmetric encryption KMS keys in a single Region. You cannot create any
         * other type of KMS key in a custom key store.
         * </p>
         * <p>
         * When you create a KMS key in an CloudHSM key store, KMS generates a non-exportable 256-bit symmetric key in
         * its associated CloudHSM cluster and associates it with the KMS key. When you create a KMS key in an external
         * key store, you must use the <code>XksKeyId</code> parameter to specify an external key that serves as key
         * material for the KMS key.
         * </p>
         * 
         * @param customKeyStoreId
         *        Creates the KMS key in the specified <a
         *        href="https://docs.aws.amazon.com/kms/latest/developerguide/custom-key-store-overview.html">custom key
         *        store</a>. The <code>ConnectionState</code> of the custom key store must be <code>CONNECTED</code>. To
         *        find the CustomKeyStoreID and ConnectionState use the <a>DescribeCustomKeyStores</a> operation.</p>
         *        <p>
         *        This parameter is valid only for symmetric encryption KMS keys in a single Region. You cannot create
         *        any other type of KMS key in a custom key store.
         *        </p>
         *        <p>
         *        When you create a KMS key in an CloudHSM key store, KMS generates a non-exportable 256-bit symmetric
         *        key in its associated CloudHSM cluster and associates it with the KMS key. When you create a KMS key
         *        in an external key store, you must use the <code>XksKeyId</code> parameter to specify an external key
         *        that serves as key material for the KMS key.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder customKeyStoreId(String customKeyStoreId);

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
         * Assigns one or more tags to the KMS key. Use this parameter to tag the KMS key when it is created. To tag an
         * existing KMS key, use the <a>TagResource</a> operation.
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
         *        Assigns one or more tags to the KMS key. Use this parameter to tag the KMS key when it is created. To
         *        tag an existing KMS key, use the <a>TagResource</a> operation.</p> <important>
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
         * Assigns one or more tags to the KMS key. Use this parameter to tag the KMS key when it is created. To tag an
         * existing KMS key, use the <a>TagResource</a> operation.
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
         *        Assigns one or more tags to the KMS key. Use this parameter to tag the KMS key when it is created. To
         *        tag an existing KMS key, use the <a>TagResource</a> operation.</p> <important>
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
         * Assigns one or more tags to the KMS key. Use this parameter to tag the KMS key when it is created. To tag an
         * existing KMS key, use the <a>TagResource</a> operation.
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

        /**
         * <p>
         * Creates a multi-Region primary key that you can replicate into other Amazon Web Services Regions. You cannot
         * change this value after you create the KMS key.
         * </p>
         * <p>
         * For a multi-Region key, set this parameter to <code>True</code>. For a single-Region KMS key, omit this
         * parameter or set it to <code>False</code>. The default value is <code>False</code>.
         * </p>
         * <p>
         * This operation supports <i>multi-Region keys</i>, an KMS feature that lets you create multiple interoperable
         * KMS keys in different Amazon Web Services Regions. Because these KMS keys have the same key ID, key material,
         * and other metadata, you can use them interchangeably to encrypt data in one Amazon Web Services Region and
         * decrypt it in a different Amazon Web Services Region without re-encrypting the data or making a cross-Region
         * call. For more information about multi-Region keys, see <a
         * href="https://docs.aws.amazon.com/kms/latest/developerguide/multi-region-keys-overview.html">Multi-Region
         * keys in KMS</a> in the <i>Key Management Service Developer Guide</i>.
         * </p>
         * <p>
         * This value creates a <i>primary key</i>, not a replica. To create a <i>replica key</i>, use the
         * <a>ReplicateKey</a> operation.
         * </p>
         * <p>
         * You can create a symmetric or asymmetric multi-Region key, and you can create a multi-Region key with
         * imported key material. However, you cannot create a multi-Region key in a custom key store.
         * </p>
         * 
         * @param multiRegion
         *        Creates a multi-Region primary key that you can replicate into other Amazon Web Services Regions. You
         *        cannot change this value after you create the KMS key. </p>
         *        <p>
         *        For a multi-Region key, set this parameter to <code>True</code>. For a single-Region KMS key, omit
         *        this parameter or set it to <code>False</code>. The default value is <code>False</code>.
         *        </p>
         *        <p>
         *        This operation supports <i>multi-Region keys</i>, an KMS feature that lets you create multiple
         *        interoperable KMS keys in different Amazon Web Services Regions. Because these KMS keys have the same
         *        key ID, key material, and other metadata, you can use them interchangeably to encrypt data in one
         *        Amazon Web Services Region and decrypt it in a different Amazon Web Services Region without
         *        re-encrypting the data or making a cross-Region call. For more information about multi-Region keys,
         *        see <a
         *        href="https://docs.aws.amazon.com/kms/latest/developerguide/multi-region-keys-overview.html">Multi
         *        -Region keys in KMS</a> in the <i>Key Management Service Developer Guide</i>.
         *        </p>
         *        <p>
         *        This value creates a <i>primary key</i>, not a replica. To create a <i>replica key</i>, use the
         *        <a>ReplicateKey</a> operation.
         *        </p>
         *        <p>
         *        You can create a symmetric or asymmetric multi-Region key, and you can create a multi-Region key with
         *        imported key material. However, you cannot create a multi-Region key in a custom key store.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder multiRegion(Boolean multiRegion);

        /**
         * <p>
         * Identifies the <a
         * href="https://docs.aws.amazon.com/kms/latest/developerguide/keystore-external.html#concept-external-key"
         * >external key</a> that serves as key material for the KMS key in an <a
         * href="https://docs.aws.amazon.com/kms/latest/developerguide/keystore-external.html">external key store</a>.
         * Specify the ID that the <a
         * href="https://docs.aws.amazon.com/kms/latest/developerguide/keystore-external.html#concept-xks-proxy"
         * >external key store proxy</a> uses to refer to the external key. For help, see the documentation for your
         * external key store proxy.
         * </p>
         * <p>
         * This parameter is required for a KMS key with an <code>Origin</code> value of <code>EXTERNAL_KEY_STORE</code>
         * . It is not valid for KMS keys with any other <code>Origin</code> value.
         * </p>
         * <p>
         * The external key must be an existing 256-bit AES symmetric encryption key hosted outside of Amazon Web
         * Services in an external key manager associated with the external key store specified by the
         * <code>CustomKeyStoreId</code> parameter. This key must be enabled and configured to perform encryption and
         * decryption. Each KMS key in an external key store must use a different external key. For details, see <a
         * href="https://docs.aws.amazon.com/create-xks-keys.html#xks-key-requirements">Requirements for a KMS key in an
         * external key store</a> in the <i>Key Management Service Developer Guide</i>.
         * </p>
         * <p>
         * Each KMS key in an external key store is associated two backing keys. One is key material that KMS generates.
         * The other is the external key specified by this parameter. When you use the KMS key in an external key store
         * to encrypt data, the encryption operation is performed first by KMS using the KMS key material, and then by
         * the external key manager using the specified external key, a process known as <i>double encryption</i>. For
         * details, see <a href=
         * "https://docs.aws.amazon.com/kms/latest/developerguide/keystore-external.html#concept-double-encryption"
         * >Double encryption</a> in the <i>Key Management Service Developer Guide</i>.
         * </p>
         * 
         * @param xksKeyId
         *        Identifies the <a href=
         *        "https://docs.aws.amazon.com/kms/latest/developerguide/keystore-external.html#concept-external-key"
         *        >external key</a> that serves as key material for the KMS key in an <a
         *        href="https://docs.aws.amazon.com/kms/latest/developerguide/keystore-external.html">external key
         *        store</a>. Specify the ID that the <a href=
         *        "https://docs.aws.amazon.com/kms/latest/developerguide/keystore-external.html#concept-xks-proxy"
         *        >external key store proxy</a> uses to refer to the external key. For help, see the documentation for
         *        your external key store proxy.</p>
         *        <p>
         *        This parameter is required for a KMS key with an <code>Origin</code> value of
         *        <code>EXTERNAL_KEY_STORE</code>. It is not valid for KMS keys with any other <code>Origin</code>
         *        value.
         *        </p>
         *        <p>
         *        The external key must be an existing 256-bit AES symmetric encryption key hosted outside of Amazon Web
         *        Services in an external key manager associated with the external key store specified by the
         *        <code>CustomKeyStoreId</code> parameter. This key must be enabled and configured to perform encryption
         *        and decryption. Each KMS key in an external key store must use a different external key. For details,
         *        see <a href="https://docs.aws.amazon.com/create-xks-keys.html#xks-key-requirements">Requirements for a
         *        KMS key in an external key store</a> in the <i>Key Management Service Developer Guide</i>.
         *        </p>
         *        <p>
         *        Each KMS key in an external key store is associated two backing keys. One is key material that KMS
         *        generates. The other is the external key specified by this parameter. When you use the KMS key in an
         *        external key store to encrypt data, the encryption operation is performed first by KMS using the KMS
         *        key material, and then by the external key manager using the specified external key, a process known
         *        as <i>double encryption</i>. For details, see <a href=
         *        "https://docs.aws.amazon.com/kms/latest/developerguide/keystore-external.html#concept-double-encryption"
         *        >Double encryption</a> in the <i>Key Management Service Developer Guide</i>.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder xksKeyId(String xksKeyId);

        @Override
        Builder overrideConfiguration(AwsRequestOverrideConfiguration overrideConfiguration);

        @Override
        Builder overrideConfiguration(Consumer<AwsRequestOverrideConfiguration.Builder> builderConsumer);
    }

    static final class BuilderImpl extends KmsRequest.BuilderImpl implements Builder {
        private String policy;

        private String description;

        private String keyUsage;

        private String customerMasterKeySpec;

        private String keySpec;

        private String origin;

        private String customKeyStoreId;

        private Boolean bypassPolicyLockoutSafetyCheck;

        private List<Tag> tags = DefaultSdkAutoConstructList.getInstance();

        private Boolean multiRegion;

        private String xksKeyId;

        private BuilderImpl() {
        }

        private BuilderImpl(CreateKeyRequest model) {
            super(model);
            policy(model.policy);
            description(model.description);
            keyUsage(model.keyUsage);
            customerMasterKeySpec(model.customerMasterKeySpec);
            keySpec(model.keySpec);
            origin(model.origin);
            customKeyStoreId(model.customKeyStoreId);
            bypassPolicyLockoutSafetyCheck(model.bypassPolicyLockoutSafetyCheck);
            tags(model.tags);
            multiRegion(model.multiRegion);
            xksKeyId(model.xksKeyId);
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

        public final String getKeyUsage() {
            return keyUsage;
        }

        public final void setKeyUsage(String keyUsage) {
            this.keyUsage = keyUsage;
        }

        @Override
        public final Builder keyUsage(String keyUsage) {
            this.keyUsage = keyUsage;
            return this;
        }

        @Override
        public final Builder keyUsage(KeyUsageType keyUsage) {
            this.keyUsage(keyUsage == null ? null : keyUsage.toString());
            return this;
        }

        @Deprecated
        public final String getCustomerMasterKeySpec() {
            return customerMasterKeySpec;
        }

        @Deprecated
        public final void setCustomerMasterKeySpec(String customerMasterKeySpec) {
            this.customerMasterKeySpec = customerMasterKeySpec;
        }

        @Override
        @Deprecated
        public final Builder customerMasterKeySpec(String customerMasterKeySpec) {
            this.customerMasterKeySpec = customerMasterKeySpec;
            return this;
        }

        @Override
        @Deprecated
        public final Builder customerMasterKeySpec(CustomerMasterKeySpec customerMasterKeySpec) {
            this.customerMasterKeySpec(customerMasterKeySpec == null ? null : customerMasterKeySpec.toString());
            return this;
        }

        public final String getKeySpec() {
            return keySpec;
        }

        public final void setKeySpec(String keySpec) {
            this.keySpec = keySpec;
        }

        @Override
        public final Builder keySpec(String keySpec) {
            this.keySpec = keySpec;
            return this;
        }

        @Override
        public final Builder keySpec(KeySpec keySpec) {
            this.keySpec(keySpec == null ? null : keySpec.toString());
            return this;
        }

        public final String getOrigin() {
            return origin;
        }

        public final void setOrigin(String origin) {
            this.origin = origin;
        }

        @Override
        public final Builder origin(String origin) {
            this.origin = origin;
            return this;
        }

        @Override
        public final Builder origin(OriginType origin) {
            this.origin(origin == null ? null : origin.toString());
            return this;
        }

        public final String getCustomKeyStoreId() {
            return customKeyStoreId;
        }

        public final void setCustomKeyStoreId(String customKeyStoreId) {
            this.customKeyStoreId = customKeyStoreId;
        }

        @Override
        public final Builder customKeyStoreId(String customKeyStoreId) {
            this.customKeyStoreId = customKeyStoreId;
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

        public final Boolean getMultiRegion() {
            return multiRegion;
        }

        public final void setMultiRegion(Boolean multiRegion) {
            this.multiRegion = multiRegion;
        }

        @Override
        public final Builder multiRegion(Boolean multiRegion) {
            this.multiRegion = multiRegion;
            return this;
        }

        public final String getXksKeyId() {
            return xksKeyId;
        }

        public final void setXksKeyId(String xksKeyId) {
            this.xksKeyId = xksKeyId;
        }

        @Override
        public final Builder xksKeyId(String xksKeyId) {
            this.xksKeyId = xksKeyId;
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
        public CreateKeyRequest build() {
            return new CreateKeyRequest(this);
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
