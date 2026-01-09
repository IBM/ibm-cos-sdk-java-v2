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

package com.ibm.cos.v2.nativeimagetest;

import com.ibm.cos.v2.auth.credentials.AwsCredentialsProviderChain;
import com.ibm.cos.v2.auth.credentials.DefaultCredentialsProvider;
import com.ibm.cos.v2.auth.credentials.ProfileCredentialsProvider;
import com.ibm.cos.v2.enhanced.dynamodb.DynamoDbEnhancedClient;
import com.ibm.cos.v2.http.apache.ApacheHttpClient;
import com.ibm.cos.v2.http.urlconnection.UrlConnectionHttpClient;
import com.ibm.cos.v2.metrics.LoggingMetricPublisher;
import com.ibm.cos.v2.regions.Region;
import com.ibm.cos.v2.services.dynamodb.DynamoDbClient;
import com.ibm.cos.v2.services.s3.S3AsyncClient;
import com.ibm.cos.v2.services.s3.S3Client;

/**
 * The module containing all dependencies required by the {@link App}.
 */
public class DependencyFactory {

    /** Default Properties Credentials file path. */
    private static final String TEST_CREDENTIALS_PROFILE_NAME = "aws-test-account";

    public static final AwsCredentialsProviderChain CREDENTIALS_PROVIDER_CHAIN =
        AwsCredentialsProviderChain.of(ProfileCredentialsProvider.builder()
                                                                 .profileName(TEST_CREDENTIALS_PROFILE_NAME)
                                                                 .build(),
                                       DefaultCredentialsProvider.create());

    private DependencyFactory() {
    }

    public static S3Client s3UrlConnectionHttpClient() {
        return S3Client.builder()
                       .credentialsProvider(CREDENTIALS_PROVIDER_CHAIN)
                       .httpClientBuilder(UrlConnectionHttpClient.builder())
                       .overrideConfiguration(o -> o.addMetricPublisher(LoggingMetricPublisher.create()))
                       .region(Region.US_WEST_2)
                       .build();
    }

    public static S3Client s3ApacheHttpClient() {
        return S3Client.builder()
                       .credentialsProvider(CREDENTIALS_PROVIDER_CHAIN)
                       .httpClientBuilder(ApacheHttpClient.builder())
                       .overrideConfiguration(o -> o.addMetricPublisher(LoggingMetricPublisher.create()))
                       .region(Region.US_WEST_2)
                       .build();
    }

    public static S3AsyncClient s3NettyClient() {
        return S3AsyncClient.builder()
                            .credentialsProvider(CREDENTIALS_PROVIDER_CHAIN)
                            .overrideConfiguration(o -> o.addMetricPublisher(LoggingMetricPublisher.create()))
                            .region(Region.US_WEST_2)
                            .build();
    }

    public static DynamoDbClient ddbClient() {
        return DynamoDbClient.builder()
                             .credentialsProvider(CREDENTIALS_PROVIDER_CHAIN)
                             .httpClientBuilder(ApacheHttpClient.builder())
                             .overrideConfiguration(o -> o.addMetricPublisher(LoggingMetricPublisher.create()))
                             .region(Region.US_WEST_2)
                             .build();
    }

    public static DynamoDbEnhancedClient enhancedClient(DynamoDbClient ddbClient) {
        return DynamoDbEnhancedClient.builder()
                                     .dynamoDbClient(ddbClient)
                                     .build();

    }
}
