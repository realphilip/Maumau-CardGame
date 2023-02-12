package de.htw.berlin.domain;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
public class Game {

    //go through playerList, index 0 is player's turn
    private Player activePlayer;
    @ElementCollection
    private List<Player> playerList = new ArrayList<>();
    
    private Stack drawStack;
    private Stack playStack;

    //fields for persistent games and ability to choose between multiple
    private String uniqueGameName;
    private Long id;
    private Color currentWishedColor;
    private boolean isDirectionReversed = false;
    private int numberOfCardsToDraw;
    private boolean isCurrentPlayerSkipped = false;
    private String winner;
    private boolean specialRules;
    private boolean hasPlayerPlayed;
    private boolean isColorWishOutstanding = false;
    private int roundNumber;



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

    public String getUniqueGameName() {
        return uniqueGameName;
    }

    public void setUniqueGameName(String uniqueGameName) {
        this.uniqueGameName = uniqueGameName;
    }

    public Color getCurrentWishedColor() {
        return currentWishedColor;
    }

    public void setCurrentWishedColor(Color currentWishedColor) {
        this.currentWishedColor = currentWishedColor;
    }

    public boolean isDirectionReversed() {
        return isDirectionReversed;
    }

    public void setDirectionReversed(boolean directionReversed) {
        isDirectionReversed = directionReversed;
    }

    public int getNumberOfCardsToDraw() {
        return numberOfCardsToDraw;
    }

    public void setNumberOfCardsToDraw(int numberOfCardsToDraw) {
        this.numberOfCardsToDraw = numberOfCardsToDraw;
    }

    public boolean isCurrentPlayerSkipped() {
        return isCurrentPlayerSkipped;
    }

    public void setCurrentPlayerSkipped(boolean currentPlayerSkipped) {
        isCurrentPlayerSkipped = currentPlayerSkipped;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    public boolean isSpecialRules() {
        return specialRules;
    }

    public void setSpecialRules(boolean specialRules) {
        this.specialRules = specialRules;
    }

    public boolean isHasPlayerPlayed() {
        return hasPlayerPlayed;
    }

    public void setHasPlayerPlayed(boolean hasPlayerPlayed) {
        this.hasPlayerPlayed = hasPlayerPlayed;
    }

    public Player getActivePlayer() {
        return activePlayer;
    }

    public void setActivePlayer(Player activePlayer) {
        this.activePlayer = activePlayer;
    }

    @GeneratedValue
    @Id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isColorWishOutstanding() {
        return isColorWishOutstanding;
    }

    public void setColorWishOutstanding(boolean colorWishOutstanding) {
        isColorWishOutstanding = colorWishOutstanding;
    }

    public int getRoundNumber() {
        return roundNumber;
    }

    public void setRoundNumber(int roundNumber) {
        this.roundNumber = roundNumber;
    }
}
