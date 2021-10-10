package com.paymob.http.utils;

import com.paymob.http.methods.Delete;
import com.paymob.http.Request;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;

public abstract class DataAccessing extends EditingData implements Delete {
    public DataAccessing(Request r) {
        super(r);
    }

    @Override
    public String delete(String payload) {
       // request_info();
        client = HttpClient.newHttpClient();
        request = HttpRequest.newBuilder()
                .headers(d)
                .method("DELETE", HttpRequest.BodyPublishers.ofString(payload))
                .uri(URI.create(full_url())).build();
        getBody();
        return body; }
}