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

package com.ibm.cos.v2.services.kms.model;

import java.util.EnumSet;
import java.util.Map;
import java.util.Set;
import com.ibm.cos.v2.annotations.Generated;
import com.ibm.cos.v2.utils.internal.EnumUtils;

@Generated("com.ibm.cos.v2:codegen")
public enum AlgorithmSpec {
    RSAES_PKCS1_V1_5("RSAES_PKCS1_V1_5"),

    RSAES_OAEP_SHA_1("RSAES_OAEP_SHA_1"),

    RSAES_OAEP_SHA_256("RSAES_OAEP_SHA_256"),

    RSA_AES_KEY_WRAP_SHA_1("RSA_AES_KEY_WRAP_SHA_1"),

    RSA_AES_KEY_WRAP_SHA_256("RSA_AES_KEY_WRAP_SHA_256"),

    SM2_PKE("SM2PKE"),

    UNKNOWN_TO_SDK_VERSION(null);

    private static final Map<String, AlgorithmSpec> VALUE_MAP = EnumUtils.uniqueIndex(AlgorithmSpec.class,
            AlgorithmSpec::toString);

    private final String value;

    private AlgorithmSpec(String value) {
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
     * @return AlgorithmSpec corresponding to the value
     */
    public static AlgorithmSpec fromValue(String value) {
        if (value == null) {
            return null;
        }
        return VALUE_MAP.getOrDefault(value, UNKNOWN_TO_SDK_VERSION);
    }

    /**
     * Use this in place of {@link #values()} to return a {@link Set} of all values known to the SDK. This will return
     * all known enum values except {@link #UNKNOWN_TO_SDK_VERSION}.
     *
     * @return a {@link Set} of known {@link AlgorithmSpec}s
     */
    public static Set<AlgorithmSpec> knownValues() {
        Set<AlgorithmSpec> knownValues = EnumSet.allOf(AlgorithmSpec.class);
        knownValues.remove(UNKNOWN_TO_SDK_VERSION);
        return knownValues;
    }
}
