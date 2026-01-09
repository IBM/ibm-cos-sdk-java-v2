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

package com.ibm.cos.v2.services.kms.paginators;

import java.util.Collections;
import java.util.Iterator;
import java.util.function.Function;
import com.ibm.cos.v2.annotations.Generated;
import com.ibm.cos.v2.core.pagination.sync.PaginatedItemsIterable;
import com.ibm.cos.v2.core.pagination.sync.PaginatedResponsesIterator;
import com.ibm.cos.v2.core.pagination.sync.SdkIterable;
import com.ibm.cos.v2.core.pagination.sync.SyncPageFetcher;
import com.ibm.cos.v2.services.kms.KmsClient;
import com.ibm.cos.v2.services.kms.internal.UserAgentUtils;
import com.ibm.cos.v2.services.kms.model.AliasListEntry;
import com.ibm.cos.v2.services.kms.model.ListAliasesRequest;
import com.ibm.cos.v2.services.kms.model.ListAliasesResponse;

/**
 * <p>
 * Represents the output for the
 * {@link com.ibm.cos.v2.services.kms.KmsClient#listAliasesPaginator(com.ibm.cos.v2.services.kms.model.ListAliasesRequest)}
 * operation which is a paginated operation. This class is an iterable of
 * {@link com.ibm.cos.v2.services.kms.model.ListAliasesResponse} that can be used to iterate through all the
 * response pages of the operation.
 * </p>
 * <p>
 * When the operation is called, an instance of this class is returned. At this point, no service calls are made yet and
 * so there is no guarantee that the request is valid. As you iterate through the iterable, SDK will start lazily
 * loading response pages by making service calls until there are no pages left or your iteration stops. If there are
 * errors in your request, you will see the failures only after you start iterating through the iterable.
 * </p>
 *
 * <p>
 * The following are few ways to iterate through the response pages:
 * </p>
 * 1) Using a Stream
 * 
 * <pre>
 * {@code
 * com.ibm.cos.v2.services.kms.paginators.ListAliasesIterable responses = client.listAliasesPaginator(request);
 * responses.stream().forEach(....);
 * }
 * </pre>
 *
 * 2) Using For loop
 * 
 * <pre>
 * {
 *     &#064;code
 *     com.ibm.cos.v2.services.kms.paginators.ListAliasesIterable responses = client.listAliasesPaginator(request);
 *     for (com.ibm.cos.v2.services.kms.model.ListAliasesResponse response : responses) {
 *         // do something;
 *     }
 * }
 * </pre>
 *
 * 3) Use iterator directly
 * 
 * <pre>
 * {@code
 * com.ibm.cos.v2.services.kms.paginators.ListAliasesIterable responses = client.listAliasesPaginator(request);
 * responses.iterator().forEachRemaining(....);
 * }
 * </pre>
 * <p>
 * <b>Please notice that the configuration of Limit won't limit the number of results you get with the paginator. It
 * only limits the number of results in each page.</b>
 * </p>
 * <p>
 * <b>Note: If you prefer to have control on service calls, use the
 * {@link #listAliases(com.ibm.cos.v2.services.kms.model.ListAliasesRequest)} operation.</b>
 * </p>
 */
@Generated("com.ibm.cos.v2:codegen")
public class ListAliasesIterable implements SdkIterable<ListAliasesResponse> {
    private final KmsClient client;

    private final ListAliasesRequest firstRequest;

    private final SyncPageFetcher nextPageFetcher;

    public ListAliasesIterable(KmsClient client, ListAliasesRequest firstRequest) {
        this.client = client;
        this.firstRequest = UserAgentUtils.applyPaginatorUserAgent(firstRequest);
        this.nextPageFetcher = new ListAliasesResponseFetcher();
    }

    @Override
    public Iterator<ListAliasesResponse> iterator() {
        return PaginatedResponsesIterator.builder().nextPageFetcher(nextPageFetcher).build();
    }

    /**
     * Returns an iterable to iterate through the paginated {@link ListAliasesResponse#aliases()} member. The returned
     * iterable is used to iterate through the results across all response pages and not a single page.
     *
     * This method is useful if you are interested in iterating over the paginated member in the response pages instead
     * of the top level pages. Similar to iteration over pages, this method internally makes service calls to get the
     * next list of results until the iteration stops or there are no more results.
     */
    public final SdkIterable<AliasListEntry> aliases() {
        Function<ListAliasesResponse, Iterator<AliasListEntry>> getIterator = response -> {
            if (response != null && response.aliases() != null) {
                return response.aliases().iterator();
            }
            return Collections.emptyIterator();
        };
        return PaginatedItemsIterable.<ListAliasesResponse, AliasListEntry> builder().pagesIterable(this)
                .itemIteratorFunction(getIterator).build();
    }

    private class ListAliasesResponseFetcher implements SyncPageFetcher<ListAliasesResponse> {
        @Override
        public boolean hasNextPage(ListAliasesResponse previousPage) {
            return previousPage.truncated() != null && previousPage.truncated().booleanValue();
        }

        @Override
        public ListAliasesResponse nextPage(ListAliasesResponse previousPage) {
            if (previousPage == null) {
                return client.listAliases(firstRequest);
            }
            return client.listAliases(firstRequest.toBuilder().marker(previousPage.nextMarker()).build());
        }
    }
}
