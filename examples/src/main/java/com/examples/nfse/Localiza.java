package com.examples.nfse;

import io.github.sdk.Const;
import io.github.sdk.routes.Nfse;

import java.io.IOException;

import com.google.gson.JsonNull;
import com.google.gson.JsonObject;

public class Localiza {

    public static void main(String[] args) throws IllegalAccessException, IOException {

        try {

            int ambiente = Const.AMBIENTE_HOMOLOGACAO;
            String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJlbXAiOiJ0b2tlbl9leGVtcGxvIiwidXNyIjoidGsiLCJ0cCI6InRrIn0.Tva_viCMCeG3nkRYmi_RcJ6BtSzui60kdzIsuq5X-sQ";
            int timeout = 60;

            Nfse nfse = new Nfse(ambiente, token, timeout, false);

            JsonObject payload = new JsonObject();

            payload.addProperty("data_emissao_inicial", "2020-01-01");
            payload.addProperty("data_emissao_final", "2020-01-31");
            payload.addProperty("data_competencia_inicial", "2020-01-01");
            payload.addProperty("data_competencia_final", "2020-01-31");
            payload.add("tomador_cnpj", JsonNull.INSTANCE);
            payload.add("tomador_cpf", JsonNull.INSTANCE);
            payload.add("tomador_im", JsonNull.INSTANCE);
            payload.add("nfse_numero", JsonNull.INSTANCE);
            payload.add("nfse_numero_inicial", JsonNull.INSTANCE);
            payload.add("nfse_numero_final", JsonNull.INSTANCE);
            payload.addProperty("rps_numero", "15");
            payload.addProperty("rps_serie", "0");
            payload.addProperty("rps_tipo", "1");
            payload.addProperty("pagina", "1");

            JsonObject resp = nfse.localiza(payload);

            System.out.println(resp);

        } catch (Exception e) {

            e.printStackTrace();

        }
        
    }

}
