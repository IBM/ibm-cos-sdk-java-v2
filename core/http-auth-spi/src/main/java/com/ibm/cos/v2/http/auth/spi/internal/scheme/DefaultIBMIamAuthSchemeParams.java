/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License").
 * You may not use this file except in compliance with the License.
 * A copy of the License is located at
 *
 *  http://aws.amazon.com/apache2.0
 *
 * or in the "license" file accompanying this file. This file is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */

package com.ibm.cos.v2.http.auth.spi.internal.scheme;

import com.ibm.cos.v2.utils.Validate;

public class DefaultIBMIamAuthSchemeParams implements IBMIamAuthSchemeParams {
    private final String operation;

    private final String apiKey;

    private final String serviceInstaceId;

    private DefaultIBMIamAuthSchemeParams(Builder builder) {
        this.operation = Validate.paramNotNull(builder.operation, "operation");
        this.apiKey = builder.build().apiKey();
        this.serviceInstaceId = builder.build().serviceInstanceId();
    }

    public static IBMIamAuthSchemeParams.Builder builder() {
        return new Builder();
    }

    @Override
    public String operation() {
        return operation;
    }

    @Override
    public String apiKey() {
        return "";
    }

    @Override
    public String serviceInstanceId() {
        return "";
    }

    @Override
    public IBMIamAuthSchemeParams.Builder toBuilder() {
        return new Builder(this);
    }

    private static final class Builder implements IBMIamAuthSchemeParams.Builder {
        private String operation;

        private String apiKey;

        private String serviceInstanceId;

        Builder() {
        }

        Builder(DefaultIBMIamAuthSchemeParams params) {
            this.operation = params.operation;
            this.apiKey = params.apiKey;
            this.serviceInstanceId = params.serviceInstaceId;
        }

        @Override
        public Builder operation(String operation) {
            this.operation = operation;
            return this;
        }

        @Override
        public Builder apiKey(String apiKey) {
            this.apiKey = apiKey;
            return this;
        }

        @Override
        public Builder serviceInstanceId(String serviceInstanceId) {
            this.serviceInstanceId = serviceInstanceId;
            return this;
        }

        @Override
        public IBMIamAuthSchemeParams build() {
            return new DefaultIBMIamAuthSchemeParams(this);
        }
    }
}
