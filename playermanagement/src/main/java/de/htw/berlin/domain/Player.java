package de.htw.berlin.domain;

import java.util.List;

public class Player {
    private String name;
    private Stack hand;
    private boolean saidMauMau = false;

    //add boolean for real player/computer player

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Stack getHand() {
        return hand;
    }

    public void setHand(Stack hand) {
        this.hand = hand;
    }

    public boolean isSaidMauMau() {
        return saidMauMau;
    }

    public void setSaidMauMau(boolean saidMauMau) {
        this.saidMauMau = saidMauMau;
    }
}
