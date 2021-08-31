import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class FetchingData implements Retrievable {
    final private static Logger log = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    protected HttpRequest request;
    protected HttpClient client;
    protected String body;
    protected Request r;

    public FetchingData(Request r) {
        this.r = r;
    }

    @Override
    public String retrieve() {
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
                        "User-Agent", paymob_Sdk_version()).build();
        getBody();
        return body;
    }

    protected String getBody() {
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

    protected void request_info() {
        log.log(Level.INFO, "Sending Request To Paymob, Request URL: " + full_url());
    }

    protected String full_url() {
        String BASE_URL = "https://next-stg.paymobsolutions.com/api/next/";
        return new StringBuilder().append(BASE_URL).append("v1/").append("intention/").toString();
    }

    protected String paymob_Sdk_version() {
        return new StringBuilder().append("Paymob Python SDK ").append("v1").toString();
    }

    protected String auth_header() {
        return new StringBuilder().append("Token ").append(r.getSecretKey()).toString(); }}
