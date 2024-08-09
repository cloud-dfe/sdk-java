package com.examples.cteos;

import io.github.sdk.Const;
import io.github.sdk.Util;
import io.github.sdk.routes.Cteos;

import java.io.IOException;

import com.google.gson.JsonObject;

public class Importa {

    public static void main(String[] args) throws IllegalAccessException, IOException {
        
        try {

            int ambiente = Const.AMBIENTE_HOMOLOGACAO;
            String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJlbXAiOiJ0b2tlbl9leGVtcGxvIiwidXNyIjoidGsiLCJ0cCI6InRrIn0.Tva_viCMCeG3nkRYmi_RcJ6BtSzui60kdzIsuq5X-sQ";
            int timeout = 60;

            Cteos cteos = new Cteos(ambiente, token, timeout, false);

            String fileXml = Util.readFile("caminho_do_arquivo.xml");

            String fileXmlBase64 = Util.encode(fileXml);

            JsonObject payload = new JsonObject();

            payload.addProperty("xml", fileXmlBase64);

            JsonObject resp = cteos.importa(payload);

            System.out.println(resp);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
