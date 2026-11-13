package com.examples.nfabi;

import io.github.sdk.Const;
import io.github.sdk.routes.Nfabi;

import java.io.IOException;

import com.google.gson.JsonObject;

public class Status {

    public static void main(String[] args) throws IllegalAccessException, IOException {

        try {

            int ambiente = Const.AMBIENTE_HOMOLOGACAO;
            String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJlbXAiOiJ0b2tlbl9leGVtcGxvIiwidXNyIjoidGsiLCJ0cCI6InRrIn0.Tva_viCMCeG3nkRYmi_RcJ6BtSzui60kdzIsuq5X-sQ";
            int timeout = 60;

            Nfabi nfabi = new Nfabi(ambiente, token, timeout, false);

            JsonObject resp = nfabi.status();

            System.out.println(resp);

        } catch (Exception e) {

            e.printStackTrace();

        }
        
    }

}
