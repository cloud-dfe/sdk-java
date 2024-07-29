package com.examples.averbacao;

import io.github.sdk.Const;
import io.github.sdk.Util;
import io.github.sdk.routes.Averbacao;

import java.io.IOException;

import com.google.gson.JsonObject;

public class AtmXml {
    public static void main(String[] args) throws IllegalAccessException, IOException {
        
        int ambiente = Const.AMBIENTE_HOMOLOGACAO;
        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJlbXAiOjQ2MSwidXNyIjoxNzAsInRwIjoyLCJpYXQiOjE2NTE1MDYzMjR9.a0cOwP6BUDZAboYwMzoMjutCtFM8Ph-X4pLahZIB_V4";
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

    }
}