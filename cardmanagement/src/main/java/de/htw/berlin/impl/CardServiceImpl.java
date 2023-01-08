package de.htw.berlin.impl;

import de.htw.berlin.export.CardService;
import de.htw.berlin.domain.Card;
import de.htw.berlin.domain.Color;
import de.htw.berlin.domain.Stack;
import de.htw.berlin.domain.Value;
import org.springframework.stereotype.Component;

@Component
public class CardServiceImpl implements CardService {

    @Override
    public Card createCard(Value value, Color color) {
        Card c1 = new Card();
        c1.setColor(color);
        c1.setValue(value);
        return c1;
    }

    @Override
    public Stack createStack() {
        return new Stack();
    }

    @Override
    public Stack shuffleStack(Stack cards, boolean type) {
        if(type){
            cards.shuffleStack();
        }
        return cards;
    }
}
