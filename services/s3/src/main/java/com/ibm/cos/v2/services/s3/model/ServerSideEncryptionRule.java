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
import java.util.function.Consumer;
import java.util.function.Function;
import com.ibm.cos.v2.annotations.Generated;
import com.ibm.cos.v2.annotations.Mutable;
import com.ibm.cos.v2.annotations.NotThreadSafe;
import com.ibm.cos.v2.core.SdkField;
import com.ibm.cos.v2.core.SdkPojo;
import com.ibm.cos.v2.core.protocol.MarshallLocation;
import com.ibm.cos.v2.core.protocol.MarshallingType;
import com.ibm.cos.v2.core.traits.LocationTrait;
import com.ibm.cos.v2.utils.ToString;
import com.ibm.cos.v2.utils.builder.CopyableBuilder;
import com.ibm.cos.v2.utils.builder.ToCopyableBuilder;

/**
 * <p>
 * Specifies the default server-side encryption configuration.
 * </p>
 * <note>
 * <ul>
 * <li>
 * <p>
 * <b>General purpose buckets</b> - If you're specifying a customer managed KMS key, we recommend using a fully
 * qualified KMS key ARN. If you use a KMS key alias instead, then KMS resolves the key within the requester’s account.
 * This behavior can result in data that's encrypted with a KMS key that belongs to the requester, and not the bucket
 * owner.
 * </p>
 * </li>
 * <li>
 * <p>
 * <b>Directory buckets</b> - When you specify an <a
 * href="https://docs.aws.amazon.com/kms/latest/developerguide/concepts.html#customer-cmk">KMS customer managed key</a>
 * for encryption in your directory bucket, only use the key ID or key ARN. The key alias format of the KMS key isn't
 * supported.
 * </p>
 * </li>
 * </ul>
 * </note>
 */
@Generated("com.ibm.cos.v2:codegen")
public final class ServerSideEncryptionRule implements SdkPojo, Serializable,
        ToCopyableBuilder<ServerSideEncryptionRule.Builder, ServerSideEncryptionRule> {
    private static final SdkField<ServerSideEncryptionByDefault> APPLY_SERVER_SIDE_ENCRYPTION_BY_DEFAULT_FIELD = SdkField
            .<ServerSideEncryptionByDefault> builder(MarshallingType.SDK_POJO)
            .memberName("ApplyServerSideEncryptionByDefault")
            .getter(getter(ServerSideEncryptionRule::applyServerSideEncryptionByDefault))
            .setter(setter(Builder::applyServerSideEncryptionByDefault))
            .constructor(ServerSideEncryptionByDefault::builder)
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("ApplyServerSideEncryptionByDefault")
                    .unmarshallLocationName("ApplyServerSideEncryptionByDefault").build()).build();

    private static final SdkField<Boolean> BUCKET_KEY_ENABLED_FIELD = SdkField
            .<Boolean> builder(MarshallingType.BOOLEAN)
            .memberName("BucketKeyEnabled")
            .getter(getter(ServerSideEncryptionRule::bucketKeyEnabled))
            .setter(setter(Builder::bucketKeyEnabled))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("BucketKeyEnabled")
                    .unmarshallLocationName("BucketKeyEnabled").build()).build();

    private static final List<SdkField<?>> SDK_FIELDS = Collections.unmodifiableList(Arrays.asList(
            APPLY_SERVER_SIDE_ENCRYPTION_BY_DEFAULT_FIELD, BUCKET_KEY_ENABLED_FIELD));

    private static final Map<String, SdkField<?>> SDK_NAME_TO_FIELD = memberNameToFieldInitializer();

    private static final long serialVersionUID = 1L;

    private final ServerSideEncryptionByDefault applyServerSideEncryptionByDefault;

    private final Boolean bucketKeyEnabled;

    private ServerSideEncryptionRule(BuilderImpl builder) {
        this.applyServerSideEncryptionByDefault = builder.applyServerSideEncryptionByDefault;
        this.bucketKeyEnabled = builder.bucketKeyEnabled;
    }

    /**
     * <p>
     * Specifies the default server-side encryption to apply to new objects in the bucket. If a PUT Object request
     * doesn't specify any server-side encryption, this default encryption will be applied.
     * </p>
     * 
     * @return Specifies the default server-side encryption to apply to new objects in the bucket. If a PUT Object
     *         request doesn't specify any server-side encryption, this default encryption will be applied.
     */
    public final ServerSideEncryptionByDefault applyServerSideEncryptionByDefault() {
        return applyServerSideEncryptionByDefault;
    }

    /**
     * <p>
     * Specifies whether Amazon S3 should use an S3 Bucket Key with server-side encryption using KMS (SSE-KMS) for new
     * objects in the bucket. Existing objects are not affected. Setting the <code>BucketKeyEnabled</code> element to
     * <code>true</code> causes Amazon S3 to use an S3 Bucket Key.
     * </p>
     * <note>
     * <ul>
     * <li>
     * <p>
     * <b>General purpose buckets</b> - By default, S3 Bucket Key is not enabled. For more information, see <a
     * href="https://docs.aws.amazon.com/AmazonS3/latest/dev/bucket-key.html">Amazon S3 Bucket Keys</a> in the <i>Amazon
     * S3 User Guide</i>.
     * </p>
     * </li>
     * <li>
     * <p>
     * <b>Directory buckets</b> - S3 Bucket Keys are always enabled for <code>GET</code> and <code>PUT</code> operations
     * in a directory bucket and can’t be disabled. S3 Bucket Keys aren't supported, when you copy SSE-KMS encrypted
     * objects from general purpose buckets to directory buckets, from directory buckets to general purpose buckets, or
     * between directory buckets, through <a
     * href="https://docs.aws.amazon.com/AmazonS3/latest/API/API_CopyObject.html">CopyObject</a>, <a
     * href="https://docs.aws.amazon.com/AmazonS3/latest/API/API_UploadPartCopy.html">UploadPartCopy</a>, <a
     * href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/directory-buckets-objects-Batch-Ops">the Copy
     * operation in Batch Operations</a>, or <a
     * href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/create-import-job">the import jobs</a>. In this case,
     * Amazon S3 makes a call to KMS every time a copy request is made for a KMS-encrypted object.
     * </p>
     * </li>
     * </ul>
     * </note>
     * 
     * @return Specifies whether Amazon S3 should use an S3 Bucket Key with server-side encryption using KMS (SSE-KMS)
     *         for new objects in the bucket. Existing objects are not affected. Setting the
     *         <code>BucketKeyEnabled</code> element to <code>true</code> causes Amazon S3 to use an S3 Bucket Key. </p>
     *         <note>
     *         <ul>
     *         <li>
     *         <p>
     *         <b>General purpose buckets</b> - By default, S3 Bucket Key is not enabled. For more information, see <a
     *         href="https://docs.aws.amazon.com/AmazonS3/latest/dev/bucket-key.html">Amazon S3 Bucket Keys</a> in the
     *         <i>Amazon S3 User Guide</i>.
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         <b>Directory buckets</b> - S3 Bucket Keys are always enabled for <code>GET</code> and <code>PUT</code>
     *         operations in a directory bucket and can’t be disabled. S3 Bucket Keys aren't supported, when you copy
     *         SSE-KMS encrypted objects from general purpose buckets to directory buckets, from directory buckets to
     *         general purpose buckets, or between directory buckets, through <a
     *         href="https://docs.aws.amazon.com/AmazonS3/latest/API/API_CopyObject.html">CopyObject</a>, <a
     *         href="https://docs.aws.amazon.com/AmazonS3/latest/API/API_UploadPartCopy.html">UploadPartCopy</a>, <a
     *         href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/directory-buckets-objects-Batch-Ops">the Copy
     *         operation in Batch Operations</a>, or <a
     *         href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/create-import-job">the import jobs</a>. In
     *         this case, Amazon S3 makes a call to KMS every time a copy request is made for a KMS-encrypted object.
     *         </p>
     *         </li>
     *         </ul>
     */
    public final Boolean bucketKeyEnabled() {
        return bucketKeyEnabled;
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
        hashCode = 31 * hashCode + Objects.hashCode(applyServerSideEncryptionByDefault());
        hashCode = 31 * hashCode + Objects.hashCode(bucketKeyEnabled());
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
        if (!(obj instanceof ServerSideEncryptionRule)) {
            return false;
        }
        ServerSideEncryptionRule other = (ServerSideEncryptionRule) obj;
        return Objects.equals(applyServerSideEncryptionByDefault(), other.applyServerSideEncryptionByDefault())
                && Objects.equals(bucketKeyEnabled(), other.bucketKeyEnabled());
    }

    /**
     * Returns a string representation of this object. This is useful for testing and debugging. Sensitive data will be
     * redacted from this string using a placeholder value.
     */
    @Override
    public final String toString() {
        return ToString.builder("ServerSideEncryptionRule")
                .add("ApplyServerSideEncryptionByDefault", applyServerSideEncryptionByDefault())
                .add("BucketKeyEnabled", bucketKeyEnabled()).build();
    }

    public final <T> Optional<T> getValueForField(String fieldName, Class<T> clazz) {
        switch (fieldName) {
        case "ApplyServerSideEncryptionByDefault":
            return Optional.ofNullable(clazz.cast(applyServerSideEncryptionByDefault()));
        case "BucketKeyEnabled":
            return Optional.ofNullable(clazz.cast(bucketKeyEnabled()));
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
        map.put("ApplyServerSideEncryptionByDefault", APPLY_SERVER_SIDE_ENCRYPTION_BY_DEFAULT_FIELD);
        map.put("BucketKeyEnabled", BUCKET_KEY_ENABLED_FIELD);
        return Collections.unmodifiableMap(map);
    }

    private static <T> Function<Object, T> getter(Function<ServerSideEncryptionRule, T> g) {
        return obj -> g.apply((ServerSideEncryptionRule) obj);
    }

    private static <T> BiConsumer<Object, T> setter(BiConsumer<Builder, T> s) {
        return (obj, val) -> s.accept((Builder) obj, val);
    }

    @Mutable
    @NotThreadSafe
    public interface Builder extends SdkPojo, CopyableBuilder<Builder, ServerSideEncryptionRule> {
        /**
         * <p>
         * Specifies the default server-side encryption to apply to new objects in the bucket. If a PUT Object request
         * doesn't specify any server-side encryption, this default encryption will be applied.
         * </p>
         * 
         * @param applyServerSideEncryptionByDefault
         *        Specifies the default server-side encryption to apply to new objects in the bucket. If a PUT Object
         *        request doesn't specify any server-side encryption, this default encryption will be applied.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder applyServerSideEncryptionByDefault(ServerSideEncryptionByDefault applyServerSideEncryptionByDefault);

        /**
         * <p>
         * Specifies the default server-side encryption to apply to new objects in the bucket. If a PUT Object request
         * doesn't specify any server-side encryption, this default encryption will be applied.
         * </p>
         * This is a convenience method that creates an instance of the {@link ServerSideEncryptionByDefault.Builder}
         * avoiding the need to create one manually via {@link ServerSideEncryptionByDefault#builder()}.
         *
         * <p>
         * When the {@link Consumer} completes, {@link ServerSideEncryptionByDefault.Builder#build()} is called
         * immediately and its result is passed to
         * {@link #applyServerSideEncryptionByDefault(ServerSideEncryptionByDefault)}.
         * 
         * @param applyServerSideEncryptionByDefault
         *        a consumer that will call methods on {@link ServerSideEncryptionByDefault.Builder}
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see #applyServerSideEncryptionByDefault(ServerSideEncryptionByDefault)
         */
        default Builder applyServerSideEncryptionByDefault(
                Consumer<ServerSideEncryptionByDefault.Builder> applyServerSideEncryptionByDefault) {
            return applyServerSideEncryptionByDefault(ServerSideEncryptionByDefault.builder()
                    .applyMutation(applyServerSideEncryptionByDefault).build());
        }

        /**
         * <p>
         * Specifies whether Amazon S3 should use an S3 Bucket Key with server-side encryption using KMS (SSE-KMS) for
         * new objects in the bucket. Existing objects are not affected. Setting the <code>BucketKeyEnabled</code>
         * element to <code>true</code> causes Amazon S3 to use an S3 Bucket Key.
         * </p>
         * <note>
         * <ul>
         * <li>
         * <p>
         * <b>General purpose buckets</b> - By default, S3 Bucket Key is not enabled. For more information, see <a
         * href="https://docs.aws.amazon.com/AmazonS3/latest/dev/bucket-key.html">Amazon S3 Bucket Keys</a> in the
         * <i>Amazon S3 User Guide</i>.
         * </p>
         * </li>
         * <li>
         * <p>
         * <b>Directory buckets</b> - S3 Bucket Keys are always enabled for <code>GET</code> and <code>PUT</code>
         * operations in a directory bucket and can’t be disabled. S3 Bucket Keys aren't supported, when you copy
         * SSE-KMS encrypted objects from general purpose buckets to directory buckets, from directory buckets to
         * general purpose buckets, or between directory buckets, through <a
         * href="https://docs.aws.amazon.com/AmazonS3/latest/API/API_CopyObject.html">CopyObject</a>, <a
         * href="https://docs.aws.amazon.com/AmazonS3/latest/API/API_UploadPartCopy.html">UploadPartCopy</a>, <a
         * href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/directory-buckets-objects-Batch-Ops">the Copy
         * operation in Batch Operations</a>, or <a
         * href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/create-import-job">the import jobs</a>. In this
         * case, Amazon S3 makes a call to KMS every time a copy request is made for a KMS-encrypted object.
         * </p>
         * </li>
         * </ul>
         * </note>
         * 
         * @param bucketKeyEnabled
         *        Specifies whether Amazon S3 should use an S3 Bucket Key with server-side encryption using KMS
         *        (SSE-KMS) for new objects in the bucket. Existing objects are not affected. Setting the
         *        <code>BucketKeyEnabled</code> element to <code>true</code> causes Amazon S3 to use an S3 Bucket Key.
         *        </p> <note>
         *        <ul>
         *        <li>
         *        <p>
         *        <b>General purpose buckets</b> - By default, S3 Bucket Key is not enabled. For more information, see
         *        <a href="https://docs.aws.amazon.com/AmazonS3/latest/dev/bucket-key.html">Amazon S3 Bucket Keys</a> in
         *        the <i>Amazon S3 User Guide</i>.
         *        </p>
         *        </li>
         *        <li>
         *        <p>
         *        <b>Directory buckets</b> - S3 Bucket Keys are always enabled for <code>GET</code> and <code>PUT</code>
         *        operations in a directory bucket and can’t be disabled. S3 Bucket Keys aren't supported, when you copy
         *        SSE-KMS encrypted objects from general purpose buckets to directory buckets, from directory buckets to
         *        general purpose buckets, or between directory buckets, through <a
         *        href="https://docs.aws.amazon.com/AmazonS3/latest/API/API_CopyObject.html">CopyObject</a>, <a
         *        href="https://docs.aws.amazon.com/AmazonS3/latest/API/API_UploadPartCopy.html">UploadPartCopy</a>, <a
         *        href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/directory-buckets-objects-Batch-Ops">the
         *        Copy operation in Batch Operations</a>, or <a
         *        href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/create-import-job">the import jobs</a>. In
         *        this case, Amazon S3 makes a call to KMS every time a copy request is made for a KMS-encrypted object.
         *        </p>
         *        </li>
         *        </ul>
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder bucketKeyEnabled(Boolean bucketKeyEnabled);
    }

    static final class BuilderImpl implements Builder {
        private ServerSideEncryptionByDefault applyServerSideEncryptionByDefault;

        private Boolean bucketKeyEnabled;

        private BuilderImpl() {
        }

        private BuilderImpl(ServerSideEncryptionRule model) {
            applyServerSideEncryptionByDefault(model.applyServerSideEncryptionByDefault);
            bucketKeyEnabled(model.bucketKeyEnabled);
        }

        public final ServerSideEncryptionByDefault.Builder getApplyServerSideEncryptionByDefault() {
            return applyServerSideEncryptionByDefault != null ? applyServerSideEncryptionByDefault.toBuilder() : null;
        }

        public final void setApplyServerSideEncryptionByDefault(
                ServerSideEncryptionByDefault.BuilderImpl applyServerSideEncryptionByDefault) {
            this.applyServerSideEncryptionByDefault = applyServerSideEncryptionByDefault != null ? applyServerSideEncryptionByDefault
                    .build() : null;
        }

        @Override
        public final Builder applyServerSideEncryptionByDefault(ServerSideEncryptionByDefault applyServerSideEncryptionByDefault) {
            this.applyServerSideEncryptionByDefault = applyServerSideEncryptionByDefault;
            return this;
        }

        public final Boolean getBucketKeyEnabled() {
            return bucketKeyEnabled;
        }

        public final void setBucketKeyEnabled(Boolean bucketKeyEnabled) {
            this.bucketKeyEnabled = bucketKeyEnabled;
        }

        @Override
        public final Builder bucketKeyEnabled(Boolean bucketKeyEnabled) {
            this.bucketKeyEnabled = bucketKeyEnabled;
            return this;
        }

        @Override
        public ServerSideEncryptionRule build() {
            return new ServerSideEncryptionRule(this);
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
