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
public final class ListAliasesResponse extends KmsResponse implements
        ToCopyableBuilder<ListAliasesResponse.Builder, ListAliasesResponse> {
    private static final SdkField<List<AliasListEntry>> ALIASES_FIELD = SdkField
            .<List<AliasListEntry>> builder(MarshallingType.LIST)
            .memberName("Aliases")
            .getter(getter(ListAliasesResponse::aliases))
            .setter(setter(Builder::aliases))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("Aliases").build(),
                    ListTrait
                            .builder()
                            .memberLocationName(null)
                            .memberFieldInfo(
                                    SdkField.<AliasListEntry> builder(MarshallingType.SDK_POJO)
                                            .constructor(AliasListEntry::builder)
                                            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD)
                                                    .locationName("member").build()).build()).build()).build();

    private static final SdkField<String> NEXT_MARKER_FIELD = SdkField.<String> builder(MarshallingType.STRING)
            .memberName("NextMarker").getter(getter(ListAliasesResponse::nextMarker)).setter(setter(Builder::nextMarker))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("NextMarker").build()).build();

    private static final SdkField<Boolean> TRUNCATED_FIELD = SdkField.<Boolean> builder(MarshallingType.BOOLEAN)
            .memberName("Truncated").getter(getter(ListAliasesResponse::truncated)).setter(setter(Builder::truncated))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("Truncated").build()).build();

    private static final List<SdkField<?>> SDK_FIELDS = Collections.unmodifiableList(Arrays.asList(ALIASES_FIELD,
            NEXT_MARKER_FIELD, TRUNCATED_FIELD));

    private static final Map<String, SdkField<?>> SDK_NAME_TO_FIELD = memberNameToFieldInitializer();

    private final List<AliasListEntry> aliases;

    private final String nextMarker;

    private final Boolean truncated;

    private ListAliasesResponse(BuilderImpl builder) {
        super(builder);
        this.aliases = builder.aliases;
        this.nextMarker = builder.nextMarker;
        this.truncated = builder.truncated;
    }

    /**
     * For responses, this returns true if the service returned a value for the Aliases property. This DOES NOT check
     * that the value is non-empty (for which, you should check the {@code isEmpty()} method on the property). This is
     * useful because the SDK will never return a null collection or map, but you may need to differentiate between the
     * service returning nothing (or null) and the service returning an empty collection or map. For requests, this
     * returns true if a value for the property was specified in the request builder, and false if a value was not
     * specified.
     */
    public final boolean hasAliases() {
        return aliases != null && !(aliases instanceof SdkAutoConstructList);
    }

    /**
     * <p>
     * A list of aliases.
     * </p>
     * <p>
     * Attempts to modify the collection returned by this method will result in an UnsupportedOperationException.
     * </p>
     * <p>
     * This method will never return null. If you would like to know whether the service returned this field (so that
     * you can differentiate between null and empty), you can use the {@link #hasAliases} method.
     * </p>
     * 
     * @return A list of aliases.
     */
    public final List<AliasListEntry> aliases() {
        return aliases;
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
        hashCode = 31 * hashCode + Objects.hashCode(hasAliases() ? aliases() : null);
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
        if (!(obj instanceof ListAliasesResponse)) {
            return false;
        }
        ListAliasesResponse other = (ListAliasesResponse) obj;
        return hasAliases() == other.hasAliases() && Objects.equals(aliases(), other.aliases())
                && Objects.equals(nextMarker(), other.nextMarker()) && Objects.equals(truncated(), other.truncated());
    }

    /**
     * Returns a string representation of this object. This is useful for testing and debugging. Sensitive data will be
     * redacted from this string using a placeholder value.
     */
    @Override
    public final String toString() {
        return ToString.builder("ListAliasesResponse").add("Aliases", hasAliases() ? aliases() : null)
                .add("NextMarker", nextMarker()).add("Truncated", truncated()).build();
    }

    public final <T> Optional<T> getValueForField(String fieldName, Class<T> clazz) {
        switch (fieldName) {
        case "Aliases":
            return Optional.ofNullable(clazz.cast(aliases()));
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
        map.put("Aliases", ALIASES_FIELD);
        map.put("NextMarker", NEXT_MARKER_FIELD);
        map.put("Truncated", TRUNCATED_FIELD);
        return Collections.unmodifiableMap(map);
    }

    private static <T> Function<Object, T> getter(Function<ListAliasesResponse, T> g) {
        return obj -> g.apply((ListAliasesResponse) obj);
    }

    private static <T> BiConsumer<Object, T> setter(BiConsumer<Builder, T> s) {
        return (obj, val) -> s.accept((Builder) obj, val);
    }

    @Mutable
    @NotThreadSafe
    public interface Builder extends KmsResponse.Builder, SdkPojo, CopyableBuilder<Builder, ListAliasesResponse> {
        /**
         * <p>
         * A list of aliases.
         * </p>
         * 
         * @param aliases
         *        A list of aliases.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder aliases(Collection<AliasListEntry> aliases);

        /**
         * <p>
         * A list of aliases.
         * </p>
         * 
         * @param aliases
         *        A list of aliases.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder aliases(AliasListEntry... aliases);

        /**
         * <p>
         * A list of aliases.
         * </p>
         * This is a convenience method that creates an instance of the
         * {@link com.ibm.cos.v2.services.kms.model.AliasListEntry.Builder} avoiding the need to create one
         * manually via {@link com.ibm.cos.v2.services.kms.model.AliasListEntry#builder()}.
         *
         * <p>
         * When the {@link Consumer} completes,
         * {@link com.ibm.cos.v2.services.kms.model.AliasListEntry.Builder#build()} is called immediately and
         * its result is passed to {@link #aliases(List<AliasListEntry>)}.
         * 
         * @param aliases
         *        a consumer that will call methods on
         *        {@link com.ibm.cos.v2.services.kms.model.AliasListEntry.Builder}
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see #aliases(java.util.Collection<AliasListEntry>)
         */
        Builder aliases(Consumer<AliasListEntry.Builder>... aliases);

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
        private List<AliasListEntry> aliases = DefaultSdkAutoConstructList.getInstance();

        private String nextMarker;

        private Boolean truncated;

        private BuilderImpl() {
        }

        private BuilderImpl(ListAliasesResponse model) {
            super(model);
            aliases(model.aliases);
            nextMarker(model.nextMarker);
            truncated(model.truncated);
        }

        public final List<AliasListEntry.Builder> getAliases() {
            List<AliasListEntry.Builder> result = AliasListCopier.copyToBuilder(this.aliases);
            if (result instanceof SdkAutoConstructList) {
                return null;
            }
            return result;
        }

        public final void setAliases(Collection<AliasListEntry.BuilderImpl> aliases) {
            this.aliases = AliasListCopier.copyFromBuilder(aliases);
        }

        @Override
        public final Builder aliases(Collection<AliasListEntry> aliases) {
            this.aliases = AliasListCopier.copy(aliases);
            return this;
        }

        @Override
        @SafeVarargs
        public final Builder aliases(AliasListEntry... aliases) {
            aliases(Arrays.asList(aliases));
            return this;
        }

        @Override
        @SafeVarargs
        public final Builder aliases(Consumer<AliasListEntry.Builder>... aliases) {
            aliases(Stream.of(aliases).map(c -> AliasListEntry.builder().applyMutation(c).build()).collect(Collectors.toList()));
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
        public ListAliasesResponse build() {
            return new ListAliasesResponse(this);
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
