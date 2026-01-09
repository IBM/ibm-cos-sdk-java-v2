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

package com.ibm.cos.v2.protocols.query.unmarshall;

import com.ibm.cos.v2.annotations.SdkProtectedApi;
import com.ibm.cos.v2.core.SdkPojo;
import com.ibm.cos.v2.http.SdkHttpFullResponse;

/**
 * Interface to unmarshall a AWS/QUERY or REST/XML error response.
 */
@SdkProtectedApi
public interface XmlErrorUnmarshaller {

    /**
     * @param sdkPojo Builder for exception class to unmarshall.
     * @param resultRoot Parsed XML document of response.
     * @param response HTTP response.
     * @param <TypeT> Type being unmarshalled.
     * @return Unmarshalled exception
     */
    <TypeT extends SdkPojo> TypeT unmarshall(SdkPojo sdkPojo,
                                             XmlElement resultRoot,
                                             SdkHttpFullResponse response);
}
