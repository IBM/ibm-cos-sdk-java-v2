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

package com.ibm.cos.v2;

public class SDKGlobalConfiguration {

        /**
         * Disable validation of server certificates when using the HTTPS protocol. This should ONLY be
         * used to do quick smoke tests against endpoints which don't yet have valid certificates; it
         * should NEVER be used in production. This property is meant to be used as a flag (i.e.
         * -Dcom.com.amazonaws.sdk.disableCertChecking) rather then taking a value
         * (-Dcom.com.amazonaws.sdk.disableCertChecking=true). This property is treated as false by default
         * (i.e. check certificates by default)
         */
        //Support has been removed in v2
        /*public static final String DISABLE_CERT_CHECKING_SYSTEM_PROPERTY =
            "com.amazonaws.sdk.disableCertChecking";*/

        /** Global variable IAM Endpoint */
        public static String IAM_ENDPOINT = "https://iam.cloud.ibm.com/identity/token";

        /**
         * By default, the AmazonS3Client will continue to use the legacy
         * S3Signer to authenticate requests it makes to S3 in regions that
         * support the older protocol. Setting this property to anything other
         * than null will cause the client to upgrade to Signature Version 4
         * whenever it has been configured with an explicit region (which is a
         * required parameter for Signature Version 4). The client will continue
         * to use the older signature protocol when not configured with a region
         * to avoid breaking existing applications.
         * <p>
         * Signature Version 4 is more secure than the legacy S3Signer, but
         * requires calculating a SHA-256 hash of the entire request body which
         * can be expensive for large upload requests.
         */
        @Deprecated
        public static final String ENABLE_S3_SIGV4_SYSTEM_PROPERTY =
            "com.amazonaws.services.s3.enableV4";

        /**
         * Like {@link #ENABLE_S3_SIGV4_SYSTEM_PROPERTY}, but causes the client to
         * always use Signature Version 4, assuming a region of
         * &quot;us-east-1&quot; if no explicit region has been configured. This
         * guarantees that the more secure authentication protocol will be used,
         * but will cause authentication failures in code that accesses buckets in
         * regions other than US Standard without explicitly configuring a region.
         */
        @Deprecated
        public static final String ENFORCE_S3_SIGV4_SYSTEM_PROPERTY =
            "com.amazonaws.services.s3.enforceV4";

        /**
         * By default, the S3 client constructor does not set a region.
         * <p>
         * If the client is not configured with an explicit region, bucket operations
         * (eg. {@code listObjects}) will attempt to determine the bucket's region the first
         * time that bucket is seen. This may result in a cross-region call.
         * <p>
         * Setting this system property to anything other than {@code null} or
         * {@code false} will <i>disable</i> this implicit fixed-region invocation,
         * and any attempt to use a regionless client will fail with an IllegalStateException.
         * This allows SDK users to force all S3 clients to be created with a region defined,
         * so that calls to unintended regions are avoided.
         * <p>
         * Note: Even with this option enabled, SDK users can still create clients not
         * attached to fixed regions using specific opt-in methods on the S3 client builder.
         * For instance, the {@code enableGlobalBucketAccess} option explicitly allows
         * creation of a client that will automatically identify the location of a bucket via
         * a call to a single, fixed region.
         */
        //Support has been removed in v2
        /*public static final String DISABLE_S3_IMPLICIT_GLOBAL_CLIENTS_SYSTEM_PROPERTY =
            "com.amazonaws.services.s3.disableImplicitGlobalClients";*/

        /**
         * Overrides the client default {@link //ClientConfiguration} to use
         * configuration with values tailored towards clients operating in the
         * same AWS region as the service endpoint they call.  Timeouts in
         * in-region optimized configurations are generally set much lower than
         * the client standard configuration.
         */
        //Support has been removed in v2
       /* public static final String ENABLE_IN_REGION_OPTIMIZED_MODE =
            "com.amazonaws.sdk.enableInRegionOptimizedMode";*/

        /**
         * @deprecated with {@link //AmazonWebServiceRequest#getRequestClientOptions()}
         * and {@link //RequestClientOptions#setReadLimit(int)}.
         * <p>
         * The default size of the buffer when uploading data from a stream. A
         * buffer of this size will be created and filled with the first bytes from
         * a stream being uploaded so that any transmit errors that occur in that
         * section of the data can be automatically retried without the caller's
         * intervention.
         * <p>
         * If not set, the default value of 128 KB will be used.
         */
        @Deprecated
        public static final String DEFAULT_S3_STREAM_BUFFER_SIZE =
            "com.amazonaws.sdk.s3.defaultStreamBufferSize";

        /**
         *
         * Internal system property to enable timing info collection.
         */
        @Deprecated
        public static final String PROFILING_SYSTEM_PROPERTY =
            "com.amazonaws.sdk.enableRuntimeProfiling";

        /**
         * Environment variable to disable CBOR protocol. This forces the request
         * to be sent over the wire as a AWS JSON.
         */
        public static final String AWS_CBOR_DISABLE_ENV_VAR = "AWS_CBOR_DISABLE";

        /**
         * System property to disable CBOR protocol. This forces the request to be sent over the wire
         * as a AWS JSON
         */
        public static final String AWS_CBOR_DISABLE_SYSTEM_PROPERTY = "com.amazonaws.sdk.disableCbor";

        /**
         * Environment variable to disable Ion binary protocol. This forces the request
         * to be sent over the wire as Ion text.
         */
        public static final String AWS_ION_BINARY_DISABLE_ENV_VAR = "AWS_ION_BINARY_DISABLE";

        /**
         * System property to disable Ion binary protocol. This forces the request to be sent over the wire
         * as Ion text
         */
        public static final String AWS_ION_BINARY_DISABLE_SYSTEM_PROPERTY = "com.amazonaws.sdk.disableIonBinary";

        /**
         * Environment variable to disable loading credentials or regions from EC2 Metadata instance service.
         */
        public static final String AWS_EC2_METADATA_DISABLED_ENV_VAR = "AWS_EC2_METADATA_DISABLED";

        /**
         * System property to disable loading credentials or regions from EC2 Metadata instance service.
         */
        //Change - com.amazonaws.sdk.disableEc2Metadata is now aws.disableEc2Metadata
        /*public static final String AWS_EC2_METADATA_DISABLED_SYSTEM_PROPERTY = "com.amazonaws.sdk"
                                                                                + ".disableEc2Metadata";*/

        /**
         * Environment variable to enable/disable client side monitoring.
         */
        public static final String AWS_CSM_ENABLED_ENV_VAR = "AWS_CSM_ENABLED";

        /**
         * Environment variable to set the host to send client side monitor events to.
         */
        public static final String AWS_CSM_HOST_ENV_VAR = "AWS_CSM_HOST";

        /**
         * Environment varaible to set the port of the out of process client side
         * monitoring agent.
         */
        public static final String AWS_CSM_PORT_ENV_VAR = "AWS_CSM_PORT";

        /**
         * Environment variable to set the client ID to use for client side
         * monitoring events.
         */
        public static final String AWS_CSM_CLIENT_ID_ENV_VAR = "AWS_CSM_CLIENT_ID";

        /**
         * System properties to set the retry mode to use. See {@link //RetryMode} for available values
         */
        public static final String AWS_RETRY_MODE_SYSTEM_PROPERTY = "com.amazonaws.sdk.retryMode";

        /**
         * Environment variable to set the retry mode to use. See {@link //RetryMode} for available values
         */
        public static final String AWS_RETRY_MODE_ENV_VAR = "AWS_RETRY_MODE";

        /**
         * System properties to set the retry max attempts
         */
        public static final String AWS_MAX_ATTEMPTS_SYSTEM_PROPERTY = "com.amazonaws.sdk.maxAttempts";

        /**
         * Environment variable to set the retry max attempts
         */
        public static final String AWS_MAX_ATTEMPTS_ENV_VAR= "AWS_MAX_ATTEMPTS";

        /**
         * @deprecated by {@link //SDKGlobalTime#setGlobalTimeOffset(int)}
         */
        @Deprecated
        public  static void setGlobalTimeOffset(int timeOffset) {
        //SDKGlobalTime.setGlobalTimeOffset(timeOffset);
    }



}
