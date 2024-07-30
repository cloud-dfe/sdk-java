package com.examples.cte;

import io.github.sdk.Const;
import io.github.sdk.routes.Cte;

import java.io.IOException;

import com.google.gson.JsonObject;

public class Pdf {

    public static void main(String[] args) throws IllegalAccessException, IOException {

        try {
        
            int ambiente = Const.AMBIENTE_HOMOLOGACAO;
            String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJlbXAiOjQ2MSwidXNyIjoxNzAsInRwIjoyLCJpYXQiOjE2NTE1MDYzMjR9.a0cOwP6BUDZAboYwMzoMjutCtFM8Ph-X4pLahZIB_V4";
            int timeout = 60;

            Cte cte = new Cte(ambiente, token, timeout, false);

            JsonObject json = new JsonObject();

            json.addProperty("chave", "50000000000000000000000000000000000000000000");

            JsonObject resp = cte.pdf(json);

            System.out.println(resp);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

}

