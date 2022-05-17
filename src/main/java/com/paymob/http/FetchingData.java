package com.paymob.http;

import com.paymob.http.methods.List;
import com.paymob.http.methods.Retrieve;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;

import java.net.URI;
import java.net.http.HttpRequest;

public abstract class FetchingData extends ResponseHandler implements Retrieve, List {

    private static final Logger log = LogManager.getLogger(FetchingData.class);

    public FetchingData(Request request, Model model) {
        super(request, model);
    }

    public FetchingData(Request request) {
        super(request);
    }

    @Override
    public JSONObject retrieve(String referenceTransaction) {
        request = HttpRequest.newBuilder().uri(URI.create(intentionURL() + referenceTransaction + '/')).GET().headers(arrHeader()).build();
        getBody();
        request_info();
        log.debug("The retrieve transaction is: " + referenceTransaction);
        log.debug("The retrieve response is:\n" + body);
        return body;
    }

    @Override
    public JSONObject List() {
        request = HttpRequest.newBuilder().uri(URI.create(intentionURL())).GET().headers(arrHeader()).build();
        getBody();
        request_info();
        log.debug("The list response is:\n" + body);
        return body;
    }
}
