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

package com.ibm.cos.v2.services.s3.model.selectobjectcontenteventstream;

import com.ibm.cos.v2.annotations.Generated;
import com.ibm.cos.v2.annotations.SdkInternalApi;
import com.ibm.cos.v2.services.s3.model.EndEvent;
import com.ibm.cos.v2.services.s3.model.SelectObjectContentEventStream;
import com.ibm.cos.v2.services.s3.model.SelectObjectContentResponseHandler;

/**
 * A specialization of {@code com.ibm.cos.v2.services.s3.model.EndEvent} that represents the
 * {@code SelectObjectContentEventStream$End} event. Do not use this class directly. Instead, use the static builder
 * methods on {@link com.ibm.cos.v2.services.s3.model.SelectObjectContentEventStream}.
 */
@SdkInternalApi
@Generated("com.ibm.cos.v2:codegen")
public final class DefaultEnd extends EndEvent {
    private static final long serialVersionUID = 1L;

    DefaultEnd(BuilderImpl builderImpl) {
        super(builderImpl);
    }

    @Override
    public Builder toBuilder() {
        return new BuilderImpl(this);
    }

    public static Builder builder() {
        return new BuilderImpl();
    }

    @Override
    public void accept(SelectObjectContentResponseHandler.Visitor visitor) {
        visitor.visitEnd(this);
    }

    @Override
    public SelectObjectContentEventStream.EventType sdkEventType() {
        return SelectObjectContentEventStream.EventType.END;
    }

    public interface Builder extends EndEvent.Builder {
        @Override
        DefaultEnd build();
    }

    private static final class BuilderImpl extends EndEvent.BuilderImpl implements Builder {
        private BuilderImpl() {
        }

        private BuilderImpl(DefaultEnd event) {
            super(event);
        }

        @Override
        public DefaultEnd build() {
            return new DefaultEnd(this);
        }
    }
}
