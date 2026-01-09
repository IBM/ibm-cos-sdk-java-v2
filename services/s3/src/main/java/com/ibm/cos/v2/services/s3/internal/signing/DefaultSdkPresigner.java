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

package com.ibm.cos.v2.services.s3.internal.signing;

import java.net.URI;
import java.util.function.Supplier;
import com.ibm.cos.v2.annotations.SdkInternalApi;
import com.ibm.cos.v2.auth.credentials.AwsCredentialsProvider;
import com.ibm.cos.v2.auth.credentials.DefaultCredentialsProvider;
import com.ibm.cos.v2.awscore.endpoint.DualstackEnabledProvider;
import com.ibm.cos.v2.awscore.endpoint.FipsEnabledProvider;
import com.ibm.cos.v2.awscore.presigner.SdkPresigner;
import com.ibm.cos.v2.identity.spi.AwsCredentialsIdentity;
import com.ibm.cos.v2.identity.spi.IdentityProvider;
import com.ibm.cos.v2.profiles.ProfileFile;
import com.ibm.cos.v2.profiles.ProfileFileSystemSetting;
import com.ibm.cos.v2.regions.Region;
import com.ibm.cos.v2.regions.providers.DefaultAwsRegionProviderChain;
import com.ibm.cos.v2.utils.IoUtils;

/**
 * The base class implementing the {@link SdkPresigner} interface.
 * <p>
 * TODO: This should get moved to aws-core (or split and moved to sdk-core and aws-core) when we support presigning from
 * multiple services.
 * TODO: After moving, this should get marked as an @SdkProtectedApi.
 */
@SdkInternalApi
public abstract class DefaultSdkPresigner implements SdkPresigner {
    private final Supplier<ProfileFile> profileFile;
    private final String profileName;
    private final Region region;
    private final URI endpointOverride;
    private final IdentityProvider<? extends AwsCredentialsIdentity> credentialsProvider;
    private final Boolean dualstackEnabled;
    private final boolean fipsEnabled;

    protected DefaultSdkPresigner(Builder<?> b) {
        this.profileFile = ProfileFile::defaultProfileFile;
        this.profileName = ProfileFileSystemSetting.AWS_PROFILE.getStringValueOrThrow();
        this.region = b.region != null ? b.region : DefaultAwsRegionProviderChain.builder()
                                                                                 .profileFile(profileFile)
                                                                                 .profileName(profileName)
                                                                                 .build()
                                                                                 .getRegion();
        this.credentialsProvider = b.credentialsProvider != null ? b.credentialsProvider
                                                                 : DefaultCredentialsProvider.builder()
                                                                                             .profileFile(profileFile)
                                                                                             .profileName(profileName)
                                                                                             .build();
        this.endpointOverride = b.endpointOverride;
        this.dualstackEnabled = b.dualstackEnabled != null ? b.dualstackEnabled
                                                           : DualstackEnabledProvider.builder()
                                                                                     .profileFile(profileFile)
                                                                                     .profileName(profileName)
                                                                                     .build()
                                                                                     .isDualstackEnabled()
                                                                                     .orElse(null);
        this.fipsEnabled = b.fipsEnabled != null ? b.fipsEnabled
                                                 : FipsEnabledProvider.builder()
                                                                      .profileFile(profileFile)
                                                                      .profileName(profileName)
                                                                      .build()
                                                                      .isFipsEnabled()
                                                                      .orElse(false);
    }

    protected Supplier<ProfileFile> profileFileSupplier() {
        return profileFile;
    }

    protected String profileName() {
        return profileName;
    }

    protected Region region() {
        return region;
    }

    protected IdentityProvider<? extends AwsCredentialsIdentity> credentialsProvider() {
        return credentialsProvider;
    }

    protected Boolean dualstackEnabled() {
        return dualstackEnabled;
    }

    protected boolean fipsEnabled() {
        return fipsEnabled;
    }

    protected URI endpointOverride() {
        return endpointOverride;
    }

    @Override
    public void close() {
        IoUtils.closeIfCloseable(credentialsProvider, null);
    }

    /**
     * The base class implementing the {@link SdkPresigner.Builder} interface.
     */
    @SdkInternalApi
    public abstract static class Builder<B extends Builder<B>>
        implements SdkPresigner.Builder {
        private Region region;
        private IdentityProvider<? extends AwsCredentialsIdentity> credentialsProvider;
        private Boolean dualstackEnabled;
        private Boolean fipsEnabled;
        private URI endpointOverride;

        protected Builder() {
        }

        @Override
        public B region(Region region) {
            this.region = region;
            return thisBuilder();
        }

        @Override
        public B credentialsProvider(AwsCredentialsProvider credentialsProvider) {
            return credentialsProvider((IdentityProvider<? extends AwsCredentialsIdentity>) credentialsProvider);
        }

        @Override
        public B credentialsProvider(IdentityProvider<? extends AwsCredentialsIdentity> credentialsProvider) {
            this.credentialsProvider = credentialsProvider;
            return thisBuilder();
        }

        @Override
        public B dualstackEnabled(Boolean dualstackEnabled) {
            this.dualstackEnabled = dualstackEnabled;
            return thisBuilder();
        }

        @Override
        public B fipsEnabled(Boolean fipsEnabled) {
            this.fipsEnabled = fipsEnabled;
            return thisBuilder();
        }

        @Override
        public B endpointOverride(URI endpointOverride) {
            this.endpointOverride = endpointOverride;
            return thisBuilder();
        }

        @SuppressWarnings("unchecked")
        private B thisBuilder() {
            return (B) this;
        }
    }
}
