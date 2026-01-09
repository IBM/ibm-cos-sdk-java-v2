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

package com.ibm.cos.v2.protocols.xml;

import java.util.Optional;
import java.util.function.Supplier;
import com.ibm.cos.v2.annotations.SdkProtectedApi;
import com.ibm.cos.v2.awscore.AwsResponse;
import com.ibm.cos.v2.core.Response;
import com.ibm.cos.v2.core.SdkPojo;
import com.ibm.cos.v2.core.http.HttpResponseHandler;
import com.ibm.cos.v2.protocols.core.OperationInfo;
import com.ibm.cos.v2.protocols.query.unmarshall.XmlElement;
import com.ibm.cos.v2.protocols.xml.internal.marshall.XmlGenerator;
import com.ibm.cos.v2.protocols.xml.internal.unmarshall.AwsXmlPredicatedResponseHandler;
import com.ibm.cos.v2.protocols.xml.internal.unmarshall.DecorateErrorFromResponseBodyUnmarshaller;

/**
 * Factory to generate the various protocol handlers and generators to be used for communicating with
 * Amazon S3. S3 has some unique differences from typical REST/XML that warrant a custom protocol factory.
 */
@SdkProtectedApi
public final class AwsS3ProtocolFactory extends AwsXmlProtocolFactory {
    private AwsS3ProtocolFactory(Builder builder) {
        super(builder);
    }

    /**
     * For Amazon S3, the Code, Message, and modeled fields are in the top level document.
     *
     * @param document Root XML document.
     * @return If error root is found than a fulfilled {@link Optional}, otherwise an empty one.
     */
    @Override
    Optional<XmlElement> getErrorRoot(XmlElement document) {
        return Optional.of(document);
    }

    public static Builder builder() {
        return new Builder();
    }

    /**
     * Builder for {@link AwsS3ProtocolFactory}.
     */
    public static final class Builder extends AwsXmlProtocolFactory.Builder<Builder> {

        private Builder() {
        }

        @Override
        public AwsS3ProtocolFactory build() {
            return new AwsS3ProtocolFactory(this);
        }
    }

    @Override
    public <T extends AwsResponse> HttpResponseHandler<Response<T>> createCombinedResponseHandler(
        Supplier<SdkPojo> pojoSupplier, XmlOperationMetadata staxOperationMetadata) {

        return createErrorCouldBeInBodyResponseHandler(pojoSupplier, staxOperationMetadata);
    }

    /**
     * Creates a {@link XmlGenerator} with a S3XmlWriter.
     */
    @Override
    protected XmlGenerator createGenerator(OperationInfo operationInfo) {
        return operationInfo.hasPayloadMembers() ?
               XmlGenerator.create(operationInfo.addtionalMetadata(XML_NAMESPACE_ATTRIBUTE), true) :
               null;
    }

    private <T extends AwsResponse> HttpResponseHandler<Response<T>> createErrorCouldBeInBodyResponseHandler(
        Supplier<SdkPojo> pojoSupplier, XmlOperationMetadata staxOperationMetadata) {

        return new AwsXmlPredicatedResponseHandler<>(r -> pojoSupplier.get(),
                                                     createResponseTransformer(pojoSupplier),
                                                     createErrorTransformer(),
                                                     DecorateErrorFromResponseBodyUnmarshaller.of(this::getErrorRoot),
                                                     staxOperationMetadata.isHasStreamingSuccessResponse());
    }
}
