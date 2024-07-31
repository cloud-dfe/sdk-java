package com.examples.gnre;

import io.github.sdk.Const;
import io.github.sdk.routes.Gnre;

import java.io.IOException;

import com.google.gson.JsonObject;

public class ConfigUf {

    public static void main(String[] args) throws IllegalAccessException, IOException {

        try {
        
            int ambiente = Const.AMBIENTE_HOMOLOGACAO;
            String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJlbXAiOjQ2MSwidXNyIjoxNzAsInRwIjoyLCJpYXQiOjE2NTE1MDYzMjR9.a0cOwP6BUDZAboYwMzoMjutCtFM8Ph-X4pLahZIB_V4";
            int timeout = 60;

            Gnre gnre = new Gnre(ambiente, token, timeout, false);

            JsonObject payload = new JsonObject();

            payload.addProperty("uf_favoverida", "SP");
            payload.addProperty("codigo_receita", (String) null);
            payload.addProperty("curier", (String) null);

            JsonObject resp = gnre.config_uf(payload);

            System.out.println(resp);

        } catch (Exception e) {

            System.out.println(e.getMessage());

        }
        
    }

}
