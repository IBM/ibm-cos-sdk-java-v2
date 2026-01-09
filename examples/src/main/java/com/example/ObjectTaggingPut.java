package com.example;

import com.ibm.cos.v2.auth.credentials.AwsCredentials;
import com.ibm.cos.v2.auth.credentials.StaticCredentialsProvider;
import com.ibm.cos.v2.auth.credentials.ibmOAuth.BasicIBMOAuthCredentials;
import com.ibm.cos.v2.regions.Region;
import com.ibm.cos.v2.services.s3.S3Client;
import com.ibm.cos.v2.services.s3.model.PutObjectTaggingRequest;
import com.ibm.cos.v2.services.s3.model.Tag;
import com.ibm.cos.v2.services.s3.model.Tagging;

import java.net.URI;

/**
 * Before running this Java V2 code example, set up your development
 * environment, including your credentials.
 *
 * Prerequisite:
 *  - Create a bucket.
 *  - Upload an object.
 */
public class ObjectTaggingPut {
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

        putObjectTagging(client, bucketName, objectKey);

        client.close();
        System.out.println("Done!");
    }

    /**
     * Put tags on an object
     *
     * @param client the S3Client instance used to interact with the IBM COS service
     * @param bucketName the name of the COS bucket
     * @param objectKey the name of the object to be uploaded
     */
    private static void putObjectTagging(S3Client client, String bucketName, String objectKey) {
        Tag tag1 = Tag.builder()
                .key("tagKey1")
                .value("tagValue1")
                .build();

        Tag tag2 = Tag.builder()
                .key("tagKey2")
                .value("tagValue2")
                .build();

        Tagging tagging = Tagging.builder()
                .tagSet(tag1, tag2)
                .build();

        PutObjectTaggingRequest putObjectTaggingRequest = PutObjectTaggingRequest.builder()
                .bucket(bucketName)
                .key(objectKey)
                .tagging(tagging)
                .build();
        client.putObjectTagging(putObjectTaggingRequest);

        System.out.println("Tags set to object: " + objectKey);
    }
}
