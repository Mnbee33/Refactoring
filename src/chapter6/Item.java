package chapter6;

public class Item {
    int quantity;
    int itemPrice;

    double getPrice() {
        int basePrice = quantity * itemPrice;
        double discountFactor;
        if (basePrice > 1000) {
            discountFactor = 0.95;
        } else {
            discountFactor = 0.98;
        }
        return basePrice * discountFactor;
    }
}
