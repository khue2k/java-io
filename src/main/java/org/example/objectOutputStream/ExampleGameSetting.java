package org.example.objectOutputStream;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;

public class ExampleGameSetting {
    private final static String filePath = "C:\\Users\\ADMIN\\Documents\\java-core\\java-io\\src\\main\\java\\org\\example\\objectOutputStream\\data.txt";

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        GameSetting gameSetting = new GameSetting(10, 80, null, null);
//        new ExampleGameSetting().writeGameSetting(gameSetting);
//        new ExampleGameSetting().readGameSetting(gameSetting);
        writeUnsharedTest();
        readUnsharedTest();
    }

    private void readGameSetting(GameSetting gameSetting) throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(filePath);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        //read string
        System.out.println(objectInputStream.readUTF());
        GameSetting gameSetting1 = (GameSetting) objectInputStream.readObject();
        System.out.println(gameSetting1.toString());
    }

    private void writeGameSetting(GameSetting gameSetting) throws IOException {
        OutputStream outputStream = new FileOutputStream(filePath);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        //write a string
        objectOutputStream.writeUTF("Game setting save at " + new Date());
        //write a object
        objectOutputStream.writeObject(gameSetting);
        objectOutputStream.close();
    }

    private static void writeUnsharedTest() throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(filePath);
        ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);
        ArrayList<String> list = new ArrayList<>();
        list.add("One");
        list.add("Two");
        outputStream.writeUnshared(list);
        outputStream.writeUnshared(list);
        outputStream.close();
    }

    private static void readUnsharedTest() throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(filePath);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        ArrayList<String> list1 = (ArrayList<String>) objectInputStream.readObject();
        ArrayList<String> list2 = (ArrayList<String>) objectInputStream.readObject();
        System.out.println(list1.toString());
        System.out.println(list2.toString());
        System.out.println(list1 == list2);
    }

}
