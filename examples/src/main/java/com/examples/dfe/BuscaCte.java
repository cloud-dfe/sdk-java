package com.examples.dfe;

import io.github.sdk.Const;
import io.github.sdk.routes.Dfe;

import java.io.IOException;

import com.google.gson.JsonObject;

public class BuscaCte {

    public static void main(String[] args) throws IllegalAccessException, IOException {

        try {
        
            int ambiente = Const.AMBIENTE_HOMOLOGACAO;
            String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJlbXAiOjQ2MSwidXNyIjoxNzAsInRwIjoyLCJpYXQiOjE2NTE1MDYzMjR9.a0cOwP6BUDZAboYwMzoMjutCtFM8Ph-X4pLahZIB_V4";
            int timeout = 60;

            Dfe dfe = new Dfe(ambiente, token, timeout, false);

            JsonObject payload = new JsonObject();
            payload.addProperty("periodo", "2020-10");
            payload.addProperty("data", "2020-10-15");
            payload.addProperty("cnpj", "06338788000127");

            JsonObject resp = dfe.buscaCte(payload);

            System.out.println(resp);

        } catch (Exception e) {

            System.out.println(e.getMessage());

        }
        
    }

}
