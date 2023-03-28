package org.example.byteArrayInputStream;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class Example {
    public static void main(String[] args) throws IOException {
//        String data = "duong xuan khue 123";
//        byte[] bytes = data.getBytes();
//        ByteArrayInputStream inputStream = new ByteArrayInputStream(bytes);
//        inputStream.mark(4);
//        System.out.println(inputStream.markSupported());
//        int code;
//        while ((code = inputStream.read()) != -1) {
//            System.out.print((char) code);
//        }
//        System.out.println();
//        inputStream.reset();
//        System.out.println(inputStream.available());
        byte[]bytes=new byte[]{5,6,7,8,9,10};
        ByteArrayInputStream inputStream=new ByteArrayInputStream(bytes);
        System.out.println(inputStream.markSupported());

        System.out.println(inputStream.read());
        inputStream.mark(1);
        System.out.println(inputStream.read());
        System.out.println(inputStream.read());
        System.out.println("reset");
        inputStream.reset();
        System.out.println(inputStream.read());
    }
}
