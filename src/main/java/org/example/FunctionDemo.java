package org.example;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class FunctionDemo {
    // Use Case: it used to apply a transformation to an input value and produce an output.
    public static void main(String[] args) {
        Function<String, String> toLowerCase = s -> s.toLowerCase();
        System.out.println(toLowerCase.apply("MOHAMED"));
        UnaryOperator<String> toUppercase = s -> s.toUpperCase();
        System.out.println(toUppercase.apply("hello"));
        Function<Double, String> formatNum = n -> n.toString();
        System.out.println(formatNum.apply(34d));
        Function<Double, String> formatNumber = (number) -> {
            DecimalFormat decimalFormat = new DecimalFormat("#,###.00");
            return decimalFormat.format(number);
        };
        double num = 213423433.34342;
        String formattedNumber = formatNumber.apply(num);
        System.out.println(formatNumber.apply(23213233.323122));
        System.out.println(formattedNumber);

        Integer[] numbers = {1,2,3,4,5};
        Function<Integer[] , Integer> arrayToAvg = arrayOfNumber -> {
            int sum = 0;
            for (Integer number : arrayOfNumber ){
                sum += number;
            }
            int avg = sum/(arrayOfNumber.length);
            return avg;
        };
        System.out.println(arrayToAvg.apply(numbers));

        System.out.println("_____________________");

        List<Account> accounts = new ArrayList<>();

        Account account1 = new Account("Dev1");
        account1.setRole(Role.USER);
        account1.enable();
        Account account2 = new Account("Dev2");
        account2.setRole(Role.USER);
        account2.enable();
        Account account3 = new Account("Guest1");
        Account account4 = new Account("Guest2");
        Account account5 = new Account("Guest3");
        Account account6 = new Account("Guest4");
        accounts.add(account1);
        accounts.add(account2);
        accounts.add(account3);
        accounts.add(account4);
        accounts.add(account5);
        accounts.add(account6);

        Function<Account, String> extractAccountInfo = (account -> account.getUsername() + " " + account.getRole());
        System.out.println(extractAccountInfo.apply(account1));
        System.out.println("___printAccount___");
        Consumer<Account> printAccount = account -> System.out.println(account);
        accounts.forEach(printAccount);
        System.out.println("___printAccountInfo___");
        Consumer<Account> printAccountInfo = account -> System.out.println(extractAccountInfo.apply(account));
        accounts.forEach(printAccountInfo);


    }
}
