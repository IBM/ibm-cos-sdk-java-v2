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

package com.ibm.cos.v2.http.auth.scheme;

import com.ibm.cos.v2.annotations.SdkPublicApi;
import com.ibm.cos.v2.http.auth.internal.scheme.DefaultNoAuthAuthScheme;
import com.ibm.cos.v2.http.auth.spi.scheme.AuthScheme;
import com.ibm.cos.v2.http.auth.spi.signer.HttpSigner;
import com.ibm.cos.v2.identity.spi.Identity;
import com.ibm.cos.v2.identity.spi.IdentityProvider;
import com.ibm.cos.v2.identity.spi.IdentityProviders;

/**
 * An auth scheme that represents no authentication.
 */
@SdkPublicApi
public interface NoAuthAuthScheme extends AuthScheme<NoAuthAuthScheme.AnonymousIdentity> {
    /**
     * The scheme ID for the no-auth auth scheme.
     */
    String SCHEME_ID = "smithy.api#noAuth";

    static NoAuthAuthScheme create() {
        return DefaultNoAuthAuthScheme.create();
    }

    /**
     * Retrieve the {@link AnonymousIdentity} based {@link IdentityProvider} associated with this authentication scheme.
     */
    @Override
    IdentityProvider<AnonymousIdentity> identityProvider(IdentityProviders providers);

    /**
     * Retrieve the {@link HttpSigner} associated with this authentication scheme.
     */
    @Override
    HttpSigner<AnonymousIdentity> signer();

    /**
     * An anonymous identity used by the no-auth auth scheme.
     */
    interface AnonymousIdentity extends Identity {
    }
}
