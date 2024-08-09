package com.examples.emitente;

import io.github.sdk.Const;
import io.github.sdk.routes.Emitente;

import java.io.IOException;

import com.google.gson.JsonObject;

public class Atualiza {

    public static void main(String[] args) throws IllegalAccessException, IOException {

        try {
        
            int ambiente = Const.AMBIENTE_HOMOLOGACAO;
            String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJlbXAiOiJ0b2tlbl9leGVtcGxvIiwidXNyIjoidGsiLCJ0cCI6InRrIn0.Tva_viCMCeG3nkRYmi_RcJ6BtSzui60kdzIsuq5X-sQ";
            int timeout = 60;

            Emitente emitente = new Emitente(ambiente, token, timeout, false);

            JsonObject payload = new JsonObject();
            payload.addProperty("nome", "EMPRESA TESTE2");
            payload.addProperty("razao", "EMPRESA TESTE2");
            // payload.addProperty("cnae", "12369875");
            // payload.addProperty("crt", "1");
            // payload.addProperty("ie", "12369875");
            // payload.addProperty("im", "12369875");
            // payload.addProperty("suframa", "12369875");
            // payload.addProperty("csc", "...");
            // payload.addProperty("cscid", "000001");
            // payload.addProperty("tar", "C92920029-12");
            // payload.addProperty("login_prefeitura", null);
            // payload.addProperty("senha_prefeitura", null);
            // payload.addProperty("client_id_prefeitura", null);
            // payload.addProperty("client_secret_prefeitura", null);
            // payload.addProperty("telefone", "46998895532");
            // payload.addProperty("email", "empresa@teste.com");
            // payload.addProperty("rua", "TESTE");
            // payload.addProperty("numero", "1");
            // payload.addProperty("complemento", "NENHUM");
            // payload.addProperty("bairro", "TESTE");
            // payload.addProperty("municipio", "CIDADE TESTE");
            // payload.addProperty("cmun", "5300108");
            // payload.addProperty("uf", "PR");
            // payload.addProperty("cep", "85000100");
            // payload.addProperty("logo", "useyn56j4mx35m5j6_JSHh734khjd...saasjda");

            JsonObject resp = emitente.atualiza(payload);

            System.out.println(resp);

        } catch (Exception e) {

            System.out.println(e.getMessage());

        }

    }

}
