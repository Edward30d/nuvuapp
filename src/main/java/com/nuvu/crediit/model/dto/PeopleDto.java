package com.nuvu.crediit.model.dto;

public class PeopleDto {

    private Long idPeople;
    private Long idNumber;
    private Long idType;
    private String name;
    private String lastName;
    private Long phoneNumber;
    private String address;
    private String email;

    public PeopleDto() {
    }

    public Long getIdPeople() {
        return idPeople;
    }

    public void setIdPeople(Long idPeople) {
        this.idPeople = idPeople;
    }

    public Long getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(Long idNumber) {
        this.idNumber = idNumber;
    }

    public Long getIdType() {
        return idType;
    }

    public void setIdType(Long idType) {
        this.idType = idType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
