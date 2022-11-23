package de.htw.berlin.export;

import de.htw.berlin.domain.Card;
import de.htw.berlin.domain.Player;

public interface PlayerService {
    //Added after feedback - no method to create player

    /**
     * Create a player
     * @param name Player name field
     * @return the newlycreated player
     */
    Player newPlayer (String name);

    /**
     *
     * @param card card object to be added
     * @param player player to whom card is added
     *
     */
    Player addCardtoHand(Card card, Player player);

    /**
     *
     * @param card card object to be removed
     * @param player player from whom card is removed
     *
     */
    Player removeCardfromHand(Card card, Player player);
}
