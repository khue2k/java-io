package org.example.pipedInputStream;

import java.io.*;

public class Example {
    private BufferedInputStream bufferedInputStream;
    private BufferedOutputStream bufferedOutputStream;

    public static void main(String[] args) throws IOException {
        new Example().test();
    }

    private void test() throws IOException {
        PipedInputStream pipedInputStream=new PipedInputStream();
        PipedOutputStream pipedOutputStream =new PipedOutputStream();
        pipedOutputStream.connect(pipedInputStream);
        this.bufferedInputStream=new BufferedInputStream(pipedInputStream);
        this.bufferedOutputStream=new BufferedOutputStream(pipedOutputStream);

        new ThreadA().start();
        new ThreadB().start();
    }

    public class ThreadA extends Thread {

        @Override
        public void run() {
            try {
                byte[] bytes=new byte[]{'a', 97, 'b', 'c', 101};
                for (byte b : bytes) {
                    bufferedOutputStream.write(b);
                    Thread.sleep(1000);
                }
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
            finally {
                closeQuietly(bufferedOutputStream);
            }
        }
    }

    public class ThreadB extends Thread {
        @Override
        public void run() {
            try {
                int code=0;
                while ((code=bufferedInputStream.read())!=-1){
                    System.out.println(code+" : "+(char)code);
                }
            }
            catch (Exception e){
                e.printStackTrace();
            }
            finally {
                closeQuietly(bufferedInputStream);
            }
        }
    }
    private void closeQuietly(InputStream inputStream){
        try {
            if (inputStream!=null){
                inputStream.close();
            }
        }catch (IOException e ){
            e.printStackTrace();
        }
    }
    private void closeQuietly(OutputStream outputStream){
        try {
            if (outputStream!=null){
                outputStream.close();
            }
        }catch (IOException e ){
            e.printStackTrace();
        }
    }
}
