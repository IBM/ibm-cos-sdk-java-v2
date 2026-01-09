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

package com.ibm.cos.v2.awscore.internal.authcontext;

import java.time.Duration;
import com.ibm.cos.v2.annotations.SdkInternalApi;
import com.ibm.cos.v2.auth.credentials.AwsCredentials;
import com.ibm.cos.v2.auth.credentials.CredentialUtils;
import com.ibm.cos.v2.auth.signer.AwsSignerExecutionAttribute;
import com.ibm.cos.v2.awscore.AwsExecutionAttribute;
import com.ibm.cos.v2.awscore.AwsRequestOverrideConfiguration;
import com.ibm.cos.v2.core.RequestOverrideConfiguration;
import com.ibm.cos.v2.core.SdkRequest;
import com.ibm.cos.v2.core.interceptor.ExecutionAttributes;
import com.ibm.cos.v2.core.internal.util.MetricUtils;
import com.ibm.cos.v2.core.metrics.CoreMetric;
import com.ibm.cos.v2.core.signer.Signer;
import com.ibm.cos.v2.identity.spi.AwsCredentialsIdentity;
import com.ibm.cos.v2.identity.spi.IdentityProvider;
import com.ibm.cos.v2.metrics.MetricCollector;
import com.ibm.cos.v2.utils.CompletableFutureUtils;
import com.ibm.cos.v2.utils.Pair;
import com.ibm.cos.v2.utils.Validate;

/**
 * An authorization strategy for AWS Credentials that can resolve a compatible signer as
 * well as provide resolved AWS credentials as an execution attribute.
 *
 * @deprecated This is only used for compatibility with pre-SRA authorization logic. After we are comfortable that the new code
 * paths are working, we should migrate old clients to the new code paths (where possible) and delete this code.
 */
@Deprecated
@SdkInternalApi
public final class AwsCredentialsAuthorizationStrategy implements AuthorizationStrategy {

    private final SdkRequest request;
    private final Signer defaultSigner;
    private final IdentityProvider<? extends AwsCredentialsIdentity> defaultCredentialsProvider;
    private final MetricCollector metricCollector;

    public AwsCredentialsAuthorizationStrategy(Builder builder) {
        this.request = builder.request();
        this.defaultSigner = builder.defaultSigner();
        this.defaultCredentialsProvider = builder.defaultCredentialsProvider();
        this.metricCollector = builder.metricCollector();
    }

    public static Builder builder() {
        return new Builder();
    }

    /**
     * Request override signers take precedence over the default alternative, for instance what is specified in the
     * client. Request override signers can also be modified by modifyRequest interceptors.
     *
     * @return The signer that will be used by the SDK to sign the request
     *
     */
    @Override
    public Signer resolveSigner() {
        return request.overrideConfiguration()
                      .flatMap(RequestOverrideConfiguration::signer)
                      .orElse(defaultSigner);
    }

    /**
     * Add credentials to be used by the signer in later stages.
     */
    @Override
    public void addCredentialsToExecutionAttributes(ExecutionAttributes executionAttributes) {
        IdentityProvider<? extends AwsCredentialsIdentity> credentialsProvider =
            resolveCredentialsProvider(request, defaultCredentialsProvider);
        AwsCredentials credentials = CredentialUtils.toCredentials(resolveCredentials(credentialsProvider, metricCollector));
        executionAttributes.putAttribute(AwsSignerExecutionAttribute.AWS_CREDENTIALS, credentials);
        // TODO: A separate execution attribute is not strictly needed; this can be optimized before release
        executionAttributes.putAttribute(AwsExecutionAttribute.AWS_AUTH_ACCOUNT_ID, credentials.accountId().orElse(null));
    }

    /**
     * Resolves the credentials provider, with the request override configuration taking precedence over the
     * provided default.
     *
     * @return The credentials provider that will be used by the SDK to resolve credentials
     */
    private static IdentityProvider<? extends AwsCredentialsIdentity> resolveCredentialsProvider(
            SdkRequest originalRequest,
            IdentityProvider<? extends AwsCredentialsIdentity> defaultProvider) {
        return originalRequest.overrideConfiguration()
                              .filter(c -> c instanceof AwsRequestOverrideConfiguration)
                              .map(c -> (AwsRequestOverrideConfiguration) c)
                              .flatMap(AwsRequestOverrideConfiguration::credentialsIdentityProvider)
                              .orElse(defaultProvider);
    }

    private static AwsCredentialsIdentity resolveCredentials(
            IdentityProvider<? extends AwsCredentialsIdentity> credentialsProvider,
            MetricCollector metricCollector) {
        Validate.notNull(credentialsProvider, "No credentials provider exists to resolve credentials from.");

        // TODO(sra-identity-and-auth): internal issue SMITHY-1677. avoid join for async clients.
        Pair<? extends AwsCredentialsIdentity, Duration> measured =
            MetricUtils.measureDuration(() -> CompletableFutureUtils.joinLikeSync(credentialsProvider.resolveIdentity()));

        metricCollector.reportMetric(CoreMetric.CREDENTIALS_FETCH_DURATION, measured.right());
        AwsCredentialsIdentity credentials = measured.left();

        Validate.validState(credentials != null, "Credential providers must never return null.");
        return credentials;
    }

    public static final class Builder {
        private SdkRequest request;
        private Signer defaultSigner;
        private IdentityProvider<? extends AwsCredentialsIdentity> defaultCredentialsProvider;
        private MetricCollector metricCollector;

        private Builder() {
        }

        public SdkRequest request() {
            return this.request;
        }

        public Builder request(SdkRequest request) {
            this.request = request;
            return this;
        }

        public Signer defaultSigner() {
            return this.defaultSigner;
        }

        public Builder defaultSigner(Signer defaultSigner) {
            this.defaultSigner = defaultSigner;
            return this;
        }

        public IdentityProvider<? extends AwsCredentialsIdentity> defaultCredentialsProvider() {
            return this.defaultCredentialsProvider;
        }

        public Builder defaultCredentialsProvider(IdentityProvider<? extends AwsCredentialsIdentity> defaultCredentialsProvider) {
            this.defaultCredentialsProvider = defaultCredentialsProvider;
            return this;
        }

        public MetricCollector metricCollector() {
            return this.metricCollector;
        }

        public Builder metricCollector(MetricCollector metricCollector) {
            this.metricCollector = metricCollector;
            return this;
        }

        public AwsCredentialsAuthorizationStrategy build() {
            return new AwsCredentialsAuthorizationStrategy(this);
        }
    }
}
