package de.htw.berlin.domain;

import java.util.List;

public class Player {
    private String name;
    private List<Card> hand;
    private boolean saidMauMau = false;


/*
    public boolean isSaidMauMau() {
        return saidMauMau;
    }

    public void setSaidMauMau(boolean saidMauMau) {
        this.saidMauMau = saidMauMau;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Card> getHand() {
        return hand;
    }

    public void setHand(List<Card> hand) {
        this.hand = hand;
    }

 */

    boolean playCard(Card card){
        return false;
    }
    void drawCard(){}


}
