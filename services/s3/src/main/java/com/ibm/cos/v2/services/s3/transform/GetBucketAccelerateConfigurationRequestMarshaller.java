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

package com.ibm.cos.v2.services.s3.transform;

import com.ibm.cos.v2.annotations.Generated;
import com.ibm.cos.v2.annotations.SdkInternalApi;
import com.ibm.cos.v2.core.exception.SdkClientException;
import com.ibm.cos.v2.core.runtime.transform.Marshaller;
import com.ibm.cos.v2.http.SdkHttpFullRequest;
import com.ibm.cos.v2.http.SdkHttpMethod;
import com.ibm.cos.v2.protocols.core.OperationInfo;
import com.ibm.cos.v2.protocols.core.ProtocolMarshaller;
import com.ibm.cos.v2.protocols.xml.AwsXmlProtocolFactory;
import com.ibm.cos.v2.services.s3.model.GetBucketAccelerateConfigurationRequest;
import com.ibm.cos.v2.utils.Validate;

/**
 * {@link GetBucketAccelerateConfigurationRequest} Marshaller
 */
@Generated("com.ibm.cos.v2:codegen")
@SdkInternalApi
public class GetBucketAccelerateConfigurationRequestMarshaller implements Marshaller<GetBucketAccelerateConfigurationRequest> {
    private static final OperationInfo SDK_OPERATION_BINDING = OperationInfo.builder().requestUri("?accelerate")
            .httpMethod(SdkHttpMethod.GET).hasExplicitPayloadMember(false).hasPayloadMembers(false)
            .putAdditionalMetadata(AwsXmlProtocolFactory.ROOT_MARSHALL_LOCATION_ATTRIBUTE, null)
            .putAdditionalMetadata(AwsXmlProtocolFactory.XML_NAMESPACE_ATTRIBUTE, null).build();

    private final AwsXmlProtocolFactory protocolFactory;

    public GetBucketAccelerateConfigurationRequestMarshaller(AwsXmlProtocolFactory protocolFactory) {
        this.protocolFactory = protocolFactory;
    }

    @Override
    public SdkHttpFullRequest marshall(GetBucketAccelerateConfigurationRequest getBucketAccelerateConfigurationRequest) {
        Validate.paramNotNull(getBucketAccelerateConfigurationRequest, "getBucketAccelerateConfigurationRequest");
        try {
            ProtocolMarshaller<SdkHttpFullRequest> protocolMarshaller = protocolFactory
                    .createProtocolMarshaller(SDK_OPERATION_BINDING);
            return protocolMarshaller.marshall(getBucketAccelerateConfigurationRequest);
        } catch (Exception e) {
            throw SdkClientException.builder().message("Unable to marshall request to JSON: " + e.getMessage()).cause(e).build();
        }
    }
}
