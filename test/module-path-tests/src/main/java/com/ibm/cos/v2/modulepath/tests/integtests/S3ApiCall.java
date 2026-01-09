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

package com.ibm.cos.v2.modulepath.tests.integtests;

import com.ibm.cos.v2.http.apache.ApacheHttpClient;
import com.ibm.cos.v2.http.nio.netty.NettyNioAsyncHttpClient;
import com.ibm.cos.v2.http.urlconnection.UrlConnectionHttpClient;
import com.ibm.cos.v2.regions.Region;
import com.ibm.cos.v2.services.s3.S3AsyncClient;
import com.ibm.cos.v2.services.s3.S3Client;

public class S3ApiCall extends BaseApiCall {

    private S3Client s3Client = S3Client.builder()
                                        .region(Region.US_WEST_2)
                                        .httpClient(ApacheHttpClient.builder().build())
                                        .credentialsProvider(CREDENTIALS_PROVIDER_CHAIN)
                                        .build();

    private S3Client s3ClientWithHttpUrlConnection = S3Client.builder()
                                                             .region(Region.US_WEST_2)
                                                             .httpClient(UrlConnectionHttpClient.builder().build())
                                                             .credentialsProvider(CREDENTIALS_PROVIDER_CHAIN).build();

    private S3AsyncClient s3ClientWithNettyClient = S3AsyncClient.builder()
                                                                 .region(Region.US_WEST_2)
                                                                 .httpClient(NettyNioAsyncHttpClient.builder().build())
                                                                 .credentialsProvider(CREDENTIALS_PROVIDER_CHAIN).build();

    public S3ApiCall() {
        super("s3");
    }

    @Override
    public Runnable apacheClientRunnable() {
        return () -> s3Client.listBuckets();
    }

    @Override
    public Runnable urlHttpConnectionClientRunnable() {
        return () -> s3ClientWithHttpUrlConnection.listBuckets();
    }

    @Override
    public Runnable nettyClientRunnable() {
        return () -> s3ClientWithNettyClient.listBuckets().join();
    }
}
