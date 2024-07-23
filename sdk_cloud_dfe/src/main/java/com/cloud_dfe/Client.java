package com.cloud_dfe;

import com.google.gson.JsonObject;

public class Client {

    private final int ambiente;
    private final String token;
    private final int timeout;
    private final boolean debug;
    private final Service service;

    protected Client(int ambiente, String token, int timeout, boolean debug) throws IllegalAccessException {
        
        if (token.isEmpty()) {
            throw new IllegalAccessException("O token não foi informado no processo.");
        }

        if (ambiente != Const.AMBIENTE_HOMOLOGACAO && ambiente != Const.AMBIENTE_PRODUCAO){
            throw new IllegalArgumentException("O AMBIENTE deve ser 1-PRODUCÃO OU 2-HOMOLOGAÇÃO.");
        }
        
        this.token = token;
        this.ambiente = ambiente;
        this.timeout = timeout;
        this.debug = debug;

        String baseUrl = "";

        if (this.ambiente == Const.AMBIENTE_HOMOLOGACAO){
            baseUrl = Const.URL_HOMOLOGACAO;
        }

        if (this.ambiente == Const.AMBIENTE_PRODUCAO){
            baseUrl = Const.URL_PRODUCAO;
        }

        this.service = new Service(baseUrl, this.token, this.timeout, this.debug);

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

    public Service getService() {
        return service;
    }

    public JsonObject send(String method, String route, JsonObject payload) {
        JsonObject resp = null;

        try {
            
            resp = service.request(method, route, payload);

        } catch (Exception e) {

            e.printStackTrace();

        }

        return resp;
    }
    
}