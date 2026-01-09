/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License").
 * You may not use this file except in compliance with the License.
 * A copy of the License is located at
 *
 *  http://aws.amazon.com/apache2.0
 *
 * or in the "license" file accompanying this file. This file is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */

package com.ibm.cos.v2.utils.internal.proxy;

import static com.ibm.cos.v2.utils.http.SdkHttpUtils.parseNonProxyHostsEnvironmentVariable;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import com.ibm.cos.v2.annotations.SdkInternalApi;
import com.ibm.cos.v2.utils.Logger;
import com.ibm.cos.v2.utils.ProxyConfigProvider;
import com.ibm.cos.v2.utils.ProxyEnvironmentSetting;
import com.ibm.cos.v2.utils.StringUtils;

/**
 * An implementation of the {@link ProxyConfigProvider} interface that retrieves proxy configuration settings from environment
 * variables. This class is responsible for extracting proxy host, port, username, and password settings from environment
 * variables based on the specified proxy scheme (HTTP or HTTPS).
 *
 * @see ProxyConfigProvider
 */
@SdkInternalApi
public class ProxyEnvironmentVariableConfigProvider implements ProxyConfigProvider {

    private static final Logger log = Logger.loggerFor(ProxyEnvironmentVariableConfigProvider.class);

    private final String scheme;

    private final URL proxyUrl;

    public ProxyEnvironmentVariableConfigProvider(String scheme) {
        this.scheme = scheme == null ? "http" : scheme;
        this.proxyUrl = silentlyGetUrl().orElse(null);
    }


    private Optional<URL> silentlyGetUrl() {
        String stringUrl = Objects.equals(this.scheme, HTTPS) ? ProxyEnvironmentSetting.HTTPS_PROXY.getStringValue().orElse(null)
                                                              : ProxyEnvironmentSetting.HTTP_PROXY.getStringValue().orElse(null);
        if (StringUtils.isNotBlank(stringUrl)) {
            try {
                return Optional.of(new URL(stringUrl));
            } catch (MalformedURLException e) {
                log.warn(() -> "Malformed proxy config environment variable.", e);
            }
        }
        return Optional.empty();
    }

    @Override
    public int port() {
        return Optional.ofNullable(this.proxyUrl)
                       .map(URL::getPort)
                       .orElse(0);
    }

    @Override
    public Optional<String> userName() {
        return Optional.ofNullable(this.proxyUrl)
                       .map(URL::getUserInfo)
                       .flatMap(userInfo -> Optional.ofNullable(userInfo.split(":", 2)[0]));
    }

    @Override
    public Optional<String> password() {
        return Optional.ofNullable(this.proxyUrl)
                       .map(URL::getUserInfo)
                       .filter(userInfo -> userInfo.contains(":"))
                       .map(userInfo -> userInfo.split(":", 2))
                       .filter(parts -> parts.length > 1)
                       .map(parts -> parts[1]);
    }

    @Override
    public String host() {
        return Optional.ofNullable(this.proxyUrl).map(URL::getHost).orElse(null);
    }

    @Override
    public Set<String> nonProxyHosts() {
        return parseNonProxyHostsEnvironmentVariable();
    }
}
