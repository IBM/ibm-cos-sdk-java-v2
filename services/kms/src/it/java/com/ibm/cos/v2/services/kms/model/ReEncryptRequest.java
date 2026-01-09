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

import java.nio.ByteBuffer;
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
import com.ibm.cos.v2.awscore.AwsRequestOverrideConfiguration;
import com.ibm.cos.v2.core.SdkBytes;
import com.ibm.cos.v2.core.SdkField;
import com.ibm.cos.v2.core.SdkPojo;
import com.ibm.cos.v2.core.protocol.MarshallLocation;
import com.ibm.cos.v2.core.protocol.MarshallingType;
import com.ibm.cos.v2.core.traits.ListTrait;
import com.ibm.cos.v2.core.traits.LocationTrait;
import com.ibm.cos.v2.core.traits.MapTrait;
import com.ibm.cos.v2.core.util.DefaultSdkAutoConstructList;
import com.ibm.cos.v2.core.util.DefaultSdkAutoConstructMap;
import com.ibm.cos.v2.core.util.SdkAutoConstructList;
import com.ibm.cos.v2.core.util.SdkAutoConstructMap;
import com.ibm.cos.v2.utils.ToString;
import com.ibm.cos.v2.utils.builder.CopyableBuilder;
import com.ibm.cos.v2.utils.builder.ToCopyableBuilder;

/**
 */
@Generated("com.ibm.cos.v2:codegen")
public final class ReEncryptRequest extends KmsRequest implements ToCopyableBuilder<ReEncryptRequest.Builder, ReEncryptRequest> {
    private static final SdkField<SdkBytes> CIPHERTEXT_BLOB_FIELD = SdkField.<SdkBytes> builder(MarshallingType.SDK_BYTES)
            .memberName("CiphertextBlob").getter(getter(ReEncryptRequest::ciphertextBlob))
            .setter(setter(Builder::ciphertextBlob))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("CiphertextBlob").build()).build();

    private static final SdkField<Map<String, String>> SOURCE_ENCRYPTION_CONTEXT_FIELD = SdkField
            .<Map<String, String>> builder(MarshallingType.MAP)
            .memberName("SourceEncryptionContext")
            .getter(getter(ReEncryptRequest::sourceEncryptionContext))
            .setter(setter(Builder::sourceEncryptionContext))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("SourceEncryptionContext").build(),
                    MapTrait.builder()
                            .keyLocationName("key")
                            .valueLocationName("value")
                            .valueFieldInfo(
                                    SdkField.<String> builder(MarshallingType.STRING)
                                            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD)
                                                    .locationName("value").build()).build()).build()).build();

    private static final SdkField<String> SOURCE_KEY_ID_FIELD = SdkField.<String> builder(MarshallingType.STRING)
            .memberName("SourceKeyId").getter(getter(ReEncryptRequest::sourceKeyId)).setter(setter(Builder::sourceKeyId))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("SourceKeyId").build()).build();

    private static final SdkField<String> DESTINATION_KEY_ID_FIELD = SdkField.<String> builder(MarshallingType.STRING)
            .memberName("DestinationKeyId").getter(getter(ReEncryptRequest::destinationKeyId))
            .setter(setter(Builder::destinationKeyId))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("DestinationKeyId").build()).build();

    private static final SdkField<Map<String, String>> DESTINATION_ENCRYPTION_CONTEXT_FIELD = SdkField
            .<Map<String, String>> builder(MarshallingType.MAP)
            .memberName("DestinationEncryptionContext")
            .getter(getter(ReEncryptRequest::destinationEncryptionContext))
            .setter(setter(Builder::destinationEncryptionContext))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("DestinationEncryptionContext")
                    .build(),
                    MapTrait.builder()
                            .keyLocationName("key")
                            .valueLocationName("value")
                            .valueFieldInfo(
                                    SdkField.<String> builder(MarshallingType.STRING)
                                            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD)
                                                    .locationName("value").build()).build()).build()).build();

    private static final SdkField<String> SOURCE_ENCRYPTION_ALGORITHM_FIELD = SdkField.<String> builder(MarshallingType.STRING)
            .memberName("SourceEncryptionAlgorithm").getter(getter(ReEncryptRequest::sourceEncryptionAlgorithmAsString))
            .setter(setter(Builder::sourceEncryptionAlgorithm))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("SourceEncryptionAlgorithm").build())
            .build();

    private static final SdkField<String> DESTINATION_ENCRYPTION_ALGORITHM_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("DestinationEncryptionAlgorithm")
            .getter(getter(ReEncryptRequest::destinationEncryptionAlgorithmAsString))
            .setter(setter(Builder::destinationEncryptionAlgorithm))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("DestinationEncryptionAlgorithm")
                    .build()).build();

    private static final SdkField<List<String>> GRANT_TOKENS_FIELD = SdkField
            .<List<String>> builder(MarshallingType.LIST)
            .memberName("GrantTokens")
            .getter(getter(ReEncryptRequest::grantTokens))
            .setter(setter(Builder::grantTokens))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("GrantTokens").build(),
                    ListTrait
                            .builder()
                            .memberLocationName(null)
                            .memberFieldInfo(
                                    SdkField.<String> builder(MarshallingType.STRING)
                                            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD)
                                                    .locationName("member").build()).build()).build()).build();

    private static final SdkField<Boolean> DRY_RUN_FIELD = SdkField.<Boolean> builder(MarshallingType.BOOLEAN)
            .memberName("DryRun").getter(getter(ReEncryptRequest::dryRun)).setter(setter(Builder::dryRun))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("DryRun").build()).build();

    private static final List<SdkField<?>> SDK_FIELDS = Collections.unmodifiableList(Arrays.asList(CIPHERTEXT_BLOB_FIELD,
            SOURCE_ENCRYPTION_CONTEXT_FIELD, SOURCE_KEY_ID_FIELD, DESTINATION_KEY_ID_FIELD, DESTINATION_ENCRYPTION_CONTEXT_FIELD,
            SOURCE_ENCRYPTION_ALGORITHM_FIELD, DESTINATION_ENCRYPTION_ALGORITHM_FIELD, GRANT_TOKENS_FIELD, DRY_RUN_FIELD));

    private static final Map<String, SdkField<?>> SDK_NAME_TO_FIELD = memberNameToFieldInitializer();

    private final SdkBytes ciphertextBlob;

    private final Map<String, String> sourceEncryptionContext;

    private final String sourceKeyId;

    private final String destinationKeyId;

    private final Map<String, String> destinationEncryptionContext;

    private final String sourceEncryptionAlgorithm;

    private final String destinationEncryptionAlgorithm;

    private final List<String> grantTokens;

    private final Boolean dryRun;

    private ReEncryptRequest(BuilderImpl builder) {
        super(builder);
        this.ciphertextBlob = builder.ciphertextBlob;
        this.sourceEncryptionContext = builder.sourceEncryptionContext;
        this.sourceKeyId = builder.sourceKeyId;
        this.destinationKeyId = builder.destinationKeyId;
        this.destinationEncryptionContext = builder.destinationEncryptionContext;
        this.sourceEncryptionAlgorithm = builder.sourceEncryptionAlgorithm;
        this.destinationEncryptionAlgorithm = builder.destinationEncryptionAlgorithm;
        this.grantTokens = builder.grantTokens;
        this.dryRun = builder.dryRun;
    }

    /**
     * <p>
     * Ciphertext of the data to reencrypt.
     * </p>
     * 
     * @return Ciphertext of the data to reencrypt.
     */
    public final SdkBytes ciphertextBlob() {
        return ciphertextBlob;
    }

    /**
     * For responses, this returns true if the service returned a value for the SourceEncryptionContext property. This
     * DOES NOT check that the value is non-empty (for which, you should check the {@code isEmpty()} method on the
     * property). This is useful because the SDK will never return a null collection or map, but you may need to
     * differentiate between the service returning nothing (or null) and the service returning an empty collection or
     * map. For requests, this returns true if a value for the property was specified in the request builder, and false
     * if a value was not specified.
     */
    public final boolean hasSourceEncryptionContext() {
        return sourceEncryptionContext != null && !(sourceEncryptionContext instanceof SdkAutoConstructMap);
    }

    /**
     * <p>
     * Specifies the encryption context to use to decrypt the ciphertext. Enter the same encryption context that was
     * used to encrypt the ciphertext.
     * </p>
     * <p>
     * An <i>encryption context</i> is a collection of non-secret key-value pairs that represent additional
     * authenticated data. When you use an encryption context to encrypt data, you must specify the same (an exact
     * case-sensitive match) encryption context to decrypt the data. An encryption context is supported only on
     * operations with symmetric encryption KMS keys. On operations with symmetric encryption KMS keys, an encryption
     * context is optional, but it is strongly recommended.
     * </p>
     * <p>
     * For more information, see <a
     * href="https://docs.aws.amazon.com/kms/latest/developerguide/concepts.html#encrypt_context">Encryption context</a>
     * in the <i>Key Management Service Developer Guide</i>.
     * </p>
     * <p>
     * Attempts to modify the collection returned by this method will result in an UnsupportedOperationException.
     * </p>
     * <p>
     * This method will never return null. If you would like to know whether the service returned this field (so that
     * you can differentiate between null and empty), you can use the {@link #hasSourceEncryptionContext} method.
     * </p>
     * 
     * @return Specifies the encryption context to use to decrypt the ciphertext. Enter the same encryption context that
     *         was used to encrypt the ciphertext.</p>
     *         <p>
     *         An <i>encryption context</i> is a collection of non-secret key-value pairs that represent additional
     *         authenticated data. When you use an encryption context to encrypt data, you must specify the same (an
     *         exact case-sensitive match) encryption context to decrypt the data. An encryption context is supported
     *         only on operations with symmetric encryption KMS keys. On operations with symmetric encryption KMS keys,
     *         an encryption context is optional, but it is strongly recommended.
     *         </p>
     *         <p>
     *         For more information, see <a
     *         href="https://docs.aws.amazon.com/kms/latest/developerguide/concepts.html#encrypt_context">Encryption
     *         context</a> in the <i>Key Management Service Developer Guide</i>.
     */
    public final Map<String, String> sourceEncryptionContext() {
        return sourceEncryptionContext;
    }

    /**
     * <p>
     * Specifies the KMS key that KMS will use to decrypt the ciphertext before it is re-encrypted.
     * </p>
     * <p>
     * Enter a key ID of the KMS key that was used to encrypt the ciphertext. If you identify a different KMS key, the
     * <code>ReEncrypt</code> operation throws an <code>IncorrectKeyException</code>.
     * </p>
     * <p>
     * This parameter is required only when the ciphertext was encrypted under an asymmetric KMS key. If you used a
     * symmetric encryption KMS key, KMS can get the KMS key from metadata that it adds to the symmetric ciphertext
     * blob. However, it is always recommended as a best practice. This practice ensures that you use the KMS key that
     * you intend.
     * </p>
     * <p>
     * To specify a KMS key, use its key ID, key ARN, alias name, or alias ARN. When using an alias name, prefix it with
     * <code>"alias/"</code>. To specify a KMS key in a different Amazon Web Services account, you must use the key ARN
     * or alias ARN.
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
     * <li>
     * <p>
     * Alias name: <code>alias/ExampleAlias</code>
     * </p>
     * </li>
     * <li>
     * <p>
     * Alias ARN: <code>arn:aws:kms:us-east-2:111122223333:alias/ExampleAlias</code>
     * </p>
     * </li>
     * </ul>
     * <p>
     * To get the key ID and key ARN for a KMS key, use <a>ListKeys</a> or <a>DescribeKey</a>. To get the alias name and
     * alias ARN, use <a>ListAliases</a>.
     * </p>
     * 
     * @return Specifies the KMS key that KMS will use to decrypt the ciphertext before it is re-encrypted.</p>
     *         <p>
     *         Enter a key ID of the KMS key that was used to encrypt the ciphertext. If you identify a different KMS
     *         key, the <code>ReEncrypt</code> operation throws an <code>IncorrectKeyException</code>.
     *         </p>
     *         <p>
     *         This parameter is required only when the ciphertext was encrypted under an asymmetric KMS key. If you
     *         used a symmetric encryption KMS key, KMS can get the KMS key from metadata that it adds to the symmetric
     *         ciphertext blob. However, it is always recommended as a best practice. This practice ensures that you use
     *         the KMS key that you intend.
     *         </p>
     *         <p>
     *         To specify a KMS key, use its key ID, key ARN, alias name, or alias ARN. When using an alias name, prefix
     *         it with <code>"alias/"</code>. To specify a KMS key in a different Amazon Web Services account, you must
     *         use the key ARN or alias ARN.
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
     *         <li>
     *         <p>
     *         Alias name: <code>alias/ExampleAlias</code>
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         Alias ARN: <code>arn:aws:kms:us-east-2:111122223333:alias/ExampleAlias</code>
     *         </p>
     *         </li>
     *         </ul>
     *         <p>
     *         To get the key ID and key ARN for a KMS key, use <a>ListKeys</a> or <a>DescribeKey</a>. To get the alias
     *         name and alias ARN, use <a>ListAliases</a>.
     */
    public final String sourceKeyId() {
        return sourceKeyId;
    }

    /**
     * <p>
     * A unique identifier for the KMS key that is used to reencrypt the data. Specify a symmetric encryption KMS key or
     * an asymmetric KMS key with a <code>KeyUsage</code> value of <code>ENCRYPT_DECRYPT</code>. To find the
     * <code>KeyUsage</code> value of a KMS key, use the <a>DescribeKey</a> operation.
     * </p>
     * <p>
     * To specify a KMS key, use its key ID, key ARN, alias name, or alias ARN. When using an alias name, prefix it with
     * <code>"alias/"</code>. To specify a KMS key in a different Amazon Web Services account, you must use the key ARN
     * or alias ARN.
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
     * <li>
     * <p>
     * Alias name: <code>alias/ExampleAlias</code>
     * </p>
     * </li>
     * <li>
     * <p>
     * Alias ARN: <code>arn:aws:kms:us-east-2:111122223333:alias/ExampleAlias</code>
     * </p>
     * </li>
     * </ul>
     * <p>
     * To get the key ID and key ARN for a KMS key, use <a>ListKeys</a> or <a>DescribeKey</a>. To get the alias name and
     * alias ARN, use <a>ListAliases</a>.
     * </p>
     * 
     * @return A unique identifier for the KMS key that is used to reencrypt the data. Specify a symmetric encryption
     *         KMS key or an asymmetric KMS key with a <code>KeyUsage</code> value of <code>ENCRYPT_DECRYPT</code>. To
     *         find the <code>KeyUsage</code> value of a KMS key, use the <a>DescribeKey</a> operation.</p>
     *         <p>
     *         To specify a KMS key, use its key ID, key ARN, alias name, or alias ARN. When using an alias name, prefix
     *         it with <code>"alias/"</code>. To specify a KMS key in a different Amazon Web Services account, you must
     *         use the key ARN or alias ARN.
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
     *         <li>
     *         <p>
     *         Alias name: <code>alias/ExampleAlias</code>
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         Alias ARN: <code>arn:aws:kms:us-east-2:111122223333:alias/ExampleAlias</code>
     *         </p>
     *         </li>
     *         </ul>
     *         <p>
     *         To get the key ID and key ARN for a KMS key, use <a>ListKeys</a> or <a>DescribeKey</a>. To get the alias
     *         name and alias ARN, use <a>ListAliases</a>.
     */
    public final String destinationKeyId() {
        return destinationKeyId;
    }

    /**
     * For responses, this returns true if the service returned a value for the DestinationEncryptionContext property.
     * This DOES NOT check that the value is non-empty (for which, you should check the {@code isEmpty()} method on the
     * property). This is useful because the SDK will never return a null collection or map, but you may need to
     * differentiate between the service returning nothing (or null) and the service returning an empty collection or
     * map. For requests, this returns true if a value for the property was specified in the request builder, and false
     * if a value was not specified.
     */
    public final boolean hasDestinationEncryptionContext() {
        return destinationEncryptionContext != null && !(destinationEncryptionContext instanceof SdkAutoConstructMap);
    }

    /**
     * <p>
     * Specifies that encryption context to use when the reencrypting the data.
     * </p>
     * <important>
     * <p>
     * Do not include confidential or sensitive information in this field. This field may be displayed in plaintext in
     * CloudTrail logs and other output.
     * </p>
     * </important>
     * <p>
     * A destination encryption context is valid only when the destination KMS key is a symmetric encryption KMS key.
     * The standard ciphertext format for asymmetric KMS keys does not include fields for metadata.
     * </p>
     * <p>
     * An <i>encryption context</i> is a collection of non-secret key-value pairs that represent additional
     * authenticated data. When you use an encryption context to encrypt data, you must specify the same (an exact
     * case-sensitive match) encryption context to decrypt the data. An encryption context is supported only on
     * operations with symmetric encryption KMS keys. On operations with symmetric encryption KMS keys, an encryption
     * context is optional, but it is strongly recommended.
     * </p>
     * <p>
     * For more information, see <a
     * href="https://docs.aws.amazon.com/kms/latest/developerguide/concepts.html#encrypt_context">Encryption context</a>
     * in the <i>Key Management Service Developer Guide</i>.
     * </p>
     * <p>
     * Attempts to modify the collection returned by this method will result in an UnsupportedOperationException.
     * </p>
     * <p>
     * This method will never return null. If you would like to know whether the service returned this field (so that
     * you can differentiate between null and empty), you can use the {@link #hasDestinationEncryptionContext} method.
     * </p>
     * 
     * @return Specifies that encryption context to use when the reencrypting the data.</p> <important>
     *         <p>
     *         Do not include confidential or sensitive information in this field. This field may be displayed in
     *         plaintext in CloudTrail logs and other output.
     *         </p>
     *         </important>
     *         <p>
     *         A destination encryption context is valid only when the destination KMS key is a symmetric encryption KMS
     *         key. The standard ciphertext format for asymmetric KMS keys does not include fields for metadata.
     *         </p>
     *         <p>
     *         An <i>encryption context</i> is a collection of non-secret key-value pairs that represent additional
     *         authenticated data. When you use an encryption context to encrypt data, you must specify the same (an
     *         exact case-sensitive match) encryption context to decrypt the data. An encryption context is supported
     *         only on operations with symmetric encryption KMS keys. On operations with symmetric encryption KMS keys,
     *         an encryption context is optional, but it is strongly recommended.
     *         </p>
     *         <p>
     *         For more information, see <a
     *         href="https://docs.aws.amazon.com/kms/latest/developerguide/concepts.html#encrypt_context">Encryption
     *         context</a> in the <i>Key Management Service Developer Guide</i>.
     */
    public final Map<String, String> destinationEncryptionContext() {
        return destinationEncryptionContext;
    }

    /**
     * <p>
     * Specifies the encryption algorithm that KMS will use to decrypt the ciphertext before it is reencrypted. The
     * default value, <code>SYMMETRIC_DEFAULT</code>, represents the algorithm used for symmetric encryption KMS keys.
     * </p>
     * <p>
     * Specify the same algorithm that was used to encrypt the ciphertext. If you specify a different algorithm, the
     * decrypt attempt fails.
     * </p>
     * <p>
     * This parameter is required only when the ciphertext was encrypted under an asymmetric KMS key.
     * </p>
     * <p>
     * If the service returns an enum value that is not available in the current SDK version,
     * {@link #sourceEncryptionAlgorithm} will return {@link EncryptionAlgorithmSpec#UNKNOWN_TO_SDK_VERSION}. The raw
     * value returned by the service is available from {@link #sourceEncryptionAlgorithmAsString}.
     * </p>
     * 
     * @return Specifies the encryption algorithm that KMS will use to decrypt the ciphertext before it is reencrypted.
     *         The default value, <code>SYMMETRIC_DEFAULT</code>, represents the algorithm used for symmetric encryption
     *         KMS keys.</p>
     *         <p>
     *         Specify the same algorithm that was used to encrypt the ciphertext. If you specify a different algorithm,
     *         the decrypt attempt fails.
     *         </p>
     *         <p>
     *         This parameter is required only when the ciphertext was encrypted under an asymmetric KMS key.
     * @see EncryptionAlgorithmSpec
     */
    public final EncryptionAlgorithmSpec sourceEncryptionAlgorithm() {
        return EncryptionAlgorithmSpec.fromValue(sourceEncryptionAlgorithm);
    }

    /**
     * <p>
     * Specifies the encryption algorithm that KMS will use to decrypt the ciphertext before it is reencrypted. The
     * default value, <code>SYMMETRIC_DEFAULT</code>, represents the algorithm used for symmetric encryption KMS keys.
     * </p>
     * <p>
     * Specify the same algorithm that was used to encrypt the ciphertext. If you specify a different algorithm, the
     * decrypt attempt fails.
     * </p>
     * <p>
     * This parameter is required only when the ciphertext was encrypted under an asymmetric KMS key.
     * </p>
     * <p>
     * If the service returns an enum value that is not available in the current SDK version,
     * {@link #sourceEncryptionAlgorithm} will return {@link EncryptionAlgorithmSpec#UNKNOWN_TO_SDK_VERSION}. The raw
     * value returned by the service is available from {@link #sourceEncryptionAlgorithmAsString}.
     * </p>
     * 
     * @return Specifies the encryption algorithm that KMS will use to decrypt the ciphertext before it is reencrypted.
     *         The default value, <code>SYMMETRIC_DEFAULT</code>, represents the algorithm used for symmetric encryption
     *         KMS keys.</p>
     *         <p>
     *         Specify the same algorithm that was used to encrypt the ciphertext. If you specify a different algorithm,
     *         the decrypt attempt fails.
     *         </p>
     *         <p>
     *         This parameter is required only when the ciphertext was encrypted under an asymmetric KMS key.
     * @see EncryptionAlgorithmSpec
     */
    public final String sourceEncryptionAlgorithmAsString() {
        return sourceEncryptionAlgorithm;
    }

    /**
     * <p>
     * Specifies the encryption algorithm that KMS will use to reecrypt the data after it has decrypted it. The default
     * value, <code>SYMMETRIC_DEFAULT</code>, represents the encryption algorithm used for symmetric encryption KMS
     * keys.
     * </p>
     * <p>
     * This parameter is required only when the destination KMS key is an asymmetric KMS key.
     * </p>
     * <p>
     * If the service returns an enum value that is not available in the current SDK version,
     * {@link #destinationEncryptionAlgorithm} will return {@link EncryptionAlgorithmSpec#UNKNOWN_TO_SDK_VERSION}. The
     * raw value returned by the service is available from {@link #destinationEncryptionAlgorithmAsString}.
     * </p>
     * 
     * @return Specifies the encryption algorithm that KMS will use to reecrypt the data after it has decrypted it. The
     *         default value, <code>SYMMETRIC_DEFAULT</code>, represents the encryption algorithm used for symmetric
     *         encryption KMS keys.</p>
     *         <p>
     *         This parameter is required only when the destination KMS key is an asymmetric KMS key.
     * @see EncryptionAlgorithmSpec
     */
    public final EncryptionAlgorithmSpec destinationEncryptionAlgorithm() {
        return EncryptionAlgorithmSpec.fromValue(destinationEncryptionAlgorithm);
    }

    /**
     * <p>
     * Specifies the encryption algorithm that KMS will use to reecrypt the data after it has decrypted it. The default
     * value, <code>SYMMETRIC_DEFAULT</code>, represents the encryption algorithm used for symmetric encryption KMS
     * keys.
     * </p>
     * <p>
     * This parameter is required only when the destination KMS key is an asymmetric KMS key.
     * </p>
     * <p>
     * If the service returns an enum value that is not available in the current SDK version,
     * {@link #destinationEncryptionAlgorithm} will return {@link EncryptionAlgorithmSpec#UNKNOWN_TO_SDK_VERSION}. The
     * raw value returned by the service is available from {@link #destinationEncryptionAlgorithmAsString}.
     * </p>
     * 
     * @return Specifies the encryption algorithm that KMS will use to reecrypt the data after it has decrypted it. The
     *         default value, <code>SYMMETRIC_DEFAULT</code>, represents the encryption algorithm used for symmetric
     *         encryption KMS keys.</p>
     *         <p>
     *         This parameter is required only when the destination KMS key is an asymmetric KMS key.
     * @see EncryptionAlgorithmSpec
     */
    public final String destinationEncryptionAlgorithmAsString() {
        return destinationEncryptionAlgorithm;
    }

    /**
     * For responses, this returns true if the service returned a value for the GrantTokens property. This DOES NOT
     * check that the value is non-empty (for which, you should check the {@code isEmpty()} method on the property).
     * This is useful because the SDK will never return a null collection or map, but you may need to differentiate
     * between the service returning nothing (or null) and the service returning an empty collection or map. For
     * requests, this returns true if a value for the property was specified in the request builder, and false if a
     * value was not specified.
     */
    public final boolean hasGrantTokens() {
        return grantTokens != null && !(grantTokens instanceof SdkAutoConstructList);
    }

    /**
     * <p>
     * A list of grant tokens.
     * </p>
     * <p>
     * Use a grant token when your permission to call this operation comes from a new grant that has not yet achieved
     * <i>eventual consistency</i>. For more information, see <a
     * href="https://docs.aws.amazon.com/kms/latest/developerguide/grants.html#grant_token">Grant token</a> and <a
     * href="https://docs.aws.amazon.com/kms/latest/developerguide/grant-manage.html#using-grant-token">Using a grant
     * token</a> in the <i>Key Management Service Developer Guide</i>.
     * </p>
     * <p>
     * Attempts to modify the collection returned by this method will result in an UnsupportedOperationException.
     * </p>
     * <p>
     * This method will never return null. If you would like to know whether the service returned this field (so that
     * you can differentiate between null and empty), you can use the {@link #hasGrantTokens} method.
     * </p>
     * 
     * @return A list of grant tokens.</p>
     *         <p>
     *         Use a grant token when your permission to call this operation comes from a new grant that has not yet
     *         achieved <i>eventual consistency</i>. For more information, see <a
     *         href="https://docs.aws.amazon.com/kms/latest/developerguide/grants.html#grant_token">Grant token</a> and
     *         <a href="https://docs.aws.amazon.com/kms/latest/developerguide/grant-manage.html#using-grant-token">Using
     *         a grant token</a> in the <i>Key Management Service Developer Guide</i>.
     */
    public final List<String> grantTokens() {
        return grantTokens;
    }

    /**
     * <p>
     * Checks if your request will succeed. <code>DryRun</code> is an optional parameter.
     * </p>
     * <p>
     * To learn more about how to use this parameter, see <a
     * href="https://docs.aws.amazon.com/kms/latest/developerguide/programming-dryrun.html">Testing your KMS API
     * calls</a> in the <i>Key Management Service Developer Guide</i>.
     * </p>
     * 
     * @return Checks if your request will succeed. <code>DryRun</code> is an optional parameter. </p>
     *         <p>
     *         To learn more about how to use this parameter, see <a
     *         href="https://docs.aws.amazon.com/kms/latest/developerguide/programming-dryrun.html">Testing your KMS API
     *         calls</a> in the <i>Key Management Service Developer Guide</i>.
     */
    public final Boolean dryRun() {
        return dryRun;
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
        hashCode = 31 * hashCode + Objects.hashCode(ciphertextBlob());
        hashCode = 31 * hashCode + Objects.hashCode(hasSourceEncryptionContext() ? sourceEncryptionContext() : null);
        hashCode = 31 * hashCode + Objects.hashCode(sourceKeyId());
        hashCode = 31 * hashCode + Objects.hashCode(destinationKeyId());
        hashCode = 31 * hashCode + Objects.hashCode(hasDestinationEncryptionContext() ? destinationEncryptionContext() : null);
        hashCode = 31 * hashCode + Objects.hashCode(sourceEncryptionAlgorithmAsString());
        hashCode = 31 * hashCode + Objects.hashCode(destinationEncryptionAlgorithmAsString());
        hashCode = 31 * hashCode + Objects.hashCode(hasGrantTokens() ? grantTokens() : null);
        hashCode = 31 * hashCode + Objects.hashCode(dryRun());
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
        if (!(obj instanceof ReEncryptRequest)) {
            return false;
        }
        ReEncryptRequest other = (ReEncryptRequest) obj;
        return Objects.equals(ciphertextBlob(), other.ciphertextBlob())
                && hasSourceEncryptionContext() == other.hasSourceEncryptionContext()
                && Objects.equals(sourceEncryptionContext(), other.sourceEncryptionContext())
                && Objects.equals(sourceKeyId(), other.sourceKeyId())
                && Objects.equals(destinationKeyId(), other.destinationKeyId())
                && hasDestinationEncryptionContext() == other.hasDestinationEncryptionContext()
                && Objects.equals(destinationEncryptionContext(), other.destinationEncryptionContext())
                && Objects.equals(sourceEncryptionAlgorithmAsString(), other.sourceEncryptionAlgorithmAsString())
                && Objects.equals(destinationEncryptionAlgorithmAsString(), other.destinationEncryptionAlgorithmAsString())
                && hasGrantTokens() == other.hasGrantTokens() && Objects.equals(grantTokens(), other.grantTokens())
                && Objects.equals(dryRun(), other.dryRun());
    }

    /**
     * Returns a string representation of this object. This is useful for testing and debugging. Sensitive data will be
     * redacted from this string using a placeholder value.
     */
    @Override
    public final String toString() {
        return ToString.builder("ReEncryptRequest").add("CiphertextBlob", ciphertextBlob())
                .add("SourceEncryptionContext", hasSourceEncryptionContext() ? sourceEncryptionContext() : null)
                .add("SourceKeyId", sourceKeyId()).add("DestinationKeyId", destinationKeyId())
                .add("DestinationEncryptionContext", hasDestinationEncryptionContext() ? destinationEncryptionContext() : null)
                .add("SourceEncryptionAlgorithm", sourceEncryptionAlgorithmAsString())
                .add("DestinationEncryptionAlgorithm", destinationEncryptionAlgorithmAsString())
                .add("GrantTokens", hasGrantTokens() ? grantTokens() : null).add("DryRun", dryRun()).build();
    }

    public final <T> Optional<T> getValueForField(String fieldName, Class<T> clazz) {
        switch (fieldName) {
        case "CiphertextBlob":
            return Optional.ofNullable(clazz.cast(ciphertextBlob()));
        case "SourceEncryptionContext":
            return Optional.ofNullable(clazz.cast(sourceEncryptionContext()));
        case "SourceKeyId":
            return Optional.ofNullable(clazz.cast(sourceKeyId()));
        case "DestinationKeyId":
            return Optional.ofNullable(clazz.cast(destinationKeyId()));
        case "DestinationEncryptionContext":
            return Optional.ofNullable(clazz.cast(destinationEncryptionContext()));
        case "SourceEncryptionAlgorithm":
            return Optional.ofNullable(clazz.cast(sourceEncryptionAlgorithmAsString()));
        case "DestinationEncryptionAlgorithm":
            return Optional.ofNullable(clazz.cast(destinationEncryptionAlgorithmAsString()));
        case "GrantTokens":
            return Optional.ofNullable(clazz.cast(grantTokens()));
        case "DryRun":
            return Optional.ofNullable(clazz.cast(dryRun()));
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
        map.put("CiphertextBlob", CIPHERTEXT_BLOB_FIELD);
        map.put("SourceEncryptionContext", SOURCE_ENCRYPTION_CONTEXT_FIELD);
        map.put("SourceKeyId", SOURCE_KEY_ID_FIELD);
        map.put("DestinationKeyId", DESTINATION_KEY_ID_FIELD);
        map.put("DestinationEncryptionContext", DESTINATION_ENCRYPTION_CONTEXT_FIELD);
        map.put("SourceEncryptionAlgorithm", SOURCE_ENCRYPTION_ALGORITHM_FIELD);
        map.put("DestinationEncryptionAlgorithm", DESTINATION_ENCRYPTION_ALGORITHM_FIELD);
        map.put("GrantTokens", GRANT_TOKENS_FIELD);
        map.put("DryRun", DRY_RUN_FIELD);
        return Collections.unmodifiableMap(map);
    }

    private static <T> Function<Object, T> getter(Function<ReEncryptRequest, T> g) {
        return obj -> g.apply((ReEncryptRequest) obj);
    }

    private static <T> BiConsumer<Object, T> setter(BiConsumer<Builder, T> s) {
        return (obj, val) -> s.accept((Builder) obj, val);
    }

    @Mutable
    @NotThreadSafe
    public interface Builder extends KmsRequest.Builder, SdkPojo, CopyableBuilder<Builder, ReEncryptRequest> {
        /**
         * <p>
         * Ciphertext of the data to reencrypt.
         * </p>
         * 
         * @param ciphertextBlob
         *        Ciphertext of the data to reencrypt.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder ciphertextBlob(SdkBytes ciphertextBlob);

        /**
         * <p>
         * Specifies the encryption context to use to decrypt the ciphertext. Enter the same encryption context that was
         * used to encrypt the ciphertext.
         * </p>
         * <p>
         * An <i>encryption context</i> is a collection of non-secret key-value pairs that represent additional
         * authenticated data. When you use an encryption context to encrypt data, you must specify the same (an exact
         * case-sensitive match) encryption context to decrypt the data. An encryption context is supported only on
         * operations with symmetric encryption KMS keys. On operations with symmetric encryption KMS keys, an
         * encryption context is optional, but it is strongly recommended.
         * </p>
         * <p>
         * For more information, see <a
         * href="https://docs.aws.amazon.com/kms/latest/developerguide/concepts.html#encrypt_context">Encryption
         * context</a> in the <i>Key Management Service Developer Guide</i>.
         * </p>
         * 
         * @param sourceEncryptionContext
         *        Specifies the encryption context to use to decrypt the ciphertext. Enter the same encryption context
         *        that was used to encrypt the ciphertext.</p>
         *        <p>
         *        An <i>encryption context</i> is a collection of non-secret key-value pairs that represent additional
         *        authenticated data. When you use an encryption context to encrypt data, you must specify the same (an
         *        exact case-sensitive match) encryption context to decrypt the data. An encryption context is supported
         *        only on operations with symmetric encryption KMS keys. On operations with symmetric encryption KMS
         *        keys, an encryption context is optional, but it is strongly recommended.
         *        </p>
         *        <p>
         *        For more information, see <a
         *        href="https://docs.aws.amazon.com/kms/latest/developerguide/concepts.html#encrypt_context">Encryption
         *        context</a> in the <i>Key Management Service Developer Guide</i>.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder sourceEncryptionContext(Map<String, String> sourceEncryptionContext);

        /**
         * <p>
         * Specifies the KMS key that KMS will use to decrypt the ciphertext before it is re-encrypted.
         * </p>
         * <p>
         * Enter a key ID of the KMS key that was used to encrypt the ciphertext. If you identify a different KMS key,
         * the <code>ReEncrypt</code> operation throws an <code>IncorrectKeyException</code>.
         * </p>
         * <p>
         * This parameter is required only when the ciphertext was encrypted under an asymmetric KMS key. If you used a
         * symmetric encryption KMS key, KMS can get the KMS key from metadata that it adds to the symmetric ciphertext
         * blob. However, it is always recommended as a best practice. This practice ensures that you use the KMS key
         * that you intend.
         * </p>
         * <p>
         * To specify a KMS key, use its key ID, key ARN, alias name, or alias ARN. When using an alias name, prefix it
         * with <code>"alias/"</code>. To specify a KMS key in a different Amazon Web Services account, you must use the
         * key ARN or alias ARN.
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
         * <li>
         * <p>
         * Alias name: <code>alias/ExampleAlias</code>
         * </p>
         * </li>
         * <li>
         * <p>
         * Alias ARN: <code>arn:aws:kms:us-east-2:111122223333:alias/ExampleAlias</code>
         * </p>
         * </li>
         * </ul>
         * <p>
         * To get the key ID and key ARN for a KMS key, use <a>ListKeys</a> or <a>DescribeKey</a>. To get the alias name
         * and alias ARN, use <a>ListAliases</a>.
         * </p>
         * 
         * @param sourceKeyId
         *        Specifies the KMS key that KMS will use to decrypt the ciphertext before it is re-encrypted.</p>
         *        <p>
         *        Enter a key ID of the KMS key that was used to encrypt the ciphertext. If you identify a different KMS
         *        key, the <code>ReEncrypt</code> operation throws an <code>IncorrectKeyException</code>.
         *        </p>
         *        <p>
         *        This parameter is required only when the ciphertext was encrypted under an asymmetric KMS key. If you
         *        used a symmetric encryption KMS key, KMS can get the KMS key from metadata that it adds to the
         *        symmetric ciphertext blob. However, it is always recommended as a best practice. This practice ensures
         *        that you use the KMS key that you intend.
         *        </p>
         *        <p>
         *        To specify a KMS key, use its key ID, key ARN, alias name, or alias ARN. When using an alias name,
         *        prefix it with <code>"alias/"</code>. To specify a KMS key in a different Amazon Web Services account,
         *        you must use the key ARN or alias ARN.
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
         *        <li>
         *        <p>
         *        Alias name: <code>alias/ExampleAlias</code>
         *        </p>
         *        </li>
         *        <li>
         *        <p>
         *        Alias ARN: <code>arn:aws:kms:us-east-2:111122223333:alias/ExampleAlias</code>
         *        </p>
         *        </li>
         *        </ul>
         *        <p>
         *        To get the key ID and key ARN for a KMS key, use <a>ListKeys</a> or <a>DescribeKey</a>. To get the
         *        alias name and alias ARN, use <a>ListAliases</a>.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder sourceKeyId(String sourceKeyId);

        /**
         * <p>
         * A unique identifier for the KMS key that is used to reencrypt the data. Specify a symmetric encryption KMS
         * key or an asymmetric KMS key with a <code>KeyUsage</code> value of <code>ENCRYPT_DECRYPT</code>. To find the
         * <code>KeyUsage</code> value of a KMS key, use the <a>DescribeKey</a> operation.
         * </p>
         * <p>
         * To specify a KMS key, use its key ID, key ARN, alias name, or alias ARN. When using an alias name, prefix it
         * with <code>"alias/"</code>. To specify a KMS key in a different Amazon Web Services account, you must use the
         * key ARN or alias ARN.
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
         * <li>
         * <p>
         * Alias name: <code>alias/ExampleAlias</code>
         * </p>
         * </li>
         * <li>
         * <p>
         * Alias ARN: <code>arn:aws:kms:us-east-2:111122223333:alias/ExampleAlias</code>
         * </p>
         * </li>
         * </ul>
         * <p>
         * To get the key ID and key ARN for a KMS key, use <a>ListKeys</a> or <a>DescribeKey</a>. To get the alias name
         * and alias ARN, use <a>ListAliases</a>.
         * </p>
         * 
         * @param destinationKeyId
         *        A unique identifier for the KMS key that is used to reencrypt the data. Specify a symmetric encryption
         *        KMS key or an asymmetric KMS key with a <code>KeyUsage</code> value of <code>ENCRYPT_DECRYPT</code>.
         *        To find the <code>KeyUsage</code> value of a KMS key, use the <a>DescribeKey</a> operation.</p>
         *        <p>
         *        To specify a KMS key, use its key ID, key ARN, alias name, or alias ARN. When using an alias name,
         *        prefix it with <code>"alias/"</code>. To specify a KMS key in a different Amazon Web Services account,
         *        you must use the key ARN or alias ARN.
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
         *        <li>
         *        <p>
         *        Alias name: <code>alias/ExampleAlias</code>
         *        </p>
         *        </li>
         *        <li>
         *        <p>
         *        Alias ARN: <code>arn:aws:kms:us-east-2:111122223333:alias/ExampleAlias</code>
         *        </p>
         *        </li>
         *        </ul>
         *        <p>
         *        To get the key ID and key ARN for a KMS key, use <a>ListKeys</a> or <a>DescribeKey</a>. To get the
         *        alias name and alias ARN, use <a>ListAliases</a>.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder destinationKeyId(String destinationKeyId);

        /**
         * <p>
         * Specifies that encryption context to use when the reencrypting the data.
         * </p>
         * <important>
         * <p>
         * Do not include confidential or sensitive information in this field. This field may be displayed in plaintext
         * in CloudTrail logs and other output.
         * </p>
         * </important>
         * <p>
         * A destination encryption context is valid only when the destination KMS key is a symmetric encryption KMS
         * key. The standard ciphertext format for asymmetric KMS keys does not include fields for metadata.
         * </p>
         * <p>
         * An <i>encryption context</i> is a collection of non-secret key-value pairs that represent additional
         * authenticated data. When you use an encryption context to encrypt data, you must specify the same (an exact
         * case-sensitive match) encryption context to decrypt the data. An encryption context is supported only on
         * operations with symmetric encryption KMS keys. On operations with symmetric encryption KMS keys, an
         * encryption context is optional, but it is strongly recommended.
         * </p>
         * <p>
         * For more information, see <a
         * href="https://docs.aws.amazon.com/kms/latest/developerguide/concepts.html#encrypt_context">Encryption
         * context</a> in the <i>Key Management Service Developer Guide</i>.
         * </p>
         * 
         * @param destinationEncryptionContext
         *        Specifies that encryption context to use when the reencrypting the data.</p> <important>
         *        <p>
         *        Do not include confidential or sensitive information in this field. This field may be displayed in
         *        plaintext in CloudTrail logs and other output.
         *        </p>
         *        </important>
         *        <p>
         *        A destination encryption context is valid only when the destination KMS key is a symmetric encryption
         *        KMS key. The standard ciphertext format for asymmetric KMS keys does not include fields for metadata.
         *        </p>
         *        <p>
         *        An <i>encryption context</i> is a collection of non-secret key-value pairs that represent additional
         *        authenticated data. When you use an encryption context to encrypt data, you must specify the same (an
         *        exact case-sensitive match) encryption context to decrypt the data. An encryption context is supported
         *        only on operations with symmetric encryption KMS keys. On operations with symmetric encryption KMS
         *        keys, an encryption context is optional, but it is strongly recommended.
         *        </p>
         *        <p>
         *        For more information, see <a
         *        href="https://docs.aws.amazon.com/kms/latest/developerguide/concepts.html#encrypt_context">Encryption
         *        context</a> in the <i>Key Management Service Developer Guide</i>.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder destinationEncryptionContext(Map<String, String> destinationEncryptionContext);

        /**
         * <p>
         * Specifies the encryption algorithm that KMS will use to decrypt the ciphertext before it is reencrypted. The
         * default value, <code>SYMMETRIC_DEFAULT</code>, represents the algorithm used for symmetric encryption KMS
         * keys.
         * </p>
         * <p>
         * Specify the same algorithm that was used to encrypt the ciphertext. If you specify a different algorithm, the
         * decrypt attempt fails.
         * </p>
         * <p>
         * This parameter is required only when the ciphertext was encrypted under an asymmetric KMS key.
         * </p>
         * 
         * @param sourceEncryptionAlgorithm
         *        Specifies the encryption algorithm that KMS will use to decrypt the ciphertext before it is
         *        reencrypted. The default value, <code>SYMMETRIC_DEFAULT</code>, represents the algorithm used for
         *        symmetric encryption KMS keys.</p>
         *        <p>
         *        Specify the same algorithm that was used to encrypt the ciphertext. If you specify a different
         *        algorithm, the decrypt attempt fails.
         *        </p>
         *        <p>
         *        This parameter is required only when the ciphertext was encrypted under an asymmetric KMS key.
         * @see EncryptionAlgorithmSpec
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see EncryptionAlgorithmSpec
         */
        Builder sourceEncryptionAlgorithm(String sourceEncryptionAlgorithm);

        /**
         * <p>
         * Specifies the encryption algorithm that KMS will use to decrypt the ciphertext before it is reencrypted. The
         * default value, <code>SYMMETRIC_DEFAULT</code>, represents the algorithm used for symmetric encryption KMS
         * keys.
         * </p>
         * <p>
         * Specify the same algorithm that was used to encrypt the ciphertext. If you specify a different algorithm, the
         * decrypt attempt fails.
         * </p>
         * <p>
         * This parameter is required only when the ciphertext was encrypted under an asymmetric KMS key.
         * </p>
         * 
         * @param sourceEncryptionAlgorithm
         *        Specifies the encryption algorithm that KMS will use to decrypt the ciphertext before it is
         *        reencrypted. The default value, <code>SYMMETRIC_DEFAULT</code>, represents the algorithm used for
         *        symmetric encryption KMS keys.</p>
         *        <p>
         *        Specify the same algorithm that was used to encrypt the ciphertext. If you specify a different
         *        algorithm, the decrypt attempt fails.
         *        </p>
         *        <p>
         *        This parameter is required only when the ciphertext was encrypted under an asymmetric KMS key.
         * @see EncryptionAlgorithmSpec
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see EncryptionAlgorithmSpec
         */
        Builder sourceEncryptionAlgorithm(EncryptionAlgorithmSpec sourceEncryptionAlgorithm);

        /**
         * <p>
         * Specifies the encryption algorithm that KMS will use to reecrypt the data after it has decrypted it. The
         * default value, <code>SYMMETRIC_DEFAULT</code>, represents the encryption algorithm used for symmetric
         * encryption KMS keys.
         * </p>
         * <p>
         * This parameter is required only when the destination KMS key is an asymmetric KMS key.
         * </p>
         * 
         * @param destinationEncryptionAlgorithm
         *        Specifies the encryption algorithm that KMS will use to reecrypt the data after it has decrypted it.
         *        The default value, <code>SYMMETRIC_DEFAULT</code>, represents the encryption algorithm used for
         *        symmetric encryption KMS keys.</p>
         *        <p>
         *        This parameter is required only when the destination KMS key is an asymmetric KMS key.
         * @see EncryptionAlgorithmSpec
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see EncryptionAlgorithmSpec
         */
        Builder destinationEncryptionAlgorithm(String destinationEncryptionAlgorithm);

        /**
         * <p>
         * Specifies the encryption algorithm that KMS will use to reecrypt the data after it has decrypted it. The
         * default value, <code>SYMMETRIC_DEFAULT</code>, represents the encryption algorithm used for symmetric
         * encryption KMS keys.
         * </p>
         * <p>
         * This parameter is required only when the destination KMS key is an asymmetric KMS key.
         * </p>
         * 
         * @param destinationEncryptionAlgorithm
         *        Specifies the encryption algorithm that KMS will use to reecrypt the data after it has decrypted it.
         *        The default value, <code>SYMMETRIC_DEFAULT</code>, represents the encryption algorithm used for
         *        symmetric encryption KMS keys.</p>
         *        <p>
         *        This parameter is required only when the destination KMS key is an asymmetric KMS key.
         * @see EncryptionAlgorithmSpec
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see EncryptionAlgorithmSpec
         */
        Builder destinationEncryptionAlgorithm(EncryptionAlgorithmSpec destinationEncryptionAlgorithm);

        /**
         * <p>
         * A list of grant tokens.
         * </p>
         * <p>
         * Use a grant token when your permission to call this operation comes from a new grant that has not yet
         * achieved <i>eventual consistency</i>. For more information, see <a
         * href="https://docs.aws.amazon.com/kms/latest/developerguide/grants.html#grant_token">Grant token</a> and <a
         * href="https://docs.aws.amazon.com/kms/latest/developerguide/grant-manage.html#using-grant-token">Using a
         * grant token</a> in the <i>Key Management Service Developer Guide</i>.
         * </p>
         * 
         * @param grantTokens
         *        A list of grant tokens.</p>
         *        <p>
         *        Use a grant token when your permission to call this operation comes from a new grant that has not yet
         *        achieved <i>eventual consistency</i>. For more information, see <a
         *        href="https://docs.aws.amazon.com/kms/latest/developerguide/grants.html#grant_token">Grant token</a>
         *        and <a
         *        href="https://docs.aws.amazon.com/kms/latest/developerguide/grant-manage.html#using-grant-token">Using
         *        a grant token</a> in the <i>Key Management Service Developer Guide</i>.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder grantTokens(Collection<String> grantTokens);

        /**
         * <p>
         * A list of grant tokens.
         * </p>
         * <p>
         * Use a grant token when your permission to call this operation comes from a new grant that has not yet
         * achieved <i>eventual consistency</i>. For more information, see <a
         * href="https://docs.aws.amazon.com/kms/latest/developerguide/grants.html#grant_token">Grant token</a> and <a
         * href="https://docs.aws.amazon.com/kms/latest/developerguide/grant-manage.html#using-grant-token">Using a
         * grant token</a> in the <i>Key Management Service Developer Guide</i>.
         * </p>
         * 
         * @param grantTokens
         *        A list of grant tokens.</p>
         *        <p>
         *        Use a grant token when your permission to call this operation comes from a new grant that has not yet
         *        achieved <i>eventual consistency</i>. For more information, see <a
         *        href="https://docs.aws.amazon.com/kms/latest/developerguide/grants.html#grant_token">Grant token</a>
         *        and <a
         *        href="https://docs.aws.amazon.com/kms/latest/developerguide/grant-manage.html#using-grant-token">Using
         *        a grant token</a> in the <i>Key Management Service Developer Guide</i>.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder grantTokens(String... grantTokens);

        /**
         * <p>
         * Checks if your request will succeed. <code>DryRun</code> is an optional parameter.
         * </p>
         * <p>
         * To learn more about how to use this parameter, see <a
         * href="https://docs.aws.amazon.com/kms/latest/developerguide/programming-dryrun.html">Testing your KMS API
         * calls</a> in the <i>Key Management Service Developer Guide</i>.
         * </p>
         * 
         * @param dryRun
         *        Checks if your request will succeed. <code>DryRun</code> is an optional parameter. </p>
         *        <p>
         *        To learn more about how to use this parameter, see <a
         *        href="https://docs.aws.amazon.com/kms/latest/developerguide/programming-dryrun.html">Testing your KMS
         *        API calls</a> in the <i>Key Management Service Developer Guide</i>.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder dryRun(Boolean dryRun);

        @Override
        Builder overrideConfiguration(AwsRequestOverrideConfiguration overrideConfiguration);

        @Override
        Builder overrideConfiguration(Consumer<AwsRequestOverrideConfiguration.Builder> builderConsumer);
    }

    static final class BuilderImpl extends KmsRequest.BuilderImpl implements Builder {
        private SdkBytes ciphertextBlob;

        private Map<String, String> sourceEncryptionContext = DefaultSdkAutoConstructMap.getInstance();

        private String sourceKeyId;

        private String destinationKeyId;

        private Map<String, String> destinationEncryptionContext = DefaultSdkAutoConstructMap.getInstance();

        private String sourceEncryptionAlgorithm;

        private String destinationEncryptionAlgorithm;

        private List<String> grantTokens = DefaultSdkAutoConstructList.getInstance();

        private Boolean dryRun;

        private BuilderImpl() {
        }

        private BuilderImpl(ReEncryptRequest model) {
            super(model);
            ciphertextBlob(model.ciphertextBlob);
            sourceEncryptionContext(model.sourceEncryptionContext);
            sourceKeyId(model.sourceKeyId);
            destinationKeyId(model.destinationKeyId);
            destinationEncryptionContext(model.destinationEncryptionContext);
            sourceEncryptionAlgorithm(model.sourceEncryptionAlgorithm);
            destinationEncryptionAlgorithm(model.destinationEncryptionAlgorithm);
            grantTokens(model.grantTokens);
            dryRun(model.dryRun);
        }

        public final ByteBuffer getCiphertextBlob() {
            return ciphertextBlob == null ? null : ciphertextBlob.asByteBuffer();
        }

        public final void setCiphertextBlob(ByteBuffer ciphertextBlob) {
            ciphertextBlob(ciphertextBlob == null ? null : SdkBytes.fromByteBuffer(ciphertextBlob));
        }

        @Override
        public final Builder ciphertextBlob(SdkBytes ciphertextBlob) {
            this.ciphertextBlob = ciphertextBlob;
            return this;
        }

        public final Map<String, String> getSourceEncryptionContext() {
            if (sourceEncryptionContext instanceof SdkAutoConstructMap) {
                return null;
            }
            return sourceEncryptionContext;
        }

        public final void setSourceEncryptionContext(Map<String, String> sourceEncryptionContext) {
            this.sourceEncryptionContext = EncryptionContextTypeCopier.copy(sourceEncryptionContext);
        }

        @Override
        public final Builder sourceEncryptionContext(Map<String, String> sourceEncryptionContext) {
            this.sourceEncryptionContext = EncryptionContextTypeCopier.copy(sourceEncryptionContext);
            return this;
        }

        public final String getSourceKeyId() {
            return sourceKeyId;
        }

        public final void setSourceKeyId(String sourceKeyId) {
            this.sourceKeyId = sourceKeyId;
        }

        @Override
        public final Builder sourceKeyId(String sourceKeyId) {
            this.sourceKeyId = sourceKeyId;
            return this;
        }

        public final String getDestinationKeyId() {
            return destinationKeyId;
        }

        public final void setDestinationKeyId(String destinationKeyId) {
            this.destinationKeyId = destinationKeyId;
        }

        @Override
        public final Builder destinationKeyId(String destinationKeyId) {
            this.destinationKeyId = destinationKeyId;
            return this;
        }

        public final Map<String, String> getDestinationEncryptionContext() {
            if (destinationEncryptionContext instanceof SdkAutoConstructMap) {
                return null;
            }
            return destinationEncryptionContext;
        }

        public final void setDestinationEncryptionContext(Map<String, String> destinationEncryptionContext) {
            this.destinationEncryptionContext = EncryptionContextTypeCopier.copy(destinationEncryptionContext);
        }

        @Override
        public final Builder destinationEncryptionContext(Map<String, String> destinationEncryptionContext) {
            this.destinationEncryptionContext = EncryptionContextTypeCopier.copy(destinationEncryptionContext);
            return this;
        }

        public final String getSourceEncryptionAlgorithm() {
            return sourceEncryptionAlgorithm;
        }

        public final void setSourceEncryptionAlgorithm(String sourceEncryptionAlgorithm) {
            this.sourceEncryptionAlgorithm = sourceEncryptionAlgorithm;
        }

        @Override
        public final Builder sourceEncryptionAlgorithm(String sourceEncryptionAlgorithm) {
            this.sourceEncryptionAlgorithm = sourceEncryptionAlgorithm;
            return this;
        }

        @Override
        public final Builder sourceEncryptionAlgorithm(EncryptionAlgorithmSpec sourceEncryptionAlgorithm) {
            this.sourceEncryptionAlgorithm(sourceEncryptionAlgorithm == null ? null : sourceEncryptionAlgorithm.toString());
            return this;
        }

        public final String getDestinationEncryptionAlgorithm() {
            return destinationEncryptionAlgorithm;
        }

        public final void setDestinationEncryptionAlgorithm(String destinationEncryptionAlgorithm) {
            this.destinationEncryptionAlgorithm = destinationEncryptionAlgorithm;
        }

        @Override
        public final Builder destinationEncryptionAlgorithm(String destinationEncryptionAlgorithm) {
            this.destinationEncryptionAlgorithm = destinationEncryptionAlgorithm;
            return this;
        }

        @Override
        public final Builder destinationEncryptionAlgorithm(EncryptionAlgorithmSpec destinationEncryptionAlgorithm) {
            this.destinationEncryptionAlgorithm(destinationEncryptionAlgorithm == null ? null : destinationEncryptionAlgorithm
                    .toString());
            return this;
        }

        public final Collection<String> getGrantTokens() {
            if (grantTokens instanceof SdkAutoConstructList) {
                return null;
            }
            return grantTokens;
        }

        public final void setGrantTokens(Collection<String> grantTokens) {
            this.grantTokens = GrantTokenListCopier.copy(grantTokens);
        }

        @Override
        public final Builder grantTokens(Collection<String> grantTokens) {
            this.grantTokens = GrantTokenListCopier.copy(grantTokens);
            return this;
        }

        @Override
        @SafeVarargs
        public final Builder grantTokens(String... grantTokens) {
            grantTokens(Arrays.asList(grantTokens));
            return this;
        }

        public final Boolean getDryRun() {
            return dryRun;
        }

        public final void setDryRun(Boolean dryRun) {
            this.dryRun = dryRun;
        }

        @Override
        public final Builder dryRun(Boolean dryRun) {
            this.dryRun = dryRun;
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
        public ReEncryptRequest build() {
            return new ReEncryptRequest(this);
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
