package de.htw.berlin.impl;

import de.htw.berlin.domain.Card;
import de.htw.berlin.domain.Color;
import de.htw.berlin.domain.Value;
import de.htw.berlin.export.RulesService;
import org.apache.logging.log4j.Logger;

public class SpecialRulesServiceImpl implements RulesService {
    Logger logger;
    @Override
    public boolean canPlaceCard(Card placedCard, Card cardOnDeck, Color wishedColor) {
        //compare on deck and placed
        Color colorOnDeck = cardOnDeck.getColor();
        Value valueOnDeck = cardOnDeck.getValue();

        Color colorPlaced = placedCard.getColor();
        Value valuePlaced = placedCard.getValue();

        //if jack, then if not wished then color has to equal placed color, if wished then has to equal wished.
        if (valueOnDeck.equals(Value.JACK)){
            if (wishedColor == null){
                return colorOnDeck.equals(colorPlaced);
            } else {
                logger.debug("matches wished color");
                return wishedColor.equals(colorPlaced);
            } //else has to equal color on deck or value on deck.
        } else if (colorPlaced.equals(colorOnDeck)){
            return true;
        } else if (valuePlaced.equals(valueOnDeck)){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean mustDirectionChange(Card card) {
        logger.debug("changing direction?");
        Value value = card.getValue();
        if (value.equals(Value.NINE)) return true;
        else return false;
    }

    @Override
    public boolean canWishColor(Card card) {
        logger.debug("is color wished?");
        Value value = card.getValue();
        if (value.equals(Value.JACK)) return true;
        else return false;
    }

    @Override
    public boolean isTurnSkipped(Card card) {
        logger.debug("is turn skipped?");
        Value value = card.getValue();
        if (value.equals(Value.EIGHT)) return true;
        else return false;
    }

    @Override
    public int mustDrawTwoCards(Card card, int initialNumberOfCards) {
        Value value = card.getValue();
        if (value.equals(Value.SEVEN)){
            int numberofCards = initialNumberOfCards + 2;
            logger.debug("two more cards");
            return numberofCards;
        }
        return initialNumberOfCards;
    }
}
