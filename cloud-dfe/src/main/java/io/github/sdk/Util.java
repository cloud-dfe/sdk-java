package io.github.sdk;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.zip.GZIPInputStream;

public final class Util {

    private Util() {}

    public static String encode(String data) {
        byte[] bytes = data.getBytes(StandardCharsets.UTF_8);
        return Base64.getEncoder().encodeToString(bytes);
    }

    public static String decode(String data) {
        byte[] decodedBytes = Base64.getDecoder().decode(data);
        try (ByteArrayInputStream compressedStream = new ByteArrayInputStream(decodedBytes);
             ByteArrayOutputStream decompressedStream = new ByteArrayOutputStream();
             GZIPInputStream gzipStream = new GZIPInputStream(compressedStream)) {
             
            byte[] buffer = new byte[1024];
            int len;
            while ((len = gzipStream.read(buffer)) != -1) {
                decompressedStream.write(buffer, 0, len);
            }
            byte[] decompressedBytes = decompressedStream.toByteArray();
            return new String(decompressedBytes, StandardCharsets.UTF_8);
        } catch (IOException e) {
            return new String(decodedBytes, StandardCharsets.UTF_8);
        }
    }

    public static String readFile(String file) throws IOException {
        File inputFile = new File(file);
        byte[] fileBytes = new byte[(int) inputFile.length()];
        try (FileInputStream fis = new FileInputStream(inputFile)) {
            fis.read(fileBytes);
        }
        return new String(fileBytes, StandardCharsets.UTF_8);
    }
}
