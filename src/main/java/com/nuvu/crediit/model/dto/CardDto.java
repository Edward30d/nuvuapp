package com.nuvu.crediit.model.dto;

public class CardDto {

    private String type;
    private String franchise;
    private Long idNumber;
    private String dateExpiry;
    private Long csv;
    private Long balance;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFranchise() {
        return franchise;
    }

    public void setFranchise(String franchise) {
        this.franchise = franchise;
    }

    public Long getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(Long idNumber) {
        this.idNumber = idNumber;
    }

    public String getDateExpiry() {
        return dateExpiry;
    }

    public void setDateExpiry(String dateEnpiry) {
        this.dateExpiry = dateEnpiry;
    }

    public Long getCsv() {
        return csv;
    }

    public void setCsv(Long csv) {
        this.csv = csv;
    }

    public Long getBalance() {
        return balance;
    }

    public void setBalance(Long balance) {
        this.balance = balance;
    }
}
