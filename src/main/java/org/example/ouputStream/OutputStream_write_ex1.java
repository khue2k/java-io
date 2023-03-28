package org.example.ouputStream;

import java.io.*;
import java.net.URL;

public class OutputStream_write_ex1 {
    private static final  String filePath="C:\\Users\\ADMIN\\Documents\\java-core\\java-io\\src\\main\\java\\org\\example\\ouputStream\\output.txt";
    public static void main(String[] args)  {
        OutputStream outputStream;
        try {
            outputStream=new FileOutputStream(filePath);
            String text="duong xuan khue";
            byte[]bytes=text.getBytes();
            outputStream.write(bytes);
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
