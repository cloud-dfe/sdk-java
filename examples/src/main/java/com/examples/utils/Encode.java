package com.examples.utils;

import io.github.sdk.Util;
import java.io.IOException;

public class Encode {

    public static void main(String[] args) throws IllegalAccessException, IOException {
        
    try {

        String data = "texto a ser decodificado";
        
        String result = Util.encode(data);

        System.out.println(result);

    } catch (Exception e) {

        e.printStackTrace();

    }


    }

}
