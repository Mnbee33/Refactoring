package chapter7;

public class Account {
    private AccountType type;
    private int daysOverdrawn;

    private double interestRate;

    double bankCharge() {
        double result = 4.5;
        if (daysOverdrawn > 0) {
            result += type.overdraftCharge(daysOverdrawn);
        }
        return result;
    }

    double interestForAmount_Days(double amount, int days) {
        return interestRate * amount * days / 365;
    }
}
