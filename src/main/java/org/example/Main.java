package org.example;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        String str = "2.02303E13";
        BigDecimal bigDecimal = new BigDecimal(str);
        long result = bigDecimal.longValueExact();

        System.out.println(result);
    }
}