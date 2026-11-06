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
        return getClient().send("POST", "/ciot", payload);
    }

    public JsonObject consulta (JsonObject payload) {
        String identificacao = checkIdentificacao(payload);
        return getClient().send("GET", "/ciot/"+identificacao, null);
    }

    public JsonObject busca (JsonObject payload) {
        return getClient().send("POST", "/ciot/busca", payload);
    }

    public JsonObject cancela (JsonObject payload) {
        return getClient().send("POST", "/ciot/cancela", payload);
    }

    public JsonObject encerra (JsonObject payload) {
        return getClient().send("POST", "/ciot/encerra", payload);
    }

    public JsonObject retifica (JsonObject payload) {
        return getClient().send("POST", "/ciot/retifica", payload);
    }

    public JsonObject pdf (JsonObject payload) {
        String identificacao = checkIdentificacao(payload);
        return getClient().send("GET", "/ciot/pdf/"+identificacao, null);
    }

    public JsonObject transportador (JsonObject payload) {
        return getClient().send("POST", "/ciot/transportador", payload);
    }

    // o CIOT é identificado pela identificação informada na criação, não por chave de acesso
    public String checkIdentificacao(JsonObject payload) {
        String identificacao = payload.has("identificacao") && !payload.get("identificacao").isJsonNull()
            ? payload.get("identificacao").getAsString().trim()
            : "";
        if (!identificacao.matches("^[A-Za-z0-9._-]{1,40}$")) {
            throw new IllegalArgumentException("A identificação do CIOT deve ter de 1 a 40 caracteres: letras, números, ponto, hífen ou sublinhado.");
        }
        return identificacao;
    }
}
