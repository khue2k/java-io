package org.example.objectOutputStream;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Example {
    private static final String filePath = "C:\\Users\\ADMIN\\Documents\\java-core\\java-io\\src\\main\\java\\org\\example\\objectOutputStream\\data.txt";

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter your choice !");
            int choice = scanner.nextInt();
            if (choice == 0)
                break;
            switch (choice) {
                case 1:
                    new Example().writeToFile(filePath);
                case 2:
                    new Example().readFromFile(filePath);
            }
        }
    }

    private void writeToFile(String filePath) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filePath));
        List<Employee> list = Arrays.asList(
                new Employee("khue", 123),
                new Employee("duong", 234),
                new Employee("duong", 234)
        );
        objectOutputStream.writeObject(list);
        objectOutputStream.close();
        System.out.println("Write finished !");
    }

    private void readFromFile(String filePath) throws IOException, ClassNotFoundException {
        File file = new File(filePath);
        InputStream inputStream = new FileInputStream(file);
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
        List<Employee> list = (List<Employee>) objectInputStream.readObject();
//        while (true) {
//            try {
//                list.add((Employee) objectInputStream.
//                        readObject());
//            } catch (EOFException e) {
//                break;
//            }
//        }
        System.out.println(list);
        objectInputStream.close();
        System.out.println("Read finished !");
    }
}
