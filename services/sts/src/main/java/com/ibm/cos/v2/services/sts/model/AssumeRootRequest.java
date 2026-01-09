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
public final class AssumeRootRequest extends StsRequest implements
        ToCopyableBuilder<AssumeRootRequest.Builder, AssumeRootRequest> {
    private static final SdkField<String> TARGET_PRINCIPAL_FIELD = SdkField.<String> builder(MarshallingType.STRING)
            .memberName("TargetPrincipal").getter(getter(AssumeRootRequest::targetPrincipal))
            .setter(setter(Builder::targetPrincipal))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("TargetPrincipal").build()).build();

    private static final SdkField<PolicyDescriptorType> TASK_POLICY_ARN_FIELD = SdkField
            .<PolicyDescriptorType> builder(MarshallingType.SDK_POJO).memberName("TaskPolicyArn")
            .getter(getter(AssumeRootRequest::taskPolicyArn)).setter(setter(Builder::taskPolicyArn))
            .constructor(PolicyDescriptorType::builder)
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("TaskPolicyArn").build()).build();

    private static final SdkField<Integer> DURATION_SECONDS_FIELD = SdkField.<Integer> builder(MarshallingType.INTEGER)
            .memberName("DurationSeconds").getter(getter(AssumeRootRequest::durationSeconds))
            .setter(setter(Builder::durationSeconds))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("DurationSeconds").build()).build();

    private static final List<SdkField<?>> SDK_FIELDS = Collections.unmodifiableList(Arrays.asList(TARGET_PRINCIPAL_FIELD,
            TASK_POLICY_ARN_FIELD, DURATION_SECONDS_FIELD));

    private static final Map<String, SdkField<?>> SDK_NAME_TO_FIELD = memberNameToFieldInitializer();

    private final String targetPrincipal;

    private final PolicyDescriptorType taskPolicyArn;

    private final Integer durationSeconds;

    private AssumeRootRequest(BuilderImpl builder) {
        super(builder);
        this.targetPrincipal = builder.targetPrincipal;
        this.taskPolicyArn = builder.taskPolicyArn;
        this.durationSeconds = builder.durationSeconds;
    }

    /**
     * <p>
     * The member account principal ARN or account ID.
     * </p>
     * 
     * @return The member account principal ARN or account ID.
     */
    public final String targetPrincipal() {
        return targetPrincipal;
    }

    /**
     * <p>
     * The identity based policy that scopes the session to the privileged tasks that can be performed. You can use one
     * of following Amazon Web Services managed policies to scope root session actions.
     * </p>
     * <ul>
     * <li>
     * <p>
     * <a href=
     * "https://docs.aws.amazon.com/IAM/latest/UserGuide/security-iam-awsmanpol.html#security-iam-awsmanpol-IAMAuditRootUserCredentials"
     * >IAMAuditRootUserCredentials</a>
     * </p>
     * </li>
     * <li>
     * <p>
     * <a href=
     * "https://docs.aws.amazon.com/IAM/latest/UserGuide/security-iam-awsmanpol.html#security-iam-awsmanpol-IAMCreateRootUserPassword"
     * >IAMCreateRootUserPassword</a>
     * </p>
     * </li>
     * <li>
     * <p>
     * <a href=
     * "https://docs.aws.amazon.com/IAM/latest/UserGuide/security-iam-awsmanpol.html#security-iam-awsmanpol-IAMDeleteRootUserCredentials"
     * >IAMDeleteRootUserCredentials</a>
     * </p>
     * </li>
     * <li>
     * <p>
     * <a href=
     * "https://docs.aws.amazon.com/IAM/latest/UserGuide/security-iam-awsmanpol.html#security-iam-awsmanpol-S3UnlockBucketPolicy"
     * >S3UnlockBucketPolicy</a>
     * </p>
     * </li>
     * <li>
     * <p>
     * <a href=
     * "https://docs.aws.amazon.com/IAM/latest/UserGuide/security-iam-awsmanpol.html#security-iam-awsmanpol-SQSUnlockQueuePolicy"
     * >SQSUnlockQueuePolicy</a>
     * </p>
     * </li>
     * </ul>
     * 
     * @return The identity based policy that scopes the session to the privileged tasks that can be performed. You can
     *         use one of following Amazon Web Services managed policies to scope root session actions.</p>
     *         <ul>
     *         <li>
     *         <p>
     *         <a href=
     *         "https://docs.aws.amazon.com/IAM/latest/UserGuide/security-iam-awsmanpol.html#security-iam-awsmanpol-IAMAuditRootUserCredentials"
     *         >IAMAuditRootUserCredentials</a>
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         <a href=
     *         "https://docs.aws.amazon.com/IAM/latest/UserGuide/security-iam-awsmanpol.html#security-iam-awsmanpol-IAMCreateRootUserPassword"
     *         >IAMCreateRootUserPassword</a>
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         <a href=
     *         "https://docs.aws.amazon.com/IAM/latest/UserGuide/security-iam-awsmanpol.html#security-iam-awsmanpol-IAMDeleteRootUserCredentials"
     *         >IAMDeleteRootUserCredentials</a>
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         <a href=
     *         "https://docs.aws.amazon.com/IAM/latest/UserGuide/security-iam-awsmanpol.html#security-iam-awsmanpol-S3UnlockBucketPolicy"
     *         >S3UnlockBucketPolicy</a>
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         <a href=
     *         "https://docs.aws.amazon.com/IAM/latest/UserGuide/security-iam-awsmanpol.html#security-iam-awsmanpol-SQSUnlockQueuePolicy"
     *         >SQSUnlockQueuePolicy</a>
     *         </p>
     *         </li>
     */
    public final PolicyDescriptorType taskPolicyArn() {
        return taskPolicyArn;
    }

    /**
     * <p>
     * The duration, in seconds, of the privileged session. The value can range from 0 seconds up to the maximum session
     * duration of 900 seconds (15 minutes). If you specify a value higher than this setting, the operation fails.
     * </p>
     * <p>
     * By default, the value is set to <code>900</code> seconds.
     * </p>
     * 
     * @return The duration, in seconds, of the privileged session. The value can range from 0 seconds up to the maximum
     *         session duration of 900 seconds (15 minutes). If you specify a value higher than this setting, the
     *         operation fails.</p>
     *         <p>
     *         By default, the value is set to <code>900</code> seconds.
     */
    public final Integer durationSeconds() {
        return durationSeconds;
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
        hashCode = 31 * hashCode + Objects.hashCode(targetPrincipal());
        hashCode = 31 * hashCode + Objects.hashCode(taskPolicyArn());
        hashCode = 31 * hashCode + Objects.hashCode(durationSeconds());
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
        if (!(obj instanceof AssumeRootRequest)) {
            return false;
        }
        AssumeRootRequest other = (AssumeRootRequest) obj;
        return Objects.equals(targetPrincipal(), other.targetPrincipal())
                && Objects.equals(taskPolicyArn(), other.taskPolicyArn())
                && Objects.equals(durationSeconds(), other.durationSeconds());
    }

    /**
     * Returns a string representation of this object. This is useful for testing and debugging. Sensitive data will be
     * redacted from this string using a placeholder value.
     */
    @Override
    public final String toString() {
        return ToString.builder("AssumeRootRequest").add("TargetPrincipal", targetPrincipal())
                .add("TaskPolicyArn", taskPolicyArn()).add("DurationSeconds", durationSeconds()).build();
    }

    public final <T> Optional<T> getValueForField(String fieldName, Class<T> clazz) {
        switch (fieldName) {
        case "TargetPrincipal":
            return Optional.ofNullable(clazz.cast(targetPrincipal()));
        case "TaskPolicyArn":
            return Optional.ofNullable(clazz.cast(taskPolicyArn()));
        case "DurationSeconds":
            return Optional.ofNullable(clazz.cast(durationSeconds()));
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
        map.put("TargetPrincipal", TARGET_PRINCIPAL_FIELD);
        map.put("TaskPolicyArn", TASK_POLICY_ARN_FIELD);
        map.put("DurationSeconds", DURATION_SECONDS_FIELD);
        return Collections.unmodifiableMap(map);
    }

    private static <T> Function<Object, T> getter(Function<AssumeRootRequest, T> g) {
        return obj -> g.apply((AssumeRootRequest) obj);
    }

    private static <T> BiConsumer<Object, T> setter(BiConsumer<Builder, T> s) {
        return (obj, val) -> s.accept((Builder) obj, val);
    }

    @Mutable
    @NotThreadSafe
    public interface Builder extends StsRequest.Builder, SdkPojo, CopyableBuilder<Builder, AssumeRootRequest> {
        /**
         * <p>
         * The member account principal ARN or account ID.
         * </p>
         * 
         * @param targetPrincipal
         *        The member account principal ARN or account ID.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder targetPrincipal(String targetPrincipal);

        /**
         * <p>
         * The identity based policy that scopes the session to the privileged tasks that can be performed. You can use
         * one of following Amazon Web Services managed policies to scope root session actions.
         * </p>
         * <ul>
         * <li>
         * <p>
         * <a href=
         * "https://docs.aws.amazon.com/IAM/latest/UserGuide/security-iam-awsmanpol.html#security-iam-awsmanpol-IAMAuditRootUserCredentials"
         * >IAMAuditRootUserCredentials</a>
         * </p>
         * </li>
         * <li>
         * <p>
         * <a href=
         * "https://docs.aws.amazon.com/IAM/latest/UserGuide/security-iam-awsmanpol.html#security-iam-awsmanpol-IAMCreateRootUserPassword"
         * >IAMCreateRootUserPassword</a>
         * </p>
         * </li>
         * <li>
         * <p>
         * <a href=
         * "https://docs.aws.amazon.com/IAM/latest/UserGuide/security-iam-awsmanpol.html#security-iam-awsmanpol-IAMDeleteRootUserCredentials"
         * >IAMDeleteRootUserCredentials</a>
         * </p>
         * </li>
         * <li>
         * <p>
         * <a href=
         * "https://docs.aws.amazon.com/IAM/latest/UserGuide/security-iam-awsmanpol.html#security-iam-awsmanpol-S3UnlockBucketPolicy"
         * >S3UnlockBucketPolicy</a>
         * </p>
         * </li>
         * <li>
         * <p>
         * <a href=
         * "https://docs.aws.amazon.com/IAM/latest/UserGuide/security-iam-awsmanpol.html#security-iam-awsmanpol-SQSUnlockQueuePolicy"
         * >SQSUnlockQueuePolicy</a>
         * </p>
         * </li>
         * </ul>
         * 
         * @param taskPolicyArn
         *        The identity based policy that scopes the session to the privileged tasks that can be performed. You
         *        can use one of following Amazon Web Services managed policies to scope root session actions.</p>
         *        <ul>
         *        <li>
         *        <p>
         *        <a href=
         *        "https://docs.aws.amazon.com/IAM/latest/UserGuide/security-iam-awsmanpol.html#security-iam-awsmanpol-IAMAuditRootUserCredentials"
         *        >IAMAuditRootUserCredentials</a>
         *        </p>
         *        </li>
         *        <li>
         *        <p>
         *        <a href=
         *        "https://docs.aws.amazon.com/IAM/latest/UserGuide/security-iam-awsmanpol.html#security-iam-awsmanpol-IAMCreateRootUserPassword"
         *        >IAMCreateRootUserPassword</a>
         *        </p>
         *        </li>
         *        <li>
         *        <p>
         *        <a href=
         *        "https://docs.aws.amazon.com/IAM/latest/UserGuide/security-iam-awsmanpol.html#security-iam-awsmanpol-IAMDeleteRootUserCredentials"
         *        >IAMDeleteRootUserCredentials</a>
         *        </p>
         *        </li>
         *        <li>
         *        <p>
         *        <a href=
         *        "https://docs.aws.amazon.com/IAM/latest/UserGuide/security-iam-awsmanpol.html#security-iam-awsmanpol-S3UnlockBucketPolicy"
         *        >S3UnlockBucketPolicy</a>
         *        </p>
         *        </li>
         *        <li>
         *        <p>
         *        <a href=
         *        "https://docs.aws.amazon.com/IAM/latest/UserGuide/security-iam-awsmanpol.html#security-iam-awsmanpol-SQSUnlockQueuePolicy"
         *        >SQSUnlockQueuePolicy</a>
         *        </p>
         *        </li>
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder taskPolicyArn(PolicyDescriptorType taskPolicyArn);

        /**
         * <p>
         * The identity based policy that scopes the session to the privileged tasks that can be performed. You can use
         * one of following Amazon Web Services managed policies to scope root session actions.
         * </p>
         * <ul>
         * <li>
         * <p>
         * <a href=
         * "https://docs.aws.amazon.com/IAM/latest/UserGuide/security-iam-awsmanpol.html#security-iam-awsmanpol-IAMAuditRootUserCredentials"
         * >IAMAuditRootUserCredentials</a>
         * </p>
         * </li>
         * <li>
         * <p>
         * <a href=
         * "https://docs.aws.amazon.com/IAM/latest/UserGuide/security-iam-awsmanpol.html#security-iam-awsmanpol-IAMCreateRootUserPassword"
         * >IAMCreateRootUserPassword</a>
         * </p>
         * </li>
         * <li>
         * <p>
         * <a href=
         * "https://docs.aws.amazon.com/IAM/latest/UserGuide/security-iam-awsmanpol.html#security-iam-awsmanpol-IAMDeleteRootUserCredentials"
         * >IAMDeleteRootUserCredentials</a>
         * </p>
         * </li>
         * <li>
         * <p>
         * <a href=
         * "https://docs.aws.amazon.com/IAM/latest/UserGuide/security-iam-awsmanpol.html#security-iam-awsmanpol-S3UnlockBucketPolicy"
         * >S3UnlockBucketPolicy</a>
         * </p>
         * </li>
         * <li>
         * <p>
         * <a href=
         * "https://docs.aws.amazon.com/IAM/latest/UserGuide/security-iam-awsmanpol.html#security-iam-awsmanpol-SQSUnlockQueuePolicy"
         * >SQSUnlockQueuePolicy</a>
         * </p>
         * </li>
         * </ul>
         * This is a convenience method that creates an instance of the {@link PolicyDescriptorType.Builder} avoiding
         * the need to create one manually via {@link PolicyDescriptorType#builder()}.
         *
         * <p>
         * When the {@link Consumer} completes, {@link PolicyDescriptorType.Builder#build()} is called immediately and
         * its result is passed to {@link #taskPolicyArn(PolicyDescriptorType)}.
         * 
         * @param taskPolicyArn
         *        a consumer that will call methods on {@link PolicyDescriptorType.Builder}
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see #taskPolicyArn(PolicyDescriptorType)
         */
        default Builder taskPolicyArn(Consumer<PolicyDescriptorType.Builder> taskPolicyArn) {
            return taskPolicyArn(PolicyDescriptorType.builder().applyMutation(taskPolicyArn).build());
        }

        /**
         * <p>
         * The duration, in seconds, of the privileged session. The value can range from 0 seconds up to the maximum
         * session duration of 900 seconds (15 minutes). If you specify a value higher than this setting, the operation
         * fails.
         * </p>
         * <p>
         * By default, the value is set to <code>900</code> seconds.
         * </p>
         * 
         * @param durationSeconds
         *        The duration, in seconds, of the privileged session. The value can range from 0 seconds up to the
         *        maximum session duration of 900 seconds (15 minutes). If you specify a value higher than this setting,
         *        the operation fails.</p>
         *        <p>
         *        By default, the value is set to <code>900</code> seconds.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder durationSeconds(Integer durationSeconds);

        @Override
        Builder overrideConfiguration(AwsRequestOverrideConfiguration overrideConfiguration);

        @Override
        Builder overrideConfiguration(Consumer<AwsRequestOverrideConfiguration.Builder> builderConsumer);
    }

    static final class BuilderImpl extends StsRequest.BuilderImpl implements Builder {
        private String targetPrincipal;

        private PolicyDescriptorType taskPolicyArn;

        private Integer durationSeconds;

        private BuilderImpl() {
        }

        private BuilderImpl(AssumeRootRequest model) {
            super(model);
            targetPrincipal(model.targetPrincipal);
            taskPolicyArn(model.taskPolicyArn);
            durationSeconds(model.durationSeconds);
        }

        public final String getTargetPrincipal() {
            return targetPrincipal;
        }

        public final void setTargetPrincipal(String targetPrincipal) {
            this.targetPrincipal = targetPrincipal;
        }

        @Override
        public final Builder targetPrincipal(String targetPrincipal) {
            this.targetPrincipal = targetPrincipal;
            return this;
        }

        public final PolicyDescriptorType.Builder getTaskPolicyArn() {
            return taskPolicyArn != null ? taskPolicyArn.toBuilder() : null;
        }

        public final void setTaskPolicyArn(PolicyDescriptorType.BuilderImpl taskPolicyArn) {
            this.taskPolicyArn = taskPolicyArn != null ? taskPolicyArn.build() : null;
        }

        @Override
        public final Builder taskPolicyArn(PolicyDescriptorType taskPolicyArn) {
            this.taskPolicyArn = taskPolicyArn;
            return this;
        }

        public final Integer getDurationSeconds() {
            return durationSeconds;
        }

        public final void setDurationSeconds(Integer durationSeconds) {
            this.durationSeconds = durationSeconds;
        }

        @Override
        public final Builder durationSeconds(Integer durationSeconds) {
            this.durationSeconds = durationSeconds;
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
        public AssumeRootRequest build() {
            return new AssumeRootRequest(this);
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
