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
import com.ibm.cos.v2.services.s3.model.PutBucketProtectionConfigurationRequest;
import com.ibm.cos.v2.utils.Validate;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.util.Base64;
import java.util.Optional;

@SdkInternalApi
public class PutBucketProtectionConfigurationMarshaller implements Marshaller<PutBucketProtectionConfigurationRequest> {
    private static final OperationInfo SDK_OPERATION_BINDING = OperationInfo.builder().requestUri("/{Bucket}/?protection")
                                                                            .httpMethod(SdkHttpMethod.PUT).hasExplicitPayloadMember(true).hasPayloadMembers(true)
                                                                            .putAdditionalMetadata(AwsXmlProtocolFactory.ROOT_MARSHALL_LOCATION_ATTRIBUTE, null)
                                                                            .putAdditionalMetadata(AwsXmlProtocolFactory.XML_NAMESPACE_ATTRIBUTE, "http://s3.amazonaws.com/doc/2006-03-01/")
                                                                            .build();

    private final AwsXmlProtocolFactory protocolFactory;

    public PutBucketProtectionConfigurationMarshaller(AwsXmlProtocolFactory protocolFactory) {
        this.protocolFactory = protocolFactory;
    }


    @Override
    public SdkHttpFullRequest marshall(PutBucketProtectionConfigurationRequest bucketProtectionConfiguration) {

        Validate.paramNotNull(bucketProtectionConfiguration, "bucketProtectionConfiguration");
        try {
            ProtocolMarshaller<SdkHttpFullRequest> protocolMarshaller = protocolFactory
                .createProtocolMarshaller(SDK_OPERATION_BINDING);

            SdkHttpFullRequest request = protocolMarshaller.marshall(bucketProtectionConfiguration);

            byte[] content = new byte[0];

            Optional<ContentStreamProvider> csp = request.contentStreamProvider();
            if (csp.isPresent()) {
                try (InputStream is = csp.get().newStream()) {
                    content = toBytes(is);
                }
            }

            // --- Compute Content-MD5 ----
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
