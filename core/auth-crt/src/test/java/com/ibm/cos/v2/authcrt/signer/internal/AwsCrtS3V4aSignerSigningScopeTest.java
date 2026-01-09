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

package com.ibm.cos.v2.authcrt.signer.internal;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;
import com.ibm.cos.v2.auth.signer.AwsSignerExecutionAttribute;
import com.ibm.cos.v2.authcrt.signer.AwsCrtS3V4aSigner;
import com.ibm.cos.v2.authcrt.signer.SignerTestUtils;
import com.ibm.cos.v2.authcrt.signer.SigningTestCase;
import com.ibm.cos.v2.core.interceptor.ExecutionAttributes;
import com.ibm.cos.v2.http.SdkHttpFullRequest;
import com.ibm.cos.v2.regions.RegionScope;

public class AwsCrtS3V4aSignerSigningScopeTest extends BaseSigningScopeTest {
    @Test
    public void signing_chunkedEncoding_regionalScope_present_overrides() {
        SigningTestCase testCase = SignerTestUtils.createBasicChunkedSigningTestCase();
        SdkHttpFullRequest signedRequest = signRequestWithScope(testCase, null, RegionScope.GLOBAL);

        String regionHeader = signedRequest.firstMatchingHeader("X-Amz-Region-Set").get();
        assertThat(regionHeader).isEqualTo(RegionScope.GLOBAL.id());
    }

    @Test
    public void testS3Presigning() {
        SigningTestCase testCase = SignerTestUtils.createBasicQuerySigningTestCase();

        SdkHttpFullRequest signedRequest = presignRequestWithScope(testCase, null, RegionScope.GLOBAL);

        List<String> regionHeader = signedRequest.rawQueryParameters().get("X-Amz-Region-Set");
        assertThat(regionHeader.get(0)).isEqualTo(RegionScope.GLOBAL.id());
    }


    protected SdkHttpFullRequest signRequestWithScope(SigningTestCase testCase, RegionScope defaultRegionScope,
                                                      RegionScope regionScope) {
        ExecutionAttributes executionAttributes = SignerTestUtils.buildBasicExecutionAttributes(testCase);
        if (regionScope != null) {
            executionAttributes.putAttribute(AwsSignerExecutionAttribute.SIGNING_REGION_SCOPE, regionScope);
        }
        SdkHttpFullRequest request = testCase.requestBuilder.build();
        return AwsCrtS3V4aSigner.builder().defaultRegionScope(defaultRegionScope).build().sign(request, executionAttributes);
    }

    protected SdkHttpFullRequest presignRequestWithScope(SigningTestCase testCase, RegionScope defaultRegionScope,
                                                         RegionScope regionScope) {
        ExecutionAttributes executionAttributes = SignerTestUtils.buildBasicExecutionAttributes(testCase);
        if (regionScope != null) {
            executionAttributes.putAttribute(AwsSignerExecutionAttribute.SIGNING_REGION_SCOPE, regionScope);
        }
        SdkHttpFullRequest request = testCase.requestBuilder.build();
        return AwsCrtS3V4aSigner.builder().defaultRegionScope(defaultRegionScope).build().presign(request, executionAttributes);
    }
}
