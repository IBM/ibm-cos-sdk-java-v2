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
public final class GetParametersForImportRequest extends KmsRequest implements
        ToCopyableBuilder<GetParametersForImportRequest.Builder, GetParametersForImportRequest> {
    private static final SdkField<String> KEY_ID_FIELD = SdkField.<String> builder(MarshallingType.STRING).memberName("KeyId")
            .getter(getter(GetParametersForImportRequest::keyId)).setter(setter(Builder::keyId))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("KeyId").build()).build();

    private static final SdkField<String> WRAPPING_ALGORITHM_FIELD = SdkField.<String> builder(MarshallingType.STRING)
            .memberName("WrappingAlgorithm").getter(getter(GetParametersForImportRequest::wrappingAlgorithmAsString))
            .setter(setter(Builder::wrappingAlgorithm))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("WrappingAlgorithm").build()).build();

    private static final SdkField<String> WRAPPING_KEY_SPEC_FIELD = SdkField.<String> builder(MarshallingType.STRING)
            .memberName("WrappingKeySpec").getter(getter(GetParametersForImportRequest::wrappingKeySpecAsString))
            .setter(setter(Builder::wrappingKeySpec))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("WrappingKeySpec").build()).build();

    private static final List<SdkField<?>> SDK_FIELDS = Collections.unmodifiableList(Arrays.asList(KEY_ID_FIELD,
            WRAPPING_ALGORITHM_FIELD, WRAPPING_KEY_SPEC_FIELD));

    private static final Map<String, SdkField<?>> SDK_NAME_TO_FIELD = memberNameToFieldInitializer();

    private final String keyId;

    private final String wrappingAlgorithm;

    private final String wrappingKeySpec;

    private GetParametersForImportRequest(BuilderImpl builder) {
        super(builder);
        this.keyId = builder.keyId;
        this.wrappingAlgorithm = builder.wrappingAlgorithm;
        this.wrappingKeySpec = builder.wrappingKeySpec;
    }

    /**
     * <p>
     * The identifier of the KMS key that will be associated with the imported key material. The <code>Origin</code> of
     * the KMS key must be <code>EXTERNAL</code>.
     * </p>
     * <p>
     * All KMS key types are supported, including multi-Region keys. However, you cannot import key material into a KMS
     * key in a custom key store.
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
     * @return The identifier of the KMS key that will be associated with the imported key material. The
     *         <code>Origin</code> of the KMS key must be <code>EXTERNAL</code>.</p>
     *         <p>
     *         All KMS key types are supported, including multi-Region keys. However, you cannot import key material
     *         into a KMS key in a custom key store.
     *         </p>
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
     * The algorithm you will use with the RSA public key (<code>PublicKey</code>) in the response to protect your key
     * material during import. For more information, see <a
     * href="kms/latest/developerguide/importing-keys-get-public-key-and-token.html#select-wrapping-algorithm">Select a
     * wrapping algorithm</a> in the <i>Key Management Service Developer Guide</i>.
     * </p>
     * <p>
     * For RSA_AES wrapping algorithms, you encrypt your key material with an AES key that you generate, then encrypt
     * your AES key with the RSA public key from KMS. For RSAES wrapping algorithms, you encrypt your key material
     * directly with the RSA public key from KMS.
     * </p>
     * <p>
     * The wrapping algorithms that you can use depend on the type of key material that you are importing. To import an
     * RSA private key, you must use an RSA_AES wrapping algorithm.
     * </p>
     * <ul>
     * <li>
     * <p>
     * <b>RSA_AES_KEY_WRAP_SHA_256</b> — Supported for wrapping RSA and ECC key material.
     * </p>
     * </li>
     * <li>
     * <p>
     * <b>RSA_AES_KEY_WRAP_SHA_1</b> — Supported for wrapping RSA and ECC key material.
     * </p>
     * </li>
     * <li>
     * <p>
     * <b>RSAES_OAEP_SHA_256</b> — Supported for all types of key material, except RSA key material (private key).
     * </p>
     * <p>
     * You cannot use the RSAES_OAEP_SHA_256 wrapping algorithm with the RSA_2048 wrapping key spec to wrap
     * ECC_NIST_P521 key material.
     * </p>
     * </li>
     * <li>
     * <p>
     * <b>RSAES_OAEP_SHA_1</b> — Supported for all types of key material, except RSA key material (private key).
     * </p>
     * <p>
     * You cannot use the RSAES_OAEP_SHA_1 wrapping algorithm with the RSA_2048 wrapping key spec to wrap ECC_NIST_P521
     * key material.
     * </p>
     * </li>
     * <li>
     * <p>
     * <b>RSAES_PKCS1_V1_5</b> (Deprecated) — As of October 10, 2023, KMS does not support the RSAES_PKCS1_V1_5 wrapping
     * algorithm.
     * </p>
     * </li>
     * </ul>
     * <p>
     * If the service returns an enum value that is not available in the current SDK version, {@link #wrappingAlgorithm}
     * will return {@link AlgorithmSpec#UNKNOWN_TO_SDK_VERSION}. The raw value returned by the service is available from
     * {@link #wrappingAlgorithmAsString}.
     * </p>
     * 
     * @return The algorithm you will use with the RSA public key (<code>PublicKey</code>) in the response to protect
     *         your key material during import. For more information, see <a
     *         href="kms/latest/developerguide/importing-keys-get-public-key-and-token.html#select-wrapping-algorithm"
     *         >Select a wrapping algorithm</a> in the <i>Key Management Service Developer Guide</i>.</p>
     *         <p>
     *         For RSA_AES wrapping algorithms, you encrypt your key material with an AES key that you generate, then
     *         encrypt your AES key with the RSA public key from KMS. For RSAES wrapping algorithms, you encrypt your
     *         key material directly with the RSA public key from KMS.
     *         </p>
     *         <p>
     *         The wrapping algorithms that you can use depend on the type of key material that you are importing. To
     *         import an RSA private key, you must use an RSA_AES wrapping algorithm.
     *         </p>
     *         <ul>
     *         <li>
     *         <p>
     *         <b>RSA_AES_KEY_WRAP_SHA_256</b> — Supported for wrapping RSA and ECC key material.
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         <b>RSA_AES_KEY_WRAP_SHA_1</b> — Supported for wrapping RSA and ECC key material.
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         <b>RSAES_OAEP_SHA_256</b> — Supported for all types of key material, except RSA key material (private
     *         key).
     *         </p>
     *         <p>
     *         You cannot use the RSAES_OAEP_SHA_256 wrapping algorithm with the RSA_2048 wrapping key spec to wrap
     *         ECC_NIST_P521 key material.
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         <b>RSAES_OAEP_SHA_1</b> — Supported for all types of key material, except RSA key material (private key).
     *         </p>
     *         <p>
     *         You cannot use the RSAES_OAEP_SHA_1 wrapping algorithm with the RSA_2048 wrapping key spec to wrap
     *         ECC_NIST_P521 key material.
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         <b>RSAES_PKCS1_V1_5</b> (Deprecated) — As of October 10, 2023, KMS does not support the RSAES_PKCS1_V1_5
     *         wrapping algorithm.
     *         </p>
     *         </li>
     * @see AlgorithmSpec
     */
    public final AlgorithmSpec wrappingAlgorithm() {
        return AlgorithmSpec.fromValue(wrappingAlgorithm);
    }

    /**
     * <p>
     * The algorithm you will use with the RSA public key (<code>PublicKey</code>) in the response to protect your key
     * material during import. For more information, see <a
     * href="kms/latest/developerguide/importing-keys-get-public-key-and-token.html#select-wrapping-algorithm">Select a
     * wrapping algorithm</a> in the <i>Key Management Service Developer Guide</i>.
     * </p>
     * <p>
     * For RSA_AES wrapping algorithms, you encrypt your key material with an AES key that you generate, then encrypt
     * your AES key with the RSA public key from KMS. For RSAES wrapping algorithms, you encrypt your key material
     * directly with the RSA public key from KMS.
     * </p>
     * <p>
     * The wrapping algorithms that you can use depend on the type of key material that you are importing. To import an
     * RSA private key, you must use an RSA_AES wrapping algorithm.
     * </p>
     * <ul>
     * <li>
     * <p>
     * <b>RSA_AES_KEY_WRAP_SHA_256</b> — Supported for wrapping RSA and ECC key material.
     * </p>
     * </li>
     * <li>
     * <p>
     * <b>RSA_AES_KEY_WRAP_SHA_1</b> — Supported for wrapping RSA and ECC key material.
     * </p>
     * </li>
     * <li>
     * <p>
     * <b>RSAES_OAEP_SHA_256</b> — Supported for all types of key material, except RSA key material (private key).
     * </p>
     * <p>
     * You cannot use the RSAES_OAEP_SHA_256 wrapping algorithm with the RSA_2048 wrapping key spec to wrap
     * ECC_NIST_P521 key material.
     * </p>
     * </li>
     * <li>
     * <p>
     * <b>RSAES_OAEP_SHA_1</b> — Supported for all types of key material, except RSA key material (private key).
     * </p>
     * <p>
     * You cannot use the RSAES_OAEP_SHA_1 wrapping algorithm with the RSA_2048 wrapping key spec to wrap ECC_NIST_P521
     * key material.
     * </p>
     * </li>
     * <li>
     * <p>
     * <b>RSAES_PKCS1_V1_5</b> (Deprecated) — As of October 10, 2023, KMS does not support the RSAES_PKCS1_V1_5 wrapping
     * algorithm.
     * </p>
     * </li>
     * </ul>
     * <p>
     * If the service returns an enum value that is not available in the current SDK version, {@link #wrappingAlgorithm}
     * will return {@link AlgorithmSpec#UNKNOWN_TO_SDK_VERSION}. The raw value returned by the service is available from
     * {@link #wrappingAlgorithmAsString}.
     * </p>
     * 
     * @return The algorithm you will use with the RSA public key (<code>PublicKey</code>) in the response to protect
     *         your key material during import. For more information, see <a
     *         href="kms/latest/developerguide/importing-keys-get-public-key-and-token.html#select-wrapping-algorithm"
     *         >Select a wrapping algorithm</a> in the <i>Key Management Service Developer Guide</i>.</p>
     *         <p>
     *         For RSA_AES wrapping algorithms, you encrypt your key material with an AES key that you generate, then
     *         encrypt your AES key with the RSA public key from KMS. For RSAES wrapping algorithms, you encrypt your
     *         key material directly with the RSA public key from KMS.
     *         </p>
     *         <p>
     *         The wrapping algorithms that you can use depend on the type of key material that you are importing. To
     *         import an RSA private key, you must use an RSA_AES wrapping algorithm.
     *         </p>
     *         <ul>
     *         <li>
     *         <p>
     *         <b>RSA_AES_KEY_WRAP_SHA_256</b> — Supported for wrapping RSA and ECC key material.
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         <b>RSA_AES_KEY_WRAP_SHA_1</b> — Supported for wrapping RSA and ECC key material.
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         <b>RSAES_OAEP_SHA_256</b> — Supported for all types of key material, except RSA key material (private
     *         key).
     *         </p>
     *         <p>
     *         You cannot use the RSAES_OAEP_SHA_256 wrapping algorithm with the RSA_2048 wrapping key spec to wrap
     *         ECC_NIST_P521 key material.
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         <b>RSAES_OAEP_SHA_1</b> — Supported for all types of key material, except RSA key material (private key).
     *         </p>
     *         <p>
     *         You cannot use the RSAES_OAEP_SHA_1 wrapping algorithm with the RSA_2048 wrapping key spec to wrap
     *         ECC_NIST_P521 key material.
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         <b>RSAES_PKCS1_V1_5</b> (Deprecated) — As of October 10, 2023, KMS does not support the RSAES_PKCS1_V1_5
     *         wrapping algorithm.
     *         </p>
     *         </li>
     * @see AlgorithmSpec
     */
    public final String wrappingAlgorithmAsString() {
        return wrappingAlgorithm;
    }

    /**
     * <p>
     * The type of RSA public key to return in the response. You will use this wrapping key with the specified wrapping
     * algorithm to protect your key material during import.
     * </p>
     * <p>
     * Use the longest RSA wrapping key that is practical.
     * </p>
     * <p>
     * You cannot use an RSA_2048 public key to directly wrap an ECC_NIST_P521 private key. Instead, use an RSA_AES
     * wrapping algorithm or choose a longer RSA public key.
     * </p>
     * <p>
     * If the service returns an enum value that is not available in the current SDK version, {@link #wrappingKeySpec}
     * will return {@link WrappingKeySpec#UNKNOWN_TO_SDK_VERSION}. The raw value returned by the service is available
     * from {@link #wrappingKeySpecAsString}.
     * </p>
     * 
     * @return The type of RSA public key to return in the response. You will use this wrapping key with the specified
     *         wrapping algorithm to protect your key material during import. </p>
     *         <p>
     *         Use the longest RSA wrapping key that is practical.
     *         </p>
     *         <p>
     *         You cannot use an RSA_2048 public key to directly wrap an ECC_NIST_P521 private key. Instead, use an
     *         RSA_AES wrapping algorithm or choose a longer RSA public key.
     * @see WrappingKeySpec
     */
    public final WrappingKeySpec wrappingKeySpec() {
        return WrappingKeySpec.fromValue(wrappingKeySpec);
    }

    /**
     * <p>
     * The type of RSA public key to return in the response. You will use this wrapping key with the specified wrapping
     * algorithm to protect your key material during import.
     * </p>
     * <p>
     * Use the longest RSA wrapping key that is practical.
     * </p>
     * <p>
     * You cannot use an RSA_2048 public key to directly wrap an ECC_NIST_P521 private key. Instead, use an RSA_AES
     * wrapping algorithm or choose a longer RSA public key.
     * </p>
     * <p>
     * If the service returns an enum value that is not available in the current SDK version, {@link #wrappingKeySpec}
     * will return {@link WrappingKeySpec#UNKNOWN_TO_SDK_VERSION}. The raw value returned by the service is available
     * from {@link #wrappingKeySpecAsString}.
     * </p>
     * 
     * @return The type of RSA public key to return in the response. You will use this wrapping key with the specified
     *         wrapping algorithm to protect your key material during import. </p>
     *         <p>
     *         Use the longest RSA wrapping key that is practical.
     *         </p>
     *         <p>
     *         You cannot use an RSA_2048 public key to directly wrap an ECC_NIST_P521 private key. Instead, use an
     *         RSA_AES wrapping algorithm or choose a longer RSA public key.
     * @see WrappingKeySpec
     */
    public final String wrappingKeySpecAsString() {
        return wrappingKeySpec;
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
        hashCode = 31 * hashCode + Objects.hashCode(wrappingAlgorithmAsString());
        hashCode = 31 * hashCode + Objects.hashCode(wrappingKeySpecAsString());
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
        if (!(obj instanceof GetParametersForImportRequest)) {
            return false;
        }
        GetParametersForImportRequest other = (GetParametersForImportRequest) obj;
        return Objects.equals(keyId(), other.keyId())
                && Objects.equals(wrappingAlgorithmAsString(), other.wrappingAlgorithmAsString())
                && Objects.equals(wrappingKeySpecAsString(), other.wrappingKeySpecAsString());
    }

    /**
     * Returns a string representation of this object. This is useful for testing and debugging. Sensitive data will be
     * redacted from this string using a placeholder value.
     */
    @Override
    public final String toString() {
        return ToString.builder("GetParametersForImportRequest").add("KeyId", keyId())
                .add("WrappingAlgorithm", wrappingAlgorithmAsString()).add("WrappingKeySpec", wrappingKeySpecAsString()).build();
    }

    public final <T> Optional<T> getValueForField(String fieldName, Class<T> clazz) {
        switch (fieldName) {
        case "KeyId":
            return Optional.ofNullable(clazz.cast(keyId()));
        case "WrappingAlgorithm":
            return Optional.ofNullable(clazz.cast(wrappingAlgorithmAsString()));
        case "WrappingKeySpec":
            return Optional.ofNullable(clazz.cast(wrappingKeySpecAsString()));
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
        map.put("WrappingAlgorithm", WRAPPING_ALGORITHM_FIELD);
        map.put("WrappingKeySpec", WRAPPING_KEY_SPEC_FIELD);
        return Collections.unmodifiableMap(map);
    }

    private static <T> Function<Object, T> getter(Function<GetParametersForImportRequest, T> g) {
        return obj -> g.apply((GetParametersForImportRequest) obj);
    }

    private static <T> BiConsumer<Object, T> setter(BiConsumer<Builder, T> s) {
        return (obj, val) -> s.accept((Builder) obj, val);
    }

    @Mutable
    @NotThreadSafe
    public interface Builder extends KmsRequest.Builder, SdkPojo, CopyableBuilder<Builder, GetParametersForImportRequest> {
        /**
         * <p>
         * The identifier of the KMS key that will be associated with the imported key material. The <code>Origin</code>
         * of the KMS key must be <code>EXTERNAL</code>.
         * </p>
         * <p>
         * All KMS key types are supported, including multi-Region keys. However, you cannot import key material into a
         * KMS key in a custom key store.
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
         *        The identifier of the KMS key that will be associated with the imported key material. The
         *        <code>Origin</code> of the KMS key must be <code>EXTERNAL</code>.</p>
         *        <p>
         *        All KMS key types are supported, including multi-Region keys. However, you cannot import key material
         *        into a KMS key in a custom key store.
         *        </p>
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
         * The algorithm you will use with the RSA public key (<code>PublicKey</code>) in the response to protect your
         * key material during import. For more information, see <a
         * href="kms/latest/developerguide/importing-keys-get-public-key-and-token.html#select-wrapping-algorithm"
         * >Select a wrapping algorithm</a> in the <i>Key Management Service Developer Guide</i>.
         * </p>
         * <p>
         * For RSA_AES wrapping algorithms, you encrypt your key material with an AES key that you generate, then
         * encrypt your AES key with the RSA public key from KMS. For RSAES wrapping algorithms, you encrypt your key
         * material directly with the RSA public key from KMS.
         * </p>
         * <p>
         * The wrapping algorithms that you can use depend on the type of key material that you are importing. To import
         * an RSA private key, you must use an RSA_AES wrapping algorithm.
         * </p>
         * <ul>
         * <li>
         * <p>
         * <b>RSA_AES_KEY_WRAP_SHA_256</b> — Supported for wrapping RSA and ECC key material.
         * </p>
         * </li>
         * <li>
         * <p>
         * <b>RSA_AES_KEY_WRAP_SHA_1</b> — Supported for wrapping RSA and ECC key material.
         * </p>
         * </li>
         * <li>
         * <p>
         * <b>RSAES_OAEP_SHA_256</b> — Supported for all types of key material, except RSA key material (private key).
         * </p>
         * <p>
         * You cannot use the RSAES_OAEP_SHA_256 wrapping algorithm with the RSA_2048 wrapping key spec to wrap
         * ECC_NIST_P521 key material.
         * </p>
         * </li>
         * <li>
         * <p>
         * <b>RSAES_OAEP_SHA_1</b> — Supported for all types of key material, except RSA key material (private key).
         * </p>
         * <p>
         * You cannot use the RSAES_OAEP_SHA_1 wrapping algorithm with the RSA_2048 wrapping key spec to wrap
         * ECC_NIST_P521 key material.
         * </p>
         * </li>
         * <li>
         * <p>
         * <b>RSAES_PKCS1_V1_5</b> (Deprecated) — As of October 10, 2023, KMS does not support the RSAES_PKCS1_V1_5
         * wrapping algorithm.
         * </p>
         * </li>
         * </ul>
         * 
         * @param wrappingAlgorithm
         *        The algorithm you will use with the RSA public key (<code>PublicKey</code>) in the response to protect
         *        your key material during import. For more information, see <a href=
         *        "kms/latest/developerguide/importing-keys-get-public-key-and-token.html#select-wrapping-algorithm"
         *        >Select a wrapping algorithm</a> in the <i>Key Management Service Developer Guide</i>.</p>
         *        <p>
         *        For RSA_AES wrapping algorithms, you encrypt your key material with an AES key that you generate, then
         *        encrypt your AES key with the RSA public key from KMS. For RSAES wrapping algorithms, you encrypt your
         *        key material directly with the RSA public key from KMS.
         *        </p>
         *        <p>
         *        The wrapping algorithms that you can use depend on the type of key material that you are importing. To
         *        import an RSA private key, you must use an RSA_AES wrapping algorithm.
         *        </p>
         *        <ul>
         *        <li>
         *        <p>
         *        <b>RSA_AES_KEY_WRAP_SHA_256</b> — Supported for wrapping RSA and ECC key material.
         *        </p>
         *        </li>
         *        <li>
         *        <p>
         *        <b>RSA_AES_KEY_WRAP_SHA_1</b> — Supported for wrapping RSA and ECC key material.
         *        </p>
         *        </li>
         *        <li>
         *        <p>
         *        <b>RSAES_OAEP_SHA_256</b> — Supported for all types of key material, except RSA key material (private
         *        key).
         *        </p>
         *        <p>
         *        You cannot use the RSAES_OAEP_SHA_256 wrapping algorithm with the RSA_2048 wrapping key spec to wrap
         *        ECC_NIST_P521 key material.
         *        </p>
         *        </li>
         *        <li>
         *        <p>
         *        <b>RSAES_OAEP_SHA_1</b> — Supported for all types of key material, except RSA key material (private
         *        key).
         *        </p>
         *        <p>
         *        You cannot use the RSAES_OAEP_SHA_1 wrapping algorithm with the RSA_2048 wrapping key spec to wrap
         *        ECC_NIST_P521 key material.
         *        </p>
         *        </li>
         *        <li>
         *        <p>
         *        <b>RSAES_PKCS1_V1_5</b> (Deprecated) — As of October 10, 2023, KMS does not support the
         *        RSAES_PKCS1_V1_5 wrapping algorithm.
         *        </p>
         *        </li>
         * @see AlgorithmSpec
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see AlgorithmSpec
         */
        Builder wrappingAlgorithm(String wrappingAlgorithm);

        /**
         * <p>
         * The algorithm you will use with the RSA public key (<code>PublicKey</code>) in the response to protect your
         * key material during import. For more information, see <a
         * href="kms/latest/developerguide/importing-keys-get-public-key-and-token.html#select-wrapping-algorithm"
         * >Select a wrapping algorithm</a> in the <i>Key Management Service Developer Guide</i>.
         * </p>
         * <p>
         * For RSA_AES wrapping algorithms, you encrypt your key material with an AES key that you generate, then
         * encrypt your AES key with the RSA public key from KMS. For RSAES wrapping algorithms, you encrypt your key
         * material directly with the RSA public key from KMS.
         * </p>
         * <p>
         * The wrapping algorithms that you can use depend on the type of key material that you are importing. To import
         * an RSA private key, you must use an RSA_AES wrapping algorithm.
         * </p>
         * <ul>
         * <li>
         * <p>
         * <b>RSA_AES_KEY_WRAP_SHA_256</b> — Supported for wrapping RSA and ECC key material.
         * </p>
         * </li>
         * <li>
         * <p>
         * <b>RSA_AES_KEY_WRAP_SHA_1</b> — Supported for wrapping RSA and ECC key material.
         * </p>
         * </li>
         * <li>
         * <p>
         * <b>RSAES_OAEP_SHA_256</b> — Supported for all types of key material, except RSA key material (private key).
         * </p>
         * <p>
         * You cannot use the RSAES_OAEP_SHA_256 wrapping algorithm with the RSA_2048 wrapping key spec to wrap
         * ECC_NIST_P521 key material.
         * </p>
         * </li>
         * <li>
         * <p>
         * <b>RSAES_OAEP_SHA_1</b> — Supported for all types of key material, except RSA key material (private key).
         * </p>
         * <p>
         * You cannot use the RSAES_OAEP_SHA_1 wrapping algorithm with the RSA_2048 wrapping key spec to wrap
         * ECC_NIST_P521 key material.
         * </p>
         * </li>
         * <li>
         * <p>
         * <b>RSAES_PKCS1_V1_5</b> (Deprecated) — As of October 10, 2023, KMS does not support the RSAES_PKCS1_V1_5
         * wrapping algorithm.
         * </p>
         * </li>
         * </ul>
         * 
         * @param wrappingAlgorithm
         *        The algorithm you will use with the RSA public key (<code>PublicKey</code>) in the response to protect
         *        your key material during import. For more information, see <a href=
         *        "kms/latest/developerguide/importing-keys-get-public-key-and-token.html#select-wrapping-algorithm"
         *        >Select a wrapping algorithm</a> in the <i>Key Management Service Developer Guide</i>.</p>
         *        <p>
         *        For RSA_AES wrapping algorithms, you encrypt your key material with an AES key that you generate, then
         *        encrypt your AES key with the RSA public key from KMS. For RSAES wrapping algorithms, you encrypt your
         *        key material directly with the RSA public key from KMS.
         *        </p>
         *        <p>
         *        The wrapping algorithms that you can use depend on the type of key material that you are importing. To
         *        import an RSA private key, you must use an RSA_AES wrapping algorithm.
         *        </p>
         *        <ul>
         *        <li>
         *        <p>
         *        <b>RSA_AES_KEY_WRAP_SHA_256</b> — Supported for wrapping RSA and ECC key material.
         *        </p>
         *        </li>
         *        <li>
         *        <p>
         *        <b>RSA_AES_KEY_WRAP_SHA_1</b> — Supported for wrapping RSA and ECC key material.
         *        </p>
         *        </li>
         *        <li>
         *        <p>
         *        <b>RSAES_OAEP_SHA_256</b> — Supported for all types of key material, except RSA key material (private
         *        key).
         *        </p>
         *        <p>
         *        You cannot use the RSAES_OAEP_SHA_256 wrapping algorithm with the RSA_2048 wrapping key spec to wrap
         *        ECC_NIST_P521 key material.
         *        </p>
         *        </li>
         *        <li>
         *        <p>
         *        <b>RSAES_OAEP_SHA_1</b> — Supported for all types of key material, except RSA key material (private
         *        key).
         *        </p>
         *        <p>
         *        You cannot use the RSAES_OAEP_SHA_1 wrapping algorithm with the RSA_2048 wrapping key spec to wrap
         *        ECC_NIST_P521 key material.
         *        </p>
         *        </li>
         *        <li>
         *        <p>
         *        <b>RSAES_PKCS1_V1_5</b> (Deprecated) — As of October 10, 2023, KMS does not support the
         *        RSAES_PKCS1_V1_5 wrapping algorithm.
         *        </p>
         *        </li>
         * @see AlgorithmSpec
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see AlgorithmSpec
         */
        Builder wrappingAlgorithm(AlgorithmSpec wrappingAlgorithm);

        /**
         * <p>
         * The type of RSA public key to return in the response. You will use this wrapping key with the specified
         * wrapping algorithm to protect your key material during import.
         * </p>
         * <p>
         * Use the longest RSA wrapping key that is practical.
         * </p>
         * <p>
         * You cannot use an RSA_2048 public key to directly wrap an ECC_NIST_P521 private key. Instead, use an RSA_AES
         * wrapping algorithm or choose a longer RSA public key.
         * </p>
         * 
         * @param wrappingKeySpec
         *        The type of RSA public key to return in the response. You will use this wrapping key with the
         *        specified wrapping algorithm to protect your key material during import. </p>
         *        <p>
         *        Use the longest RSA wrapping key that is practical.
         *        </p>
         *        <p>
         *        You cannot use an RSA_2048 public key to directly wrap an ECC_NIST_P521 private key. Instead, use an
         *        RSA_AES wrapping algorithm or choose a longer RSA public key.
         * @see WrappingKeySpec
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see WrappingKeySpec
         */
        Builder wrappingKeySpec(String wrappingKeySpec);

        /**
         * <p>
         * The type of RSA public key to return in the response. You will use this wrapping key with the specified
         * wrapping algorithm to protect your key material during import.
         * </p>
         * <p>
         * Use the longest RSA wrapping key that is practical.
         * </p>
         * <p>
         * You cannot use an RSA_2048 public key to directly wrap an ECC_NIST_P521 private key. Instead, use an RSA_AES
         * wrapping algorithm or choose a longer RSA public key.
         * </p>
         * 
         * @param wrappingKeySpec
         *        The type of RSA public key to return in the response. You will use this wrapping key with the
         *        specified wrapping algorithm to protect your key material during import. </p>
         *        <p>
         *        Use the longest RSA wrapping key that is practical.
         *        </p>
         *        <p>
         *        You cannot use an RSA_2048 public key to directly wrap an ECC_NIST_P521 private key. Instead, use an
         *        RSA_AES wrapping algorithm or choose a longer RSA public key.
         * @see WrappingKeySpec
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see WrappingKeySpec
         */
        Builder wrappingKeySpec(WrappingKeySpec wrappingKeySpec);

        @Override
        Builder overrideConfiguration(AwsRequestOverrideConfiguration overrideConfiguration);

        @Override
        Builder overrideConfiguration(Consumer<AwsRequestOverrideConfiguration.Builder> builderConsumer);
    }

    static final class BuilderImpl extends KmsRequest.BuilderImpl implements Builder {
        private String keyId;

        private String wrappingAlgorithm;

        private String wrappingKeySpec;

        private BuilderImpl() {
        }

        private BuilderImpl(GetParametersForImportRequest model) {
            super(model);
            keyId(model.keyId);
            wrappingAlgorithm(model.wrappingAlgorithm);
            wrappingKeySpec(model.wrappingKeySpec);
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

        public final String getWrappingAlgorithm() {
            return wrappingAlgorithm;
        }

        public final void setWrappingAlgorithm(String wrappingAlgorithm) {
            this.wrappingAlgorithm = wrappingAlgorithm;
        }

        @Override
        public final Builder wrappingAlgorithm(String wrappingAlgorithm) {
            this.wrappingAlgorithm = wrappingAlgorithm;
            return this;
        }

        @Override
        public final Builder wrappingAlgorithm(AlgorithmSpec wrappingAlgorithm) {
            this.wrappingAlgorithm(wrappingAlgorithm == null ? null : wrappingAlgorithm.toString());
            return this;
        }

        public final String getWrappingKeySpec() {
            return wrappingKeySpec;
        }

        public final void setWrappingKeySpec(String wrappingKeySpec) {
            this.wrappingKeySpec = wrappingKeySpec;
        }

        @Override
        public final Builder wrappingKeySpec(String wrappingKeySpec) {
            this.wrappingKeySpec = wrappingKeySpec;
            return this;
        }

        @Override
        public final Builder wrappingKeySpec(WrappingKeySpec wrappingKeySpec) {
            this.wrappingKeySpec(wrappingKeySpec == null ? null : wrappingKeySpec.toString());
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
        public GetParametersForImportRequest build() {
            return new GetParametersForImportRequest(this);
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
