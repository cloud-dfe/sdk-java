package com.examples.nfcom;

import io.github.sdk.Const;
import io.github.sdk.routes.Nfcom;

import java.io.IOException;

import com.google.gson.JsonObject;

public class Busca {

    public static void main(String[] args) throws IllegalAccessException, IOException {

        try {

            int ambiente = Const.AMBIENTE_HOMOLOGACAO;
            String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJlbXAiOjQ2MSwidXNyIjoxNzAsInRwIjoyLCJpYXQiOjE2NTE1MDYzMjR9.a0cOwP6BUDZAboYwMzoMjutCtFM8Ph-X4pLahZIB_V4";
            int timeout = 60;

            Nfcom nfcom = new Nfcom(ambiente, token, timeout, false);

            JsonObject payload = new JsonObject();

            payload.addProperty("numero_inicial", 1210);
            payload.addProperty("numero_final", 1210);
            payload.addProperty("serie", 1);
            payload.addProperty("data_inicial", "2019-12-01");
            payload.addProperty("data_final", "2019-12-31");
            payload.addProperty("cancel_inicial", "2019-12-01");
            payload.addProperty("cancel_final", "2019-12-31");
            payload.addProperty("status", "1");

            JsonObject resp = nfcom.busca(payload);

            System.out.println(resp);

        } catch (Exception e) {

            e.printStackTrace();

        }
        
    }

}
