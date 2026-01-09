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

import static com.ibm.cos.v2.s3benchmarks.BenchmarkUtils.printOutResult;
import static com.ibm.cos.v2.utils.FunctionalUtils.runAndLogError;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import com.ibm.cos.v2.utils.Logger;
import com.ibm.cos.v2.utils.Validate;

public class V1TransferManagerDownloadBenchmark extends V1BaseTransferManagerBenchmark {
    private static final Logger logger = Logger.loggerFor("V1TransferManagerDownloadBenchmark");

    V1TransferManagerDownloadBenchmark(TransferManagerBenchmarkConfig config) {
        super(config);
        Validate.notNull(config.key(), "Key must not be null");
        Validate.notNull(config.filePath(), "File path must not be null");
    }

    @Override
    protected void doRunBenchmark() {
        downloadToFile();
    }

    private void downloadToFile() {
        List<Double> metrics = new ArrayList<>();
        logger.info(() -> "Starting to download to file");
        for (int i = 0; i < iteration; i++) {
            downloadOnceToFile(metrics);
        }
        long contentLength = s3Client.getObjectMetadata(bucket, key).getContentLength();
        printOutResult(metrics, "V1 Download to File", contentLength);
    }

    private void downloadOnceToFile(List<Double> latencies) {
        Path downloadPath = new File(this.path).toPath();
        long start = System.currentTimeMillis();

        try {
            transferManager.download(bucket, key, new File(this.path)).waitForCompletion();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            logger.warn(() -> "Thread interrupted when waiting for completion", e);
        }
        long end = System.currentTimeMillis();
        latencies.add((end - start) / 1000.0);
        runAndLogError(logger.logger(),
                       "Deleting file failed",
                       () -> Files.delete(downloadPath));
    }
}
