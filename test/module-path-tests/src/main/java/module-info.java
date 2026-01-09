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

module com.ibm.cos.v2.modulepath.tests {
    requires com.ibm.cos.v2.regions;
    requires com.ibm.cos.v2.http.urlconnection;
    requires com.ibm.cos.v2.http.apache;
    requires com.ibm.cos.v2.http.nio.netty;
    requires com.ibm.cos.v2.http;
    requires com.ibm.cos.v2.core;
    requires com.ibm.cos.v2.awscore;
    requires com.ibm.cos.v2.auth;
    requires com.ibm.cos.v2.services.s3;
    requires com.ibm.cos.v2.protocol.tests;
    requires org.reactivestreams;
    requires com.ibm.cos.v2.utils;
    requires com.ibm.cos.v2.testutils.service;

    requires org.slf4j;
    requires slf4j.simple;
}
