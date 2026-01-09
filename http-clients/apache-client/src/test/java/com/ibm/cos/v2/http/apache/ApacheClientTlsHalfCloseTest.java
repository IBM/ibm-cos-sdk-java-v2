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

package com.ibm.cos.v2.http.apache;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIf;
import com.ibm.cos.v2.http.ContentStreamProvider;
import com.ibm.cos.v2.http.FileStoreTlsKeyManagersProvider;
import com.ibm.cos.v2.http.HttpExecuteRequest;
import com.ibm.cos.v2.http.HttpExecuteResponse;
import com.ibm.cos.v2.http.SdkHttpClient;
import com.ibm.cos.v2.http.SdkHttpFullRequest;
import com.ibm.cos.v2.http.SdkHttpMethod;
import com.ibm.cos.v2.http.SdkHttpRequest;
import com.ibm.cos.v2.http.TlsKeyManagersProvider;
import com.ibm.cos.v2.http.server.MockServer;

public class ApacheClientTlsHalfCloseTest extends ClientTlsAuthTestBase {

    private static TlsKeyManagersProvider tlsKeyManagersProvider;
    private static MockServer mockServer;
    private SdkHttpClient httpClient;

    private static final int TWO_MB = 2 * 1024 * 1024;
    private static final byte[] CONTENT = new byte[TWO_MB];

    @Test
    @EnabledIf("halfCloseSupported")
    public void errorWhenServerHalfClosesSocketWhileStreamIsOpened() {

        mockServer = MockServer.createMockServer(MockServer.ServerBehavior.HALF_CLOSE);
        mockServer.startServer(tlsKeyManagersProvider);

        httpClient = ApacheHttpClient.builder()
                                     .tlsKeyManagersProvider(tlsKeyManagersProvider)
                                     .build();
        IOException exception = assertThrows(IOException.class, () -> {
            executeHttpRequest(httpClient);
        });
        assertEquals("Remote end is closed.", exception.getMessage());
    }


    @Test
    public void errorWhenServerFullClosesSocketWhileStreamIsOpened() throws IOException {
        mockServer = MockServer.createMockServer(MockServer.ServerBehavior.FULL_CLOSE_IN_BETWEEN);
        mockServer.startServer(tlsKeyManagersProvider);

        httpClient = ApacheHttpClient.builder()
                                     .tlsKeyManagersProvider(tlsKeyManagersProvider)
                                     .build();

        IOException exception = assertThrows(IOException.class, () -> {
            executeHttpRequest(httpClient);
        });

        if(halfCloseSupported()){
            assertEquals("Remote end is closed.", exception.getMessage());

        }else {
            assertEquals("Socket is closed", exception.getMessage());

        }
    }

    @Test
    public void successfulRequestForFullCloseSocketAtTheEnd() throws IOException {
        mockServer = MockServer.createMockServer(MockServer.ServerBehavior.FULL_CLOSE_AT_THE_END);
        mockServer.startServer(tlsKeyManagersProvider);

        httpClient = ApacheHttpClient.builder()
                                     .tlsKeyManagersProvider(tlsKeyManagersProvider)
                                     .build();

        HttpExecuteResponse response = executeHttpRequest(httpClient);

        assertThat(response.httpResponse().isSuccessful()).isTrue();
    }

    @AfterEach
    void tearDown() {
        if (mockServer != null) {
            mockServer.stopServer();
        }
    }

    @BeforeAll
    public static void setUp() throws IOException {
        ClientTlsAuthTestBase.setUp();
        System.setProperty("javax.net.ssl.trustStore", serverKeyStore.toAbsolutePath().toString());
        System.setProperty("javax.net.ssl.trustStorePassword", STORE_PASSWORD);
        System.setProperty("javax.net.ssl.trustStoreType", "jks");
        tlsKeyManagersProvider = FileStoreTlsKeyManagersProvider.create(clientKeyStore, CLIENT_STORE_TYPE, STORE_PASSWORD);
    }

    @AfterAll
    public static void clear() throws IOException {
        System.clearProperty("javax.net.ssl.trustStore");
        System.clearProperty("javax.net.ssl.trustStorePassword");
        System.clearProperty("javax.net.ssl.trustStoreType");
        ClientTlsAuthTestBase.teardown();

    }

    private static HttpExecuteResponse executeHttpRequest(SdkHttpClient client) throws IOException {
        ContentStreamProvider contentStreamProvider = () -> new ByteArrayInputStream(CONTENT);
        SdkHttpRequest httpRequest = SdkHttpFullRequest.builder()
                                                       .method(SdkHttpMethod.PUT)
                                                       .protocol("https")
                                                       .host("localhost:" + mockServer.getPort())
                                                       .build();
        HttpExecuteRequest request = HttpExecuteRequest.builder()
                                                       .request(httpRequest)
                                                       .contentStreamProvider(contentStreamProvider)
                                                       .build();

        return client.prepareRequest(request).call();
    }

    public static boolean halfCloseSupported(){
        return MockServer.isTlsHalfCloseSupported();
    }
}