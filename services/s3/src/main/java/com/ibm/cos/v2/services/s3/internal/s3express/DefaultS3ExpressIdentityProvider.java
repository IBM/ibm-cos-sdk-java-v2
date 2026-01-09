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

package com.ibm.cos.v2.services.s3.internal.s3express;

import java.util.concurrent.CompletableFuture;
import com.ibm.cos.v2.annotations.SdkInternalApi;
import com.ibm.cos.v2.core.SdkClient;
import com.ibm.cos.v2.core.identity.SdkIdentityProperty;
import com.ibm.cos.v2.identity.spi.AwsCredentialsIdentity;
import com.ibm.cos.v2.identity.spi.IdentityProvider;
import com.ibm.cos.v2.identity.spi.ResolveIdentityRequest;
import com.ibm.cos.v2.services.s3.s3express.S3ExpressSessionCredentials;

@SdkInternalApi
public final class DefaultS3ExpressIdentityProvider implements IdentityProvider<S3ExpressSessionCredentials> {

    private final S3ExpressIdentityCache identityCache;
    private final IdentityProvider<AwsCredentialsIdentity> baseIdentityProvider;

    public DefaultS3ExpressIdentityProvider(S3ExpressIdentityCache identityCache,
                                            IdentityProvider<AwsCredentialsIdentity> baseIdentityProvider) {
        this.identityCache = identityCache;
        this.baseIdentityProvider = baseIdentityProvider;
    }

    @Override
    public Class<S3ExpressSessionCredentials> identityType() {
        return S3ExpressSessionCredentials.class;
    }

    @Override
    public CompletableFuture<S3ExpressSessionCredentials> resolveIdentity(ResolveIdentityRequest request) {
        String bucket = request.property(S3ExpressAuthSchemeProvider.BUCKET);
        SdkClient client = request.property(SdkIdentityProperty.SDK_CLIENT);

        return baseIdentityProvider.resolveIdentity(request).thenApply(identity -> {
            S3ExpressIdentityKey key = S3ExpressIdentityKey.builder()
                                                           .bucket(bucket)
                                                           .client(client)
                                                           .identity(identity)
                                                           .build();
            // TODO unwrap any exception
            return identityCache.get(key);
        });
    }
}
