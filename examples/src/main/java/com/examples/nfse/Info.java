package com.examples.nfse;

import io.github.sdk.Const;
import io.github.sdk.routes.Nfse;

import java.io.IOException;

import com.google.gson.JsonObject;

public class Info {

    public static void main(String[] args) throws IllegalAccessException, IOException {

        try {

            int ambiente = Const.AMBIENTE_HOMOLOGACAO;
            String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJlbXAiOiJ0b2tlbl9leGVtcGxvIiwidXNyIjoidGsiLCJ0cCI6InRrIn0.Tva_viCMCeG3nkRYmi_RcJ6BtSzui60kdzIsuq5X-sQ";
            int timeout = 60;

            Nfse nfse = new Nfse(ambiente, token, timeout, false);

            JsonObject payload = new JsonObject();

            payload.addProperty("ibge", "4200101");

            JsonObject resp = nfse.info(payload);

            System.out.println(resp);

        } catch (Exception e) {

            e.printStackTrace();

        }
        
    }

}
