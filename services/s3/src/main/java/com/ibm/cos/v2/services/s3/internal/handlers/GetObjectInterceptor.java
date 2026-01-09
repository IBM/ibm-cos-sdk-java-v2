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

package com.ibm.cos.v2.services.s3.internal.handlers;

import java.util.Optional;
import java.util.regex.Pattern;
import com.ibm.cos.v2.annotations.SdkInternalApi;
import com.ibm.cos.v2.checksums.spi.ChecksumAlgorithm;
import com.ibm.cos.v2.core.SdkResponse;
import com.ibm.cos.v2.core.checksums.ChecksumSpecs;
import com.ibm.cos.v2.core.checksums.ChecksumValidation;
import com.ibm.cos.v2.core.interceptor.Context;
import com.ibm.cos.v2.core.interceptor.ExecutionAttributes;
import com.ibm.cos.v2.core.interceptor.ExecutionInterceptor;
import com.ibm.cos.v2.core.interceptor.SdkExecutionAttribute;
import com.ibm.cos.v2.core.internal.util.HttpChecksumUtils;
import com.ibm.cos.v2.http.SdkHttpResponse;
import com.ibm.cos.v2.services.s3.model.GetObjectRequest;
import com.ibm.cos.v2.services.s3.model.GetObjectResponse;
import com.ibm.cos.v2.utils.Pair;

/**
 * Interceptor for {@link GetObjectRequest} messages.
 */
@SdkInternalApi
public class GetObjectInterceptor implements ExecutionInterceptor {

    public static final Pattern MULTIPART_CHECKSUM_PATTERN = Pattern.compile(".*-\\d+$");

    @Override
    public void afterTransmission(Context.AfterTransmission context, ExecutionAttributes executionAttributes) {

        if (!(context.request() instanceof GetObjectRequest)) {
            return;
        }
        ChecksumSpecs resolvedChecksumSpecs = executionAttributes.getAttribute(SdkExecutionAttribute.RESOLVED_CHECKSUM_SPECS);

        if (HttpChecksumUtils.isHttpChecksumValidationEnabled(resolvedChecksumSpecs)) {
            Pair<ChecksumAlgorithm, String> algorithmChecksumValuePair =
                HttpChecksumUtils.getAlgorithmChecksumValuePair(context.httpResponse(), resolvedChecksumSpecs);

            // Multipart uploaded objects the received Checksum is the checksum of checksums of individual parts and part number.
            if (algorithmChecksumValuePair != null &&
                algorithmChecksumValuePair.right() != null &&
                MULTIPART_CHECKSUM_PATTERN.matcher(algorithmChecksumValuePair.right()).matches()) {
                executionAttributes.putAttribute(SdkExecutionAttribute.HTTP_RESPONSE_CHECKSUM_VALIDATION,
                                                 ChecksumValidation.FORCE_SKIP);
            }
        }
    }

    @Override
    public SdkResponse modifyResponse(Context.ModifyResponse context, ExecutionAttributes executionAttributes) {
        SdkResponse response = context.response();
        if (!(response instanceof GetObjectResponse)) {
            return response;
        }

        return fixContentRange(response, context.httpResponse());
    }

    /**
     * S3 currently returns content-range in two possible headers: Content-Range or x-amz-content-range based on the x-amz-te in
     * the request. This will check the x-amz-content-range if the modeled header (Content-Range) wasn't populated.
     */
    private SdkResponse fixContentRange(SdkResponse sdkResponse, SdkHttpResponse httpResponse) {
        // Use the modeled content range header, if the service returned it.
        GetObjectResponse getObjectResponse = (GetObjectResponse) sdkResponse;
        if (getObjectResponse.contentRange() != null) {
            return getObjectResponse;
        }

        // If the service didn't use the modeled content range header, check the x-amz-content-range header.
        Optional<String> xAmzContentRange = httpResponse.firstMatchingHeader("x-amz-content-range");
        if (!xAmzContentRange.isPresent()) {
            return getObjectResponse;
        }

        return getObjectResponse.copy(r -> r.contentRange(xAmzContentRange.get()));
    }
}
