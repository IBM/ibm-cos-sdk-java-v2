/*
 * Copyright 2020-2025 Amazon.com, Inc. or its affiliates. All Rights Reserved.
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

package com.ibm.cos.v2.regions;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import com.ibm.cos.v2.annotations.SdkPublicApi;

/**
 * A tag applied to endpoints to specify that they're to be used in certain contexts. For example, FIPS tags are applied
 * to endpoints discussed here: https://aws.amazon.com/compliance/fips/ and DUALSTACK tags are applied to endpoints that
 * can return IPv6 addresses.
 */
@SdkPublicApi
public final class EndpointTag {
    public static final EndpointTag DUALSTACK = EndpointTag.of("dualstack");

    public static final EndpointTag FIPS = EndpointTag.of("fips");

    private static final List<EndpointTag> ENDPOINT_TAGS = Collections.unmodifiableList(Arrays.asList(DUALSTACK, FIPS));

    private final String id;

    private EndpointTag(String id) {
        this.id = id;
    }

    public static EndpointTag of(String id) {
        return EndpointTagCache.put(id);
    }

    public static List<EndpointTag> endpointTags() {
        return ENDPOINT_TAGS;
    }

    public String id() {
        return this.id;
    }

    @Override
    public String toString() {
        return id;
    }

    private static class EndpointTagCache {
        private static final ConcurrentHashMap<String, EndpointTag> IDS = new ConcurrentHashMap<>();

        private EndpointTagCache() {
        }

        private static EndpointTag put(String id) {
            return IDS.computeIfAbsent(id, EndpointTag::new);
        }
    }
}
