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

import static com.ibm.cos.v2.services.sts.internal.StsAuthUtils.accountIdFromArn;
import static com.ibm.cos.v2.services.sts.internal.StsAuthUtils.fromStsCredentials;

import java.util.function.Consumer;
import java.util.function.Supplier;
import com.ibm.cos.v2.annotations.NotThreadSafe;
import com.ibm.cos.v2.annotations.SdkPublicApi;
import com.ibm.cos.v2.annotations.ThreadSafe;
import com.ibm.cos.v2.auth.credentials.AwsCredentialsProvider;
import com.ibm.cos.v2.auth.credentials.AwsSessionCredentials;
import com.ibm.cos.v2.services.sts.StsClient;
import com.ibm.cos.v2.services.sts.model.AssumeRoleWithSamlRequest;
import com.ibm.cos.v2.services.sts.model.AssumeRoleWithSamlResponse;
import com.ibm.cos.v2.utils.Validate;
import com.ibm.cos.v2.utils.builder.ToCopyableBuilder;

/**
 * An implementation of {@link AwsCredentialsProvider} that periodically sends an {@link AssumeRoleWithSamlRequest} to the AWS
 * Security Token Service to maintain short-lived sessions to use for authentication. These sessions are updated using a single
 * calling thread (by default) or asynchronously (if {@link Builder#asyncCredentialUpdateEnabled(Boolean)} is set).
 *
 * If the credentials are not successfully updated before expiration, calls to {@link #resolveCredentials()} will block until
 * they are updated successfully.
 *
 * Users of this provider must {@link #close()} it when they are finished using it.
 *
 * This is created using {@link StsAssumeRoleWithSamlCredentialsProvider#builder()}.
 */
@SdkPublicApi
@ThreadSafe
public final class StsAssumeRoleWithSamlCredentialsProvider
    extends StsCredentialsProvider
    implements ToCopyableBuilder<StsAssumeRoleWithSamlCredentialsProvider.Builder, StsAssumeRoleWithSamlCredentialsProvider> {
    private static final String PROVIDER_NAME = "StsAssumeRoleWithSamlCredentialsProvider";
    private final Supplier<AssumeRoleWithSamlRequest> assumeRoleWithSamlRequestSupplier;


    /**
     * @see #builder()
     */
    private StsAssumeRoleWithSamlCredentialsProvider(Builder builder) {
        super(builder, "sts-assume-role-with-saml-credentials-provider");
        Validate.notNull(builder.assumeRoleWithSamlRequestSupplier, "Assume role with SAML request must not be null.");

        this.assumeRoleWithSamlRequestSupplier = builder.assumeRoleWithSamlRequestSupplier;
    }

    /**
     * Create a builder for an {@link StsAssumeRoleWithSamlCredentialsProvider}.
     */
    public static Builder builder() {
        return new Builder();
    }

    @Override
    protected AwsSessionCredentials getUpdatedCredentials(StsClient stsClient) {
        AssumeRoleWithSamlRequest assumeRoleWithSamlRequest = assumeRoleWithSamlRequestSupplier.get();
        Validate.notNull(assumeRoleWithSamlRequest, "Assume role with saml request must not be null.");
        AssumeRoleWithSamlResponse assumeRoleResponse = stsClient.assumeRoleWithSAML(assumeRoleWithSamlRequest);
        return fromStsCredentials(assumeRoleResponse.credentials(),
                                  PROVIDER_NAME,
                                  accountIdFromArn(assumeRoleResponse.assumedRoleUser()));
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
     * A builder (created by {@link StsAssumeRoleWithSamlCredentialsProvider#builder()}) for creating a
     * {@link StsAssumeRoleWithSamlCredentialsProvider}.
     */
    @NotThreadSafe
    public static final class Builder extends BaseBuilder<Builder, StsAssumeRoleWithSamlCredentialsProvider> {
        private Supplier<AssumeRoleWithSamlRequest> assumeRoleWithSamlRequestSupplier;

        private Builder() {
            super(StsAssumeRoleWithSamlCredentialsProvider::new);
        }

        public Builder(StsAssumeRoleWithSamlCredentialsProvider provider) {
            super(StsAssumeRoleWithSamlCredentialsProvider::new, provider);
            this.assumeRoleWithSamlRequestSupplier = provider.assumeRoleWithSamlRequestSupplier;
        }

        /**
         * Configure the {@link AssumeRoleWithSamlRequest} that should be periodically sent to the STS service to update
         * the session token when it gets close to expiring.
         *
         * @param assumeRoleWithSamlRequest The request to send to STS whenever the assumed session expires.
         * @return This object for chained calls.
         */
        public Builder refreshRequest(AssumeRoleWithSamlRequest assumeRoleWithSamlRequest) {
            return refreshRequest(() -> assumeRoleWithSamlRequest);
        }

        /**
         * Similar to {@link #refreshRequest(AssumeRoleWithSamlRequest)}, but takes a {@link Supplier} to supply the request to
         * STS.
         *
         * @param assumeRoleWithSamlRequestSupplier A supplier
         * @return This object for chained calls.
         */
        public Builder refreshRequest(Supplier<AssumeRoleWithSamlRequest> assumeRoleWithSamlRequestSupplier) {
            this.assumeRoleWithSamlRequestSupplier = assumeRoleWithSamlRequestSupplier;
            return this;
        }

        /**
         * Similar to {@link #refreshRequest(AssumeRoleWithSamlRequest)}, but takes a lambda to configure a new
         * {@link AssumeRoleWithSamlRequest.Builder}. This removes the need to called {@link AssumeRoleWithSamlRequest#builder()}
         * and {@link AssumeRoleWithSamlRequest.Builder#build()}.
         */
        public Builder refreshRequest(Consumer<AssumeRoleWithSamlRequest.Builder> assumeRoleWithSamlRequest) {
            return refreshRequest(AssumeRoleWithSamlRequest.builder().applyMutation(assumeRoleWithSamlRequest).build());
        }

        @Override
        public StsAssumeRoleWithSamlCredentialsProvider build() {
            return super.build();
        }
    }
}
