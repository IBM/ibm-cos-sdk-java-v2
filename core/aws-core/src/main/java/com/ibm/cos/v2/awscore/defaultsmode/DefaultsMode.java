/*
 * Copyright 2020-2025 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"). You may not use this file except in compliance with
 * the License. A copy of the License is located at
 * 
 * http://aws.amazon.com/apache2.0
 * 
 * or in the "license" file accompanying this file. This file is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR
 * CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions
 * and limitations under the License.
 */

package com.ibm.cos.v2.awscore.defaultsmode;

import java.util.Map;
import com.ibm.cos.v2.annotations.SdkPublicApi;
import com.ibm.cos.v2.utils.Validate;
import com.ibm.cos.v2.utils.internal.EnumUtils;

/**
 * A defaults mode determines how certain default configuration options are resolved in the SDK. Based on the provided
 * mode, the SDK will vend sensible default values tailored to the mode for the following settings:
 * <ul>
 * <li>retryMode:
 * <p>
 * A retry mode specifies how the SDK attempts retries. See <a
 * href="https://docs.aws.amazon.com/sdkref/latest/guide/setting-global-retry_mode.html">Retry Mode</a>
 * </p>
 * </li>
 * <li>s3UsEast1RegionalEndpoints:
 * <p>
 * Specifies how the SDK determines the AWS service endpoint that it uses to talk to the Amazon S3 for the us-east-1
 * region
 * </p>
 * </li>
 * <li>connectTimeoutInMillis:
 * <p>
 * The amount of time after making an initial connection attempt on a socket, where if the client does not receive a
 * completion of the connect handshake, the client gives up and fails the operation
 * </p>
 * </li>
 * <li>tlsNegotiationTimeoutInMillis:
 * <p>
 * The maximum amount of time that a TLS handshake is allowed to take from the time the CLIENT HELLO message is sent to
 * ethe time the client and server have fully negotiated ciphers and exchanged keys
 * </p>
 * </li>
 * </ul>
 * <p>
 * All options above can be configured by users, and the overridden value will take precedence.
 * <p>
 * <b>Note:</b> for any mode other than {@link #LEGACY}, the vended default values might change as best practices may
 * evolve. As a result, it is encouraged to perform testing when upgrading the SDK if you are using a mode other than
 * {@link #LEGACY}
 * <p>
 * While the {@link #LEGACY} defaults mode is specific to Java, other modes are standardized across all of the AWS SDKs
 * </p>
 * <p>
 * The defaults mode can be configured:
 * <ol>
 * <li>Directly on a client via {@code AwsClientBuilder.Builder#defaultsMode(DefaultsMode)}.</li>
 * <li>On a configuration profile via the "defaults_mode" profile file property.</li>
 * <li>Globally via the "aws.defaultsMode" system property.</li>
 * <li>Globally via the "AWS_DEFAULTS_MODE" environment variable.</li>
 * </ol>
 */
@SdkPublicApi
public enum DefaultsMode {
    /**
     * <p>
     * The LEGACY mode provides default settings that vary per SDK and were used prior to establishment of defaults_mode
     * </p>
     */
    LEGACY("legacy"),

    /**
     * <p>
     * The STANDARD mode provides the latest recommended default values that should be safe to run in most scenarios
     * </p>
     * <p>
     * Note that the default values vended from this mode might change as best practices may evolve. As a result, it is
     * encouraged to perform tests when upgrading the SDK
     * </p>
     */
    STANDARD("standard"),

    /**
     * <p>
     * The MOBILE mode builds on the standard mode and includes optimization tailored for mobile applications
     * </p>
     * <p>
     * Note that the default values vended from this mode might change as best practices may evolve. As a result, it is
     * encouraged to perform tests when upgrading the SDK
     * </p>
     */
    MOBILE("mobile"),

    /**
     * <p>
     * The CROSS_REGION mode builds on the standard mode and includes optimization tailored for applications which call
     * AWS services in a different region
     * </p>
     * <p>
     * Note that the default values vended from this mode might change as best practices may evolve. As a result, it is
     * encouraged to perform tests when upgrading the SDK
     * </p>
     */
    CROSS_REGION("cross-region"),

    /**
     * <p>
     * The IN_REGION mode builds on the standard mode and includes optimization tailored for applications which call AWS
     * services from within the same AWS region
     * </p>
     * <p>
     * Note that the default values vended from this mode might change as best practices may evolve. As a result, it is
     * encouraged to perform tests when upgrading the SDK
     * </p>
     */
    IN_REGION("in-region"),

    /**
     * <p>
     * The AUTO mode is an experimental mode that builds on the standard mode. The SDK will attempt to discover the
     * execution environment to determine the appropriate settings automatically.
     * </p>
     * <p>
     * Note that the auto detection is heuristics-based and does not guarantee 100% accuracy. STANDARD mode will be used
     * if the execution environment cannot be determined. The auto detection might query <a
     * href="https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/ec2-instance-metadata.html">EC2 Instance Metadata
     * service</a>, which might introduce latency. Therefore we recommend choosing an explicit defaults_mode instead if
     * startup latency is critical to your application
     * </p>
     */
    AUTO("auto");

    private static final Map<String, DefaultsMode> VALUE_MAP = EnumUtils.uniqueIndex(DefaultsMode.class, DefaultsMode::toString);

    private final String value;

    private DefaultsMode(String value) {
        this.value = value;
    }

    /**
     * Use this in place of valueOf to convert the raw string returned by the service into the enum value.
     *
     * @param value
     *        real value
     * @return DefaultsMode corresponding to the value
     */
    public static DefaultsMode fromValue(String value) {
        Validate.paramNotNull(value, "value");
        if (!VALUE_MAP.containsKey(value)) {
            throw new IllegalArgumentException("The provided value is not a valid defaults mode " + value);
        }
        return VALUE_MAP.get(value);
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
