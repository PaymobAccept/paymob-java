package com.paymob.http;

import org.apache.log4j.Logger;
import org.json.JSONObject;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ResponseHandler extends HeaderHandler {
    private static final Logger log1 = Logger.getLogger(HeaderHandler.class);

    protected JSONObject body;
    protected String requestEndpoint;
    protected HttpResponse<String> response;
    protected HttpRequest request;
    protected HttpClient client;

    public ResponseHandler(Request requestObject, Model model) {
        super(requestObject, model);
    }

    public ResponseHandler(Request requestObject) {
        super(requestObject);
    }

    protected void getBody() {
        response = null;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());

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
                requestEndpoint = String.valueOf(response.request());
            }

        } catch (IOException | InterruptedException | NullPointerException e) {
            log1.error(e.getMessage());
        }
        assert response != null;
    }

    protected void request_info() {
        log1.info("Sending Request to Paymob: " + requestEndpoint);
    }
}
