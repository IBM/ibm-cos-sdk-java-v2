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

import com.ibm.cos.v2.utils.ToString;
import com.ibm.cos.v2.utils.Validate;
import java.util.Objects;

public final class DefaultIAMCredentialsIdentity implements IBMOAuthIdentity {

    private final String apiKey;
    private final String serviceInstanceId;
    private String iamToken;

    private DefaultIAMCredentialsIdentity(DefaultIAMCredentialsIdentity.Builder builder) {
        this.apiKey = builder.apiKey;
        this.serviceInstanceId = builder.serviceInstanceId;
        this.iamToken = null;
        Validate.paramNotNull(apiKey, "apiKey");
        Validate.paramNotNull(serviceInstanceId, "serviceInstanceId");
    }
    public static IBMOAuthIdentity.Builder builder() {
        return new DefaultIAMCredentialsIdentity.Builder();
    }

    @Override
    public String apiKey() {
        return apiKey;
    }

    @Override
    public String serviceInstanceId() {
        return serviceInstanceId;
    }

    @Override
    public void setIAMToken(String token){
        this.iamToken = token;
    }

    @Override
    public String toString() {
        return ToString.builder("IBMOAuthIdentity")
                       .add("apiKey", apiKey)
                       .add("serviceInstanceId", serviceInstanceId)
                       //.add("iamToken",iamToken)
                       .build();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        IBMOAuthIdentity that = (IBMOAuthIdentity) o;
        return Objects.equals(apiKey, that.apiKey()) &&
               Objects.equals(serviceInstanceId, that.serviceInstanceId());
    }

    @Override
    public int hashCode() {
        int hashCode = 1;
        hashCode = 31 * hashCode + Objects.hashCode(apiKey);
        hashCode = 31 * hashCode + Objects.hashCode(serviceInstanceId);
        return hashCode;
    }

    @Override
    public String getIAMToken(){
        return iamToken;
    }



    private static final class Builder implements IBMOAuthIdentity.Builder {
        private String apiKey;
        private String serviceInstanceId;
        private String iamToken;

        @Override
        public Builder apiKey(String accessKeyId) {
            this.apiKey = accessKeyId;
            return this;
        }

        @Override
        public Builder serviceInstanceId(String serviceInstanceId) {
            this.serviceInstanceId = serviceInstanceId;
            return this;
        }

        @Override
        public IBMOAuthIdentity build() {
            return new DefaultIAMCredentialsIdentity(this);
        }
    }
}
