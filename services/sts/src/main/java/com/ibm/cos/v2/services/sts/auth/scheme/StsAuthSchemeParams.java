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

package com.ibm.cos.v2.services.sts.auth.scheme;

import com.ibm.cos.v2.annotations.Generated;
import com.ibm.cos.v2.annotations.SdkPublicApi;
import com.ibm.cos.v2.regions.Region;
import com.ibm.cos.v2.services.sts.auth.scheme.internal.DefaultStsAuthSchemeParams;
import com.ibm.cos.v2.utils.builder.CopyableBuilder;
import com.ibm.cos.v2.utils.builder.ToCopyableBuilder;

/**
 * The parameters object used to resolve the auth schemes for the Sts service.
 */
@Generated("com.ibm.cos.v2:codegen")
@SdkPublicApi
public interface StsAuthSchemeParams extends ToCopyableBuilder<StsAuthSchemeParams.Builder, StsAuthSchemeParams> {
    /**
     * Get a new builder for creating a {@link StsAuthSchemeParams}.
     */
    static Builder builder() {
        return DefaultStsAuthSchemeParams.builder();
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
     * Returns a {@link Builder} to customize the parameters.
     */
    Builder toBuilder();

    /**
     * A builder for a {@link StsAuthSchemeParams}.
     */
    interface Builder extends CopyableBuilder<Builder, StsAuthSchemeParams> {
        /**
         * Set the operation for which to resolve the auth scheme.
         */
        Builder operation(String operation);

        /**
         * Set the region. The region parameter may be used with the "aws.auth#sigv4" auth scheme.
         */
        Builder region(Region region);

        /**
         * Returns a {@link StsAuthSchemeParams} object that is created from the properties that have been set on the
         * builder.
         */
        StsAuthSchemeParams build();
    }
}
