package de.htw.berlin.domain;
import de.htw.berlin.impl.NormalRulesServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import de.htw.berlin.domain.Card;
import de.htw.berlin.domain.Color;
import de.htw.berlin.domain.Value;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class NormalRulesServiceImplTest {

    @InjectMocks
    private NormalRulesServiceImpl normalRulesService;

    @Mock
    private Card card;

    @Mock
    private Card placedCard;

    @Test
    public void canPlaceCardShouldReturnTrueIfColorMatches() {
        when(card.getColor()).thenReturn(Color.HEART);
        when(placedCard.getColor()).thenReturn(Color.CLUB);
        when(placedCard.getValue()).thenReturn(Value.EIGHT);
        when(card.getValue()).thenReturn(Value.SEVEN);

        boolean result = normalRulesService.canPlaceCard(placedCard, card, Color.DIAMOND);
        assertTrue(result);
    }

    @Test
    public void canPlaceCardShouldReturnTrueIfValueMatches() {
        when(card.getColor()).thenReturn(Color.HEART);
        when(placedCard.getColor()).thenReturn(Color.DIAMOND);
        when(placedCard.getValue()).thenReturn(Value.EIGHT);
        when(card.getValue()).thenReturn(Value.EIGHT);

        boolean result = normalRulesService.canPlaceCard(placedCard, card, Color.DIAMOND);
        assertTrue(result);
    }

    @Test
    public void canPlaceCardShouldReturnFalseIfNeitherValueNorColorMatches() {
        when(card.getColor()).thenReturn(Color.HEART);
        when(placedCard.getColor()).thenReturn(Color.DIAMOND);
        when(placedCard.getValue()).thenReturn(Value.EIGHT);
        when(card.getValue()).thenReturn(Value.SEVEN);

        boolean result = normalRulesService.canPlaceCard(placedCard, card, Color.DIAMOND);
        assertFalse(result);
    }

    @Test
    public void mustDirectionChange() {
        boolean result = normalRulesService.mustDirectionChange(card);
        assertFalse(result);
    }

    @Test
    public void canWishColor() {
        boolean result = normalRulesService.canWishColor(card);
        assertFalse(result);
    }

    @Test
    public void isTurnSkipped() {
        boolean result = normalRulesService.isTurnSkipped(card);
        assertFalse(result);
    }

    @Test
    public void mustDrawTwoCards() {
        NormalRulesServiceImpl normalRulesService = new NormalRulesServiceImpl();
        Card card = mock(Card.class);
        int initialNumberOfCards = 0;

        int result = normalRulesService.mustDrawTwoCards(card, initialNumberOfCards);

        assertEquals(0, result);
    }
}