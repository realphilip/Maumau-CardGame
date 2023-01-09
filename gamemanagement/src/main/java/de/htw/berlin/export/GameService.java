package de.htw.berlin.export;

import de.htw.berlin.domain.*;
import de.htw.berlin.domain.Color;

import java.awt.*;
import java.util.List;

public interface GameService {

    /**
     * Create a game
     * @param uniqueGameName User-defined game name, should be unique
     * @param playerList List of player objects participating
     * @param specialRules Are rules normal or special?
     * @return The created new game
     */
    Game createGame(String uniqueGameName, List<Player> playerList, boolean specialRules);
    /**
     *
     * Draws a card from the drawStack
     * This was refactored to remove int howManyToDraw because game should be persistent and pausable
     * @param game the current game object, to be modified
     * @return the modified game object
     */
    Game drawCard(Game game);

    /**
     * Play a card
     * @param game the current game object, to be modified
     * @param card The card is played
     * @param player The player of said card
     * @return the modified game object
     */
    Game playCard(Game game, Card card, Player player); //Jack cant be played on another Jack // consider Stack and Player

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
     * Check and Announce the winner of a Game
     *
     * @param player current player.
     * @return is game over?
     */
    boolean checkWinner(Player player);

    /**
     * 
     * Color that is wished
     * @param game the current game object, to be modified
     * @param color type of the card
     * @return the modified game object
     */
    Game wishColor (Game game, Color color);

    /**
     *
     * The game proceeds to the next player in the list
     * @param game the current game object, to be modified
     * @return the modified game object
     */
    Game nextPlayer (Game game);

    /**
     * Set the player to have said Mau
     * @param player the player that has his Mau-state reset
     * @param saidMau needs specification in case mau reversed
     */
    void setMauMau(Player player, boolean saidMau);

    /**
     * check if player said MauMau
     * @param game the current game object, to be modified
     * @return the modified game object, in case player forgot to say Mau and has to keep playing
     */
    Game sayMauMau(Game game);
    //TODO: find out how to deal with Ablagestapel
    //TODO: find out how to deal with different rules
}
