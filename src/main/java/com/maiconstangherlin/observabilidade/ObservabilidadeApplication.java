package com.maiconstangherlin.observabilidade;

import com.maiconstangherlin.observabilidade.gzip.Compression;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ClassPathResource;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

@SpringBootApplication
public class ObservabilidadeApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ObservabilidadeApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        ClassPathResource classPathResource = new ClassPathResource("example.json");
//        InputStream inputStream = classPathResource.getInputStream();
//
//        String value = new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
//
//        String valueCompress = Compression.compress(value);
//
//        PrintWriter printWriter = new PrintWriter("compress.txt", StandardCharsets.UTF_8);
//        printWriter.println(valueCompress);
//        printWriter.close();
//
//        String compressTxt = Files.readString(Path.of("compress.txt"), StandardCharsets.UTF_8);
//        String json = Compression.decompress(compressTxt);
//
//        printWriter = new PrintWriter("decompress.json");
//        printWriter.println(json);
//        printWriter.close();
    }
}
