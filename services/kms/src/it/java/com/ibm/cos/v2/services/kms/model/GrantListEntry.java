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

import java.io.Serializable;
import java.time.Instant;
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
 * <p>
 * Contains information about a grant.
 * </p>
 */
@Generated("com.ibm.cos.v2:codegen")
public final class GrantListEntry implements SdkPojo, Serializable, ToCopyableBuilder<GrantListEntry.Builder, GrantListEntry> {
    private static final SdkField<String> KEY_ID_FIELD = SdkField.<String> builder(MarshallingType.STRING).memberName("KeyId")
            .getter(getter(GrantListEntry::keyId)).setter(setter(Builder::keyId))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("KeyId").build()).build();

    private static final SdkField<String> GRANT_ID_FIELD = SdkField.<String> builder(MarshallingType.STRING)
            .memberName("GrantId").getter(getter(GrantListEntry::grantId)).setter(setter(Builder::grantId))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("GrantId").build()).build();

    private static final SdkField<String> NAME_FIELD = SdkField.<String> builder(MarshallingType.STRING).memberName("Name")
            .getter(getter(GrantListEntry::name)).setter(setter(Builder::name))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("Name").build()).build();

    private static final SdkField<Instant> CREATION_DATE_FIELD = SdkField.<Instant> builder(MarshallingType.INSTANT)
            .memberName("CreationDate").getter(getter(GrantListEntry::creationDate)).setter(setter(Builder::creationDate))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("CreationDate").build()).build();

    private static final SdkField<String> GRANTEE_PRINCIPAL_FIELD = SdkField.<String> builder(MarshallingType.STRING)
            .memberName("GranteePrincipal").getter(getter(GrantListEntry::granteePrincipal))
            .setter(setter(Builder::granteePrincipal))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("GranteePrincipal").build()).build();

    private static final SdkField<String> RETIRING_PRINCIPAL_FIELD = SdkField.<String> builder(MarshallingType.STRING)
            .memberName("RetiringPrincipal").getter(getter(GrantListEntry::retiringPrincipal))
            .setter(setter(Builder::retiringPrincipal))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("RetiringPrincipal").build()).build();

    private static final SdkField<String> ISSUING_ACCOUNT_FIELD = SdkField.<String> builder(MarshallingType.STRING)
            .memberName("IssuingAccount").getter(getter(GrantListEntry::issuingAccount)).setter(setter(Builder::issuingAccount))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("IssuingAccount").build()).build();

    private static final SdkField<List<String>> OPERATIONS_FIELD = SdkField
            .<List<String>> builder(MarshallingType.LIST)
            .memberName("Operations")
            .getter(getter(GrantListEntry::operationsAsStrings))
            .setter(setter(Builder::operationsWithStrings))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("Operations").build(),
                    ListTrait
                            .builder()
                            .memberLocationName(null)
                            .memberFieldInfo(
                                    SdkField.<String> builder(MarshallingType.STRING)
                                            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD)
                                                    .locationName("member").build()).build()).build()).build();

    private static final SdkField<GrantConstraints> CONSTRAINTS_FIELD = SdkField
            .<GrantConstraints> builder(MarshallingType.SDK_POJO).memberName("Constraints")
            .getter(getter(GrantListEntry::constraints)).setter(setter(Builder::constraints))
            .constructor(GrantConstraints::builder)
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("Constraints").build()).build();

    private static final List<SdkField<?>> SDK_FIELDS = Collections.unmodifiableList(Arrays.asList(KEY_ID_FIELD, GRANT_ID_FIELD,
            NAME_FIELD, CREATION_DATE_FIELD, GRANTEE_PRINCIPAL_FIELD, RETIRING_PRINCIPAL_FIELD, ISSUING_ACCOUNT_FIELD,
            OPERATIONS_FIELD, CONSTRAINTS_FIELD));

    private static final Map<String, SdkField<?>> SDK_NAME_TO_FIELD = memberNameToFieldInitializer();

    private static final long serialVersionUID = 1L;

    private final String keyId;

    private final String grantId;

    private final String name;

    private final Instant creationDate;

    private final String granteePrincipal;

    private final String retiringPrincipal;

    private final String issuingAccount;

    private final List<String> operations;

    private final GrantConstraints constraints;

    private GrantListEntry(BuilderImpl builder) {
        this.keyId = builder.keyId;
        this.grantId = builder.grantId;
        this.name = builder.name;
        this.creationDate = builder.creationDate;
        this.granteePrincipal = builder.granteePrincipal;
        this.retiringPrincipal = builder.retiringPrincipal;
        this.issuingAccount = builder.issuingAccount;
        this.operations = builder.operations;
        this.constraints = builder.constraints;
    }

    /**
     * <p>
     * The unique identifier for the KMS key to which the grant applies.
     * </p>
     * 
     * @return The unique identifier for the KMS key to which the grant applies.
     */
    public final String keyId() {
        return keyId;
    }

    /**
     * <p>
     * The unique identifier for the grant.
     * </p>
     * 
     * @return The unique identifier for the grant.
     */
    public final String grantId() {
        return grantId;
    }

    /**
     * <p>
     * The friendly name that identifies the grant. If a name was provided in the <a>CreateGrant</a> request, that name
     * is returned. Otherwise this value is null.
     * </p>
     * 
     * @return The friendly name that identifies the grant. If a name was provided in the <a>CreateGrant</a> request,
     *         that name is returned. Otherwise this value is null.
     */
    public final String name() {
        return name;
    }

    /**
     * <p>
     * The date and time when the grant was created.
     * </p>
     * 
     * @return The date and time when the grant was created.
     */
    public final Instant creationDate() {
        return creationDate;
    }

    /**
     * <p>
     * The identity that gets the permissions in the grant.
     * </p>
     * <p>
     * The <code>GranteePrincipal</code> field in the <code>ListGrants</code> response usually contains the user or role
     * designated as the grantee principal in the grant. However, when the grantee principal in the grant is an Amazon
     * Web Services service, the <code>GranteePrincipal</code> field contains the <a href=
     * "https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_policies_elements_principal.html#principal-services"
     * >service principal</a>, which might represent several different grantee principals.
     * </p>
     * 
     * @return The identity that gets the permissions in the grant.</p>
     *         <p>
     *         The <code>GranteePrincipal</code> field in the <code>ListGrants</code> response usually contains the user
     *         or role designated as the grantee principal in the grant. However, when the grantee principal in the
     *         grant is an Amazon Web Services service, the <code>GranteePrincipal</code> field contains the <a href=
     *         "https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_policies_elements_principal.html#principal-services"
     *         >service principal</a>, which might represent several different grantee principals.
     */
    public final String granteePrincipal() {
        return granteePrincipal;
    }

    /**
     * <p>
     * The principal that can retire the grant.
     * </p>
     * 
     * @return The principal that can retire the grant.
     */
    public final String retiringPrincipal() {
        return retiringPrincipal;
    }

    /**
     * <p>
     * The Amazon Web Services account under which the grant was issued.
     * </p>
     * 
     * @return The Amazon Web Services account under which the grant was issued.
     */
    public final String issuingAccount() {
        return issuingAccount;
    }

    /**
     * <p>
     * The list of operations permitted by the grant.
     * </p>
     * <p>
     * Attempts to modify the collection returned by this method will result in an UnsupportedOperationException.
     * </p>
     * <p>
     * This method will never return null. If you would like to know whether the service returned this field (so that
     * you can differentiate between null and empty), you can use the {@link #hasOperations} method.
     * </p>
     * 
     * @return The list of operations permitted by the grant.
     */
    public final List<GrantOperation> operations() {
        return GrantOperationListCopier.copyStringToEnum(operations);
    }

    /**
     * For responses, this returns true if the service returned a value for the Operations property. This DOES NOT check
     * that the value is non-empty (for which, you should check the {@code isEmpty()} method on the property). This is
     * useful because the SDK will never return a null collection or map, but you may need to differentiate between the
     * service returning nothing (or null) and the service returning an empty collection or map. For requests, this
     * returns true if a value for the property was specified in the request builder, and false if a value was not
     * specified.
     */
    public final boolean hasOperations() {
        return operations != null && !(operations instanceof SdkAutoConstructList);
    }

    /**
     * <p>
     * The list of operations permitted by the grant.
     * </p>
     * <p>
     * Attempts to modify the collection returned by this method will result in an UnsupportedOperationException.
     * </p>
     * <p>
     * This method will never return null. If you would like to know whether the service returned this field (so that
     * you can differentiate between null and empty), you can use the {@link #hasOperations} method.
     * </p>
     * 
     * @return The list of operations permitted by the grant.
     */
    public final List<String> operationsAsStrings() {
        return operations;
    }

    /**
     * <p>
     * A list of key-value pairs that must be present in the encryption context of certain subsequent operations that
     * the grant allows.
     * </p>
     * 
     * @return A list of key-value pairs that must be present in the encryption context of certain subsequent operations
     *         that the grant allows.
     */
    public final GrantConstraints constraints() {
        return constraints;
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
        hashCode = 31 * hashCode + Objects.hashCode(keyId());
        hashCode = 31 * hashCode + Objects.hashCode(grantId());
        hashCode = 31 * hashCode + Objects.hashCode(name());
        hashCode = 31 * hashCode + Objects.hashCode(creationDate());
        hashCode = 31 * hashCode + Objects.hashCode(granteePrincipal());
        hashCode = 31 * hashCode + Objects.hashCode(retiringPrincipal());
        hashCode = 31 * hashCode + Objects.hashCode(issuingAccount());
        hashCode = 31 * hashCode + Objects.hashCode(hasOperations() ? operationsAsStrings() : null);
        hashCode = 31 * hashCode + Objects.hashCode(constraints());
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
        if (!(obj instanceof GrantListEntry)) {
            return false;
        }
        GrantListEntry other = (GrantListEntry) obj;
        return Objects.equals(keyId(), other.keyId()) && Objects.equals(grantId(), other.grantId())
                && Objects.equals(name(), other.name()) && Objects.equals(creationDate(), other.creationDate())
                && Objects.equals(granteePrincipal(), other.granteePrincipal())
                && Objects.equals(retiringPrincipal(), other.retiringPrincipal())
                && Objects.equals(issuingAccount(), other.issuingAccount()) && hasOperations() == other.hasOperations()
                && Objects.equals(operationsAsStrings(), other.operationsAsStrings())
                && Objects.equals(constraints(), other.constraints());
    }

    /**
     * Returns a string representation of this object. This is useful for testing and debugging. Sensitive data will be
     * redacted from this string using a placeholder value.
     */
    @Override
    public final String toString() {
        return ToString.builder("GrantListEntry").add("KeyId", keyId()).add("GrantId", grantId()).add("Name", name())
                .add("CreationDate", creationDate()).add("GranteePrincipal", granteePrincipal())
                .add("RetiringPrincipal", retiringPrincipal()).add("IssuingAccount", issuingAccount())
                .add("Operations", hasOperations() ? operationsAsStrings() : null).add("Constraints", constraints()).build();
    }

    public final <T> Optional<T> getValueForField(String fieldName, Class<T> clazz) {
        switch (fieldName) {
        case "KeyId":
            return Optional.ofNullable(clazz.cast(keyId()));
        case "GrantId":
            return Optional.ofNullable(clazz.cast(grantId()));
        case "Name":
            return Optional.ofNullable(clazz.cast(name()));
        case "CreationDate":
            return Optional.ofNullable(clazz.cast(creationDate()));
        case "GranteePrincipal":
            return Optional.ofNullable(clazz.cast(granteePrincipal()));
        case "RetiringPrincipal":
            return Optional.ofNullable(clazz.cast(retiringPrincipal()));
        case "IssuingAccount":
            return Optional.ofNullable(clazz.cast(issuingAccount()));
        case "Operations":
            return Optional.ofNullable(clazz.cast(operationsAsStrings()));
        case "Constraints":
            return Optional.ofNullable(clazz.cast(constraints()));
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
        map.put("KeyId", KEY_ID_FIELD);
        map.put("GrantId", GRANT_ID_FIELD);
        map.put("Name", NAME_FIELD);
        map.put("CreationDate", CREATION_DATE_FIELD);
        map.put("GranteePrincipal", GRANTEE_PRINCIPAL_FIELD);
        map.put("RetiringPrincipal", RETIRING_PRINCIPAL_FIELD);
        map.put("IssuingAccount", ISSUING_ACCOUNT_FIELD);
        map.put("Operations", OPERATIONS_FIELD);
        map.put("Constraints", CONSTRAINTS_FIELD);
        return Collections.unmodifiableMap(map);
    }

    private static <T> Function<Object, T> getter(Function<GrantListEntry, T> g) {
        return obj -> g.apply((GrantListEntry) obj);
    }

    private static <T> BiConsumer<Object, T> setter(BiConsumer<Builder, T> s) {
        return (obj, val) -> s.accept((Builder) obj, val);
    }

    @Mutable
    @NotThreadSafe
    public interface Builder extends SdkPojo, CopyableBuilder<Builder, GrantListEntry> {
        /**
         * <p>
         * The unique identifier for the KMS key to which the grant applies.
         * </p>
         * 
         * @param keyId
         *        The unique identifier for the KMS key to which the grant applies.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder keyId(String keyId);

        /**
         * <p>
         * The unique identifier for the grant.
         * </p>
         * 
         * @param grantId
         *        The unique identifier for the grant.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder grantId(String grantId);

        /**
         * <p>
         * The friendly name that identifies the grant. If a name was provided in the <a>CreateGrant</a> request, that
         * name is returned. Otherwise this value is null.
         * </p>
         * 
         * @param name
         *        The friendly name that identifies the grant. If a name was provided in the <a>CreateGrant</a> request,
         *        that name is returned. Otherwise this value is null.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder name(String name);

        /**
         * <p>
         * The date and time when the grant was created.
         * </p>
         * 
         * @param creationDate
         *        The date and time when the grant was created.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder creationDate(Instant creationDate);

        /**
         * <p>
         * The identity that gets the permissions in the grant.
         * </p>
         * <p>
         * The <code>GranteePrincipal</code> field in the <code>ListGrants</code> response usually contains the user or
         * role designated as the grantee principal in the grant. However, when the grantee principal in the grant is an
         * Amazon Web Services service, the <code>GranteePrincipal</code> field contains the <a href=
         * "https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_policies_elements_principal.html#principal-services"
         * >service principal</a>, which might represent several different grantee principals.
         * </p>
         * 
         * @param granteePrincipal
         *        The identity that gets the permissions in the grant.</p>
         *        <p>
         *        The <code>GranteePrincipal</code> field in the <code>ListGrants</code> response usually contains the
         *        user or role designated as the grantee principal in the grant. However, when the grantee principal in
         *        the grant is an Amazon Web Services service, the <code>GranteePrincipal</code> field contains the <a
         *        href=
         *        "https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_policies_elements_principal.html#principal-services"
         *        >service principal</a>, which might represent several different grantee principals.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder granteePrincipal(String granteePrincipal);

        /**
         * <p>
         * The principal that can retire the grant.
         * </p>
         * 
         * @param retiringPrincipal
         *        The principal that can retire the grant.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder retiringPrincipal(String retiringPrincipal);

        /**
         * <p>
         * The Amazon Web Services account under which the grant was issued.
         * </p>
         * 
         * @param issuingAccount
         *        The Amazon Web Services account under which the grant was issued.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder issuingAccount(String issuingAccount);

        /**
         * <p>
         * The list of operations permitted by the grant.
         * </p>
         * 
         * @param operations
         *        The list of operations permitted by the grant.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder operationsWithStrings(Collection<String> operations);

        /**
         * <p>
         * The list of operations permitted by the grant.
         * </p>
         * 
         * @param operations
         *        The list of operations permitted by the grant.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder operationsWithStrings(String... operations);

        /**
         * <p>
         * The list of operations permitted by the grant.
         * </p>
         * 
         * @param operations
         *        The list of operations permitted by the grant.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder operations(Collection<GrantOperation> operations);

        /**
         * <p>
         * The list of operations permitted by the grant.
         * </p>
         * 
         * @param operations
         *        The list of operations permitted by the grant.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder operations(GrantOperation... operations);

        /**
         * <p>
         * A list of key-value pairs that must be present in the encryption context of certain subsequent operations
         * that the grant allows.
         * </p>
         * 
         * @param constraints
         *        A list of key-value pairs that must be present in the encryption context of certain subsequent
         *        operations that the grant allows.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder constraints(GrantConstraints constraints);

        /**
         * <p>
         * A list of key-value pairs that must be present in the encryption context of certain subsequent operations
         * that the grant allows.
         * </p>
         * This is a convenience method that creates an instance of the {@link GrantConstraints.Builder} avoiding the
         * need to create one manually via {@link GrantConstraints#builder()}.
         *
         * <p>
         * When the {@link Consumer} completes, {@link GrantConstraints.Builder#build()} is called immediately and its
         * result is passed to {@link #constraints(GrantConstraints)}.
         * 
         * @param constraints
         *        a consumer that will call methods on {@link GrantConstraints.Builder}
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see #constraints(GrantConstraints)
         */
        default Builder constraints(Consumer<GrantConstraints.Builder> constraints) {
            return constraints(GrantConstraints.builder().applyMutation(constraints).build());
        }
    }

    static final class BuilderImpl implements Builder {
        private String keyId;

        private String grantId;

        private String name;

        private Instant creationDate;

        private String granteePrincipal;

        private String retiringPrincipal;

        private String issuingAccount;

        private List<String> operations = DefaultSdkAutoConstructList.getInstance();

        private GrantConstraints constraints;

        private BuilderImpl() {
        }

        private BuilderImpl(GrantListEntry model) {
            keyId(model.keyId);
            grantId(model.grantId);
            name(model.name);
            creationDate(model.creationDate);
            granteePrincipal(model.granteePrincipal);
            retiringPrincipal(model.retiringPrincipal);
            issuingAccount(model.issuingAccount);
            operationsWithStrings(model.operations);
            constraints(model.constraints);
        }

        public final String getKeyId() {
            return keyId;
        }

        public final void setKeyId(String keyId) {
            this.keyId = keyId;
        }

        @Override
        public final Builder keyId(String keyId) {
            this.keyId = keyId;
            return this;
        }

        public final String getGrantId() {
            return grantId;
        }

        public final void setGrantId(String grantId) {
            this.grantId = grantId;
        }

        @Override
        public final Builder grantId(String grantId) {
            this.grantId = grantId;
            return this;
        }

        public final String getName() {
            return name;
        }

        public final void setName(String name) {
            this.name = name;
        }

        @Override
        public final Builder name(String name) {
            this.name = name;
            return this;
        }

        public final Instant getCreationDate() {
            return creationDate;
        }

        public final void setCreationDate(Instant creationDate) {
            this.creationDate = creationDate;
        }

        @Override
        public final Builder creationDate(Instant creationDate) {
            this.creationDate = creationDate;
            return this;
        }

        public final String getGranteePrincipal() {
            return granteePrincipal;
        }

        public final void setGranteePrincipal(String granteePrincipal) {
            this.granteePrincipal = granteePrincipal;
        }

        @Override
        public final Builder granteePrincipal(String granteePrincipal) {
            this.granteePrincipal = granteePrincipal;
            return this;
        }

        public final String getRetiringPrincipal() {
            return retiringPrincipal;
        }

        public final void setRetiringPrincipal(String retiringPrincipal) {
            this.retiringPrincipal = retiringPrincipal;
        }

        @Override
        public final Builder retiringPrincipal(String retiringPrincipal) {
            this.retiringPrincipal = retiringPrincipal;
            return this;
        }

        public final String getIssuingAccount() {
            return issuingAccount;
        }

        public final void setIssuingAccount(String issuingAccount) {
            this.issuingAccount = issuingAccount;
        }

        @Override
        public final Builder issuingAccount(String issuingAccount) {
            this.issuingAccount = issuingAccount;
            return this;
        }

        public final Collection<String> getOperations() {
            if (operations instanceof SdkAutoConstructList) {
                return null;
            }
            return operations;
        }

        public final void setOperations(Collection<String> operations) {
            this.operations = GrantOperationListCopier.copy(operations);
        }

        @Override
        public final Builder operationsWithStrings(Collection<String> operations) {
            this.operations = GrantOperationListCopier.copy(operations);
            return this;
        }

        @Override
        @SafeVarargs
        public final Builder operationsWithStrings(String... operations) {
            operationsWithStrings(Arrays.asList(operations));
            return this;
        }

        @Override
        public final Builder operations(Collection<GrantOperation> operations) {
            this.operations = GrantOperationListCopier.copyEnumToString(operations);
            return this;
        }

        @Override
        @SafeVarargs
        public final Builder operations(GrantOperation... operations) {
            operations(Arrays.asList(operations));
            return this;
        }

        public final GrantConstraints.Builder getConstraints() {
            return constraints != null ? constraints.toBuilder() : null;
        }

        public final void setConstraints(GrantConstraints.BuilderImpl constraints) {
            this.constraints = constraints != null ? constraints.build() : null;
        }

        @Override
        public final Builder constraints(GrantConstraints constraints) {
            this.constraints = constraints;
            return this;
        }

        @Override
        public GrantListEntry build() {
            return new GrantListEntry(this);
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
