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

import com.ibm.cos.v2.awscore.AwsRequest;

public abstract class StsRequest extends AwsRequest {
    protected StsRequest(Builder builder) {
        super(builder);
    }

    @Override
    public abstract Builder toBuilder();

    public interface Builder extends AwsRequest.Builder {
        @Override
        StsRequest build();
    }

    protected abstract static class BuilderImpl extends AwsRequest.BuilderImpl implements Builder {
        protected BuilderImpl() {
        }

        protected BuilderImpl(StsRequest request) {
            super(request);
        }
    }
}
