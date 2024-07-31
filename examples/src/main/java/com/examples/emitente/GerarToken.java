package com.examples.emitente;

import io.github.sdk.Const;
import io.github.sdk.routes.Emitente;

import java.io.IOException;

import com.google.gson.JsonObject;

public class GerarToken {

    public static void main(String[] args) throws IllegalAccessException, IOException {

        try {
        
            int ambiente = Const.AMBIENTE_HOMOLOGACAO;
            String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJlbXAiOjQ2MSwidXNyIjoxNzAsInRwIjoyLCJpYXQiOjE2NTE1MDYzMjR9.a0cOwP6BUDZAboYwMzoMjutCtFM8Ph-X4pLahZIB_V4";
            int timeout = 60;

            Emitente emitente = new Emitente(ambiente, token, timeout, false);

            JsonObject resp = emitente.token();

            System.out.println(resp);

        } catch (Exception e) {

            System.out.println(e.getMessage());

        }
        
    }

}
