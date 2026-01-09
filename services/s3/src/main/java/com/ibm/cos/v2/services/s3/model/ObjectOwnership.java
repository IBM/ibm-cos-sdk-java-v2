/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"). You may not use this file except in compliance with
 * the License. A copy of the License is located at
 * 
 * http://aws.amazon.com/apache2.0
 * 
 * or in the "license" file accompanying this file. This file is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR
 * CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions
 * and limitations under the License.
 */

package com.ibm.cos.v2.services.s3.model;

import java.util.EnumSet;
import java.util.Map;
import java.util.Set;
import com.ibm.cos.v2.annotations.Generated;
import com.ibm.cos.v2.utils.internal.EnumUtils;

/**
 * <p>
 * The container element for object ownership for a bucket's ownership controls.
 * </p>
 * <p>
 * <code>BucketOwnerPreferred</code> - Objects uploaded to the bucket change ownership to the bucket owner if the
 * objects are uploaded with the <code>bucket-owner-full-control</code> canned ACL.
 * </p>
 * <p>
 * <code>ObjectWriter</code> - The uploading account will own the object if the object is uploaded with the
 * <code>bucket-owner-full-control</code> canned ACL.
 * </p>
 * <p>
 * <code>BucketOwnerEnforced</code> - Access control lists (ACLs) are disabled and no longer affect permissions. The
 * bucket owner automatically owns and has full control over every object in the bucket. The bucket only accepts PUT
 * requests that don't specify an ACL or specify bucket owner full control ACLs (such as the predefined
 * <code>bucket-owner-full-control</code> canned ACL or a custom ACL in XML format that grants the same permissions).
 * </p>
 * <p>
 * By default, <code>ObjectOwnership</code> is set to <code>BucketOwnerEnforced</code> and ACLs are disabled. We
 * recommend keeping ACLs disabled, except in uncommon use cases where you must control access for each object
 * individually. For more information about S3 Object Ownership, see <a
 * href="https://docs.aws.amazon.com/AmazonS3/latest/userguide/about-object-ownership.html">Controlling ownership of
 * objects and disabling ACLs for your bucket</a> in the <i>Amazon S3 User Guide</i>.
 * </p>
 * <note>
 * <p>
 * This functionality is not supported for directory buckets. Directory buckets use the bucket owner enforced setting
 * for S3 Object Ownership.
 * </p>
 * </note>
 */
@Generated("com.ibm.cos.v2:codegen")
public enum ObjectOwnership {
    BUCKET_OWNER_PREFERRED("BucketOwnerPreferred"),

    OBJECT_WRITER("ObjectWriter"),

    BUCKET_OWNER_ENFORCED("BucketOwnerEnforced"),

    UNKNOWN_TO_SDK_VERSION(null);

    private static final Map<String, ObjectOwnership> VALUE_MAP = EnumUtils.uniqueIndex(ObjectOwnership.class,
            ObjectOwnership::toString);

    private final String value;

    private ObjectOwnership(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    /**
     * Use this in place of valueOf to convert the raw string returned by the service into the enum value.
     *
     * @param value
     *        real value
     * @return ObjectOwnership corresponding to the value
     */
    public static ObjectOwnership fromValue(String value) {
        if (value == null) {
            return null;
        }
        return VALUE_MAP.getOrDefault(value, UNKNOWN_TO_SDK_VERSION);
    }

    /**
     * Use this in place of {@link #values()} to return a {@link Set} of all values known to the SDK. This will return
     * all known enum values except {@link #UNKNOWN_TO_SDK_VERSION}.
     *
     * @return a {@link Set} of known {@link ObjectOwnership}s
     */
    public static Set<ObjectOwnership> knownValues() {
        Set<ObjectOwnership> knownValues = EnumSet.allOf(ObjectOwnership.class);
        knownValues.remove(UNKNOWN_TO_SDK_VERSION);
        return knownValues;
    }
}
