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

package com.ibm.cos.v2.services.sts.endpoints.internal;

import java.net.URI;
import java.util.Arrays;
import java.util.concurrent.CompletableFuture;
import com.ibm.cos.v2.annotations.Generated;
import com.ibm.cos.v2.annotations.SdkInternalApi;
import com.ibm.cos.v2.awscore.endpoints.AwsEndpointAttribute;
import com.ibm.cos.v2.awscore.endpoints.authscheme.SigV4AuthScheme;
import com.ibm.cos.v2.core.exception.SdkClientException;
import com.ibm.cos.v2.endpoints.Endpoint;
import com.ibm.cos.v2.regions.Region;
import com.ibm.cos.v2.services.sts.endpoints.StsEndpointParams;
import com.ibm.cos.v2.services.sts.endpoints.StsEndpointProvider;
import com.ibm.cos.v2.utils.CompletableFutureUtils;
import com.ibm.cos.v2.utils.Validate;

@Generated("software.amazon.awssdk:codegen")
@SdkInternalApi
public final class DefaultStsEndpointProvider implements StsEndpointProvider {
    @Override
    public CompletableFuture<Endpoint> resolveEndpoint(StsEndpointParams params) {
        Validate.notNull(params.useDualStack(), "Parameter 'UseDualStack' must not be null");
        Validate.notNull(params.useFips(), "Parameter 'UseFIPS' must not be null");
        Validate.notNull(params.useGlobalEndpoint(), "Parameter 'UseGlobalEndpoint' must not be null");
        try {
            RuleResult result = endpointRule0(params, new LocalState(params.region()));
            if (result.canContinue()) {
                throw SdkClientException.create("Rule engine did not reach an error or endpoint result");
            }
            if (result.isError()) {
                String errorMsg = result.error();
                if (errorMsg.contains("Invalid ARN") && errorMsg.contains(":s3:::")) {
                    errorMsg += ". Use the bucket name instead of simple bucket ARNs in GetBucketLocationRequest.";
                }
                throw SdkClientException.create(errorMsg);
            }
            return CompletableFuture.completedFuture(result.endpoint());
        } catch (Exception error) {
            return CompletableFutureUtils.failedFuture(error);
        }
    }

    private static RuleResult endpointRule0(StsEndpointParams params, LocalState locals) {
        RuleResult result = endpointRule1(params, locals);
        if (result.isResolved()) {
            return result;
        }
        result = endpointRule19(params, locals);
        if (result.isResolved()) {
            return result;
        }
        result = endpointRule23(params, locals);
        if (result.isResolved()) {
            return result;
        }
        return endpointRule40(params, locals);
    }

    private static RuleResult endpointRule1(StsEndpointParams params, LocalState locals) {
        if (params.useGlobalEndpoint() && params.endpoint() == null && locals.region() != null) {
            RulePartition partitionResult = null;
            if ((partitionResult = RulesFunctions.awsPartition(locals.region())) != null) {
                locals = locals.toBuilder().partitionResult(partitionResult).build();
                if (!params.useFips() && !params.useDualStack()) {
                    RuleResult result = endpointRule2(params, locals);
                    if (result.isResolved()) {
                        return result;
                    }
                    result = endpointRule3(params, locals);
                    if (result.isResolved()) {
                        return result;
                    }
                    result = endpointRule4(params, locals);
                    if (result.isResolved()) {
                        return result;
                    }
                    result = endpointRule5(params, locals);
                    if (result.isResolved()) {
                        return result;
                    }
                    result = endpointRule6(params, locals);
                    if (result.isResolved()) {
                        return result;
                    }
                    result = endpointRule7(params, locals);
                    if (result.isResolved()) {
                        return result;
                    }
                    result = endpointRule8(params, locals);
                    if (result.isResolved()) {
                        return result;
                    }
                    result = endpointRule9(params, locals);
                    if (result.isResolved()) {
                        return result;
                    }
                    result = endpointRule10(params, locals);
                    if (result.isResolved()) {
                        return result;
                    }
                    result = endpointRule11(params, locals);
                    if (result.isResolved()) {
                        return result;
                    }
                    result = endpointRule12(params, locals);
                    if (result.isResolved()) {
                        return result;
                    }
                    result = endpointRule13(params, locals);
                    if (result.isResolved()) {
                        return result;
                    }
                    result = endpointRule14(params, locals);
                    if (result.isResolved()) {
                        return result;
                    }
                    result = endpointRule15(params, locals);
                    if (result.isResolved()) {
                        return result;
                    }
                    result = endpointRule16(params, locals);
                    if (result.isResolved()) {
                        return result;
                    }
                    result = endpointRule17(params, locals);
                    if (result.isResolved()) {
                        return result;
                    }
                    return endpointRule18(params, locals);
                }
            }
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule2(StsEndpointParams params, LocalState locals) {
        if ("ap-northeast-1".equals(locals.region())) {
            return RuleResult.endpoint(Endpoint
                                           .builder()
                                           .url(URI.create("https://sts.amazonaws.com"))
                                           .putAttribute(AwsEndpointAttribute.AUTH_SCHEMES,
                                                         Arrays.asList(SigV4AuthScheme.builder().signingName("sts").signingRegion("us-east-1").build()))
                                           .build());
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule3(StsEndpointParams params, LocalState locals) {
        if ("ap-south-1".equals(locals.region())) {
            return RuleResult.endpoint(Endpoint
                                           .builder()
                                           .url(URI.create("https://sts.amazonaws.com"))
                                           .putAttribute(AwsEndpointAttribute.AUTH_SCHEMES,
                                                         Arrays.asList(SigV4AuthScheme.builder().signingName("sts").signingRegion("us-east-1").build()))
                                           .build());
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule4(StsEndpointParams params, LocalState locals) {
        if ("ap-southeast-1".equals(locals.region())) {
            return RuleResult.endpoint(Endpoint
                                           .builder()
                                           .url(URI.create("https://sts.amazonaws.com"))
                                           .putAttribute(AwsEndpointAttribute.AUTH_SCHEMES,
                                                         Arrays.asList(SigV4AuthScheme.builder().signingName("sts").signingRegion("us-east-1").build()))
                                           .build());
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule5(StsEndpointParams params, LocalState locals) {
        if ("ap-southeast-2".equals(locals.region())) {
            return RuleResult.endpoint(Endpoint
                                           .builder()
                                           .url(URI.create("https://sts.amazonaws.com"))
                                           .putAttribute(AwsEndpointAttribute.AUTH_SCHEMES,
                                                         Arrays.asList(SigV4AuthScheme.builder().signingName("sts").signingRegion("us-east-1").build()))
                                           .build());
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule6(StsEndpointParams params, LocalState locals) {
        if ("aws-global".equals(locals.region())) {
            return RuleResult.endpoint(Endpoint
                                           .builder()
                                           .url(URI.create("https://sts.amazonaws.com"))
                                           .putAttribute(AwsEndpointAttribute.AUTH_SCHEMES,
                                                         Arrays.asList(SigV4AuthScheme.builder().signingName("sts").signingRegion("us-east-1").build()))
                                           .build());
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule7(StsEndpointParams params, LocalState locals) {
        if ("ca-central-1".equals(locals.region())) {
            return RuleResult.endpoint(Endpoint
                                           .builder()
                                           .url(URI.create("https://sts.amazonaws.com"))
                                           .putAttribute(AwsEndpointAttribute.AUTH_SCHEMES,
                                                         Arrays.asList(SigV4AuthScheme.builder().signingName("sts").signingRegion("us-east-1").build()))
                                           .build());
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule8(StsEndpointParams params, LocalState locals) {
        if ("eu-central-1".equals(locals.region())) {
            return RuleResult.endpoint(Endpoint
                                           .builder()
                                           .url(URI.create("https://sts.amazonaws.com"))
                                           .putAttribute(AwsEndpointAttribute.AUTH_SCHEMES,
                                                         Arrays.asList(SigV4AuthScheme.builder().signingName("sts").signingRegion("us-east-1").build()))
                                           .build());
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule9(StsEndpointParams params, LocalState locals) {
        if ("eu-north-1".equals(locals.region())) {
            return RuleResult.endpoint(Endpoint
                                           .builder()
                                           .url(URI.create("https://sts.amazonaws.com"))
                                           .putAttribute(AwsEndpointAttribute.AUTH_SCHEMES,
                                                         Arrays.asList(SigV4AuthScheme.builder().signingName("sts").signingRegion("us-east-1").build()))
                                           .build());
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule10(StsEndpointParams params, LocalState locals) {
        if ("eu-west-1".equals(locals.region())) {
            return RuleResult.endpoint(Endpoint
                                           .builder()
                                           .url(URI.create("https://sts.amazonaws.com"))
                                           .putAttribute(AwsEndpointAttribute.AUTH_SCHEMES,
                                                         Arrays.asList(SigV4AuthScheme.builder().signingName("sts").signingRegion("us-east-1").build()))
                                           .build());
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule11(StsEndpointParams params, LocalState locals) {
        if ("eu-west-2".equals(locals.region())) {
            return RuleResult.endpoint(Endpoint
                                           .builder()
                                           .url(URI.create("https://sts.amazonaws.com"))
                                           .putAttribute(AwsEndpointAttribute.AUTH_SCHEMES,
                                                         Arrays.asList(SigV4AuthScheme.builder().signingName("sts").signingRegion("us-east-1").build()))
                                           .build());
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule12(StsEndpointParams params, LocalState locals) {
        if ("eu-west-3".equals(locals.region())) {
            return RuleResult.endpoint(Endpoint
                                           .builder()
                                           .url(URI.create("https://sts.amazonaws.com"))
                                           .putAttribute(AwsEndpointAttribute.AUTH_SCHEMES,
                                                         Arrays.asList(SigV4AuthScheme.builder().signingName("sts").signingRegion("us-east-1").build()))
                                           .build());
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule13(StsEndpointParams params, LocalState locals) {
        if ("sa-east-1".equals(locals.region())) {
            return RuleResult.endpoint(Endpoint
                                           .builder()
                                           .url(URI.create("https://sts.amazonaws.com"))
                                           .putAttribute(AwsEndpointAttribute.AUTH_SCHEMES,
                                                         Arrays.asList(SigV4AuthScheme.builder().signingName("sts").signingRegion("us-east-1").build()))
                                           .build());
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule14(StsEndpointParams params, LocalState locals) {
        if ("us-east-1".equals(locals.region())) {
            return RuleResult.endpoint(Endpoint
                                           .builder()
                                           .url(URI.create("https://sts.amazonaws.com"))
                                           .putAttribute(AwsEndpointAttribute.AUTH_SCHEMES,
                                                         Arrays.asList(SigV4AuthScheme.builder().signingName("sts").signingRegion("us-east-1").build()))
                                           .build());
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule15(StsEndpointParams params, LocalState locals) {
        if ("us-east-2".equals(locals.region())) {
            return RuleResult.endpoint(Endpoint
                                           .builder()
                                           .url(URI.create("https://sts.amazonaws.com"))
                                           .putAttribute(AwsEndpointAttribute.AUTH_SCHEMES,
                                                         Arrays.asList(SigV4AuthScheme.builder().signingName("sts").signingRegion("us-east-1").build()))
                                           .build());
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule16(StsEndpointParams params, LocalState locals) {
        if ("us-west-1".equals(locals.region())) {
            return RuleResult.endpoint(Endpoint
                                           .builder()
                                           .url(URI.create("https://sts.amazonaws.com"))
                                           .putAttribute(AwsEndpointAttribute.AUTH_SCHEMES,
                                                         Arrays.asList(SigV4AuthScheme.builder().signingName("sts").signingRegion("us-east-1").build()))
                                           .build());
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule17(StsEndpointParams params, LocalState locals) {
        if ("us-west-2".equals(locals.region())) {
            return RuleResult.endpoint(Endpoint
                                           .builder()
                                           .url(URI.create("https://sts.amazonaws.com"))
                                           .putAttribute(AwsEndpointAttribute.AUTH_SCHEMES,
                                                         Arrays.asList(SigV4AuthScheme.builder().signingName("sts").signingRegion("us-east-1").build()))
                                           .build());
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule18(StsEndpointParams params, LocalState locals) {
        return RuleResult.endpoint(Endpoint
                                       .builder()
                                       .url(URI.create("https://sts." + locals.region() + "." + locals.partitionResult().dnsSuffix()))
                                       .putAttribute(AwsEndpointAttribute.AUTH_SCHEMES,
                                                     Arrays.asList(SigV4AuthScheme.builder().signingName("sts").signingRegion(locals.region()).build()))
                                       .build());
    }

    private static RuleResult endpointRule19(StsEndpointParams params, LocalState locals) {
        if (params.endpoint() != null) {
            RuleResult result = endpointRule20(params, locals);
            if (result.isResolved()) {
                return result;
            }
            result = endpointRule21(params, locals);
            if (result.isResolved()) {
                return result;
            }
            return endpointRule22(params, locals);
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule20(StsEndpointParams params, LocalState locals) {
        if (params.useFips()) {
            return RuleResult.error("Invalid Configuration: FIPS and custom endpoint are not supported");
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule21(StsEndpointParams params, LocalState locals) {
        if (params.useDualStack()) {
            return RuleResult.error("Invalid Configuration: Dualstack and custom endpoint are not supported");
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule22(StsEndpointParams params, LocalState locals) {
        return RuleResult.endpoint(Endpoint.builder().url(URI.create(params.endpoint())).build());
    }

    private static RuleResult endpointRule23(StsEndpointParams params, LocalState locals) {
        if (locals.region() != null) {
            return endpointRule24(params, locals);
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule24(StsEndpointParams params, LocalState locals) {
        RulePartition partitionResult = null;
        if ((partitionResult = RulesFunctions.awsPartition(locals.region())) != null) {
            locals = locals.toBuilder().partitionResult(partitionResult).build();
            RuleResult result = endpointRule25(params, locals);
            if (result.isResolved()) {
                return result;
            }
            result = endpointRule29(params, locals);
            if (result.isResolved()) {
                return result;
            }
            result = endpointRule34(params, locals);
            if (result.isResolved()) {
                return result;
            }
            result = endpointRule38(params, locals);
            if (result.isResolved()) {
                return result;
            }
            return endpointRule39(params, locals);
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule25(StsEndpointParams params, LocalState locals) {
        if (params.useFips() && params.useDualStack()) {
            RuleResult result = endpointRule26(params, locals);
            if (result.isResolved()) {
                return result;
            }
            return endpointRule28(params, locals);
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule26(StsEndpointParams params, LocalState locals) {
        if (locals.partitionResult().supportsFIPS() && locals.partitionResult().supportsDualStack()) {
            return endpointRule27(params, locals);
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule27(StsEndpointParams params, LocalState locals) {
        return RuleResult.endpoint(Endpoint.builder()
                                           .url(URI.create("https://sts-fips." + locals.region() + "." + locals.partitionResult().dualStackDnsSuffix()))
                                           .build());
    }

    private static RuleResult endpointRule28(StsEndpointParams params, LocalState locals) {
        return RuleResult.error("FIPS and DualStack are enabled, but this partition does not support one or both");
    }

    private static RuleResult endpointRule29(StsEndpointParams params, LocalState locals) {
        if (params.useFips()) {
            RuleResult result = endpointRule30(params, locals);
            if (result.isResolved()) {
                return result;
            }
            return endpointRule33(params, locals);
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule30(StsEndpointParams params, LocalState locals) {
        if (locals.partitionResult().supportsFIPS()) {
            RuleResult result = endpointRule31(params, locals);
            if (result.isResolved()) {
                return result;
            }
            return endpointRule32(params, locals);
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule31(StsEndpointParams params, LocalState locals) {
        if ("aws-us-gov".equals(locals.partitionResult().name())) {
            return RuleResult.endpoint(Endpoint.builder().url(URI.create("https://sts." + locals.region() + ".amazonaws.com"))
                                               .build());
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule32(StsEndpointParams params, LocalState locals) {
        return RuleResult.endpoint(Endpoint.builder()
                                           .url(URI.create("https://sts-fips." + locals.region() + "." + locals.partitionResult().dnsSuffix())).build());
    }

    private static RuleResult endpointRule33(StsEndpointParams params, LocalState locals) {
        return RuleResult.error("FIPS is enabled but this partition does not support FIPS");
    }

    private static RuleResult endpointRule34(StsEndpointParams params, LocalState locals) {
        if (params.useDualStack()) {
            RuleResult result = endpointRule35(params, locals);
            if (result.isResolved()) {
                return result;
            }
            return endpointRule37(params, locals);
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule35(StsEndpointParams params, LocalState locals) {
        if (locals.partitionResult().supportsDualStack()) {
            return endpointRule36(params, locals);
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule36(StsEndpointParams params, LocalState locals) {
        return RuleResult.endpoint(Endpoint.builder()
                                           .url(URI.create("https://sts." + locals.region() + "." + locals.partitionResult().dualStackDnsSuffix())).build());
    }

    private static RuleResult endpointRule37(StsEndpointParams params, LocalState locals) {
        return RuleResult.error("DualStack is enabled but this partition does not support DualStack");
    }

    private static RuleResult endpointRule38(StsEndpointParams params, LocalState locals) {
        if ("aws-global".equals(locals.region())) {
            return RuleResult.endpoint(Endpoint
                                           .builder()
                                           .url(URI.create("https://sts.amazonaws.com"))
                                           .putAttribute(AwsEndpointAttribute.AUTH_SCHEMES,
                                                         Arrays.asList(SigV4AuthScheme.builder().signingName("sts").signingRegion("us-east-1").build()))
                                           .build());
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule39(StsEndpointParams params, LocalState locals) {
        return RuleResult.endpoint(Endpoint.builder()
                                           .url(URI.create("https://sts." + locals.region() + "." + locals.partitionResult().dnsSuffix())).build());
    }

    private static RuleResult endpointRule40(StsEndpointParams params, LocalState locals) {
        return RuleResult.error("Invalid Configuration: Missing Region");
    }

    @Override
    public boolean equals(Object rhs) {
        return rhs != null && getClass().equals(rhs.getClass());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    private static final class LocalState {
        private final String region;

        private final RulePartition partitionResult;

        LocalState() {
            this.region = null;
            this.partitionResult = null;
        }

        LocalState(Region region) {
            if (region != null) {
                this.region = region.id();
            } else {
                this.region = null;
            }
            this.partitionResult = null;
        }

        LocalState(LocalStateBuilder builder) {
            this.region = builder.region;
            this.partitionResult = builder.partitionResult;
        }

        public String region() {
            return this.region;
        }

        public RulePartition partitionResult() {
            return this.partitionResult;
        }

        public LocalStateBuilder toBuilder() {
            return new LocalStateBuilder(this);
        }
    }

    private static final class LocalStateBuilder {
        private String region;

        private RulePartition partitionResult;

        LocalStateBuilder() {
            this.region = null;
            this.partitionResult = null;
        }

        LocalStateBuilder(LocalState locals) {
            this.region = locals.region;
            this.partitionResult = locals.partitionResult;
        }

        public LocalStateBuilder region(String value) {
            this.region = value;
            return this;
        }

        public LocalStateBuilder partitionResult(RulePartition value) {
            this.partitionResult = value;
            return this;
        }

        LocalState build() {
            return new LocalState(this);
        }
    }
}
