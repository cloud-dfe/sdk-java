package com.examples.utils;

import io.github.sdk.Util;
import java.io.IOException;

public class Decode {

    public static void main(String[] args) throws IllegalAccessException, IOException {

        try {

            //Exemplo de base64 + Compactado/zipado
            String data = "dGV4dG8gYSBzZXIgZGVjb2RpZmljYWRv";
            
            //Exemplo de base64
            //String data = "H4sIAAAAAAAACgtJrSjJV0jOzy1ITC5JTMnXr8osAFIATnk5SBcAAAA=";

            String result = Util.decode(data);

            System.out.println(result);

        } catch (Exception e) {

            e.printStackTrace();

        }
        
    }

}
