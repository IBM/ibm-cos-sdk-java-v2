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

package com.ibm.cos.v2.core.internal.http.timers;

import com.ibm.cos.v2.annotations.SdkInternalApi;
import com.ibm.cos.v2.http.Abortable;

/**
 * A no op implementation of {@link TimeoutTracker}.
 */
@SdkInternalApi
public final class NoOpTimeoutTracker implements TimeoutTracker {

    public static final NoOpTimeoutTracker INSTANCE = new NoOpTimeoutTracker();

    private NoOpTimeoutTracker() {
    }

    @Override
    public boolean hasExecuted() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

    @Override
    public void cancel() {

    }

    @Override
    public void abortable(Abortable abortable) {

    }
}
