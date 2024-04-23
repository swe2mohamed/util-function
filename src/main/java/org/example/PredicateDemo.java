package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class PredicateDemo {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = -10; i < 30; i++) {
            numbers.add(i);
        }

        Predicate<Integer> isPositive = number -> number > 0;
        System.out.println("____isGreaterThan18____");
        Predicate<Integer> isGreaterThan18 = number -> number > 18;
        filterNumber(numbers, isGreaterThan18);
        System.out.println("____isEven____");
        Predicate<Integer> isEven = number -> number % 2 == 0;
        filterNumber(numbers, isEven);



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

        Predicate<Account> isEnable = account -> account.isEnable();
        Predicate<Account> isRoleUser = account -> account.getRole().equals(Role.USER);

        System.out.println("____Size enable account____");
        List<Account> enableAccount = filterAccounts(accounts,isEnable);
        System.out.println(enableAccount.size());

        System.out.println("____User account____");
        List<Account> userAccounts = filterAccounts(accounts, isRoleUser);
        System.out.println(userAccounts);


    }

    /* Use case for Predicate Interface is to:
        - Filter elements in condition
        - Selecting element from a stream or sequence of data tha  meet the "specific condition".
     */

    public static void filterNumber(List<Integer> numbers, Predicate<Integer> predicate) {
        for (Integer number : numbers) {
            if (predicate.test(number)) {
                System.out.print(number + " ");
            }
        }
        System.out.println();
    }

    ;

    public static List<Account> filterAccounts(List<Account> accounts, Predicate<Account> predicate) {
        List<Account> result = new ArrayList<>();
        for (Account account : accounts) {
            if (predicate.test(account)) {
                result.add(account);
            }
        }
        return result;
    }

}

