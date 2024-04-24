package org.example;

import javax.annotation.processing.SupportedOptions;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.UUID;
import java.util.function.Supplier;

public class SupplierDemo {
    public static void main(String[] args) {
        Supplier<String> sessionIdSupplier = () -> UUID.randomUUID().toString();
        System.out.println("ID: " + sessionIdSupplier.get());

        Supplier<Double> takeDecimalInput = () -> {
            double number;
            while (true) {
                try {
                    Scanner scanner = new Scanner(System.in);
                    System.out.println("Enter the number: ");
                    number = scanner.nextDouble();
                    break;
                }catch (InputMismatchException e){
                    System.out.println("Number not valid");
                    System.out.println("_____");
                }
            }
            return number;
        };
        System.out.println(takeDecimalInput.get());
    }

}