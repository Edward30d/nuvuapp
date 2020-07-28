package com.nuvu.crediit.model.dto;

public class RequestAddCard {

    private PeopleDto people;
    private CardDto card;

    public PeopleDto getPeople() {
        return people;
    }

    public void setPeople(PeopleDto people) {
        this.people = people;
    }

    public CardDto getCard() {
        return card;
    }

    public void setCard(CardDto card) {
        this.card = card;
    }
}
