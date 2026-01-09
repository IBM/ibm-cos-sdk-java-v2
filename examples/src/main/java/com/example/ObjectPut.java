package com.example;

import com.ibm.cos.v2.auth.credentials.AwsCredentials;
import com.ibm.cos.v2.auth.credentials.StaticCredentialsProvider;
import com.ibm.cos.v2.auth.credentials.ibmOAuth.BasicIBMOAuthCredentials;
import com.ibm.cos.v2.core.sync.RequestBody;
import com.ibm.cos.v2.regions.Region;
import com.ibm.cos.v2.services.s3.S3Client;
import com.ibm.cos.v2.services.s3.model.PutObjectRequest;

import java.io.File;
import java.net.URI;

/**
 * Before running this Java V2 code example, set up your development
 * environment, including your credentials.
 *
 * Prerequisite
 *  - Create a bucket.
 */
public class ObjectPut {
    public static void main(String[] args) {
        // Specify the region
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
        String objectPath = "path/to/file.txt";

        putObject(client, bucketName, objectKey, objectPath);

        client.close();
        System.out.println("Done!");
    }

    /**
     * Put an object in a COS bucket.
     *
     * @param client the S3Client instance used to interact with the IBM COS service
     * @param bucketName the name of the COS bucket
     * @param objectKey the name of the object to be uploaded
     * @param objectPath the local file path of the object to be uploaded
     */
    public static void putObject(S3Client client, String bucketName, String objectKey, String objectPath) {
        PutObjectRequest putObjectRequest = PutObjectRequest.builder()
                .bucket(bucketName)
                .key(objectKey)
                .build();
        client.putObject(putObjectRequest, RequestBody.fromFile(new File(objectPath)));

        System.out.println("Put object " + objectKey + " into bucket " + bucketName);
    }
}
