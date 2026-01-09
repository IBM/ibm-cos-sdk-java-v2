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

package com.ibm.cos.v2.benchmark.marshaller.dynamodb;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UncheckedIOException;
import java.net.URI;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import com.ibm.cos.v2.core.client.config.SdkClientConfiguration;
import com.ibm.cos.v2.core.client.config.SdkClientOption;
import com.ibm.cos.v2.core.http.HttpResponseHandler;
import com.ibm.cos.v2.core.interceptor.ExecutionAttributes;
import com.ibm.cos.v2.http.AbortableInputStream;
import com.ibm.cos.v2.http.SdkHttpFullRequest;
import com.ibm.cos.v2.http.SdkHttpFullResponse;
import com.ibm.cos.v2.protocols.core.ExceptionMetadata;
import com.ibm.cos.v2.protocols.json.AwsJsonProtocol;
import com.ibm.cos.v2.protocols.json.AwsJsonProtocolFactory;
import com.ibm.cos.v2.protocols.json.JsonOperationMetadata;
import com.ibm.cos.v2.protocols.json.internal.unmarshall.SdkClientJsonProtocolAdvancedOption;
import com.ibm.cos.v2.services.dynamodb.model.AttributeValue;
import com.ibm.cos.v2.services.dynamodb.model.BackupInUseException;
import com.ibm.cos.v2.services.dynamodb.model.BackupNotFoundException;
import com.ibm.cos.v2.services.dynamodb.model.ConditionalCheckFailedException;
import com.ibm.cos.v2.services.dynamodb.model.ContinuousBackupsUnavailableException;
import com.ibm.cos.v2.services.dynamodb.model.DynamoDbException;
import com.ibm.cos.v2.services.dynamodb.model.GetItemResponse;
import com.ibm.cos.v2.services.dynamodb.model.GlobalTableAlreadyExistsException;
import com.ibm.cos.v2.services.dynamodb.model.GlobalTableNotFoundException;
import com.ibm.cos.v2.services.dynamodb.model.IndexNotFoundException;
import com.ibm.cos.v2.services.dynamodb.model.InternalServerErrorException;
import com.ibm.cos.v2.services.dynamodb.model.InvalidRestoreTimeException;
import com.ibm.cos.v2.services.dynamodb.model.ItemCollectionSizeLimitExceededException;
import com.ibm.cos.v2.services.dynamodb.model.LimitExceededException;
import com.ibm.cos.v2.services.dynamodb.model.PointInTimeRecoveryUnavailableException;
import com.ibm.cos.v2.services.dynamodb.model.ProvisionedThroughputExceededException;
import com.ibm.cos.v2.services.dynamodb.model.PutItemRequest;
import com.ibm.cos.v2.services.dynamodb.model.ReplicaAlreadyExistsException;
import com.ibm.cos.v2.services.dynamodb.model.ReplicaNotFoundException;
import com.ibm.cos.v2.services.dynamodb.model.ResourceInUseException;
import com.ibm.cos.v2.services.dynamodb.model.ResourceNotFoundException;
import com.ibm.cos.v2.services.dynamodb.model.TableAlreadyExistsException;
import com.ibm.cos.v2.services.dynamodb.model.TableInUseException;
import com.ibm.cos.v2.services.dynamodb.model.TableNotFoundException;
import com.ibm.cos.v2.services.dynamodb.transform.PutItemRequestMarshaller;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Fork(1)
public class V2DynamoDbAttributeValue {

    private static final AwsJsonProtocolFactory JSON_PROTOCOL_FACTORY = AwsJsonProtocolFactory
        .builder()
        .clientConfiguration(SdkClientConfiguration
                                 .builder()
                                 .option(SdkClientOption.ENDPOINT, URI.create("https://localhost"))
                                 .option(SdkClientJsonProtocolAdvancedOption.ENABLE_FAST_UNMARSHALLER, true)
                                 .build())
        .defaultServiceExceptionSupplier(DynamoDbException::builder)
        .protocol(AwsJsonProtocol.AWS_JSON)
        .protocolVersion("1.0")
        .registerModeledException(
            ExceptionMetadata.builder().errorCode("ResourceInUseException")
                             .exceptionBuilderSupplier(ResourceInUseException::builder).build())
        .registerModeledException(
            ExceptionMetadata.builder().errorCode("TableAlreadyExistsException")
                             .exceptionBuilderSupplier(TableAlreadyExistsException::builder).build())
        .registerModeledException(
            ExceptionMetadata.builder().errorCode("GlobalTableAlreadyExistsException")
                             .exceptionBuilderSupplier(GlobalTableAlreadyExistsException::builder).build())
        .registerModeledException(
            ExceptionMetadata.builder().errorCode("InvalidRestoreTimeException")
                             .exceptionBuilderSupplier(InvalidRestoreTimeException::builder).build())
        .registerModeledException(
            ExceptionMetadata.builder().errorCode("ReplicaAlreadyExistsException")
                             .exceptionBuilderSupplier(ReplicaAlreadyExistsException::builder).build())
        .registerModeledException(
            ExceptionMetadata.builder().errorCode("ConditionalCheckFailedException")
                             .exceptionBuilderSupplier(ConditionalCheckFailedException::builder).build())
        .registerModeledException(
            ExceptionMetadata.builder().errorCode("BackupNotFoundException")
                             .exceptionBuilderSupplier(BackupNotFoundException::builder).build())
        .registerModeledException(
            ExceptionMetadata.builder().errorCode("IndexNotFoundException")
                             .exceptionBuilderSupplier(IndexNotFoundException::builder).build())
        .registerModeledException(
            ExceptionMetadata.builder().errorCode("LimitExceededException")
                             .exceptionBuilderSupplier(LimitExceededException::builder).build())
        .registerModeledException(
            ExceptionMetadata.builder().errorCode("GlobalTableNotFoundException")
                             .exceptionBuilderSupplier(GlobalTableNotFoundException::builder).build())
        .registerModeledException(
            ExceptionMetadata.builder().errorCode("ItemCollectionSizeLimitExceededException")
                             .exceptionBuilderSupplier(ItemCollectionSizeLimitExceededException::builder).build())
        .registerModeledException(
            ExceptionMetadata.builder().errorCode("ReplicaNotFoundException")
                             .exceptionBuilderSupplier(ReplicaNotFoundException::builder).build())
        .registerModeledException(
            ExceptionMetadata.builder().errorCode("TableNotFoundException")
                             .exceptionBuilderSupplier(TableNotFoundException::builder).build())
        .registerModeledException(
            ExceptionMetadata.builder().errorCode("BackupInUseException")
                             .exceptionBuilderSupplier(BackupInUseException::builder).build())
        .registerModeledException(
            ExceptionMetadata.builder().errorCode("ResourceNotFoundException")
                             .exceptionBuilderSupplier(ResourceNotFoundException::builder).build())
        .registerModeledException(
            ExceptionMetadata.builder().errorCode("ContinuousBackupsUnavailableException")
                             .exceptionBuilderSupplier(ContinuousBackupsUnavailableException::builder).build())
        .registerModeledException(
            ExceptionMetadata.builder().errorCode("TableInUseException")
                             .exceptionBuilderSupplier(TableInUseException::builder).build())
        .registerModeledException(
            ExceptionMetadata.builder().errorCode("ProvisionedThroughputExceededException")
                             .exceptionBuilderSupplier(ProvisionedThroughputExceededException::builder).build())
        .registerModeledException(
            ExceptionMetadata.builder().errorCode("PointInTimeRecoveryUnavailableException")
                             .exceptionBuilderSupplier(PointInTimeRecoveryUnavailableException::builder).build())
        .registerModeledException(
            ExceptionMetadata.builder().errorCode("InternalServerError")
                             .exceptionBuilderSupplier(InternalServerErrorException::builder).build())
        .build();

    private static final PutItemRequestMarshaller PUT_ITEM_REQUEST_MARSHALLER
        = new PutItemRequestMarshaller(getJsonProtocolFactory());

    private static HttpResponseHandler<GetItemResponse> getItemResponseJsonResponseHandler() {
        return JSON_PROTOCOL_FACTORY.createResponseHandler(JsonOperationMetadata.builder()
                                                                                .isPayloadJson(true)
                                                                                .hasStreamingSuccessResponse(false)
                                                                                .build(),
                                                           GetItemResponse::builder);
    }

    @Benchmark
    public Object putItem(PutItemState s) {
        return putItemRequestMarshaller().marshall(s.getReq());
    }

    @Benchmark
    public Object getItem(GetItemState s) throws Exception {
        SdkHttpFullResponse resp = fullResponse(s.testItem);
        return getItemResponseJsonResponseHandler().handle(resp, new ExecutionAttributes());
    }

    @State(Scope.Benchmark)
    public static class PutItemState {
        @Param({"TINY", "SMALL", "HUGE"})
        private TestItem testItem;

        private PutItemRequest req;

        @Setup
        public void setup() {
            req = PutItemRequest.builder().item(testItem.getValue()).build();
        }

        public PutItemRequest getReq() {
            return req;
        }
    }

    @State(Scope.Benchmark)
    public static class GetItemState {
        @Param({"TINY", "SMALL", "HUGE"})
        private TestItemUnmarshalling testItem;
    }

    public enum TestItem {
        TINY,
        SMALL,
        HUGE;

        private static final AbstractItemFactory<AttributeValue> FACTORY = new V2ItemFactory();

        private Map<String, AttributeValue> av;

        static {
            TINY.av = FACTORY.tiny();
            SMALL.av = FACTORY.small();
            HUGE.av = FACTORY.huge();
        }

        public Map<String, AttributeValue> getValue() {
            return av;
        }
    }

    public enum TestItemUnmarshalling {
        TINY,
        SMALL,
        HUGE;

        private byte[] utf8;

        static {
            TINY.utf8 = toUtf8ByteArray(TestItem.TINY.av);
            SMALL.utf8 = toUtf8ByteArray(TestItem.SMALL.av);
            HUGE.utf8 = toUtf8ByteArray(TestItem.HUGE.av);
        }

        public byte[] utf8() {
            return utf8;
        }
    }

    private SdkHttpFullResponse fullResponse(TestItemUnmarshalling item) {
        AbortableInputStream abortableInputStream = AbortableInputStream.create(new ByteArrayInputStream(item.utf8()));
        return SdkHttpFullResponse.builder()
                                  .statusCode(200)
                                  .content(abortableInputStream)
                                  .build();
    }

    private static byte[] toUtf8ByteArray(Map<String, AttributeValue> item) {
        SdkHttpFullRequest marshalled = putItemRequestMarshaller().marshall(PutItemRequest.builder().item(item).build());
        InputStream content = marshalled.contentStreamProvider().get().newStream();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] buff = new byte[8192];
        int read;
        try {
            while ((read = content.read(buff)) != -1) {
                baos.write(buff, 0, read);
            }
        } catch (IOException ioe) {
            throw new UncheckedIOException(ioe);
        }
        return baos.toByteArray();
    }

    private static PutItemRequestMarshaller putItemRequestMarshaller() {
        return PUT_ITEM_REQUEST_MARSHALLER;
    }

    private static AwsJsonProtocolFactory getJsonProtocolFactory() {
        return JSON_PROTOCOL_FACTORY;
    }
}
