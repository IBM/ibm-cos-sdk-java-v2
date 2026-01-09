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

package com.ibm.cos.v2.protocols.json.internal;

import com.ibm.cos.v2.annotations.SdkInternalApi;
import com.ibm.cos.v2.protocols.json.BaseAwsStructuredJsonFactory;
import com.ibm.cos.v2.protocols.json.SdkJsonGenerator;
import com.ibm.cos.v2.protocols.json.StructuredJsonGenerator;
import com.ibm.cos.v2.thirdparty.jackson.core.JsonFactory;
import com.ibm.cos.v2.thirdparty.jackson.core.StreamReadFeature;
import com.ibm.cos.v2.thirdparty.jackson.core.StreamWriteFeature;

/**
 * Creates generators and protocol handlers for plain text JSON wire format.
 */
@SdkInternalApi
public final class AwsStructuredPlainJsonFactory {

    /**
     * Recommended to share JsonFactory instances per http://wiki.fasterxml.com/JacksonBestPracticesPerformance
     */
    private static final JsonFactory JSON_FACTORY = JsonFactory.builder()
                                                               .enable(StreamReadFeature.USE_FAST_BIG_NUMBER_PARSER)
                                                               .enable(StreamReadFeature.USE_FAST_DOUBLE_PARSER)
                                                               .enable(StreamWriteFeature.USE_FAST_DOUBLE_WRITER)
                                                               .build();

    public static final BaseAwsStructuredJsonFactory SDK_JSON_FACTORY = new BaseAwsStructuredJsonFactory(JSON_FACTORY) {
        @Override
        protected StructuredJsonGenerator createWriter(JsonFactory jsonFactory,
                                                       String contentType) {
            return new SdkJsonGenerator(jsonFactory, contentType);
        }

        @Override
        public JsonFactory getJsonFactory() {
            return JSON_FACTORY;
        }
    };

    protected AwsStructuredPlainJsonFactory() {
    }
}
