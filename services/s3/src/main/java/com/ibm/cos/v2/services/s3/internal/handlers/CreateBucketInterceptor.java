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

package com.ibm.cos.v2.services.s3.internal.handlers;

import com.ibm.cos.v2.annotations.SdkInternalApi;
import com.ibm.cos.v2.awscore.AwsExecutionAttribute;
import com.ibm.cos.v2.core.SdkRequest;
import com.ibm.cos.v2.core.interceptor.Context;
import com.ibm.cos.v2.core.interceptor.ExecutionAttributes;
import com.ibm.cos.v2.core.interceptor.ExecutionInterceptor;
import com.ibm.cos.v2.regions.Region;
import com.ibm.cos.v2.services.s3.internal.BucketUtils;
import com.ibm.cos.v2.services.s3.model.CreateBucketConfiguration;
import com.ibm.cos.v2.services.s3.model.CreateBucketRequest;

@SdkInternalApi
public final class CreateBucketInterceptor implements ExecutionInterceptor {

    @Override
    public SdkRequest modifyRequest(Context.ModifyRequest context, ExecutionAttributes executionAttributes) {
        SdkRequest sdkRequest = context.request();

        if (sdkRequest instanceof CreateBucketRequest) {
            CreateBucketRequest request = (CreateBucketRequest) sdkRequest;
            validateBucketNameIsS3Compatible(request.bucket());

            if (request.createBucketConfiguration() == null) {
                return addLocationConstraintToRequest(request,
                                                      executionAttributes,
                                                      CreateBucketConfiguration.builder().build());
            }

            CreateBucketConfiguration bucketConfiguration = request.createBucketConfiguration();
            
            if (bucketConfiguration.locationConstraint() == null && bucketConfiguration.location() == null) {
                return addLocationConstraintToRequest(request, executionAttributes, bucketConfiguration);
            }
        }

        return sdkRequest;
    }

    private SdkRequest addLocationConstraintToRequest(CreateBucketRequest request,
                                                      ExecutionAttributes executionAttributes,
                                                      CreateBucketConfiguration configuration) {
        Region region = executionAttributes.getAttribute(AwsExecutionAttribute.AWS_REGION);
        return request.copy(r -> r.createBucketConfiguration(setLocationConstraint(region, configuration)));
    }

    private CreateBucketConfiguration setLocationConstraint(Region region, CreateBucketConfiguration configuration) {
        if (region.equals(Region.US_EAST_1)) {
            // us-east-1 requires no location restraint. See http://docs.aws.amazon.com/AmazonS3/latest/API/RESTBucketPUT.html
            return null;
        }
        return configuration.copy(c -> c.locationConstraint(region.id()).build());
    }

    /**
     * Validates that the name of the bucket being requested to be created
     * is a valid S3 bucket name according to their guidelines. If the bucket
     * name is not valid, an {@link IllegalArgumentException} is thrown. See
     * {@link BucketUtils#isValidDnsBucketName(String, boolean)} for additional
     * details.
     *
     * @param bucketName Name of the bucket
     */
    private void validateBucketNameIsS3Compatible(String bucketName) {
        BucketUtils.isValidDnsBucketName(bucketName, true);
    }
}
