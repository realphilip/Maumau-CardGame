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
    Game createGame(String uniqueGameName, List<String> playerList, boolean specialRules);
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
     *Shuffle a stack or dont
     *
     * @param game game before
     *@return the game with the shuffled stack or not
     */
    Game shuffleStack(Game game);

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
<<<<<<< HEAD
    //TODO: find out how to deal with Ablagestapel
=======

    /**
     * check if saying maumau is at all necessary.
     * @param player the player thats being checked
     * @return true if it is necessary
     */
    boolean isSayMauMauNecessary(Player player);

    /**
     * choose the rules for the game. true are the special rules. false are the normal (simple) rules.
     * @param specialRules
     * @return the implementation of the selected rules.
     */
    RulesService chooseRules(boolean specialRules);

    /**
     * Gives around Cards to all the players, generally at the start of the game.
     *
     * @param drawStack - the stack to draw from
     * @param playerList - all the players at the start of the game
     * @param amountOfCardsToGiveAround  - this is the number of iterations the for loop goes through
     * @return - the modified drawStack
     */
    Stack giveAroundCards(Stack drawStack, List<Player> playerList, int amountOfCardsToGiveAround);

    /**
     * This is a special method that giveAroundCards to one player, instead of a whole game.
     *
     * @param drawStack - the stack to draw from
     * @param player - the single player to give to
     * @param amountOfCardsToGiveAround  - this is the number of iterations the for loop goes through
     * @return - the modified drawStack
     */
    Stack giveCardsToOne(Stack drawStack, Player player, int amountOfCardsToGiveAround);

    /**
     * an assisting method to remove a card from a stack
     *
     * @param stack - the stack from which to remove
     * @param card - the card to remove
     * @return - the modified stack
     */
    Stack removeCardFromAStack(Stack stack, Card card);

    /**
     * This method is necessary in case a player chooses to play with a high amount of players.
     * This determines a fun configuration of the game so that there are enough cards in the drawStack and enough cards for the players.
     *
     * @param completeStack   - the initial complete card stack
     * @param players - A list of players
     * @return - the ideal, calculated number of cards a game should start with.
     */
    int cardsPerPlayer(Stack completeStack, List<Player> players);

    /**
     * This is the method that takes a card from a player and inserts it to the top of the playstack.
     *
     * @param playStack the playstack
     * @param player the player
     * @param card the card thats being played.
     * @return - the playstack again but modified, as with all the other methods.
     */
    Stack putDownCard(Stack playStack, Player player, Card card);


>>>>>>> 13cb96ad3582c6858f5bdbbf97507c24a6b64ff0
}
