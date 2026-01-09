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
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.function.BiConsumer;
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
 * Detailed information about the external key store proxy (XKS proxy). Your external key store proxy translates KMS
 * requests into a format that your external key manager can understand. These fields appear in a
 * <a>DescribeCustomKeyStores</a> response only when the <code>CustomKeyStoreType</code> is
 * <code>EXTERNAL_KEY_STORE</code>.
 * </p>
 */
@Generated("com.ibm.cos.v2:codegen")
public final class XksProxyConfigurationType implements SdkPojo, Serializable,
        ToCopyableBuilder<XksProxyConfigurationType.Builder, XksProxyConfigurationType> {
    private static final SdkField<String> CONNECTIVITY_FIELD = SdkField.<String> builder(MarshallingType.STRING)
            .memberName("Connectivity").getter(getter(XksProxyConfigurationType::connectivityAsString))
            .setter(setter(Builder::connectivity))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("Connectivity").build()).build();

    private static final SdkField<String> ACCESS_KEY_ID_FIELD = SdkField.<String> builder(MarshallingType.STRING)
            .memberName("AccessKeyId").getter(getter(XksProxyConfigurationType::accessKeyId))
            .setter(setter(Builder::accessKeyId))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("AccessKeyId").build()).build();

    private static final SdkField<String> URI_ENDPOINT_FIELD = SdkField.<String> builder(MarshallingType.STRING)
            .memberName("UriEndpoint").getter(getter(XksProxyConfigurationType::uriEndpoint))
            .setter(setter(Builder::uriEndpoint))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("UriEndpoint").build()).build();

    private static final SdkField<String> URI_PATH_FIELD = SdkField.<String> builder(MarshallingType.STRING)
            .memberName("UriPath").getter(getter(XksProxyConfigurationType::uriPath)).setter(setter(Builder::uriPath))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("UriPath").build()).build();

    private static final SdkField<String> VPC_ENDPOINT_SERVICE_NAME_FIELD = SdkField.<String> builder(MarshallingType.STRING)
            .memberName("VpcEndpointServiceName").getter(getter(XksProxyConfigurationType::vpcEndpointServiceName))
            .setter(setter(Builder::vpcEndpointServiceName))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("VpcEndpointServiceName").build())
            .build();

    private static final List<SdkField<?>> SDK_FIELDS = Collections.unmodifiableList(Arrays.asList(CONNECTIVITY_FIELD,
            ACCESS_KEY_ID_FIELD, URI_ENDPOINT_FIELD, URI_PATH_FIELD, VPC_ENDPOINT_SERVICE_NAME_FIELD));

    private static final Map<String, SdkField<?>> SDK_NAME_TO_FIELD = memberNameToFieldInitializer();

    private static final long serialVersionUID = 1L;

    private final String connectivity;

    private final String accessKeyId;

    private final String uriEndpoint;

    private final String uriPath;

    private final String vpcEndpointServiceName;

    private XksProxyConfigurationType(BuilderImpl builder) {
        this.connectivity = builder.connectivity;
        this.accessKeyId = builder.accessKeyId;
        this.uriEndpoint = builder.uriEndpoint;
        this.uriPath = builder.uriPath;
        this.vpcEndpointServiceName = builder.vpcEndpointServiceName;
    }

    /**
     * <p>
     * Indicates whether the external key store proxy uses a public endpoint or an Amazon VPC endpoint service to
     * communicate with KMS.
     * </p>
     * <p>
     * If the service returns an enum value that is not available in the current SDK version, {@link #connectivity} will
     * return {@link XksProxyConnectivityType#UNKNOWN_TO_SDK_VERSION}. The raw value returned by the service is
     * available from {@link #connectivityAsString}.
     * </p>
     * 
     * @return Indicates whether the external key store proxy uses a public endpoint or an Amazon VPC endpoint service
     *         to communicate with KMS.
     * @see XksProxyConnectivityType
     */
    public final XksProxyConnectivityType connectivity() {
        return XksProxyConnectivityType.fromValue(connectivity);
    }

    /**
     * <p>
     * Indicates whether the external key store proxy uses a public endpoint or an Amazon VPC endpoint service to
     * communicate with KMS.
     * </p>
     * <p>
     * If the service returns an enum value that is not available in the current SDK version, {@link #connectivity} will
     * return {@link XksProxyConnectivityType#UNKNOWN_TO_SDK_VERSION}. The raw value returned by the service is
     * available from {@link #connectivityAsString}.
     * </p>
     * 
     * @return Indicates whether the external key store proxy uses a public endpoint or an Amazon VPC endpoint service
     *         to communicate with KMS.
     * @see XksProxyConnectivityType
     */
    public final String connectivityAsString() {
        return connectivity;
    }

    /**
     * <p>
     * The part of the external key store <a href=
     * "https://docs.aws.amazon.com/kms/latest/APIReference/API_CreateCustomKeyStore.html#KMS-CreateCustomKeyStore-request-XksProxyAuthenticationCredential"
     * >proxy authentication credential</a> that uniquely identifies the secret access key.
     * </p>
     * 
     * @return The part of the external key store <a href=
     *         "https://docs.aws.amazon.com/kms/latest/APIReference/API_CreateCustomKeyStore.html#KMS-CreateCustomKeyStore-request-XksProxyAuthenticationCredential"
     *         >proxy authentication credential</a> that uniquely identifies the secret access key.
     */
    public final String accessKeyId() {
        return accessKeyId;
    }

    /**
     * <p>
     * The URI endpoint for the external key store proxy.
     * </p>
     * <p>
     * If the external key store proxy has a public endpoint, it is displayed here.
     * </p>
     * <p>
     * If the external key store proxy uses an Amazon VPC endpoint service name, this field displays the private DNS
     * name associated with the VPC endpoint service.
     * </p>
     * 
     * @return The URI endpoint for the external key store proxy.</p>
     *         <p>
     *         If the external key store proxy has a public endpoint, it is displayed here.
     *         </p>
     *         <p>
     *         If the external key store proxy uses an Amazon VPC endpoint service name, this field displays the private
     *         DNS name associated with the VPC endpoint service.
     */
    public final String uriEndpoint() {
        return uriEndpoint;
    }

    /**
     * <p>
     * The path to the external key store proxy APIs.
     * </p>
     * 
     * @return The path to the external key store proxy APIs.
     */
    public final String uriPath() {
        return uriPath;
    }

    /**
     * <p>
     * The Amazon VPC endpoint service used to communicate with the external key store proxy. This field appears only
     * when the external key store proxy uses an Amazon VPC endpoint service to communicate with KMS.
     * </p>
     * 
     * @return The Amazon VPC endpoint service used to communicate with the external key store proxy. This field appears
     *         only when the external key store proxy uses an Amazon VPC endpoint service to communicate with KMS.
     */
    public final String vpcEndpointServiceName() {
        return vpcEndpointServiceName;
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
        hashCode = 31 * hashCode + Objects.hashCode(connectivityAsString());
        hashCode = 31 * hashCode + Objects.hashCode(accessKeyId());
        hashCode = 31 * hashCode + Objects.hashCode(uriEndpoint());
        hashCode = 31 * hashCode + Objects.hashCode(uriPath());
        hashCode = 31 * hashCode + Objects.hashCode(vpcEndpointServiceName());
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
        if (!(obj instanceof XksProxyConfigurationType)) {
            return false;
        }
        XksProxyConfigurationType other = (XksProxyConfigurationType) obj;
        return Objects.equals(connectivityAsString(), other.connectivityAsString())
                && Objects.equals(accessKeyId(), other.accessKeyId()) && Objects.equals(uriEndpoint(), other.uriEndpoint())
                && Objects.equals(uriPath(), other.uriPath())
                && Objects.equals(vpcEndpointServiceName(), other.vpcEndpointServiceName());
    }

    /**
     * Returns a string representation of this object. This is useful for testing and debugging. Sensitive data will be
     * redacted from this string using a placeholder value.
     */
    @Override
    public final String toString() {
        return ToString.builder("XksProxyConfigurationType").add("Connectivity", connectivityAsString())
                .add("AccessKeyId", accessKeyId() == null ? null : "*** Sensitive Data Redacted ***")
                .add("UriEndpoint", uriEndpoint()).add("UriPath", uriPath())
                .add("VpcEndpointServiceName", vpcEndpointServiceName()).build();
    }

    public final <T> Optional<T> getValueForField(String fieldName, Class<T> clazz) {
        switch (fieldName) {
        case "Connectivity":
            return Optional.ofNullable(clazz.cast(connectivityAsString()));
        case "AccessKeyId":
            return Optional.ofNullable(clazz.cast(accessKeyId()));
        case "UriEndpoint":
            return Optional.ofNullable(clazz.cast(uriEndpoint()));
        case "UriPath":
            return Optional.ofNullable(clazz.cast(uriPath()));
        case "VpcEndpointServiceName":
            return Optional.ofNullable(clazz.cast(vpcEndpointServiceName()));
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
        map.put("Connectivity", CONNECTIVITY_FIELD);
        map.put("AccessKeyId", ACCESS_KEY_ID_FIELD);
        map.put("UriEndpoint", URI_ENDPOINT_FIELD);
        map.put("UriPath", URI_PATH_FIELD);
        map.put("VpcEndpointServiceName", VPC_ENDPOINT_SERVICE_NAME_FIELD);
        return Collections.unmodifiableMap(map);
    }

    private static <T> Function<Object, T> getter(Function<XksProxyConfigurationType, T> g) {
        return obj -> g.apply((XksProxyConfigurationType) obj);
    }

    private static <T> BiConsumer<Object, T> setter(BiConsumer<Builder, T> s) {
        return (obj, val) -> s.accept((Builder) obj, val);
    }

    @Mutable
    @NotThreadSafe
    public interface Builder extends SdkPojo, CopyableBuilder<Builder, XksProxyConfigurationType> {
        /**
         * <p>
         * Indicates whether the external key store proxy uses a public endpoint or an Amazon VPC endpoint service to
         * communicate with KMS.
         * </p>
         * 
         * @param connectivity
         *        Indicates whether the external key store proxy uses a public endpoint or an Amazon VPC endpoint
         *        service to communicate with KMS.
         * @see XksProxyConnectivityType
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see XksProxyConnectivityType
         */
        Builder connectivity(String connectivity);

        /**
         * <p>
         * Indicates whether the external key store proxy uses a public endpoint or an Amazon VPC endpoint service to
         * communicate with KMS.
         * </p>
         * 
         * @param connectivity
         *        Indicates whether the external key store proxy uses a public endpoint or an Amazon VPC endpoint
         *        service to communicate with KMS.
         * @see XksProxyConnectivityType
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see XksProxyConnectivityType
         */
        Builder connectivity(XksProxyConnectivityType connectivity);

        /**
         * <p>
         * The part of the external key store <a href=
         * "https://docs.aws.amazon.com/kms/latest/APIReference/API_CreateCustomKeyStore.html#KMS-CreateCustomKeyStore-request-XksProxyAuthenticationCredential"
         * >proxy authentication credential</a> that uniquely identifies the secret access key.
         * </p>
         * 
         * @param accessKeyId
         *        The part of the external key store <a href=
         *        "https://docs.aws.amazon.com/kms/latest/APIReference/API_CreateCustomKeyStore.html#KMS-CreateCustomKeyStore-request-XksProxyAuthenticationCredential"
         *        >proxy authentication credential</a> that uniquely identifies the secret access key.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder accessKeyId(String accessKeyId);

        /**
         * <p>
         * The URI endpoint for the external key store proxy.
         * </p>
         * <p>
         * If the external key store proxy has a public endpoint, it is displayed here.
         * </p>
         * <p>
         * If the external key store proxy uses an Amazon VPC endpoint service name, this field displays the private DNS
         * name associated with the VPC endpoint service.
         * </p>
         * 
         * @param uriEndpoint
         *        The URI endpoint for the external key store proxy.</p>
         *        <p>
         *        If the external key store proxy has a public endpoint, it is displayed here.
         *        </p>
         *        <p>
         *        If the external key store proxy uses an Amazon VPC endpoint service name, this field displays the
         *        private DNS name associated with the VPC endpoint service.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder uriEndpoint(String uriEndpoint);

        /**
         * <p>
         * The path to the external key store proxy APIs.
         * </p>
         * 
         * @param uriPath
         *        The path to the external key store proxy APIs.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder uriPath(String uriPath);

        /**
         * <p>
         * The Amazon VPC endpoint service used to communicate with the external key store proxy. This field appears
         * only when the external key store proxy uses an Amazon VPC endpoint service to communicate with KMS.
         * </p>
         * 
         * @param vpcEndpointServiceName
         *        The Amazon VPC endpoint service used to communicate with the external key store proxy. This field
         *        appears only when the external key store proxy uses an Amazon VPC endpoint service to communicate with
         *        KMS.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder vpcEndpointServiceName(String vpcEndpointServiceName);
    }

    static final class BuilderImpl implements Builder {
        private String connectivity;

        private String accessKeyId;

        private String uriEndpoint;

        private String uriPath;

        private String vpcEndpointServiceName;

        private BuilderImpl() {
        }

        private BuilderImpl(XksProxyConfigurationType model) {
            connectivity(model.connectivity);
            accessKeyId(model.accessKeyId);
            uriEndpoint(model.uriEndpoint);
            uriPath(model.uriPath);
            vpcEndpointServiceName(model.vpcEndpointServiceName);
        }

        public final String getConnectivity() {
            return connectivity;
        }

        public final void setConnectivity(String connectivity) {
            this.connectivity = connectivity;
        }

        @Override
        public final Builder connectivity(String connectivity) {
            this.connectivity = connectivity;
            return this;
        }

        @Override
        public final Builder connectivity(XksProxyConnectivityType connectivity) {
            this.connectivity(connectivity == null ? null : connectivity.toString());
            return this;
        }

        public final String getAccessKeyId() {
            return accessKeyId;
        }

        public final void setAccessKeyId(String accessKeyId) {
            this.accessKeyId = accessKeyId;
        }

        @Override
        public final Builder accessKeyId(String accessKeyId) {
            this.accessKeyId = accessKeyId;
            return this;
        }

        public final String getUriEndpoint() {
            return uriEndpoint;
        }

        public final void setUriEndpoint(String uriEndpoint) {
            this.uriEndpoint = uriEndpoint;
        }

        @Override
        public final Builder uriEndpoint(String uriEndpoint) {
            this.uriEndpoint = uriEndpoint;
            return this;
        }

        public final String getUriPath() {
            return uriPath;
        }

        public final void setUriPath(String uriPath) {
            this.uriPath = uriPath;
        }

        @Override
        public final Builder uriPath(String uriPath) {
            this.uriPath = uriPath;
            return this;
        }

        public final String getVpcEndpointServiceName() {
            return vpcEndpointServiceName;
        }

        public final void setVpcEndpointServiceName(String vpcEndpointServiceName) {
            this.vpcEndpointServiceName = vpcEndpointServiceName;
        }

        @Override
        public final Builder vpcEndpointServiceName(String vpcEndpointServiceName) {
            this.vpcEndpointServiceName = vpcEndpointServiceName;
            return this;
        }

        @Override
        public XksProxyConfigurationType build() {
            return new XksProxyConfigurationType(this);
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
