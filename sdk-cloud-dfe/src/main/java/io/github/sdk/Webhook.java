package io.github.sdk;

import javax.crypto.Cipher;
import javax.crypto.Mac;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Arrays;

public class Webhook {

    public static boolean isValid(String token, String payload) throws Exception {
        // Parse the JSON payload
        Gson gson = new Gson();
        JsonObject std = gson.fromJson(payload, JsonObject.class);

        if (std == null) {
            throw new Exception("Payload incorreto.");
        }

        if (!std.has("signature")) {
            throw new Exception("Payload incorreto não contêm a assinatura.");
        }

        if (token == null || token.isEmpty()) {
            throw new Exception("Token vazio.");
        }

        String key = convertKey(token);

        byte[] c = Base64.getDecoder().decode(std.get("signature").getAsString());

        int ivlen = 16;

        byte[] iv = Arrays.copyOfRange(c, 0, ivlen);
        byte[] hmac = Arrays.copyOfRange(c, ivlen, ivlen + 32);
        byte[] ciphertextRaw = Arrays.copyOfRange(c, 48, c.length);

        float originalTime = decryptTime(ciphertextRaw, key, iv);

        Mac mac = Mac.getInstance("HmacSHA256");
        mac.init(new SecretKeySpec(token.getBytes(StandardCharsets.UTF_8), "HmacSHA256"));
        byte[] calcmac = mac.doFinal(ciphertextRaw);

        if (Arrays.equals(hmac, calcmac)) {
            long currentTime = System.currentTimeMillis() / 1000;
            long dif = currentTime - (long) originalTime;

            if (dif < 300) {
                return true;
            }
            throw new Exception("Assinatura expirou.");
        }
        throw new Exception("Token ou assinatura incorreta.");
    }

    private static String convertKey(String token) {
        String key = token.substring(0, 16);
        return String.format("%-16s", key).replace(' ', '0');
    }

    private static float decryptTime(byte[] ciphertextRaw, String token, byte[] iv) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
        SecretKeySpec secretKey = new SecretKeySpec(token.getBytes(StandardCharsets.UTF_8), "AES");
        IvParameterSpec ivParams = new IvParameterSpec(iv);
        cipher.init(Cipher.DECRYPT_MODE, secretKey, ivParams);

        byte[] decryptedBytes = cipher.doFinal(ciphertextRaw);
        String decrypted = new String(decryptedBytes, StandardCharsets.UTF_8);

        return Float.parseFloat(decrypted);
    }
}
