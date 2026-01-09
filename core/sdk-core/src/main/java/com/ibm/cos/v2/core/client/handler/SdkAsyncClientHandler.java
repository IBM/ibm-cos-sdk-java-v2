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

package com.ibm.cos.v2.core.client.handler;

import com.ibm.cos.v2.annotations.Immutable;
import com.ibm.cos.v2.annotations.SdkProtectedApi;
import com.ibm.cos.v2.annotations.ThreadSafe;
import com.ibm.cos.v2.core.client.config.SdkClientConfiguration;
import com.ibm.cos.v2.core.client.config.SdkClientOptionValidation;
import com.ibm.cos.v2.core.internal.handler.BaseAsyncClientHandler;
import com.ibm.cos.v2.core.internal.http.AmazonAsyncHttpClient;

/**
 * Default implementation of {@link AsyncClientHandler}.
 */
@Immutable
@ThreadSafe
@SdkProtectedApi
public class SdkAsyncClientHandler extends BaseAsyncClientHandler implements AsyncClientHandler {

    public SdkAsyncClientHandler(SdkClientConfiguration clientConfiguration) {
        super(clientConfiguration, new AmazonAsyncHttpClient(clientConfiguration));
        SdkClientOptionValidation.validateAsyncClientOptions(clientConfiguration);
    }
}
