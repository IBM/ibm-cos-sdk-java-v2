/*
 * Copyright 2018 IBM Corp. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
package com.ibm.cos.v2.services.s3.transform;

import com.ibm.cos.v2.core.exception.SdkClientException;
import com.ibm.cos.v2.core.runtime.transform.Marshaller;
import com.ibm.cos.v2.http.SdkHttpFullRequest;
import com.ibm.cos.v2.http.SdkHttpMethod;
import com.ibm.cos.v2.protocols.core.OperationInfo;
import com.ibm.cos.v2.protocols.core.ProtocolMarshaller;
import com.ibm.cos.v2.protocols.xml.AwsXmlProtocolFactory;
import com.ibm.cos.v2.services.s3.model.ExtendObjectRetentionRequest;
import com.ibm.cos.v2.utils.Validate;

public class ExtendObjectRetentionRequestMarshaller implements Marshaller<ExtendObjectRetentionRequest> {
    private static final OperationInfo SDK_OPERATION_BINDING = OperationInfo.builder()
                                                                            .requestUri("/{Bucket}/{Key+}?extendRetention")
                                                                            .httpMethod(SdkHttpMethod.POST).hasExplicitPayloadMember(true).hasPayloadMembers(true)
                                                                            .putAdditionalMetadata(AwsXmlProtocolFactory.ROOT_MARSHALL_LOCATION_ATTRIBUTE, "ExtendObjectRetention")
                                                                            .putAdditionalMetadata(AwsXmlProtocolFactory.XML_NAMESPACE_ATTRIBUTE, "http://s3.amazonaws.com/doc/2006-03-01/")
                                                                            .build();

    private final AwsXmlProtocolFactory protocolFactory;

    public ExtendObjectRetentionRequestMarshaller(AwsXmlProtocolFactory protocolFactory) {
        this.protocolFactory = protocolFactory;
    }

    @Override
    public SdkHttpFullRequest marshall(ExtendObjectRetentionRequest extendObjectRetentionRequest) {

        Validate.paramNotNull(extendObjectRetentionRequest, "ExtendObjectRetentionRequest");
        try {
            ProtocolMarshaller<SdkHttpFullRequest> protocolMarshaller = protocolFactory
                .createProtocolMarshaller(SDK_OPERATION_BINDING);

            SdkHttpFullRequest request = protocolMarshaller.marshall(extendObjectRetentionRequest);
            SdkHttpFullRequest.Builder builder = request.toBuilder();
            builder.putHeader("Content-Type", "text/plain");
            return request;

        } catch (Exception e) {
            throw SdkClientException.builder().message("Unable to marshall request to JSON: " + e.getMessage()).cause(e).build();
        }
    }
}