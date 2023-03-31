package org.example.dataOutputStream;

import java.io.*;
import java.time.LocalDate;

public class Example {
    private static final String filePath = "C:\\Users\\ADMIN\\Documents\\java-core\\java-io\\src\\main\\java\\org\\example\\dataOutputStream\\output.txt";

    public static void main(String[] args) throws Exception {
        readDataFromFile(filePath);
    }

    private static void writeFile(String filePath) throws IOException {
        Order[] orders = new Order[]{
                new Order(LocalDate.of(2020, 1, 6), true, "Pencil", 95, 1.99f, 189.05f),
                new Order(LocalDate.of(2020, 1, 23), false, "Binder", 50, 19.99f, 999.50f),
                new Order(LocalDate.of(2020, 2, 9), true, "Pencil", 36, 4.99f, 179.64f),
                new Order(LocalDate.of(2020, 2, 26), false, "Pen", 27, 19.99f, 539.73f),
                new Order(LocalDate.of(2020, 3, 15), true, "Pencil", 56, 2.99f, 167.44f) //
        };
        DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(filePath));
        for (Order order : orders) {
            dataOutputStream.writeUTF(order.getOrderDate().toString());
            dataOutputStream.writeBoolean(order.isFinished());
            dataOutputStream.writeUTF(order.getItem());
            dataOutputStream.writeInt(order.getUnits());
            dataOutputStream.writeFloat(order.getUnitCost());
            dataOutputStream.writeFloat(order.getTotal());
        }
        dataOutputStream.close();
        System.out.println("Write to output.txt success !");
    }

    private static void readFile(String filePath) throws IOException {
        DataInputStream inputStream = new DataInputStream(new FileInputStream(filePath));
        int row = 0;
        System.out.printf("|%3s | %-10s | %10s | %-15s | %Units8s| %10s | %10s |%n", //
                "No", "Order Date", "Finished?", "Item", "", "Unit Cost", "Total");

        System.out.printf("|%3s | %-10s | %10s | %-15s | %8s| %10s | %10s |%n", //
                "--", "---------", "----------", "----------", "------", "---------", "---------");

        while (inputStream.available() > 0) {
            row++;
            String orderDate = inputStream.readUTF();
            Boolean finished = inputStream.readBoolean();
            String item = inputStream.readUTF();
            int units = inputStream.readInt();
            float unitCost = inputStream.readFloat();
            float total = inputStream.readFloat();
            System.out.printf("|%3d | %-10s | %10b | %-15s | %8d| %,10.2f | %,10.2f |%n", //
                    row, orderDate, finished, item, units, unitCost, total);
        }
        System.out.println("Read file output.txt success !");
    }

    private static void writeToFile(String filePath) throws IOException {
        DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(filePath));
        dataOutputStream.writeInt(10);
        dataOutputStream.writeDouble(3.141592654);
        dataOutputStream.writeUTF("Duong Xuan Khue");
        dataOutputStream.close();
    }

    private static void readDataFromFile(String filePath) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream();
        DataOutputStream dataOutputStream=new DataOutputStream(byteArrayOutputStream);
        dataOutputStream.writeByte(111);
        dataOutputStream.writeByte(112);
        byte[]bytes= byteArrayOutputStream.toByteArray();
        for (byte b : bytes) {
            System.out.println(b);
        }
    }

}
