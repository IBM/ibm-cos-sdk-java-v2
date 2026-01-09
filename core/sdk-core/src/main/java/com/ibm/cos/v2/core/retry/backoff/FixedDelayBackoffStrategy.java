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

package com.ibm.cos.v2.core.retry.backoff;

import static com.ibm.cos.v2.utils.Validate.isNotNegative;

import java.time.Duration;
import com.ibm.cos.v2.annotations.SdkPublicApi;
import com.ibm.cos.v2.core.retry.RetryPolicyContext;
import com.ibm.cos.v2.utils.ToString;

/**
 * Simple backoff strategy that always uses a fixed delay for the delay before the next retry attempt.
 *
 * @deprecated Use instead {@link com.ibm.cos.v2.retries.api.BackoffStrategy} and
 * {@link com.ibm.cos.v2.retries.api.BackoffStrategy#fixedDelay(Duration)}.
 */
@SdkPublicApi
@Deprecated
public final class FixedDelayBackoffStrategy implements BackoffStrategy {

    private final Duration fixedBackoff;

    private FixedDelayBackoffStrategy(Duration fixedBackoff) {
        this.fixedBackoff = isNotNegative(fixedBackoff, "fixedBackoff");
    }

    @Override
    public Duration computeDelayBeforeNextRetry(RetryPolicyContext context) {
        return fixedBackoff;
    }

    public static FixedDelayBackoffStrategy create(Duration fixedBackoff) {
        return new FixedDelayBackoffStrategy(fixedBackoff);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        FixedDelayBackoffStrategy that = (FixedDelayBackoffStrategy) o;

        return fixedBackoff.equals(that.fixedBackoff);
    }

    @Override
    public int hashCode() {
        return fixedBackoff.hashCode();
    }

    @Override
    public String toString() {
        return ToString.builder("FixedDelayBackoffStrategy")
                       .add("fixedBackoff", fixedBackoff)
                       .build();
    }
}
