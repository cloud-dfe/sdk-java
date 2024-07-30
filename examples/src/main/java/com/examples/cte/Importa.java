package com.examples.cte;

import io.github.sdk.Const;
import io.github.sdk.Util;
import io.github.sdk.routes.Cte;

import java.io.IOException;

import com.google.gson.JsonObject;

public class Importa {

    public static void main(String[] args) throws IllegalAccessException, IOException {
        
        try {

            int ambiente = Const.AMBIENTE_HOMOLOGACAO;
            String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJlbXAiOjQ2MSwidXNyIjoxNzAsInRwIjoyLCJpYXQiOjE2NTE1MDYzMjR9.a0cOwP6BUDZAboYwMzoMjutCtFM8Ph-X4pLahZIB_V4";
            int timeout = 60;

            Cte cte = new Cte(ambiente, token, timeout, false);

            String fileXml = Util.readFile("caminho_do_arquivo.xml");

            String fileXmlBase64 = Util.encode(fileXml);

            JsonObject payload = new JsonObject();

            payload.addProperty("xml", fileXmlBase64);

            JsonObject resp = cte.importa(payload);

            System.out.println(resp);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
