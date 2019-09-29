package chapter6;

import java.util.ArrayList;
import java.util.List;

public class Print {
    List<Order> orders = new ArrayList<>();
    String name;

    void printOwing(double previousAmount) {
        printBanner();
        double outstanding = previousAmount * 1.2;
        for (Order each : orders) {
            outstanding += each.getAmount();
        }
        printDetails(outstanding);
    }

    private void printBanner() {
        System.out.println("*******************");
        System.out.println("** Customer Owes **");
        System.out.println("*******************");
    }

    private void printDetails(double outstanding) {
        System.out.println("name: " + name);
        System.out.println("amount: " + outstanding);
    }
}
