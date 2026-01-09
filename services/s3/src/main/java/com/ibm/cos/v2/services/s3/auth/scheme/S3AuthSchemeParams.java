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

package com.ibm.cos.v2.services.s3.auth.scheme;

import java.util.List;
import com.ibm.cos.v2.annotations.Generated;
import com.ibm.cos.v2.annotations.SdkPublicApi;
import com.ibm.cos.v2.http.auth.aws.signer.RegionSet;
import com.ibm.cos.v2.regions.Region;
import com.ibm.cos.v2.services.s3.auth.scheme.internal.DefaultS3AuthSchemeParams;
import com.ibm.cos.v2.utils.builder.CopyableBuilder;
import com.ibm.cos.v2.utils.builder.ToCopyableBuilder;

/**
 * The parameters object used to resolve the auth schemes for the S3 service.
 */
@Generated("com.ibm.cos.v2:codegen")
@SdkPublicApi
public interface S3AuthSchemeParams extends ToCopyableBuilder<S3AuthSchemeParams.Builder, S3AuthSchemeParams> {
    /**
     * Get a new builder for creating a {@link S3AuthSchemeParams}.
     */
    static Builder builder() {
        return DefaultS3AuthSchemeParams.builder();
    }

    /**
     * Returns the operation for which to resolve the auth scheme.
     */
    String operation();

    /**
     * Returns the region. The region parameter may be used with the "aws.auth#sigv4" auth scheme.
     */
    Region region();

    /**
     * Returns the RegionSet. The regionSet parameter may be used with the "aws.auth#sigv4a" auth scheme.
     */
    RegionSet regionSet();

    /**
     * The S3 bucket used to send the request. This is an optional parameter that will be set automatically for
     * operations that are scoped to an S3 bucket.
     */
    String bucket();

    /**
     * When true, send this request to the FIPS-compliant regional endpoint. If the configured endpoint does not have a
     * FIPS compliant endpoint, dispatching the request will return an error.
     */
    Boolean useFips();

    /**
     * When true, use the dual-stack endpoint. If the configured endpoint does not support dual-stack, dispatching the
     * request MAY return an error.
     */
    Boolean useDualStack();

    /**
     * Override the endpoint used to send this request
     */
    String endpoint();

    /**
     * When true, force a path-style endpoint to be used where the bucket name is part of the path.
     */
    Boolean forcePathStyle();

    /**
     * When true, use S3 Accelerate. NOTE: Not all regions support S3 accelerate.
     */
    Boolean accelerate();

    /**
     * Whether the global endpoint should be used, rather then the regional endpoint for us-east-1.
     */
    Boolean useGlobalEndpoint();

    /**
     * Internal parameter to use object lambda endpoint for an operation (eg: WriteGetObjectResponse)
     */
    Boolean useObjectLambdaEndpoint();

    /**
     * The S3 Key used to send the request. This is an optional parameter that will be set automatically for operations
     * that are scoped to an S3 Key.
     */
    String key();

    /**
     * The S3 Prefix used to send the request. This is an optional parameter that will be set automatically for
     * operations that are scoped to an S3 Prefix.
     */
    String prefix();

    /**
     * The Copy Source used for Copy Object request. This is an optional parameter that will be set automatically for
     * operations that are scoped to Copy Source.
     */
    String copySource();

    /**
     * Internal parameter to disable Access Point Buckets
     */
    Boolean disableAccessPoints();

    /**
     * Whether multi-region access points (MRAP) should be disabled.
     */
    Boolean disableMultiRegionAccessPoints();

    /**
     * When an Access Point ARN is provided and this flag is enabled, the SDK MUST use the ARN's region when
     * constructing the endpoint instead of the client's configured region.
     */
    Boolean useArnRegion();

    /**
     * Internal parameter to indicate whether S3Express operation should use control plane, (ex. CreateBucket)
     */
    Boolean useS3ExpressControlEndpoint();

    /**
     * Parameter to indicate whether S3Express session auth should be disabled
     */
    Boolean disableS3ExpressSessionAuth();

    /**
     * DeleteObjectKeys Endpoint Params from the customization config
     */
    List<String> deleteObjectKeys();

    /**
     * Returns a {@link Builder} to customize the parameters.
     */
    Builder toBuilder();

    /**
     * A builder for a {@link S3AuthSchemeParams}.
     */
    interface Builder extends CopyableBuilder<Builder, S3AuthSchemeParams> {
        /**
         * Set the operation for which to resolve the auth scheme.
         */
        Builder operation(String operation);

        /**
         * Set the region. The region parameter may be used with the "aws.auth#sigv4" auth scheme.
         */
        Builder region(Region region);

        /**
         * Set the RegionSet. The regionSet parameter may be used with the "aws.auth#sigv4a" auth scheme.
         */
        Builder regionSet(RegionSet regionSet);

        /**
         * The S3 bucket used to send the request. This is an optional parameter that will be set automatically for
         * operations that are scoped to an S3 bucket.
         */
        Builder bucket(String bucket);

        /**
         * When true, send this request to the FIPS-compliant regional endpoint. If the configured endpoint does not
         * have a FIPS compliant endpoint, dispatching the request will return an error.
         */
        Builder useFips(Boolean useFIPS);

        /**
         * When true, use the dual-stack endpoint. If the configured endpoint does not support dual-stack, dispatching
         * the request MAY return an error.
         */
        Builder useDualStack(Boolean useDualStack);

        /**
         * Override the endpoint used to send this request
         */
        Builder endpoint(String endpoint);

        /**
         * When true, force a path-style endpoint to be used where the bucket name is part of the path.
         */
        Builder forcePathStyle(Boolean forcePathStyle);

        /**
         * When true, use S3 Accelerate. NOTE: Not all regions support S3 accelerate.
         */
        Builder accelerate(Boolean accelerate);

        /**
         * Whether the global endpoint should be used, rather then the regional endpoint for us-east-1.
         */
        Builder useGlobalEndpoint(Boolean useGlobalEndpoint);

        /**
         * Internal parameter to use object lambda endpoint for an operation (eg: WriteGetObjectResponse)
         */
        Builder useObjectLambdaEndpoint(Boolean useObjectLambdaEndpoint);

        /**
         * The S3 Key used to send the request. This is an optional parameter that will be set automatically for
         * operations that are scoped to an S3 Key.
         */
        Builder key(String key);

        /**
         * The S3 Prefix used to send the request. This is an optional parameter that will be set automatically for
         * operations that are scoped to an S3 Prefix.
         */
        Builder prefix(String prefix);

        /**
         * The Copy Source used for Copy Object request. This is an optional parameter that will be set automatically
         * for operations that are scoped to Copy Source.
         */
        Builder copySource(String copySource);

        /**
         * Internal parameter to disable Access Point Buckets
         */
        Builder disableAccessPoints(Boolean disableAccessPoints);

        /**
         * Whether multi-region access points (MRAP) should be disabled.
         */
        Builder disableMultiRegionAccessPoints(Boolean disableMultiRegionAccessPoints);

        /**
         * When an Access Point ARN is provided and this flag is enabled, the SDK MUST use the ARN's region when
         * constructing the endpoint instead of the client's configured region.
         */
        Builder useArnRegion(Boolean useArnRegion);

        /**
         * Internal parameter to indicate whether S3Express operation should use control plane, (ex. CreateBucket)
         */
        Builder useS3ExpressControlEndpoint(Boolean useS3ExpressControlEndpoint);

        /**
         * Parameter to indicate whether S3Express session auth should be disabled
         */
        Builder disableS3ExpressSessionAuth(Boolean disableS3ExpressSessionAuth);

        /**
         * DeleteObjectKeys Endpoint Params from the customization config
         */
        Builder deleteObjectKeys(List<String> deleteObjectKeys);

        /**
         * Returns a {@link S3AuthSchemeParams} object that is created from the properties that have been set on the
         * builder.
         */
        S3AuthSchemeParams build();
    }
}
