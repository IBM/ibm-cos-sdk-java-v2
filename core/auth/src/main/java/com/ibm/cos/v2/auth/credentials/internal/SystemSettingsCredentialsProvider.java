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

package com.ibm.cos.v2.auth.credentials.internal;

import static com.ibm.cos.v2.utils.StringUtils.trim;

import com.ibm.cos.v2.SDKGlobalConfiguration;
import com.ibm.cos.v2.auth.credentials.ibmOAuth.BasicIBMOAuthCredentials;
import com.ibm.cos.v2.core.SdkSystemSetting;
import com.ibm.cos.v2.core.exception.SdkClientException;
import java.util.Optional;
import com.ibm.cos.v2.annotations.SdkInternalApi;
import com.ibm.cos.v2.auth.credentials.AwsBasicCredentials;
import com.ibm.cos.v2.auth.credentials.AwsCredentials;
import com.ibm.cos.v2.auth.credentials.AwsCredentialsProvider;
import com.ibm.cos.v2.auth.credentials.AwsSessionCredentials;
import com.ibm.cos.v2.auth.credentials.EnvironmentVariableCredentialsProvider;
import com.ibm.cos.v2.auth.credentials.SystemPropertyCredentialsProvider;
//import com.ibm.cos.v2.core.SdkSystemSetting;
//import com.ibm.cos.v2.core.exception.SdkClientException;
import com.ibm.cos.v2.utils.StringUtils;
import com.ibm.cos.v2.utils.SystemSetting;
import java.util.stream.Stream;

/**
 * Loads credentials providers from the {@link //SdkSystemSetting#AWS_ACCESS_KEY_ID},
 * {@link //SdkSystemSetting#AWS_SECRET_ACCESS_KEY}, and {@link //SdkSystemSetting#AWS_SESSION_TOKEN} system settings.
 * {@link //SdkSystemSetting#IBM_API_KEY_ID}, and {@link //SdkSystemSetting#IBM_SERVICE_INSTANCE_ID} system settings.
 *
 * This does not load the credentials directly. Instead, the actual mapping of setting to credentials is done by child classes.
 * This allows us to separately load the credentials from system properties and environment variables so that customers can
 * remove one or the other from their credential chain, or build a different chain with these pieces of functionality separated.
 *
 * @see EnvironmentVariableCredentialsProvider
 * @see SystemPropertyCredentialsProvider
 */
@SdkInternalApi
public abstract class SystemSettingsCredentialsProvider implements AwsCredentialsProvider {


    @Override
    public AwsCredentials resolveCredentials() {
        String accessKey = trim(loadSetting(SdkSystemSetting.AWS_ACCESS_KEY_ID).orElse(null));
        String secretKey = trim(loadSetting(SdkSystemSetting.AWS_SECRET_ACCESS_KEY).orElse(null));
        String sessionToken = trim(loadSetting(SdkSystemSetting.AWS_SESSION_TOKEN).orElse(null));
        String accountId = trim(loadSetting(SdkSystemSetting.AWS_ACCOUNT_ID).orElse(null));

        String ibmApiKey = trim(loadSetting(SdkSystemSetting.IBM_API_KEY_ID).orElse(null));
        String serviceInstanceId = trim(loadSetting(SdkSystemSetting.IBM_SERVICE_INSTANCE_ID).orElse(null));

        // --- IAM Credentials ---
        if (Stream.of(ibmApiKey, serviceInstanceId).allMatch(StringUtils::isNotBlank)) {
            return new BasicIBMOAuthCredentials(ibmApiKey,serviceInstanceId);
        }

        // --- HMAC with Session Token ---
        if (Stream.of(accessKey, secretKey, sessionToken).allMatch(StringUtils::isNotBlank)) {
            return AwsSessionCredentials.builder()
                                        .accessKeyId(accessKey)
                                        .secretAccessKey(secretKey)
                                        .sessionToken(sessionToken)
                                        .accountId(accountId)
                                        .providerName(provider())
                                        .build();
        }

        // --- HMAC without Session Token ---
        if (Stream.of(accessKey,secretKey).allMatch(StringUtils::isNotBlank)) {
            return AwsBasicCredentials.builder()
                                      .accessKeyId(accessKey)
                                      .secretAccessKey(secretKey)
                                      .accountId(accountId)
                                      .providerName(provider())
                                      .build();
        }

        // --- If nothing is found ---
        throw SdkClientException.builder()
                                .message(String.format(
                                    "Unable to load credentials from system settings. Please provide either HMAC (access/secret key) " +
                                    "or IAM (API key + service instance ID) either via \n"
                                    + " environment variable for HMAC (%s, %s) \n"
                                    + " environment variable for IAM (%s, %s) \n"
                                    + " or \n"
                                    + " system property for HMAC (%s, %s) \n"
                                    + " system property for IAM (%s, %s).",
                                    SdkSystemSetting.AWS_ACCESS_KEY_ID.environmentVariable(),
                                    SdkSystemSetting.AWS_SECRET_ACCESS_KEY.environmentVariable(),
                                    SdkSystemSetting.IBM_API_KEY_ID.environmentVariable(),
                                    SdkSystemSetting.IBM_SERVICE_INSTANCE_ID.environmentVariable(),
                                    SdkSystemSetting.AWS_ACCESS_KEY_ID.property(),
                                    SdkSystemSetting.AWS_SECRET_ACCESS_KEY.property(),
                                    SdkSystemSetting.IBM_API_KEY_ID.property(),
                                    SdkSystemSetting.IBM_SERVICE_INSTANCE_ID.property()
                                ))
                                .build();
    }

    /**
     * Implemented by child classes to load the requested setting.
     */
    protected abstract Optional<String> loadSetting(SystemSetting setting);

    protected abstract String provider();
}
