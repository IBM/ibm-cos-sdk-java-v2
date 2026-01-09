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


package com.ibm.cos.v2.protocols.json.internal.marshall;

import java.util.List;
import java.util.Map;
import com.ibm.cos.v2.annotations.SdkInternalApi;
import com.ibm.cos.v2.core.SdkNumber;
import com.ibm.cos.v2.core.document.Document;
import com.ibm.cos.v2.core.document.VoidDocumentVisitor;
import com.ibm.cos.v2.protocols.json.StructuredJsonGenerator;

@SdkInternalApi
public class DocumentTypeJsonMarshaller implements VoidDocumentVisitor {

    private final StructuredJsonGenerator jsonGenerator;

    public DocumentTypeJsonMarshaller(StructuredJsonGenerator jsonGenerator) {
        this.jsonGenerator = jsonGenerator;
    }

    @Override
    public void visitNull() {
        jsonGenerator.writeNull();
    }

    @Override
    public void visitBoolean(Boolean document) {
        jsonGenerator.writeValue(document);
    }

    @Override
    public void visitString(String document) {
        jsonGenerator.writeValue(document);

    }

    @Override
    public void visitNumber(SdkNumber document) {
        jsonGenerator.writeNumber(document.stringValue());

    }

    @Override
    public void visitMap(Map<String, Document> documentMap) {
        jsonGenerator.writeStartObject();
        documentMap.entrySet().forEach(entry -> {
            jsonGenerator.writeFieldName(entry.getKey());
            entry.getValue().accept(this);
        });
        jsonGenerator.writeEndObject();
    }

    @Override
    public void visitList(List<Document> documentList) {
        jsonGenerator.writeStartArray();
        documentList.stream().forEach(document -> document.accept(this));
        jsonGenerator.writeEndArray();
    }
}
