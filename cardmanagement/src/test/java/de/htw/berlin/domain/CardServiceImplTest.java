package de.htw.berlin.domain;
import de.htw.berlin.export.CardService;
import de.htw.berlin.impl.CardServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CardServiceImplTest {

    @InjectMocks
    private CardServiceImpl cardServiceImpl;

    @Mock
    private Card mockCard;

    @Mock
    private CardService cardService;

    @Mock
    private Stack mockStack;

    @Test
    public void testCreateCard() {
        when(mockCard.getValue()).thenReturn(Value.ACE);
        when(mockCard.getColor()).thenReturn(Color.HEART);

        Card card = cardServiceImpl.createCard(Value.ACE, Color.HEART);

        assertEquals(mockCard.getValue(), card.getValue());
        assertEquals(mockCard.getColor(), card.getColor());
    }

    @Test
    public void testCreateStack() {
        int expectedSize = Value.values().length * Color.values().length;

        Stack stack = cardServiceImpl.createStack();

        assertEquals(expectedSize, stack.cardList.size());
    }

    @Test
    public void testShuffleStack() {
        List<Card> deck = new ArrayList<>();
        for (int i = 0; i < 52; i++) {
            deck.add(new Card(Value.ACE, Color.HEART));
        }
        List<Card> shuffledDeck = new ArrayList<>(deck);
        Collections.shuffle(shuffledDeck);
        assertNotEquals(deck, shuffledDeck);
    }




}
