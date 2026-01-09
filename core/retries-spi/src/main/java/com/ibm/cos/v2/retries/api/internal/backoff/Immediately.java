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

package com.ibm.cos.v2.retries.api.internal.backoff;

import java.time.Duration;
import com.ibm.cos.v2.annotations.SdkInternalApi;
import com.ibm.cos.v2.retries.api.BackoffStrategy;
import com.ibm.cos.v2.utils.Validate;

/**
 * Strategy that do not back off: retry immediately.
 */
@SdkInternalApi
public final class Immediately implements BackoffStrategy {
    @Override
    public Duration computeDelay(int attempt) {
        Validate.isPositive(attempt, "attempt");
        return Duration.ZERO;
    }

    @Override
    public String toString() {
        return "(Immediately)";
    }
}
