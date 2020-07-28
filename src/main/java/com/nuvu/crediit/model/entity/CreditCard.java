package com.nuvu.crediit.model.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CreditCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCreditCard;
    private Long idNumber;
    private String dateExpiry;
    private Long csv;
    private Long people;
    private Long categoryCard;
    private Long balance;

    public CreditCard() {
    }

    public Long getIdCreditCard() {
        return idCreditCard;
    }

    public void setIdCreditCard(Long idCreditCard) {
        this.idCreditCard = idCreditCard;
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

    public Long getPeople() {
        return people;
    }

    public void setPeople(Long people) {
        this.people = people;
    }

    public Long getCategoryCard() {
        return categoryCard;
    }

    public void setCategoryCard(Long categoryCard) {
        this.categoryCard = categoryCard;
    }

    public Long getBalance() {
        return balance;
    }

    public void setBalance(Long balance) {
        this.balance = balance;
    }
}
