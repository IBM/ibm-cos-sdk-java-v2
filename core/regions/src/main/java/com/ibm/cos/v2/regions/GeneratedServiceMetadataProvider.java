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

import com.ibm.cos.v2.annotations.SdkPublicApi;
import java.util.Map;
import com.ibm.cos.v2.utils.ImmutableMap;
import com.ibm.cos.v2.regions.servicemetadata.S3ControlServiceMetadata;
import com.ibm.cos.v2.regions.servicemetadata.S3OutpostsServiceMetadata;

@SdkPublicApi
public final class GeneratedServiceMetadataProvider implements ServiceMetadataProvider {
    private static final Map<String, ServiceMetadata> SERVICE_METADATA = ImmutableMap.<String, ServiceMetadata> builder()
                                                                                     .put("s3-control", new S3ControlServiceMetadata()).put("s3-outposts", new S3OutpostsServiceMetadata()).build();

    public ServiceMetadata serviceMetadata(String endpointPrefix) {
        return SERVICE_METADATA.get(endpointPrefix);
    }
}
