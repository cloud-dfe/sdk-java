package com.examples.mdfe;

import io.github.sdk.Const;
import io.github.sdk.routes.Mdfe;

import java.io.IOException;

import com.google.gson.JsonObject;

public class Condutor {

    public static void main(String[] args) throws IllegalAccessException, IOException {

        try {
        
            int ambiente = Const.AMBIENTE_HOMOLOGACAO;
            String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJlbXAiOjQ2MSwidXNyIjoxNzAsInRwIjoyLCJpYXQiOjE2NTE1MDYzMjR9.a0cOwP6BUDZAboYwMzoMjutCtFM8Ph-X4pLahZIB_V4";
            int timeout = 60;

            Mdfe mdfe = new Mdfe(ambiente, token, timeout, false);

            JsonObject payload = new JsonObject();

            payload.addProperty("chave", "50000000000000000000000000000000000000000000");
            payload.addProperty("nome", "Nome do condutor");
            payload.addProperty("cpf", "01234567890");

            JsonObject resp = mdfe.condutor(payload);

            System.out.println(resp);

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

}
