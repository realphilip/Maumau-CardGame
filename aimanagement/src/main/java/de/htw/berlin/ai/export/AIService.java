package de.htw.berlin.ai.export;

import de.htw.berlin.domain.Color;
import de.htw.berlin.domain.Player;

public interface AIService {

    /**
     *  Creates an AI Player and has him say hello.
     * @param index - the index id of the AI Player
     * @return - The new player's name.
     */
    String createAI(int index);

    /**
     * An AI Player sends chat messages.
     * @param name the name of the player to introduce himself
     * @return The message delivered by the AI Player.
     */
    String chatMessage (String name);

    /**
     * Generates a color that the AI Wishes in the special rule set.
     * @return - the wished color value.
     */
    Color whatColorToWish();

    /**
     * Checks whether an AI forgets to say MauMau or says it.
     * @param player - the AI Player
     * @return - true if player says mau.
     */
    boolean saysMauMauOrForgetsTo(Player player);
}
