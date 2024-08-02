package io.github.sdk.routes;

import io.github.sdk.Base;
import com.google.gson.JsonObject;

public class Softhouse extends Base {

    public Softhouse(int ambiente, String token, int timeout, boolean debug) throws IllegalAccessException {
        super(ambiente, token, timeout, debug);
    }

    public JsonObject criaEmitente(JsonObject payload) {
        return getClient().send("POST", "/soft/emitente", payload);
    }

    public JsonObject atualizaEmitente(JsonObject payload) {
        return getClient().send("PUT", "/soft/emitente", payload);
    }

    public JsonObject mostraEmitente(JsonObject payload) {
        if (payload == null || !payload.has("doc")) {
            throw new IllegalArgumentException("Deve ser passado um CNPJ ou um CPF para visualizar o emitente.");
        }
        
        String doc = payload.get("doc").getAsString();
        return getClient().send("GET", "/soft/emitente/" + doc, null);
    }

    public JsonObject listaEmitente(JsonObject payload) {
        String status = payload.has("status") ? payload.get("status").getAsString() : "";
        String rota = "/soft/emitente";

        if ("deletados".equals(status) || "inativos".equals(status)) {
            rota = "/soft/emitente/deletados";
        }

        return getClient().send("GET", rota, null);
    }

    public JsonObject deletaEmitente(JsonObject payload) {
        if (payload == null || !payload.has("doc")) {
            throw new IllegalArgumentException("Deve ser passado um CNPJ ou um CPF para visualizar o emitente.");
        }
        
        String doc = payload.get("doc").getAsString();
        return getClient().send("DELETE", "/soft/emitente/" + doc, null);
    }
}
