package com.paymob.http.utils;

import com.paymob.http.Model;
import com.paymob.http.Request;
import com.paymob.http.methods.Delete;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;

import java.net.URI;
import java.net.http.HttpRequest;

public abstract class DataAccessing extends EditingData implements Delete {
    private static final Logger log3 = LogManager.getLogger(DataAccessing.class);

    public DataAccessing(Request request, Model model) {
        super(request, model);
    }

    public DataAccessing(Request request) {
        super(request);
    }

    @Override
    public JSONObject delete(String payload) {
        request =
                HttpRequest.newBuilder()
                        .headers(arrHeader())
                        .DELETE()
                        .uri(URI.create(intentionURL()))
                        .build();
        getBody();
        request_info();
        log3.debug("The request is: " + payload);
        log3.debug("The delete response is:\n" + body);
        return body;
    }
}
