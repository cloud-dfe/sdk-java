package com.examples.nfse;

import io.github.sdk.Const;
import io.github.sdk.routes.Nfse;

import java.io.IOException;

import com.google.gson.JsonObject;

public class Cria {

    public static void main(String[] args) throws IllegalAccessException, IOException {

        try {

            int ambiente = Const.AMBIENTE_HOMOLOGACAO;
            String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJlbXAiOjQ2MSwidXNyIjoxNzAsInRwIjoyLCJpYXQiOjE2NTE1MDYzMjR9.a0cOwP6BUDZAboYwMzoMjutCtFM8Ph-X4pLahZIB_V4";
            int timeout = 60;

            Nfse nfse = new Nfse(ambiente, token, timeout, false);

            JsonObject payload = createPayload();

            JsonObject resp = nfse.cria(payload);

            System.out.println(resp);

            if (resp.get("codigo").getAsInt() == 200) {
                
                String chave = resp.get("chave").getAsString();
                
                if (resp.get("codigo").getAsInt() == 5023){

                    Thread.sleep(5000);
                    int tentativas = 1;

                    while (tentativas <= 5) {
                        
                        JsonObject payloadConsulta = new JsonObject();
                        payloadConsulta.addProperty("chave", chave);

                        JsonObject respConsulta = nfse.consulta(payloadConsulta);

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

                JsonObject respConsulta = nfse.consulta(payloadConsulta);

                if (respConsulta.get("sucesso").getAsBoolean()) {
                    System.out.println(respConsulta);
                } else {
                    System.out.println(respConsulta);
                }
            
            } else {
                System.out.println(resp);
            }

        } catch (Exception e) {

            e.printStackTrace();

        }
        
    }

    private static JsonObject createPayload() {
        JsonObject payload = new JsonObject();

        payload.addProperty("numero", "1");
        payload.addProperty("serie", "0");
        payload.addProperty("tipo", "1");
        payload.addProperty("status", "1");
        payload.addProperty("data_emissao", "2017-12-27T17:43:14-03:00");

        JsonObject tomador = new JsonObject();
        tomador.addProperty("cnpj", "12345678901234");
        tomador.add("cpf", null);
        tomador.add("im", null);
        tomador.addProperty("razao_social", "Fake Tecnologia Ltda");

        JsonObject endereco = new JsonObject();
        endereco.addProperty("logradouro", "Rua New Horizon");
        endereco.addProperty("numero", "16");
        endereco.add("complemento", null);
        endereco.addProperty("bairro", "Jardim America");
        endereco.addProperty("codigo_municipio", "4119905");
        endereco.addProperty("uf", "PR");
        endereco.addProperty("cep", "81530945");

        tomador.add("endereco", endereco);
        payload.add("tomador", tomador);

        JsonObject servico = new JsonObject();
        servico.addProperty("codigo_tributacao_municipio", "10500");
        servico.addProperty("discriminacao", "Exemplo Serviço");
        servico.addProperty("codigo_municipio", "4119905");
        servico.addProperty("valor_servicos", "1.00");
        servico.addProperty("valor_pis", "1.00");
        servico.addProperty("valor_cofins", "1.00");
        servico.addProperty("valor_inss", "1.00");
        servico.addProperty("valor_ir", "1.00");
        servico.addProperty("valor_csll", "1.00");
        servico.addProperty("valor_outras", "1.00");
        servico.addProperty("valor_aliquota", "1.00");
        servico.addProperty("valor_desconto_incondicionado", "1.00");

        payload.add("servico", servico);

        JsonObject intermediario = new JsonObject();
        intermediario.addProperty("cnpj", "12345678901234");
        intermediario.add("cpf", null);
        intermediario.add("im", null);
        intermediario.addProperty("razao_social", "Fake Tecnologia Ltda");

        payload.add("intermediario", intermediario);

        JsonObject obra = new JsonObject();
        obra.addProperty("codigo", "2222");
        obra.addProperty("art", "1111");

        payload.add("obra", obra);

        return payload;
    }

}
