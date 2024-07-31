package com.examples.gnre;

import java.io.IOException;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import io.github.sdk.Const;
import io.github.sdk.routes.Gnre;

public class Cria {

    public static void main(String[] args) throws IllegalAccessException, IOException {

        try {
        
            int ambiente = Const.AMBIENTE_HOMOLOGACAO;
            String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJlbXAiOjQ2MSwidXNyIjoxNzAsInRwIjoyLCJpYXQiOjE2NTE1MDYzMjR9.a0cOwP6BUDZAboYwMzoMjutCtFM8Ph-X4pLahZIB_V4";
            int timeout = 60;

            Gnre gnre = new Gnre(ambiente, token, timeout, false);

            JsonObject payload = createPayload();

            JsonObject resp = gnre.cria(payload);

            System.out.println(resp);

            if (resp.get("codigo").getAsInt() == 200) {
                
                String chave = resp.get("chave").getAsString();
                
                if (resp.get("codigo").getAsInt() == 5023){

                    Thread.sleep(5000);
                    int tentativas = 1;

                    while (tentativas <= 5) {
                        
                        JsonObject payloadConsulta = new JsonObject();
                        payloadConsulta.addProperty("chave", chave);

                        JsonObject respConsulta = gnre.consulta(payloadConsulta);

                        if (respConsulta.get("codigo").getAsInt() != 5023) {
                            if (respConsulta.get("sucesso").getAsBoolean()) {
                                System.out.println(respConsulta);
                                break;
                            } else {
                                System.out.println(respConsulta);
                                break;
                            }
                        }

                        Thread.sleep(5000);
                        tentativas++;

                    }
                } else {
                    System.out.println(resp);
                }
            
            } else if (resp.get("codigo").getAsInt() == 5001 || resp.get("codigo").getAsInt() == 5002) {
                System.out.println(resp.get("erro").getAsString());
            
            } else if (resp.get("codigo").getAsInt() == 5008 || resp.get("codigo").getAsInt() >= 7000) {
                
                String chave = resp.get("chave").getAsString();

                JsonObject payloadConsulta = new JsonObject();

                payloadConsulta.addProperty("chave", chave);

                System.out.println(resp);

                JsonObject respConsulta = gnre.consulta(payloadConsulta);

                if (respConsulta.get("sucesso").getAsBoolean()) {
                    System.out.println(respConsulta);
                } else {
                    System.out.println(respConsulta);
                }
            
            } else {
                System.out.println(resp);
            }

        } catch (Exception e) {
                
            System.out.println(e.getMessage());
    
        }

    }

    private static JsonObject createPayload() {

        JsonObject payload = new JsonObject();

        payload.addProperty("numero", "6");
        payload.addProperty("uf_favoverida", "RO");
        payload.add("ie_emitente_uf_favorecida", null);
        payload.addProperty("tipo", "0");
        payload.addProperty("valor", 12.55);
        payload.addProperty("data_pagamento", "2022-05-22");
        payload.addProperty("identificador_guia", "12345");

        JsonArray receitas = new JsonArray();
        JsonObject receita = new JsonObject();
        receita.addProperty("codigo", "100102");
        receita.add("detalhamento", null);
        receita.addProperty("data_vencimento", "2022-05-22");
        receita.addProperty("convenio", "Convênio ICMS 142/18");
        receita.addProperty("numero_controle", "1");
        receita.add("numero_controle_fecp", null);

        JsonObject documentoOrigem = new JsonObject();
        documentoOrigem.addProperty("numero", "000000001");
        documentoOrigem.addProperty("tipo", "10");
        receita.add("documento_origem", documentoOrigem);

        receita.add("produto", null);

        JsonObject referencia = new JsonObject();
        referencia.addProperty("periodo", "0");
        referencia.addProperty("mes", "05");
        referencia.addProperty("ano", "2022");
        referencia.add("parcela", null);
        receita.add("referencia", referencia);

        JsonArray valores = new JsonArray();
        JsonObject valor = new JsonObject();
        valor.addProperty("valor", 12.55);
        valor.addProperty("tipo", "11");
        valores.add(valor);
        receita.add("valores", valores);

        JsonObject contribuinteDestinatario = new JsonObject();
        contribuinteDestinatario.add("cnpj", null);
        contribuinteDestinatario.add("cpf", null);
        contribuinteDestinatario.add("ie", null);
        contribuinteDestinatario.add("razao", null);
        contribuinteDestinatario.add("ibge", null);
        receita.add("contribuinte_destinatario", contribuinteDestinatario);

        JsonArray extras = new JsonArray();
        JsonObject extra = new JsonObject();
        extra.addProperty("codigo", "52");
        extra.addProperty("conteudo", "32220526434850000191550100000000011015892724");
        extras.add(extra);
        receita.add("extras", extras);

        receitas.add(receita);
        payload.add("receitas", receitas);

        return payload;
    
    }

}
