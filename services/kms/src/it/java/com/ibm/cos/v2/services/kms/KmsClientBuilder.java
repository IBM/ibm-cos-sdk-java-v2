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

package com.ibm.cos.v2.services.kms;

import com.ibm.cos.v2.annotations.Generated;
import com.ibm.cos.v2.awscore.client.builder.AwsSyncClientBuilder;

/**
 * A builder for creating an instance of {@link KmsClient}. This can be created with the static
 * {@link KmsClient#builder()} method.
 */
@Generated("com.ibm.cos.v2:codegen")
public interface KmsClientBuilder extends AwsSyncClientBuilder<KmsClientBuilder, KmsClient>,
        KmsBaseClientBuilder<KmsClientBuilder, KmsClient> {
}
