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

import static com.ibm.cos.v2.services.s3.internal.checksums.ChecksumConstant.CONTENT_LENGTH_HEADER;
import static com.ibm.cos.v2.services.s3.internal.checksums.ChecksumsEnabledValidator.getObjectChecksumEnabledPerResponse;

import java.io.InputStream;
import java.util.Optional;
import com.ibm.cos.v2.annotations.SdkInternalApi;
import com.ibm.cos.v2.core.checksums.Md5Checksum;
import com.ibm.cos.v2.core.checksums.SdkChecksum;
import com.ibm.cos.v2.core.interceptor.Context;
import com.ibm.cos.v2.core.interceptor.ExecutionAttributes;
import com.ibm.cos.v2.core.interceptor.ExecutionInterceptor;
import com.ibm.cos.v2.services.s3.internal.checksums.S3ChecksumValidatingInputStream;

@SdkInternalApi
public final class SyncChecksumValidationInterceptor implements ExecutionInterceptor {

    @Override
    public Optional<InputStream> modifyHttpResponseContent(Context.ModifyHttpResponse context,
                                                           ExecutionAttributes executionAttributes) {
        if (getObjectChecksumEnabledPerResponse(context.request(), context.httpResponse(), executionAttributes)
            && context.responseBody().isPresent()) {

            SdkChecksum checksum = new Md5Checksum();

            long contentLength = context.httpResponse()
                                        .firstMatchingHeader(CONTENT_LENGTH_HEADER)
                                        .map(Long::parseLong)
                                        .orElse(0L);

            if (contentLength > 0) {
                return Optional.of(new S3ChecksumValidatingInputStream(context.responseBody().get(), checksum, contentLength));
            }
        }

        return context.responseBody();
    }
}
