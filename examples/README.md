# COS SDK for Java (v2) code examples

To build and run these COS SDK for Java (v2) code examples, you need the following:

* An installation of [Apache Maven](https://maven.apache.org/) (>3.0)
* An instance of IBM COS.
* An API key
  from [IBM Cloud Identity and Access Management](https://cloud.ibm.com/docs/account?topic=account-userapikey&interface=ui)
  with at least `Writer` permissions.
* The ID of the instance of COS that you are working with.
* Token acquisition endpoint.
* Service endpoint.

These values can be found in the IBM Cloud UI
by [generating a service credential](https://cloud.ibm.com/docs/services/cloud-object-storage/iam?topic=cloud-object-storage-service-credentials#service-credentials).

## Build and run the examples

* Clone this repository and navigate to the `examples` folder:
```bash
   git clone https://github.ibm.com/cos-clevos/ibm-cos-sdk-java-v2.git
   cd examples
```

## Configuration Changes Required

Before running the examples, update the following values in the code or configuration file:

### 1. **Authentication Endpoint**

* **Default:** `https://iam.cloud.ibm.com/identity/token`

Update the IAM endpoint in your code:

```java
String authEndpoint = "https://iam.cloud.ibm.com/identity/token";

S3Client client = S3Client.builder()
        .endpointOverride(URI.create(cosEndpoint))
        .credentialsProvider(StaticCredentialsProvider.create(credentials))
        .region(Region.of(region))
        .iamEndpoint(authEndpoint)
        .build();
```

***

### 2. **Service Endpoint**

*   Each COS bucket is tied to a region. For example:
    *   `us-south`: `https://s3.us-south.cloud-object-storage.appdomain.cloud`
    *   `eu-de`: `https://s3.eu-de.cloud-object-storage.appdomain.cloud`

Update the endpoint in your code:

```java
String cosEndpoint = "https://s3.us-south.cloud-object-storage.appdomain.cloud";

S3Client client = S3Client.builder()
        .endpointOverride(URI.create(cosEndpoint))
        .credentialsProvider(StaticCredentialsProvider.create(credentials))
        .region(Region.of(region))
        .iamEndpoint(iamEndpoint)
        .build();
```

***

### 3. **Region**

Specify the region where your bucket resides:

```java
String region = "us-south";

S3Client client = S3Client.builder()
        .endpointOverride(URI.create(cosEndpoint))
        .credentialsProvider(StaticCredentialsProvider.create(credentials))
        .region(Region.of(region))
        .iamEndpoint(iamEndpoint)
        .build();
```

***

### 4. **Create IAM credentials**

Replace placeholders with your actual credentials:

```java
String apiKey = "<your-api-key>";
String serviceInstanceId = "<your-service-instance-id>";

AwsCredentials credentials = new BasicIBMOAuthCredentials(apiKey, serviceInstanceId);
```

***

### 5. **Create HMAC credentials**

Replace placeholders with your actual credentials:

```java
String accessKeyId = "<access-key-id>";
String secretAccessKey = "<secret-access-key>";

AwsCredentials credentials = AwsBasicCredentials.create(accessKeyId, secretAccessKey);
```

***

## Key Differences from SDK v1

*   **Client Builder:** v2 uses `S3Client.builder()` instead of `AmazonS3ClientBuilder`.
*   **Request/Response Objects:** Methods now use `PutObjectRequest`, `GetObjectRequest`, etc., from `com.ibm.cos.v2.services.s3.model`.
*   **Immutable Objects:** Most v2 request objects are immutable and use builders.
*   **Async Support:** v2 introduces `S3AsyncClient` for non-blocking operations.

***

## Example Classes

*   `ObjectPut.java` – Upload an object to a bucket
*   `ObjectGet.java` – Download an object from a bucket
*   `ObjectList.java` – List objects in a bucket
*   `ObjectDelete.java` – Delete an object from a bucket
*   For large file uploads, use **multipart upload** examples provided.

***

### How to Migrate from v1 to v2

Check the [Migration Guide]() for detailed differences and code snippets.

