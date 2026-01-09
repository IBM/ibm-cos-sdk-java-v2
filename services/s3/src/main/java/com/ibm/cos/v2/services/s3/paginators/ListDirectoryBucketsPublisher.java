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

package com.ibm.cos.v2.services.s3.paginators;

import java.util.Collections;
import java.util.Iterator;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;
import org.reactivestreams.Subscriber;
import com.ibm.cos.v2.annotations.Generated;
import com.ibm.cos.v2.core.async.SdkPublisher;
import com.ibm.cos.v2.core.pagination.async.AsyncPageFetcher;
import com.ibm.cos.v2.core.pagination.async.PaginatedItemsPublisher;
import com.ibm.cos.v2.core.pagination.async.ResponsesSubscription;
import com.ibm.cos.v2.core.util.PaginatorUtils;
import com.ibm.cos.v2.services.s3.S3AsyncClient;
import com.ibm.cos.v2.services.s3.internal.UserAgentUtils;
import com.ibm.cos.v2.services.s3.model.Bucket;
import com.ibm.cos.v2.services.s3.model.ListDirectoryBucketsRequest;
import com.ibm.cos.v2.services.s3.model.ListDirectoryBucketsResponse;

/**
 * <p>
 * Represents the output for the
 * {@link com.ibm.cos.v2.services.s3.S3AsyncClient#listDirectoryBucketsPaginator(com.ibm.cos.v2.services.s3.model.ListDirectoryBucketsRequest)}
 * operation which is a paginated operation. This class is a type of {@link org.reactivestreams.Publisher} which can be
 * used to provide a sequence of {@link com.ibm.cos.v2.services.s3.model.ListDirectoryBucketsResponse} response
 * pages as per demand from the subscriber.
 * </p>
 * <p>
 * When the operation is called, an instance of this class is returned. At this point, no service calls are made yet and
 * so there is no guarantee that the request is valid. If there are errors in your request, you will see the failures
 * only after you start streaming the data. The subscribe method should be called as a request to start streaming data.
 * For more info, see {@link org.reactivestreams.Publisher#subscribe(org.reactivestreams.Subscriber)}. Each call to the
 * subscribe method will result in a new {@link org.reactivestreams.Subscription} i.e., a new contract to stream data
 * from the starting request.
 * </p>
 *
 * <p>
 * The following are few ways to use the response class:
 * </p>
 * 1) Using the subscribe helper method
 * 
 * <pre>
 * {@code
 * com.ibm.cos.v2.services.s3.paginators.ListDirectoryBucketsPublisher publisher = client.listDirectoryBucketsPaginator(request);
 * CompletableFuture<Void> future = publisher.subscribe(res -> { // Do something with the response });
 * future.get();
 * }
 * </pre>
 *
 * 2) Using a custom subscriber
 * 
 * <pre>
 * {@code
 * com.ibm.cos.v2.services.s3.paginators.ListDirectoryBucketsPublisher publisher = client.listDirectoryBucketsPaginator(request);
 * publisher.subscribe(new Subscriber<com.ibm.cos.v2.services.s3.model.ListDirectoryBucketsResponse>() {
 * 
 * public void onSubscribe(org.reactivestreams.Subscriber subscription) { //... };
 * 
 * 
 * public void onNext(com.ibm.cos.v2.services.s3.model.ListDirectoryBucketsResponse response) { //... };
 * });}
 * </pre>
 * 
 * As the response is a publisher, it can work well with third party reactive streams implementations like RxJava2.
 * <p>
 * <b>Please notice that the configuration of MaxDirectoryBuckets won't limit the number of results you get with the
 * paginator. It only limits the number of results in each page.</b>
 * </p>
 * <p>
 * <b>Note: If you prefer to have control on service calls, use the
 * {@link #listDirectoryBuckets(com.ibm.cos.v2.services.s3.model.ListDirectoryBucketsRequest)} operation.</b>
 * </p>
 */
@Generated("com.ibm.cos.v2:codegen")
public class ListDirectoryBucketsPublisher implements SdkPublisher<ListDirectoryBucketsResponse> {
    private final S3AsyncClient client;

    private final ListDirectoryBucketsRequest firstRequest;

    private final AsyncPageFetcher nextPageFetcher;

    private boolean isLastPage;

    public ListDirectoryBucketsPublisher(S3AsyncClient client, ListDirectoryBucketsRequest firstRequest) {
        this(client, firstRequest, false);
    }

    private ListDirectoryBucketsPublisher(S3AsyncClient client, ListDirectoryBucketsRequest firstRequest, boolean isLastPage) {
        this.client = client;
        this.firstRequest = UserAgentUtils.applyPaginatorUserAgent(firstRequest);
        this.isLastPage = isLastPage;
        this.nextPageFetcher = new ListDirectoryBucketsResponseFetcher();
    }

    @Override
    public void subscribe(Subscriber<? super ListDirectoryBucketsResponse> subscriber) {
        subscriber.onSubscribe(ResponsesSubscription.builder().subscriber(subscriber).nextPageFetcher(nextPageFetcher).build());
    }

    /**
     * Returns a publisher that can be used to get a stream of data. You need to subscribe to the publisher to request
     * the stream of data. The publisher has a helper forEach method that takes in a {@link java.util.function.Consumer}
     * and then applies that consumer to each response returned by the service.
     */
    public final SdkPublisher<Bucket> buckets() {
        Function<ListDirectoryBucketsResponse, Iterator<Bucket>> getIterator = response -> {
            if (response != null && response.buckets() != null) {
                return response.buckets().iterator();
            }
            return Collections.emptyIterator();
        };
        return PaginatedItemsPublisher.builder().nextPageFetcher(new ListDirectoryBucketsResponseFetcher())
                .iteratorFunction(getIterator).isLastPage(isLastPage).build();
    }

    private class ListDirectoryBucketsResponseFetcher implements AsyncPageFetcher<ListDirectoryBucketsResponse> {
        @Override
        public boolean hasNextPage(final ListDirectoryBucketsResponse previousPage) {
            return PaginatorUtils.isOutputTokenAvailable(previousPage.continuationToken());
        }

        @Override
        public CompletableFuture<ListDirectoryBucketsResponse> nextPage(final ListDirectoryBucketsResponse previousPage) {
            if (previousPage == null) {
                return client.listDirectoryBuckets(firstRequest);
            }
            return client.listDirectoryBuckets(firstRequest.toBuilder().continuationToken(previousPage.continuationToken())
                    .build());
        }
    }
}
