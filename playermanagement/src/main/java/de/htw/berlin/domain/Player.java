package de.htw.berlin.domain;

import javax.persistence.Embeddable;
import java.util.List;
@Embeddable
public class Player {
    private String name;
    private Stack hand;

    private boolean aiOrNot = false;
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

    public boolean isAiOrNot() {
        return aiOrNot;
    }

    public void setAiOrNot(boolean aiOrNot) {
        this.aiOrNot = aiOrNot;
    }

    public boolean isSaidMauMau() {
        return saidMauMau;
    }

    public void setSaidMauMau(boolean saidMauMau) {
        this.saidMauMau = saidMauMau;
    }
}
