package com.examples.vpo;

import io.github.sdk.Const;
import io.github.sdk.routes.Vpo;

import java.io.IOException;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class Rota {

    public static void main(String[] args) throws IllegalAccessException, IOException {

        try {

            int ambiente = Const.AMBIENTE_HOMOLOGACAO;
            String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJlbXAiOiJ0b2tlbl9leGVtcGxvIiwidXNyIjoidGsiLCJ0cCI6InRrIn0.Tva_viCMCeG3nkRYmi_RcJ6BtSzui60kdzIsuq5X-sQ";
            int timeout = 60;

            Vpo vpo = new Vpo(ambiente, token, timeout, false);

            JsonObject payload = new JsonObject();
            JsonArray enderecos = new JsonArray();
            JsonObject enderecosItem1 = new JsonObject();
            enderecosItem1.addProperty("codigo_municipio", "3543402");
            enderecosItem1.addProperty("nome_municipio", "Ribeirão Preto");
            enderecosItem1.addProperty("uf", "SP");
            enderecos.add(enderecosItem1);
            JsonObject enderecosItem2 = new JsonObject();
            enderecosItem2.addProperty("codigo_municipio", "3505906");
            enderecosItem2.addProperty("nome_municipio", "Batatais");
            enderecosItem2.addProperty("uf", "SP");
            enderecos.add(enderecosItem2);
            payload.add("enderecos", enderecos);
            payload.addProperty("categoria", "7");
            payload.addProperty("data_inicio", "2026-11-10 08:00:00");
            payload.addProperty("tipo_combustivel", "DIESEL");

            JsonObject resp = vpo.rota(payload);

            System.out.println(resp);

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

}
