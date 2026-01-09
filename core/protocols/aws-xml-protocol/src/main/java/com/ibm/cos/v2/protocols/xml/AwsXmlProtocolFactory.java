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

import static java.util.Collections.unmodifiableList;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Supplier;
import com.ibm.cos.v2.annotations.SdkProtectedApi;
import com.ibm.cos.v2.awscore.AwsResponse;
import com.ibm.cos.v2.awscore.exception.AwsServiceException;
import com.ibm.cos.v2.core.ClientEndpointProvider;
import com.ibm.cos.v2.core.Response;
import com.ibm.cos.v2.core.SdkPojo;
import com.ibm.cos.v2.core.client.config.SdkClientConfiguration;
import com.ibm.cos.v2.core.client.config.SdkClientOption;
import com.ibm.cos.v2.core.http.HttpResponseHandler;
import com.ibm.cos.v2.core.http.MetricCollectingHttpResponseHandler;
import com.ibm.cos.v2.core.internal.http.CombinedResponseHandler;
import com.ibm.cos.v2.core.metrics.CoreMetric;
import com.ibm.cos.v2.http.SdkHttpFullRequest;
import com.ibm.cos.v2.http.SdkHttpFullResponse;
import com.ibm.cos.v2.protocols.core.ExceptionMetadata;
import com.ibm.cos.v2.protocols.core.OperationInfo;
import com.ibm.cos.v2.protocols.core.OperationMetadataAttribute;
import com.ibm.cos.v2.protocols.core.ProtocolMarshaller;
import com.ibm.cos.v2.protocols.query.unmarshall.AwsXmlErrorProtocolUnmarshaller;
import com.ibm.cos.v2.protocols.query.unmarshall.XmlElement;
import com.ibm.cos.v2.protocols.xml.internal.marshall.XmlGenerator;
import com.ibm.cos.v2.protocols.xml.internal.marshall.XmlProtocolMarshaller;
import com.ibm.cos.v2.protocols.xml.internal.unmarshall.AwsXmlErrorTransformer;
import com.ibm.cos.v2.protocols.xml.internal.unmarshall.AwsXmlResponseHandler;
import com.ibm.cos.v2.protocols.xml.internal.unmarshall.AwsXmlResponseTransformer;
import com.ibm.cos.v2.protocols.xml.internal.unmarshall.AwsXmlUnmarshallingContext;
import com.ibm.cos.v2.protocols.xml.internal.unmarshall.XmlProtocolUnmarshaller;
import com.ibm.cos.v2.protocols.xml.internal.unmarshall.XmlResponseHandler;

/**
 * Factory to generate the various protocol handlers and generators to be used for
 * communicating with REST/XML services.
 */
@SdkProtectedApi
public class AwsXmlProtocolFactory {

    /**
     * Attribute for configuring the XML namespace to include in the xmlns attribute of the root element.
     */
    public static final OperationMetadataAttribute<String> XML_NAMESPACE_ATTRIBUTE =
        new OperationMetadataAttribute<>(String.class);

    /**
     * Some services like Route53 specifies the location for the request shape. This should be the root of the
     * generated xml document.
     *
     * Other services Cloudfront, s3 don't specify location param for the request shape. For them, this value will be null.
     */
    public static final OperationMetadataAttribute<String> ROOT_MARSHALL_LOCATION_ATTRIBUTE =
        new OperationMetadataAttribute<>(String.class);

    private static final XmlProtocolUnmarshaller XML_PROTOCOL_UNMARSHALLER = XmlProtocolUnmarshaller.create();

    private final List<ExceptionMetadata> modeledExceptions;
    private final Supplier<SdkPojo> defaultServiceExceptionSupplier;
    private final HttpResponseHandler<AwsServiceException> errorUnmarshaller;
    private final SdkClientConfiguration clientConfiguration;

    AwsXmlProtocolFactory(Builder<?> builder) {
        this.modeledExceptions = unmodifiableList(builder.modeledExceptions);
        this.defaultServiceExceptionSupplier = builder.defaultServiceExceptionSupplier;
        this.clientConfiguration = builder.clientConfiguration;

        this.errorUnmarshaller = timeUnmarshalling(
            AwsXmlErrorProtocolUnmarshaller.builder()
                                           .defaultExceptionSupplier(defaultServiceExceptionSupplier)
                                           .exceptions(modeledExceptions)
                                           .errorUnmarshaller(XML_PROTOCOL_UNMARSHALLER)
                                           .errorRootExtractor(this::getErrorRoot)
                                           .build());
    }

    /**
     * Creates an instance of {@link XmlProtocolMarshaller} to be used for marshalling the request.
     *
     * @param operationInfo Info required to marshall the request
     */
    public ProtocolMarshaller<SdkHttpFullRequest> createProtocolMarshaller(OperationInfo operationInfo) {
        return XmlProtocolMarshaller.builder()
                                    .endpoint(endpoint(clientConfiguration))
                                    .xmlGenerator(createGenerator(operationInfo))
                                    .operationInfo(operationInfo)
                                    .build();
    }

    private URI endpoint(SdkClientConfiguration clientConfiguration) {
        ClientEndpointProvider endpointProvider = clientConfiguration.option(SdkClientOption.CLIENT_ENDPOINT_PROVIDER);
        if (endpointProvider != null) {
            return endpointProvider.clientEndpoint();
        }

        // Some old client versions may not use the endpoint provider. In that case, use the legacy endpoint field.
        return clientConfiguration.option(SdkClientOption.ENDPOINT);
    }

    public <T extends SdkPojo> HttpResponseHandler<T> createResponseHandler(Supplier<SdkPojo> pojoSupplier,
                                                                            XmlOperationMetadata staxOperationMetadata) {
        return createResponseHandler(r -> pojoSupplier.get(), staxOperationMetadata);
    }

    public <T extends SdkPojo> HttpResponseHandler<T> createResponseHandler(Function<SdkHttpFullResponse, SdkPojo> pojoSupplier,
                                                                            XmlOperationMetadata staxOperationMetadata) {
        return timeUnmarshalling(
            new AwsXmlResponseHandler<>(
                new XmlResponseHandler<>(
                    XML_PROTOCOL_UNMARSHALLER, pojoSupplier,
                    staxOperationMetadata.isHasStreamingSuccessResponse())));
    }

    protected <T extends AwsResponse> Function<AwsXmlUnmarshallingContext, T> createResponseTransformer(
        Supplier<SdkPojo> pojoSupplier) {

        return new AwsXmlResponseTransformer<>(
            XML_PROTOCOL_UNMARSHALLER, r -> pojoSupplier.get());
    }

    protected Function<AwsXmlUnmarshallingContext, AwsServiceException> createErrorTransformer() {
        return AwsXmlErrorTransformer.builder()
                                     .defaultExceptionSupplier(defaultServiceExceptionSupplier)
                                     .exceptions(modeledExceptions)
                                     .errorUnmarshaller(XML_PROTOCOL_UNMARSHALLER)
                                     .build();
    }

    public HttpResponseHandler<AwsServiceException> createErrorResponseHandler() {
        return errorUnmarshaller;
    }

    private <T> MetricCollectingHttpResponseHandler<T> timeUnmarshalling(HttpResponseHandler<T> delegate) {
        return MetricCollectingHttpResponseHandler.create(CoreMetric.UNMARSHALLING_DURATION, delegate);
    }

    public <T extends AwsResponse> HttpResponseHandler<Response<T>> createCombinedResponseHandler(
        Supplier<SdkPojo> pojoSupplier, XmlOperationMetadata staxOperationMetadata) {

        return new CombinedResponseHandler<>(createResponseHandler(pojoSupplier, staxOperationMetadata),
                                             createErrorResponseHandler());
    }

    /**
     * Extracts the <Error/> element from the root XML document. This method is protected as S3 has
     * a slightly different location.
     *
     * @param document Root XML document.
     * @return If error root is found than a fulfilled {@link Optional}, otherwise an empty one.
     */
    Optional<XmlElement> getErrorRoot(XmlElement document) {
        return document.getOptionalElementByName("Error");
    }

    protected XmlGenerator createGenerator(OperationInfo operationInfo) {
        return operationInfo.hasPayloadMembers() ?
               XmlGenerator.create(operationInfo.addtionalMetadata(XML_NAMESPACE_ATTRIBUTE), false) :
               null;
    }

    public static Builder builder() {
        return new Builder();
    }

    /**
     * Builder for {@link AwsXmlProtocolFactory}.
     */
    public static class Builder<SubclassT extends Builder> {

        private final List<ExceptionMetadata> modeledExceptions = new ArrayList<>();
        private Supplier<SdkPojo> defaultServiceExceptionSupplier;
        private SdkClientConfiguration clientConfiguration;

        Builder() {
        }

        /**
         * Registers a new modeled exception by the error code.
         *
         * @param errorMetadata metadata for unmarshalling the exceptions
         * @return This builder for method chaining.
         */
        public final SubclassT registerModeledException(ExceptionMetadata errorMetadata) {
            modeledExceptions.add(errorMetadata);
            return getSubclass();
        }

        /**
         * A supplier for the services base exception builder. This is used when we can't identify any modeled
         * exception to unmarshall into.
         *
         * @param exceptionBuilderSupplier Suppplier of the base service exceptions Builder.
         * @return This builder for method chaining.
         */
        public SubclassT defaultServiceExceptionSupplier(Supplier<SdkPojo> exceptionBuilderSupplier) {
            this.defaultServiceExceptionSupplier = exceptionBuilderSupplier;
            return getSubclass();
        }

        /**
         * Sets the {@link SdkClientConfiguration} which contains the service endpoint.
         *
         * @param clientConfiguration Configuration of the client.
         * @return This builder for method chaining.
         */
        public SubclassT clientConfiguration(SdkClientConfiguration clientConfiguration) {
            this.clientConfiguration = clientConfiguration;
            return getSubclass();
        }

        @SuppressWarnings("unchecked")
        private SubclassT getSubclass() {
            return (SubclassT) this;
        }

        public AwsXmlProtocolFactory build() {
            return new AwsXmlProtocolFactory(this);
        }
    }
}
