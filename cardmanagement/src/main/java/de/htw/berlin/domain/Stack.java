package de.htw.berlin.domain;

import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;
import java.util.ArrayList;
import java.util.List;

@Embeddable
public class Stack {
    public List<Card> cardList = new ArrayList<>();

    @ElementCollection
    public List<Card> getCardList() {
        return cardList;
    }

    public void setCardList(List<Card> cardList) {
        this.cardList = cardList;
    }

}
