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

package com.ibm.cos.v2.awscore.checksum;

import java.io.ByteArrayInputStream;
import java.net.URI;
import java.util.Optional;
import org.junit.Test;
import com.ibm.cos.v2.auth.credentials.AwsBasicCredentials;
import com.ibm.cos.v2.auth.signer.Aws4Signer;
import com.ibm.cos.v2.auth.signer.AwsSignerExecutionAttribute;
import com.ibm.cos.v2.core.checksums.Algorithm;
import com.ibm.cos.v2.core.checksums.ChecksumSpecs;
import com.ibm.cos.v2.core.interceptor.ExecutionAttributes;
import com.ibm.cos.v2.core.interceptor.SdkExecutionAttribute;
import com.ibm.cos.v2.http.SdkHttpFullRequest;
import com.ibm.cos.v2.http.SdkHttpMethod;
import com.ibm.cos.v2.regions.Region;

import static org.assertj.core.api.Assertions.assertThat;

public class AwsSignerWithChecksumTest {

    final String headerName = "x-amz-checksum-sha256";
    final ChecksumSpecs SHA_256_HEADER = getCheckSum(Algorithm.SHA256, false, headerName);
    private final Aws4Signer signer = Aws4Signer.create();
    private final AwsBasicCredentials credentials = AwsBasicCredentials.create("access", "secret");

    @Test
    public void signingWithChecksumWithSha256ShouldHaveChecksumInHeaders() throws Exception {
        SdkHttpFullRequest.Builder request = generateBasicRequest("abc");
        ExecutionAttributes executionAttributes = getExecutionAttributes(SHA_256_HEADER);
        SdkHttpFullRequest signed = signer.sign(request.build(), executionAttributes);
        final Optional<String> checksumHeader = signed.firstMatchingHeader(headerName);
        assertThat(checksumHeader).hasValue("ungWv48Bz+pBQUDeXa4iI7ADYaOWF3qctBD/YfIAFa0=");
    }

    @Test
    public void signingWithNoChecksumHeaderAlgorithmShouldNotAddChecksumInHeaders() throws Exception {
        SdkHttpFullRequest.Builder request = generateBasicRequest("abc");
        ExecutionAttributes executionAttributes = getExecutionAttributes(null);
        SdkHttpFullRequest signed = signer.sign(request.build(), executionAttributes);
        assertThat(signed.firstMatchingHeader(headerName)).isNotPresent();
    }

    @Test
    public void signingWithNoChecksumShouldNotHaveChecksumInHeaders() throws Exception {
        SdkHttpFullRequest.Builder request = generateBasicRequest("abc");
        ExecutionAttributes executionAttributes = getExecutionAttributes(null);
        SdkHttpFullRequest signed = signer.sign(request.build(), executionAttributes);
        assertThat(signed.firstMatchingHeader(headerName)).isNotPresent();
    }

    private ExecutionAttributes getExecutionAttributes(ChecksumSpecs checksumSpecs) {
        ExecutionAttributes executionAttributes =
            ExecutionAttributes.builder()
                               .put(AwsSignerExecutionAttribute.AWS_CREDENTIALS, credentials)
                               .put(AwsSignerExecutionAttribute.SERVICE_SIGNING_NAME, "demo")
                               .put(AwsSignerExecutionAttribute.SIGNING_REGION, Region.of("us-east-1"))
                               .put(SdkExecutionAttribute.RESOLVED_CHECKSUM_SPECS, checksumSpecs)
                               .build();
        return executionAttributes;
    }

    private SdkHttpFullRequest.Builder generateBasicRequest(String stringInput) {
        return SdkHttpFullRequest.builder()
                                 .contentStreamProvider(() -> {
                                     return new ByteArrayInputStream(stringInput.getBytes());
                                 })
                                 .method(SdkHttpMethod.POST)
                                 .putHeader("Host", "demo.us-east-1.amazonaws.com")
                                 .putHeader("x-amz-archive-description", "test  test")
                                 .encodedPath("/")
                                 .uri(URI.create("http://demo.us-east-1.amazonaws.com"));
    }

    private ChecksumSpecs getCheckSum(Algorithm algorithm, boolean isStreamingRequest, String headerName) {
        return ChecksumSpecs.builder().algorithm(algorithm)
                            .isRequestStreaming(isStreamingRequest).headerName(headerName).build();
    }
}
