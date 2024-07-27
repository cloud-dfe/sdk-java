package io.github.sdk.routes;

import io.github.sdk.Base;
import com.google.gson.JsonObject;

public class Averbacao extends Base {

    public Averbacao(int ambiente, String token, int timeout, boolean debug) throws IllegalAccessException {
        super(ambiente, token, timeout, debug);
    }

    public JsonObject atm (JsonObject payload) {
        return getClient().send("POST", "/averbacao/atm", payload);
    }

    public JsonObject atmCancela (JsonObject payload) {
        return getClient().send("POST", "/averbacao/atm/cancela", payload);
    }

    public JsonObject portoSeguro (JsonObject payload) {
        return getClient().send("POST", "/averbacao/portoseguro", payload);
    }

    public JsonObject portoSeguroCancela (JsonObject payload) {
        return getClient().send("POST", "/averbacao/portoseguro/cancela", payload);
    }

    public JsonObject elt (JsonObject payload) {
        return getClient().send("POST", "/averbacao/elt", payload);
    }
    

}