/*
 * Copyright 2025 IBM Corp. All Rights Reserved.
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
import com.ibm.cos.v2.services.s3.model.PutBucketReplicationReattemptRequest;
import com.ibm.cos.v2.utils.Validate;

public class PutBucketReplicationReattemptRequestMarshaller implements Marshaller<PutBucketReplicationReattemptRequest> {
    private static final OperationInfo SDK_OPERATION_BINDING = OperationInfo.builder().requestUri("/{Bucket}/?ibm-replication"
                                                                                                  + "-reattempt")
                                                                            .httpMethod(SdkHttpMethod.PUT).hasExplicitPayloadMember(true).hasPayloadMembers(true).hasStreamingInput(true)
                                                                            .putAdditionalMetadata(AwsXmlProtocolFactory.ROOT_MARSHALL_LOCATION_ATTRIBUTE, null)
                                                                            .putAdditionalMetadata(AwsXmlProtocolFactory.XML_NAMESPACE_ATTRIBUTE, null).build();

    private final AwsXmlProtocolFactory protocolFactory;

    public PutBucketReplicationReattemptRequestMarshaller(AwsXmlProtocolFactory protocolFactory) {
        this.protocolFactory = protocolFactory;
    }

    @Override
    public SdkHttpFullRequest marshall(PutBucketReplicationReattemptRequest setBucketReplicationReattemptRequest) {
        Validate.paramNotNull(setBucketReplicationReattemptRequest, "setBucketReplicationReattemptRequest");
        try {
            ProtocolMarshaller<SdkHttpFullRequest> protocolMarshaller = protocolFactory
                .createProtocolMarshaller(SDK_OPERATION_BINDING);
            return protocolMarshaller.marshall(setBucketReplicationReattemptRequest);
        } catch (Exception e) {
            throw SdkClientException.builder().message("Unable to marshall request to JSON: " + e.getMessage()).cause(e).build();
        }
    }
}