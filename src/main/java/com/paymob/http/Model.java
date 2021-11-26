package com.paymob.http;

public class Model {

    private String sdk_api_version = "v1";
    private String Base_URL = "https://flashapi.paymob.com/";

    public Model(String base_URL, String sdk_api_version) {
        this.sdk_api_version = sdk_api_version;
        Base_URL = base_URL;
    }

    public Model() {}

    protected String getSdk_api_version() {
        return sdk_api_version;
    }

    protected void setSdk_api_version(String sdk_api_version) {
        this.sdk_api_version = sdk_api_version;
    }

    protected String getBase_URL() {
        return Base_URL;
    }

    protected void setBase_URL(String base_URL) {
        Base_URL = base_URL;
    }

    protected final String getIntentionPath() {
        return "/intention/";
    }

    protected final String getCustomerPath() {
        return "/customer/";
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
