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

package com.ibm.cos.v2.protocols.json;

import java.net.URI;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;
import com.ibm.cos.v2.core.ClientEndpointProvider;
import com.ibm.cos.v2.core.SdkField;
import com.ibm.cos.v2.core.SdkPojo;
import com.ibm.cos.v2.core.client.config.SdkClientConfiguration;
import com.ibm.cos.v2.core.client.config.SdkClientOption;
import com.ibm.cos.v2.http.SdkHttpFullRequest;
import com.ibm.cos.v2.http.SdkHttpMethod;
import com.ibm.cos.v2.protocols.core.OperationInfo;
import com.ibm.cos.v2.protocols.core.ProtocolMarshaller;
import static org.assertj.core.api.Assertions.assertThat;

public class AWSQueryModeTest {

    private static final OperationInfo EMPTY_OPERATION_INFO = OperationInfo.builder()
                                                                           .httpMethod(SdkHttpMethod.POST)
                                                                           .hasImplicitPayloadMembers(true)
                                                                           .build();

    /*
     * A simple test POJO to marshall
     */
    private static final class TestPojo implements SdkPojo {

        private TestPojo() {}

        @Override
        public List<SdkField<?>> sdkFields() {
            return Collections.emptyList();
        }

        @Override
        public boolean equalsBySdkFields(Object other) {
            if (!(other instanceof TestPojo)) {
                return false;
            }
            return true;
        }

        @Override
        public Map<String, SdkField<?>> sdkFieldNameToField() {
            return Collections.emptyMap();
        }

    }

    @Test
    public void testMarshallWithAwsQueryCompatibleTrue() {
        SdkClientConfiguration clientConfig =
            SdkClientConfiguration.builder()
                                  .option(SdkClientOption.CLIENT_ENDPOINT_PROVIDER,
                                          ClientEndpointProvider.forEndpointOverride(URI.create("http://localhost")))
                                  .build();
        AwsJsonProtocolFactory factory =
            AwsJsonProtocolFactory.builder()
                                  .clientConfiguration(clientConfig)
                                  .protocolVersion("1.1")
                                  .protocol(AwsJsonProtocol.AWS_JSON)
                                  .hasAwsQueryCompatible(true)
                                  .build();

        ProtocolMarshaller<SdkHttpFullRequest> marshaller = factory.createProtocolMarshaller(EMPTY_OPERATION_INFO);
        SdkPojo testPojo = new TestPojo();

        SdkHttpFullRequest result = marshaller.marshall(testPojo);

        assertThat(result.headers()).containsKey("x-amzn-query-mode");
        assertThat(result.headers().get("x-amzn-query-mode").get(0)).isEqualTo("true");
    }

    @Test
    public void testMarshallWithNoAwsQueryCompatible() {
        SdkClientConfiguration clientConfig =
            SdkClientConfiguration.builder()
                                  .option(SdkClientOption.CLIENT_ENDPOINT_PROVIDER,
                                          ClientEndpointProvider.forEndpointOverride(URI.create("http://localhost")))
                                  .build();
        AwsJsonProtocolFactory factory =
            AwsJsonProtocolFactory.builder()
                                  .clientConfiguration(clientConfig)
                                  .protocolVersion("1.1")
                                  .protocol(AwsJsonProtocol.AWS_JSON)
                                  .build();

        ProtocolMarshaller<SdkHttpFullRequest> marshaller = factory.createProtocolMarshaller(EMPTY_OPERATION_INFO);
        SdkPojo testPojo = new TestPojo();

        SdkHttpFullRequest result = marshaller.marshall(testPojo);

        assertThat(result.headers()).doesNotContainKey("x-amzn-query-mode");
    }

}
