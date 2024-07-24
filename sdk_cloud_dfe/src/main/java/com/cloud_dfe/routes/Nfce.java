package com.cloud_dfe.routes;

import com.cloud_dfe.Base;
import com.google.gson.JsonObject;

public class Nfce extends Base{

    public Nfce(int ambiente, String token, int timeout, boolean debug) throws IllegalAccessException {
        super(ambiente, token, timeout, debug);
    }

    public JsonObject cria (JsonObject payload) {
        return getClient().send("POST", "/nfce", payload);
    }

    public JsonObject preview (JsonObject payload) {
        return getClient().send("POST", "/nfce/preview", payload);
    }

    public JsonObject status () {
        return getClient().send("GET", "/nfce/status", null);
    }

    public JsonObject consulta (JsonObject payload) {
        String key = checkKey(payload);
        return getClient().send("GET", "/nfce/"+key, null);
    }

    public JsonObject busca (JsonObject payload) {
        return getClient().send("POST", "/nfce/busca", payload);
    }

    public JsonObject cancela (JsonObject payload) {
        return getClient().send("POST", "/nfce/cancela", payload);
    }

    public JsonObject offline () {
        return getClient().send("GET", "/nfce/offline", null);
    }

    public JsonObject inutiliza (JsonObject payload) {
        return getClient().send("POST", "/nfce/inutiliza", payload);
    }

    public JsonObject pdf (JsonObject payload) {
        String key = checkKey(payload);
        return getClient().send("GET", "/nfce/pdf/"+key, null);
    }

    public JsonObject substitui (JsonObject payload) {
        return getClient().send("POST", "/nfce/substitui", payload);
    }

    public JsonObject backup (JsonObject payload) {
        return getClient().send("POST", "/nfce/backup", payload);
    }

    public JsonObject importa (JsonObject payload) {
        return getClient().send("POST", "/nfce/importa", payload);
    }

}
