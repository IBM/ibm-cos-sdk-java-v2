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

import com.ibm.cos.v2.IBMInternalFlag;
import com.ibm.cos.v2.annotations.Generated;
import com.ibm.cos.v2.annotations.SdkInternalApi;
import com.ibm.cos.v2.core.exception.SdkClientException;
import com.ibm.cos.v2.core.runtime.transform.Marshaller;
import com.ibm.cos.v2.http.SdkHttpFullRequest;
import com.ibm.cos.v2.http.SdkHttpMethod;
import com.ibm.cos.v2.http.auth.aws.internal.signer.util.SignerConstant;
import com.ibm.cos.v2.protocols.core.OperationInfo;
import com.ibm.cos.v2.protocols.core.ProtocolMarshaller;
import com.ibm.cos.v2.protocols.xml.AwsXmlProtocolFactory;
import com.ibm.cos.v2.services.s3.model.CreateBucketRequest;
import com.ibm.cos.v2.utils.Validate;

/**
 * {@link CreateBucketRequest} Marshaller
 */
@Generated("com.ibm.cos.v2:codegen")
@SdkInternalApi
public class CreateBucketRequestMarshaller implements Marshaller<CreateBucketRequest> {
    public static final String IBM_SSE_KP_ENCRYPTION_ALGORITHM = "ibm-sse-kp-encryption-algorithm";
    public static final String IBM_SSE_KP_CUSTOMER_ROOT_KEY_CRN = "ibm-sse-kp-customer-root-key-crn";

    private static final OperationInfo SDK_OPERATION_BINDING = OperationInfo.builder().requestUri("")
            .httpMethod(SdkHttpMethod.PUT).hasExplicitPayloadMember(true).hasPayloadMembers(true)
            .putAdditionalMetadata(AwsXmlProtocolFactory.ROOT_MARSHALL_LOCATION_ATTRIBUTE, null)
            .putAdditionalMetadata(AwsXmlProtocolFactory.XML_NAMESPACE_ATTRIBUTE, "http://s3.amazonaws.com/doc/2006-03-01/")
            .build();

    private final AwsXmlProtocolFactory protocolFactory;

    public CreateBucketRequestMarshaller(AwsXmlProtocolFactory protocolFactory) {
        this.protocolFactory = protocolFactory;
    }

    @Override
    public SdkHttpFullRequest marshall(CreateBucketRequest createBucketRequest) {
        Validate.paramNotNull(createBucketRequest, "createBucketRequest");
        try {
            ProtocolMarshaller<SdkHttpFullRequest> protocolMarshaller = protocolFactory
                    .createProtocolMarshaller(SDK_OPERATION_BINDING);

            SdkHttpFullRequest request =  protocolMarshaller.marshall(createBucketRequest);
            SdkHttpFullRequest.Builder builder = request.toBuilder();

            /**
             * Add IAM specific headers based on the credentials set & any optional
             * parameters added to the CreateBucketRequest object.
             */
            if(IBMInternalFlag.isIAM()) {
                if (createBucketRequest.serviceInstanceId() != null) {
                    builder.putHeader(SignerConstant.IBM_SERVICE_INSTANCE_ID, createBucketRequest.serviceInstanceId());
                }
                if (createBucketRequest.encryptionType() != null) {
                    builder.putHeader(IBM_SSE_KP_ENCRYPTION_ALGORITHM,
                                      createBucketRequest.encryptionType().kmsEncryptionAlgorithm());
                    builder.putHeader(IBM_SSE_KP_CUSTOMER_ROOT_KEY_CRN,
                                      createBucketRequest.encryptionType().ibmSseKmsCustomerRootKeyCrn());
                }
            }

            request = builder.build();
            return request;
        } catch (Exception e) {
            throw SdkClientException.builder().message("Unable to marshall request to JSON: " + e.getMessage()).cause(e).build();
        }
    }
}
