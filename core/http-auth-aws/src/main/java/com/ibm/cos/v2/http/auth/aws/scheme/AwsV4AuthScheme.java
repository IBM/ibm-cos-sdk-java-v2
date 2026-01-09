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

package com.ibm.cos.v2.http.auth.aws.scheme;

import com.ibm.cos.v2.annotations.SdkPublicApi;
import com.ibm.cos.v2.http.auth.aws.internal.scheme.DefaultAwsV4AuthScheme;
import com.ibm.cos.v2.http.auth.aws.signer.AwsV4HttpSigner;
import com.ibm.cos.v2.http.auth.spi.scheme.AuthScheme;
import com.ibm.cos.v2.identity.spi.AwsCredentialsIdentity;
import com.ibm.cos.v2.identity.spi.IdentityProvider;
import com.ibm.cos.v2.identity.spi.IdentityProviders;

/**
 * The <a href="https://smithy.io/2.0/aws/aws-auth.html#aws-auth-sigv4-trait">aws.auth#sigv4</a> auth scheme, which uses a
 * {@link AwsCredentialsIdentity} and {@link AwsV4HttpSigner}.
 */
@SdkPublicApi
public interface AwsV4AuthScheme extends AuthScheme<AwsCredentialsIdentity> {

    /**
     * The scheme ID for this interface.
     */
    String SCHEME_ID = "aws.auth#sigv4";

    /**
     * Get a default implementation of a {@link AwsV4AuthScheme}
     */
    static AwsV4AuthScheme create() {
        return DefaultAwsV4AuthScheme.create();
    }

    /**
     * Retrieve the {@link AwsCredentialsIdentity} based {@link IdentityProvider} associated with this authentication scheme.
     */
    @Override
    IdentityProvider<AwsCredentialsIdentity> identityProvider(IdentityProviders providers);

    /**
     * Retrieve the {@link AwsV4HttpSigner} associated with this authentication scheme.
     */
    @Override
    AwsV4HttpSigner signer();
}
