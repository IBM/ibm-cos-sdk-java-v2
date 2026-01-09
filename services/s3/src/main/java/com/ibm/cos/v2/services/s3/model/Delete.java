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

package com.ibm.cos.v2.services.s3.model;

import java.io.Serializable;
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
import com.ibm.cos.v2.core.traits.RequiredTrait;
import com.ibm.cos.v2.core.util.DefaultSdkAutoConstructList;
import com.ibm.cos.v2.core.util.SdkAutoConstructList;
import com.ibm.cos.v2.utils.ToString;
import com.ibm.cos.v2.utils.builder.CopyableBuilder;
import com.ibm.cos.v2.utils.builder.ToCopyableBuilder;

/**
 * <p>
 * Container for the objects to delete.
 * </p>
 */
@Generated("com.ibm.cos.v2:codegen")
public final class Delete implements SdkPojo, Serializable, ToCopyableBuilder<Delete.Builder, Delete> {
    private static final SdkField<List<ObjectIdentifier>> OBJECTS_FIELD = SdkField
            .<List<ObjectIdentifier>> builder(MarshallingType.LIST)
            .memberName("Objects")
            .getter(getter(Delete::objects))
            .setter(setter(Builder::objects))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("Object")
                    .unmarshallLocationName("Object").build(),
                    ListTrait
                            .builder()
                            .memberLocationName(null)
                            .memberFieldInfo(
                                    SdkField.<ObjectIdentifier> builder(MarshallingType.SDK_POJO)
                                            .constructor(ObjectIdentifier::builder)
                                            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD)
                                                    .locationName("member").unmarshallLocationName("member").build()).build())
                            .isFlattened(true).build(), RequiredTrait.create()).build();

    private static final SdkField<Boolean> QUIET_FIELD = SdkField
            .<Boolean> builder(MarshallingType.BOOLEAN)
            .memberName("Quiet")
            .getter(getter(Delete::quiet))
            .setter(setter(Builder::quiet))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("Quiet")
                    .unmarshallLocationName("Quiet").build()).build();

    private static final List<SdkField<?>> SDK_FIELDS = Collections.unmodifiableList(Arrays.asList(OBJECTS_FIELD, QUIET_FIELD));

    private static final Map<String, SdkField<?>> SDK_NAME_TO_FIELD = memberNameToFieldInitializer();

    private static final long serialVersionUID = 1L;

    private final List<ObjectIdentifier> objects;

    private final Boolean quiet;

    private Delete(BuilderImpl builder) {
        this.objects = builder.objects;
        this.quiet = builder.quiet;
    }

    /**
     * For responses, this returns true if the service returned a value for the Objects property. This DOES NOT check
     * that the value is non-empty (for which, you should check the {@code isEmpty()} method on the property). This is
     * useful because the SDK will never return a null collection or map, but you may need to differentiate between the
     * service returning nothing (or null) and the service returning an empty collection or map. For requests, this
     * returns true if a value for the property was specified in the request builder, and false if a value was not
     * specified.
     */
    public final boolean hasObjects() {
        return objects != null && !(objects instanceof SdkAutoConstructList);
    }

    /**
     * <p>
     * The object to delete.
     * </p>
     * <note>
     * <p>
     * <b>Directory buckets</b> - For directory buckets, an object that's composed entirely of whitespace characters is
     * not supported by the <code>DeleteObjects</code> API operation. The request will receive a
     * <code>400 Bad Request</code> error and none of the objects in the request will be deleted.
     * </p>
     * </note>
     * <p>
     * Attempts to modify the collection returned by this method will result in an UnsupportedOperationException.
     * </p>
     * <p>
     * This method will never return null. If you would like to know whether the service returned this field (so that
     * you can differentiate between null and empty), you can use the {@link #hasObjects} method.
     * </p>
     * 
     * @return The object to delete.</p> <note>
     *         <p>
     *         <b>Directory buckets</b> - For directory buckets, an object that's composed entirely of whitespace
     *         characters is not supported by the <code>DeleteObjects</code> API operation. The request will receive a
     *         <code>400 Bad Request</code> error and none of the objects in the request will be deleted.
     *         </p>
     */
    public final List<ObjectIdentifier> objects() {
        return objects;
    }

    /**
     * <p>
     * Element to enable quiet mode for the request. When you add this element, you must set its value to
     * <code>true</code>.
     * </p>
     * 
     * @return Element to enable quiet mode for the request. When you add this element, you must set its value to
     *         <code>true</code>.
     */
    public final Boolean quiet() {
        return quiet;
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
        hashCode = 31 * hashCode + Objects.hashCode(hasObjects() ? objects() : null);
        hashCode = 31 * hashCode + Objects.hashCode(quiet());
        return hashCode;
    }

    @Override
    public final boolean equals(Object obj) {
        return equalsBySdkFields(obj);
    }

    @Override
    public final boolean equalsBySdkFields(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Delete)) {
            return false;
        }
        Delete other = (Delete) obj;
        return hasObjects() == other.hasObjects() && Objects.equals(objects(), other.objects())
                && Objects.equals(quiet(), other.quiet());
    }

    /**
     * Returns a string representation of this object. This is useful for testing and debugging. Sensitive data will be
     * redacted from this string using a placeholder value.
     */
    @Override
    public final String toString() {
        return ToString.builder("Delete").add("Objects", hasObjects() ? objects() : null).add("Quiet", quiet()).build();
    }

    public final <T> Optional<T> getValueForField(String fieldName, Class<T> clazz) {
        switch (fieldName) {
        case "Objects":
            return Optional.ofNullable(clazz.cast(objects()));
        case "Quiet":
            return Optional.ofNullable(clazz.cast(quiet()));
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
        map.put("Object", OBJECTS_FIELD);
        map.put("Quiet", QUIET_FIELD);
        return Collections.unmodifiableMap(map);
    }

    private static <T> Function<Object, T> getter(Function<Delete, T> g) {
        return obj -> g.apply((Delete) obj);
    }

    private static <T> BiConsumer<Object, T> setter(BiConsumer<Builder, T> s) {
        return (obj, val) -> s.accept((Builder) obj, val);
    }

    @Mutable
    @NotThreadSafe
    public interface Builder extends SdkPojo, CopyableBuilder<Builder, Delete> {
        /**
         * <p>
         * The object to delete.
         * </p>
         * <note>
         * <p>
         * <b>Directory buckets</b> - For directory buckets, an object that's composed entirely of whitespace characters
         * is not supported by the <code>DeleteObjects</code> API operation. The request will receive a
         * <code>400 Bad Request</code> error and none of the objects in the request will be deleted.
         * </p>
         * </note>
         * 
         * @param objects
         *        The object to delete.</p> <note>
         *        <p>
         *        <b>Directory buckets</b> - For directory buckets, an object that's composed entirely of whitespace
         *        characters is not supported by the <code>DeleteObjects</code> API operation. The request will receive
         *        a <code>400 Bad Request</code> error and none of the objects in the request will be deleted.
         *        </p>
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder objects(Collection<ObjectIdentifier> objects);

        /**
         * <p>
         * The object to delete.
         * </p>
         * <note>
         * <p>
         * <b>Directory buckets</b> - For directory buckets, an object that's composed entirely of whitespace characters
         * is not supported by the <code>DeleteObjects</code> API operation. The request will receive a
         * <code>400 Bad Request</code> error and none of the objects in the request will be deleted.
         * </p>
         * </note>
         * 
         * @param objects
         *        The object to delete.</p> <note>
         *        <p>
         *        <b>Directory buckets</b> - For directory buckets, an object that's composed entirely of whitespace
         *        characters is not supported by the <code>DeleteObjects</code> API operation. The request will receive
         *        a <code>400 Bad Request</code> error and none of the objects in the request will be deleted.
         *        </p>
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder objects(ObjectIdentifier... objects);

        /**
         * <p>
         * The object to delete.
         * </p>
         * <note>
         * <p>
         * <b>Directory buckets</b> - For directory buckets, an object that's composed entirely of whitespace characters
         * is not supported by the <code>DeleteObjects</code> API operation. The request will receive a
         * <code>400 Bad Request</code> error and none of the objects in the request will be deleted.
         * </p>
         * </note> This is a convenience method that creates an instance of the
         * {@link com.ibm.cos.v2.services.s3.model.ObjectIdentifier.Builder} avoiding the need to create one
         * manually via {@link com.ibm.cos.v2.services.s3.model.ObjectIdentifier#builder()}.
         *
         * <p>
         * When the {@link Consumer} completes,
         * {@link com.ibm.cos.v2.services.s3.model.ObjectIdentifier.Builder#build()} is called immediately and
         * its result is passed to {@link #objects(List<ObjectIdentifier>)}.
         * 
         * @param objects
         *        a consumer that will call methods on
         *        {@link com.ibm.cos.v2.services.s3.model.ObjectIdentifier.Builder}
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see #objects(java.util.Collection<ObjectIdentifier>)
         */
        Builder objects(Consumer<ObjectIdentifier.Builder>... objects);

        /**
         * <p>
         * Element to enable quiet mode for the request. When you add this element, you must set its value to
         * <code>true</code>.
         * </p>
         * 
         * @param quiet
         *        Element to enable quiet mode for the request. When you add this element, you must set its value to
         *        <code>true</code>.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder quiet(Boolean quiet);
    }

    static final class BuilderImpl implements Builder {
        private List<ObjectIdentifier> objects = DefaultSdkAutoConstructList.getInstance();

        private Boolean quiet;

        private BuilderImpl() {
        }

        private BuilderImpl(Delete model) {
            objects(model.objects);
            quiet(model.quiet);
        }

        public final List<ObjectIdentifier.Builder> getObjects() {
            List<ObjectIdentifier.Builder> result = ObjectIdentifierListCopier.copyToBuilder(this.objects);
            if (result instanceof SdkAutoConstructList) {
                return null;
            }
            return result;
        }

        public final void setObjects(Collection<ObjectIdentifier.BuilderImpl> objects) {
            this.objects = ObjectIdentifierListCopier.copyFromBuilder(objects);
        }

        @Override
        public final Builder objects(Collection<ObjectIdentifier> objects) {
            this.objects = ObjectIdentifierListCopier.copy(objects);
            return this;
        }

        @Override
        @SafeVarargs
        public final Builder objects(ObjectIdentifier... objects) {
            objects(Arrays.asList(objects));
            return this;
        }

        @Override
        @SafeVarargs
        public final Builder objects(Consumer<ObjectIdentifier.Builder>... objects) {
            objects(Stream.of(objects).map(c -> ObjectIdentifier.builder().applyMutation(c).build()).collect(Collectors.toList()));
            return this;
        }

        public final Boolean getQuiet() {
            return quiet;
        }

        public final void setQuiet(Boolean quiet) {
            this.quiet = quiet;
        }

        @Override
        public final Builder quiet(Boolean quiet) {
            this.quiet = quiet;
            return this;
        }

        @Override
        public Delete build() {
            return new Delete(this);
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
