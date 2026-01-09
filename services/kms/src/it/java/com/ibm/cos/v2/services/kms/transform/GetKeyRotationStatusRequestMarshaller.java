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

package com.ibm.cos.v2.services.kms.transform;

import com.ibm.cos.v2.annotations.Generated;
import com.ibm.cos.v2.annotations.SdkInternalApi;
import com.ibm.cos.v2.core.exception.SdkClientException;
import com.ibm.cos.v2.core.runtime.transform.Marshaller;
import com.ibm.cos.v2.http.SdkHttpFullRequest;
import com.ibm.cos.v2.http.SdkHttpMethod;
import com.ibm.cos.v2.protocols.core.OperationInfo;
import com.ibm.cos.v2.protocols.core.ProtocolMarshaller;
import com.ibm.cos.v2.protocols.json.BaseAwsJsonProtocolFactory;
import com.ibm.cos.v2.services.kms.model.GetKeyRotationStatusRequest;
import com.ibm.cos.v2.utils.Validate;

/**
 * {@link GetKeyRotationStatusRequest} Marshaller
 */
@Generated("com.ibm.cos.v2:codegen")
@SdkInternalApi
public class GetKeyRotationStatusRequestMarshaller implements Marshaller<GetKeyRotationStatusRequest> {
    private static final OperationInfo SDK_OPERATION_BINDING = OperationInfo.builder().requestUri("/")
            .httpMethod(SdkHttpMethod.POST).hasExplicitPayloadMember(false).hasImplicitPayloadMembers(true)
            .hasPayloadMembers(true).operationIdentifier("TrentService.GetKeyRotationStatus").build();

    private final BaseAwsJsonProtocolFactory protocolFactory;

    public GetKeyRotationStatusRequestMarshaller(BaseAwsJsonProtocolFactory protocolFactory) {
        this.protocolFactory = protocolFactory;
    }

    @Override
    public SdkHttpFullRequest marshall(GetKeyRotationStatusRequest getKeyRotationStatusRequest) {
        Validate.paramNotNull(getKeyRotationStatusRequest, "getKeyRotationStatusRequest");
        try {
            ProtocolMarshaller<SdkHttpFullRequest> protocolMarshaller = protocolFactory
                    .createProtocolMarshaller(SDK_OPERATION_BINDING);
            return protocolMarshaller.marshall(getKeyRotationStatusRequest);
        } catch (Exception e) {
            throw SdkClientException.builder().message("Unable to marshall request to JSON: " + e.getMessage()).cause(e).build();
        }
    }
}
