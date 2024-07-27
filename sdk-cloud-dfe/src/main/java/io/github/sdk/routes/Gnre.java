package io.github.sdk.routes;

import io.github.sdk.Base;
import com.google.gson.JsonObject;

public class Gnre extends Base{

    public Gnre(int ambiente, String token, int timeout, boolean debug) throws IllegalAccessException {
        super(ambiente, token, timeout, debug);
    }

    public JsonObject consulta (JsonObject payload) {
        String key = checkKey(payload);
        return getClient().send("GET", "/gnre/"+key, null);
    }

    public JsonObject cria (JsonObject payload) {
        return getClient().send("POST", "/gnre", payload);
    }

    public JsonObject config_uf (JsonObject payload) {
        return getClient().send("POST", "/gnre/configuf", payload);
    }
    
}
