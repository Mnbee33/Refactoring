package videoRental;

public class NewReleasePrice extends Price {
    @Override
    int getPriceCode() {
        return Movie.NEW_RELEASE;
    }

    @Override
    double getCharge(int dayRented) {
        return dayRented * 3;
    }

    @Override
    int getFrequentRentarPoints(int dayRented) {
        return (dayRented > 1) ? 2 : 1;
    }
}
