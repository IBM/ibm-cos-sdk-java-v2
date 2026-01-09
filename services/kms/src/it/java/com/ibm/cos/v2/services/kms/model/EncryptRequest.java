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
public final class EncryptRequest extends KmsRequest implements ToCopyableBuilder<EncryptRequest.Builder, EncryptRequest> {
    private static final SdkField<String> KEY_ID_FIELD = SdkField.<String> builder(MarshallingType.STRING).memberName("KeyId")
            .getter(getter(EncryptRequest::keyId)).setter(setter(Builder::keyId))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("KeyId").build()).build();

    private static final SdkField<SdkBytes> PLAINTEXT_FIELD = SdkField.<SdkBytes> builder(MarshallingType.SDK_BYTES)
            .memberName("Plaintext").getter(getter(EncryptRequest::plaintext)).setter(setter(Builder::plaintext))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("Plaintext").build()).build();

    private static final SdkField<Map<String, String>> ENCRYPTION_CONTEXT_FIELD = SdkField
            .<Map<String, String>> builder(MarshallingType.MAP)
            .memberName("EncryptionContext")
            .getter(getter(EncryptRequest::encryptionContext))
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
            .getter(getter(EncryptRequest::grantTokens))
            .setter(setter(Builder::grantTokens))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("GrantTokens").build(),
                    ListTrait
                            .builder()
                            .memberLocationName(null)
                            .memberFieldInfo(
                                    SdkField.<String> builder(MarshallingType.STRING)
                                            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD)
                                                    .locationName("member").build()).build()).build()).build();

    private static final SdkField<String> ENCRYPTION_ALGORITHM_FIELD = SdkField.<String> builder(MarshallingType.STRING)
            .memberName("EncryptionAlgorithm").getter(getter(EncryptRequest::encryptionAlgorithmAsString))
            .setter(setter(Builder::encryptionAlgorithm))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("EncryptionAlgorithm").build())
            .build();

    private static final SdkField<Boolean> DRY_RUN_FIELD = SdkField.<Boolean> builder(MarshallingType.BOOLEAN)
            .memberName("DryRun").getter(getter(EncryptRequest::dryRun)).setter(setter(Builder::dryRun))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("DryRun").build()).build();

    private static final List<SdkField<?>> SDK_FIELDS = Collections.unmodifiableList(Arrays.asList(KEY_ID_FIELD, PLAINTEXT_FIELD,
            ENCRYPTION_CONTEXT_FIELD, GRANT_TOKENS_FIELD, ENCRYPTION_ALGORITHM_FIELD, DRY_RUN_FIELD));

    private static final Map<String, SdkField<?>> SDK_NAME_TO_FIELD = memberNameToFieldInitializer();

    private final String keyId;

    private final SdkBytes plaintext;

    private final Map<String, String> encryptionContext;

    private final List<String> grantTokens;

    private final String encryptionAlgorithm;

    private final Boolean dryRun;

    private EncryptRequest(BuilderImpl builder) {
        super(builder);
        this.keyId = builder.keyId;
        this.plaintext = builder.plaintext;
        this.encryptionContext = builder.encryptionContext;
        this.grantTokens = builder.grantTokens;
        this.encryptionAlgorithm = builder.encryptionAlgorithm;
        this.dryRun = builder.dryRun;
    }

    /**
     * <p>
     * Identifies the KMS key to use in the encryption operation. The KMS key must have a <code>KeyUsage</code> of
     * <code>ENCRYPT_DECRYPT</code>. To find the <code>KeyUsage</code> of a KMS key, use the <a>DescribeKey</a>
     * operation.
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
     * @return Identifies the KMS key to use in the encryption operation. The KMS key must have a <code>KeyUsage</code>
     *         of <code>ENCRYPT_DECRYPT</code>. To find the <code>KeyUsage</code> of a KMS key, use the
     *         <a>DescribeKey</a> operation.</p>
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
     * Data to be encrypted.
     * </p>
     * 
     * @return Data to be encrypted.
     */
    public final SdkBytes plaintext() {
        return plaintext;
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
     * Specifies the encryption context that will be used to encrypt the data. An encryption context is valid only for
     * <a href="https://docs.aws.amazon.com/kms/latest/developerguide/concepts.html#cryptographic-operations">
     * cryptographic operations</a> with a symmetric encryption KMS key. The standard asymmetric encryption algorithms
     * and HMAC algorithms that KMS uses do not support an encryption context.
     * </p>
     * <important>
     * <p>
     * Do not include confidential or sensitive information in this field. This field may be displayed in plaintext in
     * CloudTrail logs and other output.
     * </p>
     * </important>
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
     * @return Specifies the encryption context that will be used to encrypt the data. An encryption context is valid
     *         only for <a
     *         href="https://docs.aws.amazon.com/kms/latest/developerguide/concepts.html#cryptographic-operations"
     *         >cryptographic operations</a> with a symmetric encryption KMS key. The standard asymmetric encryption
     *         algorithms and HMAC algorithms that KMS uses do not support an encryption context. </p> <important>
     *         <p>
     *         Do not include confidential or sensitive information in this field. This field may be displayed in
     *         plaintext in CloudTrail logs and other output.
     *         </p>
     *         </important>
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
     * Specifies the encryption algorithm that KMS will use to encrypt the plaintext message. The algorithm must be
     * compatible with the KMS key that you specify.
     * </p>
     * <p>
     * This parameter is required only for asymmetric KMS keys. The default value, <code>SYMMETRIC_DEFAULT</code>, is
     * the algorithm used for symmetric encryption KMS keys. If you are using an asymmetric KMS key, we recommend
     * RSAES_OAEP_SHA_256.
     * </p>
     * <p>
     * The SM2PKE algorithm is only available in China Regions.
     * </p>
     * <p>
     * If the service returns an enum value that is not available in the current SDK version,
     * {@link #encryptionAlgorithm} will return {@link EncryptionAlgorithmSpec#UNKNOWN_TO_SDK_VERSION}. The raw value
     * returned by the service is available from {@link #encryptionAlgorithmAsString}.
     * </p>
     * 
     * @return Specifies the encryption algorithm that KMS will use to encrypt the plaintext message. The algorithm must
     *         be compatible with the KMS key that you specify.</p>
     *         <p>
     *         This parameter is required only for asymmetric KMS keys. The default value,
     *         <code>SYMMETRIC_DEFAULT</code>, is the algorithm used for symmetric encryption KMS keys. If you are using
     *         an asymmetric KMS key, we recommend RSAES_OAEP_SHA_256.
     *         </p>
     *         <p>
     *         The SM2PKE algorithm is only available in China Regions.
     * @see EncryptionAlgorithmSpec
     */
    public final EncryptionAlgorithmSpec encryptionAlgorithm() {
        return EncryptionAlgorithmSpec.fromValue(encryptionAlgorithm);
    }

    /**
     * <p>
     * Specifies the encryption algorithm that KMS will use to encrypt the plaintext message. The algorithm must be
     * compatible with the KMS key that you specify.
     * </p>
     * <p>
     * This parameter is required only for asymmetric KMS keys. The default value, <code>SYMMETRIC_DEFAULT</code>, is
     * the algorithm used for symmetric encryption KMS keys. If you are using an asymmetric KMS key, we recommend
     * RSAES_OAEP_SHA_256.
     * </p>
     * <p>
     * The SM2PKE algorithm is only available in China Regions.
     * </p>
     * <p>
     * If the service returns an enum value that is not available in the current SDK version,
     * {@link #encryptionAlgorithm} will return {@link EncryptionAlgorithmSpec#UNKNOWN_TO_SDK_VERSION}. The raw value
     * returned by the service is available from {@link #encryptionAlgorithmAsString}.
     * </p>
     * 
     * @return Specifies the encryption algorithm that KMS will use to encrypt the plaintext message. The algorithm must
     *         be compatible with the KMS key that you specify.</p>
     *         <p>
     *         This parameter is required only for asymmetric KMS keys. The default value,
     *         <code>SYMMETRIC_DEFAULT</code>, is the algorithm used for symmetric encryption KMS keys. If you are using
     *         an asymmetric KMS key, we recommend RSAES_OAEP_SHA_256.
     *         </p>
     *         <p>
     *         The SM2PKE algorithm is only available in China Regions.
     * @see EncryptionAlgorithmSpec
     */
    public final String encryptionAlgorithmAsString() {
        return encryptionAlgorithm;
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
        hashCode = 31 * hashCode + Objects.hashCode(keyId());
        hashCode = 31 * hashCode + Objects.hashCode(plaintext());
        hashCode = 31 * hashCode + Objects.hashCode(hasEncryptionContext() ? encryptionContext() : null);
        hashCode = 31 * hashCode + Objects.hashCode(hasGrantTokens() ? grantTokens() : null);
        hashCode = 31 * hashCode + Objects.hashCode(encryptionAlgorithmAsString());
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
        if (!(obj instanceof EncryptRequest)) {
            return false;
        }
        EncryptRequest other = (EncryptRequest) obj;
        return Objects.equals(keyId(), other.keyId()) && Objects.equals(plaintext(), other.plaintext())
                && hasEncryptionContext() == other.hasEncryptionContext()
                && Objects.equals(encryptionContext(), other.encryptionContext()) && hasGrantTokens() == other.hasGrantTokens()
                && Objects.equals(grantTokens(), other.grantTokens())
                && Objects.equals(encryptionAlgorithmAsString(), other.encryptionAlgorithmAsString())
                && Objects.equals(dryRun(), other.dryRun());
    }

    /**
     * Returns a string representation of this object. This is useful for testing and debugging. Sensitive data will be
     * redacted from this string using a placeholder value.
     */
    @Override
    public final String toString() {
        return ToString.builder("EncryptRequest").add("KeyId", keyId())
                .add("Plaintext", plaintext() == null ? null : "*** Sensitive Data Redacted ***")
                .add("EncryptionContext", hasEncryptionContext() ? encryptionContext() : null)
                .add("GrantTokens", hasGrantTokens() ? grantTokens() : null)
                .add("EncryptionAlgorithm", encryptionAlgorithmAsString()).add("DryRun", dryRun()).build();
    }

    public final <T> Optional<T> getValueForField(String fieldName, Class<T> clazz) {
        switch (fieldName) {
        case "KeyId":
            return Optional.ofNullable(clazz.cast(keyId()));
        case "Plaintext":
            return Optional.ofNullable(clazz.cast(plaintext()));
        case "EncryptionContext":
            return Optional.ofNullable(clazz.cast(encryptionContext()));
        case "GrantTokens":
            return Optional.ofNullable(clazz.cast(grantTokens()));
        case "EncryptionAlgorithm":
            return Optional.ofNullable(clazz.cast(encryptionAlgorithmAsString()));
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
        map.put("KeyId", KEY_ID_FIELD);
        map.put("Plaintext", PLAINTEXT_FIELD);
        map.put("EncryptionContext", ENCRYPTION_CONTEXT_FIELD);
        map.put("GrantTokens", GRANT_TOKENS_FIELD);
        map.put("EncryptionAlgorithm", ENCRYPTION_ALGORITHM_FIELD);
        map.put("DryRun", DRY_RUN_FIELD);
        return Collections.unmodifiableMap(map);
    }

    private static <T> Function<Object, T> getter(Function<EncryptRequest, T> g) {
        return obj -> g.apply((EncryptRequest) obj);
    }

    private static <T> BiConsumer<Object, T> setter(BiConsumer<Builder, T> s) {
        return (obj, val) -> s.accept((Builder) obj, val);
    }

    @Mutable
    @NotThreadSafe
    public interface Builder extends KmsRequest.Builder, SdkPojo, CopyableBuilder<Builder, EncryptRequest> {
        /**
         * <p>
         * Identifies the KMS key to use in the encryption operation. The KMS key must have a <code>KeyUsage</code> of
         * <code>ENCRYPT_DECRYPT</code>. To find the <code>KeyUsage</code> of a KMS key, use the <a>DescribeKey</a>
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
         *        Identifies the KMS key to use in the encryption operation. The KMS key must have a
         *        <code>KeyUsage</code> of <code>ENCRYPT_DECRYPT</code>. To find the <code>KeyUsage</code> of a KMS key,
         *        use the <a>DescribeKey</a> operation.</p>
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
         * Data to be encrypted.
         * </p>
         * 
         * @param plaintext
         *        Data to be encrypted.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder plaintext(SdkBytes plaintext);

        /**
         * <p>
         * Specifies the encryption context that will be used to encrypt the data. An encryption context is valid only
         * for <a href="https://docs.aws.amazon.com/kms/latest/developerguide/concepts.html#cryptographic-operations">
         * cryptographic operations</a> with a symmetric encryption KMS key. The standard asymmetric encryption
         * algorithms and HMAC algorithms that KMS uses do not support an encryption context.
         * </p>
         * <important>
         * <p>
         * Do not include confidential or sensitive information in this field. This field may be displayed in plaintext
         * in CloudTrail logs and other output.
         * </p>
         * </important>
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
         *        Specifies the encryption context that will be used to encrypt the data. An encryption context is valid
         *        only for <a
         *        href="https://docs.aws.amazon.com/kms/latest/developerguide/concepts.html#cryptographic-operations"
         *        >cryptographic operations</a> with a symmetric encryption KMS key. The standard asymmetric encryption
         *        algorithms and HMAC algorithms that KMS uses do not support an encryption context. </p> <important>
         *        <p>
         *        Do not include confidential or sensitive information in this field. This field may be displayed in
         *        plaintext in CloudTrail logs and other output.
         *        </p>
         *        </important>
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
         * Specifies the encryption algorithm that KMS will use to encrypt the plaintext message. The algorithm must be
         * compatible with the KMS key that you specify.
         * </p>
         * <p>
         * This parameter is required only for asymmetric KMS keys. The default value, <code>SYMMETRIC_DEFAULT</code>,
         * is the algorithm used for symmetric encryption KMS keys. If you are using an asymmetric KMS key, we recommend
         * RSAES_OAEP_SHA_256.
         * </p>
         * <p>
         * The SM2PKE algorithm is only available in China Regions.
         * </p>
         * 
         * @param encryptionAlgorithm
         *        Specifies the encryption algorithm that KMS will use to encrypt the plaintext message. The algorithm
         *        must be compatible with the KMS key that you specify.</p>
         *        <p>
         *        This parameter is required only for asymmetric KMS keys. The default value,
         *        <code>SYMMETRIC_DEFAULT</code>, is the algorithm used for symmetric encryption KMS keys. If you are
         *        using an asymmetric KMS key, we recommend RSAES_OAEP_SHA_256.
         *        </p>
         *        <p>
         *        The SM2PKE algorithm is only available in China Regions.
         * @see EncryptionAlgorithmSpec
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see EncryptionAlgorithmSpec
         */
        Builder encryptionAlgorithm(String encryptionAlgorithm);

        /**
         * <p>
         * Specifies the encryption algorithm that KMS will use to encrypt the plaintext message. The algorithm must be
         * compatible with the KMS key that you specify.
         * </p>
         * <p>
         * This parameter is required only for asymmetric KMS keys. The default value, <code>SYMMETRIC_DEFAULT</code>,
         * is the algorithm used for symmetric encryption KMS keys. If you are using an asymmetric KMS key, we recommend
         * RSAES_OAEP_SHA_256.
         * </p>
         * <p>
         * The SM2PKE algorithm is only available in China Regions.
         * </p>
         * 
         * @param encryptionAlgorithm
         *        Specifies the encryption algorithm that KMS will use to encrypt the plaintext message. The algorithm
         *        must be compatible with the KMS key that you specify.</p>
         *        <p>
         *        This parameter is required only for asymmetric KMS keys. The default value,
         *        <code>SYMMETRIC_DEFAULT</code>, is the algorithm used for symmetric encryption KMS keys. If you are
         *        using an asymmetric KMS key, we recommend RSAES_OAEP_SHA_256.
         *        </p>
         *        <p>
         *        The SM2PKE algorithm is only available in China Regions.
         * @see EncryptionAlgorithmSpec
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see EncryptionAlgorithmSpec
         */
        Builder encryptionAlgorithm(EncryptionAlgorithmSpec encryptionAlgorithm);

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
        private String keyId;

        private SdkBytes plaintext;

        private Map<String, String> encryptionContext = DefaultSdkAutoConstructMap.getInstance();

        private List<String> grantTokens = DefaultSdkAutoConstructList.getInstance();

        private String encryptionAlgorithm;

        private Boolean dryRun;

        private BuilderImpl() {
        }

        private BuilderImpl(EncryptRequest model) {
            super(model);
            keyId(model.keyId);
            plaintext(model.plaintext);
            encryptionContext(model.encryptionContext);
            grantTokens(model.grantTokens);
            encryptionAlgorithm(model.encryptionAlgorithm);
            dryRun(model.dryRun);
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

        public final ByteBuffer getPlaintext() {
            return plaintext == null ? null : plaintext.asByteBuffer();
        }

        public final void setPlaintext(ByteBuffer plaintext) {
            plaintext(plaintext == null ? null : SdkBytes.fromByteBuffer(plaintext));
        }

        @Override
        public final Builder plaintext(SdkBytes plaintext) {
            this.plaintext = plaintext;
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
        public EncryptRequest build() {
            return new EncryptRequest(this);
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
