package de.htw.berlin.export;

import de.htw.berlin.domain.Card;
import de.htw.berlin.domain.Color;
import de.htw.berlin.domain.Value;

public interface CardService {
    //TODO: unclear where to manage Stack

    /**
     * Cards are complex objects that need to be created first
     * @param value enum value
     * @param color enum color (warning: color is actually type, e.g. spades, hearts)
     * @return the created card instance
     */
    Card createCard(Value value, Color color);
}
