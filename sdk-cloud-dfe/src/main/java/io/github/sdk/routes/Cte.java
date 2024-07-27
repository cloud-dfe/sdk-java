package io.github.sdk.routes;

import io.github.sdk.Base;
import com.google.gson.JsonObject; 

public class Cte extends Base{

    public Cte(int ambiente, String token, int timeout, boolean debug) throws IllegalAccessException {
        super(ambiente, token, timeout, debug);
    }

    public JsonObject status () {
        return getClient().send("GET", "/cte/status", null);
    }

    public JsonObject consulta (JsonObject payload) {
        String key = checkKey(payload);
        return getClient().send("GET", "/cte/"+key, null);
    }

    public JsonObject pdf (JsonObject payload) {
        String key = checkKey(payload);
        return getClient().send("GET", "/cte/pdf/"+key, null);
    }

    public JsonObject cria (JsonObject payload) {
        return getClient().send("POST", "/cte", payload);
    }

    public JsonObject busca (JsonObject payload) {
        return getClient().send("POST", "/cte/busca", payload);
    }

    public JsonObject cancela (JsonObject payload) {
        return getClient().send("POST", "/cte/cancela", payload);
    }

    public JsonObject correcao (JsonObject payload) {
        return getClient().send("POST", "/cte/correcao", payload);
    }

    public JsonObject inutiliza (JsonObject payload) {
        return getClient().send("POST", "/cte/inutiliza", payload);
    }

    public JsonObject backup (JsonObject payload) {
        return getClient().send("POST", "/cte/backup", payload);
    }

    public JsonObject importa (JsonObject payload) {
        return getClient().send("POST", "/cte/importa", payload);
    }

    public JsonObject preview (JsonObject payload) {
        return getClient().send("POST", "/cte/preview", payload);
    }

    public JsonObject desacordo (JsonObject payload) {
        return getClient().send("POST", "/cte/desacordo", payload);
    }

}
