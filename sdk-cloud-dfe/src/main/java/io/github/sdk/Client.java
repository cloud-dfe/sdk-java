package io.github.sdk;

import com.google.gson.JsonObject;

public class Client {

    private final int ambiente;
    private final int apiVersion;
    private final String token;
    private final int timeout;
    private final boolean debug;
    private final Service service;

    protected Client(int ambiente, String token, int timeout, boolean debug) throws IllegalAccessException {
        this(ambiente, token, timeout, debug, Const.API_VERSAO_PADRAO);
    }

    protected Client(int ambiente, String token, int timeout, boolean debug, int apiVersion) throws IllegalAccessException {
        
        if (token.isEmpty()) {
            throw new IllegalAccessException("O token não foi informado no processo.");
        }

        if (ambiente != Const.AMBIENTE_HOMOLOGACAO && ambiente != Const.AMBIENTE_PRODUCAO){
            throw new IllegalArgumentException("O AMBIENTE deve ser 1-PRODUÇÃO OU 2-HOMOLOGAÇÃO.");
        }

        if (apiVersion <= 0) {
            throw new IllegalArgumentException("A versão da API deve ser maior que zero.");
        }
        
        this.token = token;
        this.ambiente = ambiente;
        this.apiVersion = apiVersion;
        this.timeout = timeout;
        this.debug = debug;

        String baseUrl = "";

        if (this.ambiente == Const.AMBIENTE_HOMOLOGACAO){
            baseUrl = Const.URL_HOMOLOGACAO;
        }

        if (this.ambiente == Const.AMBIENTE_PRODUCAO){
            baseUrl = Const.URL_PRODUCAO;
        }

        baseUrl = baseUrl + this.apiVersion;

        this.service = new Service(baseUrl, this.token, this.timeout, this.debug);

    }

    public int getAmbiente() {
        return ambiente;
    }

    public int getApiVersion() {
        return apiVersion;
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