package com.examples.ciot;

import io.github.sdk.Const;
import io.github.sdk.routes.Ciot;

import java.io.IOException;

import com.google.gson.JsonObject;

public class Consulta {

    public static void main(String[] args) throws IllegalAccessException, IOException {

        try {

            int ambiente = Const.AMBIENTE_HOMOLOGACAO;
            String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJlbXAiOiJ0b2tlbl9leGVtcGxvIiwidXNyIjoidGsiLCJ0cCI6InRrIn0.Tva_viCMCeG3nkRYmi_RcJ6BtSzui60kdzIsuq5X-sQ";
            int timeout = 60;

            Ciot ciot = new Ciot(ambiente, token, timeout, false);

            JsonObject payload = new JsonObject();
            payload.addProperty("identificacao", "VIAGEM-0001");

            JsonObject resp = ciot.consulta(payload);

            System.out.println(resp);

            if (resp.get("sucesso").getAsBoolean()) {
                if (resp.get("codigo").getAsInt() == 5023) {
                    // lote em processamento: consultar pela identificação ou esperar o webhook
                } else {
                    // CIOT declarado
                }
            } else {
                // rejeição
            }

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

}
