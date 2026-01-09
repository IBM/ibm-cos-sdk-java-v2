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
 * The request was rejected because the state of the specified resource is not valid for this request.
 * </p>
 * <p>
 * This exceptions means one of the following:
 * </p>
 * <ul>
 * <li>
 * <p>
 * The key state of the KMS key is not compatible with the operation.
 * </p>
 * <p>
 * To find the key state, use the <a>DescribeKey</a> operation. For more information about which key states are
 * compatible with each KMS operation, see <a
 * href="https://docs.aws.amazon.com/kms/latest/developerguide/key-state.html">Key states of KMS keys</a> in the <i>
 * <i>Key Management Service Developer Guide</i> </i>.
 * </p>
 * </li>
 * <li>
 * <p>
 * For cryptographic operations on KMS keys in custom key stores, this exception represents a general failure with many
 * possible causes. To identify the cause, see the error message that accompanies the exception.
 * </p>
 * </li>
 * </ul>
 */
@Generated("com.ibm.cos.v2:codegen")
public final class KmsInvalidStateException extends KmsException implements
        ToCopyableBuilder<KmsInvalidStateException.Builder, KmsInvalidStateException> {
    private static final List<SdkField<?>> SDK_FIELDS = Collections.emptyList();

    private static final Map<String, SdkField<?>> SDK_NAME_TO_FIELD = memberNameToFieldInitializer();

    private static final long serialVersionUID = 1L;

    private KmsInvalidStateException(BuilderImpl builder) {
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
    public interface Builder extends SdkPojo, CopyableBuilder<Builder, KmsInvalidStateException>, KmsException.Builder {
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

        private BuilderImpl(KmsInvalidStateException model) {
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
        public KmsInvalidStateException build() {
            return new KmsInvalidStateException(this);
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
