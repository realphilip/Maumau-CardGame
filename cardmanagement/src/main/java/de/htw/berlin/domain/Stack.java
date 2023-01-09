package de.htw.berlin.domain;

import java.util.ArrayList;
import java.util.List;

public class Stack {
    public List<Card> cardList = new ArrayList<>();

    public List<Card> getCardList() {
        return cardList;
    }

    public void setCardList(List<Card> cardList) {
        this.cardList = cardList;
    }

}
