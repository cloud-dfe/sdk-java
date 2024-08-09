package com.examples.cteos;

import io.github.sdk.Const;
import io.github.sdk.routes.Cteos;

import java.io.IOException;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class Correcao {

    public static void main(String[] args) throws IllegalAccessException, IOException {
        
        try {

            int ambiente = Const.AMBIENTE_HOMOLOGACAO;
            String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJlbXAiOiJ0b2tlbl9leGVtcGxvIiwidXNyIjoidGsiLCJ0cCI6InRrIn0.Tva_viCMCeG3nkRYmi_RcJ6BtSzui60kdzIsuq5X-sQ";
            int timeout = 60;

            Cteos cteos = new Cteos(ambiente, token, timeout, false);

            JsonObject payload = new JsonObject();
            payload.addProperty("chave", "50000000000000000000000000000000000000000000");

            JsonObject correcao = new JsonObject();
            correcao.addProperty("grupo_corrigido", "ide");
            correcao.addProperty("campo_corrigido", "natOp");
            correcao.addProperty("valor_corrigido", "PRESTACAO DE SERVIÇO");

            JsonArray correcoes = new JsonArray();
            correcoes.add(correcao);

            payload.add("correcoes", correcoes);

            JsonObject resp = cteos.correcao(payload);

            System.out.println(resp);
        
        } catch (Exception e) {
            
            e.printStackTrace();
            
        }
    }

}
