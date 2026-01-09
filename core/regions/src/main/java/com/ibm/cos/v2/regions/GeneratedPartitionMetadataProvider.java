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
import com.ibm.cos.v2.regions.partitionmetadata.AwsCnPartitionMetadata;
import com.ibm.cos.v2.regions.partitionmetadata.AwsEuscPartitionMetadata;
import com.ibm.cos.v2.regions.partitionmetadata.AwsIsoBPartitionMetadata;
import com.ibm.cos.v2.regions.partitionmetadata.AwsIsoEPartitionMetadata;
import com.ibm.cos.v2.regions.partitionmetadata.AwsIsoFPartitionMetadata;
import com.ibm.cos.v2.regions.partitionmetadata.AwsIsoPartitionMetadata;
import com.ibm.cos.v2.regions.partitionmetadata.AwsPartitionMetadata;
import com.ibm.cos.v2.regions.partitionmetadata.AwsUsGovPartitionMetadata;
import com.ibm.cos.v2.utils.ImmutableMap;

@SdkPublicApi
public final class GeneratedPartitionMetadataProvider implements PartitionMetadataProvider {
    private static final Map<String, PartitionMetadata> PARTITION_METADATA = ImmutableMap.<String, PartitionMetadata> builder()
                                                                                         .put("aws", new AwsPartitionMetadata()).put("aws-cn", new AwsCnPartitionMetadata())
                                                                                         .put("aws-us-gov", new AwsUsGovPartitionMetadata()).put("aws-iso", new AwsIsoPartitionMetadata())
                                                                                         .put("aws-iso-b", new AwsIsoBPartitionMetadata()).put("aws-iso-e", new AwsIsoEPartitionMetadata())
                                                                                         .put("aws-iso-f", new AwsIsoFPartitionMetadata()).put("aws-eusc", new AwsEuscPartitionMetadata()).build();

    public PartitionMetadata partitionMetadata(String partition) {
        return PARTITION_METADATA.get(partition);
    }

    public PartitionMetadata partitionMetadata(Region region) {
        return PARTITION_METADATA.values().stream().filter(p -> region.id().matches(p.regionRegex())).findFirst()
                .orElse(new AwsPartitionMetadata());
    }
}
