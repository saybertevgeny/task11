package ru.lanit.dto;

import java.time.LocalDate;

public class RequestPersonDto {

    private final String firstname;

    private final String middlename;

    private final String lastname;

    private final LocalDate birthdate;

    public RequestPersonDto(String firstname, String middlename, String lastname, String birthdate) {
        this.firstname = firstname;
        this.middlename = middlename;
        this.lastname = lastname;
        this.birthdate = LocalDate.parse(birthdate);
    }

    public String getFirstname() {
        return firstname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public String getLastname() {
        return lastname;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }
}
