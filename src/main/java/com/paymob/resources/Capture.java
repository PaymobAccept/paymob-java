package com.paymob.resources;

import com.paymob.http.Model;
import com.paymob.http.Request;
import com.paymob.http.ResponseHandler;
import com.paymob.http.methods.Create;
import org.apache.log4j.Logger;
import org.json.JSONObject;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;

public class Capture extends ResponseHandler implements Create {

    private static final Logger log3 = Logger.getLogger(Capture.class);

    public Capture(Request requestObject, Model model) {
        super(requestObject,model);
    }

    public Capture(Request requestObject) {
        super(requestObject);
    }

    @Override
    public JSONObject create(String payload) {
        client = HttpClient.newHttpClient();
        request =
                HttpRequest.newBuilder()
                        .headers(d)
                        .POST(HttpRequest.BodyPublishers.ofString(payload))
                        .uri(URI.create(captureURL()))
                        .build();
        getBody();
        request_info();
        log3.debug("The request is: " + payload);
        log3.debug("The create response is:\n" + body);
        return body;
    }
}
