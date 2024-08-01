package com.examples.nfcom;

import io.github.sdk.Const;
import io.github.sdk.routes.Nfcom;

import java.io.IOException;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class Backup {

    public static void main(String[] args) throws IllegalAccessException, IOException {

        try {

            int ambiente = Const.AMBIENTE_HOMOLOGACAO;
            String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJlbXAiOjQ2MSwidXNyIjoxNzAsInRwIjoyLCJpYXQiOjE2NTE1MDYzMjR9.a0cOwP6BUDZAboYwMzoMjutCtFM8Ph-X4pLahZIB_V4";
            int timeout = 60;

            Nfcom nfcom = new Nfcom(ambiente, token, timeout, false);

            JsonObject payload = new JsonObject();
            payload.addProperty("ano", "2019");
            payload.addProperty("mes", "12");

            JsonArray emails = new JsonArray();
            emails.add("contato@cloud-dfe.com.br");
            payload.add("emails", emails);

            JsonObject resp = nfcom.backup(payload);

            System.out.println(resp);

        } catch (Exception e) {

            e.printStackTrace();

        }
        
    }

}
