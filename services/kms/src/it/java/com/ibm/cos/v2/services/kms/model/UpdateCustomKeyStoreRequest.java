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
public final class UpdateCustomKeyStoreRequest extends KmsRequest implements
        ToCopyableBuilder<UpdateCustomKeyStoreRequest.Builder, UpdateCustomKeyStoreRequest> {
    private static final SdkField<String> CUSTOM_KEY_STORE_ID_FIELD = SdkField.<String> builder(MarshallingType.STRING)
            .memberName("CustomKeyStoreId").getter(getter(UpdateCustomKeyStoreRequest::customKeyStoreId))
            .setter(setter(Builder::customKeyStoreId))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("CustomKeyStoreId").build()).build();

    private static final SdkField<String> NEW_CUSTOM_KEY_STORE_NAME_FIELD = SdkField.<String> builder(MarshallingType.STRING)
            .memberName("NewCustomKeyStoreName").getter(getter(UpdateCustomKeyStoreRequest::newCustomKeyStoreName))
            .setter(setter(Builder::newCustomKeyStoreName))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("NewCustomKeyStoreName").build())
            .build();

    private static final SdkField<String> KEY_STORE_PASSWORD_FIELD = SdkField.<String> builder(MarshallingType.STRING)
            .memberName("KeyStorePassword").getter(getter(UpdateCustomKeyStoreRequest::keyStorePassword))
            .setter(setter(Builder::keyStorePassword))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("KeyStorePassword").build()).build();

    private static final SdkField<String> CLOUD_HSM_CLUSTER_ID_FIELD = SdkField.<String> builder(MarshallingType.STRING)
            .memberName("CloudHsmClusterId").getter(getter(UpdateCustomKeyStoreRequest::cloudHsmClusterId))
            .setter(setter(Builder::cloudHsmClusterId))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("CloudHsmClusterId").build()).build();

    private static final SdkField<String> XKS_PROXY_URI_ENDPOINT_FIELD = SdkField.<String> builder(MarshallingType.STRING)
            .memberName("XksProxyUriEndpoint").getter(getter(UpdateCustomKeyStoreRequest::xksProxyUriEndpoint))
            .setter(setter(Builder::xksProxyUriEndpoint))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("XksProxyUriEndpoint").build())
            .build();

    private static final SdkField<String> XKS_PROXY_URI_PATH_FIELD = SdkField.<String> builder(MarshallingType.STRING)
            .memberName("XksProxyUriPath").getter(getter(UpdateCustomKeyStoreRequest::xksProxyUriPath))
            .setter(setter(Builder::xksProxyUriPath))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("XksProxyUriPath").build()).build();

    private static final SdkField<String> XKS_PROXY_VPC_ENDPOINT_SERVICE_NAME_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("XksProxyVpcEndpointServiceName")
            .getter(getter(UpdateCustomKeyStoreRequest::xksProxyVpcEndpointServiceName))
            .setter(setter(Builder::xksProxyVpcEndpointServiceName))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("XksProxyVpcEndpointServiceName")
                    .build()).build();

    private static final SdkField<XksProxyAuthenticationCredentialType> XKS_PROXY_AUTHENTICATION_CREDENTIAL_FIELD = SdkField
            .<XksProxyAuthenticationCredentialType> builder(MarshallingType.SDK_POJO)
            .memberName("XksProxyAuthenticationCredential")
            .getter(getter(UpdateCustomKeyStoreRequest::xksProxyAuthenticationCredential))
            .setter(setter(Builder::xksProxyAuthenticationCredential))
            .constructor(XksProxyAuthenticationCredentialType::builder)
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("XksProxyAuthenticationCredential")
                    .build()).build();

    private static final SdkField<String> XKS_PROXY_CONNECTIVITY_FIELD = SdkField.<String> builder(MarshallingType.STRING)
            .memberName("XksProxyConnectivity").getter(getter(UpdateCustomKeyStoreRequest::xksProxyConnectivityAsString))
            .setter(setter(Builder::xksProxyConnectivity))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("XksProxyConnectivity").build())
            .build();

    private static final List<SdkField<?>> SDK_FIELDS = Collections.unmodifiableList(Arrays.asList(CUSTOM_KEY_STORE_ID_FIELD,
            NEW_CUSTOM_KEY_STORE_NAME_FIELD, KEY_STORE_PASSWORD_FIELD, CLOUD_HSM_CLUSTER_ID_FIELD, XKS_PROXY_URI_ENDPOINT_FIELD,
            XKS_PROXY_URI_PATH_FIELD, XKS_PROXY_VPC_ENDPOINT_SERVICE_NAME_FIELD, XKS_PROXY_AUTHENTICATION_CREDENTIAL_FIELD,
            XKS_PROXY_CONNECTIVITY_FIELD));

    private static final Map<String, SdkField<?>> SDK_NAME_TO_FIELD = memberNameToFieldInitializer();

    private final String customKeyStoreId;

    private final String newCustomKeyStoreName;

    private final String keyStorePassword;

    private final String cloudHsmClusterId;

    private final String xksProxyUriEndpoint;

    private final String xksProxyUriPath;

    private final String xksProxyVpcEndpointServiceName;

    private final XksProxyAuthenticationCredentialType xksProxyAuthenticationCredential;

    private final String xksProxyConnectivity;

    private UpdateCustomKeyStoreRequest(BuilderImpl builder) {
        super(builder);
        this.customKeyStoreId = builder.customKeyStoreId;
        this.newCustomKeyStoreName = builder.newCustomKeyStoreName;
        this.keyStorePassword = builder.keyStorePassword;
        this.cloudHsmClusterId = builder.cloudHsmClusterId;
        this.xksProxyUriEndpoint = builder.xksProxyUriEndpoint;
        this.xksProxyUriPath = builder.xksProxyUriPath;
        this.xksProxyVpcEndpointServiceName = builder.xksProxyVpcEndpointServiceName;
        this.xksProxyAuthenticationCredential = builder.xksProxyAuthenticationCredential;
        this.xksProxyConnectivity = builder.xksProxyConnectivity;
    }

    /**
     * <p>
     * Identifies the custom key store that you want to update. Enter the ID of the custom key store. To find the ID of
     * a custom key store, use the <a>DescribeCustomKeyStores</a> operation.
     * </p>
     * 
     * @return Identifies the custom key store that you want to update. Enter the ID of the custom key store. To find
     *         the ID of a custom key store, use the <a>DescribeCustomKeyStores</a> operation.
     */
    public final String customKeyStoreId() {
        return customKeyStoreId;
    }

    /**
     * <p>
     * Changes the friendly name of the custom key store to the value that you specify. The custom key store name must
     * be unique in the Amazon Web Services account.
     * </p>
     * <important>
     * <p>
     * Do not include confidential or sensitive information in this field. This field may be displayed in plaintext in
     * CloudTrail logs and other output.
     * </p>
     * </important>
     * <p>
     * To change this value, an CloudHSM key store must be disconnected. An external key store can be connected or
     * disconnected.
     * </p>
     * 
     * @return Changes the friendly name of the custom key store to the value that you specify. The custom key store
     *         name must be unique in the Amazon Web Services account.</p> <important>
     *         <p>
     *         Do not include confidential or sensitive information in this field. This field may be displayed in
     *         plaintext in CloudTrail logs and other output.
     *         </p>
     *         </important>
     *         <p>
     *         To change this value, an CloudHSM key store must be disconnected. An external key store can be connected
     *         or disconnected.
     */
    public final String newCustomKeyStoreName() {
        return newCustomKeyStoreName;
    }

    /**
     * <p>
     * Enter the current password of the <code>kmsuser</code> crypto user (CU) in the CloudHSM cluster that is
     * associated with the custom key store. This parameter is valid only for custom key stores with a
     * <code>CustomKeyStoreType</code> of <code>AWS_CLOUDHSM</code>.
     * </p>
     * <p>
     * This parameter tells KMS the current password of the <code>kmsuser</code> crypto user (CU). It does not set or
     * change the password of any users in the CloudHSM cluster.
     * </p>
     * <p>
     * To change this value, the CloudHSM key store must be disconnected.
     * </p>
     * 
     * @return Enter the current password of the <code>kmsuser</code> crypto user (CU) in the CloudHSM cluster that is
     *         associated with the custom key store. This parameter is valid only for custom key stores with a
     *         <code>CustomKeyStoreType</code> of <code>AWS_CLOUDHSM</code>.</p>
     *         <p>
     *         This parameter tells KMS the current password of the <code>kmsuser</code> crypto user (CU). It does not
     *         set or change the password of any users in the CloudHSM cluster.
     *         </p>
     *         <p>
     *         To change this value, the CloudHSM key store must be disconnected.
     */
    public final String keyStorePassword() {
        return keyStorePassword;
    }

    /**
     * <p>
     * Associates the custom key store with a related CloudHSM cluster. This parameter is valid only for custom key
     * stores with a <code>CustomKeyStoreType</code> of <code>AWS_CLOUDHSM</code>.
     * </p>
     * <p>
     * Enter the cluster ID of the cluster that you used to create the custom key store or a cluster that shares a
     * backup history and has the same cluster certificate as the original cluster. You cannot use this parameter to
     * associate a custom key store with an unrelated cluster. In addition, the replacement cluster must <a
     * href="https://docs.aws.amazon.com/kms/latest/developerguide/create-keystore.html#before-keystore">fulfill the
     * requirements</a> for a cluster associated with a custom key store. To view the cluster certificate of a cluster,
     * use the <a
     * href="https://docs.aws.amazon.com/cloudhsm/latest/APIReference/API_DescribeClusters.html">DescribeClusters</a>
     * operation.
     * </p>
     * <p>
     * To change this value, the CloudHSM key store must be disconnected.
     * </p>
     * 
     * @return Associates the custom key store with a related CloudHSM cluster. This parameter is valid only for custom
     *         key stores with a <code>CustomKeyStoreType</code> of <code>AWS_CLOUDHSM</code>.</p>
     *         <p>
     *         Enter the cluster ID of the cluster that you used to create the custom key store or a cluster that shares
     *         a backup history and has the same cluster certificate as the original cluster. You cannot use this
     *         parameter to associate a custom key store with an unrelated cluster. In addition, the replacement cluster
     *         must <a
     *         href="https://docs.aws.amazon.com/kms/latest/developerguide/create-keystore.html#before-keystore">fulfill
     *         the requirements</a> for a cluster associated with a custom key store. To view the cluster certificate of
     *         a cluster, use the <a
     *         href="https://docs.aws.amazon.com/cloudhsm/latest/APIReference/API_DescribeClusters.html"
     *         >DescribeClusters</a> operation.
     *         </p>
     *         <p>
     *         To change this value, the CloudHSM key store must be disconnected.
     */
    public final String cloudHsmClusterId() {
        return cloudHsmClusterId;
    }

    /**
     * <p>
     * Changes the URI endpoint that KMS uses to connect to your external key store proxy (XKS proxy). This parameter is
     * valid only for custom key stores with a <code>CustomKeyStoreType</code> of <code>EXTERNAL_KEY_STORE</code>.
     * </p>
     * <p>
     * For external key stores with an <code>XksProxyConnectivity</code> value of <code>PUBLIC_ENDPOINT</code>, the
     * protocol must be HTTPS.
     * </p>
     * <p>
     * For external key stores with an <code>XksProxyConnectivity</code> value of <code>VPC_ENDPOINT_SERVICE</code>,
     * specify <code>https://</code> followed by the private DNS name associated with the VPC endpoint service. Each
     * external key store must use a different private DNS name.
     * </p>
     * <p>
     * The combined <code>XksProxyUriEndpoint</code> and <code>XksProxyUriPath</code> values must be unique in the
     * Amazon Web Services account and Region.
     * </p>
     * <p>
     * To change this value, the external key store must be disconnected.
     * </p>
     * 
     * @return Changes the URI endpoint that KMS uses to connect to your external key store proxy (XKS proxy). This
     *         parameter is valid only for custom key stores with a <code>CustomKeyStoreType</code> of
     *         <code>EXTERNAL_KEY_STORE</code>.</p>
     *         <p>
     *         For external key stores with an <code>XksProxyConnectivity</code> value of <code>PUBLIC_ENDPOINT</code>,
     *         the protocol must be HTTPS.
     *         </p>
     *         <p>
     *         For external key stores with an <code>XksProxyConnectivity</code> value of
     *         <code>VPC_ENDPOINT_SERVICE</code>, specify <code>https://</code> followed by the private DNS name
     *         associated with the VPC endpoint service. Each external key store must use a different private DNS name.
     *         </p>
     *         <p>
     *         The combined <code>XksProxyUriEndpoint</code> and <code>XksProxyUriPath</code> values must be unique in
     *         the Amazon Web Services account and Region.
     *         </p>
     *         <p>
     *         To change this value, the external key store must be disconnected.
     */
    public final String xksProxyUriEndpoint() {
        return xksProxyUriEndpoint;
    }

    /**
     * <p>
     * Changes the base path to the proxy APIs for this external key store. To find this value, see the documentation
     * for your external key manager and external key store proxy (XKS proxy). This parameter is valid only for custom
     * key stores with a <code>CustomKeyStoreType</code> of <code>EXTERNAL_KEY_STORE</code>.
     * </p>
     * <p>
     * The value must start with <code>/</code> and must end with <code>/kms/xks/v1</code>, where <code>v1</code>
     * represents the version of the KMS external key store proxy API. You can include an optional prefix between the
     * required elements such as <code>/<i>example</i>/kms/xks/v1</code>.
     * </p>
     * <p>
     * The combined <code>XksProxyUriEndpoint</code> and <code>XksProxyUriPath</code> values must be unique in the
     * Amazon Web Services account and Region.
     * </p>
     * <p>
     * You can change this value when the external key store is connected or disconnected.
     * </p>
     * 
     * @return Changes the base path to the proxy APIs for this external key store. To find this value, see the
     *         documentation for your external key manager and external key store proxy (XKS proxy). This parameter is
     *         valid only for custom key stores with a <code>CustomKeyStoreType</code> of
     *         <code>EXTERNAL_KEY_STORE</code>.</p>
     *         <p>
     *         The value must start with <code>/</code> and must end with <code>/kms/xks/v1</code>, where
     *         <code>v1</code> represents the version of the KMS external key store proxy API. You can include an
     *         optional prefix between the required elements such as <code>/<i>example</i>/kms/xks/v1</code>.
     *         </p>
     *         <p>
     *         The combined <code>XksProxyUriEndpoint</code> and <code>XksProxyUriPath</code> values must be unique in
     *         the Amazon Web Services account and Region.
     *         </p>
     *         <p>
     *         You can change this value when the external key store is connected or disconnected.
     */
    public final String xksProxyUriPath() {
        return xksProxyUriPath;
    }

    /**
     * <p>
     * Changes the name that KMS uses to identify the Amazon VPC endpoint service for your external key store proxy (XKS
     * proxy). This parameter is valid when the <code>CustomKeyStoreType</code> is <code>EXTERNAL_KEY_STORE</code> and
     * the <code>XksProxyConnectivity</code> is <code>VPC_ENDPOINT_SERVICE</code>.
     * </p>
     * <p>
     * To change this value, the external key store must be disconnected.
     * </p>
     * 
     * @return Changes the name that KMS uses to identify the Amazon VPC endpoint service for your external key store
     *         proxy (XKS proxy). This parameter is valid when the <code>CustomKeyStoreType</code> is
     *         <code>EXTERNAL_KEY_STORE</code> and the <code>XksProxyConnectivity</code> is
     *         <code>VPC_ENDPOINT_SERVICE</code>.</p>
     *         <p>
     *         To change this value, the external key store must be disconnected.
     */
    public final String xksProxyVpcEndpointServiceName() {
        return xksProxyVpcEndpointServiceName;
    }

    /**
     * <p>
     * Changes the credentials that KMS uses to sign requests to the external key store proxy (XKS proxy). This
     * parameter is valid only for custom key stores with a <code>CustomKeyStoreType</code> of
     * <code>EXTERNAL_KEY_STORE</code>.
     * </p>
     * <p>
     * You must specify both the <code>AccessKeyId</code> and <code>SecretAccessKey</code> value in the authentication
     * credential, even if you are only updating one value.
     * </p>
     * <p>
     * This parameter doesn't establish or change your authentication credentials on the proxy. It just tells KMS the
     * credential that you established with your external key store proxy. For example, if you rotate the credential on
     * your external key store proxy, you can use this parameter to update the credential in KMS.
     * </p>
     * <p>
     * You can change this value when the external key store is connected or disconnected.
     * </p>
     * 
     * @return Changes the credentials that KMS uses to sign requests to the external key store proxy (XKS proxy). This
     *         parameter is valid only for custom key stores with a <code>CustomKeyStoreType</code> of
     *         <code>EXTERNAL_KEY_STORE</code>.</p>
     *         <p>
     *         You must specify both the <code>AccessKeyId</code> and <code>SecretAccessKey</code> value in the
     *         authentication credential, even if you are only updating one value.
     *         </p>
     *         <p>
     *         This parameter doesn't establish or change your authentication credentials on the proxy. It just tells
     *         KMS the credential that you established with your external key store proxy. For example, if you rotate
     *         the credential on your external key store proxy, you can use this parameter to update the credential in
     *         KMS.
     *         </p>
     *         <p>
     *         You can change this value when the external key store is connected or disconnected.
     */
    public final XksProxyAuthenticationCredentialType xksProxyAuthenticationCredential() {
        return xksProxyAuthenticationCredential;
    }

    /**
     * <p>
     * Changes the connectivity setting for the external key store. To indicate that the external key store proxy uses a
     * Amazon VPC endpoint service to communicate with KMS, specify <code>VPC_ENDPOINT_SERVICE</code>. Otherwise,
     * specify <code>PUBLIC_ENDPOINT</code>.
     * </p>
     * <p>
     * If you change the <code>XksProxyConnectivity</code> to <code>VPC_ENDPOINT_SERVICE</code>, you must also change
     * the <code>XksProxyUriEndpoint</code> and add an <code>XksProxyVpcEndpointServiceName</code> value.
     * </p>
     * <p>
     * If you change the <code>XksProxyConnectivity</code> to <code>PUBLIC_ENDPOINT</code>, you must also change the
     * <code>XksProxyUriEndpoint</code> and specify a null or empty string for the
     * <code>XksProxyVpcEndpointServiceName</code> value.
     * </p>
     * <p>
     * To change this value, the external key store must be disconnected.
     * </p>
     * <p>
     * If the service returns an enum value that is not available in the current SDK version,
     * {@link #xksProxyConnectivity} will return {@link XksProxyConnectivityType#UNKNOWN_TO_SDK_VERSION}. The raw value
     * returned by the service is available from {@link #xksProxyConnectivityAsString}.
     * </p>
     * 
     * @return Changes the connectivity setting for the external key store. To indicate that the external key store
     *         proxy uses a Amazon VPC endpoint service to communicate with KMS, specify
     *         <code>VPC_ENDPOINT_SERVICE</code>. Otherwise, specify <code>PUBLIC_ENDPOINT</code>.</p>
     *         <p>
     *         If you change the <code>XksProxyConnectivity</code> to <code>VPC_ENDPOINT_SERVICE</code>, you must also
     *         change the <code>XksProxyUriEndpoint</code> and add an <code>XksProxyVpcEndpointServiceName</code> value.
     *         </p>
     *         <p>
     *         If you change the <code>XksProxyConnectivity</code> to <code>PUBLIC_ENDPOINT</code>, you must also change
     *         the <code>XksProxyUriEndpoint</code> and specify a null or empty string for the
     *         <code>XksProxyVpcEndpointServiceName</code> value.
     *         </p>
     *         <p>
     *         To change this value, the external key store must be disconnected.
     * @see XksProxyConnectivityType
     */
    public final XksProxyConnectivityType xksProxyConnectivity() {
        return XksProxyConnectivityType.fromValue(xksProxyConnectivity);
    }

    /**
     * <p>
     * Changes the connectivity setting for the external key store. To indicate that the external key store proxy uses a
     * Amazon VPC endpoint service to communicate with KMS, specify <code>VPC_ENDPOINT_SERVICE</code>. Otherwise,
     * specify <code>PUBLIC_ENDPOINT</code>.
     * </p>
     * <p>
     * If you change the <code>XksProxyConnectivity</code> to <code>VPC_ENDPOINT_SERVICE</code>, you must also change
     * the <code>XksProxyUriEndpoint</code> and add an <code>XksProxyVpcEndpointServiceName</code> value.
     * </p>
     * <p>
     * If you change the <code>XksProxyConnectivity</code> to <code>PUBLIC_ENDPOINT</code>, you must also change the
     * <code>XksProxyUriEndpoint</code> and specify a null or empty string for the
     * <code>XksProxyVpcEndpointServiceName</code> value.
     * </p>
     * <p>
     * To change this value, the external key store must be disconnected.
     * </p>
     * <p>
     * If the service returns an enum value that is not available in the current SDK version,
     * {@link #xksProxyConnectivity} will return {@link XksProxyConnectivityType#UNKNOWN_TO_SDK_VERSION}. The raw value
     * returned by the service is available from {@link #xksProxyConnectivityAsString}.
     * </p>
     * 
     * @return Changes the connectivity setting for the external key store. To indicate that the external key store
     *         proxy uses a Amazon VPC endpoint service to communicate with KMS, specify
     *         <code>VPC_ENDPOINT_SERVICE</code>. Otherwise, specify <code>PUBLIC_ENDPOINT</code>.</p>
     *         <p>
     *         If you change the <code>XksProxyConnectivity</code> to <code>VPC_ENDPOINT_SERVICE</code>, you must also
     *         change the <code>XksProxyUriEndpoint</code> and add an <code>XksProxyVpcEndpointServiceName</code> value.
     *         </p>
     *         <p>
     *         If you change the <code>XksProxyConnectivity</code> to <code>PUBLIC_ENDPOINT</code>, you must also change
     *         the <code>XksProxyUriEndpoint</code> and specify a null or empty string for the
     *         <code>XksProxyVpcEndpointServiceName</code> value.
     *         </p>
     *         <p>
     *         To change this value, the external key store must be disconnected.
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
        hashCode = 31 * hashCode + Objects.hashCode(customKeyStoreId());
        hashCode = 31 * hashCode + Objects.hashCode(newCustomKeyStoreName());
        hashCode = 31 * hashCode + Objects.hashCode(keyStorePassword());
        hashCode = 31 * hashCode + Objects.hashCode(cloudHsmClusterId());
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
        if (!(obj instanceof UpdateCustomKeyStoreRequest)) {
            return false;
        }
        UpdateCustomKeyStoreRequest other = (UpdateCustomKeyStoreRequest) obj;
        return Objects.equals(customKeyStoreId(), other.customKeyStoreId())
                && Objects.equals(newCustomKeyStoreName(), other.newCustomKeyStoreName())
                && Objects.equals(keyStorePassword(), other.keyStorePassword())
                && Objects.equals(cloudHsmClusterId(), other.cloudHsmClusterId())
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
        return ToString.builder("UpdateCustomKeyStoreRequest").add("CustomKeyStoreId", customKeyStoreId())
                .add("NewCustomKeyStoreName", newCustomKeyStoreName())
                .add("KeyStorePassword", keyStorePassword() == null ? null : "*** Sensitive Data Redacted ***")
                .add("CloudHsmClusterId", cloudHsmClusterId()).add("XksProxyUriEndpoint", xksProxyUriEndpoint())
                .add("XksProxyUriPath", xksProxyUriPath())
                .add("XksProxyVpcEndpointServiceName", xksProxyVpcEndpointServiceName())
                .add("XksProxyAuthenticationCredential", xksProxyAuthenticationCredential())
                .add("XksProxyConnectivity", xksProxyConnectivityAsString()).build();
    }

    public final <T> Optional<T> getValueForField(String fieldName, Class<T> clazz) {
        switch (fieldName) {
        case "CustomKeyStoreId":
            return Optional.ofNullable(clazz.cast(customKeyStoreId()));
        case "NewCustomKeyStoreName":
            return Optional.ofNullable(clazz.cast(newCustomKeyStoreName()));
        case "KeyStorePassword":
            return Optional.ofNullable(clazz.cast(keyStorePassword()));
        case "CloudHsmClusterId":
            return Optional.ofNullable(clazz.cast(cloudHsmClusterId()));
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
        map.put("CustomKeyStoreId", CUSTOM_KEY_STORE_ID_FIELD);
        map.put("NewCustomKeyStoreName", NEW_CUSTOM_KEY_STORE_NAME_FIELD);
        map.put("KeyStorePassword", KEY_STORE_PASSWORD_FIELD);
        map.put("CloudHsmClusterId", CLOUD_HSM_CLUSTER_ID_FIELD);
        map.put("XksProxyUriEndpoint", XKS_PROXY_URI_ENDPOINT_FIELD);
        map.put("XksProxyUriPath", XKS_PROXY_URI_PATH_FIELD);
        map.put("XksProxyVpcEndpointServiceName", XKS_PROXY_VPC_ENDPOINT_SERVICE_NAME_FIELD);
        map.put("XksProxyAuthenticationCredential", XKS_PROXY_AUTHENTICATION_CREDENTIAL_FIELD);
        map.put("XksProxyConnectivity", XKS_PROXY_CONNECTIVITY_FIELD);
        return Collections.unmodifiableMap(map);
    }

    private static <T> Function<Object, T> getter(Function<UpdateCustomKeyStoreRequest, T> g) {
        return obj -> g.apply((UpdateCustomKeyStoreRequest) obj);
    }

    private static <T> BiConsumer<Object, T> setter(BiConsumer<Builder, T> s) {
        return (obj, val) -> s.accept((Builder) obj, val);
    }

    @Mutable
    @NotThreadSafe
    public interface Builder extends KmsRequest.Builder, SdkPojo, CopyableBuilder<Builder, UpdateCustomKeyStoreRequest> {
        /**
         * <p>
         * Identifies the custom key store that you want to update. Enter the ID of the custom key store. To find the ID
         * of a custom key store, use the <a>DescribeCustomKeyStores</a> operation.
         * </p>
         * 
         * @param customKeyStoreId
         *        Identifies the custom key store that you want to update. Enter the ID of the custom key store. To find
         *        the ID of a custom key store, use the <a>DescribeCustomKeyStores</a> operation.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder customKeyStoreId(String customKeyStoreId);

        /**
         * <p>
         * Changes the friendly name of the custom key store to the value that you specify. The custom key store name
         * must be unique in the Amazon Web Services account.
         * </p>
         * <important>
         * <p>
         * Do not include confidential or sensitive information in this field. This field may be displayed in plaintext
         * in CloudTrail logs and other output.
         * </p>
         * </important>
         * <p>
         * To change this value, an CloudHSM key store must be disconnected. An external key store can be connected or
         * disconnected.
         * </p>
         * 
         * @param newCustomKeyStoreName
         *        Changes the friendly name of the custom key store to the value that you specify. The custom key store
         *        name must be unique in the Amazon Web Services account.</p> <important>
         *        <p>
         *        Do not include confidential or sensitive information in this field. This field may be displayed in
         *        plaintext in CloudTrail logs and other output.
         *        </p>
         *        </important>
         *        <p>
         *        To change this value, an CloudHSM key store must be disconnected. An external key store can be
         *        connected or disconnected.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder newCustomKeyStoreName(String newCustomKeyStoreName);

        /**
         * <p>
         * Enter the current password of the <code>kmsuser</code> crypto user (CU) in the CloudHSM cluster that is
         * associated with the custom key store. This parameter is valid only for custom key stores with a
         * <code>CustomKeyStoreType</code> of <code>AWS_CLOUDHSM</code>.
         * </p>
         * <p>
         * This parameter tells KMS the current password of the <code>kmsuser</code> crypto user (CU). It does not set
         * or change the password of any users in the CloudHSM cluster.
         * </p>
         * <p>
         * To change this value, the CloudHSM key store must be disconnected.
         * </p>
         * 
         * @param keyStorePassword
         *        Enter the current password of the <code>kmsuser</code> crypto user (CU) in the CloudHSM cluster that
         *        is associated with the custom key store. This parameter is valid only for custom key stores with a
         *        <code>CustomKeyStoreType</code> of <code>AWS_CLOUDHSM</code>.</p>
         *        <p>
         *        This parameter tells KMS the current password of the <code>kmsuser</code> crypto user (CU). It does
         *        not set or change the password of any users in the CloudHSM cluster.
         *        </p>
         *        <p>
         *        To change this value, the CloudHSM key store must be disconnected.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder keyStorePassword(String keyStorePassword);

        /**
         * <p>
         * Associates the custom key store with a related CloudHSM cluster. This parameter is valid only for custom key
         * stores with a <code>CustomKeyStoreType</code> of <code>AWS_CLOUDHSM</code>.
         * </p>
         * <p>
         * Enter the cluster ID of the cluster that you used to create the custom key store or a cluster that shares a
         * backup history and has the same cluster certificate as the original cluster. You cannot use this parameter to
         * associate a custom key store with an unrelated cluster. In addition, the replacement cluster must <a
         * href="https://docs.aws.amazon.com/kms/latest/developerguide/create-keystore.html#before-keystore">fulfill the
         * requirements</a> for a cluster associated with a custom key store. To view the cluster certificate of a
         * cluster, use the <a
         * href="https://docs.aws.amazon.com/cloudhsm/latest/APIReference/API_DescribeClusters.html">
         * DescribeClusters</a> operation.
         * </p>
         * <p>
         * To change this value, the CloudHSM key store must be disconnected.
         * </p>
         * 
         * @param cloudHsmClusterId
         *        Associates the custom key store with a related CloudHSM cluster. This parameter is valid only for
         *        custom key stores with a <code>CustomKeyStoreType</code> of <code>AWS_CLOUDHSM</code>.</p>
         *        <p>
         *        Enter the cluster ID of the cluster that you used to create the custom key store or a cluster that
         *        shares a backup history and has the same cluster certificate as the original cluster. You cannot use
         *        this parameter to associate a custom key store with an unrelated cluster. In addition, the replacement
         *        cluster must <a
         *        href="https://docs.aws.amazon.com/kms/latest/developerguide/create-keystore.html#before-keystore"
         *        >fulfill the requirements</a> for a cluster associated with a custom key store. To view the cluster
         *        certificate of a cluster, use the <a
         *        href="https://docs.aws.amazon.com/cloudhsm/latest/APIReference/API_DescribeClusters.html"
         *        >DescribeClusters</a> operation.
         *        </p>
         *        <p>
         *        To change this value, the CloudHSM key store must be disconnected.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder cloudHsmClusterId(String cloudHsmClusterId);

        /**
         * <p>
         * Changes the URI endpoint that KMS uses to connect to your external key store proxy (XKS proxy). This
         * parameter is valid only for custom key stores with a <code>CustomKeyStoreType</code> of
         * <code>EXTERNAL_KEY_STORE</code>.
         * </p>
         * <p>
         * For external key stores with an <code>XksProxyConnectivity</code> value of <code>PUBLIC_ENDPOINT</code>, the
         * protocol must be HTTPS.
         * </p>
         * <p>
         * For external key stores with an <code>XksProxyConnectivity</code> value of <code>VPC_ENDPOINT_SERVICE</code>,
         * specify <code>https://</code> followed by the private DNS name associated with the VPC endpoint service. Each
         * external key store must use a different private DNS name.
         * </p>
         * <p>
         * The combined <code>XksProxyUriEndpoint</code> and <code>XksProxyUriPath</code> values must be unique in the
         * Amazon Web Services account and Region.
         * </p>
         * <p>
         * To change this value, the external key store must be disconnected.
         * </p>
         * 
         * @param xksProxyUriEndpoint
         *        Changes the URI endpoint that KMS uses to connect to your external key store proxy (XKS proxy). This
         *        parameter is valid only for custom key stores with a <code>CustomKeyStoreType</code> of
         *        <code>EXTERNAL_KEY_STORE</code>.</p>
         *        <p>
         *        For external key stores with an <code>XksProxyConnectivity</code> value of
         *        <code>PUBLIC_ENDPOINT</code>, the protocol must be HTTPS.
         *        </p>
         *        <p>
         *        For external key stores with an <code>XksProxyConnectivity</code> value of
         *        <code>VPC_ENDPOINT_SERVICE</code>, specify <code>https://</code> followed by the private DNS name
         *        associated with the VPC endpoint service. Each external key store must use a different private DNS
         *        name.
         *        </p>
         *        <p>
         *        The combined <code>XksProxyUriEndpoint</code> and <code>XksProxyUriPath</code> values must be unique
         *        in the Amazon Web Services account and Region.
         *        </p>
         *        <p>
         *        To change this value, the external key store must be disconnected.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder xksProxyUriEndpoint(String xksProxyUriEndpoint);

        /**
         * <p>
         * Changes the base path to the proxy APIs for this external key store. To find this value, see the
         * documentation for your external key manager and external key store proxy (XKS proxy). This parameter is valid
         * only for custom key stores with a <code>CustomKeyStoreType</code> of <code>EXTERNAL_KEY_STORE</code>.
         * </p>
         * <p>
         * The value must start with <code>/</code> and must end with <code>/kms/xks/v1</code>, where <code>v1</code>
         * represents the version of the KMS external key store proxy API. You can include an optional prefix between
         * the required elements such as <code>/<i>example</i>/kms/xks/v1</code>.
         * </p>
         * <p>
         * The combined <code>XksProxyUriEndpoint</code> and <code>XksProxyUriPath</code> values must be unique in the
         * Amazon Web Services account and Region.
         * </p>
         * <p>
         * You can change this value when the external key store is connected or disconnected.
         * </p>
         * 
         * @param xksProxyUriPath
         *        Changes the base path to the proxy APIs for this external key store. To find this value, see the
         *        documentation for your external key manager and external key store proxy (XKS proxy). This parameter
         *        is valid only for custom key stores with a <code>CustomKeyStoreType</code> of
         *        <code>EXTERNAL_KEY_STORE</code>.</p>
         *        <p>
         *        The value must start with <code>/</code> and must end with <code>/kms/xks/v1</code>, where
         *        <code>v1</code> represents the version of the KMS external key store proxy API. You can include an
         *        optional prefix between the required elements such as <code>/<i>example</i>/kms/xks/v1</code>.
         *        </p>
         *        <p>
         *        The combined <code>XksProxyUriEndpoint</code> and <code>XksProxyUriPath</code> values must be unique
         *        in the Amazon Web Services account and Region.
         *        </p>
         *        <p>
         *        You can change this value when the external key store is connected or disconnected.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder xksProxyUriPath(String xksProxyUriPath);

        /**
         * <p>
         * Changes the name that KMS uses to identify the Amazon VPC endpoint service for your external key store proxy
         * (XKS proxy). This parameter is valid when the <code>CustomKeyStoreType</code> is
         * <code>EXTERNAL_KEY_STORE</code> and the <code>XksProxyConnectivity</code> is
         * <code>VPC_ENDPOINT_SERVICE</code>.
         * </p>
         * <p>
         * To change this value, the external key store must be disconnected.
         * </p>
         * 
         * @param xksProxyVpcEndpointServiceName
         *        Changes the name that KMS uses to identify the Amazon VPC endpoint service for your external key store
         *        proxy (XKS proxy). This parameter is valid when the <code>CustomKeyStoreType</code> is
         *        <code>EXTERNAL_KEY_STORE</code> and the <code>XksProxyConnectivity</code> is
         *        <code>VPC_ENDPOINT_SERVICE</code>.</p>
         *        <p>
         *        To change this value, the external key store must be disconnected.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder xksProxyVpcEndpointServiceName(String xksProxyVpcEndpointServiceName);

        /**
         * <p>
         * Changes the credentials that KMS uses to sign requests to the external key store proxy (XKS proxy). This
         * parameter is valid only for custom key stores with a <code>CustomKeyStoreType</code> of
         * <code>EXTERNAL_KEY_STORE</code>.
         * </p>
         * <p>
         * You must specify both the <code>AccessKeyId</code> and <code>SecretAccessKey</code> value in the
         * authentication credential, even if you are only updating one value.
         * </p>
         * <p>
         * This parameter doesn't establish or change your authentication credentials on the proxy. It just tells KMS
         * the credential that you established with your external key store proxy. For example, if you rotate the
         * credential on your external key store proxy, you can use this parameter to update the credential in KMS.
         * </p>
         * <p>
         * You can change this value when the external key store is connected or disconnected.
         * </p>
         * 
         * @param xksProxyAuthenticationCredential
         *        Changes the credentials that KMS uses to sign requests to the external key store proxy (XKS proxy).
         *        This parameter is valid only for custom key stores with a <code>CustomKeyStoreType</code> of
         *        <code>EXTERNAL_KEY_STORE</code>.</p>
         *        <p>
         *        You must specify both the <code>AccessKeyId</code> and <code>SecretAccessKey</code> value in the
         *        authentication credential, even if you are only updating one value.
         *        </p>
         *        <p>
         *        This parameter doesn't establish or change your authentication credentials on the proxy. It just tells
         *        KMS the credential that you established with your external key store proxy. For example, if you rotate
         *        the credential on your external key store proxy, you can use this parameter to update the credential
         *        in KMS.
         *        </p>
         *        <p>
         *        You can change this value when the external key store is connected or disconnected.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder xksProxyAuthenticationCredential(XksProxyAuthenticationCredentialType xksProxyAuthenticationCredential);

        /**
         * <p>
         * Changes the credentials that KMS uses to sign requests to the external key store proxy (XKS proxy). This
         * parameter is valid only for custom key stores with a <code>CustomKeyStoreType</code> of
         * <code>EXTERNAL_KEY_STORE</code>.
         * </p>
         * <p>
         * You must specify both the <code>AccessKeyId</code> and <code>SecretAccessKey</code> value in the
         * authentication credential, even if you are only updating one value.
         * </p>
         * <p>
         * This parameter doesn't establish or change your authentication credentials on the proxy. It just tells KMS
         * the credential that you established with your external key store proxy. For example, if you rotate the
         * credential on your external key store proxy, you can use this parameter to update the credential in KMS.
         * </p>
         * <p>
         * You can change this value when the external key store is connected or disconnected.
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
         * Changes the connectivity setting for the external key store. To indicate that the external key store proxy
         * uses a Amazon VPC endpoint service to communicate with KMS, specify <code>VPC_ENDPOINT_SERVICE</code>.
         * Otherwise, specify <code>PUBLIC_ENDPOINT</code>.
         * </p>
         * <p>
         * If you change the <code>XksProxyConnectivity</code> to <code>VPC_ENDPOINT_SERVICE</code>, you must also
         * change the <code>XksProxyUriEndpoint</code> and add an <code>XksProxyVpcEndpointServiceName</code> value.
         * </p>
         * <p>
         * If you change the <code>XksProxyConnectivity</code> to <code>PUBLIC_ENDPOINT</code>, you must also change the
         * <code>XksProxyUriEndpoint</code> and specify a null or empty string for the
         * <code>XksProxyVpcEndpointServiceName</code> value.
         * </p>
         * <p>
         * To change this value, the external key store must be disconnected.
         * </p>
         * 
         * @param xksProxyConnectivity
         *        Changes the connectivity setting for the external key store. To indicate that the external key store
         *        proxy uses a Amazon VPC endpoint service to communicate with KMS, specify
         *        <code>VPC_ENDPOINT_SERVICE</code>. Otherwise, specify <code>PUBLIC_ENDPOINT</code>.</p>
         *        <p>
         *        If you change the <code>XksProxyConnectivity</code> to <code>VPC_ENDPOINT_SERVICE</code>, you must
         *        also change the <code>XksProxyUriEndpoint</code> and add an
         *        <code>XksProxyVpcEndpointServiceName</code> value.
         *        </p>
         *        <p>
         *        If you change the <code>XksProxyConnectivity</code> to <code>PUBLIC_ENDPOINT</code>, you must also
         *        change the <code>XksProxyUriEndpoint</code> and specify a null or empty string for the
         *        <code>XksProxyVpcEndpointServiceName</code> value.
         *        </p>
         *        <p>
         *        To change this value, the external key store must be disconnected.
         * @see XksProxyConnectivityType
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see XksProxyConnectivityType
         */
        Builder xksProxyConnectivity(String xksProxyConnectivity);

        /**
         * <p>
         * Changes the connectivity setting for the external key store. To indicate that the external key store proxy
         * uses a Amazon VPC endpoint service to communicate with KMS, specify <code>VPC_ENDPOINT_SERVICE</code>.
         * Otherwise, specify <code>PUBLIC_ENDPOINT</code>.
         * </p>
         * <p>
         * If you change the <code>XksProxyConnectivity</code> to <code>VPC_ENDPOINT_SERVICE</code>, you must also
         * change the <code>XksProxyUriEndpoint</code> and add an <code>XksProxyVpcEndpointServiceName</code> value.
         * </p>
         * <p>
         * If you change the <code>XksProxyConnectivity</code> to <code>PUBLIC_ENDPOINT</code>, you must also change the
         * <code>XksProxyUriEndpoint</code> and specify a null or empty string for the
         * <code>XksProxyVpcEndpointServiceName</code> value.
         * </p>
         * <p>
         * To change this value, the external key store must be disconnected.
         * </p>
         * 
         * @param xksProxyConnectivity
         *        Changes the connectivity setting for the external key store. To indicate that the external key store
         *        proxy uses a Amazon VPC endpoint service to communicate with KMS, specify
         *        <code>VPC_ENDPOINT_SERVICE</code>. Otherwise, specify <code>PUBLIC_ENDPOINT</code>.</p>
         *        <p>
         *        If you change the <code>XksProxyConnectivity</code> to <code>VPC_ENDPOINT_SERVICE</code>, you must
         *        also change the <code>XksProxyUriEndpoint</code> and add an
         *        <code>XksProxyVpcEndpointServiceName</code> value.
         *        </p>
         *        <p>
         *        If you change the <code>XksProxyConnectivity</code> to <code>PUBLIC_ENDPOINT</code>, you must also
         *        change the <code>XksProxyUriEndpoint</code> and specify a null or empty string for the
         *        <code>XksProxyVpcEndpointServiceName</code> value.
         *        </p>
         *        <p>
         *        To change this value, the external key store must be disconnected.
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
        private String customKeyStoreId;

        private String newCustomKeyStoreName;

        private String keyStorePassword;

        private String cloudHsmClusterId;

        private String xksProxyUriEndpoint;

        private String xksProxyUriPath;

        private String xksProxyVpcEndpointServiceName;

        private XksProxyAuthenticationCredentialType xksProxyAuthenticationCredential;

        private String xksProxyConnectivity;

        private BuilderImpl() {
        }

        private BuilderImpl(UpdateCustomKeyStoreRequest model) {
            super(model);
            customKeyStoreId(model.customKeyStoreId);
            newCustomKeyStoreName(model.newCustomKeyStoreName);
            keyStorePassword(model.keyStorePassword);
            cloudHsmClusterId(model.cloudHsmClusterId);
            xksProxyUriEndpoint(model.xksProxyUriEndpoint);
            xksProxyUriPath(model.xksProxyUriPath);
            xksProxyVpcEndpointServiceName(model.xksProxyVpcEndpointServiceName);
            xksProxyAuthenticationCredential(model.xksProxyAuthenticationCredential);
            xksProxyConnectivity(model.xksProxyConnectivity);
        }

        public final String getCustomKeyStoreId() {
            return customKeyStoreId;
        }

        public final void setCustomKeyStoreId(String customKeyStoreId) {
            this.customKeyStoreId = customKeyStoreId;
        }

        @Override
        public final Builder customKeyStoreId(String customKeyStoreId) {
            this.customKeyStoreId = customKeyStoreId;
            return this;
        }

        public final String getNewCustomKeyStoreName() {
            return newCustomKeyStoreName;
        }

        public final void setNewCustomKeyStoreName(String newCustomKeyStoreName) {
            this.newCustomKeyStoreName = newCustomKeyStoreName;
        }

        @Override
        public final Builder newCustomKeyStoreName(String newCustomKeyStoreName) {
            this.newCustomKeyStoreName = newCustomKeyStoreName;
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
        public UpdateCustomKeyStoreRequest build() {
            return new UpdateCustomKeyStoreRequest(this);
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
