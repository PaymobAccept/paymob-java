package com.paymob.http;

import com.paymob.http.methods.List;
import com.paymob.http.methods.Retrieve;
import org.apache.log4j.Logger;
import org.json.JSONObject;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;

public abstract class FetchingData extends ResponseHandler implements Retrieve, List {

    private static final Logger log = Logger.getLogger(FetchingData.class);

    public FetchingData(Request r) {
        super(r);
    }

    @Override
    public JSONObject retrieve(String payload) {
        client = HttpClient.newHttpClient();
        request = HttpRequest.newBuilder().uri(URI.create(intentionURL())).GET().headers(d).build();
        getBody();
        request_info();
        log.debug("The request is: " + payload);
        log.debug("The retrieve response is:\n" + body);
        return body;
    }

    @Override
    public JSONObject List() {
        client = HttpClient.newHttpClient();
        request = HttpRequest.newBuilder().uri(URI.create(intentionURL())).GET().headers(d).build();
        getBody();
        request_info();
        log.debug("The list response is:\n" + body);
        return body;
    }
}
