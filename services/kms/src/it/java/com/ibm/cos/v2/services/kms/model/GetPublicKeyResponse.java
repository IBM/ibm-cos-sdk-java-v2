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
import java.util.function.Function;
import com.ibm.cos.v2.annotations.Generated;
import com.ibm.cos.v2.annotations.Mutable;
import com.ibm.cos.v2.annotations.NotThreadSafe;
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
public final class GetPublicKeyResponse extends KmsResponse implements
        ToCopyableBuilder<GetPublicKeyResponse.Builder, GetPublicKeyResponse> {
    private static final SdkField<String> KEY_ID_FIELD = SdkField.<String> builder(MarshallingType.STRING).memberName("KeyId")
            .getter(getter(GetPublicKeyResponse::keyId)).setter(setter(Builder::keyId))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("KeyId").build()).build();

    private static final SdkField<SdkBytes> PUBLIC_KEY_FIELD = SdkField.<SdkBytes> builder(MarshallingType.SDK_BYTES)
            .memberName("PublicKey").getter(getter(GetPublicKeyResponse::publicKey)).setter(setter(Builder::publicKey))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("PublicKey").build()).build();

    private static final SdkField<String> CUSTOMER_MASTER_KEY_SPEC_FIELD = SdkField.<String> builder(MarshallingType.STRING)
            .memberName("CustomerMasterKeySpec").getter(getter(GetPublicKeyResponse::customerMasterKeySpecAsString))
            .setter(setter(Builder::customerMasterKeySpec))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("CustomerMasterKeySpec").build())
            .build();

    private static final SdkField<String> KEY_SPEC_FIELD = SdkField.<String> builder(MarshallingType.STRING)
            .memberName("KeySpec").getter(getter(GetPublicKeyResponse::keySpecAsString)).setter(setter(Builder::keySpec))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("KeySpec").build()).build();

    private static final SdkField<String> KEY_USAGE_FIELD = SdkField.<String> builder(MarshallingType.STRING)
            .memberName("KeyUsage").getter(getter(GetPublicKeyResponse::keyUsageAsString)).setter(setter(Builder::keyUsage))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("KeyUsage").build()).build();

    private static final SdkField<List<String>> ENCRYPTION_ALGORITHMS_FIELD = SdkField
            .<List<String>> builder(MarshallingType.LIST)
            .memberName("EncryptionAlgorithms")
            .getter(getter(GetPublicKeyResponse::encryptionAlgorithmsAsStrings))
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
            .getter(getter(GetPublicKeyResponse::signingAlgorithmsAsStrings))
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
            .getter(getter(GetPublicKeyResponse::keyAgreementAlgorithmsAsStrings))
            .setter(setter(Builder::keyAgreementAlgorithmsWithStrings))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("KeyAgreementAlgorithms").build(),
                    ListTrait
                            .builder()
                            .memberLocationName(null)
                            .memberFieldInfo(
                                    SdkField.<String> builder(MarshallingType.STRING)
                                            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD)
                                                    .locationName("member").build()).build()).build()).build();

    private static final List<SdkField<?>> SDK_FIELDS = Collections.unmodifiableList(Arrays.asList(KEY_ID_FIELD,
            PUBLIC_KEY_FIELD, CUSTOMER_MASTER_KEY_SPEC_FIELD, KEY_SPEC_FIELD, KEY_USAGE_FIELD, ENCRYPTION_ALGORITHMS_FIELD,
            SIGNING_ALGORITHMS_FIELD, KEY_AGREEMENT_ALGORITHMS_FIELD));

    private static final Map<String, SdkField<?>> SDK_NAME_TO_FIELD = memberNameToFieldInitializer();

    private final String keyId;

    private final SdkBytes publicKey;

    private final String customerMasterKeySpec;

    private final String keySpec;

    private final String keyUsage;

    private final List<String> encryptionAlgorithms;

    private final List<String> signingAlgorithms;

    private final List<String> keyAgreementAlgorithms;

    private GetPublicKeyResponse(BuilderImpl builder) {
        super(builder);
        this.keyId = builder.keyId;
        this.publicKey = builder.publicKey;
        this.customerMasterKeySpec = builder.customerMasterKeySpec;
        this.keySpec = builder.keySpec;
        this.keyUsage = builder.keyUsage;
        this.encryptionAlgorithms = builder.encryptionAlgorithms;
        this.signingAlgorithms = builder.signingAlgorithms;
        this.keyAgreementAlgorithms = builder.keyAgreementAlgorithms;
    }

    /**
     * <p>
     * The Amazon Resource Name (<a
     * href="https://docs.aws.amazon.com/kms/latest/developerguide/concepts.html#key-id-key-ARN">key ARN</a>) of the
     * asymmetric KMS key from which the public key was downloaded.
     * </p>
     * 
     * @return The Amazon Resource Name (<a
     *         href="https://docs.aws.amazon.com/kms/latest/developerguide/concepts.html#key-id-key-ARN">key ARN</a>) of
     *         the asymmetric KMS key from which the public key was downloaded.
     */
    public final String keyId() {
        return keyId;
    }

    /**
     * <p>
     * The exported public key.
     * </p>
     * <p>
     * The value is a DER-encoded X.509 public key, also known as <code>SubjectPublicKeyInfo</code> (SPKI), as defined
     * in <a href="https://tools.ietf.org/html/rfc5280">RFC 5280</a>. When you use the HTTP API or the Amazon Web
     * Services CLI, the value is Base64-encoded. Otherwise, it is not Base64-encoded.
     * </p>
     * <p/>
     * 
     * @return The exported public key.
     *         </p>
     *         <p>
     *         The value is a DER-encoded X.509 public key, also known as <code>SubjectPublicKeyInfo</code> (SPKI), as
     *         defined in <a href="https://tools.ietf.org/html/rfc5280">RFC 5280</a>. When you use the HTTP API or the
     *         Amazon Web Services CLI, the value is Base64-encoded. Otherwise, it is not Base64-encoded.
     *         </p>
     */
    public final SdkBytes publicKey() {
        return publicKey;
    }

    /**
     * <p>
     * Instead, use the <code>KeySpec</code> field in the <code>GetPublicKey</code> response.
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
     * @return Instead, use the <code>KeySpec</code> field in the <code>GetPublicKey</code> response.</p>
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
     * Instead, use the <code>KeySpec</code> field in the <code>GetPublicKey</code> response.
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
     * @return Instead, use the <code>KeySpec</code> field in the <code>GetPublicKey</code> response.</p>
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
     * The type of the of the public key that was downloaded.
     * </p>
     * <p>
     * If the service returns an enum value that is not available in the current SDK version, {@link #keySpec} will
     * return {@link KeySpec#UNKNOWN_TO_SDK_VERSION}. The raw value returned by the service is available from
     * {@link #keySpecAsString}.
     * </p>
     * 
     * @return The type of the of the public key that was downloaded.
     * @see KeySpec
     */
    public final KeySpec keySpec() {
        return KeySpec.fromValue(keySpec);
    }

    /**
     * <p>
     * The type of the of the public key that was downloaded.
     * </p>
     * <p>
     * If the service returns an enum value that is not available in the current SDK version, {@link #keySpec} will
     * return {@link KeySpec#UNKNOWN_TO_SDK_VERSION}. The raw value returned by the service is available from
     * {@link #keySpecAsString}.
     * </p>
     * 
     * @return The type of the of the public key that was downloaded.
     * @see KeySpec
     */
    public final String keySpecAsString() {
        return keySpec;
    }

    /**
     * <p>
     * The permitted use of the public key. Valid values for asymmetric key pairs are <code>ENCRYPT_DECRYPT</code>,
     * <code>SIGN_VERIFY</code>, and <code>KEY_AGREEMENT</code>.
     * </p>
     * <p>
     * This information is critical. For example, if a public key with <code>SIGN_VERIFY</code> key usage encrypts data
     * outside of KMS, the ciphertext cannot be decrypted.
     * </p>
     * <p>
     * If the service returns an enum value that is not available in the current SDK version, {@link #keyUsage} will
     * return {@link KeyUsageType#UNKNOWN_TO_SDK_VERSION}. The raw value returned by the service is available from
     * {@link #keyUsageAsString}.
     * </p>
     * 
     * @return The permitted use of the public key. Valid values for asymmetric key pairs are
     *         <code>ENCRYPT_DECRYPT</code>, <code>SIGN_VERIFY</code>, and <code>KEY_AGREEMENT</code>. </p>
     *         <p>
     *         This information is critical. For example, if a public key with <code>SIGN_VERIFY</code> key usage
     *         encrypts data outside of KMS, the ciphertext cannot be decrypted.
     * @see KeyUsageType
     */
    public final KeyUsageType keyUsage() {
        return KeyUsageType.fromValue(keyUsage);
    }

    /**
     * <p>
     * The permitted use of the public key. Valid values for asymmetric key pairs are <code>ENCRYPT_DECRYPT</code>,
     * <code>SIGN_VERIFY</code>, and <code>KEY_AGREEMENT</code>.
     * </p>
     * <p>
     * This information is critical. For example, if a public key with <code>SIGN_VERIFY</code> key usage encrypts data
     * outside of KMS, the ciphertext cannot be decrypted.
     * </p>
     * <p>
     * If the service returns an enum value that is not available in the current SDK version, {@link #keyUsage} will
     * return {@link KeyUsageType#UNKNOWN_TO_SDK_VERSION}. The raw value returned by the service is available from
     * {@link #keyUsageAsString}.
     * </p>
     * 
     * @return The permitted use of the public key. Valid values for asymmetric key pairs are
     *         <code>ENCRYPT_DECRYPT</code>, <code>SIGN_VERIFY</code>, and <code>KEY_AGREEMENT</code>. </p>
     *         <p>
     *         This information is critical. For example, if a public key with <code>SIGN_VERIFY</code> key usage
     *         encrypts data outside of KMS, the ciphertext cannot be decrypted.
     * @see KeyUsageType
     */
    public final String keyUsageAsString() {
        return keyUsage;
    }

    /**
     * <p>
     * The encryption algorithms that KMS supports for this key.
     * </p>
     * <p>
     * This information is critical. If a public key encrypts data outside of KMS by using an unsupported encryption
     * algorithm, the ciphertext cannot be decrypted.
     * </p>
     * <p>
     * This field appears in the response only when the <code>KeyUsage</code> of the public key is
     * <code>ENCRYPT_DECRYPT</code>.
     * </p>
     * <p>
     * Attempts to modify the collection returned by this method will result in an UnsupportedOperationException.
     * </p>
     * <p>
     * This method will never return null. If you would like to know whether the service returned this field (so that
     * you can differentiate between null and empty), you can use the {@link #hasEncryptionAlgorithms} method.
     * </p>
     * 
     * @return The encryption algorithms that KMS supports for this key. </p>
     *         <p>
     *         This information is critical. If a public key encrypts data outside of KMS by using an unsupported
     *         encryption algorithm, the ciphertext cannot be decrypted.
     *         </p>
     *         <p>
     *         This field appears in the response only when the <code>KeyUsage</code> of the public key is
     *         <code>ENCRYPT_DECRYPT</code>.
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
     * The encryption algorithms that KMS supports for this key.
     * </p>
     * <p>
     * This information is critical. If a public key encrypts data outside of KMS by using an unsupported encryption
     * algorithm, the ciphertext cannot be decrypted.
     * </p>
     * <p>
     * This field appears in the response only when the <code>KeyUsage</code> of the public key is
     * <code>ENCRYPT_DECRYPT</code>.
     * </p>
     * <p>
     * Attempts to modify the collection returned by this method will result in an UnsupportedOperationException.
     * </p>
     * <p>
     * This method will never return null. If you would like to know whether the service returned this field (so that
     * you can differentiate between null and empty), you can use the {@link #hasEncryptionAlgorithms} method.
     * </p>
     * 
     * @return The encryption algorithms that KMS supports for this key. </p>
     *         <p>
     *         This information is critical. If a public key encrypts data outside of KMS by using an unsupported
     *         encryption algorithm, the ciphertext cannot be decrypted.
     *         </p>
     *         <p>
     *         This field appears in the response only when the <code>KeyUsage</code> of the public key is
     *         <code>ENCRYPT_DECRYPT</code>.
     */
    public final List<String> encryptionAlgorithmsAsStrings() {
        return encryptionAlgorithms;
    }

    /**
     * <p>
     * The signing algorithms that KMS supports for this key.
     * </p>
     * <p>
     * This field appears in the response only when the <code>KeyUsage</code> of the public key is
     * <code>SIGN_VERIFY</code>.
     * </p>
     * <p>
     * Attempts to modify the collection returned by this method will result in an UnsupportedOperationException.
     * </p>
     * <p>
     * This method will never return null. If you would like to know whether the service returned this field (so that
     * you can differentiate between null and empty), you can use the {@link #hasSigningAlgorithms} method.
     * </p>
     * 
     * @return The signing algorithms that KMS supports for this key.</p>
     *         <p>
     *         This field appears in the response only when the <code>KeyUsage</code> of the public key is
     *         <code>SIGN_VERIFY</code>.
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
     * The signing algorithms that KMS supports for this key.
     * </p>
     * <p>
     * This field appears in the response only when the <code>KeyUsage</code> of the public key is
     * <code>SIGN_VERIFY</code>.
     * </p>
     * <p>
     * Attempts to modify the collection returned by this method will result in an UnsupportedOperationException.
     * </p>
     * <p>
     * This method will never return null. If you would like to know whether the service returned this field (so that
     * you can differentiate between null and empty), you can use the {@link #hasSigningAlgorithms} method.
     * </p>
     * 
     * @return The signing algorithms that KMS supports for this key.</p>
     *         <p>
     *         This field appears in the response only when the <code>KeyUsage</code> of the public key is
     *         <code>SIGN_VERIFY</code>.
     */
    public final List<String> signingAlgorithmsAsStrings() {
        return signingAlgorithms;
    }

    /**
     * <p>
     * The key agreement algorithm used to derive a shared secret. This field is present only when the KMS key has a
     * <code>KeyUsage</code> value of <code>KEY_AGREEMENT</code>.
     * </p>
     * <p>
     * Attempts to modify the collection returned by this method will result in an UnsupportedOperationException.
     * </p>
     * <p>
     * This method will never return null. If you would like to know whether the service returned this field (so that
     * you can differentiate between null and empty), you can use the {@link #hasKeyAgreementAlgorithms} method.
     * </p>
     * 
     * @return The key agreement algorithm used to derive a shared secret. This field is present only when the KMS key
     *         has a <code>KeyUsage</code> value of <code>KEY_AGREEMENT</code>.
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
     * The key agreement algorithm used to derive a shared secret. This field is present only when the KMS key has a
     * <code>KeyUsage</code> value of <code>KEY_AGREEMENT</code>.
     * </p>
     * <p>
     * Attempts to modify the collection returned by this method will result in an UnsupportedOperationException.
     * </p>
     * <p>
     * This method will never return null. If you would like to know whether the service returned this field (so that
     * you can differentiate between null and empty), you can use the {@link #hasKeyAgreementAlgorithms} method.
     * </p>
     * 
     * @return The key agreement algorithm used to derive a shared secret. This field is present only when the KMS key
     *         has a <code>KeyUsage</code> value of <code>KEY_AGREEMENT</code>.
     */
    public final List<String> keyAgreementAlgorithmsAsStrings() {
        return keyAgreementAlgorithms;
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
        hashCode = 31 * hashCode + Objects.hashCode(publicKey());
        hashCode = 31 * hashCode + Objects.hashCode(customerMasterKeySpecAsString());
        hashCode = 31 * hashCode + Objects.hashCode(keySpecAsString());
        hashCode = 31 * hashCode + Objects.hashCode(keyUsageAsString());
        hashCode = 31 * hashCode + Objects.hashCode(hasEncryptionAlgorithms() ? encryptionAlgorithmsAsStrings() : null);
        hashCode = 31 * hashCode + Objects.hashCode(hasSigningAlgorithms() ? signingAlgorithmsAsStrings() : null);
        hashCode = 31 * hashCode + Objects.hashCode(hasKeyAgreementAlgorithms() ? keyAgreementAlgorithmsAsStrings() : null);
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
        if (!(obj instanceof GetPublicKeyResponse)) {
            return false;
        }
        GetPublicKeyResponse other = (GetPublicKeyResponse) obj;
        return Objects.equals(keyId(), other.keyId()) && Objects.equals(publicKey(), other.publicKey())
                && Objects.equals(customerMasterKeySpecAsString(), other.customerMasterKeySpecAsString())
                && Objects.equals(keySpecAsString(), other.keySpecAsString())
                && Objects.equals(keyUsageAsString(), other.keyUsageAsString())
                && hasEncryptionAlgorithms() == other.hasEncryptionAlgorithms()
                && Objects.equals(encryptionAlgorithmsAsStrings(), other.encryptionAlgorithmsAsStrings())
                && hasSigningAlgorithms() == other.hasSigningAlgorithms()
                && Objects.equals(signingAlgorithmsAsStrings(), other.signingAlgorithmsAsStrings())
                && hasKeyAgreementAlgorithms() == other.hasKeyAgreementAlgorithms()
                && Objects.equals(keyAgreementAlgorithmsAsStrings(), other.keyAgreementAlgorithmsAsStrings());
    }

    /**
     * Returns a string representation of this object. This is useful for testing and debugging. Sensitive data will be
     * redacted from this string using a placeholder value.
     */
    @Override
    public final String toString() {
        return ToString.builder("GetPublicKeyResponse").add("KeyId", keyId()).add("PublicKey", publicKey())
                .add("CustomerMasterKeySpec", customerMasterKeySpecAsString()).add("KeySpec", keySpecAsString())
                .add("KeyUsage", keyUsageAsString())
                .add("EncryptionAlgorithms", hasEncryptionAlgorithms() ? encryptionAlgorithmsAsStrings() : null)
                .add("SigningAlgorithms", hasSigningAlgorithms() ? signingAlgorithmsAsStrings() : null)
                .add("KeyAgreementAlgorithms", hasKeyAgreementAlgorithms() ? keyAgreementAlgorithmsAsStrings() : null).build();
    }

    public final <T> Optional<T> getValueForField(String fieldName, Class<T> clazz) {
        switch (fieldName) {
        case "KeyId":
            return Optional.ofNullable(clazz.cast(keyId()));
        case "PublicKey":
            return Optional.ofNullable(clazz.cast(publicKey()));
        case "CustomerMasterKeySpec":
            return Optional.ofNullable(clazz.cast(customerMasterKeySpecAsString()));
        case "KeySpec":
            return Optional.ofNullable(clazz.cast(keySpecAsString()));
        case "KeyUsage":
            return Optional.ofNullable(clazz.cast(keyUsageAsString()));
        case "EncryptionAlgorithms":
            return Optional.ofNullable(clazz.cast(encryptionAlgorithmsAsStrings()));
        case "SigningAlgorithms":
            return Optional.ofNullable(clazz.cast(signingAlgorithmsAsStrings()));
        case "KeyAgreementAlgorithms":
            return Optional.ofNullable(clazz.cast(keyAgreementAlgorithmsAsStrings()));
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
        map.put("PublicKey", PUBLIC_KEY_FIELD);
        map.put("CustomerMasterKeySpec", CUSTOMER_MASTER_KEY_SPEC_FIELD);
        map.put("KeySpec", KEY_SPEC_FIELD);
        map.put("KeyUsage", KEY_USAGE_FIELD);
        map.put("EncryptionAlgorithms", ENCRYPTION_ALGORITHMS_FIELD);
        map.put("SigningAlgorithms", SIGNING_ALGORITHMS_FIELD);
        map.put("KeyAgreementAlgorithms", KEY_AGREEMENT_ALGORITHMS_FIELD);
        return Collections.unmodifiableMap(map);
    }

    private static <T> Function<Object, T> getter(Function<GetPublicKeyResponse, T> g) {
        return obj -> g.apply((GetPublicKeyResponse) obj);
    }

    private static <T> BiConsumer<Object, T> setter(BiConsumer<Builder, T> s) {
        return (obj, val) -> s.accept((Builder) obj, val);
    }

    @Mutable
    @NotThreadSafe
    public interface Builder extends KmsResponse.Builder, SdkPojo, CopyableBuilder<Builder, GetPublicKeyResponse> {
        /**
         * <p>
         * The Amazon Resource Name (<a
         * href="https://docs.aws.amazon.com/kms/latest/developerguide/concepts.html#key-id-key-ARN">key ARN</a>) of the
         * asymmetric KMS key from which the public key was downloaded.
         * </p>
         * 
         * @param keyId
         *        The Amazon Resource Name (<a
         *        href="https://docs.aws.amazon.com/kms/latest/developerguide/concepts.html#key-id-key-ARN">key ARN</a>)
         *        of the asymmetric KMS key from which the public key was downloaded.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder keyId(String keyId);

        /**
         * <p>
         * The exported public key.
         * </p>
         * <p>
         * The value is a DER-encoded X.509 public key, also known as <code>SubjectPublicKeyInfo</code> (SPKI), as
         * defined in <a href="https://tools.ietf.org/html/rfc5280">RFC 5280</a>. When you use the HTTP API or the
         * Amazon Web Services CLI, the value is Base64-encoded. Otherwise, it is not Base64-encoded.
         * </p>
         * <p/>
         * 
         * @param publicKey
         *        The exported public key.
         *        </p>
         *        <p>
         *        The value is a DER-encoded X.509 public key, also known as <code>SubjectPublicKeyInfo</code> (SPKI),
         *        as defined in <a href="https://tools.ietf.org/html/rfc5280">RFC 5280</a>. When you use the HTTP API or
         *        the Amazon Web Services CLI, the value is Base64-encoded. Otherwise, it is not Base64-encoded.
         *        </p>
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder publicKey(SdkBytes publicKey);

        /**
         * <p>
         * Instead, use the <code>KeySpec</code> field in the <code>GetPublicKey</code> response.
         * </p>
         * <p>
         * The <code>KeySpec</code> and <code>CustomerMasterKeySpec</code> fields have the same value. We recommend that
         * you use the <code>KeySpec</code> field in your code. However, to avoid breaking changes, KMS supports both
         * fields.
         * </p>
         * 
         * @param customerMasterKeySpec
         *        Instead, use the <code>KeySpec</code> field in the <code>GetPublicKey</code> response.</p>
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
         * Instead, use the <code>KeySpec</code> field in the <code>GetPublicKey</code> response.
         * </p>
         * <p>
         * The <code>KeySpec</code> and <code>CustomerMasterKeySpec</code> fields have the same value. We recommend that
         * you use the <code>KeySpec</code> field in your code. However, to avoid breaking changes, KMS supports both
         * fields.
         * </p>
         * 
         * @param customerMasterKeySpec
         *        Instead, use the <code>KeySpec</code> field in the <code>GetPublicKey</code> response.</p>
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
         * The type of the of the public key that was downloaded.
         * </p>
         * 
         * @param keySpec
         *        The type of the of the public key that was downloaded.
         * @see KeySpec
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see KeySpec
         */
        Builder keySpec(String keySpec);

        /**
         * <p>
         * The type of the of the public key that was downloaded.
         * </p>
         * 
         * @param keySpec
         *        The type of the of the public key that was downloaded.
         * @see KeySpec
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see KeySpec
         */
        Builder keySpec(KeySpec keySpec);

        /**
         * <p>
         * The permitted use of the public key. Valid values for asymmetric key pairs are <code>ENCRYPT_DECRYPT</code>,
         * <code>SIGN_VERIFY</code>, and <code>KEY_AGREEMENT</code>.
         * </p>
         * <p>
         * This information is critical. For example, if a public key with <code>SIGN_VERIFY</code> key usage encrypts
         * data outside of KMS, the ciphertext cannot be decrypted.
         * </p>
         * 
         * @param keyUsage
         *        The permitted use of the public key. Valid values for asymmetric key pairs are
         *        <code>ENCRYPT_DECRYPT</code>, <code>SIGN_VERIFY</code>, and <code>KEY_AGREEMENT</code>. </p>
         *        <p>
         *        This information is critical. For example, if a public key with <code>SIGN_VERIFY</code> key usage
         *        encrypts data outside of KMS, the ciphertext cannot be decrypted.
         * @see KeyUsageType
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see KeyUsageType
         */
        Builder keyUsage(String keyUsage);

        /**
         * <p>
         * The permitted use of the public key. Valid values for asymmetric key pairs are <code>ENCRYPT_DECRYPT</code>,
         * <code>SIGN_VERIFY</code>, and <code>KEY_AGREEMENT</code>.
         * </p>
         * <p>
         * This information is critical. For example, if a public key with <code>SIGN_VERIFY</code> key usage encrypts
         * data outside of KMS, the ciphertext cannot be decrypted.
         * </p>
         * 
         * @param keyUsage
         *        The permitted use of the public key. Valid values for asymmetric key pairs are
         *        <code>ENCRYPT_DECRYPT</code>, <code>SIGN_VERIFY</code>, and <code>KEY_AGREEMENT</code>. </p>
         *        <p>
         *        This information is critical. For example, if a public key with <code>SIGN_VERIFY</code> key usage
         *        encrypts data outside of KMS, the ciphertext cannot be decrypted.
         * @see KeyUsageType
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see KeyUsageType
         */
        Builder keyUsage(KeyUsageType keyUsage);

        /**
         * <p>
         * The encryption algorithms that KMS supports for this key.
         * </p>
         * <p>
         * This information is critical. If a public key encrypts data outside of KMS by using an unsupported encryption
         * algorithm, the ciphertext cannot be decrypted.
         * </p>
         * <p>
         * This field appears in the response only when the <code>KeyUsage</code> of the public key is
         * <code>ENCRYPT_DECRYPT</code>.
         * </p>
         * 
         * @param encryptionAlgorithms
         *        The encryption algorithms that KMS supports for this key. </p>
         *        <p>
         *        This information is critical. If a public key encrypts data outside of KMS by using an unsupported
         *        encryption algorithm, the ciphertext cannot be decrypted.
         *        </p>
         *        <p>
         *        This field appears in the response only when the <code>KeyUsage</code> of the public key is
         *        <code>ENCRYPT_DECRYPT</code>.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder encryptionAlgorithmsWithStrings(Collection<String> encryptionAlgorithms);

        /**
         * <p>
         * The encryption algorithms that KMS supports for this key.
         * </p>
         * <p>
         * This information is critical. If a public key encrypts data outside of KMS by using an unsupported encryption
         * algorithm, the ciphertext cannot be decrypted.
         * </p>
         * <p>
         * This field appears in the response only when the <code>KeyUsage</code> of the public key is
         * <code>ENCRYPT_DECRYPT</code>.
         * </p>
         * 
         * @param encryptionAlgorithms
         *        The encryption algorithms that KMS supports for this key. </p>
         *        <p>
         *        This information is critical. If a public key encrypts data outside of KMS by using an unsupported
         *        encryption algorithm, the ciphertext cannot be decrypted.
         *        </p>
         *        <p>
         *        This field appears in the response only when the <code>KeyUsage</code> of the public key is
         *        <code>ENCRYPT_DECRYPT</code>.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder encryptionAlgorithmsWithStrings(String... encryptionAlgorithms);

        /**
         * <p>
         * The encryption algorithms that KMS supports for this key.
         * </p>
         * <p>
         * This information is critical. If a public key encrypts data outside of KMS by using an unsupported encryption
         * algorithm, the ciphertext cannot be decrypted.
         * </p>
         * <p>
         * This field appears in the response only when the <code>KeyUsage</code> of the public key is
         * <code>ENCRYPT_DECRYPT</code>.
         * </p>
         * 
         * @param encryptionAlgorithms
         *        The encryption algorithms that KMS supports for this key. </p>
         *        <p>
         *        This information is critical. If a public key encrypts data outside of KMS by using an unsupported
         *        encryption algorithm, the ciphertext cannot be decrypted.
         *        </p>
         *        <p>
         *        This field appears in the response only when the <code>KeyUsage</code> of the public key is
         *        <code>ENCRYPT_DECRYPT</code>.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder encryptionAlgorithms(Collection<EncryptionAlgorithmSpec> encryptionAlgorithms);

        /**
         * <p>
         * The encryption algorithms that KMS supports for this key.
         * </p>
         * <p>
         * This information is critical. If a public key encrypts data outside of KMS by using an unsupported encryption
         * algorithm, the ciphertext cannot be decrypted.
         * </p>
         * <p>
         * This field appears in the response only when the <code>KeyUsage</code> of the public key is
         * <code>ENCRYPT_DECRYPT</code>.
         * </p>
         * 
         * @param encryptionAlgorithms
         *        The encryption algorithms that KMS supports for this key. </p>
         *        <p>
         *        This information is critical. If a public key encrypts data outside of KMS by using an unsupported
         *        encryption algorithm, the ciphertext cannot be decrypted.
         *        </p>
         *        <p>
         *        This field appears in the response only when the <code>KeyUsage</code> of the public key is
         *        <code>ENCRYPT_DECRYPT</code>.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder encryptionAlgorithms(EncryptionAlgorithmSpec... encryptionAlgorithms);

        /**
         * <p>
         * The signing algorithms that KMS supports for this key.
         * </p>
         * <p>
         * This field appears in the response only when the <code>KeyUsage</code> of the public key is
         * <code>SIGN_VERIFY</code>.
         * </p>
         * 
         * @param signingAlgorithms
         *        The signing algorithms that KMS supports for this key.</p>
         *        <p>
         *        This field appears in the response only when the <code>KeyUsage</code> of the public key is
         *        <code>SIGN_VERIFY</code>.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder signingAlgorithmsWithStrings(Collection<String> signingAlgorithms);

        /**
         * <p>
         * The signing algorithms that KMS supports for this key.
         * </p>
         * <p>
         * This field appears in the response only when the <code>KeyUsage</code> of the public key is
         * <code>SIGN_VERIFY</code>.
         * </p>
         * 
         * @param signingAlgorithms
         *        The signing algorithms that KMS supports for this key.</p>
         *        <p>
         *        This field appears in the response only when the <code>KeyUsage</code> of the public key is
         *        <code>SIGN_VERIFY</code>.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder signingAlgorithmsWithStrings(String... signingAlgorithms);

        /**
         * <p>
         * The signing algorithms that KMS supports for this key.
         * </p>
         * <p>
         * This field appears in the response only when the <code>KeyUsage</code> of the public key is
         * <code>SIGN_VERIFY</code>.
         * </p>
         * 
         * @param signingAlgorithms
         *        The signing algorithms that KMS supports for this key.</p>
         *        <p>
         *        This field appears in the response only when the <code>KeyUsage</code> of the public key is
         *        <code>SIGN_VERIFY</code>.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder signingAlgorithms(Collection<SigningAlgorithmSpec> signingAlgorithms);

        /**
         * <p>
         * The signing algorithms that KMS supports for this key.
         * </p>
         * <p>
         * This field appears in the response only when the <code>KeyUsage</code> of the public key is
         * <code>SIGN_VERIFY</code>.
         * </p>
         * 
         * @param signingAlgorithms
         *        The signing algorithms that KMS supports for this key.</p>
         *        <p>
         *        This field appears in the response only when the <code>KeyUsage</code> of the public key is
         *        <code>SIGN_VERIFY</code>.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder signingAlgorithms(SigningAlgorithmSpec... signingAlgorithms);

        /**
         * <p>
         * The key agreement algorithm used to derive a shared secret. This field is present only when the KMS key has a
         * <code>KeyUsage</code> value of <code>KEY_AGREEMENT</code>.
         * </p>
         * 
         * @param keyAgreementAlgorithms
         *        The key agreement algorithm used to derive a shared secret. This field is present only when the KMS
         *        key has a <code>KeyUsage</code> value of <code>KEY_AGREEMENT</code>.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder keyAgreementAlgorithmsWithStrings(Collection<String> keyAgreementAlgorithms);

        /**
         * <p>
         * The key agreement algorithm used to derive a shared secret. This field is present only when the KMS key has a
         * <code>KeyUsage</code> value of <code>KEY_AGREEMENT</code>.
         * </p>
         * 
         * @param keyAgreementAlgorithms
         *        The key agreement algorithm used to derive a shared secret. This field is present only when the KMS
         *        key has a <code>KeyUsage</code> value of <code>KEY_AGREEMENT</code>.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder keyAgreementAlgorithmsWithStrings(String... keyAgreementAlgorithms);

        /**
         * <p>
         * The key agreement algorithm used to derive a shared secret. This field is present only when the KMS key has a
         * <code>KeyUsage</code> value of <code>KEY_AGREEMENT</code>.
         * </p>
         * 
         * @param keyAgreementAlgorithms
         *        The key agreement algorithm used to derive a shared secret. This field is present only when the KMS
         *        key has a <code>KeyUsage</code> value of <code>KEY_AGREEMENT</code>.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder keyAgreementAlgorithms(Collection<KeyAgreementAlgorithmSpec> keyAgreementAlgorithms);

        /**
         * <p>
         * The key agreement algorithm used to derive a shared secret. This field is present only when the KMS key has a
         * <code>KeyUsage</code> value of <code>KEY_AGREEMENT</code>.
         * </p>
         * 
         * @param keyAgreementAlgorithms
         *        The key agreement algorithm used to derive a shared secret. This field is present only when the KMS
         *        key has a <code>KeyUsage</code> value of <code>KEY_AGREEMENT</code>.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder keyAgreementAlgorithms(KeyAgreementAlgorithmSpec... keyAgreementAlgorithms);
    }

    static final class BuilderImpl extends KmsResponse.BuilderImpl implements Builder {
        private String keyId;

        private SdkBytes publicKey;

        private String customerMasterKeySpec;

        private String keySpec;

        private String keyUsage;

        private List<String> encryptionAlgorithms = DefaultSdkAutoConstructList.getInstance();

        private List<String> signingAlgorithms = DefaultSdkAutoConstructList.getInstance();

        private List<String> keyAgreementAlgorithms = DefaultSdkAutoConstructList.getInstance();

        private BuilderImpl() {
        }

        private BuilderImpl(GetPublicKeyResponse model) {
            super(model);
            keyId(model.keyId);
            publicKey(model.publicKey);
            customerMasterKeySpec(model.customerMasterKeySpec);
            keySpec(model.keySpec);
            keyUsage(model.keyUsage);
            encryptionAlgorithmsWithStrings(model.encryptionAlgorithms);
            signingAlgorithmsWithStrings(model.signingAlgorithms);
            keyAgreementAlgorithmsWithStrings(model.keyAgreementAlgorithms);
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

        @Override
        public GetPublicKeyResponse build() {
            return new GetPublicKeyResponse(this);
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
