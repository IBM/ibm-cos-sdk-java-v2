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
public final class CreateAliasRequest extends KmsRequest implements
        ToCopyableBuilder<CreateAliasRequest.Builder, CreateAliasRequest> {
    private static final SdkField<String> ALIAS_NAME_FIELD = SdkField.<String> builder(MarshallingType.STRING)
            .memberName("AliasName").getter(getter(CreateAliasRequest::aliasName)).setter(setter(Builder::aliasName))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("AliasName").build()).build();

    private static final SdkField<String> TARGET_KEY_ID_FIELD = SdkField.<String> builder(MarshallingType.STRING)
            .memberName("TargetKeyId").getter(getter(CreateAliasRequest::targetKeyId)).setter(setter(Builder::targetKeyId))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("TargetKeyId").build()).build();

    private static final List<SdkField<?>> SDK_FIELDS = Collections.unmodifiableList(Arrays.asList(ALIAS_NAME_FIELD,
            TARGET_KEY_ID_FIELD));

    private static final Map<String, SdkField<?>> SDK_NAME_TO_FIELD = memberNameToFieldInitializer();

    private final String aliasName;

    private final String targetKeyId;

    private CreateAliasRequest(BuilderImpl builder) {
        super(builder);
        this.aliasName = builder.aliasName;
        this.targetKeyId = builder.targetKeyId;
    }

    /**
     * <p>
     * Specifies the alias name. This value must begin with <code>alias/</code> followed by a name, such as
     * <code>alias/ExampleAlias</code>.
     * </p>
     * <important>
     * <p>
     * Do not include confidential or sensitive information in this field. This field may be displayed in plaintext in
     * CloudTrail logs and other output.
     * </p>
     * </important>
     * <p>
     * The <code>AliasName</code> value must be string of 1-256 characters. It can contain only alphanumeric characters,
     * forward slashes (/), underscores (_), and dashes (-). The alias name cannot begin with <code>alias/aws/</code>.
     * The <code>alias/aws/</code> prefix is reserved for <a
     * href="https://docs.aws.amazon.com/kms/latest/developerguide/concepts.html#aws-managed-cmk">Amazon Web Services
     * managed keys</a>.
     * </p>
     * 
     * @return Specifies the alias name. This value must begin with <code>alias/</code> followed by a name, such as
     *         <code>alias/ExampleAlias</code>. </p> <important>
     *         <p>
     *         Do not include confidential or sensitive information in this field. This field may be displayed in
     *         plaintext in CloudTrail logs and other output.
     *         </p>
     *         </important>
     *         <p>
     *         The <code>AliasName</code> value must be string of 1-256 characters. It can contain only alphanumeric
     *         characters, forward slashes (/), underscores (_), and dashes (-). The alias name cannot begin with
     *         <code>alias/aws/</code>. The <code>alias/aws/</code> prefix is reserved for <a
     *         href="https://docs.aws.amazon.com/kms/latest/developerguide/concepts.html#aws-managed-cmk">Amazon Web
     *         Services managed keys</a>.
     */
    public final String aliasName() {
        return aliasName;
    }

    /**
     * <p>
     * Associates the alias with the specified <a
     * href="https://docs.aws.amazon.com/kms/latest/developerguide/concepts.html#customer-cmk">customer managed key</a>.
     * The KMS key must be in the same Amazon Web Services Region.
     * </p>
     * <p>
     * A valid key ID is required. If you supply a null or empty string value, this operation returns an error.
     * </p>
     * <p>
     * For help finding the key ID and ARN, see <a
     * href="https://docs.aws.amazon.com/kms/latest/developerguide/viewing-keys.html#find-cmk-id-arn">Finding the Key ID
     * and ARN</a> in the <i> <i>Key Management Service Developer Guide</i> </i>.
     * </p>
     * <p>
     * Specify the key ID or key ARN of the KMS key.
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
     * @return Associates the alias with the specified <a
     *         href="https://docs.aws.amazon.com/kms/latest/developerguide/concepts.html#customer-cmk">customer managed
     *         key</a>. The KMS key must be in the same Amazon Web Services Region. </p>
     *         <p>
     *         A valid key ID is required. If you supply a null or empty string value, this operation returns an error.
     *         </p>
     *         <p>
     *         For help finding the key ID and ARN, see <a
     *         href="https://docs.aws.amazon.com/kms/latest/developerguide/viewing-keys.html#find-cmk-id-arn">Finding
     *         the Key ID and ARN</a> in the <i> <i>Key Management Service Developer Guide</i> </i>.
     *         </p>
     *         <p>
     *         Specify the key ID or key ARN of the KMS key.
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
    public final String targetKeyId() {
        return targetKeyId;
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
        hashCode = 31 * hashCode + Objects.hashCode(aliasName());
        hashCode = 31 * hashCode + Objects.hashCode(targetKeyId());
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
        if (!(obj instanceof CreateAliasRequest)) {
            return false;
        }
        CreateAliasRequest other = (CreateAliasRequest) obj;
        return Objects.equals(aliasName(), other.aliasName()) && Objects.equals(targetKeyId(), other.targetKeyId());
    }

    /**
     * Returns a string representation of this object. This is useful for testing and debugging. Sensitive data will be
     * redacted from this string using a placeholder value.
     */
    @Override
    public final String toString() {
        return ToString.builder("CreateAliasRequest").add("AliasName", aliasName()).add("TargetKeyId", targetKeyId()).build();
    }

    public final <T> Optional<T> getValueForField(String fieldName, Class<T> clazz) {
        switch (fieldName) {
        case "AliasName":
            return Optional.ofNullable(clazz.cast(aliasName()));
        case "TargetKeyId":
            return Optional.ofNullable(clazz.cast(targetKeyId()));
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
        map.put("TargetKeyId", TARGET_KEY_ID_FIELD);
        return Collections.unmodifiableMap(map);
    }

    private static <T> Function<Object, T> getter(Function<CreateAliasRequest, T> g) {
        return obj -> g.apply((CreateAliasRequest) obj);
    }

    private static <T> BiConsumer<Object, T> setter(BiConsumer<Builder, T> s) {
        return (obj, val) -> s.accept((Builder) obj, val);
    }

    @Mutable
    @NotThreadSafe
    public interface Builder extends KmsRequest.Builder, SdkPojo, CopyableBuilder<Builder, CreateAliasRequest> {
        /**
         * <p>
         * Specifies the alias name. This value must begin with <code>alias/</code> followed by a name, such as
         * <code>alias/ExampleAlias</code>.
         * </p>
         * <important>
         * <p>
         * Do not include confidential or sensitive information in this field. This field may be displayed in plaintext
         * in CloudTrail logs and other output.
         * </p>
         * </important>
         * <p>
         * The <code>AliasName</code> value must be string of 1-256 characters. It can contain only alphanumeric
         * characters, forward slashes (/), underscores (_), and dashes (-). The alias name cannot begin with
         * <code>alias/aws/</code>. The <code>alias/aws/</code> prefix is reserved for <a
         * href="https://docs.aws.amazon.com/kms/latest/developerguide/concepts.html#aws-managed-cmk">Amazon Web
         * Services managed keys</a>.
         * </p>
         * 
         * @param aliasName
         *        Specifies the alias name. This value must begin with <code>alias/</code> followed by a name, such as
         *        <code>alias/ExampleAlias</code>. </p> <important>
         *        <p>
         *        Do not include confidential or sensitive information in this field. This field may be displayed in
         *        plaintext in CloudTrail logs and other output.
         *        </p>
         *        </important>
         *        <p>
         *        The <code>AliasName</code> value must be string of 1-256 characters. It can contain only alphanumeric
         *        characters, forward slashes (/), underscores (_), and dashes (-). The alias name cannot begin with
         *        <code>alias/aws/</code>. The <code>alias/aws/</code> prefix is reserved for <a
         *        href="https://docs.aws.amazon.com/kms/latest/developerguide/concepts.html#aws-managed-cmk">Amazon Web
         *        Services managed keys</a>.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder aliasName(String aliasName);

        /**
         * <p>
         * Associates the alias with the specified <a
         * href="https://docs.aws.amazon.com/kms/latest/developerguide/concepts.html#customer-cmk">customer managed
         * key</a>. The KMS key must be in the same Amazon Web Services Region.
         * </p>
         * <p>
         * A valid key ID is required. If you supply a null or empty string value, this operation returns an error.
         * </p>
         * <p>
         * For help finding the key ID and ARN, see <a
         * href="https://docs.aws.amazon.com/kms/latest/developerguide/viewing-keys.html#find-cmk-id-arn">Finding the
         * Key ID and ARN</a> in the <i> <i>Key Management Service Developer Guide</i> </i>.
         * </p>
         * <p>
         * Specify the key ID or key ARN of the KMS key.
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
         * @param targetKeyId
         *        Associates the alias with the specified <a
         *        href="https://docs.aws.amazon.com/kms/latest/developerguide/concepts.html#customer-cmk">customer
         *        managed key</a>. The KMS key must be in the same Amazon Web Services Region. </p>
         *        <p>
         *        A valid key ID is required. If you supply a null or empty string value, this operation returns an
         *        error.
         *        </p>
         *        <p>
         *        For help finding the key ID and ARN, see <a
         *        href="https://docs.aws.amazon.com/kms/latest/developerguide/viewing-keys.html#find-cmk-id-arn">Finding
         *        the Key ID and ARN</a> in the <i> <i>Key Management Service Developer Guide</i> </i>.
         *        </p>
         *        <p>
         *        Specify the key ID or key ARN of the KMS key.
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
        Builder targetKeyId(String targetKeyId);

        @Override
        Builder overrideConfiguration(AwsRequestOverrideConfiguration overrideConfiguration);

        @Override
        Builder overrideConfiguration(Consumer<AwsRequestOverrideConfiguration.Builder> builderConsumer);
    }

    static final class BuilderImpl extends KmsRequest.BuilderImpl implements Builder {
        private String aliasName;

        private String targetKeyId;

        private BuilderImpl() {
        }

        private BuilderImpl(CreateAliasRequest model) {
            super(model);
            aliasName(model.aliasName);
            targetKeyId(model.targetKeyId);
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
        public CreateAliasRequest build() {
            return new CreateAliasRequest(this);
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
