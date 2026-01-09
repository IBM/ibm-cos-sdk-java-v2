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
import java.time.Instant;
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
import com.ibm.cos.v2.core.SdkBytes;
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
public final class ImportKeyMaterialRequest extends KmsRequest implements
        ToCopyableBuilder<ImportKeyMaterialRequest.Builder, ImportKeyMaterialRequest> {
    private static final SdkField<String> KEY_ID_FIELD = SdkField.<String> builder(MarshallingType.STRING).memberName("KeyId")
            .getter(getter(ImportKeyMaterialRequest::keyId)).setter(setter(Builder::keyId))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("KeyId").build()).build();

    private static final SdkField<SdkBytes> IMPORT_TOKEN_FIELD = SdkField.<SdkBytes> builder(MarshallingType.SDK_BYTES)
            .memberName("ImportToken").getter(getter(ImportKeyMaterialRequest::importToken)).setter(setter(Builder::importToken))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("ImportToken").build()).build();

    private static final SdkField<SdkBytes> ENCRYPTED_KEY_MATERIAL_FIELD = SdkField.<SdkBytes> builder(MarshallingType.SDK_BYTES)
            .memberName("EncryptedKeyMaterial").getter(getter(ImportKeyMaterialRequest::encryptedKeyMaterial))
            .setter(setter(Builder::encryptedKeyMaterial))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("EncryptedKeyMaterial").build())
            .build();

    private static final SdkField<Instant> VALID_TO_FIELD = SdkField.<Instant> builder(MarshallingType.INSTANT)
            .memberName("ValidTo").getter(getter(ImportKeyMaterialRequest::validTo)).setter(setter(Builder::validTo))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("ValidTo").build()).build();

    private static final SdkField<String> EXPIRATION_MODEL_FIELD = SdkField.<String> builder(MarshallingType.STRING)
            .memberName("ExpirationModel").getter(getter(ImportKeyMaterialRequest::expirationModelAsString))
            .setter(setter(Builder::expirationModel))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("ExpirationModel").build()).build();

    private static final List<SdkField<?>> SDK_FIELDS = Collections.unmodifiableList(Arrays.asList(KEY_ID_FIELD,
            IMPORT_TOKEN_FIELD, ENCRYPTED_KEY_MATERIAL_FIELD, VALID_TO_FIELD, EXPIRATION_MODEL_FIELD));

    private static final Map<String, SdkField<?>> SDK_NAME_TO_FIELD = memberNameToFieldInitializer();

    private final String keyId;

    private final SdkBytes importToken;

    private final SdkBytes encryptedKeyMaterial;

    private final Instant validTo;

    private final String expirationModel;

    private ImportKeyMaterialRequest(BuilderImpl builder) {
        super(builder);
        this.keyId = builder.keyId;
        this.importToken = builder.importToken;
        this.encryptedKeyMaterial = builder.encryptedKeyMaterial;
        this.validTo = builder.validTo;
        this.expirationModel = builder.expirationModel;
    }

    /**
     * <p>
     * The identifier of the KMS key that will be associated with the imported key material. This must be the same KMS
     * key specified in the <code>KeyID</code> parameter of the corresponding <a>GetParametersForImport</a> request. The
     * <code>Origin</code> of the KMS key must be <code>EXTERNAL</code> and its <code>KeyState</code> must be
     * <code>PendingImport</code>.
     * </p>
     * <p>
     * The KMS key can be a symmetric encryption KMS key, HMAC KMS key, asymmetric encryption KMS key, or asymmetric
     * signing KMS key, including a <a href="kms/latest/developerguide/multi-region-keys-overview.html">multi-Region
     * key</a> of any supported type. You cannot perform this operation on a KMS key in a custom key store, or on a KMS
     * key in a different Amazon Web Services account.
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
     * @return The identifier of the KMS key that will be associated with the imported key material. This must be the
     *         same KMS key specified in the <code>KeyID</code> parameter of the corresponding
     *         <a>GetParametersForImport</a> request. The <code>Origin</code> of the KMS key must be
     *         <code>EXTERNAL</code> and its <code>KeyState</code> must be <code>PendingImport</code>. </p>
     *         <p>
     *         The KMS key can be a symmetric encryption KMS key, HMAC KMS key, asymmetric encryption KMS key, or
     *         asymmetric signing KMS key, including a <a
     *         href="kms/latest/developerguide/multi-region-keys-overview.html">multi-Region key</a> of any supported
     *         type. You cannot perform this operation on a KMS key in a custom key store, or on a KMS key in a
     *         different Amazon Web Services account.
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
     * The import token that you received in the response to a previous <a>GetParametersForImport</a> request. It must
     * be from the same response that contained the public key that you used to encrypt the key material.
     * </p>
     * 
     * @return The import token that you received in the response to a previous <a>GetParametersForImport</a> request.
     *         It must be from the same response that contained the public key that you used to encrypt the key
     *         material.
     */
    public final SdkBytes importToken() {
        return importToken;
    }

    /**
     * <p>
     * The encrypted key material to import. The key material must be encrypted under the public wrapping key that
     * <a>GetParametersForImport</a> returned, using the wrapping algorithm that you specified in the same
     * <code>GetParametersForImport</code> request.
     * </p>
     * 
     * @return The encrypted key material to import. The key material must be encrypted under the public wrapping key
     *         that <a>GetParametersForImport</a> returned, using the wrapping algorithm that you specified in the same
     *         <code>GetParametersForImport</code> request.
     */
    public final SdkBytes encryptedKeyMaterial() {
        return encryptedKeyMaterial;
    }

    /**
     * <p>
     * The date and time when the imported key material expires. This parameter is required when the value of the
     * <code>ExpirationModel</code> parameter is <code>KEY_MATERIAL_EXPIRES</code>. Otherwise it is not valid.
     * </p>
     * <p>
     * The value of this parameter must be a future date and time. The maximum value is 365 days from the request date.
     * </p>
     * <p>
     * When the key material expires, KMS deletes the key material from the KMS key. Without its key material, the KMS
     * key is unusable. To use the KMS key in cryptographic operations, you must reimport the same key material.
     * </p>
     * <p>
     * You cannot change the <code>ExpirationModel</code> or <code>ValidTo</code> values for the current import after
     * the request completes. To change either value, you must delete (<a>DeleteImportedKeyMaterial</a>) and reimport
     * the key material.
     * </p>
     * 
     * @return The date and time when the imported key material expires. This parameter is required when the value of
     *         the <code>ExpirationModel</code> parameter is <code>KEY_MATERIAL_EXPIRES</code>. Otherwise it is not
     *         valid.</p>
     *         <p>
     *         The value of this parameter must be a future date and time. The maximum value is 365 days from the
     *         request date.
     *         </p>
     *         <p>
     *         When the key material expires, KMS deletes the key material from the KMS key. Without its key material,
     *         the KMS key is unusable. To use the KMS key in cryptographic operations, you must reimport the same key
     *         material.
     *         </p>
     *         <p>
     *         You cannot change the <code>ExpirationModel</code> or <code>ValidTo</code> values for the current import
     *         after the request completes. To change either value, you must delete (<a>DeleteImportedKeyMaterial</a>)
     *         and reimport the key material.
     */
    public final Instant validTo() {
        return validTo;
    }

    /**
     * <p>
     * Specifies whether the key material expires. The default is <code>KEY_MATERIAL_EXPIRES</code>. For help with this
     * choice, see <a href=
     * "https://docs.aws.amazon.com/en_us/kms/latest/developerguide/importing-keys.html#importing-keys-expiration"
     * >Setting an expiration time</a> in the <i>Key Management Service Developer Guide</i>.
     * </p>
     * <p>
     * When the value of <code>ExpirationModel</code> is <code>KEY_MATERIAL_EXPIRES</code>, you must specify a value for
     * the <code>ValidTo</code> parameter. When value is <code>KEY_MATERIAL_DOES_NOT_EXPIRE</code>, you must omit the
     * <code>ValidTo</code> parameter.
     * </p>
     * <p>
     * You cannot change the <code>ExpirationModel</code> or <code>ValidTo</code> values for the current import after
     * the request completes. To change either value, you must reimport the key material.
     * </p>
     * <p>
     * If the service returns an enum value that is not available in the current SDK version, {@link #expirationModel}
     * will return {@link ExpirationModelType#UNKNOWN_TO_SDK_VERSION}. The raw value returned by the service is
     * available from {@link #expirationModelAsString}.
     * </p>
     * 
     * @return Specifies whether the key material expires. The default is <code>KEY_MATERIAL_EXPIRES</code>. For help
     *         with this choice, see <a href=
     *         "https://docs.aws.amazon.com/en_us/kms/latest/developerguide/importing-keys.html#importing-keys-expiration"
     *         >Setting an expiration time</a> in the <i>Key Management Service Developer Guide</i>.</p>
     *         <p>
     *         When the value of <code>ExpirationModel</code> is <code>KEY_MATERIAL_EXPIRES</code>, you must specify a
     *         value for the <code>ValidTo</code> parameter. When value is <code>KEY_MATERIAL_DOES_NOT_EXPIRE</code>,
     *         you must omit the <code>ValidTo</code> parameter.
     *         </p>
     *         <p>
     *         You cannot change the <code>ExpirationModel</code> or <code>ValidTo</code> values for the current import
     *         after the request completes. To change either value, you must reimport the key material.
     * @see ExpirationModelType
     */
    public final ExpirationModelType expirationModel() {
        return ExpirationModelType.fromValue(expirationModel);
    }

    /**
     * <p>
     * Specifies whether the key material expires. The default is <code>KEY_MATERIAL_EXPIRES</code>. For help with this
     * choice, see <a href=
     * "https://docs.aws.amazon.com/en_us/kms/latest/developerguide/importing-keys.html#importing-keys-expiration"
     * >Setting an expiration time</a> in the <i>Key Management Service Developer Guide</i>.
     * </p>
     * <p>
     * When the value of <code>ExpirationModel</code> is <code>KEY_MATERIAL_EXPIRES</code>, you must specify a value for
     * the <code>ValidTo</code> parameter. When value is <code>KEY_MATERIAL_DOES_NOT_EXPIRE</code>, you must omit the
     * <code>ValidTo</code> parameter.
     * </p>
     * <p>
     * You cannot change the <code>ExpirationModel</code> or <code>ValidTo</code> values for the current import after
     * the request completes. To change either value, you must reimport the key material.
     * </p>
     * <p>
     * If the service returns an enum value that is not available in the current SDK version, {@link #expirationModel}
     * will return {@link ExpirationModelType#UNKNOWN_TO_SDK_VERSION}. The raw value returned by the service is
     * available from {@link #expirationModelAsString}.
     * </p>
     * 
     * @return Specifies whether the key material expires. The default is <code>KEY_MATERIAL_EXPIRES</code>. For help
     *         with this choice, see <a href=
     *         "https://docs.aws.amazon.com/en_us/kms/latest/developerguide/importing-keys.html#importing-keys-expiration"
     *         >Setting an expiration time</a> in the <i>Key Management Service Developer Guide</i>.</p>
     *         <p>
     *         When the value of <code>ExpirationModel</code> is <code>KEY_MATERIAL_EXPIRES</code>, you must specify a
     *         value for the <code>ValidTo</code> parameter. When value is <code>KEY_MATERIAL_DOES_NOT_EXPIRE</code>,
     *         you must omit the <code>ValidTo</code> parameter.
     *         </p>
     *         <p>
     *         You cannot change the <code>ExpirationModel</code> or <code>ValidTo</code> values for the current import
     *         after the request completes. To change either value, you must reimport the key material.
     * @see ExpirationModelType
     */
    public final String expirationModelAsString() {
        return expirationModel;
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
        hashCode = 31 * hashCode + Objects.hashCode(importToken());
        hashCode = 31 * hashCode + Objects.hashCode(encryptedKeyMaterial());
        hashCode = 31 * hashCode + Objects.hashCode(validTo());
        hashCode = 31 * hashCode + Objects.hashCode(expirationModelAsString());
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
        if (!(obj instanceof ImportKeyMaterialRequest)) {
            return false;
        }
        ImportKeyMaterialRequest other = (ImportKeyMaterialRequest) obj;
        return Objects.equals(keyId(), other.keyId()) && Objects.equals(importToken(), other.importToken())
                && Objects.equals(encryptedKeyMaterial(), other.encryptedKeyMaterial())
                && Objects.equals(validTo(), other.validTo())
                && Objects.equals(expirationModelAsString(), other.expirationModelAsString());
    }

    /**
     * Returns a string representation of this object. This is useful for testing and debugging. Sensitive data will be
     * redacted from this string using a placeholder value.
     */
    @Override
    public final String toString() {
        return ToString.builder("ImportKeyMaterialRequest").add("KeyId", keyId()).add("ImportToken", importToken())
                .add("EncryptedKeyMaterial", encryptedKeyMaterial()).add("ValidTo", validTo())
                .add("ExpirationModel", expirationModelAsString()).build();
    }

    public final <T> Optional<T> getValueForField(String fieldName, Class<T> clazz) {
        switch (fieldName) {
        case "KeyId":
            return Optional.ofNullable(clazz.cast(keyId()));
        case "ImportToken":
            return Optional.ofNullable(clazz.cast(importToken()));
        case "EncryptedKeyMaterial":
            return Optional.ofNullable(clazz.cast(encryptedKeyMaterial()));
        case "ValidTo":
            return Optional.ofNullable(clazz.cast(validTo()));
        case "ExpirationModel":
            return Optional.ofNullable(clazz.cast(expirationModelAsString()));
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
        map.put("ImportToken", IMPORT_TOKEN_FIELD);
        map.put("EncryptedKeyMaterial", ENCRYPTED_KEY_MATERIAL_FIELD);
        map.put("ValidTo", VALID_TO_FIELD);
        map.put("ExpirationModel", EXPIRATION_MODEL_FIELD);
        return Collections.unmodifiableMap(map);
    }

    private static <T> Function<Object, T> getter(Function<ImportKeyMaterialRequest, T> g) {
        return obj -> g.apply((ImportKeyMaterialRequest) obj);
    }

    private static <T> BiConsumer<Object, T> setter(BiConsumer<Builder, T> s) {
        return (obj, val) -> s.accept((Builder) obj, val);
    }

    @Mutable
    @NotThreadSafe
    public interface Builder extends KmsRequest.Builder, SdkPojo, CopyableBuilder<Builder, ImportKeyMaterialRequest> {
        /**
         * <p>
         * The identifier of the KMS key that will be associated with the imported key material. This must be the same
         * KMS key specified in the <code>KeyID</code> parameter of the corresponding <a>GetParametersForImport</a>
         * request. The <code>Origin</code> of the KMS key must be <code>EXTERNAL</code> and its <code>KeyState</code>
         * must be <code>PendingImport</code>.
         * </p>
         * <p>
         * The KMS key can be a symmetric encryption KMS key, HMAC KMS key, asymmetric encryption KMS key, or asymmetric
         * signing KMS key, including a <a href="kms/latest/developerguide/multi-region-keys-overview.html">multi-Region
         * key</a> of any supported type. You cannot perform this operation on a KMS key in a custom key store, or on a
         * KMS key in a different Amazon Web Services account.
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
         *        The identifier of the KMS key that will be associated with the imported key material. This must be the
         *        same KMS key specified in the <code>KeyID</code> parameter of the corresponding
         *        <a>GetParametersForImport</a> request. The <code>Origin</code> of the KMS key must be
         *        <code>EXTERNAL</code> and its <code>KeyState</code> must be <code>PendingImport</code>. </p>
         *        <p>
         *        The KMS key can be a symmetric encryption KMS key, HMAC KMS key, asymmetric encryption KMS key, or
         *        asymmetric signing KMS key, including a <a
         *        href="kms/latest/developerguide/multi-region-keys-overview.html">multi-Region key</a> of any supported
         *        type. You cannot perform this operation on a KMS key in a custom key store, or on a KMS key in a
         *        different Amazon Web Services account.
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
         * The import token that you received in the response to a previous <a>GetParametersForImport</a> request. It
         * must be from the same response that contained the public key that you used to encrypt the key material.
         * </p>
         * 
         * @param importToken
         *        The import token that you received in the response to a previous <a>GetParametersForImport</a>
         *        request. It must be from the same response that contained the public key that you used to encrypt the
         *        key material.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder importToken(SdkBytes importToken);

        /**
         * <p>
         * The encrypted key material to import. The key material must be encrypted under the public wrapping key that
         * <a>GetParametersForImport</a> returned, using the wrapping algorithm that you specified in the same
         * <code>GetParametersForImport</code> request.
         * </p>
         * 
         * @param encryptedKeyMaterial
         *        The encrypted key material to import. The key material must be encrypted under the public wrapping key
         *        that <a>GetParametersForImport</a> returned, using the wrapping algorithm that you specified in the
         *        same <code>GetParametersForImport</code> request.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder encryptedKeyMaterial(SdkBytes encryptedKeyMaterial);

        /**
         * <p>
         * The date and time when the imported key material expires. This parameter is required when the value of the
         * <code>ExpirationModel</code> parameter is <code>KEY_MATERIAL_EXPIRES</code>. Otherwise it is not valid.
         * </p>
         * <p>
         * The value of this parameter must be a future date and time. The maximum value is 365 days from the request
         * date.
         * </p>
         * <p>
         * When the key material expires, KMS deletes the key material from the KMS key. Without its key material, the
         * KMS key is unusable. To use the KMS key in cryptographic operations, you must reimport the same key material.
         * </p>
         * <p>
         * You cannot change the <code>ExpirationModel</code> or <code>ValidTo</code> values for the current import
         * after the request completes. To change either value, you must delete (<a>DeleteImportedKeyMaterial</a>) and
         * reimport the key material.
         * </p>
         * 
         * @param validTo
         *        The date and time when the imported key material expires. This parameter is required when the value of
         *        the <code>ExpirationModel</code> parameter is <code>KEY_MATERIAL_EXPIRES</code>. Otherwise it is not
         *        valid.</p>
         *        <p>
         *        The value of this parameter must be a future date and time. The maximum value is 365 days from the
         *        request date.
         *        </p>
         *        <p>
         *        When the key material expires, KMS deletes the key material from the KMS key. Without its key
         *        material, the KMS key is unusable. To use the KMS key in cryptographic operations, you must reimport
         *        the same key material.
         *        </p>
         *        <p>
         *        You cannot change the <code>ExpirationModel</code> or <code>ValidTo</code> values for the current
         *        import after the request completes. To change either value, you must delete
         *        (<a>DeleteImportedKeyMaterial</a>) and reimport the key material.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder validTo(Instant validTo);

        /**
         * <p>
         * Specifies whether the key material expires. The default is <code>KEY_MATERIAL_EXPIRES</code>. For help with
         * this choice, see <a href=
         * "https://docs.aws.amazon.com/en_us/kms/latest/developerguide/importing-keys.html#importing-keys-expiration"
         * >Setting an expiration time</a> in the <i>Key Management Service Developer Guide</i>.
         * </p>
         * <p>
         * When the value of <code>ExpirationModel</code> is <code>KEY_MATERIAL_EXPIRES</code>, you must specify a value
         * for the <code>ValidTo</code> parameter. When value is <code>KEY_MATERIAL_DOES_NOT_EXPIRE</code>, you must
         * omit the <code>ValidTo</code> parameter.
         * </p>
         * <p>
         * You cannot change the <code>ExpirationModel</code> or <code>ValidTo</code> values for the current import
         * after the request completes. To change either value, you must reimport the key material.
         * </p>
         * 
         * @param expirationModel
         *        Specifies whether the key material expires. The default is <code>KEY_MATERIAL_EXPIRES</code>. For help
         *        with this choice, see <a href=
         *        "https://docs.aws.amazon.com/en_us/kms/latest/developerguide/importing-keys.html#importing-keys-expiration"
         *        >Setting an expiration time</a> in the <i>Key Management Service Developer Guide</i>.</p>
         *        <p>
         *        When the value of <code>ExpirationModel</code> is <code>KEY_MATERIAL_EXPIRES</code>, you must specify
         *        a value for the <code>ValidTo</code> parameter. When value is
         *        <code>KEY_MATERIAL_DOES_NOT_EXPIRE</code>, you must omit the <code>ValidTo</code> parameter.
         *        </p>
         *        <p>
         *        You cannot change the <code>ExpirationModel</code> or <code>ValidTo</code> values for the current
         *        import after the request completes. To change either value, you must reimport the key material.
         * @see ExpirationModelType
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see ExpirationModelType
         */
        Builder expirationModel(String expirationModel);

        /**
         * <p>
         * Specifies whether the key material expires. The default is <code>KEY_MATERIAL_EXPIRES</code>. For help with
         * this choice, see <a href=
         * "https://docs.aws.amazon.com/en_us/kms/latest/developerguide/importing-keys.html#importing-keys-expiration"
         * >Setting an expiration time</a> in the <i>Key Management Service Developer Guide</i>.
         * </p>
         * <p>
         * When the value of <code>ExpirationModel</code> is <code>KEY_MATERIAL_EXPIRES</code>, you must specify a value
         * for the <code>ValidTo</code> parameter. When value is <code>KEY_MATERIAL_DOES_NOT_EXPIRE</code>, you must
         * omit the <code>ValidTo</code> parameter.
         * </p>
         * <p>
         * You cannot change the <code>ExpirationModel</code> or <code>ValidTo</code> values for the current import
         * after the request completes. To change either value, you must reimport the key material.
         * </p>
         * 
         * @param expirationModel
         *        Specifies whether the key material expires. The default is <code>KEY_MATERIAL_EXPIRES</code>. For help
         *        with this choice, see <a href=
         *        "https://docs.aws.amazon.com/en_us/kms/latest/developerguide/importing-keys.html#importing-keys-expiration"
         *        >Setting an expiration time</a> in the <i>Key Management Service Developer Guide</i>.</p>
         *        <p>
         *        When the value of <code>ExpirationModel</code> is <code>KEY_MATERIAL_EXPIRES</code>, you must specify
         *        a value for the <code>ValidTo</code> parameter. When value is
         *        <code>KEY_MATERIAL_DOES_NOT_EXPIRE</code>, you must omit the <code>ValidTo</code> parameter.
         *        </p>
         *        <p>
         *        You cannot change the <code>ExpirationModel</code> or <code>ValidTo</code> values for the current
         *        import after the request completes. To change either value, you must reimport the key material.
         * @see ExpirationModelType
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see ExpirationModelType
         */
        Builder expirationModel(ExpirationModelType expirationModel);

        @Override
        Builder overrideConfiguration(AwsRequestOverrideConfiguration overrideConfiguration);

        @Override
        Builder overrideConfiguration(Consumer<AwsRequestOverrideConfiguration.Builder> builderConsumer);
    }

    static final class BuilderImpl extends KmsRequest.BuilderImpl implements Builder {
        private String keyId;

        private SdkBytes importToken;

        private SdkBytes encryptedKeyMaterial;

        private Instant validTo;

        private String expirationModel;

        private BuilderImpl() {
        }

        private BuilderImpl(ImportKeyMaterialRequest model) {
            super(model);
            keyId(model.keyId);
            importToken(model.importToken);
            encryptedKeyMaterial(model.encryptedKeyMaterial);
            validTo(model.validTo);
            expirationModel(model.expirationModel);
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

        public final ByteBuffer getImportToken() {
            return importToken == null ? null : importToken.asByteBuffer();
        }

        public final void setImportToken(ByteBuffer importToken) {
            importToken(importToken == null ? null : SdkBytes.fromByteBuffer(importToken));
        }

        @Override
        public final Builder importToken(SdkBytes importToken) {
            this.importToken = importToken;
            return this;
        }

        public final ByteBuffer getEncryptedKeyMaterial() {
            return encryptedKeyMaterial == null ? null : encryptedKeyMaterial.asByteBuffer();
        }

        public final void setEncryptedKeyMaterial(ByteBuffer encryptedKeyMaterial) {
            encryptedKeyMaterial(encryptedKeyMaterial == null ? null : SdkBytes.fromByteBuffer(encryptedKeyMaterial));
        }

        @Override
        public final Builder encryptedKeyMaterial(SdkBytes encryptedKeyMaterial) {
            this.encryptedKeyMaterial = encryptedKeyMaterial;
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
        public ImportKeyMaterialRequest build() {
            return new ImportKeyMaterialRequest(this);
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
