package org.example.dataOutputStream;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private LocalDate orderDate;
    private boolean finished;
    private String item;
    private int units;
    private float unitCost;
    private float total;
}
