/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
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

package com.ibm.cos.v2.services.s3.model;

import java.util.EnumSet;
import java.util.Map;
import java.util.Set;
import com.ibm.cos.v2.annotations.Generated;
import com.ibm.cos.v2.utils.internal.EnumUtils;

@Generated("com.ibm.cos.v2:codegen")
public enum TransitionDefaultMinimumObjectSize {
    VARIES_BY_STORAGE_CLASS("varies_by_storage_class"),

    ALL_STORAGE_CLASSES_128_K("all_storage_classes_128K"),

    UNKNOWN_TO_SDK_VERSION(null);

    private static final Map<String, TransitionDefaultMinimumObjectSize> VALUE_MAP = EnumUtils.uniqueIndex(
            TransitionDefaultMinimumObjectSize.class, TransitionDefaultMinimumObjectSize::toString);

    private final String value;

    private TransitionDefaultMinimumObjectSize(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    /**
     * Use this in place of valueOf to convert the raw string returned by the service into the enum value.
     *
     * @param value
     *        real value
     * @return TransitionDefaultMinimumObjectSize corresponding to the value
     */
    public static TransitionDefaultMinimumObjectSize fromValue(String value) {
        if (value == null) {
            return null;
        }
        return VALUE_MAP.getOrDefault(value, UNKNOWN_TO_SDK_VERSION);
    }

    /**
     * Use this in place of {@link #values()} to return a {@link Set} of all values known to the SDK. This will return
     * all known enum values except {@link #UNKNOWN_TO_SDK_VERSION}.
     *
     * @return a {@link Set} of known {@link TransitionDefaultMinimumObjectSize}s
     */
    public static Set<TransitionDefaultMinimumObjectSize> knownValues() {
        Set<TransitionDefaultMinimumObjectSize> knownValues = EnumSet.allOf(TransitionDefaultMinimumObjectSize.class);
        knownValues.remove(UNKNOWN_TO_SDK_VERSION);
        return knownValues;
    }
}
