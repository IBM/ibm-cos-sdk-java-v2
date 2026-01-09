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

package com.ibm.cos.v2.services.s3.model;

import java.io.Serializable;
import java.util.Arrays;
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
import com.ibm.cos.v2.core.SdkField;
import com.ibm.cos.v2.core.SdkPojo;
import com.ibm.cos.v2.core.protocol.MarshallLocation;
import com.ibm.cos.v2.core.protocol.MarshallingType;
import com.ibm.cos.v2.core.traits.LocationTrait;
import com.ibm.cos.v2.core.traits.RequiredTrait;
import com.ibm.cos.v2.utils.ToString;
import com.ibm.cos.v2.utils.builder.CopyableBuilder;
import com.ibm.cos.v2.utils.builder.ToCopyableBuilder;

/**
 * <p>
 * Describes the default server-side encryption to apply to new objects in the bucket. If a PUT Object request doesn't
 * specify any server-side encryption, this default encryption will be applied. For more information, see <a
 * href="https://docs.aws.amazon.com/AmazonS3/latest/API/RESTBucketPUTencryption.html">PutBucketEncryption</a>.
 * </p>
 * <note>
 * <ul>
 * <li>
 * <p>
 * <b>General purpose buckets</b> - If you don't specify a customer managed key at configuration, Amazon S3
 * automatically creates an Amazon Web Services KMS key (<code>aws/s3</code>) in your Amazon Web Services account the
 * first time that you add an object encrypted with SSE-KMS to a bucket. By default, Amazon S3 uses this KMS key for
 * SSE-KMS.
 * </p>
 * </li>
 * <li>
 * <p>
 * <b>Directory buckets</b> - Your SSE-KMS configuration can only support 1 <a
 * href="https://docs.aws.amazon.com/kms/latest/developerguide/concepts.html#customer-cmk">customer managed key</a> per
 * directory bucket's lifetime. The <a
 * href="https://docs.aws.amazon.com/kms/latest/developerguide/concepts.html#aws-managed-cmk">Amazon Web Services
 * managed key</a> (<code>aws/s3</code>) isn't supported.
 * </p>
 * </li>
 * <li>
 * <p>
 * <b>Directory buckets</b> - For directory buckets, there are only two supported options for server-side encryption:
 * SSE-S3 and SSE-KMS.
 * </p>
 * </li>
 * </ul>
 * </note>
 */
@Generated("com.ibm.cos.v2:codegen")
public final class ServerSideEncryptionByDefault implements SdkPojo, Serializable,
        ToCopyableBuilder<ServerSideEncryptionByDefault.Builder, ServerSideEncryptionByDefault> {
    private static final SdkField<String> SSE_ALGORITHM_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("SSEAlgorithm")
            .getter(getter(ServerSideEncryptionByDefault::sseAlgorithmAsString))
            .setter(setter(Builder::sseAlgorithm))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("SSEAlgorithm")
                    .unmarshallLocationName("SSEAlgorithm").build(), RequiredTrait.create()).build();

    private static final SdkField<String> KMS_MASTER_KEY_ID_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("KMSMasterKeyID")
            .getter(getter(ServerSideEncryptionByDefault::kmsMasterKeyID))
            .setter(setter(Builder::kmsMasterKeyID))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("KMSMasterKeyID")
                    .unmarshallLocationName("KMSMasterKeyID").build()).build();

    private static final List<SdkField<?>> SDK_FIELDS = Collections.unmodifiableList(Arrays.asList(SSE_ALGORITHM_FIELD,
            KMS_MASTER_KEY_ID_FIELD));

    private static final Map<String, SdkField<?>> SDK_NAME_TO_FIELD = memberNameToFieldInitializer();

    private static final long serialVersionUID = 1L;

    private final String sseAlgorithm;

    private final String kmsMasterKeyID;

    private ServerSideEncryptionByDefault(BuilderImpl builder) {
        this.sseAlgorithm = builder.sseAlgorithm;
        this.kmsMasterKeyID = builder.kmsMasterKeyID;
    }

    /**
     * <p>
     * Server-side encryption algorithm to use for the default encryption.
     * </p>
     * <note>
     * <p>
     * For directory buckets, there are only two supported values for server-side encryption: <code>AES256</code> and
     * <code>aws:kms</code>.
     * </p>
     * </note>
     * <p>
     * If the service returns an enum value that is not available in the current SDK version, {@link #sseAlgorithm} will
     * return {@link ServerSideEncryption#UNKNOWN_TO_SDK_VERSION}. The raw value returned by the service is available
     * from {@link #sseAlgorithmAsString}.
     * </p>
     * 
     * @return Server-side encryption algorithm to use for the default encryption.</p> <note>
     *         <p>
     *         For directory buckets, there are only two supported values for server-side encryption:
     *         <code>AES256</code> and <code>aws:kms</code>.
     *         </p>
     * @see ServerSideEncryption
     */
    public final ServerSideEncryption sseAlgorithm() {
        return ServerSideEncryption.fromValue(sseAlgorithm);
    }

    /**
     * <p>
     * Server-side encryption algorithm to use for the default encryption.
     * </p>
     * <note>
     * <p>
     * For directory buckets, there are only two supported values for server-side encryption: <code>AES256</code> and
     * <code>aws:kms</code>.
     * </p>
     * </note>
     * <p>
     * If the service returns an enum value that is not available in the current SDK version, {@link #sseAlgorithm} will
     * return {@link ServerSideEncryption#UNKNOWN_TO_SDK_VERSION}. The raw value returned by the service is available
     * from {@link #sseAlgorithmAsString}.
     * </p>
     * 
     * @return Server-side encryption algorithm to use for the default encryption.</p> <note>
     *         <p>
     *         For directory buckets, there are only two supported values for server-side encryption:
     *         <code>AES256</code> and <code>aws:kms</code>.
     *         </p>
     * @see ServerSideEncryption
     */
    public final String sseAlgorithmAsString() {
        return sseAlgorithm;
    }

    /**
     * <p>
     * Amazon Web Services Key Management Service (KMS) customer managed key ID to use for the default encryption.
     * </p>
     * <note>
     * <ul>
     * <li>
     * <p>
     * <b>General purpose buckets</b> - This parameter is allowed if and only if <code>SSEAlgorithm</code> is set to
     * <code>aws:kms</code> or <code>aws:kms:dsse</code>.
     * </p>
     * </li>
     * <li>
     * <p>
     * <b>Directory buckets</b> - This parameter is allowed if and only if <code>SSEAlgorithm</code> is set to
     * <code>aws:kms</code>.
     * </p>
     * </li>
     * </ul>
     * </note>
     * <p>
     * You can specify the key ID, key alias, or the Amazon Resource Name (ARN) of the KMS key.
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
     * Key Alias: <code>alias/alias-name</code>
     * </p>
     * </li>
     * </ul>
     * <p>
     * If you are using encryption with cross-account or Amazon Web Services service operations, you must use a fully
     * qualified KMS key ARN. For more information, see <a href=
     * "https://docs.aws.amazon.com/AmazonS3/latest/dev/bucket-encryption.html#bucket-encryption-update-bucket-policy"
     * >Using encryption for cross-account operations</a>.
     * </p>
     * <note>
     * <ul>
     * <li>
     * <p>
     * <b>General purpose buckets</b> - If you're specifying a customer managed KMS key, we recommend using a fully
     * qualified KMS key ARN. If you use a KMS key alias instead, then KMS resolves the key within the requester’s
     * account. This behavior can result in data that's encrypted with a KMS key that belongs to the requester, and not
     * the bucket owner. Also, if you use a key ID, you can run into a LogDestination undeliverable error when creating
     * a VPC flow log.
     * </p>
     * </li>
     * <li>
     * <p>
     * <b>Directory buckets</b> - When you specify an <a
     * href="https://docs.aws.amazon.com/kms/latest/developerguide/concepts.html#customer-cmk">KMS customer managed
     * key</a> for encryption in your directory bucket, only use the key ID or key ARN. The key alias format of the KMS
     * key isn't supported.
     * </p>
     * </li>
     * </ul>
     * </note> <important>
     * <p>
     * Amazon S3 only supports symmetric encryption KMS keys. For more information, see <a
     * href="https://docs.aws.amazon.com/kms/latest/developerguide/symmetric-asymmetric.html">Asymmetric keys in Amazon
     * Web Services KMS</a> in the <i>Amazon Web Services Key Management Service Developer Guide</i>.
     * </p>
     * </important>
     * 
     * @return Amazon Web Services Key Management Service (KMS) customer managed key ID to use for the default
     *         encryption. </p> <note>
     *         <ul>
     *         <li>
     *         <p>
     *         <b>General purpose buckets</b> - This parameter is allowed if and only if <code>SSEAlgorithm</code> is
     *         set to <code>aws:kms</code> or <code>aws:kms:dsse</code>.
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         <b>Directory buckets</b> - This parameter is allowed if and only if <code>SSEAlgorithm</code> is set to
     *         <code>aws:kms</code>.
     *         </p>
     *         </li>
     *         </ul>
     *         </note>
     *         <p>
     *         You can specify the key ID, key alias, or the Amazon Resource Name (ARN) of the KMS key.
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
     *         Key Alias: <code>alias/alias-name</code>
     *         </p>
     *         </li>
     *         </ul>
     *         <p>
     *         If you are using encryption with cross-account or Amazon Web Services service operations, you must use a
     *         fully qualified KMS key ARN. For more information, see <a href=
     *         "https://docs.aws.amazon.com/AmazonS3/latest/dev/bucket-encryption.html#bucket-encryption-update-bucket-policy"
     *         >Using encryption for cross-account operations</a>.
     *         </p>
     *         <note>
     *         <ul>
     *         <li>
     *         <p>
     *         <b>General purpose buckets</b> - If you're specifying a customer managed KMS key, we recommend using a
     *         fully qualified KMS key ARN. If you use a KMS key alias instead, then KMS resolves the key within the
     *         requester’s account. This behavior can result in data that's encrypted with a KMS key that belongs to the
     *         requester, and not the bucket owner. Also, if you use a key ID, you can run into a LogDestination
     *         undeliverable error when creating a VPC flow log.
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         <b>Directory buckets</b> - When you specify an <a
     *         href="https://docs.aws.amazon.com/kms/latest/developerguide/concepts.html#customer-cmk">KMS customer
     *         managed key</a> for encryption in your directory bucket, only use the key ID or key ARN. The key alias
     *         format of the KMS key isn't supported.
     *         </p>
     *         </li>
     *         </ul>
     *         </note> <important>
     *         <p>
     *         Amazon S3 only supports symmetric encryption KMS keys. For more information, see <a
     *         href="https://docs.aws.amazon.com/kms/latest/developerguide/symmetric-asymmetric.html">Asymmetric keys in
     *         Amazon Web Services KMS</a> in the <i>Amazon Web Services Key Management Service Developer Guide</i>.
     *         </p>
     */
    public final String kmsMasterKeyID() {
        return kmsMasterKeyID;
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
        hashCode = 31 * hashCode + Objects.hashCode(sseAlgorithmAsString());
        hashCode = 31 * hashCode + Objects.hashCode(kmsMasterKeyID());
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
        if (!(obj instanceof ServerSideEncryptionByDefault)) {
            return false;
        }
        ServerSideEncryptionByDefault other = (ServerSideEncryptionByDefault) obj;
        return Objects.equals(sseAlgorithmAsString(), other.sseAlgorithmAsString())
                && Objects.equals(kmsMasterKeyID(), other.kmsMasterKeyID());
    }

    /**
     * Returns a string representation of this object. This is useful for testing and debugging. Sensitive data will be
     * redacted from this string using a placeholder value.
     */
    @Override
    public final String toString() {
        return ToString.builder("ServerSideEncryptionByDefault").add("SSEAlgorithm", sseAlgorithmAsString())
                .add("KMSMasterKeyID", kmsMasterKeyID() == null ? null : "*** Sensitive Data Redacted ***").build();
    }

    public final <T> Optional<T> getValueForField(String fieldName, Class<T> clazz) {
        switch (fieldName) {
        case "SSEAlgorithm":
            return Optional.ofNullable(clazz.cast(sseAlgorithmAsString()));
        case "KMSMasterKeyID":
            return Optional.ofNullable(clazz.cast(kmsMasterKeyID()));
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
        map.put("SSEAlgorithm", SSE_ALGORITHM_FIELD);
        map.put("KMSMasterKeyID", KMS_MASTER_KEY_ID_FIELD);
        return Collections.unmodifiableMap(map);
    }

    private static <T> Function<Object, T> getter(Function<ServerSideEncryptionByDefault, T> g) {
        return obj -> g.apply((ServerSideEncryptionByDefault) obj);
    }

    private static <T> BiConsumer<Object, T> setter(BiConsumer<Builder, T> s) {
        return (obj, val) -> s.accept((Builder) obj, val);
    }

    @Mutable
    @NotThreadSafe
    public interface Builder extends SdkPojo, CopyableBuilder<Builder, ServerSideEncryptionByDefault> {
        /**
         * <p>
         * Server-side encryption algorithm to use for the default encryption.
         * </p>
         * <note>
         * <p>
         * For directory buckets, there are only two supported values for server-side encryption: <code>AES256</code>
         * and <code>aws:kms</code>.
         * </p>
         * </note>
         * 
         * @param sseAlgorithm
         *        Server-side encryption algorithm to use for the default encryption.</p> <note>
         *        <p>
         *        For directory buckets, there are only two supported values for server-side encryption:
         *        <code>AES256</code> and <code>aws:kms</code>.
         *        </p>
         * @see ServerSideEncryption
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see ServerSideEncryption
         */
        Builder sseAlgorithm(String sseAlgorithm);

        /**
         * <p>
         * Server-side encryption algorithm to use for the default encryption.
         * </p>
         * <note>
         * <p>
         * For directory buckets, there are only two supported values for server-side encryption: <code>AES256</code>
         * and <code>aws:kms</code>.
         * </p>
         * </note>
         * 
         * @param sseAlgorithm
         *        Server-side encryption algorithm to use for the default encryption.</p> <note>
         *        <p>
         *        For directory buckets, there are only two supported values for server-side encryption:
         *        <code>AES256</code> and <code>aws:kms</code>.
         *        </p>
         * @see ServerSideEncryption
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see ServerSideEncryption
         */
        Builder sseAlgorithm(ServerSideEncryption sseAlgorithm);

        /**
         * <p>
         * Amazon Web Services Key Management Service (KMS) customer managed key ID to use for the default encryption.
         * </p>
         * <note>
         * <ul>
         * <li>
         * <p>
         * <b>General purpose buckets</b> - This parameter is allowed if and only if <code>SSEAlgorithm</code> is set to
         * <code>aws:kms</code> or <code>aws:kms:dsse</code>.
         * </p>
         * </li>
         * <li>
         * <p>
         * <b>Directory buckets</b> - This parameter is allowed if and only if <code>SSEAlgorithm</code> is set to
         * <code>aws:kms</code>.
         * </p>
         * </li>
         * </ul>
         * </note>
         * <p>
         * You can specify the key ID, key alias, or the Amazon Resource Name (ARN) of the KMS key.
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
         * Key Alias: <code>alias/alias-name</code>
         * </p>
         * </li>
         * </ul>
         * <p>
         * If you are using encryption with cross-account or Amazon Web Services service operations, you must use a
         * fully qualified KMS key ARN. For more information, see <a href=
         * "https://docs.aws.amazon.com/AmazonS3/latest/dev/bucket-encryption.html#bucket-encryption-update-bucket-policy"
         * >Using encryption for cross-account operations</a>.
         * </p>
         * <note>
         * <ul>
         * <li>
         * <p>
         * <b>General purpose buckets</b> - If you're specifying a customer managed KMS key, we recommend using a fully
         * qualified KMS key ARN. If you use a KMS key alias instead, then KMS resolves the key within the requester’s
         * account. This behavior can result in data that's encrypted with a KMS key that belongs to the requester, and
         * not the bucket owner. Also, if you use a key ID, you can run into a LogDestination undeliverable error when
         * creating a VPC flow log.
         * </p>
         * </li>
         * <li>
         * <p>
         * <b>Directory buckets</b> - When you specify an <a
         * href="https://docs.aws.amazon.com/kms/latest/developerguide/concepts.html#customer-cmk">KMS customer managed
         * key</a> for encryption in your directory bucket, only use the key ID or key ARN. The key alias format of the
         * KMS key isn't supported.
         * </p>
         * </li>
         * </ul>
         * </note> <important>
         * <p>
         * Amazon S3 only supports symmetric encryption KMS keys. For more information, see <a
         * href="https://docs.aws.amazon.com/kms/latest/developerguide/symmetric-asymmetric.html">Asymmetric keys in
         * Amazon Web Services KMS</a> in the <i>Amazon Web Services Key Management Service Developer Guide</i>.
         * </p>
         * </important>
         * 
         * @param kmsMasterKeyID
         *        Amazon Web Services Key Management Service (KMS) customer managed key ID to use for the default
         *        encryption. </p> <note>
         *        <ul>
         *        <li>
         *        <p>
         *        <b>General purpose buckets</b> - This parameter is allowed if and only if <code>SSEAlgorithm</code> is
         *        set to <code>aws:kms</code> or <code>aws:kms:dsse</code>.
         *        </p>
         *        </li>
         *        <li>
         *        <p>
         *        <b>Directory buckets</b> - This parameter is allowed if and only if <code>SSEAlgorithm</code> is set
         *        to <code>aws:kms</code>.
         *        </p>
         *        </li>
         *        </ul>
         *        </note>
         *        <p>
         *        You can specify the key ID, key alias, or the Amazon Resource Name (ARN) of the KMS key.
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
         *        Key Alias: <code>alias/alias-name</code>
         *        </p>
         *        </li>
         *        </ul>
         *        <p>
         *        If you are using encryption with cross-account or Amazon Web Services service operations, you must use
         *        a fully qualified KMS key ARN. For more information, see <a href=
         *        "https://docs.aws.amazon.com/AmazonS3/latest/dev/bucket-encryption.html#bucket-encryption-update-bucket-policy"
         *        >Using encryption for cross-account operations</a>.
         *        </p>
         *        <note>
         *        <ul>
         *        <li>
         *        <p>
         *        <b>General purpose buckets</b> - If you're specifying a customer managed KMS key, we recommend using a
         *        fully qualified KMS key ARN. If you use a KMS key alias instead, then KMS resolves the key within the
         *        requester’s account. This behavior can result in data that's encrypted with a KMS key that belongs to
         *        the requester, and not the bucket owner. Also, if you use a key ID, you can run into a LogDestination
         *        undeliverable error when creating a VPC flow log.
         *        </p>
         *        </li>
         *        <li>
         *        <p>
         *        <b>Directory buckets</b> - When you specify an <a
         *        href="https://docs.aws.amazon.com/kms/latest/developerguide/concepts.html#customer-cmk">KMS customer
         *        managed key</a> for encryption in your directory bucket, only use the key ID or key ARN. The key alias
         *        format of the KMS key isn't supported.
         *        </p>
         *        </li>
         *        </ul>
         *        </note> <important>
         *        <p>
         *        Amazon S3 only supports symmetric encryption KMS keys. For more information, see <a
         *        href="https://docs.aws.amazon.com/kms/latest/developerguide/symmetric-asymmetric.html">Asymmetric keys
         *        in Amazon Web Services KMS</a> in the <i>Amazon Web Services Key Management Service Developer
         *        Guide</i>.
         *        </p>
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder kmsMasterKeyID(String kmsMasterKeyID);
    }

    static final class BuilderImpl implements Builder {
        private String sseAlgorithm;

        private String kmsMasterKeyID;

        private BuilderImpl() {
        }

        private BuilderImpl(ServerSideEncryptionByDefault model) {
            sseAlgorithm(model.sseAlgorithm);
            kmsMasterKeyID(model.kmsMasterKeyID);
        }

        public final String getSseAlgorithm() {
            return sseAlgorithm;
        }

        public final void setSseAlgorithm(String sseAlgorithm) {
            this.sseAlgorithm = sseAlgorithm;
        }

        @Override
        public final Builder sseAlgorithm(String sseAlgorithm) {
            this.sseAlgorithm = sseAlgorithm;
            return this;
        }

        @Override
        public final Builder sseAlgorithm(ServerSideEncryption sseAlgorithm) {
            this.sseAlgorithm(sseAlgorithm == null ? null : sseAlgorithm.toString());
            return this;
        }

        public final String getKmsMasterKeyID() {
            return kmsMasterKeyID;
        }

        public final void setKmsMasterKeyID(String kmsMasterKeyID) {
            this.kmsMasterKeyID = kmsMasterKeyID;
        }

        @Override
        public final Builder kmsMasterKeyID(String kmsMasterKeyID) {
            this.kmsMasterKeyID = kmsMasterKeyID;
            return this;
        }

        @Override
        public ServerSideEncryptionByDefault build() {
            return new ServerSideEncryptionByDefault(this);
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
