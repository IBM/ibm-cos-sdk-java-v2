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

package com.ibm.cos.v2.http.auth.aws.internal.signer;

import com.ibm.cos.v2.identity.spi.internal.IBMOAuthIdentity;
import java.time.Clock;
import com.ibm.cos.v2.annotations.Immutable;
import com.ibm.cos.v2.annotations.SdkInternalApi;
import com.ibm.cos.v2.http.auth.spi.signer.BaseSignRequest;
import com.ibm.cos.v2.http.auth.spi.signer.SignerProperty;
import com.ibm.cos.v2.identity.spi.AwsCredentialsIdentity;
import com.ibm.cos.v2.utils.Validate;


/**
 * A class which contains "properties" relevant to SigV4. These properties can be derived {@link SignerProperty}'s on a
 * {@link BaseSignRequest}.
 */
@SdkInternalApi
@Immutable
public final class V4Properties {
    private final AwsCredentialsIdentity credentials;
    private final CredentialScope credentialScope;
    private final Clock signingClock;
    private final boolean doubleUrlEncode;
    private final boolean normalizePath;
    private final IBMOAuthIdentity iamCredentials;


    private V4Properties(Builder builder) {
        if (builder.iamCredentials != null) {
            // Use IAM credentials
            this.iamCredentials = Validate.paramNotNull(builder.iamCredentials, "iamCredentials");
            this.credentials = null;
            this.credentialScope = null;
            this.doubleUrlEncode = false;
            this.normalizePath = false;
        } else if (builder.credentials != null) {
            // Use AWS credentials
            this.credentials = Validate.paramNotNull(builder.credentials, "credentials");
            this.credentialScope = Validate.paramNotNull(builder.credentialScope, "CredentialScope");
            this.doubleUrlEncode = Validate.getOrDefault(builder.doubleUrlEncode, () -> true);
            this.normalizePath = Validate.getOrDefault(builder.normalizePath, () -> true);
            this.iamCredentials = null;
        } else {
            throw new IllegalArgumentException("Either credentials or iamCredentials must be provided");
        }
        this.signingClock = Validate.paramNotNull(builder.signingClock, "SigningClock");

    }

    public static Builder builder() {
        return new Builder();
    }

    public AwsCredentialsIdentity getCredentials() {
        return credentials;
    }

    public IBMOAuthIdentity getIbmoAuthIdentity() {return iamCredentials; }

    public CredentialScope getCredentialScope() {
        return credentialScope;
    }

    public Clock getSigningClock() {
        return signingClock;
    }

    public boolean shouldDoubleUrlEncode() {
        return doubleUrlEncode;
    }

    public boolean shouldNormalizePath() {
        return normalizePath;
    }

    public IBMOAuthIdentity getiamCredentials() { return iamCredentials; }

    public static class Builder {
        private AwsCredentialsIdentity credentials;
        private CredentialScope credentialScope;
        private Clock signingClock;
        private Boolean doubleUrlEncode;
        private Boolean normalizePath;
        private IBMOAuthIdentity iamCredentials;

        public Builder credentials(AwsCredentialsIdentity credentials) {
            this.credentials = Validate.paramNotNull(credentials, "Credentials");
            return this;
        }

        public Builder iamCredentials(IBMOAuthIdentity iamCredentials){
            this.iamCredentials = Validate.paramNotNull(iamCredentials,"iamCredentials");
            return this;
        }

        public Builder credentialScope(CredentialScope credentialScope) {
            this.credentialScope = Validate.paramNotNull(credentialScope, "CredentialScope");
            return this;
        }

        public Builder signingClock(Clock signingClock) {
            this.signingClock = signingClock;
            return this;
        }

        public Builder doubleUrlEncode(Boolean doubleUrlEncode) {
            this.doubleUrlEncode = doubleUrlEncode;
            return this;
        }

        public Builder normalizePath(Boolean normalizePath) {
            this.normalizePath = normalizePath;
            return this;
        }

        public V4Properties build() {
            return new V4Properties(this);
        }
    }
}
