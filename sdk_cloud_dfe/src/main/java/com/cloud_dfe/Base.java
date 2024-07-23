package com.cloud_dfe;

import com.google.gson.JsonObject;

public abstract class Base {

    private final int ambiente;
    private final String token;
    private final int timeout;
    private final boolean debug;
    private final Client client;

    protected Base(int ambiente, String token, int timeout, boolean debug) throws IllegalAccessException {
        this.ambiente = ambiente;
        this.token = token;
        this.timeout = timeout;
        this.debug = debug;

        try {
            this.client = new Client(this.ambiente, this.token, this.timeout, this.debug);
        } catch (IllegalAccessException e) {
            throw new IllegalAccessException("Não foi possível instanciar a classe Client.");
        }
    }

    public int getAmbiente() {
        return ambiente;
    }

    public String getToken() {
        return token;
    }

    public int getTimeout() {
        return timeout;
    }

    public boolean isDebug() {
        return debug;
    }

    public Client getClient() {
        return client;
    }

    public String checkKey(JsonObject payload) {
        if (!payload.has("chave")) {
            throw new IllegalArgumentException("A chave não foi informada no payload.");
        }

        String key = payload.get("chave").getAsString().replaceAll("[^0-9]", "");
        
        if (key.isEmpty() || key.length() != 44) {
            throw new IllegalArgumentException("A chave deve conter exatamente 44 dígitos numéricos.");
        }

        return key;
    }
}
