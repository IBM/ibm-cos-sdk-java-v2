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

package com.ibm.cos.v2.core.identity;

import com.ibm.cos.v2.annotations.Immutable;
import com.ibm.cos.v2.annotations.SdkPublicApi;
import com.ibm.cos.v2.annotations.ThreadSafe;
import com.ibm.cos.v2.core.SdkClient;
import com.ibm.cos.v2.identity.spi.IdentityProperty;

@SdkPublicApi
@Immutable
@ThreadSafe
public final class SdkIdentityProperty {

    public static final IdentityProperty<SdkClient> SDK_CLIENT = IdentityProperty.create(SdkIdentityProperty.class, "SdkClient");

    private SdkIdentityProperty() {
    }
}
