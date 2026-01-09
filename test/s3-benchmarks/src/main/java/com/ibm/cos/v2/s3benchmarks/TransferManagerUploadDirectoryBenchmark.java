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

import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import com.ibm.cos.v2.transfer.s3.model.CompletedDirectoryUpload;
import com.ibm.cos.v2.transfer.s3.model.DirectoryUpload;
import com.ibm.cos.v2.utils.Logger;
import com.ibm.cos.v2.utils.Validate;

public class TransferManagerUploadDirectoryBenchmark extends BaseTransferManagerBenchmark {
    private static final Logger logger = Logger.loggerFor("TransferManagerUploadDirectoryBenchmark");
    private final TransferManagerBenchmarkConfig config;

    public TransferManagerUploadDirectoryBenchmark(TransferManagerBenchmarkConfig config) {
        super(config);
        Validate.notNull(config.filePath(), "File path must not be null");
        this.config = config;
    }

    @Override
    protected void doRunBenchmark() {

        try {
            uploadDirectory(iteration, true);
        } catch (Exception exception) {
            logger.error(() -> "Request failed: ", exception);
        }
    }

    private void uploadDirectory(int count, boolean printoutResult) throws Exception {
        List<Double> metrics = new ArrayList<>();
        logger.info(() -> "Starting to upload directory");
        for (int i = 0; i < count; i++) {
            uploadOnce(metrics);
        }
        if (printoutResult) {
            printOutResult(metrics, "TM v2 Upload Directory");
        }
    }

    private void uploadOnce(List<Double> latencies) throws Exception {
        Path uploadPath = new File(this.path).toPath();
        long start = System.currentTimeMillis();
        DirectoryUpload upload =
            transferManager.uploadDirectory(b -> b.bucket(bucket)
                                                  .s3Prefix(config.prefix())
                                                  .source(uploadPath));
        CompletedDirectoryUpload completedDirectoryUpload = upload.completionFuture().get(timeout.getSeconds(), TimeUnit.SECONDS);
        if (completedDirectoryUpload.failedTransfers().isEmpty()) {
            long end = System.currentTimeMillis();
            latencies.add((end - start) / 1000.0);
        } else {
            logger.error(() -> "Some transfers failed: " + completedDirectoryUpload.failedTransfers());
        }
    }

}
