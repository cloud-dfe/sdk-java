package com.examples.mdfe;

import io.github.sdk.Const;
import io.github.sdk.routes.Mdfe;

import java.io.IOException;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class Cria {

    public static void main(String[] args) throws IllegalAccessException, IOException {

        try {
        
            int ambiente = Const.AMBIENTE_HOMOLOGACAO;
            String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJlbXAiOjQ2MSwidXNyIjoxNzAsInRwIjoyLCJpYXQiOjE2NTE1MDYzMjR9.a0cOwP6BUDZAboYwMzoMjutCtFM8Ph-X4pLahZIB_V4";
            int timeout = 60;

            Mdfe mdfe = new Mdfe(ambiente, token, timeout, false);

            JsonObject payload = createPayload();

            JsonObject resp = mdfe.cria(payload);

            System.out.println(resp);

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

    private static JsonObject createPayload() {
        
        JsonObject payload = new JsonObject();

        payload.addProperty("tipo_operacao", "2");
        payload.add("tipo_transporte", null);
        payload.addProperty("numero", "27");
        payload.addProperty("serie", "1");
        payload.addProperty("data_emissao", "2021-06-26T09:21:42-00:00");
        payload.addProperty("uf_inicio", "RN");
        payload.addProperty("uf_fim", "GO");

        JsonArray municipiosCarregamento = new JsonArray();
        JsonObject municipioCarregamento = new JsonObject();
        municipioCarregamento.addProperty("codigo_municipio", "2408003");
        municipioCarregamento.addProperty("nome_municipio", "Mossoró");
        municipiosCarregamento.add(municipioCarregamento);
        payload.add("municipios_carregamento", municipiosCarregamento);

        JsonArray percursos = new JsonArray();
        JsonObject percurso1 = new JsonObject();
        percurso1.addProperty("uf", "PB");
        percursos.add(percurso1);
        JsonObject percurso2 = new JsonObject();
        percurso2.addProperty("uf", "PE");
        percursos.add(percurso2);
        JsonObject percurso3 = new JsonObject();
        percurso3.addProperty("uf", "BA");
        percursos.add(percurso3);
        payload.add("percursos", percursos);

        JsonArray municipiosDescarregamento = new JsonArray();
        JsonObject municipioDescarregamento = new JsonObject();
        municipioDescarregamento.addProperty("codigo_municipio", "5200050");
        municipioDescarregamento.addProperty("nome_municipio", "Abadia de Goiás");

        JsonArray nfes = new JsonArray();
        JsonObject nfe = new JsonObject();
        nfe.addProperty("chave", "50000000000000000000000000000000000000000000");
        nfes.add(nfe);
        municipioDescarregamento.add("nfes", nfes);
        municipiosDescarregamento.add(municipioDescarregamento);
        payload.add("municipios_descarregamento", municipiosDescarregamento);

        JsonObject valores = new JsonObject();
        valores.addProperty("valor_total_carga", "100.00");
        valores.addProperty("codigo_unidade_medida_peso_bruto", "01");
        valores.addProperty("peso_bruto", "1000.000");
        payload.add("valores", valores);

        payload.add("informacao_adicional_fisco", null);
        payload.add("informacao_complementar", null);

        JsonObject modalRodoviario = new JsonObject();
        modalRodoviario.addProperty("rntrc", "57838055");
        modalRodoviario.add("ciot", new JsonArray());
        modalRodoviario.add("contratante", new JsonArray());
        modalRodoviario.add("vale_pedagio", new JsonArray());

        JsonObject veiculo = new JsonObject();
        veiculo.addProperty("codigo", "000000001");
        veiculo.addProperty("placa", "FFF1257");
        veiculo.addProperty("renavam", "335540391");
        veiculo.addProperty("tara", "0");
        veiculo.addProperty("tipo_rodado", "01");
        veiculo.addProperty("tipo_carroceria", "00");
        veiculo.addProperty("uf", "MT");

        JsonArray condutores = new JsonArray();
        JsonObject condutor = new JsonObject();
        condutor.addProperty("nome", "JOAO TESTE");
        condutor.addProperty("cpf", "01234567890");
        condutores.add(condutor);
        veiculo.add("condutores", condutores);

        modalRodoviario.add("veiculo", veiculo);
        modalRodoviario.add("reboque", new JsonArray());

        payload.add("modal_rodoviario", modalRodoviario);

        return payload;
    
    }

}
