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

package com.ibm.cos.v2.core.internal.waiters;

import java.time.Duration;
import java.util.Optional;
import com.ibm.cos.v2.annotations.SdkInternalApi;
import com.ibm.cos.v2.core.waiters.WaiterOverrideConfiguration;
import com.ibm.cos.v2.retries.api.BackoffStrategy;

/**
 * Internal waiter configuration class that provides default values if not overridden.
 */
@SdkInternalApi
public final class WaiterConfiguration {
    private static final int DEFAULT_MAX_ATTEMPTS = 3;
    private static final BackoffStrategy DEFAULT_BACKOFF_STRATEGY =
        BackoffStrategy.fixedDelayWithoutJitter(Duration.ofSeconds(5));
    private final Integer maxAttempts;
    private final BackoffStrategy backoffStrategy;
    private final Duration waitTimeout;

    public WaiterConfiguration(WaiterOverrideConfiguration overrideConfiguration) {
        Optional<WaiterOverrideConfiguration> configuration = Optional.ofNullable(overrideConfiguration);
        this.backoffStrategy =
            configuration.flatMap(WaiterOverrideConfiguration::backoffStrategyV2).orElse(DEFAULT_BACKOFF_STRATEGY);
        this.waitTimeout = configuration.flatMap(WaiterOverrideConfiguration::waitTimeout).orElse(null);
        this.maxAttempts = configuration.flatMap(WaiterOverrideConfiguration::maxAttempts).orElse(DEFAULT_MAX_ATTEMPTS);
    }

    public Duration waitTimeout() {
        return waitTimeout;
    }

    public BackoffStrategy backoffStrategy() {
        return backoffStrategy;
    }

    public int maxAttempts() {
        return maxAttempts;
    }
}
