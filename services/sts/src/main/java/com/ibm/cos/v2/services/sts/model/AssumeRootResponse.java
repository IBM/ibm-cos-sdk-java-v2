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

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
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
 */
@Generated("com.ibm.cos.v2:codegen")
public final class AssumeRootResponse extends StsResponse implements
        ToCopyableBuilder<AssumeRootResponse.Builder, AssumeRootResponse> {
    private static final SdkField<Credentials> CREDENTIALS_FIELD = SdkField.<Credentials> builder(MarshallingType.SDK_POJO)
            .memberName("Credentials").getter(getter(AssumeRootResponse::credentials)).setter(setter(Builder::credentials))
            .constructor(Credentials::builder)
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("Credentials").build()).build();

    private static final SdkField<String> SOURCE_IDENTITY_FIELD = SdkField.<String> builder(MarshallingType.STRING)
            .memberName("SourceIdentity").getter(getter(AssumeRootResponse::sourceIdentity))
            .setter(setter(Builder::sourceIdentity))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("SourceIdentity").build()).build();

    private static final List<SdkField<?>> SDK_FIELDS = Collections.unmodifiableList(Arrays.asList(CREDENTIALS_FIELD,
            SOURCE_IDENTITY_FIELD));

    private static final Map<String, SdkField<?>> SDK_NAME_TO_FIELD = memberNameToFieldInitializer();

    private final Credentials credentials;

    private final String sourceIdentity;

    private AssumeRootResponse(BuilderImpl builder) {
        super(builder);
        this.credentials = builder.credentials;
        this.sourceIdentity = builder.sourceIdentity;
    }

    /**
     * <p>
     * The temporary security credentials, which include an access key ID, a secret access key, and a security token.
     * </p>
     * <note>
     * <p>
     * The size of the security token that STS API operations return is not fixed. We strongly recommend that you make
     * no assumptions about the maximum size.
     * </p>
     * </note>
     * 
     * @return The temporary security credentials, which include an access key ID, a secret access key, and a security
     *         token.</p> <note>
     *         <p>
     *         The size of the security token that STS API operations return is not fixed. We strongly recommend that
     *         you make no assumptions about the maximum size.
     *         </p>
     */
    public final Credentials credentials() {
        return credentials;
    }

    /**
     * <p>
     * The source identity specified by the principal that is calling the <code>AssumeRoot</code> operation.
     * </p>
     * <p>
     * You can use the <code>aws:SourceIdentity</code> condition key to control access based on the value of source
     * identity. For more information about using source identity, see <a
     * href="https://docs.aws.amazon.com/IAM/latest/UserGuide/id_credentials_temp_control-access_monitor.html">Monitor
     * and control actions taken with assumed roles</a> in the <i>IAM User Guide</i>.
     * </p>
     * <p>
     * The regex used to validate this parameter is a string of characters consisting of upper- and lower-case
     * alphanumeric characters with no spaces. You can also include underscores or any of the following characters: =,.@-
     * </p>
     * 
     * @return The source identity specified by the principal that is calling the <code>AssumeRoot</code> operation.</p>
     *         <p>
     *         You can use the <code>aws:SourceIdentity</code> condition key to control access based on the value of
     *         source identity. For more information about using source identity, see <a
     *         href="https://docs.aws.amazon.com/IAM/latest/UserGuide/id_credentials_temp_control-access_monitor.html"
     *         >Monitor and control actions taken with assumed roles</a> in the <i>IAM User Guide</i>.
     *         </p>
     *         <p>
     *         The regex used to validate this parameter is a string of characters consisting of upper- and lower-case
     *         alphanumeric characters with no spaces. You can also include underscores or any of the following
     *         characters: =,.@-
     */
    public final String sourceIdentity() {
        return sourceIdentity;
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
        hashCode = 31 * hashCode + Objects.hashCode(credentials());
        hashCode = 31 * hashCode + Objects.hashCode(sourceIdentity());
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
        if (!(obj instanceof AssumeRootResponse)) {
            return false;
        }
        AssumeRootResponse other = (AssumeRootResponse) obj;
        return Objects.equals(credentials(), other.credentials()) && Objects.equals(sourceIdentity(), other.sourceIdentity());
    }

    /**
     * Returns a string representation of this object. This is useful for testing and debugging. Sensitive data will be
     * redacted from this string using a placeholder value.
     */
    @Override
    public final String toString() {
        return ToString.builder("AssumeRootResponse").add("Credentials", credentials()).add("SourceIdentity", sourceIdentity())
                .build();
    }

    public final <T> Optional<T> getValueForField(String fieldName, Class<T> clazz) {
        switch (fieldName) {
        case "Credentials":
            return Optional.ofNullable(clazz.cast(credentials()));
        case "SourceIdentity":
            return Optional.ofNullable(clazz.cast(sourceIdentity()));
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
        map.put("Credentials", CREDENTIALS_FIELD);
        map.put("SourceIdentity", SOURCE_IDENTITY_FIELD);
        return Collections.unmodifiableMap(map);
    }

    private static <T> Function<Object, T> getter(Function<AssumeRootResponse, T> g) {
        return obj -> g.apply((AssumeRootResponse) obj);
    }

    private static <T> BiConsumer<Object, T> setter(BiConsumer<Builder, T> s) {
        return (obj, val) -> s.accept((Builder) obj, val);
    }

    @Mutable
    @NotThreadSafe
    public interface Builder extends StsResponse.Builder, SdkPojo, CopyableBuilder<Builder, AssumeRootResponse> {
        /**
         * <p>
         * The temporary security credentials, which include an access key ID, a secret access key, and a security
         * token.
         * </p>
         * <note>
         * <p>
         * The size of the security token that STS API operations return is not fixed. We strongly recommend that you
         * make no assumptions about the maximum size.
         * </p>
         * </note>
         * 
         * @param credentials
         *        The temporary security credentials, which include an access key ID, a secret access key, and a
         *        security token.</p> <note>
         *        <p>
         *        The size of the security token that STS API operations return is not fixed. We strongly recommend that
         *        you make no assumptions about the maximum size.
         *        </p>
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder credentials(Credentials credentials);

        /**
         * <p>
         * The temporary security credentials, which include an access key ID, a secret access key, and a security
         * token.
         * </p>
         * <note>
         * <p>
         * The size of the security token that STS API operations return is not fixed. We strongly recommend that you
         * make no assumptions about the maximum size.
         * </p>
         * </note> This is a convenience method that creates an instance of the {@link Credentials.Builder} avoiding the
         * need to create one manually via {@link Credentials#builder()}.
         *
         * <p>
         * When the {@link Consumer} completes, {@link Credentials.Builder#build()} is called immediately and its result
         * is passed to {@link #credentials(Credentials)}.
         * 
         * @param credentials
         *        a consumer that will call methods on {@link Credentials.Builder}
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see #credentials(Credentials)
         */
        default Builder credentials(Consumer<Credentials.Builder> credentials) {
            return credentials(Credentials.builder().applyMutation(credentials).build());
        }

        /**
         * <p>
         * The source identity specified by the principal that is calling the <code>AssumeRoot</code> operation.
         * </p>
         * <p>
         * You can use the <code>aws:SourceIdentity</code> condition key to control access based on the value of source
         * identity. For more information about using source identity, see <a
         * href="https://docs.aws.amazon.com/IAM/latest/UserGuide/id_credentials_temp_control-access_monitor.html"
         * >Monitor and control actions taken with assumed roles</a> in the <i>IAM User Guide</i>.
         * </p>
         * <p>
         * The regex used to validate this parameter is a string of characters consisting of upper- and lower-case
         * alphanumeric characters with no spaces. You can also include underscores or any of the following characters:
         * =,.@-
         * </p>
         * 
         * @param sourceIdentity
         *        The source identity specified by the principal that is calling the <code>AssumeRoot</code>
         *        operation.</p>
         *        <p>
         *        You can use the <code>aws:SourceIdentity</code> condition key to control access based on the value of
         *        source identity. For more information about using source identity, see <a href=
         *        "https://docs.aws.amazon.com/IAM/latest/UserGuide/id_credentials_temp_control-access_monitor.html"
         *        >Monitor and control actions taken with assumed roles</a> in the <i>IAM User Guide</i>.
         *        </p>
         *        <p>
         *        The regex used to validate this parameter is a string of characters consisting of upper- and
         *        lower-case alphanumeric characters with no spaces. You can also include underscores or any of the
         *        following characters: =,.@-
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder sourceIdentity(String sourceIdentity);
    }

    static final class BuilderImpl extends StsResponse.BuilderImpl implements Builder {
        private Credentials credentials;

        private String sourceIdentity;

        private BuilderImpl() {
        }

        private BuilderImpl(AssumeRootResponse model) {
            super(model);
            credentials(model.credentials);
            sourceIdentity(model.sourceIdentity);
        }

        public final Credentials.Builder getCredentials() {
            return credentials != null ? credentials.toBuilder() : null;
        }

        public final void setCredentials(Credentials.BuilderImpl credentials) {
            this.credentials = credentials != null ? credentials.build() : null;
        }

        @Override
        public final Builder credentials(Credentials credentials) {
            this.credentials = credentials;
            return this;
        }

        public final String getSourceIdentity() {
            return sourceIdentity;
        }

        public final void setSourceIdentity(String sourceIdentity) {
            this.sourceIdentity = sourceIdentity;
        }

        @Override
        public final Builder sourceIdentity(String sourceIdentity) {
            this.sourceIdentity = sourceIdentity;
            return this;
        }

        @Override
        public AssumeRootResponse build() {
            return new AssumeRootResponse(this);
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
