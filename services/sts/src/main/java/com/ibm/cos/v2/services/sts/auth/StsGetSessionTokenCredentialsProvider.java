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

package com.ibm.cos.v2.services.sts.auth;

import static com.ibm.cos.v2.services.sts.internal.StsAuthUtils.fromStsCredentials;

import java.util.function.Consumer;
import com.ibm.cos.v2.annotations.NotThreadSafe;
import com.ibm.cos.v2.annotations.SdkPublicApi;
import com.ibm.cos.v2.annotations.ThreadSafe;
import com.ibm.cos.v2.auth.credentials.AwsCredentialsProvider;
import com.ibm.cos.v2.auth.credentials.AwsSessionCredentials;
import com.ibm.cos.v2.services.sts.StsClient;
import com.ibm.cos.v2.services.sts.model.GetSessionTokenRequest;
import com.ibm.cos.v2.services.sts.model.GetSessionTokenResponse;
import com.ibm.cos.v2.utils.Validate;
import com.ibm.cos.v2.utils.builder.ToCopyableBuilder;

/**
 * An implementation of {@link AwsCredentialsProvider} that periodically sends a {@link GetSessionTokenRequest} to the AWS
 * Security Token Service to maintain short-lived sessions to use for authentication. These sessions are updated using a single
 * calling thread (by default) or asynchronously (if {@link Builder#asyncCredentialUpdateEnabled(Boolean)} is set).
 *
 * If the credentials are not successfully updated before expiration, calls to {@link #resolveCredentials()} will block until
 * they are updated successfully.
 *
 * Users of this provider must {@link #close()} it when they are finished using it.
 *
 * This is created using {@link #builder()}.
 */
@SdkPublicApi
@ThreadSafe
public class StsGetSessionTokenCredentialsProvider
    extends StsCredentialsProvider
    implements ToCopyableBuilder<StsGetSessionTokenCredentialsProvider.Builder, StsGetSessionTokenCredentialsProvider> {
    private static final String PROVIDER_NAME = "StsGetSessionTokenCredentialsProvider";

    private final GetSessionTokenRequest getSessionTokenRequest;

    /**
     * @see #builder()
     */
    private StsGetSessionTokenCredentialsProvider(Builder builder) {
        super(builder, "sts-get-token-credentials-provider");
        Validate.notNull(builder.getSessionTokenRequest, "Get session token request must not be null.");

        this.getSessionTokenRequest = builder.getSessionTokenRequest;
    }

    /**
     * Create a builder for an {@link StsGetSessionTokenCredentialsProvider}.
     */
    public static Builder builder() {
        return new Builder();
    }

    @Override
    protected AwsSessionCredentials getUpdatedCredentials(StsClient stsClient) {
        GetSessionTokenResponse sessionToken = stsClient.getSessionToken(getSessionTokenRequest);
        return fromStsCredentials(sessionToken.credentials(), PROVIDER_NAME);
    }

    @Override
    public Builder toBuilder() {
        return new Builder(this);
    }

    @Override
    String providerName() {
        return PROVIDER_NAME;
    }

    /**
     * A builder (created by {@link StsGetSessionTokenCredentialsProvider#builder()}) for creating a
     * {@link StsGetSessionTokenCredentialsProvider}.
     */
    @NotThreadSafe
    public static final class Builder extends BaseBuilder<Builder, StsGetSessionTokenCredentialsProvider> {
        private GetSessionTokenRequest getSessionTokenRequest = GetSessionTokenRequest.builder().build();

        private Builder() {
            super(StsGetSessionTokenCredentialsProvider::new);
        }

        public Builder(StsGetSessionTokenCredentialsProvider provider) {
            super(StsGetSessionTokenCredentialsProvider::new, provider);
            this.getSessionTokenRequest = provider.getSessionTokenRequest;
        }

        /**
         * Configure the {@link GetSessionTokenRequest} that should be periodically sent to the STS service to update the session
         * token when it gets close to expiring.
         *
         * If this is not specified, default values are used.
         *
         * @param getSessionTokenRequest The request to send to STS whenever the assumed session expires.
         * @return This object for chained calls.
         */
        public Builder refreshRequest(GetSessionTokenRequest getSessionTokenRequest) {
            this.getSessionTokenRequest = getSessionTokenRequest;
            return this;
        }

        /**
         * Similar to {@link #refreshRequest(GetSessionTokenRequest)}, but takes a lambda to configure a new
         * {@link GetSessionTokenRequest.Builder}. This removes the need to called
         * {@link GetSessionTokenRequest#builder()} and {@link GetSessionTokenRequest.Builder#build()}.
         */
        public Builder refreshRequest(Consumer<GetSessionTokenRequest.Builder> getFederationTokenRequest) {
            return refreshRequest(GetSessionTokenRequest.builder().applyMutation(getFederationTokenRequest).build());
        }
        
        @Override
        public StsGetSessionTokenCredentialsProvider build() {
            return super.build();
        }
    }
}
