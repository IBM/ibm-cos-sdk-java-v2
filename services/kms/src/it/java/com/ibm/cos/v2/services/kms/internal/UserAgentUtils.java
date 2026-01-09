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

package com.ibm.cos.v2.services.kms.internal;

import java.util.function.Consumer;
import com.ibm.cos.v2.annotations.Generated;
import com.ibm.cos.v2.annotations.SdkInternalApi;
import com.ibm.cos.v2.awscore.AwsRequestOverrideConfiguration;
import com.ibm.cos.v2.core.ApiName;
import com.ibm.cos.v2.services.kms.model.KmsRequest;

@Generated("com.ibm.cos.v2:codegen")
@SdkInternalApi
public class UserAgentUtils {
    private UserAgentUtils() {
    }

    public static <T extends KmsRequest> T applyUserAgentInfo(T request,
            Consumer<AwsRequestOverrideConfiguration.Builder> userAgentApplier) {
        AwsRequestOverrideConfiguration overrideConfiguration = request.overrideConfiguration()
                .map(c -> c.toBuilder().applyMutation(userAgentApplier).build())
                .orElse((AwsRequestOverrideConfiguration.builder().applyMutation(userAgentApplier).build()));
        return (T) request.toBuilder().overrideConfiguration(overrideConfiguration).build();
    }

    public static <T extends KmsRequest> T applyPaginatorUserAgent(T request) {
        return applyUserAgentInfo(request, b -> b.addApiName(ApiName.builder().name("sdk-metrics").version("C").build()));
    }
}
