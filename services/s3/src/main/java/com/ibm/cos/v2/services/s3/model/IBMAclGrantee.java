package com.ibm.cos.v2.services.s3.model;

/**
 * This is a helper class provides predefined group grantees for commonly used ACLs
 */
public final class IBMAclGrantee {
    private IBMAclGrantee() {
        // Prevent instantiation
    }

    public static Grantee allUsers() {
        return Grantee.builder()
                      .type(Type.GROUP)
                      .uri("http://acs.amazonaws.com/groups/global/AllUsers")
                      .build();
    }

    public static Grantee authenticatedUsers() {
        return Grantee.builder()
                      .type(Type.GROUP)
                      .uri("http://acs.amazonaws.com/groups/global/AuthenticatedUsers")
                      .build();
    }

    public static Grantee logDelivery() {
        return Grantee.builder()
                      .type(Type.GROUP)
                      .uri("http://acs.amazonaws.com/groups/s3/LogDelivery")
                      .build();
    }
}
