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
final class CompletedPartListCopier {
    static List<CompletedPart> copy(Collection<? extends CompletedPart> completedPartListParam) {
        List<CompletedPart> list;
        if (completedPartListParam == null || completedPartListParam instanceof SdkAutoConstructList) {
            list = DefaultSdkAutoConstructList.getInstance();
        } else {
            List<CompletedPart> modifiableList = new ArrayList<>(completedPartListParam.size());
            completedPartListParam.forEach(entry -> {
                modifiableList.add(entry);
            });
            list = Collections.unmodifiableList(modifiableList);
        }
        return list;
    }

    static List<CompletedPart> copyFromBuilder(Collection<? extends CompletedPart.Builder> completedPartListParam) {
        List<CompletedPart> list;
        if (completedPartListParam == null || completedPartListParam instanceof SdkAutoConstructList) {
            list = DefaultSdkAutoConstructList.getInstance();
        } else {
            List<CompletedPart> modifiableList = new ArrayList<>(completedPartListParam.size());
            completedPartListParam.forEach(entry -> {
                CompletedPart member = entry == null ? null : entry.build();
                modifiableList.add(member);
            });
            list = Collections.unmodifiableList(modifiableList);
        }
        return list;
    }

    static List<CompletedPart.Builder> copyToBuilder(Collection<? extends CompletedPart> completedPartListParam) {
        List<CompletedPart.Builder> list;
        if (completedPartListParam == null || completedPartListParam instanceof SdkAutoConstructList) {
            list = DefaultSdkAutoConstructList.getInstance();
        } else {
            List<CompletedPart.Builder> modifiableList = new ArrayList<>(completedPartListParam.size());
            completedPartListParam.forEach(entry -> {
                CompletedPart.Builder member = entry == null ? null : entry.toBuilder();
                modifiableList.add(member);
            });
            list = Collections.unmodifiableList(modifiableList);
        }
        return list;
    }
}
