package com.paymob.http;

public class Model {
    private int sdk_api_version = 1;

    protected final char getVersion() { return 'v'; }

    protected final String getBase_URL() {
        return "https://next-stg.paymobsolutions.com/next/api/";
    }

    protected final String getIntentionPath() {
        return "/intention/";
    }

    protected final String getRefundPath() {
        return "/payment-reference/refund/";
    }

    protected final String getVoidPath() {
        return "/payment-reference/void/";
    }

    protected final String getCapturePath() {
        return "/payment-reference/capture/";
    }

    protected int getSdk_api_version() {
        return sdk_api_version;
    }

    protected void setSdk_api_version(int sdk_api_version) {
        this.sdk_api_version = sdk_api_version;
    }
}
