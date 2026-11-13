package com.examples.nfabi;

import io.github.sdk.Const;
import io.github.sdk.routes.Nfabi;

import java.io.IOException;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Desfazimento {

    public static void main(String[] args) throws IllegalAccessException, IOException {

        try {

            int ambiente = Const.AMBIENTE_HOMOLOGACAO;
            String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJlbXAiOiJ0b2tlbl9leGVtcGxvIiwidXNyIjoidGsiLCJ0cCI6InRrIn0.Tva_viCMCeG3nkRYmi_RcJ6BtSzui60kdzIsuq5X-sQ";
            int timeout = 60;

            Nfabi nfabi = new Nfabi(ambiente, token, timeout, false);

            JsonObject payload = JsonParser.parseString("{\"chave\": \"41261210944071000104770010000001231012345679\", \"tipo\": \"01\", \"data\": \"2027-02-01\"}").getAsJsonObject();

            JsonObject resp = nfabi.desfazimento(payload);

            System.out.println(resp);

        } catch (Exception e) {

            e.printStackTrace();

        }
        
    }

}
