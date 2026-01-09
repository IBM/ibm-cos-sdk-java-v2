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
import java.util.stream.Collectors;
import java.util.stream.Stream;
import com.ibm.cos.v2.annotations.Generated;
import com.ibm.cos.v2.annotations.Mutable;
import com.ibm.cos.v2.annotations.NotThreadSafe;
import com.ibm.cos.v2.core.SdkField;
import com.ibm.cos.v2.core.SdkPojo;
import com.ibm.cos.v2.core.protocol.MarshallLocation;
import com.ibm.cos.v2.core.protocol.MarshallingType;
import com.ibm.cos.v2.core.traits.ListTrait;
import com.ibm.cos.v2.core.traits.LocationTrait;
import com.ibm.cos.v2.core.traits.RequiredTrait;
import com.ibm.cos.v2.core.util.DefaultSdkAutoConstructList;
import com.ibm.cos.v2.core.util.SdkAutoConstructList;
import com.ibm.cos.v2.utils.ToString;
import com.ibm.cos.v2.utils.builder.CopyableBuilder;
import com.ibm.cos.v2.utils.builder.ToCopyableBuilder;

/**
 * <p>
 * Describes where logs are stored and the prefix that Amazon S3 assigns to all log object keys for a bucket. For more
 * information, see <a href="https://docs.aws.amazon.com/AmazonS3/latest/API/RESTBucketPUTlogging.html">PUT Bucket
 * logging</a> in the <i>Amazon S3 API Reference</i>.
 * </p>
 */
@Generated("com.ibm.cos.v2:codegen")
public final class LoggingEnabled implements SdkPojo, Serializable, ToCopyableBuilder<LoggingEnabled.Builder, LoggingEnabled> {
    private static final SdkField<String> TARGET_BUCKET_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("TargetBucket")
            .getter(getter(LoggingEnabled::targetBucket))
            .setter(setter(Builder::targetBucket))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("TargetBucket")
                    .unmarshallLocationName("TargetBucket").build(), RequiredTrait.create()).build();

    private static final SdkField<List<TargetGrant>> TARGET_GRANTS_FIELD = SdkField
            .<List<TargetGrant>> builder(MarshallingType.LIST)
            .memberName("TargetGrants")
            .getter(getter(LoggingEnabled::targetGrants))
            .setter(setter(Builder::targetGrants))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("TargetGrants")
                    .unmarshallLocationName("TargetGrants").build(),
                    ListTrait
                            .builder()
                            .memberLocationName("Grant")
                            .memberFieldInfo(
                                    SdkField.<TargetGrant> builder(MarshallingType.SDK_POJO)
                                            .constructor(TargetGrant::builder)
                                            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD)
                                                    .locationName("Grant").unmarshallLocationName("Grant").build()).build())
                            .build()).build();

    private static final SdkField<String> TARGET_PREFIX_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("TargetPrefix")
            .getter(getter(LoggingEnabled::targetPrefix))
            .setter(setter(Builder::targetPrefix))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("TargetPrefix")
                    .unmarshallLocationName("TargetPrefix").build(), RequiredTrait.create()).build();

    private static final SdkField<TargetObjectKeyFormat> TARGET_OBJECT_KEY_FORMAT_FIELD = SdkField
            .<TargetObjectKeyFormat> builder(MarshallingType.SDK_POJO)
            .memberName("TargetObjectKeyFormat")
            .getter(getter(LoggingEnabled::targetObjectKeyFormat))
            .setter(setter(Builder::targetObjectKeyFormat))
            .constructor(TargetObjectKeyFormat::builder)
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("TargetObjectKeyFormat")
                    .unmarshallLocationName("TargetObjectKeyFormat").build()).build();

    private static final List<SdkField<?>> SDK_FIELDS = Collections.unmodifiableList(Arrays.asList(TARGET_BUCKET_FIELD,
            TARGET_GRANTS_FIELD, TARGET_PREFIX_FIELD, TARGET_OBJECT_KEY_FORMAT_FIELD));

    private static final Map<String, SdkField<?>> SDK_NAME_TO_FIELD = memberNameToFieldInitializer();

    private static final long serialVersionUID = 1L;

    private final String targetBucket;

    private final List<TargetGrant> targetGrants;

    private final String targetPrefix;

    private final TargetObjectKeyFormat targetObjectKeyFormat;

    private LoggingEnabled(BuilderImpl builder) {
        this.targetBucket = builder.targetBucket;
        this.targetGrants = builder.targetGrants;
        this.targetPrefix = builder.targetPrefix;
        this.targetObjectKeyFormat = builder.targetObjectKeyFormat;
    }

    /**
     * <p>
     * Specifies the bucket where you want Amazon S3 to store server access logs. You can have your logs delivered to
     * any bucket that you own, including the same bucket that is being logged. You can also configure multiple buckets
     * to deliver their logs to the same target bucket. In this case, you should choose a different
     * <code>TargetPrefix</code> for each source bucket so that the delivered log files can be distinguished by key.
     * </p>
     * 
     * @return Specifies the bucket where you want Amazon S3 to store server access logs. You can have your logs
     *         delivered to any bucket that you own, including the same bucket that is being logged. You can also
     *         configure multiple buckets to deliver their logs to the same target bucket. In this case, you should
     *         choose a different <code>TargetPrefix</code> for each source bucket so that the delivered log files can
     *         be distinguished by key.
     */
    public final String targetBucket() {
        return targetBucket;
    }

    /**
     * For responses, this returns true if the service returned a value for the TargetGrants property. This DOES NOT
     * check that the value is non-empty (for which, you should check the {@code isEmpty()} method on the property).
     * This is useful because the SDK will never return a null collection or map, but you may need to differentiate
     * between the service returning nothing (or null) and the service returning an empty collection or map. For
     * requests, this returns true if a value for the property was specified in the request builder, and false if a
     * value was not specified.
     */
    public final boolean hasTargetGrants() {
        return targetGrants != null && !(targetGrants instanceof SdkAutoConstructList);
    }

    /**
     * <p>
     * Container for granting information.
     * </p>
     * <p>
     * Buckets that use the bucket owner enforced setting for Object Ownership don't support target grants. For more
     * information, see <a href=
     * "https://docs.aws.amazon.com/AmazonS3/latest/userguide/enable-server-access-logging.html#grant-log-delivery-permissions-general"
     * >Permissions for server access log delivery</a> in the <i>Amazon S3 User Guide</i>.
     * </p>
     * <p>
     * Attempts to modify the collection returned by this method will result in an UnsupportedOperationException.
     * </p>
     * <p>
     * This method will never return null. If you would like to know whether the service returned this field (so that
     * you can differentiate between null and empty), you can use the {@link #hasTargetGrants} method.
     * </p>
     * 
     * @return Container for granting information.</p>
     *         <p>
     *         Buckets that use the bucket owner enforced setting for Object Ownership don't support target grants. For
     *         more information, see <a href=
     *         "https://docs.aws.amazon.com/AmazonS3/latest/userguide/enable-server-access-logging.html#grant-log-delivery-permissions-general"
     *         >Permissions for server access log delivery</a> in the <i>Amazon S3 User Guide</i>.
     */
    public final List<TargetGrant> targetGrants() {
        return targetGrants;
    }

    /**
     * <p>
     * A prefix for all log object keys. If you store log files from multiple Amazon S3 buckets in a single bucket, you
     * can use a prefix to distinguish which log files came from which bucket.
     * </p>
     * 
     * @return A prefix for all log object keys. If you store log files from multiple Amazon S3 buckets in a single
     *         bucket, you can use a prefix to distinguish which log files came from which bucket.
     */
    public final String targetPrefix() {
        return targetPrefix;
    }

    /**
     * <p>
     * Amazon S3 key format for log objects.
     * </p>
     * 
     * @return Amazon S3 key format for log objects.
     */
    public final TargetObjectKeyFormat targetObjectKeyFormat() {
        return targetObjectKeyFormat;
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
        hashCode = 31 * hashCode + Objects.hashCode(targetBucket());
        hashCode = 31 * hashCode + Objects.hashCode(hasTargetGrants() ? targetGrants() : null);
        hashCode = 31 * hashCode + Objects.hashCode(targetPrefix());
        hashCode = 31 * hashCode + Objects.hashCode(targetObjectKeyFormat());
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
        if (!(obj instanceof LoggingEnabled)) {
            return false;
        }
        LoggingEnabled other = (LoggingEnabled) obj;
        return Objects.equals(targetBucket(), other.targetBucket()) && hasTargetGrants() == other.hasTargetGrants()
                && Objects.equals(targetGrants(), other.targetGrants()) && Objects.equals(targetPrefix(), other.targetPrefix())
                && Objects.equals(targetObjectKeyFormat(), other.targetObjectKeyFormat());
    }

    /**
     * Returns a string representation of this object. This is useful for testing and debugging. Sensitive data will be
     * redacted from this string using a placeholder value.
     */
    @Override
    public final String toString() {
        return ToString.builder("LoggingEnabled").add("TargetBucket", targetBucket())
                .add("TargetGrants", hasTargetGrants() ? targetGrants() : null).add("TargetPrefix", targetPrefix())
                .add("TargetObjectKeyFormat", targetObjectKeyFormat()).build();
    }

    public final <T> Optional<T> getValueForField(String fieldName, Class<T> clazz) {
        switch (fieldName) {
        case "TargetBucket":
            return Optional.ofNullable(clazz.cast(targetBucket()));
        case "TargetGrants":
            return Optional.ofNullable(clazz.cast(targetGrants()));
        case "TargetPrefix":
            return Optional.ofNullable(clazz.cast(targetPrefix()));
        case "TargetObjectKeyFormat":
            return Optional.ofNullable(clazz.cast(targetObjectKeyFormat()));
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
        map.put("TargetBucket", TARGET_BUCKET_FIELD);
        map.put("TargetGrants", TARGET_GRANTS_FIELD);
        map.put("TargetPrefix", TARGET_PREFIX_FIELD);
        map.put("TargetObjectKeyFormat", TARGET_OBJECT_KEY_FORMAT_FIELD);
        return Collections.unmodifiableMap(map);
    }

    private static <T> Function<Object, T> getter(Function<LoggingEnabled, T> g) {
        return obj -> g.apply((LoggingEnabled) obj);
    }

    private static <T> BiConsumer<Object, T> setter(BiConsumer<Builder, T> s) {
        return (obj, val) -> s.accept((Builder) obj, val);
    }

    @Mutable
    @NotThreadSafe
    public interface Builder extends SdkPojo, CopyableBuilder<Builder, LoggingEnabled> {
        /**
         * <p>
         * Specifies the bucket where you want Amazon S3 to store server access logs. You can have your logs delivered
         * to any bucket that you own, including the same bucket that is being logged. You can also configure multiple
         * buckets to deliver their logs to the same target bucket. In this case, you should choose a different
         * <code>TargetPrefix</code> for each source bucket so that the delivered log files can be distinguished by key.
         * </p>
         * 
         * @param targetBucket
         *        Specifies the bucket where you want Amazon S3 to store server access logs. You can have your logs
         *        delivered to any bucket that you own, including the same bucket that is being logged. You can also
         *        configure multiple buckets to deliver their logs to the same target bucket. In this case, you should
         *        choose a different <code>TargetPrefix</code> for each source bucket so that the delivered log files
         *        can be distinguished by key.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder targetBucket(String targetBucket);

        /**
         * <p>
         * Container for granting information.
         * </p>
         * <p>
         * Buckets that use the bucket owner enforced setting for Object Ownership don't support target grants. For more
         * information, see <a href=
         * "https://docs.aws.amazon.com/AmazonS3/latest/userguide/enable-server-access-logging.html#grant-log-delivery-permissions-general"
         * >Permissions for server access log delivery</a> in the <i>Amazon S3 User Guide</i>.
         * </p>
         * 
         * @param targetGrants
         *        Container for granting information.</p>
         *        <p>
         *        Buckets that use the bucket owner enforced setting for Object Ownership don't support target grants.
         *        For more information, see <a href=
         *        "https://docs.aws.amazon.com/AmazonS3/latest/userguide/enable-server-access-logging.html#grant-log-delivery-permissions-general"
         *        >Permissions for server access log delivery</a> in the <i>Amazon S3 User Guide</i>.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder targetGrants(Collection<TargetGrant> targetGrants);

        /**
         * <p>
         * Container for granting information.
         * </p>
         * <p>
         * Buckets that use the bucket owner enforced setting for Object Ownership don't support target grants. For more
         * information, see <a href=
         * "https://docs.aws.amazon.com/AmazonS3/latest/userguide/enable-server-access-logging.html#grant-log-delivery-permissions-general"
         * >Permissions for server access log delivery</a> in the <i>Amazon S3 User Guide</i>.
         * </p>
         * 
         * @param targetGrants
         *        Container for granting information.</p>
         *        <p>
         *        Buckets that use the bucket owner enforced setting for Object Ownership don't support target grants.
         *        For more information, see <a href=
         *        "https://docs.aws.amazon.com/AmazonS3/latest/userguide/enable-server-access-logging.html#grant-log-delivery-permissions-general"
         *        >Permissions for server access log delivery</a> in the <i>Amazon S3 User Guide</i>.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder targetGrants(TargetGrant... targetGrants);

        /**
         * <p>
         * Container for granting information.
         * </p>
         * <p>
         * Buckets that use the bucket owner enforced setting for Object Ownership don't support target grants. For more
         * information, see <a href=
         * "https://docs.aws.amazon.com/AmazonS3/latest/userguide/enable-server-access-logging.html#grant-log-delivery-permissions-general"
         * >Permissions for server access log delivery</a> in the <i>Amazon S3 User Guide</i>.
         * </p>
         * This is a convenience method that creates an instance of the
         * {@link com.ibm.cos.v2.services.s3.model.TargetGrant.Builder} avoiding the need to create one manually
         * via {@link com.ibm.cos.v2.services.s3.model.TargetGrant#builder()}.
         *
         * <p>
         * When the {@link Consumer} completes,
         * {@link com.ibm.cos.v2.services.s3.model.TargetGrant.Builder#build()} is called immediately and its
         * result is passed to {@link #targetGrants(List<TargetGrant>)}.
         * 
         * @param targetGrants
         *        a consumer that will call methods on
         *        {@link com.ibm.cos.v2.services.s3.model.TargetGrant.Builder}
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see #targetGrants(java.util.Collection<TargetGrant>)
         */
        Builder targetGrants(Consumer<TargetGrant.Builder>... targetGrants);

        /**
         * <p>
         * A prefix for all log object keys. If you store log files from multiple Amazon S3 buckets in a single bucket,
         * you can use a prefix to distinguish which log files came from which bucket.
         * </p>
         * 
         * @param targetPrefix
         *        A prefix for all log object keys. If you store log files from multiple Amazon S3 buckets in a single
         *        bucket, you can use a prefix to distinguish which log files came from which bucket.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder targetPrefix(String targetPrefix);

        /**
         * <p>
         * Amazon S3 key format for log objects.
         * </p>
         * 
         * @param targetObjectKeyFormat
         *        Amazon S3 key format for log objects.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder targetObjectKeyFormat(TargetObjectKeyFormat targetObjectKeyFormat);

        /**
         * <p>
         * Amazon S3 key format for log objects.
         * </p>
         * This is a convenience method that creates an instance of the {@link TargetObjectKeyFormat.Builder} avoiding
         * the need to create one manually via {@link TargetObjectKeyFormat#builder()}.
         *
         * <p>
         * When the {@link Consumer} completes, {@link TargetObjectKeyFormat.Builder#build()} is called immediately and
         * its result is passed to {@link #targetObjectKeyFormat(TargetObjectKeyFormat)}.
         * 
         * @param targetObjectKeyFormat
         *        a consumer that will call methods on {@link TargetObjectKeyFormat.Builder}
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see #targetObjectKeyFormat(TargetObjectKeyFormat)
         */
        default Builder targetObjectKeyFormat(Consumer<TargetObjectKeyFormat.Builder> targetObjectKeyFormat) {
            return targetObjectKeyFormat(TargetObjectKeyFormat.builder().applyMutation(targetObjectKeyFormat).build());
        }
    }

    static final class BuilderImpl implements Builder {
        private String targetBucket;

        private List<TargetGrant> targetGrants = DefaultSdkAutoConstructList.getInstance();

        private String targetPrefix;

        private TargetObjectKeyFormat targetObjectKeyFormat;

        private BuilderImpl() {
        }

        private BuilderImpl(LoggingEnabled model) {
            targetBucket(model.targetBucket);
            targetGrants(model.targetGrants);
            targetPrefix(model.targetPrefix);
            targetObjectKeyFormat(model.targetObjectKeyFormat);
        }

        public final String getTargetBucket() {
            return targetBucket;
        }

        public final void setTargetBucket(String targetBucket) {
            this.targetBucket = targetBucket;
        }

        @Override
        public final Builder targetBucket(String targetBucket) {
            this.targetBucket = targetBucket;
            return this;
        }

        public final List<TargetGrant.Builder> getTargetGrants() {
            List<TargetGrant.Builder> result = TargetGrantsCopier.copyToBuilder(this.targetGrants);
            if (result instanceof SdkAutoConstructList) {
                return null;
            }
            return result;
        }

        public final void setTargetGrants(Collection<TargetGrant.BuilderImpl> targetGrants) {
            this.targetGrants = TargetGrantsCopier.copyFromBuilder(targetGrants);
        }

        @Override
        public final Builder targetGrants(Collection<TargetGrant> targetGrants) {
            this.targetGrants = TargetGrantsCopier.copy(targetGrants);
            return this;
        }

        @Override
        @SafeVarargs
        public final Builder targetGrants(TargetGrant... targetGrants) {
            targetGrants(Arrays.asList(targetGrants));
            return this;
        }

        @Override
        @SafeVarargs
        public final Builder targetGrants(Consumer<TargetGrant.Builder>... targetGrants) {
            targetGrants(Stream.of(targetGrants).map(c -> TargetGrant.builder().applyMutation(c).build())
                    .collect(Collectors.toList()));
            return this;
        }

        public final String getTargetPrefix() {
            return targetPrefix;
        }

        public final void setTargetPrefix(String targetPrefix) {
            this.targetPrefix = targetPrefix;
        }

        @Override
        public final Builder targetPrefix(String targetPrefix) {
            this.targetPrefix = targetPrefix;
            return this;
        }

        public final TargetObjectKeyFormat.Builder getTargetObjectKeyFormat() {
            return targetObjectKeyFormat != null ? targetObjectKeyFormat.toBuilder() : null;
        }

        public final void setTargetObjectKeyFormat(TargetObjectKeyFormat.BuilderImpl targetObjectKeyFormat) {
            this.targetObjectKeyFormat = targetObjectKeyFormat != null ? targetObjectKeyFormat.build() : null;
        }

        @Override
        public final Builder targetObjectKeyFormat(TargetObjectKeyFormat targetObjectKeyFormat) {
            this.targetObjectKeyFormat = targetObjectKeyFormat;
            return this;
        }

        @Override
        public LoggingEnabled build() {
            return new LoggingEnabled(this);
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
