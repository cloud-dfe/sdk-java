package com.examples.ciot;

import io.github.sdk.Const;
import io.github.sdk.routes.Ciot;

import java.io.IOException;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class Cria {

    public static void main(String[] args) throws IllegalAccessException, IOException {

        try {

            int ambiente = Const.AMBIENTE_HOMOLOGACAO;
            String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJlbXAiOiJ0b2tlbl9leGVtcGxvIiwidXNyIjoidGsiLCJ0cCI6InRrIn0.Tva_viCMCeG3nkRYmi_RcJ6BtSzui60kdzIsuq5X-sQ";
            int timeout = 60;

            Ciot ciot = new Ciot(ambiente, token, timeout, false);

            JsonObject payload = new JsonObject();
            payload.addProperty("numero", "1001");
            payload.addProperty("identificacao", "PEDIDO-77");
            payload.addProperty("tipo_operacao", "1");
            payload.addProperty("data_inicio", "2026-11-10");
            payload.addProperty("data_fim", "2026-11-12");
            payload.addProperty("valor_frete", "4550.92");
            JsonObject contratante = new JsonObject();
            contratante.addProperty("cnpj", "11222333000181");
            contratante.addProperty("nome", "TRANSPORTADORA EXEMPLO LTDA");
            contratante.addProperty("rntrc", "12345678");
            payload.add("contratante", contratante);
            JsonObject contratado = new JsonObject();
            contratado.addProperty("cnpj", "22333444000181");
            contratado.addProperty("nome", "TRANSPORTADOR CONTRATADO LTDA");
            contratado.addProperty("rntrc", "87654321");
            payload.add("contratado", contratado);
            JsonObject destinatario = new JsonObject();
            destinatario.addProperty("cnpj", "44555666000199");
            destinatario.addProperty("nome", "DESTINATARIO EXEMPLO LTDA");
            payload.add("destinatario", destinatario);
            JsonObject motorista = new JsonObject();
            motorista.addProperty("cpf", "12345678909");
            motorista.addProperty("nome", "MOTORISTA EXEMPLO");
            payload.add("motorista", motorista);
            JsonArray veiculos = new JsonArray();
            JsonObject veiculosItem1 = new JsonObject();
            veiculosItem1.addProperty("placa", "BCD2E34");
            veiculosItem1.addProperty("eixos", "2");
            veiculosItem1.addProperty("rntrc", "87654321");
            veiculos.add(veiculosItem1);
            payload.add("veiculos", veiculos);
            JsonObject carga = new JsonObject();
            carga.addProperty("tipo", "05");
            carga.addProperty("natureza", "8414");
            carga.addProperty("peso", "1520");
            payload.add("carga", carga);
            JsonArray viagens = new JsonArray();
            JsonObject viagensItem1 = new JsonObject();
            viagensItem1.addProperty("quantidade", "1");
            viagensItem1.addProperty("distancia", "560");
            JsonObject origem = new JsonObject();
            origem.addProperty("cep", "85000000");
            origem.addProperty("codigo_municipio", "4121604");
            origem.addProperty("municipio", "Renascença");
            origem.addProperty("uf", "PR");
            viagensItem1.add("origem", origem);
            JsonObject destino = new JsonObject();
            destino.addProperty("cep", "88300000");
            destino.addProperty("codigo_municipio", "4208203");
            destino.addProperty("municipio", "Itajaí");
            destino.addProperty("uf", "SC");
            viagensItem1.add("destino", destino);
            viagens.add(viagensItem1);
            payload.add("viagens", viagens);
            JsonArray pagamentos = new JsonArray();
            JsonObject pagamentosItem1 = new JsonObject();
            pagamentosItem1.addProperty("forma", "1");
            pagamentosItem1.addProperty("tipo", "5");
            pagamentosItem1.addProperty("cnpj", "22333444000181");
            pagamentosItem1.addProperty("chave_pix", "22333444000181");
            pagamentosItem1.addProperty("vencimento", "2026-11-12");
            pagamentosItem1.addProperty("valor", "4550.92");
            pagamentos.add(pagamentosItem1);
            payload.add("pagamentos", pagamentos);

            JsonObject resp = ciot.cria(payload);

            System.out.println(resp);

            if (resp.get("sucesso").getAsBoolean()) {
                if (resp.get("codigo").getAsInt() == 5023) {
                    // lote em processamento: consultar pela chave ou esperar o webhook
                } else {
                    // CIOT declarado
                }
            } else {
                // rejeição
            }

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

}
