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
public final class ReplicateKeyResponse extends KmsResponse implements
        ToCopyableBuilder<ReplicateKeyResponse.Builder, ReplicateKeyResponse> {
    private static final SdkField<KeyMetadata> REPLICA_KEY_METADATA_FIELD = SdkField
            .<KeyMetadata> builder(MarshallingType.SDK_POJO).memberName("ReplicaKeyMetadata")
            .getter(getter(ReplicateKeyResponse::replicaKeyMetadata)).setter(setter(Builder::replicaKeyMetadata))
            .constructor(KeyMetadata::builder)
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("ReplicaKeyMetadata").build())
            .build();

    private static final SdkField<String> REPLICA_POLICY_FIELD = SdkField.<String> builder(MarshallingType.STRING)
            .memberName("ReplicaPolicy").getter(getter(ReplicateKeyResponse::replicaPolicy))
            .setter(setter(Builder::replicaPolicy))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("ReplicaPolicy").build()).build();

    private static final SdkField<List<Tag>> REPLICA_TAGS_FIELD = SdkField
            .<List<Tag>> builder(MarshallingType.LIST)
            .memberName("ReplicaTags")
            .getter(getter(ReplicateKeyResponse::replicaTags))
            .setter(setter(Builder::replicaTags))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("ReplicaTags").build(),
                    ListTrait
                            .builder()
                            .memberLocationName(null)
                            .memberFieldInfo(
                                    SdkField.<Tag> builder(MarshallingType.SDK_POJO)
                                            .constructor(Tag::builder)
                                            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD)
                                                    .locationName("member").build()).build()).build()).build();

    private static final List<SdkField<?>> SDK_FIELDS = Collections.unmodifiableList(Arrays.asList(REPLICA_KEY_METADATA_FIELD,
            REPLICA_POLICY_FIELD, REPLICA_TAGS_FIELD));

    private static final Map<String, SdkField<?>> SDK_NAME_TO_FIELD = memberNameToFieldInitializer();

    private final KeyMetadata replicaKeyMetadata;

    private final String replicaPolicy;

    private final List<Tag> replicaTags;

    private ReplicateKeyResponse(BuilderImpl builder) {
        super(builder);
        this.replicaKeyMetadata = builder.replicaKeyMetadata;
        this.replicaPolicy = builder.replicaPolicy;
        this.replicaTags = builder.replicaTags;
    }

    /**
     * <p>
     * Displays details about the new replica key, including its Amazon Resource Name (<a
     * href="https://docs.aws.amazon.com/kms/latest/developerguide/concepts.html#key-id-key-ARN">key ARN</a>) and <a
     * href="https://docs.aws.amazon.com/kms/latest/developerguide/key-state.html">Key states of KMS keys</a>. It also
     * includes the ARN and Amazon Web Services Region of its primary key and other replica keys.
     * </p>
     * 
     * @return Displays details about the new replica key, including its Amazon Resource Name (<a
     *         href="https://docs.aws.amazon.com/kms/latest/developerguide/concepts.html#key-id-key-ARN">key ARN</a>)
     *         and <a href="https://docs.aws.amazon.com/kms/latest/developerguide/key-state.html">Key states of KMS
     *         keys</a>. It also includes the ARN and Amazon Web Services Region of its primary key and other replica
     *         keys.
     */
    public final KeyMetadata replicaKeyMetadata() {
        return replicaKeyMetadata;
    }

    /**
     * <p>
     * The key policy of the new replica key. The value is a key policy document in JSON format.
     * </p>
     * 
     * @return The key policy of the new replica key. The value is a key policy document in JSON format.
     */
    public final String replicaPolicy() {
        return replicaPolicy;
    }

    /**
     * For responses, this returns true if the service returned a value for the ReplicaTags property. This DOES NOT
     * check that the value is non-empty (for which, you should check the {@code isEmpty()} method on the property).
     * This is useful because the SDK will never return a null collection or map, but you may need to differentiate
     * between the service returning nothing (or null) and the service returning an empty collection or map. For
     * requests, this returns true if a value for the property was specified in the request builder, and false if a
     * value was not specified.
     */
    public final boolean hasReplicaTags() {
        return replicaTags != null && !(replicaTags instanceof SdkAutoConstructList);
    }

    /**
     * <p>
     * The tags on the new replica key. The value is a list of tag key and tag value pairs.
     * </p>
     * <p>
     * Attempts to modify the collection returned by this method will result in an UnsupportedOperationException.
     * </p>
     * <p>
     * This method will never return null. If you would like to know whether the service returned this field (so that
     * you can differentiate between null and empty), you can use the {@link #hasReplicaTags} method.
     * </p>
     * 
     * @return The tags on the new replica key. The value is a list of tag key and tag value pairs.
     */
    public final List<Tag> replicaTags() {
        return replicaTags;
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
        hashCode = 31 * hashCode + Objects.hashCode(replicaKeyMetadata());
        hashCode = 31 * hashCode + Objects.hashCode(replicaPolicy());
        hashCode = 31 * hashCode + Objects.hashCode(hasReplicaTags() ? replicaTags() : null);
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
        if (!(obj instanceof ReplicateKeyResponse)) {
            return false;
        }
        ReplicateKeyResponse other = (ReplicateKeyResponse) obj;
        return Objects.equals(replicaKeyMetadata(), other.replicaKeyMetadata())
                && Objects.equals(replicaPolicy(), other.replicaPolicy()) && hasReplicaTags() == other.hasReplicaTags()
                && Objects.equals(replicaTags(), other.replicaTags());
    }

    /**
     * Returns a string representation of this object. This is useful for testing and debugging. Sensitive data will be
     * redacted from this string using a placeholder value.
     */
    @Override
    public final String toString() {
        return ToString.builder("ReplicateKeyResponse").add("ReplicaKeyMetadata", replicaKeyMetadata())
                .add("ReplicaPolicy", replicaPolicy()).add("ReplicaTags", hasReplicaTags() ? replicaTags() : null).build();
    }

    public final <T> Optional<T> getValueForField(String fieldName, Class<T> clazz) {
        switch (fieldName) {
        case "ReplicaKeyMetadata":
            return Optional.ofNullable(clazz.cast(replicaKeyMetadata()));
        case "ReplicaPolicy":
            return Optional.ofNullable(clazz.cast(replicaPolicy()));
        case "ReplicaTags":
            return Optional.ofNullable(clazz.cast(replicaTags()));
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
        map.put("ReplicaKeyMetadata", REPLICA_KEY_METADATA_FIELD);
        map.put("ReplicaPolicy", REPLICA_POLICY_FIELD);
        map.put("ReplicaTags", REPLICA_TAGS_FIELD);
        return Collections.unmodifiableMap(map);
    }

    private static <T> Function<Object, T> getter(Function<ReplicateKeyResponse, T> g) {
        return obj -> g.apply((ReplicateKeyResponse) obj);
    }

    private static <T> BiConsumer<Object, T> setter(BiConsumer<Builder, T> s) {
        return (obj, val) -> s.accept((Builder) obj, val);
    }

    @Mutable
    @NotThreadSafe
    public interface Builder extends KmsResponse.Builder, SdkPojo, CopyableBuilder<Builder, ReplicateKeyResponse> {
        /**
         * <p>
         * Displays details about the new replica key, including its Amazon Resource Name (<a
         * href="https://docs.aws.amazon.com/kms/latest/developerguide/concepts.html#key-id-key-ARN">key ARN</a>) and <a
         * href="https://docs.aws.amazon.com/kms/latest/developerguide/key-state.html">Key states of KMS keys</a>. It
         * also includes the ARN and Amazon Web Services Region of its primary key and other replica keys.
         * </p>
         * 
         * @param replicaKeyMetadata
         *        Displays details about the new replica key, including its Amazon Resource Name (<a
         *        href="https://docs.aws.amazon.com/kms/latest/developerguide/concepts.html#key-id-key-ARN">key ARN</a>)
         *        and <a href="https://docs.aws.amazon.com/kms/latest/developerguide/key-state.html">Key states of KMS
         *        keys</a>. It also includes the ARN and Amazon Web Services Region of its primary key and other replica
         *        keys.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder replicaKeyMetadata(KeyMetadata replicaKeyMetadata);

        /**
         * <p>
         * Displays details about the new replica key, including its Amazon Resource Name (<a
         * href="https://docs.aws.amazon.com/kms/latest/developerguide/concepts.html#key-id-key-ARN">key ARN</a>) and <a
         * href="https://docs.aws.amazon.com/kms/latest/developerguide/key-state.html">Key states of KMS keys</a>. It
         * also includes the ARN and Amazon Web Services Region of its primary key and other replica keys.
         * </p>
         * This is a convenience method that creates an instance of the {@link KeyMetadata.Builder} avoiding the need to
         * create one manually via {@link KeyMetadata#builder()}.
         *
         * <p>
         * When the {@link Consumer} completes, {@link KeyMetadata.Builder#build()} is called immediately and its result
         * is passed to {@link #replicaKeyMetadata(KeyMetadata)}.
         * 
         * @param replicaKeyMetadata
         *        a consumer that will call methods on {@link KeyMetadata.Builder}
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see #replicaKeyMetadata(KeyMetadata)
         */
        default Builder replicaKeyMetadata(Consumer<KeyMetadata.Builder> replicaKeyMetadata) {
            return replicaKeyMetadata(KeyMetadata.builder().applyMutation(replicaKeyMetadata).build());
        }

        /**
         * <p>
         * The key policy of the new replica key. The value is a key policy document in JSON format.
         * </p>
         * 
         * @param replicaPolicy
         *        The key policy of the new replica key. The value is a key policy document in JSON format.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder replicaPolicy(String replicaPolicy);

        /**
         * <p>
         * The tags on the new replica key. The value is a list of tag key and tag value pairs.
         * </p>
         * 
         * @param replicaTags
         *        The tags on the new replica key. The value is a list of tag key and tag value pairs.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder replicaTags(Collection<Tag> replicaTags);

        /**
         * <p>
         * The tags on the new replica key. The value is a list of tag key and tag value pairs.
         * </p>
         * 
         * @param replicaTags
         *        The tags on the new replica key. The value is a list of tag key and tag value pairs.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder replicaTags(Tag... replicaTags);

        /**
         * <p>
         * The tags on the new replica key. The value is a list of tag key and tag value pairs.
         * </p>
         * This is a convenience method that creates an instance of the
         * {@link com.ibm.cos.v2.services.kms.model.Tag.Builder} avoiding the need to create one manually via
         * {@link com.ibm.cos.v2.services.kms.model.Tag#builder()}.
         *
         * <p>
         * When the {@link Consumer} completes, {@link com.ibm.cos.v2.services.kms.model.Tag.Builder#build()} is
         * called immediately and its result is passed to {@link #replicaTags(List<Tag>)}.
         * 
         * @param replicaTags
         *        a consumer that will call methods on {@link com.ibm.cos.v2.services.kms.model.Tag.Builder}
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see #replicaTags(java.util.Collection<Tag>)
         */
        Builder replicaTags(Consumer<Tag.Builder>... replicaTags);
    }

    static final class BuilderImpl extends KmsResponse.BuilderImpl implements Builder {
        private KeyMetadata replicaKeyMetadata;

        private String replicaPolicy;

        private List<Tag> replicaTags = DefaultSdkAutoConstructList.getInstance();

        private BuilderImpl() {
        }

        private BuilderImpl(ReplicateKeyResponse model) {
            super(model);
            replicaKeyMetadata(model.replicaKeyMetadata);
            replicaPolicy(model.replicaPolicy);
            replicaTags(model.replicaTags);
        }

        public final KeyMetadata.Builder getReplicaKeyMetadata() {
            return replicaKeyMetadata != null ? replicaKeyMetadata.toBuilder() : null;
        }

        public final void setReplicaKeyMetadata(KeyMetadata.BuilderImpl replicaKeyMetadata) {
            this.replicaKeyMetadata = replicaKeyMetadata != null ? replicaKeyMetadata.build() : null;
        }

        @Override
        public final Builder replicaKeyMetadata(KeyMetadata replicaKeyMetadata) {
            this.replicaKeyMetadata = replicaKeyMetadata;
            return this;
        }

        public final String getReplicaPolicy() {
            return replicaPolicy;
        }

        public final void setReplicaPolicy(String replicaPolicy) {
            this.replicaPolicy = replicaPolicy;
        }

        @Override
        public final Builder replicaPolicy(String replicaPolicy) {
            this.replicaPolicy = replicaPolicy;
            return this;
        }

        public final List<Tag.Builder> getReplicaTags() {
            List<Tag.Builder> result = TagListCopier.copyToBuilder(this.replicaTags);
            if (result instanceof SdkAutoConstructList) {
                return null;
            }
            return result;
        }

        public final void setReplicaTags(Collection<Tag.BuilderImpl> replicaTags) {
            this.replicaTags = TagListCopier.copyFromBuilder(replicaTags);
        }

        @Override
        public final Builder replicaTags(Collection<Tag> replicaTags) {
            this.replicaTags = TagListCopier.copy(replicaTags);
            return this;
        }

        @Override
        @SafeVarargs
        public final Builder replicaTags(Tag... replicaTags) {
            replicaTags(Arrays.asList(replicaTags));
            return this;
        }

        @Override
        @SafeVarargs
        public final Builder replicaTags(Consumer<Tag.Builder>... replicaTags) {
            replicaTags(Stream.of(replicaTags).map(c -> Tag.builder().applyMutation(c).build()).collect(Collectors.toList()));
            return this;
        }

        @Override
        public ReplicateKeyResponse build() {
            return new ReplicateKeyResponse(this);
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
