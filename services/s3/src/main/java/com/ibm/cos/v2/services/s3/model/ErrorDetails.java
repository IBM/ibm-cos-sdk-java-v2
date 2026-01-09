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
import com.ibm.cos.v2.utils.ToString;
import com.ibm.cos.v2.utils.builder.CopyableBuilder;
import com.ibm.cos.v2.utils.builder.ToCopyableBuilder;

/**
 * <p>
 * If the <code>CreateBucketMetadataTableConfiguration</code> request succeeds, but S3 Metadata was unable to create the
 * table, this structure contains the error code and error message.
 * </p>
 */
@Generated("com.ibm.cos.v2:codegen")
public final class ErrorDetails implements SdkPojo, Serializable, ToCopyableBuilder<ErrorDetails.Builder, ErrorDetails> {
    private static final SdkField<String> ERROR_CODE_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("ErrorCode")
            .getter(getter(ErrorDetails::errorCode))
            .setter(setter(Builder::errorCode))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("ErrorCode")
                    .unmarshallLocationName("ErrorCode").build()).build();

    private static final SdkField<String> ERROR_MESSAGE_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("ErrorMessage")
            .getter(getter(ErrorDetails::errorMessage))
            .setter(setter(Builder::errorMessage))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("ErrorMessage")
                    .unmarshallLocationName("ErrorMessage").build()).build();

    private static final List<SdkField<?>> SDK_FIELDS = Collections.unmodifiableList(Arrays.asList(ERROR_CODE_FIELD,
            ERROR_MESSAGE_FIELD));

    private static final Map<String, SdkField<?>> SDK_NAME_TO_FIELD = memberNameToFieldInitializer();

    private static final long serialVersionUID = 1L;

    private final String errorCode;

    private final String errorMessage;

    private ErrorDetails(BuilderImpl builder) {
        this.errorCode = builder.errorCode;
        this.errorMessage = builder.errorMessage;
    }

    /**
     * <p>
     * If the <code>CreateBucketMetadataTableConfiguration</code> request succeeds, but S3 Metadata was unable to create
     * the table, this structure contains the error code. The possible error codes and error messages are as follows:
     * </p>
     * <ul>
     * <li>
     * <p>
     * <code>AccessDeniedCreatingResources</code> - You don't have sufficient permissions to create the required
     * resources. Make sure that you have <code>s3tables:CreateNamespace</code>, <code>s3tables:CreateTable</code>,
     * <code>s3tables:GetTable</code> and <code>s3tables:PutTablePolicy</code> permissions, and then try again. To
     * create a new metadata table, you must delete the metadata configuration for this bucket, and then create a new
     * metadata configuration.
     * </p>
     * </li>
     * <li>
     * <p>
     * <code>AccessDeniedWritingToTable</code> - Unable to write to the metadata table because of missing resource
     * permissions. To fix the resource policy, Amazon S3 needs to create a new metadata table. To create a new metadata
     * table, you must delete the metadata configuration for this bucket, and then create a new metadata configuration.
     * </p>
     * </li>
     * <li>
     * <p>
     * <code>DestinationTableNotFound</code> - The destination table doesn't exist. To create a new metadata table, you
     * must delete the metadata configuration for this bucket, and then create a new metadata configuration.
     * </p>
     * </li>
     * <li>
     * <p>
     * <code>ServerInternalError</code> - An internal error has occurred. To create a new metadata table, you must
     * delete the metadata configuration for this bucket, and then create a new metadata configuration.
     * </p>
     * </li>
     * <li>
     * <p>
     * <code>TableAlreadyExists</code> - The table that you specified already exists in the table bucket's namespace.
     * Specify a different table name. To create a new metadata table, you must delete the metadata configuration for
     * this bucket, and then create a new metadata configuration.
     * </p>
     * </li>
     * <li>
     * <p>
     * <code>TableBucketNotFound</code> - The table bucket that you specified doesn't exist in this Amazon Web Services
     * Region and account. Create or choose a different table bucket. To create a new metadata table, you must delete
     * the metadata configuration for this bucket, and then create a new metadata configuration.
     * </p>
     * </li>
     * </ul>
     * 
     * @return If the <code>CreateBucketMetadataTableConfiguration</code> request succeeds, but S3 Metadata was unable
     *         to create the table, this structure contains the error code. The possible error codes and error messages
     *         are as follows: </p>
     *         <ul>
     *         <li>
     *         <p>
     *         <code>AccessDeniedCreatingResources</code> - You don't have sufficient permissions to create the required
     *         resources. Make sure that you have <code>s3tables:CreateNamespace</code>,
     *         <code>s3tables:CreateTable</code>, <code>s3tables:GetTable</code> and
     *         <code>s3tables:PutTablePolicy</code> permissions, and then try again. To create a new metadata table, you
     *         must delete the metadata configuration for this bucket, and then create a new metadata configuration.
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         <code>AccessDeniedWritingToTable</code> - Unable to write to the metadata table because of missing
     *         resource permissions. To fix the resource policy, Amazon S3 needs to create a new metadata table. To
     *         create a new metadata table, you must delete the metadata configuration for this bucket, and then create
     *         a new metadata configuration.
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         <code>DestinationTableNotFound</code> - The destination table doesn't exist. To create a new metadata
     *         table, you must delete the metadata configuration for this bucket, and then create a new metadata
     *         configuration.
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         <code>ServerInternalError</code> - An internal error has occurred. To create a new metadata table, you
     *         must delete the metadata configuration for this bucket, and then create a new metadata configuration.
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         <code>TableAlreadyExists</code> - The table that you specified already exists in the table bucket's
     *         namespace. Specify a different table name. To create a new metadata table, you must delete the metadata
     *         configuration for this bucket, and then create a new metadata configuration.
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         <code>TableBucketNotFound</code> - The table bucket that you specified doesn't exist in this Amazon Web
     *         Services Region and account. Create or choose a different table bucket. To create a new metadata table,
     *         you must delete the metadata configuration for this bucket, and then create a new metadata configuration.
     *         </p>
     *         </li>
     */
    public final String errorCode() {
        return errorCode;
    }

    /**
     * <p>
     * If the <code>CreateBucketMetadataTableConfiguration</code> request succeeds, but S3 Metadata was unable to create
     * the table, this structure contains the error message. The possible error codes and error messages are as follows:
     * </p>
     * <ul>
     * <li>
     * <p>
     * <code>AccessDeniedCreatingResources</code> - You don't have sufficient permissions to create the required
     * resources. Make sure that you have <code>s3tables:CreateNamespace</code>, <code>s3tables:CreateTable</code>,
     * <code>s3tables:GetTable</code> and <code>s3tables:PutTablePolicy</code> permissions, and then try again. To
     * create a new metadata table, you must delete the metadata configuration for this bucket, and then create a new
     * metadata configuration.
     * </p>
     * </li>
     * <li>
     * <p>
     * <code>AccessDeniedWritingToTable</code> - Unable to write to the metadata table because of missing resource
     * permissions. To fix the resource policy, Amazon S3 needs to create a new metadata table. To create a new metadata
     * table, you must delete the metadata configuration for this bucket, and then create a new metadata configuration.
     * </p>
     * </li>
     * <li>
     * <p>
     * <code>DestinationTableNotFound</code> - The destination table doesn't exist. To create a new metadata table, you
     * must delete the metadata configuration for this bucket, and then create a new metadata configuration.
     * </p>
     * </li>
     * <li>
     * <p>
     * <code>ServerInternalError</code> - An internal error has occurred. To create a new metadata table, you must
     * delete the metadata configuration for this bucket, and then create a new metadata configuration.
     * </p>
     * </li>
     * <li>
     * <p>
     * <code>TableAlreadyExists</code> - The table that you specified already exists in the table bucket's namespace.
     * Specify a different table name. To create a new metadata table, you must delete the metadata configuration for
     * this bucket, and then create a new metadata configuration.
     * </p>
     * </li>
     * <li>
     * <p>
     * <code>TableBucketNotFound</code> - The table bucket that you specified doesn't exist in this Amazon Web Services
     * Region and account. Create or choose a different table bucket. To create a new metadata table, you must delete
     * the metadata configuration for this bucket, and then create a new metadata configuration.
     * </p>
     * </li>
     * </ul>
     * 
     * @return If the <code>CreateBucketMetadataTableConfiguration</code> request succeeds, but S3 Metadata was unable
     *         to create the table, this structure contains the error message. The possible error codes and error
     *         messages are as follows: </p>
     *         <ul>
     *         <li>
     *         <p>
     *         <code>AccessDeniedCreatingResources</code> - You don't have sufficient permissions to create the required
     *         resources. Make sure that you have <code>s3tables:CreateNamespace</code>,
     *         <code>s3tables:CreateTable</code>, <code>s3tables:GetTable</code> and
     *         <code>s3tables:PutTablePolicy</code> permissions, and then try again. To create a new metadata table, you
     *         must delete the metadata configuration for this bucket, and then create a new metadata configuration.
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         <code>AccessDeniedWritingToTable</code> - Unable to write to the metadata table because of missing
     *         resource permissions. To fix the resource policy, Amazon S3 needs to create a new metadata table. To
     *         create a new metadata table, you must delete the metadata configuration for this bucket, and then create
     *         a new metadata configuration.
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         <code>DestinationTableNotFound</code> - The destination table doesn't exist. To create a new metadata
     *         table, you must delete the metadata configuration for this bucket, and then create a new metadata
     *         configuration.
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         <code>ServerInternalError</code> - An internal error has occurred. To create a new metadata table, you
     *         must delete the metadata configuration for this bucket, and then create a new metadata configuration.
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         <code>TableAlreadyExists</code> - The table that you specified already exists in the table bucket's
     *         namespace. Specify a different table name. To create a new metadata table, you must delete the metadata
     *         configuration for this bucket, and then create a new metadata configuration.
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         <code>TableBucketNotFound</code> - The table bucket that you specified doesn't exist in this Amazon Web
     *         Services Region and account. Create or choose a different table bucket. To create a new metadata table,
     *         you must delete the metadata configuration for this bucket, and then create a new metadata configuration.
     *         </p>
     *         </li>
     */
    public final String errorMessage() {
        return errorMessage;
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
        hashCode = 31 * hashCode + Objects.hashCode(errorCode());
        hashCode = 31 * hashCode + Objects.hashCode(errorMessage());
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
        if (!(obj instanceof ErrorDetails)) {
            return false;
        }
        ErrorDetails other = (ErrorDetails) obj;
        return Objects.equals(errorCode(), other.errorCode()) && Objects.equals(errorMessage(), other.errorMessage());
    }

    /**
     * Returns a string representation of this object. This is useful for testing and debugging. Sensitive data will be
     * redacted from this string using a placeholder value.
     */
    @Override
    public final String toString() {
        return ToString.builder("ErrorDetails").add("ErrorCode", errorCode()).add("ErrorMessage", errorMessage()).build();
    }

    public final <T> Optional<T> getValueForField(String fieldName, Class<T> clazz) {
        switch (fieldName) {
        case "ErrorCode":
            return Optional.ofNullable(clazz.cast(errorCode()));
        case "ErrorMessage":
            return Optional.ofNullable(clazz.cast(errorMessage()));
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
        map.put("ErrorCode", ERROR_CODE_FIELD);
        map.put("ErrorMessage", ERROR_MESSAGE_FIELD);
        return Collections.unmodifiableMap(map);
    }

    private static <T> Function<Object, T> getter(Function<ErrorDetails, T> g) {
        return obj -> g.apply((ErrorDetails) obj);
    }

    private static <T> BiConsumer<Object, T> setter(BiConsumer<Builder, T> s) {
        return (obj, val) -> s.accept((Builder) obj, val);
    }

    @Mutable
    @NotThreadSafe
    public interface Builder extends SdkPojo, CopyableBuilder<Builder, ErrorDetails> {
        /**
         * <p>
         * If the <code>CreateBucketMetadataTableConfiguration</code> request succeeds, but S3 Metadata was unable to
         * create the table, this structure contains the error code. The possible error codes and error messages are as
         * follows:
         * </p>
         * <ul>
         * <li>
         * <p>
         * <code>AccessDeniedCreatingResources</code> - You don't have sufficient permissions to create the required
         * resources. Make sure that you have <code>s3tables:CreateNamespace</code>, <code>s3tables:CreateTable</code>,
         * <code>s3tables:GetTable</code> and <code>s3tables:PutTablePolicy</code> permissions, and then try again. To
         * create a new metadata table, you must delete the metadata configuration for this bucket, and then create a
         * new metadata configuration.
         * </p>
         * </li>
         * <li>
         * <p>
         * <code>AccessDeniedWritingToTable</code> - Unable to write to the metadata table because of missing resource
         * permissions. To fix the resource policy, Amazon S3 needs to create a new metadata table. To create a new
         * metadata table, you must delete the metadata configuration for this bucket, and then create a new metadata
         * configuration.
         * </p>
         * </li>
         * <li>
         * <p>
         * <code>DestinationTableNotFound</code> - The destination table doesn't exist. To create a new metadata table,
         * you must delete the metadata configuration for this bucket, and then create a new metadata configuration.
         * </p>
         * </li>
         * <li>
         * <p>
         * <code>ServerInternalError</code> - An internal error has occurred. To create a new metadata table, you must
         * delete the metadata configuration for this bucket, and then create a new metadata configuration.
         * </p>
         * </li>
         * <li>
         * <p>
         * <code>TableAlreadyExists</code> - The table that you specified already exists in the table bucket's
         * namespace. Specify a different table name. To create a new metadata table, you must delete the metadata
         * configuration for this bucket, and then create a new metadata configuration.
         * </p>
         * </li>
         * <li>
         * <p>
         * <code>TableBucketNotFound</code> - The table bucket that you specified doesn't exist in this Amazon Web
         * Services Region and account. Create or choose a different table bucket. To create a new metadata table, you
         * must delete the metadata configuration for this bucket, and then create a new metadata configuration.
         * </p>
         * </li>
         * </ul>
         * 
         * @param errorCode
         *        If the <code>CreateBucketMetadataTableConfiguration</code> request succeeds, but S3 Metadata was
         *        unable to create the table, this structure contains the error code. The possible error codes and error
         *        messages are as follows: </p>
         *        <ul>
         *        <li>
         *        <p>
         *        <code>AccessDeniedCreatingResources</code> - You don't have sufficient permissions to create the
         *        required resources. Make sure that you have <code>s3tables:CreateNamespace</code>,
         *        <code>s3tables:CreateTable</code>, <code>s3tables:GetTable</code> and
         *        <code>s3tables:PutTablePolicy</code> permissions, and then try again. To create a new metadata table,
         *        you must delete the metadata configuration for this bucket, and then create a new metadata
         *        configuration.
         *        </p>
         *        </li>
         *        <li>
         *        <p>
         *        <code>AccessDeniedWritingToTable</code> - Unable to write to the metadata table because of missing
         *        resource permissions. To fix the resource policy, Amazon S3 needs to create a new metadata table. To
         *        create a new metadata table, you must delete the metadata configuration for this bucket, and then
         *        create a new metadata configuration.
         *        </p>
         *        </li>
         *        <li>
         *        <p>
         *        <code>DestinationTableNotFound</code> - The destination table doesn't exist. To create a new metadata
         *        table, you must delete the metadata configuration for this bucket, and then create a new metadata
         *        configuration.
         *        </p>
         *        </li>
         *        <li>
         *        <p>
         *        <code>ServerInternalError</code> - An internal error has occurred. To create a new metadata table, you
         *        must delete the metadata configuration for this bucket, and then create a new metadata configuration.
         *        </p>
         *        </li>
         *        <li>
         *        <p>
         *        <code>TableAlreadyExists</code> - The table that you specified already exists in the table bucket's
         *        namespace. Specify a different table name. To create a new metadata table, you must delete the
         *        metadata configuration for this bucket, and then create a new metadata configuration.
         *        </p>
         *        </li>
         *        <li>
         *        <p>
         *        <code>TableBucketNotFound</code> - The table bucket that you specified doesn't exist in this Amazon
         *        Web Services Region and account. Create or choose a different table bucket. To create a new metadata
         *        table, you must delete the metadata configuration for this bucket, and then create a new metadata
         *        configuration.
         *        </p>
         *        </li>
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder errorCode(String errorCode);

        /**
         * <p>
         * If the <code>CreateBucketMetadataTableConfiguration</code> request succeeds, but S3 Metadata was unable to
         * create the table, this structure contains the error message. The possible error codes and error messages are
         * as follows:
         * </p>
         * <ul>
         * <li>
         * <p>
         * <code>AccessDeniedCreatingResources</code> - You don't have sufficient permissions to create the required
         * resources. Make sure that you have <code>s3tables:CreateNamespace</code>, <code>s3tables:CreateTable</code>,
         * <code>s3tables:GetTable</code> and <code>s3tables:PutTablePolicy</code> permissions, and then try again. To
         * create a new metadata table, you must delete the metadata configuration for this bucket, and then create a
         * new metadata configuration.
         * </p>
         * </li>
         * <li>
         * <p>
         * <code>AccessDeniedWritingToTable</code> - Unable to write to the metadata table because of missing resource
         * permissions. To fix the resource policy, Amazon S3 needs to create a new metadata table. To create a new
         * metadata table, you must delete the metadata configuration for this bucket, and then create a new metadata
         * configuration.
         * </p>
         * </li>
         * <li>
         * <p>
         * <code>DestinationTableNotFound</code> - The destination table doesn't exist. To create a new metadata table,
         * you must delete the metadata configuration for this bucket, and then create a new metadata configuration.
         * </p>
         * </li>
         * <li>
         * <p>
         * <code>ServerInternalError</code> - An internal error has occurred. To create a new metadata table, you must
         * delete the metadata configuration for this bucket, and then create a new metadata configuration.
         * </p>
         * </li>
         * <li>
         * <p>
         * <code>TableAlreadyExists</code> - The table that you specified already exists in the table bucket's
         * namespace. Specify a different table name. To create a new metadata table, you must delete the metadata
         * configuration for this bucket, and then create a new metadata configuration.
         * </p>
         * </li>
         * <li>
         * <p>
         * <code>TableBucketNotFound</code> - The table bucket that you specified doesn't exist in this Amazon Web
         * Services Region and account. Create or choose a different table bucket. To create a new metadata table, you
         * must delete the metadata configuration for this bucket, and then create a new metadata configuration.
         * </p>
         * </li>
         * </ul>
         * 
         * @param errorMessage
         *        If the <code>CreateBucketMetadataTableConfiguration</code> request succeeds, but S3 Metadata was
         *        unable to create the table, this structure contains the error message. The possible error codes and
         *        error messages are as follows: </p>
         *        <ul>
         *        <li>
         *        <p>
         *        <code>AccessDeniedCreatingResources</code> - You don't have sufficient permissions to create the
         *        required resources. Make sure that you have <code>s3tables:CreateNamespace</code>,
         *        <code>s3tables:CreateTable</code>, <code>s3tables:GetTable</code> and
         *        <code>s3tables:PutTablePolicy</code> permissions, and then try again. To create a new metadata table,
         *        you must delete the metadata configuration for this bucket, and then create a new metadata
         *        configuration.
         *        </p>
         *        </li>
         *        <li>
         *        <p>
         *        <code>AccessDeniedWritingToTable</code> - Unable to write to the metadata table because of missing
         *        resource permissions. To fix the resource policy, Amazon S3 needs to create a new metadata table. To
         *        create a new metadata table, you must delete the metadata configuration for this bucket, and then
         *        create a new metadata configuration.
         *        </p>
         *        </li>
         *        <li>
         *        <p>
         *        <code>DestinationTableNotFound</code> - The destination table doesn't exist. To create a new metadata
         *        table, you must delete the metadata configuration for this bucket, and then create a new metadata
         *        configuration.
         *        </p>
         *        </li>
         *        <li>
         *        <p>
         *        <code>ServerInternalError</code> - An internal error has occurred. To create a new metadata table, you
         *        must delete the metadata configuration for this bucket, and then create a new metadata configuration.
         *        </p>
         *        </li>
         *        <li>
         *        <p>
         *        <code>TableAlreadyExists</code> - The table that you specified already exists in the table bucket's
         *        namespace. Specify a different table name. To create a new metadata table, you must delete the
         *        metadata configuration for this bucket, and then create a new metadata configuration.
         *        </p>
         *        </li>
         *        <li>
         *        <p>
         *        <code>TableBucketNotFound</code> - The table bucket that you specified doesn't exist in this Amazon
         *        Web Services Region and account. Create or choose a different table bucket. To create a new metadata
         *        table, you must delete the metadata configuration for this bucket, and then create a new metadata
         *        configuration.
         *        </p>
         *        </li>
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder errorMessage(String errorMessage);
    }

    static final class BuilderImpl implements Builder {
        private String errorCode;

        private String errorMessage;

        private BuilderImpl() {
        }

        private BuilderImpl(ErrorDetails model) {
            errorCode(model.errorCode);
            errorMessage(model.errorMessage);
        }

        public final String getErrorCode() {
            return errorCode;
        }

        public final void setErrorCode(String errorCode) {
            this.errorCode = errorCode;
        }

        @Override
        public final Builder errorCode(String errorCode) {
            this.errorCode = errorCode;
            return this;
        }

        public final String getErrorMessage() {
            return errorMessage;
        }

        public final void setErrorMessage(String errorMessage) {
            this.errorMessage = errorMessage;
        }

        @Override
        public final Builder errorMessage(String errorMessage) {
            this.errorMessage = errorMessage;
            return this;
        }

        @Override
        public ErrorDetails build() {
            return new ErrorDetails(this);
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
