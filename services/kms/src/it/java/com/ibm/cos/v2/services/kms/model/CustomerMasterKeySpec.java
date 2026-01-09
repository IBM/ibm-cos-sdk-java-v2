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
@Deprecated
public enum CustomerMasterKeySpec {
    RSA_2048("RSA_2048"),

    RSA_3072("RSA_3072"),

    RSA_4096("RSA_4096"),

    ECC_NIST_P256("ECC_NIST_P256"),

    ECC_NIST_P384("ECC_NIST_P384"),

    ECC_NIST_P521("ECC_NIST_P521"),

    ECC_SECG_P256_K1("ECC_SECG_P256K1"),

    SYMMETRIC_DEFAULT("SYMMETRIC_DEFAULT"),

    HMAC_224("HMAC_224"),

    HMAC_256("HMAC_256"),

    HMAC_384("HMAC_384"),

    HMAC_512("HMAC_512"),

    SM2("SM2"),

    UNKNOWN_TO_SDK_VERSION(null);

    private static final Map<String, CustomerMasterKeySpec> VALUE_MAP = EnumUtils.uniqueIndex(CustomerMasterKeySpec.class,
            CustomerMasterKeySpec::toString);

    private final String value;

    private CustomerMasterKeySpec(String value) {
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
     * @return CustomerMasterKeySpec corresponding to the value
     */
    public static CustomerMasterKeySpec fromValue(String value) {
        if (value == null) {
            return null;
        }
        return VALUE_MAP.getOrDefault(value, UNKNOWN_TO_SDK_VERSION);
    }

    /**
     * Use this in place of {@link #values()} to return a {@link Set} of all values known to the SDK. This will return
     * all known enum values except {@link #UNKNOWN_TO_SDK_VERSION}.
     *
     * @return a {@link Set} of known {@link CustomerMasterKeySpec}s
     */
    public static Set<CustomerMasterKeySpec> knownValues() {
        Set<CustomerMasterKeySpec> knownValues = EnumSet.allOf(CustomerMasterKeySpec.class);
        knownValues.remove(UNKNOWN_TO_SDK_VERSION);
        return knownValues;
    }
}
