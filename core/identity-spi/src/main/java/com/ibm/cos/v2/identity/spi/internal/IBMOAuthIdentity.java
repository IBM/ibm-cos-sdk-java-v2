/*
 * Copyright 2017 IBM Corp. All Rights Reserved.
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

package com.ibm.cos.v2.identity.spi.internal;

import com.ibm.cos.v2.identity.spi.Identity;

public interface IBMOAuthIdentity extends Identity {

    /**
     * Retrieve the IBM api key
     */
    String apiKey();

    /**
     * Retrieve the IBM service instance id.
     */
    String serviceInstanceId();

    /**
     * Retrieve the IAM Token used to authenticate request
     */
    void setIAMToken(String token);

    static IBMOAuthIdentity.Builder builder() {
        return DefaultIAMCredentialsIdentity.builder();
    }

    String getIAMToken();

    interface Builder {
        Builder apiKey(String apiKey);

        Builder serviceInstanceId(String serviceInstanceId);

        IBMOAuthIdentity build();
    }

    /**
     * Constructs a new credentials object, with the specified IAM api key and service Instance ID.
     *
     * @param apikey
     * @param serviceInstanceId
     */
    static IBMOAuthIdentity create(String apikey,String serviceInstanceId) {
        return builder()
            .apiKey(apikey)
            .serviceInstanceId(serviceInstanceId)
            .build();
    }

}
