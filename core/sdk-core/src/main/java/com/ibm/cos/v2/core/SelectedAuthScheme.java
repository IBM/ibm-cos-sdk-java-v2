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

import java.util.concurrent.CompletableFuture;
import com.ibm.cos.v2.annotations.SdkProtectedApi;
import com.ibm.cos.v2.http.auth.spi.scheme.AuthSchemeOption;
import com.ibm.cos.v2.http.auth.spi.signer.HttpSigner;
import com.ibm.cos.v2.identity.spi.Identity;
import com.ibm.cos.v2.utils.Validate;

/**
 * A container for the identity resolver, signer and auth option that we selected for use with this service call attempt.
 */
@SdkProtectedApi
public final class SelectedAuthScheme<T extends Identity> {
    private final CompletableFuture<? extends T> identity;

    public SelectedAuthScheme(CompletableFuture<? extends T> identity,
                              HttpSigner<T> signer,
                              AuthSchemeOption authSchemeOption) {
        this.identity = Validate.paramNotNull(identity, "identity");
        this.signer = Validate.paramNotNull(signer, "signer");
        this.authSchemeOption = Validate.paramNotNull(authSchemeOption, "authSchemeOption");
    }

    private final HttpSigner<T> signer;
    private final AuthSchemeOption authSchemeOption;

    public CompletableFuture<? extends T> identity() {
        return identity;
    }

    public HttpSigner<T> signer() {
        return signer;
    }

    public AuthSchemeOption authSchemeOption() {
        return authSchemeOption;
    }
}
