/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License").
 * You may not use this file except in compliance with the License.
 * A copy of the License is located at
 *
 *  http://aws.amazon.com/apache2.0
 *
 * or in the "license" file accompanying this file. This file is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */

package com.ibm.cos.v2.protocols.cbor;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static com.ibm.cos.v2.core.SdkSystemSetting.CBOR_ENABLED;
import static com.ibm.cos.v2.core.traits.TimestampFormatTrait.Format.RFC_822;
import static com.ibm.cos.v2.core.traits.TimestampFormatTrait.Format.UNIX_TIMESTAMP;
import static com.ibm.cos.v2.core.traits.TimestampFormatTrait.Format.UNIX_TIMESTAMP_MILLIS;

import java.util.Map;
import org.junit.jupiter.api.Test;
import com.ibm.cos.v2.core.protocol.MarshallLocation;
import com.ibm.cos.v2.core.traits.TimestampFormatTrait;
import com.ibm.cos.v2.testutils.EnvironmentVariableHelper;

public class AwsCborProtocolFactoryTest {

    @Test
    public void defaultTimestampFormats_cborEnabled() {
        AwsCborProtocolFactory factory = AwsCborProtocolFactory.builder().build();
        Map<MarshallLocation, TimestampFormatTrait.Format> defaultTimestampFormats = factory.getDefaultTimestampFormats();
        assertThat(defaultTimestampFormats.get(MarshallLocation.HEADER)).isEqualTo(RFC_822);
        assertThat(defaultTimestampFormats.get(MarshallLocation.PAYLOAD)).isEqualTo(UNIX_TIMESTAMP_MILLIS);
    }

    @Test
    public void defaultTimestampFormats_cborDisabled() {
        EnvironmentVariableHelper.run(helper -> {
            helper.set(CBOR_ENABLED, "false");
            AwsCborProtocolFactory factory = AwsCborProtocolFactory.builder().build();
            Map<MarshallLocation, TimestampFormatTrait.Format> defaultTimestampFormats = factory.getDefaultTimestampFormats();
            assertThat(defaultTimestampFormats.get(MarshallLocation.HEADER)).isEqualTo(RFC_822);
            assertThat(defaultTimestampFormats.get(MarshallLocation.PAYLOAD)).isEqualTo(UNIX_TIMESTAMP);
        });
    }
}
