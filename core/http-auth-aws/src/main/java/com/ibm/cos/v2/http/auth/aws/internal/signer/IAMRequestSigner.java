/*
 * Copyright 2017 IBM Corp. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */

package com.ibm.cos.v2.http.auth.aws.internal.signer;

import com.ibm.cos.v2.SDKGlobalConfiguration;
import com.ibm.cos.v2.annotations.SdkPublicApi;
import com.ibm.cos.v2.http.SdkHttpRequest;
import com.ibm.cos.v2.http.auth.aws.internal.signer.util.SignerConstant;
import com.ibm.cos.v2.identity.spi.internal.IBMOAuthIdentity;
import com.ibm.cos.v2.utils.Logger;
import com.ibm.cloud.sdk.core.security.IamAuthenticator;

@SdkPublicApi
public class IAMRequestSigner {
    private static final Logger LOG = Logger.loggerFor(IAMRequestSigner.class);

    public V4RequestSigningResult sign(SdkHttpRequest.Builder requestBuilder , IBMOAuthIdentity iamIdentity){
        String iamToken = iamIdentity.getIAMToken();
        LOG.debug(() -> "OAuth Signer");
        //generate token
        if (iamToken == null || iamToken == "") {
            IamAuthenticator authenticator;
            authenticator = new IamAuthenticator.Builder()
                .apikey(iamIdentity.apiKey())
                .url(SDKGlobalConfiguration.IAM_ENDPOINT)
                .disableSSLVerification(true)
                .build();

                authenticator.validate();

                iamToken = authenticator.requestToken().getAccessToken();

                iamIdentity.setIAMToken(iamToken);
        }
        requestBuilder.putHeader(SignerConstant.AUTHORIZATION,"Bearer " + iamToken);
        // Check if the header is already added via request, then do not override the value in signer
        if (!requestBuilder.headers().containsKey(SignerConstant.IBM_SERVICE_INSTANCE_ID)) {
            requestBuilder.putHeader(SignerConstant.IBM_SERVICE_INSTANCE_ID, iamIdentity.serviceInstanceId());
        }

        byte[] DUMMY_SIGNING_KEY = new byte[]{0x00};
        V4RequestSigningResult requestSigningResult = new V4RequestSigningResult(null, DUMMY_SIGNING_KEY, null, null,
                                                                                 requestBuilder);
        return requestSigningResult;
    }

}
