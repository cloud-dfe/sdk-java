package io.github.sdk.routes;

import io.github.sdk.Base;
import com.google.gson.JsonObject;

public class Ciot extends Base{

    public Ciot(int ambiente, String token, int timeout, boolean debug) throws IllegalAccessException {
        super(ambiente, token, timeout, debug);
    }

    public Ciot(int ambiente, String token, int timeout, boolean debug, int apiVersion) throws IllegalAccessException {
        super(ambiente, token, timeout, debug, apiVersion);
    }

    public JsonObject cria (JsonObject payload) {
        return getClient().send("POST", "/ciot/ailog", payload);
    }

    public JsonObject consulta (JsonObject payload) {
        String key = checkKey(payload);
        return getClient().send("GET", "/ciot/ailog/"+key, null);
    }

    public JsonObject busca (JsonObject payload) {
        return getClient().send("POST", "/ciot/ailog/busca", payload);
    }

    public JsonObject cancela (JsonObject payload) {
        return getClient().send("POST", "/ciot/ailog/cancela", payload);
    }

    public JsonObject encerra (JsonObject payload) {
        return getClient().send("POST", "/ciot/ailog/encerra", payload);
    }

    public JsonObject retifica (JsonObject payload) {
        return getClient().send("POST", "/ciot/ailog/retifica", payload);
    }

    public JsonObject pdf (JsonObject payload) {
        String key = checkKey(payload);
        return getClient().send("GET", "/ciot/ailog/pdf/"+key, null);
    }

    public JsonObject transportador (JsonObject payload) {
        return getClient().send("POST", "/ciot/ailog/transportador", payload);
    }

}
