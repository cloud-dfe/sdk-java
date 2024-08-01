package com.examples.nfe;

import io.github.sdk.Const;
import io.github.sdk.routes.Nfe;

import java.io.IOException;

import com.google.gson.JsonObject;

public class ConsultaCadastro {

    public static void main(String[] args) throws IllegalAccessException, IOException {

        try {

            int ambiente = Const.AMBIENTE_HOMOLOGACAO;
            String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJlbXAiOjQ2MSwidXNyIjoxNzAsInRwIjoyLCJpYXQiOjE2NTE1MDYzMjR9.a0cOwP6BUDZAboYwMzoMjutCtFM8Ph-X4pLahZIB_V4";
            int timeout = 60;

            Nfe nfe = new Nfe(ambiente, token, timeout, false);

            JsonObject payload = new JsonObject();
            payload.addProperty("uf", "SP");
            payload.addProperty("cnpj", "12345678901234");
            // payload.addProperty("ie", "123456789");
            // payload.addProperty("cpf", "12345678901");

            JsonObject resp = nfe.cadastro(payload);

            System.out.println(resp);

        } catch (Exception e) {

            e.printStackTrace();

        }
        
    }

}
