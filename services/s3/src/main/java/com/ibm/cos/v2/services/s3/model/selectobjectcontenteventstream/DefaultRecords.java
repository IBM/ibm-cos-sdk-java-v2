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
import com.ibm.cos.v2.services.s3.model.RecordsEvent;
import com.ibm.cos.v2.services.s3.model.SelectObjectContentEventStream;
import com.ibm.cos.v2.services.s3.model.SelectObjectContentResponseHandler;

/**
 * A specialization of {@code com.ibm.cos.v2.services.s3.model.RecordsEvent} that represents the
 * {@code SelectObjectContentEventStream$Records} event. Do not use this class directly. Instead, use the static builder
 * methods on {@link com.ibm.cos.v2.services.s3.model.SelectObjectContentEventStream}.
 */
@SdkInternalApi
@Generated("com.ibm.cos.v2:codegen")
public final class DefaultRecords extends RecordsEvent {
    private static final long serialVersionUID = 1L;

    DefaultRecords(BuilderImpl builderImpl) {
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
        visitor.visitRecords(this);
    }

    @Override
    public SelectObjectContentEventStream.EventType sdkEventType() {
        return SelectObjectContentEventStream.EventType.RECORDS;
    }

    public interface Builder extends RecordsEvent.Builder {
        @Override
        DefaultRecords build();
    }

    private static final class BuilderImpl extends RecordsEvent.BuilderImpl implements Builder {
        private BuilderImpl() {
        }

        private BuilderImpl(DefaultRecords event) {
            super(event);
        }

        @Override
        public DefaultRecords build() {
            return new DefaultRecords(this);
        }
    }
}
