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

import com.ibm.cos.v2.annotations.Generated;
import com.ibm.cos.v2.awscore.AwsResponse;
import com.ibm.cos.v2.awscore.AwsResponseMetadata;

@Generated("com.ibm.cos.v2:codegen")
public abstract class KmsResponse extends AwsResponse {
    private final KmsResponseMetadata responseMetadata;

    protected KmsResponse(Builder builder) {
        super(builder);
        this.responseMetadata = builder.responseMetadata();
    }

    @Override
    public KmsResponseMetadata responseMetadata() {
        return responseMetadata;
    }

    public interface Builder extends AwsResponse.Builder {
        @Override
        KmsResponse build();

        @Override
        KmsResponseMetadata responseMetadata();

        @Override
        Builder responseMetadata(AwsResponseMetadata metadata);
    }

    protected abstract static class BuilderImpl extends AwsResponse.BuilderImpl implements Builder {
        private KmsResponseMetadata responseMetadata;

        protected BuilderImpl() {
        }

        protected BuilderImpl(KmsResponse response) {
            super(response);
            this.responseMetadata = response.responseMetadata();
        }

        @Override
        public KmsResponseMetadata responseMetadata() {
            return responseMetadata;
        }

        @Override
        public Builder responseMetadata(AwsResponseMetadata responseMetadata) {
            this.responseMetadata = KmsResponseMetadata.create(responseMetadata);
            return this;
        }
    }
}
