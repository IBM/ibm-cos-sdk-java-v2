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

package com.ibm.cos.v2.protocols.xml.internal.unmarshall;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Supplier;
import com.ibm.cos.v2.annotations.SdkInternalApi;
import com.ibm.cos.v2.awscore.exception.AwsServiceException;
import com.ibm.cos.v2.core.SdkPojo;
import com.ibm.cos.v2.protocols.core.ExceptionMetadata;
import com.ibm.cos.v2.protocols.query.internal.unmarshall.AwsXmlErrorUnmarshaller;
import com.ibm.cos.v2.protocols.query.unmarshall.XmlErrorUnmarshaller;

/**
 * A transformer function that takes a parsed XML response and converts it into an {@link AwsServiceException}. Used
 * as a component in the {@link AwsXmlPredicatedResponseHandler}.
 */
@SdkInternalApi
public final class AwsXmlErrorTransformer
        implements Function<AwsXmlUnmarshallingContext, AwsServiceException> {

    private final AwsXmlErrorUnmarshaller awsXmlErrorUnmarshaller;

    private AwsXmlErrorTransformer(Builder builder) {
        this.awsXmlErrorUnmarshaller = AwsXmlErrorUnmarshaller.builder()
                                                              .defaultExceptionSupplier(builder.defaultExceptionSupplier)
                                                              .exceptions(builder.exceptions)
                                                              .errorUnmarshaller(builder.errorUnmarshaller)
                                                              .build();
    }

    @Override
    public AwsServiceException apply(AwsXmlUnmarshallingContext context) {
        return awsXmlErrorUnmarshaller.unmarshall(context.parsedRootXml(),
                                                  Optional.ofNullable(context.parsedErrorXml()),
                                                  Optional.empty(),
                                                  context.sdkHttpFullResponse(),
                                                  context.executionAttributes());
    }

    /**
     * @return New Builder instance.
     */
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Builder for {@link AwsXmlErrorTransformer}.
     */
    public static final class Builder {

        private List<ExceptionMetadata> exceptions;
        private Supplier<SdkPojo> defaultExceptionSupplier;
        private XmlErrorUnmarshaller errorUnmarshaller;

        private Builder() {
        }

        /**
         * List of {@link ExceptionMetadata} to represent the modeled exceptions for the service.
         * For AWS services the error type is a string representing the type of the modeled exception.
         *
         * @return This builder for method chaining.
         */
        public Builder exceptions(List<ExceptionMetadata> exceptions) {
            this.exceptions = exceptions;
            return this;
        }

        /**
         * Default exception type if "error code" does not match any known modeled exception. This is the generated
         * base exception for the service (i.e. DynamoDbException).
         *
         * @return This builder for method chaining.
         */
        public Builder defaultExceptionSupplier(Supplier<SdkPojo> defaultExceptionSupplier) {
            this.defaultExceptionSupplier = defaultExceptionSupplier;
            return this;
        }

        /**
         * The unmarshaller to use. The unmarshaller only unmarshalls any modeled fields of the exception,
         * additional metadata is extracted by {@link AwsXmlErrorTransformer}.
         *
         * @param errorUnmarshaller Error unmarshaller to use.
         * @return This builder for method chaining.
         */
        public Builder errorUnmarshaller(XmlErrorUnmarshaller errorUnmarshaller) {
            this.errorUnmarshaller = errorUnmarshaller;
            return this;
        }

        /**
         * @return New instance of {@link AwsXmlErrorTransformer}.
         */
        public AwsXmlErrorTransformer build() {
            return new AwsXmlErrorTransformer(this);
        }
    }
}
