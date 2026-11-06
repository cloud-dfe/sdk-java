package com.examples.ciot;

import io.github.sdk.Const;
import io.github.sdk.routes.Ciot;

import java.io.IOException;

import com.google.gson.JsonObject;

public class Busca {

    public static void main(String[] args) throws IllegalAccessException, IOException {

        try {

            int ambiente = Const.AMBIENTE_HOMOLOGACAO;
            String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJlbXAiOiJ0b2tlbl9leGVtcGxvIiwidXNyIjoidGsiLCJ0cCI6InRrIn0.Tva_viCMCeG3nkRYmi_RcJ6BtSzui60kdzIsuq5X-sQ";
            int timeout = 60;

            Ciot ciot = new Ciot(ambiente, token, timeout, false);

            JsonObject payload = new JsonObject();
            payload.addProperty("data_inicial", "2026-11-01");
            payload.addProperty("data_final", "2026-11-30");
            payload.addProperty("situacao", "ABERTO");
            payload.addProperty("pagina", "1");

            JsonObject resp = ciot.busca(payload);

            System.out.println(resp);

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

}
