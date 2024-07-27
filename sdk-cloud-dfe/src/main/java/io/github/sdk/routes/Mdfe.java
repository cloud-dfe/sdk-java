package io.github.sdk.routes;

import io.github.sdk.Base;
import com.google.gson.JsonObject;

public class Mdfe extends Base{

    public Mdfe(int ambiente, String token, int timeout, boolean debug) throws IllegalAccessException {
        super(ambiente, token, timeout, debug);
    }

    public JsonObject cria (JsonObject payload) {
        return getClient().send("POST", "/mdfe", payload);
    }

    public JsonObject preview (JsonObject payload) {
        return getClient().send("POST", "/mdfe/preview", payload);
    }

    public JsonObject status (JsonObject payload) {
        return getClient().send("POST", "/mdfe/status", payload);
    }

    public JsonObject consulta (JsonObject payload) {
        String key = checkKey(payload);
        return getClient().send("GET", "/mdfe/"+key, null);
    }

    public JsonObject busca (JsonObject payload) {
        return getClient().send("POST", "/mdfe/busca", payload);
    }

    public JsonObject cancela (JsonObject payload) {
        return getClient().send("POST", "/mdfe/cancela", payload);
    }

    public JsonObject encerra (JsonObject payload) {
        return getClient().send("POST", "/mdfe/encerra", payload);
    }

    public JsonObject condutor (JsonObject payload) {
        return getClient().send("POST", "/mdfe/condutor", payload);
    }

    public JsonObject offline () {
        return getClient().send("GET", "/mdfe/offline", null);
    }

    public JsonObject pdf (JsonObject payload) {
        String key = checkKey(payload);
        return getClient().send("GET", "/mdfe/"+key, null);
    }

    public JsonObject backup (JsonObject payload) {
        return getClient().send("POST", "/mdfe/backup", payload);
    }

    public JsonObject nfe (JsonObject payload) {
        return getClient().send("POST", "/mdfe/nfe", payload);
    }

    public JsonObject abertos (JsonObject payload) {
        return getClient().send("POST", "/mdfe/abertos", payload);
    }

    public JsonObject importa (JsonObject payload) {
        return getClient().send("POST", "/mdfe/importa", payload);
    }

}
