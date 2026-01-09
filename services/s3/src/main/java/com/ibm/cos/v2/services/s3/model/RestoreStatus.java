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

package com.ibm.cos.v2.services.s3.model;

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
 * Specifies the restoration status of an object. Objects in certain storage classes must be restored before they can be
 * retrieved. For more information about these storage classes and how to work with archived objects, see <a
 * href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/archived-objects.html"> Working with archived objects</a>
 * in the <i>Amazon S3 User Guide</i>.
 * </p>
 * <note>
 * <p>
 * This functionality is not supported for directory buckets. Directory buckets only support
 * <code>EXPRESS_ONEZONE</code> (the S3 Express One Zone storage class) in Availability Zones and
 * <code>ONEZONE_IA</code> (the S3 One Zone-Infrequent Access storage class) in Dedicated Local Zones.
 * </p>
 * </note>
 */
@Generated("com.ibm.cos.v2:codegen")
public final class RestoreStatus implements SdkPojo, Serializable, ToCopyableBuilder<RestoreStatus.Builder, RestoreStatus> {
    private static final SdkField<Boolean> IS_RESTORE_IN_PROGRESS_FIELD = SdkField
            .<Boolean> builder(MarshallingType.BOOLEAN)
            .memberName("IsRestoreInProgress")
            .getter(getter(RestoreStatus::isRestoreInProgress))
            .setter(setter(Builder::isRestoreInProgress))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("IsRestoreInProgress")
                    .unmarshallLocationName("IsRestoreInProgress").build()).build();

    private static final SdkField<Instant> RESTORE_EXPIRY_DATE_FIELD = SdkField
            .<Instant> builder(MarshallingType.INSTANT)
            .memberName("RestoreExpiryDate")
            .getter(getter(RestoreStatus::restoreExpiryDate))
            .setter(setter(Builder::restoreExpiryDate))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("RestoreExpiryDate")
                    .unmarshallLocationName("RestoreExpiryDate").build()).build();

    private static final List<SdkField<?>> SDK_FIELDS = Collections.unmodifiableList(Arrays.asList(IS_RESTORE_IN_PROGRESS_FIELD,
            RESTORE_EXPIRY_DATE_FIELD));

    private static final Map<String, SdkField<?>> SDK_NAME_TO_FIELD = memberNameToFieldInitializer();

    private static final long serialVersionUID = 1L;

    private final Boolean isRestoreInProgress;

    private final Instant restoreExpiryDate;

    private RestoreStatus(BuilderImpl builder) {
        this.isRestoreInProgress = builder.isRestoreInProgress;
        this.restoreExpiryDate = builder.restoreExpiryDate;
    }

    /**
     * <p>
     * Specifies whether the object is currently being restored. If the object restoration is in progress, the header
     * returns the value <code>TRUE</code>. For example:
     * </p>
     * <p>
     * <code>x-amz-optional-object-attributes: IsRestoreInProgress="true"</code>
     * </p>
     * <p>
     * If the object restoration has completed, the header returns the value <code>FALSE</code>. For example:
     * </p>
     * <p>
     * <code>x-amz-optional-object-attributes: IsRestoreInProgress="false", RestoreExpiryDate="2012-12-21T00:00:00.000Z"</code>
     * </p>
     * <p>
     * If the object hasn't been restored, there is no header response.
     * </p>
     * 
     * @return Specifies whether the object is currently being restored. If the object restoration is in progress, the
     *         header returns the value <code>TRUE</code>. For example:</p>
     *         <p>
     *         <code>x-amz-optional-object-attributes: IsRestoreInProgress="true"</code>
     *         </p>
     *         <p>
     *         If the object restoration has completed, the header returns the value <code>FALSE</code>. For example:
     *         </p>
     *         <p>
     *         <code>x-amz-optional-object-attributes: IsRestoreInProgress="false", RestoreExpiryDate="2012-12-21T00:00:00.000Z"</code>
     *         </p>
     *         <p>
     *         If the object hasn't been restored, there is no header response.
     */
    public final Boolean isRestoreInProgress() {
        return isRestoreInProgress;
    }

    /**
     * <p>
     * Indicates when the restored copy will expire. This value is populated only if the object has already been
     * restored. For example:
     * </p>
     * <p>
     * <code>x-amz-optional-object-attributes: IsRestoreInProgress="false", RestoreExpiryDate="2012-12-21T00:00:00.000Z"</code>
     * </p>
     * 
     * @return Indicates when the restored copy will expire. This value is populated only if the object has already been
     *         restored. For example:</p>
     *         <p>
     *         <code>x-amz-optional-object-attributes: IsRestoreInProgress="false", RestoreExpiryDate="2012-12-21T00:00:00.000Z"</code>
     */
    public final Instant restoreExpiryDate() {
        return restoreExpiryDate;
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
        hashCode = 31 * hashCode + Objects.hashCode(isRestoreInProgress());
        hashCode = 31 * hashCode + Objects.hashCode(restoreExpiryDate());
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
        if (!(obj instanceof RestoreStatus)) {
            return false;
        }
        RestoreStatus other = (RestoreStatus) obj;
        return Objects.equals(isRestoreInProgress(), other.isRestoreInProgress())
                && Objects.equals(restoreExpiryDate(), other.restoreExpiryDate());
    }

    /**
     * Returns a string representation of this object. This is useful for testing and debugging. Sensitive data will be
     * redacted from this string using a placeholder value.
     */
    @Override
    public final String toString() {
        return ToString.builder("RestoreStatus").add("IsRestoreInProgress", isRestoreInProgress())
                .add("RestoreExpiryDate", restoreExpiryDate()).build();
    }

    public final <T> Optional<T> getValueForField(String fieldName, Class<T> clazz) {
        switch (fieldName) {
        case "IsRestoreInProgress":
            return Optional.ofNullable(clazz.cast(isRestoreInProgress()));
        case "RestoreExpiryDate":
            return Optional.ofNullable(clazz.cast(restoreExpiryDate()));
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
        map.put("IsRestoreInProgress", IS_RESTORE_IN_PROGRESS_FIELD);
        map.put("RestoreExpiryDate", RESTORE_EXPIRY_DATE_FIELD);
        return Collections.unmodifiableMap(map);
    }

    private static <T> Function<Object, T> getter(Function<RestoreStatus, T> g) {
        return obj -> g.apply((RestoreStatus) obj);
    }

    private static <T> BiConsumer<Object, T> setter(BiConsumer<Builder, T> s) {
        return (obj, val) -> s.accept((Builder) obj, val);
    }

    @Mutable
    @NotThreadSafe
    public interface Builder extends SdkPojo, CopyableBuilder<Builder, RestoreStatus> {
        /**
         * <p>
         * Specifies whether the object is currently being restored. If the object restoration is in progress, the
         * header returns the value <code>TRUE</code>. For example:
         * </p>
         * <p>
         * <code>x-amz-optional-object-attributes: IsRestoreInProgress="true"</code>
         * </p>
         * <p>
         * If the object restoration has completed, the header returns the value <code>FALSE</code>. For example:
         * </p>
         * <p>
         * <code>x-amz-optional-object-attributes: IsRestoreInProgress="false", RestoreExpiryDate="2012-12-21T00:00:00.000Z"</code>
         * </p>
         * <p>
         * If the object hasn't been restored, there is no header response.
         * </p>
         * 
         * @param isRestoreInProgress
         *        Specifies whether the object is currently being restored. If the object restoration is in progress,
         *        the header returns the value <code>TRUE</code>. For example:</p>
         *        <p>
         *        <code>x-amz-optional-object-attributes: IsRestoreInProgress="true"</code>
         *        </p>
         *        <p>
         *        If the object restoration has completed, the header returns the value <code>FALSE</code>. For example:
         *        </p>
         *        <p>
         *        <code>x-amz-optional-object-attributes: IsRestoreInProgress="false", RestoreExpiryDate="2012-12-21T00:00:00.000Z"</code>
         *        </p>
         *        <p>
         *        If the object hasn't been restored, there is no header response.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder isRestoreInProgress(Boolean isRestoreInProgress);

        /**
         * <p>
         * Indicates when the restored copy will expire. This value is populated only if the object has already been
         * restored. For example:
         * </p>
         * <p>
         * <code>x-amz-optional-object-attributes: IsRestoreInProgress="false", RestoreExpiryDate="2012-12-21T00:00:00.000Z"</code>
         * </p>
         * 
         * @param restoreExpiryDate
         *        Indicates when the restored copy will expire. This value is populated only if the object has already
         *        been restored. For example:</p>
         *        <p>
         *        <code>x-amz-optional-object-attributes: IsRestoreInProgress="false", RestoreExpiryDate="2012-12-21T00:00:00.000Z"</code>
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder restoreExpiryDate(Instant restoreExpiryDate);
    }

    static final class BuilderImpl implements Builder {
        private Boolean isRestoreInProgress;

        private Instant restoreExpiryDate;

        private BuilderImpl() {
        }

        private BuilderImpl(RestoreStatus model) {
            isRestoreInProgress(model.isRestoreInProgress);
            restoreExpiryDate(model.restoreExpiryDate);
        }

        public final Boolean getIsRestoreInProgress() {
            return isRestoreInProgress;
        }

        public final void setIsRestoreInProgress(Boolean isRestoreInProgress) {
            this.isRestoreInProgress = isRestoreInProgress;
        }

        @Override
        public final Builder isRestoreInProgress(Boolean isRestoreInProgress) {
            this.isRestoreInProgress = isRestoreInProgress;
            return this;
        }

        public final Instant getRestoreExpiryDate() {
            return restoreExpiryDate;
        }

        public final void setRestoreExpiryDate(Instant restoreExpiryDate) {
            this.restoreExpiryDate = restoreExpiryDate;
        }

        @Override
        public final Builder restoreExpiryDate(Instant restoreExpiryDate) {
            this.restoreExpiryDate = restoreExpiryDate;
            return this;
        }

        @Override
        public RestoreStatus build() {
            return new RestoreStatus(this);
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
