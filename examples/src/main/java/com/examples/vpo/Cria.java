package com.examples.vpo;

import io.github.sdk.Const;
import io.github.sdk.routes.Vpo;

import java.io.IOException;

import com.google.gson.JsonObject;

public class Cria {

    public static void main(String[] args) throws IllegalAccessException, IOException {

        try {

            int ambiente = Const.AMBIENTE_HOMOLOGACAO;
            String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJlbXAiOiJ0b2tlbl9leGVtcGxvIiwidXNyIjoidGsiLCJ0cCI6InRrIn0.Tva_viCMCeG3nkRYmi_RcJ6BtSzui60kdzIsuq5X-sQ";
            int timeout = 60;

            Vpo vpo = new Vpo(ambiente, token, timeout, false);

            JsonObject payload = new JsonObject();
            payload.addProperty("numero", "1001");
            payload.addProperty("identificacao", "VIAGEM-77");
            payload.addProperty("emissor", "SEMPARAR");
            payload.addProperty("data_inicio", "2026-11-10 08:00:00");
            payload.addProperty("data_fim", "2026-11-12 18:00:00");
            JsonObject rota = new JsonObject();
            rota.addProperty("id", "58222");
            rota.addProperty("indice", "0");
            rota.addProperty("distancia_km", "45.279");
            rota.addProperty("tipo_combustivel", "DIESEL");
            payload.add("rota", rota);
            JsonObject veiculo = new JsonObject();
            veiculo.addProperty("placa", "BCD2E34");
            veiculo.addProperty("categoria", "7");
            payload.add("veiculo", veiculo);
            JsonObject transportador = new JsonObject();
            transportador.addProperty("cnpj", "22333444000181");
            transportador.addProperty("rntrc", "87654321");
            transportador.addProperty("nome", "TRANSPORTADOR EXEMPLO LTDA");
            payload.add("transportador", transportador);
            payload.addProperty("cte", "1234");

            JsonObject resp = vpo.cria(payload);

            System.out.println(resp);

            if (resp.get("sucesso").getAsBoolean()) {
                if (resp.get("codigo").getAsInt() == 5023) {
                    // lote em processamento: consultar pela chave ou esperar o webhook
                } else {
                    // VPO comprado
                }
            } else {
                // rejeição
            }

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

}
