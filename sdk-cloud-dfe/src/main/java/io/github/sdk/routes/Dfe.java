package io.github.sdk.routes;

import io.github.sdk.Base;
import com.google.gson.JsonObject;

public class Dfe extends Base{

    public Dfe(int ambiente, String token, int timeout, boolean debug) throws IllegalAccessException {
        super(ambiente, token, timeout, debug);
    }

    public JsonObject buscaCte (JsonObject payload) {
        return getClient().send("POST", "/dfe/cte", payload);
    }

    public JsonObject buscaNfe (JsonObject payload) {
        return getClient().send("POST", "/dfe/nfe", payload);
    }

    public JsonObject buscaNfse (JsonObject payload) {
        return getClient().send("POST", "/dfe/nfse", payload);
    }

    public JsonObject downloadCte (JsonObject payload) {
        String key = checkKey(payload);
        return getClient().send("GET", "/dfe/cte/"+key, null);
    }

    public JsonObject downloadNfe (JsonObject payload) {
        String key = checkKey(payload);
        return getClient().send("GET", "/dfe/nfe/"+key, null);
    }

    public JsonObject downloadNfse (JsonObject payload) {
        String key = checkKey(payload);
        return getClient().send("GET", "/dfe/nfse/"+key, null);
    }

    public JsonObject eventos (JsonObject payload) {
        String key = checkKey(payload);
        return getClient().send("GET", "/dfe/eventos/"+key, null);
    }

    public JsonObject backup (JsonObject payload) {
        return getClient().send("POST", "/dfe/backup", payload);
    }

}
