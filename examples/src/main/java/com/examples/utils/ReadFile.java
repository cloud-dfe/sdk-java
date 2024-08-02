package com.examples.utils;

import io.github.sdk.Util;
import java.io.IOException;

public class ReadFile {

    public static void main(String[] args) throws IllegalAccessException, IOException {

        try {

            String result = Util.readFile("caminho_do_arquivo");

            System.out.println(result);

        } catch (Exception e) {

            e.printStackTrace();

        }
        
    }

}
