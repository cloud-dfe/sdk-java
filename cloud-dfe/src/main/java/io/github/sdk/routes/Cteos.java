package io.github.sdk.routes;

import io.github.sdk.Base;
import com.google.gson.JsonObject; 

public class Cteos extends Base{

    public Cteos(int ambiente, String token, int timeout, boolean debug) throws IllegalAccessException {
        super(ambiente, token, timeout, debug);
    }

    public JsonObject status () {
        return getClient().send("GET", "/cteos/status", null);
    }

    public JsonObject consulta (JsonObject payload) {
        String key = checkKey(payload);
        return getClient().send("GET", "/cteos/"+key, null);
    }

    public JsonObject pdf (JsonObject payload) {
        String key = checkKey(payload);
        return getClient().send("GET", "/cteos/pdf/"+key, null);
    }

    public JsonObject cria (JsonObject payload) {
        return getClient().send("POST", "/cteos", payload);
    }

    public JsonObject busca (JsonObject payload) {
        return getClient().send("POST", "/cteos/busca", payload);
    }

    public JsonObject cancela (JsonObject payload) {
        return getClient().send("POST", "/cteos/cancela", payload);
    }

    public JsonObject correcao (JsonObject payload) {
        return getClient().send("POST", "/cteos/correcao", payload);
    }

    public JsonObject inutiliza (JsonObject payload) {
        return getClient().send("POST", "/cteos/inutiliza", payload);
    }

    public JsonObject backup (JsonObject payload) {
        return getClient().send("POST", "/cteos/backup", payload);
    }

    public JsonObject importa (JsonObject payload) {
        return getClient().send("POST", "/cteos/importa", payload);
    }

    public JsonObject preview (JsonObject payload) {
        return getClient().send("POST", "/cteos/preview", payload);
    }

    public JsonObject desacordo (JsonObject payload) {
        return getClient().send("POST", "/cteos/desacordo", payload);
    }

}
