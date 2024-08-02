package com.examples.softhouse;

import io.github.sdk.Const;
import io.github.sdk.Util;
import io.github.sdk.routes.Softhouse;

import java.io.IOException;

import com.google.gson.JsonObject;

public class AtualizaEmitente {

    public static void main(String[] args) throws IllegalAccessException, IOException {

        try {

            int ambiente = Const.AMBIENTE_HOMOLOGACAO;
            String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJlbXAiOjQ2MSwidXNyIjoxNzAsInRwIjoyLCJpYXQiOjE2NTE1MDYzMjR9.a0cOwP6BUDZAboYwMzoMjutCtFM8Ph-X4pLahZIB_V4";
            int timeout = 60;

            Softhouse softhouse = new Softhouse(ambiente, token, timeout, false);

            JsonObject payload = new JsonObject();

            payload.addProperty("nome", "EMPRESA TESTE");
            payload.addProperty("razao", "EMPRESA TESTE");
            payload.addProperty("cnae", "12369875");
            payload.addProperty("crt", "1");  // Regime tributário
            payload.addProperty("ie", "12369875");
            payload.addProperty("im", "12369875");
            payload.addProperty("suframa", "12369875");
            payload.addProperty("csc", "...");  // token para emissão de NFCe
            payload.addProperty("cscid", "000001");
            payload.addProperty("tar", "C92920029-12");  // tar BPe
            payload.add("login_prefeitura", null);
            payload.add("senha_prefeitura", null);
            payload.add("client_id_prefeitura", null);
            payload.add("client_secret_prefeitura", null);
            payload.addProperty("telefone", "46998895532");
            payload.addProperty("email", "empresa@teste.com");
            payload.addProperty("rua", "TESTE");
            payload.addProperty("numero", "1");
            payload.addProperty("complemento", "NENHUM");
            payload.addProperty("bairro", "TESTE");
            payload.addProperty("municipio", "CIDADE TESTE");  // IBGE
            payload.addProperty("cmun", "5300108");  // IBGE
            payload.addProperty("uf", "PR");  // IBGE
            payload.addProperty("cep", "85000100");
            payload.addProperty("logo", "useyn56j4mx35m5j6_JSHh734khjd...saasjda");  // BASE 64
            payload.addProperty("webhook", "https://seusite.com.br/notifications");

            JsonObject resp = softhouse.atualizaEmitente(payload);

            System.out.println(resp);

        } catch (Exception e) {

            e.printStackTrace();

        }
        
    }

}
