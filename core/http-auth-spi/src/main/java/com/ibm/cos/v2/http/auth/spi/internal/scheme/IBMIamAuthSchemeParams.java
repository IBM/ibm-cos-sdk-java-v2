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

import com.ibm.cos.v2.utils.builder.CopyableBuilder;
import com.ibm.cos.v2.utils.builder.ToCopyableBuilder;

public interface IBMIamAuthSchemeParams extends ToCopyableBuilder<IBMIamAuthSchemeParams.Builder, IBMIamAuthSchemeParams> {
    static Builder builder() { return DefaultIBMIamAuthSchemeParams.builder(); }

    String operation();

    String apiKey();

    String serviceInstanceId();

    Builder toBuilder();

    interface Builder extends CopyableBuilder<Builder, IBMIamAuthSchemeParams> {
        /**
         * Set the operation for which to resolve the auth scheme.
         */
        Builder operation(String operation);

        /**
         * Set the apiKey. The apiKey parameter to be used with the auth scheme for authentication
         */
        Builder apiKey(String apiKey);

        /**
         * Set the serviceInstanceId. The serviceInstanceId parameter to be used with the auth scheme for authentication
         */
        Builder serviceInstanceId(String serviceInstanceId);

        /**
         * Returns a {@link IBMIamAuthSchemeParams} object that is created from the properties that have been
         * set on the builder.
         */
        IBMIamAuthSchemeParams build();
    }
}
