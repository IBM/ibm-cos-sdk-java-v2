/*
 * Copyright 2025 IBM Corp. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */

package com.ibm.cos.v2.services.s3.model;

import com.ibm.cos.v2.annotations.Mutable;
import com.ibm.cos.v2.annotations.NotThreadSafe;
import com.ibm.cos.v2.core.SdkField;
import com.ibm.cos.v2.core.SdkPojo;
import com.ibm.cos.v2.core.protocol.MarshallLocation;
import com.ibm.cos.v2.core.protocol.MarshallingType;
import com.ibm.cos.v2.core.traits.LocationTrait;
import com.ibm.cos.v2.core.traits.RequiredTrait;
import com.ibm.cos.v2.utils.ToString;
import com.ibm.cos.v2.utils.builder.CopyableBuilder;
import com.ibm.cos.v2.utils.builder.ToCopyableBuilder;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.function.Function;

public class ContentList extends S3Request
    implements SdkPojo, ToCopyableBuilder<ContentList.Builder, ContentList> {

    private static final SdkField<ObjectSyncAttempted> OBJECT_SYNC_ATTEMPTED_FIELD = SdkField
        .<ObjectSyncAttempted>builder(MarshallingType.SDK_POJO)
        .memberName("objectSyncAttempted")
        .getter(getter(ContentList::objectSyncAttempted))
        .setter(setter(ContentList.Builder::objectSyncAttempted))
        .constructor(ObjectSyncAttempted::builder)
        .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("objectSyncAttempted")
                             .unmarshallLocationName("objectSyncAttempted").build(), RequiredTrait.create()).build();

    private static final List<SdkField<?>> SDK_FIELDS = Collections.unmodifiableList(Arrays.asList(OBJECT_SYNC_ATTEMPTED_FIELD));

    private final ObjectSyncAttempted objectSyncAttempted;

    private ContentList(BuilderImpl builder) {
        super(builder);
        this.objectSyncAttempted = builder.objectSyncAttempted;
    }

    private static <T> Function<Object, T> getter(Function<ContentList, T> g) {
        return obj -> g.apply((ContentList) obj);
    }

    private static <T> BiConsumer<Object, T> setter(BiConsumer<ContentList.Builder, T> s) {
        return (obj, val) -> s.accept((ContentList.Builder) obj, val);
    }

    @Override
    public Builder toBuilder() {
        return new BuilderImpl(this);
    }

    public static Builder builder() {
        return new BuilderImpl();
    }

    public static Class<? extends Builder> serializableBuilderClass() {
        return BuilderImpl.class;
    }

    @Override
    public final int hashCode() {
        int hashCode = 1;
        hashCode = 31 * hashCode + super.hashCode();
        hashCode = 31 * hashCode + Objects.hashCode(objectSyncAttempted());
        return hashCode;
    }

    @Override
    public final boolean equals(Object obj) {
        return super.equals(obj) && equalsBySdkFields(obj);
    }

    @Override
    public final boolean equalsBySdkFields(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof ContentList)) {
            return false;
        }
        ContentList other = (ContentList) obj;
        return Objects.equals(objectSyncAttempted(), other.objectSyncAttempted());
    }

    /**
     * Returns a string representation of this object. This is useful for testing and debugging. Sensitive data will be
     * redacted from this string using a placeholder value.
     */
    @Override
    public final String toString() {
        return ToString.builder("ContentList")
                       .add("objectSyncAttempted",objectSyncAttempted())
                       .build();

    }

    public final <T> Optional<T> getValueForField(String fieldName, Class<T> clazz) {
        switch (fieldName) {
            case "objectSyncAttempted":
                return Optional.ofNullable(clazz.cast(objectSyncAttempted()));
            default:
                return Optional.empty();
        }
    }

    @Override
    public List<SdkField<?>> sdkFields() {
        return SDK_FIELDS;
    }


    @Mutable
    @NotThreadSafe
    public interface Builder extends S3Request.Builder, SdkPojo, CopyableBuilder<ContentList.Builder, ContentList> {

        Builder objectSyncAttempted(ObjectSyncAttempted objectSyncAttemptedName);

    }

    static private final class BuilderImpl extends S3Request.BuilderImpl implements ContentList.Builder {

        private ObjectSyncAttempted objectSyncAttempted;

        private BuilderImpl(){}

        private BuilderImpl(ContentList model) {
            super(model);
            objectSyncAttempted(model.objectSyncAttempted);
        }

        public ObjectSyncAttempted getObjectSyncAttempted() { return  objectSyncAttempted;}

        public void setObjectSyncAttempted(ObjectSyncAttempted objectSyncAttempted) { this.objectSyncAttempted = objectSyncAttempted;}

        @Override
        public ContentList.Builder objectSyncAttempted(ObjectSyncAttempted objectSyncAttemptedName){
            this.objectSyncAttempted = objectSyncAttemptedName;
            return this;
        }

        @Override
        public List<SdkField<?>> sdkFields() {
            return SDK_FIELDS;
        }

        @Override
        public ContentList build() {
            return new ContentList(this);
        }
    }

    public ObjectSyncAttempted objectSyncAttempted() {
        return objectSyncAttempted;
    }

}
