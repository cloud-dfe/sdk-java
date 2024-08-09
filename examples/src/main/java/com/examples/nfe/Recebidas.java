package com.examples.nfe;

import io.github.sdk.Const;
import io.github.sdk.routes.Nfe;

import java.io.IOException;

import com.google.gson.JsonObject;

public class Recebidas {

    public static void main(String[] args) throws IllegalAccessException, IOException {

        try {

            int ambiente = Const.AMBIENTE_PRODUCAO;
            String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJlbXAiOiJ0b2tlbl9leGVtcGxvIiwidXNyIjoidGsiLCJ0cCI6InRrIn0.Tva_viCMCeG3nkRYmi_RcJ6BtSzui60kdzIsuq5X-sQ";
            int timeout = 60;

            Nfe nfe = new Nfe(ambiente, token, timeout, false);

            JsonObject payload = new JsonObject();

            payload.addProperty("chave", "50000000000000000000000000000000000000000000");
            payload.addProperty("chave_referenciada", "50000000000000000000000000000000000000000001");
            payload.addProperty("justificativa", "teste de substituicao");
            
            JsonObject resp = nfe.recebidas(payload);

            System.out.println(resp);

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

}
