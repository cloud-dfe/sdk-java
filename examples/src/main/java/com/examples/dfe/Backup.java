package com.examples.dfe;

import io.github.sdk.Const;
import io.github.sdk.routes.Dfe;

import java.io.IOException;

import com.google.gson.JsonObject;

public class Backup {

    public static void main(String[] args) throws IllegalAccessException, IOException {

        try {
        
            int ambiente = Const.AMBIENTE_HOMOLOGACAO;
            String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJlbXAiOiJ0b2tlbl9leGVtcGxvIiwidXNyIjoidGsiLCJ0cCI6InRrIn0.Tva_viCMCeG3nkRYmi_RcJ6BtSzui60kdzIsuq5X-sQ";
            int timeout = 60;

            Dfe dfe = new Dfe(ambiente, token, timeout, false);

            JsonObject payload = new JsonObject();
            payload.addProperty("tipo", "nfe");
            payload.addProperty("ano", "2021");
            payload.addProperty("mes", "10");

            JsonObject resp = dfe.backup(payload);
        
            System.out.println(resp);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
