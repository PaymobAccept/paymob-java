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

public class PayToken extends ResponseHandler implements Create {

    private static final Logger log7 = Logger.getLogger(Capture.class);

    public PayToken(Request requestObject, Model model) {
        super(requestObject, model);
    }

    public PayToken(Request requestObject) {
        super(requestObject);
    }

    @Override
    public JSONObject create(String payload) {
        client = HttpClient.newHttpClient();
        request = HttpRequest.newBuilder().headers(d).POST(HttpRequest.BodyPublishers.ofString(payload)).uri(URI.create(motoURL())).build();
        getBody();
        request_info();
        log7.debug("The request is: " + payload);
        log7.debug("The moto response is:\n" + body);
        return body;
    }
}