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

package com.ibm.cos.v2.services.kms.model;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import com.ibm.cos.v2.annotations.Generated;
import com.ibm.cos.v2.annotations.Mutable;
import com.ibm.cos.v2.annotations.NotThreadSafe;
import com.ibm.cos.v2.core.SdkField;
import com.ibm.cos.v2.core.SdkPojo;
import com.ibm.cos.v2.core.protocol.MarshallLocation;
import com.ibm.cos.v2.core.protocol.MarshallingType;
import com.ibm.cos.v2.core.traits.ListTrait;
import com.ibm.cos.v2.core.traits.LocationTrait;
import com.ibm.cos.v2.core.util.DefaultSdkAutoConstructList;
import com.ibm.cos.v2.core.util.SdkAutoConstructList;
import com.ibm.cos.v2.utils.ToString;
import com.ibm.cos.v2.utils.builder.CopyableBuilder;
import com.ibm.cos.v2.utils.builder.ToCopyableBuilder;

/**
 */
@Generated("com.ibm.cos.v2:codegen")
public final class ListGrantsResponse extends KmsResponse implements
        ToCopyableBuilder<ListGrantsResponse.Builder, ListGrantsResponse> {
    private static final SdkField<List<GrantListEntry>> GRANTS_FIELD = SdkField
            .<List<GrantListEntry>> builder(MarshallingType.LIST)
            .memberName("Grants")
            .getter(getter(ListGrantsResponse::grants))
            .setter(setter(Builder::grants))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("Grants").build(),
                    ListTrait
                            .builder()
                            .memberLocationName(null)
                            .memberFieldInfo(
                                    SdkField.<GrantListEntry> builder(MarshallingType.SDK_POJO)
                                            .constructor(GrantListEntry::builder)
                                            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD)
                                                    .locationName("member").build()).build()).build()).build();

    private static final SdkField<String> NEXT_MARKER_FIELD = SdkField.<String> builder(MarshallingType.STRING)
            .memberName("NextMarker").getter(getter(ListGrantsResponse::nextMarker)).setter(setter(Builder::nextMarker))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("NextMarker").build()).build();

    private static final SdkField<Boolean> TRUNCATED_FIELD = SdkField.<Boolean> builder(MarshallingType.BOOLEAN)
            .memberName("Truncated").getter(getter(ListGrantsResponse::truncated)).setter(setter(Builder::truncated))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("Truncated").build()).build();

    private static final List<SdkField<?>> SDK_FIELDS = Collections.unmodifiableList(Arrays.asList(GRANTS_FIELD,
            NEXT_MARKER_FIELD, TRUNCATED_FIELD));

    private static final Map<String, SdkField<?>> SDK_NAME_TO_FIELD = memberNameToFieldInitializer();

    private final List<GrantListEntry> grants;

    private final String nextMarker;

    private final Boolean truncated;

    private ListGrantsResponse(BuilderImpl builder) {
        super(builder);
        this.grants = builder.grants;
        this.nextMarker = builder.nextMarker;
        this.truncated = builder.truncated;
    }

    /**
     * For responses, this returns true if the service returned a value for the Grants property. This DOES NOT check
     * that the value is non-empty (for which, you should check the {@code isEmpty()} method on the property). This is
     * useful because the SDK will never return a null collection or map, but you may need to differentiate between the
     * service returning nothing (or null) and the service returning an empty collection or map. For requests, this
     * returns true if a value for the property was specified in the request builder, and false if a value was not
     * specified.
     */
    public final boolean hasGrants() {
        return grants != null && !(grants instanceof SdkAutoConstructList);
    }

    /**
     * <p>
     * A list of grants.
     * </p>
     * <p>
     * Attempts to modify the collection returned by this method will result in an UnsupportedOperationException.
     * </p>
     * <p>
     * This method will never return null. If you would like to know whether the service returned this field (so that
     * you can differentiate between null and empty), you can use the {@link #hasGrants} method.
     * </p>
     * 
     * @return A list of grants.
     */
    public final List<GrantListEntry> grants() {
        return grants;
    }

    /**
     * <p>
     * When <code>Truncated</code> is true, this element is present and contains the value to use for the
     * <code>Marker</code> parameter in a subsequent request.
     * </p>
     * 
     * @return When <code>Truncated</code> is true, this element is present and contains the value to use for the
     *         <code>Marker</code> parameter in a subsequent request.
     */
    public final String nextMarker() {
        return nextMarker;
    }

    /**
     * <p>
     * A flag that indicates whether there are more items in the list. When this value is true, the list in this
     * response is truncated. To get more items, pass the value of the <code>NextMarker</code> element in this response
     * to the <code>Marker</code> parameter in a subsequent request.
     * </p>
     * 
     * @return A flag that indicates whether there are more items in the list. When this value is true, the list in this
     *         response is truncated. To get more items, pass the value of the <code>NextMarker</code> element in this
     *         response to the <code>Marker</code> parameter in a subsequent request.
     */
    public final Boolean truncated() {
        return truncated;
    }

    @Override
    public Builder toBuilder() {
        return new BuilderImpl(this);
    }

    public static Builder builder() {
        return new BuilderImpl();
    }

    public static Class<? extends Builder> serializableBuilderClass() {
        return BuilderImpl.class;
    }

    @Override
    public final int hashCode() {
        int hashCode = 1;
        hashCode = 31 * hashCode + super.hashCode();
        hashCode = 31 * hashCode + Objects.hashCode(hasGrants() ? grants() : null);
        hashCode = 31 * hashCode + Objects.hashCode(nextMarker());
        hashCode = 31 * hashCode + Objects.hashCode(truncated());
        return hashCode;
    }

    @Override
    public final boolean equals(Object obj) {
        return super.equals(obj) && equalsBySdkFields(obj);
    }

    @Override
    public final boolean equalsBySdkFields(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof ListGrantsResponse)) {
            return false;
        }
        ListGrantsResponse other = (ListGrantsResponse) obj;
        return hasGrants() == other.hasGrants() && Objects.equals(grants(), other.grants())
                && Objects.equals(nextMarker(), other.nextMarker()) && Objects.equals(truncated(), other.truncated());
    }

    /**
     * Returns a string representation of this object. This is useful for testing and debugging. Sensitive data will be
     * redacted from this string using a placeholder value.
     */
    @Override
    public final String toString() {
        return ToString.builder("ListGrantsResponse").add("Grants", hasGrants() ? grants() : null)
                .add("NextMarker", nextMarker()).add("Truncated", truncated()).build();
    }

    public final <T> Optional<T> getValueForField(String fieldName, Class<T> clazz) {
        switch (fieldName) {
        case "Grants":
            return Optional.ofNullable(clazz.cast(grants()));
        case "NextMarker":
            return Optional.ofNullable(clazz.cast(nextMarker()));
        case "Truncated":
            return Optional.ofNullable(clazz.cast(truncated()));
        default:
            return Optional.empty();
        }
    }

    @Override
    public final List<SdkField<?>> sdkFields() {
        return SDK_FIELDS;
    }

    @Override
    public final Map<String, SdkField<?>> sdkFieldNameToField() {
        return SDK_NAME_TO_FIELD;
    }

    private static Map<String, SdkField<?>> memberNameToFieldInitializer() {
        Map<String, SdkField<?>> map = new HashMap<>();
        map.put("Grants", GRANTS_FIELD);
        map.put("NextMarker", NEXT_MARKER_FIELD);
        map.put("Truncated", TRUNCATED_FIELD);
        return Collections.unmodifiableMap(map);
    }

    private static <T> Function<Object, T> getter(Function<ListGrantsResponse, T> g) {
        return obj -> g.apply((ListGrantsResponse) obj);
    }

    private static <T> BiConsumer<Object, T> setter(BiConsumer<Builder, T> s) {
        return (obj, val) -> s.accept((Builder) obj, val);
    }

    @Mutable
    @NotThreadSafe
    public interface Builder extends KmsResponse.Builder, SdkPojo, CopyableBuilder<Builder, ListGrantsResponse> {
        /**
         * <p>
         * A list of grants.
         * </p>
         * 
         * @param grants
         *        A list of grants.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder grants(Collection<GrantListEntry> grants);

        /**
         * <p>
         * A list of grants.
         * </p>
         * 
         * @param grants
         *        A list of grants.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder grants(GrantListEntry... grants);

        /**
         * <p>
         * A list of grants.
         * </p>
         * This is a convenience method that creates an instance of the
         * {@link com.ibm.cos.v2.services.kms.model.GrantListEntry.Builder} avoiding the need to create one
         * manually via {@link com.ibm.cos.v2.services.kms.model.GrantListEntry#builder()}.
         *
         * <p>
         * When the {@link Consumer} completes,
         * {@link com.ibm.cos.v2.services.kms.model.GrantListEntry.Builder#build()} is called immediately and
         * its result is passed to {@link #grants(List<GrantListEntry>)}.
         * 
         * @param grants
         *        a consumer that will call methods on
         *        {@link com.ibm.cos.v2.services.kms.model.GrantListEntry.Builder}
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see #grants(java.util.Collection<GrantListEntry>)
         */
        Builder grants(Consumer<GrantListEntry.Builder>... grants);

        /**
         * <p>
         * When <code>Truncated</code> is true, this element is present and contains the value to use for the
         * <code>Marker</code> parameter in a subsequent request.
         * </p>
         * 
         * @param nextMarker
         *        When <code>Truncated</code> is true, this element is present and contains the value to use for the
         *        <code>Marker</code> parameter in a subsequent request.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder nextMarker(String nextMarker);

        /**
         * <p>
         * A flag that indicates whether there are more items in the list. When this value is true, the list in this
         * response is truncated. To get more items, pass the value of the <code>NextMarker</code> element in this
         * response to the <code>Marker</code> parameter in a subsequent request.
         * </p>
         * 
         * @param truncated
         *        A flag that indicates whether there are more items in the list. When this value is true, the list in
         *        this response is truncated. To get more items, pass the value of the <code>NextMarker</code> element
         *        in this response to the <code>Marker</code> parameter in a subsequent request.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder truncated(Boolean truncated);
    }

    static final class BuilderImpl extends KmsResponse.BuilderImpl implements Builder {
        private List<GrantListEntry> grants = DefaultSdkAutoConstructList.getInstance();

        private String nextMarker;

        private Boolean truncated;

        private BuilderImpl() {
        }

        private BuilderImpl(ListGrantsResponse model) {
            super(model);
            grants(model.grants);
            nextMarker(model.nextMarker);
            truncated(model.truncated);
        }

        public final List<GrantListEntry.Builder> getGrants() {
            List<GrantListEntry.Builder> result = GrantListCopier.copyToBuilder(this.grants);
            if (result instanceof SdkAutoConstructList) {
                return null;
            }
            return result;
        }

        public final void setGrants(Collection<GrantListEntry.BuilderImpl> grants) {
            this.grants = GrantListCopier.copyFromBuilder(grants);
        }

        @Override
        public final Builder grants(Collection<GrantListEntry> grants) {
            this.grants = GrantListCopier.copy(grants);
            return this;
        }

        @Override
        @SafeVarargs
        public final Builder grants(GrantListEntry... grants) {
            grants(Arrays.asList(grants));
            return this;
        }

        @Override
        @SafeVarargs
        public final Builder grants(Consumer<GrantListEntry.Builder>... grants) {
            grants(Stream.of(grants).map(c -> GrantListEntry.builder().applyMutation(c).build()).collect(Collectors.toList()));
            return this;
        }

        public final String getNextMarker() {
            return nextMarker;
        }

        public final void setNextMarker(String nextMarker) {
            this.nextMarker = nextMarker;
        }

        @Override
        public final Builder nextMarker(String nextMarker) {
            this.nextMarker = nextMarker;
            return this;
        }

        public final Boolean getTruncated() {
            return truncated;
        }

        public final void setTruncated(Boolean truncated) {
            this.truncated = truncated;
        }

        @Override
        public final Builder truncated(Boolean truncated) {
            this.truncated = truncated;
            return this;
        }

        @Override
        public ListGrantsResponse build() {
            return new ListGrantsResponse(this);
        }

        @Override
        public List<SdkField<?>> sdkFields() {
            return SDK_FIELDS;
        }

        @Override
        public Map<String, SdkField<?>> sdkFieldNameToField() {
            return SDK_NAME_TO_FIELD;
        }
    }
}
