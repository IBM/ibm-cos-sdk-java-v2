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

import java.util.Collections;
import java.util.List;
import java.util.Map;
import com.ibm.cos.v2.annotations.Generated;
import com.ibm.cos.v2.annotations.Mutable;
import com.ibm.cos.v2.annotations.NotThreadSafe;
import com.ibm.cos.v2.awscore.exception.AwsErrorDetails;
import com.ibm.cos.v2.core.SdkField;
import com.ibm.cos.v2.core.SdkPojo;
import com.ibm.cos.v2.utils.builder.CopyableBuilder;
import com.ibm.cos.v2.utils.builder.ToCopyableBuilder;

/**
 * <p>
 * The request was rejected because the associated CloudHSM cluster did not meet the configuration requirements for an
 * CloudHSM key store.
 * </p>
 * <ul>
 * <li>
 * <p>
 * The CloudHSM cluster must be configured with private subnets in at least two different Availability Zones in the
 * Region.
 * </p>
 * </li>
 * <li>
 * <p>
 * The <a href="https://docs.aws.amazon.com/cloudhsm/latest/userguide/configure-sg.html">security group for the
 * cluster</a> (cloudhsm-cluster-<i>&lt;cluster-id&gt;</i>-sg) must include inbound rules and outbound rules that allow
 * TCP traffic on ports 2223-2225. The <b>Source</b> in the inbound rules and the <b>Destination</b> in the outbound
 * rules must match the security group ID. These rules are set by default when you create the CloudHSM cluster. Do not
 * delete or change them. To get information about a particular security group, use the <a
 * href="https://docs.aws.amazon.com/AWSEC2/latest/APIReference/API_DescribeSecurityGroups.html"
 * >DescribeSecurityGroups</a> operation.
 * </p>
 * </li>
 * <li>
 * <p>
 * The CloudHSM cluster must contain at least as many HSMs as the operation requires. To add HSMs, use the CloudHSM <a
 * href="https://docs.aws.amazon.com/cloudhsm/latest/APIReference/API_CreateHsm.html">CreateHsm</a> operation.
 * </p>
 * <p>
 * For the <a>CreateCustomKeyStore</a>, <a>UpdateCustomKeyStore</a>, and <a>CreateKey</a> operations, the CloudHSM
 * cluster must have at least two active HSMs, each in a different Availability Zone. For the
 * <a>ConnectCustomKeyStore</a> operation, the CloudHSM must contain at least one active HSM.
 * </p>
 * </li>
 * </ul>
 * <p>
 * For information about the requirements for an CloudHSM cluster that is associated with an CloudHSM key store, see <a
 * href="https://docs.aws.amazon.com/kms/latest/developerguide/create-keystore.html#before-keystore">Assemble the
 * Prerequisites</a> in the <i>Key Management Service Developer Guide</i>. For information about creating a private
 * subnet for an CloudHSM cluster, see <a
 * href="https://docs.aws.amazon.com/cloudhsm/latest/userguide/create-subnets.html">Create a Private Subnet</a> in the
 * <i>CloudHSM User Guide</i>. For information about cluster security groups, see <a
 * href="https://docs.aws.amazon.com/cloudhsm/latest/userguide/configure-sg.html">Configure a Default Security Group</a>
 * in the <i> <i>CloudHSM User Guide</i> </i>.
 * </p>
 */
@Generated("com.ibm.cos.v2:codegen")
public final class CloudHsmClusterInvalidConfigurationException extends KmsException implements
        ToCopyableBuilder<CloudHsmClusterInvalidConfigurationException.Builder, CloudHsmClusterInvalidConfigurationException> {
    private static final List<SdkField<?>> SDK_FIELDS = Collections.emptyList();

    private static final Map<String, SdkField<?>> SDK_NAME_TO_FIELD = memberNameToFieldInitializer();

    private static final long serialVersionUID = 1L;

    private CloudHsmClusterInvalidConfigurationException(BuilderImpl builder) {
        super(builder);
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
    public final List<SdkField<?>> sdkFields() {
        return SDK_FIELDS;
    }

    @Override
    public final Map<String, SdkField<?>> sdkFieldNameToField() {
        return SDK_NAME_TO_FIELD;
    }

    private static Map<String, SdkField<?>> memberNameToFieldInitializer() {
        return Collections.emptyMap();
    }

    @Mutable
    @NotThreadSafe
    public interface Builder extends SdkPojo, CopyableBuilder<Builder, CloudHsmClusterInvalidConfigurationException>,
            KmsException.Builder {
        @Override
        Builder awsErrorDetails(AwsErrorDetails awsErrorDetails);

        @Override
        Builder message(String message);

        @Override
        Builder requestId(String requestId);

        @Override
        Builder statusCode(int statusCode);

        @Override
        Builder cause(Throwable cause);

        @Override
        Builder writableStackTrace(Boolean writableStackTrace);

        @Override
        Builder numAttempts(Integer numAttempts);
    }

    static final class BuilderImpl extends KmsException.BuilderImpl implements Builder {
        private BuilderImpl() {
        }

        private BuilderImpl(CloudHsmClusterInvalidConfigurationException model) {
            super(model);
        }

        @Override
        public BuilderImpl awsErrorDetails(AwsErrorDetails awsErrorDetails) {
            this.awsErrorDetails = awsErrorDetails;
            return this;
        }

        @Override
        public BuilderImpl message(String message) {
            this.message = message;
            return this;
        }

        @Override
        public BuilderImpl requestId(String requestId) {
            this.requestId = requestId;
            return this;
        }

        @Override
        public BuilderImpl statusCode(int statusCode) {
            this.statusCode = statusCode;
            return this;
        }

        @Override
        public BuilderImpl cause(Throwable cause) {
            this.cause = cause;
            return this;
        }

        @Override
        public BuilderImpl writableStackTrace(Boolean writableStackTrace) {
            this.writableStackTrace = writableStackTrace;
            return this;
        }

        @Override
        public BuilderImpl numAttempts(Integer numAttempts) {
            this.numAttempts = numAttempts;
            return this;
        }

        @Override
        public CloudHsmClusterInvalidConfigurationException build() {
            return new CloudHsmClusterInvalidConfigurationException(this);
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
