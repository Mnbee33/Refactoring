package chapter7;

public class Person {
    private String name;

    private TelephoneNumber officeTelephoneNumber = new TelephoneNumber();

    public String getName() {
        return name;
    }

    public String getTelephoneNumber() {
        return String.format("(%s)%s", officeTelephoneNumber.getOfficeAreaCode(), officeTelephoneNumber.getOfficeNumber());
    }

    String getOfficeAreaCode() {
        return officeTelephoneNumber.getOfficeAreaCode();
    }

    String getOfficeNumber() {
        return officeTelephoneNumber.getOfficeAreaCode();
    }

    void setOfficeAreaCode(String officeAreaCode) {
        officeTelephoneNumber.setOfficeAreaCode(officeAreaCode);
    }

    void setOfficeNumber(String officeNumber) {
        officeTelephoneNumber.setOfficeNumber(officeNumber);
    }
}
