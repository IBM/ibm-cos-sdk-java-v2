package com.ibm.cos.v2.stability.tests.s3;

import java.time.Duration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import com.ibm.cos.v2.http.async.SdkAsyncHttpClient;
import com.ibm.cos.v2.http.crt.AwsCrtAsyncHttpClient;
import com.ibm.cos.v2.retries.DefaultRetryStrategy;
import com.ibm.cos.v2.services.s3.S3AsyncClient;
import com.ibm.cos.v2.stability.tests.exceptions.StabilityTestsRetryableException;
import com.ibm.cos.v2.testutils.retry.RetryableTest;

/**
 * Stability tests for {@link S3AsyncClient} using {@link AwsCrtAsyncHttpClient}
 */
public class S3AsyncWithCrtAsyncHttpClientStabilityTest extends S3AsyncBaseStabilityTest {

    private static String bucketName = "s3withcrtasyncclientstabilitytests" + System.currentTimeMillis();

    private static S3AsyncClient s3CrtClient;

    static {
        int numThreads = Runtime.getRuntime().availableProcessors();
        SdkAsyncHttpClient.Builder httpClientBuilder = AwsCrtAsyncHttpClient.builder()
                .connectionMaxIdleTime(Duration.ofSeconds(5));

        s3CrtClient = S3AsyncClient.builder()
                .httpClientBuilder(httpClientBuilder)
                .credentialsProvider(CREDENTIALS_PROVIDER_CHAIN)
                .overrideConfiguration(b -> b.apiCallTimeout(Duration.ofMinutes(10))
                        // Retry at test level
                        .retryStrategy(DefaultRetryStrategy.doNotRetry()))
                .build();
    }

    public S3AsyncWithCrtAsyncHttpClientStabilityTest() {
        super(s3CrtClient);
    }

    @BeforeAll
    public static void setup() {
        s3CrtClient.createBucket(b -> b.bucket(bucketName)).join();
    }

    @AfterAll
    public static void cleanup() {
        deleteBucketAndAllContents(s3CrtClient, bucketName);
        s3CrtClient.close();
    }

    @Override
    protected String getTestBucketName() { return bucketName; }

    @RetryableTest(maxRetries = 3, retryableException = StabilityTestsRetryableException.class)
    public void getBucketAcl_lowTpsLongInterval_Crt() {
        doGetBucketAcl_lowTpsLongInterval();
    }
}
