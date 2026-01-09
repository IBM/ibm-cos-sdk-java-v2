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

package com.ibm.cos.v2.http.crt;

import java.io.IOException;
import java.util.concurrent.ExecutionException;
import com.ibm.cos.v2.http.SdkHttpClient;
import com.ibm.cos.v2.http.async.SdkAsyncHttpClient;
import com.ibm.cos.v2.http.proxy.HttpClientDefaultProxyConfigTestSuite;

public class AsyncCrtClientProxyConfigurationTest extends HttpClientDefaultProxyConfigTestSuite {
    @Override
    protected Class<? extends Exception> getProxyFailedExceptionType() {
        return ExecutionException.class;
    }

    @Override
    protected Class<? extends Exception> getProxyFailedCauseExceptionType() {
        return IOException.class;
    }

    @Override
    protected boolean isSyncClient() {
        return false;
    }

    @Override
    protected SdkAsyncHttpClient createHttpClientWithDefaultProxy() {
        return AwsCrtAsyncHttpClient.create();
    }

    @Override
    protected SdkHttpClient createSyncHttpClientWithDefaultProxy() {
        throw new IllegalArgumentException("Sync client is not supported for this test.");
    }
}
