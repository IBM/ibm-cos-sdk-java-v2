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
import com.ibm.cos.v2.annotations.Generated;
import com.ibm.cos.v2.annotations.Mutable;
import com.ibm.cos.v2.annotations.NotThreadSafe;
import com.ibm.cos.v2.awscore.AwsRequestOverrideConfiguration;
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
public final class CreateGrantRequest extends KmsRequest implements
        ToCopyableBuilder<CreateGrantRequest.Builder, CreateGrantRequest> {
    private static final SdkField<String> KEY_ID_FIELD = SdkField.<String> builder(MarshallingType.STRING).memberName("KeyId")
            .getter(getter(CreateGrantRequest::keyId)).setter(setter(Builder::keyId))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("KeyId").build()).build();

    private static final SdkField<String> GRANTEE_PRINCIPAL_FIELD = SdkField.<String> builder(MarshallingType.STRING)
            .memberName("GranteePrincipal").getter(getter(CreateGrantRequest::granteePrincipal))
            .setter(setter(Builder::granteePrincipal))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("GranteePrincipal").build()).build();

    private static final SdkField<String> RETIRING_PRINCIPAL_FIELD = SdkField.<String> builder(MarshallingType.STRING)
            .memberName("RetiringPrincipal").getter(getter(CreateGrantRequest::retiringPrincipal))
            .setter(setter(Builder::retiringPrincipal))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("RetiringPrincipal").build()).build();

    private static final SdkField<List<String>> OPERATIONS_FIELD = SdkField
            .<List<String>> builder(MarshallingType.LIST)
            .memberName("Operations")
            .getter(getter(CreateGrantRequest::operationsAsStrings))
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
            .getter(getter(CreateGrantRequest::constraints)).setter(setter(Builder::constraints))
            .constructor(GrantConstraints::builder)
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("Constraints").build()).build();

    private static final SdkField<List<String>> GRANT_TOKENS_FIELD = SdkField
            .<List<String>> builder(MarshallingType.LIST)
            .memberName("GrantTokens")
            .getter(getter(CreateGrantRequest::grantTokens))
            .setter(setter(Builder::grantTokens))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("GrantTokens").build(),
                    ListTrait
                            .builder()
                            .memberLocationName(null)
                            .memberFieldInfo(
                                    SdkField.<String> builder(MarshallingType.STRING)
                                            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD)
                                                    .locationName("member").build()).build()).build()).build();

    private static final SdkField<String> NAME_FIELD = SdkField.<String> builder(MarshallingType.STRING).memberName("Name")
            .getter(getter(CreateGrantRequest::name)).setter(setter(Builder::name))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("Name").build()).build();

    private static final SdkField<Boolean> DRY_RUN_FIELD = SdkField.<Boolean> builder(MarshallingType.BOOLEAN)
            .memberName("DryRun").getter(getter(CreateGrantRequest::dryRun)).setter(setter(Builder::dryRun))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("DryRun").build()).build();

    private static final List<SdkField<?>> SDK_FIELDS = Collections.unmodifiableList(Arrays.asList(KEY_ID_FIELD,
            GRANTEE_PRINCIPAL_FIELD, RETIRING_PRINCIPAL_FIELD, OPERATIONS_FIELD, CONSTRAINTS_FIELD, GRANT_TOKENS_FIELD,
            NAME_FIELD, DRY_RUN_FIELD));

    private static final Map<String, SdkField<?>> SDK_NAME_TO_FIELD = memberNameToFieldInitializer();

    private final String keyId;

    private final String granteePrincipal;

    private final String retiringPrincipal;

    private final List<String> operations;

    private final GrantConstraints constraints;

    private final List<String> grantTokens;

    private final String name;

    private final Boolean dryRun;

    private CreateGrantRequest(BuilderImpl builder) {
        super(builder);
        this.keyId = builder.keyId;
        this.granteePrincipal = builder.granteePrincipal;
        this.retiringPrincipal = builder.retiringPrincipal;
        this.operations = builder.operations;
        this.constraints = builder.constraints;
        this.grantTokens = builder.grantTokens;
        this.name = builder.name;
        this.dryRun = builder.dryRun;
    }

    /**
     * <p>
     * Identifies the KMS key for the grant. The grant gives principals permission to use this KMS key.
     * </p>
     * <p>
     * Specify the key ID or key ARN of the KMS key. To specify a KMS key in a different Amazon Web Services account,
     * you must use the key ARN.
     * </p>
     * <p>
     * For example:
     * </p>
     * <ul>
     * <li>
     * <p>
     * Key ID: <code>1234abcd-12ab-34cd-56ef-1234567890ab</code>
     * </p>
     * </li>
     * <li>
     * <p>
     * Key ARN: <code>arn:aws:kms:us-east-2:111122223333:key/1234abcd-12ab-34cd-56ef-1234567890ab</code>
     * </p>
     * </li>
     * </ul>
     * <p>
     * To get the key ID and key ARN for a KMS key, use <a>ListKeys</a> or <a>DescribeKey</a>.
     * </p>
     * 
     * @return Identifies the KMS key for the grant. The grant gives principals permission to use this KMS key.</p>
     *         <p>
     *         Specify the key ID or key ARN of the KMS key. To specify a KMS key in a different Amazon Web Services
     *         account, you must use the key ARN.
     *         </p>
     *         <p>
     *         For example:
     *         </p>
     *         <ul>
     *         <li>
     *         <p>
     *         Key ID: <code>1234abcd-12ab-34cd-56ef-1234567890ab</code>
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         Key ARN: <code>arn:aws:kms:us-east-2:111122223333:key/1234abcd-12ab-34cd-56ef-1234567890ab</code>
     *         </p>
     *         </li>
     *         </ul>
     *         <p>
     *         To get the key ID and key ARN for a KMS key, use <a>ListKeys</a> or <a>DescribeKey</a>.
     */
    public final String keyId() {
        return keyId;
    }

    /**
     * <p>
     * The identity that gets the permissions specified in the grant.
     * </p>
     * <p>
     * To specify the grantee principal, use the Amazon Resource Name (ARN) of an Amazon Web Services principal. Valid
     * principals include Amazon Web Services accounts, IAM users, IAM roles, federated users, and assumed role users.
     * For help with the ARN syntax for a principal, see <a
     * href="https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_identifiers.html#identifiers-arns">IAM ARNs</a>
     * in the <i> <i>Identity and Access Management User Guide</i> </i>.
     * </p>
     * 
     * @return The identity that gets the permissions specified in the grant.</p>
     *         <p>
     *         To specify the grantee principal, use the Amazon Resource Name (ARN) of an Amazon Web Services principal.
     *         Valid principals include Amazon Web Services accounts, IAM users, IAM roles, federated users, and assumed
     *         role users. For help with the ARN syntax for a principal, see <a
     *         href="https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_identifiers.html#identifiers-arns">IAM
     *         ARNs</a> in the <i> <i>Identity and Access Management User Guide</i> </i>.
     */
    public final String granteePrincipal() {
        return granteePrincipal;
    }

    /**
     * <p>
     * The principal that has permission to use the <a>RetireGrant</a> operation to retire the grant.
     * </p>
     * <p>
     * To specify the principal, use the <a
     * href="https://docs.aws.amazon.com/general/latest/gr/aws-arns-and-namespaces.html">Amazon Resource Name (ARN)</a>
     * of an Amazon Web Services principal. Valid principals include Amazon Web Services accounts, IAM users, IAM roles,
     * federated users, and assumed role users. For help with the ARN syntax for a principal, see <a
     * href="https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_identifiers.html#identifiers-arns">IAM ARNs</a>
     * in the <i> <i>Identity and Access Management User Guide</i> </i>.
     * </p>
     * <p>
     * The grant determines the retiring principal. Other principals might have permission to retire the grant or revoke
     * the grant. For details, see <a>RevokeGrant</a> and <a
     * href="https://docs.aws.amazon.com/kms/latest/developerguide/grant-manage.html#grant-delete">Retiring and revoking
     * grants</a> in the <i>Key Management Service Developer Guide</i>.
     * </p>
     * 
     * @return The principal that has permission to use the <a>RetireGrant</a> operation to retire the grant. </p>
     *         <p>
     *         To specify the principal, use the <a
     *         href="https://docs.aws.amazon.com/general/latest/gr/aws-arns-and-namespaces.html">Amazon Resource Name
     *         (ARN)</a> of an Amazon Web Services principal. Valid principals include Amazon Web Services accounts, IAM
     *         users, IAM roles, federated users, and assumed role users. For help with the ARN syntax for a principal,
     *         see <a
     *         href="https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_identifiers.html#identifiers-arns">IAM
     *         ARNs</a> in the <i> <i>Identity and Access Management User Guide</i> </i>.
     *         </p>
     *         <p>
     *         The grant determines the retiring principal. Other principals might have permission to retire the grant
     *         or revoke the grant. For details, see <a>RevokeGrant</a> and <a
     *         href="https://docs.aws.amazon.com/kms/latest/developerguide/grant-manage.html#grant-delete">Retiring and
     *         revoking grants</a> in the <i>Key Management Service Developer Guide</i>.
     */
    public final String retiringPrincipal() {
        return retiringPrincipal;
    }

    /**
     * <p>
     * A list of operations that the grant permits.
     * </p>
     * <p>
     * This list must include only operations that are permitted in a grant. Also, the operation must be supported on
     * the KMS key. For example, you cannot create a grant for a symmetric encryption KMS key that allows the
     * <a>Sign</a> operation, or a grant for an asymmetric KMS key that allows the <a>GenerateDataKey</a> operation. If
     * you try, KMS returns a <code>ValidationError</code> exception. For details, see <a
     * href="https://docs.aws.amazon.com/kms/latest/developerguide/grants.html#terms-grant-operations">Grant
     * operations</a> in the <i>Key Management Service Developer Guide</i>.
     * </p>
     * <p>
     * Attempts to modify the collection returned by this method will result in an UnsupportedOperationException.
     * </p>
     * <p>
     * This method will never return null. If you would like to know whether the service returned this field (so that
     * you can differentiate between null and empty), you can use the {@link #hasOperations} method.
     * </p>
     * 
     * @return A list of operations that the grant permits. </p>
     *         <p>
     *         This list must include only operations that are permitted in a grant. Also, the operation must be
     *         supported on the KMS key. For example, you cannot create a grant for a symmetric encryption KMS key that
     *         allows the <a>Sign</a> operation, or a grant for an asymmetric KMS key that allows the
     *         <a>GenerateDataKey</a> operation. If you try, KMS returns a <code>ValidationError</code> exception. For
     *         details, see <a
     *         href="https://docs.aws.amazon.com/kms/latest/developerguide/grants.html#terms-grant-operations">Grant
     *         operations</a> in the <i>Key Management Service Developer Guide</i>.
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
     * A list of operations that the grant permits.
     * </p>
     * <p>
     * This list must include only operations that are permitted in a grant. Also, the operation must be supported on
     * the KMS key. For example, you cannot create a grant for a symmetric encryption KMS key that allows the
     * <a>Sign</a> operation, or a grant for an asymmetric KMS key that allows the <a>GenerateDataKey</a> operation. If
     * you try, KMS returns a <code>ValidationError</code> exception. For details, see <a
     * href="https://docs.aws.amazon.com/kms/latest/developerguide/grants.html#terms-grant-operations">Grant
     * operations</a> in the <i>Key Management Service Developer Guide</i>.
     * </p>
     * <p>
     * Attempts to modify the collection returned by this method will result in an UnsupportedOperationException.
     * </p>
     * <p>
     * This method will never return null. If you would like to know whether the service returned this field (so that
     * you can differentiate between null and empty), you can use the {@link #hasOperations} method.
     * </p>
     * 
     * @return A list of operations that the grant permits. </p>
     *         <p>
     *         This list must include only operations that are permitted in a grant. Also, the operation must be
     *         supported on the KMS key. For example, you cannot create a grant for a symmetric encryption KMS key that
     *         allows the <a>Sign</a> operation, or a grant for an asymmetric KMS key that allows the
     *         <a>GenerateDataKey</a> operation. If you try, KMS returns a <code>ValidationError</code> exception. For
     *         details, see <a
     *         href="https://docs.aws.amazon.com/kms/latest/developerguide/grants.html#terms-grant-operations">Grant
     *         operations</a> in the <i>Key Management Service Developer Guide</i>.
     */
    public final List<String> operationsAsStrings() {
        return operations;
    }

    /**
     * <p>
     * Specifies a grant constraint.
     * </p>
     * <important>
     * <p>
     * Do not include confidential or sensitive information in this field. This field may be displayed in plaintext in
     * CloudTrail logs and other output.
     * </p>
     * </important>
     * <p>
     * KMS supports the <code>EncryptionContextEquals</code> and <code>EncryptionContextSubset</code> grant constraints,
     * which allow the permissions in the grant only when the encryption context in the request matches (
     * <code>EncryptionContextEquals</code>) or includes (<code>EncryptionContextSubset</code>) the encryption context
     * specified in the constraint.
     * </p>
     * <p>
     * The encryption context grant constraints are supported only on <a
     * href="https://docs.aws.amazon.com/kms/latest/developerguide/grants.html#terms-grant-operations">grant
     * operations</a> that include an <code>EncryptionContext</code> parameter, such as cryptographic operations on
     * symmetric encryption KMS keys. Grants with grant constraints can include the <a>DescribeKey</a> and
     * <a>RetireGrant</a> operations, but the constraint doesn't apply to these operations. If a grant with a grant
     * constraint includes the <code>CreateGrant</code> operation, the constraint requires that any grants created with
     * the <code>CreateGrant</code> permission have an equally strict or stricter encryption context constraint.
     * </p>
     * <p>
     * You cannot use an encryption context grant constraint for cryptographic operations with asymmetric KMS keys or
     * HMAC KMS keys. Operations with these keys don't support an encryption context.
     * </p>
     * <p>
     * Each constraint value can include up to 8 encryption context pairs. The encryption context value in each
     * constraint cannot exceed 384 characters. For information about grant constraints, see <a
     * href="https://docs.aws.amazon.com/kms/latest/developerguide/create-grant-overview.html#grant-constraints">Using
     * grant constraints</a> in the <i>Key Management Service Developer Guide</i>. For more information about encryption
     * context, see <a
     * href="https://docs.aws.amazon.com/kms/latest/developerguide/concepts.html#encrypt_context">Encryption context</a>
     * in the <i> <i>Key Management Service Developer Guide</i> </i>.
     * </p>
     * 
     * @return Specifies a grant constraint.</p> <important>
     *         <p>
     *         Do not include confidential or sensitive information in this field. This field may be displayed in
     *         plaintext in CloudTrail logs and other output.
     *         </p>
     *         </important>
     *         <p>
     *         KMS supports the <code>EncryptionContextEquals</code> and <code>EncryptionContextSubset</code> grant
     *         constraints, which allow the permissions in the grant only when the encryption context in the request
     *         matches (<code>EncryptionContextEquals</code>) or includes (<code>EncryptionContextSubset</code>) the
     *         encryption context specified in the constraint.
     *         </p>
     *         <p>
     *         The encryption context grant constraints are supported only on <a
     *         href="https://docs.aws.amazon.com/kms/latest/developerguide/grants.html#terms-grant-operations">grant
     *         operations</a> that include an <code>EncryptionContext</code> parameter, such as cryptographic operations
     *         on symmetric encryption KMS keys. Grants with grant constraints can include the <a>DescribeKey</a> and
     *         <a>RetireGrant</a> operations, but the constraint doesn't apply to these operations. If a grant with a
     *         grant constraint includes the <code>CreateGrant</code> operation, the constraint requires that any grants
     *         created with the <code>CreateGrant</code> permission have an equally strict or stricter encryption
     *         context constraint.
     *         </p>
     *         <p>
     *         You cannot use an encryption context grant constraint for cryptographic operations with asymmetric KMS
     *         keys or HMAC KMS keys. Operations with these keys don't support an encryption context.
     *         </p>
     *         <p>
     *         Each constraint value can include up to 8 encryption context pairs. The encryption context value in each
     *         constraint cannot exceed 384 characters. For information about grant constraints, see <a href=
     *         "https://docs.aws.amazon.com/kms/latest/developerguide/create-grant-overview.html#grant-constraints"
     *         >Using grant constraints</a> in the <i>Key Management Service Developer Guide</i>. For more information
     *         about encryption context, see <a
     *         href="https://docs.aws.amazon.com/kms/latest/developerguide/concepts.html#encrypt_context">Encryption
     *         context</a> in the <i> <i>Key Management Service Developer Guide</i> </i>.
     */
    public final GrantConstraints constraints() {
        return constraints;
    }

    /**
     * For responses, this returns true if the service returned a value for the GrantTokens property. This DOES NOT
     * check that the value is non-empty (for which, you should check the {@code isEmpty()} method on the property).
     * This is useful because the SDK will never return a null collection or map, but you may need to differentiate
     * between the service returning nothing (or null) and the service returning an empty collection or map. For
     * requests, this returns true if a value for the property was specified in the request builder, and false if a
     * value was not specified.
     */
    public final boolean hasGrantTokens() {
        return grantTokens != null && !(grantTokens instanceof SdkAutoConstructList);
    }

    /**
     * <p>
     * A list of grant tokens.
     * </p>
     * <p>
     * Use a grant token when your permission to call this operation comes from a new grant that has not yet achieved
     * <i>eventual consistency</i>. For more information, see <a
     * href="https://docs.aws.amazon.com/kms/latest/developerguide/grants.html#grant_token">Grant token</a> and <a
     * href="https://docs.aws.amazon.com/kms/latest/developerguide/grant-manage.html#using-grant-token">Using a grant
     * token</a> in the <i>Key Management Service Developer Guide</i>.
     * </p>
     * <p>
     * Attempts to modify the collection returned by this method will result in an UnsupportedOperationException.
     * </p>
     * <p>
     * This method will never return null. If you would like to know whether the service returned this field (so that
     * you can differentiate between null and empty), you can use the {@link #hasGrantTokens} method.
     * </p>
     * 
     * @return A list of grant tokens. </p>
     *         <p>
     *         Use a grant token when your permission to call this operation comes from a new grant that has not yet
     *         achieved <i>eventual consistency</i>. For more information, see <a
     *         href="https://docs.aws.amazon.com/kms/latest/developerguide/grants.html#grant_token">Grant token</a> and
     *         <a href="https://docs.aws.amazon.com/kms/latest/developerguide/grant-manage.html#using-grant-token">Using
     *         a grant token</a> in the <i>Key Management Service Developer Guide</i>.
     */
    public final List<String> grantTokens() {
        return grantTokens;
    }

    /**
     * <p>
     * A friendly name for the grant. Use this value to prevent the unintended creation of duplicate grants when
     * retrying this request.
     * </p>
     * <important>
     * <p>
     * Do not include confidential or sensitive information in this field. This field may be displayed in plaintext in
     * CloudTrail logs and other output.
     * </p>
     * </important>
     * <p>
     * When this value is absent, all <code>CreateGrant</code> requests result in a new grant with a unique
     * <code>GrantId</code> even if all the supplied parameters are identical. This can result in unintended duplicates
     * when you retry the <code>CreateGrant</code> request.
     * </p>
     * <p>
     * When this value is present, you can retry a <code>CreateGrant</code> request with identical parameters; if the
     * grant already exists, the original <code>GrantId</code> is returned without creating a new grant. Note that the
     * returned grant token is unique with every <code>CreateGrant</code> request, even when a duplicate
     * <code>GrantId</code> is returned. All grant tokens for the same grant ID can be used interchangeably.
     * </p>
     * 
     * @return A friendly name for the grant. Use this value to prevent the unintended creation of duplicate grants when
     *         retrying this request.</p> <important>
     *         <p>
     *         Do not include confidential or sensitive information in this field. This field may be displayed in
     *         plaintext in CloudTrail logs and other output.
     *         </p>
     *         </important>
     *         <p>
     *         When this value is absent, all <code>CreateGrant</code> requests result in a new grant with a unique
     *         <code>GrantId</code> even if all the supplied parameters are identical. This can result in unintended
     *         duplicates when you retry the <code>CreateGrant</code> request.
     *         </p>
     *         <p>
     *         When this value is present, you can retry a <code>CreateGrant</code> request with identical parameters;
     *         if the grant already exists, the original <code>GrantId</code> is returned without creating a new grant.
     *         Note that the returned grant token is unique with every <code>CreateGrant</code> request, even when a
     *         duplicate <code>GrantId</code> is returned. All grant tokens for the same grant ID can be used
     *         interchangeably.
     */
    public final String name() {
        return name;
    }

    /**
     * <p>
     * Checks if your request will succeed. <code>DryRun</code> is an optional parameter.
     * </p>
     * <p>
     * To learn more about how to use this parameter, see <a
     * href="https://docs.aws.amazon.com/kms/latest/developerguide/programming-dryrun.html">Testing your KMS API
     * calls</a> in the <i>Key Management Service Developer Guide</i>.
     * </p>
     * 
     * @return Checks if your request will succeed. <code>DryRun</code> is an optional parameter. </p>
     *         <p>
     *         To learn more about how to use this parameter, see <a
     *         href="https://docs.aws.amazon.com/kms/latest/developerguide/programming-dryrun.html">Testing your KMS API
     *         calls</a> in the <i>Key Management Service Developer Guide</i>.
     */
    public final Boolean dryRun() {
        return dryRun;
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
        hashCode = 31 * hashCode + Objects.hashCode(keyId());
        hashCode = 31 * hashCode + Objects.hashCode(granteePrincipal());
        hashCode = 31 * hashCode + Objects.hashCode(retiringPrincipal());
        hashCode = 31 * hashCode + Objects.hashCode(hasOperations() ? operationsAsStrings() : null);
        hashCode = 31 * hashCode + Objects.hashCode(constraints());
        hashCode = 31 * hashCode + Objects.hashCode(hasGrantTokens() ? grantTokens() : null);
        hashCode = 31 * hashCode + Objects.hashCode(name());
        hashCode = 31 * hashCode + Objects.hashCode(dryRun());
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
        if (!(obj instanceof CreateGrantRequest)) {
            return false;
        }
        CreateGrantRequest other = (CreateGrantRequest) obj;
        return Objects.equals(keyId(), other.keyId()) && Objects.equals(granteePrincipal(), other.granteePrincipal())
                && Objects.equals(retiringPrincipal(), other.retiringPrincipal()) && hasOperations() == other.hasOperations()
                && Objects.equals(operationsAsStrings(), other.operationsAsStrings())
                && Objects.equals(constraints(), other.constraints()) && hasGrantTokens() == other.hasGrantTokens()
                && Objects.equals(grantTokens(), other.grantTokens()) && Objects.equals(name(), other.name())
                && Objects.equals(dryRun(), other.dryRun());
    }

    /**
     * Returns a string representation of this object. This is useful for testing and debugging. Sensitive data will be
     * redacted from this string using a placeholder value.
     */
    @Override
    public final String toString() {
        return ToString.builder("CreateGrantRequest").add("KeyId", keyId()).add("GranteePrincipal", granteePrincipal())
                .add("RetiringPrincipal", retiringPrincipal()).add("Operations", hasOperations() ? operationsAsStrings() : null)
                .add("Constraints", constraints()).add("GrantTokens", hasGrantTokens() ? grantTokens() : null)
                .add("Name", name()).add("DryRun", dryRun()).build();
    }

    public final <T> Optional<T> getValueForField(String fieldName, Class<T> clazz) {
        switch (fieldName) {
        case "KeyId":
            return Optional.ofNullable(clazz.cast(keyId()));
        case "GranteePrincipal":
            return Optional.ofNullable(clazz.cast(granteePrincipal()));
        case "RetiringPrincipal":
            return Optional.ofNullable(clazz.cast(retiringPrincipal()));
        case "Operations":
            return Optional.ofNullable(clazz.cast(operationsAsStrings()));
        case "Constraints":
            return Optional.ofNullable(clazz.cast(constraints()));
        case "GrantTokens":
            return Optional.ofNullable(clazz.cast(grantTokens()));
        case "Name":
            return Optional.ofNullable(clazz.cast(name()));
        case "DryRun":
            return Optional.ofNullable(clazz.cast(dryRun()));
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
        map.put("GranteePrincipal", GRANTEE_PRINCIPAL_FIELD);
        map.put("RetiringPrincipal", RETIRING_PRINCIPAL_FIELD);
        map.put("Operations", OPERATIONS_FIELD);
        map.put("Constraints", CONSTRAINTS_FIELD);
        map.put("GrantTokens", GRANT_TOKENS_FIELD);
        map.put("Name", NAME_FIELD);
        map.put("DryRun", DRY_RUN_FIELD);
        return Collections.unmodifiableMap(map);
    }

    private static <T> Function<Object, T> getter(Function<CreateGrantRequest, T> g) {
        return obj -> g.apply((CreateGrantRequest) obj);
    }

    private static <T> BiConsumer<Object, T> setter(BiConsumer<Builder, T> s) {
        return (obj, val) -> s.accept((Builder) obj, val);
    }

    @Mutable
    @NotThreadSafe
    public interface Builder extends KmsRequest.Builder, SdkPojo, CopyableBuilder<Builder, CreateGrantRequest> {
        /**
         * <p>
         * Identifies the KMS key for the grant. The grant gives principals permission to use this KMS key.
         * </p>
         * <p>
         * Specify the key ID or key ARN of the KMS key. To specify a KMS key in a different Amazon Web Services
         * account, you must use the key ARN.
         * </p>
         * <p>
         * For example:
         * </p>
         * <ul>
         * <li>
         * <p>
         * Key ID: <code>1234abcd-12ab-34cd-56ef-1234567890ab</code>
         * </p>
         * </li>
         * <li>
         * <p>
         * Key ARN: <code>arn:aws:kms:us-east-2:111122223333:key/1234abcd-12ab-34cd-56ef-1234567890ab</code>
         * </p>
         * </li>
         * </ul>
         * <p>
         * To get the key ID and key ARN for a KMS key, use <a>ListKeys</a> or <a>DescribeKey</a>.
         * </p>
         * 
         * @param keyId
         *        Identifies the KMS key for the grant. The grant gives principals permission to use this KMS key.</p>
         *        <p>
         *        Specify the key ID or key ARN of the KMS key. To specify a KMS key in a different Amazon Web Services
         *        account, you must use the key ARN.
         *        </p>
         *        <p>
         *        For example:
         *        </p>
         *        <ul>
         *        <li>
         *        <p>
         *        Key ID: <code>1234abcd-12ab-34cd-56ef-1234567890ab</code>
         *        </p>
         *        </li>
         *        <li>
         *        <p>
         *        Key ARN: <code>arn:aws:kms:us-east-2:111122223333:key/1234abcd-12ab-34cd-56ef-1234567890ab</code>
         *        </p>
         *        </li>
         *        </ul>
         *        <p>
         *        To get the key ID and key ARN for a KMS key, use <a>ListKeys</a> or <a>DescribeKey</a>.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder keyId(String keyId);

        /**
         * <p>
         * The identity that gets the permissions specified in the grant.
         * </p>
         * <p>
         * To specify the grantee principal, use the Amazon Resource Name (ARN) of an Amazon Web Services principal.
         * Valid principals include Amazon Web Services accounts, IAM users, IAM roles, federated users, and assumed
         * role users. For help with the ARN syntax for a principal, see <a
         * href="https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_identifiers.html#identifiers-arns">IAM
         * ARNs</a> in the <i> <i>Identity and Access Management User Guide</i> </i>.
         * </p>
         * 
         * @param granteePrincipal
         *        The identity that gets the permissions specified in the grant.</p>
         *        <p>
         *        To specify the grantee principal, use the Amazon Resource Name (ARN) of an Amazon Web Services
         *        principal. Valid principals include Amazon Web Services accounts, IAM users, IAM roles, federated
         *        users, and assumed role users. For help with the ARN syntax for a principal, see <a
         *        href="https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_identifiers.html#identifiers-arns"
         *        >IAM ARNs</a> in the <i> <i>Identity and Access Management User Guide</i> </i>.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder granteePrincipal(String granteePrincipal);

        /**
         * <p>
         * The principal that has permission to use the <a>RetireGrant</a> operation to retire the grant.
         * </p>
         * <p>
         * To specify the principal, use the <a
         * href="https://docs.aws.amazon.com/general/latest/gr/aws-arns-and-namespaces.html">Amazon Resource Name
         * (ARN)</a> of an Amazon Web Services principal. Valid principals include Amazon Web Services accounts, IAM
         * users, IAM roles, federated users, and assumed role users. For help with the ARN syntax for a principal, see
         * <a href="https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_identifiers.html#identifiers-arns">IAM
         * ARNs</a> in the <i> <i>Identity and Access Management User Guide</i> </i>.
         * </p>
         * <p>
         * The grant determines the retiring principal. Other principals might have permission to retire the grant or
         * revoke the grant. For details, see <a>RevokeGrant</a> and <a
         * href="https://docs.aws.amazon.com/kms/latest/developerguide/grant-manage.html#grant-delete">Retiring and
         * revoking grants</a> in the <i>Key Management Service Developer Guide</i>.
         * </p>
         * 
         * @param retiringPrincipal
         *        The principal that has permission to use the <a>RetireGrant</a> operation to retire the grant. </p>
         *        <p>
         *        To specify the principal, use the <a
         *        href="https://docs.aws.amazon.com/general/latest/gr/aws-arns-and-namespaces.html">Amazon Resource Name
         *        (ARN)</a> of an Amazon Web Services principal. Valid principals include Amazon Web Services accounts,
         *        IAM users, IAM roles, federated users, and assumed role users. For help with the ARN syntax for a
         *        principal, see <a
         *        href="https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_identifiers.html#identifiers-arns"
         *        >IAM ARNs</a> in the <i> <i>Identity and Access Management User Guide</i> </i>.
         *        </p>
         *        <p>
         *        The grant determines the retiring principal. Other principals might have permission to retire the
         *        grant or revoke the grant. For details, see <a>RevokeGrant</a> and <a
         *        href="https://docs.aws.amazon.com/kms/latest/developerguide/grant-manage.html#grant-delete">Retiring
         *        and revoking grants</a> in the <i>Key Management Service Developer Guide</i>.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder retiringPrincipal(String retiringPrincipal);

        /**
         * <p>
         * A list of operations that the grant permits.
         * </p>
         * <p>
         * This list must include only operations that are permitted in a grant. Also, the operation must be supported
         * on the KMS key. For example, you cannot create a grant for a symmetric encryption KMS key that allows the
         * <a>Sign</a> operation, or a grant for an asymmetric KMS key that allows the <a>GenerateDataKey</a> operation.
         * If you try, KMS returns a <code>ValidationError</code> exception. For details, see <a
         * href="https://docs.aws.amazon.com/kms/latest/developerguide/grants.html#terms-grant-operations">Grant
         * operations</a> in the <i>Key Management Service Developer Guide</i>.
         * </p>
         * 
         * @param operations
         *        A list of operations that the grant permits. </p>
         *        <p>
         *        This list must include only operations that are permitted in a grant. Also, the operation must be
         *        supported on the KMS key. For example, you cannot create a grant for a symmetric encryption KMS key
         *        that allows the <a>Sign</a> operation, or a grant for an asymmetric KMS key that allows the
         *        <a>GenerateDataKey</a> operation. If you try, KMS returns a <code>ValidationError</code> exception.
         *        For details, see <a
         *        href="https://docs.aws.amazon.com/kms/latest/developerguide/grants.html#terms-grant-operations">Grant
         *        operations</a> in the <i>Key Management Service Developer Guide</i>.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder operationsWithStrings(Collection<String> operations);

        /**
         * <p>
         * A list of operations that the grant permits.
         * </p>
         * <p>
         * This list must include only operations that are permitted in a grant. Also, the operation must be supported
         * on the KMS key. For example, you cannot create a grant for a symmetric encryption KMS key that allows the
         * <a>Sign</a> operation, or a grant for an asymmetric KMS key that allows the <a>GenerateDataKey</a> operation.
         * If you try, KMS returns a <code>ValidationError</code> exception. For details, see <a
         * href="https://docs.aws.amazon.com/kms/latest/developerguide/grants.html#terms-grant-operations">Grant
         * operations</a> in the <i>Key Management Service Developer Guide</i>.
         * </p>
         * 
         * @param operations
         *        A list of operations that the grant permits. </p>
         *        <p>
         *        This list must include only operations that are permitted in a grant. Also, the operation must be
         *        supported on the KMS key. For example, you cannot create a grant for a symmetric encryption KMS key
         *        that allows the <a>Sign</a> operation, or a grant for an asymmetric KMS key that allows the
         *        <a>GenerateDataKey</a> operation. If you try, KMS returns a <code>ValidationError</code> exception.
         *        For details, see <a
         *        href="https://docs.aws.amazon.com/kms/latest/developerguide/grants.html#terms-grant-operations">Grant
         *        operations</a> in the <i>Key Management Service Developer Guide</i>.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder operationsWithStrings(String... operations);

        /**
         * <p>
         * A list of operations that the grant permits.
         * </p>
         * <p>
         * This list must include only operations that are permitted in a grant. Also, the operation must be supported
         * on the KMS key. For example, you cannot create a grant for a symmetric encryption KMS key that allows the
         * <a>Sign</a> operation, or a grant for an asymmetric KMS key that allows the <a>GenerateDataKey</a> operation.
         * If you try, KMS returns a <code>ValidationError</code> exception. For details, see <a
         * href="https://docs.aws.amazon.com/kms/latest/developerguide/grants.html#terms-grant-operations">Grant
         * operations</a> in the <i>Key Management Service Developer Guide</i>.
         * </p>
         * 
         * @param operations
         *        A list of operations that the grant permits. </p>
         *        <p>
         *        This list must include only operations that are permitted in a grant. Also, the operation must be
         *        supported on the KMS key. For example, you cannot create a grant for a symmetric encryption KMS key
         *        that allows the <a>Sign</a> operation, or a grant for an asymmetric KMS key that allows the
         *        <a>GenerateDataKey</a> operation. If you try, KMS returns a <code>ValidationError</code> exception.
         *        For details, see <a
         *        href="https://docs.aws.amazon.com/kms/latest/developerguide/grants.html#terms-grant-operations">Grant
         *        operations</a> in the <i>Key Management Service Developer Guide</i>.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder operations(Collection<GrantOperation> operations);

        /**
         * <p>
         * A list of operations that the grant permits.
         * </p>
         * <p>
         * This list must include only operations that are permitted in a grant. Also, the operation must be supported
         * on the KMS key. For example, you cannot create a grant for a symmetric encryption KMS key that allows the
         * <a>Sign</a> operation, or a grant for an asymmetric KMS key that allows the <a>GenerateDataKey</a> operation.
         * If you try, KMS returns a <code>ValidationError</code> exception. For details, see <a
         * href="https://docs.aws.amazon.com/kms/latest/developerguide/grants.html#terms-grant-operations">Grant
         * operations</a> in the <i>Key Management Service Developer Guide</i>.
         * </p>
         * 
         * @param operations
         *        A list of operations that the grant permits. </p>
         *        <p>
         *        This list must include only operations that are permitted in a grant. Also, the operation must be
         *        supported on the KMS key. For example, you cannot create a grant for a symmetric encryption KMS key
         *        that allows the <a>Sign</a> operation, or a grant for an asymmetric KMS key that allows the
         *        <a>GenerateDataKey</a> operation. If you try, KMS returns a <code>ValidationError</code> exception.
         *        For details, see <a
         *        href="https://docs.aws.amazon.com/kms/latest/developerguide/grants.html#terms-grant-operations">Grant
         *        operations</a> in the <i>Key Management Service Developer Guide</i>.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder operations(GrantOperation... operations);

        /**
         * <p>
         * Specifies a grant constraint.
         * </p>
         * <important>
         * <p>
         * Do not include confidential or sensitive information in this field. This field may be displayed in plaintext
         * in CloudTrail logs and other output.
         * </p>
         * </important>
         * <p>
         * KMS supports the <code>EncryptionContextEquals</code> and <code>EncryptionContextSubset</code> grant
         * constraints, which allow the permissions in the grant only when the encryption context in the request matches
         * (<code>EncryptionContextEquals</code>) or includes (<code>EncryptionContextSubset</code>) the encryption
         * context specified in the constraint.
         * </p>
         * <p>
         * The encryption context grant constraints are supported only on <a
         * href="https://docs.aws.amazon.com/kms/latest/developerguide/grants.html#terms-grant-operations">grant
         * operations</a> that include an <code>EncryptionContext</code> parameter, such as cryptographic operations on
         * symmetric encryption KMS keys. Grants with grant constraints can include the <a>DescribeKey</a> and
         * <a>RetireGrant</a> operations, but the constraint doesn't apply to these operations. If a grant with a grant
         * constraint includes the <code>CreateGrant</code> operation, the constraint requires that any grants created
         * with the <code>CreateGrant</code> permission have an equally strict or stricter encryption context
         * constraint.
         * </p>
         * <p>
         * You cannot use an encryption context grant constraint for cryptographic operations with asymmetric KMS keys
         * or HMAC KMS keys. Operations with these keys don't support an encryption context.
         * </p>
         * <p>
         * Each constraint value can include up to 8 encryption context pairs. The encryption context value in each
         * constraint cannot exceed 384 characters. For information about grant constraints, see <a
         * href="https://docs.aws.amazon.com/kms/latest/developerguide/create-grant-overview.html#grant-constraints"
         * >Using grant constraints</a> in the <i>Key Management Service Developer Guide</i>. For more information about
         * encryption context, see <a
         * href="https://docs.aws.amazon.com/kms/latest/developerguide/concepts.html#encrypt_context">Encryption
         * context</a> in the <i> <i>Key Management Service Developer Guide</i> </i>.
         * </p>
         * 
         * @param constraints
         *        Specifies a grant constraint.</p> <important>
         *        <p>
         *        Do not include confidential or sensitive information in this field. This field may be displayed in
         *        plaintext in CloudTrail logs and other output.
         *        </p>
         *        </important>
         *        <p>
         *        KMS supports the <code>EncryptionContextEquals</code> and <code>EncryptionContextSubset</code> grant
         *        constraints, which allow the permissions in the grant only when the encryption context in the request
         *        matches (<code>EncryptionContextEquals</code>) or includes (<code>EncryptionContextSubset</code>) the
         *        encryption context specified in the constraint.
         *        </p>
         *        <p>
         *        The encryption context grant constraints are supported only on <a
         *        href="https://docs.aws.amazon.com/kms/latest/developerguide/grants.html#terms-grant-operations">grant
         *        operations</a> that include an <code>EncryptionContext</code> parameter, such as cryptographic
         *        operations on symmetric encryption KMS keys. Grants with grant constraints can include the
         *        <a>DescribeKey</a> and <a>RetireGrant</a> operations, but the constraint doesn't apply to these
         *        operations. If a grant with a grant constraint includes the <code>CreateGrant</code> operation, the
         *        constraint requires that any grants created with the <code>CreateGrant</code> permission have an
         *        equally strict or stricter encryption context constraint.
         *        </p>
         *        <p>
         *        You cannot use an encryption context grant constraint for cryptographic operations with asymmetric KMS
         *        keys or HMAC KMS keys. Operations with these keys don't support an encryption context.
         *        </p>
         *        <p>
         *        Each constraint value can include up to 8 encryption context pairs. The encryption context value in
         *        each constraint cannot exceed 384 characters. For information about grant constraints, see <a href=
         *        "https://docs.aws.amazon.com/kms/latest/developerguide/create-grant-overview.html#grant-constraints"
         *        >Using grant constraints</a> in the <i>Key Management Service Developer Guide</i>. For more
         *        information about encryption context, see <a
         *        href="https://docs.aws.amazon.com/kms/latest/developerguide/concepts.html#encrypt_context">Encryption
         *        context</a> in the <i> <i>Key Management Service Developer Guide</i> </i>.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder constraints(GrantConstraints constraints);

        /**
         * <p>
         * Specifies a grant constraint.
         * </p>
         * <important>
         * <p>
         * Do not include confidential or sensitive information in this field. This field may be displayed in plaintext
         * in CloudTrail logs and other output.
         * </p>
         * </important>
         * <p>
         * KMS supports the <code>EncryptionContextEquals</code> and <code>EncryptionContextSubset</code> grant
         * constraints, which allow the permissions in the grant only when the encryption context in the request matches
         * (<code>EncryptionContextEquals</code>) or includes (<code>EncryptionContextSubset</code>) the encryption
         * context specified in the constraint.
         * </p>
         * <p>
         * The encryption context grant constraints are supported only on <a
         * href="https://docs.aws.amazon.com/kms/latest/developerguide/grants.html#terms-grant-operations">grant
         * operations</a> that include an <code>EncryptionContext</code> parameter, such as cryptographic operations on
         * symmetric encryption KMS keys. Grants with grant constraints can include the <a>DescribeKey</a> and
         * <a>RetireGrant</a> operations, but the constraint doesn't apply to these operations. If a grant with a grant
         * constraint includes the <code>CreateGrant</code> operation, the constraint requires that any grants created
         * with the <code>CreateGrant</code> permission have an equally strict or stricter encryption context
         * constraint.
         * </p>
         * <p>
         * You cannot use an encryption context grant constraint for cryptographic operations with asymmetric KMS keys
         * or HMAC KMS keys. Operations with these keys don't support an encryption context.
         * </p>
         * <p>
         * Each constraint value can include up to 8 encryption context pairs. The encryption context value in each
         * constraint cannot exceed 384 characters. For information about grant constraints, see <a
         * href="https://docs.aws.amazon.com/kms/latest/developerguide/create-grant-overview.html#grant-constraints"
         * >Using grant constraints</a> in the <i>Key Management Service Developer Guide</i>. For more information about
         * encryption context, see <a
         * href="https://docs.aws.amazon.com/kms/latest/developerguide/concepts.html#encrypt_context">Encryption
         * context</a> in the <i> <i>Key Management Service Developer Guide</i> </i>.
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

        /**
         * <p>
         * A list of grant tokens.
         * </p>
         * <p>
         * Use a grant token when your permission to call this operation comes from a new grant that has not yet
         * achieved <i>eventual consistency</i>. For more information, see <a
         * href="https://docs.aws.amazon.com/kms/latest/developerguide/grants.html#grant_token">Grant token</a> and <a
         * href="https://docs.aws.amazon.com/kms/latest/developerguide/grant-manage.html#using-grant-token">Using a
         * grant token</a> in the <i>Key Management Service Developer Guide</i>.
         * </p>
         * 
         * @param grantTokens
         *        A list of grant tokens. </p>
         *        <p>
         *        Use a grant token when your permission to call this operation comes from a new grant that has not yet
         *        achieved <i>eventual consistency</i>. For more information, see <a
         *        href="https://docs.aws.amazon.com/kms/latest/developerguide/grants.html#grant_token">Grant token</a>
         *        and <a
         *        href="https://docs.aws.amazon.com/kms/latest/developerguide/grant-manage.html#using-grant-token">Using
         *        a grant token</a> in the <i>Key Management Service Developer Guide</i>.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder grantTokens(Collection<String> grantTokens);

        /**
         * <p>
         * A list of grant tokens.
         * </p>
         * <p>
         * Use a grant token when your permission to call this operation comes from a new grant that has not yet
         * achieved <i>eventual consistency</i>. For more information, see <a
         * href="https://docs.aws.amazon.com/kms/latest/developerguide/grants.html#grant_token">Grant token</a> and <a
         * href="https://docs.aws.amazon.com/kms/latest/developerguide/grant-manage.html#using-grant-token">Using a
         * grant token</a> in the <i>Key Management Service Developer Guide</i>.
         * </p>
         * 
         * @param grantTokens
         *        A list of grant tokens. </p>
         *        <p>
         *        Use a grant token when your permission to call this operation comes from a new grant that has not yet
         *        achieved <i>eventual consistency</i>. For more information, see <a
         *        href="https://docs.aws.amazon.com/kms/latest/developerguide/grants.html#grant_token">Grant token</a>
         *        and <a
         *        href="https://docs.aws.amazon.com/kms/latest/developerguide/grant-manage.html#using-grant-token">Using
         *        a grant token</a> in the <i>Key Management Service Developer Guide</i>.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder grantTokens(String... grantTokens);

        /**
         * <p>
         * A friendly name for the grant. Use this value to prevent the unintended creation of duplicate grants when
         * retrying this request.
         * </p>
         * <important>
         * <p>
         * Do not include confidential or sensitive information in this field. This field may be displayed in plaintext
         * in CloudTrail logs and other output.
         * </p>
         * </important>
         * <p>
         * When this value is absent, all <code>CreateGrant</code> requests result in a new grant with a unique
         * <code>GrantId</code> even if all the supplied parameters are identical. This can result in unintended
         * duplicates when you retry the <code>CreateGrant</code> request.
         * </p>
         * <p>
         * When this value is present, you can retry a <code>CreateGrant</code> request with identical parameters; if
         * the grant already exists, the original <code>GrantId</code> is returned without creating a new grant. Note
         * that the returned grant token is unique with every <code>CreateGrant</code> request, even when a duplicate
         * <code>GrantId</code> is returned. All grant tokens for the same grant ID can be used interchangeably.
         * </p>
         * 
         * @param name
         *        A friendly name for the grant. Use this value to prevent the unintended creation of duplicate grants
         *        when retrying this request.</p> <important>
         *        <p>
         *        Do not include confidential or sensitive information in this field. This field may be displayed in
         *        plaintext in CloudTrail logs and other output.
         *        </p>
         *        </important>
         *        <p>
         *        When this value is absent, all <code>CreateGrant</code> requests result in a new grant with a unique
         *        <code>GrantId</code> even if all the supplied parameters are identical. This can result in unintended
         *        duplicates when you retry the <code>CreateGrant</code> request.
         *        </p>
         *        <p>
         *        When this value is present, you can retry a <code>CreateGrant</code> request with identical
         *        parameters; if the grant already exists, the original <code>GrantId</code> is returned without
         *        creating a new grant. Note that the returned grant token is unique with every <code>CreateGrant</code>
         *        request, even when a duplicate <code>GrantId</code> is returned. All grant tokens for the same grant
         *        ID can be used interchangeably.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder name(String name);

        /**
         * <p>
         * Checks if your request will succeed. <code>DryRun</code> is an optional parameter.
         * </p>
         * <p>
         * To learn more about how to use this parameter, see <a
         * href="https://docs.aws.amazon.com/kms/latest/developerguide/programming-dryrun.html">Testing your KMS API
         * calls</a> in the <i>Key Management Service Developer Guide</i>.
         * </p>
         * 
         * @param dryRun
         *        Checks if your request will succeed. <code>DryRun</code> is an optional parameter. </p>
         *        <p>
         *        To learn more about how to use this parameter, see <a
         *        href="https://docs.aws.amazon.com/kms/latest/developerguide/programming-dryrun.html">Testing your KMS
         *        API calls</a> in the <i>Key Management Service Developer Guide</i>.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder dryRun(Boolean dryRun);

        @Override
        Builder overrideConfiguration(AwsRequestOverrideConfiguration overrideConfiguration);

        @Override
        Builder overrideConfiguration(Consumer<AwsRequestOverrideConfiguration.Builder> builderConsumer);
    }

    static final class BuilderImpl extends KmsRequest.BuilderImpl implements Builder {
        private String keyId;

        private String granteePrincipal;

        private String retiringPrincipal;

        private List<String> operations = DefaultSdkAutoConstructList.getInstance();

        private GrantConstraints constraints;

        private List<String> grantTokens = DefaultSdkAutoConstructList.getInstance();

        private String name;

        private Boolean dryRun;

        private BuilderImpl() {
        }

        private BuilderImpl(CreateGrantRequest model) {
            super(model);
            keyId(model.keyId);
            granteePrincipal(model.granteePrincipal);
            retiringPrincipal(model.retiringPrincipal);
            operationsWithStrings(model.operations);
            constraints(model.constraints);
            grantTokens(model.grantTokens);
            name(model.name);
            dryRun(model.dryRun);
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

        public final Collection<String> getGrantTokens() {
            if (grantTokens instanceof SdkAutoConstructList) {
                return null;
            }
            return grantTokens;
        }

        public final void setGrantTokens(Collection<String> grantTokens) {
            this.grantTokens = GrantTokenListCopier.copy(grantTokens);
        }

        @Override
        public final Builder grantTokens(Collection<String> grantTokens) {
            this.grantTokens = GrantTokenListCopier.copy(grantTokens);
            return this;
        }

        @Override
        @SafeVarargs
        public final Builder grantTokens(String... grantTokens) {
            grantTokens(Arrays.asList(grantTokens));
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

        public final Boolean getDryRun() {
            return dryRun;
        }

        public final void setDryRun(Boolean dryRun) {
            this.dryRun = dryRun;
        }

        @Override
        public final Builder dryRun(Boolean dryRun) {
            this.dryRun = dryRun;
            return this;
        }

        @Override
        public Builder overrideConfiguration(AwsRequestOverrideConfiguration overrideConfiguration) {
            super.overrideConfiguration(overrideConfiguration);
            return this;
        }

        @Override
        public Builder overrideConfiguration(Consumer<AwsRequestOverrideConfiguration.Builder> builderConsumer) {
            super.overrideConfiguration(builderConsumer);
            return this;
        }

        @Override
        public CreateGrantRequest build() {
            return new CreateGrantRequest(this);
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
