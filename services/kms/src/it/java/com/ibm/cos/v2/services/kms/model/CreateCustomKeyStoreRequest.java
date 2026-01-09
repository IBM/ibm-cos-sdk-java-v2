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
public final class CreateCustomKeyStoreRequest extends KmsRequest implements
        ToCopyableBuilder<CreateCustomKeyStoreRequest.Builder, CreateCustomKeyStoreRequest> {
    private static final SdkField<String> CUSTOM_KEY_STORE_NAME_FIELD = SdkField.<String> builder(MarshallingType.STRING)
            .memberName("CustomKeyStoreName").getter(getter(CreateCustomKeyStoreRequest::customKeyStoreName))
            .setter(setter(Builder::customKeyStoreName))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("CustomKeyStoreName").build())
            .build();

    private static final SdkField<String> CLOUD_HSM_CLUSTER_ID_FIELD = SdkField.<String> builder(MarshallingType.STRING)
            .memberName("CloudHsmClusterId").getter(getter(CreateCustomKeyStoreRequest::cloudHsmClusterId))
            .setter(setter(Builder::cloudHsmClusterId))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("CloudHsmClusterId").build()).build();

    private static final SdkField<String> TRUST_ANCHOR_CERTIFICATE_FIELD = SdkField.<String> builder(MarshallingType.STRING)
            .memberName("TrustAnchorCertificate").getter(getter(CreateCustomKeyStoreRequest::trustAnchorCertificate))
            .setter(setter(Builder::trustAnchorCertificate))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("TrustAnchorCertificate").build())
            .build();

    private static final SdkField<String> KEY_STORE_PASSWORD_FIELD = SdkField.<String> builder(MarshallingType.STRING)
            .memberName("KeyStorePassword").getter(getter(CreateCustomKeyStoreRequest::keyStorePassword))
            .setter(setter(Builder::keyStorePassword))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("KeyStorePassword").build()).build();

    private static final SdkField<String> CUSTOM_KEY_STORE_TYPE_FIELD = SdkField.<String> builder(MarshallingType.STRING)
            .memberName("CustomKeyStoreType").getter(getter(CreateCustomKeyStoreRequest::customKeyStoreTypeAsString))
            .setter(setter(Builder::customKeyStoreType))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("CustomKeyStoreType").build())
            .build();

    private static final SdkField<String> XKS_PROXY_URI_ENDPOINT_FIELD = SdkField.<String> builder(MarshallingType.STRING)
            .memberName("XksProxyUriEndpoint").getter(getter(CreateCustomKeyStoreRequest::xksProxyUriEndpoint))
            .setter(setter(Builder::xksProxyUriEndpoint))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("XksProxyUriEndpoint").build())
            .build();

    private static final SdkField<String> XKS_PROXY_URI_PATH_FIELD = SdkField.<String> builder(MarshallingType.STRING)
            .memberName("XksProxyUriPath").getter(getter(CreateCustomKeyStoreRequest::xksProxyUriPath))
            .setter(setter(Builder::xksProxyUriPath))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("XksProxyUriPath").build()).build();

    private static final SdkField<String> XKS_PROXY_VPC_ENDPOINT_SERVICE_NAME_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("XksProxyVpcEndpointServiceName")
            .getter(getter(CreateCustomKeyStoreRequest::xksProxyVpcEndpointServiceName))
            .setter(setter(Builder::xksProxyVpcEndpointServiceName))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("XksProxyVpcEndpointServiceName")
                    .build()).build();

    private static final SdkField<XksProxyAuthenticationCredentialType> XKS_PROXY_AUTHENTICATION_CREDENTIAL_FIELD = SdkField
            .<XksProxyAuthenticationCredentialType> builder(MarshallingType.SDK_POJO)
            .memberName("XksProxyAuthenticationCredential")
            .getter(getter(CreateCustomKeyStoreRequest::xksProxyAuthenticationCredential))
            .setter(setter(Builder::xksProxyAuthenticationCredential))
            .constructor(XksProxyAuthenticationCredentialType::builder)
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("XksProxyAuthenticationCredential")
                    .build()).build();

    private static final SdkField<String> XKS_PROXY_CONNECTIVITY_FIELD = SdkField.<String> builder(MarshallingType.STRING)
            .memberName("XksProxyConnectivity").getter(getter(CreateCustomKeyStoreRequest::xksProxyConnectivityAsString))
            .setter(setter(Builder::xksProxyConnectivity))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("XksProxyConnectivity").build())
            .build();

    private static final List<SdkField<?>> SDK_FIELDS = Collections.unmodifiableList(Arrays.asList(CUSTOM_KEY_STORE_NAME_FIELD,
            CLOUD_HSM_CLUSTER_ID_FIELD, TRUST_ANCHOR_CERTIFICATE_FIELD, KEY_STORE_PASSWORD_FIELD, CUSTOM_KEY_STORE_TYPE_FIELD,
            XKS_PROXY_URI_ENDPOINT_FIELD, XKS_PROXY_URI_PATH_FIELD, XKS_PROXY_VPC_ENDPOINT_SERVICE_NAME_FIELD,
            XKS_PROXY_AUTHENTICATION_CREDENTIAL_FIELD, XKS_PROXY_CONNECTIVITY_FIELD));

    private static final Map<String, SdkField<?>> SDK_NAME_TO_FIELD = memberNameToFieldInitializer();

    private final String customKeyStoreName;

    private final String cloudHsmClusterId;

    private final String trustAnchorCertificate;

    private final String keyStorePassword;

    private final String customKeyStoreType;

    private final String xksProxyUriEndpoint;

    private final String xksProxyUriPath;

    private final String xksProxyVpcEndpointServiceName;

    private final XksProxyAuthenticationCredentialType xksProxyAuthenticationCredential;

    private final String xksProxyConnectivity;

    private CreateCustomKeyStoreRequest(BuilderImpl builder) {
        super(builder);
        this.customKeyStoreName = builder.customKeyStoreName;
        this.cloudHsmClusterId = builder.cloudHsmClusterId;
        this.trustAnchorCertificate = builder.trustAnchorCertificate;
        this.keyStorePassword = builder.keyStorePassword;
        this.customKeyStoreType = builder.customKeyStoreType;
        this.xksProxyUriEndpoint = builder.xksProxyUriEndpoint;
        this.xksProxyUriPath = builder.xksProxyUriPath;
        this.xksProxyVpcEndpointServiceName = builder.xksProxyVpcEndpointServiceName;
        this.xksProxyAuthenticationCredential = builder.xksProxyAuthenticationCredential;
        this.xksProxyConnectivity = builder.xksProxyConnectivity;
    }

    /**
     * <p>
     * Specifies a friendly name for the custom key store. The name must be unique in your Amazon Web Services account
     * and Region. This parameter is required for all custom key stores.
     * </p>
     * <important>
     * <p>
     * Do not include confidential or sensitive information in this field. This field may be displayed in plaintext in
     * CloudTrail logs and other output.
     * </p>
     * </important>
     * 
     * @return Specifies a friendly name for the custom key store. The name must be unique in your Amazon Web Services
     *         account and Region. This parameter is required for all custom key stores.</p> <important>
     *         <p>
     *         Do not include confidential or sensitive information in this field. This field may be displayed in
     *         plaintext in CloudTrail logs and other output.
     *         </p>
     */
    public final String customKeyStoreName() {
        return customKeyStoreName;
    }

    /**
     * <p>
     * Identifies the CloudHSM cluster for an CloudHSM key store. This parameter is required for custom key stores with
     * <code>CustomKeyStoreType</code> of <code>AWS_CLOUDHSM</code>.
     * </p>
     * <p>
     * Enter the cluster ID of any active CloudHSM cluster that is not already associated with a custom key store. To
     * find the cluster ID, use the <a
     * href="https://docs.aws.amazon.com/cloudhsm/latest/APIReference/API_DescribeClusters.html">DescribeClusters</a>
     * operation.
     * </p>
     * 
     * @return Identifies the CloudHSM cluster for an CloudHSM key store. This parameter is required for custom key
     *         stores with <code>CustomKeyStoreType</code> of <code>AWS_CLOUDHSM</code>.</p>
     *         <p>
     *         Enter the cluster ID of any active CloudHSM cluster that is not already associated with a custom key
     *         store. To find the cluster ID, use the <a
     *         href="https://docs.aws.amazon.com/cloudhsm/latest/APIReference/API_DescribeClusters.html"
     *         >DescribeClusters</a> operation.
     */
    public final String cloudHsmClusterId() {
        return cloudHsmClusterId;
    }

    /**
     * <p>
     * Specifies the certificate for an CloudHSM key store. This parameter is required for custom key stores with a
     * <code>CustomKeyStoreType</code> of <code>AWS_CLOUDHSM</code>.
     * </p>
     * <p>
     * Enter the content of the trust anchor certificate for the CloudHSM cluster. This is the content of the
     * <code>customerCA.crt</code> file that you created when you <a
     * href="https://docs.aws.amazon.com/cloudhsm/latest/userguide/initialize-cluster.html">initialized the cluster</a>.
     * </p>
     * 
     * @return Specifies the certificate for an CloudHSM key store. This parameter is required for custom key stores
     *         with a <code>CustomKeyStoreType</code> of <code>AWS_CLOUDHSM</code>.</p>
     *         <p>
     *         Enter the content of the trust anchor certificate for the CloudHSM cluster. This is the content of the
     *         <code>customerCA.crt</code> file that you created when you <a
     *         href="https://docs.aws.amazon.com/cloudhsm/latest/userguide/initialize-cluster.html">initialized the
     *         cluster</a>.
     */
    public final String trustAnchorCertificate() {
        return trustAnchorCertificate;
    }

    /**
     * <p>
     * Specifies the <code>kmsuser</code> password for an CloudHSM key store. This parameter is required for custom key
     * stores with a <code>CustomKeyStoreType</code> of <code>AWS_CLOUDHSM</code>.
     * </p>
     * <p>
     * Enter the password of the <a
     * href="https://docs.aws.amazon.com/kms/latest/developerguide/key-store-concepts.html#concept-kmsuser">
     * <code>kmsuser</code> crypto user (CU) account</a> in the specified CloudHSM cluster. KMS logs into the cluster as
     * this user to manage key material on your behalf.
     * </p>
     * <p>
     * The password must be a string of 7 to 32 characters. Its value is case sensitive.
     * </p>
     * <p>
     * This parameter tells KMS the <code>kmsuser</code> account password; it does not change the password in the
     * CloudHSM cluster.
     * </p>
     * 
     * @return Specifies the <code>kmsuser</code> password for an CloudHSM key store. This parameter is required for
     *         custom key stores with a <code>CustomKeyStoreType</code> of <code>AWS_CLOUDHSM</code>.</p>
     *         <p>
     *         Enter the password of the <a
     *         href="https://docs.aws.amazon.com/kms/latest/developerguide/key-store-concepts.html#concept-kmsuser">
     *         <code>kmsuser</code> crypto user (CU) account</a> in the specified CloudHSM cluster. KMS logs into the
     *         cluster as this user to manage key material on your behalf.
     *         </p>
     *         <p>
     *         The password must be a string of 7 to 32 characters. Its value is case sensitive.
     *         </p>
     *         <p>
     *         This parameter tells KMS the <code>kmsuser</code> account password; it does not change the password in
     *         the CloudHSM cluster.
     */
    public final String keyStorePassword() {
        return keyStorePassword;
    }

    /**
     * <p>
     * Specifies the type of custom key store. The default value is <code>AWS_CLOUDHSM</code>.
     * </p>
     * <p>
     * For a custom key store backed by an CloudHSM cluster, omit the parameter or enter <code>AWS_CLOUDHSM</code>. For
     * a custom key store backed by an external key manager outside of Amazon Web Services, enter
     * <code>EXTERNAL_KEY_STORE</code>. You cannot change this property after the key store is created.
     * </p>
     * <p>
     * If the service returns an enum value that is not available in the current SDK version,
     * {@link #customKeyStoreType} will return {@link CustomKeyStoreType#UNKNOWN_TO_SDK_VERSION}. The raw value returned
     * by the service is available from {@link #customKeyStoreTypeAsString}.
     * </p>
     * 
     * @return Specifies the type of custom key store. The default value is <code>AWS_CLOUDHSM</code>.</p>
     *         <p>
     *         For a custom key store backed by an CloudHSM cluster, omit the parameter or enter
     *         <code>AWS_CLOUDHSM</code>. For a custom key store backed by an external key manager outside of Amazon Web
     *         Services, enter <code>EXTERNAL_KEY_STORE</code>. You cannot change this property after the key store is
     *         created.
     * @see CustomKeyStoreType
     */
    public final CustomKeyStoreType customKeyStoreType() {
        return CustomKeyStoreType.fromValue(customKeyStoreType);
    }

    /**
     * <p>
     * Specifies the type of custom key store. The default value is <code>AWS_CLOUDHSM</code>.
     * </p>
     * <p>
     * For a custom key store backed by an CloudHSM cluster, omit the parameter or enter <code>AWS_CLOUDHSM</code>. For
     * a custom key store backed by an external key manager outside of Amazon Web Services, enter
     * <code>EXTERNAL_KEY_STORE</code>. You cannot change this property after the key store is created.
     * </p>
     * <p>
     * If the service returns an enum value that is not available in the current SDK version,
     * {@link #customKeyStoreType} will return {@link CustomKeyStoreType#UNKNOWN_TO_SDK_VERSION}. The raw value returned
     * by the service is available from {@link #customKeyStoreTypeAsString}.
     * </p>
     * 
     * @return Specifies the type of custom key store. The default value is <code>AWS_CLOUDHSM</code>.</p>
     *         <p>
     *         For a custom key store backed by an CloudHSM cluster, omit the parameter or enter
     *         <code>AWS_CLOUDHSM</code>. For a custom key store backed by an external key manager outside of Amazon Web
     *         Services, enter <code>EXTERNAL_KEY_STORE</code>. You cannot change this property after the key store is
     *         created.
     * @see CustomKeyStoreType
     */
    public final String customKeyStoreTypeAsString() {
        return customKeyStoreType;
    }

    /**
     * <p>
     * Specifies the endpoint that KMS uses to send requests to the external key store proxy (XKS proxy). This parameter
     * is required for custom key stores with a <code>CustomKeyStoreType</code> of <code>EXTERNAL_KEY_STORE</code>.
     * </p>
     * <p>
     * The protocol must be HTTPS. KMS communicates on port 443. Do not specify the port in the
     * <code>XksProxyUriEndpoint</code> value.
     * </p>
     * <p>
     * For external key stores with <code>XksProxyConnectivity</code> value of <code>VPC_ENDPOINT_SERVICE</code>,
     * specify <code>https://</code> followed by the private DNS name of the VPC endpoint service.
     * </p>
     * <p>
     * For external key stores with <code>PUBLIC_ENDPOINT</code> connectivity, this endpoint must be reachable before
     * you create the custom key store. KMS connects to the external key store proxy while creating the custom key
     * store. For external key stores with <code>VPC_ENDPOINT_SERVICE</code> connectivity, KMS connects when you call
     * the <a>ConnectCustomKeyStore</a> operation.
     * </p>
     * <p>
     * The value of this parameter must begin with <code>https://</code>. The remainder can contain upper and lower case
     * letters (A-Z and a-z), numbers (0-9), dots (<code>.</code>), and hyphens (<code>-</code>). Additional slashes (
     * <code>/</code> and <code>\</code>) are not permitted.
     * </p>
     * <p>
     * <b>Uniqueness requirements: </b>
     * </p>
     * <ul>
     * <li>
     * <p>
     * The combined <code>XksProxyUriEndpoint</code> and <code>XksProxyUriPath</code> values must be unique in the
     * Amazon Web Services account and Region.
     * </p>
     * </li>
     * <li>
     * <p>
     * An external key store with <code>PUBLIC_ENDPOINT</code> connectivity cannot use the same
     * <code>XksProxyUriEndpoint</code> value as an external key store with <code>VPC_ENDPOINT_SERVICE</code>
     * connectivity in this Amazon Web Services Region.
     * </p>
     * </li>
     * <li>
     * <p>
     * Each external key store with <code>VPC_ENDPOINT_SERVICE</code> connectivity must have its own private DNS name.
     * The <code>XksProxyUriEndpoint</code> value for external key stores with <code>VPC_ENDPOINT_SERVICE</code>
     * connectivity (private DNS name) must be unique in the Amazon Web Services account and Region.
     * </p>
     * </li>
     * </ul>
     * 
     * @return Specifies the endpoint that KMS uses to send requests to the external key store proxy (XKS proxy). This
     *         parameter is required for custom key stores with a <code>CustomKeyStoreType</code> of
     *         <code>EXTERNAL_KEY_STORE</code>.</p>
     *         <p>
     *         The protocol must be HTTPS. KMS communicates on port 443. Do not specify the port in the
     *         <code>XksProxyUriEndpoint</code> value.
     *         </p>
     *         <p>
     *         For external key stores with <code>XksProxyConnectivity</code> value of <code>VPC_ENDPOINT_SERVICE</code>
     *         , specify <code>https://</code> followed by the private DNS name of the VPC endpoint service.
     *         </p>
     *         <p>
     *         For external key stores with <code>PUBLIC_ENDPOINT</code> connectivity, this endpoint must be reachable
     *         before you create the custom key store. KMS connects to the external key store proxy while creating the
     *         custom key store. For external key stores with <code>VPC_ENDPOINT_SERVICE</code> connectivity, KMS
     *         connects when you call the <a>ConnectCustomKeyStore</a> operation.
     *         </p>
     *         <p>
     *         The value of this parameter must begin with <code>https://</code>. The remainder can contain upper and
     *         lower case letters (A-Z and a-z), numbers (0-9), dots (<code>.</code>), and hyphens (<code>-</code>).
     *         Additional slashes (<code>/</code> and <code>\</code>) are not permitted.
     *         </p>
     *         <p>
     *         <b>Uniqueness requirements: </b>
     *         </p>
     *         <ul>
     *         <li>
     *         <p>
     *         The combined <code>XksProxyUriEndpoint</code> and <code>XksProxyUriPath</code> values must be unique in
     *         the Amazon Web Services account and Region.
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         An external key store with <code>PUBLIC_ENDPOINT</code> connectivity cannot use the same
     *         <code>XksProxyUriEndpoint</code> value as an external key store with <code>VPC_ENDPOINT_SERVICE</code>
     *         connectivity in this Amazon Web Services Region.
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         Each external key store with <code>VPC_ENDPOINT_SERVICE</code> connectivity must have its own private DNS
     *         name. The <code>XksProxyUriEndpoint</code> value for external key stores with
     *         <code>VPC_ENDPOINT_SERVICE</code> connectivity (private DNS name) must be unique in the Amazon Web
     *         Services account and Region.
     *         </p>
     *         </li>
     */
    public final String xksProxyUriEndpoint() {
        return xksProxyUriEndpoint;
    }

    /**
     * <p>
     * Specifies the base path to the proxy APIs for this external key store. To find this value, see the documentation
     * for your external key store proxy. This parameter is required for all custom key stores with a
     * <code>CustomKeyStoreType</code> of <code>EXTERNAL_KEY_STORE</code>.
     * </p>
     * <p>
     * The value must start with <code>/</code> and must end with <code>/kms/xks/v1</code> where <code>v1</code>
     * represents the version of the KMS external key store proxy API. This path can include an optional prefix between
     * the required elements such as <code>/<i>prefix</i>/kms/xks/v1</code>.
     * </p>
     * <p>
     * <b>Uniqueness requirements: </b>
     * </p>
     * <ul>
     * <li>
     * <p>
     * The combined <code>XksProxyUriEndpoint</code> and <code>XksProxyUriPath</code> values must be unique in the
     * Amazon Web Services account and Region.
     * </p>
     * </li>
     * </ul>
     * 
     * @return Specifies the base path to the proxy APIs for this external key store. To find this value, see the
     *         documentation for your external key store proxy. This parameter is required for all custom key stores
     *         with a <code>CustomKeyStoreType</code> of <code>EXTERNAL_KEY_STORE</code>.</p>
     *         <p>
     *         The value must start with <code>/</code> and must end with <code>/kms/xks/v1</code> where <code>v1</code>
     *         represents the version of the KMS external key store proxy API. This path can include an optional prefix
     *         between the required elements such as <code>/<i>prefix</i>/kms/xks/v1</code>.
     *         </p>
     *         <p>
     *         <b>Uniqueness requirements: </b>
     *         </p>
     *         <ul>
     *         <li>
     *         <p>
     *         The combined <code>XksProxyUriEndpoint</code> and <code>XksProxyUriPath</code> values must be unique in
     *         the Amazon Web Services account and Region.
     *         </p>
     *         </li>
     */
    public final String xksProxyUriPath() {
        return xksProxyUriPath;
    }

    /**
     * <p>
     * Specifies the name of the Amazon VPC endpoint service for interface endpoints that is used to communicate with
     * your external key store proxy (XKS proxy). This parameter is required when the value of
     * <code>CustomKeyStoreType</code> is <code>EXTERNAL_KEY_STORE</code> and the value of
     * <code>XksProxyConnectivity</code> is <code>VPC_ENDPOINT_SERVICE</code>.
     * </p>
     * <p>
     * The Amazon VPC endpoint service must <a
     * href="https://docs.aws.amazon.com/kms/latest/developerguide/create-xks-keystore.html#xks-requirements">fulfill
     * all requirements</a> for use with an external key store.
     * </p>
     * <p>
     * <b>Uniqueness requirements:</b>
     * </p>
     * <ul>
     * <li>
     * <p>
     * External key stores with <code>VPC_ENDPOINT_SERVICE</code> connectivity can share an Amazon VPC, but each
     * external key store must have its own VPC endpoint service and private DNS name.
     * </p>
     * </li>
     * </ul>
     * 
     * @return Specifies the name of the Amazon VPC endpoint service for interface endpoints that is used to communicate
     *         with your external key store proxy (XKS proxy). This parameter is required when the value of
     *         <code>CustomKeyStoreType</code> is <code>EXTERNAL_KEY_STORE</code> and the value of
     *         <code>XksProxyConnectivity</code> is <code>VPC_ENDPOINT_SERVICE</code>.</p>
     *         <p>
     *         The Amazon VPC endpoint service must <a
     *         href="https://docs.aws.amazon.com/kms/latest/developerguide/create-xks-keystore.html#xks-requirements"
     *         >fulfill all requirements</a> for use with an external key store.
     *         </p>
     *         <p>
     *         <b>Uniqueness requirements:</b>
     *         </p>
     *         <ul>
     *         <li>
     *         <p>
     *         External key stores with <code>VPC_ENDPOINT_SERVICE</code> connectivity can share an Amazon VPC, but each
     *         external key store must have its own VPC endpoint service and private DNS name.
     *         </p>
     *         </li>
     */
    public final String xksProxyVpcEndpointServiceName() {
        return xksProxyVpcEndpointServiceName;
    }

    /**
     * <p>
     * Specifies an authentication credential for the external key store proxy (XKS proxy). This parameter is required
     * for all custom key stores with a <code>CustomKeyStoreType</code> of <code>EXTERNAL_KEY_STORE</code>.
     * </p>
     * <p>
     * The <code>XksProxyAuthenticationCredential</code> has two required elements: <code>RawSecretAccessKey</code>, a
     * secret key, and <code>AccessKeyId</code>, a unique identifier for the <code>RawSecretAccessKey</code>. For
     * character requirements, see <a href="kms/latest/APIReference/API_XksProxyAuthenticationCredentialType.html">
     * XksProxyAuthenticationCredentialType</a>.
     * </p>
     * <p>
     * KMS uses this authentication credential to sign requests to the external key store proxy on your behalf. This
     * credential is unrelated to Identity and Access Management (IAM) and Amazon Web Services credentials.
     * </p>
     * <p>
     * This parameter doesn't set or change the authentication credentials on the XKS proxy. It just tells KMS the
     * credential that you established on your external key store proxy. If you rotate your proxy authentication
     * credential, use the <a>UpdateCustomKeyStore</a> operation to provide the new credential to KMS.
     * </p>
     * 
     * @return Specifies an authentication credential for the external key store proxy (XKS proxy). This parameter is
     *         required for all custom key stores with a <code>CustomKeyStoreType</code> of
     *         <code>EXTERNAL_KEY_STORE</code>.</p>
     *         <p>
     *         The <code>XksProxyAuthenticationCredential</code> has two required elements:
     *         <code>RawSecretAccessKey</code>, a secret key, and <code>AccessKeyId</code>, a unique identifier for the
     *         <code>RawSecretAccessKey</code>. For character requirements, see <a
     *         href="kms/latest/APIReference/API_XksProxyAuthenticationCredentialType.html"
     *         >XksProxyAuthenticationCredentialType</a>.
     *         </p>
     *         <p>
     *         KMS uses this authentication credential to sign requests to the external key store proxy on your behalf.
     *         This credential is unrelated to Identity and Access Management (IAM) and Amazon Web Services credentials.
     *         </p>
     *         <p>
     *         This parameter doesn't set or change the authentication credentials on the XKS proxy. It just tells KMS
     *         the credential that you established on your external key store proxy. If you rotate your proxy
     *         authentication credential, use the <a>UpdateCustomKeyStore</a> operation to provide the new credential to
     *         KMS.
     */
    public final XksProxyAuthenticationCredentialType xksProxyAuthenticationCredential() {
        return xksProxyAuthenticationCredential;
    }

    /**
     * <p>
     * Indicates how KMS communicates with the external key store proxy. This parameter is required for custom key
     * stores with a <code>CustomKeyStoreType</code> of <code>EXTERNAL_KEY_STORE</code>.
     * </p>
     * <p>
     * If the external key store proxy uses a public endpoint, specify <code>PUBLIC_ENDPOINT</code>. If the external key
     * store proxy uses a Amazon VPC endpoint service for communication with KMS, specify
     * <code>VPC_ENDPOINT_SERVICE</code>. For help making this choice, see <a
     * href="https://docs.aws.amazon.com/kms/latest/developerguide/plan-xks-keystore.html#choose-xks-connectivity"
     * >Choosing a connectivity option</a> in the <i>Key Management Service Developer Guide</i>.
     * </p>
     * <p>
     * An Amazon VPC endpoint service keeps your communication with KMS in a private address space entirely within
     * Amazon Web Services, but it requires more configuration, including establishing a Amazon VPC with multiple
     * subnets, a VPC endpoint service, a network load balancer, and a verified private DNS name. A public endpoint is
     * simpler to set up, but it might be slower and might not fulfill your security requirements. You might consider
     * testing with a public endpoint, and then establishing a VPC endpoint service for production tasks. Note that this
     * choice does not determine the location of the external key store proxy. Even if you choose a VPC endpoint
     * service, the proxy can be hosted within the VPC or outside of Amazon Web Services such as in your corporate data
     * center.
     * </p>
     * <p>
     * If the service returns an enum value that is not available in the current SDK version,
     * {@link #xksProxyConnectivity} will return {@link XksProxyConnectivityType#UNKNOWN_TO_SDK_VERSION}. The raw value
     * returned by the service is available from {@link #xksProxyConnectivityAsString}.
     * </p>
     * 
     * @return Indicates how KMS communicates with the external key store proxy. This parameter is required for custom
     *         key stores with a <code>CustomKeyStoreType</code> of <code>EXTERNAL_KEY_STORE</code>.</p>
     *         <p>
     *         If the external key store proxy uses a public endpoint, specify <code>PUBLIC_ENDPOINT</code>. If the
     *         external key store proxy uses a Amazon VPC endpoint service for communication with KMS, specify
     *         <code>VPC_ENDPOINT_SERVICE</code>. For help making this choice, see <a
     *         href="https://docs.aws.amazon.com/kms/latest/developerguide/plan-xks-keystore.html#choose-xks-connectivity"
     *         >Choosing a connectivity option</a> in the <i>Key Management Service Developer Guide</i>.
     *         </p>
     *         <p>
     *         An Amazon VPC endpoint service keeps your communication with KMS in a private address space entirely
     *         within Amazon Web Services, but it requires more configuration, including establishing a Amazon VPC with
     *         multiple subnets, a VPC endpoint service, a network load balancer, and a verified private DNS name. A
     *         public endpoint is simpler to set up, but it might be slower and might not fulfill your security
     *         requirements. You might consider testing with a public endpoint, and then establishing a VPC endpoint
     *         service for production tasks. Note that this choice does not determine the location of the external key
     *         store proxy. Even if you choose a VPC endpoint service, the proxy can be hosted within the VPC or outside
     *         of Amazon Web Services such as in your corporate data center.
     * @see XksProxyConnectivityType
     */
    public final XksProxyConnectivityType xksProxyConnectivity() {
        return XksProxyConnectivityType.fromValue(xksProxyConnectivity);
    }

    /**
     * <p>
     * Indicates how KMS communicates with the external key store proxy. This parameter is required for custom key
     * stores with a <code>CustomKeyStoreType</code> of <code>EXTERNAL_KEY_STORE</code>.
     * </p>
     * <p>
     * If the external key store proxy uses a public endpoint, specify <code>PUBLIC_ENDPOINT</code>. If the external key
     * store proxy uses a Amazon VPC endpoint service for communication with KMS, specify
     * <code>VPC_ENDPOINT_SERVICE</code>. For help making this choice, see <a
     * href="https://docs.aws.amazon.com/kms/latest/developerguide/plan-xks-keystore.html#choose-xks-connectivity"
     * >Choosing a connectivity option</a> in the <i>Key Management Service Developer Guide</i>.
     * </p>
     * <p>
     * An Amazon VPC endpoint service keeps your communication with KMS in a private address space entirely within
     * Amazon Web Services, but it requires more configuration, including establishing a Amazon VPC with multiple
     * subnets, a VPC endpoint service, a network load balancer, and a verified private DNS name. A public endpoint is
     * simpler to set up, but it might be slower and might not fulfill your security requirements. You might consider
     * testing with a public endpoint, and then establishing a VPC endpoint service for production tasks. Note that this
     * choice does not determine the location of the external key store proxy. Even if you choose a VPC endpoint
     * service, the proxy can be hosted within the VPC or outside of Amazon Web Services such as in your corporate data
     * center.
     * </p>
     * <p>
     * If the service returns an enum value that is not available in the current SDK version,
     * {@link #xksProxyConnectivity} will return {@link XksProxyConnectivityType#UNKNOWN_TO_SDK_VERSION}. The raw value
     * returned by the service is available from {@link #xksProxyConnectivityAsString}.
     * </p>
     * 
     * @return Indicates how KMS communicates with the external key store proxy. This parameter is required for custom
     *         key stores with a <code>CustomKeyStoreType</code> of <code>EXTERNAL_KEY_STORE</code>.</p>
     *         <p>
     *         If the external key store proxy uses a public endpoint, specify <code>PUBLIC_ENDPOINT</code>. If the
     *         external key store proxy uses a Amazon VPC endpoint service for communication with KMS, specify
     *         <code>VPC_ENDPOINT_SERVICE</code>. For help making this choice, see <a
     *         href="https://docs.aws.amazon.com/kms/latest/developerguide/plan-xks-keystore.html#choose-xks-connectivity"
     *         >Choosing a connectivity option</a> in the <i>Key Management Service Developer Guide</i>.
     *         </p>
     *         <p>
     *         An Amazon VPC endpoint service keeps your communication with KMS in a private address space entirely
     *         within Amazon Web Services, but it requires more configuration, including establishing a Amazon VPC with
     *         multiple subnets, a VPC endpoint service, a network load balancer, and a verified private DNS name. A
     *         public endpoint is simpler to set up, but it might be slower and might not fulfill your security
     *         requirements. You might consider testing with a public endpoint, and then establishing a VPC endpoint
     *         service for production tasks. Note that this choice does not determine the location of the external key
     *         store proxy. Even if you choose a VPC endpoint service, the proxy can be hosted within the VPC or outside
     *         of Amazon Web Services such as in your corporate data center.
     * @see XksProxyConnectivityType
     */
    public final String xksProxyConnectivityAsString() {
        return xksProxyConnectivity;
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
        hashCode = 31 * hashCode + Objects.hashCode(customKeyStoreName());
        hashCode = 31 * hashCode + Objects.hashCode(cloudHsmClusterId());
        hashCode = 31 * hashCode + Objects.hashCode(trustAnchorCertificate());
        hashCode = 31 * hashCode + Objects.hashCode(keyStorePassword());
        hashCode = 31 * hashCode + Objects.hashCode(customKeyStoreTypeAsString());
        hashCode = 31 * hashCode + Objects.hashCode(xksProxyUriEndpoint());
        hashCode = 31 * hashCode + Objects.hashCode(xksProxyUriPath());
        hashCode = 31 * hashCode + Objects.hashCode(xksProxyVpcEndpointServiceName());
        hashCode = 31 * hashCode + Objects.hashCode(xksProxyAuthenticationCredential());
        hashCode = 31 * hashCode + Objects.hashCode(xksProxyConnectivityAsString());
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
        if (!(obj instanceof CreateCustomKeyStoreRequest)) {
            return false;
        }
        CreateCustomKeyStoreRequest other = (CreateCustomKeyStoreRequest) obj;
        return Objects.equals(customKeyStoreName(), other.customKeyStoreName())
                && Objects.equals(cloudHsmClusterId(), other.cloudHsmClusterId())
                && Objects.equals(trustAnchorCertificate(), other.trustAnchorCertificate())
                && Objects.equals(keyStorePassword(), other.keyStorePassword())
                && Objects.equals(customKeyStoreTypeAsString(), other.customKeyStoreTypeAsString())
                && Objects.equals(xksProxyUriEndpoint(), other.xksProxyUriEndpoint())
                && Objects.equals(xksProxyUriPath(), other.xksProxyUriPath())
                && Objects.equals(xksProxyVpcEndpointServiceName(), other.xksProxyVpcEndpointServiceName())
                && Objects.equals(xksProxyAuthenticationCredential(), other.xksProxyAuthenticationCredential())
                && Objects.equals(xksProxyConnectivityAsString(), other.xksProxyConnectivityAsString());
    }

    /**
     * Returns a string representation of this object. This is useful for testing and debugging. Sensitive data will be
     * redacted from this string using a placeholder value.
     */
    @Override
    public final String toString() {
        return ToString.builder("CreateCustomKeyStoreRequest").add("CustomKeyStoreName", customKeyStoreName())
                .add("CloudHsmClusterId", cloudHsmClusterId()).add("TrustAnchorCertificate", trustAnchorCertificate())
                .add("KeyStorePassword", keyStorePassword() == null ? null : "*** Sensitive Data Redacted ***")
                .add("CustomKeyStoreType", customKeyStoreTypeAsString()).add("XksProxyUriEndpoint", xksProxyUriEndpoint())
                .add("XksProxyUriPath", xksProxyUriPath())
                .add("XksProxyVpcEndpointServiceName", xksProxyVpcEndpointServiceName())
                .add("XksProxyAuthenticationCredential", xksProxyAuthenticationCredential())
                .add("XksProxyConnectivity", xksProxyConnectivityAsString()).build();
    }

    public final <T> Optional<T> getValueForField(String fieldName, Class<T> clazz) {
        switch (fieldName) {
        case "CustomKeyStoreName":
            return Optional.ofNullable(clazz.cast(customKeyStoreName()));
        case "CloudHsmClusterId":
            return Optional.ofNullable(clazz.cast(cloudHsmClusterId()));
        case "TrustAnchorCertificate":
            return Optional.ofNullable(clazz.cast(trustAnchorCertificate()));
        case "KeyStorePassword":
            return Optional.ofNullable(clazz.cast(keyStorePassword()));
        case "CustomKeyStoreType":
            return Optional.ofNullable(clazz.cast(customKeyStoreTypeAsString()));
        case "XksProxyUriEndpoint":
            return Optional.ofNullable(clazz.cast(xksProxyUriEndpoint()));
        case "XksProxyUriPath":
            return Optional.ofNullable(clazz.cast(xksProxyUriPath()));
        case "XksProxyVpcEndpointServiceName":
            return Optional.ofNullable(clazz.cast(xksProxyVpcEndpointServiceName()));
        case "XksProxyAuthenticationCredential":
            return Optional.ofNullable(clazz.cast(xksProxyAuthenticationCredential()));
        case "XksProxyConnectivity":
            return Optional.ofNullable(clazz.cast(xksProxyConnectivityAsString()));
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
        map.put("CustomKeyStoreName", CUSTOM_KEY_STORE_NAME_FIELD);
        map.put("CloudHsmClusterId", CLOUD_HSM_CLUSTER_ID_FIELD);
        map.put("TrustAnchorCertificate", TRUST_ANCHOR_CERTIFICATE_FIELD);
        map.put("KeyStorePassword", KEY_STORE_PASSWORD_FIELD);
        map.put("CustomKeyStoreType", CUSTOM_KEY_STORE_TYPE_FIELD);
        map.put("XksProxyUriEndpoint", XKS_PROXY_URI_ENDPOINT_FIELD);
        map.put("XksProxyUriPath", XKS_PROXY_URI_PATH_FIELD);
        map.put("XksProxyVpcEndpointServiceName", XKS_PROXY_VPC_ENDPOINT_SERVICE_NAME_FIELD);
        map.put("XksProxyAuthenticationCredential", XKS_PROXY_AUTHENTICATION_CREDENTIAL_FIELD);
        map.put("XksProxyConnectivity", XKS_PROXY_CONNECTIVITY_FIELD);
        return Collections.unmodifiableMap(map);
    }

    private static <T> Function<Object, T> getter(Function<CreateCustomKeyStoreRequest, T> g) {
        return obj -> g.apply((CreateCustomKeyStoreRequest) obj);
    }

    private static <T> BiConsumer<Object, T> setter(BiConsumer<Builder, T> s) {
        return (obj, val) -> s.accept((Builder) obj, val);
    }

    @Mutable
    @NotThreadSafe
    public interface Builder extends KmsRequest.Builder, SdkPojo, CopyableBuilder<Builder, CreateCustomKeyStoreRequest> {
        /**
         * <p>
         * Specifies a friendly name for the custom key store. The name must be unique in your Amazon Web Services
         * account and Region. This parameter is required for all custom key stores.
         * </p>
         * <important>
         * <p>
         * Do not include confidential or sensitive information in this field. This field may be displayed in plaintext
         * in CloudTrail logs and other output.
         * </p>
         * </important>
         * 
         * @param customKeyStoreName
         *        Specifies a friendly name for the custom key store. The name must be unique in your Amazon Web
         *        Services account and Region. This parameter is required for all custom key stores.</p> <important>
         *        <p>
         *        Do not include confidential or sensitive information in this field. This field may be displayed in
         *        plaintext in CloudTrail logs and other output.
         *        </p>
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder customKeyStoreName(String customKeyStoreName);

        /**
         * <p>
         * Identifies the CloudHSM cluster for an CloudHSM key store. This parameter is required for custom key stores
         * with <code>CustomKeyStoreType</code> of <code>AWS_CLOUDHSM</code>.
         * </p>
         * <p>
         * Enter the cluster ID of any active CloudHSM cluster that is not already associated with a custom key store.
         * To find the cluster ID, use the <a
         * href="https://docs.aws.amazon.com/cloudhsm/latest/APIReference/API_DescribeClusters.html"
         * >DescribeClusters</a> operation.
         * </p>
         * 
         * @param cloudHsmClusterId
         *        Identifies the CloudHSM cluster for an CloudHSM key store. This parameter is required for custom key
         *        stores with <code>CustomKeyStoreType</code> of <code>AWS_CLOUDHSM</code>.</p>
         *        <p>
         *        Enter the cluster ID of any active CloudHSM cluster that is not already associated with a custom key
         *        store. To find the cluster ID, use the <a
         *        href="https://docs.aws.amazon.com/cloudhsm/latest/APIReference/API_DescribeClusters.html"
         *        >DescribeClusters</a> operation.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder cloudHsmClusterId(String cloudHsmClusterId);

        /**
         * <p>
         * Specifies the certificate for an CloudHSM key store. This parameter is required for custom key stores with a
         * <code>CustomKeyStoreType</code> of <code>AWS_CLOUDHSM</code>.
         * </p>
         * <p>
         * Enter the content of the trust anchor certificate for the CloudHSM cluster. This is the content of the
         * <code>customerCA.crt</code> file that you created when you <a
         * href="https://docs.aws.amazon.com/cloudhsm/latest/userguide/initialize-cluster.html">initialized the
         * cluster</a>.
         * </p>
         * 
         * @param trustAnchorCertificate
         *        Specifies the certificate for an CloudHSM key store. This parameter is required for custom key stores
         *        with a <code>CustomKeyStoreType</code> of <code>AWS_CLOUDHSM</code>.</p>
         *        <p>
         *        Enter the content of the trust anchor certificate for the CloudHSM cluster. This is the content of the
         *        <code>customerCA.crt</code> file that you created when you <a
         *        href="https://docs.aws.amazon.com/cloudhsm/latest/userguide/initialize-cluster.html">initialized the
         *        cluster</a>.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder trustAnchorCertificate(String trustAnchorCertificate);

        /**
         * <p>
         * Specifies the <code>kmsuser</code> password for an CloudHSM key store. This parameter is required for custom
         * key stores with a <code>CustomKeyStoreType</code> of <code>AWS_CLOUDHSM</code>.
         * </p>
         * <p>
         * Enter the password of the <a
         * href="https://docs.aws.amazon.com/kms/latest/developerguide/key-store-concepts.html#concept-kmsuser">
         * <code>kmsuser</code> crypto user (CU) account</a> in the specified CloudHSM cluster. KMS logs into the
         * cluster as this user to manage key material on your behalf.
         * </p>
         * <p>
         * The password must be a string of 7 to 32 characters. Its value is case sensitive.
         * </p>
         * <p>
         * This parameter tells KMS the <code>kmsuser</code> account password; it does not change the password in the
         * CloudHSM cluster.
         * </p>
         * 
         * @param keyStorePassword
         *        Specifies the <code>kmsuser</code> password for an CloudHSM key store. This parameter is required for
         *        custom key stores with a <code>CustomKeyStoreType</code> of <code>AWS_CLOUDHSM</code>.</p>
         *        <p>
         *        Enter the password of the <a
         *        href="https://docs.aws.amazon.com/kms/latest/developerguide/key-store-concepts.html#concept-kmsuser">
         *        <code>kmsuser</code> crypto user (CU) account</a> in the specified CloudHSM cluster. KMS logs into the
         *        cluster as this user to manage key material on your behalf.
         *        </p>
         *        <p>
         *        The password must be a string of 7 to 32 characters. Its value is case sensitive.
         *        </p>
         *        <p>
         *        This parameter tells KMS the <code>kmsuser</code> account password; it does not change the password in
         *        the CloudHSM cluster.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder keyStorePassword(String keyStorePassword);

        /**
         * <p>
         * Specifies the type of custom key store. The default value is <code>AWS_CLOUDHSM</code>.
         * </p>
         * <p>
         * For a custom key store backed by an CloudHSM cluster, omit the parameter or enter <code>AWS_CLOUDHSM</code>.
         * For a custom key store backed by an external key manager outside of Amazon Web Services, enter
         * <code>EXTERNAL_KEY_STORE</code>. You cannot change this property after the key store is created.
         * </p>
         * 
         * @param customKeyStoreType
         *        Specifies the type of custom key store. The default value is <code>AWS_CLOUDHSM</code>.</p>
         *        <p>
         *        For a custom key store backed by an CloudHSM cluster, omit the parameter or enter
         *        <code>AWS_CLOUDHSM</code>. For a custom key store backed by an external key manager outside of Amazon
         *        Web Services, enter <code>EXTERNAL_KEY_STORE</code>. You cannot change this property after the key
         *        store is created.
         * @see CustomKeyStoreType
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see CustomKeyStoreType
         */
        Builder customKeyStoreType(String customKeyStoreType);

        /**
         * <p>
         * Specifies the type of custom key store. The default value is <code>AWS_CLOUDHSM</code>.
         * </p>
         * <p>
         * For a custom key store backed by an CloudHSM cluster, omit the parameter or enter <code>AWS_CLOUDHSM</code>.
         * For a custom key store backed by an external key manager outside of Amazon Web Services, enter
         * <code>EXTERNAL_KEY_STORE</code>. You cannot change this property after the key store is created.
         * </p>
         * 
         * @param customKeyStoreType
         *        Specifies the type of custom key store. The default value is <code>AWS_CLOUDHSM</code>.</p>
         *        <p>
         *        For a custom key store backed by an CloudHSM cluster, omit the parameter or enter
         *        <code>AWS_CLOUDHSM</code>. For a custom key store backed by an external key manager outside of Amazon
         *        Web Services, enter <code>EXTERNAL_KEY_STORE</code>. You cannot change this property after the key
         *        store is created.
         * @see CustomKeyStoreType
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see CustomKeyStoreType
         */
        Builder customKeyStoreType(CustomKeyStoreType customKeyStoreType);

        /**
         * <p>
         * Specifies the endpoint that KMS uses to send requests to the external key store proxy (XKS proxy). This
         * parameter is required for custom key stores with a <code>CustomKeyStoreType</code> of
         * <code>EXTERNAL_KEY_STORE</code>.
         * </p>
         * <p>
         * The protocol must be HTTPS. KMS communicates on port 443. Do not specify the port in the
         * <code>XksProxyUriEndpoint</code> value.
         * </p>
         * <p>
         * For external key stores with <code>XksProxyConnectivity</code> value of <code>VPC_ENDPOINT_SERVICE</code>,
         * specify <code>https://</code> followed by the private DNS name of the VPC endpoint service.
         * </p>
         * <p>
         * For external key stores with <code>PUBLIC_ENDPOINT</code> connectivity, this endpoint must be reachable
         * before you create the custom key store. KMS connects to the external key store proxy while creating the
         * custom key store. For external key stores with <code>VPC_ENDPOINT_SERVICE</code> connectivity, KMS connects
         * when you call the <a>ConnectCustomKeyStore</a> operation.
         * </p>
         * <p>
         * The value of this parameter must begin with <code>https://</code>. The remainder can contain upper and lower
         * case letters (A-Z and a-z), numbers (0-9), dots (<code>.</code>), and hyphens (<code>-</code>). Additional
         * slashes (<code>/</code> and <code>\</code>) are not permitted.
         * </p>
         * <p>
         * <b>Uniqueness requirements: </b>
         * </p>
         * <ul>
         * <li>
         * <p>
         * The combined <code>XksProxyUriEndpoint</code> and <code>XksProxyUriPath</code> values must be unique in the
         * Amazon Web Services account and Region.
         * </p>
         * </li>
         * <li>
         * <p>
         * An external key store with <code>PUBLIC_ENDPOINT</code> connectivity cannot use the same
         * <code>XksProxyUriEndpoint</code> value as an external key store with <code>VPC_ENDPOINT_SERVICE</code>
         * connectivity in this Amazon Web Services Region.
         * </p>
         * </li>
         * <li>
         * <p>
         * Each external key store with <code>VPC_ENDPOINT_SERVICE</code> connectivity must have its own private DNS
         * name. The <code>XksProxyUriEndpoint</code> value for external key stores with
         * <code>VPC_ENDPOINT_SERVICE</code> connectivity (private DNS name) must be unique in the Amazon Web Services
         * account and Region.
         * </p>
         * </li>
         * </ul>
         * 
         * @param xksProxyUriEndpoint
         *        Specifies the endpoint that KMS uses to send requests to the external key store proxy (XKS proxy).
         *        This parameter is required for custom key stores with a <code>CustomKeyStoreType</code> of
         *        <code>EXTERNAL_KEY_STORE</code>.</p>
         *        <p>
         *        The protocol must be HTTPS. KMS communicates on port 443. Do not specify the port in the
         *        <code>XksProxyUriEndpoint</code> value.
         *        </p>
         *        <p>
         *        For external key stores with <code>XksProxyConnectivity</code> value of
         *        <code>VPC_ENDPOINT_SERVICE</code>, specify <code>https://</code> followed by the private DNS name of
         *        the VPC endpoint service.
         *        </p>
         *        <p>
         *        For external key stores with <code>PUBLIC_ENDPOINT</code> connectivity, this endpoint must be
         *        reachable before you create the custom key store. KMS connects to the external key store proxy while
         *        creating the custom key store. For external key stores with <code>VPC_ENDPOINT_SERVICE</code>
         *        connectivity, KMS connects when you call the <a>ConnectCustomKeyStore</a> operation.
         *        </p>
         *        <p>
         *        The value of this parameter must begin with <code>https://</code>. The remainder can contain upper and
         *        lower case letters (A-Z and a-z), numbers (0-9), dots (<code>.</code>), and hyphens (<code>-</code>).
         *        Additional slashes (<code>/</code> and <code>\</code>) are not permitted.
         *        </p>
         *        <p>
         *        <b>Uniqueness requirements: </b>
         *        </p>
         *        <ul>
         *        <li>
         *        <p>
         *        The combined <code>XksProxyUriEndpoint</code> and <code>XksProxyUriPath</code> values must be unique
         *        in the Amazon Web Services account and Region.
         *        </p>
         *        </li>
         *        <li>
         *        <p>
         *        An external key store with <code>PUBLIC_ENDPOINT</code> connectivity cannot use the same
         *        <code>XksProxyUriEndpoint</code> value as an external key store with <code>VPC_ENDPOINT_SERVICE</code>
         *        connectivity in this Amazon Web Services Region.
         *        </p>
         *        </li>
         *        <li>
         *        <p>
         *        Each external key store with <code>VPC_ENDPOINT_SERVICE</code> connectivity must have its own private
         *        DNS name. The <code>XksProxyUriEndpoint</code> value for external key stores with
         *        <code>VPC_ENDPOINT_SERVICE</code> connectivity (private DNS name) must be unique in the Amazon Web
         *        Services account and Region.
         *        </p>
         *        </li>
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder xksProxyUriEndpoint(String xksProxyUriEndpoint);

        /**
         * <p>
         * Specifies the base path to the proxy APIs for this external key store. To find this value, see the
         * documentation for your external key store proxy. This parameter is required for all custom key stores with a
         * <code>CustomKeyStoreType</code> of <code>EXTERNAL_KEY_STORE</code>.
         * </p>
         * <p>
         * The value must start with <code>/</code> and must end with <code>/kms/xks/v1</code> where <code>v1</code>
         * represents the version of the KMS external key store proxy API. This path can include an optional prefix
         * between the required elements such as <code>/<i>prefix</i>/kms/xks/v1</code>.
         * </p>
         * <p>
         * <b>Uniqueness requirements: </b>
         * </p>
         * <ul>
         * <li>
         * <p>
         * The combined <code>XksProxyUriEndpoint</code> and <code>XksProxyUriPath</code> values must be unique in the
         * Amazon Web Services account and Region.
         * </p>
         * </li>
         * </ul>
         * 
         * @param xksProxyUriPath
         *        Specifies the base path to the proxy APIs for this external key store. To find this value, see the
         *        documentation for your external key store proxy. This parameter is required for all custom key stores
         *        with a <code>CustomKeyStoreType</code> of <code>EXTERNAL_KEY_STORE</code>.</p>
         *        <p>
         *        The value must start with <code>/</code> and must end with <code>/kms/xks/v1</code> where
         *        <code>v1</code> represents the version of the KMS external key store proxy API. This path can include
         *        an optional prefix between the required elements such as <code>/<i>prefix</i>/kms/xks/v1</code>.
         *        </p>
         *        <p>
         *        <b>Uniqueness requirements: </b>
         *        </p>
         *        <ul>
         *        <li>
         *        <p>
         *        The combined <code>XksProxyUriEndpoint</code> and <code>XksProxyUriPath</code> values must be unique
         *        in the Amazon Web Services account and Region.
         *        </p>
         *        </li>
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder xksProxyUriPath(String xksProxyUriPath);

        /**
         * <p>
         * Specifies the name of the Amazon VPC endpoint service for interface endpoints that is used to communicate
         * with your external key store proxy (XKS proxy). This parameter is required when the value of
         * <code>CustomKeyStoreType</code> is <code>EXTERNAL_KEY_STORE</code> and the value of
         * <code>XksProxyConnectivity</code> is <code>VPC_ENDPOINT_SERVICE</code>.
         * </p>
         * <p>
         * The Amazon VPC endpoint service must <a
         * href="https://docs.aws.amazon.com/kms/latest/developerguide/create-xks-keystore.html#xks-requirements"
         * >fulfill all requirements</a> for use with an external key store.
         * </p>
         * <p>
         * <b>Uniqueness requirements:</b>
         * </p>
         * <ul>
         * <li>
         * <p>
         * External key stores with <code>VPC_ENDPOINT_SERVICE</code> connectivity can share an Amazon VPC, but each
         * external key store must have its own VPC endpoint service and private DNS name.
         * </p>
         * </li>
         * </ul>
         * 
         * @param xksProxyVpcEndpointServiceName
         *        Specifies the name of the Amazon VPC endpoint service for interface endpoints that is used to
         *        communicate with your external key store proxy (XKS proxy). This parameter is required when the value
         *        of <code>CustomKeyStoreType</code> is <code>EXTERNAL_KEY_STORE</code> and the value of
         *        <code>XksProxyConnectivity</code> is <code>VPC_ENDPOINT_SERVICE</code>.</p>
         *        <p>
         *        The Amazon VPC endpoint service must <a href=
         *        "https://docs.aws.amazon.com/kms/latest/developerguide/create-xks-keystore.html#xks-requirements"
         *        >fulfill all requirements</a> for use with an external key store.
         *        </p>
         *        <p>
         *        <b>Uniqueness requirements:</b>
         *        </p>
         *        <ul>
         *        <li>
         *        <p>
         *        External key stores with <code>VPC_ENDPOINT_SERVICE</code> connectivity can share an Amazon VPC, but
         *        each external key store must have its own VPC endpoint service and private DNS name.
         *        </p>
         *        </li>
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder xksProxyVpcEndpointServiceName(String xksProxyVpcEndpointServiceName);

        /**
         * <p>
         * Specifies an authentication credential for the external key store proxy (XKS proxy). This parameter is
         * required for all custom key stores with a <code>CustomKeyStoreType</code> of <code>EXTERNAL_KEY_STORE</code>.
         * </p>
         * <p>
         * The <code>XksProxyAuthenticationCredential</code> has two required elements: <code>RawSecretAccessKey</code>,
         * a secret key, and <code>AccessKeyId</code>, a unique identifier for the <code>RawSecretAccessKey</code>. For
         * character requirements, see <a href="kms/latest/APIReference/API_XksProxyAuthenticationCredentialType.html">
         * XksProxyAuthenticationCredentialType</a>.
         * </p>
         * <p>
         * KMS uses this authentication credential to sign requests to the external key store proxy on your behalf. This
         * credential is unrelated to Identity and Access Management (IAM) and Amazon Web Services credentials.
         * </p>
         * <p>
         * This parameter doesn't set or change the authentication credentials on the XKS proxy. It just tells KMS the
         * credential that you established on your external key store proxy. If you rotate your proxy authentication
         * credential, use the <a>UpdateCustomKeyStore</a> operation to provide the new credential to KMS.
         * </p>
         * 
         * @param xksProxyAuthenticationCredential
         *        Specifies an authentication credential for the external key store proxy (XKS proxy). This parameter is
         *        required for all custom key stores with a <code>CustomKeyStoreType</code> of
         *        <code>EXTERNAL_KEY_STORE</code>.</p>
         *        <p>
         *        The <code>XksProxyAuthenticationCredential</code> has two required elements:
         *        <code>RawSecretAccessKey</code>, a secret key, and <code>AccessKeyId</code>, a unique identifier for
         *        the <code>RawSecretAccessKey</code>. For character requirements, see <a
         *        href="kms/latest/APIReference/API_XksProxyAuthenticationCredentialType.html"
         *        >XksProxyAuthenticationCredentialType</a>.
         *        </p>
         *        <p>
         *        KMS uses this authentication credential to sign requests to the external key store proxy on your
         *        behalf. This credential is unrelated to Identity and Access Management (IAM) and Amazon Web Services
         *        credentials.
         *        </p>
         *        <p>
         *        This parameter doesn't set or change the authentication credentials on the XKS proxy. It just tells
         *        KMS the credential that you established on your external key store proxy. If you rotate your proxy
         *        authentication credential, use the <a>UpdateCustomKeyStore</a> operation to provide the new credential
         *        to KMS.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder xksProxyAuthenticationCredential(XksProxyAuthenticationCredentialType xksProxyAuthenticationCredential);

        /**
         * <p>
         * Specifies an authentication credential for the external key store proxy (XKS proxy). This parameter is
         * required for all custom key stores with a <code>CustomKeyStoreType</code> of <code>EXTERNAL_KEY_STORE</code>.
         * </p>
         * <p>
         * The <code>XksProxyAuthenticationCredential</code> has two required elements: <code>RawSecretAccessKey</code>,
         * a secret key, and <code>AccessKeyId</code>, a unique identifier for the <code>RawSecretAccessKey</code>. For
         * character requirements, see <a href="kms/latest/APIReference/API_XksProxyAuthenticationCredentialType.html">
         * XksProxyAuthenticationCredentialType</a>.
         * </p>
         * <p>
         * KMS uses this authentication credential to sign requests to the external key store proxy on your behalf. This
         * credential is unrelated to Identity and Access Management (IAM) and Amazon Web Services credentials.
         * </p>
         * <p>
         * This parameter doesn't set or change the authentication credentials on the XKS proxy. It just tells KMS the
         * credential that you established on your external key store proxy. If you rotate your proxy authentication
         * credential, use the <a>UpdateCustomKeyStore</a> operation to provide the new credential to KMS.
         * </p>
         * This is a convenience method that creates an instance of the
         * {@link XksProxyAuthenticationCredentialType.Builder} avoiding the need to create one manually via
         * {@link XksProxyAuthenticationCredentialType#builder()}.
         *
         * <p>
         * When the {@link Consumer} completes, {@link XksProxyAuthenticationCredentialType.Builder#build()} is called
         * immediately and its result is passed to
         * {@link #xksProxyAuthenticationCredential(XksProxyAuthenticationCredentialType)}.
         * 
         * @param xksProxyAuthenticationCredential
         *        a consumer that will call methods on {@link XksProxyAuthenticationCredentialType.Builder}
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see #xksProxyAuthenticationCredential(XksProxyAuthenticationCredentialType)
         */
        default Builder xksProxyAuthenticationCredential(
                Consumer<XksProxyAuthenticationCredentialType.Builder> xksProxyAuthenticationCredential) {
            return xksProxyAuthenticationCredential(XksProxyAuthenticationCredentialType.builder()
                    .applyMutation(xksProxyAuthenticationCredential).build());
        }

        /**
         * <p>
         * Indicates how KMS communicates with the external key store proxy. This parameter is required for custom key
         * stores with a <code>CustomKeyStoreType</code> of <code>EXTERNAL_KEY_STORE</code>.
         * </p>
         * <p>
         * If the external key store proxy uses a public endpoint, specify <code>PUBLIC_ENDPOINT</code>. If the external
         * key store proxy uses a Amazon VPC endpoint service for communication with KMS, specify
         * <code>VPC_ENDPOINT_SERVICE</code>. For help making this choice, see <a
         * href="https://docs.aws.amazon.com/kms/latest/developerguide/plan-xks-keystore.html#choose-xks-connectivity"
         * >Choosing a connectivity option</a> in the <i>Key Management Service Developer Guide</i>.
         * </p>
         * <p>
         * An Amazon VPC endpoint service keeps your communication with KMS in a private address space entirely within
         * Amazon Web Services, but it requires more configuration, including establishing a Amazon VPC with multiple
         * subnets, a VPC endpoint service, a network load balancer, and a verified private DNS name. A public endpoint
         * is simpler to set up, but it might be slower and might not fulfill your security requirements. You might
         * consider testing with a public endpoint, and then establishing a VPC endpoint service for production tasks.
         * Note that this choice does not determine the location of the external key store proxy. Even if you choose a
         * VPC endpoint service, the proxy can be hosted within the VPC or outside of Amazon Web Services such as in
         * your corporate data center.
         * </p>
         * 
         * @param xksProxyConnectivity
         *        Indicates how KMS communicates with the external key store proxy. This parameter is required for
         *        custom key stores with a <code>CustomKeyStoreType</code> of <code>EXTERNAL_KEY_STORE</code>.</p>
         *        <p>
         *        If the external key store proxy uses a public endpoint, specify <code>PUBLIC_ENDPOINT</code>. If the
         *        external key store proxy uses a Amazon VPC endpoint service for communication with KMS, specify
         *        <code>VPC_ENDPOINT_SERVICE</code>. For help making this choice, see <a
         *        href="https://docs.aws.amazon.com/kms/latest/developerguide/plan-xks-keystore.html#choose-xks-connectivity"
         *        >Choosing a connectivity option</a> in the <i>Key Management Service Developer Guide</i>.
         *        </p>
         *        <p>
         *        An Amazon VPC endpoint service keeps your communication with KMS in a private address space entirely
         *        within Amazon Web Services, but it requires more configuration, including establishing a Amazon VPC
         *        with multiple subnets, a VPC endpoint service, a network load balancer, and a verified private DNS
         *        name. A public endpoint is simpler to set up, but it might be slower and might not fulfill your
         *        security requirements. You might consider testing with a public endpoint, and then establishing a VPC
         *        endpoint service for production tasks. Note that this choice does not determine the location of the
         *        external key store proxy. Even if you choose a VPC endpoint service, the proxy can be hosted within
         *        the VPC or outside of Amazon Web Services such as in your corporate data center.
         * @see XksProxyConnectivityType
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see XksProxyConnectivityType
         */
        Builder xksProxyConnectivity(String xksProxyConnectivity);

        /**
         * <p>
         * Indicates how KMS communicates with the external key store proxy. This parameter is required for custom key
         * stores with a <code>CustomKeyStoreType</code> of <code>EXTERNAL_KEY_STORE</code>.
         * </p>
         * <p>
         * If the external key store proxy uses a public endpoint, specify <code>PUBLIC_ENDPOINT</code>. If the external
         * key store proxy uses a Amazon VPC endpoint service for communication with KMS, specify
         * <code>VPC_ENDPOINT_SERVICE</code>. For help making this choice, see <a
         * href="https://docs.aws.amazon.com/kms/latest/developerguide/plan-xks-keystore.html#choose-xks-connectivity"
         * >Choosing a connectivity option</a> in the <i>Key Management Service Developer Guide</i>.
         * </p>
         * <p>
         * An Amazon VPC endpoint service keeps your communication with KMS in a private address space entirely within
         * Amazon Web Services, but it requires more configuration, including establishing a Amazon VPC with multiple
         * subnets, a VPC endpoint service, a network load balancer, and a verified private DNS name. A public endpoint
         * is simpler to set up, but it might be slower and might not fulfill your security requirements. You might
         * consider testing with a public endpoint, and then establishing a VPC endpoint service for production tasks.
         * Note that this choice does not determine the location of the external key store proxy. Even if you choose a
         * VPC endpoint service, the proxy can be hosted within the VPC or outside of Amazon Web Services such as in
         * your corporate data center.
         * </p>
         * 
         * @param xksProxyConnectivity
         *        Indicates how KMS communicates with the external key store proxy. This parameter is required for
         *        custom key stores with a <code>CustomKeyStoreType</code> of <code>EXTERNAL_KEY_STORE</code>.</p>
         *        <p>
         *        If the external key store proxy uses a public endpoint, specify <code>PUBLIC_ENDPOINT</code>. If the
         *        external key store proxy uses a Amazon VPC endpoint service for communication with KMS, specify
         *        <code>VPC_ENDPOINT_SERVICE</code>. For help making this choice, see <a
         *        href="https://docs.aws.amazon.com/kms/latest/developerguide/plan-xks-keystore.html#choose-xks-connectivity"
         *        >Choosing a connectivity option</a> in the <i>Key Management Service Developer Guide</i>.
         *        </p>
         *        <p>
         *        An Amazon VPC endpoint service keeps your communication with KMS in a private address space entirely
         *        within Amazon Web Services, but it requires more configuration, including establishing a Amazon VPC
         *        with multiple subnets, a VPC endpoint service, a network load balancer, and a verified private DNS
         *        name. A public endpoint is simpler to set up, but it might be slower and might not fulfill your
         *        security requirements. You might consider testing with a public endpoint, and then establishing a VPC
         *        endpoint service for production tasks. Note that this choice does not determine the location of the
         *        external key store proxy. Even if you choose a VPC endpoint service, the proxy can be hosted within
         *        the VPC or outside of Amazon Web Services such as in your corporate data center.
         * @see XksProxyConnectivityType
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see XksProxyConnectivityType
         */
        Builder xksProxyConnectivity(XksProxyConnectivityType xksProxyConnectivity);

        @Override
        Builder overrideConfiguration(AwsRequestOverrideConfiguration overrideConfiguration);

        @Override
        Builder overrideConfiguration(Consumer<AwsRequestOverrideConfiguration.Builder> builderConsumer);
    }

    static final class BuilderImpl extends KmsRequest.BuilderImpl implements Builder {
        private String customKeyStoreName;

        private String cloudHsmClusterId;

        private String trustAnchorCertificate;

        private String keyStorePassword;

        private String customKeyStoreType;

        private String xksProxyUriEndpoint;

        private String xksProxyUriPath;

        private String xksProxyVpcEndpointServiceName;

        private XksProxyAuthenticationCredentialType xksProxyAuthenticationCredential;

        private String xksProxyConnectivity;

        private BuilderImpl() {
        }

        private BuilderImpl(CreateCustomKeyStoreRequest model) {
            super(model);
            customKeyStoreName(model.customKeyStoreName);
            cloudHsmClusterId(model.cloudHsmClusterId);
            trustAnchorCertificate(model.trustAnchorCertificate);
            keyStorePassword(model.keyStorePassword);
            customKeyStoreType(model.customKeyStoreType);
            xksProxyUriEndpoint(model.xksProxyUriEndpoint);
            xksProxyUriPath(model.xksProxyUriPath);
            xksProxyVpcEndpointServiceName(model.xksProxyVpcEndpointServiceName);
            xksProxyAuthenticationCredential(model.xksProxyAuthenticationCredential);
            xksProxyConnectivity(model.xksProxyConnectivity);
        }

        public final String getCustomKeyStoreName() {
            return customKeyStoreName;
        }

        public final void setCustomKeyStoreName(String customKeyStoreName) {
            this.customKeyStoreName = customKeyStoreName;
        }

        @Override
        public final Builder customKeyStoreName(String customKeyStoreName) {
            this.customKeyStoreName = customKeyStoreName;
            return this;
        }

        public final String getCloudHsmClusterId() {
            return cloudHsmClusterId;
        }

        public final void setCloudHsmClusterId(String cloudHsmClusterId) {
            this.cloudHsmClusterId = cloudHsmClusterId;
        }

        @Override
        public final Builder cloudHsmClusterId(String cloudHsmClusterId) {
            this.cloudHsmClusterId = cloudHsmClusterId;
            return this;
        }

        public final String getTrustAnchorCertificate() {
            return trustAnchorCertificate;
        }

        public final void setTrustAnchorCertificate(String trustAnchorCertificate) {
            this.trustAnchorCertificate = trustAnchorCertificate;
        }

        @Override
        public final Builder trustAnchorCertificate(String trustAnchorCertificate) {
            this.trustAnchorCertificate = trustAnchorCertificate;
            return this;
        }

        public final String getKeyStorePassword() {
            return keyStorePassword;
        }

        public final void setKeyStorePassword(String keyStorePassword) {
            this.keyStorePassword = keyStorePassword;
        }

        @Override
        public final Builder keyStorePassword(String keyStorePassword) {
            this.keyStorePassword = keyStorePassword;
            return this;
        }

        public final String getCustomKeyStoreType() {
            return customKeyStoreType;
        }

        public final void setCustomKeyStoreType(String customKeyStoreType) {
            this.customKeyStoreType = customKeyStoreType;
        }

        @Override
        public final Builder customKeyStoreType(String customKeyStoreType) {
            this.customKeyStoreType = customKeyStoreType;
            return this;
        }

        @Override
        public final Builder customKeyStoreType(CustomKeyStoreType customKeyStoreType) {
            this.customKeyStoreType(customKeyStoreType == null ? null : customKeyStoreType.toString());
            return this;
        }

        public final String getXksProxyUriEndpoint() {
            return xksProxyUriEndpoint;
        }

        public final void setXksProxyUriEndpoint(String xksProxyUriEndpoint) {
            this.xksProxyUriEndpoint = xksProxyUriEndpoint;
        }

        @Override
        public final Builder xksProxyUriEndpoint(String xksProxyUriEndpoint) {
            this.xksProxyUriEndpoint = xksProxyUriEndpoint;
            return this;
        }

        public final String getXksProxyUriPath() {
            return xksProxyUriPath;
        }

        public final void setXksProxyUriPath(String xksProxyUriPath) {
            this.xksProxyUriPath = xksProxyUriPath;
        }

        @Override
        public final Builder xksProxyUriPath(String xksProxyUriPath) {
            this.xksProxyUriPath = xksProxyUriPath;
            return this;
        }

        public final String getXksProxyVpcEndpointServiceName() {
            return xksProxyVpcEndpointServiceName;
        }

        public final void setXksProxyVpcEndpointServiceName(String xksProxyVpcEndpointServiceName) {
            this.xksProxyVpcEndpointServiceName = xksProxyVpcEndpointServiceName;
        }

        @Override
        public final Builder xksProxyVpcEndpointServiceName(String xksProxyVpcEndpointServiceName) {
            this.xksProxyVpcEndpointServiceName = xksProxyVpcEndpointServiceName;
            return this;
        }

        public final XksProxyAuthenticationCredentialType.Builder getXksProxyAuthenticationCredential() {
            return xksProxyAuthenticationCredential != null ? xksProxyAuthenticationCredential.toBuilder() : null;
        }

        public final void setXksProxyAuthenticationCredential(
                XksProxyAuthenticationCredentialType.BuilderImpl xksProxyAuthenticationCredential) {
            this.xksProxyAuthenticationCredential = xksProxyAuthenticationCredential != null ? xksProxyAuthenticationCredential
                    .build() : null;
        }

        @Override
        public final Builder xksProxyAuthenticationCredential(
                XksProxyAuthenticationCredentialType xksProxyAuthenticationCredential) {
            this.xksProxyAuthenticationCredential = xksProxyAuthenticationCredential;
            return this;
        }

        public final String getXksProxyConnectivity() {
            return xksProxyConnectivity;
        }

        public final void setXksProxyConnectivity(String xksProxyConnectivity) {
            this.xksProxyConnectivity = xksProxyConnectivity;
        }

        @Override
        public final Builder xksProxyConnectivity(String xksProxyConnectivity) {
            this.xksProxyConnectivity = xksProxyConnectivity;
            return this;
        }

        @Override
        public final Builder xksProxyConnectivity(XksProxyConnectivityType xksProxyConnectivity) {
            this.xksProxyConnectivity(xksProxyConnectivity == null ? null : xksProxyConnectivity.toString());
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
        public CreateCustomKeyStoreRequest build() {
            return new CreateCustomKeyStoreRequest(this);
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
