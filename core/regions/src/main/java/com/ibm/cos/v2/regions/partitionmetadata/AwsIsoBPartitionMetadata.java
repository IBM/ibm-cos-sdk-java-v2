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

package com.ibm.cos.v2.regions.partitionmetadata;

import java.util.Map;
import com.ibm.cos.v2.annotations.SdkPublicApi;
import com.ibm.cos.v2.regions.EndpointTag;
import com.ibm.cos.v2.regions.PartitionEndpointKey;
import com.ibm.cos.v2.regions.PartitionMetadata;
import com.ibm.cos.v2.utils.ImmutableMap;

@SdkPublicApi
public final class AwsIsoBPartitionMetadata implements PartitionMetadata {
    private static final Map<PartitionEndpointKey, String> DNS_SUFFIXES = ImmutableMap.<PartitionEndpointKey, String> builder()
            .put(PartitionEndpointKey.builder().build(), "sc2s.sgov.gov")
            .put(PartitionEndpointKey.builder().tags(EndpointTag.of("fips")).build(), "sc2s.sgov.gov").build();

    private static final Map<PartitionEndpointKey, String> HOSTNAMES = ImmutableMap.<PartitionEndpointKey, String> builder()
            .put(PartitionEndpointKey.builder().build(), "{service}.{region}.{dnsSuffix}")
            .put(PartitionEndpointKey.builder().tags(EndpointTag.of("fips")).build(), "{service}-fips.{region}.{dnsSuffix}")
            .build();

    private static final String ID = "aws-iso-b";

    private static final String NAME = "AWS ISOB (US)";

    private static final String REGION_REGEX = "^us\\-isob\\-\\w+\\-\\d+$";

    @Override
    public String id() {
        return ID;
    }

    @Override
    public String name() {
        return NAME;
    }

    @Override
    public String regionRegex() {
        return REGION_REGEX;
    }

    @Override
    public String dnsSuffix(PartitionEndpointKey key) {
        return DNS_SUFFIXES.get(key);
    }

    @Override
    public String hostname(PartitionEndpointKey key) {
        return HOSTNAMES.get(key);
    }
}
