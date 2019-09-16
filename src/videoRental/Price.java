package videoRental;

abstract class Price {
    abstract int getPriceCode();

    abstract double getCharge(int dayRented);

    int getFrequentRentarPoints(int dayRented) {
        return 1;
    }
}
