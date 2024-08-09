package com.examples.cteos;

import io.github.sdk.Const;
import io.github.sdk.routes.Cteos;

import java.io.IOException;

import com.google.gson.JsonObject;

public class Backup {
    
    public static void main(String[] args) throws IllegalAccessException, IOException {
        
        try {
            
            int ambiente = Const.AMBIENTE_HOMOLOGACAO;
            String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJlbXAiOiJ0b2tlbl9leGVtcGxvIiwidXNyIjoidGsiLCJ0cCI6InRrIn0.Tva_viCMCeG3nkRYmi_RcJ6BtSzui60kdzIsuq5X-sQ";
            int timeout = 60;

            Cteos cteos = new Cteos(ambiente, token, timeout, false);

            JsonObject payload = new JsonObject();
            payload.addProperty("ano", "2021");
            payload.addProperty("mes", "2");

            JsonObject resp = cteos.backup(payload);

            System.out.println(resp);

        } catch (Exception e) {
        
            e.printStackTrace();
        
        }

    }
}
