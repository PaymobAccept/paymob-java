package com.paymob.http;

public class HeaderHandler extends Model {

    protected String[] d;
    protected Request requestObject;
    protected Model model;

    public HeaderHandler(Request requestObject, Model model) {
        super(model.getBase_URL(), model.getSdk_api_version());
        this.requestObject = requestObject;
        this.model = model;
        arrHeader();
    }

    public HeaderHandler(Request requestObject) {
        this.requestObject = requestObject;
        arrHeader();
    }

    protected String[] arrHeader() {
        d = new String[] {
                    "sdk_api_version", getSdk_api_version(),
                    "sdk_language", "Java",
                    "Content-Type", "application/json",
                    "Authorization", auth_header(),
                    "sdk_authority", "paymob",
                    "sdk_lang_version", System.getProperty("java.version"),
                    "sdk_lang_version_date", System.getProperty("java.version.date"),
                    "sdk_platform", System.getProperty("os.name"),
                    "sdk_platform_version", System.getProperty("os.version"),
                    "sdk_platform_arch", System.getProperty("os.arch"),
                    "sdk_dir", System.getProperty("user.dir"),
                    "User-Agent", paymob_Sdk_version()
                };
        return d;
    }

    protected final String intentionURL() {
        return new StringBuilder()
                .append(getBase_URL())
                .append(getSdk_api_version())
                .append(getIntentionPath())
                .toString();
    }

        protected final String refundURL() {
            return new StringBuilder()
                    .append(getBase_URL())
                    .append(getSdk_api_version())
                    .append(getRefundPath())
                    .toString();
        }

        protected final String voidURL() {
            return new StringBuilder()
                    .append(getBase_URL())
                    .append(getSdk_api_version())
                    .append(getVoidPath())
                    .toString();
        }

        protected final String captureURL() {
            return new StringBuilder()
                    .append(getBase_URL())
                    .append(getSdk_api_version())
                    .append(getCapturePath())
                    .toString();
        }

    protected final String customerURL() {
        return new StringBuilder()
                .append(getBase_URL())
                .append(getSdk_api_version())
                .append(getCustomerPath())
                .toString();
    }

    protected final String paymob_Sdk_version() {
        return new StringBuilder()
                .append("Paymob Python SDK ")
                .append(getSdk_api_version())
                .toString();
    }

    protected final String auth_header() {
        return new StringBuilder().append("Token ").append(requestObject.getSecretKey()).toString();
    }
}
