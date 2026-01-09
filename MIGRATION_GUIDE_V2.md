# IBM Cloud Object Storage Java SDK: Migration Guide (v1 → v2)

## Introduction

This migration guide helps developers transition from the IBM Cloud Object Storage (S3-compatible) SDK for Java v1 to the new IBM COS SDK for Java v2.
The v2 SDK is a modernized, modular, and extensible rewrite.

Developers familiar with AWS SDK v2 patterns will find the new IBM COS v2 structure intuitive.
Meanwhile, applications written using the original v1 API may require updates in request/response model, client construction, streaming uploads, error handling, and credential management.

## Table of Contents

- [IBM Cloud Object Storage Java SDK: Migration Guide (v1 → v2)](#ibm-cloud-object-storage-java-sdk-migration-guide-v1--v2)
  - [Introduction](#introduction)
  - [Table of Contents](#table-of-contents)
  - [Understanding the Migration](#understanding-the-migration)
    - [Why a New SDK Version?](#why-a-new-sdk-version)
    - [Overview of steps](#overview-of-steps)
  - [Project Setup](#project-setup)
    - [Java Version Requirements](#java-version-requirements)
    - [Working with Maven](#working-with-maven)
    - [Declaring SDK for JAVA v2 as dependency](#declaring-sdk-for-java-v2-as-dependency)
  - [Configuring service clients](#configuring-service-clients)
    - [Creating a service client](#creating-a-service-client)
      - [Client configuration example](#client-configuration-example)
        - [Example of client configuration in v1](#example-of-client-configuration-in-v1)
        - [Example of synchronous client configuration in v2](#example-of-synchronous-client-configuration-in-v2)
        - [Example of asynchronous client configuration in v2](#example-of-asynchronous-client-configuration-in-v2)
      - [Example for creating IAM Client](#example-for-creating-iam-client)
      - [Example for creating HMAC Client](#example-for-creating-hmac-client)
      - [Client Override Configuration](#client-override-configuration)
    - [Credential Provider](#credential-provider)
      - [AWSCredentialsProvider](#awscredentialsprovider)
      - [DefaultAWSCredentialsProviderChain](#defaultawscredentialsproviderchain)
      - [AWSStaticCredentialsProvider](#awsstaticcredentialsprovider)
      - [EnvironmentVariableCredentialsProvider](#environmentvariablecredentialsprovider)
      - [SystemPropertiesCredentialsProvider](#systempropertiescredentialsprovider)
      - [ProfileCredentialsProvider](#profilecredentialsprovider)
    - [Trust-All Certificates (Self-Signed TLS)](#trust-all-certificates-self-signed-tls)
  - [Migrating common operations, requests and responses](#migrating-common-operations-requests-and-responses)
    - [Date parameter changes](#date-parameter-changes)
    - [Timeout parameter changes](#timeout-parameter-changes)
    - [Streaming operation](#streaming-operation)
      - [Put Object with Metadata:](#put-object-with-metadata)
    - [Serialization differences between v1 and v2 of IBM COS SDK](#serialization-differences-between-v1-and-v2-of-ibm-cos-sdk)
    - [Deserialization differences between v1 and v2 of IBM COS SDK](#deserialization-differences-between-v1-and-v2-of-ibm-cos-sdk)
      - [Empty Collections in V2 compared to `nulls` in V1](#empty-collections-in-v2-compared-to-nulls-in-v1)
  - [Exception Changes](#exception-changes)
  - [S3 Operation Changes](#s3-operation-changes)
  - [Operational Examples](#operational-examples)
    - [Create Request](#create-request)
    - [Adding a Custom Header](#adding-a-custom-header)
    - [List Objects From an S3 Bucket](#list-objects-from-an-s3-bucket)
    - [Access Control List (ACL)](#access-control-list-acl)
      - [Example for creating Grant](#example-for-creating-grant)
      - [V1's setBucketAcl() to V2's putBucketAcl()](#v1s-setbucketacl-to-v2s-putbucketacl)
      - [Getting Bucket Grants](#getting-bucket-grants)
      - [Operation with Canned ACL](#operation-with-canned-acl)
      - [V1 to V2 Mappings for BucketACL](#v1-to-v2-mappings-for-bucketacl)
      - [Example to check if Owner has FULL\_ACCESS](#example-to-check-if-owner-has-full_access)
      - [Object Level ACL](#object-level-acl)
        - [Example for setObjectAcl with Canned ACL](#example-for-setobjectacl-with-canned-acl)
        - [Getting Object Grants](#getting-object-grants)
    - [GetObject in V2](#getobject-in-v2)
      - [V1’s withMatchingETagConstraint to V2’s ifMatch() while building the request](#v1s-withmatchingetagconstraint-to-v2s-ifmatch-while-building-the-request)
      - [V1’s withModifiedSinceConstraint() to V2’s .ifModifiedSince(Instant)](#v1s-withmodifiedsinceconstraint-to-v2s-ifmodifiedsinceinstant)
      - [Example to work with Response Input Stream](#example-to-work-with-response-input-stream)
    - [getObjectAsString()](#getobjectasstring)
    - [ListObjectsV2](#listobjectsv2)
      - [To work with ListObjectsV2Response and S3Object.](#to-work-with-listobjectsv2response-and-s3object)
      - [CHANGES: (wrt Listing Objects)](#changes-wrt-listing-objects)
    - [Deleting Object](#deleting-object)
    - [Delete Object Request with Keys](#delete-object-request-with-keys)
    - [Deleting Bucket](#deleting-bucket)
    - [Deleting Objects and Buckets](#deleting-objects-and-buckets)
    - [Head Bucket](#head-bucket)
    - [Bucket Exist](#bucket-exist)
    - [List of Global properties removed](#list-of-global-properties-removed)
    - [Bucket Tagging](#bucket-tagging)
      - [API CHANGES](#api-changes)
      - [Example for Bucket Tagging (setBucketTaggingConfiguration, getBucketTagging)](#example-for-bucket-tagging-setbuckettaggingconfiguration-getbuckettagging)
    - [Multipart](#multipart)
      - [V1's initiateMultipartUpload to V2's createMultipartUpload](#v1s-initiatemultipartupload-to-v2s-createmultipartupload)
      - [Implementation differences](#implementation-differences)
      - [Multipart Full Example](#multipart-full-example)
      - [Multipart upload using Input Stream (Simpler way)](#multipart-upload-using-input-stream-simpler-way)
    - [Copy Request](#copy-request)
      - [Example for copying from source Bucket to Destination bucket](#example-for-copying-from-source-bucket-to-destination-bucket)
      - [Metadata behavior in SDK v2 during Copy Request](#metadata-behavior-in-sdk-v2-during-copy-request)
    - [Website Configuration](#website-configuration)
    - [Pre signed URL](#pre-signed-url)
    - [CORS](#cors)
      - [To create CORS rule](#to-create-cors-rule)
      - [Set bucket CORS config](#set-bucket-cors-config)
    - [Versioned Object Deletion](#versioned-object-deletion)
    - [System Properties](#system-properties)
    - [ProfileCredentialsProvider](#profilecredentialsprovider-1)
    - [S3 Transfer Manager](#s3-transfer-manager)
    - [IBM Supported Features](#ibm-supported-features)
      - [Bucket Protection (WORM)](#bucket-protection-worm)
        - [1. setBucketProtectionConfiguration()](#1-setbucketprotectionconfiguration)
        - [2. getBucketProtection()](#2-getbucketprotection)
        - [3. addLegalHold()](#3-addlegalhold)
        - [4. listLegalHolds()](#4-listlegalholds)
        - [5. deleteLegalHold()](#5-deletelegalhold)
      - [Key Protect (SSE-KMS)](#key-protect-sse-kms)
      - [Extended Listing](#extended-listing)
  - [Best practices for using the IBM COS SDK for Java v2](#best-practices-for-using-the-ibm-cos-sdk-for-java-v2)

-----

## Understanding the Migration

### Why a New SDK Version?

IBM Cloud Object Storage SDK for Java v1 was based on the AWS SDK for Java v1 architecture. While functional, the v1 SDK relied on:

- mutable request objects
- non-reactive, blocking I/O
- an older execution pipeline
- manual credential handling patterns
- legacy internal models (ACLs, metadata)
- Managing IAM tokens is manual

The new IBM COS SDK for Java v2 is a re-architecture aligned with the AWS SDK v2 runtime, bringing:

- Immutable builders for all request & response models
- Modernized HTTP stack (Netty or Apache clients)
- Better async support (`S3AsyncClient` + `TransferManager`)
- Cleaner credential provider system
- Stricter validation (headers, metadata, ranges)
- More consistent error handling
- IAM is handled by `IamAuthenticator` using IBM Cloud SDK Core

The goal is long-term compatibility with the AWS v2 ecosystem while preserving IBM-specific capabilities such as IAM authentication, WORM.

### Overview of steps

The IBM COS SDK for Java v2 introduces significant changes to the S3 client, including a new package structure, updated class names, and revised method signatures.

1. Begin by adding the SDK for Java v2 depedency to POM

2. Replace v1 class import statement: All import statements will be from the `com.ibm.cos.v2` package.
   > For S3Client: Replace the import

   ```java
     import com.ibm.cloud.objectstorage.services.s3.AmazonS3;
   ```

   with

   ```java  
     import com.ibm.cos.v2.services.s3.S3Client;
   ```

3. Change v1 constructors to v2 builders.
4. Replace v1 `Result` response objects with v2 `Response` equivalents.
    - A consistent difference between v1 and v2 is that all response objects in v2 end with `Response` instead of `Result`.
5. Make API changes:
    - Setter methods do not use the `set` or `with` prefix.
    - Getter methods prefixed with `get` are also gone.
Instead we use the field names.

| Area          | v1 (Old SDK)                    | v2 (New SDK)                         |
|---------------|---------------------------------|--------------------------------------|
| Request Model | POJO + setters                  | Immutable builder classes            |
| Client        | `AmazonS3Client`                | `S3Client` / `S3AsyncClient`         |
| Streaming     | `InputStream` via constructor   | `RequestBody.fromXxx(...)`           |
| ACLs          | Canonical/Group grantee classes | Enum-based Type + `IBMAclGrantee`    |
| Exceptions    | v1-style S3 exceptions          | Modernized `S3Exception` hierarchy   |
| Range Header  | numeric setters                 | String format: `"bytes=offset-size"` |

This guide focuses on direct code mapping so you can update applications with minimum confusion.

-----

## Project Setup

### Java Version Requirements

You need the following Java development environment requirements to work with SDK for Java v2:

- Requires **Java 8 or later**. You can download Java SE Development Kit software from - [oracle](http://www.oracle.com/technetwork/java/javase/downloads/)
- **Apache Maven.** A Maven-compatible build tool such as Apache Maven.
  - If you need to install Maven, go to [Maven](http://maven.apache.org/) to download and install it.

### Working with Maven

#### Configure Java compiler for Maven

If you create your project with a different archetype or by using another method,
you must ensure that the Maven compiler plugin is part of the build and that its source and target properties are both set to `1.8` in the `pom.xml` file.

Refer to below snippet for one way to configure these required setting:

```xml
<project>
    <properties>
        <maven.compiler.source>1.8</maven.compiler.source>
        <maven.compiler.target>1.8</maven.compiler.target>
    </properties>
    <build>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
                <version>${maven.compiler.plugin.version}</version>
            </plugin>
        </plugins>
    </build>
</project>
```

Alternatively, you can configure the compiler configuration inline with the plugin declaration, as follows:

```xml
<project>
    <build>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
                <configuration>
                    <source>1.8</source>
                    <target>1.8</target>
                </configuration>
            </plugin>
        </plugins>
    </build>
</project>
```

### Declaring SDK for JAVA v2 as dependency

To use the IBM COS SDK for Java in your project, you need to declare it as a dependency in your project’s `pom.xml` file.

#### IBM COS v1

```xml
<dependency>
    <groupId>com.ibm.cos</groupId>
    <artifactId>ibm-cos-java-sdk</artifactId>
    <version>v1.x</version>
</dependency>
```

#### IBM COS v2

v2 uses modularized components, now that you have configured the SDK, you can add dependencies for one or more of the IBM COS SDK for Java modules to use in your project.

```xml
<project>
    <dependencies>
        <dependency>
            <groupId>com.ibm.cos.v2</groupId>
            <artifactId>s3</artifactId>
            <version>0.0.1</version>
            <exclusions>
                <exclusion>
                    <groupId>com.ibm.cos.v2</groupId>
                    <artifactId>netty-nio-client</artifactId>
                    <version>0.0.1</version>
                </exclusion>
                <exclusion>
                    <groupId>com.ibm.cos.v2</groupId>
                    <artifactId>apache-client</artifactId>
                    <version>0.0.1</version>
                </exclusion>
            </exclusions>
        </dependency>
    </dependencies>
</project>
```

#### Build the entire SDK into your project

To optimize your application, we strongly recommend that you pull in only the components you need instead of the entire SDK. However, to build the entire IBM COS SDK for Java into your project, declare it in your `pom.xml` file, as follows.

```xml
<project>
    <dependencies>
        <dependency>
            <groupId>com.ibm.cos.v2</groupId>
            <artifactId>cos-java-sdk</artifactId>
            <version>0.0.1</version>
        </dependency>
    </dependencies>
</project>
```

#### In the Java files, incrementally change over the v1 classes to v2 classes

As you replace v1 classes with v2 classes, make the necessary changes to support the v2 API such as using builders instead of constructors and using fluent getters and setters.

#### Remove v1 Maven dependencies from the POM and v1 imports from files

After you migrate your code to use v2 classes, remove any leftover v1 imports from files and all dependencies from your build file.

#### Build your Project

After you configure the `pom.xml` file, you can use Maven to build your project. To build your Maven project from the command line, open a terminal or command prompt window, navigate to your project directory (for example, `myTestApp`), enter or paste the following command,

```sh
mvn clean package
```

-----

## Configuring service clients

To programmatically access IBM COS services, the SDK uses a client. A service client object is immutable.

### Creating a service client

Client creation is one of the biggest changes between IBM COS Java SDK v1 and v2. v1 used a mutable builder pattern based on IBM COS SDK v1 (`AmazonS3ClientBuilder`).
v2 uses immutable clients, immutable requests, and modern HTTP client builders.

In v2, the following changes have been made to the default client creation logic.

- The default credential provider chain for S3 no longer includes anonymous credentials.
- You must manually specify anonymous access to S3 by using the `AnonymousCredentialsProvider`.
- v2 does not support the property -> `SDKGlobalConfiguration.DISABLE_CERT_CHECKING_SYSTEM_PROPERTY`.

#### Client configuration example

In v1, SDK client configuration was modified by setting a `ClientConfiguration` instance on the client or client builder.
In v2, the client configuration is split into separate configuration classes.
With the separate configuration classes, you can configure different HTTP clients for async versus synchronous clients.

#### Example of client configuration in v1

```java
AmazonS3ClientBuilder.standard()
    .withClientConfiguration(clientConfiguration)
    .build()
```

#### Example of synchronous client configuration in v2

```java
ProxyConfiguration.Builder proxyConfig = ProxyConfiguration.builder();

ApacheHttpClient.Builder httpClientBuilder =
    ApacheHttpClient.builder()
                    .proxyConfiguration(proxyConfig.build());

ClientOverrideConfiguration.Builder overrideConfig =
    ClientOverrideConfiguration.builder();

S3Client client = S3Client.builder()
                          .httpClientBuilder(httpClientBuilder)
                          .overrideConfiguration(overrideConfig.build())
                          .build();
```

#### Example of asynchronous client configuration in v2

```java
NettyNioAsyncHttpClient.Builder httpClientBuilder =
    NettyNioAsyncHttpClient.builder();

ClientOverrideConfiguration.Builder overrideConfig =
    ClientOverrideConfiguration.builder();

ClientAsyncConfiguration.Builder asyncConfig =
    ClientAsyncConfiguration.builder();

S3Client client = S3Client.builder()
                          .httpClientBuilder(httpClientBuilder)
                          .overrideConfiguration(overrideConfig.build())
                          .asyncConfiguration(asyncConfig.build())
                          .build();
```

#### Example for creating IAM Client

#### IBM COS v1

```java
//Setting IAM_ENDPOINT via Global variable
SDKGlobalConfiguration.IAM_ENDPOINT = "https://iam.cloud.ibm.com/identity/token";

String endpointUrl = <YOUR_ENDPOINT_URL>;
String location = <YOUR_LOCATION>;

AWSCredentials credentials;
credentials = new BasicIBMOAuthCredentials(api_key, service_instance_id);

//Initializes the Amazon S3 client builder
AmazonS3 cosClient = AmazonS3ClientBuilder.standard()
                                          .withCredentials(new AWSStaticCredentialsProvider(credentials))
                                          .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(endpoint_url, location))
                                          .build();
```

#### IBM COS v2

**Key Change:**

- V2 clients are **immutable**, **thread-safe**, and use **builder configuration**.
- HTTP configuration is split across `ApacheHttpClient` and `ClientOverrideConfiguration`.
- Endpoint override uses `endpointOverride(URI)` instead of `EndpointConfiguration`.
- Path style access moved under `S3Configuration`.

```java
// Option-1: Setting IAM_ENDPOINT via Global variable
SDKGlobalConfiguration.IAM_ENDPOINT = "https://iam.cloud.ibm.com/identity/token";

String endpointUrl = <YOUR_ENDPOINT_URL>;
String location = <YOUR_LOCATION>;

// Wrap IBM OAuth credentials in a provider
AwsCredentialsProvider credentials =
    StaticCredentialsProvider.create(new BasicIBMOAuthCredentials(api_key, service_instance_id));

S3Client cosClient = S3Client.builder()
                             .credentialsProvider(credentials)
                             .endpointOverride(URI.create(endpointUrl))   //custom IBM COS endpoint
                             .region(Region.of(location))
                             .iamEndpoint("iamEndPoint")     //option-2: to set iamEndpoint
                             .build();
```

> Note: `com.ibm.cloud.objectstorage.oauth.DefaultTokenManager` and `com.ibm.cloud.objectstorage.oauth.DefaultTokenProvider` are removed.

#### Example for creating HMAC Client

#### IBM COS V1

```java
String endpointUrl = <YOUR_ENDPOINT_URL>;
String location = <YOUR_LOCATION>;

BasicAWSCredentials credentials = new BasicAWSCredentials(accessKeyId, secretAccessKey);

//Initializes the Amazon S3 client builder
AmazonS3 cosClient = AmazonS3ClientBuilder.standard()
                                          .withCredentials(new AWSStaticCredentialsProvider(credentials))
                                          .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(endpoint_url, location))
                                          .build();
```

#### IBM COS V2

```java
String endpointUrl = <YOUR_ENDPOINT_URL>;
String location = <YOUR_LOCATION>;

AwsCredentialsProvider credentialsProvider = StaticCredentialsProvider.create
                                                                          (AwsBasicCredentials.create(accessKey, secretKey));

S3Client cosClient = S3Client.builder()
                             .credentialsProvider(credentials)
                             .endpointOverride(URI.create(endpoint_url))
                             .region(Region.of(location))
                             .build();
```

### Client Override Configuration

These below changes are only at client level, not at request level.

### Http Clients

#### Notable changes

- In v2, you can change which HTTP client to use at runtime by specifying an implementation using `clientBuilder.httpClientBuilder`.
- When you pass an HTTP client by using `clientBuilder.httpClient` to a service client builder, the HTTP client is not closed by default if the service client closes.
- This allows you to share HTTP clients between service clients.
- Asynchronous HTTP clients now use non-blocking IO.
- Some operations now use HTTP/2 for improved performance.

**Settings changes:**

| Change Category    | V1                                                                                    | V2 (Sync, Apache)                                                         |
|--------------------|---------------------------------------------------------------------------------------|---------------------------------------------------------------------------|
| Initialization     | `ClientConfiguration clientConfig = new ClientConfiguration()`                        | `ApacheHttpClient.Builder httpClientBuilder = ApacheHttpClient.builder()` |
| Max Connections    | `clientConfig.setMaxConnections(...)` or `clientConfig.withMaxConnections(...)`       | `httpClientBuilder.maxConnections(...)`                                   |
| Connection Timeout | `clientConfig.setConnectionTimeout(...)` or `clientConfig.withConnectionTimeout(...)` | `httpClientBuilder.connectionTimeout(...)`                                |
| Socket Timeout     | `clientConfig.setSocketTimeout(...)` or `clientConfig.withSocketTimeout(...)`         | `httpClientBuilder.socketTimeout(...)`                                    |

-----

**Client Overrides:**

| Change Category    | V1                                                              | V2                                                                                           |
|--------------------|-----------------------------------------------------------------|----------------------------------------------------------------------------------------------|
| Initialization     | `ClientConfiguration clientConfig = new ClientConfiguration()`  | `ClientOverrideConfiguration.Builder overrideConfig = ClientOverrideConfiguration.builder()` |
| Additional Headers | `clientConfig.addHeader(...)` or `clientConfig.withHeader(...)` | `overrideConfig.putHeader(...)`                                                              |

-----

**Client Override Retry Configuration:**

| Change Category | V1                                                                            | V2                                                                                                          |
|-----------------|-------------------------------------------------------------------------------|-------------------------------------------------------------------------------------------------------------|
| Initialization  | `ClientConfiguration clientConfig = new ClientConfiguration()`                | `ClientOverrideConfiguration.Builder overrideConfigBuilder = ClientOverrideConfiguration.builder()`         |
| Max error retry | `clientConfig.setMaxErrorRetry(...)` or `clientConfig.withMaxErrorRetry(...)` | // Configure the default retry strategy.  `overrideConfigBuilder.retryStrategy(b -> b.maxAttempts(...));` |

-----

**Client HTTP Proxy Configuration:**

| Change Category | V1                                                                    | V2                                                                      |
|-----------------|-----------------------------------------------------------------------|-------------------------------------------------------------------------|
| Initialization  | `ClientConfiguration clientConfig = new ClientConfiguration()`        | `ProxyConfiguration.Builder proxyConfig = ProxyConfiguration.builder()` |
| Proxy Host      | `clientConfig.setProxyHost(...)` or `clientConfig.withProxyHost(...)` | `proxyConfig.endpoint(...)`                                             |
| Proxy Port      | `clientConfig.setProxyPort(...)` or `clientConfig.withProxyPort(...)` | `proxyConfig.endpoint(...)`                                             |

-----

#### Notable differences

- The default credentials provider loads system properties before environment variables in version  v2 (In version 1, default credentials provider loads environment variables before system properties).

- The constructor method is replaced with the `create` or `builder` methods.

  - `DefaultCredentialsProvider.create();`

-----

## Credential Provider

### AWSCredentialsProvider

| Change Category    | V1                                                        | V2                                                                    |
|--------------------|-----------------------------------------------------------|-----------------------------------------------------------------------|
| Package/class name | `com.ibm.cloud.objectstorage.auth.AWSCredentialsProvider` | `com.ibm.cos.v2.auth.credentials.AwsCredentialsProvider` |
| Method name        | `getCredentials`                                          | `resolveCredentials`                                                  |
| Unsupported method | `refresh`                                                 | Not supported                                                         |

-----

### DefaultAWSCredentialsProviderChain

| Change Category                     | V1                                                                    | V2                                                                        |
|-------------------------------------|-----------------------------------------------------------------------|---------------------------------------------------------------------------|
| Package/class name                  | `com.ibm.cloud.objectstorage.auth.DefaultAWSCredentialsProviderChain` | `com.ibm.cos.v2.auth.credentials.DefaultCredentialsProvider` |
| Creation                            | `new DefaultAWSCredentialsProviderChain`                              | `DefaultCredentialsProvider.create`                                       |
| Unsupported method                  | `getInstance`                                                         | Not supported                                                             |
| Priority order of external settings | Environment variables before system properties                        | System properties before environment variables                            |

-----

### AWSStaticCredentialsProvider

| Change Category    | V1                                                              | V2                                                                       |
|--------------------|-----------------------------------------------------------------|--------------------------------------------------------------------------|
| Package/class name | `com.ibm.cloud.objectstorage.auth.AWSStaticCredentialsProvider` | `com.ibm.cos.v2.auth.credentials.StaticCredentialsProvider` |
| Creation           | `new AWSStaticCredentialsProvider`                              | `StaticCredentialsProvider.create`                                       |

-----

### EnvironmentVariableCredentialsProvider

| Change Category           | V1                                                                            | V2                                                                                            |
|---------------------------|-------------------------------------------------------------------------------|-----------------------------------------------------------------------------------------------|
| Package/class name        | `com.ibm.cloud.objectstorage.auth.EnvironmentVariableCredentialsProvider`     | `com.ibm.cos.v2.auth.credentials.EnvironmentVariableCredentialsProvider`         |
| Creation                  | `new EnvironmentVariableCredentialsProvider`                                  | `EnvironmentVariableCredentialsProvider.create`                                               |
| Environment variable name | `AWS_ACCESS_KEY`  `SDKGlobalConfiguration.ACCESS_KEY_ENV_VAR`               | `AWS_ACCESS_KEY_ID`    `SdkSystemSetting.AWS_ACCESS_KEY_ID.environmentVariable()`             |
| Environment variable name | `AWS_SECRET_KEY`  `SDKGlobalConfiguration.SECRET_KEY_ENV_VAR`               | `AWS_SECRET_ACCESS_KEY`  `SdkSystemSetting.AWS_SECRET_ACCESS_KEY.environmentVariable()`     |
| Environment variable name | `IBM_API_KEY_ID`  `SDKGlobalConfiguration.IBM_API_KEY`                      | `IBM_API_KEY_ID`  `SdkSystemSetting.IBM_API_KEY_ID.environmentVariable()`                   |
| Environment variable name | `IBM_SERVICE_INSTANCE_ID`  `SDKGlobalConfiguration.IBM_SERVICE_INSTANCE_ID` | `IBM_SERVICE_INSTANCE_ID`  `SdkSystemSetting.IBM_SERVICE_INSTANCE_ID.environmentVariable()` |

-----

### SystemPropertiesCredentialsProvider

| Change Category           | V1                                                                                                                                    | V2                                                                                                                         |
|---------------------------|---------------------------------------------------------------------------------------------------------------------------------------|----------------------------------------------------------------------------------------------------------------------------|
| Package/class name        | `com.ibm.cloud.objectstorage.auth.SystemPropertiesCredentialsProvider`                                                                | `com.ibm.cos.v2.auth.credentials.SystemPropertiesCredentialsProvider`                                         |
| Creation                  | `new SystemPropertiesCredentialsProvider`                                                                                             | `SystemPropertiesCredentialsProvider.create`                                                                               |
| Environment variable name | `aws.accessKeyId`  `System.setProperty(SDKGlobalConfiguration.ACCESS_KEY_SYSTEM_PROPERTY, API_KEY);`                                | `aws.accessKeyId`    `System.setProperty(SdkSystemSetting.AWS_ACCESS_KEY_ID.property(), ACCESS_KEY);`                      |
| Environment variable name | `aws.secretKey`  `System.setProperty(SDKGlobalConfiguration.SECRET_KEY_SYSTEM_PROPERTY, API_KEY);`                                  | `aws.secretAccessKey`    `System.setProperty(SdkSystemSetting.AWS_SECRET_ACCESS_KEY.property(), SECRET_ACCESS_KEY);`       |
| Environment variable name | `ibm.apiKeyId`  `System.setProperty(SDKGlobalConfiguration.IBM_API_KEY_SYSTEM_PROPERTY, API_KEY);`                                  | `ibm.apiKeyId`    `System.setProperty(SdkSystemSetting.IBM_API_KEY_ID.property(), API_KEY);`                               |
| Environment variable name | `ibm.serviceInstanceId`    `System.setProperty(SDKGlobalConfiguration.IBM_SERVICE_INSTANCE_ID_SYSTEM_PROPERTY, SERVICE_INSTANCE_ID);` | `ibm.serviceInstanceId`    `System.setProperty(SdkSystemSetting.IBM_SERVICE_INSTANCE_ID.property(), SERVICE_INSTANCE_ID);` |

-----

### ProfileCredentialsProvider

| Change Category            | V1                                                                                 | V2                                                                                                                                                                                                                                                                             |
|----------------------------|------------------------------------------------------------------------------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Package/class name         | `com.ibm.cloud.objectstorage.auth.ProfileCredentialsProvider`                      | `com.ibm.cos.v2.auth.credentials.ProfileCredentialsProvider`                                                                                                                                                                                                                   |
| Creation                   | `new ProfileCredentialsProvider`                                                   | `ProfileCredentialsProvider.create`                                                                                                                                                                                                                                            |
| Location of custom profile | `AWS_CREDENTIAL_PROFILES_FILE` environment variable                                | `AWS_SHARED_CREDENTIALS_FILE` environment variable                                                                                                                                                                                                                             |
|Example                    | `AWSCredentialsProvider provider = new ProfileCredentialsProvider(VALID_PROFILE);` | `ProfileFile profileFile = ProfileFile.builder().content(Paths.get(VALID_PROFILE)) // Same as ~/.aws/credentials .type(ProfileFile.Type.CREDENTIALS).build();`  `ProfileCredentialsProvider provider = ProfileCredentialsProvider.builder().profileFile(profileFile).build();` |

-----

#### Additional Changes

**Class removed:** `com.ibm.cloud.objectstorage.auth.PropertiesFileCredentialsProvider`

**What changed?** In SDK v1, `PropertiesFileCredentialsProvider` allowed loading credentials from a Java `.properties`
file without requiring an AWS-style profile section.

In SDK v2, this class has been removed. Credential loading from files now only supports AWS profile (INI) format via `ProfileCredentialsProvider.`

#### SDK v1 example

```java
ibm.apiKeyId=xxxx
ibm.serviceInstanceId=yyyy

AWSCredentialsProvider provider =
    new PropertiesFileCredentialsProvider("credentials.properties");
```

#### SDK v2 example

```ini
[default]
ibm_api_key_id=xxxx
ibm_service_instance_id=yyyy
```

```java
ProfileFile profileFile = ProfileFile.builder()
                                     .content(Paths.get("~/.aws/credentials"))
                                     .type(ProfileFile.Type.CREDENTIALS)
                                     .build();

ProfileCredentialsProvider provider =
    ProfileCredentialsProvider.builder()
                              .profileFile(profileFile)
                              .build();

```

## Trust-All Certificates (Self-Signed TLS)

v1 had internal `TrustingX509TrustManager`. It was done with setting variable -> `SDKGlobalConfiguration.DISABLE_CERT_CHECKING_SYSTEM_PROPERTY`

v2 requires explicitly providing your own.

```java
SdkHttpClient sdkHttpClient = ApacheHttpClient.builder()
                                              .buildWithDefaults(AttributeMap.builder()
                                                                             .put(SdkHttpConfigurationOption.TRUST_ALL_CERTIFICATES, true) //TrustAllCertificates enabled
                                                                             .build());

// Build S3 Client passing 'sdkHttpClient' to httpClient() builder method
S3Client client = S3Client.builder()
                          .httpClient(sdkHttpClient)
                          .build();
```

>**Note:** This is insecure and should only be used in controlled development environments.

-----

## Migrating common operations, requests and responses

This section covers the most-used IBM COS operations and their direct v1 → v2 equivalents.

Java SDK v2 has the following changes from v1.

- **Paginated S3 operations**: S3 operations with multiple response pages now have a `Paginator` method for automatically iterating over all items in the response.
- You cannot mutate requests and responses.
- S3 request and response types in IBM COS SDK v2 are constructed via static builder methods instead of public constructors, so patterns like `new PutObjectRequest().withBucketName(...)` become `PutObjectRequest.builder().bucket(bucketName)...build()`.
- S3 operations support a short-hand way to create requests: `s3Client.putObject(r -> r.bucket(bucket).key(key))`.

### Date parameter changes

In v1, many operations accepted `java.util.Date` objects for time-based parameters.
In v2, these operations use `java.time.Instant` objects instead as it is immutable and thread-safe, also to align with Java 8+ best practices.
You can convert `Date` parameters by calling the `toInstant()` method on your `Date` object.

**Example in V1:**

```java
Date expiration = new Date(System.currentTimeMillis() + 3600000);
```

**Example in V2:**

```java
Date expiration = new Date(System.currentTimeMillis() + 3600000);
expiration.toInstant() //to convert to instant
```

### Timeout parameter changes

In v1, timeout values were specified as integer values representing milliseconds.
In v2, timeout parameters use `java.time.Duration` objects for better type safety and clarity.
You can convert numeric timeout values by wrapping your numeric values with the appropriate `Duration` factory method.

### Example - Set a request timeout in version 1

```java
// Set request timeout in milliseconds
ClientConfiguration clientConfiguration = new ClientConfiguration();
clientConfiguration.setRequestTimeout(5000);  // 5 seconds
```

### Example - Set a request timeout in version 2

```java
// Set request timeout using Duration
ClientConfiguration clientConfiguration = new ClientConfiguration();
clientConfiguration.setRequestTimeout(Duration.ofMillis(5000));// 5 seconds

    // Or more clearly:
    clientConfiguration.setRequestTimeout(Duration.ofSeconds(5));// 5 seconds
```

You can use the following `Duration` factory methods for timeout values:

- `Duration.ofMillis(long millis)` - For millisecond values.
- `Duration.ofSeconds(long seconds)` - For second values.
- `Duration.ofMinutes(long minutes)` - For minute values.

-----

## Streaming operation

Streaming operations, such as Amazon S3 `getObject` and `putObject` methods, support non-blocking I/O in v2 SDK.
As a result, the request and response model objects no longer take an `InputStream` as a parameter.

Instead, for synchronous requests the request object accepts `RequestBody`, which is a stream of bytes.
The asynchronous equivalent accepts an `AsyncRequestBody`.

**Example of S3 `putObject` operation in IBM COS V1 (From File):**

```java
PutObjectRequest request = new PutObjectRequest("bucket-name", "key", new File("sample.txt"));
s3Client.putObject(request);
```

**Example of S3 `putObject` operation in IBM V2:**

V2 separates metadata (request) and payload (`RequestBody`), Request is immutable, payload can be a stream, file, or string.

```java
PutObjectRequest putObjectRequest  = PutObjectRequest.builder()
                                                     .bucket("bucket-name")
                                                     .key("key")
                                                     .build();

s3Client.putObject(putObjectRequest, RequestBody.fromFile(new File("sample.txt")));
```

### Example in V2 for String

```java
PutObjectRequest putObjectRequest  = PutObjectRequest.builder()
                                                     .bucket("bucket-name")
                                                     .key("key")
                                                     .build();

s3Client.putObject(putObjectRequest, RequestBody.fromString("string_content", StandardCharsets.UTF_8));
```

**Example in V1 for InputStream:**

```java
CLIENT.putObject("bucket-name", "key", "input-stream", metadata);
```

**Example in V2 for InputStream:**

```java
CLIENT.putObject(PutObjectRequest.builder()
                .bucket("bucket-name")
                .key("key")
                .build(),
    RequestBody.fromInputStream("input-stream",length));
```

### Put Object with Metadata

In `putObject()` we do not have `ObjectMetaData`, now we have separate fields for them like Content MD5, Content Length.
For any custom metadata like user meta data, it supports `Map<String,String>` to accept via builder method `.metadata()`.

#### Example in SDK v1

```java
Map<String, String> userMetadata;

ObjectMetadata metadata = new ObjectMetadata();
metadata.setContentLength(size); //to set Content length
metadata.setContentType("content-type"); //to set Content type
metadata.setUserMetadata(null); //to set user meta data 

PutObjectResult result = V1CLIENT.putObject("bucket-name", "key", "input-stream", metadata);
```

#### Example in SDK v2

```java
Map<String, String> userMetadata;

PutObjectResponse putResultA = V2CLIENT.putObject(
    PutObjectRequest.builder()
                    .bucket("bucket-name")
                    .key(key)
                    .contentLength(size) //to set Content length
                    .contentType("content-type") //to set Content type
                    .metadata(userMetadata) //to set user meta data 
                    .build(),
    RequestBody.fromInputStream("input-stream", size));
```

> **Note:** S3 converts all user-defined metadata keys to lowercase when storing and returning them.

**Example of S3 `getObject` operation in v1:**

```java
S3Object s3Obj = V1CLIENT.getObject("bucket-name", key);
S3ObjectInputStream s3in = s3Obj.getObjectContent();
FileOutputStream fos = new FileOutputStream(new File(key));
```

**Example of S3 `getObject` operation in v2**

```java
V2CLIENT.getObject(GetObjectRequest.builder().bucket("bucket-name").key(key).build(),
    ResponseTransformer.toFile(Paths.get("key")));
```

In the SDK for Java  v2, streaming response operations have an `AsBytes` method to load the response into memory and simplify common type conversions in-memory.

-----

## Serialization differences between v1 and v2 of IBM COS SDK

### List objects to request parameters difference

The SDK for Java v1 and v2 differ in how they serialize `List` objects to request parameters.

- **v1 Behavior:** The SDK for Java v1 **does not serialize an empty list**.
- **v2 Behavior:** The SDK for Java  v2 **serializes an empty list as an empty parameter**.

#### Example: `SampleOperation` Serialization

Consider a service with a `SampleOperation` that takes a `SampleRequest`.
The `SampleRequest` accepts a `String` type `str1` and a `List` type `listParam`.

| Version            | Example Code Snippet                                                                                                      | Wire-level Logging (Partial Request)                                 | `listParam` Serialization |
|--------------------|---------------------------------------------------------------------------------------------------------------------------|----------------------------------------------------------------------|---------------------------|
| **v1**             | `SampleRequest v1Request = new SampleRequest().withStr1("TestName");`    `sampleS3V1Client.sampleOperation(v1Request);` | `Action=SampleOperation&Version=2011-01-01&str1=TestName`            | Not serialized            |
| **v2**             | `sampleS3V2Client.sampleOperation(b -> b.str1("TestName"));`                                                              | `Action=SampleOperation&Version=2011-01-01&str1=TestName&listParam=` | Serialized with no value  |

### POJOs in V1 compared to Builders in V2

The two SDK versions differ in their use of model objects for de/serialization.

- **V1 SDK for Java:** Uses **mutable POJO classes** (Plain Old Java Objects), allowing de/serialization libraries like Jackson to use model objects directly.
- **V2 SDK for Java:** Uses **immutable model objects**.  You must use an intermediate **builder** to perform de/serialization.

#### Example: `headBucket` Deserialization with Jackson `ObjectMapper`

| Version | Serialization/Deserialization Approach | Key Code Difference (Using `ObjectMapper`)                                                                                                                                                                   |
|---------|----------------------------------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| V1      | Uses POJOs                             | `String v1Serialized = mapper.writeValueAsString(resultV1);`    `HeadBucketResult deserializedV1 = mapper.readValue(v1Serialized, HeadBucketResult.class);`                                                |
| V2      | Uses Builders                          | `String v2Serialized = mapper.writeValueAsString(v2Response.toBuilder());`    `HeadBucketResponse v2Deserialized = mapper.readValue(v2Serialized, HeadBucketResponse.serializableBuilderClass()).build();` |

-----

## Deserialization differences between v1 and v2 of IBM COS SDK

### Empty Collections in V2 compared to `nulls` in V1

The SDKs differ in how they deserialize JSON responses when a property modeled as a list or map is missing or empty.

- **V1 Behavior:** Deserializes a missing property to **`null`**.
- **V2 Behavior:** Deserializes a missing property to an **immutable empty collection object** (e.g., `Collections.emptyList()`) 29].

| Version                   | Behavior for Empty Response                   | Code Snippet                                                                                                                                                  | Output                                     | Null Check Requirement                                                        |
|---------------------------|-----------------------------------------------|---------------------------------------------------------------------------------------------------------------------------------------------------------------|--------------------------------------------|-------------------------------------------------------------------------------|
| **V1** (null collection)  | Returns `null` for missing collections.       | `if (resultV1.getObjectSummaries() != null) { ... } else { System.out.println("Contents list is <null>");  }` | `Contents list is <null>`                  | Yes, explicit `null` checks are required.|
| **V2** (empty collection) | Returns an immutable empty collection (`[]`). | `System.out.println(responseV2.hasContents());`    `System.out.println(responseV2.contents().isEmpty());`    `System.out.println(responseV2.contents());`| `false`    `true`    `[] - empty list` | No, promotes safer, more concise code by avoiding explicit `null` checks 31]. |

The V2 SDK also provides a `has` method (e.g., `hasContents`) to check if an attribute was returned by the service.

-----

## Exception Changes

Exception class names, their structures, and their relationships have changed.
`com.ibm.cos.v2.core.exception.SdkException` is the new base Exception class that all the other exceptions extend.

| V1 Exception Class                                                                                   | V2 Exception Class                                      |
|------------------------------------------------------------------------------------------------------|---------------------------------------------------------|
| `com.ibm.cloud.objectstorage.SdkBaseException`  `com.ibm.cloud.objectstorage.AmazonClientException`  | `com.ibm.cos.v2.core.exception.SdkException`            |
| `com.ibm.cloud.objectstorage.SdkClientException`                                                     | `com.ibm.cos.v2.core.exception.SdkClientException`      |
| `com.ibm.cloud.objectstorage.AmazonServiceException`                                                 | `com.ibm.cos.v2.awscore.exception.AwsServiceException`  |

### Exception Method Mapping

| V1 Method (on `AmazonServiceException`) | V2 Equivalent Method (on `AwsServiceException`)                        |
|-----------------------------------------|------------------------------------------------------------------------|
| `getRequestId()`                        | `SdkServiceException.requestId()`                                      |
| `getServiceName()`                      | `AwsServiceException.awsErrorDetails().serviceName()`                  |
| `getErrorCode()`                        | `AwsServiceException.awsErrorDetails().errorCode()`                    |
| `getErrorMessage()`                     | `AwsServiceException.awsErrorDetails().errorMessage()`                 |
| `getStatusCode()`                       | `AwsServiceException.awsErrorDetails().sdkHttpResponse().statusCode()` |
| `getHttpHeaders()`                      | `AwsServiceException.awsErrorDetails().sdkHttpResponse().headers()`    |
| `rawResponse()`                         | `AwsServiceException.awsErrorDetails().rawResponse()`                  |

-----

## S3 Operation Changes

### Anonymous Access

SDK for Java  v2 disables anonymous access by default.  To enable it, you must use the `AnonymousCredentialsProvider`.

### Operation Name Changes

Many S3 client operation names have changed in v2.

- **V1 Inconsistency:** In v1, S3 client was not generated directly from the service API, leading to inconsistencies between SDK operations and the service API.
- **V2 Consistency:** In v2, S3 client is generated to be more consistent with the service API.

### S3 Operation (API) Names Mapping

The following table shows the operation names in the two versions.

| V1 Operation Name                      | V2 Operation Name                                               |
|----------------------------------------|-----------------------------------------------------------------|
| `abortMultipartUpload`                 | `abortMultipartUpload`                                          |
| `changeObjectStorageClass`             | `copyObject`                                                    |
| `completeMultipartUpload`              | `completeMultipartUpload`                                       |
| `copyObject`                           | `copyObject`                                                    |
| `copyPart`                             | `uploadPartCopy`                                                |
| `createBucket`                         | `createBucket`                                                  |
| `deleteBucket`                         | `deleteBucket`                                                  |
| `deleteBucketAnalyticsConfiguration`   | `deleteBucketAnalyticsConfiguration`                            |
| `deleteBucketCrossOriginConfiguration` | `deleteBucketCors`                                              |
| `deleteBucketEncryption`               | `deleteBucketEncryption`                                        |
| `deleteBucketInventoryConfiguration`   | `deleteBucketInventoryConfiguration`                            |
| `deleteBucketLifecycleConfiguration`   | `deleteBucketLifecycle`                                         |
| `deleteBucketMetricsConfiguration`     | `deleteBucketMetricsConfiguration`                              |
| `deleteBucketPolicy`                   | `deleteBucketPolicy`                                            |
| `deleteBucketReplicationConfiguration` | `deleteBucketReplication`                                       |
| `deleteBucketTaggingConfiguration`     | `deleteBucketTagging`                                           |
| `deleteBucketWebsiteConfiguration`     | `deleteBucketWebsite`                                           |
| `deleteObject`                         | `deleteObject`                                                  |
| `deleteObjectTagging`                  | `deleteObjectTagging`                                           |
| `deleteObjects`                        | `deleteObjects`                                                 |
| `deleteVersion`                        | `deleteObject`                                                  |
| `disableRequesterPays`                 | `putBucketRequestPayment`                                       |
| `doesBucketExist`                      | `headBucket`                                                    |
| `doesBucketExistV2`                    | `headBucket`                                                    |
| `doesObjectExist`                      | `headObject`                                                    |
| `enableRequesterPays`                  | `putBucketRequestPayment`                                       |
| `generatePresignedUrl`                 | `S3Presigner`                                                   |
| `getBucketAccelerateConfiguration`     | `getBucketAccelerateConfiguration`                              |
| `getBucketAcl`                         | `getBucketAcl`                                                  |
| `getBucketAnalyticsConfiguration`      | `getBucketAnalyticsConfiguration`                               |
| `getBucketCrossOriginConfiguration`    | `getBucketCors`                                                 |
| `getBucketEncryption`                  | `getBucketEncryption`                                           |
| `getBucketInventoryConfiguration`      | `getBucketInventoryConfiguration`                               |
| `getBucketLifecycleConfiguration`      | `getBucketLifecycle` or `getBucketLifecycleConfiguration`       |
| `getBucketLocation`                    | `getBucketLocation`                                             |
| `getBucketLoggingConfiguration`        | `getBucketLogging`                                              |
| `getBucketMetricsConfiguration`        | `getBucketMetricsConfiguration`                                 |
| `getBucketNotificationConfiguration`   | `getBucketNotification` or `getBucketNotificationConfiguration` |
| `getBucketPolicy`                      | `getBucketPolicy`                                               |
| `getBucketReplicationConfiguration`    | `getBucketReplication`                                          |
| `getBucketTaggingConfiguration`        | `getBucketTagging`                                              |
| `getBucketVersioningConfiguration`     | `getBucketVersioning`                                           |
| `getBucketWebsiteConfiguration`        | `getBucketWebsite`                                              |
| `getObject`                            | `getObject`                                                     |
| `getObjectAcl`                         | `getObjectAcl`                                                  |
| `getObjectAsString`                    | `getObjectAsBytes().asUtf8String`                               |
| `getObjectMetadata`                    | `headObject`                                                    |
| `getObjectTagging`                     | `getObjectTagging`                                              |
| `getResourceUrl`                       | `S3Utilities#getUrl`                                            |
| `getS3AccountOwner`                    | `listBuckets`                                                   |
| `getUrl`                               | `S3Utilities#getUrl`                                            |
| `headBucket`                           | `headBucket`                                                    |
| `initiateMultipartUpload`              | `createMultipartUpload`                                         |
| `isRequesterPaysEnabled`               | `getBucketRequestPayment`                                       |
| `listBucketAnalyticsConfigurations`    | `listBucketAnalyticsConfigurations`                             |
| `listBucketInventoryConfigurations`    | `listBucketInventoryConfigurations`                             |
| `listBucketMetricsConfigurations`      | `listBucketMetricsConfigurations`                               |
| `listBuckets`                          | `listBuckets`                                                   |
| `listMultipartUploads`                 | `listMultipartUploads`                                          |
| `listNextBatchOfObjects`               | `listObjectsV2Paginator`                                        |
| `listNextBatchOfVersions`              | `listObjectVersionsPaginator`                                   |
| `listObjects`                          | `listObjects`                                                   |
| `listObjectsV2`                        | `listObjectsV2`                                                 |
| `listParts`                            | `listParts`                                                     |
| `listVersions`                         | `listObjectVersions`                                            |
| `putObject`                            | `putObject`                                                     |
| `restoreObject`                        | `restoreObject`                                                 |
| `restoreObjectV2`                      | `restoreObject`                                                 |
| `selectObjectContent`                  | `selectObjectContent`                                           |
| `setBucketAccelerateConfiguration`     | `putBucketAccelerateConfiguration`                              |
| `setBucketAcl`                         | `putBucketAcl`                                                  |
| `setBucketAnalyticsConfiguration`      | `putBucketAnalyticsConfiguration`                               |
| `setBucketCrossOriginConfiguration`    | `putBucketCors`                                                 |
| `setBucketEncryption`                  | `putBucketEncryption`                                           |
| `setBucketInventoryConfiguration`      | `putBucketInventoryConfiguration`                               |
| `setBucketLifecycleConfiguration`      | `putBucketLifecycle` or `putBucketLifecycleConfiguration`       |
| `setBucketLoggingConfiguration`        | `putBucketLogging`                                              |
| `setBucketMetricsConfiguration`        | `putBucketMetricsConfiguration`                                 |
| `setBucketNotificationConfiguration`   | `putBucketNotification` or `putBucketNotificationConfiguration` |
| `setBucketPolicy`                      | `putBucketPolicy`                                               |
| `setBucketReplicationConfiguration`    | `putBucketReplication`                                          |
| `setBucketTaggingConfiguration`        | `putBucketTagging`                                              |
| `setBucketVersioningConfiguration`     | `putBucketVersioning`                                           |
| `setBucketWebsiteConfiguration`        | `putBucketWebsite`                                              |
| `setObjectAcl`                         | `putObjectAcl`                                                  |
| `setObjectRedirectLocation`            | `copyObject`                                                    |
| `setObjectTagging`                     | `putObjectTagging`                                              |
| `uploadPart`                           | `uploadPart`                                                    |
| `setBucketProtectionConfiguration`     | `putBucketProtectionConfiguration`                              |
| `getBucketProtection`                  | `getBucketProtection`                                           |
| `addLegalHolds`                        | `addLegalHolds`                                                 |
| `listLegalHolds`                       | `listLegalHolds`                                                |
| `deleteLegalHold`                      | `deleteLegalHold`                                               |
| `extendObjectRetention`                | `extendObjectRetention`                                         |
| `setBucketReplicationReattempt`        | `putBucketReplicationReattempt`                                 |
| `listBucketReplicationFailures`        | `listBucketReplicationFailures`                                 |

-----

## Operational Examples

### Create Request

#### Example to Create Bucket in V1

Requests used mutable POJO (Plain Old Java Object) classes, created using constructors and setters.

```java
CreateBucketRequest createBucketRequest = new CreateBucketRequest(bucketName);
cosClient.createBucket(createBucketRequest);
```

#### Example to Create Bucket in V2 (Builder Pattern)

All service requests use **immutable objects with builders**.

```java
CreateBucketRequest createBucketRequest = CreateBucketRequest.builder()
                                                             .bucket("bucketName")
                                                             .build();
cosClient.createBucket(createBucketRequest);
```

-----

### Adding a Custom Header

Custom headers are handled differently, especially in V2, where `overrideConfiguration` is used.

#### Example to add custom header in V1

```java
CreateBucketRequest request = new CreateBucketRequest("bucketName");
request.putCustomRequestHeader("Authorization", "\u0007");
```

#### Example to add custom header in V2 (Builder Pattern)

```java
CreateBucketRequest request = CreateBucketRequest.builder()
                                                 .bucket("bucketName")
                                                 .overrideConfiguration(b -> b.putHeader("Content-Length", "\u0007"))
                                                 .build();
```

**Note on Header Validation:** In V2, the SDK and service have stricter validation for headers like `Content-Length`.
Invalid values now return `HTTP 400 Bad Request, Invalid Argument`, instead of the `HTTP 403 SignatureDoesNotMatch` seen in V1.

- We cannot set headers to `NULL` directly in IBM COS SDK v2.

- `Expect` header is not critical for HTTP/1.1, unless set to a valid value like 100, v2 will drop it.

-----

### List Objects From an S3 Bucket

The model for listing objects has been updated in V2, with `ObjectListing` no longer existing, and V2 promoting the use of Paginators.

#### V1 (IBM SDK Style) - Iteration via `isTruncated`

```java
ObjectListing objectListing = s3ClientV1.listObjects("bucket-Name"); 

while (objectListing.isTruncated()) {
objectListing = s3ClientV1.listNextBatchOfObjects(objectListing);
    for (S3ObjectSummary summary : objectListing.getObjectSummaries()) {
    System.out.println(summary.getKey());
    }
    }
```

#### V2 (Builder Pattern) - Paginator Iteration

```java
ListObjectsV2Request request = ListObjectsV2Request.builder()
                                                   .bucket("bucket-name")
                                                   .build();

// V2 returns a paginator.
ListObjectsV2Iterable responses=s3ClientV2.listObjectsV2Paginator(request);

for (ListObjectsV2Response page : responses) {
    page.contents().forEach(content -> {
    System.out.println(content.key());
    });
    }
```

-----

### Access Control List (ACL)

#### Example for creating Grant

**In IBM COS V1:**

```java
Grant specificACL = new Grant(GroupGrantee.AllUsers, Permission.Read);
```

- GroupGrantee.AllUsers was an enum constant of type GroupGrantee.
- It extended/implemented the Grantee interface, and its internal structure faked an ID even though S3 group grantees don’t technically have IDs in the service model.

Let’s see what GroupGrantee.AllUsers looked like internally in v1:

```java
public enum GroupGrantee implements Grantee {
    AllUsers("http://acs.amazonaws.com/groups/global/AllUsers"),
    AuthenticatedUsers("http://acs.amazonaws.com/groups/global/AuthenticatedUsers"),
    LogDelivery("http://acs.amazonaws.com/groups/s3/LogDelivery");

    private final String uri;

    private GroupGrantee(String uri) {
        this.uri = uri;
    }

    @Override
    public String getIdentifier() {
        return this.uri;  // ← Notice this!
    }

    @Override
    public void setIdentifier(String id) {
        // no-op
    }
}
```

The `getIdentifier()` method (aka id() in your matcher) actually returned the URI string for Group grantees.

**In IBM COS SDK v2:**
In v2, the model was **rebuilt from scratch** (stricter to AWS spec)

```java
public final class Grantee {
    private final Type type;
    private final String id;
    private final String displayName;
    private final String emailAddress;
    private final String uri;
}
```

1. Each field now has a **specific meaning**, matching S3’s actual XML structure:
    - id → for CanonicalUser (the AWS account ID)
    - uri → for Group
    - emailAddress → legacy (not used)
2. The SDK no longer aliases or reuses uri as id.

'GROUP' Grant will be built as below in v2:

```java
Grantee grantee = Grantee.builder()
                         .type(Type.GROUP)
                         .uri("http://acs.amazonaws.com/groups/global/AllUsers")
                         .build();

Grant specificACL = Grant.builder()
                         .grantee(grantee)
                         .permission(Permission.READ)
                         .build();
```

### New utility addition of IBMAclGrantee in IBM COS for creating GRANTEE of Type ‘GROUP’

The IBM v2 Java SDK now includes a new utility class `IBMAclGrantee` to simplify working with Access Control List (ACL) group grantees in IBM Cloud Object Storage (COS).
Included Group Grantees

- `IBMAclGrantee.allUsers()` - All internet users (public access)
- `IBMAclGrantee.authenticatedUsers()`  - All authenticated users
- `IBMAclGrantee.logDelivery()` - Log Delivery group

### Example using IBMAclGrantee: Instead of above, make use of IBMAclGrantee for building GROUP Grantee

```java
Grant specificACL = Grant.builder()
                         .grantee(IBMAclGrantee.allUsers()) // type=GROUP, uri set, id=null
                         .permission(Permission.READ)
                         .build();
```

So, when you create as above, `grantee.id()` is null.

#### V1's setBucketAcl() to V2's putBucketAcl()

```java
// SDK V1
Grant specificACL = new Grant(GroupGrantee.AllUsers, Permission.Read);

AccessControlList acl = new AccessControlList();
acl.grantPermission(specificACL);

s3ClientV1.setBucketAcl("bucket-name", acl);

// SDK V2
Grant specificACL = Grant.builder()
                         .grantee(IBMAclGrantee.allUsers())
                         .permission(Permission.READ)
                         .build();

AccessControlPolicy acl = AccessControlPolicy.builder()
                                             .grants(specificACL)
                                             .build();

PutBucketAclRequest request = PutBucketAclRequest.builder()
                                                 .bucket("bucket-name")
                                                 .accessControlPolicy(acl)
                                                 .build();

s3ClientV2.putBucketAcl(request);
```

#### Getting Bucket Grants

#### Example for getBucketAcl()

```java
// SDK V1
GetBucketAclRequest getBucketAclRequest = new GetBucketAclRequest("bucket-name");
AccessControlList acl = CLIENT.getBucketAcl(getBucketAclRequest);
List<Grant> grants = acl.getGrantsAsList();

// SDK V2
GetBucketAclRequest getBucketAclRequest = GetBucketAclRequest.builder()
                                                             .bucket("bucket-name").build();

GetBucketAclResponse acl = CLIENT.getBucketAcl(getBucketAclRequest);
List<Grant> grants = acl.grants();

for (Grant grant : grants) {
    System.out.println(grant);
}
```

#### Operation with Canned ACL

#### Example for creating bucket in IBM COS v1 with Canned ACL

```java
CreateBucketRequest request = new CreateBucketRequest(BUCKET_NAME);
request.withCannedAcl(CannedAccessControlList.AuthenticatedRead);
```

**In IBM COS v2:**

```java
CreateBucketRequest createBucketRequest = CreateBucketRequest.builder()
                                                             .bucket(BUCKET_NAME)
                                                             .acl(BucketCannedACL.AUTHENTICATED_READ)
                                                             .build();
```

#### V1 to V2 Mappings for BucketACL

| Operation                 | V1                                                                                           | V2                                                                                                      |
|---------------------------|----------------------------------------------------------------------------------------------|---------------------------------------------------------------------------------------------------------|
| To set ACL                | `setBucketAcl(bucket, CannedAccessControlList.PublicRead)`                                   | `putBucketAcl(bucket, BucketCannedACL.PUBLIC_READ)`                                                     |
| To get Grantee            | grant.getGrantee()                                                                           | grant.grantee()                                                                                         |
| To get ‘Type of Grantee’  | grant.getGrantee()                                                                           | grant.grantee().type()                                                                                  |
| Grantee Type mapping      | Canonical user - CanonicalGrantee (Java Class)  Group grantee - GroupGrantee(Java Class)     | Canonical user - Type.CANONICAL_USER (enum constant)  Group grantee -Type.GROUP (enum Constant)         |
| To check Type of grantee  | grant.getGrantee() instanceOf CanonicalGrantee    grant.getGrantee() instanceof GroupGrantee | if(grant.grantee().type() == Type.CANONICAL_USER) //as it is enum  grant.grantee().type() == Type.GROUP |
| Grantee Attribute access  | getDisplayName()  getIdentifier()  getURI()                                                  | displayName()  id()  uri()                                                                              |
| Get Permission            | grant.getPermission()  grant.getPermission().toString() // to get permission as string       | grant.permission()  grant.permissionAsString() // to get permission as string                           |
| Builder-style shift       | `request.withCannedAcl(CannedAccessControlList.AuthenticatedRead);`                          | `requestBuilder.acl(BucketCannedACL.AUTHENTICATED_READ);`                                               |

#### Grantee Types mapping

| V1                            | V2                                  |
|-------------------------------|-------------------------------------|
| CanonicalGrantee (Java Class) | Type.CANONICAL_USER (enum constant) |
| GroupGrantee(Java Class)      | Type.GROUP (enum Constant)          |

#### Canned ACL Mappings for Bucket ACL

| V1                                        | V2                                 |
|-------------------------------------------|------------------------------------|
| CannedAccessControlList.PublicRead        | BucketCannedACL.PUBLIC_READ        |
| CannedAccessControlList.AuthenticatedRead | BucketCannedACL.AUTHENTICATED_READ |
| CannedAccessControlList.Private           | BucketCannedACL.PRIVATE            |
| CannedAccessControlList.PublicReadWrite   | BucketCannedACL.PUBLIC_READ_WRITE  |

#### Example to check if Owner has FULL_ACCESS

```java
// SDK V1
List<Grant> grants = acl.grants();
for (Grant grant : grants) {
    if(grant.getGrantee() instanceOf grant.getGrantee()){
    // Confirm that owner has full control
    System.out.println(grant.getPermission().toString().equals("FULL_CONTROL"));
    System.out.println(((CanonicalGrantee) canonicalUser.getGrantee()).getDisplayName());
    }
    }

// SDK V2
List<Grant> grants = acl.grants();
for (Grant grant : grants) {
    if (grant.grantee().type() == Type.CANONICAL_USER){
    // Confirm that owner has full control
    System.out.println((grant.permissionAsString().equals("FULL_CONTROL")));
    System.out.println(grant.grantee().displayName());
    }
    }
```

### Object Level ACL

#### Example for setObjectAcl with Canned ACL

**In IBM COS v1:**

```java
// Upload object with private ACL
V1CLIENT.putObject("bucket-name", "foo1", "foo1");

V1CLIENT.setObjectAcl("bucket-name", "foo1", CannedAccessControlList.Private);
```

**In IBM COS v2:**

```java
PutObjectRequest putObjectRequest = PutObjectRequest.builder()
                                                    .bucket("bucket-name")
                                                    .key("foo1")
                                                    .acl(ObjectCannedACL.PRIVATE)
                                                    .build();    

V2CLIENT.putObject(putObjectRequest, RequestBody.fromString("foo1"));
```

-----

#### Canned ACL Mappings for Object ACL

| V1                                        | V2                                 |
|-------------------------------------------|------------------------------------|
| CannedAccessControlList.PublicRead        | ObjectCannedACL.PUBLIC_READ        |
| CannedAccessControlList.AuthenticatedRead | ObjectCannedACL.AUTHENTICATED_READ |
| CannedAccessControlList.Private           | ObjectCannedACL.PRIVATE            |
| CannedAccessControlList.PublicReadWrite   | ObjectCannedACL.PUBLIC_READ_WRITE  |

#### Getting Object Grants

```java
// SDK V1
GetObjectAclRequest getObjectAclRequest = new GetObjectAclRequest("bucket-name");
AccessControlList acl = CLIENT.getObjectAcl(getBucketAclRequest);
List<Grant> grants = acl.getGrantsAsList();

// SDK V2
GetObjectAclResponse acl = CLIENT.getObjectAcl(GetObjectAclRequest.builder()
                                                                  .bucket("bucket-name")
                                                                  .key("key")
                                                                  .build());
List<Grant> grantList = acl.grants();
```

## GetObject in V2

### V1’s withMatchingETagConstraint to V2’s ifMatch() while building the request

```java
// SDK v1
GetObjectRequest getObjectRequest = GetObjectRequest.builder()
                                                    .bucket("bucket-name")
                                                    .key("key")
                                                    .build();

getObjectRequest.withMatchingETagConstraint(new StringBuilder(response.eTag()).reverse().toString());

// SDK v2
GetObjectRequest request = GetObjectRequest.builder()
                                           .bucket("bucket-name")
                                           .key("key")
                                           .ifMatch(new StringBuilder(response.eTag()).reverse().toString())
                                           .build();
```

#### V1’s withModifiedSinceConstraint() to V2’s .ifModifiedSince(Instant)

```java
// SDK v1
GetObjectRequest request = new GetObjectRequest("bucket-name", put.name());
request.withModifiedSinceConstraint(dateConstraint);

// SDK v2
GetObjectRequest request = GetObjectRequest.builder()
                                           .bucket("bucket-name")
                                           .key("key")
                                           .ifModifiedSince(dateConstraint.toInstant())
                                           .build();
```

**Conditional GET behavior change:**
In SDK v2, conditional GET failures (such as If-Modified-Since) return an HTTP 304 response that is surfaced as an S3Exception.
Unlike SDK v1, the SDK does not return a null response or empty object. Applications must catch and handle S3Exception with status code 304 explicitly.

#### Example to work with Response Input Stream

```java
ResponseInputStream<GetObjectResponse> object = CLIENT.getObject(GetObjectRequest.builder()
                                                                                 .bucket("bucket-name")
                                                                                 .key("key")
                                                                                 .build());
```

To get response: `object.response()`

#### Below is the response

```java
GetObjectResponse(AcceptRanges=bytes, LastModified=2025-10-21T10:42:53Z, ContentLength=10, ETag="bafb23697f66102a97c6dbae7e165108", ContentType=application/octet-stream, Metadata={metakey=metaValue})
GetObjectResponse(AcceptRanges=bytes, LastModified=2025-10-21T10:42:54Z, ContentLength=7, ETag="296ab49302a43553e323fb8cb43fcd7a", ContentRange=bytes 4-10/11, ContentType=text/plain;charset=utf-8, Metadata={})
```

**Notable differences:**

1. **ContentRange:** This is string now instead of Long array

   Error when Invalid Range is provided:
   > com.ibm.cos.v2.services.s3.model.S3Exception: The requested range cannot be satisfied. (Service: S3, Status Code: 416, Request ID: 48703f2c-0dd5-4b29-ba07-d58f8e10328e) (SDK Attempt Count: 1)

2. **Etag:** In **IBM COS SDK v2**, GetObjectResponse.eTag() returns the raw value from the HTTP header, including the surrounding quotes as sent by S3.
   > GetObjectResponse(AcceptRanges=bytes, LastModified=2025-10-22T07:04:29Z, ContentLength=4096, ETag="3753ce49bc969acd8d5ef569b09ae948", ContentType=application/octet-stream, Metadata={})

-----

### getObjectAsString()

This API is used to retrieve the contents of an object from a bucket directly as a String.
In IBM COS v1, we would use `getObjectAsString()`, but in V2 we use getObject() and then read the response stream manually, or use `getObjectBytes(GetObjectRequest).asUtf8String()` for direct String retrieval.

```java
// SDK v1
V1CLIENT.getObjectAsString("bucket-name", "key");

// SDK v2
String response =  V2CLIENT.getObjectAsBytes(GetObjectRequest.builder()
                                                             .bucket("bucket-name")
                                                             .key("key")
                                                             .build()).asUtf8String()
```

-----

### ListObjectsV2

- **Newer API** (recommended this for all new applications).
- Returns ListObjectsV2Response with:
  - `contents()` → list of object summaries
  - `commonPrefixes()` → same as above
  - `continuationToken` and `nextContinuationToken` for pagination (simpler than v1).
  - startAfter parameter to control where listing begins.

#### To work with ListObjectsV2Response and S3Object

```java
ListObjectsV2Request listObjectsV2Request = ListObjectsV2Request.builder()
                                                                .bucket("bucket-name")
                                                                .build();

ListObjectsV2Response listObjectsV2Response = s3Client.listObjectsV2(listObjectsV2Request);

List<S3Object> summaries = listObjectsV2Response.contents();

for (S3Object summary : summaries) {
    summary.key(); // bucket name
}
```

- Note: `CLIENT.listObjects(objectsRequest)` -> Accepting ListObjectRequest Builder instead of bucket name exists as extending support for V1 (to support Backward Compatibility).
Returns a ListObjectsResponse that contains:
  - `contents()`: list of object summaries
  - `commonPrefixes()`:when using delimiters
  - `marker` and `nextMarker` for pagination.

#### CHANGES: (wrt Listing Objects)

- `S3ObjectSummary` → `S3Object`

- `S3ObjectSummary.getKey()` → `S3Object.key()`

- `commonPrefixes()` instead of `getCommonPrefixes()` when using delimiters  
  (Returns `List<CommonPrefix>` instead of `List<String>`)

- `KeyVersion` → `ObjectIdentifier`

- There is no `getObjectMetadata()` method. Instead, use `headObject()` to fetch metadata.  
  For example, `lastModified()` in v2 returns a `java.time.Instant`, which can be converted to
  `java.util.Date` using `Date.from()`.

- `getInstanceLength()` → `contentLength()`

```java
Date lastModified = CLIENT.getObject(bucketName, "foo").getObjectMetadata().getLastModified();
```

**In V2:** `headObject` tries to get metadata of the object. If no object found, SDK throws an S3Exception with HTTP status 404, caught and interpreted as "object does not exist.

```java
HeadObjectRequest headObjectRequest = HeadObjectRequest.builder()
                                                       .bucket("bucket-name")
                                                       .key("key")
                                                       .build();

Instant lastModifiedInstant = CLIENT.headObject(headObjectRequest).lastModified();
Date lastModified = Date.from(lastModifiedInstant);
```

-----

### Deleting Object

```java
// SDK V1
V1CLIENT.deleteObject("bucket-name","key"));

// SDK V2
DeleteObjectRequest deleteObjectRequest = DeleteObjectRequest.builder()
                                                             .bucket("bucket-name")
                                                             .key("key")
                                                             .build();
V2CLIENT.deleteObject(deleteObjectRequest);
```

-----

### Delete Object Request with Keys

**Example in IBM COS v1:**

```java
DeleteObjectsRequest multiObjectDeleteRequest = new DeleteObjectsRequest.builder().bucket("bucketName").build();

List<KeyVersion> keys = new ArrayList<KeyVersion>();
KeyVersion keyVersion1 = new KeyVersion(key1);
KeyVersion keyVersion2 = new KeyVersion(key2);
keys.add(keyVersion1);
keys.add(keyVersion2);

deleteRequest.setKeys(keys);
V1CLIENT.deleteObjects(deleteRequest);
```

**Example in IBM COS V2:**

```java
List<ObjectIdentifier> keys = Arrays.asList(
    ObjectIdentifier.builder().key(key1).build(),
    ObjectIdentifier.builder().key(key2).build()
);

DeleteObjectsRequest deleteRequest = DeleteObjectsRequest.builder()
                                                         .bucket("bucket-name")
                                                         .delete(Delete.builder().objects(keys).build())
                                                         .build();

V2CLIENT.deleteObjects(deleteRequest);
```

-----

### Deleting Bucket

```java
// SDK V1
V1CLIENT.deleteBucket("bucket-name");

// SDK V2
DeleteBucketRequest deleteBucketRequest = DeleteBucketRequest.builder().bucket("bucket-name").build();
V2CLIENT.deleteBucket(deleteBucketRequest);
```

-----

### Deleting Objects and Buckets

| Operation               | V1 (POJO/String)                                            | V2 (Builder Pattern)                                                                                                                                                         |
|-------------------------|-------------------------------------------------------------|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Delete Single Object    | `V1CLIENT.deleteObject( BUCKET_NAME ,summary.key());`       | `DeleteObjectRequest deleteObjectRequest = DeleteObjectRequest.builder().bucket("bucketName").key(summary.key()).build();`   `V2CLIENT.deleteObject(deleteObjectRequest);` |
| Delete Versioned Object | `DeleteVersionRequest` class used.                          | `DeleteObjectRequest.builder().versionId(...)` used                                                                                                                          |
| Delete Multiple Objects | Uses `KeyVersion` and `DeleteObjectsRequest.setKeys(keys)`. | Uses `ObjectIdentifier` and `DeleteObjectsRequest.delete(Delete.builder().objects(keys))`.                                                                                   |
| Delete Bucket           | `V1CLIENT.deleteBucket("bucketName");`                      | `DeleteBucketRequest deleteBucketRequest = DeleteBucketRequest.builder().bucket("bucketName").build();`  `V2CLIENT.deleteBucket(deleteBucketRequest);`                     |

-----

### Head Bucket

```java
// SDK V1
HeadBucketResult head = V1CLIENT.headBucket(new HeadBucketRequest("bucketName"));

// SDK V2
HeadBucketRequest headBucketRequest = HeadBucketRequest.builder()
                                                       .bucket("bucketName")
                                                       .build();
HeadBucketResponse head = V2CLIENT.headBucket(headBucketRequest);
```

-----

### Bucket Exist

```java
// SDK V1
V1CLIENT.doesBucketExist("bucketName");

// SDK V2 – doesBucketExist() is removed so we need to use headBucket()
V2CLIENT.headBucket(HeadBucketRequest.builder().bucket("bucketName").build());
```

-----

### List of Global properties removed

The following system properties no longer supported from (SDKGlobalConfiguration)

- DISABLE_CERT_CHECKING_SYSTEM_PROPERTY
- DEFAULT_METRICS_SYSTEM_PROPERTY
- RETRY_THROTTLING_SYSTEM_PROPERTY
- REGIONS_FILE_OVERRIDE_SYSTEM_PROPERTY
- DISABLE_REMOTE_REGIONS_FILE_SYSTEM_PROPERTY
- DISABLE_S3_IMPLICIT_GLOBAL_CLIENTS_SYSTEM_PROPERTY
- ENABLE_IN_REGION_OPTIMIZED_MODE
  
-----

### Bucket Tagging

In IBM COS SDK for Java v2, the whole `BucketTaggingConfiguration SetBucketTaggingConfigurationRequest`, and `TagSet` model from v1 are gone.
Instead, tagging uses the `putBucketTagging()` and `getBucketTagging()` APIs with the `Tagging` and `Tag` models.

> If no tags are set, `AWS SDK v2 throws S3Exception with 404 (NoSuchTagSet)`, instead of returning `null` like v1.

#### API CHANGES

|V1 | V2 |
|---|------------------|
|getBucketTaggingConfiguration | getBucketTagging |
|setBucketTaggingConfiguration | putBucketTagging |
|deleteBucketTaggingConfiguration | deleteBucketTagging |

#### Example for Bucket Tagging (setBucketTaggingConfiguration, getBucketTagging)

```java
// IBM COS SDK v1

// Set Bucket Tagging Config – IN v1
SetBucketTaggingConfigurationRequest request = new SetBucketTaggingConfigurationRequest("bucketName", createStandardTaggingConfig());
CLIENT.setBucketTaggingConfiguration(request);

// Get Bucket Tagging Config – In v1
BucketTaggingConfiguration bucketTaggingConfig = CLIENT.getBucketTaggingConfiguration("bucketName");

// Get all TagSet – IN v1
List<TagSet> tagSetList = bucketTaggingConfig.getAllTagSets();
List<Tag> tagList = taggingResponse.tagSet();


//IBM COS SDK v2

// Set Bucket Tagging Config – IN v2
CLIENT.putBucketTagging(PutBucketTaggingRequest.builder()
                        .bucket("bucketName")
                        .tagging(createTagSet())
    .build());

// Get Bucket Tagging Config – In v2
GetBucketTaggingRequest getBucketTaggingRequest = GetBucketTaggingRequest.builder()
                                                                         .bucket("bucketName")
                                                                         .build();
GetBucketTaggingResponse taggingResponse = CLIENT.getBucketTagging(getBucketTaggingRequest);
```

-----

### Multipart

#### V1's initiateMultipartUpload to V2's createMultipartUpload

#### Example migration

```java
// SDK V1

ObjectMetadata metadata = new ObjectMetadata();
metadata.setContentType("application/zip");
metadata.addUserMetadata("mykey", "myvalue");

InitiateMultipartUploadRequest initRequest =  new InitiateMultipartUploadRequest(
    "bucket-name",
    "object-key",
    metadata);

InitiateMultipartUploadResult initResponse = s3ClientV1.initiateMultipartUpload(initRequest);
String uploadId = initResponse.getUploadId();


// SDK V2
// V1 uses ObjectMetadata methods, whereas V2 uses a simple Map.

CreateMultipartUploadRequest createMultipartRequest = CreateMultipartUploadRequest.builder()
                                                                                  .bucket("bucket-name")
                                                                                  .key("object-key")
                                                                                  .contentType("application/zip")
                                                                                  .metadata(Collections.singletonMap("mykey", "myvalue"))
                                                                                  .build();

CreateMultipartUploadResponse response = s3ClientV2.createMultipartUpload(createMultipartRequest);
String uploadId = response.uploadId();
```

#### Implementation differences

The default `Content-Type` header value for the following methods differ as shown in the following table.

| SDK version | Method | Default Content-Type value |
|-------------|--------------------------|----------------------------|
| version 1 | initiateMultipartUpload | application/octet-stream |
| version 2 | createMultipartUpload | binary/octet-stream |

#### Multipart Full Example

**In V1:** Initiate → upload parts → Abort

```java
//Initiate Multipart upload
InitiateMultipartUploadRequest initiateRequest = new InitiateMultipartUploadRequest("bucket-name", key);
InitiateMultipartUploadResult initResult = V1CLIENT.initiateMultipartUpload(initiateRequest);
String uploadId = initResult.getUploadId();

// Upload parts
UploadPartRequest uploadRequest = new UploadPartRequest()
    .withBucketName("bucket-name")
    .withKey(key)
    .withUploadId(uploadId)
    .withPartNumber(range.part())
    .withFileOffset(range.start())
    .withFile(input.fileHandle())
    .withPartSize(range.size());
UploadPartResult partResult = V1CLIENT1.uploadPart(uploadRequest);

//Abort Multipart Upload
AbortMultipartUploadRequest abortRequest =
    new AbortMultipartUploadRequest("bucket-name", "key", uploadId);
CLIENT1.abortMultipartUpload(abortRequest);

// List multipart uploads
ListMultipartUploadsRequest listMpRequest = new ListMultipartUploadsRequest("bucket-name");
MultipartUploadListing listing = V1CLIENT.listMultipartUploads(listMpRequest);
```

**In IBM COS v2:**
Since requests are **immutable builders** (builder() methods) and results are plain objects, not fluent withX setters.

For uploading a range of a file, we have two options:

- Use a FileChannel + slice into a ByteBuffer

  ```java
    try (FileChannel channel = FileChannel.open(file.fileHandle().toPath(), StandardOpenOption.READ)) {
        ByteBuffer buffer = ByteBuffer.allocate((int) range.size());
        channel.read(buffer, range.start());
        buffer.flip();
    
        UploadPartResponse partResult = V2CLIENT.uploadPart(uploadRequest,
            RequestBody.fromByteBuffer(buffer));
    }
  ```

- Stream the part via InputStream

  ```java
    try (InputStream in = new FileInputStream(file.fileHandle())) {
        in.skip(range.start());
    
        UploadPartResponse partResult = V2CLIENT.uploadPart(uploadRequest,
            RequestBody.fromInputStream(in, range.size()));
    }
  ```

#### Multipart upload using Input Stream (Simpler way)

```java
// 1. Initiate Multipart Upload
CreateMultipartUploadRequest initiateRequest = CreateMultipartUploadRequest.builder()
                                                                           .bucket("bucket-name")
                                                                           .key("key")
                                                                           .build();

CreateMultipartUploadResponse initResponse = V2CLIENT.createMultipartUpload(initiateRequest);
String uploadId = initResponse.uploadId();

// To collect ETags
List<CompletedPart> eTags = new ArrayList<>();

// 2. Upload parts – Input Stream
for (ChunkedFileNoise.Range range : input) {
UploadPartRequest uploadRequest = UploadPartRequest.builder()
                                                   .bucket("bucket-name")
                                                   .key("key")
                                                   .uploadId("uploadId")
                                                   .partNumber(range.part()).contentLength(range.size())
                                                   .build();

    try (InputStream in = new FileInputStream(file.fileHandle())) {
    in.skip(range.start());

UploadPartResponse partResult = V2CLIENT.uploadPart(uploadRequest,RequestBody.fromInputStream(in, range.size()));

        eTags.add(CompletedPart.builder()
                    .partNumber(range.part())
    .eTag(partResult.eTag())
    .build());

    } catch (FileNotFoundException e) {
    throw new RuntimeException(e);
    } catch (IOException e) {
    throw new RuntimeException(e);
    }

        //2b. Upload parts – file
        for (ChunkedFileNoise.Range range : uploadFile) {
UploadPartRequest uploadRequest = UploadPartRequest.builder()
                                                   .bucket(bucketName)
                                                   .key(uploadFile.name())
                                                   .uploadId(uploadId)
                                                   .partNumber(range.part())
                                                   .contentLength(range.size())
                                                   .build();

RequestBody requestBody = RequestBody.fromFile(uploadFile.fileHandle().toPath());
UploadPartResponse partResult = V2CLIENT.uploadPart(uploadRequest,requestBody);
      
   eTags.add(CompletedPart.builder()
   .partNumber(range.part()).eTag(partResult.eTag()).build());
    }


// 3. Abort Multipart Upload (if you want to cancel)
AbortMultipartUploadRequest abortRequest = AbortMultipartUploadRequest.builder()
                                                                      .bucket("bucket-name")
                                                                      .key(key)
                                                                      .uploadId(uploadId)
                                                                      .build();

V2CLIENT.abortMultipartUpload(abortRequest);

//4. Complete Multipart
CompletedMultipartUpload multipartUpload = CompletedMultipartUpload.builder().parts(eTags).build();

CompleteMultipartUploadRequest compRequest = CompleteMultipartUploadRequest.builder()
                                                                           .bucket("bucket-name")
                                                                           .key(uploadFile.name())
                                                                           .uploadId(uploadId)
                                                                           .multipartUpload(multipartUpload)
                                                                           .retentionLegalHoldId(legaHoldId)
                                                                           .retentionPeriod(retentionPeriod)
                                                                           .build();
CompleteMultipartUploadResponse finalResult = V2CLIENT.completeMultipartUpload(compRequest);


// List multipart uploads
ListMultipartUploadsRequest listMpRequest = ListMultipartUploadsRequest.builder()
                                                                       .bucket("bucket-name")
                                                                       .build();
ListMultipartUploadsResponse listing = V2CLIENT.listMultipartUploads(listMpRequest);
```

#### Notable Changes

Listing is response of listMultipartUploads()

**In V1:** `listing.getMultipartUploads()`

**In V2:** `(ListMultipartUploadsResponse)listing.uploads()`

-----

### Copy Request

#### Example for copying from source Bucket to Destination bucket

```java
//SDK V1
CopyObjectResult result = V1CLIENT.copyObject("source-bucket-name", "source-key" "target-bucket-name", "dest-key");

//SDK v2
CopyObjectRequest copyRequest = CopyObjectRequest.builder()
                                                 .sourceBucket("source-bucket-name")
                                                 .sourceKey("source-key")
                                                 .destinationBucket("target-bucket-name")
                                                 .destinationKey("dest-key");
                                .build();
CopyObjectResponse result = V2CLIENT.copyObject(copyRequest);
```

The response type in V2 is `CopyObjectResponse`, which contains the result and metadata. Access the actual result with `result.copyObjectResult()` if you need ETag or last modified.

**For example:**
`String eTag = result.copyObjectResult().eTag();`

- Note: When you supply new metadata in the copy request, you must explicitly set the metadata directive to `REPLACE`; otherwise, the service rejects the request with the error :
- `The x-amz-metadata-directive you specified was invalid. (Service: S3, Status Code: 400, Request ID: 5776c9de-cec5-43f7-aafe-c4bb3e61f74b) (SDK Attempt Count: 1) at com.ibm.cleversafe.s3.java.tests.ObjectMetadataTest.test_java_object_set_get_metadata_overwrite_to_good(ObjectMetadataTest.java:270)`

#### Metadata behavior in SDK v2 during Copy Request

In SDK v2, metadata handling during copy is explicit and must be controlled using MetadataDirective.
If you do not specify a metadata directive:

- The service treats the request as metadata replacement

- The service treats the request as metadata replacement

#### When copying metadata as-is (COPY)

Use MetadataDirective.COPY when you want the destination object to retain all metadata from the source object (for example, renaming or moving an object).

```java
    CopyObjectRequest copyRequest = CopyObjectRequest.builder()
                                                     .sourceBucket("source-bucket-name")
                                                     .sourceKey("source-key")
                                                     .destinationBucket("target-bucket-name")
                                                     .destinationKey("dest-key")
                                                     .metadataDirective(MetadataDirective.COPY)
                                                     .build();

CLIENT.copyObject(copyRequest);
```

#### When replacing metadata (REPLACE)

If you want to modify or replace metadata during a copy operation, you must explicitly set the metadata directive to REPLACE.
Failing to do so while supplying new metadata will result in a 400 Bad Request error.

****Correct way to replace metadata during copy

```java
//Copy with new metadata
CopyObjectRequest copyRequest = CopyObjectRequest.builder()
                                                 .sourceBucket("source-bucket-name")
                                                 .sourceKey("source-key")
                                                 .destinationBucket("target-bucket-name")
                                                 .destinationKey("dest-key")
                                                 .metadata(metadata)
                                                 .metadataDirective(MetadataDirective.REPLACE)
                                                 .build();
CLIENT.copyObject(copyRequest);
```

-----

### Website Configuration

#### IBM COS v1

```java
BucketWebsiteConfiguration putWebsiteConfig = new BucketWebsiteConfiguration("index.html", "error.html");
CLIENT.setBucketWebsiteConfiguration("bucket-name", putWebsiteConfig);
```

#### IBM COS v2

- Use builder pattern for WebsiteConfiguration, IndexDocument, and ErrorDocument.

- Use PutBucketWebsiteRequest and GetBucketWebsiteRequest to set/get website configuration.

- Result type for get is WebsiteConfiguration

```java
WebsiteConfiguration websiteConfig = WebsiteConfiguration.builder()
                                                         .indexDocument(IndexDocument.builder().suffix("index.html").build())
                                                         .errorDocument(ErrorDocument.builder().key("error.html").build())
                                                         .build();
PutBucketWebsiteRequest putBucketWebsiteRequest = PutBucketWebsiteRequest.builder().bucket("bucket-name").websiteConfiguration(websiteConfig).build();
CLIENT.putBucketWebsite(putBucketWebsiteRequest);
```

-----

### Pre signed URL

#### IBM COS v1

```java
GeneratePresignedUrlRequest presignedUrlRequest = new GeneratePresignedUrlRequest(bucket, key, HttpMethod.GET);
IAM_CLIENT.generatePresignedUrl(presignedUrlRequest);
```

#### IBM COS v2

In IBM COS SDK for Java v2, GeneratePresignedUrlRequest and generatePresignedUrl() are removed — they are replaced by a S3Presigner utility class.
It will be

- S3Presigner + GetObjectPresignRequest

- S3Presigner + PutObjectPresignRequest

```java
//1. Create presigner (you can reuse IAM or custom credentials)
//This is usually done at application startup, because creating a presigner can be expensive

S3Presigner presigner = S3Presigner.builder()
                                   .region("region")
                                   .credentialsProvider(IAM_CLIENT. serviceClientConfiguration().credentialsProvider()
                                                                  .endpointOverride(URI.create(DsnetConfig.getApiEndpointUrl()))
                                                                  .build();

FOR HTTP -GET
//2. Build the GET object request 
GetObjectRequest getObjectRequest = GetObjectRequest.builder()
                                                    .bucket("bucket-name")
                                                    .key(key)
                                                    .build();

//3. Define presign request (e.g., URL valid for 15 minutes)- for GetObject
GetObjectPresignRequest presignRequest = GetObjectPresignRequest.builder()
                                                                .signatureDuration(Duration.ofMinutes(15))
                                                                .getObjectRequest(getObjectRequest)
                                                                .build();

//4. Generate presigned URL
URL presignedUrl = presigner.presignGetObject(presignRequest).url();

FOR HTTP -PUT
//2.Build PutObjectRequest - if it's a put request
PutObjectRequest putObjectRequest = PutObjectRequest.builder()
                                                    .bucket("bucket-name")
                                                    .key(keyName)
                                                    .build();

//3. Define presign request,  the pre-signed URL to expire after one hour.
PutObjectPresignRequest presignRequest = PutObjectPresignRequest.builder()
                                                                .signatureDuration(Duration.ofHours(1))
                                                                .putObjectRequest(putObjectRequest)
                                                                .build();

//4. Generate presigned URL
URL presignedUrl = presigner.presignPutObject(presignRequest).url();

System.out.println("Presigned URL: " + presignedUrl);

// Close presigner when done
presigner.close();
```

#### Note: Pre-signed URL validity (Signature V4)

When generating pre-signed URLs using Signature Version 4 (SigV4), the allowed expiration window is now explicitly bounded.

- Minimum validity: 1 second

- Maximum validity: 7 days

In v1, the documentation commonly stated only the upper limit (“at most 7 days”).
SDK v2 now enforces both the minimum and maximum bounds as part of SigV4 compliance.
This means, Pre-signed URLs cannot be created with Zero or negative expiration and Expiration longer than 7 days.

-----

### CORS

#### IBM COS v1

```java
BucketCrossOriginConfiguration cors = CLIENT.getBucketCrossOriginConfiguration("bucket-name");
```

#### IBM COS v2

replaced with `GetBucketCorsRequest`, and build using builder

```java
GetBucketCorsResponse getCorsResponse = CLIENT.getBucketCors(
    GetBucketCorsRequest.builder().bucket("bucket-name").build()
);
```

#### From Cors Response

- Cors.getRules() -> getCorsResponse.corsRules();

- In IBM COS SDK for Java v2, the CORS rule getters return plain `List<String>` — not enums (unlike v1), so rule.allowedMethods().get(0).name() -> rule.allowedMethods().get(0)
  > Note: In v1, rule.allowedMethods() returned a list of CORSRule.AllowedMethods enums → hence .name(). In v2, it returns a list of strings like "GET", "PUT", etc. — so .name() is not needed.

- The following Exception is thrown from getBucketCors() is no existing Cors Exist:
  `Exception: com.ibm.cos.v2.services.s3.model.S3Exception: The CORS configuration does not exist (Service: S3, Status Code: 404, Request ID: a768f8cd-1c20-44e6-830e-68c7c0835c63) (SDK Attempt Count: 1)`

#### To create CORS rule

#### In IBM COS v1

```java
CORSRule rule1 = new CORSRule().withAllowedMethods(Arrays.asList(CORSRule.AllowedMethods.GET))
                               .withAllowedOrigins(Arrays.asList("*suffix"));
```

#### In IBM COS v2

```java
CORSRule rule1 = CORSRule.builder()
                         .allowedMethods(Arrays.asList("GET"))
                         .allowedOrigins("*suffix")
                         .build();
```

#### Set bucket CORS config

#### Example in IBM COS V1

```java
BucketCrossOriginConfiguration cors = new BucketCrossOriginConfiguration().withRules(rule1, rule2, rule3, rule4);
CLIENT.setBucketCrossOriginConfiguration("bucket-name", cors);
```

#### Example in IBM COS v2

```java
PutBucketCorsRequest putCorsRequest = PutBucketCorsRequest.builder()
                                                          .bucket("bucket-name")
                                                          .corsConfiguration(
                                                              CORSConfiguration.builder()
                                                                               .corsRules(Arrays.asList(rule1, rule2, rule3, rule4))
                                                                               .build()
                                                          )
                                                          .build();

CLIENT.putBucketCors(putCorsRequest);
```

-----

### Versioned Object Deletion

#### IBM COS v1

```java
DeleteVersionRequest deleteVersionRequest = new DeleteVersionRequest("bucket-name", "foo_copy", COPY_REQ.getVersionId());
CLIENT.deleteVersion(deleteVersionRequest);
```

#### IBM COS v2

versioned object deletion is done through DeleteObjectRequest — there’s no separate DeleteVersionRequest class like in v1.

```java
DeleteObjectRequest deleteRequest = DeleteObjectRequest.builder()
                                                       .bucket("bucket-name")
                                                       .key("foo_copy")
                                                       .versionId(COPY_REQ.versionId()) // equivalent to getVersionId()
                                                       .build();

DeleteObjectResponse deleteResponse = CLIENT.deleteObject(deleteRequest);
```

-----

### System Properties

System properties are mapped to V2 enum constants for setting credentials.

| V1 (`SDKGlobalConfiguration`)                                                                              | V2 (`SdkSystemSetting`)                                                                            |
|:-----------------------------------------------------------------------------------------------------------|:---------------------------------------------------------------------------------------------------|
| `System.setProperty(SDKGlobalConfiguration.IBM_API_KEY_SYSTEM_PROPERTY, API_KEY);`                         | `System. setProperty (SdkSystemSetting.IBM_API_KEY_ID.property(), API_KEY );`                      |
| `System.setProperty(SDKGlobalConfiguration.IBM_SERVICE_INSTANCE_ID_SYSTEM_PROPERTY, SERVICE_INSTANCE_ID);` | `System. setProperty (SdkSystemSetting.IBM_SERVICE_INSTANCE_ID.property(), SERVICE_INSTANCE_ID );` |
| `AWSCredentialsProvider provider = new SystemPropertiesCredentialsProvider();`                             | `AwsCredentialsProvider provider = SystemPropertyCredentialsProvider. create ();`                  |

-----

### ProfileCredentialsProvider

Reads credentials from `~/.aws/credentials`.

| V1 (Constructor)                                                                    | V2 (Builder)                                                                                                      |
|:------------------------------------------------------------------------------------|:------------------------------------------------------------------------------------------------------------------|
| `AWSCredentialsProvider provider = new ProfileCredentialsProvider(VALID_PROFILE);`  | `ProfileCredentialsProvider provider = ProfileCredentialsProvider.builder().profileFile(VALID_PROFILE).build();`  |

-----

### S3 Transfer Manager

V2 replaces the V1 `TransferManager` with the **`S3TransferManager`**, which requires an asynchronous client (`S3AsyncClient`).

#### V1 (Synchronous Client)

``` java
TransferManager manager = TransferManagerBuilder.standard().withS3Client(CLIENT).build();
```

#### V2 (Asynchronous Client/Builder)

``` java
TransferManager manager = TransferManagerBuilder.standard().withS3Client(CLIENT).build();
S3AsyncClient s3AsyncClient = S3AsyncClient.builder().multipartEnabled(true).build();
S3TransferManager transferManager = S3TransferManager.builder().s3Client(s3AsyncClient).build();
```

#### Upload a file to an S3 bucket

The following example shows a file upload example along with the optional use of a **`LoggingTransferListener`**, which logs the progress of the upload.

To upload a file to S3 using the S3 Transfer Manager, pass an **`UploadFileRequest`** object to the **`S3TransferManager`**'s uploadFile method.

The FileUpload object returned from the uploadFile method represents the upload process. After the request finishes, the CompletedFileUpload object contains information about the upload.

``` java
public void trackUploadFile(S3TransferManager transferManager, String bucketName, String key, URI filePathURI) {
    UploadFileRequest uploadFileRequest = UploadFileRequest.builder().putObjectRequest(b -> b.bucket(bucketName).key(key))
    .addTransferListener(LoggingTransferListener.create())  // Add listener
    .source(Paths.get(filePathURI)).build();

    FileUpload fileUpload = transferManager.uploadFile(uploadFileRequest);
    fileUpload.completionFuture().join();
}
```

-----

## IBM Supported Features

### Bucket Protection (WORM)

#### 1. setBucketProtectionConfiguration()

##### V1 (POJO/Setter)

``` java
BucketProtectionConfiguration config = new BucketProtectionConfiguration().withStatus(...)
SetBucketProtectionConfigurationRequest setConfig = new SetBucketProtectionConfigurationRequest().
                                                        withProtectionConfiguration(true);
V1CLIENT.setBucketProtectionConfiguration(setConfig);
```

##### V2 (Builder Pattern)

``` java
BucketProtectionConfiguration config = BucketProtectionConfiguration.builder().status(...).build();
PutBucketProtectionConfigurationRequest setConfig = PutBucketProtectionConfigurationRequest.builder()
                                                    .protectionConfiguration(config).build();
V2CLIENT.putBucketProtectionConfiguration(setConfig); 
```

#### 2. getBucketProtection()

##### V1 (POJO/Setter)

``` java
BucketProtectionConfiguration returnedConfig = V1CLIENT.getBucketProtection("bucket-name");
System.out.println(returnedConfig.getStatus());
```

##### V2 (Builder Pattern)

``` java
GetBucketProtectionConfigurationResponse returnedConfig =
    V2CLIENT.getBucketProtection(GetBucketProtectionConfigurationRequest.builder().bucket("bucket-name").build());
```

#### Response getter mapping

| Operation                      | V1                             | V2                          |
|--------------------------------|--------------------------------|-----------------------------|
| To get Status                  | `geStatus()`                   | `status()`                  |
| To get defaultRetentionInDays  | `getDefaultRetentionInDays()`  | `defaultRetentionInDays()`  |
| To get maximumRetentionInDays  | `getMaximumRetentionInDays()`  | `maximumRetentionInDays()`  |
| To get minimumRetentionInDays  | `getMinimumRetentionInDays()`  | `minimumRetentionInDays()`  |

#### 3. addLegalHold()

##### V1 (POJO/Setter)

``` java
V1CLIENT.addLegalHold("bucket-name", key, "LegalTest01");
```

##### V2 (Builder Pattern)

``` java
V2CLIENT.addLegalHold(AddLegalHoldRequest.builder().bucket("bucket-name").key(key).legalHoldId("LegalTest01").build());
```

#### 4. listLegalHolds()

##### V1 (POJO/Setter)

``` java
ListLegalHoldsResult result = V1CLIENT.listLegalHolds("bucket-name", "key");
```

##### V2 (Builder Pattern)

``` java
ListLegalHoldsResponse result =  V2CLIENT.listLegalHolds(ListLegalHoldsRequest.builder()
                                        .bucket(("bucket-name")
                                        .key("key")
                                        .build());
```

#### 5. deleteLegalHold()

##### V1 (POJO/Setter)

``` java
V1CLIENT.deleteLegalHold("bucket-name", "key", "LegalTest02");
```

##### V2 (Builder Pattern)

``` java
V2CLIENT.deleteLegalHold(DeleteLegalHoldRequest.builder()
        .bucket("bucket-name")
        .key("key")
        .legalHoldId("LegalTest02")
        .build());
```

-----

### Key Protect (SSE-KMS)

| Operation                  | V1 (POJO/Setter)                                                                                                                                                                  | V2 (Builder Pattern)                                                                                                                                                                                 |
|----------------------------|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Create Bucket with KMS CRN | `EncryptionType et = new EncryptionType();`  `et.setIBMSSEKMSCustomerRootKeyCrn("...");`  `CreateBucketRequest cbr = new CreateBucketRequest(bucketName).withEncryptionType(et);` | `EncryptionType et = EncryptionType.builder().ibmSSEKMSCustomerRootKeyCrn("...").build();`  `CreateBucketRequest cbr = CreateBucketRequest.builder().bucket(bucketName).encryptionType(et).build();` |
| Check Response             | `HeadBucketResult.getIBMSSEKPCrk()`                                                                                                                                               | `HeadBucketResponse.IBMSSEKPCrk()`                                                                                                                                                                   |

-----

### Extended Listing

#### V1 (Synchronous Client)

``` java
ListBucketsExtendedResponse extendedResponse = V1CLIENT.listBucketsExtended();
List<Bucket> extendedListingBuckets = extendedResponse.getBuckets(); 
```

#### V2 (Asynchronous Client/Builder)

``` java
ListBucketsExtendedResponse extendedResponse = V2CLIENT.listBucketsExtended();
List<Bucket> extendedListingBuckets = extendedResponse.buckets();
```

## Best practices for using the IBM COS SDK for Java v2

### Prevent hanging requests by configuring API timeouts

The SDK provides default values for some timeout options, such as connection timeout and socket timeouts, but not for API call timeouts or individual API call attempt timeouts. It is a good practice to set timeouts for both the individual attempts and the entire request. This will ensure your application fails fast in an optimal way when there are transient issues that could cause request attempts to take longer to complete or fatal network issues.

### Default values

| Operation                   | Default Value (in seconds) |
|-----------------------------|----------------------------|
| SOCKET_READ_TIMEOUT         | 30                         |
| SOCKET_WRITE_TIMEOUT        | 30                         |
| CONNECTION_TIMEOUT          | 2                          |
| CONNECTION_ACQUIRE_TIMEOUT  | 10                         |
| CONNECTION_MAX_IDLE_TIMEOUT | 60                         |
| CONNECTION_TIME_TO_LIVE     | 0                          |

You can configure timeouts for all requests made by a service clients using `ClientOverrideConfiguration#apiCallAttemptTimeout` and `ClientOverrideConfiguration#apiCallTimeout`

The following example shows the configuration of an Amazon S3 client with custom timeout values.

``` java
S3Client.builder()
        .overrideConfiguration(
             b -> b.apiCallTimeout(Duration.ofSeconds(<custom value>))
                   .apiCallAttemptTimeout(Duration.ofMillis(<custom value>)))
        .build();
```

apiCallAttemptTimeout:
This setting sets the amount of time for a single HTTP attempt, after which the API call can be retried.

apiCallTimeout:
The value for this property configures the amount of time for the entire execution, including all retry attempts.

As an alternative to setting these timeout values on the service client,
you can use `RequestOverrideConfiguration#apiCallTimeout()` and `RequestOverrideConfiguration#apiCallAttemptTimeout()` to configure a single request.

The following example configures a single listBuckets request with custom timeout values.

``` java
s3Client.listBuckets(lbr -> lbr.overrideConfiguration(
        b -> b.apiCallTimeout(Duration.ofSeconds(<custom value>))
               .apiCallAttemptTimeout(Duration.ofMillis(<custom value>))));
```

When you use these properties together, you set a hard limit on the total time spent on all attempts across retries. You also set an individual HTTP request to fail fast on a slow request.

### Improve performance by reusing service clients

Each service client maintains its own HTTP connection pool. A connection that already exists in the pool can be reused by a new request to cut down the time to establish a new connection. We recommend sharing a single instance of the client to avoid the overhead of having too many connection pools that aren't used effectively. All service clients are thread safe.

If you don't want to share a client instance, call close() on the instance to release the resources when the client is not needed.

### Prevent resource leaks by closing unused service clients

Close a service client to release resources, such as threads, if it is no longer needed. If you don't want to share a client instance, call close() on the instance to release the resources when the client is not needed.

### Prevent connection pool exhaustion by closing input streams

For streaming operations such as S3Client#getObject, if you are working with ResponseInputStream directly, we recommend that you do the following:

- Read all the data from the input stream as soon as possible.

- Close the input stream as soon as possible.

We make these recommendations because the input stream is a direct stream of data from the HTTP connection and the underlying HTTP connection can't be reused until all data from the stream has been read and the stream is closed.
If these rules are not followed, the client can run out of resources by allocating too many open, but unused, HTTP connections.
