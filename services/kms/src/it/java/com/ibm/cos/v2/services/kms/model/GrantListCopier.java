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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import com.ibm.cos.v2.annotations.Generated;
import com.ibm.cos.v2.core.util.DefaultSdkAutoConstructList;
import com.ibm.cos.v2.core.util.SdkAutoConstructList;

@Generated("com.ibm.cos.v2:codegen")
final class GrantListCopier {
    static List<GrantListEntry> copy(Collection<? extends GrantListEntry> grantListParam) {
        List<GrantListEntry> list;
        if (grantListParam == null || grantListParam instanceof SdkAutoConstructList) {
            list = DefaultSdkAutoConstructList.getInstance();
        } else {
            List<GrantListEntry> modifiableList = new ArrayList<>(grantListParam.size());
            grantListParam.forEach(entry -> {
                modifiableList.add(entry);
            });
            list = Collections.unmodifiableList(modifiableList);
        }
        return list;
    }

    static List<GrantListEntry> copyFromBuilder(Collection<? extends GrantListEntry.Builder> grantListParam) {
        List<GrantListEntry> list;
        if (grantListParam == null || grantListParam instanceof SdkAutoConstructList) {
            list = DefaultSdkAutoConstructList.getInstance();
        } else {
            List<GrantListEntry> modifiableList = new ArrayList<>(grantListParam.size());
            grantListParam.forEach(entry -> {
                GrantListEntry member = entry == null ? null : entry.build();
                modifiableList.add(member);
            });
            list = Collections.unmodifiableList(modifiableList);
        }
        return list;
    }

    static List<GrantListEntry.Builder> copyToBuilder(Collection<? extends GrantListEntry> grantListParam) {
        List<GrantListEntry.Builder> list;
        if (grantListParam == null || grantListParam instanceof SdkAutoConstructList) {
            list = DefaultSdkAutoConstructList.getInstance();
        } else {
            List<GrantListEntry.Builder> modifiableList = new ArrayList<>(grantListParam.size());
            grantListParam.forEach(entry -> {
                GrantListEntry.Builder member = entry == null ? null : entry.toBuilder();
                modifiableList.add(member);
            });
            list = Collections.unmodifiableList(modifiableList);
        }
        return list;
    }
}
