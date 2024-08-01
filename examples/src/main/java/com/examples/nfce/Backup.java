package com.examples.nfce;

import io.github.sdk.Const;
import io.github.sdk.routes.Nfce;

import java.io.IOException;

import com.google.gson.JsonObject;

public class Backup {

    public static void main(String[] args) throws IllegalAccessException, IOException {

        try {

            int ambiente = Const.AMBIENTE_HOMOLOGACAO;
            String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJlbXAiOjQ2MSwidXNyIjoxNzAsInRwIjoyLCJpYXQiOjE2NTE1MDYzMjR9.a0cOwP6BUDZAboYwMzoMjutCtFM8Ph-X4pLahZIB_V4";
            int timeout = 60;

            Nfce nfce = new Nfce(ambiente, token, timeout, false);

            JsonObject payload = new JsonObject();

            payload.addProperty("ano", "2021");
            payload.addProperty("mes", "2");

            JsonObject resp = nfce.backup(payload);

            System.out.println(resp);

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

}
