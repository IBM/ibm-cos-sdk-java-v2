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

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Optional;
import com.ibm.cos.v2.annotations.Generated;
import com.ibm.cos.v2.annotations.SdkInternalApi;
import com.ibm.cos.v2.core.SdkSystemSetting;
import com.ibm.cos.v2.protocols.jsoncore.JsonNodeParser;
import com.ibm.cos.v2.utils.ClassLoaderHelper;
import com.ibm.cos.v2.utils.FunctionalUtils;
import com.ibm.cos.v2.utils.IoUtils;
import com.ibm.cos.v2.utils.OptionalUtils;

@Generated("software.amazon.awssdk:codegen")
@SdkInternalApi
public final class DefaultPartitionDataProvider implements PartitionDataProvider {
    private static final JsonNodeParser PARSER = JsonNodeParser.create();

    @Override
    public Partitions loadPartitions() {
        return OptionalUtils.firstPresent(systemSettingPartitionsFile(), this::classpathPartitionsFile,
                                          () -> Optional.of(LazyPartitionsContainer.PARTITIONS)).orElseThrow(
            () -> new IllegalStateException("Unable to find partition metadata."));
    }

    private Optional<Partitions> systemSettingPartitionsFile() {
        return SdkSystemSetting.AWS_PARTITIONS_FILE.getStringValue().map(Paths::get)
                                                   .map(p -> FunctionalUtils.invokeSafely(() -> Files.newInputStream(p))).map(this::readPartitionsFile);
    }

    private Optional<Partitions> classpathPartitionsFile() {
        return Optional.ofNullable(
                           ClassLoaderHelper.classLoader(getClass()).getResourceAsStream("com/ibm/cos/v2/global/partitions"
                                                                                         + ".json"))
                       .map(this::readPartitionsFile);
    }

    private Partitions readPartitionsFile(InputStream partitionsFile) {
        try {
            return Partitions.fromNode(PARSER.parse(partitionsFile));
        } finally {
            IoUtils.closeQuietly(partitionsFile, null);
        }
    }

    static class LazyPartitionsContainer {
        static final Partitions PARTITIONS = Partitions
            .builder()
            .version("1.1")
            .addPartition(
                Partition
                    .builder()
                    .id("aws")
                    .regionRegex("^(us|eu|ap|sa|ca|me|af|il|mx)\\-\\w+\\-\\d+$")
                    .putRegion("af-south-1", RegionOverride.builder().build())
                    .putRegion("ap-east-1", RegionOverride.builder().build())
                    .putRegion("ap-northeast-1", RegionOverride.builder().build())
                    .putRegion("ap-northeast-2", RegionOverride.builder().build())
                    .putRegion("ap-northeast-3", RegionOverride.builder().build())
                    .putRegion("ap-south-1", RegionOverride.builder().build())
                    .putRegion("ap-south-2", RegionOverride.builder().build())
                    .putRegion("ap-southeast-1", RegionOverride.builder().build())
                    .putRegion("ap-southeast-2", RegionOverride.builder().build())
                    .putRegion("ap-southeast-3", RegionOverride.builder().build())
                    .putRegion("ap-southeast-4", RegionOverride.builder().build())
                    .putRegion("ap-southeast-5", RegionOverride.builder().build())
                    .putRegion("ap-southeast-7", RegionOverride.builder().build())
                    .putRegion("aws-global", RegionOverride.builder().build())
                    .putRegion("ca-central-1", RegionOverride.builder().build())
                    .putRegion("ca-west-1", RegionOverride.builder().build())
                    .putRegion("eu-central-1", RegionOverride.builder().build())
                    .putRegion("eu-central-2", RegionOverride.builder().build())
                    .putRegion("eu-north-1", RegionOverride.builder().build())
                    .putRegion("eu-south-1", RegionOverride.builder().build())
                    .putRegion("eu-south-2", RegionOverride.builder().build())
                    .putRegion("eu-west-1", RegionOverride.builder().build())
                    .putRegion("eu-west-2", RegionOverride.builder().build())
                    .putRegion("eu-west-3", RegionOverride.builder().build())
                    .putRegion("il-central-1", RegionOverride.builder().build())
                    .putRegion("me-central-1", RegionOverride.builder().build())
                    .putRegion("me-south-1", RegionOverride.builder().build())
                    .putRegion("mx-central-1", RegionOverride.builder().build())
                    .putRegion("sa-east-1", RegionOverride.builder().build())
                    .putRegion("us-east-1", RegionOverride.builder().build())
                    .putRegion("us-east-2", RegionOverride.builder().build())
                    .putRegion("us-west-1", RegionOverride.builder().build())
                    .putRegion("us-west-2", RegionOverride.builder().build())
                    .outputs(
                        Outputs.builder().dnsSuffix("amazonaws.com").dualStackDnsSuffix("api.aws")
                               .supportsFips(true).supportsDualStack(true).implicitGlobalRegion("us-east-1")
                               .build()).build())
            .addPartition(
                Partition
                    .builder()
                    .id("aws-cn")
                    .regionRegex("^cn\\-\\w+\\-\\d+$")
                    .putRegion("aws-cn-global", RegionOverride.builder().build())
                    .putRegion("cn-north-1", RegionOverride.builder().build())
                    .putRegion("cn-northwest-1", RegionOverride.builder().build())
                    .outputs(
                        Outputs.builder().dnsSuffix("amazonaws.com.cn")
                               .dualStackDnsSuffix("api.amazonwebservices.com.cn").supportsFips(true)
                               .supportsDualStack(true).implicitGlobalRegion("cn-northwest-1").build()).build())
            .addPartition(
                Partition
                    .builder()
                    .id("aws-us-gov")
                    .regionRegex("^us\\-gov\\-\\w+\\-\\d+$")
                    .putRegion("aws-us-gov-global", RegionOverride.builder().build())
                    .putRegion("us-gov-east-1", RegionOverride.builder().build())
                    .putRegion("us-gov-west-1", RegionOverride.builder().build())
                    .outputs(
                        Outputs.builder().dnsSuffix("amazonaws.com").dualStackDnsSuffix("api.aws")
                               .supportsFips(true).supportsDualStack(true).implicitGlobalRegion("us-gov-west-1")
                               .build()).build())
            .addPartition(
                Partition
                    .builder()
                    .id("aws-iso")
                    .regionRegex("^us\\-iso\\-\\w+\\-\\d+$")
                    .putRegion("aws-iso-global", RegionOverride.builder().build())
                    .putRegion("us-iso-east-1", RegionOverride.builder().build())
                    .putRegion("us-iso-west-1", RegionOverride.builder().build())
                    .outputs(
                        Outputs.builder().dnsSuffix("c2s.ic.gov").dualStackDnsSuffix("c2s.ic.gov")
                               .supportsFips(true).supportsDualStack(false)
                               .implicitGlobalRegion("us-iso-east-1").build()).build())
            .addPartition(
                Partition
                    .builder()
                    .id("aws-iso-b")
                    .regionRegex("^us\\-isob\\-\\w+\\-\\d+$")
                    .putRegion("aws-iso-b-global", RegionOverride.builder().build())
                    .putRegion("us-isob-east-1", RegionOverride.builder().build())
                    .outputs(
                        Outputs.builder().dnsSuffix("sc2s.sgov.gov").dualStackDnsSuffix("sc2s.sgov.gov")
                               .supportsFips(true).supportsDualStack(false)
                               .implicitGlobalRegion("us-isob-east-1").build()).build())
            .addPartition(
                Partition
                    .builder()
                    .id("aws-iso-e")
                    .regionRegex("^eu\\-isoe\\-\\w+\\-\\d+$")
                    .putRegion("aws-iso-e-global", RegionOverride.builder().build())
                    .putRegion("eu-isoe-west-1", RegionOverride.builder().build())
                    .outputs(
                        Outputs.builder().dnsSuffix("cloud.adc-e.uk").dualStackDnsSuffix("cloud.adc-e.uk")
                               .supportsFips(true).supportsDualStack(false)
                               .implicitGlobalRegion("eu-isoe-west-1").build()).build())
            .addPartition(
                Partition
                    .builder()
                    .id("aws-iso-f")
                    .regionRegex("^us\\-isof\\-\\w+\\-\\d+$")
                    .putRegion("aws-iso-f-global", RegionOverride.builder().build())
                    .putRegion("us-isof-east-1", RegionOverride.builder().build())
                    .putRegion("us-isof-south-1", RegionOverride.builder().build())
                    .outputs(
                        Outputs.builder().dnsSuffix("csp.hci.ic.gov").dualStackDnsSuffix("csp.hci.ic.gov")
                               .supportsFips(true).supportsDualStack(false)
                               .implicitGlobalRegion("us-isof-south-1").build()).build())
            .addPartition(
                Partition
                    .builder()
                    .id("aws-eusc")
                    .regionRegex("^eusc\\-(de)\\-\\w+\\-\\d+$")
                    .putRegion("eusc-de-east-1", RegionOverride.builder().build())
                    .outputs(
                        Outputs.builder().dnsSuffix("amazonaws.eu").dualStackDnsSuffix("amazonaws.eu")
                               .supportsFips(true).supportsDualStack(false)
                               .implicitGlobalRegion("eusc-de-east-1").build()).build()).build();
    }
}
