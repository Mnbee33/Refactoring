package videoRental;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name;
    private List<Rental> rentals = new ArrayList<>();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental arg) {
        rentals.add(arg);
    }

    public String getName() {
        return name;
    }

    public String statement() {
        int frequentRentarPoints = 0;
        String result = "Rental Record for " + getName() + "\n";

        for (Rental each : rentals) {
            frequentRentarPoints += each.getFrequentRentarPoints();
            result += "\t" + each.getMovie().getTitle() + "\t" + each.getCharge() + "\n";
        }
        result += "Amount owed is " + getTotalCharge() + "\n";
        result += "You earned " + getTotalFrequentRenterPoint() + " frequent renter points";
        return result;
    }

    private double getTotalCharge() {
        return rentals.stream().mapToDouble(Rental::getCharge).sum();
    }

    private int getTotalFrequentRenterPoint() {
        return rentals.stream().mapToInt(Rental::getFrequentRentarPoints).sum();
    }

    public String htmlStatement() {
        String result = "<h1>Rentals for <em>" + getName() + "</em></h1><p>\n";
        for (Rental each : rentals) {
            result += each.getMovie().getTitle() + ": " + each.getCharge() + "<br>\n";
        }
        result += "<p>You owe <em>" + getTotalCharge() + "</em><p>\n";
        result += "On this rental you earned <em>" + getTotalFrequentRenterPoint() + "</em> frequent renter points<p>";
        return result;
    }
}
