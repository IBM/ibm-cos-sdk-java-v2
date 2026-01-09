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

package com.ibm.cos.v2.services.s3.endpoints.internal;

import java.net.URI;
import java.util.Arrays;
import java.util.concurrent.CompletableFuture;
import com.ibm.cos.v2.annotations.Generated;
import com.ibm.cos.v2.annotations.SdkInternalApi;
import com.ibm.cos.v2.awscore.endpoints.AwsEndpointAttribute;
import com.ibm.cos.v2.awscore.endpoints.authscheme.SigV4AuthScheme;
import com.ibm.cos.v2.awscore.endpoints.authscheme.SigV4aAuthScheme;
import com.ibm.cos.v2.core.exception.SdkClientException;
import com.ibm.cos.v2.endpoints.Endpoint;
import com.ibm.cos.v2.regions.Region;
import com.ibm.cos.v2.services.s3.endpoints.S3EndpointParams;
import com.ibm.cos.v2.services.s3.endpoints.S3EndpointProvider;
import com.ibm.cos.v2.services.s3.endpoints.authscheme.S3ExpressEndpointAuthScheme;
import com.ibm.cos.v2.utils.CompletableFutureUtils;
import com.ibm.cos.v2.utils.Validate;

@Generated("com.ibm.cos.v2:codegen")
@SdkInternalApi
public final class DefaultS3EndpointProvider implements S3EndpointProvider {
    @Override
    public CompletableFuture<Endpoint> resolveEndpoint(S3EndpointParams params) {
        Validate.notNull(params.useFips(), "Parameter 'UseFIPS' must not be null");
        Validate.notNull(params.useDualStack(), "Parameter 'UseDualStack' must not be null");
        Validate.notNull(params.forcePathStyle(), "Parameter 'ForcePathStyle' must not be null");
        Validate.notNull(params.accelerate(), "Parameter 'Accelerate' must not be null");
        Validate.notNull(params.useGlobalEndpoint(), "Parameter 'UseGlobalEndpoint' must not be null");
        Validate.notNull(params.disableMultiRegionAccessPoints(), "Parameter 'DisableMultiRegionAccessPoints' must not be null");
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

    private static RuleResult endpointRule0(S3EndpointParams params, LocalState locals) {
        RuleResult result = endpointRule1(params, locals);
        if (result.isResolved()) {
            return result;
        }
        return endpointRule343(params, locals);
    }

    private static RuleResult endpointRule1(S3EndpointParams params, LocalState locals) {
        if (locals.region() != null) {
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
            result = endpointRule65(params, locals);
            if (result.isResolved()) {
                return result;
            }
            result = endpointRule118(params, locals);
            if (result.isResolved()) {
                return result;
            }
            result = endpointRule123(params, locals);
            if (result.isResolved()) {
                return result;
            }
            result = endpointRule137(params, locals);
            if (result.isResolved()) {
                return result;
            }
            result = endpointRule308(params, locals);
            if (result.isResolved()) {
                return result;
            }
            return endpointRule317(params, locals);
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule2(S3EndpointParams params, LocalState locals) {
        if (params.accelerate() && params.useFips()) {
            return RuleResult.error("Accelerate cannot be used with FIPS");
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule3(S3EndpointParams params, LocalState locals) {
        if (params.useDualStack() && params.endpoint() != null) {
            return RuleResult.error("Cannot set dual-stack in combination with a custom endpoint.");
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule4(S3EndpointParams params, LocalState locals) {
        if (params.endpoint() != null && params.useFips()) {
            return RuleResult.error("A custom endpoint cannot be combined with FIPS");
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule5(S3EndpointParams params, LocalState locals) {
        if (params.endpoint() != null && params.accelerate()) {
            return RuleResult.error("A custom endpoint cannot be combined with S3 Accelerate");
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule6(S3EndpointParams params, LocalState locals) {
        if (params.useFips()) {
            RulePartition partitionResult = null;
            if ((partitionResult = RulesFunctions.awsPartition(locals.region())) != null) {
                locals = locals.toBuilder().partitionResult(partitionResult).build();
                if ("aws-cn".equals(locals.partitionResult().name())) {
                    return RuleResult.error("Partition does not support FIPS");
                }
            }
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule7(S3EndpointParams params, LocalState locals) {
        if (params.bucket() != null) {
            String bucketSuffix = null;
            if ((bucketSuffix = RulesFunctions.substring(params.bucket(), 0, 6, true)) != null) {
                locals = locals.toBuilder().bucketSuffix(bucketSuffix).build();
                if ("--x-s3".equals(locals.bucketSuffix())) {
                    RuleResult result = endpointRule8(params, locals);
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
                    result = endpointRule24(params, locals);
                    if (result.isResolved()) {
                        return result;
                    }
                    result = endpointRule29(params, locals);
                    if (result.isResolved()) {
                        return result;
                    }
                    return endpointRule64(params, locals);
                }
            }
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule8(S3EndpointParams params, LocalState locals) {
        if (params.useDualStack()) {
            return RuleResult.error("S3Express does not support Dual-stack.");
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule9(S3EndpointParams params, LocalState locals) {
        if (params.accelerate()) {
            return RuleResult.error("S3Express does not support S3 Accelerate.");
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule10(S3EndpointParams params, LocalState locals) {
        if (params.endpoint() != null) {
            RuleUrl url = null;
            if ((url = RulesFunctions.parseURL(params.endpoint())) != null) {
                locals = locals.toBuilder().url(url).build();
                RuleResult result = endpointRule11(params, locals);
                if (result.isResolved()) {
                    return result;
                }
                result = endpointRule18(params, locals);
                if (result.isResolved()) {
                    return result;
                }
                result = endpointRule21(params, locals);
                if (result.isResolved()) {
                    return result;
                }
                return endpointRule23(params, locals);
            }
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule11(S3EndpointParams params, LocalState locals) {
        if (params.disableS3ExpressSessionAuth() != null && params.disableS3ExpressSessionAuth()) {
            RuleResult result = endpointRule12(params, locals);
            if (result.isResolved()) {
                return result;
            }
            result = endpointRule15(params, locals);
            if (result.isResolved()) {
                return result;
            }
            return endpointRule17(params, locals);
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule12(S3EndpointParams params, LocalState locals) {
        if (locals.url().isIp()) {
            return endpointRule13(params, locals);
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule13(S3EndpointParams params, LocalState locals) {
        String uriEncodedBucket = null;
        if ((uriEncodedBucket = RulesFunctions.uriEncode(params.bucket())) != null) {
            locals = locals.toBuilder().uriEncodedBucket(uriEncodedBucket).build();
            return endpointRule14(params, locals);
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule14(S3EndpointParams params, LocalState locals) {
        return RuleResult.endpoint(Endpoint
                .builder()
                .url(URI.create(locals.url().scheme() + "://" + locals.url().authority() + "/" + locals.uriEncodedBucket()
                        + locals.url().path()))
                .putAttribute(KnownS3ExpressEndpointProperty.BACKEND, "S3Express")
                .putAttribute(
                        AwsEndpointAttribute.AUTH_SCHEMES,
                        Arrays.asList(SigV4AuthScheme.builder().disableDoubleEncoding(true).signingName("s3express")
                                .signingRegion(locals.region()).build())).build());
    }

    private static RuleResult endpointRule15(S3EndpointParams params, LocalState locals) {
        if (RulesFunctions.awsIsVirtualHostableS3Bucket(params.bucket(), false)) {
            return endpointRule16(params, locals);
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule16(S3EndpointParams params, LocalState locals) {
        return RuleResult.endpoint(Endpoint
                .builder()
                .url(URI.create(locals.url().scheme() + "://" + params.bucket() + "." + locals.url().authority()
                        + locals.url().path()))
                .putAttribute(KnownS3ExpressEndpointProperty.BACKEND, "S3Express")
                .putAttribute(
                        AwsEndpointAttribute.AUTH_SCHEMES,
                        Arrays.asList(SigV4AuthScheme.builder().disableDoubleEncoding(true).signingName("s3express")
                                .signingRegion(locals.region()).build())).build());
    }

    private static RuleResult endpointRule17(S3EndpointParams params, LocalState locals) {
        return RuleResult.error("S3Express bucket name is not a valid virtual hostable name.");
    }

    private static RuleResult endpointRule18(S3EndpointParams params, LocalState locals) {
        if (locals.url().isIp()) {
            return endpointRule19(params, locals);
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule19(S3EndpointParams params, LocalState locals) {
        String uriEncodedBucket = null;
        if ((uriEncodedBucket = RulesFunctions.uriEncode(params.bucket())) != null) {
            locals = locals.toBuilder().uriEncodedBucket(uriEncodedBucket).build();
            return endpointRule20(params, locals);
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule20(S3EndpointParams params, LocalState locals) {
        return RuleResult.endpoint(Endpoint
                .builder()
                .url(URI.create(locals.url().scheme() + "://" + locals.url().authority() + "/" + locals.uriEncodedBucket()
                        + locals.url().path()))
                .putAttribute(KnownS3ExpressEndpointProperty.BACKEND, "S3Express")
                .putAttribute(
                        AwsEndpointAttribute.AUTH_SCHEMES,
                        Arrays.asList(S3ExpressEndpointAuthScheme.builder().disableDoubleEncoding(true).signingName("s3express")
                                .signingRegion(locals.region()).build())).build());
    }

    private static RuleResult endpointRule21(S3EndpointParams params, LocalState locals) {
        if (RulesFunctions.awsIsVirtualHostableS3Bucket(params.bucket(), false)) {
            return endpointRule22(params, locals);
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule22(S3EndpointParams params, LocalState locals) {
        return RuleResult.endpoint(Endpoint
                .builder()
                .url(URI.create(locals.url().scheme() + "://" + params.bucket() + "." + locals.url().authority()
                        + locals.url().path()))
                .putAttribute(KnownS3ExpressEndpointProperty.BACKEND, "S3Express")
                .putAttribute(
                        AwsEndpointAttribute.AUTH_SCHEMES,
                        Arrays.asList(S3ExpressEndpointAuthScheme.builder().disableDoubleEncoding(true).signingName("s3express")
                                .signingRegion(locals.region()).build())).build());
    }

    private static RuleResult endpointRule23(S3EndpointParams params, LocalState locals) {
        return RuleResult.error("S3Express bucket name is not a valid virtual hostable name.");
    }

    private static RuleResult endpointRule24(S3EndpointParams params, LocalState locals) {
        if (params.useS3ExpressControlEndpoint() != null && params.useS3ExpressControlEndpoint()) {
            return endpointRule25(params, locals);
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule25(S3EndpointParams params, LocalState locals) {
        RulePartition partitionResult = null;
        if ((partitionResult = RulesFunctions.awsPartition(locals.region())) != null) {
            locals = locals.toBuilder().partitionResult(partitionResult).build();
            return endpointRule26(params, locals);
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule26(S3EndpointParams params, LocalState locals) {
        String uriEncodedBucket = null;
        if ((uriEncodedBucket = RulesFunctions.uriEncode(params.bucket())) != null) {
            locals = locals.toBuilder().uriEncodedBucket(uriEncodedBucket).build();
            if (params.endpoint() == null) {
                RuleResult result = endpointRule27(params, locals);
                if (result.isResolved()) {
                    return result;
                }
                return endpointRule28(params, locals);
            }
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule27(S3EndpointParams params, LocalState locals) {
        if (params.useFips()) {
            return RuleResult.endpoint(Endpoint
                    .builder()
                    .url(URI.create("https://s3express-control-fips." + locals.region() + "."
                            + locals.partitionResult().dnsSuffix() + "/" + locals.uriEncodedBucket()))
                    .putAttribute(KnownS3ExpressEndpointProperty.BACKEND, "S3Express")
                    .putAttribute(
                            AwsEndpointAttribute.AUTH_SCHEMES,
                            Arrays.asList(SigV4AuthScheme.builder().disableDoubleEncoding(true).signingName("s3express")
                                    .signingRegion(locals.region()).build())).build());
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule28(S3EndpointParams params, LocalState locals) {
        return RuleResult.endpoint(Endpoint
                .builder()
                .url(URI.create("https://s3express-control." + locals.region() + "." + locals.partitionResult().dnsSuffix() + "/"
                        + locals.uriEncodedBucket()))
                .putAttribute(KnownS3ExpressEndpointProperty.BACKEND, "S3Express")
                .putAttribute(
                        AwsEndpointAttribute.AUTH_SCHEMES,
                        Arrays.asList(SigV4AuthScheme.builder().disableDoubleEncoding(true).signingName("s3express")
                                .signingRegion(locals.region()).build())).build());
    }

    private static RuleResult endpointRule29(S3EndpointParams params, LocalState locals) {
        if (RulesFunctions.awsIsVirtualHostableS3Bucket(params.bucket(), false)) {
            return endpointRule30(params, locals);
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule30(S3EndpointParams params, LocalState locals) {
        RulePartition partitionResult = null;
        if ((partitionResult = RulesFunctions.awsPartition(locals.region())) != null) {
            locals = locals.toBuilder().partitionResult(partitionResult).build();
            RuleResult result = endpointRule31(params, locals);
            if (result.isResolved()) {
                return result;
            }
            result = endpointRule48(params, locals);
            if (result.isResolved()) {
                return result;
            }
            result = endpointRule51(params, locals);
            if (result.isResolved()) {
                return result;
            }
            result = endpointRule54(params, locals);
            if (result.isResolved()) {
                return result;
            }
            result = endpointRule57(params, locals);
            if (result.isResolved()) {
                return result;
            }
            result = endpointRule60(params, locals);
            if (result.isResolved()) {
                return result;
            }
            return endpointRule63(params, locals);
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule31(S3EndpointParams params, LocalState locals) {
        if (params.disableS3ExpressSessionAuth() != null && params.disableS3ExpressSessionAuth()) {
            RuleResult result = endpointRule32(params, locals);
            if (result.isResolved()) {
                return result;
            }
            result = endpointRule35(params, locals);
            if (result.isResolved()) {
                return result;
            }
            result = endpointRule38(params, locals);
            if (result.isResolved()) {
                return result;
            }
            result = endpointRule41(params, locals);
            if (result.isResolved()) {
                return result;
            }
            result = endpointRule44(params, locals);
            if (result.isResolved()) {
                return result;
            }
            return endpointRule47(params, locals);
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule32(S3EndpointParams params, LocalState locals) {
        String s3ExpressAvailabilityZoneId = null;
        String s3ExpressAvailabilityZoneDelim = null;
        if ((s3ExpressAvailabilityZoneId = RulesFunctions.substring(params.bucket(), 6, 14, true)) != null) {
            locals = locals.toBuilder().s3ExpressAvailabilityZoneId(s3ExpressAvailabilityZoneId).build();
        } else {
            return RuleResult.carryOn();
        }
        if ((s3ExpressAvailabilityZoneDelim = RulesFunctions.substring(params.bucket(), 14, 16, true)) != null) {
            locals = locals.toBuilder().s3ExpressAvailabilityZoneDelim(s3ExpressAvailabilityZoneDelim).build();
            if ("--".equals(locals.s3ExpressAvailabilityZoneDelim())) {
                RuleResult result = endpointRule33(params, locals);
                if (result.isResolved()) {
                    return result;
                }
                return endpointRule34(params, locals);
            }
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule33(S3EndpointParams params, LocalState locals) {
        if (params.useFips()) {
            return RuleResult.endpoint(Endpoint
                    .builder()
                    .url(URI.create("https://" + params.bucket() + ".s3express-fips-" + locals.s3ExpressAvailabilityZoneId()
                            + "." + locals.region() + "." + locals.partitionResult().dnsSuffix()))
                    .putAttribute(KnownS3ExpressEndpointProperty.BACKEND, "S3Express")
                    .putAttribute(
                            AwsEndpointAttribute.AUTH_SCHEMES,
                            Arrays.asList(SigV4AuthScheme.builder().disableDoubleEncoding(true).signingName("s3express")
                                    .signingRegion(locals.region()).build())).build());
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule34(S3EndpointParams params, LocalState locals) {
        return RuleResult.endpoint(Endpoint
                .builder()
                .url(URI.create("https://" + params.bucket() + ".s3express-" + locals.s3ExpressAvailabilityZoneId() + "."
                        + locals.region() + "." + locals.partitionResult().dnsSuffix()))
                .putAttribute(KnownS3ExpressEndpointProperty.BACKEND, "S3Express")
                .putAttribute(
                        AwsEndpointAttribute.AUTH_SCHEMES,
                        Arrays.asList(SigV4AuthScheme.builder().disableDoubleEncoding(true).signingName("s3express")
                                .signingRegion(locals.region()).build())).build());
    }

    private static RuleResult endpointRule35(S3EndpointParams params, LocalState locals) {
        String s3ExpressAvailabilityZoneId = null;
        String s3ExpressAvailabilityZoneDelim = null;
        if ((s3ExpressAvailabilityZoneId = RulesFunctions.substring(params.bucket(), 6, 15, true)) != null) {
            locals = locals.toBuilder().s3ExpressAvailabilityZoneId(s3ExpressAvailabilityZoneId).build();
        } else {
            return RuleResult.carryOn();
        }
        if ((s3ExpressAvailabilityZoneDelim = RulesFunctions.substring(params.bucket(), 15, 17, true)) != null) {
            locals = locals.toBuilder().s3ExpressAvailabilityZoneDelim(s3ExpressAvailabilityZoneDelim).build();
            if ("--".equals(locals.s3ExpressAvailabilityZoneDelim())) {
                RuleResult result = endpointRule36(params, locals);
                if (result.isResolved()) {
                    return result;
                }
                return endpointRule37(params, locals);
            }
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule36(S3EndpointParams params, LocalState locals) {
        if (params.useFips()) {
            return RuleResult.endpoint(Endpoint
                    .builder()
                    .url(URI.create("https://" + params.bucket() + ".s3express-fips-" + locals.s3ExpressAvailabilityZoneId()
                            + "." + locals.region() + "." + locals.partitionResult().dnsSuffix()))
                    .putAttribute(KnownS3ExpressEndpointProperty.BACKEND, "S3Express")
                    .putAttribute(
                            AwsEndpointAttribute.AUTH_SCHEMES,
                            Arrays.asList(SigV4AuthScheme.builder().disableDoubleEncoding(true).signingName("s3express")
                                    .signingRegion(locals.region()).build())).build());
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule37(S3EndpointParams params, LocalState locals) {
        return RuleResult.endpoint(Endpoint
                .builder()
                .url(URI.create("https://" + params.bucket() + ".s3express-" + locals.s3ExpressAvailabilityZoneId() + "."
                        + locals.region() + "." + locals.partitionResult().dnsSuffix()))
                .putAttribute(KnownS3ExpressEndpointProperty.BACKEND, "S3Express")
                .putAttribute(
                        AwsEndpointAttribute.AUTH_SCHEMES,
                        Arrays.asList(SigV4AuthScheme.builder().disableDoubleEncoding(true).signingName("s3express")
                                .signingRegion(locals.region()).build())).build());
    }

    private static RuleResult endpointRule38(S3EndpointParams params, LocalState locals) {
        String s3ExpressAvailabilityZoneId = null;
        String s3ExpressAvailabilityZoneDelim = null;
        if ((s3ExpressAvailabilityZoneId = RulesFunctions.substring(params.bucket(), 6, 19, true)) != null) {
            locals = locals.toBuilder().s3ExpressAvailabilityZoneId(s3ExpressAvailabilityZoneId).build();
        } else {
            return RuleResult.carryOn();
        }
        if ((s3ExpressAvailabilityZoneDelim = RulesFunctions.substring(params.bucket(), 19, 21, true)) != null) {
            locals = locals.toBuilder().s3ExpressAvailabilityZoneDelim(s3ExpressAvailabilityZoneDelim).build();
            if ("--".equals(locals.s3ExpressAvailabilityZoneDelim())) {
                RuleResult result = endpointRule39(params, locals);
                if (result.isResolved()) {
                    return result;
                }
                return endpointRule40(params, locals);
            }
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule39(S3EndpointParams params, LocalState locals) {
        if (params.useFips()) {
            return RuleResult.endpoint(Endpoint
                    .builder()
                    .url(URI.create("https://" + params.bucket() + ".s3express-fips-" + locals.s3ExpressAvailabilityZoneId()
                            + "." + locals.region() + "." + locals.partitionResult().dnsSuffix()))
                    .putAttribute(KnownS3ExpressEndpointProperty.BACKEND, "S3Express")
                    .putAttribute(
                            AwsEndpointAttribute.AUTH_SCHEMES,
                            Arrays.asList(SigV4AuthScheme.builder().disableDoubleEncoding(true).signingName("s3express")
                                    .signingRegion(locals.region()).build())).build());
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule40(S3EndpointParams params, LocalState locals) {
        return RuleResult.endpoint(Endpoint
                .builder()
                .url(URI.create("https://" + params.bucket() + ".s3express-" + locals.s3ExpressAvailabilityZoneId() + "."
                        + locals.region() + "." + locals.partitionResult().dnsSuffix()))
                .putAttribute(KnownS3ExpressEndpointProperty.BACKEND, "S3Express")
                .putAttribute(
                        AwsEndpointAttribute.AUTH_SCHEMES,
                        Arrays.asList(SigV4AuthScheme.builder().disableDoubleEncoding(true).signingName("s3express")
                                .signingRegion(locals.region()).build())).build());
    }

    private static RuleResult endpointRule41(S3EndpointParams params, LocalState locals) {
        String s3ExpressAvailabilityZoneId = null;
        String s3ExpressAvailabilityZoneDelim = null;
        if ((s3ExpressAvailabilityZoneId = RulesFunctions.substring(params.bucket(), 6, 20, true)) != null) {
            locals = locals.toBuilder().s3ExpressAvailabilityZoneId(s3ExpressAvailabilityZoneId).build();
        } else {
            return RuleResult.carryOn();
        }
        if ((s3ExpressAvailabilityZoneDelim = RulesFunctions.substring(params.bucket(), 20, 22, true)) != null) {
            locals = locals.toBuilder().s3ExpressAvailabilityZoneDelim(s3ExpressAvailabilityZoneDelim).build();
            if ("--".equals(locals.s3ExpressAvailabilityZoneDelim())) {
                RuleResult result = endpointRule42(params, locals);
                if (result.isResolved()) {
                    return result;
                }
                return endpointRule43(params, locals);
            }
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule42(S3EndpointParams params, LocalState locals) {
        if (params.useFips()) {
            return RuleResult.endpoint(Endpoint
                    .builder()
                    .url(URI.create("https://" + params.bucket() + ".s3express-fips-" + locals.s3ExpressAvailabilityZoneId()
                            + "." + locals.region() + "." + locals.partitionResult().dnsSuffix()))
                    .putAttribute(KnownS3ExpressEndpointProperty.BACKEND, "S3Express")
                    .putAttribute(
                            AwsEndpointAttribute.AUTH_SCHEMES,
                            Arrays.asList(SigV4AuthScheme.builder().disableDoubleEncoding(true).signingName("s3express")
                                    .signingRegion(locals.region()).build())).build());
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule43(S3EndpointParams params, LocalState locals) {
        return RuleResult.endpoint(Endpoint
                .builder()
                .url(URI.create("https://" + params.bucket() + ".s3express-" + locals.s3ExpressAvailabilityZoneId() + "."
                        + locals.region() + "." + locals.partitionResult().dnsSuffix()))
                .putAttribute(KnownS3ExpressEndpointProperty.BACKEND, "S3Express")
                .putAttribute(
                        AwsEndpointAttribute.AUTH_SCHEMES,
                        Arrays.asList(SigV4AuthScheme.builder().disableDoubleEncoding(true).signingName("s3express")
                                .signingRegion(locals.region()).build())).build());
    }

    private static RuleResult endpointRule44(S3EndpointParams params, LocalState locals) {
        String s3ExpressAvailabilityZoneId = null;
        String s3ExpressAvailabilityZoneDelim = null;
        if ((s3ExpressAvailabilityZoneId = RulesFunctions.substring(params.bucket(), 6, 26, true)) != null) {
            locals = locals.toBuilder().s3ExpressAvailabilityZoneId(s3ExpressAvailabilityZoneId).build();
        } else {
            return RuleResult.carryOn();
        }
        if ((s3ExpressAvailabilityZoneDelim = RulesFunctions.substring(params.bucket(), 26, 28, true)) != null) {
            locals = locals.toBuilder().s3ExpressAvailabilityZoneDelim(s3ExpressAvailabilityZoneDelim).build();
            if ("--".equals(locals.s3ExpressAvailabilityZoneDelim())) {
                RuleResult result = endpointRule45(params, locals);
                if (result.isResolved()) {
                    return result;
                }
                return endpointRule46(params, locals);
            }
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule45(S3EndpointParams params, LocalState locals) {
        if (params.useFips()) {
            return RuleResult.endpoint(Endpoint
                    .builder()
                    .url(URI.create("https://" + params.bucket() + ".s3express-fips-" + locals.s3ExpressAvailabilityZoneId()
                            + "." + locals.region() + "." + locals.partitionResult().dnsSuffix()))
                    .putAttribute(KnownS3ExpressEndpointProperty.BACKEND, "S3Express")
                    .putAttribute(
                            AwsEndpointAttribute.AUTH_SCHEMES,
                            Arrays.asList(SigV4AuthScheme.builder().disableDoubleEncoding(true).signingName("s3express")
                                    .signingRegion(locals.region()).build())).build());
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule46(S3EndpointParams params, LocalState locals) {
        return RuleResult.endpoint(Endpoint
                .builder()
                .url(URI.create("https://" + params.bucket() + ".s3express-" + locals.s3ExpressAvailabilityZoneId() + "."
                        + locals.region() + "." + locals.partitionResult().dnsSuffix()))
                .putAttribute(KnownS3ExpressEndpointProperty.BACKEND, "S3Express")
                .putAttribute(
                        AwsEndpointAttribute.AUTH_SCHEMES,
                        Arrays.asList(SigV4AuthScheme.builder().disableDoubleEncoding(true).signingName("s3express")
                                .signingRegion(locals.region()).build())).build());
    }

    private static RuleResult endpointRule47(S3EndpointParams params, LocalState locals) {
        return RuleResult.error("Unrecognized S3Express bucket name format.");
    }

    private static RuleResult endpointRule48(S3EndpointParams params, LocalState locals) {
        String s3ExpressAvailabilityZoneId = null;
        String s3ExpressAvailabilityZoneDelim = null;
        if ((s3ExpressAvailabilityZoneId = RulesFunctions.substring(params.bucket(), 6, 14, true)) != null) {
            locals = locals.toBuilder().s3ExpressAvailabilityZoneId(s3ExpressAvailabilityZoneId).build();
        } else {
            return RuleResult.carryOn();
        }
        if ((s3ExpressAvailabilityZoneDelim = RulesFunctions.substring(params.bucket(), 14, 16, true)) != null) {
            locals = locals.toBuilder().s3ExpressAvailabilityZoneDelim(s3ExpressAvailabilityZoneDelim).build();
            if ("--".equals(locals.s3ExpressAvailabilityZoneDelim())) {
                RuleResult result = endpointRule49(params, locals);
                if (result.isResolved()) {
                    return result;
                }
                return endpointRule50(params, locals);
            }
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule49(S3EndpointParams params, LocalState locals) {
        if (params.useFips()) {
            return RuleResult.endpoint(Endpoint
                    .builder()
                    .url(URI.create("https://" + params.bucket() + ".s3express-fips-" + locals.s3ExpressAvailabilityZoneId()
                            + "." + locals.region() + "." + locals.partitionResult().dnsSuffix()))
                    .putAttribute(KnownS3ExpressEndpointProperty.BACKEND, "S3Express")
                    .putAttribute(
                            AwsEndpointAttribute.AUTH_SCHEMES,
                            Arrays.asList(S3ExpressEndpointAuthScheme.builder().disableDoubleEncoding(true)
                                    .signingName("s3express").signingRegion(locals.region()).build())).build());
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule50(S3EndpointParams params, LocalState locals) {
        return RuleResult.endpoint(Endpoint
                .builder()
                .url(URI.create("https://" + params.bucket() + ".s3express-" + locals.s3ExpressAvailabilityZoneId() + "."
                        + locals.region() + "." + locals.partitionResult().dnsSuffix()))
                .putAttribute(KnownS3ExpressEndpointProperty.BACKEND, "S3Express")
                .putAttribute(
                        AwsEndpointAttribute.AUTH_SCHEMES,
                        Arrays.asList(S3ExpressEndpointAuthScheme.builder().disableDoubleEncoding(true).signingName("s3express")
                                .signingRegion(locals.region()).build())).build());
    }

    private static RuleResult endpointRule51(S3EndpointParams params, LocalState locals) {
        String s3ExpressAvailabilityZoneId = null;
        String s3ExpressAvailabilityZoneDelim = null;
        if ((s3ExpressAvailabilityZoneId = RulesFunctions.substring(params.bucket(), 6, 15, true)) != null) {
            locals = locals.toBuilder().s3ExpressAvailabilityZoneId(s3ExpressAvailabilityZoneId).build();
        } else {
            return RuleResult.carryOn();
        }
        if ((s3ExpressAvailabilityZoneDelim = RulesFunctions.substring(params.bucket(), 15, 17, true)) != null) {
            locals = locals.toBuilder().s3ExpressAvailabilityZoneDelim(s3ExpressAvailabilityZoneDelim).build();
            if ("--".equals(locals.s3ExpressAvailabilityZoneDelim())) {
                RuleResult result = endpointRule52(params, locals);
                if (result.isResolved()) {
                    return result;
                }
                return endpointRule53(params, locals);
            }
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule52(S3EndpointParams params, LocalState locals) {
        if (params.useFips()) {
            return RuleResult.endpoint(Endpoint
                    .builder()
                    .url(URI.create("https://" + params.bucket() + ".s3express-fips-" + locals.s3ExpressAvailabilityZoneId()
                            + "." + locals.region() + "." + locals.partitionResult().dnsSuffix()))
                    .putAttribute(KnownS3ExpressEndpointProperty.BACKEND, "S3Express")
                    .putAttribute(
                            AwsEndpointAttribute.AUTH_SCHEMES,
                            Arrays.asList(S3ExpressEndpointAuthScheme.builder().disableDoubleEncoding(true)
                                    .signingName("s3express").signingRegion(locals.region()).build())).build());
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule53(S3EndpointParams params, LocalState locals) {
        return RuleResult.endpoint(Endpoint
                .builder()
                .url(URI.create("https://" + params.bucket() + ".s3express-" + locals.s3ExpressAvailabilityZoneId() + "."
                        + locals.region() + "." + locals.partitionResult().dnsSuffix()))
                .putAttribute(KnownS3ExpressEndpointProperty.BACKEND, "S3Express")
                .putAttribute(
                        AwsEndpointAttribute.AUTH_SCHEMES,
                        Arrays.asList(S3ExpressEndpointAuthScheme.builder().disableDoubleEncoding(true).signingName("s3express")
                                .signingRegion(locals.region()).build())).build());
    }

    private static RuleResult endpointRule54(S3EndpointParams params, LocalState locals) {
        String s3ExpressAvailabilityZoneId = null;
        String s3ExpressAvailabilityZoneDelim = null;
        if ((s3ExpressAvailabilityZoneId = RulesFunctions.substring(params.bucket(), 6, 19, true)) != null) {
            locals = locals.toBuilder().s3ExpressAvailabilityZoneId(s3ExpressAvailabilityZoneId).build();
        } else {
            return RuleResult.carryOn();
        }
        if ((s3ExpressAvailabilityZoneDelim = RulesFunctions.substring(params.bucket(), 19, 21, true)) != null) {
            locals = locals.toBuilder().s3ExpressAvailabilityZoneDelim(s3ExpressAvailabilityZoneDelim).build();
            if ("--".equals(locals.s3ExpressAvailabilityZoneDelim())) {
                RuleResult result = endpointRule55(params, locals);
                if (result.isResolved()) {
                    return result;
                }
                return endpointRule56(params, locals);
            }
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule55(S3EndpointParams params, LocalState locals) {
        if (params.useFips()) {
            return RuleResult.endpoint(Endpoint
                    .builder()
                    .url(URI.create("https://" + params.bucket() + ".s3express-fips-" + locals.s3ExpressAvailabilityZoneId()
                            + "." + locals.region() + "." + locals.partitionResult().dnsSuffix()))
                    .putAttribute(KnownS3ExpressEndpointProperty.BACKEND, "S3Express")
                    .putAttribute(
                            AwsEndpointAttribute.AUTH_SCHEMES,
                            Arrays.asList(S3ExpressEndpointAuthScheme.builder().disableDoubleEncoding(true)
                                    .signingName("s3express").signingRegion(locals.region()).build())).build());
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule56(S3EndpointParams params, LocalState locals) {
        return RuleResult.endpoint(Endpoint
                .builder()
                .url(URI.create("https://" + params.bucket() + ".s3express-" + locals.s3ExpressAvailabilityZoneId() + "."
                        + locals.region() + "." + locals.partitionResult().dnsSuffix()))
                .putAttribute(KnownS3ExpressEndpointProperty.BACKEND, "S3Express")
                .putAttribute(
                        AwsEndpointAttribute.AUTH_SCHEMES,
                        Arrays.asList(S3ExpressEndpointAuthScheme.builder().disableDoubleEncoding(true).signingName("s3express")
                                .signingRegion(locals.region()).build())).build());
    }

    private static RuleResult endpointRule57(S3EndpointParams params, LocalState locals) {
        String s3ExpressAvailabilityZoneId = null;
        String s3ExpressAvailabilityZoneDelim = null;
        if ((s3ExpressAvailabilityZoneId = RulesFunctions.substring(params.bucket(), 6, 20, true)) != null) {
            locals = locals.toBuilder().s3ExpressAvailabilityZoneId(s3ExpressAvailabilityZoneId).build();
        } else {
            return RuleResult.carryOn();
        }
        if ((s3ExpressAvailabilityZoneDelim = RulesFunctions.substring(params.bucket(), 20, 22, true)) != null) {
            locals = locals.toBuilder().s3ExpressAvailabilityZoneDelim(s3ExpressAvailabilityZoneDelim).build();
            if ("--".equals(locals.s3ExpressAvailabilityZoneDelim())) {
                RuleResult result = endpointRule58(params, locals);
                if (result.isResolved()) {
                    return result;
                }
                return endpointRule59(params, locals);
            }
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule58(S3EndpointParams params, LocalState locals) {
        if (params.useFips()) {
            return RuleResult.endpoint(Endpoint
                    .builder()
                    .url(URI.create("https://" + params.bucket() + ".s3express-fips-" + locals.s3ExpressAvailabilityZoneId()
                            + "." + locals.region() + "." + locals.partitionResult().dnsSuffix()))
                    .putAttribute(KnownS3ExpressEndpointProperty.BACKEND, "S3Express")
                    .putAttribute(
                            AwsEndpointAttribute.AUTH_SCHEMES,
                            Arrays.asList(S3ExpressEndpointAuthScheme.builder().disableDoubleEncoding(true)
                                    .signingName("s3express").signingRegion(locals.region()).build())).build());
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule59(S3EndpointParams params, LocalState locals) {
        return RuleResult.endpoint(Endpoint
                .builder()
                .url(URI.create("https://" + params.bucket() + ".s3express-" + locals.s3ExpressAvailabilityZoneId() + "."
                        + locals.region() + "." + locals.partitionResult().dnsSuffix()))
                .putAttribute(KnownS3ExpressEndpointProperty.BACKEND, "S3Express")
                .putAttribute(
                        AwsEndpointAttribute.AUTH_SCHEMES,
                        Arrays.asList(S3ExpressEndpointAuthScheme.builder().disableDoubleEncoding(true).signingName("s3express")
                                .signingRegion(locals.region()).build())).build());
    }

    private static RuleResult endpointRule60(S3EndpointParams params, LocalState locals) {
        String s3ExpressAvailabilityZoneId = null;
        String s3ExpressAvailabilityZoneDelim = null;
        if ((s3ExpressAvailabilityZoneId = RulesFunctions.substring(params.bucket(), 6, 26, true)) != null) {
            locals = locals.toBuilder().s3ExpressAvailabilityZoneId(s3ExpressAvailabilityZoneId).build();
        } else {
            return RuleResult.carryOn();
        }
        if ((s3ExpressAvailabilityZoneDelim = RulesFunctions.substring(params.bucket(), 26, 28, true)) != null) {
            locals = locals.toBuilder().s3ExpressAvailabilityZoneDelim(s3ExpressAvailabilityZoneDelim).build();
            if ("--".equals(locals.s3ExpressAvailabilityZoneDelim())) {
                RuleResult result = endpointRule61(params, locals);
                if (result.isResolved()) {
                    return result;
                }
                return endpointRule62(params, locals);
            }
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule61(S3EndpointParams params, LocalState locals) {
        if (params.useFips()) {
            return RuleResult.endpoint(Endpoint
                    .builder()
                    .url(URI.create("https://" + params.bucket() + ".s3express-fips-" + locals.s3ExpressAvailabilityZoneId()
                            + "." + locals.region() + "." + locals.partitionResult().dnsSuffix()))
                    .putAttribute(KnownS3ExpressEndpointProperty.BACKEND, "S3Express")
                    .putAttribute(
                            AwsEndpointAttribute.AUTH_SCHEMES,
                            Arrays.asList(S3ExpressEndpointAuthScheme.builder().disableDoubleEncoding(true)
                                    .signingName("s3express").signingRegion(locals.region()).build())).build());
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule62(S3EndpointParams params, LocalState locals) {
        return RuleResult.endpoint(Endpoint
                .builder()
                .url(URI.create("https://" + params.bucket() + ".s3express-" + locals.s3ExpressAvailabilityZoneId() + "."
                        + locals.region() + "." + locals.partitionResult().dnsSuffix()))
                .putAttribute(KnownS3ExpressEndpointProperty.BACKEND, "S3Express")
                .putAttribute(
                        AwsEndpointAttribute.AUTH_SCHEMES,
                        Arrays.asList(S3ExpressEndpointAuthScheme.builder().disableDoubleEncoding(true).signingName("s3express")
                                .signingRegion(locals.region()).build())).build());
    }

    private static RuleResult endpointRule63(S3EndpointParams params, LocalState locals) {
        return RuleResult.error("Unrecognized S3Express bucket name format.");
    }

    private static RuleResult endpointRule64(S3EndpointParams params, LocalState locals) {
        return RuleResult.error("S3Express bucket name is not a valid virtual hostable name.");
    }

    private static RuleResult endpointRule65(S3EndpointParams params, LocalState locals) {
        if (params.bucket() != null) {
            String accessPointSuffix = null;
            if ((accessPointSuffix = RulesFunctions.substring(params.bucket(), 0, 7, true)) != null) {
                locals = locals.toBuilder().accessPointSuffix(accessPointSuffix).build();
                if ("--xa-s3".equals(locals.accessPointSuffix())) {
                    RuleResult result = endpointRule66(params, locals);
                    if (result.isResolved()) {
                        return result;
                    }
                    result = endpointRule67(params, locals);
                    if (result.isResolved()) {
                        return result;
                    }
                    result = endpointRule68(params, locals);
                    if (result.isResolved()) {
                        return result;
                    }
                    result = endpointRule82(params, locals);
                    if (result.isResolved()) {
                        return result;
                    }
                    return endpointRule117(params, locals);
                }
            }
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule66(S3EndpointParams params, LocalState locals) {
        if (params.useDualStack()) {
            return RuleResult.error("S3Express does not support Dual-stack.");
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule67(S3EndpointParams params, LocalState locals) {
        if (params.accelerate()) {
            return RuleResult.error("S3Express does not support S3 Accelerate.");
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule68(S3EndpointParams params, LocalState locals) {
        if (params.endpoint() != null) {
            RuleUrl url = null;
            if ((url = RulesFunctions.parseURL(params.endpoint())) != null) {
                locals = locals.toBuilder().url(url).build();
                RuleResult result = endpointRule69(params, locals);
                if (result.isResolved()) {
                    return result;
                }
                result = endpointRule76(params, locals);
                if (result.isResolved()) {
                    return result;
                }
                result = endpointRule79(params, locals);
                if (result.isResolved()) {
                    return result;
                }
                return endpointRule81(params, locals);
            }
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule69(S3EndpointParams params, LocalState locals) {
        if (params.disableS3ExpressSessionAuth() != null && params.disableS3ExpressSessionAuth()) {
            RuleResult result = endpointRule70(params, locals);
            if (result.isResolved()) {
                return result;
            }
            result = endpointRule73(params, locals);
            if (result.isResolved()) {
                return result;
            }
            return endpointRule75(params, locals);
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule70(S3EndpointParams params, LocalState locals) {
        if (locals.url().isIp()) {
            return endpointRule71(params, locals);
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule71(S3EndpointParams params, LocalState locals) {
        String uriEncodedBucket = null;
        if ((uriEncodedBucket = RulesFunctions.uriEncode(params.bucket())) != null) {
            locals = locals.toBuilder().uriEncodedBucket(uriEncodedBucket).build();
            return endpointRule72(params, locals);
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule72(S3EndpointParams params, LocalState locals) {
        return RuleResult.endpoint(Endpoint
                .builder()
                .url(URI.create(locals.url().scheme() + "://" + locals.url().authority() + "/" + locals.uriEncodedBucket()
                        + locals.url().path()))
                .putAttribute(KnownS3ExpressEndpointProperty.BACKEND, "S3Express")
                .putAttribute(
                        AwsEndpointAttribute.AUTH_SCHEMES,
                        Arrays.asList(SigV4AuthScheme.builder().disableDoubleEncoding(true).signingName("s3express")
                                .signingRegion(locals.region()).build())).build());
    }

    private static RuleResult endpointRule73(S3EndpointParams params, LocalState locals) {
        if (RulesFunctions.awsIsVirtualHostableS3Bucket(params.bucket(), false)) {
            return endpointRule74(params, locals);
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule74(S3EndpointParams params, LocalState locals) {
        return RuleResult.endpoint(Endpoint
                .builder()
                .url(URI.create(locals.url().scheme() + "://" + params.bucket() + "." + locals.url().authority()
                        + locals.url().path()))
                .putAttribute(KnownS3ExpressEndpointProperty.BACKEND, "S3Express")
                .putAttribute(
                        AwsEndpointAttribute.AUTH_SCHEMES,
                        Arrays.asList(SigV4AuthScheme.builder().disableDoubleEncoding(true).signingName("s3express")
                                .signingRegion(locals.region()).build())).build());
    }

    private static RuleResult endpointRule75(S3EndpointParams params, LocalState locals) {
        return RuleResult.error("S3Express bucket name is not a valid virtual hostable name.");
    }

    private static RuleResult endpointRule76(S3EndpointParams params, LocalState locals) {
        if (locals.url().isIp()) {
            return endpointRule77(params, locals);
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule77(S3EndpointParams params, LocalState locals) {
        String uriEncodedBucket = null;
        if ((uriEncodedBucket = RulesFunctions.uriEncode(params.bucket())) != null) {
            locals = locals.toBuilder().uriEncodedBucket(uriEncodedBucket).build();
            return endpointRule78(params, locals);
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule78(S3EndpointParams params, LocalState locals) {
        return RuleResult.endpoint(Endpoint
                .builder()
                .url(URI.create(locals.url().scheme() + "://" + locals.url().authority() + "/" + locals.uriEncodedBucket()
                        + locals.url().path()))
                .putAttribute(KnownS3ExpressEndpointProperty.BACKEND, "S3Express")
                .putAttribute(
                        AwsEndpointAttribute.AUTH_SCHEMES,
                        Arrays.asList(S3ExpressEndpointAuthScheme.builder().disableDoubleEncoding(true).signingName("s3express")
                                .signingRegion(locals.region()).build())).build());
    }

    private static RuleResult endpointRule79(S3EndpointParams params, LocalState locals) {
        if (RulesFunctions.awsIsVirtualHostableS3Bucket(params.bucket(), false)) {
            return endpointRule80(params, locals);
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule80(S3EndpointParams params, LocalState locals) {
        return RuleResult.endpoint(Endpoint
                .builder()
                .url(URI.create(locals.url().scheme() + "://" + params.bucket() + "." + locals.url().authority()
                        + locals.url().path()))
                .putAttribute(KnownS3ExpressEndpointProperty.BACKEND, "S3Express")
                .putAttribute(
                        AwsEndpointAttribute.AUTH_SCHEMES,
                        Arrays.asList(S3ExpressEndpointAuthScheme.builder().disableDoubleEncoding(true).signingName("s3express")
                                .signingRegion(locals.region()).build())).build());
    }

    private static RuleResult endpointRule81(S3EndpointParams params, LocalState locals) {
        return RuleResult.error("S3Express bucket name is not a valid virtual hostable name.");
    }

    private static RuleResult endpointRule82(S3EndpointParams params, LocalState locals) {
        if (RulesFunctions.awsIsVirtualHostableS3Bucket(params.bucket(), false)) {
            return endpointRule83(params, locals);
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule83(S3EndpointParams params, LocalState locals) {
        RulePartition partitionResult = null;
        if ((partitionResult = RulesFunctions.awsPartition(locals.region())) != null) {
            locals = locals.toBuilder().partitionResult(partitionResult).build();
            RuleResult result = endpointRule84(params, locals);
            if (result.isResolved()) {
                return result;
            }
            result = endpointRule101(params, locals);
            if (result.isResolved()) {
                return result;
            }
            result = endpointRule104(params, locals);
            if (result.isResolved()) {
                return result;
            }
            result = endpointRule107(params, locals);
            if (result.isResolved()) {
                return result;
            }
            result = endpointRule110(params, locals);
            if (result.isResolved()) {
                return result;
            }
            result = endpointRule113(params, locals);
            if (result.isResolved()) {
                return result;
            }
            return endpointRule116(params, locals);
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule84(S3EndpointParams params, LocalState locals) {
        if (params.disableS3ExpressSessionAuth() != null && params.disableS3ExpressSessionAuth()) {
            RuleResult result = endpointRule85(params, locals);
            if (result.isResolved()) {
                return result;
            }
            result = endpointRule88(params, locals);
            if (result.isResolved()) {
                return result;
            }
            result = endpointRule91(params, locals);
            if (result.isResolved()) {
                return result;
            }
            result = endpointRule94(params, locals);
            if (result.isResolved()) {
                return result;
            }
            result = endpointRule97(params, locals);
            if (result.isResolved()) {
                return result;
            }
            return endpointRule100(params, locals);
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule85(S3EndpointParams params, LocalState locals) {
        String s3ExpressAvailabilityZoneId = null;
        String s3ExpressAvailabilityZoneDelim = null;
        if ((s3ExpressAvailabilityZoneId = RulesFunctions.substring(params.bucket(), 7, 15, true)) != null) {
            locals = locals.toBuilder().s3ExpressAvailabilityZoneId(s3ExpressAvailabilityZoneId).build();
        } else {
            return RuleResult.carryOn();
        }
        if ((s3ExpressAvailabilityZoneDelim = RulesFunctions.substring(params.bucket(), 15, 17, true)) != null) {
            locals = locals.toBuilder().s3ExpressAvailabilityZoneDelim(s3ExpressAvailabilityZoneDelim).build();
            if ("--".equals(locals.s3ExpressAvailabilityZoneDelim())) {
                RuleResult result = endpointRule86(params, locals);
                if (result.isResolved()) {
                    return result;
                }
                return endpointRule87(params, locals);
            }
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule86(S3EndpointParams params, LocalState locals) {
        if (params.useFips()) {
            return RuleResult.endpoint(Endpoint
                    .builder()
                    .url(URI.create("https://" + params.bucket() + ".s3express-fips-" + locals.s3ExpressAvailabilityZoneId()
                            + "." + locals.region() + "." + locals.partitionResult().dnsSuffix()))
                    .putAttribute(KnownS3ExpressEndpointProperty.BACKEND, "S3Express")
                    .putAttribute(
                            AwsEndpointAttribute.AUTH_SCHEMES,
                            Arrays.asList(SigV4AuthScheme.builder().disableDoubleEncoding(true).signingName("s3express")
                                    .signingRegion(locals.region()).build())).build());
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule87(S3EndpointParams params, LocalState locals) {
        return RuleResult.endpoint(Endpoint
                .builder()
                .url(URI.create("https://" + params.bucket() + ".s3express-" + locals.s3ExpressAvailabilityZoneId() + "."
                        + locals.region() + "." + locals.partitionResult().dnsSuffix()))
                .putAttribute(KnownS3ExpressEndpointProperty.BACKEND, "S3Express")
                .putAttribute(
                        AwsEndpointAttribute.AUTH_SCHEMES,
                        Arrays.asList(SigV4AuthScheme.builder().disableDoubleEncoding(true).signingName("s3express")
                                .signingRegion(locals.region()).build())).build());
    }

    private static RuleResult endpointRule88(S3EndpointParams params, LocalState locals) {
        String s3ExpressAvailabilityZoneId = null;
        String s3ExpressAvailabilityZoneDelim = null;
        if ((s3ExpressAvailabilityZoneId = RulesFunctions.substring(params.bucket(), 7, 16, true)) != null) {
            locals = locals.toBuilder().s3ExpressAvailabilityZoneId(s3ExpressAvailabilityZoneId).build();
        } else {
            return RuleResult.carryOn();
        }
        if ((s3ExpressAvailabilityZoneDelim = RulesFunctions.substring(params.bucket(), 16, 18, true)) != null) {
            locals = locals.toBuilder().s3ExpressAvailabilityZoneDelim(s3ExpressAvailabilityZoneDelim).build();
            if ("--".equals(locals.s3ExpressAvailabilityZoneDelim())) {
                RuleResult result = endpointRule89(params, locals);
                if (result.isResolved()) {
                    return result;
                }
                return endpointRule90(params, locals);
            }
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule89(S3EndpointParams params, LocalState locals) {
        if (params.useFips()) {
            return RuleResult.endpoint(Endpoint
                    .builder()
                    .url(URI.create("https://" + params.bucket() + ".s3express-fips-" + locals.s3ExpressAvailabilityZoneId()
                            + "." + locals.region() + "." + locals.partitionResult().dnsSuffix()))
                    .putAttribute(KnownS3ExpressEndpointProperty.BACKEND, "S3Express")
                    .putAttribute(
                            AwsEndpointAttribute.AUTH_SCHEMES,
                            Arrays.asList(SigV4AuthScheme.builder().disableDoubleEncoding(true).signingName("s3express")
                                    .signingRegion(locals.region()).build())).build());
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule90(S3EndpointParams params, LocalState locals) {
        return RuleResult.endpoint(Endpoint
                .builder()
                .url(URI.create("https://" + params.bucket() + ".s3express-" + locals.s3ExpressAvailabilityZoneId() + "."
                        + locals.region() + "." + locals.partitionResult().dnsSuffix()))
                .putAttribute(KnownS3ExpressEndpointProperty.BACKEND, "S3Express")
                .putAttribute(
                        AwsEndpointAttribute.AUTH_SCHEMES,
                        Arrays.asList(SigV4AuthScheme.builder().disableDoubleEncoding(true).signingName("s3express")
                                .signingRegion(locals.region()).build())).build());
    }

    private static RuleResult endpointRule91(S3EndpointParams params, LocalState locals) {
        String s3ExpressAvailabilityZoneId = null;
        String s3ExpressAvailabilityZoneDelim = null;
        if ((s3ExpressAvailabilityZoneId = RulesFunctions.substring(params.bucket(), 7, 20, true)) != null) {
            locals = locals.toBuilder().s3ExpressAvailabilityZoneId(s3ExpressAvailabilityZoneId).build();
        } else {
            return RuleResult.carryOn();
        }
        if ((s3ExpressAvailabilityZoneDelim = RulesFunctions.substring(params.bucket(), 20, 22, true)) != null) {
            locals = locals.toBuilder().s3ExpressAvailabilityZoneDelim(s3ExpressAvailabilityZoneDelim).build();
            if ("--".equals(locals.s3ExpressAvailabilityZoneDelim())) {
                RuleResult result = endpointRule92(params, locals);
                if (result.isResolved()) {
                    return result;
                }
                return endpointRule93(params, locals);
            }
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule92(S3EndpointParams params, LocalState locals) {
        if (params.useFips()) {
            return RuleResult.endpoint(Endpoint
                    .builder()
                    .url(URI.create("https://" + params.bucket() + ".s3express-fips-" + locals.s3ExpressAvailabilityZoneId()
                            + "." + locals.region() + "." + locals.partitionResult().dnsSuffix()))
                    .putAttribute(KnownS3ExpressEndpointProperty.BACKEND, "S3Express")
                    .putAttribute(
                            AwsEndpointAttribute.AUTH_SCHEMES,
                            Arrays.asList(SigV4AuthScheme.builder().disableDoubleEncoding(true).signingName("s3express")
                                    .signingRegion(locals.region()).build())).build());
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule93(S3EndpointParams params, LocalState locals) {
        return RuleResult.endpoint(Endpoint
                .builder()
                .url(URI.create("https://" + params.bucket() + ".s3express-" + locals.s3ExpressAvailabilityZoneId() + "."
                        + locals.region() + "." + locals.partitionResult().dnsSuffix()))
                .putAttribute(KnownS3ExpressEndpointProperty.BACKEND, "S3Express")
                .putAttribute(
                        AwsEndpointAttribute.AUTH_SCHEMES,
                        Arrays.asList(SigV4AuthScheme.builder().disableDoubleEncoding(true).signingName("s3express")
                                .signingRegion(locals.region()).build())).build());
    }

    private static RuleResult endpointRule94(S3EndpointParams params, LocalState locals) {
        String s3ExpressAvailabilityZoneId = null;
        String s3ExpressAvailabilityZoneDelim = null;
        if ((s3ExpressAvailabilityZoneId = RulesFunctions.substring(params.bucket(), 7, 21, true)) != null) {
            locals = locals.toBuilder().s3ExpressAvailabilityZoneId(s3ExpressAvailabilityZoneId).build();
        } else {
            return RuleResult.carryOn();
        }
        if ((s3ExpressAvailabilityZoneDelim = RulesFunctions.substring(params.bucket(), 21, 23, true)) != null) {
            locals = locals.toBuilder().s3ExpressAvailabilityZoneDelim(s3ExpressAvailabilityZoneDelim).build();
            if ("--".equals(locals.s3ExpressAvailabilityZoneDelim())) {
                RuleResult result = endpointRule95(params, locals);
                if (result.isResolved()) {
                    return result;
                }
                return endpointRule96(params, locals);
            }
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule95(S3EndpointParams params, LocalState locals) {
        if (params.useFips()) {
            return RuleResult.endpoint(Endpoint
                    .builder()
                    .url(URI.create("https://" + params.bucket() + ".s3express-fips-" + locals.s3ExpressAvailabilityZoneId()
                            + "." + locals.region() + "." + locals.partitionResult().dnsSuffix()))
                    .putAttribute(KnownS3ExpressEndpointProperty.BACKEND, "S3Express")
                    .putAttribute(
                            AwsEndpointAttribute.AUTH_SCHEMES,
                            Arrays.asList(SigV4AuthScheme.builder().disableDoubleEncoding(true).signingName("s3express")
                                    .signingRegion(locals.region()).build())).build());
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule96(S3EndpointParams params, LocalState locals) {
        return RuleResult.endpoint(Endpoint
                .builder()
                .url(URI.create("https://" + params.bucket() + ".s3express-" + locals.s3ExpressAvailabilityZoneId() + "."
                        + locals.region() + "." + locals.partitionResult().dnsSuffix()))
                .putAttribute(KnownS3ExpressEndpointProperty.BACKEND, "S3Express")
                .putAttribute(
                        AwsEndpointAttribute.AUTH_SCHEMES,
                        Arrays.asList(SigV4AuthScheme.builder().disableDoubleEncoding(true).signingName("s3express")
                                .signingRegion(locals.region()).build())).build());
    }

    private static RuleResult endpointRule97(S3EndpointParams params, LocalState locals) {
        String s3ExpressAvailabilityZoneId = null;
        String s3ExpressAvailabilityZoneDelim = null;
        if ((s3ExpressAvailabilityZoneId = RulesFunctions.substring(params.bucket(), 7, 27, true)) != null) {
            locals = locals.toBuilder().s3ExpressAvailabilityZoneId(s3ExpressAvailabilityZoneId).build();
        } else {
            return RuleResult.carryOn();
        }
        if ((s3ExpressAvailabilityZoneDelim = RulesFunctions.substring(params.bucket(), 27, 29, true)) != null) {
            locals = locals.toBuilder().s3ExpressAvailabilityZoneDelim(s3ExpressAvailabilityZoneDelim).build();
            if ("--".equals(locals.s3ExpressAvailabilityZoneDelim())) {
                RuleResult result = endpointRule98(params, locals);
                if (result.isResolved()) {
                    return result;
                }
                return endpointRule99(params, locals);
            }
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule98(S3EndpointParams params, LocalState locals) {
        if (params.useFips()) {
            return RuleResult.endpoint(Endpoint
                    .builder()
                    .url(URI.create("https://" + params.bucket() + ".s3express-fips-" + locals.s3ExpressAvailabilityZoneId()
                            + "." + locals.region() + "." + locals.partitionResult().dnsSuffix()))
                    .putAttribute(KnownS3ExpressEndpointProperty.BACKEND, "S3Express")
                    .putAttribute(
                            AwsEndpointAttribute.AUTH_SCHEMES,
                            Arrays.asList(SigV4AuthScheme.builder().disableDoubleEncoding(true).signingName("s3express")
                                    .signingRegion(locals.region()).build())).build());
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule99(S3EndpointParams params, LocalState locals) {
        return RuleResult.endpoint(Endpoint
                .builder()
                .url(URI.create("https://" + params.bucket() + ".s3express-" + locals.s3ExpressAvailabilityZoneId() + "."
                        + locals.region() + "." + locals.partitionResult().dnsSuffix()))
                .putAttribute(KnownS3ExpressEndpointProperty.BACKEND, "S3Express")
                .putAttribute(
                        AwsEndpointAttribute.AUTH_SCHEMES,
                        Arrays.asList(SigV4AuthScheme.builder().disableDoubleEncoding(true).signingName("s3express")
                                .signingRegion(locals.region()).build())).build());
    }

    private static RuleResult endpointRule100(S3EndpointParams params, LocalState locals) {
        return RuleResult.error("Unrecognized S3Express bucket name format.");
    }

    private static RuleResult endpointRule101(S3EndpointParams params, LocalState locals) {
        String s3ExpressAvailabilityZoneId = null;
        String s3ExpressAvailabilityZoneDelim = null;
        if ((s3ExpressAvailabilityZoneId = RulesFunctions.substring(params.bucket(), 7, 15, true)) != null) {
            locals = locals.toBuilder().s3ExpressAvailabilityZoneId(s3ExpressAvailabilityZoneId).build();
        } else {
            return RuleResult.carryOn();
        }
        if ((s3ExpressAvailabilityZoneDelim = RulesFunctions.substring(params.bucket(), 15, 17, true)) != null) {
            locals = locals.toBuilder().s3ExpressAvailabilityZoneDelim(s3ExpressAvailabilityZoneDelim).build();
            if ("--".equals(locals.s3ExpressAvailabilityZoneDelim())) {
                RuleResult result = endpointRule102(params, locals);
                if (result.isResolved()) {
                    return result;
                }
                return endpointRule103(params, locals);
            }
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule102(S3EndpointParams params, LocalState locals) {
        if (params.useFips()) {
            return RuleResult.endpoint(Endpoint
                    .builder()
                    .url(URI.create("https://" + params.bucket() + ".s3express-fips-" + locals.s3ExpressAvailabilityZoneId()
                            + "." + locals.region() + "." + locals.partitionResult().dnsSuffix()))
                    .putAttribute(KnownS3ExpressEndpointProperty.BACKEND, "S3Express")
                    .putAttribute(
                            AwsEndpointAttribute.AUTH_SCHEMES,
                            Arrays.asList(S3ExpressEndpointAuthScheme.builder().disableDoubleEncoding(true)
                                    .signingName("s3express").signingRegion(locals.region()).build())).build());
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule103(S3EndpointParams params, LocalState locals) {
        return RuleResult.endpoint(Endpoint
                .builder()
                .url(URI.create("https://" + params.bucket() + ".s3express-" + locals.s3ExpressAvailabilityZoneId() + "."
                        + locals.region() + "." + locals.partitionResult().dnsSuffix()))
                .putAttribute(KnownS3ExpressEndpointProperty.BACKEND, "S3Express")
                .putAttribute(
                        AwsEndpointAttribute.AUTH_SCHEMES,
                        Arrays.asList(S3ExpressEndpointAuthScheme.builder().disableDoubleEncoding(true).signingName("s3express")
                                .signingRegion(locals.region()).build())).build());
    }

    private static RuleResult endpointRule104(S3EndpointParams params, LocalState locals) {
        String s3ExpressAvailabilityZoneId = null;
        String s3ExpressAvailabilityZoneDelim = null;
        if ((s3ExpressAvailabilityZoneId = RulesFunctions.substring(params.bucket(), 7, 16, true)) != null) {
            locals = locals.toBuilder().s3ExpressAvailabilityZoneId(s3ExpressAvailabilityZoneId).build();
        } else {
            return RuleResult.carryOn();
        }
        if ((s3ExpressAvailabilityZoneDelim = RulesFunctions.substring(params.bucket(), 16, 18, true)) != null) {
            locals = locals.toBuilder().s3ExpressAvailabilityZoneDelim(s3ExpressAvailabilityZoneDelim).build();
            if ("--".equals(locals.s3ExpressAvailabilityZoneDelim())) {
                RuleResult result = endpointRule105(params, locals);
                if (result.isResolved()) {
                    return result;
                }
                return endpointRule106(params, locals);
            }
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule105(S3EndpointParams params, LocalState locals) {
        if (params.useFips()) {
            return RuleResult.endpoint(Endpoint
                    .builder()
                    .url(URI.create("https://" + params.bucket() + ".s3express-fips-" + locals.s3ExpressAvailabilityZoneId()
                            + "." + locals.region() + "." + locals.partitionResult().dnsSuffix()))
                    .putAttribute(KnownS3ExpressEndpointProperty.BACKEND, "S3Express")
                    .putAttribute(
                            AwsEndpointAttribute.AUTH_SCHEMES,
                            Arrays.asList(S3ExpressEndpointAuthScheme.builder().disableDoubleEncoding(true)
                                    .signingName("s3express").signingRegion(locals.region()).build())).build());
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule106(S3EndpointParams params, LocalState locals) {
        return RuleResult.endpoint(Endpoint
                .builder()
                .url(URI.create("https://" + params.bucket() + ".s3express-" + locals.s3ExpressAvailabilityZoneId() + "."
                        + locals.region() + "." + locals.partitionResult().dnsSuffix()))
                .putAttribute(KnownS3ExpressEndpointProperty.BACKEND, "S3Express")
                .putAttribute(
                        AwsEndpointAttribute.AUTH_SCHEMES,
                        Arrays.asList(S3ExpressEndpointAuthScheme.builder().disableDoubleEncoding(true).signingName("s3express")
                                .signingRegion(locals.region()).build())).build());
    }

    private static RuleResult endpointRule107(S3EndpointParams params, LocalState locals) {
        String s3ExpressAvailabilityZoneId = null;
        String s3ExpressAvailabilityZoneDelim = null;
        if ((s3ExpressAvailabilityZoneId = RulesFunctions.substring(params.bucket(), 7, 20, true)) != null) {
            locals = locals.toBuilder().s3ExpressAvailabilityZoneId(s3ExpressAvailabilityZoneId).build();
        } else {
            return RuleResult.carryOn();
        }
        if ((s3ExpressAvailabilityZoneDelim = RulesFunctions.substring(params.bucket(), 20, 22, true)) != null) {
            locals = locals.toBuilder().s3ExpressAvailabilityZoneDelim(s3ExpressAvailabilityZoneDelim).build();
            if ("--".equals(locals.s3ExpressAvailabilityZoneDelim())) {
                RuleResult result = endpointRule108(params, locals);
                if (result.isResolved()) {
                    return result;
                }
                return endpointRule109(params, locals);
            }
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule108(S3EndpointParams params, LocalState locals) {
        if (params.useFips()) {
            return RuleResult.endpoint(Endpoint
                    .builder()
                    .url(URI.create("https://" + params.bucket() + ".s3express-fips-" + locals.s3ExpressAvailabilityZoneId()
                            + "." + locals.region() + "." + locals.partitionResult().dnsSuffix()))
                    .putAttribute(KnownS3ExpressEndpointProperty.BACKEND, "S3Express")
                    .putAttribute(
                            AwsEndpointAttribute.AUTH_SCHEMES,
                            Arrays.asList(S3ExpressEndpointAuthScheme.builder().disableDoubleEncoding(true)
                                    .signingName("s3express").signingRegion(locals.region()).build())).build());
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule109(S3EndpointParams params, LocalState locals) {
        return RuleResult.endpoint(Endpoint
                .builder()
                .url(URI.create("https://" + params.bucket() + ".s3express-" + locals.s3ExpressAvailabilityZoneId() + "."
                        + locals.region() + "." + locals.partitionResult().dnsSuffix()))
                .putAttribute(KnownS3ExpressEndpointProperty.BACKEND, "S3Express")
                .putAttribute(
                        AwsEndpointAttribute.AUTH_SCHEMES,
                        Arrays.asList(S3ExpressEndpointAuthScheme.builder().disableDoubleEncoding(true).signingName("s3express")
                                .signingRegion(locals.region()).build())).build());
    }

    private static RuleResult endpointRule110(S3EndpointParams params, LocalState locals) {
        String s3ExpressAvailabilityZoneId = null;
        String s3ExpressAvailabilityZoneDelim = null;
        if ((s3ExpressAvailabilityZoneId = RulesFunctions.substring(params.bucket(), 7, 21, true)) != null) {
            locals = locals.toBuilder().s3ExpressAvailabilityZoneId(s3ExpressAvailabilityZoneId).build();
        } else {
            return RuleResult.carryOn();
        }
        if ((s3ExpressAvailabilityZoneDelim = RulesFunctions.substring(params.bucket(), 21, 23, true)) != null) {
            locals = locals.toBuilder().s3ExpressAvailabilityZoneDelim(s3ExpressAvailabilityZoneDelim).build();
            if ("--".equals(locals.s3ExpressAvailabilityZoneDelim())) {
                RuleResult result = endpointRule111(params, locals);
                if (result.isResolved()) {
                    return result;
                }
                return endpointRule112(params, locals);
            }
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule111(S3EndpointParams params, LocalState locals) {
        if (params.useFips()) {
            return RuleResult.endpoint(Endpoint
                    .builder()
                    .url(URI.create("https://" + params.bucket() + ".s3express-fips-" + locals.s3ExpressAvailabilityZoneId()
                            + "." + locals.region() + "." + locals.partitionResult().dnsSuffix()))
                    .putAttribute(KnownS3ExpressEndpointProperty.BACKEND, "S3Express")
                    .putAttribute(
                            AwsEndpointAttribute.AUTH_SCHEMES,
                            Arrays.asList(S3ExpressEndpointAuthScheme.builder().disableDoubleEncoding(true)
                                    .signingName("s3express").signingRegion(locals.region()).build())).build());
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule112(S3EndpointParams params, LocalState locals) {
        return RuleResult.endpoint(Endpoint
                .builder()
                .url(URI.create("https://" + params.bucket() + ".s3express-" + locals.s3ExpressAvailabilityZoneId() + "."
                        + locals.region() + "." + locals.partitionResult().dnsSuffix()))
                .putAttribute(KnownS3ExpressEndpointProperty.BACKEND, "S3Express")
                .putAttribute(
                        AwsEndpointAttribute.AUTH_SCHEMES,
                        Arrays.asList(S3ExpressEndpointAuthScheme.builder().disableDoubleEncoding(true).signingName("s3express")
                                .signingRegion(locals.region()).build())).build());
    }

    private static RuleResult endpointRule113(S3EndpointParams params, LocalState locals) {
        String s3ExpressAvailabilityZoneId = null;
        String s3ExpressAvailabilityZoneDelim = null;
        if ((s3ExpressAvailabilityZoneId = RulesFunctions.substring(params.bucket(), 7, 27, true)) != null) {
            locals = locals.toBuilder().s3ExpressAvailabilityZoneId(s3ExpressAvailabilityZoneId).build();
        } else {
            return RuleResult.carryOn();
        }
        if ((s3ExpressAvailabilityZoneDelim = RulesFunctions.substring(params.bucket(), 27, 29, true)) != null) {
            locals = locals.toBuilder().s3ExpressAvailabilityZoneDelim(s3ExpressAvailabilityZoneDelim).build();
            if ("--".equals(locals.s3ExpressAvailabilityZoneDelim())) {
                RuleResult result = endpointRule114(params, locals);
                if (result.isResolved()) {
                    return result;
                }
                return endpointRule115(params, locals);
            }
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule114(S3EndpointParams params, LocalState locals) {
        if (params.useFips()) {
            return RuleResult.endpoint(Endpoint
                    .builder()
                    .url(URI.create("https://" + params.bucket() + ".s3express-fips-" + locals.s3ExpressAvailabilityZoneId()
                            + "." + locals.region() + "." + locals.partitionResult().dnsSuffix()))
                    .putAttribute(KnownS3ExpressEndpointProperty.BACKEND, "S3Express")
                    .putAttribute(
                            AwsEndpointAttribute.AUTH_SCHEMES,
                            Arrays.asList(S3ExpressEndpointAuthScheme.builder().disableDoubleEncoding(true)
                                    .signingName("s3express").signingRegion(locals.region()).build())).build());
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule115(S3EndpointParams params, LocalState locals) {
        return RuleResult.endpoint(Endpoint
                .builder()
                .url(URI.create("https://" + params.bucket() + ".s3express-" + locals.s3ExpressAvailabilityZoneId() + "."
                        + locals.region() + "." + locals.partitionResult().dnsSuffix()))
                .putAttribute(KnownS3ExpressEndpointProperty.BACKEND, "S3Express")
                .putAttribute(
                        AwsEndpointAttribute.AUTH_SCHEMES,
                        Arrays.asList(S3ExpressEndpointAuthScheme.builder().disableDoubleEncoding(true).signingName("s3express")
                                .signingRegion(locals.region()).build())).build());
    }

    private static RuleResult endpointRule116(S3EndpointParams params, LocalState locals) {
        return RuleResult.error("Unrecognized S3Express bucket name format.");
    }

    private static RuleResult endpointRule117(S3EndpointParams params, LocalState locals) {
        return RuleResult.error("S3Express bucket name is not a valid virtual hostable name.");
    }

    private static RuleResult endpointRule118(S3EndpointParams params, LocalState locals) {
        if (params.bucket() == null && params.useS3ExpressControlEndpoint() != null && params.useS3ExpressControlEndpoint()) {
            return endpointRule119(params, locals);
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule119(S3EndpointParams params, LocalState locals) {
        RulePartition partitionResult = null;
        if ((partitionResult = RulesFunctions.awsPartition(locals.region())) != null) {
            locals = locals.toBuilder().partitionResult(partitionResult).build();
            RuleResult result = endpointRule120(params, locals);
            if (result.isResolved()) {
                return result;
            }
            result = endpointRule121(params, locals);
            if (result.isResolved()) {
                return result;
            }
            return endpointRule122(params, locals);
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule120(S3EndpointParams params, LocalState locals) {
        if (params.endpoint() != null) {
            RuleUrl url = null;
            if ((url = RulesFunctions.parseURL(params.endpoint())) != null) {
                locals = locals.toBuilder().url(url).build();
                return RuleResult.endpoint(Endpoint
                        .builder()
                        .url(URI.create(locals.url().scheme() + "://" + locals.url().authority() + locals.url().path()))
                        .putAttribute(KnownS3ExpressEndpointProperty.BACKEND, "S3Express")
                        .putAttribute(
                                AwsEndpointAttribute.AUTH_SCHEMES,
                                Arrays.asList(SigV4AuthScheme.builder().disableDoubleEncoding(true).signingName("s3express")
                                        .signingRegion(locals.region()).build())).build());
            }
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule121(S3EndpointParams params, LocalState locals) {
        if (params.useFips()) {
            return RuleResult.endpoint(Endpoint
                    .builder()
                    .url(URI.create("https://s3express-control-fips." + locals.region() + "."
                            + locals.partitionResult().dnsSuffix()))
                    .putAttribute(KnownS3ExpressEndpointProperty.BACKEND, "S3Express")
                    .putAttribute(
                            AwsEndpointAttribute.AUTH_SCHEMES,
                            Arrays.asList(SigV4AuthScheme.builder().disableDoubleEncoding(true).signingName("s3express")
                                    .signingRegion(locals.region()).build())).build());
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule122(S3EndpointParams params, LocalState locals) {
        return RuleResult.endpoint(Endpoint
                .builder()
                .url(URI.create("https://s3express-control." + locals.region() + "." + locals.partitionResult().dnsSuffix()))
                .putAttribute(KnownS3ExpressEndpointProperty.BACKEND, "S3Express")
                .putAttribute(
                        AwsEndpointAttribute.AUTH_SCHEMES,
                        Arrays.asList(SigV4AuthScheme.builder().disableDoubleEncoding(true).signingName("s3express")
                                .signingRegion(locals.region()).build())).build());
    }

    private static RuleResult endpointRule123(S3EndpointParams params, LocalState locals) {
        if (params.bucket() != null) {
            String hardwareType = null;
            String regionPrefix = null;
            String bucketAliasSuffix = null;
            String outpostId = null;
            RulePartition regionPartition = null;
            if ((hardwareType = RulesFunctions.substring(params.bucket(), 49, 50, true)) != null) {
                locals = locals.toBuilder().hardwareType(hardwareType).build();
            } else {
                return RuleResult.carryOn();
            }
            if ((regionPrefix = RulesFunctions.substring(params.bucket(), 8, 12, true)) != null) {
                locals = locals.toBuilder().regionPrefix(regionPrefix).build();
            } else {
                return RuleResult.carryOn();
            }
            if ((bucketAliasSuffix = RulesFunctions.substring(params.bucket(), 0, 7, true)) != null) {
                locals = locals.toBuilder().bucketAliasSuffix(bucketAliasSuffix).build();
            } else {
                return RuleResult.carryOn();
            }
            if ((outpostId = RulesFunctions.substring(params.bucket(), 32, 49, true)) != null) {
                locals = locals.toBuilder().outpostId(outpostId).build();
            } else {
                return RuleResult.carryOn();
            }
            if ((regionPartition = RulesFunctions.awsPartition(locals.region())) != null) {
                locals = locals.toBuilder().regionPartition(regionPartition).build();
                if ("--op-s3".equals(locals.bucketAliasSuffix())) {
                    RuleResult result = endpointRule124(params, locals);
                    if (result.isResolved()) {
                        return result;
                    }
                    return endpointRule136(params, locals);
                }
            }
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule124(S3EndpointParams params, LocalState locals) {
        if (RulesFunctions.isValidHostLabel(locals.outpostId(), false)) {
            RuleResult result = endpointRule125(params, locals);
            if (result.isResolved()) {
                return result;
            }
            result = endpointRule130(params, locals);
            if (result.isResolved()) {
                return result;
            }
            return endpointRule135(params, locals);
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule125(S3EndpointParams params, LocalState locals) {
        if ("e".equals(locals.hardwareType())) {
            RuleResult result = endpointRule126(params, locals);
            if (result.isResolved()) {
                return result;
            }
            return endpointRule129(params, locals);
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule126(S3EndpointParams params, LocalState locals) {
        if ("beta".equals(locals.regionPrefix())) {
            RuleResult result = endpointRule127(params, locals);
            if (result.isResolved()) {
                return result;
            }
            return endpointRule128(params, locals);
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule127(S3EndpointParams params, LocalState locals) {
        if (params.endpoint() == null) {
            return RuleResult.error("Expected a endpoint to be specified but no endpoint was found");
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule128(S3EndpointParams params, LocalState locals) {
        if (params.endpoint() != null) {
            RuleUrl url = null;
            if ((url = RulesFunctions.parseURL(params.endpoint())) != null) {
                locals = locals.toBuilder().url(url).build();
                return RuleResult.endpoint(Endpoint
                        .builder()
                        .url(URI.create("https://" + params.bucket() + ".ec2." + locals.url().authority()))
                        .putAttribute(
                                AwsEndpointAttribute.AUTH_SCHEMES,
                                Arrays.asList(SigV4aAuthScheme.builder().disableDoubleEncoding(true).signingName("s3-outposts")
                                        .signingRegionSet(Arrays.asList("*")).build(), SigV4AuthScheme.builder()
                                        .disableDoubleEncoding(true).signingName("s3-outposts").signingRegion(locals.region())
                                        .build())).build());
            }
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule129(S3EndpointParams params, LocalState locals) {
        return RuleResult.endpoint(Endpoint
                .builder()
                .url(URI.create("https://" + params.bucket() + ".ec2.s3-outposts." + locals.region() + "."
                        + locals.regionPartition().dnsSuffix()))
                .putAttribute(
                        AwsEndpointAttribute.AUTH_SCHEMES,
                        Arrays.asList(
                                SigV4aAuthScheme.builder().disableDoubleEncoding(true).signingName("s3-outposts")
                                        .signingRegionSet(Arrays.asList("*")).build(),
                                SigV4AuthScheme.builder().disableDoubleEncoding(true).signingName("s3-outposts")
                                        .signingRegion(locals.region()).build())).build());
    }

    private static RuleResult endpointRule130(S3EndpointParams params, LocalState locals) {
        if ("o".equals(locals.hardwareType())) {
            RuleResult result = endpointRule131(params, locals);
            if (result.isResolved()) {
                return result;
            }
            return endpointRule134(params, locals);
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule131(S3EndpointParams params, LocalState locals) {
        if ("beta".equals(locals.regionPrefix())) {
            RuleResult result = endpointRule132(params, locals);
            if (result.isResolved()) {
                return result;
            }
            return endpointRule133(params, locals);
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule132(S3EndpointParams params, LocalState locals) {
        if (params.endpoint() == null) {
            return RuleResult.error("Expected a endpoint to be specified but no endpoint was found");
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule133(S3EndpointParams params, LocalState locals) {
        if (params.endpoint() != null) {
            RuleUrl url = null;
            if ((url = RulesFunctions.parseURL(params.endpoint())) != null) {
                locals = locals.toBuilder().url(url).build();
                return RuleResult.endpoint(Endpoint
                        .builder()
                        .url(URI.create("https://" + params.bucket() + ".op-" + locals.outpostId() + "."
                                + locals.url().authority()))
                        .putAttribute(
                                AwsEndpointAttribute.AUTH_SCHEMES,
                                Arrays.asList(SigV4aAuthScheme.builder().disableDoubleEncoding(true).signingName("s3-outposts")
                                        .signingRegionSet(Arrays.asList("*")).build(), SigV4AuthScheme.builder()
                                        .disableDoubleEncoding(true).signingName("s3-outposts").signingRegion(locals.region())
                                        .build())).build());
            }
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule134(S3EndpointParams params, LocalState locals) {
        return RuleResult.endpoint(Endpoint
                .builder()
                .url(URI.create("https://" + params.bucket() + ".op-" + locals.outpostId() + ".s3-outposts." + locals.region()
                        + "." + locals.regionPartition().dnsSuffix()))
                .putAttribute(
                        AwsEndpointAttribute.AUTH_SCHEMES,
                        Arrays.asList(
                                SigV4aAuthScheme.builder().disableDoubleEncoding(true).signingName("s3-outposts")
                                        .signingRegionSet(Arrays.asList("*")).build(),
                                SigV4AuthScheme.builder().disableDoubleEncoding(true).signingName("s3-outposts")
                                        .signingRegion(locals.region()).build())).build());
    }

    private static RuleResult endpointRule135(S3EndpointParams params, LocalState locals) {
        return RuleResult.error("Unrecognized hardware type: \"Expected hardware type o or e but got " + locals.hardwareType()
                + "\"");
    }

    private static RuleResult endpointRule136(S3EndpointParams params, LocalState locals) {
        return RuleResult.error("Invalid ARN: The outpost Id must only contain a-z, A-Z, 0-9 and `-`.");
    }

    private static RuleResult endpointRule137(S3EndpointParams params, LocalState locals) {
        if (params.bucket() != null) {
            RuleResult result = endpointRule138(params, locals);
            if (result.isResolved()) {
                return result;
            }
            result = endpointRule139(params, locals);
            if (result.isResolved()) {
                return result;
            }
            result = endpointRule180(params, locals);
            if (result.isResolved()) {
                return result;
            }
            result = endpointRule185(params, locals);
            if (result.isResolved()) {
                return result;
            }
            result = endpointRule280(params, locals);
            if (result.isResolved()) {
                return result;
            }
            result = endpointRule281(params, locals);
            if (result.isResolved()) {
                return result;
            }
            return endpointRule282(params, locals);
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule138(S3EndpointParams params, LocalState locals) {
        if (params.endpoint() != null && RulesFunctions.parseURL(params.endpoint()) == null) {
            return RuleResult.error("Custom endpoint `" + params.endpoint() + "` was not a valid URI");
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule139(S3EndpointParams params, LocalState locals) {
        if (!params.forcePathStyle() && RulesFunctions.awsIsVirtualHostableS3Bucket(params.bucket(), false)) {
            return endpointRule140(params, locals);
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule140(S3EndpointParams params, LocalState locals) {
        RulePartition partitionResult = null;
        if ((partitionResult = RulesFunctions.awsPartition(locals.region())) != null) {
            locals = locals.toBuilder().partitionResult(partitionResult).build();
            RuleResult result = endpointRule141(params, locals);
            if (result.isResolved()) {
                return result;
            }
            return endpointRule179(params, locals);
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule141(S3EndpointParams params, LocalState locals) {
        if (RulesFunctions.isValidHostLabel(locals.region(), false)) {
            RuleResult result = endpointRule142(params, locals);
            if (result.isResolved()) {
                return result;
            }
            result = endpointRule143(params, locals);
            if (result.isResolved()) {
                return result;
            }
            result = endpointRule144(params, locals);
            if (result.isResolved()) {
                return result;
            }
            result = endpointRule146(params, locals);
            if (result.isResolved()) {
                return result;
            }
            result = endpointRule147(params, locals);
            if (result.isResolved()) {
                return result;
            }
            result = endpointRule148(params, locals);
            if (result.isResolved()) {
                return result;
            }
            result = endpointRule150(params, locals);
            if (result.isResolved()) {
                return result;
            }
            result = endpointRule151(params, locals);
            if (result.isResolved()) {
                return result;
            }
            result = endpointRule152(params, locals);
            if (result.isResolved()) {
                return result;
            }
            result = endpointRule154(params, locals);
            if (result.isResolved()) {
                return result;
            }
            result = endpointRule155(params, locals);
            if (result.isResolved()) {
                return result;
            }
            result = endpointRule156(params, locals);
            if (result.isResolved()) {
                return result;
            }
            result = endpointRule158(params, locals);
            if (result.isResolved()) {
                return result;
            }
            result = endpointRule159(params, locals);
            if (result.isResolved()) {
                return result;
            }
            result = endpointRule160(params, locals);
            if (result.isResolved()) {
                return result;
            }
            result = endpointRule161(params, locals);
            if (result.isResolved()) {
                return result;
            }
            result = endpointRule164(params, locals);
            if (result.isResolved()) {
                return result;
            }
            result = endpointRule167(params, locals);
            if (result.isResolved()) {
                return result;
            }
            result = endpointRule168(params, locals);
            if (result.isResolved()) {
                return result;
            }
            result = endpointRule169(params, locals);
            if (result.isResolved()) {
                return result;
            }
            result = endpointRule170(params, locals);
            if (result.isResolved()) {
                return result;
            }
            result = endpointRule173(params, locals);
            if (result.isResolved()) {
                return result;
            }
            result = endpointRule174(params, locals);
            if (result.isResolved()) {
                return result;
            }
            result = endpointRule175(params, locals);
            if (result.isResolved()) {
                return result;
            }
            return endpointRule178(params, locals);
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule142(S3EndpointParams params, LocalState locals) {
        if (params.accelerate() && "aws-cn".equals(locals.partitionResult().name())) {
            return RuleResult.error("S3 Accelerate cannot be used in this region");
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule143(S3EndpointParams params, LocalState locals) {
        if (params.useDualStack() && params.useFips() && !params.accelerate() && params.endpoint() == null
                && "aws-global".equals(locals.region())) {
            return RuleResult.endpoint(Endpoint
                    .builder()
                    .url(URI.create("https://" + params.bucket() + ".s3-fips.dualstack.us-east-1."
                            + locals.partitionResult().dnsSuffix()))
                    .putAttribute(
                            AwsEndpointAttribute.AUTH_SCHEMES,
                            Arrays.asList(SigV4AuthScheme.builder().disableDoubleEncoding(true).signingName("s3")
                                    .signingRegion("us-east-1").build())).build());
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule144(S3EndpointParams params, LocalState locals) {
        if (params.useDualStack() && params.useFips() && !params.accelerate() && params.endpoint() == null
                && !("aws-global".equals(locals.region())) && params.useGlobalEndpoint()) {
            return endpointRule145(params, locals);
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule145(S3EndpointParams params, LocalState locals) {
        return RuleResult.endpoint(Endpoint
                .builder()
                .url(URI.create("https://" + params.bucket() + ".s3-fips.dualstack." + locals.region() + "."
                        + locals.partitionResult().dnsSuffix()))
                .putAttribute(
                        AwsEndpointAttribute.AUTH_SCHEMES,
                        Arrays.asList(SigV4AuthScheme.builder().disableDoubleEncoding(true).signingName("s3")
                                .signingRegion(locals.region()).build())).build());
    }

    private static RuleResult endpointRule146(S3EndpointParams params, LocalState locals) {
        if (params.useDualStack() && params.useFips() && !params.accelerate() && params.endpoint() == null
                && !("aws-global".equals(locals.region())) && !params.useGlobalEndpoint()) {
            return RuleResult.endpoint(Endpoint
                    .builder()
                    .url(URI.create("https://" + params.bucket() + ".s3-fips.dualstack." + locals.region() + "."
                            + locals.partitionResult().dnsSuffix()))
                    .putAttribute(
                            AwsEndpointAttribute.AUTH_SCHEMES,
                            Arrays.asList(SigV4AuthScheme.builder().disableDoubleEncoding(true).signingName("s3")
                                    .signingRegion(locals.region()).build())).build());
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule147(S3EndpointParams params, LocalState locals) {
        if (!params.useDualStack() && params.useFips() && !params.accelerate() && params.endpoint() == null
                && "aws-global".equals(locals.region())) {
            return RuleResult.endpoint(Endpoint
                    .builder()
                    .url(URI.create("https://" + params.bucket() + ".s3-fips.us-east-1." + locals.partitionResult().dnsSuffix()))
                    .putAttribute(
                            AwsEndpointAttribute.AUTH_SCHEMES,
                            Arrays.asList(SigV4AuthScheme.builder().disableDoubleEncoding(true).signingName("s3")
                                    .signingRegion("us-east-1").build())).build());
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule148(S3EndpointParams params, LocalState locals) {
        if (!params.useDualStack() && params.useFips() && !params.accelerate() && params.endpoint() == null
                && !("aws-global".equals(locals.region())) && params.useGlobalEndpoint()) {
            return endpointRule149(params, locals);
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule149(S3EndpointParams params, LocalState locals) {
        return RuleResult.endpoint(Endpoint
                .builder()
                .url(URI.create("https://" + params.bucket() + ".s3-fips." + locals.region() + "."
                        + locals.partitionResult().dnsSuffix()))
                .putAttribute(
                        AwsEndpointAttribute.AUTH_SCHEMES,
                        Arrays.asList(SigV4AuthScheme.builder().disableDoubleEncoding(true).signingName("s3")
                                .signingRegion(locals.region()).build())).build());
    }

    private static RuleResult endpointRule150(S3EndpointParams params, LocalState locals) {
        if (!params.useDualStack() && params.useFips() && !params.accelerate() && params.endpoint() == null
                && !("aws-global".equals(locals.region())) && !params.useGlobalEndpoint()) {
            return RuleResult.endpoint(Endpoint
                    .builder()
                    .url(URI.create("https://" + params.bucket() + ".s3-fips." + locals.region() + "."
                            + locals.partitionResult().dnsSuffix()))
                    .putAttribute(
                            AwsEndpointAttribute.AUTH_SCHEMES,
                            Arrays.asList(SigV4AuthScheme.builder().disableDoubleEncoding(true).signingName("s3")
                                    .signingRegion(locals.region()).build())).build());
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule151(S3EndpointParams params, LocalState locals) {
        if (params.useDualStack() && !params.useFips() && params.accelerate() && params.endpoint() == null
                && "aws-global".equals(locals.region())) {
            return RuleResult.endpoint(Endpoint
                    .builder()
                    .url(URI.create("https://" + params.bucket() + ".s3-accelerate.dualstack.us-east-1."
                            + locals.partitionResult().dnsSuffix()))
                    .putAttribute(
                            AwsEndpointAttribute.AUTH_SCHEMES,
                            Arrays.asList(SigV4AuthScheme.builder().disableDoubleEncoding(true).signingName("s3")
                                    .signingRegion("us-east-1").build())).build());
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule152(S3EndpointParams params, LocalState locals) {
        if (params.useDualStack() && !params.useFips() && params.accelerate() && params.endpoint() == null
                && !("aws-global".equals(locals.region())) && params.useGlobalEndpoint()) {
            return endpointRule153(params, locals);
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule153(S3EndpointParams params, LocalState locals) {
        return RuleResult
                .endpoint(Endpoint
                        .builder()
                        .url(URI.create("https://" + params.bucket() + ".s3-accelerate.dualstack."
                                + locals.partitionResult().dnsSuffix()))
                        .putAttribute(
                                AwsEndpointAttribute.AUTH_SCHEMES,
                                Arrays.asList(SigV4AuthScheme.builder().disableDoubleEncoding(true).signingName("s3")
                                        .signingRegion(locals.region()).build())).build());
    }

    private static RuleResult endpointRule154(S3EndpointParams params, LocalState locals) {
        if (params.useDualStack() && !params.useFips() && params.accelerate() && params.endpoint() == null
                && !("aws-global".equals(locals.region())) && !params.useGlobalEndpoint()) {
            return RuleResult.endpoint(Endpoint
                    .builder()
                    .url(URI.create("https://" + params.bucket() + ".s3-accelerate.dualstack."
                            + locals.partitionResult().dnsSuffix()))
                    .putAttribute(
                            AwsEndpointAttribute.AUTH_SCHEMES,
                            Arrays.asList(SigV4AuthScheme.builder().disableDoubleEncoding(true).signingName("s3")
                                    .signingRegion(locals.region()).build())).build());
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule155(S3EndpointParams params, LocalState locals) {
        if (params.useDualStack() && !params.useFips() && !params.accelerate() && params.endpoint() == null
                && "aws-global".equals(locals.region())) {
            return RuleResult.endpoint(Endpoint
                    .builder()
                    .url(URI.create("https://" + params.bucket() + ".s3.dualstack.us-east-1."
                            + locals.partitionResult().dnsSuffix()))
                    .putAttribute(
                            AwsEndpointAttribute.AUTH_SCHEMES,
                            Arrays.asList(SigV4AuthScheme.builder().disableDoubleEncoding(true).signingName("s3")
                                    .signingRegion("us-east-1").build())).build());
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule156(S3EndpointParams params, LocalState locals) {
        if (params.useDualStack() && !params.useFips() && !params.accelerate() && params.endpoint() == null
                && !("aws-global".equals(locals.region())) && params.useGlobalEndpoint()) {
            return endpointRule157(params, locals);
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule157(S3EndpointParams params, LocalState locals) {
        return RuleResult.endpoint(Endpoint
                .builder()
                .url(URI.create("https://" + params.bucket() + ".s3.dualstack." + locals.region() + "."
                        + locals.partitionResult().dnsSuffix()))
                .putAttribute(
                        AwsEndpointAttribute.AUTH_SCHEMES,
                        Arrays.asList(SigV4AuthScheme.builder().disableDoubleEncoding(true).signingName("s3")
                                .signingRegion(locals.region()).build())).build());
    }

    private static RuleResult endpointRule158(S3EndpointParams params, LocalState locals) {
        if (params.useDualStack() && !params.useFips() && !params.accelerate() && params.endpoint() == null
                && !("aws-global".equals(locals.region())) && !params.useGlobalEndpoint()) {
            return RuleResult.endpoint(Endpoint
                    .builder()
                    .url(URI.create("https://" + params.bucket() + ".s3.dualstack." + locals.region() + "."
                            + locals.partitionResult().dnsSuffix()))
                    .putAttribute(
                            AwsEndpointAttribute.AUTH_SCHEMES,
                            Arrays.asList(SigV4AuthScheme.builder().disableDoubleEncoding(true).signingName("s3")
                                    .signingRegion(locals.region()).build())).build());
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule159(S3EndpointParams params, LocalState locals) {
        if (!params.useDualStack() && !params.useFips() && !params.accelerate() && params.endpoint() != null) {
            RuleUrl url = null;
            if ((url = RulesFunctions.parseURL(params.endpoint())) != null) {
                locals = locals.toBuilder().url(url).build();
                if (locals.url().isIp() && "aws-global".equals(locals.region())) {
                    return RuleResult.endpoint(Endpoint
                            .builder()
                            .url(URI.create(locals.url().scheme() + "://" + locals.url().authority()
                                    + locals.url().normalizedPath() + params.bucket()))
                            .putAttribute(
                                    AwsEndpointAttribute.AUTH_SCHEMES,
                                    Arrays.asList(SigV4AuthScheme.builder().disableDoubleEncoding(true).signingName("s3")
                                            .signingRegion("us-east-1").build())).build());
                }
            }
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule160(S3EndpointParams params, LocalState locals) {
        if (!params.useDualStack() && !params.useFips() && !params.accelerate() && params.endpoint() != null) {
            RuleUrl url = null;
            if ((url = RulesFunctions.parseURL(params.endpoint())) != null) {
                locals = locals.toBuilder().url(url).build();
                if (!locals.url().isIp() && "aws-global".equals(locals.region())) {
                    return RuleResult.endpoint(Endpoint
                            .builder()
                            .url(URI.create(locals.url().scheme() + "://" + params.bucket() + "." + locals.url().authority()
                                    + locals.url().path()))
                            .putAttribute(
                                    AwsEndpointAttribute.AUTH_SCHEMES,
                                    Arrays.asList(SigV4AuthScheme.builder().disableDoubleEncoding(true).signingName("s3")
                                            .signingRegion("us-east-1").build())).build());
                }
            }
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule161(S3EndpointParams params, LocalState locals) {
        if (!params.useDualStack() && !params.useFips() && !params.accelerate() && params.endpoint() != null) {
            RuleUrl url = null;
            if ((url = RulesFunctions.parseURL(params.endpoint())) != null) {
                locals = locals.toBuilder().url(url).build();
                if (locals.url().isIp() && !("aws-global".equals(locals.region())) && params.useGlobalEndpoint()) {
                    RuleResult result = endpointRule162(params, locals);
                    if (result.isResolved()) {
                        return result;
                    }
                    return endpointRule163(params, locals);
                }
            }
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule162(S3EndpointParams params, LocalState locals) {
        if ("us-east-1".equals(locals.region())) {
            return RuleResult.endpoint(Endpoint
                    .builder()
                    .url(URI.create(locals.url().scheme() + "://" + locals.url().authority() + locals.url().normalizedPath()
                            + params.bucket()))
                    .putAttribute(
                            AwsEndpointAttribute.AUTH_SCHEMES,
                            Arrays.asList(SigV4AuthScheme.builder().disableDoubleEncoding(true).signingName("s3")
                                    .signingRegion(locals.region()).build())).build());
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule163(S3EndpointParams params, LocalState locals) {
        return RuleResult.endpoint(Endpoint
                .builder()
                .url(URI.create(locals.url().scheme() + "://" + locals.url().authority() + locals.url().normalizedPath()
                        + params.bucket()))
                .putAttribute(
                        AwsEndpointAttribute.AUTH_SCHEMES,
                        Arrays.asList(SigV4AuthScheme.builder().disableDoubleEncoding(true).signingName("s3")
                                .signingRegion(locals.region()).build())).build());
    }

    private static RuleResult endpointRule164(S3EndpointParams params, LocalState locals) {
        if (!params.useDualStack() && !params.useFips() && !params.accelerate() && params.endpoint() != null) {
            RuleUrl url = null;
            if ((url = RulesFunctions.parseURL(params.endpoint())) != null) {
                locals = locals.toBuilder().url(url).build();
                if (!locals.url().isIp() && !("aws-global".equals(locals.region())) && params.useGlobalEndpoint()) {
                    RuleResult result = endpointRule165(params, locals);
                    if (result.isResolved()) {
                        return result;
                    }
                    return endpointRule166(params, locals);
                }
            }
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule165(S3EndpointParams params, LocalState locals) {
        if ("us-east-1".equals(locals.region())) {
            return RuleResult.endpoint(Endpoint
                    .builder()
                    .url(URI.create(locals.url().scheme() + "://" + params.bucket() + "." + locals.url().authority()
                            + locals.url().path()))
                    .putAttribute(
                            AwsEndpointAttribute.AUTH_SCHEMES,
                            Arrays.asList(SigV4AuthScheme.builder().disableDoubleEncoding(true).signingName("s3")
                                    .signingRegion(locals.region()).build())).build());
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule166(S3EndpointParams params, LocalState locals) {
        return RuleResult.endpoint(Endpoint
                .builder()
                .url(URI.create(locals.url().scheme() + "://" + params.bucket() + "." + locals.url().authority()
                        + locals.url().path()))
                .putAttribute(
                        AwsEndpointAttribute.AUTH_SCHEMES,
                        Arrays.asList(SigV4AuthScheme.builder().disableDoubleEncoding(true).signingName("s3")
                                .signingRegion(locals.region()).build())).build());
    }

    private static RuleResult endpointRule167(S3EndpointParams params, LocalState locals) {
        if (!params.useDualStack() && !params.useFips() && !params.accelerate() && params.endpoint() != null) {
            RuleUrl url = null;
            if ((url = RulesFunctions.parseURL(params.endpoint())) != null) {
                locals = locals.toBuilder().url(url).build();
                if (locals.url().isIp() && !("aws-global".equals(locals.region())) && !params.useGlobalEndpoint()) {
                    return RuleResult.endpoint(Endpoint
                            .builder()
                            .url(URI.create(locals.url().scheme() + "://" + locals.url().authority()
                                    + locals.url().normalizedPath() + params.bucket()))
                            .putAttribute(
                                    AwsEndpointAttribute.AUTH_SCHEMES,
                                    Arrays.asList(SigV4AuthScheme.builder().disableDoubleEncoding(true).signingName("s3")
                                            .signingRegion(locals.region()).build())).build());
                }
            }
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule168(S3EndpointParams params, LocalState locals) {
        if (!params.useDualStack() && !params.useFips() && !params.accelerate() && params.endpoint() != null) {
            RuleUrl url = null;
            if ((url = RulesFunctions.parseURL(params.endpoint())) != null) {
                locals = locals.toBuilder().url(url).build();
                if (!locals.url().isIp() && !("aws-global".equals(locals.region())) && !params.useGlobalEndpoint()) {
                    return RuleResult.endpoint(Endpoint
                            .builder()
                            .url(URI.create(locals.url().scheme() + "://" + params.bucket() + "." + locals.url().authority()
                                    + locals.url().path()))
                            .putAttribute(
                                    AwsEndpointAttribute.AUTH_SCHEMES,
                                    Arrays.asList(SigV4AuthScheme.builder().disableDoubleEncoding(true).signingName("s3")
                                            .signingRegion(locals.region()).build())).build());
                }
            }
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule169(S3EndpointParams params, LocalState locals) {
        if (!params.useDualStack() && !params.useFips() && params.accelerate() && params.endpoint() == null
                && "aws-global".equals(locals.region())) {
            return RuleResult.endpoint(Endpoint
                    .builder()
                    .url(URI.create("https://" + params.bucket() + ".s3-accelerate." + locals.partitionResult().dnsSuffix()))
                    .putAttribute(
                            AwsEndpointAttribute.AUTH_SCHEMES,
                            Arrays.asList(SigV4AuthScheme.builder().disableDoubleEncoding(true).signingName("s3")
                                    .signingRegion("us-east-1").build())).build());
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule170(S3EndpointParams params, LocalState locals) {
        if (!params.useDualStack() && !params.useFips() && params.accelerate() && params.endpoint() == null
                && !("aws-global".equals(locals.region())) && params.useGlobalEndpoint()) {
            RuleResult result = endpointRule171(params, locals);
            if (result.isResolved()) {
                return result;
            }
            return endpointRule172(params, locals);
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule171(S3EndpointParams params, LocalState locals) {
        if ("us-east-1".equals(locals.region())) {
            return RuleResult.endpoint(Endpoint
                    .builder()
                    .url(URI.create("https://" + params.bucket() + ".s3-accelerate." + locals.partitionResult().dnsSuffix()))
                    .putAttribute(
                            AwsEndpointAttribute.AUTH_SCHEMES,
                            Arrays.asList(SigV4AuthScheme.builder().disableDoubleEncoding(true).signingName("s3")
                                    .signingRegion(locals.region()).build())).build());
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule172(S3EndpointParams params, LocalState locals) {
        return RuleResult.endpoint(Endpoint
                .builder()
                .url(URI.create("https://" + params.bucket() + ".s3-accelerate." + locals.partitionResult().dnsSuffix()))
                .putAttribute(
                        AwsEndpointAttribute.AUTH_SCHEMES,
                        Arrays.asList(SigV4AuthScheme.builder().disableDoubleEncoding(true).signingName("s3")
                                .signingRegion(locals.region()).build())).build());
    }

    private static RuleResult endpointRule173(S3EndpointParams params, LocalState locals) {
        if (!params.useDualStack() && !params.useFips() && params.accelerate() && params.endpoint() == null
                && !("aws-global".equals(locals.region())) && !params.useGlobalEndpoint()) {
            return RuleResult.endpoint(Endpoint
                    .builder()
                    .url(URI.create("https://" + params.bucket() + ".s3-accelerate." + locals.partitionResult().dnsSuffix()))
                    .putAttribute(
                            AwsEndpointAttribute.AUTH_SCHEMES,
                            Arrays.asList(SigV4AuthScheme.builder().disableDoubleEncoding(true).signingName("s3")
                                    .signingRegion(locals.region()).build())).build());
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule174(S3EndpointParams params, LocalState locals) {
        if (!params.useDualStack() && !params.useFips() && !params.accelerate() && params.endpoint() == null
                && "aws-global".equals(locals.region())) {
            return RuleResult.endpoint(Endpoint
                    .builder()
                    .url(URI.create("https://" + params.bucket() + ".s3." + locals.partitionResult().dnsSuffix()))
                    .putAttribute(
                            AwsEndpointAttribute.AUTH_SCHEMES,
                            Arrays.asList(SigV4AuthScheme.builder().disableDoubleEncoding(true).signingName("s3")
                                    .signingRegion("us-east-1").build())).build());
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule175(S3EndpointParams params, LocalState locals) {
        if (!params.useDualStack() && !params.useFips() && !params.accelerate() && params.endpoint() == null
                && !("aws-global".equals(locals.region())) && params.useGlobalEndpoint()) {
            RuleResult result = endpointRule176(params, locals);
            if (result.isResolved()) {
                return result;
            }
            return endpointRule177(params, locals);
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule176(S3EndpointParams params, LocalState locals) {
        if ("us-east-1".equals(locals.region())) {
            return RuleResult.endpoint(Endpoint
                    .builder()
                    .url(URI.create("https://" + params.bucket() + ".s3." + locals.partitionResult().dnsSuffix()))
                    .putAttribute(
                            AwsEndpointAttribute.AUTH_SCHEMES,
                            Arrays.asList(SigV4AuthScheme.builder().disableDoubleEncoding(true).signingName("s3")
                                    .signingRegion(locals.region()).build())).build());
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule177(S3EndpointParams params, LocalState locals) {
        return RuleResult.endpoint(Endpoint
                .builder()
                .url(URI.create("https://" + params.bucket() + ".s3." + locals.region() + "."
                        + locals.partitionResult().dnsSuffix()))
                .putAttribute(
                        AwsEndpointAttribute.AUTH_SCHEMES,
                        Arrays.asList(SigV4AuthScheme.builder().disableDoubleEncoding(true).signingName("s3")
                                .signingRegion(locals.region()).build())).build());
    }

    private static RuleResult endpointRule178(S3EndpointParams params, LocalState locals) {
        if (!params.useDualStack() && !params.useFips() && !params.accelerate() && params.endpoint() == null
                && !("aws-global".equals(locals.region())) && !params.useGlobalEndpoint()) {
            return RuleResult.endpoint(Endpoint
                    .builder()
                    .url(URI.create("https://" + params.bucket() + ".s3." + locals.region() + "."
                            + locals.partitionResult().dnsSuffix()))
                    .putAttribute(
                            AwsEndpointAttribute.AUTH_SCHEMES,
                            Arrays.asList(SigV4AuthScheme.builder().disableDoubleEncoding(true).signingName("s3")
                                    .signingRegion(locals.region()).build())).build());
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule179(S3EndpointParams params, LocalState locals) {
        return RuleResult.error("Invalid region: region was not a valid DNS name.");
    }

    private static RuleResult endpointRule180(S3EndpointParams params, LocalState locals) {
        if (params.endpoint() != null) {
            RuleUrl url = null;
            if ((url = RulesFunctions.parseURL(params.endpoint())) != null) {
                locals = locals.toBuilder().url(url).build();
                if ("http".equals(locals.url().scheme()) && RulesFunctions.awsIsVirtualHostableS3Bucket(params.bucket(), true)
                        && !params.forcePathStyle() && !params.useFips() && !params.useDualStack() && !params.accelerate()) {
                    return endpointRule181(params, locals);
                }
            }
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule181(S3EndpointParams params, LocalState locals) {
        RulePartition partitionResult = null;
        if ((partitionResult = RulesFunctions.awsPartition(locals.region())) != null) {
            locals = locals.toBuilder().partitionResult(partitionResult).build();
            RuleResult result = endpointRule182(params, locals);
            if (result.isResolved()) {
                return result;
            }
            return endpointRule184(params, locals);
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule182(S3EndpointParams params, LocalState locals) {
        if (RulesFunctions.isValidHostLabel(locals.region(), false)) {
            return endpointRule183(params, locals);
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule183(S3EndpointParams params, LocalState locals) {
        return RuleResult.endpoint(Endpoint
                .builder()
                .url(URI.create(locals.url().scheme() + "://" + params.bucket() + "." + locals.url().authority()
                        + locals.url().path()))
                .putAttribute(
                        AwsEndpointAttribute.AUTH_SCHEMES,
                        Arrays.asList(SigV4AuthScheme.builder().disableDoubleEncoding(true).signingName("s3")
                                .signingRegion(locals.region()).build())).build());
    }

    private static RuleResult endpointRule184(S3EndpointParams params, LocalState locals) {
        return RuleResult.error("Invalid region: region was not a valid DNS name.");
    }

    private static RuleResult endpointRule185(S3EndpointParams params, LocalState locals) {
        if (!params.forcePathStyle()) {
            RuleArn bucketArn = null;
            if ((bucketArn = RulesFunctions.awsParseArn(params.bucket())) != null) {
                locals = locals.toBuilder().bucketArn(bucketArn).build();
                RuleResult result = endpointRule186(params, locals);
                if (result.isResolved()) {
                    return result;
                }
                return endpointRule279(params, locals);
            }
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule186(S3EndpointParams params, LocalState locals) {
        String arnType = null;
        if ((arnType = RulesFunctions.listAccess(locals.bucketArn().resourceId(), 0)) != null) {
            locals = locals.toBuilder().arnType(arnType).build();
            if (!("".equals(locals.arnType()))) {
                RuleResult result = endpointRule187(params, locals);
                if (result.isResolved()) {
                    return result;
                }
                result = endpointRule214(params, locals);
                if (result.isResolved()) {
                    return result;
                }
                result = endpointRule252(params, locals);
                if (result.isResolved()) {
                    return result;
                }
                return endpointRule278(params, locals);
            }
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule187(S3EndpointParams params, LocalState locals) {
        if ("s3-object-lambda".equals(locals.bucketArn().service())) {
            RuleResult result = endpointRule188(params, locals);
            if (result.isResolved()) {
                return result;
            }
            return endpointRule213(params, locals);
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule188(S3EndpointParams params, LocalState locals) {
        if ("accesspoint".equals(locals.arnType())) {
            RuleResult result = endpointRule189(params, locals);
            if (result.isResolved()) {
                return result;
            }
            return endpointRule212(params, locals);
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule189(S3EndpointParams params, LocalState locals) {
        String accessPointName = null;
        if ((accessPointName = RulesFunctions.listAccess(locals.bucketArn().resourceId(), 1)) != null) {
            locals = locals.toBuilder().accessPointName(accessPointName).build();
            if (!("".equals(locals.accessPointName()))) {
                RuleResult result = endpointRule190(params, locals);
                if (result.isResolved()) {
                    return result;
                }
                result = endpointRule191(params, locals);
                if (result.isResolved()) {
                    return result;
                }
                result = endpointRule192(params, locals);
                if (result.isResolved()) {
                    return result;
                }
                return endpointRule211(params, locals);
            }
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule190(S3EndpointParams params, LocalState locals) {
        if (params.useDualStack()) {
            return RuleResult.error("S3 Object Lambda does not support Dual-stack");
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule191(S3EndpointParams params, LocalState locals) {
        if (params.accelerate()) {
            return RuleResult.error("S3 Object Lambda does not support S3 Accelerate");
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule192(S3EndpointParams params, LocalState locals) {
        if (!("".equals(locals.bucketArn().region()))) {
            RuleResult result = endpointRule193(params, locals);
            if (result.isResolved()) {
                return result;
            }
            result = endpointRule194(params, locals);
            if (result.isResolved()) {
                return result;
            }
            return endpointRule210(params, locals);
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule193(S3EndpointParams params, LocalState locals) {
        if (params.disableAccessPoints() != null && params.disableAccessPoints()) {
            return RuleResult.error("Access points are not supported for this operation");
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule194(S3EndpointParams params, LocalState locals) {
        if (RulesFunctions.listAccess(locals.bucketArn().resourceId(), 2) == null) {
            RuleResult result = endpointRule195(params, locals);
            if (result.isResolved()) {
                return result;
            }
            return endpointRule196(params, locals);
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule195(S3EndpointParams params, LocalState locals) {
        if (params.useArnRegion() != null && !params.useArnRegion()
                && !(RulesFunctions.stringEquals(locals.bucketArn().region(), locals.region()))) {
            return RuleResult.error("Invalid configuration: region from ARN `" + locals.bucketArn().region()
                    + "` does not match client region `" + locals.region() + "` and UseArnRegion is `false`");
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule196(S3EndpointParams params, LocalState locals) {
        RulePartition bucketPartition = null;
        if ((bucketPartition = RulesFunctions.awsPartition(locals.bucketArn().region())) != null) {
            locals = locals.toBuilder().bucketPartition(bucketPartition).build();
            return endpointRule197(params, locals);
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule197(S3EndpointParams params, LocalState locals) {
        RulePartition partitionResult = null;
        if ((partitionResult = RulesFunctions.awsPartition(locals.region())) != null) {
            locals = locals.toBuilder().partitionResult(partitionResult).build();
            RuleResult result = endpointRule198(params, locals);
            if (result.isResolved()) {
                return result;
            }
            return endpointRule209(params, locals);
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule198(S3EndpointParams params, LocalState locals) {
        if (RulesFunctions.stringEquals(locals.bucketPartition().name(), locals.partitionResult().name())) {
            RuleResult result = endpointRule199(params, locals);
            if (result.isResolved()) {
                return result;
            }
            return endpointRule208(params, locals);
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule199(S3EndpointParams params, LocalState locals) {
        if (RulesFunctions.isValidHostLabel(locals.bucketArn().region(), true)) {
            RuleResult result = endpointRule200(params, locals);
            if (result.isResolved()) {
                return result;
            }
            result = endpointRule201(params, locals);
            if (result.isResolved()) {
                return result;
            }
            return endpointRule207(params, locals);
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule200(S3EndpointParams params, LocalState locals) {
        if ("".equals(locals.bucketArn().accountId())) {
            return RuleResult.error("Invalid ARN: Missing account id");
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule201(S3EndpointParams params, LocalState locals) {
        if (RulesFunctions.isValidHostLabel(locals.bucketArn().accountId(), false)) {
            RuleResult result = endpointRule202(params, locals);
            if (result.isResolved()) {
                return result;
            }
            return endpointRule206(params, locals);
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule202(S3EndpointParams params, LocalState locals) {
        if (RulesFunctions.isValidHostLabel(locals.accessPointName(), false)) {
            RuleResult result = endpointRule203(params, locals);
            if (result.isResolved()) {
                return result;
            }
            result = endpointRule204(params, locals);
            if (result.isResolved()) {
                return result;
            }
            return endpointRule205(params, locals);
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule203(S3EndpointParams params, LocalState locals) {
        if (params.endpoint() != null) {
            RuleUrl url = null;
            if ((url = RulesFunctions.parseURL(params.endpoint())) != null) {
                locals = locals.toBuilder().url(url).build();
                return RuleResult.endpoint(Endpoint
                        .builder()
                        .url(URI.create(locals.url().scheme() + "://" + locals.accessPointName() + "-"
                                + locals.bucketArn().accountId() + "." + locals.url().authority() + locals.url().path()))
                        .putAttribute(
                                AwsEndpointAttribute.AUTH_SCHEMES,
                                Arrays.asList(SigV4AuthScheme.builder().disableDoubleEncoding(true)
                                        .signingName("s3-object-lambda").signingRegion(locals.bucketArn().region()).build()))
                        .build());
            }
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule204(S3EndpointParams params, LocalState locals) {
        if (params.useFips()) {
            return RuleResult.endpoint(Endpoint
                    .builder()
                    .url(URI.create("https://" + locals.accessPointName() + "-" + locals.bucketArn().accountId()
                            + ".s3-object-lambda-fips." + locals.bucketArn().region() + "."
                            + locals.bucketPartition().dnsSuffix()))
                    .putAttribute(
                            AwsEndpointAttribute.AUTH_SCHEMES,
                            Arrays.asList(SigV4AuthScheme.builder().disableDoubleEncoding(true).signingName("s3-object-lambda")
                                    .signingRegion(locals.bucketArn().region()).build())).build());
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule205(S3EndpointParams params, LocalState locals) {
        return RuleResult.endpoint(Endpoint
                .builder()
                .url(URI.create("https://" + locals.accessPointName() + "-" + locals.bucketArn().accountId()
                        + ".s3-object-lambda." + locals.bucketArn().region() + "." + locals.bucketPartition().dnsSuffix()))
                .putAttribute(
                        AwsEndpointAttribute.AUTH_SCHEMES,
                        Arrays.asList(SigV4AuthScheme.builder().disableDoubleEncoding(true).signingName("s3-object-lambda")
                                .signingRegion(locals.bucketArn().region()).build())).build());
    }

    private static RuleResult endpointRule206(S3EndpointParams params, LocalState locals) {
        return RuleResult.error("Invalid ARN: The access point name may only contain a-z, A-Z, 0-9 and `-`. Found: `"
                + locals.accessPointName() + "`");
    }

    private static RuleResult endpointRule207(S3EndpointParams params, LocalState locals) {
        return RuleResult.error("Invalid ARN: The account id may only contain a-z, A-Z, 0-9 and `-`. Found: `"
                + locals.bucketArn().accountId() + "`");
    }

    private static RuleResult endpointRule208(S3EndpointParams params, LocalState locals) {
        return RuleResult.error("Invalid region in ARN: `" + locals.bucketArn().region() + "` (invalid DNS name)");
    }

    private static RuleResult endpointRule209(S3EndpointParams params, LocalState locals) {
        return RuleResult.error("Client was configured for partition `" + locals.partitionResult().name() + "` but ARN (`"
                + params.bucket() + "`) has `" + locals.bucketPartition().name() + "`");
    }

    private static RuleResult endpointRule210(S3EndpointParams params, LocalState locals) {
        return RuleResult.error("Invalid ARN: The ARN may only contain a single resource component after `accesspoint`.");
    }

    private static RuleResult endpointRule211(S3EndpointParams params, LocalState locals) {
        return RuleResult.error("Invalid ARN: bucket ARN is missing a region");
    }

    private static RuleResult endpointRule212(S3EndpointParams params, LocalState locals) {
        return RuleResult
                .error("Invalid ARN: Expected a resource of the format `accesspoint:<accesspoint name>` but no name was provided");
    }

    private static RuleResult endpointRule213(S3EndpointParams params, LocalState locals) {
        return RuleResult.error("Invalid ARN: Object Lambda ARNs only support `accesspoint` arn types, but found: `"
                + locals.arnType() + "`");
    }

    private static RuleResult endpointRule214(S3EndpointParams params, LocalState locals) {
        if ("accesspoint".equals(locals.arnType())) {
            RuleResult result = endpointRule215(params, locals);
            if (result.isResolved()) {
                return result;
            }
            return endpointRule251(params, locals);
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule215(S3EndpointParams params, LocalState locals) {
        String accessPointName = null;
        if ((accessPointName = RulesFunctions.listAccess(locals.bucketArn().resourceId(), 1)) != null) {
            locals = locals.toBuilder().accessPointName(accessPointName).build();
            if (!("".equals(locals.accessPointName()))) {
                RuleResult result = endpointRule216(params, locals);
                if (result.isResolved()) {
                    return result;
                }
                result = endpointRule241(params, locals);
                if (result.isResolved()) {
                    return result;
                }
                return endpointRule250(params, locals);
            }
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule216(S3EndpointParams params, LocalState locals) {
        if (!("".equals(locals.bucketArn().region()))) {
            return endpointRule217(params, locals);
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule217(S3EndpointParams params, LocalState locals) {
        if ("accesspoint".equals(locals.arnType())) {
            return endpointRule218(params, locals);
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule218(S3EndpointParams params, LocalState locals) {
        if (!("".equals(locals.bucketArn().region()))) {
            RuleResult result = endpointRule219(params, locals);
            if (result.isResolved()) {
                return result;
            }
            result = endpointRule220(params, locals);
            if (result.isResolved()) {
                return result;
            }
            return endpointRule240(params, locals);
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule219(S3EndpointParams params, LocalState locals) {
        if (params.disableAccessPoints() != null && params.disableAccessPoints()) {
            return RuleResult.error("Access points are not supported for this operation");
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule220(S3EndpointParams params, LocalState locals) {
        if (RulesFunctions.listAccess(locals.bucketArn().resourceId(), 2) == null) {
            RuleResult result = endpointRule221(params, locals);
            if (result.isResolved()) {
                return result;
            }
            return endpointRule222(params, locals);
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule221(S3EndpointParams params, LocalState locals) {
        if (params.useArnRegion() != null && !params.useArnRegion()
                && !(RulesFunctions.stringEquals(locals.bucketArn().region(), locals.region()))) {
            return RuleResult.error("Invalid configuration: region from ARN `" + locals.bucketArn().region()
                    + "` does not match client region `" + locals.region() + "` and UseArnRegion is `false`");
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule222(S3EndpointParams params, LocalState locals) {
        RulePartition bucketPartition = null;
        if ((bucketPartition = RulesFunctions.awsPartition(locals.bucketArn().region())) != null) {
            locals = locals.toBuilder().bucketPartition(bucketPartition).build();
            return endpointRule223(params, locals);
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule223(S3EndpointParams params, LocalState locals) {
        RulePartition partitionResult = null;
        if ((partitionResult = RulesFunctions.awsPartition(locals.region())) != null) {
            locals = locals.toBuilder().partitionResult(partitionResult).build();
            RuleResult result = endpointRule224(params, locals);
            if (result.isResolved()) {
                return result;
            }
            return endpointRule239(params, locals);
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule224(S3EndpointParams params, LocalState locals) {
        if (RulesFunctions.stringEquals(locals.bucketPartition().name(), locals.partitionResult().name())) {
            RuleResult result = endpointRule225(params, locals);
            if (result.isResolved()) {
                return result;
            }
            return endpointRule238(params, locals);
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule225(S3EndpointParams params, LocalState locals) {
        if (RulesFunctions.isValidHostLabel(locals.bucketArn().region(), true)) {
            RuleResult result = endpointRule226(params, locals);
            if (result.isResolved()) {
                return result;
            }
            return endpointRule237(params, locals);
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule226(S3EndpointParams params, LocalState locals) {
        if ("s3".equals(locals.bucketArn().service())) {
            RuleResult result = endpointRule227(params, locals);
            if (result.isResolved()) {
                return result;
            }
            return endpointRule236(params, locals);
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule227(S3EndpointParams params, LocalState locals) {
        if (RulesFunctions.isValidHostLabel(locals.bucketArn().accountId(), false)) {
            RuleResult result = endpointRule228(params, locals);
            if (result.isResolved()) {
                return result;
            }
            return endpointRule235(params, locals);
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule228(S3EndpointParams params, LocalState locals) {
        if (RulesFunctions.isValidHostLabel(locals.accessPointName(), false)) {
            RuleResult result = endpointRule229(params, locals);
            if (result.isResolved()) {
                return result;
            }
            result = endpointRule230(params, locals);
            if (result.isResolved()) {
                return result;
            }
            result = endpointRule231(params, locals);
            if (result.isResolved()) {
                return result;
            }
            result = endpointRule232(params, locals);
            if (result.isResolved()) {
                return result;
            }
            result = endpointRule233(params, locals);
            if (result.isResolved()) {
                return result;
            }
            return endpointRule234(params, locals);
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule229(S3EndpointParams params, LocalState locals) {
        if (params.accelerate()) {
            return RuleResult.error("Access Points do not support S3 Accelerate");
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule230(S3EndpointParams params, LocalState locals) {
        if (params.useFips() && params.useDualStack()) {
            return RuleResult.endpoint(Endpoint
                    .builder()
                    .url(URI.create("https://" + locals.accessPointName() + "-" + locals.bucketArn().accountId()
                            + ".s3-accesspoint-fips.dualstack." + locals.bucketArn().region() + "."
                            + locals.bucketPartition().dnsSuffix()))
                    .putAttribute(
                            AwsEndpointAttribute.AUTH_SCHEMES,
                            Arrays.asList(SigV4AuthScheme.builder().disableDoubleEncoding(true).signingName("s3")
                                    .signingRegion(locals.bucketArn().region()).build())).build());
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule231(S3EndpointParams params, LocalState locals) {
        if (params.useFips() && !params.useDualStack()) {
            return RuleResult
                    .endpoint(Endpoint
                            .builder()
                            .url(URI.create("https://" + locals.accessPointName() + "-" + locals.bucketArn().accountId()
                                    + ".s3-accesspoint-fips." + locals.bucketArn().region() + "."
                                    + locals.bucketPartition().dnsSuffix()))
                            .putAttribute(
                                    AwsEndpointAttribute.AUTH_SCHEMES,
                                    Arrays.asList(SigV4AuthScheme.builder().disableDoubleEncoding(true).signingName("s3")
                                            .signingRegion(locals.bucketArn().region()).build())).build());
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule232(S3EndpointParams params, LocalState locals) {
        if (!params.useFips() && params.useDualStack()) {
            return RuleResult.endpoint(Endpoint
                    .builder()
                    .url(URI.create("https://" + locals.accessPointName() + "-" + locals.bucketArn().accountId()
                            + ".s3-accesspoint.dualstack." + locals.bucketArn().region() + "."
                            + locals.bucketPartition().dnsSuffix()))
                    .putAttribute(
                            AwsEndpointAttribute.AUTH_SCHEMES,
                            Arrays.asList(SigV4AuthScheme.builder().disableDoubleEncoding(true).signingName("s3")
                                    .signingRegion(locals.bucketArn().region()).build())).build());
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule233(S3EndpointParams params, LocalState locals) {
        if (!params.useFips() && !params.useDualStack() && params.endpoint() != null) {
            RuleUrl url = null;
            if ((url = RulesFunctions.parseURL(params.endpoint())) != null) {
                locals = locals.toBuilder().url(url).build();
                return RuleResult.endpoint(Endpoint
                        .builder()
                        .url(URI.create(locals.url().scheme() + "://" + locals.accessPointName() + "-"
                                + locals.bucketArn().accountId() + "." + locals.url().authority() + locals.url().path()))
                        .putAttribute(
                                AwsEndpointAttribute.AUTH_SCHEMES,
                                Arrays.asList(SigV4AuthScheme.builder().disableDoubleEncoding(true).signingName("s3")
                                        .signingRegion(locals.bucketArn().region()).build())).build());
            }
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule234(S3EndpointParams params, LocalState locals) {
        if (!params.useFips() && !params.useDualStack()) {
            return RuleResult.endpoint(Endpoint
                    .builder()
                    .url(URI.create("https://" + locals.accessPointName() + "-" + locals.bucketArn().accountId()
                            + ".s3-accesspoint." + locals.bucketArn().region() + "." + locals.bucketPartition().dnsSuffix()))
                    .putAttribute(
                            AwsEndpointAttribute.AUTH_SCHEMES,
                            Arrays.asList(SigV4AuthScheme.builder().disableDoubleEncoding(true).signingName("s3")
                                    .signingRegion(locals.bucketArn().region()).build())).build());
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule235(S3EndpointParams params, LocalState locals) {
        return RuleResult.error("Invalid ARN: The access point name may only contain a-z, A-Z, 0-9 and `-`. Found: `"
                + locals.accessPointName() + "`");
    }

    private static RuleResult endpointRule236(S3EndpointParams params, LocalState locals) {
        return RuleResult.error("Invalid ARN: The account id may only contain a-z, A-Z, 0-9 and `-`. Found: `"
                + locals.bucketArn().accountId() + "`");
    }

    private static RuleResult endpointRule237(S3EndpointParams params, LocalState locals) {
        return RuleResult.error("Invalid ARN: The ARN was not for the S3 service, found: " + locals.bucketArn().service());
    }

    private static RuleResult endpointRule238(S3EndpointParams params, LocalState locals) {
        return RuleResult.error("Invalid region in ARN: `" + locals.bucketArn().region() + "` (invalid DNS name)");
    }

    private static RuleResult endpointRule239(S3EndpointParams params, LocalState locals) {
        return RuleResult.error("Client was configured for partition `" + locals.partitionResult().name() + "` but ARN (`"
                + params.bucket() + "`) has `" + locals.bucketPartition().name() + "`");
    }

    private static RuleResult endpointRule240(S3EndpointParams params, LocalState locals) {
        return RuleResult.error("Invalid ARN: The ARN may only contain a single resource component after `accesspoint`.");
    }

    private static RuleResult endpointRule241(S3EndpointParams params, LocalState locals) {
        if (RulesFunctions.isValidHostLabel(locals.accessPointName(), true)) {
            RuleResult result = endpointRule242(params, locals);
            if (result.isResolved()) {
                return result;
            }
            result = endpointRule243(params, locals);
            if (result.isResolved()) {
                return result;
            }
            result = endpointRule244(params, locals);
            if (result.isResolved()) {
                return result;
            }
            result = endpointRule245(params, locals);
            if (result.isResolved()) {
                return result;
            }
            return endpointRule246(params, locals);
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule242(S3EndpointParams params, LocalState locals) {
        if (params.useDualStack()) {
            return RuleResult.error("S3 MRAP does not support dual-stack");
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule243(S3EndpointParams params, LocalState locals) {
        if (params.useFips()) {
            return RuleResult.error("S3 MRAP does not support FIPS");
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule244(S3EndpointParams params, LocalState locals) {
        if (params.accelerate()) {
            return RuleResult.error("S3 MRAP does not support S3 Accelerate");
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule245(S3EndpointParams params, LocalState locals) {
        if (params.disableMultiRegionAccessPoints()) {
            return RuleResult.error("Invalid configuration: Multi-Region Access Point ARNs are disabled.");
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule246(S3EndpointParams params, LocalState locals) {
        RulePartition mrapPartition = null;
        if ((mrapPartition = RulesFunctions.awsPartition(locals.region())) != null) {
            locals = locals.toBuilder().mrapPartition(mrapPartition).build();
            RuleResult result = endpointRule247(params, locals);
            if (result.isResolved()) {
                return result;
            }
            return endpointRule249(params, locals);
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule247(S3EndpointParams params, LocalState locals) {
        if (RulesFunctions.stringEquals(locals.mrapPartition().name(), locals.bucketArn().partition())) {
            return endpointRule248(params, locals);
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule248(S3EndpointParams params, LocalState locals) {
        return RuleResult.endpoint(Endpoint
                .builder()
                .url(URI.create("https://" + locals.accessPointName() + ".accesspoint.s3-global."
                        + locals.mrapPartition().dnsSuffix()))
                .putAttribute(
                        AwsEndpointAttribute.AUTH_SCHEMES,
                        Arrays.asList(SigV4aAuthScheme.builder().disableDoubleEncoding(true).signingName("s3")
                                .signingRegionSet(Arrays.asList("*")).build())).build());
    }

    private static RuleResult endpointRule249(S3EndpointParams params, LocalState locals) {
        return RuleResult.error("Client was configured for partition `" + locals.mrapPartition().name()
                + "` but bucket referred to partition `" + locals.bucketArn().partition() + "`");
    }

    private static RuleResult endpointRule250(S3EndpointParams params, LocalState locals) {
        return RuleResult.error("Invalid Access Point Name");
    }

    private static RuleResult endpointRule251(S3EndpointParams params, LocalState locals) {
        return RuleResult
                .error("Invalid ARN: Expected a resource of the format `accesspoint:<accesspoint name>` but no name was provided");
    }

    private static RuleResult endpointRule252(S3EndpointParams params, LocalState locals) {
        if ("s3-outposts".equals(locals.bucketArn().service())) {
            RuleResult result = endpointRule253(params, locals);
            if (result.isResolved()) {
                return result;
            }
            result = endpointRule254(params, locals);
            if (result.isResolved()) {
                return result;
            }
            result = endpointRule255(params, locals);
            if (result.isResolved()) {
                return result;
            }
            result = endpointRule256(params, locals);
            if (result.isResolved()) {
                return result;
            }
            result = endpointRule257(params, locals);
            if (result.isResolved()) {
                return result;
            }
            return endpointRule277(params, locals);
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule253(S3EndpointParams params, LocalState locals) {
        if (params.useDualStack()) {
            return RuleResult.error("S3 Outposts does not support Dual-stack");
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule254(S3EndpointParams params, LocalState locals) {
        if (params.useFips()) {
            return RuleResult.error("S3 Outposts does not support FIPS");
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule255(S3EndpointParams params, LocalState locals) {
        if (params.accelerate()) {
            return RuleResult.error("S3 Outposts does not support S3 Accelerate");
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule256(S3EndpointParams params, LocalState locals) {
        if (RulesFunctions.listAccess(locals.bucketArn().resourceId(), 4) != null) {
            return RuleResult.error("Invalid Arn: Outpost Access Point ARN contains sub resources");
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule257(S3EndpointParams params, LocalState locals) {
        String outpostId = null;
        if ((outpostId = RulesFunctions.listAccess(locals.bucketArn().resourceId(), 1)) != null) {
            locals = locals.toBuilder().outpostId(outpostId).build();
            RuleResult result = endpointRule258(params, locals);
            if (result.isResolved()) {
                return result;
            }
            return endpointRule276(params, locals);
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule258(S3EndpointParams params, LocalState locals) {
        if (RulesFunctions.isValidHostLabel(locals.outpostId(), false)) {
            RuleResult result = endpointRule259(params, locals);
            if (result.isResolved()) {
                return result;
            }
            return endpointRule260(params, locals);
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule259(S3EndpointParams params, LocalState locals) {
        if (params.useArnRegion() != null && !params.useArnRegion()
                && !(RulesFunctions.stringEquals(locals.bucketArn().region(), locals.region()))) {
            return RuleResult.error("Invalid configuration: region from ARN `" + locals.bucketArn().region()
                    + "` does not match client region `" + locals.region() + "` and UseArnRegion is `false`");
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule260(S3EndpointParams params, LocalState locals) {
        RulePartition bucketPartition = null;
        if ((bucketPartition = RulesFunctions.awsPartition(locals.bucketArn().region())) != null) {
            locals = locals.toBuilder().bucketPartition(bucketPartition).build();
            return endpointRule261(params, locals);
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule261(S3EndpointParams params, LocalState locals) {
        RulePartition partitionResult = null;
        if ((partitionResult = RulesFunctions.awsPartition(locals.region())) != null) {
            locals = locals.toBuilder().partitionResult(partitionResult).build();
            RuleResult result = endpointRule262(params, locals);
            if (result.isResolved()) {
                return result;
            }
            return endpointRule275(params, locals);
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule262(S3EndpointParams params, LocalState locals) {
        if (RulesFunctions.stringEquals(locals.bucketPartition().name(), locals.partitionResult().name())) {
            RuleResult result = endpointRule263(params, locals);
            if (result.isResolved()) {
                return result;
            }
            return endpointRule274(params, locals);
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule263(S3EndpointParams params, LocalState locals) {
        if (RulesFunctions.isValidHostLabel(locals.bucketArn().region(), true)) {
            RuleResult result = endpointRule264(params, locals);
            if (result.isResolved()) {
                return result;
            }
            return endpointRule273(params, locals);
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule264(S3EndpointParams params, LocalState locals) {
        if (RulesFunctions.isValidHostLabel(locals.bucketArn().accountId(), false)) {
            RuleResult result = endpointRule265(params, locals);
            if (result.isResolved()) {
                return result;
            }
            return endpointRule272(params, locals);
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule265(S3EndpointParams params, LocalState locals) {
        String outpostType = null;
        if ((outpostType = RulesFunctions.listAccess(locals.bucketArn().resourceId(), 2)) != null) {
            locals = locals.toBuilder().outpostType(outpostType).build();
            RuleResult result = endpointRule266(params, locals);
            if (result.isResolved()) {
                return result;
            }
            return endpointRule271(params, locals);
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule266(S3EndpointParams params, LocalState locals) {
        String accessPointName = null;
        if ((accessPointName = RulesFunctions.listAccess(locals.bucketArn().resourceId(), 3)) != null) {
            locals = locals.toBuilder().accessPointName(accessPointName).build();
            RuleResult result = endpointRule267(params, locals);
            if (result.isResolved()) {
                return result;
            }
            return endpointRule270(params, locals);
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule267(S3EndpointParams params, LocalState locals) {
        if ("accesspoint".equals(locals.outpostType())) {
            RuleResult result = endpointRule268(params, locals);
            if (result.isResolved()) {
                return result;
            }
            return endpointRule269(params, locals);
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule268(S3EndpointParams params, LocalState locals) {
        if (params.endpoint() != null) {
            RuleUrl url = null;
            if ((url = RulesFunctions.parseURL(params.endpoint())) != null) {
                locals = locals.toBuilder().url(url).build();
                return RuleResult.endpoint(Endpoint
                        .builder()
                        .url(URI.create("https://" + locals.accessPointName() + "-" + locals.bucketArn().accountId() + "."
                                + locals.outpostId() + "." + locals.url().authority()))
                        .putAttribute(
                                AwsEndpointAttribute.AUTH_SCHEMES,
                                Arrays.asList(SigV4aAuthScheme.builder().disableDoubleEncoding(true).signingName("s3-outposts")
                                        .signingRegionSet(Arrays.asList("*")).build(),
                                        SigV4AuthScheme.builder().disableDoubleEncoding(true).signingName("s3-outposts")
                                                .signingRegion(locals.bucketArn().region()).build())).build());
            }
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule269(S3EndpointParams params, LocalState locals) {
        return RuleResult.endpoint(Endpoint
                .builder()
                .url(URI.create("https://" + locals.accessPointName() + "-" + locals.bucketArn().accountId() + "."
                        + locals.outpostId() + ".s3-outposts." + locals.bucketArn().region() + "."
                        + locals.bucketPartition().dnsSuffix()))
                .putAttribute(
                        AwsEndpointAttribute.AUTH_SCHEMES,
                        Arrays.asList(
                                SigV4aAuthScheme.builder().disableDoubleEncoding(true).signingName("s3-outposts")
                                        .signingRegionSet(Arrays.asList("*")).build(),
                                SigV4AuthScheme.builder().disableDoubleEncoding(true).signingName("s3-outposts")
                                        .signingRegion(locals.bucketArn().region()).build())).build());
    }

    private static RuleResult endpointRule270(S3EndpointParams params, LocalState locals) {
        return RuleResult.error("Expected an outpost type `accesspoint`, found " + locals.outpostType());
    }

    private static RuleResult endpointRule271(S3EndpointParams params, LocalState locals) {
        return RuleResult.error("Invalid ARN: expected an access point name");
    }

    private static RuleResult endpointRule272(S3EndpointParams params, LocalState locals) {
        return RuleResult.error("Invalid ARN: Expected a 4-component resource");
    }

    private static RuleResult endpointRule273(S3EndpointParams params, LocalState locals) {
        return RuleResult.error("Invalid ARN: The account id may only contain a-z, A-Z, 0-9 and `-`. Found: `"
                + locals.bucketArn().accountId() + "`");
    }

    private static RuleResult endpointRule274(S3EndpointParams params, LocalState locals) {
        return RuleResult.error("Invalid region in ARN: `" + locals.bucketArn().region() + "` (invalid DNS name)");
    }

    private static RuleResult endpointRule275(S3EndpointParams params, LocalState locals) {
        return RuleResult.error("Client was configured for partition `" + locals.partitionResult().name() + "` but ARN (`"
                + params.bucket() + "`) has `" + locals.bucketPartition().name() + "`");
    }

    private static RuleResult endpointRule276(S3EndpointParams params, LocalState locals) {
        return RuleResult.error("Invalid ARN: The outpost Id may only contain a-z, A-Z, 0-9 and `-`. Found: `"
                + locals.outpostId() + "`");
    }

    private static RuleResult endpointRule277(S3EndpointParams params, LocalState locals) {
        return RuleResult.error("Invalid ARN: The Outpost Id was not set");
    }

    private static RuleResult endpointRule278(S3EndpointParams params, LocalState locals) {
        return RuleResult.error("Invalid ARN: Unrecognized format: " + params.bucket() + " (type: " + locals.arnType() + ")");
    }

    private static RuleResult endpointRule279(S3EndpointParams params, LocalState locals) {
        return RuleResult.error("Invalid ARN: No ARN type specified");
    }

    private static RuleResult endpointRule280(S3EndpointParams params, LocalState locals) {
        String arnPrefix = null;
        if ((arnPrefix = RulesFunctions.substring(params.bucket(), 0, 4, false)) != null) {
            locals = locals.toBuilder().arnPrefix(arnPrefix).build();
            if ("arn:".equals(locals.arnPrefix()) && RulesFunctions.awsParseArn(params.bucket()) == null) {
                return RuleResult.error("Invalid ARN: `" + params.bucket() + "` was not a valid ARN");
            }
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule281(S3EndpointParams params, LocalState locals) {
        if (params.forcePathStyle() && RulesFunctions.awsParseArn(params.bucket()) != null) {
            return RuleResult.error("Path-style addressing cannot be used with ARN buckets");
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule282(S3EndpointParams params, LocalState locals) {
        String uriEncodedBucket = null;
        if ((uriEncodedBucket = RulesFunctions.uriEncode(params.bucket())) != null) {
            locals = locals.toBuilder().uriEncodedBucket(uriEncodedBucket).build();
            return endpointRule283(params, locals);
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule283(S3EndpointParams params, LocalState locals) {
        RulePartition partitionResult = null;
        if ((partitionResult = RulesFunctions.awsPartition(locals.region())) != null) {
            locals = locals.toBuilder().partitionResult(partitionResult).build();
            RuleResult result = endpointRule284(params, locals);
            if (result.isResolved()) {
                return result;
            }
            return endpointRule307(params, locals);
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule284(S3EndpointParams params, LocalState locals) {
        if (!params.accelerate()) {
            RuleResult result = endpointRule285(params, locals);
            if (result.isResolved()) {
                return result;
            }
            result = endpointRule286(params, locals);
            if (result.isResolved()) {
                return result;
            }
            result = endpointRule288(params, locals);
            if (result.isResolved()) {
                return result;
            }
            result = endpointRule289(params, locals);
            if (result.isResolved()) {
                return result;
            }
            result = endpointRule290(params, locals);
            if (result.isResolved()) {
                return result;
            }
            result = endpointRule292(params, locals);
            if (result.isResolved()) {
                return result;
            }
            result = endpointRule293(params, locals);
            if (result.isResolved()) {
                return result;
            }
            result = endpointRule294(params, locals);
            if (result.isResolved()) {
                return result;
            }
            result = endpointRule296(params, locals);
            if (result.isResolved()) {
                return result;
            }
            result = endpointRule297(params, locals);
            if (result.isResolved()) {
                return result;
            }
            result = endpointRule298(params, locals);
            if (result.isResolved()) {
                return result;
            }
            result = endpointRule301(params, locals);
            if (result.isResolved()) {
                return result;
            }
            result = endpointRule302(params, locals);
            if (result.isResolved()) {
                return result;
            }
            result = endpointRule303(params, locals);
            if (result.isResolved()) {
                return result;
            }
            return endpointRule306(params, locals);
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule285(S3EndpointParams params, LocalState locals) {
        if (params.useDualStack() && params.endpoint() == null && params.useFips() && "aws-global".equals(locals.region())) {
            return RuleResult.endpoint(Endpoint
                    .builder()
                    .url(URI.create("https://s3-fips.dualstack.us-east-1." + locals.partitionResult().dnsSuffix() + "/"
                            + locals.uriEncodedBucket()))
                    .putAttribute(
                            AwsEndpointAttribute.AUTH_SCHEMES,
                            Arrays.asList(SigV4AuthScheme.builder().disableDoubleEncoding(true).signingName("s3")
                                    .signingRegion("us-east-1").build())).build());
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule286(S3EndpointParams params, LocalState locals) {
        if (params.useDualStack() && params.endpoint() == null && params.useFips() && !("aws-global".equals(locals.region()))
                && params.useGlobalEndpoint()) {
            return endpointRule287(params, locals);
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule287(S3EndpointParams params, LocalState locals) {
        return RuleResult.endpoint(Endpoint
                .builder()
                .url(URI.create("https://s3-fips.dualstack." + locals.region() + "." + locals.partitionResult().dnsSuffix() + "/"
                        + locals.uriEncodedBucket()))
                .putAttribute(
                        AwsEndpointAttribute.AUTH_SCHEMES,
                        Arrays.asList(SigV4AuthScheme.builder().disableDoubleEncoding(true).signingName("s3")
                                .signingRegion(locals.region()).build())).build());
    }

    private static RuleResult endpointRule288(S3EndpointParams params, LocalState locals) {
        if (params.useDualStack() && params.endpoint() == null && params.useFips() && !("aws-global".equals(locals.region()))
                && !params.useGlobalEndpoint()) {
            return RuleResult.endpoint(Endpoint
                    .builder()
                    .url(URI.create("https://s3-fips.dualstack." + locals.region() + "." + locals.partitionResult().dnsSuffix()
                            + "/" + locals.uriEncodedBucket()))
                    .putAttribute(
                            AwsEndpointAttribute.AUTH_SCHEMES,
                            Arrays.asList(SigV4AuthScheme.builder().disableDoubleEncoding(true).signingName("s3")
                                    .signingRegion(locals.region()).build())).build());
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule289(S3EndpointParams params, LocalState locals) {
        if (!params.useDualStack() && params.endpoint() == null && params.useFips() && "aws-global".equals(locals.region())) {
            return RuleResult.endpoint(Endpoint
                    .builder()
                    .url(URI.create("https://s3-fips.us-east-1." + locals.partitionResult().dnsSuffix() + "/"
                            + locals.uriEncodedBucket()))
                    .putAttribute(
                            AwsEndpointAttribute.AUTH_SCHEMES,
                            Arrays.asList(SigV4AuthScheme.builder().disableDoubleEncoding(true).signingName("s3")
                                    .signingRegion("us-east-1").build())).build());
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule290(S3EndpointParams params, LocalState locals) {
        if (!params.useDualStack() && params.endpoint() == null && params.useFips() && !("aws-global".equals(locals.region()))
                && params.useGlobalEndpoint()) {
            return endpointRule291(params, locals);
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule291(S3EndpointParams params, LocalState locals) {
        return RuleResult.endpoint(Endpoint
                .builder()
                .url(URI.create("https://s3-fips." + locals.region() + "." + locals.partitionResult().dnsSuffix() + "/"
                        + locals.uriEncodedBucket()))
                .putAttribute(
                        AwsEndpointAttribute.AUTH_SCHEMES,
                        Arrays.asList(SigV4AuthScheme.builder().disableDoubleEncoding(true).signingName("s3")
                                .signingRegion(locals.region()).build())).build());
    }

    private static RuleResult endpointRule292(S3EndpointParams params, LocalState locals) {
        if (!params.useDualStack() && params.endpoint() == null && params.useFips() && !("aws-global".equals(locals.region()))
                && !params.useGlobalEndpoint()) {
            return RuleResult.endpoint(Endpoint
                    .builder()
                    .url(URI.create("https://s3-fips." + locals.region() + "." + locals.partitionResult().dnsSuffix() + "/"
                            + locals.uriEncodedBucket()))
                    .putAttribute(
                            AwsEndpointAttribute.AUTH_SCHEMES,
                            Arrays.asList(SigV4AuthScheme.builder().disableDoubleEncoding(true).signingName("s3")
                                    .signingRegion(locals.region()).build())).build());
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule293(S3EndpointParams params, LocalState locals) {
        if (params.useDualStack() && params.endpoint() == null && !params.useFips() && "aws-global".equals(locals.region())) {
            return RuleResult.endpoint(Endpoint
                    .builder()
                    .url(URI.create("https://s3.dualstack.us-east-1." + locals.partitionResult().dnsSuffix() + "/"
                            + locals.uriEncodedBucket()))
                    .putAttribute(
                            AwsEndpointAttribute.AUTH_SCHEMES,
                            Arrays.asList(SigV4AuthScheme.builder().disableDoubleEncoding(true).signingName("s3")
                                    .signingRegion("us-east-1").build())).build());
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule294(S3EndpointParams params, LocalState locals) {
        if (params.useDualStack() && params.endpoint() == null && !params.useFips() && !("aws-global".equals(locals.region()))
                && params.useGlobalEndpoint()) {
            return endpointRule295(params, locals);
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule295(S3EndpointParams params, LocalState locals) {
        return RuleResult.endpoint(Endpoint
                .builder()
                .url(URI.create("https://s3.dualstack." + locals.region() + "." + locals.partitionResult().dnsSuffix() + "/"
                        + locals.uriEncodedBucket()))
                .putAttribute(
                        AwsEndpointAttribute.AUTH_SCHEMES,
                        Arrays.asList(SigV4AuthScheme.builder().disableDoubleEncoding(true).signingName("s3")
                                .signingRegion(locals.region()).build())).build());
    }

    private static RuleResult endpointRule296(S3EndpointParams params, LocalState locals) {
        if (params.useDualStack() && params.endpoint() == null && !params.useFips() && !("aws-global".equals(locals.region()))
                && !params.useGlobalEndpoint()) {
            return RuleResult.endpoint(Endpoint
                    .builder()
                    .url(URI.create("https://s3.dualstack." + locals.region() + "." + locals.partitionResult().dnsSuffix() + "/"
                            + locals.uriEncodedBucket()))
                    .putAttribute(
                            AwsEndpointAttribute.AUTH_SCHEMES,
                            Arrays.asList(SigV4AuthScheme.builder().disableDoubleEncoding(true).signingName("s3")
                                    .signingRegion(locals.region()).build())).build());
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule297(S3EndpointParams params, LocalState locals) {
        if (!params.useDualStack() && params.endpoint() != null) {
            RuleUrl url = null;
            if ((url = RulesFunctions.parseURL(params.endpoint())) != null) {
                locals = locals.toBuilder().url(url).build();
                if (!params.useFips() && "aws-global".equals(locals.region())) {
                    return RuleResult.endpoint(Endpoint
                            .builder()
                            .url(URI.create(locals.url().scheme() + "://" + locals.url().authority()
                                    + locals.url().normalizedPath() + locals.uriEncodedBucket()))
                            .putAttribute(
                                    AwsEndpointAttribute.AUTH_SCHEMES,
                                    Arrays.asList(SigV4AuthScheme.builder().disableDoubleEncoding(true).signingName("s3")
                                            .signingRegion("us-east-1").build())).build());
                }
            }
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule298(S3EndpointParams params, LocalState locals) {
        if (!params.useDualStack() && params.endpoint() != null) {
            RuleUrl url = null;
            if ((url = RulesFunctions.parseURL(params.endpoint())) != null) {
                locals = locals.toBuilder().url(url).build();
                if (!params.useFips() && !("aws-global".equals(locals.region())) && params.useGlobalEndpoint()) {
                    RuleResult result = endpointRule299(params, locals);
                    if (result.isResolved()) {
                        return result;
                    }
                    return endpointRule300(params, locals);
                }
            }
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule299(S3EndpointParams params, LocalState locals) {
        if ("us-east-1".equals(locals.region())) {
            return RuleResult.endpoint(Endpoint
                    .builder()
                    .url(URI.create(locals.url().scheme() + "://" + locals.url().authority() + locals.url().normalizedPath()
                            + locals.uriEncodedBucket()))
                    .putAttribute(
                            AwsEndpointAttribute.AUTH_SCHEMES,
                            Arrays.asList(SigV4AuthScheme.builder().disableDoubleEncoding(true).signingName("s3")
                                    .signingRegion(locals.region()).build())).build());
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule300(S3EndpointParams params, LocalState locals) {
        return RuleResult.endpoint(Endpoint
                .builder()
                .url(URI.create(locals.url().scheme() + "://" + locals.url().authority() + locals.url().normalizedPath()
                        + locals.uriEncodedBucket()))
                .putAttribute(
                        AwsEndpointAttribute.AUTH_SCHEMES,
                        Arrays.asList(SigV4AuthScheme.builder().disableDoubleEncoding(true).signingName("s3")
                                .signingRegion(locals.region()).build())).build());
    }

    private static RuleResult endpointRule301(S3EndpointParams params, LocalState locals) {
        if (!params.useDualStack() && params.endpoint() != null) {
            RuleUrl url = null;
            if ((url = RulesFunctions.parseURL(params.endpoint())) != null) {
                locals = locals.toBuilder().url(url).build();
                if (!params.useFips() && !("aws-global".equals(locals.region())) && !params.useGlobalEndpoint()) {
                    return RuleResult.endpoint(Endpoint
                            .builder()
                            .url(URI.create(locals.url().scheme() + "://" + locals.url().authority()
                                    + locals.url().normalizedPath() + locals.uriEncodedBucket()))
                            .putAttribute(
                                    AwsEndpointAttribute.AUTH_SCHEMES,
                                    Arrays.asList(SigV4AuthScheme.builder().disableDoubleEncoding(true).signingName("s3")
                                            .signingRegion(locals.region()).build())).build());
                }
            }
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule302(S3EndpointParams params, LocalState locals) {
        if (!params.useDualStack() && params.endpoint() == null && !params.useFips() && "aws-global".equals(locals.region())) {
            return RuleResult.endpoint(Endpoint
                    .builder()
                    .url(URI.create("https://s3." + locals.partitionResult().dnsSuffix() + "/" + locals.uriEncodedBucket()))
                    .putAttribute(
                            AwsEndpointAttribute.AUTH_SCHEMES,
                            Arrays.asList(SigV4AuthScheme.builder().disableDoubleEncoding(true).signingName("s3")
                                    .signingRegion("us-east-1").build())).build());
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule303(S3EndpointParams params, LocalState locals) {
        if (!params.useDualStack() && params.endpoint() == null && !params.useFips() && !("aws-global".equals(locals.region()))
                && params.useGlobalEndpoint()) {
            RuleResult result = endpointRule304(params, locals);
            if (result.isResolved()) {
                return result;
            }
            return endpointRule305(params, locals);
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule304(S3EndpointParams params, LocalState locals) {
        if ("us-east-1".equals(locals.region())) {
            return RuleResult.endpoint(Endpoint
                    .builder()
                    .url(URI.create("https://s3." + locals.partitionResult().dnsSuffix() + "/" + locals.uriEncodedBucket()))
                    .putAttribute(
                            AwsEndpointAttribute.AUTH_SCHEMES,
                            Arrays.asList(SigV4AuthScheme.builder().disableDoubleEncoding(true).signingName("s3")
                                    .signingRegion(locals.region()).build())).build());
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule305(S3EndpointParams params, LocalState locals) {
        return RuleResult.endpoint(Endpoint
                .builder()
                .url(URI.create("https://s3." + locals.region() + "." + locals.partitionResult().dnsSuffix() + "/"
                        + locals.uriEncodedBucket()))
                .putAttribute(
                        AwsEndpointAttribute.AUTH_SCHEMES,
                        Arrays.asList(SigV4AuthScheme.builder().disableDoubleEncoding(true).signingName("s3")
                                .signingRegion(locals.region()).build())).build());
    }

    private static RuleResult endpointRule306(S3EndpointParams params, LocalState locals) {
        if (!params.useDualStack() && params.endpoint() == null && !params.useFips() && !("aws-global".equals(locals.region()))
                && !params.useGlobalEndpoint()) {
            return RuleResult.endpoint(Endpoint
                    .builder()
                    .url(URI.create("https://s3." + locals.region() + "." + locals.partitionResult().dnsSuffix() + "/"
                            + locals.uriEncodedBucket()))
                    .putAttribute(
                            AwsEndpointAttribute.AUTH_SCHEMES,
                            Arrays.asList(SigV4AuthScheme.builder().disableDoubleEncoding(true).signingName("s3")
                                    .signingRegion(locals.region()).build())).build());
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule307(S3EndpointParams params, LocalState locals) {
        return RuleResult.error("Path-style addressing cannot be used with S3 Accelerate");
    }

    private static RuleResult endpointRule308(S3EndpointParams params, LocalState locals) {
        if (params.useObjectLambdaEndpoint() != null && params.useObjectLambdaEndpoint()) {
            return endpointRule309(params, locals);
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule309(S3EndpointParams params, LocalState locals) {
        RulePartition partitionResult = null;
        if ((partitionResult = RulesFunctions.awsPartition(locals.region())) != null) {
            locals = locals.toBuilder().partitionResult(partitionResult).build();
            RuleResult result = endpointRule310(params, locals);
            if (result.isResolved()) {
                return result;
            }
            return endpointRule316(params, locals);
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule310(S3EndpointParams params, LocalState locals) {
        if (RulesFunctions.isValidHostLabel(locals.region(), true)) {
            RuleResult result = endpointRule311(params, locals);
            if (result.isResolved()) {
                return result;
            }
            result = endpointRule312(params, locals);
            if (result.isResolved()) {
                return result;
            }
            result = endpointRule313(params, locals);
            if (result.isResolved()) {
                return result;
            }
            result = endpointRule314(params, locals);
            if (result.isResolved()) {
                return result;
            }
            return endpointRule315(params, locals);
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule311(S3EndpointParams params, LocalState locals) {
        if (params.useDualStack()) {
            return RuleResult.error("S3 Object Lambda does not support Dual-stack");
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule312(S3EndpointParams params, LocalState locals) {
        if (params.accelerate()) {
            return RuleResult.error("S3 Object Lambda does not support S3 Accelerate");
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule313(S3EndpointParams params, LocalState locals) {
        if (params.endpoint() != null) {
            RuleUrl url = null;
            if ((url = RulesFunctions.parseURL(params.endpoint())) != null) {
                locals = locals.toBuilder().url(url).build();
                return RuleResult.endpoint(Endpoint
                        .builder()
                        .url(URI.create(locals.url().scheme() + "://" + locals.url().authority() + locals.url().path()))
                        .putAttribute(
                                AwsEndpointAttribute.AUTH_SCHEMES,
                                Arrays.asList(SigV4AuthScheme.builder().disableDoubleEncoding(true)
                                        .signingName("s3-object-lambda").signingRegion(locals.region()).build())).build());
            }
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule314(S3EndpointParams params, LocalState locals) {
        if (params.useFips()) {
            return RuleResult.endpoint(Endpoint
                    .builder()
                    .url(URI.create("https://s3-object-lambda-fips." + locals.region() + "."
                            + locals.partitionResult().dnsSuffix()))
                    .putAttribute(
                            AwsEndpointAttribute.AUTH_SCHEMES,
                            Arrays.asList(SigV4AuthScheme.builder().disableDoubleEncoding(true).signingName("s3-object-lambda")
                                    .signingRegion(locals.region()).build())).build());
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule315(S3EndpointParams params, LocalState locals) {
        return RuleResult.endpoint(Endpoint
                .builder()
                .url(URI.create("https://s3-object-lambda." + locals.region() + "." + locals.partitionResult().dnsSuffix()))
                .putAttribute(
                        AwsEndpointAttribute.AUTH_SCHEMES,
                        Arrays.asList(SigV4AuthScheme.builder().disableDoubleEncoding(true).signingName("s3-object-lambda")
                                .signingRegion(locals.region()).build())).build());
    }

    private static RuleResult endpointRule316(S3EndpointParams params, LocalState locals) {
        return RuleResult.error("Invalid region: region was not a valid DNS name.");
    }

    private static RuleResult endpointRule317(S3EndpointParams params, LocalState locals) {
        if (params.bucket() == null) {
            return endpointRule318(params, locals);
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule318(S3EndpointParams params, LocalState locals) {
        RulePartition partitionResult = null;
        if ((partitionResult = RulesFunctions.awsPartition(locals.region())) != null) {
            locals = locals.toBuilder().partitionResult(partitionResult).build();
            RuleResult result = endpointRule319(params, locals);
            if (result.isResolved()) {
                return result;
            }
            return endpointRule342(params, locals);
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule319(S3EndpointParams params, LocalState locals) {
        if (RulesFunctions.isValidHostLabel(locals.region(), true)) {
            RuleResult result = endpointRule320(params, locals);
            if (result.isResolved()) {
                return result;
            }
            result = endpointRule321(params, locals);
            if (result.isResolved()) {
                return result;
            }
            result = endpointRule323(params, locals);
            if (result.isResolved()) {
                return result;
            }
            result = endpointRule324(params, locals);
            if (result.isResolved()) {
                return result;
            }
            result = endpointRule325(params, locals);
            if (result.isResolved()) {
                return result;
            }
            result = endpointRule327(params, locals);
            if (result.isResolved()) {
                return result;
            }
            result = endpointRule328(params, locals);
            if (result.isResolved()) {
                return result;
            }
            result = endpointRule329(params, locals);
            if (result.isResolved()) {
                return result;
            }
            result = endpointRule331(params, locals);
            if (result.isResolved()) {
                return result;
            }
            result = endpointRule332(params, locals);
            if (result.isResolved()) {
                return result;
            }
            result = endpointRule333(params, locals);
            if (result.isResolved()) {
                return result;
            }
            result = endpointRule336(params, locals);
            if (result.isResolved()) {
                return result;
            }
            result = endpointRule337(params, locals);
            if (result.isResolved()) {
                return result;
            }
            result = endpointRule338(params, locals);
            if (result.isResolved()) {
                return result;
            }
            return endpointRule341(params, locals);
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule320(S3EndpointParams params, LocalState locals) {
        if (params.useFips() && params.useDualStack() && params.endpoint() == null && "aws-global".equals(locals.region())) {
            return RuleResult.endpoint(Endpoint
                    .builder()
                    .url(URI.create("https://s3-fips.dualstack.us-east-1." + locals.partitionResult().dnsSuffix()))
                    .putAttribute(
                            AwsEndpointAttribute.AUTH_SCHEMES,
                            Arrays.asList(SigV4AuthScheme.builder().disableDoubleEncoding(true).signingName("s3")
                                    .signingRegion("us-east-1").build())).build());
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule321(S3EndpointParams params, LocalState locals) {
        if (params.useFips() && params.useDualStack() && params.endpoint() == null && !("aws-global".equals(locals.region()))
                && params.useGlobalEndpoint()) {
            return endpointRule322(params, locals);
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule322(S3EndpointParams params, LocalState locals) {
        return RuleResult.endpoint(Endpoint
                .builder()
                .url(URI.create("https://s3-fips.dualstack." + locals.region() + "." + locals.partitionResult().dnsSuffix()))
                .putAttribute(
                        AwsEndpointAttribute.AUTH_SCHEMES,
                        Arrays.asList(SigV4AuthScheme.builder().disableDoubleEncoding(true).signingName("s3")
                                .signingRegion(locals.region()).build())).build());
    }

    private static RuleResult endpointRule323(S3EndpointParams params, LocalState locals) {
        if (params.useFips() && params.useDualStack() && params.endpoint() == null && !("aws-global".equals(locals.region()))
                && !params.useGlobalEndpoint()) {
            return RuleResult.endpoint(Endpoint
                    .builder()
                    .url(URI.create("https://s3-fips.dualstack." + locals.region() + "." + locals.partitionResult().dnsSuffix()))
                    .putAttribute(
                            AwsEndpointAttribute.AUTH_SCHEMES,
                            Arrays.asList(SigV4AuthScheme.builder().disableDoubleEncoding(true).signingName("s3")
                                    .signingRegion(locals.region()).build())).build());
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule324(S3EndpointParams params, LocalState locals) {
        if (params.useFips() && !params.useDualStack() && params.endpoint() == null && "aws-global".equals(locals.region())) {
            return RuleResult.endpoint(Endpoint
                    .builder()
                    .url(URI.create("https://s3-fips.us-east-1." + locals.partitionResult().dnsSuffix()))
                    .putAttribute(
                            AwsEndpointAttribute.AUTH_SCHEMES,
                            Arrays.asList(SigV4AuthScheme.builder().disableDoubleEncoding(true).signingName("s3")
                                    .signingRegion("us-east-1").build())).build());
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule325(S3EndpointParams params, LocalState locals) {
        if (params.useFips() && !params.useDualStack() && params.endpoint() == null && !("aws-global".equals(locals.region()))
                && params.useGlobalEndpoint()) {
            return endpointRule326(params, locals);
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule326(S3EndpointParams params, LocalState locals) {
        return RuleResult.endpoint(Endpoint
                .builder()
                .url(URI.create("https://s3-fips." + locals.region() + "." + locals.partitionResult().dnsSuffix()))
                .putAttribute(
                        AwsEndpointAttribute.AUTH_SCHEMES,
                        Arrays.asList(SigV4AuthScheme.builder().disableDoubleEncoding(true).signingName("s3")
                                .signingRegion(locals.region()).build())).build());
    }

    private static RuleResult endpointRule327(S3EndpointParams params, LocalState locals) {
        if (params.useFips() && !params.useDualStack() && params.endpoint() == null && !("aws-global".equals(locals.region()))
                && !params.useGlobalEndpoint()) {
            return RuleResult.endpoint(Endpoint
                    .builder()
                    .url(URI.create("https://s3-fips." + locals.region() + "." + locals.partitionResult().dnsSuffix()))
                    .putAttribute(
                            AwsEndpointAttribute.AUTH_SCHEMES,
                            Arrays.asList(SigV4AuthScheme.builder().disableDoubleEncoding(true).signingName("s3")
                                    .signingRegion(locals.region()).build())).build());
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule328(S3EndpointParams params, LocalState locals) {
        if (!params.useFips() && params.useDualStack() && params.endpoint() == null && "aws-global".equals(locals.region())) {
            return RuleResult.endpoint(Endpoint
                    .builder()
                    .url(URI.create("https://s3.dualstack.us-east-1." + locals.partitionResult().dnsSuffix()))
                    .putAttribute(
                            AwsEndpointAttribute.AUTH_SCHEMES,
                            Arrays.asList(SigV4AuthScheme.builder().disableDoubleEncoding(true).signingName("s3")
                                    .signingRegion("us-east-1").build())).build());
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule329(S3EndpointParams params, LocalState locals) {
        if (!params.useFips() && params.useDualStack() && params.endpoint() == null && !("aws-global".equals(locals.region()))
                && params.useGlobalEndpoint()) {
            return endpointRule330(params, locals);
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule330(S3EndpointParams params, LocalState locals) {
        return RuleResult.endpoint(Endpoint
                .builder()
                .url(URI.create("https://s3.dualstack." + locals.region() + "." + locals.partitionResult().dnsSuffix()))
                .putAttribute(
                        AwsEndpointAttribute.AUTH_SCHEMES,
                        Arrays.asList(SigV4AuthScheme.builder().disableDoubleEncoding(true).signingName("s3")
                                .signingRegion(locals.region()).build())).build());
    }

    private static RuleResult endpointRule331(S3EndpointParams params, LocalState locals) {
        if (!params.useFips() && params.useDualStack() && params.endpoint() == null && !("aws-global".equals(locals.region()))
                && !params.useGlobalEndpoint()) {
            return RuleResult.endpoint(Endpoint
                    .builder()
                    .url(URI.create("https://s3.dualstack." + locals.region() + "." + locals.partitionResult().dnsSuffix()))
                    .putAttribute(
                            AwsEndpointAttribute.AUTH_SCHEMES,
                            Arrays.asList(SigV4AuthScheme.builder().disableDoubleEncoding(true).signingName("s3")
                                    .signingRegion(locals.region()).build())).build());
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule332(S3EndpointParams params, LocalState locals) {
        if (!params.useFips() && !params.useDualStack() && params.endpoint() != null) {
            RuleUrl url = null;
            if ((url = RulesFunctions.parseURL(params.endpoint())) != null) {
                locals = locals.toBuilder().url(url).build();
                if ("aws-global".equals(locals.region())) {
                    return RuleResult.endpoint(Endpoint
                            .builder()
                            .url(URI.create(locals.url().scheme() + "://" + locals.url().authority() + locals.url().path()))
                            .putAttribute(
                                    AwsEndpointAttribute.AUTH_SCHEMES,
                                    Arrays.asList(SigV4AuthScheme.builder().disableDoubleEncoding(true).signingName("s3")
                                            .signingRegion("us-east-1").build())).build());
                }
            }
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule333(S3EndpointParams params, LocalState locals) {
        if (!params.useFips() && !params.useDualStack() && params.endpoint() != null) {
            RuleUrl url = null;
            if ((url = RulesFunctions.parseURL(params.endpoint())) != null) {
                locals = locals.toBuilder().url(url).build();
                if (!("aws-global".equals(locals.region())) && params.useGlobalEndpoint()) {
                    RuleResult result = endpointRule334(params, locals);
                    if (result.isResolved()) {
                        return result;
                    }
                    return endpointRule335(params, locals);
                }
            }
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule334(S3EndpointParams params, LocalState locals) {
        if ("us-east-1".equals(locals.region())) {
            return RuleResult.endpoint(Endpoint
                    .builder()
                    .url(URI.create(locals.url().scheme() + "://" + locals.url().authority() + locals.url().path()))
                    .putAttribute(
                            AwsEndpointAttribute.AUTH_SCHEMES,
                            Arrays.asList(SigV4AuthScheme.builder().disableDoubleEncoding(true).signingName("s3")
                                    .signingRegion(locals.region()).build())).build());
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule335(S3EndpointParams params, LocalState locals) {
        return RuleResult.endpoint(Endpoint
                .builder()
                .url(URI.create(locals.url().scheme() + "://" + locals.url().authority() + locals.url().path()))
                .putAttribute(
                        AwsEndpointAttribute.AUTH_SCHEMES,
                        Arrays.asList(SigV4AuthScheme.builder().disableDoubleEncoding(true).signingName("s3")
                                .signingRegion(locals.region()).build())).build());
    }

    private static RuleResult endpointRule336(S3EndpointParams params, LocalState locals) {
        if (!params.useFips() && !params.useDualStack() && params.endpoint() != null) {
            RuleUrl url = null;
            if ((url = RulesFunctions.parseURL(params.endpoint())) != null) {
                locals = locals.toBuilder().url(url).build();
                if (!("aws-global".equals(locals.region())) && !params.useGlobalEndpoint()) {
                    return RuleResult.endpoint(Endpoint
                            .builder()
                            .url(URI.create(locals.url().scheme() + "://" + locals.url().authority() + locals.url().path()))
                            .putAttribute(
                                    AwsEndpointAttribute.AUTH_SCHEMES,
                                    Arrays.asList(SigV4AuthScheme.builder().disableDoubleEncoding(true).signingName("s3")
                                            .signingRegion(locals.region()).build())).build());
                }
            }
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule337(S3EndpointParams params, LocalState locals) {
        if (!params.useFips() && !params.useDualStack() && params.endpoint() == null && "aws-global".equals(locals.region())) {
            return RuleResult.endpoint(Endpoint
                    .builder()
                    .url(URI.create("https://s3." + locals.partitionResult().dnsSuffix()))
                    .putAttribute(
                            AwsEndpointAttribute.AUTH_SCHEMES,
                            Arrays.asList(SigV4AuthScheme.builder().disableDoubleEncoding(true).signingName("s3")
                                    .signingRegion("us-east-1").build())).build());
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule338(S3EndpointParams params, LocalState locals) {
        if (!params.useFips() && !params.useDualStack() && params.endpoint() == null && !("aws-global".equals(locals.region()))
                && params.useGlobalEndpoint()) {
            RuleResult result = endpointRule339(params, locals);
            if (result.isResolved()) {
                return result;
            }
            return endpointRule340(params, locals);
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule339(S3EndpointParams params, LocalState locals) {
        if ("us-east-1".equals(locals.region())) {
            return RuleResult.endpoint(Endpoint
                    .builder()
                    .url(URI.create("https://s3." + locals.partitionResult().dnsSuffix()))
                    .putAttribute(
                            AwsEndpointAttribute.AUTH_SCHEMES,
                            Arrays.asList(SigV4AuthScheme.builder().disableDoubleEncoding(true).signingName("s3")
                                    .signingRegion(locals.region()).build())).build());
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule340(S3EndpointParams params, LocalState locals) {
        return RuleResult.endpoint(Endpoint
                .builder()
                .url(URI.create("https://s3." + locals.region() + "." + locals.partitionResult().dnsSuffix()))
                .putAttribute(
                        AwsEndpointAttribute.AUTH_SCHEMES,
                        Arrays.asList(SigV4AuthScheme.builder().disableDoubleEncoding(true).signingName("s3")
                                .signingRegion(locals.region()).build())).build());
    }

    private static RuleResult endpointRule341(S3EndpointParams params, LocalState locals) {
        if (!params.useFips() && !params.useDualStack() && params.endpoint() == null && !("aws-global".equals(locals.region()))
                && !params.useGlobalEndpoint()) {
            return RuleResult.endpoint(Endpoint
                    .builder()
                    .url(URI.create("https://s3." + locals.region() + "." + locals.partitionResult().dnsSuffix()))
                    .putAttribute(
                            AwsEndpointAttribute.AUTH_SCHEMES,
                            Arrays.asList(SigV4AuthScheme.builder().disableDoubleEncoding(true).signingName("s3")
                                    .signingRegion(locals.region()).build())).build());
        }
        return RuleResult.carryOn();
    }

    private static RuleResult endpointRule342(S3EndpointParams params, LocalState locals) {
        return RuleResult.error("Invalid region: region was not a valid DNS name.");
    }

    private static RuleResult endpointRule343(S3EndpointParams params, LocalState locals) {
        return RuleResult.error("A region must be set when sending requests to S3.");
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

        private final String bucketSuffix;

        private final RuleUrl url;

        private final String uriEncodedBucket;

        private final String s3ExpressAvailabilityZoneId;

        private final String s3ExpressAvailabilityZoneDelim;

        private final String accessPointSuffix;

        private final String hardwareType;

        private final String regionPrefix;

        private final String bucketAliasSuffix;

        private final String outpostId;

        private final RulePartition regionPartition;

        private final RuleArn bucketArn;

        private final String arnType;

        private final String accessPointName;

        private final RulePartition bucketPartition;

        private final RulePartition mrapPartition;

        private final String outpostType;

        private final String arnPrefix;

        LocalState() {
            this.region = null;
            this.partitionResult = null;
            this.bucketSuffix = null;
            this.url = null;
            this.uriEncodedBucket = null;
            this.s3ExpressAvailabilityZoneId = null;
            this.s3ExpressAvailabilityZoneDelim = null;
            this.accessPointSuffix = null;
            this.hardwareType = null;
            this.regionPrefix = null;
            this.bucketAliasSuffix = null;
            this.outpostId = null;
            this.regionPartition = null;
            this.bucketArn = null;
            this.arnType = null;
            this.accessPointName = null;
            this.bucketPartition = null;
            this.mrapPartition = null;
            this.outpostType = null;
            this.arnPrefix = null;
        }

        LocalState(Region region) {
            if (region != null) {
                this.region = region.id();
            } else {
                this.region = null;
            }
            this.partitionResult = null;
            this.bucketSuffix = null;
            this.url = null;
            this.uriEncodedBucket = null;
            this.s3ExpressAvailabilityZoneId = null;
            this.s3ExpressAvailabilityZoneDelim = null;
            this.accessPointSuffix = null;
            this.hardwareType = null;
            this.regionPrefix = null;
            this.bucketAliasSuffix = null;
            this.outpostId = null;
            this.regionPartition = null;
            this.bucketArn = null;
            this.arnType = null;
            this.accessPointName = null;
            this.bucketPartition = null;
            this.mrapPartition = null;
            this.outpostType = null;
            this.arnPrefix = null;
        }

        LocalState(LocalStateBuilder builder) {
            this.region = builder.region;
            this.partitionResult = builder.partitionResult;
            this.bucketSuffix = builder.bucketSuffix;
            this.url = builder.url;
            this.uriEncodedBucket = builder.uriEncodedBucket;
            this.s3ExpressAvailabilityZoneId = builder.s3ExpressAvailabilityZoneId;
            this.s3ExpressAvailabilityZoneDelim = builder.s3ExpressAvailabilityZoneDelim;
            this.accessPointSuffix = builder.accessPointSuffix;
            this.hardwareType = builder.hardwareType;
            this.regionPrefix = builder.regionPrefix;
            this.bucketAliasSuffix = builder.bucketAliasSuffix;
            this.outpostId = builder.outpostId;
            this.regionPartition = builder.regionPartition;
            this.bucketArn = builder.bucketArn;
            this.arnType = builder.arnType;
            this.accessPointName = builder.accessPointName;
            this.bucketPartition = builder.bucketPartition;
            this.mrapPartition = builder.mrapPartition;
            this.outpostType = builder.outpostType;
            this.arnPrefix = builder.arnPrefix;
        }

        public String region() {
            return this.region;
        }

        public RulePartition partitionResult() {
            return this.partitionResult;
        }

        public String bucketSuffix() {
            return this.bucketSuffix;
        }

        public RuleUrl url() {
            return this.url;
        }

        public String uriEncodedBucket() {
            return this.uriEncodedBucket;
        }

        public String s3ExpressAvailabilityZoneId() {
            return this.s3ExpressAvailabilityZoneId;
        }

        public String s3ExpressAvailabilityZoneDelim() {
            return this.s3ExpressAvailabilityZoneDelim;
        }

        public String accessPointSuffix() {
            return this.accessPointSuffix;
        }

        public String hardwareType() {
            return this.hardwareType;
        }

        public String regionPrefix() {
            return this.regionPrefix;
        }

        public String bucketAliasSuffix() {
            return this.bucketAliasSuffix;
        }

        public String outpostId() {
            return this.outpostId;
        }

        public RulePartition regionPartition() {
            return this.regionPartition;
        }

        public RuleArn bucketArn() {
            return this.bucketArn;
        }

        public String arnType() {
            return this.arnType;
        }

        public String accessPointName() {
            return this.accessPointName;
        }

        public RulePartition bucketPartition() {
            return this.bucketPartition;
        }

        public RulePartition mrapPartition() {
            return this.mrapPartition;
        }

        public String outpostType() {
            return this.outpostType;
        }

        public String arnPrefix() {
            return this.arnPrefix;
        }

        public LocalStateBuilder toBuilder() {
            return new LocalStateBuilder(this);
        }
    }

    private static final class LocalStateBuilder {
        private String region;

        private RulePartition partitionResult;

        private String bucketSuffix;

        private RuleUrl url;

        private String uriEncodedBucket;

        private String s3ExpressAvailabilityZoneId;

        private String s3ExpressAvailabilityZoneDelim;

        private String accessPointSuffix;

        private String hardwareType;

        private String regionPrefix;

        private String bucketAliasSuffix;

        private String outpostId;

        private RulePartition regionPartition;

        private RuleArn bucketArn;

        private String arnType;

        private String accessPointName;

        private RulePartition bucketPartition;

        private RulePartition mrapPartition;

        private String outpostType;

        private String arnPrefix;

        LocalStateBuilder() {
            this.region = null;
            this.partitionResult = null;
            this.bucketSuffix = null;
            this.url = null;
            this.uriEncodedBucket = null;
            this.s3ExpressAvailabilityZoneId = null;
            this.s3ExpressAvailabilityZoneDelim = null;
            this.accessPointSuffix = null;
            this.hardwareType = null;
            this.regionPrefix = null;
            this.bucketAliasSuffix = null;
            this.outpostId = null;
            this.regionPartition = null;
            this.bucketArn = null;
            this.arnType = null;
            this.accessPointName = null;
            this.bucketPartition = null;
            this.mrapPartition = null;
            this.outpostType = null;
            this.arnPrefix = null;
        }

        LocalStateBuilder(LocalState locals) {
            this.region = locals.region;
            this.partitionResult = locals.partitionResult;
            this.bucketSuffix = locals.bucketSuffix;
            this.url = locals.url;
            this.uriEncodedBucket = locals.uriEncodedBucket;
            this.s3ExpressAvailabilityZoneId = locals.s3ExpressAvailabilityZoneId;
            this.s3ExpressAvailabilityZoneDelim = locals.s3ExpressAvailabilityZoneDelim;
            this.accessPointSuffix = locals.accessPointSuffix;
            this.hardwareType = locals.hardwareType;
            this.regionPrefix = locals.regionPrefix;
            this.bucketAliasSuffix = locals.bucketAliasSuffix;
            this.outpostId = locals.outpostId;
            this.regionPartition = locals.regionPartition;
            this.bucketArn = locals.bucketArn;
            this.arnType = locals.arnType;
            this.accessPointName = locals.accessPointName;
            this.bucketPartition = locals.bucketPartition;
            this.mrapPartition = locals.mrapPartition;
            this.outpostType = locals.outpostType;
            this.arnPrefix = locals.arnPrefix;
        }

        public LocalStateBuilder region(String value) {
            this.region = value;
            return this;
        }

        public LocalStateBuilder partitionResult(RulePartition value) {
            this.partitionResult = value;
            return this;
        }

        public LocalStateBuilder bucketSuffix(String value) {
            this.bucketSuffix = value;
            return this;
        }

        public LocalStateBuilder url(RuleUrl value) {
            this.url = value;
            return this;
        }

        public LocalStateBuilder uriEncodedBucket(String value) {
            this.uriEncodedBucket = value;
            return this;
        }

        public LocalStateBuilder s3ExpressAvailabilityZoneId(String value) {
            this.s3ExpressAvailabilityZoneId = value;
            return this;
        }

        public LocalStateBuilder s3ExpressAvailabilityZoneDelim(String value) {
            this.s3ExpressAvailabilityZoneDelim = value;
            return this;
        }

        public LocalStateBuilder accessPointSuffix(String value) {
            this.accessPointSuffix = value;
            return this;
        }

        public LocalStateBuilder hardwareType(String value) {
            this.hardwareType = value;
            return this;
        }

        public LocalStateBuilder regionPrefix(String value) {
            this.regionPrefix = value;
            return this;
        }

        public LocalStateBuilder bucketAliasSuffix(String value) {
            this.bucketAliasSuffix = value;
            return this;
        }

        public LocalStateBuilder outpostId(String value) {
            this.outpostId = value;
            return this;
        }

        public LocalStateBuilder regionPartition(RulePartition value) {
            this.regionPartition = value;
            return this;
        }

        public LocalStateBuilder bucketArn(RuleArn value) {
            this.bucketArn = value;
            return this;
        }

        public LocalStateBuilder arnType(String value) {
            this.arnType = value;
            return this;
        }

        public LocalStateBuilder accessPointName(String value) {
            this.accessPointName = value;
            return this;
        }

        public LocalStateBuilder bucketPartition(RulePartition value) {
            this.bucketPartition = value;
            return this;
        }

        public LocalStateBuilder mrapPartition(RulePartition value) {
            this.mrapPartition = value;
            return this;
        }

        public LocalStateBuilder outpostType(String value) {
            this.outpostType = value;
            return this;
        }

        public LocalStateBuilder arnPrefix(String value) {
            this.arnPrefix = value;
            return this;
        }

        LocalState build() {
            return new LocalState(this);
        }
    }
}
