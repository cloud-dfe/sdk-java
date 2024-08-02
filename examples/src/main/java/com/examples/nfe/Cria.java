package com.examples.nfe;

import io.github.sdk.Const;
import io.github.sdk.routes.Nfe;

import java.io.IOException;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class Cria {

    public static void main(String[] args) throws IllegalAccessException, IOException {

        try {

            int ambiente = Const.AMBIENTE_HOMOLOGACAO;
            String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJlbXAiOjQ2MSwidXNyIjoxNzAsInRwIjoyLCJpYXQiOjE2NTE1MDYzMjR9.a0cOwP6BUDZAboYwMzoMjutCtFM8Ph-X4pLahZIB_V4";
            int timeout = 60;

            Nfe nfe = new Nfe(ambiente, token, timeout, false);

            JsonObject payload = createPayload();
            JsonArray itens = listaItens();

            payload.add("itens", itens);

            JsonObject resp = nfe.cria(payload);

            System.out.println(resp);

            if (resp.get("codigo").getAsInt() == 200) {
                
                String chave = resp.get("chave").getAsString();
                
                if (resp.get("codigo").getAsInt() == 5023){

                    Thread.sleep(5000);
                    int tentativas = 1;

                    while (tentativas <= 5) {
                        
                        JsonObject payloadConsulta = new JsonObject();
                        payloadConsulta.addProperty("chave", chave);

                        JsonObject respConsulta = nfe.consulta(payloadConsulta);

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

                JsonObject respConsulta = nfe.consulta(payloadConsulta);

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
        payload.addProperty("natureza_operacao", "VENDA DENTRO DO ESTADO");
        payload.addProperty("serie", "1");
        payload.addProperty("numero", "101007");
        payload.addProperty("data_emissao", "2021-06-26T13:00:00-03:00");
        payload.addProperty("data_entrada_saida", "2021-06-26T13:00:00-03:00");
        payload.addProperty("tipo_operacao", "1");
        payload.addProperty("finalidade_emissao", "1");
        payload.addProperty("consumidor_final", "1");
        payload.addProperty("presenca_comprador", "9");

        JsonObject intermediario = new JsonObject();
        intermediario.addProperty("indicador", "0");
        payload.add("intermediario", intermediario);

        JsonArray notasReferenciadas = new JsonArray();
        JsonObject notaReferenciada = new JsonObject();
        JsonObject nfe = new JsonObject();
        nfe.addProperty("chave", "50000000000000000000000000000000000000000000");
        notaReferenciada.add("nfe", nfe);
        notasReferenciadas.add(notaReferenciada);
        payload.add("notas_referenciadas", notasReferenciadas);

        JsonObject destinatario = new JsonObject();
        destinatario.addProperty("cpf", "01234567890");
        destinatario.addProperty("nome", "EMPRESA MODELO");
        destinatario.addProperty("indicador_inscricao_estadual", "9");
        destinatario.add("inscricao_estadual", null);

        JsonObject endereco = new JsonObject();
        endereco.addProperty("logradouro", "AVENIDA TESTE");
        endereco.addProperty("numero", "444");
        endereco.addProperty("bairro", "CENTRO");
        endereco.addProperty("codigo_municipio", "4108403");
        endereco.addProperty("nome_municipio", "Mossoro");
        endereco.addProperty("uf", "PR");
        endereco.addProperty("cep", "59653120");
        endereco.addProperty("codigo_pais", "1058");
        endereco.addProperty("nome_pais", "BRASIL");
        endereco.addProperty("telefone", "8499995555");
        destinatario.add("endereco", endereco);
        payload.add("destinatario", destinatario);

        JsonObject frete = new JsonObject();
        frete.addProperty("modalidade_frete", "0");

        JsonArray volumes = new JsonArray();
        JsonObject volume = new JsonObject();
        volume.addProperty("quantidade", "10");
        volume.add("especie", null);
        volume.addProperty("marca", "TESTE");
        volume.add("numero", null);
        volume.addProperty("peso_liquido", 500);
        volume.addProperty("peso_bruto", 500);
        volumes.add(volume);
        frete.add("volumes", volumes);
        payload.add("frete", frete);

        JsonObject cobranca = new JsonObject();
        JsonObject fatura = new JsonObject();
        fatura.addProperty("numero", "1035.00");
        fatura.addProperty("valor_original", "224.50");
        fatura.addProperty("valor_desconto", "0.00");
        fatura.addProperty("valor_liquido", "224.50");
        cobranca.add("fatura", fatura);
        payload.add("cobranca", cobranca);

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
        JsonObject pessoa2 = new JsonObject();
        pessoa2.addProperty("cnpj", "80681257000195");
        pessoasAutorizadas.add(pessoa1);
        pessoasAutorizadas.add(pessoa2);
        payload.add("pessoas_autorizadas", pessoasAutorizadas);

        return payload;
    }

    private static JsonArray listaItens() {
        JsonArray itens = new JsonArray();

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
        item.addProperty("informacoes_adicionais", "Valor aproximado tributos R$: 9,43 (4,20%) Fonte: IBPT");

        itens.add(item);

        return itens;
    }

}
