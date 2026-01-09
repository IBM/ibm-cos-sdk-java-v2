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

package com.ibm.cos.v2.auth.credentials.internal;

import java.util.function.Supplier;
import com.ibm.cos.v2.annotations.SdkInternalApi;
import com.ibm.cos.v2.auth.credentials.AwsCredentials;
import com.ibm.cos.v2.auth.credentials.AwsCredentialsProvider;
import com.ibm.cos.v2.utils.IoUtils;
import com.ibm.cos.v2.utils.Lazy;
import com.ibm.cos.v2.utils.SdkAutoCloseable;
import com.ibm.cos.v2.utils.ToString;

/**
 * A wrapper for {@link AwsCredentialsProvider} that defers creation of the underlying provider until the first time the
 * {@link AwsCredentialsProvider#resolveCredentials()} method is invoked.
 */
@SdkInternalApi
public class LazyAwsCredentialsProvider implements AwsCredentialsProvider, SdkAutoCloseable {
    private final Lazy<AwsCredentialsProvider> delegate;

    private LazyAwsCredentialsProvider(Supplier<AwsCredentialsProvider> delegateConstructor) {
        this.delegate = new Lazy<>(delegateConstructor);
    }

    public static LazyAwsCredentialsProvider create(Supplier<AwsCredentialsProvider> delegateConstructor) {
        return new LazyAwsCredentialsProvider(delegateConstructor);
    }

    @Override
    public AwsCredentials resolveCredentials() {
        return delegate.getValue().resolveCredentials();
    }

    @Override
    public void close() {
        IoUtils.closeIfCloseable(delegate, null);
    }

    @Override
    public String toString() {
        return ToString.builder("LazyAwsCredentialsProvider")
                       .add("delegate", delegate)
                       .build();
    }
}
