package de.htw.berlin.domain;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import de.htw.berlin.impl.SpecialRulesServiceImpl;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import de.htw.berlin.domain.Card;
import de.htw.berlin.domain.Color;
import de.htw.berlin.domain.Value;
import de.htw.berlin.export.RulesService;

public class SpecialRulesServiceImplTest {

    private Logger logger;
    private RulesService rulesService;
    private Card placedCard;
    private Card cardOnDeck;

    @Before
    public void setup() {
        logger = mock(Logger.class);
        rulesService = new SpecialRulesServiceImpl();

        placedCard = mock(Card.class);
        cardOnDeck = mock(Card.class);
    }

    @Test
    public void testCanPlaceCard() {
        when(cardOnDeck.getColor()).thenReturn(Color.HEART);
        when(cardOnDeck.getValue()).thenReturn(Value.JACK);
        when(placedCard.getColor()).thenReturn(Color.HEART);
        when(placedCard.getValue()).thenReturn(Value.ACE);
        rulesService.canPlaceCard(placedCard, cardOnDeck, null);
        // test case for wished color not being null
        rulesService.canPlaceCard(placedCard, cardOnDeck, Color.HEART);
    }

    @Test
    public void testMustDirectionChange() {
        when(cardOnDeck.getValue()).thenReturn(Value.NINE);
        rulesService.mustDirectionChange(cardOnDeck);
    }

    @Test
    public void testCanWishColor() {
        when(cardOnDeck.getValue()).thenReturn(Value.JACK);
        rulesService.canWishColor(cardOnDeck);
    }

    @Test
    public void testIsTurnSkipped() {
        when(cardOnDeck.getValue()).thenReturn(Value.EIGHT);
        rulesService.isTurnSkipped(cardOnDeck);
    }

    @Test
    public void testMustDrawTwoCards() {
        when(cardOnDeck.getValue()).thenReturn(Value.SEVEN);
        rulesService.mustDrawTwoCards(cardOnDeck, 5);
    }
}
