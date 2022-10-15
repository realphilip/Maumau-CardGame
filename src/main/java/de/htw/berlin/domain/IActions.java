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
     *
     * @param card The card is played
     * @return If playing was successful
     */
    boolean playCard(Card card);
    void shuffleStack(List<Card> cardList);
    void executeAction(_Action action);
    void announceWinner();

}
