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

package com.ibm.cos.v2.regions.servicemetadata;

import java.net.URI;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import com.ibm.cos.v2.annotations.SdkPublicApi;
import com.ibm.cos.v2.regions.PartitionEndpointKey;
import com.ibm.cos.v2.regions.Region;
import com.ibm.cos.v2.regions.ServiceEndpointKey;
import com.ibm.cos.v2.regions.ServiceMetadata;
import com.ibm.cos.v2.regions.ServicePartitionMetadata;
import com.ibm.cos.v2.regions.internal.DefaultServicePartitionMetadata;
import com.ibm.cos.v2.regions.internal.util.ServiceMetadataUtils;
import com.ibm.cos.v2.utils.ImmutableMap;
import com.ibm.cos.v2.utils.Pair;

@SdkPublicApi
public final class S3OutpostsServiceMetadata implements ServiceMetadata {
    private static final String ENDPOINT_PREFIX = "s3-outposts";

    private static final List<Region> REGIONS = Collections.unmodifiableList(Arrays.asList(Region.of("af-south-1"),
            Region.of("ap-east-1"), Region.of("ap-northeast-1"), Region.of("ap-northeast-2"), Region.of("ap-northeast-3"),
            Region.of("ap-south-1"), Region.of("ap-southeast-1"), Region.of("ap-southeast-2"), Region.of("ap-southeast-3"),
            Region.of("ca-central-1"), Region.of("eu-central-1"), Region.of("eu-north-1"), Region.of("eu-south-1"),
            Region.of("eu-west-1"), Region.of("eu-west-2"), Region.of("eu-west-3"), Region.of("fips-ca-central-1"),
            Region.of("fips-us-east-1"), Region.of("fips-us-east-2"), Region.of("fips-us-west-1"), Region.of("fips-us-west-2"),
            Region.of("il-central-1"), Region.of("me-south-1"), Region.of("sa-east-1"), Region.of("us-east-1"),
            Region.of("us-east-2"), Region.of("us-west-1"), Region.of("us-west-2"), Region.of("fips-us-gov-east-1"),
            Region.of("fips-us-gov-west-1"), Region.of("us-gov-east-1"), Region.of("us-gov-west-1"),
            Region.of("fips-us-iso-east-1"), Region.of("us-iso-east-1"), Region.of("us-isob-east-1")));

    private static final List<ServicePartitionMetadata> PARTITIONS = Collections.unmodifiableList(Arrays.asList(
            new DefaultServicePartitionMetadata("aws", null), new DefaultServicePartitionMetadata("aws-us-gov", null),
            new DefaultServicePartitionMetadata("aws-iso", null), new DefaultServicePartitionMetadata("aws-iso-b", null)));

    private static final Map<ServiceEndpointKey, String> SIGNING_REGIONS_BY_REGION = ImmutableMap
            .<ServiceEndpointKey, String> builder().build();

    private static final Map<Pair<String, PartitionEndpointKey>, String> SIGNING_REGIONS_BY_PARTITION = ImmutableMap
            .<Pair<String, PartitionEndpointKey>, String> builder().build();

    private static final Map<ServiceEndpointKey, String> DNS_SUFFIXES_BY_REGION = ImmutableMap
            .<ServiceEndpointKey, String> builder().build();

    private static final Map<Pair<String, PartitionEndpointKey>, String> DNS_SUFFIXES_BY_PARTITION = ImmutableMap
            .<Pair<String, PartitionEndpointKey>, String> builder().build();

    private static final Map<ServiceEndpointKey, String> HOSTNAMES_BY_REGION = ImmutableMap
            .<ServiceEndpointKey, String> builder().build();

    private static final Map<Pair<String, PartitionEndpointKey>, String> HOSTNAMES_BY_PARTITION = ImmutableMap
            .<Pair<String, PartitionEndpointKey>, String> builder().build();

    @Override
    public List<Region> regions() {
        return REGIONS;
    }

    @Override
    public List<ServicePartitionMetadata> servicePartitions() {
        return PARTITIONS;
    }

    @Override
    public URI endpointFor(ServiceEndpointKey key) {
        return ServiceMetadataUtils.endpointFor(ServiceMetadataUtils.hostname(key, HOSTNAMES_BY_REGION, HOSTNAMES_BY_PARTITION),
                ENDPOINT_PREFIX, key.region().id(),
                ServiceMetadataUtils.dnsSuffix(key, DNS_SUFFIXES_BY_REGION, DNS_SUFFIXES_BY_PARTITION));
    }

    @Override
    public Region signingRegion(ServiceEndpointKey key) {
        return ServiceMetadataUtils.signingRegion(key, SIGNING_REGIONS_BY_REGION, SIGNING_REGIONS_BY_PARTITION);
    }
}
