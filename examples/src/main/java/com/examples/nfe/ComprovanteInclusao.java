package com.examples.nfe;

import io.github.sdk.Const;
import io.github.sdk.routes.Nfe;

import java.io.IOException;

import com.google.gson.JsonObject;

public class ComprovanteInclusao {

    public static void main(String[] args) throws IllegalAccessException, IOException {

        try {

            int ambiente = Const.AMBIENTE_HOMOLOGACAO;
            String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJlbXAiOjQ2MSwidXNyIjoxNzAsInRwIjoyLCJpYXQiOjE2NTE1MDYzMjR9.a0cOwP6BUDZAboYwMzoMjutCtFM8Ph-X4pLahZIB_V4";
            int timeout = 60;

            Nfe nfe = new Nfe(ambiente, token, timeout, false);

            JsonObject payload = new JsonObject();
            payload.addProperty("chave", "123456789012345678901234567890123456789012345678901234");

            JsonObject registra = new JsonObject();
            registra.addProperty("data", "2021-10-12T12:22:33-03:00");
            registra.addProperty("imagem", "lUHJvYyB2ZXJzYW....");
            registra.addProperty("recebedor_documento", "123456789 SSPRJ");
            registra.addProperty("recebedor_nome", "NOME TESTE");

            JsonObject coordenadas = new JsonObject();
            coordenadas.addProperty("latitude", -23.628360);
            coordenadas.addProperty("longitude", -46.622109);

            registra.add("coordenadas", coordenadas);
            payload.add("registra", registra);

            JsonObject resp = nfe.comprovante(payload);

            System.out.println(resp);

        } catch (Exception e) {
        
            e.printStackTrace();
        
        }
        
    }

}
