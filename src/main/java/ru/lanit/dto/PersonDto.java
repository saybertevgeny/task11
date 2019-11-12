package ru.lanit.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PersonDto {

    private int id;

    private String fullname;

    private LocalDate birthdate;

    private List<AddressDto> addresses;

    public PersonDto(int id, String fullname, LocalDate birthdate) {
        this.id = id;
        this.fullname = fullname;
        this.birthdate = birthdate;
        this.addresses = new ArrayList<>();
    }

    public PersonDto(int id, String fullname, LocalDate birthdate, List<AddressDto> addresses) {
        this.id = id;
        this.fullname = fullname;
        this.birthdate = birthdate;
        this.addresses = addresses;
    }

    public int getId() {
        return id;
    }

    public String getFullname() {
        return fullname;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public List<AddressDto> getAddresses() {
        return this.addresses;
    }
}
