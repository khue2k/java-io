package org.example.bufferedInputStream;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Example {
    private static  final  String filePath="C:\\Users\\ADMIN\\Documents\\java-core\\java-io\\src\\main\\java\\org\\example\\bufferedInputStream\\input.txt";
    public static void main(String[] args) throws IOException {
        BufferedInputStream bufferedInputStream = null;
        InputStream inputStream=null;
        try {
            inputStream=new FileInputStream(filePath);
            bufferedInputStream=new BufferedInputStream(inputStream,1024);
            int code=0;
            while ((code=bufferedInputStream.read())!=-1){
                System.out.print((char) code);
            }
        } finally {
            bufferedInputStream.close();
            inputStream.close();
        }
    }
}
