package com.examples.vpo;

import io.github.sdk.Const;
import io.github.sdk.routes.Vpo;

import java.io.IOException;

import com.google.gson.JsonObject;

public class Busca {

    public static void main(String[] args) throws IllegalAccessException, IOException {

        try {

            int ambiente = Const.AMBIENTE_HOMOLOGACAO;
            String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJlbXAiOiJ0b2tlbl9leGVtcGxvIiwidXNyIjoidGsiLCJ0cCI6InRrIn0.Tva_viCMCeG3nkRYmi_RcJ6BtSzui60kdzIsuq5X-sQ";
            int timeout = 60;

            Vpo vpo = new Vpo(ambiente, token, timeout, false);

            JsonObject payload = new JsonObject();
            payload.addProperty("numero_inicial", "1");
            payload.addProperty("numero_final", "1999");
            payload.addProperty("data_inicial", "2026-11-01");
            payload.addProperty("data_final", "2026-11-30");
            payload.addProperty("situacao", "COMPRADO");
            payload.addProperty("pagina", "1");

            JsonObject resp = vpo.busca(payload);

            System.out.println(resp);

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

}
