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

import java.time.Duration;
import java.util.EnumMap;
import java.util.Map;
import com.ibm.cos.v2.annotations.SdkInternalApi;
import com.ibm.cos.v2.core.client.config.SdkClientOption;
import com.ibm.cos.v2.core.retry.RetryMode;
import com.ibm.cos.v2.http.SdkHttpConfigurationOption;
import com.ibm.cos.v2.regions.ServiceMetadataAdvancedOption;
import com.ibm.cos.v2.utils.AttributeMap;

/**
 * Contains a collection of default configuration options for each DefaultsMode
 */
@SdkInternalApi
public final class DefaultsModeConfiguration {
    private static final AttributeMap STANDARD_DEFAULTS = AttributeMap.builder()
                                                                      .put(SdkClientOption.DEFAULT_RETRY_MODE, RetryMode.STANDARD)
                                                                      .put(ServiceMetadataAdvancedOption.DEFAULT_S3_US_EAST_1_REGIONAL_ENDPOINT, "regional").build();

    private static final AttributeMap STANDARD_HTTP_DEFAULTS = AttributeMap.builder()
                                                                           .put(SdkHttpConfigurationOption.CONNECTION_TIMEOUT, Duration.ofMillis(3100))
                                                                           .put(SdkHttpConfigurationOption.TLS_NEGOTIATION_TIMEOUT, Duration.ofMillis(3100)).build();

    private static final AttributeMap MOBILE_DEFAULTS = AttributeMap.builder()
                                                                    .put(SdkClientOption.DEFAULT_RETRY_MODE, RetryMode.STANDARD)
                                                                    .put(ServiceMetadataAdvancedOption.DEFAULT_S3_US_EAST_1_REGIONAL_ENDPOINT, "regional").build();

    private static final AttributeMap MOBILE_HTTP_DEFAULTS = AttributeMap.builder()
                                                                         .put(SdkHttpConfigurationOption.CONNECTION_TIMEOUT, Duration.ofMillis(30000))
                                                                         .put(SdkHttpConfigurationOption.TLS_NEGOTIATION_TIMEOUT, Duration.ofMillis(30000)).build();

    private static final AttributeMap CROSS_REGION_DEFAULTS = AttributeMap.builder()
                                                                          .put(SdkClientOption.DEFAULT_RETRY_MODE, RetryMode.STANDARD)
                                                                          .put(ServiceMetadataAdvancedOption.DEFAULT_S3_US_EAST_1_REGIONAL_ENDPOINT, "regional").build();

    private static final AttributeMap CROSS_REGION_HTTP_DEFAULTS = AttributeMap.builder()
                                                                               .put(SdkHttpConfigurationOption.CONNECTION_TIMEOUT, Duration.ofMillis(3100))
                                                                               .put(SdkHttpConfigurationOption.TLS_NEGOTIATION_TIMEOUT, Duration.ofMillis(3100)).build();

    private static final AttributeMap IN_REGION_DEFAULTS = AttributeMap.builder()
                                                                       .put(SdkClientOption.DEFAULT_RETRY_MODE, RetryMode.STANDARD)
                                                                       .put(ServiceMetadataAdvancedOption.DEFAULT_S3_US_EAST_1_REGIONAL_ENDPOINT, "regional").build();

    private static final AttributeMap IN_REGION_HTTP_DEFAULTS = AttributeMap.builder()
                                                                            .put(SdkHttpConfigurationOption.CONNECTION_TIMEOUT, Duration.ofMillis(1100))
                                                                            .put(SdkHttpConfigurationOption.TLS_NEGOTIATION_TIMEOUT, Duration.ofMillis(1100)).build();

    private static final AttributeMap LEGACY_DEFAULTS = AttributeMap.empty();

    private static final AttributeMap LEGACY_HTTP_DEFAULTS = AttributeMap.empty();

    private static final Map<DefaultsMode, AttributeMap> DEFAULT_CONFIG_BY_MODE = new EnumMap<>(DefaultsMode.class);

    private static final Map<DefaultsMode, AttributeMap> DEFAULT_HTTP_CONFIG_BY_MODE = new EnumMap<>(DefaultsMode.class);

    static {
        DEFAULT_CONFIG_BY_MODE.put(DefaultsMode.STANDARD, STANDARD_DEFAULTS);
        DEFAULT_CONFIG_BY_MODE.put(DefaultsMode.MOBILE, MOBILE_DEFAULTS);
        DEFAULT_CONFIG_BY_MODE.put(DefaultsMode.CROSS_REGION, CROSS_REGION_DEFAULTS);
        DEFAULT_CONFIG_BY_MODE.put(DefaultsMode.IN_REGION, IN_REGION_DEFAULTS);
        DEFAULT_CONFIG_BY_MODE.put(DefaultsMode.LEGACY, LEGACY_DEFAULTS);
        DEFAULT_HTTP_CONFIG_BY_MODE.put(DefaultsMode.STANDARD, STANDARD_HTTP_DEFAULTS);
        DEFAULT_HTTP_CONFIG_BY_MODE.put(DefaultsMode.MOBILE, MOBILE_HTTP_DEFAULTS);
        DEFAULT_HTTP_CONFIG_BY_MODE.put(DefaultsMode.CROSS_REGION, CROSS_REGION_HTTP_DEFAULTS);
        DEFAULT_HTTP_CONFIG_BY_MODE.put(DefaultsMode.IN_REGION, IN_REGION_HTTP_DEFAULTS);
        DEFAULT_HTTP_CONFIG_BY_MODE.put(DefaultsMode.LEGACY, LEGACY_HTTP_DEFAULTS);
    }

    private DefaultsModeConfiguration() {
    }

    /**
     * Return the default config options for a given defaults mode
     */
    public static AttributeMap defaultConfig(DefaultsMode mode) {
        return DEFAULT_CONFIG_BY_MODE.getOrDefault(mode, AttributeMap.empty());
    }

    /**
     * Return the default config options for a given defaults mode
     */
    public static AttributeMap defaultHttpConfig(DefaultsMode mode) {
        return DEFAULT_HTTP_CONFIG_BY_MODE.getOrDefault(mode, AttributeMap.empty());
    }
}
