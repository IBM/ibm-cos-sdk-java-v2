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
 */
@Generated("com.ibm.cos.v2:codegen")
public final class CreateGrantResponse extends KmsResponse implements
        ToCopyableBuilder<CreateGrantResponse.Builder, CreateGrantResponse> {
    private static final SdkField<String> GRANT_TOKEN_FIELD = SdkField.<String> builder(MarshallingType.STRING)
            .memberName("GrantToken").getter(getter(CreateGrantResponse::grantToken)).setter(setter(Builder::grantToken))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("GrantToken").build()).build();

    private static final SdkField<String> GRANT_ID_FIELD = SdkField.<String> builder(MarshallingType.STRING)
            .memberName("GrantId").getter(getter(CreateGrantResponse::grantId)).setter(setter(Builder::grantId))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("GrantId").build()).build();

    private static final List<SdkField<?>> SDK_FIELDS = Collections.unmodifiableList(Arrays.asList(GRANT_TOKEN_FIELD,
            GRANT_ID_FIELD));

    private static final Map<String, SdkField<?>> SDK_NAME_TO_FIELD = memberNameToFieldInitializer();

    private final String grantToken;

    private final String grantId;

    private CreateGrantResponse(BuilderImpl builder) {
        super(builder);
        this.grantToken = builder.grantToken;
        this.grantId = builder.grantId;
    }

    /**
     * <p>
     * The grant token.
     * </p>
     * <p>
     * Use a grant token when your permission to call this operation comes from a new grant that has not yet achieved
     * <i>eventual consistency</i>. For more information, see <a
     * href="https://docs.aws.amazon.com/kms/latest/developerguide/grants.html#grant_token">Grant token</a> and <a
     * href="https://docs.aws.amazon.com/kms/latest/developerguide/grant-manage.html#using-grant-token">Using a grant
     * token</a> in the <i>Key Management Service Developer Guide</i>.
     * </p>
     * 
     * @return The grant token.</p>
     *         <p>
     *         Use a grant token when your permission to call this operation comes from a new grant that has not yet
     *         achieved <i>eventual consistency</i>. For more information, see <a
     *         href="https://docs.aws.amazon.com/kms/latest/developerguide/grants.html#grant_token">Grant token</a> and
     *         <a href="https://docs.aws.amazon.com/kms/latest/developerguide/grant-manage.html#using-grant-token">Using
     *         a grant token</a> in the <i>Key Management Service Developer Guide</i>.
     */
    public final String grantToken() {
        return grantToken;
    }

    /**
     * <p>
     * The unique identifier for the grant.
     * </p>
     * <p>
     * You can use the <code>GrantId</code> in a <a>ListGrants</a>, <a>RetireGrant</a>, or <a>RevokeGrant</a> operation.
     * </p>
     * 
     * @return The unique identifier for the grant.</p>
     *         <p>
     *         You can use the <code>GrantId</code> in a <a>ListGrants</a>, <a>RetireGrant</a>, or <a>RevokeGrant</a>
     *         operation.
     */
    public final String grantId() {
        return grantId;
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
        hashCode = 31 * hashCode + Objects.hashCode(grantToken());
        hashCode = 31 * hashCode + Objects.hashCode(grantId());
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
        if (!(obj instanceof CreateGrantResponse)) {
            return false;
        }
        CreateGrantResponse other = (CreateGrantResponse) obj;
        return Objects.equals(grantToken(), other.grantToken()) && Objects.equals(grantId(), other.grantId());
    }

    /**
     * Returns a string representation of this object. This is useful for testing and debugging. Sensitive data will be
     * redacted from this string using a placeholder value.
     */
    @Override
    public final String toString() {
        return ToString.builder("CreateGrantResponse").add("GrantToken", grantToken()).add("GrantId", grantId()).build();
    }

    public final <T> Optional<T> getValueForField(String fieldName, Class<T> clazz) {
        switch (fieldName) {
        case "GrantToken":
            return Optional.ofNullable(clazz.cast(grantToken()));
        case "GrantId":
            return Optional.ofNullable(clazz.cast(grantId()));
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
        map.put("GrantToken", GRANT_TOKEN_FIELD);
        map.put("GrantId", GRANT_ID_FIELD);
        return Collections.unmodifiableMap(map);
    }

    private static <T> Function<Object, T> getter(Function<CreateGrantResponse, T> g) {
        return obj -> g.apply((CreateGrantResponse) obj);
    }

    private static <T> BiConsumer<Object, T> setter(BiConsumer<Builder, T> s) {
        return (obj, val) -> s.accept((Builder) obj, val);
    }

    @Mutable
    @NotThreadSafe
    public interface Builder extends KmsResponse.Builder, SdkPojo, CopyableBuilder<Builder, CreateGrantResponse> {
        /**
         * <p>
         * The grant token.
         * </p>
         * <p>
         * Use a grant token when your permission to call this operation comes from a new grant that has not yet
         * achieved <i>eventual consistency</i>. For more information, see <a
         * href="https://docs.aws.amazon.com/kms/latest/developerguide/grants.html#grant_token">Grant token</a> and <a
         * href="https://docs.aws.amazon.com/kms/latest/developerguide/grant-manage.html#using-grant-token">Using a
         * grant token</a> in the <i>Key Management Service Developer Guide</i>.
         * </p>
         * 
         * @param grantToken
         *        The grant token.</p>
         *        <p>
         *        Use a grant token when your permission to call this operation comes from a new grant that has not yet
         *        achieved <i>eventual consistency</i>. For more information, see <a
         *        href="https://docs.aws.amazon.com/kms/latest/developerguide/grants.html#grant_token">Grant token</a>
         *        and <a
         *        href="https://docs.aws.amazon.com/kms/latest/developerguide/grant-manage.html#using-grant-token">Using
         *        a grant token</a> in the <i>Key Management Service Developer Guide</i>.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder grantToken(String grantToken);

        /**
         * <p>
         * The unique identifier for the grant.
         * </p>
         * <p>
         * You can use the <code>GrantId</code> in a <a>ListGrants</a>, <a>RetireGrant</a>, or <a>RevokeGrant</a>
         * operation.
         * </p>
         * 
         * @param grantId
         *        The unique identifier for the grant.</p>
         *        <p>
         *        You can use the <code>GrantId</code> in a <a>ListGrants</a>, <a>RetireGrant</a>, or <a>RevokeGrant</a>
         *        operation.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder grantId(String grantId);
    }

    static final class BuilderImpl extends KmsResponse.BuilderImpl implements Builder {
        private String grantToken;

        private String grantId;

        private BuilderImpl() {
        }

        private BuilderImpl(CreateGrantResponse model) {
            super(model);
            grantToken(model.grantToken);
            grantId(model.grantId);
        }

        public final String getGrantToken() {
            return grantToken;
        }

        public final void setGrantToken(String grantToken) {
            this.grantToken = grantToken;
        }

        @Override
        public final Builder grantToken(String grantToken) {
            this.grantToken = grantToken;
            return this;
        }

        public final String getGrantId() {
            return grantId;
        }

        public final void setGrantId(String grantId) {
            this.grantId = grantId;
        }

        @Override
        public final Builder grantId(String grantId) {
            this.grantId = grantId;
            return this;
        }

        @Override
        public CreateGrantResponse build() {
            return new CreateGrantResponse(this);
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
