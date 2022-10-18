package de.htw.berlin.domain;

import java.util.List;

public class Game {
    //oder: ansatz - playerlist immer wechseln
    private List<Player> playerList;
    private Stack drawStack;
    private Stack playStack;
    private Color currentColor;
    public List<Player> getPlayerList() {
        return playerList;
    }

    public void setPlayerList(List<Player> playerList) {
        this.playerList = playerList;
    }

    public Stack getDrawStack() {
        return drawStack;
    }

    public void setDrawStack(Stack drawStack) {
        this.drawStack = drawStack;
    }

    public Stack getPlayStack() {
        return playStack;
    }

    public void setPlayStack(Stack playStack) {
        this.playStack = playStack;
    }
}
