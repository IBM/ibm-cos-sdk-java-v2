/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"). You may not use this file except in compliance with
 * the License. A copy of the License is located at
 * 
 * http://aws.amazon.com/apache2.0
 * 
 * or in the "license" file accompanying this file. This file is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR
 * CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions
 * and limitations under the License.
 */

package com.ibm.cos.v2.services.s3.waiters.internal;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import com.ibm.cos.v2.annotations.Generated;
import com.ibm.cos.v2.annotations.SdkInternalApi;

import com.ibm.cos.v2.core.SdkResponse;

import com.ibm.cos.v2.core.exception.SdkServiceException;
import com.ibm.cos.v2.core.waiters.WaiterAcceptor;
import com.ibm.cos.v2.core.waiters.WaiterState;

/**
 * Contains classes used at runtime by the code generator classes for waiter acceptors generated from JMESPath
 * expressions.
 */
@Generated("com.ibm.cos.v2:codegen")
@SdkInternalApi
public final class WaitersRuntime {

    private static final String FAILURE_MESSAGE_FORMAT_FOR_STATUS_MATCHER = "A waiter acceptor was matched on HTTP response "
            + "status code (%d) and transitioned the waiter to " + "failure state";
    /**
     * The default acceptors that should be matched *last* in the list of acceptors used by the SDK client waiters.
     */
    public static final List<WaiterAcceptor<Object>> DEFAULT_ACCEPTORS = Collections.unmodifiableList(defaultAcceptors());

    private WaitersRuntime() {
    }

    private static List<WaiterAcceptor<Object>> defaultAcceptors() {
        return Collections.singletonList(retryOnUnmatchedResponseWaiter());
    }

    private static WaiterAcceptor<Object> retryOnUnmatchedResponseWaiter() {
        return WaiterAcceptor.retryOnResponseAcceptor(r -> true);
    }

    /**
     * A {@link WaiterAcceptor} implementation that checks for a specific HTTP response status, regardless of whether
     * it's reported by a response or an exception.
     */
    public static final class ResponseStatusAcceptor implements WaiterAcceptor<SdkResponse> {
        private final int statusCode;
        private final WaiterState waiterState;

        public ResponseStatusAcceptor(int statusCode, WaiterState waiterState) {
            this.statusCode = statusCode;
            this.waiterState = waiterState;
        }

        @Override
        public WaiterState waiterState() {
            return waiterState;
        }

        @Override
        public boolean matches(SdkResponse response) {
            return response.sdkHttpResponse() != null && response.sdkHttpResponse().statusCode() == statusCode;
        }

        @Override
        public boolean matches(Throwable throwable) {
            if (throwable instanceof SdkServiceException) {
                return ((SdkServiceException) throwable).statusCode() == statusCode;
            }

            return false;
        }

        @Override
        public Optional<String> message() {
            return waiterState == WaiterState.FAILURE ? Optional.of(String.format(FAILURE_MESSAGE_FORMAT_FOR_STATUS_MATCHER,
                    statusCode)) : Optional.empty();
        }
    }
}
