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

import java.nio.ByteBuffer;
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
import com.ibm.cos.v2.core.SdkBytes;
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
public final class GenerateMacRequest extends KmsRequest implements
        ToCopyableBuilder<GenerateMacRequest.Builder, GenerateMacRequest> {
    private static final SdkField<SdkBytes> MESSAGE_FIELD = SdkField.<SdkBytes> builder(MarshallingType.SDK_BYTES)
            .memberName("Message").getter(getter(GenerateMacRequest::message)).setter(setter(Builder::message))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("Message").build()).build();

    private static final SdkField<String> KEY_ID_FIELD = SdkField.<String> builder(MarshallingType.STRING).memberName("KeyId")
            .getter(getter(GenerateMacRequest::keyId)).setter(setter(Builder::keyId))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("KeyId").build()).build();

    private static final SdkField<String> MAC_ALGORITHM_FIELD = SdkField.<String> builder(MarshallingType.STRING)
            .memberName("MacAlgorithm").getter(getter(GenerateMacRequest::macAlgorithmAsString))
            .setter(setter(Builder::macAlgorithm))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("MacAlgorithm").build()).build();

    private static final SdkField<List<String>> GRANT_TOKENS_FIELD = SdkField
            .<List<String>> builder(MarshallingType.LIST)
            .memberName("GrantTokens")
            .getter(getter(GenerateMacRequest::grantTokens))
            .setter(setter(Builder::grantTokens))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("GrantTokens").build(),
                    ListTrait
                            .builder()
                            .memberLocationName(null)
                            .memberFieldInfo(
                                    SdkField.<String> builder(MarshallingType.STRING)
                                            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD)
                                                    .locationName("member").build()).build()).build()).build();

    private static final SdkField<Boolean> DRY_RUN_FIELD = SdkField.<Boolean> builder(MarshallingType.BOOLEAN)
            .memberName("DryRun").getter(getter(GenerateMacRequest::dryRun)).setter(setter(Builder::dryRun))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("DryRun").build()).build();

    private static final List<SdkField<?>> SDK_FIELDS = Collections.unmodifiableList(Arrays.asList(MESSAGE_FIELD, KEY_ID_FIELD,
            MAC_ALGORITHM_FIELD, GRANT_TOKENS_FIELD, DRY_RUN_FIELD));

    private static final Map<String, SdkField<?>> SDK_NAME_TO_FIELD = memberNameToFieldInitializer();

    private final SdkBytes message;

    private final String keyId;

    private final String macAlgorithm;

    private final List<String> grantTokens;

    private final Boolean dryRun;

    private GenerateMacRequest(BuilderImpl builder) {
        super(builder);
        this.message = builder.message;
        this.keyId = builder.keyId;
        this.macAlgorithm = builder.macAlgorithm;
        this.grantTokens = builder.grantTokens;
        this.dryRun = builder.dryRun;
    }

    /**
     * <p>
     * The message to be hashed. Specify a message of up to 4,096 bytes.
     * </p>
     * <p>
     * <code>GenerateMac</code> and <a>VerifyMac</a> do not provide special handling for message digests. If you
     * generate an HMAC for a hash digest of a message, you must verify the HMAC of the same hash digest.
     * </p>
     * 
     * @return The message to be hashed. Specify a message of up to 4,096 bytes. </p>
     *         <p>
     *         <code>GenerateMac</code> and <a>VerifyMac</a> do not provide special handling for message digests. If you
     *         generate an HMAC for a hash digest of a message, you must verify the HMAC of the same hash digest.
     */
    public final SdkBytes message() {
        return message;
    }

    /**
     * <p>
     * The HMAC KMS key to use in the operation. The MAC algorithm computes the HMAC for the message and the key as
     * described in <a href="https://datatracker.ietf.org/doc/html/rfc2104">RFC 2104</a>.
     * </p>
     * <p>
     * To identify an HMAC KMS key, use the <a>DescribeKey</a> operation and see the <code>KeySpec</code> field in the
     * response.
     * </p>
     * 
     * @return The HMAC KMS key to use in the operation. The MAC algorithm computes the HMAC for the message and the key
     *         as described in <a href="https://datatracker.ietf.org/doc/html/rfc2104">RFC 2104</a>.</p>
     *         <p>
     *         To identify an HMAC KMS key, use the <a>DescribeKey</a> operation and see the <code>KeySpec</code> field
     *         in the response.
     */
    public final String keyId() {
        return keyId;
    }

    /**
     * <p>
     * The MAC algorithm used in the operation.
     * </p>
     * <p>
     * The algorithm must be compatible with the HMAC KMS key that you specify. To find the MAC algorithms that your
     * HMAC KMS key supports, use the <a>DescribeKey</a> operation and see the <code>MacAlgorithms</code> field in the
     * <code>DescribeKey</code> response.
     * </p>
     * <p>
     * If the service returns an enum value that is not available in the current SDK version, {@link #macAlgorithm} will
     * return {@link MacAlgorithmSpec#UNKNOWN_TO_SDK_VERSION}. The raw value returned by the service is available from
     * {@link #macAlgorithmAsString}.
     * </p>
     * 
     * @return The MAC algorithm used in the operation.</p>
     *         <p>
     *         The algorithm must be compatible with the HMAC KMS key that you specify. To find the MAC algorithms that
     *         your HMAC KMS key supports, use the <a>DescribeKey</a> operation and see the <code>MacAlgorithms</code>
     *         field in the <code>DescribeKey</code> response.
     * @see MacAlgorithmSpec
     */
    public final MacAlgorithmSpec macAlgorithm() {
        return MacAlgorithmSpec.fromValue(macAlgorithm);
    }

    /**
     * <p>
     * The MAC algorithm used in the operation.
     * </p>
     * <p>
     * The algorithm must be compatible with the HMAC KMS key that you specify. To find the MAC algorithms that your
     * HMAC KMS key supports, use the <a>DescribeKey</a> operation and see the <code>MacAlgorithms</code> field in the
     * <code>DescribeKey</code> response.
     * </p>
     * <p>
     * If the service returns an enum value that is not available in the current SDK version, {@link #macAlgorithm} will
     * return {@link MacAlgorithmSpec#UNKNOWN_TO_SDK_VERSION}. The raw value returned by the service is available from
     * {@link #macAlgorithmAsString}.
     * </p>
     * 
     * @return The MAC algorithm used in the operation.</p>
     *         <p>
     *         The algorithm must be compatible with the HMAC KMS key that you specify. To find the MAC algorithms that
     *         your HMAC KMS key supports, use the <a>DescribeKey</a> operation and see the <code>MacAlgorithms</code>
     *         field in the <code>DescribeKey</code> response.
     * @see MacAlgorithmSpec
     */
    public final String macAlgorithmAsString() {
        return macAlgorithm;
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
        hashCode = 31 * hashCode + Objects.hashCode(message());
        hashCode = 31 * hashCode + Objects.hashCode(keyId());
        hashCode = 31 * hashCode + Objects.hashCode(macAlgorithmAsString());
        hashCode = 31 * hashCode + Objects.hashCode(hasGrantTokens() ? grantTokens() : null);
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
        if (!(obj instanceof GenerateMacRequest)) {
            return false;
        }
        GenerateMacRequest other = (GenerateMacRequest) obj;
        return Objects.equals(message(), other.message()) && Objects.equals(keyId(), other.keyId())
                && Objects.equals(macAlgorithmAsString(), other.macAlgorithmAsString())
                && hasGrantTokens() == other.hasGrantTokens() && Objects.equals(grantTokens(), other.grantTokens())
                && Objects.equals(dryRun(), other.dryRun());
    }

    /**
     * Returns a string representation of this object. This is useful for testing and debugging. Sensitive data will be
     * redacted from this string using a placeholder value.
     */
    @Override
    public final String toString() {
        return ToString.builder("GenerateMacRequest")
                .add("Message", message() == null ? null : "*** Sensitive Data Redacted ***").add("KeyId", keyId())
                .add("MacAlgorithm", macAlgorithmAsString()).add("GrantTokens", hasGrantTokens() ? grantTokens() : null)
                .add("DryRun", dryRun()).build();
    }

    public final <T> Optional<T> getValueForField(String fieldName, Class<T> clazz) {
        switch (fieldName) {
        case "Message":
            return Optional.ofNullable(clazz.cast(message()));
        case "KeyId":
            return Optional.ofNullable(clazz.cast(keyId()));
        case "MacAlgorithm":
            return Optional.ofNullable(clazz.cast(macAlgorithmAsString()));
        case "GrantTokens":
            return Optional.ofNullable(clazz.cast(grantTokens()));
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
        map.put("Message", MESSAGE_FIELD);
        map.put("KeyId", KEY_ID_FIELD);
        map.put("MacAlgorithm", MAC_ALGORITHM_FIELD);
        map.put("GrantTokens", GRANT_TOKENS_FIELD);
        map.put("DryRun", DRY_RUN_FIELD);
        return Collections.unmodifiableMap(map);
    }

    private static <T> Function<Object, T> getter(Function<GenerateMacRequest, T> g) {
        return obj -> g.apply((GenerateMacRequest) obj);
    }

    private static <T> BiConsumer<Object, T> setter(BiConsumer<Builder, T> s) {
        return (obj, val) -> s.accept((Builder) obj, val);
    }

    @Mutable
    @NotThreadSafe
    public interface Builder extends KmsRequest.Builder, SdkPojo, CopyableBuilder<Builder, GenerateMacRequest> {
        /**
         * <p>
         * The message to be hashed. Specify a message of up to 4,096 bytes.
         * </p>
         * <p>
         * <code>GenerateMac</code> and <a>VerifyMac</a> do not provide special handling for message digests. If you
         * generate an HMAC for a hash digest of a message, you must verify the HMAC of the same hash digest.
         * </p>
         * 
         * @param message
         *        The message to be hashed. Specify a message of up to 4,096 bytes. </p>
         *        <p>
         *        <code>GenerateMac</code> and <a>VerifyMac</a> do not provide special handling for message digests. If
         *        you generate an HMAC for a hash digest of a message, you must verify the HMAC of the same hash digest.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder message(SdkBytes message);

        /**
         * <p>
         * The HMAC KMS key to use in the operation. The MAC algorithm computes the HMAC for the message and the key as
         * described in <a href="https://datatracker.ietf.org/doc/html/rfc2104">RFC 2104</a>.
         * </p>
         * <p>
         * To identify an HMAC KMS key, use the <a>DescribeKey</a> operation and see the <code>KeySpec</code> field in
         * the response.
         * </p>
         * 
         * @param keyId
         *        The HMAC KMS key to use in the operation. The MAC algorithm computes the HMAC for the message and the
         *        key as described in <a href="https://datatracker.ietf.org/doc/html/rfc2104">RFC 2104</a>.</p>
         *        <p>
         *        To identify an HMAC KMS key, use the <a>DescribeKey</a> operation and see the <code>KeySpec</code>
         *        field in the response.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder keyId(String keyId);

        /**
         * <p>
         * The MAC algorithm used in the operation.
         * </p>
         * <p>
         * The algorithm must be compatible with the HMAC KMS key that you specify. To find the MAC algorithms that your
         * HMAC KMS key supports, use the <a>DescribeKey</a> operation and see the <code>MacAlgorithms</code> field in
         * the <code>DescribeKey</code> response.
         * </p>
         * 
         * @param macAlgorithm
         *        The MAC algorithm used in the operation.</p>
         *        <p>
         *        The algorithm must be compatible with the HMAC KMS key that you specify. To find the MAC algorithms
         *        that your HMAC KMS key supports, use the <a>DescribeKey</a> operation and see the
         *        <code>MacAlgorithms</code> field in the <code>DescribeKey</code> response.
         * @see MacAlgorithmSpec
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see MacAlgorithmSpec
         */
        Builder macAlgorithm(String macAlgorithm);

        /**
         * <p>
         * The MAC algorithm used in the operation.
         * </p>
         * <p>
         * The algorithm must be compatible with the HMAC KMS key that you specify. To find the MAC algorithms that your
         * HMAC KMS key supports, use the <a>DescribeKey</a> operation and see the <code>MacAlgorithms</code> field in
         * the <code>DescribeKey</code> response.
         * </p>
         * 
         * @param macAlgorithm
         *        The MAC algorithm used in the operation.</p>
         *        <p>
         *        The algorithm must be compatible with the HMAC KMS key that you specify. To find the MAC algorithms
         *        that your HMAC KMS key supports, use the <a>DescribeKey</a> operation and see the
         *        <code>MacAlgorithms</code> field in the <code>DescribeKey</code> response.
         * @see MacAlgorithmSpec
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see MacAlgorithmSpec
         */
        Builder macAlgorithm(MacAlgorithmSpec macAlgorithm);

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
        private SdkBytes message;

        private String keyId;

        private String macAlgorithm;

        private List<String> grantTokens = DefaultSdkAutoConstructList.getInstance();

        private Boolean dryRun;

        private BuilderImpl() {
        }

        private BuilderImpl(GenerateMacRequest model) {
            super(model);
            message(model.message);
            keyId(model.keyId);
            macAlgorithm(model.macAlgorithm);
            grantTokens(model.grantTokens);
            dryRun(model.dryRun);
        }

        public final ByteBuffer getMessage() {
            return message == null ? null : message.asByteBuffer();
        }

        public final void setMessage(ByteBuffer message) {
            message(message == null ? null : SdkBytes.fromByteBuffer(message));
        }

        @Override
        public final Builder message(SdkBytes message) {
            this.message = message;
            return this;
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

        public final String getMacAlgorithm() {
            return macAlgorithm;
        }

        public final void setMacAlgorithm(String macAlgorithm) {
            this.macAlgorithm = macAlgorithm;
        }

        @Override
        public final Builder macAlgorithm(String macAlgorithm) {
            this.macAlgorithm = macAlgorithm;
            return this;
        }

        @Override
        public final Builder macAlgorithm(MacAlgorithmSpec macAlgorithm) {
            this.macAlgorithm(macAlgorithm == null ? null : macAlgorithm.toString());
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
        public GenerateMacRequest build() {
            return new GenerateMacRequest(this);
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
