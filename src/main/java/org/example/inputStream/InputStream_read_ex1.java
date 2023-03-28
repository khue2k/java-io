package org.example.inputStream;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class InputStream_read_ex1 {
    private static final String fileInputPath = "C:\\Users\\ADMIN\\Documents\\java-core\\java-io\\src\\main\\java\\org\\example\\inputStream\\input.txt";
    private static final String fileOutputPath = "C:\\Users\\ADMIN\\Documents\\java-core\\java-io\\src\\main\\java\\org\\example\\inputStream\\output.txt";

    public static void main(String[] args) throws IOException {
        InputStream is =new FileInputStream(fileInputPath);
        
    }
}
