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

package com.ibm.cos.v2.auth.signer;

import static com.ibm.cos.v2.http.auth.aws.internal.signer.util.SignerConstant.X_AMZ_CONTENT_SHA256;

import com.ibm.cos.v2.annotations.SdkPublicApi;
import com.ibm.cos.v2.auth.signer.params.Aws4SignerParams;
import com.ibm.cos.v2.core.checksums.SdkChecksum;
import com.ibm.cos.v2.core.interceptor.ExecutionAttributes;
import com.ibm.cos.v2.http.SdkHttpFullRequest;
import com.ibm.cos.v2.auth.signer.internal.BaseAws4Signer;

@SdkPublicApi
public class Aws4UnsignedPayloadSigner extends BaseAws4Signer {
    public static final String UNSIGNED_PAYLOAD = "UNSIGNED-PAYLOAD";

    private Aws4UnsignedPayloadSigner() {
    }

    public static Aws4UnsignedPayloadSigner create() {
        return new Aws4UnsignedPayloadSigner();
    }

    public SdkHttpFullRequest sign(SdkHttpFullRequest request, ExecutionAttributes executionAttributes) {
        request = this.addContentSha256Header(request);
        return super.sign(request, executionAttributes);
    }

    public SdkHttpFullRequest sign(SdkHttpFullRequest request, Aws4SignerParams signingParams) {
        request = this.addContentSha256Header(request);
        return super.sign(request, signingParams);
    }

    protected String calculateContentHash(SdkHttpFullRequest.Builder mutableRequest, Aws4SignerParams signerParams, SdkChecksum contentFlexibleChecksum) {
        return "https".equals(mutableRequest.protocol()) ? "UNSIGNED-PAYLOAD" : super.calculateContentHash(mutableRequest, signerParams, contentFlexibleChecksum);
    }

    private SdkHttpFullRequest addContentSha256Header(SdkHttpFullRequest request) {
        return request.toBuilder().putHeader(X_AMZ_CONTENT_SHA256, "required").build();
    }
}