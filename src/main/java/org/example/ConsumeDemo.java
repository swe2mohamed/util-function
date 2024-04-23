package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class ConsumeDemo {
    public static void main(String[] args) {
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

        // "Consumer" function interface which take a Parameter but do NOT return, it just for print.
        Consumer<Account> printUsername = account -> System.out.println(account.getUsername());
        Consumer<Account> printRegisterDate = account -> System.out.println(account.getCreateDate());

        Predicate<Account> isGuestRole = account -> account.getRole().equals(Role.GUEST);


        // we can use "for loop" ---> we use "accept" which is method in Consumer.
        System.out.println("___for loop___");
        for (Account account : accounts){
            printUsername.accept(account);
        }

        // we can use "forEach" which is a method in the "Consumer"
        System.out.println("___forEach___");
        accounts.forEach(printUsername);

        System.out.println("___UserRole: by use forEach___");
        accounts.forEach(account -> {
            if (isGuestRole.test(account)) {
                System.out.println(account.getUsername());
            }
        });

    }
}
