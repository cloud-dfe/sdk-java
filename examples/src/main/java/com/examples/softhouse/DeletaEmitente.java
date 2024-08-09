package com.examples.softhouse;

import io.github.sdk.Const;
import io.github.sdk.routes.Softhouse;

import java.io.IOException;

import com.google.gson.JsonObject;

public class DeletaEmitente {

    public static void main(String[] args) throws IllegalAccessException, IOException {

        try {

            int ambiente = Const.AMBIENTE_HOMOLOGACAO;
            String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJlbXAiOiJ0b2tlbl9leGVtcGxvIiwidXNyIjoidGsiLCJ0cCI6InRrIn0.Tva_viCMCeG3nkRYmi_RcJ6BtSzui60kdzIsuq5X-sQ";
            int timeout = 60;

            Softhouse softhouse = new Softhouse(ambiente, token, timeout, false);

            JsonObject payload = new JsonObject();

            payload.addProperty("doc", "25447784000121");

            JsonObject resp = softhouse.deletaEmitente(payload);

            System.out.println(resp);

        } catch (Exception e) {

            e.printStackTrace();

        }
        
    }

}
