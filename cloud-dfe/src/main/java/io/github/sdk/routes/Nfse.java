package io.github.sdk.routes;

import io.github.sdk.Base;
import com.google.gson.JsonObject;

public class Nfse extends Base {

    public Nfse(int ambiente, String token, int timeout, boolean debug) throws IllegalAccessException {
        super(ambiente, token, timeout, debug);
    }

    public JsonObject cria (JsonObject payload) {
        return getClient().send("POST", "/nfse", payload);
    }

    public JsonObject preview (JsonObject payload) {
        return getClient().send("POST", "/nfse/preview", payload);
    }

    public JsonObject pdf (JsonObject payload) {
        String key = checkKey(payload);
        return getClient().send("GET", "/nfse/pdf/"+key, null);
    }

    public JsonObject consulta (JsonObject payload) {
        String key = checkKey(payload);
        return getClient().send("GET", "/nfse/"+key, null);
    }

    public JsonObject cancela (JsonObject payload) {
        return getClient().send("POST", "/nfse/cancela", payload);
    }

    public JsonObject substitui (JsonObject payload) {
        return getClient().send("POST", "/nfse/substitui", payload);
    }

    public JsonObject busca (JsonObject payload) {
        return getClient().send("POST", "/nfse/busca", payload);
    }

    public JsonObject backup (JsonObject payload) {
        return getClient().send("POST", "/nfse/backup", payload);
    }

    public JsonObject localiza (JsonObject payload) {
        return getClient().send("POST", "/nfse/consulta", payload);
    }

    public JsonObject info (JsonObject payload) {
        
        if (!payload.has("ibge")) {
            throw new IllegalArgumentException("A chave ibge não foi informada no payload.");
        }
        
        String ibge = payload.get("ibge").getAsString();

        return getClient().send("GET", "/nfse/info/"+ibge, null);
    }

    public JsonObject conflito (JsonObject payload) {
        return getClient().send("POST", "/nfse/conflito", payload);
    }

    public JsonObject offline () {
        return getClient().send("GET", "/nfse/offline", null);
    }

    public JsonObject resolve (JsonObject payload) {
        String key = checkKey(payload);
        return getClient().send("GET", "/nfse/resolve/"+key, null);
    }



}
