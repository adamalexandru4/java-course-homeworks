package com.javacourse.designpatterns.facade;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Optional;

public class HttpConnectionHandler {

    private URL url;

    public HttpConnectionHandler(URL url) {
        this.url = url;
    }

    public HttpURLConnection createConnection() throws IOException {
        return (HttpURLConnection) this.url.openConnection();
    }

    public void sendRequest(HttpURLConnection httpURLConnection, String requestMethod, String body) throws IOException {
        if (requestMethod.equals("POST")) {
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setRequestMethod("POST");
            OutputStream os = httpURLConnection.getOutputStream();
            os.write(body.getBytes());
            os.flush();
            os.close();
        }
    }

    public Optional<String> getReponse(HttpURLConnection httpURLConnection) throws IOException {
        int responseCode = httpURLConnection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            return Optional.of(response.toString());
        }
        return Optional.empty();
    }
}

