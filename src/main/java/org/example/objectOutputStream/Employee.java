package org.example.objectOutputStream;

import lombok.Data;

import java.io.Serializable;

@Data
public class Employee implements Serializable {
    public static final long serialVersionUID=1L;
    private String fullName;
    private float salary;

    public Employee(String fullName, float salary) {
        this.fullName = fullName;
        this.salary = salary;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }
}
