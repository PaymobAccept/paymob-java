package com.paymob.http;

import org.apache.log4j.Logger;
import org.json.JSONObject;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ResponseHandler extends HeaderHandler {
    private static final Logger log11 = Logger.getLogger(HeaderHandler.class);

    protected JSONObject body;
    protected String requestEndpoint;
    protected HttpResponse<String> response;
    protected HttpRequest request;
    protected HttpClient client;

    public ResponseHandler(Request requestObject) {
        super(requestObject);
    }

    protected void getBody() {
        response = null;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            log11.error(e.getMessage());
        }
        assert response != null;

        if (response.statusCode() == 401)
            log11.error("Incorrect authentication credential: Error code: " + response.statusCode());
        else if (response.statusCode() == 404)
            log11.error("Page not found Error code: " + response.statusCode());
        else if (response.statusCode() == 405)
            log11.error("Method Not Allowed: Error code: " + response.statusCode());
        else if (response.statusCode() == 415)
            log11.error("invalid format: Error code: " + response.statusCode());
        else if (response.statusCode() == 500)
            log11.error("Internal Server Error: Error code: " + response.statusCode());
        else {
            body = new JSONObject(response.body());
            requestEndpoint = String.valueOf(response.request());
        }
    }
    protected void request_info() {
        log11.info("Sending Request to Paymob: " + requestEndpoint);
    }
}
