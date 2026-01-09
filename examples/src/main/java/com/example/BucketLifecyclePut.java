package com.example;

import com.ibm.cos.v2.auth.credentials.AwsCredentials;
import com.ibm.cos.v2.auth.credentials.StaticCredentialsProvider;
import com.ibm.cos.v2.auth.credentials.ibmOAuth.BasicIBMOAuthCredentials;
import com.ibm.cos.v2.regions.Region;
import com.ibm.cos.v2.services.s3.S3Client;
import com.ibm.cos.v2.services.s3.model.*;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

/**
 * Before running this Java V2 code example, set up your development
 * environment, including your credentials.
 *
 * Prerequisite:
 *  - Create a bucket
 */
public class BucketLifecyclePut {
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
        putBucketLifecycle(client, bucketName);

        client.close();
        System.out.println("Done!");
    }

    /**
     * Put lifecycle configuration on a bucket.
     *
     * @param client the S3Client instance used to interact with the IBM COS service
     * @param bucketName the name of the COS bucket
     */
    private static void putBucketLifecycle(S3Client client, String bucketName) {
        Transition transition = Transition.builder()
                .days(30)
                .storageClass(StorageClass.GLACIER.toString())
                .build();

        List<Transition> transitions = new ArrayList<>();
        transitions.add(transition);

        LifecycleRuleFilter ruleFilter = LifecycleRuleFilter.builder()
                .prefix("")
                .build();

        LifecycleRule rule = LifecycleRule.builder()
                .id("test-lifecycle")
                .filter(ruleFilter)
                .transitions(transitions)
                .status(ExpirationStatus.ENABLED)
                .build();

        List<LifecycleRule> rules = new ArrayList<>();
        rules.add(rule);

        BucketLifecycleConfiguration lifecycleConfiguration = BucketLifecycleConfiguration.builder()
                .rules(rules)
                .build();

        PutBucketLifecycleConfigurationRequest putRequest = PutBucketLifecycleConfigurationRequest.builder()
                .bucket(bucketName)
                .lifecycleConfiguration(lifecycleConfiguration)
                .build();
        client.putBucketLifecycleConfiguration(putRequest);

        System.out.println("Lifecycle configuration has been successfully set on bucket " + bucketName);
    }
}
