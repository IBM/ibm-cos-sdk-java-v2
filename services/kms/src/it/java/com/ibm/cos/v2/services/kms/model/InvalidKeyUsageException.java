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

import java.util.Collections;
import java.util.List;
import java.util.Map;
import com.ibm.cos.v2.annotations.Generated;
import com.ibm.cos.v2.annotations.Mutable;
import com.ibm.cos.v2.annotations.NotThreadSafe;
import com.ibm.cos.v2.awscore.exception.AwsErrorDetails;
import com.ibm.cos.v2.core.SdkField;
import com.ibm.cos.v2.core.SdkPojo;
import com.ibm.cos.v2.utils.builder.CopyableBuilder;
import com.ibm.cos.v2.utils.builder.ToCopyableBuilder;

/**
 * <p>
 * The request was rejected for one of the following reasons:
 * </p>
 * <ul>
 * <li>
 * <p>
 * The <code>KeyUsage</code> value of the KMS key is incompatible with the API operation.
 * </p>
 * </li>
 * <li>
 * <p>
 * The encryption algorithm or signing algorithm specified for the operation is incompatible with the type of key
 * material in the KMS key <code>(KeySpec</code>).
 * </p>
 * </li>
 * </ul>
 * <p>
 * For encrypting, decrypting, re-encrypting, and generating data keys, the <code>KeyUsage</code> must be
 * <code>ENCRYPT_DECRYPT</code>. For signing and verifying messages, the <code>KeyUsage</code> must be
 * <code>SIGN_VERIFY</code>. For generating and verifying message authentication codes (MACs), the <code>KeyUsage</code>
 * must be <code>GENERATE_VERIFY_MAC</code>. For deriving key agreement secrets, the <code>KeyUsage</code> must be
 * <code>KEY_AGREEMENT</code>. To find the <code>KeyUsage</code> of a KMS key, use the <a>DescribeKey</a> operation.
 * </p>
 * <p>
 * To find the encryption or signing algorithms supported for a particular KMS key, use the <a>DescribeKey</a>
 * operation.
 * </p>
 */
@Generated("com.ibm.cos.v2:codegen")
public final class InvalidKeyUsageException extends KmsException implements
        ToCopyableBuilder<InvalidKeyUsageException.Builder, InvalidKeyUsageException> {
    private static final List<SdkField<?>> SDK_FIELDS = Collections.emptyList();

    private static final Map<String, SdkField<?>> SDK_NAME_TO_FIELD = memberNameToFieldInitializer();

    private static final long serialVersionUID = 1L;

    private InvalidKeyUsageException(BuilderImpl builder) {
        super(builder);
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
    public final List<SdkField<?>> sdkFields() {
        return SDK_FIELDS;
    }

    @Override
    public final Map<String, SdkField<?>> sdkFieldNameToField() {
        return SDK_NAME_TO_FIELD;
    }

    private static Map<String, SdkField<?>> memberNameToFieldInitializer() {
        return Collections.emptyMap();
    }

    @Mutable
    @NotThreadSafe
    public interface Builder extends SdkPojo, CopyableBuilder<Builder, InvalidKeyUsageException>, KmsException.Builder {
        @Override
        Builder awsErrorDetails(AwsErrorDetails awsErrorDetails);

        @Override
        Builder message(String message);

        @Override
        Builder requestId(String requestId);

        @Override
        Builder statusCode(int statusCode);

        @Override
        Builder cause(Throwable cause);

        @Override
        Builder writableStackTrace(Boolean writableStackTrace);

        @Override
        Builder numAttempts(Integer numAttempts);
    }

    static final class BuilderImpl extends KmsException.BuilderImpl implements Builder {
        private BuilderImpl() {
        }

        private BuilderImpl(InvalidKeyUsageException model) {
            super(model);
        }

        @Override
        public BuilderImpl awsErrorDetails(AwsErrorDetails awsErrorDetails) {
            this.awsErrorDetails = awsErrorDetails;
            return this;
        }

        @Override
        public BuilderImpl message(String message) {
            this.message = message;
            return this;
        }

        @Override
        public BuilderImpl requestId(String requestId) {
            this.requestId = requestId;
            return this;
        }

        @Override
        public BuilderImpl statusCode(int statusCode) {
            this.statusCode = statusCode;
            return this;
        }

        @Override
        public BuilderImpl cause(Throwable cause) {
            this.cause = cause;
            return this;
        }

        @Override
        public BuilderImpl writableStackTrace(Boolean writableStackTrace) {
            this.writableStackTrace = writableStackTrace;
            return this;
        }

        @Override
        public BuilderImpl numAttempts(Integer numAttempts) {
            this.numAttempts = numAttempts;
            return this;
        }

        @Override
        public InvalidKeyUsageException build() {
            return new InvalidKeyUsageException(this);
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
