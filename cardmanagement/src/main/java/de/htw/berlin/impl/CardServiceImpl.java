package de.htw.berlin.impl;

import de.htw.berlin.export.CardService;
import de.htw.berlin.domain.Card;
import de.htw.berlin.domain.Color;
import de.htw.berlin.domain.Stack;
import de.htw.berlin.domain.Value;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
public class CardServiceImpl implements CardService {

    @Override
    public Card createCard(Value value, Color color) {
        Card newCard = new Card(value, color);
        return newCard;
    }

    @Override
    public Stack createStack() {
        Stack newStack = new Stack();
        for (Value thisValue : Value.values()){
            for (Color thisColor : Color.values()){
                newStack.cardList.add(createCard(thisValue, thisColor));
            }
        }
        return newStack;
    }

    @Override
    public Stack shuffleStack(Stack cards, boolean isBeginning) {
        //find the size of cards for finding the top card
        int topCardIndex = cards.cardList.size() - 1;
        if(!isBeginning){
            Collections.shuffle(cards.cardList);
        } else if (isBeginning) {
            Card topCard = cards.cardList.get(topCardIndex);
            System.out.println(topCard.getColor() + " - " + topCard.getValue());
            cards.cardList.remove(topCardIndex);
            Collections.shuffle(cards.cardList);
            cards.cardList.add(topCard);
        }
        return cards;
    }
}
