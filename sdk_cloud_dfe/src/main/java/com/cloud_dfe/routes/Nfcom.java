package com.cloud_dfe.routes;

import com.cloud_dfe.Base;
import com.google.gson.JsonObject;

public class Nfcom extends Base{

    public Nfcom(int ambiente, String token, int timeout, boolean debug) throws IllegalAccessException {
        super(ambiente, token, timeout, debug);
    }

    public JsonObject status () {
        return getClient().send("GET", "/nfcom/stutus", null);
    }

    public JsonObject cria (JsonObject payload) {
        return getClient().send("POST", "/nfcom", payload);
    }

    public JsonObject consulta (JsonObject payload) {
        String key = checkKey(payload);
        return getClient().send("GET", "/nfcom/"+key, null);
    }
    
    public JsonObject cancela (JsonObject payload) {
        return getClient().send("POST", "/nfcom/cancela", payload);
    }

    public JsonObject busca (JsonObject payload) {
        return getClient().send("POST", "/nfcom/busca", payload);
    }

    public JsonObject pdf (JsonObject payload) {
        String key = checkKey(payload);
        return getClient().send("GET", "/nfcom/pdf/"+key, null);
    }

    public JsonObject preview (JsonObject payload) {
        return getClient().send("POST", "/nfcom/preview", payload);
    }

    public JsonObject backup (JsonObject payload) {
        return getClient().send("POST", "/nfcom/backup", payload);
    }

    public JsonObject importa (JsonObject payload) {
        return getClient().send("POST", "/nfcom/importa", payload);
    }
}
