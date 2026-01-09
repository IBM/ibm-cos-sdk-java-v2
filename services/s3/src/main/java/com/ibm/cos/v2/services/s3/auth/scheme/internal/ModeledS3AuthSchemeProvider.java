/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"). You may not use this file except in compliance with
 * the License. A copy of the License is located at
 * 
 * http://aws.amazon.com/apache2.0
 * 
 * or in the "license" file accompanying this file. This file is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR
 * CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions
 * and limitations under the License.
 */

package com.ibm.cos.v2.services.s3.auth.scheme.internal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import com.ibm.cos.v2.annotations.Generated;
import com.ibm.cos.v2.annotations.SdkInternalApi;
import com.ibm.cos.v2.http.auth.aws.signer.AwsV4HttpSigner;
import com.ibm.cos.v2.http.auth.spi.scheme.AuthSchemeOption;
import com.ibm.cos.v2.services.s3.auth.scheme.S3AuthSchemeParams;
import com.ibm.cos.v2.services.s3.auth.scheme.S3AuthSchemeProvider;

@Generated("com.ibm.cos.v2:codegen")
@SdkInternalApi
public final class ModeledS3AuthSchemeProvider implements S3AuthSchemeProvider {
    private static final ModeledS3AuthSchemeProvider DEFAULT = new ModeledS3AuthSchemeProvider();

    private ModeledS3AuthSchemeProvider() {
    }

    public static ModeledS3AuthSchemeProvider create() {
        return DEFAULT;
    }

    @Override
    public List<AuthSchemeOption> resolveAuthScheme(S3AuthSchemeParams params) {
        List<AuthSchemeOption> options = new ArrayList<>();
        switch (params.operation()) {
        case "UploadPart":
        case "PutObject":
            options.add(AuthSchemeOption.builder().schemeId("aws.auth#sigv4")
                    .putSignerProperty(AwsV4HttpSigner.SERVICE_SIGNING_NAME, "s3")
                    .putSignerProperty(AwsV4HttpSigner.REGION_NAME, params.region().id())
                    .putSignerProperty(AwsV4HttpSigner.PAYLOAD_SIGNING_ENABLED, false)
                    .putSignerProperty(AwsV4HttpSigner.DOUBLE_URL_ENCODE, false)
                    .putSignerProperty(AwsV4HttpSigner.NORMALIZE_PATH, false)
                    .putSignerProperty(AwsV4HttpSigner.CHUNK_ENCODING_ENABLED, true).build());
            break;
        default:
            options.add(AuthSchemeOption.builder().schemeId("aws.auth#sigv4")
                    .putSignerProperty(AwsV4HttpSigner.SERVICE_SIGNING_NAME, "s3")
                    .putSignerProperty(AwsV4HttpSigner.REGION_NAME, params.region().id())
                    .putSignerProperty(AwsV4HttpSigner.PAYLOAD_SIGNING_ENABLED, false)
                    .putSignerProperty(AwsV4HttpSigner.DOUBLE_URL_ENCODE, false)
                    .putSignerProperty(AwsV4HttpSigner.NORMALIZE_PATH, false).build());
            break;
        }
        return Collections.unmodifiableList(options);
    }
}
