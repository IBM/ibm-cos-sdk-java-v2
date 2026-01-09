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

package com.ibm.cos.v2.services.s3;

import java.util.function.Consumer;
import com.ibm.cos.v2.annotations.Generated;
import com.ibm.cos.v2.awscore.client.builder.AwsAsyncClientBuilder;
import com.ibm.cos.v2.services.s3.multipart.MultipartConfiguration;
import com.ibm.cos.v2.services.s3.multipart.MultipartConfiguration.Builder;

/**
 * A builder for creating an instance of {@link S3AsyncClient}. This can be created with the static
 * {@link S3AsyncClient#builder()} method.
 */
@Generated("com.ibm.cos.v2:codegen")
public interface S3AsyncClientBuilder extends AwsAsyncClientBuilder<S3AsyncClientBuilder, S3AsyncClient>,
        S3BaseClientBuilder<S3AsyncClientBuilder, S3AsyncClient> {
    /**
     * Enables automatic conversion of GET, PUT and COPY methods to their equivalent multipart operation. CRC32 checksum
     * will be enabled for PUT, unless the checksum is specified or checksum validation is disabled.
     */
    default S3AsyncClientBuilder multipartEnabled(Boolean enabled) {
        throw new UnsupportedOperationException();
    }

    /**
     * Configuration for multipart operation of this client.
     */
    default S3AsyncClientBuilder multipartConfiguration(MultipartConfiguration multipartConfiguration) {
        throw new UnsupportedOperationException();
    }

    /**
     * Configuration for multipart operation of this client.
     */
    default S3AsyncClientBuilder multipartConfiguration(Consumer<Builder> multipartConfiguration) {
        Builder builder = MultipartConfiguration.builder();
        multipartConfiguration.accept(builder);
        return multipartConfiguration(builder.build());
    }
}
