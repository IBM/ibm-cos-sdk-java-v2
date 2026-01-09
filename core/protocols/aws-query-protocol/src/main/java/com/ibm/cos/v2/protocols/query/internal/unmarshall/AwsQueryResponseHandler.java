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

package com.ibm.cos.v2.protocols.query.internal.unmarshall;

import static com.ibm.cos.v2.awscore.util.AwsHeader.AWS_REQUEST_ID;

import java.io.IOException;
import java.util.Map;
import java.util.function.Function;
import com.ibm.cos.v2.annotations.SdkInternalApi;
import com.ibm.cos.v2.awscore.AwsResponse;
import com.ibm.cos.v2.awscore.AwsResponseMetadata;
import com.ibm.cos.v2.awscore.DefaultAwsResponseMetadata;
import com.ibm.cos.v2.core.SdkPojo;
import com.ibm.cos.v2.core.SdkStandardLogger;
import com.ibm.cos.v2.core.http.HttpResponseHandler;
import com.ibm.cos.v2.core.interceptor.ExecutionAttributes;
import com.ibm.cos.v2.http.SdkHttpFullResponse;
import com.ibm.cos.v2.http.SdkHttpResponse;
import com.ibm.cos.v2.utils.Logger;
import com.ibm.cos.v2.utils.Pair;

/**
 * Response handler for AWS/Query services and Amazon EC2 which is a dialect of the Query protocol.
 *
 * @param <T> Indicates the type being unmarshalled by this response handler.
 */
@SdkInternalApi
public final class AwsQueryResponseHandler<T extends AwsResponse> implements HttpResponseHandler<T> {

    private static final Logger log = Logger.loggerFor(AwsQueryResponseHandler.class);

    private final QueryProtocolUnmarshaller unmarshaller;
    private final Function<SdkHttpFullResponse, SdkPojo> pojoSupplier;


    public AwsQueryResponseHandler(QueryProtocolUnmarshaller unmarshaller,
                                   Function<SdkHttpFullResponse, SdkPojo> pojoSupplier) {
        this.unmarshaller = unmarshaller;
        this.pojoSupplier = pojoSupplier;
    }

    @Override
    public T handle(SdkHttpFullResponse response, ExecutionAttributes executionAttributes) throws Exception {
        try {
            return unmarshallResponse(response);
        } finally {
            response.content().ifPresent(i -> {
                try {
                    i.close();
                } catch (IOException e) {
                    log.warn(() -> "Error closing HTTP content.", e);
                }
            });
        }
    }

    @SuppressWarnings("unchecked")
    private T unmarshallResponse(SdkHttpFullResponse response) throws Exception {
        SdkStandardLogger.REQUEST_LOGGER.trace(() -> "Parsing service response XML.");
        Pair<T, Map<String, String>> result = unmarshaller.unmarshall(pojoSupplier.apply(response), response);
        SdkStandardLogger.REQUEST_LOGGER.trace(() -> "Done parsing service response.");
        AwsResponseMetadata responseMetadata = generateResponseMetadata(response, result.right());
        return (T) result.left().toBuilder().responseMetadata(responseMetadata).build();
    }

    /**
     * Create the default {@link AwsResponseMetadata}. This might be wrapped by a service
     * specific metadata object to provide modeled access to additional metadata. (See S3 and Kinesis).
     */
    private AwsResponseMetadata generateResponseMetadata(SdkHttpResponse response, Map<String, String> metadata) {
        if (!metadata.containsKey(AWS_REQUEST_ID)) {
            metadata.put(AWS_REQUEST_ID, response.firstMatchingHeader(X_AMZN_REQUEST_ID_HEADERS).orElse(null));
        }

        response.forEachHeader((key, value) -> metadata.put(key, value.get(0)));
        return DefaultAwsResponseMetadata.create(metadata);
    }

    @Override
    public boolean needsConnectionLeftOpen() {
        // Query doesn't support streaming so this is always false
        return false;
    }

}
