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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import com.ibm.cos.v2.annotations.Generated;
import com.ibm.cos.v2.core.util.DefaultSdkAutoConstructList;
import com.ibm.cos.v2.core.util.SdkAutoConstructList;

@Generated("com.ibm.cos.v2:codegen")
final class OptionalObjectAttributesListCopier {
    static List<String> copy(Collection<String> optionalObjectAttributesListParam) {
        List<String> list;
        if (optionalObjectAttributesListParam == null || optionalObjectAttributesListParam instanceof SdkAutoConstructList) {
            list = DefaultSdkAutoConstructList.getInstance();
        } else {
            List<String> modifiableList = new ArrayList<>(optionalObjectAttributesListParam.size());
            optionalObjectAttributesListParam.forEach(entry -> {
                modifiableList.add(entry);
            });
            list = Collections.unmodifiableList(modifiableList);
        }
        return list;
    }

    static List<String> copyEnumToString(Collection<OptionalObjectAttributes> optionalObjectAttributesListParam) {
        List<String> list;
        if (optionalObjectAttributesListParam == null || optionalObjectAttributesListParam instanceof SdkAutoConstructList) {
            list = DefaultSdkAutoConstructList.getInstance();
        } else {
            List<String> modifiableList = new ArrayList<>(optionalObjectAttributesListParam.size());
            optionalObjectAttributesListParam.forEach(entry -> {
                String result = entry.toString();
                modifiableList.add(result);
            });
            list = Collections.unmodifiableList(modifiableList);
        }
        return list;
    }

    static List<OptionalObjectAttributes> copyStringToEnum(Collection<String> optionalObjectAttributesListParam) {
        List<OptionalObjectAttributes> list;
        if (optionalObjectAttributesListParam == null || optionalObjectAttributesListParam instanceof SdkAutoConstructList) {
            list = DefaultSdkAutoConstructList.getInstance();
        } else {
            List<OptionalObjectAttributes> modifiableList = new ArrayList<>(optionalObjectAttributesListParam.size());
            optionalObjectAttributesListParam.forEach(entry -> {
                OptionalObjectAttributes result = OptionalObjectAttributes.fromValue(entry);
                modifiableList.add(result);
            });
            list = Collections.unmodifiableList(modifiableList);
        }
        return list;
    }
}
