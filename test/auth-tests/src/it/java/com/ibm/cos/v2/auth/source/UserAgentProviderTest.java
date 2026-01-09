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

package com.ibm.cos.v2.auth.source;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import com.ibm.cos.v2.auth.credentials.AwsBasicCredentials;
import com.ibm.cos.v2.auth.credentials.AwsCredentials;
import com.ibm.cos.v2.auth.credentials.AwsSessionCredentials;
import com.ibm.cos.v2.auth.credentials.StaticCredentialsProvider;
import com.ibm.cos.v2.http.AbortableInputStream;
import com.ibm.cos.v2.http.HttpExecuteResponse;
import com.ibm.cos.v2.http.SdkHttpClient;
import com.ibm.cos.v2.http.SdkHttpRequest;
import com.ibm.cos.v2.http.SdkHttpResponse;
import com.ibm.cos.v2.identity.spi.AwsCredentialsIdentity;
import com.ibm.cos.v2.identity.spi.IdentityProvider;
import com.ibm.cos.v2.services.sts.StsClient;
import com.ibm.cos.v2.testutils.service.http.MockSyncHttpClient;
import com.ibm.cos.v2.utils.StringInputStream;

class UserAgentProviderTest {
    private static final AwsCredentials BASIC_IDENTITY = basicCredentialsBuilder().build();
    private static final AwsCredentials SESSION_IDENTITY = sessionCredentialsBuilder().build();

    private MockSyncHttpClient mockHttpClient;

    @BeforeEach
    public void setup() throws UnsupportedEncodingException {
        mockHttpClient = new MockSyncHttpClient();
        mockHttpClient.stubNextResponse(mockResponse());
    }

    public static HttpExecuteResponse mockResponse() {
        return HttpExecuteResponse.builder()
                                  .response(SdkHttpResponse.builder().statusCode(200).build())
                                  .responseBody(AbortableInputStream.create(new StringInputStream("")))
                                  .build();
    }

    @ParameterizedTest
    @MethodSource("credentialProviders")
    void userAgentString_containsCredentialProviderNames_IfPresent(IdentityProvider<? extends AwsCredentialsIdentity> provider,
                                                                   String expected) throws Exception {
        stsClient(provider, mockHttpClient).getCallerIdentity();

        SdkHttpRequest lastRequest = mockHttpClient.getLastRequest();
        assertThat(lastRequest).isNotNull();

        List<String> userAgentHeaders = lastRequest.headers().get("User-Agent");
        assertThat(userAgentHeaders).isNotNull().hasSize(1);
        assertThat(userAgentHeaders.get(0)).contains(expected);
    }

    private static Stream<Arguments> credentialProviders() {
        return Stream.of(
            Arguments.of(StaticCredentialsProvider.create(SESSION_IDENTITY), "stat"),
            Arguments.of(StaticCredentialsProvider.create(BASIC_IDENTITY), "stat")
        );
    }

    private static StsClient stsClient(IdentityProvider<? extends AwsCredentialsIdentity> provider, SdkHttpClient httpClient) {
        return StsClient.builder()
                        .credentialsProvider(provider)
                        .httpClient(httpClient)
                        .build();
    }

    private static AwsSessionCredentials.Builder sessionCredentialsBuilder() {
        return AwsSessionCredentials.builder()
                                    .accessKeyId("akid")
                                    .secretAccessKey("secret")
                                    .sessionToken("token");
    }

    private static AwsBasicCredentials.Builder basicCredentialsBuilder() {
        return AwsBasicCredentials.builder()
                                  .accessKeyId("akid")
                                  .secretAccessKey("secret");
    }
}
