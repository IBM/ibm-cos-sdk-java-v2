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

package com.ibm.cos.v2.awscore.internal.defaultsmode;

import java.util.Optional;
import com.ibm.cos.v2.annotations.SdkProtectedApi;
import com.ibm.cos.v2.awscore.defaultsmode.DefaultsMode;
import com.ibm.cos.v2.core.SdkSystemSetting;
import com.ibm.cos.v2.regions.Region;
import com.ibm.cos.v2.utils.JavaSystemSetting;
import com.ibm.cos.v2.utils.OptionalUtils;
import com.ibm.cos.v2.utils.SystemSetting;
import com.ibm.cos.v2.utils.internal.SystemSettingUtils;

/**
 * This class attempts to discover the appropriate {@link DefaultsMode} by inspecting the environment. It falls
 * back to the {@link DefaultsMode#STANDARD} mode if the target mode cannot be determined.
 *
 * <p>
 * Implementation notes: this class should've been outside internal package,
 * but we can't fix it due to backwards compatibility reasons.
 */
@SdkProtectedApi
public class AutoDefaultsModeDiscovery {
    private static final DefaultsMode FALLBACK_DEFAULTS_MODE = DefaultsMode.STANDARD;
    private static final String ANDROID_JAVA_VENDOR = "The Android Project";
    private static final String AWS_DEFAULT_REGION_ENV_VAR = "AWS_DEFAULT_REGION";

    /**
     *  Discovers the defaultMode using the following workflow:
     *
     *  1. Check if it's on mobile
     *  2. If it's not on mobile (best we can tell), see if we can determine whether we're an in-region or cross-region client.
     *  3. If we couldn't figure out the region from environment variables. Check IMDSv2. This step might take up to 1 second
     *  (default connect timeout)
     *  4. Finally, use fallback mode
     */
    public DefaultsMode discover(Region regionResolvedFromSdkClient) {

        if (isMobile()) {
            return DefaultsMode.MOBILE;
        }

        if (isAwsExecutionEnvironment()) {
            Optional<String> regionStr = regionFromAwsExecutionEnvironment();

            if (regionStr.isPresent()) {
                return compareRegion(regionStr.get(), regionResolvedFromSdkClient);
            }
        }

        return FALLBACK_DEFAULTS_MODE;
    }

    private static DefaultsMode compareRegion(String region, Region clientRegion) {
        if (region.equalsIgnoreCase(clientRegion.id())) {
            return DefaultsMode.IN_REGION;
        }

        return DefaultsMode.CROSS_REGION;
    }

    /**
     * Check to see if the application is running on a mobile device by verifying the Java
     * vendor system property. Currently only checks for Android. While it's technically possible to
     * use Java with iOS, it's not a common use-case.
     * <p>
     * https://developer.android.com/reference/java/lang/System#getProperties()
     */
    private static boolean isMobile() {
        return JavaSystemSetting.JAVA_VENDOR.getStringValue()
                                            .filter(o -> o.equals(ANDROID_JAVA_VENDOR))
                                            .isPresent();
    }

    private static boolean isAwsExecutionEnvironment() {
        return SdkSystemSetting.AWS_EXECUTION_ENV.getStringValue().isPresent();
    }

    private static Optional<String> regionFromAwsExecutionEnvironment() {
        Optional<String> regionFromRegionEnvVar = SdkSystemSetting.AWS_REGION.getStringValue();
        return OptionalUtils.firstPresent(regionFromRegionEnvVar,
                                          () -> SystemSettingUtils.resolveEnvironmentVariable(new DefaultRegionEnvVar()));
    }

    private static final class DefaultRegionEnvVar implements SystemSetting {
        @Override
        public String property() {
            return null;
        }

        @Override
        public String environmentVariable() {
            return AWS_DEFAULT_REGION_ENV_VAR;
        }

        @Override
        public String defaultValue() {
            return null;
        }
    }
}
