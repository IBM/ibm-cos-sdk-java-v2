package com.example;

import com.ibm.cos.v2.auth.credentials.AwsCredentials;
import com.ibm.cos.v2.auth.credentials.StaticCredentialsProvider;
import com.ibm.cos.v2.auth.credentials.ibmOAuth.BasicIBMOAuthCredentials;
import com.ibm.cos.v2.regions.Region;
import com.ibm.cos.v2.services.s3.S3Client;
import com.ibm.cos.v2.services.s3.model.CreateBucketRequest;

import java.net.URI;

/**
 * Before running this Java V2 code example, set up your development
 * environment, including your credentials.
 */
public class BucketCreate {
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

        // Generate a unique bucket name
        String prefix = "test-bucket-";
        String bucketName = prefix + System.currentTimeMillis();

        createBucket(client, bucketName);

        client.close();
        System.out.println("Done!");
    }

    /**
     * Create a bucket associated with the provided IBM COS client.
     *
     * @param client the S3Client instance used to interact with the IBM COS service
     * @param bucketName the name of the COS bucket to create
     */
    public static void createBucket(S3Client client, String bucketName) {
        CreateBucketRequest bucketRequest = CreateBucketRequest.builder()
                .bucket(bucketName)
                .build();
        client.createBucket(bucketRequest);

        System.out.println("Created bucket: " + bucketName);
    }
}
