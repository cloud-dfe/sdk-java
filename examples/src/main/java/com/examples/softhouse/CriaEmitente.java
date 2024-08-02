package com.examples.softhouse;

import io.github.sdk.Const;
import io.github.sdk.Util;
import io.github.sdk.routes.Softhouse;

import java.io.IOException;

import com.google.gson.JsonObject;

public class CriaEmitente {

    public static void main(String[] args) throws IllegalAccessException, IOException {

        try {
                
            int ambiente = Const.AMBIENTE_HOMOLOGACAO;
            String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJlbXAiOjQ2MSwidXNyIjoxNzAsInRwIjoyLCJpYXQiOjE2NTE1MDYzMjR9.a0cOwP6BUDZAboYwMzoMjutCtFM8Ph-X4pLahZIB_V4";
            int timeout = 60;

            Softhouse softhouse = new Softhouse(ambiente, token, timeout, false);

            JsonObject payObject = new JsonObject();

            payObject.addProperty("nome", "EMPRESA TESTE");
            payObject.addProperty("razao", "EMPRESA TESTE");
            payObject.addProperty("cnpj", "47853098000193");
            payObject.addProperty("cpf", "12345678901");
            payObject.addProperty("cnae", "12369875");
            payObject.addProperty("crt", "1");  // Regime tributário
            payObject.addProperty("ie", "12369875");
            payObject.addProperty("im", "12369875");
            payObject.addProperty("suframa", "12369875");
            payObject.addProperty("csc", "...");  // token para emissão de NFCe
            payObject.addProperty("cscid", "000001");
            payObject.addProperty("tar", "C92920029-12");  // tar BPe
            payObject.add("login_prefeitura", null);
            payObject.add("senha_prefeitura", null);
            payObject.add("client_id_prefeitura", null);
            payObject.add("client_secret_prefeitura", null);
            payObject.addProperty("telefone", "46998895532");
            payObject.addProperty("email", "empresa@teste.com");
            payObject.addProperty("rua", "TESTE");
            payObject.addProperty("numero", "1");
            payObject.addProperty("complemento", "NENHUM");
            payObject.addProperty("bairro", "TESTE");
            payObject.addProperty("municipio", "CIDADE TESTE");  // IBGE
            payObject.addProperty("cmun", "5300108");  // IBGE
            payObject.addProperty("uf", "PR");  // IBGE
            payObject.addProperty("cep", "85000100");
            payObject.addProperty("logo", "useyn56j4mx35m5j6_JSHh734khjd...saasjda");  // BASE 64
            payObject.addProperty("plano", "Emitente");

            JsonObject documentos = new JsonObject();
            documentos.addProperty("nfe", true);
            documentos.addProperty("nfce", true);
            documentos.addProperty("nfse", true);
            documentos.addProperty("mdfe", true);
            documentos.addProperty("cte", true);
            documentos.addProperty("cteos", true);
            documentos.addProperty("bpe", true);
            documentos.addProperty("dfe_nfe", true);
            documentos.addProperty("dfe_cte", true);
            documentos.addProperty("sintegra", true);
            documentos.addProperty("gnre", true);

            payObject.add("documentos", documentos);

            JsonObject resp = softhouse.criaEmitente(payObject);

            System.out.println(resp);

        } catch (Exception e) {

            e.printStackTrace();

        }

        
    }

}
