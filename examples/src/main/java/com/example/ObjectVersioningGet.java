package com.example;

import com.ibm.cos.v2.auth.credentials.AwsCredentials;
import com.ibm.cos.v2.auth.credentials.StaticCredentialsProvider;
import com.ibm.cos.v2.auth.credentials.ibmOAuth.BasicIBMOAuthCredentials;
import com.ibm.cos.v2.regions.Region;
import com.ibm.cos.v2.services.s3.S3Client;
import com.ibm.cos.v2.services.s3.model.GetBucketVersioningRequest;
import com.ibm.cos.v2.services.s3.model.GetBucketVersioningResponse;

import java.net.URI;

/**
 * Before running this Java V2 code example, set up your development
 * environment, including your credentials.
 *
 * Prerequisite
 *  - Create a bucket
 */
public class BucketVersionGet {
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
        getBucketVersioningStatus(client, bucketName);

        client.close();
        System.out.println("Done!");
    }

    /**
     * Get the bucket versioning status.
     *
     * @param client the S3Client instance used to interact with the IBM COS service
     * @param bucketName the name of the COS bucket
     */
    public static void getBucketVersioningStatus(S3Client client, String bucketName) {
        GetBucketVersioningRequest getBucketVersioningRequest = GetBucketVersioningRequest.builder()
                .bucket(bucketName)
                .build();
        GetBucketVersioningResponse response = client.getBucketVersioning(getBucketVersioningRequest);

        System.out.println("Bucket Versioning Status: " + response.statusAsString());
    }
}
