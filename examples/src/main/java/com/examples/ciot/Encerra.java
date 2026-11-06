package com.examples.ciot;

import io.github.sdk.Const;
import io.github.sdk.routes.Ciot;

import java.io.IOException;

import com.google.gson.JsonObject;

public class Encerra {

    public static void main(String[] args) throws IllegalAccessException, IOException {

        try {

            int ambiente = Const.AMBIENTE_HOMOLOGACAO;
            String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJlbXAiOiJ0b2tlbl9leGVtcGxvIiwidXNyIjoidGsiLCJ0cCI6InRrIn0.Tva_viCMCeG3nkRYmi_RcJ6BtSzui60kdzIsuq5X-sQ";
            int timeout = 60;

            Ciot ciot = new Ciot(ambiente, token, timeout, false);

            JsonObject payload = new JsonObject();
            payload.addProperty("identificacao", "VIAGEM-0001");
            JsonObject carga = new JsonObject();
            carga.addProperty("tipo", "05");
            carga.addProperty("natureza", "8414");
            carga.addProperty("peso", "1520");
            payload.add("carga", carga);

            JsonObject resp = ciot.encerra(payload);

            System.out.println(resp);

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

}
