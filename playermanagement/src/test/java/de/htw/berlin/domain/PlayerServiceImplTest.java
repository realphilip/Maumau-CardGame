package de.htw.berlin.domain;import de.htw.berlin.domain.Card;
import de.htw.berlin.impl.PlayerServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import de.htw.berlin.domain.Card;
import de.htw.berlin.domain.Player;
import de.htw.berlin.domain.Stack;
import de.htw.berlin.export.PlayerService;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PlayerServiceImplTest {
    @Mock
    private Stack hand;

    @Mock
    private Card card;

    @InjectMocks
    private PlayerServiceImpl playerServiceImpl;

    @Test
    public void testNewPlayer() {
        String name = "player1";
        Player expectedPlayer = new Player();
        expectedPlayer.setName(name);

        Player actualPlayer = playerServiceImpl.newPlayer(name);

        assertEquals(expectedPlayer, actualPlayer);
    }

    @Test
    public void testAddCardtoHand() {
        Player player = new Player();
        player.setHand(hand);

        List<Card> cardList = new ArrayList<>();
        when(hand.getCardList()).thenReturn(cardList);

        Player expectedPlayer = playerServiceImpl.addCardtoHand(card, player);

        assertEquals(expectedPlayer.getHand().getCardList().size(), 1);
    }

    @Test
    public void testRemoveCardfromHand() {
        Player player = new Player();
        player.setHand(hand);

        List<Card> cardList = new ArrayList<>();
        cardList.add(card);
        when(hand.getCardList()).thenReturn(cardList);

        Player expectedPlayer = playerServiceImpl.removeCardfromHand(card, player);

        assertEquals(expectedPlayer.getHand().getCardList().size(), 0);
    }
}
