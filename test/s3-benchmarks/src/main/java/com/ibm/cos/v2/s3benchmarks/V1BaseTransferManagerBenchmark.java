/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License").
 * You may not use this file except in compliance with the License.
 * A copy of the License is located at
 *
 *  http://aws.amazon.com/apache2.0
 *
 * or in the "license" file accompanying this file. This file is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */

package com.ibm.cos.v2.s3benchmarks;

import static com.ibm.cos.v2.s3benchmarks.BenchmarkUtils.BENCHMARK_ITERATIONS;
import static com.ibm.cos.v2.s3benchmarks.BenchmarkUtils.COPY_SUFFIX;
import static com.ibm.cos.v2.s3benchmarks.BenchmarkUtils.PRE_WARMUP_ITERATIONS;
import static com.ibm.cos.v2.s3benchmarks.BenchmarkUtils.PRE_WARMUP_RUNS;
import static com.ibm.cos.v2.s3benchmarks.BenchmarkUtils.WARMUP_KEY;
import static com.ibm.cos.v2.transfer.s3.SizeConstant.MB;
import static com.ibm.cos.v2.utils.FunctionalUtils.runAndLogError;

import com.ibm.cos.v2.ClientConfiguration;
import com.ibm.cos.v2.services.s3.AmazonS3;
import com.ibm.cos.v2.services.s3.AmazonS3Client;
import com.ibm.cos.v2.services.s3.transfer.Copy;
import com.ibm.cos.v2.services.s3.transfer.Download;
import com.ibm.cos.v2.services.s3.transfer.TransferManager;
import com.ibm.cos.v2.services.s3.transfer.TransferManagerBuilder;
import com.ibm.cos.v2.services.s3.transfer.Upload;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import com.ibm.cos.v2.testutils.RandomTempFile;
import com.ibm.cos.v2.utils.Logger;

abstract class V1BaseTransferManagerBenchmark implements TransferManagerBenchmark {
    private static final int MAX_CONCURRENCY = 100;
    private static final Logger logger = Logger.loggerFor("TransferManagerBenchmark");

    protected final TransferManager transferManager;
    protected final AmazonS3 s3Client;
    protected final String bucket;
    protected final String key;
    protected final int iteration;
    protected final String path;
    private final File tmpFile;
    private final ExecutorService executorService;

    V1BaseTransferManagerBenchmark(TransferManagerBenchmarkConfig config) {
        logger.info(() -> "Benchmark config: " + config);
        Long partSizeInMb = config.partSizeInMb() == null ? null : config.partSizeInMb() * MB;
        s3Client = AmazonS3Client.builder()
                                 .withClientConfiguration(new ClientConfiguration().withMaxConnections(MAX_CONCURRENCY))
                                 .build();
        executorService = Executors.newFixedThreadPool(MAX_CONCURRENCY);
        transferManager = TransferManagerBuilder.standard()
                                                .withMinimumUploadPartSize(partSizeInMb)
                                                .withS3Client(s3Client)
                                                .withExecutorFactory(() -> executorService)
                                                .build();
        bucket = config.bucket();
        key = config.key();
        path = config.filePath();
        iteration = config.iteration() == null ? BENCHMARK_ITERATIONS : config.iteration();
        try {
            tmpFile = new RandomTempFile(20 * MB);
        } catch (IOException e) {
            logger.error(() -> "Failed to create the file");
            throw new RuntimeException("Failed to create the temp file", e);
        }
    }

    @Override
    public void run() {
        try {
            warmUp();
            additionalWarmup();
            doRunBenchmark();
        } catch (Exception e) {
            logger.error(() -> "Exception occurred", e);
        } finally {
            cleanup();
        }
    }

    protected void additionalWarmup() {
        // default to no-op
    }

    protected abstract void doRunBenchmark();

    private void cleanup() {
        executorService.shutdown();
        transferManager.shutdownNow();
        s3Client.shutdown();
    }

    private void warmUp() {
        logger.info(() -> "Starting to warm up");

        for (int i = 0; i < PRE_WARMUP_ITERATIONS; i++) {
            warmUpUploadBatch();
            warmUpDownloadBatch();
            warmUpCopyBatch();

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                logger.warn(() -> "Thread interrupted when waiting for completion", e);
            }
        }
        logger.info(() -> "Ending warm up");
    }

    private void warmUpCopyBatch() {
        List<Copy> uploads = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            uploads.add(transferManager.copy(bucket, WARMUP_KEY, bucket, WARMUP_KEY + COPY_SUFFIX));
        }

        uploads.forEach(u -> {
            try {
                u.waitForCopyResult();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                logger.error(() -> "Thread interrupted ", e);
            }
        });
    }

    private void warmUpDownloadBatch() {
        List<Download> downloads = new ArrayList<>();
        List<File> tmpFiles = new ArrayList<>();
        for (int i = 0; i < PRE_WARMUP_RUNS; i++) {
            File tmpFile = RandomTempFile.randomUncreatedFile();
            tmpFiles.add(tmpFile);
            downloads.add(transferManager.download(bucket, WARMUP_KEY, tmpFile));
        }

        downloads.forEach(u -> {
            try {
                u.waitForCompletion();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                logger.error(() -> "Thread interrupted ", e);
            }
        });

        tmpFiles.forEach(f -> runAndLogError(logger.logger(), "Deleting file failed", () -> Files.delete(f.toPath())));
    }

    private void warmUpUploadBatch() {
        List<Upload> uploads = new ArrayList<>();
        for (int i = 0; i < PRE_WARMUP_RUNS; i++) {
            uploads.add(transferManager.upload(bucket, WARMUP_KEY, tmpFile));
        }

        uploads.forEach(u -> {
            try {
                u.waitForUploadResult();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                logger.error(() -> "Thread interrupted ", e);
            }
        });
    }
}
