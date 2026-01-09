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

package com.ibm.cos.v2.transfer.s3.internal.model;

import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import com.ibm.cos.v2.annotations.SdkInternalApi;
import com.ibm.cos.v2.transfer.s3.model.CompletedDirectoryUpload;
import com.ibm.cos.v2.transfer.s3.model.DirectoryUpload;
import com.ibm.cos.v2.utils.ToString;
import com.ibm.cos.v2.utils.Validate;

@SdkInternalApi
public final class DefaultDirectoryUpload implements DirectoryUpload {
    
    private final CompletableFuture<CompletedDirectoryUpload> completionFuture;

    public DefaultDirectoryUpload(CompletableFuture<CompletedDirectoryUpload> completionFuture) {
        this.completionFuture = Validate.paramNotNull(completionFuture, "completionFuture");
    }

    @Override
    public CompletableFuture<CompletedDirectoryUpload> completionFuture() {
        return completionFuture;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        DefaultDirectoryUpload that = (DefaultDirectoryUpload) o;

        return Objects.equals(completionFuture, that.completionFuture);
    }

    @Override
    public int hashCode() {
        return completionFuture != null ? completionFuture.hashCode() : 0;
    }

    @Override
    public String toString() {
        return ToString.builder("DefaultDirectoryUpload")
                       .add("completionFuture", completionFuture)
                       .build();
    }
}
