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
import java.util.Collection;
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
import com.ibm.cos.v2.core.traits.ListTrait;
import com.ibm.cos.v2.core.traits.LocationTrait;
import com.ibm.cos.v2.core.util.DefaultSdkAutoConstructList;
import com.ibm.cos.v2.core.util.SdkAutoConstructList;
import com.ibm.cos.v2.utils.ToString;
import com.ibm.cos.v2.utils.builder.CopyableBuilder;
import com.ibm.cos.v2.utils.builder.ToCopyableBuilder;

/**
 */
@Generated("com.ibm.cos.v2:codegen")
public final class GetPublicKeyRequest extends KmsRequest implements
        ToCopyableBuilder<GetPublicKeyRequest.Builder, GetPublicKeyRequest> {
    private static final SdkField<String> KEY_ID_FIELD = SdkField.<String> builder(MarshallingType.STRING).memberName("KeyId")
            .getter(getter(GetPublicKeyRequest::keyId)).setter(setter(Builder::keyId))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("KeyId").build()).build();

    private static final SdkField<List<String>> GRANT_TOKENS_FIELD = SdkField
            .<List<String>> builder(MarshallingType.LIST)
            .memberName("GrantTokens")
            .getter(getter(GetPublicKeyRequest::grantTokens))
            .setter(setter(Builder::grantTokens))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("GrantTokens").build(),
                    ListTrait
                            .builder()
                            .memberLocationName(null)
                            .memberFieldInfo(
                                    SdkField.<String> builder(MarshallingType.STRING)
                                            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD)
                                                    .locationName("member").build()).build()).build()).build();

    private static final List<SdkField<?>> SDK_FIELDS = Collections.unmodifiableList(Arrays.asList(KEY_ID_FIELD,
            GRANT_TOKENS_FIELD));

    private static final Map<String, SdkField<?>> SDK_NAME_TO_FIELD = memberNameToFieldInitializer();

    private final String keyId;

    private final List<String> grantTokens;

    private GetPublicKeyRequest(BuilderImpl builder) {
        super(builder);
        this.keyId = builder.keyId;
        this.grantTokens = builder.grantTokens;
    }

    /**
     * <p>
     * Identifies the asymmetric KMS key that includes the public key.
     * </p>
     * <p>
     * To specify a KMS key, use its key ID, key ARN, alias name, or alias ARN. When using an alias name, prefix it with
     * <code>"alias/"</code>. To specify a KMS key in a different Amazon Web Services account, you must use the key ARN
     * or alias ARN.
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
     * <li>
     * <p>
     * Alias name: <code>alias/ExampleAlias</code>
     * </p>
     * </li>
     * <li>
     * <p>
     * Alias ARN: <code>arn:aws:kms:us-east-2:111122223333:alias/ExampleAlias</code>
     * </p>
     * </li>
     * </ul>
     * <p>
     * To get the key ID and key ARN for a KMS key, use <a>ListKeys</a> or <a>DescribeKey</a>. To get the alias name and
     * alias ARN, use <a>ListAliases</a>.
     * </p>
     * 
     * @return Identifies the asymmetric KMS key that includes the public key.</p>
     *         <p>
     *         To specify a KMS key, use its key ID, key ARN, alias name, or alias ARN. When using an alias name, prefix
     *         it with <code>"alias/"</code>. To specify a KMS key in a different Amazon Web Services account, you must
     *         use the key ARN or alias ARN.
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
     *         <li>
     *         <p>
     *         Alias name: <code>alias/ExampleAlias</code>
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         Alias ARN: <code>arn:aws:kms:us-east-2:111122223333:alias/ExampleAlias</code>
     *         </p>
     *         </li>
     *         </ul>
     *         <p>
     *         To get the key ID and key ARN for a KMS key, use <a>ListKeys</a> or <a>DescribeKey</a>. To get the alias
     *         name and alias ARN, use <a>ListAliases</a>.
     */
    public final String keyId() {
        return keyId;
    }

    /**
     * For responses, this returns true if the service returned a value for the GrantTokens property. This DOES NOT
     * check that the value is non-empty (for which, you should check the {@code isEmpty()} method on the property).
     * This is useful because the SDK will never return a null collection or map, but you may need to differentiate
     * between the service returning nothing (or null) and the service returning an empty collection or map. For
     * requests, this returns true if a value for the property was specified in the request builder, and false if a
     * value was not specified.
     */
    public final boolean hasGrantTokens() {
        return grantTokens != null && !(grantTokens instanceof SdkAutoConstructList);
    }

    /**
     * <p>
     * A list of grant tokens.
     * </p>
     * <p>
     * Use a grant token when your permission to call this operation comes from a new grant that has not yet achieved
     * <i>eventual consistency</i>. For more information, see <a
     * href="https://docs.aws.amazon.com/kms/latest/developerguide/grants.html#grant_token">Grant token</a> and <a
     * href="https://docs.aws.amazon.com/kms/latest/developerguide/grant-manage.html#using-grant-token">Using a grant
     * token</a> in the <i>Key Management Service Developer Guide</i>.
     * </p>
     * <p>
     * Attempts to modify the collection returned by this method will result in an UnsupportedOperationException.
     * </p>
     * <p>
     * This method will never return null. If you would like to know whether the service returned this field (so that
     * you can differentiate between null and empty), you can use the {@link #hasGrantTokens} method.
     * </p>
     * 
     * @return A list of grant tokens.</p>
     *         <p>
     *         Use a grant token when your permission to call this operation comes from a new grant that has not yet
     *         achieved <i>eventual consistency</i>. For more information, see <a
     *         href="https://docs.aws.amazon.com/kms/latest/developerguide/grants.html#grant_token">Grant token</a> and
     *         <a href="https://docs.aws.amazon.com/kms/latest/developerguide/grant-manage.html#using-grant-token">Using
     *         a grant token</a> in the <i>Key Management Service Developer Guide</i>.
     */
    public final List<String> grantTokens() {
        return grantTokens;
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
        hashCode = 31 * hashCode + Objects.hashCode(hasGrantTokens() ? grantTokens() : null);
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
        if (!(obj instanceof GetPublicKeyRequest)) {
            return false;
        }
        GetPublicKeyRequest other = (GetPublicKeyRequest) obj;
        return Objects.equals(keyId(), other.keyId()) && hasGrantTokens() == other.hasGrantTokens()
                && Objects.equals(grantTokens(), other.grantTokens());
    }

    /**
     * Returns a string representation of this object. This is useful for testing and debugging. Sensitive data will be
     * redacted from this string using a placeholder value.
     */
    @Override
    public final String toString() {
        return ToString.builder("GetPublicKeyRequest").add("KeyId", keyId())
                .add("GrantTokens", hasGrantTokens() ? grantTokens() : null).build();
    }

    public final <T> Optional<T> getValueForField(String fieldName, Class<T> clazz) {
        switch (fieldName) {
        case "KeyId":
            return Optional.ofNullable(clazz.cast(keyId()));
        case "GrantTokens":
            return Optional.ofNullable(clazz.cast(grantTokens()));
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
        map.put("GrantTokens", GRANT_TOKENS_FIELD);
        return Collections.unmodifiableMap(map);
    }

    private static <T> Function<Object, T> getter(Function<GetPublicKeyRequest, T> g) {
        return obj -> g.apply((GetPublicKeyRequest) obj);
    }

    private static <T> BiConsumer<Object, T> setter(BiConsumer<Builder, T> s) {
        return (obj, val) -> s.accept((Builder) obj, val);
    }

    @Mutable
    @NotThreadSafe
    public interface Builder extends KmsRequest.Builder, SdkPojo, CopyableBuilder<Builder, GetPublicKeyRequest> {
        /**
         * <p>
         * Identifies the asymmetric KMS key that includes the public key.
         * </p>
         * <p>
         * To specify a KMS key, use its key ID, key ARN, alias name, or alias ARN. When using an alias name, prefix it
         * with <code>"alias/"</code>. To specify a KMS key in a different Amazon Web Services account, you must use the
         * key ARN or alias ARN.
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
         * <li>
         * <p>
         * Alias name: <code>alias/ExampleAlias</code>
         * </p>
         * </li>
         * <li>
         * <p>
         * Alias ARN: <code>arn:aws:kms:us-east-2:111122223333:alias/ExampleAlias</code>
         * </p>
         * </li>
         * </ul>
         * <p>
         * To get the key ID and key ARN for a KMS key, use <a>ListKeys</a> or <a>DescribeKey</a>. To get the alias name
         * and alias ARN, use <a>ListAliases</a>.
         * </p>
         * 
         * @param keyId
         *        Identifies the asymmetric KMS key that includes the public key.</p>
         *        <p>
         *        To specify a KMS key, use its key ID, key ARN, alias name, or alias ARN. When using an alias name,
         *        prefix it with <code>"alias/"</code>. To specify a KMS key in a different Amazon Web Services account,
         *        you must use the key ARN or alias ARN.
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
         *        <li>
         *        <p>
         *        Alias name: <code>alias/ExampleAlias</code>
         *        </p>
         *        </li>
         *        <li>
         *        <p>
         *        Alias ARN: <code>arn:aws:kms:us-east-2:111122223333:alias/ExampleAlias</code>
         *        </p>
         *        </li>
         *        </ul>
         *        <p>
         *        To get the key ID and key ARN for a KMS key, use <a>ListKeys</a> or <a>DescribeKey</a>. To get the
         *        alias name and alias ARN, use <a>ListAliases</a>.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder keyId(String keyId);

        /**
         * <p>
         * A list of grant tokens.
         * </p>
         * <p>
         * Use a grant token when your permission to call this operation comes from a new grant that has not yet
         * achieved <i>eventual consistency</i>. For more information, see <a
         * href="https://docs.aws.amazon.com/kms/latest/developerguide/grants.html#grant_token">Grant token</a> and <a
         * href="https://docs.aws.amazon.com/kms/latest/developerguide/grant-manage.html#using-grant-token">Using a
         * grant token</a> in the <i>Key Management Service Developer Guide</i>.
         * </p>
         * 
         * @param grantTokens
         *        A list of grant tokens.</p>
         *        <p>
         *        Use a grant token when your permission to call this operation comes from a new grant that has not yet
         *        achieved <i>eventual consistency</i>. For more information, see <a
         *        href="https://docs.aws.amazon.com/kms/latest/developerguide/grants.html#grant_token">Grant token</a>
         *        and <a
         *        href="https://docs.aws.amazon.com/kms/latest/developerguide/grant-manage.html#using-grant-token">Using
         *        a grant token</a> in the <i>Key Management Service Developer Guide</i>.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder grantTokens(Collection<String> grantTokens);

        /**
         * <p>
         * A list of grant tokens.
         * </p>
         * <p>
         * Use a grant token when your permission to call this operation comes from a new grant that has not yet
         * achieved <i>eventual consistency</i>. For more information, see <a
         * href="https://docs.aws.amazon.com/kms/latest/developerguide/grants.html#grant_token">Grant token</a> and <a
         * href="https://docs.aws.amazon.com/kms/latest/developerguide/grant-manage.html#using-grant-token">Using a
         * grant token</a> in the <i>Key Management Service Developer Guide</i>.
         * </p>
         * 
         * @param grantTokens
         *        A list of grant tokens.</p>
         *        <p>
         *        Use a grant token when your permission to call this operation comes from a new grant that has not yet
         *        achieved <i>eventual consistency</i>. For more information, see <a
         *        href="https://docs.aws.amazon.com/kms/latest/developerguide/grants.html#grant_token">Grant token</a>
         *        and <a
         *        href="https://docs.aws.amazon.com/kms/latest/developerguide/grant-manage.html#using-grant-token">Using
         *        a grant token</a> in the <i>Key Management Service Developer Guide</i>.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder grantTokens(String... grantTokens);

        @Override
        Builder overrideConfiguration(AwsRequestOverrideConfiguration overrideConfiguration);

        @Override
        Builder overrideConfiguration(Consumer<AwsRequestOverrideConfiguration.Builder> builderConsumer);
    }

    static final class BuilderImpl extends KmsRequest.BuilderImpl implements Builder {
        private String keyId;

        private List<String> grantTokens = DefaultSdkAutoConstructList.getInstance();

        private BuilderImpl() {
        }

        private BuilderImpl(GetPublicKeyRequest model) {
            super(model);
            keyId(model.keyId);
            grantTokens(model.grantTokens);
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

        public final Collection<String> getGrantTokens() {
            if (grantTokens instanceof SdkAutoConstructList) {
                return null;
            }
            return grantTokens;
        }

        public final void setGrantTokens(Collection<String> grantTokens) {
            this.grantTokens = GrantTokenListCopier.copy(grantTokens);
        }

        @Override
        public final Builder grantTokens(Collection<String> grantTokens) {
            this.grantTokens = GrantTokenListCopier.copy(grantTokens);
            return this;
        }

        @Override
        @SafeVarargs
        public final Builder grantTokens(String... grantTokens) {
            grantTokens(Arrays.asList(grantTokens));
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
        public GetPublicKeyRequest build() {
            return new GetPublicKeyRequest(this);
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
