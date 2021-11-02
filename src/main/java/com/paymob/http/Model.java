package com.paymob.http;

public class Model {

    private int sdk_api_version = 1;
    private String Base_URL = "https://next-stg.paymobsolutions.com/next/api/";

    public Model(String base_URL, int sdk_api_version) {
        this.sdk_api_version = sdk_api_version;
        Base_URL = base_URL;
    }

    public Model() {}

    protected int getSdk_api_version() {
        return sdk_api_version;
    }

    protected void setSdk_api_version(int sdk_api_version) {
        this.sdk_api_version = sdk_api_version;
    }

    protected String getBase_URL() {
        return Base_URL;
    }

    protected void setBase_URL(String base_URL) {
        Base_URL = base_URL;
    }

    protected final char getVersion() {
        return 'v';
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
}
