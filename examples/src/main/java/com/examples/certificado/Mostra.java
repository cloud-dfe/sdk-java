package com.examples.certificado;

import io.github.sdk.Const;
import io.github.sdk.routes.Certificado;

import java.io.IOException;

import com.google.gson.JsonObject;

public class Mostra {

    public static void main(String[] args) throws IllegalAccessException, IOException {
        
        try {

            int ambiente = Const.AMBIENTE_HOMOLOGACAO;
            String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJlbXAiOjQ2MSwidXNyIjoxNzAsInRwIjoyLCJpYXQiOjE2NTE1MDYzMjR9.a0cOwP6BUDZAboYwMzoMjutCtFM8Ph-X4pLahZIB_V4";
            int timeout = 60;

            Certificado certificado = new Certificado(ambiente, token, timeout, false);

            JsonObject resp = certificado.mostra();

            System.out.println(resp);

        } catch (Exception e) {
                
            e.printStackTrace();
            
        }
        
    }

}
