package com.paymob.resources;

import com.paymob.http.Model;
import com.paymob.http.Request;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;

import java.net.URI;
import java.net.http.HttpRequest;

public class Refund extends Capture {

    private static final Logger log4 = LogManager.getLogger(Refund.class);

    public Refund(Request requestObject, Model model) {
        super(requestObject,model);
    }

    public Refund(Request requestObject) {
        super(requestObject);
    }

    @Override
    public JSONObject create(String payload) {
        request =
                HttpRequest.newBuilder()
                        .headers(arrHeader())
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
