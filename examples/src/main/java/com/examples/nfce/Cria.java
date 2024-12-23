package com.examples.nfce;

import io.github.sdk.Const;
import io.github.sdk.routes.Nfce;

import java.io.IOException;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class Cria {

    public static void main(String[] args) throws IllegalAccessException, IOException {

        try {

            int ambiente = Const.AMBIENTE_HOMOLOGACAO;
            String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJlbXAiOiJ0b2tlbl9leGVtcGxvIiwidXNyIjoidGsiLCJ0cCI6InRrIn0.Tva_viCMCeG3nkRYmi_RcJ6BtSzui60kdzIsuq5X-sQ";
            int timeout = 60;

            Nfce nfce = new Nfce(ambiente, token, timeout, false);

            JsonObject payload = createPayload();
            JsonArray listaItens = createListaItens();

            payload.add("itens", listaItens);

            JsonObject resp = nfce.cria(payload);

            System.out.println(resp);

            if (resp.has("sucesso") && resp.get("sucesso").getAsBoolean()) {
                if (resp.has("codigo") && resp.get("codigo").getAsInt() == 2) {
                    // Offline
                    System.out.println("Nota emitida offline. Aguarde a sincronização.");
                } else {
                    // Autorizado
                    System.out.println("Nota autorizada com sucesso: " + resp);
                }
            } else if (resp.has("codigo") &&
                       (resp.get("codigo").getAsInt() == 5001 || resp.get("codigo").getAsInt() == 5002)) {
                // Erro nos campos
                if (resp.has("erros")) {
                    System.out.println("Erro nos campos: " + resp.get("erros"));
                } else {
                    System.out.println("Erro nos campos, mas sem detalhes fornecidos.");
                }
            } else if (resp.has("codigo") &&
                       (resp.get("codigo").getAsInt() == 5008 || resp.get("codigo").getAsInt() >= 7000)) {
                // Problemas de comunicação ou chave pendente
                String chave = resp.has("chave") ? resp.get("chave").getAsString() : null;
        
                if (chave == null || chave.isEmpty()) {
                    System.out.println("Chave não encontrada no response.");
                    return;
                }
        
                System.out.println("Problemas de comunicação ou chave pendente: " + resp);
        
                // Consulta pela chave
                JsonObject payloadConsulta = new JsonObject();
                payloadConsulta.addProperty("chave", chave);
        
                try {
                    JsonObject respConsulta = nfce.consulta(payloadConsulta);
        
                    if (respConsulta.has("codigo") && respConsulta.get("codigo").getAsInt() != 5023) {
                        if (respConsulta.has("sucesso") && respConsulta.get("sucesso").getAsBoolean()) {
                            // Autorizado
                            System.out.println("Nota autorizada após consulta: " + respConsulta);
                        } else {
                            // Rejeição
                            System.out.println("Nota rejeitada após consulta: " + respConsulta);
                        }
                    } else {
                        // Em processamento
                        System.out.println("Nota em processamento: " + respConsulta);
                    }
                } catch (Exception e) {
                    System.out.println("Erro ao consultar NFC-e: " + e.getMessage());
                }
            } else {
                // Rejeição
                System.out.println("Nota rejeitada: " + resp);
            }

        } catch (Exception e) {

            e.printStackTrace();

        }
        
    }

    private static JsonObject createPayload() {
        JsonObject payload = new JsonObject();
        payload.addProperty("natureza_operacao", "VENDA DENTRO DO ESTADO");
        payload.addProperty("serie", "1");
        payload.addProperty("numero", "101008");
        payload.addProperty("data_emissao", "2021-06-26T15:20:00-03:00");
        payload.addProperty("tipo_operacao", "1");
        payload.addProperty("presenca_comprador", "1");

        JsonObject frete = new JsonObject();
        frete.addProperty("modalidade_frete", "9");
        payload.add("frete", frete);

        JsonObject pagamento = new JsonObject();
        JsonArray formasPagamento = new JsonArray();
        JsonObject formaPagamento = new JsonObject();
        formaPagamento.addProperty("meio_pagamento", "01");
        formaPagamento.addProperty("valor", "224.50");
        formasPagamento.add(formaPagamento);
        pagamento.add("formas_pagamento", formasPagamento);
        payload.add("pagamento", pagamento);

        payload.addProperty("informacoes_adicionais_contribuinte", "PV: 3325 * Rep: DIRETO * Motorista:  * Forma Pagto: 04 DIAS * teste de observação para a nota fiscal * Valor aproximado tributos R$9,43 (4,20%) Fonte: IBPT");

        JsonArray pessoasAutorizadas = new JsonArray();
        JsonObject pessoa1 = new JsonObject();
        pessoa1.addProperty("cnpj", "96256273000170");
        pessoasAutorizadas.add(pessoa1);
        JsonObject pessoa2 = new JsonObject();
        pessoa2.addProperty("cnpj", "80681257000195");
        pessoasAutorizadas.add(pessoa2);
        payload.add("pessoas_autorizadas", pessoasAutorizadas);

        return payload;
    }

    private static JsonArray createListaItens() {
        JsonArray listaItens = new JsonArray();
        JsonObject item = new JsonObject();
        item.addProperty("numero_item", "1");
        item.addProperty("codigo_produto", "000297");
        item.addProperty("descricao", "SAL GROSSO 50KGS");
        item.addProperty("codigo_ncm", "84159020");
        item.addProperty("cfop", "5102");
        item.addProperty("unidade_comercial", "SC");
        item.addProperty("quantidade_comercial", 10);
        item.addProperty("valor_unitario_comercial", "22.45");
        item.addProperty("valor_bruto", "224.50");
        item.addProperty("unidade_tributavel", "SC");
        item.addProperty("quantidade_tributavel", "10.00");
        item.addProperty("valor_unitario_tributavel", "22.45");
        item.addProperty("origem", "0");
        item.addProperty("inclui_no_total", "1");

        JsonObject imposto = new JsonObject();
        imposto.addProperty("valor_aproximado_tributos", 9.43);

        JsonObject icms = new JsonObject();
        icms.addProperty("situacao_tributaria", "102");
        icms.addProperty("aliquota_credito_simples", "0");
        icms.addProperty("valor_credito_simples", "0");
        icms.addProperty("modalidade_base_calculo", "3");
        icms.addProperty("valor_base_calculo", "0.00");
        icms.addProperty("modalidade_base_calculo_st", "4");
        icms.addProperty("aliquota_reducao_base_calculo", "0.00");
        icms.addProperty("aliquota", "0.00");
        icms.addProperty("aliquota_final", "0.00");
        icms.addProperty("valor", "0.00");
        icms.addProperty("aliquota_margem_valor_adicionado_st", "0.00");
        icms.addProperty("aliquota_reducao_base_calculo_st", "0.00");
        icms.addProperty("valor_base_calculo_st", "0.00");
        icms.addProperty("aliquota_st", "0.00");
        icms.addProperty("valor_st", "0.00");
        imposto.add("icms", icms);

        JsonObject fcp = new JsonObject();
        fcp.addProperty("aliquota", "1.65");
        imposto.add("fcp", fcp);

        JsonObject pis = new JsonObject();
        pis.addProperty("situacao_tributaria", "01");
        pis.addProperty("valor_base_calculo", 224.5);
        pis.addProperty("aliquota", "1.65");
        pis.addProperty("valor", "3.70");
        imposto.add("pis", pis);

        JsonObject cofins = new JsonObject();
        cofins.addProperty("situacao_tributaria", "01");
        cofins.addProperty("valor_base_calculo", 224.5);
        cofins.addProperty("aliquota", "7.60");
        cofins.addProperty("valor", "17.06");
        imposto.add("cofins", cofins);

        item.add("imposto", imposto);
        item.addProperty("valor_desconto", 0);
        item.addProperty("valor_frete", 0);
        item.addProperty("valor_seguro", 0);
        item.addProperty("valor_outras_despesas", 0);
        item.addProperty("informacoes_adicionais_item", "Valor aproximado tributos R$: 9,43 (4,20%) Fonte: IBPT");

        listaItens.add(item);

        return listaItens;
    }

}
