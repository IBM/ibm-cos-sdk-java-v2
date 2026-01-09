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

package com.ibm.cos.v2.services.sts.internal;

import com.ibm.cos.v2.annotations.SdkInternalApi;
import com.ibm.cos.v2.auth.credentials.AwsSessionCredentials;
import com.ibm.cos.v2.services.sts.endpoints.internal.Arn;
import com.ibm.cos.v2.services.sts.model.AssumedRoleUser;
import com.ibm.cos.v2.services.sts.model.Credentials;

@SdkInternalApi
public final class StsAuthUtils {

    private StsAuthUtils() {
    }

    public static String accountIdFromArn(AssumedRoleUser assumedRoleUser) {
        if (assumedRoleUser == null) {
            return null;
        }
        return Arn.parse(assumedRoleUser.arn())
                  .map(Arn::accountId)
                  .orElse(null);
    }

    public static AwsSessionCredentials fromStsCredentials(Credentials credentials, String provider) {
        return fromStsCredentials(credentials, provider, null);
    }

    public static AwsSessionCredentials fromStsCredentials(Credentials credentials, String provider, String accountId) {
        return AwsSessionCredentials.builder()
                                    .accessKeyId(credentials.accessKeyId())
                                    .secretAccessKey(credentials.secretAccessKey())
                                    .sessionToken(credentials.sessionToken())
                                    .expirationTime(credentials.expiration())
                                    .providerName(provider)
                                    .accountId(accountId)
                                    .build();
    }
}
