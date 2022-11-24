package de.htw.berlin.export;

import de.htw.berlin.domain.Card;
import de.htw.berlin.domain.Color;

public interface RulesService {

    //there are two implementations: special and normal rules. with normal rules, only first method is relevant.

    /**
     * Most important rule method - can the card be placed
     * @param placedCard the card thats trying to be placed
     * @param cardOnDeck the card on top
     * @param wishedColor edge case - a wished color (not necessarily the color of the card on top)
     * @return
     */
    boolean canPlaceCard(Card placedCard, Card cardOnDeck, Color wishedColor);

    /**
     * Must the direction change?
     * @param card the card played
     * @return does the direction change?
     */
    boolean mustDirectionChange(Card card);

    /**
     * Can a color be wished?
     * @param card the card played
     * @return does the player get a chance to wish a color?
     */
    boolean canWishColor(Card card);

    /**
     * Is a player skipped
     * @param card the card played
     * @return is the player skipped? When true he is.
     */
    boolean isTurnSkipped(Card card);

    /**
     * Does the player need to draw cards?
     * @param card played card
     * @param initialNumberOfCards edge case - initial number of cards in case drawing is played along
     * @return
     */
    int mustDrawTwoCards(Card card, int initialNumberOfCards);

}
