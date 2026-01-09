

package com.ibm.cos.v2;

import com.ibm.cos.v2.annotations.SdkInternalApi;

@SdkInternalApi
public class IBMInternalFlag {

    //for internal use only
    public static Boolean isIAM = false;

    public static Boolean isIAM() {
        return isIAM;
    }

    public static void setIAM(Boolean value) {
        isIAM = value;
    }
}
