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

package com.ibm.cos.v2.http.auth.signer;

import com.ibm.cos.v2.annotations.SdkPublicApi;
import com.ibm.cos.v2.http.auth.internal.signer.DefaultBearerHttpSigner;
import com.ibm.cos.v2.http.auth.spi.signer.HttpSigner;
import com.ibm.cos.v2.identity.spi.TokenIdentity;

/**
 * An {@link HttpSigner} that will sign a request with a bearer-token ({@link TokenIdentity}).
 */
@SdkPublicApi
public interface BearerHttpSigner extends HttpSigner<TokenIdentity> {

    /**
     * Get a default implementation of a {@link BearerHttpSigner}
     *
     * @return BearerHttpSigner
     */
    static BearerHttpSigner create() {
        return new DefaultBearerHttpSigner();
    }
}
