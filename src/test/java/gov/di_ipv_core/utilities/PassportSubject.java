package gov.di_ipv_core.utilities;

public enum PassportSubject implements TestInput {
    PassportSubjectHappyDanny("543543543", "Smith", "Danny", "27", "08", "1995", "01", "01", "2030"),
    PassportSubjectHappyKenneth("321654987", "DECERQUEIRA", "KENNETH", "23", "08", "1959", "01", "01", "2030"),
    InvalidPassportNumber("ABCDEFGHI", "DECERQUEIRA", "KENNETH", "23", "08", "1959", "01", "01", "2030"),
    InvalidfirstName("321654987", "DECERQUEIRA", "KENNE£4", "23", "08", "1959", "01", "01", "2030"),
    Invalidsurname("321654987", "DECERQ&^%3RA", "KENNETH", "23", "08", "1959", "01", "01", "2030"),
    InvalidDateofBirth("321654987", "DECERQUEIRA", "KENNETH", "23", "13", "1959", "01", "01", "2030"),
    InvalidExpiryDate("321654987", "DECERQUEIRA", "KENNETH", "23", "08", "1959", "41", "01", "2030");

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

