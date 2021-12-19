package com.paymob.http;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import java.time.Duration;
import java.util.concurrent.ExecutionException;

public class ResponseHandler extends HeaderHandler {
    private static final Logger log1 = LogManager.getLogger(HeaderHandler.class);

    protected JSONObject body;
    protected String requestEndpoint;
    protected HttpResponse<String> response;
    protected HttpRequest request;

    public ResponseHandler(Request requestObject, Model model) {
        super(requestObject, model);
    }

    public ResponseHandler(Request requestObject) {
        super(requestObject);
    }

    private final HttpClient client = HttpClient
            .newBuilder()
            .version(HttpClient.Version.HTTP_2)
            .connectTimeout(Duration.ofSeconds(2))
            .build();

    protected void getBody() {
        try {
           response = client.sendAsync(request,
                   HttpResponse.BodyHandlers.ofString()).get();
           
            if (response.statusCode() == 401)
                log1.error("Incorrect authentication credential: Error code: " + response.statusCode());
            else if (response.statusCode() == 404)
                log1.error("Page not found Error code: " + response.statusCode());
            else if (response.statusCode() == 405)
                log1.error("Method Not Allowed: Error code: " + response.statusCode());
            else if (response.statusCode() == 415)
                log1.error("invalid format: Error code: " + response.statusCode());
            else if (response.statusCode() == 500)
                log1.error("Internal Server Error: Error code: " + response.statusCode());
            else {
                body = new JSONObject(response.body());
                requestEndpoint = response.request().toString();
            }
        } catch (NullPointerException | IllegalArgumentException | InterruptedException | ExecutionException e) {
            log1.error(e.getMessage());
        }
    }

    protected void request_info() {
        log1.info("Sending Request to Paymob: " + requestEndpoint);
    }
}