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
final class MultiRegionKeyListCopier {
    static List<MultiRegionKey> copy(Collection<? extends MultiRegionKey> multiRegionKeyListParam) {
        List<MultiRegionKey> list;
        if (multiRegionKeyListParam == null || multiRegionKeyListParam instanceof SdkAutoConstructList) {
            list = DefaultSdkAutoConstructList.getInstance();
        } else {
            List<MultiRegionKey> modifiableList = new ArrayList<>(multiRegionKeyListParam.size());
            multiRegionKeyListParam.forEach(entry -> {
                modifiableList.add(entry);
            });
            list = Collections.unmodifiableList(modifiableList);
        }
        return list;
    }

    static List<MultiRegionKey> copyFromBuilder(Collection<? extends MultiRegionKey.Builder> multiRegionKeyListParam) {
        List<MultiRegionKey> list;
        if (multiRegionKeyListParam == null || multiRegionKeyListParam instanceof SdkAutoConstructList) {
            list = DefaultSdkAutoConstructList.getInstance();
        } else {
            List<MultiRegionKey> modifiableList = new ArrayList<>(multiRegionKeyListParam.size());
            multiRegionKeyListParam.forEach(entry -> {
                MultiRegionKey member = entry == null ? null : entry.build();
                modifiableList.add(member);
            });
            list = Collections.unmodifiableList(modifiableList);
        }
        return list;
    }

    static List<MultiRegionKey.Builder> copyToBuilder(Collection<? extends MultiRegionKey> multiRegionKeyListParam) {
        List<MultiRegionKey.Builder> list;
        if (multiRegionKeyListParam == null || multiRegionKeyListParam instanceof SdkAutoConstructList) {
            list = DefaultSdkAutoConstructList.getInstance();
        } else {
            List<MultiRegionKey.Builder> modifiableList = new ArrayList<>(multiRegionKeyListParam.size());
            multiRegionKeyListParam.forEach(entry -> {
                MultiRegionKey.Builder member = entry == null ? null : entry.toBuilder();
                modifiableList.add(member);
            });
            list = Collections.unmodifiableList(modifiableList);
        }
        return list;
    }
}
