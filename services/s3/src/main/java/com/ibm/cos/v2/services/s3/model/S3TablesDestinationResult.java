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
 * The destination information for the metadata table configuration. The destination table bucket must be in the same
 * Region and Amazon Web Services account as the general purpose bucket. The specified metadata table name must be
 * unique within the <code>aws_s3_metadata</code> namespace in the destination table bucket.
 * </p>
 */
@Generated("com.ibm.cos.v2:codegen")
public final class S3TablesDestinationResult implements SdkPojo, Serializable,
        ToCopyableBuilder<S3TablesDestinationResult.Builder, S3TablesDestinationResult> {
    private static final SdkField<String> TABLE_BUCKET_ARN_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("TableBucketArn")
            .getter(getter(S3TablesDestinationResult::tableBucketArn))
            .setter(setter(Builder::tableBucketArn))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("TableBucketArn")
                    .unmarshallLocationName("TableBucketArn").build(), RequiredTrait.create()).build();

    private static final SdkField<String> TABLE_NAME_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("TableName")
            .getter(getter(S3TablesDestinationResult::tableName))
            .setter(setter(Builder::tableName))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("TableName")
                    .unmarshallLocationName("TableName").build(), RequiredTrait.create()).build();

    private static final SdkField<String> TABLE_ARN_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("TableArn")
            .getter(getter(S3TablesDestinationResult::tableArn))
            .setter(setter(Builder::tableArn))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("TableArn")
                    .unmarshallLocationName("TableArn").build(), RequiredTrait.create()).build();

    private static final SdkField<String> TABLE_NAMESPACE_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("TableNamespace")
            .getter(getter(S3TablesDestinationResult::tableNamespace))
            .setter(setter(Builder::tableNamespace))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("TableNamespace")
                    .unmarshallLocationName("TableNamespace").build(), RequiredTrait.create()).build();

    private static final List<SdkField<?>> SDK_FIELDS = Collections.unmodifiableList(Arrays.asList(TABLE_BUCKET_ARN_FIELD,
            TABLE_NAME_FIELD, TABLE_ARN_FIELD, TABLE_NAMESPACE_FIELD));

    private static final Map<String, SdkField<?>> SDK_NAME_TO_FIELD = memberNameToFieldInitializer();

    private static final long serialVersionUID = 1L;

    private final String tableBucketArn;

    private final String tableName;

    private final String tableArn;

    private final String tableNamespace;

    private S3TablesDestinationResult(BuilderImpl builder) {
        this.tableBucketArn = builder.tableBucketArn;
        this.tableName = builder.tableName;
        this.tableArn = builder.tableArn;
        this.tableNamespace = builder.tableNamespace;
    }

    /**
     * <p>
     * The Amazon Resource Name (ARN) for the table bucket that's specified as the destination in the metadata table
     * configuration. The destination table bucket must be in the same Region and Amazon Web Services account as the
     * general purpose bucket.
     * </p>
     * 
     * @return The Amazon Resource Name (ARN) for the table bucket that's specified as the destination in the metadata
     *         table configuration. The destination table bucket must be in the same Region and Amazon Web Services
     *         account as the general purpose bucket.
     */
    public final String tableBucketArn() {
        return tableBucketArn;
    }

    /**
     * <p>
     * The name for the metadata table in your metadata table configuration. The specified metadata table name must be
     * unique within the <code>aws_s3_metadata</code> namespace in the destination table bucket.
     * </p>
     * 
     * @return The name for the metadata table in your metadata table configuration. The specified metadata table name
     *         must be unique within the <code>aws_s3_metadata</code> namespace in the destination table bucket.
     */
    public final String tableName() {
        return tableName;
    }

    /**
     * <p>
     * The Amazon Resource Name (ARN) for the metadata table in the metadata table configuration. The specified metadata
     * table name must be unique within the <code>aws_s3_metadata</code> namespace in the destination table bucket.
     * </p>
     * 
     * @return The Amazon Resource Name (ARN) for the metadata table in the metadata table configuration. The specified
     *         metadata table name must be unique within the <code>aws_s3_metadata</code> namespace in the destination
     *         table bucket.
     */
    public final String tableArn() {
        return tableArn;
    }

    /**
     * <p>
     * The table bucket namespace for the metadata table in your metadata table configuration. This value is always
     * <code>aws_s3_metadata</code>.
     * </p>
     * 
     * @return The table bucket namespace for the metadata table in your metadata table configuration. This value is
     *         always <code>aws_s3_metadata</code>.
     */
    public final String tableNamespace() {
        return tableNamespace;
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
        hashCode = 31 * hashCode + Objects.hashCode(tableBucketArn());
        hashCode = 31 * hashCode + Objects.hashCode(tableName());
        hashCode = 31 * hashCode + Objects.hashCode(tableArn());
        hashCode = 31 * hashCode + Objects.hashCode(tableNamespace());
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
        if (!(obj instanceof S3TablesDestinationResult)) {
            return false;
        }
        S3TablesDestinationResult other = (S3TablesDestinationResult) obj;
        return Objects.equals(tableBucketArn(), other.tableBucketArn()) && Objects.equals(tableName(), other.tableName())
                && Objects.equals(tableArn(), other.tableArn()) && Objects.equals(tableNamespace(), other.tableNamespace());
    }

    /**
     * Returns a string representation of this object. This is useful for testing and debugging. Sensitive data will be
     * redacted from this string using a placeholder value.
     */
    @Override
    public final String toString() {
        return ToString.builder("S3TablesDestinationResult").add("TableBucketArn", tableBucketArn())
                .add("TableName", tableName()).add("TableArn", tableArn()).add("TableNamespace", tableNamespace()).build();
    }

    public final <T> Optional<T> getValueForField(String fieldName, Class<T> clazz) {
        switch (fieldName) {
        case "TableBucketArn":
            return Optional.ofNullable(clazz.cast(tableBucketArn()));
        case "TableName":
            return Optional.ofNullable(clazz.cast(tableName()));
        case "TableArn":
            return Optional.ofNullable(clazz.cast(tableArn()));
        case "TableNamespace":
            return Optional.ofNullable(clazz.cast(tableNamespace()));
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
        map.put("TableBucketArn", TABLE_BUCKET_ARN_FIELD);
        map.put("TableName", TABLE_NAME_FIELD);
        map.put("TableArn", TABLE_ARN_FIELD);
        map.put("TableNamespace", TABLE_NAMESPACE_FIELD);
        return Collections.unmodifiableMap(map);
    }

    private static <T> Function<Object, T> getter(Function<S3TablesDestinationResult, T> g) {
        return obj -> g.apply((S3TablesDestinationResult) obj);
    }

    private static <T> BiConsumer<Object, T> setter(BiConsumer<Builder, T> s) {
        return (obj, val) -> s.accept((Builder) obj, val);
    }

    @Mutable
    @NotThreadSafe
    public interface Builder extends SdkPojo, CopyableBuilder<Builder, S3TablesDestinationResult> {
        /**
         * <p>
         * The Amazon Resource Name (ARN) for the table bucket that's specified as the destination in the metadata table
         * configuration. The destination table bucket must be in the same Region and Amazon Web Services account as the
         * general purpose bucket.
         * </p>
         * 
         * @param tableBucketArn
         *        The Amazon Resource Name (ARN) for the table bucket that's specified as the destination in the
         *        metadata table configuration. The destination table bucket must be in the same Region and Amazon Web
         *        Services account as the general purpose bucket.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder tableBucketArn(String tableBucketArn);

        /**
         * <p>
         * The name for the metadata table in your metadata table configuration. The specified metadata table name must
         * be unique within the <code>aws_s3_metadata</code> namespace in the destination table bucket.
         * </p>
         * 
         * @param tableName
         *        The name for the metadata table in your metadata table configuration. The specified metadata table
         *        name must be unique within the <code>aws_s3_metadata</code> namespace in the destination table bucket.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder tableName(String tableName);

        /**
         * <p>
         * The Amazon Resource Name (ARN) for the metadata table in the metadata table configuration. The specified
         * metadata table name must be unique within the <code>aws_s3_metadata</code> namespace in the destination table
         * bucket.
         * </p>
         * 
         * @param tableArn
         *        The Amazon Resource Name (ARN) for the metadata table in the metadata table configuration. The
         *        specified metadata table name must be unique within the <code>aws_s3_metadata</code> namespace in the
         *        destination table bucket.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder tableArn(String tableArn);

        /**
         * <p>
         * The table bucket namespace for the metadata table in your metadata table configuration. This value is always
         * <code>aws_s3_metadata</code>.
         * </p>
         * 
         * @param tableNamespace
         *        The table bucket namespace for the metadata table in your metadata table configuration. This value is
         *        always <code>aws_s3_metadata</code>.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder tableNamespace(String tableNamespace);
    }

    static final class BuilderImpl implements Builder {
        private String tableBucketArn;

        private String tableName;

        private String tableArn;

        private String tableNamespace;

        private BuilderImpl() {
        }

        private BuilderImpl(S3TablesDestinationResult model) {
            tableBucketArn(model.tableBucketArn);
            tableName(model.tableName);
            tableArn(model.tableArn);
            tableNamespace(model.tableNamespace);
        }

        public final String getTableBucketArn() {
            return tableBucketArn;
        }

        public final void setTableBucketArn(String tableBucketArn) {
            this.tableBucketArn = tableBucketArn;
        }

        @Override
        public final Builder tableBucketArn(String tableBucketArn) {
            this.tableBucketArn = tableBucketArn;
            return this;
        }

        public final String getTableName() {
            return tableName;
        }

        public final void setTableName(String tableName) {
            this.tableName = tableName;
        }

        @Override
        public final Builder tableName(String tableName) {
            this.tableName = tableName;
            return this;
        }

        public final String getTableArn() {
            return tableArn;
        }

        public final void setTableArn(String tableArn) {
            this.tableArn = tableArn;
        }

        @Override
        public final Builder tableArn(String tableArn) {
            this.tableArn = tableArn;
            return this;
        }

        public final String getTableNamespace() {
            return tableNamespace;
        }

        public final void setTableNamespace(String tableNamespace) {
            this.tableNamespace = tableNamespace;
        }

        @Override
        public final Builder tableNamespace(String tableNamespace) {
            this.tableNamespace = tableNamespace;
            return this;
        }

        @Override
        public S3TablesDestinationResult build() {
            return new S3TablesDestinationResult(this);
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
