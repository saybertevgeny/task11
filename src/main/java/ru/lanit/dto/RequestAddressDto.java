package ru.lanit.dto;

public class RequestAddressDto {

    private int personId;

    private String street;

    private String house;

    private String flat;

    public RequestAddressDto(String personId, String street, String house, String flat) {
        this.personId = Integer.parseInt(personId);
        this.street = street;
        this.house = house;
        this.flat = flat;
    }

    public int getPersonId() {
        return personId;
    }

    public String getStreet() {
        return street;
    }

    public String getHouse() {
        return house;
    }

    public String getFlat() {
        return flat;
    }
}
