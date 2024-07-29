package com.examples.cte;

import io.github.sdk.Const;
import io.github.sdk.Util;
import io.github.sdk.routes.Cte;

import java.io.IOException;

import com.google.gson.JsonObject;

public class Correcao {

    public static void main(String[] args) throws IllegalAccessException, IOException {
        
        int ambiente = Const.AMBIENTE_HOMOLOGACAO;
        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJlbXAiOjQ2MSwidXNyIjoxNzAsInRwIjoyLCJpYXQiOjE2NTE1MDYzMjR9.a0cOwP6BUDZAboYwMzoMjutCtFM8Ph-X4pLahZIB_V4";
        int timeout = 60;

        Cte cte = new Cte(ambiente, token, timeout, false);

    }

}
