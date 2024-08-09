package com.examples.cte;

import io.github.sdk.Const;
import io.github.sdk.routes.Cte;

import java.io.IOException;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class Preview {

    public static void main(String[] args) throws IllegalAccessException, IOException {
        
        int ambiente = Const.AMBIENTE_HOMOLOGACAO;
        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJlbXAiOiJ0b2tlbl9leGVtcGxvIiwidXNyIjoidGsiLCJ0cCI6InRrIn0.Tva_viCMCeG3nkRYmi_RcJ6BtSzui60kdzIsuq5X-sQ";
        int timeout = 60;

        Cte cte = new Cte(ambiente, token, timeout, false);

        JsonObject payload = createPayload();

        JsonObject resp = cte.preview(payload);

        System.out.println(resp);

    }
    
    private static JsonObject createPayload() {
        JsonObject payload = new JsonObject();

        payload.addProperty("cfop", "5932");
        payload.addProperty("natureza_operacao", "PRESTACAO DE SERVIÇO");
        payload.addProperty("numero", "66");
        payload.addProperty("serie", "1");
        payload.addProperty("data_emissao", "2021-06-22T03:00:00-03:00");
        payload.addProperty("tipo_operacao", "0");
        payload.addProperty("codigo_municipio_envio", "2408003");
        payload.addProperty("nome_municipio_envio", "MOSSORO");
        payload.addProperty("uf_envio", "RN");
        payload.addProperty("tipo_servico", "0");
        payload.addProperty("codigo_municipio_inicio", "2408003");
        payload.addProperty("nome_municipio_inicio", "Mossoró");
        payload.addProperty("uf_inicio", "RN");
        payload.addProperty("codigo_municipio_fim", "2408003");
        payload.addProperty("nome_municipio_fim", "Mossoró");
        payload.addProperty("uf_fim", "RN");
        payload.addProperty("retirar_mercadoria", "1");
        payload.add("detalhes_retirar", null);
        payload.addProperty("tipo_programacao_entrega", "0");
        payload.addProperty("sem_hora_tipo_hora_programada", "0");

        JsonObject remetente = new JsonObject();
        remetente.addProperty("cpf", "01234567890");
        remetente.add("inscricao_estadual", null);
        remetente.addProperty("nome", "EMPRESA MODELO");
        remetente.addProperty("razao_social", "MODELO LTDA");
        remetente.addProperty("telefone", "8433163070");

        JsonObject enderecoRemetente = new JsonObject();
        enderecoRemetente.addProperty("logradouro", "AVENIDA TESTE");
        enderecoRemetente.addProperty("numero", "444");
        enderecoRemetente.addProperty("bairro", "CENTRO");
        enderecoRemetente.addProperty("codigo_municipio", "2408003");
        enderecoRemetente.addProperty("nome_municipio", "MOSSORÓ");
        enderecoRemetente.addProperty("uf", "RN");

        remetente.add("endereco", enderecoRemetente);
        payload.add("remetente", remetente);

        JsonObject valores = new JsonObject();
        valores.addProperty("valor_total", "0.00");
        valores.addProperty("valor_receber", "0.00");
        valores.addProperty("valor_total_carga", "224.50");
        valores.addProperty("produto_predominante", "SAL");

        JsonArray quantidades = new JsonArray();
        JsonObject quantidade = new JsonObject();
        quantidade.addProperty("codigo_unidade_medida", "01");
        quantidade.addProperty("tipo_medida", "Peso Bruto");
        quantidade.addProperty("quantidade", "500.00");
        quantidades.add(quantidade);

        valores.add("quantidades", quantidades);
        payload.add("valores", valores);

        JsonObject imposto = new JsonObject();
        JsonObject icms = new JsonObject();
        icms.addProperty("situacao_tributaria", "20");
        icms.addProperty("valor_base_calculo", "0.00");
        icms.addProperty("aliquota", "12.00");
        icms.addProperty("valor", "0.00");
        icms.addProperty("aliquota_reducao_base_calculo", "50.00");
        imposto.add("icms", icms);
        payload.add("imposto", imposto);

        JsonArray nfes = new JsonArray();
        JsonObject nfe = new JsonObject();
        nfe.addProperty("chave", "50000000000000000000000000000000000000000000");
        nfes.add(nfe);
        payload.add("nfes", nfes);

        JsonObject modalRodoviario = new JsonObject();
        modalRodoviario.addProperty("rntrc", "02033517");
        payload.add("modal_rodoviario", modalRodoviario);

        JsonObject destinatario = new JsonObject();
        destinatario.addProperty("cpf", "01234567890");
        destinatario.add("inscricao_estadual", null);
        destinatario.addProperty("nome", "EMPRESA MODELO");
        destinatario.addProperty("telefone", "8499995555");

        JsonObject enderecoDestinatario = new JsonObject();
        enderecoDestinatario.addProperty("logradouro", "AVENIDA TESTE");
        enderecoDestinatario.addProperty("numero", "444");
        enderecoDestinatario.addProperty("bairro", "CENTRO");
        enderecoDestinatario.addProperty("codigo_municipio", "2408003");
        enderecoDestinatario.addProperty("nome_municipio", "Mossoró");
        enderecoDestinatario.addProperty("cep", "59603330");
        enderecoDestinatario.addProperty("uf", "RN");
        enderecoDestinatario.addProperty("codigo_pais", "1058");
        enderecoDestinatario.addProperty("nome_pais", "BRASIL");
        enderecoDestinatario.addProperty("email", "teste@teste.com.br");

        destinatario.add("endereco", enderecoDestinatario);
        payload.add("destinatario", destinatario);

        JsonArray componentesValor = new JsonArray();
        JsonObject componenteValor = new JsonObject();
        componenteValor.addProperty("nome", "teste2");
        componenteValor.addProperty("valor", "1999.00");
        componentesValor.add(componenteValor);
        payload.add("componentes_valor", componentesValor);

        JsonObject tomador = new JsonObject();
        tomador.addProperty("tipo", "3");
        tomador.addProperty("indicador_inscricao_estadual", "9");
        payload.add("tomador", tomador);

        payload.addProperty("observacao", "");

        return payload;
    }
    
}
