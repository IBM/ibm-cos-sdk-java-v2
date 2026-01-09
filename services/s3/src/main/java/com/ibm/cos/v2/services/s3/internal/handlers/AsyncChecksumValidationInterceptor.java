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
import static com.ibm.cos.v2.services.s3.internal.checksums.ChecksumsEnabledValidator.CHECKSUM;
import static com.ibm.cos.v2.services.s3.internal.checksums.ChecksumsEnabledValidator.getObjectChecksumEnabledPerResponse;

import java.nio.ByteBuffer;
import java.util.Optional;
import org.reactivestreams.Publisher;
import com.ibm.cos.v2.annotations.SdkInternalApi;
import com.ibm.cos.v2.core.checksums.Md5Checksum;
import com.ibm.cos.v2.core.checksums.SdkChecksum;
import com.ibm.cos.v2.core.interceptor.Context;
import com.ibm.cos.v2.core.interceptor.ExecutionAttributes;
import com.ibm.cos.v2.core.interceptor.ExecutionInterceptor;
import com.ibm.cos.v2.services.s3.internal.checksums.S3ChecksumValidatingPublisher;

@SdkInternalApi
public final class AsyncChecksumValidationInterceptor implements ExecutionInterceptor {

    @Override
    public Optional<Publisher<ByteBuffer>> modifyAsyncHttpResponseContent(Context.ModifyHttpResponse context,
                                                                          ExecutionAttributes executionAttributes) {
        if (getObjectChecksumEnabledPerResponse(context.request(), context.httpResponse(), executionAttributes)
            && context.responsePublisher().isPresent()) {
            long contentLength = context.httpResponse()
                                        .firstMatchingHeader(CONTENT_LENGTH_HEADER)
                                        .map(Long::parseLong)
                                        .orElse(0L);

            SdkChecksum checksum = new Md5Checksum();
            executionAttributes.putAttribute(CHECKSUM, checksum);
            if (contentLength > 0) {
                return Optional.of(new S3ChecksumValidatingPublisher(context.responsePublisher().get(), checksum, contentLength));
            }
        }

        return context.responsePublisher();
    }
}
