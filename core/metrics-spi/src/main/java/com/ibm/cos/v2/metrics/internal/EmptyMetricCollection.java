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

package com.ibm.cos.v2.metrics.internal;

import java.time.Instant;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import com.ibm.cos.v2.annotations.SdkInternalApi;
import com.ibm.cos.v2.metrics.MetricCollection;
import com.ibm.cos.v2.metrics.MetricRecord;
import com.ibm.cos.v2.metrics.SdkMetric;

@SdkInternalApi
public final class EmptyMetricCollection implements MetricCollection {
    private final Instant creationTime = Instant.now();

    @Override
    public String name() {
        return "NoOp";
    }

    @Override
    public <T> List<T> metricValues(SdkMetric<T> metric) {
        return Collections.emptyList();
    }

    @Override
    public List<MetricCollection> children() {
        return Collections.emptyList();
    }

    @Override
    public Instant creationTime() {
        return creationTime;
    }

    @Override
    public Iterator<MetricRecord<?>> iterator() {
        return Collections.emptyIterator();
    }

    public static EmptyMetricCollection create() {
        return new EmptyMetricCollection();
    }
}
