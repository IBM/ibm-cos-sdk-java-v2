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

package com.ibm.cos.v2.services.sts.model;

import com.ibm.cos.v2.annotations.Generated;
import com.ibm.cos.v2.awscore.AwsResponse;
import com.ibm.cos.v2.awscore.AwsResponseMetadata;

@Generated("com.ibm.cos.v2:codegen")
public abstract class StsResponse extends AwsResponse {
    private final StsResponseMetadata responseMetadata;

    protected StsResponse(Builder builder) {
        super(builder);
        this.responseMetadata = builder.responseMetadata();
    }

    @Override
    public StsResponseMetadata responseMetadata() {
        return responseMetadata;
    }

    public interface Builder extends AwsResponse.Builder {
        @Override
        StsResponse build();

        @Override
        StsResponseMetadata responseMetadata();

        @Override
        Builder responseMetadata(AwsResponseMetadata metadata);
    }

    protected abstract static class BuilderImpl extends AwsResponse.BuilderImpl implements Builder {
        private StsResponseMetadata responseMetadata;

        protected BuilderImpl() {
        }

        protected BuilderImpl(StsResponse response) {
            super(response);
            this.responseMetadata = response.responseMetadata();
        }

        @Override
        public StsResponseMetadata responseMetadata() {
            return responseMetadata;
        }

        @Override
        public Builder responseMetadata(AwsResponseMetadata responseMetadata) {
            this.responseMetadata = StsResponseMetadata.create(responseMetadata);
            return this;
        }
    }
}
