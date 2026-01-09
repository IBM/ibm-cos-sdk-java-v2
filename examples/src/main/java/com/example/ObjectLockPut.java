package com.example;

import com.ibm.cos.v2.auth.credentials.AwsCredentials;
import com.ibm.cos.v2.auth.credentials.StaticCredentialsProvider;
import com.ibm.cos.v2.auth.credentials.ibmOAuth.BasicIBMOAuthCredentials;
import com.ibm.cos.v2.regions.Region;
import com.ibm.cos.v2.services.s3.S3Client;
import com.ibm.cos.v2.services.s3.model.ObjectLockMode;
import com.ibm.cos.v2.services.s3.model.ObjectLockRetention;
import com.ibm.cos.v2.services.s3.model.ObjectLockRetentionMode;
import com.ibm.cos.v2.services.s3.model.PutObjectRetentionRequest;

import java.net.URI;
import java.time.Instant;
import java.time.temporal.ChronoUnit;

/**
 * Before running this Java V2 code example, set up your development
 * environment, including your credentials.
 *
 * Prerequisite
 *  - Create a bucket with 'Object Lock' enabled (must be at creation time)
 *  - Enable versioning on bucket
 *  - Upload an object
 */
public class ObjectLockPut {
    public static void main(String[] args) {
        // IBM Cloud Object Storage region
        String region = "us-south";

        // IBM Cloud API key
        String apiKey = "API_KEY";

        // COS service instance/resource ID (CRN)
        String serviceInstanceId = "SERVICE_INSTANCE_ID";

        // COS Endpoint
        String cosEndpoint = "https://s3.us-south.cloud-object-storage.appdomain.cloud";

        // Create IBM COS credentials that the AWS SDK v2 can use via IBM’s adapter.
        AwsCredentials credentials = new BasicIBMOAuthCredentials(apiKey, serviceInstanceId);

        // Build the S3 client pointed at IBM COS.
        S3Client client = S3Client.builder()
                .endpointOverride(URI.create(cosEndpoint))
                .credentialsProvider(StaticCredentialsProvider.create(credentials))
                .region(Region.of(region))
                .build();

        String bucketName = "bucket-name";
        String objectKey = "object-key";

        putObjectWithRetention(client, bucketName, objectKey);

        client.close();
        System.out.println("Done!");
    }

    /**
     * Update the object with given lock mode and retention period
     *
     * @param client     the S3Client instance used to interact with the IBM COS service
     * @param bucketName the name of the COS bucket
     * @param objectKey  the name of the object
     */
    private static void putObjectWithRetention(S3Client client, String bucketName, String objectKey) {
        // Create an object lock mode: "COMPLIANCE" OR "GOVERNANCE".
        ObjectLockMode objectLockMode = ObjectLockMode.COMPLIANCE;

        // Create a retention period of 90 days.
        Instant retainUntil = Instant.now().plus(90, ChronoUnit.DAYS);

        // Create an object lock retention
        ObjectLockRetention objectLockRetention = ObjectLockRetention.builder()
                .mode(ObjectLockRetentionMode.COMPLIANCE)
                .retainUntilDate(retainUntil)
                .build();

        // Apply the retention on object
        PutObjectRetentionRequest putObjectRetentionRequest = PutObjectRetentionRequest.builder()
                .bucket(bucketName)
                .key(objectKey)
                .retention(objectLockRetention)
                .build();
        client.putObjectRetention(putObjectRetentionRequest);

        System.out.printf("Updated object with %s mode, retainUntil=%s%n", objectLockMode, retainUntil);
    }
}
