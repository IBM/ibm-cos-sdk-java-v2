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

package com.ibm.cos.v2.services.s3.endpoints;

import java.util.List;
import com.ibm.cos.v2.annotations.Generated;
import com.ibm.cos.v2.annotations.SdkPublicApi;
import com.ibm.cos.v2.regions.Region;
import com.ibm.cos.v2.utils.builder.CopyableBuilder;
import com.ibm.cos.v2.utils.builder.ToCopyableBuilder;

/**
 * The parameters object used to resolve an endpoint for the S3 service.
 */
@Generated("com.ibm.cos.v2:codegen")
@SdkPublicApi
public final class S3EndpointParams implements ToCopyableBuilder<S3EndpointParams.Builder, S3EndpointParams> {
    private final String bucket;

    private final Region region;

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

    private S3EndpointParams(BuilderImpl builder) {
        this.bucket = builder.bucket;
        this.region = builder.region;
        this.useFIPS = builder.useFIPS;
        this.useDualStack = builder.useDualStack;
        this.endpoint = builder.endpoint;
        this.forcePathStyle = builder.forcePathStyle;
        this.accelerate = builder.accelerate;
        this.useGlobalEndpoint = builder.useGlobalEndpoint;
        this.useObjectLambdaEndpoint = builder.useObjectLambdaEndpoint;
        this.key = builder.key;
        this.prefix = builder.prefix;
        this.copySource = builder.copySource;
        this.disableAccessPoints = builder.disableAccessPoints;
        this.disableMultiRegionAccessPoints = builder.disableMultiRegionAccessPoints;
        this.useArnRegion = builder.useArnRegion;
        this.useS3ExpressControlEndpoint = builder.useS3ExpressControlEndpoint;
        this.disableS3ExpressSessionAuth = builder.disableS3ExpressSessionAuth;
        this.deleteObjectKeys = builder.deleteObjectKeys;
    }

    public static Builder builder() {
        return new BuilderImpl();
    }

    public String bucket() {
        return bucket;
    }

    public Region region() {
        return region;
    }

    public Boolean useFips() {
        return useFIPS;
    }

    public Boolean useDualStack() {
        return useDualStack;
    }

    public String endpoint() {
        return endpoint;
    }

    public Boolean forcePathStyle() {
        return forcePathStyle;
    }

    public Boolean accelerate() {
        return accelerate;
    }

    public Boolean useGlobalEndpoint() {
        return useGlobalEndpoint;
    }

    public Boolean useObjectLambdaEndpoint() {
        return useObjectLambdaEndpoint;
    }

    public String key() {
        return key;
    }

    public String prefix() {
        return prefix;
    }

    public String copySource() {
        return copySource;
    }

    public Boolean disableAccessPoints() {
        return disableAccessPoints;
    }

    public Boolean disableMultiRegionAccessPoints() {
        return disableMultiRegionAccessPoints;
    }

    public Boolean useArnRegion() {
        return useArnRegion;
    }

    public Boolean useS3ExpressControlEndpoint() {
        return useS3ExpressControlEndpoint;
    }

    public Boolean disableS3ExpressSessionAuth() {
        return disableS3ExpressSessionAuth;
    }

    public List<String> deleteObjectKeys() {
        return deleteObjectKeys;
    }

    public Builder toBuilder() {
        return new BuilderImpl(this);
    }

    public interface Builder extends CopyableBuilder<Builder, S3EndpointParams> {
        Builder bucket(String bucket);

        Builder region(Region region);

        Builder useFips(Boolean useFIPS);

        Builder useDualStack(Boolean useDualStack);

        Builder endpoint(String endpoint);

        Builder forcePathStyle(Boolean forcePathStyle);

        Builder accelerate(Boolean accelerate);

        Builder useGlobalEndpoint(Boolean useGlobalEndpoint);

        Builder useObjectLambdaEndpoint(Boolean useObjectLambdaEndpoint);

        Builder key(String key);

        Builder prefix(String prefix);

        Builder copySource(String copySource);

        Builder disableAccessPoints(Boolean disableAccessPoints);

        Builder disableMultiRegionAccessPoints(Boolean disableMultiRegionAccessPoints);

        Builder useArnRegion(Boolean useArnRegion);

        Builder useS3ExpressControlEndpoint(Boolean useS3ExpressControlEndpoint);

        Builder disableS3ExpressSessionAuth(Boolean disableS3ExpressSessionAuth);

        Builder deleteObjectKeys(List<String> deleteObjectKeys);

        S3EndpointParams build();
    }

    private static class BuilderImpl implements Builder {
        private String bucket;

        private Region region;

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

        private BuilderImpl() {
        }

        private BuilderImpl(S3EndpointParams builder) {
            this.bucket = builder.bucket;
            this.region = builder.region;
            this.useFIPS = builder.useFIPS;
            this.useDualStack = builder.useDualStack;
            this.endpoint = builder.endpoint;
            this.forcePathStyle = builder.forcePathStyle;
            this.accelerate = builder.accelerate;
            this.useGlobalEndpoint = builder.useGlobalEndpoint;
            this.useObjectLambdaEndpoint = builder.useObjectLambdaEndpoint;
            this.key = builder.key;
            this.prefix = builder.prefix;
            this.copySource = builder.copySource;
            this.disableAccessPoints = builder.disableAccessPoints;
            this.disableMultiRegionAccessPoints = builder.disableMultiRegionAccessPoints;
            this.useArnRegion = builder.useArnRegion;
            this.useS3ExpressControlEndpoint = builder.useS3ExpressControlEndpoint;
            this.disableS3ExpressSessionAuth = builder.disableS3ExpressSessionAuth;
            this.deleteObjectKeys = builder.deleteObjectKeys;
        }

        @Override
        public Builder bucket(String bucket) {
            this.bucket = bucket;
            return this;
        }

        @Override
        public Builder region(Region region) {
            this.region = region;
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
        public S3EndpointParams build() {
            return new S3EndpointParams(this);
        }
    }
}
