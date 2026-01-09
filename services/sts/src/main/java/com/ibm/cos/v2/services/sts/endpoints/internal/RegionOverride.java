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

package com.ibm.cos.v2.services.sts.endpoints.internal;

import com.ibm.cos.v2.annotations.SdkInternalApi;
import com.ibm.cos.v2.protocols.jsoncore.JsonNode;

@SdkInternalApi
public class RegionOverride {

    private RegionOverride(Builder builder) {
    }

    public static Builder builder() {
        return new Builder();
    }

    public static RegionOverride fromNode(JsonNode node) {
        Builder b = new Builder();
        return b.build();
    }

    @Override
    public int hashCode() {
        return 7;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof RegionOverride;
    }

    public static class Builder {
        public RegionOverride build() {
            return new RegionOverride(this);
        }
    }
}
