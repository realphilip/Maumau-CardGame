package de.htw.berlin.domain;

import de.htw.berlin.domain.Card;
import de.htw.berlin.domain.Player;
import de.htw.berlin.domain.Stack;
import de.htw.berlin.export.PlayerService;
import de.htw.berlin.impl.PlayerServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class PlayerServiceImplTest {
    @InjectMocks
    private PlayerServiceImpl playerServiceImpl;

    @Mock
    private Card card;

    @Test
    public void testNewPlayer() {
        Player player = playerServiceImpl.newPlayer("John");
        Assert.assertEquals("John", player.getName());
    }

    @Test
    public void testAddCardtoHand() {
        Player player = playerServiceImpl.newPlayer("John");
        Stack hand = new Stack();
        hand.cardList = new ArrayList<>();
        player.setHand(hand);
        player = playerServiceImpl.addCardtoHand(card, player);
        Assert.assertEquals(1, player.getHand().cardList.size());
    }

    @Test
    public void testRemoveCardfromHand() {
        Player player = playerServiceImpl.newPlayer("John");
        Stack hand = new Stack();
        hand.cardList = new ArrayList<>();
        hand.cardList.add(card);
        player.setHand(hand);
        player = playerServiceImpl.removeCardfromHand(card, player);
        Assert.assertEquals(0, player.getHand().cardList.size());
    }
}
