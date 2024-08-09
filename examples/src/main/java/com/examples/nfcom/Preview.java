package com.examples.nfcom;

import io.github.sdk.Const;
import io.github.sdk.routes.Nfcom;

import java.io.IOException;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class Preview {

    public static void main(String[] args) throws IllegalAccessException, IOException {

        try {

            int ambiente = Const.AMBIENTE_HOMOLOGACAO;
            String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJlbXAiOiJ0b2tlbl9leGVtcGxvIiwidXNyIjoidGsiLCJ0cCI6InRrIn0.Tva_viCMCeG3nkRYmi_RcJ6BtSzui60kdzIsuq5X-sQ";
            int timeout = 60;

            Nfcom nfcom = new Nfcom(ambiente, token, timeout, false);

            JsonObject payload = createPayload();

            JsonArray listaItens = createListaItens();

            payload.add("itens", listaItens);

            JsonObject resp = nfcom.preview(payload);

            System.out.println(resp);

        } catch (Exception e) {

            e.printStackTrace();

        }
        
    }

    private static JsonObject createPayload() {
        JsonObject payload = new JsonObject();
    
        payload.addProperty("numero", "3");
        payload.addProperty("serie", "1");
        payload.addProperty("data_emissao", "2024-06-20T13:23:00-03:00");
        payload.addProperty("finalidade_emissao", "0");
        payload.addProperty("tipo_faturamento", "0");
        payload.addProperty("indicador_prepago", "0");
        payload.addProperty("indicador_cessao_meios_rede", "0");
    
        JsonObject destinatario = new JsonObject();
        destinatario.addProperty("nome", "HELIO WOLFF");
        destinatario.addProperty("cpf", "06844990960");
        destinatario.addProperty("cnpj", "");
        destinatario.addProperty("id_outros", "");
        destinatario.add("inscricao_estadual", null);
        destinatario.addProperty("indicador_inscricao_estadual", "9");
    
        JsonObject endereco = new JsonObject();
        endereco.addProperty("logradouro", "LOJA");
        endereco.add("complemento", null);
        endereco.addProperty("numero", "SN");
        endereco.addProperty("bairro", "BANANAL");
        endereco.addProperty("codigo_municipio", "4314035");
        endereco.addProperty("nome_municipio", "Pareci Novo");
        endereco.addProperty("uf", "RS");
        endereco.addProperty("codigo_pais", "1058");
        endereco.addProperty("nome_pais", "Brasil");
        endereco.addProperty("cep", "95783000");
        endereco.add("telefone", null);
        endereco.add("email", null);
    
        destinatario.add("endereco", endereco);
        payload.add("destinatario", destinatario);
    
        JsonObject assinante = new JsonObject();
        assinante.addProperty("codigo", "123");
        assinante.addProperty("tipo", "3");
        assinante.addProperty("servico", "4");
        assinante.addProperty("numero_contrato", "12345678");
        assinante.addProperty("data_inicio", "2022-01-01");
        assinante.addProperty("data_fim", "2022-01-01");
        assinante.add("numero_terminal", null);
        assinante.add("uf", null);
    
        payload.add("assinante", assinante);
    
        JsonArray itens = new JsonArray();
        payload.add("itens", itens);
    
        JsonObject cobranca = new JsonObject();
        cobranca.addProperty("data_competencia", "2024-06-01");
        cobranca.addProperty("data_vencimento", "2024-06-30");
        cobranca.addProperty("codigo_barras", "19872982798277298279287298728278272872872");
    
        payload.add("cobranca", cobranca);
    
        payload.addProperty("informacoes_adicionais_contribuinte", "");
    
        return payload;
    }

    private static JsonArray createListaItens() {
        JsonArray listaItens = new JsonArray();
        JsonObject item = new JsonObject();
    
        item.addProperty("numero_item", "1");
        item.addProperty("codigo_produto", "123");
        item.addProperty("descricao", "LP 1MB");
        item.addProperty("codigo_classificacao", "0400401");
        item.addProperty("cfop", "5301");
        item.addProperty("unidade_medida", "1");
        item.addProperty("quantidade", "1");
        item.addProperty("valor_unitario", "10.00");
        item.addProperty("valor_desconto", "0");
        item.addProperty("valor_outras_despesas", "0");
        item.addProperty("valor_bruto", "10.00");
        item.addProperty("indicador_devolucao", "0");
        item.addProperty("informacoes_adicionais", "teste");
    
        JsonObject imposto = new JsonObject();
        JsonObject icms = new JsonObject();
        icms.addProperty("situacao_tributaria", "00");
        icms.addProperty("valor_base_calculo", "10.00");
        icms.addProperty("aliquota", "18.00");
        icms.addProperty("valor", "1.80");
        imposto.add("icms", icms);
    
        JsonObject fcp = new JsonObject();
        fcp.add("aliquota", null);
        fcp.add("valor", null);
        imposto.add("fcp", fcp);
    
        item.add("imposto", imposto);
    
        listaItens.add(item);
    
        return listaItens;
    }

}
