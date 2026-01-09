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

package com.ibm.cos.v2.services.sts.internal;

import java.net.URI;
import com.ibm.cos.v2.annotations.SdkInternalApi;
import com.ibm.cos.v2.auth.credentials.AwsCredentials;
import com.ibm.cos.v2.auth.credentials.AwsCredentialsProvider;
import com.ibm.cos.v2.auth.credentials.ChildProfileCredentialsProviderFactory;
import com.ibm.cos.v2.profiles.Profile;
import com.ibm.cos.v2.profiles.ProfileProperty;
import com.ibm.cos.v2.regions.Region;
import com.ibm.cos.v2.regions.providers.DefaultAwsRegionProviderChain;
import com.ibm.cos.v2.services.sts.StsClient;
import com.ibm.cos.v2.services.sts.StsClientBuilder;
import com.ibm.cos.v2.services.sts.auth.StsAssumeRoleCredentialsProvider;
import com.ibm.cos.v2.services.sts.model.AssumeRoleRequest;
import com.ibm.cos.v2.utils.IoUtils;
import com.ibm.cos.v2.utils.SdkAutoCloseable;

/**
 * An implementation of {@link ChildProfileCredentialsProviderFactory} that uses configuration in a profile to create a
 * {@link StsAssumeRoleCredentialsProvider}.
 */
@SdkInternalApi
public final class StsProfileCredentialsProviderFactory implements ChildProfileCredentialsProviderFactory {
    private static final String MISSING_PROPERTY_ERROR_FORMAT = "'%s' must be set to use role-based credential loading in the "
                                                                + "'%s' profile.";

    @Override
    public AwsCredentialsProvider create(AwsCredentialsProvider sourceCredentialsProvider, Profile profile) {
        return new StsProfileCredentialsProvider(sourceCredentialsProvider, profile);
    }

    /**
     * A wrapper for a {@link StsAssumeRoleCredentialsProvider} that is returned by this factory when
     * {@link #create(AwsCredentialsProvider, Profile)} is invoked. This wrapper is important because it ensures the parent
     * credentials provider is closed when the assume-role credentials provider is no longer needed.
     */
    private static final class StsProfileCredentialsProvider implements AwsCredentialsProvider, SdkAutoCloseable {
        private final StsClient stsClient;
        private final AwsCredentialsProvider parentCredentialsProvider;
        private final StsAssumeRoleCredentialsProvider credentialsProvider;

        private StsProfileCredentialsProvider(AwsCredentialsProvider parentCredentialsProvider, Profile profile) {
            String roleArn = requireProperty(profile, ProfileProperty.ROLE_ARN);
            String roleSessionName = profile.property(ProfileProperty.ROLE_SESSION_NAME)
                                            .orElseGet(() -> "ibm-cos-java-sdk-" + System.currentTimeMillis());
            String externalId = profile.property(ProfileProperty.EXTERNAL_ID).orElse(null);

            AssumeRoleRequest assumeRoleRequest = AssumeRoleRequest.builder()
                                                                   .roleArn(roleArn)
                                                                   .roleSessionName(roleSessionName)
                                                                   .externalId(externalId)
                                                                   .build();

            this.stsClient = StsClient.builder()
                                      .applyMutation(client -> configureEndpoint(client, profile))
                                      .credentialsProvider(parentCredentialsProvider)
                                      .build();

            this.parentCredentialsProvider = parentCredentialsProvider;
            this.credentialsProvider = StsAssumeRoleCredentialsProvider.builder()
                                                                       .stsClient(stsClient)
                                                                       .refreshRequest(assumeRoleRequest)
                                                                       .build();
        }

        private void configureEndpoint(StsClientBuilder stsClientBuilder, Profile profile) {
            Region stsRegion = profile.property(ProfileProperty.REGION)
                                      .map(Region::of)
                                      .orElseGet(() -> {
                                          try {
                                              return new DefaultAwsRegionProviderChain().getRegion();
                                          } catch (RuntimeException e) {
                                              return null;
                                          }
                                      });

            if (stsRegion != null) {
                stsClientBuilder.region(stsRegion);
            } else {
                stsClientBuilder.region(Region.US_EAST_1);
                stsClientBuilder.endpointOverride(URI.create("https://sts.amazonaws.com"));
            }
        }

        private String requireProperty(Profile profile, String requiredProperty) {
            return profile.property(requiredProperty)
                          .orElseThrow(() -> new IllegalArgumentException(String.format(MISSING_PROPERTY_ERROR_FORMAT,
                                                                                        requiredProperty, profile.name())));
        }

        @Override
        public AwsCredentials resolveCredentials() {
            return this.credentialsProvider.resolveCredentials();
        }

        @Override
        public void close() {
            IoUtils.closeIfCloseable(parentCredentialsProvider, null);
            IoUtils.closeQuietly(credentialsProvider, null);
            IoUtils.closeQuietly(stsClient, null);
        }
    }
}
