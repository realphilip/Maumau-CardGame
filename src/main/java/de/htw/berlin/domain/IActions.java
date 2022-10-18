package de.htw.berlin.domain;

import java.util.List;

public interface IActions {

    /**
     *
     * @return
     */
    Card drawCard();

    /**
     * Play a card
     * Card must be playable
     * @param card The card is played
     * @return If playing was successful
     */
    boolean playCard(Card card);
    void shuffleStack(List<Card> cardList);
    void executeAction(String action);
    void announceWinner();

}
