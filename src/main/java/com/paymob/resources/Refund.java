package com.paymob.resources;

import com.paymob.http.Request;
import org.apache.log4j.Logger;
import org.json.JSONObject;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;

public class Refund extends Capture {

    private static final Logger log4 = Logger.getLogger(Refund.class);

    public Refund(Request r) {
        super(r);
    }

    @Override
    public JSONObject create(String payload) {
        client = HttpClient.newHttpClient();
        request =
                HttpRequest.newBuilder()
                        .headers(d)
                        .POST(HttpRequest.BodyPublishers.ofString(payload))
                        .uri(URI.create(refundURL()))
                        .build();
        getBody();
        request_info();
        log4.debug("The request is: " + payload);
        log4.debug("The create response is: \n" + body);
        return body;
    }
}
