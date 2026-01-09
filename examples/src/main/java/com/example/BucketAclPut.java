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
public class BucketAclPut {
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

        // Use this method to set a canned acl
        putBucketAclCanned(client, bucketName);

        // Use this method to set an acl
        String id = "canonical-id";
        putBucketAclCustom(client, bucketName, id);

        client.close();
        System.out.println("Done!");
    }

    /**
     * Sets one of the predefined (canned) ACLs to a COS bucket.
     * This method is the simplest way to change a bucket's access control
     *
     * @param client the S3Client instance used to interact with the IBM COS service
     * @param bucketName the name of the COS bucket to create
     */
    private static void putBucketAclCanned(S3Client client, String bucketName) {
        PutBucketAclRequest putBucketAclRequest = PutBucketAclRequest.builder()
                .bucket(bucketName)
                .acl(BucketCannedACL.PUBLIC_READ)
                .build();
        client.putBucketAcl(putBucketAclRequest);

        System.out.println("Bucket ACL applied for bucket " + bucketName);
    }

    /**
     * Sets a fine-grained ACL on a bucket by constructing an AccessControlPolicy with explicit owners
     * and grants (grantee + permission).
     *
     * @param client the S3Client instance used to interact with the IBM COS service
     * @param bucketName the name of the COS bucket to create
     * @param id the ID of the IBM user or account that will be granted full control of the bucket
     */
    private static void putBucketAclCustom(S3Client client, String bucketName, String id) {
        Grantee canonicalUser = Grantee.builder()
                .id(id)
                .type(Type.CANONICAL_USER)
                .build();

        Grant ownerGrant = Grant.builder()
                .grantee(canonicalUser)
                .permission(Permission.FULL_CONTROL)
                .build();

        List<Grant> grants = new ArrayList<>();
        grants.add(ownerGrant);

        Owner owner = Owner.builder()
                .id(id)
                .build();
        AccessControlPolicy acl = AccessControlPolicy.builder()
                .owner(owner)
                .grants(grants)
                .build();

        PutBucketAclRequest putAclReq = PutBucketAclRequest.builder()
                .bucket(bucketName)
                .accessControlPolicy(acl)
                .build();
        client.putBucketAcl(putAclReq);

        System.out.println("Bucket ACL applied for bucket " + bucketName);
    }
}
