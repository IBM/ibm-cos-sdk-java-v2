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
import java.time.Instant;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.function.Function;

public class ObjectSyncAttempted extends S3Request
    implements SdkPojo, ToCopyableBuilder<ObjectSyncAttempted.Builder, ObjectSyncAttempted> {

    private static final SdkField<String> KEY_FIELD = SdkField
        .<String>builder(MarshallingType.STRING)
        .memberName("Key")
        .getter(getter(ObjectSyncAttempted::key))
        .setter(setter(ObjectSyncAttempted.Builder::key))
        .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("Key")
                             .unmarshallLocationName("Key").build()).build();

    private static final SdkField<String> VERSION_ID_FIELD = SdkField
        .<String>builder(MarshallingType.STRING)
        .memberName("VersionId")
        .getter(getter(ObjectSyncAttempted::versionId))
        .setter(setter(ObjectSyncAttempted.Builder::versionId))
        .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("VersionId")
                             .unmarshallLocationName("VersionId").build()).build();

    private static final SdkField<String> SYNC_TYPE_FIELD = SdkField
        .<String>builder(MarshallingType.STRING)
        .memberName("SyncType")
        .getter(getter(ObjectSyncAttempted::syncType))
        .setter(setter(ObjectSyncAttempted.Builder::syncType))
        .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("SyncType")
                             .unmarshallLocationName("SyncType").build()).build();

    private static final SdkField<Instant> FIRST_SYNC_ATTEMPTED_FIELD = SdkField
        .<Instant>builder(MarshallingType.INSTANT)
        .memberName("FirstSyncAttempted")
        .getter(getter(ObjectSyncAttempted::firstSyncAttempted))
        .setter(setter(ObjectSyncAttempted.Builder::firstSyncAttempted))
        .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("FirstSyncAttempted")
                             .unmarshallLocationName("FirstSyncAttempted").build()).build();

    private static final SdkField<Instant> LAST_SYNC_ATTEMPTED_FIELD = SdkField
        .<Instant>builder(MarshallingType.INSTANT)
        .memberName("LastSyncAttempted")
        .getter(getter(ObjectSyncAttempted::lastSyncAttempted))
        .setter(setter(ObjectSyncAttempted.Builder::lastSyncAttempted))
        .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("LastSyncAttempted")
                             .unmarshallLocationName("LastSyncAttempted").build()).build();

    private static final SdkField<String> SYNC_FAILURE_CAUSE_FIELD = SdkField
        .<String>builder(MarshallingType.STRING)
        .memberName("SyncFailureCause")
        .getter(getter(ObjectSyncAttempted::syncFailureCause))
        .setter(setter(ObjectSyncAttempted.Builder::syncFailureCause))
        .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("SyncFailureCause")
                             .unmarshallLocationName("SyncFailureCause").build()).build();



    private static final List<SdkField<?>> SDK_FIELDS = Collections.unmodifiableList(Arrays.asList(KEY_FIELD, VERSION_ID_FIELD,
     SYNC_TYPE_FIELD, FIRST_SYNC_ATTEMPTED_FIELD, LAST_SYNC_ATTEMPTED_FIELD, SYNC_FAILURE_CAUSE_FIELD));

    private final String key;
    /**
     * UUID of object version that has failed sync."
     */
    private final String versionId;

    /**
     * >The type of sync that has failed. This shall be either <code> content </code> , <code> metadata </code> or <code> objectLock </code>
     */
    private final String syncType;

    /**
     * Timestamp of last sync attempt from primary sync queue.
     */
    private final Instant firstSyncAttempted;

    /**
     * Timestamp of most recent sync attempt from failure sync queue.
     */
    private final Instant lastSyncAttempted;

    /**
     * Descriptive message regarding the cause of the most recent sync attempt failure.
     */
    private final String syncFailureCause;

    private ObjectSyncAttempted(BuilderImpl builder) {
        super(builder);
        this.key = builder.key;
        this.versionId = builder.versionId;
        this.syncType = builder.syncType;
        this.firstSyncAttempted = builder.firstSyncAttempted;
        this.lastSyncAttempted = builder.lastSyncAttempted;
        this.syncFailureCause = builder.syncFailureCause;
    }

    private static <T> Function<Object, T> getter(Function<ObjectSyncAttempted, T> g) {
        return obj -> g.apply((ObjectSyncAttempted) obj);
    }

    private static <T> BiConsumer<Object, T> setter(BiConsumer<ObjectSyncAttempted.Builder, T> s) {
        return (obj, val) -> s.accept((ObjectSyncAttempted.Builder) obj, val);
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
        hashCode = 31 * hashCode + Objects.hashCode(key());
        hashCode = 31 * hashCode + Objects.hashCode(versionId());
        hashCode = 31 * hashCode + Objects.hashCode(syncType());
        hashCode = 31 * hashCode + Objects.hashCode(firstSyncAttempted());
        hashCode = 31 * hashCode + Objects.hashCode(lastSyncAttempted());
        hashCode = 31 * hashCode + Objects.hashCode(syncFailureCause());
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
        if (!(obj instanceof ObjectSyncAttempted)) {
            return false;
        }
        ObjectSyncAttempted other = (ObjectSyncAttempted) obj;
        return Objects.equals(key(), other.key()) && Objects.equals(versionId(), other.versionId())
               && Objects.equals(syncType(), other.syncType()) && Objects.equals(firstSyncAttempted(), other.firstSyncAttempted())
               && Objects.equals(lastSyncAttempted(), other.lastSyncAttempted()) && Objects.equals(syncFailureCause(), other.syncFailureCause());
    }

    /**
     * Returns a string representation of this object. This is useful for testing and debugging. Sensitive data will be
     * redacted from this string using a placeholder value.
     */
    @Override
    public final String toString() {
        return ToString.builder("ObjectSyncAttempted")
                       .add("Key",key())
                       .add("VersionId",versionId())
                       .add("SyncType",syncType())
                       .add("FirstSyncAttempted",firstSyncAttempted())
                       .add("LastSyncAttempted",lastSyncAttempted())
                       .add("SyncFailureCause",syncFailureCause())
                       .build();

    }

    public final <T> Optional<T> getValueForField(String fieldName, Class<T> clazz) {
        switch (fieldName) {
            case "Key":
                return Optional.ofNullable(clazz.cast(key()));
            case "VersionId":
                return Optional.ofNullable(clazz.cast(versionId()));
            case "SyncType":
                return Optional.ofNullable(clazz.cast(syncType()));
            case "FirstSyncAttempted":
                return Optional.ofNullable(clazz.cast(firstSyncAttempted()));
            case "LastSyncAttempted":
                return Optional.ofNullable(clazz.cast(lastSyncAttempted()));
            case "SyncFailureCause":
                return Optional.ofNullable(clazz.cast(syncFailureCause()));
            default:
                return Optional.empty();
        }
    }

    @Override
    public List<SdkField<?>> sdkFields() {
        return SDK_FIELDS;
    }

    /**
     * Returns the key of Amazon S3 bucket.
     */
    public String key() {
        return key;
    }

    public String versionId() {
        return versionId;
    }

    public String syncType() {
        return syncType;
    }

    public Instant firstSyncAttempted() {
        return firstSyncAttempted;
    }


    public Instant lastSyncAttempted() {
        return lastSyncAttempted;
    }

    public String syncFailureCause() {
        return syncFailureCause;
    }

    @Mutable
    @NotThreadSafe
    public interface Builder extends S3Request.Builder, SdkPojo, CopyableBuilder<ObjectSyncAttempted.Builder, ObjectSyncAttempted> {

        Builder key(String key);

        Builder versionId(String versionId);

        Builder syncType(String syncType);

        Builder firstSyncAttempted(Instant firstSyncAttempted);

        Builder lastSyncAttempted(Instant lastSyncAttempted);

        Builder syncFailureCause(String syncFailureCause);

    }

    static private final class BuilderImpl extends S3Request.BuilderImpl implements ObjectSyncAttempted.Builder {

        private String key;

        private String versionId;

        private String syncType;

        private Instant firstSyncAttempted;

        private Instant lastSyncAttempted;

        private String syncFailureCause;

        private BuilderImpl(){}

        private BuilderImpl(ObjectSyncAttempted model) {
            super(model);
            key(model.key);
        }

        public String getKey() { return  key;}

        public void setKey(String key) { this.key = key;}

        @Override
        public Builder key(String key){
            this.key = key;
            return this;
        }

        public String getVersionId() {
            return versionId;
        }

        public void setVersionId(String versionId) {
            this.versionId = versionId;
        }

        @Override
        public Builder versionId(String versionId) {
            this.versionId = versionId;
            return this;
        }

        public String getSyncType() {
            return syncType;
        }

        public void setSyncType(String syncType) {
            this.syncType = syncType;
        }

        @Override
        public Builder syncType(String syncType) {
            this.syncType = syncType;
            return this;
        }

        public Instant getFirstSyncAttempted() {
            return firstSyncAttempted;
        }

        public void setFirstSyncAttempted(Instant firstSyncAttempted) {
            this.firstSyncAttempted = firstSyncAttempted;
        }

        @Override
        public Builder firstSyncAttempted(Instant firstSyncAttempted) {
            this.firstSyncAttempted = firstSyncAttempted;
            return this;
        }

        public Instant getLastSyncAttempted() {
            return lastSyncAttempted;
        }

        public void setLastSyncAttempted(Instant lastSyncAttempted) {
            this.lastSyncAttempted = lastSyncAttempted;
        }

        @Override
        public Builder lastSyncAttempted(Instant lastSyncAttempted) {
            this.lastSyncAttempted = lastSyncAttempted;
            return this;
        }

        public String getSyncFailureCause() {
            return syncFailureCause;
        }

        public void setSyncFailureCause(String syncFailureCause) {
            this.syncFailureCause = syncFailureCause;
        }

        @Override
        public Builder syncFailureCause(String syncFailureCause) {
            this.syncFailureCause = syncFailureCause;
            return this;
        }

        @Override
        public List<SdkField<?>> sdkFields() {
            return SDK_FIELDS;
        }

        @Override
        public ObjectSyncAttempted build() {
            return new ObjectSyncAttempted(this);
        }
    }


}
