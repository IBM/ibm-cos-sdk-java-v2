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

package com.ibm.cos.v2.protocols.json;

import com.ibm.cos.v2.annotations.SdkProtectedApi;
import com.ibm.cos.v2.annotations.ThreadSafe;
import com.ibm.cos.v2.protocols.json.internal.unmarshall.JsonProtocolUnmarshaller;

/**
 * Factory to generate the various JSON protocol handlers and generators to be used for
 * communicating with the service.
 */
@ThreadSafe
@SdkProtectedApi
public final class AwsJsonProtocolFactory extends BaseAwsJsonProtocolFactory {

    protected AwsJsonProtocolFactory(Builder builder) {
        super(builder);
    }

    public static Builder builder() {
        return new Builder();
    }

    /**
     * Builder for {@link AwsJsonProtocolFactory}.
     */
    public static final class Builder extends BaseAwsJsonProtocolFactory.Builder<Builder> {

        private Builder() {
            protocolUnmarshallDependencies(JsonProtocolUnmarshaller::defaultProtocolUnmarshallDependencies);
        }

        public AwsJsonProtocolFactory build() {
            return new AwsJsonProtocolFactory(this);
        }

    }
}
