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
            String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJlbXAiOjQ2MSwidXNyIjoxNzAsInRwIjoyLCJpYXQiOjE2NTE1MDYzMjR9.a0cOwP6BUDZAboYwMzoMjutCtFM8Ph-X4pLahZIB_V4";
            int timeout = 60;

            Nfce nfce = new Nfce(ambiente, token, timeout, false);

            JsonObject payload = createPayload();
            JsonArray listaItens = createListaItens();

            payload.add("itens", listaItens);

            JsonObject resp = nfce.cria(payload);

            System.out.println(resp);

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
