package com.examples.mdfe;

import io.github.sdk.Const;
import io.github.sdk.routes.Mdfe;

import java.io.IOException;

import com.google.gson.JsonObject;

public class Abertos {

    public static void main(String[] args) throws IllegalAccessException, IOException {

        try {

            int ambiente = Const.AMBIENTE_HOMOLOGACAO;
            String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJlbXAiOiJ0b2tlbl9leGVtcGxvIiwidXNyIjoidGsiLCJ0cCI6InRrIn0.Tva_viCMCeG3nkRYmi_RcJ6BtSzui60kdzIsuq5X-sQ";
            int timeout = 60;

            Mdfe mdfe = new Mdfe(ambiente, token, timeout, false);

            JsonObject resp = mdfe.abertos();

            System.out.println(resp);

        } catch (Exception e) {

            e.printStackTrace();

        }
        
    }

}
