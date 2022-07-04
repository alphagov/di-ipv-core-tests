package gov.di_ipv_core.utilities;

public enum PassportSubject implements TestInput {
    PassportSubjectHappy("321654987", "DECERQUEIRA", "KENNETH", "26", "11", "1964", "01", "01", "2030"),
    InvalidPassportNumber("ABCDEFGHI", "DECERQUEIRA", "KENNETH", "26", "11", "1964", "01", "01", "2030"),
    InvalidfirstName("ABCDEFGHI", "DECERQUEIRA", "KENNE£4", "26", "11", "1964", "01", "01", "2030"),
    Invalidsurname("ABCDEFGHI", "DECERQ&^%3RA", "KENNETH", "26", "11", "1964", "01", "01", "2030"),
    InvalidDateofBirth("ABCDEFGHI", "DECERQ&^%3RA", "KENNETH", "26", "13", "1964", "01", "01", "2030"),
    InvalidExpiryDate("ABCDEFGHI", "DECERQ&^%3RA", "KENNETH", "26", "12", "1964", "41", "01", "2030");

    private String passportNumber, surname, givenName, birthDay, birthMonth, birthYear, expiryDay, expiryMonth, expiryYear;

    PassportSubject(String passportNumber, String surname, String givenName, String birthDay, String birthMonth, String birthYear, String expiryDay, String expiryMonth, String expiryYear) {
        this.passportNumber = passportNumber;
        this.surname = surname;
        this.givenName = givenName;
        this.birthDay = birthDay;
        this.birthMonth = birthMonth;
        this.birthYear = birthYear;
        this.expiryDay = expiryDay;
        this.expiryMonth = expiryMonth;
        this.expiryYear = expiryYear;
    }

    public String getpassportNumber() {
        return passportNumber;
    }

    public String getsurname() {
        return surname;
    }

    public String getgivenName() {
        return givenName;
    }

    public String getbirthDay() {
        return birthDay;
    }

    public String getbirthMonth() {
        return birthMonth;
    }

    public String getbirthYear() {
        return birthYear;
    }

    public String getexpiryDay() {
        return expiryDay;
    }

    public String getexpiryMonth() {
        return expiryMonth;
    }

    public String getexpiryYear() {
        return expiryYear;
    }
}

