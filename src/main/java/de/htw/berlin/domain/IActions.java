package de.htw.berlin.domain;

import java.util.List;

/**
 * Temporary interface for all game actions
 */
public interface IActions {

    /**
     *
     * Draws a card from the drawStack
     * @param howManyToDraw how many cards to draw
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
     * Color that is wished
     *
     * @param color type of the card
     */
    void wishColor (Color color);

    /**
     * Skip the next player
     */
    void skipTurn();

    /**
     * player say MauMau
     *
     * @return If MauMau is valid
     */
    boolean sayMauMau();

}
