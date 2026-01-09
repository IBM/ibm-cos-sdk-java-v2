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

package com.ibm.cos.v2.auth.token.signer;

import static com.ibm.cos.v2.utils.CompletableFutureUtils.joinLikeSync;

import java.util.concurrent.CompletableFuture;
import com.ibm.cos.v2.annotations.SdkProtectedApi;
import com.ibm.cos.v2.auth.token.credentials.SdkToken;
import com.ibm.cos.v2.core.SelectedAuthScheme;
import com.ibm.cos.v2.core.interceptor.ExecutionAttribute;
import com.ibm.cos.v2.core.interceptor.SdkInternalExecutionAttribute;
import com.ibm.cos.v2.http.auth.scheme.BearerAuthScheme;
import com.ibm.cos.v2.http.auth.signer.BearerHttpSigner;
import com.ibm.cos.v2.http.auth.spi.scheme.AuthSchemeOption;
import com.ibm.cos.v2.identity.spi.Identity;

/**
 * SdkToken authorizing attributes attached to the execution.
 *
 * @deprecated Signer execution attributes have been deprecated in favor of signer properties, set on the auth scheme's signer
 * options.
 */
@Deprecated
@SdkProtectedApi
public final class SdkTokenExecutionAttribute {

    /**
     * The token to sign requests using token authorization instead of AWS Credentials.
     *
     * @deprecated This is a protected class that is internal to the SDK, so you shouldn't be using it.
     */
    @Deprecated
    public static final ExecutionAttribute<SdkToken> SDK_TOKEN =
        ExecutionAttribute.derivedBuilder("SdkToken",
                                          SdkToken.class,
                                          SdkInternalExecutionAttribute.SELECTED_AUTH_SCHEME)
                          .readMapping(SdkTokenExecutionAttribute::sdkTokenReadMapping)
                          .writeMapping(SdkTokenExecutionAttribute::sdkTokenWriteMapping)
                          .build();

    private SdkTokenExecutionAttribute() {
    }


    private static SdkToken sdkTokenReadMapping(SelectedAuthScheme<?> authScheme) {
        if (authScheme == null) {
            return null;
        }
        Identity identity = joinLikeSync(authScheme.identity());
        if (!(identity instanceof SdkToken)) {
            return null;
        }
        return (SdkToken) identity;
    }

    private static <T extends Identity> SelectedAuthScheme<?> sdkTokenWriteMapping(SelectedAuthScheme<T> authScheme,
                                                                                   SdkToken token) {
        if (authScheme == null) {
            // This is an unusual use-case.
            // Let's assume they're setting the token so that they can call the signer directly. If that's true, then it
            // doesn't really matter what we store other than the credentials.
            return new SelectedAuthScheme<>(CompletableFuture.completedFuture(token),
                                            BearerHttpSigner.create(),
                                            AuthSchemeOption.builder()
                                                            .schemeId(BearerAuthScheme.SCHEME_ID)
                                                            .build());
        }

        return new SelectedAuthScheme<>(CompletableFuture.completedFuture((T) token),
                                        authScheme.signer(),
                                        authScheme.authSchemeOption());
    }
}
