package com.paymob.http.utils;

import com.paymob.http.Request;
import com.paymob.http.methods.Delete;
import org.apache.log4j.Logger;
import org.json.JSONObject;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;

public abstract class DataAccessing extends EditingData implements Delete {
    private static final Logger log3 = Logger.getLogger(DataAccessing.class);

    public DataAccessing(Request r) {
        super(r);
    }

    @Override
    public JSONObject delete(String payload) {
        client = HttpClient.newHttpClient();
        request =
                HttpRequest.newBuilder()
                        .headers(d)
                        .method("DELETE", HttpRequest.BodyPublishers.ofString(payload))
                        .uri(URI.create(intentionURL()))
                        .build();
        getBody();
        request_info();
        log3.debug("The request is: " + payload);
        log3.debug("The delete response is:\n" + body);
        return body;
    }
}
