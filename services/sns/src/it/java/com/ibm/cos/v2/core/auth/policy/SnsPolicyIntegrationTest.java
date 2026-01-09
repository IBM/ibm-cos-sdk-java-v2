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

package com.ibm.cos.v2.core.auth.policy;

import org.junit.After;
import org.junit.Test;
import com.ibm.cos.v2.core.auth.policy.Statement.Effect;
import com.ibm.cos.v2.core.auth.policy.conditions.StringCondition;
import com.ibm.cos.v2.core.auth.policy.conditions.StringCondition.StringComparisonType;
import com.ibm.cos.v2.services.sns.IntegrationTestBase;
import com.ibm.cos.v2.services.sns.model.CreateTopicRequest;
import com.ibm.cos.v2.services.sns.model.DeleteTopicRequest;
import com.ibm.cos.v2.services.sns.model.SetTopicAttributesRequest;

/**
 * Integration tests for the service specific access control policy code provided by the Sns client.
 */
public class SnsPolicyIntegrationTest extends IntegrationTestBase {
    private String topicArn;

    /**
     * Releases all test resources.
     */
    @After
    public void tearDown() throws Exception {
        sns.deleteTopic(DeleteTopicRequest.builder().topicArn(topicArn).build());
    }

    /**
     * Tests that we can construct valid policies with Sns specific conditions/resources/etc.
     */
    @Test
    public void testPolicies() throws Exception {
        String topicName = "java-sns-policy-integ-test-" + System.currentTimeMillis();
        topicArn = sns.createTopic(CreateTopicRequest.builder().name(topicName).build()).topicArn();

        Policy policy = new Policy()
                .withStatements(new Statement(Effect.Allow)
                                        .withActions(new Action("sns:Subscribe"))
                                        .withPrincipals(Principal.ALL_USERS)
                                        .withResources(new Resource(topicArn))
                                        .withConditions(new StringCondition(StringComparisonType.StringLike,
                                                                            "sns:Endpoint", "*@amazon.com"),
                                                        new StringCondition(StringComparisonType.StringEquals,
                                                                            "sns:Protocol", "email")));
        sns.setTopicAttributes(SetTopicAttributesRequest.builder()
                                                        .topicArn(topicArn)
                                                        .attributeName("Policy")
                                                        .attributeValue(policy.toJson())
                                                        .build());
    }
}
