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

package com.ibm.cos.v2.services.sts.auth;

import com.ibm.cos.v2.services.sts.StsClient;
import com.ibm.cos.v2.services.sts.auth.StsGetSessionTokenCredentialsProvider.Builder;
import com.ibm.cos.v2.services.sts.model.AssumedRoleUser;
import com.ibm.cos.v2.services.sts.model.Credentials;
import com.ibm.cos.v2.services.sts.model.GetSessionTokenRequest;
import com.ibm.cos.v2.services.sts.model.GetSessionTokenResponse;

/**
 * Validate the functionality of {@link StsGetSessionTokenCredentialsProvider}.
 * Inherits tests from {@link StsCredentialsProviderTestBase}.
 */
public class StsGetSessionTokenCredentialsProviderTest
        extends StsCredentialsProviderTestBase<GetSessionTokenRequest, GetSessionTokenResponse> {
    @Override
    protected GetSessionTokenRequest getRequest() {
        return GetSessionTokenRequest.builder().build();
    }

    @Override
    protected GetSessionTokenResponse getResponse(Credentials credentials) {
        return GetSessionTokenResponse.builder()
                                      .credentials(credentials)
                                      .build();
    }

    @Override
    protected Builder createCredentialsProviderBuilder(GetSessionTokenRequest request) {
        return StsGetSessionTokenCredentialsProvider.builder().refreshRequest(request);
    }

    @Override
    protected GetSessionTokenResponse callClient(StsClient client, GetSessionTokenRequest request) {
        return client.getSessionToken(request);
    }

    @Override
    protected String providerName() {
        return "StsGetSessionTokenCredentialsProvider";
    }
}
