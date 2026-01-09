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

@SdkInternalApi
public interface TimeoutTask extends Runnable {

    /**
     * @param abortable the abortable request
     */
    default void abortable(Abortable abortable) {
    }

    default void cancel() {
    }

    /**
     * @return True if timeout task has executed. False otherwise
     */
    boolean hasExecuted();
}
