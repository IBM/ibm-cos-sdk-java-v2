package com.example;

import com.ibm.cos.v2.auth.credentials.AwsCredentials;
import com.ibm.cos.v2.auth.credentials.StaticCredentialsProvider;
import com.ibm.cos.v2.auth.credentials.ibmOAuth.BasicIBMOAuthCredentials;
import com.ibm.cos.v2.regions.Region;
import com.ibm.cos.v2.services.s3.S3Client;
import com.ibm.cos.v2.services.s3.model.CopyObjectRequest;

import java.net.URI;

/**
 * Before running this Java V2 code example, set up your development
 * environment, including your credentials.
 *
 * Prerequisite
 *  - Create a bucket
 *  - Upload an object
 */
public class ObjectCopy {
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

        String sourceBucket = "source-bucket";
        String sourceKey = "source-key";
        String destinationBucket = "destination-bucket";
        String destinationKey = "destination-key";

        copyObject(client, sourceBucket, sourceKey, destinationBucket, destinationKey);

        client.close();
        System.out.println("Done!");
    }

    /**
     * Get an object from bucket.
     *
     * @param client the S3Client instance used to interact with the IBM COS service
     * @param sourceBucket the name of the source bucket
     * @param sourceKey the name of the source object
     * @param destinationBucket the name of the destination bucket
     * @param destinationKey the name of the destination object
     */
    public static void copyObject(S3Client client, String sourceBucket, String sourceKey, String destinationBucket, String destinationKey) {
        CopyObjectRequest copyObjectRequest = CopyObjectRequest.builder()
                .sourceBucket(sourceBucket)
                .sourceKey(sourceKey)
                .destinationBucket(destinationBucket)
                .destinationKey(destinationKey)
                .build();
        client.copyObject(copyObjectRequest);

        System.out.println("Object copied successfully");
    }
}
