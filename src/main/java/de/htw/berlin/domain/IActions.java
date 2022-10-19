package de.htw.berlin.domain;

import java.util.List;

public interface IActions {

    /**
     *
     * Draws a card from the drawStack
     *
     * @return Card
     */
    Card drawCard(int howManyToDraw);

    /**
     * Play a card
     * @param card The card is played
     * @param color The color of the played card
     * @return If card is playable
     */
    boolean playCard(Card card, Color color); //Jack cant be played on another Jack // consider Stack and Player

    /**
     *
     * Shuffel a Stack
     *
     * @param stack of cards
     *
     * @return shuffled Stack
     */
    Stack shuffleStack(Stack stack);

    /**
     *
     * Announce the winner of a Game
     *
     * @param player that won.
     */
    void announceWinner(Player player);

    /**
     *
     * @param color
     */
    void wishColor (Color color);

    /**
     * Skip the next player
     */
    void skipTurn();

    /**
     *
     * @return If MauMau is valid
     */
    boolean sayMauMau();

}
