package com.ibm.cos.v2.services.s3.model;

import com.ibm.cos.v2.core.SdkField;
import com.ibm.cos.v2.core.SdkPojo;
import com.ibm.cos.v2.core.protocol.MarshallLocation;
import com.ibm.cos.v2.core.protocol.MarshallingType;
import com.ibm.cos.v2.core.traits.LocationTrait;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * A set of attributes primarily used to define the encryption type of an s3 request.
 * These values will be applied to specific headers on IO requests.
 *
 */
public final class EncryptionType {
    private static final SdkField<String> IBM_SSE_KP_ENCRYPTION_ALGORITHM_FIELD = SdkField
        .<String> builder(MarshallingType.STRING)
        .memberName("IBM_SSE_KP_ENCRYPTION_ALGORITHM")
        .getter(getter(EncryptionType::kmsEncryptionAlgorithm))
        .setter(setter(EncryptionType.Builder::kmsEncryptionAlgorithm))
        .traits(LocationTrait.builder().location(MarshallLocation.HEADER).locationName("ibm-sse-kp-encryption-algorithm")
                             .unmarshallLocationName("ibm-sse-kp-encryption-algorithm").build()).build();

    private static final SdkField<String> IBM_SSE_KP_CUSTOMER_ROOT_KEY_CRN_FIELD = SdkField
        .<String> builder(MarshallingType.STRING)
        .memberName("IBM_SSE_KP_CUSTOMER_ROOT_KEY_CRN")
        .getter(getter(EncryptionType::ibmSseKmsCustomerRootKeyCrn))
        .setter(setter(EncryptionType.Builder::ibmSSEKMSCustomerRootKeyCrn))
        .traits(LocationTrait.builder().location(MarshallLocation.HEADER).locationName("ibm-sse-kms-customer-root-key-crn")
                             .unmarshallLocationName("ibm-sse-kms-customer-root-key-crn").build()).build();

    private static final List<SdkField<?>> SDK_FIELDS = Collections.unmodifiableList(Arrays.asList(IBM_SSE_KP_ENCRYPTION_ALGORITHM_FIELD,
                                                                                     IBM_SSE_KP_CUSTOMER_ROOT_KEY_CRN_FIELD));

    /***The encryption algorithm used in ibm-sse-kms-encryption-algorithm header. Default value assigned*/
    private final String kmsEncryptionAlgorithm ;

    /**ibm-sse-kms-customer-root-key-crn header**/
    private final String ibmSSEKMSCustomerRootKeyCrn;

    /** constructor
     * Sets default value as 'AES256' if not set to encryption algorithm */
    private EncryptionType(BuilderImpl builder) {
        this.kmsEncryptionAlgorithm = builder.kmsEncryptionAlgorithm != null ? builder.kmsEncryptionAlgorithm : "AES256";
        this.ibmSSEKMSCustomerRootKeyCrn = builder.ibmSSEKMSCustomerRootKeyCrn;
    }

    /**
     * The encryption algorithm that will be used for objects stored in the newly created bucket
     * @return encryption algorithm
     */
    public String kmsEncryptionAlgorithm() {
        return kmsEncryptionAlgorithm;
    }

    /**
     * return the IBMSSEKMSCustomerRootKeyCrn header value
     * @return IBMSSEKMSCustomerRootKeyCrn
     */
    public String ibmSseKmsCustomerRootKeyCrn() {
        return ibmSSEKMSCustomerRootKeyCrn;
    }

    public static Builder builder() {
        return new BuilderImpl();
    }


    public interface Builder extends SdkPojo {
        /**
         * The encryption algorithm that will be used for objects stored in the newly created bucket
         * @param kmsEncryptionAlgorithm
         */
        Builder kmsEncryptionAlgorithm(String kmsEncryptionAlgorithm);

        /**
         * Set the IBMSSEKMSCustomerRootKeyCrn. The string must comply with the correct CRN format for the version
         * of the api, otherwise the request will be rejected by COS
         *
         * @param iBMSSEKMSCustomerRootKeyCrn
         */
        Builder ibmSSEKMSCustomerRootKeyCrn(String iBMSSEKMSCustomerRootKeyCrn);

        EncryptionType build();
    }

    static final class BuilderImpl implements Builder {

        private String kmsEncryptionAlgorithm;

        private String ibmSSEKMSCustomerRootKeyCrn;

        private BuilderImpl() {
        }

        private BuilderImpl(EncryptionType model) {
            kmsEncryptionAlgorithm(model.kmsEncryptionAlgorithm);
            ibmSSEKMSCustomerRootKeyCrn(model.ibmSSEKMSCustomerRootKeyCrn);
        }

        @Override
        public Builder kmsEncryptionAlgorithm(String kmsEncryptionAlgorithm) {
            this.kmsEncryptionAlgorithm = kmsEncryptionAlgorithm;
            return this;
        }

        @Override
        public Builder ibmSSEKMSCustomerRootKeyCrn(String ibmSSEKMSCustomerRootKeyCrn) {
            this.ibmSSEKMSCustomerRootKeyCrn = ibmSSEKMSCustomerRootKeyCrn;
            return this;
        }

        @Override
        public EncryptionType build() {
           return new EncryptionType(this);
        }

        @Override
        public List<SdkField<?>> sdkFields() {
            return SDK_FIELDS;
        }
    }

    private static <T> Function<Object, T> getter(Function<EncryptionType, T> g) {
        return obj -> g.apply((EncryptionType) obj);
    }

    private static <T> BiConsumer<Object, T> setter(BiConsumer<EncryptionType.Builder, T> s) {
        return (obj, val) -> s.accept((EncryptionType.Builder) obj, val);
    }
}
