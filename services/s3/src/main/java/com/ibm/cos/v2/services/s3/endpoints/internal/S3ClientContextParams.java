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

package com.ibm.cos.v2.services.s3.endpoints;

import com.ibm.cos.v2.annotations.Generated;
import com.ibm.cos.v2.annotations.SdkInternalApi;
import com.ibm.cos.v2.utils.AttributeMap;

@Generated("com.ibm.cos.v2:codegen")
@SdkInternalApi
public final class S3ClientContextParams<T> extends AttributeMap.Key<T> {
    /**
     * Enables this client to use S3 Transfer Acceleration endpoints.
     */
    public static final S3ClientContextParams<Boolean> ACCELERATE = new S3ClientContextParams<>(Boolean.class);

    /**
     * Disables this client's usage of Multi-Region Access Points.
     */
    public static final S3ClientContextParams<Boolean> DISABLE_MULTI_REGION_ACCESS_POINTS = new S3ClientContextParams<>(
            Boolean.class);

    /**
     * Disables this client's usage of Session Auth for S3Express buckets and reverts to using conventional SigV4 for
     * those.
     */
    public static final S3ClientContextParams<Boolean> DISABLE_S3_EXPRESS_SESSION_AUTH = new S3ClientContextParams<>(
            Boolean.class);

    /**
     * Forces this client to use path-style addressing for buckets.
     */
    public static final S3ClientContextParams<Boolean> FORCE_PATH_STYLE = new S3ClientContextParams<>(Boolean.class);

    /**
     * Enables this client to use an ARN's region when constructing an endpoint instead of the client's configured
     * region.
     */
    public static final S3ClientContextParams<Boolean> USE_ARN_REGION = new S3ClientContextParams<>(Boolean.class);

    /**
     * Enables cross-region bucket access for this client
     */
    public static final S3ClientContextParams<Boolean> CROSS_REGION_ACCESS_ENABLED = new S3ClientContextParams<>(Boolean.class);

    private S3ClientContextParams(Class<T> valueClass) {
        super(valueClass);
    }
}
