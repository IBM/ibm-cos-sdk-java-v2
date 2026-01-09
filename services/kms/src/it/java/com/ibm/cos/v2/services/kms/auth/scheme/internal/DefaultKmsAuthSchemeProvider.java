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

package com.ibm.cos.v2.services.kms.auth.scheme.internal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import com.ibm.cos.v2.annotations.Generated;
import com.ibm.cos.v2.annotations.SdkInternalApi;
import com.ibm.cos.v2.http.auth.aws.signer.AwsV4HttpSigner;
import com.ibm.cos.v2.http.auth.spi.scheme.AuthSchemeOption;
import com.ibm.cos.v2.services.kms.auth.scheme.KmsAuthSchemeParams;
import com.ibm.cos.v2.services.kms.auth.scheme.KmsAuthSchemeProvider;

@Generated("com.ibm.cos.v2:codegen")
@SdkInternalApi
public final class DefaultKmsAuthSchemeProvider implements KmsAuthSchemeProvider {
    private static final DefaultKmsAuthSchemeProvider DEFAULT = new DefaultKmsAuthSchemeProvider();

    private DefaultKmsAuthSchemeProvider() {
    }

    public static DefaultKmsAuthSchemeProvider create() {
        return DEFAULT;
    }

    @Override
    public List<AuthSchemeOption> resolveAuthScheme(KmsAuthSchemeParams params) {
        List<AuthSchemeOption> options = new ArrayList<>();
        options.add(AuthSchemeOption.builder().schemeId("aws.auth#sigv4")
                .putSignerProperty(AwsV4HttpSigner.SERVICE_SIGNING_NAME, "kms")
                .putSignerProperty(AwsV4HttpSigner.REGION_NAME, params.region().id()).build());
        return Collections.unmodifiableList(options);
    }
}
