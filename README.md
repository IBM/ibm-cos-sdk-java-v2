# IBM Cloud Object Storage - Java SDK v2

This package allows Java developers to write software that interacts with [IBM Cloud Object Storage](https://www.ibm.com/cloud/object-storage).
It is a fork of the [AWS SDK for Java v2](https://github.com/aws/aws-sdk-java-v2) library and can stand as a drop-in replacement for applications that use S3-compatible APIs and do not depend on other AWS services.

***

## Feedback & Issue Reporting

We value your feedback! Please report any bugs or issues in the [GitHub Issues](https://github.com/ibm/ibm-cos-sdk-java-v2/issues/new) section.
Suggestions for enhancements and reports of unexpected behavior are welcome.

***

## Documentation

* [Core documentation for IBM COS](https://cloud.ibm.com/docs/cloud-object-storage?topic=cloud-object-storage-getting-started-cloud-object-storage)
* [Code Examples](./examples)
* [Java API reference documentation](https://ibm.github.io/ibm-cos-sdk-java-v2/)
* [REST API reference documentation](https://cloud.ibm.com/docs/cloud-object-storage/api-reference/about-api.html?group=api-reference)

For release notes, see the [CHANGELOG](CHANGELOG.md).

* [Getting the SDK](#getting-the-sdk)
* [Example code](#example-code)
* [Getting help](#getting-help)

***

## Quick Start

You'll need:

* An [IBM Cloud](https://cloud.ibm.com/registration) account.
* An instance of IBM Cloud Object Storage (COS).
* An IAM API key from [IBM Cloud API keys page](https://cloud.ibm.com/iam/apikeys) with at least `Writer` permissions.
* The service instance ID of your COS instance.
* IAM Token endpoint.
* Service endpoint.

These values can be found in the IBM Cloud UI by [generating a service credential](https://cloud.ibm.com/docs/services/cloud-object-storage/iam?topic=cloud-object-storage-service-credentials#service-credentials).

***

## Archive Tier Support

You can automatically archive objects after a specified length of time or after a specified date.
Once archived, a temporary copy of an object can be restored for access as needed. Restore time may take up to 15 hours.

An archive policy is set at the bucket level by calling the ``PutBucketLifecycleConfiguration`` method on a client instance.
A newly added or modified archive policy applies to new objects uploaded and does not affect existing objects.
For more detail, see the [IBM Cloud documentation](https://cloud.ibm.com/docs/cloud-object-storage?topic=cloud-object-storage-java).

## Accelerated Archive

Users can set an archive rule that would allow data restore from an archive in 2 hours or 12 hours.

***

## Immutable Object Storage

Users can configure buckets with an Immutable Object Storage policy to prevent objects from being modified or deleted for a defined period of time.
The retention period can be specified on a per-object basis, or objects can inherit a default retention period set on the bucket.
It is also possible to set open-ended and permanent retention periods.
Immutable Object Storage meets the rules set forth by the SEC governing record retention, and IBM Cloud administrators are unable to bypass these restrictions.
For more detail, see the [IBM Cloud documentation](https://cloud.ibm.com/docs/cloud-object-storage?topic=cloud-object-storage-java).

Note: Immutable Object Storage does not support Aspera transfers via the SDK to upload objects or directories at this stage.

***

## Getting the SDK

To begin using the SDK, add the dependency to your Maven project:

```xml
<dependency>
    <groupId>com.ibm.cos.v2</groupId>
    <artifactId>cos-java-sdk</artifactId>
    <version>1.0.0</version>
</dependency>
```

### Building from source

Once you check out the code from GitHub, you can build it using Maven:

```sh
mvn clean install -DskipTests=true
```

### Example Code

The following example demonstrates how to create a bucket using IAM authentication in IBM Cloud Object Storage using the v2 SDK and S3-compatible APIs.  
The SDK requires a minimum version of Java 8 or newer.

```java
package com.example;

import com.ibm.cos.v2.auth.credentials.AwsCredentials;
import com.ibm.cos.v2.auth.credentials.StaticCredentialsProvider;
import com.ibm.cos.v2.auth.credentials.ibmOAuth.BasicIBMOAuthCredentials;
import com.ibm.cos.v2.regions.Region;
import com.ibm.cos.v2.services.s3.S3Client;
import com.ibm.cos.v2.services.s3.model.CreateBucketRequest;

import java.net.URI;

// -------------------------------------------------------------------
// IBM COS Example - Create Bucket using API KEY with Java v2 SDK
// -------------------------------------------------------------------
public class BucketCreate {
    public static void main(String[] args) {
        String region = "us-south";
        String apiKey = "API_KEY";
        String serviceInstanceId = "RESOURCE_INSTANCE_ID";
        String cosEndpoint = "https://s3.us-south.cloud-object-storage.appdomain.cloud";

        // Create IBM COS credentials that the AWS SDK v2 can use via IBM’s adapter.
        AwsCredentials credentials = new BasicIBMOAuthCredentials(apiKey, serviceInstanceId);

        // Build the S3 client pointed at IBM COS.
        S3Client client = S3Client.builder()
                                  .endpointOverride(URI.create(cosEndpoint))
                                  .credentialsProvider(StaticCredentialsProvider.create(credentials))
                                  .region(Region.of(region))
                                  .build();

        // Create unique bucket name
        String bucketName = "test-bucket-v2-" + System.currentTimeMillis();

        // Create bucket input
        CreateBucketRequest bucketRequest = CreateBucketRequest.builder().bucket(bucketName).build();

        // Execute bucket creation
        client.createBucket(bucketRequest);
        System.out.println("Created bucket: " + bucketName);
        
        client.close();
    }
}
```

### Compile and run

```sh
mvn clean install
java -cp target/your-jar.jar BucketCreate
```

More examples can be found [examples directory](./examples).

***

## Getting Help

Feel free to use GitHub issues for tracking bugs and feature requests, but for help please use one of the following resources:

* Read a quick start guide in [IBM Cloud Docs](https://cloud.ibm.com/docs/cloud-object-storage?topic=cloud-object-storage-java).
* Ask a question on [Stack Overflow](https://stackoverflow.com/questions/tagged/object-storage+ibm) and tag it with `ibm` and `object-storage`.
* Open a support ticket with [IBM Cloud Support](https://cloud.ibm.com/unifiedsupport/supportcenter/)
* If it turns out that you may have found a bug, please [open an issue](https://github.com/ibm/ibm-cos-sdk-java-v2/issues/new).

***

## License

This SDK is distributed under the
[Apache License, Version 2.0](http://www.apache.org/licenses/LICENSE-2.0),
see LICENSE.txt and NOTICE.txt for more information.
