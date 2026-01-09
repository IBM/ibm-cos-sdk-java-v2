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

package com.ibm.cos.v2.services.s3.auth.scheme.internal;

import java.util.List;
import com.ibm.cos.v2.annotations.Generated;
import com.ibm.cos.v2.annotations.SdkInternalApi;
import com.ibm.cos.v2.http.auth.aws.signer.RegionSet;
import com.ibm.cos.v2.regions.Region;
import com.ibm.cos.v2.services.s3.auth.scheme.S3AuthSchemeParams;
import com.ibm.cos.v2.services.s3.endpoints.S3EndpointProvider;
import com.ibm.cos.v2.utils.Validate;

@Generated("com.ibm.cos.v2:codegen")
@SdkInternalApi
public final class DefaultS3AuthSchemeParams implements S3AuthSchemeParams, S3EndpointResolverAware {
    private final String operation;

    private final Region region;

    private final RegionSet regionSet;

    private final String bucket;

    private final Boolean useFIPS;

    private final Boolean useDualStack;

    private final String endpoint;

    private final Boolean forcePathStyle;

    private final Boolean accelerate;

    private final Boolean useGlobalEndpoint;

    private final Boolean useObjectLambdaEndpoint;

    private final String key;

    private final String prefix;

    private final String copySource;

    private final Boolean disableAccessPoints;

    private final Boolean disableMultiRegionAccessPoints;

    private final Boolean useArnRegion;

    private final Boolean useS3ExpressControlEndpoint;

    private final Boolean disableS3ExpressSessionAuth;

    private final List<String> deleteObjectKeys;

    private final S3EndpointProvider endpointProvider;

    private DefaultS3AuthSchemeParams(Builder builder) {
        this.operation = Validate.paramNotNull(builder.operation, "operation");
        this.region = builder.region;
        this.regionSet = builder.regionSet;
        this.bucket = builder.bucket;
        this.useFIPS = Validate.paramNotNull(builder.useFIPS, "useFIPS");
        this.useDualStack = Validate.paramNotNull(builder.useDualStack, "useDualStack");
        this.endpoint = builder.endpoint;
        this.forcePathStyle = Validate.paramNotNull(builder.forcePathStyle, "forcePathStyle");
        this.accelerate = Validate.paramNotNull(builder.accelerate, "accelerate");
        this.useGlobalEndpoint = Validate.paramNotNull(builder.useGlobalEndpoint, "useGlobalEndpoint");
        this.useObjectLambdaEndpoint = builder.useObjectLambdaEndpoint;
        this.key = builder.key;
        this.prefix = builder.prefix;
        this.copySource = builder.copySource;
        this.disableAccessPoints = builder.disableAccessPoints;
        this.disableMultiRegionAccessPoints = Validate.paramNotNull(builder.disableMultiRegionAccessPoints,
                "disableMultiRegionAccessPoints");
        this.useArnRegion = builder.useArnRegion;
        this.useS3ExpressControlEndpoint = builder.useS3ExpressControlEndpoint;
        this.disableS3ExpressSessionAuth = builder.disableS3ExpressSessionAuth;
        this.deleteObjectKeys = builder.deleteObjectKeys;
        this.endpointProvider = builder.endpointProvider;
    }

    public static S3AuthSchemeParams.Builder builder() {
        return new Builder();
    }

    @Override
    public String operation() {
        return operation;
    }

    @Override
    public Region region() {
        return region;
    }

    @Override
    public RegionSet regionSet() {
        return regionSet;
    }

    @Override
    public String bucket() {
        return bucket;
    }

    @Override
    public Boolean useFips() {
        return useFIPS;
    }

    @Override
    public Boolean useDualStack() {
        return useDualStack;
    }

    @Override
    public String endpoint() {
        return endpoint;
    }

    @Override
    public Boolean forcePathStyle() {
        return forcePathStyle;
    }

    @Override
    public Boolean accelerate() {
        return accelerate;
    }

    @Override
    public Boolean useGlobalEndpoint() {
        return useGlobalEndpoint;
    }

    @Override
    public Boolean useObjectLambdaEndpoint() {
        return useObjectLambdaEndpoint;
    }

    @Override
    public String key() {
        return key;
    }

    @Override
    public String prefix() {
        return prefix;
    }

    @Override
    public String copySource() {
        return copySource;
    }

    @Override
    public Boolean disableAccessPoints() {
        return disableAccessPoints;
    }

    @Override
    public Boolean disableMultiRegionAccessPoints() {
        return disableMultiRegionAccessPoints;
    }

    @Override
    public Boolean useArnRegion() {
        return useArnRegion;
    }

    @Override
    public Boolean useS3ExpressControlEndpoint() {
        return useS3ExpressControlEndpoint;
    }

    @Override
    public Boolean disableS3ExpressSessionAuth() {
        return disableS3ExpressSessionAuth;
    }

    @Override
    public List<String> deleteObjectKeys() {
        return deleteObjectKeys;
    }

    @Override
    public S3EndpointProvider endpointProvider() {
        return endpointProvider;
    }

    @Override
    public S3AuthSchemeParams.Builder toBuilder() {
        return new Builder(this);
    }

    private static final class Builder implements S3AuthSchemeParams.Builder, S3EndpointResolverAware.Builder {
        private String operation;

        private Region region;

        private RegionSet regionSet;

        private String bucket;

        private Boolean useFIPS = false;

        private Boolean useDualStack = false;

        private String endpoint;

        private Boolean forcePathStyle = false;

        private Boolean accelerate = false;

        private Boolean useGlobalEndpoint = false;

        private Boolean useObjectLambdaEndpoint;

        private String key;

        private String prefix;

        private String copySource;

        private Boolean disableAccessPoints;

        private Boolean disableMultiRegionAccessPoints = false;

        private Boolean useArnRegion;

        private Boolean useS3ExpressControlEndpoint;

        private Boolean disableS3ExpressSessionAuth;

        private List<String> deleteObjectKeys;

        private S3EndpointProvider endpointProvider;

        Builder() {
        }

        Builder(DefaultS3AuthSchemeParams params) {
            this.operation = params.operation;
            this.region = params.region;
            this.regionSet = params.regionSet;
            this.bucket = params.bucket;
            this.useFIPS = params.useFIPS;
            this.useDualStack = params.useDualStack;
            this.endpoint = params.endpoint;
            this.forcePathStyle = params.forcePathStyle;
            this.accelerate = params.accelerate;
            this.useGlobalEndpoint = params.useGlobalEndpoint;
            this.useObjectLambdaEndpoint = params.useObjectLambdaEndpoint;
            this.key = params.key;
            this.prefix = params.prefix;
            this.copySource = params.copySource;
            this.disableAccessPoints = params.disableAccessPoints;
            this.disableMultiRegionAccessPoints = params.disableMultiRegionAccessPoints;
            this.useArnRegion = params.useArnRegion;
            this.useS3ExpressControlEndpoint = params.useS3ExpressControlEndpoint;
            this.disableS3ExpressSessionAuth = params.disableS3ExpressSessionAuth;
            this.deleteObjectKeys = params.deleteObjectKeys;
            this.endpointProvider = params.endpointProvider;
        }

        @Override
        public Builder operation(String operation) {
            this.operation = operation;
            return this;
        }

        @Override
        public Builder region(Region region) {
            this.region = region;
            return this;
        }

        @Override
        public Builder regionSet(RegionSet regionSet) {
            this.regionSet = regionSet;
            return this;
        }

        @Override
        public Builder bucket(String bucket) {
            this.bucket = bucket;
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
        public Builder useDualStack(Boolean useDualStack) {
            this.useDualStack = useDualStack;
            if (this.useDualStack == null) {
                this.useDualStack = false;
            }
            return this;
        }

        @Override
        public Builder endpoint(String endpoint) {
            this.endpoint = endpoint;
            return this;
        }

        @Override
        public Builder forcePathStyle(Boolean forcePathStyle) {
            this.forcePathStyle = forcePathStyle;
            if (this.forcePathStyle == null) {
                this.forcePathStyle = false;
            }
            return this;
        }

        @Override
        public Builder accelerate(Boolean accelerate) {
            this.accelerate = accelerate;
            if (this.accelerate == null) {
                this.accelerate = false;
            }
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
        public Builder useObjectLambdaEndpoint(Boolean useObjectLambdaEndpoint) {
            this.useObjectLambdaEndpoint = useObjectLambdaEndpoint;
            return this;
        }

        @Override
        public Builder key(String key) {
            this.key = key;
            return this;
        }

        @Override
        public Builder prefix(String prefix) {
            this.prefix = prefix;
            return this;
        }

        @Override
        public Builder copySource(String copySource) {
            this.copySource = copySource;
            return this;
        }

        @Override
        public Builder disableAccessPoints(Boolean disableAccessPoints) {
            this.disableAccessPoints = disableAccessPoints;
            return this;
        }

        @Override
        public Builder disableMultiRegionAccessPoints(Boolean disableMultiRegionAccessPoints) {
            this.disableMultiRegionAccessPoints = disableMultiRegionAccessPoints;
            if (this.disableMultiRegionAccessPoints == null) {
                this.disableMultiRegionAccessPoints = false;
            }
            return this;
        }

        @Override
        public Builder useArnRegion(Boolean useArnRegion) {
            this.useArnRegion = useArnRegion;
            return this;
        }

        @Override
        public Builder useS3ExpressControlEndpoint(Boolean useS3ExpressControlEndpoint) {
            this.useS3ExpressControlEndpoint = useS3ExpressControlEndpoint;
            return this;
        }

        @Override
        public Builder disableS3ExpressSessionAuth(Boolean disableS3ExpressSessionAuth) {
            this.disableS3ExpressSessionAuth = disableS3ExpressSessionAuth;
            return this;
        }

        @Override
        public Builder deleteObjectKeys(List<String> deleteObjectKeys) {
            this.deleteObjectKeys = deleteObjectKeys;
            return this;
        }

        @Override
        public Builder endpointProvider(S3EndpointProvider endpointProvider) {
            this.endpointProvider = endpointProvider;
            return this;
        }

        @Override
        public S3AuthSchemeParams build() {
            return new DefaultS3AuthSchemeParams(this);
        }
    }
}
