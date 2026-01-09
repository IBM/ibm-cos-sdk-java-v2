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

package com.ibm.cos.v2.protocols.json.internal.unmarshall;

import java.util.Map;
import com.ibm.cos.v2.annotations.SdkInternalApi;
import com.ibm.cos.v2.core.protocol.MarshallLocation;
import com.ibm.cos.v2.core.protocol.MarshallingType;
import com.ibm.cos.v2.core.traits.TimestampFormatTrait;
import com.ibm.cos.v2.protocols.jsoncore.JsonNode;
import com.ibm.cos.v2.protocols.jsoncore.JsonValueNodeFactory;
import com.ibm.cos.v2.thirdparty.jackson.core.JsonFactory;

@SdkInternalApi
public interface ProtocolUnmarshallDependencies {

    /**
     * Used for unmarshalling. This registry is used to lookup an unmarshaller for a given location and marshalling type.
     * @see JsonUnmarshaller
     * @see JsonUnmarshallerContext#getUnmarshaller(MarshallLocation, MarshallingType)
     */
    JsonUnmarshallerRegistry jsonUnmarshallerRegistry();

    /**
     * Used for parsing. This factory knows how to convert the state of the parser into {@link JsonNode} instances that are
     * used during unmarshalling.
     */
    JsonValueNodeFactory nodeValueFactory();

    /**
     * Used to expose this data through the interface.
     */
    Map<MarshallLocation, TimestampFormatTrait.Format> timestampFormats();

    /**
     * Used to parse JSON using Jackson.
     */
    JsonFactory jsonFactory();
}
