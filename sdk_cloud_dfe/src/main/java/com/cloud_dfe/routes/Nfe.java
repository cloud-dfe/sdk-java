package com.cloud_dfe.routes;

import com.cloud_dfe.Base;
import com.google.gson.JsonObject;

public class Nfe extends Base {

    public Nfe(int ambiente, String token, int timeout, boolean debug) throws IllegalAccessException {
        super(ambiente, token, timeout, debug);
    }

    public JsonObject cria (JsonObject payload) {
        return getClient().send("POST", "/nfe", payload);
    }

    public JsonObject preview (JsonObject payload) {
        return getClient().send("POST", "/nfe/preview", payload);
    }

    public JsonObject status () {
        return getClient().send("GET", "/nfe/status", null);
    }

    public JsonObject consulta (JsonObject payload) {
        String key = checkKey(payload);
        return getClient().send("GET", "/nfe/"+key, null);
    }

    public JsonObject busca (JsonObject payload) {
        return getClient().send("POST", "/nfe/busca", payload);
    }

    public JsonObject cancela (JsonObject payload) {
        return getClient().send("POST", "/nfe/cancela", payload);
    }

    public JsonObject correcao (JsonObject payload) {
        return getClient().send("POST", "/nfe/correcao", payload);
    }

    public JsonObject inutiliza (JsonObject payload) {
        return getClient().send("POST", "/nfe/inutiliza", payload);
    }

    public JsonObject pdf (JsonObject payload) {
        String key = checkKey(payload);
        return getClient().send("GET", "/nfe/pdf/"+key, null);
    }

    public JsonObject etiqueta (JsonObject payload) {
        String key = checkKey(payload);
        return getClient().send("GET", "/nfe/pdf/etiqueta"+key, null);
    }

    public JsonObject manifesta (JsonObject payload) {
        return getClient().send("POST", "/nfe/manifesta", payload);
    }

    public JsonObject backup (JsonObject payload) {
        return getClient().send("POST", "/nfe/backup", payload);
    }

    public JsonObject download (JsonObject payload) {
        String key = checkKey(payload);
        return getClient().send("GET", "/nfe/download/"+key, null);
    }

    public JsonObject recebidas (JsonObject payload) {
        return getClient().send("POST", "/nfe/recebidas", payload);
    }

    public JsonObject interessado (JsonObject payload) {
        return getClient().send("POST", "/nfe/recebidas", payload);
    }

    public JsonObject importa (JsonObject payload) {
        return getClient().send("POST", "/nfe/importa", payload);
    }

    public JsonObject comprovante (JsonObject payload) {
        return getClient().send("POST", "/nfe/comprovante", payload);
    }

    public JsonObject cadastro (JsonObject payload) {
        return getClient().send("POST", "/nfe/cadastro", payload);
    }

}
