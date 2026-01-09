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

package com.ibm.cos.v2.services.s3.endpoints.internal;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import com.ibm.cos.v2.awscore.endpoints.authscheme.EndpointAuthScheme;
import com.ibm.cos.v2.awscore.endpoints.authscheme.SigV4AuthScheme;
import com.ibm.cos.v2.awscore.endpoints.authscheme.SigV4aAuthScheme;

public final class DefaultEndpointAuthSchemeStrategyFactory implements EndpointAuthSchemeStrategyFactory {
    private static final String SIGV4_NAME = "sigv4";
    private static final String SIGV4A_NAME = "sigv4a";

    public EndpointAuthSchemeStrategy endpointAuthSchemeStrategy() {
        Map<String, Function<Value.Record, EndpointAuthScheme>> knownAuthSchemesMapping = new HashMap<>();
        knownAuthSchemesMapping.put(SIGV4A_NAME, this::sigV4A);
        knownAuthSchemesMapping.put(SIGV4_NAME, this::sigV4);
        return new DefaultEndpointAuthSchemeStrategy(knownAuthSchemesMapping);
    }

    private EndpointAuthScheme sigV4A(Value.Record scheme) {
        SigV4aAuthScheme.Builder schemeBuilder = SigV4aAuthScheme.builder();

        Value signingName = scheme.get(Identifier.of("signingName"));
        if (signingName != null) {
            schemeBuilder.signingName(signingName.expectString());
        }

        Value signingRegionSet = scheme.get(Identifier.of("signingRegionSet"));
        if (signingRegionSet != null) {
            Value.Array signingRegionSetArray = signingRegionSet.expectArray();
            for (int j = 0; j < signingRegionSetArray.size(); ++j) {
                schemeBuilder.addSigningRegion(signingRegionSetArray.get(j).expectString());
            }
        }

        Value disableDoubleEncoding = scheme.get(Identifier.of("disableDoubleEncoding"));
        if (disableDoubleEncoding != null) {
            schemeBuilder.disableDoubleEncoding(disableDoubleEncoding.expectBool());
        }

        return schemeBuilder.build();
    }

    private EndpointAuthScheme sigV4(Value.Record scheme) {
        SigV4AuthScheme.Builder schemeBuilder = SigV4AuthScheme.builder();

        Value signingName = scheme.get(Identifier.of("signingName"));
        if (signingName != null) {
            schemeBuilder.signingName(signingName.expectString());
        }

        Value signingRegion = scheme.get(Identifier.of("signingRegion"));
        if (signingRegion != null) {
            schemeBuilder.signingRegion(signingRegion.expectString());
        }

        Value disableDoubleEncoding = scheme.get(Identifier.of("disableDoubleEncoding"));
        if (disableDoubleEncoding != null) {
            schemeBuilder.disableDoubleEncoding(disableDoubleEncoding.expectBool());
        }

        return schemeBuilder.build();
    }
}
