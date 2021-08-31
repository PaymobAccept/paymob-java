import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;

public abstract class EditingData extends FetchingData implements Correctable, Updatable, Creatable{
    public EditingData(Request r) {
        super(r);
    }

    @Override
    public String update(String payload) {
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
        getBody();
        return body;
    }

    @Override
    public String patch(String payload) {
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
        getBody();
        return body;
    }

    @Override
    public String create(String payload) {
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
        getBody();
        return body; }}
