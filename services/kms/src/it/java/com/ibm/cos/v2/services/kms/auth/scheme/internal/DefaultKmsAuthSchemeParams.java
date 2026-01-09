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

package com.ibm.cos.v2.services.kms.auth.scheme.internal;

import com.ibm.cos.v2.annotations.Generated;
import com.ibm.cos.v2.annotations.SdkInternalApi;
import com.ibm.cos.v2.regions.Region;
import com.ibm.cos.v2.services.kms.auth.scheme.KmsAuthSchemeParams;
import com.ibm.cos.v2.utils.Validate;

@Generated("com.ibm.cos.v2:codegen")
@SdkInternalApi
public final class DefaultKmsAuthSchemeParams implements KmsAuthSchemeParams {
    private final String operation;

    private final Region region;

    private DefaultKmsAuthSchemeParams(Builder builder) {
        this.operation = Validate.paramNotNull(builder.operation, "operation");
        this.region = builder.region;
    }

    public static KmsAuthSchemeParams.Builder builder() {
        return new Builder();
    }

    @Override
    public String operation() {
        return operation;
    }

    @Override
    public Region region() {
        return region;
    }

    @Override
    public KmsAuthSchemeParams.Builder toBuilder() {
        return new Builder(this);
    }

    private static final class Builder implements KmsAuthSchemeParams.Builder {
        private String operation;

        private Region region;

        Builder() {
        }

        Builder(DefaultKmsAuthSchemeParams params) {
            this.operation = params.operation;
            this.region = params.region;
        }

        @Override
        public Builder operation(String operation) {
            this.operation = operation;
            return this;
        }

        @Override
        public Builder region(Region region) {
            this.region = region;
            return this;
        }

        @Override
        public KmsAuthSchemeParams build() {
            return new DefaultKmsAuthSchemeParams(this);
        }
    }
}
