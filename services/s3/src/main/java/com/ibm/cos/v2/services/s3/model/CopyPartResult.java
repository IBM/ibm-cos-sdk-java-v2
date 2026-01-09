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
import java.time.Instant;
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
import com.ibm.cos.v2.utils.ToString;
import com.ibm.cos.v2.utils.builder.CopyableBuilder;
import com.ibm.cos.v2.utils.builder.ToCopyableBuilder;

/**
 * <p>
 * Container for all response elements.
 * </p>
 */
@Generated("com.ibm.cos.v2:codegen")
public final class CopyPartResult implements SdkPojo, Serializable, ToCopyableBuilder<CopyPartResult.Builder, CopyPartResult> {
    private static final SdkField<String> E_TAG_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("ETag")
            .getter(getter(CopyPartResult::eTag))
            .setter(setter(Builder::eTag))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("ETag")
                    .unmarshallLocationName("ETag").build()).build();

    private static final SdkField<Instant> LAST_MODIFIED_FIELD = SdkField
            .<Instant> builder(MarshallingType.INSTANT)
            .memberName("LastModified")
            .getter(getter(CopyPartResult::lastModified))
            .setter(setter(Builder::lastModified))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("LastModified")
                    .unmarshallLocationName("LastModified").build()).build();

    private static final SdkField<String> CHECKSUM_CRC32_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("ChecksumCRC32")
            .getter(getter(CopyPartResult::checksumCRC32))
            .setter(setter(Builder::checksumCRC32))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("ChecksumCRC32")
                    .unmarshallLocationName("ChecksumCRC32").build()).build();

    private static final SdkField<String> CHECKSUM_CRC32_C_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("ChecksumCRC32C")
            .getter(getter(CopyPartResult::checksumCRC32C))
            .setter(setter(Builder::checksumCRC32C))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("ChecksumCRC32C")
                    .unmarshallLocationName("ChecksumCRC32C").build()).build();

    private static final SdkField<String> CHECKSUM_CRC64_NVME_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("ChecksumCRC64NVME")
            .getter(getter(CopyPartResult::checksumCRC64NVME))
            .setter(setter(Builder::checksumCRC64NVME))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("ChecksumCRC64NVME")
                    .unmarshallLocationName("ChecksumCRC64NVME").build()).build();

    private static final SdkField<String> CHECKSUM_SHA1_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("ChecksumSHA1")
            .getter(getter(CopyPartResult::checksumSHA1))
            .setter(setter(Builder::checksumSHA1))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("ChecksumSHA1")
                    .unmarshallLocationName("ChecksumSHA1").build()).build();

    private static final SdkField<String> CHECKSUM_SHA256_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("ChecksumSHA256")
            .getter(getter(CopyPartResult::checksumSHA256))
            .setter(setter(Builder::checksumSHA256))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("ChecksumSHA256")
                    .unmarshallLocationName("ChecksumSHA256").build()).build();

    private static final List<SdkField<?>> SDK_FIELDS = Collections.unmodifiableList(Arrays.asList(E_TAG_FIELD,
            LAST_MODIFIED_FIELD, CHECKSUM_CRC32_FIELD, CHECKSUM_CRC32_C_FIELD, CHECKSUM_CRC64_NVME_FIELD, CHECKSUM_SHA1_FIELD,
            CHECKSUM_SHA256_FIELD));

    private static final Map<String, SdkField<?>> SDK_NAME_TO_FIELD = memberNameToFieldInitializer();

    private static final long serialVersionUID = 1L;

    private final String eTag;

    private final Instant lastModified;

    private final String checksumCRC32;

    private final String checksumCRC32C;

    private final String checksumCRC64NVME;

    private final String checksumSHA1;

    private final String checksumSHA256;

    private CopyPartResult(BuilderImpl builder) {
        this.eTag = builder.eTag;
        this.lastModified = builder.lastModified;
        this.checksumCRC32 = builder.checksumCRC32;
        this.checksumCRC32C = builder.checksumCRC32C;
        this.checksumCRC64NVME = builder.checksumCRC64NVME;
        this.checksumSHA1 = builder.checksumSHA1;
        this.checksumSHA256 = builder.checksumSHA256;
    }

    /**
     * <p>
     * Entity tag of the object.
     * </p>
     * 
     * @return Entity tag of the object.
     */
    public final String eTag() {
        return eTag;
    }

    /**
     * <p>
     * Date and time at which the object was uploaded.
     * </p>
     * 
     * @return Date and time at which the object was uploaded.
     */
    public final Instant lastModified() {
        return lastModified;
    }

    /**
     * <p>
     * This header can be used as a data integrity check to verify that the data received is the same data that was
     * originally sent. This header specifies the Base64 encoded, 32-bit <code>CRC32</code> checksum of the part. For
     * more information, see <a
     * href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/checking-object-integrity.html">Checking object
     * integrity</a> in the <i>Amazon S3 User Guide</i>.
     * </p>
     * 
     * @return This header can be used as a data integrity check to verify that the data received is the same data that
     *         was originally sent. This header specifies the Base64 encoded, 32-bit <code>CRC32</code> checksum of the
     *         part. For more information, see <a
     *         href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/checking-object-integrity.html">Checking
     *         object integrity</a> in the <i>Amazon S3 User Guide</i>.
     */
    public final String checksumCRC32() {
        return checksumCRC32;
    }

    /**
     * <p>
     * This header can be used as a data integrity check to verify that the data received is the same data that was
     * originally sent. This header specifies the Base64 encoded, 32-bit <code>CRC32C</code> checksum of the part. For
     * more information, see <a
     * href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/checking-object-integrity.html">Checking object
     * integrity</a> in the <i>Amazon S3 User Guide</i>.
     * </p>
     * 
     * @return This header can be used as a data integrity check to verify that the data received is the same data that
     *         was originally sent. This header specifies the Base64 encoded, 32-bit <code>CRC32C</code> checksum of the
     *         part. For more information, see <a
     *         href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/checking-object-integrity.html">Checking
     *         object integrity</a> in the <i>Amazon S3 User Guide</i>.
     */
    public final String checksumCRC32C() {
        return checksumCRC32C;
    }

    /**
     * <p>
     * The Base64 encoded, 64-bit <code>CRC64NVME</code> checksum of the part. This checksum is present if the multipart
     * upload request was created with the <code>CRC64NVME</code> checksum algorithm to the uploaded object). For more
     * information, see <a
     * href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/checking-object-integrity.html">Checking object
     * integrity</a> in the <i>Amazon S3 User Guide</i>.
     * </p>
     * 
     * @return The Base64 encoded, 64-bit <code>CRC64NVME</code> checksum of the part. This checksum is present if the
     *         multipart upload request was created with the <code>CRC64NVME</code> checksum algorithm to the uploaded
     *         object). For more information, see <a
     *         href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/checking-object-integrity.html">Checking
     *         object integrity</a> in the <i>Amazon S3 User Guide</i>.
     */
    public final String checksumCRC64NVME() {
        return checksumCRC64NVME;
    }

    /**
     * <p>
     * This header can be used as a data integrity check to verify that the data received is the same data that was
     * originally sent. This header specifies the Base64 encoded, 160-bit <code>SHA1</code> checksum of the part. For
     * more information, see <a
     * href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/checking-object-integrity.html">Checking object
     * integrity</a> in the <i>Amazon S3 User Guide</i>.
     * </p>
     * 
     * @return This header can be used as a data integrity check to verify that the data received is the same data that
     *         was originally sent. This header specifies the Base64 encoded, 160-bit <code>SHA1</code> checksum of the
     *         part. For more information, see <a
     *         href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/checking-object-integrity.html">Checking
     *         object integrity</a> in the <i>Amazon S3 User Guide</i>.
     */
    public final String checksumSHA1() {
        return checksumSHA1;
    }

    /**
     * <p>
     * This header can be used as a data integrity check to verify that the data received is the same data that was
     * originally sent. This header specifies the Base64 encoded, 256-bit <code>SHA256</code> checksum of the part. For
     * more information, see <a
     * href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/checking-object-integrity.html">Checking object
     * integrity</a> in the <i>Amazon S3 User Guide</i>.
     * </p>
     * 
     * @return This header can be used as a data integrity check to verify that the data received is the same data that
     *         was originally sent. This header specifies the Base64 encoded, 256-bit <code>SHA256</code> checksum of
     *         the part. For more information, see <a
     *         href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/checking-object-integrity.html">Checking
     *         object integrity</a> in the <i>Amazon S3 User Guide</i>.
     */
    public final String checksumSHA256() {
        return checksumSHA256;
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
        hashCode = 31 * hashCode + Objects.hashCode(eTag());
        hashCode = 31 * hashCode + Objects.hashCode(lastModified());
        hashCode = 31 * hashCode + Objects.hashCode(checksumCRC32());
        hashCode = 31 * hashCode + Objects.hashCode(checksumCRC32C());
        hashCode = 31 * hashCode + Objects.hashCode(checksumCRC64NVME());
        hashCode = 31 * hashCode + Objects.hashCode(checksumSHA1());
        hashCode = 31 * hashCode + Objects.hashCode(checksumSHA256());
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
        if (!(obj instanceof CopyPartResult)) {
            return false;
        }
        CopyPartResult other = (CopyPartResult) obj;
        return Objects.equals(eTag(), other.eTag()) && Objects.equals(lastModified(), other.lastModified())
                && Objects.equals(checksumCRC32(), other.checksumCRC32())
                && Objects.equals(checksumCRC32C(), other.checksumCRC32C())
                && Objects.equals(checksumCRC64NVME(), other.checksumCRC64NVME())
                && Objects.equals(checksumSHA1(), other.checksumSHA1())
                && Objects.equals(checksumSHA256(), other.checksumSHA256());
    }

    /**
     * Returns a string representation of this object. This is useful for testing and debugging. Sensitive data will be
     * redacted from this string using a placeholder value.
     */
    @Override
    public final String toString() {
        return ToString.builder("CopyPartResult").add("ETag", eTag()).add("LastModified", lastModified())
                .add("ChecksumCRC32", checksumCRC32()).add("ChecksumCRC32C", checksumCRC32C())
                .add("ChecksumCRC64NVME", checksumCRC64NVME()).add("ChecksumSHA1", checksumSHA1())
                .add("ChecksumSHA256", checksumSHA256()).build();
    }

    public final <T> Optional<T> getValueForField(String fieldName, Class<T> clazz) {
        switch (fieldName) {
        case "ETag":
            return Optional.ofNullable(clazz.cast(eTag()));
        case "LastModified":
            return Optional.ofNullable(clazz.cast(lastModified()));
        case "ChecksumCRC32":
            return Optional.ofNullable(clazz.cast(checksumCRC32()));
        case "ChecksumCRC32C":
            return Optional.ofNullable(clazz.cast(checksumCRC32C()));
        case "ChecksumCRC64NVME":
            return Optional.ofNullable(clazz.cast(checksumCRC64NVME()));
        case "ChecksumSHA1":
            return Optional.ofNullable(clazz.cast(checksumSHA1()));
        case "ChecksumSHA256":
            return Optional.ofNullable(clazz.cast(checksumSHA256()));
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
        map.put("ETag", E_TAG_FIELD);
        map.put("LastModified", LAST_MODIFIED_FIELD);
        map.put("ChecksumCRC32", CHECKSUM_CRC32_FIELD);
        map.put("ChecksumCRC32C", CHECKSUM_CRC32_C_FIELD);
        map.put("ChecksumCRC64NVME", CHECKSUM_CRC64_NVME_FIELD);
        map.put("ChecksumSHA1", CHECKSUM_SHA1_FIELD);
        map.put("ChecksumSHA256", CHECKSUM_SHA256_FIELD);
        return Collections.unmodifiableMap(map);
    }

    private static <T> Function<Object, T> getter(Function<CopyPartResult, T> g) {
        return obj -> g.apply((CopyPartResult) obj);
    }

    private static <T> BiConsumer<Object, T> setter(BiConsumer<Builder, T> s) {
        return (obj, val) -> s.accept((Builder) obj, val);
    }

    @Mutable
    @NotThreadSafe
    public interface Builder extends SdkPojo, CopyableBuilder<Builder, CopyPartResult> {
        /**
         * <p>
         * Entity tag of the object.
         * </p>
         * 
         * @param eTag
         *        Entity tag of the object.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder eTag(String eTag);

        /**
         * <p>
         * Date and time at which the object was uploaded.
         * </p>
         * 
         * @param lastModified
         *        Date and time at which the object was uploaded.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder lastModified(Instant lastModified);

        /**
         * <p>
         * This header can be used as a data integrity check to verify that the data received is the same data that was
         * originally sent. This header specifies the Base64 encoded, 32-bit <code>CRC32</code> checksum of the part.
         * For more information, see <a
         * href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/checking-object-integrity.html">Checking object
         * integrity</a> in the <i>Amazon S3 User Guide</i>.
         * </p>
         * 
         * @param checksumCRC32
         *        This header can be used as a data integrity check to verify that the data received is the same data
         *        that was originally sent. This header specifies the Base64 encoded, 32-bit <code>CRC32</code> checksum
         *        of the part. For more information, see <a
         *        href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/checking-object-integrity.html">Checking
         *        object integrity</a> in the <i>Amazon S3 User Guide</i>.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder checksumCRC32(String checksumCRC32);

        /**
         * <p>
         * This header can be used as a data integrity check to verify that the data received is the same data that was
         * originally sent. This header specifies the Base64 encoded, 32-bit <code>CRC32C</code> checksum of the part.
         * For more information, see <a
         * href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/checking-object-integrity.html">Checking object
         * integrity</a> in the <i>Amazon S3 User Guide</i>.
         * </p>
         * 
         * @param checksumCRC32C
         *        This header can be used as a data integrity check to verify that the data received is the same data
         *        that was originally sent. This header specifies the Base64 encoded, 32-bit <code>CRC32C</code>
         *        checksum of the part. For more information, see <a
         *        href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/checking-object-integrity.html">Checking
         *        object integrity</a> in the <i>Amazon S3 User Guide</i>.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder checksumCRC32C(String checksumCRC32C);

        /**
         * <p>
         * The Base64 encoded, 64-bit <code>CRC64NVME</code> checksum of the part. This checksum is present if the
         * multipart upload request was created with the <code>CRC64NVME</code> checksum algorithm to the uploaded
         * object). For more information, see <a
         * href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/checking-object-integrity.html">Checking object
         * integrity</a> in the <i>Amazon S3 User Guide</i>.
         * </p>
         * 
         * @param checksumCRC64NVME
         *        The Base64 encoded, 64-bit <code>CRC64NVME</code> checksum of the part. This checksum is present if
         *        the multipart upload request was created with the <code>CRC64NVME</code> checksum algorithm to the
         *        uploaded object). For more information, see <a
         *        href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/checking-object-integrity.html">Checking
         *        object integrity</a> in the <i>Amazon S3 User Guide</i>.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder checksumCRC64NVME(String checksumCRC64NVME);

        /**
         * <p>
         * This header can be used as a data integrity check to verify that the data received is the same data that was
         * originally sent. This header specifies the Base64 encoded, 160-bit <code>SHA1</code> checksum of the part.
         * For more information, see <a
         * href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/checking-object-integrity.html">Checking object
         * integrity</a> in the <i>Amazon S3 User Guide</i>.
         * </p>
         * 
         * @param checksumSHA1
         *        This header can be used as a data integrity check to verify that the data received is the same data
         *        that was originally sent. This header specifies the Base64 encoded, 160-bit <code>SHA1</code> checksum
         *        of the part. For more information, see <a
         *        href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/checking-object-integrity.html">Checking
         *        object integrity</a> in the <i>Amazon S3 User Guide</i>.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder checksumSHA1(String checksumSHA1);

        /**
         * <p>
         * This header can be used as a data integrity check to verify that the data received is the same data that was
         * originally sent. This header specifies the Base64 encoded, 256-bit <code>SHA256</code> checksum of the part.
         * For more information, see <a
         * href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/checking-object-integrity.html">Checking object
         * integrity</a> in the <i>Amazon S3 User Guide</i>.
         * </p>
         * 
         * @param checksumSHA256
         *        This header can be used as a data integrity check to verify that the data received is the same data
         *        that was originally sent. This header specifies the Base64 encoded, 256-bit <code>SHA256</code>
         *        checksum of the part. For more information, see <a
         *        href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/checking-object-integrity.html">Checking
         *        object integrity</a> in the <i>Amazon S3 User Guide</i>.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder checksumSHA256(String checksumSHA256);
    }

    static final class BuilderImpl implements Builder {
        private String eTag;

        private Instant lastModified;

        private String checksumCRC32;

        private String checksumCRC32C;

        private String checksumCRC64NVME;

        private String checksumSHA1;

        private String checksumSHA256;

        private BuilderImpl() {
        }

        private BuilderImpl(CopyPartResult model) {
            eTag(model.eTag);
            lastModified(model.lastModified);
            checksumCRC32(model.checksumCRC32);
            checksumCRC32C(model.checksumCRC32C);
            checksumCRC64NVME(model.checksumCRC64NVME);
            checksumSHA1(model.checksumSHA1);
            checksumSHA256(model.checksumSHA256);
        }

        public final String getETag() {
            return eTag;
        }

        public final void setETag(String eTag) {
            this.eTag = eTag;
        }

        @Override
        public final Builder eTag(String eTag) {
            this.eTag = eTag;
            return this;
        }

        public final Instant getLastModified() {
            return lastModified;
        }

        public final void setLastModified(Instant lastModified) {
            this.lastModified = lastModified;
        }

        @Override
        public final Builder lastModified(Instant lastModified) {
            this.lastModified = lastModified;
            return this;
        }

        public final String getChecksumCRC32() {
            return checksumCRC32;
        }

        public final void setChecksumCRC32(String checksumCRC32) {
            this.checksumCRC32 = checksumCRC32;
        }

        @Override
        public final Builder checksumCRC32(String checksumCRC32) {
            this.checksumCRC32 = checksumCRC32;
            return this;
        }

        public final String getChecksumCRC32C() {
            return checksumCRC32C;
        }

        public final void setChecksumCRC32C(String checksumCRC32C) {
            this.checksumCRC32C = checksumCRC32C;
        }

        @Override
        public final Builder checksumCRC32C(String checksumCRC32C) {
            this.checksumCRC32C = checksumCRC32C;
            return this;
        }

        public final String getChecksumCRC64NVME() {
            return checksumCRC64NVME;
        }

        public final void setChecksumCRC64NVME(String checksumCRC64NVME) {
            this.checksumCRC64NVME = checksumCRC64NVME;
        }

        @Override
        public final Builder checksumCRC64NVME(String checksumCRC64NVME) {
            this.checksumCRC64NVME = checksumCRC64NVME;
            return this;
        }

        public final String getChecksumSHA1() {
            return checksumSHA1;
        }

        public final void setChecksumSHA1(String checksumSHA1) {
            this.checksumSHA1 = checksumSHA1;
        }

        @Override
        public final Builder checksumSHA1(String checksumSHA1) {
            this.checksumSHA1 = checksumSHA1;
            return this;
        }

        public final String getChecksumSHA256() {
            return checksumSHA256;
        }

        public final void setChecksumSHA256(String checksumSHA256) {
            this.checksumSHA256 = checksumSHA256;
        }

        @Override
        public final Builder checksumSHA256(String checksumSHA256) {
            this.checksumSHA256 = checksumSHA256;
            return this;
        }

        @Override
        public CopyPartResult build() {
            return new CopyPartResult(this);
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
