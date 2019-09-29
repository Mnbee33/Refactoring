package chapter6;

public class Item2 {
    private int quantity;
    private int itemPrice;

    double price() {
        return basePrice() - quantityDiscount() + shipping();
    }

    private double shipping() {
        return Math.min(basePrice() * 0.1, 100.0);
    }

    private int basePrice() {
        return quantity * itemPrice;
    }

    private double quantityDiscount() {
        return Math.max(0, quantity - 500) * itemPrice * 0.05;
    }
}
