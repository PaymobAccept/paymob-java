package com.paymob.resources;

import com.paymob.http.FetchingData;
import com.paymob.http.Model;
import com.paymob.http.Request;
import org.apache.log4j.Logger;
import org.json.JSONObject;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;

public class Customer extends FetchingData {
    private static final Logger log6 = Logger.getLogger(FetchingData.class);

    public Customer(Request request, Model model) {
        super(request, model);
    }

    public Customer(Request request) {
        super(request);
    }

    @Override
    public JSONObject retrieve(String customerId) {
        client = HttpClient.newHttpClient();
        request = HttpRequest.newBuilder().uri(URI.create(customerURL() + customerId + '/')).GET().headers(d).build();
        getBody();
        request_info();
        log6.debug("The customer id is: " + customerId);
        log6.debug("The retrieve response is:\n" + body);
        return body;
    }

    @Override
    public JSONObject List() {
        client = HttpClient.newHttpClient();
        request = HttpRequest.newBuilder().uri(URI.create(customerURL())).GET().headers(d).build();
        getBody();
        request_info();
        log6.debug("The list response is:\n" + body);
        return body;
    }
}
