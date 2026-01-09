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

package com.ibm.cos.v2.core;

import com.ibm.cos.v2.annotations.SdkPublicApi;
import com.ibm.cos.v2.annotations.ThreadSafe;
import com.ibm.cos.v2.utils.SdkAutoCloseable;

/**
 * All SDK service client interfaces should extend this interface.
 */
@SdkPublicApi
@ThreadSafe
public interface SdkClient extends SdkAutoCloseable {

    /**
     * The name of the service.
     *
     * @return name for this service.
     */
    String serviceName();

    /**
     * The SDK service client configuration exposes client settings to the user, e.g., ClientOverrideConfiguration
     *
     * @return SdkServiceClientConfiguration
     */
    default SdkServiceClientConfiguration serviceClientConfiguration() {
        throw new UnsupportedOperationException();
    }
}
