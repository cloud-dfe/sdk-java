package com.examples.nfse;

import io.github.sdk.Const;
import io.github.sdk.Util;
import io.github.sdk.routes.Nfse;

import java.io.IOException;

import com.google.gson.JsonObject;

public class Conflito {

    public static void main(String[] args) throws IllegalAccessException, IOException {

        try {

            int ambiente = Const.AMBIENTE_HOMOLOGACAO;
            String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJlbXAiOjQ2MSwidXNyIjoxNzAsInRwIjoyLCJpYXQiOjE2NTE1MDYzMjR9.a0cOwP6BUDZAboYwMzoMjutCtFM8Ph-X4pLahZIB_V4";
            int timeout = 60;

            Nfse nfse = new Nfse(ambiente, token, timeout, false);

            String xmlFile = Util.readFile("caminho_do_arquivo.xml");
            String xmlFileBase64 = Util.encode(xmlFile);

            JsonObject payload = new JsonObject();

            payload.addProperty("chave", "50000000000000000000000000000000000000000000");
            payload.addProperty("xml", xmlFileBase64);

            JsonObject resp = nfse.conflito(payload);

            System.out.println(resp);

        } catch (Exception e) {

            e.printStackTrace();

        }
        
    }

}
