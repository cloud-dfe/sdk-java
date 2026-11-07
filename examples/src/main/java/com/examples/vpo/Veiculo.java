package com.examples.vpo;

import io.github.sdk.Const;
import io.github.sdk.routes.Vpo;

import java.io.IOException;

import com.google.gson.JsonObject;

public class Veiculo {

    public static void main(String[] args) throws IllegalAccessException, IOException {

        try {

            int ambiente = Const.AMBIENTE_HOMOLOGACAO;
            String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJlbXAiOiJ0b2tlbl9leGVtcGxvIiwidXNyIjoidGsiLCJ0cCI6InRrIn0.Tva_viCMCeG3nkRYmi_RcJ6BtSzui60kdzIsuq5X-sQ";
            int timeout = 60;

            Vpo vpo = new Vpo(ambiente, token, timeout, false);

            JsonObject payload = new JsonObject();
            payload.addProperty("emissor", "SEMPARAR");
            payload.addProperty("placa", "BCD2E34");

            JsonObject resp = vpo.veiculo(payload);

            System.out.println(resp);

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

}
