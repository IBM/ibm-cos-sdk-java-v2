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

import static com.ibm.cos.v2.services.s3.internal.checksums.ChecksumConstant.ENABLE_CHECKSUM_REQUEST_HEADER;
import static com.ibm.cos.v2.services.s3.internal.checksums.ChecksumConstant.ENABLE_MD5_CHECKSUM_HEADER_VALUE;
import static com.ibm.cos.v2.services.s3.internal.checksums.ChecksumConstant.S3_MD5_CHECKSUM_LENGTH;
import static com.ibm.cos.v2.services.s3.internal.checksums.ChecksumsEnabledValidator.getObjectChecksumEnabledPerRequest;
import static com.ibm.cos.v2.services.s3.internal.checksums.ChecksumsEnabledValidator.getObjectChecksumEnabledPerResponse;

import com.ibm.cos.v2.annotations.SdkInternalApi;
import com.ibm.cos.v2.core.SdkRequest;
import com.ibm.cos.v2.core.SdkResponse;
import com.ibm.cos.v2.core.interceptor.Context;
import com.ibm.cos.v2.core.interceptor.ExecutionAttributes;
import com.ibm.cos.v2.core.interceptor.ExecutionInterceptor;
import com.ibm.cos.v2.http.SdkHttpRequest;
import com.ibm.cos.v2.http.SdkHttpResponse;
import com.ibm.cos.v2.services.s3.internal.s3express.S3ExpressUtils;
import com.ibm.cos.v2.services.s3.model.ChecksumMode;
import com.ibm.cos.v2.services.s3.model.GetObjectRequest;
import com.ibm.cos.v2.services.s3.model.GetObjectResponse;
import com.ibm.cos.v2.utils.Validate;

@SdkInternalApi
public final class EnableTrailingChecksumInterceptor implements ExecutionInterceptor {

    /**
     * Enable {@link ChecksumMode} for {@link GetObjectRequest} if trailing checksum is enabled from config,
     * {@link ChecksumMode} is disabled, and is S3Express.
     * TODO (s3express) - refactor to migrate out s3express specific code
     */
    @Override
    public SdkRequest modifyRequest(Context.ModifyRequest context, ExecutionAttributes executionAttributes) {

        SdkRequest request = context.request();
        if (getObjectChecksumEnabledPerRequest(request, executionAttributes)
            && S3ExpressUtils.useS3Express(executionAttributes)) {
            return ((GetObjectRequest) request).toBuilder().checksumMode(ChecksumMode.ENABLED).build();
        }
        return request;
    }

    /**
     * Append trailing checksum header for {@link GetObjectRequest} if trailing checksum is enabled from config,
     * {@link ChecksumMode} is disabled, and is not S3Express.
     */
    @Override
    public SdkHttpRequest modifyHttpRequest(Context.ModifyHttpRequest context,
                                            ExecutionAttributes executionAttributes) {

        if (getObjectChecksumEnabledPerRequest(context.request(), executionAttributes)
            && !S3ExpressUtils.useS3Express(executionAttributes)) {
            return context.httpRequest()
                          .toBuilder()
                          .putHeader(ENABLE_CHECKSUM_REQUEST_HEADER, ENABLE_MD5_CHECKSUM_HEADER_VALUE)
                          .build();
        }

        return context.httpRequest();
    }

    /**
     * Subtract the contentLength of {@link GetObjectResponse} if trailing checksums is enabled.
     */
    @Override
    public SdkResponse modifyResponse(Context.ModifyResponse context, ExecutionAttributes executionAttributes) {
        SdkResponse response = context.response();
        SdkHttpResponse httpResponse = context.httpResponse();

        if (getObjectChecksumEnabledPerResponse(context.request(), httpResponse, executionAttributes)) {
            GetObjectResponse getResponse = (GetObjectResponse) response;
            Long contentLength = getResponse.contentLength();
            Validate.notNull(contentLength, "Service returned null 'Content-Length'.");
            return getResponse.toBuilder()
                              .contentLength(contentLength - S3_MD5_CHECKSUM_LENGTH)
                              .build();
        }

        return response;
    }
}
