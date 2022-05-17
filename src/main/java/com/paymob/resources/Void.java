package com.paymob.resources;

import com.paymob.http.Model;
import com.paymob.http.Request;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;

import java.net.URI;
import java.net.http.HttpRequest;

public class Void extends Refund {
    private static final Logger log5 = LogManager.getLogger(Void.class);

    public Void(Request requestObject) {
        super(requestObject);
    }
    public Void(Request requestObject, Model model) {
        super(requestObject, model);
    }


    @Override
    public JSONObject create(String payload) {
        request =
                HttpRequest.newBuilder()
                        .headers(arrHeader())
                        .POST(HttpRequest.BodyPublishers.ofString(payload))
                        .uri(URI.create(voidURL()))
                        .build();
        getBody();
        request_info();
        log5.debug("The request is: " + payload);
        log5.debug("The create response is:\n" + body);
        return body;
    }
}
