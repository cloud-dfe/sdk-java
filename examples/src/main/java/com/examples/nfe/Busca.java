package com.examples.nfe;

import io.github.sdk.Const;
import io.github.sdk.routes.Nfe;

import java.io.IOException;

import com.google.gson.JsonObject;

public class Busca {

    public static void main(String[] args) throws IllegalAccessException, IOException {

        try {

            int ambiente = Const.AMBIENTE_HOMOLOGACAO;
            String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJlbXAiOjQ2MSwidXNyIjoxNzAsInRwIjoyLCJpYXQiOjE2NTE1MDYzMjR9.a0cOwP6BUDZAboYwMzoMjutCtFM8Ph-X4pLahZIB_V4";
            int timeout = 60;

            Nfe nfe = new Nfe(ambiente, token, timeout, false);

            JsonObject payload = new JsonObject();

            payload.addProperty("numero_inicial", 1214);
            payload.addProperty("numero_final", 101002);
            payload.addProperty("serie", 1);
            // payload.addProperty("data_inicial", "2019-12-01");
            // payload.addProperty("data_final", "2019-12-31");
            // payload.addProperty("cancel_inicial", "2019-12-01");
            // payload.addProperty("cancel_final", "2019-12-31");

            JsonObject resp = nfe.busca(payload);

            System.out.println(resp);

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

}
