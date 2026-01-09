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

package com.ibm.cos.v2.services.kms.endpoints.internal;

import java.net.URI;
import java.util.concurrent.CompletableFuture;
import com.ibm.cos.v2.annotations.Generated;
import com.ibm.cos.v2.annotations.SdkInternalApi;
import com.ibm.cos.v2.core.exception.SdkClientException;
import com.ibm.cos.v2.endpoints.Endpoint;
import com.ibm.cos.v2.regions.Region;
import com.ibm.cos.v2.services.kms.endpoints.KmsEndpointParams;
import com.ibm.cos.v2.services.kms.endpoints.KmsEndpointProvider;
import com.ibm.cos.v2.utils.CompletableFutureUtils;
import com.ibm.cos.v2.utils.Validate;

@Generated("com.ibm.cos.v2:codegen")
@SdkInternalApi
public final class DefaultKmsEndpointProvider implements KmsEndpointProvider {
    @Override
    public CompletableFuture<Endpoint> resolveEndpoint(KmsEndpointParams params) {
        Validate.notNull(params.useDualStack(), "Parameter 'UseDualStack' must not be null");
        Validate.notNull(params.useFips(), "Parameter 'UseFIPS' must not be null");
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

    private static RuleResult endpointRule0(KmsEndpointParams params, LocalState locals) {
        RuleResult result = endpointRule1(params, locals);
        if (result.isResolved()) {
            return result;
        }
        result = endpointRule5(params, locals);
        if (result.isResolved()) {
            return result;
        }
        return endpointRule20(params, locals);
    }

    private static RuleResult endpointRule1(KmsEndpointParams params, LocalState locals) {
        if (params.endpoint() != null) {
            RuleResult result = endpointRule2(params, locals);
            if (result.isResolved()) {
                return result;
            }
            result = endpointRule3(params, locals);
            if (result.isResolved()) {
                return result;
            }
            return endpointRule4(params, locals);
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule2(KmsEndpointParams params, LocalState locals) {
        if (params.useFips()) {
            return RuleResult.error("Invalid Configuration: FIPS and custom endpoint are not supported");
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule3(KmsEndpointParams params, LocalState locals) {
        if (params.useDualStack()) {
            return RuleResult.error("Invalid Configuration: Dualstack and custom endpoint are not supported");
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule4(KmsEndpointParams params, LocalState locals) {
        return RuleResult.endpoint(Endpoint.builder().url(URI.create(params.endpoint())).build());
    }

    private static RuleResult endpointRule5(KmsEndpointParams params, LocalState locals) {
        if (locals.region() != null) {
            return endpointRule6(params, locals);
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule6(KmsEndpointParams params, LocalState locals) {
        RulePartition partitionResult = null;
        if ((partitionResult = RulesFunctions.awsPartition(locals.region())) != null) {
            locals = locals.toBuilder().partitionResult(partitionResult).build();
            RuleResult result = endpointRule7(params, locals);
            if (result.isResolved()) {
                return result;
            }
            result = endpointRule11(params, locals);
            if (result.isResolved()) {
                return result;
            }
            result = endpointRule15(params, locals);
            if (result.isResolved()) {
                return result;
            }
            return endpointRule19(params, locals);
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule7(KmsEndpointParams params, LocalState locals) {
        if (params.useFips() && params.useDualStack()) {
            RuleResult result = endpointRule8(params, locals);
            if (result.isResolved()) {
                return result;
            }
            return endpointRule10(params, locals);
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule8(KmsEndpointParams params, LocalState locals) {
        if (locals.partitionResult().supportsFIPS() && locals.partitionResult().supportsDualStack()) {
            return endpointRule9(params, locals);
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule9(KmsEndpointParams params, LocalState locals) {
        return RuleResult.endpoint(Endpoint.builder()
                .url(URI.create("https://kms-fips." + locals.region() + "." + locals.partitionResult().dualStackDnsSuffix()))
                .build());
    }

    private static RuleResult endpointRule10(KmsEndpointParams params, LocalState locals) {
        return RuleResult.error("FIPS and DualStack are enabled, but this partition does not support one or both");
    }

    private static RuleResult endpointRule11(KmsEndpointParams params, LocalState locals) {
        if (params.useFips()) {
            RuleResult result = endpointRule12(params, locals);
            if (result.isResolved()) {
                return result;
            }
            return endpointRule14(params, locals);
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule12(KmsEndpointParams params, LocalState locals) {
        if (locals.partitionResult().supportsFIPS()) {
            return endpointRule13(params, locals);
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule13(KmsEndpointParams params, LocalState locals) {
        return RuleResult.endpoint(Endpoint.builder()
                .url(URI.create("https://kms-fips." + locals.region() + "." + locals.partitionResult().dnsSuffix())).build());
    }

    private static RuleResult endpointRule14(KmsEndpointParams params, LocalState locals) {
        return RuleResult.error("FIPS is enabled but this partition does not support FIPS");
    }

    private static RuleResult endpointRule15(KmsEndpointParams params, LocalState locals) {
        if (params.useDualStack()) {
            RuleResult result = endpointRule16(params, locals);
            if (result.isResolved()) {
                return result;
            }
            return endpointRule18(params, locals);
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule16(KmsEndpointParams params, LocalState locals) {
        if (locals.partitionResult().supportsDualStack()) {
            return endpointRule17(params, locals);
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule17(KmsEndpointParams params, LocalState locals) {
        return RuleResult.endpoint(Endpoint.builder()
                .url(URI.create("https://kms." + locals.region() + "." + locals.partitionResult().dualStackDnsSuffix())).build());
    }

    private static RuleResult endpointRule18(KmsEndpointParams params, LocalState locals) {
        return RuleResult.error("DualStack is enabled but this partition does not support DualStack");
    }

    private static RuleResult endpointRule19(KmsEndpointParams params, LocalState locals) {
        return RuleResult.endpoint(Endpoint.builder()
                .url(URI.create("https://kms." + locals.region() + "." + locals.partitionResult().dnsSuffix())).build());
    }

    private static RuleResult endpointRule20(KmsEndpointParams params, LocalState locals) {
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
