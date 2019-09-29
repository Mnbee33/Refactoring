package chapter6;

import java.util.ArrayList;
import java.util.List;

public class Print {
    List<Order> orders = new ArrayList<>();
    String name;

    void printOwing() {
        double outstanding = 0.0;

        System.out.println("*******************");
        System.out.println("** Customer Owes **");
        System.out.println("*******************");

        for (Order each : orders) {
            outstanding += each.getAmount();
        }

        System.out.println("name: " + name);
        System.out.println("amount: " + outstanding);
    }
}
