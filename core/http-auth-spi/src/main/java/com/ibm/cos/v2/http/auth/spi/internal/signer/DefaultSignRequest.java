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

package com.ibm.cos.v2.http.auth.spi.internal.signer;

import com.ibm.cos.v2.annotations.SdkInternalApi;
import com.ibm.cos.v2.http.ContentStreamProvider;
import com.ibm.cos.v2.http.auth.spi.signer.SignRequest;
import com.ibm.cos.v2.identity.spi.Identity;
import com.ibm.cos.v2.utils.ToString;

@SdkInternalApi
public final class DefaultSignRequest<IdentityT extends Identity>
    extends DefaultBaseSignRequest<ContentStreamProvider, IdentityT> implements SignRequest<IdentityT> {

    private DefaultSignRequest(BuilderImpl<IdentityT> builder) {
        super(builder);
    }

    public static <IdentityT extends Identity> SignRequest.Builder<IdentityT> builder() {
        return new BuilderImpl<>();
    }

    public static <IdentityT extends Identity> SignRequest.Builder<IdentityT> builder(IdentityT identity) {
        return new BuilderImpl<>(identity);
    }

    @Override
    public String toString() {
        return ToString.builder("SignRequest")
            .add("request", request)
            .add("identity", identity)
            .add("properties", properties)
            .build();
    }

    @Override
    public SignRequest.Builder<IdentityT> toBuilder() {
        return new BuilderImpl<>(this);
    }

    @SdkInternalApi
    public static final class BuilderImpl<IdentityT extends Identity>
        extends DefaultBaseSignRequest.BuilderImpl<SignRequest.Builder<IdentityT>, ContentStreamProvider, IdentityT>
        implements SignRequest.Builder<IdentityT> {

        // Used to enable consumer builder pattern in HttpSigner.sign()
        private BuilderImpl() {
        }

        // Used by SignRequest#builder() where identity is passed as parameter, to avoid having to pass Class<IdentityT>.
        private BuilderImpl(IdentityT identity) {
            super(identity);
        }

        private BuilderImpl(DefaultSignRequest<IdentityT> request) {
            properties(request.properties);
            identity(request.identity);
            payload(request.payload);
            request(request.request);
        }

        @Override
        public SignRequest<IdentityT> build() {
            return new DefaultSignRequest<>(this);
        }
    }
}
