package com.examples.averbacao;

import io.github.sdk.Const;
import io.github.sdk.Util;
import io.github.sdk.routes.Averbacao;

import java.io.IOException;

import com.google.gson.JsonObject;

public class AtmXml {
    public static void main(String[] args) throws IllegalAccessException, IOException {
        
        try {

            int ambiente = Const.AMBIENTE_HOMOLOGACAO;
            String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJlbXAiOiJ0b2tlbl9leGVtcGxvIiwidXNyIjoidGsiLCJ0cCI6InRrIn0.Tva_viCMCeG3nkRYmi_RcJ6BtSzui60kdzIsuq5X-sQ";
            int timeout = 60;

            Averbacao averbacao = new Averbacao(ambiente, token, timeout, false);

            String fileXml = Util.readFile("caminho_do_arquivo.xml");

            String fileXmlBase64 = Util.encode(fileXml);
            
            JsonObject payload = new JsonObject();

            payload.addProperty("xml", fileXmlBase64); // Substitua "file_xml_base64" pelo valor real
            payload.addProperty("usuario", "login");
            payload.addProperty("senha", "senha");
            payload.addProperty("codigo", "codigo");
            payload.addProperty("chave", "");

            JsonObject resp = averbacao.atm(payload);

            System.out.println(resp);

        } catch (Exception e) {
            
            e.printStackTrace();
            
        }
    }
}