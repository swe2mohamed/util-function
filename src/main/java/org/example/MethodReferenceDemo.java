package org.example;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.ToDoubleBiFunction;

public class MethodReferenceDemo {
    public static void main(String[] args) {
        // First method use Lambda expression.
        Function<Double, Double> calTaxLambda = salary -> Calculator.calculateTax(salary);
        // Second method use Method Reference.
        // Reference to a static method (ClassName::staticMethodName)
        Function<Double, Double> calTaxMethodReference = Calculator::calculateTax;
        System.out.println(calTaxMethodReference.apply(10000d));

        Calculator calculator = new Calculator();
        BiFunction<Double, Double, Double> additionUseLambda = (n1, n2) -> calculator.addition(n1, n2);
        System.out.println(additionUseLambda.apply(3d,5d));

        BiFunction<Double, Double, Double> additionUsedMethodReference = calculator::addition;
        System.out.println(additionUsedMethodReference.apply(3d,4d));
    }
    }

