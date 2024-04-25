package org.example;

public class Calculator {

    public static double calculateTax(double salary){
        final double TAX_RATE = 0.15;
        return salary * TAX_RATE;
    }

    public double addition(double n1, double n2){
        return n1 + n2;
    }
}
