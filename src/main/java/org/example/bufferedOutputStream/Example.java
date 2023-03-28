package org.example.bufferedOutputStream;

import java.io.*;

public class Example {
    private static final String filePath = "C:\\Users\\ADMIN\\Documents\\java-core\\java-io\\src\\main\\java\\org\\example\\bufferedOutputStream\\output.txt";

    public static void main(String[] args) throws IOException {
        BufferedOutputStream bufferedOutputStream = null;
        OutputStream outputStream = null;
        InputStream inputStream = null;
        try {
            //Write to file
            outputStream = new FileOutputStream(filePath);
            bufferedOutputStream = new BufferedOutputStream(outputStream, 1024);
            String text = "Duong Xuan Khue";
            byte[] bytes = text.getBytes();
            outputStream.write(bytes);
            //read data from file
            inputStream = new FileInputStream(filePath);
            int code = 0;
            System.out.println("Read data from file !");
            while ((code = inputStream.read()) != -1) {
                System.out.print((char) code);
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            bufferedOutputStream.close();
            outputStream.close();
            inputStream.close();
        }
    }
}
