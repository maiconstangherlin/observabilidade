package com.maiconstangherlin.observabilidade.gzip;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class Compression {

    public static String compress(String value) throws IOException {
        var byteArrayOutputStream = new ByteArrayOutputStream();
        var gzipOutputStream = new GZIPOutputStream(byteArrayOutputStream);

        gzipOutputStream.write(value.getBytes());
        gzipOutputStream.close();

        byte[] compress = byteArrayOutputStream.toByteArray();
        return Base64.getEncoder().encodeToString(compress);
    }

    public static String decompress(String compressValue) throws IOException {
        byte[] compressed = Base64.getMimeDecoder().decode(compressValue);
        ByteArrayInputStream bis = new ByteArrayInputStream(compressed);
        GZIPInputStream gzip = new GZIPInputStream(bis);
        byte[] buf = new byte[1024];
        int len;
        StringBuilder sb = new StringBuilder();
        while ((len = gzip.read(buf)) > 0) {
            sb.append(new String(buf, 0, len));
        }
        gzip.close();
        return sb.toString();
    }
}


