package com.paymob.http;

import com.paymob.http.methods.Retrieve;
import org.apache.log4j.*;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;



public abstract class FetchingData implements Retrieve {
 //  final private static Logger log = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

 //   private static Logger log2= Logger.getLogger(com.paymob.http.FetchingData.class);
 private static Logger log = Logger.getLogger(FetchingData.class);
    Layout layout = new SimpleLayout();
    //create appender + link layout
    Appender app = new ConsoleAppender(layout);

    protected HttpRequest request;
    protected HttpClient client;
    protected String body;
    protected Request r;
    protected String d[];


    public FetchingData(Request r) {
        this.r = r;
        d = new String[]{
                "sdk_api_version", "v1",
                "sdk_language", "Java",
                "Content-Type", "application/json",
                "Authorization", auth_header(),
                "sdk_authority", "paymob",
                "sdk_lang_version", System.getProperty("java.version"),
                "sdk_platform", System.getProperty("os.name"),
                "User-Agent", paymob_Sdk_version()};
        request_info();
    }

    @Override
    public String retrieve() {
        client = HttpClient.newHttpClient();
        request = HttpRequest.newBuilder()
                .uri(URI.create(full_url())).GET()
                .headers(d).build();
        getBody();
        return body; }

    protected String getBody() {
        HttpResponse<String> responseOfString = null;
        try {
            responseOfString = client.send(request, HttpResponse.BodyHandlers.ofString());

        } catch (IOException | InterruptedException e) {
            e.printStackTrace(); }

        assert responseOfString != null;

        log.addAppender(app);
        if (responseOfString.statusCode() == 401)
            log.error("Incorrect authentication credentials");
           // log.log(Level.WARNING, "Incorrect authentication credentials");
        else if (responseOfString.statusCode() == 404)
            log.error("Page not found");
         //  log.log(Level.WARNING, "Page not found");
        else if (responseOfString.statusCode() == 405)
            log.error("Method Not Allowed");
            //log.log(Level.WARNING, "Method Not Allowed");
        else if (responseOfString.statusCode() == 415)
            log.error("invalid format");
            //log.log(Level.WARNING, "invalid format");
        else if (responseOfString.statusCode() == 500)
            log.error("Internal Server Error");
            //log.log(Level.WARNING, "Internal Server Error");
        else
            body = responseOfString.body();
        return body; }

    protected void request_info() {
       // log.log(Level.INFO, "Sending com.paymob.http.Request To Paymob, com.paymob.http.Request URL: " + full_url());
        log.info("Sending com.paymob.http.Request To Paymob, com.paymob.http.Request URL: " + full_url());
    }

    protected String full_url() {
        String BASE_URL = "https://next-stg.paymobsolutions.com/next/api/";
        return new StringBuilder().append(BASE_URL).append("v1/").append("intention/").toString(); }

    protected String paymob_Sdk_version() {
        return new StringBuilder().append("Paymob Python SDK ").append("v1").toString(); }

    protected String auth_header() {
        return new StringBuilder().append("Token ").append(r.getSecretKey()).toString(); }
}
