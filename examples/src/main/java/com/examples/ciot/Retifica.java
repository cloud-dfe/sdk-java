package com.examples.ciot;

import io.github.sdk.Const;
import io.github.sdk.routes.Ciot;

import java.io.IOException;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class Retifica {

    public static void main(String[] args) throws IllegalAccessException, IOException {

        try {

            int ambiente = Const.AMBIENTE_HOMOLOGACAO;
            String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJlbXAiOiJ0b2tlbl9leGVtcGxvIiwidXNyIjoidGsiLCJ0cCI6InRrIn0.Tva_viCMCeG3nkRYmi_RcJ6BtSzui60kdzIsuq5X-sQ";
            int timeout = 60;

            Ciot ciot = new Ciot(ambiente, token, timeout, false);

            JsonObject payload = new JsonObject();
            payload.addProperty("identificacao", "VIAGEM-0001");
            payload.addProperty("data_fim", "2026-11-13");
            payload.addProperty("valor_frete", "4800.00");
            JsonArray pagamentos = new JsonArray();
            JsonObject pagamentosItem1 = new JsonObject();
            pagamentosItem1.addProperty("forma", "1");
            pagamentosItem1.addProperty("tipo", "5");
            pagamentosItem1.addProperty("cnpj", "22333444000181");
            pagamentosItem1.addProperty("chave_pix", "22333444000181");
            pagamentosItem1.addProperty("vencimento", "2026-11-13");
            pagamentosItem1.addProperty("valor", "4800.00");
            pagamentos.add(pagamentosItem1);
            payload.add("pagamentos", pagamentos);

            JsonObject resp = ciot.retifica(payload);

            System.out.println(resp);

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

}
