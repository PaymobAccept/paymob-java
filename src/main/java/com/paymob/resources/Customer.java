package com.paymob.resources;

import com.paymob.http.FetchingData;
import com.paymob.http.Model;
import com.paymob.http.Request;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;

import java.net.URI;
import java.net.http.HttpRequest;

public class Customer extends FetchingData {

    private static final Logger log6 = LogManager.getLogger(Customer.class);

    public Customer(Request request, Model model) {
        super(request, model);
    }

    public Customer(Request request) {
        super(request);
    }

    @Override
    public JSONObject retrieve(String customerId) {
        request = HttpRequest.newBuilder().uri(URI.create(customerURL() + customerId + '/')).GET().headers(arrHeader()).build();
        getBody();
        request_info();
        log6.debug("The customer id is: " + customerId);
        log6.debug("The retrieve response is:\n" + body);
        return body;
    }

    @Override
    public JSONObject List() {
        request = HttpRequest.newBuilder().uri(URI.create(customerURL())).GET().headers(arrHeader()).build();
        getBody();
        request_info();
        log6.debug("The list response is:\n" + body);
        return body;
    }
}
