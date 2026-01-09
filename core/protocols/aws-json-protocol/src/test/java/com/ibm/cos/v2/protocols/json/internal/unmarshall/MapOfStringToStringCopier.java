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

package com.ibm.cos.v2.protocols.json.internal.unmarshall;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import com.ibm.cos.v2.annotations.Generated;
import com.ibm.cos.v2.core.util.DefaultSdkAutoConstructMap;
import com.ibm.cos.v2.core.util.SdkAutoConstructMap;

@Generated("com.ibm.cos.v2:codegen")
final class MapOfStringToStringCopier {
    static Map<String, String> copy(Map<String, String> mapOfStringToStringParam) {
        Map<String, String> map;
        if (mapOfStringToStringParam == null || mapOfStringToStringParam instanceof SdkAutoConstructMap) {
            map = DefaultSdkAutoConstructMap.getInstance();
        } else {
            Map<String, String> modifiableMap = new LinkedHashMap<>(mapOfStringToStringParam.size());
            mapOfStringToStringParam.forEach((key, value) -> {
                modifiableMap.put(key, value);
            });
            map = Collections.unmodifiableMap(modifiableMap);
        }
        return map;
    }
}
