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

package com.ibm.cos.v2.services.sts.model;

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
 * Amazon Web Services credentials for API authentication.
 * </p>
 */
public final class Credentials implements SdkPojo, Serializable, ToCopyableBuilder<Credentials.Builder, Credentials> {
    private static final SdkField<String> ACCESS_KEY_ID_FIELD = SdkField.<String> builder(MarshallingType.STRING)
                                                                        .memberName("AccessKeyId").getter(getter(Credentials::accessKeyId)).setter(setter(Builder::accessKeyId))
                                                                        .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("AccessKeyId").build()).build();

    private static final SdkField<String> SECRET_ACCESS_KEY_FIELD = SdkField.<String> builder(MarshallingType.STRING)
                                                                            .memberName("SecretAccessKey").getter(getter(Credentials::secretAccessKey)).setter(setter(Builder::secretAccessKey))
                                                                            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("SecretAccessKey").build()).build();

    private static final SdkField<String> SESSION_TOKEN_FIELD = SdkField.<String> builder(MarshallingType.STRING)
                                                                        .memberName("SessionToken").getter(getter(Credentials::sessionToken)).setter(setter(Builder::sessionToken))
                                                                        .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("SessionToken").build()).build();

    private static final SdkField<Instant> EXPIRATION_FIELD = SdkField.<Instant> builder(MarshallingType.INSTANT)
                                                                      .memberName("Expiration").getter(getter(Credentials::expiration)).setter(setter(Builder::expiration))
                                                                      .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("Expiration").build()).build();

    private static final List<SdkField<?>> SDK_FIELDS = Collections.unmodifiableList(Arrays.asList(ACCESS_KEY_ID_FIELD,
                                                                                                   SECRET_ACCESS_KEY_FIELD, SESSION_TOKEN_FIELD, EXPIRATION_FIELD));

    private static final Map<String, SdkField<?>> SDK_NAME_TO_FIELD = memberNameToFieldInitializer();

    private static final long serialVersionUID = 1L;

    private final String accessKeyId;

    private final String secretAccessKey;

    private final String sessionToken;

    private final Instant expiration;

    private Credentials(BuilderImpl builder) {
        this.accessKeyId = builder.accessKeyId;
        this.secretAccessKey = builder.secretAccessKey;
        this.sessionToken = builder.sessionToken;
        this.expiration = builder.expiration;
    }

    /**
     * <p>
     * The access key ID that identifies the temporary security credentials.
     * </p>
     *
     * @return The access key ID that identifies the temporary security credentials.
     */
    public final String accessKeyId() {
        return accessKeyId;
    }

    /**
     * <p>
     * The secret access key that can be used to sign requests.
     * </p>
     *
     * @return The secret access key that can be used to sign requests.
     */
    public final String secretAccessKey() {
        return secretAccessKey;
    }

    /**
     * <p>
     * The token that users must pass to the service API to use the temporary credentials.
     * </p>
     *
     * @return The token that users must pass to the service API to use the temporary credentials.
     */
    public final String sessionToken() {
        return sessionToken;
    }

    /**
     * <p>
     * The date on which the current credentials expire.
     * </p>
     *
     * @return The date on which the current credentials expire.
     */
    public final Instant expiration() {
        return expiration;
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
        hashCode = 31 * hashCode + Objects.hashCode(accessKeyId());
        hashCode = 31 * hashCode + Objects.hashCode(secretAccessKey());
        hashCode = 31 * hashCode + Objects.hashCode(sessionToken());
        hashCode = 31 * hashCode + Objects.hashCode(expiration());
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
        if (!(obj instanceof Credentials)) {
            return false;
        }
        Credentials other = (Credentials) obj;
        return Objects.equals(accessKeyId(), other.accessKeyId()) && Objects.equals(secretAccessKey(), other.secretAccessKey())
               && Objects.equals(sessionToken(), other.sessionToken()) && Objects.equals(expiration(), other.expiration());
    }

    /**
     * Returns a string representation of this object. This is useful for testing and debugging. Sensitive data will be
     * redacted from this string using a placeholder value.
     */
    @Override
    public final String toString() {
        return ToString.builder("Credentials").add("AccessKeyId", accessKeyId())
                       .add("SecretAccessKey", secretAccessKey() == null ? null : "*** Sensitive Data Redacted ***")
                       .add("SessionToken", sessionToken()).add("Expiration", expiration()).build();
    }

    public final <T> Optional<T> getValueForField(String fieldName, Class<T> clazz) {
        switch (fieldName) {
            case "AccessKeyId":
                return Optional.ofNullable(clazz.cast(accessKeyId()));
            case "SecretAccessKey":
                return Optional.ofNullable(clazz.cast(secretAccessKey()));
            case "SessionToken":
                return Optional.ofNullable(clazz.cast(sessionToken()));
            case "Expiration":
                return Optional.ofNullable(clazz.cast(expiration()));
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
        map.put("AccessKeyId", ACCESS_KEY_ID_FIELD);
        map.put("SecretAccessKey", SECRET_ACCESS_KEY_FIELD);
        map.put("SessionToken", SESSION_TOKEN_FIELD);
        map.put("Expiration", EXPIRATION_FIELD);
        return Collections.unmodifiableMap(map);
    }

    private static <T> Function<Object, T> getter(Function<Credentials, T> g) {
        return obj -> g.apply((Credentials) obj);
    }

    private static <T> BiConsumer<Object, T> setter(BiConsumer<Builder, T> s) {
        return (obj, val) -> s.accept((Builder) obj, val);
    }

    @Mutable
    @NotThreadSafe
    public interface Builder extends SdkPojo, CopyableBuilder<Builder, Credentials> {
        /**
         * <p>
         * The access key ID that identifies the temporary security credentials.
         * </p>
         *
         * @param accessKeyId
         *        The access key ID that identifies the temporary security credentials.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder accessKeyId(String accessKeyId);

        /**
         * <p>
         * The secret access key that can be used to sign requests.
         * </p>
         *
         * @param secretAccessKey
         *        The secret access key that can be used to sign requests.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder secretAccessKey(String secretAccessKey);

        /**
         * <p>
         * The token that users must pass to the service API to use the temporary credentials.
         * </p>
         *
         * @param sessionToken
         *        The token that users must pass to the service API to use the temporary credentials.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder sessionToken(String sessionToken);

        /**
         * <p>
         * The date on which the current credentials expire.
         * </p>
         *
         * @param expiration
         *        The date on which the current credentials expire.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder expiration(Instant expiration);
    }

    static final class BuilderImpl implements Builder {
        private String accessKeyId;

        private String secretAccessKey;

        private String sessionToken;

        private Instant expiration;

        private BuilderImpl() {
        }

        private BuilderImpl(Credentials model) {
            accessKeyId(model.accessKeyId);
            secretAccessKey(model.secretAccessKey);
            sessionToken(model.sessionToken);
            expiration(model.expiration);
        }

        public final String getAccessKeyId() {
            return accessKeyId;
        }

        public final void setAccessKeyId(String accessKeyId) {
            this.accessKeyId = accessKeyId;
        }

        @Override
        public final Builder accessKeyId(String accessKeyId) {
            this.accessKeyId = accessKeyId;
            return this;
        }

        public final String getSecretAccessKey() {
            return secretAccessKey;
        }

        public final void setSecretAccessKey(String secretAccessKey) {
            this.secretAccessKey = secretAccessKey;
        }

        @Override
        public final Builder secretAccessKey(String secretAccessKey) {
            this.secretAccessKey = secretAccessKey;
            return this;
        }

        public final String getSessionToken() {
            return sessionToken;
        }

        public final void setSessionToken(String sessionToken) {
            this.sessionToken = sessionToken;
        }

        @Override
        public final Builder sessionToken(String sessionToken) {
            this.sessionToken = sessionToken;
            return this;
        }

        public final Instant getExpiration() {
            return expiration;
        }

        public final void setExpiration(Instant expiration) {
            this.expiration = expiration;
        }

        @Override
        public final Builder expiration(Instant expiration) {
            this.expiration = expiration;
            return this;
        }

        @Override
        public Credentials build() {
            return new Credentials(this);
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
