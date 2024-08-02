package com.examples.nfse;

import io.github.sdk.Const;
import io.github.sdk.routes.Nfse;

import java.io.IOException;

import com.google.gson.JsonObject;

public class Substitui {

    public static void main(String[] args) throws IllegalAccessException, IOException {

        try {

            int ambiente = Const.AMBIENTE_HOMOLOGACAO;
            String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJlbXAiOjQ2MSwidXNyIjoxNzAsInRwIjoyLCJpYXQiOjE2NTE1MDYzMjR9.a0cOwP6BUDZAboYwMzoMjutCtFM8Ph-X4pLahZIB_V4";
            int timeout = 60;

            Nfse nfse = new Nfse(ambiente, token, timeout, false);

            JsonObject payObject = new JsonObject();

            payObject.addProperty("chave", "50000000000000000000000000000000000000000000");
            payObject.addProperty("codigo_cancelamento", "2");
            payObject.addProperty("motivo_cancelamento", "nota emitida com valor errado");
            payObject.addProperty("numero", "1");
            payObject.addProperty("serie", "0");
            payObject.addProperty("tipo", "1");
            payObject.addProperty("status", "1");
            payObject.addProperty("data_emissao", "2017-12-27T17:43:14-03:00");

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
            payObject.add("tomador", tomador);

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

            payObject.add("servico", servico);

            JsonObject intermediario = new JsonObject();
            intermediario.addProperty("cnpj", "12345678901234");
            intermediario.add("cpf", null);
            intermediario.add("im", null);
            intermediario.addProperty("razao_social", "Fake Tecnologia Ltda");

            payObject.add("intermediario", intermediario);

            JsonObject obra = new JsonObject();
            obra.addProperty("codigo", "2222");
            obra.addProperty("art", "1111");

            payObject.add("obra", obra);

            JsonObject resp = nfse.substitui(payObject);

            System.out.println(resp);

        } catch (Exception e) {

            e.printStackTrace();

        }
        
    }

}
