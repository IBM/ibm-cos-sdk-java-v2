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

package com.ibm.cos.v2.protocols.query.internal.unmarshall;

import java.util.List;
import com.ibm.cos.v2.annotations.SdkInternalApi;
import com.ibm.cos.v2.core.SdkField;
import com.ibm.cos.v2.protocols.core.StringToValueConverter;
import com.ibm.cos.v2.protocols.query.unmarshall.XmlElement;

/**
 * Unmarshaller implementation for simple, scalar values.
 *
 * @param <T> Type being unmarshalled.
 */
@SdkInternalApi
public final class SimpleTypeQueryUnmarshaller<T> implements QueryUnmarshaller<T> {

    private final StringToValueConverter.StringToValue<T> stringToValue;

    public SimpleTypeQueryUnmarshaller(StringToValueConverter.StringToValue<T> stringToValue) {
        this.stringToValue = stringToValue;
    }

    @Override
    public T unmarshall(QueryUnmarshallerContext context, List<XmlElement> content, SdkField<T> field) {
        if (content == null) {
            return null;
        }
        return stringToValue.convert(content.get(0).textContent(), field);
    }
}
