package de.htw.berlin.impl;

import de.htw.berlin.domain.Card;
import de.htw.berlin.domain.Color;
import de.htw.berlin.domain.Value;
import de.htw.berlin.export.RulesService;

public class NormalRulesServiceImpl implements RulesService {

    @Override
    public boolean canPlaceCard(Card placedCard, Card cardOnDeck, Color wishedColor) {
        //compare on deck and placed
        Color colorOnDeck = cardOnDeck.getColor();
        Value valueOnDeck = cardOnDeck.getValue();

        Color colorPlaced = placedCard.getColor();
        Value valuePlaced = placedCard.getValue();

        //either comparison make true, else false.
        if (colorPlaced.equals(colorOnDeck)){
            return true;
        } else if (valuePlaced.equals(valueOnDeck)){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean mustDirectionChange(Card card) {
        return false;
    }

    @Override
    public boolean canWishColor(Card card) {
        return false;
    }

    @Override
    public boolean isTurnSkipped(Card card) {
        return false;
    }

    @Override
    public int mustDrawTwoCards(Card card, int initialNumberOfCards) {
        return 0;
    }
}
