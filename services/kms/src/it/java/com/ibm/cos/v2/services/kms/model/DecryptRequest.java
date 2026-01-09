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
public final class DecryptRequest extends KmsRequest implements ToCopyableBuilder<DecryptRequest.Builder, DecryptRequest> {
    private static final SdkField<SdkBytes> CIPHERTEXT_BLOB_FIELD = SdkField.<SdkBytes> builder(MarshallingType.SDK_BYTES)
            .memberName("CiphertextBlob").getter(getter(DecryptRequest::ciphertextBlob)).setter(setter(Builder::ciphertextBlob))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("CiphertextBlob").build()).build();

    private static final SdkField<Map<String, String>> ENCRYPTION_CONTEXT_FIELD = SdkField
            .<Map<String, String>> builder(MarshallingType.MAP)
            .memberName("EncryptionContext")
            .getter(getter(DecryptRequest::encryptionContext))
            .setter(setter(Builder::encryptionContext))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("EncryptionContext").build(),
                    MapTrait.builder()
                            .keyLocationName("key")
                            .valueLocationName("value")
                            .valueFieldInfo(
                                    SdkField.<String> builder(MarshallingType.STRING)
                                            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD)
                                                    .locationName("value").build()).build()).build()).build();

    private static final SdkField<List<String>> GRANT_TOKENS_FIELD = SdkField
            .<List<String>> builder(MarshallingType.LIST)
            .memberName("GrantTokens")
            .getter(getter(DecryptRequest::grantTokens))
            .setter(setter(Builder::grantTokens))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("GrantTokens").build(),
                    ListTrait
                            .builder()
                            .memberLocationName(null)
                            .memberFieldInfo(
                                    SdkField.<String> builder(MarshallingType.STRING)
                                            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD)
                                                    .locationName("member").build()).build()).build()).build();

    private static final SdkField<String> KEY_ID_FIELD = SdkField.<String> builder(MarshallingType.STRING).memberName("KeyId")
            .getter(getter(DecryptRequest::keyId)).setter(setter(Builder::keyId))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("KeyId").build()).build();

    private static final SdkField<String> ENCRYPTION_ALGORITHM_FIELD = SdkField.<String> builder(MarshallingType.STRING)
            .memberName("EncryptionAlgorithm").getter(getter(DecryptRequest::encryptionAlgorithmAsString))
            .setter(setter(Builder::encryptionAlgorithm))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("EncryptionAlgorithm").build())
            .build();

    private static final SdkField<RecipientInfo> RECIPIENT_FIELD = SdkField.<RecipientInfo> builder(MarshallingType.SDK_POJO)
            .memberName("Recipient").getter(getter(DecryptRequest::recipient)).setter(setter(Builder::recipient))
            .constructor(RecipientInfo::builder)
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("Recipient").build()).build();

    private static final SdkField<Boolean> DRY_RUN_FIELD = SdkField.<Boolean> builder(MarshallingType.BOOLEAN)
            .memberName("DryRun").getter(getter(DecryptRequest::dryRun)).setter(setter(Builder::dryRun))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("DryRun").build()).build();

    private static final List<SdkField<?>> SDK_FIELDS = Collections.unmodifiableList(Arrays.asList(CIPHERTEXT_BLOB_FIELD,
            ENCRYPTION_CONTEXT_FIELD, GRANT_TOKENS_FIELD, KEY_ID_FIELD, ENCRYPTION_ALGORITHM_FIELD, RECIPIENT_FIELD,
            DRY_RUN_FIELD));

    private static final Map<String, SdkField<?>> SDK_NAME_TO_FIELD = memberNameToFieldInitializer();

    private final SdkBytes ciphertextBlob;

    private final Map<String, String> encryptionContext;

    private final List<String> grantTokens;

    private final String keyId;

    private final String encryptionAlgorithm;

    private final RecipientInfo recipient;

    private final Boolean dryRun;

    private DecryptRequest(BuilderImpl builder) {
        super(builder);
        this.ciphertextBlob = builder.ciphertextBlob;
        this.encryptionContext = builder.encryptionContext;
        this.grantTokens = builder.grantTokens;
        this.keyId = builder.keyId;
        this.encryptionAlgorithm = builder.encryptionAlgorithm;
        this.recipient = builder.recipient;
        this.dryRun = builder.dryRun;
    }

    /**
     * <p>
     * Ciphertext to be decrypted. The blob includes metadata.
     * </p>
     * 
     * @return Ciphertext to be decrypted. The blob includes metadata.
     */
    public final SdkBytes ciphertextBlob() {
        return ciphertextBlob;
    }

    /**
     * For responses, this returns true if the service returned a value for the EncryptionContext property. This DOES
     * NOT check that the value is non-empty (for which, you should check the {@code isEmpty()} method on the property).
     * This is useful because the SDK will never return a null collection or map, but you may need to differentiate
     * between the service returning nothing (or null) and the service returning an empty collection or map. For
     * requests, this returns true if a value for the property was specified in the request builder, and false if a
     * value was not specified.
     */
    public final boolean hasEncryptionContext() {
        return encryptionContext != null && !(encryptionContext instanceof SdkAutoConstructMap);
    }

    /**
     * <p>
     * Specifies the encryption context to use when decrypting the data. An encryption context is valid only for <a
     * href="https://docs.aws.amazon.com/kms/latest/developerguide/concepts.html#cryptographic-operations">cryptographic
     * operations</a> with a symmetric encryption KMS key. The standard asymmetric encryption algorithms and HMAC
     * algorithms that KMS uses do not support an encryption context.
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
     * you can differentiate between null and empty), you can use the {@link #hasEncryptionContext} method.
     * </p>
     * 
     * @return Specifies the encryption context to use when decrypting the data. An encryption context is valid only for
     *         <a href="https://docs.aws.amazon.com/kms/latest/developerguide/concepts.html#cryptographic-operations">
     *         cryptographic operations</a> with a symmetric encryption KMS key. The standard asymmetric encryption
     *         algorithms and HMAC algorithms that KMS uses do not support an encryption context.</p>
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
    public final Map<String, String> encryptionContext() {
        return encryptionContext;
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
     * @return A list of grant tokens. </p>
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
     * Specifies the KMS key that KMS uses to decrypt the ciphertext.
     * </p>
     * <p>
     * Enter a key ID of the KMS key that was used to encrypt the ciphertext. If you identify a different KMS key, the
     * <code>Decrypt</code> operation throws an <code>IncorrectKeyException</code>.
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
     * @return Specifies the KMS key that KMS uses to decrypt the ciphertext.</p>
     *         <p>
     *         Enter a key ID of the KMS key that was used to encrypt the ciphertext. If you identify a different KMS
     *         key, the <code>Decrypt</code> operation throws an <code>IncorrectKeyException</code>.
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
    public final String keyId() {
        return keyId;
    }

    /**
     * <p>
     * Specifies the encryption algorithm that will be used to decrypt the ciphertext. Specify the same algorithm that
     * was used to encrypt the data. If you specify a different algorithm, the <code>Decrypt</code> operation fails.
     * </p>
     * <p>
     * This parameter is required only when the ciphertext was encrypted under an asymmetric KMS key. The default value,
     * <code>SYMMETRIC_DEFAULT</code>, represents the only supported algorithm that is valid for symmetric encryption
     * KMS keys.
     * </p>
     * <p>
     * If the service returns an enum value that is not available in the current SDK version,
     * {@link #encryptionAlgorithm} will return {@link EncryptionAlgorithmSpec#UNKNOWN_TO_SDK_VERSION}. The raw value
     * returned by the service is available from {@link #encryptionAlgorithmAsString}.
     * </p>
     * 
     * @return Specifies the encryption algorithm that will be used to decrypt the ciphertext. Specify the same
     *         algorithm that was used to encrypt the data. If you specify a different algorithm, the
     *         <code>Decrypt</code> operation fails.</p>
     *         <p>
     *         This parameter is required only when the ciphertext was encrypted under an asymmetric KMS key. The
     *         default value, <code>SYMMETRIC_DEFAULT</code>, represents the only supported algorithm that is valid for
     *         symmetric encryption KMS keys.
     * @see EncryptionAlgorithmSpec
     */
    public final EncryptionAlgorithmSpec encryptionAlgorithm() {
        return EncryptionAlgorithmSpec.fromValue(encryptionAlgorithm);
    }

    /**
     * <p>
     * Specifies the encryption algorithm that will be used to decrypt the ciphertext. Specify the same algorithm that
     * was used to encrypt the data. If you specify a different algorithm, the <code>Decrypt</code> operation fails.
     * </p>
     * <p>
     * This parameter is required only when the ciphertext was encrypted under an asymmetric KMS key. The default value,
     * <code>SYMMETRIC_DEFAULT</code>, represents the only supported algorithm that is valid for symmetric encryption
     * KMS keys.
     * </p>
     * <p>
     * If the service returns an enum value that is not available in the current SDK version,
     * {@link #encryptionAlgorithm} will return {@link EncryptionAlgorithmSpec#UNKNOWN_TO_SDK_VERSION}. The raw value
     * returned by the service is available from {@link #encryptionAlgorithmAsString}.
     * </p>
     * 
     * @return Specifies the encryption algorithm that will be used to decrypt the ciphertext. Specify the same
     *         algorithm that was used to encrypt the data. If you specify a different algorithm, the
     *         <code>Decrypt</code> operation fails.</p>
     *         <p>
     *         This parameter is required only when the ciphertext was encrypted under an asymmetric KMS key. The
     *         default value, <code>SYMMETRIC_DEFAULT</code>, represents the only supported algorithm that is valid for
     *         symmetric encryption KMS keys.
     * @see EncryptionAlgorithmSpec
     */
    public final String encryptionAlgorithmAsString() {
        return encryptionAlgorithm;
    }

    /**
     * <p>
     * A signed <a
     * href="https://docs.aws.amazon.com/enclaves/latest/user/nitro-enclave-concepts.html#term-attestdoc">attestation
     * document</a> from an Amazon Web Services Nitro enclave and the encryption algorithm to use with the enclave's
     * public key. The only valid encryption algorithm is <code>RSAES_OAEP_SHA_256</code>.
     * </p>
     * <p>
     * This parameter only supports attestation documents for Amazon Web Services Nitro Enclaves. To include this
     * parameter, use the <a
     * href="https://docs.aws.amazon.com/enclaves/latest/user/developing-applications.html#sdk">Amazon Web Services
     * Nitro Enclaves SDK</a> or any Amazon Web Services SDK.
     * </p>
     * <p>
     * When you use this parameter, instead of returning the plaintext data, KMS encrypts the plaintext data with the
     * public key in the attestation document, and returns the resulting ciphertext in the
     * <code>CiphertextForRecipient</code> field in the response. This ciphertext can be decrypted only with the private
     * key in the enclave. The <code>Plaintext</code> field in the response is null or empty.
     * </p>
     * <p>
     * For information about the interaction between KMS and Amazon Web Services Nitro Enclaves, see <a
     * href="https://docs.aws.amazon.com/kms/latest/developerguide/services-nitro-enclaves.html">How Amazon Web Services
     * Nitro Enclaves uses KMS</a> in the <i>Key Management Service Developer Guide</i>.
     * </p>
     * 
     * @return A signed <a
     *         href="https://docs.aws.amazon.com/enclaves/latest/user/nitro-enclave-concepts.html#term-attestdoc"
     *         >attestation document</a> from an Amazon Web Services Nitro enclave and the encryption algorithm to use
     *         with the enclave's public key. The only valid encryption algorithm is <code>RSAES_OAEP_SHA_256</code>.
     *         </p>
     *         <p>
     *         This parameter only supports attestation documents for Amazon Web Services Nitro Enclaves. To include
     *         this parameter, use the <a
     *         href="https://docs.aws.amazon.com/enclaves/latest/user/developing-applications.html#sdk">Amazon Web
     *         Services Nitro Enclaves SDK</a> or any Amazon Web Services SDK.
     *         </p>
     *         <p>
     *         When you use this parameter, instead of returning the plaintext data, KMS encrypts the plaintext data
     *         with the public key in the attestation document, and returns the resulting ciphertext in the
     *         <code>CiphertextForRecipient</code> field in the response. This ciphertext can be decrypted only with the
     *         private key in the enclave. The <code>Plaintext</code> field in the response is null or empty.
     *         </p>
     *         <p>
     *         For information about the interaction between KMS and Amazon Web Services Nitro Enclaves, see <a
     *         href="https://docs.aws.amazon.com/kms/latest/developerguide/services-nitro-enclaves.html">How Amazon Web
     *         Services Nitro Enclaves uses KMS</a> in the <i>Key Management Service Developer Guide</i>.
     */
    public final RecipientInfo recipient() {
        return recipient;
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
        hashCode = 31 * hashCode + Objects.hashCode(hasEncryptionContext() ? encryptionContext() : null);
        hashCode = 31 * hashCode + Objects.hashCode(hasGrantTokens() ? grantTokens() : null);
        hashCode = 31 * hashCode + Objects.hashCode(keyId());
        hashCode = 31 * hashCode + Objects.hashCode(encryptionAlgorithmAsString());
        hashCode = 31 * hashCode + Objects.hashCode(recipient());
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
        if (!(obj instanceof DecryptRequest)) {
            return false;
        }
        DecryptRequest other = (DecryptRequest) obj;
        return Objects.equals(ciphertextBlob(), other.ciphertextBlob()) && hasEncryptionContext() == other.hasEncryptionContext()
                && Objects.equals(encryptionContext(), other.encryptionContext()) && hasGrantTokens() == other.hasGrantTokens()
                && Objects.equals(grantTokens(), other.grantTokens()) && Objects.equals(keyId(), other.keyId())
                && Objects.equals(encryptionAlgorithmAsString(), other.encryptionAlgorithmAsString())
                && Objects.equals(recipient(), other.recipient()) && Objects.equals(dryRun(), other.dryRun());
    }

    /**
     * Returns a string representation of this object. This is useful for testing and debugging. Sensitive data will be
     * redacted from this string using a placeholder value.
     */
    @Override
    public final String toString() {
        return ToString.builder("DecryptRequest").add("CiphertextBlob", ciphertextBlob())
                .add("EncryptionContext", hasEncryptionContext() ? encryptionContext() : null)
                .add("GrantTokens", hasGrantTokens() ? grantTokens() : null).add("KeyId", keyId())
                .add("EncryptionAlgorithm", encryptionAlgorithmAsString()).add("Recipient", recipient()).add("DryRun", dryRun())
                .build();
    }

    public final <T> Optional<T> getValueForField(String fieldName, Class<T> clazz) {
        switch (fieldName) {
        case "CiphertextBlob":
            return Optional.ofNullable(clazz.cast(ciphertextBlob()));
        case "EncryptionContext":
            return Optional.ofNullable(clazz.cast(encryptionContext()));
        case "GrantTokens":
            return Optional.ofNullable(clazz.cast(grantTokens()));
        case "KeyId":
            return Optional.ofNullable(clazz.cast(keyId()));
        case "EncryptionAlgorithm":
            return Optional.ofNullable(clazz.cast(encryptionAlgorithmAsString()));
        case "Recipient":
            return Optional.ofNullable(clazz.cast(recipient()));
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
        map.put("EncryptionContext", ENCRYPTION_CONTEXT_FIELD);
        map.put("GrantTokens", GRANT_TOKENS_FIELD);
        map.put("KeyId", KEY_ID_FIELD);
        map.put("EncryptionAlgorithm", ENCRYPTION_ALGORITHM_FIELD);
        map.put("Recipient", RECIPIENT_FIELD);
        map.put("DryRun", DRY_RUN_FIELD);
        return Collections.unmodifiableMap(map);
    }

    private static <T> Function<Object, T> getter(Function<DecryptRequest, T> g) {
        return obj -> g.apply((DecryptRequest) obj);
    }

    private static <T> BiConsumer<Object, T> setter(BiConsumer<Builder, T> s) {
        return (obj, val) -> s.accept((Builder) obj, val);
    }

    @Mutable
    @NotThreadSafe
    public interface Builder extends KmsRequest.Builder, SdkPojo, CopyableBuilder<Builder, DecryptRequest> {
        /**
         * <p>
         * Ciphertext to be decrypted. The blob includes metadata.
         * </p>
         * 
         * @param ciphertextBlob
         *        Ciphertext to be decrypted. The blob includes metadata.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder ciphertextBlob(SdkBytes ciphertextBlob);

        /**
         * <p>
         * Specifies the encryption context to use when decrypting the data. An encryption context is valid only for <a
         * href="https://docs.aws.amazon.com/kms/latest/developerguide/concepts.html#cryptographic-operations">
         * cryptographic operations</a> with a symmetric encryption KMS key. The standard asymmetric encryption
         * algorithms and HMAC algorithms that KMS uses do not support an encryption context.
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
         * @param encryptionContext
         *        Specifies the encryption context to use when decrypting the data. An encryption context is valid only
         *        for <a
         *        href="https://docs.aws.amazon.com/kms/latest/developerguide/concepts.html#cryptographic-operations"
         *        >cryptographic operations</a> with a symmetric encryption KMS key. The standard asymmetric encryption
         *        algorithms and HMAC algorithms that KMS uses do not support an encryption context.</p>
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
        Builder encryptionContext(Map<String, String> encryptionContext);

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
         *        A list of grant tokens. </p>
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
         *        A list of grant tokens. </p>
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
         * Specifies the KMS key that KMS uses to decrypt the ciphertext.
         * </p>
         * <p>
         * Enter a key ID of the KMS key that was used to encrypt the ciphertext. If you identify a different KMS key,
         * the <code>Decrypt</code> operation throws an <code>IncorrectKeyException</code>.
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
         * @param keyId
         *        Specifies the KMS key that KMS uses to decrypt the ciphertext.</p>
         *        <p>
         *        Enter a key ID of the KMS key that was used to encrypt the ciphertext. If you identify a different KMS
         *        key, the <code>Decrypt</code> operation throws an <code>IncorrectKeyException</code>.
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
        Builder keyId(String keyId);

        /**
         * <p>
         * Specifies the encryption algorithm that will be used to decrypt the ciphertext. Specify the same algorithm
         * that was used to encrypt the data. If you specify a different algorithm, the <code>Decrypt</code> operation
         * fails.
         * </p>
         * <p>
         * This parameter is required only when the ciphertext was encrypted under an asymmetric KMS key. The default
         * value, <code>SYMMETRIC_DEFAULT</code>, represents the only supported algorithm that is valid for symmetric
         * encryption KMS keys.
         * </p>
         * 
         * @param encryptionAlgorithm
         *        Specifies the encryption algorithm that will be used to decrypt the ciphertext. Specify the same
         *        algorithm that was used to encrypt the data. If you specify a different algorithm, the
         *        <code>Decrypt</code> operation fails.</p>
         *        <p>
         *        This parameter is required only when the ciphertext was encrypted under an asymmetric KMS key. The
         *        default value, <code>SYMMETRIC_DEFAULT</code>, represents the only supported algorithm that is valid
         *        for symmetric encryption KMS keys.
         * @see EncryptionAlgorithmSpec
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see EncryptionAlgorithmSpec
         */
        Builder encryptionAlgorithm(String encryptionAlgorithm);

        /**
         * <p>
         * Specifies the encryption algorithm that will be used to decrypt the ciphertext. Specify the same algorithm
         * that was used to encrypt the data. If you specify a different algorithm, the <code>Decrypt</code> operation
         * fails.
         * </p>
         * <p>
         * This parameter is required only when the ciphertext was encrypted under an asymmetric KMS key. The default
         * value, <code>SYMMETRIC_DEFAULT</code>, represents the only supported algorithm that is valid for symmetric
         * encryption KMS keys.
         * </p>
         * 
         * @param encryptionAlgorithm
         *        Specifies the encryption algorithm that will be used to decrypt the ciphertext. Specify the same
         *        algorithm that was used to encrypt the data. If you specify a different algorithm, the
         *        <code>Decrypt</code> operation fails.</p>
         *        <p>
         *        This parameter is required only when the ciphertext was encrypted under an asymmetric KMS key. The
         *        default value, <code>SYMMETRIC_DEFAULT</code>, represents the only supported algorithm that is valid
         *        for symmetric encryption KMS keys.
         * @see EncryptionAlgorithmSpec
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see EncryptionAlgorithmSpec
         */
        Builder encryptionAlgorithm(EncryptionAlgorithmSpec encryptionAlgorithm);

        /**
         * <p>
         * A signed <a
         * href="https://docs.aws.amazon.com/enclaves/latest/user/nitro-enclave-concepts.html#term-attestdoc"
         * >attestation document</a> from an Amazon Web Services Nitro enclave and the encryption algorithm to use with
         * the enclave's public key. The only valid encryption algorithm is <code>RSAES_OAEP_SHA_256</code>.
         * </p>
         * <p>
         * This parameter only supports attestation documents for Amazon Web Services Nitro Enclaves. To include this
         * parameter, use the <a
         * href="https://docs.aws.amazon.com/enclaves/latest/user/developing-applications.html#sdk">Amazon Web Services
         * Nitro Enclaves SDK</a> or any Amazon Web Services SDK.
         * </p>
         * <p>
         * When you use this parameter, instead of returning the plaintext data, KMS encrypts the plaintext data with
         * the public key in the attestation document, and returns the resulting ciphertext in the
         * <code>CiphertextForRecipient</code> field in the response. This ciphertext can be decrypted only with the
         * private key in the enclave. The <code>Plaintext</code> field in the response is null or empty.
         * </p>
         * <p>
         * For information about the interaction between KMS and Amazon Web Services Nitro Enclaves, see <a
         * href="https://docs.aws.amazon.com/kms/latest/developerguide/services-nitro-enclaves.html">How Amazon Web
         * Services Nitro Enclaves uses KMS</a> in the <i>Key Management Service Developer Guide</i>.
         * </p>
         * 
         * @param recipient
         *        A signed <a
         *        href="https://docs.aws.amazon.com/enclaves/latest/user/nitro-enclave-concepts.html#term-attestdoc"
         *        >attestation document</a> from an Amazon Web Services Nitro enclave and the encryption algorithm to
         *        use with the enclave's public key. The only valid encryption algorithm is
         *        <code>RSAES_OAEP_SHA_256</code>. </p>
         *        <p>
         *        This parameter only supports attestation documents for Amazon Web Services Nitro Enclaves. To include
         *        this parameter, use the <a
         *        href="https://docs.aws.amazon.com/enclaves/latest/user/developing-applications.html#sdk">Amazon Web
         *        Services Nitro Enclaves SDK</a> or any Amazon Web Services SDK.
         *        </p>
         *        <p>
         *        When you use this parameter, instead of returning the plaintext data, KMS encrypts the plaintext data
         *        with the public key in the attestation document, and returns the resulting ciphertext in the
         *        <code>CiphertextForRecipient</code> field in the response. This ciphertext can be decrypted only with
         *        the private key in the enclave. The <code>Plaintext</code> field in the response is null or empty.
         *        </p>
         *        <p>
         *        For information about the interaction between KMS and Amazon Web Services Nitro Enclaves, see <a
         *        href="https://docs.aws.amazon.com/kms/latest/developerguide/services-nitro-enclaves.html">How Amazon
         *        Web Services Nitro Enclaves uses KMS</a> in the <i>Key Management Service Developer Guide</i>.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder recipient(RecipientInfo recipient);

        /**
         * <p>
         * A signed <a
         * href="https://docs.aws.amazon.com/enclaves/latest/user/nitro-enclave-concepts.html#term-attestdoc"
         * >attestation document</a> from an Amazon Web Services Nitro enclave and the encryption algorithm to use with
         * the enclave's public key. The only valid encryption algorithm is <code>RSAES_OAEP_SHA_256</code>.
         * </p>
         * <p>
         * This parameter only supports attestation documents for Amazon Web Services Nitro Enclaves. To include this
         * parameter, use the <a
         * href="https://docs.aws.amazon.com/enclaves/latest/user/developing-applications.html#sdk">Amazon Web Services
         * Nitro Enclaves SDK</a> or any Amazon Web Services SDK.
         * </p>
         * <p>
         * When you use this parameter, instead of returning the plaintext data, KMS encrypts the plaintext data with
         * the public key in the attestation document, and returns the resulting ciphertext in the
         * <code>CiphertextForRecipient</code> field in the response. This ciphertext can be decrypted only with the
         * private key in the enclave. The <code>Plaintext</code> field in the response is null or empty.
         * </p>
         * <p>
         * For information about the interaction between KMS and Amazon Web Services Nitro Enclaves, see <a
         * href="https://docs.aws.amazon.com/kms/latest/developerguide/services-nitro-enclaves.html">How Amazon Web
         * Services Nitro Enclaves uses KMS</a> in the <i>Key Management Service Developer Guide</i>.
         * </p>
         * This is a convenience method that creates an instance of the {@link RecipientInfo.Builder} avoiding the need
         * to create one manually via {@link RecipientInfo#builder()}.
         *
         * <p>
         * When the {@link Consumer} completes, {@link RecipientInfo.Builder#build()} is called immediately and its
         * result is passed to {@link #recipient(RecipientInfo)}.
         * 
         * @param recipient
         *        a consumer that will call methods on {@link RecipientInfo.Builder}
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see #recipient(RecipientInfo)
         */
        default Builder recipient(Consumer<RecipientInfo.Builder> recipient) {
            return recipient(RecipientInfo.builder().applyMutation(recipient).build());
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

        private Map<String, String> encryptionContext = DefaultSdkAutoConstructMap.getInstance();

        private List<String> grantTokens = DefaultSdkAutoConstructList.getInstance();

        private String keyId;

        private String encryptionAlgorithm;

        private RecipientInfo recipient;

        private Boolean dryRun;

        private BuilderImpl() {
        }

        private BuilderImpl(DecryptRequest model) {
            super(model);
            ciphertextBlob(model.ciphertextBlob);
            encryptionContext(model.encryptionContext);
            grantTokens(model.grantTokens);
            keyId(model.keyId);
            encryptionAlgorithm(model.encryptionAlgorithm);
            recipient(model.recipient);
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

        public final Map<String, String> getEncryptionContext() {
            if (encryptionContext instanceof SdkAutoConstructMap) {
                return null;
            }
            return encryptionContext;
        }

        public final void setEncryptionContext(Map<String, String> encryptionContext) {
            this.encryptionContext = EncryptionContextTypeCopier.copy(encryptionContext);
        }

        @Override
        public final Builder encryptionContext(Map<String, String> encryptionContext) {
            this.encryptionContext = EncryptionContextTypeCopier.copy(encryptionContext);
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

        public final String getEncryptionAlgorithm() {
            return encryptionAlgorithm;
        }

        public final void setEncryptionAlgorithm(String encryptionAlgorithm) {
            this.encryptionAlgorithm = encryptionAlgorithm;
        }

        @Override
        public final Builder encryptionAlgorithm(String encryptionAlgorithm) {
            this.encryptionAlgorithm = encryptionAlgorithm;
            return this;
        }

        @Override
        public final Builder encryptionAlgorithm(EncryptionAlgorithmSpec encryptionAlgorithm) {
            this.encryptionAlgorithm(encryptionAlgorithm == null ? null : encryptionAlgorithm.toString());
            return this;
        }

        public final RecipientInfo.Builder getRecipient() {
            return recipient != null ? recipient.toBuilder() : null;
        }

        public final void setRecipient(RecipientInfo.BuilderImpl recipient) {
            this.recipient = recipient != null ? recipient.build() : null;
        }

        @Override
        public final Builder recipient(RecipientInfo recipient) {
            this.recipient = recipient;
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
        public DecryptRequest build() {
            return new DecryptRequest(this);
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
