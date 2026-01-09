/*
 * Copyright 2017 IBM Corp. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */

package com.ibm.cos.v2.auth.credentials.ibmOAuth;

import com.ibm.cos.v2.annotations.SdkInternalApi;
import com.ibm.cos.v2.auth.credentials.CredentialUtils;
import com.ibm.cos.v2.core.SelectedAuthScheme;
import com.ibm.cos.v2.core.interceptor.ExecutionAttribute;
import com.ibm.cos.v2.core.interceptor.SdkExecutionAttribute;
import com.ibm.cos.v2.core.interceptor.SdkInternalExecutionAttribute;
import com.ibm.cos.v2.http.auth.aws.signer.IBMOAuthSigner;
import com.ibm.cos.v2.http.auth.spi.scheme.AuthSchemeOption;
import com.ibm.cos.v2.identity.spi.Identity;
import com.ibm.cos.v2.identity.spi.internal.IBMIamAuthProperties;
import com.ibm.cos.v2.identity.spi.internal.IBMOAuthIdentity;
import java.util.concurrent.CompletableFuture;

/**
 * Execution attribute that contains the {@link IBMOAuthCredentials} to be used
 * when signing requests with the {@link IBMOAuthSigner}.   
 * @see IBMOAuthSigner
 * @see IBMOAuthCredentials
 */
public class IBMSignerExecutionAttribute extends SdkExecutionAttribute {
    public static final ExecutionAttribute<IBMOAuthCredentials> IAM_CREDENTIALS =
        ExecutionAttribute.derivedBuilder("IAMCredentials",
                                          IBMOAuthCredentials.class,
                                          SdkInternalExecutionAttribute.SELECTED_AUTH_SCHEME)
                          .readMapping(IBMSignerExecutionAttribute::ibmCredentialsReadMapping)
                          .writeMapping(IBMSignerExecutionAttribute::ibmCredentialsWriteMapping)
                          .build();

    private static IBMOAuthCredentials ibmCredentialsReadMapping(SelectedAuthScheme<?> authScheme) {
        if (authScheme == null) return null;

        Identity identity = joinLikeSync(authScheme.identity());
        if (!(identity instanceof IBMOAuthIdentity)) return null;

        return CredentialUtils.toIAMCredentials((IBMOAuthIdentity) identity);
    }

    /**
     * Mapping function to write the {@link IBMOAuthCredentials} into a
     * {@link SelectedAuthScheme} that uses the {@link IBMOAuthSigner}. 
        * If the {@code authScheme} is null, a new {@code SelectedAuthScheme} is        
        * created with the {@code IBMOAuthSigner} and the provided credentials.
        * If the {@code authScheme} is not null, it is modified to use the
        * {@code IBMOAuthSigner} and the provided credentials.
     * @param authScheme
     * @param credentials
     * @return  A {@code SelectedAuthScheme} that uses the {@code IBMOAuthSigner} and the provided credentials.
     */
    private static <T extends Identity> SelectedAuthScheme<?> ibmCredentialsWriteMapping(SelectedAuthScheme<T> authScheme,
                                                                                         IBMOAuthCredentials credentials) {
        if (authScheme == null) {
            // Build a new auth scheme with IBM signer
            return new SelectedAuthScheme<>(
                CompletableFuture.completedFuture(credentials),
                IBMOAuthSigner.create(),
                AuthSchemeOption.builder()
                                .schemeId("com.ibm#iamBearerAuth")
                                .putIdentityProperty(IBMIamAuthProperties.API_KEY, credentials.apiKey())
                                .putIdentityProperty(IBMIamAuthProperties.SERVICE_INSTANCE_ID, credentials.serviceInstanceId())
                                .build()
            );
        }

        // Force IAM Signer into existing SelectedAuthScheme
        return new SelectedAuthScheme<>(CompletableFuture.completedFuture(credentials),
            IBMOAuthSigner.create(),
            authScheme.authSchemeOption().copy(option -> {
                option.schemeId("com.ibm#iamBearerAuth");
                option.putIdentityProperty(IBMIamAuthProperties.API_KEY, credentials.apiKey());
                option.putIdentityProperty(IBMIamAuthProperties.SERVICE_INSTANCE_ID, credentials.serviceInstanceId());
            })
        );
    }

    /**
        * Joins the identity future, wrapping any exceptions in a runtime exception.
        * This is safe as this method is only called internally by the SDK.
     */
    @SdkInternalApi
    private static Identity joinLikeSync(CompletableFuture<? extends Identity> identityFuture) {
        try {
            return identityFuture.get(); // Blocking call is safe here as it's internal
        } catch (Exception e) {
            throw new RuntimeException("Failed to retrieve identity from SelectedAuthScheme", e);
        }
    }
}
