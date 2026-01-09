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

package com.ibm.cos.v2.services.sts.auth.scheme.internal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import com.ibm.cos.v2.annotations.Generated;
import com.ibm.cos.v2.annotations.SdkInternalApi;
import com.ibm.cos.v2.http.auth.aws.signer.AwsV4HttpSigner;
import com.ibm.cos.v2.http.auth.spi.scheme.AuthSchemeOption;
import com.ibm.cos.v2.services.sts.auth.scheme.StsAuthSchemeParams;
import com.ibm.cos.v2.services.sts.auth.scheme.StsAuthSchemeProvider;

@Generated("com.ibm.cos.v2:codegen")
@SdkInternalApi
public final class DefaultStsAuthSchemeProvider implements StsAuthSchemeProvider {
    private static final DefaultStsAuthSchemeProvider DEFAULT = new DefaultStsAuthSchemeProvider();

    private DefaultStsAuthSchemeProvider() {
    }

    public static DefaultStsAuthSchemeProvider create() {
        return DEFAULT;
    }

    @Override
    public List<AuthSchemeOption> resolveAuthScheme(StsAuthSchemeParams params) {
        List<AuthSchemeOption> options = new ArrayList<>();
        options.add(AuthSchemeOption.builder().schemeId("aws.auth#sigv4")
                .putSignerProperty(AwsV4HttpSigner.SERVICE_SIGNING_NAME, "sts")
                .putSignerProperty(AwsV4HttpSigner.REGION_NAME, params.region().id()).build());
        return Collections.unmodifiableList(options);
    }
}
