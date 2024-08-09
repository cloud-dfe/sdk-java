package com.examples.cteos;

import io.github.sdk.Const;
import io.github.sdk.routes.Cteos;

import java.io.IOException;

import com.google.gson.JsonObject;

public class Busca {

    public static void main(String[] args) throws IllegalAccessException, IOException {

        try {
        
            int ambiente = Const.AMBIENTE_HOMOLOGACAO;
            String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJlbXAiOiJ0b2tlbl9leGVtcGxvIiwidXNyIjoidGsiLCJ0cCI6InRrIn0.Tva_viCMCeG3nkRYmi_RcJ6BtSzui60kdzIsuq5X-sQ";
            int timeout = 60;

            Cteos cteos = new Cteos(ambiente, token, timeout, false);

            JsonObject payload = new JsonObject();
            payload.addProperty("numero_inicial", "1214");
            payload.addProperty("numero_final", "101002");
            payload.addProperty("serie", "1");
            // payload.addProperty("data_inicial", "");
            // payload.addProperty("data_final", "2019-12-31");
            // payload.addProperty("cancel_inicial", "2019-12-01");
            // payload.addProperty("cancel_final", "2019-12-31");

            JsonObject resp = cteos.busca(payload);

            System.out.println(resp);

        } catch (Exception e) {
        
            e.printStackTrace();
        
        }
    }
}
