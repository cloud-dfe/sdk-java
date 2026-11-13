package io.github.sdk.routes;

import io.github.sdk.Base;
import com.google.gson.JsonObject;

public class Nfabi extends Base{

    public Nfabi(int ambiente, String token, int timeout, boolean debug) throws IllegalAccessException {
        super(ambiente, token, timeout, debug);
    }

    public Nfabi(int ambiente, String token, int timeout, boolean debug, int apiVersion) throws IllegalAccessException {
        super(ambiente, token, timeout, debug, apiVersion);
    }

    public JsonObject status () {
        return getClient().send("GET", "/nfabi/stutus", null);
    }

    public JsonObject cria (JsonObject payload) {
        return getClient().send("POST", "/nfabi", payload);
    }

    public JsonObject consulta (JsonObject payload) {
        String key = checkKey(payload);
        return getClient().send("GET", "/nfabi/"+key, null);
    }
    
    public JsonObject cancela (JsonObject payload) {
        return getClient().send("POST", "/nfabi/cancela", payload);
    }

    public JsonObject parcela (JsonObject payload) {
        return getClient().send("POST", "/nfabi/parcela", payload);
    }

    public JsonObject desfazimento (JsonObject payload) {
        return getClient().send("POST", "/nfabi/desfazimento", payload);
    }

    public JsonObject busca (JsonObject payload) {
        return getClient().send("POST", "/nfabi/busca", payload);
    }

    public JsonObject pdf (JsonObject payload) {
        String key = checkKey(payload);
        return getClient().send("GET", "/nfabi/pdf/"+key, null);
    }

    public JsonObject preview (JsonObject payload) {
        return getClient().send("POST", "/nfabi/preview", payload);
    }

    public JsonObject backup (JsonObject payload) {
        return getClient().send("POST", "/nfabi/backup", payload);
    }

    public JsonObject importa (JsonObject payload) {
        return getClient().send("POST", "/nfabi/importa", payload);
    }
}
