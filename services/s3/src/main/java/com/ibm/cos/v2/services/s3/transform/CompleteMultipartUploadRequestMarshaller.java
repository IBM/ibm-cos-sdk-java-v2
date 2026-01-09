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
import com.ibm.cos.v2.http.ContentStreamProvider;
import com.ibm.cos.v2.http.Header;
import com.ibm.cos.v2.http.SdkHttpFullRequest;
import com.ibm.cos.v2.http.SdkHttpMethod;
import com.ibm.cos.v2.protocols.core.OperationInfo;
import com.ibm.cos.v2.protocols.core.ProtocolMarshaller;
import com.ibm.cos.v2.protocols.xml.AwsXmlProtocolFactory;
import com.ibm.cos.v2.services.s3.model.CompleteMultipartUploadRequest;
import com.ibm.cos.v2.utils.Validate;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.util.Base64;
import java.util.Optional;

/**
 * {@link CompleteMultipartUploadRequest} Marshaller
 */
@Generated("com.ibm.cos.v2:codegen")
@SdkInternalApi
public class CompleteMultipartUploadRequestMarshaller implements Marshaller<CompleteMultipartUploadRequest> {
    private static final OperationInfo SDK_OPERATION_BINDING = OperationInfo.builder().requestUri("/{Key+}")
            .httpMethod(SdkHttpMethod.POST).hasExplicitPayloadMember(true).hasPayloadMembers(true)
            .putAdditionalMetadata(AwsXmlProtocolFactory.ROOT_MARSHALL_LOCATION_ATTRIBUTE, null)
            .putAdditionalMetadata(AwsXmlProtocolFactory.XML_NAMESPACE_ATTRIBUTE, "http://s3.amazonaws.com/doc/2006-03-01/")
            .build();

    private final AwsXmlProtocolFactory protocolFactory;

    public CompleteMultipartUploadRequestMarshaller(AwsXmlProtocolFactory protocolFactory) {
        this.protocolFactory = protocolFactory;
    }

    @Override
    public SdkHttpFullRequest marshall(CompleteMultipartUploadRequest completeMultipartUploadRequest) {
        Validate.paramNotNull(completeMultipartUploadRequest, "completeMultipartUploadRequest");
        try {
            ProtocolMarshaller<SdkHttpFullRequest> protocolMarshaller = protocolFactory
                    .createProtocolMarshaller(SDK_OPERATION_BINDING);
            SdkHttpFullRequest request =  protocolMarshaller.marshall(completeMultipartUploadRequest);

            byte[] content = new byte[0];

            Optional<ContentStreamProvider> csp = request.contentStreamProvider();
            if (csp.isPresent()) {
                try (InputStream is = csp.get().newStream()) {
                    content = toBytes(is);
                }
            }

            // --- IBM-specific for retention : Compute Content-MD5 ----
            String contentMd5 = computeContentMd5(content);

            byte[] finalContent = content;
            SdkHttpFullRequest.Builder builder = request.toBuilder()
                                                        .putHeader(Header.CONTENT_MD5, contentMd5)
                                                        .contentStreamProvider(() -> new ByteArrayInputStream(finalContent));

            request = builder.build();
            return request;
        } catch (Exception e) {
            throw SdkClientException.builder().message("Unable to marshall request to JSON: " + e.getMessage()).cause(e).build();
        }
    }

    byte[] toBytes(InputStream is) throws IOException {
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        byte[] data = new byte[4096];
        int nRead;
        while ((nRead = is.read(data, 0, data.length)) != -1) {
            buffer.write(data, 0, nRead);
        }
        return buffer.toByteArray();
    }

    private String computeContentMd5(byte[] content) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] md5 = md.digest(content);
            return Base64.getEncoder().encodeToString(md5);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
