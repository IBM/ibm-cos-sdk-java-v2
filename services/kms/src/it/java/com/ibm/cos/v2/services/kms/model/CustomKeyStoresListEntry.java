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

import java.io.Serializable;
import java.time.Instant;
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
import com.ibm.cos.v2.core.SdkField;
import com.ibm.cos.v2.core.SdkPojo;
import com.ibm.cos.v2.core.protocol.MarshallLocation;
import com.ibm.cos.v2.core.protocol.MarshallingType;
import com.ibm.cos.v2.core.traits.LocationTrait;
import com.ibm.cos.v2.utils.ToString;
import com.ibm.cos.v2.utils.builder.CopyableBuilder;
import com.ibm.cos.v2.utils.builder.ToCopyableBuilder;

/**
 * <p>
 * Contains information about each custom key store in the custom key store list.
 * </p>
 */
@Generated("com.ibm.cos.v2:codegen")
public final class CustomKeyStoresListEntry implements SdkPojo, Serializable,
        ToCopyableBuilder<CustomKeyStoresListEntry.Builder, CustomKeyStoresListEntry> {
    private static final SdkField<String> CUSTOM_KEY_STORE_ID_FIELD = SdkField.<String> builder(MarshallingType.STRING)
            .memberName("CustomKeyStoreId").getter(getter(CustomKeyStoresListEntry::customKeyStoreId))
            .setter(setter(Builder::customKeyStoreId))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("CustomKeyStoreId").build()).build();

    private static final SdkField<String> CUSTOM_KEY_STORE_NAME_FIELD = SdkField.<String> builder(MarshallingType.STRING)
            .memberName("CustomKeyStoreName").getter(getter(CustomKeyStoresListEntry::customKeyStoreName))
            .setter(setter(Builder::customKeyStoreName))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("CustomKeyStoreName").build())
            .build();

    private static final SdkField<String> CLOUD_HSM_CLUSTER_ID_FIELD = SdkField.<String> builder(MarshallingType.STRING)
            .memberName("CloudHsmClusterId").getter(getter(CustomKeyStoresListEntry::cloudHsmClusterId))
            .setter(setter(Builder::cloudHsmClusterId))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("CloudHsmClusterId").build()).build();

    private static final SdkField<String> TRUST_ANCHOR_CERTIFICATE_FIELD = SdkField.<String> builder(MarshallingType.STRING)
            .memberName("TrustAnchorCertificate").getter(getter(CustomKeyStoresListEntry::trustAnchorCertificate))
            .setter(setter(Builder::trustAnchorCertificate))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("TrustAnchorCertificate").build())
            .build();

    private static final SdkField<String> CONNECTION_STATE_FIELD = SdkField.<String> builder(MarshallingType.STRING)
            .memberName("ConnectionState").getter(getter(CustomKeyStoresListEntry::connectionStateAsString))
            .setter(setter(Builder::connectionState))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("ConnectionState").build()).build();

    private static final SdkField<String> CONNECTION_ERROR_CODE_FIELD = SdkField.<String> builder(MarshallingType.STRING)
            .memberName("ConnectionErrorCode").getter(getter(CustomKeyStoresListEntry::connectionErrorCodeAsString))
            .setter(setter(Builder::connectionErrorCode))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("ConnectionErrorCode").build())
            .build();

    private static final SdkField<Instant> CREATION_DATE_FIELD = SdkField.<Instant> builder(MarshallingType.INSTANT)
            .memberName("CreationDate").getter(getter(CustomKeyStoresListEntry::creationDate))
            .setter(setter(Builder::creationDate))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("CreationDate").build()).build();

    private static final SdkField<String> CUSTOM_KEY_STORE_TYPE_FIELD = SdkField.<String> builder(MarshallingType.STRING)
            .memberName("CustomKeyStoreType").getter(getter(CustomKeyStoresListEntry::customKeyStoreTypeAsString))
            .setter(setter(Builder::customKeyStoreType))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("CustomKeyStoreType").build())
            .build();

    private static final SdkField<XksProxyConfigurationType> XKS_PROXY_CONFIGURATION_FIELD = SdkField
            .<XksProxyConfigurationType> builder(MarshallingType.SDK_POJO).memberName("XksProxyConfiguration")
            .getter(getter(CustomKeyStoresListEntry::xksProxyConfiguration)).setter(setter(Builder::xksProxyConfiguration))
            .constructor(XksProxyConfigurationType::builder)
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("XksProxyConfiguration").build())
            .build();

    private static final List<SdkField<?>> SDK_FIELDS = Collections.unmodifiableList(Arrays.asList(CUSTOM_KEY_STORE_ID_FIELD,
            CUSTOM_KEY_STORE_NAME_FIELD, CLOUD_HSM_CLUSTER_ID_FIELD, TRUST_ANCHOR_CERTIFICATE_FIELD, CONNECTION_STATE_FIELD,
            CONNECTION_ERROR_CODE_FIELD, CREATION_DATE_FIELD, CUSTOM_KEY_STORE_TYPE_FIELD, XKS_PROXY_CONFIGURATION_FIELD));

    private static final Map<String, SdkField<?>> SDK_NAME_TO_FIELD = memberNameToFieldInitializer();

    private static final long serialVersionUID = 1L;

    private final String customKeyStoreId;

    private final String customKeyStoreName;

    private final String cloudHsmClusterId;

    private final String trustAnchorCertificate;

    private final String connectionState;

    private final String connectionErrorCode;

    private final Instant creationDate;

    private final String customKeyStoreType;

    private final XksProxyConfigurationType xksProxyConfiguration;

    private CustomKeyStoresListEntry(BuilderImpl builder) {
        this.customKeyStoreId = builder.customKeyStoreId;
        this.customKeyStoreName = builder.customKeyStoreName;
        this.cloudHsmClusterId = builder.cloudHsmClusterId;
        this.trustAnchorCertificate = builder.trustAnchorCertificate;
        this.connectionState = builder.connectionState;
        this.connectionErrorCode = builder.connectionErrorCode;
        this.creationDate = builder.creationDate;
        this.customKeyStoreType = builder.customKeyStoreType;
        this.xksProxyConfiguration = builder.xksProxyConfiguration;
    }

    /**
     * <p>
     * A unique identifier for the custom key store.
     * </p>
     * 
     * @return A unique identifier for the custom key store.
     */
    public final String customKeyStoreId() {
        return customKeyStoreId;
    }

    /**
     * <p>
     * The user-specified friendly name for the custom key store.
     * </p>
     * 
     * @return The user-specified friendly name for the custom key store.
     */
    public final String customKeyStoreName() {
        return customKeyStoreName;
    }

    /**
     * <p>
     * A unique identifier for the CloudHSM cluster that is associated with an CloudHSM key store. This field appears
     * only when the <code>CustomKeyStoreType</code> is <code>AWS_CLOUDHSM</code>.
     * </p>
     * 
     * @return A unique identifier for the CloudHSM cluster that is associated with an CloudHSM key store. This field
     *         appears only when the <code>CustomKeyStoreType</code> is <code>AWS_CLOUDHSM</code>.
     */
    public final String cloudHsmClusterId() {
        return cloudHsmClusterId;
    }

    /**
     * <p>
     * The trust anchor certificate of the CloudHSM cluster associated with an CloudHSM key store. When you <a
     * href="https://docs.aws.amazon.com/cloudhsm/latest/userguide/initialize-cluster.html#sign-csr">initialize the
     * cluster</a>, you create this certificate and save it in the <code>customerCA.crt</code> file.
     * </p>
     * <p>
     * This field appears only when the <code>CustomKeyStoreType</code> is <code>AWS_CLOUDHSM</code>.
     * </p>
     * 
     * @return The trust anchor certificate of the CloudHSM cluster associated with an CloudHSM key store. When you <a
     *         href="https://docs.aws.amazon.com/cloudhsm/latest/userguide/initialize-cluster.html#sign-csr">initialize
     *         the cluster</a>, you create this certificate and save it in the <code>customerCA.crt</code> file.</p>
     *         <p>
     *         This field appears only when the <code>CustomKeyStoreType</code> is <code>AWS_CLOUDHSM</code>.
     */
    public final String trustAnchorCertificate() {
        return trustAnchorCertificate;
    }

    /**
     * <p>
     * Indicates whether the custom key store is connected to its backing key store. For an CloudHSM key store, the
     * <code>ConnectionState</code> indicates whether it is connected to its CloudHSM cluster. For an external key
     * store, the <code>ConnectionState</code> indicates whether it is connected to the external key store proxy that
     * communicates with your external key manager.
     * </p>
     * <p>
     * You can create and use KMS keys in your custom key stores only when its <code>ConnectionState</code> is
     * <code>CONNECTED</code>.
     * </p>
     * <p>
     * The <code>ConnectionState</code> value is <code>DISCONNECTED</code> only if the key store has never been
     * connected or you use the <a>DisconnectCustomKeyStore</a> operation to disconnect it. If the value is
     * <code>CONNECTED</code> but you are having trouble using the custom key store, make sure that the backing key
     * store is reachable and active. For an CloudHSM key store, verify that its associated CloudHSM cluster is active
     * and contains at least one active HSM. For an external key store, verify that the external key store proxy and
     * external key manager are connected and enabled.
     * </p>
     * <p>
     * A value of <code>FAILED</code> indicates that an attempt to connect was unsuccessful. The
     * <code>ConnectionErrorCode</code> field in the response indicates the cause of the failure. For help resolving a
     * connection failure, see <a
     * href="https://docs.aws.amazon.com/kms/latest/developerguide/fix-keystore.html">Troubleshooting a custom key
     * store</a> in the <i>Key Management Service Developer Guide</i>.
     * </p>
     * <p>
     * If the service returns an enum value that is not available in the current SDK version, {@link #connectionState}
     * will return {@link ConnectionStateType#UNKNOWN_TO_SDK_VERSION}. The raw value returned by the service is
     * available from {@link #connectionStateAsString}.
     * </p>
     * 
     * @return Indicates whether the custom key store is connected to its backing key store. For an CloudHSM key store,
     *         the <code>ConnectionState</code> indicates whether it is connected to its CloudHSM cluster. For an
     *         external key store, the <code>ConnectionState</code> indicates whether it is connected to the external
     *         key store proxy that communicates with your external key manager.</p>
     *         <p>
     *         You can create and use KMS keys in your custom key stores only when its <code>ConnectionState</code> is
     *         <code>CONNECTED</code>.
     *         </p>
     *         <p>
     *         The <code>ConnectionState</code> value is <code>DISCONNECTED</code> only if the key store has never been
     *         connected or you use the <a>DisconnectCustomKeyStore</a> operation to disconnect it. If the value is
     *         <code>CONNECTED</code> but you are having trouble using the custom key store, make sure that the backing
     *         key store is reachable and active. For an CloudHSM key store, verify that its associated CloudHSM cluster
     *         is active and contains at least one active HSM. For an external key store, verify that the external key
     *         store proxy and external key manager are connected and enabled.
     *         </p>
     *         <p>
     *         A value of <code>FAILED</code> indicates that an attempt to connect was unsuccessful. The
     *         <code>ConnectionErrorCode</code> field in the response indicates the cause of the failure. For help
     *         resolving a connection failure, see <a
     *         href="https://docs.aws.amazon.com/kms/latest/developerguide/fix-keystore.html">Troubleshooting a custom
     *         key store</a> in the <i>Key Management Service Developer Guide</i>.
     * @see ConnectionStateType
     */
    public final ConnectionStateType connectionState() {
        return ConnectionStateType.fromValue(connectionState);
    }

    /**
     * <p>
     * Indicates whether the custom key store is connected to its backing key store. For an CloudHSM key store, the
     * <code>ConnectionState</code> indicates whether it is connected to its CloudHSM cluster. For an external key
     * store, the <code>ConnectionState</code> indicates whether it is connected to the external key store proxy that
     * communicates with your external key manager.
     * </p>
     * <p>
     * You can create and use KMS keys in your custom key stores only when its <code>ConnectionState</code> is
     * <code>CONNECTED</code>.
     * </p>
     * <p>
     * The <code>ConnectionState</code> value is <code>DISCONNECTED</code> only if the key store has never been
     * connected or you use the <a>DisconnectCustomKeyStore</a> operation to disconnect it. If the value is
     * <code>CONNECTED</code> but you are having trouble using the custom key store, make sure that the backing key
     * store is reachable and active. For an CloudHSM key store, verify that its associated CloudHSM cluster is active
     * and contains at least one active HSM. For an external key store, verify that the external key store proxy and
     * external key manager are connected and enabled.
     * </p>
     * <p>
     * A value of <code>FAILED</code> indicates that an attempt to connect was unsuccessful. The
     * <code>ConnectionErrorCode</code> field in the response indicates the cause of the failure. For help resolving a
     * connection failure, see <a
     * href="https://docs.aws.amazon.com/kms/latest/developerguide/fix-keystore.html">Troubleshooting a custom key
     * store</a> in the <i>Key Management Service Developer Guide</i>.
     * </p>
     * <p>
     * If the service returns an enum value that is not available in the current SDK version, {@link #connectionState}
     * will return {@link ConnectionStateType#UNKNOWN_TO_SDK_VERSION}. The raw value returned by the service is
     * available from {@link #connectionStateAsString}.
     * </p>
     * 
     * @return Indicates whether the custom key store is connected to its backing key store. For an CloudHSM key store,
     *         the <code>ConnectionState</code> indicates whether it is connected to its CloudHSM cluster. For an
     *         external key store, the <code>ConnectionState</code> indicates whether it is connected to the external
     *         key store proxy that communicates with your external key manager.</p>
     *         <p>
     *         You can create and use KMS keys in your custom key stores only when its <code>ConnectionState</code> is
     *         <code>CONNECTED</code>.
     *         </p>
     *         <p>
     *         The <code>ConnectionState</code> value is <code>DISCONNECTED</code> only if the key store has never been
     *         connected or you use the <a>DisconnectCustomKeyStore</a> operation to disconnect it. If the value is
     *         <code>CONNECTED</code> but you are having trouble using the custom key store, make sure that the backing
     *         key store is reachable and active. For an CloudHSM key store, verify that its associated CloudHSM cluster
     *         is active and contains at least one active HSM. For an external key store, verify that the external key
     *         store proxy and external key manager are connected and enabled.
     *         </p>
     *         <p>
     *         A value of <code>FAILED</code> indicates that an attempt to connect was unsuccessful. The
     *         <code>ConnectionErrorCode</code> field in the response indicates the cause of the failure. For help
     *         resolving a connection failure, see <a
     *         href="https://docs.aws.amazon.com/kms/latest/developerguide/fix-keystore.html">Troubleshooting a custom
     *         key store</a> in the <i>Key Management Service Developer Guide</i>.
     * @see ConnectionStateType
     */
    public final String connectionStateAsString() {
        return connectionState;
    }

    /**
     * <p>
     * Describes the connection error. This field appears in the response only when the <code>ConnectionState</code> is
     * <code>FAILED</code>.
     * </p>
     * <p>
     * Many failures can be resolved by updating the properties of the custom key store. To update a custom key store,
     * disconnect it (<a>DisconnectCustomKeyStore</a>), correct the errors (<a>UpdateCustomKeyStore</a>), and try to
     * connect again (<a>ConnectCustomKeyStore</a>). For additional help resolving these errors, see <a
     * href="https://docs.aws.amazon.com/kms/latest/developerguide/fix-keystore.html#fix-keystore-failed">How to Fix a
     * Connection Failure</a> in <i>Key Management Service Developer Guide</i>.
     * </p>
     * <p>
     * <b>All custom key stores:</b>
     * </p>
     * <ul>
     * <li>
     * <p>
     * <code>INTERNAL_ERROR</code> — KMS could not complete the request due to an internal error. Retry the request. For
     * <code>ConnectCustomKeyStore</code> requests, disconnect the custom key store before trying to connect again.
     * </p>
     * </li>
     * <li>
     * <p>
     * <code>NETWORK_ERRORS</code> — Network errors are preventing KMS from connecting the custom key store to its
     * backing key store.
     * </p>
     * </li>
     * </ul>
     * <p>
     * <b>CloudHSM key stores:</b>
     * </p>
     * <ul>
     * <li>
     * <p>
     * <code>CLUSTER_NOT_FOUND</code> — KMS cannot find the CloudHSM cluster with the specified cluster ID.
     * </p>
     * </li>
     * <li>
     * <p>
     * <code>INSUFFICIENT_CLOUDHSM_HSMS</code> — The associated CloudHSM cluster does not contain any active HSMs. To
     * connect a custom key store to its CloudHSM cluster, the cluster must contain at least one active HSM.
     * </p>
     * </li>
     * <li>
     * <p>
     * <code>INSUFFICIENT_FREE_ADDRESSES_IN_SUBNET</code> — At least one private subnet associated with the CloudHSM
     * cluster doesn't have any available IP addresses. A CloudHSM key store connection requires one free IP address in
     * each of the associated private subnets, although two are preferable. For details, see <a
     * href="https://docs.aws.amazon.com/kms/latest/developerguide/fix-keystore.html#fix-keystore-failed">How to Fix a
     * Connection Failure</a> in the <i>Key Management Service Developer Guide</i>.
     * </p>
     * </li>
     * <li>
     * <p>
     * <code>INVALID_CREDENTIALS</code> — The <code>KeyStorePassword</code> for the custom key store doesn't match the
     * current password of the <code>kmsuser</code> crypto user in the CloudHSM cluster. Before you can connect your
     * custom key store to its CloudHSM cluster, you must change the <code>kmsuser</code> account password and update
     * the <code>KeyStorePassword</code> value for the custom key store.
     * </p>
     * </li>
     * <li>
     * <p>
     * <code>SUBNET_NOT_FOUND</code> — A subnet in the CloudHSM cluster configuration was deleted. If KMS cannot find
     * all of the subnets in the cluster configuration, attempts to connect the custom key store to the CloudHSM cluster
     * fail. To fix this error, create a cluster from a recent backup and associate it with your custom key store. (This
     * process creates a new cluster configuration with a VPC and private subnets.) For details, see <a
     * href="https://docs.aws.amazon.com/kms/latest/developerguide/fix-keystore.html#fix-keystore-failed">How to Fix a
     * Connection Failure</a> in the <i>Key Management Service Developer Guide</i>.
     * </p>
     * </li>
     * <li>
     * <p>
     * <code>USER_LOCKED_OUT</code> — The <code>kmsuser</code> CU account is locked out of the associated CloudHSM
     * cluster due to too many failed password attempts. Before you can connect your custom key store to its CloudHSM
     * cluster, you must change the <code>kmsuser</code> account password and update the key store password value for
     * the custom key store.
     * </p>
     * </li>
     * <li>
     * <p>
     * <code>USER_LOGGED_IN</code> — The <code>kmsuser</code> CU account is logged into the associated CloudHSM cluster.
     * This prevents KMS from rotating the <code>kmsuser</code> account password and logging into the cluster. Before
     * you can connect your custom key store to its CloudHSM cluster, you must log the <code>kmsuser</code> CU out of
     * the cluster. If you changed the <code>kmsuser</code> password to log into the cluster, you must also and update
     * the key store password value for the custom key store. For help, see <a
     * href="https://docs.aws.amazon.com/kms/latest/developerguide/fix-keystore.html#login-kmsuser-2">How to Log Out and
     * Reconnect</a> in the <i>Key Management Service Developer Guide</i>.
     * </p>
     * </li>
     * <li>
     * <p>
     * <code>USER_NOT_FOUND</code> — KMS cannot find a <code>kmsuser</code> CU account in the associated CloudHSM
     * cluster. Before you can connect your custom key store to its CloudHSM cluster, you must create a
     * <code>kmsuser</code> CU account in the cluster, and then update the key store password value for the custom key
     * store.
     * </p>
     * </li>
     * </ul>
     * <p>
     * <b>External key stores:</b>
     * </p>
     * <ul>
     * <li>
     * <p>
     * <code>INVALID_CREDENTIALS</code> — One or both of the <code>XksProxyAuthenticationCredential</code> values is not
     * valid on the specified external key store proxy.
     * </p>
     * </li>
     * <li>
     * <p>
     * <code>XKS_PROXY_ACCESS_DENIED</code> — KMS requests are denied access to the external key store proxy. If the
     * external key store proxy has authorization rules, verify that they permit KMS to communicate with the proxy on
     * your behalf.
     * </p>
     * </li>
     * <li>
     * <p>
     * <code>XKS_PROXY_INVALID_CONFIGURATION</code> — A configuration error is preventing the external key store from
     * connecting to its proxy. Verify the value of the <code>XksProxyUriPath</code>.
     * </p>
     * </li>
     * <li>
     * <p>
     * <code>XKS_PROXY_INVALID_RESPONSE</code> — KMS cannot interpret the response from the external key store proxy. If
     * you see this connection error code repeatedly, notify your external key store proxy vendor.
     * </p>
     * </li>
     * <li>
     * <p>
     * <code>XKS_PROXY_INVALID_TLS_CONFIGURATION</code> — KMS cannot connect to the external key store proxy because the
     * TLS configuration is invalid. Verify that the XKS proxy supports TLS 1.2 or 1.3. Also, verify that the TLS
     * certificate is not expired, and that it matches the hostname in the <code>XksProxyUriEndpoint</code> value, and
     * that it is signed by a certificate authority included in the <a
     * href="https://github.com/aws/aws-kms-xksproxy-api-spec/blob/main/TrustedCertificateAuthorities">Trusted
     * Certificate Authorities</a> list.
     * </p>
     * </li>
     * <li>
     * <p>
     * <code>XKS_PROXY_NOT_REACHABLE</code> — KMS can't communicate with your external key store proxy. Verify that the
     * <code>XksProxyUriEndpoint</code> and <code>XksProxyUriPath</code> are correct. Use the tools for your external
     * key store proxy to verify that the proxy is active and available on its network. Also, verify that your external
     * key manager instances are operating properly. Connection attempts fail with this connection error code if the
     * proxy reports that all external key manager instances are unavailable.
     * </p>
     * </li>
     * <li>
     * <p>
     * <code>XKS_PROXY_TIMED_OUT</code> — KMS can connect to the external key store proxy, but the proxy does not
     * respond to KMS in the time allotted. If you see this connection error code repeatedly, notify your external key
     * store proxy vendor.
     * </p>
     * </li>
     * <li>
     * <p>
     * <code>XKS_VPC_ENDPOINT_SERVICE_INVALID_CONFIGURATION</code> — The Amazon VPC endpoint service configuration
     * doesn't conform to the requirements for an KMS external key store.
     * </p>
     * <ul>
     * <li>
     * <p>
     * The VPC endpoint service must be an endpoint service for interface endpoints in the caller's Amazon Web Services
     * account.
     * </p>
     * </li>
     * <li>
     * <p>
     * It must have a network load balancer (NLB) connected to at least two subnets, each in a different Availability
     * Zone.
     * </p>
     * </li>
     * <li>
     * <p>
     * The <code>Allow principals</code> list must include the KMS service principal for the Region,
     * <code>cks.kms.&lt;region&gt;.amazonaws.com</code>, such as <code>cks.kms.us-east-1.amazonaws.com</code>.
     * </p>
     * </li>
     * <li>
     * <p>
     * It must <i>not</i> require <a
     * href="https://docs.aws.amazon.com/vpc/latest/privatelink/create-endpoint-service.html">acceptance</a> of
     * connection requests.
     * </p>
     * </li>
     * <li>
     * <p>
     * It must have a private DNS name. The private DNS name for an external key store with
     * <code>VPC_ENDPOINT_SERVICE</code> connectivity must be unique in its Amazon Web Services Region.
     * </p>
     * </li>
     * <li>
     * <p>
     * The domain of the private DNS name must have a <a
     * href="https://docs.aws.amazon.com/vpc/latest/privatelink/verify-domains.html">verification status</a> of
     * <code>verified</code>.
     * </p>
     * </li>
     * <li>
     * <p>
     * The <a href="https://docs.aws.amazon.com/elasticloadbalancing/latest/network/create-tls-listener.html">TLS
     * certificate</a> specifies the private DNS hostname at which the endpoint is reachable.
     * </p>
     * </li>
     * </ul>
     * </li>
     * <li>
     * <p>
     * <code>XKS_VPC_ENDPOINT_SERVICE_NOT_FOUND</code> — KMS can't find the VPC endpoint service that it uses to
     * communicate with the external key store proxy. Verify that the <code>XksProxyVpcEndpointServiceName</code> is
     * correct and the KMS service principal has service consumer permissions on the Amazon VPC endpoint service.
     * </p>
     * </li>
     * </ul>
     * <p>
     * If the service returns an enum value that is not available in the current SDK version,
     * {@link #connectionErrorCode} will return {@link ConnectionErrorCodeType#UNKNOWN_TO_SDK_VERSION}. The raw value
     * returned by the service is available from {@link #connectionErrorCodeAsString}.
     * </p>
     * 
     * @return Describes the connection error. This field appears in the response only when the
     *         <code>ConnectionState</code> is <code>FAILED</code>.</p>
     *         <p>
     *         Many failures can be resolved by updating the properties of the custom key store. To update a custom key
     *         store, disconnect it (<a>DisconnectCustomKeyStore</a>), correct the errors (<a>UpdateCustomKeyStore</a>),
     *         and try to connect again (<a>ConnectCustomKeyStore</a>). For additional help resolving these errors, see
     *         <a href="https://docs.aws.amazon.com/kms/latest/developerguide/fix-keystore.html#fix-keystore-failed">How
     *         to Fix a Connection Failure</a> in <i>Key Management Service Developer Guide</i>.
     *         </p>
     *         <p>
     *         <b>All custom key stores:</b>
     *         </p>
     *         <ul>
     *         <li>
     *         <p>
     *         <code>INTERNAL_ERROR</code> — KMS could not complete the request due to an internal error. Retry the
     *         request. For <code>ConnectCustomKeyStore</code> requests, disconnect the custom key store before trying
     *         to connect again.
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         <code>NETWORK_ERRORS</code> — Network errors are preventing KMS from connecting the custom key store to
     *         its backing key store.
     *         </p>
     *         </li>
     *         </ul>
     *         <p>
     *         <b>CloudHSM key stores:</b>
     *         </p>
     *         <ul>
     *         <li>
     *         <p>
     *         <code>CLUSTER_NOT_FOUND</code> — KMS cannot find the CloudHSM cluster with the specified cluster ID.
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         <code>INSUFFICIENT_CLOUDHSM_HSMS</code> — The associated CloudHSM cluster does not contain any active
     *         HSMs. To connect a custom key store to its CloudHSM cluster, the cluster must contain at least one active
     *         HSM.
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         <code>INSUFFICIENT_FREE_ADDRESSES_IN_SUBNET</code> — At least one private subnet associated with the
     *         CloudHSM cluster doesn't have any available IP addresses. A CloudHSM key store connection requires one
     *         free IP address in each of the associated private subnets, although two are preferable. For details, see
     *         <a href="https://docs.aws.amazon.com/kms/latest/developerguide/fix-keystore.html#fix-keystore-failed">How
     *         to Fix a Connection Failure</a> in the <i>Key Management Service Developer Guide</i>.
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         <code>INVALID_CREDENTIALS</code> — The <code>KeyStorePassword</code> for the custom key store doesn't
     *         match the current password of the <code>kmsuser</code> crypto user in the CloudHSM cluster. Before you
     *         can connect your custom key store to its CloudHSM cluster, you must change the <code>kmsuser</code>
     *         account password and update the <code>KeyStorePassword</code> value for the custom key store.
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         <code>SUBNET_NOT_FOUND</code> — A subnet in the CloudHSM cluster configuration was deleted. If KMS cannot
     *         find all of the subnets in the cluster configuration, attempts to connect the custom key store to the
     *         CloudHSM cluster fail. To fix this error, create a cluster from a recent backup and associate it with
     *         your custom key store. (This process creates a new cluster configuration with a VPC and private subnets.)
     *         For details, see <a
     *         href="https://docs.aws.amazon.com/kms/latest/developerguide/fix-keystore.html#fix-keystore-failed">How to
     *         Fix a Connection Failure</a> in the <i>Key Management Service Developer Guide</i>.
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         <code>USER_LOCKED_OUT</code> — The <code>kmsuser</code> CU account is locked out of the associated
     *         CloudHSM cluster due to too many failed password attempts. Before you can connect your custom key store
     *         to its CloudHSM cluster, you must change the <code>kmsuser</code> account password and update the key
     *         store password value for the custom key store.
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         <code>USER_LOGGED_IN</code> — The <code>kmsuser</code> CU account is logged into the associated CloudHSM
     *         cluster. This prevents KMS from rotating the <code>kmsuser</code> account password and logging into the
     *         cluster. Before you can connect your custom key store to its CloudHSM cluster, you must log the
     *         <code>kmsuser</code> CU out of the cluster. If you changed the <code>kmsuser</code> password to log into
     *         the cluster, you must also and update the key store password value for the custom key store. For help,
     *         see <a href="https://docs.aws.amazon.com/kms/latest/developerguide/fix-keystore.html#login-kmsuser-2">How
     *         to Log Out and Reconnect</a> in the <i>Key Management Service Developer Guide</i>.
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         <code>USER_NOT_FOUND</code> — KMS cannot find a <code>kmsuser</code> CU account in the associated
     *         CloudHSM cluster. Before you can connect your custom key store to its CloudHSM cluster, you must create a
     *         <code>kmsuser</code> CU account in the cluster, and then update the key store password value for the
     *         custom key store.
     *         </p>
     *         </li>
     *         </ul>
     *         <p>
     *         <b>External key stores:</b>
     *         </p>
     *         <ul>
     *         <li>
     *         <p>
     *         <code>INVALID_CREDENTIALS</code> — One or both of the <code>XksProxyAuthenticationCredential</code>
     *         values is not valid on the specified external key store proxy.
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         <code>XKS_PROXY_ACCESS_DENIED</code> — KMS requests are denied access to the external key store proxy. If
     *         the external key store proxy has authorization rules, verify that they permit KMS to communicate with the
     *         proxy on your behalf.
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         <code>XKS_PROXY_INVALID_CONFIGURATION</code> — A configuration error is preventing the external key store
     *         from connecting to its proxy. Verify the value of the <code>XksProxyUriPath</code>.
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         <code>XKS_PROXY_INVALID_RESPONSE</code> — KMS cannot interpret the response from the external key store
     *         proxy. If you see this connection error code repeatedly, notify your external key store proxy vendor.
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         <code>XKS_PROXY_INVALID_TLS_CONFIGURATION</code> — KMS cannot connect to the external key store proxy
     *         because the TLS configuration is invalid. Verify that the XKS proxy supports TLS 1.2 or 1.3. Also, verify
     *         that the TLS certificate is not expired, and that it matches the hostname in the
     *         <code>XksProxyUriEndpoint</code> value, and that it is signed by a certificate authority included in the
     *         <a
     *         href="https://github.com/aws/aws-kms-xksproxy-api-spec/blob/main/TrustedCertificateAuthorities">Trusted
     *         Certificate Authorities</a> list.
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         <code>XKS_PROXY_NOT_REACHABLE</code> — KMS can't communicate with your external key store proxy. Verify
     *         that the <code>XksProxyUriEndpoint</code> and <code>XksProxyUriPath</code> are correct. Use the tools for
     *         your external key store proxy to verify that the proxy is active and available on its network. Also,
     *         verify that your external key manager instances are operating properly. Connection attempts fail with
     *         this connection error code if the proxy reports that all external key manager instances are unavailable.
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         <code>XKS_PROXY_TIMED_OUT</code> — KMS can connect to the external key store proxy, but the proxy does
     *         not respond to KMS in the time allotted. If you see this connection error code repeatedly, notify your
     *         external key store proxy vendor.
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         <code>XKS_VPC_ENDPOINT_SERVICE_INVALID_CONFIGURATION</code> — The Amazon VPC endpoint service
     *         configuration doesn't conform to the requirements for an KMS external key store.
     *         </p>
     *         <ul>
     *         <li>
     *         <p>
     *         The VPC endpoint service must be an endpoint service for interface endpoints in the caller's Amazon Web
     *         Services account.
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         It must have a network load balancer (NLB) connected to at least two subnets, each in a different
     *         Availability Zone.
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         The <code>Allow principals</code> list must include the KMS service principal for the Region,
     *         <code>cks.kms.&lt;region&gt;.amazonaws.com</code>, such as <code>cks.kms.us-east-1.amazonaws.com</code>.
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         It must <i>not</i> require <a
     *         href="https://docs.aws.amazon.com/vpc/latest/privatelink/create-endpoint-service.html">acceptance</a> of
     *         connection requests.
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         It must have a private DNS name. The private DNS name for an external key store with
     *         <code>VPC_ENDPOINT_SERVICE</code> connectivity must be unique in its Amazon Web Services Region.
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         The domain of the private DNS name must have a <a
     *         href="https://docs.aws.amazon.com/vpc/latest/privatelink/verify-domains.html">verification status</a> of
     *         <code>verified</code>.
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         The <a
     *         href="https://docs.aws.amazon.com/elasticloadbalancing/latest/network/create-tls-listener.html">TLS
     *         certificate</a> specifies the private DNS hostname at which the endpoint is reachable.
     *         </p>
     *         </li>
     *         </ul>
     *         </li>
     *         <li>
     *         <p>
     *         <code>XKS_VPC_ENDPOINT_SERVICE_NOT_FOUND</code> — KMS can't find the VPC endpoint service that it uses to
     *         communicate with the external key store proxy. Verify that the
     *         <code>XksProxyVpcEndpointServiceName</code> is correct and the KMS service principal has service consumer
     *         permissions on the Amazon VPC endpoint service.
     *         </p>
     *         </li>
     * @see ConnectionErrorCodeType
     */
    public final ConnectionErrorCodeType connectionErrorCode() {
        return ConnectionErrorCodeType.fromValue(connectionErrorCode);
    }

    /**
     * <p>
     * Describes the connection error. This field appears in the response only when the <code>ConnectionState</code> is
     * <code>FAILED</code>.
     * </p>
     * <p>
     * Many failures can be resolved by updating the properties of the custom key store. To update a custom key store,
     * disconnect it (<a>DisconnectCustomKeyStore</a>), correct the errors (<a>UpdateCustomKeyStore</a>), and try to
     * connect again (<a>ConnectCustomKeyStore</a>). For additional help resolving these errors, see <a
     * href="https://docs.aws.amazon.com/kms/latest/developerguide/fix-keystore.html#fix-keystore-failed">How to Fix a
     * Connection Failure</a> in <i>Key Management Service Developer Guide</i>.
     * </p>
     * <p>
     * <b>All custom key stores:</b>
     * </p>
     * <ul>
     * <li>
     * <p>
     * <code>INTERNAL_ERROR</code> — KMS could not complete the request due to an internal error. Retry the request. For
     * <code>ConnectCustomKeyStore</code> requests, disconnect the custom key store before trying to connect again.
     * </p>
     * </li>
     * <li>
     * <p>
     * <code>NETWORK_ERRORS</code> — Network errors are preventing KMS from connecting the custom key store to its
     * backing key store.
     * </p>
     * </li>
     * </ul>
     * <p>
     * <b>CloudHSM key stores:</b>
     * </p>
     * <ul>
     * <li>
     * <p>
     * <code>CLUSTER_NOT_FOUND</code> — KMS cannot find the CloudHSM cluster with the specified cluster ID.
     * </p>
     * </li>
     * <li>
     * <p>
     * <code>INSUFFICIENT_CLOUDHSM_HSMS</code> — The associated CloudHSM cluster does not contain any active HSMs. To
     * connect a custom key store to its CloudHSM cluster, the cluster must contain at least one active HSM.
     * </p>
     * </li>
     * <li>
     * <p>
     * <code>INSUFFICIENT_FREE_ADDRESSES_IN_SUBNET</code> — At least one private subnet associated with the CloudHSM
     * cluster doesn't have any available IP addresses. A CloudHSM key store connection requires one free IP address in
     * each of the associated private subnets, although two are preferable. For details, see <a
     * href="https://docs.aws.amazon.com/kms/latest/developerguide/fix-keystore.html#fix-keystore-failed">How to Fix a
     * Connection Failure</a> in the <i>Key Management Service Developer Guide</i>.
     * </p>
     * </li>
     * <li>
     * <p>
     * <code>INVALID_CREDENTIALS</code> — The <code>KeyStorePassword</code> for the custom key store doesn't match the
     * current password of the <code>kmsuser</code> crypto user in the CloudHSM cluster. Before you can connect your
     * custom key store to its CloudHSM cluster, you must change the <code>kmsuser</code> account password and update
     * the <code>KeyStorePassword</code> value for the custom key store.
     * </p>
     * </li>
     * <li>
     * <p>
     * <code>SUBNET_NOT_FOUND</code> — A subnet in the CloudHSM cluster configuration was deleted. If KMS cannot find
     * all of the subnets in the cluster configuration, attempts to connect the custom key store to the CloudHSM cluster
     * fail. To fix this error, create a cluster from a recent backup and associate it with your custom key store. (This
     * process creates a new cluster configuration with a VPC and private subnets.) For details, see <a
     * href="https://docs.aws.amazon.com/kms/latest/developerguide/fix-keystore.html#fix-keystore-failed">How to Fix a
     * Connection Failure</a> in the <i>Key Management Service Developer Guide</i>.
     * </p>
     * </li>
     * <li>
     * <p>
     * <code>USER_LOCKED_OUT</code> — The <code>kmsuser</code> CU account is locked out of the associated CloudHSM
     * cluster due to too many failed password attempts. Before you can connect your custom key store to its CloudHSM
     * cluster, you must change the <code>kmsuser</code> account password and update the key store password value for
     * the custom key store.
     * </p>
     * </li>
     * <li>
     * <p>
     * <code>USER_LOGGED_IN</code> — The <code>kmsuser</code> CU account is logged into the associated CloudHSM cluster.
     * This prevents KMS from rotating the <code>kmsuser</code> account password and logging into the cluster. Before
     * you can connect your custom key store to its CloudHSM cluster, you must log the <code>kmsuser</code> CU out of
     * the cluster. If you changed the <code>kmsuser</code> password to log into the cluster, you must also and update
     * the key store password value for the custom key store. For help, see <a
     * href="https://docs.aws.amazon.com/kms/latest/developerguide/fix-keystore.html#login-kmsuser-2">How to Log Out and
     * Reconnect</a> in the <i>Key Management Service Developer Guide</i>.
     * </p>
     * </li>
     * <li>
     * <p>
     * <code>USER_NOT_FOUND</code> — KMS cannot find a <code>kmsuser</code> CU account in the associated CloudHSM
     * cluster. Before you can connect your custom key store to its CloudHSM cluster, you must create a
     * <code>kmsuser</code> CU account in the cluster, and then update the key store password value for the custom key
     * store.
     * </p>
     * </li>
     * </ul>
     * <p>
     * <b>External key stores:</b>
     * </p>
     * <ul>
     * <li>
     * <p>
     * <code>INVALID_CREDENTIALS</code> — One or both of the <code>XksProxyAuthenticationCredential</code> values is not
     * valid on the specified external key store proxy.
     * </p>
     * </li>
     * <li>
     * <p>
     * <code>XKS_PROXY_ACCESS_DENIED</code> — KMS requests are denied access to the external key store proxy. If the
     * external key store proxy has authorization rules, verify that they permit KMS to communicate with the proxy on
     * your behalf.
     * </p>
     * </li>
     * <li>
     * <p>
     * <code>XKS_PROXY_INVALID_CONFIGURATION</code> — A configuration error is preventing the external key store from
     * connecting to its proxy. Verify the value of the <code>XksProxyUriPath</code>.
     * </p>
     * </li>
     * <li>
     * <p>
     * <code>XKS_PROXY_INVALID_RESPONSE</code> — KMS cannot interpret the response from the external key store proxy. If
     * you see this connection error code repeatedly, notify your external key store proxy vendor.
     * </p>
     * </li>
     * <li>
     * <p>
     * <code>XKS_PROXY_INVALID_TLS_CONFIGURATION</code> — KMS cannot connect to the external key store proxy because the
     * TLS configuration is invalid. Verify that the XKS proxy supports TLS 1.2 or 1.3. Also, verify that the TLS
     * certificate is not expired, and that it matches the hostname in the <code>XksProxyUriEndpoint</code> value, and
     * that it is signed by a certificate authority included in the <a
     * href="https://github.com/aws/aws-kms-xksproxy-api-spec/blob/main/TrustedCertificateAuthorities">Trusted
     * Certificate Authorities</a> list.
     * </p>
     * </li>
     * <li>
     * <p>
     * <code>XKS_PROXY_NOT_REACHABLE</code> — KMS can't communicate with your external key store proxy. Verify that the
     * <code>XksProxyUriEndpoint</code> and <code>XksProxyUriPath</code> are correct. Use the tools for your external
     * key store proxy to verify that the proxy is active and available on its network. Also, verify that your external
     * key manager instances are operating properly. Connection attempts fail with this connection error code if the
     * proxy reports that all external key manager instances are unavailable.
     * </p>
     * </li>
     * <li>
     * <p>
     * <code>XKS_PROXY_TIMED_OUT</code> — KMS can connect to the external key store proxy, but the proxy does not
     * respond to KMS in the time allotted. If you see this connection error code repeatedly, notify your external key
     * store proxy vendor.
     * </p>
     * </li>
     * <li>
     * <p>
     * <code>XKS_VPC_ENDPOINT_SERVICE_INVALID_CONFIGURATION</code> — The Amazon VPC endpoint service configuration
     * doesn't conform to the requirements for an KMS external key store.
     * </p>
     * <ul>
     * <li>
     * <p>
     * The VPC endpoint service must be an endpoint service for interface endpoints in the caller's Amazon Web Services
     * account.
     * </p>
     * </li>
     * <li>
     * <p>
     * It must have a network load balancer (NLB) connected to at least two subnets, each in a different Availability
     * Zone.
     * </p>
     * </li>
     * <li>
     * <p>
     * The <code>Allow principals</code> list must include the KMS service principal for the Region,
     * <code>cks.kms.&lt;region&gt;.amazonaws.com</code>, such as <code>cks.kms.us-east-1.amazonaws.com</code>.
     * </p>
     * </li>
     * <li>
     * <p>
     * It must <i>not</i> require <a
     * href="https://docs.aws.amazon.com/vpc/latest/privatelink/create-endpoint-service.html">acceptance</a> of
     * connection requests.
     * </p>
     * </li>
     * <li>
     * <p>
     * It must have a private DNS name. The private DNS name for an external key store with
     * <code>VPC_ENDPOINT_SERVICE</code> connectivity must be unique in its Amazon Web Services Region.
     * </p>
     * </li>
     * <li>
     * <p>
     * The domain of the private DNS name must have a <a
     * href="https://docs.aws.amazon.com/vpc/latest/privatelink/verify-domains.html">verification status</a> of
     * <code>verified</code>.
     * </p>
     * </li>
     * <li>
     * <p>
     * The <a href="https://docs.aws.amazon.com/elasticloadbalancing/latest/network/create-tls-listener.html">TLS
     * certificate</a> specifies the private DNS hostname at which the endpoint is reachable.
     * </p>
     * </li>
     * </ul>
     * </li>
     * <li>
     * <p>
     * <code>XKS_VPC_ENDPOINT_SERVICE_NOT_FOUND</code> — KMS can't find the VPC endpoint service that it uses to
     * communicate with the external key store proxy. Verify that the <code>XksProxyVpcEndpointServiceName</code> is
     * correct and the KMS service principal has service consumer permissions on the Amazon VPC endpoint service.
     * </p>
     * </li>
     * </ul>
     * <p>
     * If the service returns an enum value that is not available in the current SDK version,
     * {@link #connectionErrorCode} will return {@link ConnectionErrorCodeType#UNKNOWN_TO_SDK_VERSION}. The raw value
     * returned by the service is available from {@link #connectionErrorCodeAsString}.
     * </p>
     * 
     * @return Describes the connection error. This field appears in the response only when the
     *         <code>ConnectionState</code> is <code>FAILED</code>.</p>
     *         <p>
     *         Many failures can be resolved by updating the properties of the custom key store. To update a custom key
     *         store, disconnect it (<a>DisconnectCustomKeyStore</a>), correct the errors (<a>UpdateCustomKeyStore</a>),
     *         and try to connect again (<a>ConnectCustomKeyStore</a>). For additional help resolving these errors, see
     *         <a href="https://docs.aws.amazon.com/kms/latest/developerguide/fix-keystore.html#fix-keystore-failed">How
     *         to Fix a Connection Failure</a> in <i>Key Management Service Developer Guide</i>.
     *         </p>
     *         <p>
     *         <b>All custom key stores:</b>
     *         </p>
     *         <ul>
     *         <li>
     *         <p>
     *         <code>INTERNAL_ERROR</code> — KMS could not complete the request due to an internal error. Retry the
     *         request. For <code>ConnectCustomKeyStore</code> requests, disconnect the custom key store before trying
     *         to connect again.
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         <code>NETWORK_ERRORS</code> — Network errors are preventing KMS from connecting the custom key store to
     *         its backing key store.
     *         </p>
     *         </li>
     *         </ul>
     *         <p>
     *         <b>CloudHSM key stores:</b>
     *         </p>
     *         <ul>
     *         <li>
     *         <p>
     *         <code>CLUSTER_NOT_FOUND</code> — KMS cannot find the CloudHSM cluster with the specified cluster ID.
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         <code>INSUFFICIENT_CLOUDHSM_HSMS</code> — The associated CloudHSM cluster does not contain any active
     *         HSMs. To connect a custom key store to its CloudHSM cluster, the cluster must contain at least one active
     *         HSM.
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         <code>INSUFFICIENT_FREE_ADDRESSES_IN_SUBNET</code> — At least one private subnet associated with the
     *         CloudHSM cluster doesn't have any available IP addresses. A CloudHSM key store connection requires one
     *         free IP address in each of the associated private subnets, although two are preferable. For details, see
     *         <a href="https://docs.aws.amazon.com/kms/latest/developerguide/fix-keystore.html#fix-keystore-failed">How
     *         to Fix a Connection Failure</a> in the <i>Key Management Service Developer Guide</i>.
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         <code>INVALID_CREDENTIALS</code> — The <code>KeyStorePassword</code> for the custom key store doesn't
     *         match the current password of the <code>kmsuser</code> crypto user in the CloudHSM cluster. Before you
     *         can connect your custom key store to its CloudHSM cluster, you must change the <code>kmsuser</code>
     *         account password and update the <code>KeyStorePassword</code> value for the custom key store.
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         <code>SUBNET_NOT_FOUND</code> — A subnet in the CloudHSM cluster configuration was deleted. If KMS cannot
     *         find all of the subnets in the cluster configuration, attempts to connect the custom key store to the
     *         CloudHSM cluster fail. To fix this error, create a cluster from a recent backup and associate it with
     *         your custom key store. (This process creates a new cluster configuration with a VPC and private subnets.)
     *         For details, see <a
     *         href="https://docs.aws.amazon.com/kms/latest/developerguide/fix-keystore.html#fix-keystore-failed">How to
     *         Fix a Connection Failure</a> in the <i>Key Management Service Developer Guide</i>.
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         <code>USER_LOCKED_OUT</code> — The <code>kmsuser</code> CU account is locked out of the associated
     *         CloudHSM cluster due to too many failed password attempts. Before you can connect your custom key store
     *         to its CloudHSM cluster, you must change the <code>kmsuser</code> account password and update the key
     *         store password value for the custom key store.
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         <code>USER_LOGGED_IN</code> — The <code>kmsuser</code> CU account is logged into the associated CloudHSM
     *         cluster. This prevents KMS from rotating the <code>kmsuser</code> account password and logging into the
     *         cluster. Before you can connect your custom key store to its CloudHSM cluster, you must log the
     *         <code>kmsuser</code> CU out of the cluster. If you changed the <code>kmsuser</code> password to log into
     *         the cluster, you must also and update the key store password value for the custom key store. For help,
     *         see <a href="https://docs.aws.amazon.com/kms/latest/developerguide/fix-keystore.html#login-kmsuser-2">How
     *         to Log Out and Reconnect</a> in the <i>Key Management Service Developer Guide</i>.
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         <code>USER_NOT_FOUND</code> — KMS cannot find a <code>kmsuser</code> CU account in the associated
     *         CloudHSM cluster. Before you can connect your custom key store to its CloudHSM cluster, you must create a
     *         <code>kmsuser</code> CU account in the cluster, and then update the key store password value for the
     *         custom key store.
     *         </p>
     *         </li>
     *         </ul>
     *         <p>
     *         <b>External key stores:</b>
     *         </p>
     *         <ul>
     *         <li>
     *         <p>
     *         <code>INVALID_CREDENTIALS</code> — One or both of the <code>XksProxyAuthenticationCredential</code>
     *         values is not valid on the specified external key store proxy.
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         <code>XKS_PROXY_ACCESS_DENIED</code> — KMS requests are denied access to the external key store proxy. If
     *         the external key store proxy has authorization rules, verify that they permit KMS to communicate with the
     *         proxy on your behalf.
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         <code>XKS_PROXY_INVALID_CONFIGURATION</code> — A configuration error is preventing the external key store
     *         from connecting to its proxy. Verify the value of the <code>XksProxyUriPath</code>.
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         <code>XKS_PROXY_INVALID_RESPONSE</code> — KMS cannot interpret the response from the external key store
     *         proxy. If you see this connection error code repeatedly, notify your external key store proxy vendor.
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         <code>XKS_PROXY_INVALID_TLS_CONFIGURATION</code> — KMS cannot connect to the external key store proxy
     *         because the TLS configuration is invalid. Verify that the XKS proxy supports TLS 1.2 or 1.3. Also, verify
     *         that the TLS certificate is not expired, and that it matches the hostname in the
     *         <code>XksProxyUriEndpoint</code> value, and that it is signed by a certificate authority included in the
     *         <a
     *         href="https://github.com/aws/aws-kms-xksproxy-api-spec/blob/main/TrustedCertificateAuthorities">Trusted
     *         Certificate Authorities</a> list.
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         <code>XKS_PROXY_NOT_REACHABLE</code> — KMS can't communicate with your external key store proxy. Verify
     *         that the <code>XksProxyUriEndpoint</code> and <code>XksProxyUriPath</code> are correct. Use the tools for
     *         your external key store proxy to verify that the proxy is active and available on its network. Also,
     *         verify that your external key manager instances are operating properly. Connection attempts fail with
     *         this connection error code if the proxy reports that all external key manager instances are unavailable.
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         <code>XKS_PROXY_TIMED_OUT</code> — KMS can connect to the external key store proxy, but the proxy does
     *         not respond to KMS in the time allotted. If you see this connection error code repeatedly, notify your
     *         external key store proxy vendor.
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         <code>XKS_VPC_ENDPOINT_SERVICE_INVALID_CONFIGURATION</code> — The Amazon VPC endpoint service
     *         configuration doesn't conform to the requirements for an KMS external key store.
     *         </p>
     *         <ul>
     *         <li>
     *         <p>
     *         The VPC endpoint service must be an endpoint service for interface endpoints in the caller's Amazon Web
     *         Services account.
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         It must have a network load balancer (NLB) connected to at least two subnets, each in a different
     *         Availability Zone.
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         The <code>Allow principals</code> list must include the KMS service principal for the Region,
     *         <code>cks.kms.&lt;region&gt;.amazonaws.com</code>, such as <code>cks.kms.us-east-1.amazonaws.com</code>.
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         It must <i>not</i> require <a
     *         href="https://docs.aws.amazon.com/vpc/latest/privatelink/create-endpoint-service.html">acceptance</a> of
     *         connection requests.
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         It must have a private DNS name. The private DNS name for an external key store with
     *         <code>VPC_ENDPOINT_SERVICE</code> connectivity must be unique in its Amazon Web Services Region.
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         The domain of the private DNS name must have a <a
     *         href="https://docs.aws.amazon.com/vpc/latest/privatelink/verify-domains.html">verification status</a> of
     *         <code>verified</code>.
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         The <a
     *         href="https://docs.aws.amazon.com/elasticloadbalancing/latest/network/create-tls-listener.html">TLS
     *         certificate</a> specifies the private DNS hostname at which the endpoint is reachable.
     *         </p>
     *         </li>
     *         </ul>
     *         </li>
     *         <li>
     *         <p>
     *         <code>XKS_VPC_ENDPOINT_SERVICE_NOT_FOUND</code> — KMS can't find the VPC endpoint service that it uses to
     *         communicate with the external key store proxy. Verify that the
     *         <code>XksProxyVpcEndpointServiceName</code> is correct and the KMS service principal has service consumer
     *         permissions on the Amazon VPC endpoint service.
     *         </p>
     *         </li>
     * @see ConnectionErrorCodeType
     */
    public final String connectionErrorCodeAsString() {
        return connectionErrorCode;
    }

    /**
     * <p>
     * The date and time when the custom key store was created.
     * </p>
     * 
     * @return The date and time when the custom key store was created.
     */
    public final Instant creationDate() {
        return creationDate;
    }

    /**
     * <p>
     * Indicates the type of the custom key store. <code>AWS_CLOUDHSM</code> indicates a custom key store backed by an
     * CloudHSM cluster. <code>EXTERNAL_KEY_STORE</code> indicates a custom key store backed by an external key store
     * proxy and external key manager outside of Amazon Web Services.
     * </p>
     * <p>
     * If the service returns an enum value that is not available in the current SDK version,
     * {@link #customKeyStoreType} will return {@link CustomKeyStoreType#UNKNOWN_TO_SDK_VERSION}. The raw value returned
     * by the service is available from {@link #customKeyStoreTypeAsString}.
     * </p>
     * 
     * @return Indicates the type of the custom key store. <code>AWS_CLOUDHSM</code> indicates a custom key store backed
     *         by an CloudHSM cluster. <code>EXTERNAL_KEY_STORE</code> indicates a custom key store backed by an
     *         external key store proxy and external key manager outside of Amazon Web Services.
     * @see CustomKeyStoreType
     */
    public final CustomKeyStoreType customKeyStoreType() {
        return CustomKeyStoreType.fromValue(customKeyStoreType);
    }

    /**
     * <p>
     * Indicates the type of the custom key store. <code>AWS_CLOUDHSM</code> indicates a custom key store backed by an
     * CloudHSM cluster. <code>EXTERNAL_KEY_STORE</code> indicates a custom key store backed by an external key store
     * proxy and external key manager outside of Amazon Web Services.
     * </p>
     * <p>
     * If the service returns an enum value that is not available in the current SDK version,
     * {@link #customKeyStoreType} will return {@link CustomKeyStoreType#UNKNOWN_TO_SDK_VERSION}. The raw value returned
     * by the service is available from {@link #customKeyStoreTypeAsString}.
     * </p>
     * 
     * @return Indicates the type of the custom key store. <code>AWS_CLOUDHSM</code> indicates a custom key store backed
     *         by an CloudHSM cluster. <code>EXTERNAL_KEY_STORE</code> indicates a custom key store backed by an
     *         external key store proxy and external key manager outside of Amazon Web Services.
     * @see CustomKeyStoreType
     */
    public final String customKeyStoreTypeAsString() {
        return customKeyStoreType;
    }

    /**
     * <p>
     * Configuration settings for the external key store proxy (XKS proxy). The external key store proxy translates KMS
     * requests into a format that your external key manager can understand. The proxy configuration includes connection
     * information that KMS requires.
     * </p>
     * <p>
     * This field appears only when the <code>CustomKeyStoreType</code> is <code>EXTERNAL_KEY_STORE</code>.
     * </p>
     * 
     * @return Configuration settings for the external key store proxy (XKS proxy). The external key store proxy
     *         translates KMS requests into a format that your external key manager can understand. The proxy
     *         configuration includes connection information that KMS requires.</p>
     *         <p>
     *         This field appears only when the <code>CustomKeyStoreType</code> is <code>EXTERNAL_KEY_STORE</code>.
     */
    public final XksProxyConfigurationType xksProxyConfiguration() {
        return xksProxyConfiguration;
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
        hashCode = 31 * hashCode + Objects.hashCode(customKeyStoreId());
        hashCode = 31 * hashCode + Objects.hashCode(customKeyStoreName());
        hashCode = 31 * hashCode + Objects.hashCode(cloudHsmClusterId());
        hashCode = 31 * hashCode + Objects.hashCode(trustAnchorCertificate());
        hashCode = 31 * hashCode + Objects.hashCode(connectionStateAsString());
        hashCode = 31 * hashCode + Objects.hashCode(connectionErrorCodeAsString());
        hashCode = 31 * hashCode + Objects.hashCode(creationDate());
        hashCode = 31 * hashCode + Objects.hashCode(customKeyStoreTypeAsString());
        hashCode = 31 * hashCode + Objects.hashCode(xksProxyConfiguration());
        return hashCode;
    }

    @Override
    public final boolean equals(Object obj) {
        return equalsBySdkFields(obj);
    }

    @Override
    public final boolean equalsBySdkFields(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof CustomKeyStoresListEntry)) {
            return false;
        }
        CustomKeyStoresListEntry other = (CustomKeyStoresListEntry) obj;
        return Objects.equals(customKeyStoreId(), other.customKeyStoreId())
                && Objects.equals(customKeyStoreName(), other.customKeyStoreName())
                && Objects.equals(cloudHsmClusterId(), other.cloudHsmClusterId())
                && Objects.equals(trustAnchorCertificate(), other.trustAnchorCertificate())
                && Objects.equals(connectionStateAsString(), other.connectionStateAsString())
                && Objects.equals(connectionErrorCodeAsString(), other.connectionErrorCodeAsString())
                && Objects.equals(creationDate(), other.creationDate())
                && Objects.equals(customKeyStoreTypeAsString(), other.customKeyStoreTypeAsString())
                && Objects.equals(xksProxyConfiguration(), other.xksProxyConfiguration());
    }

    /**
     * Returns a string representation of this object. This is useful for testing and debugging. Sensitive data will be
     * redacted from this string using a placeholder value.
     */
    @Override
    public final String toString() {
        return ToString.builder("CustomKeyStoresListEntry").add("CustomKeyStoreId", customKeyStoreId())
                .add("CustomKeyStoreName", customKeyStoreName()).add("CloudHsmClusterId", cloudHsmClusterId())
                .add("TrustAnchorCertificate", trustAnchorCertificate()).add("ConnectionState", connectionStateAsString())
                .add("ConnectionErrorCode", connectionErrorCodeAsString()).add("CreationDate", creationDate())
                .add("CustomKeyStoreType", customKeyStoreTypeAsString()).add("XksProxyConfiguration", xksProxyConfiguration())
                .build();
    }

    public final <T> Optional<T> getValueForField(String fieldName, Class<T> clazz) {
        switch (fieldName) {
        case "CustomKeyStoreId":
            return Optional.ofNullable(clazz.cast(customKeyStoreId()));
        case "CustomKeyStoreName":
            return Optional.ofNullable(clazz.cast(customKeyStoreName()));
        case "CloudHsmClusterId":
            return Optional.ofNullable(clazz.cast(cloudHsmClusterId()));
        case "TrustAnchorCertificate":
            return Optional.ofNullable(clazz.cast(trustAnchorCertificate()));
        case "ConnectionState":
            return Optional.ofNullable(clazz.cast(connectionStateAsString()));
        case "ConnectionErrorCode":
            return Optional.ofNullable(clazz.cast(connectionErrorCodeAsString()));
        case "CreationDate":
            return Optional.ofNullable(clazz.cast(creationDate()));
        case "CustomKeyStoreType":
            return Optional.ofNullable(clazz.cast(customKeyStoreTypeAsString()));
        case "XksProxyConfiguration":
            return Optional.ofNullable(clazz.cast(xksProxyConfiguration()));
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
        map.put("CustomKeyStoreName", CUSTOM_KEY_STORE_NAME_FIELD);
        map.put("CloudHsmClusterId", CLOUD_HSM_CLUSTER_ID_FIELD);
        map.put("TrustAnchorCertificate", TRUST_ANCHOR_CERTIFICATE_FIELD);
        map.put("ConnectionState", CONNECTION_STATE_FIELD);
        map.put("ConnectionErrorCode", CONNECTION_ERROR_CODE_FIELD);
        map.put("CreationDate", CREATION_DATE_FIELD);
        map.put("CustomKeyStoreType", CUSTOM_KEY_STORE_TYPE_FIELD);
        map.put("XksProxyConfiguration", XKS_PROXY_CONFIGURATION_FIELD);
        return Collections.unmodifiableMap(map);
    }

    private static <T> Function<Object, T> getter(Function<CustomKeyStoresListEntry, T> g) {
        return obj -> g.apply((CustomKeyStoresListEntry) obj);
    }

    private static <T> BiConsumer<Object, T> setter(BiConsumer<Builder, T> s) {
        return (obj, val) -> s.accept((Builder) obj, val);
    }

    @Mutable
    @NotThreadSafe
    public interface Builder extends SdkPojo, CopyableBuilder<Builder, CustomKeyStoresListEntry> {
        /**
         * <p>
         * A unique identifier for the custom key store.
         * </p>
         * 
         * @param customKeyStoreId
         *        A unique identifier for the custom key store.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder customKeyStoreId(String customKeyStoreId);

        /**
         * <p>
         * The user-specified friendly name for the custom key store.
         * </p>
         * 
         * @param customKeyStoreName
         *        The user-specified friendly name for the custom key store.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder customKeyStoreName(String customKeyStoreName);

        /**
         * <p>
         * A unique identifier for the CloudHSM cluster that is associated with an CloudHSM key store. This field
         * appears only when the <code>CustomKeyStoreType</code> is <code>AWS_CLOUDHSM</code>.
         * </p>
         * 
         * @param cloudHsmClusterId
         *        A unique identifier for the CloudHSM cluster that is associated with an CloudHSM key store. This field
         *        appears only when the <code>CustomKeyStoreType</code> is <code>AWS_CLOUDHSM</code>.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder cloudHsmClusterId(String cloudHsmClusterId);

        /**
         * <p>
         * The trust anchor certificate of the CloudHSM cluster associated with an CloudHSM key store. When you <a
         * href="https://docs.aws.amazon.com/cloudhsm/latest/userguide/initialize-cluster.html#sign-csr">initialize the
         * cluster</a>, you create this certificate and save it in the <code>customerCA.crt</code> file.
         * </p>
         * <p>
         * This field appears only when the <code>CustomKeyStoreType</code> is <code>AWS_CLOUDHSM</code>.
         * </p>
         * 
         * @param trustAnchorCertificate
         *        The trust anchor certificate of the CloudHSM cluster associated with an CloudHSM key store. When you
         *        <a href="https://docs.aws.amazon.com/cloudhsm/latest/userguide/initialize-cluster.html#sign-csr">
         *        initialize the cluster</a>, you create this certificate and save it in the <code>customerCA.crt</code>
         *        file.</p>
         *        <p>
         *        This field appears only when the <code>CustomKeyStoreType</code> is <code>AWS_CLOUDHSM</code>.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder trustAnchorCertificate(String trustAnchorCertificate);

        /**
         * <p>
         * Indicates whether the custom key store is connected to its backing key store. For an CloudHSM key store, the
         * <code>ConnectionState</code> indicates whether it is connected to its CloudHSM cluster. For an external key
         * store, the <code>ConnectionState</code> indicates whether it is connected to the external key store proxy
         * that communicates with your external key manager.
         * </p>
         * <p>
         * You can create and use KMS keys in your custom key stores only when its <code>ConnectionState</code> is
         * <code>CONNECTED</code>.
         * </p>
         * <p>
         * The <code>ConnectionState</code> value is <code>DISCONNECTED</code> only if the key store has never been
         * connected or you use the <a>DisconnectCustomKeyStore</a> operation to disconnect it. If the value is
         * <code>CONNECTED</code> but you are having trouble using the custom key store, make sure that the backing key
         * store is reachable and active. For an CloudHSM key store, verify that its associated CloudHSM cluster is
         * active and contains at least one active HSM. For an external key store, verify that the external key store
         * proxy and external key manager are connected and enabled.
         * </p>
         * <p>
         * A value of <code>FAILED</code> indicates that an attempt to connect was unsuccessful. The
         * <code>ConnectionErrorCode</code> field in the response indicates the cause of the failure. For help resolving
         * a connection failure, see <a
         * href="https://docs.aws.amazon.com/kms/latest/developerguide/fix-keystore.html">Troubleshooting a custom key
         * store</a> in the <i>Key Management Service Developer Guide</i>.
         * </p>
         * 
         * @param connectionState
         *        Indicates whether the custom key store is connected to its backing key store. For an CloudHSM key
         *        store, the <code>ConnectionState</code> indicates whether it is connected to its CloudHSM cluster. For
         *        an external key store, the <code>ConnectionState</code> indicates whether it is connected to the
         *        external key store proxy that communicates with your external key manager.</p>
         *        <p>
         *        You can create and use KMS keys in your custom key stores only when its <code>ConnectionState</code>
         *        is <code>CONNECTED</code>.
         *        </p>
         *        <p>
         *        The <code>ConnectionState</code> value is <code>DISCONNECTED</code> only if the key store has never
         *        been connected or you use the <a>DisconnectCustomKeyStore</a> operation to disconnect it. If the value
         *        is <code>CONNECTED</code> but you are having trouble using the custom key store, make sure that the
         *        backing key store is reachable and active. For an CloudHSM key store, verify that its associated
         *        CloudHSM cluster is active and contains at least one active HSM. For an external key store, verify
         *        that the external key store proxy and external key manager are connected and enabled.
         *        </p>
         *        <p>
         *        A value of <code>FAILED</code> indicates that an attempt to connect was unsuccessful. The
         *        <code>ConnectionErrorCode</code> field in the response indicates the cause of the failure. For help
         *        resolving a connection failure, see <a
         *        href="https://docs.aws.amazon.com/kms/latest/developerguide/fix-keystore.html">Troubleshooting a
         *        custom key store</a> in the <i>Key Management Service Developer Guide</i>.
         * @see ConnectionStateType
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see ConnectionStateType
         */
        Builder connectionState(String connectionState);

        /**
         * <p>
         * Indicates whether the custom key store is connected to its backing key store. For an CloudHSM key store, the
         * <code>ConnectionState</code> indicates whether it is connected to its CloudHSM cluster. For an external key
         * store, the <code>ConnectionState</code> indicates whether it is connected to the external key store proxy
         * that communicates with your external key manager.
         * </p>
         * <p>
         * You can create and use KMS keys in your custom key stores only when its <code>ConnectionState</code> is
         * <code>CONNECTED</code>.
         * </p>
         * <p>
         * The <code>ConnectionState</code> value is <code>DISCONNECTED</code> only if the key store has never been
         * connected or you use the <a>DisconnectCustomKeyStore</a> operation to disconnect it. If the value is
         * <code>CONNECTED</code> but you are having trouble using the custom key store, make sure that the backing key
         * store is reachable and active. For an CloudHSM key store, verify that its associated CloudHSM cluster is
         * active and contains at least one active HSM. For an external key store, verify that the external key store
         * proxy and external key manager are connected and enabled.
         * </p>
         * <p>
         * A value of <code>FAILED</code> indicates that an attempt to connect was unsuccessful. The
         * <code>ConnectionErrorCode</code> field in the response indicates the cause of the failure. For help resolving
         * a connection failure, see <a
         * href="https://docs.aws.amazon.com/kms/latest/developerguide/fix-keystore.html">Troubleshooting a custom key
         * store</a> in the <i>Key Management Service Developer Guide</i>.
         * </p>
         * 
         * @param connectionState
         *        Indicates whether the custom key store is connected to its backing key store. For an CloudHSM key
         *        store, the <code>ConnectionState</code> indicates whether it is connected to its CloudHSM cluster. For
         *        an external key store, the <code>ConnectionState</code> indicates whether it is connected to the
         *        external key store proxy that communicates with your external key manager.</p>
         *        <p>
         *        You can create and use KMS keys in your custom key stores only when its <code>ConnectionState</code>
         *        is <code>CONNECTED</code>.
         *        </p>
         *        <p>
         *        The <code>ConnectionState</code> value is <code>DISCONNECTED</code> only if the key store has never
         *        been connected or you use the <a>DisconnectCustomKeyStore</a> operation to disconnect it. If the value
         *        is <code>CONNECTED</code> but you are having trouble using the custom key store, make sure that the
         *        backing key store is reachable and active. For an CloudHSM key store, verify that its associated
         *        CloudHSM cluster is active and contains at least one active HSM. For an external key store, verify
         *        that the external key store proxy and external key manager are connected and enabled.
         *        </p>
         *        <p>
         *        A value of <code>FAILED</code> indicates that an attempt to connect was unsuccessful. The
         *        <code>ConnectionErrorCode</code> field in the response indicates the cause of the failure. For help
         *        resolving a connection failure, see <a
         *        href="https://docs.aws.amazon.com/kms/latest/developerguide/fix-keystore.html">Troubleshooting a
         *        custom key store</a> in the <i>Key Management Service Developer Guide</i>.
         * @see ConnectionStateType
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see ConnectionStateType
         */
        Builder connectionState(ConnectionStateType connectionState);

        /**
         * <p>
         * Describes the connection error. This field appears in the response only when the <code>ConnectionState</code>
         * is <code>FAILED</code>.
         * </p>
         * <p>
         * Many failures can be resolved by updating the properties of the custom key store. To update a custom key
         * store, disconnect it (<a>DisconnectCustomKeyStore</a>), correct the errors (<a>UpdateCustomKeyStore</a>), and
         * try to connect again (<a>ConnectCustomKeyStore</a>). For additional help resolving these errors, see <a
         * href="https://docs.aws.amazon.com/kms/latest/developerguide/fix-keystore.html#fix-keystore-failed">How to Fix
         * a Connection Failure</a> in <i>Key Management Service Developer Guide</i>.
         * </p>
         * <p>
         * <b>All custom key stores:</b>
         * </p>
         * <ul>
         * <li>
         * <p>
         * <code>INTERNAL_ERROR</code> — KMS could not complete the request due to an internal error. Retry the request.
         * For <code>ConnectCustomKeyStore</code> requests, disconnect the custom key store before trying to connect
         * again.
         * </p>
         * </li>
         * <li>
         * <p>
         * <code>NETWORK_ERRORS</code> — Network errors are preventing KMS from connecting the custom key store to its
         * backing key store.
         * </p>
         * </li>
         * </ul>
         * <p>
         * <b>CloudHSM key stores:</b>
         * </p>
         * <ul>
         * <li>
         * <p>
         * <code>CLUSTER_NOT_FOUND</code> — KMS cannot find the CloudHSM cluster with the specified cluster ID.
         * </p>
         * </li>
         * <li>
         * <p>
         * <code>INSUFFICIENT_CLOUDHSM_HSMS</code> — The associated CloudHSM cluster does not contain any active HSMs.
         * To connect a custom key store to its CloudHSM cluster, the cluster must contain at least one active HSM.
         * </p>
         * </li>
         * <li>
         * <p>
         * <code>INSUFFICIENT_FREE_ADDRESSES_IN_SUBNET</code> — At least one private subnet associated with the CloudHSM
         * cluster doesn't have any available IP addresses. A CloudHSM key store connection requires one free IP address
         * in each of the associated private subnets, although two are preferable. For details, see <a
         * href="https://docs.aws.amazon.com/kms/latest/developerguide/fix-keystore.html#fix-keystore-failed">How to Fix
         * a Connection Failure</a> in the <i>Key Management Service Developer Guide</i>.
         * </p>
         * </li>
         * <li>
         * <p>
         * <code>INVALID_CREDENTIALS</code> — The <code>KeyStorePassword</code> for the custom key store doesn't match
         * the current password of the <code>kmsuser</code> crypto user in the CloudHSM cluster. Before you can connect
         * your custom key store to its CloudHSM cluster, you must change the <code>kmsuser</code> account password and
         * update the <code>KeyStorePassword</code> value for the custom key store.
         * </p>
         * </li>
         * <li>
         * <p>
         * <code>SUBNET_NOT_FOUND</code> — A subnet in the CloudHSM cluster configuration was deleted. If KMS cannot
         * find all of the subnets in the cluster configuration, attempts to connect the custom key store to the
         * CloudHSM cluster fail. To fix this error, create a cluster from a recent backup and associate it with your
         * custom key store. (This process creates a new cluster configuration with a VPC and private subnets.) For
         * details, see <a
         * href="https://docs.aws.amazon.com/kms/latest/developerguide/fix-keystore.html#fix-keystore-failed">How to Fix
         * a Connection Failure</a> in the <i>Key Management Service Developer Guide</i>.
         * </p>
         * </li>
         * <li>
         * <p>
         * <code>USER_LOCKED_OUT</code> — The <code>kmsuser</code> CU account is locked out of the associated CloudHSM
         * cluster due to too many failed password attempts. Before you can connect your custom key store to its
         * CloudHSM cluster, you must change the <code>kmsuser</code> account password and update the key store password
         * value for the custom key store.
         * </p>
         * </li>
         * <li>
         * <p>
         * <code>USER_LOGGED_IN</code> — The <code>kmsuser</code> CU account is logged into the associated CloudHSM
         * cluster. This prevents KMS from rotating the <code>kmsuser</code> account password and logging into the
         * cluster. Before you can connect your custom key store to its CloudHSM cluster, you must log the
         * <code>kmsuser</code> CU out of the cluster. If you changed the <code>kmsuser</code> password to log into the
         * cluster, you must also and update the key store password value for the custom key store. For help, see <a
         * href="https://docs.aws.amazon.com/kms/latest/developerguide/fix-keystore.html#login-kmsuser-2">How to Log Out
         * and Reconnect</a> in the <i>Key Management Service Developer Guide</i>.
         * </p>
         * </li>
         * <li>
         * <p>
         * <code>USER_NOT_FOUND</code> — KMS cannot find a <code>kmsuser</code> CU account in the associated CloudHSM
         * cluster. Before you can connect your custom key store to its CloudHSM cluster, you must create a
         * <code>kmsuser</code> CU account in the cluster, and then update the key store password value for the custom
         * key store.
         * </p>
         * </li>
         * </ul>
         * <p>
         * <b>External key stores:</b>
         * </p>
         * <ul>
         * <li>
         * <p>
         * <code>INVALID_CREDENTIALS</code> — One or both of the <code>XksProxyAuthenticationCredential</code> values is
         * not valid on the specified external key store proxy.
         * </p>
         * </li>
         * <li>
         * <p>
         * <code>XKS_PROXY_ACCESS_DENIED</code> — KMS requests are denied access to the external key store proxy. If the
         * external key store proxy has authorization rules, verify that they permit KMS to communicate with the proxy
         * on your behalf.
         * </p>
         * </li>
         * <li>
         * <p>
         * <code>XKS_PROXY_INVALID_CONFIGURATION</code> — A configuration error is preventing the external key store
         * from connecting to its proxy. Verify the value of the <code>XksProxyUriPath</code>.
         * </p>
         * </li>
         * <li>
         * <p>
         * <code>XKS_PROXY_INVALID_RESPONSE</code> — KMS cannot interpret the response from the external key store
         * proxy. If you see this connection error code repeatedly, notify your external key store proxy vendor.
         * </p>
         * </li>
         * <li>
         * <p>
         * <code>XKS_PROXY_INVALID_TLS_CONFIGURATION</code> — KMS cannot connect to the external key store proxy because
         * the TLS configuration is invalid. Verify that the XKS proxy supports TLS 1.2 or 1.3. Also, verify that the
         * TLS certificate is not expired, and that it matches the hostname in the <code>XksProxyUriEndpoint</code>
         * value, and that it is signed by a certificate authority included in the <a
         * href="https://github.com/aws/aws-kms-xksproxy-api-spec/blob/main/TrustedCertificateAuthorities">Trusted
         * Certificate Authorities</a> list.
         * </p>
         * </li>
         * <li>
         * <p>
         * <code>XKS_PROXY_NOT_REACHABLE</code> — KMS can't communicate with your external key store proxy. Verify that
         * the <code>XksProxyUriEndpoint</code> and <code>XksProxyUriPath</code> are correct. Use the tools for your
         * external key store proxy to verify that the proxy is active and available on its network. Also, verify that
         * your external key manager instances are operating properly. Connection attempts fail with this connection
         * error code if the proxy reports that all external key manager instances are unavailable.
         * </p>
         * </li>
         * <li>
         * <p>
         * <code>XKS_PROXY_TIMED_OUT</code> — KMS can connect to the external key store proxy, but the proxy does not
         * respond to KMS in the time allotted. If you see this connection error code repeatedly, notify your external
         * key store proxy vendor.
         * </p>
         * </li>
         * <li>
         * <p>
         * <code>XKS_VPC_ENDPOINT_SERVICE_INVALID_CONFIGURATION</code> — The Amazon VPC endpoint service configuration
         * doesn't conform to the requirements for an KMS external key store.
         * </p>
         * <ul>
         * <li>
         * <p>
         * The VPC endpoint service must be an endpoint service for interface endpoints in the caller's Amazon Web
         * Services account.
         * </p>
         * </li>
         * <li>
         * <p>
         * It must have a network load balancer (NLB) connected to at least two subnets, each in a different
         * Availability Zone.
         * </p>
         * </li>
         * <li>
         * <p>
         * The <code>Allow principals</code> list must include the KMS service principal for the Region,
         * <code>cks.kms.&lt;region&gt;.amazonaws.com</code>, such as <code>cks.kms.us-east-1.amazonaws.com</code>.
         * </p>
         * </li>
         * <li>
         * <p>
         * It must <i>not</i> require <a
         * href="https://docs.aws.amazon.com/vpc/latest/privatelink/create-endpoint-service.html">acceptance</a> of
         * connection requests.
         * </p>
         * </li>
         * <li>
         * <p>
         * It must have a private DNS name. The private DNS name for an external key store with
         * <code>VPC_ENDPOINT_SERVICE</code> connectivity must be unique in its Amazon Web Services Region.
         * </p>
         * </li>
         * <li>
         * <p>
         * The domain of the private DNS name must have a <a
         * href="https://docs.aws.amazon.com/vpc/latest/privatelink/verify-domains.html">verification status</a> of
         * <code>verified</code>.
         * </p>
         * </li>
         * <li>
         * <p>
         * The <a href="https://docs.aws.amazon.com/elasticloadbalancing/latest/network/create-tls-listener.html">TLS
         * certificate</a> specifies the private DNS hostname at which the endpoint is reachable.
         * </p>
         * </li>
         * </ul>
         * </li>
         * <li>
         * <p>
         * <code>XKS_VPC_ENDPOINT_SERVICE_NOT_FOUND</code> — KMS can't find the VPC endpoint service that it uses to
         * communicate with the external key store proxy. Verify that the <code>XksProxyVpcEndpointServiceName</code> is
         * correct and the KMS service principal has service consumer permissions on the Amazon VPC endpoint service.
         * </p>
         * </li>
         * </ul>
         * 
         * @param connectionErrorCode
         *        Describes the connection error. This field appears in the response only when the
         *        <code>ConnectionState</code> is <code>FAILED</code>.</p>
         *        <p>
         *        Many failures can be resolved by updating the properties of the custom key store. To update a custom
         *        key store, disconnect it (<a>DisconnectCustomKeyStore</a>), correct the errors
         *        (<a>UpdateCustomKeyStore</a>), and try to connect again (<a>ConnectCustomKeyStore</a>). For additional
         *        help resolving these errors, see <a
         *        href="https://docs.aws.amazon.com/kms/latest/developerguide/fix-keystore.html#fix-keystore-failed">How
         *        to Fix a Connection Failure</a> in <i>Key Management Service Developer Guide</i>.
         *        </p>
         *        <p>
         *        <b>All custom key stores:</b>
         *        </p>
         *        <ul>
         *        <li>
         *        <p>
         *        <code>INTERNAL_ERROR</code> — KMS could not complete the request due to an internal error. Retry the
         *        request. For <code>ConnectCustomKeyStore</code> requests, disconnect the custom key store before
         *        trying to connect again.
         *        </p>
         *        </li>
         *        <li>
         *        <p>
         *        <code>NETWORK_ERRORS</code> — Network errors are preventing KMS from connecting the custom key store
         *        to its backing key store.
         *        </p>
         *        </li>
         *        </ul>
         *        <p>
         *        <b>CloudHSM key stores:</b>
         *        </p>
         *        <ul>
         *        <li>
         *        <p>
         *        <code>CLUSTER_NOT_FOUND</code> — KMS cannot find the CloudHSM cluster with the specified cluster ID.
         *        </p>
         *        </li>
         *        <li>
         *        <p>
         *        <code>INSUFFICIENT_CLOUDHSM_HSMS</code> — The associated CloudHSM cluster does not contain any active
         *        HSMs. To connect a custom key store to its CloudHSM cluster, the cluster must contain at least one
         *        active HSM.
         *        </p>
         *        </li>
         *        <li>
         *        <p>
         *        <code>INSUFFICIENT_FREE_ADDRESSES_IN_SUBNET</code> — At least one private subnet associated with the
         *        CloudHSM cluster doesn't have any available IP addresses. A CloudHSM key store connection requires one
         *        free IP address in each of the associated private subnets, although two are preferable. For details,
         *        see <a
         *        href="https://docs.aws.amazon.com/kms/latest/developerguide/fix-keystore.html#fix-keystore-failed">How
         *        to Fix a Connection Failure</a> in the <i>Key Management Service Developer Guide</i>.
         *        </p>
         *        </li>
         *        <li>
         *        <p>
         *        <code>INVALID_CREDENTIALS</code> — The <code>KeyStorePassword</code> for the custom key store doesn't
         *        match the current password of the <code>kmsuser</code> crypto user in the CloudHSM cluster. Before you
         *        can connect your custom key store to its CloudHSM cluster, you must change the <code>kmsuser</code>
         *        account password and update the <code>KeyStorePassword</code> value for the custom key store.
         *        </p>
         *        </li>
         *        <li>
         *        <p>
         *        <code>SUBNET_NOT_FOUND</code> — A subnet in the CloudHSM cluster configuration was deleted. If KMS
         *        cannot find all of the subnets in the cluster configuration, attempts to connect the custom key store
         *        to the CloudHSM cluster fail. To fix this error, create a cluster from a recent backup and associate
         *        it with your custom key store. (This process creates a new cluster configuration with a VPC and
         *        private subnets.) For details, see <a
         *        href="https://docs.aws.amazon.com/kms/latest/developerguide/fix-keystore.html#fix-keystore-failed">How
         *        to Fix a Connection Failure</a> in the <i>Key Management Service Developer Guide</i>.
         *        </p>
         *        </li>
         *        <li>
         *        <p>
         *        <code>USER_LOCKED_OUT</code> — The <code>kmsuser</code> CU account is locked out of the associated
         *        CloudHSM cluster due to too many failed password attempts. Before you can connect your custom key
         *        store to its CloudHSM cluster, you must change the <code>kmsuser</code> account password and update
         *        the key store password value for the custom key store.
         *        </p>
         *        </li>
         *        <li>
         *        <p>
         *        <code>USER_LOGGED_IN</code> — The <code>kmsuser</code> CU account is logged into the associated
         *        CloudHSM cluster. This prevents KMS from rotating the <code>kmsuser</code> account password and
         *        logging into the cluster. Before you can connect your custom key store to its CloudHSM cluster, you
         *        must log the <code>kmsuser</code> CU out of the cluster. If you changed the <code>kmsuser</code>
         *        password to log into the cluster, you must also and update the key store password value for the custom
         *        key store. For help, see <a
         *        href="https://docs.aws.amazon.com/kms/latest/developerguide/fix-keystore.html#login-kmsuser-2">How to
         *        Log Out and Reconnect</a> in the <i>Key Management Service Developer Guide</i>.
         *        </p>
         *        </li>
         *        <li>
         *        <p>
         *        <code>USER_NOT_FOUND</code> — KMS cannot find a <code>kmsuser</code> CU account in the associated
         *        CloudHSM cluster. Before you can connect your custom key store to its CloudHSM cluster, you must
         *        create a <code>kmsuser</code> CU account in the cluster, and then update the key store password value
         *        for the custom key store.
         *        </p>
         *        </li>
         *        </ul>
         *        <p>
         *        <b>External key stores:</b>
         *        </p>
         *        <ul>
         *        <li>
         *        <p>
         *        <code>INVALID_CREDENTIALS</code> — One or both of the <code>XksProxyAuthenticationCredential</code>
         *        values is not valid on the specified external key store proxy.
         *        </p>
         *        </li>
         *        <li>
         *        <p>
         *        <code>XKS_PROXY_ACCESS_DENIED</code> — KMS requests are denied access to the external key store proxy.
         *        If the external key store proxy has authorization rules, verify that they permit KMS to communicate
         *        with the proxy on your behalf.
         *        </p>
         *        </li>
         *        <li>
         *        <p>
         *        <code>XKS_PROXY_INVALID_CONFIGURATION</code> — A configuration error is preventing the external key
         *        store from connecting to its proxy. Verify the value of the <code>XksProxyUriPath</code>.
         *        </p>
         *        </li>
         *        <li>
         *        <p>
         *        <code>XKS_PROXY_INVALID_RESPONSE</code> — KMS cannot interpret the response from the external key
         *        store proxy. If you see this connection error code repeatedly, notify your external key store proxy
         *        vendor.
         *        </p>
         *        </li>
         *        <li>
         *        <p>
         *        <code>XKS_PROXY_INVALID_TLS_CONFIGURATION</code> — KMS cannot connect to the external key store proxy
         *        because the TLS configuration is invalid. Verify that the XKS proxy supports TLS 1.2 or 1.3. Also,
         *        verify that the TLS certificate is not expired, and that it matches the hostname in the
         *        <code>XksProxyUriEndpoint</code> value, and that it is signed by a certificate authority included in
         *        the <a
         *        href="https://github.com/aws/aws-kms-xksproxy-api-spec/blob/main/TrustedCertificateAuthorities">
         *        Trusted Certificate Authorities</a> list.
         *        </p>
         *        </li>
         *        <li>
         *        <p>
         *        <code>XKS_PROXY_NOT_REACHABLE</code> — KMS can't communicate with your external key store proxy.
         *        Verify that the <code>XksProxyUriEndpoint</code> and <code>XksProxyUriPath</code> are correct. Use the
         *        tools for your external key store proxy to verify that the proxy is active and available on its
         *        network. Also, verify that your external key manager instances are operating properly. Connection
         *        attempts fail with this connection error code if the proxy reports that all external key manager
         *        instances are unavailable.
         *        </p>
         *        </li>
         *        <li>
         *        <p>
         *        <code>XKS_PROXY_TIMED_OUT</code> — KMS can connect to the external key store proxy, but the proxy does
         *        not respond to KMS in the time allotted. If you see this connection error code repeatedly, notify your
         *        external key store proxy vendor.
         *        </p>
         *        </li>
         *        <li>
         *        <p>
         *        <code>XKS_VPC_ENDPOINT_SERVICE_INVALID_CONFIGURATION</code> — The Amazon VPC endpoint service
         *        configuration doesn't conform to the requirements for an KMS external key store.
         *        </p>
         *        <ul>
         *        <li>
         *        <p>
         *        The VPC endpoint service must be an endpoint service for interface endpoints in the caller's Amazon
         *        Web Services account.
         *        </p>
         *        </li>
         *        <li>
         *        <p>
         *        It must have a network load balancer (NLB) connected to at least two subnets, each in a different
         *        Availability Zone.
         *        </p>
         *        </li>
         *        <li>
         *        <p>
         *        The <code>Allow principals</code> list must include the KMS service principal for the Region,
         *        <code>cks.kms.&lt;region&gt;.amazonaws.com</code>, such as
         *        <code>cks.kms.us-east-1.amazonaws.com</code>.
         *        </p>
         *        </li>
         *        <li>
         *        <p>
         *        It must <i>not</i> require <a
         *        href="https://docs.aws.amazon.com/vpc/latest/privatelink/create-endpoint-service.html">acceptance</a>
         *        of connection requests.
         *        </p>
         *        </li>
         *        <li>
         *        <p>
         *        It must have a private DNS name. The private DNS name for an external key store with
         *        <code>VPC_ENDPOINT_SERVICE</code> connectivity must be unique in its Amazon Web Services Region.
         *        </p>
         *        </li>
         *        <li>
         *        <p>
         *        The domain of the private DNS name must have a <a
         *        href="https://docs.aws.amazon.com/vpc/latest/privatelink/verify-domains.html">verification status</a>
         *        of <code>verified</code>.
         *        </p>
         *        </li>
         *        <li>
         *        <p>
         *        The <a
         *        href="https://docs.aws.amazon.com/elasticloadbalancing/latest/network/create-tls-listener.html">TLS
         *        certificate</a> specifies the private DNS hostname at which the endpoint is reachable.
         *        </p>
         *        </li>
         *        </ul>
         *        </li>
         *        <li>
         *        <p>
         *        <code>XKS_VPC_ENDPOINT_SERVICE_NOT_FOUND</code> — KMS can't find the VPC endpoint service that it uses
         *        to communicate with the external key store proxy. Verify that the
         *        <code>XksProxyVpcEndpointServiceName</code> is correct and the KMS service principal has service
         *        consumer permissions on the Amazon VPC endpoint service.
         *        </p>
         *        </li>
         * @see ConnectionErrorCodeType
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see ConnectionErrorCodeType
         */
        Builder connectionErrorCode(String connectionErrorCode);

        /**
         * <p>
         * Describes the connection error. This field appears in the response only when the <code>ConnectionState</code>
         * is <code>FAILED</code>.
         * </p>
         * <p>
         * Many failures can be resolved by updating the properties of the custom key store. To update a custom key
         * store, disconnect it (<a>DisconnectCustomKeyStore</a>), correct the errors (<a>UpdateCustomKeyStore</a>), and
         * try to connect again (<a>ConnectCustomKeyStore</a>). For additional help resolving these errors, see <a
         * href="https://docs.aws.amazon.com/kms/latest/developerguide/fix-keystore.html#fix-keystore-failed">How to Fix
         * a Connection Failure</a> in <i>Key Management Service Developer Guide</i>.
         * </p>
         * <p>
         * <b>All custom key stores:</b>
         * </p>
         * <ul>
         * <li>
         * <p>
         * <code>INTERNAL_ERROR</code> — KMS could not complete the request due to an internal error. Retry the request.
         * For <code>ConnectCustomKeyStore</code> requests, disconnect the custom key store before trying to connect
         * again.
         * </p>
         * </li>
         * <li>
         * <p>
         * <code>NETWORK_ERRORS</code> — Network errors are preventing KMS from connecting the custom key store to its
         * backing key store.
         * </p>
         * </li>
         * </ul>
         * <p>
         * <b>CloudHSM key stores:</b>
         * </p>
         * <ul>
         * <li>
         * <p>
         * <code>CLUSTER_NOT_FOUND</code> — KMS cannot find the CloudHSM cluster with the specified cluster ID.
         * </p>
         * </li>
         * <li>
         * <p>
         * <code>INSUFFICIENT_CLOUDHSM_HSMS</code> — The associated CloudHSM cluster does not contain any active HSMs.
         * To connect a custom key store to its CloudHSM cluster, the cluster must contain at least one active HSM.
         * </p>
         * </li>
         * <li>
         * <p>
         * <code>INSUFFICIENT_FREE_ADDRESSES_IN_SUBNET</code> — At least one private subnet associated with the CloudHSM
         * cluster doesn't have any available IP addresses. A CloudHSM key store connection requires one free IP address
         * in each of the associated private subnets, although two are preferable. For details, see <a
         * href="https://docs.aws.amazon.com/kms/latest/developerguide/fix-keystore.html#fix-keystore-failed">How to Fix
         * a Connection Failure</a> in the <i>Key Management Service Developer Guide</i>.
         * </p>
         * </li>
         * <li>
         * <p>
         * <code>INVALID_CREDENTIALS</code> — The <code>KeyStorePassword</code> for the custom key store doesn't match
         * the current password of the <code>kmsuser</code> crypto user in the CloudHSM cluster. Before you can connect
         * your custom key store to its CloudHSM cluster, you must change the <code>kmsuser</code> account password and
         * update the <code>KeyStorePassword</code> value for the custom key store.
         * </p>
         * </li>
         * <li>
         * <p>
         * <code>SUBNET_NOT_FOUND</code> — A subnet in the CloudHSM cluster configuration was deleted. If KMS cannot
         * find all of the subnets in the cluster configuration, attempts to connect the custom key store to the
         * CloudHSM cluster fail. To fix this error, create a cluster from a recent backup and associate it with your
         * custom key store. (This process creates a new cluster configuration with a VPC and private subnets.) For
         * details, see <a
         * href="https://docs.aws.amazon.com/kms/latest/developerguide/fix-keystore.html#fix-keystore-failed">How to Fix
         * a Connection Failure</a> in the <i>Key Management Service Developer Guide</i>.
         * </p>
         * </li>
         * <li>
         * <p>
         * <code>USER_LOCKED_OUT</code> — The <code>kmsuser</code> CU account is locked out of the associated CloudHSM
         * cluster due to too many failed password attempts. Before you can connect your custom key store to its
         * CloudHSM cluster, you must change the <code>kmsuser</code> account password and update the key store password
         * value for the custom key store.
         * </p>
         * </li>
         * <li>
         * <p>
         * <code>USER_LOGGED_IN</code> — The <code>kmsuser</code> CU account is logged into the associated CloudHSM
         * cluster. This prevents KMS from rotating the <code>kmsuser</code> account password and logging into the
         * cluster. Before you can connect your custom key store to its CloudHSM cluster, you must log the
         * <code>kmsuser</code> CU out of the cluster. If you changed the <code>kmsuser</code> password to log into the
         * cluster, you must also and update the key store password value for the custom key store. For help, see <a
         * href="https://docs.aws.amazon.com/kms/latest/developerguide/fix-keystore.html#login-kmsuser-2">How to Log Out
         * and Reconnect</a> in the <i>Key Management Service Developer Guide</i>.
         * </p>
         * </li>
         * <li>
         * <p>
         * <code>USER_NOT_FOUND</code> — KMS cannot find a <code>kmsuser</code> CU account in the associated CloudHSM
         * cluster. Before you can connect your custom key store to its CloudHSM cluster, you must create a
         * <code>kmsuser</code> CU account in the cluster, and then update the key store password value for the custom
         * key store.
         * </p>
         * </li>
         * </ul>
         * <p>
         * <b>External key stores:</b>
         * </p>
         * <ul>
         * <li>
         * <p>
         * <code>INVALID_CREDENTIALS</code> — One or both of the <code>XksProxyAuthenticationCredential</code> values is
         * not valid on the specified external key store proxy.
         * </p>
         * </li>
         * <li>
         * <p>
         * <code>XKS_PROXY_ACCESS_DENIED</code> — KMS requests are denied access to the external key store proxy. If the
         * external key store proxy has authorization rules, verify that they permit KMS to communicate with the proxy
         * on your behalf.
         * </p>
         * </li>
         * <li>
         * <p>
         * <code>XKS_PROXY_INVALID_CONFIGURATION</code> — A configuration error is preventing the external key store
         * from connecting to its proxy. Verify the value of the <code>XksProxyUriPath</code>.
         * </p>
         * </li>
         * <li>
         * <p>
         * <code>XKS_PROXY_INVALID_RESPONSE</code> — KMS cannot interpret the response from the external key store
         * proxy. If you see this connection error code repeatedly, notify your external key store proxy vendor.
         * </p>
         * </li>
         * <li>
         * <p>
         * <code>XKS_PROXY_INVALID_TLS_CONFIGURATION</code> — KMS cannot connect to the external key store proxy because
         * the TLS configuration is invalid. Verify that the XKS proxy supports TLS 1.2 or 1.3. Also, verify that the
         * TLS certificate is not expired, and that it matches the hostname in the <code>XksProxyUriEndpoint</code>
         * value, and that it is signed by a certificate authority included in the <a
         * href="https://github.com/aws/aws-kms-xksproxy-api-spec/blob/main/TrustedCertificateAuthorities">Trusted
         * Certificate Authorities</a> list.
         * </p>
         * </li>
         * <li>
         * <p>
         * <code>XKS_PROXY_NOT_REACHABLE</code> — KMS can't communicate with your external key store proxy. Verify that
         * the <code>XksProxyUriEndpoint</code> and <code>XksProxyUriPath</code> are correct. Use the tools for your
         * external key store proxy to verify that the proxy is active and available on its network. Also, verify that
         * your external key manager instances are operating properly. Connection attempts fail with this connection
         * error code if the proxy reports that all external key manager instances are unavailable.
         * </p>
         * </li>
         * <li>
         * <p>
         * <code>XKS_PROXY_TIMED_OUT</code> — KMS can connect to the external key store proxy, but the proxy does not
         * respond to KMS in the time allotted. If you see this connection error code repeatedly, notify your external
         * key store proxy vendor.
         * </p>
         * </li>
         * <li>
         * <p>
         * <code>XKS_VPC_ENDPOINT_SERVICE_INVALID_CONFIGURATION</code> — The Amazon VPC endpoint service configuration
         * doesn't conform to the requirements for an KMS external key store.
         * </p>
         * <ul>
         * <li>
         * <p>
         * The VPC endpoint service must be an endpoint service for interface endpoints in the caller's Amazon Web
         * Services account.
         * </p>
         * </li>
         * <li>
         * <p>
         * It must have a network load balancer (NLB) connected to at least two subnets, each in a different
         * Availability Zone.
         * </p>
         * </li>
         * <li>
         * <p>
         * The <code>Allow principals</code> list must include the KMS service principal for the Region,
         * <code>cks.kms.&lt;region&gt;.amazonaws.com</code>, such as <code>cks.kms.us-east-1.amazonaws.com</code>.
         * </p>
         * </li>
         * <li>
         * <p>
         * It must <i>not</i> require <a
         * href="https://docs.aws.amazon.com/vpc/latest/privatelink/create-endpoint-service.html">acceptance</a> of
         * connection requests.
         * </p>
         * </li>
         * <li>
         * <p>
         * It must have a private DNS name. The private DNS name for an external key store with
         * <code>VPC_ENDPOINT_SERVICE</code> connectivity must be unique in its Amazon Web Services Region.
         * </p>
         * </li>
         * <li>
         * <p>
         * The domain of the private DNS name must have a <a
         * href="https://docs.aws.amazon.com/vpc/latest/privatelink/verify-domains.html">verification status</a> of
         * <code>verified</code>.
         * </p>
         * </li>
         * <li>
         * <p>
         * The <a href="https://docs.aws.amazon.com/elasticloadbalancing/latest/network/create-tls-listener.html">TLS
         * certificate</a> specifies the private DNS hostname at which the endpoint is reachable.
         * </p>
         * </li>
         * </ul>
         * </li>
         * <li>
         * <p>
         * <code>XKS_VPC_ENDPOINT_SERVICE_NOT_FOUND</code> — KMS can't find the VPC endpoint service that it uses to
         * communicate with the external key store proxy. Verify that the <code>XksProxyVpcEndpointServiceName</code> is
         * correct and the KMS service principal has service consumer permissions on the Amazon VPC endpoint service.
         * </p>
         * </li>
         * </ul>
         * 
         * @param connectionErrorCode
         *        Describes the connection error. This field appears in the response only when the
         *        <code>ConnectionState</code> is <code>FAILED</code>.</p>
         *        <p>
         *        Many failures can be resolved by updating the properties of the custom key store. To update a custom
         *        key store, disconnect it (<a>DisconnectCustomKeyStore</a>), correct the errors
         *        (<a>UpdateCustomKeyStore</a>), and try to connect again (<a>ConnectCustomKeyStore</a>). For additional
         *        help resolving these errors, see <a
         *        href="https://docs.aws.amazon.com/kms/latest/developerguide/fix-keystore.html#fix-keystore-failed">How
         *        to Fix a Connection Failure</a> in <i>Key Management Service Developer Guide</i>.
         *        </p>
         *        <p>
         *        <b>All custom key stores:</b>
         *        </p>
         *        <ul>
         *        <li>
         *        <p>
         *        <code>INTERNAL_ERROR</code> — KMS could not complete the request due to an internal error. Retry the
         *        request. For <code>ConnectCustomKeyStore</code> requests, disconnect the custom key store before
         *        trying to connect again.
         *        </p>
         *        </li>
         *        <li>
         *        <p>
         *        <code>NETWORK_ERRORS</code> — Network errors are preventing KMS from connecting the custom key store
         *        to its backing key store.
         *        </p>
         *        </li>
         *        </ul>
         *        <p>
         *        <b>CloudHSM key stores:</b>
         *        </p>
         *        <ul>
         *        <li>
         *        <p>
         *        <code>CLUSTER_NOT_FOUND</code> — KMS cannot find the CloudHSM cluster with the specified cluster ID.
         *        </p>
         *        </li>
         *        <li>
         *        <p>
         *        <code>INSUFFICIENT_CLOUDHSM_HSMS</code> — The associated CloudHSM cluster does not contain any active
         *        HSMs. To connect a custom key store to its CloudHSM cluster, the cluster must contain at least one
         *        active HSM.
         *        </p>
         *        </li>
         *        <li>
         *        <p>
         *        <code>INSUFFICIENT_FREE_ADDRESSES_IN_SUBNET</code> — At least one private subnet associated with the
         *        CloudHSM cluster doesn't have any available IP addresses. A CloudHSM key store connection requires one
         *        free IP address in each of the associated private subnets, although two are preferable. For details,
         *        see <a
         *        href="https://docs.aws.amazon.com/kms/latest/developerguide/fix-keystore.html#fix-keystore-failed">How
         *        to Fix a Connection Failure</a> in the <i>Key Management Service Developer Guide</i>.
         *        </p>
         *        </li>
         *        <li>
         *        <p>
         *        <code>INVALID_CREDENTIALS</code> — The <code>KeyStorePassword</code> for the custom key store doesn't
         *        match the current password of the <code>kmsuser</code> crypto user in the CloudHSM cluster. Before you
         *        can connect your custom key store to its CloudHSM cluster, you must change the <code>kmsuser</code>
         *        account password and update the <code>KeyStorePassword</code> value for the custom key store.
         *        </p>
         *        </li>
         *        <li>
         *        <p>
         *        <code>SUBNET_NOT_FOUND</code> — A subnet in the CloudHSM cluster configuration was deleted. If KMS
         *        cannot find all of the subnets in the cluster configuration, attempts to connect the custom key store
         *        to the CloudHSM cluster fail. To fix this error, create a cluster from a recent backup and associate
         *        it with your custom key store. (This process creates a new cluster configuration with a VPC and
         *        private subnets.) For details, see <a
         *        href="https://docs.aws.amazon.com/kms/latest/developerguide/fix-keystore.html#fix-keystore-failed">How
         *        to Fix a Connection Failure</a> in the <i>Key Management Service Developer Guide</i>.
         *        </p>
         *        </li>
         *        <li>
         *        <p>
         *        <code>USER_LOCKED_OUT</code> — The <code>kmsuser</code> CU account is locked out of the associated
         *        CloudHSM cluster due to too many failed password attempts. Before you can connect your custom key
         *        store to its CloudHSM cluster, you must change the <code>kmsuser</code> account password and update
         *        the key store password value for the custom key store.
         *        </p>
         *        </li>
         *        <li>
         *        <p>
         *        <code>USER_LOGGED_IN</code> — The <code>kmsuser</code> CU account is logged into the associated
         *        CloudHSM cluster. This prevents KMS from rotating the <code>kmsuser</code> account password and
         *        logging into the cluster. Before you can connect your custom key store to its CloudHSM cluster, you
         *        must log the <code>kmsuser</code> CU out of the cluster. If you changed the <code>kmsuser</code>
         *        password to log into the cluster, you must also and update the key store password value for the custom
         *        key store. For help, see <a
         *        href="https://docs.aws.amazon.com/kms/latest/developerguide/fix-keystore.html#login-kmsuser-2">How to
         *        Log Out and Reconnect</a> in the <i>Key Management Service Developer Guide</i>.
         *        </p>
         *        </li>
         *        <li>
         *        <p>
         *        <code>USER_NOT_FOUND</code> — KMS cannot find a <code>kmsuser</code> CU account in the associated
         *        CloudHSM cluster. Before you can connect your custom key store to its CloudHSM cluster, you must
         *        create a <code>kmsuser</code> CU account in the cluster, and then update the key store password value
         *        for the custom key store.
         *        </p>
         *        </li>
         *        </ul>
         *        <p>
         *        <b>External key stores:</b>
         *        </p>
         *        <ul>
         *        <li>
         *        <p>
         *        <code>INVALID_CREDENTIALS</code> — One or both of the <code>XksProxyAuthenticationCredential</code>
         *        values is not valid on the specified external key store proxy.
         *        </p>
         *        </li>
         *        <li>
         *        <p>
         *        <code>XKS_PROXY_ACCESS_DENIED</code> — KMS requests are denied access to the external key store proxy.
         *        If the external key store proxy has authorization rules, verify that they permit KMS to communicate
         *        with the proxy on your behalf.
         *        </p>
         *        </li>
         *        <li>
         *        <p>
         *        <code>XKS_PROXY_INVALID_CONFIGURATION</code> — A configuration error is preventing the external key
         *        store from connecting to its proxy. Verify the value of the <code>XksProxyUriPath</code>.
         *        </p>
         *        </li>
         *        <li>
         *        <p>
         *        <code>XKS_PROXY_INVALID_RESPONSE</code> — KMS cannot interpret the response from the external key
         *        store proxy. If you see this connection error code repeatedly, notify your external key store proxy
         *        vendor.
         *        </p>
         *        </li>
         *        <li>
         *        <p>
         *        <code>XKS_PROXY_INVALID_TLS_CONFIGURATION</code> — KMS cannot connect to the external key store proxy
         *        because the TLS configuration is invalid. Verify that the XKS proxy supports TLS 1.2 or 1.3. Also,
         *        verify that the TLS certificate is not expired, and that it matches the hostname in the
         *        <code>XksProxyUriEndpoint</code> value, and that it is signed by a certificate authority included in
         *        the <a
         *        href="https://github.com/aws/aws-kms-xksproxy-api-spec/blob/main/TrustedCertificateAuthorities">
         *        Trusted Certificate Authorities</a> list.
         *        </p>
         *        </li>
         *        <li>
         *        <p>
         *        <code>XKS_PROXY_NOT_REACHABLE</code> — KMS can't communicate with your external key store proxy.
         *        Verify that the <code>XksProxyUriEndpoint</code> and <code>XksProxyUriPath</code> are correct. Use the
         *        tools for your external key store proxy to verify that the proxy is active and available on its
         *        network. Also, verify that your external key manager instances are operating properly. Connection
         *        attempts fail with this connection error code if the proxy reports that all external key manager
         *        instances are unavailable.
         *        </p>
         *        </li>
         *        <li>
         *        <p>
         *        <code>XKS_PROXY_TIMED_OUT</code> — KMS can connect to the external key store proxy, but the proxy does
         *        not respond to KMS in the time allotted. If you see this connection error code repeatedly, notify your
         *        external key store proxy vendor.
         *        </p>
         *        </li>
         *        <li>
         *        <p>
         *        <code>XKS_VPC_ENDPOINT_SERVICE_INVALID_CONFIGURATION</code> — The Amazon VPC endpoint service
         *        configuration doesn't conform to the requirements for an KMS external key store.
         *        </p>
         *        <ul>
         *        <li>
         *        <p>
         *        The VPC endpoint service must be an endpoint service for interface endpoints in the caller's Amazon
         *        Web Services account.
         *        </p>
         *        </li>
         *        <li>
         *        <p>
         *        It must have a network load balancer (NLB) connected to at least two subnets, each in a different
         *        Availability Zone.
         *        </p>
         *        </li>
         *        <li>
         *        <p>
         *        The <code>Allow principals</code> list must include the KMS service principal for the Region,
         *        <code>cks.kms.&lt;region&gt;.amazonaws.com</code>, such as
         *        <code>cks.kms.us-east-1.amazonaws.com</code>.
         *        </p>
         *        </li>
         *        <li>
         *        <p>
         *        It must <i>not</i> require <a
         *        href="https://docs.aws.amazon.com/vpc/latest/privatelink/create-endpoint-service.html">acceptance</a>
         *        of connection requests.
         *        </p>
         *        </li>
         *        <li>
         *        <p>
         *        It must have a private DNS name. The private DNS name for an external key store with
         *        <code>VPC_ENDPOINT_SERVICE</code> connectivity must be unique in its Amazon Web Services Region.
         *        </p>
         *        </li>
         *        <li>
         *        <p>
         *        The domain of the private DNS name must have a <a
         *        href="https://docs.aws.amazon.com/vpc/latest/privatelink/verify-domains.html">verification status</a>
         *        of <code>verified</code>.
         *        </p>
         *        </li>
         *        <li>
         *        <p>
         *        The <a
         *        href="https://docs.aws.amazon.com/elasticloadbalancing/latest/network/create-tls-listener.html">TLS
         *        certificate</a> specifies the private DNS hostname at which the endpoint is reachable.
         *        </p>
         *        </li>
         *        </ul>
         *        </li>
         *        <li>
         *        <p>
         *        <code>XKS_VPC_ENDPOINT_SERVICE_NOT_FOUND</code> — KMS can't find the VPC endpoint service that it uses
         *        to communicate with the external key store proxy. Verify that the
         *        <code>XksProxyVpcEndpointServiceName</code> is correct and the KMS service principal has service
         *        consumer permissions on the Amazon VPC endpoint service.
         *        </p>
         *        </li>
         * @see ConnectionErrorCodeType
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see ConnectionErrorCodeType
         */
        Builder connectionErrorCode(ConnectionErrorCodeType connectionErrorCode);

        /**
         * <p>
         * The date and time when the custom key store was created.
         * </p>
         * 
         * @param creationDate
         *        The date and time when the custom key store was created.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder creationDate(Instant creationDate);

        /**
         * <p>
         * Indicates the type of the custom key store. <code>AWS_CLOUDHSM</code> indicates a custom key store backed by
         * an CloudHSM cluster. <code>EXTERNAL_KEY_STORE</code> indicates a custom key store backed by an external key
         * store proxy and external key manager outside of Amazon Web Services.
         * </p>
         * 
         * @param customKeyStoreType
         *        Indicates the type of the custom key store. <code>AWS_CLOUDHSM</code> indicates a custom key store
         *        backed by an CloudHSM cluster. <code>EXTERNAL_KEY_STORE</code> indicates a custom key store backed by
         *        an external key store proxy and external key manager outside of Amazon Web Services.
         * @see CustomKeyStoreType
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see CustomKeyStoreType
         */
        Builder customKeyStoreType(String customKeyStoreType);

        /**
         * <p>
         * Indicates the type of the custom key store. <code>AWS_CLOUDHSM</code> indicates a custom key store backed by
         * an CloudHSM cluster. <code>EXTERNAL_KEY_STORE</code> indicates a custom key store backed by an external key
         * store proxy and external key manager outside of Amazon Web Services.
         * </p>
         * 
         * @param customKeyStoreType
         *        Indicates the type of the custom key store. <code>AWS_CLOUDHSM</code> indicates a custom key store
         *        backed by an CloudHSM cluster. <code>EXTERNAL_KEY_STORE</code> indicates a custom key store backed by
         *        an external key store proxy and external key manager outside of Amazon Web Services.
         * @see CustomKeyStoreType
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see CustomKeyStoreType
         */
        Builder customKeyStoreType(CustomKeyStoreType customKeyStoreType);

        /**
         * <p>
         * Configuration settings for the external key store proxy (XKS proxy). The external key store proxy translates
         * KMS requests into a format that your external key manager can understand. The proxy configuration includes
         * connection information that KMS requires.
         * </p>
         * <p>
         * This field appears only when the <code>CustomKeyStoreType</code> is <code>EXTERNAL_KEY_STORE</code>.
         * </p>
         * 
         * @param xksProxyConfiguration
         *        Configuration settings for the external key store proxy (XKS proxy). The external key store proxy
         *        translates KMS requests into a format that your external key manager can understand. The proxy
         *        configuration includes connection information that KMS requires.</p>
         *        <p>
         *        This field appears only when the <code>CustomKeyStoreType</code> is <code>EXTERNAL_KEY_STORE</code>.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder xksProxyConfiguration(XksProxyConfigurationType xksProxyConfiguration);

        /**
         * <p>
         * Configuration settings for the external key store proxy (XKS proxy). The external key store proxy translates
         * KMS requests into a format that your external key manager can understand. The proxy configuration includes
         * connection information that KMS requires.
         * </p>
         * <p>
         * This field appears only when the <code>CustomKeyStoreType</code> is <code>EXTERNAL_KEY_STORE</code>.
         * </p>
         * This is a convenience method that creates an instance of the {@link XksProxyConfigurationType.Builder}
         * avoiding the need to create one manually via {@link XksProxyConfigurationType#builder()}.
         *
         * <p>
         * When the {@link Consumer} completes, {@link XksProxyConfigurationType.Builder#build()} is called immediately
         * and its result is passed to {@link #xksProxyConfiguration(XksProxyConfigurationType)}.
         * 
         * @param xksProxyConfiguration
         *        a consumer that will call methods on {@link XksProxyConfigurationType.Builder}
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see #xksProxyConfiguration(XksProxyConfigurationType)
         */
        default Builder xksProxyConfiguration(Consumer<XksProxyConfigurationType.Builder> xksProxyConfiguration) {
            return xksProxyConfiguration(XksProxyConfigurationType.builder().applyMutation(xksProxyConfiguration).build());
        }
    }

    static final class BuilderImpl implements Builder {
        private String customKeyStoreId;

        private String customKeyStoreName;

        private String cloudHsmClusterId;

        private String trustAnchorCertificate;

        private String connectionState;

        private String connectionErrorCode;

        private Instant creationDate;

        private String customKeyStoreType;

        private XksProxyConfigurationType xksProxyConfiguration;

        private BuilderImpl() {
        }

        private BuilderImpl(CustomKeyStoresListEntry model) {
            customKeyStoreId(model.customKeyStoreId);
            customKeyStoreName(model.customKeyStoreName);
            cloudHsmClusterId(model.cloudHsmClusterId);
            trustAnchorCertificate(model.trustAnchorCertificate);
            connectionState(model.connectionState);
            connectionErrorCode(model.connectionErrorCode);
            creationDate(model.creationDate);
            customKeyStoreType(model.customKeyStoreType);
            xksProxyConfiguration(model.xksProxyConfiguration);
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

        public final String getConnectionState() {
            return connectionState;
        }

        public final void setConnectionState(String connectionState) {
            this.connectionState = connectionState;
        }

        @Override
        public final Builder connectionState(String connectionState) {
            this.connectionState = connectionState;
            return this;
        }

        @Override
        public final Builder connectionState(ConnectionStateType connectionState) {
            this.connectionState(connectionState == null ? null : connectionState.toString());
            return this;
        }

        public final String getConnectionErrorCode() {
            return connectionErrorCode;
        }

        public final void setConnectionErrorCode(String connectionErrorCode) {
            this.connectionErrorCode = connectionErrorCode;
        }

        @Override
        public final Builder connectionErrorCode(String connectionErrorCode) {
            this.connectionErrorCode = connectionErrorCode;
            return this;
        }

        @Override
        public final Builder connectionErrorCode(ConnectionErrorCodeType connectionErrorCode) {
            this.connectionErrorCode(connectionErrorCode == null ? null : connectionErrorCode.toString());
            return this;
        }

        public final Instant getCreationDate() {
            return creationDate;
        }

        public final void setCreationDate(Instant creationDate) {
            this.creationDate = creationDate;
        }

        @Override
        public final Builder creationDate(Instant creationDate) {
            this.creationDate = creationDate;
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

        public final XksProxyConfigurationType.Builder getXksProxyConfiguration() {
            return xksProxyConfiguration != null ? xksProxyConfiguration.toBuilder() : null;
        }

        public final void setXksProxyConfiguration(XksProxyConfigurationType.BuilderImpl xksProxyConfiguration) {
            this.xksProxyConfiguration = xksProxyConfiguration != null ? xksProxyConfiguration.build() : null;
        }

        @Override
        public final Builder xksProxyConfiguration(XksProxyConfigurationType xksProxyConfiguration) {
            this.xksProxyConfiguration = xksProxyConfiguration;
            return this;
        }

        @Override
        public CustomKeyStoresListEntry build() {
            return new CustomKeyStoresListEntry(this);
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
