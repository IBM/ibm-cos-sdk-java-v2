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

package com.ibm.cos.v2.core.signer;

import com.ibm.cos.v2.annotations.SdkPublicApi;
import com.ibm.cos.v2.core.interceptor.ExecutionAttributes;
import com.ibm.cos.v2.http.SdkHttpFullRequest;

/**
 * A No op implementation of Signer and Presigner interfaces that returns the
 * input {@link SdkHttpFullRequest} without modifications.
 *
 * @deprecated Replaced by {@code com.ibm.cos.v2.http.auth.spi.signer.HttpSigner#doNotSign()} in
 * 'http-auth-spi'.
 */
@SdkPublicApi
@Deprecated
public final class NoOpSigner implements Signer, Presigner {

    @Override
    public SdkHttpFullRequest presign(SdkHttpFullRequest request, ExecutionAttributes executionAttributes) {
        return request;
    }

    @Override
    public SdkHttpFullRequest sign(SdkHttpFullRequest request, ExecutionAttributes executionAttributes) {
        return request;
    }
}
