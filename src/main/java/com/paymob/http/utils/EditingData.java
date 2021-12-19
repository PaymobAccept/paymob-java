package com.paymob.http.utils;

import com.paymob.http.FetchingData;
import com.paymob.http.Model;
import com.paymob.http.Request;
import com.paymob.http.methods.Create;
import com.paymob.http.methods.Patch;
import com.paymob.http.methods.Update;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;

import java.net.URI;
import java.net.http.HttpRequest;

public abstract class EditingData extends FetchingData implements Patch, Update, Create {
    private static final Logger log2 = LogManager.getLogger(EditingData.class);

    public EditingData(Request request, Model model) {
        super(request, model);
    }

    public EditingData(Request request) {
        super(request);
    }

    @Override
    public JSONObject update(String payload) {
        request =
                HttpRequest.newBuilder()
                        .headers(arrHeader())
                        .PUT(HttpRequest.BodyPublishers.ofString(payload))
                        .uri(URI.create(intentionURL()))
                        .build();
        getBody();
        request_info();
        log2.debug("The request is: " + payload);
        log2.debug("The update response is:\n" + body);
        return body;
    }

    @Override
    public JSONObject patch(String payload) {
        request =
                HttpRequest.newBuilder()
                        .headers(arrHeader())
                        .method("PATCH", HttpRequest.BodyPublishers.ofString(payload))
                        .uri(URI.create(intentionURL()))
                        .build();
        getBody();
        request_info();
        log2.debug("The request is: " + payload);
        log2.debug("The patch response is:\n" + body);
        return body;
    }

    @Override
    public JSONObject create(String payload){
        request =
                HttpRequest.newBuilder()
                        .headers(arrHeader())
                        .POST(HttpRequest.BodyPublishers.ofString(payload))
                        .uri(URI.create(intentionURL()))
                        .build();
        getBody();
        request_info();
        log2.debug("The request is: " + payload);
        log2.debug("The create response is:\n" + body);
        return body;
    }
}
