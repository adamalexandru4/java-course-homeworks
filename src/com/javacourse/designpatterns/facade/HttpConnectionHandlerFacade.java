package com.javacourse.designpatterns.facade;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Optional;

public class HttpConnectionHandlerFacade {

    HttpConnectionHandler httpConnectionHandler;

    public HttpConnectionHandlerFacade(URL url) {
        httpConnectionHandler = new HttpConnectionHandler(url);
    }

    public Optional<String> consume(String requestMethod, String body) throws IOException {
        HttpURLConnection httpURLConnection = httpConnectionHandler.createConnection();
        httpConnectionHandler.sendRequest(httpURLConnection, requestMethod, body);
        return httpConnectionHandler.getReponse(httpURLConnection);
    }
}
