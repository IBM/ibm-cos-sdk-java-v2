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

package com.ibm.cos.v2.modulepath.tests;

import java.util.ArrayList;
import java.util.List;
import com.ibm.cos.v2.modulepath.tests.integtests.BaseApiCall;
import com.ibm.cos.v2.modulepath.tests.integtests.S3ApiCall;

/**
 * Tests runner to test module path on real service.
 */
public class IntegTestsRunner {

    private IntegTestsRunner() {
    }

    public static void main(String... args) {

        List<BaseApiCall> tests = new ArrayList<>();
        tests.add(new S3ApiCall());

        tests.forEach(test -> {
            test.usingApacheClient();
            test.usingUrlConnectionClient();
            test.usingNettyClient();
        });
    }
}
