package com.examples.nfe;

import io.github.sdk.Const;
import io.github.sdk.routes.Nfe;

import java.io.IOException;

import com.google.gson.JsonObject;

public class Manifesta {

    public static void main(String[] args) throws IllegalAccessException, IOException {

        try {

            int ambiente = Const.AMBIENTE_PRODUCAO;
            String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJlbXAiOjQ2MSwidXNyIjoxNzAsInRwIjoyLCJpYXQiOjE2NTE1MDYzMjR9.a0cOwP6BUDZAboYwMzoMjutCtFM8Ph-X4pLahZIB_V4";
            int timeout = 60;

            Nfe nfe = new Nfe(ambiente, token, timeout, false);

            JsonObject payload = new JsonObject();

            payload.addProperty("chave", "50000000000000000000000000000000000000000000");
            payload.addProperty("tipo_evento", "210210");

            JsonObject resp = nfe.manifesta(payload);

            System.out.println(resp);

        } catch (Exception e) {

            e.printStackTrace();

        }
        
    }

}
