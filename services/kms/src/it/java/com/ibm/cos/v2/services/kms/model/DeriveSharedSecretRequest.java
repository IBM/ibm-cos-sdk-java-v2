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
import com.ibm.cos.v2.core.util.DefaultSdkAutoConstructList;
import com.ibm.cos.v2.core.util.SdkAutoConstructList;
import com.ibm.cos.v2.utils.ToString;
import com.ibm.cos.v2.utils.builder.CopyableBuilder;
import com.ibm.cos.v2.utils.builder.ToCopyableBuilder;

/**
 */
@Generated("com.ibm.cos.v2:codegen")
public final class DeriveSharedSecretRequest extends KmsRequest implements
        ToCopyableBuilder<DeriveSharedSecretRequest.Builder, DeriveSharedSecretRequest> {
    private static final SdkField<String> KEY_ID_FIELD = SdkField.<String> builder(MarshallingType.STRING).memberName("KeyId")
            .getter(getter(DeriveSharedSecretRequest::keyId)).setter(setter(Builder::keyId))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("KeyId").build()).build();

    private static final SdkField<String> KEY_AGREEMENT_ALGORITHM_FIELD = SdkField.<String> builder(MarshallingType.STRING)
            .memberName("KeyAgreementAlgorithm").getter(getter(DeriveSharedSecretRequest::keyAgreementAlgorithmAsString))
            .setter(setter(Builder::keyAgreementAlgorithm))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("KeyAgreementAlgorithm").build())
            .build();

    private static final SdkField<SdkBytes> PUBLIC_KEY_FIELD = SdkField.<SdkBytes> builder(MarshallingType.SDK_BYTES)
            .memberName("PublicKey").getter(getter(DeriveSharedSecretRequest::publicKey)).setter(setter(Builder::publicKey))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("PublicKey").build()).build();

    private static final SdkField<List<String>> GRANT_TOKENS_FIELD = SdkField
            .<List<String>> builder(MarshallingType.LIST)
            .memberName("GrantTokens")
            .getter(getter(DeriveSharedSecretRequest::grantTokens))
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
            .memberName("DryRun").getter(getter(DeriveSharedSecretRequest::dryRun)).setter(setter(Builder::dryRun))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("DryRun").build()).build();

    private static final SdkField<RecipientInfo> RECIPIENT_FIELD = SdkField.<RecipientInfo> builder(MarshallingType.SDK_POJO)
            .memberName("Recipient").getter(getter(DeriveSharedSecretRequest::recipient)).setter(setter(Builder::recipient))
            .constructor(RecipientInfo::builder)
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("Recipient").build()).build();

    private static final List<SdkField<?>> SDK_FIELDS = Collections.unmodifiableList(Arrays.asList(KEY_ID_FIELD,
            KEY_AGREEMENT_ALGORITHM_FIELD, PUBLIC_KEY_FIELD, GRANT_TOKENS_FIELD, DRY_RUN_FIELD, RECIPIENT_FIELD));

    private static final Map<String, SdkField<?>> SDK_NAME_TO_FIELD = memberNameToFieldInitializer();

    private final String keyId;

    private final String keyAgreementAlgorithm;

    private final SdkBytes publicKey;

    private final List<String> grantTokens;

    private final Boolean dryRun;

    private final RecipientInfo recipient;

    private DeriveSharedSecretRequest(BuilderImpl builder) {
        super(builder);
        this.keyId = builder.keyId;
        this.keyAgreementAlgorithm = builder.keyAgreementAlgorithm;
        this.publicKey = builder.publicKey;
        this.grantTokens = builder.grantTokens;
        this.dryRun = builder.dryRun;
        this.recipient = builder.recipient;
    }

    /**
     * <p>
     * Identifies an asymmetric NIST-recommended ECC or SM2 (China Regions only) KMS key. KMS uses the private key in
     * the specified key pair to derive the shared secret. The key usage of the KMS key must be
     * <code>KEY_AGREEMENT</code>. To find the <code>KeyUsage</code> of a KMS key, use the <a>DescribeKey</a> operation.
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
     * @return Identifies an asymmetric NIST-recommended ECC or SM2 (China Regions only) KMS key. KMS uses the private
     *         key in the specified key pair to derive the shared secret. The key usage of the KMS key must be
     *         <code>KEY_AGREEMENT</code>. To find the <code>KeyUsage</code> of a KMS key, use the <a>DescribeKey</a>
     *         operation.</p>
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
     * Specifies the key agreement algorithm used to derive the shared secret. The only valid value is <code>ECDH</code>
     * .
     * </p>
     * <p>
     * If the service returns an enum value that is not available in the current SDK version,
     * {@link #keyAgreementAlgorithm} will return {@link KeyAgreementAlgorithmSpec#UNKNOWN_TO_SDK_VERSION}. The raw
     * value returned by the service is available from {@link #keyAgreementAlgorithmAsString}.
     * </p>
     * 
     * @return Specifies the key agreement algorithm used to derive the shared secret. The only valid value is
     *         <code>ECDH</code>.
     * @see KeyAgreementAlgorithmSpec
     */
    public final KeyAgreementAlgorithmSpec keyAgreementAlgorithm() {
        return KeyAgreementAlgorithmSpec.fromValue(keyAgreementAlgorithm);
    }

    /**
     * <p>
     * Specifies the key agreement algorithm used to derive the shared secret. The only valid value is <code>ECDH</code>
     * .
     * </p>
     * <p>
     * If the service returns an enum value that is not available in the current SDK version,
     * {@link #keyAgreementAlgorithm} will return {@link KeyAgreementAlgorithmSpec#UNKNOWN_TO_SDK_VERSION}. The raw
     * value returned by the service is available from {@link #keyAgreementAlgorithmAsString}.
     * </p>
     * 
     * @return Specifies the key agreement algorithm used to derive the shared secret. The only valid value is
     *         <code>ECDH</code>.
     * @see KeyAgreementAlgorithmSpec
     */
    public final String keyAgreementAlgorithmAsString() {
        return keyAgreementAlgorithm;
    }

    /**
     * <p>
     * Specifies the public key in your peer's NIST-recommended elliptic curve (ECC) or SM2 (China Regions only) key
     * pair.
     * </p>
     * <p>
     * The public key must be a DER-encoded X.509 public key, also known as <code>SubjectPublicKeyInfo</code> (SPKI), as
     * defined in <a href="https://tools.ietf.org/html/rfc5280">RFC 5280</a>.
     * </p>
     * <p>
     * <a>GetPublicKey</a> returns the public key of an asymmetric KMS key pair in the required DER-encoded format.
     * </p>
     * <note>
     * <p>
     * If you use <a href="https://docs.aws.amazon.com/cli/v1/userguide/cli-chap-welcome.html">Amazon Web Services CLI
     * version 1</a>, you must provide the DER-encoded X.509 public key in a file. Otherwise, the Amazon Web Services
     * CLI Base64-encodes the public key a second time, resulting in a <code>ValidationException</code>.
     * </p>
     * </note>
     * <p>
     * You can specify the public key as binary data in a file using fileb (<code>fileb://&lt;path-to-file&gt;</code>)
     * or in-line using a Base64 encoded string.
     * </p>
     * 
     * @return Specifies the public key in your peer's NIST-recommended elliptic curve (ECC) or SM2 (China Regions only)
     *         key pair.</p>
     *         <p>
     *         The public key must be a DER-encoded X.509 public key, also known as <code>SubjectPublicKeyInfo</code>
     *         (SPKI), as defined in <a href="https://tools.ietf.org/html/rfc5280">RFC 5280</a>.
     *         </p>
     *         <p>
     *         <a>GetPublicKey</a> returns the public key of an asymmetric KMS key pair in the required DER-encoded
     *         format.
     *         </p>
     *         <note>
     *         <p>
     *         If you use <a href="https://docs.aws.amazon.com/cli/v1/userguide/cli-chap-welcome.html">Amazon Web
     *         Services CLI version 1</a>, you must provide the DER-encoded X.509 public key in a file. Otherwise, the
     *         Amazon Web Services CLI Base64-encodes the public key a second time, resulting in a
     *         <code>ValidationException</code>.
     *         </p>
     *         </note>
     *         <p>
     *         You can specify the public key as binary data in a file using fileb (
     *         <code>fileb://&lt;path-to-file&gt;</code>) or in-line using a Base64 encoded string.
     */
    public final SdkBytes publicKey() {
        return publicKey;
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

    /**
     * <p>
     * A signed <a
     * href="https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/nitro-enclave-how.html#term-attestdoc">attestation
     * document</a> from an Amazon Web Services Nitro enclave and the encryption algorithm to use with the enclave's
     * public key. The only valid encryption algorithm is <code>RSAES_OAEP_SHA_256</code>.
     * </p>
     * <p>
     * This parameter only supports attestation documents for Amazon Web Services Nitro Enclaves. To call
     * DeriveSharedSecret for an Amazon Web Services Nitro Enclaves, use the <a
     * href="https://docs.aws.amazon.com/enclaves/latest/user/developing-applications.html#sdk">Amazon Web Services
     * Nitro Enclaves SDK</a> to generate the attestation document and then use the Recipient parameter from any Amazon
     * Web Services SDK to provide the attestation document for the enclave.
     * </p>
     * <p>
     * When you use this parameter, instead of returning a plaintext copy of the shared secret, KMS encrypts the
     * plaintext shared secret under the public key in the attestation document, and returns the resulting ciphertext in
     * the <code>CiphertextForRecipient</code> field in the response. This ciphertext can be decrypted only with the
     * private key in the enclave. The <code>CiphertextBlob</code> field in the response contains the encrypted shared
     * secret derived from the KMS key specified by the <code>KeyId</code> parameter and public key specified by the
     * <code>PublicKey</code> parameter. The <code>SharedSecret</code> field in the response is null or empty.
     * </p>
     * <p>
     * For information about the interaction between KMS and Amazon Web Services Nitro Enclaves, see <a
     * href="https://docs.aws.amazon.com/kms/latest/developerguide/services-nitro-enclaves.html">How Amazon Web Services
     * Nitro Enclaves uses KMS</a> in the <i>Key Management Service Developer Guide</i>.
     * </p>
     * 
     * @return A signed <a
     *         href="https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/nitro-enclave-how.html#term-attestdoc"
     *         >attestation document</a> from an Amazon Web Services Nitro enclave and the encryption algorithm to use
     *         with the enclave's public key. The only valid encryption algorithm is <code>RSAES_OAEP_SHA_256</code>.
     *         </p>
     *         <p>
     *         This parameter only supports attestation documents for Amazon Web Services Nitro Enclaves. To call
     *         DeriveSharedSecret for an Amazon Web Services Nitro Enclaves, use the <a
     *         href="https://docs.aws.amazon.com/enclaves/latest/user/developing-applications.html#sdk">Amazon Web
     *         Services Nitro Enclaves SDK</a> to generate the attestation document and then use the Recipient parameter
     *         from any Amazon Web Services SDK to provide the attestation document for the enclave.
     *         </p>
     *         <p>
     *         When you use this parameter, instead of returning a plaintext copy of the shared secret, KMS encrypts the
     *         plaintext shared secret under the public key in the attestation document, and returns the resulting
     *         ciphertext in the <code>CiphertextForRecipient</code> field in the response. This ciphertext can be
     *         decrypted only with the private key in the enclave. The <code>CiphertextBlob</code> field in the response
     *         contains the encrypted shared secret derived from the KMS key specified by the <code>KeyId</code>
     *         parameter and public key specified by the <code>PublicKey</code> parameter. The <code>SharedSecret</code>
     *         field in the response is null or empty.
     *         </p>
     *         <p>
     *         For information about the interaction between KMS and Amazon Web Services Nitro Enclaves, see <a
     *         href="https://docs.aws.amazon.com/kms/latest/developerguide/services-nitro-enclaves.html">How Amazon Web
     *         Services Nitro Enclaves uses KMS</a> in the <i>Key Management Service Developer Guide</i>.
     */
    public final RecipientInfo recipient() {
        return recipient;
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
        hashCode = 31 * hashCode + Objects.hashCode(keyAgreementAlgorithmAsString());
        hashCode = 31 * hashCode + Objects.hashCode(publicKey());
        hashCode = 31 * hashCode + Objects.hashCode(hasGrantTokens() ? grantTokens() : null);
        hashCode = 31 * hashCode + Objects.hashCode(dryRun());
        hashCode = 31 * hashCode + Objects.hashCode(recipient());
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
        if (!(obj instanceof DeriveSharedSecretRequest)) {
            return false;
        }
        DeriveSharedSecretRequest other = (DeriveSharedSecretRequest) obj;
        return Objects.equals(keyId(), other.keyId())
                && Objects.equals(keyAgreementAlgorithmAsString(), other.keyAgreementAlgorithmAsString())
                && Objects.equals(publicKey(), other.publicKey()) && hasGrantTokens() == other.hasGrantTokens()
                && Objects.equals(grantTokens(), other.grantTokens()) && Objects.equals(dryRun(), other.dryRun())
                && Objects.equals(recipient(), other.recipient());
    }

    /**
     * Returns a string representation of this object. This is useful for testing and debugging. Sensitive data will be
     * redacted from this string using a placeholder value.
     */
    @Override
    public final String toString() {
        return ToString.builder("DeriveSharedSecretRequest").add("KeyId", keyId())
                .add("KeyAgreementAlgorithm", keyAgreementAlgorithmAsString()).add("PublicKey", publicKey())
                .add("GrantTokens", hasGrantTokens() ? grantTokens() : null).add("DryRun", dryRun())
                .add("Recipient", recipient()).build();
    }

    public final <T> Optional<T> getValueForField(String fieldName, Class<T> clazz) {
        switch (fieldName) {
        case "KeyId":
            return Optional.ofNullable(clazz.cast(keyId()));
        case "KeyAgreementAlgorithm":
            return Optional.ofNullable(clazz.cast(keyAgreementAlgorithmAsString()));
        case "PublicKey":
            return Optional.ofNullable(clazz.cast(publicKey()));
        case "GrantTokens":
            return Optional.ofNullable(clazz.cast(grantTokens()));
        case "DryRun":
            return Optional.ofNullable(clazz.cast(dryRun()));
        case "Recipient":
            return Optional.ofNullable(clazz.cast(recipient()));
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
        map.put("KeyAgreementAlgorithm", KEY_AGREEMENT_ALGORITHM_FIELD);
        map.put("PublicKey", PUBLIC_KEY_FIELD);
        map.put("GrantTokens", GRANT_TOKENS_FIELD);
        map.put("DryRun", DRY_RUN_FIELD);
        map.put("Recipient", RECIPIENT_FIELD);
        return Collections.unmodifiableMap(map);
    }

    private static <T> Function<Object, T> getter(Function<DeriveSharedSecretRequest, T> g) {
        return obj -> g.apply((DeriveSharedSecretRequest) obj);
    }

    private static <T> BiConsumer<Object, T> setter(BiConsumer<Builder, T> s) {
        return (obj, val) -> s.accept((Builder) obj, val);
    }

    @Mutable
    @NotThreadSafe
    public interface Builder extends KmsRequest.Builder, SdkPojo, CopyableBuilder<Builder, DeriveSharedSecretRequest> {
        /**
         * <p>
         * Identifies an asymmetric NIST-recommended ECC or SM2 (China Regions only) KMS key. KMS uses the private key
         * in the specified key pair to derive the shared secret. The key usage of the KMS key must be
         * <code>KEY_AGREEMENT</code>. To find the <code>KeyUsage</code> of a KMS key, use the <a>DescribeKey</a>
         * operation.
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
         *        Identifies an asymmetric NIST-recommended ECC or SM2 (China Regions only) KMS key. KMS uses the
         *        private key in the specified key pair to derive the shared secret. The key usage of the KMS key must
         *        be <code>KEY_AGREEMENT</code>. To find the <code>KeyUsage</code> of a KMS key, use the
         *        <a>DescribeKey</a> operation.</p>
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
         * Specifies the key agreement algorithm used to derive the shared secret. The only valid value is
         * <code>ECDH</code>.
         * </p>
         * 
         * @param keyAgreementAlgorithm
         *        Specifies the key agreement algorithm used to derive the shared secret. The only valid value is
         *        <code>ECDH</code>.
         * @see KeyAgreementAlgorithmSpec
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see KeyAgreementAlgorithmSpec
         */
        Builder keyAgreementAlgorithm(String keyAgreementAlgorithm);

        /**
         * <p>
         * Specifies the key agreement algorithm used to derive the shared secret. The only valid value is
         * <code>ECDH</code>.
         * </p>
         * 
         * @param keyAgreementAlgorithm
         *        Specifies the key agreement algorithm used to derive the shared secret. The only valid value is
         *        <code>ECDH</code>.
         * @see KeyAgreementAlgorithmSpec
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see KeyAgreementAlgorithmSpec
         */
        Builder keyAgreementAlgorithm(KeyAgreementAlgorithmSpec keyAgreementAlgorithm);

        /**
         * <p>
         * Specifies the public key in your peer's NIST-recommended elliptic curve (ECC) or SM2 (China Regions only) key
         * pair.
         * </p>
         * <p>
         * The public key must be a DER-encoded X.509 public key, also known as <code>SubjectPublicKeyInfo</code>
         * (SPKI), as defined in <a href="https://tools.ietf.org/html/rfc5280">RFC 5280</a>.
         * </p>
         * <p>
         * <a>GetPublicKey</a> returns the public key of an asymmetric KMS key pair in the required DER-encoded format.
         * </p>
         * <note>
         * <p>
         * If you use <a href="https://docs.aws.amazon.com/cli/v1/userguide/cli-chap-welcome.html">Amazon Web Services
         * CLI version 1</a>, you must provide the DER-encoded X.509 public key in a file. Otherwise, the Amazon Web
         * Services CLI Base64-encodes the public key a second time, resulting in a <code>ValidationException</code>.
         * </p>
         * </note>
         * <p>
         * You can specify the public key as binary data in a file using fileb (
         * <code>fileb://&lt;path-to-file&gt;</code>) or in-line using a Base64 encoded string.
         * </p>
         * 
         * @param publicKey
         *        Specifies the public key in your peer's NIST-recommended elliptic curve (ECC) or SM2 (China Regions
         *        only) key pair.</p>
         *        <p>
         *        The public key must be a DER-encoded X.509 public key, also known as <code>SubjectPublicKeyInfo</code>
         *        (SPKI), as defined in <a href="https://tools.ietf.org/html/rfc5280">RFC 5280</a>.
         *        </p>
         *        <p>
         *        <a>GetPublicKey</a> returns the public key of an asymmetric KMS key pair in the required DER-encoded
         *        format.
         *        </p>
         *        <note>
         *        <p>
         *        If you use <a href="https://docs.aws.amazon.com/cli/v1/userguide/cli-chap-welcome.html">Amazon Web
         *        Services CLI version 1</a>, you must provide the DER-encoded X.509 public key in a file. Otherwise,
         *        the Amazon Web Services CLI Base64-encodes the public key a second time, resulting in a
         *        <code>ValidationException</code>.
         *        </p>
         *        </note>
         *        <p>
         *        You can specify the public key as binary data in a file using fileb (
         *        <code>fileb://&lt;path-to-file&gt;</code>) or in-line using a Base64 encoded string.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder publicKey(SdkBytes publicKey);

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

        /**
         * <p>
         * A signed <a href="https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/nitro-enclave-how.html#term-attestdoc">
         * attestation document</a> from an Amazon Web Services Nitro enclave and the encryption algorithm to use with
         * the enclave's public key. The only valid encryption algorithm is <code>RSAES_OAEP_SHA_256</code>.
         * </p>
         * <p>
         * This parameter only supports attestation documents for Amazon Web Services Nitro Enclaves. To call
         * DeriveSharedSecret for an Amazon Web Services Nitro Enclaves, use the <a
         * href="https://docs.aws.amazon.com/enclaves/latest/user/developing-applications.html#sdk">Amazon Web Services
         * Nitro Enclaves SDK</a> to generate the attestation document and then use the Recipient parameter from any
         * Amazon Web Services SDK to provide the attestation document for the enclave.
         * </p>
         * <p>
         * When you use this parameter, instead of returning a plaintext copy of the shared secret, KMS encrypts the
         * plaintext shared secret under the public key in the attestation document, and returns the resulting
         * ciphertext in the <code>CiphertextForRecipient</code> field in the response. This ciphertext can be decrypted
         * only with the private key in the enclave. The <code>CiphertextBlob</code> field in the response contains the
         * encrypted shared secret derived from the KMS key specified by the <code>KeyId</code> parameter and public key
         * specified by the <code>PublicKey</code> parameter. The <code>SharedSecret</code> field in the response is
         * null or empty.
         * </p>
         * <p>
         * For information about the interaction between KMS and Amazon Web Services Nitro Enclaves, see <a
         * href="https://docs.aws.amazon.com/kms/latest/developerguide/services-nitro-enclaves.html">How Amazon Web
         * Services Nitro Enclaves uses KMS</a> in the <i>Key Management Service Developer Guide</i>.
         * </p>
         * 
         * @param recipient
         *        A signed <a
         *        href="https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/nitro-enclave-how.html#term-attestdoc"
         *        >attestation document</a> from an Amazon Web Services Nitro enclave and the encryption algorithm to
         *        use with the enclave's public key. The only valid encryption algorithm is
         *        <code>RSAES_OAEP_SHA_256</code>. </p>
         *        <p>
         *        This parameter only supports attestation documents for Amazon Web Services Nitro Enclaves. To call
         *        DeriveSharedSecret for an Amazon Web Services Nitro Enclaves, use the <a
         *        href="https://docs.aws.amazon.com/enclaves/latest/user/developing-applications.html#sdk">Amazon Web
         *        Services Nitro Enclaves SDK</a> to generate the attestation document and then use the Recipient
         *        parameter from any Amazon Web Services SDK to provide the attestation document for the enclave.
         *        </p>
         *        <p>
         *        When you use this parameter, instead of returning a plaintext copy of the shared secret, KMS encrypts
         *        the plaintext shared secret under the public key in the attestation document, and returns the
         *        resulting ciphertext in the <code>CiphertextForRecipient</code> field in the response. This ciphertext
         *        can be decrypted only with the private key in the enclave. The <code>CiphertextBlob</code> field in
         *        the response contains the encrypted shared secret derived from the KMS key specified by the
         *        <code>KeyId</code> parameter and public key specified by the <code>PublicKey</code> parameter. The
         *        <code>SharedSecret</code> field in the response is null or empty.
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
         * A signed <a href="https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/nitro-enclave-how.html#term-attestdoc">
         * attestation document</a> from an Amazon Web Services Nitro enclave and the encryption algorithm to use with
         * the enclave's public key. The only valid encryption algorithm is <code>RSAES_OAEP_SHA_256</code>.
         * </p>
         * <p>
         * This parameter only supports attestation documents for Amazon Web Services Nitro Enclaves. To call
         * DeriveSharedSecret for an Amazon Web Services Nitro Enclaves, use the <a
         * href="https://docs.aws.amazon.com/enclaves/latest/user/developing-applications.html#sdk">Amazon Web Services
         * Nitro Enclaves SDK</a> to generate the attestation document and then use the Recipient parameter from any
         * Amazon Web Services SDK to provide the attestation document for the enclave.
         * </p>
         * <p>
         * When you use this parameter, instead of returning a plaintext copy of the shared secret, KMS encrypts the
         * plaintext shared secret under the public key in the attestation document, and returns the resulting
         * ciphertext in the <code>CiphertextForRecipient</code> field in the response. This ciphertext can be decrypted
         * only with the private key in the enclave. The <code>CiphertextBlob</code> field in the response contains the
         * encrypted shared secret derived from the KMS key specified by the <code>KeyId</code> parameter and public key
         * specified by the <code>PublicKey</code> parameter. The <code>SharedSecret</code> field in the response is
         * null or empty.
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

        @Override
        Builder overrideConfiguration(AwsRequestOverrideConfiguration overrideConfiguration);

        @Override
        Builder overrideConfiguration(Consumer<AwsRequestOverrideConfiguration.Builder> builderConsumer);
    }

    static final class BuilderImpl extends KmsRequest.BuilderImpl implements Builder {
        private String keyId;

        private String keyAgreementAlgorithm;

        private SdkBytes publicKey;

        private List<String> grantTokens = DefaultSdkAutoConstructList.getInstance();

        private Boolean dryRun;

        private RecipientInfo recipient;

        private BuilderImpl() {
        }

        private BuilderImpl(DeriveSharedSecretRequest model) {
            super(model);
            keyId(model.keyId);
            keyAgreementAlgorithm(model.keyAgreementAlgorithm);
            publicKey(model.publicKey);
            grantTokens(model.grantTokens);
            dryRun(model.dryRun);
            recipient(model.recipient);
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

        public final String getKeyAgreementAlgorithm() {
            return keyAgreementAlgorithm;
        }

        public final void setKeyAgreementAlgorithm(String keyAgreementAlgorithm) {
            this.keyAgreementAlgorithm = keyAgreementAlgorithm;
        }

        @Override
        public final Builder keyAgreementAlgorithm(String keyAgreementAlgorithm) {
            this.keyAgreementAlgorithm = keyAgreementAlgorithm;
            return this;
        }

        @Override
        public final Builder keyAgreementAlgorithm(KeyAgreementAlgorithmSpec keyAgreementAlgorithm) {
            this.keyAgreementAlgorithm(keyAgreementAlgorithm == null ? null : keyAgreementAlgorithm.toString());
            return this;
        }

        public final ByteBuffer getPublicKey() {
            return publicKey == null ? null : publicKey.asByteBuffer();
        }

        public final void setPublicKey(ByteBuffer publicKey) {
            publicKey(publicKey == null ? null : SdkBytes.fromByteBuffer(publicKey));
        }

        @Override
        public final Builder publicKey(SdkBytes publicKey) {
            this.publicKey = publicKey;
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
        public DeriveSharedSecretRequest build() {
            return new DeriveSharedSecretRequest(this);
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
