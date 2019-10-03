package chapter7;

public class Person {
    private String name;
    private String officeAreaCode;
    private String officeNumber;

    public String getName() {
        return name;
    }

    public String getTelephoneNumber() {
        return String.format("(%s)%s", officeAreaCode, officeNumber);
    }

    String getOfficeAreaCode() {
        return officeAreaCode;
    }

    String getOfficeNumber() {
        return officeNumber;
    }

    void setOfficeAreaCode(String officeAreaCode) {
        this.officeAreaCode = officeAreaCode;
    }

    void setOfficeNumber(String officeNumber) {
        this.officeNumber = officeNumber;
    }
}
