package com.cloud_dfe;

public abstract class Const {

    public static final int AMBIENTE_PRODUCAO = 1;
    public static final int AMBIENTE_HOMOLOGACAO = 2;

    public static final String URL_PRODUCAO = "https://api.integranotas.com.br/v1";
    public static final String URL_HOMOLOGACAO = "https://hom-api.integranotas.com.br/v1";

    private Const() {}
}
