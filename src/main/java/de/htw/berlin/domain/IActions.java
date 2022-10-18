package de.htw.berlin.domain;

import java.util.List;

public interface IActions {

    /**
     *
     * @return
     */
    Card drawCard(int howManytoDraw); //define how many

    /**
     * Play a card
     * Card must be playable
     * @param card The card is played
     * @return If playing was successful
     */
    boolean playCard(Card card, Color color); //Jack cant be played on another Jack // consider Stack and Player

    void wishColor (Color color);
    void skipTurn();
    boolean sayMauMau();
    void shuffleStack(List<Card> cardList);
    void announceWinner();

}
