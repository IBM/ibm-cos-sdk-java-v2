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

import java.util.Map;
import com.ibm.cos.v2.annotations.SdkPublicApi;
import com.ibm.cos.v2.regions.regionmetadata.AfSouth1;
import com.ibm.cos.v2.utils.ImmutableMap;


@SdkPublicApi
public final class GeneratedRegionMetadataProvider implements RegionMetadataProvider { //TODO:REMOVE
    private static final Map<Region, RegionMetadata> REGION_METADATA = ImmutableMap.<Region, RegionMetadata> builder()
                                                                                   .put(Region.AF_SOUTH_1, new AfSouth1()).put(Region.AP_EAST_1, new AfSouth1())
                                                                                   .build();

    public RegionMetadata regionMetadata(Region region) {
        return REGION_METADATA.get(region);
    }
}
