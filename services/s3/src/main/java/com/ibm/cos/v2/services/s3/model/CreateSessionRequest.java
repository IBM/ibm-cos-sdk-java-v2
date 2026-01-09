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
import com.ibm.cos.v2.core.traits.RequiredTrait;
import com.ibm.cos.v2.utils.ToString;
import com.ibm.cos.v2.utils.builder.CopyableBuilder;
import com.ibm.cos.v2.utils.builder.ToCopyableBuilder;

/**
 */
@Generated("com.ibm.cos.v2:codegen")
public final class CreateSessionRequest extends S3Request implements
        ToCopyableBuilder<CreateSessionRequest.Builder, CreateSessionRequest> {
    private static final SdkField<String> SESSION_MODE_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("SessionMode")
            .getter(getter(CreateSessionRequest::sessionModeAsString))
            .setter(setter(Builder::sessionMode))
            .traits(LocationTrait.builder().location(MarshallLocation.HEADER).locationName("x-amz-create-session-mode")
                    .unmarshallLocationName("x-amz-create-session-mode").build()).build();

    private static final SdkField<String> BUCKET_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("Bucket")
            .getter(getter(CreateSessionRequest::bucket))
            .setter(setter(Builder::bucket))
            .traits(LocationTrait.builder().location(MarshallLocation.PATH).locationName("Bucket")
                    .unmarshallLocationName("Bucket").build(), RequiredTrait.create()).build();

    private static final SdkField<String> SERVER_SIDE_ENCRYPTION_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("ServerSideEncryption")
            .getter(getter(CreateSessionRequest::serverSideEncryptionAsString))
            .setter(setter(Builder::serverSideEncryption))
            .traits(LocationTrait.builder().location(MarshallLocation.HEADER).locationName("x-amz-server-side-encryption")
                    .unmarshallLocationName("x-amz-server-side-encryption").build()).build();

    private static final SdkField<String> SSEKMS_KEY_ID_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("SSEKMSKeyId")
            .getter(getter(CreateSessionRequest::ssekmsKeyId))
            .setter(setter(Builder::ssekmsKeyId))
            .traits(LocationTrait.builder().location(MarshallLocation.HEADER)
                    .locationName("x-amz-server-side-encryption-aws-kms-key-id")
                    .unmarshallLocationName("x-amz-server-side-encryption-aws-kms-key-id").build()).build();

    private static final SdkField<String> SSEKMS_ENCRYPTION_CONTEXT_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("SSEKMSEncryptionContext")
            .getter(getter(CreateSessionRequest::ssekmsEncryptionContext))
            .setter(setter(Builder::ssekmsEncryptionContext))
            .traits(LocationTrait.builder().location(MarshallLocation.HEADER)
                    .locationName("x-amz-server-side-encryption-context")
                    .unmarshallLocationName("x-amz-server-side-encryption-context").build()).build();

    private static final SdkField<Boolean> BUCKET_KEY_ENABLED_FIELD = SdkField
            .<Boolean> builder(MarshallingType.BOOLEAN)
            .memberName("BucketKeyEnabled")
            .getter(getter(CreateSessionRequest::bucketKeyEnabled))
            .setter(setter(Builder::bucketKeyEnabled))
            .traits(LocationTrait.builder().location(MarshallLocation.HEADER)
                    .locationName("x-amz-server-side-encryption-bucket-key-enabled")
                    .unmarshallLocationName("x-amz-server-side-encryption-bucket-key-enabled").build()).build();

    private static final List<SdkField<?>> SDK_FIELDS = Collections.unmodifiableList(Arrays.asList(SESSION_MODE_FIELD,
            BUCKET_FIELD, SERVER_SIDE_ENCRYPTION_FIELD, SSEKMS_KEY_ID_FIELD, SSEKMS_ENCRYPTION_CONTEXT_FIELD,
            BUCKET_KEY_ENABLED_FIELD));

    private static final Map<String, SdkField<?>> SDK_NAME_TO_FIELD = memberNameToFieldInitializer();

    private final String sessionMode;

    private final String bucket;

    private final String serverSideEncryption;

    private final String ssekmsKeyId;

    private final String ssekmsEncryptionContext;

    private final Boolean bucketKeyEnabled;

    private CreateSessionRequest(BuilderImpl builder) {
        super(builder);
        this.sessionMode = builder.sessionMode;
        this.bucket = builder.bucket;
        this.serverSideEncryption = builder.serverSideEncryption;
        this.ssekmsKeyId = builder.ssekmsKeyId;
        this.ssekmsEncryptionContext = builder.ssekmsEncryptionContext;
        this.bucketKeyEnabled = builder.bucketKeyEnabled;
    }

    /**
     * <p>
     * Specifies the mode of the session that will be created, either <code>ReadWrite</code> or <code>ReadOnly</code>.
     * By default, a <code>ReadWrite</code> session is created. A <code>ReadWrite</code> session is capable of executing
     * all the Zonal endpoint API operations on a directory bucket. A <code>ReadOnly</code> session is constrained to
     * execute the following Zonal endpoint API operations: <code>GetObject</code>, <code>HeadObject</code>,
     * <code>ListObjectsV2</code>, <code>GetObjectAttributes</code>, <code>ListParts</code>, and
     * <code>ListMultipartUploads</code>.
     * </p>
     * <p>
     * If the service returns an enum value that is not available in the current SDK version, {@link #sessionMode} will
     * return {@link SessionMode#UNKNOWN_TO_SDK_VERSION}. The raw value returned by the service is available from
     * {@link #sessionModeAsString}.
     * </p>
     * 
     * @return Specifies the mode of the session that will be created, either <code>ReadWrite</code> or
     *         <code>ReadOnly</code>. By default, a <code>ReadWrite</code> session is created. A <code>ReadWrite</code>
     *         session is capable of executing all the Zonal endpoint API operations on a directory bucket. A
     *         <code>ReadOnly</code> session is constrained to execute the following Zonal endpoint API operations:
     *         <code>GetObject</code>, <code>HeadObject</code>, <code>ListObjectsV2</code>,
     *         <code>GetObjectAttributes</code>, <code>ListParts</code>, and <code>ListMultipartUploads</code>.
     * @see SessionMode
     */
    public final SessionMode sessionMode() {
        return SessionMode.fromValue(sessionMode);
    }

    /**
     * <p>
     * Specifies the mode of the session that will be created, either <code>ReadWrite</code> or <code>ReadOnly</code>.
     * By default, a <code>ReadWrite</code> session is created. A <code>ReadWrite</code> session is capable of executing
     * all the Zonal endpoint API operations on a directory bucket. A <code>ReadOnly</code> session is constrained to
     * execute the following Zonal endpoint API operations: <code>GetObject</code>, <code>HeadObject</code>,
     * <code>ListObjectsV2</code>, <code>GetObjectAttributes</code>, <code>ListParts</code>, and
     * <code>ListMultipartUploads</code>.
     * </p>
     * <p>
     * If the service returns an enum value that is not available in the current SDK version, {@link #sessionMode} will
     * return {@link SessionMode#UNKNOWN_TO_SDK_VERSION}. The raw value returned by the service is available from
     * {@link #sessionModeAsString}.
     * </p>
     * 
     * @return Specifies the mode of the session that will be created, either <code>ReadWrite</code> or
     *         <code>ReadOnly</code>. By default, a <code>ReadWrite</code> session is created. A <code>ReadWrite</code>
     *         session is capable of executing all the Zonal endpoint API operations on a directory bucket. A
     *         <code>ReadOnly</code> session is constrained to execute the following Zonal endpoint API operations:
     *         <code>GetObject</code>, <code>HeadObject</code>, <code>ListObjectsV2</code>,
     *         <code>GetObjectAttributes</code>, <code>ListParts</code>, and <code>ListMultipartUploads</code>.
     * @see SessionMode
     */
    public final String sessionModeAsString() {
        return sessionMode;
    }

    /**
     * <p>
     * The name of the bucket that you create a session for.
     * </p>
     * 
     * @return The name of the bucket that you create a session for.
     */
    public final String bucket() {
        return bucket;
    }

    /**
     * <p>
     * The server-side encryption algorithm to use when you store objects in the directory bucket.
     * </p>
     * <p>
     * For directory buckets, there are only two supported options for server-side encryption: server-side encryption
     * with Amazon S3 managed keys (SSE-S3) (<code>AES256</code>) and server-side encryption with KMS keys (SSE-KMS) (
     * <code>aws:kms</code>). By default, Amazon S3 encrypts data with SSE-S3. For more information, see <a
     * href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/serv-side-encryption.html">Protecting data with
     * server-side encryption</a> in the <i>Amazon S3 User Guide</i>.
     * </p>
     * <p>
     * If the service returns an enum value that is not available in the current SDK version,
     * {@link #serverSideEncryption} will return {@link ServerSideEncryption#UNKNOWN_TO_SDK_VERSION}. The raw value
     * returned by the service is available from {@link #serverSideEncryptionAsString}.
     * </p>
     * 
     * @return The server-side encryption algorithm to use when you store objects in the directory bucket.</p>
     *         <p>
     *         For directory buckets, there are only two supported options for server-side encryption: server-side
     *         encryption with Amazon S3 managed keys (SSE-S3) (<code>AES256</code>) and server-side encryption with KMS
     *         keys (SSE-KMS) (<code>aws:kms</code>). By default, Amazon S3 encrypts data with SSE-S3. For more
     *         information, see <a
     *         href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/serv-side-encryption.html">Protecting data
     *         with server-side encryption</a> in the <i>Amazon S3 User Guide</i>.
     * @see ServerSideEncryption
     */
    public final ServerSideEncryption serverSideEncryption() {
        return ServerSideEncryption.fromValue(serverSideEncryption);
    }

    /**
     * <p>
     * The server-side encryption algorithm to use when you store objects in the directory bucket.
     * </p>
     * <p>
     * For directory buckets, there are only two supported options for server-side encryption: server-side encryption
     * with Amazon S3 managed keys (SSE-S3) (<code>AES256</code>) and server-side encryption with KMS keys (SSE-KMS) (
     * <code>aws:kms</code>). By default, Amazon S3 encrypts data with SSE-S3. For more information, see <a
     * href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/serv-side-encryption.html">Protecting data with
     * server-side encryption</a> in the <i>Amazon S3 User Guide</i>.
     * </p>
     * <p>
     * If the service returns an enum value that is not available in the current SDK version,
     * {@link #serverSideEncryption} will return {@link ServerSideEncryption#UNKNOWN_TO_SDK_VERSION}. The raw value
     * returned by the service is available from {@link #serverSideEncryptionAsString}.
     * </p>
     * 
     * @return The server-side encryption algorithm to use when you store objects in the directory bucket.</p>
     *         <p>
     *         For directory buckets, there are only two supported options for server-side encryption: server-side
     *         encryption with Amazon S3 managed keys (SSE-S3) (<code>AES256</code>) and server-side encryption with KMS
     *         keys (SSE-KMS) (<code>aws:kms</code>). By default, Amazon S3 encrypts data with SSE-S3. For more
     *         information, see <a
     *         href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/serv-side-encryption.html">Protecting data
     *         with server-side encryption</a> in the <i>Amazon S3 User Guide</i>.
     * @see ServerSideEncryption
     */
    public final String serverSideEncryptionAsString() {
        return serverSideEncryption;
    }

    /**
     * <p>
     * If you specify <code>x-amz-server-side-encryption</code> with <code>aws:kms</code>, you must specify the
     * <code> x-amz-server-side-encryption-aws-kms-key-id</code> header with the ID (Key ID or Key ARN) of the KMS
     * symmetric encryption customer managed key to use. Otherwise, you get an HTTP <code>400 Bad Request</code> error.
     * Only use the key ID or key ARN. The key alias format of the KMS key isn't supported. Also, if the KMS key doesn't
     * exist in the same account that't issuing the command, you must use the full Key ARN not the Key ID.
     * </p>
     * <p>
     * Your SSE-KMS configuration can only support 1 <a
     * href="https://docs.aws.amazon.com/kms/latest/developerguide/concepts.html#customer-cmk">customer managed key</a>
     * per directory bucket's lifetime. The <a
     * href="https://docs.aws.amazon.com/kms/latest/developerguide/concepts.html#aws-managed-cmk">Amazon Web Services
     * managed key</a> (<code>aws/s3</code>) isn't supported.
     * </p>
     * 
     * @return If you specify <code>x-amz-server-side-encryption</code> with <code>aws:kms</code>, you must specify the
     *         <code> x-amz-server-side-encryption-aws-kms-key-id</code> header with the ID (Key ID or Key ARN) of the
     *         KMS symmetric encryption customer managed key to use. Otherwise, you get an HTTP
     *         <code>400 Bad Request</code> error. Only use the key ID or key ARN. The key alias format of the KMS key
     *         isn't supported. Also, if the KMS key doesn't exist in the same account that't issuing the command, you
     *         must use the full Key ARN not the Key ID. </p>
     *         <p>
     *         Your SSE-KMS configuration can only support 1 <a
     *         href="https://docs.aws.amazon.com/kms/latest/developerguide/concepts.html#customer-cmk">customer managed
     *         key</a> per directory bucket's lifetime. The <a
     *         href="https://docs.aws.amazon.com/kms/latest/developerguide/concepts.html#aws-managed-cmk">Amazon Web
     *         Services managed key</a> (<code>aws/s3</code>) isn't supported.
     */
    public final String ssekmsKeyId() {
        return ssekmsKeyId;
    }

    /**
     * <p>
     * Specifies the Amazon Web Services KMS Encryption Context as an additional encryption context to use for object
     * encryption. The value of this header is a Base64 encoded string of a UTF-8 encoded JSON, which contains the
     * encryption context as key-value pairs. This value is stored as object metadata and automatically gets passed on
     * to Amazon Web Services KMS for future <code>GetObject</code> operations on this object.
     * </p>
     * <p>
     * <b>General purpose buckets</b> - This value must be explicitly added during <code>CopyObject</code> operations if
     * you want an additional encryption context for your object. For more information, see <a
     * href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/UsingKMSEncryption.html#encryption-context"
     * >Encryption context</a> in the <i>Amazon S3 User Guide</i>.
     * </p>
     * <p>
     * <b>Directory buckets</b> - You can optionally provide an explicit encryption context value. The value must match
     * the default encryption context - the bucket Amazon Resource Name (ARN). An additional encryption context value is
     * not supported.
     * </p>
     * 
     * @return Specifies the Amazon Web Services KMS Encryption Context as an additional encryption context to use for
     *         object encryption. The value of this header is a Base64 encoded string of a UTF-8 encoded JSON, which
     *         contains the encryption context as key-value pairs. This value is stored as object metadata and
     *         automatically gets passed on to Amazon Web Services KMS for future <code>GetObject</code> operations on
     *         this object.</p>
     *         <p>
     *         <b>General purpose buckets</b> - This value must be explicitly added during <code>CopyObject</code>
     *         operations if you want an additional encryption context for your object. For more information, see <a
     *         href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/UsingKMSEncryption.html#encryption-context">
     *         Encryption context</a> in the <i>Amazon S3 User Guide</i>.
     *         </p>
     *         <p>
     *         <b>Directory buckets</b> - You can optionally provide an explicit encryption context value. The value
     *         must match the default encryption context - the bucket Amazon Resource Name (ARN). An additional
     *         encryption context value is not supported.
     */
    public final String ssekmsEncryptionContext() {
        return ssekmsEncryptionContext;
    }

    /**
     * <p>
     * Specifies whether Amazon S3 should use an S3 Bucket Key for object encryption with server-side encryption using
     * KMS keys (SSE-KMS).
     * </p>
     * <p>
     * S3 Bucket Keys are always enabled for <code>GET</code> and <code>PUT</code> operations in a directory bucket and
     * can’t be disabled. S3 Bucket Keys aren't supported, when you copy SSE-KMS encrypted objects from general purpose
     * buckets to directory buckets, from directory buckets to general purpose buckets, or between directory buckets,
     * through <a href="https://docs.aws.amazon.com/AmazonS3/latest/API/API_CopyObject.html">CopyObject</a>, <a
     * href="https://docs.aws.amazon.com/AmazonS3/latest/API/API_UploadPartCopy.html">UploadPartCopy</a>, <a
     * href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/directory-buckets-objects-Batch-Ops">the Copy
     * operation in Batch Operations</a>, or <a
     * href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/create-import-job">the import jobs</a>. In this case,
     * Amazon S3 makes a call to KMS every time a copy request is made for a KMS-encrypted object.
     * </p>
     * 
     * @return Specifies whether Amazon S3 should use an S3 Bucket Key for object encryption with server-side encryption
     *         using KMS keys (SSE-KMS).</p>
     *         <p>
     *         S3 Bucket Keys are always enabled for <code>GET</code> and <code>PUT</code> operations in a directory
     *         bucket and can’t be disabled. S3 Bucket Keys aren't supported, when you copy SSE-KMS encrypted objects
     *         from general purpose buckets to directory buckets, from directory buckets to general purpose buckets, or
     *         between directory buckets, through <a
     *         href="https://docs.aws.amazon.com/AmazonS3/latest/API/API_CopyObject.html">CopyObject</a>, <a
     *         href="https://docs.aws.amazon.com/AmazonS3/latest/API/API_UploadPartCopy.html">UploadPartCopy</a>, <a
     *         href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/directory-buckets-objects-Batch-Ops">the Copy
     *         operation in Batch Operations</a>, or <a
     *         href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/create-import-job">the import jobs</a>. In
     *         this case, Amazon S3 makes a call to KMS every time a copy request is made for a KMS-encrypted object.
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
        hashCode = 31 * hashCode + super.hashCode();
        hashCode = 31 * hashCode + Objects.hashCode(sessionModeAsString());
        hashCode = 31 * hashCode + Objects.hashCode(bucket());
        hashCode = 31 * hashCode + Objects.hashCode(serverSideEncryptionAsString());
        hashCode = 31 * hashCode + Objects.hashCode(ssekmsKeyId());
        hashCode = 31 * hashCode + Objects.hashCode(ssekmsEncryptionContext());
        hashCode = 31 * hashCode + Objects.hashCode(bucketKeyEnabled());
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
        if (!(obj instanceof CreateSessionRequest)) {
            return false;
        }
        CreateSessionRequest other = (CreateSessionRequest) obj;
        return Objects.equals(sessionModeAsString(), other.sessionModeAsString()) && Objects.equals(bucket(), other.bucket())
                && Objects.equals(serverSideEncryptionAsString(), other.serverSideEncryptionAsString())
                && Objects.equals(ssekmsKeyId(), other.ssekmsKeyId())
                && Objects.equals(ssekmsEncryptionContext(), other.ssekmsEncryptionContext())
                && Objects.equals(bucketKeyEnabled(), other.bucketKeyEnabled());
    }

    /**
     * Returns a string representation of this object. This is useful for testing and debugging. Sensitive data will be
     * redacted from this string using a placeholder value.
     */
    @Override
    public final String toString() {
        return ToString.builder("CreateSessionRequest").add("SessionMode", sessionModeAsString()).add("Bucket", bucket())
                .add("ServerSideEncryption", serverSideEncryptionAsString())
                .add("SSEKMSKeyId", ssekmsKeyId() == null ? null : "*** Sensitive Data Redacted ***")
                .add("SSEKMSEncryptionContext", ssekmsEncryptionContext() == null ? null : "*** Sensitive Data Redacted ***")
                .add("BucketKeyEnabled", bucketKeyEnabled()).build();
    }

    public final <T> Optional<T> getValueForField(String fieldName, Class<T> clazz) {
        switch (fieldName) {
        case "SessionMode":
            return Optional.ofNullable(clazz.cast(sessionModeAsString()));
        case "Bucket":
            return Optional.ofNullable(clazz.cast(bucket()));
        case "ServerSideEncryption":
            return Optional.ofNullable(clazz.cast(serverSideEncryptionAsString()));
        case "SSEKMSKeyId":
            return Optional.ofNullable(clazz.cast(ssekmsKeyId()));
        case "SSEKMSEncryptionContext":
            return Optional.ofNullable(clazz.cast(ssekmsEncryptionContext()));
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
        map.put("x-amz-create-session-mode", SESSION_MODE_FIELD);
        map.put("Bucket", BUCKET_FIELD);
        map.put("x-amz-server-side-encryption", SERVER_SIDE_ENCRYPTION_FIELD);
        map.put("x-amz-server-side-encryption-aws-kms-key-id", SSEKMS_KEY_ID_FIELD);
        map.put("x-amz-server-side-encryption-context", SSEKMS_ENCRYPTION_CONTEXT_FIELD);
        map.put("x-amz-server-side-encryption-bucket-key-enabled", BUCKET_KEY_ENABLED_FIELD);
        return Collections.unmodifiableMap(map);
    }

    private static <T> Function<Object, T> getter(Function<CreateSessionRequest, T> g) {
        return obj -> g.apply((CreateSessionRequest) obj);
    }

    private static <T> BiConsumer<Object, T> setter(BiConsumer<Builder, T> s) {
        return (obj, val) -> s.accept((Builder) obj, val);
    }

    @Mutable
    @NotThreadSafe
    public interface Builder extends S3Request.Builder, SdkPojo, CopyableBuilder<Builder, CreateSessionRequest> {
        /**
         * <p>
         * Specifies the mode of the session that will be created, either <code>ReadWrite</code> or
         * <code>ReadOnly</code>. By default, a <code>ReadWrite</code> session is created. A <code>ReadWrite</code>
         * session is capable of executing all the Zonal endpoint API operations on a directory bucket. A
         * <code>ReadOnly</code> session is constrained to execute the following Zonal endpoint API operations:
         * <code>GetObject</code>, <code>HeadObject</code>, <code>ListObjectsV2</code>, <code>GetObjectAttributes</code>, <code>ListParts</code>, and <code>ListMultipartUploads</code>.
         * </p>
         * 
         * @param sessionMode
         *        Specifies the mode of the session that will be created, either <code>ReadWrite</code> or
         *        <code>ReadOnly</code>. By default, a <code>ReadWrite</code> session is created. A
         *        <code>ReadWrite</code> session is capable of executing all the Zonal endpoint API operations on a
         *        directory bucket. A <code>ReadOnly</code> session is constrained to execute the following Zonal
         *        endpoint API operations: <code>GetObject</code>, <code>HeadObject</code>, <code>ListObjectsV2</code>,
         *        <code>GetObjectAttributes</code>, <code>ListParts</code>, and <code>ListMultipartUploads</code>.
         * @see SessionMode
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see SessionMode
         */
        Builder sessionMode(String sessionMode);

        /**
         * <p>
         * Specifies the mode of the session that will be created, either <code>ReadWrite</code> or
         * <code>ReadOnly</code>. By default, a <code>ReadWrite</code> session is created. A <code>ReadWrite</code>
         * session is capable of executing all the Zonal endpoint API operations on a directory bucket. A
         * <code>ReadOnly</code> session is constrained to execute the following Zonal endpoint API operations:
         * <code>GetObject</code>, <code>HeadObject</code>, <code>ListObjectsV2</code>, <code>GetObjectAttributes</code>, <code>ListParts</code>, and <code>ListMultipartUploads</code>.
         * </p>
         * 
         * @param sessionMode
         *        Specifies the mode of the session that will be created, either <code>ReadWrite</code> or
         *        <code>ReadOnly</code>. By default, a <code>ReadWrite</code> session is created. A
         *        <code>ReadWrite</code> session is capable of executing all the Zonal endpoint API operations on a
         *        directory bucket. A <code>ReadOnly</code> session is constrained to execute the following Zonal
         *        endpoint API operations: <code>GetObject</code>, <code>HeadObject</code>, <code>ListObjectsV2</code>,
         *        <code>GetObjectAttributes</code>, <code>ListParts</code>, and <code>ListMultipartUploads</code>.
         * @see SessionMode
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see SessionMode
         */
        Builder sessionMode(SessionMode sessionMode);

        /**
         * <p>
         * The name of the bucket that you create a session for.
         * </p>
         * 
         * @param bucket
         *        The name of the bucket that you create a session for.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder bucket(String bucket);

        /**
         * <p>
         * The server-side encryption algorithm to use when you store objects in the directory bucket.
         * </p>
         * <p>
         * For directory buckets, there are only two supported options for server-side encryption: server-side
         * encryption with Amazon S3 managed keys (SSE-S3) (<code>AES256</code>) and server-side encryption with KMS
         * keys (SSE-KMS) (<code>aws:kms</code>). By default, Amazon S3 encrypts data with SSE-S3. For more information,
         * see <a href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/serv-side-encryption.html">Protecting data
         * with server-side encryption</a> in the <i>Amazon S3 User Guide</i>.
         * </p>
         * 
         * @param serverSideEncryption
         *        The server-side encryption algorithm to use when you store objects in the directory bucket.</p>
         *        <p>
         *        For directory buckets, there are only two supported options for server-side encryption: server-side
         *        encryption with Amazon S3 managed keys (SSE-S3) (<code>AES256</code>) and server-side encryption with
         *        KMS keys (SSE-KMS) (<code>aws:kms</code>). By default, Amazon S3 encrypts data with SSE-S3. For more
         *        information, see <a
         *        href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/serv-side-encryption.html">Protecting data
         *        with server-side encryption</a> in the <i>Amazon S3 User Guide</i>.
         * @see ServerSideEncryption
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see ServerSideEncryption
         */
        Builder serverSideEncryption(String serverSideEncryption);

        /**
         * <p>
         * The server-side encryption algorithm to use when you store objects in the directory bucket.
         * </p>
         * <p>
         * For directory buckets, there are only two supported options for server-side encryption: server-side
         * encryption with Amazon S3 managed keys (SSE-S3) (<code>AES256</code>) and server-side encryption with KMS
         * keys (SSE-KMS) (<code>aws:kms</code>). By default, Amazon S3 encrypts data with SSE-S3. For more information,
         * see <a href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/serv-side-encryption.html">Protecting data
         * with server-side encryption</a> in the <i>Amazon S3 User Guide</i>.
         * </p>
         * 
         * @param serverSideEncryption
         *        The server-side encryption algorithm to use when you store objects in the directory bucket.</p>
         *        <p>
         *        For directory buckets, there are only two supported options for server-side encryption: server-side
         *        encryption with Amazon S3 managed keys (SSE-S3) (<code>AES256</code>) and server-side encryption with
         *        KMS keys (SSE-KMS) (<code>aws:kms</code>). By default, Amazon S3 encrypts data with SSE-S3. For more
         *        information, see <a
         *        href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/serv-side-encryption.html">Protecting data
         *        with server-side encryption</a> in the <i>Amazon S3 User Guide</i>.
         * @see ServerSideEncryption
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see ServerSideEncryption
         */
        Builder serverSideEncryption(ServerSideEncryption serverSideEncryption);

        /**
         * <p>
         * If you specify <code>x-amz-server-side-encryption</code> with <code>aws:kms</code>, you must specify the
         * <code> x-amz-server-side-encryption-aws-kms-key-id</code> header with the ID (Key ID or Key ARN) of the KMS
         * symmetric encryption customer managed key to use. Otherwise, you get an HTTP <code>400 Bad Request</code>
         * error. Only use the key ID or key ARN. The key alias format of the KMS key isn't supported. Also, if the KMS
         * key doesn't exist in the same account that't issuing the command, you must use the full Key ARN not the Key
         * ID.
         * </p>
         * <p>
         * Your SSE-KMS configuration can only support 1 <a
         * href="https://docs.aws.amazon.com/kms/latest/developerguide/concepts.html#customer-cmk">customer managed
         * key</a> per directory bucket's lifetime. The <a
         * href="https://docs.aws.amazon.com/kms/latest/developerguide/concepts.html#aws-managed-cmk">Amazon Web
         * Services managed key</a> (<code>aws/s3</code>) isn't supported.
         * </p>
         * 
         * @param ssekmsKeyId
         *        If you specify <code>x-amz-server-side-encryption</code> with <code>aws:kms</code>, you must specify
         *        the <code> x-amz-server-side-encryption-aws-kms-key-id</code> header with the ID (Key ID or Key ARN)
         *        of the KMS symmetric encryption customer managed key to use. Otherwise, you get an HTTP
         *        <code>400 Bad Request</code> error. Only use the key ID or key ARN. The key alias format of the KMS
         *        key isn't supported. Also, if the KMS key doesn't exist in the same account that't issuing the
         *        command, you must use the full Key ARN not the Key ID. </p>
         *        <p>
         *        Your SSE-KMS configuration can only support 1 <a
         *        href="https://docs.aws.amazon.com/kms/latest/developerguide/concepts.html#customer-cmk">customer
         *        managed key</a> per directory bucket's lifetime. The <a
         *        href="https://docs.aws.amazon.com/kms/latest/developerguide/concepts.html#aws-managed-cmk">Amazon Web
         *        Services managed key</a> (<code>aws/s3</code>) isn't supported.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder ssekmsKeyId(String ssekmsKeyId);

        /**
         * <p>
         * Specifies the Amazon Web Services KMS Encryption Context as an additional encryption context to use for
         * object encryption. The value of this header is a Base64 encoded string of a UTF-8 encoded JSON, which
         * contains the encryption context as key-value pairs. This value is stored as object metadata and automatically
         * gets passed on to Amazon Web Services KMS for future <code>GetObject</code> operations on this object.
         * </p>
         * <p>
         * <b>General purpose buckets</b> - This value must be explicitly added during <code>CopyObject</code>
         * operations if you want an additional encryption context for your object. For more information, see <a
         * href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/UsingKMSEncryption.html#encryption-context"
         * >Encryption context</a> in the <i>Amazon S3 User Guide</i>.
         * </p>
         * <p>
         * <b>Directory buckets</b> - You can optionally provide an explicit encryption context value. The value must
         * match the default encryption context - the bucket Amazon Resource Name (ARN). An additional encryption
         * context value is not supported.
         * </p>
         * 
         * @param ssekmsEncryptionContext
         *        Specifies the Amazon Web Services KMS Encryption Context as an additional encryption context to use
         *        for object encryption. The value of this header is a Base64 encoded string of a UTF-8 encoded JSON,
         *        which contains the encryption context as key-value pairs. This value is stored as object metadata and
         *        automatically gets passed on to Amazon Web Services KMS for future <code>GetObject</code> operations
         *        on this object.</p>
         *        <p>
         *        <b>General purpose buckets</b> - This value must be explicitly added during <code>CopyObject</code>
         *        operations if you want an additional encryption context for your object. For more information, see <a
         *        href
         *        ="https://docs.aws.amazon.com/AmazonS3/latest/userguide/UsingKMSEncryption.html#encryption-context"
         *        >Encryption context</a> in the <i>Amazon S3 User Guide</i>.
         *        </p>
         *        <p>
         *        <b>Directory buckets</b> - You can optionally provide an explicit encryption context value. The value
         *        must match the default encryption context - the bucket Amazon Resource Name (ARN). An additional
         *        encryption context value is not supported.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder ssekmsEncryptionContext(String ssekmsEncryptionContext);

        /**
         * <p>
         * Specifies whether Amazon S3 should use an S3 Bucket Key for object encryption with server-side encryption
         * using KMS keys (SSE-KMS).
         * </p>
         * <p>
         * S3 Bucket Keys are always enabled for <code>GET</code> and <code>PUT</code> operations in a directory bucket
         * and can’t be disabled. S3 Bucket Keys aren't supported, when you copy SSE-KMS encrypted objects from general
         * purpose buckets to directory buckets, from directory buckets to general purpose buckets, or between directory
         * buckets, through <a
         * href="https://docs.aws.amazon.com/AmazonS3/latest/API/API_CopyObject.html">CopyObject</a>, <a
         * href="https://docs.aws.amazon.com/AmazonS3/latest/API/API_UploadPartCopy.html">UploadPartCopy</a>, <a
         * href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/directory-buckets-objects-Batch-Ops">the Copy
         * operation in Batch Operations</a>, or <a
         * href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/create-import-job">the import jobs</a>. In this
         * case, Amazon S3 makes a call to KMS every time a copy request is made for a KMS-encrypted object.
         * </p>
         * 
         * @param bucketKeyEnabled
         *        Specifies whether Amazon S3 should use an S3 Bucket Key for object encryption with server-side
         *        encryption using KMS keys (SSE-KMS).</p>
         *        <p>
         *        S3 Bucket Keys are always enabled for <code>GET</code> and <code>PUT</code> operations in a directory
         *        bucket and can’t be disabled. S3 Bucket Keys aren't supported, when you copy SSE-KMS encrypted objects
         *        from general purpose buckets to directory buckets, from directory buckets to general purpose buckets,
         *        or between directory buckets, through <a
         *        href="https://docs.aws.amazon.com/AmazonS3/latest/API/API_CopyObject.html">CopyObject</a>, <a
         *        href="https://docs.aws.amazon.com/AmazonS3/latest/API/API_UploadPartCopy.html">UploadPartCopy</a>, <a
         *        href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/directory-buckets-objects-Batch-Ops">the
         *        Copy operation in Batch Operations</a>, or <a
         *        href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/create-import-job">the import jobs</a>. In
         *        this case, Amazon S3 makes a call to KMS every time a copy request is made for a KMS-encrypted object.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder bucketKeyEnabled(Boolean bucketKeyEnabled);

        @Override
        Builder overrideConfiguration(AwsRequestOverrideConfiguration overrideConfiguration);

        @Override
        Builder overrideConfiguration(Consumer<AwsRequestOverrideConfiguration.Builder> builderConsumer);
    }

    static final class BuilderImpl extends S3Request.BuilderImpl implements Builder {
        private String sessionMode;

        private String bucket;

        private String serverSideEncryption;

        private String ssekmsKeyId;

        private String ssekmsEncryptionContext;

        private Boolean bucketKeyEnabled;

        private BuilderImpl() {
        }

        private BuilderImpl(CreateSessionRequest model) {
            super(model);
            sessionMode(model.sessionMode);
            bucket(model.bucket);
            serverSideEncryption(model.serverSideEncryption);
            ssekmsKeyId(model.ssekmsKeyId);
            ssekmsEncryptionContext(model.ssekmsEncryptionContext);
            bucketKeyEnabled(model.bucketKeyEnabled);
        }

        public final String getSessionMode() {
            return sessionMode;
        }

        public final void setSessionMode(String sessionMode) {
            this.sessionMode = sessionMode;
        }

        @Override
        public final Builder sessionMode(String sessionMode) {
            this.sessionMode = sessionMode;
            return this;
        }

        @Override
        public final Builder sessionMode(SessionMode sessionMode) {
            this.sessionMode(sessionMode == null ? null : sessionMode.toString());
            return this;
        }

        public final String getBucket() {
            return bucket;
        }

        public final void setBucket(String bucket) {
            this.bucket = bucket;
        }

        @Override
        public final Builder bucket(String bucket) {
            this.bucket = bucket;
            return this;
        }

        public final String getServerSideEncryption() {
            return serverSideEncryption;
        }

        public final void setServerSideEncryption(String serverSideEncryption) {
            this.serverSideEncryption = serverSideEncryption;
        }

        @Override
        public final Builder serverSideEncryption(String serverSideEncryption) {
            this.serverSideEncryption = serverSideEncryption;
            return this;
        }

        @Override
        public final Builder serverSideEncryption(ServerSideEncryption serverSideEncryption) {
            this.serverSideEncryption(serverSideEncryption == null ? null : serverSideEncryption.toString());
            return this;
        }

        public final String getSsekmsKeyId() {
            return ssekmsKeyId;
        }

        public final void setSsekmsKeyId(String ssekmsKeyId) {
            this.ssekmsKeyId = ssekmsKeyId;
        }

        @Override
        public final Builder ssekmsKeyId(String ssekmsKeyId) {
            this.ssekmsKeyId = ssekmsKeyId;
            return this;
        }

        public final String getSsekmsEncryptionContext() {
            return ssekmsEncryptionContext;
        }

        public final void setSsekmsEncryptionContext(String ssekmsEncryptionContext) {
            this.ssekmsEncryptionContext = ssekmsEncryptionContext;
        }

        @Override
        public final Builder ssekmsEncryptionContext(String ssekmsEncryptionContext) {
            this.ssekmsEncryptionContext = ssekmsEncryptionContext;
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
        public CreateSessionRequest build() {
            return new CreateSessionRequest(this);
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
