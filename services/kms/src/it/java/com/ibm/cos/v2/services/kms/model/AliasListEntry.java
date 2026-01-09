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

package com.ibm.cos.v2.services.kms.model;

import java.io.Serializable;
import java.time.Instant;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.function.Function;
import com.ibm.cos.v2.annotations.Generated;
import com.ibm.cos.v2.annotations.Mutable;
import com.ibm.cos.v2.annotations.NotThreadSafe;
import com.ibm.cos.v2.core.SdkField;
import com.ibm.cos.v2.core.SdkPojo;
import com.ibm.cos.v2.core.protocol.MarshallLocation;
import com.ibm.cos.v2.core.protocol.MarshallingType;
import com.ibm.cos.v2.core.traits.LocationTrait;
import com.ibm.cos.v2.utils.ToString;
import com.ibm.cos.v2.utils.builder.CopyableBuilder;
import com.ibm.cos.v2.utils.builder.ToCopyableBuilder;

/**
 * <p>
 * Contains information about an alias.
 * </p>
 */
@Generated("com.ibm.cos.v2:codegen")
public final class AliasListEntry implements SdkPojo, Serializable, ToCopyableBuilder<AliasListEntry.Builder, AliasListEntry> {
    private static final SdkField<String> ALIAS_NAME_FIELD = SdkField.<String> builder(MarshallingType.STRING)
            .memberName("AliasName").getter(getter(AliasListEntry::aliasName)).setter(setter(Builder::aliasName))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("AliasName").build()).build();

    private static final SdkField<String> ALIAS_ARN_FIELD = SdkField.<String> builder(MarshallingType.STRING)
            .memberName("AliasArn").getter(getter(AliasListEntry::aliasArn)).setter(setter(Builder::aliasArn))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("AliasArn").build()).build();

    private static final SdkField<String> TARGET_KEY_ID_FIELD = SdkField.<String> builder(MarshallingType.STRING)
            .memberName("TargetKeyId").getter(getter(AliasListEntry::targetKeyId)).setter(setter(Builder::targetKeyId))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("TargetKeyId").build()).build();

    private static final SdkField<Instant> CREATION_DATE_FIELD = SdkField.<Instant> builder(MarshallingType.INSTANT)
            .memberName("CreationDate").getter(getter(AliasListEntry::creationDate)).setter(setter(Builder::creationDate))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("CreationDate").build()).build();

    private static final SdkField<Instant> LAST_UPDATED_DATE_FIELD = SdkField.<Instant> builder(MarshallingType.INSTANT)
            .memberName("LastUpdatedDate").getter(getter(AliasListEntry::lastUpdatedDate))
            .setter(setter(Builder::lastUpdatedDate))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("LastUpdatedDate").build()).build();

    private static final List<SdkField<?>> SDK_FIELDS = Collections.unmodifiableList(Arrays.asList(ALIAS_NAME_FIELD,
            ALIAS_ARN_FIELD, TARGET_KEY_ID_FIELD, CREATION_DATE_FIELD, LAST_UPDATED_DATE_FIELD));

    private static final Map<String, SdkField<?>> SDK_NAME_TO_FIELD = memberNameToFieldInitializer();

    private static final long serialVersionUID = 1L;

    private final String aliasName;

    private final String aliasArn;

    private final String targetKeyId;

    private final Instant creationDate;

    private final Instant lastUpdatedDate;

    private AliasListEntry(BuilderImpl builder) {
        this.aliasName = builder.aliasName;
        this.aliasArn = builder.aliasArn;
        this.targetKeyId = builder.targetKeyId;
        this.creationDate = builder.creationDate;
        this.lastUpdatedDate = builder.lastUpdatedDate;
    }

    /**
     * <p>
     * String that contains the alias. This value begins with <code>alias/</code>.
     * </p>
     * 
     * @return String that contains the alias. This value begins with <code>alias/</code>.
     */
    public final String aliasName() {
        return aliasName;
    }

    /**
     * <p>
     * String that contains the key ARN.
     * </p>
     * 
     * @return String that contains the key ARN.
     */
    public final String aliasArn() {
        return aliasArn;
    }

    /**
     * <p>
     * String that contains the key identifier of the KMS key associated with the alias.
     * </p>
     * 
     * @return String that contains the key identifier of the KMS key associated with the alias.
     */
    public final String targetKeyId() {
        return targetKeyId;
    }

    /**
     * <p>
     * Date and time that the alias was most recently created in the account and Region. Formatted as Unix time.
     * </p>
     * 
     * @return Date and time that the alias was most recently created in the account and Region. Formatted as Unix time.
     */
    public final Instant creationDate() {
        return creationDate;
    }

    /**
     * <p>
     * Date and time that the alias was most recently associated with a KMS key in the account and Region. Formatted as
     * Unix time.
     * </p>
     * 
     * @return Date and time that the alias was most recently associated with a KMS key in the account and Region.
     *         Formatted as Unix time.
     */
    public final Instant lastUpdatedDate() {
        return lastUpdatedDate;
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
        hashCode = 31 * hashCode + Objects.hashCode(aliasName());
        hashCode = 31 * hashCode + Objects.hashCode(aliasArn());
        hashCode = 31 * hashCode + Objects.hashCode(targetKeyId());
        hashCode = 31 * hashCode + Objects.hashCode(creationDate());
        hashCode = 31 * hashCode + Objects.hashCode(lastUpdatedDate());
        return hashCode;
    }

    @Override
    public final boolean equals(Object obj) {
        return equalsBySdkFields(obj);
    }

    @Override
    public final boolean equalsBySdkFields(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof AliasListEntry)) {
            return false;
        }
        AliasListEntry other = (AliasListEntry) obj;
        return Objects.equals(aliasName(), other.aliasName()) && Objects.equals(aliasArn(), other.aliasArn())
                && Objects.equals(targetKeyId(), other.targetKeyId()) && Objects.equals(creationDate(), other.creationDate())
                && Objects.equals(lastUpdatedDate(), other.lastUpdatedDate());
    }

    /**
     * Returns a string representation of this object. This is useful for testing and debugging. Sensitive data will be
     * redacted from this string using a placeholder value.
     */
    @Override
    public final String toString() {
        return ToString.builder("AliasListEntry").add("AliasName", aliasName()).add("AliasArn", aliasArn())
                .add("TargetKeyId", targetKeyId()).add("CreationDate", creationDate()).add("LastUpdatedDate", lastUpdatedDate())
                .build();
    }

    public final <T> Optional<T> getValueForField(String fieldName, Class<T> clazz) {
        switch (fieldName) {
        case "AliasName":
            return Optional.ofNullable(clazz.cast(aliasName()));
        case "AliasArn":
            return Optional.ofNullable(clazz.cast(aliasArn()));
        case "TargetKeyId":
            return Optional.ofNullable(clazz.cast(targetKeyId()));
        case "CreationDate":
            return Optional.ofNullable(clazz.cast(creationDate()));
        case "LastUpdatedDate":
            return Optional.ofNullable(clazz.cast(lastUpdatedDate()));
        default:
            return Optional.empty();
        }
    }

    @Override
    public final List<SdkField<?>> sdkFields() {
        return SDK_FIELDS;
    }

    @Override
    public final Map<String, SdkField<?>> sdkFieldNameToField() {
        return SDK_NAME_TO_FIELD;
    }

    private static Map<String, SdkField<?>> memberNameToFieldInitializer() {
        Map<String, SdkField<?>> map = new HashMap<>();
        map.put("AliasName", ALIAS_NAME_FIELD);
        map.put("AliasArn", ALIAS_ARN_FIELD);
        map.put("TargetKeyId", TARGET_KEY_ID_FIELD);
        map.put("CreationDate", CREATION_DATE_FIELD);
        map.put("LastUpdatedDate", LAST_UPDATED_DATE_FIELD);
        return Collections.unmodifiableMap(map);
    }

    private static <T> Function<Object, T> getter(Function<AliasListEntry, T> g) {
        return obj -> g.apply((AliasListEntry) obj);
    }

    private static <T> BiConsumer<Object, T> setter(BiConsumer<Builder, T> s) {
        return (obj, val) -> s.accept((Builder) obj, val);
    }

    @Mutable
    @NotThreadSafe
    public interface Builder extends SdkPojo, CopyableBuilder<Builder, AliasListEntry> {
        /**
         * <p>
         * String that contains the alias. This value begins with <code>alias/</code>.
         * </p>
         * 
         * @param aliasName
         *        String that contains the alias. This value begins with <code>alias/</code>.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder aliasName(String aliasName);

        /**
         * <p>
         * String that contains the key ARN.
         * </p>
         * 
         * @param aliasArn
         *        String that contains the key ARN.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder aliasArn(String aliasArn);

        /**
         * <p>
         * String that contains the key identifier of the KMS key associated with the alias.
         * </p>
         * 
         * @param targetKeyId
         *        String that contains the key identifier of the KMS key associated with the alias.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder targetKeyId(String targetKeyId);

        /**
         * <p>
         * Date and time that the alias was most recently created in the account and Region. Formatted as Unix time.
         * </p>
         * 
         * @param creationDate
         *        Date and time that the alias was most recently created in the account and Region. Formatted as Unix
         *        time.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder creationDate(Instant creationDate);

        /**
         * <p>
         * Date and time that the alias was most recently associated with a KMS key in the account and Region. Formatted
         * as Unix time.
         * </p>
         * 
         * @param lastUpdatedDate
         *        Date and time that the alias was most recently associated with a KMS key in the account and Region.
         *        Formatted as Unix time.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder lastUpdatedDate(Instant lastUpdatedDate);
    }

    static final class BuilderImpl implements Builder {
        private String aliasName;

        private String aliasArn;

        private String targetKeyId;

        private Instant creationDate;

        private Instant lastUpdatedDate;

        private BuilderImpl() {
        }

        private BuilderImpl(AliasListEntry model) {
            aliasName(model.aliasName);
            aliasArn(model.aliasArn);
            targetKeyId(model.targetKeyId);
            creationDate(model.creationDate);
            lastUpdatedDate(model.lastUpdatedDate);
        }

        public final String getAliasName() {
            return aliasName;
        }

        public final void setAliasName(String aliasName) {
            this.aliasName = aliasName;
        }

        @Override
        public final Builder aliasName(String aliasName) {
            this.aliasName = aliasName;
            return this;
        }

        public final String getAliasArn() {
            return aliasArn;
        }

        public final void setAliasArn(String aliasArn) {
            this.aliasArn = aliasArn;
        }

        @Override
        public final Builder aliasArn(String aliasArn) {
            this.aliasArn = aliasArn;
            return this;
        }

        public final String getTargetKeyId() {
            return targetKeyId;
        }

        public final void setTargetKeyId(String targetKeyId) {
            this.targetKeyId = targetKeyId;
        }

        @Override
        public final Builder targetKeyId(String targetKeyId) {
            this.targetKeyId = targetKeyId;
            return this;
        }

        public final Instant getCreationDate() {
            return creationDate;
        }

        public final void setCreationDate(Instant creationDate) {
            this.creationDate = creationDate;
        }

        @Override
        public final Builder creationDate(Instant creationDate) {
            this.creationDate = creationDate;
            return this;
        }

        public final Instant getLastUpdatedDate() {
            return lastUpdatedDate;
        }

        public final void setLastUpdatedDate(Instant lastUpdatedDate) {
            this.lastUpdatedDate = lastUpdatedDate;
        }

        @Override
        public final Builder lastUpdatedDate(Instant lastUpdatedDate) {
            this.lastUpdatedDate = lastUpdatedDate;
            return this;
        }

        @Override
        public AliasListEntry build() {
            return new AliasListEntry(this);
        }

        @Override
        public List<SdkField<?>> sdkFields() {
            return SDK_FIELDS;
        }

        @Override
        public Map<String, SdkField<?>> sdkFieldNameToField() {
            return SDK_NAME_TO_FIELD;
        }
    }
}
