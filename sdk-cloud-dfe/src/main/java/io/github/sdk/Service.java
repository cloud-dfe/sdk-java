package io.github.sdk;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Service {

    private final String baseUri;
    private final String token;
    private final int timeout;
    private final boolean debug;

    public Service (String baseUri, String token, int timeout, boolean debug) {
        this.baseUri = baseUri;
        this.token = token;
        this.timeout = timeout * 1000;
        this.debug = debug;
    }

    public String getBaseUri() {
        return baseUri;
    }

    public String getToken() {
        return token;
    }

    public int getTimeout() {
        return timeout;
    }

    public boolean getDebug() {
        return debug;
    }

    public JsonObject request(String method, String route, JsonObject payload) {
        JsonObject resp = null;

        try {

            String url = baseUri + route;

            URL obj = new URL(url);

            HttpURLConnection con = (HttpURLConnection) obj.openConnection();

            con.setRequestMethod(method);
            
            con.setRequestProperty("Authorization", token);
            con.setRequestProperty("Accept", "application/json");
            con.setRequestProperty("Content-Type", "application/json");

            con.setConnectTimeout(timeout);
            con.setReadTimeout(timeout);

            if ("POST".equalsIgnoreCase(method) || "PUT".equalsIgnoreCase(method)) {
                con.setDoOutput(true);
                String payloadString = new Gson().toJson(payload);

                try (DataOutputStream wr = new DataOutputStream(con.getOutputStream())) {
                    wr.writeBytes(payloadString);
                    wr.flush();
                }
            }

            InputStream inputStream;
            try {
                inputStream = con.getInputStream();
            } catch (Exception e) {
                inputStream = con.getErrorStream();
            }

            BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            resp = new Gson().fromJson(response.toString(), JsonObject.class);

        } catch (Exception e) {
         
            e.printStackTrace();

        }

        return resp;
    }

}
