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

package com.ibm.cos.v2.retries.internal;

import java.time.Duration;
import java.util.function.Predicate;
import com.ibm.cos.v2.annotations.SdkInternalApi;
import com.ibm.cos.v2.retries.AdaptiveRetryStrategy;
import com.ibm.cos.v2.retries.api.AcquireInitialTokenRequest;
import com.ibm.cos.v2.retries.api.BackoffStrategy;
import com.ibm.cos.v2.retries.api.RefreshRetryTokenRequest;
import com.ibm.cos.v2.retries.internal.circuitbreaker.TokenBucketStore;
import com.ibm.cos.v2.retries.internal.ratelimiter.RateLimiterTokenBucket;
import com.ibm.cos.v2.retries.internal.ratelimiter.RateLimiterTokenBucketStore;
import com.ibm.cos.v2.utils.Logger;
import com.ibm.cos.v2.utils.Validate;

@SdkInternalApi
public final class DefaultAdaptiveRetryStrategy
    extends BaseRetryStrategy implements AdaptiveRetryStrategy {

    private static final Logger LOG = Logger.loggerFor(DefaultAdaptiveRetryStrategy.class);
    private final RateLimiterTokenBucketStore rateLimiterTokenBucketStore;

    DefaultAdaptiveRetryStrategy(Builder builder) {
        super(LOG, builder);
        this.rateLimiterTokenBucketStore = Validate.paramNotNull(builder.rateLimiterTokenBucketStore,
                                                                 "rateLimiterTokenBucketStore");
    }

    @Override
    protected Duration computeInitialBackoff(AcquireInitialTokenRequest request) {
        RateLimiterTokenBucket bucket = rateLimiterTokenBucketStore.tokenBucketForScope(request.scope());
        return bucket.tryAcquire().delay();
    }

    @Override
    protected Duration computeBackoff(RefreshRetryTokenRequest request, DefaultRetryToken token) {
        Duration backoff = super.computeBackoff(request, token);
        RateLimiterTokenBucket bucket = rateLimiterTokenBucketStore.tokenBucketForScope(token.scope());
        return backoff.plus(bucket.tryAcquire().delay());
    }

    @Override
    protected void updateStateForRetry(RefreshRetryTokenRequest request) {
        if (treatAsThrottling.test(request.failure())) {
            DefaultRetryToken token = asDefaultRetryToken(request.token());
            RateLimiterTokenBucket bucket = rateLimiterTokenBucketStore.tokenBucketForScope(token.scope());
            bucket.updateRateAfterThrottling();
        }
    }

    @Override
    protected void updateStateForSuccess(DefaultRetryToken token) {
        RateLimiterTokenBucket bucket = rateLimiterTokenBucketStore.tokenBucketForScope(token.scope());
        bucket.updateRateAfterSuccess();
    }

    @Override
    public Builder toBuilder() {
        return new Builder(this);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder extends BaseRetryStrategy.Builder implements AdaptiveRetryStrategy.Builder {
        private RateLimiterTokenBucketStore rateLimiterTokenBucketStore;

        Builder() {
        }

        Builder(DefaultAdaptiveRetryStrategy strategy) {
            super(strategy);
            this.rateLimiterTokenBucketStore = strategy.rateLimiterTokenBucketStore;
        }

        @Override
        public Builder retryOnException(Predicate<Throwable> shouldRetry) {
            setRetryOnException(shouldRetry);
            return this;
        }

        @Override
        public Builder maxAttempts(int maxAttempts) {
            setMaxAttempts(maxAttempts);
            return this;
        }

        @Override
        public Builder treatAsThrottling(Predicate<Throwable> treatAsThrottling) {
            setTreatAsThrottling(treatAsThrottling);
            return this;
        }

        @Override
        public Builder backoffStrategy(BackoffStrategy backoffStrategy) {
            setBackoffStrategy(backoffStrategy);
            return this;
        }

        @Override
        public Builder throttlingBackoffStrategy(BackoffStrategy backoffStrategy) {
            setThrottlingBackoffStrategy(backoffStrategy);
            return this;
        }

        public Builder circuitBreakerEnabled(Boolean circuitBreakerEnabled) {
            setCircuitBreakerEnabled(circuitBreakerEnabled);
            return this;
        }

        public Builder tokenBucketExceptionCost(int exceptionCost) {
            setTokenBucketExceptionCost(exceptionCost);
            return this;
        }

        public Builder rateLimiterTokenBucketStore(RateLimiterTokenBucketStore rateLimiterTokenBucketStore) {
            this.rateLimiterTokenBucketStore = rateLimiterTokenBucketStore;
            return this;
        }

        public Builder tokenBucketStore(TokenBucketStore tokenBucketStore) {
            setTokenBucketStore(tokenBucketStore);
            return this;
        }

        @Override
        public Builder useClientDefaults(boolean useClientDefaults) {
            setUseClientDefaults(useClientDefaults);
            return this;
        }

        @Override
        public AdaptiveRetryStrategy build() {
            return new DefaultAdaptiveRetryStrategy(this);
        }
    }
}
