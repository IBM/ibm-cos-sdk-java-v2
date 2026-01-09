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

package com.ibm.cos.v2.regions.regionmetadata;

import com.ibm.cos.v2.annotations.SdkPublicApi;
import com.ibm.cos.v2.regions.PartitionMetadata;
import com.ibm.cos.v2.regions.RegionMetadata;

@SdkPublicApi
public final class AfSouth1 implements RegionMetadata {
    private static final String ID = "af-south-1";

    private static final String DOMAIN = "amazonaws.com";

    private static final String DESCRIPTION = "Africa (Cape Town)";

    private static final String PARTITION_ID = "aws";

    @Override
    public String id() {
        return ID;
    }

    @Override
    public String domain() {
        return DOMAIN;
    }

    @Override
    public String description() {
        return DESCRIPTION;
    }

    @Override
    public PartitionMetadata partition() {
        return PartitionMetadata.of(PARTITION_ID);
    }
}
