import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class handling_in implements Create_in, Patch_in, Delete_in, Update, Retrieve_in {
    final private static Logger log = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    private HttpRequest request;
    private HttpClient client;
    private String body;
    private Request r;

    public handling_in(Request r) {
        this.r = r;
    }

    @Override
    public String Delete(String payload) {
        request_info();
        client = HttpClient.newHttpClient();
        request = HttpRequest.newBuilder()
                .headers("sdk_api_version", "v1",
                        "sdk_language", "Java",
                        "Content-Type", "application/json",
                        "Authorization", auth_header(),
                        "sdk_authority", "paymob",
                        "sdk_lang_version", System.getProperty("java.version"),
                        "sdk_platform", System.getProperty("os.name"),
                        "User-Agent", paymob_Sdk_version())
                .method("DELETE", HttpRequest.BodyPublishers.ofString(payload))
                .uri(URI.create(full_url())).build();
        get_body();

        return body;
    }

    @Override
    public String Update(String payload) {
        request_info();
        client = HttpClient.newHttpClient();
        request = HttpRequest.newBuilder()
                .headers("sdk_api_version", "v1",
                        "sdk_language", "Java",
                        "Content-Type", "application/json",
                        "Authorization", auth_header(),
                        "sdk_authority", "paymob",
                        "sdk_lang_version", System.getProperty("java.version"),
                        "sdk_platform", System.getProperty("os.name"),
                        "User-Agent", paymob_Sdk_version())
                .PUT(HttpRequest.BodyPublishers.ofString(payload))
                .uri(URI.create(full_url())).build();
        get_body();
        return body;
    }

    @Override
    public String Create(String payload) {
        request_info();
        client = HttpClient.newHttpClient();
        request = HttpRequest.newBuilder()
                .headers("sdk_api_version", "v1",
                        "sdk_language", "Java",
                        "Content-Type", "application/json",
                        "Authorization", auth_header(),
                        "sdk_authority", "paymob",
                        "sdk_lang_version", System.getProperty("java.version"),
                        "sdk_platform", System.getProperty("os.name"),
                        "User-Agent", paymob_Sdk_version())
                .POST(HttpRequest.BodyPublishers.ofString(payload))
                .uri(URI.create(full_url())).build();
        get_body();
        return body;
    }

    @Override
    public String Patch(String payload) {
        request_info();
        client = HttpClient.newHttpClient();
        request = HttpRequest.newBuilder()

                .headers("sdk_api_version", "v1",
                        "sdk_language", "Java",
                        "Content-Type", "application/json",
                        "Authorization", auth_header(),
                        "sdk_authority", "paymob",
                        "sdk_lang_version", System.getProperty("java.version"),
                        "sdk_platform", System.getProperty("os.name"),
                        "User-Agent", paymob_Sdk_version())
                .method("PATCH", HttpRequest.BodyPublishers.ofString(payload))
                .uri(URI.create(full_url())).build();
        get_body();
        return body;
    }

    @Override
    public String Retrieve() {

        request_info();
        client = HttpClient.newHttpClient();
        request = HttpRequest.newBuilder()
                .uri(URI.create(full_url())).GET()
                .headers("sdk_api_version", "v1",
                        "sdk_language", "Java",
                        "Content-Type", "application/json",
                        "Authorization", auth_header(),
                        "sdk_authority", "paymob",
                        "sdk_lang_version", System.getProperty("java.version"),
                        "sdk_platform", System.getProperty("os.name"),
                        "User-Agent", paymob_Sdk_version())
                .build();
        get_body();

        return body;
    }

    private String get_body() {
        HttpResponse<String> responseOfString = null;
        try {
            responseOfString = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        assert responseOfString != null;

        if (responseOfString.statusCode() == 401)
            log.log(Level.WARNING, "Incorrect authentication credentials");

        else if (responseOfString.statusCode() == 404)
            log.log(Level.WARNING, "Page not found");

        else if (responseOfString.statusCode() == 405)
            log.log(Level.WARNING, "Method Not Allowed");

        else if (responseOfString.statusCode() == 415)
            log.log(Level.WARNING, "invalid format");

        else if (responseOfString.statusCode() == 500)
            log.log(Level.WARNING, "Internal Server Error");

        else
            body = responseOfString.body();

        return body;
    }

    private void request_info() {
        log.log(Level.INFO, "Sending Request To Paymob, Request URL: " + full_url());
    }

    private String full_url() {
        String BASE_URL = "https://next-stg.paymobsolutions.com/api/next/";
        return new StringBuilder().append(BASE_URL).append("v1/").append("intention/").toString();

    }

    private String paymob_Sdk_version() {
        return new StringBuilder().append("Paymob Python SDK ").append("v1").toString();
    }

    private String auth_header() {
        return new StringBuilder().append("Token ").append(r.getSecret_key()).toString();
    }
}
