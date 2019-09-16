package videoRental;

public class Movie {
    public static final int CHILDREN = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;

    private String title;
    private Price price;

    public Movie(String title, int priceCode) {
        this.title = title;
        setPriceCode(priceCode);
    }

    public String getTitle() {
        return title;
    }

    public void setPriceCode(int priceCode) {
        switch (priceCode) {
            case Movie.REGULAR:
                price = new RegularPrice();
                break;
            case Movie.NEW_RELEASE:
                price = new NewReleasePrice();
                break;
            case Movie.CHILDREN:
                price = new ChildrenPrice();
                break;
            default:
                throw new IllegalArgumentException("不正な料金コード");
        }
    }

    public int getPriceCode() {
        return price.getPriceCode();
    }

    double getCharge(int dayRented) {
        return price.getCharge(dayRented);
    }

    int getFrequentRentarPoints(int dayRented) {
        return price.getFrequentRentarPoints(dayRented);
    }
}
