package chapter6;

public class Item {
    int quantity;
    int itemPrice;

    double getPrice() {
        return basePrice() * discountFactor();
    }

    private double discountFactor() {
        if (basePrice() > 1000) {
            return 0.95;
        } else {
            return 0.98;
        }
    }

    private int basePrice() {
        return quantity * itemPrice;
    }
}
