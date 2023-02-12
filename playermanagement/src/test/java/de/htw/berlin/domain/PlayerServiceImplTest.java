package de.htw.berlin.domain;import de.htw.berlin.domain.Card;
import de.htw.berlin.domain.Player;
import de.htw.berlin.impl.PlayerServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Stack;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PlayerServiceImplTest {

    private PlayerServiceImpl playerService;
    private Card mockCard;
    private Player mockPlayer;

    @Before
    public void setUp() {
        playerService = new PlayerServiceImpl();
        mockCard = Mockito.mock(Card.class);
        mockPlayer = Mockito.mock(Player.class);
    }

    @Test
    public void testNewPlayer() {
        String playerName = "John Doe";
        Player player = playerService.newPlayer(playerName);
        assertEquals(playerName, player.getName());
    }

    @Test
    public void testAddCardtoHand() {
        Stack<Card> hand = new Stack<>();
        when(mockPlayer.getHand()).thenReturn(hand);

        Player player = playerService.addCardtoHand(mockCard, mockPlayer);
        assertEquals(1, player.getHand().size());
        assertEquals(mockCard, player.getHand().peek());
    }

    @Test
    public void testRemoveCardfromHand() {
        Stack<Card> hand = new Stack<>();
        hand.push(mockCard);
        when(mockPlayer.getHand()).thenReturn(hand);

        Player player = playerService.removeCardfromHand(mockCard, mockPlayer);
        assertEquals(0, player.getHand().size());
    }
}
