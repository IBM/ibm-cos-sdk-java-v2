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

import static com.ibm.cos.v2.utils.DependencyValidate.requireClass;

import java.time.Clock;
import com.ibm.cos.v2.annotations.SdkInternalApi;
import com.ibm.cos.v2.http.auth.aws.crt.internal.signer.DefaultAwsCrtV4aHttpSigner;
import com.ibm.cos.v2.http.auth.aws.eventstream.internal.signer.EventStreamV4PayloadSigner;
import com.ibm.cos.v2.http.auth.aws.internal.signer.CredentialScope;
import com.ibm.cos.v2.identity.spi.AwsCredentialsIdentity;
import com.ibm.cos.v2.utils.Logger;

/**
 * Utilities for loading of classes and objects which have optional dependencies, and therefore need to be safely checked at
 * runtime in order to use.
 */
@SdkInternalApi
public final class OptionalDependencyLoaderUtil {
    private static final Logger LOG = Logger.loggerFor(OptionalDependencyLoaderUtil.class);

    private static final String HTTP_AUTH_AWS_CRT_PATH =
        "com.ibm.cos.v2.http.auth.aws.crt.HttpAuthAwsCrt";
    private static final String HTTP_AUTH_AWS_CRT_MODULE = "software.amazon.awssdk:http-auth-aws-crt";
    private static final String HTTP_AUTH_AWS_EVENT_STREAM_PATH =
        "com.ibm.cos.v2.http.auth.aws.eventstream.HttpAuthAwsEventStream";
    private static final String HTTP_AUTH_AWS_EVENT_STREAM_MODULE = "software.amazon.awssdk:http-auth-aws-eventstream";

    private OptionalDependencyLoaderUtil() {
    }

    public static DefaultAwsCrtV4aHttpSigner getDefaultAwsCrtV4aHttpSigner() {
        requireClass(HTTP_AUTH_AWS_CRT_PATH, HTTP_AUTH_AWS_CRT_MODULE, "CRT-V4a signing");
        return new DefaultAwsCrtV4aHttpSigner();
    }

    public static EventStreamV4PayloadSigner getEventStreamV4PayloadSigner(
        AwsCredentialsIdentity credentials,
        CredentialScope credentialScope,
        Clock signingClock) {

        requireClass(HTTP_AUTH_AWS_EVENT_STREAM_PATH, HTTP_AUTH_AWS_EVENT_STREAM_MODULE, "Event-stream signing");
        return EventStreamV4PayloadSigner.builder()
                                         .credentials(credentials)
                                         .credentialScope(credentialScope)
                                         .signingClock(signingClock)
                                         .build();
    }
}
