package com.paymob.http.utils;

import com.paymob.http.*;
import com.paymob.http.methods.Create;
import com.paymob.http.methods.Patch;
import com.paymob.http.methods.Update;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;

public abstract class EditingData extends FetchingData implements Patch, Update, Create {
    public EditingData(Request r) {
        super(r);
    }
    @Override
    public String update(String payload) {
        client = HttpClient.newHttpClient();
        request = HttpRequest.newBuilder()
                .headers(d)
                .PUT(HttpRequest.BodyPublishers.ofString(payload))
                .uri(URI.create(full_url())).build();
        getBody();
        return body; }

    @Override
    public String patch(String payload) {
        client = HttpClient.newHttpClient();
        request = HttpRequest.newBuilder()
                .headers(d)
                .method("PATCH", HttpRequest.BodyPublishers.ofString(payload))
                .uri(URI.create(full_url())).build();
        getBody();
        return body; }

    @Override
    public String create(String payload) {
        client = HttpClient.newHttpClient();
        request = HttpRequest.newBuilder()
                .headers(d)
                .POST(HttpRequest.BodyPublishers.ofString(payload))
                .uri(URI.create(full_url())).build();
        getBody();
        return body; }
}