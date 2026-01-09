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
public final class VerifyRequest extends KmsRequest implements ToCopyableBuilder<VerifyRequest.Builder, VerifyRequest> {
    private static final SdkField<String> KEY_ID_FIELD = SdkField.<String> builder(MarshallingType.STRING).memberName("KeyId")
            .getter(getter(VerifyRequest::keyId)).setter(setter(Builder::keyId))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("KeyId").build()).build();

    private static final SdkField<SdkBytes> MESSAGE_FIELD = SdkField.<SdkBytes> builder(MarshallingType.SDK_BYTES)
            .memberName("Message").getter(getter(VerifyRequest::message)).setter(setter(Builder::message))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("Message").build()).build();

    private static final SdkField<String> MESSAGE_TYPE_FIELD = SdkField.<String> builder(MarshallingType.STRING)
            .memberName("MessageType").getter(getter(VerifyRequest::messageTypeAsString)).setter(setter(Builder::messageType))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("MessageType").build()).build();

    private static final SdkField<SdkBytes> SIGNATURE_FIELD = SdkField.<SdkBytes> builder(MarshallingType.SDK_BYTES)
            .memberName("Signature").getter(getter(VerifyRequest::signature)).setter(setter(Builder::signature))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("Signature").build()).build();

    private static final SdkField<String> SIGNING_ALGORITHM_FIELD = SdkField.<String> builder(MarshallingType.STRING)
            .memberName("SigningAlgorithm").getter(getter(VerifyRequest::signingAlgorithmAsString))
            .setter(setter(Builder::signingAlgorithm))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("SigningAlgorithm").build()).build();

    private static final SdkField<List<String>> GRANT_TOKENS_FIELD = SdkField
            .<List<String>> builder(MarshallingType.LIST)
            .memberName("GrantTokens")
            .getter(getter(VerifyRequest::grantTokens))
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
            .memberName("DryRun").getter(getter(VerifyRequest::dryRun)).setter(setter(Builder::dryRun))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("DryRun").build()).build();

    private static final List<SdkField<?>> SDK_FIELDS = Collections.unmodifiableList(Arrays.asList(KEY_ID_FIELD, MESSAGE_FIELD,
            MESSAGE_TYPE_FIELD, SIGNATURE_FIELD, SIGNING_ALGORITHM_FIELD, GRANT_TOKENS_FIELD, DRY_RUN_FIELD));

    private static final Map<String, SdkField<?>> SDK_NAME_TO_FIELD = memberNameToFieldInitializer();

    private final String keyId;

    private final SdkBytes message;

    private final String messageType;

    private final SdkBytes signature;

    private final String signingAlgorithm;

    private final List<String> grantTokens;

    private final Boolean dryRun;

    private VerifyRequest(BuilderImpl builder) {
        super(builder);
        this.keyId = builder.keyId;
        this.message = builder.message;
        this.messageType = builder.messageType;
        this.signature = builder.signature;
        this.signingAlgorithm = builder.signingAlgorithm;
        this.grantTokens = builder.grantTokens;
        this.dryRun = builder.dryRun;
    }

    /**
     * <p>
     * Identifies the asymmetric KMS key that will be used to verify the signature. This must be the same KMS key that
     * was used to generate the signature. If you specify a different KMS key, the signature verification fails.
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
     * @return Identifies the asymmetric KMS key that will be used to verify the signature. This must be the same KMS
     *         key that was used to generate the signature. If you specify a different KMS key, the signature
     *         verification fails.</p>
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
     * Specifies the message that was signed. You can submit a raw message of up to 4096 bytes, or a hash digest of the
     * message. If you submit a digest, use the <code>MessageType</code> parameter with a value of <code>DIGEST</code>.
     * </p>
     * <p>
     * If the message specified here is different from the message that was signed, the signature verification fails. A
     * message and its hash digest are considered to be the same message.
     * </p>
     * 
     * @return Specifies the message that was signed. You can submit a raw message of up to 4096 bytes, or a hash digest
     *         of the message. If you submit a digest, use the <code>MessageType</code> parameter with a value of
     *         <code>DIGEST</code>.</p>
     *         <p>
     *         If the message specified here is different from the message that was signed, the signature verification
     *         fails. A message and its hash digest are considered to be the same message.
     */
    public final SdkBytes message() {
        return message;
    }

    /**
     * <p>
     * Tells KMS whether the value of the <code>Message</code> parameter should be hashed as part of the signing
     * algorithm. Use <code>RAW</code> for unhashed messages; use <code>DIGEST</code> for message digests, which are
     * already hashed.
     * </p>
     * <p>
     * When the value of <code>MessageType</code> is <code>RAW</code>, KMS uses the standard signing algorithm, which
     * begins with a hash function. When the value is <code>DIGEST</code>, KMS skips the hashing step in the signing
     * algorithm.
     * </p>
     * <important>
     * <p>
     * Use the <code>DIGEST</code> value only when the value of the <code>Message</code> parameter is a message digest.
     * If you use the <code>DIGEST</code> value with an unhashed message, the security of the verification operation can
     * be compromised.
     * </p>
     * </important>
     * <p>
     * When the value of <code>MessageType</code>is <code>DIGEST</code>, the length of the <code>Message</code> value
     * must match the length of hashed messages for the specified signing algorithm.
     * </p>
     * <p>
     * You can submit a message digest and omit the <code>MessageType</code> or specify <code>RAW</code> so the digest
     * is hashed again while signing. However, if the signed message is hashed once while signing, but twice while
     * verifying, verification fails, even when the message hasn't changed.
     * </p>
     * <p>
     * The hashing algorithm in that <code>Verify</code> uses is based on the <code>SigningAlgorithm</code> value.
     * </p>
     * <ul>
     * <li>
     * <p>
     * Signing algorithms that end in SHA_256 use the SHA_256 hashing algorithm.
     * </p>
     * </li>
     * <li>
     * <p>
     * Signing algorithms that end in SHA_384 use the SHA_384 hashing algorithm.
     * </p>
     * </li>
     * <li>
     * <p>
     * Signing algorithms that end in SHA_512 use the SHA_512 hashing algorithm.
     * </p>
     * </li>
     * <li>
     * <p>
     * SM2DSA uses the SM3 hashing algorithm. For details, see <a href=
     * "https://docs.aws.amazon.com/kms/latest/developerguide/asymmetric-key-specs.html#key-spec-sm-offline-verification"
     * >Offline verification with SM2 key pairs</a>.
     * </p>
     * </li>
     * </ul>
     * <p>
     * If the service returns an enum value that is not available in the current SDK version, {@link #messageType} will
     * return {@link MessageType#UNKNOWN_TO_SDK_VERSION}. The raw value returned by the service is available from
     * {@link #messageTypeAsString}.
     * </p>
     * 
     * @return Tells KMS whether the value of the <code>Message</code> parameter should be hashed as part of the signing
     *         algorithm. Use <code>RAW</code> for unhashed messages; use <code>DIGEST</code> for message digests, which
     *         are already hashed.</p>
     *         <p>
     *         When the value of <code>MessageType</code> is <code>RAW</code>, KMS uses the standard signing algorithm,
     *         which begins with a hash function. When the value is <code>DIGEST</code>, KMS skips the hashing step in
     *         the signing algorithm.
     *         </p>
     *         <important>
     *         <p>
     *         Use the <code>DIGEST</code> value only when the value of the <code>Message</code> parameter is a message
     *         digest. If you use the <code>DIGEST</code> value with an unhashed message, the security of the
     *         verification operation can be compromised.
     *         </p>
     *         </important>
     *         <p>
     *         When the value of <code>MessageType</code>is <code>DIGEST</code>, the length of the <code>Message</code>
     *         value must match the length of hashed messages for the specified signing algorithm.
     *         </p>
     *         <p>
     *         You can submit a message digest and omit the <code>MessageType</code> or specify <code>RAW</code> so the
     *         digest is hashed again while signing. However, if the signed message is hashed once while signing, but
     *         twice while verifying, verification fails, even when the message hasn't changed.
     *         </p>
     *         <p>
     *         The hashing algorithm in that <code>Verify</code> uses is based on the <code>SigningAlgorithm</code>
     *         value.
     *         </p>
     *         <ul>
     *         <li>
     *         <p>
     *         Signing algorithms that end in SHA_256 use the SHA_256 hashing algorithm.
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         Signing algorithms that end in SHA_384 use the SHA_384 hashing algorithm.
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         Signing algorithms that end in SHA_512 use the SHA_512 hashing algorithm.
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         SM2DSA uses the SM3 hashing algorithm. For details, see <a href=
     *         "https://docs.aws.amazon.com/kms/latest/developerguide/asymmetric-key-specs.html#key-spec-sm-offline-verification"
     *         >Offline verification with SM2 key pairs</a>.
     *         </p>
     *         </li>
     * @see MessageType
     */
    public final MessageType messageType() {
        return MessageType.fromValue(messageType);
    }

    /**
     * <p>
     * Tells KMS whether the value of the <code>Message</code> parameter should be hashed as part of the signing
     * algorithm. Use <code>RAW</code> for unhashed messages; use <code>DIGEST</code> for message digests, which are
     * already hashed.
     * </p>
     * <p>
     * When the value of <code>MessageType</code> is <code>RAW</code>, KMS uses the standard signing algorithm, which
     * begins with a hash function. When the value is <code>DIGEST</code>, KMS skips the hashing step in the signing
     * algorithm.
     * </p>
     * <important>
     * <p>
     * Use the <code>DIGEST</code> value only when the value of the <code>Message</code> parameter is a message digest.
     * If you use the <code>DIGEST</code> value with an unhashed message, the security of the verification operation can
     * be compromised.
     * </p>
     * </important>
     * <p>
     * When the value of <code>MessageType</code>is <code>DIGEST</code>, the length of the <code>Message</code> value
     * must match the length of hashed messages for the specified signing algorithm.
     * </p>
     * <p>
     * You can submit a message digest and omit the <code>MessageType</code> or specify <code>RAW</code> so the digest
     * is hashed again while signing. However, if the signed message is hashed once while signing, but twice while
     * verifying, verification fails, even when the message hasn't changed.
     * </p>
     * <p>
     * The hashing algorithm in that <code>Verify</code> uses is based on the <code>SigningAlgorithm</code> value.
     * </p>
     * <ul>
     * <li>
     * <p>
     * Signing algorithms that end in SHA_256 use the SHA_256 hashing algorithm.
     * </p>
     * </li>
     * <li>
     * <p>
     * Signing algorithms that end in SHA_384 use the SHA_384 hashing algorithm.
     * </p>
     * </li>
     * <li>
     * <p>
     * Signing algorithms that end in SHA_512 use the SHA_512 hashing algorithm.
     * </p>
     * </li>
     * <li>
     * <p>
     * SM2DSA uses the SM3 hashing algorithm. For details, see <a href=
     * "https://docs.aws.amazon.com/kms/latest/developerguide/asymmetric-key-specs.html#key-spec-sm-offline-verification"
     * >Offline verification with SM2 key pairs</a>.
     * </p>
     * </li>
     * </ul>
     * <p>
     * If the service returns an enum value that is not available in the current SDK version, {@link #messageType} will
     * return {@link MessageType#UNKNOWN_TO_SDK_VERSION}. The raw value returned by the service is available from
     * {@link #messageTypeAsString}.
     * </p>
     * 
     * @return Tells KMS whether the value of the <code>Message</code> parameter should be hashed as part of the signing
     *         algorithm. Use <code>RAW</code> for unhashed messages; use <code>DIGEST</code> for message digests, which
     *         are already hashed.</p>
     *         <p>
     *         When the value of <code>MessageType</code> is <code>RAW</code>, KMS uses the standard signing algorithm,
     *         which begins with a hash function. When the value is <code>DIGEST</code>, KMS skips the hashing step in
     *         the signing algorithm.
     *         </p>
     *         <important>
     *         <p>
     *         Use the <code>DIGEST</code> value only when the value of the <code>Message</code> parameter is a message
     *         digest. If you use the <code>DIGEST</code> value with an unhashed message, the security of the
     *         verification operation can be compromised.
     *         </p>
     *         </important>
     *         <p>
     *         When the value of <code>MessageType</code>is <code>DIGEST</code>, the length of the <code>Message</code>
     *         value must match the length of hashed messages for the specified signing algorithm.
     *         </p>
     *         <p>
     *         You can submit a message digest and omit the <code>MessageType</code> or specify <code>RAW</code> so the
     *         digest is hashed again while signing. However, if the signed message is hashed once while signing, but
     *         twice while verifying, verification fails, even when the message hasn't changed.
     *         </p>
     *         <p>
     *         The hashing algorithm in that <code>Verify</code> uses is based on the <code>SigningAlgorithm</code>
     *         value.
     *         </p>
     *         <ul>
     *         <li>
     *         <p>
     *         Signing algorithms that end in SHA_256 use the SHA_256 hashing algorithm.
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         Signing algorithms that end in SHA_384 use the SHA_384 hashing algorithm.
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         Signing algorithms that end in SHA_512 use the SHA_512 hashing algorithm.
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         SM2DSA uses the SM3 hashing algorithm. For details, see <a href=
     *         "https://docs.aws.amazon.com/kms/latest/developerguide/asymmetric-key-specs.html#key-spec-sm-offline-verification"
     *         >Offline verification with SM2 key pairs</a>.
     *         </p>
     *         </li>
     * @see MessageType
     */
    public final String messageTypeAsString() {
        return messageType;
    }

    /**
     * <p>
     * The signature that the <code>Sign</code> operation generated.
     * </p>
     * 
     * @return The signature that the <code>Sign</code> operation generated.
     */
    public final SdkBytes signature() {
        return signature;
    }

    /**
     * <p>
     * The signing algorithm that was used to sign the message. If you submit a different algorithm, the signature
     * verification fails.
     * </p>
     * <p>
     * If the service returns an enum value that is not available in the current SDK version, {@link #signingAlgorithm}
     * will return {@link SigningAlgorithmSpec#UNKNOWN_TO_SDK_VERSION}. The raw value returned by the service is
     * available from {@link #signingAlgorithmAsString}.
     * </p>
     * 
     * @return The signing algorithm that was used to sign the message. If you submit a different algorithm, the
     *         signature verification fails.
     * @see SigningAlgorithmSpec
     */
    public final SigningAlgorithmSpec signingAlgorithm() {
        return SigningAlgorithmSpec.fromValue(signingAlgorithm);
    }

    /**
     * <p>
     * The signing algorithm that was used to sign the message. If you submit a different algorithm, the signature
     * verification fails.
     * </p>
     * <p>
     * If the service returns an enum value that is not available in the current SDK version, {@link #signingAlgorithm}
     * will return {@link SigningAlgorithmSpec#UNKNOWN_TO_SDK_VERSION}. The raw value returned by the service is
     * available from {@link #signingAlgorithmAsString}.
     * </p>
     * 
     * @return The signing algorithm that was used to sign the message. If you submit a different algorithm, the
     *         signature verification fails.
     * @see SigningAlgorithmSpec
     */
    public final String signingAlgorithmAsString() {
        return signingAlgorithm;
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
        hashCode = 31 * hashCode + Objects.hashCode(keyId());
        hashCode = 31 * hashCode + Objects.hashCode(message());
        hashCode = 31 * hashCode + Objects.hashCode(messageTypeAsString());
        hashCode = 31 * hashCode + Objects.hashCode(signature());
        hashCode = 31 * hashCode + Objects.hashCode(signingAlgorithmAsString());
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
        if (!(obj instanceof VerifyRequest)) {
            return false;
        }
        VerifyRequest other = (VerifyRequest) obj;
        return Objects.equals(keyId(), other.keyId()) && Objects.equals(message(), other.message())
                && Objects.equals(messageTypeAsString(), other.messageTypeAsString())
                && Objects.equals(signature(), other.signature())
                && Objects.equals(signingAlgorithmAsString(), other.signingAlgorithmAsString())
                && hasGrantTokens() == other.hasGrantTokens() && Objects.equals(grantTokens(), other.grantTokens())
                && Objects.equals(dryRun(), other.dryRun());
    }

    /**
     * Returns a string representation of this object. This is useful for testing and debugging. Sensitive data will be
     * redacted from this string using a placeholder value.
     */
    @Override
    public final String toString() {
        return ToString.builder("VerifyRequest").add("KeyId", keyId())
                .add("Message", message() == null ? null : "*** Sensitive Data Redacted ***")
                .add("MessageType", messageTypeAsString()).add("Signature", signature())
                .add("SigningAlgorithm", signingAlgorithmAsString()).add("GrantTokens", hasGrantTokens() ? grantTokens() : null)
                .add("DryRun", dryRun()).build();
    }

    public final <T> Optional<T> getValueForField(String fieldName, Class<T> clazz) {
        switch (fieldName) {
        case "KeyId":
            return Optional.ofNullable(clazz.cast(keyId()));
        case "Message":
            return Optional.ofNullable(clazz.cast(message()));
        case "MessageType":
            return Optional.ofNullable(clazz.cast(messageTypeAsString()));
        case "Signature":
            return Optional.ofNullable(clazz.cast(signature()));
        case "SigningAlgorithm":
            return Optional.ofNullable(clazz.cast(signingAlgorithmAsString()));
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
        map.put("KeyId", KEY_ID_FIELD);
        map.put("Message", MESSAGE_FIELD);
        map.put("MessageType", MESSAGE_TYPE_FIELD);
        map.put("Signature", SIGNATURE_FIELD);
        map.put("SigningAlgorithm", SIGNING_ALGORITHM_FIELD);
        map.put("GrantTokens", GRANT_TOKENS_FIELD);
        map.put("DryRun", DRY_RUN_FIELD);
        return Collections.unmodifiableMap(map);
    }

    private static <T> Function<Object, T> getter(Function<VerifyRequest, T> g) {
        return obj -> g.apply((VerifyRequest) obj);
    }

    private static <T> BiConsumer<Object, T> setter(BiConsumer<Builder, T> s) {
        return (obj, val) -> s.accept((Builder) obj, val);
    }

    @Mutable
    @NotThreadSafe
    public interface Builder extends KmsRequest.Builder, SdkPojo, CopyableBuilder<Builder, VerifyRequest> {
        /**
         * <p>
         * Identifies the asymmetric KMS key that will be used to verify the signature. This must be the same KMS key
         * that was used to generate the signature. If you specify a different KMS key, the signature verification
         * fails.
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
         *        Identifies the asymmetric KMS key that will be used to verify the signature. This must be the same KMS
         *        key that was used to generate the signature. If you specify a different KMS key, the signature
         *        verification fails.</p>
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
         * Specifies the message that was signed. You can submit a raw message of up to 4096 bytes, or a hash digest of
         * the message. If you submit a digest, use the <code>MessageType</code> parameter with a value of
         * <code>DIGEST</code>.
         * </p>
         * <p>
         * If the message specified here is different from the message that was signed, the signature verification
         * fails. A message and its hash digest are considered to be the same message.
         * </p>
         * 
         * @param message
         *        Specifies the message that was signed. You can submit a raw message of up to 4096 bytes, or a hash
         *        digest of the message. If you submit a digest, use the <code>MessageType</code> parameter with a value
         *        of <code>DIGEST</code>.</p>
         *        <p>
         *        If the message specified here is different from the message that was signed, the signature
         *        verification fails. A message and its hash digest are considered to be the same message.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder message(SdkBytes message);

        /**
         * <p>
         * Tells KMS whether the value of the <code>Message</code> parameter should be hashed as part of the signing
         * algorithm. Use <code>RAW</code> for unhashed messages; use <code>DIGEST</code> for message digests, which are
         * already hashed.
         * </p>
         * <p>
         * When the value of <code>MessageType</code> is <code>RAW</code>, KMS uses the standard signing algorithm,
         * which begins with a hash function. When the value is <code>DIGEST</code>, KMS skips the hashing step in the
         * signing algorithm.
         * </p>
         * <important>
         * <p>
         * Use the <code>DIGEST</code> value only when the value of the <code>Message</code> parameter is a message
         * digest. If you use the <code>DIGEST</code> value with an unhashed message, the security of the verification
         * operation can be compromised.
         * </p>
         * </important>
         * <p>
         * When the value of <code>MessageType</code>is <code>DIGEST</code>, the length of the <code>Message</code>
         * value must match the length of hashed messages for the specified signing algorithm.
         * </p>
         * <p>
         * You can submit a message digest and omit the <code>MessageType</code> or specify <code>RAW</code> so the
         * digest is hashed again while signing. However, if the signed message is hashed once while signing, but twice
         * while verifying, verification fails, even when the message hasn't changed.
         * </p>
         * <p>
         * The hashing algorithm in that <code>Verify</code> uses is based on the <code>SigningAlgorithm</code> value.
         * </p>
         * <ul>
         * <li>
         * <p>
         * Signing algorithms that end in SHA_256 use the SHA_256 hashing algorithm.
         * </p>
         * </li>
         * <li>
         * <p>
         * Signing algorithms that end in SHA_384 use the SHA_384 hashing algorithm.
         * </p>
         * </li>
         * <li>
         * <p>
         * Signing algorithms that end in SHA_512 use the SHA_512 hashing algorithm.
         * </p>
         * </li>
         * <li>
         * <p>
         * SM2DSA uses the SM3 hashing algorithm. For details, see <a href=
         * "https://docs.aws.amazon.com/kms/latest/developerguide/asymmetric-key-specs.html#key-spec-sm-offline-verification"
         * >Offline verification with SM2 key pairs</a>.
         * </p>
         * </li>
         * </ul>
         * 
         * @param messageType
         *        Tells KMS whether the value of the <code>Message</code> parameter should be hashed as part of the
         *        signing algorithm. Use <code>RAW</code> for unhashed messages; use <code>DIGEST</code> for message
         *        digests, which are already hashed.</p>
         *        <p>
         *        When the value of <code>MessageType</code> is <code>RAW</code>, KMS uses the standard signing
         *        algorithm, which begins with a hash function. When the value is <code>DIGEST</code>, KMS skips the
         *        hashing step in the signing algorithm.
         *        </p>
         *        <important>
         *        <p>
         *        Use the <code>DIGEST</code> value only when the value of the <code>Message</code> parameter is a
         *        message digest. If you use the <code>DIGEST</code> value with an unhashed message, the security of the
         *        verification operation can be compromised.
         *        </p>
         *        </important>
         *        <p>
         *        When the value of <code>MessageType</code>is <code>DIGEST</code>, the length of the
         *        <code>Message</code> value must match the length of hashed messages for the specified signing
         *        algorithm.
         *        </p>
         *        <p>
         *        You can submit a message digest and omit the <code>MessageType</code> or specify <code>RAW</code> so
         *        the digest is hashed again while signing. However, if the signed message is hashed once while signing,
         *        but twice while verifying, verification fails, even when the message hasn't changed.
         *        </p>
         *        <p>
         *        The hashing algorithm in that <code>Verify</code> uses is based on the <code>SigningAlgorithm</code>
         *        value.
         *        </p>
         *        <ul>
         *        <li>
         *        <p>
         *        Signing algorithms that end in SHA_256 use the SHA_256 hashing algorithm.
         *        </p>
         *        </li>
         *        <li>
         *        <p>
         *        Signing algorithms that end in SHA_384 use the SHA_384 hashing algorithm.
         *        </p>
         *        </li>
         *        <li>
         *        <p>
         *        Signing algorithms that end in SHA_512 use the SHA_512 hashing algorithm.
         *        </p>
         *        </li>
         *        <li>
         *        <p>
         *        SM2DSA uses the SM3 hashing algorithm. For details, see <a href=
         *        "https://docs.aws.amazon.com/kms/latest/developerguide/asymmetric-key-specs.html#key-spec-sm-offline-verification"
         *        >Offline verification with SM2 key pairs</a>.
         *        </p>
         *        </li>
         * @see MessageType
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see MessageType
         */
        Builder messageType(String messageType);

        /**
         * <p>
         * Tells KMS whether the value of the <code>Message</code> parameter should be hashed as part of the signing
         * algorithm. Use <code>RAW</code> for unhashed messages; use <code>DIGEST</code> for message digests, which are
         * already hashed.
         * </p>
         * <p>
         * When the value of <code>MessageType</code> is <code>RAW</code>, KMS uses the standard signing algorithm,
         * which begins with a hash function. When the value is <code>DIGEST</code>, KMS skips the hashing step in the
         * signing algorithm.
         * </p>
         * <important>
         * <p>
         * Use the <code>DIGEST</code> value only when the value of the <code>Message</code> parameter is a message
         * digest. If you use the <code>DIGEST</code> value with an unhashed message, the security of the verification
         * operation can be compromised.
         * </p>
         * </important>
         * <p>
         * When the value of <code>MessageType</code>is <code>DIGEST</code>, the length of the <code>Message</code>
         * value must match the length of hashed messages for the specified signing algorithm.
         * </p>
         * <p>
         * You can submit a message digest and omit the <code>MessageType</code> or specify <code>RAW</code> so the
         * digest is hashed again while signing. However, if the signed message is hashed once while signing, but twice
         * while verifying, verification fails, even when the message hasn't changed.
         * </p>
         * <p>
         * The hashing algorithm in that <code>Verify</code> uses is based on the <code>SigningAlgorithm</code> value.
         * </p>
         * <ul>
         * <li>
         * <p>
         * Signing algorithms that end in SHA_256 use the SHA_256 hashing algorithm.
         * </p>
         * </li>
         * <li>
         * <p>
         * Signing algorithms that end in SHA_384 use the SHA_384 hashing algorithm.
         * </p>
         * </li>
         * <li>
         * <p>
         * Signing algorithms that end in SHA_512 use the SHA_512 hashing algorithm.
         * </p>
         * </li>
         * <li>
         * <p>
         * SM2DSA uses the SM3 hashing algorithm. For details, see <a href=
         * "https://docs.aws.amazon.com/kms/latest/developerguide/asymmetric-key-specs.html#key-spec-sm-offline-verification"
         * >Offline verification with SM2 key pairs</a>.
         * </p>
         * </li>
         * </ul>
         * 
         * @param messageType
         *        Tells KMS whether the value of the <code>Message</code> parameter should be hashed as part of the
         *        signing algorithm. Use <code>RAW</code> for unhashed messages; use <code>DIGEST</code> for message
         *        digests, which are already hashed.</p>
         *        <p>
         *        When the value of <code>MessageType</code> is <code>RAW</code>, KMS uses the standard signing
         *        algorithm, which begins with a hash function. When the value is <code>DIGEST</code>, KMS skips the
         *        hashing step in the signing algorithm.
         *        </p>
         *        <important>
         *        <p>
         *        Use the <code>DIGEST</code> value only when the value of the <code>Message</code> parameter is a
         *        message digest. If you use the <code>DIGEST</code> value with an unhashed message, the security of the
         *        verification operation can be compromised.
         *        </p>
         *        </important>
         *        <p>
         *        When the value of <code>MessageType</code>is <code>DIGEST</code>, the length of the
         *        <code>Message</code> value must match the length of hashed messages for the specified signing
         *        algorithm.
         *        </p>
         *        <p>
         *        You can submit a message digest and omit the <code>MessageType</code> or specify <code>RAW</code> so
         *        the digest is hashed again while signing. However, if the signed message is hashed once while signing,
         *        but twice while verifying, verification fails, even when the message hasn't changed.
         *        </p>
         *        <p>
         *        The hashing algorithm in that <code>Verify</code> uses is based on the <code>SigningAlgorithm</code>
         *        value.
         *        </p>
         *        <ul>
         *        <li>
         *        <p>
         *        Signing algorithms that end in SHA_256 use the SHA_256 hashing algorithm.
         *        </p>
         *        </li>
         *        <li>
         *        <p>
         *        Signing algorithms that end in SHA_384 use the SHA_384 hashing algorithm.
         *        </p>
         *        </li>
         *        <li>
         *        <p>
         *        Signing algorithms that end in SHA_512 use the SHA_512 hashing algorithm.
         *        </p>
         *        </li>
         *        <li>
         *        <p>
         *        SM2DSA uses the SM3 hashing algorithm. For details, see <a href=
         *        "https://docs.aws.amazon.com/kms/latest/developerguide/asymmetric-key-specs.html#key-spec-sm-offline-verification"
         *        >Offline verification with SM2 key pairs</a>.
         *        </p>
         *        </li>
         * @see MessageType
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see MessageType
         */
        Builder messageType(MessageType messageType);

        /**
         * <p>
         * The signature that the <code>Sign</code> operation generated.
         * </p>
         * 
         * @param signature
         *        The signature that the <code>Sign</code> operation generated.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder signature(SdkBytes signature);

        /**
         * <p>
         * The signing algorithm that was used to sign the message. If you submit a different algorithm, the signature
         * verification fails.
         * </p>
         * 
         * @param signingAlgorithm
         *        The signing algorithm that was used to sign the message. If you submit a different algorithm, the
         *        signature verification fails.
         * @see SigningAlgorithmSpec
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see SigningAlgorithmSpec
         */
        Builder signingAlgorithm(String signingAlgorithm);

        /**
         * <p>
         * The signing algorithm that was used to sign the message. If you submit a different algorithm, the signature
         * verification fails.
         * </p>
         * 
         * @param signingAlgorithm
         *        The signing algorithm that was used to sign the message. If you submit a different algorithm, the
         *        signature verification fails.
         * @see SigningAlgorithmSpec
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see SigningAlgorithmSpec
         */
        Builder signingAlgorithm(SigningAlgorithmSpec signingAlgorithm);

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
        private String keyId;

        private SdkBytes message;

        private String messageType;

        private SdkBytes signature;

        private String signingAlgorithm;

        private List<String> grantTokens = DefaultSdkAutoConstructList.getInstance();

        private Boolean dryRun;

        private BuilderImpl() {
        }

        private BuilderImpl(VerifyRequest model) {
            super(model);
            keyId(model.keyId);
            message(model.message);
            messageType(model.messageType);
            signature(model.signature);
            signingAlgorithm(model.signingAlgorithm);
            grantTokens(model.grantTokens);
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

        public final ByteBuffer getMessage() {
            return message == null ? null : message.asByteBuffer();
        }

        public final void setMessage(ByteBuffer message) {
            message(message == null ? null : SdkBytes.fromByteBuffer(message));
        }

        @Override
        public final Builder message(SdkBytes message) {
            this.message = message;
            return this;
        }

        public final String getMessageType() {
            return messageType;
        }

        public final void setMessageType(String messageType) {
            this.messageType = messageType;
        }

        @Override
        public final Builder messageType(String messageType) {
            this.messageType = messageType;
            return this;
        }

        @Override
        public final Builder messageType(MessageType messageType) {
            this.messageType(messageType == null ? null : messageType.toString());
            return this;
        }

        public final ByteBuffer getSignature() {
            return signature == null ? null : signature.asByteBuffer();
        }

        public final void setSignature(ByteBuffer signature) {
            signature(signature == null ? null : SdkBytes.fromByteBuffer(signature));
        }

        @Override
        public final Builder signature(SdkBytes signature) {
            this.signature = signature;
            return this;
        }

        public final String getSigningAlgorithm() {
            return signingAlgorithm;
        }

        public final void setSigningAlgorithm(String signingAlgorithm) {
            this.signingAlgorithm = signingAlgorithm;
        }

        @Override
        public final Builder signingAlgorithm(String signingAlgorithm) {
            this.signingAlgorithm = signingAlgorithm;
            return this;
        }

        @Override
        public final Builder signingAlgorithm(SigningAlgorithmSpec signingAlgorithm) {
            this.signingAlgorithm(signingAlgorithm == null ? null : signingAlgorithm.toString());
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
        public VerifyRequest build() {
            return new VerifyRequest(this);
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
