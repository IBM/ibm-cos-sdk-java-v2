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

package com.ibm.cos.v2.protocols.xml.internal.unmarshall;

import java.io.IOException;
import java.util.function.Function;
import com.ibm.cos.v2.annotations.SdkInternalApi;
import com.ibm.cos.v2.core.SdkPojo;
import com.ibm.cos.v2.core.SdkStandardLogger;
import com.ibm.cos.v2.core.http.HttpResponseHandler;
import com.ibm.cos.v2.core.interceptor.ExecutionAttributes;
import com.ibm.cos.v2.http.SdkHttpFullResponse;
import com.ibm.cos.v2.utils.Logger;

/**
 * Response handler for REST-XML services (Cloudfront, Route53, and S3).
 *
 * @param <T> Indicates the type being unmarshalled by this response handler.
 */
@SdkInternalApi
public final class XmlResponseHandler<T extends SdkPojo> implements HttpResponseHandler<T> {

    private static final Logger log = Logger.loggerFor(XmlResponseHandler.class);

    private final XmlProtocolUnmarshaller unmarshaller;
    private final Function<SdkHttpFullResponse, SdkPojo> pojoSupplier;
    private final boolean needsConnectionLeftOpen;

    public XmlResponseHandler(XmlProtocolUnmarshaller unmarshaller,
                              Function<SdkHttpFullResponse, SdkPojo> pojoSupplier,
                              boolean needsConnectionLeftOpen) {
        this.unmarshaller = unmarshaller;
        this.pojoSupplier = pojoSupplier;
        this.needsConnectionLeftOpen = needsConnectionLeftOpen;
    }

    @Override
    public T handle(SdkHttpFullResponse response, ExecutionAttributes executionAttributes) throws Exception {
        try {
            return unmarshallResponse(response);
        } finally {
            if (!needsConnectionLeftOpen) {
                closeStream(response);
            }
        }
    }

    private void closeStream(SdkHttpFullResponse response) {
        response.content().ifPresent(i -> {
            try {
                i.close();
            } catch (IOException e) {
                log.warn(() -> "Error closing HTTP content.", e);
            }
        });
    }

    @SuppressWarnings("unchecked")
    private T unmarshallResponse(SdkHttpFullResponse response) throws Exception {
        SdkStandardLogger.REQUEST_LOGGER.trace(() -> "Parsing service response XML.");
        T result = unmarshaller.unmarshall(pojoSupplier.apply(response), response);
        SdkStandardLogger.REQUEST_LOGGER.trace(() -> "Done parsing service response.");
        return result;
    }

    @Override
    public boolean needsConnectionLeftOpen() {
        return needsConnectionLeftOpen;
    }
}
