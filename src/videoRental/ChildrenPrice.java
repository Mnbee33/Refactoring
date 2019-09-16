package videoRental;

public class ChildrenPrice extends Price {
    @Override
    int getPriceCode() {
        return Movie.CHILDREN;
    }

    double getCharge(int dayRented) {
        double result = 0;
        result += 1.5;
        if (dayRented > 3)
            result += (dayRented - 3) * 1.5;
        return result;
    }
}
