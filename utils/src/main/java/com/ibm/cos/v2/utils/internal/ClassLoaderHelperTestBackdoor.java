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

package com.ibm.cos.v2.utils.internal;

import java.util.HashMap;
import java.util.Map;
import com.ibm.cos.v2.annotations.SdkInternalApi;
import com.ibm.cos.v2.annotations.SdkTestInternalApi;
import com.ibm.cos.v2.utils.ClassLoaderHelper;

/**
 * This is a backdoor to add overrides to the results of querying {@link ClassLoaderHelper}s. This is used for testing
 * resource overrides within the SDK.
 */
@SdkTestInternalApi
@SdkInternalApi
public class ClassLoaderHelperTestBackdoor {
    private static final Map<Class<?>, ClassLoader> CLASSLOADER_OVERRIDES = new HashMap<>();

    private ClassLoaderHelperTestBackdoor() {
    }

    public static void addClassLoaderOverride(Class<?> key, ClassLoader value) {
        CLASSLOADER_OVERRIDES.put(key, value);
    }

    public static void clearClassLoaderOverrides() {
        CLASSLOADER_OVERRIDES.clear();
    }

    public static ClassLoader getClassLoader(Class<?> clazz) {
        if (!CLASSLOADER_OVERRIDES.isEmpty() && CLASSLOADER_OVERRIDES.containsKey(clazz)) {
            return CLASSLOADER_OVERRIDES.get(clazz);
        }
        return clazz.getClassLoader();
    }
}
