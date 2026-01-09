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

package com.ibm.cos.v2.auth.signer;

import com.ibm.cos.v2.annotations.SdkPublicApi;
import com.ibm.cos.v2.auth.signer.internal.AbstractAwsS3V4Signer;

/**
 * AWS4 signer implementation for AWS S3
 *
 * @deprecated Use {@code com.ibm.cos.v2.http.auth.aws.signer.AwsV4HttpSigner} from the 'http-auth-aws' module.
 */
@Deprecated
@SdkPublicApi
public final class AwsS3V4Signer extends AbstractAwsS3V4Signer {
    private AwsS3V4Signer() {
    }

    public static AwsS3V4Signer create() {
        return new AwsS3V4Signer();
    }
}
