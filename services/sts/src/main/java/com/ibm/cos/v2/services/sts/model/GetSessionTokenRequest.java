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
public final class GetSessionTokenRequest extends StsRequest implements
        ToCopyableBuilder<GetSessionTokenRequest.Builder, GetSessionTokenRequest> {
    private static final SdkField<Integer> DURATION_SECONDS_FIELD = SdkField.<Integer> builder(MarshallingType.INTEGER)
            .memberName("DurationSeconds").getter(getter(GetSessionTokenRequest::durationSeconds))
            .setter(setter(Builder::durationSeconds))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("DurationSeconds").build()).build();

    private static final SdkField<String> SERIAL_NUMBER_FIELD = SdkField.<String> builder(MarshallingType.STRING)
            .memberName("SerialNumber").getter(getter(GetSessionTokenRequest::serialNumber))
            .setter(setter(Builder::serialNumber))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("SerialNumber").build()).build();

    private static final SdkField<String> TOKEN_CODE_FIELD = SdkField.<String> builder(MarshallingType.STRING)
            .memberName("TokenCode").getter(getter(GetSessionTokenRequest::tokenCode)).setter(setter(Builder::tokenCode))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("TokenCode").build()).build();

    private static final List<SdkField<?>> SDK_FIELDS = Collections.unmodifiableList(Arrays.asList(DURATION_SECONDS_FIELD,
            SERIAL_NUMBER_FIELD, TOKEN_CODE_FIELD));

    private static final Map<String, SdkField<?>> SDK_NAME_TO_FIELD = memberNameToFieldInitializer();

    private final Integer durationSeconds;

    private final String serialNumber;

    private final String tokenCode;

    private GetSessionTokenRequest(BuilderImpl builder) {
        super(builder);
        this.durationSeconds = builder.durationSeconds;
        this.serialNumber = builder.serialNumber;
        this.tokenCode = builder.tokenCode;
    }

    /**
     * <p>
     * The duration, in seconds, that the credentials should remain valid. Acceptable durations for IAM user sessions
     * range from 900 seconds (15 minutes) to 129,600 seconds (36 hours), with 43,200 seconds (12 hours) as the default.
     * Sessions for Amazon Web Services account owners are restricted to a maximum of 3,600 seconds (one hour). If the
     * duration is longer than one hour, the session for Amazon Web Services account owners defaults to one hour.
     * </p>
     * 
     * @return The duration, in seconds, that the credentials should remain valid. Acceptable durations for IAM user
     *         sessions range from 900 seconds (15 minutes) to 129,600 seconds (36 hours), with 43,200 seconds (12
     *         hours) as the default. Sessions for Amazon Web Services account owners are restricted to a maximum of
     *         3,600 seconds (one hour). If the duration is longer than one hour, the session for Amazon Web Services
     *         account owners defaults to one hour.
     */
    public final Integer durationSeconds() {
        return durationSeconds;
    }

    /**
     * <p>
     * The identification number of the MFA device that is associated with the IAM user who is making the
     * <code>GetSessionToken</code> call. Specify this value if the IAM user has a policy that requires MFA
     * authentication. The value is either the serial number for a hardware device (such as <code>GAHT12345678</code>)
     * or an Amazon Resource Name (ARN) for a virtual device (such as <code>arn:aws:iam::123456789012:mfa/user</code>).
     * You can find the device for an IAM user by going to the Amazon Web Services Management Console and viewing the
     * user's security credentials.
     * </p>
     * <p>
     * The regex used to validate this parameter is a string of characters consisting of upper- and lower-case
     * alphanumeric characters with no spaces. You can also include underscores or any of the following characters:
     * =,.@:/-
     * </p>
     * 
     * @return The identification number of the MFA device that is associated with the IAM user who is making the
     *         <code>GetSessionToken</code> call. Specify this value if the IAM user has a policy that requires MFA
     *         authentication. The value is either the serial number for a hardware device (such as
     *         <code>GAHT12345678</code>) or an Amazon Resource Name (ARN) for a virtual device (such as
     *         <code>arn:aws:iam::123456789012:mfa/user</code>). You can find the device for an IAM user by going to the
     *         Amazon Web Services Management Console and viewing the user's security credentials. </p>
     *         <p>
     *         The regex used to validate this parameter is a string of characters consisting of upper- and lower-case
     *         alphanumeric characters with no spaces. You can also include underscores or any of the following
     *         characters: =,.@:/-
     */
    public final String serialNumber() {
        return serialNumber;
    }

    /**
     * <p>
     * The value provided by the MFA device, if MFA is required. If any policy requires the IAM user to submit an MFA
     * code, specify this value. If MFA authentication is required, the user must provide a code when requesting a set
     * of temporary security credentials. A user who fails to provide the code receives an "access denied" response when
     * requesting resources that require MFA authentication.
     * </p>
     * <p>
     * The format for this parameter, as described by its regex pattern, is a sequence of six numeric digits.
     * </p>
     * 
     * @return The value provided by the MFA device, if MFA is required. If any policy requires the IAM user to submit
     *         an MFA code, specify this value. If MFA authentication is required, the user must provide a code when
     *         requesting a set of temporary security credentials. A user who fails to provide the code receives an
     *         "access denied" response when requesting resources that require MFA authentication.</p>
     *         <p>
     *         The format for this parameter, as described by its regex pattern, is a sequence of six numeric digits.
     */
    public final String tokenCode() {
        return tokenCode;
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
        hashCode = 31 * hashCode + Objects.hashCode(durationSeconds());
        hashCode = 31 * hashCode + Objects.hashCode(serialNumber());
        hashCode = 31 * hashCode + Objects.hashCode(tokenCode());
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
        if (!(obj instanceof GetSessionTokenRequest)) {
            return false;
        }
        GetSessionTokenRequest other = (GetSessionTokenRequest) obj;
        return Objects.equals(durationSeconds(), other.durationSeconds()) && Objects.equals(serialNumber(), other.serialNumber())
                && Objects.equals(tokenCode(), other.tokenCode());
    }

    /**
     * Returns a string representation of this object. This is useful for testing and debugging. Sensitive data will be
     * redacted from this string using a placeholder value.
     */
    @Override
    public final String toString() {
        return ToString.builder("GetSessionTokenRequest").add("DurationSeconds", durationSeconds())
                .add("SerialNumber", serialNumber()).add("TokenCode", tokenCode()).build();
    }

    public final <T> Optional<T> getValueForField(String fieldName, Class<T> clazz) {
        switch (fieldName) {
        case "DurationSeconds":
            return Optional.ofNullable(clazz.cast(durationSeconds()));
        case "SerialNumber":
            return Optional.ofNullable(clazz.cast(serialNumber()));
        case "TokenCode":
            return Optional.ofNullable(clazz.cast(tokenCode()));
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
        map.put("DurationSeconds", DURATION_SECONDS_FIELD);
        map.put("SerialNumber", SERIAL_NUMBER_FIELD);
        map.put("TokenCode", TOKEN_CODE_FIELD);
        return Collections.unmodifiableMap(map);
    }

    private static <T> Function<Object, T> getter(Function<GetSessionTokenRequest, T> g) {
        return obj -> g.apply((GetSessionTokenRequest) obj);
    }

    private static <T> BiConsumer<Object, T> setter(BiConsumer<Builder, T> s) {
        return (obj, val) -> s.accept((Builder) obj, val);
    }

    @Mutable
    @NotThreadSafe
    public interface Builder extends StsRequest.Builder, SdkPojo, CopyableBuilder<Builder, GetSessionTokenRequest> {
        /**
         * <p>
         * The duration, in seconds, that the credentials should remain valid. Acceptable durations for IAM user
         * sessions range from 900 seconds (15 minutes) to 129,600 seconds (36 hours), with 43,200 seconds (12 hours) as
         * the default. Sessions for Amazon Web Services account owners are restricted to a maximum of 3,600 seconds
         * (one hour). If the duration is longer than one hour, the session for Amazon Web Services account owners
         * defaults to one hour.
         * </p>
         * 
         * @param durationSeconds
         *        The duration, in seconds, that the credentials should remain valid. Acceptable durations for IAM user
         *        sessions range from 900 seconds (15 minutes) to 129,600 seconds (36 hours), with 43,200 seconds (12
         *        hours) as the default. Sessions for Amazon Web Services account owners are restricted to a maximum of
         *        3,600 seconds (one hour). If the duration is longer than one hour, the session for Amazon Web Services
         *        account owners defaults to one hour.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder durationSeconds(Integer durationSeconds);

        /**
         * <p>
         * The identification number of the MFA device that is associated with the IAM user who is making the
         * <code>GetSessionToken</code> call. Specify this value if the IAM user has a policy that requires MFA
         * authentication. The value is either the serial number for a hardware device (such as
         * <code>GAHT12345678</code>) or an Amazon Resource Name (ARN) for a virtual device (such as
         * <code>arn:aws:iam::123456789012:mfa/user</code>). You can find the device for an IAM user by going to the
         * Amazon Web Services Management Console and viewing the user's security credentials.
         * </p>
         * <p>
         * The regex used to validate this parameter is a string of characters consisting of upper- and lower-case
         * alphanumeric characters with no spaces. You can also include underscores or any of the following characters:
         * =,.@:/-
         * </p>
         * 
         * @param serialNumber
         *        The identification number of the MFA device that is associated with the IAM user who is making the
         *        <code>GetSessionToken</code> call. Specify this value if the IAM user has a policy that requires MFA
         *        authentication. The value is either the serial number for a hardware device (such as
         *        <code>GAHT12345678</code>) or an Amazon Resource Name (ARN) for a virtual device (such as
         *        <code>arn:aws:iam::123456789012:mfa/user</code>). You can find the device for an IAM user by going to
         *        the Amazon Web Services Management Console and viewing the user's security credentials. </p>
         *        <p>
         *        The regex used to validate this parameter is a string of characters consisting of upper- and
         *        lower-case alphanumeric characters with no spaces. You can also include underscores or any of the
         *        following characters: =,.@:/-
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder serialNumber(String serialNumber);

        /**
         * <p>
         * The value provided by the MFA device, if MFA is required. If any policy requires the IAM user to submit an
         * MFA code, specify this value. If MFA authentication is required, the user must provide a code when requesting
         * a set of temporary security credentials. A user who fails to provide the code receives an "access denied"
         * response when requesting resources that require MFA authentication.
         * </p>
         * <p>
         * The format for this parameter, as described by its regex pattern, is a sequence of six numeric digits.
         * </p>
         * 
         * @param tokenCode
         *        The value provided by the MFA device, if MFA is required. If any policy requires the IAM user to
         *        submit an MFA code, specify this value. If MFA authentication is required, the user must provide a
         *        code when requesting a set of temporary security credentials. A user who fails to provide the code
         *        receives an "access denied" response when requesting resources that require MFA authentication.</p>
         *        <p>
         *        The format for this parameter, as described by its regex pattern, is a sequence of six numeric digits.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder tokenCode(String tokenCode);

        @Override
        Builder overrideConfiguration(AwsRequestOverrideConfiguration overrideConfiguration);

        @Override
        Builder overrideConfiguration(Consumer<AwsRequestOverrideConfiguration.Builder> builderConsumer);
    }

    static final class BuilderImpl extends StsRequest.BuilderImpl implements Builder {
        private Integer durationSeconds;

        private String serialNumber;

        private String tokenCode;

        private BuilderImpl() {
        }

        private BuilderImpl(GetSessionTokenRequest model) {
            super(model);
            durationSeconds(model.durationSeconds);
            serialNumber(model.serialNumber);
            tokenCode(model.tokenCode);
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

        public final String getSerialNumber() {
            return serialNumber;
        }

        public final void setSerialNumber(String serialNumber) {
            this.serialNumber = serialNumber;
        }

        @Override
        public final Builder serialNumber(String serialNumber) {
            this.serialNumber = serialNumber;
            return this;
        }

        public final String getTokenCode() {
            return tokenCode;
        }

        public final void setTokenCode(String tokenCode) {
            this.tokenCode = tokenCode;
        }

        @Override
        public final Builder tokenCode(String tokenCode) {
            this.tokenCode = tokenCode;
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
        public GetSessionTokenRequest build() {
            return new GetSessionTokenRequest(this);
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
