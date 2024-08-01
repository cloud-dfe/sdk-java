package com.examples.nfce;

import io.github.sdk.Const;
import io.github.sdk.routes.Nfce;

import java.io.IOException;

import com.google.gson.JsonObject;

public class Busca {

    public static void main(String[] args) throws IllegalAccessException, IOException {
        
        try {

            int ambiente = Const.AMBIENTE_HOMOLOGACAO;
            String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJlbXAiOjQ2MSwidXNyIjoxNzAsInRwIjoyLCJpYXQiOjE2NTE1MDYzMjR9.a0cOwP6BUDZAboYwMzoMjutCtFM8Ph-X4pLahZIB_V4";
            int timeout = 60;

            Nfce nfce = new Nfce(ambiente, token, timeout, false);

            JsonObject payload = new JsonObject();

            payload.addProperty("numero_inicial", 1214);
            payload.addProperty("numero_final", 101002);
            payload.addProperty("serie", 1);
            // payload.addProperty("data_inicial", "2019-12-01");
            // payload.addProperty("data_final", "2019-12-31");
            // payload.addProperty("cancel_inicial", "2019-12-01"); // Cancelamento
            // payload.addProperty("cancel_final", "2019-12-31"); // Cancelamento

            JsonObject resp = nfce.busca(payload);

            System.out.println(resp);

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

}
