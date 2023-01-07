package de.htw.berlin.configuration;

import de.htw.berlin.domain.Card;
import de.htw.berlin.domain.Color;
import de.htw.berlin.domain.Game;
import de.htw.berlin.domain.Value;
import de.htw.berlin.export.RulesService;
import org.springframework.stereotype.Component;

@Component
public class RulesServiceImpl implements RulesService {
    @Override
    public boolean canPlaceCard(Card placedCard, Card cardOnDeck, Color wishedColor) {
        if(placedCard.getColor() == wishedColor){
            return true;
        }
        if(placedCard.getValue() == cardOnDeck.getValue()){
            return true;
        }
        return false;
    }

    @Override
    public boolean mustDirectionChange(Card card) {
        return card.getValue() == Value.NINE;
    }

    @Override
    public boolean canWishColor(Card card) {
        return card.getValue() == Value.JACK;
    }

    @Override
    public boolean isTurnSkipped(Card card) {
        return card.getValue() == Value.EIGHT;
    }

    @Override
    public int mustDrawTwoCards(Card card, int initialNumberOfCards) {
        if(card.getValue()==Value.SEVEN){
            initialNumberOfCards = 2;
        }
        return initialNumberOfCards;
    }
}
