package com.examples.cteos;

import io.github.sdk.Const;
import io.github.sdk.routes.Cteos;

import java.io.IOException;

import com.google.gson.JsonObject;

public class Status {

    public static void main(String[] args) throws IllegalAccessException, IOException {
        
        int ambiente = Const.AMBIENTE_HOMOLOGACAO;
        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJlbXAiOiJ0b2tlbl9leGVtcGxvIiwidXNyIjoidGsiLCJ0cCI6InRrIn0.Tva_viCMCeG3nkRYmi_RcJ6BtSzui60kdzIsuq5X-sQ";
        int timeout = 60;

        Cteos cteos = new Cteos(ambiente, token, timeout, false);

        JsonObject resp = cteos.status();

        System.out.println(resp);

    }

}
