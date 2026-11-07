package io.github.sdk.routes;

import io.github.sdk.Base;
import com.google.gson.JsonObject;

public class Vpo extends Base{

    public Vpo(int ambiente, String token, int timeout, boolean debug) throws IllegalAccessException {
        super(ambiente, token, timeout, debug);
    }

    public Vpo(int ambiente, String token, int timeout, boolean debug, int apiVersion) throws IllegalAccessException {
        super(ambiente, token, timeout, debug, apiVersion);
    }

    public JsonObject cria (JsonObject payload) {
        return getClient().send("POST", "/vpo/ailog", payload);
    }

    public JsonObject consulta (JsonObject payload) {
        String key = checkKey(payload);
        return getClient().send("GET", "/vpo/ailog/"+key, null);
    }

    public JsonObject busca (JsonObject payload) {
        return getClient().send("POST", "/vpo/ailog/busca", payload);
    }

    public JsonObject cancela (JsonObject payload) {
        return getClient().send("POST", "/vpo/ailog/cancela", payload);
    }

    public JsonObject reemite (JsonObject payload) {
        return getClient().send("POST", "/vpo/ailog/reemite", payload);
    }

    public JsonObject rota (JsonObject payload) {
        return getClient().send("POST", "/vpo/ailog/rota", payload);
    }

    public JsonObject pdf (JsonObject payload) {
        String key = checkKey(payload);
        return getClient().send("GET", "/vpo/ailog/pdf/"+key, null);
    }

    public JsonObject veiculo (JsonObject payload) {
        return getClient().send("POST", "/vpo/ailog/veiculo", payload);
    }

}
