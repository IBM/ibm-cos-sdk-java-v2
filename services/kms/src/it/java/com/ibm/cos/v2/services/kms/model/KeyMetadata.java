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

import java.io.Serializable;
import java.time.Instant;
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
import com.ibm.cos.v2.annotations.Generated;
import com.ibm.cos.v2.annotations.Mutable;
import com.ibm.cos.v2.annotations.NotThreadSafe;
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
 * <p>
 * Contains metadata about a KMS key.
 * </p>
 * <p>
 * This data type is used as a response element for the <a>CreateKey</a>, <a>DescribeKey</a>, and <a>ReplicateKey</a>
 * operations.
 * </p>
 */
@Generated("com.ibm.cos.v2:codegen")
public final class KeyMetadata implements SdkPojo, Serializable, ToCopyableBuilder<KeyMetadata.Builder, KeyMetadata> {
    private static final SdkField<String> AWS_ACCOUNT_ID_FIELD = SdkField.<String> builder(MarshallingType.STRING)
            .memberName("AWSAccountId").getter(getter(KeyMetadata::awsAccountId)).setter(setter(Builder::awsAccountId))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("AWSAccountId").build()).build();

    private static final SdkField<String> KEY_ID_FIELD = SdkField.<String> builder(MarshallingType.STRING).memberName("KeyId")
            .getter(getter(KeyMetadata::keyId)).setter(setter(Builder::keyId))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("KeyId").build()).build();

    private static final SdkField<String> ARN_FIELD = SdkField.<String> builder(MarshallingType.STRING).memberName("Arn")
            .getter(getter(KeyMetadata::arn)).setter(setter(Builder::arn))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("Arn").build()).build();

    private static final SdkField<Instant> CREATION_DATE_FIELD = SdkField.<Instant> builder(MarshallingType.INSTANT)
            .memberName("CreationDate").getter(getter(KeyMetadata::creationDate)).setter(setter(Builder::creationDate))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("CreationDate").build()).build();

    private static final SdkField<Boolean> ENABLED_FIELD = SdkField.<Boolean> builder(MarshallingType.BOOLEAN)
            .memberName("Enabled").getter(getter(KeyMetadata::enabled)).setter(setter(Builder::enabled))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("Enabled").build()).build();

    private static final SdkField<String> DESCRIPTION_FIELD = SdkField.<String> builder(MarshallingType.STRING)
            .memberName("Description").getter(getter(KeyMetadata::description)).setter(setter(Builder::description))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("Description").build()).build();

    private static final SdkField<String> KEY_USAGE_FIELD = SdkField.<String> builder(MarshallingType.STRING)
            .memberName("KeyUsage").getter(getter(KeyMetadata::keyUsageAsString)).setter(setter(Builder::keyUsage))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("KeyUsage").build()).build();

    private static final SdkField<String> KEY_STATE_FIELD = SdkField.<String> builder(MarshallingType.STRING)
            .memberName("KeyState").getter(getter(KeyMetadata::keyStateAsString)).setter(setter(Builder::keyState))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("KeyState").build()).build();

    private static final SdkField<Instant> DELETION_DATE_FIELD = SdkField.<Instant> builder(MarshallingType.INSTANT)
            .memberName("DeletionDate").getter(getter(KeyMetadata::deletionDate)).setter(setter(Builder::deletionDate))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("DeletionDate").build()).build();

    private static final SdkField<Instant> VALID_TO_FIELD = SdkField.<Instant> builder(MarshallingType.INSTANT)
            .memberName("ValidTo").getter(getter(KeyMetadata::validTo)).setter(setter(Builder::validTo))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("ValidTo").build()).build();

    private static final SdkField<String> ORIGIN_FIELD = SdkField.<String> builder(MarshallingType.STRING).memberName("Origin")
            .getter(getter(KeyMetadata::originAsString)).setter(setter(Builder::origin))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("Origin").build()).build();

    private static final SdkField<String> CUSTOM_KEY_STORE_ID_FIELD = SdkField.<String> builder(MarshallingType.STRING)
            .memberName("CustomKeyStoreId").getter(getter(KeyMetadata::customKeyStoreId))
            .setter(setter(Builder::customKeyStoreId))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("CustomKeyStoreId").build()).build();

    private static final SdkField<String> CLOUD_HSM_CLUSTER_ID_FIELD = SdkField.<String> builder(MarshallingType.STRING)
            .memberName("CloudHsmClusterId").getter(getter(KeyMetadata::cloudHsmClusterId))
            .setter(setter(Builder::cloudHsmClusterId))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("CloudHsmClusterId").build()).build();

    private static final SdkField<String> EXPIRATION_MODEL_FIELD = SdkField.<String> builder(MarshallingType.STRING)
            .memberName("ExpirationModel").getter(getter(KeyMetadata::expirationModelAsString))
            .setter(setter(Builder::expirationModel))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("ExpirationModel").build()).build();

    private static final SdkField<String> KEY_MANAGER_FIELD = SdkField.<String> builder(MarshallingType.STRING)
            .memberName("KeyManager").getter(getter(KeyMetadata::keyManagerAsString)).setter(setter(Builder::keyManager))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("KeyManager").build()).build();

    private static final SdkField<String> CUSTOMER_MASTER_KEY_SPEC_FIELD = SdkField.<String> builder(MarshallingType.STRING)
            .memberName("CustomerMasterKeySpec").getter(getter(KeyMetadata::customerMasterKeySpecAsString))
            .setter(setter(Builder::customerMasterKeySpec))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("CustomerMasterKeySpec").build())
            .build();

    private static final SdkField<String> KEY_SPEC_FIELD = SdkField.<String> builder(MarshallingType.STRING)
            .memberName("KeySpec").getter(getter(KeyMetadata::keySpecAsString)).setter(setter(Builder::keySpec))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("KeySpec").build()).build();

    private static final SdkField<List<String>> ENCRYPTION_ALGORITHMS_FIELD = SdkField
            .<List<String>> builder(MarshallingType.LIST)
            .memberName("EncryptionAlgorithms")
            .getter(getter(KeyMetadata::encryptionAlgorithmsAsStrings))
            .setter(setter(Builder::encryptionAlgorithmsWithStrings))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("EncryptionAlgorithms").build(),
                    ListTrait
                            .builder()
                            .memberLocationName(null)
                            .memberFieldInfo(
                                    SdkField.<String> builder(MarshallingType.STRING)
                                            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD)
                                                    .locationName("member").build()).build()).build()).build();

    private static final SdkField<List<String>> SIGNING_ALGORITHMS_FIELD = SdkField
            .<List<String>> builder(MarshallingType.LIST)
            .memberName("SigningAlgorithms")
            .getter(getter(KeyMetadata::signingAlgorithmsAsStrings))
            .setter(setter(Builder::signingAlgorithmsWithStrings))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("SigningAlgorithms").build(),
                    ListTrait
                            .builder()
                            .memberLocationName(null)
                            .memberFieldInfo(
                                    SdkField.<String> builder(MarshallingType.STRING)
                                            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD)
                                                    .locationName("member").build()).build()).build()).build();

    private static final SdkField<List<String>> KEY_AGREEMENT_ALGORITHMS_FIELD = SdkField
            .<List<String>> builder(MarshallingType.LIST)
            .memberName("KeyAgreementAlgorithms")
            .getter(getter(KeyMetadata::keyAgreementAlgorithmsAsStrings))
            .setter(setter(Builder::keyAgreementAlgorithmsWithStrings))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("KeyAgreementAlgorithms").build(),
                    ListTrait
                            .builder()
                            .memberLocationName(null)
                            .memberFieldInfo(
                                    SdkField.<String> builder(MarshallingType.STRING)
                                            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD)
                                                    .locationName("member").build()).build()).build()).build();

    private static final SdkField<Boolean> MULTI_REGION_FIELD = SdkField.<Boolean> builder(MarshallingType.BOOLEAN)
            .memberName("MultiRegion").getter(getter(KeyMetadata::multiRegion)).setter(setter(Builder::multiRegion))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("MultiRegion").build()).build();

    private static final SdkField<MultiRegionConfiguration> MULTI_REGION_CONFIGURATION_FIELD = SdkField
            .<MultiRegionConfiguration> builder(MarshallingType.SDK_POJO).memberName("MultiRegionConfiguration")
            .getter(getter(KeyMetadata::multiRegionConfiguration)).setter(setter(Builder::multiRegionConfiguration))
            .constructor(MultiRegionConfiguration::builder)
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("MultiRegionConfiguration").build())
            .build();

    private static final SdkField<Integer> PENDING_DELETION_WINDOW_IN_DAYS_FIELD = SdkField
            .<Integer> builder(MarshallingType.INTEGER)
            .memberName("PendingDeletionWindowInDays")
            .getter(getter(KeyMetadata::pendingDeletionWindowInDays))
            .setter(setter(Builder::pendingDeletionWindowInDays))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("PendingDeletionWindowInDays")
                    .build()).build();

    private static final SdkField<List<String>> MAC_ALGORITHMS_FIELD = SdkField
            .<List<String>> builder(MarshallingType.LIST)
            .memberName("MacAlgorithms")
            .getter(getter(KeyMetadata::macAlgorithmsAsStrings))
            .setter(setter(Builder::macAlgorithmsWithStrings))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("MacAlgorithms").build(),
                    ListTrait
                            .builder()
                            .memberLocationName(null)
                            .memberFieldInfo(
                                    SdkField.<String> builder(MarshallingType.STRING)
                                            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD)
                                                    .locationName("member").build()).build()).build()).build();

    private static final SdkField<XksKeyConfigurationType> XKS_KEY_CONFIGURATION_FIELD = SdkField
            .<XksKeyConfigurationType> builder(MarshallingType.SDK_POJO).memberName("XksKeyConfiguration")
            .getter(getter(KeyMetadata::xksKeyConfiguration)).setter(setter(Builder::xksKeyConfiguration))
            .constructor(XksKeyConfigurationType::builder)
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("XksKeyConfiguration").build())
            .build();

    private static final List<SdkField<?>> SDK_FIELDS = Collections.unmodifiableList(Arrays.asList(AWS_ACCOUNT_ID_FIELD,
            KEY_ID_FIELD, ARN_FIELD, CREATION_DATE_FIELD, ENABLED_FIELD, DESCRIPTION_FIELD, KEY_USAGE_FIELD, KEY_STATE_FIELD,
            DELETION_DATE_FIELD, VALID_TO_FIELD, ORIGIN_FIELD, CUSTOM_KEY_STORE_ID_FIELD, CLOUD_HSM_CLUSTER_ID_FIELD,
            EXPIRATION_MODEL_FIELD, KEY_MANAGER_FIELD, CUSTOMER_MASTER_KEY_SPEC_FIELD, KEY_SPEC_FIELD,
            ENCRYPTION_ALGORITHMS_FIELD, SIGNING_ALGORITHMS_FIELD, KEY_AGREEMENT_ALGORITHMS_FIELD, MULTI_REGION_FIELD,
            MULTI_REGION_CONFIGURATION_FIELD, PENDING_DELETION_WINDOW_IN_DAYS_FIELD, MAC_ALGORITHMS_FIELD,
            XKS_KEY_CONFIGURATION_FIELD));

    private static final Map<String, SdkField<?>> SDK_NAME_TO_FIELD = memberNameToFieldInitializer();

    private static final long serialVersionUID = 1L;

    private final String awsAccountId;

    private final String keyId;

    private final String arn;

    private final Instant creationDate;

    private final Boolean enabled;

    private final String description;

    private final String keyUsage;

    private final String keyState;

    private final Instant deletionDate;

    private final Instant validTo;

    private final String origin;

    private final String customKeyStoreId;

    private final String cloudHsmClusterId;

    private final String expirationModel;

    private final String keyManager;

    private final String customerMasterKeySpec;

    private final String keySpec;

    private final List<String> encryptionAlgorithms;

    private final List<String> signingAlgorithms;

    private final List<String> keyAgreementAlgorithms;

    private final Boolean multiRegion;

    private final MultiRegionConfiguration multiRegionConfiguration;

    private final Integer pendingDeletionWindowInDays;

    private final List<String> macAlgorithms;

    private final XksKeyConfigurationType xksKeyConfiguration;

    private KeyMetadata(BuilderImpl builder) {
        this.awsAccountId = builder.awsAccountId;
        this.keyId = builder.keyId;
        this.arn = builder.arn;
        this.creationDate = builder.creationDate;
        this.enabled = builder.enabled;
        this.description = builder.description;
        this.keyUsage = builder.keyUsage;
        this.keyState = builder.keyState;
        this.deletionDate = builder.deletionDate;
        this.validTo = builder.validTo;
        this.origin = builder.origin;
        this.customKeyStoreId = builder.customKeyStoreId;
        this.cloudHsmClusterId = builder.cloudHsmClusterId;
        this.expirationModel = builder.expirationModel;
        this.keyManager = builder.keyManager;
        this.customerMasterKeySpec = builder.customerMasterKeySpec;
        this.keySpec = builder.keySpec;
        this.encryptionAlgorithms = builder.encryptionAlgorithms;
        this.signingAlgorithms = builder.signingAlgorithms;
        this.keyAgreementAlgorithms = builder.keyAgreementAlgorithms;
        this.multiRegion = builder.multiRegion;
        this.multiRegionConfiguration = builder.multiRegionConfiguration;
        this.pendingDeletionWindowInDays = builder.pendingDeletionWindowInDays;
        this.macAlgorithms = builder.macAlgorithms;
        this.xksKeyConfiguration = builder.xksKeyConfiguration;
    }

    /**
     * <p>
     * The twelve-digit account ID of the Amazon Web Services account that owns the KMS key.
     * </p>
     * 
     * @return The twelve-digit account ID of the Amazon Web Services account that owns the KMS key.
     */
    public final String awsAccountId() {
        return awsAccountId;
    }

    /**
     * <p>
     * The globally unique identifier for the KMS key.
     * </p>
     * 
     * @return The globally unique identifier for the KMS key.
     */
    public final String keyId() {
        return keyId;
    }

    /**
     * <p>
     * The Amazon Resource Name (ARN) of the KMS key. For examples, see <a
     * href="https://docs.aws.amazon.com/general/latest/gr/aws-arns-and-namespaces.html#arn-syntax-kms">Key Management
     * Service (KMS)</a> in the Example ARNs section of the <i>Amazon Web Services General Reference</i>.
     * </p>
     * 
     * @return The Amazon Resource Name (ARN) of the KMS key. For examples, see <a
     *         href="https://docs.aws.amazon.com/general/latest/gr/aws-arns-and-namespaces.html#arn-syntax-kms">Key
     *         Management Service (KMS)</a> in the Example ARNs section of the <i>Amazon Web Services General
     *         Reference</i>.
     */
    public final String arn() {
        return arn;
    }

    /**
     * <p>
     * The date and time when the KMS key was created.
     * </p>
     * 
     * @return The date and time when the KMS key was created.
     */
    public final Instant creationDate() {
        return creationDate;
    }

    /**
     * <p>
     * Specifies whether the KMS key is enabled. When <code>KeyState</code> is <code>Enabled</code> this value is true,
     * otherwise it is false.
     * </p>
     * 
     * @return Specifies whether the KMS key is enabled. When <code>KeyState</code> is <code>Enabled</code> this value
     *         is true, otherwise it is false.
     */
    public final Boolean enabled() {
        return enabled;
    }

    /**
     * <p>
     * The description of the KMS key.
     * </p>
     * 
     * @return The description of the KMS key.
     */
    public final String description() {
        return description;
    }

    /**
     * <p>
     * The <a href="https://docs.aws.amazon.com/kms/latest/developerguide/concepts.html#cryptographic-operations">
     * cryptographic operations</a> for which you can use the KMS key.
     * </p>
     * <p>
     * If the service returns an enum value that is not available in the current SDK version, {@link #keyUsage} will
     * return {@link KeyUsageType#UNKNOWN_TO_SDK_VERSION}. The raw value returned by the service is available from
     * {@link #keyUsageAsString}.
     * </p>
     * 
     * @return The <a
     *         href="https://docs.aws.amazon.com/kms/latest/developerguide/concepts.html#cryptographic-operations"
     *         >cryptographic operations</a> for which you can use the KMS key.
     * @see KeyUsageType
     */
    public final KeyUsageType keyUsage() {
        return KeyUsageType.fromValue(keyUsage);
    }

    /**
     * <p>
     * The <a href="https://docs.aws.amazon.com/kms/latest/developerguide/concepts.html#cryptographic-operations">
     * cryptographic operations</a> for which you can use the KMS key.
     * </p>
     * <p>
     * If the service returns an enum value that is not available in the current SDK version, {@link #keyUsage} will
     * return {@link KeyUsageType#UNKNOWN_TO_SDK_VERSION}. The raw value returned by the service is available from
     * {@link #keyUsageAsString}.
     * </p>
     * 
     * @return The <a
     *         href="https://docs.aws.amazon.com/kms/latest/developerguide/concepts.html#cryptographic-operations"
     *         >cryptographic operations</a> for which you can use the KMS key.
     * @see KeyUsageType
     */
    public final String keyUsageAsString() {
        return keyUsage;
    }

    /**
     * <p>
     * The current status of the KMS key.
     * </p>
     * <p>
     * For more information about how key state affects the use of a KMS key, see <a
     * href="https://docs.aws.amazon.com/kms/latest/developerguide/key-state.html">Key states of KMS keys</a> in the
     * <i>Key Management Service Developer Guide</i>.
     * </p>
     * <p>
     * If the service returns an enum value that is not available in the current SDK version, {@link #keyState} will
     * return {@link KeyState#UNKNOWN_TO_SDK_VERSION}. The raw value returned by the service is available from
     * {@link #keyStateAsString}.
     * </p>
     * 
     * @return The current status of the KMS key.</p>
     *         <p>
     *         For more information about how key state affects the use of a KMS key, see <a
     *         href="https://docs.aws.amazon.com/kms/latest/developerguide/key-state.html">Key states of KMS keys</a> in
     *         the <i>Key Management Service Developer Guide</i>.
     * @see KeyState
     */
    public final KeyState keyState() {
        return KeyState.fromValue(keyState);
    }

    /**
     * <p>
     * The current status of the KMS key.
     * </p>
     * <p>
     * For more information about how key state affects the use of a KMS key, see <a
     * href="https://docs.aws.amazon.com/kms/latest/developerguide/key-state.html">Key states of KMS keys</a> in the
     * <i>Key Management Service Developer Guide</i>.
     * </p>
     * <p>
     * If the service returns an enum value that is not available in the current SDK version, {@link #keyState} will
     * return {@link KeyState#UNKNOWN_TO_SDK_VERSION}. The raw value returned by the service is available from
     * {@link #keyStateAsString}.
     * </p>
     * 
     * @return The current status of the KMS key.</p>
     *         <p>
     *         For more information about how key state affects the use of a KMS key, see <a
     *         href="https://docs.aws.amazon.com/kms/latest/developerguide/key-state.html">Key states of KMS keys</a> in
     *         the <i>Key Management Service Developer Guide</i>.
     * @see KeyState
     */
    public final String keyStateAsString() {
        return keyState;
    }

    /**
     * <p>
     * The date and time after which KMS deletes this KMS key. This value is present only when the KMS key is scheduled
     * for deletion, that is, when its <code>KeyState</code> is <code>PendingDeletion</code>.
     * </p>
     * <p>
     * When the primary key in a multi-Region key is scheduled for deletion but still has replica keys, its key state is
     * <code>PendingReplicaDeletion</code> and the length of its waiting period is displayed in the
     * <code>PendingDeletionWindowInDays</code> field.
     * </p>
     * 
     * @return The date and time after which KMS deletes this KMS key. This value is present only when the KMS key is
     *         scheduled for deletion, that is, when its <code>KeyState</code> is <code>PendingDeletion</code>.</p>
     *         <p>
     *         When the primary key in a multi-Region key is scheduled for deletion but still has replica keys, its key
     *         state is <code>PendingReplicaDeletion</code> and the length of its waiting period is displayed in the
     *         <code>PendingDeletionWindowInDays</code> field.
     */
    public final Instant deletionDate() {
        return deletionDate;
    }

    /**
     * <p>
     * The time at which the imported key material expires. When the key material expires, KMS deletes the key material
     * and the KMS key becomes unusable. This value is present only for KMS keys whose <code>Origin</code> is
     * <code>EXTERNAL</code> and whose <code>ExpirationModel</code> is <code>KEY_MATERIAL_EXPIRES</code>, otherwise this
     * value is omitted.
     * </p>
     * 
     * @return The time at which the imported key material expires. When the key material expires, KMS deletes the key
     *         material and the KMS key becomes unusable. This value is present only for KMS keys whose
     *         <code>Origin</code> is <code>EXTERNAL</code> and whose <code>ExpirationModel</code> is
     *         <code>KEY_MATERIAL_EXPIRES</code>, otherwise this value is omitted.
     */
    public final Instant validTo() {
        return validTo;
    }

    /**
     * <p>
     * The source of the key material for the KMS key. When this value is <code>AWS_KMS</code>, KMS created the key
     * material. When this value is <code>EXTERNAL</code>, the key material was imported or the KMS key doesn't have any
     * key material. When this value is <code>AWS_CLOUDHSM</code>, the key material was created in the CloudHSM cluster
     * associated with a custom key store.
     * </p>
     * <p>
     * If the service returns an enum value that is not available in the current SDK version, {@link #origin} will
     * return {@link OriginType#UNKNOWN_TO_SDK_VERSION}. The raw value returned by the service is available from
     * {@link #originAsString}.
     * </p>
     * 
     * @return The source of the key material for the KMS key. When this value is <code>AWS_KMS</code>, KMS created the
     *         key material. When this value is <code>EXTERNAL</code>, the key material was imported or the KMS key
     *         doesn't have any key material. When this value is <code>AWS_CLOUDHSM</code>, the key material was created
     *         in the CloudHSM cluster associated with a custom key store.
     * @see OriginType
     */
    public final OriginType origin() {
        return OriginType.fromValue(origin);
    }

    /**
     * <p>
     * The source of the key material for the KMS key. When this value is <code>AWS_KMS</code>, KMS created the key
     * material. When this value is <code>EXTERNAL</code>, the key material was imported or the KMS key doesn't have any
     * key material. When this value is <code>AWS_CLOUDHSM</code>, the key material was created in the CloudHSM cluster
     * associated with a custom key store.
     * </p>
     * <p>
     * If the service returns an enum value that is not available in the current SDK version, {@link #origin} will
     * return {@link OriginType#UNKNOWN_TO_SDK_VERSION}. The raw value returned by the service is available from
     * {@link #originAsString}.
     * </p>
     * 
     * @return The source of the key material for the KMS key. When this value is <code>AWS_KMS</code>, KMS created the
     *         key material. When this value is <code>EXTERNAL</code>, the key material was imported or the KMS key
     *         doesn't have any key material. When this value is <code>AWS_CLOUDHSM</code>, the key material was created
     *         in the CloudHSM cluster associated with a custom key store.
     * @see OriginType
     */
    public final String originAsString() {
        return origin;
    }

    /**
     * <p>
     * A unique identifier for the <a
     * href="https://docs.aws.amazon.com/kms/latest/developerguide/custom-key-store-overview.html">custom key store</a>
     * that contains the KMS key. This field is present only when the KMS key is created in a custom key store.
     * </p>
     * 
     * @return A unique identifier for the <a
     *         href="https://docs.aws.amazon.com/kms/latest/developerguide/custom-key-store-overview.html">custom key
     *         store</a> that contains the KMS key. This field is present only when the KMS key is created in a custom
     *         key store.
     */
    public final String customKeyStoreId() {
        return customKeyStoreId;
    }

    /**
     * <p>
     * The cluster ID of the CloudHSM cluster that contains the key material for the KMS key. When you create a KMS key
     * in an CloudHSM <a
     * href="https://docs.aws.amazon.com/kms/latest/developerguide/custom-key-store-overview.html">custom key store</a>,
     * KMS creates the key material for the KMS key in the associated CloudHSM cluster. This field is present only when
     * the KMS key is created in an CloudHSM key store.
     * </p>
     * 
     * @return The cluster ID of the CloudHSM cluster that contains the key material for the KMS key. When you create a
     *         KMS key in an CloudHSM <a
     *         href="https://docs.aws.amazon.com/kms/latest/developerguide/custom-key-store-overview.html">custom key
     *         store</a>, KMS creates the key material for the KMS key in the associated CloudHSM cluster. This field is
     *         present only when the KMS key is created in an CloudHSM key store.
     */
    public final String cloudHsmClusterId() {
        return cloudHsmClusterId;
    }

    /**
     * <p>
     * Specifies whether the KMS key's key material expires. This value is present only when <code>Origin</code> is
     * <code>EXTERNAL</code>, otherwise this value is omitted.
     * </p>
     * <p>
     * If the service returns an enum value that is not available in the current SDK version, {@link #expirationModel}
     * will return {@link ExpirationModelType#UNKNOWN_TO_SDK_VERSION}. The raw value returned by the service is
     * available from {@link #expirationModelAsString}.
     * </p>
     * 
     * @return Specifies whether the KMS key's key material expires. This value is present only when <code>Origin</code>
     *         is <code>EXTERNAL</code>, otherwise this value is omitted.
     * @see ExpirationModelType
     */
    public final ExpirationModelType expirationModel() {
        return ExpirationModelType.fromValue(expirationModel);
    }

    /**
     * <p>
     * Specifies whether the KMS key's key material expires. This value is present only when <code>Origin</code> is
     * <code>EXTERNAL</code>, otherwise this value is omitted.
     * </p>
     * <p>
     * If the service returns an enum value that is not available in the current SDK version, {@link #expirationModel}
     * will return {@link ExpirationModelType#UNKNOWN_TO_SDK_VERSION}. The raw value returned by the service is
     * available from {@link #expirationModelAsString}.
     * </p>
     * 
     * @return Specifies whether the KMS key's key material expires. This value is present only when <code>Origin</code>
     *         is <code>EXTERNAL</code>, otherwise this value is omitted.
     * @see ExpirationModelType
     */
    public final String expirationModelAsString() {
        return expirationModel;
    }

    /**
     * <p>
     * The manager of the KMS key. KMS keys in your Amazon Web Services account are either customer managed or Amazon
     * Web Services managed. For more information about the difference, see <a
     * href="https://docs.aws.amazon.com/kms/latest/developerguide/concepts.html#kms_keys">KMS keys</a> in the <i>Key
     * Management Service Developer Guide</i>.
     * </p>
     * <p>
     * If the service returns an enum value that is not available in the current SDK version, {@link #keyManager} will
     * return {@link KeyManagerType#UNKNOWN_TO_SDK_VERSION}. The raw value returned by the service is available from
     * {@link #keyManagerAsString}.
     * </p>
     * 
     * @return The manager of the KMS key. KMS keys in your Amazon Web Services account are either customer managed or
     *         Amazon Web Services managed. For more information about the difference, see <a
     *         href="https://docs.aws.amazon.com/kms/latest/developerguide/concepts.html#kms_keys">KMS keys</a> in the
     *         <i>Key Management Service Developer Guide</i>.
     * @see KeyManagerType
     */
    public final KeyManagerType keyManager() {
        return KeyManagerType.fromValue(keyManager);
    }

    /**
     * <p>
     * The manager of the KMS key. KMS keys in your Amazon Web Services account are either customer managed or Amazon
     * Web Services managed. For more information about the difference, see <a
     * href="https://docs.aws.amazon.com/kms/latest/developerguide/concepts.html#kms_keys">KMS keys</a> in the <i>Key
     * Management Service Developer Guide</i>.
     * </p>
     * <p>
     * If the service returns an enum value that is not available in the current SDK version, {@link #keyManager} will
     * return {@link KeyManagerType#UNKNOWN_TO_SDK_VERSION}. The raw value returned by the service is available from
     * {@link #keyManagerAsString}.
     * </p>
     * 
     * @return The manager of the KMS key. KMS keys in your Amazon Web Services account are either customer managed or
     *         Amazon Web Services managed. For more information about the difference, see <a
     *         href="https://docs.aws.amazon.com/kms/latest/developerguide/concepts.html#kms_keys">KMS keys</a> in the
     *         <i>Key Management Service Developer Guide</i>.
     * @see KeyManagerType
     */
    public final String keyManagerAsString() {
        return keyManager;
    }

    /**
     * <p>
     * Instead, use the <code>KeySpec</code> field.
     * </p>
     * <p>
     * The <code>KeySpec</code> and <code>CustomerMasterKeySpec</code> fields have the same value. We recommend that you
     * use the <code>KeySpec</code> field in your code. However, to avoid breaking changes, KMS supports both fields.
     * </p>
     * <p>
     * If the service returns an enum value that is not available in the current SDK version,
     * {@link #customerMasterKeySpec} will return {@link CustomerMasterKeySpec#UNKNOWN_TO_SDK_VERSION}. The raw value
     * returned by the service is available from {@link #customerMasterKeySpecAsString}.
     * </p>
     * 
     * @return Instead, use the <code>KeySpec</code> field.</p>
     *         <p>
     *         The <code>KeySpec</code> and <code>CustomerMasterKeySpec</code> fields have the same value. We recommend
     *         that you use the <code>KeySpec</code> field in your code. However, to avoid breaking changes, KMS
     *         supports both fields.
     * @see CustomerMasterKeySpec
     * @deprecated This field has been deprecated. Instead, use the KeySpec field.
     */
    @Deprecated
    public final CustomerMasterKeySpec customerMasterKeySpec() {
        return CustomerMasterKeySpec.fromValue(customerMasterKeySpec);
    }

    /**
     * <p>
     * Instead, use the <code>KeySpec</code> field.
     * </p>
     * <p>
     * The <code>KeySpec</code> and <code>CustomerMasterKeySpec</code> fields have the same value. We recommend that you
     * use the <code>KeySpec</code> field in your code. However, to avoid breaking changes, KMS supports both fields.
     * </p>
     * <p>
     * If the service returns an enum value that is not available in the current SDK version,
     * {@link #customerMasterKeySpec} will return {@link CustomerMasterKeySpec#UNKNOWN_TO_SDK_VERSION}. The raw value
     * returned by the service is available from {@link #customerMasterKeySpecAsString}.
     * </p>
     * 
     * @return Instead, use the <code>KeySpec</code> field.</p>
     *         <p>
     *         The <code>KeySpec</code> and <code>CustomerMasterKeySpec</code> fields have the same value. We recommend
     *         that you use the <code>KeySpec</code> field in your code. However, to avoid breaking changes, KMS
     *         supports both fields.
     * @see CustomerMasterKeySpec
     * @deprecated This field has been deprecated. Instead, use the KeySpec field.
     */
    @Deprecated
    public final String customerMasterKeySpecAsString() {
        return customerMasterKeySpec;
    }

    /**
     * <p>
     * Describes the type of key material in the KMS key.
     * </p>
     * <p>
     * If the service returns an enum value that is not available in the current SDK version, {@link #keySpec} will
     * return {@link KeySpec#UNKNOWN_TO_SDK_VERSION}. The raw value returned by the service is available from
     * {@link #keySpecAsString}.
     * </p>
     * 
     * @return Describes the type of key material in the KMS key.
     * @see KeySpec
     */
    public final KeySpec keySpec() {
        return KeySpec.fromValue(keySpec);
    }

    /**
     * <p>
     * Describes the type of key material in the KMS key.
     * </p>
     * <p>
     * If the service returns an enum value that is not available in the current SDK version, {@link #keySpec} will
     * return {@link KeySpec#UNKNOWN_TO_SDK_VERSION}. The raw value returned by the service is available from
     * {@link #keySpecAsString}.
     * </p>
     * 
     * @return Describes the type of key material in the KMS key.
     * @see KeySpec
     */
    public final String keySpecAsString() {
        return keySpec;
    }

    /**
     * <p>
     * The encryption algorithms that the KMS key supports. You cannot use the KMS key with other encryption algorithms
     * within KMS.
     * </p>
     * <p>
     * This value is present only when the <code>KeyUsage</code> of the KMS key is <code>ENCRYPT_DECRYPT</code>.
     * </p>
     * <p>
     * Attempts to modify the collection returned by this method will result in an UnsupportedOperationException.
     * </p>
     * <p>
     * This method will never return null. If you would like to know whether the service returned this field (so that
     * you can differentiate between null and empty), you can use the {@link #hasEncryptionAlgorithms} method.
     * </p>
     * 
     * @return The encryption algorithms that the KMS key supports. You cannot use the KMS key with other encryption
     *         algorithms within KMS.</p>
     *         <p>
     *         This value is present only when the <code>KeyUsage</code> of the KMS key is <code>ENCRYPT_DECRYPT</code>.
     */
    public final List<EncryptionAlgorithmSpec> encryptionAlgorithms() {
        return EncryptionAlgorithmSpecListCopier.copyStringToEnum(encryptionAlgorithms);
    }

    /**
     * For responses, this returns true if the service returned a value for the EncryptionAlgorithms property. This DOES
     * NOT check that the value is non-empty (for which, you should check the {@code isEmpty()} method on the property).
     * This is useful because the SDK will never return a null collection or map, but you may need to differentiate
     * between the service returning nothing (or null) and the service returning an empty collection or map. For
     * requests, this returns true if a value for the property was specified in the request builder, and false if a
     * value was not specified.
     */
    public final boolean hasEncryptionAlgorithms() {
        return encryptionAlgorithms != null && !(encryptionAlgorithms instanceof SdkAutoConstructList);
    }

    /**
     * <p>
     * The encryption algorithms that the KMS key supports. You cannot use the KMS key with other encryption algorithms
     * within KMS.
     * </p>
     * <p>
     * This value is present only when the <code>KeyUsage</code> of the KMS key is <code>ENCRYPT_DECRYPT</code>.
     * </p>
     * <p>
     * Attempts to modify the collection returned by this method will result in an UnsupportedOperationException.
     * </p>
     * <p>
     * This method will never return null. If you would like to know whether the service returned this field (so that
     * you can differentiate between null and empty), you can use the {@link #hasEncryptionAlgorithms} method.
     * </p>
     * 
     * @return The encryption algorithms that the KMS key supports. You cannot use the KMS key with other encryption
     *         algorithms within KMS.</p>
     *         <p>
     *         This value is present only when the <code>KeyUsage</code> of the KMS key is <code>ENCRYPT_DECRYPT</code>.
     */
    public final List<String> encryptionAlgorithmsAsStrings() {
        return encryptionAlgorithms;
    }

    /**
     * <p>
     * The signing algorithms that the KMS key supports. You cannot use the KMS key with other signing algorithms within
     * KMS.
     * </p>
     * <p>
     * This field appears only when the <code>KeyUsage</code> of the KMS key is <code>SIGN_VERIFY</code>.
     * </p>
     * <p>
     * Attempts to modify the collection returned by this method will result in an UnsupportedOperationException.
     * </p>
     * <p>
     * This method will never return null. If you would like to know whether the service returned this field (so that
     * you can differentiate between null and empty), you can use the {@link #hasSigningAlgorithms} method.
     * </p>
     * 
     * @return The signing algorithms that the KMS key supports. You cannot use the KMS key with other signing
     *         algorithms within KMS.</p>
     *         <p>
     *         This field appears only when the <code>KeyUsage</code> of the KMS key is <code>SIGN_VERIFY</code>.
     */
    public final List<SigningAlgorithmSpec> signingAlgorithms() {
        return SigningAlgorithmSpecListCopier.copyStringToEnum(signingAlgorithms);
    }

    /**
     * For responses, this returns true if the service returned a value for the SigningAlgorithms property. This DOES
     * NOT check that the value is non-empty (for which, you should check the {@code isEmpty()} method on the property).
     * This is useful because the SDK will never return a null collection or map, but you may need to differentiate
     * between the service returning nothing (or null) and the service returning an empty collection or map. For
     * requests, this returns true if a value for the property was specified in the request builder, and false if a
     * value was not specified.
     */
    public final boolean hasSigningAlgorithms() {
        return signingAlgorithms != null && !(signingAlgorithms instanceof SdkAutoConstructList);
    }

    /**
     * <p>
     * The signing algorithms that the KMS key supports. You cannot use the KMS key with other signing algorithms within
     * KMS.
     * </p>
     * <p>
     * This field appears only when the <code>KeyUsage</code> of the KMS key is <code>SIGN_VERIFY</code>.
     * </p>
     * <p>
     * Attempts to modify the collection returned by this method will result in an UnsupportedOperationException.
     * </p>
     * <p>
     * This method will never return null. If you would like to know whether the service returned this field (so that
     * you can differentiate between null and empty), you can use the {@link #hasSigningAlgorithms} method.
     * </p>
     * 
     * @return The signing algorithms that the KMS key supports. You cannot use the KMS key with other signing
     *         algorithms within KMS.</p>
     *         <p>
     *         This field appears only when the <code>KeyUsage</code> of the KMS key is <code>SIGN_VERIFY</code>.
     */
    public final List<String> signingAlgorithmsAsStrings() {
        return signingAlgorithms;
    }

    /**
     * <p>
     * The key agreement algorithm used to derive a shared secret.
     * </p>
     * <p>
     * Attempts to modify the collection returned by this method will result in an UnsupportedOperationException.
     * </p>
     * <p>
     * This method will never return null. If you would like to know whether the service returned this field (so that
     * you can differentiate between null and empty), you can use the {@link #hasKeyAgreementAlgorithms} method.
     * </p>
     * 
     * @return The key agreement algorithm used to derive a shared secret.
     */
    public final List<KeyAgreementAlgorithmSpec> keyAgreementAlgorithms() {
        return KeyAgreementAlgorithmSpecListCopier.copyStringToEnum(keyAgreementAlgorithms);
    }

    /**
     * For responses, this returns true if the service returned a value for the KeyAgreementAlgorithms property. This
     * DOES NOT check that the value is non-empty (for which, you should check the {@code isEmpty()} method on the
     * property). This is useful because the SDK will never return a null collection or map, but you may need to
     * differentiate between the service returning nothing (or null) and the service returning an empty collection or
     * map. For requests, this returns true if a value for the property was specified in the request builder, and false
     * if a value was not specified.
     */
    public final boolean hasKeyAgreementAlgorithms() {
        return keyAgreementAlgorithms != null && !(keyAgreementAlgorithms instanceof SdkAutoConstructList);
    }

    /**
     * <p>
     * The key agreement algorithm used to derive a shared secret.
     * </p>
     * <p>
     * Attempts to modify the collection returned by this method will result in an UnsupportedOperationException.
     * </p>
     * <p>
     * This method will never return null. If you would like to know whether the service returned this field (so that
     * you can differentiate between null and empty), you can use the {@link #hasKeyAgreementAlgorithms} method.
     * </p>
     * 
     * @return The key agreement algorithm used to derive a shared secret.
     */
    public final List<String> keyAgreementAlgorithmsAsStrings() {
        return keyAgreementAlgorithms;
    }

    /**
     * <p>
     * Indicates whether the KMS key is a multi-Region (<code>True</code>) or regional (<code>False</code>) key. This
     * value is <code>True</code> for multi-Region primary and replica keys and <code>False</code> for regional KMS
     * keys.
     * </p>
     * <p>
     * For more information about multi-Region keys, see <a
     * href="https://docs.aws.amazon.com/kms/latest/developerguide/multi-region-keys-overview.html">Multi-Region keys in
     * KMS</a> in the <i>Key Management Service Developer Guide</i>.
     * </p>
     * 
     * @return Indicates whether the KMS key is a multi-Region (<code>True</code>) or regional (<code>False</code>) key.
     *         This value is <code>True</code> for multi-Region primary and replica keys and <code>False</code> for
     *         regional KMS keys.</p>
     *         <p>
     *         For more information about multi-Region keys, see <a
     *         href="https://docs.aws.amazon.com/kms/latest/developerguide/multi-region-keys-overview.html">Multi-Region
     *         keys in KMS</a> in the <i>Key Management Service Developer Guide</i>.
     */
    public final Boolean multiRegion() {
        return multiRegion;
    }

    /**
     * <p>
     * Lists the primary and replica keys in same multi-Region key. This field is present only when the value of the
     * <code>MultiRegion</code> field is <code>True</code>.
     * </p>
     * <p>
     * For more information about any listed KMS key, use the <a>DescribeKey</a> operation.
     * </p>
     * <ul>
     * <li>
     * <p>
     * <code>MultiRegionKeyType</code> indicates whether the KMS key is a <code>PRIMARY</code> or <code>REPLICA</code>
     * key.
     * </p>
     * </li>
     * <li>
     * <p>
     * <code>PrimaryKey</code> displays the key ARN and Region of the primary key. This field displays the current KMS
     * key if it is the primary key.
     * </p>
     * </li>
     * <li>
     * <p>
     * <code>ReplicaKeys</code> displays the key ARNs and Regions of all replica keys. This field includes the current
     * KMS key if it is a replica key.
     * </p>
     * </li>
     * </ul>
     * 
     * @return Lists the primary and replica keys in same multi-Region key. This field is present only when the value of
     *         the <code>MultiRegion</code> field is <code>True</code>.</p>
     *         <p>
     *         For more information about any listed KMS key, use the <a>DescribeKey</a> operation.
     *         </p>
     *         <ul>
     *         <li>
     *         <p>
     *         <code>MultiRegionKeyType</code> indicates whether the KMS key is a <code>PRIMARY</code> or
     *         <code>REPLICA</code> key.
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         <code>PrimaryKey</code> displays the key ARN and Region of the primary key. This field displays the
     *         current KMS key if it is the primary key.
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         <code>ReplicaKeys</code> displays the key ARNs and Regions of all replica keys. This field includes the
     *         current KMS key if it is a replica key.
     *         </p>
     *         </li>
     */
    public final MultiRegionConfiguration multiRegionConfiguration() {
        return multiRegionConfiguration;
    }

    /**
     * <p>
     * The waiting period before the primary key in a multi-Region key is deleted. This waiting period begins when the
     * last of its replica keys is deleted. This value is present only when the <code>KeyState</code> of the KMS key is
     * <code>PendingReplicaDeletion</code>. That indicates that the KMS key is the primary key in a multi-Region key, it
     * is scheduled for deletion, and it still has existing replica keys.
     * </p>
     * <p>
     * When a single-Region KMS key or a multi-Region replica key is scheduled for deletion, its deletion date is
     * displayed in the <code>DeletionDate</code> field. However, when the primary key in a multi-Region key is
     * scheduled for deletion, its waiting period doesn't begin until all of its replica keys are deleted. This value
     * displays that waiting period. When the last replica key in the multi-Region key is deleted, the
     * <code>KeyState</code> of the scheduled primary key changes from <code>PendingReplicaDeletion</code> to
     * <code>PendingDeletion</code> and the deletion date appears in the <code>DeletionDate</code> field.
     * </p>
     * 
     * @return The waiting period before the primary key in a multi-Region key is deleted. This waiting period begins
     *         when the last of its replica keys is deleted. This value is present only when the <code>KeyState</code>
     *         of the KMS key is <code>PendingReplicaDeletion</code>. That indicates that the KMS key is the primary key
     *         in a multi-Region key, it is scheduled for deletion, and it still has existing replica keys.</p>
     *         <p>
     *         When a single-Region KMS key or a multi-Region replica key is scheduled for deletion, its deletion date
     *         is displayed in the <code>DeletionDate</code> field. However, when the primary key in a multi-Region key
     *         is scheduled for deletion, its waiting period doesn't begin until all of its replica keys are deleted.
     *         This value displays that waiting period. When the last replica key in the multi-Region key is deleted,
     *         the <code>KeyState</code> of the scheduled primary key changes from <code>PendingReplicaDeletion</code>
     *         to <code>PendingDeletion</code> and the deletion date appears in the <code>DeletionDate</code> field.
     */
    public final Integer pendingDeletionWindowInDays() {
        return pendingDeletionWindowInDays;
    }

    /**
     * <p>
     * The message authentication code (MAC) algorithm that the HMAC KMS key supports.
     * </p>
     * <p>
     * This value is present only when the <code>KeyUsage</code> of the KMS key is <code>GENERATE_VERIFY_MAC</code>.
     * </p>
     * <p>
     * Attempts to modify the collection returned by this method will result in an UnsupportedOperationException.
     * </p>
     * <p>
     * This method will never return null. If you would like to know whether the service returned this field (so that
     * you can differentiate between null and empty), you can use the {@link #hasMacAlgorithms} method.
     * </p>
     * 
     * @return The message authentication code (MAC) algorithm that the HMAC KMS key supports.</p>
     *         <p>
     *         This value is present only when the <code>KeyUsage</code> of the KMS key is
     *         <code>GENERATE_VERIFY_MAC</code>.
     */
    public final List<MacAlgorithmSpec> macAlgorithms() {
        return MacAlgorithmSpecListCopier.copyStringToEnum(macAlgorithms);
    }

    /**
     * For responses, this returns true if the service returned a value for the MacAlgorithms property. This DOES NOT
     * check that the value is non-empty (for which, you should check the {@code isEmpty()} method on the property).
     * This is useful because the SDK will never return a null collection or map, but you may need to differentiate
     * between the service returning nothing (or null) and the service returning an empty collection or map. For
     * requests, this returns true if a value for the property was specified in the request builder, and false if a
     * value was not specified.
     */
    public final boolean hasMacAlgorithms() {
        return macAlgorithms != null && !(macAlgorithms instanceof SdkAutoConstructList);
    }

    /**
     * <p>
     * The message authentication code (MAC) algorithm that the HMAC KMS key supports.
     * </p>
     * <p>
     * This value is present only when the <code>KeyUsage</code> of the KMS key is <code>GENERATE_VERIFY_MAC</code>.
     * </p>
     * <p>
     * Attempts to modify the collection returned by this method will result in an UnsupportedOperationException.
     * </p>
     * <p>
     * This method will never return null. If you would like to know whether the service returned this field (so that
     * you can differentiate between null and empty), you can use the {@link #hasMacAlgorithms} method.
     * </p>
     * 
     * @return The message authentication code (MAC) algorithm that the HMAC KMS key supports.</p>
     *         <p>
     *         This value is present only when the <code>KeyUsage</code> of the KMS key is
     *         <code>GENERATE_VERIFY_MAC</code>.
     */
    public final List<String> macAlgorithmsAsStrings() {
        return macAlgorithms;
    }

    /**
     * <p>
     * Information about the external key that is associated with a KMS key in an external key store.
     * </p>
     * <p>
     * For more information, see <a
     * href="https://docs.aws.amazon.com/kms/latest/developerguide/keystore-external.html#concept-external-key">External
     * key</a> in the <i>Key Management Service Developer Guide</i>.
     * </p>
     * 
     * @return Information about the external key that is associated with a KMS key in an external key store.</p>
     *         <p>
     *         For more information, see <a href=
     *         "https://docs.aws.amazon.com/kms/latest/developerguide/keystore-external.html#concept-external-key"
     *         >External key</a> in the <i>Key Management Service Developer Guide</i>.
     */
    public final XksKeyConfigurationType xksKeyConfiguration() {
        return xksKeyConfiguration;
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
        hashCode = 31 * hashCode + Objects.hashCode(awsAccountId());
        hashCode = 31 * hashCode + Objects.hashCode(keyId());
        hashCode = 31 * hashCode + Objects.hashCode(arn());
        hashCode = 31 * hashCode + Objects.hashCode(creationDate());
        hashCode = 31 * hashCode + Objects.hashCode(enabled());
        hashCode = 31 * hashCode + Objects.hashCode(description());
        hashCode = 31 * hashCode + Objects.hashCode(keyUsageAsString());
        hashCode = 31 * hashCode + Objects.hashCode(keyStateAsString());
        hashCode = 31 * hashCode + Objects.hashCode(deletionDate());
        hashCode = 31 * hashCode + Objects.hashCode(validTo());
        hashCode = 31 * hashCode + Objects.hashCode(originAsString());
        hashCode = 31 * hashCode + Objects.hashCode(customKeyStoreId());
        hashCode = 31 * hashCode + Objects.hashCode(cloudHsmClusterId());
        hashCode = 31 * hashCode + Objects.hashCode(expirationModelAsString());
        hashCode = 31 * hashCode + Objects.hashCode(keyManagerAsString());
        hashCode = 31 * hashCode + Objects.hashCode(customerMasterKeySpecAsString());
        hashCode = 31 * hashCode + Objects.hashCode(keySpecAsString());
        hashCode = 31 * hashCode + Objects.hashCode(hasEncryptionAlgorithms() ? encryptionAlgorithmsAsStrings() : null);
        hashCode = 31 * hashCode + Objects.hashCode(hasSigningAlgorithms() ? signingAlgorithmsAsStrings() : null);
        hashCode = 31 * hashCode + Objects.hashCode(hasKeyAgreementAlgorithms() ? keyAgreementAlgorithmsAsStrings() : null);
        hashCode = 31 * hashCode + Objects.hashCode(multiRegion());
        hashCode = 31 * hashCode + Objects.hashCode(multiRegionConfiguration());
        hashCode = 31 * hashCode + Objects.hashCode(pendingDeletionWindowInDays());
        hashCode = 31 * hashCode + Objects.hashCode(hasMacAlgorithms() ? macAlgorithmsAsStrings() : null);
        hashCode = 31 * hashCode + Objects.hashCode(xksKeyConfiguration());
        return hashCode;
    }

    @Override
    public final boolean equals(Object obj) {
        return equalsBySdkFields(obj);
    }

    @Override
    public final boolean equalsBySdkFields(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof KeyMetadata)) {
            return false;
        }
        KeyMetadata other = (KeyMetadata) obj;
        return Objects.equals(awsAccountId(), other.awsAccountId()) && Objects.equals(keyId(), other.keyId())
                && Objects.equals(arn(), other.arn()) && Objects.equals(creationDate(), other.creationDate())
                && Objects.equals(enabled(), other.enabled()) && Objects.equals(description(), other.description())
                && Objects.equals(keyUsageAsString(), other.keyUsageAsString())
                && Objects.equals(keyStateAsString(), other.keyStateAsString())
                && Objects.equals(deletionDate(), other.deletionDate()) && Objects.equals(validTo(), other.validTo())
                && Objects.equals(originAsString(), other.originAsString())
                && Objects.equals(customKeyStoreId(), other.customKeyStoreId())
                && Objects.equals(cloudHsmClusterId(), other.cloudHsmClusterId())
                && Objects.equals(expirationModelAsString(), other.expirationModelAsString())
                && Objects.equals(keyManagerAsString(), other.keyManagerAsString())
                && Objects.equals(customerMasterKeySpecAsString(), other.customerMasterKeySpecAsString())
                && Objects.equals(keySpecAsString(), other.keySpecAsString())
                && hasEncryptionAlgorithms() == other.hasEncryptionAlgorithms()
                && Objects.equals(encryptionAlgorithmsAsStrings(), other.encryptionAlgorithmsAsStrings())
                && hasSigningAlgorithms() == other.hasSigningAlgorithms()
                && Objects.equals(signingAlgorithmsAsStrings(), other.signingAlgorithmsAsStrings())
                && hasKeyAgreementAlgorithms() == other.hasKeyAgreementAlgorithms()
                && Objects.equals(keyAgreementAlgorithmsAsStrings(), other.keyAgreementAlgorithmsAsStrings())
                && Objects.equals(multiRegion(), other.multiRegion())
                && Objects.equals(multiRegionConfiguration(), other.multiRegionConfiguration())
                && Objects.equals(pendingDeletionWindowInDays(), other.pendingDeletionWindowInDays())
                && hasMacAlgorithms() == other.hasMacAlgorithms()
                && Objects.equals(macAlgorithmsAsStrings(), other.macAlgorithmsAsStrings())
                && Objects.equals(xksKeyConfiguration(), other.xksKeyConfiguration());
    }

    /**
     * Returns a string representation of this object. This is useful for testing and debugging. Sensitive data will be
     * redacted from this string using a placeholder value.
     */
    @Override
    public final String toString() {
        return ToString.builder("KeyMetadata").add("AWSAccountId", awsAccountId()).add("KeyId", keyId()).add("Arn", arn())
                .add("CreationDate", creationDate()).add("Enabled", enabled()).add("Description", description())
                .add("KeyUsage", keyUsageAsString()).add("KeyState", keyStateAsString()).add("DeletionDate", deletionDate())
                .add("ValidTo", validTo()).add("Origin", originAsString()).add("CustomKeyStoreId", customKeyStoreId())
                .add("CloudHsmClusterId", cloudHsmClusterId()).add("ExpirationModel", expirationModelAsString())
                .add("KeyManager", keyManagerAsString()).add("CustomerMasterKeySpec", customerMasterKeySpecAsString())
                .add("KeySpec", keySpecAsString())
                .add("EncryptionAlgorithms", hasEncryptionAlgorithms() ? encryptionAlgorithmsAsStrings() : null)
                .add("SigningAlgorithms", hasSigningAlgorithms() ? signingAlgorithmsAsStrings() : null)
                .add("KeyAgreementAlgorithms", hasKeyAgreementAlgorithms() ? keyAgreementAlgorithmsAsStrings() : null)
                .add("MultiRegion", multiRegion()).add("MultiRegionConfiguration", multiRegionConfiguration())
                .add("PendingDeletionWindowInDays", pendingDeletionWindowInDays())
                .add("MacAlgorithms", hasMacAlgorithms() ? macAlgorithmsAsStrings() : null)
                .add("XksKeyConfiguration", xksKeyConfiguration()).build();
    }

    public final <T> Optional<T> getValueForField(String fieldName, Class<T> clazz) {
        switch (fieldName) {
        case "AWSAccountId":
            return Optional.ofNullable(clazz.cast(awsAccountId()));
        case "KeyId":
            return Optional.ofNullable(clazz.cast(keyId()));
        case "Arn":
            return Optional.ofNullable(clazz.cast(arn()));
        case "CreationDate":
            return Optional.ofNullable(clazz.cast(creationDate()));
        case "Enabled":
            return Optional.ofNullable(clazz.cast(enabled()));
        case "Description":
            return Optional.ofNullable(clazz.cast(description()));
        case "KeyUsage":
            return Optional.ofNullable(clazz.cast(keyUsageAsString()));
        case "KeyState":
            return Optional.ofNullable(clazz.cast(keyStateAsString()));
        case "DeletionDate":
            return Optional.ofNullable(clazz.cast(deletionDate()));
        case "ValidTo":
            return Optional.ofNullable(clazz.cast(validTo()));
        case "Origin":
            return Optional.ofNullable(clazz.cast(originAsString()));
        case "CustomKeyStoreId":
            return Optional.ofNullable(clazz.cast(customKeyStoreId()));
        case "CloudHsmClusterId":
            return Optional.ofNullable(clazz.cast(cloudHsmClusterId()));
        case "ExpirationModel":
            return Optional.ofNullable(clazz.cast(expirationModelAsString()));
        case "KeyManager":
            return Optional.ofNullable(clazz.cast(keyManagerAsString()));
        case "CustomerMasterKeySpec":
            return Optional.ofNullable(clazz.cast(customerMasterKeySpecAsString()));
        case "KeySpec":
            return Optional.ofNullable(clazz.cast(keySpecAsString()));
        case "EncryptionAlgorithms":
            return Optional.ofNullable(clazz.cast(encryptionAlgorithmsAsStrings()));
        case "SigningAlgorithms":
            return Optional.ofNullable(clazz.cast(signingAlgorithmsAsStrings()));
        case "KeyAgreementAlgorithms":
            return Optional.ofNullable(clazz.cast(keyAgreementAlgorithmsAsStrings()));
        case "MultiRegion":
            return Optional.ofNullable(clazz.cast(multiRegion()));
        case "MultiRegionConfiguration":
            return Optional.ofNullable(clazz.cast(multiRegionConfiguration()));
        case "PendingDeletionWindowInDays":
            return Optional.ofNullable(clazz.cast(pendingDeletionWindowInDays()));
        case "MacAlgorithms":
            return Optional.ofNullable(clazz.cast(macAlgorithmsAsStrings()));
        case "XksKeyConfiguration":
            return Optional.ofNullable(clazz.cast(xksKeyConfiguration()));
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
        map.put("AWSAccountId", AWS_ACCOUNT_ID_FIELD);
        map.put("KeyId", KEY_ID_FIELD);
        map.put("Arn", ARN_FIELD);
        map.put("CreationDate", CREATION_DATE_FIELD);
        map.put("Enabled", ENABLED_FIELD);
        map.put("Description", DESCRIPTION_FIELD);
        map.put("KeyUsage", KEY_USAGE_FIELD);
        map.put("KeyState", KEY_STATE_FIELD);
        map.put("DeletionDate", DELETION_DATE_FIELD);
        map.put("ValidTo", VALID_TO_FIELD);
        map.put("Origin", ORIGIN_FIELD);
        map.put("CustomKeyStoreId", CUSTOM_KEY_STORE_ID_FIELD);
        map.put("CloudHsmClusterId", CLOUD_HSM_CLUSTER_ID_FIELD);
        map.put("ExpirationModel", EXPIRATION_MODEL_FIELD);
        map.put("KeyManager", KEY_MANAGER_FIELD);
        map.put("CustomerMasterKeySpec", CUSTOMER_MASTER_KEY_SPEC_FIELD);
        map.put("KeySpec", KEY_SPEC_FIELD);
        map.put("EncryptionAlgorithms", ENCRYPTION_ALGORITHMS_FIELD);
        map.put("SigningAlgorithms", SIGNING_ALGORITHMS_FIELD);
        map.put("KeyAgreementAlgorithms", KEY_AGREEMENT_ALGORITHMS_FIELD);
        map.put("MultiRegion", MULTI_REGION_FIELD);
        map.put("MultiRegionConfiguration", MULTI_REGION_CONFIGURATION_FIELD);
        map.put("PendingDeletionWindowInDays", PENDING_DELETION_WINDOW_IN_DAYS_FIELD);
        map.put("MacAlgorithms", MAC_ALGORITHMS_FIELD);
        map.put("XksKeyConfiguration", XKS_KEY_CONFIGURATION_FIELD);
        return Collections.unmodifiableMap(map);
    }

    private static <T> Function<Object, T> getter(Function<KeyMetadata, T> g) {
        return obj -> g.apply((KeyMetadata) obj);
    }

    private static <T> BiConsumer<Object, T> setter(BiConsumer<Builder, T> s) {
        return (obj, val) -> s.accept((Builder) obj, val);
    }

    @Mutable
    @NotThreadSafe
    public interface Builder extends SdkPojo, CopyableBuilder<Builder, KeyMetadata> {
        /**
         * <p>
         * The twelve-digit account ID of the Amazon Web Services account that owns the KMS key.
         * </p>
         * 
         * @param awsAccountId
         *        The twelve-digit account ID of the Amazon Web Services account that owns the KMS key.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder awsAccountId(String awsAccountId);

        /**
         * <p>
         * The globally unique identifier for the KMS key.
         * </p>
         * 
         * @param keyId
         *        The globally unique identifier for the KMS key.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder keyId(String keyId);

        /**
         * <p>
         * The Amazon Resource Name (ARN) of the KMS key. For examples, see <a
         * href="https://docs.aws.amazon.com/general/latest/gr/aws-arns-and-namespaces.html#arn-syntax-kms">Key
         * Management Service (KMS)</a> in the Example ARNs section of the <i>Amazon Web Services General Reference</i>.
         * </p>
         * 
         * @param arn
         *        The Amazon Resource Name (ARN) of the KMS key. For examples, see <a
         *        href="https://docs.aws.amazon.com/general/latest/gr/aws-arns-and-namespaces.html#arn-syntax-kms">Key
         *        Management Service (KMS)</a> in the Example ARNs section of the <i>Amazon Web Services General
         *        Reference</i>.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder arn(String arn);

        /**
         * <p>
         * The date and time when the KMS key was created.
         * </p>
         * 
         * @param creationDate
         *        The date and time when the KMS key was created.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder creationDate(Instant creationDate);

        /**
         * <p>
         * Specifies whether the KMS key is enabled. When <code>KeyState</code> is <code>Enabled</code> this value is
         * true, otherwise it is false.
         * </p>
         * 
         * @param enabled
         *        Specifies whether the KMS key is enabled. When <code>KeyState</code> is <code>Enabled</code> this
         *        value is true, otherwise it is false.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder enabled(Boolean enabled);

        /**
         * <p>
         * The description of the KMS key.
         * </p>
         * 
         * @param description
         *        The description of the KMS key.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder description(String description);

        /**
         * <p>
         * The <a href="https://docs.aws.amazon.com/kms/latest/developerguide/concepts.html#cryptographic-operations">
         * cryptographic operations</a> for which you can use the KMS key.
         * </p>
         * 
         * @param keyUsage
         *        The <a
         *        href="https://docs.aws.amazon.com/kms/latest/developerguide/concepts.html#cryptographic-operations"
         *        >cryptographic operations</a> for which you can use the KMS key.
         * @see KeyUsageType
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see KeyUsageType
         */
        Builder keyUsage(String keyUsage);

        /**
         * <p>
         * The <a href="https://docs.aws.amazon.com/kms/latest/developerguide/concepts.html#cryptographic-operations">
         * cryptographic operations</a> for which you can use the KMS key.
         * </p>
         * 
         * @param keyUsage
         *        The <a
         *        href="https://docs.aws.amazon.com/kms/latest/developerguide/concepts.html#cryptographic-operations"
         *        >cryptographic operations</a> for which you can use the KMS key.
         * @see KeyUsageType
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see KeyUsageType
         */
        Builder keyUsage(KeyUsageType keyUsage);

        /**
         * <p>
         * The current status of the KMS key.
         * </p>
         * <p>
         * For more information about how key state affects the use of a KMS key, see <a
         * href="https://docs.aws.amazon.com/kms/latest/developerguide/key-state.html">Key states of KMS keys</a> in the
         * <i>Key Management Service Developer Guide</i>.
         * </p>
         * 
         * @param keyState
         *        The current status of the KMS key.</p>
         *        <p>
         *        For more information about how key state affects the use of a KMS key, see <a
         *        href="https://docs.aws.amazon.com/kms/latest/developerguide/key-state.html">Key states of KMS keys</a>
         *        in the <i>Key Management Service Developer Guide</i>.
         * @see KeyState
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see KeyState
         */
        Builder keyState(String keyState);

        /**
         * <p>
         * The current status of the KMS key.
         * </p>
         * <p>
         * For more information about how key state affects the use of a KMS key, see <a
         * href="https://docs.aws.amazon.com/kms/latest/developerguide/key-state.html">Key states of KMS keys</a> in the
         * <i>Key Management Service Developer Guide</i>.
         * </p>
         * 
         * @param keyState
         *        The current status of the KMS key.</p>
         *        <p>
         *        For more information about how key state affects the use of a KMS key, see <a
         *        href="https://docs.aws.amazon.com/kms/latest/developerguide/key-state.html">Key states of KMS keys</a>
         *        in the <i>Key Management Service Developer Guide</i>.
         * @see KeyState
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see KeyState
         */
        Builder keyState(KeyState keyState);

        /**
         * <p>
         * The date and time after which KMS deletes this KMS key. This value is present only when the KMS key is
         * scheduled for deletion, that is, when its <code>KeyState</code> is <code>PendingDeletion</code>.
         * </p>
         * <p>
         * When the primary key in a multi-Region key is scheduled for deletion but still has replica keys, its key
         * state is <code>PendingReplicaDeletion</code> and the length of its waiting period is displayed in the
         * <code>PendingDeletionWindowInDays</code> field.
         * </p>
         * 
         * @param deletionDate
         *        The date and time after which KMS deletes this KMS key. This value is present only when the KMS key is
         *        scheduled for deletion, that is, when its <code>KeyState</code> is <code>PendingDeletion</code>.</p>
         *        <p>
         *        When the primary key in a multi-Region key is scheduled for deletion but still has replica keys, its
         *        key state is <code>PendingReplicaDeletion</code> and the length of its waiting period is displayed in
         *        the <code>PendingDeletionWindowInDays</code> field.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder deletionDate(Instant deletionDate);

        /**
         * <p>
         * The time at which the imported key material expires. When the key material expires, KMS deletes the key
         * material and the KMS key becomes unusable. This value is present only for KMS keys whose <code>Origin</code>
         * is <code>EXTERNAL</code> and whose <code>ExpirationModel</code> is <code>KEY_MATERIAL_EXPIRES</code>,
         * otherwise this value is omitted.
         * </p>
         * 
         * @param validTo
         *        The time at which the imported key material expires. When the key material expires, KMS deletes the
         *        key material and the KMS key becomes unusable. This value is present only for KMS keys whose
         *        <code>Origin</code> is <code>EXTERNAL</code> and whose <code>ExpirationModel</code> is
         *        <code>KEY_MATERIAL_EXPIRES</code>, otherwise this value is omitted.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder validTo(Instant validTo);

        /**
         * <p>
         * The source of the key material for the KMS key. When this value is <code>AWS_KMS</code>, KMS created the key
         * material. When this value is <code>EXTERNAL</code>, the key material was imported or the KMS key doesn't have
         * any key material. When this value is <code>AWS_CLOUDHSM</code>, the key material was created in the CloudHSM
         * cluster associated with a custom key store.
         * </p>
         * 
         * @param origin
         *        The source of the key material for the KMS key. When this value is <code>AWS_KMS</code>, KMS created
         *        the key material. When this value is <code>EXTERNAL</code>, the key material was imported or the KMS
         *        key doesn't have any key material. When this value is <code>AWS_CLOUDHSM</code>, the key material was
         *        created in the CloudHSM cluster associated with a custom key store.
         * @see OriginType
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see OriginType
         */
        Builder origin(String origin);

        /**
         * <p>
         * The source of the key material for the KMS key. When this value is <code>AWS_KMS</code>, KMS created the key
         * material. When this value is <code>EXTERNAL</code>, the key material was imported or the KMS key doesn't have
         * any key material. When this value is <code>AWS_CLOUDHSM</code>, the key material was created in the CloudHSM
         * cluster associated with a custom key store.
         * </p>
         * 
         * @param origin
         *        The source of the key material for the KMS key. When this value is <code>AWS_KMS</code>, KMS created
         *        the key material. When this value is <code>EXTERNAL</code>, the key material was imported or the KMS
         *        key doesn't have any key material. When this value is <code>AWS_CLOUDHSM</code>, the key material was
         *        created in the CloudHSM cluster associated with a custom key store.
         * @see OriginType
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see OriginType
         */
        Builder origin(OriginType origin);

        /**
         * <p>
         * A unique identifier for the <a
         * href="https://docs.aws.amazon.com/kms/latest/developerguide/custom-key-store-overview.html">custom key
         * store</a> that contains the KMS key. This field is present only when the KMS key is created in a custom key
         * store.
         * </p>
         * 
         * @param customKeyStoreId
         *        A unique identifier for the <a
         *        href="https://docs.aws.amazon.com/kms/latest/developerguide/custom-key-store-overview.html">custom key
         *        store</a> that contains the KMS key. This field is present only when the KMS key is created in a
         *        custom key store.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder customKeyStoreId(String customKeyStoreId);

        /**
         * <p>
         * The cluster ID of the CloudHSM cluster that contains the key material for the KMS key. When you create a KMS
         * key in an CloudHSM <a
         * href="https://docs.aws.amazon.com/kms/latest/developerguide/custom-key-store-overview.html">custom key
         * store</a>, KMS creates the key material for the KMS key in the associated CloudHSM cluster. This field is
         * present only when the KMS key is created in an CloudHSM key store.
         * </p>
         * 
         * @param cloudHsmClusterId
         *        The cluster ID of the CloudHSM cluster that contains the key material for the KMS key. When you create
         *        a KMS key in an CloudHSM <a
         *        href="https://docs.aws.amazon.com/kms/latest/developerguide/custom-key-store-overview.html">custom key
         *        store</a>, KMS creates the key material for the KMS key in the associated CloudHSM cluster. This field
         *        is present only when the KMS key is created in an CloudHSM key store.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder cloudHsmClusterId(String cloudHsmClusterId);

        /**
         * <p>
         * Specifies whether the KMS key's key material expires. This value is present only when <code>Origin</code> is
         * <code>EXTERNAL</code>, otherwise this value is omitted.
         * </p>
         * 
         * @param expirationModel
         *        Specifies whether the KMS key's key material expires. This value is present only when
         *        <code>Origin</code> is <code>EXTERNAL</code>, otherwise this value is omitted.
         * @see ExpirationModelType
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see ExpirationModelType
         */
        Builder expirationModel(String expirationModel);

        /**
         * <p>
         * Specifies whether the KMS key's key material expires. This value is present only when <code>Origin</code> is
         * <code>EXTERNAL</code>, otherwise this value is omitted.
         * </p>
         * 
         * @param expirationModel
         *        Specifies whether the KMS key's key material expires. This value is present only when
         *        <code>Origin</code> is <code>EXTERNAL</code>, otherwise this value is omitted.
         * @see ExpirationModelType
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see ExpirationModelType
         */
        Builder expirationModel(ExpirationModelType expirationModel);

        /**
         * <p>
         * The manager of the KMS key. KMS keys in your Amazon Web Services account are either customer managed or
         * Amazon Web Services managed. For more information about the difference, see <a
         * href="https://docs.aws.amazon.com/kms/latest/developerguide/concepts.html#kms_keys">KMS keys</a> in the
         * <i>Key Management Service Developer Guide</i>.
         * </p>
         * 
         * @param keyManager
         *        The manager of the KMS key. KMS keys in your Amazon Web Services account are either customer managed
         *        or Amazon Web Services managed. For more information about the difference, see <a
         *        href="https://docs.aws.amazon.com/kms/latest/developerguide/concepts.html#kms_keys">KMS keys</a> in
         *        the <i>Key Management Service Developer Guide</i>.
         * @see KeyManagerType
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see KeyManagerType
         */
        Builder keyManager(String keyManager);

        /**
         * <p>
         * The manager of the KMS key. KMS keys in your Amazon Web Services account are either customer managed or
         * Amazon Web Services managed. For more information about the difference, see <a
         * href="https://docs.aws.amazon.com/kms/latest/developerguide/concepts.html#kms_keys">KMS keys</a> in the
         * <i>Key Management Service Developer Guide</i>.
         * </p>
         * 
         * @param keyManager
         *        The manager of the KMS key. KMS keys in your Amazon Web Services account are either customer managed
         *        or Amazon Web Services managed. For more information about the difference, see <a
         *        href="https://docs.aws.amazon.com/kms/latest/developerguide/concepts.html#kms_keys">KMS keys</a> in
         *        the <i>Key Management Service Developer Guide</i>.
         * @see KeyManagerType
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see KeyManagerType
         */
        Builder keyManager(KeyManagerType keyManager);

        /**
         * <p>
         * Instead, use the <code>KeySpec</code> field.
         * </p>
         * <p>
         * The <code>KeySpec</code> and <code>CustomerMasterKeySpec</code> fields have the same value. We recommend that
         * you use the <code>KeySpec</code> field in your code. However, to avoid breaking changes, KMS supports both
         * fields.
         * </p>
         * 
         * @param customerMasterKeySpec
         *        Instead, use the <code>KeySpec</code> field.</p>
         *        <p>
         *        The <code>KeySpec</code> and <code>CustomerMasterKeySpec</code> fields have the same value. We
         *        recommend that you use the <code>KeySpec</code> field in your code. However, to avoid breaking
         *        changes, KMS supports both fields.
         * @see CustomerMasterKeySpec
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see CustomerMasterKeySpec
         * @deprecated This field has been deprecated. Instead, use the KeySpec field.
         */
        @Deprecated
        Builder customerMasterKeySpec(String customerMasterKeySpec);

        /**
         * <p>
         * Instead, use the <code>KeySpec</code> field.
         * </p>
         * <p>
         * The <code>KeySpec</code> and <code>CustomerMasterKeySpec</code> fields have the same value. We recommend that
         * you use the <code>KeySpec</code> field in your code. However, to avoid breaking changes, KMS supports both
         * fields.
         * </p>
         * 
         * @param customerMasterKeySpec
         *        Instead, use the <code>KeySpec</code> field.</p>
         *        <p>
         *        The <code>KeySpec</code> and <code>CustomerMasterKeySpec</code> fields have the same value. We
         *        recommend that you use the <code>KeySpec</code> field in your code. However, to avoid breaking
         *        changes, KMS supports both fields.
         * @see CustomerMasterKeySpec
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see CustomerMasterKeySpec
         * @deprecated This field has been deprecated. Instead, use the KeySpec field.
         */
        @Deprecated
        Builder customerMasterKeySpec(CustomerMasterKeySpec customerMasterKeySpec);

        /**
         * <p>
         * Describes the type of key material in the KMS key.
         * </p>
         * 
         * @param keySpec
         *        Describes the type of key material in the KMS key.
         * @see KeySpec
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see KeySpec
         */
        Builder keySpec(String keySpec);

        /**
         * <p>
         * Describes the type of key material in the KMS key.
         * </p>
         * 
         * @param keySpec
         *        Describes the type of key material in the KMS key.
         * @see KeySpec
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see KeySpec
         */
        Builder keySpec(KeySpec keySpec);

        /**
         * <p>
         * The encryption algorithms that the KMS key supports. You cannot use the KMS key with other encryption
         * algorithms within KMS.
         * </p>
         * <p>
         * This value is present only when the <code>KeyUsage</code> of the KMS key is <code>ENCRYPT_DECRYPT</code>.
         * </p>
         * 
         * @param encryptionAlgorithms
         *        The encryption algorithms that the KMS key supports. You cannot use the KMS key with other encryption
         *        algorithms within KMS.</p>
         *        <p>
         *        This value is present only when the <code>KeyUsage</code> of the KMS key is
         *        <code>ENCRYPT_DECRYPT</code>.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder encryptionAlgorithmsWithStrings(Collection<String> encryptionAlgorithms);

        /**
         * <p>
         * The encryption algorithms that the KMS key supports. You cannot use the KMS key with other encryption
         * algorithms within KMS.
         * </p>
         * <p>
         * This value is present only when the <code>KeyUsage</code> of the KMS key is <code>ENCRYPT_DECRYPT</code>.
         * </p>
         * 
         * @param encryptionAlgorithms
         *        The encryption algorithms that the KMS key supports. You cannot use the KMS key with other encryption
         *        algorithms within KMS.</p>
         *        <p>
         *        This value is present only when the <code>KeyUsage</code> of the KMS key is
         *        <code>ENCRYPT_DECRYPT</code>.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder encryptionAlgorithmsWithStrings(String... encryptionAlgorithms);

        /**
         * <p>
         * The encryption algorithms that the KMS key supports. You cannot use the KMS key with other encryption
         * algorithms within KMS.
         * </p>
         * <p>
         * This value is present only when the <code>KeyUsage</code> of the KMS key is <code>ENCRYPT_DECRYPT</code>.
         * </p>
         * 
         * @param encryptionAlgorithms
         *        The encryption algorithms that the KMS key supports. You cannot use the KMS key with other encryption
         *        algorithms within KMS.</p>
         *        <p>
         *        This value is present only when the <code>KeyUsage</code> of the KMS key is
         *        <code>ENCRYPT_DECRYPT</code>.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder encryptionAlgorithms(Collection<EncryptionAlgorithmSpec> encryptionAlgorithms);

        /**
         * <p>
         * The encryption algorithms that the KMS key supports. You cannot use the KMS key with other encryption
         * algorithms within KMS.
         * </p>
         * <p>
         * This value is present only when the <code>KeyUsage</code> of the KMS key is <code>ENCRYPT_DECRYPT</code>.
         * </p>
         * 
         * @param encryptionAlgorithms
         *        The encryption algorithms that the KMS key supports. You cannot use the KMS key with other encryption
         *        algorithms within KMS.</p>
         *        <p>
         *        This value is present only when the <code>KeyUsage</code> of the KMS key is
         *        <code>ENCRYPT_DECRYPT</code>.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder encryptionAlgorithms(EncryptionAlgorithmSpec... encryptionAlgorithms);

        /**
         * <p>
         * The signing algorithms that the KMS key supports. You cannot use the KMS key with other signing algorithms
         * within KMS.
         * </p>
         * <p>
         * This field appears only when the <code>KeyUsage</code> of the KMS key is <code>SIGN_VERIFY</code>.
         * </p>
         * 
         * @param signingAlgorithms
         *        The signing algorithms that the KMS key supports. You cannot use the KMS key with other signing
         *        algorithms within KMS.</p>
         *        <p>
         *        This field appears only when the <code>KeyUsage</code> of the KMS key is <code>SIGN_VERIFY</code>.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder signingAlgorithmsWithStrings(Collection<String> signingAlgorithms);

        /**
         * <p>
         * The signing algorithms that the KMS key supports. You cannot use the KMS key with other signing algorithms
         * within KMS.
         * </p>
         * <p>
         * This field appears only when the <code>KeyUsage</code> of the KMS key is <code>SIGN_VERIFY</code>.
         * </p>
         * 
         * @param signingAlgorithms
         *        The signing algorithms that the KMS key supports. You cannot use the KMS key with other signing
         *        algorithms within KMS.</p>
         *        <p>
         *        This field appears only when the <code>KeyUsage</code> of the KMS key is <code>SIGN_VERIFY</code>.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder signingAlgorithmsWithStrings(String... signingAlgorithms);

        /**
         * <p>
         * The signing algorithms that the KMS key supports. You cannot use the KMS key with other signing algorithms
         * within KMS.
         * </p>
         * <p>
         * This field appears only when the <code>KeyUsage</code> of the KMS key is <code>SIGN_VERIFY</code>.
         * </p>
         * 
         * @param signingAlgorithms
         *        The signing algorithms that the KMS key supports. You cannot use the KMS key with other signing
         *        algorithms within KMS.</p>
         *        <p>
         *        This field appears only when the <code>KeyUsage</code> of the KMS key is <code>SIGN_VERIFY</code>.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder signingAlgorithms(Collection<SigningAlgorithmSpec> signingAlgorithms);

        /**
         * <p>
         * The signing algorithms that the KMS key supports. You cannot use the KMS key with other signing algorithms
         * within KMS.
         * </p>
         * <p>
         * This field appears only when the <code>KeyUsage</code> of the KMS key is <code>SIGN_VERIFY</code>.
         * </p>
         * 
         * @param signingAlgorithms
         *        The signing algorithms that the KMS key supports. You cannot use the KMS key with other signing
         *        algorithms within KMS.</p>
         *        <p>
         *        This field appears only when the <code>KeyUsage</code> of the KMS key is <code>SIGN_VERIFY</code>.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder signingAlgorithms(SigningAlgorithmSpec... signingAlgorithms);

        /**
         * <p>
         * The key agreement algorithm used to derive a shared secret.
         * </p>
         * 
         * @param keyAgreementAlgorithms
         *        The key agreement algorithm used to derive a shared secret.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder keyAgreementAlgorithmsWithStrings(Collection<String> keyAgreementAlgorithms);

        /**
         * <p>
         * The key agreement algorithm used to derive a shared secret.
         * </p>
         * 
         * @param keyAgreementAlgorithms
         *        The key agreement algorithm used to derive a shared secret.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder keyAgreementAlgorithmsWithStrings(String... keyAgreementAlgorithms);

        /**
         * <p>
         * The key agreement algorithm used to derive a shared secret.
         * </p>
         * 
         * @param keyAgreementAlgorithms
         *        The key agreement algorithm used to derive a shared secret.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder keyAgreementAlgorithms(Collection<KeyAgreementAlgorithmSpec> keyAgreementAlgorithms);

        /**
         * <p>
         * The key agreement algorithm used to derive a shared secret.
         * </p>
         * 
         * @param keyAgreementAlgorithms
         *        The key agreement algorithm used to derive a shared secret.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder keyAgreementAlgorithms(KeyAgreementAlgorithmSpec... keyAgreementAlgorithms);

        /**
         * <p>
         * Indicates whether the KMS key is a multi-Region (<code>True</code>) or regional (<code>False</code>) key.
         * This value is <code>True</code> for multi-Region primary and replica keys and <code>False</code> for regional
         * KMS keys.
         * </p>
         * <p>
         * For more information about multi-Region keys, see <a
         * href="https://docs.aws.amazon.com/kms/latest/developerguide/multi-region-keys-overview.html">Multi-Region
         * keys in KMS</a> in the <i>Key Management Service Developer Guide</i>.
         * </p>
         * 
         * @param multiRegion
         *        Indicates whether the KMS key is a multi-Region (<code>True</code>) or regional (<code>False</code>)
         *        key. This value is <code>True</code> for multi-Region primary and replica keys and <code>False</code>
         *        for regional KMS keys.</p>
         *        <p>
         *        For more information about multi-Region keys, see <a
         *        href="https://docs.aws.amazon.com/kms/latest/developerguide/multi-region-keys-overview.html"
         *        >Multi-Region keys in KMS</a> in the <i>Key Management Service Developer Guide</i>.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder multiRegion(Boolean multiRegion);

        /**
         * <p>
         * Lists the primary and replica keys in same multi-Region key. This field is present only when the value of the
         * <code>MultiRegion</code> field is <code>True</code>.
         * </p>
         * <p>
         * For more information about any listed KMS key, use the <a>DescribeKey</a> operation.
         * </p>
         * <ul>
         * <li>
         * <p>
         * <code>MultiRegionKeyType</code> indicates whether the KMS key is a <code>PRIMARY</code> or
         * <code>REPLICA</code> key.
         * </p>
         * </li>
         * <li>
         * <p>
         * <code>PrimaryKey</code> displays the key ARN and Region of the primary key. This field displays the current
         * KMS key if it is the primary key.
         * </p>
         * </li>
         * <li>
         * <p>
         * <code>ReplicaKeys</code> displays the key ARNs and Regions of all replica keys. This field includes the
         * current KMS key if it is a replica key.
         * </p>
         * </li>
         * </ul>
         * 
         * @param multiRegionConfiguration
         *        Lists the primary and replica keys in same multi-Region key. This field is present only when the value
         *        of the <code>MultiRegion</code> field is <code>True</code>.</p>
         *        <p>
         *        For more information about any listed KMS key, use the <a>DescribeKey</a> operation.
         *        </p>
         *        <ul>
         *        <li>
         *        <p>
         *        <code>MultiRegionKeyType</code> indicates whether the KMS key is a <code>PRIMARY</code> or
         *        <code>REPLICA</code> key.
         *        </p>
         *        </li>
         *        <li>
         *        <p>
         *        <code>PrimaryKey</code> displays the key ARN and Region of the primary key. This field displays the
         *        current KMS key if it is the primary key.
         *        </p>
         *        </li>
         *        <li>
         *        <p>
         *        <code>ReplicaKeys</code> displays the key ARNs and Regions of all replica keys. This field includes
         *        the current KMS key if it is a replica key.
         *        </p>
         *        </li>
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder multiRegionConfiguration(MultiRegionConfiguration multiRegionConfiguration);

        /**
         * <p>
         * Lists the primary and replica keys in same multi-Region key. This field is present only when the value of the
         * <code>MultiRegion</code> field is <code>True</code>.
         * </p>
         * <p>
         * For more information about any listed KMS key, use the <a>DescribeKey</a> operation.
         * </p>
         * <ul>
         * <li>
         * <p>
         * <code>MultiRegionKeyType</code> indicates whether the KMS key is a <code>PRIMARY</code> or
         * <code>REPLICA</code> key.
         * </p>
         * </li>
         * <li>
         * <p>
         * <code>PrimaryKey</code> displays the key ARN and Region of the primary key. This field displays the current
         * KMS key if it is the primary key.
         * </p>
         * </li>
         * <li>
         * <p>
         * <code>ReplicaKeys</code> displays the key ARNs and Regions of all replica keys. This field includes the
         * current KMS key if it is a replica key.
         * </p>
         * </li>
         * </ul>
         * This is a convenience method that creates an instance of the {@link MultiRegionConfiguration.Builder}
         * avoiding the need to create one manually via {@link MultiRegionConfiguration#builder()}.
         *
         * <p>
         * When the {@link Consumer} completes, {@link MultiRegionConfiguration.Builder#build()} is called immediately
         * and its result is passed to {@link #multiRegionConfiguration(MultiRegionConfiguration)}.
         * 
         * @param multiRegionConfiguration
         *        a consumer that will call methods on {@link MultiRegionConfiguration.Builder}
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see #multiRegionConfiguration(MultiRegionConfiguration)
         */
        default Builder multiRegionConfiguration(Consumer<MultiRegionConfiguration.Builder> multiRegionConfiguration) {
            return multiRegionConfiguration(MultiRegionConfiguration.builder().applyMutation(multiRegionConfiguration).build());
        }

        /**
         * <p>
         * The waiting period before the primary key in a multi-Region key is deleted. This waiting period begins when
         * the last of its replica keys is deleted. This value is present only when the <code>KeyState</code> of the KMS
         * key is <code>PendingReplicaDeletion</code>. That indicates that the KMS key is the primary key in a
         * multi-Region key, it is scheduled for deletion, and it still has existing replica keys.
         * </p>
         * <p>
         * When a single-Region KMS key or a multi-Region replica key is scheduled for deletion, its deletion date is
         * displayed in the <code>DeletionDate</code> field. However, when the primary key in a multi-Region key is
         * scheduled for deletion, its waiting period doesn't begin until all of its replica keys are deleted. This
         * value displays that waiting period. When the last replica key in the multi-Region key is deleted, the
         * <code>KeyState</code> of the scheduled primary key changes from <code>PendingReplicaDeletion</code> to
         * <code>PendingDeletion</code> and the deletion date appears in the <code>DeletionDate</code> field.
         * </p>
         * 
         * @param pendingDeletionWindowInDays
         *        The waiting period before the primary key in a multi-Region key is deleted. This waiting period begins
         *        when the last of its replica keys is deleted. This value is present only when the
         *        <code>KeyState</code> of the KMS key is <code>PendingReplicaDeletion</code>. That indicates that the
         *        KMS key is the primary key in a multi-Region key, it is scheduled for deletion, and it still has
         *        existing replica keys.</p>
         *        <p>
         *        When a single-Region KMS key or a multi-Region replica key is scheduled for deletion, its deletion
         *        date is displayed in the <code>DeletionDate</code> field. However, when the primary key in a
         *        multi-Region key is scheduled for deletion, its waiting period doesn't begin until all of its replica
         *        keys are deleted. This value displays that waiting period. When the last replica key in the
         *        multi-Region key is deleted, the <code>KeyState</code> of the scheduled primary key changes from
         *        <code>PendingReplicaDeletion</code> to <code>PendingDeletion</code> and the deletion date appears in
         *        the <code>DeletionDate</code> field.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder pendingDeletionWindowInDays(Integer pendingDeletionWindowInDays);

        /**
         * <p>
         * The message authentication code (MAC) algorithm that the HMAC KMS key supports.
         * </p>
         * <p>
         * This value is present only when the <code>KeyUsage</code> of the KMS key is <code>GENERATE_VERIFY_MAC</code>.
         * </p>
         * 
         * @param macAlgorithms
         *        The message authentication code (MAC) algorithm that the HMAC KMS key supports.</p>
         *        <p>
         *        This value is present only when the <code>KeyUsage</code> of the KMS key is
         *        <code>GENERATE_VERIFY_MAC</code>.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder macAlgorithmsWithStrings(Collection<String> macAlgorithms);

        /**
         * <p>
         * The message authentication code (MAC) algorithm that the HMAC KMS key supports.
         * </p>
         * <p>
         * This value is present only when the <code>KeyUsage</code> of the KMS key is <code>GENERATE_VERIFY_MAC</code>.
         * </p>
         * 
         * @param macAlgorithms
         *        The message authentication code (MAC) algorithm that the HMAC KMS key supports.</p>
         *        <p>
         *        This value is present only when the <code>KeyUsage</code> of the KMS key is
         *        <code>GENERATE_VERIFY_MAC</code>.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder macAlgorithmsWithStrings(String... macAlgorithms);

        /**
         * <p>
         * The message authentication code (MAC) algorithm that the HMAC KMS key supports.
         * </p>
         * <p>
         * This value is present only when the <code>KeyUsage</code> of the KMS key is <code>GENERATE_VERIFY_MAC</code>.
         * </p>
         * 
         * @param macAlgorithms
         *        The message authentication code (MAC) algorithm that the HMAC KMS key supports.</p>
         *        <p>
         *        This value is present only when the <code>KeyUsage</code> of the KMS key is
         *        <code>GENERATE_VERIFY_MAC</code>.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder macAlgorithms(Collection<MacAlgorithmSpec> macAlgorithms);

        /**
         * <p>
         * The message authentication code (MAC) algorithm that the HMAC KMS key supports.
         * </p>
         * <p>
         * This value is present only when the <code>KeyUsage</code> of the KMS key is <code>GENERATE_VERIFY_MAC</code>.
         * </p>
         * 
         * @param macAlgorithms
         *        The message authentication code (MAC) algorithm that the HMAC KMS key supports.</p>
         *        <p>
         *        This value is present only when the <code>KeyUsage</code> of the KMS key is
         *        <code>GENERATE_VERIFY_MAC</code>.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder macAlgorithms(MacAlgorithmSpec... macAlgorithms);

        /**
         * <p>
         * Information about the external key that is associated with a KMS key in an external key store.
         * </p>
         * <p>
         * For more information, see <a
         * href="https://docs.aws.amazon.com/kms/latest/developerguide/keystore-external.html#concept-external-key"
         * >External key</a> in the <i>Key Management Service Developer Guide</i>.
         * </p>
         * 
         * @param xksKeyConfiguration
         *        Information about the external key that is associated with a KMS key in an external key store.</p>
         *        <p>
         *        For more information, see <a href=
         *        "https://docs.aws.amazon.com/kms/latest/developerguide/keystore-external.html#concept-external-key"
         *        >External key</a> in the <i>Key Management Service Developer Guide</i>.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder xksKeyConfiguration(XksKeyConfigurationType xksKeyConfiguration);

        /**
         * <p>
         * Information about the external key that is associated with a KMS key in an external key store.
         * </p>
         * <p>
         * For more information, see <a
         * href="https://docs.aws.amazon.com/kms/latest/developerguide/keystore-external.html#concept-external-key"
         * >External key</a> in the <i>Key Management Service Developer Guide</i>.
         * </p>
         * This is a convenience method that creates an instance of the {@link XksKeyConfigurationType.Builder} avoiding
         * the need to create one manually via {@link XksKeyConfigurationType#builder()}.
         *
         * <p>
         * When the {@link Consumer} completes, {@link XksKeyConfigurationType.Builder#build()} is called immediately
         * and its result is passed to {@link #xksKeyConfiguration(XksKeyConfigurationType)}.
         * 
         * @param xksKeyConfiguration
         *        a consumer that will call methods on {@link XksKeyConfigurationType.Builder}
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see #xksKeyConfiguration(XksKeyConfigurationType)
         */
        default Builder xksKeyConfiguration(Consumer<XksKeyConfigurationType.Builder> xksKeyConfiguration) {
            return xksKeyConfiguration(XksKeyConfigurationType.builder().applyMutation(xksKeyConfiguration).build());
        }
    }

    static final class BuilderImpl implements Builder {
        private String awsAccountId;

        private String keyId;

        private String arn;

        private Instant creationDate;

        private Boolean enabled;

        private String description;

        private String keyUsage;

        private String keyState;

        private Instant deletionDate;

        private Instant validTo;

        private String origin;

        private String customKeyStoreId;

        private String cloudHsmClusterId;

        private String expirationModel;

        private String keyManager;

        private String customerMasterKeySpec;

        private String keySpec;

        private List<String> encryptionAlgorithms = DefaultSdkAutoConstructList.getInstance();

        private List<String> signingAlgorithms = DefaultSdkAutoConstructList.getInstance();

        private List<String> keyAgreementAlgorithms = DefaultSdkAutoConstructList.getInstance();

        private Boolean multiRegion;

        private MultiRegionConfiguration multiRegionConfiguration;

        private Integer pendingDeletionWindowInDays;

        private List<String> macAlgorithms = DefaultSdkAutoConstructList.getInstance();

        private XksKeyConfigurationType xksKeyConfiguration;

        private BuilderImpl() {
        }

        private BuilderImpl(KeyMetadata model) {
            awsAccountId(model.awsAccountId);
            keyId(model.keyId);
            arn(model.arn);
            creationDate(model.creationDate);
            enabled(model.enabled);
            description(model.description);
            keyUsage(model.keyUsage);
            keyState(model.keyState);
            deletionDate(model.deletionDate);
            validTo(model.validTo);
            origin(model.origin);
            customKeyStoreId(model.customKeyStoreId);
            cloudHsmClusterId(model.cloudHsmClusterId);
            expirationModel(model.expirationModel);
            keyManager(model.keyManager);
            customerMasterKeySpec(model.customerMasterKeySpec);
            keySpec(model.keySpec);
            encryptionAlgorithmsWithStrings(model.encryptionAlgorithms);
            signingAlgorithmsWithStrings(model.signingAlgorithms);
            keyAgreementAlgorithmsWithStrings(model.keyAgreementAlgorithms);
            multiRegion(model.multiRegion);
            multiRegionConfiguration(model.multiRegionConfiguration);
            pendingDeletionWindowInDays(model.pendingDeletionWindowInDays);
            macAlgorithmsWithStrings(model.macAlgorithms);
            xksKeyConfiguration(model.xksKeyConfiguration);
        }

        public final String getAwsAccountId() {
            return awsAccountId;
        }

        public final void setAwsAccountId(String awsAccountId) {
            this.awsAccountId = awsAccountId;
        }

        @Override
        public final Builder awsAccountId(String awsAccountId) {
            this.awsAccountId = awsAccountId;
            return this;
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

        public final Instant getCreationDate() {
            return creationDate;
        }

        public final void setCreationDate(Instant creationDate) {
            this.creationDate = creationDate;
        }

        @Override
        public final Builder creationDate(Instant creationDate) {
            this.creationDate = creationDate;
            return this;
        }

        public final Boolean getEnabled() {
            return enabled;
        }

        public final void setEnabled(Boolean enabled) {
            this.enabled = enabled;
        }

        @Override
        public final Builder enabled(Boolean enabled) {
            this.enabled = enabled;
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

        public final String getKeyState() {
            return keyState;
        }

        public final void setKeyState(String keyState) {
            this.keyState = keyState;
        }

        @Override
        public final Builder keyState(String keyState) {
            this.keyState = keyState;
            return this;
        }

        @Override
        public final Builder keyState(KeyState keyState) {
            this.keyState(keyState == null ? null : keyState.toString());
            return this;
        }

        public final Instant getDeletionDate() {
            return deletionDate;
        }

        public final void setDeletionDate(Instant deletionDate) {
            this.deletionDate = deletionDate;
        }

        @Override
        public final Builder deletionDate(Instant deletionDate) {
            this.deletionDate = deletionDate;
            return this;
        }

        public final Instant getValidTo() {
            return validTo;
        }

        public final void setValidTo(Instant validTo) {
            this.validTo = validTo;
        }

        @Override
        public final Builder validTo(Instant validTo) {
            this.validTo = validTo;
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

        public final String getCloudHsmClusterId() {
            return cloudHsmClusterId;
        }

        public final void setCloudHsmClusterId(String cloudHsmClusterId) {
            this.cloudHsmClusterId = cloudHsmClusterId;
        }

        @Override
        public final Builder cloudHsmClusterId(String cloudHsmClusterId) {
            this.cloudHsmClusterId = cloudHsmClusterId;
            return this;
        }

        public final String getExpirationModel() {
            return expirationModel;
        }

        public final void setExpirationModel(String expirationModel) {
            this.expirationModel = expirationModel;
        }

        @Override
        public final Builder expirationModel(String expirationModel) {
            this.expirationModel = expirationModel;
            return this;
        }

        @Override
        public final Builder expirationModel(ExpirationModelType expirationModel) {
            this.expirationModel(expirationModel == null ? null : expirationModel.toString());
            return this;
        }

        public final String getKeyManager() {
            return keyManager;
        }

        public final void setKeyManager(String keyManager) {
            this.keyManager = keyManager;
        }

        @Override
        public final Builder keyManager(String keyManager) {
            this.keyManager = keyManager;
            return this;
        }

        @Override
        public final Builder keyManager(KeyManagerType keyManager) {
            this.keyManager(keyManager == null ? null : keyManager.toString());
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

        public final Collection<String> getEncryptionAlgorithms() {
            if (encryptionAlgorithms instanceof SdkAutoConstructList) {
                return null;
            }
            return encryptionAlgorithms;
        }

        public final void setEncryptionAlgorithms(Collection<String> encryptionAlgorithms) {
            this.encryptionAlgorithms = EncryptionAlgorithmSpecListCopier.copy(encryptionAlgorithms);
        }

        @Override
        public final Builder encryptionAlgorithmsWithStrings(Collection<String> encryptionAlgorithms) {
            this.encryptionAlgorithms = EncryptionAlgorithmSpecListCopier.copy(encryptionAlgorithms);
            return this;
        }

        @Override
        @SafeVarargs
        public final Builder encryptionAlgorithmsWithStrings(String... encryptionAlgorithms) {
            encryptionAlgorithmsWithStrings(Arrays.asList(encryptionAlgorithms));
            return this;
        }

        @Override
        public final Builder encryptionAlgorithms(Collection<EncryptionAlgorithmSpec> encryptionAlgorithms) {
            this.encryptionAlgorithms = EncryptionAlgorithmSpecListCopier.copyEnumToString(encryptionAlgorithms);
            return this;
        }

        @Override
        @SafeVarargs
        public final Builder encryptionAlgorithms(EncryptionAlgorithmSpec... encryptionAlgorithms) {
            encryptionAlgorithms(Arrays.asList(encryptionAlgorithms));
            return this;
        }

        public final Collection<String> getSigningAlgorithms() {
            if (signingAlgorithms instanceof SdkAutoConstructList) {
                return null;
            }
            return signingAlgorithms;
        }

        public final void setSigningAlgorithms(Collection<String> signingAlgorithms) {
            this.signingAlgorithms = SigningAlgorithmSpecListCopier.copy(signingAlgorithms);
        }

        @Override
        public final Builder signingAlgorithmsWithStrings(Collection<String> signingAlgorithms) {
            this.signingAlgorithms = SigningAlgorithmSpecListCopier.copy(signingAlgorithms);
            return this;
        }

        @Override
        @SafeVarargs
        public final Builder signingAlgorithmsWithStrings(String... signingAlgorithms) {
            signingAlgorithmsWithStrings(Arrays.asList(signingAlgorithms));
            return this;
        }

        @Override
        public final Builder signingAlgorithms(Collection<SigningAlgorithmSpec> signingAlgorithms) {
            this.signingAlgorithms = SigningAlgorithmSpecListCopier.copyEnumToString(signingAlgorithms);
            return this;
        }

        @Override
        @SafeVarargs
        public final Builder signingAlgorithms(SigningAlgorithmSpec... signingAlgorithms) {
            signingAlgorithms(Arrays.asList(signingAlgorithms));
            return this;
        }

        public final Collection<String> getKeyAgreementAlgorithms() {
            if (keyAgreementAlgorithms instanceof SdkAutoConstructList) {
                return null;
            }
            return keyAgreementAlgorithms;
        }

        public final void setKeyAgreementAlgorithms(Collection<String> keyAgreementAlgorithms) {
            this.keyAgreementAlgorithms = KeyAgreementAlgorithmSpecListCopier.copy(keyAgreementAlgorithms);
        }

        @Override
        public final Builder keyAgreementAlgorithmsWithStrings(Collection<String> keyAgreementAlgorithms) {
            this.keyAgreementAlgorithms = KeyAgreementAlgorithmSpecListCopier.copy(keyAgreementAlgorithms);
            return this;
        }

        @Override
        @SafeVarargs
        public final Builder keyAgreementAlgorithmsWithStrings(String... keyAgreementAlgorithms) {
            keyAgreementAlgorithmsWithStrings(Arrays.asList(keyAgreementAlgorithms));
            return this;
        }

        @Override
        public final Builder keyAgreementAlgorithms(Collection<KeyAgreementAlgorithmSpec> keyAgreementAlgorithms) {
            this.keyAgreementAlgorithms = KeyAgreementAlgorithmSpecListCopier.copyEnumToString(keyAgreementAlgorithms);
            return this;
        }

        @Override
        @SafeVarargs
        public final Builder keyAgreementAlgorithms(KeyAgreementAlgorithmSpec... keyAgreementAlgorithms) {
            keyAgreementAlgorithms(Arrays.asList(keyAgreementAlgorithms));
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

        public final MultiRegionConfiguration.Builder getMultiRegionConfiguration() {
            return multiRegionConfiguration != null ? multiRegionConfiguration.toBuilder() : null;
        }

        public final void setMultiRegionConfiguration(MultiRegionConfiguration.BuilderImpl multiRegionConfiguration) {
            this.multiRegionConfiguration = multiRegionConfiguration != null ? multiRegionConfiguration.build() : null;
        }

        @Override
        public final Builder multiRegionConfiguration(MultiRegionConfiguration multiRegionConfiguration) {
            this.multiRegionConfiguration = multiRegionConfiguration;
            return this;
        }

        public final Integer getPendingDeletionWindowInDays() {
            return pendingDeletionWindowInDays;
        }

        public final void setPendingDeletionWindowInDays(Integer pendingDeletionWindowInDays) {
            this.pendingDeletionWindowInDays = pendingDeletionWindowInDays;
        }

        @Override
        public final Builder pendingDeletionWindowInDays(Integer pendingDeletionWindowInDays) {
            this.pendingDeletionWindowInDays = pendingDeletionWindowInDays;
            return this;
        }

        public final Collection<String> getMacAlgorithms() {
            if (macAlgorithms instanceof SdkAutoConstructList) {
                return null;
            }
            return macAlgorithms;
        }

        public final void setMacAlgorithms(Collection<String> macAlgorithms) {
            this.macAlgorithms = MacAlgorithmSpecListCopier.copy(macAlgorithms);
        }

        @Override
        public final Builder macAlgorithmsWithStrings(Collection<String> macAlgorithms) {
            this.macAlgorithms = MacAlgorithmSpecListCopier.copy(macAlgorithms);
            return this;
        }

        @Override
        @SafeVarargs
        public final Builder macAlgorithmsWithStrings(String... macAlgorithms) {
            macAlgorithmsWithStrings(Arrays.asList(macAlgorithms));
            return this;
        }

        @Override
        public final Builder macAlgorithms(Collection<MacAlgorithmSpec> macAlgorithms) {
            this.macAlgorithms = MacAlgorithmSpecListCopier.copyEnumToString(macAlgorithms);
            return this;
        }

        @Override
        @SafeVarargs
        public final Builder macAlgorithms(MacAlgorithmSpec... macAlgorithms) {
            macAlgorithms(Arrays.asList(macAlgorithms));
            return this;
        }

        public final XksKeyConfigurationType.Builder getXksKeyConfiguration() {
            return xksKeyConfiguration != null ? xksKeyConfiguration.toBuilder() : null;
        }

        public final void setXksKeyConfiguration(XksKeyConfigurationType.BuilderImpl xksKeyConfiguration) {
            this.xksKeyConfiguration = xksKeyConfiguration != null ? xksKeyConfiguration.build() : null;
        }

        @Override
        public final Builder xksKeyConfiguration(XksKeyConfigurationType xksKeyConfiguration) {
            this.xksKeyConfiguration = xksKeyConfiguration;
            return this;
        }

        @Override
        public KeyMetadata build() {
            return new KeyMetadata(this);
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
