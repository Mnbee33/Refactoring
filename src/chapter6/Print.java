package chapter6;

import java.util.ArrayList;
import java.util.List;

public class Print {
    List<Order> orders = new ArrayList<>();
    String name;

    void printOwing(double previousAmount) {
        printBanner();
        double outstanding = getOutstanding(previousAmount * 1.2);
        printDetails(outstanding);
    }

    private void printBanner() {
        System.out.println("*******************");
        System.out.println("** Customer Owes **");
        System.out.println("*******************");
    }

    private double getOutstanding(double initialValue) {
        double result = initialValue;
        for (Order each : orders) {
            result += each.getAmount();
        }
        return result;
    }

    private void printDetails(double outstanding) {
        System.out.println("name: " + name);
        System.out.println("amount: " + outstanding);
    }
}
