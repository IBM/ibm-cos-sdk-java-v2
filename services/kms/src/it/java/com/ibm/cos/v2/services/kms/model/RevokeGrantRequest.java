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
import java.util.function.Consumer;
import java.util.function.Function;
import com.ibm.cos.v2.annotations.Generated;
import com.ibm.cos.v2.annotations.Mutable;
import com.ibm.cos.v2.annotations.NotThreadSafe;
import com.ibm.cos.v2.awscore.AwsRequestOverrideConfiguration;
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
public final class RevokeGrantRequest extends KmsRequest implements
        ToCopyableBuilder<RevokeGrantRequest.Builder, RevokeGrantRequest> {
    private static final SdkField<String> KEY_ID_FIELD = SdkField.<String> builder(MarshallingType.STRING).memberName("KeyId")
            .getter(getter(RevokeGrantRequest::keyId)).setter(setter(Builder::keyId))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("KeyId").build()).build();

    private static final SdkField<String> GRANT_ID_FIELD = SdkField.<String> builder(MarshallingType.STRING)
            .memberName("GrantId").getter(getter(RevokeGrantRequest::grantId)).setter(setter(Builder::grantId))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("GrantId").build()).build();

    private static final SdkField<Boolean> DRY_RUN_FIELD = SdkField.<Boolean> builder(MarshallingType.BOOLEAN)
            .memberName("DryRun").getter(getter(RevokeGrantRequest::dryRun)).setter(setter(Builder::dryRun))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("DryRun").build()).build();

    private static final List<SdkField<?>> SDK_FIELDS = Collections.unmodifiableList(Arrays.asList(KEY_ID_FIELD, GRANT_ID_FIELD,
            DRY_RUN_FIELD));

    private static final Map<String, SdkField<?>> SDK_NAME_TO_FIELD = memberNameToFieldInitializer();

    private final String keyId;

    private final String grantId;

    private final Boolean dryRun;

    private RevokeGrantRequest(BuilderImpl builder) {
        super(builder);
        this.keyId = builder.keyId;
        this.grantId = builder.grantId;
        this.dryRun = builder.dryRun;
    }

    /**
     * <p>
     * A unique identifier for the KMS key associated with the grant. To get the key ID and key ARN for a KMS key, use
     * <a>ListKeys</a> or <a>DescribeKey</a>.
     * </p>
     * <p>
     * Specify the key ID or key ARN of the KMS key. To specify a KMS key in a different Amazon Web Services account,
     * you must use the key ARN.
     * </p>
     * <p>
     * For example:
     * </p>
     * <ul>
     * <li>
     * <p>
     * Key ID: <code>1234abcd-12ab-34cd-56ef-1234567890ab</code>
     * </p>
     * </li>
     * <li>
     * <p>
     * Key ARN: <code>arn:aws:kms:us-east-2:111122223333:key/1234abcd-12ab-34cd-56ef-1234567890ab</code>
     * </p>
     * </li>
     * </ul>
     * <p>
     * To get the key ID and key ARN for a KMS key, use <a>ListKeys</a> or <a>DescribeKey</a>.
     * </p>
     * 
     * @return A unique identifier for the KMS key associated with the grant. To get the key ID and key ARN for a KMS
     *         key, use <a>ListKeys</a> or <a>DescribeKey</a>.</p>
     *         <p>
     *         Specify the key ID or key ARN of the KMS key. To specify a KMS key in a different Amazon Web Services
     *         account, you must use the key ARN.
     *         </p>
     *         <p>
     *         For example:
     *         </p>
     *         <ul>
     *         <li>
     *         <p>
     *         Key ID: <code>1234abcd-12ab-34cd-56ef-1234567890ab</code>
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         Key ARN: <code>arn:aws:kms:us-east-2:111122223333:key/1234abcd-12ab-34cd-56ef-1234567890ab</code>
     *         </p>
     *         </li>
     *         </ul>
     *         <p>
     *         To get the key ID and key ARN for a KMS key, use <a>ListKeys</a> or <a>DescribeKey</a>.
     */
    public final String keyId() {
        return keyId;
    }

    /**
     * <p>
     * Identifies the grant to revoke. To get the grant ID, use <a>CreateGrant</a>, <a>ListGrants</a>, or
     * <a>ListRetirableGrants</a>.
     * </p>
     * 
     * @return Identifies the grant to revoke. To get the grant ID, use <a>CreateGrant</a>, <a>ListGrants</a>, or
     *         <a>ListRetirableGrants</a>.
     */
    public final String grantId() {
        return grantId;
    }

    /**
     * <p>
     * Checks if your request will succeed. <code>DryRun</code> is an optional parameter.
     * </p>
     * <p>
     * To learn more about how to use this parameter, see <a
     * href="https://docs.aws.amazon.com/kms/latest/developerguide/programming-dryrun.html">Testing your KMS API
     * calls</a> in the <i>Key Management Service Developer Guide</i>.
     * </p>
     * 
     * @return Checks if your request will succeed. <code>DryRun</code> is an optional parameter. </p>
     *         <p>
     *         To learn more about how to use this parameter, see <a
     *         href="https://docs.aws.amazon.com/kms/latest/developerguide/programming-dryrun.html">Testing your KMS API
     *         calls</a> in the <i>Key Management Service Developer Guide</i>.
     */
    public final Boolean dryRun() {
        return dryRun;
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
        hashCode = 31 * hashCode + Objects.hashCode(keyId());
        hashCode = 31 * hashCode + Objects.hashCode(grantId());
        hashCode = 31 * hashCode + Objects.hashCode(dryRun());
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
        if (!(obj instanceof RevokeGrantRequest)) {
            return false;
        }
        RevokeGrantRequest other = (RevokeGrantRequest) obj;
        return Objects.equals(keyId(), other.keyId()) && Objects.equals(grantId(), other.grantId())
                && Objects.equals(dryRun(), other.dryRun());
    }

    /**
     * Returns a string representation of this object. This is useful for testing and debugging. Sensitive data will be
     * redacted from this string using a placeholder value.
     */
    @Override
    public final String toString() {
        return ToString.builder("RevokeGrantRequest").add("KeyId", keyId()).add("GrantId", grantId()).add("DryRun", dryRun())
                .build();
    }

    public final <T> Optional<T> getValueForField(String fieldName, Class<T> clazz) {
        switch (fieldName) {
        case "KeyId":
            return Optional.ofNullable(clazz.cast(keyId()));
        case "GrantId":
            return Optional.ofNullable(clazz.cast(grantId()));
        case "DryRun":
            return Optional.ofNullable(clazz.cast(dryRun()));
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
        map.put("KeyId", KEY_ID_FIELD);
        map.put("GrantId", GRANT_ID_FIELD);
        map.put("DryRun", DRY_RUN_FIELD);
        return Collections.unmodifiableMap(map);
    }

    private static <T> Function<Object, T> getter(Function<RevokeGrantRequest, T> g) {
        return obj -> g.apply((RevokeGrantRequest) obj);
    }

    private static <T> BiConsumer<Object, T> setter(BiConsumer<Builder, T> s) {
        return (obj, val) -> s.accept((Builder) obj, val);
    }

    @Mutable
    @NotThreadSafe
    public interface Builder extends KmsRequest.Builder, SdkPojo, CopyableBuilder<Builder, RevokeGrantRequest> {
        /**
         * <p>
         * A unique identifier for the KMS key associated with the grant. To get the key ID and key ARN for a KMS key,
         * use <a>ListKeys</a> or <a>DescribeKey</a>.
         * </p>
         * <p>
         * Specify the key ID or key ARN of the KMS key. To specify a KMS key in a different Amazon Web Services
         * account, you must use the key ARN.
         * </p>
         * <p>
         * For example:
         * </p>
         * <ul>
         * <li>
         * <p>
         * Key ID: <code>1234abcd-12ab-34cd-56ef-1234567890ab</code>
         * </p>
         * </li>
         * <li>
         * <p>
         * Key ARN: <code>arn:aws:kms:us-east-2:111122223333:key/1234abcd-12ab-34cd-56ef-1234567890ab</code>
         * </p>
         * </li>
         * </ul>
         * <p>
         * To get the key ID and key ARN for a KMS key, use <a>ListKeys</a> or <a>DescribeKey</a>.
         * </p>
         * 
         * @param keyId
         *        A unique identifier for the KMS key associated with the grant. To get the key ID and key ARN for a KMS
         *        key, use <a>ListKeys</a> or <a>DescribeKey</a>.</p>
         *        <p>
         *        Specify the key ID or key ARN of the KMS key. To specify a KMS key in a different Amazon Web Services
         *        account, you must use the key ARN.
         *        </p>
         *        <p>
         *        For example:
         *        </p>
         *        <ul>
         *        <li>
         *        <p>
         *        Key ID: <code>1234abcd-12ab-34cd-56ef-1234567890ab</code>
         *        </p>
         *        </li>
         *        <li>
         *        <p>
         *        Key ARN: <code>arn:aws:kms:us-east-2:111122223333:key/1234abcd-12ab-34cd-56ef-1234567890ab</code>
         *        </p>
         *        </li>
         *        </ul>
         *        <p>
         *        To get the key ID and key ARN for a KMS key, use <a>ListKeys</a> or <a>DescribeKey</a>.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder keyId(String keyId);

        /**
         * <p>
         * Identifies the grant to revoke. To get the grant ID, use <a>CreateGrant</a>, <a>ListGrants</a>, or
         * <a>ListRetirableGrants</a>.
         * </p>
         * 
         * @param grantId
         *        Identifies the grant to revoke. To get the grant ID, use <a>CreateGrant</a>, <a>ListGrants</a>, or
         *        <a>ListRetirableGrants</a>.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder grantId(String grantId);

        /**
         * <p>
         * Checks if your request will succeed. <code>DryRun</code> is an optional parameter.
         * </p>
         * <p>
         * To learn more about how to use this parameter, see <a
         * href="https://docs.aws.amazon.com/kms/latest/developerguide/programming-dryrun.html">Testing your KMS API
         * calls</a> in the <i>Key Management Service Developer Guide</i>.
         * </p>
         * 
         * @param dryRun
         *        Checks if your request will succeed. <code>DryRun</code> is an optional parameter. </p>
         *        <p>
         *        To learn more about how to use this parameter, see <a
         *        href="https://docs.aws.amazon.com/kms/latest/developerguide/programming-dryrun.html">Testing your KMS
         *        API calls</a> in the <i>Key Management Service Developer Guide</i>.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder dryRun(Boolean dryRun);

        @Override
        Builder overrideConfiguration(AwsRequestOverrideConfiguration overrideConfiguration);

        @Override
        Builder overrideConfiguration(Consumer<AwsRequestOverrideConfiguration.Builder> builderConsumer);
    }

    static final class BuilderImpl extends KmsRequest.BuilderImpl implements Builder {
        private String keyId;

        private String grantId;

        private Boolean dryRun;

        private BuilderImpl() {
        }

        private BuilderImpl(RevokeGrantRequest model) {
            super(model);
            keyId(model.keyId);
            grantId(model.grantId);
            dryRun(model.dryRun);
        }

        public final String getKeyId() {
            return keyId;
        }

        public final void setKeyId(String keyId) {
            this.keyId = keyId;
        }

        @Override
        public final Builder keyId(String keyId) {
            this.keyId = keyId;
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

        public final Boolean getDryRun() {
            return dryRun;
        }

        public final void setDryRun(Boolean dryRun) {
            this.dryRun = dryRun;
        }

        @Override
        public final Builder dryRun(Boolean dryRun) {
            this.dryRun = dryRun;
            return this;
        }

        @Override
        public Builder overrideConfiguration(AwsRequestOverrideConfiguration overrideConfiguration) {
            super.overrideConfiguration(overrideConfiguration);
            return this;
        }

        @Override
        public Builder overrideConfiguration(Consumer<AwsRequestOverrideConfiguration.Builder> builderConsumer) {
            super.overrideConfiguration(builderConsumer);
            return this;
        }

        @Override
        public RevokeGrantRequest build() {
            return new RevokeGrantRequest(this);
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
