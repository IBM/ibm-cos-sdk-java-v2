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

package com.ibm.cos.v2.http.auth.aws.internal.signer.util;

import com.ibm.cos.v2.annotations.SdkInternalApi;
import com.ibm.cos.v2.identity.spi.AwsCredentialsIdentity;
import com.ibm.cos.v2.identity.spi.AwsSessionCredentialsIdentity;
import com.ibm.cos.v2.identity.spi.Identity;
import com.ibm.cos.v2.identity.spi.internal.IBMOAuthIdentity;
import com.ibm.cos.v2.utils.StringUtils;

@SdkInternalApi
public final class CredentialUtils {

    private CredentialUtils() {
    }

    /**
     * Determine whether the provided credentials are anonymous credentials, indicating that the customer is not attempting to
     * authenticate themselves.
     */
    public static boolean isAnonymous(Identity credentials) {
        if(credentials instanceof IBMOAuthIdentity){
            return ((IBMOAuthIdentity)credentials).serviceInstanceId() == null
                && ((IBMOAuthIdentity)credentials).getIAMToken() == null;
        }
        return ((AwsCredentialsIdentity) credentials).secretAccessKey() == null
                   && ((AwsCredentialsIdentity) credentials).accessKeyId() == null;
    }

    /**
     * Sanitize given AWS credentials by trimming whitespace
     */
    public static AwsCredentialsIdentity sanitizeCredentials(AwsCredentialsIdentity credentials) {
        String accessKeyId = StringUtils.trim(credentials.accessKeyId());
        String secretKey = StringUtils.trim(credentials.secretAccessKey());

        if (credentials instanceof AwsSessionCredentialsIdentity) {
            AwsSessionCredentialsIdentity sessionCredentials = (AwsSessionCredentialsIdentity) credentials;
            return AwsSessionCredentialsIdentity.create(accessKeyId,
                                                        secretKey,
                                                        StringUtils.trim(sessionCredentials.sessionToken()));
        }

        // given credentials are anonymous, so don't create new instance
        if (accessKeyId == null && secretKey == null) {
            return credentials;
        }

        return AwsCredentialsIdentity.create(accessKeyId, secretKey);
    }

    /**
     * Sanitize given IAM credentials by trimming whitespace
     */
    public static IBMOAuthIdentity sanitizeCredentialsIAM(IBMOAuthIdentity credentials) {
        String apikey = StringUtils.trim(credentials.apiKey());
        String serviceInstanceId = StringUtils.trim(credentials.serviceInstanceId());

        // given credentials are anonymous, so don't create new instance
        if (apikey== null && serviceInstanceId == null) {
            return credentials;
        }

        return IBMOAuthIdentity.create(apikey,serviceInstanceId);
    }
}
