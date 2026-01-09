/*
 * (C) Copyright 2018 IBM Corp. All Rights Reserved.
 */
package com.ibm.cos.v2.services.s3.model;

import com.ibm.cos.v2.annotations.Mutable;
import com.ibm.cos.v2.annotations.NotThreadSafe;
import com.ibm.cos.v2.core.SdkField;
import com.ibm.cos.v2.core.SdkPojo;
import com.ibm.cos.v2.utils.builder.CopyableBuilder;
import com.ibm.cos.v2.utils.builder.ToCopyableBuilder;
import java.util.Collections;
import java.util.List;

/**
 * A response class representing void response
 * <p>
 * This operation returns no meaningful payload; hence this response
 * holds no data.
 * </p>
 */
public class VoidHttpResponse extends S3Response implements
                                                     ToCopyableBuilder<VoidHttpResponse.Builder, VoidHttpResponse> {

    /**
     * Since this operation returns no meaningful payload, this list is empty.
     */
    private static final List<SdkField<?>> SDK_FIELDS = Collections.emptyList();

    private VoidHttpResponse(Builder builder) {
        super(builder);
        // Private constructor for immutability
    }

    public static Builder builder() {
        return new BuilderImpl();
    }

    @Override
    public List<SdkField<?>> sdkFields() {
        return SDK_FIELDS;
    }

    @Override
    public Builder toBuilder() {
        return new BuilderImpl();
    }

    @Mutable
    @NotThreadSafe
    public interface Builder extends S3Response.Builder, SdkPojo,
                                     CopyableBuilder<VoidHttpResponse.Builder, VoidHttpResponse> {

    }

    static final class BuilderImpl extends S3Response.BuilderImpl implements VoidHttpResponse.Builder {

        private BuilderImpl() {
        }

        @Override
        public List<SdkField<?>> sdkFields() {
            return SDK_FIELDS;
        }

        @Override
        public VoidHttpResponse build() {
            return new VoidHttpResponse(this);
        }
    }

}
