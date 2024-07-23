package com.cloud_dfe.routes;

import com.cloud_dfe.Base;
import com.google.gson.JsonObject;

public class Certificado extends Base{

    public Certificado(int ambiente, String token, int timeout, boolean debug) throws IllegalAccessException {
        super(ambiente, token, timeout, debug);
    }

    public JsonObject atualiza (JsonObject payload) {
        return getClient().send("POST", "/certificado", payload);
    }

    public JsonObject mostra () {
        return getClient().send("GET", "/certificado", null);
    }

}
