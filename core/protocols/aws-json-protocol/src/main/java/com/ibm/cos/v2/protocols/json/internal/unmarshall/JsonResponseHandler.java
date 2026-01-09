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

import static com.ibm.cos.v2.utils.Validate.paramNotNull;

import java.util.function.Function;
import com.ibm.cos.v2.annotations.SdkInternalApi;
import com.ibm.cos.v2.core.SdkPojo;
import com.ibm.cos.v2.core.SdkStandardLogger;
import com.ibm.cos.v2.core.http.HttpResponseHandler;
import com.ibm.cos.v2.core.interceptor.ExecutionAttributes;
import com.ibm.cos.v2.http.SdkHttpFullResponse;
import com.ibm.cos.v2.utils.FunctionalUtils;
import com.ibm.cos.v2.utils.IoUtils;

/**
 * Default implementation of HttpResponseHandler that handles a successful response from a
 * service and unmarshalls the result using a JSON unmarshaller.
 *
 * @param <T> Indicates the type being unmarshalled by this response handler.
 */
@SdkInternalApi
public final class JsonResponseHandler<T extends SdkPojo> implements HttpResponseHandler<T> {

    private final Function<SdkHttpFullResponse, SdkPojo> pojoSupplier;
    private final boolean needsConnectionLeftOpen;
    private final boolean isPayloadJson;
    /**
     * The JSON unmarshaller to use when handling the response
     */
    private JsonProtocolUnmarshaller unmarshaller;

    /**
     * Constructs a new response handler that will use the specified JSON unmarshaller to unmarshall
     * the service response and uses the specified response element path to find the root of the
     * business data in the service's response.
     *
     * @param unmarshaller    The JSON unmarshaller to use on the response.
     */
    public JsonResponseHandler(JsonProtocolUnmarshaller unmarshaller,
                               Function<SdkHttpFullResponse, SdkPojo> pojoSupplier,
                               boolean needsConnectionLeftOpen,
                               boolean isPayloadJson) {
        this.unmarshaller = paramNotNull(unmarshaller, "unmarshaller");
        this.pojoSupplier = pojoSupplier;

        this.needsConnectionLeftOpen = needsConnectionLeftOpen;
        this.isPayloadJson = isPayloadJson;

    }


    /**
     * @see HttpResponseHandler#handle(SdkHttpFullResponse, ExecutionAttributes)
     */
    @Override
    public T handle(SdkHttpFullResponse response, ExecutionAttributes executionAttributes) throws Exception {
        SdkStandardLogger.REQUEST_LOGGER.trace(() -> "Parsing service response JSON.");

        try {
            T result = unmarshaller.unmarshall(pojoSupplier.apply(response), response);

            // Make sure we read all the data to get an accurate CRC32 calculation.
            // See https://github.com/aws/ibm-cos-java-sdk/issues/1018
            if (shouldParsePayloadAsJson() && response.content().isPresent()) {
                IoUtils.drainInputStream(response.content().get());
            }

            SdkStandardLogger.REQUEST_LOGGER.trace(() -> "Done parsing service response.");
            return result;
        } finally {
            if (!needsConnectionLeftOpen) {
                response.content().ifPresent(i -> FunctionalUtils.invokeSafely(i::close));
            }
        }
    }

    @Override
    public boolean needsConnectionLeftOpen() {
        return needsConnectionLeftOpen;
    }

    /**
     * @return True if the payload will be parsed as JSON, false otherwise.
     */
    private boolean shouldParsePayloadAsJson() {
        return !needsConnectionLeftOpen && isPayloadJson;
    }

}
