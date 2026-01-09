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
public enum ConnectionErrorCodeType {
    INVALID_CREDENTIALS("INVALID_CREDENTIALS"),

    CLUSTER_NOT_FOUND("CLUSTER_NOT_FOUND"),

    NETWORK_ERRORS("NETWORK_ERRORS"),

    INTERNAL_ERROR("INTERNAL_ERROR"),

    INSUFFICIENT_CLOUDHSM_HSMS("INSUFFICIENT_CLOUDHSM_HSMS"),

    USER_LOCKED_OUT("USER_LOCKED_OUT"),

    USER_NOT_FOUND("USER_NOT_FOUND"),

    USER_LOGGED_IN("USER_LOGGED_IN"),

    SUBNET_NOT_FOUND("SUBNET_NOT_FOUND"),

    INSUFFICIENT_FREE_ADDRESSES_IN_SUBNET("INSUFFICIENT_FREE_ADDRESSES_IN_SUBNET"),

    XKS_PROXY_ACCESS_DENIED("XKS_PROXY_ACCESS_DENIED"),

    XKS_PROXY_NOT_REACHABLE("XKS_PROXY_NOT_REACHABLE"),

    XKS_VPC_ENDPOINT_SERVICE_NOT_FOUND("XKS_VPC_ENDPOINT_SERVICE_NOT_FOUND"),

    XKS_PROXY_INVALID_RESPONSE("XKS_PROXY_INVALID_RESPONSE"),

    XKS_PROXY_INVALID_CONFIGURATION("XKS_PROXY_INVALID_CONFIGURATION"),

    XKS_VPC_ENDPOINT_SERVICE_INVALID_CONFIGURATION("XKS_VPC_ENDPOINT_SERVICE_INVALID_CONFIGURATION"),

    XKS_PROXY_TIMED_OUT("XKS_PROXY_TIMED_OUT"),

    XKS_PROXY_INVALID_TLS_CONFIGURATION("XKS_PROXY_INVALID_TLS_CONFIGURATION"),

    UNKNOWN_TO_SDK_VERSION(null);

    private static final Map<String, ConnectionErrorCodeType> VALUE_MAP = EnumUtils.uniqueIndex(ConnectionErrorCodeType.class,
            ConnectionErrorCodeType::toString);

    private final String value;

    private ConnectionErrorCodeType(String value) {
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
     * @return ConnectionErrorCodeType corresponding to the value
     */
    public static ConnectionErrorCodeType fromValue(String value) {
        if (value == null) {
            return null;
        }
        return VALUE_MAP.getOrDefault(value, UNKNOWN_TO_SDK_VERSION);
    }

    /**
     * Use this in place of {@link #values()} to return a {@link Set} of all values known to the SDK. This will return
     * all known enum values except {@link #UNKNOWN_TO_SDK_VERSION}.
     *
     * @return a {@link Set} of known {@link ConnectionErrorCodeType}s
     */
    public static Set<ConnectionErrorCodeType> knownValues() {
        Set<ConnectionErrorCodeType> knownValues = EnumSet.allOf(ConnectionErrorCodeType.class);
        knownValues.remove(UNKNOWN_TO_SDK_VERSION);
        return knownValues;
    }
}
