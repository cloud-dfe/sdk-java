package io.github.sdk.routes;

import io.github.sdk.Base;
import com.google.gson.JsonObject;

public class Emitente extends Base{

    public Emitente(int ambiente, String token, int timeout, boolean debug) throws IllegalAccessException {
        super(ambiente, token, timeout, debug);
    }

    public JsonObject token () {
        return getClient().send("GET", "/emitente/token", null);
    }

    public JsonObject atualiza (JsonObject payload) {
        return getClient().send("PUT", "/emitente", payload);
    }

    public JsonObject mostra () {
        return getClient().send("GET", "/emitente", null);
    }

}
