package com.examples.vpo;

import io.github.sdk.Const;
import io.github.sdk.routes.Vpo;

import java.io.IOException;

import com.google.gson.JsonObject;

public class Reemite {

    public static void main(String[] args) throws IllegalAccessException, IOException {

        try {

            int ambiente = Const.AMBIENTE_HOMOLOGACAO;
            String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJlbXAiOiJ0b2tlbl9leGVtcGxvIiwidXNyIjoidGsiLCJ0cCI6InRrIn0.Tva_viCMCeG3nkRYmi_RcJ6BtSzui60kdzIsuq5X-sQ";
            int timeout = 60;

            Vpo vpo = new Vpo(ambiente, token, timeout, false);

            JsonObject payload = new JsonObject();
            payload.addProperty("chave", "41261122333444000181930010000010011360347860");
            JsonObject veiculo = new JsonObject();
            veiculo.addProperty("placa", "CDE3F45");
            veiculo.addProperty("categoria", "7");
            payload.add("veiculo", veiculo);
            payload.addProperty("observacao", "Troca do cavalo mecanico");

            JsonObject resp = vpo.reemite(payload);

            System.out.println(resp);

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

}
