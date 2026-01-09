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

package com.ibm.cos.v2.services.sts.endpoints;

import com.ibm.cos.v2.annotations.SdkPublicApi;
import com.ibm.cos.v2.regions.Region;
import com.ibm.cos.v2.utils.builder.CopyableBuilder;
import com.ibm.cos.v2.utils.builder.ToCopyableBuilder;

/**
 * The parameters object used to resolve an endpoint for the Sts service.
 */
@SdkPublicApi
public final class StsEndpointParams implements ToCopyableBuilder<StsEndpointParams.Builder, StsEndpointParams> {
    private final Region region;

    private final Boolean useDualStack;

    private final Boolean useFIPS;

    private final String endpoint;

    private final Boolean useGlobalEndpoint;

    private StsEndpointParams(BuilderImpl builder) {
        this.region = builder.region;
        this.useDualStack = builder.useDualStack;
        this.useFIPS = builder.useFIPS;
        this.endpoint = builder.endpoint;
        this.useGlobalEndpoint = builder.useGlobalEndpoint;
    }

    public static Builder builder() {
        return new BuilderImpl();
    }

    public Region region() {
        return region;
    }

    public Boolean useDualStack() {
        return useDualStack;
    }

    public Boolean useFips() {
        return useFIPS;
    }

    public String endpoint() {
        return endpoint;
    }

    public Boolean useGlobalEndpoint() {
        return useGlobalEndpoint;
    }

    public Builder toBuilder() {
        return new BuilderImpl(this);
    }

    public interface Builder extends CopyableBuilder<Builder, StsEndpointParams> {
        Builder region(Region region);

        Builder useDualStack(Boolean useDualStack);

        Builder useFips(Boolean useFIPS);

        Builder endpoint(String endpoint);

        Builder useGlobalEndpoint(Boolean useGlobalEndpoint);

        StsEndpointParams build();
    }

    private static class BuilderImpl implements Builder {
        private Region region;

        private Boolean useDualStack = false;

        private Boolean useFIPS = false;

        private String endpoint;

        private Boolean useGlobalEndpoint = false;

        private BuilderImpl() {
        }

        private BuilderImpl(StsEndpointParams builder) {
            this.region = builder.region;
            this.useDualStack = builder.useDualStack;
            this.useFIPS = builder.useFIPS;
            this.endpoint = builder.endpoint;
            this.useGlobalEndpoint = builder.useGlobalEndpoint;
        }

        @Override
        public Builder region(Region region) {
            this.region = region;
            return this;
        }

        @Override
        public Builder useDualStack(Boolean useDualStack) {
            this.useDualStack = useDualStack;
            if (this.useDualStack == null) {
                this.useDualStack = false;
            }
            return this;
        }

        @Override
        public Builder useFips(Boolean useFIPS) {
            this.useFIPS = useFIPS;
            if (this.useFIPS == null) {
                this.useFIPS = false;
            }
            return this;
        }

        @Override
        public Builder endpoint(String endpoint) {
            this.endpoint = endpoint;
            return this;
        }

        @Override
        public Builder useGlobalEndpoint(Boolean useGlobalEndpoint) {
            this.useGlobalEndpoint = useGlobalEndpoint;
            if (this.useGlobalEndpoint == null) {
                this.useGlobalEndpoint = false;
            }
            return this;
        }

        @Override
        public StsEndpointParams build() {
            return new StsEndpointParams(this);
        }
    }
}
